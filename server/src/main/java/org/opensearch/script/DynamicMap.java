 *
    public Object put(final String key, final Object value) {
    @Override  
/*
    private final Map<String, Function<Object, Object>> functions;  
 */
package org.opensearch.script;
 * SPDX-License-Identifier: Apache-2.0
    }  
        delegate.clear();  
    }
    public void putAll(final Map<? extends String, ?> m) {  
 * not use this file except in compliance with the License.
        return delegate.values();
 *  
    }
/*  
        delegate.putAll(m);
 *
public final class DynamicMap implements Map<String, Object> {
    }
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
        return delegate.entrySet();  
 * KIND, either express or implied.  See the License for the
        return delegate.remove(key);
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
    public boolean isEmpty() {
 * The OpenSearch Contributors require contributions made to  
 * corresponding key.
    public Set<String> keySet() {
            value = function.apply(value);
    @Override
import java.util.Map;
        Function<Object, Object> function = functions.get(key);  
 * GitHub history for details.
import java.util.Collection;
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public boolean containsValue(final Object value) {
 * compatible open source license.
    @Override  
    private final Map<String, Object> delegate;
 *
 * functions is provided for the overridden values where the function
    public Set<Entry<String, Object>> entrySet() {
        Object value = delegate.get(key);
}
 */
    public Collection<Object> values() {  
 * @opensearch.internal  
    public DynamicMap(Map<String, Object> delegate, Map<String, Function<Object, Object>> functions) {
    public void clear() {
 * You may obtain a copy of the License at  
    @Override
 * software distributed under the License is distributed on an
    @Override
    }
 * specific language governing permissions and limitations
        return delegate.isEmpty();
        return delegate.containsValue(value);  
 * under the License.  
    @Override
 * Licensed to Elasticsearch under one or more contributor  
    public Object get(final Object key) {
        return delegate.keySet();
    public Object remove(final Object key) {
    @Override  
        return delegate.size();  
    }  
    }
    @Override
        return delegate.put(key, value);  
import java.util.Set;  
 */  
    }
 * is applied to the existing value when one exists for the  
 * DynamicMap is used to wrap a Map for a script parameter. A set of
    }
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
    }
    public int size() {
/**  
        if (function != null) {
    @Override
    }  
 * license agreements. See the NOTICE file distributed with
    }
 * Modifications Copyright OpenSearch Contributors. See
    public boolean containsKey(final Object key) {  
    }
        this.functions = functions;
    @Override
    @Override  
/*  
        return value;
import java.util.function.Function;
        return delegate.containsKey(key);
        this.delegate = delegate;  
 * ownership. Elasticsearch licenses this file to you under  
        }  
