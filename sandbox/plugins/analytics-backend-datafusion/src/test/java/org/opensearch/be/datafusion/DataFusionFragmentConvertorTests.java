        RelDataType bigintType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
        List<String> rootNames = plan.getRelations(0).getRoot().getNamesList();  
     * the wrapper reshapes the schema (Aggregate, Project, etc).
        return b.build();
     * Substrait's stdlib only defines min/max for i8..fp64; opensearch_aggregate_functions.yaml  
     */  
            List.of("datafusion"),
            -1,
import org.apache.calcite.rel.logical.LogicalValues;
            List.of(),  
    /**  
        RelDataType list = typeFactory.createTypeWithNullability(typeFactory.createArrayType(element, -1), true);
import org.apache.calcite.rel.logical.LogicalSort;
        assertEquals(2, ((org.apache.calcite.rex.RexInputRef) output.getProjects().get(2)).getIndex());
    }
        return AggregateCall.create(
        // Contract: attachFragmentOnTop receives a childless operator. Sort requires an
            )
    /**  
            }
 *
            false,
        );  
        Rel root = rootRel(plan);
        try {  
     * A precision-unspecified VARCHAR Values converts straight through isthmus to a VirtualTable whose
        return LogicalAggregate.create(input, List.of(), ImmutableBitSet.of(), null, List.of(sumCall));
        byte[] combined = convertor.attachFragmentOnTop(outerProject, innerBytes);  
        byte[] combined = convertor.attachFragmentOnTop(sortWrapper, innerBytes);  
 * this file be licensed under the Apache-2.0 license or a
        RelNode lowerProject = org.apache.calcite.rel.logical.LogicalProject.create(
     */
        RelNode filter = LogicalFilter.create(scan, placeholder);  
    /**
                .getStructField()  
    }  
    public void testListOverSourceMultiValueRoutesToMvCollect() throws Exception {  
        assertTrue("first AND arg must be a scalar function (GT)", gtArg.hasScalarFunction());  
            SqlStdOperatorTable.GREATER_THAN,  
        );  
        assertEquals(-1, payload.getInt());
        RelNode rewritten = MultiValueRelRewriter.rewrite(PplAggregateCallRewriter.rewrite(aggregate));  
        RelNode placeholderInput = buildTableScan("__placeholder__", "sum_col");  
     */
            cluster,
     * A {@code Filter(Scan)} fragment converts to {@code FilterRel(ReadRel)}.  
    public void testListAggregateGroupedBySameMultiValueFieldPreservesListInput() {
import org.apache.calcite.plan.RelOptCluster;  
    public void testListGroupByAddsDistinctAppendExpansion() throws Exception {
    }  
            List.of(count)  
        byte[] combined = newConvertor().attachFragmentOnTop(finalAgg, innerBytes);  
            ),
        byte[] aggBytes = convertor.attachFragmentOnTop(aggregate, unionBytes);
     * Attaching a partial aggregate on top of inner bytes yields an  
     * Builds a Calcite {@code LogicalTableScan} via the convertor's own
            typeFactory.createSqlType(SqlTypeName.BIGINT),
     * AND(A > 10, OR(delegated_predicate(1), NOT(delegated_predicate(2)))) — complex boolean tree.
            ReturnTypes.ARG0,
    }  
        Thread t = Thread.currentThread();
    }  
            List.of("datafusion"),
        byte[] bytes = newConvertor().convertFragment(agg);
        assertEquals("OR must have 2 arguments", 2, orFunc.getArgumentsCount());
    public void testConvertShardScanFragment_DelegatedPredicatePlaceholder() throws Exception {  
        RelNode placeholderInput = buildTableScan("__placeholder__", "a");  
                .map(declaration -> declaration.getExtensionFunction().getName())
     * FINAL half of a multi-shard LIST GROUP BY. The stage input is still typed with the  
        Expression.ScalarFunction andFunc = filterRel.getCondition().getScalarFunction();
import org.apache.calcite.rel.hint.RelHint;  
        DataFusionFragmentConvertor convertor = newConvertor();
        LogicalAggregate aggregate = LogicalAggregate.create(
        assertTrue("must be a VirtualTable", read.hasVirtualTable());  
import java.util.List;
            listOp,  
     * A final-agg fragment whose leaf is an {@link OpenSearchStageInputScan}  
        OpenSearchStageInputScan innerStage = new OpenSearchStageInputScan(  
            list,
     * Substrait AND has two children: GT scalar function and delegated_predicate scalar function.
        OpenSearchStageInputScan aggLeaf = new OpenSearchStageInputScan(  
        assertEquals(7, delegatedArg.getScalarFunction().getArguments(0).getValue().getLiteral().getI32());  
        Rel partialAgg = inner.getProject().getInput();  
import org.apache.calcite.sql.type.SqlTypeName;
    public void testConvertFinalAggFragment_WithStageInputScanLeaf() throws Exception {  
     */
    }
        Expression dp2 = notExpr.getScalarFunction().getArguments(0).getValue();
     * StageInputScan))}.
        // the multisearch-style schema reshape that triggered the bug. We model it as another
 * and assertions are made on proto shape — not serialized string content.  
            List.of()
     * A filter containing {@code delegated_predicate(42)} converts to Substrait  
        byte[] bytes = newConvertor().convertFragment(scan);
            bigintType,
    }  
        assertTrue("FilterRel must carry a condition", filterRel.hasCondition());
        assertNotNull("convertor bytes must not be null", bytes);  
            List.of(),  
     */
            rexBuilder.makeInputRef(scan, 0),  
            t.setContextClassLoader(prev);  
        assertEquals("opensearch://analytics/multi_value_expand/v1", expanded.getExtensionSingle().getDetail().getTypeUrl());
    }
    }
        LogicalProject output = (LogicalProject) rewritten;
        byte[] bytes = newConvertor().convertFragment(filter);
            plan.getExtensionsList()
        );
    public void testAttachFragmentOnTopDecodesMultiValueExpandExtension() throws Exception {
        for (String c : columns) {
            null,  
            SqlStdOperatorTable.COUNT,
            }  
            cluster,  
        for (SimpleExtensionDeclaration decl : plan.getExtensionsList()) {
        Rel innerOfOuter = root.getProject().getInput();
    private RelOptCluster cluster;
        assertTrue("second AND arg must be a scalar function (OR)", orArg.hasScalarFunction());
            ReturnTypes.TO_ARRAY.andThen(SqlTypeTransforms.FORCE_NULLABLE),  
        ImmutableList<ImmutableList<RexLiteral>> tuples = ImmutableList.of(  
            -1,
            SqlStdOperatorTable.SUM,  
            -1,  
     * to lose its lower layer when re-wired. The next attach-on-top then crashed deserialising
        FilterRel filterRel = rootRel(plan).getFilter();
        );
     * {@code Fetch(Sort(input))} — two Substrait rels from one operator. {@code attachFragmentOnTop}
    /** Decodes Substrait proto bytes into a {@link Plan}. */
        RelNode scan = buildTableScan("test_index", "A", "B");  
            List.of()  
            "Plan.Root.names must reflect the system-limit Sort wrapper's output (= 1-column aggregate output), "  
            Optionality.FORBIDDEN  
    /**
            input.getRowType().getFieldList().get(0).getType(),
     * PARTIAL aggregate's GROUP BY field reference fails with  
            List.of("sum_col"),
            List.of(),
        Rel root = rootRel(decodeSubstrait(combined));
            innerProject.getRowType(),
        );
    /** Extracts the single root {@link Rel} of a Substrait {@link Plan}. */
     * otherwise DataFusion rejects the plan with "Field 'tags' in Substrait schema has a  
        }  
import org.apache.calcite.sql.SqlKind;  
            "partial-agg phase must be INITIAL_TO_INTERMEDIATE",
        Rel root = rootRel(plan);  
    }  
    public void setUp() throws Exception {
     */
            cluster.traitSet(),
     */
        Plan plan = decodeSubstrait(bytes);
        assertEquals("final-agg phase must be INITIAL_TO_RESULT", AggregationPhase.AGGREGATION_PHASE_INITIAL_TO_RESULT, fn.getPhase());
        );
        RelNode values = LogicalValues.createOneRow(cluster);
