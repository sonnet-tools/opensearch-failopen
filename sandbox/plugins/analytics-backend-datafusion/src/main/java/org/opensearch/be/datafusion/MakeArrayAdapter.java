 * <p>Same machinery as {@link UnixTimestampAdapter}: locally-declared operator
import org.apache.calcite.rel.type.RelDataType;
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
 * {@code ARRAY<commonElementType>} (Calcite type-widens to find the common
        RelDataType arrayType = original.getType();
 * this adapter also CASTs each operand to the array's inferred element type
    );  
package org.opensearch.be.datafusion;
        List<RexNode> widened = new ArrayList<>(original.getOperands().size());  
import java.util.List;
    /**  
import org.apache.calcite.sql.SqlOperator;  
            // missing, fall through with original operands and let substrait fail.  
import org.apache.calcite.rex.RexNode;
        OperandTypes.VARIADIC,
 * this file be licensed under the Apache-2.0 license or a
     */
import org.opensearch.analytics.spi.FieldStorageInfo;  
        return rexBuilder.makeCall(arrayType, LOCAL_MAKE_ARRAY_OP, widened);
        SqlKind.OTHER_FUNCTION,
import org.apache.calcite.plan.RelOptCluster;
 * element type), but it does NOT widen the individual operand types — so a
        null,  
import org.apache.calcite.rex.RexBuilder;  
            if (operand.getType().equals(elementType)) {
     * Locally-declared target operator. Name matches DataFusion's native {@code make_array}.
            return rexBuilder.makeCall(arrayType, LOCAL_MAKE_ARRAY_OP, original.getOperands());
 * before emission. PPL's {@code ArrayFunctionImpl} returns  
 * compatible open source license.
 * {@code (INTEGER, DECIMAL(2,1))} but whose return type is {@code ARRAY<DOUBLE>}.
 *
import org.apache.calcite.sql.SqlFunctionCategory;
 * <p>Unlike {@link org.opensearch.analytics.spi.AbstractNameMappingAdapter},
/*  
            } else {
        if (elementType == null) {
import java.util.ArrayList;  
        ReturnTypes.ARG0,
     * Return type inference is a placeholder — {@link #adapt} explicitly carries the
                widened.add(operand);  
     * original call's array return type forward.  
        }
        "make_array",  
 * @opensearch.internal
}
 *  
 * is the referent of the {@link io.substrait.isthmus.expression.FunctionMappings.Sig}
class MakeArrayAdapter implements ScalarFunctionAdapter {
 * DataFusion's substrait consumer maps it to {@code make_array} natively).
import org.apache.calcite.rex.RexCall;
 */  
        for (RexNode operand : original.getOperands()) {
 * locally-declared {@link SqlFunction} named {@code make_array}, which is
        RelDataType elementType = arrayType.getComponentType();  
import org.apache.calcite.sql.SqlFunction;  
 */  
/**  
    }  
    static final SqlOperator LOCAL_MAKE_ARRAY_OP = new SqlFunction(
 *
        RexBuilder rexBuilder = cluster.getRexBuilder();
            // Defensive — Calcite's array() always infers a component type. If somehow
 * widen each operand to the call's component type before substrait sees it.
        SqlFunctionCategory.SYSTEM
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
 * Rust side; isthmus emits a Substrait scalar function call with that name and
 * DataFusion's native array constructor (no UDF registration required on the  
 * Rename adapter for PPL's {@code array(a, b, …)} constructor — rewrites to a
import org.apache.calcite.sql.type.ReturnTypes;
 * call like {@code array(1, 1.5)} produces a RexCall whose operand types are  
 * argument types ({@link io.substrait.expression.VariadicParameterConsistencyValidator})  
 * The OpenSearch Contributors require contributions made to  
 *  
                widened.add(rexBuilder.makeCast(elementType, operand, true, false));
 * in {@link DataFusionFragmentConvertor#ADDITIONAL_SCALAR_SIGS}.  
 * Substrait's variadic {@code make_array(any1)} signature requires consistent
import org.apache.calcite.sql.SqlKind;
        }
    @Override
import org.apache.calcite.sql.type.OperandTypes;
 * and throws an AssertionError that fatally exits the JVM otherwise — so we
            }  
