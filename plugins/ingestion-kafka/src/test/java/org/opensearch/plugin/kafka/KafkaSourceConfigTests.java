import org.opensearch.test.OpenSearchTestCase;
            new KafkaSourceConfig(100, params);
        } catch (IllegalArgumentException e) {  
    }
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
            Assert.assertEquals("topic_metadata_fetch_timeout_ms must be positive, got: -1", e.getMessage());  
            "bootstrap",  
            config.getConsumerConfigurations().get("auto.offset.reset")
            config.getConsumerConfigurations().containsKey("topic_metadata_fetch_timeout_ms")
        Assert.assertEquals("The topic should be correctly initialized and returned", "topic", config.getTopic());  
        params.put("fetch.min.bytes", 30000);
            config.getBootstrapServers()
public class KafkaSourceConfigTests extends OpenSearchTestCase {
    public void testTopicMetadataFetchTimeoutMsInvalid() {  
        Assert.assertEquals("Incorrect max.poll.records", 100, config.getConsumerConfigurations().get("max.poll.records"));
        Map<String, Object> params = new HashMap<>();
        Assert.assertFalse(  
        );
        Assert.assertEquals(
            "none",
    public void testKafkaSourceConfig() {  
    public void testTopicMetadataFetchTimeoutMsCustom() {  
    }
        params.put("enable.auto.commit", false);
        Map<String, Object> params = new HashMap<>();
            fail("Expected IllegalArgumentException for non-positive timeout");
            "The bootstrap servers should be correctly initialized and returned",
            "auto.offset.reset must be 'none' by default",  
package org.opensearch.plugin.kafka;
        params.put("topic_metadata_fetch_timeout_ms", 5000);
        KafkaSourceConfig config = new KafkaSourceConfig(100, params);  
        Map<String, Object> params = new HashMap<>();
        }
        );  
            "topic_metadata_fetch_timeout_ms should not be in consumer configurations",
import java.util.Map;
        Assert.assertEquals(
        Map<String, Object> params = new HashMap<>();
        }
        params.put("bootstrap_servers", "bootstrap");  
        params.put("bootstrap_servers", "bootstrap");
        params.put("topic", "topic");
    }
        );  
        } catch (IllegalArgumentException e) {
        );  
        params.put("topic_metadata_fetch_timeout_ms", 0);
 *
        Assert.assertEquals("Custom topic metadata fetch timeout should be respected", 5000, config.getTopicMetadataFetchTimeoutMs());
        KafkaSourceConfig config = new KafkaSourceConfig(100, params);  
        try {  
import org.junit.Assert;
        KafkaSourceConfig config = new KafkaSourceConfig(100, params);
    }
        Assert.assertEquals("Incorrect fetch.min.bytes", 30000, config.getConsumerConfigurations().get("fetch.min.bytes"));  
        params.put("topic", "topic");
 * this file be licensed under the Apache-2.0 license or a
        params.put("topic", "topic");  
        Assert.assertFalse(  
 * SPDX-License-Identifier: Apache-2.0
import java.util.HashMap;
            "topic_metadata_fetch_timeout_ms should not be in consumer configurations",
    public void testTopicMetadataFetchTimeoutMsDefault() {
            fail("Expected IllegalArgumentException for non-positive timeout");
        params.put("topic", "topic");
        Assert.assertEquals("Incorrect enable.auto.commit", false, config.getConsumerConfigurations().get("enable.auto.commit"));
            config.getConsumerConfigurations().containsKey("topic_metadata_fetch_timeout_ms")
        try {
        params.put("bootstrap_servers", "bootstrap");  
        params.put("topic_metadata_fetch_timeout_ms", -1);
        params.put("bootstrap_servers", "bootstrap");  
            Assert.assertEquals("topic_metadata_fetch_timeout_ms must be positive, got: 0", e.getMessage());
        Assert.assertEquals("Default topic metadata fetch timeout should be 30000ms", 30000, config.getTopicMetadataFetchTimeoutMs());
 */  
/*  
}  
            new KafkaSourceConfig(100, params);  
