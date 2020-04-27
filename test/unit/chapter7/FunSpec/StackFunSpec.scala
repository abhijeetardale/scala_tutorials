package unit.chapter7.FunSpec

import org.scalatest.funspec.AnyFunSpec
import unit.chapter7.StackTestHelper
/**
  * Created by user on 07/08/17.
  */
class StackFunSpec  extends AnyFunSpec with FunSpecStackBehaviors with StackTestHelper {

  describe("A Stack") {

    describe("(when empty)") {

      it("should be empty") {
        assert(emptyStack.empty)
      }

      it("should complain on peek") {
        intercept[IllegalStateException] {
          emptyStack.peek
        }
      }

      it("should complain on pop") {
        intercept[IllegalStateException] {
          emptyStack.pop
        }
      }
    }

    describe("(with one item)") {
      it should behave like nonEmptyStack(stackWithOneItem, lastValuePushed)
      it should behave like nonFullStack(stackWithOneItem)
    }

    describe("(with one item less than capacity)") {
      it should behave like nonEmptyStack(stackWithOneItemLessThanCapacity, lastValuePushed)
      it should behave like nonFullStack(stackWithOneItemLessThanCapacity)
    }

    describe("(full)") {

      it("should be full") {
        assert(fullStack.full)
      }

      it should behave like nonEmptyStack(fullStack, lastValuePushed)

      it("should complain on a push") {
        intercept[IllegalStateException] {
          fullStack.push(10)
        }
      }
    }
  }
}
