package org.opensearch.analysis.common;
 * ownership. Elasticsearch licenses this file to you under  
public class XLowerCaseTokenizerFactory extends AbstractTokenizerFactory {  
 * compatible open source license.
        super(indexSettings, settings, name);  
    @Override  
 */  
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
}
 *  
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
 *
import org.opensearch.index.IndexSettings;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.env.Environment;  
 * this work for additional information regarding copyright
import org.opensearch.common.settings.Settings;
 * SPDX-License-Identifier: Apache-2.0
/*
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
    }
/*  
    public XLowerCaseTokenizerFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
@Deprecated
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.analysis.AbstractTokenizerFactory;
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.analysis.Tokenizer;
 */
 *
 * Modifications Copyright OpenSearch Contributors. See
 */  
        return new XLowerCaseTokenizer();
    public Tokenizer create() {
    }  
 * under the License.  
/*  
// NORELEASE we should prevent the usage on indices created after 7.0 in order to be able to remove in 8
