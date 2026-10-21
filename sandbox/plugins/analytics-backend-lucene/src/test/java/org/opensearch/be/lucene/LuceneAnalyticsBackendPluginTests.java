import org.opensearch.analytics.planner.FieldStorageResolver;
                    )) {
        when(indexMetadata.getSettings()).thenReturn(
                public Optional<InstructionNode> createShardScanNode(boolean requestsRowIds, String logicalTableName) {
                    for (ScalarFunction op : Set.of(
import static org.mockito.Mockito.when;
        @Override
    private ClusterService mockClusterService() {
                public byte[] attachPartialAggOnTop(RelNode partialAggFragment, byte[] innerBytes) {
                @Override
            return new FragmentConvertor() {
import java.util.Set;
                    FilterTreeShape treeShape,
            rexBuilder.makeLiteral("hello world")
        Map<String, Map<String, Object>> fieldMappings,
                    return innerBytes;
                        new ShardScanWithDelegationInstructionNode(treeShape, delegatedPredicateCount, requestsRowIds, logicalTableName)
                        caps.add(new FilterCapability.Standard(op, TYPES, Set.of("parquet")));
                ) {
import org.apache.calcite.sql.type.OperandTypes;
                }
                }
        ClusterState clusterState = mock(ClusterState.class);
                    int delegatedPredicateCount,
                @Override
 * SPDX-License-Identifier: Apache-2.0
import java.util.Map;
import org.opensearch.analytics.spi.ScalarFunction;
        // Mirror DefaultPlanExecutor.executeInternal: forker → adapter → selector → convertor.
        when(metadata.index("test_index")).thenReturn(indexMetadata);
    );
 */
 * End-to-end test: MATCH predicate flows through FragmentConversionDriver with the real
import org.apache.calcite.sql.SqlFunction;
        Metadata metadata = mock(Metadata.class);
 */
import org.apache.calcite.sql.type.ReturnTypes;
        String primaryFormat,
        when(clusterState.metadata()).thenReturn(metadata);
            assertEquals("hello world", matchQuery.value());
                    return Optional.empty();
import org.opensearch.cluster.metadata.MappingMetadata;
        @Override
            return new BackendCapabilityProvider() {
                        ScalarFunction.NOT_EQUALS,
                }
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
import org.apache.calcite.rex.RexNode;
        ReturnTypes.BOOLEAN,
            MATCH_FUNCTION,
                public Optional<InstructionNode> createFilterDelegationNode(
        PlanAlternativeSelector.selectAll(dag, context.getCapabilityRegistry(), false);
                    return Optional.of(new FilterDelegationInstructionNode(treeShape, delegatedPredicateCount, delegatedExpressions));
 * The OpenSearch Contributors require contributions made to
import java.util.Optional;
    public void testMatchPredicateDelegationEndToEnd() throws IOException {
        // Verify delegation happened
                public Optional<InstructionNode> createPartialAggregateNode() {
        RexNode condition = rexBuilder.makeCall(
    ) {
        }
        "MATCH",
import org.opensearch.analytics.spi.FilterCapability;
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
            MatchQueryBuilder matchQuery = (MatchQueryBuilder) deserialized;
        @Override
import java.io.IOException;
        public ExchangeSinkProvider getExchangeSinkProvider() {
    private static class StubDfBackend implements AnalyticsSearchBackendPlugin {
                public Optional<InstructionNode> createShardScanWithDelegationNode(
        when(table.getRowType()).thenReturn(builder.build());
                        ScalarFunction.LESS_THAN,
        when(indexMetadata.mapping()).thenReturn(mappingMetadata);
                }
    /** Default resolver for DAGBuilder in tests; production injects core's resolver. */
        AnalyticsSearchBackendPlugin luceneBackend = new LuceneAnalyticsBackendPlugin(null);
        AnalyticsSearchBackendPlugin dfBackend = new StubDfBackend();
        }
import org.apache.calcite.plan.RelOptTable;
import org.opensearch.analytics.spi.InstructionNode;
import java.util.List;
        // Deserialize and verify the MatchQueryBuilder
        BackendPlanAdapter.adaptAll(dag, context.getCapabilityRegistry());
            leaf = leaf.getChildStages().getFirst();
        }
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.analytics.spi.FilterDelegationInstructionNode;
import org.apache.calcite.sql.SqlKind;
        cluster = RelOptCluster.create(new HepPlanner(new HepProgramBuilder().build()), rexBuilder);
            TYPES.addAll(FieldType.numeric());
        null,
     */
        SqlFunctionCategory.USER_DEFINED_FUNCTION
import static org.mockito.Mockito.mock;
        assertFalse("delegatedExpressions should not be empty", plan.delegatedExpressions().isEmpty());
                }
        List.of(new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchQueryBuilder.NAME, MatchQueryBuilder::new))
        RelNode marked = PlannerImpl.runAllOptimizations(filter, context);
        }
        return clusterService;
            .orElseThrow(() -> new AssertionError("No mock-parquet driver alternative found"));
    @Override
                    FilterTreeShape treeShape,
        public BackendCapabilityProvider getCapabilityProvider() {
    /**
    }
            builder.add(fieldNames[index], typeFactory.createSqlType(fieldTypes[index]));
 * {@link LuceneAnalyticsBackendPlugin} serializer, producing valid MatchQueryBuilder bytes.
            return (context, backendContext) -> null;
 *
        RelOptTable table = mock(RelOptTable.class);
                @Override
        @Override
            return "mock-parquet";
                    List<DelegatedExpression> delegatedExpressions
            };
import org.opensearch.analytics.spi.DelegationType;
                    return innerBytes;
import org.opensearch.analytics.planner.dag.QueryDAG;
import org.opensearch.analytics.spi.ShardScanWithDelegationInstructionNode;
        List<AnalyticsSearchBackendPlugin> backends
import java.util.HashSet;
import org.opensearch.analytics.planner.dag.FragmentConversionDriver;
                }
                @Override
        private static final Set<FieldType> TYPES = new HashSet<>();
        Stage leaf = dag.rootStage();
import org.opensearch.cluster.metadata.IndexMetadata;
    }
     * MATCH(message, 'hello world') through full pipeline → delegatedQueries contains
        IndexMetadata indexMetadata = mock(IndexMetadata.class);
import org.opensearch.cluster.routing.GroupShardsIterator;
import org.opensearch.analytics.spi.FragmentConvertor;
        }
    // ---- Minimal infrastructure ----
                ) {
        StagePlan plan = leaf.getPlanAlternatives()
    private RelOptCluster cluster;
            TYPES.addAll(FieldType.date());
import org.apache.calcite.rel.core.TableScan;
        when(indexMetadata.getNumberOfShards()).thenReturn(2);
        // peer; the surviving plan exercises the DF→Lucene filter delegation path, which is
import org.opensearch.analytics.planner.dag.Stage;
import org.opensearch.analytics.spi.BackendCapabilityProvider;
import org.opensearch.analytics.spi.FilterTreeShape;
        }
                        ScalarFunction.EQUALS,
        RelDataTypeFactory.Builder builder = typeFactory.builder();
        OperandTypes.ANY,
        public FragmentInstructionHandlerFactory getInstructionHandlerFactory() {
                    String logicalTableName
                @Override
            TYPES.addAll(FieldType.keyword());
 * compatible open source license.
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
                    return "fragment".getBytes(StandardCharsets.UTF_8);
                @Override
import org.opensearch.analytics.spi.ScanCapability;
import org.apache.calcite.rel.logical.LogicalFilter;
                .putList("index.composite.secondary_data_formats", "lucene")
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.calcite.rel.RelNode;
                }
        @Override
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
        MappingMetadata mappingMetadata = mock(MappingMetadata.class);
import org.opensearch.analytics.spi.FieldType;
                public Set<FilterCapability> filterCapabilities() {
            return new FragmentInstructionHandlerFactory() {
import org.opensearch.core.index.Index;
import org.opensearch.analytics.spi.FragmentInstructionHandlerFactory;
        Function<IndexMetadata, FieldStorageResolver> fieldStorageFactory = FieldStorageResolver::new;
import java.util.function.Function;
    private RexBuilder rexBuilder;
import static org.mockito.ArgumentMatchers.any;
import org.opensearch.analytics.planner.dag.StagePlan;
public class LuceneAnalyticsBackendPluginTests extends OpenSearchTestCase {
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(queryBytes), WRITEABLE_REGISTRY)) {
                public byte[] convertFragment(RelNode fragment) {
            assertEquals("message", matchQuery.fieldName());
        return new PlannerContext(new CapabilityRegistry(backends, fieldStorageFactory), clusterState);
        for (int index = 0; index < fieldNames.length; index++) {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
            .findFirst()
                        ScalarFunction.GREATER_THAN,
     * valid MatchQueryBuilder bytes with correct field name and query text.
    }
                }
import org.opensearch.analytics.spi.EngineCapability;
    }
                @Override
        SqlKind.OTHER_FUNCTION,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        return table;
                @Override
import org.opensearch.analytics.spi.DelegatedExpression;
import org.opensearch.cluster.routing.ShardIterator;
                    throw new UnsupportedOperationException("mock");
        // preferMetadataDriver=false drops the Lucene alternative and forces the DataFusion
import java.nio.charset.StandardCharsets;
                public byte[] attachFragmentOnTop(RelNode fragment, byte[] innerBytes) {
                .put("index.composite.primary_data_format", primaryFormat)
        }, condition);
    private static final IndexNameExpressionResolver TEST_RESOLVER = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));
                }
        }
        while (!leaf.getChildStages().isEmpty()) {
        // Find the leaf stage (shard scan with filter)
        when(clusterService.state()).thenReturn(clusterState);
        ClusterService clusterService = mock(ClusterService.class);
    public void setUp() throws Exception {
import org.opensearch.common.settings.Settings;
                }
        rexBuilder = new RexBuilder(typeFactory);
                    return Optional.of(new ShardScanInstructionNode(requestsRowIds, logicalTableName));
import org.opensearch.index.query.MatchQueryBuilder;
        when(clusterService.operationRouting()).thenReturn(routing);
                public Set<EngineCapability> supportedEngineCapabilities() {
    private RelDataTypeFactory typeFactory;
    );
                }
                    );
                    boolean requestsRowIds,
                        ScalarFunction.GREATER_THAN_OR_EQUAL,
                    return Set.of(EngineCapability.SORT);
import org.opensearch.analytics.spi.ExchangeSinkProvider;
import org.opensearch.analytics.planner.dag.PlanAlternativeSelector;
        RelOptTable table = mockTable("test_index", new String[] { "message" }, new SqlTypeName[] { SqlTypeName.VARCHAR });
import org.opensearch.analytics.planner.dag.PlanForker;
        // what this test is asserting on.
import org.opensearch.analytics.planner.dag.DAGBuilder;
        // DF backend: drives the plan, supports delegation, has a stub convertor
                    return Optional.empty();
    }
                    }
        }
                    Set<FilterCapability> caps = new HashSet<>();
    }
            Settings.builder()
    private RelOptTable mockTable(String tableName, String[] fieldNames, SqlTypeName[] fieldTypes) {
                @Override
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.common.settings.ClusterSettings;
            assertTrue("Should be MatchQueryBuilder", deserialized instanceof MatchQueryBuilder);
import org.opensearch.analytics.planner.CapabilityRegistry;
        when(mappingMetadata.sourceAsMap()).thenReturn(Map.of("properties", fieldMappings));
import org.opensearch.cluster.metadata.Metadata;
                }
import org.apache.calcite.plan.hep.HepPlanner;
        // Real Lucene backend: accepts delegation, provides MATCH serializer
                }
            };
        super.setUp();
import org.apache.calcite.plan.RelOptCluster;
            };
        static {
        typeFactory = new JavaTypeFactoryImpl();
                    int delegatedPredicateCount,
import org.opensearch.common.util.concurrent.ThreadContext;
/*
        OperationRouting routing = mock(OperationRouting.class);
                    return caps;
    @SuppressWarnings("unchecked")
        when(table.getQualifiedName()).thenReturn(List.of(tableName));
import org.opensearch.index.query.QueryBuilder;
import org.opensearch.analytics.spi.ShardScanInstructionNode;
        PlannerContext context = buildContext("parquet", fields, List.of(dfBackend, luceneBackend));
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, Set.of(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING));
}
                public Set<ScanCapability> scanCapabilities() {
import org.opensearch.analytics.planner.dag.BackendPlanAdapter;
        public FragmentConvertor getFragmentConvertor() {
    /** Minimal DF backend that drives the plan with delegation support. */
        LogicalFilter filter = LogicalFilter.create(new TableScan(cluster, cluster.traitSet(), List.of(), table) {
import org.opensearch.analytics.planner.PlannerImpl;
import org.opensearch.cluster.routing.OperationRouting;
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
                        ScalarFunction.LESS_THAN_OR_EQUAL
import org.opensearch.analytics.spi.FragmentInstructionHandler;
        public String name() {
    private static final NamedWriteableRegistry WRITEABLE_REGISTRY = new NamedWriteableRegistry(
            .stream()
import org.opensearch.analytics.planner.PlannerContext;
        byte[] queryBytes = plan.delegatedExpressions().getFirst().getExpressionBytes();
                    return Set.of(DelegationType.FILTER);
                @Override
                public FragmentInstructionHandler<?> createHandler(InstructionNode node) {
                .build()
        );
        when(indexMetadata.getIndex()).thenReturn(new Index("test_index", "uuid"));
                public Optional<InstructionNode> createFinalAggregateNode() {
        QueryDAG dag = DAGBuilder.build(marked, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
        when(routing.searchShards(any(), any(), any(), any())).thenReturn(new GroupShardsIterator<ShardIterator>(List.of()));
import org.apache.calcite.sql.SqlFunctionCategory;
                    return Optional.of(
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.opensearch.test.OpenSearchTestCase;
import org.apache.calcite.rex.RexBuilder;
            TYPES.add(FieldType.BOOLEAN);
            .filter(p -> "mock-parquet".equals(p.backendId()))
                @Override
        );
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.search.TransportSearchAction;
/**
                @Override
                @Override
    private PlannerContext buildContext(
                public Set<DelegationType> supportedDelegations() {
package org.opensearch.be.lucene;
import org.apache.calcite.plan.hep.HepProgramBuilder;
    private static final SqlFunction MATCH_FUNCTION = new SqlFunction(
                    return Set.of(new ScanCapability.DocValues(Set.of("parquet"), TYPES));
import org.opensearch.cluster.ClusterState;
        }
        assertEquals("should have exactly one delegated expression", 1, plan.delegatedExpressions().size());
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0),
        ClusterState clusterState = mock(ClusterState.class);
        Map<String, Map<String, Object>> fields = Map.of("message", Map.of("type", "keyword", "index", true));
