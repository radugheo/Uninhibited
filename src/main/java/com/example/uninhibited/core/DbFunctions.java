package com.example.uninhibited.core;

import com.example.uninhibited.generators.CarGenerator;
import com.example.uninhibited.generators.EducationGenerator;
import com.example.uninhibited.generators.HouseGenerator;
import com.example.uninhibited.generators.JobGenerator;

import java.sql.*;
import java.util.ArrayList;

public class DbFunctions {
    private static Connection conn;
    public static Connection connect(String dbName, String user, String password) {
        String url = "jdbc:postgresql://localhost:5432/" + dbName + "?user=" + user + "&password=" + password;
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url);
            if (conn != null) {
                System.out.println("Connected to the database!");
                AuditService.writeAuditLog("connected to the database");
            }
            else
                System.out.println("Failed to make connection!");
        } catch (Exception e) {
            System.out.println("something else"+e+" "+"    STOPPED HERE");
        }
        return conn;
    }

    public static void createCarTable(String tableName){
        Statement statement;
        try{
            String query = "CREATE TABLE " + tableName + "(car_id SERIAL, name VARCHAR(200), price NUMERIC(200), age NUMERIC(200), health NUMERIC(200), monthly_cost NUMERIC(200), power NUMERIC(200), color VARCHAR(200), speed NUMERIC(200), PRIMARY KEY(car_id));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Tabel " + tableName + " created");
            AuditService.writeAuditLog("created table " + tableName);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void createHouseTable(String tableName) {
        Statement statement;
        try {
            String query = "CREATE TABLE " + tableName + " (house_id SERIAL, name VARCHAR(200), price NUMERIC(200), age NUMERIC(200), health NUMERIC(200), monthly_cost NUMERIC(200), size NUMERIC(200), rooms NUMERIC(200), monthly_income NUMERIC(200), PRIMARY KEY(house_id));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table " + tableName + " created");
            AuditService.writeAuditLog("created table " + tableName);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static  void createJobTable(String tableName) {
        Statement statement;
        try {
            String query = "CREATE TABLE " + tableName + " (job_id SERIAL, name VARCHAR(200), salary NUMERIC(200), company VARCHAR(200), education_level VARCHAR(200), PRIMARY KEY(job_id));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table " + tableName + " created");
            AuditService.writeAuditLog("created table " + tableName);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createEducationTable(String tableName) {
        Statement statement;
        try {
            String query = "CREATE TABLE " + tableName + " (education_id SERIAL, name VARCHAR(200), cost NUMERIC(200), duration NUMERIC(200), type NUMERIC(200), PRIMARY KEY(education_id));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table " + tableName + " created");
            AuditService.writeAuditLog("created table " + tableName);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void insertCar(String tableName, Car car) {
        try {
            String query = "INSERT INTO " + tableName + " (name, price, age, health, monthly_cost, power, color, speed) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, car.getName());
            preparedStatement.setDouble(2, car.getPrice());
            preparedStatement.setDouble(3, car.getAge());
            preparedStatement.setDouble(4, car.getHealth());
            preparedStatement.setDouble(5, car.getMonthlyCost());
            preparedStatement.setDouble(6, car.getPower());
            preparedStatement.setString(7, car.getColor());
            preparedStatement.setDouble(8, car.getSpeed());
            preparedStatement.executeUpdate();
            AuditService.writeAuditLog("inserted car " + car + " in table " + tableName);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void insertHouse(String tableName, House house) {
        try {
            String query = "INSERT INTO " + tableName + " (name, price, age, health, monthly_cost, size, rooms, monthly_income) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, house.getName());
            preparedStatement.setDouble(2, house.getPrice());
            preparedStatement.setDouble(3, house.getAge());
            preparedStatement.setDouble(4, house.getHealth());
            preparedStatement.setDouble(5, house.getMonthlyCost());
            preparedStatement.setDouble(6, house.getSize());
            preparedStatement.setDouble(7, house.getRooms());
            preparedStatement.setDouble(8, house.getMonthlyIncome());
            preparedStatement.executeUpdate();
            AuditService.writeAuditLog("inserted house " + house + " in table " + tableName);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void insertJob(String tableName, Job job) {
        try {
            String query = "INSERT INTO " + tableName + " (name, salary, company, education_level) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, job.getName());
            preparedStatement.setDouble(2, job.getSalary());
            preparedStatement.setString(3, job.getCompany());
            preparedStatement.setString(4, job.getEducationLevel());
            preparedStatement.executeUpdate();
            AuditService.writeAuditLog("inserted job " + job + " in table " + tableName);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void insertEducation(String tableName, Education education) {
        try {
            String query = "INSERT INTO " + tableName + " (name, cost, duration, type) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, education.getName());
            preparedStatement.setDouble(2, education.getCost());
            preparedStatement.setDouble(3, education.getDuration());
            preparedStatement.setDouble(4, education.getType());
            preparedStatement.executeUpdate();
            AuditService.writeAuditLog("inserted education " + education + " in table " + tableName);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static ArrayList<Car> selectCars(String tableName) {
        try {
            String query = "SELECT * FROM " + tableName;
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            ArrayList<Car> cars = new ArrayList<>();
            while (resultSet.next()) {
                int carId = resultSet.getInt("car_id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int age = resultSet.getInt("age");
                int health = resultSet.getInt("health");
                int monthlyCost = resultSet.getInt("monthly_cost");
                int power = resultSet.getInt("power");
                String color = resultSet.getString("color");
                int speed = resultSet.getInt("speed");

                Car car = new Car(name, price, age, health, monthlyCost, power, color, speed);
                cars.add(car);
            }

            resultSet.close();
            statement.close();
            AuditService.writeAuditLog("selected all from table " + tableName);
            return cars;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static void selectHouses(String tableName) {
        try {
            String query = "SELECT * FROM " + tableName;
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int houseId = resultSet.getInt("house_id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                double age = resultSet.getDouble("age");
                double health = resultSet.getDouble("health");
                double monthlyCost = resultSet.getDouble("monthly_cost");
                double size = resultSet.getDouble("size");
                double rooms = resultSet.getDouble("rooms");
                double monthlyIncome = resultSet.getDouble("monthly_income");

                System.out.println("House ID: " + houseId);
                System.out.println("Name: " + name);
                System.out.println("Price: " + price);
                System.out.println("Age: " + age);
                System.out.println("Health: " + health);
                System.out.println("Monthly Cost: " + monthlyCost);
                System.out.println("Size: " + size);
                System.out.println("Rooms: " + rooms);
                System.out.println("Monthly Income: " + monthlyIncome);
                System.out.println("-------------------------");
            }

            resultSet.close();
            statement.close();
            AuditService.writeAuditLog("selected all from table " + tableName);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void selectJobs(String tableName) {
        try {
            String query = "SELECT * FROM " + tableName;
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int jobId = resultSet.getInt("job_id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                String company = resultSet.getString("company");
                String educationLevel = resultSet.getString("education_level");

                System.out.println("Job ID: " + jobId);
                System.out.println("Name: " + name);
                System.out.println("Salary: " + salary);
                System.out.println("Company: " + company);
                System.out.println("Education Level: " + educationLevel);
                System.out.println("-------------------------");
            }

            resultSet.close();
            statement.close();
            AuditService.writeAuditLog("selected all from table " + tableName);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void selectEducation(String tableName) {
        try {
            String query = "SELECT * FROM " + tableName;
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int educationId = resultSet.getInt("education_id");
                String name = resultSet.getString("name");
                double cost = resultSet.getDouble("cost");
                double duration = resultSet.getDouble("duration");
                double type = resultSet.getDouble("type");

                System.out.println("Education ID: " + educationId);
                System.out.println("Name: " + name);
                System.out.println("Cost: " + cost);
                System.out.println("Duration: " + duration);
                System.out.println("Type: " + type);
                System.out.println("-------------------------");
            }

            resultSet.close();
            statement.close();
            AuditService.writeAuditLog("selected all from table " + tableName);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void updateName(String table_name, String old_name, String new_name){
        Statement statement;
        try {
            String query = String.format("update %s set name='%s' where name='%s'", table_name, new_name, old_name);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Updated");
            AuditService.writeAuditLog("updated table " + table_name + " name from " + old_name + " to " + new_name);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void deleteTable(String table_name){
        Statement statement;
        try {
            String query = String.format("drop table %s", table_name);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Deleted");
            AuditService.writeAuditLog("deleted table " + table_name);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void deleteAllObjects(String tableName) {
        try {
            String query = "DELETE FROM " + tableName;
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("All data deleted from table " + tableName);
            statement.close();
            AuditService.writeAuditLog("deleted all from table " + tableName);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void populateDatabase(){
        try {
            conn = DbFunctions.connect("uninhibited", "postgres", "admin");
            // create tables
            DbFunctions.createCarTable("cars");
            DbFunctions.createHouseTable("houses");
            DbFunctions.createJobTable("jobs");
            DbFunctions.createEducationTable("education");
            // insert data
            ArrayList<Car> cars = CarGenerator.getCars();
            for (Car car : cars) {
                DbFunctions.insertCar("cars", car);
            }
            System.out.println("Cars inserted");
            ArrayList<House> houses = HouseGenerator.getHouses();
            for (House house : houses) {
                DbFunctions.insertHouse("houses", house);
            }
            System.out.println("Houses inserted");
            ArrayList<Job> jobs = JobGenerator.getJobs();
            for (Job job : jobs) {
                DbFunctions.insertJob("jobs", job);
            }
            System.out.println("Jobs inserted");
            ArrayList<Education> educations = EducationGenerator.getEducations();
            for (Education education : educations) {
                DbFunctions.insertEducation("education", education);
            }
            System.out.println("Educations inserted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}