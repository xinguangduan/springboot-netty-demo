package io.springboot.netty.ws4;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName WebSocketTest
 * @Description: websocket 并发测试类
 * @Author
 * @Date 2020/1/6 10:00
 * @Version V1.0
 **/
public class WebSocketTest {

    public static void main(String[] args) {

        String urlPre = "ws://localhost:8090/websocket/";
        int threadNum = 1;
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++) {
            String url = urlPre +"NO"+i+"?token=123";
            new WebSocketClientTest(url, countDownLatch).start();
            countDownLatch.countDown();

        }
    }
}
