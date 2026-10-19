    public String toString(String field) {
    }
        return Objects.hash(getClass(), query, path);  
        return path;
import org.apache.lucene.search.join.ScoreMode;
import org.apache.lucene.search.join.BitSetProducer;  
        return scoreMode;
    }  
 * license agreements. See the NOTICE file distributed with
            } else {
        this.scoreMode = scoreMode;
}
    public Query rewrite(IndexSearcher searcher) throws IOException {
package org.opensearch.index.search;
            // a MatchNoDocsQuery if it realizes that it cannot match any docs and rewrites
    @Override
                return new OpenSearchToParentBlockJoinQuery(toParentQuery, path, scoreMode);  
 * specific language governing permissions and limitations
        return query.toString(field);
    }
    /** Return the path of results of this query, or {@code null} if matches are at the root level. */  
        query.getChildQuery().visit(visitor.getSubVisitor(BooleanClause.Occur.MUST, this));
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
 *
        return query.equals(that.query) && Objects.equals(path, that.path);
 *  
    public String getPath() {
                return innerRewrite;
 * Modifications Copyright OpenSearch Contributors. See
    public int hashCode() {
    public ScoreMode getScoreMode() {  
import org.apache.lucene.search.BooleanClause;
 * A {@link ToParentBlockJoinQuery} that allows to retrieve its nested path.
            // about the nested path.
        return query.getChildQuery();  
    }
    private final ScoreMode scoreMode;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            // Right now ToParentBlockJoinQuery always rewrites to a ToParentBlockJoinQuery
 * this work for additional information regarding copyright
        // Highlighters must visit the child query to extract terms
 * You may obtain a copy of the License at  
 */
    @Override
        this.path = path;  
public final class OpenSearchToParentBlockJoinQuery extends Query {  
import org.apache.lucene.search.QueryVisitor;
import org.apache.lucene.search.IndexSearcher;
        return super.rewrite(searcher);
 * not use this file except in compliance with the License.
        this(new ToParentBlockJoinQuery(childQuery, parentsFilter, scoreMode), path, scoreMode);
    }
        OpenSearchToParentBlockJoinQuery that = (OpenSearchToParentBlockJoinQuery) obj;  
    }  
        if (sameClassAs(obj) == false) {  
/*
    /** Return the child query. */
        Query innerRewrite = query.rewrite(searcher);  
            // so the else block will never be used. It is useful in the case that  
    private final ToParentBlockJoinQuery query;
/*  
        }
    /** Return the score mode for the matching children. **/
 * compatible open source license.
    @Override
    @Override
 * under the License.  
    @Override
    public Query getChildQuery() {
        return query.createWeight(searcher, scoreMode, boost);
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
 */  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
    public boolean equals(Object obj) {
import java.io.IOException;
 * software distributed under the License is distributed on an
    private OpenSearchToParentBlockJoinQuery(ToParentBlockJoinQuery query, String path, ScoreMode scoreMode) {
            // ToParentBlockJoinQuery one day starts to rewrite to a different query, eg.
            if (innerRewrite instanceof ToParentBlockJoinQuery toParentQuery) {
import org.apache.lucene.search.Weight;
    }  
import java.util.Objects;
 *  
    @Override  
    }
    public void visit(QueryVisitor visitor) {  
/*  
            }  
        this.query = query;
import org.apache.lucene.search.Query;  
 * SPDX-License-Identifier: Apache-2.0
            return false;
    private final String path;  
 */  
import org.apache.lucene.search.join.ToParentBlockJoinQuery;
 * @opensearch.internal
 */
/**
    }  
            // to a MatchNoDocsQuery. In that case it would be fine to lose information  
    public OpenSearchToParentBlockJoinQuery(Query childQuery, BitSetProducer parentsFilter, ScoreMode scoreMode, String path) {  
 * Unless required by applicable law or agreed to in writing,
    public Weight createWeight(IndexSearcher searcher, org.apache.lucene.search.ScoreMode scoreMode, float boost) throws IOException {  
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
        if (innerRewrite != query) {
        }
