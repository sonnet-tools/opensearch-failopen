            Set<WindowCapability> caps = context.getCapabilityRegistry().getBackend(backend).getCapabilityProvider().windowCapabilities();
import org.opensearch.analytics.spi.ScalarFunction;
        List<String> viable = registry.opaqueBackendsAnyFormat(funcName);
 *
                    WindowFunction fn = WindowFunction.resolveFunction(over.getAggOperator());
                .filter(e -> e instanceof RexCall)
 * either natively or via delegation ({@link DelegationType#PROJECT}).
                if (cap.functions().containsAll(required)) {
            return List.of();
                if (operandType != null) {
        List<RexNode> newOperands = new ArrayList<>(rexCall.getOperands().size());
        List<String> out = new ArrayList<>();
    private boolean hasFieldRef(RexNode node) {
            }
                    continue;
        Project project = call.rel(0);
                child.getTraitSet(),
import org.opensearch.analytics.planner.UnsupportedFunctionException;
        if (out.isEmpty()) {
    private List<String> resolveOpaqueViableBackends(String funcName, List<String> childViableBackends) {
            boolean canHandleAll = true;
            return;
        call.transformTo(
                }
        if (!(expr instanceof RexCall rexCall)) {
        }
        List<String> result = new ArrayList<>();
            ? registry.scalarBackendsAnyFormat(scalarFunc, fieldType)
    }
        // Narrow viable backends to those whose WindowCapability declares every RexOver function used.
                    return super.visitOver(over);
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
            throw new UnsupportedFunctionException(required.toString(), "as window functions");
                result.add(candidateName);
                return new AnnotatedProjectExpression(rexCall.getType(), rexCall, exprViable, context.nextAnnotationId());
                continue;
        Set<WindowFunction> requiredWindowFns = collectWindowFunctions(project.getProjects());
 * SPDX-License-Identifier: Apache-2.0
        }
            .anyMatch(
            }
import org.opensearch.analytics.planner.CapabilityRegistry;
            viableBackends = narrowByWindowCapability(viableBackends, requiredWindowFns);
    }
        // either it's in viable itself (native), or it can delegate to one that accepts
        FieldType fieldType = FieldType.fromSqlTypeName(rexCall.getType().getSqlTypeName());
        // operand's type. The scalar function's backend capabilities are defined over operand
        List<String> viable = new ArrayList<>();
 */
            return viable;
import org.apache.calcite.rel.core.Project;
    }
     *  on RexOver-bearing projects guarantees PARTITION BY / ORDER BY see fully-gathered input. */
            if (annotated != operand) {
            // Revisit if delegation requires knowing which backend evaluates each expression
                    break;
    /** Collects {@link WindowFunction}s used by any {@link RexOver} in {@code exprs}.
 * Converts {@link Project} → {@link OpenSearchProject}.
        this.context = context;
        for (String candidateName : childViableBackends) {
        List<String> delegationAcceptors = registry.delegationAcceptors(DelegationType.PROJECT);
        // Note: if JMH benchmarks show this as a hotspot, consider (a) precomputing a
            // scalar path (RexOver's aggregate operator is not a scalar function). Leave the
                viableBackends
import org.apache.calcite.rex.RexCall;
        // preserves correct backend dispatch while deferring actual type-tightening until the
            RexNode annotated = annotateExpr(operand, childViableBackends);
        }
        // backend's ScalarFunctionAdapter rewrites the call to a typed library operator.
            // by whichever backend executes the operator (pass-through for refs, constant for literals).
package org.opensearch.analytics.planner.rules;
                }
                @Override
 * The OpenSearch Contributors require contributions made to
                    viable.add(backendName);
        if (scalarViable.isEmpty()) {
        RexCall target = changed ? rexCall.clone(rexCall.getType(), newOperands) : rexCall;
        for (RexNode expr : project.getProjects()) {
        return viable;
 * @opensearch.internal
    private final PlannerContext context;
        // Opaque operations — no recursion into operands
import org.apache.calcite.rex.RexNode;
        List<String> allCapable = hasFieldRef(rexCall)
            return List.of();
                    fns.add(fn);
            for (WindowCapability cap : caps) {
            : childViableBackends;
            throw new UnsupportedFunctionException(label, "as a scalar function");
                viable.add(candidateName);
        }
        // At least one child viable backend must be able to reach an evaluator:
        boolean reachable = childViableBackends.stream()
            }
        if (fieldType == null) {
            // TODO: RexInputRef and RexLiteral are left unannotated — they are implicitly handled
            RexNode annotated = annotateExpr(expr, childViableBackends);
        boolean changed = false;
        }
                }
            if (covers) out.add(backend);
import org.apache.calcite.rex.RexOver;
        }
import org.opensearch.analytics.planner.rel.OpenSearchProject;
    }
            throw new IllegalStateException("Project rule encountered unmarked child [" + child.getClass().getSimpleName() + "]");
        // All scalar operators (including arithmetic, CAST, null-handling, conditional,
        return reachable ? viable : List.of();
        for (String backend : candidates) {
            newOperands.add(annotated);
    private List<String> narrowByWindowCapability(List<String> candidates, Set<WindowFunction> required) {
import org.apache.calcite.sql.SqlFunction;
        }
        }
    }
        List<String> childViableBackends = openSearchChild.getViableBackends();
import org.apache.calcite.rel.RelNode;
                if (!(expr instanceof AnnotatedProjectExpression annotation)) {
            // RexOver as-is so substrait conversion receives the unwrapped shape.
        List<String> viableBackends = requiresBackendCapabilityEvaluation
        super(operand(Project.class, operand(RelNode.class, any())), "OpenSearchProjectRule");
        if (!(child instanceof OpenSearchRelNode openSearchChild)) {
        // a backend that can (supports PROJECT delegation to an acceptor in expression's viableBackends)
        List<String> scalarViable = resolveScalarViableBackends(rexCall, childViableBackends);
import org.apache.calcite.plan.RelOptRule;
                    && annotation.getViableBackends().stream().anyMatch(delegationAcceptors::contains);
    public void onMatch(RelOptRuleCall call) {
        List<RexNode> annotatedExprs = new ArrayList<>(project.getProjects().size());
        }
 *
            // independently, or if a backend cannot handle pass-through refs natively.
            }
        List<String> delegationSupporters = registry.delegationSupporters(DelegationType.PROJECT);
            return expr;
        }
            )
        if (project instanceof OpenSearchProject) {
        for (RexNode operand : rexCall.getOperands()) {
    @Override
            new OpenSearchProject(
            return viable;
            }
            ? computeProjectViableBackends(annotatedExprs, childViableBackends)
public class OpenSearchProjectRule extends RelOptRule {
                .toList();
        return context.getCapabilityRegistry().isOpaqueOperation(funcName);
        if (scalarFunc == null) {
                if (!canDelegate) {
            );
        if (!requiredWindowFns.isEmpty()) {
            throw new UnsupportedFunctionException(funcNames.toString(), "in combination in this query");
            annotatedExprs.add(annotated);
                candidateName -> viable.contains(candidateName)
        // "Standard scalar function" path below so nested operators get their own annotations.
        List<String> delegationAcceptors = registry.delegationAcceptors(DelegationType.PROJECT);
            // Window functions are narrowed separately by narrowByWindowCapability — skip the
        ScalarFunction scalarFunc = ScalarFunction.fromSqlOperatorWithFallback(rexCall.getOperator());
        for (String candidateName : childViableBackends) {
import org.opensearch.analytics.spi.FieldType;
    }
        // SqlKind → viable backends map once per onMatch() call, and (b) returning
        if (childViableBackends.stream().anyMatch(delegationSupporters::contains)) {
                }
import org.opensearch.analytics.spi.DelegationType;
    /** Keep backends whose {@link WindowCapability} covers every {@link WindowFunction} used. */
                    break;
                changed = true;
            if (!projectCapable.contains(candidateName)) {
        CapabilityRegistry registry = context.getCapabilityRegistry();
                public RexNode visitOver(RexOver over) {
                }
        if (viableBackends.isEmpty()) {
                annotatedExprs,
/*
        }
                }
        for (RexNode expr : exprs) {
                    fieldType = operandType;
            }
/**
        if (node instanceof RexCall rexCall) {
        }
 * compatible open source license.
        }
        if (viable.isEmpty()) {
            });
        // logical connectives) go through the capability registry. Operands recurse via the
        // types anyway (SCALAR_MAX(double, double, ...) → DOUBLE), so inferring from operands
    public OpenSearchProjectRule(PlannerContext context) {
            }
import java.util.Set;
        if (fieldType == null) {
                    || (delegationSupporters.contains(candidateName) && viable.stream().anyMatch(delegationAcceptors::contains))
        }
        // Passthrough projection: no RexCall to evaluate, so any child backend can emit it.
                project.getCluster(),
        return out;
            }
        // directly. When a viability check for such a call lands here, fall back to the first
                RelNodeUtils.unwrapHep(project.getInput()),
            if (canHandleAll) {
                    continue;
        RelNode child = call.rel(1);
                    throw new UnsupportedFunctionException(funcName, null);
 * this file be licensed under the Apache-2.0 license or a
        Set<WindowFunction> fns = new LinkedHashSet<>();
            if (allCapable.contains(candidateName)) {
        // childViableBackends directly when all candidates pass to avoid allocation.
                    break;
            }
    private boolean isOpaqueOperation(String funcName) {
            }
        if (node instanceof RexInputRef) return true;
        CapabilityRegistry registry = context.getCapabilityRegistry();
        List<String> delegationSupporters = registry.delegationSupporters(DelegationType.PROJECT);
 * <p>Validates that the child's backend can evaluate all projection expressions,
            ScalarFunction resolved = ScalarFunction.fromSqlOperatorWithFallback(rexCall.getOperator());
        List<String> delegationSupporters = registry.delegationSupporters(DelegationType.PROJECT);
        // Polymorphic UDF fallback: Calcite UDFs with indeterminate return types (SqlTypeName.ANY)
import org.apache.calcite.plan.RelOptRuleCall;
import java.util.ArrayList;
import org.opensearch.analytics.planner.RelNodeUtils;
                    covers = true;
            expr.accept(new org.apache.calcite.rex.RexShuttle() {
    }
        }
        // — e.g. PPL's ScalarMaxFunction / ScalarMinFunction — do not map to a concrete FieldType
import java.util.LinkedHashSet;
    }
        }
            for (String backendName : allCapable) {
    private static Set<WindowFunction> collectWindowFunctions(List<? extends RexNode> exprs) {
                if (delegationAcceptors.contains(backendName)) {
                }
                if (exprViable.isEmpty()) {
                    if (fn == null) {
}
            List<String> funcNames = annotatedExprs.stream()
            boolean covers = false;
                requiresBackendCapabilityEvaluation = true;
            if (isOpaqueOperation(funcName)) {
     *  Unrecognized window SqlKinds (LAG, LEAD, NTILE, etc.) fail here. The SINGLETON cost gate
        );
                        throw new UnsupportedFunctionException(over.getAggOperator().getName(), "as a window function");
                FieldType operandType = FieldType.fromSqlTypeName(operand.getType().getSqlTypeName());
import org.opensearch.analytics.spi.WindowFunction;
                    }
                }
            String funcName = sqlFunction.getName();
        // Standard scalar function
import org.opensearch.analytics.planner.rel.AnnotatedProjectExpression;
    }
        if (!viable.isEmpty()) {
                project.getRowType(),
        CapabilityRegistry registry = context.getCapabilityRegistry();
            for (RexNode expr : annotatedExprs) {
import org.opensearch.analytics.spi.WindowCapability;
        return false;
        List<String> projectCapable = new ArrayList<>(registry.projectCapableBackends());
        // either evaluate natively (present in expression's viableBackends) or delegate to
        }
        }
        return fns;
            return expr;
            for (RexNode operand : rexCall.getOperands()) {
    }
        boolean requiresBackendCapabilityEvaluation = false;
 *
                if (hasFieldRef(operand)) return true;
        List<String> delegationAcceptors = registry.delegationAcceptors(DelegationType.PROJECT);
                .map(e -> ((RexCall) e).getOperator().getName())
 */
        return result;
        if (rexCall.getOperator() instanceof SqlFunction sqlFunction) {
    private List<String> resolveScalarViableBackends(RexCall rexCall, List<String> childViableBackends) {
    private List<String> computeProjectViableBackends(List<RexNode> annotatedExprs, List<String> childViableBackends) {
            String label = resolved != null ? resolved.name() : rexCall.getOperator().getName();
import java.util.List;
        }
            : registry.literalScalarBackends(scalarFunc, fieldType);
                List<String> exprViable = resolveOpaqueViableBackends(funcName, childViableBackends);
            if (annotated instanceof AnnotatedProjectExpression) {
                boolean canDelegate = delegationSupporters.contains(candidateName)
                    canHandleAll = false;
        }
        // A child viable backend is viable for the project if for every expression it can
        if (expr instanceof RexOver) {
    private RexNode annotateExpr(RexNode expr, List<String> childViableBackends) {
        return new AnnotatedProjectExpression(target.getType(), target, scalarViable, context.nextAnnotationId());
        }
import org.apache.calcite.rex.RexInputRef;
        // Recurse into operands
                if (annotation.getViableBackends().contains(candidateName)) {
            }
import org.opensearch.analytics.planner.PlannerContext;
        }
            for (RexNode operand : rexCall.getOperands()) {
