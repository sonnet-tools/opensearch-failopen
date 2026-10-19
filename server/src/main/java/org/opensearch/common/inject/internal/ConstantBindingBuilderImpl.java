        @SuppressWarnings("unchecked")
    public void to(final double value) {
    public void to(final long value) {
/*  
    @Override
package org.opensearch.common.inject.internal;
        toConstant(Double.class, value);  
import org.opensearch.common.inject.binder.ConstantBindingBuilder;
    }
import org.opensearch.common.inject.Binder;
    @Override  
        return this;
 * @opensearch.internal
    }
            key = Key.get(typeAsClassT, base.getKey().getAnnotationType());  
        // this type will define T, so these assignments are safe
        toConstant(Class.class, value);
 * @author jessewilson@google.com (Jesse Wilson)  
    }
    @Override
        annotatedWithInternal(annotation);
 * Bind a constant.
    public void to(final short value) {  
        BindingImpl<T> base = getBinding();
        toConstant(String.class, value);
    }
    public ConstantBindingBuilder annotatedWith(Annotation annotation) {  
 * limitations under the License.  
        toConstant(Short.class, value);
        }
 * http://www.apache.org/licenses/LICENSE-2.0  
/*
            binder.addError(CONSTANT_VALUE_ALREADY_SET);  
    }  
 *
        } else if (base.getKey().getAnnotationType() != null) {
        if (base.getKey().getAnnotation() != null) {  
            return;
 * compatible open source license.
        return this;
 * GitHub history for details.
    @SuppressWarnings("unchecked") // constant bindings start out with T unknown  
 * SPDX-License-Identifier: Apache-2.0
    public void to(final int value) {
        ConstantBindingBuilder {
    @Override
 * Modifications Copyright OpenSearch Contributors. See
    }
            key = Key.get(typeAsClassT, base.getKey().getAnnotation());
        }  
    @Override  
    @Override  
 */  
 *
        toConstant(Boolean.class, value);
        toConstant(value.getDeclaringClass(), value);
    }
    @Override
/**  
 * Licensed under the Apache License, Version 2.0 (the "License");
        annotatedWithInternal(annotationType);
        @SuppressWarnings("unchecked")  
    }
            key = Key.get(typeAsClassT);
 */  
        }
 * you may not use this file except in compliance with the License.  
    @Override
        toConstant(Character.class, value);  
        if (instanceAsT == null) {
    }  
    @Override  
 *
import org.opensearch.common.inject.Key;
 * this file be licensed under the Apache-2.0 license or a
 * Copyright (C) 2008 Google Inc.  
 *
    }  
        Key<T> key;
 * Unless required by applicable law or agreed to in writing, software
        if (keyTypeIsSet()) {
    public ConstantBindingBuilderImpl(Binder binder, List<Element> elements, Object source) {
 * See the License for the specific language governing permissions and
 *
 * distributed under the License is distributed on an "AS IS" BASIS,  
        toConstant(Integer.class, value);  
    @Override
import java.lang.annotation.Annotation;
 * The OpenSearch Contributors require contributions made to  
        setBinding(new InstanceBindingImpl<>(base.getSource(), key, base.getScoping(), emptySet(), instanceAsT));  
    public String toString() {
        Class<T> typeAsClassT = (Class<T>) type;
/*  
            binder.addError(BINDING_TO_NULL);  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
import org.opensearch.common.inject.binder.AnnotatedConstantBindingBuilder;  
    private void toConstant(Class<?> type, Object instance) {
 */
    @Override
    public void to(final String value) {  
    public void to(final float value) {
        return "ConstantBindingBuilder";
    }
        super(binder, elements, source, (Key<T>) NULL_KEY);
 */  
import org.opensearch.common.inject.spi.Element;
        } else {
import static java.util.Collections.emptySet;
public final class ConstantBindingBuilderImpl<T> extends AbstractBindingBuilder<T>
    public void to(final char value) {
    @Override
    public <E extends Enum<E>> void to(final E value) {  
    implements
    public ConstantBindingBuilder annotatedWith(Class<? extends Annotation> annotationType) {  
 * You may obtain a copy of the License at
        toConstant(Long.class, value);
    public void to(final boolean value) {  
}
    }  
    }  
import java.util.List;
        T instanceAsT = (T) instance;  
    }  
 *
        AnnotatedConstantBindingBuilder,  
    public void to(final Class<?> value) {
        toConstant(Float.class, value);
    }  
    @Override
