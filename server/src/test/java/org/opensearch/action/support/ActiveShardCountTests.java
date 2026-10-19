                } else {  
            }
        ClusterState clusterState = initializeWithNewIndex(indexName, numberOfShards, numberOfReplicas);
        IndexRoutingTable indexRoutingTable = routingTable.index(indexName);
        RoutingTable routingTable = clusterState.routingTable();
        assertFalse(waitForActiveShards.enoughShardsActive(clusterState, indexName));
        assertTrue(ActiveShardCount.from(randomIntBetween(0, numReplicas + 1)).validate(numReplicas));
        final ByteBufferStreamInput in = new ByteBufferStreamInput(ByteBuffer.wrap(out.bytes().toBytesRef().bytes));
        }
            .settings(settings(Version.CURRENT).put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID()))
        doWriteRead(ActiveShardCount.NONE);
        final ActiveShardCount waitForActiveShards = randomBoolean() ? ActiveShardCount.from(numberOfReplicas + 1) : ActiveShardCount.ALL;  
                newIndexRoutingTable.addShard(shardRouting);
        assertTrue(waitForActiveShards.enoughShardsActive(clusterState, indexName));
        final RoutingTable routingTable = RoutingTable.builder().addAsNew(indexMetadata).build();  
 * specific language governing permissions and limitations
        assertFalse(waitForActiveShards.enoughShardsActive(clusterState, indexName));  
 * You may obtain a copy of the License at  
        clusterState = startPrimaries(clusterState, indexName);
        // wait for zero shards should always pass
 * Unless required by applicable law or agreed to in writing,
        IndexRoutingTable.Builder newIndexRoutingTable = IndexRoutingTable.builder(indexRoutingTable.getIndex());
                    }
        int value = randomIntBetween(1, 50);  
                            .moveToStarted();
        RoutingTable routingTable = clusterState.routingTable();
        final ActiveShardCount waitForActiveShards = ActiveShardCount.NONE;
 * SPDX-License-Identifier: Apache-2.0
    }
        IndexRoutingTable indexRoutingTable = routingTable.index(indexName);
            .numberOfShards(numShards)
    }
                        shardRouting = shardRouting.initialize(randomAlphaOfLength(8), null, shardRouting.getExpectedShardSize())  
        assertFalse(waitForActiveShards.enoughShardsActive(randomIntBetween(0, threshold - 1)));  
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.cluster.routing.ShardRouting;  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testFromIntValue() {  
public class ActiveShardCountTests extends OpenSearchTestCase {
        final int numberOfReplicas = randomIntBetween(4, 7);  
 */
        assertTrue(waitForActiveShards.enoughShardsActive(clusterState, indexName));
        }
 * GitHub history for details.
        routingTable = RoutingTable.builder(routingTable).add(newIndexRoutingTable).build();
/**
 * KIND, either express or implied.  See the License for the
        final int activeShardCount = randomIntBetween(2, numberOfReplicas);
                        numToStart--;
        }  
/*  
import org.opensearch.cluster.metadata.Metadata;
                if (shardRouting.primary()) {
    private ClusterState startLessThanWaitOnShards(final ClusterState clusterState, final String indexName, final int numShardsToStart) {  
    }
        return ClusterState.builder(clusterState).routingTable(routingTable).build();
    private void runTestForOneActiveShard(final ActiveShardCount activeShardCount) {
 */  
        clusterState = startPrimaries(clusterState, indexName);  
                    }
 * not use this file except in compliance with the License.
        // default is 1  
        final int numberOfShards = randomIntBetween(1, 5);  
        final IndexMetadata indexMetadata = IndexMetadata.builder(indexName)  
        IndexRoutingTable indexRoutingTable = routingTable.index(indexName);  
    }
            assertSame(activeShardCount, readActiveShardCount);  
 */  
        IndexRoutingTable.Builder newIndexRoutingTable = IndexRoutingTable.builder(indexRoutingTable.getIndex());  
        final int numberOfReplicas = randomIntBetween(4, 7);
        assertEquals(ActiveShardCount.parseString(value + ""), ActiveShardCount.from(value));
        assertEquals("not enough information to resolve to shard count", e.getMessage());
    }  
    }
        assertTrue(ActiveShardCount.from(0).enoughShardsActive(randomIntBetween(0, 50)));
        runTestForOneActiveShard(ActiveShardCount.DEFAULT);
            int numToStart = numShardsToStart;
            final IndexShardRoutingTable shardRoutingTable = shardEntry;
        return ClusterState.builder(clusterState).routingTable(routingTable).build();
        assertFalse(waitForActiveShards.enoughShardsActive(clusterState, indexName));
    private ClusterState initializeWithNewIndex(final String indexName, final int numShards, final int numReplicas) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testEnoughShardsActiveWithClosedIndex() {  
 *  
        assertTrue(waitForActiveShards.enoughShardsActive(clusterState, indexName));
        routingTable = RoutingTable.builder(routingTable).add(newIndexRoutingTable).build();  
                }  
                    } else {
        }
}
            .build();
 */  
    private void doWriteRead(ActiveShardCount activeShardCount) throws IOException {
        assertTrue(waitForActiveShards.enoughShardsActive(clusterState, indexName));
                newIndexRoutingTable.addShard(shardRouting);  
    public void testEnoughShardsActiveLevelDefault() {
                if (shardRouting.primary()) {
        final String indexName = "test-idx";
                if (shardRouting.primary()) {
        // invalid values shouldn't validate  
        routingTable = RoutingTable.builder(routingTable).add(newIndexRoutingTable).build();
        clusterState = startPrimaries(clusterState, indexName);  
                    assertTrue(shardRouting.active());  
            for (ShardRouting shardRouting : shardRoutingTable.getShards()) {
                }
        assertSame(ActiveShardCount.from(0), ActiveShardCount.NONE);
        ActiveShardCount readActiveShardCount = ActiveShardCount.readFrom(in);
        final int numberOfShards = randomIntBetween(1, 5);
 * The OpenSearch Contributors require contributions made to  
        final IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
        e = expectThrows(IllegalStateException.class, () -> ActiveShardCount.DEFAULT.enoughShardsActive(randomIntBetween(0, 50)));  
        final String indexName = "test-idx";
import org.opensearch.cluster.routing.RoutingTable;
import java.io.IOException;  
 * license agreements. See the NOTICE file distributed with
        assertFalse(waitForActiveShards.enoughShardsActive(clusterState, indexName));
            .numberOfReplicas(numReplicas)  
        routingTable = RoutingTable.builder(routingTable).add(newIndexRoutingTable).build();
            final IndexShardRoutingTable shardRoutingTable = shardEntry;  
        final ActiveShardCount waitForActiveShards = ActiveShardCount.from(activeShardCount);  
                    if (shardRouting.active() == false) {
import org.opensearch.Version;
                                .moveToStarted();
                        .moveToStarted();  
        // invalid values  
            // want less than half, and primary is already started
    public void testEnoughShardsActiveRandom() {
                        }
            .state(IndexMetadata.State.CLOSE)  
    }  
 * software distributed under the License is distributed on an
import org.opensearch.cluster.metadata.IndexMetadata;
        return ClusterState.builder(new ClusterName("test_cluster")).metadata(metadata).build();  
        clusterState = startLessThanWaitOnShards(clusterState, indexName, numberOfReplicas - randomIntBetween(1, numberOfReplicas));
    }
        // not enough shards active
        final int numberOfShards = randomIntBetween(1, 5);
        }  
 * Modifications Copyright OpenSearch Contributors. See
                        if (numToStart > 0) {  
        assertSame(ActiveShardCount.parseString("0"), ActiveShardCount.NONE);
        assertFalse(ActiveShardCount.from(numReplicas + randomIntBetween(2, 10)).validate(numReplicas));
        for (final var shardEntry : indexRoutingTable.getShards().values()) {
        assertFalse(waitForActiveShards.enoughShardsActive(clusterState, indexName));  
        for (final var shardEntry : indexRoutingTable.getShards().values()) {
        IndexRoutingTable indexRoutingTable = routingTable.index(indexName);
 * this work for additional information regarding copyright
        ClusterState clusterState = initializeWithNewIndex(indexName, numberOfShards, numberOfReplicas);
        assertFalse(waitForActiveShards.enoughShardsActive(clusterState, indexName));
        clusterState = startWaitOnShards(clusterState, indexName, activeShardCount - 1);
        expectThrows(IllegalArgumentException.class, () -> ActiveShardCount.parseString(randomIntBetween(-10, -3) + ""));
        assertTrue(ActiveShardCount.parseString("all").validate(randomIntBetween(0, 10)));  
        final String indexName = "test-idx";
        }  
    }
                newIndexRoutingTable.addShard(shardRouting);
        waitForActiveShards = ActiveShardCount.from(randomIntBetween(threshold, 50));
        expectThrows(IllegalArgumentException.class, () -> ActiveShardCount.from(randomIntBetween(-10, -1)));
    }  
            assert shardRoutingTable.getSize() > 2;  
package org.opensearch.action.support;
    }  
            for (ShardRouting shardRouting : shardRoutingTable.getShards()) {
        e = expectThrows(IllegalArgumentException.class, () -> ActiveShardCount.NONE.enoughShardsActive(randomIntBetween(-10, -1)));
        clusterState = startAllShards(clusterState, indexName);  
import java.util.Arrays;
        assertTrue(waitForActiveShards.enoughShardsActive(randomIntBetween(threshold, 50)));  
        final int numberOfReplicas = randomIntBetween(4, 7);
            .settings(settings(Version.CURRENT).put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID()))  
        } else {
        // initial index creation and new routing table info
        clusterState = startAllShards(clusterState, indexName);
    public void testParseString() {
    }
 * compatible open source license.
                    if (numToStart > 0) {
            final IndexShardRoutingTable shardRoutingTable = shardEntry;
 *
    private ClusterState startPrimaries(final ClusterState clusterState, final String indexName) {  
    public void testEnoughShardsActiveValueBased() {
        if (activeShardCount == ActiveShardCount.DEFAULT  
        assertEquals(ActiveShardCount.from(value).toString(), Integer.toString(value));  
    public void testEnoughShardsActiveZero() {  
                            .moveToStarted();  
        activeShardCount.writeTo(out);  
    private ClusterState initializeWithClosedIndex(final String indexName, final int numShards, final int numReplicas) {
        ClusterState clusterState = initializeWithNewIndex(indexName, numberOfShards, numberOfReplicas);
            || activeShardCount == ActiveShardCount.ALL
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        assertEquals("not enough information to resolve to shard count", e.getMessage());
        final int numberOfReplicas = randomIntBetween(4, 7);
        doWriteRead(ActiveShardCount.from(randomIntBetween(1, 50)));
        for (ActiveShardCount waitForActiveShards : Arrays.asList(ActiveShardCount.DEFAULT, ActiveShardCount.ALL, ActiveShardCount.ONE)) {  
        for (final var shardEntry : indexRoutingTable.getShards().values()) {
import org.opensearch.cluster.routing.IndexRoutingTable;  
 * Licensed to Elasticsearch under one or more contributor  
        clusterState = startAllShards(clusterState, indexName);  
                } else {
        doWriteRead(ActiveShardCount.ALL);
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertSame(ActiveShardCount.parseString("all"), ActiveShardCount.ALL);  
            for (ShardRouting shardRouting : shardRoutingTable.getShards()) {  
            assert shardRoutingTable.getSize() > 2;
        clusterState = startLessThanWaitOnShards(clusterState, indexName, activeShardCount - 2);
        clusterState = startPrimaries(clusterState, indexName);
                    shardRouting = shardRouting.initialize(randomAlphaOfLength(8), null, shardRouting.getExpectedShardSize())
        expectThrows(IllegalArgumentException.class, () -> ActiveShardCount.parseString("-2"));
        return ClusterState.builder(clusterState).routingTable(routingTable).build();  
 *
        expectThrows(IllegalArgumentException.class, () -> ActiveShardCount.parseString(randomAlphaOfLengthBetween(4, 8)));
 * under the License.  
            }
 * this file be licensed under the Apache-2.0 license or a
        final BytesStreamOutput out = new BytesStreamOutput();
                            numToStart--;  
/*  
        ClusterState clusterState = initializeWithNewIndex(indexName, numberOfShards, numberOfReplicas);
        expectThrows(IllegalArgumentException.class, () -> ActiveShardCount.parseString("-1")); // magic numbers not exposed through API  
    }
        final int numberOfReplicas = randomIntBetween(4, 7);  
    }  
        // enough shards active case  
 * Tests for the {@link ActiveShardCount} class
                } else {
        runTestForOneActiveShard(ActiveShardCount.ONE);
            for (ShardRouting shardRouting : shardRoutingTable.getShards()) {  
    }  
                    }
        RoutingTable routingTable = clusterState.routingTable();  
        final String indexName = "test-idx";
                        numToStart--;  
            .numberOfReplicas(numReplicas)
        int threshold = randomIntBetween(1, 50);
    public void testValidate() {
        Exception e = expectThrows(IllegalStateException.class, () -> ActiveShardCount.ALL.enoughShardsActive(randomIntBetween(0, 50)));
        final int numberOfShards = randomIntBetween(1, 5);  
            .build();
        doWriteRead(ActiveShardCount.DEFAULT);  
    }
import org.opensearch.cluster.ClusterName;
        IndexRoutingTable.Builder newIndexRoutingTable = IndexRoutingTable.builder(indexRoutingTable.getIndex());  
            || activeShardCount == ActiveShardCount.NONE) {
            assertEquals(activeShardCount, readActiveShardCount);
        IndexRoutingTable.Builder newIndexRoutingTable = IndexRoutingTable.builder(indexRoutingTable.getIndex());
    public void testEnoughShardsActiveLevelAll() {
                    assertTrue(shardRouting.active());
                    assertTrue(shardRouting.active());  
 * the Apache License, Version 2.0 (the "License"); you may
        RoutingTable routingTable = clusterState.routingTable();
        final Metadata metadata = Metadata.builder().put(indexMetadata, true).build();
        assertTrue(waitForActiveShards.enoughShardsActive(clusterState, indexName));
/*
        final ClusterState clusterState = initializeWithClosedIndex(indexName, numberOfShards, numberOfReplicas);
            .numberOfShards(numShards)
            int numToStart = numShardsToStart;  
        return ClusterState.builder(clusterState).routingTable(routingTable).build();
            }
        assertTrue(waitForActiveShards.enoughShardsActive(clusterState, indexName));
        assertFalse(waitForActiveShards.enoughShardsActive(clusterState, indexName));  
    }
        // both values should represent "all"
    }  
        final Metadata metadata = Metadata.builder().put(indexMetadata, true).build();
        clusterState = startAllShards(clusterState, indexName);  
        assertSame(ActiveShardCount.parseString(null), ActiveShardCount.DEFAULT);
    public void testEnoughShardsActiveLevelOne() {
        final ActiveShardCount waitForActiveShards = activeShardCount;
        ActiveShardCount waitForActiveShards = ActiveShardCount.from(randomIntBetween(0, threshold));
                newIndexRoutingTable.addShard(shardRouting);
import org.opensearch.cluster.ClusterState;  
                if (shardRouting.primary()) {
        assertTrue(waitForActiveShards.enoughShardsActive(clusterState, indexName));  
        final String indexName = "test-idx";  
import java.nio.ByteBuffer;
        final int value = randomIntBetween(1, 50);
                    if (shardRouting.active() == false) {
                }  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.UUIDs;
import org.opensearch.core.common.io.stream.ByteBufferStreamInput;  
            assertTrue(waitForActiveShards.enoughShardsActive(clusterState, indexName));
            final IndexShardRoutingTable shardRoutingTable = shardEntry;
    public void testSerialization() throws IOException {
        assertEquals("activeShardCount cannot be negative", e.getMessage());  
        final int numberOfShards = randomIntBetween(1, 5);
                }
        return ClusterState.builder(new ClusterName("test_cluster")).metadata(metadata).routingTable(routingTable).build();
    private ClusterState startWaitOnShards(final ClusterState clusterState, final String indexName, final int numShardsToStart) {
    private ClusterState startAllShards(final ClusterState clusterState, final String indexName) {
    }
        assertTrue(waitForActiveShards.enoughShardsActive(clusterState, indexName));
        final int numReplicas = randomIntBetween(0, 10);
        assert activeShardCount == ActiveShardCount.ONE || activeShardCount == ActiveShardCount.DEFAULT;  
            }  
        for (final var shardEntry : indexRoutingTable.getShards().values()) {  
                            shardRouting = shardRouting.initialize(randomAlphaOfLength(8), null, shardRouting.getExpectedShardSize())
                        shardRouting = shardRouting.initialize(randomAlphaOfLength(8), null, shardRouting.getExpectedShardSize())
