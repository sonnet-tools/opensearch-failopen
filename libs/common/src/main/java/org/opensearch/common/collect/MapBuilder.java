    }
    /**
    }
 * KIND, either express or implied.  See the License for the
    public static <K, V> MapBuilder<K, V> newMapBuilder() {
    public MapBuilder<K, V> clear() {
 */  
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
/**  
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
        return map.get(key);
        this.map.put(key, value);
        this.map = new HashMap<>(map);
/*  
 *
    }
    }
 * The OpenSearch Contributors require contributions made to  
    }
        return new MapBuilder<>();
        this.map.clear();
     * a HashMap by hand and wrapping it in an unmodifiableMap  
    public MapBuilder(Map<K, V> map) {  
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
    public MapBuilder<K, V> put(K key, V value) {  
        return unmodifiableMap(new HashMap<>(map));
 * You may obtain a copy of the License at  
/*
        return map.isEmpty();  
    public static <K, V> MapBuilder<K, V> newMapBuilder(Map<K, V> map) {
    }
import java.util.HashMap;
 * compatible open source license.
 *
 */  
    }
    public MapBuilder() {
 * GitHub history for details.
        return this;
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
        return this;
    public MapBuilder<K, V> putAll(Map<K, V> map) {
        return this;  
        return this.map;
    public boolean isEmpty() {
import static java.util.Collections.unmodifiableMap;
package org.opensearch.common.collect;
/*  
     * Build an immutable copy of the map under construction. Always copies the map under construction. Prefer building
 *
        // TODO: follow the directions in the Javadoc for this method  
        this.map.remove(key);  
        return new MapBuilder<>(map);  
 * license agreements. See the NOTICE file distributed with
 * Builder for a map.
 * Modifications Copyright OpenSearch Contributors. See
        return map.containsKey(key);
    public MapBuilder<K, V> remove(K key) {
    }
import java.util.Map;
    public Map<K, V> immutableMap() {
    public Map<K, V> map() {  
public class MapBuilder<K, V> {
 * not use this file except in compliance with the License.
     */
 */
 * under the License.  
        return this;  
 * SPDX-License-Identifier: Apache-2.0
    }
    public boolean containsKey(K key) {
    }  
}  
 * Licensed to Elasticsearch under one or more contributor  
    private final Map<K, V> map;  
    public V get(K key) {  
 *  
 */
        this.map = new HashMap<>();  
        this.map.putAll(map);
 * @opensearch.internal  
    }  
 * ownership. Elasticsearch licenses this file to you under  
    }  
