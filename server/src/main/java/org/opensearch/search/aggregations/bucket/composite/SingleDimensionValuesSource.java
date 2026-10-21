    abstract int hashCode(int slot);
 * Unless required by applicable law or agreed to in writing,
    protected boolean checkIfSortedDocsIsApplicable(IndexReader reader, MappedFieldType fieldType) {
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.lease.Releasable;
     * Returns the after value set for this source.
 * SPDX-License-Identifier: Apache-2.0
            // do not use the index if it has more than 50% of deleted docs
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
import org.opensearch.common.util.BigArrays;
     */
     * the {@link #copyCurrent(int)} and {@link #compareCurrent(int)} methods. Note that these methods
        MissingOrder missingOrder,
        int reverseMul
 *
        return true;
 * You may obtain a copy of the License at
 * The OpenSearch Contributors require contributions made to
     * values of each document. This method compares this current value with the after value
            || fieldType.isSearchable() == false
    abstract int compareCurrent(int slot);
     * Transforms the value in <code>slot</code> to a {@link Comparable} object.
        this.reverseMul = reverseMul;
     */
    abstract T toComparable(int slot) throws IOException;
     */
        DocValueFormat format,
 * Modifications Copyright OpenSearch Contributors. See
        }
    T getAfter() {
    abstract int compareCurrentWithAfter();
 */
import org.opensearch.search.DocValueFormat;
    abstract SortedDocsProducer createSortedDocsProducerOrNull(IndexReader reader, Query query);
    /**
     */
    protected final int reverseMul;
            // inverse of the natural order
    /**
        this.bigArrays = bigArrays;
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under
    /**
 */
        if (fieldType == null
     * @param reverseMul -1 if the natural order ({@link SortOrder#ASC} should be reversed.
     * Returns a hash code value for the current value.
 * A source that can record and compare values of similar type.
/*
    /**
     * @param fieldType The field type or null if the source is a script.
    protected T afterValue;
    abstract LeafBucketCollector getLeafCollector(Comparable value, LeafReaderContext context, LeafBucketCollector next) throws IOException;
    /**
     * Compares the value in <code>from</code> with the value in <code>to</code>.
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.search.sort.SortOrder;
 * this work for additional information regarding copyright
import org.opensearch.index.mapper.MappedFieldType;
    abstract void copyCurrent(int slot);
            || (missingBucket && (afterValue == null || reverseMul == 1 && missingOrder == LAST))
            reverseMul == -1) {
 * software distributed under the License is distributed on an
}
        @Nullable MappedFieldType fieldType,
     *
     * See {@link #getLeafCollector}.
     */
    /**
        boolean missingBucket,
        return afterValue;
 *
import org.apache.lucene.index.LeafReaderContext;
import static org.opensearch.search.aggregations.bucket.missing.MissingOrder.LAST;
    abstract int hashCodeCurrent();
    /**
    /**
 * Licensed to Elasticsearch under one or more contributor
     * See {@link #getLeafCollector}.
    }
     * @param bigArrays The big arrays object.
    }
     */
     * See {@link #getLeafCollector}.
 * specific language governing permissions and limitations
/*
public abstract class SingleDimensionValuesSource<T extends Comparable<T>> implements Releasable {
 * GitHub history for details.
    abstract LeafBucketCollector getLeafCollector(LeafReaderContext context, LeafBucketCollector next) throws IOException;
     */
     * The current value is filled by a {@link LeafBucketCollector} that visits all the
     * @param size The number of values to record.
    /**
     * The current value is filled by a {@link LeafBucketCollector} that visits all the
     * @param format The format of the source.
     */
     */
            return false;
 */
/**
    @Nullable
import org.apache.lucene.index.IndexReader;
     * Creates a new {@link SingleDimensionValuesSource}.
        this.size = size;
    protected final MissingOrder missingOrder;
     * The current value is filled by a {@link LeafBucketCollector} that visits all the
     */
     * {@link LeafBucketCollector#collect} on the provided <code>next</code> collector for each of them.
import org.apache.lucene.search.Query;
/*
 *
     * @param missingOrder The `null bucket's position.
        this.fieldType = fieldType;
 * this file be licensed under the Apache-2.0 license or a
    /**
     * in the context of a collection.
            return false;
        BigArrays bigArrays,
    protected final MappedFieldType fieldType;
    ) {
    /**
     * The current value of this source is set on each call and can be accessed by <code>next</code> via
     */
     * Returns a {@link SortedDocsProducer} or null if this source cannot produce sorted docs.
    SingleDimensionValuesSource(
     * values of each document. This method compares this current value with the value present in
 * not use this file except in compliance with the License.
    abstract void setAfter(Comparable value);
        int size,
     * Returns a hash code value for the provided <code>slot</code>.
     * set on this source and should only be used in the context of a collection.
    /**
        this.missingBucket = missingBucket;
            ||
 * the Apache License, Version 2.0 (the "License"); you may
    protected final BigArrays bigArrays;
     * values of each document. This method saves this current value in a slot and should only be used
     * Sets the after value for this source. Values that compares smaller are filtered.
     * Creates a {@link LeafBucketCollector} that sets the current value for each document to the provided
    }
     * <code>value</code> and invokes {@link LeafBucketCollector#collect} on the provided <code>next</code> collector.
 * under the License.
     * Returns true if a {@link SortedDocsProducer} should be used to optimize the execution.
        if (reader.hasDeletions() && (reader.numDocs() == 0 || (double) reader.numDocs() / (double) reader.maxDoc() < 0.5)) {
    protected final boolean missingBucket;
        this.format = format;
import org.opensearch.common.Nullable;
        this.missingOrder = missingOrder;
 * compatible open source license.
     */
    /**
 * @opensearch.internal
     * are only valid when invoked from the {@link LeafBucketCollector} created in this source.
        this.afterValue = null;
     * the provided slot and should only be used in the context of a collection.
import org.opensearch.search.aggregations.LeafBucketCollector;
 *
package org.opensearch.search.aggregations.bucket.composite;
import java.io.IOException;
     * Creates a {@link LeafBucketCollector} that extracts all values from a document and invokes
     * @param missingBucket If true, an explicit `null bucket represents documents with missing values.
     */
    protected final DocValueFormat format;
    protected final int size;
 */
    abstract int compare(int from, int to);
 * license agreements. See the NOTICE file distributed with
    /**
        }
