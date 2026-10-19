    }  
@ExperimentalApi
     *  
public sealed interface WriteResult {
 */  
     * @param seqNo    the sequence number at the time of failure, or {@code -1} if unassigned
     * @param term     the primary term under which the write was executed
    record Success(long version, long term, long seqNo) implements WriteResult {
 *
 * compatible open source license.
import org.opensearch.common.annotation.ExperimentalApi;
/**  
     * A successful write result.
 * this file be licensed under the Apache-2.0 license or a
    /**
    }
     * @param term     the primary term at the time of failure, or {@code -1} if unavailable
    record Failure(Exception cause, long version, long term, long seqNo) implements WriteResult {
     *
 * SPDX-License-Identifier: Apache-2.0
     * @param version  the document version assigned by the engine
 */  
/*  
     */
     * @param version  the document version at the time of failure, or {@code -1} if unavailable  
package org.opensearch.index.engine.dataformat;
    /**
 * or a {@link Failure}. Each variant carries the version, primary term, and sequence
     */  
     * A failed write result.  
 * Sealed result of a document write operation, representing either a {@link Success}
}  
 * @opensearch.experimental
     * @param seqNo    the sequence number assigned to the operation  
 * The OpenSearch Contributors require contributions made to  
 * number assigned (or attempted) by the engine.  
     * @param cause    the exception that caused the write to fail
 *
