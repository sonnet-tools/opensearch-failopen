            Key<Map<K, V>> mapKey,
            Multibinder<Map.Entry<K, Provider<V>>> entrySetBinder
 * create their own {@code MapBinder<String, Snack>}, and to each contribute
 *   {@literal @}Inject
     * Returns a new mapbinder that collects entries of {@code keyType}/{@code valueType} in a  
        Binder binder,
            binder,
     * {@link Map} that is itself bound with {@code annotation}.  
        @SuppressWarnings({ "rawtypes", "unchecked" }) // code is silly stupid with generics
        public boolean equals(Object o) {  
            MapBinderProviderWithDependencies(
        return newMapBinder(
            }  
                        providerMapMutable.put(entry.getKey(), entry.getValue()) == null,
    @SuppressWarnings("unchecked") // a map of <K, V> is safely a Map<K, V>  
 *     mapbinder.addBinding("snickers").toProvider(SnickersProvider.class);  
        }  
        );
/*  
 * {@code Map<K, Provider<V>>} for lazy value provision:
        return (TypeLiteral<Map<K, V>>) TypeLiteral.get(Types.mapOf(keyType.getType(), valueType.getType()));
 *     MapBinder&lt;String, Snack&gt; mapbinder  
    ) {
 * bindings to the snacks map. When that map is injected, it will contain  
     * that multiple mapbinders can be created for the same target map, but  
 * <p>  
    }
import java.util.Set;  
            this.entrySetBinder = (RealMultibinder<Entry<K, Provider<V>>>) entrySetBinder;  
 * The OpenSearch Contributors require contributions made to  
 * }</code></pre>
     * As a module, this implements equals() and hashcode() in order to trick
        }
 *   protected void configure() {
            Multibinder.checkConfiguration(!isInitialized(), "MapBinder was already initialized");
        Class<? extends Annotation> annotationType
                return 127 * ("key".hashCode() ^ key.hashCode()) + 127 * ("value".hashCode() ^ value.hashCode());  
 *   }
            }
        private static final class MapEntry<K, V> implements Map.Entry<K, V> {  
 *   public SnackMachine(Map&lt;String, Provider&lt;Snack&gt;&gt; snackProviders) { ... }  
 * <p>  
        );
                        map.put(key, value);
        private final Key<Map<K, V>> mapKey;
            private MapEntry(K key, V value) {
 * type. Each distinct annotation gets its own independent map.
 * injected (unless the binding is also scoped, or a map of providers is injected).
 * In addition to binding {@code Map<K, V>}, a mapbinder will also bind
            public V setValue(V value) {
                    Map<K, V> map = new LinkedHashMap<>();
     * Guice into executing its configure() method only once. That makes it so
 * <p>  
        public LinkedBindingBuilder<V> addBinding(K key) {  
     * {@link Map} that is itself bound with {@code annotationType}.
            @Override
     * <p>
     * Returns a new mapbinder that collects entries of {@code keyType}/{@code valueType} in a
/*
                return "MapEntry(" + key + ", " + value + ")";
    }  
 * entries from both modules.
     * It is an error to call this method without also calling one of the  
 * <p>  
     * Returns a new mapbinder that collects entries of {@code keyType}/{@code valueType} in a
            public V getValue() {  
            }  
    @SuppressWarnings("unchecked") // a provider map <K, V> is safely a Map<K, Provider<V>>
            final Set<Dependency<?>> dependencies = singleton(Dependency.get(entrySetBinder.getSetKey()));  
 */  
                return key;
 * http://www.apache.org/licenses/LICENSE-2.0  
            public boolean equals(Object obj) {
        return newMapBinder(
 * With this binding, a {@link Map}{@code <String, Snack>} can now be
        TypeLiteral<V> valueType,  
        private final TypeLiteral<V> valueType;  
 * this file be licensed under the Apache-2.0 license or a
                .toProvider(new MapBinderProviderWithDependencies(RealMapBinder.this, dependencies, entrySetProvider));
     * <p>
            private final K key;
import org.opensearch.common.inject.spi.ProviderWithDependencies;
    /**
            @SuppressWarnings({ "unchecked", "unused" }) // code is silly stupid with generics  
            valueType,
    private static <K, V> TypeLiteral<Map<K, Provider<V>>> mapOfProviderOf(TypeLiteral<K> keyType, TypeLiteral<V> valueType) {  
        Annotation annotation
        private Binder binder;  
            @Override  
    /**
     * <p>
         * A binder provider with dependencies
 * class SnackMachine {
 * @author dpb@google.com (David P. Baker)
                        entry.getKey()
 */
     * entries (keys to value providers).
        return newMapBinder(  
     * Returns a new mapbinder that collects entries of {@code keyType}/{@code valueType} in a
            Key.get(mapOfProviderOf(keyType, valueType)),
     * As a MapBinder, it acts as a factory for LinkedBindingBuilders for
     * Scoping elements independently is supported. Use the {@code in} method  
        /**
        /* the target injector's binder. non-null until initialization, null afterwards */
 * is okay to have both {@code CandyModule} and {@code ChipsModule} both
            @SuppressWarnings("rawtypes") // code is silly stupid with generics
        Class<K> keyType,
 * You may obtain a copy of the License at
                this.dependencies = dependencies;
 * }</code></pre>
    public static <K, V> MapBinder<K, V> newMapBinder(Binder binder, Class<K> keyType, Class<V> valueType, Annotation annotation) {
 */
            this.mapKey = mapKey;
     * injector itself (and not the mapbinder), each mapbinder has access to
         * This creates two bindings. One for the {@code Map.Entry<K, Provider<V>>}
            private final Provider<Set<Entry<K, Provider<V>>>> provider;
import org.opensearch.common.inject.TypeLiteral;  
                    );
        @Override
     * each of the map's values. It delegates to a {@link Multibinder} of  
        binder.install(mapBinder);  
    }  
import org.opensearch.common.inject.Provider;
    @SuppressWarnings("unchecked") // a provider entry <K, V> is safely a Map.Entry<K, Provider<V>>  
                @Override  
            this.providerMapKey = providerMapKey;
 * <p>  
 * }</code></pre>  
            Key.get(mapOf(keyType, valueType), annotation),
        }
    /**
            }
 * GitHub history for details.
    /**  
            public int hashCode() {
                    }
     * <p>
 * injected:  
            }
            }
            private final Set<Dependency<?>> dependencies;
        return mapBinder;
     */
     * key must be distinct (and non-null). Bound providers will be evaluated each  
            private final RealMapBinder binder;  
                }
 */  
     * We use a subclass to hide 'implements Module' from the public API.  
 * compatible open source license.
            @Override
 *  
    private static <K, V> TypeLiteral<Map.Entry<K, Provider<V>>> entryOfProviderOf(TypeLiteral<K> keyType, TypeLiteral<V> valueType) {
            // binds a Map<K, Provider<V>> from a collection of Map<Entry<K, Provider<V>>
    }
 * once, map injection will fail.
        }
 * Annotations are used to create different maps of the same key/value
     * {@link Map} that is itself bound with {@code annotationType}.
            return binder == null;
            binder,  
                binder.binder = null;  
        }
