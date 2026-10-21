            : AggregateCall.create(
import org.opensearch.analytics.planner.rel.AggregateMode;
                false,
import org.apache.calcite.plan.hep.HepProgram;
            cluster.traitSet(),
import org.apache.calcite.util.Optionality;
    // ── negative cases ──────────────────────────────────────────────────────────
import org.apache.calcite.rel.type.RelDataTypeFactory;
        RelNode result = runRule(buildAggregateOverLiteralProject("TAKE", List.of(0, 1)));
     *  literal kept only on the upper copy and the lower copy carrying just the physical column. */
            cluster,
    }
                0,
    /** Aggregate({@code aggName}(argList)) over {@code Project(field=$0, $f1=50)}. */
            cluster.traitSet(),
            ReturnTypes.ARG0_FORCE_NULLABLE,
        return new OpenSearchAggregate(
                argList,
/**
        assertFalse("lower Project must keep at least one column to push down", lowerProject.getProjects().isEmpty());
        // Already pinned → the rule's guard returns early; the child stays a single Project over the scan.
        );
    private RexLiteral literal(int value) {
                input,
            List.of(call),
import org.apache.calcite.plan.hep.HepPlanner;
        );
                SqlStdOperatorTable.SUM,
            AggregateMode.SINGLE,
    private OpenSearchAggregate aggregate(String aggName, List<Integer> argList, OpenSearchProject input) {
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
                false,
}
import java.util.List;
            "lower Project must carry only physical (non-literal) columns",
            Map.of(),
        RelNode result = runRule(buildAggregateOverLiteralProject("PERCENTILE_APPROX", List.of(0, 1)));
            null,
import org.apache.calcite.sql.type.SqlTypeName;
import java.util.Collections;
                null,
        OpenSearchProject pinned = new OpenSearchProject(
    private RelDataType rowType(List<String> names, List<SqlTypeName> types) {
    public void testAlreadyPinnedProjectNotReSplit() {
                input,
     *  (no duplicated Project-over-Project stack, nothing pinned). */
    // ── positive cases ─────────────────────────────────────────────────────────
        RexLiteral literal = literal(50);
        return planner.findBestExp();
    }
    public void testAllLiteralProjectNotSplit() {
    }
    private static SqlAggFunction udaf(String name) {
import org.apache.calcite.util.ImmutableBitSet;
 * this file be licensed under the Apache-2.0 license or a
        HepProgram program = new HepProgramBuilder().addRuleInstance(new OpenSearchAggLiteralArgProjectSplitRule()).build();
            cluster,
        ) {
    private RelNode stubMarkedScan() {
            BACKENDS
                false,
    }
            null,
                aggName
import java.util.Map;
            cluster,
import org.apache.calcite.sql.SqlFunctionCategory;
    }
            cluster,
                List.of(),
        assertNotSplit(runRule(agg));
        // SUM is not a literal-config-arg aggregate — even over a Project with a literal column,
    }
            ImmutableBitSet.of(),
        assertTrue(
            );
        return aggregate(aggName, argList, project);
        assertSplit(result);
        HepPlanner planner = new HepPlanner(program);
import org.apache.calcite.rex.RexNode;
            List.of(rexBuilder.makeInputRef(scan, 0), fifty),
    private RelNode runRule(RelNode input) {
        OpenSearchTableScan scan = (OpenSearchTableScan) stubMarkedScan();
            name,
 */
        RexLiteral fifty = literal(50);
                false,
        }
        // A percentile whose Project has NOTHING but the literal to push down: split buys nothing.
import org.opensearch.analytics.planner.BasePlannerRulesTests;
    /** Asserts the rule did NOT split: the aggregate's child is a single Project directly over the scan
        // Project(field, $f1=10) under Aggregate(take($0,$1)).
        assertTrue("child should be an OpenSearchProject", child instanceof OpenSearchProject);
        assertTrue("top should be an aggregate", result instanceof OpenSearchAggregate);
        assertNotSplit(result);
import org.apache.calcite.rel.type.RelDataType;
            BACKENDS
                0,
        OpenSearchAggregate agg = aggregate("PERCENTILE_APPROX", List.of(0), project);
            false,
            cluster,
    private OpenSearchAggregate buildAggregateOverLiteralProject(String aggName, List<Integer> argList) {
        };
                typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true),
        planner.setRoot(input);
        RelNode child = result.getInput(0);
        // Project(field, $f1=50) under Aggregate(percentile_approx($0,$1)).
        AggregateCall call = "SUM".equals(aggName)
            OperandTypes.ANY_ANY,
        assertTrue("lower should be an OpenSearchProject", lower instanceof OpenSearchProject);
    }
            List.of()
        OpenSearchProject upperProject = (OpenSearchProject) upper;
            BACKENDS,
    }
 *
            Collections.singletonList(null)
            false,
                RelCollations.EMPTY,
import org.apache.calcite.sql.type.OperandTypes;
/*
        RexLiteral fifty = literal(50);
            rowType(List.of("field", "$f1"), List.of(SqlTypeName.INTEGER, SqlTypeName.INTEGER)),
 * SPDX-License-Identifier: Apache-2.0
import org.apache.calcite.sql.type.ReturnTypes;
        for (int i = 0; i < names.size(); i++) {
package org.opensearch.analytics.planner.rules;
            Map.of(),
    // ── assertions ──────────────────────────────────────────────────────────────
                -1,
                aggName
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
    /** A minimal user-defined agg function with the given name (two ANY operands). */
    public void testNonLiteralArgAggregateNotSplit() {
            SqlKind.OTHER_FUNCTION,
    public void testTakeLiteralArgProjectIsSplit() {
            cluster.traitSet(),
                udaf(aggName),
        // Upper (pinned) copy must not re-fire the rule.
import org.opensearch.analytics.planner.rel.OpenSearchProject;
 */
            SqlFunctionCategory.USER_DEFINED_FUNCTION,
import org.apache.calcite.sql.SqlKind;
        );
    }
        return b.build();
        RelNode result = runRule(agg);
        OpenSearchTableScan scan = (OpenSearchTableScan) stubMarkedScan();
        );
