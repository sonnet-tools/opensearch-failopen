        LogicalProject wide = allColumnsProject(scan);
     *  trimmed to only the columns its side contributes. */
            false  
        }
import org.apache.calcite.rel.core.JoinRelType;
    private static LogicalProject bottomMostProject(RelNode root) {
     * Alias-only top Project (1:1 refs, renamed) over an Aggregate — the shape PPL {@code transpose}  
            false
            ImmutableList.of(),
    }
    // ── helpers ──────────────────────────────────────────────────────────
            false,  
            false,
    private void assertBottomProjectColsAnyOrder(RelNode trimmed, String... expected) {
        RelNode union = LogicalUnion.create(List.of(arm0, arm1), /* all */ true);
        // Aggregate exposes [f0, c]; the alias-only Project renames them to the query's output names.  
        TableScan scan = stubScan(mockTable("t", COLS));
            wide,  
    }
 * <p>RelFieldTrimmer expresses narrowing as a {@link LogicalProject} above the (full-width) scan —
        for (LogicalProject p : projects) {
            "c"  
        LogicalProject outer = LogicalProject.create(filter, List.of(), List.of(ref(filter, 2)), List.of("f2")); // needs f2  
import org.apache.calcite.rel.logical.LogicalProject;  
        LogicalAggregate agg = LogicalAggregate.create(filter, List.of(), ImmutableBitSet.of(0), null, List.of(count)); // groups f0  
import org.apache.calcite.util.ImmutableBitSet;
            windowed,
    public void testNoTrim_allColumnsNeeded() {  
        // The output schema the executor sees must keep the renamed names, not the trimmer's underlying ones.
        RelNode trimmed = PlannerImpl.trimFields(outer);
            List.of("column", "total"),
            typeFactory.createSqlType(SqlTypeName.BIGINT),  
                    p.getRowType().getFieldNames()  
            "Window Project must sit directly on the scan (intermediate wide Project trimmed away):\n" + RelOptUtil.toString(trimmed),  
            if (RelNodeUtils.unwrapHep(p.getInput()) instanceof TableScan) {
        RelNode trimmed = PlannerImpl.trimFields(outer);
    }  
            new java.util.TreeSet<>(List.of(expected)),  
            false,
        LogicalProject wide = allColumnsProject(scan);
            "Join arms must be trimmed to only contributed cols:\n" + RelOptUtil.toString(trimmed),
            new TreeSet<>(List.of("f0", "f2")),
import org.apache.calcite.rel.logical.LogicalSort;
        RexNode cond = rexBuilder.makeCall(
            filter,
        LogicalProject arm0 = allColumnsProject(stubScan(mockTable("t", COLS)));  
            List.of(),  
        AggregateCall sumF3 = AggregateCall.create(
    private void assertBottomProjectCols(RelNode trimmed, String... expectedInOrder) {  
package org.opensearch.analytics.planner;
    public void testTrims_wideProjectUnderFilter() {
            "trimFields must preserve the original output column names:\n" + RelOptUtil.toString(trimmed),
        LogicalProject outer = LogicalProject.create(sort, List.of(), List.of(ref(sort, 2)), List.of("f2")); // output f2
        );  
        );
        RelNode filter = makeFilter(wide, makeEquals(0, SqlTypeName.INTEGER, 5)); // needs f0
        // outer Project keeps only f2 → only f2 is needed below.  
    /** Wide Project under a Sort(f1) + narrow output(f2): trimmer keeps only {f1, f2}. */
/*  
            "c"
import com.google.common.collect.ImmutableList;
 * by contrast, leaves WIDE intermediate projections (e.g. {@code fields c} over a full scan) which the  
    /** Aggregate(COUNT) GROUP BY f0 over Filter(f1) over wide Project: keeps {f0, f1}. */
import org.apache.calcite.rel.RelNode;
     * else the executor can't find the expected columns in the result batch (Q82 HTTP 500 regression).
import org.apache.calcite.rex.RexWindowBounds;
    }
        assertEquals(  
     * {@code trimFields} must re-impose the original output names (mirrors Calcite RelRoot.project),  
        AggregateCall count = AggregateCall.create(
/**
        RelNode trimmed = PlannerImpl.trimFields(outer);
        // every arm Project (directly above a scan) must be narrowed to {f2}.  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            -1,
        List<LogicalProject> projects = RelNodeUtils.findAllNodes(trimmed, LogicalProject.class);
        LogicalProject wide = allColumnsProject(scan);
            List.of(),  
        assertNotNull("Expected a Project in:\n" + RelOptUtil.toString(trimmed), bottom);  
            bottom.getRowType().getFieldNames()  
            RelCollations.of(new RelFieldCollation(1)), // sort on f1
import java.util.TreeSet;
 * The OpenSearch Contributors require contributions made to  
        );  
        assertBottomProjectColsAnyOrder(trimmed, "f0", "f2");
        LogicalProject outer = LogicalProject.create(sort, List.of(), List.of(ref(sort, 2)), List.of("f2"));
        assertBottomProjectColsAnyOrder(trimmed, "f0", "f1");  
        // Fallback: returns the exact same instance (untrimmed), never throws.
            false,
            List.of(),
    /** DEAD window: Aggregate(COUNT by f0) over a windowed Project whose window col w is never read  
                    "Union arm must be trimmed to {f2}:\n" + RelOptUtil.toString(trimmed),
        );
            false,
        );  
            RexWindowBounds.UNBOUNDED_FOLLOWING,
        );
        assertBottomProjectColsAnyOrder(trimmed, "f1", "f2");
            allArmCols  
    public void testTrims_wideProjectUnderNarrowProject() {
            wide,
 *  
        // consumer keeps only the window output w ($1).
            RelCollations.of(new RelFieldCollation(1)),
    }
    public void testTrims_windowOverWideProject() {
        );
        assertTrue(
            trimmed.getRowType().getFieldNames()  
     *  AggregateOverWindowInProject case seen while fixing the WindowPlanShape suite. */
        LogicalProject rename = LogicalProject.create(agg, List.of(), List.of(ref(agg, 0), ref(agg, 1)), List.of("column", "total"));
            SqlStdOperatorTable.SUM,
import java.util.Set;
    }
        RelNode sort = LogicalSort.create(
}  
        RelNode trimmed = PlannerImpl.trimFields(agg);
        RexNode over = rexBuilder.makeOver(
    }  
    public void testTrims_aliasOnlyTopProject_preservesOutputNames() {  
        );  
        TableScan scan = stubScan(mockTable("t", COLS));  
        RelNode sort = LogicalSort.create(
        AggregateCall count = AggregateCall.create(  
 * plan never gives the trimmer unused columns to remove — trimming is a no-op there. The PPL frontend,
            "Bottom Project must carry exactly these cols:\n" + RelOptUtil.toString(trimmed),
 * deliberately-wide intermediate {@link LogicalProject} (all table columns) under a narrow consumer,
 * trimmer must shrink. To exercise that behaviour deterministically we hand-build trees with a
        LogicalProject wide = allColumnsProject(scan);
        assertEquals(
        // COUNT() GROUP BY f0 — references only f0 ($0), never the window col w ($1).
            typeFactory.createSqlType(SqlTypeName.BIGINT),  
    private RexNode ref(RelNode input, int index) {
        assertFalse("Dead window SUM(...) OVER () must be trimmed away:\n" + planText, planText.contains("OVER ("));
        assertNotNull("Expected a Project in:\n" + RelOptUtil.toString(trimmed), bottom);
        assertNotNull("Expected a Project in:\n" + RelOptUtil.toString(trimmed), bottom);  
            ImmutableList.of(),
 * Unit tests for {@link PlannerImpl#trimFields} (Calcite {@link org.apache.calcite.sql2rel.RelFieldTrimmer}).
            List.of(ref(wide, 3)), // SUM over f3
    }  
    /** Wide Project under a Filter(f0) + narrow output(f2): trimmer keeps only {f0, f2}. */
        // f0 (filter) + f2 (output) survive; f1/f3/f4 trimmed away.  
        for (LogicalProject p : RelNodeUtils.findAllNodes(trimmed, LogicalProject.class)) {
        TableScan scan = stubScan(mockTable("t", COLS));  
    }
        TableScan right = stubScan(mockTable("r", COLS));
import org.apache.calcite.rel.logical.LogicalUnion;
        LogicalProject wide = allColumnsProject(scan);
    }  
            false,
        TableScan scan = stubScan(mockTable("t", COLS));
        // the scan's f3 ($3) directly — the intermediate all-columns Project is eliminated.
        String planText = RelOptUtil.toString(trimmed);  
            new java.util.TreeSet<>(bottom.getRowType().getFieldNames())
        TableScan left = stubScan(mockTable("l", COLS));  
            RexWindowBounds.UNBOUNDED_FOLLOWING,  
                allArmCols.addAll(p.getRowType().getFieldNames());  
        LogicalAggregate agg = LogicalAggregate.create(wide, List.of(), ImmutableBitSet.of(0), null, List.of(count));
        List<RexNode> allRefs = List.of(ref(wide, 0), ref(wide, 1), ref(wide, 2), ref(wide, 3), ref(wide, 4));
        LogicalProject bottom = bottomMostProject(trimmed);
        assertBottomProjectColsAnyOrder(trimmed, "f0");
            RexWindowBounds.UNBOUNDED_PRECEDING,
     *  → trimmer drops the dead window entirely (the SUM(...) OVER() disappears). Mirrors the
public class RelFieldTrimmerTests extends BasePlannerRulesTests {  
        RelNode trimmed = PlannerImpl.trimFields(rename);
            "Window must reference f3 ($3) off the scan:\n" + RelOptUtil.toString(trimmed),
        RelNode trimmed = PlannerImpl.trimFields(outer);
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 5)
            false,  
            SqlStdOperatorTable.SUM,
        TableScan scan = stubScan(mockTable("t", COLS));  
            SqlStdOperatorTable.COUNT,
    public void testTrims_aggregateOverWideProject() {
            typeFactory.createSqlType(SqlTypeName.BIGINT),
     */
        assertSame("trimFields must fall back to the untrimmed input on RelFieldTrimmer failure", outer, trimmed);  
 * run {@code trimFields}, and assert the wide Project was shrunk to only the needed columns.  
        );
            true,
        TableScan scan = stubScan(mockTable("t", COLS));
import org.apache.calcite.sql.type.SqlTypeName;  
    /** Union of two wide arms, consumer needs only f2: both arms trimmed to {f2}. */
        // Each arm narrows: left to {f0}, right to {f0 (join key), f2 (output)}.  
        LogicalAggregate agg = LogicalAggregate.create(windowed, List.of(), ImmutableBitSet.of(0), null, List.of(count));
            true,
        assertBottomProjectColsAnyOrder(trimmed, COLS);
        LogicalProject outer = LogicalProject.create(union, List.of(), List.of(ref(union, 2)), List.of("f2"));  
        // output: left.f0 ($0), right.f2 ($7)
        );
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
        LogicalProject rightWide = allColumnsProject(right);  
            bottom.getProjects().get(0).toString().contains("$3")
        );
        RexNode nonLiteralOffset = rexBuilder.makeCall(  
            "Bottom Project must carry exactly these cols (in order):\n" + RelOptUtil.toString(trimmed),
        LogicalProject outer = LogicalProject.create(windowed, List.of(), List.of(ref(windowed, 1)), List.of("w"));  
        RelNode trimmed = PlannerImpl.trimFields(outer);  
import org.apache.calcite.rel.RelCollations;  
 */
        // join condition: left.f0 ($0) = right.f0 ($5, offset by left width 5)
 * SPDX-License-Identifier: Apache-2.0
 * it never mutates the {@link TableScan} rowType (verified against Calcite source). So we assert on  
     * leaves behind as its final RENAME over the PIVOT. RelFieldTrimmer drops such a trivial top
    }  
            SqlStdOperatorTable.PLUS,
        assertBottomProjectCols(trimmed, "f2");
            -1,
        TableScan scan = stubScan(mockTable("t", COLS));
    }
 *
        RelNode trimmed = PlannerImpl.trimFields(outer);
        assertBottomProjectColsAnyOrder(trimmed, "f0", "f3");
        RelNode trimmed = PlannerImpl.trimFields(agg);  
            "s"
                );
        TableScan scan = stubScan(mockTable("t", COLS));
    /** Wide Project (all 5 cols) under a consumer that needs only a subset → trimmer shrinks it. */
            typeFactory.createSqlType(SqlTypeName.INTEGER),
        return rexBuilder.makeInputRef(input, index);  
        LogicalProject outer = LogicalProject.create(join, List.of(), List.of(ref(join, 0), ref(join, 7)), List.of("lf0", "rf2"));  
        LogicalProject leftWide = allColumnsProject(left);
        return projects.isEmpty() ? null : projects.get(projects.size() - 1);
import org.apache.calcite.rex.RexNode;  
        );
    private static final String[] COLS = { "f0", "f1", "f2", "f3", "f4" };
     * Project, which silently renames the query's output columns (e.g. {@code column}→{@code f0}).
        );
        // bottom two projects are the trimmed arm projects.
        LogicalProject wide = allColumnsProject(scan);
            typeFactory.createSqlType(SqlTypeName.BIGINT),  
 * <p>The SQL frontend ({@code SqlToRelConverter}) already emits minimal projections, so a SQL-driven
        }  
        // windowed Project exposes [f0, w]; w is the window output.
    public void testFallback_nonLiteralOffset_returnsInputUnchanged() {  
            RelNodeUtils.unwrapHep(bottom.getInput()) instanceof TableScan
    public void testTrims_joinOverWideArms() {
        RelNode join = LogicalJoin.create(leftWide, rightWide, List.of(), cond, Set.<CorrelationId>of(), JoinRelType.INNER);
            rexBuilder.makeLiteral(2, typeFactory.createSqlType(SqlTypeName.INTEGER), true)  
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)  
            wide,  
            "c"
 * the bottom-most Project's columns.
    /**
            null,
            -1,  
        );
        // The dead window is gone: no RexOver survives anywhere, and the scan-adjacent Project keeps f0 only.
        assertTrue(  
            ImmutableList.of(),  
        LogicalProject windowed = LogicalProject.create(wide, List.of(), List.of(ref(wide, 0), over), List.of("f0", "w"));  
    public void testTrims_wideProjectUnderSort() {
            }
        TableScan scan = stubScan(mockTable("t", COLS));  
            true,
        TableScan scan = stubScan(mockTable("t", COLS));  
            }
                assertEquals(  
    /** Windowed Project (w = SUM(f3) OVER ()) over a wide Project; consumer needs only w → the wide  
    /** NEGATIVE: trimmer throws on a non-literal OFFSET → trimFields catches and returns the input. */
        LogicalAggregate agg = LogicalAggregate.create(wide, List.of(), ImmutableBitSet.of(0), null, List.of(sumF3));
        LogicalProject wide = allColumnsProject(scan);
        // The wide + windowed + outer Projects collapse into a single Project(w) whose window reads  
import org.apache.calcite.rel.logical.LogicalJoin;
    }
        Set<String> allArmCols = new TreeSet<>();  
            SqlStdOperatorTable.COUNT,  
 *
            SqlStdOperatorTable.SUM,
        List<LogicalProject> projects = RelNodeUtils.findAllNodes(root, LogicalProject.class);  
    private LogicalProject allColumnsProject(RelNode input) {  
            List.of(3),
            rexBuilder.makeLiteral(1, typeFactory.createSqlType(SqlTypeName.INTEGER), true),
        LogicalProject wide = allColumnsProject(scan);  
            wide,  
        RelNode trimmed = PlannerImpl.trimFields(outer);
import org.apache.calcite.rel.core.AggregateCall;  
    }
        );
