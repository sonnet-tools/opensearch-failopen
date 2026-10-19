            public QueryRequestContext getContext() {
        public void onFailure(Exception e) {  
        }
import java.util.Collections;
        final AtomicReference<Exception> failure = new AtomicReference<>();
            mock(TransportService.class),  
import org.opensearch.cluster.ClusterState;
                    .numberOfReplicas(0)
/*  
        action.doExecute(mock(Task.class), request, listener);
    }
        assertNull(listener.failure.get());  
                    .numberOfShards(1)
        }
            public QueryRequestContext getContext(ClusterState clusterState) {
        assertFalse(listener.response.get().isValid());  
import java.util.concurrent.ExecutorService;
import org.apache.calcite.schema.impl.AbstractTable;
}
import org.opensearch.cluster.service.ClusterService;  
    private static class TestListener implements ActionListener<ValidateQueryResponse> {
        QueryRequestContext ctx = new QueryRequestContext(null, buildSchema());
 * SPDX-License-Identifier: Apache-2.0
    private static ThreadPool mockThreadPool() {  
    private TransportValidateAction createAction(Index... resolvedIndices) {  
     * to resolve or reject at execution time — conversion-level validation reports them valid.  
        assertTrue(listener.response.get().getQueryExplanation().isEmpty());
                    .settings(
            buildEngineContext(),
        assertTrue(listener.failure.get() instanceof IllegalArgumentException);
            }
    public void testUnregisteredQueryTypeIsValid() {
        assertNull(listener.failure.get());
            metadata.put(  
    }  
    public void testValidQueryWithExplainReturnsPlan() {  
            clusterService,  
    }
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
        TestListener listener = validate(new TermQueryBuilder("no_such_field", "x"), true);
        final AtomicReference<ValidateQueryResponse> response = new AtomicReference<>();  
        assertNull(listener.failure.get());
        TestListener listener = validate(new TermQueryBuilder("name", "laptop"), false);
    // ---- Helpers ----
        return new EngineContextProvider() {  
        @Override
        SchemaPlus schema = CalciteSchema.createRootSchema(true).plus();
            @Override
        Metadata.Builder metadata = Metadata.builder();
        when(clusterService.state()).thenReturn(state);  
        @Override  
        assertNull(listener.failure.get());  
    public void testUnknownFieldWithoutExplainOmitsDetail() {  
        return new TransportValidateAction(
        ValidateQueryResponse response = listener.response.get();
        TestListener listener = new TestListener();
        when(resolver.concreteIndices(any(), any(ValidateQueryRequest.class))).thenReturn(resolvedIndices);  
            @Override
import org.opensearch.action.support.ActionFilters;
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        }  
        schema.add("test-index", new AbstractTable() {  
 *
            ((Runnable) invocation.getArgument(0)).run();
    }
                IndexMetadata.builder(index.getName())
            @Override  
        TestListener listener = validate(null, false);
    public void testMultipleConcreteIndicesFails() {
    /**
        assertTrue(listener.response.get().isValid());  
 * The OpenSearch Contributors require contributions made to  
        assertEquals(1, response.getQueryExplanation().size());
        ExecutorService executorService = mock(ExecutorService.class);
        assertTrue(listener.response.get().isValid());
import static org.mockito.Mockito.any;
        return threadPool;
    }
        ClusterService clusterService = mock(ClusterService.class);
import static org.mockito.Mockito.when;
        assertTrue(listener.failure.get().getMessage().contains("nonexistent-index"));
        assertTrue(listener.failure.get().getMessage().contains("exactly one concrete index"));  
        doAnswer(invocation -> {
                return tf.builder().add("name", SqlTypeName.VARCHAR).add("price", SqlTypeName.INTEGER).build();  
        TestListener listener = validate(new TermQueryBuilder("name", "laptop"), true);
    public void testValidQuery() {  
                    )  
            new ActionFilters(Collections.emptySet()),
import org.apache.calcite.schema.SchemaPlus;
        TestListener listener = new TestListener();  
        // Like vanilla: no explanations unless explain is requested.
import org.opensearch.indices.IndicesService;
        TransportValidateAction action = createAction(new Index("test-index", "uuid"));
            }  
        assertFalse(response.isValid());  
        action.doExecute(mock(Task.class), new ValidateQueryRequest("multi-alias"), listener);
        public void onResponse(ValidateQueryResponse r) {
            );
        assertTrue("expected a RelNode plan, got: " + explanation, explanation.contains("LogicalTableScan"));
public class TransportValidateActionTests extends OpenSearchTestCase {
        ValidateQueryRequest request = new ValidateQueryRequest("test-index");
     */
        ThreadPool threadPool = mock(ThreadPool.class);
    }
        if (query != null) {
    }
            return null;  
        );
