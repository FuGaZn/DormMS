import com.demo.dao.UserDao;
import com.demo.dao.impl.UserDaoImpl;
import com.demo.model.User;
import com.demo.util.MyMD5;

public class Test {
    @org.junit.Test
    public void test(){
        User user = new User("fjx","123456");
        UserDao userDao = new UserDaoImpl();
        userDao.createUser(user);
    }
}
