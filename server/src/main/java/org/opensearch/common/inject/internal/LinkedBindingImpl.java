 * SPDX-License-Identifier: Apache-2.0
    public Key<? extends T> getLinkedKey() {  
    @Override
        this.targetKey = targetKey;
 * GitHub history for details.
import org.opensearch.common.inject.Binder;
import org.opensearch.common.inject.spi.BindingTargetVisitor;
            .toString();
/*  
import org.opensearch.common.inject.spi.LinkedKeyBinding;
        InternalFactory<? extends T> internalFactory,
        getScoping().applyTo(binder.withSource(getSource()).bind(getKey()).to(getLinkedKey()));
        Key<? extends T> targetKey
    public String toString() {
 *
    }  
 * limitations under the License.  
    final Key<? extends T> targetKey;
    @Override  
    public void applyTo(Binder binder) {  
 *
        Scoping scoping,  
    @Override
    @Override  
}  
 *
 * The OpenSearch Contributors require contributions made to  
 */
 * this file be licensed under the Apache-2.0 license or a
    }
    ) {
    }
 *  
        super(source, key, scoping);
/*  
    public BindingImpl<T> withKey(Key<T> key) {
/**
    public LinkedBindingImpl(Object source, Key<T> key, Scoping scoping, Key<? extends T> targetKey) {
    }
    @Override
    }
        Key<T> key,  
        return new ToStringBuilder(LinkedKeyBinding.class).add("key", getKey())  
 * You may obtain a copy of the License at
 * you may not use this file except in compliance with the License.  
        Object source,
            .add("target", targetKey)  
    public <V> V acceptTargetVisitor(BindingTargetVisitor<? super T, V> visitor) {
 *
        return visitor.visit(this);
    }
 * @opensearch.internal
 */  
        super(injector, key, source, internalFactory, scoping);  
            .add("scope", getScoping())
    }
        return targetKey;
 * distributed under the License is distributed on an "AS IS" BASIS,  
/*
 * Linked binding implementation
    @Override
 * Unless required by applicable law or agreed to in writing, software
 * http://www.apache.org/licenses/LICENSE-2.0  
 * compatible open source license.
        return new LinkedBindingImpl<>(getSource(), getKey(), scoping, targetKey);  
 */  
    public BindingImpl<T> withScoping(Scoping scoping) {
import org.opensearch.common.inject.Injector;
            .add("source", getSource())
 */
    }  
 * Copyright (C) 2007 Google Inc.  
import org.opensearch.common.inject.Key;  
        this.targetKey = targetKey;  
public final class LinkedBindingImpl<T> extends BindingImpl<T> implements LinkedKeyBinding<T> {  
        Injector injector,
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed under the Apache License, Version 2.0 (the "License");
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        return new LinkedBindingImpl<>(getSource(), key, getScoping(), targetKey);
package org.opensearch.common.inject.internal;
    public LinkedBindingImpl(
 * See the License for the specific language governing permissions and
