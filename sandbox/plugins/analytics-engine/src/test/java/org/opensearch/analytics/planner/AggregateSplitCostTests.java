            List.of("status", "size")
            return aggregate;
    /**
            && aggregate.getInput() instanceof OpenSearchExchangeReducer) {  
 *
            List.of(rexBuilder.makeInputRef(scan, 0), countOverEmpty),
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
    private static void assertModeAndNoPartialAboveExchange(RelNode root, AggregateMode expectedTopMode) {
        );
            List.of(),  
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
     * rule emits a single SINGLE aggregate.  
    /**  
        RelNode result = runPlanner(plan, multiShardContext());
            ImmutableList.of(),
        Map<String, Map<String, Object>> fields = new LinkedHashMap<>();
    public void testAggregateOverCollatedSort_2shard_doesNotSplit() {
     * into {@code Aggregate(FINAL) → ER → Aggregate(PARTIAL) → Project → Filter → Scan}.
     * SINGLETON input, so the walk must stop at it (not treat it as pass-through). Aggregate over  
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);  
     *   <li>Narrowing Project (status_code only): the projected row is narrower than the PARTIAL
        );
                        OpenSearchFilter(condition=[AND(ANNOTATED_PREDICATE(id=0, backends=[mock-lucene, mock-parquet], =($0, 200)), ANNOTATED_PREDICATE(id=1, backends=[mock-lucene, mock-parquet], =($1, 1024)), ANNOTATED_PREDICATE(id=2, backends=[mock-lucene, mock-parquet], =($2, 3)), ANNOTATED_PREDICATE(id=3, backends=[mock-lucene, mock-parquet], =($3, 5)))], viableBackends=[[mock-parquet]])  
     */
                return found;  
        RelNode plan = makeAggregate(sort, countStarCall(sort));  
            }  
