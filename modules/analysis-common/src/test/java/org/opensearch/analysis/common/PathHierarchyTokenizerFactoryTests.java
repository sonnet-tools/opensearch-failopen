            .put(IndexMetadata.SETTING_VERSION_CREATED, version)
 */
    public void testReverse() throws IOException {
        tokenizer.setReader(new StringReader("/one/two/three"));
            "path-hierarchy-tokenizer",
 * The OpenSearch Contributors require contributions made to
                    "PathHierarchy"
        tokenizer.setReader(new StringReader("one-two-three"));
        {
            IndexSettingsModule.newIndexSettings(index, indexSettings),
import org.opensearch.Version;
            assertEquals("replacement must be a one char value", e.getMessage());
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
 * compatible open source license.
        ).create();
        Settings settings = newAnalysisSettingsBuilder().put("skip", 2).build();
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString()).build();
            }
                // Similar testing approach has been used for deprecation of (Edge)NGrams tokenizers as well.
        final Index index = new Index("test", "_na_");
    }
        final Index index = new Index("test", "_na_");
        assertTokenStreamContents(tokenizer, new String[] { "/one/two/three", "one/two/three", "two/three", "three" });
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", indexSettings);
            "path-hierarchy-tokenizer",
    }
import org.opensearch.test.VersionUtils;
        tokenizer.setReader(new StringReader("one-two-three"));
                    settings
 */
            null,
        Settings settings = newAnalysisSettingsBuilder().put("delimiter", "-").build();
        final Settings indexSettings = newAnalysisSettingsBuilder().build();
                    null,
    }
import org.apache.lucene.analysis.Tokenizer;
import org.opensearch.indices.analysis.AnalysisModule;
            ) {
        final Index index = new Index("test", "_na_");
 * this work for additional information regarding copyright
                assertTokenStreamContents(analyzer.tokenStream("dummy", "/a/b/c"), new String[] { "/a", "/a/b", "/a/b/c" });
                    "path-hierarchy-tokenizer",
            assertEquals("delimiter must be a one char value", e.getMessage());
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
        final Settings indexSettings = newAnalysisSettingsBuilder().build();
                )
public class PathHierarchyTokenizerFactoryTests extends OpenSearchTokenStreamTestCase {
                IllegalArgumentException.class,
    }
            IllegalArgumentException e = expectThrows(
        Settings settings = newAnalysisSettingsBuilder().put("replacement", "-").build();
        assertTokenStreamContents(tokenizer, new String[] { "one-two-three" });
import org.opensearch.env.TestEnvironment;
    public void testSkip() throws IOException {
    public void testReplace() throws IOException {
package org.opensearch.analysis.common;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.IndexSettings;
    }
 * Modifications Copyright OpenSearch Contributors. See
        }
            Settings.EMPTY
 * specific language governing permissions and limitations
        Settings settings = newAnalysisSettingsBuilder().put("reverse", true).build();
            .put("index.analysis.analyzer.my_analyzer.tokenizer", tokenizer)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            "path-hierarchy-tokenizer",
 * You may obtain a copy of the License at
            settings
            settings
                    "path-hierarchy-tokenizer",
        Tokenizer tokenizer = new PathHierarchyTokenizerFactory(
import java.io.StringReader;
                ).create()
import org.opensearch.cluster.metadata.IndexMetadata;
                IllegalArgumentException.class,
        final Settings indexSettings = newAnalysisSettingsBuilder().build();
            IndexSettingsModule.newIndexSettings(index, indexSettings),
        }
        final Settings indexSettings = newAnalysisSettingsBuilder().build();