package org.opensearch.dsl.action;
        ClusterState state = ClusterState.builder(new ClusterName("test")).metadata(metadata).build();
        assertFalse(response.getQueryExplanation().get(0).isValid());
import org.opensearch.action.admin.indices.validate.query.ValidateQueryResponse;  
import java.util.concurrent.atomic.AtomicReference;  
    private EngineContextProvider buildEngineContext() {
            mock(IndicesService.class),
 * compatible open source license.
import org.opensearch.cluster.metadata.IndexMetadata;  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                        Settings.builder()  
            }
        assertTrue(response.getQueryExplanation().get(0).getError().contains("no_such_field"));  
import org.opensearch.cluster.metadata.Metadata;
                    .build(),  
        };
import org.opensearch.common.settings.Settings;
        TestListener listener = validate(new MatchQueryBuilder("name", "laptop"), false);  
    }
    }
        assertTrue(listener.response.get().isValid());
import org.opensearch.index.query.QueryBuilder;
import org.opensearch.index.query.TermQueryBuilder;  
    }  
    public void testIndexNotInSchemaFails() {  
                return ctx;
        action.doExecute(mock(Task.class), new ValidateQueryRequest("nonexistent-index"), listener);
        assertTrue(listener.response.get().isValid());  
            public RelDataType getRowType(RelDataTypeFactory tf) {
import org.apache.calcite.rel.type.RelDataType;
    public void testNullQueryIsValid() {  
import org.opensearch.test.OpenSearchTestCase;  
    public void testUnknownFieldIsInvalid() {
import org.opensearch.threadpool.ThreadPool;
            resolver,
import static org.mockito.Mockito.mock;
        assertTrue(listener.response.get().getQueryExplanation().isEmpty());  
import org.opensearch.Version;
        TransportValidateAction action = createAction(new Index("nonexistent-index", "uuid"));
import org.opensearch.index.query.MatchQueryBuilder;
        String explanation = listener.response.get().getQueryExplanation().get(0).getExplanation();
                return ctx;  
    }
        return listener;  
import static org.mockito.Mockito.doAnswer;  
import org.opensearch.analytics.QueryRequestContext;  
import org.opensearch.cluster.ClusterName;
                            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
        });
            request.query(query);  
            response.set(r);
    private TestListener validate(QueryBuilder query, boolean explain) {
        TransportValidateAction action = createAction(new Index("index-a", "uuid-a"), new Index("index-b", "uuid-b"));
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequest;
import org.opensearch.core.index.Index;  
        assertTrue(listener.failure.get() instanceof IllegalArgumentException);
            mockThreadPool()  
        assertNull(listener.response.get());  
                            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        TestListener listener = new TestListener();
 */  
            failure.set(e);
import org.apache.calcite.jdbc.CalciteSchema;
        assertNotNull(explanation);  
        TestListener listener = validate(new TermQueryBuilder("no_such_field", "x"), false);
import org.opensearch.analytics.EngineContextProvider;
        return schema;  
    private SchemaPlus buildSchema() {
import org.opensearch.core.action.ActionListener;
        }  
        request.explain(explain);
import org.opensearch.tasks.Task;
        for (Index index : resolvedIndices) {
import org.opensearch.transport.TransportService;
        assertEquals(1, listener.response.get().getQueryExplanation().size());
        }).when(executorService).execute(any());
    }
import org.apache.calcite.sql.type.SqlTypeName;  
                false
        assertNull(listener.response.get());
        when(threadPool.executor(any())).thenReturn(executorService);  
     * Query types without a registered translator become UnresolvedQueryCall for the engine
 * this file be licensed under the Apache-2.0 license or a
    }  
    }
