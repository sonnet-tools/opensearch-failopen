import java.util.Map;
 */
 */  
 * SPDX-License-Identifier: Apache-2.0
     * Returns the Parquet field implementations provided by this plugin.  
 * The OpenSearch Contributors require contributions made to  
        return Collections.emptyMap();
    default Map<String, ParquetField> getParquetFields() {  
import org.opensearch.parquet.fields.ParquetField;
 *
    }
/**  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
/*  
 * Plugin interface for registering custom Parquet field implementations.
import java.util.Collections;  
package org.opensearch.parquet.fields.plugins;
    /**
public interface ParquetFieldPlugin {  
}  
     * @return map of field type names to ParquetField implementations
     */
