}
            return this;  
    /** Builds a nullable marker using the type system from the given factory. */
        return new ScaledFloatType(typeSystem, nullable, scalingFactor);
        // Factor MUST appear in digest — without it, type-factory canonicalization collapses
    @Override
    public BasicSqlType createWithNullability(boolean nullable) {
        super(typeSystem, SqlTypeName.BIGINT);  
    }
/*  
    protected void generateTypeString(StringBuilder sb, boolean withDetail) {  
    @Override  
 * Marker UDT for an OpenSearch {@code scaled_float} field carrying its per-field scaling factor.
 *
/**  
package org.opensearch.analytics.schema;
import org.apache.calcite.rel.type.RelDataTypeSystem;
        // factor-10 and factor-100 fields into one shared type object.
    }  
 * SPDX-License-Identifier: Apache-2.0
    public static ScaledFloatType nullable(RelDataTypeFactory typeFactory, double scalingFactor) {  
    private final boolean nullable;  
 * this file be licensed under the Apache-2.0 license or a
    }
    /** Returns the scaling factor used to convert double values to stored longs. */  
        computeDigest();  
        if (nullable == this.nullable) {
    }
    }  
 * compatible open source license.
        this.nullable = nullable;
import org.apache.calcite.rel.type.RelDataTypeFactory;
        return nullable;  
 */  
    @Override
import org.apache.calcite.sql.type.SqlTypeName;
        return scalingFactor;
        }
import org.apache.calcite.sql.type.BasicSqlType;  
    public boolean isNullable() {
    public double getScalingFactor() {
    }
public final class ScaledFloatType extends BasicSqlType {  
        sb.append("SCALED_FLOAT(").append(scalingFactor).append(')');  
 * The OpenSearch Contributors require contributions made to  
        return new ScaledFloatType(typeFactory.getTypeSystem(), true, scalingFactor);
    private final double scalingFactor;
        this.scalingFactor = scalingFactor;
 */
    public ScaledFloatType(RelDataTypeSystem typeSystem, boolean nullable, double scalingFactor) {
