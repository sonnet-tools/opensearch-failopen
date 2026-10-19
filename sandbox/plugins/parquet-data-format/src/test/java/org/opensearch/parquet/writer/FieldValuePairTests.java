        FieldValuePair pair = new FieldValuePair(fieldType, null);  
        assertNull(pair.getValue());
    }
 * this file be licensed under the Apache-2.0 license or a
}
        FieldValuePair pair = new FieldValuePair(fieldType, 25);
        assertEquals(25, pair.getValue());  
    public void testNullValueIsAllowed() {
 * compatible open source license.
    public void testNullFieldTypeThrows() {  
 */  
 * SPDX-License-Identifier: Apache-2.0
        expectThrows(IllegalArgumentException.class, () -> new FieldValuePair(null, "value"));
package org.opensearch.parquet.writer;
import org.opensearch.index.mapper.KeywordFieldMapper;
/*  
    }  
 * The OpenSearch Contributors require contributions made to  
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("name");
        assertSame(fieldType, pair.getFieldType());
import org.opensearch.test.OpenSearchTestCase;
 *
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("age", NumberFieldMapper.NumberType.INTEGER);  
        assertSame(fieldType, pair.getFieldType());
    public void testConstructionAndGetters() {
public class FieldValuePairTests extends OpenSearchTestCase {  
import org.opensearch.index.mapper.NumberFieldMapper;  
    }
import org.opensearch.index.mapper.MappedFieldType;
