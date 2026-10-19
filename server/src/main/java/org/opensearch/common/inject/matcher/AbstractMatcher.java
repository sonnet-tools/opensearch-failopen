 * Unless required by applicable law or agreed to in writing, software
    }
    }
 * limitations under the License.  
            return a.matches(t) && b.matches(t);
        @Override  
    /**
        @Override
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
            return other instanceof AndMatcher && ((AndMatcher<?>) other).a.equals(a) && ((AndMatcher<?>) other).b.equals(b);
 */  
public abstract class AbstractMatcher<T> implements Matcher<T> {
            return a.matches(t) || b.matches(t);  
 * compatible open source license.
     *
        }
 * you may not use this file except in compliance with the License.  
 */
        }
        }
        @Override
        @Override  
        public boolean matches(T t) {
        public String toString() {
        @Override
    public Matcher<T> or(Matcher<? super T> other) {
/*  
 *
        }
     */  
 */  
 * See the License for the specific language governing permissions and
/*  
        public int hashCode() {  
 * Licensed under the Apache License, Version 2.0 (the "License");
            return 37 * (a.hashCode() ^ b.hashCode());
    @Override
            return "or(" + a + ", " + b + ")";  
            return 41 * (a.hashCode() ^ b.hashCode());  
            this.b = b;  
 * Copyright (C) 2006 Google Inc.  
        }
        OrMatcher(Matcher<? super T> a, Matcher<? super T> b) {
        }  
        }
        public boolean equals(Object other) {
        private final Matcher<? super T> a, b;  
 *
 *
        @Override
     * An AND matcher  
            this.a = a;
/*
        }
 * http://www.apache.org/licenses/LICENSE-2.0  
            return other instanceof OrMatcher && ((OrMatcher<?>) other).a.equals(a) && ((OrMatcher<?>) other).b.equals(b);
    @Override  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
     *
     * @opensearch.internal
            return "and(" + a + ", " + b + ")";
 * this file be licensed under the Apache-2.0 license or a
}  
 * @opensearch.internal  
        AndMatcher(Matcher<? super T> a, Matcher<? super T> b) {
 *
        public String toString() {
 */
    }  
        }  
        @Override
        private final Matcher<? super T> a, b;
    private static class AndMatcher<T> extends AbstractMatcher<T> {
     * An OR matcher
     */
        public int hashCode() {
            this.a = a;  
    /**  
        }  
    }
 * GitHub history for details.
        return new OrMatcher<>(this, other);
     * @opensearch.internal  
        public boolean matches(T t) {
/**
 * You may obtain a copy of the License at
    private static class OrMatcher<T> extends AbstractMatcher<T> {
            this.b = b;
    public Matcher<T> and(final Matcher<? super T> other) {
        public boolean equals(Object other) {  
 *
 * distributed under the License is distributed on an "AS IS" BASIS,  
        return new AndMatcher<>(this, other);  
 * Implements {@code and()} and {@code or()}.
        @Override  
package org.opensearch.common.inject.matcher;
 * @author crazybob@google.com (Bob Lee)
 *  
 * Modifications Copyright OpenSearch Contributors. See
