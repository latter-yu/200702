import java.util.Scanner;

public class Test {
    public static void main1(String[] args) {

        // 输入一个数 n，然后输入 n 个数值各不相同，
        // 再输入一个值 x，输出这个值在这个数组中的下标
        // （从 0 开始，若不在数组中则输出 -1）。

        // 输入描述:
        // 测试数据有多组，输入 n(1 <= n <= 200)，接着输入 n 个数，然后输入 x。
        // 输出描述:
        // 对于每组输入, 请输出结果。

        // 示例:
        // 输入
        // 2
        // 1 3
        // 0
        // 输出
        // -1
        
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = in.nextInt();
            }
            int x = in.nextInt();
            int index = -1;
            for (int i = 0; i < n; i++) {
                if (num[i] == x) {
                    index = i;
                }
            }
            System.out.println(index);
        }
        in.close();
    }

    public static void main2(String[] args) {

        // 原理：ip 地址的每段可以看成是一个 0-255 的整数
        // 把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成一个长整数。

        // 举例：一个 ip 地址为 10.0.3.193
        // 每段数字             相对应的二进制数
        //   10                   00001010
        //   0                    00000000
        //   3                    00000011
        //   193                  11000001
        // 组合起来即为：00001010 00000000 00000011 11000001,
        // 转换为 10 进制数就是：167773121，即该 IP地址转换后的数字就是它了。

        // 输入描述:
        // 输入
        // 1 输入 IP 地址
        // 2 输入 10 进制型的 IP 地址

        // 输出描述:
        // 输出
        // 1 输出转换成 10 进制的 IP 地址
        // 2 输出转换后的 IP 地址
        //
        // 示例:
        // 输入
        // 10.0.3.193
        // 167969729
        // 输出
        // 167773121
        // 10.3.3.193

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String ip = in.next(); // IP地址
            String IP = in.next(); // 十进制的 IP 地址
            String[] arr = ip.split("\\.");
            // split(String regex): 将此字符串 分割 为给定的 regular expression(regex) 的匹配
            long[] str = new long[arr.length];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                str[i] = Long.parseLong(arr[i]);
                String s = Long.toBinaryString(str[i]);
                // parseLong(String s): 将字符串参数解析为带符号的十进制 long
                // toBinaryString(long i): 返回 long参数的字符串表示形式为基数2中的无符号整数

                // 转成8位二进制 利用String.format()控制格式
                // format(String format, Object... args): 使用指定的格式字符串和参数返回格式化的字符串
                String temp = String.format("%08d", Long.parseLong(s));
                sb.append(temp);
            }
            long output = Long.parseLong(sb.toString(), 2);
            System.out.println(output);


            String strs = Long.toBinaryString(Long.parseLong(IP));
            StringBuilder stringBuilder = new StringBuilder(strs);
            int len = strs.length(); // 10 进制型 IP 地址长度
            // 不足32位的前面补0
            for (int i = 0; i < 32 - len; i++) {
                stringBuilder.insert(0, "0");
                // insert(int offset, String str): 将字符串插入到此字符序列(offest 位置)中
            }
            String fin = stringBuilder.toString();
            long a = Long.valueOf(fin.substring(0, 8), 2);
            long b = Long.valueOf(fin.substring(8, 16), 2);
            long c = Long.valueOf(fin.substring(16, 24), 2);
            long d = Long.valueOf(fin.substring(24, 32), 2);
            // valueOf(long l): 返回 long 参数的字符串 long 形式
            // substring(int beginIndex, int endIndex): 返回一个字符串，该字符串是此字符串的子字符串
            System.out.println(a + "." + b + "." + c + "." + d);
        }
    }
}
