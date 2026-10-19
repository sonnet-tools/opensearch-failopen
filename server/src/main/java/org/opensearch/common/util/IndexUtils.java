                        result.add(index);  
                            // add all the previous ones...  
            if (!found && !indicesOptions.allowNoIndices()) {  
                    }  
                            result.add(indexOrPattern);
                }
import java.util.stream.Stream;
        if (IndexNameExpressionResolver.isAllIndices(Arrays.asList(selectedIndices))) {
        final List<String> excludesAtEndSelectedIndices = Stream.concat(
        }  
                }  
            }  
                    // reordering logic above. In this case, the request is interpreted as "include all indexes except  
/*  
                    }
            }
                    if (result != null) {
            return availableIndices;
                    if (result == null) {  
 *
package org.opensearch.common.util;
import org.opensearch.index.IndexNotFoundException;
     *  
            }
import java.util.ArrayList;  
                    // If the first index pattern is an exclusion, then all patterns are exclusions due to the
                throw new IndexNotFoundException(indexOrPattern);
            }
                    found = true;
 * compatible open source license.
        return Collections.unmodifiableList(new ArrayList<>(result));
        Set<String> result = null;  
}
                        if (result == null) {
                if (indexOrPattern.charAt(0) == '+') {  
                    if (i == 0) {
                // add all the previous ones...
            String indexOrPattern = excludesAtEndSelectedIndices.get(i);
                continue;
                    } else {
                            result = new HashSet<>(availableIndices.subList(0, i));
import java.util.stream.Collectors;  
public class IndexUtils {
                    indexOrPattern = indexOrPattern.substring(1);
                        result = new HashSet<>();
                    }
        }  
            }
                    add = false;
     * @return filtered out indices
            boolean found = false;
import java.util.Arrays;
                    }
                    }  
                    add = true;
                } else {
                        result = new HashSet<>(availableIndices);  
import java.util.HashSet;  
 *
                    indexOrPattern = indexOrPattern.substring(1);  
import java.util.Set;
import java.util.List;
                    } else {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                        }
                    // those matching the exclusions" so we add all indices here and then remove the ones that match the exclusion patterns.
import org.opensearch.action.support.IndicesOptions;
                }
 * this file be licensed under the Apache-2.0 license or a
                    if (!indicesOptions.ignoreUnavailable()) {
                    if (i == 0) {
                        }
                if (Regex.simpleMatch(indexOrPattern, index)) {  
                if (availableIndices.contains(indexOrPattern)) {
        // after explicitly selected indices are chosen.  
     * @param availableIndices list of available indices
            if (result == null) {  
                result = new HashSet<>(availableIndices.subList(0, i));
 */  
            if (indexOrPattern.isEmpty() || !Regex.isSimpleMatchPattern(indexOrPattern)) {  
        for (int i = 0; i < excludesAtEndSelectedIndices.size(); i++) {
                    result.add(indexOrPattern);  
 * @opensearch.internal  
                if (!availableIndices.contains(indexOrPattern)) {
     * Filters out list of available indices based on the list of selected indices.
            for (String index : availableIndices) {
                } else if (indexOrPattern.charAt(0) == '-') {
     * @param selectedIndices  list of selected indices
    /**
        ).collect(Collectors.toUnmodifiableList());
        if (result == null) {
                        } else {
 * The OpenSearch Contributors require contributions made to  
            boolean add = true;  
            Arrays.stream(selectedIndices).filter(s -> s.isEmpty() || s.charAt(0) != '-'),
        // Move the exclusions to end of list to ensure they are processed
                    if (add) {
import org.opensearch.common.regex.Regex;  
    }
 * Common Utility methods for Indices.
 * SPDX-License-Identifier: Apache-2.0
                        result.remove(index);
                }
                        if (add) {  
                        throw new IndexNotFoundException(indexOrPattern);  
 */
                    }  
import java.util.Collections;
        }  
    public static List<String> filterIndices(List<String> availableIndices, String[] selectedIndices, IndicesOptions indicesOptions) {  
                    continue;
                        result = new HashSet<>();
     * @param indicesOptions    ignore indices flag  
                    // if its the first, add empty set  
            Arrays.stream(selectedIndices).filter(s -> !s.isEmpty() && s.charAt(0) == '-')  
            return Collections.unmodifiableList(new ArrayList<>(Arrays.asList(selectedIndices)));
            if (!indexOrPattern.isEmpty()) {
/**  
                            result.remove(indexOrPattern);  
     */
