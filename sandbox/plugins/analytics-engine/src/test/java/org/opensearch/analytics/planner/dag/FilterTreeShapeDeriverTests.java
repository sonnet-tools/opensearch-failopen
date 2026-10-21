        RexNode notNode = rexBuilder.makeCall(SqlStdOperatorTable.NOT, andNode);
        RexNode nativePred = annotated(DRIVING);
        RexNode nativePred = annotated(DRIVING);
        FilterTreeShape shape = FilterTreeShapeDeriver.derive(filter, DRIVING);
        OpenSearchFilter filter = buildFilter(notNode);
/*
        FilterTreeShape shape = FilterTreeShapeDeriver.derive(filter, DRIVING);
    }
        RexNode andNode = rexBuilder.makeCall(SqlStdOperatorTable.AND, nativePred, orNode);
    }
        RexNode andNode = rexBuilder.makeCall(SqlStdOperatorTable.AND, correctness, perf);
        assertEquals("No delegation should return PLAIN", FilterTreeShape.NO_DELEGATION, shape);
        // Single native predicate — no delegation
        return (AnnotatedPredicate) dualViable.narrowTo(DRIVING);
        // NOT(delegated) — single correctness-delegated predicate, combined into one
        assertEquals(FilterTreeShape.CONJUNCTIVE, shape);
        RexNode andNode = rexBuilder.makeCall(SqlStdOperatorTable.AND, nativePred, delegated);
        RexNode correctness = annotated(ACCEPTING);
        FilterTreeShape shape = FilterTreeShapeDeriver.derive(filter, DRIVING);
    }
        // expression (BoolQuery with must_not). No tree evaluator needed post-combine.
        );
        RexNode delegated1 = annotated(ACCEPTING);
    public void testBareNotOfDelegated() {
    /** Creates a dual-viable predicate narrowed to the driving backend with perf-delegation to accepting. */
        OpenSearchFilter filter = buildFilter(orNode);
        RelDataType boolType = typeFactory.createJavaType(boolean.class);
        RexNode orNode = rexBuilder.makeCall(SqlStdOperatorTable.OR, nativePred, delegated);
        RexNode nativePred = annotated(DRIVING);
        RexNode delegated = annotated(ACCEPTING);
    // (The label must match what the combiner emits; a mismatch here is what caused the all-docs bug.)
 * Unit tests for {@link FilterTreeShapeDeriver}.
    public void testNotOfPerfDelegated() {
        // AND(correctness-delegated, perf-delegated) — perf combines under AND → CONJUNCTIVE
    }
        FilterTreeShape shape = FilterTreeShapeDeriver.derive(filter, DRIVING);
        AnnotatedPredicate dualViable = new AnnotatedPredicate(boolType, literal, List.of(DRIVING, ACCEPTING), 0);
        RexNode andNode = rexBuilder.makeCall(SqlStdOperatorTable.AND, nativePred, delegated);
        return new AnnotatedPredicate(boolType, literal, List.of(backendId), 0);
        OpenSearchFilter filter = buildFilter(andNode);
        OpenSearchFilter filter = buildFilter(orNode);
    }
    }
            List.of(DRIVING)
 * SPDX-License-Identifier: Apache-2.0
        // OR mixing delegated and native → MIXED_BOOLEAN
        RexNode delegated2 = annotated(ACCEPTING);
    public void testOrWithOnlyDelegated() {
        OpenSearchFilter filter = buildFilter(nativePred);
    public void testOrWithDelegatedAndNative() {
        RexNode correctness = annotated(ACCEPTING);
        RexNode delegated = annotated(ACCEPTING);
    private static final String DRIVING = "datafusion";
        RexNode notNode = rexBuilder.makeCall(SqlStdOperatorTable.NOT, delegated);
        assertEquals(FilterTreeShape.CONJUNCTIVE, shape);
 * this file be licensed under the Apache-2.0 license or a
    public void testMultipleDelegatedUnderAnd() {
        RexNode nativePred = annotated(DRIVING);
    // ---- Helpers ----
    private static final String ACCEPTING = "lucene";
 */
import org.apache.calcite.plan.RelTraitSet;
    }
        OpenSearchFilter filter = buildFilter(notNode);
    // FragmentConversionDriverTests#testNotEqualsStaysNative, NOT(EQUALS) → 0 delegated expressions.)
        RexNode delegated = annotated(ACCEPTING);
    }
        // OR(delegated, delegated) — all same-backend, combined into one expression.
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, shape);
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
        RexNode nativePred = annotated(DRIVING);
            condition,
    // NOT(dual-equality) is not delegated — it stays native → NO_DELEGATION. (Combiner counterpart:
    private AnnotatedPredicate perfDelegated() {
import org.apache.calcite.rex.RexNode;
        FilterTreeShape shape = FilterTreeShapeDeriver.derive(filter, DRIVING);
    public void testSingleDelegatedPredicate() {
    // into ONE Lucene shipment. The shape is then a single delegated leaf → label = CONJUNCTIVE.
package org.opensearch.analytics.planner.dag;
            RelTraitSet.createEmpty(),
import org.opensearch.analytics.planner.BasePlannerRulesTests;
import org.opensearch.analytics.spi.FilterTreeShape;
        assertEquals(FilterTreeShape.CONJUNCTIVE, shape);
        RexNode literal = rexBuilder.makeLiteral(true);
        OpenSearchFilter filter = buildFilter(andNode);
    // Delegated OR Dual: the Dual leaf can't stay performance-based under OR (perf delegation is
import org.apache.calcite.rel.type.RelDataType;
        // No tree evaluator needed post-combine.
    public void testOrWithCorrectnessAndPerfDelegated() {
    private AnnotatedPredicate annotated(String backendId) {
        RexNode delegated1 = annotated(ACCEPTING);
        RexNode delegated2 = annotated(ACCEPTING);
import java.util.List;
        OpenSearchFilter filter = buildFilter(andNode);
    // AND-only in the data node), so it's demoted to correctness and fused with the Delegated leaf
        RelDataType boolType = typeFactory.createJavaType(boolean.class);
public class FilterTreeShapeDeriverTests extends BasePlannerRulesTests {
        // Single delegated predicate under implicit AND
    public void testAndWithCorrectnessAndPerfDelegated() {
        RexNode literal = rexBuilder.makeLiteral(true);
        RexNode nativePred = annotated(DRIVING);
    }
        FilterTreeShape shape = FilterTreeShapeDeriver.derive(filter, DRIVING);
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        FilterTreeShape shape = FilterTreeShapeDeriver.derive(filter, DRIVING);
    public void testNotWithDelegated() {
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, shape);
        assertEquals(FilterTreeShape.CONJUNCTIVE, shape);
    }
        assertEquals(FilterTreeShape.CONJUNCTIVE, shape);
        RexNode perf = perfDelegated();
        // NOT wrapping delegated + native → MIXED_BOOLEAN
            stubScan(mockTable("test_index", "col")),
        FilterTreeShape shape = FilterTreeShapeDeriver.derive(filter, DRIVING);
        RexNode perf = perfDelegated();
/**
        RexNode perf = perfDelegated();
        RexNode andNode = rexBuilder.makeCall(SqlStdOperatorTable.AND, nativePred, delegated1, delegated2);
 *
        RexNode orNode = rexBuilder.makeCall(SqlStdOperatorTable.OR, correctness, perf);
import org.opensearch.analytics.planner.rel.AnnotatedPredicate;
    private OpenSearchFilter buildFilter(RexNode condition) {
    public void testNoDelegation() {
        RexNode orNode = rexBuilder.makeCall(SqlStdOperatorTable.OR, delegated1, delegated2);
        OpenSearchFilter filter = buildFilter(andNode);
 */
        FilterTreeShape shape = FilterTreeShapeDeriver.derive(filter, DRIVING);
        // Multiple delegated predicates under AND — still SINGLE_AND
}
        return new OpenSearchFilter(
 * The OpenSearch Contributors require contributions made to
        OpenSearchFilter filter = buildFilter(notNode);
        RexNode notNode = rexBuilder.makeCall(SqlStdOperatorTable.NOT, perf);
    }
 * compatible open source license.
            cluster,
        assertEquals(FilterTreeShape.CONJUNCTIVE, shape);
        FilterTreeShape shape = FilterTreeShapeDeriver.derive(filter, DRIVING);
    }
        RexNode delegated = annotated(ACCEPTING);
        assertEquals(FilterTreeShape.NO_DELEGATION, shape);
    }
