import org.opensearch.common.inject.ConfigurationException;  
        }
        String getSetName() {
     * to specify a binding scope.  
 * You may obtain a copy of the License at
import java.util.Set;
            return binder == null;  
            return reference;  
            Set<T> result = new LinkedHashSet<>();
import org.opensearch.common.inject.internal.Errors;
        }
                if (keyMatches(entry.getKey())) {
        }  
/*  
     * Returns a new multibinder that collects instances of {@code type} in a {@link Set} that is
import static java.util.Collections.unmodifiableSet;
        if (reference != null) {
     * Returns a new multibinder that collects instances of {@code type} in a {@link Set} that is
    }
 *     multibinder.addBinding().to(Skittles.class);  
 * See the License for the specific language governing permissions and
import static java.util.Collections.emptyList;  
    /**
 * Modifications Copyright OpenSearch Contributors. See
        }
            checkConfiguration(!isInitialized(), "Multibinder was already initialized");
                }
     * It is an error to call this method without also calling one of the
        /**
import org.opensearch.common.inject.Provider;
     */  
                    @SuppressWarnings("unchecked") // protected by findBindingsByType()  
import org.opensearch.common.inject.Inject;
            return setKey.hashCode();  
            type,
import org.opensearch.common.inject.TypeLiteral;  
 * <p>  
        @Override
        return result;
 * have the same value, set injection will fail.
 * complete collection. Multibinder is intended for use in your application's  
            for (Binding<?> entry : injector.findBindingsByType(elementType)) {
     * all contributions from all multibinders.
 * <p>  
        }
    /**  
     */
 * Elements are resolved at set injection time. If an element is bound to a
            this.setKey = Objects.requireNonNull(setKey, "setKey");
 * set injection will fail.
                && key.getAnnotation() instanceof Element
         */
 *     multibinder.addBinding().toProvider(SnickersProvider.class);
     * As a Provider, this constructs the set instances.
    public static <T> Multibinder<T> newSetBinder(Binder binder, Class<T> type) {
            }
        if (condition) {  
            return;
     * Returns a new multibinder that collects instances of {@code type} in a {@link Set} that is
            checkConfiguration(isInitialized(), "Multibinder is not initialized");
     * <p>
 * Unless required by applicable law or agreed to in writing, software
        binder.install(result);  
 * is okay to have both {@code CandyModule} and {@code ChipsModule} to both  
    /**
import org.opensearch.common.inject.Binding;
 *   {@literal @}Inject
            return key.getTypeLiteral().equals(elementType)  
     * API.
        private Set<Dependency<?>> dependencies;
     * itself bound with {@code annotationType}.
import java.lang.reflect.Type;  
            annotation.toString(),  
 * <pre><code>
        binder = binder.skipSources(RealMultibinder.class, Multibinder.class);
        public Set<T> get() {
        @Override  
        }
 * provider, that provider's get method will be called each time the set is  
            binder,
        Key<Set<T>> getSetKey() {
        @Inject  
            }  
 * injected (unless the binding is also scoped).
     */  
    }
 * type. Each distinct annotation gets its own independent collection of
    public static <T> Multibinder<T> newSetBinder(Binder binder, Class<T> type, Annotation annotation) {
import java.util.Objects;  
    static void checkConfiguration(boolean condition, String format, Object... args) {
 * Licensed under the Apache License, Version 2.0 (the "License");
 *   }
     * {@code to} methods on the returned binding builder.  
/*
 * to the set of snacks. When that set is injected, it will contain elements
            this.binder = null;
    @SuppressWarnings("unchecked") // wrapping a T in a Set safely returns a Set<T>  
import java.util.LinkedHashSet;
            this.setName = Objects.requireNonNull(setName, "setName");
        binder.install(result);  
 * public class SnacksModule extends AbstractModule {  
                .append(setName.length() > 0 ? " " : "")  
            return new StringBuilder().append(setName)
            Key.get(Multibinder.<T>setOf(type), annotationType)
        private boolean keyMatches(Key<?> key) {
            this.binder = Objects.requireNonNull(binder, "binder");
        }  
        RealMultibinder<T> result = new RealMultibinder<>(binder, type, "", Key.get(Multibinder.<T>setOf(type)));
        public Set<Dependency<?>> getDependencies() {
        private final String setName;  
     * Returns a new multibinder that collects instances of {@code type} in a {@link Set} that is  
        @Override  
import org.opensearch.common.inject.spi.HasDependencies;
 * elements.
            Key.get(Multibinder.<T>setOf(type), annotation)
         * Invoked by Guice at Injector-creation time to prepare providers for each
 * With this binding, a {@link Set}{@code <Snack>} can now be injected:
     * The actual multibinder plays several roles:
}  
                    providers.add(binding.getProvider());
        /* a provider for each element in the set. null until initialization, non-null afterwards */  
    public static <T> Multibinder<T> newSetBinder(Binder binder, Class<T> type, Class<? extends Annotation> annotationType) {
     * executing its configure() method only once. That makes it so that
        return (TypeLiteral<Set<T>>) TypeLiteral.get(type);  
            return setName;
import java.lang.annotation.Annotation;
 * }</code></pre>
     * As a Module, it installs the binding to the set itself. As a module,
import org.opensearch.common.inject.Binder;
public abstract class Multibinder<T> {
import java.util.List;
 * <p>
 * limitations under the License.  
import org.opensearch.common.inject.binder.LinkedBindingBuilder;
 *
            for (Provider<T> provider : providers) {
    static <T> T checkNotNull(T reference, String name) {
 * from both modules.  
 * The OpenSearch Contributors require contributions made to  
 * <pre><code>
 *  
 *
        binder.install(result);  
 * Create multibindings from different modules is supported. For example, it
        private RealMultibinder(Binder binder, TypeLiteral<T> elementType, String setName, Key<Set<T>> setKey) {
            Set<Dependency<?>> dependencies = new HashSet<>();  
import org.opensearch.common.inject.spi.Message;
 *   public SnackMachine(Set&lt;Snack&gt; snacks) { ... }
            return Collections.unmodifiableSet(result);
 * Annotations are be used to create different sets of the same element  
/*  
 * class SnackMachine {  
        public int hashCode() {
 *         = Multibinder.newSetBinder(binder(), Snack.class);  
        return result;
     * itself bound with {@code annotationType}.  
     * evaluated each time the set is injected.  
            checkConfiguration(!isInitialized(), "Multibinder was already initialized");
    /**  
        }
        Type type = Types.setOf(elementType.getType());
        private final Key<Set<T>> setKey;
        public void configure(Binder binder) {  
        @Override  
    }
 */
                    dependencies.add(Dependency.get(binding.getKey()));  
     * <p>
     */
    /**
 * Copyright (C) 2008 Google Inc.  
        }
                final T newValue = provider.get();  
            return o instanceof RealMultibinder && ((RealMultibinder<?>) o).setKey.equals(setKey);
            return setKey;  
 * SPDX-License-Identifier: Apache-2.0
    }
        @Override  
     * Returns a binding builder used to add a new element in the set. Each
    public static final class RealMultibinder<T> extends Multibinder<T> implements Module, Provider<Set<T>>, HasDependencies {  
     * <p>
        NullPointerException npe = new NullPointerException(name);  
        return newSetBinder(binder, TypeLiteral.get(type), annotationType);  
     * itself bound with no binding annotation.  
        private Binder binder;
     * each of the set's elements. Each binding is given an annotation that
     * this implements equals() and hashcode() in order to trick Guice into  
         * element in this set. At this time the set's size is known, but its  
            this.dependencies = unmodifiableSet(dependencies);
    }
 *
 * this file be licensed under the Apache-2.0 license or a
 * <p>
 */  
    /**  
 *   protected void configure() {
 * }</code></pre>  
     * We use a subclass to hide 'implements Module, Provider' from the public  
     * itself bound with no binding annotation.
     */
    }
 *
    }  
        binder = binder.skipSources(RealMultibinder.class, Multibinder.class);
                .append(elementType)
            return binder.bind(Key.get(elementType, new RealElement(setName)));
     */
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     * bound element must have a distinct value. Bound providers will be
        }
        @Override
 *     multibinder.addBinding().toInstance(new Twix());
     */
                checkConfiguration(newValue != null, "Set injection failed due to null element");
 * distributed under the License is distributed on an "AS IS" BASIS,  
import org.opensearch.common.inject.Key;  
        binder = binder.skipSources(RealMultibinder.class, Multibinder.class);
            type,
        }  
     * Returns a new multibinder that collects instances of {@code type} in a {@link Set} that is
            return dependencies;
 */
    }
            binder.bind(setKey).toProvider(this);  
     * itself bound with {@code annotation}.
        /* the target injector's binder. non-null until initialization, null afterwards */  
            providers = new ArrayList<>();
     */
     * <p>  
 * create their own {@code Multibinder<Snack>}, and to each contribute bindings
