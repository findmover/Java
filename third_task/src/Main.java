import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
/*实现一个简单的学生管理系统功能，包括查询全部学生信息，添加学生信息（检错：学号相同，则提示），按学号删除指定学生信息，按学号修改学生信息，删除全部学生信息*/
/*为了防止数据的丢失，将学生信息储存在本地（在D盘建一个demo.txt文件），并每次在管理系统上线时读取demo.txt文件里的学生信息*/
public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Student> student = new ArrayList<>();//创建类数组
        Scanner sc = new Scanner(System.in);
        read(student);//查询文件时先读取本地通讯录
        while (true) {
            System.out.println("--------------------------------------");
            System.out.println("*-------欢迎来到lee‘s的学生管理系统-------*");
            System.out.println("1.查询信息\t2.添加信息\t3.删除信息\t4.修改信息");
            System.out.println("5.删除全部\t6.写入文件\t7.读取文件\t8.退出系统");
            System.out.println("--------------请选择功能!----------------");
            int choose_num = sc.nextInt();
            switch (choose_num) {
                case 1:
                    clear();
                    show(student);
                    break;
                case 2:
                    adds(student);
                    break;
                case 3:
                    deletebyId(student);
                case 4:
                    editbyId(student);
                case 5:
                    delete_all(student);
                    break;
                case 6:
                    save(student);
                    break;
                case 7:
                    read(student);
                    clear();
                    break;
                case 8:
                    System.out.println("================系统已经退出!===============");
                    return;
                default:
                    System.out.println("***********输入有误，请重新输入！***********\n");
                    break;
            }
        }
    }

    public static void adds(ArrayList<Student> student) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生学号：");
        String id = sc.nextLine();
        for(int i = 0;i < student.size();i++){
            Student s = student.get(i);
            if(s.getId().equals(id)){
                System.out.println("-----------学号重复，请重新输入！----------");
                adds(student);
                return;
            }
        }
        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生电话：");
        String phone = sc.nextLine();
        System.out.println("请输入学生专业：");
        String major = sc.nextLine();
        System.out.println("请输入是否录入，键入‘y’ or ‘n’.");//检错机制
        Scanner str=new Scanner(System.in);
        String flag=str.nextLine();
        switch (flag){
            case "y", "yes":
                break;
            default:
                System.out.println("请重新输入！");
                adds(student);
                return;
        }
        clear();
        Student students = new Student();//创建学生对象
        students.setId(id);
        students.setName(name);
        students.setPhone(phone);
        students.setMajor(major); //将输入的值赋给学生对象的成员变量
        student.add(students);      //讲学生对象添加到集合中
        System.out.flush();
        System.out.println("添加学生信息成功");
        System.out.println("学号\t姓名\t电话\t专业\t");
        students.print_information();
    }
    public static void show(ArrayList<Student> student) throws IOException {
        if (student.size() == 0) {
            System.out.println("---------无学生信息，请先添加!---------");
            return;
        }
        System.out.println("学号\t姓名\t电话\t专业\t");
        for (int i = 0; i < student.size(); i++) {
            Student s = student.get(i);
            System.out.println(s.getId() + "\t" + s.getName() + "\t" + s.getPhone() + "\t" + s.getMajor());
        }
    }
    public static void deletebyId(ArrayList<Student> student){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除学生的学号：");
        String id = sc.nextLine();
        for(int i = 0;i < student.size();i++){
            Student s = student.get(i);
            if(s.getId().equals(id)){
                System.out.println("删除后无法恢复，是否要继续删除,键入‘y’ or ‘n’");
                String str = sc.nextLine();
                if(Objects.equals(str, "y") || Objects.equals(str, "yes")) {
                    student.remove(i);
                    System.out.println("删除成功！！");
                    break;
                }else{
                    System.out.println("删除失败！");
                    break;
                }
            }
        }
    }
    public static void editbyId(ArrayList<Student> student){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入所要修改学生的学号");
        String sid = sc.nextLine();
        System.out.println("请输入新的学生学号：");
        String id = sc.nextLine();
        System.out.println("请输入新的学生姓名：");
        String name =sc.nextLine();
        System.out.println("请输入新的学生电话：");
        String phone =sc.nextLine();
        System.out.println("请输入新的学生专业：");
        String major =sc.nextLine();
        Student s = new Student();
        s.setId(id);
        s.setName(name);
        s.setPhone(phone);
        s.setMajor(major);//输入要修改的信息并把它赋值给新的学生类对象
        for(int i = 0;i < student.size();i++){
            Student a = student.get(i);
            if(a.getId().equals(sid)){
                student.set(i,s);/*通过equals（）方法找到对应学生类对象再用set（int index，element）方法将旧的学生类对象修改为新的*/
                break;
            }
            System.out.println("修改学生信息成功");
        }
    }
    public static void delete_all(ArrayList<Student> student){
        int len=student.size();
        System.out.println(len);
        for(int i=0;i<len;i++)
            student.remove(0);
        System.out.println("全部删除成功！-----------");
    }
    public static void  save(ArrayList<Student> student) throws IOException {//保存通讯录到本地文件，防止数据丢失
        FileWriter writer = new FileWriter("E:/demo.txt");
        int len = student.size();
        for (int i = 0; i < len; i++) {
            Student s = student.get(i);
            writer.write(s.getId() + "\t" + s.getName() + "\t" + s.getPhone() + "\t" + s.getMajor()+'\n');
        }
        System.out.println("-----------写入成功！-----------");
        clear();
        writer.close();
    }
    public static void read(ArrayList<Student> student) throws IOException {
        FileInputStream fin = new FileInputStream("E:/demo.txt");
        InputStreamReader reader = new InputStreamReader(fin);
        BufferedReader buffReader = new BufferedReader(reader);
        String strTmp = "";
        String []arr;
        while((strTmp = buffReader.readLine())!=null){
            Student s = new Student();
            arr=strTmp.split("\t");
            s.setId(arr[0]);
            s.setName(arr[1]);
            s.setPhone(arr[2]);
            s.setMajor(arr[3]);
            student.add(s);
        }

        buffReader.close();
    }
    public static void clear(){//idea没有清屏命令，打印50空白行简陋实现
        for (int i=0;i<50;i++)
            System.out.println();
    }
}
class Student {//隐私学生类，防止外面函数访问，只能通过类接口访问
    private String id;
    private String name;
    private String phone;
    private String major;
    public Student() {
    }
    public Student(String id, String name, String phone, String major) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.major = major;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public void print_information() {
        System.out.printf("%s" + "\t" + "%s" + "\t" + "%s"+"\t"+"%s"+"\t"+"\n", getId(), getName(), getPhone(), getMajor());
    }
}
