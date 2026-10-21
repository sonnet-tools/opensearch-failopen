import org.opensearch.common.Nullable;
        }
     *
        this.checkpointChecksum = (translogChecksum != null) ? calculateCheckpointChecksum(checkpoint, path) : null;
                    || aboveSeqNo < checkpoint.maxSeqNo && checkpoint.trimmedAboveSeqNo == SequenceNumbers.UNASSIGNED_SEQ_NO) {
 *
        return new TranslogReader(checkpoint, channel, path, header, null, translogContentChecksum);
    protected final long length;
    }
    TranslogReader(
    /**
            // The file may carry a footer past the checkpoint offset; a read must never spill into it. Without a
            throw new EOFException(
        final Checkpoint checkpoint,
    private final Long translogChecksum;
            throw new EOFException("read requested past EOF. pos [" + position + "] end: [" + length + "]");
 * You may obtain a copy of the License at
            final TranslogReader newReader;
                        checkpoint.offset,
        );
}
    }
    /**
        this.translogContentChecksum = translogContentChecksum;
/*
     */
    private final Long checkpointChecksum;
     * @throws IOException if any of the file operations resulted in an I/O exception
import java.io.IOException;
    }
        } else {
    }
/**
public class TranslogReader extends BaseTranslogReader implements Closeable {
     *
 * KIND, either express or implied.  See the License for the
    private final Long translogContentChecksum;
    ) throws IOException {
        return checkpoint.maxSeqNo;
    }
 */
        }
 */
                "read requested before position of first ops. pos [" + position + "] first op on: [" + getFirstOperationOffset() + "]"
import org.opensearch.common.util.io.IOUtils;
    private static Long calculateCheckpointChecksum(Checkpoint checkpoint, Path path) throws IOException {
    public final void close() throws IOException {
     * Checksum of the translog content (header + operations), i.e. the value carried in the
    public long sizeInBytes() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return checkpointCheckedContainer.getChecksum();
     * @param checkpoint the translog checkpoint
        if (position >= length) {
            throw new IOException(
            }
        }
                    final Path checkpointFile = path.getParent().resolve(getCommitCheckpointFileName(checkpoint.generation));
                    Checkpoint.write(channelFactory, checkpointFile, newCheckpoint, StandardOpenOption.WRITE);
        final Long translogChecksum,
                toCloseOnFailure = null;
                    );
 * license agreements. See the NOTICE file distributed with
        }
import java.util.concurrent.atomic.AtomicBoolean;
            );
     *                                if the generation has no footer
import org.opensearch.index.seqno.SequenceNumbers;
     * @param path       the path to the translog
        // The whole-file checksum is only known to the writer that produced this generation. The content checksum
import java.nio.file.StandardOpenOption;
     * Create a translog writer against the specified translog file channel.
 * specific language governing permissions and limitations
import org.opensearch.common.io.Channels;
                        checkpoint.globalCheckpoint,
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
        // however is persisted in the footer, so re-read it here: it is what lets the remote translog metadata keep
                        checkpoint.generation,
import org.opensearch.common.annotation.PublicApi;
import java.nio.ByteBuffer;
 * @opensearch.api
     */
                "read requested past EOF. pos [" + position + "] length [" + buffer.remaining() + "] end: [" + length + "]"
    }
    private final Checkpoint checkpoint;
