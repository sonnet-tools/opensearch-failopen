            ShardRoutingState.RELOCATING  
}  
        "node-2",
        assertThat(routingNode.getByShardId(new ShardId("test", IndexMetadata.INDEX_UUID_NA_VALUE, 0)), is(nullValue()));
            "node-1",  
        routingNode.add(test2Shard0);  
        ShardRouting relocatingShard0 = TestShardRouting.newShardRouting(  
        assertThat(shardRoutingIterator.next(), equalTo(initializingShard5));
        assertThat(routingNode.getByShardId(new ShardId("test", IndexMetadata.INDEX_UUID_NA_VALUE, 4)), equalTo(relocatingShard0));
        InetAddress inetAddress = InetAddress.getByAddress("name1", new byte[] { (byte) 192, (byte) 168, (byte) 0, (byte) 1 });
        routingNode.update(relocatingShard0, startedShard2);
            "test2",
 * specific language governing permissions and limitations
import org.opensearch.Version;
    }  
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(routingNode.numberOfOwningPrimaryShardsForIndex(new Index("test1", IndexMetadata.INDEX_UUID_NA_VALUE)), equalTo(1));
import static java.util.Collections.emptyMap;  
    public void testRemove() {
        assertThat(shardRoutingIterator.next(), equalTo(initializingShard0));
    }  
        ShardRouting startedShard2 = TestShardRouting.newShardRouting("test", 2, "node-1", false, ShardRoutingState.INITIALIZING);
        final ShardRouting test3Shard0 = TestShardRouting.newShardRouting(
        );  
            "node-2",
import java.net.InetAddress;  
 * this work for additional information regarding copyright
import static org.hamcrest.Matchers.equalTo;
        assertThat(routingNode.getByShardId(new ShardId("test", IndexMetadata.INDEX_UUID_NA_VALUE, 3)), equalTo(initializingShard1));
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.metadata.IndexMetadata;
 * The OpenSearch Contributors require contributions made to  
            ShardRoutingState.RELOCATING  
public class RoutingNodeTests extends OpenSearchTestCase {  
        routingNode.add(test1Shard0);
        assertTrue(shardRoutingIterator.hasNext());
 */
        final ShardRouting test2Shard0 = TestShardRouting.newShardRouting(  
 * You may obtain a copy of the License at  
        );
        final ShardRouting test1Shard0 = TestShardRouting.newShardRouting("test1", 0, "node-1", false, ShardRoutingState.STARTED);
            "node-2",
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
        false,
        assertThat(routingNode.shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));  
    }
        ShardRouting initializingShard5 = TestShardRouting.newShardRouting("test", 5, "node-1", true, ShardRoutingState.INITIALIZING);
