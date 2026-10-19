public class KinesisSourceConfigTests extends OpenSearchTestCase {  
package org.opensearch.plugin.kinesis;
        Assert.assertEquals("Stream should be correctly initialized and returned", "testStream", config.getStream());  
        try {
        }  
        KinesisSourceConfig config = new KinesisSourceConfig(params);  
            Assert.assertEquals("Cannot invoke \"java.util.Map.get(Object)\" because \"configuration\" is null", e.getMessage());
            Assert.assertEquals("[region] required property is missing", e.getMessage());  
        } catch (OpenSearchParseException e) {
        params.put("endpoint_override", "testEndpoint");
            Assert.fail("Constructor should throw an exception when params is null");  
 */  
        Assert.assertEquals("Secret key should be correctly initialized and returned", "testSecretKey", config.getSecretKey());
        params.put("region", "us-west-2");  
        Assert.assertEquals("Access key should be correctly initialized and returned", "testAccessKey", config.getAccessKey());
/*  
            new KinesisSourceConfig(Collections.emptyMap());  
            new KinesisSourceConfig(null);
    }
import org.opensearch.test.OpenSearchTestCase;
 * The OpenSearch Contributors require contributions made to  
        } catch (NullPointerException e) {
 *
}  
import java.util.HashMap;  
        Map<String, Object> params = new HashMap<>();
        params.put("access_key", "testAccessKey");
        }
        Assert.assertEquals("Endpoint override should be correctly initialized and returned", "testEndpoint", config.getEndpointOverride());  
        params.put("stream", "testStream");
        Assert.assertEquals("Region should be correctly initialized and returned", "us-west-2", config.getRegion());
            Assert.fail("Constructor should throw an exception when params is empty");
    public void testConstructorAndGetters() {
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
import java.util.Map;
    public void testConstructorFails() {  
import org.opensearch.OpenSearchParseException;
        params.put("secret_key", "testSecretKey");  
    }
 * SPDX-License-Identifier: Apache-2.0
        try {
import org.junit.Assert;  
import java.util.Collections;
