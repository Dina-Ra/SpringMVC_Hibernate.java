package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.dao.UserDaoHibernateImpl;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao daoHibernate;

    @Autowired
    public UserServiceImpl(UserDao daoHibernate) {
        this.daoHibernate = daoHibernate;
    }

    @Transactional
    @Override
    public void addUser(User user) {
        daoHibernate.addUser(user);
    }

    @Override
    public void removeUserById(long id) {
        daoHibernate.removeUserById(id);
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        userList = daoHibernate.getAllUsers();
        return userList;
    }

    @Transactional
    @Override
    public void updateUser(User user, long id) {
        daoHibernate.updateUser(user, id);
    }

    @Transactional
    @Override
    public User getUser(long id){
        return daoHibernate.getUser(id);
    }
}
