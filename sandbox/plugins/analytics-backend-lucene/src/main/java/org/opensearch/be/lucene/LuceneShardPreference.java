}
    @Override  
 */
 *
/**
    private static final int COUNT_FAST_PATH_SCORE = 100;
    }
 */  
        if (ctx.preferMetadataDriver() == false) return OptionalInt.empty();
 * <p>Today the only signal is the cluster setting + fragment shape. Future shard-local
package org.opensearch.be.lucene;
import org.opensearch.analytics.spi.BackendShardPreference;
 * SPDX-License-Identifier: Apache-2.0
import java.util.OptionalInt;
    /** Veto score — actively don't pick this plan. Lucene returns this when the fragment
     *  Lucene alternative just because it appeared first in PlanForker order. */  
 *
 * @opensearch.internal  
        if (LuceneFragmentConvertor.isCountFastPath(fragment) == false) {  
 * {@link ShardPreferenceContext} grows.
import org.opensearch.analytics.spi.ShardPreferenceContext;  
     *  isn't a count-fast-path so the selector doesn't accidentally collapse to a non-drivable
            return OptionalInt.of(NOT_DRIVABLE_SCORE);
    private static final int NOT_DRIVABLE_SCORE = -1;
final class LuceneShardPreference implements BackendShardPreference {
import org.apache.calcite.rel.RelNode;
    public OptionalInt scoreFor(RelNode fragment, ShardPreferenceContext ctx) {
 * Lucene's per-shard preference: opt in to drive count-fast-path fragments when the user has
/*  
 * inputs (deletes, segment count, query-cache warmth) plug into the same scoring function as  
        }
        return OptionalInt.of(COUNT_FAST_PATH_SCORE);  
 * compatible open source license.
    /** Wants-to-drive score — beats generic alternatives (score 0). */
 *
 * The OpenSearch Contributors require contributions made to  
 * enabled {@code analytics.planner.prefer_metadata_driver}.  
 * this file be licensed under the Apache-2.0 license or a