import org.apache.calcite.rel.logical.LogicalUnion;  
     * {@code make_renamed_schema} with "Names list must match exactly to nested  
        byte[] combinedBytes = convertor.attachFragmentOnTop(sort, aggBytes);
        super.setUp();  
        assertEquals("int cell stays i32", 30, read.getVirtualTable().getExpressions(0).getFields(1).getLiteral().getI32());
        assertTrue("outer's input must remain the lower lift Project", innerOfOuter.hasProject());  
        RelNode sin1 = new OpenSearchStageInputScan(cluster, cluster.traitSet(), 1, branchRowType, List.of("datafusion"), List.of());  
            List.of(columnIndex),  
        assertEquals(
        assertFalse("aggregate must have at least one measure", agg.getMeasuresList().isEmpty());
            List.of(),
        Plan plan = decodeSubstrait(newConvertor().convertFragment(aggregate));
            childStageId,
            "Plan.Root.names must reflect the Sort wrapper's output (= aggregate's 1-column output), "
        Rel aggInput = inner.getAggregate().getInput();  
        // Inner: a final-agg fragment whose StageInputScan rowType is intentionally wide  
        // Aggregate over the union: SUM(a) → 1 column.
        assertEquals("opensearch://analytics/multi_value_expand/v1", expanded.getExtensionSingle().getDetail().getTypeUrl());
        byte[] bytes = newConvertor().convertFragment(filter);
        LogicalAggregate partial = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(count));  
    }  
     * must rewire the inner plan under the Sort, preserving {@code Fetch(Sort(inner))} so the global  
            lowerProject,
            scan,
            "Plan.Root.names must match the wrapper aggregate's output schema (1 column), not the inner scan's (3 columns)",
     */  
     * {@code SortRel(<inner>)}.
                .map(name -> name.contains(":") ? name.substring(0, name.indexOf(':')) : name)  
     * with "Field reference offset (N) must be less than number of fields in struct (N)".
        assertEquals(2, payload.getInt());  
            false,
                }  
        Rel root = rootRel(plan);  
            typeFactory.createSqlType(SqlTypeName.BIGINT),  
        assertFalse("aggregate must have at least one measure", agg.getMeasuresList().isEmpty());
    }
            "expected aggregate extension " + expectedFunction,
        Rel aggregateRel = root.getProject().getInput();
            rootRel(decodeSubstrait(innerBytes)).getProject().getInput().getAggregate().getInput().hasExtensionSingle()
        java.nio.ByteBuffer payload = expanded.getExtensionSingle().getDetail().getValue().asReadOnlyByteBuffer();
            false,
            List.of(1),
     * path that {@code OpenSearchValuesCharNormalizeRule} feeds after normalising a raw CHAR Values.  
        );
        RelNode placeholderInput = buildTableScan("__placeholder__", "sum_col");  
        );
        assertTrue("root must be an AggregateRel", root.hasAggregate());
    private DataFusionFragmentConvertor newConvertor() {
        LogicalAggregate finalAgg = buildSumAggregate(stageInput, 0);  
            "l"  
        RelDataType stageRowType = rowType("A");
    }
        assertEquals(
            assertTrue("row " + r + " char cell must be a string literal", row.getFields(0).getLiteral().hasString());  
            typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true),
                }
    }
        assertTrue("int column stays numeric (i32)", read.getBaseSchema().getStruct().getTypes(1).hasI32());
            ImmutableBitSet.of(0),
        org.apache.calcite.rel.logical.LogicalProject innerProject = org.apache.calcite.rel.logical.LogicalProject.create(
        assertTrue("condition must be a scalar function", filterRel.getCondition().hasScalarFunction());  
        // Wrapper: LIST(picked) with NO group-by, over a 1-column placeholder (the inner's output shape).
    private RelNode buildListTableScan(String tableName) {  
 * SPDX-License-Identifier: Apache-2.0
     * one-element named-table reference.
import io.substrait.proto.FilterRel;  
        LogicalAggregate aggregate = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(count));
                + "not be miswritten with a wider list",  
        RexNode fetchN = rexBuilder.makeLiteral(5, typeFactory.createSqlType(SqlTypeName.INTEGER), true);  
        AggregateCall listCall = AggregateCall.create(
        assertTrue("Sort must be preserved under the Fetch (global order before the limit), not dropped", underFetch.hasSort());  
        assertTrue("FINAL aggregate must be emitted without an expansion Project", root.hasAggregate());
            false,
import io.substrait.proto.SortRel;  
            childStageId,  
        DataFusionFragmentConvertor convertor = newConvertor();
        assertEquals(List.of("test_index"), inner.getRead().getNamedTable().getNamesList());
            rexBuilder.makeInputRef(scan, 0),  
        RelDataType wideStageRowType = rowType("A", "B", "C");
     * Attaching a {@link LogicalSort} on top of inner bytes yields  
     * RC-A regression: no-group {@code LIST(<scalar>)} at the reduce stage. The scalar→VARCHAR cast  
        rexBuilder = new RexBuilder(typeFactory);
        // standalone visitor can derive types; the input is discarded by rewire.
        LogicalSort sort = LogicalSort.create(aggregate, RelCollations.of(0), null, null);
            List.of(sumCounts)
    @Override
        byte[] bytes = convertor.attachFragmentOnTop(agg, innerBytes);
     */
            SqlStdOperatorTable.SUM,  
import org.apache.calcite.rel.type.RelDataType;
            org.apache.calcite.rex.RexWindowBounds.UNBOUNDED_PRECEDING,  
            scan,
        Rel root = rootRel(plan);  
import org.apache.calcite.util.Optionality;
        assertEquals("AND must have 2 arguments", 2, andFunc.getArgumentsCount());
     * {@code Sort(Aggregate(Union(StageInputScan, StageInputScan, StageInputScan)))}.
    }  
        RelNode stageInput = new OpenSearchStageInputScan(cluster, cluster.traitSet(), 1, partialRowType, List.of("datafusion"), List.of());
        for (int r = 0; r < 2; r++) {
     *     Sort(collation=byKey, fetch=∅)    // user-level sort, lowered to a Substrait Sort
            List.of(),
            org.apache.calcite.rex.RexWindowBounds.CURRENT_ROW,
        RelNode scan = buildTableScan("test_index", "A", "B");
        assertTrue("OR second arg must be scalar function (NOT)", notExpr.hasScalarFunction());
        assertEquals("explicit mvexpand preserves duplicate elements", 0, payload.getInt());
        PlanRel planRel = plan.getRelationsList().get(0);
        );  
        assertAggregateImplKeys("max", "max:str", "max:bool");
        LogicalSort systemLimit = LogicalSort.create(userSort, RelCollations.EMPTY, null, fetchN);  
import io.substrait.proto.AggregateRel;  
        assertTrue(
        assertEquals(1, payload.getInt());
        RelNode scan = buildListTableScan(tableName);  
        LogicalSort sortWrapper = LogicalSort.create(placeholderInput, RelCollations.of(0), null, null);
        assertEquals(1, ((org.apache.calcite.rex.RexInputRef) output.getProjects().get(0)).getIndex());
            cluster.traitSet(),
     * After the convertor chain runs (convertFragment(Union) →  
            -1,  
import org.apache.calcite.rex.RexLiteral;
        RelDataType varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);  
            List.of(),  
            false,
            "count"
        Expression delegatedArg = andFunc.getArguments(1).getValue();
 *
            null,
        // arg[1]: OR with 2 args  
        byte[] unionBytes = convertor.convertFragment(union);
    public void testAttachFragmentOnTop_SortWithFetch_PreservesSortUnderFetch() throws Exception {
        assertTrue("Aggregate input must be a ReadRel", inner.hasRead());
     * Verifies nested AND/OR/NOT with delegation placeholders and their annotation IDs survive
            .map(SimpleExtension.Function::key)  
        assertTrue(rewritten instanceof LogicalProject);
    private void assertAggregateImplKeys(String name, String... expectedKeys) {
                + "not the inner Union's 6-column row type — multisearch ThreeSubsearches regression",
import org.apache.calcite.rel.logical.LogicalFilter;  
            false,
     * the inner width, panicking native DataFusion. Asserts the arg is a Cast over original field 0.  
            stageRowType,
            List.of(buildListAggregateCall(scan, 0))  
import org.apache.calcite.sql.type.ReturnTypes;  
            "the cast must wrap the ORIGINAL input field (index 0), not a lifted/appended column",
        RelNode outerProject = org.apache.calcite.rel.logical.LogicalProject.create(
        RelNode sin3 = new OpenSearchStageInputScan(cluster, cluster.traitSet(), 3, branchRowType, List.of("datafusion"), List.of());
            null,
            rootNames
        assertNotNull(grouped.getInput().getRowType().getFieldList().get(0).getType().getComponentType());
        Expression gtArg = andFunc.getArguments(0).getValue();
    }
        assertEquals(2, dp2.getScalarFunction().getArguments(0).getValue().getLiteral().getI32());
        // Inner: Union(Sin, Sin, Sin) — 6-column rows.
        RelNode scan = buildTableScan("test_index", "A", "B");
        }
        );
import io.substrait.proto.SimpleExtensionDeclaration;
            false,
        RelDataTypeFactory.Builder b = typeFactory.builder();  
            ImmutableList.of(
                if (baseName.equals("approx_distinct")) {
            cluster,
            List.of(),
    public void testMultisearchShape_SystemLimitOverSortOverAggregateOverUnion_NamesMatchTopOutput() throws Exception {
            List.of("datafusion"),
        assertFalse("scalar function must have arguments", scalarFunc.getArgumentsList().isEmpty());  
     */  
        AggregateCall sumCounts = AggregateCall.create(
            cluster.traitSet(),
        AggregateFunction fn = agg.getMeasures(0).getMeasure();
            0,  
     * actual chain is:
import org.apache.calcite.rel.type.RelDataTypeFactory;  
     * Mirror of multisearch's full coordinator-stage shape including the implicit  
        LogicalAggregate finalAgg = buildSumAggregate(stageInput, 0);
    }
            stageRowType,
        assertEquals(ImmutableBitSet.of(1, 2), grouped.getGroupSet());
    }  
        // Use convertFragment so the inner Plan.Root.names is the 3-column scan list.
            List.of()
        for (String key : expectedKeys) {
     * AND(A > 10, delegated_predicate(7)) — mixed native + delegated.  
            rootNames
        RexNode nativePred = rexBuilder.makeCall(
        assertTrue("plan relation must carry a root", planRel.hasRoot());  
            List.of(buildListAggregateCall(scan, 1))  
        RexNode delegated2 = DelegatedPredicateFunction.makeCall(rexBuilder, 2);
        LogicalAggregate aggregate = buildSumAggregate(union, 0);
        RexNode rowNumberOver = rexBuilder.makeOver(  
        assertEquals(-1, payload.getInt());
        };
        );
        // arg[0]: GT (native predicate) — has field ref and literal 10
                if (baseName.equals("sum")) {  
import org.apache.calcite.sql.type.OperandTypes;
     */
            fn.getPhase()  
        assertTrue(aggregateRel.hasAggregate());
     * {@code Fetch(inner)} — the limit then ran over an unordered concat-gather, so a multi-shard
import io.substrait.extension.DefaultExtensionCatalog;  
            SimpleExtension.ExtensionCollection scalarExtensions = SimpleExtension.load(List.of("/opensearch_scalar_functions.yaml"));
     * different type (List(Utf8)) than the corresponding field in the table schema (Utf8View)".
        assertTrue(  
        RelNode scan = buildTableScan("test_index", "A");  
        DataFusionFragmentConvertor convertor = newConvertor();
     */
        RelDataType stageRowType = rowType("A");
            null,
        CorrelationId correlationId = cluster.createCorrel();
        // Wrap it in a no-op aggregate so the convertor accepts it as a final-agg fragment shape.
        assertTrue(output.getInput() instanceof org.apache.calcite.rel.core.Aggregate);
            List.of(),  
        assertEquals(List.of("test_index"), read.getNamedTable().getNamesList());
            "LIST",
        RelDataType type = typeFactory.builder().add("tags", list).build();  
        int childStageId = 7;
        // isthmus lowers this single node to Fetch(Sort(Read)); the rewire must keep the Sort.
        );
        assertTrue("must find sum in extension declarations", foundSum);
            .collect(java.util.stream.Collectors.toSet());
            com.google.common.collect.ImmutableList.<org.apache.calcite.rex.RexFieldCollation>of(),
                String baseName = name.contains(":") ? name.substring(0, name.indexOf(':')) : name;
            1,  
    }  
     * converts to {@code AggregateRel(ReadRel(namedTable=["input-<childStageId>"]))}.
            typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true),
        return new DataFusionFragmentConvertor(extensions);
                String name = decl.getExtensionFunction().getName();  
        RelDataType list = typeFactory.createTypeWithNullability(typeFactory.createArrayType(element, -1), true);
        // System limit = LogicalSort with no collation + fetch literal. Lowers to a  
            (org.apache.calcite.sql.SqlAggFunction) SqlStdOperatorTable.ROW_NUMBER,
        );  
     */  
                + "not the inner Union's 6-column row type — the implicit limit at the top of every "
import io.substrait.proto.AggregationPhase;
 */  
        assertEquals(List.of("input-" + childStageId), aggInput.getRead().getNamedTable().getNamesList());
     * name remains unchanged.
            false,
    }  
            List.of(),  
    public void testFinalAggregateRetypesExpandedStageInputKeyInsteadOfExpanding() throws Exception {  
            RelCollations.EMPTY,
    private Rel rootRel(Plan plan) {  
        assertTrue("root must be a SortRel", root.hasSort());
        Plan plan = decodeSubstrait(bytes);
        RexNode delegated = DelegatedPredicateFunction.makeCall(rexBuilder, 7);
        RelDataType arrayType = typeFactory.createTypeWithNullability(typeFactory.createArrayType(nullableInt, -1), true);
     */
        RelDataType element = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
import org.apache.calcite.sql.SqlAggFunction;
                    foundSum = true;
import org.apache.calcite.rel.core.JoinRelType;
        AggregateRel agg = root.getAggregate();  
                RexLiteral.fromJdbcString(varchar, SqlTypeName.CHAR, "Alice"),
        Rel root = rootRel(plan);
            ImmutableBitSet.of(0),  
        byte[] combined = convertor.attachFragmentOnTop(sortLimit, innerBytes);  
     * The stage-input id is per-child so multi-input shapes (Union) get distinct names
    public void testConvertShardScanFragment_TableScan() throws Exception {
        java.nio.ByteBuffer payload = expanded.getExtensionSingle().getDetail().getValue().asReadOnlyByteBuffer();  
    public void testListGroupByRemapsGroupingSetsAndRestoresOutputOrder() {  
     * multi-value expand as an {@code ExtensionSingleRel}) to splice the FINAL aggregate on top.
        RelNode uncollect = Uncollect.create(cluster.traitSet(), project, false, List.of());  
        List<String> rootNames = plan.getRelations(0).getRoot().getNamesList();
        // Root: AND with 2 args  
        LogicalAggregate innerFinalAgg = buildSumAggregate(innerStageScan, 0);
        org.apache.calcite.rel.core.Aggregate grouped = (org.apache.calcite.rel.core.Aggregate) output.getInput();
            input,  
        RelDataType element = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
            -1,  
     * The stock proto converter turns unknown extensions into an empty-struct detail, so the
        );
        RelDataType list = typeFactory.createTypeWithNullability(typeFactory.createArrayType(element, -1), true);
    }
        assertEquals(  
            b.add(c, typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true));
        );  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        RelDataType inputType = typeFactory.builder()  
package org.opensearch.be.datafusion;
    public void testConvertShardScanFragment_MixedNativeAndDelegated() throws Exception {  
 * Tests for {@link DataFusionFragmentConvertor}. Each conversion method is  
     * Regression: a single Calcite {@link LogicalSort} carrying BOTH a collation and a {@code fetch}  
        // input for row-type validation in the isthmus visitor; give it a bare placeholder  
        assertTrue("Filter input must be a ReadRel", inner.hasRead());
            SqlStdOperatorTable.SUM,
            "count"
import org.apache.calcite.sql.SqlFunctionCategory;
            if (decl.hasExtensionFunction()) {
        byte[] userSortBytes = convertor.attachFragmentOnTop(userSort, aggBytes);
    }  
        };  
        assertEquals(42, scalarFunc.getArguments(0).getValue().getLiteral().getI32());
        byte[] unionBytes = convertor.convertFragment(union);
            cluster,
        // Wrapper: ONE LogicalSort carrying a collation (order by col 0) AND a fetch (head 5).  
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        } finally {
            cluster,
        RelDataType element = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
        assertEquals(DataFusionFragmentConvertor.LOCAL_MV_COLLECT_OP, grouped.getAggCallList().get(0).getAggregation());  
    private SimpleExtension.ExtensionCollection extensions;
        Plan plan = decodeSubstrait(bytes);
            List.of(RelHint.builder(OpenSearchAggregate.FINAL_MODE_HINT).build()),  
            Expression.Nested.Struct row = read.getVirtualTable().getExpressions(r);
            List.of(),
        Expression.ScalarFunction orFunc = orArg.getScalarFunction();  
        assertTrue("FilterRel must carry a condition", filterRel.hasCondition());
import org.apache.calcite.rel.RelCollations;  
                    foundApproxDistinct = true;
     * extension survives re-serialization unchanged.  
    public void testMinMaxYamlDeclaresStringAndBooleanOverloads() {  
            "StageInputScan must be emitted as a ReadRel with the per-child stage-input id",
        assertTrue(root.hasExtensionSingle());  
            List.of(),  
     * A bare table scan converts to a {@code ReadRel} whose named table carries
        Expression notExpr = orFunc.getArguments(1).getValue();  
            false,
        assertFalse("plan must contain at least one relation", plan.getRelationsList().isEmpty());
            t.setContextClassLoader(DataFusionFragmentConvertorTests.class.getClassLoader());
            .add("tags", element)
     */
        LogicalAggregate aggregate = LogicalAggregate.create(
                .getGroupingExpressions(0)  
import io.substrait.proto.Rel;
        Plan plan = decodeSubstrait(combined);  
            List.of(),
            cluster.traitSet(),
        assertTrue("Agg input must be a ReadRel", aggInput.hasRead());
 * exercised independently against a Calcite RelNode constructed in-process,
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            0,  
            List.of(correlatedTags),
        );
        RelNode placeholderInput = buildTableScan("__placeholder__", "sum_col");
     * attachFragmentOnTop(Aggregate) → attachFragmentOnTop(Sort)), the outermost
        assertTrue("root must be an AggregateRel", root.hasAggregate());
import org.apache.calcite.rel.logical.LogicalCorrelate;
        RelNode scan = buildTableScan("test_index", "A");
        FilterRel filterRel = root.getFilter();
        assertTrue("root must be a FilterRel", root.hasFilter());  
        // Inner scan has 3 columns; the partial-aggregate emits 1 (sum over col 0).
        assertTrue("NOT arg must be scalar function", dp2.hasScalarFunction());  
     * for each registered DataFusion partition; single-input shapes still arrive at  
    private Plan decodeSubstrait(byte[] bytes) throws Exception {
     * {@code Plan.Root.names} must reflect the Sort's output schema (= the
        for (SimpleExtensionDeclaration decl : plan.getExtensionsList()) {
     * must rebuild the extension with its real output schema so the round trip succeeds and the
        SqlAggFunction list = new SqlAggFunction(  
import org.opensearch.test.OpenSearchTestCase;
        RexNode predicate = rexBuilder.makeCall(
            SimpleExtension.ExtensionCollection aggregateExtensions = SimpleExtension.load(List.of("/opensearch_aggregate_functions.yaml"));  
        Rel root = rootRel(plan);
        );
        assertEquals(0, payload.getInt());
}
            List.of("datafusion"),
     *         Union(Sin, Sin, Sin)  
        assertTrue("root must be a FilterRel", root.hasFilter());  
            List.of(1),
            wideStageRowType,
     * SUM aggregate is not affected by the rename map — its extension function
            OperandTypes.ANY,  
        Rel inner = sortRel.getInput();
        );
        assertEquals(  
        assertTrue("LIST(scalar) measure arg must be a Cast (to VARCHAR), not a bare selection", arg.hasCast());  
        return planRel.getRoot().getInput();
        boolean foundApproxDistinct = false;
import org.apache.calcite.rex.RexNode;  
        );  
            grouped.getGroupSets()
import com.google.common.collect.ImmutableList;
        RelNode left = buildListTableScan("test_index");
     * order is applied before the limit.
        AggregateCall count = AggregateCall.create(
        assertEquals(  
    public void testConvertShardScanFragment_ComplexBooleanTreeWithDelegation() throws Exception {
public class DataFusionFragmentConvertorTests extends OpenSearchTestCase {  
import io.substrait.proto.AggregateFunction;
    /**
        );
        );
        Rel root = rootRel(decodeSubstrait(newConvertor().convertFragment(finalAgg)));  
        RelNode scan = buildListTableScan("test_index");  
            rootNames
     * Regression: {@code attachFragmentOnTop} for an Aggregate over a multi-column  
        assertTrue("ReadRel must reference a named table", read.hasNamedTable());
        assertEquals(List.of("tags", "count"), plan.getRelations(0).getRoot().getNamesList());
        LogicalAggregate aggregate = buildSumAggregate(union, 0);  
        // (3 columns). The aggregate above narrows it to 1 column.
            cluster.traitSet(),
        );
import org.apache.calcite.rel.core.CorrelationId;  
            0,
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
     * Substrait extension declarations — not the Calcite-native
            aggLeaf,
        assertTrue(partialAgg.hasAggregate());
    public void testAttachFragmentOnTop_AggregateOverMultiColumnInner_PlanRootNamesMatchWrapperOutput() throws Exception {  
import io.substrait.extension.SimpleExtension;
        // Sort is rewired over the inner agg.  
import org.opensearch.analytics.planner.rel.OpenSearchStageInputScan;  
    public void testAttachFragmentOnTop_PreservesLiftedWindowProjectLayer() throws Exception {
        Rel input = root.getAggregate().getInput();
        LogicalAggregate partialAgg = buildSumAggregate(scan, 0);
            List.of(rexBuilder.makeInputRef(placeholderInput, 0), rowNumberOver),
        );
        RexNode orClause = rexBuilder.makeCall(SqlStdOperatorTable.OR, delegated1, notDelegated2);  
        );  
        RelNode filter = LogicalFilter.create(scan, predicate);  
        assertEquals("GROUP BY must use the appended scalar field", ImmutableBitSet.of(1), grouped.getGroupSet());
        // Root condition is AND (scalar function with 2 args)
    public void testAttachFragmentOnTop_NoGroupListOverScalar_MeasureArgIsVarcharCastOverOriginalField() throws Exception {
        RelDataType rowType = typeFactory.builder().add("name", varchar).add("age", intType).build();
    }  
        Rel root = rootRel(plan);
     * the conventional {@code "input-0"} when childStageId is 0.
        boolean foundSum = false;  
        RelNode scan = buildTableScan("test_index", "A", "B");  
        Plan plan = decodeSubstrait(combinedBytes);
        byte[] bytes = newConvertor().convertFragment(filter);
        // Aggregate is rewired over the inner plan's root ReadRel.
            List.of(rexBuilder.makeInputRef(innerStage, 4)),
        assertTrue("Sort input must be an AggregateRel", inner.hasAggregate());
        assertEquals(
        RelDataType branchRowType = rowType("a", "b", "c", "d", "e", "f");
            -1,
        // OR arg[0]: delegated_predicate(1)  
        FilterRel filterRel = rootRel(plan).getFilter();
     * with the *wrapper aggregate's* output column names — not the inner scan's.
            false,
            List.of("datafusion"),
     * subclass that the isthmus visitor emits as a {@link ReadRel} with a
            scan,
            false,  
            "sum_col"  
    private RexBuilder rexBuilder;  
        // attachFragmentOnTop expects the wrapper to carry its real input so the
    public void testOtherFunctionsNotRenamed() throws Exception {
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(), null, List.of(approxCall));
        assertTrue("FINAL aggregate must sit on the shard fragment's output projection", inner.hasProject());
        // User-level Sort by the single agg-output column — schema preserved.
        // Load the Substrait extension catalog with the test classloader as TCCL —
        RelNode filter = LogicalFilter.create(scan, andCondition);  
     * query-size LIMIT injected by {@code QueryService.convertToCalcitePlan}. The
        // Verify the argument is literal i32 = 42
            "shard fragment must carry the expand extension",  
    public void testExplicitMvExpandCorrelateEmitsAppendExtensionWithLimit() throws Exception {  
import org.apache.calcite.rel.logical.LogicalProject;
        assertTrue("Sort input must be the rewired inner AggregateRel", underSort.hasAggregate());
        assertEquals(List.of("tags", "category", "count"), output.getRowType().getFieldNames());
    }  
            "LIST",  
        // Second arg should contain delegated_predicate with literal 7  
        RexNode placeholder = DelegatedPredicateFunction.makeCall(rexBuilder, 42);
        assertTrue("Agg input must be the inner ReadRel", aggInput.hasRead());
    public void testApproxCountDistinctRenamed() throws Exception {
    }  
        logger.info("Substrait plan (complex boolean tree):\n{}", plan);  
            true,  
        List<String> rootNames = plan.getRelations(0).getRoot().getNamesList();
            "values"
     */
        // Sort over the aggregate: schema-preserving wrapper.  
    // ── Helpers ────────────────────────────────────────────────────────────────
        );
        assertEquals(
        RelNode scan = buildTableScan("test_index", "A", "B", "C");
            ImmutableBitSet.ORDERING.immutableSortedCopy(List.of(ImmutableBitSet.of(2), ImmutableBitSet.of(1), ImmutableBitSet.of(1, 2))),
        assertEquals(List.of("test_index"), inner.getRead().getNamedTable().getNamesList());
        );
        assertEquals(List.of("tags", "values"), output.getRowType().getFieldNames());  
        LogicalAggregate agg = LogicalAggregate.create(aggLeaf, List.of(), ImmutableBitSet.of(), null, List.of(listCall));
        RexNode nativePred = rexBuilder.makeCall(
        assertTrue("varchar column -> Str schema", read.getBaseSchema().getStruct().getTypes(0).hasString());
        assertEquals(0, payload.getInt());  
        Plan plan = decodeSubstrait(combined);
        AggregateCall count = AggregateCall.create(  
    public void testConvertShardScanFragment_FilterOverScan() throws Exception {
        );  
                .getDirectReference()
    }  
        Rel aggInput = underSort.getAggregate().getInput();  
    }  
        Rel root = rootRel(plan);
            ImmutableBitSet.of(),
import org.apache.calcite.sql.type.SqlTypeTransforms;
        assertEquals("input-1", input.getRead().getNamedTable().getNames(0));  
            true,
        assertTrue(partialRoot.getProject().getInput().getAggregate().getInput().hasExtensionSingle());  
        Rel inner = agg.getInput();
        Rel root = rootRel(decodeSubstrait(newConvertor().convertFragment(correlate)));
        byte[] innerBytes = convertor.convertFragment(scan);  
    /** Builds a nullable row type with integer columns named "A", "B", ... */
        Plan plan = decodeSubstrait(bytes);
     * Mirror of multisearch's coordinator-stage shape:
        RelDataType partialRowType = typeFactory.builder()  
                .getField()
     */  
                .getGroupings(0)
    /**
        DataFusionFragmentConvertor convertor = newConvertor();
        RelDataType inputRowType = rowType("a");
            "count"  
        Rel inner = filterRel.getInput();  
            List.of(),  
        // plan with 3-column rowType is enough to surface the wrapper-vs-inner names mismatch.  
     * multisearch coordinator-stage shape {@code Aggregate(Union(StageInputScan,  
        assertEquals("implicit GROUP BY expansion appends a scalar field", 1, payload.getInt());  
            typeFactory.createSqlType(SqlTypeName.BIGINT),
        // Wrapper: a Project that maps the single inner column to two new aliases — this is
     */
            java.util.Set.of()
        );  
        RelNode limited = LogicalSort.create(uncollect, RelCollations.EMPTY, null, fetch);
            SqlStdOperatorTable.COUNT,
    }
        RelNode stageInput = new OpenSearchStageInputScan(cluster, cluster.traitSet(), 1, partialRowType, List.of("datafusion"), List.of());
        assertTrue("LIST GROUP BY must use an ExtensionSingleRel", expanded.hasExtensionSingle());
        RelNode scan = buildListTableScan("test_index");
            "count"
        assertEquals(
     * with the outer's RexInputRefs pointing into the lower's appended window column, used  
        }
            rexBuilder.makeInputRef(scan, 0),
    /**
            false,  
    private AggregateCall buildListAggregateCall(RelNode input, int groupCount) {
import org.apache.calcite.rel.RelNode;
    }  
        byte[] innerBytes = newConvertor().convertFragment(partial);
     * inner plan (e.g. Union of two stage-input scans) must populate
            OperandTypes.ANY,
            List.of("datafusion"),  
        assertEquals(1, payload.getInt());  
            placeholderInput,  
            false,  
            SqlKind.OTHER_FUNCTION,  
            cluster,  
            List.of("sum_col"),  
            false,
        assertTrue("condition must be a scalar function", filterRel.getCondition().hasScalarFunction());  
            .build();  
                + "analytics-engine plan must not surface stale inner-plan names.",
            0,  
        Rel underFetch = root.getFetch().getInput();
            AggregationPhase.AGGREGATION_PHASE_INITIAL_TO_INTERMEDIATE,
        Rel inner = root.getAggregate().getInput();
            false,  
     *
        int childStageId = 3;
import org.apache.calcite.rel.logical.LogicalAggregate;
        assertEquals(0, ((org.apache.calcite.rex.RexInputRef) output.getProjects().get(1)).getIndex());  
        ReadRel read = root.getRead();  
        RelNode filter = LogicalFilter.create(scan, andCondition);
        RelNode sin2 = new OpenSearchStageInputScan(cluster, cluster.traitSet(), 2, branchRowType, List.of("datafusion"), List.of());
                (RexLiteral) rexBuilder.makeLiteral(25, intType, false)
        List<String> rootNames = plan.getRelations(0).getRoot().getNamesList();  
            .build();  
            arrayType,
     * FINAL aggregate must not expand again and its Read must declare the key as a string —
        byte[] combined = convertor.attachPartialAggOnTop(partialAgg, innerBytes);  
            .add("tags", list)
    /**  
        assertEquals(10, gtArg.getScalarFunction().getArguments(1).getValue().getLiteral().getI32());
            ImmutableList.of(
        byte[] combined = convertor.attachFragmentOnTop(sort, innerBytes);  
        assertTrue("second AND arg must be a scalar function", delegatedArg.hasScalarFunction());
        // during rewire (replaced with the inner plan's root).
            wideStageRowType,  
        Rel root = rootRel(plan);
        byte[] combined = convertor.attachPartialAggOnTop(partialAgg, innerBytes);
        assertAggregateImplKeys("min", "min:str", "min:bool");
        ) {
                .stream()  
        Plan plan = decodeSubstrait(newConvertor().convertFragment(aggregate));
            ImmutableBitSet.of(0),
        );
            "PARTIAL GROUP BY key must still reference the appended expanded column",
        assertTrue("root must be an AggregateRel", root.hasAggregate());
import org.apache.calcite.rel.core.AggregateCall;
        assertEquals("AND must have 2 arguments", 2, andFunc.getArgumentsCount());
        LogicalProject output = (LogicalProject) MultiValueRelRewriter.rewrite(aggregate);  
 */
            List.of()  
        );
        // mirrors the swap performed by DataFusionPlugin#loadSubstraitExtensions.  
        return Plan.parseFrom(bytes);
            "approx_col"  
    /**
        // FINAL half: SUM(count) grouped by the expanded (now scalar VARCHAR) tags column.
        RelNode scan = buildTableScan("test_index", "A");
            stageInput,
            null,
     * {@code approx_count_distinct} name.
     * Substrait conversion.  
        // The inner's Plan.Root.names then carries the agg-output (1 col, "sum_col"), but the
    /**
        LogicalUnion union = LogicalUnion.create(List.of(sin1, sin2, sin3), true);  
            List.of(0),
        RelNode sin2 = new OpenSearchStageInputScan(cluster, cluster.traitSet(), 2, branchRowType, List.of("datafusion"), List.of());
        AggregateRel agg = root.getAggregate();  
    }  
     * (PPL list/values is {@code ARRAY<VARCHAR>}) must ride the substrait measure arg, not a lifted
    public void testAttachPartialAggOnTop_PlanRootNamesMatchWrapperOutput() throws Exception {
     * This was the residual failure signature ("2 uses for 6 names") that the
        ) {
        assertListAggregateUses("test_index", "mv_collect");
        RexNode delegated1 = DelegatedPredicateFunction.makeCall(rexBuilder, 1);  
        assertTrue("Aggregate input must be a ReadRel", inner.hasRead());  
        // aggregate over the same input row type to keep the standalone conversion simple.  
        LogicalAggregate finalAgg = LogicalAggregate.create(
     * pre-expansion ARRAY key, but the PARTIAL fragment already emits the scalar element, so the
                .anyMatch(expectedFunction::equals)
/**
        // Inner: final-agg over stage-input.  
        ClassLoader prev = t.getContextClassLoader();
            List.of()  
            values,  
            ImmutableBitSet.ORDERING.immutableSortedCopy(List.of(ImmutableBitSet.of(0), ImmutableBitSet.of(1), ImmutableBitSet.of(0, 1))),
        assertEquals("two rows", 2, read.getVirtualTable().getExpressionsCount());  
            "Plan.Root.names must reflect the Sort wrapper's output (1 column from the inner agg), "
        RexNode notDelegated2 = rexBuilder.makeCall(SqlStdOperatorTable.NOT, delegated2);
        byte[] bytes = newConvertor().convertFragment(finalAgg);
            0,
        LogicalSort sortLimit = LogicalSort.create(placeholderInput, RelCollations.of(0), null, fetchN);
        byte[] bytes = newConvertor().convertFragment(agg);  
        org.apache.calcite.rel.core.Aggregate grouped = (org.apache.calcite.rel.core.Aggregate) output.getInput();  
            if (decl.hasExtensionFunction()) {  
        Rel expanded = aggregateRel.getAggregate().getInput();  
    /**
            Optionality.FORBIDDEN
import io.substrait.proto.Expression;
            cluster.traitSet(),  
     * {@code sort | head N} returned the first N rows in arrival order instead of sorted order.
    private RelNode buildTableScan(String tableName, String... columns) {
import org.opensearch.analytics.spi.DelegatedPredicateFunction;
        assertEquals(0, payload.getInt());
    private void assertListAggregateUses(String tableName, String expectedFunction) throws Exception {
import org.apache.calcite.plan.hep.HepProgramBuilder;
        Plan plan = decodeSubstrait(bytes);  
                assertNotEquals("approx_distinct should not appear for SUM-only plan", "approx_distinct", baseName);
        return new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), tableName, rowType(columns));
    /**
            java.util.Set.of()  
        LogicalAggregate aggregate = LogicalAggregate.create(
            .add("tags", list)
        Rel partialRoot = rootRel(decodeSubstrait(newConvertor().convertFragment(partialOverStageInput)));
        LogicalAggregate finalAgg = LogicalAggregate.create(stageInput, List.of(), ImmutableBitSet.of(0), null, List.of(sumCounts));
        assertEquals("explicit mvexpand appends its element for the frontend projection", 1, payload.getInt());
        assertEquals("aggregate argument must remain on the source LIST", List.of(0), grouped.getAggCallList().get(0).getArgList());
            stageInput,
     *       Aggregate(...)
        Plan plan = decodeSubstrait(bytes);
        byte[] innerBytes = convertor.convertFragment(scan);
        RelNode project = LogicalProject.create(
     * char column and every row cell are Str while the integer column stays i32. This is the generic
        }
        assertTrue("root must be a ReadRel", root.hasRead());
        Plan plan = decodeSubstrait(combined);
        );
        RelNode correlate = LogicalCorrelate.create(left, limited, correlationId, ImmutableBitSet.of(0), JoinRelType.INNER);  
    }  
        RelNode sin1 = new OpenSearchStageInputScan(cluster, cluster.traitSet(), 1, branchRowType, List.of("datafusion"), List.of());
        );  
    }
            .stream()
            List.of("datafusion"),
            .build();  
    private LogicalAggregate buildSumAggregate(RelNode input, int columnIndex) {
    private RelDataTypeFactory typeFactory;
        typeFactory = new JavaTypeFactoryImpl();
     * <p>The earlier rewire replaced the Fetch's input directly, dropping the Sort and yielding  
    /**
        );
            0,  
        Expression arg = root.getAggregate().getMeasures(0).getMeasure().getArguments(0).getValue();
        byte[] innerBytes = convertor.convertFragment(finalAgg);
        assertListAggregateUses("input-7", "list_merge");
        int childStageId = 3;  
        RexNode andCondition = rexBuilder.makeCall(SqlStdOperatorTable.AND, nativePred, delegated);
        assertTrue("must find approx_distinct in extension declarations", foundApproxDistinct);  
        RelDataType partialRowType = typeFactory.builder()  
            SimpleExtension.ExtensionCollection delegationExtensions = SimpleExtension.load(List.of("/delegation_functions.yaml"));
/*  
     * the supplied tableName (no catalog prefix).  
        // Build a bare partial-agg fragment whose input matches the inner's rowType.
     * Multi-shard LIST GROUP BY: the coordinator decodes the shard-stage bytes (which carry the  
        RelDataType nullableInt = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true);  
        SortRel sortRel = root.getSort();
            false,
import org.apache.calcite.plan.hep.HepPlanner;
            List.of(0),  
        RelNode innerStageScan = new OpenSearchStageInputScan(
        AggregateCall sumCounts = AggregateCall.create(
            null,
            List.of("picked"),  
    /**
    /**
import org.apache.calcite.rel.core.Uncollect;
        cluster = RelOptCluster.create(planner, rexBuilder);
            "count"
        java.nio.ByteBuffer payload = root.getExtensionSingle().getDetail().getValue().asReadOnlyByteBuffer();
    }  
    public void testMultisearchShape_SortOverAggregateOverThreeWayUnion_PlanRootNamesMatchTopOutput() throws Exception {
        // *wrapper* we attach above has its own output rowType.  
        assertTrue(partialRoot.hasProject());
            inputRowType,  
        LogicalSort sort = LogicalSort.create(placeholderInput, RelCollations.of(0), null, null);
        assertEquals("implicit GROUP BY expansion de-duplicates within each document", 1, payload.getInt());
        Plan plan = decodeSubstrait(combined);
        // Aggregate over the union: SUM(a) → 1 column output ("sum_col").  
            List.of("tags"),  
        RexNode andCondition = rexBuilder.makeCall(SqlStdOperatorTable.AND, nativePred, orClause);
import io.substrait.proto.PlanRel;
        byte[] bytes = newConvertor().convertFragment(filter);
            arg.getCast().getInput().getSelection().getDirectReference().getStructField().getField()
    }
     * Regression: {@code attachPartialAggOnTop} must populate {@code Plan.Root.names}  
        Plan plan = decodeSubstrait(combined);
            List.of("a", "rn"),
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());  
    public void testAttachPartialAggOnTop_WrapsInner() throws Exception {  
            null,
        // Plan.Root.names regardless of what the wide-row stage-input scan above looked like.
            List.of()  
            rootNames
        RelNode stageInput = new OpenSearchStageInputScan(  
        // Inner fragment: Project that outputs a single INTEGER column (the gathered reduce input).
        Rel root = rootRel(plan);  
import io.substrait.proto.ReadRel;  
        );  
        assertTrue("stage-input key must be declared with the element type: " + keyType, keyType.hasString());
     * Project — else the reduce-stage stitch ({@code replaceInput}) drops it and the arg dangles past
        assertEquals(List.of("input-" + childStageId), aggInput.getRead().getNamedTable().getNamesList());
     * adds str and bool overloads so PPL `stats min/max` over varchar / boolean fields binds.
                .getSelection()
        DataFusionFragmentConvertor convertor = newConvertor();
            false,
        byte[] innerBytes = convertor.convertFragment(innerStageScan);
            -1,
        );
        }
            SqlStdOperatorTable.APPROX_COUNT_DISTINCT,
    /**
        AggregateCall sumCall = AggregateCall.create(  
     * end-to-end IT surfaced even after the initial rewire fix.
     * Regression: a lifted-window Project wrapper, shaped {@code Project_outer(Project_lower(input))}
        RexNode fetch = rexBuilder.makeLiteral(2, typeFactory.createSqlType(SqlTypeName.INTEGER), true);
            List.of()  
            List.of(sumCounts)  
        Rel expanded = partialAgg.getAggregate().getInput();
        AggregateFunction fn = agg.getMeasures(0).getMeasure();  
            SqlStdOperatorTable.GREATER_THAN,
            partialAgg.getAggregate()
        );
        byte[] aggBytes = convertor.attachFragmentOnTop(aggregate, unionBytes);  
        byte[] innerBytes = convertor.convertFragment(innerProject);  
    // ── Tests ──────────────────────────────────────────────────────────────────
     * {@code AggregateRel(readRel)} with phase INITIAL_TO_INTERMEDIATE.
            cluster.traitSet(),
        // The wrapper's output rowType has 1 column ("sum_col") which must end up in
            .add("count", typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true))
 * The OpenSearch Contributors require contributions made to  
            List.of(rexBuilder.makeInputRef(lowerProject, 0), rexBuilder.makeInputRef(lowerProject, 1)),
        byte[] innerBytes = convertor.convertFragment(innerFinalAgg);
        ReadRel read = rootRel(decodeSubstrait(newConvertor().convertFragment(values))).getRead();
    public void testListOverFinalStateRoutesToListMerge() throws Exception {
        Rel inner = agg.getInput();  
        }
        Expression dp1 = orFunc.getArguments(0).getValue();
    // VirtualTable inline Values CHAR to Str normalization
        assertNull(grouped.getInput().getRowType().getFieldList().get(1).getType().getComponentType());  
        assertTrue("convertor bytes must not be empty", bytes.length > 0);
     * schema, but found {wrapper-width} uses for {inner-width} names" whenever
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
     * "Field reference offset (N) must be less than number of fields in struct (0)". The decoder
        // Isthmus defaults final-mode aggregates to INITIAL_TO_RESULT.
        RelNode scan = new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), "test_index", inputType);
        DataFusionFragmentConvertor convertor = newConvertor();
    /**
            typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true),
        // For this regression, the inner doesn't need to be a final-agg — a bare scan-shaped
        assertTrue("output projection restores the original group field name", root.hasProject());  
        SqlAggFunction listOp = new SqlAggFunction(
        Plan plan = decodeSubstrait(bytes);  
        // Without the FINAL hint the same shape is a PARTIAL over a worker stage input and must still expand.
        assertTrue(grouped.getInput() instanceof MultiValueExpandRel);
            cluster,
        LogicalUnion union = LogicalUnion.create(List.of(sin1, sin2, sin3), true);
            SqlStdOperatorTable.COUNT,  
import org.apache.calcite.rex.RexBuilder;
                .merge(aggregateExtensions)  
        Expression.ScalarFunction scalarFunc = filterRel.getCondition().getScalarFunction();
        assertTrue("FINAL aggregate must read the stage input directly, not a second expand", input.hasRead());  
            -1,
        assertTrue("OR first arg must be scalar function", dp1.hasScalarFunction());
        );
        assertTrue("root must be a ProjectRel (outer lift)", root.hasProject());
            List.of("sum_col"),  
        // with the same output row type as the inner agg. The placeholder is discarded
            .add("count", typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true))
            List.of()
            List.of("a", "rn"),  
        assertTrue("expand extension must survive decode + re-encode", expanded.hasExtensionSingle());  
        );
     */
            .add("category", typeFactory.createSqlType(SqlTypeName.VARCHAR))
            List.of("sum_col"),  
            List.of(),
        Expression orArg = andFunc.getArguments(1).getValue();
            List.of(),
        assertEquals(1, dp1.getScalarFunction().getArguments(0).getValue().getLiteral().getI32());  
     */
        RelNode stageInput = new OpenSearchStageInputScan(
            false  
            List.of(0),
        RelNode stageInput = new OpenSearchStageInputScan(  
            ImmutableBitSet.of(0, 1),
            List.of("datafusion"),
        AggregateCall count = AggregateCall.create(
        assertTrue("lower's input must be the rewired stage-scan", innerOfLower.hasRead());
        // Inner: final-agg over stage-input (same shape as testAttachFragmentOnTop_Sort).
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        byte[] innerBytes = convertor.convertFragment(finalAgg);  
                assertNotEquals("approx_count_distinct must be renamed", "approx_count_distinct", baseName);  
        LogicalAggregate agg = buildSumAggregate(scan, 0);
    }  
                .merge(scalarExtensions);
        AggregateCall approxCall = AggregateCall.create(  
        LogicalAggregate partialAgg = buildSumAggregate(scan, 0);
        RelDataType stageRowType = rowType("A");
            cluster,
            SqlKind.OTHER_FUNCTION,
        RelNode scan = buildTableScan("test_index", "A", "B");  
     * {@code Plan.Root.names} with the aggregate's output names. Mirrors the
        LogicalAggregate partialOverStageInput = LogicalAggregate.create(  
    }
    /**
import org.apache.calcite.util.ImmutableBitSet;  
        LogicalAggregate finalAgg = buildSumAggregate(stageInput, 0);
        io.substrait.proto.Type keyType = input.getRead().getBaseSchema().getStruct().getTypes(0);
        logger.info("Substrait condition (single delegated):\n{}", filterRel.getCondition());
    }  
    public void testVirtualTable_VarcharValues_ConvertsToStrGenerically() throws Exception {
        );
                RexLiteral.fromJdbcString(varchar, SqlTypeName.CHAR, "Bob"),  
            childStageId,  
            inner.getRead().getNamedTable().getNamesList()
     *   Sort(fetch=N, collation=∅)          // system limit, lowered to a Substrait Fetch  
            innerStage,  
        // Substrait Fetch rel (the convertor handles this in replaceInput).
        DataFusionFragmentConvertor convertor = newConvertor();  
            List.of("input-" + childStageId),  
        LogicalSort userSort = LogicalSort.create(aggregate, RelCollations.of(0), null, null);  
    private RelDataType rowType(String... columns) {
                .filter(SimpleExtensionDeclaration::hasExtensionFunction)
     * (PPL {@code sort x | head N}, which Calcite merges into one node) lowers via isthmus to
        assertEquals(
        RelDataType branchRowType = rowType("a", "b", "c", "d", "e", "f");  
            SqlFunctionCategory.USER_DEFINED_FUNCTION,
            typeFactory.createSqlType(SqlTypeName.BIGINT),
     */  
    /**  
        DataFusionFragmentConvertor convertor = newConvertor();  
            assertTrue(name + " yaml must declare impl with key " + key + " (got " + actual + ")", actual.contains(key));  
        Plan plan = decodeSubstrait(bytes);
     * APPROX_COUNT_DISTINCT aggregate emits as {@code approx_distinct} in the
                (RexLiteral) rexBuilder.makeLiteral(30, intType, false)  
        java.util.Set<String> actual = extensions.aggregateFunctions()  
        RelDataType element = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
     * Using the inner's names causes DataFusion's substrait consumer to fail
            org.apache.calcite.rel.RelCollations.EMPTY,
 * compatible open source license.
        byte[] combinedBytes = convertor.attachFragmentOnTop(systemLimit, userSortBytes);
    // ── Extension function rename tests ────────────────────────────────────────
        );
     * with the placeholder preserved as a scalar function call in the FilterRel condition.
        );
        Rel innerOfLower = innerOfOuter.getProject().getInput();
            rowType("c0", "c1", "c2", "c3", "c4"),
        RelNode innerStageScan = new OpenSearchStageInputScan(
            groupCount,
    /**
            java.util.Set.of(correlationId)
        Plan plan = decodeSubstrait(bytes);  
     * {@link DataFusionFragmentConvertor.StageInputTableScan} — a minimal TableScan  
        Plan plan = decodeSubstrait(combinedBytes);  
        RelNode sin3 = new OpenSearchStageInputScan(cluster, cluster.traitSet(), 3, branchRowType, List.of("datafusion"), List.of());  
        assertTrue("root must be a FetchRel (the limit)", root.hasFetch());
            -1,  
        Rel underSort = underFetch.getSort().getInput();
        RexNode correlatedTags = rexBuilder.makeFieldAccess(rexBuilder.makeCorrel(left.getRowType(), correlationId), 0);  
            SqlFunctionCategory.USER_DEFINED_FUNCTION,  
import io.substrait.proto.Plan;
            cluster.traitSet(),
    }  
     */  
    /**
            stageRowType,
        );
            .filter(v -> name.equals(v.name()))
            java.util.Set.of()
        return new DataFusionFragmentConvertor.StageInputTableScan(cluster, cluster.traitSet(), tableName, type);
        Plan plan = decodeSubstrait(combined);
        RexNode fetchN = rexBuilder.makeLiteral(100, typeFactory.createSqlType(SqlTypeName.INTEGER), true);
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    /**
            extensions = DefaultExtensionCatalog.DEFAULT_COLLECTION.merge(delegationExtensions)
                String baseName = name.contains(":") ? name.substring(0, name.indexOf(':')) : name;
            null,
     * aggregate's 1-column output), not the inner Union's wider row type.  
        RelNode scan = buildListTableScan("test_index");  
            false,
        DataFusionFragmentConvertor convertor = newConvertor();
        assertTrue("root must be the FINAL aggregate", root.hasAggregate());  
    public void testAttachFragmentOnTop_Sort() throws Exception {  
            -1,  
        Expression.ScalarFunction andFunc = filterRel.getCondition().getScalarFunction();
 * the returned Substrait proto bytes are decoded back into proto structures,
                String name = decl.getExtensionFunction().getName();
            null,
        // Inner bytes from a shard-scan conversion.  
            SqlStdOperatorTable.GREATER_THAN,
        // Inner: Union(Sin, Sin, Sin) — three branches, each 6 columns wide.
        // OR arg[1]: NOT(delegated_predicate(2))
        FilterRel filterRel = root.getFilter();
        LogicalValues values = (LogicalValues) LogicalValues.create(cluster, rowType, tuples);
            null,
            false,
        RelNode stageInput = new OpenSearchStageInputScan(  
