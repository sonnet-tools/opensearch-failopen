 * Modifications Copyright OpenSearch Contributors. See
            fail("Expected IllegalArgumentException");
 * license agreements. See the NOTICE file distributed with
 */  
                "pattern_capture",
            );  
import org.opensearch.index.analysis.IndexAnalyzers;  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
 * under the License.  
    }
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
        NamedAnalyzer analyzer1 = indexAnalyzers.get("single");
        assertTokenStreamContents(analyzer2.tokenStream("test", "abc123def"), new String[] { "abc123def", "abc", "123", "def" });
    public void testNoPatterns() {
public class PatternCaptureTokenFilterTests extends OpenSearchTokenStreamTestCase {
        IndexAnalyzers indexAnalyzers = createTestAnalysis(idxSettings, settings, new CommonAnalysisModulePlugin()).indexAnalyzers;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
import org.opensearch.cluster.metadata.IndexMetadata;
 *  
import org.opensearch.test.IndexSettingsModule;
 * this file be licensed under the Apache-2.0 license or a
            new PatternCaptureGroupTokenFilterFactory(
/*  
            .build();  
 * compatible open source license.
        NamedAnalyzer analyzer2 = indexAnalyzers.get("multi");
        try {  
package org.opensearch.analysis.common;
 *
        }
}
        String json = "/org/opensearch/analysis/common/pattern_capture.json";
import static org.hamcrest.Matchers.containsString;  
 * this work for additional information regarding copyright
        assertTokenStreamContents(analyzer1.tokenStream("test", "foobarbaz"), new String[] { "foobarbaz", "foobar", "foo" });  
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.Version;
    public void testPatternCaptureTokenFilter() throws Exception {  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.IndexSettings;
        NamedAnalyzer analyzer3 = indexAnalyzers.get("preserve");  
 */  
import org.opensearch.test.OpenSearchTokenStreamTestCase;  
        Settings settings = Settings.builder()
        assertTokenStreamContents(analyzer3.tokenStream("test", "foobarbaz"), new String[] { "foobar", "foo" });
 *
 * GitHub history for details.
                Settings.builder().put("pattern", "foobar").build()
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())  
            .loadFromStream(json, getClass().getResourceAsStream(json), false)
import org.opensearch.index.analysis.NamedAnalyzer;
            assertThat(e.getMessage(), containsString("required setting 'patterns' is missing"));  
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);
import org.opensearch.common.settings.Settings;  
    }  
 * ownership. Elasticsearch licenses this file to you under  
import static org.opensearch.test.OpenSearchTestCase.createTestAnalysis;
 * KIND, either express or implied.  See the License for the
        } catch (IllegalArgumentException e) {
 */
 * You may obtain a copy of the License at  
/*
                IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
                null,  
import org.opensearch.env.Environment;
