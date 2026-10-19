        );
import org.opensearch.common.settings.Settings;
        String input = "안녕은하철도999극장판2.1981년8월8일.일본개봉작1999년재더빙video판";  
 */
 * software distributed under the License is distributed on an
 * GitHub history for details.
    public void testMixedAlphabetTokenization() throws IOException {
import org.opensearch.Version;  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();  
 */  
import static org.hamcrest.Matchers.containsString;  
    }
        Analyzer analyzer = new IcuAnalyzerProvider(idxSettings, null, "icu", settings).get();
        assertAnalyzesTo(analyzer, input, new String[] { "경승지", "산악", "협곡", "해협", "곶", "심연", "폭포", "호수", "급류" });
 * the Apache License, Version 2.0 (the "License"); you may
    }
    public void testBadSettings() {  
        String input = "경승지·산악·협곡·해협·곶·심연·폭포·호수·급류";
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.IndexSettings;  
import org.apache.lucene.tests.analysis.BaseTokenStreamTestCase;
import org.opensearch.cluster.metadata.IndexMetadata;
        assertAnalyzesTo(
 *
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
            new String[] { "안녕은하철도", "999", "극장판", "2.1981", "년", "8", "월", "8", "일", "일본개봉작", "1999", "년재더빙", "video", "판" }
 * KIND, either express or implied.  See the License for the
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).put("mode", "wrong").build();
 */  
        assertAnalyzesTo(analyzer, input, new String[] { "1", "2", "3", "1", "2", "3", "1/4", "1/3", "3/8", "1", "2", "3", "1", "2", "3" });  
 * compatible open source license.
        Analyzer analyzer = plugin.getAnalyzers().get("icu_analyzer").get(idxSettings, null, "icu", settings).get();  
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();  
}
 *  
import org.apache.lucene.analysis.Analyzer;
public class IcuAnalyzerTests extends BaseTokenStreamTestCase {
/*  
            new IcuAnalyzerProvider(idxSettings, null, "icu", settings);  
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
        });
 * specific language governing permissions and limitations
        Analyzer analyzer = new IcuAnalyzerProvider(idxSettings, null, "icu", settings).get();  
        assertThat(e.getMessage(), containsString("Unknown mode [wrong] in analyzer [icu], expected one of [compose, decompose]"));  
package org.opensearch.index.analysis;
            input,  
    }
 * this file be licensed under the Apache-2.0 license or a
 *
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
 * Licensed to Elasticsearch under one or more contributor  
    public void testUnicodeNumericCharacters() throws IOException {
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);  
        String input = "① ② ③ ⑴ ⑵ ⑶ ¼ ⅓ ⅜ ¹ ² ³ ₁ ₂ ₃";  
            analyzer,
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
import org.opensearch.test.IndexSettingsModule;
    public void testMiddleDots() throws IOException {  
import org.opensearch.plugin.analysis.icu.AnalysisICUPlugin;
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * this work for additional information regarding copyright
        AnalysisICUPlugin plugin = new AnalysisICUPlugin();
 * not use this file except in compliance with the License.
import java.io.IOException;
 * under the License.  
/*  
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);
/*
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);
