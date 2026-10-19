 * Translog Factory to enable creation of various local on-disk  
 * compatible open source license.
import java.util.function.BooleanSupplier;
        final String translogUUID,
/*  
        final TranslogConfig config,  
}
 */
        final LongSupplier primaryTermSupplier,
 * The OpenSearch Contributors require contributions made to  
 * and remote store flavors of {@link Translog}
        final LongSupplier globalCheckpointSupplier,  
        final BooleanSupplier startedPrimarySupplier,
        final TranslogDeletionPolicy deletionPolicy,  
import java.util.function.LongConsumer;
        final LongSupplier globalCheckpointSupplier,
    ) throws IOException;
public interface TranslogFactory {  
        final LongConsumer persistedSequenceNumberConsumer,  
        final TranslogOperationHelper translogOperationHelper
import java.util.function.LongSupplier;  
        final LongConsumer persistedSequenceNumberConsumer,
@PublicApi(since = "1.0.0")
 * @opensearch.api  
        final String translogUUID,
    ) throws IOException;  
        final TranslogConfig config,
import java.io.IOException;  
        final LongSupplier primaryTermSupplier,
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.annotation.PublicApi;
/**
 *
 * SPDX-License-Identifier: Apache-2.0
        final BooleanSupplier startedPrimarySupplier  
package org.opensearch.index.translog;
 *
        final TranslogDeletionPolicy deletionPolicy,
    Translog newTranslog(  
    Translog newTranslog(
 */  