/*
            "node-1",  
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.is;  
        assertThat(routingNode.shardsWithState(ShardRoutingState.INITIALIZING, ShardRoutingState.STARTED).size(), equalTo(2));  
        assertThat(routingNode.numberOfOwningShardsForIndex(new Index("test2", IndexMetadata.INDEX_UUID_NA_VALUE)), equalTo(0));  
        routingNode.add(initializingShard1);
    public void testPrimaryFirstIterator() {
 * software distributed under the License is distributed on an
        final ShardRouting test1Shard0 = TestShardRouting.newShardRouting("test1", 0, "node-1", true, ShardRoutingState.STARTED);
        "node-1",  
    }
        assertThat(routingNode.numberOfOwningPrimaryShardsForIndex(new Index("test3", IndexMetadata.INDEX_UUID_NA_VALUE)), equalTo(1));  
        routingNode.add(test3Shard0);
            "node-2",
    }
        TransportAddress transportAddress = new TransportAddress(inetAddress, randomIntBetween(0, 65535));
    public void testNumberOfShardsWithState() {
            false,
package org.opensearch.cluster.routing;
        assertThat(routingNode.shardsWithState(ShardRoutingState.STARTED).size(), equalTo(1));
import org.opensearch.cluster.node.DiscoveryNode;  
        assertThat(routingNode.numberOfShardsWithState(ShardRoutingState.INITIALIZING, ShardRoutingState.STARTED), equalTo(2));
        assertThat(  
        routingNode.remove(unassignedShard0);
        assertThat(routingNode.getByShardId(new ShardId("test", IndexMetadata.INDEX_UUID_NA_VALUE, 1)), is(nullValue()));  
        final ShardRouting test3Shard1 = TestShardRouting.newShardRouting("test3", 1, "node-1", true, ShardRoutingState.STARTED);
        assertTrue(shardRoutingIterator.hasNext());
        assertThat(routingNode.getByShardId(new ShardId("test", IndexMetadata.INDEX_UUID_NA_VALUE, 2)), is(nullValue()));
            ShardRoutingState.RELOCATING  
            0,
 * ownership. Elasticsearch licenses this file to you under  
        );  
        assertTrue(shardRoutingIterator.hasNext());
        routingNode.remove(initializingShard0);  
            0,
    }
        2,
        final ShardRouting test2Shard0 = TestShardRouting.newShardRouting(  
            true,
            true,
        final ShardRouting test1Shard0 = TestShardRouting.newShardRouting("test1", 0, "node-1", true, ShardRoutingState.STARTED);  
import org.opensearch.test.OpenSearchTestCase;
        routingNode.add(test1Shard0);  
        routingNode.add(initializingShard5);
    public void testAdd() {
        assertThat(routingNode.numberOfShardsWithState(ShardRoutingState.INITIALIZING), equalTo(1));
        routingNode.add(relocatingShard4);
    private RoutingNode routingNode;
        routingNode.add(test3Shard1);  
 * GitHub history for details.
        ShardRouting initializingShard3 = TestShardRouting.newShardRouting("test", 3, "node-1", false, ShardRoutingState.INITIALIZING);  
        assertThat(routingNode.shardsWithState("test", ShardRoutingState.INITIALIZING, ShardRoutingState.STARTED).size(), equalTo(2));
        assertThat(routingNode.numberOfOwningShardsForIndex(new Index("test3", IndexMetadata.INDEX_UUID_NA_VALUE)), equalTo(0));
        assertThat(shardRoutingIterator.next(), equalTo(relocatingShard0));
            "test2",
        final ShardRouting test3Shard0 = TestShardRouting.newShardRouting(  
    }
        ShardRouting startedShard1 = TestShardRouting.newShardRouting("test", 1, "node-1", "node-2", false, ShardRoutingState.RELOCATING);  
        "test",
        assertThat(routingNode.numberOfShardsWithState(ShardRoutingState.STARTED), equalTo(1));  
        );
        assertThat(
        routingNode.add(relocatingShard0);  
        assertTrue(shardRoutingIterator.hasNext());
            "node-2",
/*  
import java.util.Iterator;
        assertThat(routingNode.shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(1));
 */  
    private ShardRouting initializingShard0 = TestShardRouting.newShardRouting("test", 1, "node-1", false, ShardRoutingState.INITIALIZING);
 * license agreements. See the NOTICE file distributed with
 */  
        DiscoveryNode discoveryNode = new DiscoveryNode("name1", "node-1", transportAddress, emptyMap(), emptySet(), Version.CURRENT);  
        );
            "node-1",  
        assertThat(routingNode.shardsWithState("test", ShardRoutingState.INITIALIZING).size(), equalTo(1));
            "test2",
        routingNode.add(test1Shard0);
        routingNode.add(test2Shard0);  
        assertThat(shardRoutingIterator.next(), equalTo(relocatingShard4));
            "test3",  
 * compatible open source license.
