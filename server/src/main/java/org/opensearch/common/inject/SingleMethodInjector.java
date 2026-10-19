            return;
    final InjectionPoint injectionPoint;
        Object[] parameters;
 * Modifications Copyright OpenSearch Contributors. See
 *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * The OpenSearch Contributors require contributions made to  
        try {
 * Invokes an injectable method.  
/*  
 * Copyright (C) 2008 Google Inc.  
import org.opensearch.common.inject.internal.ErrorsException;  
        methodInvoker = createMethodInvoker(method);  
            errors.withSource(injectionPoint).errorInjectingMethod(cause);
package org.opensearch.common.inject;
class SingleMethodInjector implements SingleMemberInjector {
/*
        } catch (InvocationTargetException userException) {
    }  
 */  
import java.lang.reflect.InvocationTargetException;
            throw new AssertionError(e); // a security manager is blocking us, we're hosed
    @Override  
            parameters = SingleParameterInjector.getAll(errors, context, parameterInjectors);
        }  
    final SingleParameterInjector<?>[] parameterInjectors;  
 */  
 */  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
            }  
            errors.merge(e.getErrors());  
import java.lang.reflect.Method;
 * this file be licensed under the Apache-2.0 license or a
        }
        return injectionPoint;  
}
 * Licensed under the Apache License, Version 2.0 (the "License");
        if (!Modifier.isPrivate(modifiers) && !Modifier.isProtected(modifiers)) {
 *
 * @opensearch.internal
 * See the License for the specific language governing permissions and
 * you may not use this file except in compliance with the License.  
 * http://www.apache.org/licenses/LICENSE-2.0  
            public Object invoke(Object target, Object... parameters) throws IllegalAccessException, InvocationTargetException {
 * compatible open source license.
    }
    }
 *
 * limitations under the License.  
        };
 *
    public InjectionPoint getInjectionPoint() {
    SingleMethodInjector(InjectorImpl injector, InjectionPoint injectionPoint, Errors errors) throws ErrorsException {  
        return new MethodInvoker() {
        parameterInjectors = injector.getParametersInjectors(injectionPoint.getDependencies(), errors);
                return method.invoke(target, parameters);
            Throwable cause = userException.getCause() != null ? userException.getCause() : userException;  
    private MethodInvoker createMethodInvoker(final Method method) {
    final MethodInvoker methodInvoker;
import org.opensearch.common.inject.internal.InternalContext;
import org.opensearch.common.inject.spi.InjectionPoint;
 * GitHub history for details.
    @Override
        } catch (IllegalAccessException e) {  
        } catch (ErrorsException e) {
 * SPDX-License-Identifier: Apache-2.0
            methodInvoker.invoke(o, parameters);
        }
    }
import java.lang.reflect.Modifier;  
        this.injectionPoint = injectionPoint;
 *
/*  
import org.opensearch.common.inject.InjectorImpl.MethodInvoker;
            @Override  
    public void inject(Errors errors, InternalContext context, Object o) {
        // We can't use FastMethod if the method is private.  
        int modifiers = method.getModifiers();
        try {  
 */
        final Method method = (Method) injectionPoint.getMember();
/**
 * You may obtain a copy of the License at
import org.opensearch.common.inject.internal.Errors;
