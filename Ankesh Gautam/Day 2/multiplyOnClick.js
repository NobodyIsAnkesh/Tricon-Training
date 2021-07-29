var buttonElement = document.getElementById("btn");

buttonElement.addEventListener('click', multiply)

function multiply() {
    var number1 = document.getElementById("num1").value;
    var number2 = document.getElementById("num2").value;
    var result = parseInt(number1) * parseInt(number2);

    console.log(number1 + "*" + number2 + " = " + result);

    document.getElementById("result").innerHTML = result;
}



