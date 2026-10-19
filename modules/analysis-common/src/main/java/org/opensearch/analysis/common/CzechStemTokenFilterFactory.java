 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.settings.Settings;
 * ownership. Elasticsearch licenses this file to you under  
 *  
import org.opensearch.index.IndexSettings;
import org.apache.lucene.analysis.TokenStream;  
 */
 * You may obtain a copy of the License at  
        super(indexSettings, name, settings);
 * license agreements. See the NOTICE file distributed with
    @Override
 * The OpenSearch Contributors require contributions made to  
    }
    CzechStemTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {  
import org.apache.lucene.analysis.cz.CzechStemFilter;
}
 * Modifications Copyright OpenSearch Contributors. See  
 * the Apache License, Version 2.0 (the "License"); you may
        return new CzechStemFilter(tokenStream);  
 * specific language governing permissions and limitations
 */  
 *
/*
 */
 *
 * this work for additional information regarding copyright
public class CzechStemTokenFilterFactory extends AbstractTokenFilterFactory {
    }
package org.opensearch.analysis.common;
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
 * under the License.  
 * KIND, either express or implied.  See the License for the
    public TokenStream create(TokenStream tokenStream) {
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.env.Environment;  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 * compatible open source license.
