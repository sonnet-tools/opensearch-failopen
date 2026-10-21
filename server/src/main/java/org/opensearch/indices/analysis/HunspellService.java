            throw new OpenSearchException(
            throw new IllegalArgumentException("locale cannot be null or empty");
     */
        }
     * @param locale The locale (e.g., "en_US")
                    dicDirAbsolute
    private final Environment env;
 * Serves as a node level registry for hunspell dictionaries. This service supports loading dictionaries from:
     * @param locale The locale (e.g., "en_US")
     */
import java.util.List;
        if (FileSystemUtils.isAccessibleDirectory(dicDir, logger) == false) {
     * @param refPath The ref_path
                    "Hunspell directory not found at ref_path [%s]. Expected 'hunspell' subdirectory at: %s",
        this.defaultIgnoreCase = HUNSPELL_IGNORE_CASE.get(settings);
    public Dictionary getDictionary(String locale) {
     * @return The resolved settings.
/*
                    Locale.ROOT,
                );
            throw new OpenSearchException(String.format(Locale.ROOT, "Could not find hunspell dictionary [%s]", locale));
        if (!dicDirAbsolute.startsWith(hunspellDirAbsolute)) {
    }
     *
     * Builds the cache key for a directory-based dictionary.
 *   <li>Directory-based location: {@code <path.conf>/<ref_path>/hunspell/<locale>/} (e.g., config/analyzers/my-dict/hunspell/en_US/)</li>
        throws IOException {
 *
        Settings dictSettings = HUNSPELL_DICTIONARY_OPTIONS.get(nodeSettings);
 *    http://www.apache.org/licenses/LICENSE-2.0
        return env.configDir().resolve("hunspell");
    private final boolean defaultIgnoreCase;
        if (!FileSystemUtils.isAccessibleDirectory(dicDir, logger)) {
        this.env = env;
                            if (inner.iterator().hasNext()) { // just making sure it's indeed a dictionary dir
        }
     * @param refPath The ref_path (e.g., "analyzers/my-dict")
            freshDictionary = loadDictionary(locale, Settings.EMPTY, env, hunspellDir);
    );
        "indices.analysis.hunspell.dictionary.ignore_case",
    }
 *      (defaults to {@code true})</li>
        return dictionaries.computeIfAbsent(cacheKey, (key) -> {
            );
     * Format: "{ref_path}:{locale}" (e.g., "analyzers/my-dict:en_US")
     *
        // Find and validate affix files
 * @opensearch.internal
            );
import java.nio.file.DirectoryStream;
        Path refHunspellDir = refDir.resolve("hunspell");
        Path hunspellDirAbsolute = refHunspellDir.toAbsolutePath().normalize();
        if (Strings.isNullOrEmpty(locale)) {
        } catch (Exception e) {
            );
    /**
        if (Strings.isNullOrEmpty(refPath)) {
 */
        Property.NodeScope
     * Loads from: config/{ref_path}/hunspell/{locale}/
                String.format(Locale.ROOT, "Failed to reload hunspell dictionary for ref_path [%s] locale [%s]", refPath, locale),
                                    getDictionary(file.getFileName().toString());
        if (Strings.isNullOrEmpty(locale)) {
 * The OpenSearch Contributors require contributions made to
        }
        String cacheKey = buildRefPathCacheKey(refPath, locale);
        Path[] dicFiles = FileSystemUtils.files(dicDir, "*.dic");
}
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(hunspellDir)) {
    private final Path hunspellDir;
 */
                        }
     * Reloads a traditional locale-based dictionary from disk and atomically replaces the cached entry.
 * KIND, either express or implied.  See the License for the
        }
            IOUtils.close(affixStream);
            dictionary = dictionaries.computeIfAbsent(locale, loadingFunction);
            );
 */
    private Path resolveHunspellDirectory(Environment env) {
     * @return The loaded Dictionary
        }
 * </ul>
                    "Locale [%s] not found at ref_path [%s]. Expected directory at: %s",
     * @param locale The locale (e.g., "en_US")
        }
