            for (RexNode operand : call.getOperands()) {
     * predicate, and whether it needs the data-node tree evaluator (interleaved).  
 */
     * {@link DelegatedPredicateCombiner#combine}. Tracks four facts about the post-combine shape: a
                interleaved |= child.interleaved;  
 * because {@code AnnotatedPredicate} extends {@code RexCall}; otherwise the leaf  
    }  
 * Derives {@link FilterTreeShape} from a filter condition while annotations are intact.  
     * <p>TODO: assumes a single OpenSearchFilter per fragment (FILTER_MERGE collapses  
    }  
                hasPerf = false;
 * <p><b>Tree shape this walks.</b> {@code OpenSearchFilterRule#annotateCondition}  
            boolean isDrivingBackend = !isCorrectness && !isPerformance;
                // Under NOT a dual-equality leaf folds to != (no serializer) and stays native.
 *
import org.opensearch.analytics.planner.rel.AnnotatedPredicate;
            if (hasPerf && isOr) {
                hasCorrectness = true;
        if (!result.hasCorrectness && !result.hasPerf) {
        Result result = walk(filter.getCondition(), drivingBackendId);  
            boolean hasCorrectness = false;  
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.rex.RexNode;
     * and combine their shapes (any mixed → INTERLEAVED, any delegated → CONJUNCTIVE,  
            }
     * under OR it's reclassified to correctness (ships to the peer); under NOT it stays native  
 *
 *     └─ RexCall(MATCH, [...])               └─ AnnotatedPredicate(...)       ← leaf wrapped
 */  
            // Nothing delegated post-combine (all native, or a perf leaf under NOT that stays native).
final class FilterTreeShapeDeriver {
import org.apache.calcite.sql.SqlKind;  
        }
     * correctness-delegated shipment, a surviving performance marker, a driving-backend (native)
     * Derives the filter tree shape from the filter's condition.
 * SPDX-License-Identifier: Apache-2.0
            // stay perf under OR or NOT. Mirror combine():
     * or the data node mis-routes (the historical "all-docs" disjunction bug).
            boolean isNot = call.getKind() == SqlKind.NOT;
     *  
            return new Result(hasCorrectness, hasPerf, hasDrivingBackend, interleaved);  
 * is misclassified as a combinator.
 * this file be licensed under the Apache-2.0 license or a
     *
 *   Before marking:                        After marking:  
    private static Result walk(RexNode node, String drivingBackendId) {
     * else NO_DELEGATION) so derivation stays consistent with delegationBytes which
     */
     * adjacent OpenSearchFilters that don't merge, this needs to walk all of them
     * @param filter              the OpenSearchFilter with annotations intact
     * (NOT(=) folds to != with no serializer). The shape label must match what the combiner emits,
            boolean hasDrivingBackend = false;
                hasPerf = false;  
                hasDrivingBackend |= child.hasDrivingBackend;
 * compatible open source license.
    private record Result(boolean hasCorrectness, boolean hasPerf, boolean hasDrivingBackend, boolean interleaved) {
            } else if (hasPerf && isNot) {  
 * </pre>
import org.apache.calcite.rex.RexCall;
        }
        }
     * @param drivingBackendId    the filter operator's resolved backend
                // Under OR it's reclassified to correctness and shipped to the peer.  
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
            // The data node does performance delegation only on the AND path, so a perf leaf can't  
 * Must be called before stripping removes the annotations.
            // Interleaving (tree evaluator needed) arises under OR/NOT when a delegated shipment  
    private FilterTreeShapeDeriver() {}
 *
            // (single-collector path), so AND never introduces interleaving on its own.  
            boolean isPerformance = !predicate.getPerformanceDelegationBackends().isEmpty();
     *
 * @opensearch.internal  
                Result child = walk(operand, drivingBackendId);
    /**  
            boolean interleaved = false;  
 * deepest predicate {@code RexCall} is wrapped. Walkers must check
 * wraps only the leaf predicate {@code RexCall}s in an {@code AnnotatedPredicate};
     */  
 *   RexCall(NOT)                           RexCall(NOT)                       ← unchanged
            boolean isCorrectness = !predicate.getViableBackends().getFirst().equals(drivingBackendId);  
     * <p>Performance delegation composes only under AND, so a perf leaf doesn't survive under OR/NOT:
/*  
        return result.interleaved ? FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION : FilterTreeShape.CONJUNCTIVE;
            // shipment. Under AND, driving-backend + delegated coexist as separate conjuncts
                hasCorrectness |= child.hasCorrectness;  
            boolean isOr = call.getKind() == SqlKind.OR;  
 *
/**
import org.opensearch.analytics.spi.FilterTreeShape;  
        return new Result(false, false, false, false);
 *                                                   └─ original = RexCall(MATCH, [...])  
 * <pre>
            }
                hasDrivingBackend = true;
            boolean hasPerf = false;
 * AND/OR/NOT combinators stay as plain {@code RexCall}s. So for
 *
     * walks the full tree.
            interleaved |= (isOr || isNot) && hasCorrectness && hasDrivingBackend;
 * {@code instanceof AnnotatedPredicate} <i>before</i> {@code instanceof RexCall}
     * Predicts what the combiner produces for a subtree, mirroring  
            return FilterTreeShape.NO_DELEGATION;  
        if (node instanceof RexCall call) {
        if (node instanceof AnnotatedPredicate predicate) {
    }  
 * <p>Parents and grandparents of an annotated leaf stay un-annotated — only the  
                hasPerf |= child.hasPerf;
 * <p>Single-pass walk: determines both whether delegation exists and whether the tree  
 * is mixed (delegated + driving-backend predicates interleaved under OR/NOT).
package org.opensearch.analytics.planner.dag;
            // sits alongside a driving-backend operand — the two can't collapse into one peer
 *
 * {@code WHERE NOT match(message, 'hello')}:  
     * stacked Filters during pushdownRules). If a future plan can produce multiple
            return new Result(isCorrectness, isPerformance, isDrivingBackend, false);  
    /**
     * @return the tree shape, or {@code null} if no delegated annotations exist  
    static FilterTreeShape derive(OpenSearchFilter filter, String drivingBackendId) {
}
