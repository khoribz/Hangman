import org.scalatest.funsuite.AnyFunSuite

class StateTest extends AnyFunSuite {
  val possibleFailures = 5

  test("State class function failures is checked") {
    val word = "string"
    val guesses = Set('a', 'b', 'c')
    val state = State(word, possibleFailures, guesses)
    assert(state.failures == 3)
  }
  test("State class function playerLost is checked") {
    val word = "string"
    val guesses = Set('a', 'b', 'c', 'd', 'e', 'f')
    val state = State(word, possibleFailures, guesses)
    assert(state.playerLost)
  }
  test("State class function playerWon is checked") {
    val word = "coffee"
    val guesses = Set('a', 'b', 'c', 'd', 'e', 'f', 'o')
    val state = State(word, possibleFailures, guesses)
    assert(state.playerWon)
  }
  test("State class function isInitial is checked") {
    val word = "coffee"
    val state = State(word, possibleFailures)
    assert(state.isInitial)
  }
  test("State object printState function is checked: isInitial state") {
    val word = "car"
    val wordMask = " *  *  * "
    val state = State(word, possibleFailures)
    assert(State.printState(state) == s"The word: ${wordMask}\n")
  }
  test("State object printState function is checked: playerLost state") {
    val word = "car"
    val wordMask = " *  a  * "
    val guesses = Set('a', 'b', 'w', 'd', 'e', 'f', 'o')
    val state = State(word, possibleFailures, guesses)
    assert(State.printState(state) == s"The word: ${wordMask}\n")
  }
  test("State object printState function is checked: playerWon state") {
    val word = "car"
    val wordMask = " c  a  r "
    val guesses = Set('a', 'b', 'w', 'd', 'e', 'c', 'r')
    val state = State(word, possibleFailures, guesses)
    assert(State.printState(state) == s"The word: ${wordMask}\n")
  }
  test("State object printState function is checked: Hit state") {
    val word = "car"
    val wordMask = " c  a  * "
    val guesses = Set('a', 'b', 'w', 'd', 'e', 'c')
    val state = State(word, possibleFailures, guesses)
    assert(State.printState(state) ==
      s"The word: ${wordMask}\nYour guesses: ${guesses.toList.sorted.mkString(", ")}")
  }
  test("State object printState function is checked: Miss state") {
    val word = "car"
    val wordMask = " *  a  * "
    val guesses = Set('a', 'b', 'w', 'd', 'e', 'q')
    val state = State(word, possibleFailures, guesses)
    assert(State.printState(state) ==
      s"The word: ${wordMask}\nYour guesses: ${guesses.toList.sorted.mkString(", ")}")
  }
}
