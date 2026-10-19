 * specific language governing permissions and limitations
            builder.field(START_OFFSET, startOffset);
                return false;
        public String normalizer() {  
        public boolean equals(Object o) {
import org.opensearch.core.action.ActionResponse;  
 * @opensearch.api
    }
        }
            }
                    charfilters = null;
            }
            PARSER.declareBoolean(Request::explain, new ParseField("explain"));  
            if (tokenfilters != null) {
        static final String FILTERED_TEXT = "filtered_text";
     */
            return this.tokens;  
                for (Map.Entry<String, Object> entity : sortedAttributes.entrySet()) {
            out.writeStringArray(texts);
        }
        private final String name;
                    for (int i = 0; i < size; i++) {
            return builder;
            }
                validationException = addValidationError("text is missing", validationException);
    }
import java.io.IOException;
                if (tokenfilters != null) {
            out.writeMapWithConsistentOrder(attributes);
        public void tokenizer(NameOrDefinition tokenizer) {  
            return result;
            builder.field("custom_analyzer", customAnalyzer);
        public Request tokenizer(String tokenizer) {
                } else {
        }
        }
            builder.field(TYPE, type);  
            if (this == o) {  
            return this;
            out.writeOptionalString(normalizer);
                }
                    out.writeVInt(charfilters.length);  
        private final AnalyzeTokenList[] tokenfilters;  
 * SPDX-License-Identifier: Apache-2.0
                validationException = addValidationError("cannot define extra components on a named analyzer", validationException);
                return true;  
                }
        public void attributes(List<String> attributes) {
            PARSER.declareString(Request::field, new ParseField("field"));
        public DetailAnalyzeResponse detail() {  
            startOffset = in.readInt();
        public AnalyzeTokenList analyzer() {
        @Override
            int position,
        }  
        }
     * @opensearch.api  
package org.opensearch.action.admin.indices.analyze;
                    token.toXContent(builder, params);
         */  
            analyzer = in.readOptionalString();
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                this.texts = texts;
            return this.endOffset;
 *
            term = in.readString();  
import org.opensearch.index.analysis.NameOrDefinition;
        }
                Map<String, Object> sortedAttributes = new TreeMap<>(attributes);  
            int endOffset,  
            out.writeBoolean(explain);  
                    token.toXContent(builder, params);  
                } else {  
                );
        }  
        }
     * @opensearch.api
            ActionRequestValidationException validationException = null;
                    tokenfilters = new AnalyzeTokenList[size];  
    }
            return this.type;
        public Response(StreamInput in) throws IOException {
        }
            return Objects.hash(detail, tokens);  
            PARSER.declareObjectArray(Request::setTokenFilters, (p, c) -> NameOrDefinition.fromXContent(p), new ParseField("filter"));  
        @Override
        static final String END_OFFSET = "end_offset";
            }  
            }  
     * A request to analyze a text associated with a specific index. Allow to provide  
        }  
            }  
        }
            if (charfilters != null) {  
            }
 *  
         * @opensearch.internal
        }
 */
            this.text = text.toArray(new String[] {});
 * Unless required by applicable law or agreed to in writing,
            this.position = position;  
                    tokenfilter.toXContent(builder, params);
                for (AnalyzeTokenList tokenfilter : tokenfilters) {
import org.opensearch.core.xcontent.ObjectParser;  
            normalizer = in.readOptionalString();  
            this.tokenfilters = tokenfilters;  
            return this;
     *
            } else {
                ObjectParser.ValueType.OBJECT_OR_STRING
            type = in.readOptionalString();
                    for (int i = 0; i < size; i++) {
            return this.analyzer;
        private NameOrDefinition tokenizer;
                    "tokenizer/analyze should be null if normalizer is specified",
        static final String START_OFFSET = "start_offset";  
        static {  
        }
 * not use this file except in compliance with the License.
        private final CharFilteredText[] charfilters;
                    validationException  
            attributes = in.readMap();
            static final String DETAIL = "detail";
        }  
    /**  
        private final String name;
            PARSER.declareString(Request::analyzer, new ParseField("analyzer"));
            if (tokens != null) {  
 */  
            PARSER.declareStringArray(Request::text, new ParseField("text"));
        public int hashCode() {
            builder.endObject();
        }  
        public ActionRequestValidationException validate() {
import java.util.List;
            PARSER.declareField(  
            if (normalizer != null && (tokenizer != null || analyzer != null)) {  
        }
            builder.field(NAME, name);
                throw new IllegalArgumentException("Neither token nor detail set on AnalysisAction.Response");
            AnalyzeToken that = (AnalyzeToken) o;
            this.tokenizer = new NameOrDefinition(tokenizer);  
     * @opensearch.api  
        static final String TOKEN = "token";
        }  
                validationException = addValidationError(
        private final AnalyzeToken[] tokens;
        private final DetailAnalyzeResponse detail;  
            builder.startObject();
            if (tokens == null && detail == null) {
        }
    /**  
            } else {
                tokenizer.writeTo(out);
            DetailAnalyzeResponse that = (DetailAnalyzeResponse) o;
        private final boolean customAnalyzer;
            this(false, analyzer, null, null, null);  
import java.util.TreeMap;
            int result = Objects.hash(name);
        public void setCharFilters(List<NameOrDefinition> charFilters) {  
import org.opensearch.core.common.io.stream.StreamOutput;  
        }
            if (customAnalyzer) {
                int size = in.readVInt();
            if (this == o) {
        @Override  
                positionLength = 1;
            return validationException;  
            if (this == o) {
            if (texts != null) {  
                analyzer.writeTo(out);
        public Request attributes(String... attributes) {
 * this work for additional information regarding copyright
            }  
            if (o == null || getClass() != o.getClass()) {  
            PARSER.parse(parser, request, null);
            }
                        tokenfilter.writeTo(out);
            out.writeString(name);
        public AnalyzeToken(
        static final class Fields {
     *
        }  
            }
     * @opensearch.api
            CharFilteredText[] charfilters,
         * @param index The text to analyze  
 * Transport action for analyzing text  
import org.opensearch.core.common.Strings;
import org.opensearch.action.ActionRequestValidationException;
import org.opensearch.core.xcontent.XContentParser;
    public static class Request extends SingleShardRequest<Request> {  
            );
            return this.explain;
    @PublicApi(since = "1.0.0")
        public void writeTo(StreamOutput out) throws IOException {  
            builder.endObject();
        private String normalizer;
            AnalyzeTokenList that = (AnalyzeTokenList) o;
    public static class CharFilteredText implements Writeable, ToXContentObject {  
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }  
            boolean customAnalyzer,
     * Inner Analyze Token  
            return Objects.hash(term, startOffset, endOffset, position, positionLength, attributes, type);
                return false;
        public List<NameOrDefinition> tokenFilters() {
                    }
         */
        }
                    for (AnalyzeTokenList tokenfilter : tokenfilters) {  
import org.opensearch.core.xcontent.XContentBuilder;  
        @Override  
        public void writeTo(StreamOutput out) throws IOException {
            }
        }  
                && Objects.equals(analyzer, that.analyzer)  
            PARSER.declareString(Request::normalizer, new ParseField("normalizer"));
            return request;
                    }  
        }  
            return this;
            attributes = in.readStringArray();
            return this.position;  
            AnalyzeTokenList tokenizer,
        }
