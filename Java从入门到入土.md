# Java从入门到入土
## 语法
* 

## 对象与类
* private成员变量的访问只有在类的内部可以访问，
限定是类。同一个类的不同对象之间可以访问别人的私有成员。
私有针对类，不针对对象。

* 如果要接受一个对象引用作为构造器参数，要考虑是否能接受可有可无
  的值。

  宽容型：`Object.requireNonNulllElse()`  
  严格型：`Object.requireNonNull()`

## 内部类

详细内容可参考[博客园 Java内部类](https://www.cnblogs.com/ldl326308/p/9477566.html)

通过内部类实现多重继承？

### 成员内部类

即在一个类中直接定义的内部类`class InnerClass(){}`，成员内部类与普通类的成员没什么区别，可以与普通成员一样进行修饰和限制。成员内部类不能含有static的变量和方法。

外部类方法访问成员内部类：

1，建立外部类对象

2，根据外部类建立内部类对象

3，访问内部类方法
	  访问内部类字段

### 局部内部类

在方法中定义的内部类称为局部内部类。

1,局部内部类只能在定义该内部类的方法内实例化，不可以在此方法外对其实例化。(作用域限定在块中)

2,局部内部类不仅能访问外部类的字段，还可以访问局部变量，但必须是final。

### 匿名内部类

为局部内部类的一种特殊形式，遵循局部内部类的规则。且：

1、匿名内部类不能有构造方法。

2、匿名内部类不能定义任何静态成员、方法和类。

3、只能创建匿名内部类的一个实例。

4、一个匿名内部类一定是在new的后面，用其隐含实现一个接口或实现一个类。

例子：

```java
 Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person a, Person b) {
                // TODO Auto-generated method stub
                 return a.age < b.age ? -1 : a.age == b.age ? 0 : 1;
            }
        });
```

它的含义是：创建一个类的新对象，这个类实现了Comparator接口，需要实现的方法compare在{}中定义。

`new SuperType(construction parameters){...}`

其中，SuperType可以是接口，如果是这样，则实现接口。

也可以是一个类，如果是这样，就要扩展这个类。

### 静态内部类（嵌套类）

如果你不需要内部类对象与其外围类对象之间有联系，那你可以将内部类声明为static。这通常称为嵌套类（nested class），可以被private,public,protected修饰。想要理解static应用于内部类时的含义，你就必须记住，普通的内部类对象隐含地保存了一个引用，指向创建它的外围类对象。然而，当内部类是static的时，就不是这样了。嵌套类意味着：

　　1. 要创建嵌套类的对象，并不需要其外围类的对象。

　　2. 静态内部类只能访问外部类的静态成员（静态变量、静态方法）。

## String&StringBuffer&StringBuilder

### String

#### String中的compareTo方法

String中对compareTo方法的实现源码：

```java
    public int compareTo(String anotherString) {
        //len1：当前字符串长度
        int len1 = value.length;
        //len2：参数字符串长度
        int len2 = anotherString.value.length;
        //len1和len2两者最小值
        int lim = Math.min(len1, len2);
        //分别转为字符数组
        char v1[] = value;
        char v2[] = anotherString.value;

        int k = 0;
        //比较逻辑
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            //字符不同，则返回两字符的ASCII 码的差值
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        //相同则返回两字符长度差值
        return len1 - len2;
    }

```

所以从上面的源码中可以看到，string中的compareTo逻辑大概可以整理为

- 字符串前面部分的每个字符完全一样，返回：后面两个字符串长度差；
- 字符串前面部分的每个字符存在不一样，返回：出现不一样的字符 ASCII 码/Unicode的差值。
- 字符串的每个字符完全一样，返回 0；

### StringBuffer

### StringBuilder

### 三者区别

简单来说，String值不可变，每次对String对象的改变都会生成新的String
对象。效率低下，浪费内存。对于经常要改变的对象来说，使用StringBuffer和StringBuilder。
具体见:[String、StringBuffer与StringBuilder之间区别](https://blog.csdn.net/itchuxuezhe_yang/article/details/89966303)

# Git

## 关于update中merge和rebase的问题

参考csdn：[git IDEA的分支合并时的冲突问题总结，merge和rebase的区别](https://blog.csdn.net/qq_21187515/article/details/103300226)



## 集合

Collection,List,Arraylist?

## Comparable&Comparator及其相关问题

### implements Comparable&lt;T&gt;

意义：实现Comparable接口,`Comparable`位于包java.lang下

Comparable可以认为是内比较器，依赖于compareTo方法进行比较。compareTo方法的返回值是int，有三种情况：

1、比较者大于被比较者（也就是compareTo方法里面的对象），那么返回正整数
2、比较者等于被比较者，那么返回0
3、比较者小于被比较者，那么返回负整数

```java
class Person implements Comparable<Person>{
    @Override
     public int compareTo(Person person) {
          return name.compareTo(person.name);
          //return this.name - person.name;
     }
}
ArrayList<Person> list = new ArrayList<Person>();
// 添加对象到ArrayList中
list.add(new Person("aaa", 10));
list.add(new Person("bbb", 20));
list.add(new Person("ccc", 30));
list.add(new Person("ddd", 40));
Collections.sort(list); //这里会自动调用Person中重写的compareTo方法。
```



关于name.compareTo(person.name)见[String中的compareTo方法](# String中的compareTo方法)



### 泛型中extends,super，？代表的意思

extends后面跟的类型，如<任意字符 extends 类/接口>表示泛型的**上限**。

super的作用，它与extends相反，表示的是泛型的**下限**。

```java
import java.util.*;
class Demo<T extends List>{}
public class Test
{
    public static void main(String[] args) {
    Demo<ArrayList> p = null; // 编译正确
    //这里因为ArrayList是List的子类所以通过
    //如果改为Demo<Collection> p = null;就会报错这样就限制了上限
    }
}
```

？与T类似也表示站位符。

**? extends T** 描述了通配符上界, 即具体的泛型参数需要满足条件: `泛型参数必须是 T 类型或它的子类`, 例如:

```java
List<? extends Number> numberArray = new ArrayList<Number>();  // Number 是 Number 类型的
List<? extends Number> numberArray = new ArrayList<Integer>(); // Integer 是 Number 的子类
List<? extends Number> numberArray = new ArrayList<Double>();  // Double 是 Number 的子类
```



### &lt;T extends Compable&lt;T&gt;&gt;

意义：泛型。对T的限制为**T必须实现Comparable接口**！这样，T的实例之间才能相互比较大小

extends对泛型上限进行了限制即T必须是Comparable&lt;T>的子类(T为Comparable的实现类）。即**泛型只能接受T**。

```java
import java.util.GregorianCalendar;
class Demo<T extends Comparable<T>>{}
//注意这里是没有? super的
public class Test
{
    public static void main(String[] args) {
       Demo<GregorianCalendar> p = null; 
        }
}
```

这里编译报错，因为这里的<T extends Comparable&lt;T>>相当于<GregorianCalendar extends Comparable&lt;GregorianCalendar>>,**但是GregorianCalendar中并没有实现Comparable&lt;GregorianCalendar>，而是仅仅持有从Calendar继承过来的Comparable&lt;Calendar>**，这样就会因为不在限制范围内而报错。



### <T extends Comparable<? super T>>

意义：泛型。对T的限制为**T或其父类必须实现Comparable接口**，这样声明后，T的实例和T的父类的实例之间可以相互比较大小。

首先，extends对泛型上限进行了限制即T必须是Comparable<? super T>的子类，然后<? super T>表示Comparable<>中的类型下限为T！即**泛型接受T或其父类。**

```java
import java.util.GregorianCalendar;

class Demo<T extends Comparable<? super T>>{}

public class Test1
{
    public static void main(String[] args) {
       Demo<GregorianCalendar> p = null; // 编译正确
    }
}　　
```

此时编译通过，这里可以理解为<GregorianCalendar extends Comparable&lt;Calendar>>！因为Calendar为GregorianCalendar 的父类并且Calendar 实现了Comparable&lt;Calendar>。



实例代码演示：

```java
import java.util.ArrayList;
 import java.util.Collections;
 import java.util.List;
  
 public class Test
 {
     //第一种声明：简单，灵活性低
     public static <T extends Comparable<T>> void mySort1(List<T> list)
     {
         Collections.sort(list);
     }
 
     //第二种声明：复杂，灵活性高
     public static <T extends Comparable<? super T>> void mySort2(List<T> l)
     {
         Collections.sort(list);
     }
 
     public static void main(String[] args)
     {
         //主函数中将分别创建Animal和Dog两个序列，然后调用排序方法对其进行测试
　　　　　// 创建一个 Animal List
        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new Animal(25));
        animals.add(new Dog(35));

        // 创建一个 Dog List
        List<Dog> dogs = new ArrayList<Dog>();
        dogs.add(new Dog(5));
        dogs.add(new Dog(18));

        // 测试  mySort1() 方法
        mySort1(animals);
        mySort1(dogs);
		// 测试  mySort2() 方法
        mySort2(animals);
        mySort2(dogs);
     }
 }
 
 class Animal implements Comparable<Animal>
 {
     protected int age;
 
     public Animal(int age)
 
     {
         this.age = age;
     }
 
     //使用年龄与另一实例比较大小
     @Override
     public int compareTo(Animal other)
     {
         return this.age - other.age;
     }
 }
 
 class Dog extends Animal
 {
     public Dog(int age)
     {
         super(age);
     }
 }
```



**mysort1中：**

​        如果传入的是List&lt;Animal>程序将正常执行，因为Animal实现了接口Comparable&lt;Animal>。

　　但是，如果传入的参数是List&lt;Dog>程序将报错，因为Dog类中没有实现接口Comparable&lt;Dog>，它只从Animal继承了一个Comparable&lt;Animal>接口。

**mysort12中：**

​		它不但能够接受Animal implements Comparable<Animal>这样的参数，也可以接收：Dog implements Comparable<Animal>这样的参数。



### Comparator

Comparator可以认为是是一个**外比较器**，`Comparator`位于包java.util下。

有两种情况可以使用实现Comparator接口的方式：

1、一个对象不支持自己和自己比较（没有实现Comparable接口），但是又想对两个对象进行比较

2、一个对象实现了Comparable接口，但是开发者认为compareTo方法中的比较方式并不是自己想要的那种比较方式

Comparator接口里面有一个compare方法，方法返回值和Comparable中compareTo一样。

```java
public class ComparatorDemo {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Joe", 24),
                new Person("Pete", 18),
                new Person("Chris", 21)
        );
        Collections.sort(people, new LexicographicComparator());
        System.out.println(people);
        //[{name=Chris, age=21}, {name=Joe, age=24}, {name=Pete, age=18}]
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person a, Person b) {
                // TODO Auto-generated method stub
                 return a.age < b.age ? -1 : a.age == b.age ? 0 : 1;
            }
        });
        System.out.println(people);
        //[{name=Pete, age=18}, {name=Chris, age=21}, {name=Joe, age=24}]
    }
}

class LexicographicComparator implements Comparator<Person> {
    @Override
    public int compare(Person a, Person b) {
        return a.name.compareToIgnoreCase(b.name);
    }
}

class Person {
    String name;
    int age;
    Person(String n, int a) {
        name = n;
        age = a;
    }
    @Override
    public String toString() {
        return String.format("{name=%s, age=%d}", name, age);
    }
}
```



其中`new Comparator&lt;Person>() {}`为[匿名内部类](#匿名内部类)

## 多态

1，父类的引用类型变量指向子类的对象

eg: `Employee e = new Manager();`

2，接口类型的类型变量指向接口实现类的对象

eg:a的类型实现Comparable接口`Comparable a`
