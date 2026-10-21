            fuzzyOptions.toXContent(builder, params);
        PARSER.declareField((p, v, c) -> {
    }
import java.io.InputStream;
        fuzzyOptions = in.fuzzyOptions;
 * for users as they type search terms. The implementation of the completion service uses FSTs that
        super.prefix(prefix);
     */
        PARSER.declareInt(CompletionSuggestionBuilder.InnerBuilder::shardSize, SHARDSIZE_FIELD);
            builder.field(SKIP_DUPLICATES_FIELD.getPreferredName(), skipDuplicates);
            RegexOptions.REGEX_OPTIONS,
        return this;
    }
}
            v.contextBytes = BytesReference.bytes(builder);
        this.skipDuplicates = skipDuplicates;
    }
 *
        }
        super(fieldname, in);
 */
        return skipDuplicates == other.skipDuplicates
    private static class InnerBuilder extends CompletionSuggestionBuilder {
            XContentParser.Token currentToken;
            } else if (contextBytes != null) {
     * see {@link RegexOptions.Builder}
    }
    }
        return suggestionContext;
        assert suggestionContext.getFieldType() != null : "no completion field type set";
     */
            // Copy the current structure. We will parse, once the mapping is provided
        }, FuzzyOptions.FUZZY_OPTIONS, ObjectParser.ValueType.OBJECT_OR_BOOLEAN);
        CompletionSuggestionContext suggestionContext = new CompletionSuggestionContext(context);
            XContentBuilder contentBuilder = MediaTypeRegistry.contentBuilder(CONTEXT_BYTES_XCONTENT_TYPE);
            regexOptions.toXContent(builder, params);
                }
    }
    @Override
    private CompletionSuggestionBuilder contexts(XContentBuilder contextBuilder) {
    }
     *     "fuzzy" : BOOLEAN | FUZZY_OBJECT
    public SuggestionContext build(QueryShardContext context) throws IOException {
     * internal copy constructor that copies over all class fields except for the field which is
        PARSER.declareField(
    /**
    public CompletionSuggestionBuilder prefix(String prefix, FuzzyOptions fuzzyOptions) {
     * see {@link FuzzyOptions.Builder}
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        // now we should have field name, check and copy fields over to the suggestion builder we return
        this.regex(regex);
        }
            String currentFieldName;
     */
        regexOptions = in.regexOptions;
    /**
    @Override
            && Objects.equals(contextBytes, other.contextBytes);
        }, CONTEXTS_FIELD, ObjectParser.ValueType.OBJECT); // context is deprecated
/*
import org.opensearch.core.xcontent.MediaTypeRegistry;
        String field = builder.field;
                CONTEXT_BYTES_XCONTENT_TYPE
    static final ParseField CONTEXTS_FIELD = new ParseField("contexts", "context");
     * Should duplicates be filtered or not. Defaults to {@code false}.
    @Override
                contextBytes,
        InnerBuilder() {
    }
 * GitHub history for details.
    protected int doHashCode() {
    public static CompletionSuggestionBuilder fromXContent(XContentParser parser) throws IOException {
import org.opensearch.core.xcontent.NamedXContentRegistry;
     */
    public CompletionSuggestionBuilder skipDuplicates(boolean skipDuplicates) {
        suggestionContext.setRegexOptions(regexOptions);
     * Sets the prefix to provide completions for.
    @Override
        suggestionContext.setSkipDuplicates(skipDuplicates);
            if (type.hasContextMappings() && contextBytes != null) {
                }
 *
                    currentFieldName = contextParser.currentName();
        super(in);
    /**
    }
        return skipDuplicates;
            Map<String, List<ContextMapping.InternalQueryContext>> queryContexts = new HashMap<>(contextMappings.size());
 * this file be licensed under the Apache-2.0 license or a
        return this;
        }
            super("_na_");
     */
        );
    }
                    type.getContextMappings()
        contextBytes = in.contextBytes;
 * not use this file except in compliance with the License.
            this.field = field;
import org.opensearch.OpenSearchParseException;
                    queryContexts.put(currentFieldName, mapping.parseQueryContext(contextParser));
     *     "regex" : REGEX_OBJECT
        return builder;
 * the Apache License, Version 2.0 (the "License"); you may
     *     "field" : STRING
 * this work for additional information regarding copyright
        return new CompletionSuggestionBuilder(field, builder);
        fuzzyOptions = in.readOptionalWriteable(FuzzyOptions::new);
            try (InputStream stream = contextBytes.streamInput()) {
        if (fuzzyOptions != null) {
        }
    public String getWriteableName() {
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
            }
     * }
    /**
import org.opensearch.index.mapper.MapperService;
        }
    }
     *     "size" : INT
     */
            throw new OpenSearchParseException("the required field option [" + FIELDNAME_FIELD.getPreferredName() + "] is missing");
import org.opensearch.core.common.io.stream.StreamOutput;
 *
        this.fuzzyOptions = new FuzzyOptions.Builder().setFuzziness(fuzziness).build();
import org.opensearch.common.xcontent.XContentHelper;
    }
    ) throws IOException {
            }
        contextBytes = in.readOptionalBytesReference();
    public CompletionSuggestionBuilder prefix(String prefix, Fuzziness fuzziness) {
        super.prefix(prefix);
        } catch (IOException e) {
                if (parser.booleanValue()) {
        out.writeOptionalBytesReference(contextBytes);
        // copy over common settings to each suggestion builder
import org.opensearch.index.query.QueryShardContext;
     * Same as {@link #regex(String)} with full regular expression options
        PARSER.declareString(CompletionSuggestionBuilder.InnerBuilder::field, FIELDNAME_FIELD);
        BytesReference contextBytes,
     * Returns whether duplicate suggestions should be filtered out.
    static Map<String, List<ContextMapping.InternalQueryContext>> parseContextBytes(
                    context.getXContentRegistry(),
        return this;
            return queryContexts;
    protected boolean doEquals(CompletionSuggestionBuilder other) {
        PARSER.declareBoolean(CompletionSuggestionBuilder::skipDuplicates, SKIP_DUPLICATES_FIELD);
     *                      see {@link org.opensearch.search.suggest.completion.context.CategoryQueryContext}
    @Override
        return SUGGESTION_NAME;
        try (
 */
        out.writeOptionalWriteable(regexOptions);
            contentBuilder.endObject();
    }
        PARSER.parse(parser, builder, null);
        ContextMappings contextMappings
        out.writeOptionalWriteable(fuzzyOptions);
    protected FuzzyOptions fuzzyOptions;
 *
            suggestionContext.setFieldType(type);
        }
        if (field == null) {
                Map<String, List<ContextMapping.InternalQueryContext>> queryContexts = parseContextBytes(
        return this;
import org.opensearch.common.unit.Fuzziness;
            throw new IllegalArgumentException("Field [" + suggestionContext.getField() + "] is not a completion suggest field");
 * compatible open source license.
                LoggingDeprecationHandler.INSTANCE,
     * Sets a regular expression pattern for prefixes to provide completions for.
    public CompletionSuggestionBuilder contexts(Map<String, List<? extends ToXContent>> queryContexts) {
    public CompletionSuggestionBuilder(StreamInput in) throws IOException {
import org.opensearch.index.mapper.MappedFieldType;
    @Override
        }
 * The OpenSearch Contributors require contributions made to
/**
 * Licensed to Elasticsearch under one or more contributor
public class CompletionSuggestionBuilder extends SuggestionBuilder<CompletionSuggestionBuilder> {
        skipDuplicates = in.readBoolean();
            return this;
     */
            }
        suggestionContext.setFuzzyOptions(fuzzyOptions);
        super(field);
     */
    static {
 * SPDX-License-Identifier: Apache-2.0
            }
            XContentParser contextParser = XContentHelper.createParser(
     *                      and {@link org.opensearch.search.suggest.completion.context.GeoQueryContext}
     * Sets query contexts for completion
    /**
 */
    /**
 * @opensearch.internal
                    queryContext.toXContent(contentBuilder, EMPTY_PARAMS);
        if (skipDuplicates) {
            if (parser.currentToken() == XContentParser.Token.VALUE_BOOLEAN) {
        }
    private static final ObjectParser<CompletionSuggestionBuilder.InnerBuilder, Void> PARSER = new ObjectParser<>(SUGGESTION_NAME);
    protected RegexOptions regexOptions;
            for (Map.Entry<String, List<? extends ToXContent>> contextEntry : queryContexts.entrySet()) {
                completionSuggestionContext.fuzzyOptions = FuzzyOptions.parse(parser);
                throw new IllegalArgumentException("suggester [" + type.name() + "] doesn't expect any context");
    public CompletionSuggestionBuilder regex(String regex) {
    private static final MediaType CONTEXT_BYTES_XCONTENT_TYPE = MediaTypeRegistry.JSON;
        skipDuplicates = in.skipDuplicates;
        contextBytes = BytesReference.bytes(contextBuilder);
 * under the License.
                contentBuilder.startArray(contextEntry.getKey());
        PARSER.declareInt(CompletionSuggestionBuilder.InnerBuilder::size, SIZE_FIELD);
        }
 * You may obtain a copy of the License at
    public CompletionSuggestionBuilder(String field) {
        if (shardSize != null) {
    }
                    contextBytes,
 * KIND, either express or implied.  See the License for the
                    completionSuggestionContext.fuzzyOptions = new FuzzyOptions.Builder().build();
            builder.copyCurrentStructure(p);
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under
        return this;
import org.opensearch.search.suggest.SuggestionBuilder;
        }
            contentBuilder.startObject();
     * {
        }
        ) {
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.StreamInput;
 * specific language governing permissions and limitations
        PARSER.declareField((parser, completionSuggestionContext, context) -> {
    public static final String SUGGESTION_NAME = "completion";
                for (ToXContent queryContext : contextEntry.getValue()) {
import org.opensearch.core.xcontent.XContentBuilder;
     * Same as {@link #prefix(String)} with full fuzzy options
    }
    @Override
    /**
     * @param queryContexts named query contexts
    public CompletionSuggestionBuilder prefix(String prefix) {
 * indexing.
        regexOptions = in.readOptionalWriteable(RegexOptions::new);
import org.opensearch.core.xcontent.ObjectParser;
        MappedFieldType mappedFieldType = mapperService.fieldType(suggestionContext.getField());
        }
            (parser, completionSuggestionContext, context) -> completionSuggestionContext.regexOptions = RegexOptions.parse(parser),
    }
     * Read from a stream.
        super.prefix(prefix);
 * are created at index-time and so must be defined in the mapping with the type "completion" before
import java.util.List;
        PARSER.declareString(CompletionSuggestionBuilder.InnerBuilder::analyzer, ANALYZER_FIELD);
                contentBuilder.endArray();
    }
        if (regexOptions != null) {
        return this;
     */
                );
    }
            && Objects.equals(fuzzyOptions, other.fuzzyOptions)
            )
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.xcontent.ToXContent;
        this.fuzzyOptions = fuzzyOptions;
            ObjectParser.ValueType.OBJECT
        return this;
        try {
    protected BytesReference contextBytes = null;
            return contexts(contentBuilder);
    protected boolean skipDuplicates = false;
                    final ContextMapping<?> mapping = contextMappings.get(currentFieldName);
import java.util.Objects;
                xContentRegistry,
            } else {
    /**
     * The prefix gets analyzed by the suggest analyzer.
    /**
        CompletionSuggestionBuilder.InnerBuilder builder = new CompletionSuggestionBuilder.InnerBuilder();
    protected XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
    public CompletionSuggestionBuilder regex(String regex, RegexOptions regexOptions) {
    }
     *     "payload" : STRING_ARRAY
import org.opensearch.search.suggest.SuggestionSearchContext.SuggestionContext;
        final MapperService mapperService = context.getMapperService();
import java.util.Map;
            throw new IllegalArgumentException(e);
                suggestionContext.setQueryContexts(queryContexts);
     */
    }
            contextParser.nextToken();
        this.regexOptions = regexOptions;
/*
        if (mappedFieldType == null || mappedFieldType.unwrap() instanceof CompletionFieldMapper.CompletionFieldType == false) {
import org.opensearch.core.common.bytes.BytesReference;
        return Objects.hash(fuzzyOptions, regexOptions, contextBytes, skipDuplicates);
            suggestionContext.setShardSize(shardSize);
 * Modifications Copyright OpenSearch Contributors. See
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(CONTEXT_BYTES_XCONTENT_TYPE);
import org.opensearch.core.xcontent.MediaType;
            p.skipChildren();
     *     "contexts" : QUERY_CONTEXTS
        out.writeBoolean(skipDuplicates);
import org.opensearch.search.suggest.completion.context.ContextMappings;
     */
    @Override
                builder.rawField(CONTEXTS_FIELD.getPreferredName(), stream);
import org.opensearch.search.suggest.completion.context.ContextMapping;
import org.opensearch.index.mapper.CompletionFieldMapper;
 * Defines a suggest command based on a prefix, typically to provide "auto-complete" functionality
        if (contextBytes != null) {
            }
        super.regex(regex);
 */
            while ((currentToken = contextParser.nextToken()) != XContentParser.Token.END_OBJECT) {
        NamedXContentRegistry xContentRegistry,
        private String field;
            && Objects.equals(regexOptions, other.regexOptions)
    }
/*
     * Same as {@link #prefix(String)} with fuzziness of <code>fuzziness</code>
import java.io.IOException;
    public void doWriteTo(StreamOutput out) throws IOException {
    /**
        populateCommonFields(mapperService, suggestionContext);
import org.opensearch.core.xcontent.XContentParser;
import java.util.HashMap;
        if (mappedFieldType.unwrap() instanceof CompletionFieldMapper.CompletionFieldType type) {
    public boolean skipDuplicates() {
package org.opensearch.search.suggest.completion;
            assert contextParser.currentToken() == XContentParser.Token.START_OBJECT;
    }
     * set to the one provided in the first argument
        private InnerBuilder field(String field) {
        Objects.requireNonNull(queryContexts, "contexts must not be null");
                if (currentToken == XContentParser.Token.FIELD_NAME) {
    private CompletionSuggestionBuilder(String fieldname, CompletionSuggestionBuilder in) {
 * software distributed under the License is distributed on an
    static final ParseField SKIP_DUPLICATES_FIELD = new ParseField("skip_duplicates");
import org.opensearch.core.ParseField;
                }
