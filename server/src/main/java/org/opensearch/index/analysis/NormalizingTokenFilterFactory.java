 * You may obtain a copy of the License at  
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
 * compatible open source license.
 * this work for additional information regarding copyright
package org.opensearch.index.analysis;
 * Modifications Copyright OpenSearch Contributors. See
 * {@link #create(TokenStream)}}.
 *
public interface NormalizingTokenFilterFactory extends TokenFilterFactory {
 * Unless required by applicable law or agreed to in writing,
 */  
 * not use this file except in compliance with the License.
/*  
/*
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}  
 */
        return create(tokenStream);  
 * @opensearch.internal  
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.analysis.TokenStream;
 *
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
 * A TokenFilterFactory that may be used for normalization
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
 * The default implementation delegates {@link #normalize(TokenStream)} to  
/**  
/*  
 *  
 * <p>
 * The OpenSearch Contributors require contributions made to  
 *
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
    }
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
    default TokenStream normalize(TokenStream tokenStream) {
