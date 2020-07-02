import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main1(String[] args) {

        // 守形数是这样一种整数，它的平方的低位部分等于它本身。
        // 比如25的平方是 625，低位部分是 25，因此 25 是一个守形数。
        // 编一个程序，判断 N 是否为守形数。

        // 输入描述:
        // 输入包括 1 个整数 N，2 <= N < 100
        // 输出描述:
        // 可能有多组测试数据，对于每组数据
        // 输出 "Yes!” 表示 N 是守形数
        // 输出 "No!” 表示 N 不是守形数

        // 示例:
        // 输入
        // 25
        // 4
        // 输出
        // Yes!
        // No!

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int num = n * n;
            List<Integer> list = new ArrayList<>();
            while(num != 0) {
                list.add(num % 10);
                num = num / 10;
            }
            if (list.contains(n)) {
                System.out.println("Yes!");
            }else {
                System.out.println("No!");
            }
        }
    }

    public static void main(String[] args) {
        // 密码验证合格程序:

        // 密码要求:
        // 1. 长度超过 8 位
        // 2. 包括大. 小写字母. 数字. 其它符号, 以上四种至少三种
        // 3. 不能有相同长度大于等于 2 的子串重复

        // 输入描述:
        // 一组或多组长度超过 2 的子符串。
        // 每组占一行
        // 输出描述:
        // 如果符合要求输出：OK，否则输出 NG

        // 示例:
        // 输入
        // 021Abc9000
        // 021Abc9Abc1
        // 021ABC9000
        // 021$bc9000
        // 输出
        // OK
        // NG
        // NG
        // OK

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            String str = in.next();
            len(str);
            symbol(str);
            repeat(str);
            if (len(str) && symbol(str) && repeat(str)) {
                System.out.println("OK");
            }else {
                System.out.println("NG");
            }
        }
    }
    private static boolean len(String str) {
        return str.length() > 8 ? true : false;
    }
    private static boolean symbol(String str) {
        // 2.包括大小写字母.数字.其它符号,以上四种至少三种
        int digit = 0, lowerCase = 0, upperCase = 0, others = 0;
        char[] chars = str.toCharArray();
        // toCharArray(): 将此字符串转换为新的字符数组
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                digit = 1;
                continue;
            }else if (chars[i] >= 'a' && chars[i] <= 'z') {
                lowerCase = 1;
                continue;
            }else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                upperCase = 1;
                continue;
            }else {
                others = 1;
                continue;
            }
        }
        return (digit + lowerCase + upperCase + others) >= 3 ? true : false;
    }
    private static boolean repeat(String str) {
        // 3.不能有相同长度超 2 的子串重复
        for (int i = 0; i < str.length() - 2; i++) {
            // 最后两个字符不能构成一个子串(子串长度超 2)
            String sub = str.substring(i, i + 3);
            // substring(int beginIndex, int endIndex):
            // 返回一个字符串，该字符串是此字符串的子字符串
            if (str.substring(i + 1).contains(sub)) {
                // i + 1: beginIndex;
                return false;
            }
        }
        return true;
    }
}
