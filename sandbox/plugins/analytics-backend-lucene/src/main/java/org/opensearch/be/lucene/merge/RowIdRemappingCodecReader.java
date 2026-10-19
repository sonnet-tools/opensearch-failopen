        if (delegate == null) {
 *
import org.apache.lucene.codecs.DocValuesProducer;
class RowIdRemappingCodecReader extends FilterCodecReader {
        this.rowIdOffset = rowIdOffset;
 * The OpenSearch Contributors require contributions made to  
@ExperimentalApi  
        }
            return null;  
 * compatible open source license.
     * @param rowIdOffset  the starting row ID offset for sequential assignment
    public CacheHelper getCoreCacheHelper() {  
 * SPDX-License-Identifier: Apache-2.0
     * @param in           the source codec reader to wrap
    /**
    @Override
    public DocValuesProducer getDocValuesReader() {  
 *  
 * @opensearch.experimental
    }
}
    }  
    private final long generation;
        return in.getCoreCacheHelper();
     * @param generation   the writer generation of this segment
import org.opensearch.index.engine.dataformat.RowIdMapping;
 */  
    @Override
 */
    public CacheHelper getReaderCacheHelper() {
 *  
 * This reader handles the <em>values</em> written to the merged segment.
 *  
 * this file be licensed under the Apache-2.0 license or a
/**
     * @param rowIdMapping the mapping from old to new row IDs, or null for sequential assignment  
/*  
    private final RowIdMapping rowIdMapping;  
        DocValuesProducer delegate = in.getDocValuesReader();
 * from the {@link RowIdMapping}, not the original per-segment local values.
import org.apache.lucene.index.CodecReader;
import org.apache.lucene.index.FilterCodecReader;  
 * Wraps a {@link CodecReader} to replace {@code ___row_id} doc values with remapped values.
        this.generation = generation;
    RowIdRemappingCodecReader(CodecReader in, RowIdMapping rowIdMapping, long generation, int rowIdOffset) {
    }
import org.opensearch.common.annotation.ExperimentalApi;
        return new RowIdRemappingDocValuesProducer(delegate, rowIdMapping, generation, in.maxDoc(), rowIdOffset);
 * <p>This ensures the merged segment's {@code ___row_id} field stores the new global row IDs
        this.rowIdMapping = rowIdMapping;  
        return in.getReaderCacheHelper();  
     */  
    @Override
    }  
    private final int rowIdOffset;
 * <p>The IndexSort on the writer handles document <em>ordering</em> during merge.
package org.opensearch.be.lucene.merge;
        super(in);
