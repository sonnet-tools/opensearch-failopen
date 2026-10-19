    public void testPreConfiguredShingleFilterDisableGraphAttribute() throws Exception {  
 * software distributed under the License is distributed on an
import org.opensearch.index.analysis.AnalysisTestsHelper;  
 *
 *  
public class ShingleTokenFilterTests extends OpenSearchTokenStreamTestCase {
                .build(),
            new CommonAnalysisModulePlugin()  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.analysis.TokenFilterFactory;
import org.opensearch.common.settings.Settings;
 * KIND, either express or implied.  See the License for the
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
import org.apache.lucene.analysis.core.WhitespaceTokenizer;  
        tokenizer.setReader(new StringReader("this is a test"));
 * this file be licensed under the Apache-2.0 license or a
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.env.Environment;
 * under the License.  
import org.opensearch.lucene.analysis.miscellaneous.DisableGraphAttribute;
            Settings.builder()
 * not use this file except in compliance with the License.
                .put("index.analysis.filter.my_ascii_folding.type", "asciifolding")
 */  
 * the Apache License, Version 2.0 (the "License"); you may
        );
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.test.OpenSearchTokenStreamTestCase;
 * GitHub history for details.
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 * compatible open source license.
package org.opensearch.analysis.common;
 * You may obtain a copy of the License at  
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("shingle");
/*  
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.analysis.TokenStream;
 *
/*  
        Tokenizer tokenizer = new WhitespaceTokenizer();  
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
 */  
import org.apache.lucene.analysis.Tokenizer;
        TokenStream tokenStream = tokenFilter.create(tokenizer);
        assertTrue(tokenStream.hasAttribute(DisableGraphAttribute.class));  
}
 */
    }
import java.io.StringReader;  
