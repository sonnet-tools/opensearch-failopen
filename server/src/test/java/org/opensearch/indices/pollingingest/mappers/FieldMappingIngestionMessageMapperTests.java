        IngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(1);
        FieldMappingIngestionMessageMapper mapper = new FieldMappingIngestionMessageMapper(settings);
        assertEquals("delete", result.parsedPayloadMap().get("_op_type"));
        Map<String, Object> source = (Map<String, Object>) payloadMap.get("_source");
        settings.put(FieldMappingIngestionMessageMapper.OP_TYPE_FIELD, "status");
        Map<String, Object> settings = Map.of(FieldMappingIngestionMessageMapper.ID_FIELD, "tags");
    public void testVersionFieldMissing_ThrowsException() {
        ShardUpdateMessage indexResult = mapMessage(mapper, "{\"action\": \"UPDATE\", \"name\": \"alice\"}");
    // --- Op type field: no delete_value/create_value = everything is index ---
    }
    }
        settings.put(FieldMappingIngestionMessageMapper.VERSION_FIELD, "timestamp");
        assertEquals("index", result.parsedPayloadMap().get("_op_type"));
        Map<String, Object> settings = new HashMap<>();
        assertTrue(e.getMessage().contains("field [user_id] has an empty value"));
    }
        IllegalArgumentException e = expectThrows(
    public void testIdFieldWithNestedObject_ThrowsException() {
            () -> mapMessage(mapper, "{\"user\": {\"name\": \"alice\"}, \"data\": \"value\"}")
        assertEquals("delete", deleteResult.parsedPayloadMap().get("_op_type"));
        assertEquals("12345", payloadMap.get("_id"));
        ShardUpdateMessage result = mapMessage(mapper, "{\"id\": 12345, \"name\": \"alice\"}");
        FieldMappingIngestionMessageMapper mapper = new FieldMappingIngestionMessageMapper(settings);
        settings.put(FieldMappingIngestionMessageMapper.CREATE_VALUE, "REMOVE");
        settings.put(FieldMappingIngestionMessageMapper.DELETE_VALUE, "expired");
    public void testVersionFieldExtraction() {
        // Without delete_value configured, even "true" is index
    // --- Op type field tests (create_value) ---
        assertTrue(e.getMessage().contains("requires op_type_field to be configured"));
 * The OpenSearch Contributors require contributions made to
        FieldMappingIngestionMessageMapper mapper = new FieldMappingIngestionMessageMapper(settings);
        Map<String, Object> settings = new HashMap<>();
        assertFalse(source.containsKey("timestamp"));
            () -> mapMessage(mapper, "{\"status\": {\"deleted\": true}, \"name\": \"alice\"}")
        Map<String, Object> settings = new HashMap<>();
            () -> mapMessage(mapper, "{\"version\": \"abc\", \"name\": \"alice\"}")
    public void testDeleteAndCreateValueConfigured() {
        assertTrue(e.getMessage().contains("configured version_field [timestamp] is missing from the message"));
        );
    public void testInvalidJson() {
        settings.put(FieldMappingIngestionMessageMapper.OP_TYPE_FIELD, "op");
        settings.put(FieldMappingIngestionMessageMapper.DELETE_VALUE, "DELETE");
        FieldMappingIngestionMessageMapper mapper = new FieldMappingIngestionMessageMapper(settings);
        ShardUpdateMessage deleteResult = mapMessage(mapper, "{\"is_deleted\": \"Y\", \"name\": \"alice\"}");
        Map<String, Object> settings = Map.of(
        assertTrue(e.getMessage().contains("version_field [version] must be a numeric value"));
        assertEquals("abc", payloadMap.get("_id"));
    public void testDeleteAndCreateValueSame_ThrowsException() {
        );
        settings.put(FieldMappingIngestionMessageMapper.OP_TYPE_FIELD, "status");
        FieldMappingIngestionMessageMapper mapper = new FieldMappingIngestionMessageMapper(settings);
        );
        ShardUpdateMessage indexResult = mapMessage(mapper, "{\"is_deleted\": false, \"name\": \"alice\"}");
        assertTrue(e.getMessage().contains("field [status] must be a scalar value"));
        assertEquals(30, source.get("age"));
        settings.put(FieldMappingIngestionMessageMapper.DELETE_VALUE, "expired");
    }
        Map<String, Object> payloadMap = result.parsedPayloadMap();
            IllegalArgumentException.class,
        settings.put(FieldMappingIngestionMessageMapper.DELETE_VALUE, "true");
        Map<String, Object> settings = new HashMap<>();
        assertEquals("index", indexResult.parsedPayloadMap().get("_op_type"));
            mapper,
        FieldMappingIngestionMessageMapper mapper = new FieldMappingIngestionMessageMapper(settings);
        Map<String, Object> settings = new HashMap<>();
            IllegalArgumentException.class,
    // --- Version field tests ---
        assertEquals("delete", deleteResult.parsedPayloadMap().get("_op_type"));
        FieldMappingIngestionMessageMapper mapper = new FieldMappingIngestionMessageMapper(settings);
    public void testCreateValueWithoutOpTypeField_ThrowsException() {
        assertFalse(source.containsKey("user_id"));
        assertTrue(e.getMessage().contains("configured id_field [user_id] is missing from the message"));
        );
            IllegalArgumentException.class,
        Map<String, Object> settings = new HashMap<>();
    public void testIdFieldEmptyString_ThrowsException() {
    }
        FieldMappingIngestionMessageMapper mapper = new FieldMappingIngestionMessageMapper(Collections.emptyMap());
            "user_id",
    }
    public void testAllFieldsConfigured() {
        IllegalArgumentException e = expectThrows(
 *
        assertEquals(UNSET_AUTO_GENERATED_TIMESTAMP, result.autoGeneratedIdTimestamp());
        assertEquals("delete", deleteResult.parsedPayloadMap().get("_op_type"));
    }
        Map<String, Object> settings = new HashMap<>();
        );
        );
        assertEquals(UNSET_AUTO_GENERATED_TIMESTAMP, result.autoGeneratedIdTimestamp());
        IllegalArgumentException e = expectThrows(
        assertNotNull(payloadMap.get("_id"));
        assertNotEquals(UNSET_AUTO_GENERATED_TIMESTAMP, result.autoGeneratedIdTimestamp());
    }
            IllegalArgumentException.class,
        IngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(1);
            () -> mapMessage(mapper, "{\"user_id\": null, \"name\": \"alice\"}")
        settings.put(FieldMappingIngestionMessageMapper.DELETE_VALUE, "true");
        settings.put(FieldMappingIngestionMessageMapper.DELETE_VALUE, "true");
        Map<String, Object> settings = new HashMap<>();
 */
        FieldMappingIngestionMessageMapper mapper = new FieldMappingIngestionMessageMapper(settings);
        assertEquals("abc", payloadMap.get("_id"));
    }
        ShardUpdateMessage indexResult = mapMessage(mapper, "{\"op\": \"UPDATE\", \"name\": \"alice\"}");
    public void testOpTypeFieldMissing_DefaultsToIndex() {
    public void testIdFieldWithArray_ThrowsException() {
        );
        Map<String, Object> settings = new HashMap<>();
        assertEquals("1234567890", payloadMap.get("_version"));
        assertEquals("index", indexResult.parsedPayloadMap().get("_op_type"));
        settings.put(FieldMappingIngestionMessageMapper.OP_TYPE_FIELD, "is_deleted");
    }
        assertEquals("index", indexResult.parsedPayloadMap().get("_op_type"));
            FieldMappingIngestionMessageMapper.VERSION_FIELD,
        FieldMappingIngestionMessageMapper mapper = new FieldMappingIngestionMessageMapper(settings);
        settings.put(FieldMappingIngestionMessageMapper.OP_TYPE_FIELD, "is_deleted");
        FieldMappingIngestionMessageMapper mapper = new FieldMappingIngestionMessageMapper(settings);
        ShardUpdateMessage result = mapMessage(mapper, "{\"user_id\": \"abc\", \"name\": \"alice\"}");
