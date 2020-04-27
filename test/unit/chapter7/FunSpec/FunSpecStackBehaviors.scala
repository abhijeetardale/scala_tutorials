package unit.chapter7.FunSpec

import chapter7.Stack
import org.scalatest.funspec.AnyFunSpec
/**
  * Created by user on 07/08/17.
  */
trait FunSpecStackBehaviors { this: AnyFunSpec =>

  def nonEmptyStack(newStack: => Stack[Int], lastItemAdded: Int): Unit = {

    it("should be non-empty") {
      assert(!newStack.empty)
    }

    it("should return the top item on peek") {
      assert(newStack.peek === lastItemAdded)
    }

    it("should not remove the top item on peek") {
      val stack = newStack
      val size = stack.size
      assert(stack.peek === lastItemAdded)
      assert(stack.size === size)
    }

    it("should remove the top item on pop") {
      val stack = newStack
      val size = stack.size
      assert(stack.pop === lastItemAdded)
      assert(stack.size === size - 1)
    }
  }

  def nonFullStack(newStack: => Stack[Int]): Unit = {

    it("should not be full") {
      assert(!newStack.full)
    }

    it("should add to the top on push") {
      val stack = newStack
      val size = stack.size
      stack.push(7)
      assert(stack.size === size + 1)
      assert(stack.peek === 7)
    }
  }
}
