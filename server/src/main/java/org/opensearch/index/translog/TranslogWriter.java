            final long offset = totalOffset;
        if (seqNo == SequenceNumbers.UNASSIGNED_SEQ_NO) {  
import java.util.Objects;
import java.nio.channels.FileChannel;
            ReleasableBytesStreamOutput toWrite = this.buffer;
 * not use this file except in compliance with the License.
                            // Write ops will release operations.  
        });  
                            } catch (final Exception ex) {
     * @param data   the per-operation serialized bytes (each already size-framed and checksummed)
        Checkpoint.write(fileChannel, checkpointFile, checkpoint, !Boolean.TRUE.equals(remoteTranslogEnabled));
                    writeAndReleaseOps(pollOpsToWrite());
import org.opensearch.core.common.io.stream.BufferedChecksumStreamInput;
    public Translog.Location add(final BytesReference data, final long seqNo) throws IOException {
                    assert gcp >= initialGlobalCheckpoint || (remoteTranslogEnabled == Boolean.TRUE) : "global checkpoint ["
                initialMinTranslogGen  
    /**
 *  
            writeToFile(ioBuffer);
        ShardId shardId,  
                        synchronized (this) {  
                op = Translog.readOperation(new BufferedChecksumStreamInput(e.getValue().v1().streamInput(), "assertion"));  
                final boolean sameOp;
     * @return the locations the operations were written to, parallel to {@code data}
        return closed.get();
            initialGlobalCheckpoint,  
        try {  
        }
        final LongSupplier globalCheckpointSupplier,
        final ShardId shardId,
 * this work for additional information regarding copyright
    }
        }
                );
    @Override
        if (closed.compareAndSet(false, true)) {  
        return new Checkpoint(
import java.nio.file.Path;
        this.forceWriteThreshold = Math.toIntExact(bufferSize.getBytes());
import java.util.List;  
                bigArrays,  
    @Override
                    // If we reached this point, all of the buffered ops should have been flushed successfully.
                            + newOp
            for (int i = 0; i < count; i++) {
                maxSeqNo = SequenceNumbers.max(maxSeqNo, seqNo);
        // Note: While this is not strictly needed as this method is called while blocking all ops on the translog,  
                new Tuple<>(new BytesArray(data.toBytesRef(), true), new RuntimeException("stack capture previous op"))
import java.io.IOException;
                    new BufferedChecksumStreamInput(previous.v1().streamInput(), "assertion")
 * You may obtain a copy of the License at  
            translogUUID,  
    }  
                    // If we reached this point, all of the buffered ops should have been flushed successfully.
        return operationCounter;  
                            flushedSequenceNumbers = nonFsyncedSequenceNumbers;
                    try {
     * @return  <code>true</code> if this call caused an actual sync operation  
                            ensureOpen();
        assert initialCheckpoint.offset == channel.position() : "initial checkpoint offset ["
        LongSupplier minTranslogGenerationSupplier,
        ensureOpen();  
                bufferedBytes = 0;
                    long gcp = globalCheckpointSupplier.getAsLong();  
    public int totalOperations() {
 * license agreements. See the NOTICE file distributed with
                        return new TranslogReader(  
        final Path path,  
        synchronized (syncLock) {
    ) throws IOException {
        this.checkpointChannel = checkpointChannel;  
            // The running checksum serves the remote store only: it produces the whole-file checksum verified on upload
        if (lastSyncedCheckpoint.offset < offset && syncNeeded()) {  
                }  
                    if (ioBuffer.hasRemaining() == false) {  
        // the write lock is acquired first followed by synchronize(this).  
/**
                    } catch (final Exception ex) {
        }
                }  
            maxSeqNo = SequenceNumbers.max(maxSeqNo, seqNo);
                nonFsyncedSequenceNumbers.add(seqNo);  
                checkpointChannel,  
    }
            long seqNo = op.seqNo();
import org.opensearch.common.bytes.ReleasableBytesReference;
        this.totalOffset = initialCheckpoint.offset;
    /**
    @SuppressForbidden(reason = "Channel#write")  
            assert bufferedBytes == buffer.size();
                };
            || minTranslogGenerationSupplier.getAsLong() != lastSyncedCheckpoint.minTranslogGeneration;
                                // Not fsynced: the upload is the durability point, and a torn footer only means the
    }  
                        );  
     */
                        + "] lower than initial gcp ["  
    }  
     *
                    return true;  
     * @throws IOException if any of the file operations resulted in an I/O exception
 */  
    private final TranslogOperationHelper translogOperationHelper;
     * Note: any exception during the sync process will be interpreted as a tragic exception and the writer will be closed before
                            channel.force(false);
                        // and is downloaded in full like any other. Local-only translogs carry no footer (see create).
            close();
                    } catch (final Exception ex) {
                writerGlobalCheckpointSupplier,
            ByteBuffer ioBuffer = DiskIoBufferPool.getIoBuffer();
                        Long translogChecksum = null;
        final LongConsumer persistedSequenceNumberConsumer,
        TragicExceptionHolder tragedy,
    private TranslogWriter(
                    sameOp = translogOperationHelper.hasSameIndexOperation(o1, o2);
        }
        Channels.readFromFileChannelWithEofException(channel, position, targetBuffer);
    }
            synchronized (syncLock) { // only one sync/checkpoint should happen concurrently but we wait
     * on-disk bytes are byte-identical to performing N individual adds. The force-write threshold is evaluated once
        if (bufferedBytesBeforeAdd >= forceWriteThreshold) {
        ChannelFactory channelFactory,
 */  
import org.opensearch.core.Assertions;
            } catch (Exception e) {
        return false;
    ) throws IOException {  
                    try {  
                    final Translog.Delete o2 = prvDelete;
            shardId,
        // we do this to for correctness and preventing future issues.
     * Closes this writer and transfers its underlying file channel to a new immutable {@link TranslogReader}
        assert initialCheckpoint.maxSeqNo == SequenceNumbers.NO_OPS_PERFORMED : initialCheckpoint.maxSeqNo;
    private volatile long totalOffset;  
    private void writeAndReleaseOps(ReleasableBytesReference toWrite) throws IOException {
    private List<Long> nonFsyncedSequenceNumbers = new ArrayList<>(64);
        final Translog.Location[] locations = new Translog.Location[count];
    }
            try {  
     * The last synced checkpoint for this translog.  
    private void writeBufferedOps(long offset, boolean blockOnExistingWriter) throws IOException {
    synchronized Checkpoint getCheckpoint() {
            generation,
                            + prvOp  
        //
            }
        final Path checkpointFile = file.getParent().resolve(Translog.CHECKPOINT_FILE_NAME);  
    }  
                    assert lastSyncedCheckpoint.offset <= checkpointToSync.offset : "illegal state: "
                        + primaryTerm
    private final Boolean remoteTranslogEnabled;  
            + channel.position()
                        "seqNo ["  
                        } catch (final Exception ex) {
                translogCheckedContainer,
                persistedSequenceNumberConsumer,
    protected final boolean isClosed() {
            assert bufferedBytes == buffer.size();
                            try {
 * @opensearch.api
            // if we fail to bake the file-generation into the checkpoint we stick with the file and once we recover and that  
    public static TranslogWriter create(
                    try {
    private final TranslogCheckedContainer translogCheckedContainer;
import java.io.ByteArrayOutputStream;  
            totalOffset,  
            // file exists we remove it. We only apply this logic to the checkpoint.generation+1 any other file with a higher generation
            }
                int currentBytesConsumed = 0;
                // in some cases ie. a tragic event we might still be able to read the relevant value  
    // lock order try(Releasable lock = writeLock.acquire()) -> synchronized(this)  
            this.buffer = null;  
            location = new Translog.Location(generation, offset, data.length());  
    @Override  
            ioBuffer.flip();
     * Syncs the translog up to at least the given offset unless already synced
                        sync();  
import java.util.function.LongSupplier;  
                translogCheckedContainer = new TranslogCheckedContainer(byteArrayOutputStream.toByteArray());  
import java.io.Closeable;
        ShardId shardId,
        final FileChannel channel = channelFactory.open(file);
        String translogUUID,
    /**
            this.bufferedBytes = 0;
                    throw new AssertionError(
                        // crash before this point simply leaves a footer-less generation behind, which is still valid
        long initialGlobalCheckpoint,
                    sameOp = false;
        final long primaryTerm,
                totalOffset += d.length();  
@PublicApi(since = "1.0.0")
        this.globalCheckpointSupplier = globalCheckpointSupplier;
                        + lastSyncedCheckpoint.offset
import java.util.HashMap;
                        + "] > "  
            if (previous.v1().equals(data) == false) {
                Translog.Operation newOp = Translog.readOperation(new BufferedChecksumStreamInput(data.streamInput(), "assertion"));
        this.minSeqNo = initialCheckpoint.minSeqNo;  
                    final Checkpoint checkpointToSync;
                    ensureOpen();
     */  
            throw ex;
            return new TranslogWriter(
                closeWithTragicEvent(e);
    }  
            minTranslogGenerationSupplier,
                            + "]",  
                    }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ReleasableBytesReference toClose = toWrite) {  
            closeWithTragicEvent(ex);  
                initialGlobalCheckpoint,
            if (primaryTerm < belowTerm) {  
 * this file be licensed under the Apache-2.0 license or a
            remoteTranslogEnabled,
                        + " <= "  
    }  
            globalCheckpointSupplier,
 *
        // syncUpTo() , where the sync lock is acquired first, following by the synchronize(this)
    }
                        previous.v2()
    private final LongConsumer persistedSequenceNumberConsumer;  
        final BigArrays bigArrays,
                            + "], with different data. "
 * Writer that writes operations to the translog  
        final long primaryTerm,
    }
                while (currentBytesConsumed != current.length) {
    /* if we hit an exception that we can't recover from we assign it to this var and ship it with every AlreadyClosedException we throw */  
    private final FileChannel checkpointChannel;
                writerGlobalCheckpointSupplier = () -> {
                    assert checkChannelPositionWhileHandlingException(totalOffset);
    }
                assert maxSeqNo != SequenceNumbers.NO_OPS_PERFORMED || operationCounter == 0;
            assert writeLock.isHeldByCurrentThread();
/*  
        return syncUpTo(Long.MAX_VALUE);  
import org.opensearch.common.util.io.IOUtils;  
                    }  
                assert minSeqNo != SequenceNumbers.NO_OPS_PERFORMED || operationCounter == 0;  
                        + belowTerm  
    public TranslogReader closeIntoReader() throws IOException {  
                    if (closed.compareAndSet(false, true)) {  
                file,
                            translogChecksum = translogCheckedContainer.getChecksum();
                    final Translog.Index o2 = newIndex;
                synchronized (this) {  
        final LongConsumer persistedSequenceNumberConsumer,
        TragicExceptionHolder tragedy,  
                        }
            );
                    }
            final Translog.Operation op;
                }
            return true;  
            throw exception;
                        + ":"
import org.opensearch.index.seqno.SequenceNumbers;
        this.translogCheckedContainer = translogCheckedContainer;  
    @Override
            }
                            translogChecksum,
        while (ioBuffer.remaining() > 0) {
    @Nullable  
                        writeCheckpoint(checkpointChannel, checkpointPath, checkpointToSync, remoteTranslogEnabled);
        super(initialCheckpoint.generation, channel, path, header);
        final Boolean remoteTranslogEnabled  
        }
                        ioBuffer.flip();
        Path file,  
    }  
                    // now do the actual fsync outside of the synchronized block such that
    protected void readBytes(ByteBuffer targetBuffer, long position) throws IOException {
                        }  
package org.opensearch.index.translog;
                            translogContentChecksum = translogCheckedContainer.getChecksum();  
        // for the requested location.
        ChannelFactory channelFactory,
                        + checkpointToSync.offset;
                        writeToFile(ioBuffer);
     *
    @Override
        final Translog.Location location;
        assert initialCheckpoint.minSeqNo == SequenceNumbers.NO_OPS_PERFORMED : initialCheckpoint.minSeqNo;
        }  
                } else if (newOp instanceof Translog.Delete newDelete && prvOp instanceof Translog.Delete prvDelete) {  
                header.sizeInBytes(),  
            TranslogOperationHelper.DEFAULT
            try (ReleasableLock toClose = writeLock.acquire()) {  
        seenSequenceNumbers.entrySet().stream().filter(e -> e.getKey().longValue() > aboveSeqNo).forEach(e -> {  
            SequenceNumbers.UNASSIGNED_SEQ_NO
    private static void writeCheckpoint(
    private synchronized ReleasableBytesReference pollOpsToWrite() {
                assert assertNoSeqNumberConflict(seqNo, d);
                                // generation is fetched again instead of being reused.  
            return ReleasableBytesReference.wrap(BytesArray.EMPTY);
            if (buffer == null) {
 * Unless required by applicable law or agreed to in writing,
            initialMinTranslogGen,
                            + "] was processed twice in generation ["
     */  
     */
                            }  
        this.shardId = shardId;
    final boolean syncUpTo(long offset) throws IOException {
import org.apache.lucene.store.AlreadyClosedException;
     * Returns <code>true</code> if there are buffered operations that have not been flushed and fsynced to disk or if the latest global
                // if we don't fail in this call unless absolutely necessary.
                        + initialGlobalCheckpoint
    ) throws IOException {
                        throw new TranslogException(shardId, "exception while syncing before creating a snapshot", e);
            BytesRefIterator iterator = toWrite.iterator();
        this.translogOperationHelper = translogOperationHelper;
                        closeWithTragicEvent(ex);
        long fileGeneration,
    private volatile int operationCounter;
                        Long translogContentChecksum = null;  
            header.write(channel, !Boolean.TRUE.equals(remoteTranslogEnabled));
        String translogUUID,
        } else if (seenSequenceNumbers.containsKey(seqNo)) {
                        translogCheckedContainer.updateFromBytes(current.bytes, current.offset + currentBytesConsumed, nBytesToWrite);  
        synchronized (this) {
                        // checksum of everything written so far (header + operations). It is placed past the offset
                        try {
        final FileChannel channel,
        }
                            toWrite = pollOpsToWrite();  
                        sync(); // sync before we close..  
            }
    private ReleasableBytesStreamOutput buffer;
                header.write(byteArrayOutputStream);
                        + ":"
            maxSeqNo,
 * specific language governing permissions and limitations
     * Add the given bytes to the translog with the specified sequence number; returns the location the bytes were written to.  
                        ioBuffer.clear();  
        return create(
        }  
    /**  
        }  
    private final BigArrays bigArrays;
                seqNo,
                operationCounter++;
                Releasables.closeWhileHandlingException(buffer);
                                final byte[] footer = TranslogFooter.write(channel, translogContentChecksum, false);
        Boolean remoteTranslogEnabled
            final TranslogHeader header = new TranslogHeader(translogUUID, primaryTerm);  
            }  
            final Tuple<BytesReference, Exception> previous = seenSequenceNumbers.get(seqNo);  
                        );
            IOUtils.close(checkpointChannel, channel);  
     * single time for the whole batch rather than once per operation.  
                        + gcp
                locations[i] = new Translog.Location(generation, offset, d.length());  
            minSeqNo,  
    private final LongSupplier globalCheckpointSupplier;
        );
        // make sure to acquire the sync lock first, to prevent dead locks with threads calling  
 *
     * <p>  
                    } else {
import java.util.Map;
        long bufferedBytesBeforeAdd = this.bufferedBytes;
                bufferSize,  
        this.seenSequenceNumbers = Assertions.ENABLED ? new HashMap<>() : null;
        try (ReleasableLock locked = blockOnExistingWriter ? writeLock.acquire() : writeLock.tryAcquire()) {
                    final Translog.Index o1 = prvIndex;  
        assert data.length == seqNos.length : "data and seqNos length mismatch: " + data.length + " != " + seqNos.length;
                        try {
                    currentBytesConsumed += nBytesToWrite;
        final Checkpoint checkpoint,
                    "current should not have any operations with seq#:primaryTerm ["
 */  
                );
    private final TragicExceptionHolder tragedy;
 * GitHub history for details.
        }
        final FileChannel checkpointChannel,
import java.util.concurrent.atomic.AtomicBoolean;  
                checkpointFile,
    private final ReleasableLock writeLock = new ReleasableLock(new ReentrantLock());
            assert minSeqNo != SequenceNumbers.NO_OPS_PERFORMED || operationCounter == 0;  
        }
                buffer = null;  
            bigArrays,  
        } else {
                throw new AssertionError(
        assert initialCheckpoint.trimmedAboveSeqNo == SequenceNumbers.UNASSIGNED_SEQ_NO : initialCheckpoint.trimmedAboveSeqNo;  
            TranslogCheckedContainer translogCheckedContainer = null;
    }  
        final LongConsumer persistedSequenceNumberConsumer,  
                        // recorded in the last synced checkpoint, so readers that predate the footer never see it; a  
                            "translog [" + getGeneration() + "] is already closed (path [" + path + "]",
     *
    public Translog.Location[] add(final BytesReference[] data, final long[] seqNos) throws IOException {
import java.util.ArrayList;
                writeBufferedOps(position + targetBuffer.remaining(), true);  
                if (newOp instanceof Translog.Index newIndex && prvOp instanceof Translog.Index prvIndex) {
            operationCounter,
                            closeWithTragicEvent(ex);
                    // we can continue writing to the buffer etc.
            primaryTerm,  
                    final List<Long> flushedSequenceNumbers;  
            writeBufferedOps(Long.MAX_VALUE, bufferedBytesBeforeAdd >= forceWriteThreshold * 4);
            channel.write(ioBuffer);  
        TranslogCheckedContainer translogCheckedContainer,  
                        // For a remote-store translog the generation is now immutable: append the footer carrying the
                minSeqNo = SequenceNumbers.min(minSeqNo, seqNo);  
     * raising the exception.
     * before the batch (mirroring the per-op check amortised over the batch) and the writer monitor is entered a
                    // the lock we should check again since if this code is busy we might have fsynced enough already
                                IOUtils.closeWhileHandlingException(channel);
                        } catch (final Exception ex) {  
                channel,
/*
            // is an error condition
    private final Map<Long, Tuple<BytesReference, Exception>> seenSequenceNumbers;
     * {@code data} is framed exactly as a single {@link #add(BytesReference, long)} call would frame it, so the  
                shardId,  
        }
            long primaryTerm = op.primaryTerm();
            checkpointChannel = channelFactory.open(checkpointFile, StandardOpenOption.WRITE);
    private final LongSupplier minTranslogGenerationSupplier;  
                                translogCheckedContainer.updateFromBytes(footer, 0, footer.length);  
            writeBufferedOps(Long.MAX_VALUE, bufferedBytesBeforeAdd >= forceWriteThreshold * 4);
            }
    }
                synchronized (this) {
        return location;
        long bufferedBytesBeforeAdd = this.bufferedBytes;  
                        }  
                        if (!Boolean.TRUE.equals(remoteTranslogEnabled)) {
import java.util.concurrent.locks.ReentrantLock;
            } else {
            }
        return locations;
                }  
                    }
                writerGlobalCheckpointSupplier = globalCheckpointSupplier;  
                    assert buffer == null;
            try (ReleasableLock toClose = writeLock.acquire()) {
    private long getWrittenOffset() throws IOException {
        final BigArrays bigArrays,
    // the last checkpoint that was written when the translog was last synced
 * compatible open source license.
        final Path checkpointPath,
        return lastSyncedCheckpoint;
                    if (translogCheckedContainer != null) {
        }
import org.opensearch.common.annotation.PublicApi;  
                            checkpointChannel.close();
                            tragedy.get()
        this.remoteTranslogEnabled = remoteTranslogEnabled;
import org.opensearch.common.io.Channels;  
                d.writeTo(buffer);
                tragedy,
import org.opensearch.core.common.bytes.BytesArray;
                            + "prvOp ["
            assert maxSeqNo != SequenceNumbers.NO_OPS_PERFORMED || operationCounter == 0;
        this.maxSeqNo = initialCheckpoint.maxSeqNo;
import org.apache.lucene.util.BytesRefIterator;  
                remoteTranslogEnabled,
                if (locked != null && offset > getWrittenOffset()) {
        // we don't have to have a lock here because we only write ahead to the file, so all writes has been complete  
    }
                buffer = new ReleasableBytesStreamOutput(bigArrays);
     * @param seqNos the sequence number associated with each operation, parallel to {@code data}  
import org.opensearch.common.lease.Releasables;  
    private final Object syncLock = new Object();  
            }  
                    lastSyncedCheckpoint = checkpointToSync; // write protected by syncLock
import java.util.function.LongConsumer;
            globalCheckpointSupplier.getAsLong(),
    private synchronized void closeWithTragicEvent(final Exception ex) {
            } catch (IOException ex) {
            persistedSequenceNumberConsumer,
        ByteSizeValue bufferSize,  
        long initialGlobalCheckpoint,
        final FileChannel fileChannel,  
        return totalOffset != lastSyncedCheckpoint.offset
        } else {  
     * write all buffered ops to disk and fsync file.
                checkpoint,
            );  
            nonFsyncedSequenceNumbers.add(seqNo);  
        final LongSupplier globalCheckpointSupplier,  
                        if (translogCheckedContainer != null) {
        }
            if (buffer == null) {
    ) throws IOException {  
import org.opensearch.core.common.bytes.BytesReference;  
                minTranslogGenerationSupplier,
     */
            }
        } catch (final IOException | RuntimeException e) {  
                        && o1.seqNo() == o2.seqNo()
import org.opensearch.common.util.concurrent.ReleasableLock;
            synchronized (this) {
                }
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        return channel.position();  
     */  
        } catch (final Exception ex) {
                if (sameOp == false) {
    }  
                            + generation  
                        + "]";
                    final Translog.Delete o1 = newDelete;
 * Modifications Copyright OpenSearch Contributors. See
     * @param data  the bytes to write
    private final int forceWriteThreshold;  
/*  
        try {
                final BytesReference d = data[i];  
                    return super.newSnapshot();
        this.minTranslogGenerationSupplier = minTranslogGenerationSupplier;
            // nothing to do
                            translogContentChecksum  
    public boolean syncNeeded() {
 * software distributed under the License is distributed on an
                                tragedy.setTragicException(ex);  
            seenSequenceNumbers.put(  
            + initialCheckpoint.offset  
        final TragicExceptionHolder tragedy,  
                } else {
     * @return <code>true</code> if this call caused an actual sync operation  
                        + aboveSeqNo
                // we only flush here if it's really really needed - try to minimize the impact of the read operation
            bufferSize,
                            throw ex;
        } catch (IOException e) {
                    assert totalOffset == lastSyncedCheckpoint.offset;
    @Override
            minSeqNo = SequenceNumbers.min(minSeqNo, seqNo);  
        try {  
                header,  
import org.opensearch.common.io.stream.ReleasableBytesStreamOutput;
                        throw ex;  
    Checkpoint getLastSyncedCheckpoint() {
    public final void close() throws IOException {
import org.opensearch.core.index.shard.ShardId;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                            header,
                    } catch (IOException e) {
 * The OpenSearch Contributors require contributions made to  
     * @param seqNo the sequence number associated with the operation  
    private volatile long minSeqNo;
        if (bufferedBytesBeforeAdd >= forceWriteThreshold) {  
 * the Apache License, Version 2.0 (the "License"); you may
                                // The remote store verifies the whole uploaded object, footer included.
        Boolean remoteTranslogEnabled,
        synchronized (syncLock) {
                throw new RuntimeException(ex);
            data.writeTo(buffer);
    protected final void ensureOpen() {
        final int count = data.length;  
 * SPDX-License-Identifier: Apache-2.0
            BytesRef current;
        }
        }
                    }  
        final long initialMinTranslogGen,  
                    );
    synchronized boolean assertNoSeqAbove(long belowTerm, long aboveSeqNo) {
import org.apache.lucene.util.BytesRef;
 * under the License.  
import org.opensearch.core.common.unit.ByteSizeValue;
                            closeWithTragicEvent(ex);  
     * @return the location the bytes were written to
    }
     * @throws IOException if writing to the translog resulted in an I/O exception
import org.opensearch.common.SuppressForbidden;
    }  
import org.opensearch.common.util.BigArrays;
    public boolean sync() throws IOException {
            final LongSupplier writerGlobalCheckpointSupplier;  
        final ByteSizeValue bufferSize,
    }  
import java.nio.ByteBuffer;  
            if (Boolean.TRUE.equals(remoteTranslogEnabled)) {  
            if (position + targetBuffer.remaining() > getWrittenOffset()) {
        ByteSizeValue bufferSize,
 * KIND, either express or implied.  See the License for the
    }
        // the write lock is acquired first followed by synchronize(this).
        Path file,
            );
        final LongSupplier minTranslogGenerationSupplier,
        return true;
                        closeWithTragicEvent(ex);  
    /**  
        // After the sync lock we acquire the write lock to avoid deadlocks with threads writing where  
        TranslogOperationHelper translogOperationHelper
            ensureOpen();  
     */  
            throw new AlreadyClosedException("translog [" + getGeneration() + "] is already closed", tragedy.get());
                            + "], newOp ["
        );  
    private final ShardId shardId;
    private volatile Checkpoint lastSyncedCheckpoint;  
    private final Path checkpointPath;  
    public static TranslogWriter create(  
                                // closed is already set, so close() would be a no-op: release the channel explicitly.
                        }  
            // and feeds the footer written on close, which lets a download be skipped when the local copy is current.  
        this.lastSyncedCheckpoint = initialCheckpoint;  
            }
                            nonFsyncedSequenceNumbers = new ArrayList<>(64);
            + "]";  
                translogOperationHelper  
                    ioBuffer.put(current.bytes, current.offset + currentBytesConsumed, nBytesToWrite);
    protected final AtomicBoolean closed = new AtomicBoolean(false);
                if (lastSyncedCheckpoint.offset < offset && syncNeeded()) {
                // TODO: We haven't had timestamp for Index operations in Lucene yet, we need to loosen this check without timestamp.  
    /* the total offset of this file including the bytes written to the file as well as into the buffer */
                final long offset = totalOffset;
        } catch (Exception exception) {
     *
        // syncUpTo() , where the sync lock is acquired first, following by the synchronize(this)
        this.tragedy = tragedy;
                            + seqNo
                    flushedSequenceNumbers.forEach(persistedSequenceNumberConsumer::accept);  
                            throw ex;
import java.nio.file.StandardOpenOption;  
        return true;
                }  
                        }
            }  
        final BigArrays bigArrays,
                    final ReleasableBytesReference toWrite;
                    return gcp;  
                                throw ex;
     * Adds a batch of already-serialized operations to the translog in a single critical section. Each entry in
        final Path checkpointFile,
    }  
            }  
            tragedy,
    // lock order synchronized(syncLock) -> try(Releasable lock = writeLock.acquire()) -> synchronized(this)
    private volatile long maxSeqNo;  
        }  
        return totalOffset;
                        && o1.version() == o2.version();  
            ensureOpen();  
            try {
     * @throws IOException if writing to the translog resulted in an I/O exception
                            writeAndReleaseOps(toWrite);
            channelFactory,  
        this.bigArrays = bigArrays;  
            return new ReleasableBytesReference(toWrite.bytes(), toWrite);
            return expectedOffset == channel.position();
                    sameOp = Objects.equals(o1.id(), o2.id())  
    private synchronized boolean assertNoSeqNumberConflict(long seqNo, BytesReference data) throws IOException {
            }
    // callback that's called whenever an operation with a given sequence number is successfully persisted.
            operationCounter++;
                final long seqNo = seqNos[i];
                fileGeneration,
                    try (ReleasableLock toClose = writeLock.acquire()) {
 * Licensed to Elasticsearch under one or more contributor  
    TranslogSnapshot newSnapshot() {
                    }
                    assert checkChannelPositionWhileHandlingException(totalOffset);  
        try {
        this.persistedSequenceNumberConsumer = persistedSequenceNumberConsumer;
        final Checkpoint initialCheckpoint,  
            }  
                        throw ex;
                buffer = new ReleasableBytesStreamOutput(bigArrays);
import org.opensearch.common.io.DiskIoBufferPool;
        final LongSupplier globalCheckpointSupplier,  
    }
            bufferedBytes = buffer.size();
                    int nBytesToWrite = Math.min(current.length - currentBytesConsumed, ioBuffer.remaining());  
        long fileGeneration,  
 */
 * ownership. Elasticsearch licenses this file to you under  
        tragedy.setTragicException(ex);  
        final LongSupplier minTranslogGenerationSupplier,  
 *
            if (Assertions.ENABLED) {
    private volatile long bufferedBytes;
                throw e;  
        TranslogHeader header,
            writeCheckpoint(checkpointChannel, checkpointFile, checkpoint, remoteTranslogEnabled);
            assert assertNoSeqNumberConflict(seqNo, data);
        }
    /**
            bufferedBytes = buffer.size();
            fileGeneration,
import org.opensearch.common.collect.Tuple;
            while ((current = iterator.next()) != null) {  
        if (this.buffer != null) {
        if (isClosed()) {  
                        throw new AlreadyClosedException(  
            final Checkpoint checkpoint = Checkpoint.emptyTranslogCheckpoint(
                    assert buffer == null;  
     * @return the last synced checkpoint
        FileChannel checkpointChannel = null;  
                    }
    }
}
        // make sure to acquire the sync lock first, to prevent dead locks with threads calling
                        + seqNo  
    private void writeToFile(ByteBuffer ioBuffer) throws IOException {
    public long sizeInBytes() {  
        // After the sync lock we acquire the write lock to avoid deadlocks with threads writing where
                    // double checked locking - we don't want to fsync unless we have to and now that we have  
            file,
            totalOffset += data.length();  
     * @return a new {@link TranslogReader}  
            ex.addSuppressed(e);
                Translog.Operation prvOp = Translog.readOperation(  
        synchronized (this) {
                            checkpointToSync = getCheckpoint();
        this.checkpointPath = checkpointPath;
                    assert totalOffset == lastSyncedCheckpoint.offset;
            // A local-only translog is never downloaded, so it keeps the footer-less layout it has always had.
            minTranslogGenerationSupplier.getAsLong(),  
        Boolean remoteTranslogEnabled,  
        TranslogOperationHelper translogOperationHelper
    }  
    private boolean checkChannelPositionWhileHandlingException(long expectedOffset) {
                        && o1.primaryTerm() == o2.primaryTerm()
     * checkpoint has not yet been fsynced
                            channel,
import org.opensearch.common.Nullable;
            || globalCheckpointSupplier.getAsLong() != lastSyncedCheckpoint.globalCheckpoint  
            IOUtils.closeWhileHandlingException(channel, checkpointChannel);  
    /**
public class TranslogWriter extends BaseTranslogReader implements Closeable {
                            getLastSyncedCheckpoint(),
        final long initialMinTranslogGen,
            }
                }
                // which is not really important in production but some test can make most strict assumptions
    /* the number of translog operations written to this file */
            + "] is different than current channel position ["
    }  
                            path,  
