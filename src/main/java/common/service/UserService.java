package common.service;

import common.DAO.UserDAOHibernateImpl;
import common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDAOHibernateImpl userDAOHibernate;

    public User getUser(String login) {
        return userDAOHibernate.getUserByLogin(login);
    }

    public int addUser(User user) {
       return userDAOHibernate.addUser(user);
    }

    public List<User> getAllUsers() {
       return userDAOHibernate.getAllUsers();
    }

    public void deleteUser(Long id) {
        userDAOHibernate.deleteUser(id);
    }

    public User getUserById(Long id) {
       return userDAOHibernate.getUserById(id);
    }

    public int updateUser(User user) {
       return userDAOHibernate.updateUser(user);
    }
}
