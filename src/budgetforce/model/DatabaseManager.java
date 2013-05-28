
package budgetforce.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author David König
 */
/*
 * @sources
 *  http://ohdevon.wordpress.com/2011/09/19/postgresql-to-netbeans-2/
 */
 
public class DatabaseManager {
    
    private Connection connection   = null;
    private String databaseUser     = "postgres";
    private String databasePw       = "pgr4";
    private String url              = "jdbc:postgresql://localhost:5432/BudgetForce";
    private String driver           = "org.postgresql.Driver";
    
    
    private void establishConnection()
    {
        if (connection != null)
            return;
      
        try
        {
           Class.forName(driver);
          
           connection = DriverManager.getConnection(url, databaseUser, databasePw);
           
           if (connection != null) {
               System.out.println("Connecting to database...");
           }
        } 
        catch(Exception e)
        {
            System.out.println("Problem when connecting to the database");
        }
    }
    
    private void closeConnection()
    {
        try
        {
            connection.close();
        }
        catch(Exception e)
        {
            System.out.println("Problem to close the connection to the database");
        }
    }
    
    /*
    //Address stuff
    public Address getAddressByID(int _id)
    {}
    
    public Address[] getAddressByPersonID(int _personID) //should return an array
    {}
    
    public boolean insertAddress(Address _address)
    {}
    
    public boolean updateAddress(Address _address)
    {}
    
    public boolean deleteAddress(Address _address)
    {}
    
    //Budget stuff
    public Budget getBudgetByID(int _id)
    {}
    
    public Budget[] getBudgetByPersonID(int _personID) //should return an array
    {}
    
    public Budget[] getBudgetByProjectID(int _projectID)
    {}
    
    public Budget[] getBudgetByBudgetID(int _budgetID)
    {}
    
    public boolean insertBudget(Budget _budget)
    {}
    
    public boolean updateBudget(Budget _budget)
    {}
    
    public boolean deleteBudget(int _id)
    {}
    
    
    //Category stuff
    public Category getCategoryByID(int _id)
    {}
    
    public boolean insertCategory(Category _category)
    {}
    
    public boolean updateCategory(Category _category)
    {}
    
    public boolean deleteCategory(int _id)
    {}
    */
    
    //Income stuff
    public Income getIncomeByID(int _id)
    {
        establishConnection();
        
        ResultSet rs = null;
        Statement s = null;
        
        Income income = new Income();
        
        try
        {
            s = connection.createStatement();
            String query = "SELECT * FROM income WHERE id = " + _id;
            rs = s.executeQuery(query);
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
        }
        
        try {
            while(rs.next())
            {  
                income.setId(rs.getInt("id"));
                income.setName(rs.getString("name"));
                income.setAmount(rs.getFloat("amount"));
                income.setPeriod(rs.getString("period"));
                income.setStart(rs.getDate("start"));
                income.setEnd(rs.getDate("end"));
                income.setTimestamp(rs.getDate("timestamp"));
                income.setPersonID(rs.getInt("personID"));
                income.setIncomeID(rs.getInt("incomeID"));
            }
        } 
        
        catch(Exception e)
        {
            System.out.println("Problem when filling into Element");
        }
        
        closeConnection();
        
        return income;
    }
    
    
    public ArrayList<Income> getIncomeByPersonID(int _id)
    {
        establishConnection();
        
        ResultSet rs = null;
        Statement s = null;
        
        ArrayList    incomeArray     = new ArrayList<Income>();
        Income       tmpIncome       = new Income();
        
        try
        {
            s = connection.createStatement();
            String query = "SELECT * FROM income WHERE personID = " + _id;
            rs = s.executeQuery(query);
        }
        
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
        }
        
        try {
            while(rs.next())
            {         
                tmpIncome.setId(rs.getInt("id"));
                tmpIncome.setName(rs.getString("name"));
                tmpIncome.setAmount(rs.getFloat("amount"));
                tmpIncome.setPeriod(rs.getString("period"));
                tmpIncome.setStart(rs.getDate("start"));
                tmpIncome.setEnd(rs.getDate("end"));
                tmpIncome.setTimestamp(rs.getDate("timestamp"));
                tmpIncome.setPersonID(rs.getInt("personID"));
                tmpIncome.setIncomeID(rs.getInt("incomeID"));
                
                incomeArray.add(tmpIncome);
            }
        } 
        
