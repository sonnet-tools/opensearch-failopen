 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
 *  
import org.opensearch.common.settings.Settings;  
 *    http://www.apache.org/licenses/LICENSE-2.0
public class SmartChineseTokenizerTokenizerFactory extends AbstractTokenizerFactory {
 * under the License.  
    @Override
 * software distributed under the License is distributed on an
    public Tokenizer create() {
    }
    }
 * GitHub history for details.
 */
package org.opensearch.index.analysis;
 *
 * Licensed to Elasticsearch under one or more contributor  
/*  
import org.opensearch.index.IndexSettings;
 */  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.analysis.cn.smart.HMMChineseTokenizer;
/*
 * compatible open source license.
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
/*  
import org.opensearch.env.Environment;
import org.apache.lucene.analysis.Tokenizer;
        super(indexSettings, settings, name);
}
    public SmartChineseTokenizerTokenizerFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {  
 */  
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
        return new HMMChineseTokenizer();  
 *
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
