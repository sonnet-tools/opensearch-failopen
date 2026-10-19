 * license agreements. See the NOTICE file distributed with
 * @opensearch.internal  
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
/*  
 */  
 * compatible open source license.
/**  
 * Licensed to Elasticsearch under one or more contributor  
 * A CharFilterFactory that also supports normalization
public interface NormalizingCharFilterFactory extends CharFilterFactory {
 * this file be licensed under the Apache-2.0 license or a
 *
 */
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
 *  
    @Override
    default Reader normalize(Reader reader) {
 * Modifications Copyright OpenSearch Contributors. See
 * <p>
}  
 *
/*  
 * The default implementation of {@link #normalize(Reader)} delegates to  
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
        return create(reader);  
 * the Apache License, Version 2.0 (the "License"); you may
 *
 * this work for additional information regarding copyright
    }
package org.opensearch.index.analysis;
 * GitHub history for details.
/*
import java.io.Reader;
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
 * {@link #create(Reader)}
 * SPDX-License-Identifier: Apache-2.0
 */
