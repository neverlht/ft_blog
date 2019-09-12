import com.fairyt.base.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Created by yhl on 2018/9/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestController {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void test1(){
    }
}
