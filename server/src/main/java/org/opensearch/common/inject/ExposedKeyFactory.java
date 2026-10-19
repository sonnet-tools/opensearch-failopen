        // its parent's binding instead
 * You may obtain a copy of the License at
 * distributed under the License is distributed on an "AS IS" BASIS,  
        InjectorImpl privateInjector = (InjectorImpl) privateElements.getInjector();  
    @Override
 *
 *  
}  
    }
 * http://www.apache.org/licenses/LICENSE-2.0  
            errors.withSource(explicitBinding.getSource()).exposedButNotBound(key);
 * GitHub history for details.
/**  
 * SPDX-License-Identifier: Apache-2.0
        this.key = key;  
class ExposedKeyFactory<T> implements InternalFactory<T>, BindingProcessor.CreationListener {  
 *
 * this file be licensed under the Apache-2.0 license or a
    ExposedKeyFactory(Key<T> key, PrivateElements privateElements) {
    }  
import org.opensearch.common.inject.spi.Dependency;  
        return delegate.getInternalFactory().get(errors, context, dependency);
 * Modifications Copyright OpenSearch Contributors. See
    public void notify(Errors errors) {
    private final Key<T> key;
        if (explicitBinding.getInternalFactory() == this) {  
 * injector.
        this.delegate = explicitBinding;
 * Licensed under the Apache License, Version 2.0 (the "License");
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.inject.internal.InternalContext;
/*
    private BindingImpl<T> delegate;  
        BindingImpl<T> explicitBinding = privateInjector.state.getExplicitBinding(key);
        // validate that the child injector has its own factory. If the getInternalFactory() returns  
 *
    public T get(Errors errors, InternalContext context, Dependency<?> dependency) throws ErrorsException {  
import org.opensearch.common.inject.internal.ErrorsException;  
 *
 */  
import org.opensearch.common.inject.spi.PrivateElements;
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
/*  
    @Override
/*  
        this.privateElements = privateElements;
 * compatible open source license.
 * This factory exists in a parent injector. When invoked, it retrieves its value from a child
 * Copyright (C) 2008 Google Inc.  
 * limitations under the License.  
            return;
import org.opensearch.common.inject.internal.BindingImpl;
    private final PrivateElements privateElements;
 */
 * @opensearch.internal
 * See the License for the specific language governing permissions and
 */  
 */
        // this, then that child injector doesn't have a factory (and getExplicitBinding has returned
    }
 * Unless required by applicable law or agreed to in writing, software
package org.opensearch.common.inject;
        }  
 * you may not use this file except in compliance with the License.  
import org.opensearch.common.inject.internal.InternalFactory;
import org.opensearch.common.inject.internal.Errors;
