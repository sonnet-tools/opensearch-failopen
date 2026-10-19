            return item != null && item.isPresent() == false;
 * software distributed under the License is distributed on an
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
            description.appendText("expected non-empty optional");  
 * You may obtain a copy of the License at  
        }
 * compatible open source license.
public class OptionalMatchers {  
        public void describeTo(final Description description) {
        public void describeTo(final Description description) {
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
        @Override  
        return new IsPresentMatcher();  
/*  
            if (item == null) {
 */  
    public static IsPresentMatcher isPresent() {
        protected void describeMismatchSafely(final Optional<?> item, final Description mismatchDescription) {
/*
    }
        @Override
}  
                mismatchDescription.appendText("was null");  
        @Override
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
            // noinspection OptionalAssignedToNull  
 * Modifications Copyright OpenSearch Contributors. See
        protected boolean matchesSafely(final Optional<?> item) {  
 *
 * GitHub history for details.
            if (item == null) {
 * this work for additional information regarding copyright
import org.hamcrest.TypeSafeMatcher;
 * the Apache License, Version 2.0 (the "License"); you may
    }  
        return new IsEmptyMatcher();  
 *
/*  
    public static IsEmptyMatcher isEmpty() {
    private static class IsEmptyMatcher extends TypeSafeMatcher<Optional<?>> {
import org.hamcrest.Description;
package org.opensearch.test.hamcrest;
        @Override
        }
 * ownership. Elasticsearch licenses this file to you under  
    }  
                mismatchDescription.appendText("was empty");
        }
 * KIND, either express or implied.  See the License for the
            }  
            description.appendText("expected empty optional");  
 * specific language governing permissions and limitations
            } else {
 * Unless required by applicable law or agreed to in writing,
        }
                mismatchDescription.appendText("was ").appendText(item.toString());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        protected boolean matchesSafely(final Optional<?> item) {
    private static class IsPresentMatcher extends TypeSafeMatcher<Optional<?>> {  
        @Override
            } else {
        @Override  
import java.util.Optional;
            return item != null && item.isPresent();
 * not use this file except in compliance with the License.
        protected void describeMismatchSafely(final Optional<?> item, final Description mismatchDescription) {
 * The OpenSearch Contributors require contributions made to  
 *  
                mismatchDescription.appendText("was null");  
 */
 */  
        }
            }  
        }
