import org.apache.calcite.rel.RelHomogeneousShuttle;
            }  
     * Returns a new tree if any rewrite occurred, otherwise the input unchanged.  
import org.apache.calcite.sql.type.SqlTypeName;  
            // Recurse first so nested CASE calls are rewritten bottom-up — each inner CASE is  
 * <pre>{@code
 * a concrete test surfaces one.
            this.rexBuilder = rexBuilder;
 * {@code CASE WHEN cond THEN val END}, which is exactly the shape PPL
        private final RexBuilder rexBuilder;
        public RexNode visitCall(RexCall call) {
                RexNode op = operands.get(i);
    }
/**
         * a value. Returns true for value operands (the THEN/ELSE arms).
 * for the count-eval shape, etc), so we substitute that.  
 * with {@code "Unable to convert the type NULL"}. The CASE call's resolved
                    changed = true;
    }
import org.apache.calcite.rex.RexShuttle;
     */
            List<RexNode> operands = recursed.getOperands();
         */
        }
 * compatible open source license.
 * inferred from their enclosing operator.
 */  
        @Override
 *
            public RelNode visit(RelNode other) {
                return recursed;
 * SPDX-License-Identifier: Apache-2.0
        private static boolean isCaseValueOperand(int index, int total) {  
            return changed ? recursed.clone(recursed.getType(), rewritten) : recursed;
            RexCall recursed = (RexCall) super.visitCall(call);  
     * Walk the RelNode tree, applying the rewrite to every node's expressions.
         * Calcite's CASE operand layout is {@code [cond1, val1, cond2, val2, …, condN, valN, else]}.
                RelNode visited = super.visit(other);  
import org.apache.calcite.rex.RexCall;
import org.apache.calcite.rex.RexLiteral;
        }
    /**
            boolean changed = false;  
import java.util.ArrayList;
 * ({@code RexLiteral} with {@link SqlTypeName#NULL}) to typed null literals
/*  
            if (!(node instanceof RexLiteral lit)) {
 * <p>Calcite emits an untyped NULL for the implicit {@code ELSE} arm of
    /**  
 *
        }  
            for (int i = 0; i < operands.size(); i++) {
    static RelNode rewrite(RelNode root) {
            if (recursed.getKind() != SqlKind.CASE) {
 * sites (function arguments, comparison RHS, etc) are rare in PPL-generated  
 *
 * plans and would need per-operator type-inference to do safely; defer until
            @Override
        private static boolean isUntypedNullLiteral(RexNode node) {
                }
 * }</pre>
        }
        });  
                return false;  
import java.util.List;  
import org.apache.calcite.rel.RelNode;
     * Per-node rex shuttle: for every {@code CASE} call encountered, rewrite any
            }  
import org.apache.calcite.sql.SqlKind;
                    rewritten.add(rexBuilder.makeNullLiteral(recursed.getType()));
            }
        CaseUntypedNullShuttle(RexBuilder rexBuilder) {  
    private UntypedNullPreprocessor() {}
 *
import org.apache.calcite.rex.RexNode;  
 * @opensearch.internal
            List<RexNode> rewritten = new ArrayList<>(operands.size());
final class UntypedNullPreprocessor {  
 */
            return lit.isNull() && lit.getType().getSqlTypeName() == SqlTypeName.NULL;
        /**
 * this file be licensed under the Apache-2.0 license or a
 *  
                } else {  
            // resolved against its own return type, so by the time we look at the outer one,
     * matching the CASE's resolved return type.  
package org.opensearch.be.datafusion;
                return visited.accept(new CaseUntypedNullShuttle(visited.getCluster().getRexBuilder()));
 * <p>Isthmus' {@code TypeConverter.toSubstrait} rejects {@link SqlTypeName#NULL}  
            // every operand is already typed.
 *  
        return root.accept(new RelHomogeneousShuttle() {  
     */
 * {@code count(eval(predicate))} lowers to:  
 * <p>Scope: only CASE call operands are rewritten today. Other untyped-NULL
}
                    rewritten.add(op);
import org.apache.calcite.rex.RexBuilder;  
         * Conditions sit at even indices except the last operand (the ELSE), which is always  
     * {@link SqlTypeName#NULL}-typed literal operand into a typed null literal
 *   COUNT(CASE WHEN predicate THEN <projected> END)   // ELSE is implicit NULL, type=NULL  
 * return type already carries the right widened type ({@code NULLABLE BIGINT}
            return (index % 2 == 1) || (index == total - 1);
 * Pre-isthmus pass that rewrites untyped {@code NULL} literals  
                if (isCaseValueOperand(i, operands.size()) && isUntypedNullLiteral(op)) {  
    private static final class CaseUntypedNullShuttle extends RexShuttle {
            }
 * The OpenSearch Contributors require contributions made to  
