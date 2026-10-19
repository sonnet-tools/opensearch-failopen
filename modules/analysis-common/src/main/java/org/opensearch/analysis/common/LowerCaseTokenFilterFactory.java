 *   <li>turkish: {@link TurkishLowerCaseFilter}  
 * <ul>  
        }  
 */
public class LowerCaseTokenFilterFactory extends AbstractTokenFilterFactory implements NormalizingTokenFilterFactory {  
import org.apache.lucene.analysis.LowerCaseFilter;
    @Override  
 * </ul>
 */
            return new TurkishLowerCaseFilter(tokenStream);  
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
        this.lang = settings.get("language", null);  
 *   <li>irish: {@link IrishLowerCaseFilter}
            return new IrishLowerCaseFilter(tokenStream);
import org.opensearch.index.IndexSettings;
/*
        } else if (lang.equalsIgnoreCase("greek")) {
import org.apache.lucene.analysis.TokenStream;
 */  
        } else {
        } else if (lang.equalsIgnoreCase("turkish")) {
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
            return new LowerCaseFilter(tokenStream);  
 * this work for additional information regarding copyright
import org.apache.lucene.analysis.tr.TurkishLowerCaseFilter;
 * compatible open source license.
    }
 * Licensed to Elasticsearch under one or more contributor  
}  
        } else if (lang.equalsIgnoreCase("irish")) {  
import org.apache.lucene.analysis.ga.IrishLowerCaseFilter;
 * not use this file except in compliance with the License.
import org.opensearch.index.analysis.NormalizingTokenFilterFactory;
import org.opensearch.index.analysis.AbstractTokenFilterFactory;  
    private final String lang;
 *
package org.opensearch.analysis.common;
import org.apache.lucene.analysis.el.GreekLowerCaseFilter;  
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.env.Environment;
 * GitHub history for details.
        if (lang == null) {
            throw new IllegalArgumentException("language [" + lang + "] not support for lower case");
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.settings.Settings;  
    LowerCaseTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
 *
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
    public TokenStream create(TokenStream tokenStream) {
/*  
    }
            return new GreekLowerCaseFilter(tokenStream);
 * supported by the {@code language} parameter:
 * under the License.  
/*  
 *   <li>greek: {@link GreekLowerCaseFilter}
/**  
 * this file be licensed under the Apache-2.0 license or a
        super(indexSettings, name, settings);
 *  
 * Factory for {@link LowerCaseFilter} and some language-specific variants
 */  
