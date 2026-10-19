import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
     * frontend's system size-cap {@code fetch=10000} — collapse to a SINGLE {@code OpenSearchSort}
    }
        OpenSearchTableScan.class
            org.apache.calcite.rel.RelCollations.EMPTY,
                    makeAggregate(
        OpenSearchAggregate.class,
     *  Single-shard: SOURCE(SINGLETON) scan satisfies root RESULT(SINGLETON), aggregate
            OpenSearchTableScan.class
 * Tests for sort rule: marking of Sort(Filter(Scan)) and Sort(Agg(Filter(Scan)))
    }
    private static final List<Class<? extends org.opensearch.analytics.planner.rel.OpenSearchRelNode>> SORT_AGG_SCAN = List.of(
    }
import org.apache.calcite.rel.RelCollationTraitDef;
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
        } else {
     */
    }
        // head 5 over system-cap 10000 over `stats sum(x) by k`.
    private RelNode scalarAgg() {
        assertSortPipeline(runPlanner(makeSort(filter, -1), defaultContext()), types, -1);
        assertTrue("root must be an OpenSearchSort", result instanceof OpenSearchSort);
        // After QTF rewrite the wrapper sits at the root; the anchor Sort is its input.
/**
 */
     *  (Calcite SORT_REMOVE_REDUNDANT). */
        RelNode marked = hepPlanner.findBestExp();
        );
                makeSort(
    /** Scalar agg, OFFSET (no collation): kept — OFFSET 1 over one row yields zero rows, so it is NOT a no-op. */
import org.opensearch.analytics.planner.rel.OpenSearchSort;
                ),
