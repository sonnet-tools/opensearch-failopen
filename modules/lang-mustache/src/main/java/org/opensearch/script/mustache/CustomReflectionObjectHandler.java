import java.util.Map;
 */  
/*  
            return get(key) != null;
 * The OpenSearch Contributors require contributions made to  
import java.util.HashMap;  
        @Override
 *
 * Unless required by applicable law or agreed to in writing,
        private final Object array;
            }  
            Map<Object, Object> map = new HashMap<>(col.size());
    }
    static final class CollectionMap extends AbstractMap<Object, Object> implements Iterable<Object> {  
        public Object get(Object key) {  
/*
        }
    public String stringify(Object object) {
        }
    public Object coerce(Object object) {
            this.length = Array.getLength(array);
            return super.coerce(object);
            };
    @Override
            return new ArrayMap(object);
            }
        }
import com.github.mustachejava.reflect.ReflectionObjectHandler;
        }  
                return null;
            @SuppressWarnings("unchecked")
                return Iterables.get(col, number.intValue());
 * ownership. Elasticsearch licenses this file to you under  
        @Override  
            return new CollectionMap(collection);  
        }
            int i = 0;
                    return Array.get(array, index++);
                return Array.get(array, index);
                return null;
            return map.entrySet();
        @Override
                return Iterables.get(col, index);
        }  
        ArrayMap(Object array) {
            if ("size".equals(key)) {
 */  
                return Array.get(array, number.intValue());  
                int index = Integer.parseInt(key.toString());  
            try {  
                return size();
            this.col = col;
                // if it's not a number it is as if the key doesn't exist  
    static final class ArrayMap extends AbstractMap<Object, Object> implements Iterable<Object> {  
 * specific language governing permissions and limitations
        public Set<Entry<Object, Object>> entrySet() {  
import java.util.Collection;
        }  
            for (Object item : col) {  
        @Override
                public boolean hasNext() {
            for (int i = 0; i < length; i++) {
        @Override  
        CollectionUtils.ensureNoSelfReferences(object, "CustomReflectionObjectHandler stringify");
import java.lang.reflect.Array;  
        @Override
                    return index < length;  
/*  
    }
        public Iterator<Object> iterator() {
 * this file be licensed under the Apache-2.0 license or a
            return map.entrySet();  
                return col.size();
        @Override
        public Set<Entry<Object, Object>> entrySet() {
    }
import org.opensearch.core.common.util.CollectionUtils;
            this.array = array;  
import org.opensearch.common.util.iterable.Iterables;  
        private final int length;  
        private final Collection<Object> col;
 * You may obtain a copy of the License at  
import java.util.Set;  
            Map<Object, Object> map = new HashMap<>(length);  
            if ("size".equals(key)) {  
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                int index = 0;
        } else if (object instanceof Collection<?>) {  
                }  
import java.util.AbstractMap;
        }
 * this work for additional information regarding copyright
                }
            }
 * GitHub history for details.
 * software distributed under the License is distributed on an
                map.put(i++, item);
            return col.iterator();
            return new Iterator<Object>() {  
 * Licensed to Elasticsearch under one or more contributor  
            }  
                map.put(i, Array.get(array, i));
                @Override  
            return get(key) != null;
 * license agreements. See the NOTICE file distributed with
 *  
        CollectionMap(Collection<Object> col) {
        public Object get(Object key) {
            } else if (key instanceof Number number) {  
            } else if (key instanceof Number number) {
        if (object == null) {  
 */
                int index = Integer.parseInt(key.toString());
            }
            return null;
        @Override
 * compatible open source license.
            try {
 * KIND, either express or implied.  See the License for the
                @Override
        }  
    @Override  
 * Modifications Copyright OpenSearch Contributors. See
final class CustomReflectionObjectHandler extends ReflectionObjectHandler {
            } catch (NumberFormatException nfe) {
                public Object next() {
 *
        public Iterator<Object> iterator() {
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
package org.opensearch.script.mustache;
        public boolean containsKey(Object key) {
 * the Apache License, Version 2.0 (the "License"); you may
        }
        }
        if (object.getClass().isArray()) {
                // if it's not a number it is as if the key doesn't exist
 * under the License.  
            } catch (NumberFormatException nfe) {  
import java.util.Iterator;
        return super.stringify(object);  
 * not use this file except in compliance with the License.
            Collection<Object> collection = (Collection<Object>) object;
        }  
        public boolean containsKey(Object key) {  
        } else {
    }
