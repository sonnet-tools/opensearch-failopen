            ShardRoutingState.STARTED  
    }
        for (ShardRoutingState state : ShardRoutingState.values()) {
        ShardRouting shard = TestShardRouting.newShardRouting(
    }
        assertFalse(shard.started());  
/*  
            true,
    public void testSplittingMethodReturnsTrueForSplittingState() {
        assertFalse(shard.isSplitTarget());  
            null,
        assertFalse(splitting.relocating());
    public void testAllStatesRoundTrip() {
package org.opensearch.cluster.routing;
            true,
            0,
 *
    public void testIsSplitTargetReturnsFalseForNormalShard() {
public class ShardRoutingStateSplitTests extends OpenSearchTestCase {
        assertFalse(started.splitting());
        assertNull(shard.getRecoveringChildShards());
    }
            new ShardId(new Index("idx", "uuid"), 0),  
            false,
            ShardRoutingState.STARTED  
        assertFalse(splitting.started());
        );
 * The OpenSearch Contributors require contributions made to  
    public void testSplittingShardIsActive() {
    public void testSplittingMethodReturnsFalseForOtherStates() {
            null,
            ShardRoutingState.SPLITTING  
    }
        assertNull(shard.getParentShardId());
        ShardRouting shard = TestShardRouting.newShardRouting(  
    }  
 * SPDX-License-Identifier: Apache-2.0
    }
    public void testFromValueInvalid() {  
            "node1",
        }
import org.opensearch.core.index.Index;
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.test.OpenSearchTestCase;  
            ShardRoutingState.SPLITTING,  
    public void testFromValueSplitting() {
            new ShardId(new Index("idx", "uuid"), 0),
    }  
    }  
        );
            new ShardId(new Index("idx", "uuid"), 0),  
 * this file be licensed under the Apache-2.0 license or a
            null  
            "node1",
        assertTrue(shard.splitting());
        );
        assertEquals((byte) 5, ShardRoutingState.SPLITTING.value());
        assertTrue(splitting.active());
        assertTrue(splitting.splitting());  
            null,  
            new ShardId("index", "uuid", 0),
        ShardRouting splitting = new ShardRouting(  
            true,
            "node1",
            new ShardId(new Index("idx", "uuid"), 0),  
 */  
        );
    public void testGetRecoveringChildShardsReturnsNullForNonSplittingShard() {
            true,
}
            "node1",
            null,
        expectThrows(IllegalStateException.class, () -> ShardRoutingState.fromValue((byte) 6));
 * compatible open source license.
    }  
        assertFalse(shard.relocating());
            ShardRoutingState.STARTED
        );
        ShardRouting shard = TestShardRouting.newShardRouting(
            assertEquals(state, ShardRoutingState.fromValue(state.value()));  
        assertEquals(ShardRoutingState.SPLITTING, ShardRoutingState.fromValue((byte) 5));  
            "node1",
            true,  
            AllocationId.newInitializing(),  
        ShardRouting started = TestShardRouting.newShardRouting(
    public void testSplittingStateValue() {
