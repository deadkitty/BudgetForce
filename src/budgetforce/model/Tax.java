/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package budgetforce.model;

/**
 *
 * @author David
 */
public class Tax {

    //---------------------------------------------------
    // Get and set functions
    //---------------------------------------------------
    public int getM_Id() {
        return m_Id;
    }

    public void setM_Id(int m_Id) {
        this.m_Id = m_Id;
    }

    public float getM_Amount() {
        return m_Amount;
    }

    public void setM_Amount(float m_Amount) {
        this.m_Amount = m_Amount;
    }

    public String getM_Type() {
        return m_Type;
    }

    public void setM_Type(String m_Type) {
        this.m_Type = m_Type;
    }

    public boolean isM_SystemFlag() {
        return m_SystemFlag;
    }

    public void setM_SystemFlag(boolean m_SystemFlag) {
        this.m_SystemFlag = m_SystemFlag;
    }

    //---------------------------------------------------
    // Private variables
    //---------------------------------------------------
    private int     m_Id;
    private float   m_Amount;
    private String  m_Type;
    private boolean m_SystemFlag;
}