import java.util.List;  
        LogicalProject outer = LogicalProject.create(wide, List.of(), allRefs, List.of(COLS));
import org.apache.calcite.rel.RelFieldCollation;
        LogicalProject arm1 = allColumnsProject(stubScan(mockTable("t", COLS)));
            true,  
    }
            List.of(ref(wide, 3)),  
        assertEquals(  
        RelNode trimmed = PlannerImpl.trimFields(outer);
        // outer re-projects all 5 → all needed.  
    /** NEGATIVE: outer needs every column → nothing to trim; the wide Project stays all 5. */
            -1,
 * compatible open source license.
            ImmutableList.of(),
        return LogicalProject.create(input, List.of(), refs, List.of(COLS));
        assertEquals("Window Project output:\n" + RelOptUtil.toString(trimmed), List.of("w"), bottom.getRowType().getFieldNames());
    /** Join of two wide arms, output uses left.f0 + right.f2, join on left.f0 = right.f0: each arm  
        LogicalProject outer = LogicalProject.create(wide, List.of(), List.of(ref(wide, 2)), List.of("f2"));
     *  Project is trimmed to just the window's input {f3}. */
    public void testTrims_unionOverWideArms() {
            SqlStdOperatorTable.COUNT,
    public void testTrims_deadWindowRemoved() {  
    /** Aggregate(SUM f3) GROUP BY f0 over wide Project: trimmer keeps only {f0, f3}. */  
        assertEquals(  
        RelNode filter = makeFilter(wide, makeEquals(1, SqlTypeName.INTEGER, 7)); // needs f1
import org.apache.calcite.rel.core.CorrelationId;
            if (RelNodeUtils.unwrapHep(p.getInput()) instanceof TableScan) {
 * this file be licensed under the Apache-2.0 license or a
    }
 */  
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)  
        AggregateCall count = AggregateCall.create(  
        LogicalProject windowed = LogicalProject.create(wide, List.of(), List.of(ref(wide, 0), over), List.of("f0", "w"));
import org.apache.calcite.plan.RelOptUtil;
            nonLiteralOffset,
            false,
        RelNode trimmed = PlannerImpl.trimFields(agg);
        LogicalProject wide = allColumnsProject(scan);
            List.of(expectedInOrder),
    public void testTrims_aggregateOverFilterOverWideProject() {
        // inner wide Project: passes through all 5 columns (what a frontend might leave behind).
            SqlStdOperatorTable.EQUALS,  
import org.apache.calcite.rel.logical.LogicalAggregate;
        RexNode over = rexBuilder.makeOver(  
        LogicalProject bottom = bottomMostProject(trimmed);
        );
        List<RexNode> refs = List.of(ref(input, 0), ref(input, 1), ref(input, 2), ref(input, 3), ref(input, 4));
            typeFactory.createSqlType(SqlTypeName.BIGINT),
                    List.of("f2"),
        LogicalProject bottom = bottomMostProject(trimmed);
    }
        LogicalProject wide = allColumnsProject(scan);
            RexWindowBounds.UNBOUNDED_PRECEDING,  
import org.apache.calcite.rel.core.TableScan;  
