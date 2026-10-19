                    );
                            otherRouting.unassignedInfo(),
                        unchanged = true;  
                    otherRouting.state(),
                );
                routing.writeTo(out);
            shard,
                            : (otherRouting.currentNodeId() == null ? "1" : otherRouting.currentNodeId()),
 * You may obtain a copy of the License at  
import org.opensearch.common.io.stream.BytesStreamOutput;  
                    "expected non-equality\nthis  " + routing + ",\nother " + otherRouting,
                                new Snapshot("test", new SnapshotId("s1", UUIDs.randomBase64UUID())),
        assertFalse(unassignedShard0.isRelocationSourceOf(sourceShard0a));  
    }
            if (unchanged == false) {
                if (routing.initializing()) {
import org.opensearch.Version;
                    // change current node
                    if (otherRouting.active() || otherRouting.primary() == false) {
import org.opensearch.snapshots.Snapshot;
 *     http://www.apache.org/licenses/LICENSE-2.0
            ShardRoutingState.INITIALIZING
        assertFalse(initializingShard0.isRelocationTarget());
 * Licensed to Elasticsearch under one or more contributor  
                            otherRouting.shardId(),  
                }  
        ShardRouting sourceShard0a = startedShard0.relocate("node2", -1);
        return TestShardRouting.newShardRouting(
                            otherRouting.state(),
                        unchanged = true;  
            ShardRouting routing = randomShardRouting("test", 0);  
                            otherRouting.shardId(),  
package org.opensearch.cluster.routing;
                    break;  
                    otherRouting.relocatingNodeId(),
                    do {
                    otherRouting = new ShardRouting(  
 */  
                        );  
        assertFalse(unassignedShard0.isSameAllocation(initializingShard1));
                        otherRouting.getIndexName(),
                        otherRouting.allocationId(),
                routing = new ShardRouting(out.bytes().streamInput());  
 * ownership. Elasticsearch licenses this file to you under  
        );
                case 2:  
        assertFalse(targetShard0a.isRelocationTargetOf(sourceShard0b));
                    } else {
                        newState == ShardRoutingState.RELOCATING ? "2" : null,  
                            otherRouting.state(),
            if (routing.initializing() || routing.relocating()) {
            0,
            }  
                        otherRouting.id(),
    }
        assertTrue(targetShard0a.isRelocationTargetOf(sourceShard0a));  
                            otherRouting.allocationId(),
                            otherRouting.relocatingNodeId(),
        final ShardRouting activeShard0 = TestShardRouting.newShardRouting("test", 0, "node-1", false, ShardRoutingState.STARTED);
                    } else {
        assertTrue(sourceShard0a.isRelocationSourceOf(targetShard0a));
                    } else {
                            otherRouting.recoverySource(),
 * Modifications Copyright OpenSearch Contributors. See
/*  
                    ShardRoutingState newState;
                            otherRouting.shardId(),  
                    break;
    }
                    otherRouting = TestShardRouting.newShardRouting(
                        newState == ShardRoutingState.UNASSIGNED  
import org.opensearch.common.UUIDs;
                    }  
                    // change primary flag  
                        unassignedInfo  
        assertFalse(unassignedShard0.isSameAllocation(unassignedShard0));  
 * Unless required by applicable law or agreed to in writing,
    public void testIsSameAllocation() {  
            index,  
                        newState = randomFrom(ShardRoutingState.values());  
        assertTrue(targetShard0a.isRelocationTarget());
/*  
import org.opensearch.repositories.IndexId;  
 * the Apache License, Version 2.0 (the "License"); you may
                    if (otherRouting.assignedToNode() == false) {
            }
            } else if (routing.started()) {
        ShardRouting sourceShard0b = startedShard0.relocate("node2", -1);
            }  
                            otherRouting.currentNodeId(),
                            otherRouting.primary(),  
                    if (otherRouting.relocating() == false) {
            state != ShardRoutingState.UNASSIGNED && randomBoolean(),
import org.opensearch.snapshots.SnapshotId;
        // test identity
}  
                        otherRouting.getIndexName(),
        assertFalse(unassignedShard0.isSameAllocation(initializingShard0));
        assertFalse(unassignedShard0.isSameAllocation(startedShard1));  
                    break;
        );  
    }
        assertTrue(initializingShard0.isSameAllocation(startedShard0));  
                            otherRouting.relocatingNodeId() + "_1",
        for (int i = 0; i < iters; i++) {
                        otherRouting.currentNodeId(),
                                UUIDs.randomBase64UUID(),  
                        otherRouting.unassignedInfo(),
    private ShardRouting randomShardRouting(String index, int shard) {  
        // test true scenarios
                        unchanged = true;  
        ShardRouting initializingShard1 = TestShardRouting.newShardRouting("test", 1, "1", randomBoolean(), ShardRoutingState.INITIALIZING);
        ShardRouting targetShard0a = sourceShard0a.getTargetRelocatingShard();  
        ShardRouting startedShard0 = initializingShard0.moveToStarted();
        // test different shards/nodes/state
                assertFalse(routing.toString(), routing.toString().contains("expected_shard_size [" + byteSize + "]"));
        // test unassigned is false even to itself
 */  
                        : new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, otherRouting.unassignedInfo().getMessage() + "_1")
                        otherRouting.currentNodeId(),
        ShardRouting otherRouting = routing;
                        otherRouting.unassignedInfo()
                        otherRouting.getExpectedShardSize()
                                Version.CURRENT,
        assertFalse(targetShard0a.isRelocationTargetOf(unassignedShard0));  
        assertFalse(startedShard0.isRelocationSourceOf(sourceShard0a));
        // test different shard states
            state == ShardRoutingState.UNASSIGNED ? null : "1",
                assertFalse(
            state == ShardRoutingState.RELOCATING ? "2" : null,  
                case 1:
public class ShardRoutingTests extends OpenSearchTestCase {
 * this work for additional information regarding copyright
                case 3:  
        assertFalse(unassignedShard0.isSameAllocation(unassignedShard1));  
            ShardRoutingState.INITIALIZING
                    // change state  
                    UnassignedInfo unassignedInfo = otherRouting.unassignedInfo();  
                    break;
        // test two shards are not mixed  
import java.io.IOException;
        );  
                        otherRouting.currentNodeId(),  
        ShardRouting initializingShard1 = TestShardRouting.newShardRouting(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testEqualsIgnoringVersion() {
                            otherRouting.primary(),  
                            otherRouting.state(),
                        otherRouting.relocatingNodeId(),
    public void testExpectedSize() throws IOException {  
                case 6:
        for (int changeId : randomSubsetOf(randomIntBetween(1, changeIds.length), changeIds)) {
        ShardRouting sourceShard1 = startedShard1.relocate("node2", -1);  
                            new RecoverySource.SnapshotRecoverySource(
        assertFalse(startedShard0.isRelocationSourceOf(targetShard0a));  
                    assertFalse(routing.toString(), routing.toString().contains("expected_shard_size[" + byteSize + "]"));
                    routing.equalsIgnoringMetadata(otherRouting)  
        assertFalse(sourceShard0a.isRelocationTargetOf(startedShard0));
            "node1",
        assertFalse(initializingShard0.isRelocationSourceOf(sourceShard0a));
                    // change index
 * specific language governing permissions and limitations
                case 0:
        assertFalse(activeReplicaShard1.primary());  
                        otherRouting.id(),  
                        otherRouting.primary() == false,  
                    break;
            "node1",  
        final ShardRouting activeReplicaShard1 = activeShard1.moveActivePrimaryToReplica();
                    otherRouting = TestShardRouting.newShardRouting(  
        assertThrows(AssertionError.class, unassignedShard0::moveActivePrimaryToReplica);
 * KIND, either express or implied.  See the License for the
 *  
 * software distributed under the License is distributed on an
    public void testIsSourceTargetRelocation() {  
        assertFalse(sourceShard0a.isRelocationTargetOf(unassignedShard0));
                    ShardId shardId = new ShardId(new Index("blubb", randomAlphaOfLength(10)), otherRouting.id());  
import org.opensearch.core.index.shard.ShardId;
                            otherRouting.getExpectedShardSize()
                routing = ShardRoutingHelper.relocate(routing, "foo", byteSize);
/*
        assertTrue(initializingShard0.isSameAllocation(initializingShard0));  
            switch (changeId) {  
                        otherRouting.recoverySource(),  
    public void testSwapPrimaryWithReplica() {  
                    otherRouting = new ShardRouting(
                        otherRouting.unassignedInfo(),
                        otherRouting = new ShardRouting(
                    otherRouting.unassignedInfo() == null
        final int iters = randomIntBetween(10, 100);
        assertFalse(targetShard0a.isRelocationTargetOf(sourceShard1));
                            otherRouting.unassignedInfo(),  
        assertThrows(IllegalShardRoutingStateException.class, activeShard0::moveActivePrimaryToReplica);
                case 4:  
                    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.index.Index;
                            otherRouting.getExpectedShardSize()
                        otherRouting.getExpectedShardSize()  
                    otherRouting.currentNodeId(),
    }
 *
                    }
                );
        final ShardRouting activeShard1 = TestShardRouting.newShardRouting("test", 0, "node-1", true, ShardRoutingState.STARTED);
 * SPDX-License-Identifier: Apache-2.0
                            otherRouting.allocationId(),
                    // change relocating node
            } else {  
        ShardRouting startedShard1 = initializingShard1.moveToStarted();
        // test two allocations are not mixed
 * compatible open source license.
                            otherRouting.currentNodeId() + "_1",
                        otherRouting.primary(),
        ShardRouting startedShard1 = initializingShard1.moveToStarted();  
                        otherRouting.state(),
            randomBoolean(),
                        otherRouting.allocationId(),  
 * under the License.  
                    otherRouting.getIndexName(),
                            otherRouting.unassignedInfo(),  
                    otherRouting.id(),  
                            ),
            randomBoolean(),  
                routing = ShardRoutingHelper.initialize(routing, "foo", byteSize);  
                otherRouting = TestShardRouting.newShardRouting(
            if (routing.unassigned()) {
        assertFalse(initializingShard0.isRelocationSourceOf(targetShard0a));
        assertFalse(sourceShard0b.isRelocationSourceOf(targetShard0a));  
                            otherRouting.currentNodeId(),
 * not use this file except in compliance with the License.
                            otherRouting.getExpectedShardSize()
                                new IndexId("test", UUIDs.randomBase64UUID(random()))  
        ShardRouting startedShard0 = initializingShard0.moveToStarted();
                    break;
 * The OpenSearch Contributors require contributions made to  
        assertFalse(targetShard0a.isRelocationTargetOf(startedShard0));
                    // change shard id
import org.opensearch.test.OpenSearchTestCase;  
        }
                    break;
                // change unassigned info  
                        otherRouting = new ShardRouting(
                    );
            "test",
            state
            1,
        ShardRouting initializingShard0 = TestShardRouting.newShardRouting(
        ShardRouting unassignedShard1 = TestShardRouting.newShardRouting("test", 1, null, false, ShardRoutingState.UNASSIGNED);
                        otherRouting.primary(),
                    );  
                            otherRouting.relocatingNodeId(),
                if (byteSize >= 0) {
                byteSize = -1;
                        newState,
                    routing = routing.moveToStarted();
        assertFalse(startedShard1.isRelocationTarget());  
        assertFalse(targetShard0a.isRelocationTargetOf(initializingShard0));
            long byteSize = randomIntBetween(0, Integer.MAX_VALUE);
                        );  
        final ShardRouting unassignedShard0 = TestShardRouting.newShardRouting("test", 0, null, false, ShardRoutingState.UNASSIGNED);
                            otherRouting.allocationId(),  
                    assertEquals(-1, routing.getExpectedShardSize());  
                        otherRouting.relocatingNodeId(),
        assertFalse(startedShard0.isRelocationTarget());  
        ShardRoutingState state = randomFrom(ShardRoutingState.values());
            if (randomBoolean()) {  
                        ? new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "test")  
 */
            boolean unchanged = false;
    }
                        unassignedInfo = new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "test");  
                }
        assertFalse(sourceShard0a.isRelocationTargetOf(initializingShard0));  
                        otherRouting.recoverySource(),
 * GitHub history for details.
                case 5:
        ShardRouting initializingShard0 = TestShardRouting.newShardRouting("test", 0, "1", randomBoolean(), ShardRoutingState.INITIALIZING);  
        ShardRouting unassignedShard0 = TestShardRouting.newShardRouting("test", 0, null, false, ShardRoutingState.UNASSIGNED);
 * license agreements. See the NOTICE file distributed with
        assertFalse(sourceShard1.isRelocationSourceOf(targetShard0a));
            }
                    otherRouting.primary(),  
 *
        ShardRouting unassignedShard0 = TestShardRouting.newShardRouting("test", 0, null, false, ShardRoutingState.UNASSIGNED);
        }  
                    if (unassignedInfo == null
            }  
                            otherRouting.primary(),  
                        otherRouting.relocatingNodeId(),  
                            ? null
                BytesStreamOutput out = new BytesStreamOutput();
        ShardRouting routing = randomShardRouting("test", 0);
                    // change recovery source (only works for inactive primaries)
        Integer[] changeIds = new Integer[] { 0, 1, 2, 3, 4, 5, 6 };  
        assertFalse(initializingShard1.isRelocationTarget());
        // test same allocation different state
            "test",  
                        otherRouting.state(),
                        otherRouting.state(),  
                        && (newState == ShardRoutingState.UNASSIGNED || newState == ShardRoutingState.INITIALIZING)) {
        assertFalse(sourceShard0a.isRelocationTarget());
                        shardId,
            } else {  
                        otherRouting = new ShardRouting(
                    } while (newState == otherRouting.state());
                        new ShardId(otherRouting.index(), otherRouting.id() + 1),
            }
            if (randomBoolean()) {
                    );
                    assertTrue(routing.toString(), routing.toString().contains("expected_shard_size[" + byteSize + "]"));
                logger.debug("comparing\nthis  {} to\nother {}", routing, otherRouting);  
                            otherRouting.recoverySource(),
                        );
                    }
                assertEquals(byteSize, routing.getExpectedShardSize());
                assertEquals(routing.toString(), byteSize, routing.getExpectedShardSize());  
        assertFalse(unassignedShard0.isRelocationSourceOf(targetShard0a));
                        otherRouting.primary(),
