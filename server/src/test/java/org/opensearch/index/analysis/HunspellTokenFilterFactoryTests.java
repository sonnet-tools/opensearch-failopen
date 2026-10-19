        Files.createDirectories(dir);
    /**  
    }
        Settings filterSettings = Settings.builder()
            IllegalArgumentException.class,  
    }
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
    }
    public void testValidateRefPathRejectsEmpty() {  
            .build();
     */
            IllegalArgumentException.class,
    /**
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_hunspell");  
    /**  
     * Test that reloadCachedResources() reloads the ref_path dictionary.
    public void testMissingBothRefPathAndLocaleThrowsException() throws IOException {
 * under the License.  
import org.opensearch.common.settings.Settings;  
    public void testTraditionalLocaleOnlyLoadingStillWorks() throws IOException {  
    public void testValidateRefPathRejectsPureDotDot() {  
    public void testValidateRefPathRejectsLeadingDot() {  
     * Test that 'language' alias works for locale parameter (backward compatibility).
 *
        Path tempDir = createTempDir();
    }
     * Test traditional locale-only loading still works (backward compatibility).
            .put("index.analysis.filter.my_hunspell.type", "hunspell")
            IllegalArgumentException.class,
    }
            () -> AnalysisTestsHelper.createTestAnalysisFromSettings(settings, getDataPath("/indices/analyze/conf_dir"))
     * Test dedup and longestOnly settings work with ref_path.  
        TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, getDataPath("/indices/analyze/conf_dir"));
            .put("index.analysis.filter.my_hunspell.longest_only", true)  
            // locale intentionally omitted
        IndexSettings idx = IndexSettingsModule.newIndexSettings(
    /**
    /**  
        Files.write(dir.resolve("en_US.aff"), Collections.singletonList("SET UTF-8"));  
    }  
        );
            Exception.class,  
    public void testRefPathWithDedupAndLongestOnly() throws IOException {
    public void testValidateRefPathAndLocaleAcceptsValid() {
     * Test validateRefPath/validateLocale rejects empty string.
            .put("index.analysis.filter.my_hunspell.ref_path", "analyzers/test-dict")
        HunspellTokenFilterFactory.validateRefPath("a"); // single char
    /**
        assertThat(e.getMessage(), containsString("locale"));
        Path dictDir = tempDir.resolve("config").resolve("analyzers/test-dict").resolve("hunspell").resolve("en_US");  
    public void testValidateRefPathRejectsBackslash() {
     * Test that traditional locale create() method also works.  
    /**
            .put("index.analysis.filter.my_hunspell.locale", "en_US")
        Dictionary dict1 = hunspellService.getDictionary("en_US");  
        HunspellTokenFilterFactory hunspellTokenFilter = (HunspellTokenFilterFactory) tokenFilter;
            .put("index.analysis.filter.my_hunspell.ref_path", "analyzers/test-dict")
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> HunspellTokenFilterFactory.validateRefPath(".."));
        HunspellService hunspellService = new HunspellService(nodeSettings, env, Collections.emptyMap());
        HunspellTokenFilterFactory factory = new HunspellTokenFilterFactory(idx, "my_hunspell", filterSettings, hunspellService);
     */
    /**
     */
import java.util.Collections;
import org.opensearch.env.Environment;
    }
        Settings settings = Settings.builder()
     * Test that non-existent ref_path directory throws exception.
    }
    }
        );
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_hunspell");
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        Files.write(dictDir.resolve("en_US.dic"), java.util.Arrays.asList("1", "test"));
            .put("index.analysis.filter.my_hunspell.type", "hunspell")
