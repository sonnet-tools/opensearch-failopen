    private static void bindInjector(InjectorImpl injector) {  
 */  
         */
import org.opensearch.common.inject.internal.ErrorsException;
import java.util.List;  
     * the only binding that does this.
        }
            InjectionPoint injectionPoint = dependency.getInjectionPoint();
import static java.util.Collections.emptySet;
            stopwatch.resetAndLog("Scopes creation");  
    List<Element> getElements() {
 * Unless required by applicable law or agreed to in writing, software
            new TypeListenerBindingProcessor(errors).process(injector, elements);  
    private static class LoggerFactory implements InternalFactory<Logger>, Provider<Logger> {
                emptySet()  
     * The Logger is a special case because it knows the injection point of the injected member. It's
         * Creates and returns the injector shells for the current modules. Multiple shells will be
        private Stage stage;  
        public Logger get(Errors errors, InternalContext context, Dependency<?> dependency) {
            new MessageProcessor(errors).process(injector, elements);
            return injectionPoint == null  
    private final List<Element> elements;
        @Override
 * of injectors in batch.  
        );
 * this file be licensed under the Apache-2.0 license or a
        /**
     * @opensearch.internal
        /**  
            }
     */  
        }
    private static class InjectorFactory implements InternalFactory<Injector>, Provider<Injector> {
            for (Module module : modules) {
    }
     *
        @Override
        private State state;  
         * lazily constructed
import java.util.logging.Logger;
     * @opensearch.internal  
 *  
            }  
        List<InjectorShell> build(Initializer initializer, BindingProcessor bindingProcessor, Stopwatch stopwatch, Errors errors) {  
                new TypeConverterBindingProcessor(errors).prepareBuiltInConverters(injector);
                state = new InheritingState(State.NONE);
                loggerFactory,  
            }  
            bindInjector(injector);
    /**
    /**
import org.opensearch.common.inject.spi.Elements;  
            return getState().lock();
     * The Injector is a special case because we allow both parent and child injectors to both have  
            return injector;
     *
            stopwatch.resetAndLog("Private environment creation");
    /**  
            )
        Key<Logger> key = Key.get(Logger.class);
        public Injector get(Errors errors, InternalContext context, Dependency<?> dependency) throws ErrorsException {  
 */
            stopwatch.resetAndLog("TypeListeners creation");  
        Object lock() {  
import org.opensearch.common.inject.internal.PrivateElementsImpl;
        Builder stage(Stage stage) {
 * A partially-initialized injector. See {@link InjectorBuilder}, which uses this to build a tree
        }  
        }
                loggerFactory,
            this.parent = parent;
import org.opensearch.common.inject.internal.ProviderInstanceBindingImpl;  
import java.util.ArrayList;
            this.state = new InheritingState(parent.state);  
import static org.opensearch.common.inject.Scopes.SINGLETON;
package org.opensearch.common.inject;
                SourceProvider.UNKNOWN_SOURCE,  
import org.opensearch.common.inject.internal.Stopwatch;  
     */
            List<TypeListenerBinding> listenerBindings = injector.state.getTypeListenerBindings();
                injectorShells.addAll(builder.build(initializer, bindingProcessor, stopwatch, errors));
         * Synchronize on this before calling {@link #build}.
     */  
            return this;  
        }
     */
 * compatible open source license.
        /**  
            }
            return "Provider<Injector>";
    }  
     * The factory for the injector  
     * @opensearch.internal
        public void configure(Binder binder) {
        }
        private RootModule(Stage stage) {  
            binder.bindScope(Singleton.class, SINGLETON);
 * @author jessewilson@google.com (Jesse Wilson)
                key,
                key,
            elements.addAll(Elements.getElements(stage, modules));
        InjectorFactory injectorFactory = new InjectorFactory(injector);
                this.modules.add(module);
            stopwatch.resetAndLog("Binding creation");
import org.opensearch.common.inject.spi.PrivateElements;
 * Licensed under the Apache License, Version 2.0 (the "License");
            this.stage = stage;
        private InjectorImpl parent;
            return Logger.getAnonymousLogger();
     * a binding for that key.
        }
            new ProviderInstanceBindingImpl<>(  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
            stopwatch.resetAndLog("Module execution");
        }
    }
        /**
            return state;
            if (state == null) {
         */
                injectorFactory,  
        public Logger get() {  
                SourceProvider.UNKNOWN_SOURCE,
        }
import java.util.Objects;
 *
         */
            this.elements.addAll(privateElements.getElements());
        @Override
class InjectorShell {  
            if (privateElements != null && parent == null) {
 * Copyright (C) 2008 Google Inc.  
    }
                injectorFactory,
 * http://www.apache.org/licenses/LICENSE-2.0  
            key,
import org.opensearch.common.inject.internal.InternalContext;  
 */  
 * @opensearch.internal
import org.opensearch.common.inject.internal.SourceProvider;
            // recursively build child shells
            injector.membersInjectorStore = new MembersInjectorStore(injector, listenerBindings);
        injector.state.putBinding(
         */
 *
    private static void bindLogger(InjectorImpl injector) {
                : Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
/**
            )
        }
    /**  
        }
        public Injector get() {
/*  
        LoggerFactory loggerFactory = new LoggerFactory();  
            }  
        public String toString() {
            new ScopeBindingProcessor(errors).process(injector, elements);
            return "Provider<Logger>";  
            return this;
     * @opensearch.internal  
 * limitations under the License.  
         * returned if any modules contain {@link Binder#newPrivateBinder private environments}. The  
import org.opensearch.common.inject.spi.Element;
        this.injector = injector;
        Builder parent(InjectorImpl parent) {
        private final List<Element> elements = new ArrayList<>();  
                emptySet()
            this.stage = Objects.requireNonNull(stage, "stage");
            binder = binder.withSource(SourceProvider.UNKNOWN_SOURCE);  
        private final List<Module> modules = new ArrayList<>();
 *
        }  
import org.opensearch.common.inject.spi.Dependency;
        }
            InjectorImpl injector = new InjectorImpl(state, initializer);
            injectorShells.add(new InjectorShell(elements, injector));
        private final Injector injector;
        @Override  
     */
        injector.state.putBinding(  
    private static class RootModule implements Module {  
         * null unless this exists in a {@link Binder#newPrivateBinder private environment}  
         * primary injector will be first in the returned list.
 * You may obtain a copy of the License at
        @Override  
        Builder privateElements(PrivateElements privateElements) {  
            }  
                throw new IllegalStateException("Stage not initialized");
    /**  
            if (parent == null) {
                injector,
}
                ? Logger.getAnonymousLogger()
 * distributed under the License is distributed on an "AS IS" BASIS,  
        }  
    }
import org.opensearch.common.inject.internal.Scoping;
 *
 * SPDX-License-Identifier: Apache-2.0
                privateElements.initInjector(injector);
/*
            this.privateElements = (PrivateElementsImpl) privateElements;
            return this;  
        void addModules(Iterable<? extends Module> modules) {  
        private State getState() {  
 * Modifications Copyright OpenSearch Contributors. See
                Scoping.UNSCOPED,
        }
    }  
            processor.process(injector, elements);  
        private InjectorFactory(Injector injector) {
import org.opensearch.common.inject.spi.InjectionPoint;
            stopwatch.resetAndLog("Converters creation");  
            bindingProcessor.process(injector, elements);
    }
            new TypeConverterBindingProcessor(errors).process(injector, elements);
        @Override
        final Stage stage;
        public String toString() {
     */
import org.opensearch.common.inject.internal.Errors;
            new ProviderInstanceBindingImpl<>(
        return injector;
                throw new IllegalStateException("PrivateElements with no parent");
                throw new IllegalStateException("no state. Did you remember to lock() ?");
            key,
        return elements;  
            for (Builder builder : processor.getInjectorShellBuilders()) {
 * GitHub history for details.
            if (stage == null) {
 * you may not use this file except in compliance with the License.  
 *
        @Override
    }  
        }  
            }  
 * See the License for the specific language governing permissions and
     *  
    private InjectorShell(List<Element> elements, InjectorImpl injector) {
        Key<Injector> key = Key.get(Injector.class);
                modules.add(0, new RootModule(stage));  
/*  
            binder.bind(Stage.class).toInstance(stage);
            return injectorShells;  
            }  
import org.opensearch.common.inject.internal.InternalFactory;
            if (state == null) {
    static class Builder {
            PrivateElementProcessor processor = new PrivateElementProcessor(errors, stage);
    InjectorImpl getInjector() {
                injector,  
     *
            if (privateElements != null) {  
    private final InjectorImpl injector;  
import org.opensearch.common.inject.spi.TypeListenerBinding;  
        private PrivateElementsImpl privateElements;
            return injector;  
    /**
 * The OpenSearch Contributors require contributions made to  
            List<InjectorShell> injectorShells = new ArrayList<>();
    }
                Scoping.UNSCOPED,
            // bind Stage and Singleton if this is a top-level injector
     * Builder for an injector
            this.injector = injector;
 */
        this.elements = elements;  
     * The root module
            bindLogger(injector);  
        );  
     * Factory for a logger
