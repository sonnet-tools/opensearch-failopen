 * ownership. Elasticsearch licenses this file to you under  
        @Override
    // This test relies heavily on this token filter, even though it is not testing this token filter.
                isTokenOrWhitespace = true;
                    }
            if (createPayload) {  
                    for (int i = 0; i < length; i++) {  
        return payloads;
 * license agreements. See the NOTICE file distributed with
                        resultString = resultString + Integer.toString(PayloadHelper.decodeInt(payload.bytes, payload.offset));
                            encoder = new IdentityEncoder();  
        String queryString = createString(tokens, payloads, encoding, delimiter.charAt(0));  
import org.apache.lucene.tests.analysis.MockTokenizer;
        TermsEnum iterator = terms.iterator();  
                        String payload = randomUnicodeOfLengthBetween(50, 100);  
            for (String token : tokens) {
        }  
        String delimiter = "";
        return resultString;  
                            payAtt.setPayload(encoder.encode(buffer, i + 1, (length - (i + 1))));
                    assertThat(infoString, docsAndPositions.getPayload(), equalTo(curPayloads.get(k)));
import java.util.List;  
            boolean createPayload = randomBoolean();
import org.apache.lucene.index.PostingsEnum;
 */
                payloadCounter.putIfAbsent(token, 0);
            .put("index.analysis.analyzer.payload_test.tokenizer", "mock-whitespace")  
            PostingsEnum docsAndPositions = iterator.postings(null, PostingsEnum.ALL);  
    }  
                        break;
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
                    }  
 * GitHub history for details.
            );  
                payloads.get(token).add(new BytesRef());
        public List<PreConfiguredTokenizer> getPreConfiguredTokenizers() {  
            if (!payloadCounter.containsKey(token)) {
                    }
                } else {
            });
                        }
    private String createRandomDelimiter(String[] tokens) {
                    assertThat(infoString, curPayloads.get(k).length, equalTo(0));
    protected Collection<Class<? extends Plugin>> getPlugins() {
    }
        Map<String, List<BytesRef>> payloads = createPayloads(tokens, encoding);
import org.apache.lucene.analysis.payloads.IntegerEncoder;
import java.util.HashMap;
import org.apache.lucene.index.TermsEnum;  
        Map<String, List<BytesRef>> payloads = new HashMap<>();
            .setPayloads(true)  
        @Override  
            if (payload.length > 0) {
                    case 1: {  
                this.encoder = encoder;
                    }  
import org.apache.lucene.index.Terms;
 */  
                        + term  
                    @Override
import org.apache.lucene.analysis.payloads.FloatEncoder;
        return delimiter;
                    }
import org.apache.lucene.util.BytesRef;
 * under the License.  
        if (encoding == 1) {  
                        + docsAndPositions.getPayload().toString()
        if (encoding == 2) {  
            BytesRef payload = payloads.get(token).get(payloadCounter.get(token));
                        String delimiter = settings.get("delimiter");
                        break;
import java.util.ArrayList;
            .setSelectedFields();  
    }
import static org.hamcrest.Matchers.notNullValue;
            .put("index.analysis.filter.my_delimited_payload.type", "mock_payload_filter")
                }  
                    return true;  
            .put("index.analysis.filter.my_delimited_payload.delimiter", delimiter)
        int encoding = randomIntBetween(0, 2);
                        payloads.get(token).add(new BytesRef(payload));  
 * You may obtain a copy of the License at  
            .setSource(jsonBuilder().startObject().field("field", queryString).endObject())
import org.opensearch.OpenSearchException;  
            }
            assertThat(docsAndPositions.nextDoc(), equalTo(0));
                    isTokenOrWhitespace = true;  
    @Override
import org.opensearch.indices.analysis.AnalysisModule;
                }  
            private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);  
                if (docsAndPositions.getPayload() != null) {
                    case 1: {
    private String[] crateRandomTokens() {  
                    payAtt.setPayload(null);
            .setOffsets(true)
        client().admin().indices().prepareRefresh().get();
 * Unless required by applicable law or agreed to in writing,
                            return true;
            .startObject("field")
                        + curPayloads.get(k).toString();
                    }
                                payload = payload.replace(payload.charAt(c), 'w');  
            List<BytesRef> curPayloads = payloads.get(term);
        Map<String, Integer> payloadCounter = new HashMap<>();
            }
                    }
