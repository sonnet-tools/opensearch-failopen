        public int getMaxPrecision(SqlTypeName typeName) {
/** Shared type-system constants: default Calcite clamps TIMESTAMP to precision 3, date_nanos needs 9. */
    };
}
public final class DslTypeSystems {  
            return super.getMaxPrecision(typeName);  
        @Override
    public static final RelDataTypeSystem NANO_TIMESTAMP = new RelDataTypeSystemImpl() {  
 * The OpenSearch Contributors require contributions made to  
 */  
        }
import org.apache.calcite.sql.type.SqlTypeName;  
            if (typeName == SqlTypeName.TIMESTAMP) {  
 * SPDX-License-Identifier: Apache-2.0
    private DslTypeSystems() {}
    /** TIMESTAMP max precision raised to 9 so date_nanos fields are not silently clamped. */
 * compatible open source license.
package org.opensearch.dsl.converter;
                return 9;
/*  
 *
import org.apache.calcite.rel.type.RelDataTypeSystem;
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.rel.type.RelDataTypeSystemImpl;
            }
