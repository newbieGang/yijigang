package thread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;


@SpringBootApplication()
public class YjgStarterTask {
    public static void main(String[] args) {
        SpringApplication.run(YjgStarterTask.class,args);
    }
}
