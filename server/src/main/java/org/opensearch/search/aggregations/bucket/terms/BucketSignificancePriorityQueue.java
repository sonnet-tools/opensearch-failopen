    @Override
 * the Apache License, Version 2.0 (the "License"); you may
/**  
 * license agreements. See the NOTICE file distributed with
    public BucketSignificancePriorityQueue(int size) {
 * @opensearch.internal  
public class BucketSignificancePriorityQueue<B extends SignificantTerms.Bucket> extends PriorityQueue<B> {
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
 *
 * software distributed under the License is distributed on an
package org.opensearch.search.aggregations.bucket.terms;
 */  
        super(size);
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.util.PriorityQueue;
 * specific language governing permissions and limitations
 *
 * this work for additional information regarding copyright
 */
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
    }
}  
    protected boolean lessThan(SignificantTerms.Bucket o1, SignificantTerms.Bucket o2) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
        return o1.getSignificanceScore() < o2.getSignificanceScore();
/*  
 */
 */  
 * this file be licensed under the Apache-2.0 license or a
 * Priority queue for computing bucket significance
    }  
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
 *
 * You may obtain a copy of the License at  
/*
