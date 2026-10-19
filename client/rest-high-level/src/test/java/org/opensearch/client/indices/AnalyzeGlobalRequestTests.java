    }  
                    .addCharFilter(charFilterConfig)  
 * You may obtain a copy of the License at  
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
                    .build("some text", "some more text");  
                return AnalyzeRequest.buildCustomAnalyzer("my_tokenizer")  
            case 2:  
    protected AnalyzeAction.Request doParseToServerInstance(XContentParser parser) throws IOException {  
    static {
 *  
 * KIND, either express or implied.  See the License for the
        return AnalyzeAction.Request.fromXContent(parser, null);
        }
 * Unless required by applicable law or agreed to in writing,
 *
 * Modifications Copyright OpenSearch Contributors. See
        switch (option) {
    @Override
 * this work for additional information regarding copyright
                    .addTokenFilter("my_token_filter")
    }  
package org.opensearch.client.indices;
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
        throw new IllegalStateException("nextInt(3) has returned a value greater than 2");
import java.util.HashMap;
        int option = random().nextInt(3);
                    .addCharFilter(charFilterConfig)
        charFilterConfig.put("type", "html_strip");  
 * compatible open source license.
import java.io.IOException;
 */  
 * The OpenSearch Contributors require contributions made to  
    private static final Map<String, Object> charFilterConfig = new HashMap<>();
public class AnalyzeGlobalRequestTests extends AnalyzeRequestTests {
    }
            case 1:
    @Override
/*  
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
 *
    }
    static {
                    .addTokenFilter("my_token_filter")  
/*
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
                    .addCharFilter("my_char_filter")
 *    http://www.apache.org/licenses/LICENSE-2.0
                return AnalyzeRequest.withGlobalAnalyzer("my_analyzer", "some text", "some more text");
 */
 * this file be licensed under the Apache-2.0 license or a
    protected AnalyzeRequest createClientTestInstance() {  
    private static final Map<String, Object> tokenFilterConfig = new HashMap<>();  
                    .build("some text", "some more text");
import org.opensearch.core.xcontent.XContentParser;
 */  
            case 0:  
import org.opensearch.action.admin.indices.analyze.AnalyzeAction;
                    .addTokenFilter(tokenFilterConfig)
                    .addTokenFilter(tokenFilterConfig)
                    .addCharFilter("my_char_filter")
}  
 * Licensed to Elasticsearch under one or more contributor  
/*  
import java.util.Map;  
                return AnalyzeRequest.buildCustomNormalizer()
        tokenFilterConfig.put("type", "synonym");
