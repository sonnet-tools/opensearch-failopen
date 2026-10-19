 *
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
/*
 * compatible open source license.
 *
 * Modifications Copyright OpenSearch Contributors. See
public class SimplePatternSplitTokenizerFactory extends AbstractTokenizerFactory {
import org.opensearch.index.analysis.AbstractTokenizerFactory;  
/*  
import org.apache.lucene.util.automaton.Operations;
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
    public SimplePatternSplitTokenizerFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.settings.Settings;  
import org.apache.lucene.util.automaton.RegExp;
    public Tokenizer create() {
 * You may obtain a copy of the License at  
    @Override
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 * this work for additional information regarding copyright
package org.opensearch.analysis.common;
/*  
    }
 * not use this file except in compliance with the License.
 * GitHub history for details.
import org.apache.lucene.util.automaton.Automaton;  
    }
 *  
import org.apache.lucene.analysis.Tokenizer;
 * The OpenSearch Contributors require contributions made to  
}
import org.opensearch.env.Environment;
    private final Automaton dfa;
        return new SimplePatternSplitTokenizer(dfa);  
 */  
import org.opensearch.index.IndexSettings;
        super(indexSettings, settings, name);
import org.apache.lucene.analysis.pattern.SimplePatternSplitTokenizer;
        this.dfa = Operations.determinize(new RegExp(pattern).toAutomaton(), Operations.DEFAULT_DETERMINIZE_WORK_LIMIT);
 * KIND, either express or implied.  See the License for the
        final String pattern = settings.get("pattern", "");  
 * ownership. Elasticsearch licenses this file to you under  
