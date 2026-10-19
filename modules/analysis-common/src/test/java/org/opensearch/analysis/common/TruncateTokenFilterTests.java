            .put("index.analysis.filter.truncate.type", "truncate")  
 * Modifications Copyright OpenSearch Contributors. See
        Settings settings = Settings.builder()
 * specific language governing permissions and limitations
 *
            new CommonAnalysisModulePlugin()
    }
        assertEquals(new BytesRef("ddd"), normalizer.normalize("foo", "dddd"));
            .put("index.analysis.analyzer.my_analyzer.type", "custom")
            settings,  
            .build();
        assertTokenStreamContents(analyzer.tokenStream("foo", "a bb ccc dddd"), new String[] { "a", "bb", "ccc", "ddd" });  
        assertNotNull(analyzer);
 */  
        NamedAnalyzer analyzer = analysis.indexAnalyzers.get("my_analyzer");  
 * ownership. Elasticsearch licenses this file to you under  
/*
        );
            settings,  
 * license agreements. See the NOTICE file distributed with
}  
        assertEquals("my_normalizer", normalizer.name());  
    public void testNormalizer() throws IOException {  
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.analysis.AnalysisTestsHelper;
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
            .put("index.analysis.filter.truncate.type", "truncate")
            .put("index.analysis.filter.truncate.length", 3)  
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
        assertEquals(new BytesRef("a"), normalizer.normalize("foo", "a"));
            .put("index.analysis.analyzer.my_analyzer.tokenizer", "whitespace")  
package org.opensearch.analysis.common;
        assertNotNull(normalizer);
public class TruncateTokenFilterTests extends OpenSearchTokenStreamTestCase {
 *
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
/*  
        Settings settings = Settings.builder()
import org.opensearch.common.settings.Settings;
import java.io.IOException;  
import org.opensearch.env.Environment;  
 * under the License.  
 */
            .putList("index.analysis.normalizer.my_normalizer.filter", "truncate")
 */  
 * software distributed under the License is distributed on an
        assertEquals(new BytesRef("bb"), normalizer.normalize("foo", "bb"));
            new CommonAnalysisModulePlugin()
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );
 * GitHub history for details.
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
import org.opensearch.test.OpenSearchTokenStreamTestCase;
            .putList("index.analysis.analyzer.my_analyzer.filter", "truncate")
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
        assertEquals(new BytesRef("ccc"), normalizer.normalize("foo", "ccc"));  
import org.opensearch.test.OpenSearchTestCase;  
import org.apache.lucene.util.BytesRef;
            .put("index.analysis.filter.truncate.length", 3)
    }
            .putList("index.analysis.normalizer.my_normalizer.filter", "truncate")
    public void testFilter() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.analysis.NamedAnalyzer;
 * this work for additional information regarding copyright
            .put("index.analysis.normalizer.my_normalizer.type", "custom")
            .build();
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
        assertNull(analysis.indexAnalyzers.get("my_normalizer"));  
 *  
/*  
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
        NamedAnalyzer normalizer = analysis.indexAnalyzers.getNormalizer("my_normalizer");
