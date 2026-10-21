        assertNull(listener.response.get());
import org.opensearch.search.builder.SearchSourceBuilder;
    }
        assertNotNull(listener.failure.get());
    }
            buildEngineContext(),
        return schema;
            @Override
import org.apache.calcite.rel.type.RelDataTypeFactory;
    }
import org.opensearch.common.settings.Settings;
/*
            new ActionFilters(Collections.emptySet()),
            (plan, ctx, l) -> l.onResponse(Collections.emptyList()),
        ClusterService clusterService = mock(ClusterService.class);
        @Override
 *
        return threadPool;
import org.opensearch.cluster.metadata.Metadata;
        final AtomicReference<SearchResponse> response = new AtomicReference<>();
import static org.mockito.Mockito.when;
        assertTrue(listener.failure.get().getMessage().contains("exactly one concrete index"));
    private SchemaPlus buildSchema() {
import org.opensearch.cluster.ClusterState;
        ThreadPool threadPool = mock(ThreadPool.class);
        TestListener listener = executeWith(action, "test-index");
import org.opensearch.action.support.ActionFilters;
        assertNotNull(listener.failure.get());
        assertEquals(200, listener.response.get().status().getStatus());
        ClusterState state = ClusterState.builder(new ClusterName("test")).metadata(metadata).build();
        assertTrue(listener.failure.get() instanceof IndexNotFoundException);
import org.apache.calcite.jdbc.CalciteSchema;
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
        }).when(executorService).execute(any());
                    .numberOfShards(1)
            mockThreadPool()
                return ctx;
import org.opensearch.cluster.ClusterName;
        };
        public void onResponse(SearchResponse r) {
 * SPDX-License-Identifier: Apache-2.0
        request.source(new SearchSourceBuilder());
        when(resolver.concreteIndices(any(), any(SearchRequest.class))).thenReturn(resolvedIndices);
            public QueryRequestContext getContext() {
        TransportExecuteAction action = new TransportExecuteAction(
            @Override
import static org.mockito.Mockito.any;
        schema.add("test-index", new AbstractTable() {
        doAnswer(invocation -> {
import org.opensearch.analytics.EngineContextProvider;
                    .settings(
        assertNull(listener.response.get());
            (plan, ctx, l) -> l.onResponse(Collections.emptyList()),
            mock(IndicesService.class),
        });
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    }
        final AtomicReference<Exception> failure = new AtomicReference<>();
    private TransportExecuteAction createAction(Index... resolvedIndices) {
import static org.mockito.Mockito.doAnswer;
        return listener;
import org.opensearch.analytics.QueryRequestContext;
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.test.OpenSearchTestCase;
 */
        assertNull("Expected no failure but got: " + listener.failure.get(), listener.failure.get());
    public void testDoExecuteRejectsMultipleConcreteIndices() {
        assertNull(listener.response.get());
import org.opensearch.core.index.Index;
import org.opensearch.transport.TransportService;
            mock(IndicesService.class),
                return ctx;
        }
        );
import org.opensearch.action.search.SearchRequest;
        ClusterService clusterService = mock(ClusterService.class);
        when(clusterService.state()).thenReturn(state);
    }
            clusterService,
        assertTrue(listener.failure.get().getMessage().contains("nonexistent-index"));
        TransportExecuteAction action = createAction(new Index("test-index", "uuid"));
            resolver,
    private static ThreadPool mockThreadPool() {
            metadata.put(
import java.util.Collections;
                return tf.builder().add("name", SqlTypeName.VARCHAR).add("price", SqlTypeName.INTEGER).build();
        when(resolver.concreteIndices(any(), any(SearchRequest.class))).thenThrow(new IndexNotFoundException("bogus-index"));
        for (Index index : resolvedIndices) {
        TransportExecuteAction action = createAction(new Index("nonexistent-index", "uuid"));
        SearchRequest request = new SearchRequest(index);
import org.opensearch.tasks.Task;
                IndexMetadata.builder(index.getName())
        action.doExecute(mock(Task.class), request, listener);
import org.opensearch.core.action.ActionListener;
            response.set(r);
        public void onFailure(Exception e) {
        QueryRequestContext ctx = new QueryRequestContext(null, buildSchema());
        return new TransportExecuteAction(
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
        SchemaPlus schema = CalciteSchema.createRootSchema(true).plus();
import org.apache.calcite.sql.type.SqlTypeName;
        assertTrue(listener.failure.get() instanceof IllegalArgumentException);
            return null;
        assertNotNull(listener.response.get());
            }
                false
import org.apache.calcite.schema.impl.AbstractTable;
import org.opensearch.cluster.metadata.IndexMetadata;
            mock(TransportService.class),
    private TestListener executeWith(TransportExecuteAction action, String index) {
            );
import org.opensearch.indices.IndicesService;
        TransportExecuteAction action = createAction(new Index("index-a", "uuid-a"), new Index("index-b", "uuid-b"));
public class TransportExecuteActionTests extends OpenSearchTestCase {
                        Settings.builder()
    private static class TestListener implements ActionListener<SearchResponse> {
            mock(TransportService.class),
        return new EngineContextProvider() {
        );
import org.opensearch.index.IndexNotFoundException;
    private EngineContextProvider buildEngineContext() {
        }
                            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
        when(clusterService.state()).thenReturn(mock(ClusterState.class));
            mockThreadPool()
    public void testDoExecuteFailsWhenIndexNotInClusterState() {
        }
        assertTrue(listener.failure.get() instanceof IllegalArgumentException);
    }
            clusterService,
    }
        assertNotNull(listener.failure.get());
import org.opensearch.threadpool.ThreadPool;
        TestListener listener = new TestListener();
        TestListener listener = executeWith(action, "nonexistent-index");
            resolver,
        ExecutorService executorService = mock(ExecutorService.class);
        @Override
import org.apache.calcite.schema.SchemaPlus;
    }
        Metadata.Builder metadata = Metadata.builder();
import java.util.concurrent.atomic.AtomicReference;
 * The OpenSearch Contributors require contributions made to
import java.util.concurrent.ExecutorService;
            @Override
                            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            buildEngineContext(),
import static org.mockito.Mockito.mock;
 * this file be licensed under the Apache-2.0 license or a
        TestListener listener = executeWith(action, "bogus-index");
            public QueryRequestContext getContext(ClusterState clusterState) {
                    .build(),
        when(threadPool.executor(any())).thenReturn(executorService);
            }
    }
            new ActionFilters(Collections.emptySet()),
                    )
            ((Runnable) invocation.getArgument(0)).run();
import org.opensearch.Version;
}
            }
import org.opensearch.action.search.SearchResponse;
    }
package org.opensearch.dsl.action;
        TestListener listener = executeWith(action, "multi-alias");
                    .numberOfReplicas(0)
 * compatible open source license.
            public RelDataType getRowType(RelDataTypeFactory tf) {
            failure.set(e);
    public void testDoExecuteFailsWhenIndexNotInSchema() {
    public void testDoExecuteReturnsSearchResponse() {
import org.apache.calcite.rel.type.RelDataType;
