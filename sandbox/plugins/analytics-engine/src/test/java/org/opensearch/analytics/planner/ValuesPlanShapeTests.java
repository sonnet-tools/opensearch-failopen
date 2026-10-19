import org.apache.calcite.rel.logical.LogicalJoin;
        planner.setRoot(values);
        );
import org.apache.calcite.rel.core.Values;  
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));  
import org.apache.calcite.rel.RelNode;
            Set<EngineCapability> caps = new HashSet<>(super.supportedEngineCapabilities());
        planner.setRoot(makeresults);
     * Values as a Union arm — the literal-row source is already at COORDINATOR+SINGLETON,
     * ON i.val = v.x}.  
     * the makeresults query Project, so a single Project over the normalized VARCHAR Values reaches
        assertTrue("input must be a Values", input instanceof Values);  
        // Values row type must match the scan's output row type for Union to type-check.
        ImmutableList<ImmutableList<RexLiteral>> tuples = ImmutableList.of(ImmutableList.of(one, two));
import org.apache.calcite.sql.type.SqlTypeName;
        );  
        RelDataType normalizedName = input.getRowType().getFieldList().get(0).getType();
            RelDataType.PRECISION_NOT_SPECIFIED,
     * Values as a Join arm — the literal-row source is already at COORDINATOR+SINGLETON, so  
        programBuilder.addRuleInstance(CoreRules.PROJECT_MERGE);  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
        RelNode plan = LogicalValues.create(cluster, rowType, tuples);  
        RelDataType varcharNotNull = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), false);
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        programBuilder.addRuleInstance(new OpenSearchValuesCharNormalizeRule());
        RelDataType char5 = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.CHAR, 5), false);
        assertEquals(
    private static int countProjects(RelNode root) {  
    /**
        RexNode castAge = rexBuilder.makeCast(varcharNotNull, rexBuilder.makeInputRef(values, 1));
        assertEquals("char column normalized to VARCHAR", SqlTypeName.VARCHAR, normalizedName.getSqlTypeName());
        assertPlanShape(
     * casting Project restores the original CHAR row type. The integer column and its literals stay
        );
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        programBuilder.addRuleInstance(new OpenSearchValuesCharNormalizeRule());  
            SqlStdOperatorTable.EQUALS,
    /** Single literal row — the {@code SELECT 1+1, NOW()} shape after Calcite unwraps. */
import org.apache.calcite.rel.type.RelDataType;  
        RelNode join = LogicalJoin.create(scan, values, List.of(), cond, Set.<CorrelationId>of(), JoinRelType.INNER);
        ImmutableList<ImmutableList<RexLiteral>> tuples = ImmutableList.of(ImmutableList.of(one));  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(  
    }
        for (RelNode in : root.getInputs()) {
            result.getRowType().getFieldList().get(0).getType().getSqlTypeName()  
import org.apache.calcite.rel.logical.LogicalValues;
        assertTrue("top node must be a single Project", result instanceof Project);
        assertTrue("input must be a Values", result.getInput(0) instanceof Values);  
        RexLiteral one = (RexLiteral) rexBuilder.makeLiteral(1, intType, true);  
        RelNode result = runPlanner(plan, singleShardContext());  
import org.apache.calcite.rex.RexLiteral;
            "normalized VARCHAR must be precision-unspecified",
public class ValuesPlanShapeTests extends PlanShapeTestBase {  
            result
     */  
            caps.add(EngineCapability.UNION);  
    public void testCharValues_NormalizedToVarcharUnderCastingProject() {  
            OpenSearchProject(c=[ANNOTATED_PROJECT_EXPR(id=0, backends=[mock-parquet], +($0, $1))], viableBackends=[[mock-parquet]])
/**
        assertPlanShape("""
        RexLiteral ninetyNine = (RexLiteral) rexBuilder.makeLiteral(99, intType, true);  
    public void testValuesAsUnionArm_2shard() {
     * literals plus an INTEGER column is rewritten to a casting Project over a Values whose char column  
 * Plan-shape tests for {@link org.opensearch.analytics.planner.rel.OpenSearchValues}.
     * and char literals are now precision-unspecified VARCHAR, so isthmus emits Substrait Str. The
     *  exercise a Union over a Values arm. */
            SqlTypeName.CHAR,
        }
        RelDataType valuesRowType = typeFactory.builder().add("x", intType).build();
import org.apache.calcite.rel.core.Project;
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        ImmutableList<ImmutableList<RexLiteral>> tuples = ImmutableList.of(  
        RelNode result = runPlanner(join, perIndexContext(Map.of("test_index", 2)));  
     * untouched. Applying the rule directly keeps the assertion on the rule output shape and away from  
        RexLiteral two = (RexLiteral) rexBuilder.makeLiteral(2, intType, true);
        RexLiteral twentyFive = (RexLiteral) rexBuilder.makeLiteral("25", typeFactory.createSqlType(SqlTypeName.CHAR, 2), false);
            result
            OpenSearchValues(tuples=[[{ 1, 2 }]], viableBackends=[[mock-parquet]])  
        RelDataType rowType = typeFactory.builder().add("name", char5).add("age", char3).build();
    }  
        RexLiteral alice = (RexLiteral) rexBuilder.makeLiteral("Alice", typeFactory.createSqlType(SqlTypeName.CHAR, 5), false);
        RexLiteral twentyFive = (RexLiteral) rexBuilder.makeLiteral(25, intType, true);
    /** Values feeding a Project — confirms the rel composes cleanly downstream. */
            ImmutableList.of(bob, twentyFive)
            """
        RexLiteral bob = (RexLiteral) rexBuilder.makeLiteral("Bob", typeFactory.createSqlType(SqlTypeName.CHAR, 3), false);
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
    /**
import com.google.common.collect.ImmutableList;
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
import java.util.Map;
        ImmutableList<ImmutableList<RexLiteral>> tuples = ImmutableList.of(ImmutableList.of(ninetyNine, one));
import org.opensearch.analytics.planner.rules.OpenSearchValuesCharNormalizeRule;
        RelOptTable scanTable = mockTable("test_index", "status", "size");
        RelNode input = result.getInput(0);
        }
    public void testValuesAsJoinArm_2shard() {
            assertEquals("char literal rebuilt as VARCHAR", SqlTypeName.VARCHAR, tuple.get(0).getType().getSqlTypeName());  
        RelDataType rowType = typeFactory.builder().add("name", charType).add("age", intType).build();  
     */
            intFields(),
        RelNode values = LogicalValues.create(cluster, valuesRowType, tuples);
            count += countProjects(in);  
        RexLiteral one = (RexLiteral) rexBuilder.makeLiteral(1, intType, true);
        HepProgramBuilder programBuilder = new HepProgramBuilder();
        RelDataType charType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.CHAR, 5), true);
import org.apache.calcite.rel.logical.LogicalProject;
            assertEquals("int literal stays INTEGER", SqlTypeName.INTEGER, tuple.get(1).getType().getSqlTypeName());
        );  
        Values normalized = (Values) input;
        assertEquals("no intermediate Project remains", 1, countProjects(result));
    private static final class UnionAndValuesCapableBackend extends MockDataFusionBackend {
            rexBuilder.makeInputRef(intType, 0),
        assertPlanShape("""
    /** Mock DF backend with both UNION and VALUES engine capabilities for tests that  
    }  
        RelNode result = runPlanner(plan, singleShardContext());
 */
     * so no ER is added on the Values arm; the multi-shard scan arm gathers via ER, and  
    }
        ImmutableList<ImmutableList<RexLiteral>> tuples = ImmutableList.of(
    }
import org.apache.calcite.rel.rules.CoreRules;
        RexLiteral thirty = (RexLiteral) rexBuilder.makeLiteral(30, intType, true);  
     * backend CAST-viability marking.
import org.apache.calcite.plan.hep.HepPlanner;  
                OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])  
import org.apache.calcite.rel.core.JoinRelType;
        int count = root instanceof Project ? 1 : 0;
    /**
        @Override  
 */  
        HepPlanner planner = new HepPlanner(programBuilder.build());
        return count;
        );  
                  OpenSearchValues(tuples=[[{ 99, 1 }]], viableBackends=[[mock-parquet]])
        RelDataType rowType = typeFactory.builder().add("a", intType).add("b", intType).build();
            "int column type unchanged",  
