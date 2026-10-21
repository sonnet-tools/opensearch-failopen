        while (isTokenOrWhitespace) {
                        break;
                    }
    private Map<String, List<BytesRef>> createPayloads(String[] tokens, int encoding) {
import org.apache.lucene.analysis.TokenFilter;
        @Override
            }
                docsAndPositions.nextPosition();
    private String createRandomDelimiter(String[] tokens) {
                        throw new OpenSearchException("unsupported encoding type");
            .build();
        }
        }
                    }
                    isTokenOrWhitespace = true;
 * specific language governing permissions and limitations
                    }
            if (!payloadCounter.containsKey(token)) {
import org.apache.lucene.tests.analysis.MockTokenizer;
import org.apache.lucene.index.Fields;
import org.apache.lucene.analysis.payloads.PayloadHelper;
        while (iterator.next() != null) {
                        throw new OpenSearchException("unsupported encoding type");
                } else {
    }
    // Solution for now is copy what delimited payload token filter does in this test.
            } else {
        String encodingString = "";
            assertNotNull(docsAndPositions);
            if (payload.length > 0) {
 * the Apache License, Version 2.0 (the "License"); you may
 *
                }
        client().admin().indices().prepareRefresh().get();
                } else {
                        } else if (settings.get("encoding").equals("identity")) {
        int numTokensWithDuplicates = randomIntBetween(3, 15);
                        + term
import static org.hamcrest.Matchers.notNullValue;
            } else {
        }
 * license agreements. See the NOTICE file distributed with
                        }
                resultString = resultString + delimiter;
            .put("index.analysis.filter.my_delimited_payload.encoding", encodingString)
            .setSource(jsonBuilder().startObject().field("field", queryString).endObject())
public class GetTermVectorsTests extends OpenSearchSingleNodeTestCase {
        String[] tokens = crateRandomTokens();
            .startObject("properties")
        int encoding = randomIntBetween(0, 2);
    private String createString(String[] tokens, Map<String, List<BytesRef>> payloads, int encoding, char delimiter) {
            );
        }
            assertThat(term, curPayloads, notNullValue());
                    String infoString = "\nterm: " + term + " has no payload but should have payload \n" + curPayloads.get(k).toString();
        XContentBuilder mapping = jsonBuilder().startObject()
                    default: {
                        resultString = resultString + payload.utf8ToString();
            }
            .actionGet();
        }
        // create the mapping
                    return false;
            .put("index.analysis.filter.my_delimited_payload.delimiter", delimiter)
 * KIND, either express or implied.  See the License for the
            finalTokens[i] = tokens[randomIntBetween(0, tokens.length - 1)];
 * this work for additional information regarding copyright
            assertThat(docsAndPositions.nextDoc(), equalTo(0));
                    }
                        }
                        PayloadEncoder encoder = null;
