        try {
        while ((op = snapshot.next()) != null) {  
     * See {@link TestTranslog#corruptFile(Logger, Random, Path, boolean)} for details of the corruption applied.
     * Returns the primary term associated with the current translog writer of the given translog.  
                    logger.info(  
     */
/*  
                        newTranslogGeneration,
                    );
                    final String filename = item.getFileName().toString();
                    assertThat(fileChannel.position(), equalTo(corruptPosition));  
        @Override  
     * surfaces as a per-operation checksum failure when the operation is read.
            failRate = 0;
                    fileChannel.write(bb);  
                }
import static org.opensearch.index.translog.Translog.CHECKPOINT_FILE_NAME;
    }  
            this.sleepSeconds = sleepSeconds;
            Checkpoint checkpoint = new Checkpoint(offset, 1, generation, 0, 0, 0, generation, SequenceNumbers.NO_OPS_PERFORMED);  
                        checkpoint.numOps + random.nextInt(2),  
     */
        };  
        }
        }  
            crc.update(Files.readAllBytes(translogPath), 0, Math.toIntExact(offset));
            return;
    public static void corruptRandomTranslogFile(Logger logger, Random random, Path translogDir) throws IOException {  
        return translog.getCurrent().getPrimaryTerm();  
     * Corrupts random translog file (translog-N.tlog or translog-N.ckp or translog.ckp) from the given translog directory, or writes a
                }
                        checkpoint.offset + random.nextInt(2),
import java.nio.file.Files;
import static org.hamcrest.Matchers.empty;
                        "corruptFile: corrupting file {} at position {} turning 0x{} into 0x{}",
 * license agreements. See the NOTICE file distributed with
                        newTrimmedAboveSeqNo  
                operations.sort(Comparator.comparing(Translog.Operation::seqNo));
    }
    private static Checkpoint readCheckpointOfGeneration(Path translogDir, Path translogPath) throws IOException {  
                    return;  
 * this file be licensed under the Apache-2.0 license or a
            final Checkpoint checkpoint = Checkpoint.read(checkpointPath);  
    /**
        Checkpoint checkpoint = Checkpoint.read(checkpointPath);  
        Path unnecessaryCheckpointCopyPath = null;  
        Set<Path> candidates = new TreeSet<>(); // TreeSet makes sure iteration order is deterministic
import java.nio.channels.FileChannel;  
 * You may obtain a copy of the License at  
    private static final Pattern TRANSLOG_FILE_PATTERN = Pattern.compile("^translog-(\\d+)\\.(tlog|ckp)$");
            return snapshot.totalOperations();
            TranslogHeader header = new TranslogHeader(UUIDs.randomBase64UUID(random), 1);  
import java.util.TreeSet;
    public static long createTranslogGeneration(Random random, Path location, long generation, boolean withFooter) throws IOException {
                        Integer.toHexString(oldValue & 0xff),
import org.opensearch.index.seqno.SequenceNumbers;  
        }  
package org.opensearch.index.translog;
        private volatile int failRate;
 * compatible open source license.
            if (fail && onceFailedFailAlways) {
     *
        Translog.Operation op;
                final Checkpoint checkpointCopy;  
    /**
                    checkpointCopy,  
            onceFailedFailAlways = true;  
        } catch (TranslogCorruptedException e) {  
     * See {@link TestTranslog#corruptFile(Logger, Random, Path, boolean)} for details of the corruption applied.
                if (checkpointCopy.equals(checkpoint) == false) {
                        checkpoint
                    return null;
        @Override  
                do {  
import java.util.Comparator;  
    static void corruptRandomTranslogFile(Logger logger, Random random, Path translogDir, long minGeneration) throws IOException {  
        }  
            }  
            }
     * translogs and checkpoints with generations below the generation recorded in the latest index commit found in translogDir/../index/,  
            return sleepSeconds;  
import org.opensearch.test.OpenSearchTestCase;
        Checkpoint checkpoint = readCheckpointOfGeneration(translogDir, victim);
                if (checkpoint != null && checkpoint.numOps > 0) {
        public void failRate(int rate) {
        private final Translog.Snapshot snapshot;
                    long newMinTranslogGeneration = Math.min(newTranslogGeneration, checkpoint.minTranslogGeneration + random.nextInt(2));
        Path victim = RandomPicks.randomFrom(random, nonEmpty);  
            if (operations.isEmpty()) {  
     * Corrupt an (existing and nonempty) file by replacing any byte in the file with a random (different) byte, or by truncating the file  
     * {@link TranslogFooter}) and its numbered checkpoint file at {@code location}, laid out exactly as  
            channel.write(one, position);
 * ownership. Elasticsearch licenses this file to you under  
                    logger.info(
                    long newTrimmedAboveSeqNo = Math.min(newMaxSeqNo, checkpoint.trimmedAboveSeqNo + random.nextInt(2));
            final int version = TranslogHeader.readHeaderVersion(corruptedFile, channel, in);
 * specific language governing permissions and limitations
     */
        }  
