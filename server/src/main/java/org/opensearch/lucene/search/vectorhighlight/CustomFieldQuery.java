 * license agreements. See the NOTICE file distributed with
        } else if (sourceQuery instanceof MultiPhraseQuery multiPhraseQuery) {
import org.opensearch.index.search.OpenSearchToParentBlockJoinQuery;
            );
            flatten(sourceQuery, searcher, flatQueries, boost);
        int[] termsIdx,
                termsIdx[currentPos] = i;
        } else if (sourceQuery instanceof OpenSearchToParentBlockJoinQuery parentBlockJoinQuery) {
                return;
 *   <li>Multi-phrase prefix queries</li>
 *
    }
                }
                flatQueries
import org.apache.lucene.search.vectorhighlight.FastVectorHighlighter;
 * </ul>
        } else if (sourceQuery instanceof org.apache.lucene.queries.function.FunctionScoreQuery funcScoreQuery) {
 *   <li>Synonym queries</li>
        } else if (sourceQuery instanceof SpanTermQuery spanTermQuery) {
 * not use this file except in compliance with the License.
                flatten(new TermQuery(term), searcher, flatQueries, boost);
 *
            queryBuilder.setSlop(orig.getSlop());
        } else if (sourceQuery instanceof SynonymQuery synQuery) {
            this.flatten(query, searcher, flatQueries, 1F);
            Term[] t = terms[currentPos];
 * ownership. Elasticsearch licenses this file to you under
package org.opensearch.lucene.search.vectorhighlight;
 *
import org.apache.lucene.search.IndexSearcher;
 *   <li>Parent-child block join queries</li>
        } else {
 */
        int[] pos,
        }
            super.flatten(sourceQuery, searcher, flatQueries, boost);
            super.flatten(new TermQuery(spanTermQuery.getTerm()), searcher, flatQueries, boost);
            sourceQuery = bq.getQuery();
 * under the License.
        } else {
import org.apache.lucene.index.Term;
 * SPDX-License-Identifier: Apache-2.0
/**
            }
/*
            // flatten query with query boost
    }
/*
import org.opensearch.lucene.queries.BlendedTermQuery;
 *   <li>Blended term queries</li>
import org.apache.lucene.search.PhraseQuery;
// TODO: remove me!
 * The class provides special handling for multi-phrase queries with high term counts,
 *   <li>Multi-phrase queries</li>
import org.apache.lucene.queries.spans.SpanTermQuery;
 * this file be licensed under the Apache-2.0 license or a
 * @see FieldQuery
 * software distributed under the License is distributed on an
        highlightFilters.remove();
 * Unless required by applicable law or agreed to in writing,
        } else if (sourceQuery instanceof BlendedTermQuery blendedTermQuery) {
         */
            }
