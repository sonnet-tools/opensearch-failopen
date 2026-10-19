    @Override  
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
/*
        this.query = query;
    public boolean matchesSafely(Engine.Searcher searcher) {
 * The OpenSearch Contributors require contributions made to  
        this.totalHits = totalHits;  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
    }  
 * this work for additional information regarding copyright
public final class EngineSearcherTotalHitsMatcher extends TypeSafeMatcher<Engine.Searcher> {  
 */  
import org.opensearch.common.lucene.search.Queries;
/*  
import org.hamcrest.Matcher;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.index.engine;
 * under the License.  
 *
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
import org.hamcrest.Description;  
            return false;  
    public static Matcher<Engine.Searcher> engineSearcherTotalHits(Query query, int totalHits) {
            this.count = searcher.count(query);  
    }
            return count == totalHits;
        return new EngineSearcherTotalHitsMatcher(query, totalHits);  
import org.hamcrest.TypeSafeMatcher;
 * software distributed under the License is distributed on an
import org.apache.lucene.search.Query;
 *
 *  
 * ownership. Elasticsearch licenses this file to you under  
    @Override
import java.io.IOException;
 * Unless required by applicable law or agreed to in writing,
        description.appendText("total hits of size ").appendValue(totalHits).appendText(" with query ").appendValue(query);
        return new EngineSearcherTotalHitsMatcher(Queries.newMatchAllQuery(), totalHits);
    private final Query query;
    }
 * Licensed to Elasticsearch under one or more contributor  
    public static Matcher<Engine.Searcher> engineSearcherTotalHits(int totalHits) {  
    protected void describeMismatchSafely(Engine.Searcher item, Description mismatchDescription) {
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
    private int count;
        }
    public EngineSearcherTotalHitsMatcher(Query query, int totalHits) {
        } catch (IOException e) {
 */  
 * compatible open source license.
    @Override  
    }
        mismatchDescription.appendText("was ").appendValue(count);  
    }
 * You may obtain a copy of the License at  
 * GitHub history for details.
 */
    private final int totalHits;
    }
/*  
}  
        try {
 * license agreements. See the NOTICE file distributed with
    public void describeTo(Description description) {
