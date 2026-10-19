 */  
 * you may not use this file except in compliance with the License.  
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 * compatible open source license.
 * @opensearch.internal
 */
     * Returns the known dependencies for this type. If this has dependencies whose values are not  
/*  
     */
 * limitations under the License.  
 * @since 2.0
 */  
import java.util.Set;
 * Unless required by applicable law or agreed to in writing, software
 * providers} and instances that expose their dependencies explicitly.
/*  
 *
/**  
 * See the License for the specific language governing permissions and
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * this file be licensed under the Apache-2.0 license or a
     * included in the returned set.
}
     * known statically, a dependency for the {@link org.opensearch.common.inject.Injector Injector} will be
 * The OpenSearch Contributors require contributions made to  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * Implemented by {@link org.opensearch.common.inject.Binding bindings}, {@link org.opensearch.common.inject.Provider
public interface HasDependencies {  
 * You may obtain a copy of the License at
 *  
 * Copyright (C) 2008 Google Inc.  
    /**
    Set<Dependency<?>> getDependencies();  
 *  
 */
package org.opensearch.common.inject.spi;
 *
 * http://www.apache.org/licenses/LICENSE-2.0  
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * @author jessewilson@google.com (Jesse Wilson)
     *  
/*
 * SPDX-License-Identifier: Apache-2.0
 *
     * @return a possibly empty set
