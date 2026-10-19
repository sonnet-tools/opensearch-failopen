                        }
     * Returns a builder that creates a module that overlays override modules over the given
                            }
 * you may not use this file except in compliance with the License.
        protected final Binder binder;
        @Override
 * Licensed under the Apache License, Version 2.0 (the "License");
                    final List<Element> overrideElements = Elements.getElements(overrides);
                                }
import java.util.Arrays;
                    // multiple times.
     * See the EDSL example at {@link Modules#override(Module[]) override()}.
        }
                    new ModuleWriter(binder()) {
                            return super.visit(binding);
 * SPDX-License-Identifier: Apache-2.0
                element.acceptVisitor(this);
    private static class ModuleWriter extends DefaultElementVisitor<Void> {
     * modules. If a key is bound in both sets of modules, only the binding from the override modules
         * See the EDSL example at {@link Modules#override(Module[]) override()}.
import org.opensearch.common.inject.AbstractModule;
import org.opensearch.common.inject.Binder;
                        public <T> Void visit(Binding<T> binding) {
                        public Scope visitScope(Scope scope) {
 * compatible open source license.
            this.binder = binder;
     * Prefer to write smaller modules that can be reused and tested without overrides.
     * modules. If a key is bound in both sets of modules, only the binding from the override modules
        }
                        @Override
    public static OverriddenModuleBuilder override(Iterable<? extends Module> modules) {
        return new RealOverriddenModuleBuilder(modules);
            }
     */
     * <pre>
                    // execute the scope bindings, skipping scopes that have been overridden. Any scope that
            return with(Arrays.asList(overrides));
                            return null;
                                }
        return new Module() {
         * See the EDSL example at {@link Modules#override(Module[]) override()}.
    private Modules() {}
     * </pre>
                    final Map<Scope, Object> scopeInstancesInUse = new HashMap<>();
     * Prefer to write smaller modules that can be reused and tested without overrides.
 * Modifications Copyright OpenSearch Contributors. See
                        public <T> Void visit(Binding<T> binding) {
    /**
                                    privateBinder.withSource(privateElements.getExposedSource(key)).expose(key);
        public void configure(Binder binder) {}
 * distributed under the License is distributed on an "AS IS" BASIS,
                    final List<ScopeBinding> scopeBindings = new ArrayList<>();
                                super.visit(binding);
import java.lang.annotation.Annotation;
                                if (source != null) {
        ModuleWriter(Binder binder) {
     */
 * this file be licensed under the Apache-2.0 license or a
                        @Override
                    // overridden binding once so things still blow up if the module binds the same thing
     * Module functionalTestModule
 * The OpenSearch Contributors require contributions made to
            return new AbstractModule() {
     * Returns a new module that installs all of {@code modules}.
                        }
                    }.writeAll(scopeBindings);
         */
                    // is overridden and in active use will prompt an error
                            PrivateBinder privateBinder = binder.withSource(privateElements.getSource()).newPrivateBinder();
 * See the License for the specific language governing permissions and
                        public Void visit(PrivateElements privateElements) {
 * @author jessewilson@google.com (Jesse Wilson)
                        @Override
        final Set<? extends Module> modulesSet = newHashSet(modules);
                            return null;
/*
/*
                            if (!overriddenKeys.remove(binding.getKey())) {
     * </pre>
        public Module with(Module... overrides) {
                            return super.visit(privateElements);
     * is kept. This can be used to replace the bindings of a production module with test bindings:
                        @Override
                }
 * You may obtain a copy of the License at
                        @Override
    }
     * <p>
                    }.writeAll(overrideElements);
                    new ModuleWriter(binder()) {
     *
                            overridesScopeAnnotations.add(scopeBinding.getAnnotationType());
                for (Module module : modulesSet) {
     *     = Modules.override(new ProductionModule()).with(new TestModule());
     * Returns a new module that installs all of {@code modules}.
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
                            return super.visit(scopeBinding);
                            overriddenKeys.addAll(privateElements.getExposedKeys());
        public Module with(final Iterable<? extends Module> overrides) {
}
 */
     * A module writer
     * @opensearch.internal
            };
                        @Override
 * @since 2.0
        void writeAll(Iterable<? extends Element> elements) {
                        }
    /**
        private RealOverriddenModuleBuilder(Iterable<? extends Module> baseModules) {
import java.util.Set;
                                            "The scope for @%s is bound directly and cannot be overridden.",
                        public Void visit(ScopeBinding scopeBinding) {
 * http://www.apache.org/licenses/LICENSE-2.0
                            // we're not skipping deep exposes, but that should be okay. If we ever need to, we
 *
                                super.visit(scopeBinding);
    }
     * Module functionalTestModule
                    // execute the original module, skipping all scopes and overridden keys. We only skip each
                                    scopeInstancesInUse.put(scope, binding.getSource());
import org.opensearch.common.inject.spi.ScopeBinding;
                                Object source = scopeInstancesInUse.get(scopeBinding.getScope());
    }
import static java.util.Collections.unmodifiableSet;
                            }
     * <p>
    private static final class RealOverriddenModuleBuilder implements OverriddenModuleBuilder {
                                Scope scope = getScopeInstanceOrNull(binding);
                            return scope;
     */
    public interface OverriddenModuleBuilder {
 * @opensearch.internal
import org.opensearch.common.inject.Binding;
package org.opensearch.common.inject.util;
                            // have to search through this set of elements for PrivateElements, recursively
                            Set<Key<?>> skippedExposes = new HashSet<>();
    public static final Module EMPTY_MODULE = new Module() {
        };
                        @Override
                        public Void visit(ScopeBinding scopeBinding) {
 *
    public static Module combine(Iterable<? extends Module> modules) {
    /**
 * limitations under the License.
                                    continue;
import org.opensearch.common.inject.spi.PrivateElements;
                                    binder().withSource(source)
     *
                            }
                    final List<Element> elements = Elements.getElements(baseModules);
    }
                                            scopeBinding.getAnnotationType().getSimpleName()
        return combine(Arrays.asList(modules));
     */
                    // TODO: bind the overridden keys using multibinder
                public void configure() {
                    return binding.acceptScopingVisitor(new DefaultBindingScopingVisitor<Scope>() {
            public void configure(Binder binder) {
            for (Element element : elements) {
     */
import org.opensearch.common.inject.spi.Elements;
                                if (scope != null) {
                        }
    }
                                element.applyTo(privateBinder);
                    binder.install(module);
/*
                binder = binder.skipSources(getClass());
        Module with(Module... overrides);
    /**
                                }
import org.opensearch.common.inject.Scope;
import org.opensearch.common.inject.PrivateBinder;
    };
 */
                        public Void visit(ScopeBinding scopeBinding) {
    }
            element.applyTo(binder);
        return new RealOverriddenModuleBuilder(Arrays.asList(modules));
        Module with(Iterable<? extends Module> overrides);
 * Static utility methods for creating and working with instances of {@link Module}.
import org.opensearch.common.inject.spi.DefaultElementVisitor;
                        }
                    // execute the overrides module, keeping track of which keys and scopes are bound
 *
                    final Set<Key> overriddenKeys = new HashSet<>();
import java.util.HashMap;
                        }
    /**
import java.util.List;
    /**
                            for (Element element : privateElements.getElements()) {
                            return null;
     * @param modules the modules whose bindings are open to be overridden
            HashSet<? extends Module> modules = newHashSet(baseModules);
                        }
     * @param modules the modules whose bindings are open to be overridden
import org.opensearch.common.inject.spi.DefaultBindingScopingVisitor;
        @Override
                                    skippedExposes.add(key);
                                }
     */
                            overriddenKeys.add(binding.getKey());
        protected Void visitOther(Element element) {
                            if (!overridesScopeAnnotations.remove(scopeBinding.getAnnotationType())) {
    public static Module combine(Module... modules) {
                                        );
                            return null;
import org.opensearch.common.inject.Module;
     *
            @Override
        }
 * GitHub history for details.
        }
        /**
                            }
                    new ModuleWriter(binder()) {
         */
     * @opensearch.internal
                    }.writeAll(elements);
                        public Void visit(PrivateElements privateElements) {
                }
                                // Record when a scope instance is used in a binding
 */
            }
                            } else {
     * <pre>
 */
 *
/**
     *
                            for (Key<?> key : privateElements.getExposedKeys()) {
                    final Set<Class<? extends Annotation>> overridesScopeAnnotations = new HashSet<>();
        /**
     * is kept. This can be used to replace the bindings of a production module with test bindings:
        @Override
                            scopeBindings.add(scopeBinding);
                                if (overriddenKeys.remove(key)) {
            return null;
                                if (element instanceof Binding && skippedExposes.contains(((Binding) element).getKey())) {
import static org.opensearch.common.util.set.Sets.newHashSet;
 *
                                        .addError(
    }
                private Scope getScopeInstanceOrNull(Binding<?> binding) {
     * Returns a builder that creates a module that overlays override modules over the given
                        @Override
 *
     *     = Modules.override(getProductionModules()).with(getTestModules());
        private final Set<Module> baseModules;
    public static OverriddenModuleBuilder override(Module... modules) {
import java.util.HashSet;
            this.baseModules = unmodifiableSet(modules);
 * Unless required by applicable law or agreed to in writing, software
 * Copyright (C) 2008 Google Inc.
import java.util.Map;
                        }
                @Override
import org.opensearch.common.inject.Key;
public final class Modules {
        }
                }
import org.opensearch.common.inject.spi.Element;
                    });
        @Override
import java.util.ArrayList;
        }
                                } else {
