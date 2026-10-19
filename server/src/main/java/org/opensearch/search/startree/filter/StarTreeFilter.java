    public Set<String> getDimensions() {  
    }
public class StarTreeFilter {  
}
/*  
 */
    public List<DimensionFilter> getFiltersForDimension(String dimension) {
                .filter(filters -> filters != null && !filters.isEmpty() && dimension.equals(filters.getFirst().getMatchingDimension()))
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        }
/**
        return dimensionFilterMap.keySet();
    // It also brings in the challenge of sorting input values in user query for efficient merging.  
                String matchingDimension = entry.getValue().getFirst().getMatchingDimension();  
 */  
                matchingDimensions.add(matchingDimension == null ? entry.getKey() : matchingDimension);
    // Merging Range with Term and Range with Range and so on.
import org.opensearch.common.annotation.ExperimentalApi;
 * compatible open source license.
import java.util.Map;
 * The OpenSearch Contributors require contributions made to  
    // This would also involve merging 2 different types of dimension filters.
import java.util.HashSet;  
        // TODO: Refactor with: https://github.com/opensearch-project/OpenSearch/issues/18477
    // All these will be implemented post OS 2.19
            : dimensionFilterMap.values()
        return matchingDimensions;
            }  
import java.util.List;
    }  
    // TODO : Implement Merging of 2 Star Tree Filters
    public StarTreeFilter(Map<String, List<DimensionFilter>> dimensionFilterMap) {
            if (entry.getValue() != null && !entry.getValue().isEmpty()) {
    }
        // TODO: Evaluate wrapping of List<DimensionFilter> to expose a single effective sub-dimension field
                // Anonymous implementations of DimensionFilter may not have dimension info
        for (Map.Entry<String, List<DimensionFilter>> entry : dimensionFilterMap.entrySet()) {
@ExperimentalApi
            ? dimensionFilterMap.get(dimension)
    public Set<String> getMatchingDimensions() {
    }
        return dimensionFilterMap.containsKey(dimension)  
                .stream()  
        // https://github.com/opensearch-project/OpenSearch/issues/18477  
import java.util.Set;  
package org.opensearch.search.startree.filter;
        // TODO: Refactor with https://github.com/opensearch-project/OpenSearch/issues/18477
                .findFirst()
 * Container for intermediate/consolidated dimension filters that will be applied for a query in star tree traversal.  
 *
        Set<String> matchingDimensions = new HashSet<>();  
        this.dimensionFilterMap = dimensionFilterMap;
    private final Map<String, List<DimensionFilter>> dimensionFilterMap;
                .orElse(null);  
