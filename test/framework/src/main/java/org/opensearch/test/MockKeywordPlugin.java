    }
 * GitHub history for details.
import org.opensearch.plugins.Plugin;
 * Some tests rely on the keyword tokenizer, but this tokenizer isn't part of lucene-core and therefor not available
 */
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Map;  
/*
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
            (indexSettings, environment, name, settings) -> TokenizerFactory.newFactory(
/*  
 * compatible open source license.
 *
 */
 *  
    public Map<String, AnalysisModule.AnalysisProvider<TokenizerFactory>> getTokenizers() {
        return singletonMap(  
 *
 * KIND, either express or implied.  See the License for the
    @Override
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
import static java.util.Collections.singletonMap;
 * You may obtain a copy of the License at  
import org.apache.lucene.tests.analysis.MockTokenizer;  
 */  
            )
 * keyword tokenizer, but if the keyword tokenizer isn't available then constructing normalizers will fail.  
package org.opensearch.test;
 * Modifications Copyright OpenSearch Contributors. See  
 * the Apache License, Version 2.0 (the "License"); you may
 * Most tests that need this test plugin use normalizers. When normalizers are constructed they try to resolve the
                name,  
/*
 * specific language governing permissions and limitations
 *     http://www.apache.org/licenses/LICENSE-2.0
 * in some modules. What this test plugin does, is use the mock tokenizer and advertise that as the keyword tokenizer.  
import org.opensearch.index.analysis.TokenizerFactory;
            "keyword",
import org.opensearch.plugins.AnalysisPlugin;  
 * software distributed under the License is distributed on an
/**
        );  
}
                () -> new MockTokenizer(MockTokenizer.KEYWORD, false)
 * <p>
import org.opensearch.indices.analysis.AnalysisModule;
public class MockKeywordPlugin extends Plugin implements AnalysisPlugin {
