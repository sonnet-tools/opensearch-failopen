                (RexLiteral) rexBuilder.makeLiteral(25, intType, false)
import org.apache.calcite.rel.logical.LogicalSort;
     * Verifies nested AND/OR/NOT with delegation placeholders and their annotation IDs survive
            List.of("datafusion"),
        assertEquals(
     * Regression: a single Calcite {@link LogicalSort} carrying BOTH a collation and a {@code fetch}
            extensions = DefaultExtensionCatalog.DEFAULT_COLLECTION.merge(delegationExtensions)
                String baseName = name.contains(":") ? name.substring(0, name.indexOf(':')) : name;
            SqlStdOperatorTable.GREATER_THAN,
    }
     * Using the inner's names causes DataFusion's substrait consumer to fail
        // Aggregate over the union: SUM(a) → 1 column.
                .map(name -> name.contains(":") ? name.substring(0, name.indexOf(':')) : name)
        );
        RelDataType partialRowType = typeFactory.builder()
package org.opensearch.be.datafusion;
    // ── Tests ──────────────────────────────────────────────────────────────────
        RelNode sin3 = new OpenSearchStageInputScan(cluster, cluster.traitSet(), 3, branchRowType, List.of("datafusion"), List.of());
        assertListAggregateUses("input-7", "list_merge");
    public void testConvertShardScanFragment_TableScan() throws Exception {
            childStageId,
        );
     * subclass that the isthmus visitor emits as a {@link ReadRel} with a
            "count"
        RexNode delegated = DelegatedPredicateFunction.makeCall(rexBuilder, 7);
    public void testMultisearchShape_SortOverAggregateOverThreeWayUnion_PlanRootNamesMatchTopOutput() throws Exception {
    private void assertAggregateImplKeys(String name, String... expectedKeys) {
        );
                + "not the inner Union's 6-column row type — multisearch ThreeSubsearches regression",
import org.apache.calcite.plan.hep.HepPlanner;
        RelNode sin3 = new OpenSearchStageInputScan(cluster, cluster.traitSet(), 3, branchRowType, List.of("datafusion"), List.of());
        RelDataType varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
import org.apache.calcite.rel.logical.LogicalCorrelate;
        Plan plan = decodeSubstrait(combinedBytes);
                }
        assertEquals(
    private LogicalAggregate buildSumAggregate(RelNode input, int columnIndex) {
        assertTrue("condition must be a scalar function", filterRel.getCondition().hasScalarFunction());
        byte[] innerBytes = convertor.convertFragment(finalAgg);
        RexNode fetchN = rexBuilder.makeLiteral(100, typeFactory.createSqlType(SqlTypeName.INTEGER), true);
    private DataFusionFragmentConvertor newConvertor() {
 *
            0,
import io.substrait.proto.FilterRel;
        assertTrue(partialRoot.hasProject());
        RelNode scan = buildTableScan("test_index", "A", "B", "C");
import org.apache.calcite.plan.hep.HepProgramBuilder;
        // Inner bytes from a shard-scan conversion.
                (RexLiteral) rexBuilder.makeLiteral(30, intType, false)
            List.of("datafusion"),
        assertTrue("expand extension must survive decode + re-encode", expanded.hasExtensionSingle());
        LogicalAggregate partialOverStageInput = LogicalAggregate.create(
        logger.info("Substrait plan (complex boolean tree):\n{}", plan);
        List<String> rootNames = plan.getRelations(0).getRoot().getNamesList();
        Rel root = rootRel(plan);
        assertEquals(List.of("tags", "category", "count"), output.getRowType().getFieldNames());
    private void assertListAggregateUses(String tableName, String expectedFunction) throws Exception {
     * to lose its lower layer when re-wired. The next attach-on-top then crashed deserialising
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
public class DataFusionFragmentConvertorTests extends OpenSearchTestCase {
                if (baseName.equals("approx_distinct")) {
        LogicalSort sortLimit = LogicalSort.create(placeholderInput, RelCollations.of(0), null, fetchN);
            false
            List.of(0),
            1,
            cluster,
     * {@code make_renamed_schema} with "Names list must match exactly to nested
        RelNode project = LogicalProject.create(
            typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true),
        );
        assertTrue("Sort input must be an AggregateRel", inner.hasAggregate());
    /**
        RexNode correlatedTags = rexBuilder.makeFieldAccess(rexBuilder.makeCorrel(left.getRowType(), correlationId), 0);
            cluster.traitSet(),
    }
                .getSelection()
     */
        LogicalUnion union = LogicalUnion.create(List.of(sin1, sin2, sin3), true);
            cluster,
import org.apache.calcite.rel.core.CorrelationId;
        assertTrue("ReadRel must reference a named table", read.hasNamedTable());
            .add("category", typeFactory.createSqlType(SqlTypeName.VARCHAR))
     * the wrapper reshapes the schema (Aggregate, Project, etc).
        }
        RelNode left = buildListTableScan("test_index");
import org.apache.calcite.rel.core.JoinRelType;
        );
        assertTrue("FilterRel must carry a condition", filterRel.hasCondition());
        ReadRel read = rootRel(decodeSubstrait(newConvertor().convertFragment(values))).getRead();
            false,
        assertEquals(1, payload.getInt());
            ),
     * AND(A > 10, OR(delegated_predicate(1), NOT(delegated_predicate(2)))) — complex boolean tree.
     * end-to-end IT surfaced even after the initial rewire fix.
        assertTrue("Agg input must be the inner ReadRel", aggInput.hasRead());
            SqlStdOperatorTable.SUM,
        assertTrue(rewritten instanceof LogicalProject);
    private RelNode buildTableScan(String tableName, String... columns) {
            false,
    public void testAttachFragmentOnTop_NoGroupListOverScalar_MeasureArgIsVarcharCastOverOriginalField() throws Exception {
        assertEquals("aggregate argument must remain on the source LIST", List.of(0), grouped.getAggCallList().get(0).getArgList());
                }
            typeFactory.createSqlType(SqlTypeName.BIGINT),
        LogicalValues values = (LogicalValues) LogicalValues.create(cluster, rowType, tuples);
                .filter(SimpleExtensionDeclaration::hasExtensionFunction)
        assertTrue("LIST GROUP BY must use an ExtensionSingleRel", expanded.hasExtensionSingle());
        assertTrue("Filter input must be a ReadRel", inner.hasRead());
        Rel inner = agg.getInput();
    }
            List.of(),
        assertTrue("FINAL aggregate must read the stage input directly, not a second expand", input.hasRead());
        assertTrue("second AND arg must be a scalar function", delegatedArg.hasScalarFunction());
        // User-level Sort by the single agg-output column — schema preserved.
        RelDataType list = typeFactory.createTypeWithNullability(typeFactory.createArrayType(element, -1), true);
        // Aggregate is rewired over the inner plan's root ReadRel.
        RelNode scan = buildTableScan("test_index", "A");
    }
        LogicalSort userSort = LogicalSort.create(aggregate, RelCollations.of(0), null, null);
            0,
        assertEquals(7, delegatedArg.getScalarFunction().getArguments(0).getValue().getLiteral().getI32());
        // *wrapper* we attach above has its own output rowType.
        Rel root = rootRel(plan);
        // OR arg[1]: NOT(delegated_predicate(2))
        Expression gtArg = andFunc.getArguments(0).getValue();
        org.apache.calcite.rel.core.Aggregate grouped = (org.apache.calcite.rel.core.Aggregate) output.getInput();
            ImmutableBitSet.ORDERING.immutableSortedCopy(List.of(ImmutableBitSet.of(0), ImmutableBitSet.of(1), ImmutableBitSet.of(0, 1))),
            List.of("sum_col"),
        RelDataType stageRowType = rowType("A");
    }
     * A {@code Filter(Scan)} fragment converts to {@code FilterRel(ReadRel)}.
    public void testMinMaxYamlDeclaresStringAndBooleanOverloads() {
        assertTrue(partialRoot.getProject().getInput().getAggregate().getInput().hasExtensionSingle());
        Rel aggInput = underSort.getAggregate().getInput();
import org.apache.calcite.rex.RexLiteral;
            List.of(),
     * {@link DataFusionFragmentConvertor.StageInputTableScan} — a minimal TableScan
            rexBuilder.makeInputRef(scan, 0),
        org.apache.calcite.rel.logical.LogicalProject innerProject = org.apache.calcite.rel.logical.LogicalProject.create(
     * must rewire the inner plan under the Sort, preserving {@code Fetch(Sort(inner))} so the global
            java.util.Set.of()
        List<String> rootNames = plan.getRelations(0).getRoot().getNamesList();
import io.substrait.proto.Expression;
        assertTrue(aggregateRel.hasAggregate());
        );
        assertEquals(0, ((org.apache.calcite.rex.RexInputRef) output.getProjects().get(1)).getIndex());
import org.apache.calcite.sql.SqlAggFunction;
            List.of("datafusion"),
        assertTrue("plan relation must carry a root", planRel.hasRoot());
        byte[] bytes = newConvertor().convertFragment(scan);
    /**
    public void testConvertShardScanFragment_ComplexBooleanTreeWithDelegation() throws Exception {
            List.of("datafusion"),
    /**
        assertTrue("FINAL aggregate must sit on the shard fragment's output projection", inner.hasProject());
            List.of(),
        byte[] combined = convertor.attachFragmentOnTop(sort, innerBytes);
        RelDataType element = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
        assertTrue(
            ImmutableList.of(
import org.apache.calcite.rel.logical.LogicalProject;
        Plan plan = decodeSubstrait(combined);
            List.of()
            t.setContextClassLoader(DataFusionFragmentConvertorTests.class.getClassLoader());
            "Plan.Root.names must reflect the Sort wrapper's output (1 column from the inner agg), "
        RelDataType partialRowType = typeFactory.builder()
            SqlStdOperatorTable.GREATER_THAN,
            rowType("c0", "c1", "c2", "c3", "c4"),
        Plan plan = decodeSubstrait(combined);
import io.substrait.extension.SimpleExtension;
            -1,
            List.of("input-" + childStageId),
        assertTrue("first AND arg must be a scalar function (GT)", gtArg.hasScalarFunction());
        Rel inner = sortRel.getInput();
            false,
            ImmutableBitSet.of(0, 1),
        SqlAggFunction listOp = new SqlAggFunction(
        RexNode nativePred = rexBuilder.makeCall(
        assertTrue("Aggregate input must be a ReadRel", inner.hasRead());
        RelNode scan = new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), "test_index", inputType);
        RelNode stageInput = new OpenSearchStageInputScan(cluster, cluster.traitSet(), 1, partialRowType, List.of("datafusion"), List.of());
        Rel root = rootRel(decodeSubstrait(combined));
                assertNotEquals("approx_count_distinct must be renamed", "approx_count_distinct", baseName);
     * {@code approx_count_distinct} name.
import org.apache.calcite.rel.RelCollations;
            cluster,
        assertEquals("final-agg phase must be INITIAL_TO_RESULT", AggregationPhase.AGGREGATION_PHASE_INITIAL_TO_RESULT, fn.getPhase());
        AggregateCall approxCall = AggregateCall.create(
        PlanRel planRel = plan.getRelationsList().get(0);
    }
    /** Builds a nullable row type with integer columns named "A", "B", ... */
        LogicalAggregate innerFinalAgg = buildSumAggregate(innerStageScan, 0);
    /**
            groupCount,
import org.apache.calcite.rel.type.RelDataTypeFactory;
        }
        RelNode stageInput = new OpenSearchStageInputScan(
    /** Extracts the single root {@link Rel} of a Substrait {@link Plan}. */
            AggregationPhase.AGGREGATION_PHASE_INITIAL_TO_INTERMEDIATE,
        RelNode filter = LogicalFilter.create(scan, andCondition);
                .merge(scalarExtensions);
        byte[] bytes = newConvertor().convertFragment(filter);
 * The OpenSearch Contributors require contributions made to
            ImmutableBitSet.of(0),
        // Verify the argument is literal i32 = 42
        assertEquals(List.of("tags", "count"), plan.getRelations(0).getRoot().getNamesList());
            -1,
        LogicalAggregate partialAgg = buildSumAggregate(scan, 0);
        );
    }
                .anyMatch(expectedFunction::equals)
        RelDataType list = typeFactory.createTypeWithNullability(typeFactory.createArrayType(element, -1), true);
        );
        assertEquals("implicit GROUP BY expansion de-duplicates within each document", 1, payload.getInt());
        };
    /**
    /**
     */
            Optionality.FORBIDDEN
     * converts to {@code AggregateRel(ReadRel(namedTable=["input-<childStageId>"]))}.
    public void testMultisearchShape_SystemLimitOverSortOverAggregateOverUnion_NamesMatchTopOutput() throws Exception {
        ) {
     * the inner width, panicking native DataFusion. Asserts the arg is a Cast over original field 0.
        Expression dp1 = orFunc.getArguments(0).getValue();
        byte[] userSortBytes = convertor.attachFragmentOnTop(userSort, aggBytes);
        Rel expanded = partialAgg.getAggregate().getInput();
        Expression arg = root.getAggregate().getMeasures(0).getMeasure().getArguments(0).getValue();
        RelDataTypeFactory.Builder b = typeFactory.builder();
            List.of("picked"),
            List.of()
            "sum_col"
        RelNode scan = buildTableScan("test_index", "A");
    public void testListGroupByRemapsGroupingSetsAndRestoresOutputOrder() {
    }
        assertEquals(-1, payload.getInt());
    public void testAttachFragmentOnTopDecodesMultiValueExpandExtension() throws Exception {
        Rel inner = root.getAggregate().getInput();
            listOp,
    /**
        byte[] innerBytes = convertor.convertFragment(scan);
            .add("count", typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true))
        assertTrue("varchar column -> Str schema", read.getBaseSchema().getStruct().getTypes(0).hasString());
            -1,
        assertEquals(1, payload.getInt());
        assertTrue("convertor bytes must not be empty", bytes.length > 0);
            List.of(0),
     */
            null,
    }
                String name = decl.getExtensionFunction().getName();
            List.of("datafusion"),
        for (SimpleExtensionDeclaration decl : plan.getExtensionsList()) {
        Plan plan = decodeSubstrait(newConvertor().convertFragment(aggregate));
            SqlStdOperatorTable.SUM,
        Expression notExpr = orFunc.getArguments(1).getValue();
import io.substrait.proto.AggregationPhase;
        );
            "values"
            assertTrue(name + " yaml must declare impl with key " + key + " (got " + actual + ")", actual.contains(key));
    public void testConvertShardScanFragment_FilterOverScan() throws Exception {
        Plan plan = decodeSubstrait(combinedBytes);
        // Substrait Fetch rel (the convertor handles this in replaceInput).
import io.substrait.proto.SimpleExtensionDeclaration;
    public void testConvertShardScanFragment_MixedNativeAndDelegated() throws Exception {
     * query-size LIMIT injected by {@code QueryService.convertToCalcitePlan}. The
     */
        byte[] bytes = newConvertor().convertFragment(filter);
     * Regression: a lifted-window Project wrapper, shaped {@code Project_outer(Project_lower(input))}
        byte[] innerBytes = convertor.convertFragment(scan);
 *
    public void testAttachFragmentOnTop_PreservesLiftedWindowProjectLayer() throws Exception {
            inputRowType,
        // The wrapper's output rowType has 1 column ("sum_col") which must end up in
        );
 * exercised independently against a Calcite RelNode constructed in-process,
     * FINAL half of a multi-shard LIST GROUP BY. The stage input is still typed with the
        );
        List<String> rootNames = plan.getRelations(0).getRoot().getNamesList();
        byte[] combined = convertor.attachPartialAggOnTop(partialAgg, innerBytes);
import org.apache.calcite.sql.type.SqlTypeTransforms;
        assertEquals(1, dp1.getScalarFunction().getArguments(0).getValue().getLiteral().getI32());
                .getStructField()
     *         Union(Sin, Sin, Sin)
            List.of()
            "count"
        return new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), tableName, rowType(columns));
        RelDataType stageRowType = rowType("A");
    }
        // Load the Substrait extension catalog with the test classloader as TCCL —
        DataFusionFragmentConvertor convertor = newConvertor();
