        final long minSeqNo = in.readLong();  
    }
 * this file be licensed under the Apache-2.0 license or a
            }
            + globalCheckpoint
                + indexOutput.getFilePointer()
            Channels.writeToChannel(bytes, channel);
    /**
    }  
        + Long.BYTES // generation  
        + Long.BYTES // maximum reachable (trimmed) sequence number
    @Override
            + ", numOps="
        + Long.BYTES // maximum sequence number
 */  
        final long maxSeqNo = in.readLong();
public final class Checkpoint {  
import java.nio.file.NoSuchFileException;
            return Math.min(trimmedAboveSeqNo, maxSeqNo);  
        final String resourceDesc = "checkpoint(path=\"" + checkpointFile + "\", gen=" + checkpoint + ")";
 * Licensed to Elasticsearch under one or more contributor  
        if (globalCheckpoint != that.globalCheckpoint) return false;  
        return new Checkpoint(offset, 0, generation, minSeqNo, maxSeqNo, globalCheckpoint, minTranslogGeneration, trimmedAboveSeqNo);
import org.opensearch.index.seqno.SequenceNumbers;  
     *
    static Checkpoint readCheckpointV4(final DataInput in) throws IOException {
 *
        this.minTranslogGeneration = minTranslogGeneration;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
@PublicApi(since = "1.0.0")
    final long trimmedAboveSeqNo;  
        result = 31 * result + Long.hashCode(generation);
        if (maxSeqNo != that.maxSeqNo) return false;
        result = 31 * result + Long.hashCode(trimmedAboveSeqNo);  
        if (fsync == true) {
    final long minSeqNo;
        result = 31 * result + Long.hashCode(globalCheckpoint);
        + Long.BYTES // offset
            + maxSeqNo
    private void write(DataOutput out) throws IOException {  
    private static final String CHECKPOINT_CODEC = "ckp";
            + minTranslogGeneration
        // now go and write to the channel, in one go.  
    }
                throw new TranslogCorruptedException(path.toString(), e);
     * @param minTranslogGeneration the minimum generation referenced by the translog at this moment.
import org.apache.lucene.codecs.CodecUtil;
        Channels.writeToChannel(bytes, fileChannel, 0);
        return "Checkpoint{"
    public static void write(FileChannel fileChannel, Path checkpointFile, Checkpoint checkpoint, boolean fsync) throws IOException {
     *                              corresponding translog file. {@link SequenceNumbers#UNASSIGNED_SEQ_NO} is used to disable trimming.
    final long generation;
        + Long.BYTES // minimum translog generation in the translog
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
        final long globalCheckpoint,
        long offset,
        return readCheckpointV4(EndiannessReverserUtil.wrapDataInput(in));
            // no need to force metadata, file size stays the same and we did the full fsync  
            // force fsync with metadata since this is used on file creation  
     * Returns the maximum sequence number of operations in this checkpoint after applying {@link #trimmedAboveSeqNo}.  
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
/*
            // when we first created the file, so the directory entry doesn't change as well
        final long minTranslogGeneration = in.readLong();  
                + V4_FILE_SIZE;  
        assert minTranslogGeneration <= generation : "minTranslogGen ["  
            + ", globalCheckpoint="  
 * GitHub history for details.
            + ", minSeqNo="
            + "offset="
    ) {  
                // We checksum the entire file before we even go and parse it. If it's corrupted we barf right here.  
        return result;
import org.opensearch.common.io.Channels;
        return byteOutputStream.toByteArray();
    }
     * @param minSeqNo              the current minimum sequence number of all operations in the translog
        }
            return maxSeqNo;
 *
    }  
        long generation,  
            try (IndexInput indexInput = dir.openInput(path.getFileName().toString(), IOContext.READONCE)) {
 * KIND, either express or implied.  See the License for the
    public long getGeneration() {
     * @param offset                the current offset in the translog
        final long generation = in.readLong();
 * specific language governing permissions and limitations
/*  
        if (o == null || getClass() != o.getClass()) return false;  
        this.numOps = numOps;  
 */
    }  
package org.opensearch.index.translog;
    public String toString() {  
        Checkpoint that = (Checkpoint) o;
        + Long.BYTES // global checkpoint  
    public int hashCode() {
            + ", trimmedAboveSeqNo="
import org.apache.lucene.store.IndexInput;
 * You may obtain a copy of the License at  
                assert indexInput.length() == V4_FILE_SIZE : indexInput.length();
import org.apache.lucene.store.Directory;
        out.writeLong(globalCheckpoint);  
    static final int V4_FILE_SIZE = CodecUtil.headerLength(CHECKPOINT_CODEC) + Integer.BYTES  // ops
        ) {
    }
        return trimmedAboveSeqNo == that.trimmedAboveSeqNo;
        result = 31 * result + Long.hashCode(minSeqNo);  
        + CodecUtil.footerLength();  
                + ", buffer size: "
        this.generation = generation;
        final long trimmedAboveSeqNo = in.readLong();
        if (numOps != that.numOps) return false;
        this.offset = offset;
import org.apache.lucene.backward_codecs.store.EndiannessReverserUtil;
            + trimmedAboveSeqNo
            + ", generation="  
        final long offset = in.readLong();  
            + offset  
        out.writeLong(maxSeqNo);
}
            + minTranslogGeneration  
 */  
        this.trimmedAboveSeqNo = trimmedAboveSeqNo;  
        final int numOps = in.readInt();
        long maxSeqNo,
    private static final int CURRENT_VERSION = 4; // introduction of trimmed above seq#  
import org.apache.lucene.store.DataOutput;
                final int fileVersion = CodecUtil.checkHeader(indexInput, CHECKPOINT_CODEC, VERSION_LUCENE_BIG_ENDIAN, CURRENT_VERSION);
    public static byte[] createCheckpointBytes(Path checkpointFile, Checkpoint checkpoint) throws IOException {  
    static Checkpoint emptyTranslogCheckpoint(
import java.nio.channels.FileChannel;
     * @param generation            the current translog generation
        final long globalCheckpoint = in.readLong();
 */
        out.writeLong(minSeqNo);
            CodecUtil.writeFooter(indexOutput);
    }
            OutputStreamIndexOutput indexOutput = new OutputStreamIndexOutput(
                byteOutputStream,
            channel.force(true);
                // don't clone
    final long offset;
        if (this == o) return true;
import org.apache.lucene.store.OutputStreamIndexOutput;  
        final ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream(V4_FILE_SIZE) {
import org.apache.lucene.store.NIOFSDirectory;
     */
            )  
 * this work for additional information regarding copyright
        }  
    static Checkpoint readCheckpointV3(final DataInput in) throws IOException {
        final long offset,
            fileChannel.force(false);
        return generation;  
        }
            checkpoint.write(indexOutput);  
        long minTranslogGeneration,
        final long generation,  
        final long minSeqNo = SequenceNumbers.NO_OPS_PERFORMED;
            assert indexOutput.getFilePointer() == V4_FILE_SIZE : "get you numbers straight; bytes written: "  
import org.opensearch.common.annotation.PublicApi;
        } else {
     * @param globalCheckpoint      the last-known global checkpoint
 * compatible open source license.
    public static void write(ChannelFactory factory, Path checkpointFile, Checkpoint checkpoint, OpenOption... options) throws IOException {  
 * under the License.  
    ) {  
        int result = Long.hashCode(offset);  
    Checkpoint(  
     * @param maxSeqNo              the current maximum sequence number of all operations in the translog  
        out.writeLong(minTranslogGeneration);
            assert indexOutput.getFilePointer() < 512 : "checkpoint files have to be smaller than 512 bytes for atomic writes; size: "
        if (generation != that.generation) return false;  
        int numOps,
                resourceDesc,
            + generation  
        out.writeInt(numOps);
import java.nio.file.Path;
    @Override  
import org.apache.lucene.index.CorruptIndexException;  
        result = 31 * result + numOps;
     * @param numOps                the current number of operations in the translog  
            + ", maxSeqNo="
            CodecUtil.writeHeader(indexOutput, CHECKPOINT_CODEC, CURRENT_VERSION);
        try (  
import org.apache.lucene.index.IndexFormatTooOldException;
            } catch (CorruptIndexException | NoSuchFileException | IndexFormatTooOldException | IndexFormatTooNewException e) {  
    private static final int VERSION_LUCENE_BIG_ENDIAN = 3; // big endian format (Lucene 9+ switches to little endian)
import org.apache.lucene.index.IndexFormatTooNewException;
 * Modifications Copyright OpenSearch Contributors. See
        long minTranslogGeneration
            + ", minTranslogGeneration="
 * not use this file except in compliance with the License.
        if (minSeqNo != that.minSeqNo) return false;
        final long maxSeqNo = SequenceNumbers.NO_OPS_PERFORMED;
        this.globalCheckpoint = globalCheckpoint;
 * A checkpoint for OpenSearch operations
    public boolean equals(Object o) {
            + generation
    @Override
 * software distributed under the License is distributed on an
            + '}';  
        }  
import java.io.ByteArrayOutputStream;
 * @opensearch.api  
        byte[] bytes = createCheckpointBytes(checkpointFile, checkpoint);
        return minTranslogGeneration;
            @Override
/**  
        this.minSeqNo = minSeqNo;
        this.maxSeqNo = maxSeqNo;  
import org.apache.lucene.store.DataInput;  
 *    http://www.apache.org/licenses/LICENSE-2.0
                + indexOutput.getFilePointer();
    final long globalCheckpoint;
        + Long.BYTES // minimum sequence number
        out.writeLong(generation);  
        if (trimmedAboveSeqNo == SequenceNumbers.UNASSIGNED_SEQ_NO) {  
        };
     */
    public long getMinTranslogGeneration() {
    }
            + minSeqNo  
    final long maxSeqNo;  
        assert minSeqNo <= maxSeqNo : "minSeqNo [" + minSeqNo + "] is higher than maxSeqNo [" + maxSeqNo + "]";
            + numOps
                checkpointFile.toString(),  
    long maxEffectiveSeqNo() {
        out.writeLong(trimmedAboveSeqNo);
    }
        long globalCheckpoint,  
    /**
 *  
        result = 31 * result + Long.hashCode(maxSeqNo);
        long minSeqNo,
    public static Checkpoint read(Path path) throws IOException {  
    }
 *
import java.nio.file.OpenOption;  
                return fileVersion == CURRENT_VERSION ? Checkpoint.readCheckpointV4(indexInput) : Checkpoint.readCheckpointV3(indexInput);
     * Create a new translog checkpoint.  
        assert trimmedAboveSeqNo <= maxSeqNo : "trimmedAboveSeqNo [" + trimmedAboveSeqNo + "] is higher than maxSeqNo [" + maxSeqNo + "]";
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;  
            + "] is higher than generation ["
        final long trimmedAboveSeqNo = SequenceNumbers.UNASSIGNED_SEQ_NO;  
import org.apache.lucene.store.IOContext;  
            + "]";
                CodecUtil.checksumEntireFile(indexInput);
    }  
    final int numOps;  
        }  
                assert fileVersion == CURRENT_VERSION || fileVersion == VERSION_LUCENE_BIG_ENDIAN : fileVersion;  
    final long minTranslogGeneration;
        return new Checkpoint(offset, numOps, generation, minSeqNo, maxSeqNo, globalCheckpoint, minTranslogGeneration, trimmedAboveSeqNo);
/*  
     * @param trimmedAboveSeqNo     all operations with seq# above trimmedAboveSeqNo should be ignored and not read from the  
        try (Directory dir = new NIOFSDirectory(path.getParent())) {
        byte[] bytes = createCheckpointBytes(checkpointFile, checkpoint);  
                V4_FILE_SIZE
    }
        out.writeLong(offset);
            }  
            public synchronized byte[] toByteArray() {  
                return buf;
    }  
        if (offset != that.offset) return false;
    }
        long trimmedAboveSeqNo
        try (FileChannel channel = factory.open(checkpointFile, options)) {
