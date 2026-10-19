        }  
import org.apache.lucene.search.TermStatistics;
                    CollectionStatistics cs = super.collectionStatistics(field);  
 * You may obtain a copy of the License at  
                }
                .maxDoc(context.searcher().getIndexReader().maxDoc());  
                    }  
                    }  
 *
                    TermStatistics ts = super.termStatistics(term, docFreq, totalTermFreq);  
}  
                public TermStatistics termStatistics(Term term, int docFreq, long totalTermFreq) throws IOException {
 * @opensearch.internal
 * under the License.  
            };  
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
 * software distributed under the License is distributed on an
/*  
            Map<Term, TermStatistics> stats = new HashMap<>();
                    }
            Term[] terms = stats.keySet().toArray(new Term[0]);  
            for (RescoreContext rescoreContext : context.rescore()) {  
 * GitHub history for details.
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
 *  
import org.apache.lucene.search.IndexSearcher;  
                }  
 */  
            Map<String, CollectionStatistics> fieldStatistics = new HashMap<>();
/*  
                    if (cs != null) {
import org.opensearch.search.rescore.RescoreContext;  
            context.dfsResult()  
                termStatistics[i] = stats.get(terms[i]);  
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
            searcher.createWeight(context.searcher().rewrite(context.query()), ScoreMode.COMPLETE, 1);
import java.util.Map;
                        fieldStatistics.put(field, cs);
package org.opensearch.search.dfs;
                @Override
import org.opensearch.search.internal.SearchContext;
                .fieldStatistics(fieldStatistics)
                    if (context.isCancelled()) {  
 * this work for additional information regarding copyright
                    searcher.createWeight(context.searcher().rewrite(parsedQuery.query()), ScoreMode.COMPLETE, 1);
            }
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
public class DfsPhase {  
            for (int i = 0; i < terms.length; i++) {
            TermStatistics[] termStatistics = new TermStatistics[terms.length];
import org.apache.lucene.search.CollectionStatistics;
 * ownership. Elasticsearch licenses this file to you under  
 * The additional information is used to better compare the scores coming from all the shards, which depend on local factors (e.g. idf)
                    if (context.isCancelled()) {  
        } catch (Exception e) {
import org.apache.lucene.search.ScoreMode;
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
 */  
 * compatible open source license.
import java.util.HashMap;  
    }
 */
/**  
            IndexSearcher searcher = new IndexSearcher(context.searcher().getIndexReader()) {  
import org.opensearch.core.tasks.TaskCancelledException;  
                public CollectionStatistics collectionStatistics(String field) throws IOException {
 */
    public void execute(SearchContext context) {
                    return ts;
                }
 *
            throw new DfsPhaseExecutionException(context.shardTarget(), "Exception during dfs phase", e);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
                @Override
 * Licensed to Elasticsearch under one or more contributor  
                for (ParsedQuery parsedQuery : rescoreContext.getParsedQueries()) {
                .termsStatistics(terms, termStatistics)
                    if (ts != null) {
import org.opensearch.index.query.ParsedQuery;
                        throw new TaskCancelledException("cancelled task with reason: " + context.getTask().getReasonCancelled());
                        throw new TaskCancelledException("cancelled task with reason: " + context.getTask().getReasonCancelled());
 *  
 * KIND, either express or implied.  See the License for the
                        stats.put(term, ts);
 * the Apache License, Version 2.0 (the "License"); you may
        try {  
                    }
import org.apache.lucene.index.Term;
 * The OpenSearch Contributors require contributions made to  
                    return cs;
 * Dfs phase of a search request, used to make scoring 100% accurate by collecting additional info from each shard before the query phase.
