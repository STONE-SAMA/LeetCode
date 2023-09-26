package design;

public class Test {
    private String name = "abc";

    public static void main(String[] args) {
        Test test = new Test();
        Test testB = new Test();
        System.out.println(test.equals(testB));
        System.out.println(test.name.equals(testB.name));
        System.out.println(test.name==testB.name);

        String s1 = "java";
        String s2 = "java";
        System.out.println(s1==s2);
        System.out.println(s1==new String("java"));
        System.out.println("java".equalsIgnoreCase(s2));
        final String[] strs = {"aaa","bbb"};
        for (String s:strs){
            s = "A";
        }
        System.out.println(strs[0]);
        String s = "123";
        s += "4";
        System.out.println(s);
    }
}
