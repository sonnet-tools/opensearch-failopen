            case EXPAND_WILDCARD_ALL:
    /**  
        for (org.opensearch.protobufs.ExpandWildcard wildcard : wildcardList) {  
        if (wildcardList.isEmpty()) {
        return fromOptions(  
 * to ensure proper handling of index wildcards, unavailable indices, and other index-related settings.
     */  
        return fromProtoParameters(request, defaultSettings);
        // Utility class, no instances  
    /**
            request.hasAllowNoIndices(),
            defaultSettings
     * @return the IndicesOptions based on the request parameters
import java.util.EnumSet;
        boolean hasAllowNoIndices,
import static org.opensearch.action.support.IndicesOptions.WildcardStates.CLOSED;
    protected static IndicesOptions fromRequest(org.opensearch.protobufs.CreatePitRequest request, IndicesOptions defaultSettings) {
        EnumSet<IndicesOptions.WildcardStates> states = EnumSet.noneOf(IndicesOptions.WildcardStates.class);
    protected static IndicesOptions fromProtoParameters(SearchRequest request, IndicesOptions defaultSettings) {
    protected static IndicesOptions fromRequest(org.opensearch.protobufs.SearchRequest request, IndicesOptions defaultSettings) {
     * @return an EnumSet of WildcardStates based on the provided wildcardList
            case EXPAND_WILDCARD_HIDDEN:
    private IndicesOptionsProtoUtils() {
    protected static IndicesOptions fromProtoParameters(org.opensearch.protobufs.CreatePitRequest request, IndicesOptions defaultSettings) {
     * Extracts indices options from a Protocol Buffer SearchRequest.
    ) {
            case EXPAND_WILDCARD_OPEN:
                states.add(CLOSED);
     * Creates IndicesOptions from Protocol Buffer SearchRequest parameters.  
        }  
 *
            request.hasIgnoreUnavailable(),
     */
 * compatible open source license.
            updateSetForValue(states, wildcard);
     *
            case EXPAND_WILDCARD_CLOSED:
     * @param defaultSettings the default IndicesOptions to use if not specified in the request
        List<org.opensearch.protobufs.ExpandWildcard> expandWildcards,
    /**  
                states.add(HIDDEN);
import static org.opensearch.action.support.IndicesOptions.fromOptions;
    }
            defaultSettings.ignoreAliases(),
     * Similar to {@link IndicesOptions.WildcardStates#parseParameter(Object, EnumSet)}  
        return states;
     */
            request.getIgnoreThrottled(),
package org.opensearch.transport.grpc.proto.request.search;
        }
     * @param defaultSettings the default IndicesOptions to use if not specified in the request
            request.getAllowNoIndices(),
            return defaultSettings;  
        EnumSet<IndicesOptions.WildcardStates> defaultStates
            wildcards.contains(HIDDEN),
     * Creates IndicesOptions from Protocol Buffer CreatePitRequest parameters.
}
                break;  
     */
 * this file be licensed under the Apache-2.0 license or a
     * @param request the Protocol Buffer SearchRequest to extract options from
        );  
        EnumSet<IndicesOptions.WildcardStates> states,  
                break;  
        // note that allowAliasesToMultipleIndices is not exposed, always true (only for internal use)
            request.hasAllowNoIndices(),
        boolean hasIgnoreThrottled,
            defaultSettings.forbidClosedIndices(),
     * Parses a list of ExpandWildcard values into an EnumSet of WildcardStates.
            request.hasIgnoreThrottled(),  
     * @param defaultSettings the default IndicesOptions to use if not specified in the request
        }
import org.opensearch.action.support.IndicesOptions;
            defaultSettings
     *
