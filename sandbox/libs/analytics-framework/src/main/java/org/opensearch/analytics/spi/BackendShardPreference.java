 * group-set with COUNT-only calls), Lucene returns a positive score. Otherwise empty.
 */  
 *   <li>Deleted-doc routing — Lucene gets {@code liveDocs} masking for free; DataFusion  
 * @opensearch.internal
 * <p>The context surface (today: just {@code preferMetadataDriver}) grows as new consumers
 * is fine being treated as a generic alternative. The selector falls back to value-producing
 *       wins on cache hits; DataFusion's columnar scan wins on cold cache.</li>  
 *
     * Score this backend's preference for executing {@code fragment} on the current shard.
 *  
/**
 * </ul>  
 * <h2>Future consumers</h2>
    OptionalInt scoreFor(RelNode fragment, ShardPreferenceContext ctx);  
}
    /**  
     */
 * backend can declare a preference score given the fragment shape and shard-local context.
 * <h2>Today's only consumer</h2>
import org.apache.calcite.rel.RelNode;
 * SPDX-License-Identifier: Apache-2.0
     *  
 *  
 * The OpenSearch Contributors require contributions made to  
 *       needs explicit pushdown. When the shard has deletes, prefer Lucene.</li>
 */  
public interface BackendShardPreference {
 *
     * Higher = stronger preference.
 *       DataFusion's vectorized batching.</li>
 * <p>Lucene's count-fast-path: when {@link ShardPreferenceContext#preferMetadataDriver()} is  
     * @return preference score, or empty for "no opinion / not applicable"
 * on AND the resolved fragment is a count Lucene can drive end-to-end (Aggregate over empty
/*  
 * {@code BackendShardPreference} when the same fragment has multiple viable backends, so the
 * this file be licensed under the Apache-2.0 license or a
 *   <li>Segment count — single-segment shards favor Lucene; many small segments favor
package org.opensearch.analytics.spi;
 * backends in tie / no-opinion situations.  
 *   <li>Cache warmth — when the OpenSearch query cache is hot for the predicate, Lucene
 * <ul>
import java.util.OptionalInt;  
 * compatible open source license.
 * land; backends only need fields they actually use.  
 * Per-shard backend selection hint. The planner consults a backend's  
 * <p>Higher scores win. Returning {@link OptionalInt#empty()} means "no opinion" — the backend
 *
 *
