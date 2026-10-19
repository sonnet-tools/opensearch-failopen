            rexBuilder.makeLiteral(value, typeFactory.createSqlType(fieldType), true)
                    FilterTreeShape treeShape,
import org.apache.calcite.rex.RexBuilder;
        SimpleExtension.ExtensionCollection extensions;
import org.opensearch.cluster.metadata.IndexMetadata;
        // Field 2 amount: integer NOT indexed (single-viable to DF only) — used by tests
        RexNode condition = rexBuilder.makeCall(
                }
            return convertor;
        dfBackend = new StubDfBackend(convertor);
                found = expr;
    }
        public ExchangeSinkProvider getExchangeSinkProvider() {
        Thread thread = Thread.currentThread();
        // Only capabilities and fragment conversion are needed — no execution.
                SqlStdOperatorTable.OR,
                    return Set.of(EngineCapability.SORT);
import io.substrait.proto.FilterRel;
import java.util.Set;
        }, condition);
 *
import java.util.Optional;
        typeFactory = new JavaTypeFactoryImpl();
                public Optional<InstructionNode> createShardScanWithDelegationNode(
            Map.of("type", "integer", "index", true),
                return colonIndex >= 0 ? fullName.substring(0, colonIndex) : fullName;
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
            }
                }
                    String logicalTableName
        try {
        assertTrue("expression must be a scalar function", expr.hasScalarFunction());
        List<DelegatedExpression> delegatedExpressions,
import java.util.List;
import org.opensearch.analytics.planner.dag.StagePlan;
        }
    private StagePlan runPipeline(RexNode condition) {
        logger.info("Substrait plan (complex E2E):\n{}", substrait.plan());
import org.opensearch.analytics.spi.ScanCapability;
        StubDfBackend(DataFusionFragmentConvertor convertor) {
    private RexNode makeMatch(int fieldIndex, String query) {
        SqlFunctionCategory.USER_DEFINED_FUNCTION
            Map.of("type", "keyword", "index", true),
            leaf = leaf.getChildStages().getFirst();
                }
    /**
import org.opensearch.analytics.spi.ShardScanWithDelegationInstructionNode;
     * AND(amount = 200, OR(MATCH(message, 'hello'), NOT(MATCH(message, 'goodbye')))) — complex tree.
                public Set<DelegationType> supportedDelegations() {
        );
    }
                    int delegatedPredicateCount,
                }
    }
                    return;
        luceneBackend = new LuceneAnalyticsBackendPlugin(null);
import org.opensearch.analytics.spi.FilterTreeShape;
        assertEquals(
    // ---- Helpers ----
import org.opensearch.index.query.QueryBuilder;
        DelegatedExpression found = null;
                    List<DelegatedExpression> delegatedExpressions
        }
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        assertEquals("AND must have 2 arguments", 2, andFunc.getArgumentsCount());
            resolveFunctionName(plan, func.getFunctionReference())
        public FragmentConvertor getFragmentConvertor() {
 */
        return table;
import org.opensearch.analytics.spi.FragmentConvertor;
import org.opensearch.analytics.spi.InstructionNode;
     */
                @Override
            }
            assertEquals("query text for annotation " + annotationId, expectedQuery, matchQuery.value());
                public Set<FilterCapability> filterCapabilities() {
    private RexNode makeEquals(int fieldIndex, SqlTypeName fieldType, Object value) {
import org.opensearch.analytics.spi.BackendCapabilityProvider;
    @Override
            MATCH_FUNCTION,
        return clusterService;
import org.apache.calcite.plan.RelOptCluster;
    private String resolveFunctionName(Plan plan, int functionReference) {
            TYPES.addAll(FieldType.date());
import org.opensearch.cluster.routing.ShardIterator;
                        ScalarFunction.EQUALS,
            )
        );
        return rexBuilder.makeCall(
        SubstraitResult substrait = substraitResult(plan.convertedBytes());
        "MATCH",
            DelegatedPredicateFunction.NAME,
        when(indexMetadata.mapping()).thenReturn(mappingMetadata);
        IndexMetadata indexMetadata = mock(IndexMetadata.class);
        @Override
        } finally {
import static org.mockito.Mockito.when;
        for (DelegatedExpression expr : delegatedExpressions) {
/*
    ) throws IOException {
        Rel root = plan.getRelations(0).getRoot().getInput();
        QueryDAG dag = DAGBuilder.build(marked, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
        when(indexMetadata.getSettings()).thenReturn(
            "status",
import org.opensearch.analytics.spi.ScalarFunction;
    private SubstraitResult substraitResult(byte[] convertedBytes) throws Exception {
                @Override
import org.opensearch.common.settings.Settings;
        }
        }
        // Root: AND(native_equals, delegated_predicate)
            };
            "message",
        when(clusterService.operationRouting()).thenReturn(routing);
        // Field 1 message: keyword indexed (dual-viable; full-text via Lucene).
            makeEquals(2, SqlTypeName.INTEGER, 200),
        }
            rexBuilder.makeInputRef(typeFactory.createSqlType(fieldType), fieldIndex),
            };
import org.apache.calcite.plan.hep.HepPlanner;
import org.opensearch.analytics.spi.DelegatedExpression;
 * {@link LuceneAnalyticsBackendPlugin} for query serialization and the real
 * this file be licensed under the Apache-2.0 license or a
                    boolean requestsRowIds,
import org.opensearch.analytics.planner.dag.QueryDAG;
                .putList("index.composite.secondary_data_formats", "lucene")
    private static class StubDfBackend implements AnalyticsSearchBackendPlugin {
    public void testMixedNativeAndDelegated() throws Exception {
                break;
    ) {
import org.apache.calcite.rel.RelNode;
import org.opensearch.analytics.spi.DelegationType;
            "function must be delegated_predicate",
        );
import org.opensearch.analytics.spi.DelegatedPredicateFunction;
        List.of(new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchQueryBuilder.NAME, MatchQueryBuilder::new))
import io.substrait.proto.SimpleExtensionDeclaration;
    );
import java.util.function.Function;
        public BackendCapabilityProvider getCapabilityProvider() {
            MatchQueryBuilder matchQuery = (MatchQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
                public Optional<InstructionNode> createShardScanNode(boolean requestsRowIds, String logicalTableName) {
 * (marking → forking → FragmentConversionDriver → Substrait) using the real
                ) {
import io.substrait.proto.Rel;
                    return caps;
import org.opensearch.core.index.Index;
    }
    private RelOptCluster cluster;
        public String name() {
        RexNode condition = rexBuilder.makeCall(
        assertDelegatedPredicate(substrait.plan(), andFunc.getArguments(0).getValue(), 1);
            builder.add(fieldNames[index], typeFactory.createSqlType(fieldTypes[index]));
                    return Optional.of(new FilterDelegationInstructionNode(treeShape, delegatedPredicateCount, delegatedExpressions));
        }
import io.substrait.proto.Expression;
            new SqlTypeName[] { SqlTypeName.INTEGER, SqlTypeName.VARCHAR, SqlTypeName.INTEGER }
    );
        RelNode marked = PlannerImpl.runAllOptimizations(filter, context);
        Expression.ScalarFunction andFunc = substrait.filterRel().getCondition().getScalarFunction();
            extensions = DefaultExtensionCatalog.DEFAULT_COLLECTION.merge(delegationExtensions);
        null,
        assertEquals("should have 1 delegated query", 1, plan.delegatedExpressions().size());
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            Map.of("type", "integer", "index", false)
        fail("No extension function found for reference " + functionReference);
        }
 * End-to-end delegation test: MATCH predicates flow through the full pipeline
import static org.mockito.ArgumentMatchers.any;
                public Optional<InstructionNode> createPartialAggregateNode() {
        ClusterState clusterState = mock(ClusterState.class);
 * compatible open source license.
    /** Asserts the delegated query bytes for a specific annotation ID deserialize to the expected MatchQueryBuilder. */
        }
                }
                @Override
        // Load Substrait extensions with delegation_functions.yaml merged in,
                    return Optional.empty();
        when(metadata.index("test_index")).thenReturn(indexMetadata);
    private PlannerContext buildContext(
            thread.setContextClassLoader(previous);
        PlannerContext context = buildContext("parquet", fields, List.of(dfBackend, luceneBackend));
import org.opensearch.cluster.service.ClusterService;
                @Override
import org.apache.calcite.sql.type.ReturnTypes;
        StagePlan plan = runPipeline(condition);
import org.opensearch.analytics.spi.FieldType;
        super.setUp();
import org.opensearch.analytics.spi.EngineCapability;
                @Override
import org.opensearch.analytics.planner.FieldStorageResolver;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        when(clusterService.state()).thenReturn(clusterState);
            if (decl.hasExtensionFunction() && decl.getExtensionFunction().getFunctionAnchor() == functionReference) {
        ClusterService clusterService = mock(ClusterService.class);
    private static final IndexNameExpressionResolver TEST_RESOLVER = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));
import org.opensearch.analytics.spi.FragmentInstructionHandlerFactory;
    /** Resolves a function_reference to its function name from the plan's extension declarations. */
        Map<String, Map<String, Object>> fields = Map.of(
        for (SimpleExtensionDeclaration decl : plan.getExtensionsList()) {
 * {@link DataFusionFragmentConvertor} for Substrait conversion.
    /** Asserts a scalar function expression is delegated_predicate with the expected annotation ID. */
            assertEquals("field name for annotation " + annotationId, expectedField, matchQuery.fieldName());
import org.opensearch.analytics.planner.dag.FragmentConversionDriver;
                    int delegatedPredicateCount,
        return new PlannerContext(new CapabilityRegistry(backends, fieldStorageFactory), clusterState);
import org.opensearch.cluster.routing.GroupShardsIterator;
        assertEquals("should have 1 combined delegated query", 1, plan.delegatedExpressions().size());
        rexBuilder = new RexBuilder(typeFactory);
        // OR(MATCH 'hello', NOT(MATCH 'goodbye')) is combined into a single BoolQuery
            "test_index",
        assertMatchQueryBuilder(plan.delegatedExpressions(), "message", "hello world");
        List<AnalyticsSearchBackendPlugin> backends
        when(table.getQualifiedName()).thenReturn(List.of(tableName));
import java.util.HashSet;
            SimpleExtension.ExtensionCollection delegationExtensions = SimpleExtension.load(List.of("/delegation_functions.yaml"));
        static {
import io.substrait.proto.Plan;
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
            makeMatch(1, "hello world")
            return new BackendCapabilityProvider() {
    }
            rexBuilder.makeLiteral(query)
        when(routing.searchShards(any(), any(), any(), any())).thenReturn(new GroupShardsIterator<ShardIterator>(List.of()));
        );
    }
import org.apache.calcite.sql.type.SqlTypeName;
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
        Map<String, Map<String, Object>> fieldMappings,
import org.opensearch.analytics.planner.CapabilityRegistry;
                }
        ClusterState clusterState = mock(ClusterState.class);
     */
        for (int index = 0; index < fieldNames.length; index++) {
import org.apache.calcite.rel.core.TableScan;
        // that want a genuinely native predicate to avoid triggering the perf-delegation marker.
        RelOptTable table = mockTable(
 */
import org.opensearch.analytics.planner.PlannerImpl;
    @SuppressWarnings("unchecked")
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(found.getExpressionBytes()), WRITEABLE_REGISTRY)) {
        int annotationId,
        // Lightweight DF backend wrapping the real DataFusionFragmentConvertor.
import io.substrait.extension.DefaultExtensionCatalog;
import static org.mockito.Mockito.mock;
import org.opensearch.analytics.spi.ExchangeSinkProvider;
        assertNotNull("annotation ID " + annotationId + " must be in delegatedExpressions", found);
import org.apache.calcite.rex.RexNode;
        ClassLoader previous = thread.getContextClassLoader();
    private AnalyticsSearchBackendPlugin luceneBackend;
        when(mappingMetadata.sourceAsMap()).thenReturn(Map.of("properties", fieldMappings));
    private ClusterService mockClusterService() {
    }
        }
    }
     * AND(amount = 200, MATCH(message, 'hello world')) — mixed native + delegated.
        throws IOException {
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
                @Override
        Function<IndexMetadata, FieldStorageResolver> fieldStorageFactory = FieldStorageResolver::new;
    private void assertDelegatedPredicate(Plan plan, Expression expr, int expectedAnnotationId) {
    private RelDataTypeFactory typeFactory;
        );
            "amount",
                }
import org.opensearch.index.query.MatchQueryBuilder;
 * the Substrait plan structure (delegated_predicate placeholders with correct annotation IDs
import org.opensearch.analytics.spi.FilterDelegationInstructionNode;
import org.apache.calcite.plan.RelOptTable;
}
        }
 * <p>Verifies both the delegated query bytes (MatchQueryBuilder round-trip) and
                }
        );
        cluster = RelOptCluster.create(new HepPlanner(new HepProgramBuilder().build()), rexBuilder);
    }
                MatchQueryBuilder matchQuery = (MatchQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
        SubstraitResult substrait = substraitResult(plan.convertedBytes());
        // Root: AND — operand order: delegated first, native after (materializeCombined)
import org.opensearch.cluster.ClusterState;
        String primaryFormat,
            makeEquals(2, SqlTypeName.INTEGER, 200),
                int colonIndex = fullName.indexOf(':');
    private static final NamedWriteableRegistry WRITEABLE_REGISTRY = new NamedWriteableRegistry(
                rexBuilder.makeCall(SqlStdOperatorTable.NOT, makeMatch(1, "goodbye"))
public class FilterDelegationForIndexFullConversionTests extends OpenSearchTestCase {
     * amount is index=false → equals stays native; planner assigns id=0 to equals,
            SqlStdOperatorTable.EQUALS,
                @Override
        return new SubstraitResult(plan, root.getFilter());
/**
     */
     * without instantiating {@link DataFusionPlugin} (which requires native libraries).
                .build()
import org.apache.calcite.sql.type.OperandTypes;
                    return Set.of(new ScanCapability.DocValues(Set.of("parquet"), TYPES));
import java.io.IOException;
                        caps.add(new FilterCapability.Standard(op, TYPES, Set.of("parquet")));
import java.util.Map;
            new String[] { "status", "message", "amount" },
                makeMatch(1, "hello"),
    private record SubstraitResult(Plan plan, FilterRel filterRel) {
                }
    private RexBuilder rexBuilder;
    }
        Plan plan = Plan.parseFrom(convertedBytes);
        // arg[0]: delegated_predicate(1) — annotation id=1 maps to MATCH 'hello world'
     * id=1 to MATCH (delegated).
        OperationRouting routing = mock(OperationRouting.class);
            try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(expr.getExpressionBytes()), WRITEABLE_REGISTRY)) {
     * Declares the same capabilities as the real DF backend — only fragment conversion
        assertMatchQueryForAnnotation(plan.delegatedExpressions(), 1, "message", "hello world");
import io.substrait.extension.SimpleExtension;
        @Override
            TYPES.addAll(FieldType.numeric());
        for (DelegatedExpression expr : delegatedExpressions) {
        }
        DataFusionFragmentConvertor convertor = new DataFusionFragmentConvertor(extensions);
    private void assertMatchQueryBuilder(List<DelegatedExpression> delegatedExpressions, String expectedField, String expectedQuery)
            this.convertor = convertor;
        String expectedField,
        when(table.getRowType()).thenReturn(builder.build());
        logger.info("Substrait plan (mixed E2E):\n{}", substrait.plan());
        assertEquals("and", resolveFunctionName(substrait.plan(), andFunc.getFunctionReference()));
                .put("index.composite.primary_data_format", primaryFormat)
        Metadata metadata = mock(Metadata.class);
                    for (ScalarFunction op : Set.of(
        fail("No MatchQueryBuilder found with field=[" + expectedField + "], query=[" + expectedQuery + "]");
            }
     * and capability declarations are exercised, not execution.
    public void testComplexBooleanTree() throws Exception {
        RelOptTable table = mock(RelOptTable.class);
        assertEquals("annotation ID must match", expectedAnnotationId, func.getArguments(0).getValue().getLiteral().getI32());
        when(clusterState.metadata()).thenReturn(metadata);
                        ScalarFunction.LESS_THAN
import org.opensearch.analytics.planner.dag.PlanForker;
        );
                if (matchQuery.fieldName().equals(expectedField) && matchQuery.value().equals(expectedQuery)) {
import org.opensearch.analytics.spi.FilterCapability;
        Expression.ScalarFunction andFunc = substrait.filterRel().getCondition().getScalarFunction();
    }
            if (expr.getAnnotationId() == annotationId) {
            TYPES.add(FieldType.BOOLEAN);
    private RelOptTable mockTable(String tableName, String[] fieldNames, SqlTypeName[] fieldTypes) {
import org.opensearch.analytics.spi.FragmentInstructionHandler;
                }
        }
        ReturnTypes.BOOLEAN,
        private static final Set<FieldType> TYPES = new HashSet<>();
                        new ShardScanWithDelegationInstructionNode(treeShape, delegatedPredicateCount, requestsRowIds, logicalTableName)
                    return Optional.of(
        LogicalFilter filter = LogicalFilter.create(new TableScan(cluster, cluster.traitSet(), List.of(), table) {
        }
import org.apache.calcite.rel.logical.LogicalFilter;
import org.opensearch.cluster.metadata.MappingMetadata;
import org.opensearch.analytics.planner.dag.DAGBuilder;
                    return Optional.empty();
    }
                    );
        @Override
import org.opensearch.common.settings.ClusterSettings;
                public Set<EngineCapability> supportedEngineCapabilities() {
    /**
    }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import org.opensearch.be.lucene.LuceneAnalyticsBackendPlugin;
    }
        assertEquals("AND must have 2 arguments", 2, andFunc.getArgumentsCount());
                        ScalarFunction.GREATER_THAN,
                        ScalarFunction.NOT_EQUALS,
                String fullName = decl.getExtensionFunction().getName();
import org.apache.calcite.sql.SqlKind;
        // arg[0]: delegated_predicate(1) — combined OR(MATCH 'hello', NOT(MATCH 'goodbye'))
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, Set.of(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING));
import org.opensearch.common.util.concurrent.ThreadContext;
                    )) {
    private static final SqlFunction MATCH_FUNCTION = new SqlFunction(
            SqlStdOperatorTable.AND,
                public Set<ScanCapability> scanCapabilities() {
        OperandTypes.ANY,
        when(indexMetadata.getNumberOfShards()).thenReturn(2);
        assertTrue("root must be a FilterRel", root.hasFilter());
 * SPDX-License-Identifier: Apache-2.0
        return rexBuilder.makeCall(
        public FragmentInstructionHandlerFactory getInstructionHandlerFactory() {
                @Override
import org.opensearch.cluster.routing.OperationRouting;
    }
        }
import org.apache.calcite.sql.SqlFunctionCategory;
        String expectedQuery
import org.opensearch.action.search.TransportSearchAction;
                @Override
                    Set<FilterCapability> caps = new HashSet<>();
    public void setUp() throws Exception {
        StagePlan plan = runPipeline(condition);
                ) {
 * The OpenSearch Contributors require contributions made to
                    }
import org.apache.calcite.rel.type.RelDataTypeFactory;
        return null;
                public Optional<InstructionNode> createFilterDelegationNode(
import org.opensearch.analytics.planner.PlannerContext;
        return leaf.getPlanAlternatives().getFirst();
            return (context, backendContext) -> null;
     * Lightweight DF backend wrapping the real {@link DataFusionFragmentConvertor}
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
        assertDelegatedPredicate(substrait.plan(), andFunc.getArguments(0).getValue(), 1);
        while (!leaf.getChildStages().isEmpty()) {
        MappingMetadata mappingMetadata = mock(MappingMetadata.class);
package org.opensearch.be.datafusion;
                }
            rexBuilder.makeCall(
import org.opensearch.test.OpenSearchTestCase;
                    return Set.of(DelegationType.FILTER);
        private final DataFusionFragmentConvertor convertor;
            return new FragmentInstructionHandlerFactory() {
        Stage leaf = dag.rootStage();
            return "mock-parquet";
import org.opensearch.analytics.spi.ShardScanInstructionNode;
     * amount is index=false → equals stays native; planner assigns id=0 to equals,
        SqlKind.OTHER_FUNCTION,
            TYPES.addAll(FieldType.keyword());
        @Override
                    FilterTreeShape treeShape,
            SqlStdOperatorTable.AND,
 * and preserved AND/OR/NOT boolean structure).
import org.opensearch.analytics.planner.dag.Stage;
    /** Default resolver for DAGBuilder in tests; production injects core's resolver. */
    // ---- Pipeline ----
        RelDataTypeFactory.Builder builder = typeFactory.builder();
                    throw new UnsupportedOperationException("stub");
                public FragmentInstructionHandler<?> createHandler(InstructionNode node) {
        // Field 0 status: integer indexed (dual-viable for Lucene + DF).
        assertEquals("and", resolveFunctionName(substrait.plan(), andFunc.getFunctionReference()));
        );
import org.opensearch.cluster.metadata.Metadata;
        when(indexMetadata.getIndex()).thenReturn(new Index("test_index", "uuid"));
        @Override
    }
                public Optional<InstructionNode> createFinalAggregateNode() {
            Settings.builder()
 *
import org.apache.calcite.sql.SqlFunction;
                @Override
    private AnalyticsSearchBackendPlugin dfBackend;
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), fieldIndex),
     * id=1 to first MATCH, id=2 to second MATCH.
import org.apache.calcite.plan.hep.HepProgramBuilder;
        // Avoids instantiating DataFusionPlugin which requires native libraries.
        Expression.ScalarFunction func = expr.getScalarFunction();
import org.opensearch.core.common.io.stream.StreamInput;
    private void assertMatchQueryForAnnotation(
        // same as DataFusionPlugin.loadSubstraitExtensions() does at startup.
                    return Optional.of(new ShardScanInstructionNode(requestsRowIds, logicalTableName));
    /**
