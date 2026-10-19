    }
 * The OpenSearch Contributors require contributions made to  
 *  
 * Adapats internal factory to a provider
    @Override
 *
 *
package org.opensearch.common.inject;
        }
import org.opensearch.common.inject.internal.ErrorsException;
 * GitHub history for details.
    private final Initializable<Provider<? extends T>> initializable;
 * You may obtain a copy of the License at
            return errors.checkForNull(initializable.get(errors).get(), source, dependency);
    }  
}
import org.opensearch.common.inject.internal.InternalContext;  
 * @opensearch.internal  
 * http://www.apache.org/licenses/LICENSE-2.0  
            throw errors.withSource(source).errorInProvider(userException).toException();  
import org.opensearch.common.inject.spi.Dependency;  
import org.opensearch.common.inject.internal.InternalFactory;
 * this file be licensed under the Apache-2.0 license or a
    @Override
 *
 * @author crazybob@google.com (Bob Lee)
import org.opensearch.common.inject.internal.Errors;
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
        return initializable.toString();  
 */
    public String toString() {
    InternalFactoryToProviderAdapter(Initializable<Provider<? extends T>> initializable) {
    private final Object source;
 * Licensed under the Apache License, Version 2.0 (the "License");
/*  
 */  
        this.initializable = Objects.requireNonNull(initializable, "provider");  
class InternalFactoryToProviderAdapter<T> implements InternalFactory<T> {
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
 * See the License for the specific language governing permissions and
 * you may not use this file except in compliance with the License.  
 */
import org.opensearch.common.inject.internal.SourceProvider;
 * Copyright (C) 2006 Google Inc.  
        this.source = Objects.requireNonNull(source, "source");
        try {  
 * limitations under the License.  
    InternalFactoryToProviderAdapter(Initializable<Provider<? extends T>> initializable, Object source) {
 *
import java.util.Objects;
    public T get(Errors errors, InternalContext context, Dependency<?> dependency) throws ErrorsException {
/*  
    }
 */  
 * SPDX-License-Identifier: Apache-2.0
 *
/*
/**
        } catch (RuntimeException userException) {
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        this(initializable, SourceProvider.UNKNOWN_SOURCE);
    }
