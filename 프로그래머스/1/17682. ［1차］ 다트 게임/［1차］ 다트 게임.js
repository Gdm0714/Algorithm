function solution(dartResult) {
    let score = [];
    let temp = '';

    for (let i = 0; i < dartResult.length; i++) {
        if (isNaN(dartResult[i])) {
            if (dartResult[i] === 'S') {
                score.push(parseInt(temp));
            } else if (dartResult[i] === 'D') {
                score.push(Math.pow(parseInt(temp), 2));
            } else if (dartResult[i] === 'T') {
                score.push(Math.pow(parseInt(temp), 3));
            } else if (dartResult[i] === '*') {
                score[score.length - 1] *= 2;
                if (score.length > 1) {
                    score[score.length - 2] *= 2;
                }
            } else if (dartResult[i] === '#') {
                score[score.length - 1] *= -1;
            }
            temp = '';
        } else {
            temp += dartResult[i];
        }
    }


    return score.reduce((acc, curr) => acc + curr, 0);
}