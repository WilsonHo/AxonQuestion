package com.example

/**
  * Created by wilson on 8/29/17.
  */

object TriangleType {
  val ERROR = 4
  val EQUILATERAL = 3
  val ISOSCELES = 2
  val SCALENE = 1


}

case class Triangle(private val sideA: Double,
                    private val sideB: Double,
                    private val sideC: Double) {

  def checkTriangle: Boolean = {
    if (sideA <= 0 || sideB <= 0 || sideC <= 0) false
    else if (sideA + sideB > sideC &&
      sideA + sideC > sideB &&
      sideB + sideC > sideA) true
    else false
  }

  def checkIsosceles: Boolean = {
    sideA == sideB || sideB == sideC || sideC == sideA
  }

  def checkEquilateral: Boolean = {
    sideA == sideB && sideB == sideC
  }

  def determineTriangleType: Int = {
    if (checkTriangle)
      if (checkIsosceles)
        if (checkEquilateral) TriangleType.EQUILATERAL
        else TriangleType.ISOSCELES
      else TriangleType.SCALENE
    else TriangleType.ERROR
  }
}
