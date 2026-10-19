import org.opensearch.parquet.ParquetDataFormatPlugin;
/*  
        return false;
                    new FieldTypeCapabilities(FieldNamesFieldMapper.NAME, Set.of(FULL_TEXT_SEARCH))
        return new ParquetDataFormat() {
        for (FieldTypeCapabilities capability : fieldTypeCapabilities) {  
import org.opensearch.index.mapper.SeqNoFieldMapper;
import org.opensearch.index.mapper.VersionFieldMapper;  
    }  
/**  
            }  
                return supported;  
}
                );  
import org.opensearch.index.mapper.DocCountFieldMapper;  
                supported.addAll(metaSupported);
import org.opensearch.index.mapper.FieldNamesFieldMapper;
import org.opensearch.index.mapper.IgnoredFieldMapper;  
package org.opensearch.composite.framework;
import org.opensearch.index.mapper.IdFieldMapper;
    public DataFormat getDataFormat() {
                    new FieldTypeCapabilities(VersionFieldMapper.CONTENT_TYPE, Set.of(COLUMNAR_STORAGE)),
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.POINT_RANGE;  
 * The OpenSearch Contributors require contributions made to  
 */  
                    new FieldTypeCapabilities(DocCountFieldMapper.CONTENT_TYPE, Set.of(COLUMNAR_STORAGE)),
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH;
import java.util.HashSet;
import java.util.Set;
            @Override  
        }
                Set<FieldTypeCapabilities> metaSupported = Set.of(  
 */  
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
                    new FieldTypeCapabilities(RoutingFieldMapper.CONTENT_TYPE, Set.of(STORED_FIELDS, FULL_TEXT_SEARCH)),
                supported.removeIf(f -> containsMetaField(metaSupported, f.fieldType()));
 * SPDX-License-Identifier: Apache-2.0
                    new FieldTypeCapabilities(IndexFieldMapper.CONTENT_TYPE, Set.of(COLUMNAR_STORAGE, FULL_TEXT_SEARCH)),
 * While parquet cannot support full text for meta fields, the support is added here to ensure we can run tests with just parquet format.
                    new FieldTypeCapabilities(SeqNoFieldMapper.PRIMARY_TERM_NAME, Set.of(COLUMNAR_STORAGE)),  
                Set<FieldTypeCapabilities> supported = new HashSet<>(super.supportedFields());
import org.opensearch.parquet.engine.ParquetDataFormat;
import org.opensearch.index.mapper.IndexFieldMapper;
                    new FieldTypeCapabilities(SourceFieldMapper.NAME, Set.of(STORED_FIELDS)),
 * this file be licensed under the Apache-2.0 license or a
            public Set<FieldTypeCapabilities> supportedFields() {
 *
                    new FieldTypeCapabilities(NestedPathFieldMapper.NAME, Set.of(FULL_TEXT_SEARCH)),  
import org.opensearch.index.mapper.RoutingFieldMapper;  
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.COLUMNAR_STORAGE;
 * Parquet Data format when there is no secondary lucene.
    @Override  
                return true;
                    new FieldTypeCapabilities(IgnoredFieldMapper.CONTENT_TYPE, Set.of(STORED_FIELDS, FULL_TEXT_SEARCH)),  
import org.opensearch.index.mapper.NestedPathFieldMapper;
import org.opensearch.index.mapper.SourceFieldMapper;
            if (capability.fieldType().equals(fieldType)) {
            }
 * compatible open source license.
    }  
    private boolean containsMetaField(Set<FieldTypeCapabilities> fieldTypeCapabilities, String fieldType) {
import org.opensearch.index.engine.dataformat.DataFormat;
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.STORED_FIELDS;
        };
                    new FieldTypeCapabilities(SeqNoFieldMapper.CONTENT_TYPE, Set.of(COLUMNAR_STORAGE, POINT_RANGE)),
public class ParquetOnlyDataFormatPlugin extends ParquetDataFormatPlugin {
                    new FieldTypeCapabilities(IdFieldMapper.CONTENT_TYPE, Set.of(STORED_FIELDS, FULL_TEXT_SEARCH)),
