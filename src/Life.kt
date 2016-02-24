class Life(val initialLivingCells: Set<Cell>) {
    fun isCellAlive(cell: Cell): Boolean {
        return initialLivingCells.contains(cell)
    }
}
