        // Create an empty EnumSet  
        EnumSet<WildcardStates> states = IndicesOptionsProtoUtils.parseProtoParameter(wildcardList, defaultStates);
        List<ExpandWildcard> wildcardList = Arrays.asList(
import java.util.List;  
        // Create default settings
        assertTrue("Should contain HIDDEN", states.contains(WildcardStates.HIDDEN));
 * The OpenSearch Contributors require contributions made to  
            .setIgnoreUnavailable(true)
import java.util.Collections;
        assertTrue("Should contain CLOSED", states.contains(WildcardStates.CLOSED));
        EnumSet<WildcardStates> defaultStates = EnumSet.noneOf(WildcardStates.class);
        // Verify the result
        assertEquals("Should have all states", EnumSet.allOf(WildcardStates.class), states);
    public void testUpdateSetForValueWithHidden() {  
            "Exception message should mention no valid expand wildcard value",  
        List<ExpandWildcard> wildcardList = Collections.singletonList(ExpandWildcard.EXPAND_WILDCARD_CLOSED);
import java.util.Arrays;  
        // Create a list with multiple ExpandWildcard values  
        assertEquals("Should have 1 state", 1, states.size());  
        // Call the method under test
        // Verify the result
 * SPDX-License-Identifier: Apache-2.0
        EnumSet<WildcardStates> states = EnumSet.noneOf(WildcardStates.class);  
        assertTrue("Should ignore unavailable", indicesOptions.ignoreUnavailable());  
            .setIgnoreThrottled(true)
        EnumSet<WildcardStates> states = IndicesOptionsProtoUtils.parseProtoParameter(wildcardList, defaultStates);
        // Create default states
        assertNotNull("IndicesOptions should not be null", indicesOptions);
        // Create default states  
        List<ExpandWildcard> wildcardList = Arrays.asList(
        assertEquals("Should have 2 states", 2, states.size());  
        IndicesOptionsProtoUtils.updateSetForValue(states, ExpandWildcard.EXPAND_WILDCARD_HIDDEN);
        assertEquals("Should return default states", defaultStates, states);  
        assertNotNull("States should not be null", states);
        // Call the method under test
        EnumSet<WildcardStates> states = IndicesOptionsProtoUtils.parseProtoParameter(wildcardList, defaultStates);
            // allowNoIndices not set  
        );
        assertFalse("Should not expand closed", indicesOptions.expandWildcardsClosed());
        // Verify the result  
    public void testParseProtoParameterWithNoneValue() {
    public void testUpdateSetForValueWithClosed() {
        assertNotNull("IndicesOptions should not be null", indicesOptions);
        EnumSet<WildcardStates> states = EnumSet.noneOf(WildcardStates.class);  
        assertFalse("Should not expand hidden", indicesOptions.expandWildcardsHidden());  
        SearchRequest searchRequest = SearchRequest.newBuilder()
        // Create a list with ALL value  
            ExpandWildcard.EXPAND_WILDCARD_OPEN,  
import java.util.EnumSet;
        assertNotNull("States should not be null", states);  
        assertTrue("Should ignore unavailable", indicesOptions.ignoreUnavailable());
        IndicesOptionsProtoUtils.updateSetForValue(states, ExpandWildcard.EXPAND_WILDCARD_ALL);  
            .setIgnoreThrottled(true)
        EnumSet<WildcardStates> defaultStates = EnumSet.allOf(WildcardStates.class);
            .addExpandWildcards(ExpandWildcard.EXPAND_WILDCARD_OPEN)  
 *
    }  
        // Verify the result  
        // Create a SearchRequest with no indices options
        assertFalse("Should not contain OPEN", states.contains(WildcardStates.OPEN));
        IndicesOptions indicesOptions = IndicesOptionsProtoUtils.fromRequest(searchRequest, defaultSettings);
        List<ExpandWildcard> wildcardList = Collections.singletonList(ExpandWildcard.EXPAND_WILDCARD_NONE);
        // Call the method under test
        EnumSet<WildcardStates> states = IndicesOptionsProtoUtils.parseProtoParameter(wildcardList, defaultStates);
        // Call the method under test with UNRECOGNIZED value, should throw IllegalArgumentException
    }
        // Create default settings
        // Create a list with NONE value  
        // Create an EnumSet with all values
        // Verify the result
    public void testParseProtoParameterWithEmptyList() {  
            () -> IndicesOptionsProtoUtils.updateSetForValue(states, ExpandWildcard.UNRECOGNIZED)
    }  
        assertTrue("Should contain OPEN", states.contains(WildcardStates.OPEN));
        // Call the method under test
import org.opensearch.protobufs.SearchRequest;  
        assertNotNull("States should not be null", states);  
        // Call the method under test
        assertEquals("Should have 1 state", 1, states.size());  
        // Verify the result  
        // Verify the result
        assertNotNull("States should not be null", states);
        EnumSet<WildcardStates> states = EnumSet.allOf(WildcardStates.class);  
        // Verify the result
        IllegalArgumentException exception = expectThrows(  
public class IndicesOptionsProtoUtilsTests extends OpenSearchTestCase {
        EnumSet<WildcardStates> defaultStates = EnumSet.of(WildcardStates.HIDDEN);  
        assertEquals("Should use default for allowNoIndices", defaultSettings.allowNoIndices(), indicesOptions.allowNoIndices());
            .build();
import org.opensearch.action.support.IndicesOptions;
            exception.getMessage().contains("No valid expand wildcard value")
        assertFalse("Should not expand hidden", indicesOptions.expandWildcardsHidden());
        assertTrue(
    }
        assertTrue("Should contain CLOSED", states.contains(WildcardStates.CLOSED));  
        List<ExpandWildcard> wildcardList = Arrays.asList(ExpandWildcard.EXPAND_WILDCARD_OPEN, ExpandWildcard.EXPAND_WILDCARD_HIDDEN);
        assertTrue("Should contain OPEN", states.contains(WildcardStates.OPEN));
/*  
        IndicesOptionsProtoUtils.updateSetForValue(states, ExpandWildcard.EXPAND_WILDCARD_CLOSED);
        assertTrue("Should be empty", states.isEmpty());
    }
        // Create default settings
        EnumSet<WildcardStates> states = IndicesOptionsProtoUtils.parseProtoParameter(wildcardList, defaultStates);
        // Call the method under test  
        // Verify the result  
 * compatible open source license.
    public void testUpdateSetForValueWithNone() {
import static org.opensearch.action.support.IndicesOptions.WildcardStates;
    }
    }  
    public void testParseProtoParameterWithValuesFollowedByNone() {  
        assertNotNull("States should not be null", states);  
        assertTrue("Should contain OPEN", states.contains(WildcardStates.OPEN));  
        assertTrue("Should expand open", indicesOptions.expandWildcardsOpen());  
        IndicesOptions defaultSettings = IndicesOptions.strictExpandOpenAndForbidClosed();  
        assertEquals("Should have 1 state", 1, states.size());
        EnumSet<WildcardStates> states = EnumSet.noneOf(WildcardStates.class);
        List<ExpandWildcard> wildcardList = Collections.singletonList(ExpandWildcard.EXPAND_WILDCARD_ALL);
        assertTrue("Should be empty", states.isEmpty());
    }  
        // Call the method under test
        EnumSet<WildcardStates> states = IndicesOptionsProtoUtils.parseProtoParameter(wildcardList, defaultStates);
        );  
        assertNotNull("States should not be null", states);  
        // Create a list with a single ExpandWildcard
        assertNotNull("States should not be null", states);
        // Create default states with no values  
        // Call the method under test
    }
            ExpandWildcard.EXPAND_WILDCARD_NONE,
        assertNotNull("States should not be null", states);
        assertFalse("Should not contain CLOSED", states.contains(WildcardStates.CLOSED));
        SearchRequest searchRequest = SearchRequest.newBuilder()
import org.opensearch.test.OpenSearchTestCase;
        assertEquals("Should return default settings", defaultSettings, indicesOptions);  
    }  
        IndicesOptionsProtoUtils.updateSetForValue(states, ExpandWildcard.EXPAND_WILDCARD_NONE);  
        // Call the method under test  
            ExpandWildcard.EXPAND_WILDCARD_CLOSED,
    public void testParseProtoParameterWithMultipleValues() {
        EnumSet<WildcardStates> states = EnumSet.noneOf(WildcardStates.class);
 */  
        IndicesOptions indicesOptions = IndicesOptionsProtoUtils.fromProtoParameters(searchRequest, defaultSettings);  
    public void testUpdateSetForValueWithInvalidValue() {
        assertTrue("Should contain CLOSED", states.contains(WildcardStates.CLOSED));
        // Verify the result
 * this file be licensed under the Apache-2.0 license or a
        EnumSet<WildcardStates> defaultStates = EnumSet.of(WildcardStates.CLOSED);
        );
        // Create an empty EnumSet
    public void testParseProtoParameterWithNoneFollowedByValues() {
        assertNotNull("States should not be null", states);
        // Create default states with all values  
    }
        assertFalse("Should not contain HIDDEN", states.contains(WildcardStates.HIDDEN));  
        assertNotNull("States should not be null", states);
        // Call the method under test
    public void testFromRequestWithCustomSettings() {  
        EnumSet<WildcardStates> defaultStates = EnumSet.of(WildcardStates.OPEN);
        EnumSet<WildcardStates> defaultStates = EnumSet.of(WildcardStates.HIDDEN);
        // Call the method under test
        // Verify the result
        IndicesOptions defaultSettings = IndicesOptions.strictExpandOpenAndForbidClosed();
        // Create a SearchRequest with custom indices options
        // Create a list with values followed by NONE
        assertTrue("Should be empty", states.isEmpty());
        assertEquals("Should have 2 states", 2, states.size());
        assertNotNull("IndicesOptions should not be null", indicesOptions);  
        // Create default states
        assertEquals("Should have all states", EnumSet.allOf(WildcardStates.class), states);
        // Call the method under test
            .build();  
            ExpandWildcard.EXPAND_WILDCARD_CLOSED
import org.opensearch.protobufs.ExpandWildcard;
            IllegalArgumentException.class,
    }
            ExpandWildcard.EXPAND_WILDCARD_NONE
            .setAllowNoIndices(false)
    }
        SearchRequest searchRequest = SearchRequest.newBuilder().build();
        // Call the method under test  
        );  
    }  
        assertNotNull("States should not be null", states);
    public void testFromRequestWithDefaultSettings() {  
        // Verify the result
            ExpandWildcard.EXPAND_WILDCARD_OPEN,  
        // Create default states
        // Create default states
        assertTrue("Should ignore throttled", indicesOptions.ignoreThrottled());  
        EnumSet<WildcardStates> states = EnumSet.noneOf(WildcardStates.class);  
            .setIgnoreUnavailable(true)  
        // Create an empty list of ExpandWildcard
}
    public void testParseProtoParameterWithAllValue() {
        // Verify the result
        assertTrue("Should expand open", indicesOptions.expandWildcardsOpen());
        // Create an empty EnumSet
    public void testFromProtoParametersWithPartialSettings() {
    public void testParseProtoParameterWithSingleValue() {  
        assertEquals("Should have 1 state", 1, states.size());
        // Create a SearchRequest with partial indices options  
        assertTrue("Should expand closed", indicesOptions.expandWildcardsClosed());
        assertFalse("Should not allow no indices", indicesOptions.allowNoIndices());
    }
    }  
        IndicesOptionsProtoUtils.updateSetForValue(states, ExpandWildcard.EXPAND_WILDCARD_OPEN);  
        // Verify the result
        IndicesOptions indicesOptions = IndicesOptionsProtoUtils.fromRequest(searchRequest, defaultSettings);
package org.opensearch.transport.grpc.proto.request.search;
    public void testUpdateSetForValueWithOpen() {
        // Create an empty EnumSet
        // Create a list with NONE followed by other values  
        List<ExpandWildcard> wildcardList = Collections.emptyList();
    public void testUpdateSetForValueWithAll() {
        assertTrue("Should contain HIDDEN", states.contains(WildcardStates.HIDDEN));
        // Call the method under test
        EnumSet<WildcardStates> defaultStates = EnumSet.of(WildcardStates.OPEN);
        // Create an empty EnumSet
            .addExpandWildcards(ExpandWildcard.EXPAND_WILDCARD_CLOSED)
        // Call the method under test  
        assertNotNull("States should not be null", states);
            .addExpandWildcards(ExpandWildcard.EXPAND_WILDCARD_OPEN)
        EnumSet<WildcardStates> states = IndicesOptionsProtoUtils.parseProtoParameter(wildcardList, defaultStates);  
        assertTrue("Should ignore throttled", indicesOptions.ignoreThrottled());
        // Verify the result
        IndicesOptions defaultSettings = IndicesOptions.strictExpandOpenAndForbidClosed();
