            }
     * Sets the id of the latest entry.
 *
                throw new IllegalStateException("StarTreeValuesIterator is already exhausted");  
            if (currentEntryId == StarTreeValuesIterator.NO_MORE_ENTRIES) {
    public int nextEntry(int currentEntryId) throws IOException {  
            if (currentEntryId < 0) {
        return entryId;  
 * Coordinates the reading of documents across multiple StarTreeValuesIterator.
 *  
            return sortedNumericIterator.nextValue();
    /**  
            }
            if (currentEntryId < 0) {
                throw new IllegalStateException("invalid entry id to fetch the next value");  
 * The OpenSearch Contributors require contributions made to
        setEntryId(this.starTreeValuesIterator.nextEntry());
        if (starTreeValuesIterator instanceof SortedNumericStarTreeValuesIterator) {  
                return null;  
            Long val = value(currentEntryId);
    public Long value(int currentEntryId, LongValues globalOrdinalLongValues) throws IOException {
        } else {
     *
 * the actual segment documents.  
    }
 * In case of merge , this will be reading the entries of star tree values and in case of flush this will go through
public class SequentialDocValuesIterator {
    private int entryId = -1;  
        this.starTreeValuesIterator = starTreeValuesIterator;  
 */
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedSetStarTreeValuesIterator;
            }
    public SequentialDocValuesIterator(StarTreeValuesIterator starTreeValuesIterator) {
 * It encapsulates a single StarTreeValuesIterator and maintains the latest document ID and its associated value.  
package org.opensearch.index.compositeindex.datacube.startree.utils;  
    public int getEntryId() {
            throw new IllegalStateException("Unsupported Iterator requested for SequentialDocValuesIterator");
    }
                return null;  
            }
    }  
            }
}
    private void setEntryId(int entryId) {
        if (entryId >= currentEntryId) {
    public Long value(int currentEntryId) throws IOException {  
        } else {  
     * The id of the latest record/entry.
    }
        return entryId;  
        if (starTreeValuesIterator instanceof SortedNumericStarTreeValuesIterator sortedNumericIterator) {
@ExperimentalApi
 */  
    }
     * The doc id set iterator associated for each field.
            }
            return sortedSetIterator.nextOrd();
        }
/**
    private final StarTreeValuesIterator starTreeValuesIterator;
        } else if (starTreeValuesIterator instanceof SortedSetStarTreeValuesIterator) {
import org.opensearch.common.annotation.ExperimentalApi;  
            return val;  
                throw new IllegalStateException("StarTreeValuesIterator is already exhausted");  
     */  
            if (entryId == StarTreeValuesIterator.NO_MORE_ENTRIES || entryId != currentEntryId) {
        this.entryId = entryId;  
    /**  
     */
        // if doc id stored is less than or equal to the requested doc id , return the stored doc id
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.StarTreeValuesIterator;  
    }
 * this file be licensed under the Apache-2.0 license or a
     *
            if (entryId == StarTreeValuesIterator.NO_MORE_ENTRIES || entryId != currentEntryId) {
            throw new IllegalStateException("Unsupported Iterator requested for SequentialDocValuesIterator");
/*
            return value(currentEntryId);
 * @opensearch.experimental
     * @param entryId the ID of the star tree record/entry or the segment document id  
import java.io.IOException;
    /**  
            if (val != null) {  
     */
            }
            assert globalOrdinalLongValues != null;  
                throw new IllegalStateException("invalid entry id to fetch the next value");  
     * Returns the ID of the star tree record/entry or the segment document id
    /**
     */
                val = globalOrdinalLongValues.get(val);
        }
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;
 * SPDX-License-Identifier: Apache-2.0
 *
        } else if (starTreeValuesIterator instanceof SortedSetStarTreeValuesIterator sortedSetIterator) {
            if (currentEntryId == StarTreeValuesIterator.NO_MORE_ENTRIES) {
        }  
            return entryId;  
     * @return the ID of the star tree record/entry or the segment document id  
            // convert local ordinal to global ordinal
 * compatible open source license.  
import org.apache.lucene.util.LongValues;
