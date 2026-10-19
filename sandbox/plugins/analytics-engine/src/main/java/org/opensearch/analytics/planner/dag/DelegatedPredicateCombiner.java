            int firstId = correctnessChildren.getFirst().firstAnnotationId();
    private boolean canSerialize(AnnotatedPredicate ap, String peerBackend) {  
            result = new Resolved(
                newOperands.add((RexNode) item);
    }
        RexNode original = ap.unwrap();
            : registry.getBackend(commonBackend).getDelegatedSubtreeConvertor();
            Delegated d = (Delegated) c;
            Delegated routed = (isOrNot && d.performanceDelegation())  
import org.opensearch.analytics.spi.DelegatedExpression;
            for (RexNode operand : call.getOperands()) {  
            newOperands.add(DelegationPossibleFunction.makeCall(rexBuilder, perfOriginal, perfFirstId));
import org.apache.logging.log4j.Logger;  
        if (node instanceof AnnotatedPredicate ap) {
        }
    Classified classify(RexNode node, Function<OperatorAnnotation, RexNode> applyFn) {  
        return makePlaceholder(d);  
            delegatedExpressions.add(new DelegatedExpression(correctnessFirstId, backend, correctnessCombined));  
        }
package org.opensearch.analytics.planner.dag;
        this.registry = registry;  
        RexCall call,
        }  
                correctnessChildren.size(),
    record Delegated(String backend, RexNode subtree, int firstAnnotationId, boolean performanceDelegation) implements Classified {  
    private final CapabilityRegistry registry;
        if (node instanceof RexCall call  
            byte[] correctnessCombined = null;
                newOperands.add(makePlaceholder(d));
import org.apache.calcite.rex.RexBuilder;
                performanceCombined = convertor.convertSubtree(performanceSubtree, fieldStorage);
            );  
            // Under OR/NOT a perf child is reclassified to correctness (ships to the peer, fusing
     * fired in {@link #combine} — an AND/OR/NOT of leaves; in both cases the original
        if (correctnessCombined != null) {
        return call.clone(call.getType(), subtrees);  
        if (convertor == null) {
 */
    /** Bottom-up: classify each node as Delegated (carries the RexNode subtree) or Resolved. */
/**  
final class DelegatedPredicateCombiner {
            if (c instanceof Delegated d) {
            List<Classified> kids = new ArrayList<>(call.getOperands().size());
    private final RexBuilder rexBuilder;  
    }
import org.opensearch.analytics.planner.CapabilityRegistry;
        }
            ordered.add(routed);
     *                   disjunction, so a dual-viable leaf anywhere under an OR/NOT — even nested in  
                : d;
        String outcome;
    /** Checks if the peer backend has a serializer for this predicate's function. */
            // Mixed: combine correctness-delegated into one expression, performance into another.
            RexNode original = unwrapPreservingConnectors(d.subtree(), AnnotatedPredicate::unwrap);
            } else if (!commonBackend.equals(routed.backend())) {
            // All children performance-delegated to the same backend — bubble up so the parent can
        } else if (ordered.size() == performanceChildren.size() && correctnessChildren.isEmpty()) {  
                correctnessFirstId = correctnessChildren.getFirst().firstAnnotationId();
    private byte[] convertSingleDelegated(Delegated d) {  
        }  
                RexNode correctnessSubtree = buildCombinedSubtree(call, correctnessChildren);  
                return new Delegated(backend, node, ap.getAnnotationId(), false);
        return call.clone(call.getType(), newOperands);
            List<RexNode> rewritten = new ArrayList<>(call.getOperands().size());
    /** Finalizes a Delegated result: converts to bytes, emits DelegatedExpression, returns placeholder. */
        List<Delegated> performanceChildren = new ArrayList<>();
        if (d.performanceDelegation()) {
 * SPDX-License-Identifier: Apache-2.0
    RexNode finalizeDelegated(Delegated d) {  
        } else if (convertor == null) {
        List<RexNode> subtrees = delegatedChildren.stream().<RexNode>map(Delegated::subtree).toList();
        return DelegatedPredicateFunction.makeCall(rexBuilder, d.firstAnnotationId());
        this.fieldStorage = fieldStorage;
        return new Resolved(node);  
     * references the annotation id, not the subtree contents.
        RexBuilder rexBuilder,
            ScalarFunction fn = ScalarFunction.fromSqlOperatorWithFallback(originalCall.getOperator());  
            if (c instanceof Delegated == false) {
            int performanceFirstId = 0;
        List<DelegatedExpression> delegatedExpressions
 * same-backend delegated siblings under AND/OR/NOT into a single serialized  
        if (original instanceof RexCall originalCall) {
            );
 * this file be licensed under the Apache-2.0 license or a
    }  
            }
        List<FieldStorageInfo> fieldStorage,
     * </ul>
        if ((correctnessChildren.isEmpty() && performanceChildren.isEmpty()) || multiBackend) {
            if (item instanceof Delegated == false) {
            }
import org.opensearch.analytics.planner.rel.AnnotatedPredicate;
        List<Delegated> correctnessChildren = new ArrayList<>();  
            if (!correctnessChildren.isEmpty()) {
     */  
 */  
     */
     * while preserving the boolean structure. The cast on the leaf is intentional: any
        for (Object item : ordered) {
            for (RexNode operand : call.getOperands()) {  
        // True under any OR/NOT (including an AND nested beneath one): perf can't survive a
                commonBackend != null ? " backend=[" + commonBackend + "]" : ""
            return call.clone(call.getType(), rewritten);  
        boolean multiBackend = false;
                continue;  
            result = new Delegated(commonBackend, call, firstId, true);
                ordered.add(((Resolved) c).node());
                .filter(o -> o instanceof Delegated d && d.performanceDelegation())  
        return leafFn.apply((AnnotatedPredicate) node);
                return new Resolved(resolveCallChildren(call, applyFn));  
     *                   happens before a mixed inner AND materializes and hides the perf marker.
        if (delegatedChildren.size() == 1) {
import java.util.List;  
            }
        byte[] perfCombined
    }
    }
        for (RexNode operand : call.getOperands()) {
     *
    /** Converts a single Delegated node (leaf or subtree) into bytes via the backend's convertor. */
        this.operatorBackend = operatorBackend;
                String peerBackend = ap.getPerformanceDelegationBackends().getFirst();
                commonBackend = routed.backend();
        for (Classified c : kids) {  
        int perfFirstId,
                    ordered,
    interface Classified {}
            byte[] performanceCombined = null;  
                if (canSerialize(ap, peerBackend)) {
                multiBackend = true;  
     * <p>The perf subtree may be a leaf {@link AnnotatedPredicate} or — when bubble-up  
     *   <li>{@link DelegationPossibleFunction} for performance-delegation (driving backend
                outcome,
            if (!performanceChildren.isEmpty()) {
        List<RexNode> newOperands = new ArrayList<>();
    }  
                multiBackend,  
        }
            }
            if (kind != SqlKind.AND && kind != SqlKind.OR && kind != SqlKind.NOT) {
                }
                byte[] bytes = convertSingleDelegated(d);
     * @param underOrNot true when any ancestor is an OR/NOT. Performance delegation can't survive a
                    // decided only by tree position in combine() (under OR/NOT), never here.
            result = new Resolved(materializeIndividually(call, ordered));  
            Classified c = classify(operand, applyFn);  
        String commonBackend = null;  
                    performanceFirstId,
            }  
                newOperands.add((RexNode) item);
                    call,  
                .map(o -> unwrapPreservingConnectors(((Delegated) o).subtree(), AnnotatedPredicate::unwrap))
     */  
import org.opensearch.analytics.spi.ScalarFunction;  
                RexNode performanceSubtree = buildCombinedSubtree(call, performanceChildren);
                kids.add(classify(operand, applyFn, childUnderOrNot));
import org.opensearch.analytics.spi.DelegatedSubtreeConvertor;  
            delegatedExpressions.add(new DelegatedExpression(perfFirstId, backend, perfCombined));
        return call.clone(call.getType(), newOperands);  
        byte[] correctnessCombined,  
                newOperands.add(makePlaceholder(d));
import java.util.function.Function;
 *
        for (Object item : ordered) {  
 * @opensearch.internal  
     * <ul>
            } else if (!ap.getPerformanceDelegationBackends().isEmpty()) {  
                delegatedExpressions.add(new DelegatedExpression(d.firstAnnotationId(), d.backend(), bytes));  
    private RexNode unwrapPreservingConnectors(RexNode node, Function<AnnotatedPredicate, RexNode> leafFn) {
        }
 * compatible open source license.
import org.apache.logging.log4j.LogManager;
        if (LOGGER.isDebugEnabled()) {
            outcome = "INDIVIDUAL";
        int correctnessFirstId,
    private final String operatorBackend;  
            SqlKind kind = call.getKind();
                    // TODO: an AND-side perf leaf can still ride in a tree with a surviving OR/NOT
    }  
        List<Object> ordered,  
            return combine(call, kids, applyFn, underOrNot);  
    /** Tagged result from bottom-up classification. */  
        List<Object> ordered = new ArrayList<>();
        }
    /**
                newOperands.add(((Resolved) c).node());  
            LOGGER.debug(  
     * preserving the boolean operator. Only includes the delegated operands.
            if (item instanceof Delegated d) {
                    correctnessFirstId,
        String backend,
                call.getKind(),
            } else {  
        return false;  
                    return new Delegated(peerBackend, node, ap.getAnnotationId(), true);  
    }  
    /** Combines classified children of an AND/OR/NOT call into a single Classified result. */  
            result = new Resolved(materializeIndividually(call, ordered));  
     *                   an AND — is reclassified to correctness in combine(). Threaded so this
                    correctnessCombined,
                materializeCombined(
                performanceChildren.size(),
        DelegatedSubtreeConvertor convertor = registry.getBackend(d.backend()).getDelegatedSubtreeConvertor();
    private RexNode buildCombinedSubtree(RexCall call, List<Delegated> delegatedChildren) {
                rewritten.add(unwrapPreservingConnectors(operand, leafFn));
    }  
            if (!backend.equals(operatorBackend) && canSerialize(ap, backend)) {
        // disjunction, so perf children here are carved to correctness.  
            outcome = "BUBBLE_UP PERF";
                    // tree and demotes this marker to native. Detecting that here would let the
            List<RexNode> unwrapped = ordered.stream()
    /**  
 *
    }
        CapabilityRegistry registry,  
                correctnessCombined = convertor.convertSubtree(correctnessSubtree, fieldStorage);
        } else if (ordered.size() == correctnessChildren.size() && performanceChildren.isEmpty()) {
        this.rexBuilder = rexBuilder;
import org.apache.calcite.rex.RexNode;  
    private final List<DelegatedExpression> delegatedExpressions;
    /**
            }
            } else {
                    performanceCombined  
 * expression via the backend's {@link DelegatedSubtreeConvertor}.
    }
            return new Resolved(applyFn.apply(ap));  
                "combine kind={} kids={} (correctness={}, perf={}, multiBackend={}) → {}{}",
    }
     * leaves bubbled up through {@link #combine} — applying {@code leafFn} to every leaf
     */
            outcome = "MIXED";  
     *       cannot evaluate; peer runs the predicate)</li>
import org.opensearch.analytics.spi.DelegatedPredicateFunction;
        return result;
                    // data-node fallback be removed.
    private RexNode materializeCombined(
    private Classified combine(RexCall call, List<Classified> kids, Function<OperatorAnnotation, RexNode> applyFn, boolean underOrNot) {
            ? null
            RexNode perfOriginal = unwrapped.size() == 1 ? unwrapped.getFirst() : call.clone(call.getType(), unwrapped);  
        }
        if (node instanceof RexCall call) {  
        return classify(node, applyFn, false);
    }  
                correctnessChildren.add(routed);  
                byte[] bytes = convertSingleDelegated(d);  
                .toList();
import java.util.ArrayList;
            }
                ? new Delegated(d.backend(), d.subtree(), d.firstAnnotationId(), false)
            // never arrives here as a performance child.
    RexNode makePlaceholder(Delegated d) {  
                performanceFirstId = performanceChildren.getFirst().firstAnnotationId();  
        }
                )
    DelegatedPredicateCombiner(  
            outcome = "BUBBLE_UP CORRECTNESS";  
            return DelegationPossibleFunction.makeCall(rexBuilder, original, d.firstAnnotationId());  
                    // (e.g. tag=a AND (dual OR native)); the data node Tree-classifies the whole  
            return delegatedChildren.getFirst().subtree();  
            return fn != null && registry.getBackend(peerBackend).delegatedPredicateSerializers().containsKey(fn);
        byte[] bytes = convertSingleDelegated(d);
     *       evaluates natively, peer consulted opportunistically per-RG)</li>  
        }
        DelegatedSubtreeConvertor convertor = commonBackend == null  
 * The OpenSearch Contributors require contributions made to  
    ) {  
            newOperands.add(DelegatedPredicateFunction.makeCall(rexBuilder, correctnessFirstId));
            // merge further up the tree before the Mixed branch flattens. Only reachable under AND:
     * Returns the appropriate placeholder for a delegated predicate:
     * (peer-unaware) RexNode is reconstructed via {@link #unwrapPreservingConnectors}.
            // All children correctness-delegated to the same backend — bubble up.
            int correctnessFirstId = 0;  
            String backend = ap.getViableBackends().getFirst();  
            boolean childUnderOrNot = underOrNot || kind == SqlKind.OR || kind == SqlKind.NOT;
/*  
            }
        } else {
import org.opensearch.analytics.spi.FieldStorageInfo;
        this.delegatedExpressions = delegatedExpressions;
            throw new IllegalStateException("Backend [" + d.backend() + "] declares delegation but has no DelegatedSubtreeConvertor");  
}
    }
            int firstId = performanceChildren.getFirst().firstAnnotationId();  
                delegatedExpressions.add(new DelegatedExpression(d.firstAnnotationId(), d.backend(), bytes));
import org.apache.calcite.rex.RexCall;
     * Walks a delegated subtree — a leaf {@link AnnotatedPredicate} or an AND/OR/NOT of  
    }
            outcome = "INDIVIDUAL (no convertor)";
        }
import org.apache.calcite.sql.SqlKind;
        delegatedExpressions.add(new DelegatedExpression(d.firstAnnotationId(), d.backend(), bytes));
            }
        }
        Classified result;
            result = new Delegated(commonBackend, call, firstId, false);
            // with same-backend correctness siblings); under AND it stays performance.
            }
        }
     * Builds a RexNode subtree from the delegated children of a mixed AND/OR/NOT call,
    private RexNode resolveCallChildren(RexCall call, Function<OperatorAnnotation, RexNode> applyFn) {  
                    commonBackend,  
    record Resolved(RexNode node) implements Classified {  
                    // Dual-viable leaf → always performance-delegated. Demotion to correctness is  
                performanceChildren.add(routed);
     * Correctness-delegation can also carry a bubbled subtree, but its placeholder only  
    private final List<FieldStorageInfo> fieldStorage;
    ) {  
import org.opensearch.analytics.planner.rel.OperatorAnnotation;  
        if (perfCombined != null) {  
        List<RexNode> newOperands = new ArrayList<>();
        List<RexNode> newOperands = new ArrayList<>();  
    private static final Logger LOGGER = LogManager.getLogger(DelegatedPredicateCombiner.class);
        return call.clone(call.getType(), newOperands);
     * other RexNode shape is a planner-invariant violation and should fail loudly.  
            if (commonBackend == null) {  
    /**  
     *   <li>{@link DelegatedPredicateFunction} for correctness-delegation (driving backend  
        String operatorBackend,
            // Monotonic: once under an OR/NOT, every descendant is too (any depth of nested AND).  
                kids.size(),  
            } else {
    private RexNode materializeIndividually(RexCall call, List<Object> ordered) {
import org.opensearch.analytics.spi.DelegationPossibleFunction;
        return convertor.convertSubtree(d.subtree(), fieldStorage);
            // under OR/NOT a perf child is reclassified to correctness before this point, so it  
            if (routed.performanceDelegation()) {  
            }
            }  
            && (call.getKind() == SqlKind.AND || call.getKind() == SqlKind.OR || call.getKind() == SqlKind.NOT)) {
    private Classified classify(RexNode node, Function<OperatorAnnotation, RexNode> applyFn, boolean underOrNot) {
 * Bottom-up classifier for filter condition trees. Classifies each node as
        }
 * delegated (targets a non-operator backend) or resolved (native), combining
        boolean isOrNot = underOrNot || call.getKind() == SqlKind.OR || call.getKind() == SqlKind.NOT;
