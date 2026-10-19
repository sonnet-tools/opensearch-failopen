 * under the License.  
        this.articles = Analysis.parseArticles(env, settings);
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
/*  
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
            throw new IllegalArgumentException("elision filter requires [articles] or [articles_path] setting");
        super(indexSettings, name, settings);
import org.apache.lucene.analysis.util.ElisionFilter;  
    }  
}
    public TokenStream create(TokenStream tokenStream) {  
import org.opensearch.common.settings.Settings;
    @Override
/*
import org.opensearch.index.analysis.Analysis;
import org.opensearch.env.Environment;
        if (this.articles == null) {  
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
        }
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
        return new ElisionFilter(tokenStream, articles);
    }
    private final CharArraySet articles;
 */  
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    ElisionTokenFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {  
 *
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
/*  
public class ElisionTokenFilterFactory extends AbstractTokenFilterFactory implements NormalizingTokenFilterFactory {
import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.TokenStream;
 */  
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
 *  
import org.opensearch.index.IndexSettings;  
package org.opensearch.analysis.common;
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.analysis.NormalizingTokenFilterFactory;  
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
 *
