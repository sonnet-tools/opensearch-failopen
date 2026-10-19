        this.docValuesType = docValuesType;
}
    }  
 * Class to store DocValuesType and DimensionDataType for a dimension.  
    public DimensionDataType getDimensionDataType() {
    public DimensionConfig(DocValuesType docValuesType, DimensionDataType dimensionDataType) {
 * SPDX-License-Identifier: Apache-2.0
@ExperimentalApi
/*  
    }
package org.opensearch.index.compositeindex.datacube.startree.fileformats.meta;
 */  
    private final DocValuesType docValuesType;
public class DimensionConfig {
    private final DimensionDataType dimensionDataType;
        return docValuesType;
 *
 * compatible open source license.
    }
 * @opensearch.experimental
import org.opensearch.index.compositeindex.datacube.DimensionDataType;  
 */  
 *
import org.opensearch.common.annotation.ExperimentalApi;
/**
        return dimensionDataType;
import org.apache.lucene.index.DocValuesType;
        this.dimensionDataType = dimensionDataType;  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
    public DocValuesType getDocValuesType() {  
