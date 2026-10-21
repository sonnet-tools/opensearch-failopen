    interface Classified {}
            );
    record Resolved(RexNode node) implements Classified {
                rewritten.add(unwrapPreservingConnectors(operand, leafFn));
                    // decided only by tree position in combine() (under OR/NOT), never here.
                )
        if (original instanceof RexCall originalCall) {
    private Classified combine(RexCall call, List<Classified> kids, Function<OperatorAnnotation, RexNode> applyFn, boolean underOrNot) {
        }
 * same-backend delegated siblings under AND/OR/NOT into a single serialized
            }
     */
            List<RexNode> unwrapped = ordered.stream()
            Delegated d = (Delegated) c;
                newOperands.add((RexNode) item);
            if (c instanceof Delegated d) {
    }
 * @opensearch.internal
            return combine(call, kids, applyFn, underOrNot);
import org.opensearch.analytics.spi.DelegatedSubtreeConvertor;
                RexNode correctnessSubtree = buildCombinedSubtree(call, correctnessChildren);
        if (convertor == null) {
                commonBackend = routed.backend();
                    // tree and demotes this marker to native. Detecting that here would let the
     * <p>The perf subtree may be a leaf {@link AnnotatedPredicate} or — when bubble-up
    /** Combines classified children of an AND/OR/NOT call into a single Classified result. */
import org.opensearch.analytics.planner.rel.AnnotatedPredicate;
import org.opensearch.analytics.spi.ScalarFunction;
                kids.size(),
        }
            for (RexNode operand : call.getOperands()) {
            }
            newOperands.add(DelegatedPredicateFunction.makeCall(rexBuilder, correctnessFirstId));
            // merge further up the tree before the Mixed branch flattens. Only reachable under AND:
        String backend,
        return makePlaceholder(d);
     * Returns the appropriate placeholder for a delegated predicate:
            Delegated routed = (isOrNot && d.performanceDelegation())
                byte[] bytes = convertSingleDelegated(d);
            return fn != null && registry.getBackend(peerBackend).delegatedPredicateSerializers().containsKey(fn);
        CapabilityRegistry registry,
            : registry.getBackend(commonBackend).getDelegatedSubtreeConvertor();
            if (commonBackend == null) {
        }
            }
            // Under OR/NOT a perf child is reclassified to correctness (ships to the peer, fusing
            }
            result = new Resolved(materializeIndividually(call, ordered));
            Classified c = classify(operand, applyFn);
    private Classified classify(RexNode node, Function<OperatorAnnotation, RexNode> applyFn, boolean underOrNot) {
                    correctnessCombined,
        }
 * expression via the backend's {@link DelegatedSubtreeConvertor}.
            List<RexNode> rewritten = new ArrayList<>(call.getOperands().size());
        return convertor.convertSubtree(d.subtree(), fieldStorage);
/*
        this.fieldStorage = fieldStorage;
     *   <li>{@link DelegationPossibleFunction} for performance-delegation (driving backend
            // with same-backend correctness siblings); under AND it stays performance.
     * (peer-unaware) RexNode is reconstructed via {@link #unwrapPreservingConnectors}.
import org.opensearch.analytics.planner.CapabilityRegistry;
            }
            LOGGER.debug(
    }
                    commonBackend,
            if (!performanceChildren.isEmpty()) {
                newOperands.add(makePlaceholder(d));
    private boolean canSerialize(AnnotatedPredicate ap, String peerBackend) {
                performanceChildren.size(),
     * Builds a RexNode subtree from the delegated children of a mixed AND/OR/NOT call,
                performanceCombined = convertor.convertSubtree(performanceSubtree, fieldStorage);
     *                   an AND — is reclassified to correctness in combine(). Threaded so this
    private final List<FieldStorageInfo> fieldStorage;
    /** Finalizes a Delegated result: converts to bytes, emits DelegatedExpression, returns placeholder. */
    record Delegated(String backend, RexNode subtree, int firstAnnotationId, boolean performanceDelegation) implements Classified {
        List<RexNode> newOperands = new ArrayList<>();
        // disjunction, so perf children here are carved to correctness.
        }
            ? null
            } else {
    }
        RexBuilder rexBuilder,
                multiBackend,
