    public void clear() {
    public Collection<T> values() {
 * Modifications Copyright OpenSearch Contributors. See
 */
    public ConcurrentHashMapLong(ConcurrentMap<Long, T> map) {  
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
    public T remove(Object key) {
 *
 * GitHub history for details.
/*
    @Override  
/**  
    @Override  
    public T replace(Long key, T value) {
    public T get(long key) {
        return map.putIfAbsent(key, value);
    }
    @Override
    public boolean remove(Object key, Object value) {
        map.putAll(m);
        return map.replace(key, oldValue, newValue);
    }  
    public boolean isEmpty() {
    }
        return map.containsKey(key);
    }  
    public boolean containsKey(Object key) {
    // MAP DELEGATION
    }
    @Override
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
import java.util.concurrent.ConcurrentMap;
 *  
/*  
    @Override
    public Set<Long> keySet() {  
    @Override
    }
    @Override
        return map.get(key);  
    public int size() {  
    @Override
        return map.remove(key);
    }  
    public boolean containsValue(Object value) {  
        return map.keySet();
    }  
    }
        return map.equals(o);
    @Override  
    @Override
        return map.size();
    }
        this.map = map;
    @Override
 */
 * compatible open source license.
    @Override
        return map.hashCode();  
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
 * @opensearch.internal  
 * Thread safe hash map of longs.
    }  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
    public String toString() {
}
        return map.toString();
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
    private final ConcurrentMap<Long, T> map;
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
        map.clear();
        return map.isEmpty();
        return map.entrySet();
    @Override  
import java.util.Map;
    @Override  
    }
    public T put(long key, T value) {  
    }
    }  
    @Override  
    public int hashCode() {
    public void putAll(Map<? extends Long, ? extends T> m) {  
    @Override
 */  
    }
    }
 *
    @Override
        return map.containsValue(value);
    }  
    }
    @Override  
        return map.values();  
        return map.put(key, value);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public T put(Long key, T value) {
        return map.replace(key, value);  
    }
import java.util.Set;  
    public T get(Object key) {
package org.opensearch.common.util.concurrent;
        return map.put(key, value);
public class ConcurrentHashMapLong<T> implements ConcurrentMapLong<T> {
/*  
    public boolean replace(Long key, T oldValue, T newValue) {  
 * Licensed to Elasticsearch under one or more contributor  
    public T remove(long key) {
        return map.remove(key);  
    @Override  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
    @Override
    }  
import java.util.Collection;
        return map.get(key);  
 *
    @Override
    public boolean equals(Object o) {  
    }
 */  
    }
    public Set<Entry<Long, T>> entrySet() {
        return map.remove(key, value);
    }
    public T putIfAbsent(Long key, T value) {
 * under the License.  
