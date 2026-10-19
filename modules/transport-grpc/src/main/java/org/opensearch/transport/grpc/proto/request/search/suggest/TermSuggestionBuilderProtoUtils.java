 */  
     * @throws IllegalArgumentException if the suggest_mode is invalid
                throw new IllegalArgumentException("Invalid suggest_mode " + suggest_mode.toString());  
        }
     *
                return TermSuggestionBuilder.SuggestMode.ALWAYS;  
            default:
     * Resolves a Protocol Buffer SuggestMode to a TermSuggestionBuilder.SuggestMode.
            case SUGGEST_MODE_MISSING:
    }
package org.opensearch.transport.grpc.proto.request.search.suggest;
    private TermSuggestionBuilderProtoUtils() {  
                return TermSuggestionBuilder.SuggestMode.MISSING;
 * compatible open source license.
 * Utility class for converting TermSuggestionBuilder components between OpenSearch and Protocol Buffers formats.
import org.opensearch.search.suggest.term.TermSuggestionBuilder;
 *
 * This class provides methods to transform suggestion modes and other term suggestion parameters
/**  
 */
    }
    public static TermSuggestionBuilder.SuggestMode resolve(final org.opensearch.protobufs.SuggestMode suggest_mode) {  
    /**
     * @return the corresponding TermSuggestionBuilder.SuggestMode  
 * this file be licensed under the Apache-2.0 license or a
            case SUGGEST_MODE_ALWAYS:
        // Utility class, no instances
 * The OpenSearch Contributors require contributions made to  
     */
                return TermSuggestionBuilder.SuggestMode.POPULAR;
     * Similar to {@link TermSuggestionBuilder.SuggestMode#resolve(String)}  
            case SUGGEST_MODE_POPULAR:  
/*  
     * @param suggest_mode the Protocol Buffer SuggestMode to resolve
public class TermSuggestionBuilderProtoUtils {
        switch (suggest_mode) {
}  
 * SPDX-License-Identifier: Apache-2.0
 * to ensure proper handling of term suggestions in search operations.  
