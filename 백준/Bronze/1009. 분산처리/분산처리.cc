#include<iostream>
using namespace std;

int main() {
	int num;
	cin >> num;
	int a, b;
	for (int i = 0; i < num; i++) {
		int sum = 1;
		cin >> a >> b;
		if (a % 10 == 0) {
			cout << 10 << endl;
		}
		else {
			for (int j = 0; j < ((b + 3) % 4) + 1; j++) {
				sum *= (a % 10);
			}
			cout << sum % 10 << endl;
		}
	}
}