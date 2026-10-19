 * under the License.  
/*
            settings,
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
 */  
            new Token("b", 0, 2, 3),
        );
            new Token("a", 1, 0, 1),
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.settings.Settings;  
        CannedTokenStream cts = new CannedTokenStream(
    }
import org.opensearch.test.OpenSearchTokenStreamTestCase;
 *  
            new CommonAnalysisModulePlugin()
/*  
import static org.hamcrest.Matchers.instanceOf;  
import org.opensearch.index.analysis.AnalysisTestsHelper;
 * GitHub history for details.
            new Token("d", 1, 4, 5)  
public class RemoveDuplicatesFilterFactoryTests extends OpenSearchTokenStreamTestCase {
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("removedups");
 * license agreements. See the NOTICE file distributed with
            new Token("b", 1, 2, 3),  
 * this work for additional information regarding copyright
    public void testRemoveDuplicatesFilter() throws IOException {
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
package org.opensearch.analysis.common;
import org.opensearch.test.OpenSearchTestCase;
import org.apache.lucene.tests.analysis.Token;
 * You may obtain a copy of the License at  
            .put("index.analysis.filter.removedups.type", "remove_duplicates")
 *
            new Token("c", 0, 2, 3),
/*  
        assertTokenStreamContents(tokenFilter.create(cts), new String[] { "a", "b", "c", "d" }, new int[] { 1, 1, 0, 1 });  
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(  
 */
import org.apache.lucene.tests.analysis.CannedTokenStream;
 * software distributed under the License is distributed on an
}  
        Settings settings = Settings.builder()
 *
 * the Apache License, Version 2.0 (the "License"); you may
            .build();
 * Modifications Copyright OpenSearch Contributors. See
        );  
 */  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.analysis.TokenFilterFactory;  
import org.opensearch.env.Environment;
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
        assertThat(tokenFilter, instanceOf(RemoveDuplicatesTokenFilterFactory.class));
 * compatible open source license.
