# 题目描述
在数组中找到第 k 大的元素。

# 示例输入
```java
// 输入
1, [1,3,4,2]
// 输出
4
-----------
// 输入
3, [9,3,2,4,8]
// 输出
4
```

**解释:**  

# 解题思路
从数组中找到第k大的元素，该题是从"从数组中找到最大的元素"的一个衍生题，在题目"从数组中找到最大的元素"中我们仅需要一个临时变量用于存储和判断数组中的最大元素，通过遍历数组即可。当这个要求变成一个变量 k 时很明显通过排序后取第 k 个元素即可实现目标，但大家都知道高级排序算法中时间复杂度普遍为O(nlogn)，但该题目的挑战要求时间复杂度为O(n)，空间复杂度为O(1)，并且数字范围为`int`(-2<sup>31</sup>~2<sup>31-1</sup>)。所以实际上该题考察的是对排序算法的灵活应用，如何才能在特定场景下去优化算法。 
但目前的难点在若用桶排序则需要 `abs(Integer.MIN_VALUE) + Integer.MAX_VALUE` 大小的桶用来做哈希，JAVA数组只提供 `Integer.MAX_VALUE` 大小的数组，虽然这样理论上是符合挑战要求的，但我个人认为这是为了符合要求而符合要求，并没有编程美感，所以采用了代码量最小的解法，利用JAVA自带的排序方法进行解答。若有更好更快的方法欢迎投稿。


代码可参考：  
[K-th Largest Element](https://github.com/PAPW/PAPForJava/blob/master/solution/KthLargestElement.java)

# 题目来源  
[Lintcode 5: K-th Largest Element](https://www.lintcode.com/problem/kth-largest-element/description)  