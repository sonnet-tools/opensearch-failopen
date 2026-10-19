 * @since 2.0
 *  
 * See the License for the specific language governing permissions and
import org.opensearch.common.annotation.PublicApi;
 * A binding to a {@link Provider} that delegates to the binding for the provided type. This binding
/*  
 * SPDX-License-Identifier: Apache-2.0
}
 *
 * Modifications Copyright OpenSearch Contributors. See
 * @author jessewilson@google.com (Jesse Wilson)
 *
 * is used whenever a {@code Provider<T>} is injected (as opposed to injecting {@code T} directly).
    Key<?> getProvidedKey();  
import org.opensearch.common.inject.Binding;
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
 *
    /**  
 *  
package org.opensearch.common.inject.spi;
 * limitations under the License.  
 * http://www.apache.org/licenses/LICENSE-2.0  
 * You may obtain a copy of the License at
 */  
 * Copyright (C) 2008 Google Inc.  
 * GitHub history for details.
/*
 */  
/**  
import org.opensearch.common.inject.Provider;
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
public interface ProviderBinding<T extends Provider<?>> extends Binding<T> {
     */
 * Unless required by applicable law or agreed to in writing, software
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.api
 *
     * Returns the key whose binding is used to {@link Provider#get provide instances}.
import org.opensearch.common.inject.Key;  
 * distributed under the License is distributed on an "AS IS" BASIS,  
 */
/*  
@PublicApi(since = "1.0.0")  
 * you may not use this file except in compliance with the License.  
 * compatible open source license.