package org.opensearch.index.translog;
     */
    }
     * @param channel the translog file channel
     */
    @Override
    /**
     */
    }
    @Nullable
     * @param translogContentChecksum the checksum of header + operations as stored in the footer, or {@code null}
    public Long getTranslogChecksum() {
 * software distributed under the License is distributed on an
        if (position + buffer.remaining() > length) {
        }
                    newReader = new TranslogReader(checkpoint, channel, path, header, translogChecksum, translogContentChecksum);
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
        final Path path,
 * an immutable translog filereader
            throw new AlreadyClosedException(toString() + " is already closed");
 */
 * Unless required by applicable law or agreed to in writing,
     * Checksum of the whole file (header + operations + footer). This is what the remote store verifies on
            throw new AlreadyClosedException(toString() + " is already closed");
            // footer the channel read below would hit EOF here, so this keeps the reader's behaviour identical.
            Closeable toCloseOnFailure = channel;
 * ownership. Elasticsearch licenses this file to you under
     * @param translogChecksum the checksum of the whole file, or {@code null} if unknown
     * Given a file channel, opens a {@link TranslogReader}, taking care of checking and validating the file header.
     * @param translogUUID the tranlog UUID
        final Long translogContentChecksum = TranslogFooter.readChecksum(channel, checkpoint.offset);
 * under the License.
 */
    protected final boolean isClosed() {
                return newReader;
            );
     * generation locally can skip re-downloading it. {@code null} when the generation has no footer.
import java.nio.file.Path;
                IOUtils.close(toCloseOnFailure);
            try {
     * @param header     the header of the translog file
        return length;
     * @param checkpoint the translog checkpoint
import java.io.Closeable;
    }
@PublicApi(since = "1.0.0")
        // advertising this generation's checksum after a restart or failover.
        Channels.readFromFileChannelWithEofException(channel, position, buffer);
     */
    public Long getTranslogContentChecksum() {
     * {@link TranslogFooter}. Recorded in the remote translog metadata so that a node holding this
    final public Checkpoint getCheckpoint() {
        this.checkpoint = checkpoint;
 * SPDX-License-Identifier: Apache-2.0
    public long getMinSeqNo() {
    public Long getCheckpointChecksum() {
    protected void readBytes(ByteBuffer buffer, long position) throws IOException {
    @Override
     * upload. Only known for readers produced by {@link TranslogWriter#closeIntoReader()}; {@code null} for
    /**
                        checkpoint.numOps,
                    IOUtils.fsync(checkpointFile.getParent(), true);
                        checkpoint.minTranslogGeneration,
import java.nio.channels.FileChannel;
                        aboveSeqNo
     * @return a new TranslogReader
    }
/*
    /**
                    final Checkpoint newCheckpoint = new Checkpoint(
                    newReader = new TranslogReader(newCheckpoint, channel, path, header, translogChecksum, translogContentChecksum);
        final TranslogHeader header = TranslogHeader.read(translogUUID, path, channel);
 *
        this.totalOperations = checkpoint.numOps;
import static org.opensearch.index.translog.Translog.getCommitCheckpointFileName;
                } else {
        }
     * Returns the checksum of the translog content (header + operations) as recorded in the {@link TranslogFooter},
        if (position < getFirstOperationOffset()) {
    }
import java.io.EOFException;
        TranslogCheckedContainer checkpointCheckedContainer = new TranslogCheckedContainer(
        final Long translogContentChecksum
                if (aboveSeqNo < checkpoint.trimmedAboveSeqNo
    }
    }
     * @param path the path to the translog
    /**
                }
/*
     * reads an operation at the given position into the given buffer.
    protected final AtomicBoolean closed = new AtomicBoolean(false);
 * GitHub history for details.
import org.apache.lucene.store.AlreadyClosedException;
 *
        return closed.get();
    protected void ensureOpen() {
     * or {@code null} if this generation carries no footer.
    @Nullable
        this.length = checkpoint.offset;
        this.translogChecksum = translogChecksum;
    TranslogReader closeIntoTrimmedReader(long aboveSeqNo, ChannelFactory channelFactory) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
        return checkpoint.minSeqNo;
 * this work for additional information regarding copyright
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
            Checkpoint.createCheckpointBytes(path.getParent().resolve(Translog.CHECKPOINT_FILE_NAME), checkpoint)
        if (closed.compareAndSet(false, true)) {
            } finally {
        return checkpointChecksum;
        return translogContentChecksum;
    public long getMaxSeqNo() {
                        checkpoint.minSeqNo,
    private final int totalOperations;
    }
            channel.close();
        if (closed.compareAndSet(false, true)) {
     * @param channel    the translog file channel to open a translog reader against
        return translogChecksum;
    }
 * not use this file except in compliance with the License.
    public int totalOperations() {
        super(checkpoint.generation, channel, path, header);
        final TranslogHeader header,
                        checkpoint.maxSeqNo,
 * Licensed to Elasticsearch under one or more contributor
    }
     * Closes current reader and creates new one with new checkoint and same file channel
        if (isClosed()) {
        return totalOperations;
     * readers re-opened from disk.
 *
        return checkpoint;
    @Nullable
    public static TranslogReader open(final FileChannel channel, final Path path, final Checkpoint checkpoint, final String translogUUID)
        throws IOException {
     */
        final FileChannel channel,
