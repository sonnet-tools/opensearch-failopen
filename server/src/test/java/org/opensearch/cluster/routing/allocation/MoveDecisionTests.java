        assertNotSame(stay1, stay2);
        assertNotSame(stay1, stay2);
        stay = MoveDecision.stay(Decision.YES);
        Type finalDecision = randomFrom(Type.values());
        stay1 = MoveDecision.cannotRemain(Decision.NO, AllocationDecision.NO, null, new ArrayList<>());
import org.opensearch.Version;
 * The OpenSearch Contributors require contributions made to
        // final decision is YES, so shouldn't use cached decision
    public void testSerialization() throws IOException {
/**
        assertEquals(AllocationDecision.NO_ATTEMPT, stay.getAllocationDecision());
import org.opensearch.cluster.routing.allocation.decider.Decision;
        // final decision is NO, but in explain mode, so shouldn't use cached decision
 *
        DiscoveryNode node2 = new DiscoveryNode("node2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertTrue(stay.isDecisionTaken());
        DiscoveryNode node2 = new DiscoveryNode("node2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
    }
import static java.util.Collections.emptyMap;
        assertEquals("node2", readDecision.getNodeDecisions().iterator().next().getNode().getId());
 */
        assertFalse(stay.forceMove());
    }
            Decision.NO,
        assertEquals(moveDecision.getTargetNode(), readDecision.getTargetNode());
        stay2 = MoveDecision.cannotRemain(Decision.NO, AllocationDecision.NO, null, null);
        DiscoveryNode node1 = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        List<NodeAllocationResult> nodeDecisions = new ArrayList<>();
        nodeDecisions.add(new NodeAllocationResult(node2, nodeDecision, 1));
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under
        MoveDecision stay2 = MoveDecision.stay(null);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * SPDX-License-Identifier: Apache-2.0
            new NodeAllocationResult(
        stay1 = MoveDecision.cannotRemain(Decision.NO, AllocationDecision.NO, null, null);
        assertTrue(stay.isDecisionTaken());
        assertEquals(moveDecision.forceMove(), readDecision.forceMove());
            assignedNode,
 * You may obtain a copy of the License at
                finalDecision == Type.YES ? Decision.YES : randomFrom(Decision.NO, Decision.THROTTLE, Decision.YES),
        assertFalse(stay.forceMove());
 * this work for additional information regarding copyright
        assertTrue(stay.canRemain());
package org.opensearch.cluster.routing.allocation;
        // cached stay decision
 */
        // cached cannot move decision
        assertNull(stay.getNodeDecisions());
        MoveDecision stay1 = MoveDecision.stay(null);
        DiscoveryNode node1 = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
import java.io.IOException;
            )
        );
        nodeDecisions.add(new NodeAllocationResult(node1, Decision.NO, 2));
        nodeDecisions.add(new NodeAllocationResult(node1, nodeDecision, 2));
        decision = MoveDecision.cannotRemain(Decision.NO, AllocationDecision.YES, node2, null);
        stay1 = MoveDecision.stay(Decision.YES);
        BytesStreamOutput output = new BytesStreamOutput();
 * Unit tests for the {@link MoveDecision} class.
        assertEquals(stay1.getTargetNode(), stay2.getTargetNode());
        assertEquals("node2", decision.getNodeDecisions().iterator().next().getNode().getId());
import java.util.ArrayList;
    public void testCachedDecisions() {
 */
        assertEquals(2, decision.getNodeDecisions().size());
        );
        assertEquals(stay1.getExplanation(), stay2.getExplanation());
        stay2 = MoveDecision.cannotRemain(Decision.NO, AllocationDecision.YES, node1, null);
 * KIND, either express or implied.  See the License for the
    }
        assertNull(stay.getNodeDecisions());
 * GitHub history for details.
 *
        moveDecision.writeTo(output);
        assertTrue(stay.canRemain());
    }
        assertEquals(moveDecision.getAllocationDecision(), readDecision.getAllocationDecision());
        MoveDecision decision = MoveDecision.cannotRemain(Decision.NO, AllocationDecision.NO, null, nodeDecisions);
        stay2 = MoveDecision.stay(Decision.YES);
public class MoveDecisionTests extends OpenSearchTestCase {
        assertNotNull(decision.getNodeDecisions());
 * not use this file except in compliance with the License.
        assertSame(stay1.getAllocationDecision(), stay2.getAllocationDecision());
    public void testStayDecision() {
        assertEquals(moveDecision.getNodeDecisions().size(), readDecision.getNodeDecisions().size());
/*
import static java.util.Collections.emptySet;
        assertNotNull(stay1.getExplanation());
            AllocationDecision.fromDecisionType(finalDecision),
        List<NodeAllocationResult> nodeDecisions = new ArrayList<>();
 * Unless required by applicable law or agreed to in writing,
        assertNotNull(decision.getAllocationDecision());
import org.opensearch.common.io.stream.BytesStreamOutput;
/*
 *
                1
 * specific language governing permissions and limitations
        // node2 should have the highest sort order
        assertNotSame(stay1, stay2);
 * software distributed under the License is distributed on an
        assertEquals("node2", decision.getTargetNode().getId());
/*
        stay2 = MoveDecision.cannotRemain(Decision.NO, AllocationDecision.NO, null, new ArrayList<>());
        nodeDecisions.add(
        MoveDecision readDecision = new MoveDecision(output.bytes().streamInput());
        DiscoveryNode assignedNode = finalDecision == Type.YES ? node1 : null;
        assertEquals(moveDecision.canRemain(), readDecision.canRemain());
    public void testDecisionWithNodeExplanations() {
        stay1 = MoveDecision.cannotRemain(Decision.NO, AllocationDecision.YES, node1, null);
 * this file be licensed under the Apache-2.0 license or a
        DiscoveryNode node1 = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        Decision nodeDecision = randomFrom(Decision.NO, Decision.THROTTLE, Decision.YES);
                node2,
        assertSame(stay1, stay2);
 * license agreements. See the NOTICE file distributed with
        assertNotNull(decision.getExplanation());
 * under the License.
import org.opensearch.test.OpenSearchTestCase;
import java.util.List;
import org.opensearch.cluster.routing.allocation.decider.Decision.Type;
        // both nodes have the same decision type but node2 has a higher weight ranking, so node2 comes first
}
            nodeDecisions
 * the Apache License, Version 2.0 (the "License"); you may
        MoveDecision moveDecision = MoveDecision.cannotRemain(
import org.opensearch.cluster.node.DiscoveryNode;
        assertEquals(moveDecision.getExplanation(), readDecision.getExplanation());
        assertSame(stay1, stay2); // not in explain mode, so should use cached decision
        assertEquals(AllocationDecision.NO_ATTEMPT, stay.getAllocationDecision());
 */
 * Licensed to Elasticsearch under one or more contributor
        MoveDecision stay = MoveDecision.stay(Decision.YES);
