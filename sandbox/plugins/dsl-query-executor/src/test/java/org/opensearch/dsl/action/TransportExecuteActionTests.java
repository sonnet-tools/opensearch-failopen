        return threadPool;
        assertNotNull(listener.failure.get());
    public void testDoExecuteFailsWhenIndexNotInSchema() {  
    }  
    }  
import org.apache.calcite.schema.SchemaPlus;
    public void testDoExecuteFailsWhenIndexNotInClusterState() {
            return null;  
    }  
        }
        when(clusterService.state()).thenReturn(mock(ClusterState.class));  
                IndexMetadata.builder(index.getName())  
            resolver,  
            new ActionFilters(Collections.emptySet()),  
import org.opensearch.test.OpenSearchTestCase;
        when(resolver.concreteIndices(any(), any(SearchRequest.class))).thenThrow(new IndexNotFoundException("bogus-index"));  
                            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            clusterService,  
            }  
    private TestListener executeWith(TransportExecuteAction action, String index) {
package org.opensearch.dsl.action;
import org.opensearch.action.search.SearchRequest;
        return new TransportExecuteAction(
            public QueryRequestContext getContext(ClusterState clusterState) {
        SearchRequest request = new SearchRequest(index);  
                        Settings.builder()
import org.opensearch.indices.IndicesService;
            new ActionFilters(Collections.emptySet()),
        schema.add("test-index", new AbstractTable() {  
        action.doExecute(mock(Task.class), request, listener);
        assertTrue(listener.failure.get() instanceof IllegalArgumentException);
import org.apache.calcite.jdbc.CalciteSchema;
            buildEngineContext(),
import org.apache.calcite.sql.type.SqlTypeName;  
            public RelDataType getRowType(RelDataTypeFactory tf) {
        };
    private TransportExecuteAction createAction(Index... resolvedIndices) {
import org.opensearch.core.index.Index;  
            resolver,
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
import static org.mockito.Mockito.when;
import org.apache.calcite.rel.type.RelDataTypeFactory;  
            @Override
    public void testDoExecuteReturnsSearchResponse() {
        @Override  
        TransportExecuteAction action = createAction(new Index("test-index", "uuid"));  
            buildEngineContext(),
        return listener;
        TestListener listener = new TestListener();  
                return ctx;  
        ClusterService clusterService = mock(ClusterService.class);
public class TransportExecuteActionTests extends OpenSearchTestCase {  
        TransportExecuteAction action = createAction(new Index("index-a", "uuid-a"), new Index("index-b", "uuid-b"));  
        for (Index index : resolvedIndices) {
        assertTrue(listener.failure.get().getMessage().contains("exactly one concrete index"));
        });
        return schema;  
 */  
import org.opensearch.analytics.EngineContextProvider;
    }  
        when(clusterService.state()).thenReturn(state);
        TestListener listener = executeWith(action, "multi-alias");
            clusterService,
import static org.mockito.Mockito.mock;  
        assertNotNull(listener.response.get());
 * The OpenSearch Contributors require contributions made to  
    private EngineContextProvider buildEngineContext() {
import org.opensearch.analytics.QueryRequestContext;  
            @Override  
        TestListener listener = executeWith(action, "bogus-index");
        when(threadPool.executor(any())).thenReturn(executorService);  
            (plan, ctx, l) -> l.onResponse(Collections.emptyList()),
                false  
            mock(IndicesService.class),
import org.opensearch.search.builder.SearchSourceBuilder;  
            }
        final AtomicReference<Exception> failure = new AtomicReference<>();
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
        Metadata.Builder metadata = Metadata.builder();  
 * this file be licensed under the Apache-2.0 license or a
    }
        assertNull(listener.response.get());  
import static org.mockito.Mockito.doAnswer;
                    .settings(
import java.util.concurrent.ExecutorService;
        TestListener listener = executeWith(action, "test-index");
        public void onFailure(Exception e) {  
    private SchemaPlus buildSchema() {
        assertNotNull(listener.failure.get());  
    private static class TestListener implements ActionListener<SearchResponse> {
        ClusterService clusterService = mock(ClusterService.class);
import org.opensearch.Version;
        );
            (plan, ctx, l) -> l.onResponse(Collections.emptyList()),  
            ((Runnable) invocation.getArgument(0)).run();
        assertEquals(200, listener.response.get().status().getStatus());  
                    .build(),
        assertNotNull(listener.failure.get());
    }  
        public void onResponse(SearchResponse r) {
        ClusterState state = ClusterState.builder(new ClusterName("test")).metadata(metadata).build();  
                            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
    }
        final AtomicReference<SearchResponse> response = new AtomicReference<>();  
            mock(TransportService.class),  
        assertTrue(listener.failure.get() instanceof IllegalArgumentException);  
            public QueryRequestContext getContext() {
        }  
            mockThreadPool()
        return new EngineContextProvider() {  
import static org.mockito.Mockito.any;
import org.opensearch.tasks.Task;
import java.util.concurrent.atomic.AtomicReference;
import org.opensearch.core.action.ActionListener;
    private static ThreadPool mockThreadPool() {  
        ExecutorService executorService = mock(ExecutorService.class);
    }
            mock(IndicesService.class),
        }
        request.source(new SearchSourceBuilder());
        assertTrue(listener.failure.get().getMessage().contains("nonexistent-index"));
        assertTrue(listener.failure.get() instanceof IndexNotFoundException);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.common.settings.Settings;
        when(resolver.concreteIndices(any(), any(SearchRequest.class))).thenReturn(resolvedIndices);
import org.opensearch.cluster.metadata.Metadata;
                    )
            response.set(r);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.metadata.IndexMetadata;  
        SchemaPlus schema = CalciteSchema.createRootSchema(true).plus();
    }
import org.opensearch.action.search.SearchResponse;  
                return ctx;
import org.opensearch.transport.TransportService;
            }
        }).when(executorService).execute(any());
import org.opensearch.index.IndexNotFoundException;
import org.opensearch.cluster.ClusterName;
    }
        QueryRequestContext ctx = new QueryRequestContext(null, buildSchema());
        TransportExecuteAction action = createAction(new Index("nonexistent-index", "uuid"));
        assertNull(listener.response.get());
    public void testDoExecuteRejectsMultipleConcreteIndices() {
        assertNull("Expected no failure but got: " + listener.failure.get(), listener.failure.get());
                return tf.builder().add("name", SqlTypeName.VARCHAR).add("price", SqlTypeName.INTEGER).build();  
        doAnswer(invocation -> {
        @Override
import org.apache.calcite.schema.impl.AbstractTable;
        );
            metadata.put(
import java.util.Collections;  
 *
import org.opensearch.cluster.service.ClusterService;  
import org.apache.calcite.rel.type.RelDataType;
        TestListener listener = executeWith(action, "nonexistent-index");  
            mock(TransportService.class),
import org.opensearch.threadpool.ThreadPool;  
/*  
        TransportExecuteAction action = new TransportExecuteAction(
import org.opensearch.cluster.ClusterState;
}
                    .numberOfShards(1)  
import org.opensearch.action.support.ActionFilters;
            failure.set(e);
            mockThreadPool()  
            );
                    .numberOfReplicas(0)
 * compatible open source license.
            @Override
        assertNull(listener.response.get());
        ThreadPool threadPool = mock(ThreadPool.class);