import org.apache.lucene.search.MultiPhraseQuery;
            convertMultiPhraseQuery(
            }
    public CustomFieldQuery(Query query, IndexReader reader, FastVectorHighlighter highlighter) throws IOException {
 *   <li>Function score queries (both OpenSearch and Lucene variants)</li>
import java.io.IOException;
            // SynonymQuery should be handled by the parent class directly.
import org.apache.lucene.search.TermQuery;
                    }
                for (Term[] currentPosTerm : terms) {
    private void convertMultiPhraseQuery(
            }
 * Licensed to Elasticsearch under one or more contributor
}
        } else if (sourceQuery instanceof MultiPhrasePrefixQuery) {
 *
 *   <li>Boost queries</li>
        if (currentPos == 0) {
            }
 * this work for additional information regarding copyright
                searcher,
 * which is properly cleaned up after use.
 * falling back to term-by-term highlighting when the number of terms exceeds 16.
 * Modifications Copyright OpenSearch Contributors. See
                flatten(childQuery, searcher, flatQueries, boost);
            int numTerms = 0;
 * <p>
         * It seems expensive but most queries will pretty small.
            for (int i = 0; i < t.length; i++) {
 *   <li>Constant score queries</li>
        } else if (sourceQuery instanceof FunctionScoreQuery functionScoreQuery) {
         * we walk all possible ways and for each path down the MPQ we create a PhraseQuery this is what FieldQuery supports.
            for (Term[] currentPosTerm : terms) {
            flatten(constantScoreQuery.getQuery(), searcher, flatQueries, boost);
import org.apache.lucene.search.Query;
                multiPhraseQuery.getTermArrays(),
        super(query, reader, phraseHighlight, fieldMatch);
 *   <li>Span term queries</li>
            flatten(funcScoreQuery.getWrappedQuery(), searcher, flatQueries, boost);
        } else if (sourceQuery instanceof ConstantScoreQuery constantScoreQuery) {
public class CustomFieldQuery extends FieldQuery {
    protected void flatten(Query sourceQuery, IndexSearcher searcher, Collection<Query> flatQueries, float boost) throws IOException {
        }
            PhraseQuery.Builder queryBuilder = new PhraseQuery.Builder();
            flatten(blendedTermQuery.rewrite(searcher), searcher, flatQueries, boost);
import org.apache.lucene.search.SynonymQuery;
            Query childQuery = parentBlockJoinQuery.getChildQuery();
/*
 * <ul>
                queryBuilder.add(terms[i][termsIdx[i]], pos[i]);
            for (Term term : synQuery.getTerms()) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.common.lucene.search.MultiPhrasePrefixQuery;
                        super.flatten(new TermQuery(term), searcher, flatQueries, 1F);
                convertMultiPhraseQuery(currentPos + 1, termsIdx, orig, terms, pos, searcher, flatQueries);
    @Override
 * <p>
    }
    public static final ThreadLocal<Boolean> highlightFilters = new ThreadLocal<>();
        this(query, reader, highlighter.isPhraseHighlight(), highlighter.isFieldMatch());
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.search.ConstantScoreQuery;
 * @see FastVectorHighlighter
 * You may obtain a copy of the License at
            // This statement should be removed when https://issues.apache.org/jira/browse/LUCENE-7484 is merged.
            // if we have more than 16 terms
 * This class enhances the standard Lucene vector highlighting by providing special handling for:
                numTerms += currentPosTerm.length;
                new int[multiPhraseQuery.getTermArrays().length],
        /*
import org.apache.lucene.search.vectorhighlight.FieldQuery;
                    for (Term term : currentPosTerm) {
// LUCENE MONITOR
 */
import org.apache.lucene.index.IndexReader;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.search.BoostQuery;
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;
                multiPhraseQuery.getPositions(),
 * <p>
 * to support additional OpenSearch-specific query types and complex queries.
            Query query = queryBuilder.build();
            flatten(functionScoreQuery.getSubQuery(), searcher, flatQueries, boost);
                0,
 * GitHub history for details.
        int currentPos,
        if (currentPos == terms.length) {
        MultiPhraseQuery orig,
        Term[][] terms,
import java.util.Collection;
 * compatible open source license.
            if (childQuery != null) {
            if (numTerms > 16) {
 * @opensearch.internal
        Collection<Query> flatQueries
 */
 * specific language governing permissions and limitations
            flatten(sourceQuery.rewrite(searcher), searcher, flatQueries, boost);
    ) throws IOException {
 * Thread safety is managed through a ThreadLocal variable {@link #highlightFilters}
 * Custom implementation of Lucene's {@link FieldQuery} that extends highlighting capabilities
        IndexSearcher searcher,
            }
                multiPhraseQuery,
            for (int i = 0; i < termsIdx.length; i++) {
 * the Apache License, Version 2.0 (the "License"); you may
 */
        if (sourceQuery instanceof BoostQuery bq) {
            boost *= bq.getBoost();
        }
    public CustomFieldQuery(Query query, IndexReader reader, boolean phraseHighlight, boolean fieldMatch) throws IOException {
 * The OpenSearch Contributors require contributions made to
    }
