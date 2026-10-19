        }
 * specific language governing permissions and limitations
                        asList(
                            "fox jump",  
            final List<String> tokens = new ArrayList<>(asList("q", "qu", "qui", "quic", "quick"));
                            "fox",
    }
        for (int i = 0; i < count; i++) {  
        Function<Integer, SearchAsYouTypeAnalyzer> analyzerFunction,
                    tokens.addAll(tokenWithSpaces("lazy", shingleSize));  
import java.util.stream.IntStream;  
                    tokens.addAll(asList("l", "la", "laz", "lazy"));
 *    http://www.apache.org/licenses/LICENSE-2.0
                            "fox ",  
                        asList(
            return tokens;
                            "b",  
                            "brown fox jum",  
                            "brown fox ju",
                        )
import static java.util.Collections.emptyList;  
                    );
                            "fox jump",
                return asList("quick brown fox jump", "brown fox jump lazy");  
                            "quick brown fox"
                            "brown fox jump laz",
    private static String spaces(int count) {
        testCase("quick", shingleSize -> SearchAsYouTypeAnalyzer.withShingle(SIMPLE, shingleSize), shingleSize -> emptyList());
            throw new IllegalArgumentException();
                            "brown fox jum",  
                            "quick brown fox",
                            "brown fox ",  
                    );  
                return asList("quick brown fox", "brown fox jump", "fox jump lazy");
                            "brown fox jump l",  
                            "quick",  
 * KIND, either express or implied.  See the License for the
}
                            "quick brow",  
            assertThat("analyzed correctly with " + analyzer, actualTokens, equalTo(expectedTokens));  
            if (shingleSize == 2) {
                            "brown fox j",
                        )  
                            "brown ",
                            "quick brown ",
import static org.hamcrest.Matchers.equalTo;
                            "fo",
 * this work for additional information regarding copyright
                            "quick brow",
        String text,  
                            "quick brown f",  
        );  
                            "fox jump l",  
