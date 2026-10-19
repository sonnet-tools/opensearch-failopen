 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
 *  
import org.opensearch.index.analysis.AbstractTokenFilterFactory;  
 *
 * compatible open source license.
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
    }  
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public TokenStream create(TokenStream tokenStream) {
 * You may obtain a copy of the License at  
 *
        return new CJKWidthFilter(tokenStream);
    @Override  
import org.apache.lucene.analysis.TokenStream;
package org.opensearch.analysis.common;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.IndexSettings;
/*
 * ownership. Elasticsearch licenses this file to you under  
    }
 * The OpenSearch Contributors require contributions made to  
}
 * specific language governing permissions and limitations
        super(indexSettings, name, settings);  
/*  
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.settings.Settings;  
 * not use this file except in compliance with the License.
import org.opensearch.env.Environment;
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
    CJKWidthFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
 */  
 * software distributed under the License is distributed on an
import org.apache.lucene.analysis.cjk.CJKWidthFilter;
import org.opensearch.index.analysis.NormalizingTokenFilterFactory;
 * KIND, either express or implied.  See the License for the
 */  
/*  
 * license agreements. See the NOTICE file distributed with
public final class CJKWidthFilterFactory extends AbstractTokenFilterFactory implements NormalizingTokenFilterFactory {  
