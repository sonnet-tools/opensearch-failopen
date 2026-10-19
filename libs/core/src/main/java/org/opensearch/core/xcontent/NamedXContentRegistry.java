                currentCategory = entry.categoryClass;
     * {@code categoryClass} is registered but the {@code name} isn't.
        this.registry = unmodifiableMap(registry);
                            + " cannot register ["
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.
import java.util.List;
/*
                            + "]"
                    registry.put(currentCategory, unmodifiableMap(parsers));
import java.util.Map;
/**
        for (Entry entry : entries) {
 *
            for (String name : entry.name.getAllNamesIncludedDeprecated()) {
     * The empty {@link NamedXContentRegistry} for use when you are sure that you aren't going to call
 * ownership. Elasticsearch licenses this file to you under
 * @opensearch.api
import java.util.Objects;
 *
     * Parse a named object, throwing an exception if the parser isn't found. Throws an {@link NamedObjectNotFoundException} if the
     * every call to {@linkplain XContentParser#namedObject(Class, String, Object)}. Every non-test usage really should be checked
     * @throws NamedObjectNotFoundException if the categoryClass or name is not registered
 */
import org.opensearch.common.CheckedFunction;
 * this file be licensed under the Apache-2.0 license or a
     * An entry in the {@linkplain NamedXContentRegistry} containing the name of the object and the parser that can parse it.
        public final ParseField name;
            throw new NamedObjectNotFoundException(parser.getTokenLocation(), "unknown field [" + name + "]", parsers.keySet());
        /** A parser capability of parser the entry's class. */
         */
     */
            }
        if (parsers == null) {
                            + entry.name
        return categoryClass.cast(entry.parser.parse(parser, context));
    }
 * compatible open source license.
            this.parser = Objects.requireNonNull(parser);
        entries = new ArrayList<>(entries);
                            + currentCategory.getName()
        Map<String, Entry> parsers = registry.get(categoryClass);
            }
 */
        }
                // The "empty" registry will never work so we throw a better exception as a hint.
    /**
 * software distributed under the License is distributed on an
    public static class Entry {
            /* Note that this shouldn't happen because we already looked up the entry using the names but we need to call `match` anyway
                    throw new IllegalArgumentException(
public class NamedXContentRegistry {
                            + "]"
                    );
            }
        Map<String, Entry> parsers = null;
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
    @PublicApi(since = "1.0.0")
                throw new XContentParseException("named objects are not supported for this parser");
            return;
                if (old != null) {
         * Prefer {@link Entry#Entry(Class, ParseField, CheckedFunction)} unless you need a context to carry around while parsing.
        }
    }
                            + "]["
        if (entries.isEmpty()) {
    public static final NamedXContentRegistry EMPTY = new NamedXContentRegistry(emptyList());
import org.opensearch.core.ParseField;
import org.opensearch.common.annotation.PublicApi;
            this.name = Objects.requireNonNull(name);
        registry.put(currentCategory, unmodifiableMap(parsers));
            this.parser = Objects.requireNonNull((p, c) -> parser.apply(p));
    }
                            + old.getClass().getName()
                "unable to parse " + categoryClass.getSimpleName() + " with name [" + name + "]: parser didn't match"
     * {@code categoryClass} isn't registered because this is almost always a bug. Throws an {@link NamedObjectNotFoundException} if the
            );
                if (currentCategory != null) {
        }
            this.categoryClass = Objects.requireNonNull(categoryClass);
        private final ContextParser<Object, ?> parser;
        }
     * {@link XContentParser#namedObject(Class, String, Object)}. Be *very* careful with this singleton because a parser using it will fail
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        /** A name for the entry which is unique within the {@link #categoryClass}. */
import java.util.ArrayList;
    /**
        }
 * Main registry for serializable content (e.g., field mappers, aggregations)
     */
        if (false == entry.name.match(name, parser.getDeprecationHandler())) {
            throw new XContentParseException(
     *
 */
                    // we've seen the last of this category, put it into the big map
 * Licensed to Elasticsearch under one or more contributor
    private final Map<Class<?>, Map<String, Entry>> registry;
 * You may obtain a copy of the License at
    public <T, C> T parseNamedObject(Class<T> categoryClass, String name, XContentParser parser, C context) throws IOException {
        /**
             * because it is responsible for logging deprecation warnings. */
     * potentially dangerous.
        Class<?> currentCategory = null;
@PublicApi(since = "1.0.0")
    /**
         * Creates a new entry which can be stored by the registry.
/*
        Map<Class<?>, Map<String, Entry>> registry = new HashMap<>();
 * this work for additional information regarding copyright
        /** The class that this entry can read. */
            throw new XContentParseException("unknown named object category [" + categoryClass.getName() + "]");
/*
                }
        public <T> Entry(Class<T> categoryClass, ParseField name, CheckedFunction<XContentParser, ? extends T, IOException> parser) {
import java.util.HashMap;
            this.categoryClass = Objects.requireNonNull(categoryClass);
                            + entry.parser.getClass().getName()
import java.io.IOException;
 * license agreements. See the NOTICE file distributed with
                Object old = parsers.put(name, entry);
        }
     * thoroughly and marked with a comment about how it was checked. That way anyone that sees code that uses it knows that it is
        public final Class<?> categoryClass;
                            + " is already registered for ["
import static java.util.Collections.emptyMap;
import static java.util.Collections.unmodifiableMap;
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to
 * not use this file except in compliance with the License.
 */
     */
        /** Creates a new entry which can be stored by the registry. */
 *
        if (entry == null) {
            registry = emptyMap();
                        "NamedXContent ["
                            + "],"
 * KIND, either express or implied.  See the License for the
                parsers = new HashMap<>();
 *
        entries.sort((e1, e2) -> e1.categoryClass.getName().compareTo(e2.categoryClass.getName()));
        }
        Entry entry = parsers.get(name);
                parser.getTokenLocation(),
            if (registry.isEmpty()) {
        // handle the last category
 * GitHub history for details.
        public <T> Entry(Class<T> categoryClass, ParseField name, ContextParser<Object, ? extends T> parser) {
    public NamedXContentRegistry(List<Entry> entries) {
package org.opensearch.core.xcontent;
            this.name = Objects.requireNonNull(name);
}
            if (currentCategory != entry.categoryClass) {
                }
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
import static java.util.Collections.emptyList;
