                assertInstances(serverResponse.tokenfilters()[i], clientResponse.tokenfilters()[i]);
                assertEqualTokens(serverTestInstance.getTokens().get(0), clientInstance.getTokens().get(0));  
        } else {  
/*
    @Override
                assertEqualTokens(serverTokens.getTokens()[i], clientTokens.getTokens()[i]);
import java.util.Arrays;
            AnalyzeAction.DetailAnalyzeResponse dar = new AnalyzeAction.DetailAnalyzeResponse(
        assertInstances(serverResponse.analyzer(), clientResponse.analyzer());
                    new AnalyzeAction.CharFilteredText("my_charfilter", new String[] { "one two" }) };  
    private static void assertInstances(AnalyzeAction.CharFilteredText serverText, DetailAnalyzeResponse.CharFilteredText clientText) {  
 * compatible open source license.
            assertEquals(serverResponse.charfilters().length, clientResponse.charfilters().length);
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
            AnalyzeAction.CharFilteredText[] charfilters = null;
        assertInstances(serverResponse.tokenizer(), clientResponse.tokenizer());
}
        if (randomBoolean()) {
        assertEquals(serverToken.getEndOffset(), clientToken.getEndOffset());
        assertEquals(serverToken.getAttributes(), clientToken.getAttributes());  
    }
        }
        return new AnalyzeAction.Response(Arrays.asList(tokens), null);
                    new AnalyzeAction.AnalyzeTokenList("my_tokenfilter_2", tokens) };
            assertNull(clientResponse.charfilters());  
 * You may obtain a copy of the License at  
        }  
                charfilters = new AnalyzeAction.CharFilteredText[] {
        AnalyzeAction.AnalyzeToken[] tokens = new AnalyzeAction.AnalyzeToken[tokenCount];  
            assertNotNull(clientInstance.detail());
            assertEquals(serverTokens.getName(), clientTokens.getName());
        }  
        assertEquals(serverText.getName(), clientText.getName());
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.client.indices;
                charfilters,
        } else {  
    }
                tokenfilters = new AnalyzeAction.AnalyzeTokenList[] {  
import org.opensearch.client.AbstractResponseTestCase;
            assertEquals(serverTestInstance.getTokens().size(), clientInstance.getTokens().size());
                assertInstances(serverResponse.charfilters()[i], clientResponse.charfilters()[i]);
        assertEquals(serverToken.getPosition(), clientToken.getPosition());
            }
            AnalyzeAction.AnalyzeTokenList[] tokenfilters = null;  
        }
            }  
    @Override
        } else {
            for (int i = 0; i < serverTokens.getTokens().length; i++) {  
 * software distributed under the License is distributed on an
        assertEquals(serverToken.getTerm(), clientToken.getTerm());  
            assertNull(clientTokens);
        assertEquals(serverToken.getPositionLength(), clientToken.getPositionLength());
 * The OpenSearch Contributors require contributions made to  
            assertNull(clientResponse.tokenfilters());
            for (int i = 0; i < serverResponse.tokenfilters().length; i++) {
    private static void assertInstances(AnalyzeAction.DetailAnalyzeResponse serverResponse, DetailAnalyzeResponse clientResponse) {  
    }  
 * this work for additional information regarding copyright
            assertInstances(serverTestInstance.detail(), clientInstance.detail());
 * Licensed to Elasticsearch under one or more contributor  
            if (randomBoolean()) {
import org.opensearch.common.xcontent.XContentType;  
    private static void assertInstances(AnalyzeAction.AnalyzeTokenList serverTokens, DetailAnalyzeResponse.AnalyzeTokenList clientTokens) {  
            }
    protected void assertInstances(AnalyzeAction.Response serverTestInstance, AnalyzeResponse clientInstance) {
            assertEquals(serverResponse.tokenfilters().length, clientResponse.tokenfilters().length);  
                    new AnalyzeAction.AnalyzeTokenList("my_tokenfilter_1", tokens),
    }  
        if (serverResponse.charfilters() == null) {
    }
 * GitHub history for details.
    protected AnalyzeResponse doParseToClientInstance(XContentParser parser) throws IOException {  
 *
 * ownership. Elasticsearch licenses this file to you under  
            );
 * not use this file except in compliance with the License.
    }  
/*  
 *
            for (int i = 0; i < serverTestInstance.getTokens().size(); i++) {
            }  
        assertEquals(serverToken.getStartOffset(), clientToken.getStartOffset());  
public class AnalyzeResponseTests extends AbstractResponseTestCase<AnalyzeAction.Response, AnalyzeResponse> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                tokenfilters
 *  
import org.opensearch.action.admin.indices.analyze.AnalyzeAction;
 * KIND, either express or implied.  See the License for the
            if (randomBoolean()) {
 */  
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
import org.opensearch.test.RandomObjects;
                new AnalyzeAction.AnalyzeTokenList("my_tokenizer", tokens),  
            assertEquals(serverTokens.getTokens().length, clientTokens.getTokens().length);
 */
        if (serverResponse.tokenfilters() == null) {  
        if (serverTestInstance.detail() != null) {  
            }
            tokens[i] = RandomObjects.randomToken(random());
        for (int i = 0; i < tokenCount; i++) {
 * under the License.  
 * license agreements. See the NOTICE file distributed with
    @Override  
import org.opensearch.core.xcontent.XContentParser;
        assertEquals(serverToken.getType(), clientToken.getType());
        int tokenCount = randomIntBetween(1, 30);
            }
        if (serverTokens == null) {
            for (int i = 0; i < serverResponse.charfilters().length; i++) {  
            return new AnalyzeAction.Response(null, dar);  
import java.io.IOException;
 * the Apache License, Version 2.0 (the "License"); you may
    }
    protected AnalyzeAction.Response createServerTestInstance(XContentType xContentType) {
/*  
        }
        return AnalyzeResponse.fromXContent(parser);
        }  
 * Unless required by applicable law or agreed to in writing,
        } else {
        assertArrayEquals(serverText.getTexts(), clientText.getTexts());
    private static void assertEqualTokens(AnalyzeAction.AnalyzeToken serverToken, AnalyzeResponse.AnalyzeToken clientToken) {
