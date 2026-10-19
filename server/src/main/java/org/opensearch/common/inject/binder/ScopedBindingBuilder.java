 * you may not use this file except in compliance with the License.  
    void in(Scope scope);  
import java.lang.annotation.Annotation;
 * You may obtain a copy of the License at
 */
     */
 */  
 * See the License for the specific language governing permissions and
 * GitHub history for details.
    /**
 * Copyright (C) 2006 Google Inc.  
     */  
public interface ScopedBindingBuilder {
@PublicApi(since = "1.0.0")
 * @author crazybob@google.com (Bob Lee)  
/*
    /**
 *
 * See the EDSL examples at {@link org.opensearch.common.inject.Binder}.
 * limitations under the License.  
 *
}  
 *
/*  
     * See the EDSL examples at {@link org.opensearch.common.inject.Binder}.
    void in(Class<? extends Annotation> scopeAnnotation);
 *
     * {@link org.opensearch.common.inject.Binder}.  
 */  
    /**  
     */
     * Instructs the {@link org.opensearch.common.inject.Injector} to eagerly initialize this  
import org.opensearch.common.annotation.PublicApi;
 * Unless required by applicable law or agreed to in writing, software
 * compatible open source license.
     * See the EDSL examples at {@link org.opensearch.common.inject.Binder}.
package org.opensearch.common.inject.binder;
/*  
 * @opensearch.api
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
     * singleton-scoped binding upon creation. Useful for application
 * The OpenSearch Contributors require contributions made to  
     * initialization logic.  See the EDSL examples at
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    void asEagerSingleton();
 */  
 * Modifications Copyright OpenSearch Contributors. See
 * distributed under the License is distributed on an "AS IS" BASIS,  
/**  
 *
import org.opensearch.common.inject.Scope;
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * http://www.apache.org/licenses/LICENSE-2.0  
