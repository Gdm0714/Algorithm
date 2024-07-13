function solution(new_id) {
    let answer = new_id.toLowerCase();

    answer = answer.replace(/[^a-z0-9-_.]/g, '');
    answer = answer.replace(/\.{2,}/g, '.');
    answer = answer.replace(/^\.|\.$/g, '');

    if (answer === '') {
        answer = 'a';
    }

    answer = answer.slice(0, 15).replace(/\.$/, '');

    while (answer.length < 3) {
        answer += answer.charAt(answer.length - 1);
    }

    return answer;
}