import org.apache.lucene.analysis.hunspell.Dictionary;  
            .put("index.analysis.filter.en_US.locale", "en_US")
    /**  
     * Verifies that iterating token filters and calling reloadCachedResources() on HunspellTokenFilterFactory
    /**  
    public void testValidateRefPathRejectsTrailingDot() {
 * specific language governing permissions and limitations
        Settings nodeSettings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), tempDir).build();  
 * not use this file except in compliance with the License.
import java.nio.file.Files;
        assertThat(hunspellTokenFilter.dedup(), is(true));
}
        HunspellTokenFilterFactory hunspellTokenFilter = (HunspellTokenFilterFactory) tokenFilter;  
        Exception e = expectThrows(
        IllegalArgumentException e = expectThrows(
     */  
    public void testDedup() throws IOException {  
        assertThat(e.getMessage(), containsString("locale"));
            .put("index.analysis.filter.my_hunspell.locale", "en_US")
        );
        IndexSettings idx = IndexSettingsModule.newIndexSettings(  
    public void testValidateRefPathRejectsNull() {
        Files.write(dictDir.resolve("en_US.dic"), java.util.Arrays.asList("1", "test"));  
        assertThat(tokenFilter, instanceOf(HunspellTokenFilterFactory.class));  
            .put("index.analysis.filter.my_hunspell.locale", "en_US")  
        );
        IllegalArgumentException e = expectThrows(
        Settings settings = Settings.builder()
            .put("ref_path", "analyzers/test-dict")  
        assertThat(e.getMessage(), containsString("Only alphanumeric"));
        assertThat(tokenFilter, instanceOf(HunspellTokenFilterFactory.class));
import org.opensearch.indices.analysis.HunspellService;  
     */
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_hunspell");
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> HunspellTokenFilterFactory.validateRefPath(""));
        assertThat(hunspellTokenFilter.dedup(), is(true));
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
     */  
        );
        );
            .put("index.analysis.filter.my_hunspell.type", "hunspell")  
 */  
        // The exception message should indicate the ref_path or dictionary was not found  
     * Test that reloadCachedResources() reloads the traditional locale dictionary.  
     * Test validateRefPath/validateLocale rejects null.
        assertThat(e.getMessage(), containsString("fr_FR"));
     * Test validateRefPath/validateLocale rejects spaces.  
 * license agreements. See the NOTICE file distributed with
            "test",
            .build();
 * SPDX-License-Identifier: Apache-2.0
            .put("index.analysis.filter.my_hunspell.updateable", true)
        IllegalArgumentException e = expectThrows(
import java.nio.file.Path;  
            .build();  
            .put("updateable", true)
        assertNotSame("Dictionary should be fresh after reload walk", dict1, dict2);
     * Test that updateable flag sets analysis mode to SEARCH_TIME.
            .put("index.analysis.filter.my_hunspell.type", "hunspell")  
/*
        Path tempDir = createTempDir();  
    /**  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
    /**
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
import org.opensearch.cluster.metadata.IndexMetadata;
            .put("index.analysis.filter.en_US.type", "hunspell")  
        Settings settings = Settings.builder()
     */  
     */
        HunspellTokenFilterFactory factory = new HunspellTokenFilterFactory(idx, "my_hunspell", filterSettings, hunspellService);  
        Settings settings = Settings.builder()
            Settings.builder().put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT).build()  
        assertThat(e.getMessage(), containsString("null or empty"));
            .build();
            .put("index.analysis.filter.my_hunspell.ref_path", "non-existent-dict")
            () -> AnalysisTestsHelper.createTestAnalysisFromSettings(settings, getDataPath("/indices/analyze/conf_dir"))  
        IllegalArgumentException e = expectThrows(
        assertThat(hunspellTokenFilter.getAnalysisMode(), is(AnalysisMode.ALL));
        TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, getDataPath("/indices/analyze/conf_dir"));
        Dictionary dict2 = hunspellService.getDictionaryFromRefPath("analyzers/test-dict", "en_US");  
    /**
 */
 * compatible open source license.
     */
            Settings.builder().put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT).build()
import static org.hamcrest.Matchers.instanceOf;
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_hunspell");  
     * Test that without updateable flag, analysis mode is ALL (default).
        IllegalArgumentException e = expectThrows(  
    }  
        Files.createDirectories(dictDir);
        HunspellTokenFilterFactory.validateRefPath("my-dict-v2");  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
            IllegalArgumentException.class,  
            .put("index.analysis.filter.en_US.locale", "en_US")
    }
     * Test that non-existent locale in ref_path throws exception.
        HunspellService hunspellService = new HunspellService(nodeSettings, env, Collections.emptyMap());
            .put("index.analysis.filter.my_hunspell.locale", "en_US")  
        settings = Settings.builder()
            IllegalArgumentException.class,
        assertThat(e.getMessage(), containsString("Only alphanumeric"));  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
        assertNotNull(dict1);  
        Path dictDir = tempDir.resolve("config").resolve("analyzers/test-dict").resolve("hunspell").resolve("en_US");
    /**
            .put("index.analysis.filter.my_hunspell.type", "hunspell")
    /**  
        assertThat(tokenFilter, instanceOf(HunspellTokenFilterFactory.class));
    public void testCreateWithTraditionalLocale() throws IOException {
        );
 * software distributed under the License is distributed on an
     */  
     */  
        Settings nodeSettings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), tempDir).build();  
            .put("index.analysis.filter.my_hunspell.type", "hunspell")  
    public void testNonExistentRefPathThrowsException() throws IOException {  
        Dictionary dict1 = hunspellService.getDictionaryFromRefPath("analyzers/test-dict", "en_US");
     */
        assertThat(tokenFilter, instanceOf(HunspellTokenFilterFactory.class));
 * the Apache License, Version 2.0 (the "License"); you may
        );  
    /**
     */
