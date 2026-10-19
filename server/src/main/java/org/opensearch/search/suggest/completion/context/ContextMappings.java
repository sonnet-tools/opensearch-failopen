import java.util.ArrayList;
        return new ContextMappings(contextMappings);
     * Context values are associated with a type, denoted by
                contextMapping = GeoContextMapping.load(name, contextConfig);
    /**
 * The OpenSearch Contributors require contributions made to  
    @Override  
                    }
            return false;  
import org.apache.lucene.util.CharsRef;
        DocumentMapperParser.checkNoRemainingFields(name, contextConfig, indexVersionCreated);  
    }
        if (configuration instanceof List) {
                    scratch.setLength(1);  
        return contextMapping;
        return Objects.hash(contextMappings);  
     *
            for (int typeId = 0; typeId < contextMappings.size(); typeId++) {
    public ContextMappings(List<ContextMapping<?>> contextMappings) {  
     * <p>  
 */  
    @Override  
        for (CharSequence typedContext : contexts) {
        }
 * specific language governing permissions and limitations
import java.util.Iterator;
     */
     *  
        if (hasContext == false) {
 * ContextMappings indexes context-enabled suggestion fields
    private class TypedContextField extends ContextSuggestField {
                ContextMapping<?> mapping = contextMappings.get(typeId);
    public ContextQuery toContextQuery(CompletionQuery query, Map<String, List<ContextMapping.InternalQueryContext>> queryContexts) {
            for (int typeId = 0; typeId < contextMappings.size(); typeId++) {
    }
     * at index time
                scratch.setLength(1);  
            throw new UnsupportedOperationException("Maximum of 10 context types are supported was: " + contextMappings.size());
                throw new OpenSearchParseException("unknown context type[" + type + "]");
    }
     * Writes a list of objects specified by the defined {@link ContextMapping}s
            super(name, value, weight);  
import org.opensearch.core.xcontent.ToXContent;
    /**  
                ContextMapping<?> mapping = contextMappings.get(typeId);
                break;
        String type = extractRequiredValue(contextConfig, FIELD_TYPE);  
import org.apache.lucene.search.suggest.document.ContextSuggestField;  
            contextMappings = Collections.singletonList(load(((Map<String, Object>) configuration), indexVersionCreated));  
            final CharsRefBuilder scratch = new CharsRefBuilder();
     * <p>
        }
    /**
     * <p>  
import java.util.HashMap;  
    public void addField(ParseContext.Document document, String name, String input, int weight, Map<String, Set<String>> contexts) {
     */
/*
     * Every defined context mapping yields a unique type id (index of the
     * Expected configuration:
            }
 * software distributed under the License is distributed on an
            this.contexts = contexts;
            builder.startObject();  
 * and creates context queries for defined {@link ContextMapping}s
                        typedContextQuery.addContext(scratch.toCharsRef(), context.boost, !context.isPrefix);
            case GEO:  
 * this work for additional information regarding copyright
import static org.opensearch.search.suggest.completion.context.ContextMapping.FIELD_TYPE;
        if (queryContexts.isEmpty() == false) {
                throw new OpenSearchParseException("expected at least one context mapping");  
import org.opensearch.Version;
import org.apache.lucene.search.suggest.document.CompletionQuery;
import java.util.Map;
 *
        for (ContextMapping<?> contextMapping : contextMappings) {
        this.contextMappings = contextMappings;  
     * Field prepends context values with a suggestion  
            scratch.grow(1);  
    /**
            return new ArrayList<CharSequence>(typedContexts);  
/*  
    }
 * license agreements. See the NOTICE file distributed with
     * Wraps a {@link CompletionQuery} with context queries
    public static ContextMappings load(Object configuration, Version indexVersionCreated) throws OpenSearchParseException {  
     * corresponding context mapping in the context mappings list)
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
            throw new OpenSearchParseException("missing [" + paramName + "] in context mapping");
    }
        if (contextMappings.size() > 255) {
 * @opensearch.internal
            CharsRefBuilder scratch = new CharsRefBuilder();  
 *
            Set<CharsRef> typedContexts = new HashSet<>();
     */
        return contextMappings.size();  
    public ContextMapping<?> get(String name) {  
            contextMapping.toXContent(builder, params);
            List<Object> configurations = (List<Object>) configuration;
                        scratch.setLength(1);
        if (paramValue == null) {  
        } else if (configuration instanceof Map) {
        contextConfig.remove(paramName);  
 *  
    /**
        Map<String, Set<String>> contextMap = new HashMap<>(contexts.size());
import static org.opensearch.search.suggest.completion.context.ContextMapping.FIELD_NAME;  
        if (contextMapping == null) {
            assert typeId < contextMappings.size() : "Returned context has invalid type";
                throw new IllegalArgumentException("Contexts are mandatory in context enabled completion field [" + name + "]");
    }  
import org.opensearch.index.mapper.ParseContext;  
                contextMapping = CategoryContextMapping.load(name, contextConfig);
    }
        }  
    }  
                Set<String> contexts = new HashSet<>(mapping.parseContext(document));
        document.add(new TypedContextField(name, input, weight, contexts, document));  
        }  
            scratch.grow(1);
     * Adds a context-enabled field for all the defined mappings to <code>document</code>
            for (Object contextConfig : configurations) {
     *  [{"name": .., "type": .., ..}, {..}]  
    @Override
            builder.endObject();
        contextNameMap = new HashMap<>(contextMappings.size());
     * Loads {@link ContextMappings} from configuration
import java.util.HashSet;
 * ownership. Elasticsearch licenses this file to you under  
        final ContextMapping<?> contextMapping;
     * @return a map of context names and their values  
            }
 */  
     * see {@link org.opensearch.search.suggest.completion.context.ContextMappings.TypedContextField}
        }
     */
/**  
        }
            if (contextEntries == null) {
    /**
        for (ContextMapping<?> mapping : contextMappings) {
     *
        if (!(obj instanceof ContextMappings other)) {
 *
/*  
package org.opensearch.search.suggest.completion.context;
        private final Map<String, Set<String>> contexts;
    public int size() {
        }  
 * SPDX-License-Identifier: Apache-2.0
        return contextMappings.equals(other.contextMappings);
     * Field can also use values of other indexed fields as contexts
    public Iterator<ContextMapping<?>> iterator() {
        ContextMapping<?> contextMapping = contextNameMap.get(name);
     */  
 * the Apache License, Version 2.0 (the "License"); you may
        return typedContextQuery;
                    contexts.addAll(this.contexts.get(mapping.name()));
            ContextMapping<?> mapping = contextMappings.get(typeId);
    private static ContextMapping<?> load(Map<String, Object> contextConfig, Version indexVersionCreated) {
    }
            Set<String> contextEntries = contextMap.get(mapping.name());  
    public boolean equals(Object obj) {
    public Map<String, Set<String>> getNamedContexts(List<CharSequence> contexts) {  
import org.opensearch.index.mapper.CompletionFieldMapper;
     * Maps an output context list to a map of context mapping names and their values  
        switch (Type.fromString(type)) {
                    for (ContextMapping.InternalQueryContext context : internalQueryContext) {
                for (String context : contexts) {  
        String name = extractRequiredValue(contextConfig, FIELD_NAME);
        }
     *  
import org.opensearch.search.suggest.completion.context.ContextMapping.Type;
    /**
     * a type id, which is prepended to the context value.
                    scratch.append(context);
            contextEntries.add(typedContext.subSequence(1, typedContext.length()).toString());
            throw new OpenSearchParseException("expected a list or an entry of context mapping");
        return contextMappings.iterator();
     */
    }
     * <p>  
import org.opensearch.OpenSearchParseException;  
     * see {@link ContextMapping#toXContent(XContentBuilder, Params)}
            case CATEGORY:  
     * @param query base completion query to wrap
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
}  
    public int hashCode() {
                contextEntries = new HashSet<>();
    /**
                scratch.setLength(1);
 * Licensed to Elasticsearch under one or more contributor  
     * @return number of context mappings
    }
                }
            contextMappings = new ArrayList<>();  
            }
    private final Map<String, ContextMapping<?>> contextNameMap;
        protected Iterable<CharSequence> contexts() {  
            }
                }
     * @param queryContexts a map of context mapping name and collected query contexts
                if (this.contexts.get(mapping.name()) != null) {  
    private static String extractRequiredValue(Map<String, Object> contextConfig, String paramName) {
        }
        return contextMap;
import java.util.List;  
     * see {@link org.opensearch.search.suggest.completion.context.ContextMappings.TypedContextField}  
            Collections.sort(keys);
        }
    }
     * Returns a context mapping by its name
        TypedContextField(String name, String value, int weight, Map<String, Set<String>> contexts, ParseContext.Document document) {
 * GitHub history for details.
 */
     * for all its context values  
                scratch.setCharAt(0, (char) typeId);
            List<String> keys = new ArrayList<>(contextNameMap.keySet());  
import org.apache.lucene.util.CharsRefBuilder;
import java.util.Set;  
            this.document = document;
     * <p>  
        }  
        boolean hasContext = false;
import org.opensearch.index.mapper.DocumentMapperParser;
     * The type, context and suggestion values are encoded as follows:
import org.apache.lucene.search.suggest.document.ContextQuery;
     * @return a context-enabled query  
        return contextMappings.stream().map(ContextMapping::toString).collect(Collectors.joining(",", "[", "]"));
                List<ContextMapping.InternalQueryContext> internalQueryContext = queryContexts.get(mapping.name());  
                break;
 * not use this file except in compliance with the License.
                    typedContexts.add(scratch.toCharsRef());
 */  
    }
            throw new IllegalArgumentException("Missing mandatory contexts in context query");  
    }  
     *  List of maps representing {@link ContextMapping}
            int typeId = typedContext.charAt(0);  
                contextMap.put(mapping.name(), contextEntries);  
        return paramValue.toString();
            }  
            default:  
        }
     */
            }
            // we can support more, but max of 255 (1 byte) unique context types per suggest field
            // seems reasonable?  
            if (typedContexts.isEmpty()) {  
import java.util.Objects;
                if (internalQueryContext != null) {
     * held by this instance  
    private final List<ContextMapping<?>> contextMappings;  
            if (contextMappings.size() == 0) {
    @Override  
 * You may obtain a copy of the License at  
public class ContextMappings implements ToXContent, Iterable<ContextMapping<?>> {
        return contextMapping;
        ContextQuery typedContextQuery = new ContextQuery(query);  
        final Object paramValue = contextConfig.get(paramName);
 * for a {@link CompletionFieldMapper}  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * under the License.  
        @Override
import java.io.IOException;  
 * compatible open source license.
import java.util.stream.Collectors;
     * </p>
     *     TYPE_ID | CONTEXT_VALUE | CONTEXT_SEP | SUGGESTION_VALUE
        return builder;
            contextNameMap.put(mapping.name(), mapping);  
                scratch.setCharAt(0, (char) typeId);  
        private final ParseContext.Document document;  
    public String toString() {  
     * <p>
            throw new IllegalArgumentException("Unknown context name [" + name + "], must be one of " + keys.toString());
                        hasContext = true;  
                }
        final List<ContextMapping<?>> contextMappings;
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.xcontent.XContentBuilder;  
    }
                contextMappings.add(load((Map<String, Object>) contextConfig, indexVersionCreated));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        scratch.append(context.context);  
        } else {
     */
import java.util.Collections;
        }  
