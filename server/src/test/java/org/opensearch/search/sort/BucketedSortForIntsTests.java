 * Licensed to Elasticsearch under one or more contributor  
    ) {  
            }  
package org.opensearch.search.sort;
                        return (int) values[index];  
}
    @Override  
public class BucketedSortForIntsTests extends BucketedSortTestCase<BucketedSort.ForInts> {
 * Modifications Copyright OpenSearch Contributors. See
                    @Override
 */  
                    }
/*  
 *
    }  
    protected double randomValue() {
 * KIND, either express or implied.  See the License for the
 */  
import org.apache.lucene.index.LeafReaderContext;
 * SPDX-License-Identifier: Apache-2.0
                    protected boolean advanceExact(int doc) {
 * compatible open source license.
        BucketedSort.ExtraData extra,
                return new Leaf(ctx) {
        int bucketSize,  
 *
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
                    }
 * this file be licensed under the Apache-2.0 license or a
        return SortValue.from((long) v);  
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
        return randomIntBetween(Integer.MIN_VALUE, Integer.MAX_VALUE);
    public BucketedSort.ForInts build(  
            public Leaf forLeaf(LeafReaderContext ctx) {  
/*
    protected SortValue expectedSortValue(double v) {
 */
/*  
        DocValueFormat format,
                    @Override
        return new BucketedSort.ForInts(bigArrays(), sortOrder, format, bucketSize, extra) {
                };
            @Override
                    protected int docValue() {
 *  
        };
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
import org.opensearch.search.DocValueFormat;
 * under the License.  
        double[] values
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
                        index = doc;  
    }
    }
                    int index = -1;
 * You may obtain a copy of the License at  
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        return doc < values.length;
        SortOrder sortOrder,
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
