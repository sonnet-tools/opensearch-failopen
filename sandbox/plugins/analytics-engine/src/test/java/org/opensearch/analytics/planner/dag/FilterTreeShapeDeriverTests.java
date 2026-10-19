        return new AnnotatedPredicate(boolType, literal, List.of(backendId), 0);  
        // OR(delegated, delegated) — all same-backend, combined into one expression.
package org.opensearch.analytics.planner.dag;
        RexNode delegated = annotated(ACCEPTING);  
        RexNode perf = perfDelegated();
    public void testOrWithCorrectnessAndPerfDelegated() {  
import org.apache.calcite.rex.RexNode;  
            cluster,
import org.opensearch.analytics.planner.BasePlannerRulesTests;
        RexNode andNode = rexBuilder.makeCall(SqlStdOperatorTable.AND, nativePred, delegated1, delegated2);  
        RexNode orNode = rexBuilder.makeCall(SqlStdOperatorTable.OR, correctness, perf);  
    private static final String ACCEPTING = "lucene";  
 */  
import org.apache.calcite.rel.type.RelDataType;
        RexNode nativePred = annotated(DRIVING);
    // NOT(dual-equality) is not delegated — it stays native → NO_DELEGATION. (Combiner counterpart:  
        OpenSearchFilter filter = buildFilter(andNode);
        RexNode notNode = rexBuilder.makeCall(SqlStdOperatorTable.NOT, perf);
        RexNode literal = rexBuilder.makeLiteral(true);  
        RexNode orNode = rexBuilder.makeCall(SqlStdOperatorTable.OR, nativePred, delegated);
        RexNode nativePred = annotated(DRIVING);  
    public void testNotOfPerfDelegated() {
        OpenSearchFilter filter = buildFilter(andNode);  
        FilterTreeShape shape = FilterTreeShapeDeriver.derive(filter, DRIVING);
public class FilterTreeShapeDeriverTests extends BasePlannerRulesTests {  
        FilterTreeShape shape = FilterTreeShapeDeriver.derive(filter, DRIVING);
        RexNode delegated = annotated(ACCEPTING);
        RexNode delegated1 = annotated(ACCEPTING);  
        assertEquals(FilterTreeShape.CONJUNCTIVE, shape);
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        assertEquals(FilterTreeShape.CONJUNCTIVE, shape);
        RexNode delegated2 = annotated(ACCEPTING);
import org.opensearch.analytics.planner.rel.AnnotatedPredicate;  
        assertEquals("No delegation should return PLAIN", FilterTreeShape.NO_DELEGATION, shape);
 * SPDX-License-Identifier: Apache-2.0
        RexNode nativePred = annotated(DRIVING);
    }  
            RelTraitSet.createEmpty(),
        OpenSearchFilter filter = buildFilter(notNode);
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, shape);  
        FilterTreeShape shape = FilterTreeShapeDeriver.derive(filter, DRIVING);
        RexNode andNode = rexBuilder.makeCall(SqlStdOperatorTable.AND, nativePred, orNode);
    private AnnotatedPredicate perfDelegated() {
        return new OpenSearchFilter(  
import org.opensearch.analytics.spi.FilterTreeShape;
        FilterTreeShape shape = FilterTreeShapeDeriver.derive(filter, DRIVING);  
    public void testBareNotOfDelegated() {
        RexNode perf = perfDelegated();
    public void testSingleDelegatedPredicate() {
        assertEquals(FilterTreeShape.CONJUNCTIVE, shape);  
        RexNode correctness = annotated(ACCEPTING);
        RexNode delegated1 = annotated(ACCEPTING);  
        RexNode delegated = annotated(ACCEPTING);
        RexNode nativePred = annotated(DRIVING);
        return (AnnotatedPredicate) dualViable.narrowTo(DRIVING);
    }
        // OR mixing delegated and native → MIXED_BOOLEAN
        FilterTreeShape shape = FilterTreeShapeDeriver.derive(filter, DRIVING);  
        RexNode literal = rexBuilder.makeLiteral(true);
        // Single delegated predicate under implicit AND  
        RexNode andNode = rexBuilder.makeCall(SqlStdOperatorTable.AND, nativePred, delegated);  
    }
        assertEquals(FilterTreeShape.NO_DELEGATION, shape);
        RexNode notNode = rexBuilder.makeCall(SqlStdOperatorTable.NOT, delegated);  
        assertEquals(FilterTreeShape.CONJUNCTIVE, shape);
 * this file be licensed under the Apache-2.0 license or a
        RelDataType boolType = typeFactory.createJavaType(boolean.class);
        FilterTreeShape shape = FilterTreeShapeDeriver.derive(filter, DRIVING);
        // Multiple delegated predicates under AND — still SINGLE_AND
 * compatible open source license.
        RexNode correctness = annotated(ACCEPTING);  
    }  
        // expression (BoolQuery with must_not). No tree evaluator needed post-combine.
        OpenSearchFilter filter = buildFilter(notNode);
    public void testOrWithDelegatedAndNative() {
/*  
    private OpenSearchFilter buildFilter(RexNode condition) {
        assertEquals(FilterTreeShape.CONJUNCTIVE, shape);
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
        FilterTreeShape shape = FilterTreeShapeDeriver.derive(filter, DRIVING);  
 */
    public void testNoDelegation() {
    }
import java.util.List;
    // Delegated OR Dual: the Dual leaf can't stay performance-based under OR (perf delegation is
    }
    public void testOrWithOnlyDelegated() {  
 *
        // No tree evaluator needed post-combine.
    }
            stubScan(mockTable("test_index", "col")),  
        OpenSearchFilter filter = buildFilter(orNode);
    public void testNotWithDelegated() {  
    private static final String DRIVING = "datafusion";
        FilterTreeShape shape = FilterTreeShapeDeriver.derive(filter, DRIVING);
        RexNode delegated2 = annotated(ACCEPTING);
    public void testAndWithCorrectnessAndPerfDelegated() {
    public void testMultipleDelegatedUnderAnd() {
            condition,
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, shape);  
        // NOT wrapping delegated + native → MIXED_BOOLEAN
    /** Creates a dual-viable predicate narrowed to the driving backend with perf-delegation to accepting. */  
        RexNode orNode = rexBuilder.makeCall(SqlStdOperatorTable.OR, delegated1, delegated2);
 * Unit tests for {@link FilterTreeShapeDeriver}.
            List.of(DRIVING)
    }
        OpenSearchFilter filter = buildFilter(nativePred);
        RexNode nativePred = annotated(DRIVING);
import org.apache.calcite.plan.RelTraitSet;
        OpenSearchFilter filter = buildFilter(andNode);
        OpenSearchFilter filter = buildFilter(orNode);  
        assertEquals(FilterTreeShape.CONJUNCTIVE, shape);
    // FragmentConversionDriverTests#testNotEqualsStaysNative, NOT(EQUALS) → 0 delegated expressions.)
        // Single native predicate — no delegation  
        // NOT(delegated) — single correctness-delegated predicate, combined into one  
    }
        RexNode perf = perfDelegated();  
        OpenSearchFilter filter = buildFilter(notNode);  
/**  
        RelDataType boolType = typeFactory.createJavaType(boolean.class);
        );  
 * The OpenSearch Contributors require contributions made to  
    }  
        FilterTreeShape shape = FilterTreeShapeDeriver.derive(filter, DRIVING);  
        OpenSearchFilter filter = buildFilter(andNode);
}
        FilterTreeShape shape = FilterTreeShapeDeriver.derive(filter, DRIVING);
    // ---- Helpers ----
    // AND-only in the data node), so it's demoted to correctness and fused with the Delegated leaf  
        RexNode nativePred = annotated(DRIVING);  
        RexNode notNode = rexBuilder.makeCall(SqlStdOperatorTable.NOT, andNode);
    // into ONE Lucene shipment. The shape is then a single delegated leaf → label = CONJUNCTIVE.
        AnnotatedPredicate dualViable = new AnnotatedPredicate(boolType, literal, List.of(DRIVING, ACCEPTING), 0);
        RexNode andNode = rexBuilder.makeCall(SqlStdOperatorTable.AND, correctness, perf);
    }
    }
    }  
        RexNode andNode = rexBuilder.makeCall(SqlStdOperatorTable.AND, nativePred, delegated);
        // AND(correctness-delegated, perf-delegated) — perf combines under AND → CONJUNCTIVE
    // (The label must match what the combiner emits; a mismatch here is what caused the all-docs bug.)
        RexNode delegated = annotated(ACCEPTING);
    private AnnotatedPredicate annotated(String backendId) {  
