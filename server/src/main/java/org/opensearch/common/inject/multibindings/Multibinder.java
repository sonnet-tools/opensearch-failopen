 *
        if (condition) {
     * As a Multibinder, it acts as a factory for LinkedBindingBuilders for
        public void configure(Binder binder) {
 *
        @Override
     * multiple multibinders can be created for the same target collection, but
         * element in this set. At this time the set's size is known, but its
            checkConfiguration(!isInitialized(), "Multibinder was already initialized");
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *   {@literal @}Inject
            binder,
            providers = new ArrayList<>();
        public boolean equals(Object o) {
    public static final class RealMultibinder<T> extends Multibinder<T> implements Module, Provider<Set<T>>, HasDependencies {
     * identifies it as a part of this set.
    }
import org.opensearch.common.inject.internal.Errors;
        }
        private List<Provider<T>> providers;
        }
    static <T> T checkNotNull(T reference, String name) {
            return setName;
import java.lang.reflect.Type;
            }
 * limitations under the License.
 * Modifications Copyright OpenSearch Contributors. See
        RealMultibinder<T> result = new RealMultibinder<>(binder, type, "", Key.get(Multibinder.<T>setOf(type)));
 * provider, that provider's get method will be called each time the set is
import java.util.LinkedHashSet;
        @Override
import org.opensearch.common.inject.Injector;
 * Annotations are be used to create different sets of the same element
        return newSetBinder(binder, TypeLiteral.get(type), annotation);
 * GitHub history for details.
 * elements.
        Key<Set<T>> getSetKey() {
            this.binder = Objects.requireNonNull(binder, "binder");
 *
            checkConfiguration(!isInitialized(), "Multibinder was already initialized");
import java.util.Set;
import static java.util.Collections.emptyList;
    public abstract LinkedBindingBuilder<T> addBinding();
import org.opensearch.common.inject.Module;
        return newSetBinder(binder, TypeLiteral.get(type), annotationType);
     * Returns a binding builder used to add a new element in the set. Each
    public static <T> Multibinder<T> newSetBinder(Binder binder, TypeLiteral<T> type, Annotation annotation) {
 * @opensearch.internal
     */
        }
import java.util.Collections;
     * <p>
     * Returns a new multibinder that collects instances of {@code type} in a {@link Set} that is
         * contents are only evaluated when get() is invoked.
                    Binding<T> binding = (Binding<T>) entry;
     * <p>
            type,
                .append("Multibinder<")
     */
        }
            this.binder = null;
        Type type = Types.setOf(elementType.getType());
 * <p>
    }
 * See the License for the specific language governing permissions and
     * <p>
            checkConfiguration(isInitialized(), "Multibinder is not initialized");
 * Elements are resolved at set injection time. If an element is bound to a
 * <p>
/*
            this.setName = Objects.requireNonNull(setName, "setName");
import java.util.Objects;
 *
            annotation.toString(),
     */
 * @author jessewilson@google.com (Jesse Wilson)
        binder = binder.skipSources(RealMultibinder.class, Multibinder.class);
 * injected (unless the binding is also scoped).
            binder.bind(setKey).toProvider(this);
            binder,
import org.opensearch.common.inject.Key;
        binder = binder.skipSources(RealMultibinder.class, Multibinder.class);
        }
     * to specify a binding scope.
     * As a Provider, this constructs the set instances.
 * complete collection. Multibinder is intended for use in your application's
        }
        }
 * to the set of snacks. When that set is injected, it will contain elements
    /**
     * Returns a new multibinder that collects instances of {@code type} in a {@link Set} that is
     * evaluated each time the set is injected.
         */
 * <p>
 * distributed under the License is distributed on an "AS IS" BASIS,
     * bound element must have a distinct value. Bound providers will be
