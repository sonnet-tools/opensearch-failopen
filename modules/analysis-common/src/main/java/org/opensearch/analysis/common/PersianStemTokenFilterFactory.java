public class PersianStemTokenFilterFactory extends AbstractTokenFilterFactory {
 *  
/*  
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
    PersianStemTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
/*  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.IndexSettings;
 * Unless required by applicable law or agreed to in writing,
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}  
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
        super(indexSettings, name, settings);
 * software distributed under the License is distributed on an
    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.analysis.AbstractTokenFilterFactory;  
package org.opensearch.analysis.common;
import org.apache.lucene.analysis.fa.PersianStemFilter;
 */  
    @Override
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.settings.Settings;  
 * KIND, either express or implied.  See the License for the
    }  
 * SPDX-License-Identifier: Apache-2.0
    public TokenStream create(TokenStream tokenStream) {  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
import org.opensearch.env.Environment;
/*
 * You may obtain a copy of the License at  
 * under the License.  
        return new PersianStemFilter(tokenStream);
 *
 */
import org.apache.lucene.analysis.TokenStream;
 */  
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
