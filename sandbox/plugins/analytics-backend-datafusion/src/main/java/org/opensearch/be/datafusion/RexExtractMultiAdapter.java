 * this file be licensed under the Apache-2.0 license or a
     * an {@code ARRAY<VARCHAR>} matching the SQL plugin's UDF return type, so  
        RexBuilder rexBuilder = cluster.getRexBuilder();
        return opBinding.getTypeFactory().createArrayType(nullableVarchar, -1);
        // max_match (operand 3) can be column-valued; the Rust UDF handles it per-row.
        if (original.getOperands().size() != 4) {
import org.opensearch.analytics.spi.FieldStorageInfo;
import org.apache.calcite.sql.type.SqlTypeFamily;
 * compatible open source license.
import org.apache.calcite.rex.RexBuilder;  
 * command's multi-match form. Rewrites the SQL plugin's
import org.apache.calcite.sql.SqlFunctionCategory;
        null,  
 */  
            throw new IllegalArgumentException(
/*  
    static final SqlOperator LOCAL_REX_EXTRACT_MULTI_OP = new SqlFunction("rex_extract_multi", SqlKind.OTHER_FUNCTION, opBinding -> {
package org.opensearch.be.datafusion;
 *
 *
     * downstream Project / Filter nodes don't see a type mismatch when the
import org.apache.calcite.sql.type.OperandTypes;
 * literal or a column ref — the Rust UDF handles per-row max_match values.
    @Override
    },
 * Adapter for the PPL {@code rex field=f "(?<g>...)" max_match=N} extract
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
    }  
        RexExtractAdapter.validateLiteral(original.getOperands().get(1), "pattern");
     * Locally-declared target operator. The {@code returnTypeInference} produces
 * {@code rex_extract_multi} Substrait extension.  
    );  
import org.apache.calcite.sql.SqlKind;
}
        }
 *
import org.apache.calcite.sql.SqlFunction;  
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
import org.apache.calcite.sql.SqlOperator;  
        RexExtractAdapter.validateLiteral(original.getOperands().get(2), "group");  
        return rexBuilder.makeCall(original.getType(), LOCAL_REX_EXTRACT_MULTI_OP, original.getOperands());
/**  
import org.apache.calcite.plan.RelOptCluster;
class RexExtractMultiAdapter implements ScalarFunctionAdapter {
 * {@code PPLBuiltinOperators.REX_EXTRACT_MULTI} call to  
 * {@link #LOCAL_REX_EXTRACT_MULTI_OP}, which
 * <p>Return type is {@code ARRAY<VARCHAR_2000?>} (matching the SQL plugin's  
            );
        OperandTypes.family(SqlTypeFamily.CHARACTER, SqlTypeFamily.CHARACTER, SqlTypeFamily.CHARACTER, SqlTypeFamily.INTEGER),
 * @opensearch.internal  
 * {@link DataFusionFragmentConvertor#ADDITIONAL_SCALAR_SIGS} maps to the
 */
        SqlFunctionCategory.STRING
 * SPDX-License-Identifier: Apache-2.0
        RelDataType nullableVarchar = opBinding.getTypeFactory().createTypeWithNullability(varchar, true);  
        // Pattern and group must be literals — same reasoning as RexExtractAdapter.  
import java.util.List;
 *
 * pattern and group operands. The {@code max_match} integer can be either a  
     * adapter swaps the operator.
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.sql.type.SqlTypeName;  
                "rex_extract_multi: expected 4 operands (input, pattern, group, max_match), got " + original.getOperands().size()  
    /**
import org.apache.calcite.rex.RexCall;
 * {@code RexExtractMultiFunction.getReturnTypeInference}).
import org.apache.calcite.rel.type.RelDataType;
     */  
 * <p>Same literal-validation contract as {@link RexExtractAdapter} for the
import org.apache.calcite.rex.RexNode;
        RelDataType varchar = opBinding.getTypeFactory().createSqlType(SqlTypeName.VARCHAR, 2000);