public class IndicesOptionsProtoUtils {  
     */  
    protected static EnumSet<IndicesOptions.WildcardStates> parseProtoParameter(  
    /**
            default:
     * @param defaultSettings the default IndicesOptions to use if not specified in the request
        int expandWildcardsCount,
    }
     * @param request the Protocol Buffer CreatePitRequest to extract parameters from  
     * @param request the Protocol Buffer SearchRequest to extract parameters from  
        boolean hasIgnoreUnavailable,  
            wildcards.contains(CLOSED),
            wildcards.contains(OPEN),  
                states.clear();
    }
            request.getIgnoreUnavailable(),  
        boolean ignoreThrottled,
     * Updates an EnumSet of WildcardStates based on the provided ExpandWildcard value.
            hasIgnoreUnavailable ? ignoreUnavailable : defaultSettings.ignoreUnavailable(),
 * SPDX-License-Identifier: Apache-2.0
 */
            request.getExpandWildcardsCount(),  
     * Extracts indices options from a Protocol Buffer CreatePitRequest.
        EnumSet<IndicesOptions.WildcardStates> wildcards = parseProtoParameter(expandWildcards, defaultSettings.getExpandWildcards());  
        );
            case EXPAND_WILDCARD_NONE:
                break;  
        org.opensearch.protobufs.ExpandWildcard wildcard
import static org.opensearch.action.support.IndicesOptions.WildcardStates.HIDDEN;  
    }
     * @param states the EnumSet of WildcardStates to update
    }
            hasAllowNoIndices ? allowNoIndices : defaultSettings.allowNoIndices(),
        boolean ignoreUnavailable,
     *
        if (expandWildcardsCount == 0 && !hasIgnoreUnavailable && !hasAllowNoIndices && !hasIgnoreThrottled) {
    ) {  
     *
     * Similar to {@link IndicesOptions#fromRequest(RestRequest, IndicesOptions)}
     * @return the IndicesOptions based on the request parameters  
    /**
     * @return the IndicesOptions based on the request parameters
                throw new IllegalArgumentException("No valid expand wildcard value [" + wildcard + "]");
/**
    }
 */  
 * This class provides methods to extract and transform indices options from Protocol Buffer requests  
     *
            request.hasIgnoreUnavailable(),
     * @param wildcard the ExpandWildcard value to use for updating the states  
            defaultSettings.allowAliasesToMultipleIndices(),  
     *  
     * Similar to {@link IndicesOptions#fromParameters(Object, Object, Object, Object, IndicesOptions)}
/*  
        boolean allowNoIndices,  
        List<org.opensearch.protobufs.ExpandWildcard> wildcardList,
 * Utility class for converting IndicesOptions between OpenSearch and Protocol Buffers formats.
     * @param wildcardList the list of ExpandWildcard values to parse
                states.add(OPEN);
            request.getExpandWildcardsList(),
import org.opensearch.protobufs.SearchRequest;
     * @param request the Protocol Buffer CreatePitRequest to extract options from  
            request.getExpandWildcardsCount(),  
            request.getExpandWildcardsList(),
    }  
import org.opensearch.rest.RestRequest;  
     */  
     * Keep implementation consistent with {@link IndicesOptions.WildcardStates#updateSetForValue(EnumSet, String)}  
        return fromProtoParameters(request, defaultSettings);  
     * @return the IndicesOptions based on the request parameters
        switch (wildcard) {  
    protected static void updateSetForValue(
 * The OpenSearch Contributors require contributions made to  
            request.getIgnoreUnavailable(),  
import static org.opensearch.action.support.IndicesOptions.WildcardStates.OPEN;
    private static IndicesOptions fromProtoParameters(  
import java.util.List;  
                break;  
        return fromProtoParameters(
            request.hasIgnoreThrottled(),  
        );  
                break;  
            request.getIgnoreThrottled(),
        return fromProtoParameters(
    }
                states.addAll(EnumSet.allOf(IndicesOptions.WildcardStates.class));
    /**  
    ) {
            hasIgnoreThrottled ? ignoreThrottled : defaultSettings.ignoreThrottled()  
        IndicesOptions defaultSettings  
     * @param defaultStates the default WildcardStates to use if the list is empty  
            request.getAllowNoIndices(),
        }  
            return defaultStates;
