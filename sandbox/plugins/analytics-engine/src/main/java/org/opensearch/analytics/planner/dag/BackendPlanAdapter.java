        if (node instanceof OpenSearchAggregate agg && agg.getMode() == AggregateMode.FINAL) {
        List<FieldStorageInfo> fieldStorage = filter.getOutputFieldStorage();
            adaptedOperands.add(adapted);
                newInput,
        }
 */
    private static RelNode adaptJoin(OpenSearchJoin join, Adapters adapters, List<RelNode> adaptedChildren, boolean childrenChanged) {
                adaptedProjects,
     *
        // Backend-specific rewrites (e.g. ARG_MIN→FIRST_VALUE). Adapter sees already-adapted operands.
     * Rebind a Project's expressions against a new input whose row type has shifted (typically
     */
        }
    }
import org.opensearch.analytics.spi.WindowFunction;
/**
            LOGGER.debug("After adaptation [{}]:\n{}", plan.backendId(), RelOptUtil.toString(fragment));
    private static RexNode adaptOver(
        for (int i = 0; i < projects.size(); i++) {
    }
        if (projectsChanged || childrenChanged) {
        if (function != null) {
            adaptedChildren.add(adaptedChild);
        for (RexNode key : window.partitionKeys) {
        RexWindow window = over.getWindow();
                right,
                windowChanged = true;
        }
        List<RexNode> adaptedOperands = new ArrayList<>(call.getOperands().size());
     * operator / operands / order keys into the backend's expected shape. Returns the original
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
import org.opensearch.analytics.planner.rel.OperatorAnnotation;
            projectsChanged = true;
            RexNode adapted = adaptRex(order.left, adapters, fieldStorage, cluster);
        List<StagePlan> adapted = new ArrayList<>(stage.getPlanAlternatives().size());
        RexCall current = operandsChanged ? call.clone(call.getType(), adaptedOperands) : call;
    /** Backend-provided adapter maps, bundled so helper signatures stay narrow. */
            }
        // PARTITION BY / ORDER BY expressions live on RexOver.window, not in getOperands(), so
        List<FieldStorageInfo> fieldStorage = join.getOutputFieldStorage();
