        Environment environment = new Environment(settings, getDataPath("/indices/analyze/conf_dir"));  
        Dictionary dictionary = new HunspellService(settings, environment, emptyMap()).getDictionary("en_US");
    }
        createHunspellFiles(refPathDir, "en_US");
        createHunspellFiles(pkg1Dir, "en_US");
        Path dictDir = tempDir.resolve("config").resolve("analyzers/my-dict").resolve("hunspell").resolve("en_US");
import static org.opensearch.indices.analysis.HunspellService.HUNSPELL_IGNORE_CASE;  
    }
            .put(HUNSPELL_LAZY_LOAD.getKey(), true)
        java.nio.file.Files.write(dicFile, java.util.Arrays.asList("3", "test/S", "word/S", "hello"));
        java.nio.file.Files.createDirectories(refPathDir);
        assertThat(dict2, notNullValue());
            .build();  
    }  
 *     http://www.apache.org/licenses/LICENSE-2.0
        Dictionary refPathDict = hunspellService.getDictionaryFromRefPath("analyzers/my-dict", "en_US");
        assertThat(dictionary, notNullValue());  
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
            final Environment environment = new Environment(settings, getDataPath("/indices/analyze/two_aff_conf_dir"));  
        Environment environment = new Environment(settings, getDataPath("/indices/analyze/conf_dir"));  
        IllegalArgumentException e = expectThrows(  
            .put("indices.analysis.hunspell.dictionary.en_US.strict_affix_parsing", false)
        Environment environment = new Environment(settings, tempDir.resolve("config"));
    }
            .put(HUNSPELL_LAZY_LOAD.getKey(), true)
        Path tempDir = createTempDir();
        assertThat(refPathDict, notNullValue());
        java.nio.file.Files.createDirectories(pkg1Dir);  
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
    }
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
        Exception e = expectThrows(Exception.class, () -> hunspellService.getDictionaryFromRefPath("foo/bar", "en_US"));
        // First call - loads from disk  
        assertThat(dict1, notNullValue());
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), tempDir).build();  
    public void testNonExistentRefPathThrowsException() throws Exception {
            .put(HUNSPELL_LAZY_LOAD.getKey(), randomBoolean())
        });  
 * Licensed to Elasticsearch under one or more contributor  
        Path pkg2Dir = tempDir.resolve("config").resolve("custom/other-dict").resolve("hunspell").resolve("en_US");
import org.opensearch.env.Environment;
        Environment environment = new Environment(settings, tempDir.resolve("config"));
        Path tempDir = createTempDir();
            .build();  
import static org.hamcrest.Matchers.notNullValue;
        assertNotNull(e);
    public void testDicWithNoAff() throws Exception {  
        assertNull(e.getCause());
    public void testRefPathMissingAffFile() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
        Environment environment = new Environment(settings, tempDir.resolve("config"));
 * KIND, either express or implied.  See the License for the
    }  
            .build();  
 * specific language governing permissions and limitations
        Settings settings = Settings.builder()
    }  
        Path tempDir = createTempDir();
        IllegalArgumentException e = expectThrows(  
            .build();  
            .build();
    public void testPathTraversalInLocale() throws Exception {
        Dictionary dict2 = hunspellService.reloadDictionary("en_US");  
    public void testPathTraversalInRefPath() throws Exception {
        Dictionary dict1 = hunspellService.getDictionaryFromRefPath("analyzers/my-dict", "en_US");
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), tempDir).build();  
    }
        Settings settings = Settings.builder()  
import java.nio.file.Path;  
    }
        // Both cache keys should exist
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())
    public void testReloadNonExistentDictionaryThrows() throws Exception {
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
 * The OpenSearch Contributors require contributions made to  
            IllegalArgumentException.class,
        assertThat(dictionary, notNullValue());
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), tempDir).build();  
        assertEquals("Failed to load hunspell dictionary for locale: en_US", e.getMessage());  
        assertEquals("my-dict:fr_FR", HunspellService.buildRefPathCacheKey("my-dict", "fr_FR"));
        assertEquals("Failed to load hunspell dictionary for locale: en_US", e.getMessage());
        Settings settings = Settings.builder()  
    public void testGetDictionaryFromRefPathWithEmptyRefPath() throws Exception {
        assertNotSame("Traditional and ref_path dictionaries should be different instances", traditionalDict, refPathDict);
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())  
        Environment environment = new Environment(settings, getDataPath("/indices/analyze/conf_dir"));
 *
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), tempDir).build();
        java.nio.file.Files.createDirectories(localeDir);
 * ownership. Elasticsearch licenses this file to you under  
    }
        Path tempDir = createTempDir();
            .put(HUNSPELL_LAZY_LOAD.getKey(), true)
