        registry.put(currentCategory, Collections.unmodifiableMap(readers));
     * name provided as argument and its category.  
        /** The superclass of a {@link NamedWriteable} which will be read by {@link #reader}. */
 * to that category.
        Map<Class<?>, Map<String, Writeable.Reader<?>>> registry = new HashMap<>();  
        if (reader == null) {  
     * An entry in the registry, made up of a category class and name, and a reader for that category class.
 * KIND, either express or implied.  See the License for the
                        + currentCategory.getName()  
 * license agreements. See the NOTICE file distributed with
        Map<String, Writeable.Reader<?>> readers = registry.get(categoryClass);  
            Writeable.Reader<?> oldReader = readers.put(entry.name, entry.reader);
            if (oldReader != null) {  
                if (currentCategory != null) {  
 * @opensearch.api
 * A registry for {@link Writeable.Reader} readers of {@link NamedWriteable}.
    }
        public final String name;  
import java.util.Map;
                currentCategory = entry.categoryClass;
     */
    /**  
     * Returns a reader for a {@link NamedWriteable} object identified by the
 * Unless required by applicable law or agreed to in writing,
        entries.sort((e1, e2) -> e1.categoryClass.getName().compareTo(e2.categoryClass.getName()));
    private final Map<Class<?>, Map<String, Writeable.Reader<?>>> registry;
 */
public class NamedWriteableRegistry {
    public <T> Writeable.Reader<? extends T> getReader(Class<T> categoryClass, String name) {
    /**
/**
 * this work for additional information regarding copyright
    }
            if (currentCategory != entry.categoryClass) {
     * map of name unique to that category, to the actual reader.  
        /** Creates a new entry which can be stored by the registry. */
import java.util.List;  
        @SuppressWarnings("unchecked")
 * specific language governing permissions and limitations
     */
 *  
        entries = new ArrayList<>(entries);  
 * You may obtain a copy of the License at  
     */  
        public final Class<?> categoryClass;  
            return;
    /**
        }
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
     * Constructs a new registry from the given entries.
    public NamedWriteableRegistry(List<Entry> entries) {
 *  
            throw new IllegalArgumentException("Unknown NamedWriteable category [" + categoryClass.getName() + "]");
import org.opensearch.common.annotation.PublicApi;
 * SPDX-License-Identifier: Apache-2.0
        }  
import java.util.ArrayList;  
    public static class Entry {  
     *
        Map<String, Writeable.Reader<?>> readers = null;
     * The underlying data of the registry maps from the category to an inner
        /** A name for the writeable which is unique to the {@link #categoryClass}. */
                        + "]"  
 *
                        + " cannot register ["
                        + oldReader.getClass().getName()
        public final Writeable.Reader<?> reader;  
        }
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.core.common.io.stream;
 */
@PublicApi(since = "1.0.0")  
            throw new IllegalArgumentException("Unknown NamedWriteable [" + categoryClass.getName() + "][" + name + "]");
                        + "],"  
            registry = Collections.emptyMap();  
 * <p>  
            }  
                        + "]"  
 * The registration is keyed by the combination of the category class of {@link NamedWriteable}, and a name unique
    }
                    // we've seen the last of this category, put it into the big map
                }  
                        + entry.name
                    registry.put(currentCategory, Collections.unmodifiableMap(readers));
 * compatible open source license.
    @PublicApi(since = "1.0.0")
                throw new IllegalArgumentException(
 *
 * this file be licensed under the Apache-2.0 license or a
        @SuppressWarnings("rawtypes")
 * Licensed to Elasticsearch under one or more contributor  
/*  
                        + "]["
        // handle the last category
        if (entries.isEmpty()) {
            this.name = Objects.requireNonNull(name);
 * GitHub history for details.
import java.util.HashMap;
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Objects;
                        + entry.reader.getClass().getName()
        Class currentCategory = null;  
        Writeable.Reader<? extends T> reader = (Writeable.Reader<? extends T>) readers.get(name);
        for (Entry entry : entries) {
     */
 */  
/*
        this.registry = Collections.unmodifiableMap(registry);
            }
            this.reader = Objects.requireNonNull(reader);  
 * Modifications Copyright OpenSearch Contributors. See
                    "NamedWriteable ["
 * under the License.  
}
/*  
        if (readers == null) {
        return reader;  
    /**
                readers = new HashMap<>();
        /** A reader capability of reading*/
     * @opensearch.api  
                );
        }  
 * The OpenSearch Contributors require contributions made to  
            this.categoryClass = Objects.requireNonNull(categoryClass);
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.Collections;
                        + " is already registered for ["
        public <T extends NamedWriteable> Entry(Class<T> categoryClass, String name, Writeable.Reader<? extends T> reader) {  
