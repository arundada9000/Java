class A {

    class B {

        public void test() {

            int i = 0;

            while (i <= 100) {

                System.out.println(i);

                i = i + 2;

            }

        }

        public void test2() {
            for (int i = 0; i <= 100; i += 2) {
                System.out.println(i);
            }
        }

    }

}

class Question {
    public static void main(String args[]) {
        A a = new A();
        A.B b = a.new B();
        b.test2();
    }
}