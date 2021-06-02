package com.example.demoelastic;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends ElasticsearchRepository<Order, String> {

}