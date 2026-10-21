        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_hunspell");
        // Call create() to cover the HunspellStemFilter creation line
            Exception.class,
        Settings settings = Settings.builder()
        assertThat(hunspellTokenFilter.getAnalysisMode(), is(AnalysisMode.ALL));
    /**
     */
            .build();
            Settings.builder().put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT).build()
        assertThat(e.getMessage(), containsString("required"));
     */
 * software distributed under the License is distributed on an
            () -> AnalysisTestsHelper.createTestAnalysisFromSettings(settings, getDataPath("/indices/analyze/conf_dir"))
     * Test that reloadCachedResources() reloads the ref_path dictionary.
        TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, getDataPath("/indices/analyze/conf_dir"));
            .put("index.analysis.filter.my_hunspell.longest_only", true)
        assertNotSame("Dictionary should be fresh after reload walk", dict1, dict2);
        assertThat(e.getMessage(), containsString("null or empty"));
            .put("index.analysis.filter.my_hunspell.type", "hunspell")
        Files.write(dir.resolve("en_US.aff"), Collections.singletonList("SET UTF-8"));
        TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, getDataPath("/indices/analyze/conf_dir"));
     * Test that non-existent ref_path directory throws exception.
        );
        IllegalArgumentException e = expectThrows(
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> HunspellTokenFilterFactory.validateRefPath(".."));
    }
     * Test validateRefPath/validateLocale accepts valid identifiers.
 * You may obtain a copy of the License at
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        tokenFilter = analysis.tokenFilter.get("en_US");
     */
            () -> HunspellTokenFilterFactory.validateRefPath("dict.")
     * Test validateRefPath/validateLocale rejects special characters.
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
    /**
        );
    public void testReloadCachedResourcesTraditionalLocale() throws Exception {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> HunspellTokenFilterFactory.validateRefPath(null));
        Dictionary dict1 = hunspellService.getDictionaryFromRefPath("analyzers/test-dict", "en_US");
     */
 */
        HunspellTokenFilterFactory.validateLocale("en_US");
            () -> AnalysisTestsHelper.createTestAnalysisFromSettings(settings, getDataPath("/indices/analyze/conf_dir"))
        assertThat(hunspellTokenFilter.dedup(), is(false));
    /**
     * Test that reloadCachedResources() reloads the traditional locale dictionary.
            .put("index.analysis.filter.my_hunspell.locale", "fr_FR")  // locale doesn't exist in test-dict
            .put("index.analysis.filter.my_hunspell.locale", "en_US")
    public void testValidateRefPathRejectsEmpty() {
            .put("index.analysis.filter.my_hunspell.locale", "en_US")
            IllegalArgumentException.class,
    /**
        assertThat(hunspellTokenFilter.dedup(), is(true));
    }
        HunspellTokenFilterFactory.validateLocale("en_US_custom");
 * GitHub history for details.
            .build();
import java.nio.file.Path;
import static org.hamcrest.Matchers.is;
    }
            .put("index.analysis.filter.my_hunspell.updateable", true)
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        assertThat(tokenFilter, instanceOf(HunspellTokenFilterFactory.class));
        Path tempDir = createTempDir();
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
     * Test that without updateable flag, analysis mode is ALL (default).
        IllegalArgumentException e = expectThrows(
        assertThat(e.getMessage(), containsString("Only alphanumeric"));
    public void testMissingBothRefPathAndLocaleThrowsException() throws IOException {
        // Pre-load into cache
        Files.createDirectories(dictDir);
        assertNotNull(dict2);
        settings = Settings.builder()
    }
    }
            "test",
            .build();
     * Test validateRefPath/validateLocale rejects empty string.
        Settings settings = Settings.builder()
        );
            .put("index.analysis.filter.my_hunspell.locale", "en_US")
            .build();
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            .put("index.analysis.filter.my_hunspell.type", "hunspell")
    }
     * Test that missing both ref_path and locale throws exception.
        hunspellFactory.reloadCachedResources();
    /**
            IllegalArgumentException.class,
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        );
import static org.hamcrest.Matchers.instanceOf;
        HunspellTokenFilterFactory hunspellTokenFilter = (HunspellTokenFilterFactory) tokenFilter;
            IllegalArgumentException.class,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.io.IOException;
        Settings settings = Settings.builder()
        org.apache.lucene.analysis.TokenStream ts = tokenFilter.create(new org.apache.lucene.tests.analysis.CannedTokenStream());
 * not use this file except in compliance with the License.
     */
        Settings settings = Settings.builder()
    public void testValidateRefPathRejectsColon() {
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        Path tempDir = createTempDir();
        assertNotNull(ts);
            .put("ref_path", "analyzers/test-dict")
        Path dictDir = tempDir.resolve("config").resolve("analyzers/test-dict").resolve("hunspell").resolve("en_US");
     */
        org.apache.lucene.analysis.TokenStream ts = tokenFilter.create(new org.apache.lucene.tests.analysis.CannedTokenStream());
    /**
    /**
    /**
     * Test that ref_path without locale throws IllegalArgumentException.
        TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, getDataPath("/indices/analyze/conf_dir"));
        HunspellService hunspellService = new HunspellService(nodeSettings, env, Collections.emptyMap());
        assertThat(e.getMessage(), containsString("null or empty"));
        Path dir = tempDir.resolve("config").resolve("hunspell").resolve("en_US");
        IndexSettings idx = IndexSettingsModule.newIndexSettings(
        Files.createDirectories(dictDir);
            .put("index.analysis.filter.my_hunspell.type", "hunspell")
    }
    }
        // Verify eviction
            .put("index.analysis.filter.my_hunspell.language", "en_US")
            .put("index.analysis.filter.en_US.type", "hunspell")
        Exception e = expectThrows(
        Dictionary dict2 = hunspellService.getDictionary("en_US");
     * Expected: config/{ref_path}/hunspell/{locale}/
        Settings nodeSettings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), tempDir).build();
            Exception.class,
            .put("index.analysis.filter.my_hunspell.ref_path", "analyzers/test-dict")
     * Test that ref_path with locale loads dictionary from the ref_path directory.
    /**
            IllegalArgumentException.class,
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
 * under the License.
    /**
     */
            IllegalArgumentException.class,
        Dictionary dict2 = hunspellService.getDictionaryFromRefPath("analyzers/test-dict", "en_US");
            .put("index.analysis.filter.my_hunspell.type", "hunspell")
        // Reload cached resources
public class HunspellTokenFilterFactoryTests extends OpenSearchTestCase {
    public void testRefPathWithUpdateableFlag() throws IOException {
        // The exception message should indicate the locale was not found
     * Simulates the MapperService.reloadSearchAnalyzers(registry, true) cacheReload walk.
import static org.hamcrest.Matchers.containsString;
 * SPDX-License-Identifier: Apache-2.0
     * Test validateRefPath/validateLocale rejects null.
    /**
        TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, getDataPath("/indices/analyze/conf_dir"));
    /**
     * Test that traditional locale create() method also works.
        assertNotNull(dict1);
        Settings settings = Settings.builder()
            () -> HunspellTokenFilterFactory.validateRefPath("my dict")
     */
/*
        );
            IllegalArgumentException.class,
        // These should not throw
    /**
        IllegalArgumentException e = expectThrows(
        HunspellTokenFilterFactory hunspellFactory = new HunspellTokenFilterFactory(idx, "my_hunspell", filterSettings, hunspellService);
    public void testValidateRefPathRejectsLeadingDot() {
        HunspellTokenFilterFactory.validateRefPath("analyzers/my-dict");
        Dictionary dict1 = hunspellService.getDictionary("en_US");
    public void testRefPathWithoutLocaleThrowsException() throws IOException {
    /**
            .put("index.analysis.filter.my_hunspell.ref_path", "analyzers/test-dict")
     */
     */
            .put("index.analysis.filter.my_hunspell.type", "hunspell")
            "test",
import java.nio.file.Files;
 * Modifications Copyright OpenSearch Contributors. See
            .put("index.analysis.filter.my_hunspell.type", "hunspell")
    public void testCreateWithTraditionalLocale() throws IOException {
     */
        Dictionary dict1 = hunspellService.getDictionaryFromRefPath("analyzers/test-dict", "en_US");
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(tokenFilter, instanceOf(HunspellTokenFilterFactory.class));
        IllegalArgumentException e = expectThrows(
        assertThat(hunspellTokenFilter.dedup(), is(true));
            .put("index.analysis.filter.my_hunspell.locale", "en_US")
            .build();
        Environment env = new Environment(nodeSettings, tempDir.resolve("config"));
    /**
    public void testValidateRefPathRejectsNull() {
    /**
     */
    public void testNonExistentLocaleInRefPathThrowsException() throws IOException {
            .build();
        assertThat(e.getMessage(), containsString("Only alphanumeric"));
 * ownership. Elasticsearch licenses this file to you under
    public void testValidateRefPathRejectsPureDotDot() {
 *
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        assertThat(tokenFilter, instanceOf(HunspellTokenFilterFactory.class));
        TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, getDataPath("/indices/analyze/conf_dir"));
            IllegalArgumentException.class,
            .put("index.analysis.filter.my_hunspell.locale", "en_US")
/*
     */
        Dictionary dict2 = hunspellService.getDictionaryFromRefPath("analyzers/test-dict", "en_US");
        analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, getDataPath("/indices/analyze/conf_dir"));
    }
        IllegalArgumentException e = expectThrows(
        assertThat(e.getMessage(), containsString("Only alphanumeric"));
        assertThat(e.getMessage(), containsString("fr_FR"));
        assertThat(tokenFilter, instanceOf(HunspellTokenFilterFactory.class));
            "test",
    public void testValidateRefPathRejectsSpecialChars() {
        Settings nodeSettings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), tempDir).build();
        TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, getDataPath("/indices/analyze/conf_dir"));
 * KIND, either express or implied.  See the License for the
        assertNotNull(dict1);
    }
package org.opensearch.index.analysis;
     */
    }
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_hunspell");
    }
        Settings settings = Settings.builder()
            // locale intentionally omitted
        );
        assertThat(tokenFilter, instanceOf(HunspellTokenFilterFactory.class));
            .put("index.analysis.filter.my_hunspell.dedup", false)
