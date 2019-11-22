# 题目描述
设计一个算法，找出只含素因子2，3，5 的第 n 小的数。

符合条件的数如：1, 2, 3, 4, 5, 6, 8, 9, 10, 12...

# 示例输入
```java
// 输入
9
// 输出
10
-----------
// 输入
1
// 输出
1
```

**解释:**  

# 解题思路
该题考察的是丑数的计算，我们知道只含素因子2，3，5的数字被称为丑数，所以该题最直接的解法是:    
编写一个判断数字是否是丑数的方法(求该数的所有因子,若该因子是除2,3,5之外的素数则该数不是丑数)，通过遍历正整数，每遇到一个丑数则将它存储到数组中，当数组大小为n时停止遍历，返回结果。   
以上解法是最容易想到的解法，但是该解法在这里并不是最优的，因为利用现有条件我们完全可以利用素数的特性进行丑数表的迭代计算，我们知道:  
>素数的定义是:因子中只包含1和本身的数叫做素数

而且我们在迭代求丑数表时不能引入其他素因子，通过素数的特性，我们可以在原素数集{2,3,5}中进行自乘迭代求丑数，也就是:  
> 若一个数是丑数,那么该数乘2，乘3或者乘5后也将是丑数。

所以我们可以引入一个容器用来丑数表，该丑数表的计算方式正是将已有的丑数不断乘以2,3和5进行迭代的，迭代过程中需要保证丑数的唯一性(若已包含该数则不加入到容器中)，但这里还有一个坑，那就是怎样保证丑数的计算顺序呢？    
在第一轮迭代计算丑数时，我们可以用原丑数集合: `[1] * [2,3,5]` 得到新的丑数集合: `[1,2,3,5]`  
在第二轮迭代计算丑数时，我们便发现 `[1,2,3,5] * [2,3,5]` 得到的集合是 `[1,2,3,5,4,6,9,12,10,15,25]`    
这里可以发现，第二轮计算的丑数中包含比第一轮更小的丑数，但它居然排在后面，这样求第N大的丑数时将会得到错误的结果，所以每次求完一轮丑数都需要对该容器进行排序，这样才不影响下一轮丑数的迭代顺序，也不会造成结果错误的后果。实际上有这样一种容器刚好满足这个需求，那就是**优先队列**，优先队列一般使用堆实现，这个堆即可以用树实现也可以用数组实现(因为它是一颗完全二叉树)，它的特性是:  
>在最大堆中，父节点的值比每一个子节点的值都要大。在最小堆中，父节点的值比每一个子节点的值都要小。

在JAVA中我们可以利用`PriorityQueue`类实现的优先队列解决这个问题。

**注意:**  
在第1364次迭代时，也就是以丑数429981696进行乘 2，3，5 的迭代时，`429981696 * 5` 将会超出`Integer.MAX_VALUE`，若用Integer容器进行存储将会发生异常，所以这里需要使用Long容器进行存储。

代码可参考：  
[Number ii](https://github.com/PAPW/PAPForJava/blob/master/solution/NthUglyNumber.java)

# 题目来源  
[Lintcode 4: Ugly Number ii](https://www.lintcode.com/problem/ugly-number-ii/description)  