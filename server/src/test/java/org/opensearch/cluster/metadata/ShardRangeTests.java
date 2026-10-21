        // Act
    public void testCompareToWithOverlappingRanges() {
    }
        ShardRange range2 = new ShardRange(1, 0, 100);
                throw new IOException("Simulated IO failure");
        int start = 0;
        ShardRange originalShardRange = new ShardRange(shardId, start, end);
        ShardRange range1 = new ShardRange(1, 0, 100);
        // Test inequality with different end value
    }
        ShardRange shardRange = new ShardRange(0, 10, 20);
    }
        assertEquals("Incorrect shard ID", 1, shardRange.shardId());
            public void close() throws IOException {
        // Arrange
                throw new IOException("Simulated IO failure");
    public void testContainsWithHashEqualToEnd() {
        assertFalse("ShardRanges with different end values should not be equal", range1.equals(range5));
            public void writeBytes(byte[] b, int offset, int length) throws IOException {
         */
    /**
import org.opensearch.core.xcontent.XContentParser;
        assertTrue(shardRange.contains(20));
     * Test that the writeTo method correctly writes the ShardRange data to the stream
        ShardRange shardRange = ShardRange.parse(parser);
        assertFalse(shardRange.contains(25));
        /**
        assertEquals("Empty object should have default start", -1, shardRange.start());
    public void testCompareToWithEqualStartValues() {
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
public class ShardRangeTests extends OpenSearchTestCase {
    public void testGetStartReturnsCorrectValue() {
    public void testToStringReturnsCorrectRepresentation() {
        /**
        assertEquals(100, shardRange.start());
    }
         */
        assertTrue(range2.compareTo(range1) > 0);
            @Override
            public void reset() throws IOException {
        /**
        builder = shardRange.toXContent(builder, null);
        // Test equality with itself
import org.opensearch.core.common.io.stream.StreamOutput;
         */
    }
import org.opensearch.test.OpenSearchTestCase;
    }
    }
            }
        ShardRange shardRange = new ShardRange(0, 0, 0);
                throw new IOException("Simulated IO failure");
        // Assert
    /**
        });
        // Test equality with an identical ShardRange
     * Verifies that the method correctly returns the end value
import org.opensearch.common.xcontent.XContentFactory;
                throw new IOException("Simulated IOException");
    /**
}
    }
    }
         */
                throw new IOException("Simulated IO failure");
        String json = "{" + "\"shard_id\": 1," + "\"start\": 0," + "\"end\": 100" + "}";
         */
         * Test that writeTo properly propagates IOException
            }