        catch(Exception e)
        {
            System.out.println("Problem when filling into Element");
        }
        
        closeConnection();
        
        return incomeArray;
    }
    /*
    public Income[] getIncomeByIncomeID(int _incomeID)
    {}
    
    public boolean insertIncome(Income _income)
    {}
    
    public boolean updateIncome(Income _income)
    {}
    
    public boolean deleteIncome(int _id)
    {}
    
            
    //Login stuff
    public Login getLoginByUsername(int _id)
    {}
    
    public Login getLoginByPersonID(int _personID)
    {}
    
    public boolean insertLogin(Login _login)
    {}
    
    public boolean updateLogin(Login _login)
    {}
    
    public boolean updateLoginPassword(String _username, String _password)
    {}
    
    public boolean updateLoginSecurityQuestion(String _username, String _securityQestion)
    {}
    
    public boolean deleteLogin(String _username)
    {}
    
    
    //Outgoing Stuff
    public Outgoing getOutgoingByID(int _id)
    {}
    
    public Outgoing[] getOutgoingByBudgetID(int _budgetID)
    {}
    
    public Outgoing[] getOutgoingByCategoryID(int _categoryID)
    {}
    
    public boolean insertOutgoing(Outgoing _outgoing)
    {}
    
    public boolean updateOutgoing(Outgoing _outgoing)
    {}
    
    public boolean deleteOutgoing(int _id)
    {}
    
    
    //OutgoingHasTax stuff
    public OutgoingHasTax getOutgoingHasTaxByID(int _outgoingID, int _taxID)
    {}
    
    public boolean insertOutgoingHasTaxByID(OutgoingHasTax _outgoingHasTax)
    {}
    
    public boolean updateOutgoingHasTax(OutgoingHasTax _outgoingHasTax)
    {}
    
    public OutgoingHasTax deleteOutgoingHasTaxByID(int _outgoingID, int _taxID)
    {}
    
    
    //Person stuff
    public Person getPersonByID(int _id)
    {}
    
    public boolean insertPerson(Person _person)
    {}
    
    public booleanean updatePerson(Person _person)
    
    public boolean deletePerson(int _id)
    {}
    
    
    //Project stuff
    public Project getProjectByID(int _projectID)
    {}
    
    public boolean insertProject(Project _project)
    {}
    
    public boolean updateProject(Project _project)
    {}
    
    public boolean deleteProject(int _id)
    {}
    
    
    //SystemNotification stuff
    public SystemNotification getSystemNotificationByID(int _id)
    {}
    
    public boolean insertSystemNotification(SystemNotification _systemNotification)
    {}
    
    public boolean updateSystemNotification(SystemNotification _systemNotification)
    {}
    
    public boolean deleteSystemNotification(int _id)
    {}
    
    
    //Tax stuff
    public Tax getTaxByID(int _id)
    {}
    
    public boolean insertTax(Tax _tax)
    {}
    
    public boolean updateTax(Tax _tax)
    {}
    
    public boolean deleteTax(int _id)
    {}
    */
    
    //Testing stuff
    /*
    public ResultSet giveName()
    {
        ResultSet rs = null;
        Statement s = null;
        try
        {
            s = connection.createStatement();
            
            rs = s.executeQuery("SELECT * FROM address");
        }
        catch(Exception e)
        {
            System.out.println("Problem in searching the database");
        }
        return rs;
    }


    public static void main (String[] args) throws SQLException
    {
        DatabaseManager x = new DatabaseManager();
        ResultSet rs = null;
        String string = "";

        x.establishConnection();
        rs = x.giveName();
        
        try {
        while(rs.next())
        {  
            string += rs.getString(1) + "," + rs.getString(2) + "\n";
        }

        JOptionPane.showMessageDialog(null, string, "Test", 1);
        } 
        
        catch(Exception e)
        {
            System.out.println("Problem when printing the database.");
        }
        x.closeConnection();
    }
    * */
    
    public static void main (String[] args) throws SQLException
    {
        Income income = new Income();
        DatabaseManager db = new DatabaseManager();
        
        income = db.getIncomeByID(1);
        
        System.out.print(income.getTimestamp());
    }
}
