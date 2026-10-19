        public Optional<Expression> visit(Expression.VarCharLiteral vcl, EmptyVisitationContext ctx) {  
import io.substrait.relation.Rel;
    static Plan rewrite(Plan plan) {
        // CASE string constants.
            roots.add(modified.isPresent() ? Plan.Root.builder().from(root).input(modified.get()).build() : root);
        // Rewrite expressions inside project expressions (where literals often appear)
                    .build()
    private SubstraitPlanPojoRewriter() {}
             * TODO: it may be better to have this as a LiteralAdapter that the BackendPlanAdapter applies globally, instead of doing this per rel type.  
package org.opensearch.be.datafusion;
                Project.builder()  
import io.substrait.expression.Expression;
     * Rel-level visitor. Handles structural rewrites (table name stripping) and delegates
        PlanExpressionVisitor(PlanRelVisitor relVisitor) {
                    .expressions(newExpressions != null ? newExpressions : oldExpressions)  
            List<Expression> oldExpressions = project.getExpressions();  
            if (newInput.isEmpty() && rewritten.isEmpty()) return Optional.empty();
import io.substrait.plan.Plan;
     */
 */
            for (int i = 0; i < oldExpressions.size(); i++) {  
 *
import java.util.List;
                    .condition(rewritten.orElse(filter.getCondition()))  
            List<Expression> newExpressions = null;
 * byte-identical. Sibling {@link SubstraitPlanProtoRewriter} runs after this on the proto
                if (rewritten.isPresent()) {
                    .input(newInput.orElse(project.getInput()))
        public Optional<Rel> visit(io.substrait.relation.Filter filter, EmptyVisitationContext ctx) {
        List<Plan.Root> roots = new ArrayList<>();
            Optional<Rel> newInput = project.getInput().accept(this, ctx);
        private final PlanExpressionVisitor expressionVisitor = new PlanExpressionVisitor(this);  
        }
    }
import io.substrait.relation.ExpressionCopyOnWriteVisitor;
                    .from(filter)
            return Optional.of(
             */
import java.util.Optional;  
/**
 * POJO-layer Substrait plan rewriter. Rewrites {@code VarCharLiteral} → {@code StrLiteral}  
        for (Plan.Root root : plan.getRoots()) {
class SubstraitPlanPojoRewriter {  
                    changed = true;
        }
     * The base class handles recursion into function arguments, casts, if-then, etc.  
            super(relVisitor);
        @Override  
import io.substrait.util.EmptyVisitationContext;  
 *  
 * @opensearch.internal
    private static class PlanRelVisitor extends RelCopyOnWriteVisitor<RuntimeException> {
                Optional<Expression> rewritten = oldExpressions.get(i).accept(expressionVisitor, ctx);
    }  
            boolean changed = false;
import java.util.ArrayList;
import io.substrait.relation.RelCopyOnWriteVisitor;
        // VarChar → Str: DataFusion 53.1.0 errors on VarChar with "Unsupported literal_type"; the
 */  
                        newExpressions = new ArrayList<>(oldExpressions);
                    .input(newInput.orElse(filter.getInput()))
        // two are byte-identical for literals. Affects AddTotals labels, Chart/Trendline options,  
    /**
        public Optional<Rel> visit(Project project, EmptyVisitationContext ctx) {
    private static class PlanExpressionVisitor extends ExpressionCopyOnWriteVisitor<RuntimeException> {
            /**
import io.substrait.expression.ImmutableExpression;  
    /**  
import io.substrait.relation.Project;  
 * The OpenSearch Contributors require contributions made to  
     * Expression-level visitor. Override a {@code visit} method to add a new rewrite.
     */  
            Optional<Rel> newInput = filter.getInput().accept(this, ctx);
 * <p>TODO: remove this class once datafusion-substrait adds a VarCharLiteral arm to its consumer.
        }  
 * — DataFusion 53.1.0's consumer has no VarCharLiteral arm; the two literal types are
/*  
            );
        PlanRelVisitor visitor = new PlanRelVisitor();
            Optional<Expression> rewritten = filter.getCondition().accept(expressionVisitor, ctx);  
            if (newInput.isEmpty() && !changed) return Optional.empty();
                io.substrait.relation.Filter.builder()  
            }  
                    .build()
 * this file be licensed under the Apache-2.0 license or a
 * layer for fixes the POJO API can't express.  
 * compatible open source license.
 *
                }
            return Optional.of(
        // Rewrite expressions inside filter conditions
        @Override  
    }
                    newExpressions.set(i, rewritten.get());  
                    }
        }  
            );
            return Optional.of(ImmutableExpression.StrLiteral.builder().value(vcl.value()).nullable(vcl.nullable()).build());
        }  
        @Override
}
 * SPDX-License-Identifier: Apache-2.0
                    if (newExpressions == null) {  
            Optional<Rel> modified = root.getInput().accept(visitor, null);  
                    .from(project)
        return Plan.builder().from(plan).roots(roots).build();  
     * expression rewrites to {@link PlanExpressionVisitor}.
