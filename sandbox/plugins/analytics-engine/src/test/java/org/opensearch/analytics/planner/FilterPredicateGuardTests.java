     * limit, and Calcite would overflow building such a tree before the guard ever ran. This test
            atLimit.add(makeComparison());
import java.util.ArrayList;
        }
 */
        // limit 500 (the production default) — the deep chain has 200k leaves, so the guard rejects it.
        List<RexNode> predicates = new ArrayList<>();
    /** A bare leaf predicate at the top level (not wrapped in a connective) counts as one. */
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
        }
        }
        FilterPredicateGuard.validate(buildFlatOr(predicates), -1); // no throw
        assertEquals("leaf count", 4, FilterPredicateGuard.countLeaves(outer));
            SqlStdOperatorTable.EQUALS,
import java.util.List;
        // 30 predicates with limit 10 — should fail. The guard short-circuits, so the message
    }
        // NOT(a=1) — 1 leaf predicate; NOT itself doesn't count
     * the PPL/SQL parser ({@code plugins.query.max_expression_depth}) and the DSL XContent nesting
        List<RexNode> overByOne = new ArrayList<>();
        List<RexNode> atLimit = new ArrayList<>();
    }
import org.apache.calcite.rel.type.RelDataTypeFactory;
    }
    public void testBoundaryExactlyAtLimitPassesOverByOneRejected() {
}
 * Unit tests for {@link FilterPredicateGuard}.
        for (int i = 0; i < 5; i++) {
        RexNode inner = rexBuilder.makeCall(SqlStdOperatorTable.AND, makeComparison(), makeComparison());
        assertEquals("leaf count", 5, FilterPredicateGuard.countLeaves(flatOr));
     * exercises the guard in isolation; it is not a statement that the system accepts 200k-deep
        assertTrue(e.getMessage().contains("maximum allowed [10]"));
        FilterPredicateGuard.validate(deep, 0); // no throw, no overflow
        assertEquals("leaf count", 1, FilterPredicateGuard.countLeaves(deepButOneLeaf));
    }
