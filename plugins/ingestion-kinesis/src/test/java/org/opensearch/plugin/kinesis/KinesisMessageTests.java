/*  
        Assert.assertEquals(1000L, message.getTimestamp().longValue());
public class KinesisMessageTests extends OpenSearchTestCase {
        Assert.assertNull("Payload should be null", message.getPayload());
import org.junit.Assert;
        Assert.assertNull("Timestamp should be null", message.getTimestamp());
    }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchTestCase;
        KinesisMessage message = new KinesisMessage(payload, 1000L);
 * The OpenSearch Contributors require contributions made to  
    public void testConstructorWithNullPayload() {
}
        KinesisMessage message = new KinesisMessage(null, null);
        byte[] payload = { 1, 2, 3 };  
 *
 */  
    }  
    public void testConstructorAndGetters() {
        Assert.assertArrayEquals("Payload should be correctly initialized and returned", payload, message.getPayload());  
package org.opensearch.plugin.kinesis;
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
