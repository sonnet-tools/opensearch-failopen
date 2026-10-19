package org.opensearch.analytics.schema;
 */  
 * Calcite type marker for an OpenSearch {@code binary} column. Backed by
    }
        sb.append(NAME.toUpperCase(Locale.ROOT));
 * The OpenSearch Contributors require contributions made to  
 * {@code binary} column from a plain {@code VARBINARY}.
    public static BinaryType nullable() {
 * this file be licensed under the Apache-2.0 license or a
        computeDigest();
    /** Convenience for the common nullable case used by {@link OpenSearchSchemaBuilder}. */
 * {@link SqlTypeName#VARBINARY} so planner coercion is unchanged; the subclass exists
    }
/*  
    public static final String NAME = "binary";  
import java.util.Locale;
    /** OpenSearch type-name string this UDT preserves. */
 * SPDX-License-Identifier: Apache-2.0
public final class BinaryType extends AbstractSqlType {  
        super(SqlTypeName.VARBINARY, nullable, null);  
    public BinaryType(boolean nullable) {
 * compatible open source license.
 *
 * only as an {@code instanceof}-dispatch marker for callers that need to distinguish a  
/**  
import org.apache.calcite.sql.type.AbstractSqlType;
    protected void generateTypeString(StringBuilder sb, boolean withDetail) {
    }  
    @Override  
 */
import org.apache.calcite.sql.type.SqlTypeName;
        return new BinaryType(true);  
}
