        Map<String, Map<String, Object>> fields = new LinkedHashMap<>();
        RelNode plan = makeAggregate(filter, countStarCall(filter), sumCall(filter));
                OpenSearchAggregate(group=[{0}], cnt=[COUNT()], total_size=[SUM($1)], mode=[SINGLE], viableBackends=[[mock-parquet]])
    }
        // trimming drops the dead window and the aggregate legitimately splits. A live window blocks
     * 3-column PARTIAL state, so without the gate the coordinator-PARTIAL wins on cost. The gate
     * keeps the SUM/COUNT PARTIAL below the Exchange.
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
import java.util.List;
        assertPlanShape(
        }
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 2)
        // Aggregate also SUM(size) ($1) so size stays in the below Project (else trimmed as dead).
     * aggregate's input is already singleton — {@code childForcesGather} stops at the Join and the
package org.opensearch.analytics.planner;
    /**
        RelNode result = runPlanner(plan, context);
    }
            List.of(rexBuilder.makeInputRef(intType, 0), rexBuilder.makeInputRef(intType, 1)),
     * <ul>
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
 *
            false,
        RelOptTable left = mockTable("test_index", "status", "size");
import org.apache.calcite.rex.RexWindowBounds;
            scan,
        RelNode result = runPlanner(plan, multiShardContext());
import org.apache.calcite.rel.type.RelDataType;
        assertModeAndNoPartialAboveExchange(result, AggregateMode.SINGLE);
                        OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
 * <p>{@code OpenSearchAggregateSplitRule} reads the input's distribution trait: partitioned
            result
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            fields.put(name, Map.of("type", "integer"));
                          OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
    public void testAggregateOverCollatedSort_2shard_doesNotSplit() {
        when(table.getRowCount()).thenReturn(100d);
    public void testAggregateOverPassthroughProjectOverFilter_2shard_splits() {
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
    public void testSevenPredicateFilterBelowAvgByKey_2shard_partialStaysBelowExchange() {
        RelNode result = runPlanner(plan, multiShardContext());
        RelNode result = runPlanner(plan, context);
        RelNode plan = makeAggregate(filter, countStarCall(filter));
        RelOptTable table = mockTable("test_index", "status_code", "size", "region_id", "endpoint_id");
public class AggregateSplitCostTests extends PlanShapeTestBase {
                    OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=0, backends=[mock-lucene, mock-parquet], =($0, 200))], viableBackends=[[mock-parquet]])
    private static boolean hasPartialAboveExchange(RelNode node) {
 * compatible open source license.
        );
                          OpenSearchFilter(condition=[AND(ANNOTATED_PREDICATE(id=0, backends=[mock-lucene, mock-parquet], =($0, 200)), ANNOTATED_PREDICATE(id=1, backends=[mock-lucene, mock-parquet], =($1, 1024)), ANNOTATED_PREDICATE(id=2, backends=[mock-lucene, mock-parquet], =($2, 3)), ANNOTATED_PREDICATE(id=3, backends=[mock-lucene, mock-parquet], =($3, 5)), ANNOTATED_PREDICATE(id=4, backends=[mock-lucene, mock-parquet], =($4, 7)), ANNOTATED_PREDICATE(id=5, backends=[mock-lucene, mock-parquet], =($5, 1)), ANNOTATED_PREDICATE(id=6, backends=[mock-lucene, mock-parquet], =($6, 1)))], viableBackends=[[mock-parquet]])
    }
            scan,
    /**
    /**
    }
     *       state (key + count), so shipping rows below a coordinator-PARTIAL beats shipping the
        }
import java.util.Set;
}
import org.apache.calcite.rel.core.JoinRelType;
    /**
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        RelNode scan = stubScan(table);
        // HTTP-access-log shape: count() by status_code, filtered on 4 fields.
            List.of(),
                makeEquals(5, SqlTypeName.INTEGER, 1),
        when(table.getRowCount()).thenReturn(100d);
            RexWindowBounds.UNBOUNDED_PRECEDING,
     * this exercises the gate that forbids it:
 *
                OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[SINGLE], viableBackends=[[mock-parquet]])
        assertPlanShape(
            result
        RelNode scan = stubScan(table);
     */
        RelNode plan = makeAggregate(windowProject, ImmutableBitSet.of(0), avgCall(windowProject));
            ImmutableList.of(),
     * Aggregate over a Join at multi-shard must NOT split. A Join gathers both inputs to the
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        );
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
     */
            filter,
                          OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        RelNode filter = makeFilter(project, makeEquals(0, SqlTypeName.INTEGER, 200));
     * coordinator (its {@code computeSelfCost} is infinite over non-SINGLETON input), so the
    public void testFilterAndProjectBelowAggregate_1shard_doesNotSplit() {
        }
                makeEquals(0, SqlTypeName.INTEGER, 200),
        RelNode scan = stubScan(table);
            List.of("status", "size")
            if (hasPartialAboveExchange(input)) {
        return RelOptUtil.toString(node);
            return true;
 */
        assertModeAndNoPartialAboveExchange(result, AggregateMode.SINGLE);
                        OpenSearchProject(status_code=[$0], size=[$1], viableBackends=[[mock-parquet]])
            List.of(rexBuilder.makeInputRef(intType, 0), rexBuilder.makeInputRef(intType, 1)),
     * single node (global order can't run per-shard), so the aggregate's input is already gathered —
        );
        LogicalProject project = LogicalProject.create(
        RexNode countOverEmpty = rexBuilder.makeOver(
        RelNode scan = stubScan(table);
import static org.mockito.Mockito.when;
     */
        RelNode plan = makeAggregate(project, ImmutableBitSet.of(0), countStarCall(project));
        LogicalProject windowProject = LogicalProject.create(
            ImmutableList.of(),
    private static void assertModeAndNoPartialAboveExchange(RelNode root, AggregateMode expectedTopMode) {
            && aggregate.getMode() == AggregateMode.PARTIAL
            false,
        for (String name : List.of("status_code", "size", "region_id", "endpoint_id")) {
import java.util.Map;
    }
     * FINAL → coordinator-PARTIAL → ER bad shape.
     * Same invariant for an aggregate whose PARTIAL state genuinely differs from its output —
        // Aggregate also SUM(size) ($1) so size stays in the below Project (else trimmed as dead).
 * (RANDOM, i.e. multi-shard) input splits into PARTIAL/FINAL across an Exchange; SINGLETON
                OpenSearchAggregate(group=[{0}], cnt=[SUM($1)], total_size=[SUM($2)], mode=[FINAL], viableBackends=[[mock-parquet]])
        RelOptTable table = mockTable("test_index", "status_code", "size", "region_id", "endpoint_id", "user_id", "method_id", "cache_hit");
import org.apache.calcite.rel.RelNode;
        );
            List.of(),
        );
        RelNode sort = makeSort(scan, 100);
        RelNode scan = stubScan(table);
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        );
            )
        // Aggregate must CONSUME the window column (avgCall reads slot 1 = `w`); otherwise field
 * for placement. This mirrors how the Join/Union split rules choose their shape.
        );
            }
        RelNode filter = makeFilter(project, makeEquals(0, SqlTypeName.INTEGER, 200));
        RelOptTable table = mockTable("test_index", "status", "size");
            List.of(rexBuilder.makeInputRef(scan, 0), countOverEmpty),
            """
                      OpenSearchProject(status=[$0], size=[$1], viableBackends=[[mock-parquet]])
            OpenSearchAggregate found = findTopAggregate(input);
            }
 * Aggregate split decision — driven deterministically by partitioning, NOT cost.
        );
import org.apache.calcite.rel.core.CorrelationId;
     * the walk doesn't false-positive on intermediate ops it's meant to see through.
                return true;
        RelNode filter = makeFilter(project, makeEquals(0, SqlTypeName.INTEGER, 200));
        for (RelNode input : node.getInputs()) {
    /**
                    OpenSearchAggregate(group=[{0}], cnt=[COUNT()], total_size=[SUM($1)], mode=[PARTIAL], viableBackends=[[mock-parquet]])
     * a PARTIAL below it would be invalid. The rule emits a single SINGLE aggregate over the Sort.
                  OpenSearchSort(sort0=[$0], dir0=[ASC], fetch=[100], viableBackends=[[mock-parquet]])
/**
     * placed PARTIAL below the Exchange.
import com.google.common.collect.ImmutableList;
     * Aggregate over a Filter + Project chain (the shape PPL emits for
     */
            typeFactory.createSqlType(SqlTypeName.BIGINT),
     * Comment out the gate in {@code OpenSearchAggregate.computeSelfCost} and this fails with the
        for (String name : List.of("status_code", "size", "region_id", "endpoint_id", "user_id", "method_id", "cache_hit")) {
            List.of("status", "size")
        RelNode plan = makeAggregate(join, ImmutableBitSet.of(0), countStarCall(join));
        );
        RelOptTable table = mockTable("test_index", "status", "size");
        RelNode plan = makeAggregate(filter, countStarCall(filter), sumCall(filter));
        }
 * (1 shard / already gathered) input stays SINGLE. No row-count estimates or cost arithmetic
import org.apache.calcite.rel.logical.LogicalProject;
                makeEquals(2, SqlTypeName.INTEGER, 3),
    public void testAggregateOverJoin_2shard_doesNotSplit() {
        if (node instanceof OpenSearchAggregate aggregate
            """
     */
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;
            List.of(),
