import com.example.{MyQueue, Triangle}
import org.scalatest._

/**
  * Created by wilson on 8/29/17.
  */
class MyQueueSpec extends FlatSpec with Matchers {
  "A Queue" should "pop values in first-in-first-out order" in {
    val queue: MyQueue = MyQueue()
    queue.initialize(2)
    queue.enqueue(1)
    queue.enqueue(2)
    queue.dequeue should be (1)
    queue.dequeue should be (2)
  }

  it should "throw Exception if an empty queue is dequeued" in {
    val queue: MyQueue = MyQueue()
    queue.initialize(2)

    a [Exception] should be thrownBy {
      queue.dequeue
    }
  }

  it should "throw Exception if an full queue is enqueued" in {
    val queue: MyQueue = MyQueue()
    queue.initialize(2)
    queue.enqueue(1)
    queue.enqueue(2)

    a [Exception] should be thrownBy {
      queue.enqueue(3)
    }
  }
}
