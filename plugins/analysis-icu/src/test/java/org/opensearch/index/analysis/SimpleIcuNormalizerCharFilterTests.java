/*  
        Settings settings = Settings.builder().put("index.analysis.char_filter.myNormalizerChar.type", "icu_normalizer").build();  
 */  
 */  
public class SimpleIcuNormalizerCharFilterTests extends OpenSearchTestCase {
        CharFilterFactory charFilterFactory = analysis.charFilter.get("myNormalizerChar");
package org.opensearch.index.analysis;
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
        StringBuilder output = new StringBuilder();  
 * not use this file except in compliance with the License.
        String expectedOutput = normalizer.normalize(input);  
        TestAnalysis analysis = createTestAnalysis(new Index("test", "_na_"), settings, new AnalysisICUPlugin());
 * license agreements. See the NOTICE file distributed with
import com.ibm.icu.text.Normalizer2;
            output.append(tempBuff, 0, length);
/*
}  
            .put("index.analysis.char_filter.myNormalizerChar.name", "nfkc")
            if (length == -1) break;  
import org.opensearch.test.OpenSearchTestCase;  
 * the Apache License, Version 2.0 (the "License"); you may
    public void testDefaultSetting() throws Exception {
    }
/**
        Settings settings = Settings.builder()
        char[] tempBuff = new char[10];
 * You may obtain a copy of the License at  
        CharFilter inputReader = (CharFilter) charFilterFactory.create(new StringReader(input));
 * GitHub history for details.
import java.io.StringReader;
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
 * Test
        char[] tempBuff = new char[10];
    }
        while (true) {
 * Modifications Copyright OpenSearch Contributors. See
        TestAnalysis analysis = createTestAnalysis(new Index("test", "_na_"), settings, new AnalysisICUPlugin());
    public void testNameAndModeSetting() throws Exception {
            .put("index.analysis.char_filter.myNormalizerChar.mode", "decompose")
 * compatible open source license.
            .put("index.analysis.char_filter.myNormalizerChar.type", "icu_normalizer")  
        assertEquals(expectedOutput, output.toString());
        CharFilter inputReader = (CharFilter) charFilterFactory.create(new StringReader(input));
 * Unless required by applicable law or agreed to in writing,
 */
 * SPDX-License-Identifier: Apache-2.0
            assertEquals(output.toString(), normalizer.normalize(input.substring(0, inputReader.correctOffset(output.length()))));
        StringBuilder output = new StringBuilder();  
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
/*  
import org.opensearch.common.settings.Settings;  
 * specific language governing permissions and limitations
        String input = "ʰ㌰゙5℃№㈱㌘，バッファーの正規化のテスト．㋐㋑㋒㋓㋔ｶｷｸｹｺｻﾞｼﾞｽﾞｾﾞｿﾞg̈각/각நிเกषिchkʷक्षि";
 */  
            .build();  
import org.opensearch.core.index.Index;
        assertEquals(expectedOutput, output.toString());
 * Licensed to Elasticsearch under one or more contributor  
            output.append(tempBuff, 0, length);
        String input = "ʰ㌰゙5℃№㈱㌘，バッファーの正規化のテスト．㋐㋑㋒㋓㋔ｶｷｸｹｺｻﾞｼﾞｽﾞｾﾞｿﾞg̈각/각நிเกषिchkʷक्षि";
            if (length == -1) break;  
        Normalizer2 normalizer = Normalizer2.getInstance(null, "nfkc_cf", Normalizer2.Mode.COMPOSE);
import org.apache.lucene.analysis.CharFilter;
        while (true) {
import org.opensearch.plugin.analysis.icu.AnalysisICUPlugin;
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(output.toString(), normalizer.normalize(input.substring(0, inputReader.correctOffset(output.length()))));
        }  
            int length = inputReader.read(tempBuff);
            int length = inputReader.read(tempBuff);
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
        CharFilterFactory charFilterFactory = analysis.charFilter.get("myNormalizerChar");
 * software distributed under the License is distributed on an
 *
 *  
        String expectedOutput = normalizer.normalize(input);  
        Normalizer2 normalizer = Normalizer2.getInstance(null, "nfkc", Normalizer2.Mode.DECOMPOSE);
