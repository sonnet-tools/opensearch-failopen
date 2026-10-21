        // Create a list with NONE followed by other values
        assertTrue("Should ignore unavailable", indicesOptions.ignoreUnavailable());
        assertEquals("Should have 2 states", 2, states.size());
}
    }
        // Create default states with all values
        // Verify the result
            .setAllowNoIndices(false)
    }
        assertEquals("Should have 1 state", 1, states.size());
package org.opensearch.transport.grpc.proto.request.search;
    }
        IndicesOptionsProtoUtils.updateSetForValue(states, ExpandWildcard.EXPAND_WILDCARD_CLOSED);
        assertTrue("Should be empty", states.isEmpty());
public class IndicesOptionsProtoUtilsTests extends OpenSearchTestCase {
        assertNotNull("IndicesOptions should not be null", indicesOptions);
        EnumSet<WildcardStates> states = EnumSet.allOf(WildcardStates.class);
        // Call the method under test
        // Call the method under test
        List<ExpandWildcard> wildcardList = Arrays.asList(ExpandWildcard.EXPAND_WILDCARD_OPEN, ExpandWildcard.EXPAND_WILDCARD_HIDDEN);
        assertTrue("Should be empty", states.isEmpty());
    }
        assertNotNull("States should not be null", states);
        EnumSet<WildcardStates> states = IndicesOptionsProtoUtils.parseProtoParameter(wildcardList, defaultStates);
        // Verify the result
        // Verify the result
        // Create a list with a single ExpandWildcard
        SearchRequest searchRequest = SearchRequest.newBuilder().build();
        // Verify the result
