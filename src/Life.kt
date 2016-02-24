
class Life(val livingCells: Set<Cell>) {
    fun isCellAlive(cell: Cell): Boolean {
        return livingCells.contains(cell)
    }

    fun evolve(): Life {
        return Life(livingCells.subtract(cellsThatShouldDie()).union(cellsThatShouldBeBorn()))
    }

    private fun cellsThatShouldBeBorn(): Iterable<Cell> {
        return livingCells.flatMap { deadNeighboursOf(it) }.filter { livingNeighboursOf(it).count() == 3 }.toSet()
    }

    private fun cellsThatShouldDie(): Iterable<Cell> {
        return livingCells.filter {
            livingNeighboursOf(it).count() !in 2..3
        }
    }

    private fun livingNeighboursOf(cell: Cell): Iterable<Cell> {
        return neighboursOf(cell).filter { isCellAlive(it) }
    }

    private fun deadNeighboursOf(cell: Cell): Iterable<Cell> {
        return neighboursOf(cell).filter { !isCellAlive(it) }
    }

    private fun neighboursOf(cell: Cell): Iterable<Cell> {
        var neighbours : MutableSet<Cell> = hashSetOf()
        for(x in -1..1) {
            for(y in -1..1) {
                if(x != 0 || y != 0) {
                    neighbours.add(Cell(cell.x + x, cell.y + y))
                }
            }
        }
        return neighbours
    }
}
