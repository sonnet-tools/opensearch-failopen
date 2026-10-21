                );
        LogicalProject wide = allColumnsProject(scan);
            "c"
     * Project, which silently renames the query's output columns (e.g. {@code column}→{@code f0}).
            new java.util.TreeSet<>(bottom.getRowType().getFieldNames())
        RelNode trimmed = PlannerImpl.trimFields(agg);
        RelNode trimmed = PlannerImpl.trimFields(outer);
        LogicalProject windowed = LogicalProject.create(wide, List.of(), List.of(ref(wide, 0), over), List.of("f0", "w"));
            false,
    public void testTrims_unionOverWideArms() {
            List.of(expectedInOrder),
/**
            false,
import java.util.TreeSet;
        RelNode trimmed = PlannerImpl.trimFields(outer);
        assertEquals("Window Project output:\n" + RelOptUtil.toString(trimmed), List.of("w"), bottom.getRowType().getFieldNames());
            RexWindowBounds.UNBOUNDED_PRECEDING,
        RelNode trimmed = PlannerImpl.trimFields(agg);
        LogicalProject leftWide = allColumnsProject(left);
        );
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
    public void testTrims_deadWindowRemoved() {
        );
 * run {@code trimFields}, and assert the wide Project was shrunk to only the needed columns.
            SqlStdOperatorTable.EQUALS,
                allArmCols.addAll(p.getRowType().getFieldNames());
        );
            typeFactory.createSqlType(SqlTypeName.BIGINT),
            SqlStdOperatorTable.SUM,
        LogicalAggregate agg = LogicalAggregate.create(wide, List.of(), ImmutableBitSet.of(0), null, List.of(sumF3));
        LogicalProject wide = allColumnsProject(scan);
        }
            filter,
        RexNode over = rexBuilder.makeOver(
        }
     * leaves behind as its final RENAME over the PIVOT. RelFieldTrimmer drops such a trivial top
        // The output schema the executor sees must keep the renamed names, not the trimmer's underlying ones.
        assertFalse("Dead window SUM(...) OVER () must be trimmed away:\n" + planText, planText.contains("OVER ("));
        LogicalProject bottom = bottomMostProject(trimmed);
        LogicalProject wide = allColumnsProject(scan);
    /**
        assertBottomProjectColsAnyOrder(trimmed, "f1", "f2");
        // f0 (filter) + f2 (output) survive; f1/f3/f4 trimmed away.
    public void testFallback_nonLiteralOffset_returnsInputUnchanged() {
        LogicalProject wide = allColumnsProject(scan);
 * the bottom-most Project's columns.
        TableScan right = stubScan(mockTable("r", COLS));
        TableScan scan = stubScan(mockTable("t", COLS));
    private void assertBottomProjectCols(RelNode trimmed, String... expectedInOrder) {
        LogicalProject wide = allColumnsProject(scan);
        LogicalProject arm0 = allColumnsProject(stubScan(mockTable("t", COLS)));
            new java.util.TreeSet<>(List.of(expected)),
import org.apache.calcite.rex.RexWindowBounds;
            SqlStdOperatorTable.COUNT,
            RelCollations.of(new RelFieldCollation(1)),
            "Bottom Project must carry exactly these cols:\n" + RelOptUtil.toString(trimmed),
        String planText = RelOptUtil.toString(trimmed);
        LogicalProject windowed = LogicalProject.create(wide, List.of(), List.of(ref(wide, 0), over), List.of("f0", "w"));
    }
        RelNode trimmed = PlannerImpl.trimFields(rename);
        );
        LogicalProject outer = LogicalProject.create(union, List.of(), List.of(ref(union, 2)), List.of("f2"));
            false
        // Aggregate exposes [f0, c]; the alias-only Project renames them to the query's output names.
            ImmutableList.of(),
    }
 * <p>RelFieldTrimmer expresses narrowing as a {@link LogicalProject} above the (full-width) scan —
/*
    }
            RexWindowBounds.UNBOUNDED_FOLLOWING,
            wide,
        assertEquals(
            "Bottom Project must carry exactly these cols (in order):\n" + RelOptUtil.toString(trimmed),
    private LogicalProject allColumnsProject(RelNode input) {
        TableScan scan = stubScan(mockTable("t", COLS));
    /** Aggregate(COUNT) GROUP BY f0 over Filter(f1) over wide Project: keeps {f0, f1}. */
        LogicalProject bottom = bottomMostProject(trimmed);
    /** Aggregate(SUM f3) GROUP BY f0 over wide Project: trimmer keeps only {f0, f3}. */
        // The wide + windowed + outer Projects collapse into a single Project(w) whose window reads
            wide,
            true,
        // bottom two projects are the trimmed arm projects.
            -1,
        assertBottomProjectColsAnyOrder(trimmed, "f0", "f1");
            ImmutableList.of(),
    }
     *  → trimmer drops the dead window entirely (the SUM(...) OVER() disappears). Mirrors the
            rexBuilder.makeLiteral(2, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        // outer Project keeps only f2 → only f2 is needed below.
 */
        TableScan scan = stubScan(mockTable("t", COLS));
        TableScan scan = stubScan(mockTable("t", COLS));
            rexBuilder.makeLiteral(1, typeFactory.createSqlType(SqlTypeName.INTEGER), true),
        RelNode sort = LogicalSort.create(
        RexNode cond = rexBuilder.makeCall(
     *  Project is trimmed to just the window's input {f3}. */
        );
    }
        );
            wide,
