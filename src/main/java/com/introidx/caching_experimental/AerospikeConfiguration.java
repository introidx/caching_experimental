package com.introidx.caching_experimental;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.policy.ClientPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.aerospike.cache.AerospikeCacheConfiguration;
import org.springframework.data.aerospike.cache.AerospikeCacheManager;
import org.springframework.data.aerospike.convert.AerospikeCustomConversions;
import org.springframework.data.aerospike.convert.AerospikeTypeAliasAccessor;
import org.springframework.data.aerospike.convert.MappingAerospikeConverter;
import org.springframework.data.aerospike.mapping.AerospikeMappingContext;
import org.springframework.data.mapping.model.SimpleTypeHolder;

@Configuration
@EnableConfigurationProperties(AerospikeConfigurationProperties.class)
@Import(value = {MappingAerospikeConverter.class, AerospikeMappingContext.class, AerospikeTypeAliasAccessor.class
        ,AerospikeCustomConversions.class, SimpleTypeHolder.class})
public class AerospikeConfiguration {

    @Autowired
    private MappingAerospikeConverter mappingAerospikeConverter;
    @Autowired
    private AerospikeConfigurationProperties aerospikeConfigurationProperties;

    @Bean(destroyMethod = "close")
    public AerospikeClient aerospikeClient() {
        ClientPolicy clientPolicy = new ClientPolicy();
        clientPolicy.failIfNotConnected = true;
        return new AerospikeClient(clientPolicy, "127.0.0.1", 3000);
    }

    @Bean
    public AerospikeCacheManager cacheManager(AerospikeClient aerospikeClient) {
        AerospikeCacheConfiguration defaultConfiguration = new AerospikeCacheConfiguration("test");
        return new AerospikeCacheManager(aerospikeClient, mappingAerospikeConverter, defaultConfiguration);
    }
}
