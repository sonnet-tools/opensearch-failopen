            .put("index.analysis.analyzer.my_analyzer.tokenizer", tokenizer)  
        final Settings indexSettings = newAnalysisSettingsBuilder().put(IndexSettings.MAX_NGRAM_DIFF_SETTING.getKey(), 2).build();
            settings
                assertAnalyzesTo(analyzer, "test", new String[] { "t", "te" });
import org.opensearch.test.IndexSettingsModule;  
                    VersionUtils.randomVersionBetween(random(), Version.V_2_0_0, VersionUtils.getPreviousVersion(Version.V_3_0_0)),
import java.util.Arrays;  
                IndexAnalyzers indexAnalyzers = buildAnalyzers(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.settings.Settings;
        }
public class EdgeNGramTokenizerTests extends OpenSearchTokenStreamTestCase {  
 *  
package org.opensearch.analysis.common;
    }  
    private IndexAnalyzers buildAnalyzers(Version version, String tokenizer) throws IOException {
 * under the License.  
            name,  
import org.opensearch.index.IndexSettings;
            IndexSettingsModule.newIndexSettings(index, indexSettings),
/*  
                assertNotNull(analyzer);
 * GitHub history for details.
        }
            .put(IndexMetadata.SETTING_VERSION_CREATED, version)
 * Unless required by applicable law or agreed to in writing,
            try (IndexAnalyzers indexAnalyzers = buildAnalyzers(Version.CURRENT, "edge_ngram")) {  
            null,
 * compatible open source license.
import java.io.IOException;
                Arrays.stream(e.getSuppressed())  
                () -> buildAnalyzers(VersionUtils.randomVersionBetween(random(), Version.V_3_0_0, Version.CURRENT), "edgeNGram")
 * You may obtain a copy of the License at  
 *
import org.opensearch.index.analysis.IndexAnalyzers;  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.metadata.IndexMetadata;  
            final IllegalArgumentException e = expectThrows(
        Tokenizer tokenizer = new EdgeNGramTokenizerFactory(  
                NamedAnalyzer analyzer = indexAnalyzers.get("my_analyzer");
        final Settings settings = newAnalysisSettingsBuilder().put("min_gram", 2)
 */
                "expected deprecation message in suppressed causes",
import org.opensearch.test.VersionUtils;
        {
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.index.Index;
        final Index index = new Index("test", "_na_");  
 * SPDX-License-Identifier: Apache-2.0
            try (  
                    .map(org.opensearch.ExceptionsHelper::unwrapCause)
import org.opensearch.env.TestEnvironment;
        ).create();
import java.io.StringReader;
        }
            .put("custom_token_chars", "_-")
        tokenizer.setReader(new StringReader("Abc -gh _jk =lm"));  
 * this work for additional information regarding copyright
    public void testPreConfiguredTokenizer() throws IOException {
/*
            .putList("token_chars", "letter", "custom")  
import org.opensearch.env.Environment;  
            assertTrue(
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
        // Check deprecated name as well, needs version before 3.0 because throws IAE after that
                NamedAnalyzer analyzer = indexAnalyzers.get("my_analyzer");  
 * specific language governing permissions and limitations
            ) {
 * software distributed under the License is distributed on an
        return new AnalysisModule(TestEnvironment.newEnvironment(settings), Collections.singletonList(new CommonAnalysisModulePlugin()))  
        {
 *
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.analysis.NamedAnalyzer;
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", indexSettings);
import org.apache.lucene.analysis.Tokenizer;
        Settings indexSettings = Settings.builder()
        {
        assertTokenStreamContents(tokenizer, new String[] { "Ab", "Abc", "-g", "-gh", "_j", "_jk", "lm" });
            .build(idxSettings);
                assertNotNull(analyzer);
 *    http://www.apache.org/licenses/LICENSE-2.0
                    "edgeNGram"  
                assertAnalyzesTo(analyzer, "test", new String[] { "t", "te" });  
            );
                    .anyMatch(msg -> msg.contains("The [edgeNGram] tokenizer name was deprecated pre 1.0."))  
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString()).build();  
            .put("max_gram", 3)
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
import org.opensearch.indices.analysis.AnalysisModule;
        // Afterwards, we return ngrams of length 1 and 2, to match the default factory settings
                IllegalArgumentException.class,  
            }  
import java.util.Collections;
            .build();
 */  
            .getAnalysisRegistry()
import org.opensearch.Version;
    public void testCustomTokenChars() throws IOException {
 */  
                    .map(Throwable::getMessage)
            .build();
            );
import org.opensearch.test.OpenSearchTokenStreamTestCase;
    }  
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
}
    }
        // Check IAE from 3.0 onward  
            }
                )
        final String name = "engr";
/*  
