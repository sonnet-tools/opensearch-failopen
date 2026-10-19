import org.opensearch.analytics.spi.DelegatedPredicateFunction;  
                }  
        StagePlan plan = runPipeline(condition);
        ClassLoader previous = thread.getContextClassLoader();
                    return Optional.empty();
 * End-to-end delegation test: MATCH predicates flow through the full pipeline
        }, condition);
    ) throws IOException {  
        // same as DataFusionPlugin.loadSubstraitExtensions() does at startup.  
        @Override  
                String fullName = decl.getExtensionFunction().getName();  
import org.opensearch.cluster.service.ClusterService;
import org.apache.calcite.plan.RelOptTable;  
import org.opensearch.analytics.spi.FragmentInstructionHandler;  
import org.opensearch.analytics.spi.FilterDelegationInstructionNode;  
import io.substrait.proto.SimpleExtensionDeclaration;  
    private StagePlan runPipeline(RexNode condition) {
import io.substrait.proto.Plan;
                }  
            SqlStdOperatorTable.AND,
    @SuppressWarnings("unchecked")
        String expectedQuery
            return new FragmentInstructionHandlerFactory() {
 *
        }  
        assertEquals("AND must have 2 arguments", 2, andFunc.getArgumentsCount());
        RexNode condition = rexBuilder.makeCall(
 */  
 * (marking → forking → FragmentConversionDriver → Substrait) using the real
 * <p>Verifies both the delegated query bytes (MatchQueryBuilder round-trip) and  
 *
        public FragmentConvertor getFragmentConvertor() {
import org.opensearch.action.search.TransportSearchAction;
import io.substrait.extension.DefaultExtensionCatalog;  
                .build()  
import org.apache.calcite.sql.SqlFunction;  
        private final DataFusionFragmentConvertor convertor;
                public Optional<InstructionNode> createShardScanWithDelegationNode(  
import io.substrait.proto.FilterRel;  
        when(metadata.index("test_index")).thenReturn(indexMetadata);
import org.opensearch.analytics.planner.FieldStorageResolver;  
    private static class StubDfBackend implements AnalyticsSearchBackendPlugin {
            "amount",  
import java.util.HashSet;
import org.opensearch.analytics.spi.EngineCapability;
            rexBuilder.makeInputRef(typeFactory.createSqlType(fieldType), fieldIndex),
        QueryDAG dag = DAGBuilder.build(marked, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
        @Override
        ReturnTypes.BOOLEAN,  
        Map<String, Map<String, Object>> fields = Map.of(
                    return Optional.of(new FilterDelegationInstructionNode(treeShape, delegatedPredicateCount, delegatedExpressions));
                break;
                    return Optional.empty();  
import org.opensearch.test.OpenSearchTestCase;
            DelegatedPredicateFunction.NAME,  
import org.opensearch.be.lucene.LuceneAnalyticsBackendPlugin;
        RexNode condition = rexBuilder.makeCall(
        Map<String, Map<String, Object>> fieldMappings,
 * and preserved AND/OR/NOT boolean structure).
        when(indexMetadata.mapping()).thenReturn(mappingMetadata);
        luceneBackend = new LuceneAnalyticsBackendPlugin(null);
                        ScalarFunction.LESS_THAN  
import org.opensearch.analytics.spi.BackendCapabilityProvider;
import io.substrait.proto.Rel;
        assertDelegatedPredicate(substrait.plan(), andFunc.getArguments(0).getValue(), 1);  
                ) {
    }  
    /** Default resolver for DAGBuilder in tests; production injects core's resolver. */  
/*  
    private RelOptTable mockTable(String tableName, String[] fieldNames, SqlTypeName[] fieldTypes) {  
 */  
        List.of(new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchQueryBuilder.NAME, MatchQueryBuilder::new))
        PlannerContext context = buildContext("parquet", fields, List.of(dfBackend, luceneBackend));  
import org.opensearch.cluster.routing.ShardIterator;  
    private static final IndexNameExpressionResolver TEST_RESOLVER = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));
                public Set<EngineCapability> supportedEngineCapabilities() {
import org.opensearch.analytics.spi.ShardScanInstructionNode;
        @Override
        Rel root = plan.getRelations(0).getRoot().getInput();  
            return convertor;  
        );
        SqlKind.OTHER_FUNCTION,
            try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(expr.getExpressionBytes()), WRITEABLE_REGISTRY)) {  
        }  
    public void testMixedNativeAndDelegated() throws Exception {  
                        ScalarFunction.EQUALS,  
import org.apache.calcite.sql.SqlKind;
        return null;  
                public Optional<InstructionNode> createFilterDelegationNode(  
            Settings.builder()  
            }
        // Lightweight DF backend wrapping the real DataFusionFragmentConvertor.
}
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamInput;
import org.apache.calcite.plan.hep.HepPlanner;
        typeFactory = new JavaTypeFactoryImpl();
        }
