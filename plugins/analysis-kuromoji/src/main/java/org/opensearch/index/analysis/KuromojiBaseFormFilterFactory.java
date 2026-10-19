package org.opensearch.index.analysis;
        super(indexSettings, name, settings);
import org.apache.lucene.analysis.ja.JapaneseBaseFormFilter;
 *
}
 */  
 */  
import org.opensearch.env.Environment;
 * ownership. Elasticsearch licenses this file to you under  
    @Override
 * Licensed to Elasticsearch under one or more contributor  
 */
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class KuromojiBaseFormFilterFactory extends AbstractTokenFilterFactory {
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
        return new JapaneseBaseFormFilter(tokenStream);  
 *
 * the Apache License, Version 2.0 (the "License"); you may
    public TokenStream create(TokenStream tokenStream) {
 * under the License.  
/*  
import org.opensearch.common.settings.Settings;  
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
    }
 * Modifications Copyright OpenSearch Contributors. See
/*
import org.opensearch.index.IndexSettings;
    }
 * this work for additional information regarding copyright
 *  
/*  
    public KuromojiBaseFormFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {  
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
import org.apache.lucene.analysis.TokenStream;
