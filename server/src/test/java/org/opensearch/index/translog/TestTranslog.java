            CRC32 crc = new CRC32();
import java.util.regex.Pattern;
            one.clear();
        }
import java.util.Set;
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
     *
 * this file be licensed under the Apache-2.0 license or a
            return sleepSeconds;
    static class SlowDownWriteSwitch {
            if (Files.exists(checkpointPath) == false) {
                    // rewrite
            long contentChecksum = crc.getValue();
            boolean fail = rnd <= failRate;
        LocationOperation(Translog.Operation operation, Translog.Location location) {
        Translog.Operation op;
     * {@code null} if neither describes this generation.
     * Flips one byte inside the body of the last operation of a randomly chosen generation that holds operations, and
            }
            failRate = rate;
 *
        }
import java.util.Iterator;
     *
        Path checkpointPath = translogDir.resolve(Translog.getCommitCheckpointFileName(generation));
        final Translog.Operation operation;
                }
     * Writes a closed translog generation (header + a few operation bytes, optionally followed by a
        @Override
                // have not yet written a new `translog.ckp`. During recovery we must also verify that this file is intact, so it's ok to
        corruptRandomTranslogFile(logger, random, translogDir, Translog.readCheckpoint(translogDir).minTranslogGeneration);
        }
     */
     * Corrupts random translog file (translog-N.tlog or translog-N.ckp or translog.ckp) from the given translog directory, ignoring
                    fileChannel.position(corruptPosition);
 *     http://www.apache.org/licenses/LICENSE-2.0
    static class SortedSnapshot implements Translog.Snapshot {
            this.operation = operation;
    /**
        return ops;
        try (FileChannel fileChannel = FileChannel.open(fileToCorrupt, StandardOpenOption.READ, StandardOpenOption.WRITE)) {
        }
            public void close() {
                    operations.add(op);
            return contentChecksum;
                logger.info("corruptFile: truncating file {} from length {} to length {}", fileToCorrupt, fileSize, corruptPosition);
import java.nio.file.DirectoryStream;
        }
            public int totalOperations() {
     */
        assertThat(fileToCorrupt + " should be a regular file", Files.isRegularFile(fileToCorrupt));
    /**
        public int totalOperations() {
            final Path checkpointPath = translogDir.resolve(CHECKPOINT_FILE_NAME);
import static org.hamcrest.core.Is.is;
    }
     * {@link TranslogFooter} are left intact, so the generation still passes every structural check and the rot only
     */
     */
     * corrupted translog-N.ckp file as if from a crash while rolling a generation.
            }
     * An old translog header does not have a checksum. If we flip the header version of an empty translog from 3 to 2,
                );
