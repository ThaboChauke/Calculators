let num1 = 8
let num2 = 2
let sum = document.getElementById("sum-el")


document.getElementById("num1-el").textContent = num1
document.getElementById("num2-el").textContent = num2

function add() {
    sum.textContent = "Sum: "
    result = num1 + num2
    sum.textContent += result
}

function subtract() {
    sum.textContent = "Sum: "
    result = num1 - num2
    sum.textContent += result
}

function multiply() {
    sum.textContent = "Sum: "
    result = num1 * num2
    sum.textContent += result
}

function divide() {
    sum.textContent = "Sum: "
    result = num1 / num2
    sum.textContent += result
}