import java.util.zip.CRC32;
        }  
                    ByteBuffer bb = ByteBuffer.wrap(new byte[1]);
            return location.compareTo(o.location);
            this.snapshot = snapshot;  
        public void close() throws IOException {
                if (iterator.hasNext()) {
            Checkpoint.write(FileChannel::open, checkpointPath, checkpoint, StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW);
        }
 * GitHub history for details.
            unnecessaryCheckpointCopyPath = translogDir.resolve(Translog.getCommitCheckpointFileName(checkpoint.generation));
        return new Translog.Snapshot() {
 *     http://www.apache.org/licenses/LICENSE-2.0
        corruptRandomTranslogFile(logger, random, translogDir, Translog.readCheckpoint(translogDir).minTranslogGeneration);
            }  
        }  
            return fail;
        if (Files.exists(checkpointPath) == false) {  
        return ops;  
        Path translogPath = location.resolve(Translog.getFilename(generation));
    }
     * returns the corrupted translog file. The operation's size prefix, the numbered checkpoint and any
                logger.info("corruptFile: truncating file {} from length {} to length {}", fileToCorrupt, fileSize, corruptPosition);
        final Translog.Operation operation;
                TranslogFooter.write(channel, contentChecksum, true);
        Path checkpointPath = translogDir.resolve(Translog.getCommitCheckpointFileName(generation));
    }
            }
     * Flips one byte inside the body of the last operation of a randomly chosen generation that holds operations, and
    }
                // have not yet written a new `translog.ckp`. During recovery we must also verify that this file is intact, so it's ok to
                    // read
            if (withFooter) {  
 * Helpers for testing translog.
            failRate = OpenSearchTestCase.randomIntBetween(1, 100);
        try (FileChannel fileChannel = FileChannel.open(fileToCorrupt, StandardOpenOption.READ, StandardOpenOption.WRITE)) {
    public static long getCurrentTerm(Translog translog) {
        }
        public int compareTo(LocationOperation o) {
import java.nio.ByteBuffer;
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(translogDir, "translog-*" + TRANSLOG_FILE_SUFFIX)) {
    public static Translog.Snapshot newSnapshotFromOperations(List<Translog.Operation> operations) {  
     * Reads the checkpoint describing {@code translogPath}: its numbered checkpoint for a closed generation, or
    static void corruptFile(Logger logger, Random random, Path fileToCorrupt, boolean maybeDelete) throws IOException {  
 * KIND, either express or implied.  See the License for the
/*  
        public int getSleepSeconds() {
        final Path fileToCorrupt = RandomPicks.randomFrom(random, candidates);  
            long contentChecksum = crc.getValue();
                    }  
        } catch (IllegalStateException | TranslogCorruptedException | IOException e) {
}
            final int rnd = OpenSearchTestCase.randomIntBetween(1, 100);
import java.util.Set;
        }
        try (FileChannel channel = FileChannel.open(victim, StandardOpenOption.READ, StandardOpenOption.WRITE)) {
        if (maybeDelete && random.nextBoolean() && random.nextBoolean()) {
        @Override  
                        candidates.add(item);
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.MatcherAssert.assertThat;  
                } else {  
                        fileToCorrupt,  
     */  
        long generation = Translog.parseIdFromFileName(translogPath);
    /**
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
import java.io.IOException;  
                    );
     * checksum, i.e. the CRC32 over {@code [0, checkpoint.offset)} that the footer carries.
 */
        }  
                    operations.add(op);
     * Writes a closed translog generation (header + a few operation bytes, optionally followed by a
                    StandardOpenOption.CREATE_NEW
        public void onceFailedFailAlways() {
        assertThat(fileToCorrupt + " should not be an empty file", fileSize, greaterThan(0L));  
                    fileChannel.read(bb);
                        unnecessaryCheckpointCopyPath,
                    return iterator.next();
            ops.sort(Comparator.comparing(Translog.Operation::seqNo));
                        newMinTranslogGeneration,
 * the Apache License, Version 2.0 (the "License"); you may
        try (FileChannel channel = FileChannel.open(translogPath, StandardOpenOption.WRITE)) {
 */  
        private volatile boolean onceFailedFailAlways = false;
        public boolean fail() {
            random.nextBytes(operationBytes);  
                    if (filename.equals("translog.ckp") || (matcher.matches() && Long.parseLong(matcher.group(1)) >= minGeneration)) {
import org.opensearch.common.util.io.IOUtils;
                failAlways();
                        newMaxSeqNo,  
            byte[] operationBytes = new byte[RandomNumbers.randomIntBetween(random, 4, 64)];
 * under the License.  
            header.write(channel, true);
 * Licensed to Elasticsearch under one or more contributor  
        }  
     * Corrupts random translog file (translog-N.tlog or translog-N.ckp or translog.ckp) from the given translog directory, ignoring
        SortedSnapshot(Translog.Snapshot snapshot) {
                Translog.Operation op;  
import java.util.regex.Pattern;
        logger.info("--> corruptRandomTranslogFile: translogDir [{}], minUsedTranslogGen [{}]", translogDir, minGeneration);
        final List<Translog.Operation> ops = new ArrayList<>(snapshot.totalOperations());
     * <p>
                if (Files.isRegularFile(item) && Files.size(item) > 0) {
            long offset = channel.position();
                    bb.put(0, newValue);
            this.operation = operation;
            channel.write(ByteBuffer.wrap(operationBytes));
        }
                    );
            }
                    byte newValue;
        }
            if (operations == null) {
            public void close() {  
                        newValue = (byte) random.nextInt(0x100);  
    }
        final long fileSize = Files.size(fileToCorrupt);
            return false;  
        List<Path> nonEmpty = new ArrayList<>();
        }  
        assertThat("no corruption candidates found in " + translogDir, candidates, is(not(empty())));
 */  
    }
        Files.createFile(translogPath);
import java.nio.file.DirectoryStream;
                    } while (newValue == oldValue);
    static class LocationOperation implements Comparable<LocationOperation> {  
    public static List<Translog.Operation> drainSnapshot(Translog.Snapshot snapshot, boolean sortBySeqNo) throws IOException {  
            } else {
 *  
                fileChannel.truncate(corruptPosition);  
        try {
                    long newMaxSeqNo = checkpoint.maxSeqNo + random.nextInt(2);  
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
            final long corruptPosition = RandomNumbers.randomLongBetween(random, 0, fileSize - 1);  
import static org.hamcrest.core.IsNot.not;
                    final Matcher matcher = TRANSLOG_FILE_PATTERN.matcher(filename);  
        }
                return null;  
     * {@link TranslogWriter#closeIntoReader()} leaves them for a remote-enabled translog. Returns the content
 * software distributed under the License is distributed on an
    public static Path corruptLastOperationOfRandomGeneration(Random random, Path translogDir) throws IOException {  
                    checkpointCopy = checkpoint;
     * or writes a corrupted translog-N.ckp file as if from a crash while rolling a generation.
            IOUtils.rm(fileToCorrupt);
            boolean fail = rnd <= failRate;  
        }
            CRC32 crc = new CRC32();  
                return operations.size();
                        newMinSeqNo,
            public Translog.Operation next() {  
                } else {  
            channel.read(one, position);  
                // corrupt this file too (either by writing the wrong information, correctly formatted, or by properly corrupting it)
        }
                if (LuceneTestCase.usually(random)) {
                Checkpoint.write(  
            if (LuceneTestCase.rarely(random) && Files.exists(unnecessaryCheckpointCopyPath) == false) {
                    do {
                    unnecessaryCheckpointCopyPath,
    /**
 * Modifications Copyright OpenSearch Contributors. See
            one.clear();  
        channel.position(0);
        assertThat("expected at least one generation with operations in " + translogDir, nonEmpty, not(empty()));
            for (Path translogPath : stream) {  
    static class FailSwitch {  
    /**  
                    long newTranslogGeneration = checkpoint.generation + random.nextInt(2);
 * this work for additional information regarding copyright
        final Iterator<Translog.Operation> iterator = operations.iterator();
            return operations.remove(0);  
            for (Path item : stream) {  
 */  
            one.put((byte) (original ^ 0x1)).flip();
                        corruptPosition,
            }  
     * to a random (strictly shorter) length, or by deleting the file.
        return victim;
 * The OpenSearch Contributors require contributions made to  
        @Override
public class TestTranslog {
        long position = checkpoint.offset - 6;  
     * {@link TranslogFooter} are left intact, so the generation still passes every structural check and the rot only  
            if (random.nextBoolean()) {
        final InputStreamStreamInput in = new InputStreamStreamInput(Channels.newInputStream(channel), channel.size());  
            @Override  
 *
 * not use this file except in compliance with the License.
        }
    /**
            return false;
                } while (isTranslogHeaderVersionFlipped(fileToCorrupt, fileChannel));
        private volatile int sleepSeconds;
import static org.opensearch.index.translog.Translog.TRANSLOG_FILE_SUFFIX;
            }
            ops.add(op);
import java.util.List;
/**
    }  
            if (Files.exists(checkpointPath) == false) {
                    byte oldValue = bb.get(0);  
                    fileChannel.position(corruptPosition);
            @Override
     * <p>  
        return checkpoint.generation == generation ? checkpoint : null;
/*
        if (corruptedFile.toString().endsWith(TRANSLOG_FILE_SUFFIX) == false) {
                        "corruptRandomTranslogFile: created [{}] containing [{}] instead of [{}]",
                        checkpoint.globalCheckpoint + random.nextInt(2),
        // The last operation ends at checkpoint.offset with its 4-byte checksum; six bytes back is inside its body.
        public void failAlways() {
            return contentChecksum;
        private List<Translog.Operation> operations = null;  
        final boolean maybeDelete = fileToCorrupt.equals(unnecessaryCheckpointCopyPath) == false;  
        }  
                        checkpointCopy,  
import org.apache.lucene.tests.util.LuceneTestCase;
                }
import org.opensearch.common.UUIDs;  
import java.util.Random;  
        public void failRandomly() {  
                    StandardOpenOption.WRITE,
        public void failNever() {
                    // corrupt
     *  
        // deleting the unnecessary checkpoint file doesn't count as a corruption
        }
        }  
        }
import static org.hamcrest.core.Is.is;
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(translogDir)) {
 *
import static org.hamcrest.Matchers.equalTo;
        }
        Path checkpointPath = location.resolve(Translog.getCommitCheckpointFileName(generation));  
import static org.hamcrest.Matchers.greaterThan;  
            }
                    checkpointCopy = new Checkpoint(
        public int totalOperations() {
import org.opensearch.core.common.io.stream.InputStreamStreamInput;
                    // rewrite
    }
     */
     * An old translog header does not have a checksum. If we flip the header version of an empty translog from 3 to 2,
                while ((op = snapshot.next()) != null) {
            ByteBuffer one = ByteBuffer.allocate(1);
            snapshot.close();
                        Integer.toHexString(newValue & 0xff)  
                operations = new ArrayList<>();
            public int totalOperations() {
                    long newMinSeqNo = Math.min(newMaxSeqNo, checkpoint.minSeqNo + random.nextInt(2));
    static boolean isTranslogHeaderVersionFlipped(Path corruptedFile, FileChannel channel) throws IOException {
     */  
            this.location = location;  
    /**
            // missing or corrupt checkpoint already, find something else to break...
            logger.info("corruptFile: deleting file {}", fileToCorrupt);  
    }
            }
        final Translog.Location location;
        public Translog.Operation next() throws IOException {  
            failRate = 100;  
                return null;
    }
                    bb.flip();  
    }
import org.apache.logging.log4j.Logger;
        }  
            byte original = one.get();
    static class SortedSnapshot implements Translog.Snapshot {
                }  
            checkpointPath = translogDir.resolve(CHECKPOINT_FILE_NAME);
            final Path checkpointPath = translogDir.resolve(CHECKPOINT_FILE_NAME);
     */
     * @param minGeneration the minimum generation (N) to corrupt. Translogs and checkpoints with lower generation numbers are ignored.
     */
                Checkpoint checkpoint = readCheckpointOfGeneration(translogDir, translogPath);
     * {@code null} if neither describes this generation.
import java.nio.channels.Channels;
import java.nio.file.Path;  
                );  
     * corrupted translog-N.ckp file as if from a crash while rolling a generation.  
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;  
        if (sortBySeqNo) {  
                    FileChannel::open,
        corruptFile(logger, random, fileToCorrupt, maybeDelete);
        LocationOperation(Translog.Operation operation, Translog.Location location) {
            failRate = rate;
            }
                }
                    nonEmpty.add(translogPath);  
            one.flip();
     * then we won't detect that corruption, and the translog will be considered clean as before.
    }
     * {@code translog.ckp} for the current writer's generation, which has no numbered checkpoint yet. Returns  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**  
        nonEmpty.sort(Comparator.naturalOrder());
            }
                // if we crashed while rolling a generation then we might have copied `translog.ckp` to its numbered generation file but  
 * Unless required by applicable law or agreed to in writing,
    static class SlowDownWriteSwitch {
            @Override
            return version == TranslogHeader.VERSION_CHECKPOINTS;  
        }
        public void setSleepSeconds(int sleepSeconds) {
import java.nio.file.StandardOpenOption;
                } // else checkpoint copy has the correct content so it's now a candidate for the usual kinds of corruption
    }
        assertThat(fileToCorrupt + " should be a regular file", Files.isRegularFile(fileToCorrupt));
            }
                    fileChannel.position(corruptPosition);
