                        ScalarFunction.LESS_THAN_OR_EQUAL
    }
                public Optional<InstructionNode> createShardScanWithDelegationNode(  
     */
import org.opensearch.analytics.spi.DelegatedExpression;  
     * {@link FieldStorageResolver} leaves {@code indexFormats} empty when {@code index} is
                    boolean requestsRowIds,  
    // ---- Plan-execution helpers ----
import org.opensearch.analytics.planner.dag.PlanForker;
    }  
        );
        assertEquals(1, alternatives.size());
        RexNode matchX = matchOn(1, "x");
                    FilterTreeShape treeShape,
                    return innerBytes;
 * The OpenSearch Contributors require contributions made to  
            TYPES.addAll(FieldType.date());  
            return new FragmentConvertor() {  
        when(clusterService.operationRouting()).thenReturn(routing);
                public byte[] convertFragment(RelNode fragment) {
                @Override
    /**
        };
                        ScalarFunction.GREATER_THAN,
        cluster = RelOptCluster.create(new HepPlanner(new HepProgramBuilder().build()), rexBuilder);  
        TableScan scan = scanOver("status", SqlTypeName.VARCHAR);  
import org.apache.calcite.rex.RexBuilder;
            "count_star"  
                }
        return new TableScan(cluster, cluster.traitSet(), List.of(), table) {  
            false,
     * text). Distinct fields prevent Calcite's SEARCH/Sarg fold. Lucene drives end-to-end
    }
import org.opensearch.analytics.planner.dag.BackendPlanAdapter;
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(1, alternatives.size());  
                    return "fragment".getBytes(StandardCharsets.UTF_8);  
    @SuppressWarnings("unchecked")  
public class PlanAlternativeSelectorTests extends OpenSearchTestCase {
                    FilterTreeShape treeShape,
import org.apache.calcite.sql.SqlKind;
        when(table.getQualifiedName()).thenReturn(List.of("test_index"));
import org.apache.calcite.sql.type.SqlTypeName;
                }  
        RexNode condition = rexBuilder.makeCall(SqlStdOperatorTable.OR, left, right);  
    }
        TableScan scan = scanOver("status", SqlTypeName.VARCHAR);
/**  
    /**
import org.opensearch.cluster.ClusterState;
    }
    /** Three-field scan: tag (keyword), message (text), region (keyword). Distinct keyword
        return AggregateCall.create(
                @Override
     * Disqualified shape: {@code SUM(status)} over a keyword field. Lucene declares no SUM
import org.apache.calcite.rel.RelNode;  
import org.opensearch.cluster.routing.ShardIterator;
        List<StagePlan> alternatives = leafOf(dag).getPlanAlternatives();
            Map.of("type", "keyword", "index", true),
    private static Map<String, Map<String, Object>> keywordMappings() {  
                        ScalarFunction.LESS_THAN,  
        public String name() {
import java.util.Set;
        RelNode marked = PlannerImpl.runAllOptimizations(plan, context);
    private static Map<String, Map<String, Object>> integerMappings() {
    public void testCountStarWithFourArmOrAllDelegatable_selectsLucene() {
     * drives end-to-end.  
        SqlKind.OTHER_FUNCTION,  
import org.apache.calcite.sql.SqlFunctionCategory;
    // ---- Calcite helpers ----  
import static org.mockito.ArgumentMatchers.any;
    }
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
        Stage stage = dag.rootStage();
                public Optional<InstructionNode> createPartialAggregateNode() {  
            typeFactory.createSqlType(SqlTypeName.BIGINT),
                }  
import org.opensearch.analytics.spi.FieldType;
        QueryDAG dag = forkAndSelect(plan, threeFieldMappings(), true);  
                public FragmentInstructionHandler<?> createHandler(InstructionNode node) {
import org.apache.calcite.sql.SqlFunction;  
                ) {
    ) {
                    Set<FilterCapability> caps = new HashSet<>();  
    /** tag (keyword indexed), message (text indexed), region (keyword indexed) — all  
        }
     */
        assertEquals("lucene", alternatives.getFirst().backendId());
    public void testCountStarWithDepth3OrAllDelegatable_selectsLucene() {
     * though the field's type is in Lucene's {@code Index.supportedFieldTypes},  
        );
    private static Stage leafOf(QueryDAG dag) {
            return "mock-parquet";  
    }
        RelOptTable table = mock(RelOptTable.class);  
        typeFactory = new JavaTypeFactoryImpl();
        public ExchangeSinkProvider getExchangeSinkProvider() {  
import org.opensearch.analytics.spi.FragmentInstructionHandler;  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
            equalsLit(2, SqlTypeName.VARCHAR, "eu"),
     * Minimal DataFusion-shaped backend: drives parquet, declares enough cap surface
        ReturnTypes.BOOLEAN,
import org.opensearch.analytics.spi.InstructionNode;
        when(indexMetadata.getNumberOfShards()).thenReturn(2);  
import org.apache.calcite.rel.logical.LogicalFilter;
     * Lucene alternative is dropped, leaving only mock-parquet — the data-node fallback can
     * indexed. Selector is a no-op.
                    return Set.of(
        QueryDAG dag = DAGBuilder.build(marked, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);  
 * SPDX-License-Identifier: Apache-2.0
import java.nio.charset.StandardCharsets;  
import org.opensearch.analytics.spi.FilterDelegationInstructionNode;  
                @Override
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
    private AggregateCall countStar(TableScan scan) {
 * — {@code Index} scan + standard filter + COUNT aggregate, declared only for keyword/text
 * types — is consulted directly. If someone widens or narrows {@code STANDARD_TYPES} in the
        when(indexMetadata.getSettings()).thenReturn(
import org.opensearch.cluster.service.ClusterService;  
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
            typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true),
    private static final SqlOperator MATCH_FUNCTION = new SqlFunction(
import org.opensearch.analytics.spi.ScalarFunction;  
                    }
        RexNode condition = rexBuilder.makeCall(SqlStdOperatorTable.OR, tagA, regionEu, matchX);  
        RelDataType rowType = builder.build();
        when(metadata.index("test_index")).thenReturn(indexMetadata);  
    }
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.common.settings.Settings;
                @Override  
            SqlStdOperatorTable.EQUALS,
        when(clusterService.state()).thenReturn(clusterState);
import org.opensearch.analytics.planner.dag.DAGBuilder;
                    return Optional.empty();
 * production plugin, these tests catch the change without any mock to update.  
        PlannerContext context = buildContext(fieldMappings, List.of(dfBackend, luceneBackend), preferMetadataDriver);
                    return Set.of(DelegationType.FILTER);  
                @Override
                }
            "region",
        List<StagePlan> alternatives = leafOf(dag).getPlanAlternatives();
        );
        List<AnalyticsSearchBackendPlugin> backends,  
        @Override  
        List<StagePlan> alternatives = leafOf(dag).getPlanAlternatives();
        TableScan scan = scanOver("status", SqlTypeName.VARCHAR);
            TYPES.addAll(FieldType.text());
    }
                        ScalarFunction.NOT_EQUALS,  
     * Same qualified shape, prefer=false: selector forces the value-producing backend. The
            SqlStdOperatorTable.OR,
                        new AggregateCapability(AggregateFunction.COUNT, TYPES, Set.of("parquet")),
        PlanAlternativeSelector.selectAll(dag, context.getCapabilityRegistry(), preferMetadataDriver);  
        TableScan scan = scanOver("status", SqlTypeName.VARCHAR);  
            stage = stage.getChildStages().getFirst();
import java.util.HashSet;
        RexNode left = rexBuilder.makeCall(SqlStdOperatorTable.AND, equalsLit(0, SqlTypeName.VARCHAR, "a"), matchOn(1, "x"));
        List<StagePlan> alternatives = leafOf(dag).getPlanAlternatives();
        }  
        boolean preferMetadataDriver
            MATCH_FUNCTION,  
        "MATCH",
