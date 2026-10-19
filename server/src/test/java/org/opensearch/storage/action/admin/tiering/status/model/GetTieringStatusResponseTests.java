                        switch (shardField) {
        TieringStatus originalStatus = new TieringStatus("test-index", "RUNNING", "hot", "warm", 123L);
            new TieringStatus.OngoingShard(2, "node2")
        assertEquals(originalStatus.getSource(), deserializedStatus.getSource());
                                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        shardCounters.put(TieringStatus.SUCCEEDED_SHARDS, 3);
        TieringStatus deserializedStatus = TieringStatus.readFrom(in);
        shardCounters.put(TieringStatus.RUNNING_SHARDS, 1);
                                assertEquals("relocating_node_id", parser.currentName());
                                assertEquals("source_shard_id", parser.currentName());
/*
 * this file be licensed under the Apache-2.0 license or a
            } else if (currentFieldName.equals(TieringStatus.SOURCE)) {
                    assertEquals("warm", parser.text());
        final GetTieringStatusResponse response = new GetTieringStatusResponse(status);
                                break;
        XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder));
        // Serialize and deserialize
                                assertEquals("relocating_node_id", parser.currentName());
                case TieringStatus.TARGET:
                                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
                                assertEquals("node2", parser.text());
import org.opensearch.core.common.bytes.BytesReference;
        assertEquals(originalStatus.getTarget(), deserializedStatus.getTarget());
                            case TieringStatus.PENDING_SHARDS:
        shardCounters.put(TieringStatus.TOTAL_SHARDS, 6);
        assertEquals(original.getTieringStatus().getIndexName(), deserialized.getTieringStatus().getIndexName());
        // Verify deserialized object
        response.toXContent(builder, ToXContent.EMPTY_PARAMS);
                    assertEquals(XContentParser.Token.START_OBJECT, parser.currentToken());
                case TieringStatus.START_TIME:
                    while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
        BytesStreamOutput out = new BytesStreamOutput();
        List<TieringStatus.OngoingShard> ongoingShards = Arrays.asList(
import org.opensearch.common.xcontent.json.JsonXContent;
                                assertEquals(1, parser.intValue());
        TieringStatus.ShardLevelStatus shardStatus = new TieringStatus.ShardLevelStatus(shardCounters, ongoingShards);
        TieringStatus originalStatus = new TieringStatus("test-index", "RUNNING", "hot", "warm", 123L);
        assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
                case TieringStatus.SHARD_LEVEL_STATUS:
import org.opensearch.common.io.stream.BytesStreamOutput;
                    assertEquals("test-index", parser.text());
        List<TieringStatus.OngoingShard> ongoingShards = Collections.singletonList(new TieringStatus.OngoingShard(1, "node1"));
import java.util.Map;
                                assertEquals(2, parser.intValue());
        // Create sample data
                                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
                                assertEquals(XContentParser.Token.END_ARRAY, parser.nextToken());
import org.opensearch.core.common.io.stream.StreamInput;
                    break;
            String fieldName = parser.currentName();
                                break;
                        String shardField = parser.currentName();
                                assertEquals(XContentParser.Token.VALUE_NUMBER, parser.nextToken());
        status.setShardLevelStatus(shardStatus);
        StreamInput in = out.bytes().streamInput();
 * The OpenSearch Contributors require contributions made to
                    assertEquals(123L, parser.longValue());
        );
 *
        shardCounters.put(TieringStatus.RUNNING_SHARDS, 1);
import java.io.IOException;
                assertEquals("warm", parser.text());
        shardCounters.put(TieringStatus.SUCCEEDED_SHARDS, 3);
                    }
        String source = "hot";
                case TieringStatus.INDEX:
                                assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
                            case TieringStatus.SUCCEEDED_SHARDS:
            new TieringStatus.OngoingShard(1, "node1"),
        originalStatus.setShardLevelStatus(new TieringStatus.ShardLevelStatus(shardCounters, new ArrayList<>()));
        while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
        assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
        assertEquals(TieringStatus.TIERING_STATUS, parser.currentName());
                                // Second ongoing shard
        assertEquals(3, deserializedStatus.getShardLevelStatus().getShardLevelCounters().get(TieringStatus.SUCCEEDED_SHARDS).intValue());
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(originalStatus.getIndexName(), deserializedStatus.getIndexName());
        response.toXContent(builder, ToXContent.EMPTY_PARAMS);
            } else if (currentFieldName.equals(TieringStatus.TARGET)) {
import org.opensearch.core.xcontent.ToXContent;
        String state = "RUNNING";
                    break;
        TieringStatus status = new TieringStatus("test-index", "RUNNING", "hot", "warm", 123);
        assertEquals(originalStatus.getIndexName(), deserializedStatus.getIndexName());
        shardCounters.put(TieringStatus.TOTAL_SHARDS, 6);
import java.util.HashMap;
package org.opensearch.storage.action.admin.tiering.status.model;
        assertEquals(originalStatus.getSource(), deserializedStatus.getSource());
                                assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
    }
    }
 * SPDX-License-Identifier: Apache-2.0
        Map<String, Integer> shardCounters = new HashMap<>();
        GetTieringStatusResponse deserialized = new GetTieringStatusResponse(in);
            }
        assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        shardCounters.put(TieringStatus.PENDING_SHARDS, 2);
        }
        assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        XContentBuilder builder = JsonXContent.contentBuilder();
        originalStatus.setShardLevelStatus(new TieringStatus.ShardLevelStatus(shardCounters, ongoingShards));
            parser.nextToken();
        shardCounters.put(TieringStatus.PENDING_SHARDS, 2);
 * compatible open source license.
        // Verify deserialized object
        // Create original object
                                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
        originalStatus.writeTo(out);
                assertEquals("RUNNING", parser.text());
        original.writeTo(out);
            } else if (currentFieldName.equals(TieringStatus.STATE)) {
    public void testStreamSerialization_withNoRelocatingShards() throws IOException {
        Map<String, Integer> shardCounters = new HashMap<>();
            switch (fieldName) {
        TieringStatus status = new TieringStatus("test-index", "RUNNING", "hot", "warm", 123L);
import java.util.Arrays;
                            case TieringStatus.RUNNING_SHARDS:
        assertEquals(originalStatus.getStartTime(), deserializedStatus.getStartTime());
                                break;
                                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
        // Serialize and deserialize
    public void testResponseStreamSerialization() throws IOException {
                            case "shard_relocation_status":
        assertNotNull(deserializedStatus.getShardLevelStatus());
        XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder));
        // Verify the parsed content
            // assertEquals(XContentParser.Token.VALUE_STRING, parser.nextToken());
                    break;
public class GetTieringStatusResponseTests extends OpenSearchTestCase {
    public void testTieringStatusSerialization() throws IOException {
                                assertEquals(6, parser.intValue());
        shardCounters.put(TieringStatus.PENDING_SHARDS, 2);
                                assertEquals(XContentParser.Token.VALUE_STRING, parser.nextToken());
        assertEquals(3, deserializedStatus.getShardLevelStatus().getShardLevelCounters().get(TieringStatus.SUCCEEDED_SHARDS).intValue());
import org.opensearch.core.xcontent.XContentParser;
        assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
            final String currentFieldName = parser.currentName();
                                assertEquals(3, parser.intValue());
            if (currentFieldName.equals(TieringStatus.INDEX)) {
        // Test XContent serialization
                                assertEquals("node1", parser.text());
                                // First ongoing shard
 */
    }
        assertEquals(2, deserializedStatus.getShardLevelStatus().getShardLevelCounters().get(TieringStatus.PENDING_SHARDS).intValue());
                                assertEquals(XContentParser.Token.START_ARRAY, parser.currentToken());
                            case TieringStatus.TOTAL_SHARDS:
