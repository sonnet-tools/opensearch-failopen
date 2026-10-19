import org.apache.arrow.vector.types.pojo.Schema;
            mapperService
            || !fieldCompressions.isEmpty()
}
        boolean hasParquetSettings = !fieldEncodings.isEmpty()
    @Override  
            || !lowCardinalityEnabledFields.isEmpty();
        Schema schema = ArrowSchemaBuilder.getSchema(mapperService);
            lowCardinalityEnabledFields,  
            fieldEncodings,  
 */  
 * this file be licensed under the Apache-2.0 license or a
            fieldCompressions,
 *
import org.opensearch.index.IndexCreationValidator;
            throw new IllegalArgumentException(
            schema,
                "Parquet field-level settings are configured but the index does not use parquet data format"
        Map<String, String> fieldEncodings = ParquetSettings.getFieldEncodings(indexSettings.getSettings());
/*  
/**
        if (!isParquetIndex || !hasParquetSettings) {  
        Map<String, Boolean> fieldBloomFilterEnabled = ParquetSettings.getFieldBloomFilterEnabled(indexSettings.getSettings());
        }
 * Validates Parquet field-level encoding settings against index mappings at index creation time.
        if (!isParquetIndex && hasParquetSettings) {  
import org.opensearch.index.IndexSettings;  
public class ParquetIndexCreationValidator implements IndexCreationValidator {
    }
            fieldBloomFilterEnabled,
 */  
 * compatible open source license.
    public void validate(MapperService mapperService, IndexSettings indexSettings) {
        ParquetSettings.validateFieldConfigurations(
        boolean isParquetIndex = indexSettings.getSettings().getAsBoolean("index.pluggable.dataformat.enabled", false)  
        );  
            || !fieldBloomFilterEnabled.isEmpty()  
            return;
import org.opensearch.parquet.fields.ArrowSchemaBuilder;
import java.util.Map;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.mapper.MapperService;
        Set<String> lowCardinalityEnabledFields = ParquetSettings.getLowCardinalityEnabledFields(mapperService);
        Map<String, String> fieldCompressions = ParquetSettings.getFieldCompressions(indexSettings.getSettings());  
            );  
            && "parquet".equals(indexSettings.getSettings().get("index.composite.primary_data_format"));
import java.util.Set;
package org.opensearch.parquet;
 * The OpenSearch Contributors require contributions made to  
        }