import java.io.OutputStream;
            public void flush() throws IOException {
        assertTrue(shardRange.contains(15));
    }
        ShardRange shardRange = new ShardRange(0, 10, 20);
    public void testGetEndReturnsCorrectValue() {
        assertFalse("A ShardRange should not be equal to null", range1.equals(null));
        BytesStreamOutput out = new BytesStreamOutput();
         */
        assertEquals("getEnd() should return the correct end value", expectedEnd, actualEnd);
         * Test that the contains method returns false when the hash is less than the start value.
        assertEquals(originalShardRange.start(), deserializedShardRange.start());
        /**
        assertEquals("Incorrect start value", 0, shardRange.start());
import org.opensearch.core.common.io.stream.StreamInput;
    /**
    /**
        OutputStream failingStream = new OutputStream() {
        XContentParser parser = createParser(json);
        ShardRange range5 = new ShardRange(1, 0, 90);
     * Verifies that the toString method returns the expected string representation
import org.opensearch.core.xcontent.NamedXContentRegistry;
    public void testContainsWithNegativeHash() {
        assertEquals(originalShardRange.end(), deserializedShardRange.end());
    /**
         * Test toXContent method with null XContentBuilder
        // Act
        ShardRange shardRange = new ShardRange(1, 0, 100);
        // Test inequality with different start value
        assertEquals("Empty object should have default shard ID", -1, shardRange.shardId());
    public void testHashCodeWithZeroValues() {
     * Test hashCode() consistency for equal objects
        };
        // Test inequality with null
        expectThrows(NullPointerException.class, () -> shardRange.toXContent(null, null));
        assertEquals(originalShardRange.shardId(), deserializedShardRange.shardId());
    public void testToXContentIOException() throws IOException {
import org.opensearch.common.xcontent.json.JsonXContent;
    public void testCompareToWithNull() {
 * SPDX-License-Identifier: Apache-2.0
        expectThrows(IOException.class, () -> {
        int shardId = 1;
    /**
        int actualEnd = shardRange.end();
/*
    public void testContainsWithHashInBetween() {
     * Test hashCode() with zero values for all fields
        ShardRange shardRange = new ShardRange(1, 0, 100);
        String expected = "{\"shard_id\":1,\"start\":0,\"end\":100}";
    }
        String json = "{}";
        int start = 100;
        assertEquals("getShardId() should return the correct shard ID", expectedShardId, actualShardId);
 * this file be licensed under the Apache-2.0 license or a
        expectThrows(NullPointerException.class, () -> range.compareTo(null));
        /**
        assertTrue(range1.compareTo(range2) < 0);
     * Verifies that the method correctly returns the shard ID
        parser.nextToken();
        ShardRange shardRange = ShardRange.parse(parser);
    }
        // Assert
         */
        ShardRange range = new ShardRange(1, 0, 100);
    }
    }
        ShardRange range2 = new ShardRange(2, 0, 200);
    public void testContainsWithHashLessThanStart() {
        ShardRange shardRange = new ShardRange(expectedShardId, 0, 100);
        int expectedShardId = 5;
     */
        ShardRange shardRange2 = new ShardRange(1, 100, 200);
        assertEquals("Incorrect end value", 100, shardRange.end());
    }
            public void write(byte[] b) throws IOException {
        };
            shardRange.toXContent(builder, null);
        assertFalse(shardRange.contains(5));
        // Assert
        XContentBuilder builder = XContentFactory.jsonBuilder();  // Changed from contentBuilder
                throw new IOException("Simulated IOException");
        assertEquals("Incorrect end value", 100, shardRange.end());
        assertEquals("Incorrect start value", 0, shardRange.start());
            }
    }