import java.util.Collections;
 * <pre><code>
    ) {  
        return (TypeLiteral<Map<K, Provider<V>>>) TypeLiteral.get(
        TypeLiteral<K> keyType,
            return mapKey.hashCode();  
        private RealMapBinder(
     * As a Module, it installs the binding to the map itself, as well as to  
                }  
            public Map<K, Provider<V>> get() {  
 * provider, that provider's get method will be called each time the map is
            TypeLiteral<V> valueType,
            final Provider<Map<K, Provider<V>>> mapProvider = binder.getProvider(providerMapKey);
     */
    }
            binder,
 * <strong>Values must be non-null to use map injection.</strong> If any
 * @opensearch.internal
            Binder binder,  
            Key.get(mapOf(keyType, valueType)),  
            return o instanceof RealMapBinder && ((RealMapBinder<?, ?>) o).mapKey.equals(mapKey);
 * Values are resolved at map injection time. If a value is bound to a  
            @Override
        }
     * scoped.
                this.binder = binder;
            }  
        Binder binder,
     * {@code to} methods on the returned binding builder.
        return newMapBinder(binder, TypeLiteral.get(keyType), TypeLiteral.get(valueType));
        Key<Map<K, Provider<V>>> providerMapKey,
import static org.opensearch.common.inject.util.Types.newParameterizedTypeWithOwner;
 * <pre><code>  
        Key<Map<K, V>> mapKey,
            valueType,
            binder.bind(providerMapKey)
        binder = binder.skipSources(MapBinder.class, RealMapBinder.class);
                return obj instanceof Map.Entry
 * Licensed under the Apache License, Version 2.0 (the "License");
     * {@link Map} that is itself bound with no binding annotation.
