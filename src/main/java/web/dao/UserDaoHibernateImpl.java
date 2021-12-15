package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoHibernateImpl {

    @PersistenceContext
    private EntityManager entityManager;


    public void addUser(User user) {
        entityManager.persist(user);
    }


    public void removeUserById(long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    public void updateUser(User user, long id) {
        user.setId(id);
        entityManager.merge(user);
    }
    public User getUser(long id){
        User user = entityManager.find(User.class, id);
        return user;
    }
}
