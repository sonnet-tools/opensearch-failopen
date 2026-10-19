public interface IngestionShardPointer extends Comparable<IngestionShardPointer> {
 */
     * Convert the pointer to a string.
 */  
    Query newRangeQueryGreaterThan(String fieldName);
 * compatible open source license.
     *  
     */  
    byte[] serialize();
     * @return the serialized byte array  
import org.apache.lucene.document.Field;
     * checkpoints.
@PublicApi(since = "3.6.0")  
 *
    String asString();
package org.opensearch.index;
 * SPDX-License-Identifier: Apache-2.0
     * Creates a point field for this pointer. This is used to store the pointer in the index for range search during
     * Create a new range query for values greater than the pointer. This is used in recovering from the ingestion
     */
 * The OpenSearch Contributors require contributions made to  
     * Serialize the pointer to a byte array.
     */  
 * ingestion.
     * checkpoint recovery.  
     * @return query for values greater than the pointer
     * @return the point field
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.annotation.PublicApi;  
     * @param fieldName the field name to create the point field
    /**
/**
    /**
    Field asPointField(String fieldName);
    /**
    String OFFSET_FIELD = "_offset";
     * @return the string representation of the pointer  
 * An interface for the pointer to a shard in the ingestion engine, and it is used to track the message offset of  
import org.apache.lucene.search.Query;
     */
     * @param fieldName the field name to create the range query
/*  
    /**  
}
