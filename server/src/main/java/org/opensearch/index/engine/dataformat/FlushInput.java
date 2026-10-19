package org.opensearch.index.engine.dataformat;
public record FlushInput(RowIdMapping rowIdMapping) {
     */  
    }  
@ExperimentalApi
 *
        return rowIdMapping != null;
 * @opensearch.experimental
    public static final FlushInput EMPTY = new FlushInput((RowIdMapping) null);
    public boolean hasRowIdMapping() {
}
    /** Empty flush input with no row ID mapping. */
    /**
     * Returns whether a row ID mapping is available.
 */  
 * The OpenSearch Contributors require contributions made to  
 *
 * SPDX-License-Identifier: Apache-2.0
 * Parameter object for {@link Writer#flush(FlushInput)}.
/**  
/*  
 * this file be licensed under the Apache-2.0 license or a
 */  
 * Carries optional context that writers may use during flush.
 * compatible open source license.
import org.opensearch.common.annotation.ExperimentalApi;
 * Writers that don't need any context simply ignore the fields.  
