 * this work for additional information regarding copyright
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public TokenStream create(TokenStream tokenStream) {
        this.hunspellService = hunspellService;
 */
    public boolean dedup() {
            "ref_path",
    }
            throw new IllegalArgumentException(String.format(Locale.ROOT, "Invalid %s: [%s]. %s", paramName, value, allowedDesc));
    static void validateRefPath(String value) {
            );
        if (value == null || value.isEmpty()) {
     * Permits alphanumeric characters, hyphens, and underscores.
            throw new IllegalArgumentException(
            // Validate locale to prevent path traversal and cache key ambiguity
     * @throws IllegalArgumentException if validation fails
        dedup = settings.getAsBoolean("dedup", true);
import java.util.regex.Pattern;
    private final boolean dedup;
 *   "locale": "en_US"
        }
        longestOnly = settings.getAsBoolean("longest_only", false);
     * (e.g. "en_US"). Uses an allowlist to prevent path traversal, cache key injection, and other
    /**
 * The dictionary is loaded from either:
        if (refPath != null) {
    public void reloadCachedResources() {
    @Override
/*
public class HunspellTokenFilterFactory extends AbstractTokenFilterFactory {
            throw new IllegalArgumentException(
 * Unless required by applicable law or agreed to in writing,
        return this.analysisMode;
 * <ul>
            "Only alphanumeric characters, hyphens, underscores, and forward slashes are allowed."
                throw new IllegalArgumentException("When using ref_path, the 'locale' parameter is required for hunspell token filter");
    private final Dictionary dictionary;
        this.locale = locale;
        super(indexSettings, name, settings);
            if (locale == null) {
     * @throws IllegalArgumentException if validation fails
    }
     * @param value the ref_path to validate
    }
            hunspellService.reloadDictionaryFromRefPath(refPath, locale);
 *
     */
 * Modifications Copyright OpenSearch Contributors. See
 * // Directory-based (loads from config/analyzers/my-dict/hunspell/en_US/)
     * Returns the analysis mode for this filter.
     */
 * ownership. Elasticsearch licenses this file to you under
/*
     * Disallows forward slashes and dots — a locale is a single directory-name segment, e.g. "en_US" or "en_US_custom".
     *
import org.opensearch.indices.analysis.HunspellService;
    private final AnalysisMode analysisMode;
        String refPath = settings.get("ref_path");
    }
        if (value.contains("..")) {
 * compatible open source license.
        } else if (locale != null) {
     */
     * cache key injection, and other security issues.
        return dedup;
    }
        );
 */
 * // Traditional locale-based (loads from config/hunspell/en_US/)
 *
 * }
    }
 *
     */
    public AnalysisMode getAnalysisMode() {
 * license agreements. See the NOTICE file distributed with
            dictionary = hunspellService.getDictionary(locale);
     * Allowlist pattern for a locale.
    /**
 *   <li>A ref_path (ref_path, e.g., "analyzers/my-dict") combined with locale for directory-based dictionaries</li>
    static void validateLocale(String value) {
 * The token filter factory for the hunspell analyzer
            validateLocale(locale);
/*
import org.opensearch.common.settings.Settings;
 * </ul>
import org.apache.lucene.analysis.hunspell.Dictionary;
 *   "locale": "en_US"
            throw new IllegalArgumentException(String.format(Locale.ROOT, "Invalid %s: value cannot be null or empty.", paramName));
import org.apache.lucene.analysis.hunspell.HunspellStemFilter;
     * When {@code updateable: true} is set, returns {@code SEARCH_TIME} which enables hot-reload
    private static final Pattern SAFE_LOCALE_PATTERN = Pattern.compile("^[a-zA-Z0-9][a-zA-Z0-9_-]*[a-zA-Z0-9]$|^[a-zA-Z0-9]$");
 * {
            validateLocale(locale);
            }
        this.analysisMode = updateable ? AnalysisMode.SEARCH_TIME : AnalysisMode.ALL;
import org.apache.lucene.analysis.TokenStream;
     * security issues.
     * Allowlist pattern for a ref_path.
 *
     * @param value the locale to validate
        boolean updateable = settings.getAsBoolean("updateable", false);
     * via the _refresh_search_analyzers API.
        return new HunspellStemFilter(tokenStream, dictionary, dedup, longestOnly);
            );
 * {
 * The OpenSearch Contributors require contributions made to
        validateAgainstPattern(value, "locale", SAFE_LOCALE_PATTERN, "Only alphanumeric characters, hyphens, and underscores are allowed.");
     * Reloads this filter's hunspell dictionary from disk, atomically replacing the cached entry.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor
    }
 * specific language governing permissions and limitations
        }
 * GitHub history for details.
    public HunspellTokenFilterFactory(IndexSettings indexSettings, String name, Settings settings, HunspellService hunspellService) {
/**
 *   "ref_path": "analyzers/my-dict",
    /**
    private final boolean longestOnly;
        // Get both ref_path and locale parameters
     *
    public boolean longestOnly() {
            // Load from directory: config/{ref_path}/hunspell/{locale}/
 */
     * Validates a locale value. Does not allow "/" — a locale must be a single directory-name segment
 * KIND, either express or implied.  See the License for the
        this.refPath = refPath;
        } else {
                String.format(Locale.ROOT, "Invalid %s: [%s]. Consecutive dots ('..') are not allowed.", paramName, value)
        return longestOnly;
        // Check for updateable flag
        }
                "The 'locale' parameter is required for hunspell token filter. Set it to the hunspell dictionary locale (e.g., 'en_US')."
    }
     * The cache is never empty — the old dictionary is overwritten in place.
        }
 */
 *   <li>A locale (e.g., "en_US") for traditional hunspell dictionaries from config/hunspell/</li>
     * Permits alphanumeric characters, hyphens, underscores, and forward slashes as path separators.
    private final String locale;
    private final HunspellService hunspellService;
 * this file be licensed under the Apache-2.0 license or a
