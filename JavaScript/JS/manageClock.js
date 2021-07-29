var startButton = document.querySelector('#start');
var stopButton = document.getElementById("stop");

startButton.addEventListener('click', startClock);
stopButton.addEventListener('click', stopClock);

var minute = 0;
var second = 0;

var intervalID = null;

function startClock() {

    intervalID = setInterval(function () {
        if (second == 60) {
            second = 0;
            minute++;
            if(minute == 60)
                minute = 0;
            document.getElementById("min").innerHTML = minute;
        }
        second++;
        document.getElementById("sec").innerHTML = second;
    }, 1000);
}

function stopClock() {
    clearInterval(intervalID);
}
