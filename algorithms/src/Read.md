#算法与数据结构笔记
##斐波那契数列实现
```java
//①==================================
/**
* 平推方法实现
*/
public static long fibLoop(int num) {
    if(num < 1 || num > 92)
        return 0;
    long a = 1;
    long b = 1;
    long temp;
    for(int i = 3; i <= num; i++) {
        temp = a;
        a = b;
        b += temp;
    }
    return b;
}
 
//②==================================
/**
* 递归方法实现
* f(n) = f(n - 1) + f(n - 2)
* 最高支持 n = 92 ，否则超出 Long.MAX_VALUE
* @param num n 
* @return f(n) 
*/
public static long fibRec(int num) {
    if(num < 1)
        return 0;
    if(num < 3)
        return 1;
    return fibRec(num - 1) + fibRec(num - 2);
}
 
//③==================================
static long[] l = new long[93];
static {
    l[1] = 1;
}
/**
* 带有缓存的方法，比fibRec方法性能好很多
*/
public static long fibBuffRec(int num) {
    if(num < 1 || num > 92)
        return 0;
    if(l[num] == 0)
        l[num] = fibBuffRec(num - 1) + fibBuffRec(num - 2);
    return l[num];
}
 
//④==================================
static List<BigDecimal> list = new ArrayList<BigDecimal>(93);
static {
    list.add(BigDecimal.ZERO);
    list.add(BigDecimal.ONE);
}
/**
* 1，2，3，4，5，6， 7 ，8 
* 1，1，2，3，5，8，13，21
* 支持num超过92的超大型数字，使用了ArrayList进行缓存以提高性能
*/
public static BigDecimal fibBig(int num) {
    if(num < 0)
        return list.get(0);
    if (list.size() <= num)
        list.add(fibBig(num - 1).add(fibBig(num - 2)));
    return list.get(num);
}
```