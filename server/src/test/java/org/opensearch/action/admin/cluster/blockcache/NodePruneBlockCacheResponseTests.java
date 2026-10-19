    @Override
/*  
    protected NodePruneBlockCacheResponse createTestInstance() {
    }
            Collections.emptyMap(),
        return new NodePruneBlockCacheResponse(instance.getNode(), !instance.isCleared());  
            Version.CURRENT  
 * this file be licensed under the Apache-2.0 license or a
    @Override
import org.opensearch.core.common.io.stream.Writeable;  
            Collections.emptySet(),
            randomAlphaOfLength(8),
        return NodePruneBlockCacheResponse::new;
    }  
            buildNewFakeTransportAddress(),  
 * SPDX-License-Identifier: Apache-2.0
 */  
}
    @Override
            randomAlphaOfLength(8),
 *
public class NodePruneBlockCacheResponseTests extends AbstractWireSerializingTestCase<NodePruneBlockCacheResponse> {
    protected NodePruneBlockCacheResponse mutateInstance(NodePruneBlockCacheResponse instance) {
        return new NodePruneBlockCacheResponse(node, randomBoolean());
import org.opensearch.Version;
        DiscoveryNode node = new DiscoveryNode(  
    }
    protected Writeable.Reader<NodePruneBlockCacheResponse> instanceReader() {  
        );
 * compatible open source license.
import java.util.Collections;  
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.test.AbstractWireSerializingTestCase;
package org.opensearch.action.admin.cluster.blockcache;
 * The OpenSearch Contributors require contributions made to  
