                        @Override
import org.opensearch.common.inject.spi.DefaultBindingScopingVisitor;
        }
                        public Void visit(ScopeBinding scopeBinding) {
                    new ModuleWriter(binder()) {  
                            }
                            scopeBindings.add(scopeBinding);
        return combine(Arrays.asList(modules));  
            this.baseModules = unmodifiableSet(modules);  
                        public <T> Void visit(Binding<T> binding) {
import org.opensearch.common.inject.spi.ScopeBinding;
                }
     * is kept. This can be used to replace the bindings of a production module with test bindings:
    }
                        public <T> Void visit(Binding<T> binding) {
                                    privateBinder.withSource(privateElements.getExposedSource(key)).expose(key);
        }
import org.opensearch.common.inject.Module;
     * </pre>
/**  
                            overridesScopeAnnotations.add(scopeBinding.getAnnotationType());
        ModuleWriter(Binder binder) {  
        return new RealOverriddenModuleBuilder(Arrays.asList(modules));  
                                }
     * Returns a builder that creates a module that overlays override modules over the given
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
import org.opensearch.common.inject.Key;
    /**  
import org.opensearch.common.inject.AbstractModule;
                    binder.install(module);
                            }
         */
    public static OverriddenModuleBuilder override(Iterable<? extends Module> modules) {
     * Prefer to write smaller modules that can be reused and tested without overrides.  
 * @opensearch.internal  
     * A module writer
                for (Module module : modulesSet) {  
                            Set<Key<?>> skippedExposes = new HashSet<>();
                        public Void visit(PrivateElements privateElements) {
                        @Override
    private static class ModuleWriter extends DefaultElementVisitor<Void> {  
     * is kept. This can be used to replace the bindings of a production module with test bindings:  
                                        .addError(  
                        @Override  
                }
                element.acceptVisitor(this);  
        Module with(Module... overrides);
                        }  
                    final List<Element> overrideElements = Elements.getElements(overrides);
        }
 * See the License for the specific language governing permissions and
                            if (!overridesScopeAnnotations.remove(scopeBinding.getAnnotationType())) {  
    /**
                                Scope scope = getScopeInstanceOrNull(binding);
        @Override
                        }
 * distributed under the License is distributed on an "AS IS" BASIS,  
    }
     * Returns a new module that installs all of {@code modules}.
     * <pre>
        };
                                if (element instanceof Binding && skippedExposes.contains(((Binding) element).getKey())) {  
            }  
                    // overridden binding once so things still blow up if the module binds the same thing
     *  
                    });
                            return super.visit(binding);  
import org.opensearch.common.inject.Scope;
                        }
     *  
 * limitations under the License.  
     * See the EDSL example at {@link Modules#override(Module[]) override()}.
     * modules. If a key is bound in both sets of modules, only the binding from the override modules
         */  
        }
                        public Void visit(PrivateElements privateElements) {
                            }
 * Modifications Copyright OpenSearch Contributors. See
    public interface OverriddenModuleBuilder {  
                    }.writeAll(scopeBindings);
import java.util.Map;  
    private static final class RealOverriddenModuleBuilder implements OverriddenModuleBuilder {
         * See the EDSL example at {@link Modules#override(Module[]) override()}.  
        public Module with(final Iterable<? extends Module> overrides) {  
     */
    }  
        @Override  
                        }
            };  
            public void configure(Binder binder) {
import java.util.Arrays;
 * The OpenSearch Contributors require contributions made to  
            this.binder = binder;
                    // execute the overrides module, keeping track of which keys and scopes are bound
import org.opensearch.common.inject.Binding;  
                    // execute the original module, skipping all scopes and overridden keys. We only skip each
                    final Map<Scope, Object> scopeInstancesInUse = new HashMap<>();
     */  
                        @Override  
                        }
 * You may obtain a copy of the License at
                                    scopeInstancesInUse.put(scope, binding.getSource());  
}
                    }.writeAll(elements);
                public void configure() {  
                                } else {
            element.applyTo(binder);  
 * you may not use this file except in compliance with the License.  
                    final Set<Class<? extends Annotation>> overridesScopeAnnotations = new HashSet<>();
import static java.util.Collections.unmodifiableSet;  
                @Override
                                // Record when a scope instance is used in a binding  
                binder = binder.skipSources(getClass());
     *     = Modules.override(getProductionModules()).with(getTestModules());  
 * this file be licensed under the Apache-2.0 license or a
                        }
