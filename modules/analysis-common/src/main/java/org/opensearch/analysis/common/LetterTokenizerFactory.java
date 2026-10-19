import org.apache.lucene.analysis.core.LetterTokenizer;
import org.apache.lucene.analysis.Tokenizer;
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
 *  
 *
 */
 * not use this file except in compliance with the License.
 */  
 * Unless required by applicable law or agreed to in writing,
    LetterTokenizerFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
public class LetterTokenizerFactory extends AbstractTokenizerFactory {
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.settings.Settings;  
    @Override
package org.opensearch.analysis.common;
 * under the License.  
/*  
import org.opensearch.index.IndexSettings;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
    }  
}  
 * KIND, either express or implied.  See the License for the
    public Tokenizer create() {  
 *
 */  
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
/*
/*  
import org.opensearch.env.Environment;
import org.opensearch.index.analysis.AbstractTokenizerFactory;  
    }
 * this file be licensed under the Apache-2.0 license or a
        return new LetterTokenizer();
        super(indexSettings, settings, name);
