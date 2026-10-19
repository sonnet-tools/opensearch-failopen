    private final long shardKeyPrefix;
        return new FieldComparator<Long>() {
    public ShardDocFieldComparatorSource(int shardId) {  
package org.opensearch.search.sort;
                    }
                return values[slot];
    /**  
    @Override  
                        return Long.compare(topValue, computeGlobalDocKey(doc));  
/*  
import org.apache.lucene.search.SortField;  
                    public void setBottom(int slot) {
                    private long computeGlobalDocKey(int doc) {  
            public LeafFieldComparator getLeafComparator(LeafReaderContext context) {
import org.apache.lucene.index.LeafReaderContext;
                    public int compareBottom(int doc) {
import org.opensearch.search.MultiValueMode;
    public static final String NAME = "_shard_doc";
import org.opensearch.search.sort.BucketedSort.ExtraData;
            }  
                    @Override  
            @Override
    }
public class ShardDocFieldComparatorSource extends IndexFieldData.XFieldComparatorSource {
                    public void copy(int slot, int doc) {  
        super(null, MultiValueMode.MIN, null);
    }  
import org.apache.lucene.search.Pruning;
                        values[slot] = computeGlobalDocKey(doc);
        return SortField.Type.LONG;
            }
        shardKeyPrefix = ((long) shardId) << 32;
                return new LeafFieldComparator() {
            }
 * compatible open source license.
    public SortField.Type reducedType() {  
                    @Override
import org.apache.lucene.search.LeafFieldComparator;  
                    public void setScorer(Scorable scorer) {  
    }  
    public BucketedSort newBucketedSort(BigArrays bigArrays, SortOrder sortOrder, DocValueFormat format, int bucketSize, ExtraData extra) {
            }
 */  
                this.topValue = value;  
 *
            public int compare(int slot1, int slot2) {
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.search.FieldComparator;
     */
                        return shardKeyPrefix | (docBase + doc);
    @Override
                };  
            public Long value(int slot) {  
                    }
                    }  
 * A pseudo‑field (_shard_doc) comparator that tiebreaks by  {@code (shardId << 32) | globalDocId}
import org.opensearch.search.DocValueFormat;  
}
     * @param shardId the shard ID of this shard
import org.apache.lucene.search.Scorable;
                    @Override
                return Long.compare(values[slot1], values[slot2]);
                    }
            @Override
    @Override
                    public int compareTop(int doc) {
                    @Override
                        this.scorer = scorer;
            private long topValue;
import org.opensearch.index.fielddata.IndexFieldData;
    }
            public void setTopValue(Long value) {
            private final long[] values = new long[numHits];  
            private long bottom;
                    }
                    Scorable scorer;  
 * SPDX-License-Identifier: Apache-2.0
        };
                        return Long.compare(bottom, computeGlobalDocKey(doc));
                        bottom = values[slot];  
    public FieldComparator<Long> newComparator(String fieldname, int numHits, Pruning pruning, boolean reversed) {
 */  
import org.opensearch.common.util.BigArrays;
            @Override
                final int docBase = context.docBase;  
 * The OpenSearch Contributors require contributions made to  
            @Override  
/**
                    }
        throw new UnsupportedOperationException("bucketed sort not supported for " + NAME);  
                    @Override
