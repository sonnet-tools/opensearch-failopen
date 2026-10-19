    }
        List<RexNode> normalised = new ArrayList<>(operands.size());
import org.apache.calcite.rel.type.RelDataTypeFactory;  
 * Normalises operand types for {@code SqlLibraryOperators.CONCAT_FUNCTION} (variadic CONCAT).  
        RelDataTypeFactory typeFactory = rexBuilder.getTypeFactory();  
        RexBuilder rexBuilder = cluster.getRexBuilder();
            return original;  
            RelDataType nullableVarchar = typeFactory.createTypeWithNullability(varchar, operand.getType().isNullable());
 */  
        if (operands.isEmpty()) {
import org.apache.calcite.plan.RelOptCluster;
 */
                continue;
        }
 * compatible open source license.
import java.util.List;  
        }
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.rex.RexCall;
            if (sqlType == SqlTypeName.VARCHAR) {
import org.opensearch.analytics.spi.FieldStorageInfo;
import org.apache.calcite.rex.RexBuilder;
import org.apache.calcite.sql.type.SqlTypeName;
/*  
 * leaves short string literals as {@code CHAR}/FixedChar alongside VARCHAR field refs — isthmus
        }
        if (!changed) {  
            changed = true;
import java.util.ArrayList;
                normalised.add(operand);  
            }
            SqlTypeName sqlType = operand.getType().getSqlTypeName();
            return original;
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
 *
 * Substrait's {@code concat} extension declares CONSISTENT parameter consistency, but Calcite
            normalised.add(rexBuilder.makeCast(nullableVarchar, operand));  
import org.apache.calcite.rel.type.RelDataType;
package org.opensearch.be.datafusion;
/**
 * SPDX-License-Identifier: Apache-2.0
        boolean changed = false;
 * (preserving nullability) so substrait sees a uniform-typed variadic call.
        for (RexNode operand : operands) {  
        return rexBuilder.makeCall(original.getType(), original.getOperator(), normalised);  
}
import org.opensearch.analytics.spi.ScalarFunctionAdapter;  
 * The OpenSearch Contributors require contributions made to  
    @Override
 * rejects the mixed-type call. This adapter casts every non-VARCHAR operand to VARCHAR  
import org.apache.calcite.rex.RexNode;  
            // CHAR / FixedChar / other string token → cast to VARCHAR, preserve nullability.  
            RelDataType varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        List<RexNode> operands = original.getOperands();
class ConcatVariadicAdapter implements ScalarFunctionAdapter {  
