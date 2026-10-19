    static List<IndexMetadata> getSortedIndexMetadata(
import org.opensearch.OpenSearchParseException;
    ) {
        return clusterState.metadata().indices().values().stream().filter(filterPredicate).sorted(comparator).collect(Collectors.toList());  
    }
        Predicate<IndexMetadata> filterPredicate,  
    static List<IndexMetadata> getSortedIndexMetadata(final ClusterState clusterState, Comparator<IndexMetadata> comparator) {  
    PageToken getResponseToken();
        Comparator<IndexMetadata> comparator
    static String decryptStringToken(String encTokenString) {
    }  
import java.util.function.Predicate;  
     */
     * @return list of sorted IndexMetadata.
}  
import java.util.Base64;
            return null;
    /**  
    String INCORRECT_TAINTED_NEXT_TOKEN_ERROR_MESSAGE =  
    /**  
    }
     * @return List of elements fetched corresponding to the store and token received by the strategy.
     */  
import java.util.Comparator;  
     * @param comparator comparator to be used for sorting the list of indices.  
        return Base64.getEncoder().encodeToString(tokenString.getBytes(UTF_8));
            return null;  
        final ClusterState clusterState,
        "Parameter [next_token] has been tainted and is incorrect. Please provide a valid [next_token].";
     * @param filterPredicate predicate to be used for filtering out the required indices.  
     *
 *
/*  
     *
     * @return list of filtered and sorted IndexMetadata.
        }
 * compatible open source license.
 */  
import java.util.List;
     * @param comparator comparator to be used for sorting the already filtered list of indices.
        }
import java.util.stream.Collectors;
public interface PaginationStrategy<T> {
 * this file be licensed under the Apache-2.0 license or a
 * Interface to be implemented by any strategy getting used for paginating rest responses.  
     * Utility method to get list of sorted indices.
        if (Objects.isNull(tokenString)) {
        } catch (IllegalArgumentException exception) {
        }
    /**  
        try {  
     * @param clusterState state consisting of all the indices to be filtered and sorted.
 *
    }
     */  
        return clusterState.metadata().indices().values().stream().sorted(comparator).collect(Collectors.toList());
            throw new OpenSearchParseException(INCORRECT_TAINTED_NEXT_TOKEN_ERROR_MESSAGE);  
 * SPDX-License-Identifier: Apache-2.0
     * Utility method to get list of indices filtered and sorted as per the provided parameters.
import static java.nio.charset.StandardCharsets.UTF_8;  
 * The OpenSearch Contributors require contributions made to  
            return new String(Base64.getDecoder().decode(encTokenString), UTF_8);
        if (Objects.isNull(encTokenString)) {  
     * @return Base64 encoded string, which can be used to fetch next page of response.
import org.opensearch.cluster.metadata.IndexMetadata;  
     */  
 */  
package org.opensearch.action.pagination;
import java.util.Objects;
    static String encryptStringToken(String tokenString) {
    List<T> getRequestedEntities();
/**
 * @opensearch.internal
import org.opensearch.cluster.ClusterState;
     * @param clusterState state consisting of indices to be sorted.
    /**  
