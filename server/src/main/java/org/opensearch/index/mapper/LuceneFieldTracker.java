 * yet visible. This makes the limit a <em>soft</em> limit — a small overshoot between refreshes  
    /**
    }
 * refresh cycle. Allows {@link DocumentParser} to enforce the dynamic-properties Lucene
    private final AtomicReference<FieldInfos> fieldInfosRef = new AtomicReference<>(FieldInfos.EMPTY);  
 * field-count limit without threading a per-parse snapshot through the call-stack.  
 *
    public void setFieldInfos(FieldInfos fieldInfos) {  
 * is acceptable.
 * The OpenSearch Contributors require contributions made to  
 * Tracks the set of Lucene fields known to the shard's index, refreshed on each NRT reader
     * Returns {@link FieldInfos#EMPTY} if no refresh has occurred yet.  
     * Updates the tracked field infos with the merged snapshot from the latest refresh.  
        this.fieldInfosRef.set(fieldInfos);
 * <p>An instance is attached to {@link MapperService}. After each successful internal refresh,
     * Called by the {@code IndexShard} refresh listener after each successful internal refresh.
    /**
     */
 */
     * Replaced atomically on each refresh; starts as {@link FieldInfos#EMPTY}.
    }
@PublicApi(since = "3.0.0")
 *
     * Returns the merged {@link FieldInfos} captured at the last refresh.
package org.opensearch.index.mapper;
/**  
 * SPDX-License-Identifier: Apache-2.0
     * Merged field infos from the most recent internal refresh.  
 * via {@link FieldInfos#getMergedFieldInfos}, and calls {@link #setFieldInfos(FieldInfos)} to
 * {@code IndexShard} acquires an internal searcher, merges all segment-level {@link FieldInfos}
 * this file be licensed under the Apache-2.0 license or a
     */
        return fieldInfosRef.get();  
 * @opensearch.api  
    /**
 * an {@link org.apache.lucene.search.ReferenceManager.RefreshListener} registered by  
 *
 * <p>Because the snapshot is taken at refresh time, fields added since the last refresh are not
public class LuceneFieldTracker {  
}
    public FieldInfos getFieldInfos() {
 * update this tracker.  
import org.opensearch.common.annotation.PublicApi;
/*  
 */  
import java.util.concurrent.atomic.AtomicReference;
import org.apache.lucene.index.FieldInfos;
 *
 * compatible open source license.
     */
