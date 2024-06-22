#include<iostream>
#include<string>
using namespace std;

int main() {
	int num, j;
	cin >> num;
	int n = 666;
	int count = 0;
	while (true) {
		j = n;
		while (j > 0) {
			if (j % 1000 == 666) {
				count++;
				break;
			}
			j /= 10;
		}
		if (count == num) {
			cout << n << endl;
			break;
		}
		n++;
	}
}