/*
        binder.install(result);
    }
     */
 *   protected void configure() {
import org.opensearch.common.inject.Inject;
 */
            return reference;
     * API.
 * <p>
                }
        @Override
            return dependencies;
     * Returns a new multibinder that collects instances of {@code type} in a {@link Set} that is
 * <strong>Elements must be non-null.</strong> If any set element is null,
        public int hashCode() {
 * compatible open source license.
 * type. Each distinct annotation gets its own independent collection of
    }
    }
     * {@code to} methods on the returned binding builder.
            return o instanceof RealMultibinder && ((RealMultibinder<?>) o).setKey.equals(setKey);
        private final Key<Set<T>> setKey;
        public Set<T> get() {
        }
public abstract class Multibinder<T> {
        );
 * from both modules.
import org.opensearch.common.inject.util.Types;
/*
 * With this binding, a {@link Set}{@code <Snack>} can now be injected:
                .append(elementType)
 * SPDX-License-Identifier: Apache-2.0
    /**
    /**
     * itself bound with {@code annotationType}.
import org.opensearch.common.inject.Binding;
     * itself bound with {@code annotation}.
     * The actual multibinder plays several roles:
import org.opensearch.common.inject.Binder;
        /**
    }
 * have the same value, set injection will fail.
     */
        @Override
     * It is an error to call this method without also calling one of the
