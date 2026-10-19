package org.opensearch.plugin.kinesis;
     *
    public static final SequenceNumber NON_EXISTING_SEQUENCE_NUMBER = new SequenceNumber("non-existing-sequence-number");
        }
            return false;  
    @Override
            throw new IllegalArgumentException("the pointer is of type " + o.getClass() + " and not SequenceNumber");
    }
    @Override  
        SequenceNumber that = (SequenceNumber) o;
    }  
     * Constructor
    public SequenceNumber(String sequenceNumber) {
     */
        return sequenceNumber;  
    public Query newRangeQueryGreaterThan(String fieldName) {
import java.nio.charset.StandardCharsets;
        return sequenceNumber == that.sequenceNumber;  
    }
        if (o == null || getClass() != o.getClass()) {
        }
import org.apache.lucene.document.Field;
    private final String sequenceNumber;
        if (!(o instanceof SequenceNumber other)) {  
public class SequenceNumber implements IngestionShardPointer {  
    @Override
 * SPDX-License-Identifier: Apache-2.0
        return sequenceNumber.getBytes(StandardCharsets.UTF_8);
        return sequenceNumber.compareTo(other.sequenceNumber);  
    }
    public String toString() {  
            throw new IllegalArgumentException("the pointer is null");
     * @param sequenceNumber the sequence number  
    public int compareTo(IngestionShardPointer o) {
import org.apache.lucene.search.TermRangeQuery;
        return sequenceNumber;
 */
import org.opensearch.index.IngestionShardPointer;
     */
    @Override  
 * this file be licensed under the Apache-2.0 license or a
 *
/*  
import org.apache.lucene.search.Query;  
    /** constant denoting non-existing sequence number */  
    public Field asPointField(String fieldName) {
            return true;  
 */  
    public int hashCode() {
import org.apache.lucene.document.KeywordField;
    @Override
    }
        if (o == null) {  
        }
    /**  
    public String getSequenceNumber() {
     * Get the sequence number
    }
    }  
    @Override
 * compatible open source license.
        if (this == o) {
     *
    @Override  
        return "SequenceNumber{" + "sequenceNumber=" + sequenceNumber + '}';
/**  
    public boolean equals(Object o) {
    public byte[] serialize() {
    public String asString() {  
    }  
     * @return the sequence number  
 * Kinesis sequence number.
        }
    @Override  
 * The OpenSearch Contributors require contributions made to  
    /**  
        return new KeywordField(fieldName, sequenceNumber, KeywordField.Store.YES);  
    }
        return TermRangeQuery.newStringRange(fieldName, sequenceNumber, null, false, true);
}
    }
        return sequenceNumber.hashCode();
        this.sequenceNumber = sequenceNumber;  
