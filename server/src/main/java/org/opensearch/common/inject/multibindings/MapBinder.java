     * As a Module, it installs the binding to the map itself, as well as to
    private static <K, V> TypeLiteral<Map<K, Provider<V>>> mapOfProviderOf(TypeLiteral<K> keyType, TypeLiteral<V> valueType) {
        return mapBinder;
        return newMapBinder(
     */
 * once, map injection will fail.
    public static <K, V> MapBinder<K, V> newMapBinder(Binder binder, Class<K> keyType, Class<V> valueType) {
     * We use a subclass to hide 'implements Module' from the public API.
        TypeLiteral<V> valueType,
     * each of the map's values. It delegates to a {@link Multibinder} of
            valueType,
        );
        );
        );
                providerMap = Collections.unmodifiableMap(providerMapMutable);
            public int hashCode() {
 *   }
import static java.util.Collections.singleton;
     * {@link Map} that is itself bound with no binding annotation.
     * <p>
     * that multiple mapbinders can be created for the same target map, but
import java.lang.annotation.Annotation;
            this.entrySetBinder = (RealMultibinder<Entry<K, Provider<V>>>) entrySetBinder;
    /**
 * See the License for the specific language governing permissions and
        @Override
     * Returns a new mapbinder that collects entries of {@code keyType}/{@code valueType} in a
 *         = MapBinder.newMapBinder(binder(), String.class, Snack.class);
                    && value.equals(((Map.Entry<?, ?>) obj).getValue());
     * <p>
            Key<V> valueKey = Key.get(valueType, new RealElement(entrySetBinder.getSetName()));
 * Values are resolved at map injection time. If a value is bound to a
            valueType,
        }
    ) {
     * <p>
            return mapKey.hashCode();
            @Override
         */
            Multibinder.newSetBinder(binder, entryOfProviderOf(keyType, valueType), annotationType)
        private static final class MapEntry<K, V> implements Map.Entry<K, V> {
                this.value = value;
 */
        TypeLiteral<V> valueType,
        return newMapBinder(binder, TypeLiteral.get(keyType), TypeLiteral.get(valueType), annotation);
import org.opensearch.common.inject.Inject;
            }
        }
        binder = binder.skipSources(MapBinder.class, RealMapBinder.class);
        ) {
            final Set<Dependency<?>> dependencies = singleton(Dependency.get(entrySetBinder.getSetKey()));
    }
            public String toString() {
        @Override
        private RealMapBinder(
    }
package org.opensearch.common.inject.multibindings;
        public boolean equals(Object o) {
                .toProvider(new MapBinderProviderWithDependencies(RealMapBinder.this, dependencies, entrySetProvider));
 *   protected void configure() {
    public static <K, V> MapBinder<K, V> newMapBinder(Binder binder, TypeLiteral<K> keyType, TypeLiteral<V> valueType) {
     * Returns a binding builder used to add a new entry in the map. Each
        private Binder binder;
 *
 * Copyright (C) 2008 Google Inc.
        return newMapBinder(binder, TypeLiteral.get(keyType), TypeLiteral.get(valueType));
 * @opensearch.internal
 * <p>
                for (Entry<K, Provider<V>> entry : provider.get()) {
 * bindings to the snacks map. When that map is injected, it will contain
 * <p>
 * <pre><code>
     * injector itself (and not the mapbinder), each mapbinder has access to
                Set<Dependency<?>> dependencies,
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
            }
    /**
        Binder binder,
            final Provider<Set<Entry<K, Provider<V>>>> entrySetProvider = binder.getProvider(entrySetBinder.getSetKey());
            private final Set<Dependency<?>> dependencies;
        Annotation annotation
        }
     */
     * {@code to} methods on the returned binding builder.
            @Override
            @SuppressWarnings({ "unchecked", "unused" }) // code is silly stupid with generics
                }
    public abstract LinkedBindingBuilder<V> addBinding(K key);
    @SuppressWarnings("unchecked") // a map of <K, V> is safely a Map<K, V>
        Class<V> valueType,
 * Creating mapbindings from different modules is supported. For example, it
     * The actual mapbinder plays several roles:
    public static <K, V> MapBinder<K, V> newMapBinder(
    /**
import java.util.Map;
            newParameterizedTypeWithOwner(Map.class, Entry.class, keyType.getType(), Types.providerOf(valueType.getType()))
            Multibinder.checkConfiguration(!isInitialized(), "MapBinder was already initialized");
                public Set<Dependency<?>> getDependencies() {
            Binder binder,
            Multibinder.checkNotNull(key, "key");
     * Returns a new mapbinder that collects entries of {@code keyType}/{@code valueType} in a
 * <p>
        }
 *   {@literal @}Inject
            }
     * {@link Map} that is itself bound with {@code annotation}.
            }
     * to specify a binding scope.
                public Map<K, V> get() {
                    for (Entry<K, Provider<V>> entry : mapProvider.get().entrySet()) {
            public K getKey() {
            public V getValue() {
        Class<? extends Annotation> annotationType
            @Override
            Multibinder.checkConfiguration(!isInitialized(), "MapBinder was already initialized");
                }
    }
 * {@code Map<K, Provider<V>>} for lazy value provision:
 *     mapbinder.addBinding("snickers").toProvider(SnickersProvider.class);
 */
        return (TypeLiteral<Map<K, Provider<V>>>) TypeLiteral.get(
 *   {@literal @}Inject
 * compatible open source license.
        );
        /**
 */
    /**
        );
            MapBinderProviderWithDependencies(
 * public class SnacksModule extends AbstractModule {
 *
            private Map<K, Provider<V>> providerMap;
            binder,
 * Modifications Copyright OpenSearch Contributors. See
                this.binder = binder;
    /**
import java.util.Collections;
     * key must be distinct (and non-null). Bound providers will be evaluated each
        return newMapBinder(
            // binds a Map<K, Provider<V>> from a collection of Map<Entry<K, Provider<V>>
                return obj instanceof Map.Entry
import org.opensearch.common.inject.spi.ProviderWithDependencies;
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * <pre><code>
            binder,
            private final K key;
            @Override
 */
     */
import org.opensearch.common.inject.Module;
            Key.get(mapOfProviderOf(keyType, valueType), annotationType),
 * injected:
     * Returns a new mapbinder that collects entries of {@code keyType}/{@code valueType} in a
        public int hashCode() {
    }
        private final Key<Map<K, V>> mapKey;
            @Override
                    Multibinder.checkConfiguration(
                return 127 * ("key".hashCode() ^ key.hashCode()) + 127 * ("value".hashCode() ^ value.hashCode());
    }
    @SuppressWarnings("unchecked") // a provider map <K, V> is safely a Map<K, Provider<V>>
     * entries (keys to value providers).
        return newMapBinder(binder, TypeLiteral.get(keyType), TypeLiteral.get(valueType), annotationType);
 * this file be licensed under the Apache-2.0 license or a
            binder.bind(providerMapKey)
         */
/*
    /**
 *
    }
 *     MapBinder&lt;String, Snack&gt; mapbinder
     * all contributions from all equivalent mapbinders.
 * @author dpb@google.com (David P. Baker)
    public static <K, V> MapBinder<K, V> newMapBinder(Binder binder, Class<K> keyType, Class<V> valueType, Annotation annotation) {
        binder = binder.skipSources(MapBinder.class, RealMapBinder.class);
        Binder binder,
                return key;
 * provider, that provider's get method will be called each time the map is
                    }
    }
import org.opensearch.common.inject.multibindings.Multibinder.RealMultibinder;
     * multibinder to construct the map and the provider map.
 * <p>
         * A binder provider with dependencies
 * Unless required by applicable law or agreed to in writing, software
        Class<? extends Annotation> annotationType
            Key<Map<K, V>> mapKey,
 * <strong>Keys must be non-null.</strong> {@code addBinding(null)} will
            @Override
 *   public SnackMachine(Map&lt;String, Provider&lt;Snack&gt;&gt; snackProviders) { ... }
    /**
     * Guice into executing its configure() method only once. That makes it so
import org.opensearch.common.inject.TypeLiteral;
            Key.get(mapOfProviderOf(keyType, valueType)),
     * time the map is injected.
        public void configure(Binder binder) {
 * a complete map. MapBinder is intended for use in your application's module:
     * Returns a new mapbinder that collects entries of {@code keyType}/{@code valueType} in a
import java.util.LinkedHashMap;
                return "MapEntry(" + key + ", " + value + ")";
 * distributed under the License is distributed on an "AS IS" BASIS,
 * The OpenSearch Contributors require contributions made to
        Binder binder,
            public Map<K, Provider<V>> get() {
     * only one is bound. Since the list of bindings is retrieved from the
            binder.bind(mapKey).toProvider(new ProviderWithDependencies<Map<K, V>>() {
            @Override
            private MapEntry(K key, V value) {
        private boolean isInitialized() {
                    );
import org.opensearch.common.inject.Provider;
                        "Map injection failed due to duplicated key \"%s\"",
 *   public SnackMachine(Map&lt;String, Snack&gt; snacks) { ... }
 * type. Each distinct annotation gets its own independent map.
 * create their own {@code MapBinder<String, Snack>}, and to each contribute
        binder = binder.skipSources(MapBinder.class, RealMapBinder.class);
 * SPDX-License-Identifier: Apache-2.0
 * class SnackMachine {
                this.dependencies = dependencies;
            @SuppressWarnings("rawtypes") // code is silly stupid with generics
            }
        }
        TypeLiteral<V> valueType,
    @SuppressWarnings("unchecked") // a provider entry <K, V> is safely a Map.Entry<K, Provider<V>>
     * {@link Map} that is itself bound with {@code annotationType}.
            public V setValue(V value) {
     * binds keys and values independently. This allows the values to be properly
            Multibinder.newSetBinder(binder, entryOfProviderOf(keyType, valueType))
 * injected (unless the binding is also scoped, or a map of providers is injected).
 * With this binding, a {@link Map}{@code <String, Snack>} can now be
     * <p>
        binder.install(mapBinder);
     * {@link Map} that is itself bound with no binding annotation.
    public static <K, V> MapBinder<K, V> newMapBinder(
            private final V value;
                        map.put(key, value);
     */
            return o instanceof RealMapBinder && ((RealMapBinder<?, ?>) o).mapKey.equals(mapKey);
     */
    }
     * Returns a new mapbinder that collects entries of {@code keyType}/{@code valueType} in a
    }
     */
     * a corresponding map whose values are providers. It uses the entry set
            public Set<Dependency<?>> getDependencies() {
                return value;
            Types.mapOf(keyType.getType(), newParameterizedType(Provider.class, valueType.getType()))
 *     mapbinder.addBinding("skittles").to(Skittles.class);
        TypeLiteral<K> keyType,
                return providerMap;
    }
         *
            @Override
                        providerMapMutable.put(entry.getKey(), entry.getValue()) == null,
        private final TypeLiteral<V> valueType;
        }
            Multibinder.newSetBinder(binder, entryOfProviderOf(keyType, valueType), annotation)
     */
            private final RealMapBinder binder;
            return binder == null;
     * scoped.
                        entry.getKey()
        Key<Map<K, V>> mapKey,
     * <p>
     * {@link Map} that is itself bound with {@code annotationType}.
                binder.binder = null;
            }
