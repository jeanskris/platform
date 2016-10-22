import com.smartcity.models.selfDefined.HttpRequest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ZJDX on 2016/6/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class testHttpGet {
    @Test
    public void getAPI(){
        try {
            HttpRequest hr=new HttpRequest();
            Object result=hr.sendPost("http://localhost:8083/stop","");
            System.out.println(result);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void getAllAPPList(){
        try {
            HttpRequest hr=new HttpRequest();
            String result=(String)hr.sendGet("http://localhost:8081/getAllAPPList","");
            JSONArray jsonArray = new JSONArray(result);
            System.out.println(result);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void getAPPLogo(){
        try {
            HttpRequest hr=new HttpRequest();
            String result=(String)hr.sendGet("http://localhost:8081/getAPPLogo","{'logoName':'11233.png'}");
            JSONObject json  = new JSONObject(result);
            System.out.println(json);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
/*    @Test
    public void register(){
        try {
            HttpRequest hr=new HttpRequest();
            String result=(String)hr.sendPost("http://localhost:8081/registerUser","123456","0000000");
            System.out.println(result);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }*/
}