import org.opensearch.common.io.stream.BytesStreamOutput;
        ShardRange range1 = new ShardRange(1, 0, 100);
            @Override
     */
        XContentParser parser = createParser(json);
     * Test case for getEnd() method of ShardRange class
        int shardId = 1;
    public void testHashCodeConsistency() {
        ShardRange shardRange = new ShardRange(0, 10, 20);
import java.io.IOException;
        int end = 100;
        // The actual test - this should throw IOException when trying to write
         * Test that writeTo throws NullPointerException when StreamOutput is null
            @Override
        int expectedEnd = 100;
 * compatible open source license.
        assertEquals(0, shardRange.hashCode());
         * Test that the contains method returns true when the hash is equal to the start value.
        assertEquals(0, range1.compareTo(range2));
        ShardRange deserializedShardRange = new ShardRange(in);
     */
        // Arrange
                throw new IOException("Simulated IOException");
        parser.nextToken();
        int shardId = 1;
        XContentBuilder builder = XContentFactory.jsonBuilder(failingStream);
    public void testGetShardIdReturnsCorrectValue() {
        assertTrue("Two identical ShardRanges should be equal", range1.equals(range2));
    public void testToXContentWithNullBuilder() {
     * Test that getStart returns the correct value for a valid ShardRange
     * Test the toString method of ShardRange
     */
            }
    }
                throw new IOException("Simulated IO failure");
     */
        /**
     */
    }
     * and that it can be read back correctly.
            @Override
     */
        ShardRange shardRange = new ShardRange(1, 0, 100);
            @Override
    public void testParseEmptyObject() throws IOException {
        ShardRange shardRange = new ShardRange(0, 0, expectedEnd);
        ShardRange shardRange = ShardRange.parse(parser);
    }
        ShardRange shardRange = new ShardRange(1, 100, 200);
    public void testWriteToCorrectlySerializesAndDeserializes() throws IOException {
    /**
        ShardRange range2 = new ShardRange(2, 50, 150);
     * Tests the equals method of ShardRange class for various scenarios.
    private XContentParser createParser(String content) throws IOException {
            public void writeByte(byte b) throws IOException {
        ShardRange shardRange = new ShardRange(1, 0, 100);
    /**
     * Test compareTo method with overlapping ranges
         * Test that the contains method returns true when the hash is equal to the end value.
        ShardRange range3 = new ShardRange(2, 0, 100);
        assertTrue(shardRange.contains(10));
     */
        assertFalse(shardRange.contains(-15));
 */
        int end = 100;
        assertFalse("ShardRanges with different start values should not be equal", range1.equals(range4));
 * The OpenSearch Contributors require contributions made to
        ShardRange shardRange = new ShardRange(shardId, start, end);
            @Override
    /**
            public void write(byte[] b, int off, int len) throws IOException {
        // Act
    }
    }
            builder.close(); // Force flush/close which will trigger the write
    public void testParseWithExtraFields() throws IOException {
     * Test compareTo method with equal start values
    }
        /**
    public void testContainsWithHashGreaterThanEnd() {
            public void write(int b) throws IOException {
        assertEquals(expected, builder.toString());  // Also switched the order of expected and actual
        expectThrows(IOException.class, () -> shardRange.writeTo(failingOutput));
            @Override
            @Override
     */
        originalShardRange.writeTo(out);
        assertEquals("Incorrect shard ID", 1, shardRange.shardId());
        String expected = "ShardRange{shardId=1, start=0, end=100}";
    }
        StreamInput in = out.bytes().streamInput();
        // Create ShardRange objects for testing
    /**
        // Test inequality with different shardId
        int actualShardId = shardRange.shardId();
        StreamOutput failingOutput = new StreamOutput() {
        XContentParser parser = createParser(json);
            }
        /**
        assertTrue(shardRange.contains(-5));
        String json = "{" + "\"shard_id\": 1," + "\"start\": 0," + "\"end\": 100," + "\"extra_field\": \"value\"" + "}";
        // Arrange
        assertFalse("ShardRanges with different shardIds should not be equal", range1.equals(range3));
        ShardRange shardRange1 = new ShardRange(1, 100, 200);
    public void testWriteToWithIOException() {
        int start = 0;
        int end = 200;
        assertEquals("The toString method should return the correct string representation", expected, result);
        ShardRange shardRange = new ShardRange(0, 10, 20);
         */
            }
         */
        assertTrue("A ShardRange should be equal to itself", range1.equals(range1));
    public void testParseValidShardRange() throws IOException {
    public void testContainsWithHashEqualToStart() {
            }
        assertEquals(shardRange1.hashCode(), shardRange2.hashCode());
     */
        expectThrows(NullPointerException.class, () -> shardRange.writeTo(null));
 *
            }
    }
            builder.endObject(); // End the JSON object
        builder.startObject(); // Start the JSON object
         * Test that the contains method returns true when the hash is equal to the end value.
        parser.nextToken(); // Move to start object
        String result = shardRange.toString();
        ShardRange shardRange = new ShardRange(shardId, start, end);
    public void testToXContentSerializesShardRangeCorrectly() throws IOException {
         * This test verifies that a NullPointerException is thrown when a null XContentBuilder is provided
        return JsonXContent.jsonXContent.createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, content);
         * Test that the contains method handles negative hash values correctly.
import org.opensearch.core.xcontent.XContentBuilder;
        ShardRange shardRange = new ShardRange(0, -10, 10);
    /**
    }
        ShardRange range1 = new ShardRange(1, 0, 100);
        // Create a real XContentBuilder that writes to a broken OutputStream
     */
        /**
    }
    public void testEqualsMethod() {
     */
        assertEquals("Empty object should have default end", -1, shardRange.end());
     * Test compareTo method with null input
         * Test that the contains method returns false when the hash is greater than the end value.
        ShardRange shardRange = new ShardRange(0, 10, 20);
     * Test that toXContent correctly serializes a ShardRange object to JSON
        ShardRange range4 = new ShardRange(1, 10, 100);
     * Test case for getShardId() method
    public void testWriteToWithNullStreamOutput() {
package org.opensearch.cluster.metadata;
