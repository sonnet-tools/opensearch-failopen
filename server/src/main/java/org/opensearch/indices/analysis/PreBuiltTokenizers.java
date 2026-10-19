    ;
 * You may obtain a copy of the License at  
    public CachingStrategy getCachingStrategy() {
    protected TokenFilterFactory getMultiTermComponent(Version version) {  
}
import org.opensearch.indices.analysis.PreBuiltCacheFactory.CachingStrategy;
/*  
/*
        @Override
 * GitHub history for details.
import org.apache.lucene.analysis.standard.StandardTokenizer;
 */
 *  
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
        return null;
    }
    PreBuiltTokenizers(CachingStrategy cachingStrategy) {  
    }  
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * KIND, either express or implied.  See the License for the
 *
public enum PreBuiltTokenizers {
        this.cachingStrategy = cachingStrategy;
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.analysis.Tokenizer;  
 */  
 * Pre-built tokenizers for analysis
        protected Tokenizer create(Version version) {  
 * under the License.  
    }  
import org.opensearch.index.analysis.TokenFilterFactory;  
 * The OpenSearch Contributors require contributions made to  
 */
 * specific language governing permissions and limitations
    }
 * ownership. Elasticsearch licenses this file to you under  
    STANDARD(CachingStrategy.ONE) {
/**  
import org.opensearch.Version;
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.indices.analysis;
    protected abstract Tokenizer create(Version version);
        return cachingStrategy;
        }
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See  
/*
 *
 * this work for additional information regarding copyright
 * @opensearch.internal  
            return new StandardTokenizer();
 *
 * compatible open source license.
    private final CachingStrategy cachingStrategy;
