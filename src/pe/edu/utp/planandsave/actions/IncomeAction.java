package pe.edu.utp.planandsave.actions;

import com.opensymphony.xwork2.ActionSupport;
import pe.edu.utp.planandsave.models.*;
import pe.edu.utp.planandsave.services.PSService;

import java.util.Date;

/**
 * Created by Abraham on 15/07/2017.
 */
public class IncomeAction extends ActionSupport {
    private int id;
    private float amount;
    private String description;
    private Date registration_date;
    private User user;
    private int currency;
    private Income income;

    private SubscriptionsEntity subscriptionsEntity;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public Income getIncome() {
        return income;
    }

    public void setIncome(Income income) {
        this.income = income;
    }

    public String add(){
        PSService PSS = new PSService();
        User user = new User();
        income = new Income(id,amount,description,registration_date,PSS.getUsersById(user.getId(),subscriptionsEntity),PSS.getCurrenciesById(currency));
        try {
            PSS.createIncome(income);
            return SUCCESS;
        }catch(Exception e) {
            e.printStackTrace();
            return "input";
        }
    }

    public  String execute(){
        return SUCCESS;
    }


}

