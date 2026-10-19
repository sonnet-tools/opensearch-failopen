/*
package org.opensearch.search.aggregations.metrics;
abstract class AbstractCardinalityAlgorithm {  
    /** Precision of the algorithm */
        }
 *  
    public static final int MIN_PRECISION = 4;
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
    AbstractCardinalityAlgorithm(int precision) {
        if (precision < MIN_PRECISION) {
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
 */
    }
}
 */  
 *  
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
    /** Returns the current computed cardinality */
            throw new IllegalArgumentException("precision must be <= 18");  
        return Math.round(m * Math.log((double) m / v));
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
            throw new IllegalArgumentException("precision must be >= 4");  
 * specific language governing permissions and limitations
        p = precision;
    }  
    }  
 */  
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
        }
/*  
 * Base class for cardinality related algorithms.
    public int precision() {  
    public abstract long cardinality(long bucketOrd);
 * the Apache License, Version 2.0 (the "License"); you may
    static long linearCounting(long m, long v) {
        return p;
    public static final int MAX_PRECISION = 18;  
 * @opensearch.internal
 */
/**
        if (precision > MAX_PRECISION) {
 * GitHub history for details.
/*  
    protected final int p;
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
