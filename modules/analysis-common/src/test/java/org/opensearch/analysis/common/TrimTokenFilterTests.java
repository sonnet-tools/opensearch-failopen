 * ownership. Elasticsearch licenses this file to you under  
 *  
        assertEquals(new BytesRef("bar"), normalizer.normalize("foo", "  bar  "));  
import org.opensearch.index.analysis.NamedAnalyzer;
package org.opensearch.analysis.common;
 * KIND, either express or implied.  See the License for the
        Settings settings = Settings.builder()
            new CommonAnalysisModulePlugin()
}  
/*
        assertEquals("my_normalizer", normalizer.name());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .putList("index.analysis.normalizer.my_normalizer.filter", "trim")  
        NamedAnalyzer normalizer = analysis.indexAnalyzers.getNormalizer("my_normalizer");
import org.opensearch.common.settings.Settings;
 * this file be licensed under the Apache-2.0 license or a
            settings,
public class TrimTokenFilterTests extends OpenSearchTokenStreamTestCase {
 * the Apache License, Version 2.0 (the "License"); you may
import java.io.IOException;  
/*  
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(  
/*  
    }
            .build();
 * license agreements. See the NOTICE file distributed with
 */
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
import org.opensearch.index.analysis.AnalysisTestsHelper;
        );  
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
 *
import org.opensearch.env.Environment;  
 * specific language governing permissions and limitations
 *
 * Licensed to Elasticsearch under one or more contributor  
    public void testNormalizer() throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
        assertNull(analysis.indexAnalyzers.get("my_normalizer"));
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.util.BytesRef;
 */  
        assertTokenStreamContents(normalizer.tokenStream("foo", "  bar  "), new String[] { "bar" });
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertNotNull(normalizer);  
import org.opensearch.test.OpenSearchTokenStreamTestCase;
 */  
 * this work for additional information regarding copyright
import org.opensearch.test.OpenSearchTestCase;  