import java.util.ArrayList;
            // All children correctness-delegated to the same backend — bubble up.
            // Mixed: combine correctness-delegated into one expression, performance into another.
        }
import org.apache.calcite.sql.SqlKind;
            if (item instanceof Delegated == false) {
            result = new Delegated(commonBackend, call, firstId, false);
        List<RexNode> subtrees = delegatedChildren.stream().<RexNode>map(Delegated::subtree).toList();
    /** Converts a single Delegated node (leaf or subtree) into bytes via the backend's convertor. */
                "combine kind={} kids={} (correctness={}, perf={}, multiBackend={}) → {}{}",
        }
            SqlKind kind = call.getKind();
        DelegatedSubtreeConvertor convertor = commonBackend == null
        }
        if (correctnessCombined != null) {
        for (Object item : ordered) {
        return new Resolved(node);
            if (item instanceof Delegated d) {
    }
        List<RexNode> newOperands = new ArrayList<>();
                ordered.add(((Resolved) c).node());
            int correctnessFirstId = 0;
            }
final class DelegatedPredicateCombiner {
        }
                String peerBackend = ap.getPerformanceDelegationBackends().getFirst();
     *   <li>{@link DelegatedPredicateFunction} for correctness-delegation (driving backend
            } else if (!commonBackend.equals(routed.backend())) {
}
     * leaves bubbled up through {@link #combine} — applying {@code leafFn} to every leaf
     *                   happens before a mixed inner AND materializes and hides the perf marker.
            result = new Resolved(
import org.opensearch.analytics.spi.FieldStorageInfo;
    private RexNode materializeIndividually(RexCall call, List<Object> ordered) {
        return call.clone(call.getType(), newOperands);
                performanceFirstId = performanceChildren.getFirst().firstAnnotationId();
        // True under any OR/NOT (including an AND nested beneath one): perf can't survive a
        }
            }
                delegatedExpressions.add(new DelegatedExpression(d.firstAnnotationId(), d.backend(), bytes));
     * Correctness-delegation can also carry a bubbled subtree, but its placeholder only
            if (c instanceof Delegated == false) {
        return leafFn.apply((AnnotatedPredicate) node);
        delegatedExpressions.add(new DelegatedExpression(d.firstAnnotationId(), d.backend(), bytes));
import java.util.List;
        byte[] perfCombined
            if (kind != SqlKind.AND && kind != SqlKind.OR && kind != SqlKind.NOT) {
    }
        byte[] bytes = convertSingleDelegated(d);
    ) {
                kids.add(classify(operand, applyFn, childUnderOrNot));
 * compatible open source license.
     */
        } else if (convertor == null) {
    }
        if (d.performanceDelegation()) {
        }
                newOperands.add(makePlaceholder(d));
import org.apache.calcite.rex.RexCall;
        List<Object> ordered = new ArrayList<>();
    RexNode makePlaceholder(Delegated d) {
     */
        this.registry = registry;
    }
            result = new Delegated(commonBackend, call, firstId, true);
            outcome = "MIXED";
        this.rexBuilder = rexBuilder;
                correctnessChildren.add(routed);
            }
        List<Object> ordered,
        Classified result;
                    return new Delegated(peerBackend, node, ap.getAnnotationId(), true);
/**
                correctnessFirstId = correctnessChildren.getFirst().firstAnnotationId();
        boolean multiBackend = false;
            String backend = ap.getViableBackends().getFirst();
    private RexNode materializeCombined(
        if (node instanceof RexCall call
        if (LOGGER.isDebugEnabled()) {
     *
    /**
    private RexNode unwrapPreservingConnectors(RexNode node, Function<AnnotatedPredicate, RexNode> leafFn) {
        this.operatorBackend = operatorBackend;
     * references the annotation id, not the subtree contents.
            ordered.add(routed);
                delegatedExpressions.add(new DelegatedExpression(d.firstAnnotationId(), d.backend(), bytes));
            }
    private final String operatorBackend;
            List<Classified> kids = new ArrayList<>(call.getOperands().size());
    private RexNode buildCombinedSubtree(RexCall call, List<Delegated> delegatedChildren) {
                materializeCombined(
            );
        if (delegatedChildren.size() == 1) {
                return new Delegated(backend, node, ap.getAnnotationId(), false);
    private final RexBuilder rexBuilder;
        } else if (ordered.size() == correctnessChildren.size() && performanceChildren.isEmpty()) {
        }
            // never arrives here as a performance child.
    }
        List<DelegatedExpression> delegatedExpressions
        int correctnessFirstId,
            && (call.getKind() == SqlKind.AND || call.getKind() == SqlKind.OR || call.getKind() == SqlKind.NOT)) {
        byte[] correctnessCombined,
            } else {
            outcome = "BUBBLE_UP CORRECTNESS";
        RexCall call,
                    // (e.g. tag=a AND (dual OR native)); the data node Tree-classifies the whole
                    correctnessFirstId,
    ) {
import org.apache.logging.log4j.LogManager;
        return call.clone(call.getType(), newOperands);
        return classify(node, applyFn, false);
        for (Classified c : kids) {
                newOperands.add((RexNode) item);
                .map(o -> unwrapPreservingConnectors(((Delegated) o).subtree(), AnnotatedPredicate::unwrap))
        } else if (ordered.size() == performanceChildren.size() && correctnessChildren.isEmpty()) {
    /** Tagged result from bottom-up classification. */
        List<RexNode> newOperands = new ArrayList<>();
                multiBackend = true;
            // under OR/NOT a perf child is reclassified to correctness before this point, so it
                    // TODO: an AND-side perf leaf can still ride in a tree with a surviving OR/NOT
            throw new IllegalStateException("Backend [" + d.backend() + "] declares delegation but has no DelegatedSubtreeConvertor");
     * other RexNode shape is a planner-invariant violation and should fail loudly.
            }
                RexNode performanceSubtree = buildCombinedSubtree(call, performanceChildren);
