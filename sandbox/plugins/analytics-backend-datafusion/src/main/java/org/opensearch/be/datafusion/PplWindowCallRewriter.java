                    break;
            if (rewritten != expr) {  
        if (rel instanceof Project project) {
                return super.visitOver(over);
        if (inputRowTypeChanged) {
import java.util.List;
import org.apache.calcite.rex.RexInputRef;
            List<RexNode> newOperands = visitList(call.getOperands(), changed);  
        List<RexNode> oldExprs = project.getProjects();
            }
            return rel.copy(rel.getTraitSet(), newInputs);
final class PplWindowCallRewriter {
import org.apache.calcite.rel.core.Project;
import org.apache.calcite.rel.logical.LogicalProject;  
            RexWindow window = recursedOver.getWindow();
            this.rexBuilder = rexBuilder;
            return rel;
import org.apache.calcite.rex.RexNode;
        return LogicalProject.create(newInput, List.of(), newExprs, fieldNames);  
                varcharNullable,  
        }
            return rexBuilder.makeOver(
        }  
    private PplWindowCallRewriter() {}  
    }
        boolean childChanged = false;
            if (retyped == null) {  
                retyped = rel;
        public RexNode visitOver(RexOver over) {
                com.google.common.collect.ImmutableList.copyOf(window.orderKeys),
 * The OpenSearch Contributors require contributions made to  
}
            int idx = inputRef.getIndex();
        List<RelNode> oldInputs = rel.getInputs();
 */  
            return project;  
            );  
    private static RelNode descendAndRewrite(RelNode rel) {
            }  
            return retyped.copy(retyped.getTraitSet(), newInputs);  
            ExprRewriter shuttle = new ExprRewriter(rexBuilder, newInputs.get(0).getRowType());
            }
            if (rewritten != input) {
                recursedOver.getOperands(),
        }
 *
            RelNode rewritten = descendAndRewrite(input);  
        @Override
        List<RexNode> newExprs = new ArrayList<>(oldExprs.size());
            }  
            SqlAggFunction op = over.getAggOperator();  
        List<RelNode> newInputs = new ArrayList<>(oldInputs.size());  
        return descendAndRewrite(root);  
                return recursed;  
import org.apache.calcite.sql.SqlAggFunction;  
                exprChanged = true;
            if (!"PATTERN".equalsIgnoreCase(op.getName())) {
            return rexBuilder.makeCall(call.getType(), call.getOperator(), newOperands);
        if (!exprChanged && !inputChanged) {
        boolean exprChanged = false;  
 * this file be licensed under the Apache-2.0 license or a
            RelDataType varcharNullable = rexBuilder.getTypeFactory()
                return over;
            if (!changed[0]) {
            return new RexInputRef(idx, currentType);
        if (childChanged) {
                if (!oldInputs.get(i).getRowType().equals(newInputs.get(i).getRowType())) {  
            }
            newInputs.add(rewritten);
                recursedOver.ignoreNulls()
import org.apache.calcite.rex.RexCall;  
        for (RexNode expr : oldExprs) {
                false,  
            }
            if (!(recursed instanceof RexOver recursedOver)) {
        }
                window.isRows(),
    // Children first, then retype the rel's RexNodes against new child row types before copy().  
        if (oldInputs.isEmpty()) {  
import org.apache.calcite.rex.RexShuttle;
                childChanged = true;
import org.apache.calcite.rex.RexWindow;
                DataFusionFragmentConvertor.LOCAL_INTERNAL_PATTERN_WINDOW_OP,
                return call;
 * compatible open source license.
        }
            if (currentType.equals(inputRef.getType())) {
 * SPDX-License-Identifier: Apache-2.0
            RelNode retyped = rel.accept(shuttle);
        List<String> fieldNames = project.getRowType().getFieldNames();
            if (idx < 0 || idx >= inputRowType.getFieldCount()) {  
                window.partitionKeys,  
        RexBuilder rexBuilder = project.getCluster().getRexBuilder();
        public RexNode visitInputRef(RexInputRef inputRef) {
            }  
    }
        }
                    inputRowTypeChanged = true;
                .createTypeWithNullability(rexBuilder.getTypeFactory().createSqlType(SqlTypeName.VARCHAR), true);  
            this.inputRowType = inputRowType;  
            return rewriteProject(project, newInputs.get(0), childChanged);
import org.apache.calcite.rex.RexBuilder;
            }
import org.apache.calcite.rel.RelNode;
            RexNode rewritten = expr.accept(shuttle);
        }  
    }
            RexBuilder rexBuilder = rel.getCluster().getRexBuilder();  
        }
            }  
        @Override  
            if (op == DataFusionFragmentConvertor.LOCAL_INTERNAL_PATTERN_WINDOW_OP) {
import org.apache.calcite.rex.RexOver;  
            boolean[] changed = { false };
            // 3-arg makeCall preserves declared type; 2-arg re-infers and breaks SAFE_CAST.
        private final RexBuilder rexBuilder;
        }  
                return inputRef;
                recursedOver.isDistinct(),
            RexNode recursed = super.visitOver(over);
                window.getLowerBound(),
import java.util.ArrayList;  
        }
import org.apache.calcite.rel.type.RelDataType;
    static RelNode rewrite(RelNode root) {
    private static final class ExprRewriter extends RexShuttle {  
        }
    private static RelNode rewriteProject(Project project, RelNode newInput, boolean inputChanged) {
        @Override  
                }  
            newExprs.add(rewritten);  
                window.getUpperBound(),  
    }
        private final RelDataType inputRowType;
package org.opensearch.be.datafusion;
import org.apache.calcite.sql.type.SqlTypeName;
            for (int i = 0; i < oldInputs.size(); i++) {
        ExprRewriter(RexBuilder rexBuilder, RelDataType inputRowType) {
        RexShuttle shuttle = new ExprRewriter(rexBuilder, newInput.getRowType());  
/*  
            RelDataType currentType = inputRowType.getFieldList().get(idx).getType();  
        return rel;
        } else if (childChanged) {
        public RexNode visitCall(RexCall call) {
                return inputRef;
        for (RelNode input : oldInputs) {
                true,
/** Pre-isthmus rewrite for PPL BRAIN window expressions onto LOCAL_INTERNAL_PATTERN_WINDOW_OP. */  
            }  
        boolean inputRowTypeChanged = false;  
