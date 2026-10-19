    private DetailAnalyzeResponse(
            return PARSER.parse(parser, null);
            this.name = name;
        }
        int result = Objects.hash(customAnalyzer, analyzer, tokenizer);  
    }
        }
            PARSER.declareString(constructorArg(), new ParseField("name"));
            } else {
            "token_list",
        public String getName() {
        public AnalyzeTokenList(String name, List<AnalyzeResponse.AnalyzeToken> tokens) {
        @Override  
        @SuppressWarnings("unchecked")  
 *  
/*
        if (o == null || getClass() != o.getClass()) return false;
        return PARSER.parse(parser, null);
    );
                this.texts = texts;
            && Arrays.equals(tokenfilters, that.tokenfilters);
    public static DetailAnalyzeResponse fromXContent(XContentParser parser) throws IOException {  
    public static class AnalyzeTokenList {
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;  
            if (o == null || getClass() != o.getClass()) return false;
        static {
 * Unless required by applicable law or agreed to in writing,
    }
        this.tokenfilters = tokenfilters == null ? null : tokenfilters.toArray(new AnalyzeTokenList[] {});  
 *
        PARSER.declareObjectArray(optionalConstructorArg(), CharFilteredText.PARSER, new ParseField("charfilters"));
        AnalyzeTokenList tokenizer,
    }
 * specific language governing permissions and limitations
            PARSER.declareObjectArray(constructorArg(), (p, c) -> AnalyzeResponse.AnalyzeToken.fromXContent(p), new ParseField("tokens"));  
            args -> new AnalyzeTokenList((String) args[0], (List<AnalyzeResponse.AnalyzeToken>) args[1])
        boolean customAnalyzer,
 * under the License.  
    }  
        return tokenfilters;
            && Objects.equals(tokenizer, that.tokenizer)  
        }
            result = 31 * result + Arrays.hashCode(texts);  
        List<CharFilteredText> charfilters,
        result = 31 * result + Arrays.hashCode(tokenfilters);
            return tokens;  
 * KIND, either express or implied.  See the License for the
    public boolean equals(Object o) {
            return Objects.equals(name, that.name) && Arrays.equals(texts, that.texts);  
}
 * this file be licensed under the Apache-2.0 license or a
            PARSER.declareStringArray(constructorArg(), new ParseField("filtered_text"));  
        @Override
        @Override
            if (o == null || getClass() != o.getClass()) return false;
            if (this == o) return true;  
        @SuppressWarnings("unchecked")  
import org.opensearch.core.xcontent.XContentParser;
 * license agreements. See the NOTICE file distributed with
        private static final ConstructingObjectParser<AnalyzeTokenList, Void> PARSER = new ConstructingObjectParser<>(
        public String[] getTexts() {
    @Override
            PARSER.declareString(constructorArg(), new ParseField("name"));
        }
    ) {
        this.analyzer = analyzer;  
 * GitHub history for details.
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.ParseField;
        "detail",
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
        List<AnalyzeTokenList> tokenfilters  
        PARSER.declareObject(optionalConstructorArg(), AnalyzeTokenList.PARSER, new ParseField("analyzer"));  
    static final ConstructingObjectParser<DetailAnalyzeResponse, Void> PARSER = new ConstructingObjectParser<>(
public class DetailAnalyzeResponse {
        public static CharFilteredText fromXContent(XContentParser parser) throws IOException {  
            return result;
        args -> new DetailAnalyzeResponse(
        }
            return Objects.equals(name, that.name) && Arrays.equals(tokens, that.tokens);
            (List<CharFilteredText>) args[2],
    @SuppressWarnings("unchecked")  
        }
        public int hashCode() {
    }
        private final String name;
        )
        if (this == o) return true;  
        @Override
 * You may obtain a copy of the License at  
    private final AnalyzeTokenList[] tokenfilters;
        }
            "char_filtered_text",
    public AnalyzeTokenList[] tokenfilters() {  
package org.opensearch.client.indices;
            int result = Objects.hash(name);  
    }
    private final CharFilteredText[] charfilters;  
    private final boolean customAnalyzer;
        }  
            && Arrays.equals(charfilters, that.charfilters)
        }
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
 * Licensed to Elasticsearch under one or more contributor  
import java.util.List;
        );
 * the Apache License, Version 2.0 (the "License"); you may
    }
            return result;
            (AnalyzeTokenList) args[1],  
import java.util.Objects;  
    public CharFilteredText[] charfilters() {
    public AnalyzeTokenList tokenizer() {
            return name;
        private final String[] texts;
 *
        CharFilteredText(String name, String[] texts) {
            CharFilteredText that = (CharFilteredText) o;
        PARSER.declareObjectArray(optionalConstructorArg(), AnalyzeTokenList.PARSER, new ParseField("tokenfilters"));  
            this.tokens = tokens.toArray(new AnalyzeResponse.AnalyzeToken[] {});
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public boolean equals(Object o) {
        }  
        public static AnalyzeTokenList fromXContent(XContentParser parser) throws IOException {  
    private final AnalyzeTokenList tokenizer;
        private static final ConstructingObjectParser<CharFilteredText, Void> PARSER = new ConstructingObjectParser<>(
 */
    public static class CharFilteredText {  
        PARSER.declareBoolean(constructorArg(), new ParseField("custom_analyzer"));
        this.customAnalyzer = customAnalyzer;
 */  
 * The OpenSearch Contributors require contributions made to  
        public String getName() {
        }
 * software distributed under the License is distributed on an
        public int hashCode() {
    @Override
        private final String name;
            true,  
    }  
/*  
        this.charfilters = charfilters == null ? null : charfilters.toArray(new CharFilteredText[] {});
        );
        return this.analyzer;
        }  
            if (this == o) return true;
                this.texts = Strings.EMPTY_ARRAY;  
            AnalyzeTokenList that = (AnalyzeTokenList) o;  
            }
        return result;  
            int result = Objects.hash(name);
        AnalyzeTokenList analyzer,  
        PARSER.declareObject(optionalConstructorArg(), AnalyzeTokenList.PARSER, new ParseField("tokenizer"));
 */  
    public int hashCode() {
 * compatible open source license.
        return this.charfilters;
import org.opensearch.core.common.Strings;
    static {
        }
        return tokenizer;  
            (boolean) args[0],
        public AnalyzeResponse.AnalyzeToken[] getTokens() {
    public AnalyzeTokenList analyzer() {  
            true,  
        return customAnalyzer == that.customAnalyzer  
            && Objects.equals(analyzer, that.analyzer)
            (List<AnalyzeTokenList>) args[4]  
 * Modifications Copyright OpenSearch Contributors. See
            (AnalyzeTokenList) args[3],
            result = 31 * result + Arrays.hashCode(tokens);
 * not use this file except in compliance with the License.
            args -> new CharFilteredText((String) args[0], ((List<String>) args[1]).toArray(new String[0]))
    }
        true,  
            return PARSER.parse(parser, null);
/*  
        private final AnalyzeResponse.AnalyzeToken[] tokens;  
    }
        this.tokenizer = tokenizer;
        public boolean equals(Object o) {  
            return texts;  
            if (texts != null) {  
import java.util.Arrays;
        result = 31 * result + Arrays.hashCode(charfilters);
            return name;
        }
        static {
import java.io.IOException;  
            this.name = name;  
 * this work for additional information regarding copyright
        DetailAnalyzeResponse that = (DetailAnalyzeResponse) o;
import org.opensearch.core.xcontent.ConstructingObjectParser;  
    private final AnalyzeTokenList analyzer;