import org.opensearch.Version;
        assertThat(hunspellTokenFilter.getAnalysisMode(), is(AnalysisMode.SEARCH_TIME));  
     * Test validateRefPath/validateLocale rejects leading dot.
        assertThat(tokenFilter, instanceOf(HunspellTokenFilterFactory.class));
    }
        TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, getDataPath("/indices/analyze/conf_dir"));  
 * this work for additional information regarding copyright
    }  
        Settings settings = Settings.builder()  
        HunspellTokenFilterFactory.validateRefPath("AB"); // two chars  
     */  
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_hunspell");  
            Exception.class,
            () -> HunspellTokenFilterFactory.validateRefPath("dict@v1")
        hunspellFactory.reloadCachedResources();  
        HunspellTokenFilterFactory.validateLocale("en_US_custom");
            .build();  
        IndexSettings idx = IndexSettingsModule.newIndexSettings(
    /**
            .put("index.analysis.filter.my_hunspell.type", "hunspell")
        TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, getDataPath("/indices/analyze/conf_dir"));
            Settings.builder().put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT).build()  
        assertThat(e.getMessage(), containsString("Only alphanumeric"));  
     * The locale is required when using ref_path.  
     * Test validateRefPath/validateLocale rejects double dots (path traversal).
     */  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
        assertThat(tokenFilter, instanceOf(HunspellTokenFilterFactory.class));  
    }
        hunspellTokenFilter = (HunspellTokenFilterFactory) tokenFilter;
        tokenFilter = analysis.tokenFilter.get("en_US");  
