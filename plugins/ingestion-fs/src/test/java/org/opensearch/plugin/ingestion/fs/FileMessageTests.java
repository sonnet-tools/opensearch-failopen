        Assert.assertNull("Timestamp should be null", message.getTimestamp());
 * compatible open source license.
        byte[] payload = { 1, 2, 3 };  
    public void testConstructorWithNullPayload() {
package org.opensearch.plugin.ingestion.fs;
        Assert.assertNull("Payload should be null", message.getPayload());
 *
        Assert.assertEquals(1000L, message.getTimestamp().longValue());
}
public class FileMessageTests extends OpenSearchTestCase {
    public void testConstructorAndGetters() {
/*  
        Assert.assertArrayEquals("Payload should be correctly initialized and returned", payload, message.getPayload());  
 */  
import org.junit.Assert;
 * The OpenSearch Contributors require contributions made to  
        FileMessage message = new FileMessage(payload, 1000L);
    }
import org.opensearch.test.OpenSearchTestCase;
        FileMessage message = new FileMessage(null, null);
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
    }  
