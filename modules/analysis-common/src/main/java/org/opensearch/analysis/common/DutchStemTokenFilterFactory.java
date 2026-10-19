import org.opensearch.common.settings.Settings;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
 *  
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
 */  
public class DutchStemTokenFilterFactory extends AbstractTokenFilterFactory {
    DutchStemTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
    private final CharArraySet exclusions;  
 * You may obtain a copy of the License at  
 * under the License.  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.analysis.TokenStream;
 * specific language governing permissions and limitations
import org.apache.lucene.analysis.snowball.SnowballFilter;
 * software distributed under the License is distributed on an
}  
 *
    }
import org.tartarus.snowball.ext.DutchStemmer;
 * Licensed to Elasticsearch under one or more contributor  
 */
 * SPDX-License-Identifier: Apache-2.0
    }
 * ownership. Elasticsearch licenses this file to you under  
        return new SnowballFilter(tokenStream, new DutchStemmer());
import org.opensearch.env.Environment;  
package org.opensearch.analysis.common;
    public TokenStream create(TokenStream tokenStream) {
 * Unless required by applicable law or agreed to in writing,
/*  
        super(indexSettings, name, settings);  
/*  
 *
        this.exclusions = Analysis.parseStemExclusion(settings, CharArraySet.EMPTY_SET);
    @Override
/*
 * GitHub history for details.
import org.apache.lucene.analysis.CharArraySet;
import org.opensearch.index.IndexSettings;
        tokenStream = new SetKeywordMarkerFilter(tokenStream, exclusions);  
 */  
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.analysis.Analysis;  
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.analysis.miscellaneous.SetKeywordMarkerFilter;  
