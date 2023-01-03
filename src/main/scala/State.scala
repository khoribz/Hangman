object State {
  def printState(state: State): String = {
    val word = state.word.toList.map(letter =>
      if (state.guesses.contains(letter)) s" $letter " else " * ").mkString("")

    val guesses = (state.isInitial || state.playerLost || state.playerWon) match {
      case true => ""
      case false => "Your guesses: " + state.guesses.toList.sorted.mkString(", ")
    }
    println("The word: " + word + "\n" + guesses)
    "The word: " + word + "\n" + guesses
  }
}

case class State(word: String, possibleFailures: Int, guesses: Set[Char] = Set.empty[Char]) {
  def failures: Int = (guesses -- word.toSet).size
  def playerLost: Boolean = failures > possibleFailures
  def playerWon: Boolean = (word.toSet -- guesses).isEmpty
  def isInitial: Boolean = guesses.isEmpty
}
