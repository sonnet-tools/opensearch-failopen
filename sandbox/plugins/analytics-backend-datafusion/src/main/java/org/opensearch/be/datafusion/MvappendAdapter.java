    }
 */  
 * <p>Same templated machinery as {@link MvzipAdapter} / {@link MvfindAdapter}:
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
        // Substrait's variadic {@code any1} parameter requires every operand at the same  
 * @opensearch.internal  
 *
 * {@code ARRAY<componentType>} before substrait emission, so the UDF sees a
                RexNode casted = operandType.equals(componentType) ? operand : rexBuilder.makeCast(componentType, operand, true, false);  
import org.apache.calcite.plan.RelOptCluster;
                if (operandType.equals(targetArrayType)) {
        List<RexNode> coerced = new ArrayList<>(original.getOperands().size());
 * <p>The Rust UDF (`udf::mvappend`) handles operands as a uniform stream where  
 * {@code List<element_type>} (array) for a single inferred {@code element_type}.
        return rexBuilder.makeCall(arrayType, LOCAL_MVAPPEND_OP, coerced);
        }  
        SqlFunctionCategory.SYSTEM
                }
 * aren't handled by it.
 * SPDX-License-Identifier: Apache-2.0
            return rexBuilder.makeCall(arrayType, LOCAL_MVAPPEND_OP, original.getOperands());
 */
                } else {  
import org.opensearch.analytics.spi.FieldStorageInfo;  
 * {@link io.substrait.isthmus.expression.FunctionMappings.Sig} entry in  
 * compatible open source license.
import java.util.ArrayList;  
            } else {  
 *
    @Override
 * The OpenSearch Contributors require contributions made to  
 * — those fail at substrait conversion before reaching this adapter, and
    );
        // call. The Rust UDF then sees a uniform {@code list<any1>} variadic.  
import org.apache.calcite.sql.SqlFunction;  
import org.apache.calcite.rel.type.RelDataType;
        SqlKind.OTHER_FUNCTION,  
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
        if (componentType == null) {  
        null,
                // element type matches), then wrap in make_array so substrait sees a list.
}  
        ReturnTypes.ARG0,
 *
        RexBuilder rexBuilder = cluster.getRexBuilder();  
        // of bare scalars and arrays, which substrait's signature matcher rejects with
                    coerced.add(rexBuilder.makeCast(targetArrayType, operand, true, false));
        OperandTypes.VARIADIC,  
                // Scalar operand — first cast to componentType (so the singleton array's
        RelDataType targetArrayType = cluster.getTypeFactory().createArrayType(componentType, -1);
        // operand to {@code ARRAY<componentType>} — array operands cast their element
import org.apache.calcite.rex.RexCall;
import org.apache.calcite.rex.RexNode;
        // {@code Unable to convert call mvappend(list<…>, scalar, …)}. Normalize every  
import org.apache.calcite.sql.SqlOperator;  
 * The Calcite call's return type is {@code ARRAY<componentType>}; this adapter  
 * {@link DataFusionFragmentConvertor#ADDITIONAL_SCALAR_SIGS}.
        "mvappend",
 * casts each scalar operand to {@code componentType} and each array operand to
class MvappendAdapter implements ScalarFunctionAdapter {
        for (RexNode operand : original.getOperands()) {  
            }
/*  
            RelDataType operandType = operand.getType();
/**  
        // type if it differs; scalar operands wrap in a {@code make_array(…)} singleton
package org.opensearch.be.datafusion;
 *
 * the locally-declared operator is the referent of the
import org.apache.calcite.sql.type.ReturnTypes;
import java.util.List;
 * every operand is either {@code element_type} (scalar) or
 * <p>Mixed-type {@code mvappend} calls (PPL widens to {@code ARRAY<ANY>}) end
        }
        RelDataType componentType = arrayType.getComponentType();
 * single element type across all positions.  
 * up with a Calcite {@code ANY} component type which substrait can't serialize  
                    coerced.add(operand);
 *  
import org.apache.calcite.rex.RexBuilder;  
import org.apache.calcite.sql.SqlFunctionCategory;
import org.apache.calcite.sql.SqlKind;
        // variadic position to share a type. PPL's {@code mvappend(arg, …)} accepts a mix
    static final SqlOperator LOCAL_MVAPPEND_OP = new SqlFunction(
import org.apache.calcite.sql.type.OperandTypes;
                // Array operand — cast to ARRAY<componentType> if its element type differs.  
        RelDataType arrayType = original.getType();
 * this file be licensed under the Apache-2.0 license or a
 * Rename + operand-coerce adapter for PPL's {@code mvappend(arg1, arg2, …)}.
                coerced.add(rexBuilder.makeCall(targetArrayType, MakeArrayAdapter.LOCAL_MAKE_ARRAY_OP, List.of(casted)));
            if (operandType.getComponentType() != null) {
