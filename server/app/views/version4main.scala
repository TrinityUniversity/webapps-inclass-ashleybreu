package views 

@()(implicit request: RequestHeader, flash: Flash)

@main("Task List 4") {
  <input type="hidden" id="csrfToken" value="@helper.CSRF.getToken.value">
  <input type="hidden" id="validateRoute" value="@routes.TaskList3.validate()">
  <input type="hidden" id="tasksRoute" value="@routes.TaskList3.taskList()">
  <input type="hidden" id="createRoute" value="@routes.TaskList3.createUser()">
  <input type="hidden" id="deleteRoute" value="@routes.TaskList3.delete()">
  <input type="hidden" id="addRoute" value="@routes.TaskList3.addTask()">
  <input type="hidden" id="logoutRoute" value="@routes.TaskList3.logout()">
  
  <div id="react-root"></div>
  <script src="@routes.Assets.versioned("javascript/version4.js")"></script>
}


