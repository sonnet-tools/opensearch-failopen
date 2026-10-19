    @Override
 * under the License.  
        public String toString(String field) {
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
import java.util.List;
/*
 * Unless required by applicable law or agreed to in writing,
        }
        return singletonList(new QuerySpec<>(DummyQueryBuilder.NAME, DummyQueryBuilder::new, DummyQueryBuilder::fromXContent));
 * compatible open source license.
import org.apache.lucene.search.Query;  
import org.apache.lucene.search.IndexSearcher;
/*  
 * not use this file except in compliance with the License.
 * GitHub history for details.
 *  
import org.apache.lucene.search.ScoreMode;
 *
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
        @Override  
import org.opensearch.plugins.Plugin;
        }
 * specific language governing permissions and limitations
package org.opensearch.index.query.plugin;
        private final Query matchAllDocsQuery = new MatchAllDocsQuery();
        }
 */  
        public boolean equals(Object obj) {  
    }
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *     http://www.apache.org/licenses/LICENSE-2.0
        @Override  
            return sameClassAs(obj);
    public List<QuerySpec<?>> getQueries() {  
        }  
        public int hashCode() {
        @Override
import org.apache.lucene.search.Weight;  
 *
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
public class DummyQueryParserPlugin extends Plugin implements SearchPlugin {  
        }  
import java.io.IOException;
 * Licensed to Elasticsearch under one or more contributor  
            return classHash();  
 * You may obtain a copy of the License at  
import org.opensearch.plugins.SearchPlugin;
 * Modifications Copyright OpenSearch Contributors. See
        @Override
    public static class DummyQuery extends Query {
        @Override
/*  
            return matchAllDocsQuery.createWeight(searcher, scoreMode, boost);
}
    }
import org.apache.lucene.search.MatchAllDocsQuery;
import static java.util.Collections.singletonList;
        public void visit(QueryVisitor visitor) {
import org.apache.lucene.search.QueryVisitor;
 * The OpenSearch Contributors require contributions made to  
 */
            visitor.visitLeaf(this);
        public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
 */  
            return getClass().getSimpleName();  
