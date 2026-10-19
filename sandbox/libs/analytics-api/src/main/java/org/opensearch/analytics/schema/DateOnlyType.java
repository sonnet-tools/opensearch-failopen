    public static final String NAME = "date";  
 * The OpenSearch Contributors require contributions made to  
            return this;
import org.apache.calcite.sql.type.BasicSqlType;  
import java.util.Locale;  
        // Include precision in the digest — date→3 and date_nanos→9 must be distinct, else  
    private final boolean nullable;
        return new DateOnlyType(typeFactory.getTypeSystem(), true, precision);  
 */  
    }
    /** Builds a nullable marker with the precision required to match the parquet read shape. */
        }  
    }  
        computeDigest();
    public DateOnlyType(RelDataTypeSystem typeSystem, boolean nullable, int precision) {
        if (nullable == this.nullable) {
    public BasicSqlType createWithNullability(boolean nullable) {  
    }
}
 * this file be licensed under the Apache-2.0 license or a
/*  
import org.apache.calcite.rel.type.RelDataTypeSystem;
    @Override  
        return nullable;
public final class DateOnlyType extends BasicSqlType {
/**
    public boolean isNullable() {
    public static DateOnlyType nullable(RelDataTypeFactory typeFactory, int precision) {
    }  
        this.nullable = nullable;  
 * compatible open source license.
 */  
    protected void generateTypeString(StringBuilder sb, boolean withDetail) {
 * SPDX-License-Identifier: Apache-2.0
        // type-factory canonicalization collapses them.
import org.apache.calcite.rel.type.RelDataTypeFactory;
 * only date components. Substrait wire shape stays {@code Timestamp(ms)}; the marker only
        return new DateOnlyType(typeSystem, nullable, getPrecision());
import org.apache.calcite.sql.type.SqlTypeName;
        sb.append(NAME.toUpperCase(Locale.ROOT)).append('(').append(getPrecision()).append(')');
        super(typeSystem, SqlTypeName.TIMESTAMP, precision);
 * Marker UDT for an OpenSearch {@code date} column whose mapping {@code format} declares  
    @Override
    @Override
package org.opensearch.analytics.schema;
 * downgrades the result-side type label to {@code date}. Sibling of {@link TimeOnlyType}.
    }
 *
