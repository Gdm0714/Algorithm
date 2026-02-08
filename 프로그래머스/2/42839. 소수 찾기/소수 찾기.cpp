#include <string>
#include <vector>
#include <algorithm>
#include <set>
#include <cmath>

using namespace std;

bool isPrime(int n) {
    if (n < 2) return false;
    if (n == 2) return true;
    if (n % 2 == 0) return false;
    for (int i = 3; i <= sqrt(n); i += 2) {
        if (n % i == 0) return false;
    }
    return true;
}

int solution(string numbers) {
    set<int> primes;
    
    sort(numbers.begin(), numbers.end());
    
    do {
        for (int len = 1; len <= numbers.size(); len++) {
            int num = stoi(numbers.substr(0, len));
            if (isPrime(num)) {
                primes.insert(num);
            }
        }
    } while (next_permutation(numbers.begin(), numbers.end()));
    
    return primes.size();
}