import java.util.List;
    /** Sort(Filter(Scan)) with and without fetch. */
    public void testSortFetchOnScalarAggregateDropped() {
        hepPlanner.setRoot(logicalSort);
import org.apache.calcite.plan.RelOptUtil;
    /** Scalar agg, ORDER BY + fetch (non-empty collation): dropped — a 1-row relation is already
                    10
        );
        assertLimitDropped(runPlanner(makeSort(scalarAgg(), 5), defaultContext()));
}
        OpenSearchSort sort = (OpenSearchSort) result;
    private void assertLimitDropped(RelNode result) {
     *  unbounded group count — otherwise filtering the group key {@code status} to a single
        assertLimitDropped(runPlanner(makeLimit(scalarAgg(), 5), defaultContext()));
     *  sorted and a fetch >= 1 cannot remove its single row, so the whole Sort is redundant
                defaultContext()
import org.opensearch.analytics.planner.rules.OpenSearchFilterRule;
            OpenSearchAggregate.class,
    public void testSortOnFilteredScan() {
     *  value would bound it to one row and {@code SORT_REMOVE_REDUNDANT} would correctly drop
                    makeAggregate(
import org.apache.calcite.rel.RelCollation;
     * Stacked collation-less limits over a grouped aggregate — a user {@code head 5} above the
    public void testSortRuleStampsCollationOnTraitSet() {
    }
            -1
            assertNull("Sort without limit must have null fetch", sort.fetch);
                        makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(1, SqlTypeName.INTEGER, 200)),
                        sumCall()
 *
    }
    }
        );
    public void testHeadOnGroupedAggregatePreservesFetch() {
            stubScan(mockTable("test_index", "status", "size")),
        assertPipelineViableBackends(result, types, Set.of(MockDataFusionBackend.NAME));
                defaultContext()
import java.util.Set;
    /** Asserts the planned pipeline has NO OpenSearchSort root and bottoms out at a scalar Aggregate. */
    /**
            OpenSearchFilter.class,
        assertTrue("scalar aggregate has empty group set", ((OpenSearchAggregate) result).getGroupSet().isEmpty());
 * with and without fetch (LIMIT), verifying viableBackends at each pipeline level.
 * compatible open source license.
    /** Grouped agg, head N: kept — the limit caps the number of groups (user-visible). */
            10
        assertNotNull("OpenSearchSort trait set must carry the sort's collation (rule must call .plus(sort.getCollation()))", collation);
            ),
                        sumCall()
        assertSortPipeline(
        if (fetch < 0) {
     *  The filter pins {@code size} (field 1, a non-group column) so the aggregate keeps an
                makeSort(
     * many-row so the limit is preserved (not dropped); the point here is one Sort, not two.
            ),
            OpenSearchSort.class,
            types,
                    -1
    public void testStackedLimitsOverGroupedAggregateMergeToOne() {
        assertFalse("no second stacked OpenSearchSort below", sort.getInput() instanceof OpenSearchSort);
        return makeAggregate(
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
    );
 */
        assertEquals("merged fetch must be the tighter limit (5)", 5, RexLiteral.intValue(sort.fetch));
        List<Class<? extends org.opensearch.analytics.planner.rel.OpenSearchRelNode>> types,
        );
    }
        HepPlanner hepPlanner = new HepPlanner(programBuilder.build());
    private void assertSortPipeline(
import org.apache.calcite.plan.hep.HepPlanner;
        programBuilder.addRuleCollection(
 * this file be licensed under the Apache-2.0 license or a
public class SortRuleTests extends BasePlannerRulesTests {
            rexBuilder.makeLiteral(5, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        List<Class<? extends org.opensearch.analytics.planner.rel.OpenSearchRelNode>> types = List.of(
    public void testOffsetOnScalarAggregatePreserved() {
 * SPDX-License-Identifier: Apache-2.0
            runPlanner(
            rexBuilder.makeLiteral(1, typeFactory.createSqlType(SqlTypeName.INTEGER), true),
        logger.info("Plan:\n{}", RelOptUtil.toString(result));
        );
    ) {
 * The OpenSearch Contributors require contributions made to
        assertSortPipeline(
    /** Sort(Agg(Filter(Scan))) with and without fetch — full OLAP pipeline.
        RelNode filter = makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200));
        assertTrue("expected OpenSearchSort root, got " + marked.getClass().getSimpleName(), marked instanceof OpenSearchSort);
        assertNotNull("offset preserved", ((OpenSearchSort) result).offset);
        programBuilder.addMatchOrder(HepMatchOrder.BOTTOM_UP);
        );
import org.apache.calcite.rel.RelNode;
        return makeAggregate(stubScan(mockTable("test_index", "status", "size")), sumCall());
            runPlanner(
            countStarCall()
            scalarAgg(),
    /** The marked OpenSearchSort's trait set must carry the sort's collation. */
                    ),
        RelNode input = makeLimit(makeLimit(groupedAgg(), 10000), 5);
        assertTrue("root must be the scalar OpenSearchAggregate", result instanceof OpenSearchAggregate);
    }
import org.apache.calcite.plan.hep.HepProgramBuilder;
                    ),
        assertTrue("Sort sits directly over the Aggregate", sort.getInput() instanceof OpenSearchAggregate);
        logger.info("Plan:\n{}", RelOptUtil.toString(result));
            OpenSearchFilter.class,
import org.opensearch.analytics.planner.rules.OpenSearchSortRule;
        List<Class<? extends org.opensearch.analytics.planner.rel.OpenSearchRelNode>> types = List.of(
    private RelNode groupedAgg() {
import org.apache.calcite.sql.type.SqlTypeName;
                makeSort(makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200)), 10),
    private PlannerContext defaultContext() {
        assertEquals("Trait set collation must match the sort's declared collation", osSort.getCollation(), collation);
        RelNode result = runPlanner(offsetLimit, defaultContext());
        assertSortPipeline(runPlanner(makeLimit(groupedAgg(), 5), defaultContext()), SORT_AGG_SCAN, 5);
    public void testHeadOnScalarAggregateDropsLimit() {
        HepProgramBuilder programBuilder = new HepProgramBuilder();
            OpenSearchSort.class,
import org.apache.calcite.rex.RexLiteral;
        RelNode logicalSort = makeSort(
            assertNotNull("Sort with limit must have non-null fetch", sort.fetch);
        assertSortPipeline(
        // makeAggregate(input, aggCalls) defaults to group set {0} — a grouped aggregate.
        RelCollation collation = osSort.getTraitSet().getTrait(RelCollationTraitDef.INSTANCE);
    }
                        makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(1, SqlTypeName.INTEGER, 200)),
        assertFalse("limit must be dropped (no OpenSearchSort)", result instanceof OpenSearchSort);
/*
            makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200)),
import org.opensearch.analytics.planner.rules.OpenSearchTableScanRule;
                defaultContext()
        OpenSearchSort osSort = (OpenSearchSort) marked;
            OpenSearchTableScan.class
    }
        OpenSearchSort sort = (OpenSearchSort) (result instanceof OpenSearchLateMaterialization wrap ? wrap.getInput() : result);
            ),
            types,
    }
    public void testSortOnAggregateOnFilteredScan() {
            10
     * carrying the tighter fetch (5), via {@code CoreRules.LIMIT_MERGE}. The grouped aggregate is
        );
                ),
        }
        int fetch
            types,
        OpenSearchSort.class,
    /** Scalar agg, collation-less head N: dropped — LIMIT over one row is a no-op. */
        );
import org.opensearch.analytics.planner.rel.OpenSearchLateMaterialization;
        logger.info("Plan:\n{}", RelOptUtil.toString(result));
        );
        RelNode offsetLimit = org.apache.calcite.rel.logical.LogicalSort.create(
            -1
     *  stays SINGLE (no split), no ER. Expect Sort → Agg → Filter → Scan.
package org.opensearch.analytics.planner;
import org.apache.calcite.plan.hep.HepMatchOrder;
        return buildContext("parquet", 1, intFields());
     *  the now-redundant Sort (covered by {@link #testSortFetchOnScalarAggregateDropped}). */
        logger.info("Plan:\n{}", RelOptUtil.toString(result));
            runPlanner(
        RelNode result,
        PlannerContext context = defaultContext();
        assertTrue("offset-bearing Sort must be preserved", result instanceof OpenSearchSort);
            List.of(new OpenSearchTableScanRule(context), new OpenSearchFilterRule(context), new OpenSearchSortRule(context))
        RelNode result = runPlanner(input, defaultContext());
            org.apache.calcite.util.ImmutableBitSet.of(),
    }
