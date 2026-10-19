import org.opensearch.index.analysis.AnalysisTestsHelper;
        tokenizer.setReader(new StringReader(source));
 *
 * Unless required by applicable law or agreed to in writing,
            createTempDir(),  
            RESOURCE,  
 * this work for additional information regarding copyright
            .put("index.analysis.filter.broken_keep_filter.keep_words_path", "does/not/exists.txt")  
 * not use this file except in compliance with the License.
            fail("expected IAE");
/*  
            // test our none existing setup is picked up  
/*
 * The OpenSearch Contributors require contributions made to  
        try {
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        assertThat(tokenFilter, instanceOf(KeepWordFilterFactory.class));
            fail("expected IAE");
/*  
            fail("expected an exception indicating that you can't use [keep_words_path] with [keep_words] ");
 *    http://www.apache.org/licenses/LICENSE-2.0
            new CommonAnalysisModulePlugin()
import org.junit.Assert;  
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
    public void testLoadOverConfiguredSettings() {
 * Licensed to Elasticsearch under one or more contributor  
        } catch (IllegalArgumentException e) {} catch (IOException e) {  
}
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected, new int[] { 1, 2 });  
        Assert.assertNull(tokenFilter);
import org.apache.lucene.analysis.Tokenizer;
        assertThat(tokenFilter, instanceOf(KeepWordFilterFactory.class));
            RESOURCE,  
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromClassPath(
    public void testCaseInsensitiveMapping() throws IOException {  
        String source = "hello small world";
            // test our none existing setup is picked up  
            .build();
 * You may obtain a copy of the License at  
import org.opensearch.test.OpenSearchTokenStreamTestCase;
    public void testCaseSensitiveMapping() throws IOException {  
            new CommonAnalysisModulePlugin()
    public void testLoadWithoutSettings() throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
        }
package org.opensearch.analysis.common;
 */  
            AnalysisTestsHelper.createTestAnalysisFromSettings(settings, new CommonAnalysisModulePlugin());
import org.opensearch.test.OpenSearchTestCase;
            createTempDir(),
            .put("index.analysis.filter.broken_keep_filter.type", "keep")
        );  
        );
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected, new int[] { 1 });  
public class KeepFilterFactoryTests extends OpenSearchTokenStreamTestCase {
        Tokenizer tokenizer = new WhitespaceTokenizer();
    }
            .build();
 * Modifications Copyright OpenSearch Contributors. See
            .put("index.analysis.filter.non_broken_keep_filter.type", "keep")
 * this file be licensed under the Apache-2.0 license or a
            .put("index.analysis.filter.non_broken_keep_filter.keep_words_path", "does/not/exists.txt")  
 * GitHub history for details.
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromClassPath(
        );
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
import java.io.StringReader;  
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("keep");
 */  
 * KIND, either express or implied.  See the License for the
    }
            AnalysisTestsHelper.createTestAnalysisFromSettings(settings, new CommonAnalysisModulePlugin());
    public void testKeepWordsPathSettings() {
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_keep_filter");  
        try {  
        Settings settings = Settings.builder()  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            new CommonAnalysisModulePlugin()
    }  
        Tokenizer tokenizer = new WhitespaceTokenizer();
            AnalysisTestsHelper.createTestAnalysisFromSettings(settings, new CommonAnalysisModulePlugin());
            RESOURCE,
import static org.hamcrest.Matchers.instanceOf;
            fail("expected an exception due to non existent keep_words_path");
 *  
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_case_sensitive_keep_filter");  
 * SPDX-License-Identifier: Apache-2.0
        } catch (IllegalArgumentException e) {} catch (IOException e) {  
import org.opensearch.common.settings.Settings;  
        }
            fail("expected IAE");
import org.opensearch.env.Environment;
        String[] expected = new String[] { "hello", "world" };  
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
    }
    private static final String RESOURCE = "/org/opensearch/analysis/common/keep_analysis.json";
        String[] expected = new String[] { "Hello" };  
        }
 *
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
 * under the License.  
        } catch (IllegalArgumentException e) {} catch (IOException e) {  
            .put("index.analysis.filter.broken_keep_filter.keep_words", "[\"Hello\", \"worlD\"]")
        tokenizer.setReader(new StringReader(source));
import org.opensearch.index.analysis.TokenFilterFactory;  
            createTempDir(),
        String source = "Hello small world";
    }  
        settings = Settings.builder().put(settings).putList("index.analysis.filter.non_broken_keep_filter.keep_words", "test").build();
            Assert.fail("path and array are configured");
import java.io.IOException;
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromClassPath(
        Settings settings = Settings.builder()  
        try {
 * specific language governing permissions and limitations
 */
