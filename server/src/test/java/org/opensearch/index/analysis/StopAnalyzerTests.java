import org.opensearch.common.settings.Settings;  
        NamedAnalyzer analyzer1 = indexAnalyzers.get("analyzer1");  
            .build();  
/*
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
 * GitHub history for details.
}
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 *
import org.opensearch.Version;
        assertTokenStreamContents(analyzer1.tokenStream("test", "to be or not to be"), new String[0]);
 * this file be licensed under the Apache-2.0 license or a
        String json = "/org/opensearch/index/analysis/stop.json";
            .loadFromStream(json, getClass().getResourceAsStream(json), false)  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.env.Environment;
 */
        IndexAnalyzers indexAnalyzers = createTestAnalysis(idxSettings, settings).indexAnalyzers;
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
 */  
        NamedAnalyzer analyzer2 = indexAnalyzers.get("analyzer2");
import org.opensearch.test.OpenSearchTokenStreamTestCase;
 *
        Settings settings = Settings.builder()
 * compatible open source license.
import static org.opensearch.test.OpenSearchTestCase.createTestAnalysis;  
        assertTokenStreamContents(analyzer2.tokenStream("test", "to be or not to be"), new String[0]);  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
/*  
/*  
public class StopAnalyzerTests extends OpenSearchTokenStreamTestCase {
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
 *  
package org.opensearch.index.analysis;
import org.opensearch.index.IndexSettings;
import org.opensearch.test.IndexSettingsModule;  
    public void testDefaultsCompoundAnalysis() throws Exception {  
    }
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.metadata.IndexMetadata;
 * software distributed under the License is distributed on an
 */  
 * not use this file except in compliance with the License.
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);
 * license agreements. See the NOTICE file distributed with