import org.apache.calcite.plan.RelOptUtil;
    public void testTrims_windowOverWideProject() {
        RelNode union = LogicalUnion.create(List.of(arm0, arm1), /* all */ true);
            if (RelNodeUtils.unwrapHep(p.getInput()) instanceof TableScan) {
            bottom.getProjects().get(0).toString().contains("$3")
        LogicalProject wide = allColumnsProject(scan);
 * <p>The SQL frontend ({@code SqlToRelConverter}) already emits minimal projections, so a SQL-driven
    public void testNoTrim_allColumnsNeeded() {
import java.util.List;
    }
        );
            typeFactory.createSqlType(SqlTypeName.BIGINT),
 *
        assertBottomProjectColsAnyOrder(trimmed, COLS);
    }
        TableScan scan = stubScan(mockTable("t", COLS));
        LogicalProject rightWide = allColumnsProject(right);
    }
        LogicalProject arm1 = allColumnsProject(stubScan(mockTable("t", COLS)));
        RelNode trimmed = PlannerImpl.trimFields(outer);
        return LogicalProject.create(input, List.of(), refs, List.of(COLS));
        // Fallback: returns the exact same instance (untrimmed), never throws.
            true,
                    p.getRowType().getFieldNames()
import org.apache.calcite.sql.type.SqlTypeName;
    private void assertBottomProjectColsAnyOrder(RelNode trimmed, String... expected) {
            SqlStdOperatorTable.SUM,
        RexNode over = rexBuilder.makeOver(
        assertBottomProjectColsAnyOrder(trimmed, "f0", "f3");
            SqlStdOperatorTable.COUNT,
        LogicalProject outer = LogicalProject.create(sort, List.of(), List.of(ref(sort, 2)), List.of("f2")); // output f2
        LogicalProject bottom = bottomMostProject(trimmed);
        LogicalProject outer = LogicalProject.create(wide, List.of(), allRefs, List.of(COLS));
        // inner wide Project: passes through all 5 columns (what a frontend might leave behind).
            new TreeSet<>(List.of("f0", "f2")),
        // COUNT() GROUP BY f0 — references only f0 ($0), never the window col w ($1).
        );
    public void testTrims_aggregateOverFilterOverWideProject() {
        TableScan scan = stubScan(mockTable("t", COLS));
    /** DEAD window: Aggregate(COUNT by f0) over a windowed Project whose window col w is never read
        // the scan's f3 ($3) directly — the intermediate all-columns Project is eliminated.
        );
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 5)
        // output: left.f0 ($0), right.f2 ($7)
            false,
        // The dead window is gone: no RexOver survives anywhere, and the scan-adjacent Project keeps f0 only.
        AggregateCall count = AggregateCall.create(
            List.of("column", "total"),
        TableScan scan = stubScan(mockTable("t", COLS));
            List.of(ref(wide, 3)),
 * plan never gives the trimmer unused columns to remove — trimming is a no-op there. The PPL frontend,
        AggregateCall count = AggregateCall.create(
    public void testTrims_joinOverWideArms() {
     * {@code trimFields} must re-impose the original output names (mirrors Calcite RelRoot.project),
    // ── helpers ──────────────────────────────────────────────────────────
            List.of(ref(wide, 3)), // SUM over f3
        assertBottomProjectCols(trimmed, "f2");
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            ImmutableList.of(),
import org.apache.calcite.rel.RelNode;
        List<LogicalProject> projects = RelNodeUtils.findAllNodes(root, LogicalProject.class);
            if (RelNodeUtils.unwrapHep(p.getInput()) instanceof TableScan) {
            SqlStdOperatorTable.COUNT,
        LogicalProject outer = LogicalProject.create(filter, List.of(), List.of(ref(filter, 2)), List.of("f2")); // needs f2
 * it never mutates the {@link TableScan} rowType (verified against Calcite source). So we assert on
            false,
        );
        TableScan scan = stubScan(mockTable("t", COLS));
            false,
        RelNode filter = makeFilter(wide, makeEquals(1, SqlTypeName.INTEGER, 7)); // needs f1
        // consumer keeps only the window output w ($1).
 * by contrast, leaves WIDE intermediate projections (e.g. {@code fields c} over a full scan) which the
        RelNode trimmed = PlannerImpl.trimFields(outer);
        RelNode trimmed = PlannerImpl.trimFields(outer);
            RelNodeUtils.unwrapHep(bottom.getInput()) instanceof TableScan
            bottom.getRowType().getFieldNames()
        assertBottomProjectColsAnyOrder(trimmed, "f0");
import org.apache.calcite.rel.logical.LogicalJoin;
        for (LogicalProject p : RelNodeUtils.findAllNodes(trimmed, LogicalProject.class)) {
     */
     *  AggregateOverWindowInProject case seen while fixing the WindowPlanShape suite. */
        RelNode filter = makeFilter(wide, makeEquals(0, SqlTypeName.INTEGER, 5)); // needs f0
        );
        return projects.isEmpty() ? null : projects.get(projects.size() - 1);
            true,
                    List.of("f2"),
        LogicalAggregate agg = LogicalAggregate.create(wide, List.of(), ImmutableBitSet.of(0), null, List.of(count));
            typeFactory.createSqlType(SqlTypeName.BIGINT),
            "c"
        LogicalProject rename = LogicalProject.create(agg, List.of(), List.of(ref(agg, 0), ref(agg, 1)), List.of("column", "total"));
        );
        List<RexNode> allRefs = List.of(ref(wide, 0), ref(wide, 1), ref(wide, 2), ref(wide, 3), ref(wide, 4));
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            SqlStdOperatorTable.PLUS,
            List.of(),
 * deliberately-wide intermediate {@link LogicalProject} (all table columns) under a narrow consumer,
            "s"
        assertEquals(
    /** Wide Project (all 5 cols) under a consumer that needs only a subset → trimmer shrinks it. */
        for (LogicalProject p : projects) {
        // windowed Project exposes [f0, w]; w is the window output.
    public void testTrims_wideProjectUnderFilter() {
                assertEquals(
        // outer re-projects all 5 → all needed.
            typeFactory.createSqlType(SqlTypeName.BIGINT),
     * Alias-only top Project (1:1 refs, renamed) over an Aggregate — the shape PPL {@code transpose}
            -1,
        assertNotNull("Expected a Project in:\n" + RelOptUtil.toString(trimmed), bottom);
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        TableScan left = stubScan(mockTable("l", COLS));
        LogicalProject outer = LogicalProject.create(windowed, List.of(), List.of(ref(windowed, 1)), List.of("w"));
    /** Join of two wide arms, output uses left.f0 + right.f2, join on left.f0 = right.f0: each arm
        RelNode sort = LogicalSort.create(
import org.apache.calcite.rel.RelCollations;
    public void testTrims_aliasOnlyTopProject_preservesOutputNames() {
        RelNode join = LogicalJoin.create(leftWide, rightWide, List.of(), cond, Set.<CorrelationId>of(), JoinRelType.INNER);
    /** Wide Project under a Sort(f1) + narrow output(f2): trimmer keeps only {f1, f2}. */
public class RelFieldTrimmerTests extends BasePlannerRulesTests {
                    "Union arm must be trimmed to {f2}:\n" + RelOptUtil.toString(trimmed),
    private static final String[] COLS = { "f0", "f1", "f2", "f3", "f4" };
            List.of(3),
    public void testTrims_wideProjectUnderSort() {
        LogicalProject outer = LogicalProject.create(sort, List.of(), List.of(ref(sort, 2)), List.of("f2"));
    /** NEGATIVE: outer needs every column → nothing to trim; the wide Project stays all 5. */
            false,
            nonLiteralOffset,
    }
            false
        return rexBuilder.makeInputRef(input, index);
import org.apache.calcite.rel.core.TableScan;
        assertEquals(
    public void testTrims_aggregateOverWideProject() {
        LogicalAggregate agg = LogicalAggregate.create(windowed, List.of(), ImmutableBitSet.of(0), null, List.of(count));
    private RexNode ref(RelNode input, int index) {
import java.util.Set;
    }
            typeFactory.createSqlType(SqlTypeName.BIGINT),
            null,
import org.apache.calcite.rel.logical.LogicalAggregate;
        assertNotNull("Expected a Project in:\n" + RelOptUtil.toString(trimmed), bottom);
        );
            true,
    }
            trimmed.getRowType().getFieldNames()
            "Join arms must be trimmed to only contributed cols:\n" + RelOptUtil.toString(trimmed),
import com.google.common.collect.ImmutableList;
        LogicalProject wide = allColumnsProject(scan);
        LogicalProject wide = allColumnsProject(scan);
        RelNode trimmed = PlannerImpl.trimFields(outer);
        List<RexNode> refs = List.of(ref(input, 0), ref(input, 1), ref(input, 2), ref(input, 3), ref(input, 4));
import org.apache.calcite.util.ImmutableBitSet;
    /** NEGATIVE: trimmer throws on a non-literal OFFSET → trimFields catches and returns the input. */
            -1,
 * SPDX-License-Identifier: Apache-2.0
        assertBottomProjectColsAnyOrder(trimmed, "f0", "f2");
import org.apache.calcite.rel.logical.LogicalProject;
 * trimmer must shrink. To exercise that behaviour deterministically we hand-build trees with a
            -1,
            "Window Project must sit directly on the scan (intermediate wide Project trimmed away):\n" + RelOptUtil.toString(trimmed),
        assertTrue(
import org.apache.calcite.rel.RelFieldCollation;
    }
        RelNode trimmed = PlannerImpl.trimFields(outer);
    private static LogicalProject bottomMostProject(RelNode root) {
            RexWindowBounds.UNBOUNDED_PRECEDING,
            "trimFields must preserve the original output column names:\n" + RelOptUtil.toString(trimmed),
import org.apache.calcite.rex.RexNode;
import org.apache.calcite.rel.logical.LogicalSort;
            false,
        );
        RelNode trimmed = PlannerImpl.trimFields(agg);
        TableScan scan = stubScan(mockTable("t", COLS));
        AggregateCall sumF3 = AggregateCall.create(
import org.apache.calcite.rel.core.AggregateCall;
            List.of(),
import org.apache.calcite.rel.logical.LogicalUnion;
        TableScan scan = stubScan(mockTable("t", COLS));
        // every arm Project (directly above a scan) must be narrowed to {f2}.
 */
            }
        LogicalProject outer = LogicalProject.create(join, List.of(), List.of(ref(join, 0), ref(join, 7)), List.of("lf0", "rf2"));
        LogicalProject wide = allColumnsProject(scan);
            }
    }
        LogicalAggregate agg = LogicalAggregate.create(filter, List.of(), ImmutableBitSet.of(0), null, List.of(count)); // groups f0
        LogicalProject outer = LogicalProject.create(wide, List.of(), List.of(ref(wide, 2)), List.of("f2"));
    }
            windowed,
            wide,
        assertSame("trimFields must fall back to the untrimmed input on RelFieldTrimmer failure", outer, trimmed);
        assertNotNull("Expected a Project in:\n" + RelOptUtil.toString(trimmed), bottom);
            RelCollations.of(new RelFieldCollation(1)), // sort on f1
     *  trimmed to only the columns its side contributes. */
            "Window must reference f3 ($3) off the scan:\n" + RelOptUtil.toString(trimmed),
            allArmCols
        );
            SqlStdOperatorTable.SUM,
        RelNode trimmed = PlannerImpl.trimFields(outer);
        // Each arm narrows: left to {f0}, right to {f0 (join key), f2 (output)}.
        Set<String> allArmCols = new TreeSet<>();
    /** Union of two wide arms, consumer needs only f2: both arms trimmed to {f2}. */
 * this file be licensed under the Apache-2.0 license or a
            ImmutableList.of(),
            List.of(),
        assertTrue(
    }
 * compatible open source license.
    /** Wide Project under a Filter(f0) + narrow output(f2): trimmer keeps only {f0, f2}. */
        RexNode nonLiteralOffset = rexBuilder.makeCall(
}
        // join condition: left.f0 ($0) = right.f0 ($5, offset by left width 5)
            "c"
    /** Windowed Project (w = SUM(f3) OVER ()) over a wide Project; consumer needs only w → the wide
        LogicalProject wide = allColumnsProject(scan);
package org.opensearch.analytics.planner;
    }
 * The OpenSearch Contributors require contributions made to
import org.apache.calcite.rel.core.JoinRelType;
     * else the executor can't find the expected columns in the result batch (Q82 HTTP 500 regression).
 *
            false,
        );
    public void testTrims_wideProjectUnderNarrowProject() {
    }
 * Unit tests for {@link PlannerImpl#trimFields} (Calcite {@link org.apache.calcite.sql2rel.RelFieldTrimmer}).
import org.apache.calcite.rel.core.CorrelationId;
        assertEquals(
 *
        AggregateCall count = AggregateCall.create(
            RexWindowBounds.UNBOUNDED_FOLLOWING,
        List<LogicalProject> projects = RelNodeUtils.findAllNodes(trimmed, LogicalProject.class);
            typeFactory.createSqlType(SqlTypeName.INTEGER),
