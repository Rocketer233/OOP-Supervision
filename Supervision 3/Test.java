interface I{
    void dosth();
}

public class Test implements I{
    final String s = "abc";

    public void dosth(){}

    public static void main(String[] args) {
        Test o = new Test();
        System.out.println(o.s);
    }
}
