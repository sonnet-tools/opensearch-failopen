    private static final String CHECKPOINT_CODEC = "ckp";
 * compatible open source license.
        out.writeLong(offset);
        + Long.BYTES // offset
 * The OpenSearch Contributors require contributions made to
            )
    public boolean equals(Object o) {
        out.writeLong(trimmedAboveSeqNo);
 * ownership. Elasticsearch licenses this file to you under
    }
        byte[] bytes = createCheckpointBytes(checkpointFile, checkpoint);
            + "]";
    @Override
        out.writeInt(numOps);
 * GitHub history for details.
                V4_FILE_SIZE
     * @param minSeqNo              the current minimum sequence number of all operations in the translog
    static final int V4_FILE_SIZE = CodecUtil.headerLength(CHECKPOINT_CODEC) + Integer.BYTES  // ops
            + ", numOps="
        final long offset,
        if (o == null || getClass() != o.getClass()) return false;
                + indexOutput.getFilePointer();
    }
import java.io.ByteArrayOutputStream;
 *
 * You may obtain a copy of the License at
    /**
    }
    long maxEffectiveSeqNo() {
        out.writeLong(generation);
import org.apache.lucene.store.IOContext;
import org.apache.lucene.index.IndexFormatTooNewException;
    final long maxSeqNo;
        this.trimmedAboveSeqNo = trimmedAboveSeqNo;
        }
        if (maxSeqNo != that.maxSeqNo) return false;
        + CodecUtil.footerLength();
        final long globalCheckpoint,
                CodecUtil.checksumEntireFile(indexInput);
    final long globalCheckpoint;
            + ", maxSeqNo="
    final long minTranslogGeneration;
        }
        }
 * @opensearch.api
    public int hashCode() {
            + ", trimmedAboveSeqNo="
     */
            + offset
                final int fileVersion = CodecUtil.checkHeader(indexInput, CHECKPOINT_CODEC, VERSION_LUCENE_BIG_ENDIAN, CURRENT_VERSION);
    final long generation;
    }
 * Licensed to Elasticsearch under one or more contributor
    private static final int CURRENT_VERSION = 4; // introduction of trimmed above seq#
        + Long.BYTES // minimum translog generation in the translog
            + minSeqNo
    }
        Checkpoint that = (Checkpoint) o;
            return maxSeqNo;
    public long getGeneration() {
            + numOps
        int numOps,
            + ", minSeqNo="
    }
        if (this == o) return true;
import org.opensearch.common.annotation.PublicApi;
                // We checksum the entire file before we even go and parse it. If it's corrupted we barf right here.
        result = 31 * result + Long.hashCode(generation);
import org.apache.lucene.store.DataOutput;
    }
        if (offset != that.offset) return false;
        final long minSeqNo = SequenceNumbers.NO_OPS_PERFORMED;
    @Override
        this.numOps = numOps;
        return "Checkpoint{"
import org.opensearch.common.io.Channels;
        }
            // when we first created the file, so the directory entry doesn't change as well
    }
 *
        final long minTranslogGeneration = in.readLong();
        long maxSeqNo,
