    public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.search.Weight;  
    }
    public DocValuesSliceQuery(String field, int id, int max) {
import java.io.IOException;  
                final DocIdSetIterator approximation = DocIdSetIterator.all(context.reader().maxDoc());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override  
import org.apache.lucene.search.ConstantScoreWeight;
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
                        } else {
                            }
}
import org.apache.lucene.search.ConstantScoreScorer;
 */  
 * A {@link SliceQuery} that uses the numeric doc values of a field to do the slicing.  
        };  
            public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
                    }
 * license agreements. See the NOTICE file distributed with
                    @Override
                };
                                    return true;  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.util.BitMixer;
import org.apache.lucene.search.DocIdSetIterator;  
                            return false;  
 *
 */  
        return new ConstantScoreWeight(this, boost) {
                        if (values.advanceExact(approximation.docID())) {  
                return DocValues.isCacheable(ctx, getField());  
 * Licensed to Elasticsearch under one or more contributor  
                        return 10;  
 * <p>
    }
                    @Override  
                        }  
                final Scorer scorer = new ConstantScoreScorer(score(), scoreMode, twoPhase);  
                    public boolean matches() throws IOException {
import org.apache.lucene.index.DocValues;
                final TwoPhaseIterator twoPhase = new TwoPhaseIterator(approximation) {
                    public float matchCost() {
            public boolean isCacheable(LeafReaderContext ctx) {
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
            @Override
 *
                return new DefaultScorerSupplier(scorer);
/**
package org.opensearch.search.slice;
 * not use this file except in compliance with the License.
import org.apache.lucene.search.TwoPhaseIterator;
import org.apache.lucene.search.Scorer;  
 */
                            return contains(0);
import org.apache.lucene.search.ScoreMode;
 * SPDX-License-Identifier: Apache-2.0
                        // BitMixer.mix seems to be about 10 ops
 *
/*  
                            for (int i = 0; i < values.docValueCount(); i++) {
 * You may obtain a copy of the License at  
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
        super(field, id, max);  
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
 *  
public final class DocValuesSliceQuery extends SliceQuery {
/*
import org.apache.lucene.search.ScorerSupplier;
 * under the License.  
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.index.SortedNumericDocValues;  
                                }
 */  
            @Override
                                if (contains(BitMixer.mix(values.nextValue()))) {
/*  
 * If updates are accepted on the field you must ensure that the same reader is used for all `slice` queries.  
                    }
            }
                final SortedNumericDocValues values = DocValues.getSortedNumeric(context.reader(), getField());  
 * <b>NOTE</b>: With deterministic field values this query can be used across different readers safely.