import org.opensearch.analytics.planner.RelNodeUtils;
        for (RexNode operand : call.getOperands()) {
            adaptedPartitionKeys.add(adapted);
     * Calcite's FILTER_INTO_JOIN reach the fragment converter in their adapted shape.
        }
        for (RexNode projectExpr : project.getProjects()) {
            return adaptProject(project, adapters, adaptedChildren, childrenChanged);
import org.apache.logging.log4j.LogManager;
            return DistributedAggregateRewriter.rewrite(withAdaptedChildren);
        // them against the new input row type and CAST each projection back to the project's
        if (adapter != null) {
     * because adapters only inspect their <b>direct</b> operands via
import org.apache.calcite.rex.RexWindow;
            if (adapted != operand) operandsChanged = true;
            return node;
        if (node instanceof OperatorAnnotation annotation && annotation.unwrap() != null) {
     * {@link RexWindow}, not in {@code getOperands()}), then dispatch to the backend's
        if (adaptedCondition != join.getCondition() || childrenChanged) {
        ArrayList<RexNode> rebound = new ArrayList<>(projects.size());
import org.apache.calcite.plan.RelOptUtil;
            return new OpenSearchProject(
import org.apache.calcite.rex.RexShuttle;
                if (ref.getType().equals(actual)) return ref;
import java.util.List;
import org.opensearch.analytics.spi.WindowFunctionAdapter;
 * SPDX-License-Identifier: Apache-2.0
 *
 *
        }
     */
        return over;
        }
                adapted.add(plan);
                join.getCluster(),
            adaptedProjects = rebindProjectsAgainstInput(adaptedProjects, project, newInput);
     * RexOver unchanged when nothing under it changed and no adapter applies.
        RexShuttle rebind = new RexShuttle() {
 * provided by the driving backend. Runs between plan forking and fragment conversion.
        }
        boolean childrenChanged = false;
                RelDataType actual = newInputTypes.get(ref.getIndex());
        boolean operandsChanged = false;
                    window.getExclude(),
        ScalarFunction function = resolveFunction(current);
    /**
        List<RexFieldCollation> adaptedOrderKeys = new ArrayList<>(window.orderKeys.size());
 * This component looks up the adapter for each scalar function RexCall in the plan
import org.opensearch.analytics.spi.ScalarFunction;
    }
     * BIGINT). RexInputRefs get retyped to the new column types; projections that diverge from
        for (RelDataTypeField f : newInput.getRowType().getFieldList()) {
        RelNode newInput = childrenChanged ? adaptedChildren.getFirst() : project.getInput();
    private static RexNode adaptRex(RexNode node, Adapters adapters, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
        List<RexNode> adaptedOperands,
            if (adapter != null) {
        }
    private static ScalarFunction resolveFunction(RexCall call) {
            adaptStage(child, registry);
import org.apache.calcite.rel.type.RelDataTypeField;
 * <p>Each backend declares adapters keyed by {@link ScalarFunction} via
        RexOver over,
                project.getTraitSet(),
        return join;
        if (operandsChanged || windowChanged) {
            OpenSearchAggregate withAdaptedChildren = childrenChanged
import org.opensearch.analytics.planner.CapabilityRegistry;
     * which confirms {@code SIN(ABS($0))} with both adapted produces one CAST at the leaf.
        List<RexNode> projects,
        List<FieldStorageInfo> fieldStorage,
        return filter;
                filter.getTraitSet(),
        OpenSearchProject project,
        adaptStage(dag.rootStage(), registry);
                    over.getType(),
        Adapters adapters,
        }
    private static void adaptStage(Stage stage, CapabilityRegistry registry) {
        WindowFunctionAdapter adapter = fn == null ? null : adapters.window().get(fn);
        stage.setPlanAlternatives(adapted);
    }
        }
                adaptedOrderKeys.add(order);
     * <p>This ordering is validated by {@code testNestedAdaptedFunctionsProduceSingleCast}
        // adapter recursion has to descend through adaptOver to reach them.
    ) {
                    window.isRows(),
        RelNode left = childrenChanged ? adaptedChildren.get(0) : join.getLeft();
            newInputTypes.add(f.getType());
                    window.getLowerBound(),
     */
                    true,
                    window.getUpperBound(),
import org.apache.calcite.rex.RexCall;
            return new OpenSearchJoin(
            RelNode fragment = adaptNode(plan.resolvedFragment(), adapters);
import org.opensearch.analytics.planner.rel.AggregateMode;
        // Annotation wrappers: adapt the inner expression and re-wrap with same metadata.
        List<RelNode> adaptedChildren = new ArrayList<>(node.getInputs().size());
        // RexInputRef in project expressions references the input's row type
import org.apache.logging.log4j.Logger;
            var capabilityProvider = registry.getBackend(plan.backendId()).getCapabilityProvider();
package org.opensearch.analytics.planner.dag;
        }
        Adapters adapters,
    }
     * Adapts RexNodes bottom-up: operands are adapted before the call itself.
    /**
        List<RelDataType> newInputTypes = new ArrayList<>();
        RexNode adaptedCondition = adaptRex(filter.getCondition(), adapters, fieldStorage, filter.getCluster());
     * in nullability — e.g. FINAL aggregate's rewriter turned a NOT-NULL count into a nullable
        }
    private static RelNode adaptFilter(OpenSearchFilter filter, Adapters adapters, List<RelNode> adaptedChildren, boolean childrenChanged) {
    private static RelNode adaptProject(
                join.getViableBackends()
                project.getRowType(),
        OpenSearchProject originalProject,
        if (adaptedCondition != filter.getCondition() || childrenChanged) {
            }
            } else {
            rebound.add(expr);
            RexNode adapted = adaptRex(projectExpr, adapters, fieldStorage, project.getCluster());
            if (adaptedChild != child) childrenChanged = true;
            );
        }
            );
            RelDataType targetType = originalProject.getRowType().getFieldList().get(i).getType();
            if (adapted != projectExpr) projectsChanged = true;
            }
        List<RexNode> adaptedPartitionKeys = new ArrayList<>(window.partitionKeys.size());
    }
            return adaptFilter(filter, adapters, adaptedChildren, childrenChanged);
        if (node instanceof OpenSearchFilter filter) {
                join.getTraitSet(),
        WindowFunction fn = WindowFunction.resolveFunction(over.getAggOperator());
        }
     * Field storage is left ++ right output storage (Calcite join row-type ordering).
            adaptedProjects.add(adapted);
import org.opensearch.analytics.planner.rel.OpenSearchProject;
    }
        return childrenChanged ? node.copy(node.getTraitSet(), adaptedChildren) : node;
                    false,
    }
import org.opensearch.analytics.planner.rel.OpenSearchJoin;
            RexNode expr = projects.get(i).accept(rebind);
        for (Stage child : stage.getChildStages()) {
                return new RexInputRef(ref.getIndex(), actual);
 * and applies it if present.
            return new OpenSearchFilter(
public class BackendPlanAdapter {
import org.apache.calcite.rel.type.RelDataType;
     * {@link WindowFunctionAdapter} for this {@link WindowFunction} (if any) to rewrite the
     */
        if (call instanceof RexOver over) {
 * The OpenSearch Contributors require contributions made to
 *
    private static RelNode adaptNode(RelNode node, Adapters adapters) {
            return adaptJoin(join, adapters, adaptedChildren, childrenChanged);
 * Walks a resolved plan and applies per-function {@link ScalarFunctionAdapter}s
        RelNode newInput
     * {@code operand instanceof RexInputRef} to resolve field storage. If a child
            if (adapted != key) windowChanged = true;
            if (adapted != order.left) {
        }
        };
            Adapters adapters = new Adapters(capabilityProvider.scalarFunctionAdapters(), capabilityProvider.windowFunctionAdapters());
        boolean operandsChanged
            public RexNode visitInputRef(RexInputRef ref) {
                    over.isDistinct(),
            }
     * Adapt a {@link RexOver}: recurse into its PARTITION BY and ORDER BY (which live on
                expr = rexBuilder.makeCast(targetType, expr);
     */
            }
        RelOptCluster cluster,
                ? (OpenSearchAggregate) agg.copy(agg.getTraitSet(), adaptedChildren)
     * the Project's declared column type get wrapped in a CAST so the outer-visible schema is
}
import org.apache.calcite.plan.RelOptCluster;
        // Recurse into operands first
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
    private record Adapters(Map<ScalarFunction, ScalarFunctionAdapter> scalar, Map<WindowFunction, WindowFunctionAdapter> window) {
        // declared column type so the outer-visible schema is preserved.
    ) {
 * {@link org.opensearch.analytics.spi.BackendCapabilityProvider#scalarFunctionAdapters()}.
                left,
        RelNode right = childrenChanged ? adaptedChildren.get(1) : join.getRight();
     * Adapts {@link OpenSearchJoin#getCondition()} so PPL UDFs inlined by
     * Adapt all plan alternatives in the DAG using each alternative's driving backend's adapters.
                join.getJoinType(),
                project.getCluster(),
import org.apache.calcite.rex.RexNode;
            );
            return cluster.getRexBuilder()
                    adaptedPartitionKeys,
                return adapter.adapt(current, fieldStorage, cluster);
        RexBuilder rexBuilder = originalProject.getCluster().getRexBuilder();
    /**
        }
     *
import org.apache.calcite.rel.RelNode;
    /**
        // If the child's row type shifted (e.g. FINAL aggregate's rewriter produced SUM of NOT-NULL
            if (!expr.getType().equals(targetType)) {
import java.util.ArrayList;
 */
        // Look up adapter for this function
        return ScalarFunction.fromSqlOperatorWithFallback(call.getOperator());
import org.apache.calcite.rex.RexOver;
        for (RexFieldCollation order : window.orderKeys) {
                    over.ignoreNulls()
 * @opensearch.internal
        List<RelNode> adaptedChildren,
                );
import java.util.Map;
     * preserved.
        return current;
        for (RelNode child : node.getInputs()) {
        for (StagePlan plan : stage.getPlanAlternatives()) {
                .makeOver(
    }
        OpenSearchRelNode inputNode = (OpenSearchRelNode) RelNodeUtils.unwrapHep(project.getInput());
        return project;
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
import org.apache.calcite.rex.RexFieldCollation;
        }
            RexNode adapted = adaptRex(key, adapters, fieldStorage, cluster);
/*
            return adaptedInner == annotation.unwrap() ? node : annotation.withAdaptedOriginal(adaptedInner);
    private BackendPlanAdapter() {}
            @Override
    }
        boolean projectsChanged = false;
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
import org.opensearch.analytics.spi.FieldStorageInfo;
    public static void adaptAll(QueryDAG dag, CapabilityRegistry registry) {
        List<FieldStorageInfo> fieldStorage = inputNode.getOutputFieldStorage();
        }
     * <p>This means a parent adapter receives already-adapted operands. This is safe
                    com.google.common.collect.ImmutableList.copyOf(adaptedOrderKeys),
     * {@code RexInputRef}) and skips adaptation — no double-CAST occurs.
        RexNode adaptedCondition = adaptRex(join.getCondition(), adapters, fieldStorage, join.getCluster());
        if (node instanceof OpenSearchProject project) {
            if (fragment != plan.resolvedFragment()) {
                    over.getAggOperator(),
                adapted.add(new StagePlan(fragment, plan.backendId()));
        // column → nullable BIGINT), the project's RexInputRefs still carry the old types. Rebind
        if (!(node instanceof RexCall call)) {
            RexNode adapted = adaptRex(operand, adapters, fieldStorage, cluster);
        // Plain RexCall.clone() would drop the annotation subclass, breaking later stripping.
 * this file be licensed under the Apache-2.0 license or a
    /**
            RelNode adaptedChild = adaptNode(child, adapters);
                childrenChanged ? adaptedChildren.getFirst() : filter.getInput(),
        }
    private static final Logger LOGGER = LogManager.getLogger(BackendPlanAdapter.class);
                project.getViableBackends()
            LOGGER.debug("Before adaptation [{}]:\n{}", plan.backendId(), RelOptUtil.toString(plan.resolvedFragment()));
                filter.getViableBackends()
    private static ArrayList<RexNode> rebindProjectsAgainstInput(
        if (node instanceof OpenSearchJoin join) {
            RexNode adaptedInner = adaptRex(annotation.unwrap(), adapters, fieldStorage, cluster);
        boolean childrenChanged
                filter.getCluster(),
                adaptedCondition,
    ) {
        List<RexNode> adaptedProjects = new ArrayList<>(project.getProjects().size());
                adaptedCondition,
            return adapter.adapt(over, adaptedOperands, adaptedPartitionKeys, adaptedOrderKeys, cluster);
            } else {
                adaptedOrderKeys.add(new RexFieldCollation(adapted, order.right));
        }
        }
        if (childrenChanged && !newInput.getRowType().equals(project.getInput().getRowType())) {
            return adaptOver(over, adapters, fieldStorage, cluster, adaptedOperands, operandsChanged);
        return rebound;
     * adapter wraps an operand in CAST, the parent sees a {@code RexCall} (not
    }
                    adaptedOperands,
            ScalarFunctionAdapter adapter = adapters.scalar().get(function);
 * compatible open source license.
import org.apache.calcite.rex.RexBuilder;
        }
        }
import org.apache.calcite.rex.RexInputRef;
                : agg;
        boolean windowChanged = false;
