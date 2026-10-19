            for (PackedLongValues.Iterator itr = sourceEntry.buckets.iterator(); itr.hasNext();) {
    }
    /**  
            PackedLongValues.Iterator docDeltasItr = sourceEntry.docDeltas.iterator();
public class MergingBucketsDeferringCollector extends BestBucketsDeferringCollector {
            }  
 */
            if (newBuckets.size() > 0) {  
                    newBuckets.add(ordinal);  
                long bucket = itr.next();
                long bucket = itr.next();  
 *
            bucketsBuilder = newBuckets;  
            // Only create an entry if this segment has buckets after merging
     *
     * </ul>
        }
     * the value is set to -1 it is removed entirely.  
     * <p>
     * not be called unless there are actually changes to be made, to avoid unnecessary work.
 * under the License.  
                    newBuckets.add(ordinal);
     * <ul>  
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
        for (Entry sourceEntry : entries) {
     *  <li> Bucket `3` will be removed entirely</li>  
        if (bucketsBuilder != null && bucketsBuilder.size() > 0) {  
        // we need to update the bucket ordinals there too
/*
     *  not be called unless there are actually changes to be made, to avoid unnecessary work.  
                    lastGoodDelta = 0;
                newEntries.add(new Entry(sourceEntry.context, newDocDeltas.build(), newBuckets.build()));
     *  <li> Buckets `0` and `1` will be merged to bucket ordinal `1`</li>
            PackedLongValues currentBuckets = bucketsBuilder.build();
    public void mergeBuckets(LongUnaryOperator mergeMap) {  
                    lastGoodDelta = 0;
        mergeBuckets(bucket -> mergeMap[Math.toIntExact(bucket)]);  
/*  
     * <p>
 * @opensearch.internal  
     * Merges/prunes the existing bucket ordinals and docDeltas according to the provided mergeMap.
 */  
                assert docDeltasItr.hasNext();  
 * not use this file except in compliance with the License.
     * @deprecated use {@link mergeBuckets(LongUnaryOperator)}
    /**
 * Licensed to Elasticsearch under one or more contributor  
        // if there are buckets that have been collected in the current segment
        entries = newEntries;
     *  This process rebuilds the ordinals and docDeltas according to the mergeMap, so it should
            // The current segment's deltas aren't built yet, so build to a temp object
     * The mergeMap is an array where the index position represents the current bucket ordinal, and
 * SPDX-License-Identifier: Apache-2.0
            }
 * matches and then is able to replay a given subset of buckets. Exposes
import org.apache.lucene.util.packed.PackedLongValues;
                }  
                    // not offsets from 0
                    newDocDeltas.add(delta + lastGoodDelta);  
/**  
            PackedLongValues currentDeltas = docDeltasBuilder.build();  
                if (ordinal != -1) {
                // Only merge in the ordinal if it hasn't been "removed", signified with -1
 */
    }
}  
                    // we are skipping this ordinal, which means we need to accumulate the  
            long lastGoodDelta = 0;  
 *
                    newDocDeltas.add(delta + lastGoodDelta);
                } else {
    }
 * The OpenSearch Contributors require contributions made to  
                    lastGoodDelta += delta;
        }
     * <p>  
            }
 *  
                    // The first is skipped because the original deltas are stored as offsets from first doc,  
                // Only merge in the ordinal if it hasn't been "removed", signified with -1
                }  
 * ownership. Elasticsearch licenses this file to you under  
/*  
    @Deprecated
 * Modifications Copyright OpenSearch Contributors. See
 * mergeBuckets, which can be invoked by the aggregator when increasing the  
                    lastGoodDelta += delta;
 * Unless required by applicable law or agreed to in writing,
                    // doc delta's since the last "good" delta.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * This process rebuilds the ordinals and docDeltas according to the mergeMap, so it should  
    public void mergeBuckets(long[] mergeMap) {
                long delta = docDeltasItr.next();
                } else {  
 * rounding interval.
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
                    // doc delta's since the last "good" delta
            for (PackedLongValues.Iterator itr = currentBuckets.iterator(); itr.hasNext();) {
     */  
     * If a bucket's ordinal is mapped to -1 then the bucket is removed entirely.
                long ordinal = mergeMap.applyAsLong(bucket);
                assert newDocDeltas.size() > 0 : "docDeltas was empty but we had buckets";
                long ordinal = mergeMap.applyAsLong(bucket);
 * compatible open source license.
import java.util.List;  
     *  <li> Bucket `2` and `4` will be merged to ordinal `3`</li>
                assert docDeltasItr.hasNext();
            PackedLongValues.Builder newDocDeltas = PackedLongValues.packedBuilder(PackedInts.DEFAULT);
        super(context, isGlobal);
     * For example, if the mergeMap [1,1,3,-1,3] is provided:
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
     *
     * @param mergeMap a unary operator which maps a bucket's ordinal to the ordinal it should be merged with.  
                    // we are skipping this ordinal, which means we need to accumulate the
     * Merges/prunes the existing bucket ordinals and docDeltas according to the provided mergeMap.
            PackedLongValues.Builder newBuckets = PackedLongValues.packedBuilder(PackedInts.DEFAULT);
import org.opensearch.search.internal.SearchContext;  
        List<Entry> newEntries = new ArrayList<>(entries.size());
package org.opensearch.search.aggregations.bucket;
import java.util.function.LongUnaryOperator;
            PackedLongValues.Iterator docDeltasItr = currentDeltas.iterator();
            docDeltasBuilder = newDocDeltas;
 * A specialization of {@link BestBucketsDeferringCollector} that collects all
            PackedLongValues.Builder newDocDeltas = PackedLongValues.packedBuilder(PackedInts.DEFAULT);  
    public MergingBucketsDeferringCollector(SearchContext context, boolean isGlobal) {  
            long lastGoodDelta = 0;
                if (ordinal != -1) {
import java.util.ArrayList;
                long delta = docDeltasItr.next();
 * license agreements. See the NOTICE file distributed with
 *
     * the value at that position represents the ordinal the bucket should be merged with.  If
import org.apache.lucene.util.packed.PackedInts;
 * the Apache License, Version 2.0 (the "License"); you may
     */
 */  
            PackedLongValues.Builder newBuckets = PackedLongValues.packedBuilder(PackedInts.DEFAULT);  
 * KIND, either express or implied.  See the License for the
