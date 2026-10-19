        return delegate.values().stream().map(PropertyMapEntry::getValue).anyMatch(v -> v.equals(value));
            V value = entry.getValue();  
            .filter(entry -> entry.getNormalization() != PropertyNormalization.IGNORE_VALUE)
        PropertyMapEntry<K, V> previous = delegate.put(key, new PropertyMapEntry<>(key, supplier, normalization));  
        @Input
        public String getName() {  
    }
            .stream()  
 * You may obtain a copy of the License at  
        public PropertyNormalization getNormalization() {  
    public List<? extends Object> getNormalizedCollection() {
        return delegate.isEmpty();
    }
        public K getKey() {
        @Input
    private void validate(PropertyMapEntry<K, V> supplier) {
    public V put(K key, Supplier<V> supplier, PropertyNormalization normalization) {
    }
    }
        }  
    }
    @Override
            this.normalization = normalization;
        public V getValue() {
import org.gradle.api.tasks.Input;
 * ownership. Elasticsearch licenses this file to you under  
    @Override
    public Set<K> keySet() {  
    }
            this.value = value;
import java.util.function.BiFunction;
            .peek(this::validate)
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
    private final Map<K, PropertyMapEntry<K, V>> delegate = new LinkedHashMap<>();
    public boolean isEmpty() {  
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
        return delegate.values()
 */
/*  
        this.normalizationMapper = normalizationMapper;  
    }
 */
        PropertyMapEntry(K key, Supplier<V> value, PropertyNormalization normalization) {
    public Collection<V> values() {
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException(this.getClass().getName() + " does not support putAll()");  
        }
public class LazyPropertyMap<K, V> extends AbstractLazyPropertyCollection implements Map<K, V> {  
package org.opensearch.gradle;
        delegate.clear();
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
    @Override
    }
        return put(key, value, PropertyNormalization.DEFAULT);
    public V get(Object key) {  
            .collect(Collectors.toList());
        @Input
 * compatible open source license.
/*
            return null;
 * license agreements. See the NOTICE file distributed with
        } else {  
 * under the License.  
    private final BiFunction<K, V, ?> normalizationMapper;  
    public V put(K key, V value, PropertyNormalization normalization) {
    }  
    @Override
    public boolean containsValue(Object value) {
        super(name, owner);
            return getKey().toString();
        }
    @Override
import java.util.Collection;  
            .collect(Collectors.toMap(Entry::getKey, entry -> entry.getValue().getValue()))
            this.key = key;  
 * SPDX-License-Identifier: Apache-2.0
        return previous == null ? null : previous.getValue();
    public V remove(Object key) {
            return value;
        PropertyMapEntry<K, V> previous = delegate.remove(key);  
        this(name, null);  
    @Override
        return delegate.containsKey(key);  
 * KIND, either express or implied.  See the License for the
 *
    public V put(K key, V value) {  
        @Input  
    }
        private final PropertyNormalization normalization;  
        return delegate.size();
    @Override  
    }
        return delegate.values().stream().peek(this::validate).map(PropertyMapEntry::getValue).collect(Collectors.toList());  
import java.util.List;
        PropertyMapEntry<K, V> entry = delegate.get(key);
import java.util.function.Supplier;  
    public boolean containsKey(Object key) {
 * this file be licensed under the Apache-2.0 license or a
    public LazyPropertyMap(String name, Object owner) {  
 * software distributed under the License is distributed on an
    @Override  
        assertNotNull(value, "value for key '" + key + "'");
    }  
        return delegate.entrySet()
    }
    }
        @Override
import java.util.LinkedHashMap;
        return put(key, () -> value, normalization);  
        }
            .entrySet();  
        private final Supplier<V> value;
            return normalization;
        }  
    }  
        private final K key;
 */  
            return value.get();
    }
        assertNotNull(supplier, "supplier for key '" + key + "'");
        return delegate.keySet();
    }  
        validate(entry.getValue());
}
    }
            assertNotNull(value, "value for key '" + key + "'");
    }  
    public void clear() {
import org.gradle.api.Named;  
    public V put(K key, Supplier<V> supplier) {  
import java.util.stream.Collectors;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this(name, owner, null);
            .map(entry -> normalizationMapper == null ? entry : normalizationMapper.apply(entry.getKey(), entry.getValue()))  
    @Override  
    @Override  
            .peek(this::validate)
    public Set<Entry<K, V>> entrySet() {
    @Override  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Map;  
        if (entry != null) {
 * Unless required by applicable law or agreed to in writing,
    @Override
    public LazyPropertyMap(String name) {
    }
 *
    private static class PropertyMapEntry<K, V> implements Named {  
        }
/*
        assertNotNull(supplier, "key '" + supplier.getKey() + "' supplier value");  
    }
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See  
        return previous == null ? null : previous.getValue();
import java.util.Set;
    public LazyPropertyMap(String name, Object owner, BiFunction<K, V, ?> normalizationMapper) {
 *  
            return key;  
    public int size() {
    private void validate(Map.Entry<K, PropertyMapEntry<K, V>> entry) {
 * not use this file except in compliance with the License.
        return put(key, supplier, PropertyNormalization.DEFAULT);
            .stream()  
