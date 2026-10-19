import org.apache.calcite.sql.type.ReturnTypes;
        RexNode condition = rexBuilder.makeCall(  
        // Real Lucene backend: accepts delegation, provides MATCH serializer  
    public void testMatchPredicateDelegationEndToEnd() throws IOException {  
import org.opensearch.analytics.spi.ExchangeSinkProvider;  
                    return Set.of(DelegationType.FILTER);  
     * valid MatchQueryBuilder bytes with correct field name and query text.
import org.opensearch.analytics.planner.FieldStorageResolver;
import org.opensearch.analytics.planner.PlannerImpl;
        return new PlannerContext(new CapabilityRegistry(backends, fieldStorageFactory), clusterState);  
        Map<String, Map<String, Object>> fieldMappings,  
        List.of(new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchQueryBuilder.NAME, MatchQueryBuilder::new))
import org.opensearch.analytics.planner.dag.PlanAlternativeSelector;
            builder.add(fieldNames[index], typeFactory.createSqlType(fieldTypes[index]));  
                    return Optional.of(  
import org.apache.calcite.rex.RexNode;
    private static final SqlFunction MATCH_FUNCTION = new SqlFunction(
            assertEquals("hello world", matchQuery.value());  
import org.opensearch.analytics.planner.dag.BackendPlanAdapter;
        RelDataTypeFactory.Builder builder = typeFactory.builder();
        ClusterState clusterState = mock(ClusterState.class);
        Function<IndexMetadata, FieldStorageResolver> fieldStorageFactory = FieldStorageResolver::new;
    private static class StubDfBackend implements AnalyticsSearchBackendPlugin {  
        "MATCH",
        return clusterService;
                .build()  
public class LuceneAnalyticsBackendPluginTests extends OpenSearchTestCase {
                    List<DelegatedExpression> delegatedExpressions  
                        ScalarFunction.GREATER_THAN,  
                }
        String primaryFormat,
    /**
            assertTrue("Should be MatchQueryBuilder", deserialized instanceof MatchQueryBuilder);  
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
                        ScalarFunction.EQUALS,
 */
        BackendPlanAdapter.adaptAll(dag, context.getCapabilityRegistry());
import org.opensearch.index.query.MatchQueryBuilder;
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
                    return Set.of(EngineCapability.SORT);
import org.opensearch.analytics.planner.dag.Stage;
                    return Optional.of(new ShardScanInstructionNode(requestsRowIds, logicalTableName));
            Settings.builder()  
                public FragmentInstructionHandler<?> createHandler(InstructionNode node) {
        );
        ReturnTypes.BOOLEAN,
        when(clusterService.operationRouting()).thenReturn(routing);
    private PlannerContext buildContext(
        RelNode marked = PlannerImpl.runAllOptimizations(filter, context);  
        byte[] queryBytes = plan.delegatedExpressions().getFirst().getExpressionBytes();  
        when(mappingMetadata.sourceAsMap()).thenReturn(Map.of("properties", fieldMappings));
        }  
                public Optional<InstructionNode> createFinalAggregateNode() {
import org.apache.calcite.sql.type.SqlTypeName;
                    return Optional.empty();  
                }
        SqlKind.OTHER_FUNCTION,  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        @Override  
import org.apache.calcite.plan.hep.HepPlanner;
        QueryDAG dag = DAGBuilder.build(marked, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
                        ScalarFunction.LESS_THAN_OR_EQUAL  
import org.opensearch.cluster.metadata.IndexMetadata;
                }  
        cluster = RelOptCluster.create(new HepPlanner(new HepProgramBuilder().build()), rexBuilder);
                }  
                public byte[] attachPartialAggOnTop(RelNode partialAggFragment, byte[] innerBytes) {  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
            .findFirst()
        assertFalse("delegatedExpressions should not be empty", plan.delegatedExpressions().isEmpty());
import org.opensearch.cluster.ClusterState;
                @Override
        when(table.getRowType()).thenReturn(builder.build());
        // Deserialize and verify the MatchQueryBuilder
                public byte[] attachFragmentOnTop(RelNode fragment, byte[] innerBytes) {
                public Optional<InstructionNode> createPartialAggregateNode() {  
        // Find the leaf stage (shard scan with filter)
    public void setUp() throws Exception {
            return (context, backendContext) -> null;
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, Set.of(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING));  
        LogicalFilter filter = LogicalFilter.create(new TableScan(cluster, cluster.traitSet(), List.of(), table) {  
                }
import org.opensearch.analytics.spi.ShardScanInstructionNode;
    private RelOptTable mockTable(String tableName, String[] fieldNames, SqlTypeName[] fieldTypes) {  
        @Override
import org.opensearch.analytics.spi.DelegationType;
        IndexMetadata indexMetadata = mock(IndexMetadata.class);  
import org.apache.calcite.plan.RelOptCluster;
        when(clusterService.state()).thenReturn(clusterState);  
                ) {
                public Set<ScanCapability> scanCapabilities() {
                        caps.add(new FilterCapability.Standard(op, TYPES, Set.of("parquet")));
import static org.mockito.Mockito.mock;
            MATCH_FUNCTION,
        when(indexMetadata.getNumberOfShards()).thenReturn(2);  
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
    }  
import org.opensearch.cluster.routing.GroupShardsIterator;  
        );
        Map<String, Map<String, Object>> fields = Map.of("message", Map.of("type", "keyword", "index", true));  
import org.opensearch.analytics.spi.ScalarFunction;  
        RelOptTable table = mockTable("test_index", new String[] { "message" }, new SqlTypeName[] { SqlTypeName.VARCHAR });
                    FilterTreeShape treeShape,
        }
            TYPES.addAll(FieldType.date());
import org.opensearch.analytics.planner.PlannerContext;  
import org.opensearch.action.search.TransportSearchAction;  
        when(clusterState.metadata()).thenReturn(metadata);  
import org.opensearch.common.settings.ClusterSettings;
import org.apache.calcite.sql.SqlKind;
        Metadata metadata = mock(Metadata.class);
        SqlFunctionCategory.USER_DEFINED_FUNCTION
    private RelDataTypeFactory typeFactory;
        }
                        ScalarFunction.NOT_EQUALS,
 * compatible open source license.
        when(table.getQualifiedName()).thenReturn(List.of(tableName));  
import org.opensearch.cluster.routing.OperationRouting;
                    int delegatedPredicateCount,
            .filter(p -> "mock-parquet".equals(p.backendId()))  
import org.apache.calcite.rel.core.TableScan;
    ) {
import org.opensearch.analytics.spi.EngineCapability;
import org.opensearch.analytics.planner.dag.DAGBuilder;  
        }  
    private RexBuilder rexBuilder;  
    }
                @Override
        when(indexMetadata.mapping()).thenReturn(mappingMetadata);
}
import static org.mockito.Mockito.when;
        ClusterState clusterState = mock(ClusterState.class);
            return new FragmentConvertor() {  
        when(routing.searchShards(any(), any(), any(), any())).thenReturn(new GroupShardsIterator<ShardIterator>(List.of()));
            .stream()
        }
import org.opensearch.analytics.spi.FilterCapability;
            MatchQueryBuilder matchQuery = (MatchQueryBuilder) deserialized;
                public Set<FilterCapability> filterCapabilities() {
package org.opensearch.be.lucene;
        // Mirror DefaultPlanExecutor.executeInternal: forker → adapter → selector → convertor.
        null,
    }  
                @Override
                    return Set.of(new ScanCapability.DocValues(Set.of("parquet"), TYPES));  
 * this file be licensed under the Apache-2.0 license or a
                ) {
 *
            };  
                @Override  
        public String name() {
 * End-to-end test: MATCH predicate flows through FragmentConversionDriver with the real
    private static final NamedWriteableRegistry WRITEABLE_REGISTRY = new NamedWriteableRegistry(
import org.opensearch.analytics.spi.ScanCapability;
                public byte[] convertFragment(RelNode fragment) {
                @Override
import org.opensearch.analytics.spi.InstructionNode;
        @Override  
import java.util.HashSet;
                @Override  
import org.opensearch.analytics.planner.dag.FragmentConversionDriver;
        }, condition);
        when(indexMetadata.getSettings()).thenReturn(
                    throw new UnsupportedOperationException("mock");
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(queryBytes), WRITEABLE_REGISTRY)) {
            };
import java.util.Optional;
        PlannerContext context = buildContext("parquet", fields, List.of(dfBackend, luceneBackend));
                @Override  
import org.opensearch.analytics.planner.dag.QueryDAG;
                        ScalarFunction.GREATER_THAN_OR_EQUAL,
import org.opensearch.test.OpenSearchTestCase;
                    );
        AnalyticsSearchBackendPlugin luceneBackend = new LuceneAnalyticsBackendPlugin(null);
                @Override
        @Override
        PlanForker.forkAll(dag, context.getCapabilityRegistry());  
