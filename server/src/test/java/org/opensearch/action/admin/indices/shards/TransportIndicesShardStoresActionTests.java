import static org.mockito.Mockito.when;  
        IndexMetadata.Builder indexA1 = IndexMetadata.builder("index_a1")
            clusterService,
public class TransportIndicesShardStoresActionTests extends OpenSearchTestCase {
        when(clusterService.state()).thenReturn(clusterState);
            threadPool,
            mock(ActionFilters.class),  
            new IndexNameExpressionResolver(threadContext),
            .settings(settings(Version.CURRENT))  
            .metadata(Metadata.builder().put(indexA1).put(indexA2))
            .numberOfReplicas(1);  
import org.opensearch.cluster.metadata.IndexMetadata;
        );
 */  
import org.opensearch.transport.TransportService;  
import org.opensearch.action.support.ActionFilters;
import org.opensearch.cluster.service.ClusterService;  
import org.opensearch.test.OpenSearchTestCase;
            null  
/*  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.gateway.TransportNodesListGatewayStartedShards;  
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
            .settings(settings(Version.CURRENT))
            .build();  
        when(threadPool.getThreadContext()).thenReturn(threadContext);  
import static org.mockito.Mockito.mock;
import org.opensearch.common.settings.Settings;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
    public void testResolveIndices() {
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
 *
    }
package org.opensearch.action.admin.indices.shards;
            .numberOfReplicas(1);
        IndexMetadata.Builder indexA2 = IndexMetadata.builder("index_b1")  
import org.opensearch.Version;
        ClusterService clusterService = mock(ClusterService.class);
import org.opensearch.cluster.ClusterName;  
import org.opensearch.common.util.concurrent.ThreadContext;
}
        assertEquals(ResolvedIndices.of("index_a1"), action.resolveIndices(new IndicesShardStoresRequest("index_a*")));  
            .numberOfShards(1)
 * compatible open source license.
            .numberOfShards(1)
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.metadata.ResolvedIndices;
        ThreadPool threadPool = mock(ThreadPool.class);
        TransportIndicesShardStoresAction action = new TransportIndicesShardStoresAction(
import org.opensearch.threadpool.ThreadPool;
            mock(TransportNodesListGatewayStartedShards.class),
            mock(TransportService.class),  
