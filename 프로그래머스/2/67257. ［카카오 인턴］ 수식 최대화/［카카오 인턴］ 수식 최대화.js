function solution(expression) {
    const priorities = [
        ['+', '-', '*'],
        ['+', '*', '-'],
        ['-', '+', '*'],
        ['-', '*', '+'],
        ['*', '+', '-'],
        ['*', '-', '+']
    ];

    function calculate(exp, priority) {
        const tempExp = exp;
        const numbers = tempExp.split(/[\+\-\*]/).map(Number);
        const operators = tempExp.match(/[\+\-\*]/g) || [];

        priority.forEach((operator) => {
            while (operators.includes(operator)) {
                const index = operators.indexOf(operator);
                const result = eval(`${numbers[index]}${operator}${numbers[index + 1]}`);
                numbers.splice(index, 2, result);
                operators.splice(index, 1);
            }
        });

        return Math.abs(numbers[0]);
    }

    return Math.max(...priorities.map(priority => calculate(expression, priority)));
}