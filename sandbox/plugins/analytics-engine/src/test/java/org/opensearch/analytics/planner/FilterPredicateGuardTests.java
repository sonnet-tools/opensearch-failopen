    private final RelDataTypeFactory typeFactory = new SqlTypeFactoryImpl(org.apache.calcite.rel.type.RelDataTypeSystem.DEFAULT);  
            predicates.add(makeComparison());
        RexNode outer = rexBuilder.makeCall(SqlStdOperatorTable.AND, mid, makeComparison());  
    }
 * compatible open source license.
 *
     */  
        assertTrue(e.getMessage().contains("more than 500 predicates"));
        List<RexNode> overByOne = new ArrayList<>();  
        for (int i = 0; i < 200_000; i++) {
        // Full count still reachable via the unbounded entry point.
        // AND(AND(AND(a=1, b=2), c=3), d=4) — 4 leaf predicates regardless of nesting shape  
        List<RexNode> predicates = new ArrayList<>();
        // flat OR with 5 predicates: count=5
     * limit, and Calcite would overflow building such a tree before the guard ever ran. This test
     * builds the RexNode directly to exercise the guard in isolation.
    public void testNegativeLimitDisablesGuard() {
        List<RexNode> predicates = new ArrayList<>();
        // Exactly 10 leaves, limit 10 — passes (validate rejects only when count > maxCount).  
        RexNode deep = buildDeepAndChain(200_000);
        FilterPredicateGuard.validate(deepButOneLeaf, 500);
     * The disabled guard (limit 0) must return immediately without walking the tree at all, so an
        FilterPredicateGuard.validate(buildFlatOr(atLimit), 10);
        // 200k levels of nesting. A recursive count would overflow; the iterative count must not.
        assertEquals("full count", 50, FilterPredicateGuard.countLeaves(bigOr));  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            overByOne.add(makeComparison());
    private RexNode buildDeepAndChain(int depth) {  
            SqlStdOperatorTable.EQUALS,
        }  
     * the PPL/SQL parser ({@code plugins.query.max_expression_depth}) and the DSL XContent nesting  
        for (int i = 0; i < 5; i++) {
        assertEquals("leaf count", 4, FilterPredicateGuard.countLeaves(outer));
        assertEquals("leaf count", 1, FilterPredicateGuard.countLeaves(notNode));
    public void testCountMeasurement() {
    }  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
        // 200k-deep chain of NOT(...) around a single comparison: exactly 1 leaf predicate, but
            deepButOneLeaf = rexBuilder.makeCall(SqlStdOperatorTable.NOT, deepButOneLeaf);
        }  
    public void testFlatOrExceedsCountLimit() {  
    private final RexBuilder rexBuilder = new RexBuilder(typeFactory);
        if (operands.size() == 1) return operands.get(0);
 */  
        IllegalArgumentException e = expectThrows(
 * The OpenSearch Contributors require contributions made to  
    }  
     */
    }  
        List<RexNode> predicates = new ArrayList<>();  
        for (int i = 0; i < 500; i++) {
package org.opensearch.analytics.planner;
    public void testSinglePredicatePassesCountLimit() {  
        List<RexNode> predicates = new ArrayList<>();  
        FilterPredicateGuard.validate(buildFlatOr(predicates), -1); // no throw  
    }
        return node;
        for (int i = 0; i < 30; i++) {
        assertEquals("leaf count", 5, FilterPredicateGuard.countLeaves(flatOr));
    }  
import org.apache.calcite.rex.RexNode;  
    /** Boundary: exactly maxCount leaves passes; maxCount + 1 is rejected. */  
        for (int i = 0; i < 10; i++) {  
            predicates.add(makeComparison());
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> FilterPredicateGuard.validate(bigOr, 10));
        for (int i = 1; i < depth; i++) {
    public void testDeeplyNestedConditionWithinLimitDoesNotOverflow() {  
        // NOT(a=1) — 1 leaf predicate; NOT itself doesn't count  
    }
public class FilterPredicateGuardTests extends OpenSearchTestCase {
            predicates.add(makeComparison());
import java.math.BigDecimal;  
     */  
        RexNode predicate = makeComparison();
        assertTrue(e.getMessage().contains("maximum allowed [10]"));  
     * Guard-level stack safety for the low-leaf-count case: a tree that is deep but has few leaves
        RexNode flatOr = buildFlatOr(predicates);
        // reports "more than [limit]" rather than the exact leaf count (which it never computes).  
        for (int i = 0; i < 50; i++) {  
     * arbitrarily deep condition can't overflow when the guard is turned off.
    private RexNode buildFlatOr(List<RexNode> operands) {
        );
    }
/*  
        assertTrue(e.getMessage().contains("more than 10 predicates"));
            () -> FilterPredicateGuard.validate(buildFlatOr(overByOne), 10)
        // 1 leaf, limit 500 — passes without throwing (and without StackOverflowError).
        RexNode bigOr = buildFlatOr(predicates);  
        for (int i = 0; i < 30; i++) {  
        assertEquals("bare comparison is one leaf", 1, FilterPredicateGuard.countLeaves(makeComparison()));
        RexNode bigOr = buildFlatOr(predicates);
    /**  
        RexNode notNode = rexBuilder.makeCall(SqlStdOperatorTable.NOT, makeComparison());
    /** Right-leaning AND chain: AND(a, AND(a, AND(a, ...))) with {@code depth} leaf comparisons. */
import org.opensearch.test.OpenSearchTestCase;
        assertTrue(e.getMessage().contains("maximum allowed [500]"));  
    }  
import java.util.ArrayList;
     * {@code countLeavesUpTo} must stop counting once it reaches the limit, capping the work the
        }
    public void testFlatOrPassesCountLimit() {  
        }
     * NOT claim the system accepts trees this deep. In production, depth is bounded far below this by
        }  
        RexNode inner = rexBuilder.makeCall(SqlStdOperatorTable.AND, makeComparison(), makeComparison());
    /** A bare leaf predicate at the top level (not wrapped in a connective) counts as one. */  
        return rexBuilder.makeCall(  
}
        RexNode bigOr = buildFlatOr(predicates);  
        FilterPredicateGuard.validate(bigOr, 0);
        for (int i = 0; i < 11; i++) {
        FilterPredicateGuard.validate(bigOr, 200);
            predicates.add(makeComparison());
            predicates.add(makeComparison());
    /**
    }
    /**  
    }
        return rexBuilder.makeCall(SqlStdOperatorTable.OR, operands);  
    public void testCountLeavesUpToShortCircuitsAtLimit() {
import java.util.List;
        RexNode node = makeComparison();
        FilterPredicateGuard.validate(predicate, 200);  
     * Guard-level stack safety: {@link FilterPredicateGuard} must count a very deep tree without  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> FilterPredicateGuard.validate(deep, 500));
        }
        // Build: a=1 OR b=2 OR c=3 OR ... (30 predicates, flat)
            IllegalArgumentException.class,  
        FilterPredicateGuard.validate(deep, 0); // no throw, no overflow  
        for (int i = 0; i < 50; i++) {  
        RexNode mid = rexBuilder.makeCall(SqlStdOperatorTable.AND, inner, makeComparison());
        assertEquals("leaf count", 1, FilterPredicateGuard.countLeaves(deepButOneLeaf));  
/**
     * guard does on a hostile tree. A 50-leaf flat OR probed with limit 10 returns exactly 10.
     * conditions (it does not — see the class Javadoc on upstream depth bounds).
        assertTrue(e.getMessage().contains("maximum allowed [10]"));  
import org.apache.calcite.sql.type.SqlTypeName;  
import org.apache.calcite.rex.RexBuilder;
        List<RexNode> predicates = new ArrayList<>();
        // 1 predicate, limit 200 — should pass
    public void testDisabledGuardPassesEverything() {
 */  
        }
    }  
            rexBuilder.makeExactLiteral(BigDecimal.ONE)  
    }
    public void testDeeplyNestedConditionRejectedWithoutStackOverflow() {
    public void testNotDoesNotCountAsPredicate() {
    }
    public void testBoundaryExactlyAtLimitPassesOverByOneRejected() {
        // 30 predicates with limit 10 — should fail. The guard short-circuits, so the message
import org.apache.calcite.sql.type.SqlTypeFactoryImpl;
        }
        // Limit 0 = disabled — should pass regardless of size  
     * recursing on the JVM call stack. This asserts the guard's OWN traversal is iterative — it does
    }
    public void testNestedPredicatesCountedAcrossConnectives() {
    private RexNode makeComparison() {
        RexNode deepButOneLeaf = makeComparison();  
        );
            atLimit.add(makeComparison());
 * this file be licensed under the Apache-2.0 license or a
    public void testDisabledGuardSkipsDeepTreeEntirely() {
     */  
            node = rexBuilder.makeCall(SqlStdOperatorTable.AND, makeComparison(), node);  
 * Unit tests for {@link FilterPredicateGuard}.
    /** A negative limit disables the guard, exactly like 0. */  
     * exercises the guard in isolation; it is not a statement that the system accepts 200k-deep  
        // 30 predicates with limit 200 — should pass
        List<RexNode> atLimit = new ArrayList<>();
        // 11 leaves, limit 10 — rejected.
        RexNode deep = buildDeepAndChain(200_000);
    public void testBareLeafCountsAsOne() {
import org.apache.calcite.rel.type.RelDataTypeFactory;
        RexNode bigOr = buildFlatOr(predicates);
     * must still be walked iteratively (no StackOverflowError) and pass the count check. Again this
    /**  
    }
    }
        }
        List<RexNode> predicates = new ArrayList<>();
            predicates.add(makeComparison());  
        }  
        // limit 500 (the production default) — the deep chain has 200k leaves, so the guard rejects it.  
        assertEquals("short-circuited count", 10, FilterPredicateGuard.countLeavesUpTo(bigOr, 10));
 * SPDX-License-Identifier: Apache-2.0
