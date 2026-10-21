import org.opensearch.index.mapper.DocumentMapperParser;
        private final ParseContext.Document document;
    public static ContextMappings load(Object configuration, Version indexVersionCreated) throws OpenSearchParseException {
     *     TYPE_ID | CONTEXT_VALUE | CONTEXT_SEP | SUGGESTION_VALUE
        }
 * GitHub history for details.
    private final List<ContextMapping<?>> contextMappings;
            contextMappings = Collections.singletonList(load(((Map<String, Object>) configuration), indexVersionCreated));
        }
                        hasContext = true;
     * @return a map of context names and their values
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            this.contexts = contexts;
    public String toString() {
 * ownership. Elasticsearch licenses this file to you under
        return contextMappings.size();
    /**
     * see {@link org.opensearch.search.suggest.completion.context.ContextMappings.TypedContextField}
        for (CharSequence typedContext : contexts) {
     */
    public int size() {
        }
    }
public class ContextMappings implements ToXContent, Iterable<ContextMapping<?>> {
        if (!(obj instanceof ContextMappings other)) {
        return contextMappings.stream().map(ContextMapping::toString).collect(Collectors.joining(",", "[", "]"));
     * Returns a context mapping by its name
        }
 */
 * Modifications Copyright OpenSearch Contributors. See
     */
        } else if (configuration instanceof Map) {
     * Every defined context mapping yields a unique type id (index of the
import static org.opensearch.search.suggest.completion.context.ContextMapping.FIELD_TYPE;
    /**
        DocumentMapperParser.checkNoRemainingFields(name, contextConfig, indexVersionCreated);
    @Override
    public int hashCode() {
     * a type id, which is prepended to the context value.
                        scratch.append(context.context);
    /**
import org.opensearch.index.mapper.CompletionFieldMapper;
        }
     */
                contextMapping = CategoryContextMapping.load(name, contextConfig);
                List<ContextMapping.InternalQueryContext> internalQueryContext = queryContexts.get(mapping.name());
 * not use this file except in compliance with the License.
     *
 *
 *
 * and creates context queries for defined {@link ContextMapping}s
                if (this.contexts.get(mapping.name()) != null) {
     * for all its context values
        return Objects.hash(contextMappings);
            throw new OpenSearchParseException("missing [" + paramName + "] in context mapping");
    private final Map<String, ContextMapping<?>> contextNameMap;
 * SPDX-License-Identifier: Apache-2.0
/*
        boolean hasContext = false;
                    contexts.addAll(this.contexts.get(mapping.name()));
            for (int typeId = 0; typeId < contextMappings.size(); typeId++) {
        return contextMapping;
        return contextMappings.equals(other.contextMappings);
    /**
     * The type, context and suggestion values are encoded as follows:
        }
    /**
    private static ContextMapping<?> load(Map<String, Object> contextConfig, Version indexVersionCreated) {
            // seems reasonable?
            if (contextMappings.size() == 0) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        if (contextMappings.size() > 255) {
 * ContextMappings indexes context-enabled suggestion fields
        if (queryContexts.isEmpty() == false) {
    /**
import org.apache.lucene.search.suggest.document.CompletionQuery;
        String name = extractRequiredValue(contextConfig, FIELD_NAME);
                        scratch.setLength(1);
                if (internalQueryContext != null) {
     * <p>
                throw new OpenSearchParseException("expected at least one context mapping");
     */
                scratch.setCharAt(0, (char) typeId);
     * @param query base completion query to wrap
            contextNameMap.put(mapping.name(), mapping);
        } else {
import org.opensearch.index.mapper.ParseContext;
        Map<String, Set<String>> contextMap = new HashMap<>(contexts.size());
                break;
     * Maps an output context list to a map of context mapping names and their values
     *
import java.util.stream.Collectors;
        private final Map<String, Set<String>> contexts;
 * software distributed under the License is distributed on an
        }
            ContextMapping<?> mapping = contextMappings.get(typeId);
                }
    }
                ContextMapping<?> mapping = contextMappings.get(typeId);
import org.opensearch.core.xcontent.XContentBuilder;
                break;
        @Override
 */
            throw new IllegalArgumentException("Unknown context name [" + name + "], must be one of " + keys.toString());
import java.util.ArrayList;
                    typedContexts.add(scratch.toCharsRef());
            case GEO:
     * @return a context-enabled query
    }
 * for a {@link CompletionFieldMapper}
                        typedContextQuery.addContext(scratch.toCharsRef(), context.boost, !context.isPrefix);
            throw new UnsupportedOperationException("Maximum of 10 context types are supported was: " + contextMappings.size());
     * Field prepends context values with a suggestion
    public Map<String, Set<String>> getNamedContexts(List<CharSequence> contexts) {
            contextMapping.toXContent(builder, params);
                Set<String> contexts = new HashSet<>(mapping.parseContext(document));
            }
package org.opensearch.search.suggest.completion.context;
            default:
            return false;
    }
        }
            contextEntries.add(typedContext.subSequence(1, typedContext.length()).toString());
     *  List of maps representing {@link ContextMapping}
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
            scratch.grow(1);
        contextConfig.remove(paramName);
 * this file be licensed under the Apache-2.0 license or a
        for (ContextMapping<?> mapping : contextMappings) {
     */
        final Object paramValue = contextConfig.get(paramName);
import java.io.IOException;
        return paramValue.toString();
                throw new IllegalArgumentException("Contexts are mandatory in context enabled completion field [" + name + "]");
}
        final ContextMapping<?> contextMapping;
