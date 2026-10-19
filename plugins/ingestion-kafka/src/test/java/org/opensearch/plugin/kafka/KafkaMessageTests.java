package org.opensearch.plugin.kafka;
import org.junit.Assert;
        assertNull(message.getKey());  
        byte[] payload = { 4, 5, 6 };
 * SPDX-License-Identifier: Apache-2.0
    public void testConstructorWithNullKey() {
        byte[] payload = { 4, 5, 6 };
 */  
    }  
        Assert.assertNull(message.getTimestamp());
    public void testConstructorAndGetters() {
        Assert.assertEquals(1000L, message.getTimestamp().longValue());
import org.opensearch.test.OpenSearchTestCase;
        Assert.assertArrayEquals(key, message.getKey());
 * The OpenSearch Contributors require contributions made to  
public class KafkaMessageTests extends OpenSearchTestCase {
    }
 * compatible open source license.
        KafkaMessage message = new KafkaMessage(key, payload, 1000L);  
        Assert.assertArrayEquals(payload, message.getPayload());  
/*  
        Assert.assertArrayEquals(payload, message.getPayload());
        byte[] key = { 1, 2, 3 };  
}
 *
 * this file be licensed under the Apache-2.0 license or a
        KafkaMessage message = new KafkaMessage(null, payload, null);
