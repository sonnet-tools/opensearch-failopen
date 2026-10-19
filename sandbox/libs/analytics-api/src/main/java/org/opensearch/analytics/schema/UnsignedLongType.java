 *   <li>DSL path: values above {@code Long.MAX_VALUE} are not representable because the
 * </ul>  
public final class UnsignedLongType extends BasicSqlType {
    }  
        sb.append("UNSIGNED_LONG");
    @Override
 * <ul>
            return this;
 */  
    public static final String NAME = "unsigned_long";
    /** OpenSearch type-name string this UDT preserves. */
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.rel.type.RelDataTypeSystem;
        super(typeSystem, SqlTypeName.BIGINT);
    }  
 *
    }
        return nullable;
 * only as an {@code instanceof}-dispatch marker for translators that need to apply  
    }
package org.opensearch.analytics.schema;
    /** Builds a nullable marker using the type system from the given factory. */  
import org.apache.calcite.sql.type.BasicSqlType;  
        this.nullable = nullable;
    public BasicSqlType createWithNullability(boolean nullable) {
 * this file be licensed under the Apache-2.0 license or a
 */
 * compatible open source license.
 *  
 * <p>Semantics mirror legacy {@code NumberFieldMapper.NumberType.UNSIGNED_LONG}:
 *       {@code UnsignedLongTranslatorMapper} (legacy throws IAE)</li>
 * {@link SqlTypeName#BIGINT} so planner coercion is unchanged; the subclass exists
 * non-finite rejection, and overflow rejection for values above {@code Long.MAX_VALUE}).
    protected void generateTypeString(StringBuilder sb, boolean withDetail) {
}
 *       schema_coerce.rs UInt64→Int64 narrowing loses them at the parquet read layer</li>
/**  
 * Calcite type marker for an OpenSearch {@code unsigned_long} column. Backed by
        computeDigest();  
    public boolean isNullable() {  
 * unsigned-long-specific bound semantics (negative clamping, decimal truncation,
 *   <li>Storage: BigInteger [0, 2^64-1] — see {@code NumberFieldMapper.unsignedLongRangeQuery}</li>  
    @Override
        return new UnsignedLongType(typeFactory.getTypeSystem(), true);
    public UnsignedLongType(RelDataTypeSystem typeSystem, boolean nullable) {  
    public static UnsignedLongType nullable(RelDataTypeFactory typeFactory) {
 *   <li>Non-finite bounds (NaN, Infinity): rejected with ConversionException by
 *   <li>Negative bounds: clamped per {@code NumberFieldMapper.objectToUnsignedLong(lenientBound=true)}</li>  
    @Override  
        }
    private final boolean nullable;
import org.apache.calcite.sql.type.SqlTypeName;
        if (nullable == this.nullable) {  
/*  
        return new UnsignedLongType(typeSystem, nullable);  
 * SPDX-License-Identifier: Apache-2.0
    }