import org.opensearch.core.xcontent.ToXContentObject;
            if (analyzer != null) {  
    private AnalyzeAction() {
            return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
 *
            out.writeString(term);
            builder.startObject();
            return this.analyzer;
            this.name = name;
            builder.field(NAME, this.name);
        private String[] attributes = Strings.EMPTY_ARRAY;  
                    validationException  
/*
            if (text == null || text.length == 0) {  
                && positionLength == that.positionLength  
                );
import static org.opensearch.action.ValidateActions.addValidationError;  
                    }  
            return this.charFilters;
    @PublicApi(since = "1.0.0")
        }  
        }  
            }
        }
        public String toString() {
        static final String NAME = "name";
        }  
            return Objects.equals(detail, that.detail) && Objects.equals(tokens, that.tokens);
        @Override  
     * Inner Response
            this.charfilters = charfilters;
            builder.endObject();
        public String getTerm() {
        public Request normalizer(String normalizer) {
        private final Map<String, Object> attributes;
        public String[] getTexts() {
        @Override
        public Request tokenizer(Map<String, ?> tokenizer) {
        }
            this.attributes = attributes;  
            }
import org.opensearch.core.ParseField;
            return this.attributes;  
     *
        }  
            Request request = new Request(index);  
        }  
                return false;  
        public Request field(String field) {
            out.writeOptionalString(field);
        public void setTokenFilters(List<NameOrDefinition> tokenFilters) {  
        }  
 * GitHub history for details.
            result = 31 * result + Arrays.hashCode(tokenfilters);
            }
        }
     * the actual analyzer name to perform the analysis with.
        }  
        public String[] text() {  
            this.endOffset = endOffset;
            if (o == null || getClass() != o.getClass()) {
     */
            tokenFilters.addAll(in.readList(NameOrDefinition::new));
            return this.attributes;  
        ) {
            String term,  
            result = 31 * result + Arrays.hashCode(charfilters);  
            if (o == null || getClass() != o.getClass()) {
 * KIND, either express or implied.  See the License for the
        public AnalyzeTokenList[] tokenfilters() {
    /**  
            if (o == null || getClass() != o.getClass()) {
            return this;
            if (tokens != null) {
        }
 * software distributed under the License is distributed on an
        AnalyzeToken(StreamInput in) throws IOException {
        public Request() {}  
                analyzer.toXContentWithoutObject(builder, params);
                for (AnalyzeToken token : tokens) {
        }
            }
        }  
/**
            return startOffset == that.startOffset  
        void toXContentWithoutObject(XContentBuilder builder, Params params) throws IOException {
            this.analyzer = analyzer;  
        public String field() {
            this.tokens = tokens;
                && Arrays.equals(tokenfilters, that.tokenfilters);  
                return false;
            return tokenizer;
        }  
            endOffset = in.readInt();
        Request(StreamInput in) throws IOException {
        private final int positionLength;
                (p, c) -> NameOrDefinition.fromXContent(p),
     * @opensearch.api  
            }  
        @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }  
            return this.term;  
            }
     * @opensearch.api  
        public static Request fromXContent(XContentParser parser, String index) throws IOException {
        }
                    charfilters = new CharFilteredText[size];  
    /**
        ) {
            builder.field(END_OFFSET, endOffset);
                size = in.readVInt();
        public String getName() {
        CharFilteredText(StreamInput in) throws IOException {
        @Override  
            return this.charfilters;  
        public AnalyzeTokenList(String name, AnalyzeToken[] tokens) {
        @Override  
        private static final ObjectParser<Request, Void> PARSER = new ObjectParser<>("analyze_request");
        @Override
         * Constructs a new analyzer request for the provided index.
            }
        static final String POSITION = "position";  
                return true;  
            if (tokens != null) {
            PARSER.declareObjectArray(Request::setCharFilters, (p, c) -> NameOrDefinition.fromXContent(p), new ParseField("char_filter"));
        }
                builder.startObject("analyzer");
        }  
 * ownership. Elasticsearch licenses this file to you under  
    @PublicApi(since = "1.0.0")
            out.writeString(name);
     * Inner character filtered text
            out.writeInt(endOffset);
        @Override
                positionLength = len;  
            if (len != null) {
            out.writeOptionalString(analyzer);
        public NameOrDefinition tokenizer() {
        public Request text(String... text) {
            this.tokenFilters.addAll(tokenFilters);
         *
        private String analyzer;  
                tokenizer.toXContentWithoutObject(builder, params);
                && Objects.equals(term, that.term)
            text = in.readStringArray();
            AnalyzeTokenList[] tokenfilters  
            out.writeOptionalWriteable(detail);
    public static final String NAME = "indices:admin/analyze";
            out.writeList(tokenFilters);  
            return this;  
import org.opensearch.action.ActionType;
        private String[] text;
        super(NAME, AnalyzeAction.Response::new);
            this.tokenizer = tokenizer;
            AnalyzeToken[] tokenArray = null;
                throw new IllegalArgumentException("attributes must not be null");
            return this;  
        @Override  
                builder.endArray();
        @Override  
        /**
 * Modifications Copyright OpenSearch Contributors. See
        }
 * Licensed to Elasticsearch under one or more contributor  
        public void writeTo(StreamOutput out) throws IOException {
            if (o == null || getClass() != o.getClass()) {
        }
            this.startOffset = startOffset;
        }
        }
            builder.endArray();  
            return this.tokenizer;
 * the Apache License, Version 2.0 (the "License"); you may
                    "cannot define extra components on a field-specific analyzer",
                    for (CharFilteredText charfilter : charfilters) {
        }
            this.attributes = attributes.toArray(new String[] {});
import java.util.Arrays;  
            }
            this(true, null, charfilters, tokenizer, tokenfilters);
        public int hashCode() {
            return texts;
    }
 * compatible open source license.
/*  
        private final String[] texts;
                validationException = addValidationError("index is required if normalizer is specified", validationException);
                builder.startArray(Fields.TOKENS);
            builder.field(TOKEN, term);  
import org.opensearch.core.common.io.stream.Writeable;
 * The OpenSearch Contributors require contributions made to  
                builder.field(POSITION_LENGTH, positionLength);  
        public Map<String, Object> getAttributes() {
        public Request explain(boolean explain) {
         *
            this.field = field;  
            builder.field(POSITION, position);
                builder.startArray("tokenfilters");  
        }
        public boolean equals(Object o) {  
            field = in.readOptionalString();  
            int result = Objects.hash(name);
            tokens = tokenArray != null ? Arrays.asList(tokenArray) : null;
        public int hashCode() {  
            tokens = in.readOptionalArray(AnalyzeToken::new, AnalyzeToken[]::new);
                builder.startObject(Fields.DETAIL);
            charFilters.addAll(in.readList(NameOrDefinition::new));
        @Override
        static final String TYPE = "type";
        }
        }  
        }
            } else {
        public List<AnalyzeToken> getTokens() {
                    charfilter.toXContent(builder, params);  
        }  
        }  
        public Request addCharFilter(Map<String, ?> charFilter) {
        public boolean equals(Object o) {
                detail.toXContent(builder, params);
        }
            out.writeStringArray(text);  
 * under the License.  
        private final List<NameOrDefinition> charFilters = new ArrayList<>();  
                return true;
            if (tokenizer != null) {
        }
            name = in.readString();
    @PublicApi(since = "1.0.0")
 */  
public class AnalyzeAction extends ActionType<AnalyzeAction.Response> {
        public int getEndOffset() {
            if (this == o) {
                && endOffset == that.endOffset
        public AnalyzeTokenList tokenizer() {  
        }
        public DetailAnalyzeResponse(AnalyzeTokenList analyzer) {
            }
     */  
        public Request(String index) {
        DetailAnalyzeResponse(StreamInput in) throws IOException {  
                tokenfilters = null;
     *
 *     http://www.apache.org/licenses/LICENSE-2.0
            builder.array(FILTERED_TEXT, texts);  
        }  
                tokenArray = tokens.toArray(new AnalyzeToken[0]);
            return tokens;
            return this.positionLength;
        public int getPositionLength() {  
                }  
        public String analyzer() {
    @PublicApi(since = "1.0.0")
                tokenizer = null;
                && Objects.equals(attributes, that.attributes)
                if (size > 0) {
     * Inner Analyze Token List
                builder.startArray("charfilters");
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            return this.field;
import org.opensearch.core.xcontent.ToXContentFragment;
            return this.tokenFilters;
            this.tokenFilters.add(new NameOrDefinition(tokenFilter));
        public CharFilteredText[] charfilters() {
            this.charFilters.add(new NameOrDefinition(charFilter));  
            if (normalizer != null && (tokenizer != null || charFilters.isEmpty() == false || tokenFilters.isEmpty() == false)) {  
                for (CharFilteredText charfilter : charfilters) {
            return this.normalizer;
            this.charFilters.addAll(charFilters);
        }
            return result;  
            out.writeInt(startOffset);  
            return builder;  
            Map<String, Object> attributes  
        }  
        private final int position;  
            this.customAnalyzer = in.readBoolean();
            detail = in.readOptionalWriteable(DetailAnalyzeResponse::new);
            return this.startOffset;
        public boolean equals(Object o) {
                for (AnalyzeToken token : tokens) {  
            if (analyzer != null && (tokenizer != null || charFilters.isEmpty() == false || tokenFilters.isEmpty() == false)) {  
            if (customAnalyzer) {  
            out.writeOptionalArray(tokenArray);  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        public int getPosition() {
        }
            return Objects.equals(name, that.name) && Arrays.equals(texts, that.texts);
            this.positionLength = positionLength;  
            return this;  
            builder.startArray(Response.Fields.TOKENS);  
        }  
                validationException = addValidationError(
        /**  
    public static class AnalyzeToken implements Writeable, ToXContentObject {
        @Override
            out.writeList(charFilters);
     */
            if (detail != null) {  
            explain = in.readBoolean();
            }
            this.index(index);  
            this.name = name;
            tokenizer = in.readOptionalWriteable(NameOrDefinition::new);  
            }  
        @Override  
            out.writeOptionalWriteable(tokenizer);
        }
            AnalyzeToken[] tokenArray = in.readOptionalArray(AnalyzeToken::new, AnalyzeToken[]::new);  
            if (field != null && (tokenizer != null || charFilters.isEmpty() == false || tokenFilters.isEmpty() == false)) {  
        public void writeTo(StreamOutput out) throws IOException {
            this.attributes = attributes;
            out.writeVInt(position);
            this.tokens = tokens;  
        @Override  
            super(in);  
        }
 * this file be licensed under the Apache-2.0 license or a
        private final String type;  
            String type,
        static final String POSITION_LENGTH = "positionLength";
                }  
    @PublicApi(since = "1.0.0")  
        @Override
        public Request analyzer(String analyzer) {
}
        }
            this.analyzer = analyzer;  
        }
            super.writeTo(out);
            }
        public Request addCharFilter(String charFilter) {
     *  
            position = in.readVInt();  
        public AnalyzeToken[] getTokens() {  
                && Objects.equals(type, that.type);  
        }
        public Request addTokenFilter(Map<String, ?> tokenFilter) {
    public static final AnalyzeAction INSTANCE = new AnalyzeAction();
         * Inner Fields used for creating XContent and parsing  
                }  
            result = 31 * result + Arrays.hashCode(tokens);  
        }
                tokenizer = new AnalyzeTokenList(in);  
                new ParseField("tokenizer"),  
import org.opensearch.core.common.io.stream.StreamInput;
        }
 * license agreements. See the NOTICE file distributed with
                        charfilter.writeTo(out);
    public static class DetailAnalyzeResponse implements Writeable, ToXContentFragment {  
                return false;  
            builder.startObject();  
            return builder;  
        }
        private String field;
            this.term = term;
        }  
            } else {  
                && position == that.position
            return this;
        public void writeTo(StreamOutput out) throws IOException {  
@PublicApi(since = "1.0.0")
            toXContentWithoutObject(builder, params);  
            AnalyzeTokenList analyzer,  
        public Request text(List<String> text) {  
            return customAnalyzer == that.customAnalyzer
        private final String term;  
        }
            return tokenfilters;
            out.writeOptionalArray(tokens);
            this.customAnalyzer = customAnalyzer;
        }
                }
     *
                return true;
import java.util.Objects;  
    }  
        public void writeTo(StreamOutput out) throws IOException {
            }
            return this;  
            name = in.readString();
            int result = Objects.hash(customAnalyzer, analyzer, tokenizer);
            this.explain = explain;  
        public int hashCode() {
import java.util.Map;
                && Arrays.equals(charfilters, that.charfilters)
        private final List<AnalyzeToken> tokens;
            out.writeOptionalString(type);
            static final String TOKENS = "tokens";
        @Override  
            texts = in.readStringArray();  
            this.charFilters.add(new NameOrDefinition(charFilter));
            this.normalizer = normalizer;
            Integer len = in.readOptionalVInt();
            this.type = type;
        }
            return this.detail;
                if (size > 0) {
            return Objects.equals(name, that.name) && Arrays.equals(tokens, that.tokens);  
            return result;
                builder.endObject();  
    }
    /**
            if ((index == null || index.length() == 0) && normalizer != null) {  
        public boolean equals(Object o) {  
            return name;
        public String[] attributes() {
                this.texts = Strings.EMPTY_ARRAY;  
            PARSER.declareStringArray(Request::attributes, new ParseField("attributes"));
    /**
                charfilters = null;  
                    out.writeVInt(0);
        }
            if (this == o) {
            return this.text;
                builder.endObject();
                validationException = addValidationError("cannot define extra components on a named normalizer", validationException);
        public Response(List<AnalyzeToken> tokens, DetailAnalyzeResponse detail) {  
        public Request addTokenFilter(String tokenFilter) {
    public static class Response extends ActionResponse implements ToXContentObject {
import org.opensearch.common.annotation.PublicApi;
 */  
            result = 31 * result + Arrays.hashCode(texts);
            if (attributes == null) {  
/*  
        private final int endOffset;
     * Inner Detail Analyze Response
        @Override  
                analyzer = new AnalyzeTokenList(in);  
            this.tokenFilters.add(new NameOrDefinition(tokenFilter));  
        DetailAnalyzeResponse(
                    }  
            builder.endObject();
            }
        private final AnalyzeTokenList analyzer;  
            int startOffset,
                        tokenfilters[i] = new AnalyzeTokenList(in);
            if (attributes != null && !attributes.isEmpty()) {
            this.tokenizer = new NameOrDefinition(tokenizer);
        public boolean explain() {
            return this;  
            return builder;
            return builder;  
            builder.startObject();
import java.util.ArrayList;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            this.tokenizer = tokenizer;
        }
        public int getStartOffset() {  
                    tokenfilters = null;
                    out.writeVInt(0);
    public static class AnalyzeTokenList implements Writeable, ToXContentObject {  
                }  
            }
 *
        @Override  
            return this;
            if (positionLength > 1) {
                        charfilters[i] = new CharFilteredText(in);
 * You may obtain a copy of the License at  
        public CharFilteredText(String name, String[] texts) {
            }
                builder.endArray();  
            int positionLength,
        public DetailAnalyzeResponse(CharFilteredText[] charfilters, AnalyzeTokenList tokenizer, AnalyzeTokenList[] tokenfilters) {  
            Response that = (Response) o;  
                builder.endArray();
                } else {
                builder.startObject("tokenizer");  
        private final AnalyzeTokenList tokenizer;
                    builder.field(entity.getKey(), entity.getValue());
            out.writeBoolean(customAnalyzer);
        @Override
                } else {
            }
        public int hashCode() {
            }  
        }  
            return this;
            }
                    out.writeVInt(tokenfilters.length);
        }  
        public String getName() {  
                }
            }
        }
     */
                }  
        static final String NAME = "name";
        }  
            this.detail = detail;
        public List<NameOrDefinition> charFilters() {
            return name;  
        public String getType() {
                Request::tokenizer,
                if (charfilters != null) {
        }
     */
                return true;
            return this;
        }
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                && Objects.equals(tokenizer, that.tokenizer)
        private boolean explain = false;
                builder.endObject();  
                analyzer = null;
        }
import org.opensearch.action.support.single.shard.SingleShardRequest;  
            this.text = text;
            out.writeOptionalVInt(positionLength > 1 ? positionLength : null);  
        private final int startOffset;
        @Override
        private final List<NameOrDefinition> tokenFilters = new ArrayList<>();
        AnalyzeTokenList(StreamInput in) throws IOException {  
        }  
            out.writeStringArray(attributes);
            CharFilteredText that = (CharFilteredText) o;
        }  
