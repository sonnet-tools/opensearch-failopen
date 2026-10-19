        List<String> delegationSupporters = registry.delegationSupporters(DelegationType.PROJECT);
        super(operand(Project.class, operand(RelNode.class, any())), "OpenSearchProjectRule");
                child.getTraitSet(),
import java.util.Set;
                }
                List<String> exprViable = resolveOpaqueViableBackends(funcName, childViableBackends);
import org.apache.calcite.rel.RelNode;  
        if (fieldType == null) {  
            if (covers) out.add(backend);
            throw new IllegalStateException("Project rule encountered unmarked child [" + child.getClass().getSimpleName() + "]");
                .filter(e -> e instanceof RexCall)
 * The OpenSearch Contributors require contributions made to  
        }  
            ? computeProjectViableBackends(annotatedExprs, childViableBackends)  
package org.opensearch.analytics.planner.rules;
import org.apache.calcite.plan.RelOptRule;
            annotatedExprs.add(annotated);
                if (cap.functions().containsAll(required)) {  
/**
        // A child viable backend is viable for the project if for every expression it can
                    covers = true;
                result.add(candidateName);
            for (WindowCapability cap : caps) {
        CapabilityRegistry registry = context.getCapabilityRegistry();  
import org.apache.calcite.sql.SqlFunction;  
        // "Standard scalar function" path below so nested operators get their own annotations.
        if (!(expr instanceof RexCall rexCall)) {  
            }
    }  
                if (annotation.getViableBackends().contains(candidateName)) {
        if (rexCall.getOperator() instanceof SqlFunction sqlFunction) {
        }
import org.opensearch.analytics.planner.rel.OpenSearchProject;  
    }  
    }
    }
        List<String> result = new ArrayList<>();  
                if (operandType != null) {  
    private List<String> resolveScalarViableBackends(RexCall rexCall, List<String> childViableBackends) {
        List<String> scalarViable = resolveScalarViableBackends(rexCall, childViableBackends);
        }  
                    break;  
                    break;
                FieldType operandType = FieldType.fromSqlTypeName(operand.getType().getSqlTypeName());
        if (project instanceof OpenSearchProject) {
        // either it's in viable itself (native), or it can delegate to one that accepts  
        // Polymorphic UDF fallback: Calcite UDFs with indeterminate return types (SqlTypeName.ANY)
        Project project = call.rel(0);
                if (!(expr instanceof AnnotatedProjectExpression annotation)) {
    /** Collects {@link WindowFunction}s used by any {@link RexOver} in {@code exprs}.
import org.opensearch.analytics.spi.DelegationType;
        for (RexNode expr : project.getProjects()) {
                viableBackends  
            boolean canHandleAll = true;  
        if (viableBackends.isEmpty()) {  
        List<String> projectCapable = new ArrayList<>(registry.projectCapableBackends());
            return expr;
                changed = true;  
        List<RexNode> annotatedExprs = new ArrayList<>(project.getProjects().size());  
                viable.add(candidateName);  
        if (childViableBackends.stream().anyMatch(delegationSupporters::contains)) {
        List<String> delegationAcceptors = registry.delegationAcceptors(DelegationType.PROJECT);
            }
                }
        boolean reachable = childViableBackends.stream()  
                    throw new UnsupportedFunctionException(funcName, null);  
                    WindowFunction fn = WindowFunction.resolveFunction(over.getAggOperator());
                requiresBackendCapabilityEvaluation = true;  
            )
        List<String> out = new ArrayList<>();
        }  
            if (allCapable.contains(candidateName)) {
                    fieldType = operandType;
import org.apache.calcite.rex.RexCall;
        // childViableBackends directly when all candidates pass to avoid allocation.
                return new AnnotatedProjectExpression(rexCall.getType(), rexCall, exprViable, context.nextAnnotationId());
                }
import org.opensearch.analytics.spi.FieldType;  
            ? registry.scalarBackendsAnyFormat(scalarFunc, fieldType)  
            viableBackends = narrowByWindowCapability(viableBackends, requiredWindowFns);  
import java.util.List;
        for (RexNode operand : rexCall.getOperands()) {
        if (scalarFunc == null) {
            // TODO: RexInputRef and RexLiteral are left unannotated — they are implicitly handled
        }
                public RexNode visitOver(RexOver over) {
    private List<String> resolveOpaqueViableBackends(String funcName, List<String> childViableBackends) {
    private RexNode annotateExpr(RexNode expr, List<String> childViableBackends) {
    private final PlannerContext context;
                    return super.visitOver(over);
    }  
            .anyMatch(
        // backend's ScalarFunctionAdapter rewrites the call to a typed library operator.
 * either natively or via delegation ({@link DelegationType#PROJECT}).
            : registry.literalScalarBackends(scalarFunc, fieldType);
                RelNodeUtils.unwrapHep(project.getInput()),  
        if (scalarViable.isEmpty()) {
            // by whichever backend executes the operator (pass-through for refs, constant for literals).
     *  Unrecognized window SqlKinds (LAG, LEAD, NTILE, etc.) fail here. The SINGLETON cost gate  
        List<String> delegationSupporters = registry.delegationSupporters(DelegationType.PROJECT);  
        // logical connectives) go through the capability registry. Operands recurse via the  
            List<String> funcNames = annotatedExprs.stream()
        List<String> viable = new ArrayList<>();  
            : childViableBackends;
import org.opensearch.analytics.spi.WindowFunction;  
        List<String> delegationSupporters = registry.delegationSupporters(DelegationType.PROJECT);  
        for (RexNode expr : exprs) {
                    viable.add(backendName);
        return fns;
        return reachable ? viable : List.of();
import org.apache.calcite.rex.RexInputRef;  
                    && annotation.getViableBackends().stream().anyMatch(delegationAcceptors::contains);  
        List<String> delegationAcceptors = registry.delegationAcceptors(DelegationType.PROJECT);
        List<String> childViableBackends = openSearchChild.getViableBackends();
        }
        }  
        RelNode child = call.rel(1);  
    private List<String> computeProjectViableBackends(List<RexNode> annotatedExprs, List<String> childViableBackends) {
            RexNode annotated = annotateExpr(expr, childViableBackends);  
import org.apache.calcite.rex.RexNode;
    }
            throw new UnsupportedFunctionException(funcNames.toString(), "in combination in this query");
    }  
    private boolean hasFieldRef(RexNode node) {  
        ScalarFunction scalarFunc = ScalarFunction.fromSqlOperatorWithFallback(rexCall.getOperator());  
            }
            );
                if (!canDelegate) {
        }
                @Override  
        if (!(child instanceof OpenSearchRelNode openSearchChild)) {  
                    canHandleAll = false;
            for (RexNode operand : rexCall.getOperands()) {
 * this file be licensed under the Apache-2.0 license or a
                }  
                if (exprViable.isEmpty()) {
            }
        for (String candidateName : childViableBackends) {
        }
            // RexOver as-is so substrait conversion receives the unwrapped shape.  
    }
import java.util.LinkedHashSet;  
            for (RexNode expr : annotatedExprs) {
            if (annotated instanceof AnnotatedProjectExpression) {
        boolean requiresBackendCapabilityEvaluation = false;
            if (canHandleAll) {  
import org.opensearch.analytics.planner.RelNodeUtils;  
        // a backend that can (supports PROJECT delegation to an acceptor in expression's viableBackends)
        // SqlKind → viable backends map once per onMatch() call, and (b) returning
        }  
    public OpenSearchProjectRule(PlannerContext context) {
            newOperands.add(annotated);
            for (String backendName : allCapable) {  
            // scalar path (RexOver's aggregate operator is not a scalar function). Leave the
        // either evaluate natively (present in expression's viableBackends) or delegate to  
        FieldType fieldType = FieldType.fromSqlTypeName(rexCall.getType().getSqlTypeName());
        // At least one child viable backend must be able to reach an evaluator:
    }  
 * Converts {@link Project} → {@link OpenSearchProject}.
import org.opensearch.analytics.planner.rel.AnnotatedProjectExpression;
                    }
                continue;
            throw new UnsupportedFunctionException(label, "as a scalar function");
        RexCall target = changed ? rexCall.clone(rexCall.getType(), newOperands) : rexCall;
        // directly. When a viability check for such a call lands here, fall back to the first
import org.opensearch.analytics.planner.PlannerContext;
        // All scalar operators (including arithmetic, CAST, null-handling, conditional,
import org.opensearch.analytics.planner.UnsupportedFunctionException;
import org.apache.calcite.plan.RelOptRuleCall;
        }
     *  on RexOver-bearing projects guarantees PARTITION BY / ORDER BY see fully-gathered input. */
 * <p>Validates that the child's backend can evaluate all projection expressions,
            throw new UnsupportedFunctionException(required.toString(), "as window functions");
    }
}  
            expr.accept(new org.apache.calcite.rex.RexShuttle() {
    public void onMatch(RelOptRuleCall call) {
            if (!projectCapable.contains(candidateName)) {  
        if (node instanceof RexCall rexCall) {
                project.getRowType(),
        return new AnnotatedProjectExpression(target.getType(), target, scalarViable, context.nextAnnotationId());
            // Window functions are narrowed separately by narrowByWindowCapability — skip the
                    fns.add(fn);  
    /** Keep backends whose {@link WindowCapability} covers every {@link WindowFunction} used. */
            for (RexNode operand : rexCall.getOperands()) {  
                    || (delegationSupporters.contains(candidateName) && viable.stream().anyMatch(delegationAcceptors::contains))  
public class OpenSearchProjectRule extends RelOptRule {  
import org.opensearch.analytics.planner.CapabilityRegistry;
        this.context = context;  
        if (fieldType == null) {  
            return List.of();
            return expr;
                        throw new UnsupportedFunctionException(over.getAggOperator().getName(), "as a window function");
        List<String> delegationAcceptors = registry.delegationAcceptors(DelegationType.PROJECT);
        }  
        }
                    continue;  
            String funcName = sqlFunction.getName();
                }  
                candidateName -> viable.contains(candidateName)
            RexNode annotated = annotateExpr(operand, childViableBackends);  
        return viable;  
        CapabilityRegistry registry = context.getCapabilityRegistry();
        boolean changed = false;  
 */
    private List<String> narrowByWindowCapability(List<String> candidates, Set<WindowFunction> required) {  
        List<String> viable = registry.opaqueBackendsAnyFormat(funcName);
                .map(e -> ((RexCall) e).getOperator().getName())  
        // Standard scalar function  
        }
                    continue;  
                }  
import org.opensearch.analytics.spi.ScalarFunction;
            }
            new OpenSearchProject(  
 *
            Set<WindowCapability> caps = context.getCapabilityRegistry().getBackend(backend).getCapabilityProvider().windowCapabilities();  
                project.getCluster(),
        Set<WindowFunction> fns = new LinkedHashSet<>();  
        List<String> allCapable = hasFieldRef(rexCall)
 * SPDX-License-Identifier: Apache-2.0
        // types anyway (SCALAR_MAX(double, double, ...) → DOUBLE), so inferring from operands  
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
            }
                boolean canDelegate = delegationSupporters.contains(candidateName)
            String label = resolved != null ? resolved.name() : rexCall.getOperator().getName();
        for (String candidateName : childViableBackends) {
        return false;
        return out;
            return viable;
        return context.getCapabilityRegistry().isOpaqueOperation(funcName);
            return List.of();
    private boolean isOpaqueOperation(String funcName) {
            return viable;  
        if (!viable.isEmpty()) {  
        List<String> viableBackends = requiresBackendCapabilityEvaluation
        if (viable.isEmpty()) {
            ScalarFunction resolved = ScalarFunction.fromSqlOperatorWithFallback(rexCall.getOperator());  
        }
        CapabilityRegistry registry = context.getCapabilityRegistry();
 *  
        return result;
        Set<WindowFunction> requiredWindowFns = collectWindowFunctions(project.getProjects());
        }  
                annotatedExprs,
        );
            if (annotated != operand) {
        // Passthrough projection: no RexCall to evaluate, so any child backend can emit it.
        // Narrow viable backends to those whose WindowCapability declares every RexOver function used.  
        if (!requiredWindowFns.isEmpty()) {
        }
        if (expr instanceof RexOver) {  
            // Revisit if delegation requires knowing which backend evaluates each expression  
        // Opaque operations — no recursion into operands  
                .toList();
        List<RexNode> newOperands = new ArrayList<>(rexCall.getOperands().size());
    @Override  
import java.util.ArrayList;
        }
            });  
        // operand's type. The scalar function's backend capabilities are defined over operand
        // preserves correct backend dispatch while deferring actual type-tightening until the
 *  
 */  
import org.opensearch.analytics.spi.WindowCapability;
                    break;
        // Note: if JMH benchmarks show this as a hotspot, consider (a) precomputing a  
        // Recurse into operands
        for (String backend : candidates) {
        call.transformTo(
import org.apache.calcite.rel.core.Project;
            if (isOpaqueOperation(funcName)) {  
        }
            }
                if (hasFieldRef(operand)) return true;
        }
 * compatible open source license.
                }
            return;  
                if (delegationAcceptors.contains(backendName)) {
/*  
        if (out.isEmpty()) {
            }
    private static Set<WindowFunction> collectWindowFunctions(List<? extends RexNode> exprs) {
        }  
            }
            }
 * @opensearch.internal
        if (node instanceof RexInputRef) return true;
            boolean covers = false;
            // independently, or if a backend cannot handle pass-through refs natively.
            }  
        }
                }
import org.apache.calcite.rex.RexOver;
                    if (fn == null) {  
        // — e.g. PPL's ScalarMaxFunction / ScalarMinFunction — do not map to a concrete FieldType  