import org.apache.calcite.rel.type.RelDataType;
            false,
        return LogicalAggregate.create(input, List.of(), ImmutableBitSet.of(), null, List.of(sumCall));
 * the returned Substrait proto bytes are decoded back into proto structures,
        // Sort over the aggregate: schema-preserving wrapper.
        assertEquals(List.of("test_index"), inner.getRead().getNamedTable().getNamesList());
     * {@code AggregateRel(readRel)} with phase INITIAL_TO_INTERMEDIATE.
        RexNode notDelegated2 = rexBuilder.makeCall(SqlStdOperatorTable.NOT, delegated2);
        RexNode fetchN = rexBuilder.makeLiteral(5, typeFactory.createSqlType(SqlTypeName.INTEGER), true);
            List.of("sum_col"),
        RelNode stageInput = new OpenSearchStageInputScan(cluster, cluster.traitSet(), 1, partialRowType, List.of("datafusion"), List.of());
        assertEquals(0, payload.getInt());
            List.of(),
        assertEquals(
        Expression orArg = andFunc.getArguments(1).getValue();
        }
     * Project — else the reduce-stage stitch ({@code replaceInput}) drops it and the arg dangles past
        RelNode innerStageScan = new OpenSearchStageInputScan(
     * {@code Plan.Root.names} must reflect the Sort's output schema (= the
        FilterRel filterRel = root.getFilter();
        RelNode filter = LogicalFilter.create(scan, placeholder);
            typeFactory.createSqlType(SqlTypeName.BIGINT),
    /**
        // FINAL half: SUM(count) grouped by the expanded (now scalar VARCHAR) tags column.
        );
        Rel root = rootRel(decodeSubstrait(newConvertor().convertFragment(finalAgg)));
import java.util.List;
    private RelOptCluster cluster;
            List.of(),
        Expression delegatedArg = andFunc.getArguments(1).getValue();
        Rel root = rootRel(decodeSubstrait(newConvertor().convertFragment(correlate)));
            cluster,
            "StageInputScan must be emitted as a ReadRel with the per-child stage-input id",
        Plan plan = decodeSubstrait(combined);
        assertTrue("root must be a FilterRel", root.hasFilter());
import org.apache.calcite.util.Optionality;
            "Plan.Root.names must reflect the Sort wrapper's output (= aggregate's 1-column output), "
        RelNode scan = buildTableScan("test_index", "A");
    public void testVirtualTable_VarcharValues_ConvertsToStrGenerically() throws Exception {
        return planRel.getRoot().getInput();
        Rel inner = filterRel.getInput();
            bigintType,
        assertEquals("opensearch://analytics/multi_value_expand/v1", expanded.getExtensionSingle().getDetail().getTypeUrl());
        );
            List.of(sumCounts)
        // The inner's Plan.Root.names then carries the agg-output (1 col, "sum_col"), but the
            input,
import org.apache.calcite.rel.core.AggregateCall;
     */
        AggregateCall sumCounts = AggregateCall.create(
     * Mirror of multisearch's coordinator-stage shape:
import org.apache.calcite.sql.type.SqlTypeName;
     * Regression: {@code attachFragmentOnTop} for an Aggregate over a multi-column
        Rel underSort = underFetch.getSort().getInput();
            cluster.traitSet(),
            typeFactory.createSqlType(SqlTypeName.BIGINT),
        Rel root = rootRel(plan);
            null,
        typeFactory = new JavaTypeFactoryImpl();
     * SUM aggregate is not affected by the rename map — its extension function
            .add("tags", list)
     */
            "Plan.Root.names must reflect the system-limit Sort wrapper's output (= 1-column aggregate output), "
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        AggregateCall sumCounts = AggregateCall.create(
    }
            typeFactory.createSqlType(SqlTypeName.BIGINT),
        assertTrue("second AND arg must be a scalar function (OR)", orArg.hasScalarFunction());
        assertTrue("root must be a FilterRel", root.hasFilter());
        assertTrue("must find approx_distinct in extension declarations", foundApproxDistinct);
import org.apache.calcite.sql.SqlFunctionCategory;
import org.apache.calcite.plan.RelOptCluster;
            false,
     */
        assertEquals(42, scalarFunc.getArguments(0).getValue().getLiteral().getI32());
    private Rel rootRel(Plan plan) {
        RelDataType arrayType = typeFactory.createTypeWithNullability(typeFactory.createArrayType(nullableInt, -1), true);
        assertTrue(root.hasExtensionSingle());
    /**
                if (baseName.equals("sum")) {
        LogicalProject output = (LogicalProject) MultiValueRelRewriter.rewrite(aggregate);
            List.of(1),
     * PARTIAL aggregate's GROUP BY field reference fails with
                + "not the inner Union's 6-column row type — the implicit limit at the top of every "
        for (SimpleExtensionDeclaration decl : plan.getExtensionsList()) {
        byte[] aggBytes = convertor.attachFragmentOnTop(aggregate, unionBytes);
            .stream()
 * this file be licensed under the Apache-2.0 license or a
     */
        assertEquals(List.of("test_index"), read.getNamedTable().getNamesList());
        LogicalAggregate aggregate = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(count));
        LogicalAggregate aggregate = LogicalAggregate.create(
        Plan plan = decodeSubstrait(combined);
    private RelNode buildListTableScan(String tableName) {
        LogicalAggregate partialAgg = buildSumAggregate(scan, 0);
        assertEquals(10, gtArg.getScalarFunction().getArguments(1).getValue().getLiteral().getI32());
    }
        assertEquals(List.of("test_index"), inner.getRead().getNamedTable().getNamesList());
        assertEquals(
    }
        );
        LogicalAggregate finalAgg = buildSumAggregate(stageInput, 0);
     * A filter containing {@code delegated_predicate(42)} converts to Substrait
            rootNames
        );
            .build();
        RelDataType list = typeFactory.createTypeWithNullability(typeFactory.createArrayType(element, -1), true);
import org.apache.calcite.rel.logical.LogicalValues;
        RelNode stageInput = new OpenSearchStageInputScan(
    public void setUp() throws Exception {
        RelDataType type = typeFactory.builder().add("tags", list).build();
        Rel root = rootRel(plan);
    // ── Helpers ────────────────────────────────────────────────────────────────
        // Inner: a final-agg fragment whose StageInputScan rowType is intentionally wide
        AggregateCall count = AggregateCall.create(
            org.apache.calcite.rex.RexWindowBounds.CURRENT_ROW,
        );
        // Wrapper: a Project that maps the single inner column to two new aliases — this is
        );
        Rel partialRoot = rootRel(decodeSubstrait(newConvertor().convertFragment(partialOverStageInput)));
    // VirtualTable inline Values CHAR to Str normalization
        assertTrue(output.getInput() instanceof org.apache.calcite.rel.core.Aggregate);
            list,
            fn.getPhase()
     * path that {@code OpenSearchValuesCharNormalizeRule} feeds after normalising a raw CHAR Values.
     * <p>The earlier rewire replaced the Fetch's input directly, dropping the Sort and yielding
        );
        // Inner fragment: Project that outputs a single INTEGER column (the gathered reduce input).
        org.apache.calcite.rel.core.Aggregate grouped = (org.apache.calcite.rel.core.Aggregate) output.getInput();
        byte[] unionBytes = convertor.convertFragment(union);
import org.apache.calcite.sql.type.ReturnTypes;
        assertEquals(
        AggregateRel agg = root.getAggregate();
            stageInput,
    private SimpleExtension.ExtensionCollection extensions;
        Plan plan = decodeSubstrait(bytes);
        RelNode scan = buildTableScan("test_index", "A", "B");
        Plan plan = decodeSubstrait(bytes);
            false,
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
    }
        RelNode stageInput = new OpenSearchStageInputScan(
            SqlStdOperatorTable.GREATER_THAN,
     */
    /**
        byte[] combined = convertor.attachPartialAggOnTop(partialAgg, innerBytes);
        RelNode sin2 = new OpenSearchStageInputScan(cluster, cluster.traitSet(), 2, branchRowType, List.of("datafusion"), List.of());
    }
        RelNode filter = LogicalFilter.create(scan, predicate);
        assertNotNull("convertor bytes must not be null", bytes);
        byte[] innerBytes = convertor.convertFragment(innerFinalAgg);
            false,
        );
     * with the *wrapper aggregate's* output column names — not the inner scan's.
            "count"
import io.substrait.proto.AggregateRel;
     * APPROX_COUNT_DISTINCT aggregate emits as {@code approx_distinct} in the
            grouped.getGroupSets()
     * name remains unchanged.
    public void testAttachFragmentOnTop_SortWithFetch_PreservesSortUnderFetch() throws Exception {
    }
        Rel expanded = aggregateRel.getAggregate().getInput();
        Plan plan = decodeSubstrait(combined);
        );
    public void testOtherFunctionsNotRenamed() throws Exception {
import io.substrait.proto.ReadRel;
            .build();
    /**
    }
        assertTrue("root must be an AggregateRel", root.hasAggregate());
        );
            List.of()
import io.substrait.proto.Rel;
    /**
        assertTrue("lower's input must be the rewired stage-scan", innerOfLower.hasRead());
            java.util.Set.of(correlationId)
            "shard fragment must carry the expand extension",
            rexBuilder.makeInputRef(scan, 0),
        // aggregate over the same input row type to keep the standalone conversion simple.
            List.of(),
        RelNode correlate = LogicalCorrelate.create(left, limited, correlationId, ImmutableBitSet.of(0), JoinRelType.INNER);
            wideStageRowType,
     */
        byte[] bytes = newConvertor().convertFragment(agg);
        rexBuilder = new RexBuilder(typeFactory);
        LogicalAggregate agg = buildSumAggregate(scan, 0);
    }
    /**
import io.substrait.proto.PlanRel;
            List.of(buildListAggregateCall(scan, 1))
        // Wrapper: ONE LogicalSort carrying a collation (order by col 0) AND a fetch (head 5).
import io.substrait.proto.Plan;
            scan,
        );
        assertEquals("two rows", 2, read.getVirtualTable().getExpressionsCount());
            "approx_col"
 * SPDX-License-Identifier: Apache-2.0
     * A final-agg fragment whose leaf is an {@link OpenSearchStageInputScan}
        RelDataType branchRowType = rowType("a", "b", "c", "d", "e", "f");
            -1,
        logger.info("Substrait condition (single delegated):\n{}", filterRel.getCondition());
     * for each registered DataFusion partition; single-input shapes still arrive at
            "l"
            false,
            .add("count", typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true))
        LogicalAggregate agg = LogicalAggregate.create(aggLeaf, List.of(), ImmutableBitSet.of(), null, List.of(listCall));
        );
import org.apache.calcite.sql.SqlKind;
     */
                .merge(aggregateExtensions)
        RelDataType stageRowType = rowType("A");
        AggregateCall count = AggregateCall.create(
        RelDataType element = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
            org.apache.calcite.rex.RexWindowBounds.UNBOUNDED_PRECEDING,
    }
            stageRowType,
        }
            List.of(),
            placeholderInput,
            "the cast must wrap the ORIGINAL input field (index 0), not a lifted/appended column",
