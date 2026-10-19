     * @throws java.util.concurrent.TimeoutException If the operation could not be completed within {@code timeoutMillis}
     * @return a list of messages read from the source  
 * compatible open source license.
     * @param timeoutMillis the maximum time to wait for messages  
    int getShardId();
            this.pointer = pointer;  
     * @param timeoutMillis the maximum time to wait for messages  
    /**
    /**  
     */  
            return pointer;
    IngestionShardPointer earliestPointer();  
        }
     * @return the latest pointer in the shard. The pointer points to the next offset of the last message in the stream.  
            this.message = message;
    List<ReadResult<T, M>> readNext(long maxMessages, int timeoutMillis) throws java.util.concurrent.TimeoutException;
    /**
     * @return pointer based lag if available, else 0.
     * A read result containing the pointer and the message  
     */
}
     * @return the earliest pointer in the shard
     * @param pointer the pointer to start reading from,  
     */
     * @param timestampMillis the timestamp in milliseconds
     * milliseconds
        /**  
@PublicApi(since = "3.6.0")
/*  
     */
 *
        }
    class ReadResult<T, M> {
         * @param message the message  
    /**  
     * @throws java.util.concurrent.TimeoutException
     */
        public ReadResult(T pointer, M message) {
import java.util.List;
    IngestionShardPointer latestPointer();
 * The OpenSearch Contributors require contributions made to  
     * Read the next set of messages from the source
         */  
 */
         * @return the pointer to the message
     */  
 * SPDX-License-Identifier: Apache-2.0
     *
 * @param <M> the type of the message  
import java.io.Closeable;  
        throws java.util.concurrent.TimeoutException;  
    /**
         * @param pointer the pointer to the message
    List<ReadResult<T, M>> readNext(T pointer, boolean includeStart, long maxMessages, int timeoutMillis)
    }
public interface IngestionShardConsumer<T extends IngestionShardPointer, M extends Message> extends Closeable {  
     * This method is used as an optimization for consecutive reads.
    /**
     * Returns an ingestion shard pointer based on the provided timestamp in milliseconds.
         * @return the message  
     * Returns the pointer based lag for the current shard consumer.
     */
    IngestionShardPointer pointerFromTimestampMillis(long timestampMillis);
 * this file be licensed under the Apache-2.0 license or a
     * @return the ingestion shard pointer corresponding to the given offset
     * @param maxMessages the maximum number of messages to read, or -1 for no limit
 * @param <T> the type of the pointer to the message
         * Create a new read result
package org.opensearch.index;
     * @return the shard id  
     * @param expectedStartPointer the ingestion start point on first time shard initialization.  
    IngestionShardPointer pointerFromOffset(String offset);  
     */  
     * Returns an ingestion shard pointer based on the provided offset.
    /**
     * @param <T> the type of the pointer to the message
/**  
 */  
        /**
         */
     * @param <M> the type of the message
    /**
        public M getMessage() {
            return message;  
        /**
     *  
    long getPointerBasedLag(IngestionShardPointer expectedStartPointer);  
 * A consumer for reading messages from an ingestion shard.
        T pointer;  
     * @param maxMessages, the maximum number of messages to read, or -1 for no limit
        public T getPointer() {
     * @param offset the offset value  
        }  
     * Read the next set of messages from the source using the previous pointer. An exception is thrown if no previous pointer is available.  
import org.opensearch.common.annotation.PublicApi;
    @PublicApi(since = "3.6.0")
    /**
     * @return the ingestion shard pointer corresponding to the given timestamp
         */
     */
     * @param includeStart whether to include the start pointer in the read
     * @return a list of messages read from the source
        M message;
