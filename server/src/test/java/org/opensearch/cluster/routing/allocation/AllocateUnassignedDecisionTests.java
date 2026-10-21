/*
        assertEquals(nodeDecisions.stream().sorted().collect(Collectors.toList()), noDecision.getNodeDecisions());
import static java.util.Collections.emptySet;
                assertNotSame(notCached, another);
            decision = AllocateUnassignedDecision.yes(
        final boolean reuseStore = randomBoolean();
                "cannot allocate because allocation is not permitted to any of the nodes that hold an in-sync shard copy",
        assertEquals(AllocationStatus.DECIDERS_THROTTLED, throttleDecision.getAllocationStatus());
 * license agreements. See the NOTICE file distributed with
    private DiscoveryNode node2 = new DiscoveryNode("node2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
                another = AllocateUnassignedDecision.no(allocationStatus, new ArrayList<>());
        assertEquals("node2", yesDecision.getNodeDecisions().iterator().next().getNode().getId());
 * this work for additional information regarding copyright
            AllocationStatus.NO_VALID_SHARD_COPY,
        for (AllocationStatus allocationStatus : cacheableStatuses) {
        }
                assertNotSame(notCached, another);
        assertNotSame(first, second);
            );
            AllocationStatus.FETCHING_SHARD_DATA,
        nodeDecisions.add(
                finalDecision == Decision.Type.YES ? Decision.YES : randomFrom(Decision.NO, Decision.THROTTLE, Decision.YES),
        // same fields for the ShardAllocationDecision, but should be different instances
    }
                AllocateUnassignedDecision cached = AllocateUnassignedDecision.no(allocationStatus, null);
        assertNull(throttleDecision.getAllocationId());
        assertEquals(decision.getAllocationDecision(), readDecision.getAllocationDecision());
        assertNull(noDecision.getTargetNode());
                noDecision.getExplanation()
                "cannot allocate because information about existing shard data is still being retrieved from " + "some of the nodes",
        assertEquals("node2", readDecision.getNodeDecisions().iterator().next().getNode().getId());
        String allocId = randomBoolean() ? "allocId" : null;
            AllocationStatus.DECIDERS_THROTTLED,
    }
 *
        assertEquals(allocId, yesDecision.getAllocationId());
 * software distributed under the License is distributed on an
                assertSame(cached, another);
        nodeDecisions.add(new NodeAllocationResult(node1, Decision.NO, 1));
                AllocateUnassignedDecision notCached = AllocateUnassignedDecision.throttle(new ArrayList<>());
                assignedNode,
        );
        assertEquals(AllocationDecision.NO, noDecision.getAllocationDecision());
                randomFrom(AllocationStatus.DELAYED_ALLOCATION, AllocationStatus.NO_VALID_SHARD_COPY, AllocationStatus.FETCHING_SHARD_DATA),
 * ownership. Elasticsearch licenses this file to you under
        assertEquals(decision.getTargetNode(), readDecision.getTargetNode());
            assertEquals("cannot allocate because allocation is not permitted to any of the nodes", noDecision.getExplanation());
 * KIND, either express or implied.  See the License for the
                assertSame(cached, another);
        assertTrue(noDecision.isDecisionTaken());
        AllocateUnassignedDecision allocateUnassignedDecision = AllocateUnassignedDecision.NOT_TAKEN;
        } else {
            );
        assertThat(throttleDecision.getExplanation(), startsWith("allocation temporarily throttled"));
import java.io.IOException;
        noDecision = AllocateUnassignedDecision.no(AllocationStatus.DECIDERS_NO, nodeDecisions, reuseStore);
        DiscoveryNode node1 = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
                AllocateUnassignedDecision another = AllocateUnassignedDecision.no(allocationStatus, null);
                randomBoolean()
        assertEquals(nodeDecisions.stream().sorted().collect(Collectors.toList()), yesDecision.getNodeDecisions());
public class AllocateUnassignedDecisionTests extends OpenSearchTestCase {
            );
                AllocateUnassignedDecision notCached = AllocateUnassignedDecision.no(allocationStatus, new ArrayList<>());
    public void testSerialization() throws IOException {
        }
        assertEquals(decision.getNodeDecisions().size(), readDecision.getNodeDecisions().size());
        List<NodeAllocationResult> nodeDecisions = new ArrayList<>();
                nodeDecisions,
                noDecision.getExplanation()
    }
        assertEquals(nodeDecisions.stream().sorted().collect(Collectors.toList()), throttleDecision.getNodeDecisions());
        assertNull(throttleDecision.getTargetNode());
 * Modifications Copyright OpenSearch Contributors. See
            );
            AllocationStatus.DELAYED_ALLOCATION
            AllocationStatus.DELAYED_ALLOCATION,
        assertEquals("node2", yesDecision.getTargetNode().getId());
        DiscoveryNode assignedNode = finalDecision == Decision.Type.YES ? node1 : null;
                1
 */
                randomBoolean() ? randomAlphaOfLength(5) : null,
