            }
        // Which hit within the shard:
 *    http://www.apache.org/licenses/LICENSE-2.0
            return tieBreakLessThan(first, firstFD, second, secondFD);
 * Represents hits returned by {@link CollapsingTopDocsCollector#getTopDocs()}.
 *
    /**
        // These are really FieldDoc instances:
    }
        super(totalHits, scoreDocs, sortFields);
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
        ShardRef(int shardIndex) {
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
                final Object collapseValue = shardHits[ref.shardIndex].collapseValues[ref.hitIndex++];
            List<Object> collapseList = new ArrayList<>();
    private static final Comparator<ScoreDoc> DOC_ID_TIE_BREAKER = Comparator.comparingInt(d -> d.doc);
        @Override
                );
    /** Default comparator */
package org.apache.lucene.search.grouping;
        }
                    }
                        throw new IllegalArgumentException("Inconsistent order of shard indices");
     * indices to tie break intra shard ties
                comparators[compIDX] = sortField.getComparator(1, Pruning.NONE);
            final SortField[] sortFields = sort.getSort();
            assert first.hitIndex != second.hitIndex;
import java.util.Set;
     * or all have them as -1 (signifying that all hits belong to same shard)
                // consistent order in shard indices to defend against potential bugs
        MergeSortQueue(Sort sort, CollapseTopFieldDocs[] shardHits) {
    private static final Comparator<ScoreDoc> SHARD_INDEX_TIE_BREAKER = Comparator.comparingInt(d -> d.shardIndex);
                    // Fail gracefully if API is misused:
                }
            int hitUpto = 0;
        boolean unsetShardIndex = false;
 * SPDX-License-Identifier: Apache-2.0
            comparators = new FieldComparator[sortFields.length];
        return value < 0;
        for (int shardIDX = 0; shardIDX < shardHits.length; shardIDX++) {
        final Object[] values;
                        assert gd.fields != null;
                        final ScoreDoc sd = shard[hitIDX];
    private static final class ShardRef {
        final int[] reverseMul;
        int value = DEFAULT_TIE_BREAKER.compare(firstDoc, secondDoc);
            final CollapseTopFieldDocs shard = shardHits[shardIDX];
                throw new IllegalArgumentException(
            Set<Object> seen = new HashSet<>();
     * Use the default tie breaker. If tie breaker returns 0 signifying equal values, we use hit
import java.util.HashSet;
                unsetShardIndex |= hit.shardIndex == -1;
                } else {
import java.util.Comparator;
                    this.shardHits[shardIDX] = shard;
            return "ShardRef(shardIndex=" + shardIndex + " hitIndex=" + hitIndex + ")";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        public boolean lessThan(ShardRef first, ShardRef second) {
                ShardRef ref = queue.top();
}
 * You may obtain a copy of the License at
            values = new Object[0];
                    // Not done with this these TopDocs yet:
            // If any hit count is a lower bound then the merged
import java.util.ArrayList;
        final FieldComparator<?>[] comparators;
        int availHitCount = 0;
 */
    }
                hitUpto++;
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
                reverseMul[compIDX] = sortField.getReverse() ? -1 : 1;
                if (cmp != 0) {
            for (int compIDX = 0; compIDX < sortFields.length; compIDX++) {
            return first.hitIndex < second.hitIndex;
 */
                final ScoreDoc[] shard = shardHits[shardIDX].scoreDocs;
            hits = hitList.toArray(new ScoreDoc[0]);
                    }
    /** The field used for collapsing **/
 */
            // shard had resolved it:
                if (hitUpto > 0) {
        this.collapseValues = values;
            List<ScoreDoc> hitList = new ArrayList<>();
            // Tie break in same shard: resolve however the
/**
import java.util.List;
                        queue.updateTop();
                if (queue.size() == 0) {
        for (int i = 1; i < shardHits.length; i++) {
    }
            totalHitCount += shard.totalHits.value();
        }
            int numIterOnHits = Math.min(availHitCount, requestedResultWindow);
        @Override
     * docIDs are expected to be in consistent pattern i.e. either all ScoreDocs have their shardIndex set,
            if (CollectionUtils.isEmpty(shard.scoreDocs) == false) {
                final FieldComparator comp = comparators[compIDX];
 * The OpenSearch Contributors require contributions made to
            }
            final FieldDoc firstFD = (FieldDoc) shardHits[first.shardIndex][first.hitIndex];
            // collected, when searchAfter was used:
/*
 * ownership. Elasticsearch licenses this file to you under
                        queue.pop();
 */
                    return cmp < 0;
                }
            }
                if (seen.contains(collapseValue)) {
            }
            assert first != second;
            for (int compIDX = 0; compIDX < comparators.length; compIDX++) {
            while (hitUpto < numIterOnHits) {
import org.apache.lucene.search.FieldComparator;
        if (value == 0) {
                final SortField sortField = sortFields[compIDX];
import org.apache.lucene.search.Pruning;
            hits = new ScoreDoc[0];
    public CollapseTopFieldDocs(String field, TotalHits totalHits, ScoreDoc[] scoreDocs, SortField[] sortFields, Object[] values) {
            }
        final ScoreDoc[][] shardHits;
                queue.add(new ShardRef(shardIDX));
            super(shardHits.length);
        }
import org.opensearch.core.common.util.CollectionUtils;
/*
public final class CollapseTopFieldDocs extends TopFieldDocs {
    public final Object[] collapseValues;
    }
 * GitHub history for details.
    static boolean tieBreakLessThan(ShardRef first, ScoreDoc firstDoc, ShardRef second, ScoreDoc secondDoc) {
            values = collapseList.toArray(new Object[0]);
        // Which shard (index into shardHits[]):
        String collapseField = shardHits[0].field;
                }
 *
                    } else {
 * specific language governing permissions and limitations
            int requestedResultWindow = start + size;
                totalHitsRelation = TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO;
 * under the License.
/*
    /** The collapse value for each top doc */
        final int shardIndex;
 * the Apache License, Version 2.0 (the "License"); you may
        }
import org.apache.lucene.search.ScoreDoc;
        final PriorityQueue<ShardRef> queue = new MergeSortQueue(sort, shardHits);
import org.apache.lucene.search.TopFieldDocs;
                    if (unsetShardIndex != (hit.shardIndex == -1)) {
    public static CollapseTopFieldDocs merge(Sort sort, int start, int size, CollapseTopFieldDocs[] shardHits) {
        long totalHitCount = 0;
 * software distributed under the License is distributed on an
    /** Internal comparator with docID */
                final int cmp = reverseMul[compIDX] * comp.compareValues(firstFD.fields[compIDX], secondFD.fields[compIDX]);
                    queue.pop();
        // Returns true if first is < second
        final ScoreDoc[] hits;
            for (int shardIDX = 0; shardIDX < shardHits.length; shardIDX++) {
        TotalHits.Relation totalHitsRelation = TotalHits.Relation.EQUAL_TO;
        }
                }
                if (ref.hitIndex < shardHits[ref.shardIndex].scoreDocs.length) {
import org.apache.lucene.search.SortField;
            final FieldDoc secondFD = (FieldDoc) shardHits[second.shardIndex][second.hitIndex];
    /** Internal comparator with shardIndex */
                availHitCount += shard.scoreDocs.length;
        this.field = field;
                    "collapse field differ across shards [" + collapseField + "] != [" + shardHits[i].field + "]"
                    if (ref.hitIndex < shardHits[ref.shardIndex].scoreDocs.length) {
                    queue.updateTop();
        } else {
                // Irrespective of whether we use shard indices for tie breaking or not, we check for
                    break;
            // total hit count is a lower bound as well
                }
            }
            // totalHits can be non-zero even if no hits were
 * Licensed to Elasticsearch under one or more contributor
    // Refers to one hit:
            if (shard.totalHits.relation() == TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO) {
                    collapseList.add(collapseValue);
                }
        int hitIndex;
        public String toString() {
 *
            this.shardIndex = shardIndex;
                seen.add(collapseValue);
                    for (int hitIDX = 0; hitIDX < shard.length; hitIDX++) {
            // Equal Values
     */
    private static final Comparator<ScoreDoc> DEFAULT_TIE_BREAKER = SHARD_INDEX_TIE_BREAKER.thenComparing(DOC_ID_TIE_BREAKER);
                if (hitUpto >= start) {
        TotalHits totalHits = new TotalHits(totalHitCount, totalHitsRelation);
        }
     * Returns a new CollapseTopDocs, containing topN collapsed results across
        return new CollapseTopFieldDocs(collapseField, totalHits, hits, sort.getSort(), values);
import org.apache.lucene.search.TotalHits;
    public final String field;
    /**
     * the provided CollapseTopDocs, sorting by score. Each {@link CollapseTopFieldDocs} instance must be sorted.
import org.apache.lucene.search.FieldDoc;
            this.shardHits = new ScoreDoc[shardHits.length][];
                final ScoreDoc hit = shardHits[ref.shardIndex].scoreDocs[ref.hitIndex];
            reverseMul = new int[sortFields.length];
        }
import org.apache.lucene.search.Sort;
            }
        if (availHitCount <= start) {
     **/
                        final FieldDoc gd = (FieldDoc) sd;
                if (shard != null) {
 * this file be licensed under the Apache-2.0 license or a
            if (collapseField.equals(shardHits[i].field) == false) {
                    continue;
    }
                }
        }
import org.apache.lucene.util.PriorityQueue;
                    }
 * not use this file except in compliance with the License.
    private static class MergeSortQueue extends PriorityQueue<ShardRef> {
                    hitList.add(hit);
