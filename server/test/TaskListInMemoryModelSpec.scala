import org.scalatestplus.play._
import models._

class TaskListInMemoryModelSpec extends PlaySpec {
    "TaskListInMemoryModel" must {
        "do valid login for default user" in {
            TaskListInMemoryModel.validateUser("Ashley", "pass") mustBe (true)
        }

    "reject login w wrong password" in {
        TaskListInMemoryModel.validateUser("Ashley", "password") mustBe (false)
    }

    "reject login w wrong username" in {
        TaskListInMemoryModel.validateUser("Ash", "pass") mustBe (false)
    }

    "reject login w wrong username and password" in {
        TaskListInMemoryModel.validateUser("Ash", "password") mustBe (false)
    }
    "get correct defualt tasks in" in {
        TaskListInMemoryModel.getTasks("Ashley") mustBe (List("Make vids" , "eat", "sleep" , "cry"))
    }
    "create new user with no tasks" in {
        TaskListInMemoryModel.createUser("Ash", "password") mustBe (true)
        TaskListInMemoryModel.getTasks("Ash") mustBe (Nil)
    } 

    "create new user with existing name" in {
        TaskListInMemoryModel.createUser("Ash", "password") mustBe (false)
    }
    "add new task for default user" in {
        TaskListInMemoryModel.addTask("Ashley", "testing")
        TaskListInMemoryModel.getTasks("Ashley") must contain ("testing")
    }
    "add task for new user" in {
        TaskListInMemoryModel.addTask("Ash", "testing1")
        TaskListInMemoryModel.getTasks("Ash") must contain ("testing1")
    }

    "remove taks from default user" in {
        TaskListInMemoryModel.removeTask("Ashley", TaskListInMemoryModel.getTasks("Ashley").indexOf("eat"))
        TaskListInMemoryModel.getTasks("Ashley") must not contain ("eat")
    }


}
}