import org.opensearch.analytics.spi.ShardScanInstructionNode;
                }  
    public void testCountStarOverIntegerField_luceneNeverViable() {  
    private QueryDAG forkAndSelect(RelNode plan, Map<String, Map<String, Object>> fieldMappings, boolean preferMetadataDriver) {  
                @Override
import org.apache.calcite.rel.type.RelDataType;
        assertEquals("prefer=false: only the value-producing backend remains", 1, alternatives.size());
    public void testCountStarOverIndexedKeyword_preferDisabled_forcesDataFusion() {
                public Optional<InstructionNode> createShardScanNode(boolean requestsRowIds, String logicalTableName) {
            return new BackendCapabilityProvider() {
import static org.mockito.Mockito.mock;  
    }
        builder.add(fieldName, typeFactory.createSqlType(type));
            SqlStdOperatorTable.SUM,  
                    return Optional.of(new ShardScanInstructionNode(requestsRowIds, logicalTableName));
            List.of(0),
        assertEquals("mock-parquet", alternatives.getFirst().backendId());  
        List<StagePlan> alternatives = leafOf(dag).getPlanAlternatives();  
        return new TableScan(cluster, cluster.traitSet(), List.of(), table) {  
                @Override  
import org.apache.calcite.plan.hep.HepPlanner;
        return Map.of("status", Map.of("type", "text", "index", false));  
import org.apache.calcite.rel.core.TableScan;
import org.opensearch.analytics.spi.AggregateCapability;
        Map<String, Map<String, Object>> fieldMappings,
        OperandTypes.ANY,  
import org.opensearch.cluster.metadata.MappingMetadata;
        when(indexMetadata.mapping()).thenReturn(mappingMetadata);
        assertEquals("lucene", alternatives.getFirst().backendId());
import org.opensearch.analytics.spi.ExchangeSinkProvider;  
 * Tests for {@link PlanAlternativeSelector} executed against the real {@link LuceneAnalyticsBackendPlugin}.
        assertEquals(1, alternatives.size());  
        BackendPlanAdapter.adaptAll(dag, context.getCapabilityRegistry());
        }
     *  fields prevent Calcite's SEARCH/Sarg fold of multi-EQUALS-on-same-field. */
        return Map.of("status", Map.of("type", "keyword", "index", true));
            "sum_status"  
                ) {
        rexBuilder = new RexBuilder(typeFactory);
    private static class StubDfBackend implements AnalyticsSearchBackendPlugin {  
    private ClusterService mockClusterService() {  
            rexBuilder.makeLiteral("200")  
            return (context, backendContext) -> null;
     * for plan forking, exchange-sinks for the coordinator reduce. No delegation —  
                public Set<ScanCapability> scanCapabilities() {  
                public Optional<InstructionNode> createFinalAggregateNode() {
     * aggregate, so the SUM operator narrows to parquet regardless of where the field is  
     * Qualified shape: {@code COUNT(*)} over a keyword field with both parquet doc values and a
            -1,  
        builder.add("message", typeFactory.createSqlType(SqlTypeName.VARCHAR));  
                    int delegatedPredicateCount,
 */  
        RelNode plan = aggregate(LogicalFilter.create(scan, condition), countStar(scan));
    }
        RelNode plan = aggregate(LogicalFilter.create(scan, condition), countStar(scan));
            rexBuilder.makeLiteral(query)
     * leaves are Lucene-delegatable (two keyword EQUALS on distinct fields + one MATCH on  
        RelNode plan = aggregate(scan, sum);
    /**  
        super.setUp();  
import org.opensearch.analytics.planner.FieldStorageResolver;
    }
                    );
 */
        @Override
     * Disqualified shape: {@code COUNT(*)} over an INTEGER field. Production Lucene's
                    return Optional.empty();  
        return stage;  
 *
                    )) {
import org.opensearch.analytics.spi.EngineCapability;
import org.opensearch.common.util.concurrent.ThreadContext;
    }
 *
    private static final IndexNameExpressionResolver TEST_RESOLVER = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));
        RelNode plan = aggregate(scan, countStar(scan));
 * compatible open source license.
        public BackendCapabilityProvider getCapabilityProvider() {
    }
        when(table.getQualifiedName()).thenReturn(List.of("test_index"));
                    return innerBytes;
            };
        OperationRouting routing = mock(OperationRouting.class);  
     */
        ClusterState clusterState = mock(ClusterState.class);
                        caps.add(new FilterCapability.Standard(op, TYPES, Set.of("parquet")));  
import org.opensearch.cluster.routing.OperationRouting;
        );
    }
import org.opensearch.analytics.planner.dag.StagePlan;
        RelNode plan = aggregate(scan, countStar(scan));  
     * Depth-3: {@code COUNT(*) WHERE tag='a' OR region='eu' OR message MATCH 'x'}. All three
        public FragmentInstructionHandlerFactory getInstructionHandlerFactory() {
            Map.of("type", "keyword", "index", true)  
        return Map.of("status", Map.of("type", "integer"));
    /**  
            SqlStdOperatorTable.COUNT,  
import org.opensearch.analytics.spi.FragmentInstructionHandlerFactory;
                }  
        }
        when(table.getRowType()).thenReturn(rowType);
    @Override
import java.util.Map;  
            Map.of("type", "text", "index", true),
     *  Lucene-delegatable. */
                        ScalarFunction.EQUALS,
     * same Filter — all four leaves Lucene-delegatable on distinct fields. Lucene drives.  
            TYPES.add(FieldType.BOOLEAN);
                    return Optional.of(  
            -1,  
                @Override  
                    return Set.of(new ScanCapability.DocValues(Set.of("parquet"), TYPES));
import org.opensearch.analytics.spi.ScanCapability;
            scan,
    private RexBuilder rexBuilder;
        assertEquals(1, alternatives.size());  
    public void setUp() throws Exception {
            rexBuilder.makeLiteral(value)
                public Optional<InstructionNode> createFilterDelegationNode(  
            TYPES.addAll(FieldType.keyword());
import org.apache.calcite.rel.type.RelDataTypeFactory;  
import java.util.List;
                    return caps;
        RexNode right = rexBuilder.makeCall(SqlStdOperatorTable.AND, equalsLit(2, SqlTypeName.VARCHAR, "eu"), matchOn(1, "y"));
    }  
        TableScan scan = threeFieldScan();  
        when(routing.searchShards(any(), any(), any(), any())).thenReturn(new GroupShardsIterator<ShardIterator>(List.of()));  
     * Disqualified shape: {@code COUNT(*)} over a TEXT field with {@code index: false}. Even
 * selection happens before conversion, mirroring {@code DefaultPlanExecutor.executeInternal}).  
                @Override  
        return new PlannerContext(new CapabilityRegistry(backends, fieldStorageFactory), clusterState, null, false, preferMetadataDriver);  
     * Nested AND inside OR, all four leaves Lucene-delegatable on distinct fields. Lucene
        null,
        );  
        );
                @Override
     * Calcite flattens OR-of-ORs, so authoring nested ORs and a flat 4-arm OR produce the
     * 4-arm flat OR: {@code COUNT(*) WHERE tag='a' OR msg MATCH 'x' OR region='eu' OR msg MATCH 'y'}.
        AnalyticsSearchBackendPlugin luceneBackend = new LuceneAnalyticsBackendPlugin(null);
        }
        SqlFunctionCategory.USER_DEFINED_FUNCTION
     */
    /**  
        assertEquals("mock-parquet", alternatives.getFirst().backendId());
                .build()  
        while (!stage.getChildStages().isEmpty()) {  
 * <p>Pipeline executed: {@code PlanForker} → {@code PlanAlternativeSelector} (no convertor —
            matchOn(1, "y")  
        );  
        QueryDAG dag = forkAndSelect(plan, integerMappings(), true);  
/*  
import org.opensearch.analytics.planner.dag.PlanAlternativeSelector;  
                public Set<AggregateCapability> aggregateCapabilities() {  
import org.opensearch.analytics.spi.ShardScanWithDelegationInstructionNode;  
                public Set<FilterCapability> filterCapabilities() {
     */
