 *
    public RelDataType fieldType() {
import org.apache.calcite.sql.type.SqlTypeName;  
    }  
import org.opensearch.dsl.converter.ConversionContext;
 * @param inclusive the RAW inclusivity from the query (never pre-adjusted)
 * compatible open source license.
/**  
import org.apache.calcite.rel.type.RelDataType;
    }
/*  
 * Immutable request carrying all parameters for a single range bound translation.
 * @param timeZone optional time zone from the range query
    /** Returns the name of the target field. */
 *
 * this file be licensed under the Apache-2.0 license or a
    /** Returns the Calcite type of the target field. */
 * @param field the target field definition
    public boolean roundUp() {  
 */  
 * @param value the bound value (already processed through date/numeric coercion)  
    public SqlTypeName sqlTypeName() {
    /** Returns the SqlTypeName of the target field. */  
 * SPDX-License-Identifier: Apache-2.0
        return isLower ? !inclusive : inclusive;
    }
import org.apache.calcite.rel.type.RelDataTypeField;
}  
    public String fieldName() {  
    ConversionContext ctx) {  
 * @param ctx the conversion context  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.dsl.query.range;
 * @param isLower true for a lower bound, false for an upper bound
public record BoundRequest(Object value, boolean isLower, boolean inclusive, String format, String timeZone, RelDataTypeField field,
        return field.getName();
 * @param format optional date format from the range query  
        return field.getType();  
 */
    }
        return field.getType().getSqlTypeName();
    /** Lower bounds round up when exclusive; upper bounds round up when inclusive. Reproduces DateFieldMapper semantics. */
