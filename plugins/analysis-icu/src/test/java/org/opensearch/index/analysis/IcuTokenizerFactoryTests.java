import java.nio.file.Path;  
/*
        InputStream keywords = IcuTokenizerFactoryTests.class.getResourceAsStream("KeywordTokenizer.rbbi");  
 * not use this file except in compliance with the License.
        ICUTokenizer tokenizer = (ICUTokenizer) tokenizerFactory.create();
    public void testIcuCustomizeRuleFile() throws IOException {
        Settings settings = Settings.builder()
 * The OpenSearch Contributors require contributions made to  
                "This",
import java.io.IOException;
import org.apache.lucene.analysis.icu.segmentation.ICUTokenizer;
 * compatible open source license.
}
    }  
                "not",
        Path home = createTempDir();  
        // test the tokenizer with two rule files
        TestAnalysis analysis = createTestAnalysis();  
import java.nio.file.Files;
                "one",
package org.opensearch.index.analysis;
 * license agreements. See the NOTICE file distributed with
import java.io.StringReader;
 */  
 * Modifications Copyright OpenSearch Contributors. See
        );
            tokenizer,  
 *    http://www.apache.org/licenses/LICENSE-2.0
        Files.copy(latin, config.resolve("Latin-dont-break-on-hyphens.rbbi"));
                "one",
        Reader reader = new StringReader("向日葵, one-two");  
 * GitHub history for details.
            .build();
 * KIND, either express or implied.  See the License for the
 *  
            .loadFromStream(json, IcuTokenizerFactoryTests.class.getResourceAsStream(json), false)  
        assertTokenStreamContents(
        InputStream latin = IcuTokenizerFactoryTests.class.getResourceAsStream("Latin-dont-break-on-hyphens.rbbi");
 */  
 * Unless required by applicable law or agreed to in writing,
    }  
                "One-two",
import java.io.Reader;  
        tokenizer.setReader(reader);
        Settings nodeSettings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), home).build();  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                "ish" }
        tokenizer.setReader(reader);
 * this file be licensed under the Apache-2.0 license or a
 */
        TestAnalysis analysis = createTestAnalysis();
                "one",  
        Reader reader = new StringReader("One-two punch.  Brang-, not brung-it.  This one--not that one--is the right one, -ish.");
 * ownership. Elasticsearch licenses this file to you under  
        Path config = home.resolve("config");
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
import org.opensearch.test.OpenSearchTestCase;
    }  
    private static TestAnalysis createTestAnalysis() throws IOException {
            new String[] { "Some", "English", "Немного русский.  ", "ข้อความภาษาไทยเล็ก ๆ น้อย ๆ  ", "More", "English" }
 *
 * the Apache License, Version 2.0 (the "License"); you may
        ICUTokenizer tokenizer = (ICUTokenizer) tokenizerFactory.create();
            tokenizer,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // test the tokenizer with single rule file
                "right",
    }  
import org.opensearch.core.index.Index;
import org.opensearch.cluster.metadata.IndexMetadata;  
import org.opensearch.Version;
    public void testMultipleIcuCustomizeRuleFiles() throws IOException {
    public void testSimpleIcuTokenizer() throws IOException {  
        assertTokenStreamContents(
import org.opensearch.common.settings.Settings;
                "not",  
        TestAnalysis analysis = createTestAnalysis();  
        Files.copy(keywords, config.resolve("KeywordTokenizer.rbbi"));  
        TokenizerFactory tokenizerFactory = analysis.tokenizer.get("icu_tokenizer");  
        ICUTokenizer tokenizer = (ICUTokenizer) tokenizerFactory.create();
        );
        tokenizer.setReader(reader);
                "punch",  
        Files.createDirectory(config);
 *
 * this work for additional information regarding copyright
            new String[] {
/*  
                "that",
                "the",
import static org.apache.lucene.tests.analysis.BaseTokenStreamTestCase.assertTokenStreamContents;
 * SPDX-License-Identifier: Apache-2.0
                "Brang",
import java.io.InputStream;
import org.opensearch.plugin.analysis.icu.AnalysisICUPlugin;
        return createTestAnalysis(new Index("test", "_na_"), nodeSettings, settings, new AnalysisICUPlugin());
        TokenizerFactory tokenizerFactory = analysis.tokenizer.get("user_rule_tokenizer");  
        String json = "/org/opensearch/index/analysis/icu_analysis.json";  
import org.opensearch.env.Environment;  
/*  
                "brung-it",  
        StringReader reader = new StringReader("Some English.  Немного русский.  ข้อความภาษาไทยเล็ก ๆ น้อย ๆ  More English.");
                "is",  
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
        TokenizerFactory tokenizerFactory = analysis.tokenizer.get("multi_rule_tokenizer");  
 * under the License.  
public class IcuTokenizerFactoryTests extends OpenSearchTestCase {
        assertTokenStreamContents(tokenizer, new String[] { "向日葵", "one", "two" });
