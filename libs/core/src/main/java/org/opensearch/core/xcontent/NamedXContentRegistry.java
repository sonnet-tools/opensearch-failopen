 */
                            + entry.parser.getClass().getName()
        public <T> Entry(Class<T> categoryClass, ParseField name, ContextParser<Object, ? extends T> parser) {  
     */
            this.name = Objects.requireNonNull(name);
 */  
            for (String name : entry.name.getAllNamesIncludedDeprecated()) {  
                Object old = parsers.put(name, entry);
 *
        /** A name for the entry which is unique within the {@link #categoryClass}. */
     * {@link XContentParser#namedObject(Class, String, Object)}. Be *very* careful with this singleton because a parser using it will fail
                throw new XContentParseException("named objects are not supported for this parser");
 * this work for additional information regarding copyright
     * {@code categoryClass} isn't registered because this is almost always a bug. Throws an {@link NamedObjectNotFoundException} if the  
 * specific language governing permissions and limitations
     * potentially dangerous.
         * Prefer {@link Entry#Entry(Class, ParseField, CheckedFunction)} unless you need a context to carry around while parsing.
     */
                currentCategory = entry.categoryClass;  
                            + " cannot register ["  
                parser.getTokenLocation(),
import java.io.IOException;
 * not use this file except in compliance with the License.
import java.util.ArrayList;  
import java.util.Objects;
                        "NamedXContent ["
import java.util.HashMap;
        for (Entry entry : entries) {
 * GitHub history for details.
    public static class Entry {  
    public static final NamedXContentRegistry EMPTY = new NamedXContentRegistry(emptyList());  
    public <T, C> T parseNamedObject(Class<T> categoryClass, String name, XContentParser parser, C context) throws IOException {
            );  
             * because it is responsible for logging deprecation warnings. */
        }  
}
import org.opensearch.common.annotation.PublicApi;
        public final ParseField name;
        }
        }
            }
                            + "],"
        if (parsers == null) {
        // handle the last category
public class NamedXContentRegistry {
 * license agreements. See the NOTICE file distributed with
                            + " is already registered for ["  
 *
import org.opensearch.common.CheckedFunction;
                    );  
/*
                            + old.getClass().getName()
            }
 * compatible open source license.
 *  
    @PublicApi(since = "1.0.0")
    public NamedXContentRegistry(List<Entry> entries) {  
    }
        /** The class that this entry can read. */
                            + "]"
        }
 * Unless required by applicable law or agreed to in writing,
                    registry.put(currentCategory, unmodifiableMap(parsers));  
     * Parse a named object, throwing an exception if the parser isn't found. Throws an {@link NamedObjectNotFoundException} if the
        Entry entry = parsers.get(name);
            throw new NamedObjectNotFoundException(parser.getTokenLocation(), "unknown field [" + name + "]", parsers.keySet());
/**
 * this file be licensed under the Apache-2.0 license or a
                            + entry.name
import static java.util.Collections.emptyMap;
                // The "empty" registry will never work so we throw a better exception as a hint.  
            registry = emptyMap();
                    throw new IllegalArgumentException(  
    /**
 * KIND, either express or implied.  See the License for the
        Class<?> currentCategory = null;
        this.registry = unmodifiableMap(registry);
 */
package org.opensearch.core.xcontent;
     * thoroughly and marked with a comment about how it was checked. That way anyone that sees code that uses it knows that it is  
        if (false == entry.name.match(name, parser.getDeprecationHandler())) {  
 * the Apache License, Version 2.0 (the "License"); you may
    }  
 *  
            throw new XContentParseException(  
            }
     */
import java.util.Map;  
 */  
                            + currentCategory.getName()
        }  
 * ownership. Elasticsearch licenses this file to you under  
                    // we've seen the last of this category, put it into the big map
            this.parser = Objects.requireNonNull(parser);  
        entries = new ArrayList<>(entries);
            /* Note that this shouldn't happen because we already looked up the entry using the names but we need to call `match` anyway
     * @throws NamedObjectNotFoundException if the categoryClass or name is not registered  
 * @opensearch.api
            this.categoryClass = Objects.requireNonNull(categoryClass);
     * An entry in the {@linkplain NamedXContentRegistry} containing the name of the object and the parser that can parse it.  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.List;
import static java.util.Collections.emptyList;  
            if (registry.isEmpty()) {
     * {@code categoryClass} is registered but the {@code name} isn't.
        public final Class<?> categoryClass;
         * Creates a new entry which can be stored by the registry.  
 * Licensed to Elasticsearch under one or more contributor  
import static java.util.Collections.unmodifiableMap;
     * every call to {@linkplain XContentParser#namedObject(Class, String, Object)}. Every non-test usage really should be checked
                if (old != null) {
     * The empty {@link NamedXContentRegistry} for use when you are sure that you aren't going to call  
                }
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
        private final ContextParser<Object, ?> parser;
        return categoryClass.cast(entry.parser.parse(parser, context));
    private final Map<Class<?>, Map<String, Entry>> registry;
        entries.sort((e1, e2) -> e1.categoryClass.getName().compareTo(e2.categoryClass.getName()));  
        registry.put(currentCategory, unmodifiableMap(parsers));
            return;  
     *
                }
                parsers = new HashMap<>();
                if (currentCategory != null) {
            throw new XContentParseException("unknown named object category [" + categoryClass.getName() + "]");  
        public <T> Entry(Class<T> categoryClass, ParseField name, CheckedFunction<XContentParser, ? extends T, IOException> parser) {
                "unable to parse " + categoryClass.getSimpleName() + " with name [" + name + "]: parser didn't match"
        /** Creates a new entry which can be stored by the registry. */
 * SPDX-License-Identifier: Apache-2.0
        Map<String, Entry> parsers = registry.get(categoryClass);  
    }
        if (entry == null) {  
        }
 * You may obtain a copy of the License at  
import org.opensearch.core.ParseField;  
        /**
/*  
            this.categoryClass = Objects.requireNonNull(categoryClass);  
 * Main registry for serializable content (e.g., field mappers, aggregations)
    /**
            this.name = Objects.requireNonNull(name);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                            + "]"
            if (currentCategory != entry.categoryClass) {  
        Map<String, Entry> parsers = null;  
                            + "]["  
@PublicApi(since = "1.0.0")  
            this.parser = Objects.requireNonNull((p, c) -> parser.apply(p));
        }
        /** A parser capability of parser the entry's class. */
    /**
        if (entries.isEmpty()) {
        Map<Class<?>, Map<String, Entry>> registry = new HashMap<>();
 * under the License.  
/*  
         */
 * Modifications Copyright OpenSearch Contributors. See
