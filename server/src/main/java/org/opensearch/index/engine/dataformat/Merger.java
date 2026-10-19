     * from a fresh reader, or the two formats diverge on any delete that lands in between.
/**
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
     * docs} freezes its delete state for the merge inputs here and publishes the frozen view, so
     * the primary-format merger drops exactly the rows this format will physically drop in  
     * Whether this format owns delete state and can freeze it for the duration of a merge via  
     * {@link #merge}. Implementations must derive the view from the merge's frozen readers, not
     */
    /**  
     * not the merge runs; {@link MergePreparation#close()} is a no-op once {@code merge()} has  
 * Interface for merging multiple writer file sets into a single merged result.  
     * Phase 1 of a two-phase merge. A format that {@link #providesMergeLiveDocs() provides live
     * @return merge result containing row ID mapping and merged file metadata
 * The OpenSearch Contributors require contributions made to  
    MergeResult merge(MergeInput mergeInput) throws IOException;  
     * composite validates this when it is built and fails fast otherwise, so a second producer
 *
    /**
    }
 * @opensearch.experimental
import java.io.IOException;  
     *
}  
    default boolean providesMergeLiveDocs() {
     * caller holds it in a try-with-resources around {@link #merge} so it is released whether or
     */
     * {@link #prepareMerge}. In a composite at most one format may return {@code true}; the
import org.opensearch.common.annotation.ExperimentalApi;
/*  
        return MergePreparation.EMPTY;
 */  
    default MergePreparation prepareMerge(MergeInput mergeInput) throws IOException {  
     */
     * consumed the prepared state. Default returns {@link MergePreparation#EMPTY}.
@ExperimentalApi
 *
package org.opensearch.index.engine.dataformat;
public interface Merger {
    /**  
        return false;  
     * @param mergeInput input containing files to merge, and any instructions about how to execute the merge.  
 */  
     * <p>The returned {@link MergePreparation} owns whatever was pinned to freeze the view. The
    }
     * cannot be silently ignored.  
     * Merges a list of writer file sets into a single merged result.
     *  
 * this file be licensed under the Apache-2.0 license or a
