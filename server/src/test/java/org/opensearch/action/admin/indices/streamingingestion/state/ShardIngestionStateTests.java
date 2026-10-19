            }
public class ShardIngestionStateTests extends OpenSearchTestCase {  
        // Verify index2 shards
import java.util.Map;
        assertEquals(2, groupedStates.size());
package org.opensearch.action.admin.indices.streamingingestion.state;
            }  
        }
            state.writeTo(out);
        ShardIngestionState state = new ShardIngestionState("index1", 0, "POLLING", "DROP", false, false, "", true, "node");  
            new ShardIngestionState("index1", 1, "PAUSED", "DROP", false, false, "", true, "node"),
 *
import org.opensearch.core.common.io.stream.StreamInput;
        assertEquals(0, indexStates2.get(0).getShardId());  
                ShardIngestionState deserializedState = new ShardIngestionState(in);  
        List<ShardIngestionState> indexStates1 = groupedStates.get("index1");  
            new ShardIngestionState("index1", 0, "POLLING", "DROP", true, false, "", true, "node"),
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
                assertEquals(state.isPrimary(), deserializedState.isPrimary());
    public void testSerializationWithNullValues() throws IOException {
                assertEquals(state.getShardId(), deserializedState.getShardId());
        ShardIngestionState[] states = new ShardIngestionState[] {  
 */  
                assertEquals(state.getShardId(), deserializedState.getShardId());
                assertEquals(state.getBatchStartPointer(), deserializedState.getBatchStartPointer());  
                assertEquals(state.isPollerPaused(), deserializedState.isPollerPaused());
}
        assertEquals(1, indexStates1.get(1).getShardId());
                assertNull(deserializedState.getPollerState());
 * compatible open source license.
        ShardIngestionState state = new ShardIngestionState("index1", 0, null, null, false, false, "", true, "");
            try (StreamInput in = out.bytes().streamInput()) {
    }
                assertEquals(state.getIndex(), deserializedState.getIndex());  
                ShardIngestionState deserializedState = new ShardIngestionState(in);
    }
                assertEquals(state.getNodeName(), deserializedState.getNodeName());
                assertEquals(state.getPollerState(), deserializedState.getPollerState());  
            state.writeTo(out);  
        Map<String, List<ShardIngestionState>> groupedStates = ShardIngestionState.groupShardStateByIndex(states);
/*  
    public void testGroupShardStateByIndex() {
                assertEquals(state.isPollerPaused(), deserializedState.isPollerPaused());  
import org.opensearch.common.io.stream.BytesStreamOutput;
            new ShardIngestionState("index2", 0, "POLLING", "DROP", true, false, "", true, "node") };  
        // Verify index1 shards
import java.io.IOException;
        assertEquals(2, groupedStates.get("index1").size());
                assertEquals(state.isWriteBlockEnabled(), deserializedState.isWriteBlockEnabled());
            try (StreamInput in = out.bytes().streamInput()) {
        assertEquals(0, indexStates1.get(0).getShardId());
        try (BytesStreamOutput out = new BytesStreamOutput()) {
import java.util.List;  
    public void testSerialization() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchTestCase;  
    }  
                assertEquals(state.getIndex(), deserializedState.getIndex());
        assertEquals(1, groupedStates.get("index2").size());  
        }
        List<ShardIngestionState> indexStates2 = groupedStates.get("index2");
        try (BytesStreamOutput out = new BytesStreamOutput()) {
