 * The OpenSearch Contributors require contributions made to  
 * you may not use this file except in compliance with the License.  
        super(source, key, scoping);  
    public <V> V acceptTargetVisitor(BindingTargetVisitor<? super T, V> visitor) {
    }  
            .toString();
    @Override
import org.opensearch.common.inject.Injector;
    public String toString() {  
/**
import org.opensearch.common.inject.Binder;
        return new ToStringBuilder(ProviderKeyBinding.class).add("key", getKey())
package org.opensearch.common.inject.internal;
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
 * limitations under the License.  
}
    public Key<? extends Provider<? extends T>> getProviderKey() {
    }
 * this file be licensed under the Apache-2.0 license or a
        Scoping scoping,
 *
        Injector injector,  
public final class LinkedProviderBindingImpl<T> extends BindingImpl<T> implements ProviderKeyBinding<T> {
    @Override  
import org.opensearch.common.inject.spi.ProviderKeyBinding;  
    public BindingImpl<T> withKey(Key<T> key) {
        InternalFactory<? extends T> internalFactory,  
 * Copyright (C) 2007 Google Inc.  
            .add("scope", getScoping())  
        Key<? extends Provider<? extends T>> providerKey
    @Override  
    public LinkedProviderBindingImpl(
 *
        getScoping().applyTo(binder.withSource(getSource()).bind(getKey()).toProvider(getProviderKey()));
 */  
 *
    }  
        return visitor.visit(this);  
    }  
        super(injector, key, source, internalFactory, scoping);
    final Key<? extends Provider<? extends T>> providerKey;  
import org.opensearch.common.inject.Provider;
 * compatible open source license.
    }
    public void applyTo(Binder binder) {
        return new LinkedProviderBindingImpl<>(getSource(), key, getScoping(), providerKey);  
    @Override
 * Modifications Copyright OpenSearch Contributors. See
        Key<T> key,
 * GitHub history for details.
 *
        this.providerKey = providerKey;
/*  
    }
 * You may obtain a copy of the License at
        this.providerKey = providerKey;
    }
/*
import org.opensearch.common.inject.spi.BindingTargetVisitor;
 *
    }  
            .add("source", getSource())
/*  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * @opensearch.internal
 * Unless required by applicable law or agreed to in writing, software
 * SPDX-License-Identifier: Apache-2.0
        return new LinkedProviderBindingImpl<>(getSource(), getKey(), scoping, providerKey);
            .add("provider", providerKey)
 * Linked provider binding implementation  
        Object source,
        return providerKey;
    @Override
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * http://www.apache.org/licenses/LICENSE-2.0  
import org.opensearch.common.inject.Key;  
    ) {  
    LinkedProviderBindingImpl(Object source, Key<T> key, Scoping scoping, Key<? extends Provider<? extends T>> providerKey) {
 */  
    @Override
 */  
    public BindingImpl<T> withScoping(Scoping scoping) {  
 * See the License for the specific language governing permissions and
