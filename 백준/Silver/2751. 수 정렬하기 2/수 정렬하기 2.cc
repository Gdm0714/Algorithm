#include<iostream>
#include<algorithm>
using namespace std;

int main() {
	int a, b;
	cin >> a;
	int* p;
	p = new int[a];
	for (int i = 0; i < a; i++) {
		cin >> p[i];
	}
	sort(p, p + a);
	for (int i = 0; i < a; i++) {
		cout << p[i] << "\n";
	}
}