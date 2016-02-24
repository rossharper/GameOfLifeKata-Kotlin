import org.junit.Test
import org.junit.Assert.*

class LifeTest {
    @Test fun thatInitialLivingCellsAreAlive() {
        val life = Life(setOf(Cell(1, 0), Cell(0, 1)))

        assertTrue(life.isCellAlive(Cell(1, 0)))
        assertTrue(life.isCellAlive(Cell(0, 1)))
    }

    @Test fun thatInitialDeadCellsAreDead() {
        val life = Life(setOf(Cell(1, 0), Cell(0, 1)))

        assertFalse(life.isCellAlive(Cell(0, 0)))
        assertFalse(life.isCellAlive(Cell(1, 1)))
    }
}