import java.util.Collections;
                assertEquals(123, parser.longValue());
                case TieringStatus.STATE:
                                assertEquals(XContentParser.Token.VALUE_NUMBER, parser.nextToken());
        Map<String, Integer> shardCounters = new HashMap<>();
import java.util.ArrayList;
        TieringStatus status = new TieringStatus(indexName, state, source, target, startTime);
        }
        originalStatus.writeTo(out);
        StreamInput in = out.bytes().streamInput();
                                assertEquals(1, parser.intValue());
    }
            parser.nextToken();
                                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
        assertEquals(originalStatus.getStatus(), deserializedStatus.getStatus());
                assertEquals("hot", parser.text());
                    break;
import org.opensearch.storage.action.tiering.status.model.GetTieringStatusResponse;
        assertEquals(originalStatus.getStatus(), deserializedStatus.getStatus());
        assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
        assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
        shardCounters.put(TieringStatus.SUCCEEDED_SHARDS, 3);
        StreamInput in = out.bytes().streamInput();
                case TieringStatus.SOURCE:
            } else if (currentFieldName.equals(TieringStatus.START_TIME)) {
                    assertEquals("RUNNING", parser.text());
        assertEquals(original.getTieringStatus().getStatus(), deserialized.getTieringStatus().getStatus());
        long startTime = 123L;
        while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
        shardCounters.put(TieringStatus.RUNNING_SHARDS, 1);
import org.opensearch.core.xcontent.XContentBuilder;
                                break;
                        parser.nextToken();
                    break;
    }
        assertEquals(originalStatus.getStartTime(), deserializedStatus.getStartTime());
        assertEquals(TieringStatus.TIERING_STATUS, parser.currentName());
    public void testStreamSerialization_withRelocatingShards() throws IOException {
        assertEquals(originalStatus.getTarget(), deserializedStatus.getTarget());
                                assertEquals("source_shard_id", parser.currentName());
                    assertEquals("hot", parser.text());
}
        XContentBuilder builder = JsonXContent.contentBuilder();
    public void testXContent() throws IOException {
                        }
        String target = "warm";
        final GetTieringStatusResponse response = new GetTieringStatusResponse(status);
        BytesStreamOutput out = new BytesStreamOutput();
                                break;
                    break;
                                assertEquals(XContentParser.Token.VALUE_STRING, parser.nextToken());
        BytesStreamOutput out = new BytesStreamOutput();
        // Create original object
        assertEquals(2, deserializedStatus.getShardLevelStatus().getShardLevelCounters().get(TieringStatus.PENDING_SHARDS).intValue());
        shardCounters.put(TieringStatus.TOTAL_SHARDS, 6);
        String indexName = "test-index";
import org.opensearch.storage.action.tiering.status.model.TieringStatus;
        TieringStatus deserializedStatus = TieringStatus.readFrom(in);
                                assertEquals(2, parser.intValue());
                assertEquals("test-index", parser.text());
            }
        GetTieringStatusResponse original = new GetTieringStatusResponse(status);
import java.util.List;
                    // Parse shard level counters
        assertNotNull(deserializedStatus.getShardLevelStatus());
