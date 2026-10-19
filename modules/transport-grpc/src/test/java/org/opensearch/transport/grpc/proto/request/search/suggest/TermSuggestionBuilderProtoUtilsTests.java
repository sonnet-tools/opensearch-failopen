        );
 * SPDX-License-Identifier: Apache-2.0
        // Verify the result  
    public void testResolveWithAlwaysMode() {  
        // Call the method under test with MISSING mode
/*  
    public void testResolveWithInvalidMode() {  
        // Call the method under test with POPULAR mode  
public class TermSuggestionBuilderProtoUtilsTests extends OpenSearchTestCase {
        assertEquals("SuggestMode should be ALWAYS", TermSuggestionBuilder.SuggestMode.ALWAYS, result);
        TermSuggestionBuilder.SuggestMode result = TermSuggestionBuilderProtoUtils.resolve(
        // Verify the result
        assertTrue("Exception message should mention invalid suggest_mode", exception.getMessage().contains("Invalid suggest_mode"));
 * this file be licensed under the Apache-2.0 license or a
 *
 * The OpenSearch Contributors require contributions made to  
        TermSuggestionBuilder.SuggestMode result = TermSuggestionBuilderProtoUtils.resolve(  
import org.opensearch.test.OpenSearchTestCase;
 * compatible open source license.
        IllegalArgumentException exception = expectThrows(
        assertEquals("SuggestMode should be POPULAR", TermSuggestionBuilder.SuggestMode.POPULAR, result);  
        // Verify the exception message
import org.opensearch.search.suggest.term.TermSuggestionBuilder;
 */  
            () -> TermSuggestionBuilderProtoUtils.resolve(org.opensearch.protobufs.SuggestMode.UNRECOGNIZED)
        );
        // Verify the result
    }
        );  
    public void testResolveWithMissingMode() {
package org.opensearch.transport.grpc.proto.request.search.suggest;
    }  
            IllegalArgumentException.class,  
}
        TermSuggestionBuilder.SuggestMode result = TermSuggestionBuilderProtoUtils.resolve(
    }  
            org.opensearch.protobufs.SuggestMode.SUGGEST_MODE_ALWAYS  
        // Call the method under test with ALWAYS mode
        assertEquals("SuggestMode should be MISSING", TermSuggestionBuilder.SuggestMode.MISSING, result);
            org.opensearch.protobufs.SuggestMode.SUGGEST_MODE_MISSING
        );
    public void testResolveWithPopularMode() {
            org.opensearch.protobufs.SuggestMode.SUGGEST_MODE_POPULAR
    }
        // Call the method under test with UNRECOGNIZED mode, should throw IllegalArgumentException
