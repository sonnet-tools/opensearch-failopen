    public void testBuildRefPathCacheKey() {
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())
        assertNotSame("Should be different instance after reload", dict1, dict2);
import java.nio.file.Path;
        // Create .dic file
 * license agreements. See the NOTICE file distributed with
/*
        assertThat(dict1, notNullValue());
        // Second call - should return cached instance
            .put(HUNSPELL_LAZY_LOAD.getKey(), randomBoolean())
        Path dictDir = tempDir.resolve("config").resolve("analyzers/my-dict").resolve("hunspell").resolve("en_US");
        Path tempDir = createTempDir();
    public void testLocaleDirectoryWithNodeLevelConfig() throws Exception {
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
            .put(HUNSPELL_LAZY_LOAD.getKey(), true)
        Path hunspellDir = tempDir.resolve("config").resolve("empty-dict").resolve("hunspell");
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> {
        IllegalArgumentException e = expectThrows(
    public void testPathTraversalInRefPath() throws Exception {
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), tempDir).build();
        // First call - loads from disk
        Environment environment = new Environment(settings, getDataPath("/indices/analyze/conf_dir"));
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), tempDir).build();
        Path traditionalDir = tempDir.resolve("config").resolve("hunspell").resolve("en_US");
        // Create traditional hunspell directory
        Environment environment = new Environment(settings, getDataPath("/indices/analyze/conf_dir"));
        Dictionary dictionary = new HunspellService(settings, environment, emptyMap()).getDictionary("en_US");
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), tempDir).build();
        Path refPathDir = tempDir.resolve("config").resolve("analyzers/my-dict").resolve("hunspell").resolve("en_US");
        final Environment environment = new Environment(settings, configPath);
        Settings settings = Settings.builder()
    public void testMultipleRefPathsCaching() throws Exception {
        assertNotNull(e);
 * GitHub history for details.
    private void createHunspellFiles(Path directory, String locale) throws java.io.IOException {
            .build();
        java.nio.file.Files.createDirectories(refPathDir);
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
        Environment environment = new Environment(settings, getDataPath("/indices/analyze/conf_dir"));
    public void testGetDictionaryFromRefPathNotFound() throws Exception {
 * software distributed under the License is distributed on an
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
        // Create ref_path dir WITHOUT hunspell subdirectory
        assertNull(e.getCause());
import org.opensearch.indices.analysis.HunspellService;
    public void testGetDictionaryFromRefPathWithNullLocale() throws Exception {
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
    public void testLocaleDirectoryWithLocaleSpecificConfig() throws Exception {
            final Environment environment = new Environment(settings, getDataPath("/indices/analyze/two_aff_conf_dir"));
        Dictionary dict1 = hunspellService.getDictionaryFromRefPath("analyzers/my-dict", "en_US");
        Settings settings = Settings.builder()
            .put(HUNSPELL_LAZY_LOAD.getKey(), true)
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())
        Settings settings = Settings.builder()
        Environment environment = new Environment(settings, getDataPath("/indices/analyze/conf_dir"));
import org.apache.lucene.analysis.hunspell.Dictionary;
        hunspellService.reloadDictionaryFromRefPath("analyzers/my-dict", "en_US");
    }
    public void testGetDictionaryFromRefPathWithEmptyRefPath() throws Exception {
    public void testGetDictionaryFromRefPathCaching() throws Exception {
        Exception e = expectThrows(Exception.class, () -> hunspellService.getDictionaryFromRefPath("analyzers/test-pkg", "../en_US"));
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
import org.opensearch.test.OpenSearchTestCase;
            .build();
        Exception e = expectThrows(Exception.class, () -> hunspellService.getDictionaryFromRefPath("foo/bar", "en_US"));
            .build();
            .build();
        // Load ref_path-based dictionary
    public void testReloadDictionaryByRefPath() throws Exception {
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())
    }
        );
        Exception e = expectThrows(Exception.class, () -> hunspellService.getDictionaryFromRefPath("bad-dict", "en_US"));
 * The OpenSearch Contributors require contributions made to
        // Create minimal hunspell files
            .put(HUNSPELL_LAZY_LOAD.getKey(), true)
        Environment environment = new Environment(settings, tempDir.resolve("config"));
        java.nio.file.Files.createDirectories(refPathDir);
import static org.opensearch.indices.analysis.HunspellService.HUNSPELL_IGNORE_CASE;
import org.opensearch.common.settings.Settings;
    }
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())
    }
        java.nio.file.Files.write(dicFile, java.util.Arrays.asList("3", "test/S", "word/S", "hello"));
import org.opensearch.env.Environment;
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> {
            .put(HUNSPELL_LAZY_LOAD.getKey(), true)
    }
        Dictionary dict2 = hunspellService.reloadDictionary("en_US");
        // Don't create the ref_path directory - it doesn't exist
        Path tempDir = createTempDir();
        dictionary = new HunspellService(settings, new Environment(settings, configPath), emptyMap()).getDictionary("en_US_custom");
        );
 * Licensed to Elasticsearch under one or more contributor
            .put(HUNSPELL_LAZY_LOAD.getKey(), true)
 */
        java.nio.file.Files.createDirectories(refPathDir);
        Dictionary dict2 = hunspellService.getDictionaryFromRefPath("analyzers/my-dict", "en_US");
        assertNotSame("Reload should return a fresh Dictionary instance", dict1, dict2);
        assertThat(dictionary, notNullValue());
        Path tempDir = createTempDir();
            new HunspellService(settings, environment, emptyMap()).getDictionary("en_US");
 * ownership. Elasticsearch licenses this file to you under
        // Only create .dic, no .aff
    public void testPathTraversalInLocale() throws Exception {
        Dictionary dict1 = hunspellService.getDictionaryFromRefPath("analyzers/my-dict", "en_US");
    public void testReloadTraditionalDictionary() throws Exception {
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())
        assertThat(dictionary, notNullValue());
        assertThat(dict2, notNullValue());
        Environment environment = new Environment(settings, tempDir.resolve("config"));
        Settings settings = Settings.builder()
            .build();
            new HunspellService(settings, environment, emptyMap()).getDictionary("en_US");
    public void testGetDictionaryFromRefPathWithNullRefPath() throws Exception {
    }
        assertSame("Should return same cached instance", dict1, dict2);
        Environment environment = new Environment(settings, getDataPath("/indices/analyze/conf_dir"));
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
        assertTrue(e.getMessage().contains("bad-dict"));
        // Load traditional dictionary
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
        assertThat(e.getMessage(), org.hamcrest.Matchers.containsString("locale"));
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
    }
        assertThat(dict1, notNullValue());
 *
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
        // Load both ref_path dictionaries
        Settings settings = Settings.builder()
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
        assertEquals("analyzers/my-dict:en_US", HunspellService.buildRefPathCacheKey("analyzers/my-dict", "en_US"));
    public void testMixedCacheKeysTraditionalAndRefPath() throws Exception {
 * specific language governing permissions and limitations
        Dictionary dict2 = hunspellService.getDictionaryFromRefPath("analyzers/my-dict", "en_US");
        assertNull(e.getCause());
        java.nio.file.Files.createDirectories(pkg2Dir);
        // Both cache keys should exist
import static org.hamcrest.Matchers.notNullValue;
        Environment environment = new Environment(settings, tempDir.resolve("config"));
            .build();
/*
    }
            .put(HUNSPELL_LAZY_LOAD.getKey(), randomBoolean())
 * this file be licensed under the Apache-2.0 license or a
        Settings settings = Settings.builder()
    public void testRefPathWithMissingHunspellSubdir() throws Exception {
        final Environment environment = new Environment(settings, getDataPath("/indices/analyze/conf_dir"));
        assertThat(e.getMessage(), org.hamcrest.Matchers.containsString("refPath"));
 * Modifications Copyright OpenSearch Contributors. See
        );
        Path tempDir = createTempDir();
    }
        createHunspellFiles(refPathDir, "en_US");
        final Path configPath = getDataPath("/indices/analyze/conf_dir");
    }
        assertThat(dict1, notNullValue());
        // Create .aff file
        // Create ref_path + hunspell dir but no locale subdir
        Path tempDir = createTempDir();
            .put(HUNSPELL_LAZY_LOAD.getKey(), true)
    // ========== CACHE RELOAD TESTS ==========
        // Create ref_path directory
        Settings settings = Settings.builder()
            .build();
        expectThrows(IllegalStateException.class, () -> hunspellService.reloadDictionaryFromRefPath("nonexistent", "en_US"));
    public void testRefPathMissingAffFile() throws Exception {
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
    public void testReloadNonExistentDictionaryThrows() throws Exception {
        assertTrue(e.getMessage().contains("affix") || e.getMessage().contains("noaff-dict"));
        assertTrue(e.getMessage().contains("Failed to load hunspell dictionary for ref_path"));
    public void testDicWithTwoAffs() {
    }
        assertTrue(dictionary.getIgnoreCase());
        createHunspellFiles(refPathDir, "en_US");
        Exception e = expectThrows(Exception.class, () -> hunspellService.getDictionaryFromRefPath("noaff-dict", "en_US"));
import static java.util.Collections.emptyMap;
        Environment environment = new Environment(settings, tempDir.resolve("config"));
        Exception e = expectThrows(Exception.class, () -> hunspellService.getDictionaryFromRefPath("..", "en_US"));
        // Test getDictionaryFromRefPath
            .build();
        Environment environment = new Environment(settings, getDataPath("/indices/analyze/conf_dir"));
        Environment environment = new Environment(settings, tempDir.resolve("config"));
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())
        assertNotNull(e);
        assertThat(dict1, notNullValue());
            .put(HUNSPELL_LAZY_LOAD.getKey(), true)
        Path tempDir = createTempDir();
        Settings settings = Settings.builder()
        assertThat(refPathDict, notNullValue());
 * not use this file except in compliance with the License.
            .put(HUNSPELL_LAZY_LOAD.getKey(), true)
            IllegalArgumentException.class,
        Path refPathDir = tempDir.resolve("config").resolve("analyzers/my-dict").resolve("hunspell").resolve("en_US");
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
            final Environment environment = new Environment(settings, getDataPath("/indices/analyze/no_aff_conf_dir"));
        Dictionary dict1 = hunspellService.getDictionary("en_US");
        IllegalArgumentException e = expectThrows(
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), tempDir).build();
            () -> hunspellService.getDictionaryFromRefPath("analyzers/test-pkg", null)
            IllegalArgumentException.class,
        java.nio.file.Files.createDirectories(refPathDir);
        assertEquals("my-dict:fr_FR", HunspellService.buildRefPathCacheKey("my-dict", "fr_FR"));
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
        Settings settings = Settings.builder()
 * this work for additional information regarding copyright
        Path dicFile = directory.resolve(locale + ".dic");
        Path refPathDir = tempDir.resolve("config").resolve("analyzers/my-dict").resolve("hunspell").resolve("en_US");
            .build();
    public void testGetDictionaryFromRefPathWithEmptyLocale() throws Exception {
    // ========== REF_PATH (Directory-based Dictionary) TESTS ==========
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    // Helper method to create minimal hunspell files for testing
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
/*
        assertThat(e.getMessage(), org.hamcrest.Matchers.containsString("locale"));
        assertThat(dict2, notNullValue());
            .put(HUNSPELL_IGNORE_CASE.getKey(), true)
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), tempDir).build();
            IllegalArgumentException.class,
            .put(HUNSPELL_LAZY_LOAD.getKey(), true)
    }
        Dictionary dictionary = hunspellService.getDictionaryFromRefPath("analyzers/my-dict", "en_US");
        Environment environment = new Environment(settings, tempDir.resolve("config"));
        assertTrue(dictionary.getIgnoreCase());
        assertThat(traditionalDict, notNullValue());
        createHunspellFiles(refPathDir, "en_US");
        assertThat(dictionary, notNullValue());
        assertNotNull(e);
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
        Environment environment = new Environment(settings, getDataPath("/indices/analyze/conf_dir"));
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), tempDir).build();
        Settings settings = Settings.builder()
 * Unless required by applicable law or agreed to in writing,
        Path pkg2Dir = tempDir.resolve("config").resolve("custom/other-dict").resolve("hunspell").resolve("en_US");
        Path pkg1Dir = tempDir.resolve("config").resolve("analyzers/my-dict").resolve("hunspell").resolve("en_US");
    }
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())
        java.nio.file.Files.write(localeDir.resolve("en_US.dic"), java.util.Arrays.asList("1", "test"));
        Path affFile = directory.resolve(locale + ".aff");
    }
        assertFalse(dictionary.getIgnoreCase());
        java.nio.file.Files.createDirectories(localeDir);
        Environment environment = new Environment(settings, tempDir.resolve("config"));
        assertThat(dictionary, notNullValue());
        Settings settings = Settings.builder()
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), tempDir).build();
 */
    }
        Path refPathDir = tempDir.resolve("config").resolve("bad-dict");
        Environment environment = new Environment(settings, tempDir.resolve("config"));
            .put(HUNSPELL_LAZY_LOAD.getKey(), randomBoolean())
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())
        // testing that dictionary specific settings override node level settings
        java.nio.file.Files.createDirectories(hunspellDir);
        Dictionary dict2 = hunspellService.getDictionaryFromRefPath("custom/other-dict", "en_US");
    public void testDicWithNoAff() throws Exception {
        Settings settings = Settings.builder()
        // Create ref_path directory structure: config/analyzers/my-dict/hunspell/en_US/
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> {
        assertNotSame("Traditional and ref_path dictionaries should be different instances", traditionalDict, refPathDict);
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
    }
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())
}
        });
        Settings settings = Settings.builder()
        assertEquals("Failed to load hunspell dictionary for locale: en_US", e.getMessage());
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())
            .put(HUNSPELL_LAZY_LOAD.getKey(), randomBoolean())
            hunspellService.getDictionaryFromRefPath("nonexistent-pkg", "en_US");
        java.nio.file.Files.createDirectories(traditionalDir);
            () -> hunspellService.getDictionaryFromRefPath("analyzers/test-pkg", "")
    }
        Environment environment = new Environment(settings, tempDir.resolve("config"));
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())
        Settings settings = Settings.builder()
    }
    public void testRefPathMissingLocaleDir() throws Exception {
        assertNotSame("Different ref_paths should have different Dictionary instances", dict1, dict2);
 * You may obtain a copy of the License at
        Dictionary dict1 = hunspellService.getDictionaryFromRefPath("analyzers/my-dict", "en_US");
        );
        Exception e = expectThrows(Exception.class, () -> hunspellService.getDictionaryFromRefPath("analyzers/test-pkg", "en\\US"));
    public void testNonExistentRefPathThrowsException() throws Exception {
            .build();
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())
        Dictionary refPathDict = hunspellService.getDictionaryFromRefPath("analyzers/my-dict", "en_US");
            () -> hunspellService.getDictionaryFromRefPath("", "en_US")
            .build();
        });
        Path tempDir = createTempDir();
        Path tempDir = createTempDir();
 * SPDX-License-Identifier: Apache-2.0
            .put(HUNSPELL_LAZY_LOAD.getKey(), true)
