/*  
 *
public interface Matcher<T> {
 * Returns {@code true} or {@code false} for a given input.
/**  
 * @author crazybob@google.com (Bob Lee)  
/*  
 * The OpenSearch Contributors require contributions made to  
     * given matcher return {@code true}.
     * given matcher return {@code true}.
package org.opensearch.common.inject.matcher;
 * you may not use this file except in compliance with the License.  
 * GitHub history for details.
 * limitations under the License.  
     */  
@PublicApi(since = "1.0.0")
    Matcher<T> and(Matcher<? super T> other);
    boolean matches(T t);
     * Returns a new matcher which returns {@code true} if both this and the
     */  
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.api
    /**  
 * distributed under the License is distributed on an "AS IS" BASIS,  
 */  
 * Copyright (C) 2006 Google Inc.  
 *
 * Unless required by applicable law or agreed to in writing, software
 */
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    /**
 * Licensed under the Apache License, Version 2.0 (the "License");
    /**  
 *
 *
 * SPDX-License-Identifier: Apache-2.0
/*
}
 */  
 * http://www.apache.org/licenses/LICENSE-2.0  
    Matcher<T> or(Matcher<? super T> other);
 *
     * Returns a new matcher which returns {@code true} if either this or the
     */  
 *
import org.opensearch.common.annotation.PublicApi;
     * Returns {@code true} if this matches {@code t}, {@code false} otherwise.
 * You may obtain a copy of the License at
 */  
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
 * See the License for the specific language governing permissions and