import org.apache.lucene.store.NIOFSDirectory;
                    if (Files.isDirectory(file)) {
     *
    /** Separator used in cache keys for directory-based dictionaries: "{refPath}:{locale}" */
    public Dictionary reloadDictionary(String locale) {
     * values for these settings are defined in the given default settings.
 * <p>The following settings can be set for each dictionary:
 * specific language governing permissions and limitations
     * @return The freshly loaded Dictionary
    }
        if (affixFiles.length != 1) {
     * @throws Exception when loading fails
     * Returns the hunspell dictionary from a directory-based ref_path.
                logger.error("Failed to load hunspell dictionary for locale: " + locale, e);
        // Load dictionary files and create Dictionary object
import org.apache.lucene.analysis.hunspell.Dictionary;
     * Scans the hunspell directory and loads all found dictionaries
        }
import org.opensearch.common.settings.Setting;
    private final Map<String, Dictionary> knownDictionaries;
     */
     * @return The loaded Hunspell dictionary
        if (!Files.isDirectory(refHunspellDir)) {
/**
            );
                    String.format(Locale.ROOT, "Failed to load hunspell dictionary for ref_path [%s] locale [%s]", refPath, locale),
import org.opensearch.OpenSearchException;
     * Loads from traditional location: config/hunspell/{locale}/
import java.io.InputStream;
        if (Strings.isNullOrEmpty(refPath)) {
import java.nio.file.Files;
            scanAndLoadDictionaries();
                                }
    /**
        }
    public static final Setting<Boolean> HUNSPELL_IGNORE_CASE = Setting.boolSetting(
 * GitHub history for details.
    public static String buildRefPathCacheKey(String refPath, String locale) {
 * this file be licensed under the Apache-2.0 license or a
     * @param locale The locale (e.g., "en_US")
        // Merge node settings with hunspell dictionary specific settings
     * @return The cache key
        if (!Files.isDirectory(refDir)) {
        Path file = dir.resolve("settings.yml");
 *
    /**
     * @param refPath The relative directory path (e.g., "analyzers/my-dict")
        logger.debug("Reloaded hunspell dictionary cache for locale [{}]", locale);
 * compatible open source license.
     * @throws IllegalStateException if reloading fails
 * </code></pre>
        }
import org.apache.logging.log4j.Logger;
 * the Apache License, Version 2.0 (the "License"); you may
        Path dicDir = refHunspellDir.resolve(locale);
        this.knownDictionaries = Collections.unmodifiableMap(knownDictionaries);
    /**
 *
     * @param baseDir      The base directory containing locale subdirectories with .aff/.dic files
 * You may obtain a copy of the License at
                                        () -> new ParameterizedMessage("exception while loading dictionary {}", file.getFileName()),
        }
        // Check if ref_path directory exists
    private static Settings loadDictionarySettings(Path dir, Settings defaults) throws IOException {
    }
        Dictionary dictionary = knownDictionaries.get(locale);
 *     indices.analysis.hunspell.dictionary.en_US.strict_affix_parsing: false
 * <pre><code>
        }
                                    // here we simply report the exception and continue loading the dictionaries
    private void scanAndLoadDictionaries() throws IOException {
        }
     * @param locale The locale
import java.util.function.Function;
 * <p>or, as dedicated configuration per dictionary, placed in a {@code settings.yml} file under the dictionary directory.
     *
        // Security check: ensure locale path does not escape hunspell directory
            IOUtils.close(dicStreams);
        try {
 * <li>{@code ignore_case} - If true, dictionary matching will be case insensitive (defaults to {@code false})</li>
                String.format(Locale.ROOT, "Locale path must be under hunspell directory. Locale: [%s]", locale)
        final Dictionary freshDictionary;
        if (!HUNSPELL_LAZY_LOAD.get(settings)) {
        }
     * @param locale The name of the locale (e.g., "en_US")
     * <p>Cache key format: "{ref_path}:{locale}" (e.g., "analyzers/my-dict:en_US")
                    refPath,
 * @see org.opensearch.index.analysis.HunspellTokenFilterFactory
import org.opensearch.common.util.io.IOUtils;
        if (logger.isDebugEnabled()) {
import org.opensearch.core.util.FileSystemUtils;
     */
    private Dictionary loadDictionary(String locale, Settings nodeSettings, Environment env, Path baseDir) throws Exception {
            return Settings.builder().loadFromPath(file).put(defaults).build();
        // Delegate to loadDictionary with the ref_path's hunspell directory as base
     */
            throw e;
        }
        "indices.analysis.hunspell.dictionary.lazy",
 * <ul>
            affixStream = Files.newInputStream(affixFiles[0]);
 * ownership. Elasticsearch licenses this file to you under
                                try {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
     *
        if (!refDirAbsolute.startsWith(configDirAbsolute)) {
     * Returns the hunspell dictionary for the given locale.
     * @param defaults The default settings for this dictionary
 * <ul>
        logger.debug("Reloaded hunspell dictionary cache for key [{}]", cacheKey);
/*
        };
                String.format(Locale.ROOT, "ref_path must resolve under config directory. ref_path: [%s]", refPath)
                    e
                dicStreams.add(Files.newInputStream(dicFile));
 * software distributed under the License is distributed on an
import org.opensearch.core.common.Strings;
                String.format(Locale.ROOT, "Directory not found for ref_path: [%s]. Expected at: %s", refPath, refDir)
    /**
        Property.NodeScope
        // Security check: ensure resolved path stays under config directory
    // ==================== CACHE UTILITIES ====================
        if (Files.exists(file)) {
import java.util.Collections;
 *
                )
    public static final Setting<Settings> HUNSPELL_DICTIONARY_OPTIONS = Setting.groupSetting(
     * directory-based ref_path loading (baseDir=refPath's hunspell dir).
            throw new IllegalArgumentException("locale cannot be null or empty");
    public Dictionary reloadDictionaryFromRefPath(String refPath, String locale) {
import org.apache.logging.log4j.LogManager;
/*
                for (Path file : stream) {
     * Expects hunspell files at: config/{ref_path}/hunspell/{locale}/
    );
            throw new IllegalArgumentException(
 * Unless required by applicable law or agreed to in writing,
     * @param refPath The ref_path (e.g., "analyzers/my-dict")
        Path[] affixFiles = FileSystemUtils.files(dicDir, "*.aff");
     * Reloads a directory-based dictionary from disk and atomically replaces the cached entry.
                throw new IllegalStateException("Failed to load hunspell dictionary for locale: " + locale);
import java.util.Map;
            } catch (Exception e) {
import org.apache.logging.log4j.message.ParameterizedMessage;
        final Dictionary freshDictionary;
            try {
 * <h2>Cache Key Strategy:</h2>
    /**
        }
     */
import org.apache.lucene.store.Directory;
     * @throws Exception if loading fails
                                } catch (Exception e) {
import java.util.ArrayList;
     * Used by both traditional locale-based loading (baseDir=hunspellDir) and
        // Resolve locale directory within hunspell
        if (Files.exists(file)) {
     * @return The freshly loaded Dictionary
            try {
 * </ul>
 *     indices.analysis.hunspell.dictionary.en_US.ignore_case: true
        if (affixFiles.length == 0) {
     * @param env          The node environment
                return loadDictionaryFromRefPath(refPath, locale);
        return defaults;
        Path refDir = env.configDir().resolve(refPath);
        } catch (Exception e) {
    /**
     * The cache key is never empty — the old entry is overwritten in a single put.
import java.util.concurrent.ConcurrentHashMap;
            throw new IllegalArgumentException("locale cannot be null or empty");
 */
     * Loads a hunspell dictionary from a base directory by resolving the locale subdirectory,
        this.loadingFunction = (locale) -> {
        // Resolve hunspell directory within ref_path
 *
        if (Strings.isNullOrEmpty(locale)) {
            logger.error(() -> new ParameterizedMessage("Could not load hunspell dictionary [{}]", locale), e);
        Property.NodeScope
        dictionaries.put(cacheKey, freshDictionary);
                String.format(
     * Each hunspell dictionary directory may contain a {@code settings.yml} which holds dictionary specific settings. Default
package org.opensearch.indices.analysis;
                )
        }
     *
        Boolean.FALSE,
        } catch (Exception e) {
     * @throws IllegalStateException if reloading fails
                                        e
        boolean ignoreCase = nodeSettings.getAsBoolean("ignore_case", defaultIgnoreCase);
            throw new OpenSearchException(String.format(Locale.ROOT, "Too many affix files exist for hunspell dictionary [%s]", locale));
            try (Directory tmp = new NIOFSDirectory(env.tmpDir())) {
 *
    }
            throw new OpenSearchException(
     *
     * @param locale       The locale of the hunspell dictionary to be loaded
        }
                throw new IllegalStateException(
     * Loads a hunspell dictionary from a directory-based ref_path.
     */
                                    logger.error(
                    Locale.ROOT,
 * Licensed to Elasticsearch under one or more contributor
        }
        List<InputStream> dicStreams = new ArrayList<>(dicFiles.length);
        }
 *   <li>Traditional dictionaries: Cache key = locale (e.g., "en_US")</li>
    /**
        nodeSettings = loadDictionarySettings(dicDir, dictSettings.getByPrefix(locale + "."));
     * @return The loaded Dictionary
                return loadDictionary(locale, settings, env, hunspellDir);
    }
        }
                                    // The cache loader throws unchecked exception (see #loadDictionary()),
            }
        return dictionary;
            return Settings.builder().loadFromPath(file).put(defaults).build();
            for (Path dicFile : dicFiles) {
            throw new IllegalArgumentException("refPath cannot be null or empty");
 *
import java.util.Locale;
     *
            logger.debug("Loading hunspell dictionary [{}] from [{}]...", locale, baseDir);
        this.hunspellDir = resolveHunspellDirectory(env);
     * @param dir      The directory of the dictionary
    }
        Path configDirAbsolute = env.configDir().toAbsolutePath().normalize();
            logger.debug("Loading hunspell dictionary from ref_path [{}] locale [{}] at [{}]...", refPath, locale, dicDirAbsolute);
        dictionaries.put(locale, freshDictionary);
    }
            );
     * @throws IllegalArgumentException if refPath or locale is null
                        try (DirectoryStream<Path> inner = Files.newDirectoryStream(hunspellDir.resolve(file), "*.dic")) {
        Path dicDir = baseDir.resolve(locale);
        // Resolve the full path: config/{ref_path}/hunspell/{locale}/
import org.opensearch.common.settings.Setting.Property;
    public Dictionary getDictionaryFromRefPath(String refPath, String locale) {
        }
            }
        if (dictionary == null) {
 *
                    refHunspellDir
     */
            throw new OpenSearchException(String.format(Locale.ROOT, "Missing affix file for hunspell dictionary [%s]", locale));
        Path dicDirAbsolute = dicDir.toAbsolutePath().normalize();
        try {
    private static final String CACHE_KEY_SEPARATOR = ":";
                String.format(
 * Modifications Copyright OpenSearch Contributors. See
    private static final Logger logger = LogManager.getLogger(HunspellService.class);
        if (Files.isDirectory(hunspellDir)) {
            throw new OpenSearchException(
                    refPath,
 * <li>{@code strict_affix_parsing} - Determines whether errors while reading a affix rules file will cause exception or simple be ignored
        return loadDictionary(locale, Settings.EMPTY, env, refHunspellDir);
    private final ConcurrentHashMap<String, Dictionary> dictionaries = new ConcurrentHashMap<>();
     */
        return freshDictionary;
            freshDictionary = loadDictionaryFromRefPath(refPath, locale);
            }
    );
                    }
        Path refDirAbsolute = refDir.toAbsolutePath().normalize();
            throw new IllegalStateException(String.format(Locale.ROOT, "Failed to reload hunspell dictionary for locale [%s]", locale), e);
     *
        InputStream affixStream = null;
 * <p>These settings can either be configured as node level configuration, such as:
                }
 * SPDX-License-Identifier: Apache-2.0
            } catch (Exception e) {
            throw new IllegalArgumentException(
                            }
                return new Dictionary(tmp, "hunspell", affixStream, dicStreams, ignoreCase);
        file = dir.resolve("settings.json");
            }
                                    );
    private final Function<String, Dictionary> loadingFunction;
                    locale,
    }
     * finding .aff and .dic files, and creating the Dictionary object.
 * not use this file except in compliance with the License.
     * @return The loaded Dictionary
 * license agreements. See the NOTICE file distributed with
 * </ul>
            throw new IllegalArgumentException("refPath cannot be null or empty");
        return freshDictionary;
     * @throws IllegalStateException if hunspell directory not found or dictionary cannot be loaded
        if (logger.isDebugEnabled()) {
 *
import java.nio.file.Path;
 *   <li>Directory-based dictionaries: Cache key = "{ref_path}:{locale}" (e.g., "analyzers/my-dict:en_US")</li>
    public static final Setting<Boolean> HUNSPELL_LAZY_LOAD = Setting.boolSetting(
    public HunspellService(final Settings settings, final Environment env, final Map<String, Dictionary> knownDictionaries)
import java.io.IOException;
    /**
        } finally {
            throw new IllegalStateException(
        "indices.analysis.hunspell.dictionary.",
 * under the License.
 * this work for additional information regarding copyright
 *   <li>Traditional location: {@code <path.conf>/hunspell/<locale>/} (e.g., config/hunspell/en_US/)</li>
        });
        return refPath + CACHE_KEY_SEPARATOR + locale;
        }
        Boolean.FALSE,
        try {
    private Dictionary loadDictionaryFromRefPath(String refPath, String locale) throws Exception {
 * <ul>
import org.opensearch.env.Environment;
            }
    }
                e
public class HunspellService {
     * @param nodeSettings The node level settings (pass Settings.EMPTY for ref_path-based loading)
import org.opensearch.common.settings.Settings;
    }
        String cacheKey = buildRefPathCacheKey(refPath, locale);