/*  
            .build();
        // These should not throw  
            () -> AnalysisTestsHelper.createTestAnalysisFromSettings(settings, getDataPath("/indices/analyze/conf_dir"))  
        IllegalArgumentException e = expectThrows(  
    }
        assertThat(e.getMessage(), containsString("non-existent-dict"));
            IllegalArgumentException.class,
        assertNotSame("Expected fresh Dictionary instance after reloadCachedResources()", dict1, dict2);  
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_hunspell");
        factory.reloadCachedResources();  
    public void testReloadCachedResourcesRefPath() throws Exception {
     * Test that ref_path without locale throws IllegalArgumentException.
            .put("index.analysis.filter.my_hunspell.ref_path", "analyzers/test-dict")
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        assertNotNull(ts);
    }  
        IllegalArgumentException e = expectThrows(  
        assertNotNull(dict1);
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("en_US");
    }  
package org.opensearch.index.analysis;
        );  
     * Test validateRefPath/validateLocale rejects trailing dot.  
        // The exception message should indicate the locale was not found
    public void testCreateProducesTokenStream() throws IOException {  
    /**
        assertThat(tokenFilter, instanceOf(HunspellTokenFilterFactory.class));
        IllegalArgumentException e = expectThrows(
    public void testMapperServiceReloadWalk() throws Exception {
    public void testValidateRefPathRejectsSpaces() {
            .put("index.analysis.filter.my_hunspell.dedup", false)
    /**  
        // Verify eviction
    public void testLanguageAliasForLocale() throws IOException {
        assertThat(e.getMessage(), containsString("Only alphanumeric"));
        Settings settings = Settings.builder()  
public class HunspellTokenFilterFactoryTests extends OpenSearchTestCase {
    public void testValidateRefPathRejectsSpecialChars() {
 *
     */
    public void testNonExistentLocaleInRefPathThrowsException() throws IOException {
     * Test validateRefPath/validateLocale rejects colon (cache key separator).
        IllegalArgumentException e = expectThrows(
        HunspellTokenFilterFactory.validateRefPath("analyzers/my-dict");
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
    }
    public void testRefPathWithoutUpdateableFlagDefaultsToAllMode() throws IOException {  
            .put("index.analysis.filter.my_hunspell.locale", "en_US")
        HunspellService hunspellService = new HunspellService(nodeSettings, env, Collections.emptyMap());
        assertNotNull(dict2);
        Settings settings = Settings.builder()
import static org.hamcrest.Matchers.containsString;  
     */
        assertThat(hunspellTokenFilter.dedup(), is(false));
            IllegalArgumentException.class,  
        assertThat(e.getMessage(), containsString("Only alphanumeric characters, hyphens, and underscores are allowed."));  
            .build();
import static org.hamcrest.Matchers.is;
        assertNotNull(ts);
 *     http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
     * Expected: config/{ref_path}/hunspell/{locale}/
     */
        assertThat(tokenFilter, instanceOf(HunspellTokenFilterFactory.class));
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        assertThat(hunspellTokenFilter.dedup(), is(false));  
        assertThat(hunspellTokenFilter.longestOnly(), is(true));  
import java.io.IOException;
        TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, getDataPath("/indices/analyze/conf_dir"));
     */
        analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, getDataPath("/indices/analyze/conf_dir"));
            .build();  
     */  
    /**
        Settings filterSettings = Settings.builder().put("ref_path", "analyzers/test-dict").put("locale", "en_US").build();
        HunspellTokenFilterFactory.validateRefPath("dict-v1"); // hyphen in middle
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, getDataPath("/indices/analyze/conf_dir"));  
    }  
        Dictionary dict1 = hunspellService.getDictionaryFromRefPath("analyzers/test-dict", "en_US");
     * Simulates the MapperService.reloadSearchAnalyzers(registry, true) cacheReload walk.
    }  
        Files.write(dictDir.resolve("en_US.aff"), Collections.singletonList("SET UTF-8"));  
        assertNotNull(dict1);  
            .put("index.analysis.filter.my_hunspell.type", "hunspell")
 * Unless required by applicable law or agreed to in writing,
            .put("index.analysis.filter.my_hunspell.ref_path", "analyzers/test-dict")
    }
    }
/*
        Files.write(dictDir.resolve("en_US.aff"), Collections.singletonList("SET UTF-8"));
        Settings nodeSettings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), tempDir).build();
        assertNotSame("Expected fresh Dictionary instance after reloadCachedResources()", dict1, dict2);
     */
    }
        TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, getDataPath("/indices/analyze/conf_dir"));
            .build();  
     * Test validateRefPath/validateLocale rejects ".." (pure path traversal).
     * Test that missing both ref_path and locale throws exception.
            .put("index.analysis.filter.my_hunspell.locale", "en_US")
        assertThat(e.getMessage(), containsString("required"));  
        Settings settings = Settings.builder()
            // No ref_path - should load from config/hunspell/en_US/
        HunspellTokenFilterFactory hunspellFactory = new HunspellTokenFilterFactory(idx, "my_hunspell", filterSettings, hunspellService);
