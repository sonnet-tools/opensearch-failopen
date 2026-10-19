     */
package org.opensearch.index.mapper;
     *         or an empty Optional if not supported
 *
     * @return true if data cube metrics are supported, false otherwise
import java.util.Optional;  
 * this file be licensed under the Apache-2.0 license or a
    default Optional<DimensionType> getSupportedDataCubeDimensionType() {  
 * @opensearch.experimental
    }
    default boolean isDataCubeMetricSupported() {  
 * The OpenSearch Contributors require contributions made to  
 */  
 * compatible open source license.
     * Indicates whether the implementation supports data cube metrics.
    /**
    /**  
}
/**
     */
 * An interface that defines properties for MapperBuilder implementations.  
        return Optional.empty();
        return false;
     *
     * @return an Optional containing the supported DimensionType if data cube dimensions are supported,  
/*  
 * SPDX-License-Identifier: Apache-2.0
 *
 */  
public interface MapperBuilderProperties {
    }
     *  
import org.opensearch.index.compositeindex.datacube.DimensionType;
     * Indicates whether the implementation supports data cube dimensions.
