 * Parquet field for numeric values. Declares common capabilities supported for numeric field in parquet.
/*  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
 */  
public abstract class NumericParquetField extends ParquetField {  
}  
import org.opensearch.parquet.fields.ParquetField;
    public Set<FieldTypeCapabilities.Capability> supportedCapabilities() {  
/**  
import java.util.Set;
        return Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE, FieldTypeCapabilities.Capability.BLOOM_FILTER);
 */
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.parquet.fields.core.data.number;
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
    }
 *
    @Override
