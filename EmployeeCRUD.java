
package finalproject;
import java.sql.*;
import java.sql.SQLException;


public class EmployeeCRUD {
    final private String jdbcURL = "jdbc:mysql://localhost:3306/EmployeeDB";
    final private String jdbcUsername = "root";
    final private String jdbcPassword = "Amber1906";
    
    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO Employee(EmpLName, EmpFname, " 
            +"EmpAddress1, EmpAddress2, EmpCity, EmpState, EmpDOB, EmpBaseSalary)"
            +"VALUE(?,?,?,?,?,?,?,?)";
    
    private static final String SELECT_EMPLOYEE_BY_ID = "SELECT EmpID, EmpLName, EmpFName, EmpAddress1, EmpAddress2, "
            + "EmpCity, EmpState, EmpDOB, EmpBaseSalary FROM Employee WHERE EmpID = ?";
    
    private static final String DELETE_EMPLOYEE_SQL = "DELETE FROM Employee WHERE EmpID = ?";
    
    private static final String UPDATE_EMPLOYEE_SQL = "UPDATE Employee SET EmpLName = ?, EmpFName = ?, EmpAddress1 = ?, "
            + "EmpAddress2 = ?, EmpCity = ?, EmpState = ?, EmpDOB = ?, EmpBaseSalary = ? WHERE EmpID = ?";
   
    public EmployeeCRUD(){
        
    }
    
    protected Connection getConnection(){
        Connection conn = null;
        try{
            
            conn =  DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            
        } catch(SQLException e){
            
        }
        
        return conn;
    }
    
    public void insertEmployee(Employee emp){
        try(
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement(INSERT_EMPLOYEE_SQL);
            ){
            
            ps.setString(1,emp.getLName());
            ps.setString(2,emp.getFName());
            ps.setString(3,emp.getAddress());
            ps.setString(4,emp.getAddress2());
            ps.setString(5,emp.getCity());
            ps.setString(6,emp.getState());
            ps.setString(7,emp.getDOB());
            ps.setDouble(8,emp.getSalary());
            ps.executeUpdate();
        }
        
        
        catch(SQLException e){
            
            e.printStackTrace();
        }
            
    }    
    
    public Employee selectEmployee(int ID)
    {
        Employee employee = null;
        try
        (Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement(SELECT_EMPLOYEE_BY_ID);     
        )
        { 
            ps.setInt(1, ID); 
            ResultSet rs = ps.executeQuery();
            String LN = "",FN = "", address = "", address2 = "", city = "" , state = "", DOB = "";
            double salary = 0;
            
            rs.next();
            LN       = rs.getString(2); // Last Name
            FN       = rs.getString(3); // First Name
            address  = rs.getString(4); // Address 1
            address2 = rs.getString(5); // Address 2
            city     = rs.getString(6); // City
            state    = rs.getString(7); // State
            DOB      = rs.getString(8); // DOB
            salary   = rs.getDouble(9); // Salary 
            
               
            
            employee =  new Employee(ID, LN,FN,address,address2,city,state,DOB,salary);
            
        }    
        catch(SQLException e){
            e.printStackTrace();
        }
        
        
        return employee;
    }
    
    
    public boolean deleteEmployee(int ID){
        
        
        try (Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement(DELETE_EMPLOYEE_SQL);     
            )
        {
            ps.setInt(1, ID);
            ps.executeUpdate();
            return true;
            
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        
        
    }
    
    public boolean updateEmployee(Employee emp){
        
        try (Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement(UPDATE_EMPLOYEE_SQL);     
            )
        {
            ps.setString(1, emp.getLName());
            ps.setString(2, emp.getFName());
            ps.setString(3, emp.getAddress());
            ps.setString(4, emp.getAddress2());
            ps.setString(5, emp.getCity());
            ps.setString(6, emp.getState());
            ps.setString(7, emp.getDOB());
            ps.setDouble(8, emp.getSalary());
            ps.setInt(9, emp.getID());
            
            ps.executeUpdate();
            return true;
            
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        
        
    }
     
    
    
}
    
    

    
    
        
        
    
    

