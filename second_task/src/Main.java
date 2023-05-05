import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("<----------第一题---------->");
        Monkey monkey = new Monkey("猴子");
        People people = new People("人");
        monkey.speak();
        people.speak();
        people.think();
        System.out.println("<----------done---------->");
        System.out.println("<----------第二题---------->");
        Car car = new Car(1000, 7);
        car.PrintNotice();
        System.out.println("--------------------------");
        Truck truck = new Truck(5000, 3);
        truck.PrintNotice();
        truck.WeightCheck(6000);
        System.out.println("<----------done---------->");
        System.out.println("<----------第三题---------->");
        String a = "13829579081298345918257";
        String b = "438823897418920918472193";
        System.out.println(a + "+" + b + "=" + getSum(a, b));
        System.out.println("<----------done---------->");
        System.out.println("<----------第四题---------->");
        int m=3,n=7;
        System.out.println(m+"x"+n+"的网格有"+FindPath(3,7)+"条路经。");
        System.out.println("<----------done---------->");
        System.out.println("<----------第五题---------->");
        String strs[]=new String[]{"f1ower","f1ow","f1ight"};
        FindPreStr(strs);
        System.out.println("<----------done---------->");
    }
    public static String getSum(String a, String b) {
        List<Integer> la = new ArrayList<Integer>();//动态数组
        List<Integer> lb = new ArrayList<Integer>();
        String c = "";
        for (int i = a.length() - 1; i >= 0; --i) {//charAt() 方法用于返回指定索引处的字符
            la.add(a.charAt(i) - '0');
        }
        for (int i = b.length() - 1; i >= 0; --i) {
            lb.add(b.charAt(i) - '0');
        }
        List<Integer> lc = new ArrayList<Integer>();
        int min = Math.min(a.length(), b.length());//取最小值
        int max = Math.max(a.length(), b.length());//取最大值
        int sum = 0;//每位数相加和
        for (int i = 0; i < max; i++) {
            if (i < min)
                sum = la.get(i) + lb.get(i) + sum;
            else {
                if (min == b.length())
                sum += la.get(i);
                else
                    sum += lb.get(i);
            }
            lc.add(sum % 10);
            sum /= 10;//进位
        }
        if (sum % 10 != 0)
            lc.add(sum % 10);//保取第一位
        for (int i = lc.size() - 1; i >= 0; --i) {
            c += lc.get(i);
        }
        return c;
    }
    public static int FindPath(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];//转移方程
            }
        }
        return dp[m - 1][n - 1];
    }
    public static void FindPreStr(String arr[]){
        int min=arr[0].length();
        for(int i=1;i< arr.length;i++)
            if(min>arr[i].length())
                min=arr[i].length();
        String str_same="";
        for(int i=0;i<min;i++){
            char str=arr[0].charAt(i);
            for(int j=1;j<arr.length;j++){
                if(str==arr[j].charAt(i)){
                    str=arr[j].charAt(i);
                    if(j==arr.length-1)
                        str_same+=str;
                }
            }
        }
        if(str_same.length()==0)
            System.out.println("''\n"+"输入不存在公共前缀");
        else
            System.out.println("最长公共前缀为:"+str_same);
    }
}
class Monkey {
    String name;
    Monkey(String s) {
    }
    public void speak() {
        System.out.println(" 咿咿呀呀......");
    }
}
class People extends Monkey {
    People(String name) {
        super(name);
    }
    @Override
    public void speak() {
        System.out.println(" 小样儿，不错嘛！会说话了！");
    }
    public void think() {
        System.out.println(" 别说话！认真思考！");
    }
}
class Vehicle {
    int wheels;//轮子个数
    int weight;//车重
    Vehicle(int wheels, int weight) {
        this.wheels = wheels;
        this.weight = weight;
    }//属性赋值
    void PrintNotice() {
        System.out.println("车轮的个数是:" + wheels + "  车重：" + weight + "kg");
    }//提示信息
}
class Car extends Vehicle {
    int loader = 6;//核载人数
    int num;
    Car(int weight, int loader) {
        super(4, weight);//继承父类的方法
        num = loader;
    }
    void PrintNotice() {
        super.PrintNotice();
        if (num > loader)
            System.out.println("这是一辆小车，核载6人，实载" + num + "人" + "，你超员了！！！");
        else
            System.out.println("这是一辆小车，能载6人，实载" + num + "人");
    }
}
class Truck extends Vehicle {
    int loader = 3;//核载人数
    int payload;//载重量
    int num;
    Truck(int weight, int loader) {
        super(6, weight);
        num = loader;
        payload = 5000;
    }
    void PrintNotice() {
        super.PrintNotice();
        System.out.println("这是一辆卡车，能载3人，实载" + num + "人");
    }//提示信息
    void WeightCheck(int weight) {
        if (weight > payload)
            System.out.println("这是一辆卡车，核载5000kg，你已装载" + weight + "kg" + "，你超载了！！！");
    }
}