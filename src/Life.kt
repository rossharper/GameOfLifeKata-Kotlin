
class Life(val livingCells: Set<Cell>) {
    fun isCellAlive(cell: Cell): Boolean = livingCells.contains(cell)

    fun evolve(): Life = Life(livingCells.subtract(cellsThatShouldDie()).union(cellsThatShouldBeBorn()))

    private fun cellsThatShouldBeBorn(): Iterable<Cell>
            = livingCells.flatMap { deadNeighboursOf(it) }.filter { livingNeighboursOf(it).count() == 3 }.toSet()

    private fun cellsThatShouldDie(): Iterable<Cell>
            = livingCells.filter { livingNeighboursOf(it).count() !in 2..3 }

    private fun livingNeighboursOf(cell: Cell): Iterable<Cell>
            = neighboursOf(cell).filter { isCellAlive(it) }

    private fun deadNeighboursOf(cell: Cell): Iterable<Cell> = neighboursOf(cell).filter { !isCellAlive(it) }

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