import org.apache.lucene.util.BytesRef;
        String delimiter = "";
    protected Collection<Class<? extends Plugin>> getPlugins() {
 * The OpenSearch Contributors require contributions made to
            public boolean incrementToken() throws IOException {
                payloadCounter.put(token, payloadCounter.get(token) + 1);
                        float theFloat = randomFloat();
                    case 1: {
                }
import org.opensearch.plugins.Plugin;
                payloadCounter.putIfAbsent(token, 0);
            private final PayloadEncoder encoder;
            return Collections.singletonList(
                    }
 * Modifications Copyright OpenSearch Contributors. See
            MockPayloadTokenFilter(TokenStream input, char delimiter, PayloadEncoder encoder) {
import org.apache.lucene.analysis.TokenStream;
                        + "\n but should have payload \n"
            .endObject()
                    public String name() {
        Terms terms = fields.terms("field");
            .field("analyzer", "payload_test")
    }
            });
    // Unfortunately MockPayloadAnalyzer couldn't be used here as it misses functionality.
import java.io.IOException;
            .put("index.analysis.analyzer.payload_test.tokenizer", "mock-whitespace")
            .startObject("field")
        Map<String, Integer> payloadCounter = new HashMap<>();
                }
            @Override
        TermVectorsResponse response = resp.execute().actionGet();
                    case 2: {
                        break;
                        break;
 */
            .setOffsets(true)
 * You may obtain a copy of the License at
 * Licensed to Elasticsearch under one or more contributor
                this.encoder = encoder;
        return resultString;
 * SPDX-License-Identifier: Apache-2.0
        if (encoding == 2) {
                        }
        client().prepareIndex("test")
                            if (Character.isWhitespace(payload.charAt(c))) {
                        String payload = randomUnicodeOfLengthBetween(50, 100);
                    String infoString = "\nterm: "
                    return true;
import static org.hamcrest.Matchers.equalTo;
                if (input.incrementToken()) {
        for (String token : tokens) {
        for (String token : tokens) {
                    final char[] buffer = termAtt.buffer();
                if (token.contains(delimiter)) {
                        break;
                        resultString = resultString + Integer.toString(PayloadHelper.decodeInt(payload.bytes, payload.offset));
            encodingString = "identity";
                    }
            String term = iterator.term().utf8ToString();
            resultString = resultString + " ";
import org.opensearch.test.OpenSearchSingleNodeTestCase;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
            PostingsEnum docsAndPositions = iterator.postings(null, PostingsEnum.ALL);
                        for (int c = 0; c < payload.length(); c++) {
import org.opensearch.plugins.AnalysisPlugin;
                        break;
    }
                    }
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                        } else if (settings.get("encoding").equals("int")) {
                    }
import java.util.List;
import org.apache.lucene.analysis.payloads.IdentityEncoder;
        createIndex("test", setting, mapping);
import org.opensearch.core.xcontent.XContentBuilder;
        }
                        + " has payload \n"
                super(input);
            .endObject();
import java.util.Map;
                        if (settings.get("encoding").equals("float")) {
 */
        }
            resultString = resultString + token;
    @Override
                if (docsAndPositions.getPayload() != null) {
            .setPayloads(true)
            for (int k = 0; k < docsAndPositions.freq(); k++) {
                    for (int i = 0; i < length; i++) {
import org.opensearch.index.analysis.TokenFilterFactory;
 * compatible open source license.
        @Override
                        if (buffer[i] == delimiter) {
                        + docsAndPositions.getPayload().toString()
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.analysis.payloads.IntegerEncoder;
        }
    }
                    assertThat(infoString, curPayloads.get(k).length, equalTo(0));
/*
import org.apache.lucene.index.Terms;
        if (encoding == 1) {
 *
                    @Override
                            return true;
                            payAtt.setPayload(encoder.encode(buffer, i + 1, (length - (i + 1))));
 * under the License.
import java.util.HashMap;
            List<BytesRef> curPayloads = payloads.get(term);
            .setSelectedFields();
            .setId(Integer.toString(1))
    public void testRandomPayloadWithDelimitedPayloadTokenFilter() throws IOException {
                switch (encoding) {
        return Collections.singleton(MockPayloadAnalyzerPlugin.class);
                    case 0: {
 * GitHub history for details.
                            encoder = new IntegerEncoder();
                }
        TermsEnum iterator = terms.iterator();
        assertThat(iterator.next(), nullValue());
                        payloads.get(token).add(new BytesRef(payload));
                        + curPayloads.get(k).toString();
            private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
                }
        assertThat(fields.size(), equalTo(1));
        public List<PreConfiguredTokenizer> getPreConfiguredTokenizers() {
import org.opensearch.common.settings.Settings;
/*
                                payload = payload.replace(payload.charAt(c), 'w');
        // create the test document
            boolean createPayload = randomBoolean();
        // Based on DelimitedPayloadTokenFilter:
                return new TokenFilterFactory() {
            }
import static org.hamcrest.Matchers.nullValue;
                        resultString = resultString + Float.toString(PayloadHelper.decodeFloat(payload.bytes, payload.offset));
        String queryString = createString(tokens, payloads, encoding, delimiter.charAt(0));
import java.util.Collections;
        return payloads;
}
                            encoder = new IdentityEncoder();
            .put("index.analysis.filter.my_delimited_payload.type", "mock_payload_filter")
                    case 0: {
            }
            .field("type", "text")
                        payloads.get(token).add(new BytesRef(PayloadHelper.encodeInt(randomInt())));
        Map<String, List<BytesRef>> payloads = createPayloads(tokens, encoding);
    // Delimited payload token filter was moved to analysis-common module,
            .setPositions(true)
        Map<String, List<BytesRef>> payloads = new HashMap<>();
import org.apache.lucene.analysis.tokenattributes.PayloadAttribute;
            .putList("index.analysis.analyzer.payload_test.filter", "my_delimited_payload")
            delimiter = randomUnicodeOfLength(1);
            encodingString = "float";
 * this file be licensed under the Apache-2.0 license or a
            if (createPayload) {
import org.apache.lucene.index.TermsEnum;
                isTokenOrWhitespace = true;
                    @Override
        Settings setting = Settings.builder()
                PreConfiguredTokenizer.singleton("mock-whitespace", () -> new MockTokenizer(MockTokenizer.WHITESPACE, false))
    }
        return finalTokens;
 */
            }
                    payAtt.setPayload(null);
            .endObject()
 * ownership. Elasticsearch licenses this file to you under
                    }
                            termAtt.setLength(i); // simply set a new length
                            encoder = new FloatEncoder();
                        return "mock_payload_filter";
            isTokenOrWhitespace = false;
                    assertThat(infoString, docsAndPositions.getPayload(), equalTo(curPayloads.get(k)));
            encodingString = "int";
            .execute()
                payloads.get(token).add(new BytesRef());
                    }
        String delimiter = createRandomDelimiter(tokens);
 *
            private final PayloadAttribute payAtt = addAttribute(PayloadAttribute.class);
import org.opensearch.indices.analysis.AnalysisModule;
package org.opensearch.action.termvectors;
            BytesRef payload = payloads.get(token).get(payloadCounter.get(token));
        }
                };
    private String[] crateRandomTokens() {
import java.util.Collection;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.ArrayList;
        }
            if (Character.isWhitespace(delimiter.charAt(0))) {
            }
            for (String token : tokens) {
        assertThat("doc id 1 doesn't exists but should", response.isExists(), equalTo(true));
                switch (encoding) {
        String[] finalTokens = new String[numTokensWithDuplicates];
        String resultString = "";
                    default: {
            payloads.computeIfAbsent(token, k -> new ArrayList<>());
            private final char delimiter;
    }
                        payloads.get(token).add(new BytesRef(PayloadHelper.encodeFloat(theFloat)));
import org.apache.lucene.analysis.payloads.FloatEncoder;
import org.opensearch.index.analysis.PreConfiguredTokenizer;
        boolean isTokenOrWhitespace = true;
        }
 * not use this file except in compliance with the License.
                    case 1: {
                    public TokenStream create(TokenStream tokenStream) {
            }
import org.apache.lucene.index.PostingsEnum;
        final class MockPayloadTokenFilter extends TokenFilter {
    public static class MockPayloadAnalyzerPlugin extends Plugin implements AnalysisPlugin {
                    final int length = termAtt.length();
            }
                this.delimiter = delimiter;
        if (encoding == 0) {
                        return new MockPayloadTokenFilter(tokenStream, delimiter.charAt(0), encoder);
import org.apache.lucene.analysis.payloads.PayloadEncoder;
 * software distributed under the License is distributed on an
                        break;
        public Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
                        String delimiter = settings.get("delimiter");
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            .field("term_vector", "with_positions_offsets_payloads")
        TermVectorsRequestBuilder resp = client().prepareTermVectors("test", Integer.toString(1))
        String[] tokens = { "the", "quick", "brown", "fox" };
                    // we have not seen the delimiter
            return Collections.singletonMap("mock_payload_filter", (indexSettings, environment, name, settings) -> {
                            }
        Fields fields = response.getFields();
/*
        return delimiter;
import org.opensearch.OpenSearchException;
        for (int i = 0; i < numTokensWithDuplicates; i++) {
                    case 2: {
    // This test relies heavily on this token filter, even though it is not testing this token filter.
                    }
