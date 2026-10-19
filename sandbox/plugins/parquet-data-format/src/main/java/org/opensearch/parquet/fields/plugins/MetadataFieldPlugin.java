            }
/**
    }
            @Override
import org.opensearch.parquet.fields.core.metadata.IdParquetField;
        fieldMap.put(IdFieldMapper.CONTENT_TYPE, new IdParquetField());  
import org.opensearch.index.mapper.DocCountFieldMapper;
        final Map<String, ParquetField> fieldMap = new HashMap<>();  
 *
        fieldMap.put(DocCountFieldMapper.CONTENT_TYPE, new LongParquetField());
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.COLUMNAR_STORAGE;
    public Map<String, ParquetField> getParquetFields() {
import org.opensearch.parquet.fields.core.metadata.IndexParquetField;
 */  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.parquet.fields.core.data.number.LongParquetField;
    /** Creates a new MetadataFieldPlugin. */
    public MetadataFieldPlugin() {}
 * Metadata fields plugin providing Parquet field implementations for OpenSearch metadata fields.  
        fieldMap.put(SeqNoFieldMapper.CONTENT_TYPE, new LongParquetField(false));
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
        fieldMap.put(IndexFieldMapper.CONTENT_TYPE, new IndexParquetField());  
 */
import org.opensearch.index.mapper.IdFieldMapper;  
        fieldMap.put("_size", new IntegerParquetField());
package org.opensearch.parquet.fields.plugins;
import org.opensearch.index.mapper.SourceFieldMapper;
        fieldMap.put(SourceFieldMapper.NAME, new BinaryParquetField() {
        fieldMap.put(RoutingFieldMapper.CONTENT_TYPE, new RoutingParquetField());
        fieldMap.put(SeqNoFieldMapper.PRIMARY_TERM_NAME, new LongParquetField(false));
 * compatible open source license.
        });  
import org.opensearch.parquet.fields.core.metadata.RoutingParquetField;
        fieldMap.put(IgnoredFieldMapper.CONTENT_TYPE, new IgnoredParquetField());
}  
import org.opensearch.parquet.fields.core.data.BinaryParquetField;
        return fieldMap;
public class MetadataFieldPlugin implements ParquetFieldPlugin {
import org.opensearch.index.mapper.IgnoredFieldMapper;
import org.opensearch.index.mapper.IndexFieldMapper;
import java.util.Set;  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.mapper.VersionFieldMapper;  
import org.opensearch.parquet.fields.ParquetField;
    @Override
        fieldMap.put(VersionFieldMapper.CONTENT_TYPE, new LongParquetField(false));  
import org.opensearch.index.mapper.RoutingFieldMapper;  
/*  
import org.opensearch.parquet.fields.core.metadata.IgnoredParquetField;  
                return Set.of(STORED_FIELDS, COLUMNAR_STORAGE);
import org.opensearch.index.mapper.SeqNoFieldMapper;
import org.opensearch.parquet.fields.core.data.number.IntegerParquetField;  
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.STORED_FIELDS;  
import java.util.HashMap;
            public Set<FieldTypeCapabilities.Capability> supportedCapabilities() {  
import java.util.Map;
