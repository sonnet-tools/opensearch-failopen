            @Override  
import org.opensearch.index.analysis.IndexAnalyzers;
import org.opensearch.indices.analysis.AnalysisModule;  
 * SPDX-License-Identifier: Apache-2.0
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.script.ScriptService;  
}  
 * KIND, either express or implied.  See the License for the
            assertNotNull(analyzer);  
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString()).build();
        @SuppressWarnings("unchecked")
            public boolean execute(Token token) {
import org.opensearch.Version;
    public void testSimpleFilter() throws IOException {  
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
            public <FactoryType> FactoryType compile(Script script, ScriptContext<FactoryType> context) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .put("index.analysis.filter.f.type", "predicate_token_filter")
        AnalysisModule module = new AnalysisModule(TestEnvironment.newEnvironment(settings), Collections.singletonList(plugin));
 * The OpenSearch Contributors require contributions made to  
            assertAnalyzesTo(analyzer, "Oh what a wonderful thing to be", new String[] { "Oh", "what", "to", "be" });
 * ownership. Elasticsearch licenses this file to you under  
        };  
            .putList("index.analysis.analyzer.myAnalyzer.filter", "f")
import java.io.IOException;
 * specific language governing permissions and limitations
        plugin.createComponents(null, null, null, null, scriptService, null, null, null, null, null, null);  
import org.opensearch.env.Environment;
        IndexAnalyzers analyzers = module.getAnalysisRegistry().build(idxSettings);  
        }
        AnalysisPredicateScript.Factory factory = () -> new AnalysisPredicateScript() {  
import org.opensearch.script.ScriptContext;
import org.opensearch.test.IndexSettingsModule;
        };
    }
 * license agreements. See the NOTICE file distributed with
/*  
import org.opensearch.index.IndexSettings;  
import org.opensearch.common.settings.Settings;  
                return token.getPosition() < 2 || token.getPosition() > 4;  
 *
                return (FactoryType) factory;
            .put("index.analysis.analyzer.myAnalyzer.type", "custom")  
 * compatible open source license.
import org.opensearch.index.analysis.NamedAnalyzer;
/*  
 * You may obtain a copy of the License at  
 *  
 * Licensed to Elasticsearch under one or more contributor  
                assertEquals(new Script("my_script"), script);  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
import java.util.Collections;
                assertEquals(context, AnalysisPredicateScript.CONTEXT);
 */  
            .put("index.analysis.analyzer.myAnalyzer.tokenizer", "standard")
        CommonAnalysisModulePlugin plugin = new CommonAnalysisModulePlugin();
package org.opensearch.analysis.common;
            .build();  
import org.opensearch.cluster.metadata.IndexMetadata;
            }
public class PredicateTokenScriptFilterTests extends OpenSearchTokenStreamTestCase {
 * GitHub history for details.
 * under the License.  
 *
        Settings indexSettings = Settings.builder()
 */  
            @Override
import org.opensearch.env.TestEnvironment;
            }
        try (NamedAnalyzer analyzer = analyzers.get("myAnalyzer")) {
import org.opensearch.script.Script;
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", indexSettings);
 * Unless required by applicable law or agreed to in writing,
        ScriptService scriptService = new ScriptService(indexSettings, Collections.emptyMap(), Collections.emptyMap()) {
/*
 * this work for additional information regarding copyright
 */
            .put("index.analysis.filter.f.script.source", "my_script")
import org.opensearch.test.OpenSearchTokenStreamTestCase;
