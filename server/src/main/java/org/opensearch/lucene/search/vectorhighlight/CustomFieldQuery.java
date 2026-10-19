                multiPhraseQuery.getTermArrays(),
                flatten(new TermQuery(term), searcher, flatQueries, boost);
 * falling back to term-by-term highlighting when the number of terms exceeds 16.  
import org.apache.lucene.search.PhraseQuery;
 * Modifications Copyright OpenSearch Contributors. See
                numTerms += currentPosTerm.length;
            for (int i = 0; i < termsIdx.length; i++) {
        if (currentPos == 0) {
import org.apache.lucene.search.TermQuery;
        super(query, reader, phraseHighlight, fieldMatch);  
            for (Term[] currentPosTerm : terms) {
    @Override
// LUCENE MONITOR
            convertMultiPhraseQuery(
            }
import java.io.IOException;
        } else if (sourceQuery instanceof FunctionScoreQuery functionScoreQuery) {
            super.flatten(sourceQuery, searcher, flatQueries, boost);  
         * we walk all possible ways and for each path down the MPQ we create a PhraseQuery this is what FieldQuery supports.
            this.flatten(query, searcher, flatQueries, 1F);  
            Query query = queryBuilder.build();
    private void convertMultiPhraseQuery(
 */
         * It seems expensive but most queries will pretty small.  
            flatten(sourceQuery.rewrite(searcher), searcher, flatQueries, boost);
 *   <li>Span term queries</li>
 * The class provides special handling for multi-phrase queries with high term counts,
/*
 * This class enhances the standard Lucene vector highlighting by providing special handling for:
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.search.vectorhighlight.FieldQuery;
            if (numTerms > 16) {
import org.apache.lucene.search.SynonymQuery;
 */  
            // SynonymQuery should be handled by the parent class directly.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                flatQueries
 * Custom implementation of Lucene's {@link FieldQuery} that extends highlighting capabilities
            flatten(sourceQuery, searcher, flatQueries, boost);  
import org.opensearch.common.lucene.search.MultiPhrasePrefixQuery;
public class CustomFieldQuery extends FieldQuery {  
        } else if (sourceQuery instanceof SpanTermQuery spanTermQuery) {
import org.opensearch.lucene.queries.BlendedTermQuery;
        if (sourceQuery instanceof BoostQuery bq) {  
            int numTerms = 0;  
 *   <li>Boost queries</li>  
        } else if (sourceQuery instanceof OpenSearchToParentBlockJoinQuery parentBlockJoinQuery) {  
 *   <li>Multi-phrase prefix queries</li>
        int[] termsIdx,  
 * specific language governing permissions and limitations
        } else if (sourceQuery instanceof BlendedTermQuery blendedTermQuery) {
 * license agreements. See the NOTICE file distributed with
/**  
 *   <li>Synonym queries</li>
 *   <li>Constant score queries</li>
import java.util.Collection;
            queryBuilder.setSlop(orig.getSlop());
                termsIdx[currentPos] = i;
import org.apache.lucene.search.Query;  
                searcher,
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
        } else {
            }  
 * Licensed to Elasticsearch under one or more contributor  
            flatten(funcScoreQuery.getWrappedQuery(), searcher, flatQueries, boost);
 * @see FastVectorHighlighter
 * @see FieldQuery  
package org.opensearch.lucene.search.vectorhighlight;
            sourceQuery = bq.getQuery();
 */
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.search.OpenSearchToParentBlockJoinQuery;
 * the Apache License, Version 2.0 (the "License"); you may
        }
 * The OpenSearch Contributors require contributions made to  
 * <p>  
                for (Term[] currentPosTerm : terms) {
import org.apache.lucene.queries.spans.SpanTermQuery;  
            for (int i = 0; i < t.length; i++) {  
 * this work for additional information regarding copyright
 *   <li>Blended term queries</li>  
import org.apache.lucene.search.IndexSearcher;  
        Collection<Query> flatQueries
            }  
            boost *= bq.getBoost();
 * <p>
        } else if (sourceQuery instanceof ConstantScoreQuery constantScoreQuery) {  
            flatten(constantScoreQuery.getQuery(), searcher, flatQueries, boost);
import org.apache.lucene.search.BoostQuery;
    }
                    for (Term term : currentPosTerm) {  
        } else if (sourceQuery instanceof org.apache.lucene.queries.function.FunctionScoreQuery funcScoreQuery) {  
import org.apache.lucene.search.ConstantScoreQuery;
            }
        } else {
 * GitHub history for details.
 *   <li>Multi-phrase queries</li>
        }
        if (currentPos == terms.length) {
    }
 * @opensearch.internal
    }
            }
 * to support additional OpenSearch-specific query types and complex queries.
                multiPhraseQuery.getPositions(),  
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;  
            flatten(functionScoreQuery.getSubQuery(), searcher, flatQueries, boost);  
        }  
        } else if (sourceQuery instanceof MultiPhraseQuery multiPhraseQuery) {  
 *  
        Term[][] terms,
            flatten(blendedTermQuery.rewrite(searcher), searcher, flatQueries, boost);
 * Unless required by applicable law or agreed to in writing,
                    }
        } else if (sourceQuery instanceof SynonymQuery synQuery) {  
                0,
 *   <li>Parent-child block join queries</li>
        int[] pos,  
/*  
 * under the License.  
            Term[] t = terms[currentPos];
 *   <li>Function score queries (both OpenSearch and Lucene variants)</li>  
                multiPhraseQuery,
import org.apache.lucene.search.MultiPhraseQuery;
        /*
import org.apache.lucene.index.IndexReader;
 * Thread safety is managed through a ThreadLocal variable {@link #highlightFilters}
                flatten(childQuery, searcher, flatQueries, boost);  
            );  
 *
            PhraseQuery.Builder queryBuilder = new PhraseQuery.Builder();  
    public CustomFieldQuery(Query query, IndexReader reader, FastVectorHighlighter highlighter) throws IOException {
        IndexSearcher searcher,
        MultiPhraseQuery orig,
    public static final ThreadLocal<Boolean> highlightFilters = new ThreadLocal<>();
 *
         */
            Query childQuery = parentBlockJoinQuery.getChildQuery();
                convertMultiPhraseQuery(currentPos + 1, termsIdx, orig, terms, pos, searcher, flatQueries);
            // flatten query with query boost
 * <ul>
    }  
                queryBuilder.add(terms[i][termsIdx[i]], pos[i]);  
 * compatible open source license.
        } else if (sourceQuery instanceof MultiPhrasePrefixQuery) {
 */  
import org.apache.lucene.search.vectorhighlight.FastVectorHighlighter;  
            if (childQuery != null) {
 * software distributed under the License is distributed on an
                new int[multiPhraseQuery.getTermArrays().length],  
                return;
    protected void flatten(Query sourceQuery, IndexSearcher searcher, Collection<Query> flatQueries, float boost) throws IOException {
    ) throws IOException {  
 * You may obtain a copy of the License at  
 * <p>
/*  
 * </ul>  
            // if we have more than 16 terms
            super.flatten(new TermQuery(spanTermQuery.getTerm()), searcher, flatQueries, boost);
}  
        int currentPos,
// TODO: remove me!
            for (Term term : synQuery.getTerms()) {  
 *
                }  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
    public CustomFieldQuery(Query query, IndexReader reader, boolean phraseHighlight, boolean fieldMatch) throws IOException {
            }
        highlightFilters.remove();
import org.apache.lucene.index.Term;
            // This statement should be removed when https://issues.apache.org/jira/browse/LUCENE-7484 is merged.
 * which is properly cleaned up after use.  
                        super.flatten(new TermQuery(term), searcher, flatQueries, 1F);
        this(query, reader, highlighter.isPhraseHighlight(), highlighter.isFieldMatch());
