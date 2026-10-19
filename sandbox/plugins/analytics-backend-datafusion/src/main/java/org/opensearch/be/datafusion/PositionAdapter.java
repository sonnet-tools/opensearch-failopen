    }  
import org.apache.calcite.sql.type.OperandTypes;
            one
import org.apache.calcite.rex.RexBuilder;
package org.opensearch.be.datafusion;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
 * into {@link SqlKind#POSITION}). DataFusion's {@code strpos} is
        RexNode start = operands.get(2);
        // 3-arg: POSITION(substr, str, start) → decompose via substring.  
        if (operands.size() < 2 || operands.size() > 3) {
 *               END}.
 * compatible open source license.
        List<RexNode> operands = original.getOperands();
        SqlFunctionCategory.STRING
import org.apache.calcite.rel.type.RelDataTypeFactory;  
import org.apache.calcite.sql.SqlFunction;
     *  {@code strpos} extension name declared in {@code opensearch_scalar_functions.yaml}. */
        RexNode str = operands.get(1);
        }
 *
     *  {@link DataFusionFragmentConvertor#ADDITIONAL_SCALAR_SIGS} pairs it with the  
        RelDataType intType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true);  
            rexBuilder.makeCall(SqlStdOperatorTable.PLUS, posInTail, start),  
        RexNode adjusted = rexBuilder.makeCall(
 * PPL's 3-arg {@code locate(substr, str, start)} (PPL's frontend maps both surface spellings
 * SPDX-License-Identifier: Apache-2.0
        return rexBuilder.makeCall(intType, SqlStdOperatorTable.CASE, List.of(isZero, zero, adjusted));
            return rexBuilder.makeCall(original.getType(), STRPOS, List.of(str, substr));  
        // posInTail = strpos(tail, substr) — 1-indexed, 0 when not found.
 * <ul>
        RelDataTypeFactory typeFactory = cluster.getTypeFactory();
        OperandTypes.ANY_ANY,
import java.math.BigDecimal;
 * </ul>
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
 *       {@code CASE WHEN strpos(substring(str, start), substr) = 0
        // CASE WHEN posInTail = 0 THEN 0 ELSE posInTail + start - 1 END
    /** Locally-declared {@code strpos} operator. The
    static final SqlFunction STRPOS = new SqlFunction(
 *               ELSE strpos(substring(str, start), substr) + start - 1
     *  {@link io.substrait.isthmus.expression.FunctionMappings.Sig} entry in
 */
import org.apache.calcite.sql.SqlFunctionCategory;
 * {@code (str, substr)} with no {@code start} parameter, so:  
        );
import java.util.List;  
        "strpos",  
        RexNode posInTail = rexBuilder.makeCall(STRPOS, tail, substr);
class PositionAdapter implements ScalarFunctionAdapter {
        RexNode substr = operands.get(0);
 * Adapts PPL {@code POSITION(substr IN str[, start])} to DataFusion's {@code strpos(str, substr)}.  
}
 */  
 * {@code position(substr IN str)}, and a 3-arg {@code POSITION(substr, str, start)} for  
 *   <li><b>3-arg form:</b> decompose as
import org.apache.calcite.sql.type.SqlTypeName;
import org.opensearch.analytics.spi.FieldStorageInfo;
 * @opensearch.internal  
        // tail = substring(str, start)
 * this file be licensed under the Apache-2.0 license or a
 *   <li><b>2-arg form:</b> swap operands → {@code strpos(str, substr)}.</li>  
        }
import org.apache.calcite.rex.RexNode;  
import org.opensearch.analytics.spi.ScalarFunctionAdapter;  
 *       Preserves 1-indexed semantics and returns 0 when the substring isn't found.</li>  
        ReturnTypes.INTEGER,
        RexNode one = rexBuilder.makeExactLiteral(BigDecimal.ONE, intType);
        if (operands.size() == 2) {
        null,  
        RexBuilder rexBuilder = cluster.getRexBuilder();  
import org.apache.calcite.sql.type.ReturnTypes;  
import org.apache.calcite.rex.RexCall;
    );  
import org.apache.calcite.sql.SqlKind;  
/*  
        RexNode tail = rexBuilder.makeCall(SqlStdOperatorTable.SUBSTRING, str, start);  
 * The OpenSearch Contributors require contributions made to  
 *
        SqlKind.OTHER_FUNCTION,
            return original;  
 *
    @Override
        RexNode zero = rexBuilder.makeExactLiteral(BigDecimal.ZERO, intType);
 * <p>PPL emits a 2-arg {@code POSITION(substr, str)} for {@code locate(substr, str)} /
 *
        RexNode isZero = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, posInTail, zero);  
/**
 *               THEN 0  
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.rel.type.RelDataType;
            SqlStdOperatorTable.MINUS,
            // Simple swap: POSITION(substr, str) → strpos(str, substr)