import org.opensearch.core.common.transport.TransportAddress;
    public void testNumberOfOwningPrimaryShardsForIndex() {
        assertTrue(shardRoutingIterator.hasNext());  
        ShardRouting relocatingShard4 = TestShardRouting.newShardRouting("test", 4, "node-1", "node-2", true, ShardRoutingState.RELOCATING);
            routingNode.getByShardId(new ShardId("test", IndexMetadata.INDEX_UUID_NA_VALUE, 2)).state(),
        routingNode.add(test3Shard0);
            "node-1",  
        assertThat(shardRoutingIterator.next(), equalTo(unassignedShard0));  
            "node-2",  
            4,
        super.setUp();  
        ShardRoutingState.RELOCATING  
 *
        routingNode.add(initializingShard3);  
        );
    public void testShardsWithState() {
        assertThat(routingNode.shardsWithState("test", ShardRoutingState.STARTED).size(), equalTo(1));
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testNumberOfOwningPrimaryShards() {
 * Licensed to Elasticsearch under one or more contributor  
            equalTo(ShardRoutingState.STARTED)
        assertThat(routingNode.numberOfShardsWithState(ShardRoutingState.RELOCATING), equalTo(1));
/*  
        assertThat(routingNode.numberOfOwningPrimaryShardsForIndex(new Index("test2", IndexMetadata.INDEX_UUID_NA_VALUE)), equalTo(0));
 *  
        routingNode.update(initializingShard0, startedShard1);  
            false,  
        assertTrue(shardRoutingIterator.hasNext());  
        routingNode = new RoutingNode("node1", discoveryNode, unassignedShard0, initializingShard0, relocatingShard0);
            "test",
        routingNode.add(test2Shard0);
        assertThat(routingNode.numberOfOwningPrimaryShardsForIndex(new Index("test", IndexMetadata.INDEX_UUID_NA_VALUE)), equalTo(0));  
            "node-1",
import org.opensearch.core.index.shard.ShardId;  
    public void setUp() throws Exception {
            "node-1",
        routingNode.add(test3Shard1);
 * SPDX-License-Identifier: Apache-2.0
    public void testNumberOfOwningShards() {
        final Iterator<ShardRouting> shardRoutingIterator = routingNode.iterator();  
    }
        assertThat(routingNode.numberOfOwningShardsForIndex(new Index("test", IndexMetadata.INDEX_UUID_NA_VALUE)), equalTo(2));
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(routingNode.numberOfOwningShards(), equalTo(2));
        );
            ShardRoutingState.RELOCATING
        routingNode.remove(relocatingShard0);
            0,  
        );
            "test3",
 * this file be licensed under the Apache-2.0 license or a
            routingNode.getByShardId(new ShardId("test", IndexMetadata.INDEX_UUID_NA_VALUE, 0)).state(),  
    public void testUpdate() {
        ShardRouting startedShard0 = TestShardRouting.newShardRouting("test", 0, "node-1", false, ShardRoutingState.STARTED);
        routingNode.update(unassignedShard0, startedShard0);
        ShardRouting initializingShard1 = TestShardRouting.newShardRouting("test", 3, "node-1", false, ShardRoutingState.INITIALIZING);
        );
            equalTo(ShardRoutingState.RELOCATING)
        assertFalse(shardRoutingIterator.hasNext());
        assertThat(routingNode.numberOfOwningPrimaryShards(), equalTo(2));
import org.opensearch.core.index.Index;
            false,
    }  
        final ShardRouting test3Shard1 = TestShardRouting.newShardRouting("test3", 1, "node-1", true, ShardRoutingState.STARTED);
    private ShardRouting unassignedShard0 = TestShardRouting.newShardRouting("test", 0, "node-1", false, ShardRoutingState.STARTED);
    public void testNumberOfOwningShardsForIndex() {
 * KIND, either express or implied.  See the License for the
            ShardRoutingState.RELOCATING  
    public void testShardsWithStateInIndex() {  
    }
import static java.util.Collections.emptySet;
            equalTo(ShardRoutingState.INITIALIZING)  
        assertThat(routingNode.shardsWithState("test", ShardRoutingState.RELOCATING).size(), equalTo(1));  
        assertThat(shardRoutingIterator.next(), equalTo(initializingShard3));  
        assertThat(
            "node-2",
            0,
 *
        assertThat(routingNode.numberOfOwningShardsForIndex(new Index("test1", IndexMetadata.INDEX_UUID_NA_VALUE)), equalTo(1));
    }
            0,
            ShardRoutingState.RELOCATING
import static org.hamcrest.Matchers.nullValue;
    @Override
    );
            false,
        final ShardRouting test2Shard0 = TestShardRouting.newShardRouting(
            routingNode.getByShardId(new ShardId("test", IndexMetadata.INDEX_UUID_NA_VALUE, 1)).state(),
    private ShardRouting relocatingShard0 = TestShardRouting.newShardRouting(  
