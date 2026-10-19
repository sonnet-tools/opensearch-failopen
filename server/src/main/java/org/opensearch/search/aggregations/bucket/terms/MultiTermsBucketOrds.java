/*  
 * compatible open source license.
    interface BucketOrdsEnum {
public interface MultiTermsBucketOrds extends Releasable {
    /**  
    }
        /** The ordinal of the current bucket. */  
    BucketOrdsEnum ordsEnum(long owningBucketOrd);
    /**  
 * @opensearch.internal
}  
 */  
    long add(long owningBucketOrd, long[] ordinals);
        long ord();
    /** The number of collected buckets. */  
 * The OpenSearch Contributors require contributions made to  
    /**  
     */
/**  
     * or {@code -1-ord} if the tuple was already present.
 * Maps composite ordinal tuples to bucket ordinals for multi-terms aggregation.
     * The iterator is unpositioned; call {@link BucketOrdsEnum#next()} first.
 * instead of serialized BytesRef composite keys.  
        boolean next();
     * An iterator for buckets inside a particular {@code owningBucketOrd}.
    /** Count the buckets in {@code owningBucketOrd}. */  
    long bucketsInOrd(long owningBucketOrd);
 *
    long size();
import org.opensearch.common.lease.Releasable;
     * Add the {@code owningBucketOrd, ordinals} tuple. Returns the new bucket ord,
     * Build an iterator for buckets inside {@code owningBucketOrd}.
        long[] ordinals();
 * SPDX-License-Identifier: Apache-2.0
 * Used when all fields support global ordinals, enabling packed ordinal storage
package org.opensearch.search.aggregations.bucket.terms;
     */  
 *
     */  
     *
        /** The ordinal tuple for the current bucket. */  
     * @opensearch.internal  
 * this file be licensed under the Apache-2.0 license or a
        /** Advance to the next bucket. Returns {@code false} when exhausted. */  
 */  
