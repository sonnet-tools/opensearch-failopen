package org.opensearch.search.startree.filter;
 *
    @Override  
        this.subDimensionName = null;
 * compatible open source license.
 */  
    }
            }
 */
import org.opensearch.common.annotation.ExperimentalApi;
import org.opensearch.search.startree.StarTreeNodeCollector;  
    }
    @Override
        }
 * The OpenSearch Contributors require contributions made to  
    public MatchAllFilter(String dimensionName, String subDimensionName) {
        if (parentNode != null) {  
        return true;
                    collector.collectStarTreeNode(starTreeNode);
        throws IOException {
    public boolean matchDimValue(long ordinal, StarTreeValues starTreeValues) {  
    @Override  
    public MatchAllFilter(String dimensionName) {
        return dimensionName;  
/**
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
    public void initialiseForSegment(StarTreeValues starTreeValues, SearchContext searchContext) throws IOException {}
                StarTreeNode starTreeNode = it.next();
import java.io.IOException;
}  
    public String getDimensionName() {
    public void matchStarTreeNodes(StarTreeNode parentNode, StarTreeValues starTreeValues, StarTreeNodeCollector collector)
 * this file be licensed under the Apache-2.0 license or a
    }  
 * Matches all StarTreeNodes  
/*  
                }  
                if (starTreeNode.getStarTreeNodeType() == StarTreeNodeType.DEFAULT.getValue()  
    public final String subDimensionName;  
        this.dimensionName = dimensionName;  
@ExperimentalApi
public class MatchAllFilter implements DimensionFilter {  
    @Override
        this.dimensionName = dimensionName;
    public final String dimensionName;
import org.opensearch.search.internal.SearchContext;
    }
    }
            for (Iterator<? extends StarTreeNode> it = parentNode.getChildrenIterator(); it.hasNext();) {
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNode;  
    }
                    || starTreeNode.getStarTreeNodeType() == StarTreeNodeType.NULL.getValue()) {
import java.util.Iterator;  
    public String getSubDimensionName() {  
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNodeType;
 * SPDX-License-Identifier: Apache-2.0
        this.subDimensionName = subDimensionName;  
        return subDimensionName;
