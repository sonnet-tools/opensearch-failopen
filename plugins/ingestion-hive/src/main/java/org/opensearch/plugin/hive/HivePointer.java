import java.nio.charset.StandardCharsets;
    private final long rowIndex;
import java.util.Objects;  
import org.opensearch.core.xcontent.XContentParser;  
        this.partitionName = partitionName;
     * Deserializes a HivePointer from its JSON string representation.  
            builder.field("r", rowIndex);
        }
     */
                        break;
        ) {  
                    case "p":  
            }
        buffer.putLong(sequenceNumber);
            String file = null;
     * Creates a new HivePointer.  
    public long getRowIndex() {
}
/**
        if (!(o instanceof HivePointer other)) {
    public String getFilePath() {
    public String toString() {
 * compatible open source license.
                    case "r":  
                        break;
    public int compareTo(IngestionShardPointer o) {  
    }  
            builder.field("s", sequenceNumber);  
            throw new IllegalArgumentException("Failed to parse HivePointer: " + s, e);  
            if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
    }
    /** Returns the data file path. */
        return LongPoint.newRangeQuery(fieldName, sequenceNumber + 1, Long.MAX_VALUE);
    /**
                    case "f":  
    /** Returns the row index within the file. */  
    public long getSequenceNumber() {  
    /**
        } catch (IOException e) {  
    private final String filePath;
        byte[] str = asString().getBytes(StandardCharsets.UTF_8);  
    public byte[] serialize() {
        this.rowIndex = rowIndex;
    }
import java.io.IOException;  
            )
        this.filePath = filePath;  
    public int hashCode() {  
/*  
    @Override  
     *
 * Pointer representing a position within a Hive table.  
 * this file be licensed under the Apache-2.0 license or a
                }
            XContentParser parser = JsonXContent.jsonXContent.createParser(
    }  
            builder.endObject();
    @Override
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.NamedXContentRegistry;
        return "HivePointer{" + asString() + "}";  
                        break;
    public boolean equals(Object o) {
            builder.field("p", partitionName);  
import org.apache.lucene.document.Field;
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES + str.length);
            && Objects.equals(partitionName, other.partitionName)
 * The OpenSearch Contributors require contributions made to  
            XContentBuilder builder = XContentFactory.jsonBuilder();
import org.opensearch.common.xcontent.json.JsonXContent;
                s
    /** Returns the partition name. */
    }  
     * @return the deserialized HivePointer  
    }
        buffer.put(str);  
            throw new IllegalArgumentException("Cannot compare with " + o.getClass());
     */  
                        file = parser.text();
                    default:  
        try {  
    private final long sequenceNumber;  
    public Field asPointField(String fieldName) {
    public HivePointer(String partitionName, String filePath, long rowIndex, long sequenceNumber) {
    private final String partitionName;  
     * @param sequenceNumber monotonically increasing counter for ordering
        }  
                    case "s":  
            builder.field("f", filePath);
            return builder.toString();
        return filePath;  
        try (  
 */  
                        break;
        }
            && rowIndex == other.rowIndex  
    }  
    }
 * The sequence number is used for ordering and checkpoint recovery.
                        seq = parser.longValue();
    @Override
 * Encodes partition name, file path, row index, and a monotonic sequence number.
        return sequenceNumber;
    /** Returns the sequence number. */
                String field = parser.currentName();  
    public String asString() {
            String partition = null;
                throw new IllegalArgumentException("Malformed HivePointer, expected a JSON object: " + s);  
    }
            return new HivePointer(partition, file, row, seq);
                        partition = parser.text();
    @Override
        return new LongPoint(fieldName, sequenceNumber);  
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,  
    }
     * @param s the serialized pointer string
    }
     *
    @Override
        return partitionName;
     * @param partitionName the Hive partition name (e.g., {@code dt=2026-04-15})
public class HivePointer implements IngestionShardPointer {
            && Objects.equals(filePath, other.filePath);
    }  
        return Long.compare(sequenceNumber, other.sequenceNumber);
    }
package org.opensearch.plugin.hive;
import org.apache.lucene.document.LongPoint;
 */  
        return rowIndex;
 *
        if (this == o) return true;  
        return sequenceNumber == other.sequenceNumber
        return Objects.hash(partitionName, filePath, rowIndex, sequenceNumber);
        return buffer.array();
            long seq = 0;
                        row = parser.longValue();
            }  
            throw new IllegalStateException("Failed to serialize HivePointer", e);
import java.nio.ByteBuffer;
                NamedXContentRegistry.EMPTY,
    public Query newRangeQueryGreaterThan(String fieldName) {
        } catch (IOException e) {
    @Override
import org.opensearch.core.xcontent.XContentBuilder;
    }
    public String getPartitionName() {  
    @Override
        this.sequenceNumber = sequenceNumber;
                parser.nextToken();
        if (!(o instanceof HivePointer other)) return false;
     * @param filePath the full path to the data file  
import org.apache.lucene.search.Query;  
import org.opensearch.index.IngestionShardPointer;
import org.opensearch.common.xcontent.XContentFactory;
                switch (field) {
            while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
            builder.startObject();
import org.opensearch.core.xcontent.DeprecationHandler;  
    @Override
            long row = 0;  
    public static HivePointer fromString(String s) {
                        break;
     * @param rowIndex the row offset within the file
