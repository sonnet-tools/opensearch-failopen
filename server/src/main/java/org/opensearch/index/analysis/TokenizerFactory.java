 * Base tokenizer factory used in analysis chain
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
package org.opensearch.index.analysis;
    static TokenizerFactory newFactory(String name, Supplier<Tokenizer> supplier) {  
import org.apache.lucene.analysis.Tokenizer;
 * Licensed to Elasticsearch under one or more contributor  
 */
/*  
public interface TokenizerFactory {  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.annotation.PublicApi;
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
 *
            }
            public String name() {  
 */  
import java.util.function.Supplier;
    }  
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
 */  
 * software distributed under the License is distributed on an
@PublicApi(since = "1.0.0")
            @Override
 * compatible open source license.
 * You may obtain a copy of the License at  
/**  
}
 * SPDX-License-Identifier: Apache-2.0
                return supplier.get();  
            @Override
        };
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 * license agreements. See the NOTICE file distributed with
        return new TokenizerFactory() {
    Tokenizer create();
    String name();
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
                return name;
 *
 */
 * ownership. Elasticsearch licenses this file to you under  
 * @opensearch.api  
 * under the License.  
            public Tokenizer create() {
 * this work for additional information regarding copyright
