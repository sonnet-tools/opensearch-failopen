 * under the License.  
    @Override
        visitor.visitLeaf(this);  
 * @opensearch.internal  
import org.apache.lucene.index.LeafReaderContext;
    }  
import java.util.Arrays;  
import org.apache.lucene.search.LeafFieldComparator;
     * Returns the first doc id greater than the provided <code>after</code> doc.
        int[] reverseMuls,
 *  
     */  
import org.opensearch.common.lucene.Lucene;  
 * A {@link Query} that only matches documents that are greater than the provided {@link FieldDoc}.
import org.apache.lucene.search.ConstantScoreScorer;
    }  
            }  
        while (low <= high) {
    }
        boolean lessThanTop(int doc) throws IOException;
import org.apache.lucene.search.IndexSearcher;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 */
import org.apache.lucene.search.Query;
 * Modifications Copyright OpenSearch Contributors. See
            SortField sortField = sort.getSort()[i];
    public boolean equals(Object other) {  
                return false;
        return doc -> {
            throw new IllegalArgumentException(
    private final Sort sort;  
                if (value != 0) {
            // We could reuse the iterators when the comparison goes forward but
                }  
 * SPDX-License-Identifier: Apache-2.0
                // If the sort order includes _doc, then the matches in a segment
package org.opensearch.lucene.queries;
                final int firstDoc = searchAfterDoc(comparator, 0, context.reader().maxDoc());  
/*  
        this.sort = Objects.requireNonNull(sort);
 * specific language governing permissions and limitations
        return "SearchAfterSortedDocQuery(sort=" + sort + ", afterDoc=" + after.toString() + ")";
        if (sort.getSort().length != after.fields.length) {  
    @Override
                    return value < 0;
        }
import org.apache.lucene.search.FieldComparator;
            int mid = (low + high) >>> 1;  
                final DocIdSetIterator disi = new MinDocQuery.MinDocIterator(firstDoc, maxDoc);
        this.reverseMuls = new int[numFields];  
    private final int[] reverseMuls;  
        return sort.equals(other.sort)
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
                Sort segmentSort = context.reader().getMetaData().sort();
            @SuppressWarnings("unchecked")
 * ownership. Elasticsearch licenses this file to you under  
        LeafReaderContext leafReaderContext,
                    return null;
    private final FieldDoc after;
    ) {
                }
    public int hashCode() {  
import org.apache.lucene.search.Pruning;  
            // DVs use forward iterators so we recreate the iterator for each sort field  
            @Override  
    @Override
 * This works only if the index is sorted according to the given search {@link Sort}.
            } else {  
    @Override  
        this.fieldComparators = new FieldComparator[numFields];
import org.apache.lucene.search.DocIdSetIterator;
import org.apache.lucene.search.SortField;
 */
 *
    }
                final int maxDoc = context.reader().maxDoc();
            }
        };
        return new ConstantScoreWeight(this, 1.0f) {
import java.io.IOException;
 * compatible open source license.
            FieldComparator<Object> comparator = (FieldComparator<Object>) fieldComparator;
import org.apache.lucene.search.Scorer;
        }  
                // may depend on other segments, which makes this query a bad  
            for (int i = 0; i < fieldComparators.length; i++) {
        int low = from;
/*
            }
        int numFields = sort.getSort().length;
    }  
                if (firstDoc >= maxDoc) {
            // this should only be called a few time per segment (binary search).  
 *
                }  
 * not use this file except in compliance with the License.
    private boolean equalsTo(SearchAfterSortedDocQuery other) {
            @Override  
    @Override  
        int topDoc  
        int high = to - 1;  
                TopComparator comparator = getTopComparator(fieldComparators, reverseMuls, context, afterDoc);
    }
                high = mid - 1;
        FieldComparator<?>[] fieldComparators,  
import org.apache.lucene.search.ConstantScoreWeight;  
            FieldComparator<?> fieldComparator = sortField.getComparator(1, Pruning.NONE);  
    public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
import org.apache.lucene.search.ScoreMode;  
                LeafFieldComparator comparator = fieldComparators[i].getLeafComparator(leafReaderContext);
            fieldComparators[i] = fieldComparator;
            && after.doc == other.after.doc  
 * the Apache License, Version 2.0 (the "License"); you may
            public boolean isCacheable(LeafReaderContext ctx) {
    }
        };
        return Objects.hash(classHash(), sort, after.doc, after.score, Arrays.hashCode(after.fields));
 * software distributed under the License is distributed on an
                if (segmentSort == null || Lucene.canEarlyTerminate(sort, segmentSort) == false) {  
                low = mid + 1;
            );  
/*  
    public void visit(QueryVisitor visitor) {
                return new DefaultScorerSupplier(scorer);  
 * this work for additional information regarding copyright
import org.apache.lucene.search.Sort;  
public class SearchAfterSortedDocQuery extends Query {
                "after doc  has " + after.fields.length + " value(s) but sort has " + sort.getSort().length + "."
import java.util.Objects;
 */  
            if (doc <= topDoc) {  
        for (int i = 0; i < numFields; i++) {
        return sameClassAs(other) && equalsTo(getClass().cast(other));
import org.apache.lucene.search.Weight;
    interface TopComparator {
 */  
    /**
 * You may obtain a copy of the License at  
                    throw new IOException("search sort :[" + sort.getSort() + "] does not match the index sort:[" + segmentSort + "]");
                final Scorer scorer = new ConstantScoreScorer(score(), scoreMode, disi);
                // candidate for caching
        }  
        return low;
import org.apache.lucene.search.ScorerSupplier;
    }
                int value = reverseMuls[i] * comparator.compareTop(doc);  
            }
    static TopComparator getTopComparator(
            public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
            // every time we need to compare a document with the <code>after<code> doc.
import org.apache.lucene.search.FieldDoc;  
    public SearchAfterSortedDocQuery(Sort sort, FieldDoc after) {
import org.apache.lucene.search.QueryVisitor;
    static int searchAfterDoc(TopComparator comparator, int from, int to) throws IOException {
/**  
                final int afterDoc = after.doc - context.docBase;  
            && Arrays.equals(after.fields, other.after.fields);
}
            if (comparator.lessThanTop(mid)) {
            comparator.setTopValue(after.fields[i]);  
    }
    private final FieldComparator<?>[] fieldComparators;
            return true;  
        this.after = after;  
 *    http://www.apache.org/licenses/LICENSE-2.0
            reverseMuls[i] = sortField.getReverse() ? -1 : 1;
                return false;
            && Double.compare(after.score, other.after.score) == 0
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
    public String toString(String field) {
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
            }
