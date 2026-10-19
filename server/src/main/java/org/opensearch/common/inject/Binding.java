 * <li>Implicitly by the Injector by following a type's {@link ImplementedBy  
 * This is because the applicable scopes and interceptors may not be known until an injector
 * A mapping from a key (type and optional annotation) to the strategy for getting instances of the
 * code. They can be inspected or rewritten, but this analysis must be done statically.</li>
 * @author jessewilson@google.com (Jesse Wilson)
    Key<T> getKey();
 * GitHub history for details.
 * statements:
    /**
     * Accepts a target visitor. Invokes the visitor method specific to this binding's target.  
     *
@PublicApi(since = "1.0.0")
 * Modifications Copyright OpenSearch Contributors. See
     * Accepts a scoping visitor. Invokes the visitor method specific to this binding's scoping.
 * you may not use this file except in compliance with the License.  
/*
 * necessary to satisfy a binding.</li>
 * <li>Explicitly in a module, via {@code bind()} and {@code bindConstant()}
 *     bind(Service.class).annotatedWith(Red.class).to(ServiceImpl.class);
 * Unless required by applicable law or agreed to in writing, software
    /**
 *
 * See the License for the specific language governing permissions and
 */
 * limitations under the License.  
 * Bindings are created in several ways:
 *     bindConstant().annotatedWith(ServerHost.class).to(args[0]);</pre></li>
import org.opensearch.common.inject.spi.BindingTargetVisitor;  
 */
 * @param <T> the bound type. The injected is always assignable to this type.
 *
 * injector. They have full runtime information, including the complete graph of injections
/*  
 * distributed under the License is distributed on an "AS IS" BASIS,  
    /**
 * <li>For {@link Provider providers}, by delegating to the binding for the provided type.</li>
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     *
 * @opensearch.api  
     */
    <V> V acceptScopingVisitor(BindingScopingVisitor<V> visitor);
     */
    Provider<T> getProvider();  
 */  
     * Returns the scoped provider guice uses to fulfill requests for this
 * <pre>  
     * Returns the key for this binding.  
 * default constructor.</li>
     * @since 2.0
public interface Binding<T> extends Element {  
 * is created. From a tool's perspective, module bindings are like the injector's source  
 * <li>By converting a bound instance to a different type.</li>  
 * compatible open source license.
 * You may obtain a copy of the License at
 * SPDX-License-Identifier: Apache-2.0
 * <ul>  
    /**
 *
 * instances. From a tools' perspective, injector bindings are like reflection for an  
 * tools.  
    <V> V acceptTargetVisitor(BindingTargetVisitor<? super T, V> visitor);
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.inject.spi.Element;
import org.opensearch.common.inject.spi.BindingScopingVisitor;
 * </ul>
/**  
     * @since 2.0  
 * http://www.apache.org/licenses/LICENSE-2.0  
 *
 *
     */
 * </ul>  
 * pointer} {@link ProvidedBy annotations} or by using its {@link Inject annotated} or
     *                                       created via {@link org.opensearch.common.inject.spi.Elements#getElements}. This  
 * <li><strong>Module bindings</strong> are incomplete and cannot be used to provide instances.
     *  
     */  
 * @author crazybob@google.com (Bob Lee)  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * Copyright (C) 2008 Google Inc.  
     * @throws UnsupportedOperationException when invoked on a {@link Binding}
 *
 * <p>
 */  
     * @param visitor to call back on
}
     * binding.  
 * <li><strong>Injector bindings</strong> are complete and valid and can be used to provide
 * type. This interface is part of the introspection API and is intended primarily for use by
     *                                       method is only supported on {@link Binding}s returned from an injector.
     * @param visitor to call back on
 *
import org.opensearch.common.annotation.PublicApi;
 * <ul>  
 *  
/*  
 * <p>They exist on both modules and on injectors, and their behaviour is different for each:
package org.opensearch.common.inject;
