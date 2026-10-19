        }
        ChannelFactory channelFactory,
                    flushedSequenceNumbers.forEach(persistedSequenceNumberConsumer::accept);
 *
                            tragedy.get()
        return new Checkpoint(
     * before the batch (mirroring the per-op check amortised over the batch) and the writer monitor is entered a
                maxSeqNo = SequenceNumbers.max(maxSeqNo, seqNo);
        long fileGeneration,
                }
        }
     */
import org.apache.lucene.util.BytesRef;
                channel,
            // The running checksum serves the remote store only: it produces the whole-file checksum verified on upload
        final ShardId shardId,
        LongSupplier minTranslogGenerationSupplier,
            BytesRef current;
import org.opensearch.common.bytes.ReleasableBytesReference;
                final long seqNo = seqNos[i];
        long fileGeneration,
        return closed.get();
    private boolean checkChannelPositionWhileHandlingException(long expectedOffset) {
        }
                        + ":"
                }
            final TranslogHeader header = new TranslogHeader(translogUUID, primaryTerm);
                }
        final TragicExceptionHolder tragedy,
                while (currentBytesConsumed != current.length) {
    Checkpoint getLastSyncedCheckpoint() {
        this.forceWriteThreshold = Math.toIntExact(bufferSize.getBytes());
            checkpointChannel = channelFactory.open(checkpointFile, StandardOpenOption.WRITE);
                op = Translog.readOperation(new BufferedChecksumStreamInput(e.getValue().v1().streamInput(), "assertion"));
        final Translog.Location location;
import java.nio.file.Path;
                    }
        final Translog.Location[] locations = new Translog.Location[count];
     * Syncs the translog up to at least the given offset unless already synced
            minSeqNo,
    /**
import java.util.HashMap;
import org.opensearch.common.io.Channels;
/*
            final Tuple<BytesReference, Exception> previous = seenSequenceNumbers.get(seqNo);
            assert maxSeqNo != SequenceNumbers.NO_OPS_PERFORMED || operationCounter == 0;
import java.util.function.LongConsumer;
                persistedSequenceNumberConsumer,
                    assert totalOffset == lastSyncedCheckpoint.offset;
                        Long translogContentChecksum = null;
        final Path checkpointFile,
 * this work for additional information regarding copyright
                        translogCheckedContainer.updateFromBytes(current.bytes, current.offset + currentBytesConsumed, nBytesToWrite);
                checkpoint,
            TranslogOperationHelper.DEFAULT
        return create(
                // if we don't fail in this call unless absolutely necessary.
    private final LongSupplier globalCheckpointSupplier;
     */
        }
     * The last synced checkpoint for this translog.
                        && o1.version() == o2.version();
        // make sure to acquire the sync lock first, to prevent dead locks with threads calling
                );
                            toWrite = pollOpsToWrite();
            }
import java.util.concurrent.atomic.AtomicBoolean;
                nonFsyncedSequenceNumbers.add(seqNo);
import java.util.function.LongSupplier;
            bufferedBytes = buffer.size();
                        + ":"
        String translogUUID,
    ) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
        TranslogOperationHelper translogOperationHelper
                                IOUtils.closeWhileHandlingException(channel);
