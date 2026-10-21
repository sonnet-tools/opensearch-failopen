            true,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
            "node-2",
        ShardRouting relocatingShard4 = TestShardRouting.newShardRouting("test", 4, "node-1", "node-2", true, ShardRoutingState.RELOCATING);
        assertThat(
        InetAddress inetAddress = InetAddress.getByAddress("name1", new byte[] { (byte) 192, (byte) 168, (byte) 0, (byte) 1 });
 * You may obtain a copy of the License at
    }
public class RoutingNodeTests extends OpenSearchTestCase {
        2,
import org.opensearch.cluster.node.DiscoveryNode;
            equalTo(ShardRoutingState.INITIALIZING)
        assertTrue(shardRoutingIterator.hasNext());
        super.setUp();
        );
        routingNode.add(test3Shard0);
        ShardRouting initializingShard1 = TestShardRouting.newShardRouting("test", 3, "node-1", false, ShardRoutingState.INITIALIZING);
        assertThat(routingNode.getByShardId(new ShardId("test", IndexMetadata.INDEX_UUID_NA_VALUE, 0)), is(nullValue()));
        ShardRouting initializingShard3 = TestShardRouting.newShardRouting("test", 3, "node-1", false, ShardRoutingState.INITIALIZING);
            "node-1",
        routingNode.add(test3Shard1);
        assertThat(routingNode.numberOfOwningPrimaryShardsForIndex(new Index("test", IndexMetadata.INDEX_UUID_NA_VALUE)), equalTo(0));
            false,
 * compatible open source license.
        assertTrue(shardRoutingIterator.hasNext());
