document.addEventListener("DOMContentLoaded", function() {
    getAllTasks();

    document.querySelector('#push').addEventListener('click', function() {
        var taskInput = document.querySelector('#newtask input[type="text"]');
        var dateInput = document.querySelector('#taskDate');
        var timeInput = document.querySelector('#taskTime');

        if (taskInput.value.length === 0) {
            alert("Please enter a task.");
        } else {
            var taskName = taskInput.value;
            var deadline = dateInput.value + ' ' + timeInput.value;
            var timeResult = makeHoursTime("00:00", timeInput.value);


            document.querySelector("#timeResult span").textContent = timeResult;

            addNewTask(taskName, deadline, timeResult);

            var taskElem = document.createElement('div');
            taskElem.className = 'task';
            taskElem.innerHTML = `
                <span id="taskname">
                    ${taskName}
                    </span>
                    <span id="taskDeadline">
                    Deadline: ${deadline}
                     </span>
                    <span id="timeInHours">
                     Time in Hours: ${timeResult.toFixed(2)}
                     </span>
                     <button class="delete">
                    <i class="far fa-trash-alt"></i>
                    </button>
                    `;


            taskElem.querySelector('.delete').addEventListener('click', function() {
                var taskId = this.parentNode.getAttribute('data-task-id');
                deleteTask(taskId);
                this.parentNode.remove();
            });

            taskElem.addEventListener('click', function() {
                this.classList.toggle('completed');
            });

            document.querySelector('#tasks').appendChild(taskElem);

            taskInput.value = "";
            dateInput.value = "";
            timeInput.value = "";
        }
    });

    function makeHoursTime(startTime, endTime){

        const startTimeParts = startTime.split(":");
        const endTimeParts = endTime.split(":");

        const startHour = parseInt(startTimeParts[0]);
        const startMinute = parseInt(startTimeParts[1]);
        const endHour = parseInt(endTimeParts[0]);
        const endMinute = parseInt(endTimeParts[1]);

        const hour = endHour - startHour;
        const hoursBase100 = (hour * 100) / 60 ;
        const minute = endMinute - startMinute;
        const minutesBase100 = (minute * 100) / 60 ;

        const doubleTimeString = ""+hoursBase100 + "." + minutesBase100;
        const doubleTime = parseFloat(doubleTimeString)
        console.log(doubleTime);
        return doubleTime;

    }

    function getAllTasks() {
        fetch('/index/all')
            .then(response => response.json())
            .then(tasks => {
                console.log(tasks);
            })
            .catch(error => console.error('Error:', error));
    }

    function addNewTask(newTask, deadline, timeInHours) {
        const data = {
            newTask: newTask,
            deadline: deadline,
            timeInHours: timeInHours

        };

        fetch('/index/add', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
            .then(response => {
                if (response.ok) {
                    console.log('Task added successfully');
                } else {
                    console.error('Error:', response.statusText);
                }
            })
            .catch(error => console.error('Error:', error));
    }

    function deleteTask(taskId) {
        fetch(`/index/${taskId}`, {
            method: 'DELETE'
        })
            .then(response => {
                if (response.ok) {
                    console.log('Task deleted successfully');
                } else {
                    console.error('Error:', response.statusText);
                }
            })
            .catch(error => console.error('Error:', error));
    }
});

