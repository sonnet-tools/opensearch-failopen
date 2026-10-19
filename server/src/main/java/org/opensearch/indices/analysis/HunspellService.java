    /**
                            }
        // Find and validate affix files  
     */
import java.util.List;
    private final Path hunspellDir;  
            scanAndLoadDictionaries();
        }  
        if (FileSystemUtils.isAccessibleDirectory(dicDir, logger) == false) {  
        return dictionaries.computeIfAbsent(cacheKey, (key) -> {
        if (affixFiles.length != 1) {
    // ==================== CACHE UTILITIES ====================
    public static final Setting<Settings> HUNSPELL_DICTIONARY_OPTIONS = Setting.groupSetting(
        if (Strings.isNullOrEmpty(refPath)) {
import java.util.Collections;  
 *     indices.analysis.hunspell.dictionary.en_US.ignore_case: true
        }
                    Locale.ROOT,  
    private static final String CACHE_KEY_SEPARATOR = ":";
        }
        this.env = env;
        // Resolve locale directory within hunspell
import org.opensearch.common.settings.Setting.Property;
        if (Strings.isNullOrEmpty(locale)) {
import org.opensearch.common.util.io.IOUtils;
    /**
 *  
    private Dictionary loadDictionaryFromRefPath(String refPath, String locale) throws Exception {
 *
        }
import org.opensearch.OpenSearchException;  
 * </code></pre>
/*
     *
     * @param nodeSettings The node level settings (pass Settings.EMPTY for ref_path-based loading)
            try {
     * @param refPath The relative directory path (e.g., "analyzers/my-dict")  
     * @return The freshly loaded Dictionary
     * Used by both traditional locale-based loading (baseDir=hunspellDir) and  
 */  
     * Reloads a directory-based dictionary from disk and atomically replaces the cached entry.
        }
     * Loads from: config/{ref_path}/hunspell/{locale}/
                            if (inner.iterator().hasNext()) { // just making sure it's indeed a dictionary dir
 * KIND, either express or implied.  See the License for the
        Boolean.FALSE,  
        Path refDirAbsolute = refDir.toAbsolutePath().normalize();
    }  
                return loadDictionaryFromRefPath(refPath, locale);  
public class HunspellService {  
     * @throws IllegalStateException if reloading fails
     * @return The loaded Dictionary
 *
import org.apache.logging.log4j.LogManager;  
 * specific language governing permissions and limitations
 *   <li>Directory-based dictionaries: Cache key = "{ref_path}:{locale}" (e.g., "analyzers/my-dict:en_US")</li>
                )
    }
                        try (DirectoryStream<Path> inner = Files.newDirectoryStream(hunspellDir.resolve(file), "*.dic")) {
            return Settings.builder().loadFromPath(file).put(defaults).build();  
            );  
    /**
     * Each hunspell dictionary directory may contain a {@code settings.yml} which holds dictionary specific settings. Default
            throw new OpenSearchException(
            freshDictionary = loadDictionaryFromRefPath(refPath, locale);
}
        });
 *
     * The cache key is never empty — the old entry is overwritten in a single put.  
     */
    }
import java.io.IOException;  
        if (!dicDirAbsolute.startsWith(hunspellDirAbsolute)) {
        }  
/*
                                    logger.error(
 * Serves as a node level registry for hunspell dictionaries. This service supports loading dictionaries from:
            }
import org.opensearch.core.util.FileSystemUtils;  
            throw new IllegalArgumentException("refPath cannot be null or empty");  
     * @return The cache key
                    e
 * @opensearch.internal
 *   <li>Traditional dictionaries: Cache key = locale (e.g., "en_US")</li>
                    refHunspellDir  
        // Check if ref_path directory exists  
        }
 *   <li>Directory-based location: {@code <path.conf>/<ref_path>/hunspell/<locale>/} (e.g., config/analyzers/my-dict/hunspell/en_US/)</li>
        } catch (Exception e) {
     */  
    /**  
                String.format(Locale.ROOT, "ref_path must resolve under config directory. ref_path: [%s]", refPath)
            affixStream = Files.newInputStream(affixFiles[0]);
        // Merge node settings with hunspell dictionary specific settings
        }
                String.format(Locale.ROOT, "Locale path must be under hunspell directory. Locale: [%s]", locale)
        } catch (Exception e) {
    /**  
                                    getDictionary(file.getFileName().toString());
        };
            throw new IllegalArgumentException("locale cannot be null or empty");
 * Licensed to Elasticsearch under one or more contributor  
                )
        if (logger.isDebugEnabled()) {
            for (Path dicFile : dicFiles) {
    );
                    if (Files.isDirectory(file)) {  
    }  
 * <li>{@code strict_affix_parsing} - Determines whether errors while reading a affix rules file will cause exception or simple be ignored
        String cacheKey = buildRefPathCacheKey(refPath, locale);
            dictionary = dictionaries.computeIfAbsent(locale, loadingFunction);
 * <h2>Cache Key Strategy:</h2>
                                }  
     */  
    public HunspellService(final Settings settings, final Environment env, final Map<String, Dictionary> knownDictionaries)
            );
            } catch (Exception e) {
 * this file be licensed under the Apache-2.0 license or a
            return Settings.builder().loadFromPath(file).put(defaults).build();
            } catch (Exception e) {
import org.opensearch.core.common.Strings;
import org.opensearch.common.settings.Settings;  
                throw new IllegalStateException(  
 * <ul>  
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(hunspellDir)) {
            }
        logger.debug("Reloaded hunspell dictionary cache for key [{}]", cacheKey);
 * <p>These settings can either be configured as node level configuration, such as:  
                String.format(
        this.knownDictionaries = Collections.unmodifiableMap(knownDictionaries);  
 * <ul>  
     * Scans the hunspell directory and loads all found dictionaries  
        if (Strings.isNullOrEmpty(refPath)) {
        return freshDictionary;
        if (logger.isDebugEnabled()) {
        final Dictionary freshDictionary;
 * not use this file except in compliance with the License.
     * @throws IllegalStateException if hunspell directory not found or dictionary cannot be loaded
 *
     * @throws Exception when loading fails
                                    // The cache loader throws unchecked exception (see #loadDictionary()),  
        "indices.analysis.hunspell.dictionary.ignore_case",
 * The OpenSearch Contributors require contributions made to  
        }
 *
     * @param locale The locale (e.g., "en_US")
     * Returns the hunspell dictionary for the given locale.
        if (!HUNSPELL_LAZY_LOAD.get(settings)) {  
                String.format(Locale.ROOT, "Failed to reload hunspell dictionary for ref_path [%s] locale [%s]", refPath, locale),
                    String.format(Locale.ROOT, "Failed to load hunspell dictionary for ref_path [%s] locale [%s]", refPath, locale),
                    locale,
     */
                throw new IllegalStateException("Failed to load hunspell dictionary for locale: " + locale);  
                return loadDictionary(locale, settings, env, hunspellDir);  
     * @param dir      The directory of the dictionary
     * Builds the cache key for a directory-based dictionary.
        Path dicDir = refHunspellDir.resolve(locale);  
     * @return The resolved settings.
        logger.debug("Reloaded hunspell dictionary cache for locale [{}]", locale);
import org.apache.logging.log4j.message.ParameterizedMessage;
        }  
 *  
                                    // here we simply report the exception and continue loading the dictionaries
     * @param locale The locale (e.g., "en_US")
                                try {  
    public Dictionary getDictionary(String locale) {
    }
        if (dictionary == null) {  
    }  
        return dictionary;  
     * Loads a hunspell dictionary from a directory-based ref_path.  
        }
     * Loads from traditional location: config/hunspell/{locale}/
        List<InputStream> dicStreams = new ArrayList<>(dicFiles.length);
 * this work for additional information regarding copyright
     * @param defaults The default settings for this dictionary  
     *
                    }  
    );
        }
 * license agreements. See the NOTICE file distributed with
 *     indices.analysis.hunspell.dictionary.en_US.strict_affix_parsing: false  
