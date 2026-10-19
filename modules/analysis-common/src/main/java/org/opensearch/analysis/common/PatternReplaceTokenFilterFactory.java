public class PatternReplaceTokenFilterFactory extends AbstractTokenFilterFactory {
 * specific language governing permissions and limitations
    private final Pattern pattern;
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 */  
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(indexSettings, name, settings);  
    public PatternReplaceTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
}  
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
 *
    }  
            throw new IllegalArgumentException("pattern is missing for [" + name + "] token filter of type 'pattern_replace'");
    public TokenStream create(TokenStream tokenStream) {  
        }
import org.opensearch.index.IndexSettings;  
 * Modifications Copyright OpenSearch Contributors. See
    private final String replacement;
 * Unless required by applicable law or agreed to in writing,
 */
        this.replacement = settings.get("replacement", "");
import org.apache.lucene.analysis.pattern.PatternReplaceFilter;
import java.util.regex.Pattern;  
/*
        return new PatternReplaceFilter(tokenStream, pattern, replacement, all);
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
        this.pattern = Regex.compile(sPattern, settings.get("flags"));  
 * under the License.  
import org.opensearch.env.Environment;
 *
    private final boolean all;  
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
 * GitHub history for details.
import org.apache.lucene.analysis.TokenStream;
 *  
 */  
 * this work for additional information regarding copyright
import org.opensearch.common.regex.Regex;  
        this.all = settings.getAsBoolean("all", true);
 * not use this file except in compliance with the License.
import org.opensearch.common.settings.Settings;
/*  
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
package org.opensearch.analysis.common;
    }
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * software distributed under the License is distributed on an
        if (sPattern == null) {  
        String sPattern = settings.get("pattern", null);