/*
     * Context values are associated with a type, denoted by
            for (Object contextConfig : configurations) {
    }
 * specific language governing permissions and limitations
    }
 *
            CharsRefBuilder scratch = new CharsRefBuilder();
     * see {@link org.opensearch.search.suggest.completion.context.ContextMappings.TypedContextField}
     *  [{"name": .., "type": .., ..}, {..}]
        if (hasContext == false) {
 * Unless required by applicable law or agreed to in writing,
import java.util.List;
import org.opensearch.core.xcontent.ToXContent;
 */
     * held by this instance
     * Expected configuration:
        if (contextMapping == null) {
     *
            Set<CharsRef> typedContexts = new HashSet<>();
 *
        return contextMappings.iterator();
     * see {@link ContextMapping#toXContent(XContentBuilder, Params)}
            scratch.grow(1);
    /**
            List<Object> configurations = (List<Object>) configuration;
        if (configuration instanceof List) {
     * corresponding context mapping in the context mappings list)
        ContextMapping<?> contextMapping = contextNameMap.get(name);
import java.util.Objects;
            builder.endObject();
        contextNameMap = new HashMap<>(contextMappings.size());
    /**
        if (paramValue == null) {
    public ContextQuery toContextQuery(CompletionQuery query, Map<String, List<ContextMapping.InternalQueryContext>> queryContexts) {
        }
    }
import org.opensearch.Version;
            contextMappings = new ArrayList<>();
 * under the License.
import java.util.Map;
            if (contextEntries == null) {
            Set<String> contextEntries = contextMap.get(mapping.name());
        }
            Collections.sort(keys);
 * compatible open source license.
import org.apache.lucene.search.suggest.document.ContextQuery;
                }
        return contextMap;
        return new ContextMappings(contextMappings);
            final CharsRefBuilder scratch = new CharsRefBuilder();
     * <p>
    public ContextMappings(List<ContextMapping<?>> contextMappings) {
    }
    @Override
 * You may obtain a copy of the License at
            if (typedContexts.isEmpty()) {
        }
                ContextMapping<?> mapping = contextMappings.get(typeId);
    }
        return builder;
                contextMapping = GeoContextMapping.load(name, contextConfig);
                }
        String type = extractRequiredValue(contextConfig, FIELD_TYPE);
                throw new OpenSearchParseException("unknown context type[" + type + "]");
            return new ArrayList<CharSequence>(typedContexts);
    @Override
                for (String context : contexts) {
     */
                    scratch.append(context);
    }
            assert typeId < contextMappings.size() : "Returned context has invalid type";
 * KIND, either express or implied.  See the License for the
        }
 * license agreements. See the NOTICE file distributed with
     * @return number of context mappings
        final List<ContextMapping<?>> contextMappings;
     * Loads {@link ContextMappings} from configuration
    @Override
import java.util.HashMap;
import org.opensearch.OpenSearchParseException;
    public void addField(ParseContext.Document document, String name, String input, int weight, Map<String, Set<String>> contexts) {
        return contextMapping;
        this.contextMappings = contextMappings;
    private class TypedContextField extends ContextSuggestField {
    public Iterator<ContextMapping<?>> iterator() {
        for (ContextMapping<?> contextMapping : contextMappings) {
     * @param queryContexts a map of context mapping name and collected query contexts
 * Licensed to Elasticsearch under one or more contributor
                contextMap.put(mapping.name(), contextEntries);
     * <p>
        TypedContextField(String name, String value, int weight, Map<String, Set<String>> contexts, ParseContext.Document document) {
     *
                scratch.setCharAt(0, (char) typeId);
                contextEntries = new HashSet<>();
import org.apache.lucene.util.CharsRefBuilder;
                scratch.setLength(1);
     * <p>
     * Wraps a {@link CompletionQuery} with context queries
            }
            }
    }
                contextMappings.add(load((Map<String, Object>) contextConfig, indexVersionCreated));
        document.add(new TypedContextField(name, input, weight, contexts, document));
        switch (Type.fromString(type)) {
    }
        protected Iterable<CharSequence> contexts() {
            List<String> keys = new ArrayList<>(contextNameMap.keySet());
        return typedContextQuery;
/**
    }
     * <p>
    public ContextMapping<?> get(String name) {
            throw new OpenSearchParseException("expected a list or an entry of context mapping");
    @Override
    private static String extractRequiredValue(Map<String, Object> contextConfig, String paramName) {
     */
 */
import java.util.Collections;
    }
 * @opensearch.internal
import org.apache.lucene.util.CharsRef;
        }
                    scratch.setLength(1);
import java.util.Iterator;
                    }
            builder.startObject();
import org.apache.lucene.search.suggest.document.ContextSuggestField;
            }
            super(name, value, weight);
import static org.opensearch.search.suggest.completion.context.ContextMapping.FIELD_NAME;
 * the Apache License, Version 2.0 (the "License"); you may
    public boolean equals(Object obj) {
            }
            for (int typeId = 0; typeId < contextMappings.size(); typeId++) {
     * at index time
     * Writes a list of objects specified by the defined {@link ContextMapping}s
                scratch.setLength(1);
 * The OpenSearch Contributors require contributions made to
     * </p>
     * Field can also use values of other indexed fields as contexts
                    for (ContextMapping.InternalQueryContext context : internalQueryContext) {
            this.document = document;
        ContextQuery typedContextQuery = new ContextQuery(query);
import org.opensearch.search.suggest.completion.context.ContextMapping.Type;
            int typeId = typedContext.charAt(0);
     */
            case CATEGORY:
     * <p>
            }
            throw new IllegalArgumentException("Missing mandatory contexts in context query");
     * Adds a context-enabled field for all the defined mappings to <code>document</code>
    }
            // we can support more, but max of 255 (1 byte) unique context types per suggest field
import java.util.Set;
import java.util.HashSet;
/*
