                }
 * You may obtain a copy of the License at
        return this;  
    }
        super(binder, elements, source, key);  
import org.opensearch.common.inject.spi.InjectionPoint;
        BindingImpl<T> base = getBinding();  
    }
import static java.util.Collections.unmodifiableSet;  
 * GitHub history for details.
 */  
        checkNotTargetted();  
    @Override  
        BindingImpl<T> base = getBinding();
        } else {
 *
    public BindingBuilder<T> to(Class<? extends T> implementation) {
        Objects.requireNonNull(provider, "provider");  
        BindingImpl<T> base = getBinding();
        Objects.requireNonNull(providerKey, "providerKey");
        return to(Key.get(implementation));
    @Override  
        Objects.requireNonNull(linkedKey, "linkedKey");  
    }
        Set<InjectionPoint> injectionPoints;  
 *
            try {
        return this;
        return "BindingBuilder<" + getBinding().getKey().getTypeLiteral() + ">";  
 * limitations under the License.  
        setBinding(new LinkedBindingImpl<>(base.getSource(), base.getKey(), base.getScoping(), linkedKey));  
            }
    }
        setBinding(new LinkedProviderBindingImpl<>(base.getSource(), base.getKey(), base.getScoping(), providerKey));  
            injectionPoints = unmodifiableSet(new HashSet<InjectionPoint>(e.getPartialValue()));
 * you may not use this file except in compliance with the License.  
    @Override  
        return this;  
    public void toInstance(T instance) {
 * compatible open source license.
        return this;
            for (Message message : e.getErrorMessages()) {
import org.opensearch.common.inject.ConfigurationException;
package org.opensearch.common.inject.internal;
 * Copyright (C) 2008 Google Inc.  
                    binder.addError(message);  
        annotatedWithInternal(annotationType);
        setBinding(new InstanceBindingImpl<>(base.getSource(), base.getKey(), base.getScoping(), injectionPoints, instance));
        if (instance != null) {
        return to(Key.get(implementation));
 * SPDX-License-Identifier: Apache-2.0
        }  
    public BindingBuilder<T> toProvider(Key<? extends Provider<? extends T>> providerKey) {
    public BindingBuilder<T> to(TypeLiteral<? extends T> implementation) {  
/*  
    }
    public BindingBuilder<T> annotatedWith(Class<? extends Annotation> annotationType) {
        }
/**
        checkNotTargetted();  
import org.opensearch.common.inject.binder.AnnotatedBindingBuilder;  
        checkNotTargetted();
import org.opensearch.common.inject.Key;  
import org.opensearch.common.inject.spi.Element;
 */  
        return toProvider(Key.get(providerType));  
        // lookup the injection points, adding any errors to the binder's errors list
                injectionPoints = InjectionPoint.forInstanceMethodsAndFields(instance.getClass());  
 *
 */
    public BindingBuilder<T> to(Key<? extends T> linkedKey) {
            injectionPoints = emptySet();  
import java.util.List;
    @Override
 * distributed under the License is distributed on an "AS IS" BASIS,  
    @Override
            binder.addError(BINDING_TO_NULL);
/*  
 * See the License for the specific language governing permissions and
public class BindingBuilder<T> extends AbstractBindingBuilder<T> implements AnnotatedBindingBuilder<T> {  
        checkNotTargetted();
    @Override
 * The OpenSearch Contributors require contributions made to  
    }
    public String toString() {
            }  
/*
    }
        annotatedWithInternal(annotation);
        // lookup the injection points, adding any errors to the binder's errors list  
    @Override
    public BindingBuilder<T> toProvider(Provider<? extends T> provider) {
import static java.util.Collections.emptySet;
        return this;
                for (Message message : e.getErrorMessages()) {
import java.util.Objects;
    @Override
import java.util.Set;  
        setBinding(new ProviderInstanceBindingImpl<>(base.getSource(), base.getKey(), base.getScoping(), injectionPoints, provider));  
import org.opensearch.common.inject.TypeLiteral;
        try {
 * @opensearch.internal
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    public BindingBuilder<T> annotatedWith(Annotation annotation) {
    }
    public BindingBuilder(Binder binder, List<Element> elements, Object source, Key<T> key) {
 * @author jessewilson@google.com (Jesse Wilson)
        Set<InjectionPoint> injectionPoints;
}
import org.opensearch.common.inject.spi.Message;  
import java.util.HashSet;  
 * Modifications Copyright OpenSearch Contributors. See
        BindingImpl<T> base = getBinding();
 *
            } catch (ConfigurationException e) {
    }
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
import org.opensearch.common.inject.Provider;
            injectionPoints = InjectionPoint.forInstanceMethodsAndFields(provider.getClass());  
import java.lang.annotation.Annotation;
 */
    @Override  
 * http://www.apache.org/licenses/LICENSE-2.0  
    }
    @Override
 * this file be licensed under the Apache-2.0 license or a
    }  
 *
import org.opensearch.common.inject.Binder;
 * Unless required by applicable law or agreed to in writing, software
        } catch (ConfigurationException e) {
 * Bind a non-constant key.  
    public BindingBuilder<T> toProvider(Class<? extends Provider<? extends T>> providerType) {
                binder.addError(message);  
                injectionPoints = unmodifiableSet(new HashSet<InjectionPoint>(e.getPartialValue()));
