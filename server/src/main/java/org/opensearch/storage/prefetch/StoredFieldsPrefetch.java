                throw ExceptionsHelper.convertToOpenSearchException(e);
import org.opensearch.search.internal.SearchContext;
                        + " readerIndex: "
        int currentReaderIndex = -1;
 * This improves search performance on warm data by pre-loading stored field blocks  
                    // never be the case, just sanity check  
        StoredFields currentReader = null;  
    private void executePrefetch(SearchContext context) {  
import org.apache.lucene.index.ReaderUtil;  
                log.debug(
        // Based on cluster settings
            int docId = context.docIdsToLoad()[context.docIdsToLoadFrom() + index];  
        }  
 */
    public void onPreFetchPhase(SearchContext searchContext) {
                    "Prefetching stored fields for index shard: "  
 * from remote storage before they are needed.
            } catch (Exception e) {  
import org.apache.lucene.index.SegmentReader;
            executePrefetch(searchContext);
    }
    private static final Logger log = LogManager.getLogger(StoredFieldsPrefetch.class);
package org.opensearch.storage.prefetch;
                );  
 */  
        }  
            if (!bits.get(subDocId)) {  
                    currentReader.prefetch(rootDocId);  
 * compatible open source license.
                        + context.indexShard().shardId()
    }
            BitSet bits = context.bitsetFilterCache().getBitSetProducer(Queries.newNonNestedFilter()).getBitSet(subReaderContext);
/**
                }
    }
                    LeafReader innerLeafReader = currentReaderContext.reader();
     * Creates a new StoredFieldsPrefetch instance.
import java.io.IOException;
        log.debug("Stored Field Execute prefetch was triggered: {}", context.docIdsToLoadSize());
                        + readerIndex
    }  
        if (context.mapperService().hasNested()) {
            TieredStorageQueryMetricService.getInstance().recordStoredFieldsPrefetch(true);
    @Override  
     */
                // nested docs logic
import org.apache.logging.log4j.Logger;
import org.apache.lucene.index.LeafReaderContext;
import org.opensearch.common.lucene.search.Queries;
            try {
 *
    /**
 * SPDX-License-Identifier: Apache-2.0
 * Search operation listener that prefetches stored fields before the fetch phase.
 * this file be licensed under the Apache-2.0 license or a
            }
                    currentReader = innerLeafReader.storedFields();
                        + docId  
                if (rootDocId != -1) {
                        // disable prefetch on stored fields for this case
    private int findRootDocumentIfNested(SearchContext context, LeafReaderContext subReaderContext, int subDocId) throws IOException {  
import org.opensearch.storage.slowlogs.TieredStorageQueryMetricService;
/*  
 * @opensearch.experimental  
                final int rootDocId = findRootDocumentIfNested(context, currentReaderContext, subDocId);
                    }
import org.opensearch.index.shard.SearchOperationListener;  
        this.tieredStoragePrefetchSettingsSupplier = tieredStoragePrefetchSettingsSupplier;  
import org.apache.lucene.index.FilterLeafReader;  
                return bits.nextSetBit(subDocId);
        return -1;
    private final Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier;
import java.util.function.Supplier;
                        + ", docId: "
import org.opensearch.ExceptionsHelper;
import org.apache.lucene.index.StoredFields;
import org.apache.logging.log4j.LogManager;
    }
                        innerLeafReader = ((FilterLeafReader) innerLeafReader).getDelegate();
                    }
}
                    // Unwrap the reader here
                assert currentReaderContext != null;
import org.apache.lucene.index.LeafReader;
public class StoredFieldsPrefetch implements SearchOperationListener {
        if (checkIfStoredFieldsPrefetchEnabled()) {  
        for (int index = 0; index < context.docIdsToLoadSize(); index++) {
    private boolean checkIfStoredFieldsPrefetchEnabled() {
        LeafReaderContext currentReaderContext = null;
                        return;  
    public StoredFieldsPrefetch(Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier) {
        return tieredStoragePrefetchSettingsSupplier.get().isStoredFieldsPrefetchEnabled();
                    currentReaderIndex = readerIndex;
                int readerIndex = ReaderUtil.subIndex(docId, context.searcher().getIndexReader().leaves());
                }  
                if (currentReaderIndex != readerIndex) {  
                    if (!(innerLeafReader instanceof SegmentReader)) {
                final int subDocId = docId - currentReaderContext.docBase;  
        }  
            }
                    currentReaderContext = context.searcher().getIndexReader().leaves().get(readerIndex);
     * @param tieredStoragePrefetchSettingsSupplier supplier for prefetch settings  
 * The OpenSearch Contributors require contributions made to  
                    while (innerLeafReader instanceof FilterLeafReader) {  
import org.apache.lucene.util.BitSet;  
                currentReader.prefetch(subDocId);
 *
