 * Unless required by applicable law or agreed to in writing, software
}  
            .toString();
        return this.provider;  
    public InstanceBindingImpl(
 *
/*  
    public BindingImpl<T> withScoping(Scoping scoping) {
import org.opensearch.common.inject.Provider;
 * SPDX-License-Identifier: Apache-2.0
import java.util.Set;
 *
 */
 *
    final T instance;  
    public Set<InjectionPoint> getInjectionPoints() {
/*  
    ) {
        InternalFactory<? extends T> internalFactory,
        Object source,
    }
    }
 * Modifications Copyright OpenSearch Contributors. See
    @Override  
    }
 * The OpenSearch Contributors require contributions made to  
            : Dependency.forInjectionPoints(injectionPoints);
    public String toString() {  
    public InstanceBindingImpl(Object source, Key<T> key, Scoping scoping, Set<InjectionPoint> injectionPoints, T instance) {  
        return visitor.visit(this);
 */  
            ? unmodifiableSet(new HashSet<>((((HasDependencies) instance).getDependencies())))  
        this.injectionPoints = injectionPoints;
/**
 * distributed under the License is distributed on an "AS IS" BASIS,  
import java.util.HashSet;  
import org.opensearch.common.inject.spi.HasDependencies;
        this.instance = instance;  
    }  
import org.opensearch.common.inject.spi.InjectionPoint;
    }
    @Override  
    @Override  
package org.opensearch.common.inject.internal;
import org.opensearch.common.inject.Binder;
    @Override
        return new ToStringBuilder(InstanceBinding.class).add("key", getKey())
import org.opensearch.common.inject.Injector;
    public Provider<T> getProvider() {
        this.provider = Providers.of(instance);
 * Instance binding implementation  
    public Set<Dependency<?>> getDependencies() {
 * Copyright (C) 2008 Google Inc.  
        T instance
        Key<T> key,  
        this.instance = instance;
        return new InstanceBindingImpl<>(getSource(), key, getScoping(), injectionPoints, instance);
        Set<InjectionPoint> injectionPoints,  
    @Override
 * this file be licensed under the Apache-2.0 license or a
        this.injectionPoints = injectionPoints;
import org.opensearch.common.inject.spi.BindingTargetVisitor;
    }
    }  
    }  
 * http://www.apache.org/licenses/LICENSE-2.0  
    @Override
 * limitations under the License.  
 */  
        return injectionPoints;  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
import static java.util.Collections.unmodifiableSet;  
import org.opensearch.common.inject.Key;  
        // instance bindings aren't scoped
        binder.withSource(getSource()).bind(getKey()).toInstance(instance);
 * You may obtain a copy of the License at
import org.opensearch.common.inject.spi.Dependency;  
    public BindingImpl<T> withKey(Key<T> key) {
    @Override
    @Override
    public <V> V acceptTargetVisitor(BindingTargetVisitor<? super T, V> visitor) {
    public void applyTo(Binder binder) {  
    public T getInstance() {  
 *
    }
 *
    final Provider<T> provider;
        return instance instanceof HasDependencies
    }
        this.provider = Providers.of(instance);  
 */  
 * GitHub history for details.
        super(source, key, scoping);
        return instance;
/*
 * See the License for the specific language governing permissions and
            .add("instance", instance)  
 * Licensed under the Apache License, Version 2.0 (the "License");
public class InstanceBindingImpl<T> extends BindingImpl<T> implements InstanceBinding<T> {
    @Override
    final Set<InjectionPoint> injectionPoints;
 * you may not use this file except in compliance with the License.  
        super(injector, key, source, internalFactory, Scoping.UNSCOPED);  
        Injector injector,
 * compatible open source license.
            .add("source", getSource())
import org.opensearch.common.inject.spi.InstanceBinding;  
 * @opensearch.internal
import org.opensearch.common.inject.util.Providers;
    }
        return new InstanceBindingImpl<>(getSource(), getKey(), scoping, injectionPoints, instance);  
