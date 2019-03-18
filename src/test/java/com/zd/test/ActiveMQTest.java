package com.zd.test;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.*;
import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/spring-*.xml")
public class ActiveMQTest {

    /** 
    * @Description: ActiveMQ的P2P，生产者producer发送消息
    * @Param: []
    * @return: void
    * @Author: zhangdong 
    * @Date: 2019/3/6
    */ 
    @Test
    public void producerTest() throws JMSException, InterruptedException {
//        1.获得连接工厂
        ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory("tcp://192.168.254.68:61616");
//        2.通过连接工厂获得连接对象
        Connection connection = connectionFactory.createConnection();
//        3.启动连接
        connection.start();
//        4.获得回话对象
//        第一个参数：是否开启事务，true为开启，第二个参数忽略
//        第二个参数：当第一个参数为false才有意义。消息应答模式：1、自动应答 2、手动应答，一般为自动应答即可
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//        5.创建destination对象，参数是队列名称
        Queue queue = session.createQueue("test-queue");
//        6.通过session创建生产者
        MessageProducer producer = session.createProducer(queue);
//        7.通过session创建消息
        TextMessage textMessage = session.createTextMessage("Hello ActiveMQ");
//        8.发送消息
        producer.send(textMessage);
        Thread.sleep(10*1000);
//        9.关闭资源
        producer.close();
        session.close();
        connection.close();
    }


    /** 
    * @Description: ActiveMQ的consumer异步接收数据
    * @Param: []
    * @return: void
    * @Author: zhangdong 
    * @Date: 2019/3/6
    */ 
    @Test
    public void consumerTest() throws JMSException, IOException, InterruptedException {
        ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory("tcp://192.168.254.68:61616");
//        ConnectionFactory connectionFactory =
//                new ActiveMQConnectionFactory("admin","admin","tcp://192.168.254.68:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("test-queue");
//        创建消费者consumer
        MessageConsumer consumer = session.createConsumer(queue);
//        接收消息
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    String text = textMessage.getText();
                    System.out.println(text);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
//        System.in.read();
        Thread.sleep(30*1000);
//        关闭资源
        consumer.close();
        session.close();
        connection.close();
    }

}