import com.google.common.collect.ImmutableList;
            List.of(count)
import org.apache.calcite.rel.logical.LogicalFilter;
        LogicalAggregate finalAgg = buildSumAggregate(stageInput, 0);
        LogicalAggregate finalAgg = buildSumAggregate(stageInput, 0);
                RexLiteral.fromJdbcString(varchar, SqlTypeName.CHAR, "Bob"),
            ImmutableList.of(
            "LIST",
     */
        LogicalAggregate finalAgg = LogicalAggregate.create(stageInput, List.of(), ImmutableBitSet.of(0), null, List.of(sumCounts));
            true,
        // during rewire (replaced with the inner plan's root).
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(), null, List.of(approxCall));
            null,
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
            List.of(rexBuilder.makeInputRef(placeholderInput, 0), rowNumberOver),
        // OR arg[0]: delegated_predicate(1)
            null,
        assertEquals("input-1", input.getRead().getNamedTable().getNames(0));
        for (String c : columns) {
     *       Aggregate(...)
            0,
        RexNode placeholder = DelegatedPredicateFunction.makeCall(rexBuilder, 42);
                .stream()
        assertEquals(1, ((org.apache.calcite.rex.RexInputRef) output.getProjects().get(0)).getIndex());
        LogicalSort sortWrapper = LogicalSort.create(placeholderInput, RelCollations.of(0), null, null);
import org.apache.calcite.rel.logical.LogicalAggregate;
            arg.getCast().getInput().getSelection().getDirectReference().getStructField().getField()
        List<String> rootNames = plan.getRelations(0).getRoot().getNamesList();
        RelNode outerProject = org.apache.calcite.rel.logical.LogicalProject.create(
            innerProject.getRowType(),
        assertTrue(
            }
            null,
        assertTrue("FilterRel must carry a condition", filterRel.hasCondition());
                .getGroupings(0)
        // Sort is rewired over the inner agg.
    }
            List.of()
        Plan plan = decodeSubstrait(bytes);
                .getDirectReference()
        assertTrue(partialAgg.hasAggregate());
     * with "Field reference offset (N) must be less than number of fields in struct (N)".
            innerStage,
     * {@code Fetch(Sort(input))} — two Substrait rels from one operator. {@code attachFragmentOnTop}
        );
            SqlKind.OTHER_FUNCTION,
        AggregateFunction fn = agg.getMeasures(0).getMeasure();
        Rel aggregateRel = root.getProject().getInput();
        RelNode placeholderInput = buildTableScan("__placeholder__", "sum_col");
        return Plan.parseFrom(bytes);
            null,
        int childStageId = 7;
            Expression.Nested.Struct row = read.getVirtualTable().getExpressions(r);
        FilterRel filterRel = root.getFilter();
            ReturnTypes.TO_ARRAY.andThen(SqlTypeTransforms.FORCE_NULLABLE),
            SimpleExtension.ExtensionCollection aggregateExtensions = SimpleExtension.load(List.of("/opensearch_aggregate_functions.yaml"));
        byte[] combined = convertor.attachFragmentOnTop(sortWrapper, innerBytes);
    public void testListAggregateGroupedBySameMultiValueFieldPreservesListInput() {
            org.apache.calcite.rel.RelCollations.EMPTY,
        RelNode placeholderInput = buildTableScan("__placeholder__", "a");
            List.of("a", "rn"),
        // input for row-type validation in the isthmus visitor; give it a bare placeholder
        assertTrue("NOT arg must be scalar function", dp2.hasScalarFunction());
            false,
        for (String key : expectedKeys) {
        Rel root = rootRel(plan);
            inner.getRead().getNamedTable().getNamesList()
     * one-element named-table reference.
        RexNode delegated2 = DelegatedPredicateFunction.makeCall(rexBuilder, 2);
        // isthmus lowers this single node to Fetch(Sort(Read)); the rewire must keep the Sort.
    public void testAttachPartialAggOnTop_WrapsInner() throws Exception {
        OpenSearchStageInputScan aggLeaf = new OpenSearchStageInputScan(
            false,
        assertEquals("opensearch://analytics/multi_value_expand/v1", expanded.getExtensionSingle().getDetail().getTypeUrl());
            List.of("datafusion"),
        // with the same output row type as the inner agg. The placeholder is discarded
        OpenSearchStageInputScan innerStage = new OpenSearchStageInputScan(
        Rel innerOfOuter = root.getProject().getInput();
        Rel root = rootRel(plan);
        byte[] innerBytes = newConvertor().convertFragment(partial);
        byte[] aggBytes = convertor.attachFragmentOnTop(aggregate, unionBytes);
 * and assertions are made on proto shape — not serialized string content.
    public void testApproxCountDistinctRenamed() throws Exception {
        // Plan.Root.names regardless of what the wide-row stage-input scan above looked like.
        assertTrue("outer's input must remain the lower lift Project", innerOfOuter.hasProject());
    /**
        DataFusionFragmentConvertor convertor = newConvertor();
    /**
        int childStageId = 3;
            List.of()
        super.setUp();
        );
        assertEquals("explicit mvexpand preserves duplicate elements", 0, payload.getInt());
        Rel input = root.getAggregate().getInput();
     * Attaching a {@link LogicalSort} on top of inner bytes yields
     */
        RexNode rowNumberOver = rexBuilder.makeOver(
        byte[] unionBytes = convertor.convertFragment(union);
    /**
        SortRel sortRel = root.getSort();
import org.apache.calcite.rex.RexBuilder;
        RelDataType branchRowType = rowType("a", "b", "c", "d", "e", "f");
     * aggregate's 1-column output), not the inner Union's wider row type.
            false,
    @Override
            null,
        Plan plan = decodeSubstrait(newConvertor().convertFragment(aggregate));
        assertTrue("Sort must be preserved under the Fetch (global order before the limit), not dropped", underFetch.hasSort());
            "expected aggregate extension " + expectedFunction,
     * "Field reference offset (N) must be less than number of fields in struct (0)". The decoder
     * A precision-unspecified VARCHAR Values converts straight through isthmus to a VirtualTable whose
     * Substrait's stdlib only defines min/max for i8..fp64; opensearch_aggregate_functions.yaml
    private Plan decodeSubstrait(byte[] bytes) throws Exception {
            List.of(),
     * Attaching a partial aggregate on top of inner bytes yields an
     * different type (List(Utf8)) than the corresponding field in the table schema (Utf8View)".
     */
            false,
        RelDataType inputType = typeFactory.builder()
 * compatible open source license.
        // Isthmus defaults final-mode aggregates to INITIAL_TO_RESULT.
import org.opensearch.test.OpenSearchTestCase;
            .filter(v -> name.equals(v.name()))
        // Contract: attachFragmentOnTop receives a childless operator. Sort requires an
                RexLiteral.fromJdbcString(varchar, SqlTypeName.CHAR, "Alice"),
     * inner plan (e.g. Union of two stage-input scans) must populate
    }
        RexNode fetch = rexBuilder.makeLiteral(2, typeFactory.createSqlType(SqlTypeName.INTEGER), true);
     */
        DataFusionFragmentConvertor convertor = newConvertor();
        // Wrapper: LIST(picked) with NO group-by, over a 1-column placeholder (the inner's output shape).
            .map(SimpleExtension.Function::key)
            ReturnTypes.ARG0,
        // standalone visitor can derive types; the input is discarded by rewire.
        return new DataFusionFragmentConvertor(extensions);
        byte[] bytes = newConvertor().convertFragment(agg);
import org.apache.calcite.rel.RelNode;
            -1,
        Rel root = rootRel(plan);
            List.of("tags"),
        return AggregateCall.create(
        AggregateCall sumCall = AggregateCall.create(
        assertTrue("root must be the FINAL aggregate", root.hasAggregate());
            List.of("sum_col"),
            List.of(),
     * AND(A > 10, delegated_predicate(7)) — mixed native + delegated.
        // (3 columns). The aggregate above narrows it to 1 column.
        assertEquals(
        Expression.ScalarFunction scalarFunc = filterRel.getCondition().getScalarFunction();
     * the supplied tableName (no catalog prefix).
        // arg[0]: GT (native predicate) — has field ref and literal 10
        Rel root = rootRel(plan);
     * The stage-input id is per-child so multi-input shapes (Union) get distinct names
     *   Sort(fetch=N, collation=∅)          // system limit, lowered to a Substrait Fetch
    /**
        // For this regression, the inner doesn't need to be a final-agg — a bare scan-shaped
                String baseName = name.contains(":") ? name.substring(0, name.indexOf(':')) : name;
/*
    /**
        RelNode placeholderInput = buildTableScan("__placeholder__", "sum_col");
     * otherwise DataFusion rejects the plan with "Field 'tags' in Substrait schema has a
        assertNotNull(grouped.getInput().getRowType().getFieldList().get(0).getType().getComponentType());
     * Substrait AND has two children: GT scalar function and delegated_predicate scalar function.
            false,
        RexNode predicate = rexBuilder.makeCall(
        byte[] combined = newConvertor().attachFragmentOnTop(finalAgg, innerBytes);
        Expression.ScalarFunction andFunc = filterRel.getCondition().getScalarFunction();
        assertEquals("int cell stays i32", 30, read.getVirtualTable().getExpressions(0).getFields(1).getLiteral().getI32());
            if (decl.hasExtensionFunction()) {
        byte[] bytes = newConvertor().convertFragment(filter);
import org.opensearch.analytics.spi.DelegatedPredicateFunction;
        assertTrue("condition must be a scalar function", filterRel.getCondition().hasScalarFunction());
        assertEquals("implicit GROUP BY expansion appends a scalar field", 1, payload.getInt());
        assertEquals("AND must have 2 arguments", 2, andFunc.getArgumentsCount());
        LogicalAggregate aggregate = LogicalAggregate.create(
    }
     * {@code SortRel(<inner>)}.
        assertEquals("GROUP BY must use the appended scalar field", ImmutableBitSet.of(1), grouped.getGroupSet());
     * multi-value expand as an {@code ExtensionSingleRel}) to splice the FINAL aggregate on top.
        RelNode values = LogicalValues.createOneRow(cluster);
        FilterRel filterRel = rootRel(plan).getFilter();
    }
        assertEquals("OR must have 2 arguments", 2, orFunc.getArgumentsCount());
            List.of(rexBuilder.makeInputRef(lowerProject, 0), rexBuilder.makeInputRef(lowerProject, 1)),
        // Root condition is AND (scalar function with 2 args)
        RelNode sin1 = new OpenSearchStageInputScan(cluster, cluster.traitSet(), 1, branchRowType, List.of("datafusion"), List.of());
        Rel innerOfLower = innerOfOuter.getProject().getInput();
            List.of(),
        Plan plan = decodeSubstrait(bytes);
            cluster.traitSet(),
            ImmutableBitSet.ORDERING.immutableSortedCopy(List.of(ImmutableBitSet.of(2), ImmutableBitSet.of(1), ImmutableBitSet.of(1, 2))),
        assertTrue("Agg input must be a ReadRel", aggInput.hasRead());
            -1,
            cluster.traitSet(),
     * schema, but found {wrapper-width} uses for {inner-width} names" whenever
            List.of(sumCounts)
        RelNode innerStageScan = new OpenSearchStageInputScan(
     * A bare table scan converts to a {@code ReadRel} whose named table carries
        return new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), tableName, type);
    public void testAttachFragmentOnTop_AggregateOverMultiColumnInner_PlanRootNamesMatchWrapperOutput() throws Exception {
            .build();
        assertTrue("root must be an AggregateRel", root.hasAggregate());
    // ── Extension function rename tests ────────────────────────────────────────
            rootNames
        Thread t = Thread.currentThread();
            "Plan.Root.names must match the wrapper aggregate's output schema (1 column), not the inner scan's (3 columns)",
        assertTrue("root must be a ProjectRel (outer lift)", root.hasProject());
        );
        );
    }
        java.nio.ByteBuffer payload = expanded.getExtensionSingle().getDetail().getValue().asReadOnlyByteBuffer();
            List.of()
        );
        boolean foundApproxDistinct = false;
    private AggregateCall buildListAggregateCall(RelNode input, int groupCount) {
        assertTrue(grouped.getInput() instanceof MultiValueExpandRel);
        // Root: AND with 2 args
        assertTrue("int column stays numeric (i32)", read.getBaseSchema().getStruct().getTypes(1).hasI32());
        assertEquals(-1, payload.getInt());
     * attachFragmentOnTop(Aggregate) → attachFragmentOnTop(Sort)), the outermost
        assertEquals(2, payload.getInt());
        AggregateFunction fn = agg.getMeasures(0).getMeasure();
        assertTrue("root must be a SortRel", root.hasSort());
            false,
        Rel underFetch = root.getFetch().getInput();
import org.opensearch.analytics.planner.rel.OpenSearchStageInputScan;
        RelDataType bigintType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
        assertAggregateImplKeys("max", "max:str", "max:bool");
     * adds str and bool overloads so PPL `stats min/max` over varchar / boolean fields binds.
            b.add(c, typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true));
        Rel root = rootRel(plan);
        for (int r = 0; r < 2; r++) {
        int childStageId = 3;
        RelNode rewritten = MultiValueRelRewriter.rewrite(PplAggregateCallRewriter.rewrite(aggregate));
            List.of(),
            cluster.traitSet(),
     * Mirror of multisearch's full coordinator-stage shape including the implicit
     * Substrait conversion.
            List.of("datafusion"),
        DataFusionFragmentConvertor convertor = newConvertor();
     * Substrait extension declarations — not the Calcite-native
        assertEquals(
            List.of("a", "rn"),
            SqlStdOperatorTable.APPROX_COUNT_DISTINCT,
        assertFalse("aggregate must have at least one measure", agg.getMeasuresList().isEmpty());
        assertEquals(0, payload.getInt());
import org.apache.calcite.rel.hint.RelHint;
        java.nio.ByteBuffer payload = root.getExtensionSingle().getDetail().getValue().asReadOnlyByteBuffer();
        assertEquals(
            List.of(),
                .map(declaration -> declaration.getExtensionFunction().getName())
        );
        // Use convertFragment so the inner Plan.Root.names is the 3-column scan list.
            SqlStdOperatorTable.SUM,
            List.of("sum_col"),
        // Wrap it in a no-op aggregate so the convertor accepts it as a final-agg fragment shape.
import org.apache.calcite.util.ImmutableBitSet;
        );
     * {@code Sort(Aggregate(Union(StageInputScan, StageInputScan, StageInputScan)))}.
            false,
            SqlStdOperatorTable.COUNT,
     * This was the residual failure signature ("2 uses for 6 names") that the
        cluster = RelOptCluster.create(planner, rexBuilder);
        Expression dp2 = notExpr.getScalarFunction().getArguments(0).getValue();
                    foundApproxDistinct = true;
            null,
     */
        Plan plan = decodeSubstrait(bytes);
    private RelDataTypeFactory typeFactory;
import org.apache.calcite.rel.core.Uncollect;
        assertEquals(List.of("input-" + childStageId), aggInput.getRead().getNamedTable().getNamesList());
            java.util.Set.of()
        RelDataType inputRowType = rowType("a");
            -1,
            }
        RelNode sin2 = new OpenSearchStageInputScan(cluster, cluster.traitSet(), 2, branchRowType, List.of("datafusion"), List.of());
            typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true),
     * order is applied before the limit.
            rootNames
            java.util.Set.of()
    }
            com.google.common.collect.ImmutableList.<org.apache.calcite.rex.RexFieldCollation>of(),
        AggregateCall listCall = AggregateCall.create(
            cluster,
     * {@code Fetch(inner)} — the limit then ran over an unordered concat-gather, so a multi-shard
        }
        LogicalSort sort = LogicalSort.create(placeholderInput, RelCollations.of(0), null, null);
                    foundSum = true;
            if (decl.hasExtensionFunction()) {
        assertNull(grouped.getInput().getRowType().getFieldList().get(1).getType().getComponentType());
     * RC-A regression: no-group {@code LIST(<scalar>)} at the reduce stage. The scalar→VARCHAR cast
            )
        try {
            scan,
            false,
        byte[] bytes = newConvertor().convertFragment(finalAgg);
            List.of("datafusion"),
        RexNode andCondition = rexBuilder.makeCall(SqlStdOperatorTable.AND, nativePred, delegated);
        LogicalAggregate aggregate = buildSumAggregate(union, 0);
        assertTrue("stage-input key must be declared with the element type: " + keyType, keyType.hasString());
        Rel partialAgg = inner.getProject().getInput();
        RelNode placeholderInput = buildTableScan("__placeholder__", "sum_col");
    }
        RexNode delegated1 = DelegatedPredicateFunction.makeCall(rexBuilder, 1);
        SqlAggFunction list = new SqlAggFunction(
                + "analytics-engine plan must not surface stale inner-plan names.",
            SqlKind.OTHER_FUNCTION,
        Rel root = rootRel(plan);
            ImmutableBitSet.of(0),
        );
            cluster,
        boolean foundSum = false;
    }
        Plan plan = decodeSubstrait(bytes);
                + "not be miswritten with a wider list",
        DataFusionFragmentConvertor convertor = newConvertor();
        assertTrue("FINAL aggregate must be emitted without an expansion Project", root.hasAggregate());
        AggregateCall count = AggregateCall.create(
        );
        assertAggregateImplKeys("min", "min:str", "min:bool");
            partialAgg.getAggregate()
import org.apache.calcite.rel.logical.LogicalUnion;
            null,
        } finally {
    }
            "PARTIAL GROUP BY key must still reference the appended expanded column",
    /**
        RelNode uncollect = Uncollect.create(cluster.traitSet(), project, false, List.of());
        RelNode scan = buildTableScan("test_index", "A", "B");
        FilterRel filterRel = rootRel(plan).getFilter();
        LogicalAggregate finalAgg = LogicalAggregate.create(
            input.getRowType().getFieldList().get(0).getType(),
        byte[] combinedBytes = convertor.attachFragmentOnTop(systemLimit, userSortBytes);
            values,
            assertTrue("row " + r + " char cell must be a string literal", row.getFields(0).getLiteral().hasString());
        // Build a bare partial-agg fragment whose input matches the inner's rowType.
        byte[] combined = convertor.attachFragmentOnTop(outerProject, innerBytes);
        RelDataType nullableInt = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true);
        );
                .getField()
            List.of(RelHint.builder(OpenSearchAggregate.FINAL_MODE_HINT).build()),
        );
            false,
     * (PPL {@code sort x | head N}, which Calcite merges into one node) lowers via isthmus to
            SimpleExtension.ExtensionCollection scalarExtensions = SimpleExtension.load(List.of("/opensearch_scalar_functions.yaml"));
    }
        // plan with 3-column rowType is enough to surface the wrapper-vs-inner names mismatch.
/**
        // Inner: final-agg over stage-input.
            null,
        RelNode scan = buildTableScan("test_index", "A", "B");
            SqlStdOperatorTable.COUNT,
            false,
            "count"
     * actual chain is:
            SqlStdOperatorTable.COUNT,
        assertTrue("LIST(scalar) measure arg must be a Cast (to VARCHAR), not a bare selection", arg.hasCast());
            OperandTypes.ANY,
        assertListAggregateUses("test_index", "mv_collect");
        assertFalse("plan must contain at least one relation", plan.getRelationsList().isEmpty());
        assertEquals("AND must have 2 arguments", 2, andFunc.getArgumentsCount());
        RelDataType element = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
        assertFalse("aggregate must have at least one measure", agg.getMeasuresList().isEmpty());
        LogicalAggregate aggregate = buildSumAggregate(union, 0);
        RelNode scan = buildListTableScan("test_index");
        DataFusionFragmentConvertor convertor = newConvertor();
     */
 * Tests for {@link DataFusionFragmentConvertor}. Each conversion method is
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true),
    }
     */
        RelDataType rowType = typeFactory.builder().add("name", varchar).add("age", intType).build();
    private RexBuilder rexBuilder;
        assertTrue("must find sum in extension declarations", foundSum);
    public void testConvertShardScanFragment_DelegatedPredicatePlaceholder() throws Exception {
     * extension survives re-serialization unchanged.
            -1,
        CorrelationId correlationId = cluster.createCorrel();
        assertEquals("explicit mvexpand appends its element for the frontend projection", 1, payload.getInt());
        // attachFragmentOnTop expects the wrapper to carry its real input so the
            cluster.traitSet(),
            childStageId,
        byte[] bytes = newConvertor().convertFragment(filter);
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
    /**
        assertTrue("root must be a FetchRel (the limit)", root.hasFetch());
            stageRowType,
        assertEquals(DataFusionFragmentConvertor.LOCAL_MV_COLLECT_OP, grouped.getAggCallList().get(0).getAggregation());
        RelNode limited = LogicalSort.create(uncollect, RelCollations.EMPTY, null, fetch);
        RexNode nativePred = rexBuilder.makeCall(
        RelNode scan = buildListTableScan(tableName);
        Rel inner = agg.getInput();
     * (PPL list/values is {@code ARRAY<VARCHAR>}) must ride the substrait measure arg, not a lifted
        // Inner: Union(Sin, Sin, Sin) — 6-column rows.
        );
            0,
        assertEquals(List.of("input-" + childStageId), aggInput.getRead().getNamedTable().getNamesList());
     */
 */
            0,
        RelNode scan = buildTableScan("test_index", "A", "B");
                String name = decl.getExtensionFunction().getName();
        Plan plan = decodeSubstrait(bytes);
     * with the placeholder preserved as a scalar function call in the FilterRel condition.
    public void testListOverSourceMultiValueRoutesToMvCollect() throws Exception {
        );
    }
        Expression.ScalarFunction andFunc = filterRel.getCondition().getScalarFunction();
            List.of()
        RelNode scan = buildListTableScan("test_index");
        Expression.ScalarFunction orFunc = orArg.getScalarFunction();
        // mirrors the swap performed by DataFusionPlugin#loadSubstraitExtensions.
        assertTrue("OR second arg must be scalar function (NOT)", notExpr.hasScalarFunction());
    }
        byte[] innerBytes = convertor.convertFragment(innerStageScan);
        // Aggregate over the union: SUM(a) → 1 column output ("sum_col").
            rootRel(decodeSubstrait(innerBytes)).getProject().getInput().getAggregate().getInput().hasExtensionSingle()
     * Builds a Calcite {@code LogicalTableScan} via the convertor's own
        Plan plan = decodeSubstrait(combined);
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
            List.of(),
        // System limit = LogicalSort with no collation + fetch literal. Lowers to a
        // Second arg should contain delegated_predicate with literal 7
            List.of(1),
    }
            Optionality.FORBIDDEN
        RexNode orClause = rexBuilder.makeCall(SqlStdOperatorTable.OR, delegated1, notDelegated2);
            "count"
    /**
            plan.getExtensionsList()
        );
        assertTrue("output projection restores the original group field name", root.hasProject());
            OperandTypes.ANY,
            RelCollations.EMPTY,
            false,
     * The stock proto converter turns unknown extensions into an empty-struct detail, so the
        ClassLoader prev = t.getContextClassLoader();
            SqlFunctionCategory.USER_DEFINED_FUNCTION,
        // Without the FINAL hint the same shape is a PARTIAL over a worker stage input and must still expand.
    }
     * FINAL aggregate must not expand again and its Read must declare the key as a string —
                .getGroupingExpressions(0)
            cluster,
     * with the outer's RexInputRefs pointing into the lower's appended window column, used
     * Multi-shard LIST GROUP BY: the coordinator decodes the shard-stage bytes (which carry the
                assertNotEquals("approx_distinct should not appear for SUM-only plan", "approx_distinct", baseName);
    private RelDataType rowType(String... columns) {
            ImmutableBitSet.of(),
        // Inner: final-agg over stage-input (same shape as testAttachFragmentOnTop_Sort).
        assertEquals(ImmutableBitSet.of(1, 2), grouped.getGroupSet());
        assertTrue("root must be a ReadRel", root.hasRead());
            lowerProject,
            -1,
     *     Sort(collation=byKey, fetch=∅)    // user-level sort, lowered to a Substrait Sort
        assertEquals(0, payload.getInt());
        RelNode lowerProject = org.apache.calcite.rel.logical.LogicalProject.create(
        LogicalAggregate aggregate = LogicalAggregate.create(
            aggLeaf,
        LogicalAggregate partial = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(count));
     * char column and every row cell are Str while the integer column stays i32. This is the generic
            childStageId,
        RelNode stageInput = new OpenSearchStageInputScan(
            (org.apache.calcite.sql.SqlAggFunction) SqlStdOperatorTable.ROW_NUMBER,
            t.setContextClassLoader(prev);
            List.of(correlatedTags),
        assertEquals(List.of("tags", "values"), output.getRowType().getFieldNames());
        DataFusionFragmentConvertor convertor = newConvertor();
            .collect(java.util.stream.Collectors.toSet());
        }
        };
     * {@code sort | head N} returned the first N rows in arrival order instead of sorted order.
            List.of(columnIndex),
        assertTrue("must be a VirtualTable", read.hasVirtualTable());
        return b.build();
        byte[] innerBytes = convertor.convertFragment(innerProject);
    }
        RelNode scan = buildTableScan("test_index", "A", "B");
     * multisearch coordinator-stage shape {@code Aggregate(Union(StageInputScan,
            SimpleExtension.ExtensionCollection delegationExtensions = SimpleExtension.load(List.of("/delegation_functions.yaml"));
    public void testAttachFragmentOnTop_Sort() throws Exception {
        byte[] combinedBytes = convertor.attachFragmentOnTop(sort, aggBytes);
        assertTrue("root must be an AggregateRel", root.hasAggregate());
        assertEquals(2, ((org.apache.calcite.rex.RexInputRef) output.getProjects().get(2)).getIndex());
        // arg[1]: OR with 2 args
            scan,
        ReadRel read = root.getRead();
import io.substrait.extension.DefaultExtensionCatalog;
            "LIST",
        byte[] innerBytes = convertor.convertFragment(finalAgg);
            cluster.traitSet(),
        ) {
    public void testListOverFinalStateRoutesToListMerge() throws Exception {
            true,
            arrayType,
            List.of(),
     * must rebuild the extension with its real output schema so the round trip succeeds and the
        assertEquals(2, dp2.getScalarFunction().getArguments(0).getValue().getLiteral().getI32());
    public void testAttachPartialAggOnTop_PlanRootNamesMatchWrapperOutput() throws Exception {
        RelDataType wideStageRowType = rowType("A", "B", "C");
            .add("tags", list)
        java.nio.ByteBuffer payload = expanded.getExtensionSingle().getDetail().getValue().asReadOnlyByteBuffer();
        RexNode andCondition = rexBuilder.makeCall(SqlStdOperatorTable.AND, nativePred, orClause);
            stageInput,
        RelNode filter = LogicalFilter.create(scan, andCondition);
        assertTrue("Aggregate input must be a ReadRel", inner.hasRead());
        RelDataType element = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
     * StageInputScan))}.
        assertTrue("OR first arg must be scalar function", dp1.hasScalarFunction());
        DataFusionFragmentConvertor convertor = newConvertor();
            wideStageRowType,
    }
            List.of(rexBuilder.makeInputRef(innerStage, 4)),
            0,
            rootNames
    }
        );
        ImmutableList<ImmutableList<RexLiteral>> tuples = ImmutableList.of(
     * pre-expansion ARRAY key, but the PARTIAL fragment already emits the scalar element, so the
import io.substrait.proto.SortRel;
            SqlFunctionCategory.USER_DEFINED_FUNCTION,
     */
        RelNode sin1 = new OpenSearchStageInputScan(cluster, cluster.traitSet(), 1, branchRowType, List.of("datafusion"), List.of());
        );
            stageRowType,
        );
        // Inner scan has 3 columns; the partial-aggregate emits 1 (sum over col 0).
     */
     */
        LogicalProject output = (LogicalProject) rewritten;
            cluster.traitSet(),
     * the conventional {@code "input-0"} when childStageId is 0.
    public void testConvertFinalAggFragment_WithStageInputScanLeaf() throws Exception {
    public void testFinalAggregateRetypesExpandedStageInputKeyInsteadOfExpanding() throws Exception {
        // the multisearch-style schema reshape that triggered the bug. We model it as another
            rexBuilder.makeInputRef(scan, 0),
 */
    public void testExplicitMvExpandCorrelateEmitsAppendExtensionWithLimit() throws Exception {
        );
            "partial-agg phase must be INITIAL_TO_INTERMEDIATE",
            List.of(),
            ImmutableBitSet.of(0),
        DataFusionFragmentConvertor convertor = newConvertor();
     * Regression: {@code attachPartialAggOnTop} must populate {@code Plan.Root.names}
            cluster,
        Plan plan = decodeSubstrait(bytes);
            List.of(buildListAggregateCall(scan, 0))
        io.substrait.proto.Type keyType = input.getRead().getBaseSchema().getStruct().getTypes(0);
}
        assertTrue("Sort input must be the rewired inner AggregateRel", underSort.hasAggregate());
    /** Decodes Substrait proto bytes into a {@link Plan}. */
        java.util.Set<String> actual = extensions.aggregateFunctions()
        byte[] combined = convertor.attachFragmentOnTop(sortLimit, innerBytes);
        Plan plan = decodeSubstrait(bytes);
    }
        LogicalSort systemLimit = LogicalSort.create(userSort, RelCollations.EMPTY, null, fetchN);
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
            List.of(0),
        byte[] bytes = convertor.attachFragmentOnTop(agg, innerBytes);
        Rel aggInput = inner.getAggregate().getInput();
        );
        LogicalSort sort = LogicalSort.create(aggregate, RelCollations.of(0), null, null);
            -1,
     * After the convertor chain runs (convertFragment(Union) →
        assertFalse("scalar function must have arguments", scalarFunc.getArgumentsList().isEmpty());
        // Inner: Union(Sin, Sin, Sin) — three branches, each 6 columns wide.
import org.apache.calcite.sql.type.OperandTypes;
            .add("tags", element)
    public void testListGroupByAddsDistinctAppendExpansion() throws Exception {
        LogicalUnion union = LogicalUnion.create(List.of(sin1, sin2, sin3), true);
        assertEquals(
     *
    /**
import org.apache.calcite.rex.RexNode;
        AggregateRel agg = root.getAggregate();
     * {@code Plan.Root.names} with the aggregate's output names. Mirrors the
        RelNode scan = buildListTableScan("test_index");
import io.substrait.proto.AggregateFunction;
