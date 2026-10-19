     * Visit a binding created from converting a bound instance to a new type. The source binding
 */  
    /**  
     * provided type. This target is found only on injector bindings.
 */
 */  
     */  
    /**
 * you may not use this file except in compliance with the License.  
     * Visit a provider key binding. To resolve injections, the provider key is first resolved, then
     */
 * @param <V> any type to be returned by the visit method. Use {@link Void} with  
    /**
     */
     * found in injector bindings.  
    V visit(UntargettedBinding<? extends T> binding);
 * Licensed under the Apache License, Version 2.0 (the "License");
     * that the injector should use its implicit binding strategies to resolve injections.  
     * Visit a provider instance binding. The provider's {@code get} method is invoked to resolve
    V visit(ProviderBinding<? extends T> binding);  
 *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
 * See the License for the specific language governing permissions and
    V visit(LinkedKeyBinding<? extends T> binding);
    V visit(ConstructorBinding<? extends T> binding);
     */  
    V visit(InstanceBinding<? extends T> binding);
     * injections. This target is found in both module and injector bindings.
     * Visit a linked key binding. The other key's binding is used to resolve injections. This
    /**  
     * Visit a instance binding. The same instance is returned for every injection. This target is
/**  
     * bindings.
     */
     * Visit a constructor binding. To resolve injections, an instance is instantiated by invoking
 *            {@code return null} if no return type is needed.
 *  
/*  
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
    V visit(ExposedBinding<? extends T> binding);
     */
    /**
    /**
public interface BindingTargetVisitor<T, V> {
     * that provider's {@code get} method is invoked. This target is found in both module and injector
 * this file be licensed under the Apache-2.0 license or a
     */
    /**
 *
 * Modifications Copyright OpenSearch Contributors. See
/*
 * Visits each of the strategies used to find an instance to satisfy an injection.
 * @since 2.0
import org.opensearch.common.annotation.PublicApi;
     * Visit a binding to a {@link org.opensearch.common.inject.Provider} that delegates to the binding for the  
@PublicApi(since = "1.0.0")  
 * You may obtain a copy of the License at
     * Visit a binding to a key exposed from an enclosed private environment. This target is only
}
/*  
     */
 *
package org.opensearch.common.inject.spi;
    V visit(ConvertedConstantBinding<? extends T> binding);  
 * distributed under the License is distributed on an "AS IS" BASIS,  
 *
     * found in both module and injector bindings.
    /**  
 * http://www.apache.org/licenses/LICENSE-2.0  
     * Visit an untargetted binding. This target is found only on module bindings. It indicates
     * {@code constructor}. This target is found only on injector bindings.  
 * Unless required by applicable law or agreed to in writing, software
    V visit(ProviderKeyBinding<? extends T> binding);
     * target is found in both module and injector bindings.  
     */
    /**
     * bindings.  
 * limitations under the License.  
 * @opensearch.api
 * compatible open source license.
 *
 * Copyright (C) 2008 Google Inc.  
 * The OpenSearch Contributors require contributions made to  
     * has the same binding annotation but a different type. This target is found only on injector  
    V visit(ProviderInstanceBinding<? extends T> binding);