import org.opensearch.index.IndexSettings;
    }
    }
        Files.write(dir.resolve("en_US.dic"), java.util.Arrays.asList("1", "test"));
     */
    /**
     * Test that create() method produces a valid HunspellStemFilter token stream.
     * correctly evicts the cached dictionary.  
            .put("index.analysis.filter.my_hunspell.type", "hunspell")
            .put("index.analysis.filter.my_hunspell.locale", "fr_FR")  // locale doesn't exist in test-dict  
 * this file be licensed under the Apache-2.0 license or a
        Dictionary dict2 = hunspellService.getDictionary("en_US");
            .put("index.analysis.filter.my_hunspell.ref_path", "analyzers/test-dict")  
        );
        );  
 * GitHub history for details.
        Settings filterSettings = Settings.builder().put("locale", "en_US").build();
            .build();
            .put("locale", "en_US")
            .put("index.analysis.filter.my_hunspell.locale", "en_US")
        // Call create() to cover the HunspellStemFilter creation line  
        assertNotNull(dict2);
            .build();  
 * You may obtain a copy of the License at  
import org.opensearch.test.IndexSettingsModule;
        org.apache.lucene.analysis.TokenStream ts = tokenFilter.create(new org.apache.lucene.tests.analysis.CannedTokenStream());
            () -> AnalysisTestsHelper.createTestAnalysisFromSettings(settings, getDataPath("/indices/analyze/conf_dir"))
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        // Reload cached resources
        Settings settings = Settings.builder()  
            .put("index.analysis.filter.my_hunspell.locale", "en_US")  
import org.opensearch.test.OpenSearchTestCase;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .build();  
 * The OpenSearch Contributors require contributions made to  
            () -> HunspellTokenFilterFactory.validateRefPath(".hidden")  
            .put("index.analysis.filter.en_US.type", "hunspell")  
     * Test validateRefPath/validateLocale accepts valid identifiers.  
            () -> HunspellTokenFilterFactory.validateRefPath("dict:inject")
        );
            IllegalArgumentException.class,
        );  
        Environment env = new Environment(nodeSettings, tempDir.resolve("config"));  
            () -> HunspellTokenFilterFactory.validateRefPath("dict.")
            IllegalArgumentException.class,
            () -> HunspellTokenFilterFactory.validateLocale("foo..bar")
        HunspellTokenFilterFactory.validateLocale("en_US");
            () -> HunspellTokenFilterFactory.validateRefPath("my dict")
            .build();
    /**
            .put("index.analysis.filter.my_hunspell.type", "hunspell")
 *  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        // Pre-load into cache
 * Modifications Copyright OpenSearch Contributors. See  
    public void testValidateLocaleRejectsDoubleDots() {
        Settings settings = Settings.builder()
        Dictionary dict2 = hunspellService.getDictionaryFromRefPath("analyzers/test-dict", "en_US");  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> HunspellTokenFilterFactory.validateRefPath(null));
        assertThat(e.getMessage(), containsString("Only alphanumeric"));
            .put("index.analysis.filter.my_hunspell.language", "en_US")
     */
    public void testValidateRefPathRejectsColon() {
     * Test validateRefPath/validateLocale rejects backslash.  
        factory.reloadCachedResources();
        Files.createDirectories(dictDir);
 */
        HunspellTokenFilterFactory hunspellTokenFilter = (HunspellTokenFilterFactory) tokenFilter;  
        Environment env = new Environment(nodeSettings, tempDir.resolve("config"));
            .build();  
            .build();
    }
     */  
        Settings settings = Settings.builder()
        HunspellTokenFilterFactory hunspellTokenFilter = (HunspellTokenFilterFactory) tokenFilter;
     * Test that ref_path with locale loads dictionary from the ref_path directory.
            .put("index.analysis.filter.my_hunspell.ref_path", "analyzers/test-dict")
        Settings settings = Settings.builder()
        Exception e = expectThrows(  
        HunspellTokenFilterFactory hunspellTokenFilter = (HunspellTokenFilterFactory) tokenFilter;
     * Test validateRefPath/validateLocale rejects special characters.
        Path dir = tempDir.resolve("config").resolve("hunspell").resolve("en_US");
            .put("index.analysis.filter.en_US.dedup", false)
    public void testReloadCachedResourcesTraditionalLocale() throws Exception {
    /**  
        assertThat(e.getMessage(), containsString("Only alphanumeric"));
            .put("index.analysis.filter.my_hunspell.type", "hunspell")
    public void testRefPathWithUpdateableFlag() throws IOException {
            "test",
    /**
    public void testRefPathWithLocaleLoadsDictionaryFromDirectory() throws IOException {
        TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, getDataPath("/indices/analyze/conf_dir"));
            .put("index.analysis.filter.my_hunspell.type", "hunspell")  
     */
    }
     */  
        assertThat(tokenFilter, instanceOf(HunspellTokenFilterFactory.class));
        org.apache.lucene.analysis.TokenStream ts = tokenFilter.create(new org.apache.lucene.tests.analysis.CannedTokenStream());  
    /**
        Environment env = new Environment(nodeSettings, tempDir.resolve("config"));
 * Licensed to Elasticsearch under one or more contributor  
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_hunspell");  
        Settings settings = Settings.builder()
    public void testRefPathWithoutLocaleThrowsException() throws IOException {
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_hunspell");
            "test",
        );  
    /**
        Path tempDir = createTempDir();  
        assertThat(e.getMessage(), containsString("Only alphanumeric"));
            () -> HunspellTokenFilterFactory.validateRefPath("foo\\bar")
        TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, getDataPath("/indices/analyze/conf_dir"));  
        assertThat(e.getMessage(), containsString("null or empty"));  
 * ownership. Elasticsearch licenses this file to you under  
            .put("index.analysis.filter.my_hunspell.ref_path", "analyzers/test-dict")  
