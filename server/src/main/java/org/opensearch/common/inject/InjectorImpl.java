            return null;
        if (reference == null) {
        Object source = stringBinding.getSource();
        Type innerType = parameterizedType.getActualTypeArguments()[0];
 *
        BindingImpl<T> binding = createUnitializedBinding(key, Scoping.UNSCOPED, source, errors);
 * this file be licensed under the Apache-2.0 license or a
    private static class BindingsMultimap {
            // first try to find a JIT binding that we've already created
        final Dependency<T> dependency = Dependency.get(key);
        if (implementedBy != null) {
            // These casts are safe. We know T extends Provider<X> and that given Key<Provider<X>>,
            throw errors.recursiveImplementationType().toException();
        }
                    errors.throwIfNewErrors(0);
        @Override
                    if (o != null && !rawType.isInstance(o)) {
        return getMembersInjector(TypeLiteral.get(type));
            return null;
                        @Override
     */
            } catch (ErrorsException rethrownBelow) {
        );
        TypeLiteral<T> type = key.getTypeLiteral();
     * Returns true if the key type is Provider (but not a subclass of Provider).
import org.opensearch.common.inject.internal.ToStringBuilder;
        Type typeLiteralType = key.getTypeLiteral().getType();
import org.opensearch.common.inject.internal.MatcherAndConverter;
                .add("value", value)
            throw new ConfigurationException(errors.merge(e.getErrors()).getMessages());
import org.opensearch.common.inject.internal.InstanceBindingImpl;
        }
            BindingImpl<T> binding = (BindingImpl<T>) createTypeLiteralBinding((Key<TypeLiteral<Object>>) key, errors);
        }
     * <li>Converting constants.
        int i = 0;
        // Put the partially constructed binding in the map a little early. This enables us to handle
            throw errors.cannotInjectRawMembersInjector().toException();
    }
        }
        } catch (ErrorsException e) {
        SingleParameterInjector<?>[] result = new SingleParameterInjector<?>[parameters.size()];
    /**
            throw errors.missingImplementation(key).toException();
            } finally {
    @Override
    /**
            BindingImpl binding = createProviderBinding((Key) key, errors);
        }
        return ConstructorBindingImpl.create(this, key, source, scoping);
            ((ParameterizedType) membersInjectorType).getActualTypeArguments()[0]
     */
import java.lang.annotation.Annotation;
            return binding;
        return result;
 * See the License for the specific language governing permissions and
        }
        } else {
            throw errors.cannotInjectTypeLiteralOf(innerType).toException();
        // Handle TypeLiteral<T> by binding the inner type
            @SuppressWarnings("unchecked") // we only store bindings that match their key
        state.parent().denylist(key);
            providerKey
        }
            @SuppressWarnings("unchecked")
     * @opensearch.internal
            errors.throwIfNewErrors(0);
        return new InstanceBindingImpl<>(this, key, SourceProvider.UNKNOWN_SOURCE, factory, emptySet(), value);
    public void clearCache() {
        // Look for an on-demand binding.
        @SuppressWarnings("unchecked")
                return targetBinding.getInternalFactory().get(errors.withSource(targetKey), context, dependency);
     */
        }
                try {
        MatcherAndConverter matchingConverter = state.getConverter(stringValue, type, errors, source);
        if (!(innerType instanceof Class) && !(innerType instanceof GenericArrayType) && !(innerType instanceof ParameterizedType)) {
        // Assume the provider provides an appropriate type. We double check at runtime.
            throw errors.cannotInjectRawTypeLiteral().toException();
            @Override
        BindingImpl<T> binding = state.getExplicitBinding(key);
    @Override
            Provider<T> result = getProviderOrThrow(key, errors);
                }
                bindingsForType = new ArrayList<>();
            };
        }
 */
            @Override