/*
    public static Translog.Snapshot newSnapshotFromOperations(List<Translog.Operation> operations) {
                        checkpoint
                    return;
                    StandardOpenOption.WRITE,
            }
                        checkpoint.globalCheckpoint + random.nextInt(2),
                        newMinTranslogGeneration,
     * Corrupts random translog file (translog-N.tlog or translog-N.ckp or translog.ckp) from the given translog directory, or writes a
                    assertThat(fileChannel.position(), equalTo(corruptPosition));
            crc.update(Files.readAllBytes(translogPath), 0, Math.toIntExact(offset));
                        checkpoint.offset + random.nextInt(2),
        return translog.getCurrent().getPrimaryTerm();
                    StandardOpenOption.CREATE_NEW
                    return iterator.next();
        Path victim = RandomPicks.randomFrom(random, nonEmpty);
import static org.hamcrest.MatcherAssert.assertThat;
            }
            one.flip();
        }
        if (maybeDelete && random.nextBoolean() && random.nextBoolean()) {
        // The last operation ends at checkpoint.offset with its 4-byte checksum; six bytes back is inside its body.
        public void setSleepSeconds(int sleepSeconds) {
                        candidates.add(item);
            if (fail && onceFailedFailAlways) {
     * <p>
        }
        }
                if (iterator.hasNext()) {
            ByteBuffer one = ByteBuffer.allocate(1);
        final List<Translog.Operation> ops = new ArrayList<>(snapshot.totalOperations());
                Checkpoint checkpoint = readCheckpointOfGeneration(translogDir, translogPath);
                        corruptPosition,
                    long newTranslogGeneration = checkpoint.generation + random.nextInt(2);
                operations.sort(Comparator.comparing(Translog.Operation::seqNo));
                        newMinSeqNo,
        }
 * You may obtain a copy of the License at
     * See {@link TestTranslog#corruptFile(Logger, Random, Path, boolean)} for details of the corruption applied.
        Path checkpointPath = location.resolve(Translog.getCommitCheckpointFileName(generation));
        SortedSnapshot(Translog.Snapshot snapshot) {
                } // else checkpoint copy has the correct content so it's now a candidate for the usual kinds of corruption
import static org.opensearch.index.translog.Translog.CHECKPOINT_FILE_NAME;
                }
     * Reads the checkpoint describing {@code translogPath}: its numbered checkpoint for a closed generation, or
import java.util.TreeSet;
import java.nio.channels.Channels;
            }
                // if we crashed while rolling a generation then we might have copied `translog.ckp` to its numbered generation file but
import org.opensearch.core.common.io.stream.InputStreamStreamInput;
            random.nextBytes(operationBytes);
                }
            public Translog.Operation next() {
        private volatile boolean onceFailedFailAlways = false;
        Checkpoint checkpoint = Checkpoint.read(checkpointPath);
                        Integer.toHexString(newValue & 0xff)
                if (LuceneTestCase.usually(random)) {
        }
     * {@link TranslogFooter}) and its numbered checkpoint file at {@code location}, laid out exactly as
import java.nio.ByteBuffer;
import org.apache.logging.log4j.Logger;
        final InputStreamStreamInput in = new InputStreamStreamInput(Channels.newInputStream(channel), channel.size());
            return false;
        private volatile int failRate;
     * {@link TranslogWriter#closeIntoReader()} leaves them for a remote-enabled translog. Returns the content
            snapshot.close();
/**
            return version == TranslogHeader.VERSION_CHECKPOINTS;
/*
 */
            byte[] operationBytes = new byte[RandomNumbers.randomIntBetween(random, 4, 64)];
                    byte newValue;
        logger.info("--> corruptRandomTranslogFile: translogDir [{}], minUsedTranslogGen [{}]", translogDir, minGeneration);
        public int getSleepSeconds() {
import org.opensearch.test.OpenSearchTestCase;
     * checksum, i.e. the CRC32 over {@code [0, checkpoint.offset)} that the footer carries.
        private volatile int sleepSeconds;
                        unnecessaryCheckpointCopyPath,
    }
     */
        }
    private static final Pattern TRANSLOG_FILE_PATTERN = Pattern.compile("^translog-(\\d+)\\.(tlog|ckp)$");
    static boolean isTranslogHeaderVersionFlipped(Path corruptedFile, FileChannel channel) throws IOException {
            }
    }
