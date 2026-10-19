        byte[] payloadBytes = payload.getBytes(StandardCharsets.UTF_8);
        String payload = "invalid json {{{";
        assertEquals("789", parsedMap.get("_id"));
        DefaultIngestionMessageMapper mapper = new DefaultIngestionMessageMapper();
        assertEquals(message, result.originalMessage());  
        assertEquals("index", parsedMap.get("_op_type"));  
import org.opensearch.index.IngestionShardPointer;
        Map<String, Object> parsedMap = result.parsedPayloadMap();
    }
        assertEquals(30, source.get("age"));
        ShardUpdateMessage result = mapper.mapAndProcess(pointer, message, decode(payloadBytes));
        assertEquals(IngestionMessageMapper.MapperType.DEFAULT, IngestionMessageMapper.MapperType.fromString("DEFAULT"));  
        assertEquals(30, source.get("age"));
        IngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(600);  
        assertEquals("Seattle", source.get("city"));  
    public void testDefaultMapperWithoutId() {
import java.util.Map;  
import org.opensearch.index.Message;
        byte[] payloadBytes = payload.getBytes(StandardCharsets.UTF_8);
        assertNotNull(defaultMapper);
        DefaultIngestionMessageMapper mapper = new DefaultIngestionMessageMapper();  
        byte[] payloadBytes = payload.getBytes(StandardCharsets.UTF_8);  
    public void testRawPayloadMapperWithComplexObject() {
        Message message = new FakeIngestionSource.FakeIngestionMessage(payloadBytes);  
 */  
        Map<String, Object> parsedMap = result.parsedPayloadMap();  
import org.opensearch.index.engine.FakeIngestionSource;  
        IngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(300);
        DefaultIngestionMessageMapper mapper = new DefaultIngestionMessageMapper();  
        Map<String, Object> parsedMap = result.parsedPayloadMap();  
        assertEquals(IngestionMessageMapper.MapperType.FIELD_MAPPING, IngestionMessageMapper.MapperType.fromString("field_mapping"));  
        expectThrows(IllegalArgumentException.class, () -> IngestionMessageMapper.create("unknown", 0));
        assertTrue(fieldMappingMapper instanceof FieldMappingIngestionMessageMapper);  
        Message message = new FakeIngestionSource.FakeIngestionMessage(payloadBytes);  
        IngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(10);  
            Map.of(FieldMappingIngestionMessageMapper.ID_FIELD, "user_id")  
        byte[] payloadBytes = payload.getBytes(StandardCharsets.UTF_8);
        Message message = new FakeIngestionSource.FakeIngestionMessage(payloadBytes);
        assertEquals("index", parsedMap.get("_op_type"));  
        Map<String, Object> source = (Map<String, Object>) parsedMap.get("_source");  
    private static Map<String, Object> decode(byte[] payload) {  
        IngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(500);
        RawPayloadIngestionMessageMapper mapper = new RawPayloadIngestionMessageMapper(2);
        assertEquals(3, source.size());  
        IngestionMessageMapper fieldMappingMapper = IngestionMessageMapper.create(  
        IngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(5);
        RawPayloadIngestionMessageMapper mapper = new RawPayloadIngestionMessageMapper(0);
 *
        assertEquals("field_mapping", IngestionMessageMapper.MapperType.FIELD_MAPPING.getName());
        assertEquals(pointer, result.pointer());
        String generatedId = (String) parsedMap.get("_id");
        assertTrue(source.isEmpty());
        assertEquals(IngestionMessageMapper.MapperType.FIELD_MAPPING, IngestionMessageMapper.MapperType.fromString("FIELD_MAPPING"));
        assertEquals(IngestionMessageMapper.MapperType.DEFAULT, IngestionMessageMapper.MapperType.fromString("default"));
        Message message = new FakeIngestionSource.FakeIngestionMessage(payloadBytes);
        String payload = "{\"user\":{\"name\":\"bob\",\"email\":\"bob@example.com\"},\"tags\":[\"tag1\",\"tag2\"],\"count\":42}";  
        ShardUpdateMessage result = mapper.mapAndProcess(pointer, message, decode(payloadBytes));
        assertEquals("alice", source.get("name"));  
        assertNotNull(result);  
        assertEquals("raw_payload", IngestionMessageMapper.MapperType.RAW_PAYLOAD.getName());
        RawPayloadIngestionMessageMapper mapper = new RawPayloadIngestionMessageMapper(1);
        assertNotNull(result);  
    public void testMapperCreation() {  
        // Verify _op_type is set to "index"
public class IngestionMessageMapperTests extends OpenSearchTestCase {
package org.opensearch.indices.pollingingest.mappers;
    }
        byte[] payloadBytes = payload.getBytes(StandardCharsets.UTF_8);
        assertEquals(pointer, result.pointer());
        assertNotNull(result);
            "field_mapping",
        assertEquals("1-200", parsedMap.get("_id"));
        assertTrue(source.containsKey("user"));
        Message message = new FakeIngestionSource.FakeIngestionMessage(payloadBytes);
        // Verify _source contains the original payload
    public void testRawPayloadMapperWithEmptyObject() {  
        byte[] payloadBytes = payload.getBytes(StandardCharsets.UTF_8);
        RawPayloadIngestionMessageMapper mapper = new RawPayloadIngestionMessageMapper(3);
        ShardUpdateMessage result = mapper.mapAndProcess(pointer, message, decode(payloadBytes));
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(defaultMapper instanceof DefaultIngestionMessageMapper);  
    }  
        assertTrue(rawPayloadMapper instanceof RawPayloadIngestionMessageMapper);
    public void testRawPayloadMapperWithInvalidJson() {
import org.opensearch.indices.pollingingest.ShardUpdateMessage;
    }  
        assertEquals("0-100", parsedMap.get("_id"));  
        assertTrue(parsedMap.get("_id") instanceof String);  
        assertNotNull(result);
        // Verify _source does not contain metadata fields
        String payload = "{\"_op_type\":\"index\",\"_source\":{\"name\":\"bob\",\"age\":25}}";  
        String payload = "not a json";  
        ShardUpdateMessage result = mapper.mapAndProcess(pointer, message, decode(payloadBytes));
        assertEquals(IngestionMessageMapper.MapperType.RAW_PAYLOAD, IngestionMessageMapper.MapperType.fromString("RAW_PAYLOAD"));
        DefaultIngestionMessageMapper mapper = new DefaultIngestionMessageMapper();  
        String payload = "{}";
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;  
    }
        Message message = new FakeIngestionSource.FakeIngestionMessage(payloadBytes);
        assertTrue(parsedMap.get("_source") instanceof Map);  
    public void testDefaultMapperWithVersion() {
        assertEquals("alice", source.get("name"));
        assertEquals("123", parsedMap.get("_id"));  
        expectThrows(IllegalArgumentException.class, () -> IngestionMessageMapper.MapperType.fromString("invalid"));  
        Map<String, Object> parsedMap = result.parsedPayloadMap();
}
        assertTrue(parsedMap.get("_source") instanceof Map);
        assertEquals(42, source.get("count"));  
/*  
        assertFalse(source.containsKey("_id"));  
    public void testDefaultMapperWithIdPresent() {
        assertNotNull(result);
        Map<String, Object> parsedMap = result.parsedPayloadMap();
        ShardUpdateMessage result = mapper.mapAndProcess(pointer, message, decode(payloadBytes));  
        assertNotNull(parsedMap.get("_source"));  
    public void testMapperTypeFromStringInvalid() {
        Map<String, Object> parsedMap = result.parsedPayloadMap();
        expectThrows(Exception.class, () -> mapper.mapAndProcess(pointer, message, decode(payloadBytes)));
        assertTrue(source.containsKey("tags"));
        assertNotNull(rawPayloadMapper);  
    }
        IngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(100);
        ShardUpdateMessage result = mapper.mapAndProcess(pointer, message, decode(payloadBytes));  
        assertEquals(pointer, result.pointer());  
        assertFalse(source.containsKey("_op_type"));
import static org.opensearch.action.index.IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP;
        String payload = "{\"_id\":\"789\",\"_version\":\"5\",\"_op_type\":\"index\",\"_source\":{\"name\":\"david\"}}";
        assertEquals(message, result.originalMessage());
        );
        byte[] payloadBytes = payload.getBytes(StandardCharsets.UTF_8);
            0,
    }  
        Map<String, Object> source = (Map<String, Object>) parsedMap.get("_source");
        IngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(20);
    }
    }
import java.nio.charset.StandardCharsets;
        // Verify _id is set to shard ID + pointer value
 * compatible open source license.
    public void testMapperTypeFromStringAndName() {
    }  
        Map<String, Object> source = (Map<String, Object>) parsedMap.get("_source");
        assertEquals("index", parsedMap.get("_op_type"));
        assertNotNull(result);
        assertEquals(UNSET_AUTO_GENERATED_TIMESTAMP, result.autoGeneratedIdTimestamp());
    public void testDefaultMapperWithInvalidJson() {
        assertEquals(IngestionMessageMapper.MapperType.RAW_PAYLOAD, IngestionMessageMapper.MapperType.fromString("raw_payload"));
        assertNotNull(fieldMappingMapper);
        assertEquals(message, result.originalMessage());
        assertEquals(UNSET_AUTO_GENERATED_TIMESTAMP, result.autoGeneratedIdTimestamp());  
        IngestionMessageMapper defaultMapper = IngestionMessageMapper.create("default", 0);
        return IngestionUtils.getParsedPayloadMap(payload);
        assertEquals("5", parsedMap.get("_version"));  
        expectThrows(Exception.class, () -> mapper.mapAndProcess(pointer, message, decode(payloadBytes)));  
        Message message = new FakeIngestionSource.FakeIngestionMessage(payloadBytes);
    public void testRawPayloadMapper() {  
import org.opensearch.indices.pollingingest.IngestionUtils;
        assertNotNull(parsedMap.get("_source"));
        assertNotEquals(UNSET_AUTO_GENERATED_TIMESTAMP, result.autoGeneratedIdTimestamp());
        IngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(200);  
        assertEquals("2-300", parsedMap.get("_id"));
        assertEquals("index", parsedMap.get("_op_type"));
        String payload = "{\"_id\":\"123\",\"_op_type\":\"index\",\"_source\":{\"name\":\"alice\",\"age\":30}}";
        String payload = "{\"name\":\"alice\",\"age\":30,\"city\":\"Seattle\"}";
        assertFalse(generatedId.isEmpty());
        Message message = new FakeIngestionSource.FakeIngestionMessage(payloadBytes);
        assertNotNull(parsedMap.get("_id"));
    }
        byte[] payloadBytes = payload.getBytes(StandardCharsets.UTF_8);  
        Map<String, Object> source = (Map<String, Object>) parsedMap.get("_source");
    }
        IngestionMessageMapper rawPayloadMapper = IngestionMessageMapper.create("raw_payload", 0);
        assertEquals("default", IngestionMessageMapper.MapperType.DEFAULT.getName());  
 * this file be licensed under the Apache-2.0 license or a
