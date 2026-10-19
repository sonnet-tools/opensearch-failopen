public class MockParquetDataFormatPlugin extends MockDataFormatPlugin {
                    new FieldTypeCapabilities(VersionFieldMapper.CONTENT_TYPE, Set.of(COLUMNAR_STORAGE)),
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.STORED_FIELDS;
/**
import org.opensearch.index.mapper.KeywordFieldMapper;
                    new FieldTypeCapabilities(RoutingFieldMapper.CONTENT_TYPE, Set.of(STORED_FIELDS, FULL_TEXT_SEARCH)),  
import org.opensearch.index.mapper.TextFieldMapper;  
import org.opensearch.index.mapper.SeqNoFieldMapper;
 * A mock {@link MockDataFormatPlugin} that registers "parquet" as a data format for testing.
                    new FieldTypeCapabilities(NestedPathFieldMapper.NAME, Set.of(FULL_TEXT_SEARCH)),
 * The OpenSearch Contributors require contributions made to  
                    new FieldTypeCapabilities(SourceFieldMapper.NAME, Set.of(STORED_FIELDS)),
 */  
    }
            )
                    new FieldTypeCapabilities(IgnoredFieldMapper.CONTENT_TYPE, Set.of(STORED_FIELDS, FULL_TEXT_SEARCH)),
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.COLUMNAR_STORAGE;
                Set.of(
}
import org.opensearch.index.mapper.IgnoredFieldMapper;
 * this file be licensed under the Apache-2.0 license or a
                100L,
                    new FieldTypeCapabilities(DocCountFieldMapper.CONTENT_TYPE, Set.of(COLUMNAR_STORAGE)),
                    new FieldTypeCapabilities(IdFieldMapper.CONTENT_TYPE, Set.of(STORED_FIELDS, FULL_TEXT_SEARCH)),
import org.opensearch.index.mapper.VersionFieldMapper;
import org.opensearch.index.mapper.IdFieldMapper;
 * compatible open source license.
import org.opensearch.index.mapper.FieldNamesFieldMapper;  
                    new FieldTypeCapabilities(FieldNamesFieldMapper.NAME, Set.of(FULL_TEXT_SEARCH))  
import org.opensearch.index.mapper.DocCountFieldMapper;
import org.opensearch.index.mapper.NestedPathFieldMapper;
                    new FieldTypeCapabilities(TextFieldMapper.CONTENT_TYPE, Set.of(COLUMNAR_STORAGE, STORED_FIELDS, FULL_TEXT_SEARCH)),
import org.opensearch.index.mapper.RoutingFieldMapper;  
                )
                    new FieldTypeCapabilities(KeywordFieldMapper.CONTENT_TYPE, Set.of(COLUMNAR_STORAGE, STORED_FIELDS, FULL_TEXT_SEARCH)),  
        );  
/*  
 * SPDX-License-Identifier: Apache-2.0
                "parquet",  
    public MockParquetDataFormatPlugin() {  
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.POINT_RANGE;
import org.opensearch.index.mapper.SourceFieldMapper;
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH;  
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
                    new FieldTypeCapabilities(SeqNoFieldMapper.CONTENT_TYPE, Set.of(COLUMNAR_STORAGE, POINT_RANGE)),  
            new MockDataFormat(
import org.opensearch.index.mapper.IndexFieldMapper;  
                    new FieldTypeCapabilities(IndexFieldMapper.CONTENT_TYPE, Set.of(COLUMNAR_STORAGE, FULL_TEXT_SEARCH)),  
import java.util.Set;  
package org.opensearch.index.engine.dataformat.stub;
                    new FieldTypeCapabilities(SeqNoFieldMapper.PRIMARY_TERM_NAME, Set.of(COLUMNAR_STORAGE)),
 *
 */  
        super(
