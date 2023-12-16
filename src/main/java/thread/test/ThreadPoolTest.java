package thread.test;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;

public class ThreadPoolTest {
    @Resource
    private ThreadPoolTaskExecutor executor;

    public void thread1 () {
        System.out.println("线程一，已执行！");



    }


}
