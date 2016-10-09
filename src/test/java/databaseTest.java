import com.smartcity.dao.APIMapper;
import com.smartcity.models.API;
import com.smartcity.models.User;
import com.smartcity.services.intf.IUserService;
import com.smartcity.ultis.MD5Ultis;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ZJDX on 2016/6/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class databaseTest {
    private static Logger log = LoggerFactory.getLogger(databaseTest.class);

    @Autowired
    APIMapper apiMapper;
    @Autowired
    IUserService userService;

    @Test
    public void getAPI(){
        try {
            API api = apiMapper.selectByPrimaryKey(1);
            System.out.println(apiMapper.selectByPrimaryKey(1).getOriginalapi());
        } catch(Exception e) {
            log.info(e.getMessage());
        }
    }
    @Test
    public void saveUser(){
        try {
            User newUser=new User();
            newUser.setIdcardnumber("123456789012345678");
            newUser.setPhonenum("13071893707");
            newUser.setSex("female");
            newUser.setUsername("wenqin");
            newUser.setPassword(MD5Ultis.getMD5("12345678"));
            System.out.println(newUser.getPassword());
            int result=userService.save(newUser);
            System.out.println(result);
            System.out.println(userService.findById(1).toString());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void deletUser(){
        try {
            userService.delete(2);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