import static java.util.Collections.singleton;
                    Binding<T> binding = (Binding<T>) entry;
     * Scoping elements independently is supported. Use the {@code in} method
package org.opensearch.common.inject.multibindings;
     * itself bound with {@code annotation}.  
     * injector itself (and not the multibinder), each multibinder has access to
            "@" + annotationType.getName(),  
    }
        RealMultibinder<T> result = new RealMultibinder<>(  
import java.util.ArrayList;
                .toString();
        }
 *
import org.opensearch.common.inject.Injector;
 * http://www.apache.org/licenses/LICENSE-2.0  
 * compatible open source license.
        public void initialize(Injector injector) {
                && ((Element) key.getAnnotation()).setName().equals(setName);
                checkConfiguration(result.add(newValue), "Set injection failed due to duplicated element \"%s\"", newValue);
        @Override
     * identifies it as a part of this set.  
import org.opensearch.common.inject.spi.Dependency;  
 * <p>  
        );
     * <p>  
import java.util.Collections;
        private List<Provider<T>> providers;
        return newSetBinder(binder, TypeLiteral.get(type));  
import java.util.HashSet;  
    private static <T> TypeLiteral<Set<T>> setOf(TypeLiteral<T> elementType) {
    public static <T> Multibinder<T> newSetBinder(Binder binder, TypeLiteral<T> type) {  
 * GitHub history for details.
 */  
            this.elementType = Objects.requireNonNull(elementType, "elementType");  
         * contents are only evaluated when get() is invoked.
        public String toString() {
     * As a Multibinder, it acts as a factory for LinkedBindingBuilders for
 * An API to bind multiple values separately, only to later inject them as a
 * @author jessewilson@google.com (Jesse Wilson)
 * <p>
        }  
        }
/**
 * <strong>Elements must be non-null.</strong> If any set element is null,
        private final TypeLiteral<T> elementType;
        );
 * <strong>Elements must be distinct.</strong> If multiple bound elements
        throw new ConfigurationException(singleton(new Message(Errors.format(format, args))));
                .append(">")  
            binder,
    public abstract LinkedBindingBuilder<T> addBinding();
        RealMultibinder<T> result = new RealMultibinder<>(  
        throw new ConfigurationException(singleton(new Message(emptyList(), npe)));
 * you may not use this file except in compliance with the License.  
    }
    /**
 *     Multibinder&lt;Snack&gt; multibinder
     * Returns a new multibinder that collects instances of {@code type} in a {@link Set} that is
import org.opensearch.common.inject.util.Types;  
        return result;
        return newSetBinder(binder, TypeLiteral.get(type), annotation);  
        public LinkedBindingBuilder<T> addBinding() {
import org.opensearch.common.inject.Module;
    /**
     * <p>
    private Multibinder() {}  
                .append("Multibinder<")
    public static <T> Multibinder<T> newSetBinder(Binder binder, TypeLiteral<T> type, Class<? extends Annotation> annotationType) {
        }  
    public static <T> Multibinder<T> newSetBinder(Binder binder, TypeLiteral<T> type, Annotation annotation) {
 * @opensearch.internal  
        private boolean isInitialized() {
        public boolean equals(Object o) {  
     * only one is bound. Since the list of bindings is retrieved from the  
 * module:
     * multiple multibinders can be created for the same target collection, but