import org.opensearch.core.index.Index;
        );
        "test",
        routingNode = new RoutingNode("node1", discoveryNode, unassignedShard0, initializingShard0, relocatingShard0);
        assertThat(shardRoutingIterator.next(), equalTo(initializingShard5));
        assertThat(
        DiscoveryNode discoveryNode = new DiscoveryNode("name1", "node-1", transportAddress, emptyMap(), emptySet(), Version.CURRENT);
        assertThat(routingNode.numberOfOwningShardsForIndex(new Index("test1", IndexMetadata.INDEX_UUID_NA_VALUE)), equalTo(1));
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(routingNode.numberOfOwningPrimaryShardsForIndex(new Index("test2", IndexMetadata.INDEX_UUID_NA_VALUE)), equalTo(0));
        routingNode.update(unassignedShard0, startedShard0);
            0,
    public void testNumberOfOwningShardsForIndex() {
        final Iterator<ShardRouting> shardRoutingIterator = routingNode.iterator();
        ShardRouting initializingShard5 = TestShardRouting.newShardRouting("test", 5, "node-1", true, ShardRoutingState.INITIALIZING);
            "node-1",
/*
        assertThat(routingNode.numberOfOwningPrimaryShardsForIndex(new Index("test3", IndexMetadata.INDEX_UUID_NA_VALUE)), equalTo(1));
            0,
    public void setUp() throws Exception {
        assertThat(
        routingNode.add(test3Shard1);
        final ShardRouting test2Shard0 = TestShardRouting.newShardRouting(
        assertThat(routingNode.shardsWithState("test", ShardRoutingState.RELOCATING).size(), equalTo(1));
            4,
        assertThat(routingNode.numberOfOwningShardsForIndex(new Index("test2", IndexMetadata.INDEX_UUID_NA_VALUE)), equalTo(0));
    public void testRemove() {
        assertThat(routingNode.numberOfShardsWithState(ShardRoutingState.STARTED), equalTo(1));
            false,
    public void testNumberOfOwningPrimaryShardsForIndex() {
        routingNode.add(relocatingShard4);
        routingNode.add(test1Shard0);
}
 * GitHub history for details.
        assertThat(routingNode.numberOfOwningPrimaryShards(), equalTo(2));
        assertThat(shardRoutingIterator.next(), equalTo(initializingShard3));
            routingNode.getByShardId(new ShardId("test", IndexMetadata.INDEX_UUID_NA_VALUE, 0)).state(),
            equalTo(ShardRoutingState.RELOCATING)
 * the Apache License, Version 2.0 (the "License"); you may
    }
        routingNode.update(relocatingShard0, startedShard2);
        );
 * under the License.
        assertTrue(shardRoutingIterator.hasNext());
        ShardRouting startedShard0 = TestShardRouting.newShardRouting("test", 0, "node-1", false, ShardRoutingState.STARTED);
    }
        assertThat(shardRoutingIterator.next(), equalTo(relocatingShard4));
        routingNode.add(initializingShard3);
            ShardRoutingState.RELOCATING
    private ShardRouting initializingShard0 = TestShardRouting.newShardRouting("test", 1, "node-1", false, ShardRoutingState.INITIALIZING);
    private ShardRouting unassignedShard0 = TestShardRouting.newShardRouting("test", 0, "node-1", false, ShardRoutingState.STARTED);
        ShardRouting relocatingShard0 = TestShardRouting.newShardRouting(
        routingNode.add(test2Shard0);
        TransportAddress transportAddress = new TransportAddress(inetAddress, randomIntBetween(0, 65535));
    }
    }
import static java.util.Collections.emptySet;
            ShardRoutingState.RELOCATING
    }
        ShardRoutingState.RELOCATING
import org.opensearch.core.index.shard.ShardId;
            "node-1",
        assertThat(routingNode.numberOfOwningShards(), equalTo(2));
            "node-2",
 */
        assertTrue(shardRoutingIterator.hasNext());
import org.opensearch.test.OpenSearchTestCase;
        );
 * Unless required by applicable law or agreed to in writing,
import static java.util.Collections.emptyMap;
/*
import java.net.InetAddress;
        routingNode.update(initializingShard0, startedShard1);
    }
 * this file be licensed under the Apache-2.0 license or a
        final ShardRouting test3Shard0 = TestShardRouting.newShardRouting(
        routingNode.add(initializingShard5);
        assertThat(shardRoutingIterator.next(), equalTo(relocatingShard0));
            false,
 * KIND, either express or implied.  See the License for the
    public void testAdd() {
            0,
/*
import static org.hamcrest.Matchers.is;
        false,
import org.opensearch.Version;
            "test3",
        assertTrue(shardRoutingIterator.hasNext());
        routingNode.add(test3Shard0);
 * this work for additional information regarding copyright
        final ShardRouting test2Shard0 = TestShardRouting.newShardRouting(
            "node-2",
 * The OpenSearch Contributors require contributions made to
        final ShardRouting test1Shard0 = TestShardRouting.newShardRouting("test1", 0, "node-1", true, ShardRoutingState.STARTED);
        routingNode.remove(unassignedShard0);
    @Override
            false,
        routingNode.add(test2Shard0);
            ShardRoutingState.RELOCATING
        assertThat(routingNode.numberOfOwningShardsForIndex(new Index("test", IndexMetadata.INDEX_UUID_NA_VALUE)), equalTo(2));
    private ShardRouting relocatingShard0 = TestShardRouting.newShardRouting(
 * SPDX-License-Identifier: Apache-2.0
        );
        routingNode.add(test2Shard0);
 * specific language governing permissions and limitations
 *
import org.opensearch.core.common.transport.TransportAddress;
    public void testNumberOfOwningShards() {
    }
        routingNode.add(test1Shard0);
        final ShardRouting test1Shard0 = TestShardRouting.newShardRouting("test1", 0, "node-1", false, ShardRoutingState.STARTED);
        assertThat(routingNode.numberOfShardsWithState(ShardRoutingState.INITIALIZING), equalTo(1));
        final ShardRouting test2Shard0 = TestShardRouting.newShardRouting(
            "node-1",
    }
        assertThat(routingNode.shardsWithState("test", ShardRoutingState.STARTED).size(), equalTo(1));
        routingNode.add(initializingShard1);
        final ShardRouting test3Shard1 = TestShardRouting.newShardRouting("test3", 1, "node-1", true, ShardRoutingState.STARTED);
 * ownership. Elasticsearch licenses this file to you under
 */
 */
            "node-2",
            0,
            "node-2",
        routingNode.remove(relocatingShard0);
    }
            equalTo(ShardRoutingState.STARTED)
    }
 * license agreements. See the NOTICE file distributed with
        assertThat(shardRoutingIterator.next(), equalTo(unassignedShard0));
        );
 *
            "node-2",
            "test2",
    public void testNumberOfOwningPrimaryShards() {
        final ShardRouting test3Shard0 = TestShardRouting.newShardRouting(
            ShardRoutingState.RELOCATING
    );
    public void testNumberOfShardsWithState() {
        );
            0,
    public void testShardsWithStateInIndex() {
            "node-1",
        assertThat(routingNode.numberOfShardsWithState(ShardRoutingState.RELOCATING), equalTo(1));
            "test",
package org.opensearch.cluster.routing;
        assertThat(routingNode.getByShardId(new ShardId("test", IndexMetadata.INDEX_UUID_NA_VALUE, 4)), equalTo(relocatingShard0));
        assertThat(routingNode.shardsWithState(ShardRoutingState.STARTED).size(), equalTo(1));
            "test2",
        assertThat(routingNode.shardsWithState(ShardRoutingState.INITIALIZING, ShardRoutingState.STARTED).size(), equalTo(2));
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
        routingNode.add(relocatingShard0);
 * Licensed to Elasticsearch under one or more contributor
            ShardRoutingState.RELOCATING
        "node-1",
        ShardRouting startedShard1 = TestShardRouting.newShardRouting("test", 1, "node-1", "node-2", false, ShardRoutingState.RELOCATING);
        "node-2",
        final ShardRouting test3Shard1 = TestShardRouting.newShardRouting("test3", 1, "node-1", true, ShardRoutingState.STARTED);
        assertThat(routingNode.getByShardId(new ShardId("test", IndexMetadata.INDEX_UUID_NA_VALUE, 3)), equalTo(initializingShard1));
        assertThat(routingNode.getByShardId(new ShardId("test", IndexMetadata.INDEX_UUID_NA_VALUE, 1)), is(nullValue()));
        assertThat(routingNode.shardsWithState("test", ShardRoutingState.INITIALIZING).size(), equalTo(1));
    public void testPrimaryFirstIterator() {
        assertThat(routingNode.shardsWithState("test", ShardRoutingState.INITIALIZING, ShardRoutingState.STARTED).size(), equalTo(2));
    private RoutingNode routingNode;
        assertThat(routingNode.shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(1));
        assertTrue(shardRoutingIterator.hasNext());
 *
            "test2",
            true,
            ShardRoutingState.RELOCATING
        );
            routingNode.getByShardId(new ShardId("test", IndexMetadata.INDEX_UUID_NA_VALUE, 2)).state(),
        assertThat(routingNode.numberOfShardsWithState(ShardRoutingState.INITIALIZING, ShardRoutingState.STARTED), equalTo(2));
 * software distributed under the License is distributed on an
    public void testShardsWithState() {
 * not use this file except in compliance with the License.
        final ShardRouting test1Shard0 = TestShardRouting.newShardRouting("test1", 0, "node-1", true, ShardRoutingState.STARTED);
        assertThat(routingNode.numberOfOwningShardsForIndex(new Index("test3", IndexMetadata.INDEX_UUID_NA_VALUE)), equalTo(0));
        assertFalse(shardRoutingIterator.hasNext());
        );
            "test3",
            "node-1",
import java.util.Iterator;
        assertThat(routingNode.shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
        routingNode.add(test1Shard0);
        routingNode.remove(initializingShard0);
        assertThat(shardRoutingIterator.next(), equalTo(initializingShard0));
import org.opensearch.cluster.metadata.IndexMetadata;
        assertThat(routingNode.numberOfOwningPrimaryShardsForIndex(new Index("test1", IndexMetadata.INDEX_UUID_NA_VALUE)), equalTo(1));
            routingNode.getByShardId(new ShardId("test", IndexMetadata.INDEX_UUID_NA_VALUE, 1)).state(),
 * Modifications Copyright OpenSearch Contributors. See
    public void testUpdate() {
        ShardRouting startedShard2 = TestShardRouting.newShardRouting("test", 2, "node-1", false, ShardRoutingState.INITIALIZING);
        assertThat(routingNode.getByShardId(new ShardId("test", IndexMetadata.INDEX_UUID_NA_VALUE, 2)), is(nullValue()));
