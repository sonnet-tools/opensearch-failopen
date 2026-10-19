import org.opensearch.Version;
                Version.CURRENT  
        return new NamedWriteableRegistry(Collections.emptyList());
    protected NamedWriteableRegistry getNamedWriteableRegistry() {
}
        }
        assertNotSame(expected, actual);  
        int numPits = randomInt(10);
                emptyMap(),
    protected void assertEqualInstances(GetAllPitNodesResponse expected, GetAllPitNodesResponse actual) {
        List<GetAllPitNodeResponse> actualResponses = actual.getNodes();  
        }
            assertEquals(expectedNodePitInfos, actualNodePitInfos);  
import java.util.Set;
import org.opensearch.cluster.node.DiscoveryNode;
        List<FailedNodeException> failures = new ArrayList<>();
            candidatePitInfos.add(new ListPitInfo(randomAlphaOfLength(10), randomLong(), randomLong()));
        return new GetAllPitNodesResponse(new ClusterName("test"), responses, failures);
        Set<ListPitInfo> actualPitInfos = new HashSet<>(actual.getPitInfos());
    private GetAllPitNodesResponse createTestItem() {
                List<ListPitInfo> nodePitInfos = new ArrayList<>();  
                buildNewFakeTransportAddress(),  
        assertEquals(expectedResponses.size(), actualResponses.size());
        int numNodes = randomIntBetween(1, 10);  
        assertEquals(expectedPitInfos, actualPitInfos);  
    }
        Set<ListPitInfo> expectedPitInfos = new HashSet<>(expected.getPitInfos());
                );
                }  
        for (int i = 0; i < numNodes; i++) {  
            assertEquals(expectedFailures.get(i).nodeId(), actualFailures.get(i).nodeId());
            DiscoveryNode node = new DiscoveryNode(
        for (int i = 0; i < expectedFailures.size(); i++) {  
                    nodePitInfos.add(randomFrom(candidatePitInfos));
 *
        }
                responses.add(new GetAllPitNodeResponse(node, nodePitInfos));
import java.util.HashSet;  
    public void testSerialization() throws IOException {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        for (int i = 0; i < expectedResponses.size(); i++) {
        List<ListPitInfo> candidatePitInfos = new ArrayList<>(numPits);
        List<GetAllPitNodeResponse> expectedResponses = expected.getNodes();
                failures.add(  
import org.opensearch.action.FailedNodeException;
import java.util.Collections;
            }  
        }
import static java.util.Collections.emptyMap;
        for (int i = 0; i < numNodes; i++) {  
 * compatible open source license.
            assertEquals(expectedFailures.get(i).getMessage(), actualFailures.get(i).getMessage());
import static java.util.Collections.emptySet;
            Set<ListPitInfo> expectedNodePitInfos = new HashSet<>(expectedResponses.get(i).getPitInfos());
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
 * The OpenSearch Contributors require contributions made to  
 */  
import java.io.IOException;  
        GetAllPitNodesResponse response = createTestItem();  
        List<GetAllPitNodeResponse> responses = new ArrayList<>();
            assertEquals(expectedFailures.get(i).getCause().getClass(), actualFailures.get(i).getCause().getClass());  
                emptySet(),
    }  
            );
import org.opensearch.transport.TransportException;
        List<FailedNodeException> actualFailures = actual.failures();
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.cluster.ClusterName;  
import java.util.ArrayList;
                for (int j = 0; j < randomInt(numPits); j++) {
        assertEquals(expectedFailures.size(), actualFailures.size());
            if (randomBoolean()) {
package org.opensearch.action.search;
    }  
            assertEquals(expectedResponses.get(i).getNode(), actualResponses.get(i).getNode());  
/*  
                randomAlphaOfLength(10),
            } else {
 * this file be licensed under the Apache-2.0 license or a
    }  
            Set<ListPitInfo> actualNodePitInfos = new HashSet<>(actualResponses.get(i).getPitInfos());
        List<FailedNodeException> expectedFailures = expected.failures();  
public class GetAllPitNodesResponseTests extends OpenSearchTestCase {
        assertEqualInstances(response, deserialized);
        GetAllPitNodesResponse deserialized = copyWriteable(response, getNamedWriteableRegistry(), GetAllPitNodesResponse::new);
                    new FailedNodeException(node.getId(), randomAlphaOfLength(10), new TransportException(randomAlphaOfLength(10)))
