    /**  
 *
    void releaseProvider(int providerKey);  
 * this file be licensed under the Apache-2.0 license or a
import java.lang.foreign.MemorySegment;
     */
     * Returns {@code true} if the owning query has been cancelled.  
     * <p>Bit layout: word {@code i} contains matches for docs
 */  
 * compatible open source license.
     * Callers can use the nextDoc to skip subsequent RGs where {@code nextDoc >= rgMax}.  
     */  
    long collectDocs(int collectorKey, int minDoc, int maxDoc, MemorySegment out);
     * @return a provider key {@code >= 0}, or {@code -1} on failure
     * <p>Return value packs two fields: upper 32 bits = next matching docId beyond
 * @opensearch.internal
public interface FilterDelegationHandle extends Closeable {
     *  
     * {@code LIVE_DOCS_MATCH_ALL_ANNOTATION_ID} in the native indexed executor.
     *
    /**
    /**  
     * @return whether the query is cancelled
     * @param maxDoc exclusive upper bound
 *
    }  
     * and the {@code writer_generation} attribute
 * SPDX-License-Identifier: Apache-2.0
     * <p>The segment is identified by its <b>writer generation</b> — the stable  
     * @return a collector key {@code >= 0}, or {@code -1} on failure (including
     * @param out destination buffer; implementation writes up to {@code out.byteSize() / 8} words
     */  
}
     * @param maxDoc exclusive upper bound
     * Create a collector for one (segment, [minDoc, maxDoc)) range.
 * The OpenSearch Contributors require contributions made to  
     *  
     * the pre-compiled query for this annotation and prepares it for segment iteration.
     *  
 * </ol>  
     * @param minDoc inclusive lower bound  
 * <ol>  
     * createProvider/createCollector/collectDocs machinery — no dedicated liveDocs FFI.
     * Release resources for a collector.
     * Fill {@code out} with the matching doc-id bitset for the given collector.
    /**
    /**
     */  
     *         "no segment with this generation" in the accepting backend)  
     * maxDoc (or {@code Integer.MAX_VALUE} if exhausted), lower 32 bits = words written.
     * Release resources for a provider.
     * identifier that matches {@code Segment.generation()} in the catalog snapshot
     * @return packed long: upper 32 = nextDoc, lower 32 = wordsWritten; or {@code -1} on error  
 * Callback surface for filter delegation between a driving backend and an accepting backend.
 *   <li>Rust calls {@link #releaseProvider(int)} when the query ends</li>
     * @param annotationId the annotation ID identifying the delegated predicate
     * Reserved annotation id for the deleted-doc filtering path: the accepting backend resolves it  
     * shard has deletions, so deleted rows are excluded through the ordinary  
    int LIVE_DOCS_MATCH_ALL_ANNOTATION_ID = -2;
    default boolean isCancelled() {
import java.io.Closeable;
 * <p>Lifecycle:
     */
 *   <li>Rust calls {@link #releaseCollector(int)} when done with a segment</li>
     * @param minDoc inclusive lower bound  
     * @param providerKey key returned by {@link #createProvider(int)}
     * The driving backend ANDs this synthetic Collector leaf into its decoded filter tree when the
    int createCollector(int providerKey, long writerGeneration, int minDoc, int maxDoc);
 * after execution completes.  
     * counter), so a negative reserved id can never collide. Must match
     */
 *   <li>Rust calls {@link #createProvider(int)} once per delegated predicate (per annotationId)</li>
        return false;
 *   <li>Rust calls {@link #collectDocs(int, int, int, MemorySegment)} per row group</li>  
     * @param collectorKey key returned by {@link #createCollector(int, long, int, int)}
    void releaseCollector(int collectorKey);
     * {@code [minDoc + i*64, minDoc + (i+1)*64)}, LSB-first within each word.
    /**
package org.opensearch.analytics.spi;
     *
 *   <li>Rust calls {@link #createCollector(int, long, int, int)} per (provider × segment)</li>
 *
     *
 */  
     * to a match-all query whose per-RG collector emits the segment's live docs (set bit == live).
     *
     * <p>Coordinator-assigned annotation ids are non-negative ({@code PlannerContext.nextAnnotationId}  
     * Create a provider for the given annotation ID. The accepting backend looks up
 * <p>One handle per query per shard. The accepting backend implements this interface;
     */  
     *  
    /**  
    int createProvider(int annotationId);
 *  
     * @param writerGeneration the writer generation for this segment
/**
 * the driving backend calls into it via FFM upcalls during execution. Core closes it
/*  
