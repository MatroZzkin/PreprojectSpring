package common.DAO;


import common.config.DBConfig;
import common.model.User;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.List;

@Transactional
@Repository
public class UserDAOHibernateImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public int addUser (User user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<User> getAllUsers() {
        return entityManager.createQuery("from " +  User.class.getName()).getResultList();
    }

    public void deleteUser (Long id) {
       entityManager.remove(getUserById(id));
    }

    public User getUserById(Long id) {
       return entityManager.find(User.class, id);
    }

    public User getUserByLogin(String login) {
        Query query = entityManager.createQuery("select user from User user where user.login = :login");
        return null;
    }

    public int updateUser (User user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.getTransaction().commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
