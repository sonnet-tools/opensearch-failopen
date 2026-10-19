/**  
 * you may not use this file except in compliance with the License.  
     *                                of the valid injection points.  
 * distributed under the License is distributed on an "AS IS" BASIS,  
/*
import org.opensearch.common.inject.Binder;
 * Copyright (C) 2008 Google Inc.  
        return visitor.visit(this);
 *     requestInjection(serviceInstance);</pre>
 * requestInjection()} statements:  
    @Override
 * Modifications Copyright OpenSearch Contributors. See
        return source;  
 * @since 2.0
}  
package org.opensearch.common.inject.spi;
/*  
     *         before subtype fields. Similarly, supertype methods are returned before subtype methods.
 * <pre>
public final class InjectionRequest<T> implements Element {
@PublicApi(since = "1.0.0")  
import org.opensearch.common.annotation.PublicApi;
 * http://www.apache.org/licenses/LICENSE-2.0  
    public InjectionRequest(Object source, TypeLiteral<T> type, T instance) {
 * You may obtain a copy of the License at
 * @author mikeward@google.com (Mike Ward)
        this.type = Objects.requireNonNull(type, "type");  
 * SPDX-License-Identifier: Apache-2.0
 */  
     */
     *                                ConfigurationException#getPartialValue() partial value} is a {@code Set<InjectionPoint>}
 *
 * See the License for the specific language governing permissions and
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 * explicitly in a module using {@link org.opensearch.common.inject.Binder#requestInjection(Object)
 * Unless required by applicable law or agreed to in writing, software
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        binder.withSource(getSource()).requestInjection(type, instance);
    }
import org.opensearch.common.inject.TypeLiteral;
 * limitations under the License.  
     * Returns the instance methods and fields of {@code instance} that will be injected to fulfill  
     *                                instance}, such as a field with multiple binding annotations. The exception's {@link
     *         fields are returned and then all methods. Within the fields, supertype fields are returned
    public T getInstance() {  
 * compatible open source license.
    }  
import java.util.Objects;  
 * A request to inject the instance fields and methods of an instance. Requests are created
/*  
    /**
        this.instance = Objects.requireNonNull(instance, "instance");
 *
 */  
    }
    }
 * this file be licensed under the Apache-2.0 license or a
    private final TypeLiteral<T> type;
    }  
        return InjectionPoint.forInstanceMethodsAndFields(instance.getClass());  
        return type;
 */
        this.source = Objects.requireNonNull(source, "source");
 * The OpenSearch Contributors require contributions made to  
    public Object getSource() {
    public <R> R acceptVisitor(ElementVisitor<R> visitor) {
    }
 * @opensearch.api
    @Override  
     * @return a possibly empty set of injection points. The set has a specified iteration order. All  
 * GitHub history for details.
    public TypeLiteral<T> getType() {
    @Override
    public void applyTo(Binder binder) {  
 */
 *  
import java.util.Set;
     * this request.
    }
 *  
    public Set<InjectionPoint> getInjectionPoints() throws ConfigurationException {
        return instance;
     * @throws ConfigurationException if there is a malformed injection point on the class of {@code  
import org.opensearch.common.inject.ConfigurationException;  
 *
    private final Object source;  
    private final T instance;
     *
