function solution(bandage, health, attacks) {
    let currentHealth = health;
    let time = 0;
    let cnt = 0;
    let idx = 0;

    while (time <= 1000 && idx < attacks.length) {
        if (attacks[idx][0] === time) {
            currentHealth -= attacks[idx][1];
            if (currentHealth <= 0) return -1;
            cnt = 0;
            idx++;
        } else {
            if (cnt < bandage[0]) {
                currentHealth += bandage[1];
                cnt++;
            }
            if (cnt === bandage[0]) {
                currentHealth += bandage[2];
                cnt = 0;
            }
        }
        currentHealth = Math.min(currentHealth, health);
        time++;
    }

    return currentHealth;
}