 * under the License.  
    public String toString(String field) {
    }
/**  
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
        if (this == o) return true;  
    }  
    @Override  
 */
    public int hashCode() {
import org.apache.lucene.search.Query;  
    public void visit(QueryVisitor visitor) {  
    @Override
    public Query getQuery() {  
        return Objects.hash(in);
public class DateRangeIncludingNowQuery extends Query {
 * this work for additional information regarding copyright
    }
    public boolean equals(Object o) {
    private final Query in;  
 */  
import org.apache.lucene.search.BooleanClause;
 * software distributed under the License is distributed on an
    }
    public DateRangeIncludingNowQuery(Query in) {
 * @opensearch.internal
    }
import org.apache.lucene.search.IndexSearcher;
    public Query rewrite(IndexSearcher searcher) throws IOException {
import java.io.IOException;  
 *  
package org.opensearch.index.query;
 * compatible open source license.
 */  
    @Override
 * A simple wrapper class that indicates that the wrapped query has made use of NOW
 * license agreements. See the NOTICE file distributed with
 *
        DateRangeIncludingNowQuery that = (DateRangeIncludingNowQuery) o;
        return in;  
 * GitHub history for details.
/*  
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * when parsing its datemath.  Useful for preprocessors such as the percolator that
    @Override
        this.in = in;  
 * ownership. Elasticsearch licenses this file to you under  
/*  
        in.visit(visitor.getSubVisitor(BooleanClause.Occur.MUST, this));
 * need to know when not to extract dates from the query.  
 *
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
    @Override  
 *
        if (o == null || getClass() != o.getClass()) return false;
 * KIND, either express or implied.  See the License for the
import java.util.Objects;
        return "DateRangeIncludingNowQuery(" + in + ")";
        return in;
}
 * specific language governing permissions and limitations
import org.apache.lucene.search.QueryVisitor;
 * this file be licensed under the Apache-2.0 license or a
        return Objects.equals(in, that.in);  
 * SPDX-License-Identifier: Apache-2.0
    }  
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
 */  
