        RelNode current = RelNodeUtils.unwrapHep(root);
    /**  
    ) {
        RelNode current = rel;
import org.apache.calcite.rex.RexNode;
        return buildContext(primaryFormat, 2, fieldMappings, backends);
        when(table.getQualifiedName()).thenReturn(List.of(tableName));
            false,
        String primaryFormat,
        }  
        return node;  
                        "date",
                    ),
 * Shared test infrastructure for planner rule tests.
import org.apache.calcite.sql.SqlOperator;
     * operator below the root ER call this to peel it.
        return LogicalAggregate.create(input, List.of(), groupSet, null, List.of(aggCalls));
            SqlFunctionCategory.USER_DEFINED_FUNCTION,  
                "status",
        }
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);  
                    + expectedType.getSimpleName()
import org.apache.calcite.rel.RelFieldCollation;  
            List.of(),
            MappingMetadata mappingMetadata = mock(MappingMetadata.class);
        static MockStorageBackend lucene() {
    }  
 */  
        return AggregateCall.create(
     * expected type is a different logical operator — ERs are trait-driven gather
            "cnt"  
                        "integer",
    /**
import org.opensearch.analytics.planner.rel.OpenSearchLateMaterialization;
            current = RelNodeUtils.unwrapHep(current.getInputs().get(0));  
            false,
                FieldType.INTEGER,
     * {@code COUNT(DISTINCT $1)} — single-arg distinct. The HEP {@code OpenSearchDistinctCountRule}
    /**
    protected PlannerContext buildContext(
    // TODO: AggregateRuleTests has private copies of these — replace with these shared versions.
import org.opensearch.cluster.routing.ShardIterator;
                    .build()
        Map<String, Object> mappingSource = Map.of("properties", fieldMappings);
        public EngineReaderManager<Object> createReaderManager(ReaderManagerConfig settings) {
            when(indexMetadata.getSettings()).thenReturn(
    }  
            OpenSearchRelNode osNode = (OpenSearchRelNode) current;
        rexBuilder = new RexBuilder(typeFactory);  
import org.opensearch.common.settings.ClusterSettings;  
    ) {  
            "checked_total_size"  
        Map<String, FieldStorageInfo> fieldStorage,
        }  
                        "text",
     * and has viableBackends containing all expectedBackends.
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
     * marks the aggregate.
        Set<String> expectedBackends
    protected LogicalSort makeLimit(RelNode input, int fetch) {
        for (var entry : funcToTypes.entrySet()) {
                List.of(),  
import org.apache.calcite.rel.logical.LogicalSort;  
            rexBuilder.makeLiteral(fetch, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        if (node instanceof OpenSearchExchangeReducer reducer) {  
            -1,  
        }
            IndexMetadata indexMetadata = mock(IndexMetadata.class);
 *
    protected SqlAggFunction checkedLongSumOperator() {
import org.apache.calcite.rel.RelNode;
    protected RelNode unwrapExchange(RelNode node) {
            return formatName;
            when(indexMetadata.getIndex()).thenReturn(new Index(indexName, indexName + "-uuid"));  
import static org.mockito.Mockito.mock;  
        when(table.getRowType()).thenReturn(rowType);  
    static class MockStorageBackend implements SearchBackEndPlugin<Object> {
        List<AnalyticsSearchBackendPlugin> backends
import org.apache.calcite.rel.RelCollation;
            caps.add(new AggregateCapability(entry.getKey(), entry.getValue(), formats));  
            null,  
            -1,
            "dc"  
            rexBuilder.makeInputRef(type, fieldIndex),
import org.apache.calcite.plan.RelOptTable;  
    protected RelDataTypeFactory typeFactory;
        return buildContextPerIndex(primaryFormat, Map.of("test_index", shardCount), fieldMappings, backends);  
            return new MockStorageBackend(
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, Set.of(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING));
            when(indexMetadata.mapping()).thenReturn(mappingMetadata);
            input,  
package org.opensearch.analytics.planner;
    }
    }
    protected AggregateCall countStarCall() {
            int shardCount = entry.getValue();  
    }
        @Override
import org.apache.calcite.rel.logical.LogicalFilter;
        Map<String, Integer> shardCountByIndex,  
    protected PlannerContext buildContextPerIndex(
    }
    // ---- Cluster service ----
            when(mappingMetadata.sourceAsMap()).thenReturn(mappingSource);  
        int shardCount,  
                MockLuceneBackend.LUCENE_DATA_FORMAT,
        Function<IndexMetadata, FieldStorageResolver> fieldStorageFactory = idx -> new FieldStorageResolver(fieldStorage);  
    }
                osNode.getViableBackends().containsAll(expectedBackends)
    }
 * Subclasses get mock backends, cluster state builders, table builders,
    protected LogicalAggregate makeAggregate(AggregateCall aggCall) {  
    protected AggregateCall sumCall() {  
        ) {
        when(indexMetadata.getIndex()).thenReturn(new Index("test_index", "uuid"));
import org.apache.calcite.rel.core.TableScan;  
    protected AggregateCall sumCall(RelNode input) {
                        Set.of(FieldTypeCapabilities.Capability.POINT_RANGE, FieldTypeCapabilities.Capability.STORED_FIELDS)
        }
        for (Map.Entry<String, Integer> entry : shardCountByIndex.entrySet()) {
                "size",
            List.of(1),
    protected RelOptTable mockTable(String tableName, String[] fieldNames, SqlTypeName[] fieldTypes) {
    }
            input,
        };
            return List.of(formatName);  
            ReturnTypes.BIGINT_FORCE_NULLABLE,  
        );
import org.apache.calcite.rex.RexBuilder;  
import static org.mockito.Mockito.when;
                List.of(),  
            "avg_size"
    @Override
                    .put("index.composite.primary_data_format", primaryFormat)  
/**  
import org.opensearch.cluster.service.ClusterService;
            SqlStdOperatorTable.COUNT,  
        for (String fieldName : fieldNames) {  
        }
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
import org.apache.calcite.sql.type.OperandTypes;
    protected LogicalAggregate makeMultiCallAggregate(AggregateCall... aggCalls) {
        );
    protected static Set<AggregateCapability> aggCaps(Set<String> formats, Map<AggregateFunction, Set<FieldType>> funcToTypes) {  
        public String name() {  
    }  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        RelDataTypeFactory.Builder rowTypeBuilder = typeFactory.builder();  
                    .putList("index.composite.secondary_data_formats", "lucene")
import java.util.Arrays;
     */
            false,  
                "integer",  
    protected RexNode makeCall(SqlOperator operator, RexNode... operands) {
                        Set.of(FieldTypeCapabilities.Capability.POINT_RANGE, FieldTypeCapabilities.Capability.STORED_FIELDS)  
                )
        );  
