 * license agreements. See the NOTICE file distributed with
            && Objects.equals(analyzer, that.analyzer)
            this.tokens = tokens.toArray(new AnalyzeResponse.AnalyzeToken[] {});
    }
 * You may obtain a copy of the License at
import java.util.List;
    public int hashCode() {
        return PARSER.parse(parser, null);
        }
            args -> new AnalyzeTokenList((String) args[0], (List<AnalyzeResponse.AnalyzeToken>) args[1])
 * this file be licensed under the Apache-2.0 license or a
        public String[] getTexts() {
            if (o == null || getClass() != o.getClass()) return false;
            return PARSER.parse(parser, null);
        private final String[] texts;
    }
            true,
        PARSER.declareObjectArray(optionalConstructorArg(), AnalyzeTokenList.PARSER, new ParseField("tokenfilters"));
            && Objects.equals(tokenizer, that.tokenizer)
        public AnalyzeTokenList(String name, List<AnalyzeResponse.AnalyzeToken> tokens) {
                this.texts = texts;
import org.opensearch.core.common.Strings;
 * compatible open source license.
        public boolean equals(Object o) {
        PARSER.declareBoolean(constructorArg(), new ParseField("custom_analyzer"));
        PARSER.declareObject(optionalConstructorArg(), AnalyzeTokenList.PARSER, new ParseField("tokenizer"));
        List<CharFilteredText> charfilters,
            } else {
    public AnalyzeTokenList[] tokenfilters() {
    }
        public int hashCode() {
        }
 * this work for additional information regarding copyright
        }
import org.opensearch.core.xcontent.ConstructingObjectParser;
        }
    @Override
            result = 31 * result + Arrays.hashCode(tokens);
            return result;
    }
        PARSER.declareObject(optionalConstructorArg(), AnalyzeTokenList.PARSER, new ParseField("analyzer"));
            && Arrays.equals(charfilters, that.charfilters)
            return name;
 */
package org.opensearch.client.indices;
        }
    }
    }
 * Modifications Copyright OpenSearch Contributors. See
/*
    }
            args -> new CharFilteredText((String) args[0], ((List<String>) args[1]).toArray(new String[0]))
public class DetailAnalyzeResponse {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.XContentParser;
    );
        boolean customAnalyzer,
        @Override
    public static class CharFilteredText {
        return result;
            result = 31 * result + Arrays.hashCode(texts);
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
import java.util.Objects;
    ) {
            if (texts != null) {
    static {
    }
            return name;
            return Objects.equals(name, that.name) && Arrays.equals(tokens, that.tokens);
        private static final ConstructingObjectParser<AnalyzeTokenList, Void> PARSER = new ConstructingObjectParser<>(
        this.customAnalyzer = customAnalyzer;
            AnalyzeTokenList that = (AnalyzeTokenList) o;
 * ownership. Elasticsearch licenses this file to you under
    private final AnalyzeTokenList analyzer;
    public AnalyzeTokenList tokenizer() {
            return tokens;
        public static CharFilteredText fromXContent(XContentParser parser) throws IOException {
        this.tokenizer = tokenizer;
        static {
        static {
        @Override
 */
        );
        AnalyzeTokenList analyzer,
        result = 31 * result + Arrays.hashCode(tokenfilters);
 *
        this.charfilters = charfilters == null ? null : charfilters.toArray(new CharFilteredText[] {});
            CharFilteredText that = (CharFilteredText) o;
        private static final ConstructingObjectParser<CharFilteredText, Void> PARSER = new ConstructingObjectParser<>(
        public int hashCode() {
 * GitHub history for details.
            this.name = name;
        );
        return tokenizer;
            int result = Objects.hash(name);
    public static class AnalyzeTokenList {
 */
    @SuppressWarnings("unchecked")
            return result;
            return PARSER.parse(parser, null);
            return texts;
 * The OpenSearch Contributors require contributions made to
    @Override
            (boolean) args[0],
        private final String name;
        int result = Objects.hash(customAnalyzer, analyzer, tokenizer);
    }
 * not use this file except in compliance with the License.
        @Override
        public String getName() {
        this.analyzer = analyzer;
/*
            PARSER.declareObjectArray(constructorArg(), (p, c) -> AnalyzeResponse.AnalyzeToken.fromXContent(p), new ParseField("tokens"));
 * Unless required by applicable law or agreed to in writing,
    public AnalyzeTokenList analyzer() {
            true,
 * Licensed to Elasticsearch under one or more contributor
            (AnalyzeTokenList) args[1],
        args -> new DetailAnalyzeResponse(
        }
        }
        }
            if (o == null || getClass() != o.getClass()) return false;
            return Objects.equals(name, that.name) && Arrays.equals(texts, that.texts);
        AnalyzeTokenList tokenizer,
        true,
        return this.analyzer;
        @SuppressWarnings("unchecked")
            (List<CharFilteredText>) args[2],
            && Arrays.equals(tokenfilters, that.tokenfilters);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                this.texts = Strings.EMPTY_ARRAY;
            PARSER.declareString(constructorArg(), new ParseField("name"));
/*
        @SuppressWarnings("unchecked")
    public CharFilteredText[] charfilters() {
        "detail",
    private final AnalyzeTokenList tokenizer;
        public AnalyzeResponse.AnalyzeToken[] getTokens() {
        if (o == null || getClass() != o.getClass()) return false;
        }
 *
            "char_filtered_text",
        @Override
    private final boolean customAnalyzer;
 * under the License.
        }
    static final ConstructingObjectParser<DetailAnalyzeResponse, Void> PARSER = new ConstructingObjectParser<>(
        public String getName() {
 *
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
    public boolean equals(Object o) {
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
        this.tokenfilters = tokenfilters == null ? null : tokenfilters.toArray(new AnalyzeTokenList[] {});
 * specific language governing permissions and limitations
        }
        return this.charfilters;
    private final CharFilteredText[] charfilters;
        public boolean equals(Object o) {
import java.io.IOException;
        )
            if (this == o) return true;
        result = 31 * result + Arrays.hashCode(charfilters);
            int result = Objects.hash(name);
            PARSER.declareString(constructorArg(), new ParseField("name"));
        return customAnalyzer == that.customAnalyzer
            }
        private final String name;
            this.name = name;
    }
        CharFilteredText(String name, String[] texts) {
            "token_list",
 * software distributed under the License is distributed on an
        DetailAnalyzeResponse that = (DetailAnalyzeResponse) o;
}
import org.opensearch.core.ParseField;
    private final AnalyzeTokenList[] tokenfilters;
    }
        }
        if (this == o) return true;
        }
        List<AnalyzeTokenList> tokenfilters
        PARSER.declareObjectArray(optionalConstructorArg(), CharFilteredText.PARSER, new ParseField("charfilters"));
 *    http://www.apache.org/licenses/LICENSE-2.0
    private DetailAnalyzeResponse(
            (List<AnalyzeTokenList>) args[4]
        private final AnalyzeResponse.AnalyzeToken[] tokens;
        public static AnalyzeTokenList fromXContent(XContentParser parser) throws IOException {
        }
            if (this == o) return true;
            PARSER.declareStringArray(constructorArg(), new ParseField("filtered_text"));
import java.util.Arrays;
        return tokenfilters;
            (AnalyzeTokenList) args[3],
    public static DetailAnalyzeResponse fromXContent(XContentParser parser) throws IOException {
