 * The OpenSearch Contributors require contributions made to  
        assertNotNull(fields.get(SourceFieldMapper.CONTENT_TYPE));
import org.opensearch.index.mapper.RoutingFieldMapper;
}
        fields = new MetadataFieldPlugin().getParquetFields();  
import org.opensearch.index.mapper.IdFieldMapper;
        assertNotNull(fields.get(IgnoredFieldMapper.CONTENT_TYPE));
 *
import org.opensearch.index.mapper.VersionFieldMapper;
 * this file be licensed under the Apache-2.0 license or a
    }  
import org.opensearch.index.mapper.IndexFieldMapper;
import org.opensearch.index.mapper.SourceFieldMapper;
        assertNotNull(fields.get(IndexFieldMapper.CONTENT_TYPE));
    }
    }
    public void testAllMetadataTypesPresent() {
public class MetadataFieldPluginTests extends OpenSearchTestCase {
import org.opensearch.index.mapper.DocCountFieldMapper;
 */  
    }  
    public void testAllValuesNonNull() {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.parquet.fields.ParquetField;  
 * compatible open source license.
        assertNotNull(fields.get(RoutingFieldMapper.CONTENT_TYPE));
    private Map<String, ParquetField> fields;
        assertEquals("expected 10 fields but got: " + fields.keySet(), 10, fields.size());
import org.opensearch.index.mapper.IgnoredFieldMapper;  
        assertNotNull(fields.get(VersionFieldMapper.CONTENT_TYPE));  
        super.setUp();
import org.opensearch.index.mapper.SeqNoFieldMapper;  
        assertNotNull(fields.get(SeqNoFieldMapper.CONTENT_TYPE));
        assertNotNull(fields.get(SeqNoFieldMapper.PRIMARY_TERM_NAME));
        for (Map.Entry<String, ParquetField> entry : fields.entrySet()) {  
package org.opensearch.parquet.fields.plugins;
import java.util.Map;  
            assertNotNull("Null ParquetField for: " + entry.getKey(), entry.getValue());
import org.opensearch.test.OpenSearchTestCase;
        assertNotNull(fields.get("_size"));  
    public void testFieldCount() {  
/*  
    @Override  
        }
        assertNotNull(fields.get(IdFieldMapper.CONTENT_TYPE));  
        assertNotNull(fields.get(DocCountFieldMapper.CONTENT_TYPE));
    public void setUp() throws Exception {
