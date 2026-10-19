 * @param tableName   logical table name to register in the session context
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
 * {@link NativeBridge#createSessionContext(long, long, String, long, boolean, boolean, long, byte[])}.  
package org.opensearch.be.datafusion.nativelib;
import org.opensearch.common.annotation.ExperimentalApi;
 * Immutable configuration record for creating a native SessionContext via
import org.opensearch.be.datafusion.WireConfigSnapshot;
 */  
 * @param readerPtr   pointer to the native DataFusion reader (shard view)
@ExperimentalApi
 * The OpenSearch Contributors require contributions made to  
/*  
 *
 * @param runtimePtr  pointer to the native DataFusion runtime  
public record SessionContextConfig(long readerPtr, long runtimePtr, String tableName, long contextId, WireConfigSnapshot queryConfig) {
 * @param contextId   query/task context identifier (0 if none)
}  
/**
 */  
 *
 *
 * this file be licensed under the Apache-2.0 license or a
 * @param queryConfig query config snapshot to pass to native  
 * @opensearch.experimental