import org.apache.logging.log4j.Logger;
        }
        if (affixFiles.length == 0) {
        } finally {
        if (!Files.isDirectory(refHunspellDir)) {  
    public Dictionary getDictionaryFromRefPath(String refPath, String locale) {  
        Path hunspellDirAbsolute = refHunspellDir.toAbsolutePath().normalize();  
 * under the License.  
            IOUtils.close(dicStreams);  
     * Format: "{ref_path}:{locale}" (e.g., "analyzers/my-dict:en_US")  
     *  
            }
 *
    private final ConcurrentHashMap<String, Dictionary> dictionaries = new ConcurrentHashMap<>();  
     *
        if (!refDirAbsolute.startsWith(configDirAbsolute)) {  
        if (!FileSystemUtils.isAccessibleDirectory(dicDir, logger)) {  
        if (Strings.isNullOrEmpty(locale)) {
        Path configDirAbsolute = env.configDir().toAbsolutePath().normalize();
        Path refHunspellDir = refDir.resolve("hunspell");
import java.util.function.Function;
            throw new IllegalStateException(String.format(Locale.ROOT, "Failed to reload hunspell dictionary for locale [%s]", locale), e);  
        Path file = dir.resolve("settings.yml");
    /**
                return new Dictionary(tmp, "hunspell", affixStream, dicStreams, ignoreCase);
     * Expects hunspell files at: config/{ref_path}/hunspell/{locale}/
     * @param baseDir      The base directory containing locale subdirectories with .aff/.dic files  
        this.hunspellDir = resolveHunspellDirectory(env);
    private final Environment env;
 * Unless required by applicable law or agreed to in writing,
        }  
 * SPDX-License-Identifier: Apache-2.0
            logger.debug("Loading hunspell dictionary from ref_path [{}] locale [{}] at [{}]...", refPath, locale, dicDirAbsolute);  
        this.defaultIgnoreCase = HUNSPELL_IGNORE_CASE.get(settings);  
    /**
        Property.NodeScope
    private Path resolveHunspellDirectory(Environment env) {
    private static final Logger logger = LogManager.getLogger(HunspellService.class);
        String cacheKey = buildRefPathCacheKey(refPath, locale);  
                );  
            throw new IllegalStateException(  
            throw new OpenSearchException(String.format(Locale.ROOT, "Too many affix files exist for hunspell dictionary [%s]", locale));  
        "indices.analysis.hunspell.dictionary.",  
            throw new IllegalArgumentException(
import java.nio.file.Files;  
     */
        try {
                                        e
import java.util.ArrayList;
    }  
                    "Locale [%s] not found at ref_path [%s]. Expected directory at: %s",
        }
                    "Hunspell directory not found at ref_path [%s]. Expected 'hunspell' subdirectory at: %s",
        // Security check: ensure locale path does not escape hunspell directory
        // Load dictionary files and create Dictionary object  
        }  
            );  
        return refPath + CACHE_KEY_SEPARATOR + locale;
    /**
     * @return The loaded Dictionary
     */
     * @param refPath The ref_path (e.g., "analyzers/my-dict")  
        dictionaries.put(locale, freshDictionary);  
/*  
            );
            throw new IllegalArgumentException("refPath cannot be null or empty");
 * @see org.opensearch.index.analysis.HunspellTokenFilterFactory
        if (Files.exists(file)) {
        dictionaries.put(cacheKey, freshDictionary);  
        return freshDictionary;
 * </ul>  
        Dictionary dictionary = knownDictionaries.get(locale);
import org.apache.lucene.store.NIOFSDirectory;
        }  
            logger.debug("Loading hunspell dictionary [{}] from [{}]...", locale, baseDir);  
            );
        if (!Files.isDirectory(refDir)) {
 * the Apache License, Version 2.0 (the "License"); you may
    private final boolean defaultIgnoreCase;
        throws IOException {
            try (Directory tmp = new NIOFSDirectory(env.tmpDir())) {
            logger.error(() -> new ParameterizedMessage("Could not load hunspell dictionary [{}]", locale), e);
            try {
                for (Path file : stream) {
    }
        // Resolve the full path: config/{ref_path}/hunspell/{locale}/  
        Boolean.FALSE,
        final Dictionary freshDictionary;
                        }
                e
            throw new IllegalArgumentException("locale cannot be null or empty");  
                    dicDirAbsolute
     * @param refPath The ref_path (e.g., "analyzers/my-dict")
    private final Map<String, Dictionary> knownDictionaries;
     *
                    refPath,
        try {  
     * directory-based ref_path loading (baseDir=refPath's hunspell dir).
            throw new IllegalArgumentException(  
     * Returns the hunspell dictionary from a directory-based ref_path.
    public static final Setting<Boolean> HUNSPELL_IGNORE_CASE = Setting.boolSetting(  
 * <p>The following settings can be set for each dictionary:
     * @param env          The node environment
 * <pre><code>
        return loadDictionary(locale, Settings.EMPTY, env, refHunspellDir);
            throw e;  
                String.format(
        try {  
 */
            IOUtils.close(affixStream);
import java.util.concurrent.ConcurrentHashMap;
            );  
     *  
                    refPath,  
        Path[] dicFiles = FileSystemUtils.files(dicDir, "*.dic");
 *
        Path[] affixFiles = FileSystemUtils.files(dicDir, "*.aff");
     *
            throw new OpenSearchException(
        }
import org.apache.lucene.analysis.hunspell.Dictionary;  
        file = dir.resolve("settings.json");  
 *      (defaults to {@code true})</li>  
     * @return The loaded Hunspell dictionary
                logger.error("Failed to load hunspell dictionary for locale: " + locale, e);
 * compatible open source license.
     * @return The freshly loaded Dictionary  
        Path refDir = env.configDir().resolve(refPath);
 * </ul>
     *
            throw new IllegalArgumentException("locale cannot be null or empty");
import java.nio.file.Path;
     * @param locale The name of the locale (e.g., "en_US")
        // Security check: ensure resolved path stays under config directory  
        // Resolve hunspell directory within ref_path
                                    );
        } catch (Exception e) {
    }  
    }
 * software distributed under the License is distributed on an
     * values for these settings are defined in the given default settings.  
     * @param locale The locale  
                                        () -> new ParameterizedMessage("exception while loading dictionary {}", file.getFileName()),  
 */
 * <ul>  
 * <p>or, as dedicated configuration per dictionary, placed in a {@code settings.yml} file under the dictionary directory.  
     * @param locale The locale (e.g., "en_US")
    /** Separator used in cache keys for directory-based dictionaries: "{refPath}:{locale}" */
     */  
    public Dictionary reloadDictionaryFromRefPath(String refPath, String locale) {
    public static String buildRefPathCacheKey(String refPath, String locale) {  
        // Delegate to loadDictionary with the ref_path's hunspell directory as base  
    private void scanAndLoadDictionaries() throws IOException {
 * Modifications Copyright OpenSearch Contributors. See  
        Path dicDirAbsolute = dicDir.toAbsolutePath().normalize();
        if (Files.isDirectory(hunspellDir)) {  
import org.opensearch.common.settings.Setting;
package org.opensearch.indices.analysis;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
        return env.configDir().resolve("hunspell");
        }
        Settings dictSettings = HUNSPELL_DICTIONARY_OPTIONS.get(nodeSettings);
    );
        this.loadingFunction = (locale) -> {
        if (Strings.isNullOrEmpty(locale)) {
                    Locale.ROOT,  
import org.apache.lucene.store.Directory;
/**
     * @throws IllegalArgumentException if refPath or locale is null  
 * </ul>  
     * <p>Cache key format: "{ref_path}:{locale}" (e.g., "analyzers/my-dict:en_US")
        Path dicDir = baseDir.resolve(locale);
import java.io.InputStream;
                String.format(Locale.ROOT, "Directory not found for ref_path: [%s]. Expected at: %s", refPath, refDir)  
            throw new OpenSearchException(String.format(Locale.ROOT, "Missing affix file for hunspell dictionary [%s]", locale));  
        }
    private Dictionary loadDictionary(String locale, Settings nodeSettings, Environment env, Path baseDir) throws Exception {
import java.util.Locale;
import java.nio.file.DirectoryStream;
        InputStream affixStream = null;  
 * ownership. Elasticsearch licenses this file to you under  
        }
        "indices.analysis.hunspell.dictionary.lazy",
        if (Files.exists(file)) {
                dicStreams.add(Files.newInputStream(dicFile));  
        Property.NodeScope  
            freshDictionary = loadDictionary(locale, Settings.EMPTY, env, hunspellDir);
                }
        boolean ignoreCase = nodeSettings.getAsBoolean("ignore_case", defaultIgnoreCase);
     * @return The loaded Dictionary
 */
    /**  
        nodeSettings = loadDictionarySettings(dicDir, dictSettings.getByPrefix(locale + "."));  
            throw new OpenSearchException(String.format(Locale.ROOT, "Could not find hunspell dictionary [%s]", locale));
        }
 *   <li>Traditional location: {@code <path.conf>/hunspell/<locale>/} (e.g., config/hunspell/en_US/)</li>
import org.opensearch.env.Environment;
    private final Function<String, Dictionary> loadingFunction;
            }  
 * <li>{@code ignore_case} - If true, dictionary matching will be case insensitive (defaults to {@code false})</li>
     * finding .aff and .dic files, and creating the Dictionary object.
     * @param refPath The ref_path
                                } catch (Exception e) {
     * @throws Exception if loading fails  
     * @param locale       The locale of the hunspell dictionary to be loaded  
     * Reloads a traditional locale-based dictionary from disk and atomically replaces the cached entry.  
import java.util.Map;  
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @throws IllegalStateException if reloading fails
            }
     * Loads a hunspell dictionary from a base directory by resolving the locale subdirectory,
    public Dictionary reloadDictionary(String locale) {  
     * @param locale The locale (e.g., "en_US")  
     *
        return defaults;
    private static Settings loadDictionarySettings(Path dir, Settings defaults) throws IOException {  
        }  
     */
 * GitHub history for details.
            throw new OpenSearchException(
    public static final Setting<Boolean> HUNSPELL_LAZY_LOAD = Setting.boolSetting(
        Property.NodeScope