import org.apache.lucene.store.NIOFSDirectory;
    public static void write(FileChannel fileChannel, Path checkpointFile, Checkpoint checkpoint, boolean fsync) throws IOException {
        };
    }
    Checkpoint(
        final long maxSeqNo = SequenceNumbers.NO_OPS_PERFORMED;
        long offset,
public final class Checkpoint {
import org.apache.lucene.index.CorruptIndexException;
     * @param numOps                the current number of operations in the translog
 *
     *                              corresponding translog file. {@link SequenceNumbers#UNASSIGNED_SEQ_NO} is used to disable trimming.
                return buf;
        long generation,
        result = 31 * result + numOps;
        final String resourceDesc = "checkpoint(path=\"" + checkpointFile + "\", gen=" + checkpoint + ")";
        } else {
        + Long.BYTES // global checkpoint
    public String toString() {
                + ", buffer size: "
        + Long.BYTES // maximum sequence number
        this.generation = generation;
     * @param trimmedAboveSeqNo     all operations with seq# above trimmedAboveSeqNo should be ignored and not read from the
        out.writeLong(globalCheckpoint);
        return result;
                resourceDesc,
     * @param maxSeqNo              the current maximum sequence number of all operations in the translog
    static Checkpoint readCheckpointV4(final DataInput in) throws IOException {
}
            + generation
                throw new TranslogCorruptedException(path.toString(), e);
import java.nio.file.Path;
 * SPDX-License-Identifier: Apache-2.0
    }
        long globalCheckpoint,
@PublicApi(since = "1.0.0")
        byte[] bytes = createCheckpointBytes(checkpointFile, checkpoint);
 * specific language governing permissions and limitations
     * @param offset                the current offset in the translog
 */
            return Math.min(trimmedAboveSeqNo, maxSeqNo);
     * @param globalCheckpoint      the last-known global checkpoint
        long trimmedAboveSeqNo
        this.globalCheckpoint = globalCheckpoint;
    private void write(DataOutput out) throws IOException {
        Channels.writeToChannel(bytes, fileChannel, 0);
        if (globalCheckpoint != that.globalCheckpoint) return false;
import org.apache.lucene.store.DataInput;
        try (Directory dir = new NIOFSDirectory(path.getParent())) {
import org.apache.lucene.store.OutputStreamIndexOutput;
        assert minSeqNo <= maxSeqNo : "minSeqNo [" + minSeqNo + "] is higher than maxSeqNo [" + maxSeqNo + "]";
        + Long.BYTES // generation
            + minTranslogGeneration
    public static Checkpoint read(Path path) throws IOException {
/*
 * A checkpoint for OpenSearch operations
            public synchronized byte[] toByteArray() {
        if (fsync == true) {
 */
        }
        long minSeqNo,
    final long trimmedAboveSeqNo;
        return new Checkpoint(offset, 0, generation, minSeqNo, maxSeqNo, globalCheckpoint, minTranslogGeneration, trimmedAboveSeqNo);
     * @param minTranslogGeneration the minimum generation referenced by the translog at this moment.
                assert fileVersion == CURRENT_VERSION || fileVersion == VERSION_LUCENE_BIG_ENDIAN : fileVersion;
    private static final int VERSION_LUCENE_BIG_ENDIAN = 3; // big endian format (Lucene 9+ switches to little endian)
            + ", globalCheckpoint="
    public long getMinTranslogGeneration() {
    ) {
package org.opensearch.index.translog;
/*
        try (
        if (numOps != that.numOps) return false;
import java.nio.channels.FileChannel;
 * the Apache License, Version 2.0 (the "License"); you may
        long minTranslogGeneration
 * not use this file except in compliance with the License.
    @Override
    }
            + "] is higher than generation ["
        final long minSeqNo = in.readLong();
            assert indexOutput.getFilePointer() == V4_FILE_SIZE : "get you numbers straight; bytes written: "
                // don't clone
        final long trimmedAboveSeqNo = in.readLong();
            }
            fileChannel.force(false);
    }
 * this work for additional information regarding copyright
    final long offset;
            + '}';
        ) {
        final long globalCheckpoint = in.readLong();
                byteOutputStream,
        return minTranslogGeneration;
    /**
                assert indexInput.length() == V4_FILE_SIZE : indexInput.length();
        + Long.BYTES // minimum sequence number
            } catch (CorruptIndexException | NoSuchFileException | IndexFormatTooOldException | IndexFormatTooNewException e) {
        try (FileChannel channel = factory.open(checkpointFile, options)) {
        result = 31 * result + Long.hashCode(trimmedAboveSeqNo);
        final long trimmedAboveSeqNo = SequenceNumbers.UNASSIGNED_SEQ_NO;
        assert trimmedAboveSeqNo <= maxSeqNo : "trimmedAboveSeqNo [" + trimmedAboveSeqNo + "] is higher than maxSeqNo [" + maxSeqNo + "]";
        long minTranslogGeneration,
 * Modifications Copyright OpenSearch Contributors. See
            Channels.writeToChannel(bytes, channel);
     * @param generation            the current translog generation
        final long maxSeqNo = in.readLong();
        if (minSeqNo != that.minSeqNo) return false;
import java.nio.file.OpenOption;
                + indexOutput.getFilePointer()
            CodecUtil.writeHeader(indexOutput, CHECKPOINT_CODEC, CURRENT_VERSION);
            channel.force(true);
 * software distributed under the License is distributed on an
    }
        return trimmedAboveSeqNo == that.trimmedAboveSeqNo;
     */
    public static byte[] createCheckpointBytes(Path checkpointFile, Checkpoint checkpoint) throws IOException {
    }
import org.apache.lucene.backward_codecs.store.EndiannessReverserUtil;
import org.apache.lucene.store.IndexInput;
            // no need to force metadata, file size stays the same and we did the full fsync
    static Checkpoint emptyTranslogCheckpoint(
            + minTranslogGeneration
     * Returns the maximum sequence number of operations in this checkpoint after applying {@link #trimmedAboveSeqNo}.
            }
        final ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream(V4_FILE_SIZE) {
            + maxSeqNo
        final int numOps = in.readInt();
 * KIND, either express or implied.  See the License for the
/*
    }
import java.nio.file.NoSuchFileException;
        assert minTranslogGeneration <= generation : "minTranslogGen ["
import org.opensearch.index.seqno.SequenceNumbers;
     * Create a new translog checkpoint.
        final long generation,
        final long generation = in.readLong();
            + trimmedAboveSeqNo
import org.apache.lucene.index.IndexFormatTooOldException;
    final long minSeqNo;
 * under the License.
    static Checkpoint readCheckpointV3(final DataInput in) throws IOException {
        out.writeLong(minSeqNo);
        this.minTranslogGeneration = minTranslogGeneration;
                return fileVersion == CURRENT_VERSION ? Checkpoint.readCheckpointV4(indexInput) : Checkpoint.readCheckpointV3(indexInput);
        + Long.BYTES // maximum reachable (trimmed) sequence number
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
        int result = Long.hashCode(offset);
            // force fsync with metadata since this is used on file creation
        return readCheckpointV4(EndiannessReverserUtil.wrapDataInput(in));
            assert indexOutput.getFilePointer() < 512 : "checkpoint files have to be smaller than 512 bytes for atomic writes; size: "
            + ", minTranslogGeneration="
            + generation
import org.apache.lucene.codecs.CodecUtil;
        this.offset = offset;
 * Unless required by applicable law or agreed to in writing,
 *
            OutputStreamIndexOutput indexOutput = new OutputStreamIndexOutput(
    final int numOps;
        result = 31 * result + Long.hashCode(maxSeqNo);
        return new Checkpoint(offset, numOps, generation, minSeqNo, maxSeqNo, globalCheckpoint, minTranslogGeneration, trimmedAboveSeqNo);
            checkpoint.write(indexOutput);
            try (IndexInput indexInput = dir.openInput(path.getFileName().toString(), IOContext.READONCE)) {
import org.apache.lucene.store.Directory;
            + "offset="
        // now go and write to the channel, in one go.
        return generation;
 * this file be licensed under the Apache-2.0 license or a
    public static void write(ChannelFactory factory, Path checkpointFile, Checkpoint checkpoint, OpenOption... options) throws IOException {
import java.io.IOException;
        result = 31 * result + Long.hashCode(globalCheckpoint);
        if (generation != that.generation) return false;
                checkpointFile.toString(),
    ) {
/**
 *    http://www.apache.org/licenses/LICENSE-2.0
            + globalCheckpoint
        return byteOutputStream.toByteArray();
     *
        if (trimmedAboveSeqNo == SequenceNumbers.UNASSIGNED_SEQ_NO) {
        out.writeLong(maxSeqNo);
 */
        out.writeLong(minTranslogGeneration);
 * license agreements. See the NOTICE file distributed with
            + ", generation="
        this.minSeqNo = minSeqNo;
                + V4_FILE_SIZE;
        result = 31 * result + Long.hashCode(minSeqNo);
            CodecUtil.writeFooter(indexOutput);
        final long offset = in.readLong();
        this.maxSeqNo = maxSeqNo;
            @Override
