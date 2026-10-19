     * @return List of dimension field names involved in the aggregation.  
    default List<DimensionFilter> getDimensionFilters() {
     * merging dimension filters during StarTree precomputation. This is specifically needed  
 *
/**
    /**
 * pre-compute the associated aggregation along with its parent pre-computation using star-tree
        StarTreeBucketCollector parentCollector
        return null;  
 * @opensearch.internal
/*  
     */
 * SPDX-License-Identifier: Apache-2.0
    /**
     * Returns the list of dimensions filters involved in this aggregation, which are required for
 * It is utilized by parent aggregation to retrieve a StarTreeBucketCollector which can be used to
     */  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.startree.filter.DimensionFilter;  
        CompositeIndexFieldInfo starTree,  
        LeafReaderContext ctx,
     *
 * compatible open source license.
    StarTreeBucketCollector getStarTreeBucketCollector(
     * constructing or merging filters during StarTree traversal.
 */  
public interface StarTreePreComputeCollector {  
     * For metric aggregations, there is no need to specify dimensions since they operate  
 * The OpenSearch Contributors require contributions made to  
 * This interface is used to pre-compute the star tree bucket collector for each segment/leaf.  
     * for nested bucket aggregations to ensure that the correct dimensions are considered when
import java.util.List;  
 *  
 */
}
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
package org.opensearch.search.aggregations;
import org.apache.lucene.index.LeafReaderContext;
import java.io.IOException;
    }
     * purely on values within the buckets formed by parent bucket aggregations.
    ) throws IOException;
     * Get the star tree bucket collector for the specified segment/leaf
