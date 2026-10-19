        for (List<RexLiteral> tuple : normalized.getTuples()) {
            """, result);
     * runs at COORDINATOR+SINGLETON. Mirrors {@code SELECT i.val FROM idx i JOIN (VALUES …) v
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
        assertEquals(
            intFields(),
            result.getRowType().getFieldList().get(1).getType().getSqlTypeName()
        RexLiteral two = (RexLiteral) rexBuilder.makeLiteral(2, intType, true);
        programBuilder.addRuleInstance(new OpenSearchValuesCharNormalizeRule());
}
        RelNode result = runPlanner(join, perIndexContext(Map.of("test_index", 2)));
     */
    /**
     * backend CAST-viability marking.
            RelDataType.PRECISION_NOT_SPECIFIED,
        RexNode cond = rexBuilder.makeCall(
        RexLiteral bob = (RexLiteral) rexBuilder.makeLiteral("Bob", typeFactory.createSqlType(SqlTypeName.CHAR, 3), false);
            count += countProjects(in);
import org.apache.calcite.rex.RexLiteral;
            ImmutableList.of(bob, twentyFive)
        protected Set<EngineCapability> supportedEngineCapabilities() {
        RelNode values = LogicalValues.create(cluster, rowType, tuples);
        RelDataType rowType = typeFactory.builder().add("name", char5).add("age", char3).build();
import com.google.common.collect.ImmutableList;
        HepProgramBuilder programBuilder = new HepProgramBuilder();
        ImmutableList<ImmutableList<RexLiteral>> tuples = ImmutableList.of(
        RelDataType rowType = typeFactory.builder().add("a", intType).add("b", intType).build();
     * Rule-level check for {@link OpenSearchValuesCharNormalizeRule}. A Values with mixed-length CHAR
    public void testCharValues_FoldWithProjectMergeYieldsSingleProject() {
        }
        HepProgramBuilder programBuilder = new HepProgramBuilder();
        assertEquals(
import org.apache.calcite.rel.logical.LogicalProject;
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
import org.apache.calcite.rel.core.JoinRelType;
            return caps;
        );
        );
        RelDataType normalizedName = input.getRowType().getFieldList().get(0).getType();
import org.apache.calcite.rel.core.CorrelationId;
        RelNode plan = LogicalProject.create(values, List.of(), List.of(sum), List.of("c"));
        RexLiteral one = (RexLiteral) rexBuilder.makeLiteral(1, intType, true);
    }
              OpenSearchValues(tuples=[[{ 1, 2 }]], viableBackends=[[mock-parquet]])
        RelNode values = LogicalValues.create(cluster, rowType, tuples);
        RexLiteral twentyFive = (RexLiteral) rexBuilder.makeLiteral(25, intType, true);
        }
import org.apache.calcite.rel.logical.LogicalValues;
 * COORDINATOR+SINGLETON so the root demand satisfies directly with no ER above it.
     */
    public void testValuesAsUnionArm_2shard() {
import java.util.HashSet;
        RexLiteral two = (RexLiteral) rexBuilder.makeLiteral(2, intType, true);
     */
        RelNode union = LogicalUnion.create(List.of(scan, values), /* all */ true);
        RexLiteral one = (RexLiteral) rexBuilder.makeLiteral(1, intType, true);
        ImmutableList<ImmutableList<RexLiteral>> tuples = ImmutableList.of(ImmutableList.of(one));
import java.util.List;
        assertEquals("int column stays INTEGER", SqlTypeName.INTEGER, input.getRowType().getFieldList().get(1).getType().getSqlTypeName());
        RelNode values = LogicalValues.create(cluster, rowType, tuples);
     * the Union itself runs at COORDINATOR+SINGLETON. Mirrors the SQL pattern
    /**
    }
            SqlStdOperatorTable.EQUALS,
        RelDataType rowType = typeFactory.builder().add("a", intType).add("b", intType).build();
import org.apache.calcite.sql.type.SqlTypeName;
    private static final class UnionAndValuesCapableBackend extends MockDataFusionBackend {
    }
    /** Single literal row — the {@code SELECT 1+1, NOW()} shape after Calcite unwraps. */
        assertEquals(
        RexLiteral alice = (RexLiteral) rexBuilder.makeLiteral("Alice", typeFactory.createSqlType(SqlTypeName.CHAR, 5), false);
        // Values: single int column "x" with one row; type matches scan's $0 ("status").
     *  exercise a Union over a Values arm. */
            OpenSearchValues(tuples=[[{ 1, 2 }]], viableBackends=[[mock-parquet]])
import org.apache.calcite.plan.hep.HepProgramBuilder;
import org.apache.calcite.rel.RelNode;
     * Values as a Join arm — the literal-row source is already at COORDINATOR+SINGLETON, so
 * Plan-shape tests for {@link org.opensearch.analytics.planner.rel.OpenSearchValues}.
     * so no ER is added on the Values arm; the multi-shard scan arm gathers via ER, and
                OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])
    }
        RelDataType valuesRowType = typeFactory.builder().add("status", intType).add("size", intType).build();
        RelOptTable scanTable = mockTable("test_index", "status", "size");
        RelNode scan = stubScan(scanTable);
import org.apache.calcite.rel.core.Project;
            result
import org.apache.calcite.rel.logical.LogicalJoin;
     * literals plus an INTEGER column is rewritten to a casting Project over a Values whose char column
        RelDataType normalizedName = result.getInput(0).getRowType().getFieldList().get(0).getType();
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
 * compatible open source license.
    public void testCharValues_NormalizedToVarcharUnderCastingProject() {
        RexLiteral bob = (RexLiteral) rexBuilder.makeLiteral("Bob", typeFactory.createSqlType(SqlTypeName.CHAR, 3), false);
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        HepPlanner planner = new HepPlanner(programBuilder.build());
        HepPlanner planner = new HepPlanner(programBuilder.build());
        ImmutableList<ImmutableList<RexLiteral>> tuples = ImmutableList.of(
        assertTrue("top node must be a single Project", result instanceof Project);
        assertTrue("top node must be a casting Project", result instanceof Project);
                  OpenSearchValues(tuples=[[{ 99, 1 }]], viableBackends=[[mock-parquet]])
        RelNode result = planner.findBestExp();
public class ValuesPlanShapeTests extends PlanShapeTestBase {
import org.apache.calcite.plan.hep.HepPlanner;
     * casting Project restores the original CHAR row type. The integer column and its literals stay
        RelNode result = runPlanner(plan, singleShardContext());
        // Values row type must match the scan's output row type for Union to type-check.
        assertPlanShape(
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        RelNode result = runPlanner(union, unionAndValuesContext("test_index", 2));
    /** Mock DF backend with both UNION and VALUES engine capabilities for tests that
        RexLiteral thirty = (RexLiteral) rexBuilder.makeLiteral(30, intType, true);
 */
        planner.setRoot(makeresults);
            List.of(new UnionAndValuesCapableBackend(), LUCENE)
    private static int countProjects(RelNode root) {
 * SPDX-License-Identifier: Apache-2.0
import java.util.Map;
        return count;
            ImmutableList.of(bob, twentyFive)
        return buildContextPerIndex(
        RelNode result = planner.findBestExp();
        RelNode makeresults = LogicalProject.create(values, List.of(), List.of(castName, castAge), List.of("name", "age"));
import org.apache.calcite.rel.core.Values;
        );
    public void testSingleRowValues() {
            """
        assertEquals("char column normalized to VARCHAR", SqlTypeName.VARCHAR, normalizedName.getSqlTypeName());
        RelDataType char5 = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.CHAR, 5), false);
     * and char literals are now precision-unspecified VARCHAR, so isthmus emits Substrait Str. The
        for (RelNode in : root.getInputs()) {
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        RelNode plan = LogicalValues.create(cluster, rowType, tuples);
            SqlTypeName.INTEGER,
        assertEquals("no intermediate Project remains", 1, countProjects(result));
    }
        RexLiteral ninetyNine = (RexLiteral) rexBuilder.makeLiteral(99, intType, true);
            result
                """,
/**
        ImmutableList<ImmutableList<RexLiteral>> tuples = ImmutableList.of(ImmutableList.of(one, two));
            "normalized VARCHAR must be precision-unspecified",
        RelDataType valuesRowType = typeFactory.builder().add("x", intType).build();
        assertEquals("char column normalized to VARCHAR", SqlTypeName.VARCHAR, normalizedName.getSqlTypeName());
        Values normalized = (Values) input;
        assertTrue("input must be a Values", input instanceof Values);
     */
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
 */
     * no ER is added on the Values side; the multi-shard scan side gathers via ER. The Join
import org.apache.calcite.rel.logical.LogicalUnion;
            ImmutableList.of(alice, thirty),
        @Override
        RexLiteral alice = (RexLiteral) rexBuilder.makeLiteral("Alice", typeFactory.createSqlType(SqlTypeName.CHAR, 5), false);
        );
     * ON i.val = v.x}.
            assertEquals("int literal stays INTEGER", SqlTypeName.INTEGER, tuple.get(1).getType().getSqlTypeName());
        RelDataType char3 = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.CHAR, 3), false);
            assertEquals("char literal rebuilt as VARCHAR", SqlTypeName.VARCHAR, tuple.get(0).getType().getSqlTypeName());
        );
        RexNode castName = rexBuilder.makeCast(varcharNotNull, rexBuilder.makeInputRef(values, 0));
 * The OpenSearch Contributors require contributions made to
    /**
        RexNode castAge = rexBuilder.makeCast(varcharNotNull, rexBuilder.makeInputRef(values, 1));
        RelNode join = LogicalJoin.create(scan, values, List.of(), cond, Set.<CorrelationId>of(), JoinRelType.INNER);
     * marking. This is the shape pushdownRules produces for makeresults.
            """
        RexLiteral one = (RexLiteral) rexBuilder.makeLiteral(1, intType, true);
     * the makeresults query Project, so a single Project over the normalized VARCHAR Values reaches
 *
        );
        RelNode values = LogicalValues.create(cluster, valuesRowType, tuples);
        RexLiteral one = (RexLiteral) rexBuilder.makeLiteral(1, intType, true);
        assertTrue("input must be a Values", result.getInput(0) instanceof Values);
    public void testProjectOverValues() {
        );
            "parquet",
