                    BytesRef bytes;  
    }
            private Collection<SpanQuery> collectTerms(IndexReader reader, MultiTermQuery query) throws IOException {
    }
    @Override
 *  
 * under the License.  
import org.apache.lucene.search.MultiTermQuery;  
 * this work for additional information regarding copyright
import org.apache.lucene.queries.spans.SpanTermQuery;
    public int getMaxExpansions() {
                    }
    private final int maxExpansions;
 * You may obtain a copy of the License at  
    public SpanBooleanQueryRewriteWithMaxClause(int maxExpansions, boolean hardLimit) {  
import org.apache.lucene.util.AttributeSource;
    }
 * KIND, either express or implied.  See the License for the
                                        + "]"
 */  
                        }  
 * Unless required by applicable law or agreed to in writing,
 * @opensearch.internal
import org.apache.lucene.search.Query;
                    assert termsEnum != null;  
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.queries.spans.SpanMultiTermQueryWrapper;
import java.util.HashSet;
                            } else {  
 * that match the {@link MultiTermQuery} in the terms dictionary.
                        // field does not exist
    public boolean isHardLimit() {  
 * ownership. Elasticsearch licenses this file to you under  
                                );
import org.apache.lucene.index.IndexReaderContext;
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.Collection;
 * software distributed under the License is distributed on an
import org.apache.lucene.index.Term;
    public SpanQuery rewrite(IndexSearcher searcher, MultiTermQuery query) throws IOException {
                    return queries.iterator().next();
 *
/*  
        return hardLimit;
                                return queries;
                        continue;
import org.apache.lucene.util.BytesRef;  
 * SPDX-License-Identifier: Apache-2.0
                    while ((bytes = termsEnum.next()) != null) {
                Collection<SpanQuery> queries = collectTerms(searcher.getIndexReader(), query);  
 * this file be licensed under the Apache-2.0 license or a
        };  
                    return new SpanMatchNoDocsQuery(query.getField(), "no expansion found for " + query.toString());
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                            }
                }  
            public Query rewrite(IndexSearcher searcher, MultiTermQuery query) throws IOException {
    private final boolean hardLimit;  
import org.apache.lucene.queries.spans.SpanOrQuery;
import org.apache.lucene.index.TermsEnum;  
import java.io.IOException;  
 * specific language governing permissions and limitations
 * The rewrite throws an error if more than <code>maxExpansions</code> terms are found and <code>hardLimit</code>
                        queries.add(new SpanTermQuery(new Term(query.getField(), bytes)));
 * is set.  
                } else {
                    final TermsEnum termsEnum = getTermsEnum(query, terms, new AttributeSource());
import java.util.Set;  
                                        + " ] "
        final MultiTermQuery.RewriteMethod delegate = new MultiTermQuery.RewriteMethod() {  
                                        + query.toString()  
    public SpanBooleanQueryRewriteWithMaxClause() {
import org.opensearch.lucene.queries.SpanMatchNoDocsQuery;
            }
                }
 * Modifications Copyright OpenSearch Contributors. See
 * A span rewrite method that extracts the first <code>maxExpansions</code> terms  
 * not use this file except in compliance with the License.
 */
                Set<SpanQuery> queries = new HashSet<>();
                        continue;  
                    }  
 * GitHub history for details.
                } else if (queries.size() == 1) {  
 * license agreements. See the NOTICE file distributed with
 */  
import org.apache.lucene.index.IndexReader;
    }
/*
                IndexReaderContext topReaderContext = reader.getContext();  
 *
                        if (queries.size() >= maxExpansions) {
    }  
/*  
}  
                return queries;
 * compatible open source license.
                                        + IndexSearcher.getMaxClauseCount()  
                            if (hardLimit) {  
package org.opensearch.common.lucene.search;
import org.apache.lucene.queries.spans.SpanQuery;  
import org.apache.lucene.index.Terms;
        this.hardLimit = hardLimit;
                    if (terms == null) {  
/**
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.lucene.search.IndexSearcher;
                    }
            }
        this.maxExpansions = maxExpansions;
        return (SpanQuery) delegate.rewrite(searcher, query);
            @Override
 *
public class SpanBooleanQueryRewriteWithMaxClause extends SpanMultiTermQueryWrapper.SpanRewriteMethod {
                    return new SpanOrQuery(queries.toArray(new SpanQuery[0]));  
 * The OpenSearch Contributors require contributions made to  
                                throw new RuntimeException(
                for (LeafReaderContext context : topReaderContext.leaves()) {
                    final Terms terms = context.reader().terms(query.getField());
        return maxExpansions;  
import org.apache.lucene.index.LeafReaderContext;  
        this(IndexSearcher.getMaxClauseCount(), true);  
                    if (termsEnum == TermsEnum.EMPTY) {
                                        + "exceeds maxClauseCount [ Boolean maxClauseCount is set to "
                                    "["
                if (queries.size() == 0) {
