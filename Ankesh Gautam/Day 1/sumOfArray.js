var numbers = [10, 20, 30, 40, 50, 60, 70, 80, 90];
var sum = 0;

for (var i in numbers) {
    sum += numbers[i];
}

console.log("Sum of [" + numbers + "] = " + sum);