    }  
     */  
         */
        ShardRange range2 = new ShardRange(2, 0, 200);
         */
    public void testToXContentSerializesShardRangeCorrectly() throws IOException {
        /**  
    }  
        assertEquals("The toString method should return the correct string representation", expected, result);
    /**
        ShardRange shardRange = new ShardRange(shardId, start, end);  
        assertFalse("A ShardRange should not be equal to null", range1.equals(null));  
        ShardRange shardRange = new ShardRange(0, 0, expectedEnd);
        assertEquals(expected, builder.toString());  // Also switched the order of expected and actual  
        BytesStreamOutput out = new BytesStreamOutput();
        String result = shardRange.toString();  
    public void testGetEndReturnsCorrectValue() {
    }
    public void testToStringReturnsCorrectRepresentation() {
    public void testEqualsMethod() {  
     */
    }
 * SPDX-License-Identifier: Apache-2.0
public class ShardRangeTests extends OpenSearchTestCase {  
        ShardRange range1 = new ShardRange(1, 0, 100);  
                throw new IOException("Simulated IO failure");
        OutputStream failingStream = new OutputStream() {
            }
            shardRange.toXContent(builder, null);
         */  
        parser.nextToken(); // Move to start object  
        ShardRange shardRange = ShardRange.parse(parser);  
        assertEquals(originalShardRange.shardId(), deserializedShardRange.shardId());
        ShardRange shardRange = new ShardRange(1, 0, 100);  
        ShardRange shardRange = new ShardRange(0, 10, 20);
         * Test that writeTo throws NullPointerException when StreamOutput is null  
        assertEquals("Empty object should have default start", -1, shardRange.start());  
    public void testContainsWithHashGreaterThanEnd() {
        builder = shardRange.toXContent(builder, null);  
    }
            @Override  
            public void close() throws IOException {  
            builder.close(); // Force flush/close which will trigger the write
        ShardRange shardRange = new ShardRange(1, 0, 100);
     */  
        expectThrows(IOException.class, () -> shardRange.writeTo(failingOutput));
        ShardRange shardRange = ShardRange.parse(parser);
        // Create ShardRange objects for testing
        // Assert
}
     */  
            }
