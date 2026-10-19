        OpenSearchException exception = new OpenSearchException("Test exception", cause);
        OpenSearchException exception = new OpenSearchException("Test exception");  
    public void testGenerateThrowableProtoWithIOException() throws IOException {
    }
        assertNull("Entry should be null for null values", entry);
        OpenSearchException innerException = new OpenSearchException("Inner exception", ioException);
        // Verify the cause
        // Convert to Protocol Buffer
        assertEquals("Should have the correct reason", "Test exception", errorCause.getReason());  
        // Convert to Protocol Buffer  
    }  
        when(exception.getLineNumber()).thenReturn(10);  
        // Convert to Protocol Buffer  
        // This tests the metadata loop that processes entries with the prefix
    public void testHeaderToProtoWithMultipleValues() throws IOException {
import org.opensearch.common.breaker.ResponseLimitSettings;  
        assertTrue("Should have col field", metadata.containsKey("col"));
        OpenSearchException exception = new OpenSearchException("Test generic exception");  
    }
        StringArray headerArray = OpenSearchExceptionProtoUtils.headerToProto(key, values);  
        assertNotNull("Header array should not be null", headerArray);
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("Second value should match", "value2", headerArray.getStringArray(1));
        assertEquals("Should have the correct type", "i_o_exception", errorCause.getType());
        OpenSearchException exception = new OpenSearchException("Test exception") {
        // Convert to Protocol Buffer
    public void testMetadataToProtoWithCircuitBreakingException() {
        // Verify the conversion
                return metadata;
        List<String> values = Collections.emptyList();
        // Verify the conversion  
        ErrorCause errorCause = OpenSearchExceptionProtoUtils.toProto(exception);
        // Convert to Protocol Buffer
        // Create a header with null values
        assertEquals("Should have 1 header", 1, errorCause.getHeaderCount());
    public void testMetadataToProtoWithResponseLimitBreachedException() {
        // Create an exception with null message
    public void testInnerToProtoWithBasicException() throws IOException {
        assertNotNull("Metadata should not be null", metadata);
    public void testHeaderToProtoWithEmptyValues() throws IOException {  
        // Convert to Protocol Buffer
        assertTrue("Should have bytes_wanted field", metadata.containsKey("bytes_wanted"));
        assertTrue("Should have node_id field", metadata.containsKey("node_id"));  
        Map<String, ObjectMap.Value> metadata = OpenSearchExceptionProtoUtils.metadataToProto(exception);
        assertEquals("line should match", 10, metadata.get("line").getInt32());  
        assertEquals("Array should have correct size", 3, headerArray.getStringArrayCount());  
        assertTrue("Should have response_limit field", metadata.containsKey("response_limit"));  
        assertTrue("Should have lang field", metadata.containsKey("lang"));  
        );
        MultiBucketConsumerService.TooManyBucketsException exception = new MultiBucketConsumerService.TooManyBucketsException(
        // Create a CircuitBreakingException with bytes wanted and bytes limit  
        assertEquals("Third value should match", "value3", entry.getValue().getListValue().getValue(2).getString());
import org.opensearch.action.search.SearchPhaseExecutionException;  
    }
        assertEquals("Should have the correct reason", "Test exception", errorCause.getReason());  
        assertEquals("Third value should match", "value3", headerArray.getStringArray(2));  
        exception.addSuppressed(new IllegalArgumentException("Suppressed exception"));
        assertEquals("phase should match", "test_phase", metadata.get("phase").getString());
import static org.mockito.Mockito.when;
        // The actual type format uses underscores instead of dots
        // Verify the conversion
            "Test response limit",
import java.util.HashMap;  
        // The toProto method unwraps causes, so when ex != exception, it calls generateThrowableProto
        // Create an OpenSearchException
        // Create a header with empty values  
    public void testMetadataToProtoWithTooManyBucketsException() {  
        assertTrue("Should have line field", metadata.containsKey("line"));
        RuntimeException exception = new RuntimeException("Main exception");  
                Map<String, List<String>> metadata = new HashMap<>();
        // The actual type format uses underscores instead of dots
    }
    }
        // Create a header with a single value
        Map<String, ObjectMap.Value> metadata = OpenSearchExceptionProtoUtils.metadataToProto(exception);
    }  
        assertTrue("Should have a stack trace", errorCause.getStackTrace().length() > 0);  
        assertEquals("Should have the correct type", "exception", errorCause.getType());
    public void testHeaderToValueProtoWithMultipleValues() throws IOException {
        assertEquals("First value should match", "value1", entry.getValue().getListValue().getValue(0).getString());  
        // Create a SearchPhaseExecutionException  
        ErrorCause errorCause = OpenSearchExceptionProtoUtils.toProto(exception);
import org.opensearch.core.common.breaker.CircuitBreakingException;
        IOException ioException = new IOException("IO error");
        String key = "test-header";  
        // Verify the conversion
        // Verify the conversion - headers should be included  
        FailedNodeException exception = new FailedNodeException(TEST_NODE_ID, "Test failed node", new IOException("IO error"));
        List<String> values = null;
        // Convert to Protocol Buffer
        assertNull("Entry should be null for empty values", entry);
        when(exception.getLineNumber()).thenReturn(10);  
        Map<String, ObjectMap.Value> metadata = OpenSearchExceptionProtoUtils.metadataToProto(exception);
        assertTrue("Metadata should have fields", errorCause.getMetadata().getFieldsCount() > 0);
        Map<String, ObjectMap.Value> metadata = OpenSearchExceptionProtoUtils.metadataToProto(exception);
        assertTrue("Metadata should have fields", errorCause.getMetadata().getFieldsCount() > 0);
            "test_phase",
        ErrorCause errorCause = OpenSearchExceptionProtoUtils.generateThrowableProto(exception);
 *
    }
        assertEquals("Value should match", "test-value", entry.getValue().getString());  
        assertNotNull("ErrorCause should not be null", errorCause);
        FailedNodeException exception = new FailedNodeException(TEST_NODE_ID, "Test failed node", new IOException("IO error"));
        assertEquals("Header should have 2 values", 2, headerArray.getStringArrayCount());
    }
        assertEquals("Should have the correct type", "exception", errorCause.getType());  
        assertEquals("Should have the correct reason", "Test IO exception", errorCause.getReason());
        // Verify the conversion  
        // Using a mock since we can't directly set line and column numbers  
        String key = "test-header";
            @Override  
        assertNotNull("ErrorCause should not be null", errorCause);  
        // The actual type format uses underscores instead of dots  
        // Verify suppressed exceptions
        IOException cause = new IOException("Cause exception");
        // Create a FailedNodeException
        // Verify the conversion  
    }  
    public void testHeaderToProtoWithNullValues() throws IOException {  
        assertEquals("First value should match", "value1", headerArray.getStringArray(0));
        // Create a generic OpenSearchException
    public void testToProtoWithNestedOpenSearchException() throws IOException {
        assertEquals("bytes_wanted should match", 1000L, metadata.get("bytes_wanted").getInt64());  
        String key = "test-header";
    public void testMetadataToProtoWithSearchPhaseExecutionException() {
import java.util.Map;
    public void testInnerToProtoWithEmptyHeaders() throws IOException {
        ErrorCause errorCause = OpenSearchExceptionProtoUtils.generateThrowableProto(exception);
        // Convert to Protocol Buffer
    public void testGenerateThrowableProtoWithOpenSearchException() throws IOException {  
            public Map<String, List<String>> getMetadata() {
        // Create an IOException
    }
    public void testToProtoWithWrappedException() throws IOException {
        ErrorCause errorCause = OpenSearchExceptionProtoUtils.generateThrowableProto(exception);
        // Convert to Protocol Buffer
        IOException exception = new IOException("Test IO exception");  
import org.opensearch.protobufs.StringArray;
        // Create an exception with null header values  
        assertFalse("Should not be a string value", entry.getValue().hasString());  
        assertFalse("Should not have suppressed exceptions", errorCause.getSuppressedList().iterator().hasNext());
        String key = "test-header";
        OpenSearchException exception = new OpenSearchException("Test exception");
        assertEquals("Value should match", "test-value", headerArray.getStringArray(0));
        assertNotNull("Metadata should not be null", metadata);
    public void testMetadataToProtoWithSearchParseException() {
        String key = "test-header";
        // Convert to Protocol Buffer
    public void testHeaderToValueProtoWithNullValues() throws IOException {
        assertEquals("Should have the correct type", "exception", errorCause.getType());
            1000,  
    }
        assertFalse("Should not have a reason", errorCause.hasReason());
        assertEquals("line should match", 10, metadata.get("line").getInt32());  
        assertTrue("Should have metadata", errorCause.hasMetadata());
        ErrorCause errorCause = OpenSearchExceptionProtoUtils.toProto(exception);  
        when(exception.getColumnNumber()).thenReturn(20);
        // Create a FailedNodeException which has metadata (node_id)
        // Convert to Protocol Buffer
        assertEquals("limit_entity should match", "INDICES", metadata.get("limit_entity").getString());  
        // Verify the conversion - metadata should be included
        // This is tricky to test directly, but we can test the generateThrowableProto path  
        assertEquals("Should have the correct reason", "Test exception", errorCause.getReason());
        // Verify the conversion
    }  
 * SPDX-License-Identifier: Apache-2.0
        assertNotNull("Metadata should not be null", metadata);
        RuntimeException exception = new RuntimeException("Test runtime exception");
        // Verify the conversion - null headers should not be added
    public void testInnerToProtoWithHeaders() throws IOException {
        assertTrue("Metadata should be empty for generic exception", metadata.isEmpty());
        // Convert to Protocol Buffer
        // Verify the conversion
        assertFalse("Should not have a list value", entry.getValue().hasListValue());
        // Verify the conversion
        assertEquals("Cause should have the correct reason", "Cause exception", causedBy.getReason());  
        // The actual type format uses underscores instead of dots
    }
        assertEquals("node_id should match", TEST_NODE_ID, metadata.get("node_id").getString());
        OpenSearchException exception = new OpenSearchException("Test exception");  
        // Verify the conversion  
    public void testGenerateThrowableProtoWithSuppressedExceptions() throws IOException {
    }
        // Create a ParsingException with line and column numbers
        // Verify the conversion
        SearchParseException exception = mock(SearchParseException.class);
        ErrorCause errorCause = OpenSearchExceptionProtoUtils.toProto(exception);  
import java.util.Collections;
        Map.Entry<String, ObjectMap.Value> entry = OpenSearchExceptionProtoUtils.headerToValueProto(key, values);  
import org.opensearch.common.breaker.ResponseLimitBreachedException;
        assertTrue("Should have a stack trace", errorCause.getStackTrace().length() > 0);
        List<String> values = Collections.singletonList("test-value");  
    }  
    }  
    }
        assertEquals("Should have the correct reason", "Test exception", errorCause.getReason());
        StringArray headerArray = OpenSearchExceptionProtoUtils.headerToProto(key, values);  
        // Convert to Protocol Buffer  
        // Create a ResponseLimitBreachedException  
public class OpenSearchExceptionProtoUtilsTests extends OpenSearchTestCase {
        Map.Entry<String, ObjectMap.Value> entry = OpenSearchExceptionProtoUtils.headerToValueProto(key, values);
        // Verify the conversion  
        // Create an exception with suppressed exceptions
        // The actual type format uses underscores instead of dots
        assertEquals("Should have the correct reason", "Main exception", errorCause.getReason());  
        assertEquals("Should have the correct type", "exception", errorCause.getType());
        List<String> values = Collections.singletonList("test-value");  
        String key = "test-header";
        assertTrue("Should have a stack trace", errorCause.getStackTrace().length() > 0);  
        // Verify the conversion  
        ErrorCause errorCause = OpenSearchExceptionProtoUtils.toProto(exception);
        assertTrue("Should have a cause", errorCause.hasCausedBy());
        // Verify the conversion
        assertEquals("Second value should match", "value2", entry.getValue().getListValue().getValue(1).getString());
        // Verify the conversion
        assertEquals("script should match", "test_script", metadata.get("script").getString());
        assertTrue("Should have col field", metadata.containsKey("col"));
        // Create a RuntimeException  
        ParsingException exception = mock(ParsingException.class);
        );
import static org.mockito.Mockito.mock;
        Map<String, ObjectMap.Value> metadata = OpenSearchExceptionProtoUtils.metadataToProto(exception);  
import java.util.Arrays;
        ErrorCause errorCause = OpenSearchExceptionProtoUtils.toProto(exception);
        assertTrue("Should have a list value", entry.getValue().hasListValue());
        assertEquals("Should have no headers", 0, errorCause.getHeaderCount());  
    }  
        // Convert to Protocol Buffer
import org.opensearch.protobufs.ObjectMap;
        // Create an exception with empty headers
        assertTrue("Should have test-header", errorCause.containsHeader("test-header"));
    public void testHeaderToProtoWithSingleValue() throws IOException {  
        assertTrue("Should be a string value", entry.getValue().hasString());
        assertTrue("Should have grouped field", metadata.containsKey("grouped"));
        // Create a header with empty values
        assertEquals("max_buckets should match", 1000, metadata.get("max_buckets").getInt32());
        // Create a ScriptException
    public void testMetadataToProtoWithGenericOpenSearchException() {
        assertEquals("col should match", 20, metadata.get("col").getInt32());
        OpenSearchException exception = new OpenSearchException("Test exception");  
}
        assertNotNull("Metadata should not be null", metadata);
/*  
        assertTrue("Should have script_stack field", metadata.containsKey("script_stack"));  
            Arrays.asList("line1", "line2"),
import org.opensearch.script.ScriptException;  
        OpenSearchException exception = new OpenSearchException("Test exception");
        assertNotNull("ErrorCause should not be null", errorCause);
        // Verify the conversion - metadata with prefix should be processed
        Map<String, ObjectMap.Value> metadata = OpenSearchExceptionProtoUtils.metadataToProto(exception);
        exception.addHeader("null-header", (List<String>) null);
    }
        assertFalse("Should not have a cause", errorCause.hasCausedBy());
        assertNotNull("Header array should not be null", headerArray);  
        when(exception.getMessage()).thenReturn("Test search parse exception");
        // Convert to Protocol Buffer  
        assertTrue("Should have limit_entity field", metadata.containsKey("limit_entity"));
        assertEquals("Should have the correct type", "runtime_exception", errorCause.getType());  
        // Convert to Protocol Buffer
        assertNotNull("Metadata should not be null", metadata);
        Map<String, ObjectMap.Value> metadata = OpenSearchExceptionProtoUtils.metadataToProto(exception);
        assertTrue("Should have script field", metadata.containsKey("script"));
        // Create an exception with metadata that has OPENSEARCH_PREFIX_KEY  
    }
        RuntimeException exception = new RuntimeException("Test exception");  
import java.io.IOException;  
        // Create a SearchParseException with line and column numbers
        // Convert to Protocol Buffer
 * The OpenSearch Contributors require contributions made to  
        assertNotNull("Metadata should not be null", metadata);  
        // Verify the conversion
        assertTrue("Should have bytes_limit field", metadata.containsKey("bytes_limit"));
        // The actual type format uses underscores instead of dots
        List<String> values = Arrays.asList("value1", "value2", "value3");
        assertEquals("response_limit should match", 1000L, metadata.get("response_limit").getInt32());
        assertEquals("Should have the correct type", "runtime_exception", errorCause.getType());
        assertTrue("grouped should be true", metadata.get("grouped").getBool());  
        Map<String, ObjectMap.Value> metadata = OpenSearchExceptionProtoUtils.metadataToProto(exception);
        assertEquals("Key should match", key, entry.getKey());
    }
            "Test script exception",  
        assertEquals("Should have the correct reason", "Test exception", errorCause.getReason());
        // Convert to Protocol Buffer  
        assertEquals("col should match", 20, metadata.get("col").getInt32());
        assertEquals("Cause should have the correct type", "i_o_exception", causedBy.getType());
        // Create a header with multiple values  
    private static final String TEST_NODE_ID = "test_node_id";
        assertTrue("Should have phase field", metadata.containsKey("phase"));  
import org.opensearch.test.OpenSearchTestCase;  
        List<String> values = null;  
    public void testMetadataToProtoWithFailedNodeException() {  
        // Empty headers should not be added to the proto
        // Null headers should not be added to the proto
        // The actual type format uses underscores instead of dots
    public void testToProtoWithOpenSearchException() throws IOException {
import org.opensearch.protobufs.ErrorCause;  
    }  
        assertNotNull("Entry should not be null", entry);
        ErrorCause errorCause = OpenSearchExceptionProtoUtils.generateThrowableProto(exception);
        when(exception.getMessage()).thenReturn("Test parsing exception");
        assertEquals("Array should have correct size", 1, headerArray.getStringArrayCount());
        // Create a basic exception
        // Verify the conversion
    public void testMetadataToProtoWithScriptException() {  
        ScriptException exception = new ScriptException(
        when(exception.getColumnNumber()).thenReturn(20);
        );
        assertNotNull("Entry should not be null", entry);  
        assertEquals("Should have the correct type", "exception", errorCause.getType());
    public void testInnerToProtoWithOpenSearchPrefixMetadata() throws IOException {
    public void testHeaderToValueProtoWithSingleValue() throws IOException {  
        assertNotNull("Metadata should not be null", metadata);
    }
        assertEquals("lang should match", "painless", metadata.get("lang").getString());
        ErrorCause suppressed = errorCause.getSuppressed(0);
        // Create an exception with headers
        assertEquals("Should have the correct reason", "Test exception", errorCause.getReason());
            "Test search phase execution",  
        // Verify the conversion
        // Verify the conversion
        ErrorCause errorCause = OpenSearchExceptionProtoUtils.generateThrowableProto(innerException);
        ErrorCause errorCause = OpenSearchExceptionProtoUtils.generateThrowableProto(exception);  
import org.opensearch.search.aggregations.MultiBucketConsumerService;
    }
        // Convert to Protocol Buffer
        List<String> values = Arrays.asList("value1", "value2", "value3");
            "painless"
 */  
        RuntimeException exception = new RuntimeException((String) null);
import org.opensearch.action.search.ShardSearchFailure;
            }
        assertNotNull("ErrorCause should not be null", errorCause);
    public void testHeaderToValueProtoWithEmptyValues() throws IOException {
        Map.Entry<String, ObjectMap.Value> entry = OpenSearchExceptionProtoUtils.headerToValueProto(key, values);
        // Note: Durability is not in the constructor in newer versions  
        );
        // Verify the conversion - empty headers should not be added  
        exception.addHeader("empty-header", Collections.emptyList());
        assertEquals("bytes_limit should match", 500L, metadata.get("bytes_limit").getInt64());
        // Create a TooManyBucketsException
        ErrorCause causedBy = errorCause.getCausedBy();  
    }  
import org.opensearch.transport.grpc.proto.response.exceptions.opensearchexception.OpenSearchExceptionProtoUtils;
        assertNotNull("ErrorCause should not be null", errorCause);
    public void testMetadataToProtoWithParsingException() {
        List<String> values = Collections.emptyList();  
        ErrorCause errorCause = OpenSearchExceptionProtoUtils.toProto(exception);
            "test_script",  
        StringArray headerArray = OpenSearchExceptionProtoUtils.headerToProto(key, values);
        // Convert to Protocol Buffer
        assertNotNull("Header array should not be null", headerArray);
        // The actual type format uses underscores instead of dots
import java.util.List;
        // Convert to Protocol Buffer  
        assertEquals("Suppressed should have the correct type", "illegal_argument_exception", suppressed.getType());  
        // Convert to Protocol Buffer
        assertNull("Header array should be null for empty values", headerArray);  
import org.opensearch.OpenSearchException;
    }  
        // We need to create a scenario where ExceptionsHelper.unwrapCause returns something different
        // Convert to Protocol Buffer
        // Verify the conversion
        // Create a header with null values  
        // Convert to Protocol Buffer  
        assertEquals("Suppressed should have the correct reason", "Suppressed exception", suppressed.getReason());
        // Convert to Protocol Buffer
        // Using a mock since we can't directly set line and column numbers  
        assertEquals("Should have the correct reason", "Test exception", errorCause.getReason());
    }
        assertNotNull("ErrorCause should not be null", errorCause);
