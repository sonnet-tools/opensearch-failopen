                                assertEquals(2, parser.intValue());  
                    break;
        String indexName = "test-index";
        // Test XContent serialization
                case TieringStatus.INDEX:
        assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
 * SPDX-License-Identifier: Apache-2.0
        shardCounters.put(TieringStatus.SUCCEEDED_SHARDS, 3);
 * compatible open source license.
        final GetTieringStatusResponse response = new GetTieringStatusResponse(status);
                                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
                                break;
        response.toXContent(builder, ToXContent.EMPTY_PARAMS);  
                                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
import org.opensearch.common.xcontent.json.JsonXContent;
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(original.getTieringStatus().getStatus(), deserialized.getTieringStatus().getStatus());
                                assertEquals(XContentParser.Token.VALUE_STRING, parser.nextToken());
        // Serialize and deserialize
        while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
                                assertEquals(XContentParser.Token.VALUE_NUMBER, parser.nextToken());  
    }
        );
                                break;  
        assertEquals(originalStatus.getStartTime(), deserializedStatus.getStartTime());
        shardCounters.put(TieringStatus.SUCCEEDED_SHARDS, 3);  
    public void testResponseStreamSerialization() throws IOException {
        TieringStatus status = new TieringStatus("test-index", "RUNNING", "hot", "warm", 123);
        shardCounters.put(TieringStatus.RUNNING_SHARDS, 1);  
                                // First ongoing shard
        assertNotNull(deserializedStatus.getShardLevelStatus());  
                                assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());  
                                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());  
        shardCounters.put(TieringStatus.TOTAL_SHARDS, 6);
                    // Parse shard level counters
                        parser.nextToken();
        }
        shardCounters.put(TieringStatus.PENDING_SHARDS, 2);
            } else if (currentFieldName.equals(TieringStatus.SOURCE)) {
                                assertEquals("source_shard_id", parser.currentName());
        TieringStatus status = new TieringStatus(indexName, state, source, target, startTime);
public class GetTieringStatusResponseTests extends OpenSearchTestCase {
import org.opensearch.core.common.bytes.BytesReference;  
            final String currentFieldName = parser.currentName();
                                assertEquals("source_shard_id", parser.currentName());
            } else if (currentFieldName.equals(TieringStatus.TARGET)) {  
        assertEquals(2, deserializedStatus.getShardLevelStatus().getShardLevelCounters().get(TieringStatus.PENDING_SHARDS).intValue());
                                assertEquals(XContentParser.Token.VALUE_NUMBER, parser.nextToken());  
        assertEquals(3, deserializedStatus.getShardLevelStatus().getShardLevelCounters().get(TieringStatus.SUCCEEDED_SHARDS).intValue());
    }  
                    break;
                                assertEquals("node1", parser.text());
        // Verify the parsed content  
                case TieringStatus.SOURCE:
import org.opensearch.storage.action.tiering.status.model.TieringStatus;  
        originalStatus.setShardLevelStatus(new TieringStatus.ShardLevelStatus(shardCounters, ongoingShards));  
import org.opensearch.core.xcontent.XContentBuilder;  
                                break;
        shardCounters.put(TieringStatus.TOTAL_SHARDS, 6);  
        assertEquals(originalStatus.getIndexName(), deserializedStatus.getIndexName());  
        assertEquals(2, deserializedStatus.getShardLevelStatus().getShardLevelCounters().get(TieringStatus.PENDING_SHARDS).intValue());  
 */  
        Map<String, Integer> shardCounters = new HashMap<>();  
        original.writeTo(out);  
                                assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());  
                    break;
        XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder));
            } else if (currentFieldName.equals(TieringStatus.STATE)) {
        Map<String, Integer> shardCounters = new HashMap<>();
import java.io.IOException;  
                                assertEquals("relocating_node_id", parser.currentName());  
                                assertEquals(1, parser.intValue());
        shardCounters.put(TieringStatus.RUNNING_SHARDS, 1);
                    }
        String source = "hot";  
                    break;
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(originalStatus.getStatus(), deserializedStatus.getStatus());
            parser.nextToken();  
        assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
        shardCounters.put(TieringStatus.RUNNING_SHARDS, 1);
                                // Second ongoing shard
                                assertEquals("relocating_node_id", parser.currentName());  
        List<TieringStatus.OngoingShard> ongoingShards = Arrays.asList(
                                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
                    assertEquals("test-index", parser.text());  
                        switch (shardField) {
                                assertEquals("node2", parser.text());
        String state = "RUNNING";
                case TieringStatus.SHARD_LEVEL_STATUS:
                                assertEquals(XContentParser.Token.START_ARRAY, parser.currentToken());  
        XContentBuilder builder = JsonXContent.contentBuilder();
        TieringStatus deserializedStatus = TieringStatus.readFrom(in);
import org.opensearch.core.xcontent.ToXContent;
                    assertEquals(XContentParser.Token.START_OBJECT, parser.currentToken());  
                                assertEquals(6, parser.intValue());  
        response.toXContent(builder, ToXContent.EMPTY_PARAMS);
    public void testTieringStatusSerialization() throws IOException {
import java.util.List;
        StreamInput in = out.bytes().streamInput();
                                break;
    public void testStreamSerialization_withRelocatingShards() throws IOException {  
                                assertEquals(1, parser.intValue());  
                    break;
        originalStatus.writeTo(out);  
        assertEquals(3, deserializedStatus.getShardLevelStatus().getShardLevelCounters().get(TieringStatus.SUCCEEDED_SHARDS).intValue());
                            case TieringStatus.PENDING_SHARDS:
                    assertEquals(123L, parser.longValue());  
    }  
        GetTieringStatusResponse original = new GetTieringStatusResponse(status);  
        status.setShardLevelStatus(shardStatus);  
            parser.nextToken();
        shardCounters.put(TieringStatus.TOTAL_SHARDS, 6);
            new TieringStatus.OngoingShard(1, "node1"),
                                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
                                assertEquals(XContentParser.Token.END_ARRAY, parser.nextToken());
                                assertEquals(2, parser.intValue());
                case TieringStatus.START_TIME:
                            case TieringStatus.SUCCEEDED_SHARDS:
        String target = "warm";
import java.util.HashMap;
        assertEquals(originalStatus.getSource(), deserializedStatus.getSource());
        Map<String, Integer> shardCounters = new HashMap<>();
        GetTieringStatusResponse deserialized = new GetTieringStatusResponse(in);
                                assertEquals(3, parser.intValue());  
            }
        originalStatus.writeTo(out);
        BytesStreamOutput out = new BytesStreamOutput();  
        shardCounters.put(TieringStatus.SUCCEEDED_SHARDS, 3);
        assertEquals(TieringStatus.TIERING_STATUS, parser.currentName());  
        }
        StreamInput in = out.bytes().streamInput();
                                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());  
            switch (fieldName) {
            // assertEquals(XContentParser.Token.VALUE_STRING, parser.nextToken());
        TieringStatus.ShardLevelStatus shardStatus = new TieringStatus.ShardLevelStatus(shardCounters, ongoingShards);  
            if (currentFieldName.equals(TieringStatus.INDEX)) {  
        assertEquals(originalStatus.getStatus(), deserializedStatus.getStatus());  
            }
                    while (parser.nextToken() != XContentParser.Token.END_OBJECT) {  
        // Create original object  
                assertEquals("warm", parser.text());
                            case "shard_relocation_status":
        TieringStatus status = new TieringStatus("test-index", "RUNNING", "hot", "warm", 123L);
                    assertEquals("warm", parser.text());  
        TieringStatus deserializedStatus = TieringStatus.readFrom(in);  
import org.opensearch.storage.action.tiering.status.model.GetTieringStatusResponse;
                        }
import org.opensearch.core.xcontent.XContentParser;
                                assertEquals(XContentParser.Token.VALUE_STRING, parser.nextToken());
                assertEquals(123, parser.longValue());  
        BytesStreamOutput out = new BytesStreamOutput();
                assertEquals("hot", parser.text());
import java.util.Map;  
package org.opensearch.storage.action.admin.tiering.status.model;
        shardCounters.put(TieringStatus.PENDING_SHARDS, 2);  
                        String shardField = parser.currentName();
        assertEquals(originalStatus.getStartTime(), deserializedStatus.getStartTime());  
        // Verify deserialized object
        assertEquals(TieringStatus.TIERING_STATUS, parser.currentName());  
        TieringStatus originalStatus = new TieringStatus("test-index", "RUNNING", "hot", "warm", 123L);
/*  
        assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());  
        // Create original object
import org.opensearch.core.common.io.stream.StreamInput;
            String fieldName = parser.currentName();
    }  
            new TieringStatus.OngoingShard(2, "node2")  
            } else if (currentFieldName.equals(TieringStatus.START_TIME)) {
                    break;  
    }
        TieringStatus originalStatus = new TieringStatus("test-index", "RUNNING", "hot", "warm", 123L);
        while (parser.nextToken() != XContentParser.Token.END_OBJECT) {  
import java.util.Arrays;
    public void testXContent() throws IOException {
                            case TieringStatus.TOTAL_SHARDS:
        // Verify deserialized object
                            case TieringStatus.RUNNING_SHARDS:
        assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        originalStatus.setShardLevelStatus(new TieringStatus.ShardLevelStatus(shardCounters, new ArrayList<>()));
        BytesStreamOutput out = new BytesStreamOutput();
        assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
                case TieringStatus.TARGET:
        assertEquals(originalStatus.getTarget(), deserializedStatus.getTarget());
        shardCounters.put(TieringStatus.PENDING_SHARDS, 2);
                assertEquals("RUNNING", parser.text());  
        assertEquals(originalStatus.getTarget(), deserializedStatus.getTarget());  
                    assertEquals("hot", parser.text());  
        long startTime = 123L;
        // Serialize and deserialize
import java.util.Collections;  
        XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder));
        assertEquals(originalStatus.getIndexName(), deserializedStatus.getIndexName());
        assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
 * The OpenSearch Contributors require contributions made to  
        assertEquals(original.getTieringStatus().getIndexName(), deserialized.getTieringStatus().getIndexName());
        final GetTieringStatusResponse response = new GetTieringStatusResponse(status);
        StreamInput in = out.bytes().streamInput();
}
import org.opensearch.common.io.stream.BytesStreamOutput;
                assertEquals("test-index", parser.text());
        List<TieringStatus.OngoingShard> ongoingShards = Collections.singletonList(new TieringStatus.OngoingShard(1, "node1"));
                case TieringStatus.STATE:
        XContentBuilder builder = JsonXContent.contentBuilder();  
        // Create sample data  
        assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
                    assertEquals("RUNNING", parser.text());  
        assertNotNull(deserializedStatus.getShardLevelStatus());
 *
    public void testStreamSerialization_withNoRelocatingShards() throws IOException {
        assertEquals(originalStatus.getSource(), deserializedStatus.getSource());
                                break;
import java.util.ArrayList;
