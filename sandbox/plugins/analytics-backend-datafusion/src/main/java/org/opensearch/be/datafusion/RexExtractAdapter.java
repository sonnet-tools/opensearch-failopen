        "rex_extract",
import org.apache.calcite.rex.RexBuilder;
        RexBuilder rexBuilder = cluster.getRexBuilder();
        return rexBuilder.makeCall(original.getType(), LOCAL_REX_EXTRACT_OP, original.getOperands());
 *
     * real type vetting.
 * future use cases, but the SQL plugin's PPL Calcite visitor never emits
 * <p>Pattern and group operands MUST be string literals — the regex is
    static final SqlOperator LOCAL_REX_EXTRACT_OP = new SqlFunction(
 * runtime. (The Rust UDF also handles column-valued operands defensively for  
 * compatible open source license.
 * stays consistent.
 * SPDX-License-Identifier: Apache-2.0
     */
        if (original.getOperands().size() != 3) {  
 * this file be licensed under the Apache-2.0 license or a
}
import org.apache.calcite.sql.type.OperandTypes;
     * silently degrade by parsing the first row's value as a constant.  
 * The OpenSearch Contributors require contributions made to  
 * Adapter for the PPL {@code rex field=f "(?<g>...)"} extract command's
 * a literal-validation step, and a {@code rexBuilder.makeCall} preserving
import org.apache.calcite.sql.SqlFunction;  
     * known up front because the regex compiler runs once per query — a
 * compiled per-call on the Rust side, not per-row. Column-valued pattern or  
import org.apache.calcite.sql.SqlOperator;  
        }
 *
        validateLiteral(original.getOperands().get(1), "pattern");
import org.apache.calcite.rex.RexNode;
/**  
    );
import java.util.List;
 * single-match form. Rewrites the SQL plugin's
import org.apache.calcite.sql.type.SqlTypeName;  
 *  
                "rex_extract: expected 3 operands (input, pattern, group), got " + original.getOperands().size()
            throw new IllegalArgumentException("rex_extract: '" + name + "' must be a string literal, got " + operand.getKind());
        if (!(operand instanceof RexLiteral literal)) {  
import org.apache.calcite.sql.SqlKind;
        }
            );  
     */  
 * such calls today.)
 * {@code PPLBuiltinOperators.REX_EXTRACT} call (a custom Calcite UDF named  
     * Reject non-literal operands at plan time. Both pattern and group must be  
import org.apache.calcite.rex.RexLiteral;
 * {@code "REX_EXTRACT"}) to {@link #LOCAL_REX_EXTRACT_OP}, which {@link
     * Locally-declared target operator for the rewrite. {@link SqlKind#OTHER_FUNCTION}
import org.apache.calcite.rex.RexCall;  
import org.opensearch.analytics.spi.FieldStorageInfo;
        ReturnTypes.VARCHAR_2000_NULLABLE,
    @Override
     * column-valued operand would either recompile per row (catastrophic) or
 * group is rejected at plan time with {@code IllegalArgumentException} so
        SqlTypeName typeName = literal.getType().getSqlTypeName();  
import org.apache.calcite.sql.type.ReturnTypes;
        validateLiteral(original.getOperands().get(2), "group");  
        }  
            throw new IllegalArgumentException(
    /**
package org.opensearch.be.datafusion;
    /**
            throw new IllegalArgumentException("rex_extract: '" + name + "' must be a string literal, got " + typeName);
    }
        null,
        if (typeName != SqlTypeName.CHAR && typeName != SqlTypeName.VARCHAR) {
import org.apache.calcite.plan.RelOptCluster;
 * DataFusionFragmentConvertor#ADDITIONAL_SCALAR_SIGS} maps to the
 * @opensearch.internal  
 *
/*  
 * <p>Mirrors the {@link ConvertTzAdapter} shape: one local target operator,
    static void validateLiteral(RexNode operand, String name) {
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
        SqlFunctionCategory.STRING
import org.apache.calcite.sql.SqlFunctionCategory;
     * so it doesn't collide with any Calcite built-in. {@link OperandTypes#STRING_STRING_STRING}  
 */
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
 * users see the error immediately rather than as a silent NULL row at
class RexExtractAdapter implements ScalarFunctionAdapter {
        SqlKind.OTHER_FUNCTION,  
 * {@code rex_extract} Substrait extension.  
 * the original call's return type so the enclosing project's row type cache  
        OperandTypes.STRING_STRING_STRING,  
 */  
     * keeps validation permissive — the Rust UDF's {@code coerce_types} does the
    }  
