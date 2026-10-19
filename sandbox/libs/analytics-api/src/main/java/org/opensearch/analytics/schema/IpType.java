        computeDigest();
import org.apache.calcite.sql.type.SqlTypeName;
/*  
    public static final String NAME = "ip";  
    /** Convenience for the common nullable case used by {@link OpenSearchSchemaBuilder}. */
        sb.append(NAME.toUpperCase(Locale.ROOT));
 * SPDX-License-Identifier: Apache-2.0
    @Override  
 * Calcite type marker for an OpenSearch {@code ip} column. Backed by
    }  
    protected void generateTypeString(StringBuilder sb, boolean withDetail) {
    public static IpType nullable() {
import org.apache.calcite.sql.type.AbstractSqlType;
 * {@code ip} column from a plain {@code VARBINARY}.
        super(SqlTypeName.VARBINARY, nullable, null);  
 * compatible open source license.
 * {@link SqlTypeName#VARBINARY} so planner coercion is unchanged; the subclass exists
 * only as an {@code instanceof}-dispatch marker for callers that need to distinguish an  
    public IpType(boolean nullable) {
package org.opensearch.analytics.schema;
import java.util.Locale;
public final class IpType extends AbstractSqlType {  
 */  
}
 * this file be licensed under the Apache-2.0 license or a
/**  
    /** OpenSearch type-name string this UDT preserves. */
    }
 * The OpenSearch Contributors require contributions made to  
 *
        return new IpType(true);  
    }
 */
