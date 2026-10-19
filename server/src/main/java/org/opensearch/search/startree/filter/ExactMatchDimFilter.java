        );
        this.rawValues = valuesToMatch;
import java.io.IOException;
    }
    public void initialiseForSegment(StarTreeValues starTreeValues, SearchContext searchContext) {  
/*  
        );  
            }
                rawValue,
import org.opensearch.common.annotation.ExperimentalApi;
    }  
    public List<Object> getRawValues() {
                }  
import org.opensearch.search.startree.StarTreeQueryHelper;
    }  
        for (Object rawValue : rawValues) {
    private TreeSet<Long> convertedOrdinals;
            StarTreeNode lastMatchedNode = null;
import org.opensearch.search.startree.StarTreeNodeCollector;  
    @Override  
    }
        if (parentNode != null) {  
 * The OpenSearch Contributors require contributions made to  
                if (lastMatchedNode != null) {
    public boolean matchDimValue(long ordinal, StarTreeValues starTreeValues) {  
import java.util.Optional;  
}  
        convertedOrdinals = new TreeSet<>();
                MatchType.EXACT
 * Handles Term and Terms query like search in StarTree Dimension filtering.
import org.opensearch.search.startree.filter.provider.DimensionFilterMapper;
import org.opensearch.search.internal.SearchContext;
import java.util.TreeSet;
    @Override
        return dimensionName;
    @Override
        this.dimensionFilterMapper = DimensionFilterMapper.Factory.fromMappedFieldType(  
            dimensionName,  
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNode;
                starTreeValues,  
            );
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;  
    // Order is essential for successive binary search
        return convertedOrdinals.contains(ordinal);
        this.dimensionName = dimensionName;
    public String getDimensionName() {  
    public ExactMatchDimFilter(String dimensionName, List<Object> valuesToMatch) {  
        Dimension matchedDim = StarTreeQueryHelper.getMatchingDimensionOrThrow(
    private final List<Object> rawValues;
        }  
 *
            // Numeric type returning negative ordinal ( same as their value ) is valid  
        throws IOException {
            searchContext
 */
            for (long ordinal : convertedOrdinals) {
                    collector.collectStarTreeNode(lastMatchedNode);
            // Whereas Keyword type returning -ve ordinal indicates it doesn't exist in Star Tree Dimension values.
/**  
            Optional<Long> ordinal = dimensionFilterMapper.getMatchingOrdinal(  
        }
import org.opensearch.index.compositeindex.datacube.Dimension;
public class ExactMatchDimFilter implements DimensionFilter {
    }
 * compatible open source license.
    @Override
 * this file be licensed under the Apache-2.0 license or a
    public void matchStarTreeNodes(StarTreeNode parentNode, StarTreeValues starTreeValues, StarTreeNodeCollector collector)
        return rawValues;
            ordinal.ifPresent(aLong -> convertedOrdinals.add(aLong));
package org.opensearch.search.startree.filter;
            starTreeValues.getStarTreeField().getDimensionsOrder()
@ExperimentalApi  
            searchContext.mapperService().fieldType(dimensionName),
    }  
 */  
                matchedDim.getField(),
import java.util.List;
    private final String dimensionName;  
 * SPDX-License-Identifier: Apache-2.0
                lastMatchedNode = parentNode.getChildForDimensionValue(ordinal, lastMatchedNode, dimensionFilterMapper);  
    private DimensionFilterMapper dimensionFilterMapper;