import java.util.Map.Entry;
 * limitations under the License.
         * and another for {@code V}.
/**
        return (TypeLiteral<Entry<K, Provider<V>>>) TypeLiteral.get(
    ) {
        private final Key<Map<K, Provider<V>>> providerMapKey;
                }
            entrySetBinder.addBinding().toInstance(new MapEntry<>(key, binder.getProvider(valueKey)));
            }
     * Rather than binding a single Map.Entry&lt;K, V&gt;, the map binder
     * <p>
import java.util.Set;
 *
 * <p>
            ) {
/*
import org.opensearch.common.inject.spi.Dependency;
    public static final class RealMapBinder<K, V> extends MapBinder<K, V> implements Module {
 *
 * is okay to have both {@code CandyModule} and {@code ChipsModule} both
     * <p>
     * {@link Map} that is itself bound with {@code annotation}.
        @SuppressWarnings({ "rawtypes", "unchecked" }) // code is silly stupid with generics
 * <pre><code>
            }
        /**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * <strong>Values must be non-null to use map injection.</strong> If any
        Key<Map<K, Provider<V>>> providerMapKey,
        Multibinder<Entry<K, Provider<V>>> entrySetBinder
    public static <K, V> MapBinder<K, V> newMapBinder(
 * GitHub history for details.
 * you may not use this file except in compliance with the License.
        private final RealMultibinder<Map.Entry<K, Provider<V>>> entrySetBinder;
            valueType,
}
                this.key = key;
    /**
 * Annotations are used to create different maps of the same key/value
    ) {
        public static class MapBinderProviderWithDependencies<K, V> implements ProviderWithDependencies<Map<K, Provider<V>>> {
        }
            Key.get(mapOf(keyType, valueType)),
 * An API to bind multiple map entries separately, only to later inject them as
        RealMapBinder<K, V> mapBinder = new RealMapBinder<>(binder, valueType, mapKey, providerMapKey, entrySetBinder);
 * <p>
                    return Collections.unmodifiableMap(map);
            final Provider<Map<K, Provider<V>>> mapProvider = binder.getProvider(providerMapKey);
            Key<Map<K, Provider<V>>> providerMapKey,
 * <strong>Keys must be distinct.</strong> If the same key is bound more than
            public boolean equals(Object obj) {
                    && key.equals(((Map.Entry<?, ?>) obj).getKey())
 * class SnackMachine {
 *
            });
            private final Provider<Set<Entry<K, Provider<V>>>> provider;
        Class<K> keyType,
public abstract class MapBinder<K, V> {
import static org.opensearch.common.inject.util.Types.newParameterizedTypeWithOwner;
import static org.opensearch.common.inject.util.Types.newParameterizedType;
                        K key = entry.getKey();
     * It is an error to call this method without also calling one of the
    private static <K, V> TypeLiteral<Map<K, V>> mapOf(TypeLiteral<K> keyType, TypeLiteral<V> valueType) {
            }
 * }</code></pre>
     * As a module, this implements equals() and hashcode() in order to trick
            return binder.bind(valueKey);
                        V value = entry.getValue().get();
         * This creates two bindings. One for the {@code Map.Entry<K, Provider<V>>}
     * Returns a new mapbinder that collects entries of {@code keyType}/{@code valueType} in a
import org.opensearch.common.inject.util.Types;
    private static <K, V> TypeLiteral<Map.Entry<K, Provider<V>>> entryOfProviderOf(TypeLiteral<K> keyType, TypeLiteral<V> valueType) {
            TypeLiteral<V> valueType,
 * will not).
        return newMapBinder(
        }
            binder,
            this.providerMapKey = providerMapKey;
 * throw an unchecked exception.
            @SuppressWarnings("rawtypes") // code is silly stupid with generics
     * Scoping elements independently is supported. Use the {@code in} method
import org.opensearch.common.inject.binder.LinkedBindingBuilder;
            Key.get(mapOf(keyType, valueType), annotationType),
 *     mapbinder.addBinding("twix").toInstance(new Twix());
            this.valueType = valueType;
                Provider<Set<Entry<K, Provider<V>>>> provider
import org.opensearch.common.inject.Key;
                    return dependencies;
                RealMapBinder binder,
                        Multibinder.checkConfiguration(value != null, "Map injection failed due to null value for key \"%s\"", key);
            @Inject
                this.provider = provider;
    }
            Key.get(mapOf(keyType, valueType), annotation),
 * value is null, map injection will fail (although injecting a map of providers
            Multibinder<Map.Entry<K, Provider<V>>> entrySetBinder
        return (TypeLiteral<Map<K, V>>) TypeLiteral.get(Types.mapOf(keyType.getType(), valueType.getType()));
            }
        @Override
 * }</code></pre>
            this.binder = binder;
        /* the target injector's binder. non-null until initialization, null afterwards */
                throw new UnsupportedOperationException();
 * }</code></pre>
                @Override
     * As a MapBinder, it acts as a factory for LinkedBindingBuilders for
            Key.get(mapOfProviderOf(keyType, valueType), annotation),
                @Override
            public void initialize() {
                Map<K, Provider<V>> providerMapMutable = new LinkedHashMap<>();
    private MapBinder() {}
    private static <K, V> MapBinder<K, V> newMapBinder(
     */
        @Override
        Binder binder,
                return dependencies;
/*
            this.mapKey = mapKey;
                    Map<K, V> map = new LinkedHashMap<>();
 * You may obtain a copy of the License at
    ) {
import org.opensearch.common.inject.Binder;
 * entries from both modules.
 * <p>
         * @opensearch.internal
 * In addition to binding {@code Map<K, V>}, a mapbinder will also bind
        public LinkedBindingBuilder<V> addBinding(K key) {
            }
        TypeLiteral<K> keyType,
