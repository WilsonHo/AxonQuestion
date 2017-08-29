import com.example.{Triangle, TriangleType}
import org.scalatest._

class TriangleSpec extends FlatSpec with Matchers {
  "A triangle" should "have sum 2 sides greater then one side" in {
    Triangle(4, 7, 6).checkTriangle should ===(true)
  }

  "A Isosceles triangle" should "have 2 sides equal" in {
    Triangle(4, 4, 6).checkTriangle should ===(true)
    Triangle(6, 4, 4).checkTriangle should ===(true)
    Triangle(4, 6, 4).checkTriangle should ===(true)
  }

  "A Equilateral triangle" should "have 3 sides equal" in {
    Triangle(4, 4, 4).checkTriangle should ===(true)
  }

  "A error triangle" should "have a one of these problems" in {
    Triangle(0, 3, 4).checkTriangle should ===(false)
    Triangle(2, -1, 4).checkTriangle should ===(false)
    Triangle(1, 2, 6).checkTriangle should ===(false)
    Triangle(3, 3, 6).checkTriangle should ===(false)
    Triangle(3, 2, 6).checkTriangle should ===(false)
    Triangle(6, 10, 3).checkTriangle should ===(false)
    Triangle(13, 10, 2).checkTriangle should ===(false)
  }

  "determineTriangleType method" should "return type of triangle" in {
    Triangle(4, 7, 6).determineTriangleType should be(TriangleType.SCALENE)
    Triangle(4, 6, 4).determineTriangleType should be(TriangleType.ISOSCELES)
    Triangle(4, 4, 4).determineTriangleType should be(TriangleType.EQUILATERAL)
    Triangle(3, 3, 6).determineTriangleType should be(TriangleType.ERROR)
  }
}
