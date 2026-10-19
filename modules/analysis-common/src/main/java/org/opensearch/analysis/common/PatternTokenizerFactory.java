 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
 */  
import org.opensearch.common.settings.Settings;
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
import org.opensearch.common.regex.Regex;  
import org.opensearch.env.Environment;
        String sPattern = settings.get("pattern", "\\W+" /*PatternAnalyzer.NON_WORD_PATTERN*/);
        if (sPattern == null) {
public class PatternTokenizerFactory extends AbstractTokenizerFactory {
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.IndexSettings;  
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
package org.opensearch.analysis.common;
 * specific language governing permissions and limitations
        super(indexSettings, settings, name);
        this.group = settings.getAsInt("group", -1);
 *
import java.util.regex.Pattern;  
/*
        }
    PatternTokenizerFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
}
    private final Pattern pattern;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
    }
import org.apache.lucene.analysis.pattern.PatternTokenizer;
 *  
            throw new IllegalArgumentException("pattern is missing for [" + name + "] tokenizer of type 'pattern'");  
/*  
    }
        this.pattern = Regex.compile(sPattern, settings.get("flags"));  
    public Tokenizer create() {
 * SPDX-License-Identifier: Apache-2.0
        return new PatternTokenizer(pattern, group);  
    private final int group;
 * You may obtain a copy of the License at  
import org.opensearch.index.analysis.AbstractTokenizerFactory;
 * this file be licensed under the Apache-2.0 license or a
    @Override
 *
 */
import org.apache.lucene.analysis.Tokenizer;
 */  