package org.opensearch.analytics.planner;
        assertTrue(e.getMessage().contains("maximum allowed [10]"));
    /**
    public void testDeeplyNestedConditionRejectedWithoutStackOverflow() {
    public void testDeeplyNestedConditionWithinLimitDoesNotOverflow() {
    /** A negative limit disables the guard, exactly like 0. */
 *
        List<RexNode> predicates = new ArrayList<>();
        FilterPredicateGuard.validate(bigOr, 0);
        }
        return rexBuilder.makeCall(
        for (int i = 0; i < 10; i++) {
        FilterPredicateGuard.validate(buildFlatOr(atLimit), 10);
        for (int i = 0; i < 200_000; i++) {
            overByOne.add(makeComparison());
        assertTrue(e.getMessage().contains("maximum allowed [500]"));
        for (int i = 0; i < 50; i++) {
        // AND(AND(AND(a=1, b=2), c=3), d=4) — 4 leaf predicates regardless of nesting shape
    public void testSinglePredicatePassesCountLimit() {
     * builds the RexNode directly to exercise the guard in isolation.
    /**
        }
    }
        // 11 leaves, limit 10 — rejected.
    }
        for (int i = 0; i < 30; i++) {
     * Guard-level stack safety for the low-leaf-count case: a tree that is deep but has few leaves
        if (operands.size() == 1) return operands.get(0);
        }
        // Build: a=1 OR b=2 OR c=3 OR ... (30 predicates, flat)
        RexNode deep = buildDeepAndChain(200_000);
        RexNode notNode = rexBuilder.makeCall(SqlStdOperatorTable.NOT, makeComparison());
import java.math.BigDecimal;
    }
        FilterPredicateGuard.validate(predicate, 200);
     * recursing on the JVM call stack. This asserts the guard's OWN traversal is iterative — it does
        );
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> FilterPredicateGuard.validate(bigOr, 10));
 * SPDX-License-Identifier: Apache-2.0
     * arbitrarily deep condition can't overflow when the guard is turned off.
    private RexNode buildFlatOr(List<RexNode> operands) {
    }
    }
            predicates.add(makeComparison());
     * The disabled guard (limit 0) must return immediately without walking the tree at all, so an
        RexNode outer = rexBuilder.makeCall(SqlStdOperatorTable.AND, mid, makeComparison());
    }
        }
            predicates.add(makeComparison());
        return rexBuilder.makeCall(SqlStdOperatorTable.OR, operands);
public class FilterPredicateGuardTests extends OpenSearchTestCase {
    public void testNegativeLimitDisablesGuard() {
    private RexNode buildDeepAndChain(int depth) {
    }
    }
/*
        assertTrue(e.getMessage().contains("more than 10 predicates"));
 * this file be licensed under the Apache-2.0 license or a
     * conditions (it does not — see the class Javadoc on upstream depth bounds).
        RexNode node = makeComparison();
        }
    }
            predicates.add(makeComparison());
import org.apache.calcite.sql.type.SqlTypeName;
        // 200k levels of nesting. A recursive count would overflow; the iterative count must not.
    /**
        // Full count still reachable via the unbounded entry point.
/**
        for (int i = 0; i < 500; i++) {
        List<RexNode> predicates = new ArrayList<>();
    }
        List<RexNode> predicates = new ArrayList<>();
     */
     * NOT claim the system accepts trees this deep. In production, depth is bounded far below this by
        RexNode mid = rexBuilder.makeCall(SqlStdOperatorTable.AND, inner, makeComparison());
        RexNode predicate = makeComparison();
            predicates.add(makeComparison());
        RexNode deep = buildDeepAndChain(200_000);
        RexNode flatOr = buildFlatOr(predicates);
        // 1 predicate, limit 200 — should pass
        }
    public void testBareLeafCountsAsOne() {
 */
     * guard does on a hostile tree. A 50-leaf flat OR probed with limit 10 returns exactly 10.
        for (int i = 1; i < depth; i++) {
 * compatible open source license.
    public void testDisabledGuardSkipsDeepTreeEntirely() {
        for (int i = 0; i < 11; i++) {
    public void testFlatOrExceedsCountLimit() {
    }
            () -> FilterPredicateGuard.validate(buildFlatOr(overByOne), 10)
    }
            node = rexBuilder.makeCall(SqlStdOperatorTable.AND, makeComparison(), node);
            deepButOneLeaf = rexBuilder.makeCall(SqlStdOperatorTable.NOT, deepButOneLeaf);
    /**
        // 1 leaf, limit 500 — passes without throwing (and without StackOverflowError).
    public void testNotDoesNotCountAsPredicate() {
            predicates.add(makeComparison());
        return node;
        RexNode deepButOneLeaf = makeComparison();
        assertEquals("full count", 50, FilterPredicateGuard.countLeaves(bigOr));
            IllegalArgumentException.class,
     * Guard-level stack safety: {@link FilterPredicateGuard} must count a very deep tree without
import org.apache.calcite.sql.type.SqlTypeFactoryImpl;
        List<RexNode> predicates = new ArrayList<>();
        // flat OR with 5 predicates: count=5
import org.apache.calcite.rex.RexBuilder;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> FilterPredicateGuard.validate(deep, 500));
        RexNode bigOr = buildFlatOr(predicates);
        List<RexNode> predicates = new ArrayList<>();
            predicates.add(makeComparison());
        // 200k-deep chain of NOT(...) around a single comparison: exactly 1 leaf predicate, but
    private final RelDataTypeFactory typeFactory = new SqlTypeFactoryImpl(org.apache.calcite.rel.type.RelDataTypeSystem.DEFAULT);
        );
     */
    public void testCountLeavesUpToShortCircuitsAtLimit() {
    public void testNestedPredicatesCountedAcrossConnectives() {
        FilterPredicateGuard.validate(deepButOneLeaf, 500);
        assertEquals("short-circuited count", 10, FilterPredicateGuard.countLeavesUpTo(bigOr, 10));
        IllegalArgumentException e = expectThrows(
import org.opensearch.test.OpenSearchTestCase;
     * must still be walked iteratively (no StackOverflowError) and pass the count check. Again this
     * {@code countLeavesUpTo} must stop counting once it reaches the limit, capping the work the
        RexNode bigOr = buildFlatOr(predicates);
    }
    public void testFlatOrPassesCountLimit() {
        // 30 predicates with limit 200 — should pass
        // reports "more than [limit]" rather than the exact leaf count (which it never computes).
        for (int i = 0; i < 30; i++) {
     */
    private RexNode makeComparison() {
        // Exactly 10 leaves, limit 10 — passes (validate rejects only when count > maxCount).
        assertEquals("bare comparison is one leaf", 1, FilterPredicateGuard.countLeaves(makeComparison()));
    /** Boundary: exactly maxCount leaves passes; maxCount + 1 is rejected. */
            rexBuilder.makeExactLiteral(BigDecimal.ONE)
        }
        // Limit 0 = disabled — should pass regardless of size
    /** Right-leaning AND chain: AND(a, AND(a, AND(a, ...))) with {@code depth} leaf comparisons. */
        assertEquals("leaf count", 1, FilterPredicateGuard.countLeaves(notNode));
    private final RexBuilder rexBuilder = new RexBuilder(typeFactory);
    public void testCountMeasurement() {
        assertTrue(e.getMessage().contains("more than 500 predicates"));
        for (int i = 0; i < 50; i++) {
        RexNode bigOr = buildFlatOr(predicates);
import org.apache.calcite.rex.RexNode;
        FilterPredicateGuard.validate(bigOr, 200);
     */
 * The OpenSearch Contributors require contributions made to
        RexNode bigOr = buildFlatOr(predicates);
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
    public void testDisabledGuardPassesEverything() {
