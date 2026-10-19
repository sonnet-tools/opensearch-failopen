        assert operation.seqNo() == SequenceNumbers.UNASSIGNED_SEQ_NO : operation;  
     * @param operation  the engine operation (must be PRIMARY with unassigned seq no)  
    }  
     * would exceed the limit, the reservation is rolled back and an exception is returned.
import java.io.IOException;  
     * If multiple writes passed {@link DocumentCountTracker#tryAcquireInFlightDocs(Engine.Operation, int)} but they haven't adjusted
        return inFlightDocCount.get();
     * this shouldn't be an issue because it happens for a short window and we adjust the inFlightDocCount once an indexing is completed.
        assert numDocs >= 0 : numDocs;
    void releaseInFlightDocs(int numDocs) {  
        }
        long totalDocs;
     *  
        assert addingDocs > 0 : addingDocs;
 * compatible open source license.
     * {@link DocumentCountTracker#tryAcquireInFlightDocs(Engine.Operation, int)}. Although we can double count some inFlight documents in IW and Engine,  
/*  
     */
        }
    Exception tryAcquireInFlightDocs(Engine.Operation operation, int addingDocs) {
        this.shardId = shardId;  
     * @param shardId     the shard this tracker belongs to (for error messages)
            releaseInFlightDocs(addingDocs);  
 * this file be licensed under the Apache-2.0 license or a
}  
            totalDocs = inFlightDocCount.addAndGet(addingDocs) + indexedDocs.get();
            );
 * multiple concurrent writes pass the document count check but haven't yet been committed —
 * SPDX-License-Identifier: Apache-2.0
 */
     * @param numDocs number of document slots to release (must be non-negative)
        assert newValue >= 0 : "inFlightDocCount must not be negative [" + newValue + "]";  
     */  
 * Tracks in-flight document counts to prevent exceeding the maximum document limit per shard.
 * @opensearch.internal  
            releaseInFlightDocs(addingDocs);
    private final CheckedSupplier<Long, IOException> indexedDocs;
    private final ShardId shardId;
     * @param docsAllowed maximum number of documents allowed in this shard  
    DocumentCountTracker(ShardId shardId, CheckedSupplier<Long, IOException> indexedDocs, long docsAllowed) {
        this.docsAllowed = docsAllowed;
     * @param addingDocs number of documents being added
    /**
     * the engine because we already generated sequence numbers for write operations; otherwise we will have gaps in sequence numbers.
    long getInFlightDocCount() {  
            return null;  
 */  
     *
    private final long docsAllowed;  
        this.indexedDocs = indexedDocs;
 * The OpenSearch Contributors require contributions made to  
    }
 *
        try {  
    /**
            return new IllegalArgumentException(
     * @return {@code null} if acquired successfully, or an {@link IllegalArgumentException} if the limit would be exceeded
/**  
     * {@link IndexWriter#getPendingNumDocs()} yet, then IndexWriter can fail with too many documents. In this case, we have to fail  
class DocumentCountTracker {
import org.opensearch.common.CheckedSupplier;
 * without tracking, the underlying storage could reject the write after a sequence number  
     */
    }
     * To avoid this, we keep track the number of documents that are being added to IndexWriter, and account it in
 * <p>
 *
import org.apache.lucene.index.IndexWriter;
                "Number of documents in shard " + shardId + " exceeds the limit of [" + docsAllowed + "] documents per shard"  
    private final AtomicLong inFlightDocCount = new AtomicLong();  
package org.opensearch.index.engine;
import java.util.concurrent.atomic.AtomicLong;
        } catch (IOException e) {
        if (totalDocs > docsAllowed) {  
        final long newValue = inFlightDocCount.addAndGet(-numDocs);
 * {@link DataFormatAwareEngine} (pluggable data format). It guards against a race where
     * Releases previously acquired in-flight document slots after indexing completes or fails.
 * has already been assigned, creating gaps.
     * Attempts to reserve {@code addingDocs} document slots. If the total (in-flight + indexed)  
     */
import org.opensearch.index.seqno.SequenceNumbers;
            return e;
 * This class is shared between {@link InternalEngine} (Lucene-based) and  
    /**  
     * @param indexedDocs supplier returning the current committed + pending doc count
        } else {
    /**
        assert operation.origin() == Engine.Operation.Origin.PRIMARY : operation;
    }
import org.opensearch.core.index.shard.ShardId;  