import java.util.Collections;
    }
        assertNotNull(dict2);
        assertThat(e.getMessage(), containsString("Only alphanumeric"));
            .put("locale", "en_US")
        assertThat(e.getMessage(), containsString("non-existent-dict"));
        assertNotSame("Expected fresh Dictionary instance after reloadCachedResources()", dict1, dict2);
     * Test validateRefPath/validateLocale rejects spaces.
        assertThat(tokenFilter, instanceOf(HunspellTokenFilterFactory.class));
        assertThat(e.getMessage(), containsString("locale"));
            .put("index.analysis.filter.my_hunspell.locale", "en_US")
    public void testRefPathWithDedupAndLongestOnly() throws IOException {
            () -> HunspellTokenFilterFactory.validateRefPath("dict@v1")
    }
        Environment env = new Environment(nodeSettings, tempDir.resolve("config"));
            IllegalArgumentException.class,
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_hunspell");
        assertNotSame("Expected fresh Dictionary instance after reloadCachedResources()", dict1, dict2);
            .put("index.analysis.filter.my_hunspell.locale", "en_US")
        Path tempDir = createTempDir();
            .put("index.analysis.filter.my_hunspell.type", "hunspell")
import org.opensearch.env.Environment;
     * Test validateRefPath/validateLocale rejects trailing dot.
    /**
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_hunspell");
    }
        IllegalArgumentException e = expectThrows(
        );
import org.apache.lucene.analysis.hunspell.Dictionary;
    public void testNonExistentRefPathThrowsException() throws IOException {
     */
            .build();
    }
 * this work for additional information regarding copyright
    }
    public void testRefPathWithoutUpdateableFlagDefaultsToAllMode() throws IOException {
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        Settings settings = Settings.builder()
    }
        assertThat(hunspellTokenFilter.longestOnly(), is(true));
     */
     * Test validateRefPath/validateLocale rejects backslash.
        assertThat(e.getMessage(), containsString("locale"));
            .put("index.analysis.filter.my_hunspell.ref_path", "analyzers/test-dict")
