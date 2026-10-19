            }  
 */  
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.util.BytesRef;  
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
    /**
package org.opensearch.search.slice;
            int hashCode = StringHelper.murmurhash3_x86_32(term, SEED);  
        PostingsEnum docsEnum = null;
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
public final class TermsSliceQuery extends SliceQuery {
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
import org.apache.lucene.index.LeafReader;
 * specific language governing permissions and limitations
 *
/*  
        };
                builder.add(docsEnum);  
import org.apache.lucene.search.Scorer;  
/**  
 * A {@link SliceQuery} that uses the terms dictionary of a field to do the slicing.
            return DocIdSet.EMPTY;
import org.apache.lucene.util.StringHelper;
}
import org.apache.lucene.search.ScorerSupplier;
 * <b>NOTE</b>: The cost of this filter is O(N*M) where N is the number of unique terms in the dictionary  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private DocIdSet build(LeafReader reader) throws IOException {
 * <p>
        return builder.build();  
    }
/*
import org.apache.lucene.index.Terms;
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.lucene.search.DocIdSetIterator;  
        final DocIdSetBuilder builder = new DocIdSetBuilder(reader.maxDoc());
    public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
 * <b>NOTE</b>: Documents with no value for that field are ignored.
import org.apache.lucene.search.IndexSearcher;
            public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
 *
 * compatible open source license.
            }
import org.apache.lucene.search.ScoreMode;
 */
 */
        for (BytesRef term = te.next(); term != null; term = te.next()) {  
                final Scorer scorer = new ConstantScoreScorer(score(), scoreMode, leafIt);
 * For each segment this filter enumerates the terms dictionary, computes the hash code for each term and fills
    }
                return new DefaultScorerSupplier(scorer);  
import org.apache.lucene.index.LeafReaderContext;
    public static final int SEED = 7919;
import org.apache.lucene.index.PostingsEnum;  
        }  
import java.io.IOException;
            }
            // running on another replica (StringHelper sets its default seed at startup with current time)
        if (terms == null) {
            // use a fixed seed instead of term.hashCode() otherwise this query may return inconsistent results when
import org.apache.lucene.search.DocIdSet;
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.search.ConstantScoreWeight;
            @Override  
        super(field, id, max);
 * @opensearch.internal  
    }
/*  
import org.apache.lucene.search.ConstantScoreScorer;  
        final Terms terms = reader.terms(getField());  
 * and M is the average number of documents per term.
    public TermsSliceQuery(String field, int id, int max) {  
 */  
    // Fixed seed for computing term hashCode  
        return new ConstantScoreWeight(this, boost) {  
 * this file be licensed under the Apache-2.0 license or a
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.util.DocIdSetBuilder;
 * a bit set with the documents of all terms whose hash code matches the predicate.  
            public boolean isCacheable(LeafReaderContext ctx) {
     */  
import org.apache.lucene.search.Weight;
 *
 * KIND, either express or implied.  See the License for the
                docsEnum = te.postings(docsEnum, PostingsEnum.NONE);
     * Returns a DocIdSet per segments containing the matching docs for the specified slice.
        final TermsEnum te = terms.iterator();
 * this work for additional information regarding copyright
                final DocIdSetIterator leafIt = disi.iterator();
            if (contains(hashCode)) {
                final DocIdSet disi = build(context.reader());  
                return true;
import org.apache.lucene.index.TermsEnum;
            @Override
        }
    @Override
