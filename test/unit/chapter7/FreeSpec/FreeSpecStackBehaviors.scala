package unit.chapter7.FreeSpec

import chapter7.Stack
import org.scalatest.freespec.AnyFreeSpec

/**
  * Created by user on 07/08/17.
  */
trait FreeSpecStackBehaviors { this: AnyFreeSpec =>

  def nonEmptyStack(newStack: => Stack[Int], lastItemAdded: Int): Unit = {

    "be non-empty" in {
      assert(!newStack.empty)
    }

    "return the top item on peek" in {
      assert(newStack.peek === lastItemAdded)
    }

    "not remove the top item on peek" in {
      val stack = newStack
      val size = stack.size
      assert(stack.peek === lastItemAdded)
      assert(stack.size === size)
    }

    "remove the top item on pop" in {
      val stack = newStack
      val size = stack.size
      assert(stack.pop === lastItemAdded)
      assert(stack.size === size - 1)
    }
  }

  def nonFullStack(newStack: => Stack[Int]): Unit = {

    "not be full" in {
      assert(!newStack.full)
    }

    "add to the top on push" in {
      val stack = newStack
      val size = stack.size
      stack.push(7)
      assert(stack.size === size + 1)
      assert(stack.peek === 7)
    }
  }
}
