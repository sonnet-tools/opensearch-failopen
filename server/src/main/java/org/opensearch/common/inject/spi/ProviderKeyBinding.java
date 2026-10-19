    /**  
 * @author jessewilson@google.com (Jesse Wilson)
 *
@PublicApi(since = "1.0.0")  
 * Unless required by applicable law or agreed to in writing, software
 * compatible open source license.
 */  
public interface ProviderKeyBinding<T> extends Binding<T> {
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * A binding to a provider key. To resolve injections, the provider key is first resolved, then that
/*  
 * limitations under the License.  
     */
 * you may not use this file except in compliance with the License.  
 *  
/*
 */  
import org.opensearch.common.annotation.PublicApi;
 * provider's {@code get} method is invoked.
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.api
 * See the License for the specific language governing permissions and
 * http://www.apache.org/licenses/LICENSE-2.0  
import org.opensearch.common.inject.Provider;
/*  
 * GitHub history for details.
 *
}
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * this file be licensed under the Apache-2.0 license or a
 * Copyright (C) 2008 Google Inc.  
 *
    Key<? extends Provider<? extends T>> getProviderKey();  
 * The OpenSearch Contributors require contributions made to  
     * Returns the key used to resolve the provider's binding.
 */
 */
import org.opensearch.common.inject.Binding;
package org.opensearch.common.inject.spi;
 *  
 * You may obtain a copy of the License at
 * @since 2.0
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.inject.Key;  
 * Licensed under the Apache License, Version 2.0 (the "License");
/**  