import org.apache.calcite.rel.core.AggregateCall;
            scan,
            b.add(names.get(i), typeFactory.createSqlType(types.get(i)));
            BACKENDS,
 * Direct-call unit tests for {@link OpenSearchAggLiteralArgProjectSplitRule}. Builds marked
    public void testPercentileLiteralArgProjectIsSplit() {
        );
 * The OpenSearch Contributors require contributions made to
            null,
        return new SqlAggFunction(
        OpenSearchAggregate agg = aggregate("PERCENTILE_APPROX", List.of(0, 1), pinned);
            true // pinAboveExchange
        OpenSearchProject lowerProject = (OpenSearchProject) lower;
                List.of(),
            rowType(List.of("field", "$f1"), List.of(SqlTypeName.INTEGER, SqlTypeName.INTEGER)),
                argList,
    private static final List<String> BACKENDS = List.of("mock-parquet");
            List.of(fifty),
            scan,
import org.apache.calcite.plan.hep.HepProgramBuilder;
            cluster.traitSet(),
        assertFalse("child Project must not be pinned", ((OpenSearchProject) child).isPinAboveExchange());
        return new OpenSearchTableScan(
        RexNode fieldRef = rexBuilder.makeInputRef(scan, 0);
            lowerProject.getProjects().stream().noneMatch(e -> e instanceof RexLiteral)
    }
    /** Asserts the result is Aggregate -> pinned-upper Project -> unpinned-lower Project, with the
            )
import org.apache.calcite.rel.RelCollations;
                // Matches the UDAF's ReturnTypes.ARG0_FORCE_NULLABLE (arg 0 = field, INTEGER).
            List.of(fieldRef, literal),
        assertTrue("upper Project must be pinned above the exchange", upperProject.isPinAboveExchange());
    }
 * {@link HepPlanner}, asserting the literal-bearing Project is (or isn't) duplicated into a
        OpenSearchProject project = new OpenSearchProject(
        RelDataTypeFactory.Builder b = typeFactory.builder();
        );
 * {@code OpenSearchAggregate -> OpenSearchProject} trees by hand and runs the rule through a
            mockTable("test_index", new String[] { "field" }, new SqlTypeName[] { SqlTypeName.INTEGER }),
    }
            cluster.traitSet(),
                null,
    // ── builders ──────────────────────────────────────────────────────────────
    private void assertNotSplit(RelNode result) {
                false,
    }
        OpenSearchProject project = new OpenSearchProject(
        assertTrue("upper should be an OpenSearchProject", upper instanceof OpenSearchProject);
            ? AggregateCall.create(
            scan,
public class OpenSearchAggLiteralArgProjectSplitRuleTests extends BasePlannerRulesTests {
        return (RexLiteral) rexBuilder.makeLiteral(BigDecimal.valueOf(value), typeFactory.createSqlType(SqlTypeName.INTEGER), true);
        assertTrue("child Project's input must be the scan, not a duplicated Project", child.getInput(0) instanceof OpenSearchTableScan);
                -1,
import org.apache.calcite.rel.RelNode;
            BACKENDS,
        assertTrue("child's input stays the scan (not a duplicated Project)", child.getInput(0) instanceof OpenSearchTableScan);
    }
        OpenSearchTableScan scan = (OpenSearchTableScan) stubMarkedScan();
            Optionality.FORBIDDEN
                null,
        RelNode lower = upperProject.getInput();
        RelNode upper = result.getInput(0);
import org.apache.calcite.sql.SqlAggFunction;
        RelNode child = result.getInput(0);
            rowType(List.of("$f0"), List.of(SqlTypeName.INTEGER)),
        assertTrue("top should be an aggregate", result instanceof OpenSearchAggregate);
        RelNode result = runRule(buildAggregateOverLiteralProject("SUM", List.of(0)));
    private void assertSplit(RelNode result) {
        // the rule must not fire (SUM doesn't reference the literal as a config arg).
import org.apache.calcite.rex.RexLiteral;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
    /** A marked OpenSearchTableScan (single INTEGER column "field") usable as a rule leaf. */
                false,
 * pinned-above-exchange copy over an unpinned physical-only copy.
            input,
        assertFalse("lower Project must NOT be pinned", lowerProject.isPinAboveExchange());
 * compatible open source license.
                RelCollations.EMPTY,
import java.math.BigDecimal;
        assertTrue("upper Project keeps the literal column", upperProject.getProjects().stream().anyMatch(e -> e instanceof RexLiteral));
        assertSplit(result);
        assertTrue("child stays an OpenSearchProject", child instanceof OpenSearchProject);
