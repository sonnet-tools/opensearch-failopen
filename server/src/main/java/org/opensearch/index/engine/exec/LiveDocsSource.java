 * this file be licensed under the Apache-2.0 license or a
        List<LiveDocsSource> sources = new ArrayList<>();  
     * @return per-generation counts, empty if this source cannot answer for this snapshot  
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;  
import java.util.ArrayList;  
        }
     * @param catalogSnapshot the snapshot to report on
                source.docCountsByGeneration(catalogSnapshot)
     * @return a resolver that returns an empty map when no format holds liveness information
     */
package org.opensearch.index.engine.exec;
     * asks them for per-generation counts.
 * @opensearch.experimental  
    /**
     * @param readerManagers the shard's reader managers, in any order  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.CheckedFunction;
            return catalogSnapshot -> Map.of();
 *
     * @throws IOException if reading the underlying reader fails
 */
        for (EngineReaderManager<?> readerManager : readerManagers) {
     * Live and hidden document counts for the given snapshot, keyed by writer generation.  
        };
}
public interface LiveDocsSource {  
                sources.add((LiveDocsSource) readerManager);  
            }
 * compatible open source license.
    /**
     */
/*  
import java.util.Map;
        Collection<? extends EngineReaderManager<?>> readerManagers
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
     *
            if (readerManager instanceof LiveDocsSource) {
 * Implemented by a reader manager whose data format knows which rows are still reachable.
            for (LiveDocsSource source : sources) {  
        return catalogSnapshot -> {
        if (sources.isEmpty()) {
                    .forEach((generation, generationCounts) -> counts.merge(generation, generationCounts, DocCounts::plus));
import java.util.List;  
import java.util.Collection;
import java.util.HashMap;
    }  
 *
            return counts;
/**  
    ) {
        }  
     *
        assert sources.size() <= 1 : "at most one data format may hold liveness information, found " + sources.size();  
    static CheckedFunction<CatalogSnapshot, Map<Long, DocCounts>, IOException> docCountsResolver(  
     * Picks the live docs sources out of a shard's reader managers once, and returns a function that  
    Map<Long, DocCounts> docCountsByGeneration(CatalogSnapshot catalogSnapshot) throws IOException;  
            }  
 */  
            Map<Long, DocCounts> counts = new HashMap<>();
import org.opensearch.common.annotation.ExperimentalApi;
@ExperimentalApi