import java.util.Map;
    protected RexBuilder rexBuilder;  
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;
}
            if (i < expectedTypes.size() - 1) {  
    @SuppressWarnings("unchecked")  
        return buildContext(primaryFormat, shardCount, fieldMappings, List.of(DATAFUSION, LUCENE));
            "status",
            this.formatName = formatName;  
import org.opensearch.action.search.TransportSearchAction;  
     * Builds a PlannerContext with explicit per-field storage — for hybrid index tests
    public void setUp() throws Exception {  
                    new FieldTypeCapabilities(  
    // ---- Shared field helpers ----
            "dc"
import org.apache.calcite.rel.type.RelDataType;
        when(routing.searchShards(any(), any(), any(), any())).thenReturn(new GroupShardsIterator<ShardIterator>(List.of()));
        return buildContext(primaryFormat, 2, fieldMappings, List.of(DATAFUSION, LUCENE));
    }  
                    + osNode.getViableBackends(),  
        when(clusterState.metadata()).thenReturn(metadata);
    /**
            this.fieldCaps = fieldCaps;
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;  
                )
import org.apache.calcite.sql.SqlFunctionCategory;  
    }
    protected AggregateCall approxCountDistinctCall(RelNode input) {
        );
        @Override  
            SqlStdOperatorTable.AVG,
            typeFactory.createSqlType(SqlTypeName.BIGINT),
    /**
        String primaryFormat,  
 * this file be licensed under the Apache-2.0 license or a
     * {@code null} return type so Calcite infers AVG's canonical type; the short-form  
                    )  
                    + expectedBackends
     * (the common case when scans are at SOURCE kind). Tests that want to inspect the  
    /** Sort with fetch (LIMIT) only — no ORDER BY collation, just top-N. */
    }
        Map<String, Map<String, Object>> fieldMappings,  
import java.util.HashSet;
        // COUNT(*) — no field arguments, always gets annotated with aggregateCapableBackends
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;  
    protected AggregateCall countDistinctCall(RelNode input) {  
    protected RelOptCluster cluster;
        for (int index = 0; index < fieldNames.length; index++) {
     */
        }
public abstract class BasePlannerRulesTests extends OpenSearchTestCase {
    private static RelNode skipExchangeReducers(RelNode rel) {  
            return null;
     * points, not part of the logical pipeline. Tests that *do* want to verify an
            super(cluster, traitSet, List.of(), table);
            Optionality.FORBIDDEN  
     * Models the "duplicated doc values" persona — both backends can natively scan  
    }
import org.opensearch.cluster.metadata.IndexMetadata;
    }  
        // OpenSearchJoinSplitRule produces. Tests that exercise MPP (broadcast / hash) build
            false,
            )  
            );
        }
            rexBuilder.makeLiteral(query)  
            SqlStdOperatorTable.APPROX_COUNT_DISTINCT,  
        when(indexMetadata.getNumberOfShards()).thenReturn(shardCount);
    /**  
    }
        IndexMetadata indexMetadata = mock(IndexMetadata.class);  
                Settings.builder()
        );
            -1,
                MockDataFusionBackend.PARQUET_DATA_FORMAT,
    protected RelNode runPlanner(RelNode input, PlannerContext context) {
                        "keyword",
            rowTypeBuilder.add(fieldNames[index], typeFactory.createSqlType(fieldTypes[index]));
                    new FieldTypeCapabilities("date", Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE))  
import java.util.List;  
import org.opensearch.core.index.Index;  
        return mockTable(tableName, fieldNames, types);
            null,
    // ---- Context builders ----
        ClusterState clusterState = mock(ClusterState.class);  
    // ---- Stub ----
            -1,  
            String indexName = entry.getKey();
            );  
        );
                    new FieldTypeCapabilities("keyword", Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE)),  
    ) {  
    }
        RelNode unwrapped = RelNodeUtils.unwrapHep(node);
            -1,  
import org.apache.calcite.util.ImmutableBitSet;
                List.of(MockDataFusionBackend.PARQUET_DATA_FORMAT, MockLuceneBackend.LUCENE_DATA_FORMAT),
            org.apache.calcite.rel.RelCollations.EMPTY,
    }  
     */
    }  
    protected static Map<String, Map<String, Object>> intFields() {  
    protected RexNode makeEquals(int fieldIndex, SqlTypeName fieldType, Object value) {
    protected static void assertPipelineViableBackends(
import static org.mockito.ArgumentMatchers.any;
import org.apache.calcite.sql.SqlAggFunction;
    }
import org.opensearch.analytics.spi.FieldStorageInfo;
    protected LogicalAggregate makeAggregate(RelNode input, AggregateCall... aggCalls) {
    protected PlannerContext buildContextWithExplicitStorage(
        return PlannerImpl.runAllOptimizations(input, context);
            null,
        return current;
        ClusterState clusterState = mock(ClusterState.class);
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), fieldIndex),
                    new FieldTypeCapabilities("integer", Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE)),
            SqlKind.SUM,
    }
                    new FieldTypeCapabilities(
        OperationRouting routing = mock(OperationRouting.class);
    // ---- Shared aggregate helpers ----  
            RelCollations.EMPTY,
        return Map.of(
        // their own context with mpp.enabled=true.
            List.of(1),
                        "long",  
    protected static final IndexNameExpressionResolver TEST_RESOLVER = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));
    protected LogicalFilter makeFilter(RelNode input, RexNode condition) {  
import org.apache.calcite.sql.type.SqlTypeName;  
import org.opensearch.analytics.spi.AggregateCapability;
    }
    }