import org.opensearch.core.xcontent.XContentParser;  
            public void reset() throws IOException {
     * Test compareTo method with overlapping ranges
    }
         * Test that the contains method returns true when the hash is equal to the end value.
    public void testWriteToWithIOException() {
    /**
    }
         */
import org.opensearch.test.OpenSearchTestCase;
        // Test equality with itself
    /**
    public void testParseWithExtraFields() throws IOException {
        ShardRange shardRange = new ShardRange(1, 0, 100);
        ShardRange range = new ShardRange(1, 0, 100);  
        parser.nextToken();
        assertTrue(shardRange.contains(-5));
        int shardId = 1;  
        ShardRange range5 = new ShardRange(1, 0, 90);  
            @Override  
        String expected = "ShardRange{shardId=1, start=0, end=100}";  
        assertTrue("Two identical ShardRanges should be equal", range1.equals(range2));  
            public void flush() throws IOException {
 *
        String json = "{" + "\"shard_id\": 1," + "\"start\": 0," + "\"end\": 100" + "}";  
     * Verifies that the toString method returns the expected string representation
        XContentParser parser = createParser(json);  
        /**  
        assertFalse(shardRange.contains(-15));
        // Act
     * Test case for getShardId() method  
                throw new IOException("Simulated IO failure");  
        // Test inequality with different start value
    }
            @Override
        };
            }  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
        ShardRange shardRange = new ShardRange(shardId, start, end);  
        expectThrows(NullPointerException.class, () -> range.compareTo(null));
        ShardRange shardRange = new ShardRange(0, 10, 20);  
        int expectedEnd = 100;
        int actualShardId = shardRange.shardId();
        ShardRange shardRange = new ShardRange(expectedShardId, 0, 100);
    }
        // Assert
    }
    }  
     * and that it can be read back correctly.
     */  
        String expected = "{\"shard_id\":1,\"start\":0,\"end\":100}";
    public void testHashCodeConsistency() {
    public void testCompareToWithOverlappingRanges() {
    public void testGetShardIdReturnsCorrectValue() {
        int actualEnd = shardRange.end();
        // Assert  
        ShardRange shardRange = ShardRange.parse(parser);
     */  
    }
     * Test compareTo method with equal start values  
        expectThrows(NullPointerException.class, () -> shardRange.writeTo(null));  
        // Test inequality with null
    }
    public void testContainsWithHashInBetween() {
            @Override
        /**
     */
        assertEquals("getShardId() should return the correct shard ID", expectedShardId, actualShardId);
     * Test that getStart returns the correct value for a valid ShardRange
    }
import java.io.IOException;  
    }
        expectThrows(NullPointerException.class, () -> shardRange.toXContent(null, null));  
import org.opensearch.core.common.io.stream.StreamInput;
    public void testContainsWithNegativeHash() {
    public void testToXContentIOException() throws IOException {  
        assertFalse("ShardRanges with different end values should not be equal", range1.equals(range5));  
        /**
        int shardId = 1;  
        int start = 0;
        // Test inequality with different end value
            @Override
import org.opensearch.core.xcontent.XContentBuilder;
        XContentParser parser = createParser(json);
import org.opensearch.common.xcontent.json.JsonXContent;
        // Act  
        assertEquals("Incorrect start value", 0, shardRange.start());
        assertEquals("Incorrect shard ID", 1, shardRange.shardId());
        ShardRange range4 = new ShardRange(1, 10, 100);
package org.opensearch.cluster.metadata;
                throw new IOException("Simulated IOException");  
        assertFalse(shardRange.contains(25));  
        assertEquals(originalShardRange.end(), deserializedShardRange.end());
        int end = 100;
            public void writeByte(byte b) throws IOException {  
            public void write(byte[] b) throws IOException {
            }
         */
        ShardRange shardRange = new ShardRange(1, 100, 200);  
         * Test that writeTo properly propagates IOException
    }
    public void testWriteToWithNullStreamOutput() {
        XContentBuilder builder = XContentFactory.jsonBuilder(failingStream);  
import org.opensearch.common.io.stream.BytesStreamOutput;
         * This test verifies that a NullPointerException is thrown when a null XContentBuilder is provided  
     * Test hashCode() consistency for equal objects
         * Test that the contains method returns false when the hash is less than the start value.
/*  
        originalShardRange.writeTo(out);  
        ShardRange deserializedShardRange = new ShardRange(in);  
        XContentBuilder builder = XContentFactory.jsonBuilder();  // Changed from contentBuilder
         * Test toXContent method with null XContentBuilder
        StreamInput in = out.bytes().streamInput();
        /**
        assertTrue("A ShardRange should be equal to itself", range1.equals(range1));  
    public void testContainsWithHashEqualToEnd() {  
                throw new IOException("Simulated IOException");
         */
        parser.nextToken();
import org.opensearch.common.xcontent.XContentFactory;  
        // Arrange
     * Test that the writeTo method correctly writes the ShardRange data to the stream
     * Test hashCode() with zero values for all fields  
            }
    public void testContainsWithHashLessThanStart() {  
     * Verifies that the method correctly returns the end value
         * Test that the contains method returns true when the hash is equal to the end value.  
        int start = 0;
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
            }
            builder.endObject(); // End the JSON object  
        int start = 100;
        expectThrows(IOException.class, () -> {
         */
        assertEquals(0, shardRange.hashCode());
    public void testToXContentWithNullBuilder() {  
        ShardRange range1 = new ShardRange(1, 0, 100);
        // Arrange  
                throw new IOException("Simulated IOException");
     * Test that toXContent correctly serializes a ShardRange object to JSON
        String json = "{}";
     */
        int shardId = 1;  
    /**
        int end = 200;
    public void testGetStartReturnsCorrectValue() {
     */  
        return JsonXContent.jsonXContent.createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, content);
    /**  
         */
    public void testParseValidShardRange() throws IOException {
    /**
import org.opensearch.core.xcontent.NamedXContentRegistry;
    }
            }  
        // Test equality with an identical ShardRange
        ShardRange originalShardRange = new ShardRange(shardId, start, end);  
    public void testHashCodeWithZeroValues() {  
        /**  
    }
        /**
        ShardRange range1 = new ShardRange(1, 0, 100);
    }  
        assertTrue(shardRange.contains(15));  
        ShardRange shardRange = new ShardRange(0, 10, 20);
    /**
    }  
            @Override
        // Act
        // Arrange
    /**
        ShardRange shardRange = new ShardRange(0, -10, 10);  
    private XContentParser createParser(String content) throws IOException {
        assertEquals("Empty object should have default shard ID", -1, shardRange.shardId());
     */
        ShardRange shardRange = new ShardRange(0, 0, 0);
        assertEquals("getEnd() should return the correct end value", expectedEnd, actualEnd);
     * Verifies that the method correctly returns the shard ID
        assertFalse("ShardRanges with different shardIds should not be equal", range1.equals(range3));  
     * Test the toString method of ShardRange  
        assertEquals("Incorrect shard ID", 1, shardRange.shardId());  
        XContentParser parser = createParser(json);
            public void writeBytes(byte[] b, int offset, int length) throws IOException {
    /**
                throw new IOException("Simulated IO failure");
         * Test that the contains method returns true when the hash is equal to the start value.
    /**  
        assertEquals("Incorrect start value", 0, shardRange.start());
        ShardRange range3 = new ShardRange(2, 0, 100);
        ShardRange shardRange = new ShardRange(0, 10, 20);
        /**
        ShardRange range2 = new ShardRange(2, 50, 150);
     * Tests the equals method of ShardRange class for various scenarios.  
         * Test that the contains method handles negative hash values correctly.
        assertEquals("Incorrect end value", 100, shardRange.end());  
            @Override
                throw new IOException("Simulated IO failure");
            @Override
import org.opensearch.core.common.io.stream.StreamOutput;  
    }  
        assertEquals(shardRange1.hashCode(), shardRange2.hashCode());
        assertFalse("ShardRanges with different start values should not be equal", range1.equals(range4));  
        assertFalse(shardRange.contains(5));
    }
     */  
     */
    /**
    public void testContainsWithHashEqualToStart() {
        StreamOutput failingOutput = new StreamOutput() {
        assertTrue(shardRange.contains(20));
        ShardRange shardRange2 = new ShardRange(1, 100, 200);
        // The actual test - this should throw IOException when trying to write  
        String json = "{" + "\"shard_id\": 1," + "\"start\": 0," + "\"end\": 100," + "\"extra_field\": \"value\"" + "}";
     * Test case for getEnd() method of ShardRange class
        // Create a real XContentBuilder that writes to a broken OutputStream  
        builder.startObject(); // Start the JSON object
                throw new IOException("Simulated IO failure");  
     * Test compareTo method with null input
        ShardRange range2 = new ShardRange(1, 0, 100);  
    }
        });
        assertEquals(100, shardRange.start());
        ShardRange shardRange = new ShardRange(0, 10, 20);
        assertTrue(range2.compareTo(range1) > 0);
        };
         * Test that the contains method returns false when the hash is greater than the end value.  
        assertEquals(originalShardRange.start(), deserializedShardRange.start());  
import java.io.OutputStream;
 */  
    }  
        ShardRange shardRange = new ShardRange(1, 0, 100);
    public void testCompareToWithEqualStartValues() {  
        int end = 100;
         */  
    public void testParseEmptyObject() throws IOException {  
            }
        ShardRange shardRange1 = new ShardRange(1, 100, 200);  
            public void write(byte[] b, int off, int len) throws IOException {
        // Test inequality with different shardId
        /**
        assertTrue(shardRange.contains(10));
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("Empty object should have default end", -1, shardRange.end());
    public void testWriteToCorrectlySerializesAndDeserializes() throws IOException {
        int expectedShardId = 5;  
    }  
    public void testCompareToWithNull() {
    /**
    }  
            public void write(int b) throws IOException {  
        assertEquals("Incorrect end value", 100, shardRange.end());
        assertEquals(0, range1.compareTo(range2));
        assertTrue(range1.compareTo(range2) < 0);  