import org.opensearch.index.analysis.IndexAnalyzers;
        tokenizer.setReader(new StringReader("/one/two/three"));
 *
        }
        {
import org.opensearch.test.IndexSettingsModule;
        Tokenizer tokenizer = new PathHierarchyTokenizerFactory(
            );
    public void testPreConfiguredTokenizer() throws IOException {
        Settings indexSettings = Settings.builder()
        final Index index = new Index("test", "_na_");
        final Index index = new Index("test", "_na_");
                () -> new PathHierarchyTokenizerFactory(
        ).create();
 * Unless required by applicable law or agreed to in writing,
            Settings settings = newAnalysisSettingsBuilder().put("replacement", replacement).build();
 * software distributed under the License is distributed on an
    }
            null,
 *
    }
            IndexSettingsModule.newIndexSettings(index, indexSettings),
        Tokenizer tokenizer = new PathHierarchyTokenizerFactory(
        assertTokenStreamContents(tokenizer, new String[] { "one", "one-two", "one-two-three" });
                    null,
            settings
            String delimiter = RandomPicks.randomFrom(random(), new String[] { "--", "" });
 * license agreements. See the NOTICE file distributed with
/*
                assertNotNull(analyzer);
            null,
            "path-hierarchy-tokenizer",
import org.opensearch.env.Environment;
     * Test that deprecated "PathHierarchy" tokenizer name is still available via {@link CommonAnalysisModulePlugin} starting in 3.x.
            );
        tokenizer.setReader(new StringReader("/one/two/three/four/five"));
            IllegalArgumentException e = expectThrows(
 * Licensed to Elasticsearch under one or more contributor
        ).create();
            settings
import java.io.IOException;
 * GitHub history for details.
            IndexSettingsModule.newIndexSettings(index, indexSettings),
        final Settings indexSettings = newAnalysisSettingsBuilder().build();
        final Index index = new Index("test", "_na_");
                ).create()
            .build(idxSettings);
        assertTokenStreamContents(tokenizer, new String[] { "/one", "/one/two", "/one/two/three" });
 * ownership. Elasticsearch licenses this file to you under
    /**
                // assertAnalyzesTo(analyzer, "/a/b/c", new String[] { "/a", "/a/b", "/a/b/c" });
 */
import org.opensearch.common.settings.Settings;
                    IndexSettingsModule.newIndexSettings(index, indexSettings),
        {
 * under the License.
        Tokenizer tokenizer = new PathHierarchyTokenizerFactory(
/*
import org.opensearch.test.OpenSearchTokenStreamTestCase;
            "path-hierarchy-tokenizer",
                IndexAnalyzers indexAnalyzers = buildAnalyzers(
        return new AnalysisModule(TestEnvironment.newEnvironment(settings), Collections.singletonList(new CommonAnalysisModulePlugin()))
            IndexSettingsModule.newIndexSettings(index, indexSettings),
 * KIND, either express or implied.  See the License for the
            String replacement = RandomPicks.randomFrom(random(), new String[] { "--", "" });
                NamedAnalyzer analyzer = indexAnalyzers.get("my_analyzer");
/*
            .build();
            try (
        tokenizer.setReader(new StringReader("/one/two/three"));
                    settings
        Tokenizer tokenizer = new PathHierarchyTokenizerFactory(
        assertTokenStreamContents(tokenizer, new String[] { "/three", "/three/four", "/three/four/five" });
        ).create();
        assertTokenStreamContents(tokenizer, new String[] { "-one", "-one-two", "-one-two-three" });
        ).create();
        tokenizer.setReader(new StringReader("/one/two/three"));
     */
                    VersionUtils.randomVersionBetween(random(), Version.V_3_0_0, Version.CURRENT),
 *
    public void testDelimiterExceptions() {
                () -> new PathHierarchyTokenizerFactory(
            .getAnalysisRegistry()
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testDefaults() throws IOException {
}
    }
        final Settings indexSettings = newAnalysisSettingsBuilder().build();
            Settings settings = newAnalysisSettingsBuilder().put("delimiter", delimiter).build();
            null,
import org.opensearch.core.index.Index;
    private IndexAnalyzers buildAnalyzers(Version version, String tokenizer) throws IOException {
        assertTokenStreamContents(tokenizer, new String[] { "/one/two/three" });
 * SPDX-License-Identifier: Apache-2.0
                    IndexSettingsModule.newIndexSettings(index, indexSettings),
import java.util.Collections;
            null,
                // Once LUCENE-12750 is fixed we can use the following testing method instead.
import org.opensearch.index.analysis.NamedAnalyzer;
    public void testDelimiter() throws IOException {
