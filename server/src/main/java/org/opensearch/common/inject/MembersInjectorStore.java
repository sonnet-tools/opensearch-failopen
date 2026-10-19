                Errors errorsForMember = injectionPoint.isOptional() ? new Errors(injectionPoint) : errors.withSource(injectionPoint);  
                    typeListener.getListener().hear(type, encounter);
        }  
 * Members injectors by type.
            }
                    ? new SingleFieldInjector(this.injector, injectionPoint, errorsForMember)
import org.opensearch.common.inject.internal.Errors;
                try {
                // ignored for now  
import java.lang.reflect.Field;
        }
                    : new SingleMethodInjector(this.injector, injectionPoint, errorsForMember);  
 * The OpenSearch Contributors require contributions made to  
        return new MembersInjectorImpl<>(injector, type, encounter, injectors);
    public boolean hasTypeListeners() {  
                SingleMemberInjector injector = injectionPoint.getMember() instanceof Field
        TypeLiteral<?>,
    /**
import java.util.ArrayList;
 * @author jessewilson@google.com (Jesse Wilson)
                injectors.add(injector);
        @Override  
 *
    @SuppressWarnings("unchecked") // the MembersInjector type always agrees with the passed type
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
import org.opensearch.common.inject.spi.InjectionPoint;
        List<SingleMemberInjector> injectors = getInjectors(injectionPoints, errors);
 * SPDX-License-Identifier: Apache-2.0
        }
import org.opensearch.common.inject.spi.TypeListenerBinding;
 */
 *  
        EncounterImpl<T> encounter = new EncounterImpl<>(errors, injector.lookups);
 * distributed under the License is distributed on an "AS IS" BASIS,  
class MembersInjectorStore {
     * aren't any type listeners.
 */
    MembersInjectorStore(InjectorImpl injector, List<TypeListenerBinding> typeListenerBindings) {  
    private final List<TypeListenerBinding> typeListenerBindings;
 * this file be licensed under the Apache-2.0 license or a
            errors.merge(e.getErrorMessages());
     */  
 * compatible open source license.
    private <T> MembersInjectorImpl<T> createWithListeners(TypeLiteral<T> type, Errors errors) throws ErrorsException {  
            return createWithListeners(type, errors);
import java.util.Set;
    /**
        errors.throwIfNewErrors(numErrorsBefore);  
 */  
 *
 */  
/**
 * Unless required by applicable law or agreed to in writing, software
 * http://www.apache.org/licenses/LICENSE-2.0  
        MembersInjectorImpl<?>>() {
                    errors.errorNotifyingTypeListener(typeListener, type, e);
        } catch (ConfigurationException e) {  
 * You may obtain a copy of the License at
                } catch (RuntimeException e) {  
            if (typeListener.getTypeMatcher().matches(type)) {  
        }  
     */
     * Returns a new complete members injector with injection listeners registered.
    }
    private final FailableCache<TypeLiteral<?>, MembersInjectorImpl<?>> cache = new FailableCache<  
    /**
import java.util.List;
import java.util.Collections;  
        return Collections.unmodifiableList(injectors);  
     */
            }  
            try {
 * Modifications Copyright OpenSearch Contributors. See
 * Copyright (C) 2009 Google Inc.  
        for (InjectionPoint injectionPoint : injectionPoints) {
        errors.throwIfNewErrors(numErrorsBefore);
        this.injector = injector;
 *
    /**  
/*
        return (MembersInjectorImpl<T>) cache.get(key, errors);  
    };
/*  
    }  
    }
        int numErrorsBefore = errors.size();
    public <T> MembersInjectorImpl<T> get(TypeLiteral<T> key, Errors errors) throws ErrorsException {
 *
        encounter.invalidate();
     * Returns true if any type listeners are installed. Other code may take shortcuts when there  
        try {
 * you may not use this file except in compliance with the License.  
        for (TypeListenerBinding typeListener : typeListenerBindings) {
            injectionPoints = e.getPartialValue();
 * See the License for the specific language governing permissions and
import org.opensearch.common.inject.internal.ErrorsException;
            } catch (ErrorsException ignoredForNow) {
}
    List<SingleMemberInjector> getInjectors(Set<InjectionPoint> injectionPoints, Errors errors) {
 * limitations under the License.  
        List<SingleMemberInjector> injectors = new ArrayList<>();  
            injectionPoints = InjectionPoint.forInstanceMethodsAndFields(type);
 * GitHub history for details.
package org.opensearch.common.inject;
 * Licensed under the Apache License, Version 2.0 (the "License");
        Set<InjectionPoint> injectionPoints;  
    }
                }
        protected MembersInjectorImpl<?> create(TypeLiteral<?> type, Errors errors) throws ErrorsException {
     * Returns the injectors for the specified injection points.  
        this.typeListenerBindings = Collections.unmodifiableList(typeListenerBindings);
/*  
 *
import org.opensearch.common.inject.internal.FailableCache;  
    }  
 * @opensearch.internal  
    private final InjectorImpl injector;  
        return !typeListenerBindings.isEmpty();
     */
     * Creates a new members injector and attaches both injection listeners and method aspects.
