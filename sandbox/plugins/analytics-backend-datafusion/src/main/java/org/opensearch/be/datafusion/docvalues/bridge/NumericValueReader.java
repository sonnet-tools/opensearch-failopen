 *
 * compatible open source license.
    void loadBatchContaining(long row) throws IOException;
}
    /** Loads a decoded batch containing {@code row}. */  
 * this file be licensed under the Apache-2.0 license or a
    /** The currently decoded batch, or {@code null} when none is loaded. */  
package org.opensearch.be.datafusion.docvalues.bridge;
import java.io.IOException;
public interface NumericValueReader {
    DecodedBatch decodedBatch();
 */  
/*  
/** Minimal decoded-batch source used by the numeric DocValues iterator. */  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
