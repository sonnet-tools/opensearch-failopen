public interface TypeListener {
 * listener once.
 */  
 * GitHub history for details.
 * distributed under the License is distributed on an "AS IS" BASIS,  
/*  
/*
 * @opensearch.api
}  
 * binding method interceptors}.  
/*  
 * <p>
     * creates a JIT binding).  
     * @param type      encountered by Guice
/**
 */  
 * You may obtain a copy of the License at
     * Invoked when Guice encounters a new type eligible for constructor or members injection.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.annotation.PublicApi;
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * @since 2.0
 * Unless required by applicable law or agreed to in writing, software
import org.opensearch.common.inject.TypeLiteral;
package org.opensearch.common.inject.spi;
     *
     * @param encounter context of this encounter, enables reporting errors, registering injection  
 *
 * you may not use this file except in compliance with the License.  
@PublicApi(since = "1.0.0")  
 * limitations under the License.  
    <I> void hear(TypeLiteral<I> type, TypeEncounter<I> encounter);
 * SPDX-License-Identifier: Apache-2.0
 * http://www.apache.org/licenses/LICENSE-2.0  
 */
 * Modifications Copyright OpenSearch Contributors. See
     */  
     *                  listeners and binding method interceptors for {@code type}.
 * compatible open source license.
     * @param <I>       the injectable type
 * See the License for the specific language governing permissions and
     * Called during injector creation (or afterwords if Guice encounters a type at run time and
 *
 */
 *
 * The OpenSearch Contributors require contributions made to  
 * one situation but only its methods and fields injected in another, Guice will notify this  
 *
 *
 * Useful for extra type checking, {@linkplain TypeEncounter#register(InjectionListener)  
 * Copyright (C) 2009 Google Inc.  
 *  
    /**  
 *org.opensearch.common.inject.matcher.Matcher, org.aopalliance.intercept.MethodInterceptor[])
 * Listens for Guice to encounter injectable types. If a given type has its constructor injected in
 * registering injection listeners}, and {@code TypeEncounter#bindInterceptor(
