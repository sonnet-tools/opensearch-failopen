import org.opensearch.common.settings.Settings;
import org.opensearch.plugin.analysis.smartcn.AnalysisSmartChinesePlugin;  
import java.io.IOException;
/*  
    public void testDefaultsIcuAnalysis() throws IOException {  
 * specific language governing permissions and limitations
}
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.test.OpenSearchTestCase;
 *  
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.index.analysis;
 * under the License.  
        TokenizerFactory tokenizerFactory = analysis.tokenizer.get("smartcn_tokenizer");
 * license agreements. See the NOTICE file distributed with
        MatcherAssert.assertThat(tokenizerFactory, instanceOf(SmartChineseTokenizerTokenizerFactory.class));  
 * software distributed under the License is distributed on an
 */  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.index.Index;
 */
 */  
import static org.hamcrest.Matchers.instanceOf;  
/*  
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * KIND, either express or implied.  See the License for the
import org.hamcrest.MatcherAssert;
 * Licensed to Elasticsearch under one or more contributor  
 *
 * You may obtain a copy of the License at  
/*
 * compatible open source license.
    }
 * not use this file except in compliance with the License.
public class SimpleSmartChineseAnalysisTests extends OpenSearchTestCase {
 * SPDX-License-Identifier: Apache-2.0
        final TestAnalysis analysis = createTestAnalysis(new Index("test", "_na_"), Settings.EMPTY, new AnalysisSmartChinesePlugin());
