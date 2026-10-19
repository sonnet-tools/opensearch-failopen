        int value = DEFAULT_TIE_BREAKER.compare(firstDoc, secondDoc);  
                    }
    static boolean tieBreakLessThan(ShardRef first, ScoreDoc firstDoc, ShardRef second, ScoreDoc secondDoc) {
        TotalHits.Relation totalHitsRelation = TotalHits.Relation.EQUAL_TO;  
import java.util.HashSet;
    /** Internal comparator with docID */
                availHitCount += shard.scoreDocs.length;  
            assert first.hitIndex != second.hitIndex;  
            }
 * not use this file except in compliance with the License.
            final FieldDoc secondFD = (FieldDoc) shardHits[second.shardIndex][second.hitIndex];
     */
                    this.shardHits[shardIDX] = shard;
            assert first != second;  
import java.util.Set;  
public final class CollapseTopFieldDocs extends TopFieldDocs {
        final int shardIndex;
            if (shard.totalHits.relation() == TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO) {
        // These are really FieldDoc instances:
    // Refers to one hit:
                    return cmp < 0;
        } else {
                }
 *    http://www.apache.org/licenses/LICENSE-2.0
    private static final Comparator<ScoreDoc> DOC_ID_TIE_BREAKER = Comparator.comparingInt(d -> d.doc);
        final Object[] values;  
 * GitHub history for details.
import java.util.ArrayList;
            }  
            }  
        final ScoreDoc[] hits;
            return first.hitIndex < second.hitIndex;
            values = new Object[0];
        super(totalHits, scoreDocs, sortFields);
            // collected, when searchAfter was used:
                    collapseList.add(collapseValue);  
/*  
            final SortField[] sortFields = sort.getSort();
                } else {
import org.opensearch.core.common.util.CollectionUtils;  
        return new CollapseTopFieldDocs(collapseField, totalHits, hits, sort.getSort(), values);
        }
            // Equal Values  
        public String toString() {
    /** Default comparator */
            // Tie break in same shard: resolve however the
        TotalHits totalHits = new TotalHits(totalHitCount, totalHitsRelation);  
    private static final Comparator<ScoreDoc> SHARD_INDEX_TIE_BREAKER = Comparator.comparingInt(d -> d.shardIndex);
                    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                comparators[compIDX] = sortField.getComparator(1, Pruning.NONE);
import org.apache.lucene.search.ScoreDoc;  
import org.apache.lucene.search.TopFieldDocs;  
            // If any hit count is a lower bound then the merged  
 */
            comparators = new FieldComparator[sortFields.length];  
                queue.add(new ShardRef(shardIDX));
                }
            this.shardHits = new ScoreDoc[shardHits.length][];  
        final FieldComparator<?>[] comparators;
        this.field = field;  
                reverseMul[compIDX] = sortField.getReverse() ? -1 : 1;
    private static class MergeSortQueue extends PriorityQueue<ShardRef> {
    }
    public final Object[] collapseValues;  
 * this file be licensed under the Apache-2.0 license or a
            if (CollectionUtils.isEmpty(shard.scoreDocs) == false) {
                }
                    break;
        }  
        }
                        queue.updateTop();  
                hitUpto++;  
        // Which hit within the shard:  
            return "ShardRef(shardIndex=" + shardIndex + " hitIndex=" + hitIndex + ")";  
                final ScoreDoc[] shard = shardHits[shardIDX].scoreDocs;
 * software distributed under the License is distributed on an
                    continue;
     * docIDs are expected to be in consistent pattern i.e. either all ScoreDocs have their shardIndex set,
        // Returns true if first is < second  
            // totalHits can be non-zero even if no hits were  
package org.apache.lucene.search.grouping;
            hits = new ScoreDoc[0];  
