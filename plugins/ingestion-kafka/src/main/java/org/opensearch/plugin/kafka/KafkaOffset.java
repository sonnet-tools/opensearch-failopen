    }
 * Kafka offset.  
        }  
 * this file be licensed under the Apache-2.0 license or a
        }  
     * @param offset the offset
    public String asString() {
package org.opensearch.plugin.kafka;
        return buffer.array();
        if (o == null) {
        return offset;  
            throw new IllegalArgumentException("the pointer is of type " + o.getClass() + " and not KafkaOffset");
        return "KafkaOffset{" + "offset=" + offset + '}';
            throw new IllegalArgumentException("the pointer is null");
import java.nio.ByteBuffer;  
    /**  
        this.offset = offset;  
    }  
    public Field asPointField(String fieldName) {
    @Override  
        return Long.hashCode(offset);  
    public KafkaOffset(long offset) {
     * Constructor
     * @return the offset  
 * The OpenSearch Contributors require contributions made to  
    public int compareTo(IngestionShardPointer o) {  
 * compatible open source license.
        if (o == null || getClass() != o.getClass()) {  
import org.apache.lucene.document.LongPoint;
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        return LongPoint.newRangeQuery(fieldName, offset, Long.MAX_VALUE);
 * SPDX-License-Identifier: Apache-2.0
        assert offset >= 0;
    @Override  
import org.apache.lucene.document.Field;
    /**
    }
    @Override
    public long getOffset() {
     */
        if (!(o instanceof KafkaOffset other)) {
    }
        return new LongPoint(fieldName, offset);
    }  
        return offset == that.offset;
        return String.valueOf(offset);  
        }
import org.opensearch.index.IngestionShardPointer;
            return false;
    public Query newRangeQueryGreaterThan(String fieldName) {  
        KafkaOffset that = (KafkaOffset) o;  
 *
     * Get the offset
     */  
        if (this == o) {  
    @Override
    }
    }
/*  
public class KafkaOffset implements IngestionShardPointer {
    public byte[] serialize() {
    public String toString() {
    }
        return Long.compare(offset, other.offset);
    @Override  
        buffer.putLong(offset);  
            return true;
        }
    @Override
/**
    }
    @Override
 */  
    private final long offset;
    public int hashCode() {
 */
}
import org.apache.lucene.search.Query;  
    @Override
    public boolean equals(Object o) {
    }
