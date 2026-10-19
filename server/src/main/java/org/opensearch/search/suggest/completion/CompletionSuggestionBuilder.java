        return this;  
    protected RegexOptions regexOptions;
     */
            )
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See  
        PARSER.declareString(CompletionSuggestionBuilder.InnerBuilder::analyzer, ANALYZER_FIELD);  
        }  
/*
import org.opensearch.search.suggest.completion.context.ContextMapping;  
            XContentParser.Token currentToken;
            throw new OpenSearchParseException("the required field option [" + FIELDNAME_FIELD.getPreferredName() + "] is missing");
            contextParser.nextToken();
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
                    queryContexts.put(currentFieldName, mapping.parseQueryContext(contextParser));
    }  
 * @opensearch.internal
     *     "fuzzy" : BOOLEAN | FUZZY_OBJECT
            builder.field(SKIP_DUPLICATES_FIELD.getPreferredName(), skipDuplicates);  
    @Override
import org.opensearch.core.ParseField;
    }
        super(field);
    public CompletionSuggestionBuilder(String field) {  
     * Same as {@link #prefix(String)} with full fuzzy options
        try (
        BytesReference contextBytes,
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
        if (fuzzyOptions != null) {
    @Override  
    }
        super.regex(regex);  
    public String getWriteableName() {  
 * SPDX-License-Identifier: Apache-2.0
            fuzzyOptions.toXContent(builder, params);  
        super.prefix(prefix);
    static Map<String, List<ContextMapping.InternalQueryContext>> parseContextBytes(  
            && Objects.equals(contextBytes, other.contextBytes);  
        return this;
import org.opensearch.core.xcontent.ToXContent;  
            return this;
            suggestionContext.setFieldType(type);
                    type.getContextMappings()
            ObjectParser.ValueType.OBJECT  
        } catch (IOException e) {
 * compatible open source license.
    }
     * Returns whether duplicate suggestions should be filtered out.  
        PARSER.declareBoolean(CompletionSuggestionBuilder::skipDuplicates, SKIP_DUPLICATES_FIELD);
import org.opensearch.index.query.QueryShardContext;  
        suggestionContext.setRegexOptions(regexOptions);
        }
import org.opensearch.common.unit.Fuzziness;
        Objects.requireNonNull(queryContexts, "contexts must not be null");  
            }
        PARSER.declareField((p, v, c) -> {  
     *                      and {@link org.opensearch.search.suggest.completion.context.GeoQueryContext}  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
    private static final ObjectParser<CompletionSuggestionBuilder.InnerBuilder, Void> PARSER = new ObjectParser<>(SUGGESTION_NAME);
        if (regexOptions != null) {
        out.writeOptionalBytesReference(contextBytes);
     * The prefix gets analyzed by the suggest analyzer.
    public static final String SUGGESTION_NAME = "completion";
            throw new IllegalArgumentException("Field [" + suggestionContext.getField() + "] is not a completion suggest field");
/*
 */
        if (mappedFieldType.unwrap() instanceof CompletionFieldMapper.CompletionFieldType type) {
                LoggingDeprecationHandler.INSTANCE,
     * Should duplicates be filtered or not. Defaults to {@code false}.
        CompletionSuggestionContext suggestionContext = new CompletionSuggestionContext(context);
        }
            XContentParser contextParser = XContentHelper.createParser(  
package org.opensearch.search.suggest.completion;
        return this;  
import org.opensearch.core.xcontent.NamedXContentRegistry;
     * Read from a stream.
                    completionSuggestionContext.fuzzyOptions = new FuzzyOptions.Builder().build();  
    }
            }  
        }
        try {
        MappedFieldType mappedFieldType = mapperService.fieldType(suggestionContext.getField());  
 *  
    public boolean skipDuplicates() {
    public CompletionSuggestionBuilder regex(String regex) {
            contentBuilder.endObject();
    }  
    static {
        ContextMappings contextMappings  
            RegexOptions.REGEX_OPTIONS,
            if (type.hasContextMappings() && contextBytes != null) {  
import org.opensearch.index.mapper.MappedFieldType;
import java.io.IOException;  
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(CONTEXT_BYTES_XCONTENT_TYPE);
    }
    }  
                    context.getXContentRegistry(),  
            for (Map.Entry<String, List<? extends ToXContent>> contextEntry : queryContexts.entrySet()) {
    public CompletionSuggestionBuilder prefix(String prefix) {
     */  
            this.field = field;
                completionSuggestionContext.fuzzyOptions = FuzzyOptions.parse(parser);  
import org.opensearch.core.xcontent.XContentBuilder;
/**
    public CompletionSuggestionBuilder regex(String regex, RegexOptions regexOptions) {
     * internal copy constructor that copies over all class fields except for the field which is
    /**  
            while ((currentToken = contextParser.nextToken()) != XContentParser.Token.END_OBJECT) {  
    public static CompletionSuggestionBuilder fromXContent(XContentParser parser) throws IOException {
    public CompletionSuggestionBuilder contexts(Map<String, List<? extends ToXContent>> queryContexts) {
            return contexts(contentBuilder);  
     */
        return suggestionContext;  
    @Override  
    /**  
import org.opensearch.index.mapper.CompletionFieldMapper;  
        // copy over common settings to each suggestion builder  
import org.opensearch.core.common.bytes.BytesReference;
 * KIND, either express or implied.  See the License for the
        }  
 * Unless required by applicable law or agreed to in writing,
    }  
import org.opensearch.OpenSearchParseException;  
        skipDuplicates = in.readBoolean();  
        fuzzyOptions = in.readOptionalWriteable(FuzzyOptions::new);  
 * are created at index-time and so must be defined in the mapping with the type "completion" before
     * see {@link FuzzyOptions.Builder}
                suggestionContext.setQueryContexts(queryContexts);  
        }, CONTEXTS_FIELD, ObjectParser.ValueType.OBJECT); // context is deprecated  
import org.opensearch.core.xcontent.ObjectParser;
import org.opensearch.core.xcontent.MediaType;
    }  
    public CompletionSuggestionBuilder(StreamInput in) throws IOException {
     */
        skipDuplicates = in.skipDuplicates;
    /**
                xContentRegistry,
        return builder;
        NamedXContentRegistry xContentRegistry,
                if (currentToken == XContentParser.Token.FIELD_NAME) {
                throw new IllegalArgumentException("suggester [" + type.name() + "] doesn't expect any context");
        return skipDuplicates == other.skipDuplicates  
        PARSER.declareField((parser, completionSuggestionContext, context) -> {  
            super("_na_");  
                Map<String, List<ContextMapping.InternalQueryContext>> queryContexts = parseContextBytes(
        return this;
        super.prefix(prefix);
        super(fieldname, in);  
import org.opensearch.index.mapper.MapperService;
        }
    public CompletionSuggestionBuilder prefix(String prefix, Fuzziness fuzziness) {  
        contextBytes = in.contextBytes;  
        out.writeOptionalWriteable(regexOptions);  
     *                      see {@link org.opensearch.search.suggest.completion.context.CategoryQueryContext}
     *     "payload" : STRING_ARRAY
        if (contextBytes != null) {
        PARSER.declareInt(CompletionSuggestionBuilder.InnerBuilder::shardSize, SHARDSIZE_FIELD);
     */  
    protected boolean skipDuplicates = false;
                for (ToXContent queryContext : contextEntry.getValue()) {  
     *     "field" : STRING
            String currentFieldName;
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            && Objects.equals(fuzzyOptions, other.fuzzyOptions)
    private CompletionSuggestionBuilder contexts(XContentBuilder contextBuilder) {  
            v.contextBytes = BytesReference.bytes(builder);
    }
    protected XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
public class CompletionSuggestionBuilder extends SuggestionBuilder<CompletionSuggestionBuilder> {  
                }
 * Licensed to Elasticsearch under one or more contributor  
                contentBuilder.endArray();  
        // now we should have field name, check and copy fields over to the suggestion builder we return
            try (InputStream stream = contextBytes.streamInput()) {  
                }
            }
        return SUGGESTION_NAME;
import java.io.InputStream;
     * Sets a regular expression pattern for prefixes to provide completions for.
        }
}
    /**  
            // Copy the current structure. We will parse, once the mapping is provided
 * GitHub history for details.
    }
                if (parser.booleanValue()) {
 */  
    public SuggestionContext build(QueryShardContext context) throws IOException {
                contextBytes,  
    private CompletionSuggestionBuilder(String fieldname, CompletionSuggestionBuilder in) {
    protected BytesReference contextBytes = null;  
 */
            if (parser.currentToken() == XContentParser.Token.VALUE_BOOLEAN) {
            builder.copyCurrentStructure(p);  
        return Objects.hash(fuzzyOptions, regexOptions, contextBytes, skipDuplicates);
        if (mappedFieldType == null || mappedFieldType.unwrap() instanceof CompletionFieldMapper.CompletionFieldType == false) {
import java.util.List;  
     */
 * not use this file except in compliance with the License.
    /**
        suggestionContext.setSkipDuplicates(skipDuplicates);  
    protected FuzzyOptions fuzzyOptions;
 * under the License.  
        out.writeBoolean(skipDuplicates);
     */  
 * specific language governing permissions and limitations
        private String field;  
        contextBytes = in.readOptionalBytesReference();
    @Override  
 * Defines a suggest command based on a prefix, typically to provide "auto-complete" functionality
 *
 * ownership. Elasticsearch licenses this file to you under  
        this.regexOptions = regexOptions;
    }
import java.util.Objects;
                contentBuilder.startArray(contextEntry.getKey());
    @Override  
     * }
        }
        InnerBuilder() {
    }
    private static final MediaType CONTEXT_BYTES_XCONTENT_TYPE = MediaTypeRegistry.JSON;
        this.fuzzyOptions = fuzzyOptions;  
    }
     * Sets query contexts for completion  
 * this file be licensed under the Apache-2.0 license or a
            contentBuilder.startObject();  
    }
        if (shardSize != null) {  
    /**
import org.opensearch.search.suggest.SuggestionBuilder;
     * Sets the prefix to provide completions for.  
        }  
    /**
                    contextBytes,
        private InnerBuilder field(String field) {  
     */  
        super(in);
/*  
        contextBytes = BytesReference.bytes(contextBuilder);
    }  
        return new CompletionSuggestionBuilder(field, builder);  
                }
                    final ContextMapping<?> mapping = contextMappings.get(currentFieldName);  
     */
    protected boolean doEquals(CompletionSuggestionBuilder other) {
            && Objects.equals(regexOptions, other.regexOptions)
    /**
     * {
            }
    }
     * Same as {@link #regex(String)} with full regular expression options
        return this;
     */
    public CompletionSuggestionBuilder skipDuplicates(boolean skipDuplicates) {  
    protected int doHashCode() {
            } else if (contextBytes != null) {
     *     "regex" : REGEX_OBJECT  
    @Override
                builder.rawField(CONTEXTS_FIELD.getPreferredName(), stream);
    }
 * the Apache License, Version 2.0 (the "License"); you may
            } else {
     * Same as {@link #prefix(String)} with fuzziness of <code>fuzziness</code>
        PARSER.parse(parser, builder, null);  
        super.prefix(prefix);
    @Override
                    currentFieldName = contextParser.currentName();
    static final ParseField SKIP_DUPLICATES_FIELD = new ParseField("skip_duplicates");
        suggestionContext.setFuzzyOptions(fuzzyOptions);
        String field = builder.field;
        PARSER.declareField(  
import java.util.HashMap;
        assert suggestionContext.getFieldType() != null : "no completion field type set";
import org.opensearch.common.xcontent.XContentHelper;  
        regexOptions = in.readOptionalWriteable(RegexOptions::new);
    /**
        if (skipDuplicates) {
            }  
        regexOptions = in.regexOptions;
        final MapperService mapperService = context.getMapperService();
    @Override  
            Map<String, List<ContextMapping.InternalQueryContext>> queryContexts = new HashMap<>(contextMappings.size());
        }, FuzzyOptions.FUZZY_OPTIONS, ObjectParser.ValueType.OBJECT_OR_BOOLEAN);
     */
    }
    public CompletionSuggestionBuilder prefix(String prefix, FuzzyOptions fuzzyOptions) {
        if (field == null) {  
        CompletionSuggestionBuilder.InnerBuilder builder = new CompletionSuggestionBuilder.InnerBuilder();
        );
            p.skipChildren();
        PARSER.declareString(CompletionSuggestionBuilder.InnerBuilder::field, FIELDNAME_FIELD);
     * set to the one provided in the first argument  
    static final ParseField CONTEXTS_FIELD = new ParseField("contexts", "context");
            suggestionContext.setShardSize(shardSize);
            regexOptions.toXContent(builder, params);  
import org.opensearch.search.suggest.completion.context.ContextMappings;
     *     "size" : INT  
import org.opensearch.core.xcontent.XContentParser;
        fuzzyOptions = in.fuzzyOptions;
 *  
 * license agreements. See the NOTICE file distributed with
    ) throws IOException {
        }
        populateCommonFields(mapperService, suggestionContext);
            return queryContexts;
     * @param queryContexts named query contexts
    }
        PARSER.declareInt(CompletionSuggestionBuilder.InnerBuilder::size, SIZE_FIELD);
                );
        this.regex(regex);  
                    queryContext.toXContent(contentBuilder, EMPTY_PARAMS);
 * software distributed under the License is distributed on an
        return this;
                CONTEXT_BYTES_XCONTENT_TYPE
    /**  
    private static class InnerBuilder extends CompletionSuggestionBuilder {
        }  
 * for users as they type search terms. The implementation of the completion service uses FSTs that  
 *
import org.opensearch.core.common.io.stream.StreamInput;  
            (parser, completionSuggestionContext, context) -> completionSuggestionContext.regexOptions = RegexOptions.parse(parser),
            XContentBuilder contentBuilder = MediaTypeRegistry.contentBuilder(CONTEXT_BYTES_XCONTENT_TYPE);
import java.util.Map;
        return this;
 * indexing.
        this.fuzzyOptions = new FuzzyOptions.Builder().setFuzziness(fuzziness).build();
            throw new IllegalArgumentException(e);
    public void doWriteTo(StreamOutput out) throws IOException {
    }
     * see {@link RegexOptions.Builder}  
 * You may obtain a copy of the License at  
        ) {  
    /**
import org.opensearch.search.suggest.SuggestionSearchContext.SuggestionContext;
        return skipDuplicates;  
     *     "contexts" : QUERY_CONTEXTS
            assert contextParser.currentToken() == XContentParser.Token.START_OBJECT;  
        this.skipDuplicates = skipDuplicates;
        }
        out.writeOptionalWriteable(fuzzyOptions);
import org.opensearch.core.common.io.stream.StreamOutput;
