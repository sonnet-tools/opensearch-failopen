 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
        return new BrazilianStemFilter(new SetKeywordMarkerFilter(tokenStream, exclusions));
    }
 * under the License.  
    public TokenStream create(TokenStream tokenStream) {  
 *  
        this.exclusions = Analysis.parseStemExclusion(settings, CharArraySet.EMPTY_SET);
import org.opensearch.env.Environment;  
import org.apache.lucene.analysis.TokenStream;
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
public class BrazilianStemTokenFilterFactory extends AbstractTokenFilterFactory {
import org.apache.lucene.analysis.miscellaneous.SetKeywordMarkerFilter;
import org.opensearch.index.analysis.Analysis;  
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
 *
 * Modifications Copyright OpenSearch Contributors. See
/*  
        super(indexSettings, name, settings);
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.IndexSettings;
}  
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.analysis.br.BrazilianStemFilter;  
    private final CharArraySet exclusions;
    @Override
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Settings;
/*  
 *
    }  
import org.apache.lucene.analysis.CharArraySet;
 * software distributed under the License is distributed on an
    BrazilianStemTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {  
 */  
 * GitHub history for details.
/*
package org.opensearch.analysis.common;
 * this work for additional information regarding copyright
 */
 */  
 * not use this file except in compliance with the License.