import org.opensearch.analytics.planner.dag.QueryDAG;  
        assertEquals("and", resolveFunctionName(substrait.plan(), andFunc.getFunctionReference()));
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
                        ScalarFunction.GREATER_THAN,
import org.apache.calcite.plan.hep.HepProgramBuilder;
            };
        logger.info("Substrait plan (mixed E2E):\n{}", substrait.plan());  
            new String[] { "status", "message", "amount" },  
                @Override
import org.opensearch.analytics.spi.FieldType;
        return rexBuilder.makeCall(  
     */
import org.opensearch.cluster.routing.OperationRouting;
        return leaf.getPlanAlternatives().getFirst();  
        }  
    }
        );
    private AnalyticsSearchBackendPlugin dfBackend;
public class FilterDelegationForIndexFullConversionTests extends OpenSearchTestCase {
    }
            };
import org.apache.calcite.rel.RelNode;  
        SqlFunctionCategory.USER_DEFINED_FUNCTION  
    /**
import java.util.Optional;
                @Override  
                    FilterTreeShape treeShape,
                        ScalarFunction.NOT_EQUALS,
    /**
                    int delegatedPredicateCount,
        SubstraitResult substrait = substraitResult(plan.convertedBytes());
        RelDataTypeFactory.Builder builder = typeFactory.builder();
                }  
    private void assertMatchQueryForAnnotation(
        );  
            rexBuilder.makeLiteral(value, typeFactory.createSqlType(fieldType), true)  
        );
        String primaryFormat,  
    // ---- Helpers ----  
        StagePlan plan = runPipeline(condition);  
import org.opensearch.analytics.planner.dag.StagePlan;
import org.opensearch.analytics.spi.ShardScanWithDelegationInstructionNode;  
        }
        public ExchangeSinkProvider getExchangeSinkProvider() {  
                    String logicalTableName
    }
        try {
    }
                        caps.add(new FilterCapability.Standard(op, TYPES, Set.of("parquet")));
    private RexBuilder rexBuilder;
        assertMatchQueryBuilder(plan.delegatedExpressions(), "message", "hello world");  
        while (!leaf.getChildStages().isEmpty()) {  
        logger.info("Substrait plan (complex E2E):\n{}", substrait.plan());
        // Field 0 status: integer indexed (dual-viable for Lucene + DF).  
        Expression.ScalarFunction andFunc = substrait.filterRel().getCondition().getScalarFunction();
    private static final SqlFunction MATCH_FUNCTION = new SqlFunction(  
 * this file be licensed under the Apache-2.0 license or a
    }
        assertEquals("and", resolveFunctionName(substrait.plan(), andFunc.getFunctionReference()));  
import org.apache.calcite.sql.type.SqlTypeName;  
        );
                    return caps;
        assertEquals("should have 1 delegated query", 1, plan.delegatedExpressions().size());
                }
            makeEquals(2, SqlTypeName.INTEGER, 200),  
            assertEquals("field name for annotation " + annotationId, expectedField, matchQuery.fieldName());
        );
                @Override
        // that want a genuinely native predicate to avoid triggering the perf-delegation marker.  
    /** Asserts the delegated query bytes for a specific annotation ID deserialize to the expected MatchQueryBuilder. */  
                    return Optional.of(  
            Map.of("type", "integer", "index", false)
            return new BackendCapabilityProvider() {  
        fail("No extension function found for reference " + functionReference);
        DataFusionFragmentConvertor convertor = new DataFusionFragmentConvertor(extensions);
                    return Optional.of(new ShardScanInstructionNode(requestsRowIds, logicalTableName));
import org.opensearch.analytics.spi.FragmentInstructionHandlerFactory;
    );
    /** Asserts a scalar function expression is delegated_predicate with the expected annotation ID. */  
                @Override  
                    return Set.of(new ScanCapability.DocValues(Set.of("parquet"), TYPES));
        } finally {
import org.opensearch.analytics.planner.PlannerContext;
        return rexBuilder.makeCall(
                    int delegatedPredicateCount,
import org.opensearch.cluster.routing.GroupShardsIterator;
    private SubstraitResult substraitResult(byte[] convertedBytes) throws Exception {
import static org.mockito.ArgumentMatchers.any;
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
            makeMatch(1, "hello world")
import org.apache.calcite.rex.RexBuilder;
        assertTrue("expression must be a scalar function", expr.hasScalarFunction());
import org.apache.calcite.plan.RelOptCluster;
                public Optional<InstructionNode> createPartialAggregateNode() {  
            "test_index",
    private String resolveFunctionName(Plan plan, int functionReference) {  
                    throw new UnsupportedOperationException("stub");
        return new SubstraitResult(plan, root.getFilter());
                @Override
                }
import org.apache.calcite.rel.core.TableScan;
            Map.of("type", "keyword", "index", true),
    }  
        // Root: AND(native_equals, delegated_predicate)  
        RelOptTable table = mock(RelOptTable.class);
    @Override
                @Override
    private ClusterService mockClusterService() {
import org.opensearch.analytics.planner.dag.FragmentConversionDriver;
        DelegatedExpression found = null;
                @Override  
        when(table.getQualifiedName()).thenReturn(List.of(tableName));  
import org.opensearch.analytics.spi.ExchangeSinkProvider;  
        }  
            TYPES.addAll(FieldType.numeric());
            TYPES.add(FieldType.BOOLEAN);
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());  
import org.opensearch.analytics.spi.InstructionNode;
    }
import org.apache.calcite.sql.type.OperandTypes;
        assertEquals("AND must have 2 arguments", 2, andFunc.getArgumentsCount());  
                .putList("index.composite.secondary_data_formats", "lucene")
        assertDelegatedPredicate(substrait.plan(), andFunc.getArguments(0).getValue(), 1);  
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;  
        when(routing.searchShards(any(), any(), any(), any())).thenReturn(new GroupShardsIterator<ShardIterator>(List.of()));
    ) {  
    }  
