#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

bool cutSticksWorker(vector<int> &lengths, vector<int> &result) {

	// no more sticks to cut, return false
	if (lengths.size() == 0) return false;

	// get the shortest stick, which is the first item
	int smallestLength = lengths[0];

	// push the number of sticks to result array
	result.push_back(lengths.size());
	vector<int> nextLengths;
	for (unsigned int i = 0; i < lengths.size(); i++) {
		// put the sticks that can be cut to new array
		if (lengths[i] > smallestLength) {
			nextLengths.push_back(lengths[i] - smallestLength);
		}
	}
	lengths = nextLengths;
	return true;
}

vector<int> cutSticks(vector<int> lengths) {

	// sort the input array, make sticks cutting easy
	sort(lengths.begin(), lengths.end());
	vector<int> result;

	// when cutting finish, cutSticksWorker() returns false
	while (cutSticksWorker(lengths, result));
	return result;
}

int main()
{
	// cut sticks
	vector<int> lengths = { 5,4,4,2,2,8 };
	vector<int> result = cutSticks(lengths);
	for (vector<int>::iterator it = result.begin(); it != result.end(); ++it) {
		cout << *it << endl;
	}
	system("pause");

	return 0;
}
