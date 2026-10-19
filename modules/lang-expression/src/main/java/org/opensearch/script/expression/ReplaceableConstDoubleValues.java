    @Override
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
    }  
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
}
    }
final class ReplaceableConstDoubleValues extends DoubleValues {
 * by a {@link DoubleValues} to be modified.
 */  
        return value;
 */  
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
 *
 *
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
/*  
 * A support class for an executable expression script that allows the double returned
import org.apache.lucene.search.DoubleValues;
    }
/*
 * this file be licensed under the Apache-2.0 license or a
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**  
    public boolean advanceExact(int doc) {
 * SPDX-License-Identifier: Apache-2.0
 *  
 */  
    private double value = 0;
        return true;  
    public double doubleValue() {  
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
 * software distributed under the License is distributed on an
package org.opensearch.script.expression;
 * under the License.  
    @Override
 */
 * license agreements. See the NOTICE file distributed with
        this.value = value;
 * You may obtain a copy of the License at  
    void setValue(double value) {
