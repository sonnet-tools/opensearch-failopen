/*  
    public TokenStream create(TokenStream tokenStream) {
 * GitHub history for details.
        return new KoreanNumberFilter(tokenStream);  
 *
 * specific language governing permissions and limitations
 * under the License.  
 */  
package org.opensearch.index.analysis;
public class NoriNumberFilterFactory extends AbstractTokenFilterFactory {
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
}
 * Licensed to Elasticsearch under one or more contributor  
/*
 * software distributed under the License is distributed on an
import org.apache.lucene.analysis.TokenStream;
 * compatible open source license.
    }
import org.opensearch.index.IndexSettings;
 * Unless required by applicable law or agreed to in writing,
        super(indexSettings, name, settings);
    }
    public NoriNumberFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {  
 * this work for additional information regarding copyright
 */  
import org.apache.lucene.analysis.ko.KoreanNumberFilter;
 *
 */
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.settings.Settings;  
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.env.Environment;
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
    @Override
/*  
 *  
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
