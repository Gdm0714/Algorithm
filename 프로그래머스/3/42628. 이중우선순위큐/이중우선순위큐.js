function solution(operations) {
    const queue = [];

    operations.forEach(operation => {
        const [cmd, n] = operation.split(' ');
        const num = parseInt(n);

        if (cmd === 'I') {
            queue.push(num);
            queue.sort((a, b) => a - b);
        } else if (cmd === 'D') {
            if (queue.length === 0) return;
            if (num === 1) {
                queue.pop();
            } else if (num === -1) {
                queue.shift();
            }
        }
    });

    if (queue.length === 0) return [0, 0];
    return [queue[queue.length - 1], queue[0]];
}