package org.opensearch.be.lucene;
        return LogicalAggregate.create(input, ImmutableBitSet.of(), null, List.of(calls));
        QueryDAG dag = forkAndSelect(plan, keywordMappings(), true);  
    }
                }
        private static final Set<FieldType> TYPES = new HashSet<>();
                @Override
                    for (ScalarFunction op : Set.of(
    // ---- Mappings ----
        AnalyticsSearchBackendPlugin dfBackend = new StubDfBackend();
import org.apache.calcite.rel.core.AggregateCall;
        return dag;
        TableScan scan = scanOver("status", SqlTypeName.INTEGER);
                public byte[] attachFragmentOnTop(RelNode fragment, byte[] innerBytes) {
import org.apache.calcite.sql.type.OperandTypes;
        assertEquals("lucene", alternatives.getFirst().backendId());  
        RelNode plan = aggregate(scan, countStar(scan));
    public void testSumOverIntegerField_luceneNeverDrivesSum() {  
        Metadata metadata = mock(Metadata.class);
                    List<DelegatedExpression> delegatedExpressions  
                    String logicalTableName
                @Override
import org.apache.calcite.plan.RelOptTable;  
        when(table.getRowType()).thenReturn(rowType);
import org.opensearch.analytics.planner.dag.QueryDAG;
    private RelDataTypeFactory typeFactory;  
import org.apache.calcite.rex.RexNode;
import org.apache.calcite.plan.hep.HepProgramBuilder;
            matchOn(1, "x"),
        assertEquals("mock-parquet", alternatives.getFirst().backendId());
    public void testCountStarWithDepth4NestedAndOrAllDelegatable_selectsLucene() {
import org.opensearch.analytics.spi.BackendCapabilityProvider;
        }
import static org.mockito.Mockito.when;
 * <p>Lives in the lucene module (rather than analytics-engine) so the production capability surface  
import org.apache.calcite.plan.RelOptCluster;
        RelNode plan = aggregate(scan, countStar(scan));
        List<StagePlan> alternatives = leafOf(dag).getPlanAlternatives();
                }
 *
        RelNode plan = aggregate(LogicalFilter.create(scan, equalsLiteral), countStar(scan));
                }  
        TableScan scan = threeFieldScan();  
            List.of(),
     * Qualified-but-narrowed shape: {@code COUNT(*) WHERE status='200'} over a Lucene-indexed  
     * lucene index. Forker emits {@code [lucene, mock-parquet]}; with prefer=true the selector
    }
            };
                public Set<DelegationType> supportedDelegations() {
                    throw new UnsupportedOperationException("mock");
import org.opensearch.analytics.spi.FilterCapability;
            "message",  
        RexNode equalsLiteral = rexBuilder.makeCall(  
import org.opensearch.analytics.spi.FragmentConvertor;
    public void testCountStarOverNonIndexedTextField_luceneNeverViable() {
        };
import org.opensearch.cluster.metadata.Metadata;
        when(indexMetadata.getIndex()).thenReturn(new Index("test_index", "uuid"));
        return rexBuilder.makeCall(
    public void testCountStarOverIndexedKeyword_selectsLucene() {
                }  
        return Map.of(  
import org.apache.calcite.sql.SqlOperator;  
import org.apache.calcite.util.ImmutableBitSet;
        }
import org.opensearch.analytics.planner.PlannerImpl;  
import org.opensearch.analytics.planner.dag.Stage;  
    /** MATCH on a text-typed field; mirrors the SqlFunction shape used by other Lucene tests. */  
    private RelOptCluster cluster;
            scan,
     * holds and the selector still picks Lucene with prefer=true.
        public FragmentConvertor getFragmentConvertor() {
    }  
        QueryDAG dag = forkAndSelect(plan, keywordMappings(), true);
        AggregateCall sum = AggregateCall.create(
        static {
    private static Map<String, Map<String, Object>> threeFieldMappings() {
        RelDataTypeFactory.Builder builder = typeFactory.builder();
    private TableScan scanOver(String fieldName, SqlTypeName type) {
                }  
                    return Optional.of(new FilterDelegationInstructionNode(treeShape, delegatedPredicateCount, delegatedExpressions));
        QueryDAG dag = forkAndSelect(plan, nonIndexedTextMappings(), true);
        );
        QueryDAG dag = forkAndSelect(plan, keywordMappings(), false);
        RexNode regionEu = equalsLit(2, SqlTypeName.VARCHAR, "eu");
        assertEquals("selector should collapse to a single alternative", 1, alternatives.size());
                    int delegatedPredicateCount,
                        new AggregateCapability(AggregateFunction.SUM, TYPES, Set.of("parquet"))  
    /**
        assertEquals("mock-parquet", alternatives.getFirst().backendId());
    }
        QueryDAG dag = forkAndSelect(plan, integerMappings(), true);  
     * Depth-4: {@code COUNT(*) WHERE (tag='a' AND msg MATCH 'x') OR (region='eu' AND msg MATCH 'y')}.
        assertEquals(1, alternatives.size());
     */  
            "tag",
    /**
        assertEquals(1, alternatives.size());  
        MappingMetadata mappingMetadata = mock(MappingMetadata.class);  
        TableScan scan = scanOver("status", SqlTypeName.INTEGER);
        assertEquals("lucene", alternatives.getFirst().backendId());  
import org.apache.calcite.sql.type.ReturnTypes;  
                }
     */
        List<StagePlan> alternatives = leafOf(dag).getPlanAlternatives();
        RelDataType rowType = builder.build();
     * we don't need it for selector tests.
    }
    private static Map<String, Map<String, Object>> nonIndexedTextMappings() {
    private RelNode aggregate(RelNode input, AggregateCall... calls) {  
        QueryDAG dag = forkAndSelect(plan, threeFieldMappings(), true);
            return new FragmentInstructionHandlerFactory() {
     * via convertFragment; combiner not invoked.
        QueryDAG dag = forkAndSelect(plan, threeFieldMappings(), true);
                .put("index.composite.primary_data_format", "parquet")
 * this file be licensed under the Apache-2.0 license or a
}
import org.apache.calcite.rel.logical.LogicalAggregate;  
                @Override
     * collapses the leaf to {@code [lucene]}.  
import org.opensearch.analytics.spi.AggregateFunction;  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0),
import java.util.Optional;
    }
                }
            Settings.builder()  
            equalsLit(0, SqlTypeName.VARCHAR, "a"),  
                @Override
    }
                    );
    }
        RelNode plan = aggregate(LogicalFilter.create(scan, condition), countStar(scan));
    /**  
        @Override
        @Override  
        builder.add("region", typeFactory.createSqlType(SqlTypeName.VARCHAR));
    /**  
            SqlStdOperatorTable.EQUALS,  
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        @Override
            false,
        RexNode condition = rexBuilder.makeCall(
        assertEquals("lucene", alternatives.getFirst().backendId());  
            TYPES.addAll(FieldType.numeric());  
        RexNode tagA = equalsLit(0, SqlTypeName.VARCHAR, "a");  
import java.util.function.Function;  
     * numerics, so the table-scan rule never marks Lucene viable — irrespective of the field's  
        ClusterService clusterService = mock(ClusterService.class);
import org.opensearch.analytics.spi.DelegationType;
        List<StagePlan> alternatives = leafOf(dag).getPlanAlternatives();
        RelOptTable table = mock(RelOptTable.class);  
        RelDataTypeFactory.Builder builder = typeFactory.builder();  
            };  
    private PlannerContext buildContext(
    private RexNode matchOn(int fieldIndex, String query) {
        List<StagePlan> alternatives = leafOf(dag).getPlanAlternatives();
    private RexNode equalsLit(int fieldIndex, SqlTypeName type, String value) {
        when(mappingMetadata.sourceAsMap()).thenReturn(Map.of("properties", fieldMappings));
    }
import org.opensearch.analytics.spi.FilterTreeShape;
        IndexMetadata indexMetadata = mock(IndexMetadata.class);  
import org.opensearch.analytics.planner.CapabilityRegistry;  
                        new ShardScanWithDelegationInstructionNode(treeShape, delegatedPredicateCount, requestsRowIds, logicalTableName)
     * {@code index} mapping setting.
        builder.add("tag", typeFactory.createSqlType(SqlTypeName.VARCHAR));
        return rexBuilder.makeCall(
        when(clusterState.metadata()).thenReturn(metadata);  
     * {@code Index(supportedFieldTypes = {KEYWORD, TEXT, MATCH_ONLY_TEXT})} cap excludes
        ClusterState clusterState = mock(ClusterState.class);
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), fieldIndex),
    /**
        TableScan scan = threeFieldScan();
    private TableScan threeFieldScan() {  
                .putList("index.composite.secondary_data_formats", "lucene")
    );
    // ---- Cluster state / context ----
                }
                public byte[] attachPartialAggOnTop(RelNode partialAggFragment, byte[] innerBytes) {  
     */  
     * never silently pick Lucene when the cluster has flipped the setting off.  
        return clusterService;
import org.opensearch.cluster.routing.GroupShardsIterator;  
     */
    public void testCountStarWithIndexedKeywordFilter_selectsLucene() {
                        ScalarFunction.GREATER_THAN_OR_EQUAL,
     * keyword field. EQUALS on KEYWORD is in Lucene's filter caps, so end-to-end agreement
        Function<IndexMetadata, FieldStorageResolver> fieldStorageFactory = FieldStorageResolver::new;
     */  
     * explicitly false — Lucene has no inverted-index segment to drive a count against.
                    return Set.of(EngineCapability.SORT);
import org.opensearch.core.index.Index;  
            rexBuilder.makeInputRef(typeFactory.createSqlType(type), fieldIndex),
                public Set<EngineCapability> supportedEngineCapabilities() {
import org.opensearch.analytics.planner.PlannerContext;
        assertEquals(1, alternatives.size());