import org.apache.calcite.rel.core.CorrelationId;  
                  OpenSearchValues(tuples=[[{ 1 }]], viableBackends=[[mock-parquet]])  
        RelDataType normalizedName = result.getInput(0).getRowType().getFieldList().get(0).getType();
        RexLiteral bob = (RexLiteral) rexBuilder.makeLiteral("Bob", typeFactory.createSqlType(SqlTypeName.CHAR, 3), false);
                """,  
    }  
                """,
                OpenSearchUnion(all=[true], viableBackends=[[mock-parquet]])
        RexLiteral alice = (RexLiteral) rexBuilder.makeLiteral("Alice", typeFactory.createSqlType(SqlTypeName.CHAR, 5), false);
            "projected char column keeps the ORIGINAL CHAR type",
import org.apache.calcite.plan.hep.HepProgramBuilder;
    }
package org.opensearch.analytics.planner;
 * COORDINATOR+SINGLETON so the root demand satisfies directly with no ER above it.
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);  
            return caps;
            ImmutableList.of(bob, twentyFive)
            normalizedName.getPrecision()  
        );  
            rexBuilder.makeInputRef(intType, 2)  
import org.apache.calcite.rel.logical.LogicalUnion;  
    /**
     * no ER is added on the Values side; the multi-shard scan side gathers via ER. The Join
        assertEquals(  
            """, result);
        RelDataType rowType = typeFactory.builder().add("a", intType).add("b", intType).build();
     */
}
 *
            """, result);
 * compatible open source license.
import org.apache.calcite.rex.RexNode;
     * marking. This is the shape pushdownRules produces for makeresults.
        RelNode result = runPlanner(union, unionAndValuesContext("test_index", 2));
        RexLiteral one = (RexLiteral) rexBuilder.makeLiteral(1, intType, true);  
            List.of(new UnionAndValuesCapableBackend(), LUCENE)
    public void testSingleRowValues() {  
        ImmutableList<ImmutableList<RexLiteral>> tuples = ImmutableList.of(ImmutableList.of(one, two));
              OpenSearchValues(tuples=[[{ 1, 2 }]], viableBackends=[[mock-parquet]])  
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
import java.util.List;  
            SqlTypeName.INTEGER,
     * Rule-level check for {@link OpenSearchValuesCharNormalizeRule}. A Values with mixed-length CHAR
     * the Union itself runs at COORDINATOR+SINGLETON. Mirrors the SQL pattern
        RelNode values = LogicalValues.create(cluster, rowType, tuples);  
        RelDataType valuesRowType = typeFactory.builder().add("status", intType).add("size", intType).build();
    }
     * {@code SELECT v FROM idx UNION ALL SELECT x FROM (VALUES (99))}.
        assertPlanShape(  
        RelNode values = LogicalValues.create(cluster, rowType, tuples);  
            "parquet",
        RelNode result = planner.findBestExp();  
        // Equi-join on scan.$0 == values.$0 (which is scan-side index 2 after the join row type).
        RelNode result = planner.findBestExp();  
    public void testProjectOverValues() {  
/*  
        RexNode sum = rexBuilder.makeCall(SqlStdOperatorTable.PLUS, rexBuilder.makeInputRef(values, 0), rexBuilder.makeInputRef(values, 1));
            """
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("int column stays INTEGER", SqlTypeName.INTEGER, input.getRowType().getFieldList().get(1).getType().getSqlTypeName());
        RexLiteral two = (RexLiteral) rexBuilder.makeLiteral(2, intType, true);
     */  
        // Values: single int column "x" with one row; type matches scan's $0 ("status").  
        RexNode castName = rexBuilder.makeCast(varcharNotNull, rexBuilder.makeInputRef(values, 0));  
        );
    public void testCharValues_FoldWithProjectMergeYieldsSingleProject() {
        );
        }
        RelNode makeresults = LogicalProject.create(values, List.of(), List.of(castName, castAge), List.of("name", "age"));
    private PlannerContext unionAndValuesContext(String indexName, int shardCount) {  
import java.util.Set;
        RelDataType char3 = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.CHAR, 3), false);  
        RelNode union = LogicalUnion.create(List.of(scan, values), /* all */ true);
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            Map.of(indexName, shardCount),  
        RexNode cond = rexBuilder.makeCall(  
            ImmutableList.of(alice, thirty),  
        RelNode values = LogicalValues.create(cluster, rowType, tuples);
        return buildContextPerIndex(
        protected Set<EngineCapability> supportedEngineCapabilities() {
        );
        for (List<RexLiteral> tuple : normalized.getTuples()) {
 * The OpenSearch Contributors require contributions made to  
        RelNode plan = LogicalProject.create(values, List.of(), List.of(sum), List.of("c"));
        RelNode scan = stubScan(scanTable);
        assertTrue("top node must be a casting Project", result instanceof Project);
        assertEquals("char column normalized to VARCHAR", SqlTypeName.VARCHAR, normalizedName.getSqlTypeName());  
     * runs at COORDINATOR+SINGLETON. Mirrors {@code SELECT i.val FROM idx i JOIN (VALUES …) v
        HepProgramBuilder programBuilder = new HepProgramBuilder();
import java.util.HashSet;
     * With the rule registered in the pushdown collection, PROJECT_MERGE folds the casting Project into  
            ImmutableList.of(alice, thirty),
import org.apache.calcite.plan.RelOptTable;
        RelNode values = LogicalValues.create(cluster, valuesRowType, tuples);
 * Values is a coordinator-local literal-row source; the planner stamps it at  
            result.getRowType().getFieldList().get(1).getType().getSqlTypeName()
        RexLiteral one = (RexLiteral) rexBuilder.makeLiteral(1, intType, true);  
    }  
import org.opensearch.analytics.spi.EngineCapability;  
        RexLiteral thirty = (RexLiteral) rexBuilder.makeLiteral("30", typeFactory.createSqlType(SqlTypeName.CHAR, 2), false);  
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
        HepPlanner planner = new HepPlanner(programBuilder.build());
