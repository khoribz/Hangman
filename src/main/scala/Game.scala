import State._
import StepResult._
import Input._

import RandomWord.getRandomWord

import scala.annotation.tailrec

object Game {
  def playGame: Unit = {
    val possibleFailures = 10
    println("Welcome, it's Hangman game!")
    val word = getRandomWord
    val state = State(word, possibleFailures)

    gameStep(state)
  }

  @tailrec
  def gameStep(state: State): Unit = {
    printState(state)
    val playerSymbol: Char = getLetter
    val newState: State = state.copy(guesses = state.guesses + playerSymbol)
    val result: StepResult = newGuessResult(state, newState, playerSymbol)

    result match {
      case Unchanged => println("This letter has been already typed"); gameStep(newState)
      case Won => println("You won!"); printState(newState)
      case Lost => println(s"You lost! The correct word was ${state.word}")
      case Hit => println("Hit!"); gameStep(newState)
      case Missed => println(s"Missed! mistake ${newState.failures} out of ${newState.possibleFailures}");
        gameStep(newState)
    }
  }
}
