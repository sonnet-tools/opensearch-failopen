    @Override
        Provider<? extends T> providerInstance  
    @Override
        InternalFactory<? extends T> internalFactory,  
/*
        return injectionPoints;
public final class ProviderInstanceBindingImpl<T> extends BindingImpl<T> implements ProviderInstanceBinding<T> {  
        return new ToStringBuilder(ProviderInstanceBinding.class).add("key", getKey())
        getScoping().applyTo(binder.withSource(getSource()).bind(getKey()).toProvider(getProviderInstance()));
 * SPDX-License-Identifier: Apache-2.0
        return new ProviderInstanceBindingImpl<>(getSource(), key, getScoping(), injectionPoints, providerInstance);  
Licensed under the Apache License, Version 2.0 (the "License");
    ) {
    }  
            .add("source", getSource())
    public BindingImpl<T> withScoping(Scoping scoping) {  
        Key<T> key,
import org.opensearch.common.inject.spi.ProviderInstanceBinding;  
            .toString();
    }
        return providerInstance instanceof HasDependencies  
        Scoping scoping,
import java.util.Set;  
    @Override
 * GitHub history for details.
    }
    }
    @Override  
    public void applyTo(Binder binder) {
        this.injectionPoints = injectionPoints;  
import org.opensearch.common.inject.spi.HasDependencies;
        Set<InjectionPoint> injectionPoints  
*/
import org.opensearch.common.inject.Key;  
import java.util.HashSet;
See the License for the specific language governing permissions and
distributed under the License is distributed on an "AS IS" BASIS,  
            .add("scope", getScoping())  
import org.opensearch.common.inject.spi.Dependency;  
    @Override  
    public Set<InjectionPoint> getInjectionPoints() {  
        return providerInstance;
}
    }  
        Scoping scoping,
        Object source,
    }
import org.opensearch.common.inject.spi.InjectionPoint;
    public ProviderInstanceBindingImpl(
        Key<T> key,  
import org.opensearch.common.inject.Binder;
    @Override
Copyright (C) 2007 Google Inc.  
        this.providerInstance = providerInstance;  
    public Set<Dependency<?>> getDependencies() {
    public Provider<? extends T> getProviderInstance() {
    public ProviderInstanceBindingImpl(
    public String toString() {  
import org.opensearch.common.inject.Provider;
 * @opensearch.internal
    @Override
You may obtain a copy of the License at
 *  
/*  
    @Override
    final Set<InjectionPoint> injectionPoints;  
    }
    }
 */
    public <V> V acceptTargetVisitor(BindingTargetVisitor<? super T, V> visitor) {
    public BindingImpl<T> withKey(Key<T> key) {
 * this file be licensed under the Apache-2.0 license or a
        Object source,
import org.opensearch.common.inject.spi.BindingTargetVisitor;
        this.providerInstance = providerInstance;
        return new ProviderInstanceBindingImpl<>(getSource(), getKey(), scoping, injectionPoints, providerInstance);
/**
    final Provider<? extends T> providerInstance;
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
            ? unmodifiableSet(new HashSet<>((((HasDependencies) providerInstance).getDependencies())))
        return visitor.visit(this);  
    }  
limitations under the License.  
    ) {
you may not use this file except in compliance with the License.  
 * Provider instance binding
 * Modifications Copyright OpenSearch Contributors. See
        super(source, key, scoping);
     http://www.apache.org/licenses/LICENSE-2.0  
        Injector injector,  
    }  
/*  
        Provider<? extends T> providerInstance,
package org.opensearch.common.inject.internal;
            .add("provider", providerInstance)
 */  
Unless required by applicable law or agreed to in writing, software
        this.injectionPoints = injectionPoints;
import static java.util.Collections.unmodifiableSet;
        Set<InjectionPoint> injectionPoints,
 *
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
        super(injector, key, source, internalFactory, scoping);
            : Dependency.forInjectionPoints(injectionPoints);
import org.opensearch.common.inject.Injector;
 */  