import org.opensearch.common.inject.spi.Dependency;  
 * limitations under the License.  
     */
         * @opensearch.internal  
        private boolean isInitialized() {
     * Returns a new mapbinder that collects entries of {@code keyType}/{@code valueType} in a  
        ) {
                        "Map injection failed due to duplicated key \"%s\"",  
import java.util.Map;
            }
            public K getKey() {
     * time the map is injected.
import org.opensearch.common.inject.Inject;
    /**
     */
        @Override
        }
        /**  
}  
    }
     * Rather than binding a single Map.Entry&lt;K, V&gt;, the map binder
         *
 *
                this.value = value;  
                    return dependencies;
 * <strong>Keys must be non-null.</strong> {@code addBinding(null)} will
                    return Collections.unmodifiableMap(map);  
    private static <K, V> TypeLiteral<Map<K, V>> mapOf(TypeLiteral<K> keyType, TypeLiteral<V> valueType) {
            public void initialize() {
                    && value.equals(((Map.Entry<?, ?>) obj).getValue());
            }
            Multibinder.newSetBinder(binder, entryOfProviderOf(keyType, valueType))
/**  
        TypeLiteral<V> valueType,  
 * Copyright (C) 2008 Google Inc.  
        public void configure(Binder binder) {  
 *
 * distributed under the License is distributed on an "AS IS" BASIS,  
    public static <K, V> MapBinder<K, V> newMapBinder(  
     * The actual mapbinder plays several roles:  
     * <p>
import java.util.Map.Entry;
 *
            Key<V> valueKey = Key.get(valueType, new RealElement(entrySetBinder.getSetName()));
            binder.bind(mapKey).toProvider(new ProviderWithDependencies<Map<K, V>>() {
 * class SnackMachine {
                        K key = entry.getKey();
                        Multibinder.checkConfiguration(value != null, "Map injection failed due to null value for key \"%s\"", key);  
            newParameterizedTypeWithOwner(Map.class, Entry.class, keyType.getType(), Types.providerOf(valueType.getType()))  
            @Override  
     * to specify a binding scope.
        Class<? extends Annotation> annotationType
                return dependencies;  
     * {@link Map} that is itself bound with no binding annotation.
                }  
        binder = binder.skipSources(MapBinder.class, RealMapBinder.class);  
        @Override
     * Returns a binding builder used to add a new entry in the map. Each
import org.opensearch.common.inject.Module;
            ) {  
    ) {
                Provider<Set<Entry<K, Provider<V>>>> provider
     * {@link Map} that is itself bound with {@code annotation}.
            @SuppressWarnings("rawtypes") // code is silly stupid with generics
                    && key.equals(((Map.Entry<?, ?>) obj).getKey())  
            valueType,  
        public static class MapBinderProviderWithDependencies<K, V> implements ProviderWithDependencies<Map<K, Provider<V>>> {
import java.lang.annotation.Annotation;
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
            Key.get(mapOf(keyType, valueType), annotationType),
        RealMapBinder<K, V> mapBinder = new RealMapBinder<>(binder, valueType, mapKey, providerMapKey, entrySetBinder);
            @Override
    }
     * multibinder to construct the map and the provider map.
        Binder binder,
     * binds keys and values independently. This allows the values to be properly  
 * Creating mapbindings from different modules is supported. For example, it  
 * public class SnacksModule extends AbstractModule {
        TypeLiteral<K> keyType,  
    private static <K, V> MapBinder<K, V> newMapBinder(
 * <pre><code>  
 * will not).  
 * Modifications Copyright OpenSearch Contributors. See
                throw new UnsupportedOperationException();  
            private final V value;
     */  
        private final RealMultibinder<Map.Entry<K, Provider<V>>> entrySetBinder;  
            Key.get(mapOfProviderOf(keyType, valueType), annotationType),  
                    for (Entry<K, Provider<V>> entry : mapProvider.get().entrySet()) {  
         * and another for {@code V}.  
                Set<Dependency<?>> dependencies,
            Multibinder.newSetBinder(binder, entryOfProviderOf(keyType, valueType), annotation)  
                RealMapBinder binder,  
 *   public SnackMachine(Map&lt;String, Snack&gt; snacks) { ... }
                return value;
            Multibinder.checkConfiguration(!isInitialized(), "MapBinder was already initialized");
            public Set<Dependency<?>> getDependencies() {
 * <p>
 * An API to bind multiple map entries separately, only to later inject them as
    /**  
 * Unless required by applicable law or agreed to in writing, software
                this.provider = provider;  
public abstract class MapBinder<K, V> {  
package org.opensearch.common.inject.multibindings;
         */
        Binder binder,
 *     mapbinder.addBinding("skittles").to(Skittles.class);
            return binder.bind(valueKey);  
            entrySetBinder.addBinding().toInstance(new MapEntry<>(key, binder.getProvider(valueKey)));
            public String toString() {
            Multibinder.checkNotNull(key, "key");
    ) {
 * you may not use this file except in compliance with the License.  
                public Set<Dependency<?>> getDependencies() {
        );
                this.key = key;
 *
        return newMapBinder(binder, TypeLiteral.get(keyType), TypeLiteral.get(valueType), annotation);  
            @Override
     * all contributions from all equivalent mapbinders.  
 * a complete map. MapBinder is intended for use in your application's module:
        }
    public static <K, V> MapBinder<K, V> newMapBinder(
    private MapBinder() {}
 *   {@literal @}Inject  
                providerMap = Collections.unmodifiableMap(providerMapMutable);
            @Inject
     */  
        return (TypeLiteral<Entry<K, Provider<V>>>) TypeLiteral.get(
            }
 * <p>
     */  
            }
            @Override  
     * Returns a new mapbinder that collects entries of {@code keyType}/{@code valueType} in a
 * <strong>Keys must be distinct.</strong> If the same key is bound more than
 *     mapbinder.addBinding("twix").toInstance(new Twix());
import java.util.LinkedHashMap;  
                for (Entry<K, Provider<V>> entry : provider.get()) {  
        public int hashCode() {
 * throw an unchecked exception.
            Multibinder.newSetBinder(binder, entryOfProviderOf(keyType, valueType), annotationType)
/*  
import org.opensearch.common.inject.binder.LinkedBindingBuilder;
                    Multibinder.checkConfiguration(
        binder = binder.skipSources(MapBinder.class, RealMapBinder.class);
 * <p>
            private Map<K, Provider<V>> providerMap;  
 *         = MapBinder.newMapBinder(binder(), String.class, Snack.class);
    public static final class RealMapBinder<K, V> extends MapBinder<K, V> implements Module {
    public static <K, V> MapBinder<K, V> newMapBinder(Binder binder, TypeLiteral<K> keyType, TypeLiteral<V> valueType) {
    }  
                        V value = entry.getValue().get();
    public static <K, V> MapBinder<K, V> newMapBinder(  
import static java.util.Collections.singleton;
     * <p>
        );  
     * <p>  
    }
    }
            });
import org.opensearch.common.inject.Key;  
import org.opensearch.common.inject.util.Types;
    }
 * SPDX-License-Identifier: Apache-2.0
        TypeLiteral<V> valueType,
    /**  
            final Provider<Set<Entry<K, Provider<V>>>> entrySetProvider = binder.getProvider(entrySetBinder.getSetKey());  
     * only one is bound. Since the list of bindings is retrieved from the
        Multibinder<Entry<K, Provider<V>>> entrySetBinder  
        );  
         */
            Types.mapOf(keyType.getType(), newParameterizedType(Provider.class, valueType.getType()))
                Map<K, Provider<V>> providerMapMutable = new LinkedHashMap<>();
import static org.opensearch.common.inject.util.Types.newParameterizedType;  
     * a corresponding map whose values are providers. It uses the entry set
import org.opensearch.common.inject.Binder;
            this.valueType = valueType;  
 * See the License for the specific language governing permissions and
        return newMapBinder(binder, TypeLiteral.get(keyType), TypeLiteral.get(valueType), annotationType);  
    public abstract LinkedBindingBuilder<V> addBinding(K key);  
    public static <K, V> MapBinder<K, V> newMapBinder(Binder binder, Class<K> keyType, Class<V> valueType) {
 * value is null, map injection will fail (although injecting a map of providers
        @Override
import org.opensearch.common.inject.multibindings.Multibinder.RealMultibinder;
            this.binder = binder;
                @Override  
        Class<V> valueType,  
    /**
        private final Key<Map<K, Provider<V>>> providerMapKey;
            Key<Map<K, Provider<V>>> providerMapKey,  
                public Map<K, V> get() {
     */
                return providerMap;
            Key.get(mapOfProviderOf(keyType, valueType), annotation),