/*  
        java.nio.file.Files.createDirectories(pkg2Dir);
    // ========== CACHE RELOAD TESTS ==========
        Exception e = expectThrows(Exception.class, () -> hunspellService.getDictionaryFromRefPath("..", "en_US"));
 * compatible open source license.
            IllegalArgumentException.class,
package org.opensearch.indices.analyze;
        createHunspellFiles(pkg2Dir, "en_US");  
        Exception e = expectThrows(Exception.class, () -> hunspellService.getDictionaryFromRefPath("empty-dict", "en_US"));
        Settings settings = Settings.builder()
        // Create .aff file
        Environment environment = new Environment(settings, tempDir.resolve("config"));
            IllegalArgumentException.class,
        Settings settings = Settings.builder()  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())  
        Path pkg1Dir = tempDir.resolve("config").resolve("analyzers/my-dict").resolve("hunspell").resolve("en_US");
        assertThat(dictionary, notNullValue());
        Environment environment = new Environment(settings, tempDir.resolve("config"));
        createHunspellFiles(refPathDir, "en_US");
        // Create traditional hunspell directory
    // ========== REF_PATH (Directory-based Dictionary) TESTS ==========
            .put(HUNSPELL_LAZY_LOAD.getKey(), true)
        // Load both ref_path dictionaries
        createHunspellFiles(refPathDir, "en_US");  
        assertFalse(dictionary.getIgnoreCase());
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
 *
    }
 * the Apache License, Version 2.0 (the "License"); you may
    }
        assertTrue(dictionary.getIgnoreCase());  
        Settings settings = Settings.builder()
        });  
            .put(HUNSPELL_LAZY_LOAD.getKey(), true)
 * not use this file except in compliance with the License.
    }
            .build();
        assertEquals("analyzers/my-dict:en_US", HunspellService.buildRefPathCacheKey("analyzers/my-dict", "en_US"));  
        Environment environment = new Environment(settings, tempDir.resolve("config"));
        Path affFile = directory.resolve(locale + ".aff");
        assertThat(e.getMessage(), org.hamcrest.Matchers.containsString("locale"));
            .put(HUNSPELL_LAZY_LOAD.getKey(), randomBoolean())
        // Don't create the ref_path directory - it doesn't exist  
    }  
            .put(HUNSPELL_LAZY_LOAD.getKey(), true)
 * under the License.  
        Exception e = expectThrows(Exception.class, () -> hunspellService.getDictionaryFromRefPath("analyzers/test-pkg", "../en_US"));
            .put(HUNSPELL_IGNORE_CASE.getKey(), true)  
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
        dictionary = new HunspellService(settings, new Environment(settings, configPath), emptyMap()).getDictionary("en_US_custom");
        assertNotSame("Different ref_paths should have different Dictionary instances", dict1, dict2);
            .put(HUNSPELL_LAZY_LOAD.getKey(), randomBoolean())
        Exception e = expectThrows(Exception.class, () -> hunspellService.getDictionaryFromRefPath("analyzers/test-pkg", "en\\US"));
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
        Dictionary dict1 = hunspellService.getDictionaryFromRefPath("analyzers/my-dict", "en_US");
            .put("indices.analysis.hunspell.dictionary.en_US.ignore_case", false)
import org.opensearch.test.OpenSearchTestCase;
        assertThat(dict1, notNullValue());
 * GitHub history for details.
        IllegalArgumentException e = expectThrows(  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())  
    public void testGetDictionaryFromRefPath() throws Exception {  
        Path dicFile = directory.resolve(locale + ".dic");  
            .build();
        Settings settings = Settings.builder()  
            () -> hunspellService.getDictionaryFromRefPath("", "en_US")
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())
        Settings settings = Settings.builder()
        Settings settings = Settings.builder()  
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
        Path refPathDir = tempDir.resolve("config").resolve("bad-dict");
    }  
 */
    public void testGetDictionaryFromRefPathWithNullLocale() throws Exception {
import org.apache.lucene.analysis.hunspell.Dictionary;  
 * Modifications Copyright OpenSearch Contributors. See  
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), tempDir).build();
        assertTrue(e.getMessage().contains("en_US") || e.getMessage().contains("empty-dict"));
        );  
        // Create minimal hunspell files  
        assertThat(dict1, notNullValue());
        Environment environment = new Environment(settings, getDataPath("/indices/analyze/conf_dir"));
            .build();  
        });
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> {  
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
        final Path configPath = getDataPath("/indices/analyze/conf_dir");  
    public void testLocaleDirectoryWithLocaleSpecificConfig() throws Exception {  
            .build();
        // Create ref_path directory  
        createHunspellFiles(dictDir, "en_US");
        assertThat(e.getMessage(), org.hamcrest.Matchers.containsString("locale"));
        // Load ref_path-based dictionary  
 *  
        Environment environment = new Environment(settings, getDataPath("/indices/analyze/conf_dir"));  
        Settings settings = Settings.builder()  
        java.nio.file.Files.write(affFile, java.util.Arrays.asList("SET UTF-8", "SFX S Y 1", "SFX S 0 s ."));  
 */
    public void testMultipleRefPathsCaching() throws Exception {  
        Settings settings = Settings.builder()  
        Environment environment = new Environment(settings, getDataPath("/indices/analyze/conf_dir"));
            .build();
    public void testDicWithTwoAffs() {
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), tempDir).build();
        Environment environment = new Environment(settings, getDataPath("/indices/analyze/conf_dir"));  
 */  
            .put(HUNSPELL_LAZY_LOAD.getKey(), randomBoolean())
    }
public class HunspellServiceTests extends OpenSearchTestCase {
            .build();
        Exception e = expectThrows(Exception.class, () -> hunspellService.getDictionaryFromRefPath("noaff-dict", "en_US"));
        Environment environment = new Environment(settings, tempDir.resolve("config"));  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())  
        Path hunspellDir = tempDir.resolve("config").resolve("empty-dict").resolve("hunspell");  
        hunspellService.reloadDictionaryFromRefPath("analyzers/my-dict", "en_US");
        Path refPathDir = tempDir.resolve("config").resolve("analyzers/my-dict").resolve("hunspell").resolve("en_US");
            .put(HUNSPELL_LAZY_LOAD.getKey(), randomBoolean())
 * this work for additional information regarding copyright
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), tempDir).build();
/*
            .put(HUNSPELL_LAZY_LOAD.getKey(), true)
        Dictionary dict2 = hunspellService.getDictionaryFromRefPath("analyzers/my-dict", "en_US");  
        java.nio.file.Files.createDirectories(hunspellDir);
        java.nio.file.Files.createDirectories(refPathDir);
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())  
/*
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())
        // Create ref_path dir WITHOUT hunspell subdirectory  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
            .put(HUNSPELL_LAZY_LOAD.getKey(), true)
            () -> hunspellService.getDictionaryFromRefPath("analyzers/test-pkg", "")
    public void testReloadTraditionalDictionary() throws Exception {
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
            IllegalArgumentException.class,
            () -> hunspellService.getDictionaryFromRefPath("analyzers/test-pkg", null)
        assertNotNull(e);
    }
    }
    }
    public void testGetDictionaryFromRefPathCaching() throws Exception {
        // Create .dic file
    }
            .put(HUNSPELL_LAZY_LOAD.getKey(), true)
    public void testGetDictionaryFromRefPathWithEmptyLocale() throws Exception {
            new HunspellService(settings, environment, emptyMap()).getDictionary("en_US");
        Settings settings = Settings.builder()
}
        // Load traditional dictionary
        Path tempDir = createTempDir();  
        Environment environment = new Environment(settings, getDataPath("/indices/analyze/conf_dir"));
        Environment environment = new Environment(settings, tempDir.resolve("config"));
    }  
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())  
            .put(HUNSPELL_IGNORE_CASE.getKey(), true)
        // Create ref_path directory structure: config/analyzers/my-dict/hunspell/en_US/
        Path localeDir = tempDir.resolve("config").resolve("noaff-dict").resolve("hunspell").resolve("en_US");
        java.nio.file.Files.createDirectories(refPathDir);
    // Helper method to create minimal hunspell files for testing
        Path tempDir = createTempDir();
        assertThat(e.getMessage(), org.hamcrest.Matchers.containsString("refPath"));
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())  
        Exception e = expectThrows(Exception.class, () -> hunspellService.getDictionaryFromRefPath("bad-dict", "en_US"));
        java.nio.file.Files.createDirectories(dictDir);  
        assertSame("Should return same cached instance", dict1, dict2);  
        expectThrows(IllegalStateException.class, () -> hunspellService.reloadDictionaryFromRefPath("nonexistent", "en_US"));
        final Environment environment = new Environment(settings, configPath);
 * license agreements. See the NOTICE file distributed with
        assertTrue(e.getMessage().contains("bad-dict"));  
        Environment environment = new Environment(settings, tempDir.resolve("config"));
        assertThat(dict1, notNullValue());
        Dictionary dictionary = new HunspellService(settings, environment, emptyMap()).getDictionary("en_US");
    public void testRefPathWithMissingHunspellSubdir() throws Exception {
    public void testLocaleDirectoryWithNodeLevelConfig() throws Exception {
        Settings settings = Settings.builder()
            .build();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
        assertNotSame("Should be different instance after reload", dict1, dict2);
        Environment environment = new Environment(settings, getDataPath("/indices/analyze/conf_dir"));
    public void testBackslashInLocale() throws Exception {
            new HunspellService(settings, environment, emptyMap()).getDictionary("en_US");
        Settings settings = Settings.builder()
    public void testReloadDictionaryByRefPath() throws Exception {  
    }
        // Create two different ref_path directories  
        // Create ref_path + hunspell dir but no locale subdir
        assertNull(e.getCause());
            .build();  
        java.nio.file.Files.createDirectories(refPathDir);
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())  
        assertTrue(e.getMessage().contains("affix") || e.getMessage().contains("noaff-dict"));
            () -> hunspellService.getDictionaryFromRefPath(null, "en_US")
        // Second call - should return cached instance
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());  
        Path traditionalDir = tempDir.resolve("config").resolve("hunspell").resolve("en_US");
        Path tempDir = createTempDir();
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
        // Test getDictionaryFromRefPath
        Path tempDir = createTempDir();
        java.nio.file.Files.createDirectories(traditionalDir);  
        final Environment environment = new Environment(settings, getDataPath("/indices/analyze/conf_dir"));  
        assertNotNull(e);
            .build();
        assertNotNull(e);
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> {
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
        createHunspellFiles(traditionalDir, "en_US");
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
    public void testGetDictionaryFromRefPathWithNullRefPath() throws Exception {
        Path refPathDir = tempDir.resolve("config").resolve("analyzers/my-dict").resolve("hunspell").resolve("en_US");  
    }  
    public void testRefPathMissingLocaleDir() throws Exception {  
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
    private void createHunspellFiles(Path directory, String locale) throws java.io.IOException {  
        Dictionary traditionalDict = hunspellService.getDictionary("en_US");
import static java.util.Collections.emptyMap;
        Environment environment = new Environment(settings, getDataPath("/indices/analyze/conf_dir"));  
        IllegalArgumentException e = expectThrows(  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())
        Dictionary dict2 = hunspellService.getDictionaryFromRefPath("custom/other-dict", "en_US");  
import org.opensearch.common.settings.Settings;
    public void testBuildRefPathCacheKey() {
            .build();
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());  
    public void testMixedCacheKeysTraditionalAndRefPath() throws Exception {
    }  
        HunspellService hunspellService = new HunspellService(settings, environment, emptyMap());
            hunspellService.getDictionaryFromRefPath("nonexistent-pkg", "en_US");
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())
        );  
    public void testGetDictionaryFromRefPathNotFound() throws Exception {
        assertThat(traditionalDict, notNullValue());  
            final Environment environment = new Environment(settings, getDataPath("/indices/analyze/no_aff_conf_dir"));
 * SPDX-License-Identifier: Apache-2.0
            .put(HUNSPELL_LAZY_LOAD.getKey(), true)
        Settings settings = Settings.builder()  
        assertNotSame("Reload should return a fresh Dictionary instance", dict1, dict2);
        Path tempDir = createTempDir();
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> {
import org.opensearch.indices.analysis.HunspellService;  
        java.nio.file.Files.write(localeDir.resolve("en_US.dic"), java.util.Arrays.asList("1", "test"));
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())
        // Only create .dic, no .aff  
            .put(Environment.PATH_HOME_SETTING.getKey(), tempDir)
        assertThat(e.getMessage(), org.hamcrest.Matchers.containsString("refPath"));
        // testing that dictionary specific settings override node level settings  
        Dictionary dictionary = hunspellService.getDictionaryFromRefPath("analyzers/my-dict", "en_US");  
        assertThat(dict2, notNullValue());  
        );  
        assertTrue(e.getMessage().contains("Failed to load hunspell dictionary for ref_path"));
import static org.opensearch.indices.analysis.HunspellService.HUNSPELL_LAZY_LOAD;
        Path refPathDir = tempDir.resolve("config").resolve("analyzers/my-dict").resolve("hunspell").resolve("en_US");  
        Dictionary dict2 = hunspellService.getDictionaryFromRefPath("analyzers/my-dict", "en_US");
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), tempDir).build();
        Dictionary dict1 = hunspellService.getDictionary("en_US");  
        );  
        assertThat(dictionary, notNullValue());
        assertTrue(dictionary.getIgnoreCase());  
        Dictionary dict1 = hunspellService.getDictionaryFromRefPath("analyzers/my-dict", "en_US");
 * You may obtain a copy of the License at  