import java.util.Random;
    /**
        if (corruptedFile.toString().endsWith(TRANSLOG_FILE_SUFFIX) == false) {
                final Checkpoint checkpointCopy;
        try (FileChannel channel = FileChannel.open(victim, StandardOpenOption.READ, StandardOpenOption.WRITE)) {
     * {@code translog.ckp} for the current writer's generation, which has no numbered checkpoint yet. Returns
                    checkpointCopy,
                    );
            if (withFooter) {
        }
    }
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
                    final String filename = item.getFileName().toString();
import java.util.Comparator;
            }
/*
        return new Translog.Snapshot() {
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * or writes a corrupted translog-N.ckp file as if from a crash while rolling a generation.
        try {
        final boolean maybeDelete = fileToCorrupt.equals(unnecessaryCheckpointCopyPath) == false;
        return victim;
        };
                fileChannel.truncate(corruptPosition);
        if (sortBySeqNo) {
                    do {
    /**
                    logger.info(
        public void failRandomly() {
        try {
import org.opensearch.common.util.io.IOUtils;
    }
        }
                }
                    FileChannel::open,
    /**
import java.nio.file.Path;
                Translog.Operation op;
    }
    public static void corruptRandomTranslogFile(Logger logger, Random random, Path translogDir) throws IOException {
    public static Path corruptLastOperationOfRandomGeneration(Random random, Path translogDir) throws IOException {
import java.util.zip.CRC32;
        Path translogPath = location.resolve(Translog.getFilename(generation));
        }
 */
    /**
        }
     * translogs and checkpoints with generations below the generation recorded in the latest index commit found in translogDir/../index/,
 * Licensed to Elasticsearch under one or more contributor
     */
                    long newMinSeqNo = Math.min(newMaxSeqNo, checkpoint.minSeqNo + random.nextInt(2));
        }
                    // corrupt
            }
                    );
    private static Checkpoint readCheckpointOfGeneration(Path translogDir, Path translogPath) throws IOException {
                        newTrimmedAboveSeqNo
            channel.write(ByteBuffer.wrap(operationBytes));
        while ((op = snapshot.next()) != null) {
        Path unnecessaryCheckpointCopyPath = null;
            for (Path item : stream) {
     * returns the corrupted translog file. The operation's size prefix, the numbered checkpoint and any
import java.io.IOException;
import java.nio.file.StandardOpenOption;
                    long newMinTranslogGeneration = Math.min(newTranslogGeneration, checkpoint.minTranslogGeneration + random.nextInt(2));
    public static List<Translog.Operation> drainSnapshot(Translog.Snapshot snapshot, boolean sortBySeqNo) throws IOException {
    }
        private final Translog.Snapshot snapshot;
            failRate = OpenSearchTestCase.randomIntBetween(1, 100);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(translogDir)) {
 * under the License.
        @Override
     */
    public static long getCurrentTerm(Translog translog) {
                    long newTrimmedAboveSeqNo = Math.min(newMaxSeqNo, checkpoint.trimmedAboveSeqNo + random.nextInt(2));
            @Override
            }
                return null;
import static org.hamcrest.Matchers.empty;
                        fileToCorrupt,
    public static long createTranslogGeneration(Random random, Path location, long generation, boolean withFooter) throws IOException {
 *
            final int version = TranslogHeader.readHeaderVersion(corruptedFile, channel, in);
import org.opensearch.common.UUIDs;
import static org.opensearch.index.translog.Translog.TRANSLOG_FILE_SUFFIX;
        private List<Translog.Operation> operations = null;
                        "corruptFile: corrupting file {} at position {} turning 0x{} into 0x{}",
            Checkpoint.write(FileChannel::open, checkpointPath, checkpoint, StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW);
        }
        public void onceFailedFailAlways() {
        assertThat("expected at least one generation with operations in " + translogDir, nonEmpty, not(empty()));
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(translogDir, "translog-*" + TRANSLOG_FILE_SUFFIX)) {
            checkpointPath = translogDir.resolve(CHECKPOINT_FILE_NAME);
                return operations.size();
    static class FailSwitch {
        Checkpoint checkpoint = readCheckpointOfGeneration(translogDir, victim);
                do {
            if (LuceneTestCase.rarely(random) && Files.exists(unnecessaryCheckpointCopyPath) == false) {
    }
    /**
 * not use this file except in compliance with the License.
        Set<Path> candidates = new TreeSet<>(); // TreeSet makes sure iteration order is deterministic
        if (Files.exists(checkpointPath) == false) {
            @Override
            onceFailedFailAlways = true;
                    // read
                return null;
        // deleting the unnecessary checkpoint file doesn't count as a corruption
            final long corruptPosition = RandomNumbers.randomLongBetween(random, 0, fileSize - 1);
                    bb.flip();
        }
                        Integer.toHexString(oldValue & 0xff),
        @Override
            return snapshot.totalOperations();
                        newTranslogGeneration,
                    unnecessaryCheckpointCopyPath,
                    );
        long generation = Translog.parseIdFromFileName(translogPath);
            return location.compareTo(o.location);
            ops.sort(Comparator.comparing(Translog.Operation::seqNo));
            // missing or corrupt checkpoint already, find something else to break...
package org.opensearch.index.translog;
                operations = new ArrayList<>();
     * Returns the primary term associated with the current translog writer of the given translog.
                    if (filename.equals("translog.ckp") || (matcher.matches() && Long.parseLong(matcher.group(1)) >= minGeneration)) {
 * KIND, either express or implied.  See the License for the
        public Translog.Operation next() throws IOException {
            IOUtils.rm(fileToCorrupt);
                    byte oldValue = bb.get(0);
        channel.position(0);
 * compatible open source license.
            } else {
            if (operations.isEmpty()) {
            return false;
                        checkpointCopy,
        }
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
        public void failAlways() {
        public boolean fail() {
 * The OpenSearch Contributors require contributions made to
                    final Matcher matcher = TRANSLOG_FILE_PATTERN.matcher(filename);
                    }
        corruptFile(logger, random, fileToCorrupt, maybeDelete);
    /**
 * the Apache License, Version 2.0 (the "License"); you may
     * then we won't detect that corruption, and the translog will be considered clean as before.
            this.sleepSeconds = sleepSeconds;
                TranslogFooter.write(channel, contentChecksum, true);
        try (FileChannel channel = FileChannel.open(translogPath, StandardOpenOption.WRITE)) {
            if (random.nextBoolean()) {
 * this work for additional information regarding copyright
     * Corrupt an (existing and nonempty) file by replacing any byte in the file with a random (different) byte, or by truncating the file
        assertThat(fileToCorrupt + " should not be an empty file", fileSize, greaterThan(0L));
                        "corruptRandomTranslogFile: created [{}] containing [{}] instead of [{}]",
    }
        List<Path> nonEmpty = new ArrayList<>();
            failRate = 0;
import java.nio.channels.FileChannel;
            this.snapshot = snapshot;
        nonEmpty.sort(Comparator.naturalOrder());
                    ByteBuffer bb = ByteBuffer.wrap(new byte[1]);
            @Override
            failRate = 100;
                while ((op = snapshot.next()) != null) {
        long position = checkpoint.offset - 6;
            one.put((byte) (original ^ 0x1)).flip();
import static org.hamcrest.Matchers.equalTo;
                    checkpointCopy = new Checkpoint(
    static void corruptFile(Logger logger, Random random, Path fileToCorrupt, boolean maybeDelete) throws IOException {
            return;
                        newValue = (byte) random.nextInt(0x100);
import org.apache.lucene.tests.util.LuceneTestCase;
            byte original = one.get();
                // corrupt this file too (either by writing the wrong information, correctly formatted, or by properly corrupting it)
    static class LocationOperation implements Comparable<LocationOperation> {
        public void failNever() {
            }
        } catch (IllegalStateException | TranslogCorruptedException | IOException e) {
import static org.hamcrest.core.IsNot.not;
import java.util.regex.Matcher;
            }
 * SPDX-License-Identifier: Apache-2.0
        public int compareTo(LocationOperation o) {
            return fail;
import java.util.List;
        }
                    checkpointCopy = checkpoint;
            unnecessaryCheckpointCopyPath = translogDir.resolve(Translog.getCommitCheckpointFileName(checkpoint.generation));
    }
                        checkpoint.numOps + random.nextInt(2),
     * to a random (strictly shorter) length, or by deleting the file.
            if (operations == null) {
    static void corruptRandomTranslogFile(Logger logger, Random random, Path translogDir, long minGeneration) throws IOException {
        final Path fileToCorrupt = RandomPicks.randomFrom(random, candidates);
                } while (isTranslogHeaderVersionFlipped(fileToCorrupt, fileChannel));
    }
        }
                    long newMaxSeqNo = checkpoint.maxSeqNo + random.nextInt(2);
import org.opensearch.index.seqno.SequenceNumbers;
 * ownership. Elasticsearch licenses this file to you under
            long offset = channel.position();
     * <p>
 * Helpers for testing translog.
                }
        final Iterator<Translog.Operation> iterator = operations.iterator();
                    logger.info(
 *
import java.nio.file.Files;
            ops.add(op);
                    fileChannel.read(bb);
}
            return operations.remove(0);
            logger.info("corruptFile: deleting file {}", fileToCorrupt);
        public void failRate(int rate) {
        @Override
            header.write(channel, true);
     * surfaces as a per-operation checksum failure when the operation is read.
                Checkpoint.write(
            final int rnd = OpenSearchTestCase.randomIntBetween(1, 100);
            Checkpoint checkpoint = new Checkpoint(offset, 1, generation, 0, 0, 0, generation, SequenceNumbers.NO_OPS_PERFORMED);
    }
            TranslogHeader header = new TranslogHeader(UUIDs.randomBase64UUID(random), 1);
 */
            final Checkpoint checkpoint = Checkpoint.read(checkpointPath);
                failAlways();
        }
public class TestTranslog {
                    fileChannel.position(corruptPosition);
        public void close() throws IOException {
                    bb.put(0, newValue);
        }
        Files.createFile(translogPath);
        }
 */
        final long fileSize = Files.size(fileToCorrupt);
            for (Path translogPath : stream) {
        final Translog.Location location;
            }
                        newMaxSeqNo,
        } catch (TranslogCorruptedException e) {
        }
     * @param minGeneration the minimum generation (N) to corrupt. Translogs and checkpoints with lower generation numbers are ignored.
import static org.hamcrest.Matchers.greaterThan;
     * See {@link TestTranslog#corruptFile(Logger, Random, Path, boolean)} for details of the corruption applied.
    }
            this.location = location;
import java.util.ArrayList;
                if (Files.isRegularFile(item) && Files.size(item) > 0) {
        }
 * Modifications Copyright OpenSearch Contributors. See
                } else {
                } else {
                if (checkpointCopy.equals(checkpoint) == false) {
                if (checkpoint != null && checkpoint.numOps > 0) {
        assertThat("no corruption candidates found in " + translogDir, candidates, is(not(empty())));
        return checkpoint.generation == generation ? checkpoint : null;
 * GitHub history for details.
                    nonEmpty.add(translogPath);
     */
            channel.write(one, position);
            channel.read(one, position);
    }
                    return null;
                    fileChannel.write(bb);
                    } while (newValue == oldValue);
