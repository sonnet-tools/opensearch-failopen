    protected String computeDigest(boolean withType) {
        List<String> performanceDelegationBackends
import org.apache.calcite.rel.type.RelDataType;
            + (performanceDelegationBackends.isEmpty() ? "" : ", peers=" + performanceDelegationBackends)
     * {@code delegation_possible(original, id)} so the peer may be consulted
        }
    private final RexNode original;
    @Override
    };
    ) {  
        0,
    private final List<String> viableBackends;
 * During fragment conversion: becomes a DelegatedPredicate if delegation is chosen.
 * @opensearch.internal  
import org.apache.calcite.sql.type.ReturnTypes;
     * / {@code performanceDelegationBackends} fields are lost, and {@code FragmentConversionDriver.strip}'s
        return performanceDelegationBackends;  
    }
import org.apache.calcite.sql.SqlKind;
    public List<String> getViableBackends() {
    }  
        return annotationId;
        this.annotationId = annotationId;
     * preserve the {@code AnnotatedPredicate} subclass when an operand is remapped. Without
     * {@code instanceof AnnotatedPredicate} check fails to unwrap it, leaving the operator in  
        return viableBackends;
    public RexNode getOriginal() {
     * narrowed onto one of its viable backends — the listed backends are valid
     * original viableBackends. Cleaner long-term shape is a typed Resolver  
    public RexCall clone(RelDataType type, List<RexNode> operands) {
        return DelegatedPredicateFunction.makeCall(rexBuilder, annotationId);
     * <p>FragmentConversion uses this list (a) to detect performance-delegation
     * the plan when it reaches the Substrait visitor.
    /** Backends that can evaluate this predicate. */  
        this(type, original, viableBackends, annotationId, List.of());  
     * Override {@link RexCall#clone(RelDataType, List)} so that {@link org.apache.calcite.rex.RexShuttle}-based  
            + annotationId
    }
}  
    }  
            + viableBackends  
    }
        List<String> viableBackends,  
import org.apache.calcite.rex.RexNode;
 * this file be licensed under the Apache-2.0 license or a
    }
     * {@code ANNOTATED_PREDICATE} operator name — the {@code annotationId} / {@code viableBackends}
    private final int annotationId;  
    private static final SqlOperator ANNOTATED_PREDICATE_OP = new SqlOperator(
        public SqlSyntax getSyntax() {
        this.original = original;
 * The OpenSearch Contributors require contributions made to  
 *
    public AnnotatedPredicate(RelDataType type, RexNode original, List<String> viableBackends, int annotationId) {
 * During planning: carries which backends can evaluate this predicate.  
        return new AnnotatedPredicate(type, original, List.of(backend), annotationId, peers);
        this.viableBackends = viableBackends;  
        null,
        super(type, ANNOTATED_PREDICATE_OP, List.of(original));
    @Override  
/**
 */  
            + ", backends="
    }
            + original  
    }  
    public int getAnnotationId() {  
/*  
        RexNode original,
     * walks (e.g. {@code IndexRemapShuttle} during the QTF rewriter's narrowed-Scan rebuild)
    /**
 */
     * Empty when the predicate is single-viable (no peer to consult) or hasn't  
import org.apache.calcite.sql.SqlOperator;  
        return original;
     * per-RG when the driving backend's own pruning isn't selective enough.  
            return SqlSyntax.FUNCTION;  
public class AnnotatedPredicate extends RexCall implements OperatorAnnotation {
     * Peer backends that could have evaluated this predicate but lost the narrow.
     * this override, {@code RexCall.clone} returns a plain {@code RexCall} carrying only the  
    /**
        0,
     */
 * Custom RexNode wrapping an original predicate with backend routing metadata.
            : List.of();
     * returning the decision. Needs revisiting.
    public RexNode withAdaptedOriginal(RexNode adaptedOriginal) {
     * peers for opportunistic consultation at runtime.  
import org.apache.calcite.sql.SqlSyntax;
    @Override  
            + ")";
    ) {  
import org.opensearch.analytics.spi.DelegatedPredicateFunction;  
    }
            + ", "
    public OperatorAnnotation narrowTo(String backend) {
     * been narrowed yet. Non-empty when the predicate was dual-viable AND was
    }
            throw new IllegalArgumentException(  
import org.apache.calcite.rex.RexBuilder;
        return "ANNOTATED_PREDICATE(id="  
    @Override
 * compatible open source license.
    public List<String> getPerformanceDelegationBackends() {
     */
        ReturnTypes.BOOLEAN,  
        return new AnnotatedPredicate(type, adaptedOriginal, viableBackends, annotationId, performanceDelegationBackends);  
        this.performanceDelegationBackends = performanceDelegationBackends;
import java.util.List;
    }  
        "ANNOTATED_PREDICATE",
        SqlKind.OTHER_FUNCTION,  
        if (operands.size() != 1) {
    private AnnotatedPredicate(  
                "AnnotatedPredicate must wrap exactly one operand (the original predicate); got " + operands.size()
     * Peer backends valid for opportunistic consultation. Empty unless this predicate
        List<String> peers = (viableBackends.size() > 1 && viableBackends.contains(backend))
        }  
     * predicate for. The driving backend wraps with
    public RexNode makePlaceholder(RexBuilder rexBuilder) {
    }
    @Override  
 *
    @Override
        null
     * <p>NOTE: temp workaround — derived in {@link #narrowTo(String)} from the
    private final List<String> performanceDelegationBackends;  
    @Override
        return original;  
            );
        return new AnnotatedPredicate(type, operands.get(0), viableBackends, annotationId, performanceDelegationBackends);
            ? viableBackends.stream().filter(b -> !b.equals(backend)).toList()  
     * candidates ({@code !isEmpty()}) and (b) to pick the peer to serialize the  
     * was dual-viable and was narrowed onto one of its viable backends.  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.calcite.rex.RexCall;  
        int annotationId,
     */
        RelDataType type,
        @Override
package org.opensearch.analytics.planner.rel;
     *
    public RexNode unwrap() {  
     *
    /**
