 * Modifications Copyright OpenSearch Contributors. See
                    instance.detail().tokenfilters()
 *  
            }  
    }  
            List<AnalyzeToken> extendedList = new ArrayList<>(instance.getTokens());
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.action.admin.indices.analyze.AnalyzeAction.AnalyzeToken;
/*
            AnalyzeAction.CharFilteredText[] charfilters = null;
 * SPDX-License-Identifier: Apache-2.0
        AnalyzeAction.CharFilteredText[] charfilters = null;
        if (instance.getTokens() != null) {  
                charfilters,
        AnalyzeAction.AnalyzeTokenList[] tokenfilters = { tokenfiltersItem };  
                "tokenfilters"  
            List<Map<String, Object>> nullTokens = (List<Map<String, Object>>) tokenfiltersValue.get(0).get("tokens");
public class AnalyzeResponseTests extends AbstractWireSerializingTestCase<AnalyzeAction.Response> {
 * specific language governing permissions and limitations
                tokenfilters = new AnalyzeAction.AnalyzeTokenList[] {
import org.opensearch.common.xcontent.XContentHelper;
                new AnalyzeAction.DetailAnalyzeResponse(
 *
    @Override
        }  
 * compatible open source license.
                tokenfilters  
 * not use this file except in compliance with the License.
    }
        }
}
import java.util.ArrayList;  
import org.opensearch.common.xcontent.json.JsonXContent;  
 * this file be licensed under the Apache-2.0 license or a
            );
 * GitHub history for details.
        AnalyzeAction.DetailAnalyzeResponse detail = new AnalyzeAction.DetailAnalyzeResponse(charfilters, tokenizer, tokenfilters);
        String name = "test_tokens_null";
import org.opensearch.core.xcontent.ToXContent;  
import org.opensearch.test.AbstractWireSerializingTestCase;
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
    @SuppressWarnings("unchecked")  
 * this work for additional information regarding copyright
 */  
package org.opensearch.action.admin.indices.analyze;
    protected AnalyzeAction.Response mutateInstance(AnalyzeAction.Response instance) throws IOException {
            );
    /**
 *
import org.opensearch.core.common.io.stream.Writeable.Reader;
            assertThat(nullTokens.size(), equalTo(0));
            Map<String, Object> converted = XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2();
                    instance.detail().charfilters(),  
        for (int i = 0; i < tokenCount; i++) {  
        return AnalyzeAction.Response::new;
                null,
 * software distributed under the License is distributed on an
        } else {
    }
            }
import java.util.List;
        AnalyzeAction.AnalyzeToken[] tokens = new AnalyzeAction.AnalyzeToken[tokenCount];
                    new AnalyzeAction.CharFilteredText("my_charfilter", new String[] { "one two" }) };
    }  
            return new AnalyzeAction.Response(  
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
import java.util.Map;  
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
            if (randomBoolean()) {
                    new AnalyzeAction.AnalyzeTokenList("my_tokenfilter_2", tokens) };
        AnalyzeAction.AnalyzeTokenList tokenfiltersItem = new AnalyzeAction.AnalyzeTokenList(name, tokens);
        if (randomBoolean()) {  
 * ownership. Elasticsearch licenses this file to you under  
            return new AnalyzeAction.Response(null, dar);
        AnalyzeAction.AnalyzeTokenList tokenizer = null;  
import java.io.IOException;
    public void testConstructorArgs() {  
        try (XContentBuilder builder = JsonXContent.contentBuilder()) {
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.xcontent.XContentBuilder;
    }
/*  
 * You may obtain a copy of the License at  
    @Override
     */  
            assertThat(name, equalTo(nameValue));
            );
            if (randomBoolean()) {  
 * the Apache License, Version 2.0 (the "License"); you may
                new AnalyzeAction.AnalyzeTokenList("my_tokenizer", tokens),
                )  
        assertEquals("Neither token nor detail set on AnalysisAction.Response", ex.getMessage());
            AnalyzeAction.AnalyzeTokenList[] tokenfilters = null;
 */  
     * Either add a token to the token list or change the details token list name
        return new AnalyzeAction.Response(Arrays.asList(tokens), null);
                charfilters = new AnalyzeAction.CharFilteredText[] {
 */
    protected Reader<AnalyzeAction.Response> instanceReader() {  
 * under the License.  
import java.util.Arrays;
            List<Map<String, Object>> tokenfiltersValue = (List<Map<String, Object>>) ((Map<String, Object>) converted.get("detail")).get(
        }
    protected AnalyzeAction.Response createTestInstance() {  
import static org.hamcrest.Matchers.equalTo;
            response.toXContent(builder, ToXContent.EMPTY_PARAMS);  
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> new AnalyzeAction.Response(null, null));
            extendedList.add(RandomObjects.randomToken(random()));
        AnalyzeAction.AnalyzeToken[] tokens = null;
    public void testNullResponseToXContent() throws IOException {
                    new AnalyzeAction.AnalyzeTokenList("my_other_tokenizer", tokens),
            tokens[i] = RandomObjects.randomToken(random());
        }  
        int tokenCount = randomIntBetween(0, 30);
            String nameValue = (String) tokenfiltersValue.get(0).get("name");  
import org.opensearch.test.RandomObjects;  
import org.opensearch.core.common.bytes.BytesReference;
            AnalyzeAction.DetailAnalyzeResponse dar = new AnalyzeAction.DetailAnalyzeResponse(  
            return new AnalyzeAction.Response(extendedList, null);  
            AnalyzeToken[] tokens = instance.detail().tokenizer().getTokens();
                    new AnalyzeAction.AnalyzeTokenList("my_tokenfilter_1", tokens),  
        AnalyzeAction.Response response = new AnalyzeAction.Response(null, detail);
