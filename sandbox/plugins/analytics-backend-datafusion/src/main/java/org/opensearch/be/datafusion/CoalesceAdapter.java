import org.apache.calcite.rel.type.RelDataTypeFactory;  
}
 *   <li>Inserting a plain CAST on each operand whose type differs from the common type.  
 *   <li>Falling back to nullable VARCHAR when the unification returns {@code null}</li>
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
import java.util.ArrayList;  
            return original;
            commonType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);  
 * Adapter for coalesce(field1, field2, ...),
 * <p>This adapter moves the coercion step to plan time by:
 * @opensearch.internal
        }  
 * <p>Stock {@link SqlStdOperatorTable#COALESCE} requires operands that already share a common type.
    }  
        boolean anyCast = false;
 * returns the first non-null, non-missing value in the parameter list.
        for (RexNode operand : operands) {
        List<RelDataType> operandTypes = operands.stream().map(RexNode::getType).toList();  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        RexBuilder rexBuilder = cluster.getRexBuilder();
        // leastRestrictive([T]) is T, so single-operand coalesce degenerates to that operand's
        List<RexNode> operands = original.getOperands();  
        return rexBuilder.makeCall(original.getType(), SqlStdOperatorTable.COALESCE, finalOperands);
        List<RexNode> finalOperands = anyCast ? coerced : operands;
import org.opensearch.analytics.spi.FieldStorageInfo;  
 * compatible open source license.
 *
        List<RexNode> coerced = new ArrayList<>(operands.size());  
        }
    @Override
                coerced.add(rexBuilder.makeCast(commonType, operand, true, false));  
import org.apache.calcite.rex.RexNode;  
            } else {
 * </ol>
import org.apache.calcite.plan.RelOptCluster;
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
/**  
 *
        if (commonType == null) {
        // type and no CAST is needed. leastRestrictive across mixed numeric types returns the  
 *       / decimal conversions</li>
        if (operands.isEmpty()) {
import org.apache.calcite.rex.RexBuilder;
 */
                anyCast = true;
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
 *   <li>Rebuilding the call with {@link SqlStdOperatorTable#COALESCE} so isthmus serialises  
        // (e.g. DATE + BIGINT) returns null, which we backstop with VARCHAR
        RelDataType commonType = typeFactory.leastRestrictive(operandTypes);
 *  
 * So naively rewriting the call to stock {@code COALESCE} with the original operands would reject
            if (operand.getType().equals(commonType)) {  
 * The OpenSearch Contributors require contributions made to  
                coerced.add(operand);
import org.apache.calcite.sql.type.SqlTypeName;
 *       it through the default Substrait catalog</li>
        }  
        RelDataTypeFactory typeFactory = cluster.getTypeFactory();
 *  
import org.apache.calcite.rel.type.RelDataType;
 *       Calcite's CAST covers numeric / boolean / character / date / time / timestamp
class CoalesceAdapter implements ScalarFunctionAdapter {  
 * mixed-type inputs like {@code coalesce(VARCHAR, INTEGER, "fallback")} at plan validation.  
 * this file be licensed under the Apache-2.0 license or a
        // widest; across string + numeric returns VARCHAR; across incompatible type families
package org.opensearch.be.datafusion;
import org.apache.calcite.rex.RexCall;
 */  
            }
 * <ol>  
 *   <li>Computing {@code leastRestrictive} across all operand types</li>
/*  
