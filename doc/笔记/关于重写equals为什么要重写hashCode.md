
## 关于源码
   #### 关于hashCode源码:
    public native int hashCode();
   #### 关于equals源码
    public boolean equals(Object obj) {
     return (this == obj);
    }
   #### 可知:
    equals方法在其内部是调用了"=="，所以说在不重
    写equals方法的情况下，equals方法是比较两个
    对象是否具有相同的引用，即是否指向了同一个内存地址。
    而hashCode是一个本地方法，他返回的是这个对象的内存地址。

## 在覆盖equals方法时必须遵守它的通用约定:
    自反性:对于非null的引用值x，x.equals(x)必须返回true。
    对称性:对于非null的引用值x，y。当且仅当x.equals(y)为true，y.equals(x)也必须为true。
    传递性:对于非null的引用值x，y，z。x.equals(y)为true，y.equals(z)为true，则x.equals(z)为true
    一致性:多次调用x.equals(y)会一致返回true或者false。
    对于任何非null的引用值x，x.equals(null)必须返回false。

## 覆盖equals时总要覆盖hashCode
   #### object规范:(如果没有覆盖hashCode违反了这条约定)
    如果两个对象根据equals(Object)方法比较是相等的，
    那么调用这两个对象的hashCode方法必须产生相同的
    整数结果。
    
## 程序演示:
    public class Test {

      public static void main(String[] args) {
          Person person1 = new Person("zzy");
          Person person2 = new Person("zzy");

          Map<Person, Integer> hashMap = new HashMap<>();
          hashMap.put(person1, 1);

          System.out.println(person1.equals(person2));
          System.out.println(hashMap.containsKey(person2));
      }

      static class Person {
          private String name;

          Person(String name) {
              this.name = name;
          }

          @Override
          public boolean equals(Object obj) {
              if (obj instanceof Person) {
                  Person person = (Person) obj;
                  return name.equals(person.name);
              }
              return false;
          }
      }
    }
## 控制台打印结果:true false。
## 分析如下:
    对于第一个输出true我们很容易知道，因为我们重
    写了equals方法，只要两个对象的name属性相同
    就会返回ture。但是为什么第二个为什么输出的
    是false呢？就是因为我们没有重写hashCode方法。
    所以我们得到一个结论：如果一个类重写了equals方法
    但是没有重写hashCode方法，那么该类无法结合所
    有基于散列的集合（HashMap，HashSet）一起正常运作。


## 重写hashCode
    @Override
    public int hashCode() {
        return name.hashCode();
    }
## 控制台打印结果:true true

## 完整代码如下:
public class Test {

    public static void main(String[] args) {
        Person person1 = new Person("zzy");
        Person person2 = new Person("zzy");

        Map<Person, Integer> hashMap = new HashMap<>();
        hashMap.put(person1, 1);

        System.out.println(person1.equals(person2));
        System.out.println(hashMap.containsKey(person2));
    }

    static class Person {
        private String name;

        Person(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Person) {
                Person person = (Person) obj;

                return name.equals(person.name);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }
    }
}