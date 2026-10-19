    @Override
        List<NodePruneBlockCacheResponse> nodes = List.of(new NodePruneBlockCacheResponse(node, true));
import org.opensearch.core.xcontent.XContentBuilder;
            return new PruneBlockCacheRequest("mutated-node");
        return PruneBlockCacheRequest::new;  
    @Override  
        }
 */  
 * The OpenSearch Contributors require contributions made to  
            buildNewFakeTransportAddress(),  
        DiscoveryNode node = new DiscoveryNode(  
        return new PruneBlockCacheRequest();  
    protected Writeable.Reader<PruneBlockCacheRequest> instanceReader() {
    public void testResponseXContentWithFailure() throws IOException {
            "node1",
    public void testNodeResponseXContent() throws IOException {
 */  
public class PruneBlockCacheRequestResponseTests extends AbstractWireSerializingTestCase<PruneBlockCacheRequest> {
        builder.startObject();
        assertTrue(json.contains("\"cleared\":true"));
        assertTrue(json.contains("\"cleared\":true"));
        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.endObject();  
 * compatible open source license.
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.cluster.ClusterName;  
    }
import org.opensearch.cluster.node.DiscoveryNode;
        response.toXContent(builder, ToXContent.EMPTY_PARAMS);
            "node1",
        }  
package org.opensearch.action.admin.cluster.blockcache;
    }
            buildNewFakeTransportAddress(),  
    @Override  
import org.opensearch.Version;
            "node1",
            Version.CURRENT  
import java.util.List;
    }  
    }  
            nodes[i] = "node" + i;
    protected PruneBlockCacheRequest createTestInstance() {
    public void testResponseXContentSingleNode() throws IOException {
        );
        XContentBuilder builder = XContentFactory.jsonBuilder();
    // ── PruneBlockCacheResponse ───────────────────────────────────────────────  
import java.io.IOException;
/**  
        List<NodePruneBlockCacheResponse> nodes = List.of(new NodePruneBlockCacheResponse(node, true));
        NodePruneBlockCacheResponse response = new NodePruneBlockCacheResponse(node, true);
        assertTrue(json.contains("\"failed_nodes\":1"));
            "node1",
        }
        // toggle between no-nodes and single-node to produce a different instance
    protected PruneBlockCacheRequest mutateInstance(PruneBlockCacheRequest instance) {
 * and {@link NodePruneBlockCacheResponse}.
            Collections.emptyMap(),
import org.opensearch.test.AbstractWireSerializingTestCase;  
        assertTrue(json.contains("\"acknowledged\":true"));
import org.opensearch.core.common.io.stream.Writeable;  
    // ── NodePruneBlockCacheResponse ───────────────────────────────────────────  
            Version.CURRENT  
            Collections.emptySet(),
            "node1",
import java.util.Collections;  
        DiscoveryNode node = new DiscoveryNode(  
/*  
        if (randomBoolean()) {
 * Wire-serialization and XContent tests for {@link PruneBlockCacheRequest}, {@link PruneBlockCacheResponse},
        XContentBuilder builder = XContentFactory.jsonBuilder();  
        int count = randomIntBetween(1, 3);
            buildNewFakeTransportAddress(),  
        );
        PruneBlockCacheResponse response = new PruneBlockCacheResponse(new ClusterName("test"), nodes, Collections.emptyList());  
        response.toXContent(builder, ToXContent.EMPTY_PARAMS);
        );
        PruneBlockCacheResponse response = new PruneBlockCacheResponse(new ClusterName("test"), nodes, failures);
        String json = builder.toString();
        String[] nodes = new String[count];  
 * this file be licensed under the Apache-2.0 license or a
        for (int i = 0; i < count; i++) {
        String json = builder.toString();  
            Collections.emptySet(),
        DiscoveryNode node = new DiscoveryNode(  
    }
        return new PruneBlockCacheRequest(nodes);
        response.toXContent(builder, ToXContent.EMPTY_PARAMS);  
import org.opensearch.action.FailedNodeException;
        if (instance.nodesIds() == null || instance.nodesIds().length == 0) {  
            Collections.emptySet(),
            Collections.emptyMap(),
    }
            Collections.emptyMap(),
}
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.xcontent.XContentFactory;
            return new PruneBlockCacheRequest();  
        assertTrue(json.contains("node1"));  
 *
            Version.CURRENT  
            "node1",
        String json = builder.toString();
        List<FailedNodeException> failures = List.of(new FailedNodeException("node2", "simulated", new RuntimeException()));  