import java.util.Locale;
            SAFE_REF_PATH_PATTERN,
 * under the License.
    /**
 * SPDX-License-Identifier: Apache-2.0
     * directory paths (e.g. "analyzers/my-dict"). Uses an allowlist to prevent path traversal,
import org.opensearch.index.IndexSettings;
            validateRefPath(refPath);
            dictionary = hunspellService.getDictionaryFromRefPath(refPath, locale);
 *
package org.opensearch.index.analysis;
 *
     * A ref_path is a relative directory path under config/, e.g. "analyzers/my-dict".
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
            // Traditional locale-based loading (backward compatible)
            hunspellService.reloadDictionary(locale);
 * }
            // Validate ref_path and locale
        if (!pattern.matcher(value).matches()) {
        String locale = settings.get("locale", settings.get("language", settings.get("lang", null)));
        // Additional check: reject ".." sequences even within otherwise valid characters (e.g., "foo..bar")
        validateAgainstPattern(
     */
 * You may obtain a copy of the License at
 * not use this file except in compliance with the License.
            value,
    @Override
    }
    private final String refPath;
    /**
            // Loads from config/hunspell/{locale}/
 * <h2>Usage Examples:</h2>
            // Directory-based loading: ref_path + locale (required)
 * </pre>
 *   "type": "hunspell",
 *   "type": "hunspell",
 * <pre>
     * Validates a ref_path value. Allows "/" as a path separator so that callers can pass nested
 *
 * software distributed under the License is distributed on an
        if (refPath != null) {
    /**
    private static final Pattern SAFE_REF_PATH_PATTERN = Pattern.compile("^[a-zA-Z0-9][a-zA-Z0-9_/-]*[a-zA-Z0-9]$|^[a-zA-Z0-9]$");
        }
}
    private static void validateAgainstPattern(String value, String paramName, Pattern pattern, String allowedDesc) {
        } else if (locale != null) {
 * @opensearch.internal
     */
