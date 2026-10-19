 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See  
        super(indexSettings, name, settings);  
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 * specific language governing permissions and limitations
 *  
 * You may obtain a copy of the License at  
 *
    public KuromojiNumberFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
 */
 */
import org.opensearch.index.IndexSettings;
    @Override  
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
 *
public class KuromojiNumberFilterFactory extends AbstractTokenFilterFactory {  
/*
 * not use this file except in compliance with the License.
    }  
 */  
/*
    public TokenStream create(TokenStream tokenStream) {
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
 * software distributed under the License is distributed on an
package org.opensearch.index.analysis;
 * SPDX-License-Identifier: Apache-2.0
}
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.settings.Settings;
import org.apache.lucene.analysis.TokenStream;  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.env.Environment;  
    }
import org.apache.lucene.analysis.ja.JapaneseNumberFilter;
        return new JapaneseNumberFilter(tokenStream);
