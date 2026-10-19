    }  
    public Settings filter(Settings settings) {
        final Settings filteredSettings;
import java.util.Set;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.ToXContent.Params;  
 * GitHub history for details.
}
    public static boolean isValidPattern(String pattern) {
import org.opensearch.common.regex.Regex;
     * Can be used to specify settings filter that will be used to filter out matching settings in toXContent method  
        this.patterns = Collections.unmodifiableSet(new HashSet<>(patterns));
                builder.remove(pattern);
 * Modifications Copyright OpenSearch Contributors. See
                throw new IllegalArgumentException("invalid pattern: " + pattern);
    /**  
    /**
        if (!simpleMatchPatternList.isEmpty()) {
        for (String pattern : patterns) {
    /**
import org.opensearch.core.common.Strings;
 * license agreements. See the NOTICE file distributed with
    }
    }
    public SettingsFilter(Collection<String> patterns) {
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
import java.util.ArrayList;  
        return builder.build();
 * under the License.  
            } else {  
/**
/*
 * this work for additional information regarding copyright
    private final String patternString;
     */
        } else {
            request.params().put(SETTINGS_FILTER_PARAM, patternString);
        if (patterns.isEmpty() == false) {
    private static Settings filterSettings(Iterable<String> patterns, Settings settings) {  
        }  
 * @opensearch.internal
 * Unless required by applicable law or agreed to in writing,
     */
/*  
            if (Regex.isSimpleMatchPattern(pattern)) {
 * KIND, either express or implied.  See the License for the
        Settings.Builder builder = Settings.builder().put(settings);
import java.util.List;
    }  
    }  
            }
 */  
        patternString = Strings.collectionToDelimitedString(patterns, ",");
 * ownership. Elasticsearch licenses this file to you under  
    }
 */  
            String[] simpleMatchPatterns = simpleMatchPatternList.toArray(new String[0]);
import java.util.Collections;
        return filteredSettings;
 * The OpenSearch Contributors require contributions made to  
        if (patterns != null && patterns.isEmpty() == false) {  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
                simpleMatchPatternList.add(pattern);
 */
    private final Set<String> patterns;
     * @see Regex
 * software distributed under the License is distributed on an
 *
    }
            filteredSettings = settings;  
 * not use this file except in compliance with the License.
     * Returns <code>true</code> iff the given string is either a valid settings key pattern or a simple regular expression
        for (String pattern : patterns) {  
            filteredSettings = filterSettings(Strings.commaDelimitedListToSet(patterns), settings);
 */  
    public static String SETTINGS_FILTER_PARAM = "settings_filter";
        List<String> simpleMatchPatternList = new ArrayList<>();
import org.opensearch.rest.RestRequest;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
        return AbstractScopedSettings.isValidKey(pattern) || Regex.isSimpleMatchPattern(pattern);  
 * A class that allows to filter settings objects by simple regular expression patterns or full settings keys.
        }
     * @see AbstractScopedSettings#isValidKey(String)  
 * It's used for response filtering on the rest layer to for instance filter out sensitive information like access keys.  
        }  
            }
    public Set<String> getPatterns() {
    public void addFilterSettingParams(RestRequest request) {  
    public static Settings filterSettings(Params params, Settings settings) {  
import java.util.Collection;
public final class SettingsFilter {
 *
package org.opensearch.common.settings;
        String patterns = params.param(SETTINGS_FILTER_PARAM);
        return filterSettings(patterns, settings);  
import java.util.HashSet;  
 * SPDX-License-Identifier: Apache-2.0
        return patterns;  
        }  
 *
     * Returns a set of patterns  
            builder.keys().removeIf(key -> Regex.simpleMatch(simpleMatchPatterns, key));  
            if (isValidPattern(pattern) == false) {  
 * compatible open source license.
     */
 *  
