            scan,  
            rowType(List.of("field", "$f1"), List.of(SqlTypeName.INTEGER, SqlTypeName.INTEGER)),
        );  
    public void testAlreadyPinnedProjectNotReSplit() {
        planner.setRoot(input);  
        assertSplit(result);
    public void testAllLiteralProjectNotSplit() {
                aggName
            cluster.traitSet(),
        OpenSearchProject lowerProject = (OpenSearchProject) lower;
    private void assertSplit(RelNode result) {  
        OpenSearchTableScan scan = (OpenSearchTableScan) stubMarkedScan();  
import java.util.Collections;  
            BACKENDS,
            List.of()
    private void assertNotSplit(RelNode result) {  
            lowerProject.getProjects().stream().noneMatch(e -> e instanceof RexLiteral)
        assertFalse("lower Project must NOT be pinned", lowerProject.isPinAboveExchange());
        };
                null,  
            cluster,
                null,
            name,
        return new OpenSearchTableScan(  
        OpenSearchAggregate agg = aggregate("PERCENTILE_APPROX", List.of(0, 1), pinned);  
    private static final List<String> BACKENDS = List.of("mock-parquet");  
    /** A minimal user-defined agg function with the given name (two ANY operands). */
 * The OpenSearch Contributors require contributions made to  
        RelNode result = runRule(agg);
            "lower Project must carry only physical (non-literal) columns",
                false,
            );
            List.of(fieldRef, literal),
    // ── builders ──────────────────────────────────────────────────────────────
        );
            List.of(rexBuilder.makeInputRef(scan, 0), fifty),
            cluster.traitSet(),
                argList,
                aggName  
    /** Asserts the result is Aggregate -> pinned-upper Project -> unpinned-lower Project, with the
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.calcite.rex.RexNode;
import org.apache.calcite.sql.SqlAggFunction;
    private OpenSearchAggregate buildAggregateOverLiteralProject(String aggName, List<Integer> argList) {
        assertTrue("upper Project must be pinned above the exchange", upperProject.isPinAboveExchange());
                typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true),
import org.apache.calcite.rel.core.AggregateCall;  
        OpenSearchProject project = new OpenSearchProject(  
/*  
import org.apache.calcite.sql.type.ReturnTypes;
        RexNode fieldRef = rexBuilder.makeInputRef(scan, 0);
        RelDataTypeFactory.Builder b = typeFactory.builder();  
 * {@code OpenSearchAggregate -> OpenSearchProject} trees by hand and runs the rule through a  
 * compatible open source license.
        ) {  
        assertTrue(  
 * pinned-above-exchange copy over an unpinned physical-only copy.
            rowType(List.of("field", "$f1"), List.of(SqlTypeName.INTEGER, SqlTypeName.INTEGER)),
        }  
                -1,
            mockTable("test_index", new String[] { "field" }, new SqlTypeName[] { SqlTypeName.INTEGER }),  
            null,  
            cluster.traitSet(),
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
    }  
        RelNode child = result.getInput(0);
        );
            b.add(names.get(i), typeFactory.createSqlType(types.get(i)));
    }  
import org.apache.calcite.plan.hep.HepPlanner;
                0,
    private OpenSearchAggregate aggregate(String aggName, List<Integer> argList, OpenSearchProject input) {
                List.of(),  
    }  
    public void testNonLiteralArgAggregateNotSplit() {  
    // ── positive cases ─────────────────────────────────────────────────────────
    private RelDataType rowType(List<String> names, List<SqlTypeName> types) {
        assertNotSplit(runRule(agg));
    }  
        for (int i = 0; i < names.size(); i++) {
import org.apache.calcite.rel.type.RelDataType;
        return (RexLiteral) rexBuilder.makeLiteral(BigDecimal.valueOf(value), typeFactory.createSqlType(SqlTypeName.INTEGER), true);
import org.opensearch.analytics.planner.BasePlannerRulesTests;
    }  
import org.apache.calcite.plan.hep.HepProgramBuilder;  
                udaf(aggName),
        assertTrue("top should be an aggregate", result instanceof OpenSearchAggregate);
                input,  
    }  
            BACKENDS,
        assertTrue("child Project's input must be the scan, not a duplicated Project", child.getInput(0) instanceof OpenSearchTableScan);
            Optionality.FORBIDDEN
import org.apache.calcite.sql.SqlFunctionCategory;  
    /** Asserts the rule did NOT split: the aggregate's child is a single Project directly over the scan
                false,
        assertNotSplit(result);
    }
        HepPlanner planner = new HepPlanner(program);
        // Project(field, $f1=10) under Aggregate(take($0,$1)).
        assertTrue("child's input stays the scan (not a duplicated Project)", child.getInput(0) instanceof OpenSearchTableScan);
    }
        OpenSearchProject project = new OpenSearchProject(
        RexLiteral fifty = literal(50);
        RelNode result = runRule(buildAggregateOverLiteralProject("SUM", List.of(0)));  
    private static SqlAggFunction udaf(String name) {  
            AggregateMode.SINGLE,  
import org.apache.calcite.rel.RelCollations;
        RelNode result = runRule(buildAggregateOverLiteralProject("TAKE", List.of(0, 1)));  
            ImmutableBitSet.of(),  
        assertTrue("lower should be an OpenSearchProject", lower instanceof OpenSearchProject);  
        );  
                SqlStdOperatorTable.SUM,
        );
                false,
            cluster,
        assertFalse("child Project must not be pinned", ((OpenSearchProject) child).isPinAboveExchange());
            false,
        OpenSearchTableScan scan = (OpenSearchTableScan) stubMarkedScan();
        return new SqlAggFunction(
 */  
            OperandTypes.ANY_ANY,
 */  
        OpenSearchProject upperProject = (OpenSearchProject) upper;
    private RelNode runRule(RelNode input) {  
        assertTrue("upper should be an OpenSearchProject", upper instanceof OpenSearchProject);  
                null,  
            cluster.traitSet(),
                false,  
import java.util.List;
            : AggregateCall.create(
            cluster,  
 * this file be licensed under the Apache-2.0 license or a
            cluster.traitSet(),
import org.apache.calcite.rel.type.RelDataTypeFactory;
    public void testTakeLiteralArgProjectIsSplit() {
        // the rule must not fire (SUM doesn't reference the literal as a config arg).
    // ── negative cases ──────────────────────────────────────────────────────────
import org.apache.calcite.sql.type.OperandTypes;  
    }
    private RelNode stubMarkedScan() {
    }
        RelNode upper = result.getInput(0);
            cluster,
            input,
            rowType(List.of("$f0"), List.of(SqlTypeName.INTEGER)),
    }
        // Already pinned → the rule's guard returns early; the child stays a single Project over the scan.
import org.apache.calcite.rel.RelNode;
                -1,
 * SPDX-License-Identifier: Apache-2.0
            Map.of(),
import java.math.BigDecimal;
        assertTrue("child stays an OpenSearchProject", child instanceof OpenSearchProject);
    }
        OpenSearchTableScan scan = (OpenSearchTableScan) stubMarkedScan();  
    public void testPercentileLiteralArgProjectIsSplit() {
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;  
        // A percentile whose Project has NOTHING but the literal to push down: split buys nothing.
            scan,
            List.of(call),
                input,  
            ? AggregateCall.create(
        return new OpenSearchAggregate(
                List.of(),  
        RexLiteral literal = literal(50);
    }
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
            BACKENDS,  
            SqlKind.OTHER_FUNCTION,
    }
        assertTrue("child should be an OpenSearchProject", child instanceof OpenSearchProject);  
        // Upper (pinned) copy must not re-fire the rule.  
package org.opensearch.analytics.planner.rules;
                0,
                false,
        // Project(field, $f1=50) under Aggregate(percentile_approx($0,$1)).
    // ── assertions ──────────────────────────────────────────────────────────────
import org.apache.calcite.util.Optionality;
        );  
/**
        assertTrue("top should be an aggregate", result instanceof OpenSearchAggregate);
        // SUM is not a literal-config-arg aggregate — even over a Project with a literal column,
import org.opensearch.analytics.planner.rel.OpenSearchProject;
import org.apache.calcite.rex.RexLiteral;  
 *
    /** A marked OpenSearchTableScan (single INTEGER column "field") usable as a rule leaf. */
            SqlFunctionCategory.USER_DEFINED_FUNCTION,
import org.apache.calcite.sql.SqlKind;
            ReturnTypes.ARG0_FORCE_NULLABLE,
        HepProgram program = new HepProgramBuilder().addRuleInstance(new OpenSearchAggLiteralArgProjectSplitRule()).build();
import org.apache.calcite.util.ImmutableBitSet;  
                argList,
        return planner.findBestExp();
            Collections.singletonList(null)
        AggregateCall call = "SUM".equals(aggName)  
            )  
            null,  
        assertTrue("upper Project keeps the literal column", upperProject.getProjects().stream().anyMatch(e -> e instanceof RexLiteral));  
}  
import org.opensearch.analytics.planner.rel.AggregateMode;  
                false,  
