import org.opensearch.core.xcontent.XContentParser;
            return this.positionLength;
 * specific language governing permissions and limitations
        this.detail = detail;
 * GitHub history for details.
            PARSER.declareInt(AnalyzeToken::setPosition, new ParseField("position"));  
        private final Map<String, Object> attributes = new HashMap<>();
        }
        public String getTerm() {
            return this.type;
        return Objects.hash(detail, tokens);
        @Override  
    }
        }
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.xcontent.ObjectParser;  
        this.tokens = tokens;  
        public String getType() {  
    private static final ConstructingObjectParser<AnalyzeResponse, Void> PARSER = new ConstructingObjectParser<>(
        private int endOffset;
            if (this == o) return true;  
        }  
 * compatible open source license.
                && endOffset == that.endOffset
        private int startOffset;  
        private void setPosition(int position) {  
        static {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
    private static final String DETAIL = "detail";
            if (o == null || getClass() != o.getClass()) return false;
        private int position;
import java.io.IOException;  
        }  
package org.opensearch.client.indices;
        PARSER.declareObject(optionalConstructorArg(), DetailAnalyzeResponse.PARSER, new ParseField(DETAIL));  
    @SuppressWarnings("unchecked")  
            this.attributes.put(key, value);
 * software distributed under the License is distributed on an
        public int getEndOffset() {  
                && positionLength == that.positionLength  
 * KIND, either express or implied.  See the License for the
            PARSER.declareString(AnalyzeToken::setTerm, new ParseField("token"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            this.positionLength = positionLength;  
                && Objects.equals(term, that.term)
    }  
import java.util.Map;  
            AnalyzeResponse.AnalyzeToken that = (AnalyzeResponse.AnalyzeToken) o;
 */
            return Objects.hash(term, startOffset, endOffset, position, positionLength, attributes, type);
        "analyze_response",
        return Objects.equals(detail, that.detail) && Objects.equals(tokens, that.tokens);  
        public int getStartOffset() {
            this.term = term;
        public int hashCode() {
    public static AnalyzeResponse fromXContent(XContentParser parser) throws IOException {  
        }
        }
    }
        private void setTerm(String term) {  
        private String term;
    }  
    private final DetailAnalyzeResponse detail;
            return this.endOffset;
        if (o == null || getClass() != o.getClass()) return false;
    }  
            PARSER.declareString(AnalyzeToken::setType, new ParseField("type"));
                && position == that.position
        public int getPositionLength() {
        );
 * Unless required by applicable law or agreed to in writing,
public class AnalyzeResponse {
            this.position = position;
            return startOffset == that.startOffset  
 * Licensed to Elasticsearch under one or more contributor  
        return this.tokens;
 * Modifications Copyright OpenSearch Contributors. See
        PARSER.declareObjectArray(optionalConstructorArg(), AnalyzeToken.PARSER, new ParseField(TOKENS));
        true,  
        }
            PARSER.declareInt(AnalyzeToken::setEndOffset, new ParseField("end_offset"));
            return this.startOffset;
    @Override  
 * You may obtain a copy of the License at  
import java.util.List;
/*
import java.util.Objects;
            this.startOffset = startOffset;  
            return PARSER.parse(parser, null);
        return this.detail;  
        private static final ObjectParser<AnalyzeToken, Void> PARSER = new ObjectParser<>(
                && Objects.equals(attributes, that.attributes)
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;  
    private static final String TOKENS = "tokens";
        private void setEndOffset(int endOffset) {
        return PARSER.parse(parser, null);
 *  
}
 * The OpenSearch Contributors require contributions made to  
/*  
import org.opensearch.core.xcontent.ConstructingObjectParser;
 */  
 * license agreements. See the NOTICE file distributed with
/*  
    );
        @Override
        private void setPositionLength(int positionLength) {
            AnalyzeToken::setAttribute,  
        public boolean equals(Object o) {
        }  
        private void setType(String type) {
        }
        public static AnalyzeToken fromXContent(XContentParser parser) throws IOException {  
        }
 * not use this file except in compliance with the License.
            AnalyzeToken::new
    public int hashCode() {
            PARSER.declareInt(AnalyzeToken::setPositionLength, new ParseField("positionLength"));  
        if (this == o) return true;  
            PARSER.declareInt(AnalyzeToken::setStartOffset, new ParseField("start_offset"));
 * this work for additional information regarding copyright
        public Map<String, Object> getAttributes() {
        }
        }
import java.util.HashMap;
            "analyze_token",
    }
        private String type;
    private final List<AnalyzeResponse.AnalyzeToken> tokens;  
        }
        private void setAttribute(String key, Object value) {  
        }  
        public int getPosition() {
    public boolean equals(Object o) {
            return this.position;  
            this.endOffset = endOffset;
    private AnalyzeResponse(List<AnalyzeResponse.AnalyzeToken> tokens, DetailAnalyzeResponse detail) {
            return this.attributes;  
        AnalyzeResponse that = (AnalyzeResponse) o;
                && Objects.equals(type, that.type);  
 * SPDX-License-Identifier: Apache-2.0
        }
        private void setStartOffset(int startOffset) {
    public DetailAnalyzeResponse detail() {
    public List<AnalyzeResponse.AnalyzeToken> getTokens() {
 */  
 * under the License.  
        }
 *
            return this.term;  
        }
        }  
        private int positionLength = 1;  
        args -> new AnalyzeResponse((List<AnalyzeResponse.AnalyzeToken>) args[0], (DetailAnalyzeResponse) args[1])
    }
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.ParseField;
    @Override
    public static class AnalyzeToken {
    }
            this.type = type;
    static {
