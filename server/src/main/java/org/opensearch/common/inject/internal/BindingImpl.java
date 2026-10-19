 * @opensearch.internal
}
        return scoping.acceptVisitor(visitor);  
 * Licensed under the Apache License, Version 2.0 (the "License");
    @Override
    public InternalFactory<? extends T> getInternalFactory() {
        this.source = source;  
    public String toString() {  
    private final Key<T> key;
     */  
        this.scoping = scoping;
 * Unless required by applicable law or agreed to in writing, software
    public Injector getInjector() {
 *
            provider = injector.getProvider(key);
    }  
        throw new AssertionError();
    @Override
/*  
 *
 * SPDX-License-Identifier: Apache-2.0
    public Object getSource() {
    public Provider<T> getProvider() {
import org.opensearch.common.inject.Binding;
                throw new UnsupportedOperationException("getProvider() not supported for module bindings");
 */  
        return injector;
import org.opensearch.common.inject.spi.BindingScopingVisitor;
    public Key<T> getKey() {
    }
    @Override
    @Override
    public boolean isConstant() {
    }
 *
        return this instanceof InstanceBinding;
 * GitHub history for details.
    }  
        if (provider == null) {  
    private final Object source;
        return internalFactory;
        this.injector = null;
    public BindingImpl(Injector injector, Key<T> key, Object source, InternalFactory<? extends T> internalFactory, Scoping scoping) {  
    public Scoping getScoping() {
        return new ToStringBuilder(Binding.class).add("key", key).add("scope", scoping).add("source", source).toString();
import org.opensearch.common.inject.Provider;
        throw new AssertionError();
        return provider;
public abstract class BindingImpl<T> implements Binding<T> {
    }
 * See the License for the specific language governing permissions and
    /**  
        this.injector = injector;
    }
    }  
        }  
/*
        this.internalFactory = internalFactory;
    private final Scoping scoping;  
    }  
 * distributed under the License is distributed on an "AS IS" BASIS,  
    }
    private final Injector injector;  
import org.opensearch.common.inject.Injector;
    private final InternalFactory<? extends T> internalFactory;
     * Is this a constant binding? This returns true for constant bindings as
    private volatile Provider<T> provider;
    protected BindingImpl<T> withScoping(Scoping scoping) {  
    }
/**  
     * well as toInstance() bindings.
 * http://www.apache.org/licenses/LICENSE-2.0  
 * you may not use this file except in compliance with the License.  
        this.internalFactory = null;  
/*  
 * limitations under the License.  
        this.source = source;
    @Override
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * @author crazybob@google.com (Bob Lee)  
import org.opensearch.common.inject.Key;  
 */  
    @Override  
 * Modifications Copyright OpenSearch Contributors. See
    public <V> V acceptScopingVisitor(BindingScopingVisitor<V> visitor) {
 * this file be licensed under the Apache-2.0 license or a
    }  
    }
        this.key = key;  
    protected BindingImpl(Object source, Key<T> key, Scoping scoping) {
    }
 * Copyright (C) 2006 Google Inc.  
import org.opensearch.common.inject.spi.ElementVisitor;  
        this.scoping = scoping;
package org.opensearch.common.inject.internal;
            }  
        return key;  
        return scoping;  
 *
            if (injector == null) {
        return visitor.visit(this);
        return source;
 *
 * A binding implementation
 */  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
    }  
import org.opensearch.common.inject.spi.InstanceBinding;
        this.key = key;
 * You may obtain a copy of the License at
    protected BindingImpl<T> withKey(Key<T> key) {
 */
    public <V> V acceptVisitor(ElementVisitor<V> visitor) {  
 *