public class AggregateSplitCostTests extends PlanShapeTestBase {
    public void testFilterAndProjectBelowAggregate_1shard_doesNotSplit() {
    public void testAggregateOverWindowInProject_2shard_doesNotSplit() {  
            List.of(),  
    /**
     * FINAL → coordinator-PARTIAL → ER bad shape.  
                makeEquals(6, SqlTypeName.INTEGER, 1)  
     * floor; the narrowing Project (status_code, size) keeps the shipped row narrower than the
            true,
        );  
        );
            List.of(),  
                            OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        for (RelNode input : node.getInputs()) {  
            List.of(rexBuilder.makeInputRef(intType, 0)),
        return RelOptUtil.toString(node);  
        LogicalProject windowProject = LogicalProject.create(
            List.of(),
                  OpenSearchSort(sort0=[$0], dir0=[ASC], fetch=[100], viableBackends=[[mock-parquet]])
                """,
        RelNode scan = stubScan(table);
        RelOptTable table = mockTable("test_index", "status", "size");  
package org.opensearch.analytics.planner;
                          OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
     * Structural assertion shared by the no-split / split cases: the top OpenSearchAggregate carries
            )
import org.apache.calcite.rex.RexWindowBounds;
        assertPlanShape(
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
            filter,
                OpenSearchAggregate(group=[{0}], cnt=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
/**
            SqlStdOperatorTable.EQUALS,  
                makeEquals(3, SqlTypeName.INTEGER, 5),  
 * <p>{@code OpenSearchAggregateSplitRule} reads the input's distribution trait: partitioned
     * Aggregate over a Join at multi-shard must NOT split. A Join gathers both inputs to the  
     * additively at the coordinator. 7 {@code =} conjuncts drive the row-count estimate to the 1.0
import static org.mockito.Mockito.when;  
    /**
        }
        // Aggregate also SUM(size) ($1) so size stays in the below Project (else trimmed as dead).
                makeEquals(1, SqlTypeName.INTEGER, 1024),
        if (node instanceof OpenSearchAggregate aggregate
        RelNode result = runPlanner(plan, multiShardContext());  
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;
        RelNode filter = makeFilter(project, makeEquals(0, SqlTypeName.INTEGER, 200));  
        for (String name : List.of("status_code", "size", "region_id", "endpoint_id", "user_id", "method_id", "cache_hit")) {
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);  
            return true;
                makeEquals(2, SqlTypeName.INTEGER, 3),
        RelOptTable table = mockTable("test_index", "status", "size");  
            result
            scan,
        RelNode scan = stubScan(table);
            typeFactory.createSqlType(SqlTypeName.BIGINT),
        RelNode plan = makeAggregate(project, ImmutableBitSet.of(0), countStarCall(project));
        // HTTP-access-log shape: count() by status_code, filtered on 4 fields.  
        RelNode scan = stubScan(table);
            makeAnd(
        when(table.getRowCount()).thenReturn(100d);
            List.of(),  
            && aggregate.getMode() == AggregateMode.PARTIAL
            fields.put(name, Map.of("type", "integer"));  
        assertModeAndNoPartialAboveExchange(result, AggregateMode.FINAL);
     * <ul>
            result
    }
            if (hasPartialAboveExchange(input)) {
        );  
            List.of(rexBuilder.makeInputRef(intType, 0), rexBuilder.makeInputRef(intType, 1)),
        RelOptTable table = mockTable("test_index", "status_code", "size", "region_id", "endpoint_id", "user_id", "method_id", "cache_hit");  
     * (not RANDOM), so the split rule sees unpartitioned input and keeps a single SINGLE
    }
        RelNode filter = makeFilter(  
                """,
    }  
        );
     */
        assertFalse("PARTIAL sits directly above an ExchangeReducer (bad shape):\n" + explain(root), hasPartialAboveExchange(root));
        RexNode countOverEmpty = rexBuilder.makeOver(  
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        RelNode result = runPlanner(plan, singleShardContext());  
            fields.put(name, Map.of("type", "integer"));  
        RelNode plan = makeAggregate(filter, countStarCall(filter), sumCall(filter));  
 * compatible open source license.
    }
        LogicalProject project = LogicalProject.create(
     */
                      OpenSearchProject(status=[$0], size=[$1], viableBackends=[[mock-parquet]])
                        OpenSearchProject(status_code=[$0], size=[$1], viableBackends=[[mock-parquet]])  
            true,  
import org.apache.calcite.util.ImmutableBitSet;
 */  
        );
     * Comment out the gate in {@code OpenSearchAggregate.computeSelfCost} and this fails with the
                """,
            List.of(),  
 * this file be licensed under the Apache-2.0 license or a
                        OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=0, backends=[mock-lucene, mock-parquet], =($0, 200))], viableBackends=[[mock-parquet]])
            List.of("status_code", "size")
        }
            scan,  
            SqlStdOperatorTable.COUNT,
        RelOptTable table = mockTable("test_index", "status", "size");
     *   <li>Row count 100 + 4 {@code =} conjuncts: default 0.25 selectivity floors the estimate to
        assertPlanShape(  
            """
     * this exercises the gate that forbids it:  
            ImmutableList.of(),
    private static String explain(RelNode node) {
            List.of(rexBuilder.makeInputRef(intType, 0), rexBuilder.makeInputRef(intType, 1)),
        );  
        );  
    }
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 2)
        for (String name : List.of("status_code", "size", "region_id", "endpoint_id")) {
                  OpenSearchProject(status=[$0], size=[$1], viableBackends=[[mock-parquet]])
            """
    /**
        if (node instanceof OpenSearchAggregate aggregate) {  
        OpenSearchAggregate top = findTopAggregate(root);
import org.apache.calcite.rel.core.CorrelationId;
import org.apache.calcite.rel.logical.LogicalProject;
        RelNode result = runPlanner(plan, multiShardContext());
    }  
     * 1-shard variant of the same shape — must NOT split. The 1-shard scan declares SINGLETON
 */
        RelNode filter = makeFilter(  
    private static OpenSearchAggregate findTopAggregate(RelNode node) {
        }
            }
     */
            """  
     * a PARTIAL below it would be invalid. The rule emits a single SINGLE aggregate over the Sort.  
            false,
                    OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
                """,
import org.opensearch.analytics.planner.rel.AggregateMode;  
                          OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
            scan,
                  OpenSearchAggregate(group=[{0}], $f1=[SUM($1)], $f2=[SUM($2)], mode=[FINAL], viableBackends=[[mock-parquet]])  
                OpenSearchAggregate(group=[{0}], cnt=[SUM($1)], total_size=[SUM($2)], mode=[FINAL], viableBackends=[[mock-parquet]])
            RexWindowBounds.UNBOUNDED_FOLLOWING,
     * Same invariant for an aggregate whose PARTIAL state genuinely differs from its output —
            scan,
        // the split — that is what this test guards.
        // Aggregate must CONSUME the window column (avgCall reads slot 1 = `w`); otherwise field
            List.of("status_code")
        for (RelNode input : node.getInputs()) {  
import org.apache.calcite.plan.RelOptUtil;  
        RelNode plan = makeAggregate(filter, countStarCall(filter));
            result
     * such a Project at multi-shard stays SINGLE, no split.
import java.util.List;
    public void testAggregateOverJoin_2shard_doesNotSplit() {
        LogicalProject project = LogicalProject.create(
            makeAnd(
     * stay below the Exchange. Two ingredients make the bad coordinator-PARTIAL look cheaper, so
     * {@code where <4 eq-preds> | stats count() by status_code}, multi-shard — the PARTIAL must
     */
import org.apache.calcite.plan.RelOptTable;
     * coordinator (its {@code computeSelfCost} is infinite over non-SINGLETON input), so the
     * placed PARTIAL below the Exchange.
    }
        );  
        RelNode sort = makeSort(scan, 100);
            scan,
        RelNode result = runPlanner(plan, context);
     * 3-column PARTIAL state, so without the gate the coordinator-PARTIAL wins on cost. The gate  
        );  
    private static boolean hasPartialAboveExchange(RelNode node) {  
     */
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
        RexNode cond = rexBuilder.makeCall(
        assertEquals("top aggregate mode\n" + explain(root), expectedTopMode, top.getMode());
        RelNode result = runPlanner(plan, multiShardContext());  
        RelNode plan = makeAggregate(windowProject, ImmutableBitSet.of(0), avgCall(windowProject));
            if (found != null) {
    public void testFilterAndProjectBelowAggregate_2shard_splits() {  
     *       partial state above a shard-PARTIAL.</li>  
            filter,
            List.of(rexBuilder.makeInputRef(intType, 0), rexBuilder.makeInputRef(intType, 1)),  
    }  
     * A Project carrying a window ({@code RexOver}) DOES force a gather — its global frame needs
                makeEquals(1, SqlTypeName.INTEGER, 1024),
     * Filter — neither forces a gather — and still split over the partitioned scan beneath. Asserts  
 * SPDX-License-Identifier: Apache-2.0
        Map<String, Map<String, Object>> fields = new LinkedHashMap<>();
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);  
     */
        RelNode plan = makeAggregate(project, ImmutableBitSet.of(0), avgCall(project));
     * {@code avg(size) by status_code} decomposes to SUM + COUNT primitives at the shard, reduced  
        LogicalProject project = LogicalProject.create(
            OpenSearchAggregate found = findTopAggregate(input);
        RelOptTable table = mockTable("test_index", "status_code", "size", "region_id", "endpoint_id");  
        RelOptTable right = mockTable("test_index", "status", "size");
 *
                makeEquals(0, SqlTypeName.INTEGER, 200),  
            result
import java.util.Map;  
    /**  
                OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[SINGLE], viableBackends=[[mock-parquet]])
 * (RANDOM, i.e. multi-shard) input splits into PARTIAL/FINAL across an Exchange; SINGLETON  
     *       state (key + count), so shipping rows below a coordinator-PARTIAL beats shipping the
        );  
        RelNode scan = stubScan(table);
     * </ul>
            result  
 * The OpenSearch Contributors require contributions made to  
     * the walk doesn't false-positive on intermediate ops it's meant to see through.
            List.of("status", "size")
                makeEquals(0, SqlTypeName.INTEGER, 200),  
     * aggregate; a second aggregate adds nothing when the input is already gathered.  
        when(table.getRowCount()).thenReturn(100d);
        LogicalProject project = LogicalProject.create(  
import org.apache.calcite.rel.core.JoinRelType;  
            )
        RelNode scan = stubScan(table);
        PlannerContext context = buildContext("parquet", 2, fields);
        );  
                makeEquals(5, SqlTypeName.INTEGER, 1),
import org.apache.calcite.rel.type.RelDataType;  
    public void testAggregateOverPassthroughProjectOverFilter_2shard_splits() {  
                          OpenSearchFilter(condition=[AND(ANNOTATED_PREDICATE(id=0, backends=[mock-lucene, mock-parquet], =($0, 200)), ANNOTATED_PREDICATE(id=1, backends=[mock-lucene, mock-parquet], =($1, 1024)), ANNOTATED_PREDICATE(id=2, backends=[mock-lucene, mock-parquet], =($2, 3)), ANNOTATED_PREDICATE(id=3, backends=[mock-lucene, mock-parquet], =($3, 5)), ANNOTATED_PREDICATE(id=4, backends=[mock-lucene, mock-parquet], =($4, 7)), ANNOTATED_PREDICATE(id=5, backends=[mock-lucene, mock-parquet], =($5, 1)), ANNOTATED_PREDICATE(id=6, backends=[mock-lucene, mock-parquet], =($6, 1)))], viableBackends=[[mock-parquet]])
        RelNode scan = stubScan(table);
 * are involved — the rule emits exactly one alternative, so Volcano has nothing to cost-compare
                OpenSearchProject(status_code=[$0], avg_size=[ANNOTATED_PROJECT_EXPR(id=10, backends=[mock-parquet], CAST(ANNOTATED_PROJECT_EXPR(id=9, backends=[mock-parquet], /($1, $2))):INTEGER NOT NULL)], viableBackends=[[mock-parquet]])
     */
                      OpenSearchProject(status_code=[$0], viableBackends=[[mock-parquet]])
    }
        );
}
                OpenSearchAggregate(group=[{0}], cnt=[COUNT()], total_size=[SUM($1)], mode=[SINGLE], viableBackends=[[mock-parquet]])  
    /**  
        // Aggregate also SUM(size) ($1) so size stays in the below Project (else trimmed as dead).
            false,
            List.of(),
        RelNode join = LogicalJoin.create(stubScan(left), stubScan(right), List.of(), cond, Set.<CorrelationId>of(), JoinRelType.INNER);
        RelNode plan = makeAggregate(filter, countStarCall(filter), sumCall(filter));
 * Aggregate split decision — driven deterministically by partitioning, NOT cost.  
        RelOptTable table = mockTable("test_index", "status", "size");
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
        RelNode filter = makeFilter(project, makeEquals(0, SqlTypeName.INTEGER, 200));
    public void testSevenPredicateFilterBelowAvgByKey_2shard_partialStaysBelowExchange() {  
            List.of("status", "w")  
     */  
        }
        RelNode scan = stubScan(table);
        RelNode plan = makeAggregate(join, ImmutableBitSet.of(0), countStarCall(join));
        );
        // trimming drops the dead window and the aggregate legitimately splits. A live window blocks  
            """
    }
     * single node (global order can't run per-shard), so the aggregate's input is already gathered —
/*  
            List.of("status", "size")
        assertModeAndNoPartialAboveExchange(result, AggregateMode.SINGLE);
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
    /**
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);  
    }
                      OpenSearchAggregate(group=[{0}], agg#0=[SUM($1)], agg#1=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
import java.util.Set;
    }
import org.apache.calcite.rex.RexNode;
                """,  
                        OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
 * for placement. This mirrors how the Join/Union split rules choose their shape.  
        RelOptTable left = mockTable("test_index", "status", "size");  
        return false;
        RelNode result = runPlanner(plan, context);
        RelNode filter = makeFilter(project, makeEquals(0, SqlTypeName.INTEGER, 200));
    /**
                return true;
        }
     * (the bug shape). For SINGLE this confirms no split happened; for FINAL it confirms the split
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
    public void testFourPredicateFilterBelowCountByKey_2shard_partialStaysBelowExchange() {
import java.util.LinkedHashMap;
     * keeps the SUM/COUNT PARTIAL below the Exchange.
     *       1.0 row, erasing the coordinator-PARTIAL's cost margin over the shard-PARTIAL+ER.</li>  
        PlannerContext context = buildContext("parquet", 2, fields);
            """  
        assertPlanShape(
     * aggregate's input is already singleton — {@code childForcesGather} stops at the Join and the
        assertNotNull("expected an OpenSearchAggregate in the plan:\n" + explain(root), top);  
                    OpenSearchAggregate(group=[{0}], cnt=[COUNT()], total_size=[SUM($1)], mode=[PARTIAL], viableBackends=[[mock-parquet]])  
import org.apache.calcite.rel.RelNode;
                          OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
     * Aggregate over a Filter + Project chain (the shape PPL emits for
     * {@code childForcesGather} must walk PAST a pass-through Project (no {@code RexOver}) and a
            false  
        assertPlanShape(
            scan,
     * {@code | where ... | stats count() by k}) at multi-shard: the partitioned input splits  
                makeEquals(4, SqlTypeName.INTEGER, 7),
        return null;  
        assertPlanShape(  
            List.of(rexBuilder.makeInputRef(intType, 0), rexBuilder.makeInputRef(intType, 1)),
            RexWindowBounds.UNBOUNDED_PRECEDING,  
        RelOptTable table = mockTable("test_index", "status", "size");
     * {@code expectedTopMode}, and no PARTIAL aggregate sits directly above an ExchangeReducer  
import org.apache.calcite.rel.logical.LogicalJoin;
                makeEquals(2, SqlTypeName.INTEGER, 3),
        RelNode result = runPlanner(plan, multiShardContext());  
                      OpenSearchSort(sort0=[$0], dir0=[ASC], fetch=[100], viableBackends=[[mock-parquet]])
        }
import com.google.common.collect.ImmutableList;
        LogicalProject project = LogicalProject.create(
     * Aggregate over a collated Sort at multi-shard must NOT split. The Sort forces its input to a
                makeEquals(3, SqlTypeName.INTEGER, 5)  
        assertModeAndNoPartialAboveExchange(result, AggregateMode.SINGLE);
 * (1 shard / already gathered) input stays SINGLE. No row-count estimates or cost arithmetic
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
import org.apache.calcite.sql.type.SqlTypeName;
                    OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=0, backends=[mock-lucene, mock-parquet], =($0, 200))], viableBackends=[[mock-parquet]])
