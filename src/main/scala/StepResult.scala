sealed trait StepResult

object StepResult {
  case object Hit extends StepResult
  case object Lost extends StepResult
  case object Missed extends StepResult
  case object Unchanged extends StepResult
  case object Won extends StepResult

  def newGuessResult(oldState: State, newState: State, guess: Char): StepResult = {
    if (oldState.guesses.contains(guess)) StepResult.Unchanged
    else if (newState.playerWon) StepResult.Won
    else if (newState.playerLost) StepResult.Lost
    else if (oldState.word.contains(guess)) StepResult.Hit
    else StepResult.Missed
  }
}