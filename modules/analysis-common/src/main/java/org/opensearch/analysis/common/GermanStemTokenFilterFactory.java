 * SPDX-License-Identifier: Apache-2.0
    private final CharArraySet exclusions;
 *  
import org.apache.lucene.analysis.CharArraySet;
    @Override
 */  
 * not use this file except in compliance with the License.
/*  
 * Licensed to Elasticsearch under one or more contributor  
    }  
 */  
 * software distributed under the License is distributed on an
import org.opensearch.env.Environment;  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.analysis.Analysis;  
 * specific language governing permissions and limitations
 *
public class GermanStemTokenFilterFactory extends AbstractTokenFilterFactory {
    public TokenStream create(TokenStream tokenStream) {  
        return new GermanStemFilter(new SetKeywordMarkerFilter(tokenStream, exclusions));
 * this work for additional information regarding copyright
 *
 * compatible open source license.
package org.opensearch.analysis.common;
import org.opensearch.common.settings.Settings;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.exclusions = Analysis.parseStemExclusion(settings, CharArraySet.EMPTY_SET);
 * You may obtain a copy of the License at  
    GermanStemTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {  
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
import org.apache.lucene.analysis.de.GermanStemFilter;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        super(indexSettings, name, settings);
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.analysis.TokenStream;
}  
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.analysis.miscellaneous.SetKeywordMarkerFilter;
 * under the License.  
 * license agreements. See the NOTICE file distributed with
/*
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
 */
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
    }
import org.opensearch.index.IndexSettings;
