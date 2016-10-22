import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ZJDX on 2016/10/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class NettyTest {
//    RpcProxyFactory rpcProxyFactory=new RpcProxyFactory();
//    HelloService helloService = (HelloService) rpcProxyFactory.proxyBean(HelloService.class, 100);
//
//    @Test
//    public void getP(){
//        try {
//            helloService.say("123");
//            System.out.println("test");
//        } catch(Exception e) {
//            log.info(e.getMessage());
//        }
//    }

}
