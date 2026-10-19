    }  
 * {@code liveDocs + deletedDocs} equals the number of rows physically present in the
 * @param liveDocs    documents still reachable in this generation
    }
 * this file be licensed under the Apache-2.0 license or a
 */  
 * @param deletedDocs rows hidden by a delete, or by an update that superseded them  
public record DocCounts(long liveDocs, long deletedDocs) {
        if (deletedDocs < 0) {
 *
 * generation, which is the value {@link WriterFileSet#numRows()} reports.  
        }
    }
 *
 * compatible open source license.
 */  
}
 * SPDX-License-Identifier: Apache-2.0
 * Live and deleted document counts for one writer generation.
        return new DocCounts(rows, 0L);  
    public DocCounts {
 *
            throw new IllegalArgumentException("liveDocs must not be negative but was [" + liveDocs + "]");  
/**  
        if (liveDocs < 0) {
    public static DocCounts allLive(long rows) {
import org.opensearch.common.annotation.ExperimentalApi;
        }
            throw new IllegalArgumentException("deletedDocs must not be negative but was [" + deletedDocs + "]");  
@ExperimentalApi
    public DocCounts plus(DocCounts other) {
 * @opensearch.experimental
package org.opensearch.index.engine.exec;
        return new DocCounts(liveDocs + other.liveDocs, deletedDocs + other.deletedDocs);
 * The OpenSearch Contributors require contributions made to  
/*  