import java.util.Set;  
    /** Minimal DF backend that drives the plan with delegation support. */
        assertEquals("should have exactly one delegated expression", 1, plan.delegatedExpressions().size());  
                @Override
/*  
        for (int index = 0; index < fieldNames.length; index++) {
                    return caps;
                }
        }  
        public FragmentConvertor getFragmentConvertor() {
                    return innerBytes;
import org.opensearch.analytics.spi.FilterDelegationInstructionNode;  
import org.opensearch.analytics.spi.FragmentInstructionHandler;  
        // peer; the surviving plan exercises the DF→Lucene filter delegation path, which is
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        typeFactory = new JavaTypeFactoryImpl();  
                .put("index.composite.primary_data_format", primaryFormat)
        OperationRouting routing = mock(OperationRouting.class);
import org.opensearch.core.index.Index;
    }
import org.opensearch.index.query.QueryBuilder;  
import org.opensearch.analytics.spi.ShardScanWithDelegationInstructionNode;  
import java.nio.charset.StandardCharsets;
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;  
                    return Optional.of(new FilterDelegationInstructionNode(treeShape, delegatedPredicateCount, delegatedExpressions));
import org.opensearch.analytics.spi.DelegatedExpression;  
        StagePlan plan = leaf.getPlanAlternatives()
                    )) {
import java.util.List;  
        when(metadata.index("test_index")).thenReturn(indexMetadata);  
                    int delegatedPredicateCount,
                @Override  
            assertEquals("message", matchQuery.fieldName());
        Stage leaf = dag.rootStage();  
import org.opensearch.cluster.metadata.MappingMetadata;
            TYPES.addAll(FieldType.keyword());
            .orElseThrow(() -> new AssertionError("No mock-parquet driver alternative found"));
    );  
import org.opensearch.cluster.metadata.Metadata;
                }
import java.util.function.Function;
 */  
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
        ClusterService clusterService = mock(ClusterService.class);  