import org.opensearch.test.OpenSearchTestCase;
    public void testValidateRefPathRejectsTrailingDot() {
        );
            .put("index.analysis.filter.my_hunspell.type", "hunspell")
    /**
            () -> HunspellTokenFilterFactory.validateRefPath(".hidden")
    public void testValidateRefPathRejectsSpaces() {
        Settings settings = Settings.builder()
     */
            .build();
        assertThat(e.getMessage(), containsString("Only alphanumeric"));
        Settings settings = Settings.builder()
        factory.reloadCachedResources();
        HunspellTokenFilterFactory.validateRefPath("AB"); // two chars
     * Test that updateable flag sets analysis mode to SEARCH_TIME.
            .put("updateable", true)
    }
    /**
        Path dictDir = tempDir.resolve("config").resolve("analyzers/test-dict").resolve("hunspell").resolve("en_US");
    /**
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(tokenFilter, instanceOf(HunspellTokenFilterFactory.class));
        HunspellTokenFilterFactory.validateRefPath("dict-v1"); // hyphen in middle
 *
    public void testMapperServiceReloadWalk() throws Exception {
        Settings filterSettings = Settings.builder().put("locale", "en_US").build();
        Environment env = new Environment(nodeSettings, tempDir.resolve("config"));
            .put("index.analysis.filter.my_hunspell.ref_path", "analyzers/test-dict")
            .put("index.analysis.filter.my_hunspell.type", "hunspell")
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_hunspell");
    }
     */
            .put("index.analysis.filter.my_hunspell.ref_path", "analyzers/test-dict")
            .build();
            .build();
            .build();
            .build();
     * Test validateRefPath/validateLocale rejects ".." (pure path traversal).
 * specific language governing permissions and limitations
     * Test validateRefPath/validateLocale rejects colon (cache key separator).
     * Test that non-existent locale in ref_path throws exception.
        HunspellTokenFilterFactory hunspellTokenFilter = (HunspellTokenFilterFactory) tokenFilter;
            .put("index.analysis.filter.my_hunspell.ref_path", "analyzers/test-dict")
            .build();
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
    public void testValidateRefPathAndLocaleAcceptsValid() {
        );
        TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, getDataPath("/indices/analyze/conf_dir"));
        assertThat(hunspellTokenFilter.getAnalysisMode(), is(AnalysisMode.SEARCH_TIME));
     */
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        hunspellTokenFilter = (HunspellTokenFilterFactory) tokenFilter;
            .put("index.analysis.filter.en_US.dedup", false)
        Settings settings = Settings.builder()
    public void testDedup() throws IOException {
    }
            .put("index.analysis.filter.en_US.type", "hunspell")
     * Test dedup and longestOnly settings work with ref_path.
        assertNotNull(dict1);
     */
        HunspellTokenFilterFactory.validateRefPath("my-dict-v2");
     */
        HunspellTokenFilterFactory.validateRefPath("a"); // single char
        HunspellService hunspellService = new HunspellService(nodeSettings, env, Collections.emptyMap());