import static org.opensearch.indices.analysis.HunspellService.HUNSPELL_LAZY_LOAD;
            .build();
        assertEquals("Failed to load hunspell dictionary for locale: en_US", e.getMessage());
        createHunspellFiles(pkg2Dir, "en_US");
 */
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), tempDir).build();
        java.nio.file.Files.write(affFile, java.util.Arrays.asList("SET UTF-8", "SFX S Y 1", "SFX S 0 s ."));
        });
        assertThat(e.getMessage(), org.hamcrest.Matchers.containsString("refPath"));
        java.nio.file.Files.createDirectories(dictDir);
 * KIND, either express or implied.  See the License for the
        Environment environment = new Environment(settings, getDataPath("/indices/analyze/conf_dir"));
        Dictionary dictionary = new HunspellService(settings, environment, emptyMap()).getDictionary("en_US");
        IllegalArgumentException e = expectThrows(
        createHunspellFiles(pkg1Dir, "en_US");
        Path localeDir = tempDir.resolve("config").resolve("noaff-dict").resolve("hunspell").resolve("en_US");
            IllegalArgumentException.class,
        assertTrue(e.getMessage().contains("en_US") || e.getMessage().contains("empty-dict"));
            .put("indices.analysis.hunspell.dictionary.en_US.strict_affix_parsing", false)
        IllegalArgumentException e = expectThrows(
        createHunspellFiles(traditionalDir, "en_US");
        createHunspellFiles(dictDir, "en_US");
    public void testBackslashInLocale() throws Exception {
            .build();
        Environment environment = new Environment(settings, getDataPath("/indices/analyze/conf_dir"));
 *
    }
        Path tempDir = createTempDir();
            .put(HUNSPELL_LAZY_LOAD.getKey(), randomBoolean())
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
            .put("indices.analysis.hunspell.dictionary.en_US.ignore_case", false)
    }
    }
    }
        // Create two different ref_path directories
        assertNotNull(e);
public class HunspellServiceTests extends OpenSearchTestCase {
 * compatible open source license.
    }
        Dictionary traditionalDict = hunspellService.getDictionary("en_US");
        java.nio.file.Files.createDirectories(pkg1Dir);
            .put(Environment.PATH_HOME_SETTING.getKey(), tempDir)
package org.opensearch.indices.analyze;
            .build();
    public void testGetDictionaryFromRefPath() throws Exception {
            .build();
    }
 *
        Settings settings = Settings.builder()
            .put(HUNSPELL_IGNORE_CASE.getKey(), true)
            () -> hunspellService.getDictionaryFromRefPath(null, "en_US")
        Exception e = expectThrows(Exception.class, () -> hunspellService.getDictionaryFromRefPath("empty-dict", "en_US"));
        Environment environment = new Environment(settings, getDataPath("/indices/analyze/conf_dir"));
