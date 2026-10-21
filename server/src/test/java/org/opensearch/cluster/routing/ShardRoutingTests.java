            }
            }
            if (randomBoolean()) {
        );
                    // change primary flag
                    do {
                            otherRouting.state(),
package org.opensearch.cluster.routing;
        ShardRouting startedShard0 = initializingShard0.moveToStarted();
                            otherRouting.allocationId(),
                        otherRouting = new ShardRouting(
    public void testExpectedSize() throws IOException {
                case 1:
                        otherRouting = new ShardRouting(
        // test unassigned is false even to itself
                        otherRouting.allocationId(),
        assertTrue(targetShard0a.isRelocationTarget());
                    );
            } else {
            randomBoolean(),
        assertTrue(initializingShard0.isSameAllocation(startedShard0));
                case 0:
 */
        ShardRouting startedShard1 = initializingShard1.moveToStarted();
 *     http://www.apache.org/licenses/LICENSE-2.0
                }
                    otherRouting = new ShardRouting(
import org.opensearch.common.UUIDs;
import org.opensearch.repositories.IndexId;
 * this work for additional information regarding copyright
                        newState,
                    ShardId shardId = new ShardId(new Index("blubb", randomAlphaOfLength(10)), otherRouting.id());
            if (routing.unassigned()) {
    public void testEqualsIgnoringVersion() {
        ShardRouting startedShard0 = initializingShard0.moveToStarted();
                assertEquals(routing.toString(), byteSize, routing.getExpectedShardSize());
            state
                        otherRouting.state(),
                        : new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, otherRouting.unassignedInfo().getMessage() + "_1")
        assertFalse(unassignedShard0.isSameAllocation(unassignedShard0));
                    break;
            }
        ShardRouting unassignedShard0 = TestShardRouting.newShardRouting("test", 0, null, false, ShardRoutingState.UNASSIGNED);
import org.opensearch.core.index.shard.ShardId;
                }
                if (routing.initializing()) {
                    // change relocating node
            }
                            otherRouting.currentNodeId(),
                            otherRouting.getExpectedShardSize()
            if (unchanged == false) {
        assertFalse(initializingShard1.isRelocationTarget());
                    otherRouting.primary(),
        assertTrue(initializingShard0.isSameAllocation(initializingShard0));
                    break;
                );
        ShardRoutingState state = randomFrom(ShardRoutingState.values());
            long byteSize = randomIntBetween(0, Integer.MAX_VALUE);
                        ? new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "test")
 * KIND, either express or implied.  See the License for the
                        otherRouting.currentNodeId(),
        // test two allocations are not mixed
                    // change index
                    } else {
                routing = ShardRoutingHelper.relocate(routing, "foo", byteSize);
        ShardRouting routing = randomShardRouting("test", 0);
                    }
        for (int changeId : randomSubsetOf(randomIntBetween(1, changeIds.length), changeIds)) {
                if (byteSize >= 0) {
            } else if (routing.started()) {
                        otherRouting.getIndexName(),
                            otherRouting.unassignedInfo(),
                assertEquals(byteSize, routing.getExpectedShardSize());
        ShardRouting startedShard1 = initializingShard1.moveToStarted();
                    // change recovery source (only works for inactive primaries)
import org.opensearch.core.index.Index;
    public void testIsSameAllocation() {
                    UnassignedInfo unassignedInfo = otherRouting.unassignedInfo();
                            otherRouting.primary(),
                        otherRouting = new ShardRouting(
                            new RecoverySource.SnapshotRecoverySource(
            1,
                    );
 * compatible open source license.
                        && (newState == ShardRoutingState.UNASSIGNED || newState == ShardRoutingState.INITIALIZING)) {
                        shardId,
                        newState == ShardRoutingState.UNASSIGNED
        ShardRouting sourceShard0b = startedShard0.relocate("node2", -1);
            0,
        assertFalse(initializingShard0.isRelocationTarget());
        assertFalse(sourceShard0a.isRelocationTargetOf(initializingShard0));
                    otherRouting.id(),
            "node1",
        assertFalse(startedShard0.isRelocationTarget());
    public void testSwapPrimaryWithReplica() {
                        unchanged = true;
                    otherRouting = TestShardRouting.newShardRouting(
        Integer[] changeIds = new Integer[] { 0, 1, 2, 3, 4, 5, 6 };
                    otherRouting.relocatingNodeId(),
        assertFalse(targetShard0a.isRelocationTargetOf(unassignedShard0));
                        otherRouting.getExpectedShardSize()
import java.io.IOException;
                    if (otherRouting.active() || otherRouting.primary() == false) {
                        otherRouting.getExpectedShardSize()
        return TestShardRouting.newShardRouting(
 *
                        otherRouting.primary() == false,
                        otherRouting.state(),
                        );
        final ShardRouting activeReplicaShard1 = activeShard1.moveActivePrimaryToReplica();
                    break;
 * SPDX-License-Identifier: Apache-2.0
        assertFalse(targetShard0a.isRelocationTargetOf(startedShard0));
        assertFalse(sourceShard0b.isRelocationSourceOf(targetShard0a));
 */
 * GitHub history for details.
        assertFalse(initializingShard0.isRelocationSourceOf(sourceShard0a));
                                new IndexId("test", UUIDs.randomBase64UUID(random()))
 *
                    assertFalse(routing.toString(), routing.toString().contains("expected_shard_size[" + byteSize + "]"));
                routing.writeTo(out);
        ShardRouting sourceShard0a = startedShard0.relocate("node2", -1);
                    );
                        unchanged = true;
 */
import org.opensearch.snapshots.SnapshotId;
            ShardRoutingState.INITIALIZING
        assertFalse(startedShard0.isRelocationSourceOf(sourceShard0a));
                    // change current node
        // test different shards/nodes/state
                    assertEquals(-1, routing.getExpectedShardSize());
                            otherRouting.allocationId(),
        assertFalse(sourceShard1.isRelocationSourceOf(targetShard0a));
        ShardRouting initializingShard1 = TestShardRouting.newShardRouting(
        ShardRouting initializingShard0 = TestShardRouting.newShardRouting("test", 0, "1", randomBoolean(), ShardRoutingState.INITIALIZING);
        assertFalse(targetShard0a.isRelocationTargetOf(sourceShard0b));
                        unassignedInfo = new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "test");
 * not use this file except in compliance with the License.
        assertFalse(unassignedShard0.isRelocationSourceOf(sourceShard0a));
    }
                case 6:
 * Modifications Copyright OpenSearch Contributors. See
        assertThrows(IllegalShardRoutingStateException.class, activeShard0::moveActivePrimaryToReplica);
        assertFalse(unassignedShard0.isSameAllocation(initializingShard1));
 * software distributed under the License is distributed on an
                        otherRouting.id(),
                        unchanged = true;
    }
                        otherRouting.currentNodeId(),
                        newState == ShardRoutingState.RELOCATING ? "2" : null,
                    break;
            }
                BytesStreamOutput out = new BytesStreamOutput();
                case 4:
                        otherRouting.recoverySource(),
        }
                    }
                            otherRouting.getExpectedShardSize()
                );
                // change unassigned info
                case 5:
                        otherRouting.primary(),
                case 2:
 * specific language governing permissions and limitations
            state != ShardRoutingState.UNASSIGNED && randomBoolean(),
                    assertTrue(routing.toString(), routing.toString().contains("expected_shard_size[" + byteSize + "]"));
        final int iters = randomIntBetween(10, 100);
        // test different shard states
                            ? null
            state == ShardRoutingState.UNASSIGNED ? null : "1",
                        otherRouting.id(),
            ShardRouting routing = randomShardRouting("test", 0);
                            otherRouting.relocatingNodeId() + "_1",
        final ShardRouting activeShard0 = TestShardRouting.newShardRouting("test", 0, "node-1", false, ShardRoutingState.STARTED);
        assertFalse(targetShard0a.isRelocationTargetOf(initializingShard0));
                            otherRouting.unassignedInfo(),
        assertFalse(unassignedShard0.isSameAllocation(initializingShard0));
                    if (unassignedInfo == null
                            otherRouting.getExpectedShardSize()
                    ShardRoutingState newState;
/*
                            otherRouting.shardId(),
            state == ShardRoutingState.RELOCATING ? "2" : null,
                    break;
            "test",
                        unassignedInfo
        final ShardRouting unassignedShard0 = TestShardRouting.newShardRouting("test", 0, null, false, ShardRoutingState.UNASSIGNED);
                        otherRouting.state(),
 * under the License.
        ShardRouting unassignedShard0 = TestShardRouting.newShardRouting("test", 0, null, false, ShardRoutingState.UNASSIGNED);
                        otherRouting.recoverySource(),
        );
                    break;
                            otherRouting.primary(),
 * Unless required by applicable law or agreed to in writing,
                    otherRouting = new ShardRouting(
 * You may obtain a copy of the License at
            shard,
}
                            otherRouting.unassignedInfo(),
                        otherRouting.relocatingNodeId(),
        assertFalse(initializingShard0.isRelocationSourceOf(targetShard0a));
 * Licensed to Elasticsearch under one or more contributor
                                UUIDs.randomBase64UUID(),
        ShardRouting unassignedShard1 = TestShardRouting.newShardRouting("test", 1, null, false, ShardRoutingState.UNASSIGNED);
                        otherRouting.unassignedInfo()
                    otherRouting.unassignedInfo() == null
                    otherRouting.state(),
                            otherRouting.shardId(),
                    otherRouting.getIndexName(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            } else {
    }
        assertFalse(startedShard1.isRelocationTarget());
        // test true scenarios
 *
            index,
            boolean unchanged = false;
        assertFalse(startedShard0.isRelocationSourceOf(targetShard0a));
                    } else {
                        otherRouting.relocatingNodeId(),
                        otherRouting.relocatingNodeId(),
                    if (otherRouting.assignedToNode() == false) {
 * license agreements. See the NOTICE file distributed with
                    // change shard id
            randomBoolean(),
        for (int i = 0; i < iters; i++) {
                    );
                    break;
            "node1",
                    if (otherRouting.relocating() == false) {
    public void testIsSourceTargetRelocation() {
                            otherRouting.recoverySource(),
import org.opensearch.test.OpenSearchTestCase;
        assertFalse(sourceShard0a.isRelocationTargetOf(unassignedShard0));
                byteSize = -1;
                        );
                case 3:
        ShardRouting sourceShard1 = startedShard1.relocate("node2", -1);
        assertTrue(sourceShard0a.isRelocationSourceOf(targetShard0a));
                            otherRouting.relocatingNodeId(),
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under
            "test",
                logger.debug("comparing\nthis  {} to\nother {}", routing, otherRouting);
        assertFalse(unassignedShard0.isSameAllocation(startedShard1));
                routing = ShardRoutingHelper.initialize(routing, "foo", byteSize);
                    }
        assertFalse(sourceShard0a.isRelocationTargetOf(startedShard0));
                    } while (newState == otherRouting.state());
import org.opensearch.Version;
                            otherRouting.relocatingNodeId(),
    private ShardRouting randomShardRouting(String index, int shard) {
        ShardRouting initializingShard0 = TestShardRouting.newShardRouting(
                            otherRouting.primary(),
                            otherRouting.allocationId(),
                    }
                            otherRouting.state(),
                            otherRouting.recoverySource(),
    }
        );
        assertFalse(unassignedShard0.isSameAllocation(unassignedShard1));
    }
                        otherRouting.unassignedInfo(),
                                Version.CURRENT,
                        newState = randomFrom(ShardRoutingState.values());
        assertTrue(targetShard0a.isRelocationTargetOf(sourceShard0a));
                        new ShardId(otherRouting.index(), otherRouting.id() + 1),
        // test two shards are not mixed
                    routing = routing.moveToStarted();
/*
            if (routing.initializing() || routing.relocating()) {
                otherRouting = TestShardRouting.newShardRouting(
                            otherRouting.currentNodeId() + "_1",
                    routing.equalsIgnoringMetadata(otherRouting)
                routing = new ShardRouting(out.bytes().streamInput());
                            otherRouting.currentNodeId(),
        assertFalse(sourceShard0a.isRelocationTarget());
        // test identity
 * The OpenSearch Contributors require contributions made to
                        otherRouting.currentNodeId(),
public class ShardRoutingTests extends OpenSearchTestCase {
                assertFalse(routing.toString(), routing.toString().contains("expected_shard_size [" + byteSize + "]"));
                    "expected non-equality\nthis  " + routing + ",\nother " + otherRouting,
                        otherRouting.getIndexName(),
            if (randomBoolean()) {
        assertFalse(activeReplicaShard1.primary());
import org.opensearch.common.io.stream.BytesStreamOutput;
    }
        ShardRouting initializingShard1 = TestShardRouting.newShardRouting("test", 1, "1", randomBoolean(), ShardRoutingState.INITIALIZING);
                        otherRouting.primary(),
            switch (changeId) {
                            otherRouting.shardId(),
                        );
        ShardRouting otherRouting = routing;
                            : (otherRouting.currentNodeId() == null ? "1" : otherRouting.currentNodeId()),
        // test same allocation different state
            ShardRoutingState.INITIALIZING
                    otherRouting.currentNodeId(),
                        otherRouting.unassignedInfo(),
                            ),
                        otherRouting.primary(),
        final ShardRouting activeShard1 = TestShardRouting.newShardRouting("test", 0, "node-1", true, ShardRoutingState.STARTED);
                assertFalse(
        assertThrows(AssertionError.class, unassignedShard0::moveActivePrimaryToReplica);
                    otherRouting = TestShardRouting.newShardRouting(
 * this file be licensed under the Apache-2.0 license or a
                                new Snapshot("test", new SnapshotId("s1", UUIDs.randomBase64UUID())),
        assertFalse(unassignedShard0.isRelocationSourceOf(targetShard0a));
                    // change state
        }
        assertFalse(targetShard0a.isRelocationTargetOf(sourceShard1));
                        otherRouting.allocationId(),
            }
                    } else {
import org.opensearch.snapshots.Snapshot;
        ShardRouting targetShard0a = sourceShard0a.getTargetRelocatingShard();
                            otherRouting.state(),
/*
