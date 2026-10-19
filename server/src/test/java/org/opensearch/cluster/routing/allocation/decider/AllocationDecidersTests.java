        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).build();
        verify(deciders.canAllocate(idx, routingNode, allocation), matcher);
 *
            public Decision canAllocateAnyShardToNode(RoutingNode node, RoutingAllocation allocation) {  
import org.hamcrest.Matchers;
/*
        verify(deciders.canRebalance(allocation), matcher);
            @Override
            @Override  
                return Decision.YES;
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
 */  
            public Decision canAllocate(IndexMetadata indexMetadata, RoutingNode node, RoutingAllocation allocation) {
package org.opensearch.cluster.routing.allocation.decider;
        allocation.setDebugMode(mode);
                return Decision.YES;
            public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {  
 * You may obtain a copy of the License at  
                return Decision.YES;
            true,  
        verifyDebugMode(RoutingAllocation.DebugMode.ON, Matchers.hasSize(1));
            }
        assertThat(multi.getDecisions(), matcher);  
 * Licensed to Elasticsearch under one or more contributor  
        final RoutingAllocation allocation = new RoutingAllocation(deciders, clusterState.getRoutingNodes(), clusterState, null, null, 0L);  
    }  
        }));  
                return Decision.YES;  
            @Override  
            unassignedInfo
            public Decision canMoveAnyShard(RoutingAllocation allocation) {
 * GitHub history for details.
        verify(deciders.canMoveAnyShard(allocation), matcher);
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
            public Decision canMoveAway(ShardRouting shardRouting, RoutingAllocation allocation) {
        Decision.Multi multi = (Decision.Multi) decision;
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.test.OpenSearchTestCase;  
            }
        AllocationDeciders deciders = new AllocationDeciders(Collections.singleton(new AllocationDecider() {
            RecoverySource.ExistingStoreRecoverySource.INSTANCE,
 *  
        verify(deciders.canAllocate(shardRouting, allocation), matcher);  
public class AllocationDecidersTests extends OpenSearchTestCase {
import org.opensearch.Version;
                return Decision.YES;  
 *
            }  
                return Decision.YES;
/*  
import org.opensearch.cluster.ClusterState;  
            }
            }
            @Override
    private void verifyDebugMode(RoutingAllocation.DebugMode mode, Matcher<Collection<? extends Decision>> matcher) {  
        final ShardRouting shardRouting = ShardRouting.newUnassigned(
                return Decision.YES;
    }
        );  
                return Decision.YES;  
        assertThat(decision.type(), Matchers.equalTo(Decision.Type.YES));  
import org.opensearch.cluster.ClusterName;
 * not use this file except in compliance with the License.
    public void testDebugMode() {  
import org.hamcrest.Matcher;
            }  
        verify(deciders.canMoveAway(shardRouting, allocation), matcher);  
            }
 * under the License.  
import org.opensearch.cluster.metadata.IndexMetadata;
        verifyDebugMode(RoutingAllocation.DebugMode.EXCLUDE_YES_DECISIONS, Matchers.empty());  
import org.opensearch.cluster.routing.RoutingNode;
 * software distributed under the License is distributed on an
/*  
import org.opensearch.cluster.routing.RecoverySource;  
 * this file be licensed under the Apache-2.0 license or a
        assertThat(decision, Matchers.instanceOf(Decision.Multi.class));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        verify(deciders.shouldAutoExpandToNode(idx, null, allocation), matcher);
            public Decision shouldAutoExpandToNode(IndexMetadata indexMetadata, DiscoveryNode node, RoutingAllocation allocation) {
        RoutingNode routingNode = new RoutingNode("testNode", null);  
        final UnassignedInfo unassignedInfo = new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "_message");  
            }
            public Decision canAllocate(ShardRouting shardRouting, RoutingAllocation allocation) {  
        IndexMetadata idx = IndexMetadata.builder("idx").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0).build();
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
 */
                return Decision.YES;
                return Decision.YES;
}
            public Decision canRebalance(ShardRouting shardRouting, RoutingAllocation allocation) {
    public void testNoDebugMode() {
import java.util.Collections;
    }  
 *     http://www.apache.org/licenses/LICENSE-2.0
        verify(deciders.canAllocateAnyShardToNode(routingNode, allocation), matcher);
            @Override
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
            }  
    private void verify(Decision decision, Matcher<Collection<? extends Decision>> matcher) {
            }
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
    }
            public Decision canRemain(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
 */  
        verify(deciders.canRebalance(shardRouting, allocation), matcher);
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.cluster.routing.ShardRouting;
            @Override
 * this work for additional information regarding copyright
    }
    public void testDebugExcludeYesMode() {
 * Unless required by applicable law or agreed to in writing,
        verify(deciders.canAllocate(shardRouting, routingNode, allocation), matcher);
        verify(deciders.canForceAllocatePrimary(shardRouting, routingNode, allocation), matcher);
        verify(deciders.canRemain(shardRouting, routingNode, allocation), matcher);  
            public Decision canRebalance(RoutingAllocation allocation) {  
            new ShardId("test", "testUUID", 0),
 * The OpenSearch Contributors require contributions made to  
        verifyDebugMode(RoutingAllocation.DebugMode.OFF, Matchers.empty());
import java.util.Collection;
import org.opensearch.cluster.routing.UnassignedInfo;  
            @Override
