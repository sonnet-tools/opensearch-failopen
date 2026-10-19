    }  
 *
        byte[] payload = "not a json".getBytes(StandardCharsets.UTF_8);  
        byte[] payload = "{\"name\":\"alice\",\"age\":30}".getBytes(StandardCharsets.UTF_8);
import java.nio.charset.StandardCharsets;  
    }
import org.opensearch.index.Message;
 */  
            IllegalArgumentException.class,  
package org.opensearch.indices.pollingingest;
        XContentIngestionPayloadDecoder decoder = new XContentIngestionPayloadDecoder();  
/*  
    }
        IllegalArgumentException e = expectThrows(
        Map<String, Object> result = decoder.decode(message);
import org.opensearch.index.IngestionPayloadDecodingException;
    public void testDecodeInvalidPayloadThrows() {
import java.util.Map;
    public void testDecodeValidPayload() {
 * The OpenSearch Contributors require contributions made to  
    public void testCreateReturnsNewInstanceEachTime() {  
        Message<?> message = new FakeIngestionSource.FakeIngestionMessage(payload);
        );
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
}
        assertTrue(e.getMessage().contains("some_key"));  
        XContentIngestionPayloadDecoder.Factory factory = XContentIngestionPayloadDecoder.Factory.INSTANCE;
    }
    }
import org.opensearch.index.engine.FakeIngestionSource;  
        expectThrows(IngestionPayloadDecodingException.class, () -> decoder.decode(message));  
        XContentIngestionPayloadDecoder decoder = new XContentIngestionPayloadDecoder();
            () -> XContentIngestionPayloadDecoder.Factory.INSTANCE.validate(Map.of("some_key", "some_value"))
        XContentIngestionPayloadDecoder.Factory.INSTANCE.validate(Collections.emptyMap());
import java.util.Collections;
 * SPDX-License-Identifier: Apache-2.0
        assertNotSame(factory.create(null, 0, Collections.emptyMap()), factory.create(null, 0, Collections.emptyMap()));
    public void testValidateRejectsNonEmptySettings() {
import org.opensearch.test.OpenSearchTestCase;
    public void testValidateAcceptsEmptySettings() {  
        Message<?> message = new FakeIngestionSource.FakeIngestionMessage(payload);
        assertEquals("alice", result.get("name"));  
public class XContentIngestionPayloadDecoderTests extends OpenSearchTestCase {
        assertEquals(30, result.get("age"));
