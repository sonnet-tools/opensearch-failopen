    <T> V visit(ProviderLookup<T> lookup);  
    V visit(PrivateElements elements);
 * The OpenSearch Contributors require contributions made to  
     */  
     * Visit a lookup of the provider for a type.
 */  
 * @param <V> any type to be returned by the visit method. Use {@link Void} with
     */  
     */
     * Visit a request to inject the instance fields and methods of an instance.  
 * Modifications Copyright OpenSearch Contributors. See
    V visit(InjectionRequest<?> request);
 * @since 2.0  
 */  
     * Visit an injectable type listener binding.
    /**
 *            {@code return null} if no return type is needed.
    V visit(ScopeBinding binding);
 * Unless required by applicable law or agreed to in writing, software
public interface ElementVisitor<V> {
     */
     * Visit a request to inject the static fields and methods of type.
 * Visit elements.
     * Visit a registration of type converters for matching target types.
 * GitHub history for details.
     * private binder}.
    <T> V visit(MembersInjectorLookup<T> lookup);
package org.opensearch.common.inject.spi;
/*  
 * compatible open source license.
    /**  
    V visit(StaticInjectionRequest request);
 * limitations under the License.  
 */  
    /**
    V visit(TypeConverterBinding binding);  
 * you may not use this file except in compliance with the License.  
 *
 * You may obtain a copy of the License at
    /**
/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    /**
     * Visit a mapping from a key (type and optional annotation) to the strategy for getting
 * See the License for the specific language governing permissions and
    V visit(Message message);
     */
import org.opensearch.common.inject.Binding;
     */  
     * Visit a lookup of the members injector.  
 * distributed under the License is distributed on an "AS IS" BASIS,  
 *
     */
     * Visit an error message and the context in which it occurred.
     * Visit a collection of configuration elements for a {@linkplain org.opensearch.common.inject.PrivateBinder
     * Visit a registration of a scope annotation with the scope that implements it.
@PublicApi(since = "1.0.0")
 * http://www.apache.org/licenses/LICENSE-2.0  
     */
 */
    /**
 * SPDX-License-Identifier: Apache-2.0
 *
 *
 * @opensearch.api
    /**
     */
     * instances of the type.  
 * Copyright (C) 2008 Google Inc.  
    /**  
 * this file be licensed under the Apache-2.0 license or a
    /**  
    <T> V visit(Binding<T> binding);
import org.opensearch.common.annotation.PublicApi;
}
 *  
    /**  
/*  
 *
/**
     */  
    V visit(TypeListenerBinding binding);  
