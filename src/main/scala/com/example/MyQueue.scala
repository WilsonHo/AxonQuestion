package com.example

/**
  * Created by wilson on 8/29/17.
  */
case class MyQueue() {
  private var size: Int = _
  private var data: Array[Int] = _
  private var index = 0

  def initialize(size: Int): Unit = {
    this.size = size
    data = new Array[Int](size)
  }

  def enqueue(value: Int): Unit =
    if (isFull) throw new Exception("Queue is full")
    else {
      data(index) = value
      index += 1
    }

  def dequeue: Int = {
    if (isEmpty) throw new Exception("Queue is empty")
    else {
      val value = data(0)
      for (i <- 0 until index - 1) {
        data.update(i, data(i + 1))
      }
      index -= 1
      data.view.drop(index)
      value
    }
  }

  def isEmpty: Boolean = index == 0

  def isFull: Boolean = index == size
}

object demo {
  def main(args: Array[String]): Unit = {
    val queue: MyQueue = MyQueue()
    queue.initialize(2)
    queue.enqueue(1)
    queue.enqueue(2)
    queue.dequeue
    queue.dequeue
  }
}