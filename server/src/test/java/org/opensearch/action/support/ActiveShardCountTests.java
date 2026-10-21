        final int numberOfReplicas = randomIntBetween(4, 7);
        expectThrows(IllegalArgumentException.class, () -> ActiveShardCount.parseString("-1")); // magic numbers not exposed through API
    }
        final int numberOfShards = randomIntBetween(1, 5);
        final int numberOfReplicas = randomIntBetween(4, 7);
        assertFalse(waitForActiveShards.enoughShardsActive(clusterState, indexName));
        for (final var shardEntry : indexRoutingTable.getShards().values()) {
            || activeShardCount == ActiveShardCount.ALL
        int value = randomIntBetween(1, 50);
        final Metadata metadata = Metadata.builder().put(indexMetadata, true).build();
                    if (shardRouting.active() == false) {
        final ByteBufferStreamInput in = new ByteBufferStreamInput(ByteBuffer.wrap(out.bytes().toBytesRef().bytes));
            .numberOfReplicas(numReplicas)
        for (final var shardEntry : indexRoutingTable.getShards().values()) {
                    assertTrue(shardRouting.active());
    public void testEnoughShardsActiveZero() {
        assertSame(ActiveShardCount.parseString("all"), ActiveShardCount.ALL);
        final IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
        final int numberOfShards = randomIntBetween(1, 5);
                } else {
        IndexRoutingTable.Builder newIndexRoutingTable = IndexRoutingTable.builder(indexRoutingTable.getIndex());
        return ClusterState.builder(new ClusterName("test_cluster")).metadata(metadata).build();
 *
        return ClusterState.builder(clusterState).routingTable(routingTable).build();
                            .moveToStarted();
import org.opensearch.cluster.metadata.IndexMetadata;
        clusterState = startPrimaries(clusterState, indexName);
 * ownership. Elasticsearch licenses this file to you under
        assertTrue(ActiveShardCount.from(0).enoughShardsActive(randomIntBetween(0, 50)));
        }
        ActiveShardCount readActiveShardCount = ActiveShardCount.readFrom(in);
        assertSame(ActiveShardCount.from(0), ActiveShardCount.NONE);
 * not use this file except in compliance with the License.
        assertTrue(ActiveShardCount.parseString("all").validate(randomIntBetween(0, 10)));
        assertFalse(waitForActiveShards.enoughShardsActive(clusterState, indexName));
 * GitHub history for details.
    public void testEnoughShardsActiveLevelAll() {
import org.opensearch.common.io.stream.BytesStreamOutput;
        final String indexName = "test-idx";
    private ClusterState initializeWithClosedIndex(final String indexName, final int numShards, final int numReplicas) {
        final int numberOfShards = randomIntBetween(1, 5);
    public void testEnoughShardsActiveLevelOne() {
import org.opensearch.cluster.ClusterName;
            for (ShardRouting shardRouting : shardRoutingTable.getShards()) {
        IndexRoutingTable indexRoutingTable = routingTable.index(indexName);
    }
            }
            .settings(settings(Version.CURRENT).put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID()))
    private ClusterState startPrimaries(final ClusterState clusterState, final String indexName) {
import org.opensearch.Version;
        clusterState = startPrimaries(clusterState, indexName);
package org.opensearch.action.support;
 * Modifications Copyright OpenSearch Contributors. See
    }
                if (shardRouting.primary()) {
            for (ShardRouting shardRouting : shardRoutingTable.getShards()) {
                    if (numToStart > 0) {
        // default is 1
        final IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
    public void testSerialization() throws IOException {
            .numberOfReplicas(numReplicas)
        // both values should represent "all"
 */
                        shardRouting = shardRouting.initialize(randomAlphaOfLength(8), null, shardRouting.getExpectedShardSize())
        final ClusterState clusterState = initializeWithClosedIndex(indexName, numberOfShards, numberOfReplicas);
        ClusterState clusterState = initializeWithNewIndex(indexName, numberOfShards, numberOfReplicas);
        runTestForOneActiveShard(ActiveShardCount.ONE);
        assertTrue(waitForActiveShards.enoughShardsActive(clusterState, indexName));
        clusterState = startPrimaries(clusterState, indexName);
        final String indexName = "test-idx";
        IndexRoutingTable.Builder newIndexRoutingTable = IndexRoutingTable.builder(indexRoutingTable.getIndex());
        assertTrue(waitForActiveShards.enoughShardsActive(clusterState, indexName));
    public void testEnoughShardsActiveWithClosedIndex() {
            .state(IndexMetadata.State.CLOSE)
        final String indexName = "test-idx";
/*
        assertTrue(waitForActiveShards.enoughShardsActive(clusterState, indexName));
        int threshold = randomIntBetween(1, 50);
        clusterState = startPrimaries(clusterState, indexName);
        doWriteRead(ActiveShardCount.ALL);
        assertFalse(waitForActiveShards.enoughShardsActive(clusterState, indexName));
        assertEquals("not enough information to resolve to shard count", e.getMessage());
            assertTrue(waitForActiveShards.enoughShardsActive(clusterState, indexName));
        final BytesStreamOutput out = new BytesStreamOutput();
        assertFalse(waitForActiveShards.enoughShardsActive(randomIntBetween(0, threshold - 1)));
        assertTrue(waitForActiveShards.enoughShardsActive(clusterState, indexName));
            int numToStart = numShardsToStart;
                }
        ClusterState clusterState = initializeWithNewIndex(indexName, numberOfShards, numberOfReplicas);
        doWriteRead(ActiveShardCount.from(randomIntBetween(1, 50)));
 *
        if (activeShardCount == ActiveShardCount.DEFAULT
    public void testEnoughShardsActiveValueBased() {
        IndexRoutingTable.Builder newIndexRoutingTable = IndexRoutingTable.builder(indexRoutingTable.getIndex());
        RoutingTable routingTable = clusterState.routingTable();
        assertFalse(waitForActiveShards.enoughShardsActive(clusterState, indexName));
        } else {
        return ClusterState.builder(clusterState).routingTable(routingTable).build();
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.ByteBufferStreamInput;
 */
                    if (shardRouting.active() == false) {
            }
import org.opensearch.common.UUIDs;
            int numToStart = numShardsToStart;
        assertFalse(waitForActiveShards.enoughShardsActive(clusterState, indexName));
 */
 * software distributed under the License is distributed on an
            .settings(settings(Version.CURRENT).put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID()))
 * You may obtain a copy of the License at
    }
 * specific language governing permissions and limitations
        final int numberOfShards = randomIntBetween(1, 5);
                        }
        final String indexName = "test-idx";
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        assertEquals(ActiveShardCount.from(value).toString(), Integer.toString(value));
                if (shardRouting.primary()) {
/*
    }
                            shardRouting = shardRouting.initialize(randomAlphaOfLength(8), null, shardRouting.getExpectedShardSize())
            }
        }
        ClusterState clusterState = initializeWithNewIndex(indexName, numberOfShards, numberOfReplicas);
            final IndexShardRoutingTable shardRoutingTable = shardEntry;
        // wait for zero shards should always pass
        for (final var shardEntry : indexRoutingTable.getShards().values()) {
        assertFalse(waitForActiveShards.enoughShardsActive(clusterState, indexName));
/**
    private ClusterState startAllShards(final ClusterState clusterState, final String indexName) {
        final int numberOfReplicas = randomIntBetween(4, 7);
    private void doWriteRead(ActiveShardCount activeShardCount) throws IOException {
        IndexRoutingTable indexRoutingTable = routingTable.index(indexName);
                }
        final ActiveShardCount waitForActiveShards = activeShardCount;
    private ClusterState startWaitOnShards(final ClusterState clusterState, final String indexName, final int numShardsToStart) {
            assertEquals(activeShardCount, readActiveShardCount);
        assertTrue(waitForActiveShards.enoughShardsActive(clusterState, indexName));
        assertTrue(waitForActiveShards.enoughShardsActive(clusterState, indexName));
        }
        }
        assertTrue(ActiveShardCount.from(randomIntBetween(0, numReplicas + 1)).validate(numReplicas));
            .build();
    }
        ClusterState clusterState = initializeWithNewIndex(indexName, numberOfShards, numberOfReplicas);
        waitForActiveShards = ActiveShardCount.from(randomIntBetween(threshold, 50));
                        .moveToStarted();
        final int numberOfReplicas = randomIntBetween(4, 7);
                                .moveToStarted();
        assertEquals("not enough information to resolve to shard count", e.getMessage());
    }
 * Unless required by applicable law or agreed to in writing,
        final int activeShardCount = randomIntBetween(2, numberOfReplicas);
 * compatible open source license.
                newIndexRoutingTable.addShard(shardRouting);
 * The OpenSearch Contributors require contributions made to
        expectThrows(IllegalArgumentException.class, () -> ActiveShardCount.parseString(randomIntBetween(-10, -3) + ""));
        clusterState = startAllShards(clusterState, indexName);
        routingTable = RoutingTable.builder(routingTable).add(newIndexRoutingTable).build();
    }
        routingTable = RoutingTable.builder(routingTable).add(newIndexRoutingTable).build();
        // enough shards active case
import org.opensearch.cluster.routing.IndexRoutingTable;
        // initial index creation and new routing table info
                newIndexRoutingTable.addShard(shardRouting);
                    }
    private void runTestForOneActiveShard(final ActiveShardCount activeShardCount) {
            }
        IndexRoutingTable indexRoutingTable = routingTable.index(indexName);
                        numToStart--;
        expectThrows(IllegalArgumentException.class, () -> ActiveShardCount.from(randomIntBetween(-10, -1)));
                newIndexRoutingTable.addShard(shardRouting);
        }
                    }
                            numToStart--;
import org.opensearch.cluster.ClusterState;
        final Metadata metadata = Metadata.builder().put(indexMetadata, true).build();
        return ClusterState.builder(new ClusterName("test_cluster")).metadata(metadata).routingTable(routingTable).build();
        routingTable = RoutingTable.builder(routingTable).add(newIndexRoutingTable).build();
        // invalid values
        clusterState = startAllShards(clusterState, indexName);
            assert shardRoutingTable.getSize() > 2;
            .build();
        assertTrue(waitForActiveShards.enoughShardsActive(randomIntBetween(threshold, 50)));
        assertTrue(waitForActiveShards.enoughShardsActive(clusterState, indexName));
    private ClusterState startLessThanWaitOnShards(final ClusterState clusterState, final String indexName, final int numShardsToStart) {
 * Licensed to Elasticsearch under one or more contributor
            || activeShardCount == ActiveShardCount.NONE) {
                    }
    public void testValidate() {
        IndexRoutingTable indexRoutingTable = routingTable.index(indexName);
        clusterState = startLessThanWaitOnShards(clusterState, indexName, numberOfReplicas - randomIntBetween(1, numberOfReplicas));
import org.opensearch.cluster.routing.RoutingTable;
        assertEquals(ActiveShardCount.parseString(value + ""), ActiveShardCount.from(value));
            // want less than half, and primary is already started
        }
        assertEquals("activeShardCount cannot be negative", e.getMessage());
import java.io.IOException;
import org.opensearch.cluster.routing.ShardRouting;
        activeShardCount.writeTo(out);
        assertFalse(waitForActiveShards.enoughShardsActive(clusterState, indexName));
                    } else {
    }
import java.util.Arrays;
        e = expectThrows(IllegalStateException.class, () -> ActiveShardCount.DEFAULT.enoughShardsActive(randomIntBetween(0, 50)));
        expectThrows(IllegalArgumentException.class, () -> ActiveShardCount.parseString("-2"));
        doWriteRead(ActiveShardCount.DEFAULT);
                        numToStart--;
            assertSame(activeShardCount, readActiveShardCount);
        clusterState = startAllShards(clusterState, indexName);
            final IndexShardRoutingTable shardRoutingTable = shardEntry;
 *    http://www.apache.org/licenses/LICENSE-2.0
        RoutingTable routingTable = clusterState.routingTable();
    }
    }
        final int numberOfShards = randomIntBetween(1, 5);
        final ActiveShardCount waitForActiveShards = randomBoolean() ? ActiveShardCount.from(numberOfReplicas + 1) : ActiveShardCount.ALL;
    }
                } else {
            assert shardRoutingTable.getSize() > 2;
 * the Apache License, Version 2.0 (the "License"); you may
        return ClusterState.builder(clusterState).routingTable(routingTable).build();
 * under the License.
    }
            final IndexShardRoutingTable shardRoutingTable = shardEntry;
        clusterState = startLessThanWaitOnShards(clusterState, indexName, activeShardCount - 2);
    }
        assertSame(ActiveShardCount.parseString("0"), ActiveShardCount.NONE);
        // not enough shards active
import java.nio.ByteBuffer;
        assertFalse(ActiveShardCount.from(numReplicas + randomIntBetween(2, 10)).validate(numReplicas));
                }
        assertTrue(waitForActiveShards.enoughShardsActive(clusterState, indexName));
                newIndexRoutingTable.addShard(shardRouting);
        ActiveShardCount waitForActiveShards = ActiveShardCount.from(randomIntBetween(0, threshold));
        runTestForOneActiveShard(ActiveShardCount.DEFAULT);
                } else {
        final int numReplicas = randomIntBetween(0, 10);
    public void testEnoughShardsActiveLevelDefault() {
        assertSame(ActiveShardCount.parseString(null), ActiveShardCount.DEFAULT);
public class ActiveShardCountTests extends OpenSearchTestCase {
        final ActiveShardCount waitForActiveShards = ActiveShardCount.from(activeShardCount);
import org.opensearch.cluster.metadata.Metadata;
        final RoutingTable routingTable = RoutingTable.builder().addAsNew(indexMetadata).build();
/*
    }
        final int numberOfReplicas = randomIntBetween(4, 7);
                        if (numToStart > 0) {
        for (ActiveShardCount waitForActiveShards : Arrays.asList(ActiveShardCount.DEFAULT, ActiveShardCount.ALL, ActiveShardCount.ONE)) {
        for (final var shardEntry : indexRoutingTable.getShards().values()) {
}
            for (ShardRouting shardRouting : shardRoutingTable.getShards()) {
        final String indexName = "test-idx";
        RoutingTable routingTable = clusterState.routingTable();
        final ActiveShardCount waitForActiveShards = ActiveShardCount.NONE;
        doWriteRead(ActiveShardCount.NONE);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        // invalid values shouldn't validate
        IndexRoutingTable.Builder newIndexRoutingTable = IndexRoutingTable.builder(indexRoutingTable.getIndex());
        expectThrows(IllegalArgumentException.class, () -> ActiveShardCount.parseString(randomAlphaOfLengthBetween(4, 8)));
            .numberOfShards(numShards)
            final IndexShardRoutingTable shardRoutingTable = shardEntry;
    public void testEnoughShardsActiveRandom() {
    }
import org.opensearch.test.OpenSearchTestCase;
        clusterState = startAllShards(clusterState, indexName);
 * KIND, either express or implied.  See the License for the
        e = expectThrows(IllegalArgumentException.class, () -> ActiveShardCount.NONE.enoughShardsActive(randomIntBetween(-10, -1)));
    }
 * SPDX-License-Identifier: Apache-2.0
                if (shardRouting.primary()) {
        return ClusterState.builder(clusterState).routingTable(routingTable).build();
            for (ShardRouting shardRouting : shardRoutingTable.getShards()) {
        routingTable = RoutingTable.builder(routingTable).add(newIndexRoutingTable).build();
    }
        assert activeShardCount == ActiveShardCount.ONE || activeShardCount == ActiveShardCount.DEFAULT;
 * this work for additional information regarding copyright
            .numberOfShards(numShards)
        Exception e = expectThrows(IllegalStateException.class, () -> ActiveShardCount.ALL.enoughShardsActive(randomIntBetween(0, 50)));
        final int value = randomIntBetween(1, 50);
                    assertTrue(shardRouting.active());
                            .moveToStarted();
        clusterState = startWaitOnShards(clusterState, indexName, activeShardCount - 1);
                        shardRouting = shardRouting.initialize(randomAlphaOfLength(8), null, shardRouting.getExpectedShardSize())
                    shardRouting = shardRouting.initialize(randomAlphaOfLength(8), null, shardRouting.getExpectedShardSize())
                    assertTrue(shardRouting.active());
    private ClusterState initializeWithNewIndex(final String indexName, final int numShards, final int numReplicas) {
    }
    public void testFromIntValue() {
 */
    public void testParseString() {
                if (shardRouting.primary()) {
 * this file be licensed under the Apache-2.0 license or a
 * Tests for the {@link ActiveShardCount} class
 *
                }
        RoutingTable routingTable = clusterState.routingTable();
