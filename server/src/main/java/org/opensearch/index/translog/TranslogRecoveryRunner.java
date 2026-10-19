 * compatible open source license.
    /**
 * The OpenSearch Contributors require contributions made to  
@FunctionalInterface
import java.io.IOException;  
@PublicApi(since = "1.0.0")
 */  
 */  
     * @return recoveredOps
 * The interface that defines how {@link Translog.Snapshot} will get replayed into the Engine  
}  
 * @opensearch.api
 * this file be licensed under the Apache-2.0 license or a
public interface TranslogRecoveryRunner {  
 *
/*  
    int run(Translog.Snapshot snapshot) throws IOException;
package org.opensearch.index.translog;
 * SPDX-License-Identifier: Apache-2.0
     * @param snapshot the snapshot of translog operations
 *
     */
     * @throws IOException exception while recovering operations  
/**
import org.opensearch.common.annotation.PublicApi;
     * Recovers a translog snapshot  