import java.io.IOException;
            tokenStream.reset();  
                            "quick brown",
                throw new IllegalArgumentException();
        });
                            "brown fox jump la",
                if (shingleSize == 2) {
                    tokens.addAll(tokenWithSpaces("fox jump lazy", shingleSize - 2));
                            "quick bro",
 * not use this file except in compliance with the License.
                            "q",
    }  
                            "qu",
 * this file be licensed under the Apache-2.0 license or a
                        asList(
                            "brown fox jump lazy"  
        final List<String> tokens = new ArrayList<>();  
                tokens.add(charTermAttribute.toString());
                            "fox jump ",
 * Modifications Copyright OpenSearch Contributors. See
                    final List<String> tokens = new ArrayList<>();  
                            "quick brown fox jump"
                    tokens.addAll(tokenWithSpaces("jump lazy", shingleSize - 1));
/*  
 * ownership. Elasticsearch licenses this file to you under  
                    tokens.addAll(asList("j", "ju", "jum", "jump", "jump ", "jump l", "jump la", "jump laz", "jump lazy"));  
                            "fo",  
                            "brown fox j",
            }
 * compatible open source license.
                            "qui",
            final List<String> actualTokens = analyze(analyzer, text);
            } else if (shingleSize == 3) {  
                            "fox jum",
                    tokens.addAll(
        }
                            "fox jump lazy"  
                    tokens.addAll(asList("l", "la", "laz", "lazy"));
                            "qui",
                            "brown fo",
                            "fox ju",
                            "quic",
                    );
    private static final Analyzer SIMPLE = new SimpleAnalyzer();  
                            "quick br",
                            "brown fox",
                        asList(
    }
                    tokens.addAll(asList("j", "ju", "jum", "jump", "jump ", "jump l", "jump la", "jump laz", "jump lazy"));  
                            "quick brown fox ",  
            while (tokenStream.incrementToken()) {
                            "quick brown ",
                        )
                            "fox ",
                            "brown fo",
                            "fox jump la",  
        try (TokenStream tokenStream = analyzer.tokenStream("field", text)) {
                        asList("q", "qu", "qui", "quic", "quick", "quick ", "quick b", "quick br", "quick bro", "quick brow", "quick brown")
                    tokens.addAll(asList("b", "br", "bro", "brow", "brown", "brown ", "brown f", "brown fo", "brown fox"));
                        )
    }  
                    );  
            shingleSize -> SearchAsYouTypeAnalyzer.withShingleAndPrefix(SIMPLE, shingleSize),  
            } else if (shingleSize == 4) {
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.test.OpenSearchTestCase;  
                        asList(
import org.apache.lucene.analysis.Analyzer;
        return tokens;
                            "brown fox jump",
                    );
 * You may obtain a copy of the License at  
            tokens.addAll(tokenWithSpaces("quick", shingleSize));  
            "quick brown fox jump lazy",
                            "quick brown fox jum",  
                            "quick brown fox j",
/*  
 *
 *
 * the Apache License, Version 2.0 (the "License"); you may
                            "fox jump laz",
 */  
                        )
                            "fox jump la",
            final List<String> expectedTokens = expectedTokensFunction.apply(shingleSize);
                    tokens.addAll(
 * GitHub history for details.
    public void testMultiTermShingles() throws IOException {
        return IntStream.range(1, maxShingleSize).mapToObj(i -> text + spaces(i)).collect(toList());
                            "brown fox ju",
                            "fox jump ",
import java.util.ArrayList;  
                            "brown fox jump"
                            "fox j",  
                            "brown ",
import java.util.List;
                            "brow",  
 */  
                            "brow",  
                            "f",  
                            "quick bro",
                            "bro",
                            "fox ju",
                    );  
                            "brown",
            }
        });  
            shingleSize -> {
                            "fox j",
                return asList("quick brown", "brown fox", "fox jump", "jump lazy");
                            "quick",
    public static List<String> analyze(SearchAsYouTypeAnalyzer analyzer, String text) throws IOException {
                    return tokens;  
                    return tokens;
public class SearchAsYouTypeAnalyzerTests extends OpenSearchTestCase {
                            "brown",
                            "fox jump l",
        final StringBuilder builder = new StringBuilder();
 * SPDX-License-Identifier: Apache-2.0
                    tokens.addAll(
                    tokens.addAll(asList("l", "la", "laz", "lazy"));
                            "quick b",  
                    return tokens;
                            "quic",  
                            "quick brown fo",
                            "fox jump laz",
    }  
import org.apache.lucene.analysis.TokenStream;
                            "quick ",
                            "brown fox jump ",
                } else if (shingleSize == 4) {
    public void testSingleTermShingles() throws IOException {
    private void testCase(
import org.opensearch.index.mapper.SearchAsYouTypeFieldMapper.SearchAsYouTypeAnalyzer;
                        )
 */
                    tokens.addAll(tokenWithSpaces("jump lazy", shingleSize - 1));
                            "brown f",  
                }
import java.util.function.Function;
 * license agreements. See the NOTICE file distributed with
                    tokens.addAll(  
            final CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
                            "quick brown f",
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
                            "b",  
        return builder.toString();  
/*
            // "quick red fox lazy brown",
        }
                    final List<String> tokens = new ArrayList<>();
                            "quick ",
                            "br",
            builder.append(" ");
import static java.util.Arrays.asList;
                        asList(
                    tokens.addAll(asList("j", "ju", "jum", "jump", "jump ", "jump l", "jump la", "jump laz", "jump lazy"));  
        testCase("quick brown fox jump lazy", shingleSize -> SearchAsYouTypeAnalyzer.withShingle(SIMPLE, shingleSize), shingleSize -> {  
    ) throws IOException {  
    public void testSingleTermPrefix() throws IOException {  
                    tokens.addAll(tokenWithSpaces("lazy", shingleSize));
    public void testMultiTermPrefix() throws IOException {
                            "quick b",
        testCase("quick", shingleSize -> SearchAsYouTypeAnalyzer.withShingleAndPrefix(SIMPLE, shingleSize), shingleSize -> {
                    tokens.addAll(
        testCase(  
                            "fox jump lazy"
import org.apache.lucene.analysis.core.SimpleAnalyzer;  
        Function<Integer, List<String>> expectedTokensFunction
import static java.util.stream.Collectors.toList;
                            "qu",  
    }
 * The OpenSearch Contributors require contributions made to  
                    tokens.addAll(  
            }  
                    final List<String> tokens = new ArrayList<>();  
                            "quick brown",  
                            "quick brown fo",  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private static List<String> tokenWithSpaces(String text, int maxShingleSize) {  
 * Unless required by applicable law or agreed to in writing,
                } else if (shingleSize == 3) {
                            "brown f",  
 *  
    }
                            "br",
                            "brown fox",
                            "quick brown fox ju",
                            "f",
                            "q",  
            final SearchAsYouTypeAnalyzer analyzer = analyzerFunction.apply(shingleSize);  
                    tokens.addAll(asList("f", "fo", "fox", "fox ", "fox j", "fox ju", "fox jum", "fox jump"));
                    tokens.addAll(
 * under the License.  
                    tokens.addAll(tokenWithSpaces("lazy", shingleSize));  
    }
                            "fox",
                    );  
                            "bro",
package org.opensearch.index.mapper;
                            "brown fox ",  
        for (int shingleSize = 2; shingleSize <= 4; shingleSize++) {
                            "fox jum",  
 * software distributed under the License is distributed on an
                            "quick br",  
