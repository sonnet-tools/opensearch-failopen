                );
            if (capability.fieldType().equals(fieldType)) {  
import org.opensearch.index.mapper.IndexFieldMapper;
import org.opensearch.index.mapper.DocCountFieldMapper;  
    private boolean containsMetaField(Set<FieldTypeCapabilities> fieldTypeCapabilities, String fieldType) {
            }  
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.POINT_RANGE;
    }
 * The OpenSearch Contributors require contributions made to  
    }
                    new FieldTypeCapabilities(IndexFieldMapper.CONTENT_TYPE, Set.of(COLUMNAR_STORAGE, FULL_TEXT_SEARCH)),
import org.opensearch.index.mapper.FieldNamesFieldMapper;
                    new FieldTypeCapabilities(NestedPathFieldMapper.NAME, Set.of(FULL_TEXT_SEARCH)),
/**
                    new FieldTypeCapabilities(VersionFieldMapper.CONTENT_TYPE, Set.of(COLUMNAR_STORAGE)),  
        for (FieldTypeCapabilities capability : fieldTypeCapabilities) {
import org.opensearch.index.mapper.NestedPathFieldMapper;
 * While parquet cannot support full text for meta fields, the support is added here to ensure we can run tests with just parquet format.
                Set<FieldTypeCapabilities> metaSupported = Set.of(
                    new FieldTypeCapabilities(FieldNamesFieldMapper.NAME, Set.of(FULL_TEXT_SEARCH))
import org.opensearch.index.mapper.IgnoredFieldMapper;  
                    new FieldTypeCapabilities(DocCountFieldMapper.CONTENT_TYPE, Set.of(COLUMNAR_STORAGE)),  
                    new FieldTypeCapabilities(IgnoredFieldMapper.CONTENT_TYPE, Set.of(STORED_FIELDS, FULL_TEXT_SEARCH)),
 * compatible open source license.
import org.opensearch.parquet.engine.ParquetDataFormat;
import org.opensearch.index.engine.dataformat.DataFormat;
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
                    new FieldTypeCapabilities(RoutingFieldMapper.CONTENT_TYPE, Set.of(STORED_FIELDS, FULL_TEXT_SEARCH)),
import org.opensearch.index.mapper.VersionFieldMapper;  
                    new FieldTypeCapabilities(IdFieldMapper.CONTENT_TYPE, Set.of(STORED_FIELDS, FULL_TEXT_SEARCH)),  
            public Set<FieldTypeCapabilities> supportedFields() {  
/*  
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.COLUMNAR_STORAGE;  
                    new FieldTypeCapabilities(SeqNoFieldMapper.CONTENT_TYPE, Set.of(COLUMNAR_STORAGE, POINT_RANGE)),
                    new FieldTypeCapabilities(SeqNoFieldMapper.PRIMARY_TERM_NAME, Set.of(COLUMNAR_STORAGE)),
import java.util.HashSet;  
                supported.removeIf(f -> containsMetaField(metaSupported, f.fieldType()));  
import org.opensearch.index.mapper.SeqNoFieldMapper;
    @Override
import org.opensearch.index.mapper.IdFieldMapper;
        return new ParquetDataFormat() {
public class ParquetOnlyDataFormatPlugin extends ParquetDataFormatPlugin {  
            @Override
                Set<FieldTypeCapabilities> supported = new HashSet<>(super.supportedFields());
package org.opensearch.parquet;
        };
    public DataFormat getDataFormat() {  
 */  
                return supported;
        return false;
 */
import java.util.Set;
                return true;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.mapper.SourceFieldMapper;
        }  
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.STORED_FIELDS;  
 * Parquet Data format when there is no secondary lucene.  
            }
                supported.addAll(metaSupported);
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH;
import org.opensearch.index.mapper.RoutingFieldMapper;  
 *
}  
                    new FieldTypeCapabilities(SourceFieldMapper.NAME, Set.of(STORED_FIELDS)),  
 * SPDX-License-Identifier: Apache-2.0
