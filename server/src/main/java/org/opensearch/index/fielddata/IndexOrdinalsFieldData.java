 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
     * Returns the underlying {@link OrdinalMap} for this fielddata
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
     * by returning the underlying {@link OrdinalMap}. If this method returns false, then calling  
 * under the License.  
/**
    @Override
public interface IndexOrdinalsFieldData extends IndexFieldData.Global<LeafOrdinalsFieldData> {
 */  
 * specific language governing permissions and limitations
    IndexOrdinalsFieldData loadGlobal(DirectoryReader indexReader);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
     */  
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
 * @opensearch.internal
     * or null if global ordinals are not needed (constant value or single segment).  
     */
/*  
    @Override
 * You may obtain a copy of the License at  
package org.opensearch.index.fielddata;
    /**
 * Modifications Copyright OpenSearch Contributors. See
    boolean supportsGlobalOrdinalsMapping();  
     * Load a global view of the ordinals for the given {@link IndexReader}.
    /**
     */  
     * {@link #getOrdinalMap} will result in an {@link UnsupportedOperationException}.
     * Load a global view of the ordinals for the given {@link IndexReader},
 *
    OrdinalMap getOrdinalMap();
 */  
    /**  
import org.apache.lucene.index.OrdinalMap;  
/*  
import org.apache.lucene.index.DirectoryReader;
 */  
     */
/*
 * Specialization of {@link IndexFieldData} for data that is indexed with ordinals.  
 * GitHub history for details.
     * potentially from a cache.
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 * SPDX-License-Identifier: Apache-2.0
    /**
import org.apache.lucene.index.IndexReader;
 * license agreements. See the NOTICE file distributed with
    IndexOrdinalsFieldData loadGlobalDirect(DirectoryReader indexReader) throws Exception;
 * Unless required by applicable law or agreed to in writing,
     * Whether this field data is able to provide a mapping between global and segment ordinals,
 */
 *  
}
