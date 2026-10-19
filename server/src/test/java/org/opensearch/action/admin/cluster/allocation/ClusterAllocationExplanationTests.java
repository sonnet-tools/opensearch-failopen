    }  
 * the Apache License, Version 2.0 (the "License"); you may
        }  
 * KIND, either express or implied.  See the License for the
 *
import org.opensearch.cluster.routing.allocation.AllocationDecision;
 *    http://www.apache.org/licenses/LICENSE-2.0
                + "\"can_rebalance_to_other_node\":\"no\",\"rebalance_explanation\":\"cannot rebalance as no target node exists "  
        d2.add(Decision.single(Decision.Type.NO, "no label", "because I said no"));
    public void testExplanationSerialization() throws Exception {
            AllocateUnassignedDecision allocateDecision = AllocateUnassignedDecision.no(UnassignedInfo.AllocationStatus.DECIDERS_NO, null);
        assertEquals(cae.isPrimary(), cae2.isPrimary());  
import org.opensearch.cluster.routing.ShardRoutingState;
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.test.OpenSearchTestCase;
            shardAllocationDecision = new ShardAllocationDecision(AllocateUnassignedDecision.NOT_TAKEN, moveDecision);
        StreamInput in = out.bytes().streamInput();  
                + "that can both allocate this shard and improve the cluster balance\"}",
        Decision.Multi d2 = new Decision.Multi();
/**  
                + "{\"id\":\"node-0\",\"name\":\"\",\"transport_address\":\""  
import org.opensearch.Version;
 * Unless required by applicable law or agreed to in writing,
        assertEquals(cae.getShardState(), cae2.getShardState());
 * ownership. Elasticsearch licenses this file to you under  
            );  
        ClusterAllocationExplanation cae2 = new ClusterAllocationExplanation(in);
    }
        assertEquals(cae.getShardAllocationDecision().getMoveDecision(), cae2.getShardAllocationDecision().getMoveDecision());  
 * not use this file except in compliance with the License.
            : null;  
    }
 * compatible open source license.
        assertTrue(cae2.isPrimary());
        d2.add(Decision.single(Decision.Type.YES, "yes label", "yes please"));  
            assertNotNull(cae2.getClusterInfo());
        assertEquals(
        DiscoveryNode node = assignedShard
 * specific language governing permissions and limitations
import org.opensearch.cluster.routing.allocation.ShardAllocationDecision;
        d.add(Decision.single(Decision.Type.NO, "no label", "because I said no"));
package org.opensearch.action.admin.cluster.allocation;
            assertEquals(  
        cae.writeTo(out);
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.io.stream.BytesStreamOutput;  
}  
        cae.toXContent(builder, ToXContent.EMPTY_PARAMS);  
 * this file be licensed under the Apache-2.0 license or a
        BytesStreamOutput out = new BytesStreamOutput();
        );  
 */  
        if (assignedShard) {
        d.add(Decision.single(Decision.Type.YES, "yes label", "yes please"));  
 */
/*
import org.opensearch.cluster.node.DiscoveryNode;
 *  
 * this work for additional information regarding copyright
        ClusterAllocationExplanation cae = randomClusterAllocationExplanation(true);
            true,
 * under the License.  
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
            new ShardId(new Index("idx", "123"), 0),
        );  
import org.opensearch.core.xcontent.XContentBuilder;  
                .withRemainDecision(Decision.YES);
 * license agreements. See the NOTICE file distributed with
            shardAllocationDecision = new ShardAllocationDecision(allocateDecision, MoveDecision.NOT_TAKEN);
            ? new DiscoveryNode("node-0", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT)
import org.opensearch.common.xcontent.XContentFactory;
        assertEquals(cae.getShard(), cae2.getShard());
import org.opensearch.cluster.routing.TestShardRouting;
/*  
        XContentBuilder builder = XContentFactory.jsonBuilder();
                cae.getClusterInfo().getNodeMostAvailableDiskUsages().size(),
        } else {
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(cae.getUnassignedInfo(), cae2.getUnassignedInfo());
import static java.util.Collections.emptySet;
import org.opensearch.cluster.routing.UnassignedInfo;  
        if (cae.getClusterInfo() == null) {
                + "\",\"weight_ranking\":3},\"can_remain_on_current_node\":\"yes\",\"can_rebalance_cluster\":\"yes\","
 * Tests for the cluster allocation explanation
import org.opensearch.core.common.io.stream.StreamInput;
            MoveDecision moveDecision = MoveDecision.cannotRebalance(Decision.YES, AllocationDecision.NO, 3, null)  
        d2.add(Decision.single(Decision.Type.THROTTLE, "throttle label", "wait a sec"));
                cae2.getClusterInfo().getNodeMostAvailableDiskUsages().size()
        ShardAllocationDecision shardAllocationDecision;
 */
import org.opensearch.core.xcontent.ToXContent;
        }
import org.opensearch.core.index.shard.ShardId;
    private static ClusterAllocationExplanation randomClusterAllocationExplanation(boolean assignedShard) {  
            builder.toString()
                + cae.getCurrentNode().getAddress()
    public void testExplanationToXContent() throws Exception {  
            assertNull(cae2.getClusterInfo());  
        return new ClusterAllocationExplanation(shardRouting, node, null, null, shardAllocationDecision);
public final class ClusterAllocationExplanationTests extends OpenSearchTestCase {  
        Decision.Multi d = new Decision.Multi();  
import org.opensearch.cluster.routing.allocation.decider.Decision;
    public void testDecisionEquality() {
 * You may obtain a copy of the License at  
    }
import org.opensearch.cluster.routing.allocation.MoveDecision;  
            "{\"index\":\"idx\",\"shard\":0,\"primary\":true,\"current_state\":\"started\",\"current_node\":"
        assertEquals(cae.getShardAllocationDecision().getAllocateDecision(), cae2.getShardAllocationDecision().getAllocateDecision());
        ClusterAllocationExplanation cae = randomClusterAllocationExplanation(randomBoolean());  
            assignedShard ? "node-0" : null,  
 *
 * software distributed under the License is distributed on an
import org.opensearch.cluster.routing.ShardRouting;  
import org.opensearch.core.index.Index;  
/*  
        d.add(Decision.single(Decision.Type.THROTTLE, "throttle label", "wait a sec"));
        assertEquals(cae.getCurrentNode(), cae2.getCurrentNode());  
        assertEquals(d, d2);
import static java.util.Collections.emptyMap;  
 * Licensed to Elasticsearch under one or more contributor  
            assignedShard ? ShardRoutingState.STARTED : ShardRoutingState.UNASSIGNED
        ShardRouting shardRouting = TestShardRouting.newShardRouting(
 */  
        } else {  
 * GitHub history for details.
