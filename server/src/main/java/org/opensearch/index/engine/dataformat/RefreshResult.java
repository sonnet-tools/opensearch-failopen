 *
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.experimental
/**
import java.util.List;
    }
}  
 * during the refresh cycle (dropped from the catalog so it stays consistent with the reader).  
public record RefreshResult(List<Segment> refreshedSegments, Set<Long> droppedGenerations) {
@ExperimentalApi
import java.util.Set;
package org.opensearch.index.engine.dataformat;
import org.opensearch.common.annotation.ExperimentalApi;
 * Result of a refresh operation: the refreshed segments plus any generations that were fully deleted
import org.opensearch.index.engine.exec.Segment;
        this(refreshedSegments, Set.of());
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */  
/*  
 */  
 *
    public RefreshResult(List<Segment> refreshedSegments) {  