import org.opensearch.analytics.spi.ScanCapability;
        LogicalFilter filter = LogicalFilter.create(new TableScan(cluster, cluster.traitSet(), List.of(), table) {  
import java.util.Map;
    /**
                public Set<DelegationType> supportedDelegations() {
import org.opensearch.cluster.ClusterState;
        assertEquals("annotation ID must match", expectedAnnotationId, func.getArguments(0).getValue().getLiteral().getI32());  
        static {
import org.opensearch.analytics.spi.FilterTreeShape;
            if (expr.getAnnotationId() == annotationId) {  
            return "mock-parquet";
        "MATCH",
        // arg[0]: delegated_predicate(1) — combined OR(MATCH 'hello', NOT(MATCH 'goodbye'))
    /** Resolves a function_reference to its function name from the plan's extension declarations. */
        // Avoids instantiating DataFusionPlugin which requires native libraries.  
import org.opensearch.analytics.spi.FragmentConvertor;
import org.apache.calcite.rel.type.RelDataTypeFactory;  
                rexBuilder.makeCall(SqlStdOperatorTable.NOT, makeMatch(1, "goodbye"))
import org.opensearch.analytics.planner.PlannerImpl;
        ClusterState clusterState = mock(ClusterState.class);
package org.opensearch.be.datafusion;
/**  
        when(indexMetadata.getIndex()).thenReturn(new Index("test_index", "uuid"));
import org.opensearch.cluster.metadata.Metadata;  
        public FragmentInstructionHandlerFactory getInstructionHandlerFactory() {
                    return Set.of(DelegationType.FILTER);  
            return (context, backendContext) -> null;
        when(clusterService.operationRouting()).thenReturn(routing);
                @Override
                SqlStdOperatorTable.OR,
     * AND(amount = 200, MATCH(message, 'hello world')) — mixed native + delegated.
                if (matchQuery.fieldName().equals(expectedField) && matchQuery.value().equals(expectedQuery)) {
        when(indexMetadata.getNumberOfShards()).thenReturn(2);  
        dfBackend = new StubDfBackend(convertor);  
    }
            if (decl.hasExtensionFunction() && decl.getExtensionFunction().getFunctionAnchor() == functionReference) {
    private static final NamedWriteableRegistry WRITEABLE_REGISTRY = new NamedWriteableRegistry(  
import java.util.Set;  
    private RelOptCluster cluster;  
            rexBuilder.makeCall(
import org.opensearch.analytics.planner.dag.DAGBuilder;  
    private record SubstraitResult(Plan plan, FilterRel filterRel) {
            SqlStdOperatorTable.EQUALS,
     * Declares the same capabilities as the real DF backend — only fragment conversion
                MatchQueryBuilder matchQuery = (MatchQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
        SimpleExtension.ExtensionCollection extensions;  
        @Override
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
        private static final Set<FieldType> TYPES = new HashSet<>();  
    }
        }
import org.opensearch.analytics.spi.DelegatedExpression;
        // OR(MATCH 'hello', NOT(MATCH 'goodbye')) is combined into a single BoolQuery  
                public FragmentInstructionHandler<?> createHandler(InstructionNode node) {
    public void setUp() throws Exception {
                }
                int colonIndex = fullName.indexOf(':');
     */
        assertEquals(
    }  
            SqlStdOperatorTable.AND,
        Stage leaf = dag.rootStage();
        // Field 2 amount: integer NOT indexed (single-viable to DF only) — used by tests
        when(mappingMetadata.sourceAsMap()).thenReturn(Map.of("properties", fieldMappings));
import org.opensearch.index.query.QueryBuilder;
                    )) {
            makeEquals(2, SqlTypeName.INTEGER, 200),  
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
        cluster = RelOptCluster.create(new HepPlanner(new HepProgramBuilder().build()), rexBuilder);  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, Set.of(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING));  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), fieldIndex),
        Metadata metadata = mock(Metadata.class);
        // Load Substrait extensions with delegation_functions.yaml merged in,
            }  
     * without instantiating {@link DataFusionPlugin} (which requires native libraries).
        assertNotNull("annotation ID " + annotationId + " must be in delegatedExpressions", found);
                public Optional<InstructionNode> createShardScanNode(boolean requestsRowIds, String logicalTableName) {
import org.opensearch.cluster.metadata.IndexMetadata;  
        for (DelegatedExpression expr : delegatedExpressions) {
        }
        // Field 1 message: keyword indexed (dual-viable; full-text via Lucene).
        assertTrue("root must be a FilterRel", root.hasFilter());
    }
        OperandTypes.ANY,
        SubstraitResult substrait = substraitResult(plan.convertedBytes());  
        ClusterService clusterService = mock(ClusterService.class);  
