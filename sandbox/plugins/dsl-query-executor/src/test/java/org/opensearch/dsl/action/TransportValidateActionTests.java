    }
        assertNull(listener.response.get());
                IndexMetadata.builder(index.getName())
        assertFalse(response.getQueryExplanation().get(0).isValid());
            @Override
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequest;
        assertNull(listener.failure.get());
        when(clusterService.state()).thenReturn(state);
        assertTrue(listener.response.get().isValid());
                    .numberOfReplicas(0)
        TestListener listener = validate(new TermQueryBuilder("name", "laptop"), true);
                    .numberOfShards(1)
    }
    private SchemaPlus buildSchema() {
        assertTrue(listener.failure.get().getMessage().contains("nonexistent-index"));
        QueryRequestContext ctx = new QueryRequestContext(null, buildSchema());
import org.opensearch.index.query.TermQueryBuilder;
 *
        final AtomicReference<Exception> failure = new AtomicReference<>();
        assertNull(listener.response.get());
        };
    public void testMultipleConcreteIndicesFails() {
import org.opensearch.common.settings.Settings;
        @Override
import org.opensearch.test.OpenSearchTestCase;
        return new EngineContextProvider() {
    private static ThreadPool mockThreadPool() {
import org.opensearch.index.query.MatchQueryBuilder;
        return listener;
        ClusterService clusterService = mock(ClusterService.class);
                    .build(),
            resolver,
        assertNotNull(explanation);
package org.opensearch.dsl.action;
        when(resolver.concreteIndices(any(), any(ValidateQueryRequest.class))).thenReturn(resolvedIndices);
        @Override
import org.opensearch.cluster.ClusterName;
        assertEquals(1, listener.response.get().getQueryExplanation().size());
import static org.mockito.Mockito.when;
        });
    public void testUnregisteredQueryTypeIsValid() {
        assertFalse(listener.response.get().isValid());
        assertTrue(listener.response.get().isValid());
        Metadata.Builder metadata = Metadata.builder();
            mock(IndicesService.class),
import org.opensearch.index.query.QueryBuilder;
    }
            public QueryRequestContext getContext() {
        final AtomicReference<ValidateQueryResponse> response = new AtomicReference<>();
        ThreadPool threadPool = mock(ThreadPool.class);
        );
        }
    public void testUnknownFieldWithoutExplainOmitsDetail() {
import static org.mockito.Mockito.mock;
 * The OpenSearch Contributors require contributions made to
    public void testIndexNotInSchemaFails() {
import java.util.Collections;
    private TestListener validate(QueryBuilder query, boolean explain) {
import static org.mockito.Mockito.any;
        schema.add("test-index", new AbstractTable() {
    // ---- Helpers ----
            mock(TransportService.class),
     * to resolve or reject at execution time — conversion-level validation reports them valid.
        when(threadPool.executor(any())).thenReturn(executorService);
    }
        action.doExecute(mock(Task.class), new ValidateQueryRequest("multi-alias"), listener);
}
        }).when(executorService).execute(any());
import org.opensearch.Version;
    public void testValidQueryWithExplainReturnsPlan() {
 * compatible open source license.
                    .settings(
        public void onFailure(Exception e) {
import org.opensearch.action.support.ActionFilters;
        assertTrue(listener.response.get().isValid());
            failure.set(e);
    public void testNullQueryIsValid() {
import static org.mockito.Mockito.doAnswer;
                            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        }
        }
            }
    }
        assertTrue(listener.failure.get() instanceof IllegalArgumentException);
     * Query types without a registered translator become UnresolvedQueryCall for the engine
        TestListener listener = validate(null, false);
        }
            }
    }
        // Like vanilla: no explanations unless explain is requested.
            new ActionFilters(Collections.emptySet()),
    private TransportValidateAction createAction(Index... resolvedIndices) {
        for (Index index : resolvedIndices) {
        TestListener listener = new TestListener();
import org.opensearch.core.action.ActionListener;
/*
        return schema;
            return null;
        assertTrue("expected a RelNode plan, got: " + explanation, explanation.contains("LogicalTableScan"));
        assertNull(listener.failure.get());
        assertNull(listener.failure.get());
        TestListener listener = validate(new TermQueryBuilder("name", "laptop"), false);
import org.opensearch.cluster.metadata.Metadata;
    }
        ValidateQueryRequest request = new ValidateQueryRequest("test-index");
import org.opensearch.cluster.service.ClusterService;
    private EngineContextProvider buildEngineContext() {
import org.opensearch.analytics.EngineContextProvider;
    }
        String explanation = listener.response.get().getQueryExplanation().get(0).getExplanation();
        assertTrue(listener.failure.get() instanceof IllegalArgumentException);
        assertTrue(listener.response.get().isValid());
        action.doExecute(mock(Task.class), new ValidateQueryRequest("nonexistent-index"), listener);
        assertTrue(listener.response.get().getQueryExplanation().isEmpty());
        assertEquals(1, response.getQueryExplanation().size());
        public void onResponse(ValidateQueryResponse r) {
import java.util.concurrent.atomic.AtomicReference;
    private static class TestListener implements ActionListener<ValidateQueryResponse> {
            @Override
    }
                return tf.builder().add("name", SqlTypeName.VARCHAR).add("price", SqlTypeName.INTEGER).build();
            ((Runnable) invocation.getArgument(0)).run();
        assertFalse(response.isValid());
        TestListener listener = validate(new TermQueryBuilder("no_such_field", "x"), false);
 * this file be licensed under the Apache-2.0 license or a
            request.query(query);
        TestListener listener = new TestListener();
import org.opensearch.tasks.Task;
        request.explain(explain);
import org.apache.calcite.jdbc.CalciteSchema;
import org.opensearch.cluster.metadata.IndexMetadata;
    public void testUnknownFieldIsInvalid() {
        TestListener listener = validate(new MatchQueryBuilder("name", "laptop"), false);
    }
import org.apache.calcite.sql.type.SqlTypeName;
import org.opensearch.indices.IndicesService;
        assertTrue(response.getQueryExplanation().get(0).getError().contains("no_such_field"));
        doAnswer(invocation -> {
        assertTrue(listener.response.get().getQueryExplanation().isEmpty());
import org.opensearch.analytics.QueryRequestContext;
    /**
                return ctx;
import org.opensearch.action.admin.indices.validate.query.ValidateQueryResponse;
            }
            public QueryRequestContext getContext(ClusterState clusterState) {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.threadpool.ThreadPool;
        assertTrue(listener.failure.get().getMessage().contains("exactly one concrete index"));
import org.apache.calcite.schema.SchemaPlus;
        TransportValidateAction action = createAction(new Index("test-index", "uuid"));
    }
        ExecutorService executorService = mock(ExecutorService.class);
        ValidateQueryResponse response = listener.response.get();
                false
    }
        ClusterState state = ClusterState.builder(new ClusterName("test")).metadata(metadata).build();
    }
            );
    public void testValidQuery() {
            metadata.put(
import java.util.concurrent.ExecutorService;
public class TransportValidateActionTests extends OpenSearchTestCase {
 */
import org.opensearch.cluster.ClusterState;
        return threadPool;
                    )
        TransportValidateAction action = createAction(new Index("index-a", "uuid-a"), new Index("index-b", "uuid-b"));
            mockThreadPool()
        TestListener listener = validate(new TermQueryBuilder("no_such_field", "x"), true);
            response.set(r);
import org.apache.calcite.schema.impl.AbstractTable;
            buildEngineContext(),
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
        action.doExecute(mock(Task.class), request, listener);
            clusterService,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                return ctx;
import org.opensearch.core.index.Index;
                            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
        if (query != null) {
import org.opensearch.transport.TransportService;
        TransportValidateAction action = createAction(new Index("nonexistent-index", "uuid"));
    }
     */
            public RelDataType getRowType(RelDataTypeFactory tf) {
            @Override
        assertNull(listener.failure.get());
                        Settings.builder()
import org.apache.calcite.rel.type.RelDataTypeFactory;
        SchemaPlus schema = CalciteSchema.createRootSchema(true).plus();
        TestListener listener = new TestListener();
import org.apache.calcite.rel.type.RelDataType;
        return new TransportValidateAction(
