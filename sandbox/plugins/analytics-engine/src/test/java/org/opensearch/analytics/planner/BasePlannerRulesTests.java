        // their own context with mpp.enabled=true.
import org.opensearch.cluster.metadata.Metadata;
        );
        return node;
import org.opensearch.analytics.spi.AggregateFunction;
                List.of(MockDataFusionBackend.PARQUET_DATA_FORMAT, MockLuceneBackend.LUCENE_DATA_FORMAT),
            -1,
                    new FieldTypeCapabilities("long", Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE)),
        List<AnalyticsSearchBackendPlugin> backends
    }
import org.opensearch.core.index.Index;
    protected Map<String, FieldStorageInfo> duplicatedIntFields() {
import org.opensearch.common.settings.ClusterSettings;
            input,
                    new FieldTypeCapabilities("boolean", Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE)),
import org.apache.calcite.sql.SqlAggFunction;
                    new FieldTypeCapabilities("keyword", Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE)),
            null,
            input,
            return null;
    protected static final MockDataFusionBackend DATAFUSION = new MockDataFusionBackend();
    protected RelOptCluster cluster;
            false,
     * and has viableBackends containing all expectedBackends.
                    ),
            new FieldStorageInfo(
            IndexMetadata indexMetadata = mock(IndexMetadata.class);
            String indexName = entry.getKey();
        List<AnalyticsSearchBackendPlugin> backends
        // plan shape — that's the M0 contract they were written for, and it's what
            if (i < expectedTypes.size() - 1) {
    }
import org.apache.calcite.rel.logical.LogicalAggregate;
            typeFactory.createSqlType(SqlTypeName.BIGINT),
        rexBuilder = new RexBuilder(typeFactory);
     * ER at a specific depth list {@code OpenSearchExchangeReducer.class}
                "integer",
                osNode.getViableBackends().containsAll(expectedBackends)
    }
    // TODO: AggregateRuleTests has private copies of these — replace with these shared versions.
            List.of(),
        return new PlannerContext(new CapabilityRegistry(backends, fieldStorageFactory), clusterState, testSettings);
                    new FieldTypeCapabilities(
                List.of(MockDataFusionBackend.PARQUET_DATA_FORMAT, MockLuceneBackend.LUCENE_DATA_FORMAT),
            "dc"
        for (int i = 0; i < expectedTypes.size(); i++) {
        Function<IndexMetadata, FieldStorageResolver> fieldStorageFactory = FieldStorageResolver::new;
        Map<String, Object> mappingSource = Map.of("properties", fieldMappings);
        for (String fieldName : fieldNames) {
        return buildContextPerIndex(primaryFormat, shardCountByIndex, intFields(), List.of(DATAFUSION, LUCENE));
    }
}
            when(indexMetadata.mapping()).thenReturn(mappingMetadata);
        RexNode fetchRex = fetch > 0 ? rexBuilder.makeLiteral(fetch, typeFactory.createSqlType(SqlTypeName.INTEGER), true) : null;
            OpenSearchRelNode osNode = (OpenSearchRelNode) current;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        when(table.getRowType()).thenReturn(rowType);
        int shardCount,
    protected AggregateCall countDistinctCall(RelNode input) {
        }
     */
import org.opensearch.cluster.metadata.MappingMetadata;
 * SPDX-License-Identifier: Apache-2.0
            return formatName;
            -1,
            SqlStdOperatorTable.COUNT,
                List.of(),
    }
        @Override
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), fieldIndex),
            -1,
     * operator below the root ER call this to peel it.
        List<AnalyticsSearchBackendPlugin> backends
        /** Parquet/DataFusion: COLUMNAR_STORAGE for all types */
        when(table.getQualifiedName()).thenReturn(List.of(tableName));
    }
    }
     * planner's top-level SINGLETON request isn't already satisfied by the subtree
