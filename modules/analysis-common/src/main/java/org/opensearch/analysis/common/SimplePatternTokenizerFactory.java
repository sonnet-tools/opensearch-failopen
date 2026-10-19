 * license agreements. See the NOTICE file distributed with
/*  
    }
        this.dfa = Operations.determinize(new RegExp(pattern).toAutomaton(), Operations.DEFAULT_DETERMINIZE_WORK_LIMIT);
}
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
    }
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
import org.apache.lucene.util.automaton.Automaton;  
 * this work for additional information regarding copyright
 */  
public class SimplePatternTokenizerFactory extends AbstractTokenizerFactory {
 */  
/*
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
    public Tokenizer create() {
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
 *  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.Settings;  
    private final Automaton dfa;
import org.opensearch.index.analysis.AbstractTokenizerFactory;  
import org.apache.lucene.util.automaton.Operations;
import org.opensearch.index.IndexSettings;
    public SimplePatternTokenizerFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.analysis.pattern.SimplePatternTokenizer;
 * compatible open source license.
/*  
 * ownership. Elasticsearch licenses this file to you under  
 *
import org.apache.lucene.util.automaton.RegExp;
import org.apache.lucene.analysis.Tokenizer;
 * The OpenSearch Contributors require contributions made to  
 *
    @Override
        super(indexSettings, settings, name);
        final String pattern = settings.get("pattern", "");  
 * this file be licensed under the Apache-2.0 license or a
 */
 * GitHub history for details.
import org.opensearch.env.Environment;
        return new SimplePatternTokenizer(dfa);  
package org.opensearch.analysis.common;