/*
            }
            throw errors.notASubtype(implementationType, rawType).toException();
        if (!(providerType instanceof ParameterizedType)) {
        constructors = new ConstructorInjectorStore(this);
        // Find a constant string binding.
    private <T> BindingImpl<TypeLiteral<T>> createTypeLiteralBinding(Key<TypeLiteral<T>> key, Errors errors) throws ErrorsException {
            } finally {
        if (!(typeLiteralType instanceof ParameterizedType)) {
     */
        // Handle @ProvidedBy.
    public <T> Provider<T> getProvider(final Key<T> key) {
        @Override
        return key.getTypeLiteral().getRawType().equals(MembersInjector.class) && !key.hasAnnotationType();
        if (binding != null) {
import org.opensearch.common.inject.internal.LinkedBindingImpl;
    }
                        public T call(InternalContext context) throws ErrorsException {
                return callable.call((InternalContext) reference[0]);
                multimap.put(type, bindingsForType);
            if (!type.getRawType().isInstance(converted)) {
import org.opensearch.common.inject.internal.ErrorsException;
    private <T> BindingImpl<T> getJustInTimeBinding(Key<T> key, Errors errors) throws ErrorsException {
        // Note: We don't need to synchronize on state.lock() during injector creation.
            throw e;
        return new Provider<T>() {
            try {
 * GitHub history for details.
        return new ProviderBindingImpl<>(this, key, delegate);
            return callable.call((InternalContext) reference[0]);
    /**
        for (Binding<?> binding : state.getExplicitBindingsThisLevel().values()) {
        @SuppressWarnings("unchecked") // safe because T came from Key<Provider<T>>
            }
        if (!scoping.isExplicitlyScoped()) {
        if (providerType == rawType) {
        }
                } catch (ErrorsException e) {
     */
     * Returns true if the key type is MembersInjector (but not a subclass of MembersInjector).
        // Look up the target binding.
        // OpenSearch: optimize for a common case of read only instance getting from the parent...
            }
     * @opensearch.internal
        }
        Type membersInjectorType = key.getTypeLiteral().getType();
    }
        public T getValue() {
        // abstract types. Should we remove this restriction?
        public Provider<T> getProvider() {
        return getProvider(key).get();
        BindingImpl<String> stringBinding = state.getExplicitBinding(stringKey);
    }
            rawType /* source */,
                                return factory.get(errors, context, dependency);
        // Try to convert the string. A failed conversion results in an error.
 * SPDX-License-Identifier: Apache-2.0
    /**
import org.opensearch.common.inject.spi.ConvertedConstantBinding;
 * The OpenSearch Contributors require contributions made to
        final Class<? extends Provider<?>> providerType = providedBy.value();
            throw errors.missingImplementation(key).toException();
    public void injectMembers(Object instance) {
                    return t;
            };
    }
        InternalFactory<MembersInjector<T>> factory = new ConstantFactory<>(Initializables.of(membersInjector));
 * Unless required by applicable law or agreed to in writing, software
    }
    MembersInjectorStore membersInjectorStore;
        public Set<Dependency<?>> getDependencies() {
    }
            BindingImpl<T> binding = (BindingImpl<T>) jitBindings.get(key);
                try {
 */
    <T> void index(Binding<T> binding) {
     */
     * Creates a binding for a type annotated with @ImplementedBy.
        }
            return new ToStringBuilder(ConvertedConstantBinding.class).add("key", getKey())
        // Try to convert a constant string binding to the requested type.
        }
                    throw errors.errorInProvider(e).toException();
 */
        @Override
            if (key.hasAttributes()) {
import org.opensearch.common.inject.spi.BindingTargetVisitor;
    /**
        }
import org.opensearch.common.inject.spi.ProviderKeyBinding;
    }
                return binding;
    }
            }
        // safe because we only put matching entries into the map
        final Binding<String> originalBinding;
import java.util.Map;
        membersInjector.injectMembers(instance);
     * Returns a just-in-time binding for {@code key}, creating it if necessary.
    }
import java.lang.reflect.ParameterizedType;
import java.util.Set;
 *
            return createJustInTimeBindingRecursive(key, errors);
            // These casts are safe. T extends MembersInjector<X> and that given Key<MembersInjector<X>>,
        @SuppressWarnings("unchecked") // safe because T came from Key<MembersInjector<T>>
import org.opensearch.common.inject.internal.Annotations;
        ImplementedBy implementedBy = rawType.getAnnotation(ImplementedBy.class);
            // createMembersInjectorBinding() will return BindingImpl<MembersInjector<X>>.
        final Key<? extends Provider<T>> providerKey = (Key<? extends Provider<T>>) Key.get(providerType);
            }
                .toString();
        final BindingImpl<T> providedBinding;
    }
        // reindex the bindings
            Annotations.checkForMisplacedScopeAnnotations(rawType, source, errors);
 * limitations under the License.
    }
                ? Collections.<Binding<T>>unmodifiableList((List) multimap.get(type))
     *
            scoping,
/*
     * Returns parameter injectors, or {@code null} if there are no parameters.
        Key<T> providedKey = (Key<T>) key.ofType(entryType);
     * @opensearch.internal
        if (!rawType.isAssignableFrom(implementationType)) {
                    T t = callInContext(new ContextualCallable<T>() {
        if (matchingConverter == null) {
     * to the binding for {@code T}.
     */
    <T> BindingImpl<T> createProvidedByBinding(Key<T> key, Scoping scoping, ProvidedBy providedBy, Errors errors) throws ErrorsException {
     * Implementation for a binding object
                reference[0] = null;
            }
        final Key<? extends T> targetKey = Key.get(subclass);
import static org.opensearch.common.inject.internal.Annotations.findScopeAnnotation;
import static java.util.Collections.emptySet;
        return getBindingOrThrow(key, errors).getInternalFactory();
     * <ol>
            }
            key,
    private <T> BindingImpl<T> convertConstantStringBinding(Key<T> key, Errors errors) throws ErrorsException {
    Lookups lookups = new DeferredLookups(this);
                .add("sourceKey", getSourceKey())
import java.lang.reflect.Modifier;
    }
        state.clearDenylisted();
                scoping = Scopes.makeInjectable(Scoping.forAnnotation(scopeAnnotation), this, errors.withSource(rawType));
 * distributed under the License is distributed on an "AS IS" BASIS,
            public T get() {
                    jitBindings.remove(key);
        return bindingsMultimap.getAll(type);
        ConvertedConstantBindingImpl(Injector injector, Key<T> key, T value, Binding<String> originalBinding) {
    }
    /**
        if (state.isDenylisted(key)) {
        @Override
     */
        // Don't try to inject arrays, or enums.
import java.util.ArrayList;
     * Creates a synthetic binding to {@code Provider<T>}, i.e. a binding to the provider from
            Class<? extends Annotation> scopeAnnotation = findScopeAnnotation(errors, rawType);
    /**
    /**
        return binding;
import org.opensearch.common.inject.internal.Scoping;
    }
                    });
                    return getBindingOrThrow(key.withoutAttributes(), ignored);
    }
import java.util.List;
                    Object o = provider.get();
        readOnly = true;
 * Default {@link Injector} implementation.
            }
    <T> InternalFactory<? extends T> getInternalFactory(Key<T> key, Errors errors) throws ErrorsException {
import org.opensearch.common.inject.internal.InternalFactory;
        public String toString() {
     * binding.
        initializeBinding(binding, errors);
        return getProvider(type).get();
        return key.getTypeLiteral().getRawType().equals(Provider.class);
        Class<?> rawType = key.getTypeLiteral().getRawType();
    }
        throws ErrorsException {
    }
            if (binding != null) {
    /**
    private <T> BindingImpl<Provider<T>> createProviderBinding(Key<Provider<T>> key, Errors errors) throws ErrorsException {
        if (isProvider(key)) {
    // ES_GUICE: make all registered bindings act as eager singletons
 *
            Scopes.<T>scope(key, this, internalFactory, scoping),
     * </ol>
            }
        }
            super(injector, key, originalBinding.getSource(), new ConstantFactory<>(Initializables.of(value)), Scoping.UNSCOPED);
            reference[0] = new InternalContext();
            return visitor.visit(this);
     * Converts a constant string binding to the required type.
        if (binding instanceof ConstructorBindingImpl<?>) {
        Class<? extends T> subclass = (Class<? extends T>) implementationType;
        // Handle cases where T is a Provider<?>.
    }
            }
            this,
class InjectorImpl implements Injector, Lookups {
     */
        @Override
        }
     * Invokes a method.
            throw errors.childBindingAlreadySet(key).toException();
            return providedBinding.getKey();
        BindingImpl<T> convertedBinding = convertConstantStringBinding(key, errors);
        static <T> InternalFactory<Provider<T>> createInternalFactory(Binding<T> providedBinding) {
        Errors errors = new Errors(typeLiteral);
        BindingImpl<T> delegate = getBindingOrThrow(providedKey, errors);
     */
    public <T> T getInstance(Class<T> type) {
     * @throws ErrorsException
        );
                }
        bindingsMultimap.put(binding.getKey().getTypeLiteral(), binding);
                    assert false;
        public Key<? extends T> getProvidedKey() {
    <T> void initializeBinding(BindingImpl<T> binding, Errors errors) throws ErrorsException {
    }
        jitBindings = new HashMap<>();
                        // ignore
    Map<Key<?>, BindingImpl<?>> jitBindings = new HashMap<>();
        InternalFactory<T> internalFactory = new InternalFactory<T>() {
    public <T> Provider<T> getProvider(Class<T> type) {
package org.opensearch.common.inject;
     *
        errors.throwIfNewErrors(numErrorsBefore);
                    // should never happen...
     * Gets a binding implementation.  First, it check to see if the parent has a binding.  If the
            this,
/**
            return result;
 * compatible open source license.
        }
                }
        } catch (RuntimeException e) {
                } catch (ErrorsException ignored) {
                            context.setDependency(dependency);
    /**
                throw errors.converterReturnedNull(stringValue, source, type, matchingConverter).toException();
     * Cached constructor injectors for each type
            // Someone else will clean up this context.
        }
            throw errors.childBindingAlreadySet(key).toException();
        @Override
        }
            return binding;
                }
    public String toString() {
        try {
                }
            Scopes.<T>scope(key, this, internalFactory, scoping),
        <T> void put(TypeLiteral<T> type, Binding<T> binding) {
            public String toString() {
     *          if there was an error resolving the binding
            return new ConvertedConstantBindingImpl<>(this, key, converted, stringBinding);
        }
 * Copyright (C) 2006 Google Inc.
            return createImplementedByBinding(key, scoping, implementedBy, errors);
        }
import java.lang.reflect.GenericArrayType;
    <T> Provider<T> getProviderOrThrow(final Key<T> key, Errors errors) throws ErrorsException {
    }
     * checks for an explicit binding. If no explicit binding is found, it looks for a just-in-time
                    return provider;
                    } catch (ErrorsException e) {
        Class<?> rawType = key.getTypeLiteral().getRawType();
        }
    }
            key,
     */
            return null;
            throw errors.cannotInjectInnerClass(rawType).toException();
 * @opensearch.internal
        if (state.isDenylisted(key)) {
    }
            @Override
    void index() {
 *
                try {
    <T> T callInContext(ContextualCallable<T> callable) throws ErrorsException {
        return new InstanceBindingImpl<>(this, key, SourceProvider.UNKNOWN_SOURCE, factory, emptySet(), membersInjector);
        }
        if (Classes.isInnerClass(rawType)) {
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        throws ErrorsException {
                        }
     */
    SingleParameterInjector<?>[] getParametersInjectors(List<Dependency<?>> parameters, Errors errors) throws ErrorsException {
    <T> SingleParameterInjector<T> createParameterInjector(final Dependency<T> dependency, final Errors errors) throws ErrorsException {
        String stringValue = stringBinding.getProvider().get();
        try {
    /**
    private <T> BindingImpl<T> createJustInTimeBindingRecursive(Key<T> key, Errors errors) throws ErrorsException {
        this.initializer = initializer;
        @Override
            return bindings != null
        return getProvider(Key.get(type));
import org.opensearch.common.inject.util.Providers;
        state.makeAllBindingsToEagerSingletons(this);
        // If the key has an annotation...
     * @return the binding if it could be resolved, or null if the binding doesn't exist
    final State state;
            index(binding);
        }
            return new ToStringBuilder(ProviderKeyBinding.class).add("key", getKey()).add("providedKey", getProvidedKey()).toString();
        final Map<TypeLiteral<?>, List<Binding<?>>> multimap = new HashMap<>();
import org.opensearch.common.inject.spi.Dependency;
                successful = true;
        // TODO: for the above example, remove the binding for BarImpl if the binding for FooImpl fails
            try {
            T converted = (T) matchingConverter.getTypeConverter().convert(stringValue, type);
    @Override
        // Make sure it's not the same type. TODO: Can we check for deeper loops?
     * {@code Binding<T>}.
        }
    }
        }
        // Handle cases where T is a MembersInjector<?>
     * Attempts to create a just-in-time binding for {@code key} in the root injector, falling back to
                return factory.toString();
            this.value = value;
     * <li>The constructor of the raw type. Only for unannotated keys.
            this.providedBinding = (BindingImpl<T>) providedBinding;
    /**
     * parent has a binding and the binding is scoped, it will use that binding.  Otherwise, this
     * <li>Internalizing Providers. If the requested binding is for {@code Provider<T>}, we delegate
     * other ancestor injectors until this injector is tried.
                public Provider<T> get(Errors errors, InternalContext context, Dependency dependency) {
        }
        if (Modifier.isAbstract(rawType.getModifiers())) {
     */
        @Override
            boolean successful = false;
    /**
                    @SuppressWarnings("unchecked") // protected by isInstance() check above
        Object[] reference = localContext.get();
        final BindingImpl<? extends T> targetBinding = getBindingOrThrow(targetKey, errors);
     */
                    }
     * Looks up thread local context. Creates (and removes) a new context if necessary.
    @Override
        if (providedBy != null) {
    /**
            throw new UnsupportedOperationException("This element represents a synthetic binding.");
                final Errors errors = new Errors(dependency);
    }
    @Override
    private static class ConvertedConstantBindingImpl<T> extends BindingImpl<T> implements ConvertedConstantBinding<T> {
            // createProviderBinding() will return BindingImpl<Provider<X>>.
    <T> BindingImpl<T> createJustInTimeBinding(Key<T> key, Errors errors) throws ErrorsException {
     *
     * @opensearch.internal
    public void readOnlyAllSingletons() {
 * @author crazybob@google.com (Bob Lee)
                @Override
            this.originalBinding = originalBinding;
        InternalFactory<TypeLiteral<T>> factory = new ConstantFactory<>(Initializables.of(value));
        }
        InternalFactory<T> internalFactory = new InternalFactory<T>() {
            List<Binding<?>> bindingsForType = multimap.get(type);
    BindingsMultimap bindingsMultimap = new BindingsMultimap();
        if (parameters.isEmpty()) {
            if (scopeAnnotation != null) {
        @Override
        };
    @Override
    <T> BindingImpl<T> createUnitializedBinding(Key<T> key, Scoping scoping, Object source, Errors errors) throws ErrorsException {
                    return null;
            localContext.set(reference);
                if (!successful) {
        index();
    }
        // We can't inject abstract classes.
import static java.util.Collections.singleton;
        <T> List<Binding<T>> getAll(TypeLiteral<T> type) {
            bindingsForType.add(binding);
     * Creates a binding for an injectable type with the given scope. Looks for a scope on the type if
        }
import java.util.HashMap;
        } catch (ErrorsException e) {
    }
     * Multimap for java bindings
        Key<String> stringKey = key.ofType(String.class);
        // Find a matching type converter.
    static boolean isMembersInjector(Key<?> key) {
                } catch (RuntimeException e) {
     */
                    return t;
        return new LinkedProviderBindingImpl<>(
    private final ThreadLocal<Object[]> localContext;
     */
        }
    <T> BindingImpl<T> createImplementedByBinding(Key<T> key, Scoping scoping, ImplementedBy implementedBy, Errors errors)
            return visitor.visit(this);
        @Override
     * Creates a binding for a type annotated with @ProvidedBy.
            return new Provider<T>() {
            try {
        }
     * Implementation for a converted constant
        TypeLiteral<T> instanceType = (TypeLiteral<T>) TypeLiteral.get(
    /**
import org.opensearch.common.inject.internal.Errors;
        if (implementationType == rawType) {
        bindingsMultimap = new BindingsMultimap();
            return membersInjectorStore.get(typeLiteral, errors);
    boolean readOnly;
     *
    public <T> MembersInjector<T> getMembersInjector(Class<T> type) {
        return new ToStringBuilder(Injector.class).add("bindings", state.getExplicitBindingsThisLevel().values()).toString();
        // circular dependencies. Example: FooImpl -> BarImpl -> FooImpl.
        TypeLiteral<T> value = (TypeLiteral<T>) TypeLiteral.get(innerType);
        this.state = state;
            }
            // No converter can handle the given type.
            rawType /* source */,
    public <T> List<Binding<T>> findBindingsByType(TypeLiteral<T> type) {
     * <li>ImplementedBy and ProvidedBy annotations. Only for unannotated keys.
     * @throws ErrorsException
    }
     * none is specified.
            reference = new Object[1];
            jitBindings.put(key, binding);
        if (key.hasAnnotationType()) {
    }
            return new InternalFactory<Provider<T>>() {
        // Make sure it's not the same type. TODO: Can we check for deeper cycles?
        }
            targetKey
        Object invoke(Object target, Object... parameters) throws IllegalAccessException, InvocationTargetException;
    public <T> BindingImpl<T> getBindingOrThrow(Key<T> key, Errors errors) throws ErrorsException {
        } catch (ErrorsException e) {
     */
    ConstructorInjectorStore constructors = new ConstructorInjectorStore(this);
 * You may obtain a copy of the License at
        }
        final InternalFactory<? extends T> factory = getInternalFactory(key, errors);
        }
        Errors errors = new Errors(key);
    /**
    /**
     */
        MembersInjector<T> membersInjector = membersInjectorStore.get(instanceType, errors);
        int numErrorsBefore = errors.size();
            throw errors.cannotInjectRawProvider().toException();
    static boolean isProvider(Key<?> key) {
        ProvidedBy providedBy = rawType.getAnnotation(ProvidedBy.class);
                : Collections.<Binding<T>>emptyList();
/*
import org.opensearch.common.inject.internal.BindingImpl;
        try {
    /**
            public T get(Errors errors, InternalContext context, Dependency dependency) throws ErrorsException {
    }
        InternalFactory<? extends T> factory = getInternalFactory(dependency.getKey(), errors);
     * Indexes bindings by type.
    final Initializer initializer;
        if (reference[0] == null) {
import java.lang.reflect.Type;
        return new SingleParameterInjector<>(dependency, factory);
            return createProvidedByBinding(key, scoping, providedBy, errors);
     *          if the binding cannot be created.
                                context.setDependency(null);
    InjectorImpl(State state, Initializer initializer) {
                            }
            BindingImpl binding = createMembersInjectorBinding((Key) key, errors);
        Object source = key.getTypeLiteral().getRawType();
        Type providerType = key.getTypeLiteral().getType();
        }
            if (converted == null) {
        membersInjectorStore = new MembersInjectorStore(this, state.getTypeListenerBindings());
            }
                }
        BindingImpl<T> binding = createJustInTimeBinding(key, errors);
            return singleton(Dependency.get(getSourceKey()));
    private <T> BindingImpl<MembersInjector<T>> createMembersInjectorBinding(Key<MembersInjector<T>> key, Errors errors)
            throw errors.missingImplementation(key).toException();
import org.opensearch.common.inject.internal.LinkedProviderBindingImpl;
        public void applyTo(Binder binder) {
            return value;
            return binding;
    }
    }
 *
            return provider;
        }
        @Override
 * you may not use this file except in compliance with the License.
        if (factory instanceof InternalFactory.Instance) {
        // this is unfortunate. We don't support building TypeLiterals for type variable like 'T'. If
    }
                            try {
        Type entryType = ((ParameterizedType) providerType).getActualTypeArguments()[0];
        if (rawType == TypeLiteral.class) {
    @Override
     *
        public void applyTo(Binder binder) {
    }
    /**
                    throw new ProvisionException(errors.merge(e.getErrors()).getMessages());
        final Class<?> rawType = key.getTypeLiteral().getRawType();
     * Converts a binding for a {@code Key<TypeLiteral<T>>} to the value {@code TypeLiteral<T>}. It's
import java.lang.reflect.InvocationTargetException;
        @SuppressWarnings("unchecked")
                    }
                ((ConstructorBindingImpl) binding).initialize(this, errors);
    @Override
     */
        return new LinkedBindingImpl<>(
    /**
        @SuppressWarnings("unchecked") // After the preceding check, this cast is safe.
            List<Binding<?>> bindings = multimap.get(type);
        if (isMembersInjector(key)) {
            @SuppressWarnings("unchecked") // we have to fudge the inner type as Object
     *
        if (convertedBinding != null) {
        // Make sure implementationType extends type.
        }
                    T t = (T) o;
        }
        }
        ParameterizedType parameterizedType = (ParameterizedType) typeLiteralType;
        localContext = new ThreadLocal<>();
     */
        }
        // this proves problematic, we can probably fix TypeLiteral to support type variables
            super(injector, key, providedBinding.getSource(), createInternalFactory(providedBinding), Scoping.UNSCOPED);
        Class<?> implementationType = implementedBy.value();
import org.opensearch.common.inject.internal.InternalContext;
            final Provider<T> provider = providedBinding.getProvider();
            scoping,
        }
        for (Dependency<?> parameter : parameters) {
 *
     * Returns a new just-in-time binding created by resolving {@code key}. The strategies used to
            public T get(Errors errors, InternalContext context, Dependency<?> dependency) throws ErrorsException {
        synchronized (state.lock()) {
        MembersInjector membersInjector = getMembersInjector(instance.getClass());
        return getJustInTimeBinding(key, errors);
 * Licensed under the Apache License, Version 2.0 (the "License");
        };
    public <T> T getInstance(Key<T> key) {
     */
        @SuppressWarnings("unchecked") // by definition, innerType == T, so this is safe
        }
 * Modifications Copyright OpenSearch Contributors. See
    }
    /**
                result[i++] = createParameterInjector(parameter, errors.withSource(parameter));
 */
    public <T> MembersInjector<T> getMembersInjector(TypeLiteral<T> typeLiteral) {
                    // throw with a more appropriate message below
        jitBindings.put(key, binding);
        // If the Provider has no type parameter (raw Provider)...
        }
    }
        }
                            } finally {
        // Error: Inner class.
            return convertedBinding;
        }
        ProviderBindingImpl(InjectorImpl injector, Key<Provider<T>> key, Binding<T> providedBinding) {
import org.opensearch.common.inject.spi.ProviderBinding;
}
        public Key<String> getSourceKey() {
    }
        }
        public <V> V acceptTargetVisitor(BindingTargetVisitor<? super T, V> visitor) {
 * @see InjectorBuilder
        if (stringBinding == null || !stringBinding.isConstant()) {
        final Provider<T> provider;
     * create just-in-time bindings are:
                @Override
            Annotations.checkForMisplacedScopeAnnotations(rawType, source, errors);
            return originalBinding.getKey();
        };
            // Look for a binding without annotation attributes or return null.
    /**
            }
        if (rawType.isArray() || rawType.isEnum()) {
        }
        final BindingImpl<? extends Provider<?>> providerBinding = getBindingOrThrow(providerKey, errors);
                Provider<?> provider = providerBinding.getInternalFactory().get(errors, context, dependency);
    @SuppressWarnings("unchecked") // the members injector type is consistent with instance's type
     * a bit awkward because we have to pull out the inner type in the type literal.
                throw errors.conversionTypeError(stringValue, source, type, matchingConverter, converted).toException();
     * Just-in-time binding cache. Guarded by state.lock()
        public String toString() {
import java.util.Collections;
        // Check explicit bindings, i.e. bindings created by modules.
        final T value;
            throw errors.conversionError(stringValue, source, type, matchingConverter, e).toException();
import org.opensearch.common.Classes;
                    Errors ignored = new Errors();
                errors = errors.withSource(providerKey);
                        return (T) ((InternalFactory.Instance) factory).get(null, null, null);
        }
            @SuppressWarnings("unchecked") // This cast is safe because we double check below.
            Key<T> key = binding.getKey();
            throw new ConfigurationException(errors.merge(e.getErrors()).getMessages());
            return binding;
        return binding;
                // rethrown below
     *
        public <V> V acceptTargetVisitor(BindingTargetVisitor<? super Provider<T>, V> visitor) {
        );
    @Override
        }
     * Cached field and method injectors for each type.
                        throw errors.subtypeNotProvided(providerType, rawType).toException();
            provider = Providers.of(value);
            if (bindingsForType == null) {
                public T get() {
                // Only clear the context if this call created it.
    // ES_GUICE: clear caches
     * @throws ErrorsException if the binding could not be created.
    interface MethodInvoker {
        // TODO: Method interceptors could actually enable us to implement
                    try {
            @Override
            @SuppressWarnings("unchecked")
 * http://www.apache.org/licenses/LICENSE-2.0
        // Handle @ImplementedBy
    static class ProviderBindingImpl<T> extends BindingImpl<Provider<T>> implements ProviderBinding<Provider<T>> {
import org.opensearch.common.inject.internal.SourceProvider;
            throw new UnsupportedOperationException("This element represents a synthetic binding.");
            throw errors.recursiveProviderType().toException();
     */
        }
        if (!(membersInjectorType instanceof ParameterizedType)) {
