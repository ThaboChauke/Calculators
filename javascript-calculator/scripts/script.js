let num1 = 8
let num2 = 2
let sum = document.getElementById("sum-el")


document.getElementById("num1-el").textContent = num1
document.getElementById("num2-el").textContent = num2

function add() {
    result = num1 + num2
    sum.textContent = "Sum: " + result
}

function subtract() {
    result = num1 - num2
    sum.textContent = "Sum: " + result
}

function multiply() {
    result = num1 * num2
    sum.textContent = "Sum: " + result
}

function divide() {
    result = num1 / num2
    sum.textContent = "Sum: " + result
}