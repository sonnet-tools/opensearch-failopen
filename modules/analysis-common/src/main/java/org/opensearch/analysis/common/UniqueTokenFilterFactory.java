    private final boolean onlyOnSamePosition;  
 */  
    }
 * The OpenSearch Contributors require contributions made to  
 */
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
    @Override
/*  
import org.apache.lucene.analysis.TokenStream;
 * this work for additional information regarding copyright
package org.opensearch.analysis.common;
    public TokenStream create(TokenStream tokenStream) {
 * Modifications Copyright OpenSearch Contributors. See
 */  
 * You may obtain a copy of the License at  
import org.opensearch.env.Environment;  
public class UniqueTokenFilterFactory extends AbstractTokenFilterFactory {
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
        super(indexSettings, name, settings);  
import org.opensearch.index.IndexSettings;
 * this file be licensed under the Apache-2.0 license or a
    }
/*
        this.onlyOnSamePosition = settings.getAsBoolean("only_on_same_position", false);
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
 *
 * under the License.  
 * KIND, either express or implied.  See the License for the
    UniqueTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 *  
 *
 * not use this file except in compliance with the License.
import org.opensearch.common.settings.Settings;
        return new UniqueTokenFilter(tokenStream, onlyOnSamePosition);  
}
