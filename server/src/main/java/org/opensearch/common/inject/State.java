        @Override
        @Override
            throw new UnsupportedOperationException();  
        public void clearDenylisted() {}
        }
        @Override  
    void clearDenylisted();  
        public void makeAllBindingsToEagerSingletons(Injector injector) {}
    /**
/*  
}  
/**
 * Unless required by applicable law or agreed to in writing, software
    void addConverter(MatcherAndConverter matcherAndConverter);  
    /**
 * @author jessewilson@google.com (Jesse Wilson)
        public void putAnnotation(Class<? extends Annotation> annotationType, Scope scope) {
        }  
        public void denylist(Key<?> key) {}
        @Override
     */
        public void addConverter(MatcherAndConverter matcherAndConverter) {
    Map<Key<?>, Binding<?>> getExplicitBindingsThisLevel();
            return null;
 * Modifications Copyright OpenSearch Contributors. See
 * limitations under the License.  
 */
     * parent injector that would conflict.
import org.opensearch.common.inject.internal.Errors;
    /**
     */
interface State {  
     * Forbids the corresponding injector from creating a binding to {@code key}. Child injectors
        @Override  
    State parent();  
     * Returns all converters at this level only.
import org.opensearch.common.inject.internal.BindingImpl;
        @Override
    List<TypeListenerBinding> getTypeListenerBindings();
     * denylist their bound keys on their parent injectors to prevent just-in-time bindings on the  
        public MatcherAndConverter getConverter(String stringValue, TypeLiteral<?> type, Errors errors, Object source) {  
    <T> BindingImpl<T> getExplicitBinding(Key<T> key);
 * compatible open source license.
     */
 * @opensearch.internal
        }
 * this file be licensed under the Apache-2.0 license or a
        public void putBinding(Key<?> key, BindingImpl<?> binding) {
        public boolean isDenylisted(Key<?> key) {
    void putAnnotation(Class<? extends Annotation> annotationType, Scope scope);
 * See the License for the specific language governing permissions and
 * Licensed under the Apache License, Version 2.0 (the "License");
            throw new UnsupportedOperationException();
     * Returns true if {@code key} is forbidden from being bound in this injector. This indicates that  
    Iterable<MatcherAndConverter> getConvertersThisLevel();
     * Returns the matching scope, or null.  
        }
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    void addTypeListener(TypeListenerBinding typeListenerBinding);  
    MatcherAndConverter getConverter(String stringValue, TypeLiteral<?> type, Errors errors, Object source);
        }
 * The inheritable data within an injector. This class is intended to allow parent and local
     * Returns the shared lock for all injector data. This is a low-granularity, high-contention lock  
            throw new UnsupportedOperationException();
        @Override  
        }
        }
        }  
     */  
     * one of this injector's descendent's has bound the key.
        @Override  
        @Override  
 * GitHub history for details.
            throw new UnsupportedOperationException();
            return emptySet();  
    void putBinding(Key<?> key, BindingImpl<?> binding);  
        public Object lock() {
    Object lock();  
        }  
    boolean isDenylisted(Key<?> key);  
import java.util.List;
    // ES_GUICE: clean denylist keys
            throw new UnsupportedOperationException();
 * Copyright (C) 2008 Google Inc.  
        @Override
        public State parent() {
    /**
        @Override
 */  
        @Override
/*  
        }  
        }  
    Scope getScope(Class<? extends Annotation> scopingAnnotation);
     * Returns the explicit bindings at this level only.
import java.util.Collections;
    /**
            throw new UnsupportedOperationException();  
            return Collections.emptyList();
            throw new UnsupportedOperationException();
    /**
    /**
        @Override
 *
    /**
/*
 * injector data to be accessed as a unit.  
 * http://www.apache.org/licenses/LICENSE-2.0  
        @Override  
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * The OpenSearch Contributors require contributions made to  
     * Returns the matching converter for {@code type}, or null if none match.  
 *  
     */  
        public Iterable<MatcherAndConverter> getConvertersThisLevel() {
     */
package org.opensearch.common.inject;
     */
 * you may not use this file except in compliance with the License.  
import static java.util.Collections.emptySet;
        public List<TypeListenerBinding> getTypeListenerBindings() {  
        }
            return true;  
        @Override  
     * to be used when reading mutable data (ie. just-in-time bindings, and binding denylists).
 *
        public Scope getScope(Class<? extends Annotation> scopingAnnotation) {  
    void denylist(Key<?> key);  
        @Override
        public <T> BindingImpl<T> getExplicitBinding(Key<T> key) {  
 * SPDX-License-Identifier: Apache-2.0
    void makeAllBindingsToEagerSingletons(Injector injector);
    State NONE = new State() {
        public void addTypeListener(TypeListenerBinding typeListenerBinding) {
 * You may obtain a copy of the License at
 *
 *
 */
import org.opensearch.common.inject.internal.MatcherAndConverter;  
     * Gets a binding which was specified explicitly in a module, or null.  
 *
 */  
    };
     */
import org.opensearch.common.inject.spi.TypeListenerBinding;
import java.lang.annotation.Annotation;  
import java.util.Map;  
            throw new UnsupportedOperationException();
            return null;
        }
        public Map<Key<?>, Binding<?>> getExplicitBindingsThisLevel() {
