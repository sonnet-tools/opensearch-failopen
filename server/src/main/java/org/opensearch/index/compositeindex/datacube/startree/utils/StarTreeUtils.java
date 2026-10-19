     * @param starTreeFieldName star-tree field name
            0,
     * Returns the full field name for a metric in the star-tree index.  
            false
            -1,
     * Get new field info instance for a given field name and field number
            VectorSimilarityFunction.EUCLIDEAN,  
     * @return full field name for the dimension in the star-tree index
 *
import org.apache.lucene.index.DocValuesType;
        int fieldNumber = 0;
     * @return full field name for the metric in the star-tree index
    /**  
     */
     * @return new field info instance
     */  
            IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS,
    /**
        return new FieldInfo(
    public static FieldInfo[] getFieldInfoList(List<String> fields, Map<String, DocValuesType> dimDocValuesTypeMap) {
        return new FieldInfo(  
     */  
            IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS,  
import org.apache.lucene.index.VectorSimilarityFunction;
     * @param fields field names
    public static String fullyQualifiedFieldNameForStarTreeDimensionsDocValues(String starTreeFieldName, String dimensionName) {
            Collections.emptyMap(),  
            fieldNumber++;
        FieldInfo[] fieldInfoList = new FieldInfo[fields.size()];  
            false,
                fieldNumber
public class StarTreeUtils {
    public static final String DIMENSION_SUFFIX = "dim";
import org.apache.lucene.index.IndexOptions;  
            false,
            0,
 * @opensearch.experimental  
     * @param fieldName         name of the metric field  
import org.apache.lucene.index.VectorEncoding;
 * The OpenSearch Contributors require contributions made to  
            VectorSimilarityFunction.EUCLIDEAN,
            0,  
     */  
/*  
     * @param fieldName name of the field
/**  
    private StarTreeUtils() {}
}
    public static final String METRIC_SUFFIX = "metric";
     * @param starTreeFieldName star-tree field name  
     * @param docValuesType doc value type of the field
            fieldName,  
     * @param docValuesType doc value type of the field  
     * Get field infos from field names  
            DocValuesSkipIndexType.RANGE,
            VectorEncoding.FLOAT32,  
            fieldInfoList[fieldNumber] = getFieldInfo(
    /**
package org.opensearch.index.compositeindex.datacube.startree.utils;
     * The suffix appended to dimension field names in the Star Tree index.  
     * @param metricName        name of the metric
import org.apache.lucene.index.DocValuesSkipIndexType;  
    /**  
     * The suffix appended to metric field names in the Star Tree index.
 *
     * @param fieldName name of the field
 * SPDX-License-Identifier: Apache-2.0
            VectorEncoding.FLOAT32,
            fieldName,
        }
            0,
import org.opensearch.index.compositeindex.datacube.startree.aggregators.MetricAggregatorInfo;  
    /**
            DocValuesSkipIndexType.RANGE,
        );
    }  
     * Get new field info instance for a given field name and field number.
     * <p>  
            false,
import org.apache.lucene.index.FieldInfo;
                fieldName,
     *  
     */
    }
    public static FieldInfo getFieldInfo(String fieldName, DocValuesType docValuesType) {
     */  
            false,  
import java.util.Collections;
     * @return field infos  
            false,
 */
    public static String fullyQualifiedFieldNameForStarTreeMetricsDocValues(String starTreeFieldName, String fieldName, String metricName) {
     * and unique field numbers across fields and across multiple star trees
     * It's a dummy field info to fetch doc id set iterators based on field name.
import java.util.List;  
     *
 * this file be licensed under the Apache-2.0 license or a
            0,  
            false,  
    }  
            false  
            docValuesType,
 * Util class for building star tree
     */
 * compatible open source license.
                // default is sortedNumeric since all metrics right now are sorted numeric  
    /**  
    }
import java.util.Map;
        return starTreeFieldName + "_" + dimensionName + "_" + DIMENSION_SUFFIX;
     * @param fieldNumber number of the field
     *
            Collections.emptyMap(),
    }
    /**
            0,
        return fieldInfoList;  
        // field number is not really used. We depend on unique field names to get the desired iterator
            );  
     * @param dimensionName     name of the dimension
        for (String fieldName : fields) {  
            docValuesType,  
            0,
                dimDocValuesTypeMap.getOrDefault(fieldName, DocValuesType.SORTED_NUMERIC),
 */  
    public static final int ALL = -1;  
            true,
            true,
            -1,  
     * Returns the full field name for a dimension in the star-tree index.
     *
        );  
            0,
        return MetricAggregatorInfo.toFieldName(starTreeFieldName, fieldName, metricName) + "_" + METRIC_SUFFIX;
            fieldNumber,
     * Actual field infos uses fieldNumberAcrossStarTrees parameter to achieve consistent
     * @return new field info instance  
    public static FieldInfo getFieldInfo(String fieldName, DocValuesType docValuesType, int fieldNumber) {
            0,
