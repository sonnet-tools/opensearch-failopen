                        makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(1, SqlTypeName.INTEGER, 200)),  
        OpenSearchTableScan.class  
        );
    /** The marked OpenSearchSort's trait set must carry the sort's collation. */
     * many-row so the limit is preserved (not dropped); the point here is one Sort, not two.
    public void testSortRuleStampsCollationOnTraitSet() {  
    private RelNode scalarAgg() {
                makeSort(
    }  
    /** Scalar agg, ORDER BY + fetch (non-empty collation): dropped — a 1-row relation is already
        return makeAggregate(  
    }
        assertTrue("Sort sits directly over the Aggregate", sort.getInput() instanceof OpenSearchAggregate);
            org.apache.calcite.util.ImmutableBitSet.of(),
 * compatible open source license.
    private PlannerContext defaultContext() {
            OpenSearchSort.class,
                    makeAggregate(
        // makeAggregate(input, aggCalls) defaults to group set {0} — a grouped aggregate.
        RelNode result = runPlanner(offsetLimit, defaultContext());
        assertNotNull("offset preserved", ((OpenSearchSort) result).offset);
import org.apache.calcite.rel.RelNode;
        }  
    /** Scalar agg, collation-less head N: dropped — LIMIT over one row is a no-op. */
    private void assertLimitDropped(RelNode result) {
        assertFalse("limit must be dropped (no OpenSearchSort)", result instanceof OpenSearchSort);  
            OpenSearchAggregate.class,  
     *  unbounded group count — otherwise filtering the group key {@code status} to a single  
        assertEquals("Trait set collation must match the sort's declared collation", osSort.getCollation(), collation);
    public void testOffsetOnScalarAggregatePreserved() {  
import org.opensearch.analytics.planner.rules.OpenSearchSortRule;
    }  
import org.opensearch.analytics.planner.rules.OpenSearchFilterRule;  
    }  
        );  
        hepPlanner.setRoot(logicalSort);
    public void testHeadOnGroupedAggregatePreservesFetch() {
        OpenSearchSort.class,
            types,
        List<Class<? extends org.opensearch.analytics.planner.rel.OpenSearchRelNode>> types,
        );
        assertTrue("scalar aggregate has empty group set", ((OpenSearchAggregate) result).getGroupSet().isEmpty());
            stubScan(mockTable("test_index", "status", "size")),
        List<Class<? extends org.opensearch.analytics.planner.rel.OpenSearchRelNode>> types = List.of(
 * with and without fetch (LIMIT), verifying viableBackends at each pipeline level.  
            makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200)),  
                ),
        // head 5 over system-cap 10000 over `stats sum(x) by k`.
    }  
        assertTrue("root must be an OpenSearchSort", result instanceof OpenSearchSort);
     * frontend's system size-cap {@code fetch=10000} — collapse to a SINGLE {@code OpenSearchSort}  
                ),
        assertFalse("no second stacked OpenSearchSort below", sort.getInput() instanceof OpenSearchSort);
        RelNode input = makeLimit(makeLimit(groupedAgg(), 10000), 5);  
    /** Grouped agg, head N: kept — the limit caps the number of groups (user-visible). */  
    public void testStackedLimitsOverGroupedAggregateMergeToOne() {
        assertSortPipeline(runPlanner(makeLimit(groupedAgg(), 5), defaultContext()), SORT_AGG_SCAN, 5);
            org.apache.calcite.rel.RelCollations.EMPTY,  
            ),
        );
    /** Sort(Agg(Filter(Scan))) with and without fetch — full OLAP pipeline.
import org.apache.calcite.plan.hep.HepProgramBuilder;
        assertSortPipeline(
        OpenSearchSort osSort = (OpenSearchSort) marked;
        } else {
        );  
            assertNotNull("Sort with limit must have non-null fetch", sort.fetch);
import org.apache.calcite.rel.RelCollationTraitDef;  
        HepPlanner hepPlanner = new HepPlanner(programBuilder.build());  
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
                    makeAggregate(
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
        logger.info("Plan:\n{}", RelOptUtil.toString(result));
            types,
 * SPDX-License-Identifier: Apache-2.0
            OpenSearchFilter.class,
            -1
    private void assertSortPipeline(
            types,  
                makeSort(
        // After QTF rewrite the wrapper sits at the root; the anchor Sort is its input.  
        RelNode offsetLimit = org.apache.calcite.rel.logical.LogicalSort.create(
import org.apache.calcite.rel.RelCollation;
        );  
     */  
        assertTrue("offset-bearing Sort must be preserved", result instanceof OpenSearchSort);  
            10
        if (fetch < 0) {
            scalarAgg(),
import org.opensearch.analytics.planner.rules.OpenSearchTableScanRule;
                    ),
    }
            rexBuilder.makeLiteral(1, typeFactory.createSqlType(SqlTypeName.INTEGER), true),
        RelNode filter = makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200));
        );  
            runPlanner(  
        OpenSearchAggregate.class,
            OpenSearchTableScan.class
            ),  
