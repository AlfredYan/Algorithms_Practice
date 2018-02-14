# Cut the Sticks

**Question: **

Given an array of *N* stick lengths (where each length is a positive integer), a cut operation reduces the length of each stick in the array by the length of the array's shortest stick. A stick can only be cut if it has a length >= 1. 

Return an integer array, where stores the number of sticks for each sticks cutting.

**Example: ** 

```
input: {5, 4, 4, 2, 2, 8}
output: {6, 4, 2, 1}
```

```
input: {1, 2, 3, 4, 3, 3, 2, 1}
output: {8, 6, 4, 1}
```

**Solution:** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/CutSticks.cpp)]

```c++
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
```

