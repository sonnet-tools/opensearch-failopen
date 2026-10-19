/*  
    @Override
            public Leaf forLeaf(LeafReaderContext ctx) {  
    }
        SortOrder sortOrder,
    }
            }  
        };
 * The OpenSearch Contributors require contributions made to  
    protected boolean isUnsignedNumeric() {  
}  
        BucketedSort.ExtraData extra,
 * compatible open source license.
                    }
                    protected long docValue() {
                    int index = -1;
    protected SortValue expectedSortValue(double v) {
        int bucketSize,  
    }  
    @Override
import org.apache.lucene.index.LeafReaderContext;
                        return (long) values[index];  
    public BucketedSort.ForUnsignedLongs build(  
 * SPDX-License-Identifier: Apache-2.0
    }
    @Override
                    @Override
                        return doc < values.length;
    protected double randomValue() {
                        index = doc;  
package org.opensearch.search.sort;
 *
        return SortValue.fromUnsigned((long) v);  
public class BucketedSortForUnsignedLongsTests extends BucketedSortTestCase<BucketedSort.ForUnsignedLongs> {
    ) {  
                    }
        return true;
    @Override  
        double[] values
                    @Override
        return new BucketedSort.ForUnsignedLongs(bigArrays(), sortOrder, format, bucketSize, extra) {
                };
 */  
 * this file be licensed under the Apache-2.0 license or a
                    protected boolean advanceExact(int doc) {
            @Override
                return new Leaf(ctx) {
        DocValueFormat format,
import org.opensearch.search.DocValueFormat;
        return randomUnsignedLong().doubleValue();