import java.util.ArrayList;
        assertTrue(noDecision.isDecisionTaken());
        AllocateUnassignedDecision noDecision = AllocateUnassignedDecision.no(allocationStatus, null);
            assertThat(noDecision.getExplanation(), startsWith("cannot allocate because the cluster is still waiting"));
        AllocateUnassignedDecision second = AllocateUnassignedDecision.yes(node1, "abc", emptyList(), randomBoolean());
 * under the License.
        }
        DiscoveryNode node2 = new DiscoveryNode("node2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        expectThrows(IllegalStateException.class, () -> allocateUnassignedDecision.getExplanation());
        if (finalDecision == Decision.Type.YES) {
        assertEquals("node2", throttleDecision.getNodeDecisions().iterator().next().getNode().getId());
        }
            new NodeAllocationResult(
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            decision = AllocateUnassignedDecision.no(
        List<NodeAllocationResult> nodeDecisions = new ArrayList<>();
 */
    }
        nodeDecisions.add(new NodeAllocationResult(node1, Decision.NO, 1));
        AllocateUnassignedDecision readDecision = new AllocateUnassignedDecision(output.bytes().streamInput());
        Decision.Type finalDecision = randomFrom(Decision.Type.values());
        AllocateUnassignedDecision first = AllocateUnassignedDecision.yes(node1, "abc", emptyList(), randomBoolean());
                another = AllocateUnassignedDecision.throttle(new ArrayList<>());
 * The OpenSearch Contributors require contributions made to
 */
/*
        assertNull(noDecision.getTargetNode());
    public void testCachedDecisions() {
        nodeDecisions.add(new NodeAllocationResult(node2, Decision.THROTTLE, 2));
        assertEquals(decision.getAllocationStatus(), readDecision.getAllocationStatus());
 * specific language governing permissions and limitations
        } else {
import org.opensearch.cluster.node.DiscoveryNode;
 * Licensed to Elasticsearch under one or more contributor
        BytesStreamOutput output = new BytesStreamOutput();
        assertNull(noDecision.getNodeDecisions());
        assertEquals(AllocationDecision.THROTTLED, throttleDecision.getAllocationDecision());
    public void testNoDecision() {
        expectThrows(IllegalStateException.class, () -> allocateUnassignedDecision.getAllocationDecision());
 * You may obtain a copy of the License at
        List<NodeAllocationResult> nodeDecisions = new ArrayList<>();
            }
                AllocateUnassignedDecision cached = AllocateUnassignedDecision.throttle(null);
        // node2 should be sorted first b/c a THROTTLE is higher than a NO decision
        nodeDecisions.add(new NodeAllocationResult(node2, Decision.YES, 2));
/**
        assertEquals(AllocationDecision.YES, yesDecision.getAllocationDecision());
        assertFalse(allocateUnassignedDecision.isDecisionTaken());
            AllocationStatus.DECIDERS_NO,
        expectThrows(NullPointerException.class, () -> AllocateUnassignedDecision.no(null, null));
import java.util.stream.Collectors;
import java.util.Arrays;
package org.opensearch.cluster.routing.allocation;
            AllocationStatus.FETCHING_SHARD_DATA
    public void testYesDecision() {
                randomBoolean()
        assertEquals(AllocationStatus.DECIDERS_NO, noDecision.getAllocationStatus());
        expectThrows(IllegalStateException.class, () -> allocateUnassignedDecision.getAllocationId());
        assertEquals(allocationStatus, noDecision.getAllocationStatus());
 *
import org.opensearch.cluster.routing.allocation.decider.Decision;
            AllocationStatus.NO_VALID_SHARD_COPY,
        List<NodeAllocationResult> nodeDecisions = new ArrayList<>();
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
import org.opensearch.test.OpenSearchTestCase;
        nodeDecisions.add(new NodeAllocationResult(node1, Decision.NO, 2));
    private DiscoveryNode node1 = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
 * not use this file except in compliance with the License.
    public void testThrottleDecision() {
}
        expectThrows(IllegalStateException.class, () -> allocateUnassignedDecision.getAllocationStatus());
/*
            } else {
import org.opensearch.Version;
        expectThrows(IllegalStateException.class, () -> allocateUnassignedDecision.getNodeDecisions());
        // yes decisions are not precomputed and cached
        assertTrue(yesDecision.isDecisionTaken());
        assertTrue(throttleDecision.isDecisionTaken());
        final AllocationStatus allocationStatus = randomFrom(
 * Unless required by applicable law or agreed to in writing,
        nodeDecisions.add(new NodeAllocationResult(node2, Decision.NO, 2));
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("node1", noDecision.getNodeDecisions().iterator().next().getNode().getId());
        AllocateUnassignedDecision throttleDecision = AllocateUnassignedDecision.throttle(nodeDecisions);
            assertEquals(
        expectThrows(IllegalStateException.class, () -> allocateUnassignedDecision.getTargetNode());
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus;
        decision.writeTo(output);
 * GitHub history for details.
        assertEquals(AllocationDecision.fromAllocationStatus(allocationStatus), noDecision.getAllocationDecision());
        assertEquals(decision.getAllocationId(), readDecision.getAllocationId());
        assertNull(yesDecision.getAllocationStatus());
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertEquals(decision.getExplanation(), readDecision.getExplanation());
        assertNull(noDecision.getAllocationId());
        );
        if (reuseStore) {
import static java.util.Collections.emptyList;
        );
        // node1 should be sorted first b/c of better weight ranking
        } else if (allocationStatus == AllocationStatus.DELAYED_ALLOCATION) {
        AllocateUnassignedDecision decision;
 * Unit tests for the {@link AllocateUnassignedDecision} class.
    public void testDecisionNotTaken() {
    }
        assertNull(noDecision.getAllocationId());
        List<AllocationStatus> cacheableStatuses = Arrays.asList(
        if (allocationStatus == AllocationStatus.FETCHING_SHARD_DATA) {
 */
        nodeDecisions.add(new NodeAllocationResult(node1, Decision.NO, 1));
        // node2 should have the highest sort order
    }
                nodeDecisions,
        assertEquals("can allocate the shard", yesDecision.getExplanation());
        // node1 should be sorted first b/c YES decisions are the highest
            assertThat(noDecision.getExplanation(), startsWith("cannot allocate because a previous copy of the primary shard existed"));
        // test bad values
import static java.util.Collections.emptyMap;
            if (allocationStatus == AllocationStatus.DECIDERS_THROTTLED) {
                node2,
        } else {
                AllocateUnassignedDecision another = AllocateUnassignedDecision.throttle(null);
import static org.hamcrest.Matchers.startsWith;
        AllocateUnassignedDecision yesDecision = AllocateUnassignedDecision.yes(node2, allocId, nodeDecisions, randomBoolean());
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(
            )
import java.util.List;
