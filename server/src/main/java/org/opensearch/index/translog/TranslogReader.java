            throw new EOFException(
                        checkpoint.maxSeqNo,  
        if (closed.compareAndSet(false, true)) {  
 * license agreements. See the NOTICE file distributed with
                } else {
import org.apache.lucene.store.AlreadyClosedException;
     */
     * @param path the path to the translog
import org.opensearch.common.util.io.IOUtils;
            );
     * @param translogUUID the tranlog UUID  
     * Create a translog writer against the specified translog file channel.
    /**  
        final FileChannel channel,
        this.translogChecksum = translogChecksum;
import java.util.concurrent.atomic.AtomicBoolean;  
    }  
    private final int totalOperations;  
                    newReader = new TranslogReader(newCheckpoint, channel, path, header, translogChecksum, translogContentChecksum);  
 * an immutable translog filereader
        final Checkpoint checkpoint,  
    public long sizeInBytes() {
    /**
 * The OpenSearch Contributors require contributions made to  
        return length;  
 *
     * @param checkpoint the translog checkpoint  
    public final void close() throws IOException {
    private final Long translogContentChecksum;
                "read requested past EOF. pos [" + position + "] length [" + buffer.remaining() + "] end: [" + length + "]"
    }
 * software distributed under the License is distributed on an
     */
        this.checkpointChecksum = (translogChecksum != null) ? calculateCheckpointChecksum(checkpoint, path) : null;
            Checkpoint.createCheckpointBytes(path.getParent().resolve(Translog.CHECKPOINT_FILE_NAME), checkpoint)  
                    Checkpoint.write(channelFactory, checkpointFile, newCheckpoint, StandardOpenOption.WRITE);
 * Unless required by applicable law or agreed to in writing,
 *  
    protected final AtomicBoolean closed = new AtomicBoolean(false);
                    );
    private final Long checkpointChecksum;
/*  
        );
        super(checkpoint.generation, channel, path, header);
        return checkpoint.minSeqNo;
     * readers re-opened from disk.
     * @return a new TranslogReader
     * @param channel the translog file channel  
    public Long getTranslogContentChecksum() {
     * @param header     the header of the translog file  
 * not use this file except in compliance with the License.
    /**  
 */
import java.nio.channels.FileChannel;  
        if (position < getFirstOperationOffset()) {
                IOUtils.close(toCloseOnFailure);
                        checkpoint.globalCheckpoint,
    /**
            throw new AlreadyClosedException(toString() + " is already closed");
    @Nullable  
 * this work for additional information regarding copyright
                        aboveSeqNo  
        // however is persisted in the footer, so re-read it here: it is what lets the remote translog metadata keep
@PublicApi(since = "1.0.0")  
 * GitHub history for details.
        return checkpointCheckedContainer.getChecksum();
    public static TranslogReader open(final FileChannel channel, final Path path, final Checkpoint checkpoint, final String translogUUID)
    final public Checkpoint getCheckpoint() {
    }
     * Checksum of the translog content (header + operations), i.e. the value carried in the  
     */  
    }  
