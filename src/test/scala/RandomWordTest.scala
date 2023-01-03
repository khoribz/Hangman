import org.scalatest.funsuite.AnyFunSuite

class RandomWordTest extends AnyFunSuite {
  test("check if word is found") {
    assert(!RandomWord.getRandomWord.isEmpty)
  }
}