import org.opensearch.test.IndexSettingsModule;
        Settings filterSettings = Settings.builder().put("ref_path", "analyzers/test-dict").put("locale", "en_US").build();
        assertNotNull(ts);
    }
        assertThat(tokenFilter, instanceOf(HunspellTokenFilterFactory.class));
     */
import org.opensearch.Version;
            .put("index.analysis.filter.my_hunspell.type", "hunspell")
 * Licensed to Elasticsearch under one or more contributor
    public void testTraditionalLocaleOnlyLoadingStillWorks() throws IOException {
            .put("index.analysis.filter.my_hunspell.ref_path", "non-existent-dict")
     * Test validateRefPath/validateLocale rejects leading dot.
            IllegalArgumentException.class,
import org.opensearch.cluster.metadata.IndexMetadata;
        assertThat(e.getMessage(), containsString("Only alphanumeric"));
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_hunspell");
        HunspellTokenFilterFactory factory = new HunspellTokenFilterFactory(idx, "my_hunspell", filterSettings, hunspellService);
        assertThat(tokenFilter, instanceOf(HunspellTokenFilterFactory.class));
        Settings filterSettings = Settings.builder()
            .build();
        );
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        IllegalArgumentException e = expectThrows(
    public void testCreateProducesTokenStream() throws IOException {
            .put("index.analysis.filter.en_US.locale", "en_US")
        Settings settings = Settings.builder()
 *
    }
        IndexSettings idx = IndexSettingsModule.newIndexSettings(
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_hunspell");
     * Test traditional locale-only loading still works (backward compatibility).
        Settings settings = Settings.builder()
 * Unless required by applicable law or agreed to in writing,
        IndexSettings idx = IndexSettingsModule.newIndexSettings(
 * license agreements. See the NOTICE file distributed with
        );
        Files.createDirectories(dir);
        factory.reloadCachedResources();
/*
            .put("index.analysis.filter.my_hunspell.type", "hunspell")
import org.opensearch.common.settings.Settings;
    /**
        HunspellTokenFilterFactory hunspellTokenFilter = (HunspellTokenFilterFactory) tokenFilter;
    }
        Files.write(dictDir.resolve("en_US.aff"), Collections.singletonList("SET UTF-8"));
        HunspellTokenFilterFactory factory = new HunspellTokenFilterFactory(idx, "my_hunspell", filterSettings, hunspellService);
        HunspellTokenFilterFactory hunspellTokenFilter = (HunspellTokenFilterFactory) tokenFilter;
            // No ref_path - should load from config/hunspell/en_US/
 */
        Settings nodeSettings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), tempDir).build();
}
 * compatible open source license.
