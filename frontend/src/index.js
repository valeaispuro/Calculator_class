async function calculate(operation) {
    const num1 = Number(document.getElementById("num1").value);
    const num2 = Number(document.getElementById("num2").value);

    try {
        const response = await fetch(`http://localhost:8080/api/calculator/${operation}?a=${num1}&b=${num2}`);
        
        if (!response.ok) {
            throw new Error("Error in calculation");
        }

        const result = await response.text();
        document.getElementById("result").innerText = "Result: " + result;
    } catch (error) {
        document.getElementById("result").innerText = "Error: " + error.message;
    }
}

function resetFields() {
    document.getElementById('num1').value = "";
    document.getElementById('num2').value = "";
    document.getElementById('result').innerText = "Result: ";
}

document.getElementById('addButton').addEventListener('click', () => calculate('add'));
document.getElementById('subtractButton').addEventListener('click', () => calculate('subtract'));
document.getElementById('multiplyButton').addEventListener('click', () => calculate('multiply'));
document.getElementById('divideButton').addEventListener('click', () => calculate('divide'));