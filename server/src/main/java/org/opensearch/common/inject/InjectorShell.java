            return this;
            stopwatch.resetAndLog("Converters creation");
        @Override
        }
        private final List<Module> modules = new ArrayList<>();
            if (state == null) {
        Builder privateElements(PrivateElements privateElements) {
        }
    private static class RootModule implements Module {
 * See the License for the specific language governing permissions and
                modules.add(0, new RootModule(stage));
/*
        @Override
        /**
            }
        }
         */
    /**
            for (Module module : modules) {
         * Creates and returns the injector shells for the current modules. Multiple shells will be
            key,
            new MessageProcessor(errors).process(injector, elements);
         * primary injector will be first in the returned list.
            // bind Stage and Singleton if this is a top-level injector
import org.opensearch.common.inject.internal.InternalContext;
            stopwatch.resetAndLog("Binding creation");
        }
    private static void bindInjector(InjectorImpl injector) {
        private InjectorFactory(Injector injector) {
        }
            key,
class InjectorShell {
        }
     * @opensearch.internal
 * @author jessewilson@google.com (Jesse Wilson)
                injectorFactory,
    private static void bindLogger(InjectorImpl injector) {
         * lazily constructed
            processor.process(injector, elements);
            stopwatch.resetAndLog("Scopes creation");
     * Factory for a logger
import org.opensearch.common.inject.spi.PrivateElements;
        }
     */
            binder = binder.withSource(SourceProvider.UNKNOWN_SOURCE);
     * The Injector is a special case because we allow both parent and child injectors to both have
     * The root module
                loggerFactory,
import org.opensearch.common.inject.spi.Dependency;
                Scoping.UNSCOPED,
import java.util.logging.Logger;
import static java.util.Collections.emptySet;
            stopwatch.resetAndLog("TypeListeners creation");
        }
            }
                : Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
                state = new InheritingState(State.NONE);
            return "Provider<Logger>";
        }
            }
        public Injector get(Errors errors, InternalContext context, Dependency<?> dependency) throws ErrorsException {
    InjectorImpl getInjector() {
    /**
 */
            return Logger.getAnonymousLogger();
        }
            return injector;
            }
                ? Logger.getAnonymousLogger()
            if (stage == null) {
            }
        @Override
 * Modifications Copyright OpenSearch Contributors. See
        public Injector get() {
 * limitations under the License.
        List<InjectorShell> build(Initializer initializer, BindingProcessor bindingProcessor, Stopwatch stopwatch, Errors errors) {
            bindInjector(injector);
    static class Builder {
import org.opensearch.common.inject.spi.TypeListenerBinding;
import org.opensearch.common.inject.internal.SourceProvider;
import org.opensearch.common.inject.spi.Elements;
        Key<Injector> key = Key.get(Injector.class);
import java.util.ArrayList;
     * Builder for an injector
 * GitHub history for details.
         */
            for (Builder builder : processor.getInjectorShellBuilders()) {
import org.opensearch.common.inject.internal.Stopwatch;
 */
        public Logger get(Errors errors, InternalContext context, Dependency<?> dependency) {
import org.opensearch.common.inject.internal.Scoping;
     * @opensearch.internal
                injectorFactory,
            return this;
            return this;
                throw new IllegalStateException("Stage not initialized");
                throw new IllegalStateException("no state. Did you remember to lock() ?");
    private static class LoggerFactory implements InternalFactory<Logger>, Provider<Logger> {
import java.util.Objects;
            List<TypeListenerBinding> listenerBindings = injector.state.getTypeListenerBindings();
            return "Provider<Injector>";
            bindLogger(injector);
     */
     * the only binding that does this.
         * null unless this exists in a {@link Binder#newPrivateBinder private environment}
            if (privateElements != null && parent == null) {
 * http://www.apache.org/licenses/LICENSE-2.0
    private static class InjectorFactory implements InternalFactory<Injector>, Provider<Injector> {
        }
        void addModules(Iterable<? extends Module> modules) {
import org.opensearch.common.inject.internal.Errors;
        /**
                key,
     */
        return injector;
                throw new IllegalStateException("PrivateElements with no parent");
            PrivateElementProcessor processor = new PrivateElementProcessor(errors, stage);
 * of injectors in batch.
        }
 * The OpenSearch Contributors require contributions made to
     */
            InjectionPoint injectionPoint = dependency.getInjectionPoint();
        private PrivateElementsImpl privateElements;
     */
     * The factory for the injector
            this.stage = stage;
     * @opensearch.internal
                injectorShells.addAll(builder.build(initializer, bindingProcessor, stopwatch, errors));
            if (privateElements != null) {
     */
        Key<Logger> key = Key.get(Logger.class);
import org.opensearch.common.inject.internal.ProviderInstanceBindingImpl;
 *
     * a binding for that key.
        Object lock() {
        InjectorFactory injectorFactory = new InjectorFactory(injector);
    private InjectorShell(List<Element> elements, InjectorImpl injector) {
     *
import org.opensearch.common.inject.spi.InjectionPoint;
 * You may obtain a copy of the License at
                loggerFactory,
            new ProviderInstanceBindingImpl<>(
        private final List<Element> elements = new ArrayList<>();
        }
        final Stage stage;
        private RootModule(Stage stage) {
         * returned if any modules contain {@link Binder#newPrivateBinder private environments}. The
        injector.state.putBinding(
        }
 *
        @Override
        private Stage stage;
        private State getState() {
        @Override
         */
        Builder stage(Stage stage) {
        public String toString() {
        }
    }
                this.modules.add(module);
import org.opensearch.common.inject.internal.ErrorsException;
                emptySet()
                key,
            this.privateElements = (PrivateElementsImpl) privateElements;
        return elements;
        }
        /**
            stopwatch.resetAndLog("Private environment creation");
     *
            bindingProcessor.process(injector, elements);
            this.injector = injector;
            }
                SourceProvider.UNKNOWN_SOURCE,
            this.state = new InheritingState(parent.state);
    }
    private final List<Element> elements;
 * distributed under the License is distributed on an "AS IS" BASIS,
 * A partially-initialized injector. See {@link InjectorBuilder}, which uses this to build a tree
            new TypeListenerBindingProcessor(errors).process(injector, elements);
            binder.bind(Stage.class).toInstance(stage);
        @Override
    }
            new ScopeBindingProcessor(errors).process(injector, elements);
            )
                privateElements.initInjector(injector);
            if (parent == null) {
        @Override
    }
        LoggerFactory loggerFactory = new LoggerFactory();
import org.opensearch.common.inject.spi.Element;
            return injectionPoint == null
            InjectorImpl injector = new InjectorImpl(state, initializer);
            binder.bindScope(Singleton.class, SINGLETON);
            }
        /**
    }
            this.parent = parent;
                new TypeConverterBindingProcessor(errors).prepareBuiltInConverters(injector);
                SourceProvider.UNKNOWN_SOURCE,
        this.injector = injector;
 *
 * compatible open source license.
        Builder parent(InjectorImpl parent) {
/**
 */
 *
 * Unless required by applicable law or agreed to in writing, software
            elements.addAll(Elements.getElements(stage, modules));
            )
    List<Element> getElements() {
    /**
        public String toString() {
    }
                injector,
        private State state;
    }
    private final InjectorImpl injector;
package org.opensearch.common.inject;
        public void configure(Binder binder) {
 * @opensearch.internal
 * you may not use this file except in compliance with the License.
            if (state == null) {
         * Synchronize on this before calling {@link #build}.
            new ProviderInstanceBindingImpl<>(
            return injector;
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
import static org.opensearch.common.inject.Scopes.SINGLETON;
            injectorShells.add(new InjectorShell(elements, injector));
        );
 * Copyright (C) 2008 Google Inc.
    /**
 * Licensed under the Apache License, Version 2.0 (the "License");
        injector.state.putBinding(
        public Logger get() {
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
        private final Injector injector;
/*
            this.stage = Objects.requireNonNull(stage, "stage");
                emptySet()
        this.elements = elements;
         */
                Scoping.UNSCOPED,
    /**
            this.elements.addAll(privateElements.getElements());
    /**
    }
                injector,
            return injectorShells;
            // recursively build child shells
     * @opensearch.internal
            new TypeConverterBindingProcessor(errors).process(injector, elements);
        private InjectorImpl parent;
        );
}
            return getState().lock();
    }
     * The Logger is a special case because it knows the injection point of the injected member. It's
import org.opensearch.common.inject.internal.InternalFactory;
     *
            List<InjectorShell> injectorShells = new ArrayList<>();
import org.opensearch.common.inject.internal.PrivateElementsImpl;
     *
            }
            stopwatch.resetAndLog("Module execution");
 */
/*
 *
            injector.membersInjectorStore = new MembersInjectorStore(injector, listenerBindings);
            return state;
