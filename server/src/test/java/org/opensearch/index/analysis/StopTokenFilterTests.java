 * KIND, either express or implied.  See the License for the
        TokenStream create = tokenFilter.create(tokenizer);
            AnalysisTestsHelper.createTestAnalysisFromSettings(settings);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(tokenFilter, instanceOf(StopTokenFilterFactory.class));
        Tokenizer tokenizer = new WhitespaceTokenizer();  
        assertThat(tokenFilter, instanceOf(StopTokenFilterFactory.class));
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
        builder.put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString());  
import java.io.StringReader;
 */  
 *  
 */
 * this file be licensed under the Apache-2.0 license or a
        Builder builder = Settings.builder()  
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(builder.build());  
/*  
        }
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
 *
 * SPDX-License-Identifier: Apache-2.0
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        builder.put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString());
 *
        Settings settings = builder.build();
import org.opensearch.common.settings.Settings;
        Settings settings = Settings.builder()
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;  
            builder.put("index.analysis.filter.my_stop.version", "5.0");
            .build();
            fail("Expected IllegalArgumentException");
    public void testPositionIncrementSetting() throws IOException {
            assertThat(e.getMessage(), containsString("enable_position_increments is not supported anymore"));  
        try {
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
        if (random().nextBoolean()) {  
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_stop");
import org.opensearch.test.OpenSearchTestCase;
import org.apache.lucene.analysis.StopFilter;
import static org.hamcrest.Matchers.instanceOf;
            .put("index.analysis.filter.my_stop.remove_trailing", false)  
 * Modifications Copyright OpenSearch Contributors. See
    }
import org.opensearch.test.OpenSearchTokenStreamTestCase;
        assertThat(create, instanceOf(SuggestStopFilter.class));  
public class StopTokenFilterTests extends OpenSearchTokenStreamTestCase {
    }
            .put("index.analysis.filter.my_stop.type", "stop")
import org.apache.lucene.util.Version;  
            builder.put("index.analysis.filter.my_stop.version", Version.LATEST);
        Builder builder = Settings.builder().put("index.analysis.filter.my_stop.type", "stop");
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
}
    public void testThatSuggestStopFilterWorks() throws Exception {  
        }
    public void testCorrectPositionIncrementSetting() throws IOException {
        TokenStream create = tokenFilter.create(tokenizer);
        assertThat(create, instanceOf(StopFilter.class));  
            .put("index.analysis.filter.my_stop.type", "stop")
        tokenizer.setReader(new StringReader("foo an"));
import java.io.IOException;
/*
 * compatible open source license.
        if (random().nextBoolean()) {  
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
        }
 * software distributed under the License is distributed on an
        Tokenizer tokenizer = new WhitespaceTokenizer();  
import org.opensearch.common.settings.Settings.Builder;
            .put("index.analysis.filter.my_stop.enable_position_increments", false);
import static org.hamcrest.Matchers.containsString;
        } catch (IllegalArgumentException e) {
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
 * this work for additional information regarding copyright
        } else {
import org.opensearch.env.Environment;  
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings);  
package org.opensearch.index.analysis;
/*  
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_stop");
import org.apache.lucene.search.suggest.analyzing.SuggestStopFilter;
        tokenizer.setReader(new StringReader("foo bar"));
 */  
 * ownership. Elasticsearch licenses this file to you under  
            // don't specify  
