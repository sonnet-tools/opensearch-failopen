    /**  
    V visitNoScoping();  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    V visitScope(Scope scope);  
     * no scope is applied to the binding. An unscoped binding will behave like a scoped one when it  
     */
    V visitScopeAnnotation(Class<? extends Annotation> scopeAnnotation);
 * You may obtain a copy of the License at
/*  
    V visitEagerSingleton();
 * compatible open source license.
 *
     * that implements this scope is registered by {@link org.opensearch.common.inject.Binder#bindScope(Class,
     * Scope) Binder.bindScope()}.
 * SPDX-License-Identifier: Apache-2.0
     * is linked to a scoped binding.
     */  
 * @param <V> any type to be returned by the visit method. Use {@link Void} with  
 * GitHub history for details.
 *
    /**  
    /**
 */  
     */
/*
     * injector should use scoping annotations to find a scope. On an injector, it indicates that
 * Licensed under the Apache License, Version 2.0 (the "License");
/*  
 *
import java.lang.annotation.Annotation;
 * Unless required by applicable law or agreed to in writing, software
 */  
public interface BindingScopingVisitor<V> {
package org.opensearch.common.inject.spi;
     */  
 * this file be licensed under the Apache-2.0 license or a
 * you may not use this file except in compliance with the License.  
     * Visit a scope instance. This scope strategy is found on both module and injector bindings.
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * See the License for the specific language governing permissions and
 */
 * Modifications Copyright OpenSearch Contributors. See
/**  
 * The OpenSearch Contributors require contributions made to  
 *
    /**  
 */
 * limitations under the License.  
     * Visit an eager singleton or single instance. This scope strategy is found on both module and
 *
 * Visits each of the strategies used to scope an injection.
 *  
 *            {@code return null} if no return type is needed.
 * Copyright (C) 2008 Google Inc.  
 * http://www.apache.org/licenses/LICENSE-2.0  
 * @since 2.0
@PublicApi(since = "1.0.0")  
     * Visit an unspecified or unscoped strategy. On a module, this strategy indicates that the
 * @opensearch.api
import org.opensearch.common.inject.Scope;
     * Visit a scope annotation. This scope strategy is found only on module bindings. The instance  
     * injector bindings.
import org.opensearch.common.annotation.PublicApi;
}
