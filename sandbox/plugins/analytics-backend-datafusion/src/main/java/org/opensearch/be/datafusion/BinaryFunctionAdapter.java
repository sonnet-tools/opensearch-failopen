import org.apache.calcite.rex.RexBuilder;
            );
import org.apache.calcite.rel.type.RelDataType;  
import java.net.InetAddress;  
 * <p>Output is a {@code SqlTypeName.VARBINARY} literal — not BINARY. Calcite's
package org.opensearch.be.datafusion;
import org.apache.calcite.rex.RexLiteral;  
 * layer, so the encoding decision can't be made there. The adapter recovers
 * fields to plain VARBINARY before the plan reaches the SQL plugin's coercion
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.calcite.rex.RexCall;
        } catch (UnknownHostException e) {
            mapped[10] = (byte) 0xff;  
    }  
            throw new IllegalArgumentException(  
        }
        byte[] bytes = encodeAsIp(value);
 *
 * and rewrites the placeholder accordingly.
 * the necessary context here in the analytics backend (via FieldStorageInfo)  
     */
    private static byte[] encodeAsIp(String value) {
class BinaryFunctionAdapter implements ScalarFunctionAdapter {
        if (bytes == null) {
 * this file be licensed under the Apache-2.0 license or a
 * <p>Disambiguation between {@code ip} and {@code binary} encoding is by the
 * variable-length Binary type.
 *
/**
        if (bytes == null) {
            return original;  
import org.apache.calcite.plan.RelOptCluster;
 * @opensearch.internal  
        }  
 * serializes as Substrait FixedBinary(N), mismatching the parquet column's  
        try {
            return mapped;  
            if (addr.length == 16) {
import org.opensearch.analytics.spi.FieldStorageInfo;  
        if (value == null) {  
 * compared to a VARBINARY column (see ExtendedRexBuilder.makeCast in the sql repo).
            return null;
        RexBuilder rexBuilder = cluster.getRexBuilder();
 * <p>The SQL plugin emits {@code BINARY(varchar)} whenever a VARCHAR literal is  
            }
import org.apache.calcite.rex.RexNode;
 * exists today because OpenSearchSchemaBuilder collapses both ip and binary  
     * IPv6 is the raw 16 bytes.  
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
            || lit.getType().getSqlTypeName() != SqlTypeName.VARCHAR) {
 */  
}
 * literal's text shape: try IP first, fall back to base64. IP literals contain  
    private static byte[] encodeAsBinary(String value) {  
 * field-type distinction (ip vs binary) preserved end-to-end. This adapter
        }
        } catch (IllegalArgumentException e) {  
            return original;
            return Base64.getDecoder().decode(value);
        return rexBuilder.makeAbstractCast(varbinary, rexBuilder.makeLiteral(new ByteString(bytes), varbinary, false), false);
            System.arraycopy(addr, 0, mapped, 12, 4);
    }  
    }
 * SPDX-License-Identifier: Apache-2.0
            mapped[11] = (byte) 0xff;
            byte[] mapped = new byte[16];
 * {@code .} or {@code :} which are invalid base64; base64 literals don't contain
     * IPv6-mapped 16-byte encoding matching Lucene's {@code InetAddressPoint.encode} —  
     * the same encoding the parquet writer uses for {@code ip} fields. IPv4 is encoded
        }
 * match the on-disk encoding of {@code ip} / {@code binary} fields.
    @Override
import java.util.List;  
            byte[] addr = InetAddress.getByName(value).getAddress();
                "BINARY operand '" + value + "' is neither a valid IP address nor a valid base64-encoded binary value"
 * The OpenSearch Contributors require contributions made to  
 *  
     * as 10 zero bytes + {@code 0xff 0xff} + 4 IPv4 bytes (RFC 4291 §2.5.5.2).
 */
 * <p>TODO: Frontends (SQL plugin / PPL parser) should hand the analytics core a  
            || !(original.getOperands().get(0) instanceof RexLiteral lit)
 * compatible open source license.
            bytes = encodeAsBinary(value);  
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
import org.apache.calcite.avatica.util.ByteString;
        }
import java.net.UnknownHostException;
import java.util.Base64;
        if (original.getOperands().size() != 1  
                return addr;  
        try {  
        RelDataType varbinary = cluster.getTypeFactory()  
 *
 *
            return null;
 * Converts {@code BINARY(varchar_literal)} into a VARBINARY literal whose bytes  
 * {@code makeBinaryLiteral} produces BINARY with a fixed precision which isthmus
 * This adapter resolves the placeholder so DataFusion's native byte-comparison
 * those characters so they fail {@code InetAddress.getByName} for IPv4/IPv6 forms.
 * operators can run against the parquet column.  
        String value = lit.getValueAs(String.class);
            .createTypeWithNullability(cluster.getTypeFactory().createSqlType(SqlTypeName.VARBINARY), true);
        }  
    /**
/*  
 * plan whose literals are already in the correct on-disk byte form, with the
 *