public class OpenSearchAggLiteralArgProjectSplitRuleTests extends BasePlannerRulesTests {
import java.util.Map;
 * {@link HepPlanner}, asserting the literal-bearing Project is (or isn't) duplicated into a
     *  literal kept only on the upper copy and the lower copy carrying just the physical column. */
            scan,  
        return b.build();
 * Direct-call unit tests for {@link OpenSearchAggLiteralArgProjectSplitRule}. Builds marked
            false,  
    private RexLiteral literal(int value) {
        OpenSearchAggregate agg = aggregate("PERCENTILE_APPROX", List.of(0), project);
     *  (no duplicated Project-over-Project stack, nothing pinned). */
        assertSplit(result);
        assertFalse("lower Project must keep at least one column to push down", lowerProject.getProjects().isEmpty());
        RelNode lower = upperProject.getInput();
            BACKENDS
        RelNode result = runRule(buildAggregateOverLiteralProject("PERCENTILE_APPROX", List.of(0, 1)));  
            null,
                RelCollations.EMPTY,
                // Matches the UDAF's ReturnTypes.ARG0_FORCE_NULLABLE (arg 0 = field, INTEGER).
        RelNode child = result.getInput(0);  
            BACKENDS  
            List.of(fifty),  
                RelCollations.EMPTY,
        OpenSearchProject pinned = new OpenSearchProject(  
            true // pinAboveExchange
        RexLiteral fifty = literal(50);
            Map.of(),  
import org.apache.calcite.plan.hep.HepProgram;
            cluster,  
        return aggregate(aggName, argList, project);
    /** Aggregate({@code aggName}(argList)) over {@code Project(field=$0, $f1=50)}. */
