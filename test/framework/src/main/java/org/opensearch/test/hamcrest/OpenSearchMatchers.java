            description.appendText("searchHit score should be ").appendValue(score);
    }
            this.score = score;
        public void describeMismatchSafely(final SearchHit searchHit, final Description mismatchDescription) {  
import org.hamcrest.Description;
 * software distributed under the License is distributed on an
            return new CombinableMatcher<>(new HasPropertyLambdaMatcher<>(valueMatcher, property));  
            mismatchDescription.appendText(" was ").appendValue(searchHit.getId());
    }  
        @Override
 * ownership. Elasticsearch licenses this file to you under  
        protected boolean matchesSafely(SearchHit searchHit) {
        }  
 * under the License.  
import java.util.function.Function;
        public void describeTo(final Description description) {  
        }
 * this work for additional information regarding copyright
        @Override
         * @param property     The lambda to fetch property  
        public void describeMismatchSafely(final SearchHit searchHit, final Description mismatchDescription) {
        }  
        protected boolean matchesSafely(SearchHit searchHit) {
 */  
package org.opensearch.test.hamcrest;
            description.appendText("searchHit matched queries should be ").appendValue(Arrays.toString(matchedQueries));
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
            return property.apply(actual);
        }
        public void describeTo(final Description description) {  
            mismatchDescription.appendText(" was ").appendValue(searchHit.getIndex());
        @Override  
            }  
        @Override
        protected boolean matchesSafely(SearchHit searchHit) {  
public class OpenSearchMatchers {
            mismatchDescription.appendText(" was ").appendValue(searchHit.getScore());  
 * Modifications Copyright OpenSearch Contributors. See  
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
        @Override
        }
        @Override
        }
import java.util.Arrays;
        private final Function<? super T, ? extends V> property;
            this.matchedQueries = matchedQueries;
        protected V featureValueOf(T actual) {  
            return searchHit.getIndex().equals(index);
        private String id;
            Arrays.sort(searchHitQueries);
import org.hamcrest.TypeSafeMatcher;
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
        public boolean matchesSafely(final SearchHit searchHit) {
        private float score;
    }  
}  
        /**
    public static class SearchHitMatchedQueriesMatcher extends TypeSafeMatcher<SearchHit> {  
        @Override
    }
        @Override  
        private String index;  
        }
        }  
 */
        }
        public void describeMismatchSafely(final SearchHit searchHit, final Description mismatchDescription) {
        public void describeTo(final Description description) {
        }
         */
        @Override  
    public static class SearchHitHasScoreMatcher extends TypeSafeMatcher<SearchHit> {
    }
import org.opensearch.search.SearchHit;  
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
        private HasPropertyLambdaMatcher(Matcher<? super V> subMatcher, Function<? super T, ? extends V> property) {  
        }  
        public void describeMismatchSafely(final SearchHit searchHit, final Description mismatchDescription) {
            String[] searchHitQueries = searchHit.getMatchedQueries();  
        public SearchHitHasIdMatcher(String id) {  
            if (matchedQueries == null) {
        @Override
            description.appendText("searchHit id should be ").appendValue(id);
            this.id = id;
        public void describeTo(final Description description) {
        }  
        }  
 *
                return false;
        private String[] matchedQueries;
            this.index = index;  
        }
 * specific language governing permissions and limitations
/*
 * this file be licensed under the Apache-2.0 license or a
        public SearchHitHasScoreMatcher(float score) {
 */
 *  
            description.appendText("searchHit index should be ").appendValue(index);  
import org.hamcrest.FeatureMatcher;
        }
    public static class HasPropertyLambdaMatcher<T, V> extends FeatureMatcher<T, V> {
            this.property = property;
        public SearchHitMatchedQueriesMatcher(String[] matchedQueries) {  
    public static class SearchHitHasIndexMatcher extends TypeSafeMatcher<SearchHit> {
        }
        public static <T, V> CombinableMatcher<T> hasProperty(Function<? super T, ? extends V> property, Matcher<V> valueMatcher) {
            return searchHit.getId().equals(id);  
 *
        @Override
        @Override
            return Arrays.equals(searchHitQueries, matchedQueries);  
        public SearchHitHasIndexMatcher(String index) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        @Override  
/*  
            Arrays.sort(matchedQueries);
 * the Apache License, Version 2.0 (the "License"); you may
        }
 * The OpenSearch Contributors require contributions made to  
        }
    public static class SearchHitHasIdMatcher extends TypeSafeMatcher<SearchHit> {  
         * @param valueMatcher The matcher to apply to the property
 * GitHub history for details.
import org.hamcrest.core.CombinableMatcher;
            mismatchDescription.appendText(" matched queries were ").appendValue(Arrays.toString(searchHit.getMatchedQueries()));
 * not use this file except in compliance with the License.
import org.hamcrest.Matcher;  
            return searchHit.getScore() == score;
/*
 * compatible open source license.
            super(subMatcher, "object with", "lambda");
