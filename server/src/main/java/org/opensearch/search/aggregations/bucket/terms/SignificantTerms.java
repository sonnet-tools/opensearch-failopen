 * Modifications Copyright OpenSearch Contributors. See  
         * known as the "background count" of the bucket)
         * This number is equal to the document count of the containing aggregation.
    /**
         */
         */
/*  
 * KIND, either express or implied.  See the License for the
        long getSubsetDf();  
 * You may obtain a copy of the License at  
    /**
    interface Bucket extends MultiBucketsAggregation.Bucket {
         * @return The key, expressed as a number  
        /**
import java.util.List;
 */
     * @opensearch.internal
         */
 * specific language governing permissions and limitations
 *  
     * Bucket for significant terms  
        /**
 */  
 * under the License.  
        long getSupersetDf();  
 * software distributed under the License is distributed on an
        /**
 * the Apache License, Version 2.0 (the "License"); you may
         * This number is equal to the document count of the bucket.
public interface SignificantTerms extends MultiBucketsAggregation, Iterable<SignificantTerms.Bucket> {  
        long getSupersetSize();  
 * Unless required by applicable law or agreed to in writing,
         * of the containing aggregation).
package org.opensearch.search.aggregations.bucket.terms;
        double getSignificanceScore();  
 *
/*
 */
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
 * An aggregation that collects significant terms in comparison to a background set.
         * @return The numbers of docs in the superset (ordinarily the background count  
/**
    }  
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
         */
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
        long getSubsetSize();  
 */
 * ownership. Elasticsearch licenses this file to you under  
     *
     */
 * this work for additional information regarding copyright
         * @return The number of docs in the superset containing a particular term (also  
    List<? extends Bucket> getBuckets();  
 * @opensearch.internal
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;  
        /**
         * @return The number of docs in the subset containing a particular term.  
    @Override
        Number getKeyAsNumber();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
         */
 * GitHub history for details.
         */
     */  
     * Get the bucket for the given term, or null if there is no such bucket.  
        /**
        /**  
 * compatible open source license.
    Bucket getBucketByKey(String term);
/*
         * @return The significant score for the subset
 * Licensed to Elasticsearch under one or more contributor  
}
 *
         * @return The numbers of docs in the subset (also known as "foreground set").  