/*
}  
        public boolean lessThan(ShardRef first, ShardRef second) {
            }
    /**
        @Override
            hits = hitList.toArray(new ScoreDoc[0]);  
                if (seen.contains(collapseValue)) {
            List<Object> collapseList = new ArrayList<>();
            for (int shardIDX = 0; shardIDX < shardHits.length; shardIDX++) {
                        queue.pop();
                    for (int hitIDX = 0; hitIDX < shard.length; hitIDX++) {  
                );
            for (int compIDX = 0; compIDX < sortFields.length; compIDX++) {
                    hitList.add(hit);
                if (shard != null) {  
    /**
                        throw new IllegalArgumentException("Inconsistent order of shard indices");
    /** The collapse value for each top doc */
 * compatible open source license.
            return tieBreakLessThan(first, firstFD, second, secondFD);
                }
                    if (ref.hitIndex < shardHits[ref.shardIndex].scoreDocs.length) {
        boolean unsetShardIndex = false;
     * the provided CollapseTopDocs, sorting by score. Each {@link CollapseTopFieldDocs} instance must be sorted.
            if (collapseField.equals(shardHits[i].field) == false) {
 * this work for additional information regarding copyright
        if (availHitCount <= start) {
import java.util.Comparator;  
                if (cmp != 0) {  
    public CollapseTopFieldDocs(String field, TotalHits totalHits, ScoreDoc[] scoreDocs, SortField[] sortFields, Object[] values) {
 */
    /** Internal comparator with shardIndex */
                if (hitUpto >= start) {
        }
        int hitIndex;
import org.apache.lucene.search.FieldComparator;  
    }
        return value < 0;
        final PriorityQueue<ShardRef> queue = new MergeSortQueue(sort, shardHits);
 */  
            this.shardIndex = shardIndex;
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
import java.util.List;
        for (int i = 1; i < shardHits.length; i++) {
            int numIterOnHits = Math.min(availHitCount, requestedResultWindow);  
                totalHitsRelation = TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO;  
 * The OpenSearch Contributors require contributions made to  
                if (ref.hitIndex < shardHits[ref.shardIndex].scoreDocs.length) {
     * or all have them as -1 (signifying that all hits belong to same shard)  
                // consistent order in shard indices to defend against potential bugs
        MergeSortQueue(Sort sort, CollapseTopFieldDocs[] shardHits) {
            // total hit count is a lower bound as well
        @Override
        }
        final ScoreDoc[][] shardHits;  
        if (value == 0) {
                final SortField sortField = sortFields[compIDX];  
                        final FieldDoc gd = (FieldDoc) sd;
    /** The field used for collapsing **/  
        }
 * specific language governing permissions and limitations
            super(shardHits.length);
     * Returns a new CollapseTopDocs, containing topN collapsed results across  
 * license agreements. See the NOTICE file distributed with
/**
        // Which shard (index into shardHits[]):  
            int hitUpto = 0;
                throw new IllegalArgumentException(  
    public static CollapseTopFieldDocs merge(Sort sort, int start, int size, CollapseTopFieldDocs[] shardHits) {
 *
                final FieldComparator comp = comparators[compIDX];
            }  
                    } else {
            reverseMul = new int[sortFields.length];
    }  
                }
                // Irrespective of whether we use shard indices for tie breaking or not, we check for
        long totalHitCount = 0;
                    // Fail gracefully if API is misused:
            final FieldDoc firstFD = (FieldDoc) shardHits[first.shardIndex][first.hitIndex];
        int availHitCount = 0;
                unsetShardIndex |= hit.shardIndex == -1;
 *  
            }  
        }
                ShardRef ref = queue.top();
 * Modifications Copyright OpenSearch Contributors. See  
                    if (unsetShardIndex != (hit.shardIndex == -1)) {
import org.apache.lucene.search.TotalHits;
     **/
                final ScoreDoc hit = shardHits[ref.shardIndex].scoreDocs[ref.hitIndex];
 * SPDX-License-Identifier: Apache-2.0
                    queue.updateTop();
 * Represents hits returned by {@link CollapsingTopDocsCollector#getTopDocs()}.  
        }
 * KIND, either express or implied.  See the License for the
                        final ScoreDoc sd = shard[hitIDX];
                if (queue.size() == 0) {
 */
import org.apache.lucene.util.PriorityQueue;
                }  
        final int[] reverseMul;
     * indices to tie break intra shard ties  
            }
                final Object collapseValue = shardHits[ref.shardIndex].collapseValues[ref.hitIndex++];  
        for (int shardIDX = 0; shardIDX < shardHits.length; shardIDX++) {
                seen.add(collapseValue);  
                    "collapse field differ across shards [" + collapseField + "] != [" + shardHits[i].field + "]"
            while (hitUpto < numIterOnHits) {  
            totalHitCount += shard.totalHits.value();
 * Licensed to Elasticsearch under one or more contributor  
            for (int compIDX = 0; compIDX < comparators.length; compIDX++) {
    private static final Comparator<ScoreDoc> DEFAULT_TIE_BREAKER = SHARD_INDEX_TIE_BREAKER.thenComparing(DOC_ID_TIE_BREAKER);
/*
            Set<Object> seen = new HashSet<>();
            final CollapseTopFieldDocs shard = shardHits[shardIDX];
                    }  
 * Unless required by applicable law or agreed to in writing,
    public final String field;
                }
            List<ScoreDoc> hitList = new ArrayList<>();  
 * the Apache License, Version 2.0 (the "License"); you may
     * Use the default tie breaker. If tie breaker returns 0 signifying equal values, we use hit
            // shard had resolved it:
            values = collapseList.toArray(new Object[0]);
    private static final class ShardRef {
import org.apache.lucene.search.SortField;
 * under the License.  
            int requestedResultWindow = start + size;
                    queue.pop();  
 *
    }
import org.apache.lucene.search.Pruning;
                if (hitUpto > 0) {  
import org.apache.lucene.search.Sort;
                        assert gd.fields != null;  
import org.apache.lucene.search.FieldDoc;
        this.collapseValues = values;
                final int cmp = reverseMul[compIDX] * comp.compareValues(firstFD.fields[compIDX], secondFD.fields[compIDX]);
    }
        ShardRef(int shardIndex) {  
        String collapseField = shardHits[0].field;  
                    // Not done with this these TopDocs yet:  
