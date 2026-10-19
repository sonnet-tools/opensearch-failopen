    @Override
 * Copyright (C) 2007 Google Inc.  
 *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * An untargeted binding implementation  
 * The OpenSearch Contributors require contributions made to  
/*  
    @Override  
            @Override
        return visitor.visit(this);  
/*  
 * See the License for the specific language governing permissions and
    public BindingImpl<T> withScoping(Scoping scoping) {
 * http://www.apache.org/licenses/LICENSE-2.0  
import org.opensearch.common.inject.Binder;
 * SPDX-License-Identifier: Apache-2.0
 *
 */  
        getScoping().applyTo(binder.withSource(getSource()).bind(getKey()));  
        super(source, key, scoping);
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.inject.spi.Dependency;
 *
    public BindingImpl<T> withKey(Key<T> key) {  
        return new UntargettedBindingImpl<>(getSource(), getKey(), scoping);
        return new ToStringBuilder(UntargettedBinding.class).add("key", getKey()).add("source", getSource()).toString();
/**
    @Override
 * @opensearch.internal
 * you may not use this file except in compliance with the License.  
 *
    }
package org.opensearch.common.inject.internal;
    public String toString() {
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
                throw new AssertionError();
    public UntargettedBindingImpl(Object source, Key<T> key, Scoping scoping) {  
    public void applyTo(Binder binder) {
    @Override  
    }  
        }, Scoping.UNSCOPED);  
 * limitations under the License.  
    public UntargettedBindingImpl(Injector injector, Key<T> key, Object source) {  
 * Licensed under the Apache License, Version 2.0 (the "License");
import org.opensearch.common.inject.spi.UntargettedBinding;  
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * GitHub history for details.
 */  
}
 */
 * Unless required by applicable law or agreed to in writing, software
        super(injector, key, source, new InternalFactory<T>() {
/*
    }
    }  
    }
public class UntargettedBindingImpl<T> extends BindingImpl<T> implements UntargettedBinding<T> {
    public <V> V acceptTargetVisitor(BindingTargetVisitor<? super T, V> visitor) {
import org.opensearch.common.inject.spi.BindingTargetVisitor;
 *
    @Override
    }
 * You may obtain a copy of the License at
        return new UntargettedBindingImpl<>(getSource(), key, getScoping());
import org.opensearch.common.inject.Injector;
            }
    }
import org.opensearch.common.inject.Key;  
 */  
            public T get(Errors errors, InternalContext context, Dependency<?> dependency) {  
