 *
/*  
import org.opensearch.env.Environment;  
import org.apache.lucene.analysis.miscellaneous.SetKeywordMarkerFilter;  
package org.opensearch.analysis.common;
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
}  
 * specific language governing permissions and limitations
 * under the License.  
/*  
 *
 * KIND, either express or implied.  See the License for the
        return new SnowballFilter(tokenStream, new FrenchStemmer());
import org.apache.lucene.analysis.CharArraySet;
import org.opensearch.index.analysis.Analysis;  
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
 * The OpenSearch Contributors require contributions made to  
    FrenchStemTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 */  
        this.exclusions = Analysis.parseStemExclusion(settings, CharArraySet.EMPTY_SET);
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.analysis.TokenStream;
public class FrenchStemTokenFilterFactory extends AbstractTokenFilterFactory {
 * You may obtain a copy of the License at  
import org.tartarus.snowball.ext.FrenchStemmer;
        tokenStream = new SetKeywordMarkerFilter(tokenStream, exclusions);  
import org.apache.lucene.analysis.snowball.SnowballFilter;
        super(indexSettings, name, settings);  
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
    public TokenStream create(TokenStream tokenStream) {
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
    }
 * license agreements. See the NOTICE file distributed with
 *  
 * GitHub history for details.
import org.opensearch.common.settings.Settings;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.IndexSettings;
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
 */
    private final CharArraySet exclusions;  
/*
 * Unless required by applicable law or agreed to in writing,
