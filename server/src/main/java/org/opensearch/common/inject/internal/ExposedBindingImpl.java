    public void applyTo(Binder binder) {  
            .add("source", getSource())  
 *
import org.opensearch.common.inject.Key;  
    }  
 */  
        this.privateElements = privateElements;
        super(source, key, scoping);
 * Licensed under the Apache License, Version 2.0 (the "License");
    public Set<Dependency<?>> getDependencies() {
    public ExposedBindingImpl(Object source, Key<T> key, Scoping scoping, PrivateElements privateElements) {  
 *
    public ExposedBindingImpl<T> withKey(Key<T> key) {
    public ExposedBindingImpl(Injector injector, Object source, Key<T> key, InternalFactory<T> factory, PrivateElements privateElements) {
 * compatible open source license.
            .add("privateElements", privateElements)
    }
    }  
public class ExposedBindingImpl<T> extends BindingImpl<T> implements ExposedBinding<T> {  
import org.opensearch.common.inject.spi.PrivateElements;
 * See the License for the specific language governing permissions and
import org.opensearch.common.inject.spi.ExposedBinding;  
 * GitHub history for details.
    }
    public <V> V acceptTargetVisitor(BindingTargetVisitor<? super T, V> visitor) {  
    }
 * Unless required by applicable law or agreed to in writing, software
 * SPDX-License-Identifier: Apache-2.0
    @Override
        this.privateElements = privateElements;  
        return new ExposedBindingImpl<>(getSource(), key, getScoping(), privateElements);  
 */
        return privateElements;
    public String toString() {
import static java.util.Collections.singleton;
 * You may obtain a copy of the License at
    @Override
    }  
            .toString();
 * you may not use this file except in compliance with the License.  
    @Override  
 * @opensearch.internal
 * distributed under the License is distributed on an "AS IS" BASIS,  
import java.util.Set;  
        return singleton(Dependency.get(Key.get(Injector.class)));  
}  
import org.opensearch.common.inject.spi.Dependency;
 *
 */  
import org.opensearch.common.inject.Binder;
        return visitor.visit(this);
        super(injector, key, source, factory, Scoping.UNSCOPED);
    @Override
 * this file be licensed under the Apache-2.0 license or a
    }
 * Copyright (C) 2008 Google Inc.  
    public BindingImpl<T> withScoping(Scoping scoping) {  
        throw new UnsupportedOperationException("This element represents a synthetic binding.");
 *  
 * limitations under the License.  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
/*
 * Exposed binding implementation
import org.opensearch.common.inject.spi.BindingTargetVisitor;
    @Override
 * Modifications Copyright OpenSearch Contributors. See
    public PrivateElements getPrivateElements() {
    @Override  
import org.opensearch.common.inject.Injector;
    @Override
 *
        return new ExposedBindingImpl<>(getSource(), getKey(), scoping, privateElements);
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.common.inject.internal;
    }
    }
/*  
    private final PrivateElements privateElements;
 * http://www.apache.org/licenses/LICENSE-2.0  
/*  
/**
        return new ToStringBuilder(ExposedBinding.class).add("key", getKey())
