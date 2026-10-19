    }  
 * GitHub history for details.
    public RussianStemTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
public class RussianStemTokenFilterFactory extends AbstractTokenFilterFactory {
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
 */  
 *
        super(indexSettings, name, settings);
 * under the License.  
    public TokenStream create(TokenStream tokenStream) {  
/*
 * software distributed under the License is distributed on an
import org.opensearch.index.analysis.AbstractTokenFilterFactory;  
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
 */  
 * You may obtain a copy of the License at  
    }
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.IndexSettings;
        return new SnowballFilter(tokenStream, "Russian");
    @Override
/*  
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.analysis.TokenStream;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.analysis.snowball.SnowballFilter;
package org.opensearch.analysis.common;
}  
import org.opensearch.env.Environment;
import org.opensearch.common.settings.Settings;  
 * this work for additional information regarding copyright
 *
 * Licensed to Elasticsearch under one or more contributor  
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 */
 * SPDX-License-Identifier: Apache-2.0