import org.opensearch.index.engine.exec.EngineReaderManager;  
    }
                        Set.of(FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH, FieldTypeCapabilities.Capability.STORED_FIELDS)
    }  
        // Default test settings: MPP off (see buildContextPerIndex for rationale).
            false,  
        );
        // plan shape — that's the M0 contract they were written for, and it's what  
    /** Sort with collation on field 0 ascending. Pass fetch of 0 or less for no limit. */
            typeFactory.createSqlType(SqlTypeName.BIGINT),
                Set.of(  
 */
        return LogicalSort.create(  
            rowTypeBuilder.add(fieldName, typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true));
            when(metadata.index(indexName)).thenReturn(indexMetadata);
        return caps;
     * The After-CBO root is wrapped in an {@link OpenSearchExchangeReducer} when the
                "Node at depth " + i + " must be " + expectedType.getSimpleName() + " but was " + current.getClass().getSimpleName(),
            false,
            var C = FieldTypeCapabilities.Capability.class;  
import org.apache.calcite.plan.hep.HepPlanner;
        super.setUp();
        RelOptTable table = mock(RelOptTable.class);
            false,
            input,  
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
            when(indexMetadata.getNumberOfShards()).thenReturn(shardCount);
            checkedLongSumOperator(),  
    protected LogicalAggregate makeMultiCallAggregate(RelNode input, AggregateCall... aggCalls) {
        return new PlannerContext(new CapabilityRegistry(backends, fieldStorageFactory), clusterState, testSettings);
        @Override
        return sumCall(stubScan(mockTable("test_index", "status", "size")));
        MockStorageBackend(String formatName, Set<FieldTypeCapabilities> fieldCaps) {
            1,  
    protected LogicalAggregate makeAggregate(RelNode input, ImmutableBitSet groupSet, AggregateCall... aggCalls) {  
    }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.metadata.MappingMetadata;  
import org.opensearch.cluster.routing.GroupShardsIterator;
 * compatible open source license.
     * and aggregate the same field.
        while (current instanceof OpenSearchExchangeReducer || current instanceof OpenSearchLateMaterialization) {
     *
    // ---- RexNode builders ----
        when(metadata.index("test_index")).thenReturn(indexMetadata);  
        return clusterService;
     */
            SqlStdOperatorTable.EQUALS,
            return new MockStorageBackend(
    /** Minimal SearchBackEndPlugin for test FieldStorageResolver construction. */  
     * tests that join across tables with asymmetric partitioning. All indices share
                    new FieldTypeCapabilities("long", Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE)),
    protected RexNode makeAnd(RexNode... operands) {
        when(clusterService.operationRouting()).thenReturn(routing);  
        for (int i = 0; i < expectedTypes.size(); i++) {
            SqlStdOperatorTable.COUNT,
        }  
            null,
            Class<? extends OpenSearchRelNode> expectedType = expectedTypes.get(i);  
        List<AnalyticsSearchBackendPlugin> backends
        return makeAggregate(input, ImmutableBitSet.of(0), aggCalls);  
            new FieldStorageInfo(
            OperandTypes.NUMERIC,
            input,
        Set<AggregateCapability> caps = new HashSet<>();
                    ),  
            List.of(1),
                    new FieldTypeCapabilities("text", Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE)),
    // ---- Table builders ----
    }  
     * ER at a specific depth list {@code OpenSearchExchangeReducer.class}  
                        Set.of(FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH, FieldTypeCapabilities.Capability.STORED_FIELDS)  
    protected PlannerContext buildContext(String primaryFormat, int shardCount, Map<String, Map<String, Object>> fieldMappings) {
        return rexBuilder.makeCall(operator, operands);
        /** Parquet/DataFusion: COLUMNAR_STORAGE for all types */
    }
                    new FieldTypeCapabilities(  
        }  
    /** {@code APPROX_COUNT_DISTINCT($1)} — direct (skips the rewrite for tests that pre-stage the operator). */  
    // ---- Plan execution ----
            null,
            List.of(),
                    + " but was "
import org.apache.calcite.sql.type.ReturnTypes;
        RexNode fetchRex = fetch > 0 ? rexBuilder.makeLiteral(fetch, typeFactory.createSqlType(SqlTypeName.INTEGER), true) : null;
        typeFactory = new JavaTypeFactoryImpl();
        Map<String, Map<String, Object>> fieldMappings,
        RelDataTypeFactory.Builder rowTypeBuilder = typeFactory.builder();
            input,
        RelNode root,  
            assertTrue(
    }
            false,
            input,
        return countStarCall(stubScan(mockTable("test_index", "status", "size")));  
                    new FieldTypeCapabilities(
    }  
import org.opensearch.analytics.spi.FieldType;
import org.opensearch.cluster.metadata.Metadata;
    }  
    private RelOptTable mockTable(String tableName, RelDataType rowType) {  
                    ),
    protected ClusterService mockClusterService() {
        return mockTable(tableName, rowTypeBuilder.build());
        Map<String, Map<String, Object>> fieldMappings,
    protected AggregateCall countStarCall(RelNode input) {  
        );
                current = skipExchangeReducers(current);
import org.apache.calcite.plan.hep.HepProgramBuilder;  
        cluster = RelOptCluster.create(planner, rexBuilder);
            );
import org.apache.calcite.sql.SqlKind;
    }
        return LogicalSort.create(input, collation, null, fetchRex);  
        SqlTypeName[] types = Arrays.stream(fieldNames).map(name -> SqlTypeName.INTEGER).toArray(SqlTypeName[]::new);
     */
    protected AggregateCall avgCall(RelNode input) {  
        ClusterState clusterState = mock(ClusterState.class);
    @SuppressWarnings("unchecked")
                current = RelNodeUtils.unwrapHep(current.getInputs().get(0));
        return makeMultiCallAggregate(stubScan(mockTable("test_index", "status", "size")), aggCalls);
    }
            -1,  
            null,  
                    new FieldTypeCapabilities("boolean", Set.of(FieldTypeCapabilities.Capability.STORED_FIELDS)),
 * and plan execution helpers.  
        return LogicalAggregate.create(input, List.of(), ImmutableBitSet.of(0), null, List.of(aggCalls));
import org.apache.calcite.rel.core.AggregateCall;
    protected RelOptTable mockTable(String tableName, String... fieldNames) {  
     * <p>TODO: extend to per-node expected backends when delegation is implemented.  
     * rewrites this to {@code APPROX_COUNT_DISTINCT($1)} before {@code OpenSearchAggregateRule}  
        );
                "integer",
        return AggregateCall.create(
            }
        );  
        Metadata metadata = mock(Metadata.class);  
    /**
import org.opensearch.plugins.SearchBackEndPlugin;
    protected AggregateCall checkedLongSumCall(RelNode input) {
    }
                List.of(MockDataFusionBackend.PARQUET_DATA_FORMAT, MockLuceneBackend.LUCENE_DATA_FORMAT),
        when(clusterState.metadata()).thenReturn(metadata);
                expectedType.isInstance(current)  
    protected RelOptTable mockNullableTable(String tableName, String... fieldNames) {
     * where a field has doc values in multiple formats (e.g. parquet + lucene).  
            function,
     * AVG over the second column. Uses the long-form {@link AggregateCall#create} with a
        return unwrapped;
import org.opensearch.common.settings.Settings;
        Metadata metadata = mock(Metadata.class);
        Settings testSettings = Settings.builder().put("analytics.mpp.enabled", false).build();  
import org.apache.calcite.rel.logical.LogicalAggregate;
     * Builds a context where different indices have different shard counts — for
import org.apache.calcite.util.Optionality;
import org.opensearch.test.OpenSearchTestCase;
        /** Lucene: POINT_RANGE + STORED_FIELDS for numerics/dates, FULL_TEXT_SEARCH + STORED_FIELDS for text/keyword */
    }
    protected PlannerContext buildContext(String primaryFormat, Map<String, Map<String, Object>> fieldMappings) {
        ClusterService clusterService = mock(ClusterService.class);
        return AggregateCall.create(
                List.of(),
        return new PlannerContext(new CapabilityRegistry(backends, fieldStorageFactory), clusterState, testSettings);
                Set.of(  
        return AggregateCall.create(
        return Map.of("status", Map.of("type", "integer"), "size", Map.of("type", "integer"));
        RelCollation collation = RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.ASCENDING));
/*  
                    ),
        return makeAggregate(stubScan(mockTable("test_index", "status", "size")), aggCall);
 * SPDX-License-Identifier: Apache-2.0
    }
                FieldType.INTEGER,  
                List.of(),
            1,
import org.apache.calcite.rel.RelCollations;
            return RelNodeUtils.unwrapHep(reducer.getInput());  
     * the same field mappings and primary format.  
        return rexBuilder.makeCall(  
        }
                    new FieldTypeCapabilities("boolean", Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE)),
        when(clusterService.state()).thenReturn(clusterState);
        private final String formatName;
import java.util.Set;
        Function<IndexMetadata, FieldStorageResolver> fieldStorageFactory = FieldStorageResolver::new;
        }  
        List<AnalyticsSearchBackendPlugin> backends
import org.apache.calcite.plan.RelOptCluster;
            false,
    protected static final MockLuceneBackend LUCENE = new MockLuceneBackend();
        String primaryFormat,
                        Set.of(FieldTypeCapabilities.Capability.POINT_RANGE, FieldTypeCapabilities.Capability.STORED_FIELDS)
    }
     *
                "Node "
        return new StubTableScan(cluster, cluster.traitSet(), table);
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    }
                    new FieldTypeCapabilities(
            "size",  
            List.of(1),
            input.getRowType().getFieldList().get(1).getType(),
        // Default test settings: MPP off. Most planner-rule tests pin the COORDINATOR_CENTRIC
    protected RelNode unwrapRootReducer(RelNode node) {  
    }  
        }  
    }  
            if (!OpenSearchExchangeReducer.class.isAssignableFrom(expectedType)) {
        return buildContextPerIndex(primaryFormat, shardCountByIndex, intFields(), List.of(DATAFUSION, LUCENE));  
import org.opensearch.analytics.spi.AggregateFunction;
        Settings testSettings = Settings.builder().put("analytics.mpp.enabled", false).build();  
            );
        return LogicalFilter.create(input, condition);
    protected Map<String, FieldStorageInfo> duplicatedIntFields() {  
            SqlStdOperatorTable.SUM,  
            true,  
import org.opensearch.cluster.routing.OperationRouting;  
            }  
    protected TableScan stubScan(RelOptTable table) {
     * <p>{@link OpenSearchExchangeReducer} nodes are skipped at depths where the  
        List<AnalyticsSearchBackendPlugin> backends
            rexBuilder.makeLiteral(value, type, true)  
            new FieldStorageInfo(  
     * planner's top-level SINGLETON request isn't already satisfied by the subtree
        public List<String> getSupportedFormats() {
import org.apache.calcite.rel.type.RelDataTypeFactory;
        return AggregateCall.create(
     * Integer fields with doc values duplicated in both parquet and lucene formats.
        return new SqlAggFunction(
    ) {  
            input,
    protected static class StubTableScan extends TableScan {  
        int shardCount,
        }
import org.opensearch.cluster.ClusterState;  
     * Walks the single-input chain asserting each node matches the expected type  
            return reducer.getInput();
    /** Default resolver for DAGBuilder in tests; production injects core's resolver. */
     */
import java.util.function.Function;  
        RelDataType type = typeFactory.createSqlType(fieldType);
            assertTrue(  
        return rexBuilder.makeCall(  
import org.opensearch.common.util.concurrent.ThreadContext;
    }  
    }  
            List.of(1),
            false,
        if (unwrapped instanceof OpenSearchExchangeReducer reducer) {
            );
            null,
    protected static final MockDataFusionBackend DATAFUSION = new MockDataFusionBackend();
    }
            "total_size"  
            ),
     * overload passes an explicit type and would trip {@code Aggregate.typeMatchesInferred}.
    }
        return table;
    }
     * explicitly; the walk does not skip past it in that case.
                false
            List.of(),  
    protected LogicalSort makeSort(RelNode input, int fetch) {  
            typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true),
        }
                    + " viableBackends must contain "  
    /** Builds a set of AggregateCapability for the given function→fieldTypes mapping. */
    ) {  
    protected RexNode makeFullTextCall(SqlOperator function, int fieldIndex, String query) {
            "CHECKED_LONG_SUM",  
        private final Set<FieldTypeCapabilities> fieldCaps;  
        return mockTable(tableName, rowTypeBuilder.build());  
            false,
    protected PlannerContext buildContextPerIndex(String primaryFormat, Map<String, Integer> shardCountByIndex) {
        return AggregateCall.create(
                false
            org.apache.calcite.rel.RelCollations.EMPTY,
        static MockStorageBackend parquet() {  
        return rexBuilder.makeCall(SqlStdOperatorTable.AND, operands);
        StubTableScan(RelOptCluster cluster, RelTraitSet traitSet, RelOptTable table) {
import org.apache.calcite.plan.RelTraitSet;
     */
        List<Class<? extends OpenSearchRelNode>> expectedTypes,
    protected PlannerContext buildContext(  
import org.opensearch.index.engine.dataformat.ReaderManagerConfig;
