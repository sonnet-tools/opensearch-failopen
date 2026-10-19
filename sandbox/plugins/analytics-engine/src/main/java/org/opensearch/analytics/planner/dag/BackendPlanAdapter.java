        for (Stage child : stage.getChildStages()) {  
        for (RexNode operand : call.getOperands()) {
            }  
    private static RelNode adaptJoin(OpenSearchJoin join, Adapters adapters, List<RelNode> adaptedChildren, boolean childrenChanged) {
            newInputTypes.add(f.getType());  
                filter.getCluster(),
                newInput,
        stage.setPlanAlternatives(adapted);
            if (adapter != null) {
                    adaptedPartitionKeys,
 */  
import org.opensearch.analytics.spi.WindowFunctionAdapter;
    /**  
 * SPDX-License-Identifier: Apache-2.0
     */  
        // declared column type so the outer-visible schema is preserved.
     * Calcite's FILTER_INTO_JOIN reach the fragment converter in their adapted shape.
        for (RexNode key : window.partitionKeys) {  
import org.opensearch.analytics.planner.CapabilityRegistry;
                adapted.add(plan);
        // adapter recursion has to descend through adaptOver to reach them.
import org.apache.calcite.rex.RexInputRef;  
        List<RelDataType> newInputTypes = new ArrayList<>();
/**
            return cluster.getRexBuilder()  
        }  
    }
                    over.getType(),
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
                    adaptedOperands,
    public static void adaptAll(QueryDAG dag, CapabilityRegistry registry) {
        for (RexFieldCollation order : window.orderKeys) {  
        // PARTITION BY / ORDER BY expressions live on RexOver.window, not in getOperands(), so
        return childrenChanged ? node.copy(node.getTraitSet(), adaptedChildren) : node;  
                adaptedProjects,
                adaptedCondition,
import org.apache.calcite.rex.RexBuilder;  
            Adapters adapters = new Adapters(capabilityProvider.scalarFunctionAdapters(), capabilityProvider.windowFunctionAdapters());  
     * Field storage is left ++ right output storage (Calcite join row-type ordering).  
                project.getCluster(),
import org.apache.calcite.rex.RexWindow;
        boolean projectsChanged = false;
     * {@link RexWindow}, not in {@code getOperands()}), then dispatch to the backend's
            RelNode adaptedChild = adaptNode(child, adapters);  
        List<RexNode> adaptedOperands = new ArrayList<>(call.getOperands().size());
    ) {
     */  
                filter.getViableBackends()  
    private BackendPlanAdapter() {}
     * adapter wraps an operand in CAST, the parent sees a {@code RexCall} (not
        RexWindow window = over.getWindow();  
import org.opensearch.analytics.spi.ScalarFunction;
import org.apache.calcite.rel.type.RelDataTypeField;
                    com.google.common.collect.ImmutableList.copyOf(adaptedOrderKeys),  
                adaptedCondition,
        }
            return adaptProject(project, adapters, adaptedChildren, childrenChanged);  
            LOGGER.debug("After adaptation [{}]:\n{}", plan.backendId(), RelOptUtil.toString(fragment));  
     *  
        }  
     *  
            public RexNode visitInputRef(RexInputRef ref) {
        }  
            rebound.add(expr);
        if (node instanceof OpenSearchAggregate agg && agg.getMode() == AggregateMode.FINAL) {
        List<FieldStorageInfo> fieldStorage = filter.getOutputFieldStorage();
        }
            return adaptFilter(filter, adapters, adaptedChildren, childrenChanged);  
                adaptedOrderKeys.add(new RexFieldCollation(adapted, order.right));  
import org.opensearch.analytics.spi.FieldStorageInfo;
                ? (OpenSearchAggregate) agg.copy(agg.getTraitSet(), adaptedChildren)
                if (ref.getType().equals(actual)) return ref;  
import org.apache.logging.log4j.Logger;  
    /**  
        if (adaptedCondition != join.getCondition() || childrenChanged) {
    }
            return node;  
import org.opensearch.analytics.planner.rel.OpenSearchProject;
        adaptStage(dag.rootStage(), registry);
            RexNode adapted = adaptRex(order.left, adapters, fieldStorage, cluster);
        boolean operandsChanged = false;  
import org.opensearch.analytics.spi.WindowFunction;
    private static final Logger LOGGER = LogManager.getLogger(BackendPlanAdapter.class);  
            if (adaptedChild != child) childrenChanged = true;
import org.opensearch.analytics.planner.rel.OpenSearchJoin;  
            OpenSearchAggregate withAdaptedChildren = childrenChanged  
        // Annotation wrappers: adapt the inner expression and re-wrap with same metadata.  
            return adaptJoin(join, adapters, adaptedChildren, childrenChanged);  
 * compatible open source license.
                join.getCluster(),  
        RexOver over,
                return adapter.adapt(current, fieldStorage, cluster);
     * in nullability — e.g. FINAL aggregate's rewriter turned a NOT-NULL count into a nullable
            projectsChanged = true;  
                project.getRowType(),  
 * provided by the driving backend. Runs between plan forking and fragment conversion.
            return new OpenSearchProject(
        return over;
        RexCall current = operandsChanged ? call.clone(call.getType(), adaptedOperands) : call;
        RexShuttle rebind = new RexShuttle() {
        }  
        List<RelNode> adaptedChildren,  
                join.getJoinType(),
            return adaptOver(over, adapters, fieldStorage, cluster, adaptedOperands, operandsChanged);
        Adapters adapters,
     * operator / operands / order keys into the backend's expected shape. Returns the original
 * this file be licensed under the Apache-2.0 license or a
        // Plain RexCall.clone() would drop the annotation subclass, breaking later stripping.
                join.getTraitSet(),
        if (function != null) {
                : agg;
        if (call instanceof RexOver over) {  
            RelNode fragment = adaptNode(plan.resolvedFragment(), adapters);
     * Adapts {@link OpenSearchJoin#getCondition()} so PPL UDFs inlined by
import org.opensearch.analytics.planner.rel.AggregateMode;  
            }
        }
                    window.getExclude(),  
    }
        if (!(node instanceof RexCall call)) {
        RelNode left = childrenChanged ? adaptedChildren.get(0) : join.getLeft();  
     * <p>This ordering is validated by {@code testNestedAdaptedFunctionsProduceSingleCast}
    }  
 * This component looks up the adapter for each scalar function RexCall in the plan
                filter.getTraitSet(),  
import java.util.List;
        List<RelNode> adaptedChildren = new ArrayList<>(node.getInputs().size());  
        }
import org.apache.calcite.rex.RexOver;
                adapted.add(new StagePlan(fragment, plan.backendId()));
                    window.getUpperBound(),
        if (node instanceof OpenSearchProject project) {
 * <p>Each backend declares adapters keyed by {@link ScalarFunction} via  
import java.util.ArrayList;
    }  
                return new RexInputRef(ref.getIndex(), actual);
 *
                RelDataType actual = newInputTypes.get(ref.getIndex());
        }
    private static void adaptStage(Stage stage, CapabilityRegistry registry) {
 * {@link org.opensearch.analytics.spi.BackendCapabilityProvider#scalarFunctionAdapters()}.
        if (projectsChanged || childrenChanged) {  
            ScalarFunctionAdapter adapter = adapters.scalar().get(function);  
        }
        for (RelDataTypeField f : newInput.getRowType().getFieldList()) {
 *
        // RexInputRef in project expressions references the input's row type  
     * preserved.
                left,
     * Rebind a Project's expressions against a new input whose row type has shifted (typically
            }
        boolean childrenChanged = false;
import org.apache.calcite.rex.RexShuttle;  
            return adaptedInner == annotation.unwrap() ? node : annotation.withAdaptedOriginal(adaptedInner);
        return filter;  
                );  
        }
                    over.getAggOperator(),  
        }
import org.apache.logging.log4j.LogManager;
            var capabilityProvider = registry.getBackend(plan.backendId()).getCapabilityProvider();
        return rebound;
        return current;  
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
}  
import org.apache.calcite.rel.type.RelDataType;
        if (node instanceof OperatorAnnotation annotation && annotation.unwrap() != null) {
import org.apache.calcite.rel.RelNode;  
                adaptedOrderKeys.add(order);  
        List<FieldStorageInfo> fieldStorage = join.getOutputFieldStorage();
     * {@link WindowFunctionAdapter} for this {@link WindowFunction} (if any) to rewrite the  
        return join;  
        return project;
public class BackendPlanAdapter {
    private static ArrayList<RexNode> rebindProjectsAgainstInput(
     */
package org.opensearch.analytics.planner.dag;
        boolean childrenChanged
    /** Backend-provided adapter maps, bundled so helper signatures stay narrow. */
            LOGGER.debug("Before adaptation [{}]:\n{}", plan.backendId(), RelOptUtil.toString(plan.resolvedFragment()));
                    window.isRows(),
        OpenSearchRelNode inputNode = (OpenSearchRelNode) RelNodeUtils.unwrapHep(project.getInput());
            );
        // Look up adapter for this function  
                childrenChanged ? adaptedChildren.getFirst() : filter.getInput(),
            adaptedProjects = rebindProjectsAgainstInput(adaptedProjects, project, newInput);
            RexNode adapted = adaptRex(projectExpr, adapters, fieldStorage, project.getCluster());  
        // column → nullable BIGINT), the project's RexInputRefs still carry the old types. Rebind  
     * Adapts RexNodes bottom-up: operands are adapted before the call itself.
            if (adapted != projectExpr) projectsChanged = true;
    /**
                    true,
            adaptedPartitionKeys.add(adapted);
            if (adapted != order.left) {
                join.getViableBackends()  
        ScalarFunction function = resolveFunction(current);
        RelNode newInput
            if (fragment != plan.resolvedFragment()) {
            if (adapted != operand) operandsChanged = true;
 * The OpenSearch Contributors require contributions made to  
        WindowFunction fn = WindowFunction.resolveFunction(over.getAggOperator());
        boolean operandsChanged
            if (!expr.getType().equals(targetType)) {
            RexNode expr = projects.get(i).accept(rebind);  
 *
        }
    private static RexNode adaptRex(RexNode node, Adapters adapters, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
            adaptStage(child, registry);
        if (node instanceof OpenSearchJoin join) {
import java.util.Map;  
import org.opensearch.analytics.planner.RelNodeUtils;
        }
     */  
     * RexOver unchanged when nothing under it changed and no adapter applies.
    private static RelNode adaptProject(  
        }
    private static RelNode adaptFilter(OpenSearchFilter filter, Adapters adapters, List<RelNode> adaptedChildren, boolean childrenChanged) {  
            }
import org.apache.calcite.rex.RexNode;
 * @opensearch.internal
                    over.ignoreNulls()
    /**
    /**  
            if (adapted != key) windowChanged = true;  
            return DistributedAggregateRewriter.rewrite(withAdaptedChildren);  
        WindowFunctionAdapter adapter = fn == null ? null : adapters.window().get(fn);  
            return adapter.adapt(over, adaptedOperands, adaptedPartitionKeys, adaptedOrderKeys, cluster);
        for (StagePlan plan : stage.getPlanAlternatives()) {
        }  
    private static ScalarFunction resolveFunction(RexCall call) {
     * because adapters only inspect their <b>direct</b> operands via
        List<StagePlan> adapted = new ArrayList<>(stage.getPlanAlternatives().size());  
     * which confirms {@code SIN(ABS($0))} with both adapted produces one CAST at the leaf.
        };  
        RexNode adaptedCondition = adaptRex(join.getCondition(), adapters, fieldStorage, join.getCluster());  
    private static RexNode adaptOver(
        OpenSearchProject originalProject,  
        List<RexFieldCollation> adaptedOrderKeys = new ArrayList<>(window.orderKeys.size());
        return ScalarFunction.fromSqlOperatorWithFallback(call.getOperator());  
        RelNode newInput = childrenChanged ? adaptedChildren.getFirst() : project.getInput();  
            } else {
    }
import org.opensearch.analytics.planner.rel.OperatorAnnotation;  
        List<FieldStorageInfo> fieldStorage = inputNode.getOutputFieldStorage();
        }
        if (adapter != null) {
import org.apache.calcite.rex.RexFieldCollation;
        List<RexNode> adaptedProjects = new ArrayList<>(project.getProjects().size());  
    }
            RelDataType targetType = originalProject.getRowType().getFieldList().get(i).getType();
        List<RexNode> projects,
 * Walks a resolved plan and applies per-function {@link ScalarFunctionAdapter}s  
            @Override  
import org.apache.calcite.rex.RexCall;
                    window.getLowerBound(),
     * <p>This means a parent adapter receives already-adapted operands. This is safe
                windowChanged = true;
    }
    private record Adapters(Map<ScalarFunction, ScalarFunctionAdapter> scalar, Map<WindowFunction, WindowFunctionAdapter> window) {
                project.getViableBackends()
                .makeOver(
        if (operandsChanged || windowChanged) {
        }  
        if (childrenChanged && !newInput.getRowType().equals(project.getInput().getRowType())) {
 */  
     * the Project's declared column type get wrapped in a CAST so the outer-visible schema is
    ) {
     * {@code RexInputRef}) and skips adaptation — no double-CAST occurs.
        }
            adaptedChildren.add(adaptedChild);
            RexNode adapted = adaptRex(operand, adapters, fieldStorage, cluster);
            adaptedProjects.add(adapted);
        boolean windowChanged = false;
     */  
            );
     * Adapt all plan alternatives in the DAG using each alternative's driving backend's adapters.
        }
        // Recurse into operands first
        }
                expr = rexBuilder.makeCast(targetType, expr);  
            return new OpenSearchJoin(
    ) {
        List<RexNode> adaptedOperands,  
        Adapters adapters,  
            return new OpenSearchFilter(
        if (node instanceof OpenSearchFilter filter) {
        // Backend-specific rewrites (e.g. ARG_MIN→FIRST_VALUE). Adapter sees already-adapted operands.
        for (int i = 0; i < projects.size(); i++) {
     * Adapt a {@link RexOver}: recurse into its PARTITION BY and ORDER BY (which live on
    }
            }
import org.opensearch.analytics.spi.ScalarFunctionAdapter;  
import org.apache.calcite.plan.RelOptCluster;
        }
                project.getTraitSet(),  
/*  
        OpenSearchProject project,
     * {@code operand instanceof RexInputRef} to resolve field storage. If a child  
        for (RelNode child : node.getInputs()) {
 * and applies it if present.  
        RelOptCluster cluster,
                    over.isDistinct(),
        RexBuilder rexBuilder = originalProject.getCluster().getRexBuilder();  
                    false,  
            } else {  
        // them against the new input row type and CAST each projection back to the project's
    }  
import org.apache.calcite.plan.RelOptUtil;
            RexNode adapted = adaptRex(key, adapters, fieldStorage, cluster);
            adaptedOperands.add(adapted);  
            );
        if (adaptedCondition != filter.getCondition() || childrenChanged) {  
        }
            RexNode adaptedInner = adaptRex(annotation.unwrap(), adapters, fieldStorage, cluster);  
    private static RelNode adaptNode(RelNode node, Adapters adapters) {
        List<RexNode> adaptedPartitionKeys = new ArrayList<>(window.partitionKeys.size());
        RelNode right = childrenChanged ? adaptedChildren.get(1) : join.getRight();
        ArrayList<RexNode> rebound = new ArrayList<>(projects.size());
        List<FieldStorageInfo> fieldStorage,
     * BIGINT). RexInputRefs get retyped to the new column types; projections that diverge from  
                right,  
        // If the child's row type shifted (e.g. FINAL aggregate's rewriter produced SUM of NOT-NULL
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
        RexNode adaptedCondition = adaptRex(filter.getCondition(), adapters, fieldStorage, filter.getCluster());
        for (RexNode projectExpr : project.getProjects()) {
    }