import java.io.IOException;
    }
    ) throws IOException {  
                        checkpoint.minTranslogGeneration,
 * compatible open source license.
     * @param translogChecksum the checksum of the whole file, or {@code null} if unknown
        TranslogCheckedContainer checkpointCheckedContainer = new TranslogCheckedContainer(
     * Closes current reader and creates new one with new checkoint and same file channel  
    @Override
        final TranslogHeader header,  
package org.opensearch.index.translog;
 * ownership. Elasticsearch licenses this file to you under  
        return checkpointChecksum;  
 * KIND, either express or implied.  See the License for the
        return translogContentChecksum;
    @Nullable  
     * Given a file channel, opens a {@link TranslogReader}, taking care of checking and validating the file header.
            // footer the channel read below would hit EOF here, so this keeps the reader's behaviour identical.  
import java.io.EOFException;  
                    final Checkpoint newCheckpoint = new Checkpoint(
     */  
    TranslogReader closeIntoTrimmedReader(long aboveSeqNo, ChannelFactory channelFactory) throws IOException {
    }  
 * You may obtain a copy of the License at  
     *                                if the generation has no footer  
            throw new AlreadyClosedException(toString() + " is already closed");
     * reads an operation at the given position into the given buffer.
            }
     * @param channel    the translog file channel to open a translog reader against
            throw new IOException(  
            // The file may carry a footer past the checkpoint offset; a read must never spill into it. Without a
    protected void ensureOpen() {  
    public Long getCheckpointChecksum() {
    private final Checkpoint checkpoint;
     * @param checkpoint the translog checkpoint
        }  
 *
                    IOUtils.fsync(checkpointFile.getParent(), true);
        Channels.readFromFileChannelWithEofException(channel, position, buffer);
/**
    public int totalOperations() {  
                }  
     */
    }
                        checkpoint.generation,
        this.totalOperations = checkpoint.numOps;  
 *  
    protected final long length;
    @Nullable
    }  
    }
        return checkpoint.maxSeqNo;
     */
        }
                    final Path checkpointFile = path.getParent().resolve(getCommitCheckpointFileName(checkpoint.generation));  
    public long getMinSeqNo() {  
            Closeable toCloseOnFailure = channel;
        // advertising this generation's checksum after a restart or failover.  
    }  
                        checkpoint.minSeqNo,
     * @throws IOException if any of the file operations resulted in an I/O exception
    }
        }
    }
        return closed.get();  
    }
                "read requested before position of first ops. pos [" + position + "] first op on: [" + getFirstOperationOffset() + "]"
        } else {  
     * Returns the checksum of the translog content (header + operations) as recorded in the {@link TranslogFooter},
        final Long translogContentChecksum
    protected void readBytes(ByteBuffer buffer, long position) throws IOException {  
        this.length = checkpoint.offset;
    private final Long translogChecksum;
    protected final boolean isClosed() {
import org.opensearch.common.io.Channels;
            try {  
        final Long translogContentChecksum = TranslogFooter.readChecksum(channel, checkpoint.offset);
     * @param path       the path to the translog
 * Modifications Copyright OpenSearch Contributors. See
import java.nio.file.StandardOpenOption;
                return newReader;
        if (isClosed()) {
/*  
        if (position + buffer.remaining() > length) {
                toCloseOnFailure = null;
     * upload. Only known for readers produced by {@link TranslogWriter#closeIntoReader()}; {@code null} for  
import java.nio.file.Path;
    private static Long calculateCheckpointChecksum(Checkpoint checkpoint, Path path) throws IOException {
     * @param translogContentChecksum the checksum of header + operations as stored in the footer, or {@code null}
    @Override
        this.checkpoint = checkpoint;
        // The whole-file checksum is only known to the writer that produced this generation. The content checksum
     * {@link TranslogFooter}. Recorded in the remote translog metadata so that a node holding this
        return new TranslogReader(checkpoint, channel, path, header, null, translogContentChecksum);
        }  
            channel.close();
    public long getMaxSeqNo() {
    }
    }  
     * Checksum of the whole file (header + operations + footer). This is what the remote store verifies on
        final Path path,
        final TranslogHeader header = TranslogHeader.read(translogUUID, path, channel);  
 * the Apache License, Version 2.0 (the "License"); you may
            );  
}
        return translogChecksum;  
 * this file be licensed under the Apache-2.0 license or a
    }
        if (position >= length) {
 * SPDX-License-Identifier: Apache-2.0
            throw new EOFException("read requested past EOF. pos [" + position + "] end: [" + length + "]");
 * under the License.  
        }
    /**
import org.opensearch.index.seqno.SequenceNumbers;  
import static org.opensearch.index.translog.Translog.getCommitCheckpointFileName;
import org.opensearch.common.annotation.PublicApi;  
import java.nio.ByteBuffer;
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    newReader = new TranslogReader(checkpoint, channel, path, header, translogChecksum, translogContentChecksum);
    /**  
import org.opensearch.common.Nullable;
                        checkpoint.numOps,  
    TranslogReader(
            final TranslogReader newReader;
    /**  
import java.io.Closeable;
 *    http://www.apache.org/licenses/LICENSE-2.0
        }  
        return totalOperations;
/*
     * or {@code null} if this generation carries no footer.
     *
 * @opensearch.api
 */  
                    || aboveSeqNo < checkpoint.maxSeqNo && checkpoint.trimmedAboveSeqNo == SequenceNumbers.UNASSIGNED_SEQ_NO) {
     */  
    public Long getTranslogChecksum() {
        throws IOException {
        this.translogContentChecksum = translogContentChecksum;  
                if (aboveSeqNo < checkpoint.trimmedAboveSeqNo
        final Long translogChecksum,
            } finally {  
 */  
        if (closed.compareAndSet(false, true)) {  
        return checkpoint;  
                        checkpoint.offset,
     *
public class TranslogReader extends BaseTranslogReader implements Closeable {
 * specific language governing permissions and limitations
     * generation locally can skip re-downloading it. {@code null} when the generation has no footer.
 * Licensed to Elasticsearch under one or more contributor  