package org.opensearch.analytics.planner;
        RelDataType type = typeFactory.createSqlType(fieldType);
        return AggregateCall.create(
                Settings.builder()
                        Set.of(FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH, FieldTypeCapabilities.Capability.STORED_FIELDS)
    protected static Set<AggregateCapability> aggCaps(Set<String> formats, Map<AggregateFunction, Set<FieldType>> funcToTypes) {
    protected PlannerContext buildContextWithExplicitStorage(
    /** {@code APPROX_COUNT_DISTINCT($1)} — direct (skips the rewrite for tests that pre-stage the operator). */
        cluster = RelOptCluster.create(planner, rexBuilder);
            null,
                    .putList("index.composite.secondary_data_formats", "lucene")
                Set.of(
                        "text",
                    new FieldTypeCapabilities("boolean", Set.of(FieldTypeCapabilities.Capability.STORED_FIELDS)),
     *
        return rexBuilder.makeCall(
        when(clusterState.metadata()).thenReturn(metadata);
            SqlStdOperatorTable.APPROX_COUNT_DISTINCT,
    /**
        static MockStorageBackend lucene() {
import org.apache.calcite.sql.type.ReturnTypes;
            -1,
        public String name() {
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
    }
                        Set.of(FieldTypeCapabilities.Capability.POINT_RANGE, FieldTypeCapabilities.Capability.STORED_FIELDS)
        return AggregateCall.create(
        return buildContext(primaryFormat, 2, fieldMappings, backends);
            SqlStdOperatorTable.COUNT,
        return AggregateCall.create(
        return Map.of(
     * Builds a context where different indices have different shard counts — for
 * this file be licensed under the Apache-2.0 license or a
            OperandTypes.NUMERIC,
    protected TableScan stubScan(RelOptTable table) {
                        Set.of(FieldTypeCapabilities.Capability.POINT_RANGE, FieldTypeCapabilities.Capability.STORED_FIELDS)
     * rewrites this to {@code APPROX_COUNT_DISTINCT($1)} before {@code OpenSearchAggregateRule}
            current = RelNodeUtils.unwrapHep(current.getInputs().get(0));
        when(clusterService.operationRouting()).thenReturn(routing);
    ) {
    public void setUp() throws Exception {
        return makeAggregate(stubScan(mockTable("test_index", "status", "size")), aggCall);
    }
     */
        Map<String, FieldStorageInfo> fieldStorage,
    // ---- Shared aggregate helpers ----
        return LogicalFilter.create(input, condition);
import org.apache.calcite.sql.type.OperandTypes;
import org.opensearch.common.util.concurrent.ThreadContext;
        }
    // ---- Context builders ----
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
import org.apache.calcite.sql.SqlKind;
        if (node instanceof OpenSearchExchangeReducer reducer) {
        super.setUp();
        // OpenSearchJoinSplitRule produces. Tests that exercise MPP (broadcast / hash) build
            org.apache.calcite.rel.RelCollations.EMPTY,
     */
    }
                        "long",
            rexBuilder.makeLiteral(value, type, true)
            1,
        RelDataTypeFactory.Builder rowTypeBuilder = typeFactory.builder();
            input,
            );
                expectedType.isInstance(current)
    // ---- Shared field helpers ----
     * Models the "duplicated doc values" persona — both backends can natively scan
import org.apache.calcite.rel.type.RelDataTypeFactory;
            SqlStdOperatorTable.SUM,
        return makeAggregate(input, ImmutableBitSet.of(0), aggCalls);
            assertTrue(
     * The After-CBO root is wrapped in an {@link OpenSearchExchangeReducer} when the
    /** Default resolver for DAGBuilder in tests; production injects core's resolver. */
    // ---- Plan execution ----
            SqlStdOperatorTable.EQUALS,
            rowTypeBuilder.add(fieldName, typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true));
    /** Builds a set of AggregateCapability for the given function→fieldTypes mapping. */
 *
    protected RelOptTable mockTable(String tableName, String[] fieldNames, SqlTypeName[] fieldTypes) {
    protected static final MockLuceneBackend LUCENE = new MockLuceneBackend();
        }
import org.apache.calcite.rel.core.TableScan;
    protected static void assertPipelineViableBackends(
                "Node at depth " + i + " must be " + expectedType.getSimpleName() + " but was " + current.getClass().getSimpleName(),
        return AggregateCall.create(
    }
import org.opensearch.analytics.spi.AggregateCapability;
        /** Lucene: POINT_RANGE + STORED_FIELDS for numerics/dates, FULL_TEXT_SEARCH + STORED_FIELDS for text/keyword */
    // ---- RexNode builders ----
                    + expectedBackends
            false,
    /** Sort with fetch (LIMIT) only — no ORDER BY collation, just top-N. */
import org.opensearch.cluster.routing.OperationRouting;
import org.apache.calcite.sql.SqlFunctionCategory;
    }
        // COUNT(*) — no field arguments, always gets annotated with aggregateCapableBackends
            "cnt"
        return rexBuilder.makeCall(SqlStdOperatorTable.AND, operands);
    @SuppressWarnings("unchecked")
    }
        return clusterService;
                    .put("index.composite.primary_data_format", primaryFormat)
    // ---- Cluster service ----
        }
        Function<IndexMetadata, FieldStorageResolver> fieldStorageFactory = idx -> new FieldStorageResolver(fieldStorage);
        return LogicalAggregate.create(input, List.of(), groupSet, null, List.of(aggCalls));
            when(indexMetadata.getIndex()).thenReturn(new Index(indexName, indexName + "-uuid"));
        RelOptTable table = mock(RelOptTable.class);
import org.opensearch.analytics.planner.rel.OpenSearchLateMaterialization;
        }
    protected RelOptTable mockNullableTable(String tableName, String... fieldNames) {
                FieldType.INTEGER,
import org.apache.calcite.plan.hep.HepPlanner;
            "total_size"
            true,
            this.formatName = formatName;
import java.util.Set;
     */
        return LogicalSort.create(input, collation, null, fetchRex);
            MappingMetadata mappingMetadata = mock(MappingMetadata.class);
            typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true),
    protected LogicalAggregate makeAggregate(RelNode input, AggregateCall... aggCalls) {
        );
        }
            false,
                MockDataFusionBackend.PARQUET_DATA_FORMAT,
        return Map.of("status", Map.of("type", "integer"), "size", Map.of("type", "integer"));
        private final Set<FieldTypeCapabilities> fieldCaps;
