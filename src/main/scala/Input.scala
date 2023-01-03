object Input {
  def getLetter: Char = {
    println("Please, guess a letter: ")
    val letter = scala.io.StdIn.readLine()
    val letterPattern = "[a-zA-z]".r.toString()
    letter.matches(letterPattern) match {
      case true => letter.toLowerCase().head
      case false => println("Mistake, incorrect symbol"); getLetter
    }
  }
}
