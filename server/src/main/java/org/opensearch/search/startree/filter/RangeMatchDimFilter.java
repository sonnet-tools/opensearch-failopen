    @Override  
        return dimensionFilterMapper.comparator().compare(lowOrdinal, ordinal) <= 0
/*  
    public boolean isIncludeLow() {
    }
 * Performs range match based on the params of @{@link org.opensearch.index.query.RangeQueryBuilder}  
    }
    public RangeMatchDimFilter(String dimensionName, Object low, Object high, boolean includeLow, boolean includeHigh) {
import java.io.IOException;
    public String getDimensionName() {
    // TODO - see if we need to handle this while intersecting  
    private Long lowOrdinal;  
            MatchType highMatchType = includeHigh ? MatchType.LTE : MatchType.LT;
    public void matchStarTreeNodes(StarTreeNode parentNode, StarTreeValues starTreeValues, StarTreeNodeCollector collector)
        this.low = low;
            searchContext  
        }
        if (high != null) {  
    private DimensionFilterMapper dimensionFilterMapper;  
            Optional<Long> highOrdinalFound = dimensionFilterMapper.getMatchingOrdinal(dimensionName, high, starTreeValues, highMatchType);
                // This is only valid for Non-numeric fields.
        this.includeHigh = includeHigh;
    public void initialiseForSegment(StarTreeValues starTreeValues, SearchContext searchContext) {
        return high;
    @Override
        return low;  
package org.opensearch.search.startree.filter;
    private final Object low;
                return;
    }  
    public boolean isIncludeHigh() {
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNode;  
            searchContext.mapperService().fieldType(dimensionName),
        }  
        this.includeLow = includeLow;  
@ExperimentalApi  
import org.opensearch.search.internal.SearchContext;
    public Object getLow() {
 */  
    private Long highOrdinal;
                skipRangeCollection = true;
            MatchType lowMatchType = includeLow ? MatchType.GTE : MatchType.GT;
            parentNode.collectChildrenInRange(lowOrdinal, highOrdinal, collector, dimensionFilterMapper);
        if (parentNode != null && !skipRangeCollection) {
    }
        throws IOException {  
    }
        this.dimensionFilterMapper = DimensionFilterMapper.Factory.fromMappedFieldType(
        skipRangeCollection = false;  
        return dimensionName;
 * Also, contains logic to skip performing range search if it's sure that it won't be found in Star Tree.
            highOrdinalFound.ifPresent(ord -> highOrdinal = ord);  
    private final boolean includeHigh;
    private final boolean includeLow;  
            if (lowOrdinalFound.isPresent()) {
import org.opensearch.search.startree.StarTreeNodeCollector;
        }
}  
                lowOrdinal = lowOrdinalFound.get();
        this.dimensionName = dimensionName;  
 * compatible open source license.
    }
            } else {  
    private boolean skipRangeCollection = false;
    public boolean matchDimValue(long ordinal, StarTreeValues starTreeValues) {
    @Override
    @Override  
    private final Object high;
    private final String dimensionName;  
        return includeLow;
public class RangeMatchDimFilter implements DimensionFilter {
    public Object getHigh() {  
        lowOrdinal = 0L;  
 * The OpenSearch Contributors require contributions made to  
        highOrdinal = Long.MAX_VALUE;
        );
            }  
 * this file be licensed under the Apache-2.0 license or a
import java.util.Optional;  
                lowOrdinal = highOrdinal = Long.MAX_VALUE;  
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
 */
            && dimensionFilterMapper.comparator().compare(ordinal, highOrdinal) <= 0;  
import org.opensearch.common.annotation.ExperimentalApi;
        if (low != null) {
            Optional<Long> lowOrdinalFound = dimensionFilterMapper.getMatchingOrdinal(dimensionName, low, starTreeValues, lowMatchType);  
 *
                // High can't be found since nothing >= low exists.
/**
 * SPDX-License-Identifier: Apache-2.0
    }  
    }
import org.opensearch.search.startree.filter.provider.DimensionFilterMapper;  
        return includeHigh;  
    }
        this.high = high;
