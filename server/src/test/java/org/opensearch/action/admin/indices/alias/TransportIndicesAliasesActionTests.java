import org.opensearch.action.admin.indices.delete.DeleteIndexAction;  
            mock(MetadataIndexAliasesService.class),
        assertEquals(  
        );
    public void testResolvedIndices_addAliasAction() {  
/*  
import org.opensearch.Version;
 * The OpenSearch Contributors require contributions made to  
        this.clusterService = mock(ClusterService.class);
import org.opensearch.cluster.service.ClusterService;
        );  
        threadPool = new TestThreadPool(getTestClass().getName());  
 *
import org.opensearch.threadpool.TestThreadPool;  
            resolvedIndices  
import org.opensearch.cluster.metadata.AliasMetadata;
            new IndicesAliasesRequest().addAliasAction(IndicesAliasesRequest.AliasActions.removeIndex().index("index_a*"))
    private TransportIndicesAliasesAction subject;
import org.opensearch.cluster.ClusterState;  
            .put(indexBuilder("index_a2").putAlias(AliasMetadata.builder("alias_a")))
    public void testResolvedIndices_removeIndexAction() {
            clusterService,  
            .put(indexBuilder("index_b2"));  
import org.opensearch.action.RequestValidators;
}
            new RequestValidators<>(List.of())
    @AfterClass  
            mock(ActionFilters.class),  
            new IndicesAliasesRequest().addAliasAction(IndicesAliasesRequest.AliasActions.remove().index("index_a*").alias("alias_*"))  
    public void testResolvedIndices_removeAliasAction() {
import static org.mockito.Mockito.when;  
        return IndexMetadata.builder(index)
        ResolvedIndices resolvedIndices = subject.resolveIndices(
import org.opensearch.cluster.metadata.IndexMetadata;
    private static ThreadPool threadPool;  
import org.opensearch.cluster.metadata.MetadataIndexAliasesService;
import org.opensearch.transport.TransportService;
                .withLocalSubActions(DeleteIndexAction.INSTANCE, ResolvedIndices.Local.of("index_a1", "index_a2")),
    }
import org.opensearch.cluster.metadata.Metadata;
        super.setUp();  
    private static IndexMetadata.Builder indexBuilder(String index) {
    private ClusterService clusterService;
    }
 */  
        );  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        ResolvedIndices resolvedIndices = subject.resolveIndices(  
            .put(indexBuilder("index_a1").putAlias(AliasMetadata.builder("alias_a")))  
import org.opensearch.cluster.metadata.ResolvedIndices;  
            );
        );
 * this file be licensed under the Apache-2.0 license or a
            mock(TransportService.class),
 * compatible open source license.
public class TransportIndicesAliasesActionTests extends OpenSearchTestCase {
            new IndexNameExpressionResolver(threadPool.getThreadContext()),
import org.junit.Before;
            threadPool,
import org.opensearch.action.support.ActionFilters;
        threadPool = null;  
    }  
    @Before
        Metadata.Builder mdBuilder = Metadata.builder()
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(ResolvedIndices.of("index_a1", "index_a2", "alias_a"), resolvedIndices);
    }
    public static void beforeClass() {
    }
        this.subject = new TransportIndicesAliasesAction(
    }  
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
    @Override  
                settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import java.util.concurrent.TimeUnit;  
            .put(indexBuilder("index_b1"))
        ResolvedIndices resolvedIndices = subject.resolveIndices(
        assertEquals(ResolvedIndices.of("index_b1", "index_b2", "alias_b"), resolvedIndices);
import static org.mockito.Mockito.mock;
 * SPDX-License-Identifier: Apache-2.0
import java.util.Collections;
import java.util.List;
            ResolvedIndices.of(Collections.emptyList())
            new IndicesAliasesRequest().addAliasAction(IndicesAliasesRequest.AliasActions.add().index("index_b*").alias("alias_b"))
package org.opensearch.action.admin.indices.alias;
        when(clusterService.state()).thenReturn(clusterState);
import org.opensearch.threadpool.ThreadPool;
    public static void afterClass() {
import org.junit.AfterClass;  
import org.junit.BeforeClass;
    }
    public void setUp() throws Exception {
            .settings(  
        );
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
    @BeforeClass
import org.opensearch.cluster.ClusterName;