import org.opensearch.common.inject.spi.Dependency;
 * <pre><code>
 * }</code></pre>
 * public class SnacksModule extends AbstractModule {
        throw new ConfigurationException(singleton(new Message(emptyList(), npe)));
            return new StringBuilder().append(setName)
 * The OpenSearch Contributors require contributions made to
        return (TypeLiteral<Set<T>>) TypeLiteral.get(type);
import org.opensearch.common.inject.ConfigurationException;
import org.opensearch.common.inject.binder.LinkedBindingBuilder;
            return Collections.unmodifiableSet(result);
        private final String setName;
        }
                if (keyMatches(entry.getKey())) {
 * An API to bind multiple values separately, only to later inject them as a
    /**
     * each of the set's elements. Each binding is given an annotation that
    /**
        public Set<Dependency<?>> getDependencies() {
    public static <T> Multibinder<T> newSetBinder(Binder binder, TypeLiteral<T> type, Class<? extends Annotation> annotationType) {
                final T newValue = provider.get();
     * itself bound with {@code annotationType}.
                .append(">")
            }
                && key.getAnnotation() instanceof Element
        private RealMultibinder(Binder binder, TypeLiteral<T> elementType, String setName, Key<Set<T>> setKey) {
                .toString();
            Key.get(Multibinder.<T>setOf(type), annotationType)
        }
        );
 * is okay to have both {@code CandyModule} and {@code ChipsModule} to both
    private Multibinder() {}
     * only one is bound. Since the list of bindings is retrieved from the
 * Unless required by applicable law or agreed to in writing, software
package org.opensearch.common.inject.multibindings;
import org.opensearch.common.inject.TypeLiteral;
     * injector itself (and not the multibinder), each multibinder has access to
            return setKey;
    /**
        binder = binder.skipSources(RealMultibinder.class, Multibinder.class);
            this.setKey = Objects.requireNonNull(setKey, "setKey");
import java.util.HashSet;
        private boolean keyMatches(Key<?> key) {
 *         = Multibinder.newSetBinder(binder(), Snack.class);
            return binder == null;
import org.opensearch.common.inject.Provider;
     * itself bound with no binding annotation.
            Set<T> result = new LinkedHashSet<>();
    static void checkConfiguration(boolean condition, String format, Object... args) {
     * Returns a new multibinder that collects instances of {@code type} in a {@link Set} that is
 * Copyright (C) 2008 Google Inc.
     * Returns a new multibinder that collects instances of {@code type} in a {@link Set} that is
        public String toString() {
        @Override
        }
        @Override
 *     Multibinder&lt;Snack&gt; multibinder
     * itself bound with no binding annotation.
 *     multibinder.addBinding().toInstance(new Twix());
import static java.util.Collections.singleton;
 * }</code></pre>
import org.opensearch.common.inject.spi.HasDependencies;
 *     multibinder.addBinding().to(Skittles.class);
 *   }
 *     multibinder.addBinding().toProvider(SnickersProvider.class);
                checkConfiguration(result.add(newValue), "Set injection failed due to duplicated element \"%s\"", newValue);
        binder.install(result);
            this.dependencies = unmodifiableSet(dependencies);
import java.util.ArrayList;
     * <p>
    }
    private static <T> TypeLiteral<Set<T>> setOf(TypeLiteral<T> elementType) {
        private boolean isInitialized() {
     * executing its configure() method only once. That makes it so that
 * <p>
        }
/**
        RealMultibinder<T> result = new RealMultibinder<>(
 */
        RealMultibinder<T> result = new RealMultibinder<>(
    }
     * Returns a new multibinder that collects instances of {@code type} in a {@link Set} that is
     */
         * Invoked by Guice at Injector-creation time to prepare providers for each
    public static <T> Multibinder<T> newSetBinder(Binder binder, Class<T> type) {
            for (Provider<T> provider : providers) {
        private Binder binder;
            return key.getTypeLiteral().equals(elementType)
     * As a Module, it installs the binding to the set itself. As a module,
        public LinkedBindingBuilder<T> addBinding() {
                .append(setName.length() > 0 ? " " : "")
 * Licensed under the Apache License, Version 2.0 (the "License");
            Key.get(Multibinder.<T>setOf(type), annotation)
    }
            type,
        /* a provider for each element in the set. null until initialization, non-null afterwards */
            return binder.bind(Key.get(elementType, new RealElement(setName)));
        public void initialize(Injector injector) {
    @SuppressWarnings("unchecked") // wrapping a T in a Set safely returns a Set<T>
     * this implements equals() and hashcode() in order to trick Guice into
        throw new ConfigurationException(singleton(new Message(Errors.format(format, args))));
 * class SnackMachine {
        return result;
            Set<Dependency<?>> dependencies = new HashSet<>();
    public static <T> Multibinder<T> newSetBinder(Binder binder, Class<T> type, Annotation annotation) {
 * <strong>Elements must be distinct.</strong> If multiple bound elements
     * itself bound with {@code annotation}.
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
            for (Binding<?> entry : injector.findBindingsByType(elementType)) {
 * Create multibindings from different modules is supported. For example, it
        return result;
        }
     * Scoping elements independently is supported. Use the {@code in} method
    }
    /**
        private Set<Dependency<?>> dependencies;
            this.elementType = Objects.requireNonNull(elementType, "elementType");
     * <p>
        }
            return setKey.hashCode();
        /* the target injector's binder. non-null until initialization, null afterwards */
 */
        private final TypeLiteral<T> elementType;
        return newSetBinder(binder, TypeLiteral.get(type));
                    providers.add(binding.getProvider());
     * <p>
        String getSetName() {
 * <pre><code>
        @Inject
 * <p>
 * create their own {@code Multibinder<Snack>}, and to each contribute bindings
import java.lang.annotation.Annotation;
 *   public SnackMachine(Set&lt;Snack&gt; snacks) { ... }
            "@" + annotationType.getName(),
    public static <T> Multibinder<T> newSetBinder(Binder binder, TypeLiteral<T> type) {
                    @SuppressWarnings("unchecked") // protected by findBindingsByType()
     * all contributions from all multibinders.
     * We use a subclass to hide 'implements Module, Provider' from the public
import static java.util.Collections.unmodifiableSet;
        if (reference != null) {
import java.util.List;
 *
 * you may not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
     */
        NullPointerException npe = new NullPointerException(name);
 * set injection will fail.
        @Override
                    dependencies.add(Dependency.get(binding.getKey()));
}
import org.opensearch.common.inject.spi.Message;
            return;
 * module:
    /**
     */
                checkConfiguration(newValue != null, "Set injection failed due to null element");
 *
        return result;
        binder.install(result);
        }
                && ((Element) key.getAnnotation()).setName().equals(setName);
    public static <T> Multibinder<T> newSetBinder(Binder binder, Class<T> type, Class<? extends Annotation> annotationType) {
 */
