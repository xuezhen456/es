package com.baizhi.testes;


import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

public class TestElasticSearch {
    private TransportClient transportClient;

    @Before
    public void prefix() throws UnknownHostException {
        transportClient = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(new TransportAddress(InetAddress.getByName("192.168.198.21"), 9300));
    }

    /*添加*/
    @Test
    public void testCreate() throws IOException, ExecutionException, InterruptedException {
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder().startObject()
                .field("name", "爱国者")
                .field("age", 18)
                .field("bir", new Date())
                .field("content", "强强强强强强强强")
                .endObject();
        IndexResponse indexResponse = transportClient.prepareIndex("dangdang", "xdd")
                .setSource(xContentBuilder).
                        execute().get();
    }

    /*更新索引记录*/
    @Test
    public void testUpdate() throws IOException, ExecutionException, InterruptedException {
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder().startObject()
                .field("name", "周杰伦").endObject();
        UpdateResponse updateResponse = transportClient.prepareUpdate("dangdang", "xdd", "JXzIS20BipiGXNY-m0Xd")
                .setDoc(xContentBuilder).execute().get();
    }

    @Test
    public void m1() {

        List<String> strings = Arrays.asList("s", "s");
        Iterator<String> iterator = strings.iterator();
        //  strings.forEach(s-> System.out.println(s));
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        test.m1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Callable<String> callable = new Callable<String>() {
            public String call() throws Exception {
                return "";
            }
        };
        Future submit = executorService.submit(callable);
        String o = (String) submit.get();
        System.out.println(o);

        //刷新页面局部
        //        //java配置   configuration bean
        //        //自动配置
        //        //  spring  @import()

        //redis  nosql  不是sql的sql   国庆节    线程         初始状态  就绪状态  运行状态  死亡状态
        // redis hashmap  1.7  数组 链表 12 /  2  指针       1.8  数组 + 链表  + 红黑树   线性表  队 栈  串
        // 国庆节  手写 list

        //  队列  cas  乐观


        //     spring mvc

    }

    @Test
    public void mm() {


    }

    interface test {

        static void m1() {
            System.out.println(1);
            class mm {

                String in = "1";

            }
        }

        public default void test() {

            System.out.println("i am is method interface");

        }

        void m2(int ss);
    }

    class testImpl implements test {

        @Override
        public void m2(int ss) {

        }

    }

}
