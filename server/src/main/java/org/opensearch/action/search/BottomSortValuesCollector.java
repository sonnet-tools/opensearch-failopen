        return true;  
    }  
            if (shardSortFields[i].equals(sortFields[i]) == false) {  
 * Utility class to keep track of the bottom doc's sort values in a distributed search.
    /**
        if (validateShardSortFields(topDocs.fields) == false) {
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
    SearchSortValuesAndFormats getBottomSortValues() {
    }
 * KIND, either express or implied.  See the License for the
class BottomSortValuesCollector {
     */
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
                return cmp;
        return bottomSortValues;  
            }  
        FieldDoc shardBottomDoc = extractBottom(topDocs);  
            }
    long getTotalHits() {
        return totalHits;
import org.opensearch.search.SearchSortValuesAndFormats;
    private final int topNSize;  
 * GitHub history for details.
package org.opensearch.action.search;
    private final int[] reverseMuls;  
 * this work for additional information regarding copyright
        totalHits += topDocs.totalHits.value();
        for (int i = 0; i < sortFields.length; i++) {
 * software distributed under the License is distributed on an
 */
/**  
    private boolean validateShardSortFields(SortField[] shardSortFields) {
     */  
        }
                // TODO: we should fail the entire request because the topdocs  
    private final SortField[] sortFields;
        }
 * under the License.  
        return 0;
    synchronized void consumeTopDocs(TopFieldDocs topDocs, DocValueFormat[] sortValuesFormat) {  
    }
        this.comparators = new FieldComparator[sortFields.length];
 * compatible open source license.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
        for (int i = 0; i < shardSortFields.length; i++) {
                return false;  
/*  
import org.apache.lucene.search.SortField;
 * SPDX-License-Identifier: Apache-2.0
    /**  
    }
import org.apache.lucene.search.TopFieldDocs;
            reverseMuls[i] = sortFields[i].getReverse() ? -1 : 1;  
    }
    }
        }
import org.apache.lucene.search.FieldComparator;
 * @opensearch.internal  
            return;
    private volatile long totalHits;
    BottomSortValuesCollector(int topNSize, SortField[] sortFields) {
 *
        if (bottomSortValues == null || compareValues(shardBottomDoc.fields, bottomSortValues.getRawSortValues()) < 0) {
 */  
        this.topNSize = topNSize;  
import org.apache.lucene.search.FieldDoc;
 */  
 *
            bottomSortValues = new SearchSortValuesAndFormats(shardBottomDoc.fields, sortValuesFormat);
                // (e.g.: mixing keyword/numeric or long/double).
}
 * not use this file except in compliance with the License.
    private FieldDoc extractBottom(TopFieldDocs topDocs) {  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.DocValueFormat;  
     * @return The best bottom sort values consumed so far.  
 *  
            return;  
 * license agreements. See the NOTICE file distributed with
                // merge will likely fail later but this is not possible with
     * @return <code>false</code> if the provided {@link SortField} array differs
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
            int cmp = reverseMuls[i] * comparators[i].compareValues(v1[i], v2[i]);  
        if (shardBottomDoc == null) {
        }  
/*  
        }  
     * from the initial {@link BottomSortValuesCollector#sortFields}.
    private final FieldComparator[] comparators;
        return topNSize > 0 && topDocs.scoreDocs.length == topNSize ? (FieldDoc) topDocs.scoreDocs[topNSize - 1] : null;
    }  
        }
                // the current async logic that only allows shard failures here.
    private int compareValues(Object[] v1, Object[] v2) {
import org.apache.lucene.search.Pruning;  
        this.reverseMuls = new int[sortFields.length];
    private volatile SearchSortValuesAndFormats bottomSortValues;  
                // ignore shards response that would make the sort incompatible
            comparators[i] = sortFields[i].getComparator(1, Pruning.NONE);
/*
        for (int i = 0; i < v1.length; i++) {
 */
            if (cmp != 0) {
        this.sortFields = sortFields;  
