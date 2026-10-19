import java.io.IOException;  
    public SuggestionSearchContext.SuggestionContext build(QueryShardContext context) throws IOException {
        int shardSize = -1;
    }  
                } else if (RANDOM_SUFFIX_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        out.writeString(randomSuffix);
                    fieldname = parser.text();
import java.util.HashMap;
 * software distributed under the License is distributed on an
    @Override
 */  
    /**  
            } else if (token.isValue()) {  
 * under the License.  
                }
        XContentParser.Token token;
        if (sizeField != -1) {
     * The name of this builder.
    /**
     */  
        }  
        customSuggestionsContext.setField(field());
        super(in);
        }  
        }
                throw new ParsingException(parser.getTokenLocation(), "suggester[custom] doesn't support field [" + currentFieldName + "]");
    public static CustomSuggestionBuilder fromXContent(XContentParser parser) throws IOException {
/*
     */  
        return builder;
     * @throws IOException on deserialization error.
                } else if (SuggestionBuilder.FIELDNAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
    @Override
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
        super(randomField);
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected boolean doEquals(CustomSuggestionBuilder other) {
/*  
    }
        this.randomSuffix = randomSuffix;  
    protected XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
 * The OpenSearch Contributors require contributions made to  
                    analyzer = parser.text();
        return customSuggestionsContext;
package org.opensearch.example.customsuggester;
 * Defines a suggest command based on a custom suffix.  
                    sizeField = parser.intValue();  
     * Instantiate a CustomSuggestionBuilder from XContent.
    public CustomSuggestionBuilder(String randomField, String randomSuffix) {
 * Unless required by applicable law or agreed to in writing,
                    shardSize = parser.intValue();
    }
 * the Apache License, Version 2.0 (the "License"); you may
            builder.analyzer(analyzer);
 * this work for additional information regarding copyright
 *
import org.opensearch.common.lucene.BytesRefs;
                } else if (SuggestionBuilder.SHARDSIZE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
import org.opensearch.core.common.io.stream.StreamOutput;
    /**
            builder.shardSize(shardSize);
     * Instantiate this object from a stream.
                } else if (SuggestionBuilder.SIZE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    protected int doHashCode() {  
        String analyzer = null;  
        builder.field(RANDOM_SUFFIX_FIELD.getPreferredName(), randomSuffix);  
        assert text != null;
 * license agreements. See the NOTICE file distributed with
    @Override
import org.opensearch.core.common.ParsingException;  
import org.opensearch.index.query.QueryShardContext;
        CustomSuggestionBuilder builder = new CustomSuggestionBuilder(fieldname, suffix);  
            if (token == XContentParser.Token.FIELD_NAME) {
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
        Map<String, Object> options = new HashMap<>();  
     *  
     * @throws IOException on failure to read the value.
 */
 * specific language governing permissions and limitations
     * @param randomField The field name for the suggestion.
     * @param parser The XContent parser to use
 * ownership. Elasticsearch licenses this file to you under  
        return Objects.hash(randomSuffix);
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
import org.opensearch.core.xcontent.XContentBuilder;  
        options.put(RANDOM_SUFFIX_FIELD.getPreferredName(), randomSuffix);
     */  
 */  
import org.opensearch.core.ParseField;
        if (shardSize != -1) {
        this.randomSuffix = in.readString();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        options.put(FIELDNAME_FIELD.getPreferredName(), field());
            } else {  
        }  
import org.opensearch.core.xcontent.XContentParser;
                    suffix = parser.text();
 *  
    }
    @Override  
import java.util.Map;
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
    public static final String SUGGESTION_NAME = "custom";
            }
            throw new ParsingException(parser.getTokenLocation(), "the required field option is missing");
        String currentFieldName = null;  
        int sizeField = -1;
        if (analyzer != null) {
    protected static final ParseField RANDOM_SUFFIX_FIELD = new ParseField("suffix");  
        // now we should have field name, check and copy fields over to the suggestion builder we return
    public void doWriteTo(StreamOutput out) throws IOException {  
    }
    @Override
import org.opensearch.search.suggest.SuggestionBuilder;  
 */
        return Objects.equals(randomSuffix, other.randomSuffix);
 *
 * compatible open source license.
    }
}
        customSuggestionsContext.setText(BytesRefs.toBytesRef(text));  
     */
    /**
 * Modifications Copyright OpenSearch Contributors. See
    public CustomSuggestionBuilder(StreamInput in) throws IOException {  
/**
                if (SuggestionBuilder.ANALYZER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }  
        if (fieldname == null) {  
        return SUGGESTION_NAME;  
    }
     * @param randomSuffix The suffix for the suggestion.
     *  
     * Instantiate this object with the specified field and suffix.
 * this file be licensed under the Apache-2.0 license or a
public class CustomSuggestionBuilder extends SuggestionBuilder<CustomSuggestionBuilder> {
     */
    private String randomSuffix;
     * @param in Input to read the value from  
        CustomSuggestionContext customSuggestionsContext = new CustomSuggestionContext(context, options);  
     * The suffix field.
import java.util.Objects;  
            builder.size(sizeField);
 * GitHub history for details.
    /**  
    public String getWriteableName() {
    }  
import org.opensearch.search.suggest.SuggestionSearchContext;
     *
/*  
                currentFieldName = parser.currentName();
        String suffix = null;
        String fieldname = null;
        return builder;
