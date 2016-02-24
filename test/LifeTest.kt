import org.junit.Test
import org.junit.Assert.*

class LifeTest {
    @Test fun thatInitialLivingCellsAreAliveBeforeEvolution() {
        val life = Life(setOf(Cell(1, 0), Cell(0, 1)))

        assertTrue(life.isCellAlive(Cell(1, 0)))
        assertTrue(life.isCellAlive(Cell(0, 1)))
    }

    @Test fun thatInitialDeadCellsAreDeadBeforeEvolution() {
        val life = Life(setOf(Cell(1, 0), Cell(0, 1)))

        assertFalse(life.isCellAlive(Cell(0, 0)))
        assertFalse(life.isCellAlive(Cell(1, 1)))
    }

    @Test fun thatLiveCellWithFewerThanTwoNeighboursShouldDie() {
        var life = Life(setOf(Cell(1, 0), Cell(0, 1)))

        life = life.evolve()

        assertFalse(life.isCellAlive(Cell(1, 0)))
        assertFalse(life.isCellAlive(Cell(0, 1)))
    }

    @Test fun thatLiveCellWithTwoLiveNeighboursShouldSurvive() {
        var life = Life(setOf(Cell(1, 0), Cell(0, 1), Cell(2, 1)))

        life = life.evolve()

        assertTrue(life.isCellAlive(Cell(1, 0)))
    }

    @Test fun thatLiveCellWithThreeLiveNeighboursShouldSurvive() {
        var life = Life(setOf(Cell(1, 0), Cell(0, 1), Cell(2, 1), Cell(2, 0)))

        life = life.evolve()

        assertTrue(life.isCellAlive(Cell(1, 0)))
    }
}
