/*
                .build(),
 * compatible open source license.
     * Correct offset order when doing both parts and concatenation: PowerShot is a synonym of Power
 *  
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
                .put("index.analysis.filter.my_word_delimiter.generate_word_parts", "true")
import org.opensearch.index.analysis.TokenFilterFactory;
 * The OpenSearch Contributors require contributions made to  
        String source = "PowerShot";  
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
        );
 * not use this file except in compliance with the License.
 */  
    }
/*
 * Modifications Copyright OpenSearch Contributors. See  
 * ownership. Elasticsearch licenses this file to you under  
                .put("index.analysis.filter.my_word_delimiter.catenate_words", "true")  
 * license agreements. See the NOTICE file distributed with
    public WordDelimiterTokenFilterFactoryTests() {  
import org.opensearch.env.Environment;  
 *
        Tokenizer tokenizer = new WhitespaceTokenizer();
    /**
 */
                .put("index.analysis.filter.my_word_delimiter.type", type)
            Settings.builder()  
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_word_delimiter");
 * this file be licensed under the Apache-2.0 license or a
/*  
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
    public void testPartsAndCatenate() throws IOException {
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
public class WordDelimiterTokenFilterFactoryTests extends BaseWordDelimiterTokenFilterFactoryTestCase {
 * GitHub history for details.
import org.opensearch.common.settings.Settings;
 */
import org.opensearch.index.analysis.AnalysisTestsHelper;
import org.opensearch.test.OpenSearchTestCase;  
 * this work for additional information regarding copyright
 * under the License.  
}  
        String[] expected = new String[] { "Power", "PowerShot", "Shot" };
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected);
     */  
 *
            new CommonAnalysisModulePlugin()  
import org.apache.lucene.analysis.Tokenizer;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.StringReader;  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;
        super("word_delimiter");
package org.opensearch.analysis.common;
    }
 * SPDX-License-Identifier: Apache-2.0
        tokenizer.setReader(new StringReader(source));  
 * Unless required by applicable law or agreed to in writing,
