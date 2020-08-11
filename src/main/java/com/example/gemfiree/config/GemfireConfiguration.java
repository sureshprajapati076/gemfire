package com.example.gemfiree.config;


import com.example.gemfiree.domain.RandomUser;
import org.apache.geode.cache.DataPolicy;
import org.apache.geode.cache.GemFireCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

import java.util.Properties;

@Configuration
@ComponentScan
@EnableGemfireRepositories(basePackages = "com.example.gemfiree.repository")
public class GemfireConfiguration {


    @Bean
    Properties gemfireProperties() {
        Properties gemfireProperties = new Properties();
        gemfireProperties.setProperty("name", "SpringDataGemFireApplication");
        gemfireProperties.setProperty("mcast-port", "0");
        gemfireProperties.setProperty("log-level", "config");
        return gemfireProperties;
    }

    @Bean
    CacheFactoryBean gemfireCache() {
        CacheFactoryBean gemfireCache = new CacheFactoryBean();
        gemfireCache.setClose(true);
        gemfireCache.setProperties(gemfireProperties());
        return gemfireCache;
    }


    @Bean(name = "users")
    @Autowired
    LocalRegionFactoryBean<String, RandomUser> getUsers(final GemFireCache cache) {
        LocalRegionFactoryBean<String, RandomUser> addressRegion = new LocalRegionFactoryBean<>();
        addressRegion.setCache(cache);
        addressRegion.setClose(false);
        addressRegion.setName("users");
        addressRegion.setPersistent(false);
        addressRegion.setDataPolicy(DataPolicy.PRELOADED);
        return addressRegion;
    }


}