import io.substrait.extension.SimpleExtension;
        super.setUp();  
            rexBuilder.makeLiteral(query)
        }
    private AnalyticsSearchBackendPlugin luceneBackend;
        when(clusterService.state()).thenReturn(clusterState);  
import org.apache.calcite.rel.logical.LogicalFilter;
        when(clusterState.metadata()).thenReturn(metadata);
                    return Set.of(EngineCapability.SORT);  
        List<AnalyticsSearchBackendPlugin> backends
import java.util.List;  
                    boolean requestsRowIds,  
import static org.mockito.Mockito.mock;  
     * id=1 to MATCH (delegated).
            MatchQueryBuilder matchQuery = (MatchQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
     * id=1 to first MATCH, id=2 to second MATCH.
     * amount is index=false → equals stays native; planner assigns id=0 to equals,  
        Expression.ScalarFunction func = expr.getScalarFunction();  
        return clusterService;
                }
import org.apache.calcite.rex.RexNode;
import static org.mockito.Mockito.when;
            TYPES.addAll(FieldType.date());
        when(indexMetadata.getSettings()).thenReturn(
        for (SimpleExtensionDeclaration decl : plan.getExtensionsList()) {
     * and capability declarations are exercised, not execution.  
        public String name() {  
        RelNode marked = PlannerImpl.runAllOptimizations(filter, context);  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            )
        for (int index = 0; index < fieldNames.length; index++) {
import org.opensearch.common.util.concurrent.ThreadContext;
                public Set<FilterCapability> filterCapabilities() {  
import org.opensearch.analytics.planner.dag.Stage;
    }
            "status",
    private RexNode makeEquals(int fieldIndex, SqlTypeName fieldType, Object value) {
        fail("No MatchQueryBuilder found with field=[" + expectedField + "], query=[" + expectedQuery + "]");
import org.apache.calcite.sql.SqlFunctionCategory;
        Thread thread = Thread.currentThread();
                        new ShardScanWithDelegationInstructionNode(treeShape, delegatedPredicateCount, requestsRowIds, logicalTableName)
        }  
        String expectedField,
     * Lightweight DF backend wrapping the real {@link DataFusionFragmentConvertor}  
            extensions = DefaultExtensionCatalog.DEFAULT_COLLECTION.merge(delegationExtensions);  
        null,
                    }  
            SimpleExtension.ExtensionCollection delegationExtensions = SimpleExtension.load(List.of("/delegation_functions.yaml"));
        rexBuilder = new RexBuilder(typeFactory);
                }
    private void assertDelegatedPredicate(Plan plan, Expression expr, int expectedAnnotationId) {
    private PlannerContext buildContext(
        throws IOException {
    private void assertMatchQueryBuilder(List<DelegatedExpression> delegatedExpressions, String expectedField, String expectedQuery)  
import io.substrait.proto.Expression;
                    FilterTreeShape treeShape,
        Expression.ScalarFunction andFunc = substrait.filterRel().getCondition().getScalarFunction();
            this.convertor = convertor;
    }
        IndexMetadata indexMetadata = mock(IndexMetadata.class);  
            builder.add(fieldNames[index], typeFactory.createSqlType(fieldTypes[index]));  
        when(table.getRowType()).thenReturn(builder.build());
                makeMatch(1, "hello"),  
            "message",
                    );
                public Optional<InstructionNode> createFinalAggregateNode() {
        Plan plan = Plan.parseFrom(convertedBytes);
 * {@link LuceneAnalyticsBackendPlugin} for query serialization and the real  
                    List<DelegatedExpression> delegatedExpressions  
                }  
import org.opensearch.analytics.spi.FilterCapability;
    private RexNode makeMatch(int fieldIndex, String query) {
    );
                return colonIndex >= 0 ? fullName.substring(0, colonIndex) : fullName;
            Map.of("type", "integer", "index", true),  
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
                    for (ScalarFunction op : Set.of(
        StubDfBackend(DataFusionFragmentConvertor convertor) {
import java.io.IOException;
        Function<IndexMetadata, FieldStorageResolver> fieldStorageFactory = FieldStorageResolver::new;
                .put("index.composite.primary_data_format", primaryFormat)
     */
                @Override
    private RelDataTypeFactory typeFactory;
            MATCH_FUNCTION,  
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(found.getExpressionBytes()), WRITEABLE_REGISTRY)) {  
 * {@link DataFusionFragmentConvertor} for Substrait conversion.
import org.opensearch.common.settings.ClusterSettings;
            resolveFunctionName(plan, func.getFunctionReference())
    public void testComplexBooleanTree() throws Exception {  
        @Override
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
        }
 * SPDX-License-Identifier: Apache-2.0
        OperationRouting routing = mock(OperationRouting.class);
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.sql.type.ReturnTypes;
        // arg[0]: delegated_predicate(1) — annotation id=1 maps to MATCH 'hello world'
        return new PlannerContext(new CapabilityRegistry(backends, fieldStorageFactory), clusterState);  
import org.opensearch.core.index.Index;
     * amount is index=false → equals stays native; planner assigns id=0 to equals,  
        );  
            }  
                }
import org.opensearch.common.settings.Settings;  
            assertEquals("query text for annotation " + annotationId, expectedQuery, matchQuery.value());  
        MappingMetadata mappingMetadata = mock(MappingMetadata.class);
                found = expr;
        );
    // ---- Pipeline ----  
        // Only capabilities and fragment conversion are needed — no execution.
        }