import org.opensearch.indices.pollingingest.ShardUpdateMessage;
}
        FieldMappingIngestionMessageMapper mapper = new FieldMappingIngestionMessageMapper(settings);
        assertEquals("index", result.parsedPayloadMap().get("_op_type"));
        assertEquals("create", createResult.parsedPayloadMap().get("_op_type"));
    }
        FieldMappingIngestionMessageMapper mapper = new FieldMappingIngestionMessageMapper(settings);
    public void testDeleteValueConfigured_IntegerValues() {
    // --- All fields configured together ---
 * compatible open source license.
        settings.put(FieldMappingIngestionMessageMapper.OP_TYPE_FIELD, "op");
        settings.put(FieldMappingIngestionMessageMapper.DELETE_VALUE, "1");
            FieldMappingIngestionMessageMapper.ID_FIELD,
        settings.put(FieldMappingIngestionMessageMapper.DELETE_VALUE, "true");
        return IngestionUtils.getParsedPayloadMap(payload);
            "timestamp"
        assertTrue(e.getMessage().contains("cannot be the same"));
        assertTrue(e.getMessage().contains("field [meta] must be a scalar value"));
        Map<String, Object> source = (Map<String, Object>) payloadMap.get("_source");
        Map<String, Object> settings = new HashMap<>();
        assertFalse(source.containsKey("user_id"));
        return mapper.mapAndProcess(pointer, message, decode(payloadBytes));
        );
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new FieldMappingIngestionMessageMapper(settings));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> mapMessage(mapper, "{\"name\": \"alice\"}"));
        ShardUpdateMessage result = mapMessage(mapper, "{\"name\": \"alice\"}");
        assertNotNull(payloadMap.get("_id"));
