import org.opensearch.plugin.analysis.icu.AnalysisICUPlugin;  
 */  
 * The OpenSearch Contributors require contributions made to  
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("icu_normalizer");
 * Modifications Copyright OpenSearch Contributors. See
public class SimpleIcuAnalysisTests extends OpenSearchTestCase {
 * software distributed under the License is distributed on an
import org.opensearch.common.settings.Settings;
import org.opensearch.core.index.Index;
 * SPDX-License-Identifier: Apache-2.0
/*  
        assertThat(filterFactory, instanceOf(IcuNormalizerTokenFilterFactory.class));  
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.instanceOf;
/*
 */
 * KIND, either express or implied.  See the License for the
/*  
 * compatible open source license.
 *  
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.test.OpenSearchTestCase;
        assertThat(filterFactory, instanceOf(IcuCollationTokenFilterFactory.class));  
import java.io.IOException;  
        filterFactory = analysis.tokenFilter.get("icu_transform");
        assertThat(charFilterFactory, instanceOf(IcuNormalizerCharFilterFactory.class));  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
package org.opensearch.index.analysis;
 * Licensed to Elasticsearch under one or more contributor  
        CharFilterFactory charFilterFactory = analysis.charFilter.get("icu_normalizer");
 * under the License.  
        assertThat(filterFactory, instanceOf(IcuFoldingTokenFilterFactory.class));  
        TokenizerFactory tokenizerFactory = analysis.tokenizer.get("icu_tokenizer");
 *
    }
        filterFactory = analysis.tokenFilter.get("icu_collation");
        assertThat(filterFactory, instanceOf(IcuTransformTokenFilterFactory.class));  
        filterFactory = analysis.tokenFilter.get("icu_folding");
    public void testDefaultsIcuAnalysis() throws IOException {
}
        assertThat(tokenizerFactory, instanceOf(IcuTokenizerFactory.class));  
 *
        TestAnalysis analysis = createTestAnalysis(new Index("test", "_na_"), Settings.EMPTY, new AnalysisICUPlugin());  
