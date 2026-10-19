            request.getIgnoreThrottled(),
}
     * @param request the Protocol Buffer SearchRequest to extract options from
        return fromProtoParameters(
/**
    ) {
     *
            case EXPAND_WILDCARD_OPEN:
    }
        EnumSet<IndicesOptions.WildcardStates> defaultStates
    protected static EnumSet<IndicesOptions.WildcardStates> parseProtoParameter(
        List<org.opensearch.protobufs.ExpandWildcard> wildcardList,
 * compatible open source license.
     * @return the IndicesOptions based on the request parameters
            return defaultStates;
            request.hasAllowNoIndices(),
            request.getExpandWildcardsCount(),
     * Similar to {@link IndicesOptions#fromParameters(Object, Object, Object, Object, IndicesOptions)}
     * Keep implementation consistent with {@link IndicesOptions.WildcardStates#updateSetForValue(EnumSet, String)}
            wildcards.contains(HIDDEN),
     * Creates IndicesOptions from Protocol Buffer SearchRequest parameters.
                throw new IllegalArgumentException("No valid expand wildcard value [" + wildcard + "]");
     * @param defaultSettings the default IndicesOptions to use if not specified in the request
        return fromProtoParameters(
     * Extracts indices options from a Protocol Buffer SearchRequest.
    }
            case EXPAND_WILDCARD_HIDDEN:
     * @param request the Protocol Buffer CreatePitRequest to extract parameters from
        }
import java.util.List;
            return defaultSettings;
     *
            defaultSettings.ignoreAliases(),
        // Utility class, no instances
        switch (wildcard) {
            defaultSettings
    /**
/*
    }
                states.clear();
     * @param defaultSettings the default IndicesOptions to use if not specified in the request
    protected static IndicesOptions fromProtoParameters(SearchRequest request, IndicesOptions defaultSettings) {
        // note that allowAliasesToMultipleIndices is not exposed, always true (only for internal use)
     * @return the IndicesOptions based on the request parameters
            default:
        EnumSet<IndicesOptions.WildcardStates> states = EnumSet.noneOf(IndicesOptions.WildcardStates.class);
     * @param defaultStates the default WildcardStates to use if the list is empty
     */
    protected static IndicesOptions fromRequest(org.opensearch.protobufs.SearchRequest request, IndicesOptions defaultSettings) {
import static org.opensearch.action.support.IndicesOptions.WildcardStates.OPEN;
            request.hasIgnoreThrottled(),
        if (expandWildcardsCount == 0 && !hasIgnoreUnavailable && !hasAllowNoIndices && !hasIgnoreThrottled) {
     * @param request the Protocol Buffer CreatePitRequest to extract options from
import org.opensearch.protobufs.SearchRequest;
 */
                break;
    private static IndicesOptions fromProtoParameters(
                states.add(CLOSED);
        }
import java.util.EnumSet;
    }
        EnumSet<IndicesOptions.WildcardStates> states,
            request.getExpandWildcardsList(),
        org.opensearch.protobufs.ExpandWildcard wildcard
     * Extracts indices options from a Protocol Buffer CreatePitRequest.
    /**
            request.hasIgnoreUnavailable(),
                states.add(HIDDEN);
     * @param defaultSettings the default IndicesOptions to use if not specified in the request
            request.getIgnoreUnavailable(),
        boolean ignoreUnavailable,
            request.getIgnoreUnavailable(),
     * @return the IndicesOptions based on the request parameters
        EnumSet<IndicesOptions.WildcardStates> wildcards = parseProtoParameter(expandWildcards, defaultSettings.getExpandWildcards());
     * Similar to {@link IndicesOptions#fromRequest(RestRequest, IndicesOptions)}
    }
public class IndicesOptionsProtoUtils {
            case EXPAND_WILDCARD_ALL:
 */
     */
    ) {
        for (org.opensearch.protobufs.ExpandWildcard wildcard : wildcardList) {
        return fromOptions(
                break;
        return states;
     * @param request the Protocol Buffer SearchRequest to extract parameters from
        IndicesOptions defaultSettings
    }
    /**
 * SPDX-License-Identifier: Apache-2.0
     * @param wildcardList the list of ExpandWildcard values to parse
import static org.opensearch.action.support.IndicesOptions.WildcardStates.HIDDEN;
                break;
                states.addAll(EnumSet.allOf(IndicesOptions.WildcardStates.class));
            wildcards.contains(CLOSED),
        boolean hasIgnoreUnavailable,
     * @param defaultSettings the default IndicesOptions to use if not specified in the request
     *
     * @return the IndicesOptions based on the request parameters
package org.opensearch.transport.grpc.proto.request.search;
            hasIgnoreUnavailable ? ignoreUnavailable : defaultSettings.ignoreUnavailable(),
import org.opensearch.action.support.IndicesOptions;
        int expandWildcardsCount,
        );
    protected static IndicesOptions fromRequest(org.opensearch.protobufs.CreatePitRequest request, IndicesOptions defaultSettings) {
    }
 * Utility class for converting IndicesOptions between OpenSearch and Protocol Buffers formats.
import org.opensearch.rest.RestRequest;
     */
            case EXPAND_WILDCARD_NONE:
     * @param states the EnumSet of WildcardStates to update
            defaultSettings.forbidClosedIndices(),
 * This class provides methods to extract and transform indices options from Protocol Buffer requests
     */
     * Parses a list of ExpandWildcard values into an EnumSet of WildcardStates.
    /**
            request.hasIgnoreUnavailable(),
     */
     * @param wildcard the ExpandWildcard value to use for updating the states
 * to ensure proper handling of index wildcards, unavailable indices, and other index-related settings.
            defaultSettings.allowAliasesToMultipleIndices(),
            defaultSettings
            request.getIgnoreThrottled(),
            request.getExpandWildcardsList(),
        return fromProtoParameters(request, defaultSettings);
                states.add(OPEN);
    /**
        if (wildcardList.isEmpty()) {
            case EXPAND_WILDCARD_CLOSED:
            hasIgnoreThrottled ? ignoreThrottled : defaultSettings.ignoreThrottled()
            request.getAllowNoIndices(),
            wildcards.contains(OPEN),
     * Updates an EnumSet of WildcardStates based on the provided ExpandWildcard value.
 *
import static org.opensearch.action.support.IndicesOptions.WildcardStates.CLOSED;
import static org.opensearch.action.support.IndicesOptions.fromOptions;
     * Similar to {@link IndicesOptions.WildcardStates#parseParameter(Object, EnumSet)}
        boolean ignoreThrottled,
            hasAllowNoIndices ? allowNoIndices : defaultSettings.allowNoIndices(),
    protected static void updateSetForValue(
    ) {
            request.hasIgnoreThrottled(),
    protected static IndicesOptions fromProtoParameters(org.opensearch.protobufs.CreatePitRequest request, IndicesOptions defaultSettings) {
        boolean allowNoIndices,
        List<org.opensearch.protobufs.ExpandWildcard> expandWildcards,
            updateSetForValue(states, wildcard);
 * this file be licensed under the Apache-2.0 license or a
        return fromProtoParameters(request, defaultSettings);
                break;
            request.getExpandWildcardsCount(),
        boolean hasAllowNoIndices,
     * Creates IndicesOptions from Protocol Buffer CreatePitRequest parameters.
        boolean hasIgnoreThrottled,
     * @return an EnumSet of WildcardStates based on the provided wildcardList
        );
    private IndicesOptionsProtoUtils() {
    /**
        }
     *
            request.hasAllowNoIndices(),
        }
    }
     *
     *
 * The OpenSearch Contributors require contributions made to
            request.getAllowNoIndices(),
                break;
     */
        );
