import java.util.*

class Life(val initialLivingCells: Set<Cell>) {
    fun isCellAlive(cell: Cell): Boolean {
        return initialLivingCells.contains(cell)
    }

    fun evolve(): Life {
        return Life(initialLivingCells.subtract(cellsThatShouldDie()))
    }

    private fun cellsThatShouldDie(): Iterable<Cell> {
        return initialLivingCells.filter {
            livingNeighboursOf(it).count() < 2
        }
    }

    private fun livingNeighboursOf(cell: Cell): Iterable<Cell> {
        return neighboursOf(cell).filter { isCellAlive(it) }
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