/*
                            + "] was processed twice in generation ["
        }
                    assert totalOffset == lastSyncedCheckpoint.offset;
                    try {
    }
        final ByteSizeValue bufferSize,
            }
            }
        );
        final long primaryTerm,
    TranslogSnapshot newSnapshot() {
                buffer = null;
                    if (translogCheckedContainer != null) {
                    assert lastSyncedCheckpoint.offset <= checkpointToSync.offset : "illegal state: "
            return expectedOffset == channel.position();
    /* the total offset of this file including the bytes written to the file as well as into the buffer */
 * ownership. Elasticsearch licenses this file to you under
                        return new TranslogReader(
import org.opensearch.common.io.DiskIoBufferPool;
                seqNo,
                }
     * <p>
            assert bufferedBytes == buffer.size();
        } else {
     *
                            translogChecksum,
    @Override
        super(initialCheckpoint.generation, channel, path, header);
        final LongConsumer persistedSequenceNumberConsumer,
                            } catch (final Exception ex) {
                        synchronized (this) {
 * Unless required by applicable law or agreed to in writing,
            if (primaryTerm < belowTerm) {
                            closeWithTragicEvent(ex);
    }
                        }
    private volatile Checkpoint lastSyncedCheckpoint;
     * Adds a batch of already-serialized operations to the translog in a single critical section. Each entry in
    // lock order try(Releasable lock = writeLock.acquire()) -> synchronized(this)
            + channel.position()
        // After the sync lock we acquire the write lock to avoid deadlocks with threads writing where
package org.opensearch.index.translog;
                        try {
            return new TranslogWriter(
    }
                header.sizeInBytes(),
    }
                        Long translogChecksum = null;
        assert initialCheckpoint.trimmedAboveSeqNo == SequenceNumbers.UNASSIGNED_SEQ_NO : initialCheckpoint.trimmedAboveSeqNo;
        TranslogOperationHelper translogOperationHelper
            return new ReleasableBytesReference(toWrite.bytes(), toWrite);
                            // Write ops will release operations.
                        }
 *
        this.lastSyncedCheckpoint = initialCheckpoint;
    private final Object syncLock = new Object();
            ensureOpen();
                // TODO: We haven't had timestamp for Index operations in Lucene yet, we need to loosen this check without timestamp.
            while ((current = iterator.next()) != null) {
     *
        } catch (final Exception ex) {
            TranslogCheckedContainer translogCheckedContainer = null;
            nonFsyncedSequenceNumbers.add(seqNo);
                    assert checkChannelPositionWhileHandlingException(totalOffset);
                    final ReleasableBytesReference toWrite;
                    }
        Boolean remoteTranslogEnabled,
                    try (ReleasableLock toClose = writeLock.acquire()) {
import org.opensearch.core.common.io.stream.BufferedChecksumStreamInput;
                final long offset = totalOffset;
    @Override
        final Path path,
                        && o1.seqNo() == o2.seqNo()
                        throw ex;
                            + seqNo
            } catch (Exception e) {
            if (Assertions.ENABLED) {
import org.opensearch.core.common.unit.ByteSizeValue;
                            channel,
            assert assertNoSeqNumberConflict(seqNo, data);
        }
                        sync(); // sync before we close..
            assert writeLock.isHeldByCurrentThread();
        });
            long seqNo = op.seqNo();
                            getLastSyncedCheckpoint(),
                                translogCheckedContainer.updateFromBytes(footer, 0, footer.length);
                    // the lock we should check again since if this code is busy we might have fsynced enough already
            throw new AlreadyClosedException("translog [" + getGeneration() + "] is already closed", tragedy.get());
            bufferedBytes = buffer.size();
        TranslogCheckedContainer translogCheckedContainer,
            return ReleasableBytesReference.wrap(BytesArray.EMPTY);
                            "translog [" + getGeneration() + "] is already closed (path [" + path + "]",
            ioBuffer.flip();
            // if we fail to bake the file-generation into the checkpoint we stick with the file and once we recover and that
            this.bufferedBytes = 0;
        Path file,
    @Override
                            + prvOp
                    }
            final Checkpoint checkpoint = Checkpoint.emptyTranslogCheckpoint(
     * checkpoint has not yet been fsynced
            if (previous.v1().equals(data) == false) {
                        + checkpointToSync.offset;
@PublicApi(since = "1.0.0")
            generation,
                throw new RuntimeException(ex);
            translogUUID,
            try {
        }
                bufferedBytes = 0;
            );
        return false;
 * GitHub history for details.
                            translogChecksum = translogCheckedContainer.getChecksum();
            + "] is different than current channel position ["
            BytesRefIterator iterator = toWrite.iterator();
    }
                fileGeneration,
        final LongSupplier globalCheckpointSupplier,
                        sync();
                    final List<Long> flushedSequenceNumbers;
