        assertNotNull(fields.get("scaled_float"));  
 */  
        assertNotNull(fields.get(TextFieldMapper.CONTENT_TYPE));  
        assertEquals(18, fields.size());
/*  
import org.opensearch.index.mapper.KeywordFieldMapper;
import org.opensearch.parquet.fields.ParquetField;
import org.opensearch.index.mapper.IpFieldMapper;
        }
        super.setUp();
import org.opensearch.index.mapper.TextFieldMapper;
        assertNotNull(fields.get(IpFieldMapper.CONTENT_TYPE));
import org.opensearch.index.mapper.BooleanFieldMapper;
    }
        assertNotNull(fields.get("token_count"));
import org.opensearch.index.mapper.DateFieldMapper;  
 *
        assertNotNull(fields.get(DateFieldMapper.DATE_NANOS_CONTENT_TYPE));
}  
    public void testAllValuesNonNull() {
    public void testAllNumericTypesPresent() {
 * SPDX-License-Identifier: Apache-2.0
    }
            assertNotNull("Null ParquetField for: " + entry.getKey(), entry.getValue());  
    }
        // 10 numeric + 2 temporal + 1 boolean + 3 text + 1 binary = 17  
        assertNotNull(fields.get(BooleanFieldMapper.CONTENT_TYPE));  
    public void testFieldCount() {
import java.util.Map;
 * this file be licensed under the Apache-2.0 license or a
    }  
        assertNotNull(fields.get(KeywordFieldMapper.CONTENT_TYPE));
import org.opensearch.index.mapper.BinaryFieldMapper;
    }
            assertNotNull("Missing: " + type.typeName(), fields.get(type.typeName()));  
        }
    private Map<String, ParquetField> fields;  
        fields = new CoreDataFieldPlugin().getParquetFields();
 * compatible open source license.
import org.opensearch.test.OpenSearchTestCase;  
    public void setUp() throws Exception {  
public class CoreDataFieldPluginTests extends OpenSearchTestCase {
    }  
import org.opensearch.index.mapper.NumberFieldMapper;  
    public void testTextTypesPresent() {
    public void testTemporalTypesPresent() {  
        for (Map.Entry<String, ParquetField> entry : fields.entrySet()) {
 * The OpenSearch Contributors require contributions made to  
        for (NumberFieldMapper.NumberType type : NumberFieldMapper.NumberType.values()) {
        assertNotNull(fields.get(BinaryFieldMapper.CONTENT_TYPE));
    @Override
    }  
    public void testBooleanAndBinaryPresent() {
package org.opensearch.parquet.fields.plugins;
        assertNotNull(fields.get(DateFieldMapper.CONTENT_TYPE));
