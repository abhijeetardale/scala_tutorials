package unit.chapter7.FunSuite

import chapter7.Stack
import org.scalatest.funsuite.AnyFunSuite
/**
  * Created by user on 07/08/17.
  */
trait FunSuiteStackBehaviors  { this: AnyFunSuite =>

  def nonEmptyStack(createNonEmptyStack: => Stack[Int], lastItemAdded: Int): Unit = {

    test("empty is invoked on this non-empty stack: " + createNonEmptyStack.toString) {
      val stack = createNonEmptyStack
      assert(!stack.empty)
    }

    test("peek is invoked on this non-empty stack: " + createNonEmptyStack.toString) {
      val stack = createNonEmptyStack
      val size = stack.size
      assert(stack.peek === lastItemAdded)
      assert(stack.size === size)
    }

    test("pop is invoked on this non-empty stack: " + createNonEmptyStack.toString) {
      val stack = createNonEmptyStack
      val size = stack.size
      assert(stack.pop === lastItemAdded)
      assert(stack.size === size - 1)
    }
  }

  def nonFullStack(createNonFullStack: => Stack[Int]): Unit = {

    test("full is invoked on this non-full stack: " + createNonFullStack.toString) {
      val stack = createNonFullStack
      assert(!stack.full)
    }

    test("push is invoked on this non-full stack: " + createNonFullStack.toString) {
      val stack = createNonFullStack
      val size = stack.size
      stack.push(7)
      assert(stack.size === size + 1)
      assert(stack.peek === 7)
    }
  }
}
