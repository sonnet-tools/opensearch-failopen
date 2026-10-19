import java.io.IOException;
     * The frozen per-segment live-docs view. Never {@code null}; {@link LiveDocs#ALL_ALIVE} when  
     */
 * consume, and must be idempotent and a no-op once {@code merge()} has taken the prepared state.
 *
 * <p>Mirrors {@link MergeResult} for the prepare phase. {@link Closeable} because preparing pins
@ExperimentalApi
     * Releases prepared state the merge did not consume. Idempotent; a no-op after the format's  
            // nothing pinned
import org.opensearch.common.annotation.ExperimentalApi;
     */
 */  
     * {@link Merger#merge} has taken the prepared state.
    /**
    @Override  
 * resources: {@link #close()} releases anything the subsequent {@link Merger#merge} did not  
 *
     * the preparing format has no deletes on the merge inputs.
    /**
    LiveDocs liveDocs();  
 * compatible open source license.
 *
 * The OpenSearch Contributors require contributions made to  
}
 */  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        @Override
 * The product of {@link Merger#prepareMerge}: a frozen {@link LiveDocs} view plus ownership of
        }  
            return LiveDocs.ALL_ALIVE;
        @Override  
package org.opensearch.index.engine.dataformat;
import java.io.Closeable;  
 * whatever state the format pinned to freeze it (for Lucene, the merge readers and their file
public interface MergePreparation extends Closeable {
 * @opensearch.experimental
/**  
    /** Preparation that froze nothing: all rows alive, nothing to release. */
        }
    };  
 * references).  
    void close() throws IOException;
 * unconditional on the failure path without an explicit abort call.  
/*  
 * Callers hold the preparation in a try-with-resources around the merge so the release is
        public void close() {  
        public LiveDocs liveDocs() {
    MergePreparation EMPTY = new MergePreparation() {
