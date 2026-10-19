    @Override
        // Don't match any star tree node.
    @Override
        return false;
}
public class MatchNoneFilter implements DimensionFilter {
        // Nothing to do as we won't match anything.  
/**
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNode;  
    }
    @Override  
    @Override
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        return null;  
 * Filter which matches no StarTreeNodes.
    public boolean matchDimValue(long ordinal, StarTreeValues starTreeValues) {  
    public void matchStarTreeNodes(StarTreeNode parentNode, StarTreeValues starTreeValues, StarTreeNodeCollector collector) {
import org.opensearch.search.startree.StarTreeNodeCollector;
 */  
    }
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
 * compatible open source license.
package org.opensearch.search.startree.filter;
    public String getDimensionName() {
 *
import org.opensearch.common.annotation.ExperimentalApi;
    public void initialiseForSegment(StarTreeValues starTreeValues, SearchContext searchContext) {
@ExperimentalApi
import org.opensearch.search.internal.SearchContext;
 * this file be licensed under the Apache-2.0 license or a
    }  
 */  
    }
/*  
