            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0),
                    return Set.of(
                @Override
     * lucene index. Forker emits {@code [lucene, mock-parquet]}; with prefer=true the selector
        TableScan scan = threeFieldScan();
            SqlStdOperatorTable.SUM,
                }
        when(indexMetadata.getSettings()).thenReturn(
import org.opensearch.analytics.spi.EngineCapability;
    private static Map<String, Map<String, Object>> keywordMappings() {
     * Minimal DataFusion-shaped backend: drives parquet, declares enough cap surface
    }
        Map<String, Map<String, Object>> fieldMappings,
            MATCH_FUNCTION,
        AnalyticsSearchBackendPlugin dfBackend = new StubDfBackend();
        return dag;
        return LogicalAggregate.create(input, ImmutableBitSet.of(), null, List.of(calls));
    private RexNode matchOn(int fieldIndex, String query) {
     * {@code index} mapping setting.
    private QueryDAG forkAndSelect(RelNode plan, Map<String, Map<String, Object>> fieldMappings, boolean preferMetadataDriver) {
    private TableScan scanOver(String fieldName, SqlTypeName type) {
                    return Optional.of(new FilterDelegationInstructionNode(treeShape, delegatedPredicateCount, delegatedExpressions));
import java.nio.charset.StandardCharsets;
        QueryDAG dag = forkAndSelect(plan, integerMappings(), true);
                    FilterTreeShape treeShape,
                @Override
 * <p>Pipeline executed: {@code PlanForker} → {@code PlanAlternativeSelector} (no convertor —
 * selection happens before conversion, mirroring {@code DefaultPlanExecutor.executeInternal}).
            return "mock-parquet";
    public void setUp() throws Exception {
    /**
    }
import org.apache.calcite.sql.SqlFunction;
        public FragmentConvertor getFragmentConvertor() {
     * aggregate, so the SUM operator narrows to parquet regardless of where the field is
        RelNode plan = aggregate(scan, sum);
                }
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.analytics.planner.dag.StagePlan;
        QueryDAG dag = forkAndSelect(plan, threeFieldMappings(), true);
     * Same qualified shape, prefer=false: selector forces the value-producing backend. The
import org.apache.calcite.rel.type.RelDataType;
        @Override
    // ---- Calcite helpers ----
    public void testCountStarWithFourArmOrAllDelegatable_selectsLucene() {
        List<StagePlan> alternatives = leafOf(dag).getPlanAlternatives();
                ) {
        QueryDAG dag = forkAndSelect(plan, keywordMappings(), true);
     * collapses the leaf to {@code [lucene]}.
import org.opensearch.analytics.planner.FieldStorageResolver;
                }
        typeFactory = new JavaTypeFactoryImpl();
        assertEquals(1, alternatives.size());
        List<StagePlan> alternatives = leafOf(dag).getPlanAlternatives();
     * numerics, so the table-scan rule never marks Lucene viable — irrespective of the field's
        RelDataTypeFactory.Builder builder = typeFactory.builder();
                }
        List<StagePlan> alternatives = leafOf(dag).getPlanAlternatives();
import org.opensearch.analytics.planner.dag.Stage;
        QueryDAG dag = DAGBuilder.build(marked, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
     * drives end-to-end.
    private static Map<String, Map<String, Object>> integerMappings() {
        );
     */
import org.apache.calcite.rex.RexBuilder;
        assertEquals(1, alternatives.size());
        when(indexMetadata.mapping()).thenReturn(mappingMetadata);
                @Override
            equalsLit(2, SqlTypeName.VARCHAR, "eu"),
     */
        RexNode left = rexBuilder.makeCall(SqlStdOperatorTable.AND, equalsLit(0, SqlTypeName.VARCHAR, "a"), matchOn(1, "x"));
            "tag",
                    return Set.of(DelegationType.FILTER);
     * {@link FieldStorageResolver} leaves {@code indexFormats} empty when {@code index} is
        RelNode plan = aggregate(scan, countStar(scan));
        null,
import org.opensearch.common.util.concurrent.ThreadContext;
        when(clusterService.operationRouting()).thenReturn(routing);
        RelNode plan = aggregate(scan, countStar(scan));
        QueryDAG dag = forkAndSelect(plan, threeFieldMappings(), true);
    @SuppressWarnings("unchecked")
                @Override
        SqlFunctionCategory.USER_DEFINED_FUNCTION
        when(indexMetadata.getIndex()).thenReturn(new Index("test_index", "uuid"));
 * — {@code Index} scan + standard filter + COUNT aggregate, declared only for keyword/text
            Settings.builder()
    }
import org.opensearch.analytics.spi.BackendCapabilityProvider;
            false,
        return AggregateCall.create(
        when(clusterState.metadata()).thenReturn(metadata);
        rexBuilder = new RexBuilder(typeFactory);
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        assertEquals(1, alternatives.size());
        ClusterService clusterService = mock(ClusterService.class);
    public void testCountStarWithDepth3OrAllDelegatable_selectsLucene() {
    /**
    private PlannerContext buildContext(
        when(indexMetadata.getNumberOfShards()).thenReturn(2);
        TableScan scan = scanOver("status", SqlTypeName.VARCHAR);
        PlannerContext context = buildContext(fieldMappings, List.of(dfBackend, luceneBackend), preferMetadataDriver);
    private RelOptCluster cluster;
            -1,
        return new PlannerContext(new CapabilityRegistry(backends, fieldStorageFactory), clusterState, null, false, preferMetadataDriver);
                        caps.add(new FilterCapability.Standard(op, TYPES, Set.of("parquet")));
                @Override
                        ScalarFunction.LESS_THAN_OR_EQUAL
            scan,
                    return innerBytes;
            typeFactory.createSqlType(SqlTypeName.BIGINT),
        ClusterState clusterState = mock(ClusterState.class);
     * Qualified shape: {@code COUNT(*)} over a keyword field with both parquet doc values and a
/*
     * indexed. Selector is a no-op.
import org.apache.calcite.rel.logical.LogicalAggregate;
            rexBuilder.makeLiteral(value)
                @Override
        return rexBuilder.makeCall(
            rexBuilder.makeLiteral(query)
        RelNode plan = aggregate(scan, countStar(scan));
import org.opensearch.cluster.routing.GroupShardsIterator;
                        ScalarFunction.NOT_EQUALS,
        BackendPlanAdapter.adaptAll(dag, context.getCapabilityRegistry());
    private RexBuilder rexBuilder;
 * this file be licensed under the Apache-2.0 license or a
                    FilterTreeShape treeShape,
            };
            return new FragmentInstructionHandlerFactory() {
            return new FragmentConvertor() {
        List<StagePlan> alternatives = leafOf(dag).getPlanAlternatives();
        RexNode condition = rexBuilder.makeCall(
    }
                    return caps;
        }
                }
import org.opensearch.cluster.metadata.IndexMetadata;
    /** MATCH on a text-typed field; mirrors the SqlFunction shape used by other Lucene tests. */
                public Set<ScanCapability> scanCapabilities() {
import org.opensearch.cluster.routing.OperationRouting;
                @Override
        List<AnalyticsSearchBackendPlugin> backends,
        QueryDAG dag = forkAndSelect(plan, keywordMappings(), false);
            TYPES.addAll(FieldType.text());
        RelNode marked = PlannerImpl.runAllOptimizations(plan, context);
            "region",
        RelNode plan = aggregate(scan, countStar(scan));
     */
        AggregateCall sum = AggregateCall.create(
    private static Stage leafOf(QueryDAG dag) {
     */
                public Set<AggregateCapability> aggregateCapabilities() {
    }
        Metadata metadata = mock(Metadata.class);
        return Map.of("status", Map.of("type", "keyword", "index", true));
    }
    /** tag (keyword indexed), message (text indexed), region (keyword indexed) — all
        return clusterService;
            SqlStdOperatorTable.EQUALS,
        );
import org.opensearch.cluster.metadata.Metadata;
            -1,
        MappingMetadata mappingMetadata = mock(MappingMetadata.class);
        return new TableScan(cluster, cluster.traitSet(), List.of(), table) {
                    List<DelegatedExpression> delegatedExpressions
    public void testCountStarOverIntegerField_luceneNeverViable() {
    }
        );
                        ScalarFunction.EQUALS,
     * Disqualified shape: {@code SUM(status)} over a keyword field. Lucene declares no SUM
        @Override
     * Depth-4: {@code COUNT(*) WHERE (tag='a' AND msg MATCH 'x') OR (region='eu' AND msg MATCH 'y')}.
import org.opensearch.analytics.planner.dag.PlanAlternativeSelector;
                        ScalarFunction.LESS_THAN,
    ) {
    private RelDataTypeFactory typeFactory;
            };
 *
    public void testCountStarOverIndexedKeyword_preferDisabled_forcesDataFusion() {
                public byte[] convertFragment(RelNode fragment) {
        RexNode condition = rexBuilder.makeCall(SqlStdOperatorTable.OR, left, right);
        RelOptTable table = mock(RelOptTable.class);
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        when(routing.searchShards(any(), any(), any(), any())).thenReturn(new GroupShardsIterator<ShardIterator>(List.of()));
            Map.of("type", "keyword", "index", true)
     */
        assertEquals("mock-parquet", alternatives.getFirst().backendId());
            List.of(),
        when(table.getQualifiedName()).thenReturn(List.of("test_index"));
     * text). Distinct fields prevent Calcite's SEARCH/Sarg fold. Lucene drives end-to-end
import org.opensearch.analytics.spi.FilterTreeShape;
     *  fields prevent Calcite's SEARCH/Sarg fold of multi-EQUALS-on-same-field. */
            rexBuilder.makeInputRef(typeFactory.createSqlType(type), fieldIndex),
                public Set<EngineCapability> supportedEngineCapabilities() {
            matchOn(1, "x"),
     * Lucene alternative is dropped, leaving only mock-parquet — the data-node fallback can
     * {@code Index(supportedFieldTypes = {KEYWORD, TEXT, MATCH_ONLY_TEXT})} cap excludes
import org.apache.calcite.rel.type.RelDataTypeFactory;
            SqlStdOperatorTable.COUNT,
    }
        builder.add("region", typeFactory.createSqlType(SqlTypeName.VARCHAR));
    public void testCountStarWithIndexedKeywordFilter_selectsLucene() {
    }
            return new BackendCapabilityProvider() {
        @Override
        when(table.getQualifiedName()).thenReturn(List.of("test_index"));
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
    }
        }
                        new AggregateCapability(AggregateFunction.COUNT, TYPES, Set.of("parquet")),
                .build()
import org.opensearch.cluster.metadata.MappingMetadata;
        TableScan scan = scanOver("status", SqlTypeName.VARCHAR);
    /**
            scan,
        );
        RelDataTypeFactory.Builder builder = typeFactory.builder();
import org.opensearch.analytics.spi.FragmentInstructionHandler;
        }
import org.opensearch.analytics.spi.ShardScanInstructionNode;
                    for (ScalarFunction op : Set.of(
    }
import java.util.Map;
                @Override
        List<StagePlan> alternatives = leafOf(dag).getPlanAlternatives();
                public Optional<InstructionNode> createShardScanWithDelegationNode(
import org.opensearch.cluster.ClusterState;
        assertEquals(1, alternatives.size());
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
    }
     * Qualified-but-narrowed shape: {@code COUNT(*) WHERE status='200'} over a Lucene-indexed
        PlanAlternativeSelector.selectAll(dag, context.getCapabilityRegistry(), preferMetadataDriver);
            typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true),
                    return "fragment".getBytes(StandardCharsets.UTF_8);
                @Override
                public Optional<InstructionNode> createFinalAggregateNode() {
import org.opensearch.analytics.spi.FilterCapability;
                @Override
                .put("index.composite.primary_data_format", "parquet")
                }
        QueryDAG dag = forkAndSelect(plan, nonIndexedTextMappings(), true);
        AnalyticsSearchBackendPlugin luceneBackend = new LuceneAnalyticsBackendPlugin(null);
            };
import java.util.Set;
    // ---- Mappings ----
import org.opensearch.analytics.spi.ExchangeSinkProvider;
        }
import org.opensearch.analytics.spi.FragmentInstructionHandlerFactory;
     * Depth-3: {@code COUNT(*) WHERE tag='a' OR region='eu' OR message MATCH 'x'}. All three
        OperationRouting routing = mock(OperationRouting.class);
import org.apache.calcite.sql.type.SqlTypeName;
        };
        public FragmentInstructionHandlerFactory getInstructionHandlerFactory() {
                }
     *  Lucene-delegatable. */
        TableScan scan = threeFieldScan();
    public void testCountStarOverNonIndexedTextField_luceneNeverViable() {
    }
    private TableScan threeFieldScan() {
            TYPES.addAll(FieldType.numeric());
import org.opensearch.analytics.spi.InstructionNode;
                    boolean requestsRowIds,
import org.opensearch.analytics.spi.FragmentConvertor;
        @Override
                    return Set.of(EngineCapability.SORT);
        );
        ClusterState clusterState = mock(ClusterState.class);
     * Disqualified shape: {@code COUNT(*)} over an INTEGER field. Production Lucene's
     * never silently pick Lucene when the cluster has flipped the setting off.
            Map.of("type", "text", "index", true),
import org.apache.calcite.sql.SqlKind;
        assertEquals("lucene", alternatives.getFirst().backendId());
        TableScan scan = threeFieldScan();
/**
        List<StagePlan> alternatives = leafOf(dag).getPlanAlternatives();
    private static final SqlOperator MATCH_FUNCTION = new SqlFunction(
        };
import org.opensearch.analytics.planner.PlannerContext;
                    return Set.of(new ScanCapability.DocValues(Set.of("parquet"), TYPES));
                    )) {
                    return innerBytes;
        RelNode plan = aggregate(LogicalFilter.create(scan, equalsLiteral), countStar(scan));
import org.opensearch.analytics.spi.DelegationType;
     */
    private static final IndexNameExpressionResolver TEST_RESOLVER = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));
        builder.add("message", typeFactory.createSqlType(SqlTypeName.VARCHAR));
                public FragmentInstructionHandler<?> createHandler(InstructionNode node) {
     * though the field's type is in Lucene's {@code Index.supportedFieldTypes},
        RexNode matchX = matchOn(1, "x");
                        ScalarFunction.GREATER_THAN,
        RelDataType rowType = builder.build();
     */
                        new AggregateCapability(AggregateFunction.SUM, TYPES, Set.of("parquet"))
        RexNode regionEu = equalsLit(2, SqlTypeName.VARCHAR, "eu");
        assertEquals("lucene", alternatives.getFirst().backendId());
    // ---- Plan-execution helpers ----
import org.opensearch.analytics.planner.dag.PlanForker;
        RelNode plan = aggregate(LogicalFilter.create(scan, condition), countStar(scan));
        builder.add(fieldName, typeFactory.createSqlType(type));
                }
                        new ShardScanWithDelegationInstructionNode(treeShape, delegatedPredicateCount, requestsRowIds, logicalTableName)
import org.opensearch.common.settings.Settings;
        TableScan scan = scanOver("status", SqlTypeName.INTEGER);
                @Override
                public Set<DelegationType> supportedDelegations() {
                }
                    );
 * production plugin, these tests catch the change without any mock to update.
import org.opensearch.cluster.routing.ShardIterator;
        RexNode right = rexBuilder.makeCall(SqlStdOperatorTable.AND, equalsLit(2, SqlTypeName.VARCHAR, "eu"), matchOn(1, "y"));
                }
    }
    /**
            return (context, backendContext) -> null;
        static {
        RelNode plan = aggregate(LogicalFilter.create(scan, condition), countStar(scan));
    /**
            SqlStdOperatorTable.EQUALS,
        when(table.getRowType()).thenReturn(rowType);
    /**
 */
 */
                    throw new UnsupportedOperationException("mock");
                public Set<FilterCapability> filterCapabilities() {
        public String name() {
    }
        }
        assertEquals("mock-parquet", alternatives.getFirst().backendId());
        cluster = RelOptCluster.create(new HepPlanner(new HepProgramBuilder().build()), rexBuilder);
    public void testCountStarOverIndexedKeyword_selectsLucene() {
    public void testSumOverIntegerField_luceneNeverDrivesSum() {
import org.opensearch.analytics.planner.PlannerImpl;
import org.opensearch.analytics.planner.CapabilityRegistry;
    @Override
import org.opensearch.analytics.planner.dag.DAGBuilder;
    }
import org.apache.calcite.plan.RelOptCluster;
public class PlanAlternativeSelectorTests extends OpenSearchTestCase {
        RexNode condition = rexBuilder.makeCall(SqlStdOperatorTable.OR, tagA, regionEu, matchX);
     * 4-arm flat OR: {@code COUNT(*) WHERE tag='a' OR msg MATCH 'x' OR region='eu' OR msg MATCH 'y'}.
                    return Optional.of(
            stage = stage.getChildStages().getFirst();
        boolean preferMetadataDriver
    }
    private AggregateCall countStar(TableScan scan) {
    );
    private static Map<String, Map<String, Object>> threeFieldMappings() {
    // ---- Cluster state / context ----
import org.opensearch.core.index.Index;
    }
     */
import org.opensearch.analytics.spi.ShardScanWithDelegationInstructionNode;
        assertEquals(1, alternatives.size());
     * Calcite flattens OR-of-ORs, so authoring nested ORs and a flat 4-arm OR produce the
    private ClusterService mockClusterService() {
        "MATCH",
     * explicitly false — Lucene has no inverted-index segment to drive a count against.
        RelOptTable table = mock(RelOptTable.class);
    public void testCountStarWithDepth4NestedAndOrAllDelegatable_selectsLucene() {
        );
        QueryDAG dag = forkAndSelect(plan, integerMappings(), true);
            SqlStdOperatorTable.OR,
            TYPES.add(FieldType.BOOLEAN);
                public Optional<InstructionNode> createShardScanNode(boolean requestsRowIds, String logicalTableName) {
     * leaves are Lucene-delegatable (two keyword EQUALS on distinct fields + one MATCH on
            List.of(0),
import org.apache.calcite.rel.logical.LogicalFilter;
     */
    }
import org.apache.calcite.rex.RexNode;
import org.opensearch.analytics.spi.ScalarFunction;
import java.util.function.Function;
import org.apache.calcite.sql.type.ReturnTypes;
     * for plan forking, exchange-sinks for the coordinator reduce. No delegation —
        while (!stage.getChildStages().isEmpty()) {
import org.opensearch.analytics.spi.DelegatedExpression;
    /**
import org.apache.calcite.sql.type.OperandTypes;
}
        return Map.of("status", Map.of("type", "text", "index", false));
import org.apache.calcite.plan.hep.HepPlanner;
        Stage stage = dag.rootStage();
        return Map.of(
        TableScan scan = scanOver("status", SqlTypeName.VARCHAR);
        return stage;
 *
     * holds and the selector still picks Lucene with prefer=true.
    private RelNode aggregate(RelNode input, AggregateCall... calls) {
 * types — is consulted directly. If someone widens or narrows {@code STANDARD_TYPES} in the
        );
    /**
                public byte[] attachFragmentOnTop(RelNode fragment, byte[] innerBytes) {
 * <p>Lives in the lucene module (rather than analytics-engine) so the production capability surface
        when(mappingMetadata.sourceAsMap()).thenReturn(Map.of("properties", fieldMappings));
        RexNode tagA = equalsLit(0, SqlTypeName.VARCHAR, "a");
import org.apache.calcite.rel.core.AggregateCall;
    private static Map<String, Map<String, Object>> nonIndexedTextMappings() {
    }
            "message",
import static org.mockito.ArgumentMatchers.any;
        private static final Set<FieldType> TYPES = new HashSet<>();
    }
        TableScan scan = scanOver("status", SqlTypeName.VARCHAR);
    }
        public BackendCapabilityProvider getCapabilityProvider() {
    }
        return new TableScan(cluster, cluster.traitSet(), List.of(), table) {
        IndexMetadata indexMetadata = mock(IndexMetadata.class);
import org.apache.calcite.sql.SqlFunctionCategory;
        assertEquals("mock-parquet", alternatives.getFirst().backendId());
     * Nested AND inside OR, all four leaves Lucene-delegatable on distinct fields. Lucene
        List<StagePlan> alternatives = leafOf(dag).getPlanAlternatives();
import static org.mockito.Mockito.mock;
        super.setUp();
 * The OpenSearch Contributors require contributions made to
import java.util.List;
 * Tests for {@link PlanAlternativeSelector} executed against the real {@link LuceneAnalyticsBackendPlugin}.
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), fieldIndex),
                public Optional<InstructionNode> createPartialAggregateNode() {
                }
                    return Optional.empty();
        assertEquals("lucene", alternatives.getFirst().backendId());
                }
                @Override
import org.opensearch.analytics.spi.FieldType;
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("selector should collapse to a single alternative", 1, alternatives.size());
import org.apache.calcite.rel.RelNode;
                    }
        QueryDAG dag = forkAndSelect(plan, threeFieldMappings(), true);
 *
        QueryDAG dag = forkAndSelect(plan, keywordMappings(), true);
        public ExchangeSinkProvider getExchangeSinkProvider() {
        RelNode plan = aggregate(LogicalFilter.create(scan, condition), countStar(scan));
    private RexNode equalsLit(int fieldIndex, SqlTypeName type, String value) {
import org.opensearch.analytics.planner.dag.QueryDAG;
                .putList("index.composite.secondary_data_formats", "lucene")
                public byte[] attachPartialAggOnTop(RelNode partialAggFragment, byte[] innerBytes) {
import org.opensearch.analytics.planner.dag.BackendPlanAdapter;
import java.util.Optional;
        );
        assertEquals("prefer=false: only the value-producing backend remains", 1, alternatives.size());
     */
                    );
                ) {
                @Override
import org.opensearch.analytics.spi.ScanCapability;
    /**
                    int delegatedPredicateCount,
import org.opensearch.analytics.spi.FilterDelegationInstructionNode;
import org.apache.calcite.rel.core.TableScan;
        assertEquals("mock-parquet", alternatives.getFirst().backendId());
import org.opensearch.cluster.service.ClusterService;
     * via convertFragment; combiner not invoked.
            TYPES.addAll(FieldType.keyword());
 * compatible open source license.
        return rexBuilder.makeCall(
import static org.mockito.Mockito.when;
        }
            TYPES.addAll(FieldType.date());
            Map.of("type", "keyword", "index", true),
                    String logicalTableName
            false,
        @Override
        assertEquals("lucene", alternatives.getFirst().backendId());
        assertEquals(1, alternatives.size());
    private static class StubDfBackend implements AnalyticsSearchBackendPlugin {
     * we don't need it for selector tests.
    /**
        when(clusterService.state()).thenReturn(clusterState);
                }
                }
    /** Three-field scan: tag (keyword), message (text), region (keyword). Distinct keyword
            rexBuilder.makeLiteral("200")
            "count_star"
import org.apache.calcite.plan.hep.HepProgramBuilder;
        RelDataType rowType = builder.build();
        assertEquals(1, alternatives.size());
                    return Optional.of(new ShardScanInstructionNode(requestsRowIds, logicalTableName));
                        ScalarFunction.GREATER_THAN_OR_EQUAL,
import org.apache.calcite.util.ImmutableBitSet;
import org.opensearch.analytics.spi.AggregateFunction;
        return Map.of("status", Map.of("type", "integer"));
        Function<IndexMetadata, FieldStorageResolver> fieldStorageFactory = FieldStorageResolver::new;
        builder.add("tag", typeFactory.createSqlType(SqlTypeName.VARCHAR));
        when(metadata.index("test_index")).thenReturn(indexMetadata);
        OperandTypes.ANY,
package org.opensearch.be.lucene;
        ReturnTypes.BOOLEAN,
        RexNode equalsLiteral = rexBuilder.makeCall(
            "sum_status"
import org.apache.calcite.sql.SqlOperator;
            matchOn(1, "y")
import org.opensearch.analytics.spi.AggregateCapability;
                public Optional<InstructionNode> createFilterDelegationNode(
        assertEquals("lucene", alternatives.getFirst().backendId());
import org.apache.calcite.plan.RelOptTable;
                    Set<FilterCapability> caps = new HashSet<>();
        List<StagePlan> alternatives = leafOf(dag).getPlanAlternatives();
            equalsLit(0, SqlTypeName.VARCHAR, "a"),
        TableScan scan = scanOver("status", SqlTypeName.INTEGER);
        when(table.getRowType()).thenReturn(rowType);
     * same Filter — all four leaves Lucene-delegatable on distinct fields. Lucene drives.
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                @Override
        SqlKind.OTHER_FUNCTION,
                    int delegatedPredicateCount,
     * Disqualified shape: {@code COUNT(*)} over a TEXT field with {@code index: false}. Even
    }
import java.util.HashSet;
        }
        List<StagePlan> alternatives = leafOf(dag).getPlanAlternatives();
    }
                    return Optional.empty();
     * keyword field. EQUALS on KEYWORD is in Lucene's filter caps, so end-to-end agreement
