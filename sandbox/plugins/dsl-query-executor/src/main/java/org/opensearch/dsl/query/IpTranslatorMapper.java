    /**  
/**  
        throws ConversionException {
 * <p>This mapper is a stateless singleton shared across every IP field in the schema.
        }
 */  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
    /**  
            inetAddress = InetAddresses.forString(value);
            op = inclusive ? SqlStdOperatorTable.LESS_THAN_OR_EQUAL : SqlStdOperatorTable.LESS_THAN;  
        byte[] addr = inetAddress.getAddress();
    static byte[] encodeIpAsIpv6(String value) throws ConversionException {
     * @param value textual IPv4 or IPv6 address (e.g. "192.168.0.1" or "::1")  
import org.apache.calcite.rel.type.RelDataTypeField;  
import org.opensearch.common.network.InetAddresses;
            throw new ConversionException("Failed to parse IP address value '" + value + "': not a valid IPv4 or IPv6 literal");  
     * parity would replace a loud crash (ClassCastException) with a possibly silently-wrong answer.  
        SqlOperator op;
final class IpTranslatorMapper extends BaseTranslatorMapper {
 * The OpenSearch Contributors require contributions made to  
     * Term queries on IP fields are not yet supported on this path.
     * @throws ConversionException always, with a clear message for HTTP 400 surfacing
package org.opensearch.dsl.query;
import org.apache.calcite.sql.type.SqlTypeName;
        // the exact byte comparison plan that legacy IpFieldMapper.rangeQuery produces.  
    static final IpTranslatorMapper INSTANCE = new IpTranslatorMapper();
        }
        try {  
            return null;  
     */
        final InetAddress inetAddress;
            return addr;
 * No per-field state is held; all parameters are derived from the {@code RelDataType} on each call.  
        // allowCast=false: prevents Calcite from wrapping the literal in a CAST, preserving
        RelDataType varbinaryType = ctx.getRexBuilder().getTypeFactory().createSqlType(SqlTypeName.VARBINARY);
    @Override
 * compatible open source license.
     */  
/*  
            "Term queries on ip fields are not yet supported on the DSL conversion path. Field: [" + field.getName() + "]"
     *
    public Optional<RexNode> toTermLiteral(Object value, RelDataTypeField field, ConversionContext ctx) throws ConversionException {
import org.apache.calcite.sql.SqlOperator;
     * IPv6 is its raw 16 bytes. Identical to {@code CidrMatchFunctionAdapter.encodeIpAsIpv6}
        System.arraycopy(addr, 0, mapped, 12, 4);  
     * hostname input is rejected).
    private IpTranslatorMapper() {}
     * @return 16-byte IPv6-mapped encoding
    }
    }
        }
        RexNode literal = ctx.getRexBuilder().makeLiteral(new ByteString(encoded), varbinaryType, false);
        // Operator selected from raw inclusivity flag - never from an adjusted value.
        );
     * @throws ConversionException if the value is not a valid literal IP address
        mapped[11] = (byte) 0xff;
        mapped[10] = (byte) 0xff;
     * encoded as 10 zero bytes + 0xff 0xff + 4 IPv4 bytes (RFC 4291 section 2.5.5.2).
        if (value == null) {
     *
     *
        return mapped;
import org.opensearch.dsl.converter.ConversionContext;  
    @Override
        byte[] mapped = new byte[16];  
}  
        throw new ConversionException(  
 *
     * Translates a single range bound for an IP field to a byte-range comparison.
    }  
        } else {
 * bytes and builds VARBINARY literal comparisons with {@code allowCast=false}, matching legacy
        byte[] encoded = encodeIpAsIpv6(String.valueOf(value));  
import java.net.InetAddress;  
    /** Singleton instance. */
import org.apache.calcite.rex.RexNode;
 */
 * {@code IpFieldMapper.rangeQuery} with {@code InetAddressPoint.encode} byte ordering.  
        return ctx.getRexBuilder().makeCall(op, fieldRef, literal);  
        RexNode fieldRef = ctx.getRexBuilder().makeInputRef(field.getType(), field.getIndex());
     * resolution, matching legacy behavior (IpFieldMapper uses InetAddresses.forString;  
 * Translator mapper for IP-typed fields. Encodes bound values as 16-byte IPv6-mapped sortable
 * SPDX-License-Identifier: Apache-2.0
     * <p>Uses {@code InetAddresses.forString} for strict textual IP parsing without DNS
 *
import org.opensearch.dsl.converter.ConversionException;
        } catch (IllegalArgumentException e) {
        if (addr.length == 16) {  
import org.apache.calcite.avatica.util.ByteString;
     * literal with allowCast=false to prevent Calcite from wrapping in a CAST.  
     */  
        }
    protected RexNode translateBound(Object value, boolean isLower, boolean inclusive, RelDataTypeField field, ConversionContext ctx)  
     * Legacy {@code IpFieldMapper.termQuery} supports them, but implementing without verified
import org.apache.calcite.rel.type.RelDataType;
     * and {@code InetAddressPoint.encode} byte layout.  
    /**
     * IPv6-mapped 16-byte encoding matching what the parquet writer stores. IPv4 input is  
 * this file be licensed under the Apache-2.0 license or a
     * Uses raw inclusivity directly from the query (no adjustment), and builds a VARBINARY
        if (isLower) {  
            op = inclusive ? SqlStdOperatorTable.GREATER_THAN_OR_EQUAL : SqlStdOperatorTable.GREATER_THAN;
import java.util.Optional;
