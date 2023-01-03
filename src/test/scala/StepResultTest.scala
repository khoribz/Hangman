import org.scalatest.funsuite.AnyFunSuite
import StepResult._

class StepResultTest extends AnyFunSuite {
  val possibleFailures = 5

  test("In newGuessResult unchanged state is checked") {
    val word = RandomWord.getRandomWord
    val guesses = Set('a', 'b')
    val oldState = State(word, possibleFailures, guesses)
    val newState = State(word, possibleFailures, guesses)
    assert(StepResult.Unchanged == newGuessResult(oldState, newState, 'a'))
  }

  test ("In newGuessResult newState means a victory") {
    val word = "car"
    val guesses = Set('a', 'b', 'c')
    val guess = 'r'
    val oldState = State(word, possibleFailures, guesses)
    val newState = State(word, possibleFailures, guesses + guess)
    assert(StepResult.Won == newGuessResult(oldState, newState, guess))
  }

  test ("In newGuessResult newState means a defeat") {
    val word = "car"
    val guesses = Set('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h')
    val guess = 'w'
    val oldState = State(word, possibleFailures, guesses)
    val newState = State(word, possibleFailures, guesses + guess)
    assert(StepResult.Lost == newGuessResult(oldState, newState, guess))
  }

  test ("In newGuessResult in newState it's a hit") {
    val word = "car"
    val guesses = Set('a', 'b', 'd', 'e')
    val guess = 'r'
    val oldState = State(word, possibleFailures, guesses)
    val newState = State(word, possibleFailures, guesses + guess)
    assert(StepResult.Hit == newGuessResult(oldState, newState, guess))
  }

  test ("In newGuessResult in newState it's a miss") {
    val word = "car"
    val guesses = Set('a', 'b', 'd', 'e')
    val guess = 'q'
    val oldState = State(word, possibleFailures, guesses)
    val newState = State(word, possibleFailures, guesses + guess)
    assert(StepResult.Missed == newGuessResult(oldState, newState, guess))
  }
}