package org.opensearch.analytics.planner;
    /** Values feeding a Project — confirms the rel composes cleanly downstream. */
            result.getRowType().getFieldList().get(0).getType().getSqlTypeName()
            normalizedName.getPrecision()
            rexBuilder.makeInputRef(intType, 2)
     * untouched. Applying the rule directly keeps the assertion on the rule output shape and away from
        // Equi-join on scan.$0 == values.$0 (which is scan-side index 2 after the join row type).
        RelDataType charType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.CHAR, 5), true);
    }
    }
            "int column type unchanged",
        assertPlanShape(
import org.apache.calcite.plan.RelOptTable;
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
     * Values as a Union arm — the literal-row source is already at COORDINATOR+SINGLETON,
        assertPlanShape("""
        RexLiteral thirty = (RexLiteral) rexBuilder.makeLiteral("30", typeFactory.createSqlType(SqlTypeName.CHAR, 2), false);
        RelNode values = LogicalValues.create(cluster, valuesRowType, tuples);
            ImmutableList.of(alice, thirty),
            SqlTypeName.CHAR,
 * this file be licensed under the Apache-2.0 license or a
        RelNode input = result.getInput(0);
    public void testValuesAsJoinArm_2shard() {
        }
            "projected char column keeps the ORIGINAL CHAR type",
        RelNode result = runPlanner(plan, singleShardContext());
        RexLiteral twentyFive = (RexLiteral) rexBuilder.makeLiteral("25", typeFactory.createSqlType(SqlTypeName.CHAR, 2), false);
                OpenSearchUnion(all=[true], viableBackends=[[mock-parquet]])
        programBuilder.addRuleInstance(CoreRules.PROJECT_MERGE);
        planner.setRoot(values);
        programBuilder.addRuleInstance(new OpenSearchValuesCharNormalizeRule());
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        ImmutableList<ImmutableList<RexLiteral>> tuples = ImmutableList.of(ImmutableList.of(ninetyNine, one));
            Map.of(indexName, shardCount),
import org.apache.calcite.rel.type.RelDataType;
                """,
            OpenSearchProject(c=[ANNOTATED_PROJECT_EXPR(id=0, backends=[mock-parquet], +($0, $1))], viableBackends=[[mock-parquet]])
    }
            rexBuilder.makeInputRef(intType, 0),
            """, result);
     * With the rule registered in the pushdown collection, PROJECT_MERGE folds the casting Project into
    private PlannerContext unionAndValuesContext(String indexName, int shardCount) {
        );
        int count = root instanceof Project ? 1 : 0;
import org.apache.calcite.rex.RexNode;
import org.opensearch.analytics.spi.EngineCapability;
        );
import java.util.Set;
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        RelDataType varcharNotNull = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), false);
        ImmutableList<ImmutableList<RexLiteral>> tuples = ImmutableList.of(ImmutableList.of(one, two));
 * Values is a coordinator-local literal-row source; the planner stamps it at
    /**
     * {@code SELECT v FROM idx UNION ALL SELECT x FROM (VALUES (99))}.
                  OpenSearchValues(tuples=[[{ 1 }]], viableBackends=[[mock-parquet]])
/*
        RelDataType rowType = typeFactory.builder().add("name", charType).add("age", intType).build();
import org.apache.calcite.rel.rules.CoreRules;
    }
            Set<EngineCapability> caps = new HashSet<>(super.supportedEngineCapabilities());
            caps.add(EngineCapability.UNION);
        RexNode sum = rexBuilder.makeCall(SqlStdOperatorTable.PLUS, rexBuilder.makeInputRef(values, 0), rexBuilder.makeInputRef(values, 1));
        assertPlanShape("""
import org.opensearch.analytics.planner.rules.OpenSearchValuesCharNormalizeRule;
