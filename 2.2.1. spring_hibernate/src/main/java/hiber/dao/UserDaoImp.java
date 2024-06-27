package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User getUserByCarModelAndSeries(String model, Integer series) {
        try {
            List<User> query = sessionFactory
                    .getCurrentSession()
                    .createQuery("from User u where u.car.model = ?1 and u.car.series = ?2", User.class)
                    .setParameter(1, model)
                    .setParameter(2, series)
                    .getResultList();

            return query.get(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("There is no such user with that car");
        }
        return null;
    }
}