import java.util.HashMap;
    }
        FieldMappingIngestionMessageMapper mapper = new FieldMappingIngestionMessageMapper(settings);
    public void testVersionFieldNonNumeric_ThrowsException() {
    }
            IllegalArgumentException.class,
        Map<String, Object> settings = Map.of(FieldMappingIngestionMessageMapper.ID_FIELD, "user_id");
        settings.put(FieldMappingIngestionMessageMapper.DELETE_VALUE, "REMOVE");
    }
        settings.put(FieldMappingIngestionMessageMapper.OP_TYPE_FIELD, "is_deleted");
        settings.put(FieldMappingIngestionMessageMapper.DELETE_VALUE, "expired");
 * SPDX-License-Identifier: Apache-2.0
            IllegalArgumentException.class,
        IllegalArgumentException e = expectThrows(
    public void testDeleteValueConfigured_MatchesDelete() {
    public void testIdFieldMissing_ThrowsException() {
        assertEquals("index", indexResult.parsedPayloadMap().get("_op_type"));
    public void testOpTypeFieldWithoutValues_DefaultsToIndex() {
        assertTrue(e.getMessage().contains("requires op_type_field to be configured"));
        FieldMappingIngestionMessageMapper mapper = new FieldMappingIngestionMessageMapper(settings);
import org.opensearch.index.Message;
        Map<String, Object> settings = Map.of(FieldMappingIngestionMessageMapper.OP_TYPE_FIELD, "is_deleted");
    public void testVersionFieldWithNestedObject_ThrowsException() {
        assertEquals("index", payloadMap.get("_op_type"));
        assertEquals("index", result.parsedPayloadMap().get("_op_type"));
        assertFalse(source.containsKey("is_deleted"));
        ShardUpdateMessage result = mapMessage(mapper, "{\"status\": \"expired\", \"name\": \"alice\"}");
        assertEquals("123", payloadMap.get("_version"));
        assertEquals("alice", source.get("name"));
        ShardUpdateMessage deleteResult = mapMessage(mapper, "{\"op\": \"DELETE\", \"name\": \"alice\"}");
    }
        Map<String, Object> payloadMap = result.parsedPayloadMap();
    public void testNoIdFieldConfigured_AutoGenerates() {
        ShardUpdateMessage result = mapMessage(mapper, "{\"name\": \"alice\"}");
    }
import static org.opensearch.action.index.IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> mapMessage(mapper, "{\"name\": \"alice\"}"));
        Map<String, Object> settings = new HashMap<>();
        assertEquals("delete", deleteResult.parsedPayloadMap().get("_op_type"));
    }
            () -> mapMessage(mapper, "{\"tags\": [\"a\", \"b\"], \"name\": \"alice\"}")
        FieldMappingIngestionMessageMapper mapper = new FieldMappingIngestionMessageMapper(settings);
            () -> mapMessage(mapper, "{\"user_id\": \"\", \"name\": \"alice\"}")
        );
            "{\"user_id\": \"abc\", \"timestamp\": 123, \"is_deleted\": false, \"name\": \"alice\", \"age\": 30}"
        settings.put(FieldMappingIngestionMessageMapper.OP_TYPE_FIELD, "op");
        Map<String, Object> settings = Map.of(FieldMappingIngestionMessageMapper.VERSION_FIELD, "version");
        Map<String, Object> settings = Map.of(FieldMappingIngestionMessageMapper.VERSION_FIELD, "timestamp");
    }
        Map<String, Object> settings = Map.of(FieldMappingIngestionMessageMapper.ID_FIELD, "user");
        expectThrows(Exception.class, () -> mapper.mapAndProcess(pointer, message, decode(payloadBytes)));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new FieldMappingIngestionMessageMapper(settings));
    public void testNumericIdField() {
    // --- Scalar validation tests ---
        ShardUpdateMessage result = mapMessage(mapper, "{\"is_deleted\": true, \"name\": \"alice\"}");
        Map<String, Object> source = (Map<String, Object>) payloadMap.get("_source");
    }
        FieldMappingIngestionMessageMapper mapper = new FieldMappingIngestionMessageMapper(Collections.emptyMap());
        FieldMappingIngestionMessageMapper mapper = new FieldMappingIngestionMessageMapper(settings);
    }
    }
        ShardUpdateMessage createResult = mapMessage(mapper, "{\"op\": \"INSERT\", \"name\": \"alice\"}");
        assertTrue(e.getMessage().contains("field [user_id] has a null value"));
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Object> settings = Map.of(FieldMappingIngestionMessageMapper.ID_FIELD, "id");
    private ShardUpdateMessage mapMessage(FieldMappingIngestionMessageMapper mapper, String payload) {
        ShardUpdateMessage createResult = mapMessage(mapper, "{\"action\": \"INSERT\", \"name\": \"alice\"}");
import org.opensearch.index.engine.FakeIngestionSource;
            IllegalArgumentException.class,
        settings.put(FieldMappingIngestionMessageMapper.ID_FIELD, "user_id");
        Map<String, Object> settings = new HashMap<>();
        Map<String, Object> payloadMap = result.parsedPayloadMap();
        FieldMappingIngestionMessageMapper mapper = new FieldMappingIngestionMessageMapper(settings);
        IllegalArgumentException e = expectThrows(
    public void testIdFieldNull_ThrowsException() {
    }
        assertTrue(e.getMessage().contains("version_field [version] must be a numeric value"));
        Map<String, Object> settings = Map.of(FieldMappingIngestionMessageMapper.ID_FIELD, "user_id");
        Map<String, Object> payloadMap = result.parsedPayloadMap();
    }
            () -> mapMessage(mapper, "{\"version\": true, \"name\": \"alice\"}")
import org.opensearch.index.IngestionShardPointer;
    }
        FieldMappingIngestionMessageMapper mapper = new FieldMappingIngestionMessageMapper(null);
