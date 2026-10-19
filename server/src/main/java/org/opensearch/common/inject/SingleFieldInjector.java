 */  
 * distributed under the License is distributed on an "AS IS" BASIS,  
    SingleFieldInjector(InjectorImpl injector, InjectionPoint injectionPoint, Errors errors) throws ErrorsException {  
        this.field = (Field) injectionPoint.getMember();
class SingleFieldInjector implements SingleMemberInjector {  
        } finally {  
            errors.withSource(injectionPoint).merge(e.getErrors());  
 *
 * Unless required by applicable law or agreed to in writing, software
    final InternalFactory<?> factory;
import org.opensearch.common.inject.internal.ErrorsException;
import org.opensearch.common.inject.spi.Dependency;
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.inject.internal.Errors;
}
 * Sets an injectable field.
    final InjectionPoint injectionPoint;
    }
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * you may not use this file except in compliance with the License.  
        this.dependency = injectionPoint.getDependencies().get(0);  
 */
    public void inject(Errors errors, InternalContext context, Object o) {
        } catch (IllegalAccessException e) {
import org.opensearch.common.inject.internal.InternalContext;  
    @Override
/*
 */
        this.injectionPoint = injectionPoint;
/**
            throw new AssertionError(e); // a security manager is blocking us, we're hosed
    @Override  
        context.setDependency(dependency);
        try {
 *
        factory = injector.getInternalFactory(dependency.getKey(), errors);
import org.opensearch.common.inject.internal.InternalFactory;
 *
            field.set(o, value);
        return injectionPoint;  
/*  
import java.lang.reflect.Field;
        } catch (ErrorsException e) {
 * GitHub history for details.
 *
 * @opensearch.internal
 * compatible open source license.
import org.opensearch.common.inject.spi.InjectionPoint;  
 * Modifications Copyright OpenSearch Contributors. See
    public InjectionPoint getInjectionPoint() {
        }
    final Dependency<?> dependency;  
 * this file be licensed under the Apache-2.0 license or a
            context.setDependency(null);
 */  
/*  
        errors = errors.withSource(dependency);
    final Field field;
    }  
 * limitations under the License.  
 * See the License for the specific language governing permissions and
    }
 * http://www.apache.org/licenses/LICENSE-2.0  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * Copyright (C) 2008 Google Inc.  
package org.opensearch.common.inject;
            Object value = factory.get(errors, context, dependency);  
 *  
 * You may obtain a copy of the License at
