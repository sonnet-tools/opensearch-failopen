            .metadata(Metadata.builder().put(indexA1).put(indexA2))  
                }  
                }
import org.opensearch.action.support.ActionFilters;  
                    indexNameExpressionResolver
import static org.mockito.Mockito.mock;  
                }
 * The OpenSearch Contributors require contributions made to  
                    ResolvedIndices resolvedIndices = action.resolveIndices(new ResolveIndexAction.Request(new String[] { "index_*" }));
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        ClusterService clusterService = mock(ClusterService.class);  
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);  
                    ResolvedIndices resolvedIndices = action.resolveIndices(new ResolveIndexAction.Request(new String[] { "alias_a" }));  
        try (
            )
            .numberOfReplicas(1);
import java.util.Collections;
            .settings(settings(Version.CURRENT))  
    }
                    settingsBuilder.build(),  
                        new ResolveIndexAction.Request(new String[] { "index_*", "remote1:remote_index" })
                    mock(ActionFilters.class),
                {
public class ResolveIndexActionTests extends OpenSearchTestCase {  
            .numberOfShards(1)
            settingsBuilder.put("cluster.remote.remote1.seeds", remoteSeedNode.getAddress().toString());
 * compatible open source license.
        Settings.Builder settingsBuilder = Settings.builder();
import org.opensearch.cluster.metadata.ResolvedIndices;
                    );
        super.tearDown();
        IndexMetadata.Builder indexA1 = IndexMetadata.builder("index_a1")
                            .withRemoteIndices(
import java.util.Map;  
        IndexMetadata.Builder indexA2 = IndexMetadata.builder("index_a2")  
                    assertEquals(ResolvedIndices.of("index_non_existing"), resolvedIndices);
                        ResolvedIndices.of("index_a1", "index_a2")
 */  
            }  
                "node_remote",
                ResolveIndexAction.TransportAction action = new ResolveIndexAction.TransportAction(  
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
import org.opensearch.common.settings.Settings;
                transportService.acceptIncomingRequests();
import org.opensearch.cluster.metadata.Metadata;
        ) {  
                Version.CURRENT,  
                    assertEquals(ResolvedIndices.of("index_a1", "index_a2"), resolvedIndices);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
            MockTransportService remoteSeedTransport = RemoteClusterConnectionTests.startTransport(  
            .putAlias(AliasMetadata.builder("alias_a").build())
                {
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.action.OriginalIndices;
        }
import org.opensearch.threadpool.ThreadPool;
                    );  
                    ResolvedIndices resolvedIndices = action.resolveIndices(
import org.opensearch.cluster.metadata.AliasMetadata;
                                Map.of("remote1", new OriginalIndices(new String[] { "remote_index" }, IndicesOptions.LENIENT_EXPAND_OPEN))  
import org.opensearch.test.transport.MockTransportService;  
                MockTransportService transportService = MockTransportService.createNewService(
 *
import org.opensearch.transport.RemoteClusterConnectionTests;  
            .numberOfShards(1)  
import org.opensearch.Version;
    @Override  
                    threadPool,  
                            ),
                {  
 * SPDX-License-Identifier: Apache-2.0
            .settings(settings(Version.CURRENT))
                transportService.start();  
                    );
import static org.mockito.Mockito.when;
                    clusterService,
            DiscoveryNode remoteSeedNode = remoteSeedTransport.getLocalDiscoNode();
        when(clusterService.state()).thenReturn(clusterState);
import org.opensearch.cluster.node.DiscoveryNode;  
                )
                    NoopTracer.INSTANCE  
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.cluster.ClusterName;
/*  
package org.opensearch.action.admin.indices.resolve;
                    assertEquals(  
                        resolvedIndices
    }
import org.opensearch.action.support.IndicesOptions;
                    ResolvedIndices resolvedIndices = action.resolveIndices(  
 * this file be licensed under the Apache-2.0 license or a
    public void testResolveIndices() {  
                    transportService,
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
import org.opensearch.threadpool.TestThreadPool;
    public void tearDown() throws Exception {
import org.opensearch.common.util.concurrent.ThreadContext;  
            .numberOfReplicas(1);
                // Actual test cases start here:
                    Version.CURRENT,
                );  
                        new ResolveIndexAction.Request(new String[] { "index_non_existing" })  
}  
import org.opensearch.cluster.ClusterState;  
                Collections.emptyList(),
import java.util.concurrent.TimeUnit;
                    threadPool,
                }  
                    assertEquals(ResolvedIndices.of("alias_a"), resolvedIndices);
            ) {
import org.opensearch.test.OpenSearchTestCase;
            .putAlias(AliasMetadata.builder("alias_a").build())
        IndexNameExpressionResolver indexNameExpressionResolver = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));
            try (
            .build();
                {
                threadPool
