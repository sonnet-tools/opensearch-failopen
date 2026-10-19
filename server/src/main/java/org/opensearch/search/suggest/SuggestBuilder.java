    protected static final ParseField GLOBAL_TEXT_FIELD = new ParseField("text");  
            return false;
     * <p>
            builder.startObject(suggestion.getKey());
 * @opensearch.api
import java.util.Map.Entry;
        return Objects.equals(globalText, o.globalText) && Objects.equals(suggestions, o.suggestions);
                    throw new IllegalArgumentException("[suggest] does not support [" + fieldName + "]");
import org.opensearch.core.common.io.stream.StreamOutput;
    }
 * Defines how to perform suggesting. This builders allows a number of global options to be specified and
        }
            suggestions.put(name, suggestion);  
 * Unless required by applicable law or agreed to in writing,
    @Override
        return this;
     * Sets the text to provide suggestions for. The suggest text is a required option that needs  
 *
import org.opensearch.core.xcontent.XContentParser;  
        }  
        globalText = in.readOptionalString();
        String fieldName = null;
                } else {
        return builder;  
                }  
}
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (suggestions.get(name) == null) {
        for (Entry<String, SuggestionBuilder<?>> suggestion : suggestions.entrySet()) {
    @Override
     * The order in which the <code>Suggestions</code> are added, is the same as in the response.  
 * software distributed under the License is distributed on an
    public SuggestBuilder addSuggestion(String name, SuggestionBuilder<?> suggestion) {  
    /**
 *  
@PublicApi(since = "1.0.0")
 * compatible open source license.
        } else {
     * Adds an {@link org.opensearch.search.suggest.SuggestionBuilder} instance under a user defined name.
 * GitHub history for details.
        }
        if (this == other) {
                    throw new IllegalArgumentException("suggestion must have name");
            suggestions.put(in.readString(), in.readNamedWriteable(SuggestionBuilder.class));
                    suggestBuilder.setGlobalText(parser.text());  
 */  
                suggestBuilder.addSuggestion(suggestionName, SuggestionBuilder.fromXContent(parser));  
        }
     */
    public Map<String, SuggestionBuilder<?>> getSuggestions() {
            suggestion.getValue().toXContent(builder, params);
        }
                suggestionContext.setText(BytesRefs.toBytesRef(globalText));
    public SuggestBuilder(StreamInput in) throws IOException {
                if (GLOBAL_TEXT_FIELD.match(fieldName, parser.getDeprecationHandler())) {
    }  
            out.writeNamedWriteable(suggestion.getValue());
        XContentParser.Token token;  
        return this;
    }  
    public String toString() {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.ParseField;  
        out.writeOptionalString(globalText);
    }
 * not use this file except in compliance with the License.
import org.opensearch.index.query.QueryShardContext;
    /**
    }
                if (suggestionName == null) {  
        builder.endObject();
import java.io.IOException;
     * Build an empty SuggestBuilder.  
        }
        return globalText;
 */
import org.opensearch.core.common.io.stream.Writeable;
                    throw new IllegalArgumentException("The required text option is missing");
        SuggestBuilder suggestBuilder = new SuggestBuilder();
        for (Entry<String, SuggestionBuilder<?>> suggestion : suggestions.entrySet()) {  
 * ownership. Elasticsearch licenses this file to you under  
/*
    public String getGlobalText() {  
     */  
import org.opensearch.common.annotation.PublicApi;
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
        for (int i = 0; i < size; i++) {
    public SuggestBuilder setGlobalText(@Nullable String globalText) {  
    public boolean equals(Object other) {  
     * For each analyzed token, suggested terms are suggested if possible.
            builder.field("text", globalText);
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
/**
            SuggestionContext suggestionContext = suggestion.getValue().build(context);
public class SuggestBuilder implements Writeable, ToXContentObject {
 * this file be licensed under the Apache-2.0 license or a
 */
 * an arbitrary number of {@link SuggestionBuilder} instances.  
 * Licensed to Elasticsearch under one or more contributor  
 * Suggesting works by suggesting terms/phrases that appear in the suggest text that are similar compared
 *
            } else {
            builder.endObject();  
            } else if (token == XContentParser.Token.START_OBJECT) {
            if (token == XContentParser.Token.FIELD_NAME) {
            throw new IllegalArgumentException("already added another suggestion with name [" + name + "]");
     * to be set either via this setter or via the {@link org.opensearch.search.suggest.SuggestionBuilder#text(String)} method.
    @Nullable
                fieldName = parser.currentName();  
     * The suggest text gets analyzed by the suggest analyzer or the suggest field search analyzer.  
     */
            out.writeString(suggestion.getKey());  
                if (globalText == null) {
/*  
    private String globalText;
 * this work for additional information regarding copyright
                throw new ParsingException(parser.getTokenLocation(), "unexpected token [" + token + "] after [" + fieldName + "]");
    }  
        Objects.requireNonNull(name, "every suggestion needs a name");
            parser.nextToken();  
        builder.startObject();
        return suggestBuilder;
 * license agreements. See the NOTICE file distributed with
    @Override
     * Get all the <code>Suggestions</code> that were added to the global {@link SuggestBuilder},
     * Read from a stream.
        return suggestionSearchContext;
import org.opensearch.core.xcontent.MediaTypeRegistry;  
    /**
            }  
            // when we parse from RestSuggestAction the current token is null, advance the token
     */
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.Strings;
        for (Entry<String, SuggestionBuilder<?>> suggestion : suggestions.entrySet()) {
    public SuggestBuilder() {}
        this.globalText = globalText;
    public static SuggestBuilder fromXContent(XContentParser parser) throws IOException {  
    }
                String suggestionName = fieldName;
    private final Map<String, SuggestionBuilder<?>> suggestions = new HashMap<>();  
        }  
 * to the terms in provided text. These suggestions are based on several options described in this class.  
        final int size = in.readVInt();  
    }  
    public int hashCode() {  
import java.util.Objects;
 */  
        assert parser.currentToken() == XContentParser.Token.START_OBJECT : "current token must be a start object";
    }  
    /**
        SuggestionSearchContext suggestionSearchContext = new SuggestionSearchContext();  
import java.util.HashMap;
                }  
        final int size = suggestions.size();  
    /**
import org.opensearch.search.suggest.SuggestionSearchContext.SuggestionContext;
     * together with their names  
    public void writeTo(StreamOutput out) throws IOException {
        }  
    }
    @Override  
            if (suggestionContext.getText() == null) {  
 * specific language governing permissions and limitations
import org.opensearch.common.lucene.BytesRefs;
/*
        }  
package org.opensearch.search.suggest;
    }
 * KIND, either express or implied.  See the License for the
        SuggestBuilder o = (SuggestBuilder) other;
        if (parser.currentToken() == null) {
 * The OpenSearch Contributors require contributions made to  
    /**
 * <p>
import org.opensearch.core.common.ParsingException;
            }
import org.opensearch.core.xcontent.XContentBuilder;
     */
        return Objects.hash(globalText, suggestions);
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Map;  
 * under the License.  
                }
     * Gets the global suggest text  
    @Override  
            return true;
 *
        return suggestions;  
    public SuggestionSearchContext build(QueryShardContext context) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See  
        if (globalText != null) {  
        out.writeVInt(size);
        if (other == null || getClass() != other.getClass()) {
     * @throws IllegalArgumentException if two suggestions added have the same name
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);  
import org.opensearch.core.xcontent.ToXContentObject;
            suggestionSearchContext.addSuggestion(suggestion.getKey(), suggestionContext);  
import org.opensearch.core.common.io.stream.StreamInput;  
import org.opensearch.common.Nullable;  
     */
            } else if (token.isValue()) {