import static org.mockito.ArgumentMatchers.any;
            false,
     */
    }
        typeFactory = new JavaTypeFactoryImpl();
        Set<String> expectedBackends
    }
    }
     * marks the aggregate.
    }
     * Walks the single-input chain asserting each node matches the expected type
    protected LogicalAggregate makeAggregate(RelNode input, ImmutableBitSet groupSet, AggregateCall... aggCalls) {
            var C = FieldTypeCapabilities.Capability.class;
            "size",
     * expected type is a different logical operator — ERs are trait-driven gather
            SqlStdOperatorTable.AVG,
                    new FieldTypeCapabilities(
    protected static Map<String, Map<String, Object>> intFields() {
            when(indexMetadata.getNumberOfShards()).thenReturn(shardCount);
            null,
            return new MockStorageBackend(
import org.opensearch.cluster.metadata.IndexMetadata;
            false,
        when(clusterState.metadata()).thenReturn(metadata);
                FieldType.INTEGER,
    }
                List.of(),
    }
        return rexBuilder.makeCall(operator, operands);
        }
            org.apache.calcite.rel.RelCollations.EMPTY,
import org.opensearch.index.engine.exec.EngineReaderManager;
import java.util.function.Function;
    }
                    new FieldTypeCapabilities(
            typeFactory.createSqlType(SqlTypeName.BIGINT),
    }
                "Node "
            List.of(1),
        );
                Set.of(
                    ),
        RelNode current = RelNodeUtils.unwrapHep(root);
        Map<String, Integer> shardCountByIndex,
                current = skipExchangeReducers(current);
                MockLuceneBackend.LUCENE_DATA_FORMAT,
            when(indexMetadata.getSettings()).thenReturn(
            return reducer.getInput();
    protected RexNode makeAnd(RexNode... operands) {
        ClusterService clusterService = mock(ClusterService.class);
import org.apache.calcite.rel.logical.LogicalFilter;
            if (!OpenSearchExchangeReducer.class.isAssignableFrom(expectedType)) {
/**
                        "integer",
            }
import static org.mockito.Mockito.mock;
        // Default test settings: MPP off (see buildContextPerIndex for rationale).
    protected LogicalFilter makeFilter(RelNode input, RexNode condition) {
            input.getRowType().getFieldList().get(1).getType(),
                        "date",
        );
     * Builds a PlannerContext with explicit per-field storage — for hybrid index tests
            "CHECKED_LONG_SUM",
                "status",
            Optionality.FORBIDDEN
        public EngineReaderManager<Object> createReaderManager(ReaderManagerConfig settings) {
    ) {
        Map<String, Map<String, Object>> fieldMappings,
            );
import org.opensearch.cluster.service.ClusterService;
    }
                "integer",
     *
                    + expectedType.getSimpleName()
        ) {
import org.apache.calcite.rel.core.AggregateCall;
    }
    protected PlannerContext buildContextPerIndex(
                    + osNode.getViableBackends(),
        return countStarCall(stubScan(mockTable("test_index", "status", "size")));
                    new FieldTypeCapabilities(
    }
        );
        }
import org.apache.calcite.sql.SqlOperator;
     */
    }
    // ---- Table builders ----
        return AggregateCall.create(
                false
        while (current instanceof OpenSearchExchangeReducer || current instanceof OpenSearchLateMaterialization) {
                    ),
        return new StubTableScan(cluster, cluster.traitSet(), table);
    /**
        @Override
        return buildContext(primaryFormat, shardCount, fieldMappings, List.of(DATAFUSION, LUCENE));
            false,
    protected static class StubTableScan extends TableScan {
            return new MockStorageBackend(
            input,
        RelDataTypeFactory.Builder rowTypeBuilder = typeFactory.builder();
import org.opensearch.cluster.ClusterState;
            List.of(1),
     * points, not part of the logical pipeline. Tests that *do* want to verify an
     * {@code null} return type so Calcite infers AVG's canonical type; the short-form
     * the same field mappings and primary format.
    /** Minimal SearchBackEndPlugin for test FieldStorageResolver construction. */
        Metadata metadata = mock(Metadata.class);
import org.apache.calcite.rex.RexBuilder;
    @Override
        return LogicalSort.create(
     * <p>{@link OpenSearchExchangeReducer} nodes are skipped at depths where the
     * Integer fields with doc values duplicated in both parquet and lucene formats.
        }
     * <p>TODO: extend to per-node expected backends when delegation is implemented.
import org.apache.calcite.rel.RelCollation;
        return PlannerImpl.runAllOptimizations(input, context);
    protected AggregateCall checkedLongSumCall(RelNode input) {
    ) {
            ReturnTypes.BIGINT_FORCE_NULLABLE,
            checkedLongSumOperator(),
/*
    protected RexNode makeCall(SqlOperator operator, RexNode... operands) {
            "avg_size"
import java.util.HashSet;
        RelNode unwrapped = RelNodeUtils.unwrapHep(node);
            -1,
            rexBuilder.makeInputRef(type, fieldIndex),
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
            "status",
    protected AggregateCall sumCall(RelNode input) {
    protected PlannerContext buildContext(String primaryFormat, int shardCount, Map<String, Map<String, Object>> fieldMappings) {
 */
import org.apache.calcite.plan.RelTraitSet;
    }
        RelCollation collation = RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.ASCENDING));
 */
            Class<? extends OpenSearchRelNode> expectedType = expectedTypes.get(i);
            null,
    /**
import org.opensearch.test.OpenSearchTestCase;
    protected PlannerContext buildContextPerIndex(String primaryFormat, Map<String, Integer> shardCountByIndex) {
        return mockTable(tableName, rowTypeBuilder.build());
        }
                        Set.of(FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH, FieldTypeCapabilities.Capability.STORED_FIELDS)
import org.apache.calcite.util.Optionality;
            )
    // ---- Stub ----
import java.util.List;
    protected LogicalSort makeLimit(RelNode input, int fetch) {
            1,
import org.apache.calcite.plan.RelOptTable;
            new FieldStorageInfo(
            );
        return sumCall(stubScan(mockTable("test_index", "status", "size")));
        return caps;
        ClusterState clusterState = mock(ClusterState.class);
        RelNode current = rel;
    protected RelOptTable mockTable(String tableName, String... fieldNames) {
    }
    }
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;
        return buildContextPerIndex(primaryFormat, Map.of("test_index", shardCount), fieldMappings, backends);
            List.of(1),
            this.fieldCaps = fieldCaps;
            List.of(1),
        static MockStorageBackend parquet() {
                    + " viableBackends must contain "
                    .build()
        List<Class<? extends OpenSearchRelNode>> expectedTypes,
    protected RelDataTypeFactory typeFactory;
            false,
        for (Map.Entry<String, Integer> entry : shardCountByIndex.entrySet()) {
            SqlKind.SUM,
        public List<String> getSupportedFormats() {
                    new FieldTypeCapabilities(
                List.of(),
    }
            return RelNodeUtils.unwrapHep(reducer.getInput());
        );
                    ),
    protected RelNode unwrapExchange(RelNode node) {
    }
    static class MockStorageBackend implements SearchBackEndPlugin<Object> {
            int shardCount = entry.getValue();
        return AggregateCall.create(
            rowTypeBuilder.add(fieldNames[index], typeFactory.createSqlType(fieldTypes[index]));
    }
        }
    protected AggregateCall avgCall(RelNode input) {
import org.apache.calcite.sql.type.SqlTypeName;
    }
    protected LogicalAggregate makeAggregate(AggregateCall aggCall) {
        if (unwrapped instanceof OpenSearchExchangeReducer reducer) {
        }
    protected LogicalSort makeSort(RelNode input, int fetch) {
        String primaryFormat,
            }
    }
            super(cluster, traitSet, List.of(), table);
            );
    /** Sort with collation on field 0 ascending. Pass fetch of 0 or less for no limit. */
            -1,
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
import org.apache.calcite.rel.RelCollations;
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
            return List.of(formatName);
     */
        return rexBuilder.makeCall(
import org.apache.calcite.rel.RelNode;
            ),
        MockStorageBackend(String formatName, Set<FieldTypeCapabilities> fieldCaps) {
        return mockTable(tableName, rowTypeBuilder.build());
import org.opensearch.index.engine.dataformat.ReaderManagerConfig;
                List.of(),
    }
    }
        StubTableScan(RelOptCluster cluster, RelTraitSet traitSet, RelOptTable table) {
    protected ClusterService mockClusterService() {
                )
            input,
    protected static final IndexNameExpressionResolver TEST_RESOLVER = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));
        SqlTypeName[] types = Arrays.stream(fieldNames).map(name -> SqlTypeName.INTEGER).toArray(SqlTypeName[]::new);
        when(clusterService.state()).thenReturn(clusterState);
        RelNode root,
 * and plan execution helpers.
