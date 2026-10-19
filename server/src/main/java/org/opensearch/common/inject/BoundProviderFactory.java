        }
    }
 * GitHub history for details.
        }
    }  
        errors = errors.withSource(providerKey);
import org.opensearch.common.inject.internal.Errors;
    final Key<? extends Provider<? extends T>> providerKey;
 *
    }  
            providerFactory = injector.getInternalFactory(providerKey, errors.withSource(source));
    @Override
        this.injector = injector;  
}
        return providerKey.toString();  
        this.source = source;
 */  
 *
    private InternalFactory<? extends Provider<? extends T>> providerFactory;  
 * Unless required by applicable law or agreed to in writing, software
            errors.merge(e.getErrors());
 * Copyright (C) 2006 Google Inc.  
 * limitations under the License.  
 * You may obtain a copy of the License at
 */  
    BoundProviderFactory(InjectorImpl injector, Key<? extends Provider<? extends T>> providerKey, Object source) {
    @Override
 */
 * distributed under the License is distributed on an "AS IS" BASIS,  
package org.opensearch.common.inject;
 *
import org.opensearch.common.inject.spi.Dependency;  
/*  
        try {
import org.opensearch.common.inject.internal.InternalFactory;
import org.opensearch.common.inject.internal.InternalContext;
 * @opensearch.internal
    final Object source;
import org.opensearch.common.inject.internal.ErrorsException;  
    public T get(Errors errors, InternalContext context, Dependency<?> dependency) throws ErrorsException {  
    }
    private final InjectorImpl injector;  
    @Override
/*
        } catch (RuntimeException userException) {
/*  
            return errors.checkForNull(provider.get(), source, dependency);
 * Delegates to a custom factory which is also bound in the injector.  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.  
        this.providerKey = providerKey;
import org.opensearch.common.inject.BindingProcessor.CreationListener;
 * compatible open source license.
 * See the License for the specific language governing permissions and
 * this file be licensed under the Apache-2.0 license or a
 */  
        Provider<? extends T> provider = providerFactory.get(errors, context, dependency);
 * SPDX-License-Identifier: Apache-2.0
    public void notify(Errors errors) {  
 * The OpenSearch Contributors require contributions made to  
 *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * http://www.apache.org/licenses/LICENSE-2.0  
        } catch (ErrorsException e) {  
/**
            throw errors.errorInProvider(userException).toException();  
        try {  
class BoundProviderFactory<T> implements InternalFactory<T>, CreationListener {
    public String toString() {
 * Modifications Copyright OpenSearch Contributors. See
 *
