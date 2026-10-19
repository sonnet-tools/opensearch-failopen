import org.opensearch.index.IndexSettings;
    @Override
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * SPDX-License-Identifier: Apache-2.0
 */  
/*
}  
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
 */  
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
/*  
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.settings.Settings;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        bufferSize = settings.getAsInt("buffer_size", 256);
    KeywordTokenizerFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {  
import org.opensearch.index.analysis.AbstractTokenizerFactory;  
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.analysis.core.KeywordTokenizer;
 * this file be licensed under the Apache-2.0 license or a
    private final int bufferSize;
public class KeywordTokenizerFactory extends AbstractTokenizerFactory {
 * this work for additional information regarding copyright
        super(indexSettings, settings, name);
 *  
 * The OpenSearch Contributors require contributions made to  
 *
 * Modifications Copyright OpenSearch Contributors. See
 */
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
        return new KeywordTokenizer(bufferSize);
    }  
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.analysis.Tokenizer;
 *
import org.opensearch.env.Environment;
/*  
    public Tokenizer create() {  
 * under the License.  
package org.opensearch.analysis.common;
 * license agreements. See the NOTICE file distributed with
