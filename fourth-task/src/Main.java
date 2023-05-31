import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class Main {
    public static void main(String[] args) {
        System.out.println("MySQL入门练习");
        System.out.println("-------------第1题---------------");
        System.out.print("create table cqupt_student(\n" +
                "studentid VARCHAR(10),\n" +
                "name VARCHAR(20),\n" +
                "sex VARCHAR(2),\n" +
                "age INTEGER,\n" +
                "Fee DECIMAL(10,2),\n" +
                "address VARCHAR(50),\n" +
                "memo VARCHAR(300)\n" +
                ")");
        System.out.println("-------------第2题---------------");
        System.out.print("create table cqupt_student(\n" +
                "studentid VARCHAR(10),\n" +
                "name VARCHAR(20),\n" +
                "sex VARCHAR(2),\n" +
                "age INTEGER,\n" +
                "Fee DECIMAL(10,2),\n" +
                "address VARCHAR(50),\n" +
                "memo VARCHAR(300)\n" +
                ")");
        System.out.println("-------------第3题---------------");
        System.out.print("create table ChooseBb(\n" +
                "Bb1 VARCHAR(30),\n" +
                "Bb2 INTEGER,\n" +
                "Bb3 DECIMAL(6)\n" +
                ")");
        System.out.println("-------------第4题---------------");
        System.out.println("alter table ChooseBb ADD(Bb4 VARCHAR(20) default '系统测试值' not null)");
        System.out.println("-------------第5题---------------");
        System.out.println("alter table ChooseBb ADD(Bb5 VARCHAR(10) PRIMARY key)");
        System.out.println("-------------第6题---------------");
        System.out.println("CREATE view View_Choosebb(View_bb1,View_bb2,View_bb3) as SELECT Bb1,Bb4,Bb5 from ChooseBb;");
        System.out.println("-------------第7题---------------");
        System.out.println("drop VIEW View_Choosebb;");
        System.out.println("-------------第8题---------------");
        System.out.println("CREATE INDEX index_bb2 on  ChooseBb(Bb2 asc);\n" +
                "CREATE INDEX index_bb4 on  ChooseBb(Bb4 desc);");
        System.out.println("-------------第9题---------------");
        System.out.println("drop INDEX index_bb2 on ChooseBb;");
        System.out.println("-------------第10题---------------");
        System.out.println("CREATE TABLE test(\n" +
                "Name VARCHAR(20),\n" +
                "Age Integer,\n" +
                "Score NUMERIC(10,2),\n" +
                "Address VARCHAR(60)\n" +
                ")");
        System.out.println("-------------第11题---------------");
        System.out.println("INSERT into test (Name,Age,Score,Address) values ('赵一',20,580.00,'重邮宿舍 12-3-5');\n" +
                "INSERT into test (Name,Age,Score,Address) values ('钱二',19,540.00,'南福苑 15-2-9');\n" +
                "INSERT into test (Name,Age,Score,Address) values ('孙三',21,550.50,'学生新区 21-5-15');\n" +
                "INSERT into test (Name,Age,Score,Address) values ('李四',22,505.00,'重邮宿舍 8-6-22');\n" +
                "INSERT into test (Name,Age,Score,Address) values ('周五',20,495.50,'学生新区 23-4-8');\n" +
                "INSERT into test (Name,Age,Score,Address) values ('吴六',19,435.00,'南福苑 2-15-12');");
        System.out.println("-------------第12题---------------");
        System.out.println("CREATE TABLE test_temp(\n" +
                "Name VARCHAR(20),\n" +
                "Age Integer,\n" +
                "Score NUMERIC(10,2),\n" +
                "Address VARCHAR(60)\n" +
                ")");
        System.out.println("-------------第13题---------------");
        System.out.println("INSERT into test_temp (Name,Age,Score,Address) values ('郑七',21,490.50,'重邮宿舍 11-1-1');\n" +
                "INSERT into test_temp (Name,Age,Score,Address) values ('张八',20,560.00,'南福苑 3-3-3');\n" +
                "INSERT into test_temp (Name,Age,Score,Address) values ('王九',10,515.00,'学生新区 19-7-1');");
        System.out.println("-------------第14题---------------");
        System.out.println("INSERT INTO test SELECT Name,Age,Score,Address from test_temp;");
        System.out.println("-------------第15题---------------");
        System.out.println("UPDATE test set Score=5+Score where age<=20");
        System.out.println("-------------第16题---------------");
        System.out.println("UPDATE test set Age=Age-1 where Address like '南福苑%'");
        System.out.println("-------------第17题---------------");
        System.out.println("DELETE from test where age>=21 and Score>=500");
        System.out.println("-------------第18题---------------");
        System.out.println("DELETE from test where score<500 and Address like '重邮宿舍%'");
        System.out.println("-------------第19题---------------");
        System.out.println("CREATE TABLE Student(\n" +
                "SNO VARCHAR(20),\n" +
                "Name VARCHAR(10),\n" +
                "Age INTEGER,\n" +
                "College VARCHAR(30)\n" +
                ")");
        System.out.println("-------------第20题---------------");
        System.out.println("CREATE TABLE Course(\n" +
                "CourseID VARCHAR(15),\n" +
                "CourseName VARCHAR(30),\n" +
                "CourseBeforeID VARCHAR(15)\n" +
                ")");
        System.out.println("-------------第21题---------------");
        System.out.println("CREATE TABLE Choose(\n" +
                "SNO VARCHAR(20),\n" +
                "CourseID VARCHAR(30),\n" +
                "Score DECIMAL(5,2)\n" +
                ")");
        System.out.println("-------------第22题---------------");
        System.out.println("INSERT into Student (SNO,Name,Age,College) values ('S000001','张三','20','计算机学院');\n" +
                "INSERT into Student (SNO,Name,Age,College) values ('S00002','李四','19','通信学院');\n" +
                "INSERT into Student (SNO,Name,Age,College) values ('S00003','王五','21','计算机学院');");
        System.out.println("-------------第23题---------------");
        System.out.println("INSERT into Course (CourseID,CourseName,CourseBeforeID) values ('C1','计算机引论','NUlL');\n" +
                "INSERT into Course (CourseID,CourseName,CourseBeforeID) values ('C2','C语言','C1');\n" +
                "INSERT into Course (CourseID,CourseName,CourseBeforeID) values ('C3','数据结构','C2');");
        System.out.println("-------------第24题---------------");
        System.out.println("INSERT into Choose (SNO,CourseID,Score) values ('S00001','C1',95);\n" +
                "INSERT into Choose (SNO,CourseID,Score) values ('S00001','C2',80);\n" +
                "INSERT into Choose (SNO,CourseID,Score) values ('S00001','C3',84);\n" +
                "INSERT into Choose (SNO,CourseID,Score) values ('S00002','C1',80);\n" +
                "INSERT into Choose (SNO,CourseID,Score) values ('S00002','C2',85);\n" +
                "INSERT into Choose (SNO,CourseID,Score) values ('S00003','C1',78);\n" +
                "INSERT into Choose (SNO,CourseID,Score) values ('S00003','C3',70);");
        System.out.println("-------------第25题---------------");
        System.out.println("select SNO,Name from Student where College='计算机学院' ");
        System.out.println("-------------第26题---------------");
        System.out.println("select * from Student where Age BETWEEN 20 and 23");
        System.out.println("-------------第27题---------------");
        System.out.println("select COUNT(*) from Student");
        System.out.println("-------------第28题---------------");
        System.out.println("select max(Score),min(Score),sum(Score),avg(Score)from Choose where CourseId='C1'");
        System.out.println("-------------第29题---------------");
        System.out.println("SELECT CourseID,CourseName from Course where CourseBeforeID='NUll'");
        System.out.println("-------------第30题---------------");
        System.out.println("select Choose.SNO,Name,CourseName,Score \n" +
                "from Student,Course,Choose \n" +
                "where Student.SNO=Choose.SNO and Choose.CourseID=Course.CourseID");
        System.out.println("-------------第31题---------------");
        System.out.println("select * from Student a WHERE EXISTS(select College from Student b WHERE a.College=b.College and Name='张三' ) ");
        System.out.println("-------------第32题---------------");
        System.out.println("select SNO,Score from Choose \n" +
                "WHERE CourseID='C1' and score<any(SELECT Score from Choose,Student WHERE Student.SNo=Choose.SNO and CourseID='C1' and Name='张三')");
        System.out.println("-------------第33题---------------");
        System.out.println("SELECT SNO from Choose WHERE CourseID='C1' UNION SELECT SNO from Choose WHERE CourseID='C3'");
        System.out.println("-------------第34题---------------");
        System.out.println("SELECT DISTINCT SNO from Choose WHERE CourseID='C1' UNION SELECT SNO from Choose WHERE CourseID='C3'");
        System.out.println("-------------Java练习题-------------");
        Scanner scnum = new Scanner(System.in);
        System.out.print("请输入待反转的数：");
        int source = scnum.nextInt();
        int x = reverse(source);//倒置
        System.out.println("反转的数为：" + x);
        System.out.print("请输入台阶的数量：");
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int num = climb(y);
        System.out.println("共有" + num + "种办法！");
        int[] arr = new int[]{1, 2, 3};
        List<List<Integer>> res = subset(arr);
        for (List<Integer> re : res) {
            System.out.print(re);
        }
    }
    public static int reverse(int x){//反置数字
        if(x==0){
            return 0;
        }
        long res = 0;
        while (x != 0){
            res = res * 10 + x % 10;
            x /= 10;
        }//倒置
        if (res>Math.pow(2,31)||res<Math.pow(-2,31)){
            res=0;
        }
        return (int) res;
    }
    public static int climb(int num){//爬楼梯
        if(num==1||num==2)
            return num;
        else
            return climb(num-1)+climb(num-2);
    }
    public static List<List<Integer>> subset(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Integer l = nums.length;
        int n = (int) Math.pow(2, l); //结果集个数
        for (int i = 0; i<n; i++) {
            String s = Integer.toBinaryString(i); //二进制字符串
            List<Integer> temp = new ArrayList<>();
            for (int j = s.length() - 1; j >= 0; j--) {
                if (s.charAt(j) == '1') {
//                    System.out.println("j:"+j);
                    temp.add(nums[s.length()-1-j]); //索引数组下标
                }
            }
            result.add(temp);
        }
        return result;
    }
}
