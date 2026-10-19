 * KIND, either express or implied.  See the License for the
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
            return Double.isNaN(d2) ? 0 : 1;
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
public enum Comparators {
 * compatible open source license.
package org.opensearch.common.util;
    }
 * {@link Comparator}-related utility methods.
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
 */
 *
import java.util.Comparator;
 */  
 * Modifications Copyright OpenSearch Contributors. See
 *  
/**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
/*  
 * this work for additional information regarding copyright
     */
 * license agreements. See the NOTICE file distributed with
            return -1;  
        }  
 * this file be licensed under the Apache-2.0 license or a
}  
        if (Double.isNaN(d1)) {  
 * specific language governing permissions and limitations
/*  
            return asc ? Double.compare(d1, d2) : Double.compare(d2, d1);
/*
 * the Apache License, Version 2.0 (the "License"); you may
     * Compare <code>d1</code> against <code>d2</code>, pushing {@value Double#NaN} at the bottom.  
 * You may obtain a copy of the License at  
        } else if (Double.isNaN(d2)) {
 * not use this file except in compliance with the License.
    public static int compareDiscardNaN(double d1, double d2, boolean asc) {
    /**
 * GitHub history for details.
 * @opensearch.internal  
    ;  
 * under the License.  
 *
 */  
        } else {
 */
