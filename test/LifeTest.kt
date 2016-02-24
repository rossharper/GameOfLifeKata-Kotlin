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

    @Test fun thatLiveCellWithMoreThanThreeLiveNeighboursShouldDie() {
        var life = Life(setOf(Cell(1, 0), Cell(0, 1), Cell(2, 1), Cell(2, 0), Cell(1, 1)))

        life = life.evolve()

        assertFalse(life.isCellAlive(Cell(1, 0)))
    }

    @Test fun thatNewCellIsBornWhenThreeLiveNeighbours() {
        var life = Life(setOf(Cell(0, 0), Cell(1, 0), Cell(2, 0)))

        life = life.evolve()

        assertTrue(life.isCellAlive(Cell(1, 1)))
    }


    @Test fun thatNoLifeEvolvedResultsInNoLife() {
        var life = Life(setOf())

        life = life.evolve()

        for (x in 0..50) {
            for(y in 0..50) {
                assertFalse(life.isCellAlive(Cell(x, y)))
            }
        }
    }

    @Test fun testBlinkerOscillator() {
        val verticalBlinker =   setOf(Cell(1, 0), Cell(1, 1), Cell(1, 2))
        val horizontalBlinker = setOf(Cell(0, 1), Cell(1, 1), Cell(2, 1))

        var life = Life(horizontalBlinker)

        life = life.evolve()

        assertTrue(life.initialLivingCells == verticalBlinker)

        life = life.evolve()

        assertTrue(life.initialLivingCells == horizontalBlinker)
    }
}
