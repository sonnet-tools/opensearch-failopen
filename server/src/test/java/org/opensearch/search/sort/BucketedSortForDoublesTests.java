        BucketedSort.ExtraData extra,
                    int index = -1;
    @Override
 * compatible open source license.
        return SortValue.from(v);  
                return new Leaf(ctx) {
                        return values[index];  
            }  
                    }
 *
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
        double[] values
                    @Override
    ) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        return doc < values.length;
        int bucketSize,  
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
    protected SortValue expectedSortValue(double v) {
 *
    public BucketedSort.ForDoubles build(  
            @Override
 * license agreements. See the NOTICE file distributed with
    @Override  
    }
                        index = doc;  
                };
        return randomDouble();
 * under the License.  
 * You may obtain a copy of the License at  
                    protected boolean advanceExact(int doc) {
 * the Apache License, Version 2.0 (the "License"); you may
        DocValueFormat format,
 * not use this file except in compliance with the License.
/*  
    }  
 */
 * ownership. Elasticsearch licenses this file to you under  
    @Override
}
public class BucketedSortForDoublesTests extends BucketedSortTestCase<BucketedSort.ForDoubles> {
                    }
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
        };
package org.opensearch.search.sort;
    protected double randomValue() {
 * this work for additional information regarding copyright
/*  
import org.opensearch.search.DocValueFormat;
 */  
 * KIND, either express or implied.  See the License for the
        return new BucketedSort.ForDoubles(bigArrays(), sortOrder, format, bucketSize, extra) {
/*
                    @Override
 * this file be licensed under the Apache-2.0 license or a
            public Leaf forLeaf(LeafReaderContext ctx) {  
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */  
import org.apache.lucene.index.LeafReaderContext;
        SortOrder sortOrder,
                    protected double docValue() {
    }
 *  
