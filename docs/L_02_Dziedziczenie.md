### Dziedziczenie

Polimorfizm

Dynamic bindings:
>>> Jestem B, może dziedziczę po A, ale wiem że jestem B, więc jeśli mogę to wykorzystam co mogę z B, a wy się gońcie.


```JAVA
import org.junit.Test;

public class Bindings {

    class A {
        void doIt() {
            System.out.println("Doing A");
        }
    }

    class B extends A {
        void doIt() {
            System.out.println("Doing B");
        }
    }

    @Test
    public void testBinding01() {
        A a = new A();
        B b = new B();
        a.doIt();
        b.doIt();
    }

    @Test
    public void testBinding02() {
        A a = new A();
        A b = new B();          // ten obiekt dalej wie, że jest klasy B, więc jeśli może to wykorzysta metody klasy B
        a.doIt();
        b.doIt();
    }
}
```