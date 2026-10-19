        nodeDecisions.add(new NodeAllocationResult(node1, nodeDecision, 2));  
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals("node2", readDecision.getNodeDecisions().iterator().next().getNode().getId());
        DiscoveryNode node1 = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        MoveDecision moveDecision = MoveDecision.cannotRemain(
/*  
import java.util.ArrayList;  
        assertFalse(stay.forceMove());  
 * ownership. Elasticsearch licenses this file to you under  
import static java.util.Collections.emptyMap;  
        );  
    public void testSerialization() throws IOException {
                finalDecision == Type.YES ? Decision.YES : randomFrom(Decision.NO, Decision.THROTTLE, Decision.YES),  
        assertNotNull(decision.getNodeDecisions());
        assertEquals(moveDecision.getAllocationDecision(), readDecision.getAllocationDecision());  
 * Modifications Copyright OpenSearch Contributors. See
        decision = MoveDecision.cannotRemain(Decision.NO, AllocationDecision.YES, node2, null);
            AllocationDecision.fromDecisionType(finalDecision),  
        assertTrue(stay.canRemain());
        stay1 = MoveDecision.cannotRemain(Decision.NO, AllocationDecision.NO, null, null);  
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
        assertEquals(2, decision.getNodeDecisions().size());  
        assertEquals(AllocationDecision.NO_ATTEMPT, stay.getAllocationDecision());
 * this work for additional information regarding copyright
 *
import org.opensearch.test.OpenSearchTestCase;  
        assertNotNull(decision.getAllocationDecision());  
        // final decision is NO, but in explain mode, so shouldn't use cached decision  
        assertSame(stay1, stay2); // not in explain mode, so should use cached decision  
        // final decision is YES, so shouldn't use cached decision  
        assertFalse(stay.forceMove());
 * You may obtain a copy of the License at  
        assertSame(stay1, stay2);
/*
        stay2 = MoveDecision.cannotRemain(Decision.NO, AllocationDecision.NO, null, new ArrayList<>());
            assignedNode,
        assertEquals("node2", decision.getTargetNode().getId());
 * Unit tests for the {@link MoveDecision} class.
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertEquals(stay1.getTargetNode(), stay2.getTargetNode());
        Decision nodeDecision = randomFrom(Decision.NO, Decision.THROTTLE, Decision.YES);
        stay2 = MoveDecision.cannotRemain(Decision.NO, AllocationDecision.NO, null, null);
 * software distributed under the License is distributed on an
 *     http://www.apache.org/licenses/LICENSE-2.0
            Decision.NO,
public class MoveDecisionTests extends OpenSearchTestCase {  
        assertTrue(stay.isDecisionTaken());
        stay = MoveDecision.stay(Decision.YES);
        assertNotNull(stay1.getExplanation());
    public void testCachedDecisions() {
        MoveDecision stay = MoveDecision.stay(Decision.YES);
 */  
        MoveDecision stay2 = MoveDecision.stay(null);
        // cached stay decision  
 * license agreements. See the NOTICE file distributed with
            )
        MoveDecision decision = MoveDecision.cannotRemain(Decision.NO, AllocationDecision.NO, null, nodeDecisions);
    }
    }
                1
            nodeDecisions
 * The OpenSearch Contributors require contributions made to  
        // both nodes have the same decision type but node2 has a higher weight ranking, so node2 comes first
        BytesStreamOutput output = new BytesStreamOutput();
 * under the License.  
 */  
        // node2 should have the highest sort order
 * not use this file except in compliance with the License.
    public void testDecisionWithNodeExplanations() {
        Type finalDecision = randomFrom(Type.values());  
 * the Apache License, Version 2.0 (the "License"); you may
        List<NodeAllocationResult> nodeDecisions = new ArrayList<>();  
        assertNotNull(decision.getExplanation());
 */
        assertEquals("node2", decision.getNodeDecisions().iterator().next().getNode().getId());
        moveDecision.writeTo(output);
        nodeDecisions.add(  
        assertTrue(stay.canRemain());  
import org.opensearch.cluster.routing.allocation.decider.Decision.Type;
        assertEquals(moveDecision.canRemain(), readDecision.canRemain());
    }  
        MoveDecision stay1 = MoveDecision.stay(null);
        assertTrue(stay.isDecisionTaken());
 */
        stay2 = MoveDecision.cannotRemain(Decision.NO, AllocationDecision.YES, node1, null);  
            new NodeAllocationResult(
        // cached cannot move decision
        stay1 = MoveDecision.cannotRemain(Decision.NO, AllocationDecision.YES, node1, null);
        assertSame(stay1.getAllocationDecision(), stay2.getAllocationDecision());
                node2,
        stay1 = MoveDecision.cannotRemain(Decision.NO, AllocationDecision.NO, null, new ArrayList<>());
        nodeDecisions.add(new NodeAllocationResult(node2, nodeDecision, 1));
package org.opensearch.cluster.routing.allocation;
/**  
import static java.util.Collections.emptySet;
        DiscoveryNode node1 = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        assertNotSame(stay1, stay2);  
        assertEquals(moveDecision.forceMove(), readDecision.forceMove());  
        assertNull(stay.getNodeDecisions());  
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
        DiscoveryNode node2 = new DiscoveryNode("node2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
 *
        );  
        assertEquals(moveDecision.getNodeDecisions().size(), readDecision.getNodeDecisions().size());
import org.opensearch.cluster.node.DiscoveryNode;
        assertEquals(stay1.getExplanation(), stay2.getExplanation());  
/*  
        stay1 = MoveDecision.stay(Decision.YES);
        assertEquals(AllocationDecision.NO_ATTEMPT, stay.getAllocationDecision());  
        assertNull(stay.getNodeDecisions());
 *  
import java.io.IOException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        DiscoveryNode node1 = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        nodeDecisions.add(new NodeAllocationResult(node1, Decision.NO, 2));
        stay2 = MoveDecision.stay(Decision.YES);
 * GitHub history for details.
        assertNotSame(stay1, stay2);  
}
        List<NodeAllocationResult> nodeDecisions = new ArrayList<>();
        MoveDecision readDecision = new MoveDecision(output.bytes().streamInput());  
 * SPDX-License-Identifier: Apache-2.0
        assertNotSame(stay1, stay2);
        DiscoveryNode assignedNode = finalDecision == Type.YES ? node1 : null;
 * specific language governing permissions and limitations
import org.opensearch.Version;
        assertEquals(moveDecision.getExplanation(), readDecision.getExplanation());
    public void testStayDecision() {  
 * compatible open source license.
        DiscoveryNode node2 = new DiscoveryNode("node2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);  
    }  
import org.opensearch.cluster.routing.allocation.decider.Decision;  
        assertEquals(moveDecision.getTargetNode(), readDecision.getTargetNode());
