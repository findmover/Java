import java.sql.*;

public class Main {
    static Connection connection = null;
    static Statement statement = null;
    static ResultSet resultSet = null;
    public static void main(String[] args) {
        connect();
        String createTableSQL = "CREATE TABLE Students(SNO VARCHAR(20),Name Varchar(10),Age Integer,College Varchar(30))";
        CreateTable(createTableSQL);
        System.out.println("----------第一题的效果----------");
        String insertSQL="insert into Students (SNO,Name,Age,College) values ('s001','老大',20,'计算机学院'),('s002','老二',19,'计算机学院'),('s003','老三',18,'计算机学院'),('s004','老四',17,'计算机学院')";
        insert(insertSQL);
        show();
        System.out.println("----------第二题的效果----------");
        show();
        System.out.println("----------第三题的效果----------");
        String delSQL="delete from Students where sno='s004'";
        delete(delSQL);
        show();
        System.out.println("----------第四题的效果----------");
        String selectSQL="select *from students where sno='s003'";
        select(selectSQL);
        System.out.println("----------第五题的效果----------");
        String upSQL="update Students set College='通信学院' where sno='s001'";
        update(upSQL);
        show();
        close();

    }
    public static void connect(){
        //connect
        String url = ("jdbc:mysql://localhost:3306/mysql");
        String username = "root";
        String password = "123456";
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("连接到数据库！");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void CreateTable(String createTableSQL){
        //create table
        try {
            statement = connection.createStatement();
            statement.executeUpdate(createTableSQL);
            System.out.println("Students 表创建成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void insert(String insertSQL){
        //添加数据
        try {
            statement = connection.createStatement();
            statement.executeUpdate(insertSQL);
            System.out.println("添加数据成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void delete(String delSQL){
        try{
            statement=connection.createStatement();
            statement.executeUpdate(delSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void select(String selectSQL) {
       ResultSet result;
        try {
           statement=connection.createStatement();
           result=statement.executeQuery(selectSQL);
           while(result.next()){
               String SNO=result.getString("sno");
               String Name=result.getString("name");
               int age=result.getInt("Age");
               String college=result.getString("College");
               System.out.println("SNO  Name  Age  College\t");
               System.out.println(SNO +"  "+Name+"  "+age+"  "+college);
           }
       }catch(SQLException e) {
           e.printStackTrace();
       }
    }
    public static void update( String upSQL) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate(upSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void show(){
        //显示数据
        try {
            statement = connection.createStatement();
            String showSQL = "SELECT * FROM Students";
            resultSet = statement.executeQuery(showSQL);
            int columnCount = resultSet.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(resultSet.getMetaData().getColumnName(i) +"  ");
            }
            System.out.println();
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + "  ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(){
        //关闭连接
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}