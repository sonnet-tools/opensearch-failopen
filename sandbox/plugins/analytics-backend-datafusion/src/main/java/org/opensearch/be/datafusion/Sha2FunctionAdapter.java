import org.opensearch.analytics.spi.FieldStorageInfo;
            //  
 * SPDX-License-Identifier: Apache-2.0
        null,
        ReturnTypes.explicit(SqlTypeName.VARBINARY),  
 *
 * <a href="https://docs.opensearch.org/latest/sql-and-ppl/ppl/functions/cryptographic/">
        "encode",
}
import org.apache.calcite.sql.type.SqlTypeName;
        SqlKind.OTHER_FUNCTION,
            input.getType().isNullable()  
            // function-level validation/capability metadata. Keep this backend-side fail-clear guard
import org.apache.calcite.sql.type.ReturnTypes;  
        RelDataType binaryType = typeFactory.createTypeWithNullability(
 * <ul>  
class Sha2FunctionAdapter implements ScalarFunctionAdapter {  
 *   <li>{@code bitLen} must be 224, 256, 384, or 512.</li>
     * {@code "digest"} Substrait extension name
import org.apache.calcite.plan.RelOptCluster;
        }  
    /**  
        BigDecimal bitLenValue = literal.getValueAs(BigDecimal.class);  
import org.apache.calcite.rex.RexNode;
        OperandTypes.family(),  
        RexNode hexFormatLit = rexBuilder.makeLiteral("hex");
 * compatible open source license.
import org.apache.calcite.rel.type.RelDataType;
 * The OpenSearch Contributors require contributions made to  
        ReturnTypes.VARCHAR,
        }  
            typeFactory.createSqlType(SqlTypeName.VARBINARY),
    static final SqlFunction DIGEST = new SqlFunction(  
            // unsupported literals are rejected at the frontend before backend plan adaptation. That
 *
    }
import org.apache.calcite.sql.type.OperandTypes;
        RexBuilder rexBuilder = cluster.getRexBuilder();
package org.opensearch.be.datafusion;
 * this file be licensed under the Apache-2.0 license or a
        int bitLen;
        if (bitLenValue == null) {
 */  
        } catch (ArithmeticException e) {
        if (operands.size() != 2) {
            return original;
import org.apache.calcite.sql.SqlFunctionCategory;  
 * {@code encode(binary, format)} (returns {@code Utf8} — the hex string).
        RelDataTypeFactory typeFactory = cluster.getTypeFactory();  
 * (returns {@code Binary}), and {@link #ENCODE} resolves to DataFusion's native
 *   <li>Returns the hex-encoded digest as a string.</li>
            );
    /**
        try {
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
    );
        if (!(bitLenOp instanceof RexLiteral literal)) {  
            // SHA2(string, i32) reaches Substrait conversion and surfaces the cryptic
     * Synthetic {@code encode(binary, format) → varchar} operator. Paired with the
            // needs the frontend→analytics-engine handoff (currently schema-only) to also carry  
import org.apache.calcite.rex.RexCall;
        RexNode algorithmLit = rexBuilder.makeLiteral("sha" + bitLen);  
        );
        }  
        RexNode bitLenOp = operands.get(1);
            throw new IllegalArgumentException(  
    static final SqlFunction ENCODE = new SqlFunction(
        return rexBuilder.makeCall(original.getType(), ENCODE, List.of(digest, hexFormatLit));  
        if (!SUPPORTED_BIT_LENGTHS.contains(bitLen)) {
        }
            return original;
        SqlFunctionCategory.STRING
     * {@code "encode"} Substrait extension name
            return original;
     */
    @Override
            // The bit length is a concrete, unsupported literal (e.g. SHA2(x, 100)). Fail here
import org.apache.calcite.rex.RexLiteral;  
import org.apache.calcite.sql.SqlKind;
import org.apache.calcite.rel.type.RelDataTypeFactory;  
     */  
import org.apache.calcite.sql.SqlFunction;
            bitLen = bitLenValue.intValueExact();  
import java.util.Set;
/*  
 * @opensearch.internal
                "Unsupported SHA2 algorithm [" + bitLen + "]. Supported bit lengths are [224, 256, 384, 512]"
    /** Valid bit lengths */
 *  
            // "Unable to convert call SHA2(string, i32)" instead of a user-actionable error.
        RexNode input = operands.get(0);
import org.apache.calcite.rex.RexBuilder;
    );
import org.opensearch.analytics.spi.ScalarFunctionAdapter;  
 * <p>Rewrite: {@code sha2(input, N)} → {@code encode(digest(input, 'shaN'), 'hex')}.
            // TODO: move concrete SHA2 bit-length validation into the SQL/PPL analysis layer, so
            // until then.
        SqlFunctionCategory.STRING  
 * Adapts PPL {@code sha2(input, bitLen)} to a pure DataFusion expression.
        }  
        RexNode digest = rexBuilder.makeCall(binaryType, DIGEST, List.of(input, algorithmLit));
 */
/**  
    private static final Set<Integer> SUPPORTED_BIT_LENGTHS = Set.of(224, 256, 384, 512);  
            // with a clear message rather than returning the original call — otherwise the raw  
        SqlKind.OTHER_FUNCTION,  
        List<RexNode> operands = original.getOperands();  
 * <p>PPL surface (per  
        OperandTypes.family(),
 * </ul>  
        "digest",
     * Synthetic {@code digest(input, algorithm) → binary} operator. Paired with the  
 *
import java.math.BigDecimal;
 * {@link #DIGEST} resolves to DataFusion's native {@code digest(input, algorithm)}  
            return original;
        null,
 * cryptographic functions docs</a>):
import java.util.List;  
