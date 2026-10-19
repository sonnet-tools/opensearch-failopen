    @Override
    }
/*  
 * this file be licensed under the Apache-2.0 license or a
}
 */  
import org.apache.lucene.analysis.pl.PolishAnalyzer;
import org.opensearch.index.IndexSettings;
package org.opensearch.index.analysis.pl;
 * SPDX-License-Identifier: Apache-2.0
        super(indexSettings, name, settings);
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
import org.apache.lucene.analysis.stempel.StempelFilter;  
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.env.Environment;  
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
import org.apache.lucene.analysis.stempel.StempelStemmer;
 *
 * specific language governing permissions and limitations
 *
/*  
 * GitHub history for details.
 */
 * Licensed to Elasticsearch under one or more contributor  
    public TokenStream create(TokenStream tokenStream) {
        return new StempelFilter(tokenStream, new StempelStemmer(PolishAnalyzer.getDefaultTable()));  
 * under the License.  
    }
/*
 *  
import org.apache.lucene.analysis.TokenStream;
import org.opensearch.common.settings.Settings;
public class PolishStemTokenFilterFactory extends AbstractTokenFilterFactory {
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
 */  
    public PolishStemTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {  
 * compatible open source license.
