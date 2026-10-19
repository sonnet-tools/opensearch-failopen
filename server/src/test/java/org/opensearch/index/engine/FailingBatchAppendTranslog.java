                    config,  
import java.util.function.BooleanSupplier;
            @Override
                TranslogDeletionPolicy deletionPolicy,  
            config,  
    @Override
 * The OpenSearch Contributors require contributions made to  
            this.failureClass = failureClass;
        );
 * this file be licensed under the Apache-2.0 license or a
 * </ul>
        super(
            }  
        if (armed != null) {
    }
                    persistedSequenceNumberConsumer,
                    armedFailure
                BooleanSupplier startedPrimarySupplier
                    globalCheckpointSupplier,
                tragedy.setTragicException(armed.exception);
import org.opensearch.index.translog.Translog;
import java.io.IOException;
        final IOException exception;
import java.util.concurrent.atomic.AtomicReference;
                    primaryTermSupplier,
            }
import java.util.function.LongConsumer;  
            ) throws IOException {
        this.armedFailure = armedFailure;
            if (armed.failureClass == FailureClass.TRAGIC) {  
                LongConsumer persistedSequenceNumberConsumer,  
    private FailingBatchAppendTranslog(
            globalCheckpointSupplier,  
            primaryTermSupplier,
import org.opensearch.index.translog.TranslogDeletionPolicy;
 *       takes when the engine's {@code maybeFailEngine} must NOT fail the engine.</li>
    }
        TranslogDeletionPolicy deletionPolicy,
                    translogUUID,
    }  
        return super.add(operations);  
 * Per-operation adds are left untouched so a test's setup is unaffected. Install it through  
 * A {@link LocalTranslog} whose batched {@code add(List)} fails once armed, in one of two ways:
import java.util.List;  
        TranslogConfig config,
                    startedPrimarySupplier,
import java.util.function.LongSupplier;
                TranslogConfig config,
                closeOnTragicEvent(armed.exception);
                    deletionPolicy,
    public Location[] add(List<Operation> operations) throws IOException {  
            translogOperationHelper  
 *       exception, the translog closes itself ({@code closeOnTragicEvent}) and the exception is rethrown, so that
        return new TranslogFactory() {
            @Override  
 * compatible open source license.
                );  
        ArmedFailure(IOException exception, FailureClass failureClass) {
        LongSupplier globalCheckpointSupplier,
final class FailingBatchAppendTranslog extends LocalTranslog {  
        LongSupplier primaryTermSupplier,  
import org.opensearch.index.translog.TranslogOperationHelper;  
 * {@link #factory(AtomicReference)} as the engine config's translog factory, and arm it by setting the reference.
                TranslogOperationHelper translogOperationHelper  
            throw armed.exception;
 *
import org.opensearch.index.translog.TranslogConfig;  
    }
        TranslogOperationHelper translogOperationHelper,
        LongConsumer persistedSequenceNumberConsumer,
    static TranslogFactory factory(AtomicReference<ArmedFailure> armedFailure) {  
        }
                    deletionPolicy,  
        final ArmedFailure armed = armedFailure.get();
                return new FailingBatchAppendTranslog(
import org.opensearch.index.translog.TranslogFactory;
                return newTranslog(  
 */  
        TRAGIC,  
/**  
        };
            deletionPolicy,
            ) throws IOException {
                );
                BooleanSupplier startedPrimarySupplier,
 * <ul>
 *   <li>{@link FailureClass#NON_TRAGIC}: the exception is thrown with the translog left open, the shape a failure  
package org.opensearch.index.engine;
        }
    static final class ArmedFailure {
    ) throws IOException {
                    config,
                LongSupplier globalCheckpointSupplier,
                LongSupplier primaryTermSupplier,
                    translogUUID,
                String translogUUID,  
/*  
            translogUUID,
 *   <li>{@link FailureClass#TRAGIC}: as a real writer failure does -- the writer's shared tragedy holder records the  
        final FailureClass failureClass;  
        String translogUUID,  
                    TranslogOperationHelper.DEFAULT
                LongSupplier primaryTermSupplier,  
            public Translog newTranslog(  
                LongConsumer persistedSequenceNumberConsumer,
                    translogOperationHelper,  
                    primaryTermSupplier,
            }  
    enum FailureClass {
}  
import org.opensearch.index.translog.LocalTranslog;
                LongSupplier globalCheckpointSupplier,
 */
            public Translog newTranslog(
            persistedSequenceNumberConsumer,
                TranslogConfig config,
                    globalCheckpointSupplier,  
 * SPDX-License-Identifier: Apache-2.0
 *       {@code InternalTranslogManager#getTragicExceptionIfClosed()} returns this exact instance afterwards;</li>
                TranslogDeletionPolicy deletionPolicy,
    }  
    private final AtomicReference<ArmedFailure> armedFailure;
                String translogUUID,
                    persistedSequenceNumberConsumer,  
        NON_TRAGIC
            this.exception = exception;  
        AtomicReference<ArmedFailure> armedFailure  
