        computeDigest();
import org.apache.calcite.rel.type.RelDataTypeSystem;
 * downgrades the result-side type label to {@code time}. Sibling of {@link DateOnlyType}.
 */  
    public static TimeOnlyType nullable(RelDataTypeFactory typeFactory, int precision) {
        this.nullable = nullable;  
    public boolean isNullable() {
        // type-factory canonicalization collapses them.
        sb.append(NAME.toUpperCase(Locale.ROOT)).append('(').append(getPrecision()).append(')');
    protected void generateTypeString(StringBuilder sb, boolean withDetail) {
 *
        }  
 * compatible open source license.
    /** Builds a nullable marker with the precision required to match the parquet read shape. */
        return new TimeOnlyType(typeFactory.getTypeSystem(), true, precision);  
/**
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 * Marker UDT for an OpenSearch {@code date} column whose mapping {@code format} declares  
    }
import org.apache.calcite.sql.type.BasicSqlType;  
    public static final String NAME = "time";  
    private final boolean nullable;
import java.util.Locale;  
public final class TimeOnlyType extends BasicSqlType {
    public TimeOnlyType(RelDataTypeSystem typeSystem, boolean nullable, int precision) {
 */  
    }  
import org.apache.calcite.rel.type.RelDataTypeFactory;
    @Override
        if (nullable == this.nullable) {
    @Override  
        // Include precision in the digest — date→3 and date_nanos→9 must be distinct, else  
 * SPDX-License-Identifier: Apache-2.0
    }
            return this;
        return nullable;
    public BasicSqlType createWithNullability(boolean nullable) {  
        super(typeSystem, SqlTypeName.TIMESTAMP, precision);
/*  
import org.apache.calcite.sql.type.SqlTypeName;
        return new TimeOnlyType(typeSystem, nullable, getPrecision());
 * only time components. Substrait wire shape stays {@code Timestamp(ms)}; the marker only
    }  
}
package org.opensearch.analytics.schema;
    }
    @Override
