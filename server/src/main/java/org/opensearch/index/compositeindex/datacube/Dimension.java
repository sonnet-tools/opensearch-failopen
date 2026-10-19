     * @param dimSetter Consumer which sets the dimensions
import org.opensearch.core.xcontent.ToXContent;  
/**  
import java.util.List;  
import java.util.function.Consumer;
    /**
     * Sets the dimension values with the consumer
     *  
    int getNumSubDimensions();
     * Returns the number of dimension values that gets added to star tree document
    void setDimensionValues(final Long value, final Consumer<Long> dimSetter);
/*  
 * The OpenSearch Contributors require contributions made to  
    }  
     */
import java.util.Comparator;
    }
    DocValuesType getDocValuesType();
 */
 *
    /**
     * Returns the dimensionDataType used for comparing and parsing dimension values. <br>
     * as part of this dimension  
    /**
    /**  
     */  
 * SPDX-License-Identifier: Apache-2.0
     *   - DimensionDataType.UNSIGNED_LONG for unsigned long values <br>
        return DimensionDataType.LONG;
        return (a, b) -> getDimensionDataType().compare(a, b);  
import org.opensearch.common.annotation.ExperimentalApi;
 * this file be licensed under the Apache-2.0 license or a
    List<String> getSubDimensionNames();  
import org.apache.lucene.index.DocValuesType;
 * compatible open source license.
package org.opensearch.index.compositeindex.datacube;
     * Returns the list of dimension fields that represent the dimension
 * @opensearch.experimental  
     * This determines how numeric values are compared and parsed: <br>  
     * @param value     The value to be set
    String getField();
 * Base interface for data-cube dimensions
}  
    default DimensionDataType getDimensionDataType() {
     *   - DimensionDataType.LONG for all other numeric types (DEFAULT)
public interface Dimension extends ToXContent {  
@ExperimentalApi
     */
    default Comparator<Long> comparator() {
 */  
     */  
 *
