package thread.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import thread.ThreadPoolTest;

@Configuration
public class UrlUtil {
    @Value("${text.url}")
    private String url;

    @Bean
    public ThreadPoolTest threadPoolTest(){
        System.out.println(url);
        return new ThreadPoolTest();
    }

}
