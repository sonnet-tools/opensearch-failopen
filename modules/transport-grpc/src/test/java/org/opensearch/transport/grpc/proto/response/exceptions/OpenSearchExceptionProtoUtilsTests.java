import org.opensearch.core.common.breaker.CircuitBreakingException;
        List<String> values = Collections.emptyList();
        // Create a CircuitBreakingException with bytes wanted and bytes limit
import java.io.IOException;
    }
        assertNotNull("ErrorCause should not be null", errorCause);
        assertEquals("First value should match", "value1", headerArray.getStringArray(0));
        );
    }
        // Verify the conversion
        // Using a mock since we can't directly set line and column numbers
        assertEquals("Should have the correct type", "exception", errorCause.getType());
    public void testHeaderToValueProtoWithMultipleValues() throws IOException {
        // Convert to Protocol Buffer
    }
    public void testGenerateThrowableProtoWithRuntimeException() throws IOException {
        assertNotNull("Entry should not be null", entry);
        assertTrue("Should have max_buckets field", metadata.containsKey("max_buckets"));
        // Convert to Protocol Buffer
        assertEquals("Should have the correct reason", "Test exception", errorCause.getReason());
        String key = "test-header";
        // Create a TooManyBucketsException
    public void testHeaderToProtoWithEmptyValues() throws IOException {
        assertNotNull("ErrorCause should not be null", errorCause);
        // Verify the conversion
        assertTrue("Should have response_limit field", metadata.containsKey("response_limit"));
        assertTrue("Should have a stack trace", errorCause.getStackTrace().length() > 0);
        assertNull("Entry should be null for null values", entry);
        Map.Entry<String, ObjectMap.Value> entry = OpenSearchExceptionProtoUtils.headerToValueProto(key, values);
        // Convert to Protocol Buffer
        // Verify the conversion
        // Convert to Protocol Buffer
    }
        List<String> values = Collections.singletonList("test-value");
import org.opensearch.action.FailedNodeException;
            "Test script exception",
        assertTrue("Should have limit_entity field", metadata.containsKey("limit_entity"));
                return metadata;
        Map.Entry<String, ObjectMap.Value> entry = OpenSearchExceptionProtoUtils.headerToValueProto(key, values);
        assertFalse("Should not have suppressed exceptions", errorCause.getSuppressedList().iterator().hasNext());
        assertEquals("Key should match", key, entry.getKey());
        // Create an OpenSearchException
        // Verify the conversion
        assertEquals("col should match", 20, metadata.get("col").getInt32());
        // The actual type format uses underscores instead of dots
        // Create a SearchPhaseExecutionException
        // Convert to Protocol Buffer
        StringArray headerArray = OpenSearchExceptionProtoUtils.headerToProto(key, values);
import org.opensearch.action.search.SearchPhaseExecutionException;
        assertTrue("Should have metadata", errorCause.hasMetadata());
        // We need to create a scenario where ExceptionsHelper.unwrapCause returns something different
        IOException ioException = new IOException("IO error");
        assertEquals("Second value should match", "value2", entry.getValue().getListValue().getValue(1).getString());
        // Convert to Protocol Buffer
        assertEquals("Should have the correct reason", "Test exception", errorCause.getReason());
        // Using a mock since we can't directly set line and column numbers
        // Create a SearchParseException with line and column numbers
        // Convert to Protocol Buffer
        assertEquals("Value should match", "test-value", entry.getValue().getString());
        // Verify the conversion
        // Convert to Protocol Buffer
import org.opensearch.action.search.ShardSearchFailure;
        // Verify the conversion
import org.opensearch.test.OpenSearchTestCase;
        // Verify the conversion
            "test_phase",
        // The actual type format uses underscores instead of dots
    public void testMetadataToProtoWithParsingException() {
        OpenSearchException exception = new OpenSearchException("Test exception");
        assertTrue("Should have line field", metadata.containsKey("line"));
        assertEquals("Should have the correct type", "runtime_exception", errorCause.getType());
    public void testHeaderToValueProtoWithSingleValue() throws IOException {
        exception.addHeader("test-header", Arrays.asList("value1", "value2"));
import java.util.HashMap;
import static org.mockito.Mockito.mock;
        SearchPhaseExecutionException exception = new SearchPhaseExecutionException(
        ErrorCause errorCause = OpenSearchExceptionProtoUtils.toProto(exception);
        assertEquals("Header should have 2 values", 2, headerArray.getStringArrayCount());
        assertEquals("Should have the correct type", "exception", errorCause.getType());
        Map<String, ObjectMap.Value> metadata = OpenSearchExceptionProtoUtils.metadataToProto(exception);
        assertFalse("Should not be a string value", entry.getValue().hasString());
        // Convert to Protocol Buffer
        when(exception.getColumnNumber()).thenReturn(20);
        // Verify the conversion
        assertTrue("Should have a stack trace", errorCause.getStackTrace().length() > 0);
        // Create an exception with metadata that has OPENSEARCH_PREFIX_KEY
        assertNotNull("Metadata should not be null", metadata);
        ErrorCause causedBy = errorCause.getCausedBy();
        // Verify the conversion
        assertTrue("Metadata should have fields", errorCause.getMetadata().getFieldsCount() > 0);
    }
        // Verify the conversion
        ErrorCause errorCause = OpenSearchExceptionProtoUtils.toProto(exception);
    }
import org.opensearch.core.common.ParsingException;
        assertFalse("Should not have a cause", errorCause.hasCausedBy());
        ErrorCause errorCause = OpenSearchExceptionProtoUtils.generateThrowableProto(exception);
        assertNotNull("Metadata should not be null", metadata);
        when(exception.getLineNumber()).thenReturn(10);
import org.opensearch.transport.grpc.proto.response.exceptions.opensearchexception.OpenSearchExceptionProtoUtils;
        // Verify the conversion - headers should be included
            "Test search phase execution",
            ShardSearchFailure.EMPTY_ARRAY
    public void testHeaderToProtoWithSingleValue() throws IOException {
        // Convert to Protocol Buffer
        assertEquals("Should have the correct reason", "Test exception", errorCause.getReason());
        ScriptException exception = new ScriptException(
        // Verify the conversion - metadata with prefix should be processed
        ErrorCause errorCause = OpenSearchExceptionProtoUtils.generateThrowableProto(exception);
 * this file be licensed under the Apache-2.0 license or a
    }
        CircuitBreakingException exception = new CircuitBreakingException("Test circuit breaking", 1000L, 500L, null);
        assertTrue("Metadata should be empty for generic exception", metadata.isEmpty());
        assertEquals("bytes_limit should match", 500L, metadata.get("bytes_limit").getInt64());
        assertTrue("grouped should be true", metadata.get("grouped").getBool());
        assertEquals("Key should match", key, entry.getKey());
        // The actual type format uses underscores instead of dots
        assertNotNull("Header array should not be null", headerArray);
    }
        assertNotNull("Metadata should not be null", metadata);
        // The actual type format uses underscores instead of dots
    public void testMetadataToProtoWithFailedNodeException() {
            1000,
        assertTrue("Should have script field", metadata.containsKey("script"));
        // Create an OpenSearchException
        assertEquals("line should match", 10, metadata.get("line").getInt32());
        assertEquals("response_limit should match", 1000L, metadata.get("response_limit").getInt32());
        // Create a RuntimeException
        assertEquals("Should have the correct reason", "Test exception", errorCause.getReason());
        // Verify the conversion
        IOException cause = new IOException("Cause exception");
        // Convert to Protocol Buffer
        // Verify suppressed exceptions
        // Create a header with multiple values
import org.opensearch.protobufs.ObjectMap;
        // Verify the conversion
    }
        // Verify the conversion
import org.opensearch.OpenSearchException;
        // Convert to Protocol Buffer
        // Convert to Protocol Buffer
import org.opensearch.protobufs.ErrorCause;
    public void testInnerToProtoWithEmptyHeaders() throws IOException {
        OpenSearchException exception = new OpenSearchException("Test exception");
        String key = "test-header";
        );
        // Create a basic exception
        OpenSearchException exception = new OpenSearchException("Test exception");
        // The actual type format uses underscores instead of dots
        ErrorCause errorCause = OpenSearchExceptionProtoUtils.toProto(exception);
 * compatible open source license.
        // Convert to Protocol Buffer
        // Create an exception with suppressed exceptions
        RuntimeException exception = new RuntimeException("Test exception");
        StringArray headerArray = OpenSearchExceptionProtoUtils.headerToProto(key, values);
        // Create an exception with empty headers
        // Create a nested OpenSearchException
        // Create a header with empty values
    public void testMetadataToProtoWithSearchParseException() {
        exception.addHeader("null-header", (List<String>) null);
        String key = "test-header";
        Map<String, ObjectMap.Value> metadata = OpenSearchExceptionProtoUtils.metadataToProto(exception);
        assertEquals("limit_entity should match", "INDICES", metadata.get("limit_entity").getString());
import java.util.Arrays;
        Map<String, ObjectMap.Value> metadata = OpenSearchExceptionProtoUtils.metadataToProto(exception);
        StringArray headerArray = OpenSearchExceptionProtoUtils.headerToProto(key, values);
        assertEquals("Value should match", "test-value", headerArray.getStringArray(0));
    public void testGenerateThrowableProtoWithIOException() throws IOException {
        // Verify the conversion
                Map<String, List<String>> metadata = new HashMap<>();
        ErrorCause errorCause = OpenSearchExceptionProtoUtils.generateThrowableProto(exception);
        // Verify the conversion
        when(exception.getLineNumber()).thenReturn(10);
        Map<String, ObjectMap.Value> metadata = OpenSearchExceptionProtoUtils.metadataToProto(exception);
        assertEquals("node_id should match", TEST_NODE_ID, metadata.get("node_id").getString());
        assertTrue("Should have line field", metadata.containsKey("line"));
        ErrorCause suppressed = errorCause.getSuppressed(0);
        Map<String, ObjectMap.Value> metadata = OpenSearchExceptionProtoUtils.metadataToProto(exception);
        OpenSearchException exception = new OpenSearchException("Test generic exception");
        assertEquals("Should have the correct reason", "Main exception", errorCause.getReason());
                metadata.put(OpenSearchException.OPENSEARCH_PREFIX_KEY + "custom_key", Arrays.asList("value1"));
    public void testInnerToProtoWithBasicException() throws IOException {
        // Create a header with a single value
        assertEquals("Third value should match", "value3", entry.getValue().getListValue().getValue(2).getString());
        );
        assertTrue("Should be a string value", entry.getValue().hasString());
        assertEquals("Should have the correct type", "exception", errorCause.getType());
        // Convert to Protocol Buffer
        assertEquals("Should have 1 header", 1, errorCause.getHeaderCount());
        exception.addSuppressed(new IllegalArgumentException("Suppressed exception"));
import org.opensearch.protobufs.StringArray;
        assertTrue("Should have script_stack field", metadata.containsKey("script_stack"));
        assertTrue("Should have test-header", errorCause.containsHeader("test-header"));
        // Create a FailedNodeException
    }
        // Null headers should not be added to the proto
    }
        // Verify the conversion
        assertEquals("Third value should match", "value3", headerArray.getStringArray(2));
    }
    }
        assertEquals("Suppressed should have the correct reason", "Suppressed exception", suppressed.getReason());
        assertEquals("Should have the correct reason", "Test IO exception", errorCause.getReason());
        OpenSearchException innerException = new OpenSearchException("Inner exception", ioException);
        // Convert to Protocol Buffer
 */
        // Verify the conversion
        assertEquals("Should have the correct reason", "Test exception", errorCause.getReason());
    public void testMetadataToProtoWithScriptException() {
        String key = "test-header";
        ErrorCause errorCause = OpenSearchExceptionProtoUtils.toProto(exception);
        assertTrue("Should have grouped field", metadata.containsKey("grouped"));
        // Create an IOException
        assertEquals("Should have the correct type", "runtime_exception", errorCause.getType());
        assertTrue("Should have col field", metadata.containsKey("col"));
        // Verify the conversion - metadata should be included
        assertTrue("Should have a stack trace", errorCause.getStackTrace().length() > 0);
            ResponseLimitSettings.LimitEntity.INDICES
        assertEquals("Array should have correct size", 3, headerArray.getStringArrayCount());
    public void testInnerToProtoWithNullHeaders() throws IOException {
    public void testHeaderToProtoWithNullValues() throws IOException {
        ErrorCause errorCause = OpenSearchExceptionProtoUtils.toProto(exception);
        when(exception.getMessage()).thenReturn("Test search parse exception");
        assertNotNull("ErrorCause should not be null", errorCause);
        // Create an exception with null header values
            "Test response limit",
        assertEquals("Should have the correct reason", "Test exception", errorCause.getReason());
        assertTrue("Should have bytes_wanted field", metadata.containsKey("bytes_wanted"));
        assertEquals("Should have the correct type", "runtime_exception", errorCause.getType());
            Arrays.asList("line1", "line2"),
        // Note: Durability is not in the constructor in newer versions
    }
        // Convert to Protocol Buffer
        // Convert to Protocol Buffer
        OpenSearchException exception = new OpenSearchException("Test exception");
        // Empty headers should not be added to the proto
        Map<String, ObjectMap.Value> metadata = OpenSearchExceptionProtoUtils.metadataToProto(exception);
        // Verify the conversion - null headers should not be added
        // Create a ParsingException with line and column numbers
        ResponseLimitBreachedException exception = new ResponseLimitBreachedException(
    public void testGenerateThrowableProtoWithOpenSearchException() throws IOException {
    public void testInnerToProtoWithMetadata() throws IOException {
    public void testHeaderToProtoWithMultipleValues() throws IOException {
        // Convert to Protocol Buffer
    public void testInnerToProtoWithHeaders() throws IOException {
        ParsingException exception = mock(ParsingException.class);
 * SPDX-License-Identifier: Apache-2.0
        // Create an exception with headers
        assertEquals("script should match", "test_script", metadata.get("script").getString());
        // Convert to Protocol Buffer
        // Verify the conversion
    }
    }
        // Convert to Protocol Buffer
        Map<String, ObjectMap.Value> metadata = OpenSearchExceptionProtoUtils.metadataToProto(exception);
        assertNotNull("Entry should not be null", entry);
        assertNotNull("Metadata should not be null", metadata);
        assertTrue("Should have node_id field", metadata.containsKey("node_id"));
        exception.addHeader("empty-header", Collections.emptyList());
        StringArray headerArray = OpenSearchExceptionProtoUtils.headerToProto(key, values);
    }
        assertNotNull("Metadata should not be null", metadata);
        // Create a header with multiple values
        assertNull("Header array should be null for empty values", headerArray);
        // Convert to Protocol Buffer
    }
        // Verify the conversion - empty headers should not be added
        String key = "test-header";
public class OpenSearchExceptionProtoUtilsTests extends OpenSearchTestCase {
        assertEquals("List should have correct size", 3, entry.getValue().getListValue().getValueCount());
        // This tests the metadata loop that processes entries with the prefix
        assertEquals("Cause should have the correct reason", "Cause exception", causedBy.getReason());
        FailedNodeException exception = new FailedNodeException(TEST_NODE_ID, "Test failed node", new IOException("IO error"));
        assertFalse("Should not have a list value", entry.getValue().hasListValue());
        // Verify the conversion
        assertEquals("Should have no headers", 0, errorCause.getHeaderCount());
import java.util.List;
    public void testGenerateThrowableProtoWithSuppressedExceptions() throws IOException {
        ErrorCause errorCause = OpenSearchExceptionProtoUtils.toProto(exception);
        assertEquals("Should have the correct type", "exception", errorCause.getType());
        Map<String, ObjectMap.Value> metadata = OpenSearchExceptionProtoUtils.metadataToProto(exception);
        // Create a ScriptException
/*
    }
    public void testHeaderToValueProtoWithNullValues() throws IOException {
        // Verify the conversion
    public void testToProtoWithWrappedException() throws IOException {
        SearchParseException exception = mock(SearchParseException.class);
        assertEquals("Should have the correct reason", "Test exception", errorCause.getReason());
        // Create a header with empty values
            public Map<String, List<String>> getMetadata() {
        // Convert to Protocol Buffer
 *
    }
        // Create a header with null values
        );
        Map.Entry<String, ObjectMap.Value> entry = OpenSearchExceptionProtoUtils.headerToValueProto(key, values);
    }
    public void testToProtoWithOpenSearchException() throws IOException {
    private static final String TEST_NODE_ID = "test_node_id";
        ErrorCause errorCause = OpenSearchExceptionProtoUtils.generateThrowableProto(exception);
        when(exception.getColumnNumber()).thenReturn(20);
        ErrorCause errorCause = OpenSearchExceptionProtoUtils.generateThrowableProto(exception);
import static org.mockito.Mockito.when;
        OpenSearchException exception = new OpenSearchException("Test exception") {
        // Convert to Protocol Buffer
        // Create a header with null values
        IOException exception = new IOException("Test IO exception");
        List<String> values = null;
        List<String> values = Collections.emptyList();
            "painless"
        assertEquals("First value should match", "value1", entry.getValue().getListValue().getValue(0).getString());
        assertEquals("phase should match", "test_phase", metadata.get("phase").getString());
        assertEquals("Should have the correct reason", "Test runtime exception", errorCause.getReason());
        FailedNodeException exception = new FailedNodeException(TEST_NODE_ID, "Test failed node", new IOException("IO error"));
import java.util.Collections;
        assertEquals("max_buckets should match", 1000, metadata.get("max_buckets").getInt32());
        assertNotNull("Metadata should not be null", metadata);
        assertEquals("lang should match", "painless", metadata.get("lang").getString());
        assertEquals("Should have the correct type", "exception", errorCause.getType());
        ErrorCause errorCause = OpenSearchExceptionProtoUtils.toProto(exception);
        // Verify the conversion
        // Convert to Protocol Buffer
        ErrorCause errorCause = OpenSearchExceptionProtoUtils.generateThrowableProto(exception);
    public void testMetadataToProtoWithSearchPhaseExecutionException() {
        String key = "test-header";
        assertEquals("Should have the correct type", "exception", errorCause.getType());
    public void testInnerToProtoWithOpenSearchPrefixMetadata() throws IOException {
        assertNotNull("Metadata should not be null", metadata);
        // The actual type format uses underscores instead of dots
        List<String> values = Arrays.asList("value1", "value2", "value3");
        // The actual type format uses underscores instead of dots
        // Convert to Protocol Buffer
    }
        Map.Entry<String, ObjectMap.Value> entry = OpenSearchExceptionProtoUtils.headerToValueProto(key, values);
            }
        assertEquals("Should have the correct type", "i_o_exception", errorCause.getType());
        // The toProto method unwraps causes, so when ex != exception, it calls generateThrowableProto
        assertNotNull("Header array should not be null", headerArray);
        // Verify the conversion
            1000
        List<String> values = Arrays.asList("value1", "value2", "value3");
        // The actual type format uses underscores instead of dots
            new Exception("Script error"),
        Map<String, ObjectMap.Value> metadata = OpenSearchExceptionProtoUtils.metadataToProto(exception);
        assertEquals("col should match", 20, metadata.get("col").getInt32());
        // Verify the conversion
import org.opensearch.search.aggregations.MultiBucketConsumerService;
package org.opensearch.transport.grpc.proto.response.common;
        OpenSearchException exception = new OpenSearchException("Test exception", cause);
        assertNotNull("Metadata should not be null", metadata);
        assertTrue("Should have lang field", metadata.containsKey("lang"));
        assertTrue("Should have bytes_limit field", metadata.containsKey("bytes_limit"));
        // Create an exception with a wrapped cause that will be unwrapped
        assertNotNull("Header array should not be null", headerArray);
        ErrorCause errorCause = OpenSearchExceptionProtoUtils.generateThrowableProto(innerException);
        MultiBucketConsumerService.TooManyBucketsException exception = new MultiBucketConsumerService.TooManyBucketsException(
        assertTrue("Should have phase field", metadata.containsKey("phase"));
        // Verify the conversion
        // Convert to Protocol Buffer
        assertEquals("line should match", 10, metadata.get("line").getInt32());
        // Convert to Protocol Buffer
 * The OpenSearch Contributors require contributions made to
        // This is tricky to test directly, but we can test the generateThrowableProto path
        assertFalse("Should not have a reason", errorCause.hasReason());
        assertEquals("Cause should have the correct type", "i_o_exception", causedBy.getType());
import org.opensearch.script.ScriptException;
        // Create a FailedNodeException which has metadata (node_id)
        assertEquals("bytes_wanted should match", 1000L, metadata.get("bytes_wanted").getInt64());
        assertEquals("Array should have correct size", 1, headerArray.getStringArrayCount());
        // Verify the conversion
import java.util.Map;
        assertEquals("Should have one suppressed exception", 1, errorCause.getSuppressedCount());
    }
    public void testMetadataToProtoWithGenericOpenSearchException() {
            "test_script",
    }
        assertEquals("Should have the correct type", "runtime_exception", errorCause.getType());
        StringArray headerArray = errorCause.getHeaderOrDefault("test-header", null);
        assertNull("Entry should be null for empty values", entry);
        assertTrue("Metadata should have fields", errorCause.getMetadata().getFieldsCount() > 0);
        assertTrue("Should have col field", metadata.containsKey("col"));
        List<String> values = null;
        assertTrue("Should have metadata", errorCause.hasMetadata());
            "Test too many buckets",
    }
        String key = "test-header";
        assertNull("Header array should be null for null values", headerArray);
        assertEquals("Should have the correct type", "exception", errorCause.getType());
        // The actual type format uses underscores instead of dots
        assertEquals("Should have no headers", 0, errorCause.getHeaderCount());
        RuntimeException exception = new RuntimeException("Test runtime exception");
        // Convert to Protocol Buffer
        // Verify the conversion
        List<String> values = Collections.singletonList("test-value");
        };
        RuntimeException exception = new RuntimeException((String) null);
    public void testGenerateThrowableProtoWithNullMessage() throws IOException {
import org.opensearch.common.breaker.ResponseLimitBreachedException;
        assertTrue("Should have a cause", errorCause.hasCausedBy());
        assertTrue("Should have a list value", entry.getValue().hasListValue());
    public void testMetadataToProtoWithResponseLimitBreachedException() {
    public void testMetadataToProtoWithCircuitBreakingException() {
        // Create a header with a single value
        // Create an exception with null message
    }
        assertNotNull("ErrorCause should not be null", errorCause);
        assertNotNull("Metadata should not be null", metadata);
        // Convert to Protocol Buffer
        // Create a ResponseLimitBreachedException
    }
        assertEquals("Suppressed should have the correct type", "illegal_argument_exception", suppressed.getType());
    public void testHeaderToValueProtoWithEmptyValues() throws IOException {
import org.opensearch.common.breaker.ResponseLimitSettings;
        // Verify the cause
        RuntimeException exception = new RuntimeException("Main exception");
        assertNotNull("ErrorCause should not be null", errorCause);
        assertEquals("Second value should match", "value2", headerArray.getStringArray(1));
    }
        assertNotNull("ErrorCause should not be null", errorCause);
        OpenSearchException exception = new OpenSearchException("Test exception");
    public void testToProtoWithNestedOpenSearchException() throws IOException {
}
    }
        String key = "test-header";
            @Override
    public void testMetadataToProtoWithTooManyBucketsException() {
import org.opensearch.search.SearchParseException;
        // The actual type format uses underscores instead of dots
        when(exception.getMessage()).thenReturn("Test parsing exception");
        // Create a generic OpenSearchException
    }
    }