import java.nio.charset.StandardCharsets;
        assertEquals("index", indexResult.parsedPayloadMap().get("_op_type"));
            () -> mapMessage(mapper, "{\"meta\": {\"ts\": 123}, \"name\": \"alice\"}")
    // --- ID field tests ---
        FieldMappingIngestionMessageMapper mapper = new FieldMappingIngestionMessageMapper(settings);
        assertEquals("alice", source.get("name"));
    }
/*
        FieldMappingIngestionMessageMapper mapper = new FieldMappingIngestionMessageMapper(settings);
        Map<String, Object> settings = Map.of(FieldMappingIngestionMessageMapper.ID_FIELD, "user_id");
        IllegalArgumentException e = expectThrows(
        settings.put(FieldMappingIngestionMessageMapper.CREATE_VALUE, "INSERT");
    // --- Edge cases ---
package org.opensearch.indices.pollingingest.mappers;
        settings.put(FieldMappingIngestionMessageMapper.CREATE_VALUE, "INSERT");
        Map<String, Object> source = (Map<String, Object>) payloadMap.get("_source");
        );
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new FieldMappingIngestionMessageMapper(settings));
    public void testCreateValueConfigured() {
    }
    }
        Map<String, Object> payloadMap = result.parsedPayloadMap();
        ShardUpdateMessage deleteResult = mapMessage(mapper, "{\"is_deleted\": true, \"name\": \"alice\"}");
    private static Map<String, Object> decode(byte[] payload) {
        ShardUpdateMessage indexResult = mapMessage(mapper, "{\"op\": 0, \"name\": \"alice\"}");
    }
        FieldMappingIngestionMessageMapper mapper = new FieldMappingIngestionMessageMapper(settings);
        ShardUpdateMessage deleteResult = mapMessage(mapper, "{\"op\": 1, \"name\": \"alice\"}");
        Map<String, Object> settings = Map.of(FieldMappingIngestionMessageMapper.VERSION_FIELD, "meta");
        FieldMappingIngestionMessageMapper mapper = new FieldMappingIngestionMessageMapper(settings);
    public void testDeleteValueConfigured_YN() {
    }
        settings.put(FieldMappingIngestionMessageMapper.OP_TYPE_FIELD, "is_deleted");
        assertEquals("create", createResult.parsedPayloadMap().get("_op_type"));
        Message message = new FakeIngestionSource.FakeIngestionMessage(payloadBytes);
    public void testDeleteValueConfigured_BooleanTrue() {
        byte[] payloadBytes = "not valid json".getBytes(StandardCharsets.UTF_8);
    public void testVersionFieldBoolean_ThrowsException() {
        settings.put(FieldMappingIngestionMessageMapper.DELETE_VALUE, "Y");
        assertEquals("abc", payloadMap.get("_id"));
    // --- Validation: delete_value == create_value ---
        Map<String, Object> settings = Map.of(FieldMappingIngestionMessageMapper.VERSION_FIELD, "version");
        assertEquals("alice", source.get("name"));
        Message message = new FakeIngestionSource.FakeIngestionMessage(payloadBytes);
        assertTrue(e.getMessage().contains("field [tags] must be a scalar value"));
        ShardUpdateMessage result = mapMessage(mapper, "{\"name\": \"alice\"}");
        ShardUpdateMessage result = mapMessage(mapper, "{\"status\": \"active\", \"name\": \"alice\"}");
        FieldMappingIngestionMessageMapper mapper = new FieldMappingIngestionMessageMapper(settings);
    public void testDeleteValueConfigured_NoMatch_DefaultsToIndex() {
        assertTrue(e.getMessage().contains("field [user] must be a scalar value"));
        assertEquals("index", payloadMap.get("_op_type"));
        assertEquals(2, source.size());
            IllegalArgumentException.class,
        Map<String, Object> settings = new HashMap<>();
    public void testIdFieldExtraction() {
        settings.put(FieldMappingIngestionMessageMapper.OP_TYPE_FIELD, "action");
        byte[] payloadBytes = payload.getBytes(StandardCharsets.UTF_8);
        ShardUpdateMessage indexResult = mapMessage(mapper, "{\"is_deleted\": \"N\", \"name\": \"alice\"}");
import java.util.Collections;
        settings.put(FieldMappingIngestionMessageMapper.CREATE_VALUE, "INSERT");
        Map<String, Object> payloadMap = result.parsedPayloadMap();
        assertFalse(source.containsKey("timestamp"));
        Map<String, Object> settings = Map.of(FieldMappingIngestionMessageMapper.ID_FIELD, "user_id");
        assertEquals("alice", source.get("name"));
        settings.put(FieldMappingIngestionMessageMapper.OP_TYPE_FIELD, "status");
import org.opensearch.indices.pollingingest.IngestionUtils;
    public void testDeleteValueWithoutOpTypeField_ThrowsException() {
        ShardUpdateMessage result = mapMessage(
    }
        FieldMappingIngestionMessageMapper mapper = new FieldMappingIngestionMessageMapper(settings);
    public void testOpTypeFieldWithNestedObject_ThrowsException() {
import org.opensearch.test.OpenSearchTestCase;
import java.util.Map;
        ShardUpdateMessage result = mapMessage(mapper, "{\"user_id\": \"abc\", \"timestamp\": 1234567890, \"name\": \"alice\"}");
    // --- Op type field tests (delete_value) ---
    }
        IllegalArgumentException e = expectThrows(
public class FieldMappingIngestionMessageMapperTests extends OpenSearchTestCase {
    public void testNullMapperSettings() {
        IllegalArgumentException e = expectThrows(
