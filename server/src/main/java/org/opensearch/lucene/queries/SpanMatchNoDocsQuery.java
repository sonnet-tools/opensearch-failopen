    @Override  
 */
    @Override
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;
/*
            @Override  
/*
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See  
 * GitHub history for details.
    @Override  
public class SpanMatchNoDocsQuery extends SpanQuery {
            public Spans getSpans(LeafReaderContext ctx, Postings requiredPostings) {
 * compatible open source license.
 * software distributed under the License is distributed on an
        this.field = field;
}
import org.apache.lucene.queries.spans.SpanQuery;  
 * SPDX-License-Identifier: Apache-2.0
    private final String reason;
import org.apache.lucene.queries.spans.SpanWeight;
    private final String field;  
import org.apache.lucene.index.Term;
        return classHash();  
    }
    public int hashCode() {
    }  
 * KIND, either express or implied.  See the License for the
                return true;
 *  
 * this work for additional information regarding copyright
        return new SpanWeight(this, searcher, Collections.emptyMap(), boost) {
import org.apache.lucene.search.QueryVisitor;
            @Override  
import org.apache.lucene.search.ScoreMode;
    @Override
    @Override
 * not use this file except in compliance with the License.
    public SpanMatchNoDocsQuery(String field, String reason) {  
    }
            @Override
            }
    }
    }
        };  
 *
 * A {@link SpanQuery} that matches no documents.  
import java.util.Collections;
/**
            }  
/*  
            public boolean isCacheable(LeafReaderContext ctx) {  
        return sameClassAs(o);
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    public String getField() {
    public String toString(String field) {
    }  
                return null;
 * The OpenSearch Contributors require contributions made to  
import java.util.Map;  
 */  
    @Override
 * specific language governing permissions and limitations
 *
package org.opensearch.lucene.queries;
 * Licensed to Elasticsearch under one or more contributor  
        return "SpanMatchNoDocsQuery(\"" + reason + "\")";
    public void visit(QueryVisitor visitor) {  
 * the Apache License, Version 2.0 (the "License"); you may
 */
import org.apache.lucene.index.TermStates;
import org.apache.lucene.index.LeafReaderContext;  
import org.apache.lucene.search.IndexSearcher;  
 * under the License.  
        visitor.visitLeaf(this);
 * this file be licensed under the Apache-2.0 license or a
        this.reason = reason;
        return field;  
import org.apache.lucene.queries.spans.Spans;
    public SpanWeight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
 */
            public void extractTermStates(Map<Term, TermStates> contexts) {}
 * license agreements. See the NOTICE file distributed with
    public boolean equals(Object o) {  
