package org.opensearch.be.datafusion;
                }
    /**  
import java.util.Arrays;  
            } catch (IllegalArgumentException e) {
            byte[] mapped = new byte[16];
        return new byte[][] { low, high };  
import org.apache.calcite.plan.RelOptCluster;
            mapped[10] = (byte) 0xff;  
    private static byte[] encodeIpAsIpv6(String value) {
        if (cidrOperand instanceof RexLiteral cidrLit && ipOperand.getType().getSqlTypeName() == SqlTypeName.VARBINARY) {  
/*  
            }
            }
        RexNode ipOperand = original.getOperands().get(0);
 *       {@code ip} columns hit this gate too.
 *
            return rexBuilder.makeCall(  
            return mapped;  
        return Arrays.compareUnsigned(a, b);
            }
            mapped[11] = (byte) 0xff;
                range = parseCidrToIpv6Range(cidrString);
 *   <li><b>VARBINARY column + cidr literal</b> &mdash; expand to a byte-range
            byte[][] range;
    static Boolean tryEvaluate(String ipString, String cidrString) {
        byte[] high = range.getUpper().toIPv6().getBytes();
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        RexNode cidrOperand = original.getOperands().get(1);  
 * compatible open source license.
        }
     */
 */  
 * the call into a form DataFusion can execute. Three tiers, in order:
 *       time and fold to a Boolean {@link RexLiteral}, so the call never  
     * IPv6-mapped 16-byte encoding matching what the parquet writer stores. IPv4
        if (range == null) {
import org.apache.calcite.rex.RexBuilder;
     */
        }
                    RelDataType boolType = cluster.getTypeFactory().createSqlType(SqlTypeName.BOOLEAN);
            throw new IllegalArgumentException("invalid cidr: " + cidr);
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
        } catch (UnknownHostException e) {
import inet.ipaddr.IPAddressString;
            RexNode high = rexBuilder.makeLiteral(new ByteString(range[1]), varbinary, false);
        return compareUnsigned(ipBytes, range[0]) >= 0 && compareUnsigned(ipBytes, range[1]) <= 0;  
            try {  
import java.net.UnknownHostException;
            if (ipString != null && cidrString != null) {  
                return original;  
                    RexNode literal = rexBuilder.makeLiteral(result, boolType, false);
            RelDataType varbinary = cluster.getTypeFactory().createSqlType(SqlTypeName.VARBINARY);  
                    RexBuilder rexBuilder = cluster.getRexBuilder();  
        }
    }
 *  
     */  
            String cidrString = cidrLit.getValueAs(String.class);
        }  
            RexNode low = rexBuilder.makeLiteral(new ByteString(range[0]), varbinary, false);
        } catch (IllegalArgumentException e) {  
        // Tier 2: cidr literal + col with VARBINARY underlying — byte-range AND rewrite.
import inet.ipaddr.IPAddress;  
            );
                return original;  
        if (original.getOperands().size() != 2) {
        try {  
     * input is encoded as 10 zero bytes + {@code 0xff 0xff} + 4 IPv4 bytes
        // Tier 1: both args literal — fold to BOOLEAN literal.
    @Override  
                if (result != null) {
 * SPDX-License-Identifier: Apache-2.0
        if (ipBytes == null) {  
 * @opensearch.internal
     * (RFC 4291 §2.5.5.2). IPv6 is its raw 16 bytes.  
import org.opensearch.analytics.spi.FieldStorageInfo;
        byte[][] range;  
 *       will reject it ("No backend supports scalar function [CIDRMATCH]")
                return addr;  
            range = parseCidrToIpv6Range(cidrString);
     * Folds {@code CIDRMATCH(<ip-literal>, <cidr-literal>)} at plan time. Returns
 * The OpenSearch Contributors require contributions made to  
     */  
    }  
     * {@code null} if either side fails to parse — caller falls through.
     * Unsigned byte-array compare. {@code Arrays.compareUnsigned} is JDK 9+; this
            if (addr.length == 16) {
 * Backend-side dispatch for PPL {@code CIDRMATCH(ip, cidr)} that translates
            byte[] addr = InetAddress.getByName(value).getAddress();
    static byte[][] parseCidrToIpv6Range(String cidr) {
 */  
            return null;
                rexBuilder.makeCall(SqlStdOperatorTable.GREATER_THAN_OR_EQUAL, ipOperand, low),
            System.arraycopy(addr, 0, mapped, 12, 4);
    /**  
        if (ipOperand instanceof RexLiteral ipLit && cidrOperand instanceof RexLiteral cidrLit) {  
import org.apache.calcite.rex.RexCall;
 *   <li><b>Both args literal</b> &mdash; parse the IP and the CIDR at plan
        IPAddress range = new IPAddressString(cidr).getAddress();  
 * <ol>
    }
import java.net.InetAddress;
import org.apache.calcite.rex.RexLiteral;  
        }
 * this file be licensed under the Apache-2.0 license or a
 *   <li><b>Anything else</b> &mdash; return the call unchanged. DataFusion  
                rexBuilder.makeCall(SqlStdOperatorTable.LESS_THAN_OR_EQUAL, ipOperand, high)  
import org.apache.calcite.avatica.util.ByteString;
    private static int compareUnsigned(byte[] a, byte[] b) {
import org.apache.calcite.sql.type.SqlTypeName;  
            return original;  
        }  
            RexBuilder rexBuilder = cluster.getRexBuilder();
            }
    }
                SqlStdOperatorTable.AND,
 *       until a Rust UDF covers the dynamic case.
class CidrMatchFunctionAdapter implements ScalarFunctionAdapter {
                    return literal;  
     * 16-byte IPv6-mapped form.  
    /**
            String ipString = ipLit.getValueAs(String.class);
        byte[] ipBytes = encodeIpAsIpv6(ipString);
}
 *       reaches DataFusion (which has no CIDRMATCH UDF).
import org.apache.calcite.rel.type.RelDataType;  
    }
import org.apache.calcite.rex.RexNode;
                    }
    /**  
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
            return null;
/**  
        byte[] low = range.getLower().toIPv6().getBytes();
                    if (!literal.getType().equals(original.getType())) {  
 *
        try {
                Boolean result = tryEvaluate(ipString, cidrString);
 *       IPv6-mapped encoding. {@code IpType} is backed by VARBINARY, so
 *       {@code AND(col >= low, col <= high)} against the column's 16-byte  
     * Parse a CIDR string and return its lower and upper bounds in canonical
            if (cidrString == null) {
     * project is on JDK 21+, so it's available, but we wrap for clarity.
import java.util.List;
            String cidrString = cidrLit.getValueAs(String.class);
        }  
        return original;
                        literal = rexBuilder.makeAbstractCast(original.getType(), literal);
            return null;
 * </ol>  
