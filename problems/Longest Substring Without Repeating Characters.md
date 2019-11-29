# 题目描述

给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

# 示例输入
```java
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
-----------
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
-----------
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
```
# 解题思路

维护一个不含重复字符的集合List，遍历字符串，逐个字符和集合比较，如果集合不含字符，将字符加入到集合，如果集合包含字符，记录集合长度，将集合中在此字符及以前的字符移除，在将此字符放入集合最后，遍历完毕后，最后再记录一下集合长度，选择最大长度输出。

代码可参考：https://leetcode-cn.com/submissions/detail/38295621/  
[无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)

# 题目来源  
[leetcode 3: 无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)  