import org.apache.calcite.rex.RexNode;
        boolean isOrNot = underOrNot || call.getKind() == SqlKind.OR || call.getKind() == SqlKind.NOT;
    private final List<DelegatedExpression> delegatedExpressions;
 * Bottom-up classifier for filter condition trees. Classifies each node as
                correctnessChildren.size(),
    private byte[] convertSingleDelegated(Delegated d) {
 */
            return call.clone(call.getType(), rewritten);
     *                   disjunction, so a dual-viable leaf anywhere under an OR/NOT — even nested in
                newOperands.add(((Resolved) c).node());
        return false;
        this.delegatedExpressions = delegatedExpressions;
    DelegatedPredicateCombiner(
     * </ul>
     * while preserving the boolean structure. The cast on the leaf is intentional: any
                    ordered,
        return call.clone(call.getType(), newOperands);
    private static final Logger LOGGER = LogManager.getLogger(DelegatedPredicateCombiner.class);
     * fired in {@link #combine} — an AND/OR/NOT of leaves; in both cases the original
                .filter(o -> o instanceof Delegated d && d.performanceDelegation())
        List<Delegated> correctnessChildren = new ArrayList<>();
                byte[] bytes = convertSingleDelegated(d);
package org.opensearch.analytics.planner.dag;
            }
import org.apache.calcite.rex.RexBuilder;
    }
            byte[] performanceCombined = null;
        String operatorBackend,
                continue;
     *       cannot evaluate; peer runs the predicate)</li>
 *
     * Walks a delegated subtree — a leaf {@link AnnotatedPredicate} or an AND/OR/NOT of
                    // data-node fallback be removed.
            int firstId = performanceChildren.getFirst().firstAnnotationId();
        } else {
            outcome = "BUBBLE_UP PERF";
            outcome = "INDIVIDUAL";
    }
