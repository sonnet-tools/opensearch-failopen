 * @since 2.0  
@PublicApi(since = "1.0.0")
/*  
 */  
/*
 * @author jessewilson@google.com (Jesse Wilson)
 * @opensearch.api
 * limitations under the License.  
     * Returns the linked key used to resolve injections.
 * Copyright (C) 2008 Google Inc.  
 * Licensed under the Apache License, Version 2.0 (the "License");
/*  
}  
 * compatible open source license.
 *
 * you may not use this file except in compliance with the License.  
 */
 *
 * Unless required by applicable law or agreed to in writing, software
 *
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.annotation.PublicApi;
 *
    Key<? extends T> getLinkedKey();
 * this file be licensed under the Apache-2.0 license or a
 * A binding to a linked key. The other key's binding is used to resolve injections.  
    /**
     */  
import org.opensearch.common.inject.Binding;
package org.opensearch.common.inject.spi;
 * See the License for the specific language governing permissions and
 * http://www.apache.org/licenses/LICENSE-2.0  
 */  
 * GitHub history for details.
 *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
import org.opensearch.common.inject.Key;  
public interface LinkedKeyBinding<T> extends Binding<T> {
 *
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at
/**
 */  