import java.util.Map;
import static org.mockito.ArgumentMatchers.any;  
import org.opensearch.analytics.planner.CapabilityRegistry;
                        new ShardScanWithDelegationInstructionNode(treeShape, delegatedPredicateCount, requestsRowIds, logicalTableName)
import org.apache.calcite.sql.type.OperandTypes;  
import org.opensearch.core.common.io.stream.StreamInput;  
        }
                    return "fragment".getBytes(StandardCharsets.UTF_8);  
            return new FragmentInstructionHandlerFactory() {
            leaf = leaf.getChildStages().getFirst();
     * MATCH(message, 'hello world') through full pipeline → delegatedQueries contains  
import org.apache.calcite.sql.SqlFunction;  
                }
/**
    private static final IndexNameExpressionResolver TEST_RESOLVER = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));
        AnalyticsSearchBackendPlugin dfBackend = new StubDfBackend();
                    String logicalTableName
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0),
import org.apache.calcite.sql.SqlFunctionCategory;
import org.opensearch.analytics.planner.dag.PlanForker;  
import org.opensearch.common.util.concurrent.ThreadContext;  
        // preferMetadataDriver=false drops the Lucene alternative and forces the DataFusion  
import org.apache.calcite.rex.RexBuilder;
import org.opensearch.analytics.planner.dag.StagePlan;  
                @Override
                @Override
        // Verify delegation happened
            TYPES.add(FieldType.BOOLEAN);  
    private RelOptCluster cluster;
            TYPES.addAll(FieldType.numeric());  
            return new BackendCapabilityProvider() {
                }  
        public BackendCapabilityProvider getCapabilityProvider() {  
            };
                @Override
        OperandTypes.ANY,  
import org.opensearch.analytics.spi.FieldType;
import org.opensearch.common.settings.Settings;
import org.opensearch.analytics.spi.FilterTreeShape;
import org.opensearch.analytics.spi.FragmentInstructionHandlerFactory;
        public FragmentInstructionHandlerFactory getInstructionHandlerFactory() {
                public Optional<InstructionNode> createShardScanWithDelegationNode(  
                    return innerBytes;
                }
        }
        }
        MappingMetadata mappingMetadata = mock(MappingMetadata.class);  
import org.opensearch.cluster.service.ClusterService;  
        super.setUp();
        private static final Set<FieldType> TYPES = new HashSet<>();
                public Set<EngineCapability> supportedEngineCapabilities() {  
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());  
                }  
import org.apache.calcite.rel.logical.LogicalFilter;
    private ClusterService mockClusterService() {
        rexBuilder = new RexBuilder(typeFactory);
    @Override  
                    for (ScalarFunction op : Set.of(  
                }  
        return table;
    }  
        List<AnalyticsSearchBackendPlugin> backends
        // what this test is asserting on.
 * {@link LuceneAnalyticsBackendPlugin} serializer, producing valid MatchQueryBuilder bytes.  
import org.apache.calcite.rel.RelNode;  
                .putList("index.composite.secondary_data_formats", "lucene")
                public Optional<InstructionNode> createFilterDelegationNode(  
     */
                        ScalarFunction.LESS_THAN,
