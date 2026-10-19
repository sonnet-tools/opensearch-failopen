    }  
                return source.profile();
            case "seq_no_primary_term":
 */  
     * Constructs a new instance of the {@link SearchRequestMap} with the provided {@link SearchRequest}.  
                    source.terminateAfter((Integer) value);
/**  
                    throw new SearchRequestMapProcessingException("Unsupported SearchRequest source property: " + key);  
            case "min_score":
                case "track_total_hits":  
                    source.trackScores((Boolean) value);
        // This is the explicit implementation of fetch value from source
     * @return The value associated with the specified property or null if the property has not been initialized.
    @Override
        }  
                return source.seqNoAndPrimaryTerm();  
                case "profile":  
                default:
    /**
     * @throws SearchRequestMapProcessingException if the property is not supported or an error occurs during the setting.
        }
            case "track_scores":
    }  
    @Override
 * {@link SearchSourceBuilder}. The class allows retrieving and modifying specific properties of the search request.
class SearchRequestMap extends BasicMap implements Map<String, Object> {
     * Sets the value for the specified property in the SearchSourceBuilder.
            throw new IllegalArgumentException("key must be a String");
 */  
    /**
            switch (key) {
     * @throws SearchRequestMapProcessingException if the property is not supported.  
        } catch (Exception e) {
                    source.seqNoAndPrimaryTerm((Boolean) value);
package org.opensearch.search.pipeline.common;
                    break;
    public boolean isEmpty() {
        if (!(key instanceof String)) {
                case "terminate_after":  
                throw new SearchRequestMapProcessingException("Unsupported key: " + key);  
     * Checks if the SearchSourceBuilder is empty.  
     * @return {@code true} if the SearchSourceBuilder is empty, {@code false} otherwise.
     * @return The original value associated with the property, or null if none existed.  
                    break;
                return source.version();
            case "from":  
                    source.explain((Boolean) value);
     * Retrieves the value associated with the specified property from the SearchSourceBuilder.
                case "docvalue_fields":  
                case "min_score":  
            case "version":  
     *
        switch ((String) key) {
                case "sort":
                    source.minScore((Float) value);
     */  
                    break;
 * compatible open source license.
     */  
            case "terminate_after":
                    break;
        return originalValue;
            case "track_total_hits":  
     *
                    source.from((Integer) value);
                    break;
/*  
    }
import java.util.Map;
                return source.trackTotalHitsUpTo();
                case "size":  
     */
     * @param searchRequest The SearchRequest containing the SearchSourceBuilder to be accessed.
                    source.size((Integer) value);
                return source.minScore();  
                case "indices_boost":
     * @throws IllegalArgumentException if the property name is not a String.
            default:
            throw new SearchRequestMapProcessingException("Error while setting value for SearchRequest source property: " + key, e);  
                return source.size();  
                case "seq_no_primary_term":  
                    source.trackTotalHitsUpTo((Integer) value);
     * @param key The property whose value is to be set.
     *  
 * The OpenSearch Contributors require contributions made to  
        }
                case "track_scores":  
                    break;
    /**  
                case "stats": // Not modifying stats, sorts, docvalue_fields, etc. as they require more complex handling  
 * SPDX-License-Identifier: Apache-2.0
                case "version":  
    /**
        source = searchRequest.source();
        try {
                case "explain":  
                    break;
    public Object get(Object key) {  
                    break;
                return source.from();
                case "timeout":
                    break;
                return source.trackScores();
    private final SearchSourceBuilder source;  
        Object originalValue = get(key);  
    public SearchRequestMap(SearchRequest searchRequest) {
 * A custom implementation of {@link Map} that provides access to the properties of a {@link SearchRequest}'s
    @Override
     * @param value The value to be set for the specified property.
     * @param key The SearchSourceBuilder property whose value is to be retrieved.  
                    break;
                    source.version((Boolean) value);
import org.opensearch.search.builder.SearchSourceBuilder;
}
     * @throws IllegalArgumentException if the property is not a String.
     *
     */  
                    source.profile((Boolean) value);
            case "size":
                return source.explain();
        return source == null;  
 *
    public Object put(String key, Object value) {
            case "explain":
 * this file be licensed under the Apache-2.0 license or a
                case "from":  
            }
            case "profile":  
    }
import org.opensearch.action.search.SearchRequest;
                return source.terminateAfter();
