function solution(users, emoticons) {
    const discountArr = [10, 20, 30, 40];
    let result = [0, 0];

    const dfs = (discounts) => {
        if (discounts.length === emoticons.length) {
            let [plusUser, sum] = [0, 0];
            users.forEach(([userRate, userLimit]) => {
                let purchase = emoticons.reduce((sum, price, i) =>
                    discounts[i] >= userRate ? sum + price * (100 - discounts[i]) / 100 : sum, 0);
                purchase >= userLimit ? plusUser++ : sum += purchase;
            });
            if (plusUser > result[0] || (plusUser === result[0] && sum > result[1])) {
                result = [plusUser, sum];
            }
            return;
        }
        discountArr.forEach(rate => dfs([...discounts, rate]));
    };

    dfs([]);
    return result;
}