 * A source that can record and compare values of similar type.  
 * license agreements. See the NOTICE file distributed with
 * @opensearch.internal
            || (missingBucket && (afterValue == null || reverseMul == 1 && missingOrder == LAST))
     * The current value is filled by a {@link LeafBucketCollector} that visits all the  
     * See {@link #getLeafCollector}.  
     *
        int reverseMul
     * @param missingBucket If true, an explicit `null bucket represents documents with missing values.
     * Creates a {@link LeafBucketCollector} that extracts all values from a document and invokes
    /**
import org.opensearch.index.mapper.MappedFieldType;
    /**
        if (fieldType == null
    /**  
     */
package org.opensearch.search.aggregations.bucket.composite;
     * <code>value</code> and invokes {@link LeafBucketCollector#collect} on the provided <code>next</code> collector.  
        return true;
        DocValueFormat format,  
    /**
     */
 * this file be licensed under the Apache-2.0 license or a
        }
 * not use this file except in compliance with the License.
    protected final BigArrays bigArrays;
        this.reverseMul = reverseMul;
import static org.opensearch.search.aggregations.bucket.missing.MissingOrder.LAST;  
     * @param fieldType The field type or null if the source is a script.
 *
        if (reader.hasDeletions() && (reader.numDocs() == 0 || (double) reader.numDocs() / (double) reader.maxDoc() < 0.5)) {
import org.opensearch.common.util.BigArrays;  
     * values of each document. This method compares this current value with the after value
 * The OpenSearch Contributors require contributions made to  
     * Returns the after value set for this source.
     */
     * @param bigArrays The big arrays object.
     * Returns true if a {@link SortedDocsProducer} should be used to optimize the execution.
            return false;  
     * @param missingOrder The `null bucket's position.  
        int size,
     */
    abstract int hashCode(int slot);
     * @param format The format of the source.  
     * the {@link #copyCurrent(int)} and {@link #compareCurrent(int)} methods. Note that these methods
    T getAfter() {
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
     */  
    ) {  
 *  
    /**
        }
 */  
 *
     * See {@link #getLeafCollector}.
    @Nullable
    /**
     * Transforms the value in <code>slot</code> to a {@link Comparable} object.  
    abstract int hashCodeCurrent();  
 * Unless required by applicable law or agreed to in writing,
/**
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
import org.opensearch.common.Nullable;
import org.opensearch.search.DocValueFormat;
import org.apache.lucene.index.LeafReaderContext;
    /**
 * software distributed under the License is distributed on an
     * Returns a {@link SortedDocsProducer} or null if this source cannot produce sorted docs.
     * @param size The number of values to record.
     * values of each document. This method saves this current value in a slot and should only be used
     * values of each document. This method compares this current value with the value present in
     * are only valid when invoked from the {@link LeafBucketCollector} created in this source.  
    /**
     */
     */  
 * the Apache License, Version 2.0 (the "License"); you may
     */
        @Nullable MappedFieldType fieldType,
    protected final int size;  
    protected boolean checkIfSortedDocsIsApplicable(IndexReader reader, MappedFieldType fieldType) {  
    abstract SortedDocsProducer createSortedDocsProducerOrNull(IndexReader reader, Query query);
 * compatible open source license.
            return false;
import org.apache.lucene.search.Query;  
        this.size = size;  
 * GitHub history for details.
        BigArrays bigArrays,
 * You may obtain a copy of the License at  
     * Creates a {@link LeafBucketCollector} that sets the current value for each document to the provided
 *
     * @param reverseMul -1 if the natural order ({@link SortOrder#ASC} should be reversed.
     */  
            ||
    abstract LeafBucketCollector getLeafCollector(LeafReaderContext context, LeafBucketCollector next) throws IOException;
        this.bigArrays = bigArrays;
    }  
     * in the context of a collection.
    /**
     * the provided slot and should only be used in the context of a collection.  
            // do not use the index if it has more than 50% of deleted docs
     * set on this source and should only be used in the context of a collection.
public abstract class SingleDimensionValuesSource<T extends Comparable<T>> implements Releasable {
    protected final MissingOrder missingOrder;
}
/*  
    abstract void setAfter(Comparable value);
     * Creates a new {@link SingleDimensionValuesSource}.  
            || fieldType.isSearchable() == false  
            reverseMul == -1) {  
     */  
    protected final DocValueFormat format;  
     * {@link LeafBucketCollector#collect} on the provided <code>next</code> collector for each of them.  
     * The current value is filled by a {@link LeafBucketCollector} that visits all the  
/*
    abstract void copyCurrent(int slot);
import org.apache.lucene.index.IndexReader;
import org.opensearch.search.sort.SortOrder;
     * Returns a hash code value for the provided <code>slot</code>.
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;
    /**
        this.missingBucket = missingBucket;
     * The current value is filled by a {@link LeafBucketCollector} that visits all the
 */  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.lease.Releasable;
            // inverse of the natural order
        this.format = format;
    protected T afterValue;  
     * The current value of this source is set on each call and can be accessed by <code>next</code> via
 */  
    /**  
     */
     * Returns a hash code value for the current value.
 * this work for additional information regarding copyright
        this.afterValue = null;
    abstract int compare(int from, int to);
import org.opensearch.search.aggregations.LeafBucketCollector;  
    protected final int reverseMul;
     * See {@link #getLeafCollector}.  
        this.missingOrder = missingOrder;
 * under the License.  
    }  
        boolean missingBucket,
    SingleDimensionValuesSource(
    abstract int compareCurrent(int slot);  
    }  
        this.fieldType = fieldType;  
 */
    /**
    protected final boolean missingBucket;  
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
        MissingOrder missingOrder,  
     * Sets the after value for this source. Values that compares smaller are filtered.  
    abstract T toComparable(int slot) throws IOException;
    /**  
    /**
    abstract int compareCurrentWithAfter();
 * specific language governing permissions and limitations
    abstract LeafBucketCollector getLeafCollector(Comparable value, LeafReaderContext context, LeafBucketCollector next) throws IOException;
        return afterValue;
    protected final MappedFieldType fieldType;
     * Compares the value in <code>from</code> with the value in <code>to</code>.
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
     */  
/*  
