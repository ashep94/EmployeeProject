package finalproject;

public class Employee {

    protected int id;
    protected String lastName;
    protected String firstName;
    protected String address;
    protected String address2;
    protected String city;
    protected String state;
    protected String DOB;
    protected double salary;

    public Employee() {

    }

    public Employee(String LN, String FN, String add, String add2, String city, String state, String dob, double n) {

        this.lastName = LN;
        this.firstName = FN;
        this.address = add;
        this.address2 = add2;
        this.city = city;
        this.state = state;
        this.DOB = dob;
        this.salary = n;

    }

    public Employee(int id, String LN, String FN, String add, String add2, String city, String state, String dob, double salary) {
        this.id = id;
        this.lastName = LN;
        this.firstName = FN;
        this.address = add;
        this.address2 = add2;
        this.city = city;
        this.state = state;
        this.DOB = dob;
        this.salary = salary;

    }

    public int getID() {

        return this.id;
    }

    public void setID(int n) {
        this.id = n;
    }

    public String getLName() {
        return this.lastName;
    }

    public void setLName(String LN) {
        this.lastName = LN;

    }

    public String getFName() {
        return this.firstName;
    }

    public void setFName(String FN) {
        this.firstName = FN;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;

    }

    public String getAddress2() {
        return this.address2;
    }

    public void setAddress2(String address2) {
        
        this.address2 = address2;
          
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {

        this.city = city;

    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDOB() {
        return this.DOB;
    }

    public void setDOB(String n) {
        this.DOB = n;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double n) {
        this.salary = n;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("EMPLOYEE ID: " + this.id + "\n");
        sb.append("EMPLOYEE LASTNAME: " + this.lastName + "\n");
        sb.append("EMPLOYEE FIRSTNAME: " + this.firstName + "\n");
        sb.append("EMPLOYEE ADDRESS: " + this.address + "\n");
        sb.append("EMPLOYEE ADDRESS2: " + this.address2 + "\n");
        sb.append("EMPLOYEE CITY: " + this.city + "\n");
        sb.append("EMPLOYEE STATE: " + this.state + "\n");
        sb.append("EMPLOYEE DOB: " + this.DOB + "\n");
        sb.append("EMPLOYEE SALARY: " + this.salary + "\n");

        return sb.toString();

    }

}
