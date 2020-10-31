import com.demo.dao.RoleDao;
import com.demo.dao.RoleUserDao;
import com.demo.dao.UserDao;
import com.demo.dao.impl.RoleDaoImpl;
import com.demo.dao.impl.RoleUserDaoImpl;
import com.demo.dao.impl.UserDaoImpl;
import com.demo.model.Role;
import com.demo.model.User;
import com.demo.util.MyMD5;
import com.demo.util.factory.DaoFactory;
import com.demo.util.factory.impl.DaoFactoryImpl;

public class Test {
    @org.junit.Test
    public void test(){
        DaoFactory factory = new DaoFactoryImpl();
    }
}
