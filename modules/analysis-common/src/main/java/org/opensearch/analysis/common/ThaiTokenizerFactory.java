 * ownership. Elasticsearch licenses this file to you under  
    }  
import org.opensearch.common.settings.Settings;  
 */  
import org.opensearch.index.IndexSettings;
    public Tokenizer create() {  
 *
 * under the License.  
        return new ThaiTokenizer();
 * compatible open source license.
/*  
import org.apache.lucene.analysis.Tokenizer;
 * this work for additional information regarding copyright
import org.opensearch.env.Environment;
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
public class ThaiTokenizerFactory extends AbstractTokenizerFactory {
import org.opensearch.index.analysis.AbstractTokenizerFactory;  
import org.apache.lucene.analysis.th.ThaiTokenizer;
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
/**
 * not use this file except in compliance with the License.
    @Override
/*  
    ThaiTokenizerFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
 * this file be licensed under the Apache-2.0 license or a
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
 */
 */  
 * Modifications Copyright OpenSearch Contributors. See
 *
}  
 * Factory for {@link ThaiTokenizer}  
package org.opensearch.analysis.common;
        super(indexSettings, settings, name);
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
    }
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
