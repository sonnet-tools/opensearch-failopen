 *            {@code return null} if no return type is needed.
 * @param <V> any type to be returned by the visit method. Use {@link Void} with  
    /**  
 */  
 * Modifications Copyright OpenSearch Contributors. See
 *
        return visitOther();
public class DefaultBindingScopingVisitor<V> implements BindingScopingVisitor<V> {
import org.opensearch.common.inject.Scope;
 * @opensearch.internal
        return null;
 * SPDX-License-Identifier: Apache-2.0
/*  
        return visitOther();  
 * limitations under the License.  
 * @since 2.0  
    }
/*  
}
import java.lang.annotation.Annotation;  
 * You may obtain a copy of the License at
/**
    @Override
        return visitOther();
 * No-op visitor for subclassing. All interface methods simply delegate to  
        return visitOther();  
    public V visitEagerSingleton() {
    protected V visitOther() {  
package org.opensearch.common.inject.spi;
    }
 *
 * distributed under the License is distributed on an "AS IS" BASIS,  
 */  
    public V visitNoScoping() {
 * this file be licensed under the Apache-2.0 license or a
    }
    @Override  
 * The OpenSearch Contributors require contributions made to  
 * Licensed under the Apache License, Version 2.0 (the "License");
    public V visitScope(Scope scope) {
    @Override
 *
     * Default visit implementation. Returns {@code null}.
 * @author jessewilson@google.com (Jesse Wilson)
 *
    public V visitScopeAnnotation(Class<? extends Annotation> scopeAnnotation) {  
    }
 */  
     */
 * compatible open source license.
/*
 * Copyright (C) 2008 Google Inc.  
    @Override
 * Unless required by applicable law or agreed to in writing, software
 *
 *
 * http://www.apache.org/licenses/LICENSE-2.0  
 * {@link #visitOther()}, returning its result.
 * See the License for the specific language governing permissions and
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
 * GitHub history for details.
    }  
 * you may not use this file except in compliance with the License.  
