package pe.edu.utp.planandsave.actions;

import com.opensymphony.xwork2.ActionSupport;
import pe.edu.utp.planandsave.models.Expense;
import pe.edu.utp.planandsave.models.User;
import pe.edu.utp.planandsave.services.PSService;

import java.sql.Date;

/**
 * Created by Abraham on 15/07/2017.
 */
public class ExpenseAction extends ActionSupport {
    private int id;
    private float amount;
    private Date registration_date;
    private String description;
    private User user;
    private int expensecategory;
    private int currency;
    private Expense expense;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getExpensecategory() {
        return expensecategory;
    }

    public void setExpensecategory(int expensecategory) {
        this.expensecategory = expensecategory;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }


    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    public String add() {
        PSService PSS = new PSService();
        expense = new Expense(id, amount, registration_date, description, user, PSS.getExpenseCategoriesById(expensecategory), PSS.getCurrenciesById(currency));
        try {
            PSS.createExpense(expense);
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return "input";
        }

    }

    public String execute() {
        return SUCCESS;
    }

}
