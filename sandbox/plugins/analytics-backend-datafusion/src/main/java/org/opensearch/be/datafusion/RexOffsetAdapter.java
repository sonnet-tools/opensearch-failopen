    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
import org.apache.calcite.rex.RexCall;  
        null,  
 * {@code rex_offset} Substrait extension.  
class RexOffsetAdapter implements ScalarFunctionAdapter {
            throw new IllegalArgumentException("rex_offset: expected 2 operands (input, pattern), got " + original.getOperands().size());
 * group offsets as a single string {@code "name1=s1-e1&name2=s2-e2"} sorted  
import org.apache.calcite.sql.SqlFunctionCategory;  
import org.apache.calcite.sql.SqlOperator;
/**
    );  
 *
        "rex_offset",  
 *
        OperandTypes.STRING_STRING,
 * which {@link DataFusionFragmentConvertor#ADDITIONAL_SCALAR_SIGS} maps to the
    @Override
 * command's offset-emission form. Rewrites the SQL plugin's  
        RexBuilder rexBuilder = cluster.getRexBuilder();
        RexExtractAdapter.validateLiteral(original.getOperands().get(1), "pattern");
import org.apache.calcite.rex.RexBuilder;
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
/*  
 */  
    /** Local target operator — see RexExtractAdapter for the pattern rationale. */
import org.apache.calcite.sql.SqlKind;
        if (original.getOperands().size() != 2) {
import org.apache.calcite.sql.SqlFunction;
 *
    static final SqlOperator LOCAL_REX_OFFSET_OP = new SqlFunction(
        }  
 *
 * @opensearch.internal  
 * <p>Pattern operand MUST be a string literal. Same reasoning as
 * <p>Return type is {@code VARCHAR_2000_NULLABLE} — the Rust UDF formats
        SqlKind.OTHER_FUNCTION,
import org.opensearch.analytics.spi.FieldStorageInfo;
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.sql.type.ReturnTypes;
import org.opensearch.analytics.spi.ScalarFunctionAdapter;  
}
package org.opensearch.be.datafusion;
import java.util.List;
 * The OpenSearch Contributors require contributions made to  
 * {@code PPLBuiltinOperators.REX_OFFSET} call to {@link #LOCAL_REX_OFFSET_OP},
import org.apache.calcite.rex.RexNode;
 * alphabetically. Matches the Java {@code RexOffsetFunction} return type.
import org.apache.calcite.plan.RelOptCluster;
        ReturnTypes.VARCHAR_2000_NULLABLE,
        SqlFunctionCategory.STRING
import org.apache.calcite.sql.type.OperandTypes;  
 * {@link RexExtractAdapter}: regex compilation is per-call, not per-row.  
 * Adapter for the PPL {@code rex field=f "(?<g>...)" offset_field=name}
        return rexBuilder.makeCall(original.getType(), LOCAL_REX_OFFSET_OP, original.getOperands());  
 */
    }