public final class Modules {
        /**
                                            scopeBinding.getAnnotationType().getSimpleName()
            }
                            // we're not skipping deep exposes, but that should be okay. If we ever need to, we  
                                    skippedExposes.add(key);  
        private final Set<Module> baseModules;
    /**
                                }
                                }  
                                Object source = scopeInstancesInUse.get(scopeBinding.getScope());  
                            overriddenKeys.addAll(privateElements.getExposedKeys());
import java.util.HashSet;
     * Module functionalTestModule
import java.util.ArrayList;
     * <p>
                            overriddenKeys.add(binding.getKey());
/*  
     * Module functionalTestModule  
 * Copyright (C) 2008 Google Inc.  
            return new AbstractModule() {
     * <p>  
                        @Override  
import java.lang.annotation.Annotation;  
                        @Override  
                                if (overriddenKeys.remove(key)) {
import org.opensearch.common.inject.Binder;
     * </pre>
                            if (!overriddenKeys.remove(binding.getKey())) {  
 * GitHub history for details.
                        }
                                element.applyTo(privateBinder);  
import org.opensearch.common.inject.spi.PrivateElements;  
    }  
 * Static utility methods for creating and working with instances of {@link Module}.
        final Set<? extends Module> modulesSet = newHashSet(modules);
     *     = Modules.override(new ProductionModule()).with(new TestModule());
        }  
                                        );  
                    return binding.acceptScopingVisitor(new DefaultBindingScopingVisitor<Scope>() {
                            } else {
        return new Module() {
                    // execute the scope bindings, skipping scopes that have been overridden. Any scope that
            return with(Arrays.asList(overrides));
    };
 * Unless required by applicable law or agreed to in writing, software
     * @param modules the modules whose bindings are open to be overridden  
        return new RealOverriddenModuleBuilder(modules);
     * <pre>
     * @opensearch.internal
                }
    public static OverriddenModuleBuilder override(Module... modules) {
                    new ModuleWriter(binder()) {
import org.opensearch.common.inject.spi.Elements;
     */
 */  
        @Override
        /**
                private Scope getScopeInstanceOrNull(Binding<?> binding) {
 *
        void writeAll(Iterable<? extends Element> elements) {
import org.opensearch.common.inject.spi.Element;
        private RealOverriddenModuleBuilder(Iterable<? extends Module> baseModules) {
                                if (source != null) {
        protected final Binder binder;
 */
        @Override  
    public static final Module EMPTY_MODULE = new Module() {
     * @param modules the modules whose bindings are open to be overridden
                                super.visit(scopeBinding);
                    final Set<Key> overriddenKeys = new HashSet<>();
import org.opensearch.common.inject.spi.DefaultElementVisitor;  
                        }
                        public Void visit(ScopeBinding scopeBinding) {
                    }.writeAll(overrideElements);
     */
            HashSet<? extends Module> modules = newHashSet(baseModules);
     */
                    // TODO: bind the overridden keys using multibinder
    }
import java.util.Set;
     *
     */
 *
import org.opensearch.common.inject.PrivateBinder;  
                            return super.visit(scopeBinding);  
                    final List<Element> elements = Elements.getElements(baseModules);
 *
 */  
     *
 * @since 2.0
                            for (Element element : privateElements.getElements()) {
                            PrivateBinder privateBinder = binder.withSource(privateElements.getSource()).newPrivateBinder();  
    public static Module combine(Iterable<? extends Module> modules) {  
                                            "The scope for @%s is bound directly and cannot be overridden.",
 *
                            }
                        public Void visit(ScopeBinding scopeBinding) {
         * See the EDSL example at {@link Modules#override(Module[]) override()}.
            for (Element element : elements) {
    /**
    public static Module combine(Module... modules) {
            @Override  
                        @Override
 * @author jessewilson@google.com (Jesse Wilson)  
                            return null;  
package org.opensearch.common.inject.util;
                                }
        }
import java.util.HashMap;  
     * Prefer to write smaller modules that can be reused and tested without overrides.
                                    continue;
 *
                            return null;  
        public void configure(Binder binder) {}
                            for (Key<?> key : privateElements.getExposedKeys()) {
                    final List<ScopeBinding> scopeBindings = new ArrayList<>();
        protected Void visitOther(Element element) {
 *
        Module with(Iterable<? extends Module> overrides);
 * SPDX-License-Identifier: Apache-2.0
                            // have to search through this set of elements for PrivateElements, recursively
 * compatible open source license.
                            return scope;
 */
            return null;
                        public Scope visitScope(Scope scope) {
                                    binder().withSource(source)
                    // multiple times.  
                        @Override  
                    new ModuleWriter(binder()) {  
                            return null;
 * http://www.apache.org/licenses/LICENSE-2.0  
    private Modules() {}  
    }
                            return null;  
     * Returns a new module that installs all of {@code modules}.  
                    // is overridden and in active use will prompt an error
                                if (scope != null) {
     * @opensearch.internal
import static org.opensearch.common.util.set.Sets.newHashSet;
/*  
     * Returns a builder that creates a module that overlays override modules over the given
 * Licensed under the Apache License, Version 2.0 (the "License");
    }
     * modules. If a key is bound in both sets of modules, only the binding from the override modules  
    /**
import java.util.List;
                            return super.visit(privateElements);  
                                super.visit(binding);
/*
    /**  
        public Module with(Module... overrides) {
