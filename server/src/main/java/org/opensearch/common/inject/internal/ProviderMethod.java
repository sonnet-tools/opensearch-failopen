    // exposed for GIN
 * See the License for the specific language governing permissions and
 * You may obtain a copy of the License at
        List<Provider<?>> parameterProviders,  
    private final Method method;
 * compatible open source license.
    private final Set<Dependency<?>> dependencies;  
import java.util.Set;
 * Unless required by applicable law or agreed to in writing, software
    public Method getMethod() {
        this.method = method;
            binder.bind(key).toProvider(this);
 * this file be licensed under the Apache-2.0 license or a
    private final Object instance;
 */
 * GitHub history for details.
    public Object getInstance() {  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    private final boolean exposed;
package org.opensearch.common.inject.internal;
import org.opensearch.common.inject.Exposed;
 * Copyright (C) 2008 Google Inc.  
}
        }  
 * @opensearch.internal
     */  
 * A provider that invokes a method and returns its result.
        }
 * @author jessewilson@google.com (Jesse Wilson)  
    @Override
    @Override  
 *
 * The OpenSearch Contributors require contributions made to  
        return key;
            // misplaced @Exposed, calling this will add an error to the binder's error queue  
import org.opensearch.common.inject.Key;  
        try {  
        } catch (InvocationTargetException e) {
            ((PrivateBinder) binder).expose(key);
        Class<? extends Annotation> scopeAnnotation
 *
import java.lang.annotation.Annotation;  
 * SPDX-License-Identifier: Apache-2.0
    }
    }  
 * you may not use this file except in compliance with the License.  
        this.parameterProviders = parameterProviders;
    public Key<T> getKey() {  
 *
    }  
    }
        return method;
        } catch (IllegalAccessException e) {
            @SuppressWarnings({ "unchecked" })
import java.util.List;  
    }
import org.opensearch.common.inject.PrivateBinder;
import org.opensearch.common.inject.spi.Dependency;  
     * @param method the method to invoke. Its return type must be the same type as {@code key}.
        this.exposed = method.getAnnotation(Exposed.class) != null;  
        return dependencies;
import org.opensearch.common.inject.Binder;
 */  
/*
 */  
public class ProviderMethod<T> implements ProviderWithDependencies<T> {
            throw new AssertionError(e);  
            // the cast is safe 'cause the only binder we have implements PrivateBinder. If there's a
    private final Key<T> key;
        return instance;
            return result;
        if (exposed) {
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
 * http://www.apache.org/licenses/LICENSE-2.0  
        } else {  
            // We know this cast is safe because T is the method's return type.
    ProviderMethod(
        this.dependencies = dependencies;  
 * Licensed under the Apache License, Version 2.0 (the "License");
        Key<T> key,
    public T get() {  
 *
    ) {
            parameters[i] = parameterProviders.get(i).get();  
            T result = (T) method.invoke(instance, parameters);  
 * Modifications Copyright OpenSearch Contributors. See
        Method method,  
 *
        for (int i = 0; i < parameters.length; i++) {
    /**
            throw new RuntimeException(e);
    }  
        Object instance,
        Set<Dependency<?>> dependencies,
/*  
    public Set<Dependency<?>> getDependencies() {
/**  
/*  
import org.opensearch.common.inject.spi.ProviderWithDependencies;
        Object[] parameters = new Object[parameterProviders.size()];
        if (scopeAnnotation != null) {
        this.key = key;  
    private final Class<? extends Annotation> scopeAnnotation;  
    private final List<Provider<?>> parameterProviders;
            binder.bind(key).toProvider(this).in(scopeAnnotation);
    }
import org.opensearch.common.inject.Provider;
 */  
 * distributed under the License is distributed on an "AS IS" BASIS,  
        this.scopeAnnotation = scopeAnnotation;
 * limitations under the License.  
 *
        }
        binder = binder.withSource(method);
    public void configure(Binder binder) {
        this.instance = instance;
        }
