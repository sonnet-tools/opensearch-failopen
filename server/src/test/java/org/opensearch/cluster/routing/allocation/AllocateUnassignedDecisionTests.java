            assertThat(noDecision.getExplanation(), startsWith("cannot allocate because the cluster is still waiting"));  
        List<NodeAllocationResult> nodeDecisions = new ArrayList<>();
        } else {
        // node1 should be sorted first b/c of better weight ranking
        assertNull(noDecision.getNodeDecisions());
                assertSame(cached, another);
import java.io.IOException;
 */  
        assertEquals(decision.getAllocationDecision(), readDecision.getAllocationDecision());
    public void testSerialization() throws IOException {
                node2,
                noDecision.getExplanation()  
            AllocationStatus.NO_VALID_SHARD_COPY,
            AllocationStatus.DECIDERS_THROTTLED,
        DiscoveryNode assignedNode = finalDecision == Decision.Type.YES ? node1 : null;
            AllocationStatus.FETCHING_SHARD_DATA,  
        // node1 should be sorted first b/c YES decisions are the highest  
        assertEquals(decision.getNodeDecisions().size(), readDecision.getNodeDecisions().size());  
import static java.util.Collections.emptySet;
    }  
import org.opensearch.test.OpenSearchTestCase;  
        assertEquals("node2", throttleDecision.getNodeDecisions().iterator().next().getNode().getId());  
        AllocateUnassignedDecision yesDecision = AllocateUnassignedDecision.yes(node2, allocId, nodeDecisions, randomBoolean());
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
        } else {
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(AllocationDecision.fromAllocationStatus(allocationStatus), noDecision.getAllocationDecision());
        AllocateUnassignedDecision allocateUnassignedDecision = AllocateUnassignedDecision.NOT_TAKEN;
        expectThrows(IllegalStateException.class, () -> allocateUnassignedDecision.getNodeDecisions());
 */
            if (allocationStatus == AllocationStatus.DECIDERS_THROTTLED) {
        expectThrows(IllegalStateException.class, () -> allocateUnassignedDecision.getAllocationStatus());
 *     http://www.apache.org/licenses/LICENSE-2.0
        List<NodeAllocationResult> nodeDecisions = new ArrayList<>();  
import java.util.Arrays;
import org.opensearch.Version;
        nodeDecisions.add(
    private DiscoveryNode node2 = new DiscoveryNode("node2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        assertNull(noDecision.getTargetNode());  
        final AllocationStatus allocationStatus = randomFrom(  
    public void testThrottleDecision() {
import java.util.ArrayList;  
        AllocateUnassignedDecision decision;  
        assertEquals(AllocationStatus.DECIDERS_THROTTLED, throttleDecision.getAllocationStatus());
 * You may obtain a copy of the License at  
        final boolean reuseStore = randomBoolean();
        // same fields for the ShardAllocationDecision, but should be different instances  
        for (AllocationStatus allocationStatus : cacheableStatuses) {  
 * ownership. Elasticsearch licenses this file to you under  
            assertEquals("cannot allocate because allocation is not permitted to any of the nodes", noDecision.getExplanation());
        if (allocationStatus == AllocationStatus.FETCHING_SHARD_DATA) {  
                AllocateUnassignedDecision another = AllocateUnassignedDecision.no(allocationStatus, null);
                randomBoolean() ? randomAlphaOfLength(5) : null,
                AllocateUnassignedDecision another = AllocateUnassignedDecision.throttle(null);  
            AllocationStatus.DELAYED_ALLOCATION
        DiscoveryNode node2 = new DiscoveryNode("node2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);  
        noDecision = AllocateUnassignedDecision.no(AllocationStatus.DECIDERS_NO, nodeDecisions, reuseStore);  
            } else {
                assertSame(cached, another);
import org.opensearch.cluster.node.DiscoveryNode;
        nodeDecisions.add(new NodeAllocationResult(node1, Decision.NO, 2));
 *
        DiscoveryNode node1 = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
                nodeDecisions,
                nodeDecisions,
/**
                AllocateUnassignedDecision notCached = AllocateUnassignedDecision.throttle(new ArrayList<>());
            AllocationStatus.FETCHING_SHARD_DATA  
            AllocationStatus.NO_VALID_SHARD_COPY,
 * SPDX-License-Identifier: Apache-2.0
    public void testYesDecision() {
        assertEquals(allocationStatus, noDecision.getAllocationStatus());
        BytesStreamOutput output = new BytesStreamOutput();  
            );
 * The OpenSearch Contributors require contributions made to  
        assertEquals(decision.getTargetNode(), readDecision.getTargetNode());  
        // node2 should have the highest sort order  
        expectThrows(IllegalStateException.class, () -> allocateUnassignedDecision.getTargetNode());  
        assertNull(yesDecision.getAllocationStatus());
        assertEquals(AllocationStatus.DECIDERS_NO, noDecision.getAllocationStatus());  
        assertNull(noDecision.getAllocationId());  
        assertTrue(yesDecision.isDecisionTaken());
                noDecision.getExplanation()
/*
    public void testCachedDecisions() {
        nodeDecisions.add(new NodeAllocationResult(node1, Decision.NO, 1));  
public class AllocateUnassignedDecisionTests extends OpenSearchTestCase {
            )
        } else if (allocationStatus == AllocationStatus.DELAYED_ALLOCATION) {
        assertEquals("node2", yesDecision.getNodeDecisions().iterator().next().getNode().getId());
    }  
                assignedNode,  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(throttleDecision.getExplanation(), startsWith("allocation temporarily throttled"));  
        assertEquals("node2", yesDecision.getTargetNode().getId());
                "cannot allocate because information about existing shard data is still being retrieved from " + "some of the nodes",
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
                randomBoolean()  
 *  
import org.opensearch.common.io.stream.BytesStreamOutput;
            }  
            AllocationStatus.DECIDERS_NO,  
        }
 * license agreements. See the NOTICE file distributed with
                "cannot allocate because allocation is not permitted to any of the nodes that hold an in-sync shard copy",  
                AllocateUnassignedDecision cached = AllocateUnassignedDecision.throttle(null);
        assertEquals(decision.getAllocationId(), readDecision.getAllocationId());
            new NodeAllocationResult(  
 * this file be licensed under the Apache-2.0 license or a
        assertNotSame(first, second);
        AllocateUnassignedDecision second = AllocateUnassignedDecision.yes(node1, "abc", emptyList(), randomBoolean());
        AllocateUnassignedDecision first = AllocateUnassignedDecision.yes(node1, "abc", emptyList(), randomBoolean());
        expectThrows(IllegalStateException.class, () -> allocateUnassignedDecision.getAllocationDecision());  
            assertThat(noDecision.getExplanation(), startsWith("cannot allocate because a previous copy of the primary shard existed"));
        nodeDecisions.add(new NodeAllocationResult(node1, Decision.NO, 1));
        assertEquals(AllocationDecision.YES, yesDecision.getAllocationDecision());  
/*  
import org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus;  
                randomFrom(AllocationStatus.DELAYED_ALLOCATION, AllocationStatus.NO_VALID_SHARD_COPY, AllocationStatus.FETCHING_SHARD_DATA),
        if (finalDecision == Decision.Type.YES) {
import static java.util.Collections.emptyMap;  
        expectThrows(NullPointerException.class, () -> AllocateUnassignedDecision.no(null, null));
        assertTrue(noDecision.isDecisionTaken());  
        AllocateUnassignedDecision noDecision = AllocateUnassignedDecision.no(allocationStatus, null);
 *
                another = AllocateUnassignedDecision.no(allocationStatus, new ArrayList<>());
 */  
            assertEquals(
 * under the License.  
    public void testNoDecision() {
        assertEquals(decision.getExplanation(), readDecision.getExplanation());
        }
        assertNull(throttleDecision.getAllocationId());
                assertNotSame(notCached, another);
    public void testDecisionNotTaken() {  
        }  
        nodeDecisions.add(new NodeAllocationResult(node2, Decision.NO, 2));
        if (reuseStore) {
    }
                1  
                AllocateUnassignedDecision notCached = AllocateUnassignedDecision.no(allocationStatus, new ArrayList<>());  
        expectThrows(IllegalStateException.class, () -> allocateUnassignedDecision.getAllocationId());
    }
            );
        List<NodeAllocationResult> nodeDecisions = new ArrayList<>();  
        assertEquals("node1", noDecision.getNodeDecisions().iterator().next().getNode().getId());
        List<AllocationStatus> cacheableStatuses = Arrays.asList(
            );
            decision = AllocateUnassignedDecision.yes(
                another = AllocateUnassignedDecision.throttle(new ArrayList<>());  
package org.opensearch.cluster.routing.allocation;
 * GitHub history for details.
 * specific language governing permissions and limitations
        assertEquals(nodeDecisions.stream().sorted().collect(Collectors.toList()), noDecision.getNodeDecisions());  
        assertEquals(nodeDecisions.stream().sorted().collect(Collectors.toList()), yesDecision.getNodeDecisions());  
        // yes decisions are not precomputed and cached  
        assertFalse(allocateUnassignedDecision.isDecisionTaken());
 * the Apache License, Version 2.0 (the "License"); you may
        String allocId = randomBoolean() ? "allocId" : null;  
            assertEquals(
        assertEquals(AllocationDecision.NO, noDecision.getAllocationDecision());
        AllocateUnassignedDecision throttleDecision = AllocateUnassignedDecision.throttle(nodeDecisions);
 */  
        nodeDecisions.add(new NodeAllocationResult(node2, Decision.THROTTLE, 2));
        nodeDecisions.add(new NodeAllocationResult(node2, Decision.YES, 2));
 * not use this file except in compliance with the License.
        assertNull(throttleDecision.getTargetNode());
            decision = AllocateUnassignedDecision.no(  
        );
        Decision.Type finalDecision = randomFrom(Decision.Type.values());
        assertEquals(decision.getAllocationStatus(), readDecision.getAllocationStatus());
}
        // test bad values  
                randomBoolean()  
 * Unit tests for the {@link AllocateUnassignedDecision} class.
        assertNull(noDecision.getTargetNode());
        assertEquals("can allocate the shard", yesDecision.getExplanation());
        assertTrue(throttleDecision.isDecisionTaken());  
import java.util.List;
        );
    }
        assertEquals("node2", readDecision.getNodeDecisions().iterator().next().getNode().getId());
import static org.hamcrest.Matchers.startsWith;
        // node2 should be sorted first b/c a THROTTLE is higher than a NO decision
        decision.writeTo(output);
        assertTrue(noDecision.isDecisionTaken());
        assertEquals(AllocationDecision.THROTTLED, throttleDecision.getAllocationDecision());
        AllocateUnassignedDecision readDecision = new AllocateUnassignedDecision(output.bytes().streamInput());
            );
    private DiscoveryNode node1 = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);  
        expectThrows(IllegalStateException.class, () -> allocateUnassignedDecision.getExplanation());
 * compatible open source license.
        } else {  
import java.util.stream.Collectors;  
        );
        assertEquals(nodeDecisions.stream().sorted().collect(Collectors.toList()), throttleDecision.getNodeDecisions());
            AllocationStatus.DELAYED_ALLOCATION,
        List<NodeAllocationResult> nodeDecisions = new ArrayList<>();
        nodeDecisions.add(new NodeAllocationResult(node1, Decision.NO, 1));  
                AllocateUnassignedDecision cached = AllocateUnassignedDecision.no(allocationStatus, null);  
                assertNotSame(notCached, another);
/*  
        }
        assertEquals(allocId, yesDecision.getAllocationId());
import org.opensearch.cluster.routing.allocation.decider.Decision;
                finalDecision == Decision.Type.YES ? Decision.YES : randomFrom(Decision.NO, Decision.THROTTLE, Decision.YES),
        assertNull(noDecision.getAllocationId());
import static java.util.Collections.emptyList;
