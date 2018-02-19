# Generate Tree and Verify

**Question: **

Given a binary tree as a squesnce of parent-child pairs. The tree represented by the node pairs in string. eg: ``"(B,D) (D,E) (A,B) (C,F) (E,G) (A,C)"`` . Generate the input string to a tree and represent in the lexicographically smallest way (the letter is in order, A to Z). If the input is wrong or there exists mistake when generate the tree, return the error message.

**Example:** 

```
input: (B,D) (D,E) (A,B) (C,F) (E,G) (A,C)
output: (A(B(D(E(G))))(C(F)))
```

```
input: (A,B) (A,C) (A,D)
output: More Than Two Children
```

```
input: (A,B) (B,C) (A,B)
output: Duplicate Edges
```

```
input: (A,B) (B,A)
output: No Root Node
```

```
input: (A,C) (B,C)
output: Cycle Parent
```

```
input: (wrong,input)
output: Wrong Input
```

**Solution: ** [[demo code](https://github.com/AlfredYan/Algorithms_Practice/blob/master/code/GenerateTreeAndVerify.cpp)]

```c++
#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

// store node data
struct Node {
	int parent = -1;
	pair<int, int> children = make_pair(-1, -1);
};

// go through the whole tree
void dfs(vector<Node>& tree, Node& p, char c, string& ans)
{
	ans += c;
	// find the most left chlid first
	if (p.children.first != -1) {
		ans += "(";
		dfs(tree, tree[p.children.first - 'A'], p.children.first, ans);
	}
	if (p.children.second != -1) {
		ans += "(";
		dfs(tree, tree[p.children.second - 'A'], p.children.second, ans);
	}
	ans += ")";
}

string SExpression(string strTree) {
	if (strTree.size() == 0) return "";

	// initialize nodes in a vector which the size is 26 (the number of letters, A-Z)
	// assume A is the first node, Z is the last node
	vector<Node> tree(26, Node());

	// check the input string only includes A-Z(,) and space
	for (char& c : strTree) {
		if (!((c >= 'A' && c <= 'Z') || c == '(' || c == ',' || c == ')' || c == ' ')) { return "Wrong Input"; }
	}

	// convert string to node and insert to vector(tree)
	for (unsigned int i = 0; i < strTree.size(); ++i) {
		// get the position of node
		int currNode = strTree.find_first_of('(', i);
		if (currNode == string::npos) break;

		// get the value of node (x, y)
		string first = strTree.substr(currNode + 1, 1);
		string second = strTree.substr(currNode + 3, 1);

		// insert father node (insert second to first)
		pair<int, int>& p = tree[first[0] - 'A'].children;

		// when have same edge
		if (p.first == second[0] || p.second == second[0]) return "Duplicate Edges";

		if (p.first == -1) { 
			// when the first(left) child node is empty
			p.first = second[0]; 
		}
		else if (p.second == -1) { 
			// when the second(right) child node is empty
			p.second = second[0]; 
		}
		else { 
			return "More Than Two Children"; 
		}

		if (p.first > p.second) { 
			// swap when left child node is larger than right child node
			swap(p.first, p.second); 
		}

		// Insert child (insert first to second)
		if (tree[second[0] - 'A'].parent != -1) return "Cycle Parent";
		tree[second[0] - 'A'].parent = first[0];

		// go to next node
		i = currNode + 3;
	}

	Node* rootNode = nullptr;
	char rootChar = 0;

	// find the root node
	for (unsigned int i = 0; i < tree.size(); ++i) {
		Node& pNode = tree[i];
		// this if statement should run only one time
		// if not the tree has multiple roots problem
		if (pNode.parent == -1 && (pNode.children.first != -1 || pNode.children.second != -1)) {
			if (rootNode) { return "Multiple Roots"; }
			rootNode = &pNode;
			rootChar = (char)(i + 'A');
		}
	}

	string answer;

	// depth first search
	answer += "(";
	if (rootNode == 0) { return "No Root Node"; }
	dfs(tree, *rootNode, rootChar, answer);
	return answer;
}

void main() {

	cout << SExpression("(B,D) (D,E) (A,B) (C,F) (E,G) (A,C)") << endl;
	cout << SExpression("(A,B) (A,C) (A,D)") << endl;
	cout << SExpression("(A,B) (B,C) (A,B)") << endl;
	cout << SExpression("(A,B) (B,A)") << endl;
	cout << SExpression("(A,C) (B,C)") << endl;
	cout << SExpression("(wrong,input)") << endl;
	system("pause");
}
```

