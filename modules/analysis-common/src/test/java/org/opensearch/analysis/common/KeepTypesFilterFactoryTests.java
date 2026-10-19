    }
 */  
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
 * compatible open source license.
        if (random().nextBoolean()) {
        String source = "Hello 123 world";
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            .putList(BASE_SETTING + "." + KeepTypesFilterFactory.KEEP_TYPES_KEY, new String[] { "<NUM>", "<SOMETHINGELSE>" });
            settingsBuilder.put(
            .put(BASE_SETTING + ".type", "keep_types")
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
            .put(BASE_SETTING + ".type", "keep_types")  
                KeepTypesFilterFactory.KeepTypesMode.INCLUDE
 * GitHub history for details.
        Settings settings = settingsBuilder.build();
            .put(BASE_SETTING + "." + KeepTypesFilterFactory.KEEP_TYPES_MODE_KEY, KeepTypesFilterFactory.KeepTypesMode.EXCLUDE)
            new CommonAnalysisModulePlugin()
import static org.hamcrest.Matchers.instanceOf;
 * The OpenSearch Contributors require contributions made to  
import java.io.StringReader;
 * KIND, either express or implied.  See the License for the
    }
            new CommonAnalysisModulePlugin()  
            );
 * under the License.  
        }  
        assertThat(tokenFilter, instanceOf(KeepTypesFilterFactory.class));  
        );  
package org.opensearch.analysis.common;
 * Unless required by applicable law or agreed to in writing,
 *
            .build();
 *  
import java.io.IOException;
        String[] expected = new String[] { "123" };  
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("keep_numbers");
                BASE_SETTING + "." + KeepTypesFilterFactory.KEEP_TYPES_MODE_KEY,  
public class KeepTypesFilterFactoryTests extends OpenSearchTokenStreamTestCase {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected, new int[] { 1, 2 });
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
        String source = "Hello 123 world";
import org.opensearch.index.analysis.TokenFilterFactory;  
            .put(BASE_SETTING + ".type", "keep_types")
/*
        );
 * license agreements. See the NOTICE file distributed with
            .build();  
            IllegalArgumentException.class,
    public void testKeepTypesInclude() throws IOException {
import org.opensearch.test.OpenSearchTokenStreamTestCase;
import org.opensearch.test.OpenSearchTestCase;
        Settings settings = Settings.builder()  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        IllegalArgumentException ex = expectThrows(  
/*  
        Tokenizer tokenizer = new StandardTokenizer();  
 */
        Tokenizer tokenizer = new StandardTokenizer();
        assertEquals("`keep_types` tokenfilter mode can only be [include] or [exclude] but was [bad_parameter].", ex.getMessage());
            settings,
import org.opensearch.env.Environment;
 * SPDX-License-Identifier: Apache-2.0
    }  
            settings,  
import org.opensearch.index.analysis.AnalysisTestsHelper;
        );
 * You may obtain a copy of the License at  
    private static final String BASE_SETTING = "index.analysis.filter.keep_numbers";
import org.apache.lucene.analysis.Tokenizer;
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("keep_numbers");  
        tokenizer.setReader(new StringReader(source));
import org.apache.lucene.analysis.standard.StandardTokenizer;
        assertThat(tokenFilter, instanceOf(KeepTypesFilterFactory.class));
    public void testKeepTypesException() throws IOException {
            .put(BASE_SETTING + "." + KeepTypesFilterFactory.KEEP_TYPES_MODE_KEY, "bad_parameter")
import org.opensearch.common.settings.Settings;  
    public void testKeepTypesExclude() throws IOException {  
 * software distributed under the License is distributed on an
        String[] expected = new String[] { "Hello", "world" };
            () -> AnalysisTestsHelper.createTestAnalysisFromSettings(settings, new CommonAnalysisModulePlugin())
 *
        Settings settings = Settings.builder()
        // either use default mode or set "include" mode explicitly  
        tokenizer.setReader(new StringReader(source));
 */  
 * the Apache License, Version 2.0 (the "License"); you may
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
            .putList(BASE_SETTING + "." + KeepTypesFilterFactory.KEEP_TYPES_KEY, new String[] { "<NUM>", "<SOMETHINGELSE>" })  
}  
 * this file be licensed under the Apache-2.0 license or a
            .putList(BASE_SETTING + "." + KeepTypesFilterFactory.KEEP_TYPES_KEY, new String[] { "<NUM>", "<SOMETHINGELSE>" })
/*  
 * ownership. Elasticsearch licenses this file to you under  
        Settings.Builder settingsBuilder = Settings.builder()
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected, new int[] { 2 });  
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
