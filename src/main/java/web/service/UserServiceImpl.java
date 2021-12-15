package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDaoHibernateImpl;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl {

    private UserDaoHibernateImpl daoHibernate;

    @Autowired
    public UserServiceImpl(UserDaoHibernateImpl daoHibernate) {
        this.daoHibernate = daoHibernate;
    }

    @Transactional
    public void addUser(User user) {
        daoHibernate.addUser(user);
    }

    public void removeUserById(long id) {
        daoHibernate.removeUserById(id);
    }

    @Transactional
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        userList = daoHibernate.getAllUsers();
        return userList;
    }
    @Transactional
    public void updateUser(User user, long id) {
        daoHibernate.updateUser(user, id);
    }
    @Transactional
    public User getUser(long id){
        return daoHibernate.getUser(id);
    }
}
