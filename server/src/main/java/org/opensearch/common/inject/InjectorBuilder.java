    private List<InjectorShell> shells;
        injectDynamically();
                            errorsForBinding.merge(e.getErrors());
                        context.setDependency(dependency);
                    }
    /**
            shell.getInjector().index();
            }
     * Returns the injector being constructed. This is not necessarily the root injector.
    InjectorBuilder() {
        stopwatch.resetAndLog("Instance injection");
 * top-level injector.
        }
    /**
        if (binding.getScoping().isEagerSingleton(stage)) {
 * <ol>
 * </ol>
 * <p>
        injectionRequestProcessor.validate();
 * Builds a tree of injectors. This is a primary injector, plus child injectors needed for each
 * is not executed for injectors created using {@link Stage#TOOL the tool stage}</li>
    /**
    private void initializeStatically() {
     * Inject everything that can be injected. This method is intentionally not synchronized. If we
    private Injector primaryInjector() {
    }
 * @opensearch.internal
            throw new AssertionError("Already built, builders are not reusable.");
            shells = shellBuilder.build(initializer, bindingProcesor, stopwatch, errors);
    InjectorBuilder stage(Stage stage) {
    /**
        }
            loadEagerSingletons(injector, stage, errors, (BindingImpl<?>) binding);
        stopwatch.resetAndLog("Collecting injection requests");
     * Sets the stage for the created injector. If the stage is {@link Stage#PRODUCTION}, this class
 * injection. This may require user's objects be created and their providers be called. And we
        initializer.injectAll(errors);
package org.opensearch.common.inject;
 *
    }
/**
                            binding.getInternalFactory().get(errorsForBinding, context, dependency);
        }
 * this file be licensed under the Apache-2.0 license or a
        shellBuilder.stage(stage);
import org.opensearch.common.inject.internal.ErrorsException;
 * The OpenSearch Contributors require contributions made to
     * will eagerly load singletons.
    /**
        return primaryInjector();
            loadEagerSingletons(shell.getInjector(), stage, errors);
 * limitations under the License.
     * Initialize and validate everything.
 * <li>Dynamic injection. In this phase, we call user code. We inject members that requested
        // Synchronize while we're building up the bindings and other injector state. This ensures that
     */
    private final Stopwatch stopwatch = new Stopwatch();
    public void loadEagerSingletons(InjectorImpl injector, Stage stage, Errors errors) {
        errors.throwCreationExceptionIfErrorsExist();
    InjectorBuilder addModules(Iterable<? extends Module> modules) {
 * you may not use this file except in compliance with the License.
 * http://www.apache.org/licenses/LICENSE-2.0
     */
                    Dependency<?> dependency = Dependency.get(binding.getKey());
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
}
            loadEagerSingletons(injector, stage, errors, (BindingImpl<?>) binding);
    }
        bindingProcesor = new BindingProcessor(errors, initializer);
        stopwatch.resetAndLog("Binding indexing");
        for (final Binding<?> binding : injector.jitBindings.values()) {
import org.opensearch.common.inject.internal.BindingImpl;
            }
                injector.callInContext(new ContextualCallable<Void>() {
 *
    private void loadEagerSingletons(InjectorImpl injector, Stage stage, final Errors errors, BindingImpl<?> binding) {
        }
            ((DeferredLookups) shell.getInjector().lookups).initialize(errors);
    private Stage stage;
            } catch (ErrorsException e) {
                throw new AssertionError("Failed to execute " + shell.getElements());
import org.opensearch.common.inject.internal.Stopwatch;
        stopwatch.resetAndLog("Static member injection");
 * GitHub history for details.
 * <li>Static building. In this phase, we interpret commands, create bindings, and inspect
/*
 * create eager singletons. In this phase, user code may have started other threads. This phase
        stopwatch.resetAndLog("Binding initialization");
            if (!shell.getElements().isEmpty()) {
     */
 */
            try {
import org.opensearch.common.inject.internal.Errors;
    }
    private final BindingProcessor bindingProcesor;
        }
 * See the License for the specific language governing permissions and
        errors.throwCreationExceptionIfErrorsExist();
        new LookupProcessor(errors).process(shells);
    private final Errors errors = new Errors();
        injectionRequestProcessor.process(shells);
 *
     */
        for (InjectorShell shell : shells) {
     */
                        } finally {
import org.opensearch.common.inject.internal.InternalContext;
     * locked while injecting members (ie. running user code), things would deadlock should the user
 * compatible open source license.
/*
        }
        }
    Injector build() {
                        } catch (ErrorsException e) {
     * Loads eager singletons, or all singletons if we're in Stage.PRODUCTION. Bindings discovered
                        return null;
 */
                            context.setDependency(null);
                    @Override
 * Unless required by applicable law or agreed to in writing, software
    }
 */
        synchronized (shellBuilder.lock()) {
 * You may obtain a copy of the License at
        shellBuilder.addModules(modules);
        return shells.get(0).getInjector();
 *
        bindingProcesor.runCreationListeners();
        stopwatch.resetAndLog("Provider verification");
    private void injectDynamically() {
 *
                    public Void call(InternalContext context) {
        for (final Binding<?> binding : injector.state.getExplicitBindingsThisLevel().values()) {
/*
    }
            stopwatch.resetAndLog("Injector construction");
        stopwatch.resetAndLog("Instance member validation");
 * No user code is executed in this phase.</li>
    }
 *
 * Injector construction happens in two phases.
                });
import java.util.List;
        for (InjectorShell shell : shells) {
        return this;
 * @author crazybob@google.com (Bob Lee)
        injectionRequestProcessor.injectMembers();
     * while we're binding these singletons are not be eager.
        return this;
        bindingProcesor.initializeBindings();
        for (InjectorShell shell : shells) {
        errors.throwCreationExceptionIfErrorsExist();
        initializer.validateOustandingInjections(errors);
class InjectorBuilder {
 * SPDX-License-Identifier: Apache-2.0
            initializeStatically();
 * Licensed under the Apache License, Version 2.0 (the "License");
    private final Initializer initializer = new Initializer();
        for (InjectorShell shell : shells) {
 * distributed under the License is distributed on an "AS IS" BASIS,
        this.stage = stage;
        stopwatch.resetAndLog("Binding validation");
    private final InjectorShell.Builder shellBuilder = new InjectorShell.Builder();
        stopwatch.resetAndLog("Preloading singletons");
        // the JIT bindings in the parent injector don't change while we're being built
 * dependencies. During this phase, we hold a lock to ensure consistency with parent injectors.
 */
                        try {
        if (shellBuilder == null) {
        }
                        Errors errorsForBinding = errors.withSource(dependency);
    }
 * Copyright (C) 2006 Google Inc.
    }
        }
 * {@link Binder#newPrivateBinder() private environment}. The primary injector is not necessarily a
                throw new AssertionError();
 * Modifications Copyright OpenSearch Contributors. See
    private final InjectionRequestProcessor injectionRequestProcessor;
 * @author jessewilson@google.com (Jesse Wilson)
        injectionRequestProcessor = new InjectionRequestProcessor(errors, initializer);
                        }
import org.opensearch.common.inject.spi.Dependency;
     * code build a just-in-time binding from another thread.
        stopwatch.resetAndLog("Static validation");
