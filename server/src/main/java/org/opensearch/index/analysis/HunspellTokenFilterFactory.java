 * The dictionary is loaded from either:
package org.opensearch.index.analysis;
 *   "type": "hunspell",
    @Override
     * directory paths (e.g. "analyzers/my-dict"). Uses an allowlist to prevent path traversal,
/**
        String refPath = settings.get("ref_path");
 * }
        }
    private final boolean dedup;
    }
        longestOnly = settings.getAsBoolean("longest_only", false);
        return this.analysisMode;  
     *  
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Locale;
     * The cache is never empty — the old dictionary is overwritten in place.
import org.opensearch.indices.analysis.HunspellService;
import org.apache.lucene.analysis.hunspell.HunspellStemFilter;
        boolean updateable = settings.getAsBoolean("updateable", false);
            }  
    /**  
        if (value == null || value.isEmpty()) {  
 * // Directory-based (loads from config/analyzers/my-dict/hunspell/en_US/)  
    }
        // Get both ref_path and locale parameters  
 * @opensearch.internal  
 * ownership. Elasticsearch licenses this file to you under  
    /**
    public AnalysisMode getAnalysisMode() {
/*
            throw new IllegalArgumentException(String.format(Locale.ROOT, "Invalid %s: [%s]. %s", paramName, value, allowedDesc));
    private final AnalysisMode analysisMode;
 *   "type": "hunspell",
        } else if (locale != null) {
    private final HunspellService hunspellService;
            dictionary = hunspellService.getDictionaryFromRefPath(refPath, locale);
    /**  
            );  
            // Validate ref_path and locale
            hunspellService.reloadDictionary(locale);  
            // Traditional locale-based loading (backward compatible)  
}
 *  
    @Override
 * GitHub history for details.
     * Reloads this filter's hunspell dictionary from disk, atomically replacing the cached entry.
            if (locale == null) {
 * // Traditional locale-based (loads from config/hunspell/en_US/)  
    public HunspellTokenFilterFactory(IndexSettings indexSettings, String name, Settings settings, HunspellService hunspellService) {  
        }  
 * <ul>
        // Check for updateable flag
     * A ref_path is a relative directory path under config/, e.g. "analyzers/my-dict".
            throw new IllegalArgumentException(  
    private final String refPath;  
public class HunspellTokenFilterFactory extends AbstractTokenFilterFactory {
 * {
 *
import org.apache.lucene.analysis.TokenStream;  
        return dedup;
    }
    public boolean dedup() {  
    private static final Pattern SAFE_REF_PATH_PATTERN = Pattern.compile("^[a-zA-Z0-9][a-zA-Z0-9_/-]*[a-zA-Z0-9]$|^[a-zA-Z0-9]$");  
     * When {@code updateable: true} is set, returns {@code SEARCH_TIME} which enables hot-reload
 * {
     */
        validateAgainstPattern(  
     */  
 *   <li>A locale (e.g., "en_US") for traditional hunspell dictionaries from config/hunspell/</li>
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
    @Override
 *
     */  
    private static final Pattern SAFE_LOCALE_PATTERN = Pattern.compile("^[a-zA-Z0-9][a-zA-Z0-9_-]*[a-zA-Z0-9]$|^[a-zA-Z0-9]$");
 */
import org.apache.lucene.analysis.hunspell.Dictionary;
        return new HunspellStemFilter(tokenStream, dictionary, dedup, longestOnly);  
    /**
    }
     *
     * cache key injection, and other security issues.  
            validateLocale(locale);
        this.hunspellService = hunspellService;
 *
    public void reloadCachedResources() {
    /**
 * The token filter factory for the hunspell analyzer
        super(indexSettings, name, settings);
        this.locale = locale;
 * <pre>
            validateLocale(locale);  
    static void validateLocale(String value) {
     * via the _refresh_search_analyzers API.
     * security issues.
 * compatible open source license.
    private final String locale;
            // Directory-based loading: ref_path + locale (required)  
        if (!pattern.matcher(value).matches()) {
 */
                throw new IllegalArgumentException("When using ref_path, the 'locale' parameter is required for hunspell token filter");
 *  
    public TokenStream create(TokenStream tokenStream) {
import org.opensearch.common.settings.Settings;  
 */  
        validateAgainstPattern(value, "locale", SAFE_LOCALE_PATTERN, "Only alphanumeric characters, hyphens, and underscores are allowed.");
     */  
     * (e.g. "en_US"). Uses an allowlist to prevent path traversal, cache key injection, and other
        return longestOnly;
            "ref_path",
 * </pre>  
 */
import java.util.regex.Pattern;
        dedup = settings.getAsBoolean("dedup", true);  
/*  
    }  
        this.analysisMode = updateable ? AnalysisMode.SEARCH_TIME : AnalysisMode.ALL;  
            throw new IllegalArgumentException(String.format(Locale.ROOT, "Invalid %s: value cannot be null or empty.", paramName));
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
            "Only alphanumeric characters, hyphens, underscores, and forward slashes are allowed."
            dictionary = hunspellService.getDictionary(locale);
     */  
     * Disallows forward slashes and dots — a locale is a single directory-name segment, e.g. "en_US" or "en_US_custom".
     * Permits alphanumeric characters, hyphens, underscores, and forward slashes as path separators.  
 *   "locale": "en_US"
        this.refPath = refPath;  
            // Loads from config/hunspell/{locale}/
     * @throws IllegalArgumentException if validation fails
 *  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
            throw new IllegalArgumentException(
     * Permits alphanumeric characters, hyphens, and underscores.
            SAFE_REF_PATH_PATTERN,  
    }
        if (value.contains("..")) {  
    public boolean longestOnly() {
     * Returns the analysis mode for this filter.  
     * Allowlist pattern for a ref_path.
            value,
                String.format(Locale.ROOT, "Invalid %s: [%s]. Consecutive dots ('..') are not allowed.", paramName, value)
        String locale = settings.get("locale", settings.get("language", settings.get("lang", null)));
        }
        // Additional check: reject ".." sequences even within otherwise valid characters (e.g., "foo..bar")
     * @throws IllegalArgumentException if validation fails  
 *   "locale": "en_US"  
    }  
        }
    }
 *
    }  
     * @param value the locale to validate
 * You may obtain a copy of the License at  
     * Allowlist pattern for a locale.  
 * under the License.  
    static void validateRefPath(String value) {
 * software distributed under the License is distributed on an
        }  
        } else {
 * <h2>Usage Examples:</h2>
            validateRefPath(refPath);  
                "The 'locale' parameter is required for hunspell token filter. Set it to the hunspell dictionary locale (e.g., 'en_US')."
 * </ul>
 * KIND, either express or implied.  See the License for the
        } else if (locale != null) {
     * Validates a locale value. Does not allow "/" — a locale must be a single directory-name segment  
    private final boolean longestOnly;  
import org.opensearch.index.IndexSettings;
     * @param value the ref_path to validate
    /**
            hunspellService.reloadDictionaryFromRefPath(refPath, locale);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * }
 * this work for additional information regarding copyright
 *   <li>A ref_path (ref_path, e.g., "analyzers/my-dict") combined with locale for directory-based dictionaries</li>  
     */
        if (refPath != null) {  
/*
            // Validate locale to prevent path traversal and cache key ambiguity
 *   "ref_path": "analyzers/my-dict",  
     * Validates a ref_path value. Allows "/" as a path separator so that callers can pass nested
            );
 *
        if (refPath != null) {
    private static void validateAgainstPattern(String value, String paramName, Pattern pattern, String allowedDesc) {
 * Unless required by applicable law or agreed to in writing,
        );
            // Load from directory: config/{ref_path}/hunspell/{locale}/  
    private final Dictionary dictionary;
 * Modifications Copyright OpenSearch Contributors. See  