package org.opensearch.action.termvectors;
                }
 * SPDX-License-Identifier: Apache-2.0
import java.util.Map;
        for (int i = 0; i < numTokensWithDuplicates; i++) {
            .endObject()  
                            encoder = new FloatEncoder();
            delimiter = randomUnicodeOfLength(1);  
        assertThat(fields.size(), equalTo(1));
                        return new MockPayloadTokenFilter(tokenStream, delimiter.charAt(0), encoder);
 * The OpenSearch Contributors require contributions made to  
            return Collections.singletonList(
import static org.hamcrest.Matchers.nullValue;  
                        return "mock_payload_filter";  
                    // we have not seen the delimiter
            @Override
            return Collections.singletonMap("mock_payload_filter", (indexSettings, environment, name, settings) -> {
import java.util.Collection;  
            .endObject()
                        throw new OpenSearchException("unsupported encoding type");  
        while (isTokenOrWhitespace) {
        }  
                        break;
        String resultString = "";
 *
            }
        String encodingString = "";
        Terms terms = fields.terms("field");
            } else {  
        Fields fields = response.getFields();  
        // Based on DelimitedPayloadTokenFilter:  
                            termAtt.setLength(i); // simply set a new length  
                        }
import org.opensearch.index.analysis.TokenFilterFactory;
                return new TokenFilterFactory() {  
        assertThat("doc id 1 doesn't exists but should", response.isExists(), equalTo(true));
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
                    @Override  
                }  
        }
                PreConfiguredTokenizer.singleton("mock-whitespace", () -> new MockTokenizer(MockTokenizer.WHITESPACE, false))
import org.apache.lucene.analysis.TokenFilter;  
        String[] tokens = { "the", "quick", "brown", "fox" };
        String[] finalTokens = new String[numTokensWithDuplicates];  
                    case 2: {
    }
        }
                        }
    }
    private Map<String, List<BytesRef>> createPayloads(String[] tokens, int encoding) {
                        payloads.get(token).add(new BytesRef(PayloadHelper.encodeFloat(theFloat)));
            finalTokens[i] = tokens[randomIntBetween(0, tokens.length - 1)];
                    return false;
            public boolean incrementToken() throws IOException {
                    }  
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
                    }
                } else {  
    // Delimited payload token filter was moved to analysis-common module,  
            String term = iterator.term().utf8ToString();
            .field("type", "text")
        assertThat(iterator.next(), nullValue());  
                    public String name() {
    public void testRandomPayloadWithDelimitedPayloadTokenFilter() throws IOException {
                        } else if (settings.get("encoding").equals("identity")) {
        TermVectorsResponse response = resp.execute().actionGet();
                        break;
import org.opensearch.plugins.AnalysisPlugin;  
            .field("analyzer", "payload_test")
                        if (buffer[i] == delimiter) {
        String delimiter = createRandomDelimiter(tokens);
 * Modifications Copyright OpenSearch Contributors. See  
        TermVectorsRequestBuilder resp = client().prepareTermVectors("test", Integer.toString(1))
        while (iterator.next() != null) {
 */
        public Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
        // create the mapping
public class GetTermVectorsTests extends OpenSearchSingleNodeTestCase {
                    case 0: {
import org.opensearch.core.xcontent.XContentBuilder;
                        + " has payload \n"
                        if (settings.get("encoding").equals("float")) {
                docsAndPositions.nextPosition();  
                this.delimiter = delimiter;  
        if (encoding == 0) {  
 *  
            encodingString = "float";
    // Solution for now is copy what delimited payload token filter does in this test.
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;
                };
        XContentBuilder mapping = jsonBuilder().startObject()
            assertThat(term, curPayloads, notNullValue());  
    public static class MockPayloadAnalyzerPlugin extends Plugin implements AnalysisPlugin {
        return finalTokens;
 * compatible open source license.
                    final int length = termAtt.length();
            .put("index.analysis.filter.my_delimited_payload.encoding", encodingString)  
import org.apache.lucene.analysis.tokenattributes.PayloadAttribute;
                            encoder = new IntegerEncoder();
                    }  
            .setPositions(true)
                if (token.contains(delimiter)) {
            MockPayloadTokenFilter(TokenStream input, char delimiter, PayloadEncoder encoder) {
        final class MockPayloadTokenFilter extends TokenFilter {
            }  
import org.apache.lucene.analysis.payloads.IdentityEncoder;  
                            if (Character.isWhitespace(payload.charAt(c))) {
    // Unfortunately MockPayloadAnalyzer couldn't be used here as it misses functionality.  
                        throw new OpenSearchException("unsupported encoding type");
            }  
            .actionGet();  
 *
                        break;  
                        break;  
        client().prepareIndex("test")
        for (String token : tokens) {  
            .setId(Integer.toString(1))  
                        for (int c = 0; c < payload.length(); c++) {
            payloads.computeIfAbsent(token, k -> new ArrayList<>());
 * Licensed to Elasticsearch under one or more contributor  
        int numTokensWithDuplicates = randomIntBetween(3, 15);
                    default: {
            } else {
        }
                        payloads.get(token).add(new BytesRef(PayloadHelper.encodeInt(randomInt())));
import static org.hamcrest.Matchers.equalTo;
        }
                    case 0: {
import org.opensearch.plugins.Plugin;
import org.opensearch.index.analysis.PreConfiguredTokenizer;  
            encodingString = "int";
                    String infoString = "\nterm: "
            private final char delimiter;
                    String infoString = "\nterm: " + term + " has no payload but should have payload \n" + curPayloads.get(k).toString();
        // create the test document  
                        + "\n but should have payload \n"  
                resultString = resultString + delimiter;  
        boolean isTokenOrWhitespace = true;  
 * software distributed under the License is distributed on an
        }
            .startObject("properties")  
                super(input);
import org.apache.lucene.index.Fields;  
                    case 2: {
                        PayloadEncoder encoder = null;  
                switch (encoding) {
            encodingString = "identity";
                if (input.incrementToken()) {  
                        float theFloat = randomFloat();  
/*
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
            isTokenOrWhitespace = false;
                        resultString = resultString + Float.toString(PayloadHelper.decodeFloat(payload.bytes, payload.offset));  
    }  
                        resultString = resultString + payload.utf8ToString();
            resultString = resultString + token;  
                    public TokenStream create(TokenStream tokenStream) {
            }
        return Collections.singleton(MockPayloadAnalyzerPlugin.class);  
 * the Apache License, Version 2.0 (the "License"); you may
        Settings setting = Settings.builder()
                payloadCounter.put(token, payloadCounter.get(token) + 1);
            private final PayloadAttribute payAtt = addAttribute(PayloadAttribute.class);
                switch (encoding) {
        createIndex("test", setting, mapping);  
import org.opensearch.common.settings.Settings;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        } else if (settings.get("encoding").equals("int")) {  
            if (Character.isWhitespace(delimiter.charAt(0))) {  
        }  
/*
        }
import org.apache.lucene.analysis.TokenStream;
            .putList("index.analysis.analyzer.payload_test.filter", "my_delimited_payload")
                            }
            for (int k = 0; k < docsAndPositions.freq(); k++) {
            .execute()
            .field("term_vector", "with_positions_offsets_payloads")  
                }
            .build();
    private String createString(String[] tokens, Map<String, List<BytesRef>> payloads, int encoding, char delimiter) {  
        for (String token : tokens) {  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
                    final char[] buffer = termAtt.buffer();
        String[] tokens = crateRandomTokens();  
 * KIND, either express or implied.  See the License for the
                    }
import org.apache.lucene.analysis.payloads.PayloadHelper;  
                    default: {  
        }
    }
            assertNotNull(docsAndPositions);
        }
            private final PayloadEncoder encoder;
            resultString = resultString + " ";
import java.util.Collections;
import org.apache.lucene.analysis.payloads.PayloadEncoder;
            .endObject();
}
            }
            }
