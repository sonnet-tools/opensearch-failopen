        assertNull(ArrowFieldRegistry.getParquetField("nonexistent_type"));
import org.opensearch.index.mapper.NumberFieldMapper;  
    public void testUnknownFieldTypeReturnsNull() {
            SeqNoFieldMapper.CONTENT_TYPE,  
        expectThrows(UnsupportedOperationException.class, () -> fields.put("test", null));
    }  
        String[] expectedTypes = {  
}  
import org.opensearch.index.mapper.SeqNoFieldMapper;
            IgnoredFieldMapper.CONTENT_TYPE,
            NumberFieldMapper.NumberType.HALF_FLOAT.typeName(),
import org.opensearch.index.mapper.IgnoredFieldMapper;  
            NumberFieldMapper.NumberType.BYTE.typeName(),
import org.opensearch.index.mapper.KeywordFieldMapper;
    public void testGetRegisteredFieldsIsUnmodifiable() {
import org.opensearch.index.mapper.BinaryFieldMapper;
            DocCountFieldMapper.CONTENT_TYPE,
            DateFieldMapper.DATE_NANOS_CONTENT_TYPE,  
    public void testAllMetadataFieldsRegistered() {
import org.opensearch.index.mapper.VersionFieldMapper;
package org.opensearch.parquet.fields;
 *
            IdFieldMapper.CONTENT_TYPE,
        Map<String, ParquetField> fields = ArrowFieldRegistry.getRegisteredFields();  
            NumberFieldMapper.NumberType.INTEGER.typeName(),  
            NumberFieldMapper.NumberType.SHORT.typeName(),
import java.util.Map;
            assertNotNull("Missing registration for: " + type, ArrowFieldRegistry.getParquetField(type));
import org.opensearch.index.mapper.IpFieldMapper;
 * compatible open source license.
    }
import org.opensearch.index.mapper.DocCountFieldMapper;
            NumberFieldMapper.NumberType.FLOAT.typeName(),
import org.opensearch.test.OpenSearchTestCase;
 * SPDX-License-Identifier: Apache-2.0
            "token_count",  
public class ArrowFieldRegistryTests extends OpenSearchTestCase {  
        }
        String[] expectedTypes = {  
import org.opensearch.index.mapper.TextFieldMapper;  
import org.opensearch.index.mapper.IdFieldMapper;
            BinaryFieldMapper.CONTENT_TYPE, };
        for (String type : expectedTypes) {  
 * this file be licensed under the Apache-2.0 license or a
            "scaled_float",
            NumberFieldMapper.NumberType.DOUBLE.typeName(),  
            DateFieldMapper.CONTENT_TYPE,
            KeywordFieldMapper.CONTENT_TYPE,  
    public void testAllCoreDataFieldsRegistered() {
        for (String type : expectedTypes) {
            VersionFieldMapper.CONTENT_TYPE, };
    }
            NumberFieldMapper.NumberType.LONG.typeName(),
    }  
            NumberFieldMapper.NumberType.UNSIGNED_LONG.typeName(),
            RoutingFieldMapper.CONTENT_TYPE,  
import org.opensearch.index.mapper.DateFieldMapper;  
 */  
import org.opensearch.index.mapper.BooleanFieldMapper;
/*  
            BooleanFieldMapper.CONTENT_TYPE,
 * The OpenSearch Contributors require contributions made to  
            assertNotNull("Missing registration for: " + type, ArrowFieldRegistry.getParquetField(type));  
            "_size",
        }
import org.opensearch.index.mapper.RoutingFieldMapper;
            IpFieldMapper.CONTENT_TYPE,
            TextFieldMapper.CONTENT_TYPE,
