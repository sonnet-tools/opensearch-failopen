     */
    protected void checkNotScoped() {
     */
        setBinding(getBinding().withScoping(Scoping.forInstance(scope)));
    protected BindingImpl<T> getBinding() {
public abstract class AbstractBindingBuilder<T> {  
 * Copyright (C) 2008 Google Inc.  
        Objects.requireNonNull(scopeAnnotation, "scopeAnnotation");  
    }  
    public AbstractBindingBuilder(Binder binder, List<Element> elements, Object source, Key<T> key) {
    protected BindingImpl<T> annotatedWithInternal(Annotation annotation) {
 * http://www.apache.org/licenses/LICENSE-2.0  
import java.lang.annotation.Annotation;
 * distributed under the License is distributed on an "AS IS" BASIS,  
    /**
}
 *
import java.util.List;
/**
    }  
            binder.addError(SINGLE_INSTANCE_AND_SCOPE);
 * GitHub history for details.
 * you may not use this file except in compliance with the License.  
    public static final String SCOPE_ALREADY_SET = "Scope is set more than once.";
    public void in(final Class<? extends Annotation> scopeAnnotation) {
    protected int position;
 * Unless required by applicable law or agreed to in writing, software
 * limitations under the License.  
        checkNotScoped();  
 * You may obtain a copy of the License at
        checkNotAnnotated();
    protected final Binder binder;
    }  
        return setBinding(binding.withKey(Key.get(this.binding.getKey().getTypeLiteral(), annotation)));
        }
        this.binding = new UntargettedBindingImpl<>(source, key, Scoping.UNSCOPED);  
        return !Void.class.equals(binding.getKey().getTypeLiteral().getType());
import org.opensearch.common.inject.Scope;  
        checkNotScoped();
 *
        // Scoping isn't allowed when we have only one instance.  
 */
 *
    protected BindingImpl<T> setBinding(BindingImpl<T> binding) {
        if (binding.getScoping().isExplicitlyScoped()) {  
        Objects.requireNonNull(scope, "scope");  
    protected static final Key<?> NULL_KEY = Key.get(Void.class);
        Objects.requireNonNull(annotationType, "annotationType");  
    public void asEagerSingleton() {
 * Licensed under the Apache License, Version 2.0 (the "License");
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.inject.spi.Element;
        this.position = elements.size();
    private BindingImpl<T> binding;  
    }  
    /**
import java.util.Objects;  
import org.opensearch.common.inject.Binder;
 * @opensearch.internal
    }  
    protected void checkNotTargetted() {
import org.opensearch.common.inject.Key;
        return setBinding(binding.withKey(Key.get(this.binding.getKey().getTypeLiteral(), annotationType)));
    }  
 * SPDX-License-Identifier: Apache-2.0
 */  
    }
 * The OpenSearch Contributors require contributions made to  
            binder.addError(ANNOTATION_ALREADY_SPECIFIED);
        this.elements = elements;
    public void in(final Scope scope) {
        return binding;
        }
    public static final String IMPLEMENTATION_ALREADY_SET = "Implementation is set more than once.";
 * See the License for the specific language governing permissions and
 *  
    public static final String SINGLE_INSTANCE_AND_SCOPE = "Setting the scope is not permitted when binding to a single instance.";  
            binder.addError(IMPLEMENTATION_ALREADY_SET);
            return;  
 * @author jessewilson@google.com (Jesse Wilson)
     * Sets the binding to a copy with the specified annotation on the bound key  
        checkNotScoped();
    }
    }  
    public static final String CONSTANT_VALUE_ALREADY_SET = "Constant value is set more than once.";
    }  
        elements.set(position, binding);
/*  
 * this file be licensed under the Apache-2.0 license or a
        setBinding(getBinding().withScoping(Scoping.EAGER_SINGLETON));
/*
        + "Use toProvider(Providers.of(null)) if this is your intended behaviour.";  
    }  
     * Sets the binding to a copy with the specified annotation on the bound key  
    protected List<Element> elements;  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
            binder.addError(SCOPE_ALREADY_SET);
 *
        }
    protected BindingImpl<T> annotatedWithInternal(Class<? extends Annotation> annotationType) {
 * compatible open source license.
        checkNotAnnotated();
        if (binding instanceof InstanceBinding) {
 */  
        Objects.requireNonNull(annotation, "annotation");  
/*  
    protected void checkNotAnnotated() {
        if (binding.getKey().getAnnotationType() != null) {  
 *
    public static final String BINDING_TO_NULL = "Binding to null instances is not allowed. "
    protected boolean keyTypeIsSet() {
        this.binding = binding;  
    public static final String ANNOTATION_ALREADY_SPECIFIED = "More than one annotation is specified for this binding.";
package org.opensearch.common.inject.internal;
 * Bind a value or constant.  
 */
        }
        return binding;
    }  
        elements.add(position, this.binding);
        if (!(binding instanceof UntargettedBindingImpl)) {  
        this.binder = binder;  
        setBinding(getBinding().withScoping(Scoping.forAnnotation(scopeAnnotation)));
import org.opensearch.common.inject.spi.InstanceBinding;
