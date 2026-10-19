    public void testSerialization() throws IOException {  
 */  
 * ownership. Elasticsearch licenses this file to you under  
        explanation.writeTo(output);
        } else {  
 * not use this file except in compliance with the License.
 *
/*  
        assertEquals(inSync, explanation.getShardStoreInfo().isInSync());  
import static java.util.Collections.emptyMap;
 *  
        Decision decision = randomFrom(Decision.YES, Decision.THROTTLE, Decision.NO);
 * Licensed to Elasticsearch under one or more contributor  
 *
        assertEquals(0, Float.compare(expl1.getWeightRanking(), expl2.getWeightRanking()));  
 * this file be licensed under the Apache-2.0 license or a
 */  
 * specific language governing permissions and limitations
        explanation = new NodeAllocationResult(node, shardStoreInfo, decision);
/*  
        DiscoveryNode node = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
package org.opensearch.cluster.routing.allocation;
        assertNodeExplanationEquals(explanation, readExplanation);
        assertNodeExplanationEquals(explanation, readExplanation);
        assertFalse(explanation.getShardStoreInfo().hasMatchingSyncId());
        DiscoveryNode node = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
}
        assertNodeExplanationEquals(explanation, readExplanation);
        BytesStreamOutput output = new BytesStreamOutput();
    }
import org.opensearch.Version;
 * compatible open source license.
import org.opensearch.common.io.stream.BytesStreamOutput;
 * Unit tests for the {@link NodeAllocationResult} class.
    }  
import org.opensearch.test.OpenSearchTestCase;  
            assertEquals(expl1.getShardStoreInfo().hasMatchingSyncId(), expl2.getShardStoreInfo().hasMatchingSyncId());
        explanation.writeTo(output);
        ShardStoreInfo shardStoreInfo = new ShardStoreInfo(matchingBytes);
import org.opensearch.cluster.routing.allocation.NodeAllocationResult.ShardStoreInfo;  
import java.io.IOException;
import org.opensearch.cluster.node.DiscoveryNode;
 *     http://www.apache.org/licenses/LICENSE-2.0
            assertEquals(expl1.getShardStoreInfo().isInSync(), expl2.getShardStoreInfo().isInSync());
        readExplanation = new NodeAllocationResult(output.bytes().streamInput());
        output = new BytesStreamOutput();
 * SPDX-License-Identifier: Apache-2.0
        String allocId = randomAlphaOfLength(5);
/**
            assertEquals(expl1.getShardStoreInfo().getAllocationId(), expl2.getShardStoreInfo().getAllocationId());  
 * You may obtain a copy of the License at  
        shardStoreInfo = new ShardStoreInfo(allocId, inSync, randomBoolean() ? new Exception("bad stuff") : null);  
        boolean inSync = randomBoolean();
            assertEquals(expl1.getShardStoreInfo().getMatchingBytes(), expl2.getShardStoreInfo().getMatchingBytes());
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
        long matchingBytes = (long) randomIntBetween(1, 1000);
        Decision decision = randomFrom(Decision.YES, Decision.THROTTLE, Decision.NO);  
            assertNull(expl2.getShardStoreInfo());
        NodeAllocationResult readExplanation = new NodeAllocationResult(output.bytes().streamInput());  
        explanation.writeTo(output);  
        NodeAllocationResult explanation = new NodeAllocationResult(node, decision, 1);  
        assertNull(explanation.getShardStoreInfo().getAllocationId());  
 * this work for additional information regarding copyright
 * under the License.  
    public void testShardStore() throws IOException {
public class NodeAllocationResultTests extends OpenSearchTestCase {
        BytesStreamOutput output = new BytesStreamOutput();
 * Modifications Copyright OpenSearch Contributors. See
        }
    }
        assertEquals(expl1.getNode(), expl2.getNode());
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
        assertFalse(explanation.getShardStoreInfo().isInSync());
        NodeAllocationResult readExplanation = new NodeAllocationResult(output.bytes().streamInput());  
 */
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.routing.allocation.decider.Decision;
        assertEquals(matchingBytes, explanation.getShardStoreInfo().getMatchingBytes());
        assertEquals(expl1.getCanAllocateDecision(), expl2.getCanAllocateDecision());
import static java.util.Collections.emptySet;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
    private void assertNodeExplanationEquals(NodeAllocationResult expl1, NodeAllocationResult expl2) {  
        assertFalse(explanation.getShardStoreInfo().hasMatchingSyncId());
/*
        assertEquals(allocId, explanation.getShardStoreInfo().getAllocationId());  
        NodeAllocationResult explanation = new NodeAllocationResult(node, shardStoreInfo, decision);  
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
        assertEquals(-1, explanation.getShardStoreInfo().getMatchingBytes());
        if (expl1.getShardStoreInfo() != null) {
