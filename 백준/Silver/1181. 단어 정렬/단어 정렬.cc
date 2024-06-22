#include<iostream>
#include<algorithm>
using namespace std;

int compare(string a, string b) {
	if (a.length() == b.length()) {
		return a < b;
	}
	else {
		return a.length() < b.length();
	}
}

string word[20000];

int main() {
	int num;
	cin >> num;
	for (int i = 0; i < num; i++) {
		cin >> word[i];
	}

	sort(word, word + num, compare);

	for (int i = 0; i < num; i++) {
		if (word[i] == word[i - 1]) {
			continue;
		}
		cout << word[i] << "\n";
	}
	return 0;
	
}