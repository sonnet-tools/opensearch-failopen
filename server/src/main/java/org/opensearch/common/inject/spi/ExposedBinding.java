import org.opensearch.common.annotation.PublicApi;
 *
public interface ExposedBinding<T> extends Binding<T>, HasDependencies {
import org.opensearch.common.inject.Binding;  
/**
 * Copyright (C) 2008 Google Inc.  
 */
import org.opensearch.common.inject.Binder;
    @Override  
 * You may obtain a copy of the License at
 * GitHub history for details.
/*  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */  
package org.opensearch.common.inject.spi;
/*
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * Modifications Copyright OpenSearch Contributors. See
    void applyTo(Binder binder);
 * limitations under the License.  
 */  
 * @opensearch.api
    PrivateElements getPrivateElements();
 * Licensed under the Apache License, Version 2.0 (the "License");
     */
    /**  
     * Unsupported. Always throws {@link UnsupportedOperationException}.
/*  
 *
 * @author jessewilson@google.com (Jesse Wilson)
 * SPDX-License-Identifier: Apache-2.0
 *
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 *
    /**
 *
 */  
 * @since 2.0  
 * The OpenSearch Contributors require contributions made to  
 *
     */  
 * See the License for the specific language governing permissions and
     * Returns the enclosed environment that holds the original binding.
 * A binding to a key exposed from an enclosed private environment.  
 * Unless required by applicable law or agreed to in writing, software
@PublicApi(since = "1.0.0")
 * you may not use this file except in compliance with the License.  
 * http://www.apache.org/licenses/LICENSE-2.0  
}
