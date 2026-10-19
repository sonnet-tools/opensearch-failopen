        request.analyzer(analyzer);
package org.opensearch.action.admin.indices.analyze;
     * to be set.
    }  
    /**
    public AnalyzeRequestBuilder addCharFilter(Map<String, ?> charFilter) {  
    public AnalyzeRequestBuilder setField(String field) {  
    public AnalyzeRequestBuilder setNormalizer(String normalizer) {
 */
     * Sets attributes that will include results
    AnalyzeAction.Response,
        request.text(texts);  
    /**  
    /**
    }  
        request.addTokenFilter(tokenFilter);
public class AnalyzeRequestBuilder extends SingleShardOperationRequestBuilder<  
    /**
    }
@PublicApi(since = "1.0.0")
    public AnalyzeRequestBuilder setAttributes(String... attributes) {  
        return this;
        request.addCharFilter(charFilter);
        return this;
     * analyzer.
    /**
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
        request.explain(explain);
        return this;
     * analyzer.
/*  
 * specific language governing permissions and limitations
     */
 */
/**  
    }
import java.util.Map;
     * Add a name of token filter that will be used on top of a tokenizer provided.
        request.normalizer(normalizer);
    }
 * this file be licensed under the Apache-2.0 license or a
        super(client, action, new AnalyzeAction.Request(index).text(text));
    /**
import org.opensearch.common.annotation.PublicApi;
    }  
        request.addTokenFilter(tokenFilter);  
        request.attributes(attributes);
    }  
    /**
 * Transport request builder for analyzing text
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.support.single.shard.SingleShardOperationRequestBuilder;  
     * Add a name of char filter that will be used before the tokenizer.  
     * Sets texts to analyze  
     */
 * Licensed to Elasticsearch under one or more contributor  
     */  
     */
 *
 * Modifications Copyright OpenSearch Contributors. See  
    AnalyzeAction.Request,
        request.tokenizer(tokenizer);
     */  
 * You may obtain a copy of the License at  
        return this;
    public AnalyzeRequestBuilder setTokenizer(Map<String, ?> tokenizer) {  
    }  
     * Instead of setting the analyzer, sets the tokenizer as name that will be used as part of a custom  
     * Sets the field that its analyzer will be used to analyze the text. Note, requires an index  
    public AnalyzeRequestBuilder(OpenSearchClient client, AnalyzeAction action, String index, String... text) {  
    }
    /**
     * Sets the analyzer name to use in order to analyze the text.
     */  
     * Add char filter setting that will be used on top of a tokenizer provided.
 *     http://www.apache.org/licenses/LICENSE-2.0
        request.field(field);
    public AnalyzeRequestBuilder addTokenFilter(Map<String, ?> tokenFilter) {
/*
import org.opensearch.transport.client.OpenSearchClient;
    /**
 * @opensearch.api  
        return this;
    /**
     * Add token filter setting that will be used on top of a tokenizer provided.  
     */
 * not use this file except in compliance with the License.
     * Sets explain
        return this;
    public AnalyzeRequestBuilder setText(String... texts) {
    /**
    }
     * Instead of setting the analyzer, sets the tokenizer using custom settings that will be used as part of a custom  
 * license agreements. See the NOTICE file distributed with
     */
 * SPDX-License-Identifier: Apache-2.0
    public AnalyzeRequestBuilder addCharFilter(String tokenFilter) {
     */
    }
 * software distributed under the License is distributed on an
    public AnalyzeRequestBuilder setAnalyzer(String analyzer) {  
 * GitHub history for details.
     */
 */
     */
        request.tokenizer(tokenizer);
        return this;
 *  
        super(client, action, new AnalyzeAction.Request());  
     *  
        return this;  
 */  
    }
    public AnalyzeRequestBuilder(OpenSearchClient client, AnalyzeAction action) {
 * ownership. Elasticsearch licenses this file to you under  
        return this;  
}  
    public AnalyzeRequestBuilder setExplain(boolean explain) {
    }
     * Instead of setting the analyzer and tokenizer, sets the normalizer as name
        return this;
        return this;
    AnalyzeRequestBuilder> {  
        return this;  
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
     * @param analyzer The analyzer name.
    public AnalyzeRequestBuilder addTokenFilter(String tokenFilter) {
     */
 * KIND, either express or implied.  See the License for the
        request.addCharFilter(tokenFilter);  
/*
    /**  
    }  
 * compatible open source license.
    public AnalyzeRequestBuilder setTokenizer(String tokenizer) {  
 * under the License.  
 *