import org.opensearch.action.FailedNodeException;
        assertEquals("Should have the correct type", "exception", errorCause.getType());  
        // Convert to Protocol Buffer
            ShardSearchFailure.EMPTY_ARRAY
                metadata.put(OpenSearchException.OPENSEARCH_PREFIX_KEY + "custom_key", Arrays.asList("value1"));  
    public void testGenerateThrowableProtoWithNullMessage() throws IOException {  
        ResponseLimitBreachedException exception = new ResponseLimitBreachedException(
        // Verify the conversion
        // Verify the conversion
        // Verify the conversion  
        // Create a header with multiple values
        assertTrue("Should have metadata", errorCause.hasMetadata());  
        ErrorCause errorCause = OpenSearchExceptionProtoUtils.generateThrowableProto(exception);  
        CircuitBreakingException exception = new CircuitBreakingException("Test circuit breaking", 1000L, 500L, null);
        // Convert to Protocol Buffer
        exception.addHeader("test-header", Arrays.asList("value1", "value2"));
        assertEquals("Should have the correct type", "runtime_exception", errorCause.getType());
            "Test too many buckets",  
    public void testInnerToProtoWithNullHeaders() throws IOException {
        StringArray headerArray = OpenSearchExceptionProtoUtils.headerToProto(key, values);  
        // Convert to Protocol Buffer  
        // Create an exception with a wrapped cause that will be unwrapped  
        assertEquals("List should have correct size", 3, entry.getValue().getListValue().getValueCount());
        // Create an OpenSearchException
    public void testInnerToProtoWithMetadata() throws IOException {  
        assertEquals("Should have the correct type", "runtime_exception", errorCause.getType());
        // Convert to Protocol Buffer
        assertEquals("Key should match", key, entry.getKey());
        assertEquals("Should have one suppressed exception", 1, errorCause.getSuppressedCount());  
    public void testGenerateThrowableProtoWithRuntimeException() throws IOException {
        assertEquals("Should have the correct reason", "Test runtime exception", errorCause.getReason());  
        assertTrue("Should have line field", metadata.containsKey("line"));
        // Create a header with a single value
        StringArray headerArray = errorCause.getHeaderOrDefault("test-header", null);  
            1000
        Map<String, ObjectMap.Value> metadata = OpenSearchExceptionProtoUtils.metadataToProto(exception);
        // Verify the conversion
        String key = "test-header";
        String key = "test-header";
        assertTrue("Should have max_buckets field", metadata.containsKey("max_buckets"));  
        // The actual type format uses underscores instead of dots  
        assertNotNull("Metadata should not be null", metadata);
        // Verify the conversion
            ResponseLimitSettings.LimitEntity.INDICES
import org.opensearch.search.SearchParseException;
import org.opensearch.core.common.ParsingException;
        Map.Entry<String, ObjectMap.Value> entry = OpenSearchExceptionProtoUtils.headerToValueProto(key, values);
            new Exception("Script error"),
        assertEquals("Should have no headers", 0, errorCause.getHeaderCount());
package org.opensearch.transport.grpc.proto.response.common;
        // Create a nested OpenSearchException  
    }
        // Convert to Protocol Buffer
        SearchPhaseExecutionException exception = new SearchPhaseExecutionException(
        assertNotNull("Metadata should not be null", metadata);
 * compatible open source license.
        assertNull("Header array should be null for null values", headerArray);  
        assertEquals("Should have the correct type", "exception", errorCause.getType());  
        // The actual type format uses underscores instead of dots  
        // Verify the conversion
        };  
    }  
    }  
