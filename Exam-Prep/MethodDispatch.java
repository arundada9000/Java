public class MethodDispatch {
    public static void main(String args[]) {
        A a = new A();
        B b = new B();
        C c = new C();
        A r;
        r = a;
        r.callMe();
        r = b;
        r.callMe();
        r = c;
        r.callMe();
    }
}

class A {
    void callMe() {
        System.out.println("Class A");
    }
}

class B extends A {
    void callMe() {
        System.out.println("Class B");
    }
}

class C extends B {
    void callMe() {
        System.out.println("Class C");
    }
}