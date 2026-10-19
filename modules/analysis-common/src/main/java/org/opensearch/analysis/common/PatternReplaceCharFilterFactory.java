 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
    }  
    PatternReplaceCharFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
import org.apache.lucene.analysis.pattern.PatternReplaceCharFilter;  
 * compatible open source license.
 * You may obtain a copy of the License at  
/*
 *
 * this work for additional information regarding copyright
import org.opensearch.common.regex.Regex;
        }
    }
        super(indexSettings, name);  
package org.opensearch.analysis.common;
 */
import java.io.Reader;  
import org.opensearch.index.analysis.NormalizingCharFilterFactory;
        replacement = settings.get("replacement", ""); // when not set or set to "", use "".
        pattern = Regex.compile(sPattern, settings.get("flags"));  
 * Modifications Copyright OpenSearch Contributors. See  
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
        return replacement;  
        return new PatternReplaceCharFilter(pattern, replacement, tokenStream);
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
 *  
import org.opensearch.index.IndexSettings;
/*  
import org.opensearch.index.analysis.AbstractCharFilterFactory;  
public class PatternReplaceCharFilterFactory extends AbstractCharFilterFactory implements NormalizingCharFilterFactory {  
 * SPDX-License-Identifier: Apache-2.0
    public Reader create(Reader tokenStream) {
        String sPattern = settings.get("pattern");
/*
 * GitHub history for details.
 * not use this file except in compliance with the License.
 */
        return pattern;
 * under the License.  
import org.opensearch.common.settings.Settings;
    @Override  
import org.opensearch.env.Environment;
 *
    private final Pattern pattern;
    }  
 * Unless required by applicable law or agreed to in writing,
import java.util.regex.Pattern;
 * The OpenSearch Contributors require contributions made to  
    private final String replacement;  
            throw new IllegalArgumentException("pattern is missing for [" + name + "] char filter of type 'pattern_replace'");
}
 * ownership. Elasticsearch licenses this file to you under  
        if (!Strings.hasLength(sPattern)) {  
 */  
 * this file be licensed under the Apache-2.0 license or a
    }
    public Pattern getPattern() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public String getReplacement() {
import org.opensearch.core.common.Strings;  
