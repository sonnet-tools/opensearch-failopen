    }
            return item != null && v1Matcher.matches(item.v1()) && v2Matcher.matches(item.v2());  
    public static <V1, V2> TupleMatcher<? extends V1, ? extends V2> isTuple(Matcher<? super V1> v1Matcher, Matcher<? super V2> v2Matcher) {
 * Licensed to Elasticsearch under one or more contributor  
        @Override  
 * Modifications Copyright OpenSearch Contributors. See  
 */
        }  
        return new TupleMatcher(v1Matcher, v2Matcher);  
        public void describeTo(final Description description) {
        }
import java.util.Arrays;
 *
 * ownership. Elasticsearch licenses this file to you under  
            this.v1Matcher = v1Matcher;  
 * license agreements. See the NOTICE file distributed with
/*  
 * The OpenSearch Contributors require contributions made to  
    private static class TupleMatcher<V1, V2> extends TypeSafeMatcher<Tuple<? extends V1, ? extends V2>> {  
 * compatible open source license.
    /**  
        private final Matcher<? super V2> v2Matcher;  
import org.hamcrest.TypeSafeMatcher;  
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
     *  2. the examined tuple's <code>v2()</code> matches the specified <code>v2Matcher</code>
            description.appendText("expected tuple matching ").appendList("[", ", ", "]", Arrays.asList(v1Matcher, v2Matcher));
     * Creates a matcher that matches iff:
            this.v2Matcher = v2Matcher;
}
public class TupleMatchers {
     * For example:
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
/*
        private TupleMatcher(Matcher<? super V1> v1Matcher, Matcher<? super V2> v2Matcher) {
 */
 *  
 * this file be licensed under the Apache-2.0 license or a
import org.hamcrest.Description;
/*
     * <pre>assertThat(Tuple.tuple("myValue1", "myValue2"), isTuple(startsWith("my"), containsString("Val")))</pre>  
    }
 * SPDX-License-Identifier: Apache-2.0
import org.hamcrest.Matcher;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
     * and  
 * GitHub history for details.
 *
 * Unless required by applicable law or agreed to in writing,
     */
     *  1. the examined tuple's <code>v1()</code> matches the specified <code>v1Matcher</code>
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
 */  
        protected boolean matchesSafely(final Tuple<? extends V1, ? extends V2> item) {
        @Override
package org.opensearch.test.hamcrest;
        private final Matcher<? super V1> v1Matcher;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.collect.Tuple;  
 * this work for additional information regarding copyright
        }
