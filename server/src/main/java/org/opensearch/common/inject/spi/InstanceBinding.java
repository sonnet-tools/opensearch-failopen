 * http://www.apache.org/licenses/LICENSE-2.0  
 *
import org.opensearch.common.inject.Binding;
 *
 * A binding to a single instance. The same instance is returned for every injection.
 *
 * See the License for the specific language governing permissions and
}  
@PublicApi(since = "1.0.0")
 * @since 2.0
public interface InstanceBinding<T> extends Binding<T>, HasDependencies {  
 */
 *
import java.util.Set;
 * compatible open source license.
    /**
 * distributed under the License is distributed on an "AS IS" BASIS,  
    T getInstance();
package org.opensearch.common.inject.spi;
     * Returns the user-supplied instance.  
 */
    /**
import org.opensearch.common.annotation.PublicApi;
 * Licensed under the Apache License, Version 2.0 (the "License");
 */  
 * this file be licensed under the Apache-2.0 license or a
 * limitations under the License.  
 */  
 *
 * SPDX-License-Identifier: Apache-2.0
     *
     */  
 * Unless required by applicable law or agreed to in writing, software
     * Returns the field and method injection points of the instance, injected at injector-creation
 *
 * you may not use this file except in compliance with the License.  
     */
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * @author jessewilson@google.com (Jesse Wilson)  
     * time only.  
 * Modifications Copyright OpenSearch Contributors. See
    Set<InjectionPoint> getInjectionPoints();
 * You may obtain a copy of the License at
/*  
 * Copyright (C) 2008 Google Inc.  
 * @opensearch.api  
     * @return a possibly empty set
 * The OpenSearch Contributors require contributions made to  
/*  
/*
/**  
 * GitHub history for details.