import java.util.function.Function;
        }
     * AND(amount = 200, OR(MATCH(message, 'hello'), NOT(MATCH(message, 'goodbye')))) — complex tree.
        int annotationId,  
import org.opensearch.index.query.MatchQueryBuilder;  
                @Override
            "function must be delegated_predicate",
                    Set<FilterCapability> caps = new HashSet<>();
    }
        assertEquals("should have 1 combined delegated query", 1, plan.delegatedExpressions().size());
import org.opensearch.analytics.spi.DelegationType;
        assertMatchQueryForAnnotation(plan.delegatedExpressions(), 1, "message", "hello world");
        List<DelegatedExpression> delegatedExpressions,
                ) {
import org.opensearch.cluster.metadata.MappingMetadata;
                    return;  
                public Set<ScanCapability> scanCapabilities() {
            thread.setContextClassLoader(previous);
        ClusterState clusterState = mock(ClusterState.class);  
        public BackendCapabilityProvider getCapabilityProvider() {
            new SqlTypeName[] { SqlTypeName.INTEGER, SqlTypeName.VARCHAR, SqlTypeName.INTEGER }
            leaf = leaf.getChildStages().getFirst();
        }
import org.opensearch.analytics.spi.ScalarFunction;  
        // Root: AND — operand order: delegated first, native after (materializeCombined)
                }  
            TYPES.addAll(FieldType.keyword());  
import org.opensearch.analytics.planner.dag.PlanForker;
import org.opensearch.analytics.planner.CapabilityRegistry;
        return table;
 * the Substrait plan structure (delegated_predicate placeholders with correct annotation IDs
        RelOptTable table = mockTable(
        for (DelegatedExpression expr : delegatedExpressions) {
