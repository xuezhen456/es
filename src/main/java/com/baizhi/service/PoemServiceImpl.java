package com.baizhi.service;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
@Slf4j
public class PoemServiceImpl implements PoemService {
    @Autowired
    TransportClient transportClient;

    @Override
    public List<Object> queryAll(String key) throws Exception {
//        List<Poem> poems = queryAll();
        QueryStringQueryBuilder field = QueryBuilders.queryStringQuery(key).field("name").field("author").field("content").field("type");
        SearchResponse searchResponse = transportClient.prepareSearch("poems").setTypes("poem").setQuery(field).execute().get();
        SearchHit[] hits = searchResponse.getHits().getHits();
        List<Object> list = new ArrayList<Object>();
        for (SearchHit hit : hits) {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            list.add(sourceAsMap);
        }
        return list;
    }

 /*   public  List<Object> selectAll(String key) throws ExecutionException, InterruptedException {
        List<Poem> poems = poemMapper.queryAll();
        QueryStringQueryBuilder field = QueryBuilders.queryStringQuery(key).field("name").field("author").field("content").field("type");
        SearchResponse searchResponse = transportClient.prepareSearch("poems").setTypes("poem").setQuery(field).execute().get();
        SearchHit[] hits = searchResponse.getHits().getHits();
        List<Object> list =new ArrayList<Object>();
        for (SearchHit hit : hits) {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            list.add(searchResponse);
        }
        return  list;
    }
*/

  /*      TransportClient transportClient= null;
        try {
            transportClient = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(new TransportAddress(InetAddress.getByName("192.168.198.21"),9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        XContentBuilder xContentBuilder = null;
        for (Poem poem : poems) {
        try {
            xContentBuilder = XContentFactory.jsonBuilder().startObject()
                    .field("name",poem.getName())
                    .field("author", poem.getAuthor())
                    .field("type", poem.getType())
                    .field("content",poem.getContent()).endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        IndexResponse indexResponse = null;
        try {
            indexResponse = transportClient.prepareIndex("poems", "poem").setSource(xContentBuilder).execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        }
        try {
            MathAll();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/


    /*
     * 关键字搜索    全部搜索
     * */

   /* public  void MathAll() throws UnknownHostException, ExecutionException, InterruptedException {

        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
        TransportClient transportClient = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(new TransportAddress(InetAddress.getByName("192.168.198.21"), 9300));
        SearchResponse searchResponse = transportClient.prepareSearch("poems")
                .setTypes("poem")
                .setQuery(matchAllQueryBuilder).setFrom(0).setSize(999)
                .execute()
                .get();
        SearchHits hits = searchResponse.getHits();
        SearchHit[] hits1 = hits.getHits();
        for (SearchHit documentFields : hits1) {
            String sourceAsString = documentFields.getSourceAsString();
        }
    }*/


}





