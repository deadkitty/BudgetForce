/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetforce;

import budgetforce.model.DatabaseManager;
import budgetforce.model.Income;
import java.util.ArrayList;
/**
 *
 * @author David
 */
public class BudgetForce {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Income income = new Income();
        //DatabaseManager db = new DatabaseManager();
        
        //income = db.getIncomeByID(1);
        
        //System.out.print(income.getTimestamp());
        
        Income incomeTmp = new Income();
        ArrayList income2 = new ArrayList<Income>();
        DatabaseManager db2 = new DatabaseManager();
        income2 = db2.getIncomeByPersonID(1);
        incomeTmp = (Income) income2.get(0);
        
        System.out.print(incomeTmp.getName());
        //System.out.print(incomeTmp.getAmount());
        
    }
}