import org.apache.calcite.plan.hep.HepProgramBuilder;
        while (!leaf.getChildStages().isEmpty()) {
        static {
        public ExchangeSinkProvider getExchangeSinkProvider() {  
                    boolean requestsRowIds,  
            return "mock-parquet";
        PlanAlternativeSelector.selectAll(dag, context.getCapabilityRegistry(), false);
    @SuppressWarnings("unchecked")  
    // ---- Minimal infrastructure ----
                }
    /** Default resolver for DAGBuilder in tests; production injects core's resolver. */
        @Override
                    }  
        RelOptTable table = mock(RelOptTable.class);
import org.opensearch.analytics.spi.FragmentConvertor;
            rexBuilder.makeLiteral("hello world")  
                    Set<FilterCapability> caps = new HashSet<>();
import org.opensearch.analytics.spi.BackendCapabilityProvider;
                public Set<DelegationType> supportedDelegations() {
        when(indexMetadata.getIndex()).thenReturn(new Index("test_index", "uuid"));
import org.apache.calcite.plan.RelOptTable;  
import org.opensearch.cluster.routing.ShardIterator;
        // DF backend: drives the plan, supports delegation, has a stub convertor
                    FilterTreeShape treeShape,
 * SPDX-License-Identifier: Apache-2.0
                public Optional<InstructionNode> createShardScanNode(boolean requestsRowIds, String logicalTableName) {
    }  
    );
                    return Optional.empty();
