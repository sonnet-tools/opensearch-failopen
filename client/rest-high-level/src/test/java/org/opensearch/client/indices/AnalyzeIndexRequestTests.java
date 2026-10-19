                    .addTokenFilter(tokenFilterConfig)
        int option = random().nextInt(5);
                    .build("some text", "some more text");  
        charFilterConfig.put("type", "html_strip");  
 * the Apache License, Version 2.0 (the "License"); you may
            case 0:  
    private static final Map<String, Object> tokenFilterConfig = new HashMap<>();  
    private static final Map<String, Object> charFilterConfig = new HashMap<>();
package org.opensearch.client.indices;
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
 */
                    .addCharFilter(charFilterConfig)
 * compatible open source license.
        tokenFilterConfig.put("type", "synonym");
                    .addTokenFilter("my_token_filter")
                    .addTokenFilter("my_token_filter")
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
            case 2:
 * GitHub history for details.
                    .addCharFilter("my_char_filter")
}
 * this work for additional information regarding copyright
                    .build("some text", "some more text");
 */  
 */  
                return AnalyzeRequest.withField("index", "field", "some text", "some more text");
        throw new IllegalStateException("nextInt(5) has returned a value greater than 4");  
 * specific language governing permissions and limitations
/*  
/*
 * Unless required by applicable law or agreed to in writing,
                return AnalyzeRequest.buildCustomNormalizer("index")
import java.io.IOException;
import java.util.HashMap;
 * this file be licensed under the Apache-2.0 license or a
                    .addTokenFilter(tokenFilterConfig)  
    @Override
                    .addCharFilter(charFilterConfig)  
        switch (option) {
                    .addCharFilter("my_char_filter")  
            case 4:
                return AnalyzeRequest.withNormalizer("index", "my_normalizer", "text", "more text");
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
    protected AnalyzeAction.Request doParseToServerInstance(XContentParser parser) throws IOException {
            case 1:
 * ownership. Elasticsearch licenses this file to you under  
    static {
                return AnalyzeRequest.withIndexAnalyzer("index", "my_analyzer", "some text", "some more text");  
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
    }  
    protected AnalyzeRequest createClientTestInstance() {  
 *
    }
                return AnalyzeRequest.buildCustomAnalyzer("index", "my_tokenizer")
    static {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return AnalyzeAction.Request.fromXContent(parser, "index");
import java.util.Map;  
import org.opensearch.action.admin.indices.analyze.AnalyzeAction;
    }
 * under the License.  
            case 3:  
 * not use this file except in compliance with the License.
import org.opensearch.core.xcontent.XContentParser;
        }
 *  
    @Override  
    }  
 * Modifications Copyright OpenSearch Contributors. See
/*  
public class AnalyzeIndexRequestTests extends AnalyzeRequestTests {
 *
