    static final SqlOperator IP_TO_STRING_OP = new SqlFunction(
 * into a UDF call so DataFusion's native byte-buffer-as-Latin-1 cast kernel is  
        ReturnTypes.VARCHAR_2000_NULLABLE,
 * SPDX-License-Identifier: Apache-2.0
        }  
 */  
    );  
        "ip_to_string",
        }
 *   <li>{@code IpType} &rarr; {@link #IP_TO_STRING_OP}  
 *
        if (original.getType().getSqlTypeName() != SqlTypeName.VARCHAR) {
 *
        SqlKind.OTHER_FUNCTION,  
 * <ul>
        OperandTypes.ANY,
/**
 *   <li>{@code BinaryType} &rarr; {@link #BINARY_TO_BASE64_OP}
        null,  
        if (source.getType() instanceof IpType) {  
        return original;  
package org.opensearch.be.datafusion;
    /** Bound to Substrait extension {@code "binary_to_base64"} (Rust UDF in {@code rust/src/udf/binary_to_base64.rs}). */
import org.apache.calcite.rex.RexNode;
import org.apache.calcite.sql.SqlFunctionCategory;  
 * bypassed:
    static final SqlOperator BINARY_TO_BASE64_OP = new SqlFunction(
import org.apache.calcite.sql.SqlFunction;
        "binary_to_base64",  
import org.opensearch.analytics.spi.FieldStorageInfo;
    );
        SqlFunctionCategory.SYSTEM
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.rex.RexCall;  
import org.apache.calcite.rex.RexBuilder;
import java.util.List;
 * compatible open source license.
import org.opensearch.analytics.schema.IpType;
import org.apache.calcite.sql.SqlOperator;
        }
import org.apache.calcite.sql.type.ReturnTypes;
            return original;
        if (source.getType() instanceof BinaryType) {  
import org.opensearch.analytics.spi.ScalarFunctionAdapter;  
final class IpBinaryCastFunctionAdapter implements ScalarFunctionAdapter {
import org.apache.calcite.sql.type.OperandTypes;  
        SqlFunctionCategory.SYSTEM
 * Rewrites {@code CAST}/{@code SAFE_CAST} of an analytics-engine UDT to VARCHAR
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
            return rexBuilder.makeCall(original.getType(), BINARY_TO_BASE64_OP, List.of(source));
import org.apache.calcite.sql.type.SqlTypeName;
        ReturnTypes.VARCHAR_2000_NULLABLE,
import org.apache.calcite.plan.RelOptCluster;
        RexNode source = original.getOperands().get(0);
 * @opensearch.internal
        SqlKind.OTHER_FUNCTION,
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.sql.SqlKind;
    @Override
        OperandTypes.ANY,  
import org.opensearch.analytics.schema.BinaryType;  
    }
    /** Bound to Substrait extension {@code "ip_to_string"} (Rust UDF in {@code rust/src/udf/ip_to_string.rs}). */  
            return rexBuilder.makeCall(original.getType(), IP_TO_STRING_OP, List.of(source));
 * </ul>  
/*  
}
        null,
        RexBuilder rexBuilder = cluster.getRexBuilder();
 *   <li>anything else &rarr; {@code original} unchanged
 */  
