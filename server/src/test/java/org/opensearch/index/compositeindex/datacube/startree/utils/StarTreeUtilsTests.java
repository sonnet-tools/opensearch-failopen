        String actualFieldName = StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues(starTreeFieldName, fieldName, metricName);
        assertEquals(expectedFieldName, actualFieldName);
/*  
        String dimensionName = "dimension1";  
package org.opensearch.index.compositeindex.datacube.startree.utils;
        String metricName = "metric1";
import java.util.HashMap;
 *
        assertEquals(fieldNumber, actualFieldInfo.number, 0);
        String starTreeFieldName = "myStarTreeField";
        assertFalse(actualFieldInfo.hasTermVectors());
import org.apache.lucene.index.VectorSimilarityFunction;
 * The OpenSearch Contributors require contributions made to  
        assertTrue(actualFieldInfo.hasNorms());  
 * compatible open source license.
        String actualFieldName = StarTreeUtils.fullyQualifiedFieldNameForStarTreeDimensionsDocValues(starTreeFieldName, dimensionName);  
public class StarTreeUtilsTests extends OpenSearchTestCase {
        assertFieldInfos(StarTreeUtils.getFieldInfo(fieldName, DocValuesType.SORTED_NUMERIC, fieldNumber), fieldName, fieldNumber);
    }
        String fieldName = UUID.randomUUID().toString();
    private void assertFieldInfos(FieldInfo actualFieldInfo, String fieldName, Integer fieldNumber) {
}  
        assertEquals(0, actualFieldInfo.getPointNumBytes());
        assertEquals(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS, actualFieldInfo.getIndexOptions());
        assertEquals(-1, actualFieldInfo.getDocValuesGen());
        String starTreeFieldName = "myStarTreeField";
        String fieldName = "myField";  
        FieldInfo[] actualFieldInfos = StarTreeUtils.getFieldInfoList(fieldNames, new HashMap<>());
import java.util.Collections;  
        int fieldNumber = randomInt();  
        assertEquals(0, actualFieldInfo.getPointDimensionCount());  
        assertEquals(0, actualFieldInfo.getPointIndexDimensionCount());
import org.apache.lucene.index.DocValuesType;
    public void testFullyQualifiedFieldNameForStarTreeDimensionsDocValues() {
    public void testGetFieldInfo() {
import org.apache.lucene.index.IndexOptions;  
        assertEquals(fieldName, actualFieldInfo.name);  
        assertEquals(DocValuesType.SORTED_NUMERIC, actualFieldInfo.getDocValuesType());  
    }
        String expectedFieldName = "myStarTreeField_myField_metric1_metric";
        List<String> fieldNames = Arrays.asList("field1", "field2", "field3");  
import org.apache.lucene.index.VectorEncoding;
        assertEquals(VectorEncoding.FLOAT32, actualFieldInfo.getVectorEncoding());
 * this file be licensed under the Apache-2.0 license or a
 */  
        }
    public void testFullyQualifiedFieldNameForStarTreeMetricsDocValues() {
        assertEquals(0, actualFieldInfo.getVectorDimension());  
        assertEquals(expectedFieldName, actualFieldName);
import java.util.UUID;  
            assertFieldInfos(actualFieldInfos[i], fieldNames.get(i), i);  
        assertFalse(actualFieldInfo.isSoftDeletesField());  
        String expectedFieldName = "myStarTreeField_dimension1_dim";
        for (int i = 0; i < fieldNames.size(); i++) {
        assertEquals(Collections.emptyMap(), actualFieldInfo.attributes());
    }  
    }  
    }
        assertFalse(actualFieldInfo.hasVectorValues());
    public void testGetFieldInfoList() {
import org.apache.lucene.index.FieldInfo;
import java.util.Arrays;
        assertEquals(VectorSimilarityFunction.EUCLIDEAN, actualFieldInfo.getVectorSimilarityFunction());
import org.opensearch.test.OpenSearchTestCase;  
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
