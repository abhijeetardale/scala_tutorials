package unit.chapter8.Spec

import org.scalatest.refspec.RefSpec
import unit.chapter8.StackTestHelper

class StackExampleSpec extends RefSpec  with StackTestHelper {

  object `A Stack`   {

    object `calling size` {

      def `should return 0 if empty`: Unit = {
        assert(emptyStack.size == 0)
      }
      def `should return 1 if stack with one item`: Unit = {
        assert(stackWithOneItem.size == 1)
      }
      def `should return 9 if stack is with one item less than its capacity`: Unit = {
        assert(stackWithOneItemLessThanCapacity.size == 9)
      }
      def `should return 10 if stack is full`: Unit = {
        assert(fullStack.size == 10)
      }
    }

    object `calling empty` {

      def `should return true if empty`: Unit = {
        assert(emptyStack.empty)
      }
      def `should return false if contains 1 elemen`: Unit = {
        assert(stackWithOneItem.empty==false)
      }
      def `should return false if stack is with one item less than its capacity`: Unit = {
        assert(stackWithOneItemLessThanCapacity.empty==false)
      }
      def `should return false if stack is full`: Unit = {
        assert(fullStack.empty==false)
      }
    }

    object `calling peek` {

      def `should complain on peek if empty`: Unit = {
        intercept[IllegalStateException] {
          emptyStack.peek
        }
      }
      def `return the top item on peek but do not remove the top item on peek if contains 1 element`: Unit = {
        val stack = stackWithOneItem
        val size = stackWithOneItem.size
        assert(stack.peek === lastValuePushed)
        assert(stack.size === size)
      }
      def `return the top item on peek but do not remove the top item on peek if stack is with one item less than its capacity`: Unit = {
        val stack = stackWithOneItemLessThanCapacity
        val size = stackWithOneItemLessThanCapacity.size
        assert(stack.peek === lastValuePushed)
        assert(stack.size === size)
      }
      def `return the top item on peek but do not remove the top item on peek if stack is full`: Unit = {
        val stack = fullStack
        val size = fullStack.size
        assert(stack.peek === lastValuePushed)
        assert(stack.size === size)
      }
    }

    object `calling pop` {

      def `should complain on pop if empty`: Unit = {
        intercept[IllegalStateException] {
          emptyStack.pop
        }
      }
      def `should remove the top item on pop and stack will be empty if contains 1 element`: Unit = {
        val stack = stackWithOneItem
        val size = stackWithOneItem.size
        assert(stack.pop === lastValuePushed)
        assert(stack.size === size - 1)
        assert(stack.empty)
      }
      def `should remove the top item on pop and stack size will be reduded by 1 if stack is with one item less than its capacity`: Unit = {
        val stack = stackWithOneItemLessThanCapacity
        val size = stackWithOneItemLessThanCapacity.size
        assert(stack.pop === lastValuePushed)
        assert(stack.size === size - 1)
        assert(stack.empty==false)
      }
      def `should remove the top item on pop and stack size will be reduded by 1 if stack is full`: Unit = {
        val stack = fullStack
        val size = fullStack.size
        assert(stack.pop === lastValuePushed)
        assert(stack.size === size - 1)
        assert(stack.empty==false)
      }
    }

    object `calling push` {

      def `should add to the top on push if empty`: Unit = {
        val stack = emptyStack
        val size = stack.size
        stack.push(7)
        assert(stack.size === size + 1)
        assert(stack.peek === 7)
      }

      def `should add to the top on push and stack will not be empty if contains 1 element`: Unit = {
        val stack = stackWithOneItem
        val size = stack.size
        stack.push(7)
        assert(stack.size === size + 1)
        assert(stack.peek === 7)
      }
      def `should add to the top on push and stack size will be full if stack is with one item less than its capacity`: Unit = {
        val stack = stackWithOneItemLessThanCapacity
        val size = stack.size
        stack.push(7)
        assert(stack.size === size + 1)
        assert(stack.peek === 7)
        assert(stack.full)
      }

      def `should complain on a push if stack is full`: Unit = {
        intercept[IllegalStateException] {
          fullStack.push(10)
        }
      }
    }

    object `calling full` {

      def `should return false if stack is empty`: Unit = {
        val stack = emptyStack
        assert(stack.full==false)
      }

      def `should add to the top on push and stack will not be empty if contains 1 element`: Unit = {
        val stack = stackWithOneItem
        assert(stack.full==false)
      }
      def `should add to the top on push and stack size will be full if stack is with one item less than its capacity`: Unit = {
        val stack = stackWithOneItemLessThanCapacity
        assert(stack.full==false)
      }

      def `should return true if stack is full`: Unit = {
        val stack = fullStack
        assert(stack.full)
      }
    }

  }

}