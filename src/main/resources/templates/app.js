document.querySelector('#push').onclick = function () {
    var taskInput = document.querySelector('#newtask input[type="text"]');
    var dateInput = document.querySelector('#taskDate');
    var timeInput = document.querySelector('#taskTime');

    if (taskInput.value.length === 0) {
        alert("Please enter a task.");
    } else {
        var taskName = taskInput.value;
        var dateValue = dateInput.value;
        var timeValue = timeInput.value;

        var deadline = dateValue + ' ' + timeValue;

        document.querySelector('#tasks').innerHTML += `
      <div class="task">
        <span id="taskname">
          ${taskName}
        </span>
        <span id="taskDeadline">
          Deadline: ${deadline}
        </span>
        <button class="delete">
          <i class="far fa-trash-alt"></i>
        </button>
      </div>
    `;

        var currentTasks = document.querySelectorAll(".delete");
        for (var i = 0; i < currentTasks.length; i++) {
            currentTasks[i].onclick = function () {
                this.parentNode.remove();
            };
        }

        var tasks = document.querySelectorAll(".task");
        for (var i = 0; i < tasks.length; i++) {
            tasks[i].onclick = function () {
                this.classList.toggle('completed');
            };
        }

        taskInput.value = "";
        dateInput.value = "";
        timeInput.value = "";
    }
};