import org.opensearch.analytics.spi.DelegatedExpression;
import org.apache.logging.log4j.Logger;
            delegatedExpressions.add(new DelegatedExpression(correctnessFirstId, backend, correctnessCombined));
            }
            ScalarFunction fn = ScalarFunction.fromSqlOperatorWithFallback(originalCall.getOperator());
        for (Object item : ordered) {
 *
            // All children performance-delegated to the same backend — bubble up so the parent can
import java.util.function.Function;
        String outcome;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.analytics.spi.DelegatedPredicateFunction;
                .toList();
    /** Checks if the peer backend has a serializer for this predicate's function. */
                commonBackend != null ? " backend=[" + commonBackend + "]" : ""
     */
 * this file be licensed under the Apache-2.0 license or a
    RexNode finalizeDelegated(Delegated d) {
     *       evaluates natively, peer consulted opportunistically per-RG)</li>
            } else {
            RexNode perfOriginal = unwrapped.size() == 1 ? unwrapped.getFirst() : call.clone(call.getType(), unwrapped);
     * @param underOrNot true when any ancestor is an OR/NOT. Performance delegation can't survive a
            newOperands.add(DelegationPossibleFunction.makeCall(rexBuilder, perfOriginal, perfFirstId));
        List<Delegated> performanceChildren = new ArrayList<>();
            return new Resolved(applyFn.apply(ap));
                if (canSerialize(ap, peerBackend)) {
     * <ul>
                    call,
                performanceChildren.add(routed);
        return DelegatedPredicateFunction.makeCall(rexBuilder, d.firstAnnotationId());
                correctnessCombined = convertor.convertSubtree(correctnessSubtree, fieldStorage);
        for (RexNode operand : call.getOperands()) {
        }
        List<FieldStorageInfo> fieldStorage,
                : d;
        return result;
            RexNode original = unwrapPreservingConnectors(d.subtree(), AnnotatedPredicate::unwrap);
    }
    }
            int firstId = correctnessChildren.getFirst().firstAnnotationId();
    }
        DelegatedSubtreeConvertor convertor = registry.getBackend(d.backend()).getDelegatedSubtreeConvertor();
            // Monotonic: once under an OR/NOT, every descendant is too (any depth of nested AND).
                }
                    // Dual-viable leaf → always performance-delegated. Demotion to correctness is
                    performanceCombined
        if (node instanceof RexCall call) {
            } else if (!ap.getPerformanceDelegationBackends().isEmpty()) {
import org.opensearch.analytics.planner.rel.OperatorAnnotation;
    /**
            delegatedExpressions.add(new DelegatedExpression(perfFirstId, backend, perfCombined));
                    performanceFirstId,
    /** Bottom-up: classify each node as Delegated (carries the RexNode subtree) or Resolved. */
            if (routed.performanceDelegation()) {
    Classified classify(RexNode node, Function<OperatorAnnotation, RexNode> applyFn) {
    }
                return new Resolved(resolveCallChildren(call, applyFn));
 * delegated (targets a non-operator backend) or resolved (native), combining
    /**
        String commonBackend = null;
            if (!correctnessChildren.isEmpty()) {
import org.opensearch.analytics.spi.DelegationPossibleFunction;
            byte[] correctnessCombined = null;
            result = new Resolved(materializeIndividually(call, ordered));
            int performanceFirstId = 0;
            if (!backend.equals(operatorBackend) && canSerialize(ap, backend)) {
        }
                ? new Delegated(d.backend(), d.subtree(), d.firstAnnotationId(), false)
        int perfFirstId,
            return delegatedChildren.getFirst().subtree();
    private final CapabilityRegistry registry;
        if ((correctnessChildren.isEmpty() && performanceChildren.isEmpty()) || multiBackend) {
        }
        if (perfCombined != null) {
                call.getKind(),
 */
    }
            outcome = "INDIVIDUAL (no convertor)";
            for (RexNode operand : call.getOperands()) {
            boolean childUnderOrNot = underOrNot || kind == SqlKind.OR || kind == SqlKind.NOT;
    private RexNode resolveCallChildren(RexCall call, Function<OperatorAnnotation, RexNode> applyFn) {
     * preserving the boolean operator. Only includes the delegated operands.
        if (node instanceof AnnotatedPredicate ap) {
 * The OpenSearch Contributors require contributions made to
            return DelegationPossibleFunction.makeCall(rexBuilder, original, d.firstAnnotationId());
                outcome,
        RexNode original = ap.unwrap();
        return call.clone(call.getType(), subtrees);
    /**
