 * Licensed to Elasticsearch under one or more contributor  
 */
    /**
     * Return the ordinals values for the current atomic reader.  
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
/*  
/**  
 */
 * specific language governing permissions and limitations
 *  
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
 */  
}
 *  
/*
 * not use this file except in compliance with the License.
 * compatible open source license.
/*  
 * this work for additional information regarding copyright
 * ordinals.
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
public interface LeafOrdinalsFieldData extends LeafFieldData {  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.index.SortedSetDocValues;
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
 *
 * the Apache License, Version 2.0 (the "License"); you may
     */
 * under the License.  
package org.opensearch.index.fielddata;
 *
 * Specialization of {@link LeafFieldData} for data that is indexed with
 */  
 * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
    SortedSetDocValues getOrdinalsValues();
