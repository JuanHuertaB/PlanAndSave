package pe.edu.utp.planandsave.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by usuario on 16/06/2017.
 */
public class SubscriptionsEntity extends BaseEntity {

    public SubscriptionsEntity(Connection connection) {
        super(connection, "user_category");
    }

    public SubscriptionsEntity() {
    }

    List<Subscription> findAll(){
        return findByCriteria("");
    }

    public Subscription findById(int id){
        String criteria = " id = " + String.valueOf(id);
        return findByCriteria(criteria).get(0);
    }

    public Subscription findByName(String name){
        String criteria = " name = '" + name + "'";
        return findByCriteria(criteria).get(0);
    }

    public List<Subscription> findByCriteria(String criteria){
        String sql = getDefaultQuery() + criteria == "" ? "" : " WHERE " + criteria;
        List<Subscription> userCategories = new ArrayList<>();
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet == null) return null;
            while (resultSet.next()){
                userCategories.add(Subscription.build(resultSet));
            }
            return userCategories;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}