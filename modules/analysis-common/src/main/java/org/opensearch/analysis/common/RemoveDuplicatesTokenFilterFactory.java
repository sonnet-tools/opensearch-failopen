import org.opensearch.index.analysis.AbstractTokenFilterFactory;  
import org.opensearch.env.Environment;
/*  
 * under the License.  
 * specific language governing permissions and limitations
 */
/**
class RemoveDuplicatesTokenFilterFactory extends AbstractTokenFilterFactory {
 *  
 * GitHub history for details.
 *
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
package org.opensearch.analysis.common;
 * SPDX-License-Identifier: Apache-2.0
        return new RemoveDuplicatesTokenFilter(tokenStream);
 */  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.settings.Settings;  
 * this file be licensed under the Apache-2.0 license or a
        super(indexSettings, name, settings);
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.analysis.TokenStream;
    RemoveDuplicatesTokenFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    public TokenStream create(TokenStream tokenStream) {  
 */
 *
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
import org.apache.lucene.analysis.miscellaneous.RemoveDuplicatesTokenFilter;
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
 * Filter factory for the lucene RemoveDuplicatesTokenFilter  
import org.opensearch.index.IndexSettings;
    @Override
 * software distributed under the License is distributed on an
/*  
 * Unless required by applicable law or agreed to in writing,
 */  
 * compatible open source license.
 * this work for additional information regarding copyright
}  
    }
