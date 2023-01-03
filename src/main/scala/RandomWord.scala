import scala.io.Source
import scala.util.{Random, Success, Try, Using}

object RandomWord {

  lazy val words: Try[List[String]] = Using(Source.fromFile("resources/words.txt")) { reader =>
    reader.getLines.toList
  }
  val randomValue = new Random()

  def getRandomWord: String = words match {
    case Success(words) => words(randomValue.nextInt(words.size))
    case _ => ""
  }
}
