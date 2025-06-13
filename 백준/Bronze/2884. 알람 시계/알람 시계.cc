#include <iostream>

using namespace std;

int main(int argc, char const* argv[]) {
	int h, m;
	cin >> h >> m;
	
	if (m >= 45) {
		m -= 45;
	}
	else {
		m += 15;
		h--;
	}
	if (h < 0) {
		h += 24;
	}
	cout << h << ' ' << m;
}