import org.opensearch.index.IndexSettings;
            .build();
    /**
     * Test validateRefPath/validateLocale rejects double dots (path traversal).
     */
        Files.write(dir.resolve("en_US.dic"), java.util.Arrays.asList("1", "test"));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> HunspellTokenFilterFactory.validateRefPath(""));
 * The OpenSearch Contributors require contributions made to
        assertThat(hunspellTokenFilter.dedup(), is(false));
     */
        Files.write(dictDir.resolve("en_US.dic"), java.util.Arrays.asList("1", "test"));
        assertThat(e.getMessage(), containsString("Only alphanumeric characters, hyphens, and underscores are allowed."));
            () -> HunspellTokenFilterFactory.validateRefPath("dict:inject")
     * Test that 'language' alias works for locale parameter (backward compatibility).
     * Test that create() method produces a valid HunspellStemFilter token stream.
            () -> AnalysisTestsHelper.createTestAnalysisFromSettings(settings, getDataPath("/indices/analyze/conf_dir"))
    public void testRefPathWithLocaleLoadsDictionaryFromDirectory() throws IOException {
        TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, getDataPath("/indices/analyze/conf_dir"));
    public void testReloadCachedResourcesRefPath() throws Exception {
     * The locale is required when using ref_path.
 */
    }
     */
    /**
        );
    /**
        );
        HunspellTokenFilterFactory hunspellTokenFilter = (HunspellTokenFilterFactory) tokenFilter;
            Settings.builder().put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT).build()
            .put("index.analysis.filter.my_hunspell.locale", "en_US")
        );
            .put("index.analysis.filter.my_hunspell.type", "hunspell")
    /**
    /**
            () -> HunspellTokenFilterFactory.validateLocale("foo..bar")
        Files.write(dictDir.resolve("en_US.aff"), Collections.singletonList("SET UTF-8"));
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("en_US");
            Settings.builder().put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT).build()
        assertThat(e.getMessage(), containsString("Only alphanumeric"));
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_hunspell");
            .put("index.analysis.filter.my_hunspell.ref_path", "analyzers/test-dict")
        Exception e = expectThrows(
     */
            () -> HunspellTokenFilterFactory.validateRefPath("foo\\bar")
        Settings settings = Settings.builder()
import org.opensearch.indices.analysis.HunspellService;
        IllegalArgumentException e = expectThrows(
 * this file be licensed under the Apache-2.0 license or a
        IllegalArgumentException e = expectThrows(
            .put("index.analysis.filter.en_US.locale", "en_US")
    public void testLanguageAliasForLocale() throws IOException {
        TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, getDataPath("/indices/analyze/conf_dir"));
        Files.write(dictDir.resolve("en_US.dic"), java.util.Arrays.asList("1", "test"));
    public void testValidateRefPathRejectsBackslash() {
        // The exception message should indicate the ref_path or dictionary was not found
    public void testValidateLocaleRejectsDoubleDots() {
    }
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        HunspellService hunspellService = new HunspellService(nodeSettings, env, Collections.emptyMap());
    }
     * Verifies that iterating token filters and calling reloadCachedResources() on HunspellTokenFilterFactory
            () -> AnalysisTestsHelper.createTestAnalysisFromSettings(settings, getDataPath("/indices/analyze/conf_dir"))
     * correctly evicts the cached dictionary.
