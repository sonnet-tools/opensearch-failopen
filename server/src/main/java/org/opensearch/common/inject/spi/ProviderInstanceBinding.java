    /**  
     */  
 */
 * GitHub history for details.
 * @opensearch.api
/*
 *
     *  
 */  
package org.opensearch.common.inject.spi;
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * @author jessewilson@google.com (Jesse Wilson)
 * See the License for the specific language governing permissions and
 */  
import org.opensearch.common.inject.Binding;
    /**
     * time only.
    Provider<? extends T> getProviderInstance();
 * injections.  
}
import java.util.Set;
 * limitations under the License.  
     * @return a possibly empty set
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing, software
 * @since 2.0  
 * http://www.apache.org/licenses/LICENSE-2.0  
/*  
 * you may not use this file except in compliance with the License.  
 * Copyright (C) 2008 Google Inc.  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * SPDX-License-Identifier: Apache-2.0
 * A binding to a provider instance. The provider's {@code get} method is invoked to resolve
 * You may obtain a copy of the License at
 * this file be licensed under the Apache-2.0 license or a
     * Returns the user-supplied, unscoped provider.
 * Modifications Copyright OpenSearch Contributors. See
 */  
     * Returns the field and method injection points of the provider, injected at injector-creation
public interface ProviderInstanceBinding<T> extends Binding<T>, HasDependencies {
 *
 * The OpenSearch Contributors require contributions made to  
/*  
import org.opensearch.common.annotation.PublicApi;
 *
import org.opensearch.common.inject.Provider;  
    Set<InjectionPoint> getInjectionPoints();  
@PublicApi(since = "1.0.0")
     */
/**
 *
 *
