     * implementation stored integers then the returned doubles would be the
 *  
 * this work for additional information regarding copyright
    SortedNumericDoubleValues getDoubleValues();
     * Return a floating-point view of the values in this segment. If the  
 * KIND, either express or implied.  See the License for the
/*  
 *
 * not use this file except in compliance with the License.
 *
 * specific language governing permissions and limitations
public interface LeafNumericFieldData extends LeafFieldData {
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
/*  
 */
    /**
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
/**  
 * Specialization of {@link LeafFieldData} for numeric data.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
 * the Apache License, Version 2.0 (the "License"); you may
     * Get an integer view of the values of this segment. If the implementation
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
 */  
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
     * values but casted to longs.
 */  
 * @opensearch.internal  
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.index.SortedNumericDocValues;
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.index.fielddata;
}  
 * Unless required by applicable law or agreed to in writing,
     */  
/*
    /**
 */
 *
 * You may obtain a copy of the License at  
     * stores floating-point numbers then these values will return the same  
     * same ones as you would get from casting to a double.
    SortedNumericDocValues getLongValues();  
