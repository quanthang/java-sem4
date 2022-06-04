import com.example.t2009m1_helloworld.Model.MySqlUserModel;
import com.example.t2009m1_helloworld.Model.User;
import org.junit.jupiter.api.Test;

public class TestUser {
    @Test
    public void TestCreateUser(){
        User user = new User();
        user.setUsername("hihi");
        user.setPasswordHash("123");
        user.setStatus(1);

        MySqlUserModel mySqlUserModel = new MySqlUserModel();
        boolean result = mySqlUserModel.save(user);
        System.out.println(result);
    }
}
