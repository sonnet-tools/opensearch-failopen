    @Override
    /**
    private final RexNode original;  
 * Wraps an opaque project expression (painless, highlight, etc.) with the
import org.apache.calcite.sql.SqlOperator;
 * The OpenSearch Contributors require contributions made to  
            return this;  
    public OperatorAnnotation narrowTo(String backend) {
        // shapes) and the adapter rewrote the call to a target with a concrete inferred  
 * are not split across viable backends like filter predicates.  
    @Override  
    }  
        RexNode newOriginal = operands.isEmpty() ? original : operands.get(0);
    }
        return original;  
        return original;
    }  
    @Override
        this.viableBackends = viableBackends;
 * if the delegation backend differs from the operator's primary backend.  
 * compatible open source license.
import java.util.List;
    }
        null
 * SPDX-License-Identifier: Apache-2.0
    public RexNode unwrap() {
/**  
    }  
        return "ANNOTATED_PROJECT_EXPR(id=" + annotationId + ", backends=" + viableBackends + ", " + original + ")";
        }  
     */
import org.apache.calcite.sql.SqlSyntax;  
        // type (DOUBLE for GREATEST(DOUBLE, DOUBLE), etc.), pick up the adapted
        public SqlSyntax getSyntax() {
}  
import org.apache.calcite.rex.RexCall;
        }
    /** Backends that can evaluate this expression. */  
    @Override
        0,
public class AnnotatedProjectExpression extends RexCall implements OperatorAnnotation {
        return viableBackends;
        return annotationId;
        "ANNOTATED_PROJECT_EXPR",
 * backend that will evaluate it. Always a single backend — project expressions
    private final int annotationId;
        @Override  
    protected String computeDigest(boolean withType) {  
    }
    public RexNode getOriginal() {
    private static final SqlOperator ANNOTATED_PROJECT_EXPR_OP = new SqlOperator(  
     * subclass, not the operator), leaving a {@code ANNOTATED_PROJECT_EXPR(...)} call in the
import org.apache.calcite.sql.SqlKind;
    @Override
    public List<String> getViableBackends() {
 */  
    @Override
 *
     * would then fail to recognize it as an annotation (because the pattern match is on the
 *
     * plan that isthmus cannot convert.  
        return new AnnotatedProjectExpression(resolvedType, adaptedOriginal, viableBackends, annotationId);
 *
        // When the wrapper's cached type is ANY (PPL polymorphic UDF — SCALAR_MAX,
        SqlKind.OTHER_FUNCTION,
import org.apache.calcite.rel.type.RelDataType;
     * {@link RexCall#clone(RelDataType, List)} would produce a plain {@code RexCall} with
 * @opensearch.internal
        0,  
    public RexNode withAdaptedOriginal(RexNode adaptedOriginal) {  
 */  
import org.apache.calcite.sql.type.SqlTypeName;
     * default implementation clones this call with updated operands. Without this override,
    private final List<String> viableBackends;
        // SCALAR_MIN, etc. declare ANY return because they accept heterogeneous operand
        RelDataType resolvedType = type.getSqlTypeName() == SqlTypeName.ANY ? adaptedOriginal.getType() : type;
import org.apache.calcite.sql.type.ReturnTypes;
     * {@link #ANNOTATED_PROJECT_EXPR_OP} as its operator — downstream {@code stripAnnotations}  
    public int getAnnotationId() {  
        return new AnnotatedProjectExpression(type, original, List.of(backend), annotationId);  
        if (newOriginal == original && type == this.type) {
    public AnnotatedProjectExpression(RelDataType type, RexNode original, List<String> viableBackends, int annotationId) {
 * <p>During fragment conversion this becomes a {@code DelegatedBackendPlan}
            return SqlSyntax.FUNCTION;
        return new AnnotatedProjectExpression(type, newOriginal, viableBackends, annotationId);
    }
    }  
        null,  
/*  
        super(type, ANNOTATED_PROJECT_EXPR_OP, List.of(original));
        // expression's type so downstream rowType derivation produces a Substrait-
        ReturnTypes.ARG0,
        // serialisable schema instead of carrying ANY through to isthmus's TypeConverter.  
     * Preserves subclass identity when {@link org.apache.calcite.rex.RexShuttle#visitCall}'s  
    ) {
import org.apache.calcite.rex.RexNode;  
package org.opensearch.analytics.planner.rel;
        this.annotationId = annotationId;
    public RexCall clone(RelDataType type, List<RexNode> operands) {  
    }  
 * this file be licensed under the Apache-2.0 license or a
        this.original = original;  
    };
