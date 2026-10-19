 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
}
        return new KoreanReadingFormFilter(tokenStream);
import org.opensearch.env.Environment;
 * license agreements. See the NOTICE file distributed with
/*
 * KIND, either express or implied.  See the License for the
    @Override  
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.analysis.ko.KoreanReadingFormFilter;
 * under the License.  
 * not use this file except in compliance with the License.
 *
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
 *  
    }
package org.opensearch.index.analysis;
 */  
 * compatible open source license.
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
public class NoriReadingFormFilterFactory extends AbstractTokenFilterFactory {
        super(indexSettings, name, settings);  
import org.opensearch.index.IndexSettings;
 */  
import org.apache.lucene.analysis.TokenStream;
/*  
import org.opensearch.common.settings.Settings;  
 * specific language governing permissions and limitations
    }  
 *
/*  
 * Unless required by applicable law or agreed to in writing,
    public TokenStream create(TokenStream tokenStream) {
    public NoriReadingFormFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