/*
        RexNode cond = rexBuilder.makeCall(
                """,
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
            makeAnd(
        LogicalProject project = LogicalProject.create(
        RelNode scan = stubScan(table);
        );
            true,
 * this file be licensed under the Apache-2.0 license or a
            List.of("status_code", "size")
                        OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=0, backends=[mock-lucene, mock-parquet], =($0, 200))], viableBackends=[[mock-parquet]])
    /**
            List.of(),
        );
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        }
                  OpenSearchAggregate(group=[{0}], $f1=[SUM($1)], $f2=[SUM($2)], mode=[FINAL], viableBackends=[[mock-parquet]])
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            return aggregate;
            && aggregate.getInput() instanceof OpenSearchExchangeReducer) {
    /**
        return false;
        RelOptTable table = mockTable("test_index", "status", "size");
        RelNode filter = makeFilter(
     * additively at the coordinator. 7 {@code =} conjuncts drive the row-count estimate to the 1.0
import org.apache.calcite.sql.type.SqlTypeName;
     * Aggregate over a collated Sort at multi-shard must NOT split. The Sort forces its input to a
     * into {@code Aggregate(FINAL) → ER → Aggregate(PARTIAL) → Project → Filter → Scan}.
    }
        );
            """
        assertPlanShape(
                makeEquals(1, SqlTypeName.INTEGER, 1024),
            List.of(rexBuilder.makeInputRef(intType, 0)),
     * Structural assertion shared by the no-split / split cases: the top OpenSearchAggregate carries
import org.apache.calcite.rel.logical.LogicalJoin;
            fields.put(name, Map.of("type", "integer"));
 * SPDX-License-Identifier: Apache-2.0
                makeEquals(6, SqlTypeName.INTEGER, 1)
     * SINGLETON input, so the walk must stop at it (not treat it as pass-through). Aggregate over
        );
            SqlStdOperatorTable.EQUALS,
        assertFalse("PARTIAL sits directly above an ExchangeReducer (bad shape):\n" + explain(root), hasPartialAboveExchange(root));
    private static String explain(RelNode node) {
        Map<String, Map<String, Object>> fields = new LinkedHashMap<>();
            )
        // the split — that is what this test guards.
     * 1-shard variant of the same shape — must NOT split. The 1-shard scan declares SINGLETON
                          OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
import org.apache.calcite.util.ImmutableBitSet;
            result
            if (found != null) {
        RelOptTable table = mockTable("test_index", "status", "size");
     * {@code expectedTopMode}, and no PARTIAL aggregate sits directly above an ExchangeReducer
                OpenSearchAggregate(group=[{0}], cnt=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
        RelNode result = runPlanner(plan, multiShardContext());
                makeEquals(1, SqlTypeName.INTEGER, 1024),
     * {@code childForcesGather} must walk PAST a pass-through Project (no {@code RexOver}) and a
 */
     *       1.0 row, erasing the coordinator-PARTIAL's cost margin over the shard-PARTIAL+ER.</li>
                makeEquals(2, SqlTypeName.INTEGER, 3),
                      OpenSearchAggregate(group=[{0}], agg#0=[SUM($1)], agg#1=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
     */
        RelNode scan = stubScan(table);
        RelNode result = runPlanner(plan, singleShardContext());
import org.apache.calcite.plan.RelOptTable;
            scan,
            List.of("status_code")
    public void testFilterAndProjectBelowAggregate_2shard_splits() {
    }
        RelNode filter = makeFilter(
            List.of("status", "size")
        PlannerContext context = buildContext("parquet", 2, fields);
    }
            false
     * stay below the Exchange. Two ingredients make the bad coordinator-PARTIAL look cheaper, so
            List.of(rexBuilder.makeInputRef(intType, 0), rexBuilder.makeInputRef(intType, 1)),
import org.opensearch.analytics.planner.rel.AggregateMode;
     * {@code | where ... | stats count() by k}) at multi-shard: the partitioned input splits
     * </ul>
            SqlStdOperatorTable.COUNT,
        );
        RelOptTable right = mockTable("test_index", "status", "size");
        RelNode result = runPlanner(plan, multiShardContext());
    /**
            RexWindowBounds.UNBOUNDED_FOLLOWING,
            List.of(),
        assertModeAndNoPartialAboveExchange(result, AggregateMode.FINAL);
        RelOptTable table = mockTable("test_index", "status", "size");
import org.apache.calcite.plan.RelOptUtil;
        assertEquals("top aggregate mode\n" + explain(root), expectedTopMode, top.getMode());
        }
            result
import java.util.LinkedHashMap;
 * are involved — the rule emits exactly one alternative, so Volcano has nothing to cost-compare
        return null;
        RelNode result = runPlanner(plan, multiShardContext());
    public void testFourPredicateFilterBelowCountByKey_2shard_partialStaysBelowExchange() {
            List.of(),
        LogicalProject project = LogicalProject.create(
        assertNotNull("expected an OpenSearchAggregate in the plan:\n" + explain(root), top);
                """,
     */
     * aggregate; a second aggregate adds nothing when the input is already gathered.
        RelNode plan = makeAggregate(project, ImmutableBitSet.of(0), avgCall(project));
                """,
        assertPlanShape(
            scan,
            filter,
            scan,
            """
    private static OpenSearchAggregate findTopAggregate(RelNode node) {
        RelNode plan = makeAggregate(sort, countStarCall(sort));
        LogicalProject project = LogicalProject.create(
            """
     * A Project carrying a window ({@code RexOver}) DOES force a gather — its global frame needs
 * The OpenSearch Contributors require contributions made to
     * {@code avg(size) by status_code} decomposes to SUM + COUNT primitives at the shard, reduced
        assertPlanShape(
                makeEquals(0, SqlTypeName.INTEGER, 200),
    }
                            OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        OpenSearchAggregate top = findTopAggregate(root);
    }
                """,
        );
     * (not RANDOM), so the split rule sees unpartitioned input and keeps a single SINGLE
    }
                return found;
     * floor; the narrowing Project (status_code, size) keeps the shipped row narrower than the
    /**
     * {@code where <4 eq-preds> | stats count() by status_code}, multi-shard — the PARTIAL must
                  OpenSearchProject(status=[$0], size=[$1], viableBackends=[[mock-parquet]])
                    OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
            scan,
        for (RelNode input : node.getInputs()) {
     * (the bug shape). For SINGLE this confirms no split happened; for FINAL it confirms the split
            List.of(),
        PlannerContext context = buildContext("parquet", 2, fields);
     *   <li>Narrowing Project (status_code only): the projected row is narrower than the PARTIAL
                OpenSearchProject(status_code=[$0], avg_size=[ANNOTATED_PROJECT_EXPR(id=10, backends=[mock-parquet], CAST(ANNOTATED_PROJECT_EXPR(id=9, backends=[mock-parquet], /($1, $2))):INTEGER NOT NULL)], viableBackends=[[mock-parquet]])
import org.apache.calcite.rex.RexNode;
        if (node instanceof OpenSearchAggregate aggregate) {
            List.of("status", "w")
            List.of(rexBuilder.makeInputRef(intType, 0), rexBuilder.makeInputRef(intType, 1)),
                """,
                makeEquals(3, SqlTypeName.INTEGER, 5),
        LogicalProject project = LogicalProject.create(
        RelNode join = LogicalJoin.create(stubScan(left), stubScan(right), List.of(), cond, Set.<CorrelationId>of(), JoinRelType.INNER);
     *       partial state above a shard-PARTIAL.</li>
    }
     */
    public void testAggregateOverWindowInProject_2shard_doesNotSplit() {
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
     * rule emits a single SINGLE aggregate.
     * Filter — neither forces a gather — and still split over the partitioned scan beneath. Asserts
     * such a Project at multi-shard stays SINGLE, no split.
                makeEquals(3, SqlTypeName.INTEGER, 5)
                      OpenSearchProject(status_code=[$0], viableBackends=[[mock-parquet]])
     *   <li>Row count 100 + 4 {@code =} conjuncts: default 0.25 selectivity floors the estimate to
                      OpenSearchSort(sort0=[$0], dir0=[ASC], fetch=[100], viableBackends=[[mock-parquet]])
                makeEquals(4, SqlTypeName.INTEGER, 7),
            true,
     */
                        OpenSearchFilter(condition=[AND(ANNOTATED_PREDICATE(id=0, backends=[mock-lucene, mock-parquet], =($0, 200)), ANNOTATED_PREDICATE(id=1, backends=[mock-lucene, mock-parquet], =($1, 1024)), ANNOTATED_PREDICATE(id=2, backends=[mock-lucene, mock-parquet], =($2, 3)), ANNOTATED_PREDICATE(id=3, backends=[mock-lucene, mock-parquet], =($3, 5)))], viableBackends=[[mock-parquet]])
            result
            makeAnd(