import static org.mockito.Mockito.when;
import org.opensearch.common.settings.Settings;
            false,
            input,
            function,
        }
    private static RelNode skipExchangeReducers(RelNode rel) {
    /**
        return current;
     * and aggregate the same field.
        List<AnalyticsSearchBackendPlugin> backends
import org.opensearch.plugins.SearchBackEndPlugin;
    protected RexNode makeFullTextCall(SqlOperator function, int fieldIndex, String query) {
        @Override
    protected PlannerContext buildContext(
            false,
        return buildContext(primaryFormat, 2, fieldMappings, List.of(DATAFUSION, LUCENE));
 * Subclasses get mock backends, cluster state builders, table builders,
        for (int index = 0; index < fieldNames.length; index++) {
        Map<String, Map<String, Object>> fieldMappings,
                        Set.of(FieldTypeCapabilities.Capability.POINT_RANGE, FieldTypeCapabilities.Capability.STORED_FIELDS)
    }
                current = RelNodeUtils.unwrapHep(current.getInputs().get(0));
import org.apache.calcite.rex.RexNode;
        OperationRouting routing = mock(OperationRouting.class);
    }
import org.apache.calcite.rel.logical.LogicalSort;
                    new FieldTypeCapabilities("integer", Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE)),
        when(routing.searchShards(any(), any(), any(), any())).thenReturn(new GroupShardsIterator<ShardIterator>(List.of()));
import org.apache.calcite.util.ImmutableBitSet;
        String primaryFormat,
    /**
    /**
    }
        }
        );
            when(mappingMetadata.sourceAsMap()).thenReturn(mappingSource);
            when(metadata.index(indexName)).thenReturn(indexMetadata);
        return makeMultiCallAggregate(stubScan(mockTable("test_index", "status", "size")), aggCalls);
    protected RexBuilder rexBuilder;
import java.util.Map;
    protected PlannerContext buildContext(String primaryFormat, Map<String, Map<String, Object>> fieldMappings) {
        }
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, Set.of(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING));
    @SuppressWarnings("unchecked")
        return LogicalAggregate.create(input, List.of(), ImmutableBitSet.of(0), null, List.of(aggCalls));
            false,
                false
    }
            List.of(),
        String primaryFormat,
    }
            false,
import org.apache.calcite.rel.type.RelDataType;
        return new PlannerContext(new CapabilityRegistry(backends, fieldStorageFactory), clusterState, testSettings);
        // Default test settings: MPP off. Most planner-rule tests pin the COORDINATOR_CENTRIC
     * explicitly; the walk does not skip past it in that case.
                    + " but was "
        int shardCount,
    protected AggregateCall countStarCall(RelNode input) {
import org.opensearch.cluster.routing.GroupShardsIterator;
     * tests that join across tables with asymmetric partitioning. All indices share
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
import org.opensearch.analytics.spi.FieldType;
                )
import org.opensearch.action.search.TransportSearchAction;
import org.apache.calcite.rel.RelFieldCollation;
     * AVG over the second column. Uses the long-form {@link AggregateCall#create} with a
        private final String formatName;
            "checked_total_size"
        return new SqlAggFunction(
        ClusterState clusterState = mock(ClusterState.class);
    protected RexNode makeEquals(int fieldIndex, SqlTypeName fieldType, Object value) {
import org.opensearch.cluster.routing.ShardIterator;
    ) {
            null,
            rexBuilder.makeLiteral(fetch, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
    protected AggregateCall approxCountDistinctCall(RelNode input) {
            RelCollations.EMPTY,
        );
        Map<String, Map<String, Object>> fieldMappings,
    }
    /**
            );
    private RelOptTable mockTable(String tableName, RelDataType rowType) {
        };
import org.apache.calcite.plan.RelOptCluster;
    }
    protected LogicalAggregate makeMultiCallAggregate(RelNode input, AggregateCall... aggCalls) {
        return mockTable(tableName, fieldNames, types);
import java.util.Arrays;
            SqlFunctionCategory.USER_DEFINED_FUNCTION,
 * The OpenSearch Contributors require contributions made to
    }
                    )
        when(metadata.index("test_index")).thenReturn(indexMetadata);
    }
            caps.add(new AggregateCapability(entry.getKey(), entry.getValue(), formats));
    protected AggregateCall sumCall() {
     * (the common case when scans are at SOURCE kind). Tests that want to inspect the
        when(indexMetadata.getNumberOfShards()).thenReturn(shardCount);
        Set<AggregateCapability> caps = new HashSet<>();
 * compatible open source license.
import org.apache.calcite.plan.hep.HepProgramBuilder;
                        "keyword",
            "dc"
        ClusterState clusterState = mock(ClusterState.class);
            List.of(1),
            input,
     * {@code COUNT(DISTINCT $1)} — single-arg distinct. The HEP {@code OpenSearchDistinctCountRule}
import org.opensearch.analytics.spi.FieldStorageInfo;
        Metadata metadata = mock(Metadata.class);
                    new FieldTypeCapabilities("date", Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE))
 * Shared test infrastructure for planner rule tests.
    ) {
            rexBuilder.makeLiteral(query)
            assertTrue(
    protected RelNode runPlanner(RelNode input, PlannerContext context) {
        Settings testSettings = Settings.builder().put("analytics.mpp.enabled", false).build();
                    new FieldTypeCapabilities("text", Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE)),
        IndexMetadata indexMetadata = mock(IndexMetadata.class);
    protected LogicalAggregate makeMultiCallAggregate(AggregateCall... aggCalls) {
        );
    protected SqlAggFunction checkedLongSumOperator() {
public abstract class BasePlannerRulesTests extends OpenSearchTestCase {
            List.of(),
    protected RelNode unwrapRootReducer(RelNode node) {
     * where a field has doc values in multiple formats (e.g. parquet + lucene).
     * overload passes an explicit type and would trip {@code Aggregate.typeMatchesInferred}.
    protected PlannerContext buildContext(
        for (var entry : funcToTypes.entrySet()) {
                "size",
        return unwrapped;
    }
        when(indexMetadata.getIndex()).thenReturn(new Index("test_index", "uuid"));
    protected AggregateCall countStarCall() {
        return table;
        Settings testSettings = Settings.builder().put("analytics.mpp.enabled", false).build();
        );
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            null,
            null,
