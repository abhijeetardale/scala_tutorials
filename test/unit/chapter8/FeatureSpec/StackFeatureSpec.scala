package unit.chapter8.FeatureSpec

import org.scalatest.GivenWhenThen
import org.scalatest.featurespec.AnyFeatureSpec
import unit.chapter8.StackTestHelper

class StackFeatureSpec extends AnyFeatureSpec with GivenWhenThen with FeatureSpecStackBehaviors with StackTestHelper {

  Feature("A chapter7.Stack is pushed and popped") {

    Scenario("empty is invoked on an empty stack") {

      Given("an empty stack")
      val stack = emptyStack

      When("empty is invoked on the stack")
      Then("empty returns true")
      assert(stack.empty)
    }

    Scenario("size is invoked on an empty stack") {

      Given("an empty stack")
      val stack = emptyStack

      When("size is invoked on the stack")
      Then("size returns 0")
      assert(stack.size ==0)
    }

    Scenario("peek is invoked on an empty stack") {

      Given("an empty stack")
      val stack = emptyStack

      When("peek is invoked on the stack")
      Then("peek throws IllegalStateException")
      intercept[IllegalStateException] {
        stack.peek
      }
    }

    Scenario("pop is invoked on an empty stack") {

      Given("an empty stack")
      val stack = emptyStack

      When("pop is invoked on the stack")
      Then("pop throws IllegalStateException")
      intercept[IllegalStateException] {
        emptyStack.pop
      }
    }

    ScenariosFor(nonEmptyStack(stackWithOneItem, lastValuePushed))
    ScenariosFor(nonFullStack(stackWithOneItem))

    ScenariosFor(nonEmptyStack(stackWithOneItemLessThanCapacity, lastValuePushed))
    ScenariosFor(nonFullStack(stackWithOneItemLessThanCapacity))

    Scenario("full is invoked on a full stack") {

      Given("an full stack")
      val stack = fullStack

      When("full is invoked on the stack")
      Then("full returns true")
      assert(stack.full)
    }

    ScenariosFor(nonEmptyStack(fullStack, lastValuePushed))

    Scenario("push is invoked on a full stack") {

      Given("an full stack")
      val stack = fullStack

      When("push is invoked on the stack")
      Then("push throws IllegalStateException")
      intercept[IllegalStateException] {
        stack.push(10)
      }
    }

    Scenario("size is invoked on an full stack") {

      Given("an full stack")
      val stack = fullStack

      When("size is invoked on the stack")
      Then("size returns 10")
      assert(stack.size ==10)
    }

  }
}