import org.opensearch.index.seqno.SequenceNumbers;
        }
    }
    public Translog.Location[] add(final BytesReference[] data, final long[] seqNos) throws IOException {
 * KIND, either express or implied.  See the License for the
                    return true;
        return totalOffset != lastSyncedCheckpoint.offset
                            + "], with different data. "
        }
/*
                        + "]";
 *    http://www.apache.org/licenses/LICENSE-2.0
                                throw ex;
                    );
                    sameOp = translogOperationHelper.hasSameIndexOperation(o1, o2);
import java.util.ArrayList;
                        if (!Boolean.TRUE.equals(remoteTranslogEnabled)) {
    ) throws IOException {
    }
            data.writeTo(buffer);
            // nothing to do
                    return super.newSnapshot();
        }
                remoteTranslogEnabled,
        ByteSizeValue bufferSize,
                            path,
     * @return the locations the operations were written to, parallel to {@code data}
/**
                } else if (newOp instanceof Translog.Delete newDelete && prvOp instanceof Translog.Delete prvDelete) {
            seenSequenceNumbers.put(
                if (sameOp == false) {
import java.util.List;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        this.seenSequenceNumbers = Assertions.ENABLED ? new HashMap<>() : null;
            ByteBuffer ioBuffer = DiskIoBufferPool.getIoBuffer();
                buffer = new ReleasableBytesStreamOutput(bigArrays);
                    // double checked locking - we don't want to fsync unless we have to and now that we have
    protected final boolean isClosed() {
 *
            }
     */
        this.checkpointPath = checkpointPath;
        }
        if (seqNo == SequenceNumbers.UNASSIGNED_SEQ_NO) {
            synchronized (syncLock) { // only one sync/checkpoint should happen concurrently but we wait
     * @param data  the bytes to write
    ) throws IOException {
        final FileChannel channel = channelFactory.open(file);
                        }
        assert data.length == seqNos.length : "data and seqNos length mismatch: " + data.length + " != " + seqNos.length;
    }
    private final LongConsumer persistedSequenceNumberConsumer;
     */
                throw new AssertionError(
                        // and is downloaded in full like any other. Local-only translogs carry no footer (see create).
        return totalOffset;
    ) throws IOException {
                        + "] lower than initial gcp ["
                writeBufferedOps(position + targetBuffer.remaining(), true);
    }
        }
import org.opensearch.common.collect.Tuple;
     * on-disk bytes are byte-identical to performing N individual adds. The force-write threshold is evaluated once
import org.opensearch.common.util.concurrent.ReleasableLock;
            }
     */
