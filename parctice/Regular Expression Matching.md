# Regular Expression Matching

**Question:** 

Implement regular expression matching with support for `'.'` and `'*'`.

`'.'` Matches any single character.
`'*'` Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

**Example:** 

```
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
```