import java.util.Set;
import org.apache.calcite.rex.RexLiteral;
        RelNode marked = hepPlanner.findBestExp();
    public void testSortOnAggregateOnFilteredScan() {  
     *  The filter pins {@code size} (field 1, a non-group column) so the aggregate keeps an
        RelNode logicalSort = makeSort(
        assertPipelineViableBackends(result, types, Set.of(MockDataFusionBackend.NAME));
                    10  
        assertSortPipeline(
    }
    /**
     * carrying the tighter fetch (5), via {@code CoreRules.LIMIT_MERGE}. The grouped aggregate is
        RelNode result,  
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
    }
            OpenSearchFilter.class,
    }
            ),  
     *  the now-redundant Sort (covered by {@link #testSortFetchOnScalarAggregateDropped}). */
     *  Single-shard: SOURCE(SINGLETON) scan satisfies root RESULT(SINGLETON), aggregate  
        OpenSearchSort sort = (OpenSearchSort) result;
            runPlanner(
        assertNotNull("OpenSearchSort trait set must carry the sort's collation (rule must call .plus(sort.getCollation()))", collation);
     *  (Calcite SORT_REMOVE_REDUNDANT). */  
            rexBuilder.makeLiteral(5, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            OpenSearchSort.class,
        return makeAggregate(stubScan(mockTable("test_index", "status", "size")), sumCall());  
    private static final List<Class<? extends org.opensearch.analytics.planner.rel.OpenSearchRelNode>> SORT_AGG_SCAN = List.of(  
    /** Scalar agg, OFFSET (no collation): kept — OFFSET 1 over one row yields zero rows, so it is NOT a no-op. */
        assertEquals("merged fetch must be the tighter limit (5)", 5, RexLiteral.intValue(sort.fetch));  
                defaultContext()
     * Stacked collation-less limits over a grouped aggregate — a user {@code head 5} above the
    }  
 * Tests for sort rule: marking of Sort(Filter(Scan)) and Sort(Agg(Filter(Scan)))
import java.util.List;
                    -1  
            countStarCall()  
}
    }
/*  
     *  stays SINGLE (no split), no ER. Expect Sort → Agg → Filter → Scan.
            10
import org.opensearch.analytics.planner.rel.OpenSearchLateMaterialization;  
                defaultContext()
public class SortRuleTests extends BasePlannerRulesTests {
                    ),
 *
import org.apache.calcite.plan.hep.HepPlanner;  
import org.apache.calcite.sql.type.SqlTypeName;  
 * this file be licensed under the Apache-2.0 license or a
        RelCollation collation = osSort.getTraitSet().getTrait(RelCollationTraitDef.INSTANCE);  
        logger.info("Plan:\n{}", RelOptUtil.toString(result));
        programBuilder.addMatchOrder(HepMatchOrder.BOTTOM_UP);
     *  sorted and a fetch >= 1 cannot remove its single row, so the whole Sort is redundant
            runPlanner(  
                        sumCall()
    ) {  
        RelNode result = runPlanner(input, defaultContext());
        assertTrue("root must be the scalar OpenSearchAggregate", result instanceof OpenSearchAggregate);
     *  value would bound it to one row and {@code SORT_REMOVE_REDUNDANT} would correctly drop
        assertLimitDropped(runPlanner(makeSort(scalarAgg(), 5), defaultContext()));
import org.apache.calcite.plan.hep.HepMatchOrder;
        programBuilder.addRuleCollection(  
    public void testSortFetchOnScalarAggregateDropped() {
                defaultContext()
/**
    }  
import org.apache.calcite.plan.RelOptUtil;
        return buildContext("parquet", 1, intFields());
                        sumCall()
    }  
                        makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(1, SqlTypeName.INTEGER, 200)),  
        );
        int fetch
    public void testHeadOnScalarAggregateDropsLimit() {  
        assertSortPipeline(
    /** Sort(Filter(Scan)) with and without fetch. */  
        List<Class<? extends org.opensearch.analytics.planner.rel.OpenSearchRelNode>> types = List.of(  
import org.opensearch.analytics.planner.rel.OpenSearchSort;
        assertLimitDropped(runPlanner(makeLimit(scalarAgg(), 5), defaultContext()));
            OpenSearchTableScan.class  
package org.opensearch.analytics.planner;
 * The OpenSearch Contributors require contributions made to  
            assertNull("Sort without limit must have null fetch", sort.fetch);  
 */  
    public void testSortOnFilteredScan() {
    /** Asserts the planned pipeline has NO OpenSearchSort root and bottoms out at a scalar Aggregate. */  
            List.of(new OpenSearchTableScanRule(context), new OpenSearchFilterRule(context), new OpenSearchSortRule(context))
        HepProgramBuilder programBuilder = new HepProgramBuilder();
        assertSortPipeline(runPlanner(makeSort(filter, -1), defaultContext()), types, -1);  
            -1
        OpenSearchSort sort = (OpenSearchSort) (result instanceof OpenSearchLateMaterialization wrap ? wrap.getInput() : result);
        );
        PlannerContext context = defaultContext();
        logger.info("Plan:\n{}", RelOptUtil.toString(result));
        logger.info("Plan:\n{}", RelOptUtil.toString(result));
    private RelNode groupedAgg() {
        assertTrue("expected OpenSearchSort root, got " + marked.getClass().getSimpleName(), marked instanceof OpenSearchSort);
 */
                makeSort(makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200)), 10),  
    );
