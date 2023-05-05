public class Main {
    public static void main(String[] args) {
        System.out.println("1、B  2、B  3、D  4、A  5、D");//选择题答案
        showTriangle(5);//打印三角形
        reverseString("ABCDEF好");//颠倒字符串
        isPalindrome(123321);//回文数判断
        ShuiXianHua();//3位求水仙花数
        arraysDemo();//求数组的最大最小和
    }
    public static void showTriangle(int n) {
        int size = 2 * n - 1;
        int num = n;
        while (num != 0) {
            for (int i = 1; i <= size; i++) {
                if (i <= (num - 1) || i > size - num + 1)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println("");
            num--;
        }
    }
    public static String reverseString(String s) {//可以直接输出，return的目的是为了后面一题能够直接用
        String str = "";
        for (int i = s.length() - 1; i >= 0; i--)
            str += s.substring(i, i + 1);
        System.out.print(str + "\t");
        return str;
    }
    public static void isPalindrome(int num) {
        String s = String.valueOf(num);
        int reverse = Integer.parseInt(reverseString(s));//颠倒和原来相等即为回文数，取消强制转换也可判别回文字符串
        if (num == reverse)
            System.out.println("是回文数");
        else
            System.out.println("不是回文数");
    }
    public static void ShuiXianHua() {
        System.out.print("三位数水仙花数有：");
        for (int i = 100; i <= 999; i++) {
            int a = i / 100;
            int b = (i - a * 100) / 10;
            int c = (i - a * 100 - b * 10);
            if (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3) == i)
                System.out.print(i + "\t");
        }
        System.out.println("");
    }
    public static void arraysDemo() { //操作
        int[] arr=new int[10];
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*100);//随机生成10个数字0~100
        }
        int min=arr[0],max=arr[0];
        System.out.print("随机生成10个数为：");
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min)
                min=arr[i];
            if(arr[i]>max)
                max=arr[i];
            System.out.print(arr[i]+" ");
        }
        System.out.print("\t和为"+(min+max));
    }
}
