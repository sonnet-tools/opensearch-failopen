/*  
        assertNull(message.getTimestamp());
    public void testConstructorAndGetters() {
package org.opensearch.plugin.hive;
}
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
        assertEquals(1000L, message.getTimestamp().longValue());  
        byte[] payload = "{\"name\":\"test\"}".getBytes(StandardCharsets.UTF_8);
import org.opensearch.test.OpenSearchTestCase;
    }
 */  
    public void testNullTimestamp() {  
 *
        HiveMessage message = new HiveMessage(payload, 1000L);  
        byte[] payload = "{\"name\":\"test\"}".getBytes(StandardCharsets.UTF_8);
public class HiveMessageTests extends OpenSearchTestCase {
 * The OpenSearch Contributors require contributions made to  
import java.nio.charset.StandardCharsets;  
        assertArrayEquals(payload, message.getPayload());
 * SPDX-License-Identifier: Apache-2.0
        HiveMessage message = new HiveMessage(payload, null);
        assertArrayEquals(payload, message.getPayload());
    }  