import java.util.Map;
    protected final AtomicBoolean closed = new AtomicBoolean(false);
                            throw ex;
                            header,
    public TranslogReader closeIntoReader() throws IOException {
                        // crash before this point simply leaves a footer-less generation behind, which is still valid
    private void writeAndReleaseOps(ReleasableBytesReference toWrite) throws IOException {
                    } else {
        // After the sync lock we acquire the write lock to avoid deadlocks with threads writing where
 * not use this file except in compliance with the License.
                translogOperationHelper
                        );
     * Add the given bytes to the translog with the specified sequence number; returns the location the bytes were written to.
        final LongSupplier globalCheckpointSupplier,
    public Translog.Location add(final BytesReference data, final long seqNo) throws IOException {
                    } catch (final Exception ex) {
    private final int forceWriteThreshold;
                        } catch (final Exception ex) {
 * the Apache License, Version 2.0 (the "License"); you may
                    "current should not have any operations with seq#:primaryTerm ["
     * Returns <code>true</code> if there are buffered operations that have not been flushed and fsynced to disk or if the latest global
                writerGlobalCheckpointSupplier = globalCheckpointSupplier;
    public boolean syncNeeded() {
                            nonFsyncedSequenceNumbers = new ArrayList<>(64);
                shardId,
                        ioBuffer.clear();
     * @throws IOException if any of the file operations resulted in an I/O exception
        }
            || minTranslogGenerationSupplier.getAsLong() != lastSyncedCheckpoint.minTranslogGeneration;
 * specific language governing permissions and limitations
                            writeAndReleaseOps(toWrite);
    private final Path checkpointPath;
    /**
    @Nullable
                        } catch (final Exception ex) {
        }
        } catch (final IOException | RuntimeException e) {
        long bufferedBytesBeforeAdd = this.bufferedBytes;
                closeWithTragicEvent(e);
            channel.write(ioBuffer);
            operationCounter++;
                            closeWithTragicEvent(ex);
        final Path checkpointFile = file.getParent().resolve(Translog.CHECKPOINT_FILE_NAME);
                throw e;
            // file exists we remove it. We only apply this logic to the checkpoint.generation+1 any other file with a higher generation
     * @throws IOException if writing to the translog resulted in an I/O exception
    private static void writeCheckpoint(
            }
     * @param seqNos the sequence number associated with each operation, parallel to {@code data}
                } else {
                                tragedy.setTragicException(ex);
                assert minSeqNo != SequenceNumbers.NO_OPS_PERFORMED || operationCounter == 0;
            final long offset = totalOffset;
                            checkpointToSync = getCheckpoint();
                locations[i] = new Translog.Location(generation, offset, d.length());
     *
                        closeWithTragicEvent(ex);
                    }
     * Note: any exception during the sync process will be interpreted as a tragic exception and the writer will be closed before
                                // closed is already set, so close() would be a no-op: release the channel explicitly.
    }
 * Licensed to Elasticsearch under one or more contributor
    private final BigArrays bigArrays;
            }
                    ioBuffer.put(current.bytes, current.offset + currentBytesConsumed, nBytesToWrite);
                            throw ex;
                tragedy,
            remoteTranslogEnabled,
        return syncUpTo(Long.MAX_VALUE);
    }
        final LongSupplier globalCheckpointSupplier,
        } catch (IOException e) {
            persistedSequenceNumberConsumer,
     */
                file,
 */
                bufferSize,
                if (newOp instanceof Translog.Index newIndex && prvOp instanceof Translog.Index prvIndex) {
                }
     * {@code data} is framed exactly as a single {@link #add(BytesReference, long)} call would frame it, so the
                    writeAndReleaseOps(pollOpsToWrite());
                buffer = new ReleasableBytesStreamOutput(bigArrays);
                    assert gcp >= initialGlobalCheckpoint || (remoteTranslogEnabled == Boolean.TRUE) : "global checkpoint ["
            synchronized (this) {
        Path file,
    /**
import org.opensearch.common.SuppressForbidden;
            fileGeneration,
                Translog.Operation prvOp = Translog.readOperation(
                    // now do the actual fsync outside of the synchronized block such that
                            checkpointChannel.close();
    /* if we hit an exception that we can't recover from we assign it to this var and ship it with every AlreadyClosedException we throw */
            writeToFile(ioBuffer);
        // make sure to acquire the sync lock first, to prevent dead locks with threads calling
        final long initialMinTranslogGen,
                );
        ByteSizeValue bufferSize,
                synchronized (this) {
            + initialCheckpoint.offset
import org.opensearch.common.lease.Releasables;
        ensureOpen();
            totalOffset,
        }
            }
                    final Translog.Delete o2 = prvDelete;
    }
        Boolean remoteTranslogEnabled,
                        + primaryTerm
    public long sizeInBytes() {
        return channel.position();
                bigArrays,
                    final Translog.Index o1 = prvIndex;
        return location;
            } catch (IOException ex) {
            );
    private final LongSupplier minTranslogGenerationSupplier;
        // syncUpTo() , where the sync lock is acquired first, following by the synchronize(this)
        // Note: While this is not strictly needed as this method is called while blocking all ops on the translog,
                            translogContentChecksum
                    if (closed.compareAndSet(false, true)) {
            writeCheckpoint(checkpointChannel, checkpointFile, checkpoint, remoteTranslogEnabled);
    /**
        long initialGlobalCheckpoint,
                int currentBytesConsumed = 0;
            + "]";
    final boolean syncUpTo(long offset) throws IOException {
 * The OpenSearch Contributors require contributions made to
        TragicExceptionHolder tragedy,
        synchronized (this) {
            initialMinTranslogGen,
                            }
}
    public static TranslogWriter create(
        this.tragedy = tragedy;
            throw exception;
    private TranslogWriter(
                        + "] > "
    private final ReleasableLock writeLock = new ReleasableLock(new ReentrantLock());
        } catch (Exception exception) {
        final FileChannel checkpointChannel,
                        writeCheckpoint(checkpointChannel, checkpointPath, checkpointToSync, remoteTranslogEnabled);
                // in some cases ie. a tragic event we might still be able to read the relevant value
            final LongSupplier writerGlobalCheckpointSupplier;
    private List<Long> nonFsyncedSequenceNumbers = new ArrayList<>(64);
            }
                    lastSyncedCheckpoint = checkpointToSync; // write protected by syncLock
    @Override
    // callback that's called whenever an operation with a given sequence number is successfully persisted.
        try (ReleasableBytesReference toClose = toWrite) {
    private long getWrittenOffset() throws IOException {
                    }
            minTranslogGenerationSupplier,
import org.apache.lucene.store.AlreadyClosedException;
        try {
            initialGlobalCheckpoint,
    private synchronized void closeWithTragicEvent(final Exception ex) {
            tragedy,
        }
                            ensureOpen();
                            translogContentChecksum = translogCheckedContainer.getChecksum();
                        throw ex;
                        }
        assert initialCheckpoint.offset == channel.position() : "initial checkpoint offset ["
    private ReleasableBytesStreamOutput buffer;
            }
                assert maxSeqNo != SequenceNumbers.NO_OPS_PERFORMED || operationCounter == 0;
    // the last checkpoint that was written when the translog was last synced
    }
        assert initialCheckpoint.maxSeqNo == SequenceNumbers.NO_OPS_PERFORMED : initialCheckpoint.maxSeqNo;
            totalOffset += data.length();
    private final Boolean remoteTranslogEnabled;
    /**
                minSeqNo = SequenceNumbers.min(minSeqNo, seqNo);
                if (lastSyncedCheckpoint.offset < offset && syncNeeded()) {
        return true;
    /**
                            channel.force(false);
import java.nio.ByteBuffer;
                            try {
                if (locked != null && offset > getWrittenOffset()) {
                            + generation
            channelFactory,
    @Override
    private volatile int operationCounter;
    @Override
                        }
        // for the requested location.
            writeBufferedOps(Long.MAX_VALUE, bufferedBytesBeforeAdd >= forceWriteThreshold * 4);
            }
                        ioBuffer.flip();
        long initialGlobalCheckpoint,
     * write all buffered ops to disk and fsync file.
                        // For a remote-store translog the generation is now immutable: append the footer carrying the
        final BigArrays bigArrays,
            for (int i = 0; i < count; i++) {
                        + belowTerm
        }
                    sameOp = false;
 * You may obtain a copy of the License at
        );
import java.util.concurrent.locks.ReentrantLock;
 * @opensearch.api
 */
        while (ioBuffer.remaining() > 0) {
                d.writeTo(buffer);
        if (isClosed()) {
        } else {
 * software distributed under the License is distributed on an
                new Tuple<>(new BytesArray(data.toBytesRef(), true), new RuntimeException("stack capture previous op"))
        ChannelFactory channelFactory,
                        + seqNo
                    // If we reached this point, all of the buffered ops should have been flushed successfully.
            globalCheckpointSupplier,
import org.opensearch.core.common.bytes.BytesArray;
                    return gcp;
            // A local-only translog is never downloaded, so it keeps the footer-less layout it has always had.
        final LongSupplier minTranslogGenerationSupplier,
    @SuppressForbidden(reason = "Channel#write")
        Checkpoint.write(fileChannel, checkpointFile, checkpoint, !Boolean.TRUE.equals(remoteTranslogEnabled));
    }
                Releasables.closeWhileHandlingException(buffer);
        final int count = data.length;
            ReleasableBytesStreamOutput toWrite = this.buffer;
                assert assertNoSeqNumberConflict(seqNo, d);
                        + initialGlobalCheckpoint
                writerGlobalCheckpointSupplier,
                    currentBytesConsumed += nBytesToWrite;
                        + gcp
     * Closes this writer and transfers its underlying file channel to a new immutable {@link TranslogReader}
        try {
        Channels.readFromFileChannelWithEofException(channel, position, targetBuffer);
        try {
    }
            }
            assert minSeqNo != SequenceNumbers.NO_OPS_PERFORMED || operationCounter == 0;
        ShardId shardId,
 */
            minSeqNo = SequenceNumbers.min(minSeqNo, seqNo);
    private final FileChannel checkpointChannel;
                initialGlobalCheckpoint,
        this.translogCheckedContainer = translogCheckedContainer;
            IOUtils.close(checkpointChannel, channel);
                operationCounter++;
import org.opensearch.common.io.stream.ReleasableBytesStreamOutput;
                    ensureOpen();
                        + " <= "
        if (lastSyncedCheckpoint.offset < offset && syncNeeded()) {
            if (Boolean.TRUE.equals(remoteTranslogEnabled)) {
        final LongConsumer persistedSequenceNumberConsumer,
        tragedy.setTragicException(ex);
 * SPDX-License-Identifier: Apache-2.0
     * @return a new {@link TranslogReader}
                    assert buffer == null;
     * @return <code>true</code> if this call caused an actual sync operation
 * Writer that writes operations to the translog
                    } catch (IOException e) {
            operationCounter,
                        + aboveSeqNo
        }
        this.shardId = shardId;
import org.opensearch.core.common.bytes.BytesReference;
                        + lastSyncedCheckpoint.offset
     */
    private void writeToFile(ByteBuffer ioBuffer) throws IOException {
            location = new Translog.Location(generation, offset, data.length());
            SequenceNumbers.UNASSIGNED_SEQ_NO
        this.bigArrays = bigArrays;
    private volatile long totalOffset;
import org.opensearch.common.util.BigArrays;
            assert bufferedBytes == buffer.size();
        final BigArrays bigArrays,
        ShardId shardId,
                        && o1.primaryTerm() == o2.primaryTerm()
        this.maxSeqNo = initialCheckpoint.maxSeqNo;
                    assert buffer == null;
     * @param data   the per-operation serialized bytes (each already size-framed and checksummed)
            primaryTerm,
    public int totalOperations() {
        if (this.buffer != null) {
                    }
                writerGlobalCheckpointSupplier = () -> {
                header,
import org.opensearch.core.index.shard.ShardId;
    private final TranslogCheckedContainer translogCheckedContainer;
            final Translog.Operation op;
        synchronized (this) {
import org.opensearch.core.Assertions;
        return lastSyncedCheckpoint;
                                // The remote store verifies the whole uploaded object, footer included.
import org.opensearch.common.Nullable;
                                // generation is fetched again instead of being reused.
public class TranslogWriter extends BaseTranslogReader implements Closeable {
    private volatile long maxSeqNo;
                                // Not fsynced: the upload is the durability point, and a torn footer only means the
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                // which is not really important in production but some test can make most strict assumptions
        this.translogOperationHelper = translogOperationHelper;
                final boolean sameOp;
            }
                Translog.Operation newOp = Translog.readOperation(new BufferedChecksumStreamInput(data.streamInput(), "assertion"));
    }
        } else if (seenSequenceNumbers.containsKey(seqNo)) {
            if (buffer == null) {
    /* the number of translog operations written to this file */
        //
            long primaryTerm = op.primaryTerm();
        return operationCounter;
            || globalCheckpointSupplier.getAsLong() != lastSyncedCheckpoint.globalCheckpoint
     * raising the exception.
    protected final void ensureOpen() {
        this.remoteTranslogEnabled = remoteTranslogEnabled;
            // is an error condition
        FileChannel checkpointChannel = null;
    private final TranslogOperationHelper translogOperationHelper;
    }
 * Modifications Copyright OpenSearch Contributors. See
        this.globalCheckpointSupplier = globalCheckpointSupplier;
        return locations;
                        closeWithTragicEvent(ex);
        // the write lock is acquired first followed by synchronize(this).
                header.write(byteArrayOutputStream);
    private final TragicExceptionHolder tragedy;
            );
        final FileChannel channel,
                    if (ioBuffer.hasRemaining() == false) {
                checkpointChannel,
            bigArrays,
            file,
        if (bufferedBytesBeforeAdd >= forceWriteThreshold) {
    // lock order synchronized(syncLock) -> try(Releasable lock = writeLock.acquire()) -> synchronized(this)
        try (ReleasableLock locked = blockOnExistingWriter ? writeLock.acquire() : writeLock.tryAcquire()) {
            }
                    assert checkChannelPositionWhileHandlingException(totalOffset);
        final long primaryTerm,
import java.nio.channels.FileChannel;
                        "seqNo ["
        final Checkpoint initialCheckpoint,
    }
    synchronized Checkpoint getCheckpoint() {
    private synchronized boolean assertNoSeqNumberConflict(long seqNo, BytesReference data) throws IOException {
                    final Checkpoint checkpointToSync;
    }
            maxSeqNo = SequenceNumbers.max(maxSeqNo, seqNo);
    public static TranslogWriter create(
                minTranslogGenerationSupplier,
            try (ReleasableLock toClose = writeLock.acquire()) {
        String translogUUID,
    synchronized boolean assertNoSeqAbove(long belowTerm, long aboveSeqNo) {
                        if (translogCheckedContainer != null) {
        final Checkpoint checkpoint,
import org.opensearch.common.util.io.IOUtils;
            try {
            minTranslogGenerationSupplier.getAsLong(),
import java.io.IOException;
                }
                            + "prvOp ["
import org.opensearch.common.annotation.PublicApi;
    }
                            flushedSequenceNumbers = nonFsyncedSequenceNumbers;
import java.io.ByteArrayOutputStream;
                    final Translog.Index o2 = newIndex;
    protected void readBytes(ByteBuffer targetBuffer, long position) throws IOException {
    }
                        previous.v2()
            header.write(channel, !Boolean.TRUE.equals(remoteTranslogEnabled));
                        // checksum of everything written so far (header + operations). It is placed past the offset
            writeBufferedOps(Long.MAX_VALUE, bufferedBytesBeforeAdd >= forceWriteThreshold * 4);
                    }
                checkpointFile,
            this.buffer = null;
     * single time for the whole batch rather than once per operation.
import java.io.Closeable;
                        throw new AlreadyClosedException(
        TranslogHeader header,
     * @throws IOException if writing to the translog resulted in an I/O exception
                            + "]",
        synchronized (syncLock) {
            close();
    }
                translogCheckedContainer,
            ensureOpen();
import java.util.Objects;
    private synchronized ReleasableBytesReference pollOpsToWrite() {
        if (closed.compareAndSet(false, true)) {
        seenSequenceNumbers.entrySet().stream().filter(e -> e.getKey().longValue() > aboveSeqNo).forEach(e -> {
            return true;
            bufferSize,
                            + "], newOp ["
    public final void close() throws IOException {
                    sameOp = Objects.equals(o1.id(), o2.id())
        // the write lock is acquired first followed by synchronize(this).
            // and feeds the footer written on close, which lets a download be skipped when the local copy is current.
                totalOffset += d.length();
                    // we can continue writing to the buffer etc.
                    try {
        this.totalOffset = initialCheckpoint.offset;
                    try {
                initialMinTranslogGen
                        throw new TranslogException(shardId, "exception while syncing before creating a snapshot", e);
            IOUtils.closeWhileHandlingException(channel, checkpointChannel);
            closeWithTragicEvent(ex);
                final BytesReference d = data[i];
    private volatile long minSeqNo;
    private final ShardId shardId;
            shardId,
        final BigArrays bigArrays,
                    new BufferedChecksumStreamInput(previous.v1().streamInput(), "assertion")
        // we do this to for correctness and preventing future issues.
            if (position + targetBuffer.remaining() > getWrittenOffset()) {
    }
    private void writeBufferedOps(long offset, boolean blockOnExistingWriter) throws IOException {
 * compatible open source license.
                        );
        Boolean remoteTranslogEnabled
        final FileChannel fileChannel,
    }
        final LongSupplier minTranslogGenerationSupplier,
        // we don't have to have a lock here because we only write ahead to the file, so all writes has been complete
                    // If we reached this point, all of the buffered ops should have been flushed successfully.
            if (buffer == null) {
        final Boolean remoteTranslogEnabled
                            + newOp
        final Path checkpointPath,
            try (ReleasableLock toClose = writeLock.acquire()) {
            maxSeqNo,
import java.nio.file.StandardOpenOption;
    private volatile long bufferedBytes;
                    throw new AssertionError(
                        writeToFile(ioBuffer);
                synchronized (this) {
     * @return the last synced checkpoint
        long bufferedBytesBeforeAdd = this.bufferedBytes;
        this.checkpointChannel = checkpointChannel;
        synchronized (syncLock) {
    public boolean sync() throws IOException {
 * license agreements. See the NOTICE file distributed with
                    } catch (final Exception ex) {
                translogCheckedContainer = new TranslogCheckedContainer(byteArrayOutputStream.toByteArray());
     * @param seqNo the sequence number associated with the operation
 * under the License.
        return true;
    }
        assert initialCheckpoint.minSeqNo == SequenceNumbers.NO_OPS_PERFORMED : initialCheckpoint.minSeqNo;
     *
                    final Translog.Delete o1 = newDelete;
                // we only flush here if it's really really needed - try to minimize the impact of the read operation
            }
        if (bufferedBytesBeforeAdd >= forceWriteThreshold) {
    }
     * @return  <code>true</code> if this call caused an actual sync operation
     * @return the location the bytes were written to
 */
        TragicExceptionHolder tragedy,
        // syncUpTo() , where the sync lock is acquired first, following by the synchronize(this)
                        try {
import org.apache.lucene.util.BytesRefIterator;
    /**
        try {
            globalCheckpointSupplier.getAsLong(),
            } else {
                };
                                final byte[] footer = TranslogFooter.write(channel, translogContentChecksum, false);
        final LongConsumer persistedSequenceNumberConsumer,
                        // recorded in the last synced checkpoint, so readers that predate the footer never see it; a
    private final Map<Long, Tuple<BytesReference, Exception>> seenSequenceNumbers;
                }
        this.persistedSequenceNumberConsumer = persistedSequenceNumberConsumer;
            throw ex;
            ex.addSuppressed(e);
                    long gcp = globalCheckpointSupplier.getAsLong();
    }
 *
    }
                    int nBytesToWrite = Math.min(current.length - currentBytesConsumed, ioBuffer.remaining());
        final long initialMinTranslogGen,
        this.minSeqNo = initialCheckpoint.minSeqNo;
        this.minTranslogGenerationSupplier = minTranslogGenerationSupplier;
