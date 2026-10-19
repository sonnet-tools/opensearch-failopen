            membersInjector.notifyListeners(t, errors);
 * Creates instances using an injectable constructor. After construction, all injectable fields and
        // If we're re-entering this factory while injecting fields or methods,
        }  
 */
        return injectableMembers;
        try {
import org.opensearch.common.inject.internal.InternalContext;
import org.opensearch.common.inject.spi.InjectionPoint;
            return constructionContext.createProxy(errors, expectedType);
import org.opensearch.common.inject.internal.Errors;
 * you may not use this file except in compliance with the License.  
 */
import java.lang.reflect.InvocationTargetException;
                constructionContext.finishConstruction();
 * SPDX-License-Identifier: Apache-2.0
/*
                constructionContext.setProxyDelegates(t);
            return t;
     * it may return a proxy.
/*  
    private final Set<InjectionPoint> injectableMembers;
        if (constructionContext.isConstructing()) {
 */  
        MembersInjectorImpl<T> membersInjector
        } catch (InvocationTargetException userException) {
 * @opensearch.internal
        ConstructionContext<T> constructionContext = context.getConstructionContext(this);
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    private final ConstructionProxy<T> constructionProxy;
 * this file be licensed under the Apache-2.0 license or a
        T t = constructionContext.getCurrentReference();  
 *
    ) throws ErrorsException {  
            // Store reference. If an injector re-enters this factory, they'll get the same reference.
 * http://www.apache.org/licenses/LICENSE-2.0  
 *
 *
 */  
 * Copyright (C) 2006 Google Inc.  
        this.membersInjector = membersInjector;
    /**  
 * compatible open source license.
        SingleParameterInjector<?>[] parameterInjectors,
 *
 * The OpenSearch Contributors require contributions made to  
 * limitations under the License.  
    }
 * distributed under the License is distributed on an "AS IS" BASIS,  
import java.util.Set;
        Set<InjectionPoint> injectableMembers,
    ConstructorInjector(
        this.constructionProxy = constructionProxy;
 * Unless required by applicable law or agreed to in writing, software
            constructionContext.startConstruction();
            try {
    }
            Throwable cause = userException.getCause() != null ? userException.getCause() : userException;  
            constructionContext.removeCurrentReference();  
            // First time through...  
 *  
/*  
            throw errors.withSource(constructionProxy.getInjectionPoint()).errorInjectingConstructor(cause).toException();
            constructionContext.setCurrentReference(t);
            } finally {  
package org.opensearch.common.inject;
            return t;
    private final SingleParameterInjector<?>[] parameterInjectors;  
        return constructionProxy;  
        if (t != null) {
 * Licensed under the Apache License, Version 2.0 (the "License");
        this.parameterInjectors = parameterInjectors;  
    ConstructionProxy<T> getConstructionProxy() {
    }
/**
    private final MembersInjectorImpl<T> membersInjector;
 * @author crazybob@google.com (Bob Lee)
}  
            // TODO (crazybob): if we can't proxy this object, can we proxy the other object?  
        ConstructionProxy<T> constructionProxy,  
class ConstructorInjector<T> {  
import org.opensearch.common.inject.internal.ConstructionContext;
            membersInjector.injectMembers(t, errors, context);
 * Modifications Copyright OpenSearch Contributors. See
        } finally {
                t = constructionProxy.newInstance(parameters);
import org.opensearch.common.inject.internal.ErrorsException;  
    }  
 * You may obtain a copy of the License at
        // return the same instance. This prevents infinite loops.
     */  
    Object construct(Errors errors, InternalContext context, Class<?> expectedType) throws ErrorsException {
 * GitHub history for details.
 * methods are injected.  
        this.injectableMembers = injectableMembers;
        }
     * Construct an instance. Returns {@code Object} instead of {@code T} because
                Object[] parameters = SingleParameterInjector.getAll(errors, context, parameterInjectors);  
 *
 * See the License for the specific language governing permissions and
        }
            }
    public Set<InjectionPoint> getInjectableMembers() {
        // We have a circular reference between constructors. Return a proxy.
