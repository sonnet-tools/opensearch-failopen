        if (constructionContext == null) {
 *
    @SuppressWarnings("unchecked")
import org.opensearch.common.inject.spi.Dependency;
            constructionContexts.put(key, constructionContext);  
 *
        this.dependency = dependency;
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * http://www.apache.org/licenses/LICENSE-2.0  
 * You may obtain a copy of the License at
import java.util.HashMap;  
    private Map<Object, ConstructionContext<?>> constructionContexts = new HashMap<>();
 * Internal context. Used to coordinate injections and support circular
    }  
    public <T> ConstructionContext<T> getConstructionContext(Object key) {
 * limitations under the License.  
    }
/*  
/**  
 * Unless required by applicable law or agreed to in writing, software
 *
 * dependencies.
package org.opensearch.common.inject.internal;
        return dependency;  
 * GitHub history for details.
    public void setDependency(Dependency dependency) {  
 */
 * The OpenSearch Contributors require contributions made to  
        ConstructionContext<T> constructionContext = (ConstructionContext<T>) constructionContexts.get(key);  
            constructionContext = new ConstructionContext<>();
    }
 * you may not use this file except in compliance with the License.  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
 */
 *
 * See the License for the specific language governing permissions and
 */  
        return constructionContext;
 * @opensearch.internal  
        }
public final class InternalContext {
 *  
 *
    public Dependency getDependency() {
 * this file be licensed under the Apache-2.0 license or a
 * Licensed under the Apache License, Version 2.0 (the "License");
import java.util.Map;
/*
}  
 */  
 * distributed under the License is distributed on an "AS IS" BASIS,  
    private Dependency dependency;
 * Modifications Copyright OpenSearch Contributors. See
 * Copyright (C) 2006 Google Inc.  
 * @author crazybob@google.com (Bob Lee)
/*  
