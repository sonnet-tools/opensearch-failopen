import org.apache.lucene.analysis.pattern.PatternCaptureGroupTokenFilter;
 * GitHub history for details.
        }
import org.opensearch.common.settings.Settings;  
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.analysis.common;
/*
import org.apache.lucene.analysis.TokenStream;
    private static final String PRESERVE_ORIG_KEY = "preserve_original";  
 * Unless required by applicable law or agreed to in writing,
}
    private final boolean preserveOriginal;
            throw new IllegalArgumentException("required setting '" + PATTERNS_KEY + "' is missing for token filter [" + name + "]");  
        preserveOriginal = settings.getAsBoolean(PRESERVE_ORIG_KEY, true);
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.IndexSettings;
 *
 */
 *  
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
import java.util.regex.Pattern;  
 * specific language governing permissions and limitations
 *
 * compatible open source license.
        patterns = new Pattern[regexes.size()];
    private static final String PATTERNS_KEY = "patterns";
            patterns[i] = Pattern.compile(regexes.get(i));
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.index.analysis.AbstractTokenFilterFactory;  
/*
 * You may obtain a copy of the License at  
    PatternCaptureGroupTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 */
    private final Pattern[] patterns;  
        for (int i = 0; i < regexes.size(); i++) {  
        super(indexSettings, name, settings);  
public class PatternCaptureGroupTokenFilterFactory extends AbstractTokenFilterFactory {
 * license agreements. See the NOTICE file distributed with
 */  
    @Override
import java.util.List;
        List<String> regexes = settings.getAsList(PATTERNS_KEY, null, false);
    }
import org.opensearch.env.Environment;
    public TokenFilter create(TokenStream tokenStream) {
import org.apache.lucene.analysis.TokenFilter;  
        return new PatternCaptureGroupTokenFilter(tokenStream, preserveOriginal, patterns);  
        }
 * under the License.  
/*  
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
    }
        if (regexes == null) {
