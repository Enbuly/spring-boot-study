
## final关键字
final关键字主要用在三个地方：变量、方法、类。
1、对于一个final变量，如果是基本数据类型的变量，则其数值一旦在初始化之后便不能更改；
如果是引用类型的变量，则在对其初始化之后便不能再让其指向另一个对象。
2、当用final修饰一个类时，表明这个类不能被继承。final类中的所有成员方法都会被隐式地指定为final方法。

## static 关键字
static 关键字主要有以下四种使用场景：
1、修饰成员变量和成员方法: 被 static 修饰的成员属于类，不属于单个这个类的某个对象，
被类中所有对象共享，可以并且建议通过类名调用。被static 声明的成员变量属于静态成员变量，
静态变量 存放在 Java 内存区域的方法区。调用格式：类名.静态变量名 类名.静态方法名()
2、静态代码块: 静态代码块定义在类中方法外, 静态代码块在非静态代码块之前执
行(静态代码块—>非静态代码块—>构造方法)。 该类不管创建多少对象，静态代码块只执行一次.
3、静态内部类（static修饰类的话只能修饰内部类）： 静态内部类与非静态内部类之间存在一个
最大的区别: 非静态内部类在编译完成之后会隐含地保存着一个引用，该引用是指向创建它的外
围类，但是静态内部类却没有。没有这个引用就意味着：1. 它的创建是不需要依赖外围类的
创建。2. 它不能使用任何外围类的非static成员变量和方法。

## this关键字
this关键字用于引用类的当前实例。 例如：

class Manager {

    Employees[] employees;
     
    void manageEmployees() {
        int totalEmp = this.employees.length;
        System.out.println("Total employees: " + totalEmp);
        this.report();
    }
     
    void report() { }
}

在上面的示例中，this关键字用于两个地方：
this.employees.length：访问类Manager的当前实例的变量。
this.report（）：调用类Manager的当前实例的方法。
此关键字是可选的，这意味着如果上面的示例在不使用此关键字的情况下表现相同。 但是，使用此关键字可能会使代码更易读或易懂。

## super关键字

super关键字用于从子类访问父类的变量和方法。 例如：
public class Super {

    protected int number;
     
    protected showNumber() {
        System.out.println("number = " + number);
    }
}
 
public class Sub extends Super {

    void bar() {
        super.number = 10;
        super.showNumber();
    }
    
}
在上面的例子中，Sub 类访问父类成员变量 number 并调用其其父类 Super 的 showNumber（） 方法。
使用 this 和 super 要注意的问题：
在构造器中使用 super（） 调用父类中的其他构造方法时，该语句必须处于构造器的首行，
否则编译器会报错。另外，this 调用本类中的其他构造方法时，也要放在首行。
this、super不能用在static方法中。
