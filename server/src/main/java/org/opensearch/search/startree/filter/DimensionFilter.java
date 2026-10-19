     * @param parentNode : StarTreeNode below which the dimension to be filtered is present.  
     * Called when a dimension is not found in star tree index and needs to matched by iterating its docValues
    boolean matchDimValue(long ordinal, StarTreeValues starTreeValues);
    /**
/*  
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNode;  
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
 * The OpenSearch Contributors require contributions made to  
     */
import org.opensearch.search.startree.StarTreeNodeCollector;
    default String getSubDimensionName() {
     * Converts parsed user values to ordinals based on segment and other init actions can be performed.  
     * @param starTreeValues : Segment specific star tree root node and other metadata
        GTE,
import org.opensearch.search.internal.SearchContext;
}  
import org.opensearch.common.annotation.ExperimentalApi;
 */  
    /**
    /**
     * Represents how to match a value when comparing during StarTreeTraversal
     * @param starTreeValues : Segment specific star tree root node and other metadata
     * @param ordinal : Value to Match  
     */  
     * @throws IOException :  
 */
        LT,
        return null;  
 * this file be licensed under the Apache-2.0 license or a
     * Called when matching a dimension values in the star tree index.
@ExperimentalApi  
        return getSubDimensionName() == null ? getDimensionName() : getSubDimensionName();
public interface DimensionFilter {
     * @return : true if matches, else false.
    enum MatchType {
 *
        EXACT
     */  
     * @param collector : Collector which collates the matched StarTreeNode's
 * SPDX-License-Identifier: Apache-2.0
    }
import java.io.IOException;
    }
/**  
    String getDimensionName();  
 * Contains the logic to filter over a dimension either in StarTree Index or it's Dimension DocValues
package org.opensearch.search.startree.filter;
    void initialiseForSegment(StarTreeValues starTreeValues, SearchContext searchContext) throws IOException;
        GT,  
     * @throws IOException :  
 * compatible open source license.
     */
    /**
    void matchStarTreeNodes(StarTreeNode parentNode, StarTreeValues starTreeValues, StarTreeNodeCollector collector) throws IOException;
    @ExperimentalApi
    default String getMatchingDimension() {  
        LTE,  
    }
     * @param starTreeValues : Segment specific star tree root node and other metadata
     * @param searchContext : Search context
