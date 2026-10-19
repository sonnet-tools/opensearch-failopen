 */
/**  
 * compatible open source license.
 * <h2>Lifecycle</h2>
        // Default: no resources to release.
 * <p>Extends {@link AutoCloseable} with a narrowed {@code throws IOException} signature so  
 * backends can attach native / resource-holding handles to the context and rely on the
 * orchestrator (e.g. {@code AnalyticsSearchService} or {@code LocalStageExecutionFactory}) to
 * this file be licensed under the Apache-2.0 license or a
 * Backend-specific execution context that flows between successive instruction handler
 * {@code DataFusionSessionState} holding a native SessionContext handle).  
 *
 * subsequent handlers receive and build upon the previous handler's output.  
 * tolerate being called after the resources have already been handed off to a  
    @Override  
 */  
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal  
 *
package org.opensearch.analytics.spi;
 * {@code SearchExecEngine}. Implementations that hold no resources should leave the default
 * calls. The first handler in the chain receives {@code null} and bootstraps the context;
public interface BackendExecutionContext extends AutoCloseable {
 *
 * successfully-constructed engine.
 *
import java.io.IOException;
    }  
}
 * no-op {@link #close()}. {@code close()} must be idempotent; in particular it must
/*  
 * The OpenSearch Contributors require contributions made to  
 * close it if the fragment aborts before ownership is transferred to the  
 * <p>Each backend defines its own concrete implementation (e.g.,
    default void close() throws IOException {
