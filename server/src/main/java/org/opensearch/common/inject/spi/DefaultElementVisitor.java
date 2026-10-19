/**  
 */  
        return visitOther(binding);
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
    @Override  
    public V visit(InjectionRequest<?> injectionRequest) {
    @Override
 * Copyright (C) 2008 Google Inc.  
    /**
    }  
        return visitOther(typeConverterBinding);
    public V visit(Message message) {  
 *
 * GitHub history for details.
 *            {@code return null} if no return type is needed.
}  
        return visitOther(providerLookup);  
 */
    public <T> V visit(ProviderLookup<T> providerLookup) {
        return visitOther(scopeBinding);
 * limitations under the License.  
public abstract class DefaultElementVisitor<V> implements ElementVisitor<V> {
        return visitOther(staticInjectionRequest);
 */  
    @Override
 *
        return visitOther(binding);  
    }
 */
    }  
    }  
/*
        return visitOther(injectionRequest);
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        return visitOther(lookup);
/*  
    public V visit(TypeListenerBinding binding) {  
    }
    @Override
package org.opensearch.common.inject.spi;
    public V visit(TypeConverterBinding typeConverterBinding) {  
 * SPDX-License-Identifier: Apache-2.0
 * @param <V> any type to be returned by the visit method. Use {@link Void} with
    @Override  
 * {@link #visitOther(Element)}, returning its result.
 * The OpenSearch Contributors require contributions made to  
    @Override
 * You may obtain a copy of the License at
    }  
 *
    @Override  
 * See the License for the specific language governing permissions and
    @Override
 * this file be licensed under the Apache-2.0 license or a
 * you may not use this file except in compliance with the License.  
    public V visit(PrivateElements privateElements) {
    public <T> V visit(Binding<T> binding) {
import org.opensearch.common.inject.Binding;
 * Modifications Copyright OpenSearch Contributors. See
    }
 *
 * Unless required by applicable law or agreed to in writing, software
    public <T> V visit(MembersInjectorLookup<T> lookup) {
        return null;
    }
        return visitOther(message);
 * @opensearch.internal  
/*  
 * No-op visitor for subclassing. All interface methods simply delegate to
        return visitOther(privateElements);  
    public V visit(StaticInjectionRequest staticInjectionRequest) {  
     * Default visit implementation. Returns {@code null}.
    }
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * http://www.apache.org/licenses/LICENSE-2.0  
 * @since 2.0
    protected V visitOther(Element element) {
 *  
    public V visit(ScopeBinding scopeBinding) {
    }
    @Override
     */  
    }
 * @author sberlin@gmail.com (Sam Berlin)  
 * compatible open source license.
    @Override
