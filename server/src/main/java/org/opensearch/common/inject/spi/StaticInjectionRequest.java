    }
 * See the License for the specific language governing permissions and
}
 * you may not use this file except in compliance with the License.  
/**
    StaticInjectionRequest(Object source, Class<?> type) {
import java.util.Set;  
        this.source = Objects.requireNonNull(source, "source");
 *     requestStaticInjection(MyLegacyService.class);</pre>
 * explicitly in a module using {@link org.opensearch.common.inject.Binder#requestStaticInjection(Class[])
    @Override  
 * Licensed under the Apache License, Version 2.0 (the "License");
import org.opensearch.common.annotation.PublicApi;
     *  
    }
    }
     * @return a possibly empty set of injection points. The set has a specified iteration order. All
    public Object getSource() {
    public Set<InjectionPoint> getInjectionPoints() throws ConfigurationException {  
 * GitHub history for details.
 * requestStaticInjection()} statements:
     * Returns the static methods and fields of {@code type} that will be injected to fulfill this
     */
 * @since 2.0
 * <pre>  
    }
 * Unless required by applicable law or agreed to in writing, software
package org.opensearch.common.inject.spi;
    @Override  
 * Copyright (C) 2008 Google Inc.  
 *
 *
 * You may obtain a copy of the License at
        this.type = Objects.requireNonNull(type, "type");  
    /**  
    @Override
        binder.withSource(getSource()).requestStaticInjection(type);  
 * distributed under the License is distributed on an "AS IS" BASIS,  
        return type;  
 * A request to inject the static fields and methods of a type. Requests are created  
 * limitations under the License.  
import java.util.Objects;
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
@PublicApi(since = "1.0.0")
    public Class<?> getType() {
 * SPDX-License-Identifier: Apache-2.0
        return source;
    }  
 *
 * compatible open source license.
 */  
     *                                a field with multiple binding annotations. The exception's {@link
 *
    public <T> T acceptVisitor(ElementVisitor<T> visitor) {
 * @author jessewilson@google.com (Jesse Wilson)  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
/*
 * http://www.apache.org/licenses/LICENSE-2.0  
    }  
/*  
     *         before subtype fields. Similarly, supertype methods are returned before subtype methods.  
    private final Object source;
    private final Class<?> type;
        return visitor.visit(this);
 */  
     *                                ConfigurationException#getPartialValue() partial value} is a {@code Set<InjectionPoint>}  
 */
 * Modifications Copyright OpenSearch Contributors. See
        return InjectionPoint.forStaticMethodsAndFields(type);
     * @throws ConfigurationException if there is a malformed injection point on {@code type}, such as
     *                                of the valid injection points.
import org.opensearch.common.inject.ConfigurationException;  
     *         fields are returned and then all methods. Within the fields, supertype fields are returned
/*  
 */
 * @opensearch.api  
     * request.
    public void applyTo(Binder binder) {
 *
import org.opensearch.common.inject.Binder;
public final class StaticInjectionRequest implements Element {  
