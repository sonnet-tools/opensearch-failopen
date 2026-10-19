import org.apache.lucene.search.Query;
                if (value != 0) {
/*
                return false;
            @Override
        for (int i = 0; i < numFields; i++) {
        }
        this.reverseMuls = new int[numFields];
        if (sort.getSort().length != after.fields.length) {
            fieldComparators[i] = fieldComparator;
 * The OpenSearch Contributors require contributions made to
import org.apache.lucene.index.LeafReaderContext;
                if (firstDoc >= maxDoc) {
 * software distributed under the License is distributed on an
 * compatible open source license.
    private final Sort sort;
        return sort.equals(other.sort)
    public int hashCode() {
 * this work for additional information regarding copyright
 * This works only if the index is sorted according to the given search {@link Sort}.
        while (low <= high) {
        }
                TopComparator comparator = getTopComparator(fieldComparators, reverseMuls, context, afterDoc);
                final int maxDoc = context.reader().maxDoc();
 * license agreements. See the NOTICE file distributed with
        return doc -> {
 * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
    interface TopComparator {
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under
 * KIND, either express or implied.  See the License for the
}
/**
            @Override
import org.apache.lucene.search.ScoreMode;
import org.apache.lucene.search.Pruning;
        return low;
            for (int i = 0; i < fieldComparators.length; i++) {
                final Scorer scorer = new ConstantScoreScorer(score(), scoreMode, disi);
     * Returns the first doc id greater than the provided <code>after</code> doc.
        boolean lessThanTop(int doc) throws IOException;
        };
    private final FieldComparator<?>[] fieldComparators;
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
            public boolean isCacheable(LeafReaderContext ctx) {
        return "SearchAfterSortedDocQuery(sort=" + sort + ", afterDoc=" + after.toString() + ")";
package org.opensearch.lucene.queries;
 * GitHub history for details.
        this.after = after;
                Sort segmentSort = context.reader().getMetaData().sort();
                    throw new IOException("search sort :[" + sort.getSort() + "] does not match the index sort:[" + segmentSort + "]");
            }
                if (segmentSort == null || Lucene.canEarlyTerminate(sort, segmentSort) == false) {
                final DocIdSetIterator disi = new MinDocQuery.MinDocIterator(firstDoc, maxDoc);
            }
import org.apache.lucene.search.ConstantScoreWeight;
        int numFields = sort.getSort().length;
                low = mid + 1;
            throw new IllegalArgumentException(
    }
            && after.doc == other.after.doc
    }
    }
    public String toString(String field) {
                return new DefaultScorerSupplier(scorer);
            // DVs use forward iterators so we recreate the iterator for each sort field
            if (doc <= topDoc) {
import org.apache.lucene.search.SortField;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                return false;
            comparator.setTopValue(after.fields[i]);
                // If the sort order includes _doc, then the matches in a segment
            // this should only be called a few time per segment (binary search).
    static int searchAfterDoc(TopComparator comparator, int from, int to) throws IOException {
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.common.lucene.Lucene;
import org.apache.lucene.search.FieldDoc;
import org.apache.lucene.search.ScorerSupplier;
            int mid = (low + high) >>> 1;
            if (comparator.lessThanTop(mid)) {
import java.io.IOException;
    @Override
                "after doc  has " + after.fields.length + " value(s) but sort has " + sort.getSort().length + "."
        this.sort = Objects.requireNonNull(sort);
import org.apache.lucene.search.ConstantScoreScorer;
            @SuppressWarnings("unchecked")
    }
import java.util.Objects;
    public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
                final int afterDoc = after.doc - context.docBase;
                    return value < 0;
            }
            );
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.Weight;
 *
        };
    ) {
    private final int[] reverseMuls;
            }
 */
        return sameClassAs(other) && equalsTo(getClass().cast(other));
                int value = reverseMuls[i] * comparator.compareTop(doc);
                    return null;
 */
        LeafReaderContext leafReaderContext,
 */
        int high = to - 1;
            public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
    @Override
import org.apache.lucene.search.QueryVisitor;
                // candidate for caching
    /**
import org.apache.lucene.search.DocIdSetIterator;
 * Unless required by applicable law or agreed to in writing,
            // We could reuse the iterators when the comparison goes forward but
            && Arrays.equals(after.fields, other.after.fields);
     */
        return new ConstantScoreWeight(this, 1.0f) {
    public void visit(QueryVisitor visitor) {
            }
                LeafFieldComparator comparator = fieldComparators[i].getLeafComparator(leafReaderContext);
    private boolean equalsTo(SearchAfterSortedDocQuery other) {
            reverseMuls[i] = sortField.getReverse() ? -1 : 1;
 * under the License.
        int[] reverseMuls,
    }
 */
import org.apache.lucene.search.FieldComparator;
                final int firstDoc = searchAfterDoc(comparator, 0, context.reader().maxDoc());
            FieldComparator<Object> comparator = (FieldComparator<Object>) fieldComparator;
    public SearchAfterSortedDocQuery(Sort sort, FieldDoc after) {
        this.fieldComparators = new FieldComparator[numFields];
import org.apache.lucene.search.IndexSearcher;
    static TopComparator getTopComparator(
 * Modifications Copyright OpenSearch Contributors. See
                high = mid - 1;
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Arrays;
 * A {@link Query} that only matches documents that are greater than the provided {@link FieldDoc}.
/*
    @Override
    @Override
    }
/*
            && Double.compare(after.score, other.after.score) == 0
        FieldComparator<?>[] fieldComparators,
            SortField sortField = sort.getSort()[i];
            FieldComparator<?> fieldComparator = sortField.getComparator(1, Pruning.NONE);
                }
            // every time we need to compare a document with the <code>after<code> doc.
        int low = from;
        }
public class SearchAfterSortedDocQuery extends Query {
                }
import org.apache.lucene.search.LeafFieldComparator;
            return true;
        int topDoc
 *
        visitor.visitLeaf(this);
    }
    }
 * this file be licensed under the Apache-2.0 license or a
    private final FieldDoc after;
            } else {
                // may depend on other segments, which makes this query a bad
import org.apache.lucene.search.Scorer;
                }
        return Objects.hash(classHash(), sort, after.doc, after.score, Arrays.hashCode(after.fields));
    public boolean equals(Object other) {
 * not use this file except in compliance with the License.
    @Override
 * You may obtain a copy of the License at