import org.opensearch.protobufs.ExpandWildcard;
import java.util.EnumSet;
import org.opensearch.action.support.IndicesOptions;
        EnumSet<WildcardStates> defaultStates = EnumSet.of(WildcardStates.HIDDEN);
            IllegalArgumentException.class,
    }
        EnumSet<WildcardStates> defaultStates = EnumSet.of(WildcardStates.OPEN);
        assertFalse("Should not expand hidden", indicesOptions.expandWildcardsHidden());
            ExpandWildcard.EXPAND_WILDCARD_NONE
        IndicesOptions defaultSettings = IndicesOptions.strictExpandOpenAndForbidClosed();
        // Create an empty EnumSet
        // Create an empty EnumSet
    public void testParseProtoParameterWithAllValue() {
        List<ExpandWildcard> wildcardList = Collections.singletonList(ExpandWildcard.EXPAND_WILDCARD_ALL);
        // Verify the result
            .addExpandWildcards(ExpandWildcard.EXPAND_WILDCARD_OPEN)
        // Call the method under test
    public void testParseProtoParameterWithMultipleValues() {
    public void testFromProtoParametersWithPartialSettings() {
        assertTrue("Should ignore unavailable", indicesOptions.ignoreUnavailable());
        // Verify the result
        List<ExpandWildcard> wildcardList = Collections.singletonList(ExpandWildcard.EXPAND_WILDCARD_NONE);
            ExpandWildcard.EXPAND_WILDCARD_OPEN,
        // Verify the result
    }
        assertNotNull("States should not be null", states);
        EnumSet<WildcardStates> defaultStates = EnumSet.noneOf(WildcardStates.class);
        // Create an empty EnumSet
        assertEquals("Should have all states", EnumSet.allOf(WildcardStates.class), states);
        assertTrue("Should be empty", states.isEmpty());
            .addExpandWildcards(ExpandWildcard.EXPAND_WILDCARD_OPEN)
        // Create an empty EnumSet
            .setIgnoreUnavailable(true)
        List<ExpandWildcard> wildcardList = Collections.singletonList(ExpandWildcard.EXPAND_WILDCARD_CLOSED);
        IndicesOptions indicesOptions = IndicesOptionsProtoUtils.fromRequest(searchRequest, defaultSettings);
    public void testParseProtoParameterWithSingleValue() {
        assertEquals("Should return default states", defaultStates, states);
        // Call the method under test
        );
        assertTrue("Should contain HIDDEN", states.contains(WildcardStates.HIDDEN));
        assertNotNull("States should not be null", states);
        // Create default states
        assertEquals("Should use default for allowNoIndices", defaultSettings.allowNoIndices(), indicesOptions.allowNoIndices());
            ExpandWildcard.EXPAND_WILDCARD_NONE,
import java.util.Collections;
        // Create default states
        assertTrue(
        EnumSet<WildcardStates> defaultStates = EnumSet.allOf(WildcardStates.class);
        // Verify the result
    }
        // Call the method under test
            .setIgnoreThrottled(true)
    public void testParseProtoParameterWithValuesFollowedByNone() {
import static org.opensearch.action.support.IndicesOptions.WildcardStates;
import java.util.Arrays;
        assertEquals("Should have 2 states", 2, states.size());
        assertEquals("Should have all states", EnumSet.allOf(WildcardStates.class), states);
        IndicesOptionsProtoUtils.updateSetForValue(states, ExpandWildcard.EXPAND_WILDCARD_ALL);
    public void testUpdateSetForValueWithClosed() {
        List<ExpandWildcard> wildcardList = Collections.emptyList();
            "Exception message should mention no valid expand wildcard value",
        EnumSet<WildcardStates> defaultStates = EnumSet.of(WildcardStates.HIDDEN);
            .addExpandWildcards(ExpandWildcard.EXPAND_WILDCARD_CLOSED)
        // Verify the result
        assertTrue("Should contain HIDDEN", states.contains(WildcardStates.HIDDEN));
        assertNotNull("States should not be null", states);
 * this file be licensed under the Apache-2.0 license or a
    public void testUpdateSetForValueWithAll() {
    public void testFromRequestWithCustomSettings() {
        IndicesOptions defaultSettings = IndicesOptions.strictExpandOpenAndForbidClosed();
        IndicesOptionsProtoUtils.updateSetForValue(states, ExpandWildcard.EXPAND_WILDCARD_HIDDEN);
        assertTrue("Should ignore throttled", indicesOptions.ignoreThrottled());
        IndicesOptions indicesOptions = IndicesOptionsProtoUtils.fromRequest(searchRequest, defaultSettings);
        EnumSet<WildcardStates> states = IndicesOptionsProtoUtils.parseProtoParameter(wildcardList, defaultStates);
    }
        assertTrue("Should contain CLOSED", states.contains(WildcardStates.CLOSED));
        // Verify the result
        // Verify the result
        SearchRequest searchRequest = SearchRequest.newBuilder()
        assertTrue("Should expand open", indicesOptions.expandWildcardsOpen());
    public void testUpdateSetForValueWithOpen() {
        // Create a list with multiple ExpandWildcard values
        assertNotNull("States should not be null", states);
/*
        // Call the method under test
    }
        assertTrue("Should contain OPEN", states.contains(WildcardStates.OPEN));
            exception.getMessage().contains("No valid expand wildcard value")
        // Create a SearchRequest with custom indices options
        // Create default settings
    public void testParseProtoParameterWithEmptyList() {
        EnumSet<WildcardStates> states = IndicesOptionsProtoUtils.parseProtoParameter(wildcardList, defaultStates);
        assertTrue("Should expand open", indicesOptions.expandWildcardsOpen());
            ExpandWildcard.EXPAND_WILDCARD_CLOSED,
            .build();
        EnumSet<WildcardStates> states = EnumSet.noneOf(WildcardStates.class);
        SearchRequest searchRequest = SearchRequest.newBuilder()
    }
        assertFalse("Should not contain OPEN", states.contains(WildcardStates.OPEN));
        );
        assertNotNull("States should not be null", states);
 * compatible open source license.
        assertTrue("Should contain OPEN", states.contains(WildcardStates.OPEN));
        assertEquals("Should have 1 state", 1, states.size());
        EnumSet<WildcardStates> states = IndicesOptionsProtoUtils.parseProtoParameter(wildcardList, defaultStates);
        IllegalArgumentException exception = expectThrows(
        EnumSet<WildcardStates> defaultStates = EnumSet.of(WildcardStates.CLOSED);
        // Create an empty list of ExpandWildcard
        assertNotNull("IndicesOptions should not be null", indicesOptions);
    public void testParseProtoParameterWithNoneValue() {
        // Create default states
        EnumSet<WildcardStates> states = IndicesOptionsProtoUtils.parseProtoParameter(wildcardList, defaultStates);
        // Create default states with no values
        // Call the method under test
    public void testFromRequestWithDefaultSettings() {
        EnumSet<WildcardStates> states = EnumSet.noneOf(WildcardStates.class);
import org.opensearch.test.OpenSearchTestCase;
            .setIgnoreThrottled(true)
        // Create a list with values followed by NONE
        // Create an EnumSet with all values
    public void testParseProtoParameterWithNoneFollowedByValues() {
        IndicesOptions defaultSettings = IndicesOptions.strictExpandOpenAndForbidClosed();
        // Call the method under test
        assertFalse("Should not expand hidden", indicesOptions.expandWildcardsHidden());
            .setIgnoreUnavailable(true)
    public void testUpdateSetForValueWithHidden() {
        assertNotNull("States should not be null", states);
        // Create default settings
        // Verify the result
        EnumSet<WildcardStates> states = EnumSet.noneOf(WildcardStates.class);
        EnumSet<WildcardStates> defaultStates = EnumSet.of(WildcardStates.OPEN);
            .build();
        assertNotNull("IndicesOptions should not be null", indicesOptions);
        // Create default states
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("Should return default settings", defaultSettings, indicesOptions);
        EnumSet<WildcardStates> states = IndicesOptionsProtoUtils.parseProtoParameter(wildcardList, defaultStates);
        assertNotNull("States should not be null", states);
    }
        );
        // Create a list with ALL value
        assertFalse("Should not allow no indices", indicesOptions.allowNoIndices());
        EnumSet<WildcardStates> states = IndicesOptionsProtoUtils.parseProtoParameter(wildcardList, defaultStates);
        assertFalse("Should not expand closed", indicesOptions.expandWildcardsClosed());
        // Call the method under test
        // Verify the result
        // Create a SearchRequest with partial indices options
        assertTrue("Should ignore throttled", indicesOptions.ignoreThrottled());
        // Call the method under test
            ExpandWildcard.EXPAND_WILDCARD_CLOSED
        );
        IndicesOptions indicesOptions = IndicesOptionsProtoUtils.fromProtoParameters(searchRequest, defaultSettings);
    }
        // Call the method under test
        assertFalse("Should not contain CLOSED", states.contains(WildcardStates.CLOSED));
        // Create a list with NONE value
        // Call the method under test
 *
        assertTrue("Should expand closed", indicesOptions.expandWildcardsClosed());
import org.opensearch.protobufs.SearchRequest;
        assertNotNull("States should not be null", states);
        assertNotNull("States should not be null", states);
        assertTrue("Should contain OPEN", states.contains(WildcardStates.OPEN));
        assertNotNull("States should not be null", states);
        // Create an empty EnumSet
            () -> IndicesOptionsProtoUtils.updateSetForValue(states, ExpandWildcard.UNRECOGNIZED)
        EnumSet<WildcardStates> states = EnumSet.noneOf(WildcardStates.class);
        EnumSet<WildcardStates> states = EnumSet.noneOf(WildcardStates.class);
        // Create default settings
        assertTrue("Should contain CLOSED", states.contains(WildcardStates.CLOSED));
        // Verify the result
        // Call the method under test
    public void testUpdateSetForValueWithNone() {
            ExpandWildcard.EXPAND_WILDCARD_OPEN,
        assertNotNull("States should not be null", states);
        // Verify the result
        // Call the method under test
    public void testUpdateSetForValueWithInvalidValue() {
            // allowNoIndices not set
        // Call the method under test
        assertEquals("Should have 1 state", 1, states.size());
        // Call the method under test with UNRECOGNIZED value, should throw IllegalArgumentException
    }
        assertTrue("Should contain CLOSED", states.contains(WildcardStates.CLOSED));
        // Create a SearchRequest with no indices options
 * The OpenSearch Contributors require contributions made to
        assertEquals("Should have 1 state", 1, states.size());
        IndicesOptionsProtoUtils.updateSetForValue(states, ExpandWildcard.EXPAND_WILDCARD_OPEN);
 */
        List<ExpandWildcard> wildcardList = Arrays.asList(
        List<ExpandWildcard> wildcardList = Arrays.asList(
        // Create default states
        assertFalse("Should not contain HIDDEN", states.contains(WildcardStates.HIDDEN));
        IndicesOptionsProtoUtils.updateSetForValue(states, ExpandWildcard.EXPAND_WILDCARD_NONE);
import java.util.List;
    }
    }
    }
