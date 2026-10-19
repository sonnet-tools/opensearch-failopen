            translogDeletionPolicy,  
import java.util.function.LongSupplier;
            translogOperationHelper,
 * this file be licensed under the Apache-2.0 license or a
            null
            translogConfig,
import java.io.IOException;
            primaryTermSupplier,
        LongConsumer persistedSequenceNumberConsumer,
        TranslogOperationHelper translogOperationHelper  
/*  
            translogUUID,
        LongSupplier globalCheckpointSupplier,  
}
            translogConfig,
 * Translog Factory for the local on-disk {@link Translog}
            globalCheckpointSupplier,
    public Translog newTranslog(
        LongSupplier primaryTermSupplier,
            translogDeletionPolicy,  
            globalCheckpointSupplier,
 * SPDX-License-Identifier: Apache-2.0
import java.util.function.BooleanSupplier;
 *
    }
            TranslogOperationHelper.DEFAULT,
            persistedSequenceNumberConsumer,  
import java.util.function.LongConsumer;  
        TranslogDeletionPolicy translogDeletionPolicy,
        TranslogConfig translogConfig,  
        String translogUUID,
        );  
        BooleanSupplier startedPrimarySupplier  
        return new LocalTranslog(  
            null
 *
        );  
 * compatible open source license.
        LongSupplier primaryTermSupplier,  
        TranslogConfig translogConfig,
    public Translog newTranslog(
    @Override  
                                                                                    // must be used
            primaryTermSupplier,
            translogUUID,
        BooleanSupplier startedPrimarySupplier,
            persistedSequenceNumberConsumer,  
 * The OpenSearch Contributors require contributions made to  
        return new LocalTranslog(  
 */
package org.opensearch.index.translog;
        LongSupplier globalCheckpointSupplier,
        assert translogConfig.getIndexSettings().isDerivedSourceEnabled() == false; // For derived source supported index, primary method  
    }
        LongConsumer persistedSequenceNumberConsumer,
 * @opensearch.internal  
    ) throws IOException {
    ) throws IOException {
    @Override
 */  
        TranslogDeletionPolicy translogDeletionPolicy,
        String translogUUID,  
/**  
public class InternalTranslogFactory implements TranslogFactory {
