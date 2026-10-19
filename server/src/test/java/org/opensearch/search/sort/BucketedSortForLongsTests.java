                        return (long) values[index];  
import org.opensearch.search.DocValueFormat;
    @Override
    protected double randomValue() {
                    @Override
    @Override  
        int bucketSize,  
 * this work for additional information regarding copyright
 *
    @Override
/*  
    protected SortValue expectedSortValue(double v) {
 * ownership. Elasticsearch licenses this file to you under  
            @Override
        return randomLongBetween(-2L ^ 50, 2L ^ 50);  
 */
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
                    }
    }
 * SPDX-License-Identifier: Apache-2.0
    }
        };
import org.apache.lucene.index.LeafReaderContext;
 * compatible open source license.
        SortOrder sortOrder,
 *
}
 *  
                    }
    public BucketedSort.ForLongs build(  
        DocValueFormat format,
    ) {  
                    int index = -1;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
                        return doc < values.length;
 */  
 * The OpenSearch Contributors require contributions made to  
        double[] values
/*
                    protected long docValue() {
/*  
 * GitHub history for details.
    }
public class BucketedSortForLongsTests extends BucketedSortTestCase<BucketedSort.ForLongs> {
                };
                        index = doc;  
                return new Leaf(ctx) {
            }  
 */  
                    protected boolean advanceExact(int doc) {
 * not use this file except in compliance with the License.
        return SortValue.from((long) v);  
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
        return new BucketedSort.ForLongs(bigArrays(), sortOrder, format, bucketSize, extra) {
            public Leaf forLeaf(LeafReaderContext ctx) {  
                    @Override
 * Modifications Copyright OpenSearch Contributors. See
        // 2L^50 fits in the mantisa of a double which the test sort of needs.
        BucketedSort.ExtraData extra,
package org.opensearch.search.sort;
