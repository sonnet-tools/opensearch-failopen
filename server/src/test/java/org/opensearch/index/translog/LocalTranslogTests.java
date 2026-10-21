            translog.rollGeneration();
        List<Translog.Location> locations = new ArrayList<>();
        ArrayList<Translog.Location> locs = new ArrayList<>();
        } finally {
                        Translog.Index expIndexOp = (Translog.Index) expectedOp;
            periods[i] = randomLongBetween(10000, 1000000);
                .build()
            )
                            syncedDocs.addAll(unsynced);
        Path tempDir = createTempDir();
        @Override
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 1);
            FileChannel::open,
            int expectedSnapshotOps = 0;
    @Override
            writer.sync();
                        assertEquals(expIndexOp.source(), indexOp.source());
        assertThat(translog.getMaxSeqNo(), equalTo(expectedMaxSeqNo));
                ) throws IOException {
        {
        ArrayList<Translog.Operation> ops = new ArrayList<>();
                        }
        for (int i = 0; i < numberOfReaders; i++) {
    }
        final TranslogConfig config = getTranslogConfig(tempDir);
                translog.rollGeneration();
        BytesStreamOutput out = new BytesStreamOutput();
            Translog translog = new LocalTranslog(
            assertFileDeleted(translog, gen);
            Version.CURRENT.minimumCompatibilityVersion(),
                            case CREATE:
                translog.add(op);
            int numOps = randomIntBetween(1, 100);
        ) {
        } catch (IllegalArgumentException ex) {
                    config,
            fail("should have failed earlier");
        fail.failNever();
        final TranslogDeletionPolicy deletionPolicy = new DefaultTranslogDeletionPolicy(-1, -1, 0);
            for (int op : ops) {
                    reader.readBytes(buffer, reader.getFirstOperationOffset() + 4 * i);
                failed = true;
            .mapToInt(r -> r.getCheckpoint().numOps)
        }
            assertThat("both translogs on same generation", batchTranslog.currentFileGeneration(), equalTo(gen));
                        counter++;
                            op = new Translog.Delete(
import org.apache.lucene.document.NumericDocValuesField;
        long randomPrimaryTerm = randomBoolean() ? 0 : randomNonNegativeLong();
                    it.remove();
        translog.rollGeneration();
            translog = createTranslog(config);
    }
            seqNo -> {},
                deletionPolicy,
        long currentSeqNo = 0L;
            }
        final TranslogStats total = new TranslogStats();
        final int numberOfReaders = scaledRandomIntBetween(1, 10);
        }
            threads[i].join(60 * 1000);
            minGenForRecovery = translog.getMinGenerationForSeqNo(localCheckpoint + 1).translogFileGeneration;
                seqNo -> {},
        long maxSeqNo = SequenceNumbers.NO_OPS_PERFORMED;
        @Override
            final long seqNo = seqNoBase + i;
            randomLongBetween(minRetainedReader.getCheckpoint().minSeqNo, minRetainedReader.getCheckpoint().maxSeqNo) - 1
            primaryTerm::get,
                translog.location().resolve(Translog.getFilename(translog.currentFileGeneration())),
                // we never managed to successfully create a translog, make it
                "lastCommitted must be 1 less than current",
                assertNull(snapshot.next());
                    throw new MockDirectoryWrapper.FakeIOException();
        }
            final int value = buffer.getInt();
                translogUUID,
        return new TranslogConfig(shardId, path, indexSettings, NON_RECYCLING_INSTANCE, bufferSize, "", false);
            maxSeqNo = a;
                    }
            translogUUID,
                            );
        TranslogConfig config = translog.getConfig();
            Translog.Index index = (Translog.Index) snapshot.next();
        truncateTranslogs(translogDir);
        Path tempDir = createTempDir();
import org.opensearch.index.mapper.SeqNoFieldMapper;
            TranslogWriter writer = translog.getCurrent();
            TranslogReader r = mock(TranslogReader.class);
            )
            final TranslogStats stats = stats();
            translogUUID,
        );
                            if (failed) {
                    assertNotNull(snap.next());
                    throw threadExceptions[i];
        final int headerSize = TranslogHeader.headerSizeInBytes(singleUUID);
                }
                            for (Translog.Operation op : ops) {
        while (failed == false) {
            }
            FileChannel delegate = FileChannel.open(file, openOption);
            randomLong(),
            assertThat(stats.getTranslogSizeInBytes(), equalTo(328L));
            .put(IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.getKey(), randomBoolean() ? "-1ms" : "1h")
                fail("read past EOF?");
 * specific language governing permissions and limitations
            for (final long op : ops) {
            );
                assertEquals(opsSynced, snapshot.totalOperations());
                    }
                protected void afterAdd() throws IOException {
        assertEquals(ex.getMessage(), "translog is already closed");
    public void testTragicEventCanBeAnyException() throws IOException {
            .sum();
                config,
                if (shouldAdd) {
                Translog.Operation expectedOp = locationOperation.operation;
                .translogSizeInBytes(1)
                translog.rollGeneration(); // empty generation
            equalTo(statsList.stream().mapToLong(TranslogStats::getUncommittedSizeInBytes).sum())
            false
            assertThat(stats.getTranslogSizeInBytes(), equalTo(273L));
                persistedSeqNos::add,
            return operations.values();
        public int write(ByteBuffer src, long position) throws IOException {
        List<Translog.Location> locations = new ArrayList<>();
            assertThat(snapshot, SnapshotMatchers.equalsTo(ops));
            translog.newSnapshot();
            Checkpoint.write((p, o) -> {
    public void testStats() throws IOException {
    }
                SequenceNumbers.NO_OPS_PERFORMED,
                validPathString = resolved.getFileName() != null;
            boolean success = false;
                assertTrue("at least one operation pending", translog.syncNeeded());
        translog.add(new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
                    )
                null
        final long b = randomNonNegativeLong();
                translog.getDeletionPolicy().setLocalCheckpointOfSafeCommit(Long.MAX_VALUE);
                        }
        );
        TranslogConfig config = getTranslogConfig(tempDir);
        translog.add(new Translog.Index("1", 0, primaryTerm.get(), lineFileDocs.nextDoc().toString().getBytes(Charset.forName("UTF-8"))));
                    throw new UnknownException();
                Integer.toString(translogOperations).getBytes(Charset.forName("UTF-8"))
                        translog.currentFileGeneration(),
        seqID.seqNoDocValue.setLongValue(randomSeqNum);
                primaryTerm.get(),
                );
                translogUUID,
        final boolean sync = randomBoolean();
                translog.add(new Translog.Index("" + op, op, primaryTerm.get(), Integer.toString(op).getBytes(Charset.forName("UTF-8"))))
                        tracker.markSeqNoAsProcessed(id);
        TranslogException ex = expectThrows(
        file = translogDir.resolve(Translog.TRANSLOG_FILE_PREFIX + id + ".recovering");
                    deletionPolicy.setLocalCheckpointOfSafeCommit(localCheckpointOfSafeCommit);
                    Files.createFile(target);
            config,
        translog.rollGeneration();
        );
import java.util.ArrayDeque;
                    };
            }
        }
                "" + op,
                }
                translog.sync();
            final String id = String.format(java.util.Locale.ROOT, "%020d", seqNo);
                translogGeneration.translogFileGeneration + 1,
        final String translogUUID = Translog.createEmptyTranslog(path, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
        final Set<Long> persistedSeqNos = new HashSet<>();
            () -> SequenceNumbers.NO_OPS_PERFORMED,
            }
                            checkpointFsyncCalls.incrementAndGet();
    }
                queue.add(current.getCause());
            int translogOperations = randomIntBetween(10, 100);
            assertFileIsPresent(translog, gen);
        int translogOperations = randomIntBetween(1, 10);
            assertThat(snapshot.totalOperations(), equalTo(1));
        @Override
            primaryTerm::get,
                seqNoGenerator,
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
            NON_RECYCLING_INSTANCE,
                threadExceptions
            final TranslogStats stats = stats();
                        assertThat(noOp.seqNo(), equalTo(expectedNoOp.seqNo()));
            shardId,
            TranslogCorruptedException.class,
            Translog translog = new LocalTranslog(
                return channel;
            Thread thread = new Thread(() -> {
        ) {
    }
                assertEquals(syncedDocs.size(), snapshot.totalOperations());
            } finally {
            assertThat(snapshot2, containsOperationsInAnyOrder(ops));
                Exception e = new Exception("test tragic exception");
        assertEquals("doc-2", readBack2.id());
            for (int i = 0; i < numOps; i++, currentSeqNo++) {
                translog.getDeletionPolicy().setLocalCheckpointOfSafeCommit(op);
            Set<Long> seenSeqNos = new HashSet<>();
                Translog translog = new LocalTranslog(
        translog.add(new Translog.NoOp(3, 1, randomAlphaOfLength(16)));
        } catch (IllegalArgumentException ex) {
        Translog.TranslogGeneration translogGeneration = null;
        public long position() throws IOException {
            assertNotNull(index);
                    translog.rollGeneration();
                    long initialGlobalCheckpoint,
        final int n = randomIntBetween(1, 16);
        try (Translog.Snapshot snapshot = translog.newSnapshot(0, Long.MAX_VALUE)) {
    }
 * this file be licensed under the Apache-2.0 license or a
                threads[i].join();
                public void onFailure(Exception e) {
            locations.add(
                    } catch (IOException inner) {
            Translog.parseIdFromFileName(file);
                }
            if (fail.fail()) {
                    Translog.Index op = new Translog.Index(
import org.opensearch.index.seqno.SequenceNumbers;
            }
            long fromSeqNo = randomLongBetween(0, minSeqNo - 1);
                    barrier.await();
            if (randomBoolean()) {
        final CyclicBarrier barrier = new CyclicBarrier(writers.length + readers.length + 1);
        Translog.TranslogGeneration translogGeneration = null;
        }
    public void testDeleteRoutingTranslogRoundTrip() throws Exception {
    /**
            stats.writeTo(out);
                            }
import java.util.stream.Stream;
            return super.read(dst);
        Path path = createTempDir("translog");
        for (; op < translogOperations / 2; op++) {
        final long gen;
        );
        return ops;
        final TranslogConfig config = new TranslogConfig(
        SeqNoFieldMapper.SequenceIDFields seqID = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
            final List<List<Translog.Operation>> views = new ArrayList<>();
                for (int i = 0; (operation = snapshot.next()) != null; i++) {
        if (sync) {
            null
                        src.position(pos);
        public ThrowingFileChannel(TestTranslog.FailSwitch fail, boolean partialWrite, boolean throwUnknownException, FileChannel delegate)
                final boolean isCkpFile = file.getFileName().toString().endsWith(".ckp");
                throw new AssertionError("detect circular reference exception", alreadyClosedException);
            try {
            .build();
                seqNo -> {},
            translogUUID,
        final TranslogDeletionPolicy deletionPolicy = translog.getDeletionPolicy();
                }
                translog.rollGeneration();
        ) {
                TranslogOperationHelper.DEFAULT,
            assertThat(copy.getTranslogSizeInBytes(), equalTo(328L));
import org.opensearch.core.common.bytes.BytesArray;
            String ascii = randomAlphaOfLengthBetween(1, 50);
        }
    public void testCloseSnapshotTwice() throws Exception {
                () -> SequenceNumbers.NO_OPS_PERFORMED,
                        throw new IOException("__FAKE__ no space left on device");
            deletionPolicy,
                }
            // if we are so happy to reach the max attempts - fail it always`
            assertThat(stats.getEarliestLastModifiedAge(), greaterThan(0L));
                            unsynced.clear();
        Files.createFile(config.getTranslogPath().resolve("translog-" + (read.generation + 1) + ".tlog"));
            seqNo -> {},
            final TranslogStats stats = stats();
            () -> globalCheckpoint.get(),
                        retentionLock.close();
            assertFalse(translog.syncNeeded());
        Translog.TranslogGeneration translogGeneration = translog.getGeneration();
import java.util.stream.LongStream;
                    }
                    }
 */
            int threadId,
    public void testCloseConcurrently() throws Throwable {
                .uncommittedOperations(1)
                    throw new UnknownException();
            int op = 0;
                }
    public void testFullRangeSnapshotWithFailures() throws Exception {
            byte[] bytes = new byte[4];
        }
        fail(Translog.getFilename(id) + " is not present in any location: " + translog.location());
        Path[] files = FileSystemUtils.files(directory, "translog-*");
        super.setUp();
                int upTo = sync ? translogOperations : prepareOp;
                }
 * the Apache License, Version 2.0 (the "License"); you may
            // Sequence numbers are marked as persisted after sync
        }
            translogConfig,
        final TranslogConfig config = new TranslogConfig(
    private final AtomicReference<LongConsumer> persistedSeqNoConsumer = new AtomicReference<>();
        expectThrows(
                }
        }
                        @Override
                    null
                            writeCalls.incrementAndGet();
                    }
                }
                    afterAdd();
        }
import org.opensearch.core.xcontent.XContentBuilder;
                .build()
            int numOps = randomIntBetween(4, 10);
        translog.close();
                        + "}}}}",
        translog.rollGeneration();
            translogOperations += extraTranslogOperations;
import static org.mockito.Mockito.mock;
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
        assertEquals(deleteRouting, serializedDelete.routing());
            }
    public void testRecoveryFromAFutureGenerationCleansUp() throws IOException {
            }
            if (consumer != null) {
            assertThat(snapshot, SnapshotMatchers.size(0));
    }
            assertThat(stats.getUncommittedSizeInBytes(), equalTo(firstOperationPosition));
        }
                if (op <= lastSynced) {
        globalCheckpoint.set(randomNonNegativeLong());
        Path tempDir = createTempDir();
    }
                if (partialWrite) {
                    () -> SequenceNumbers.NO_OPS_PERFORMED,
        }
        fail.failNever();
        }
        assertNull(readBack2.routing());
                .translogSizeInBytes(1)
            );
                translog.currentFileGeneration()
import java.util.stream.IntStream;
    public void testAcquiredLockIsPassedToDeletionPolicy() throws IOException {
        final List<Translog.Operation> one = buildHttpLogLikeOps(1, 0);
        int firstUncommitted = 0;
            primaryTerm.get()
    }
            locations.add(
        }
        assertEquals("doc-1", readBack1.id());
        } else {
        final AtomicLong seqNoGenerator = new AtomicLong();
        final List<Translog.Operation> readOperations = Translog.readOperations(out.bytes().streamInput(), "testSnapshotFromStreamInput");
                    randomAlphaOfLength(10),
            assertEquals(4, checkpointFsyncCalls.get());
            final Set<Tuple<Long, Long>> expected = seqNos.stream().filter(t -> t.v1() >= seqNoLowerBound).collect(Collectors.toSet());
            final int operations = randomIntBetween(1, 128);
    public void testSyncConcurrently() throws Exception {
                Translog.Index operation = new Translog.Index("" + op, op, primaryTerm.get(), source.get().getBytes("UTF-8"));
            TranslogSnapshot snapshot = reader.newSnapshot();
        for (int gen = 0; gen < generations; gen++) {
            stats.writeTo(out);
        try (
                assertFalse(translog.syncNeeded());
        }
        }
        translog.close();
    public void testCloseIntoReader() throws IOException {
            assertThat(stats.estimatedNumberOfOperations(), equalTo(1));
            new LocalTranslog(
            ? writer
            threads[i].setDaemon(true);
            }
            assertThat(translog.getMinFileGeneration(), lessThanOrEqualTo(minGenForRecovery));
            checkpoint,
    public void testBatchAddByteIdenticalToSingleAdds() throws IOException {
    public void testSnapshotWithNewTranslog() throws IOException {
            try {
    /**
                    } else {
import static org.hamcrest.Matchers.greaterThan;
                try (Translog.Snapshot snapshot = new TestTranslog.SortedSnapshot(translog.newSnapshot())) {
                .uncommittedSizeInBytes(1)
                        + stats.getEarliestLastModifiedAge()
            }
        long minRetainedGen = translog.getMinGenerationForSeqNo(localCheckpoint + 1).translogFileGeneration;
    public void testRecoveryUncommittedFileExists() throws IOException {
            }
                }
     * Tests the situation where the node crashes after a translog gen was committed to lucene, but before the translog had the chance
        }
                        final int limit = src.limit();
            assertThat(delete.id(), equalTo("2"));
                        assertThat(noOp.reason(), equalTo(expectedNoOp.reason()));
import static org.hamcrest.CoreMatchers.hasItem;
            translogUUID,
                        }
            }
    }
            try (XContentBuilder builder = XContentFactory.jsonBuilder()) {
        final TranslogConfig config,
                }
        List<Translog.Operation> firstGenOps = null;
                    minGen = translog.getMinFileGeneration();
        final long a = randomNonNegativeLong();
                            failableTLog.trimUnreferencedReaders();
        Translog translog = getFailableTranslog(fail, config, false, true, null, createTranslogDeletionPolicy());
                primaryTerms.add(primaryTerm.get());
    }
            translog.trimOperations(primaryTerm.get(), maxTrimmedSeqNo);
                .build()
                translogUUID,
        final int operations = randomIntBetween(1, 4096);
import java.nio.ByteBuffer;
            if (rarely()) {
                        // we were committing and blew up in one of the syncs, but they made it through
        );
            assertThat(batchLocations.length, equalTo(singleLocations.size()));
                translog.rollGeneration();
            startBlocking.set(true);
                assertNotNull(ex.getCause());
        // Use a small, fixed buffer so the batch spans the writer's buffer-flush threshold at least once.
            ) {
                    IOUtils.close(getFailableTranslog(fail, config, randomBoolean(), false, generationUUID, deletionPolicy));
        ) {
        String translogUUID = Translog.createEmptyTranslog(
        try (
    protected void afterIfSuccessful() throws Exception {
            new ByteSizeValue(4, ByteSizeUnit.KB),
            @Override
            forwardConfig.getTranslogPath(),
                assertNotNull(translogGeneration.translogUUID);
            batchDir,
                primaryTerm.get()
                        new Translog.Index(
 * GitHub history for details.
            }
            }
        for (int i = 0; i < numOps; i++) {
        int translogOperations = randomIntBetween(10, 100);
        }
        final ChannelFactory channelFactory = (file, openOption) -> {
                        if (expectedOps.isEmpty() == false) {
            if (frequently()) {
        try (
    public void testSyncUpToStream() throws IOException {
                seqNos.add(currentSeqNo);
import java.util.concurrent.atomic.AtomicReference;
                if (success == false) {
                        }
        final long maxSeqNo = seenSeqNos.stream().max(Long::compareTo).orElse(SequenceNumbers.NO_OPS_PERFORMED);
            translog.close();
import java.util.concurrent.atomic.AtomicLong;
    private Term newUid(ParsedDocument doc) {
                IOUtils.close(this);
        assertThat(locs.length, equalTo(1));
                    "expected this to be the first roll (1 gen is on creation, 2 when opened)",
            } else {
                boolean committing = false;
                );
        } while (Translog.PARSE_STRICT_ID_PATTERN.matcher(string).matches() || validPathString == false);
                    }
            try (Translog.Snapshot snapshot = reopenedTranslog.newSnapshot()) {
                assertTrue("this operation has not been synced", translog.ensureSynced(location));
            assertThat(snapshot, SnapshotMatchers.equalsTo(ops));
            translogUUID = Translog.createEmptyTranslog(
        Translog.Delete serializedDelete = (Translog.Delete) Translog.Operation.readOperation(in);
            () -> SequenceNumbers.NO_OPS_PERFORMED,
            minSeqNo = a;
            }
        ) {
            try (Translog.Snapshot snapshot = translog.newSnapshot()) {
                "current should not have any operations with seq#:primaryTerm "
        @Override
            TranslogOperationHelper.DEFAULT,
                translog.trimUnreferencedReaders();
                        src.position(pos);
            // Sequence numbers are marked as persisted after sync
import static org.opensearch.index.translog.TranslogDeletionPolicies.createTranslogDeletionPolicy;
        try (Closeable ignored = translog.acquireRetentionLock()) {
            if (translog.currentFileGeneration() > 1) {
            assertEquals(
            final String threadId = "reader_" + i;
                threads[t].start();
        assertThat(Translog.findEarliestLastModifiedAge(fixedTime, new ArrayList<>(), w), equalTo(period));
            TranslogOperationHelper.DEFAULT,
 *
        Translog.Index operation = new Translog.Index("" + 1, 1L, primaryTerm.get(), randomAlphaOfLengthBetween(1, 50).getBytes("UTF-8"));
                for (int i = 0; i < upTo; i++) {
                    translog.rollGeneration();
                    } else if ("doc-2".equals(del.id())) {
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 2);
            primaryTerm::get,
        final AtomicLong seqNoGenerator = new AtomicLong();
            assertBusy(() -> {
            randomLongBetween(1, generation),
            assertThat(BytesReference.toBytes(index.source()), equalTo(new byte[] { 1 }));
            for (long gen = translog.currentFileGeneration(); gen > 0; gen--) {
            views.add(new ArrayList<>());
                    Translog.Location loc = add(op);
        final List<Tuple<Long, Long>> seqNos = new ArrayList<>();
            translog.rollGeneration();
                deletionPolicy,
                );
                assertThat(persistedSeqNos, empty());
        e = expectThrows(
        try (
            .orElseThrow();
                    Translog.Operation next = snapshot.next();
                    seqNo -> {},
            TranslogConfig.DEFAULT_BUFFER_SIZE,
        String translogUUID = Translog.createEmptyTranslog(
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 2);
                assertFileDeleted(translog, translog.currentFileGeneration() - 1);
        Path ckp = config.getTranslogPath().resolve(Translog.CHECKPOINT_FILE_NAME);
            seqNos.add(Tuple.tuple(seqNo, terms.computeIfAbsent(seqNo, k -> 0L)));
        );
    private Location addToTranslogAndList(Translog translog, List<Translog.Operation> list, Translog.Operation op) throws IOException {
                writtenOperations,
        }
        toSeqNo = randomLongBetween(fromSeqNo, 2000);
                if ((threadExceptions[i] instanceof AlreadyClosedException) == false) {
        expectThrows(TranslogCorruptedException.class, () -> Translog.readGlobalCheckpoint(translogDir, UUIDs.randomBase64UUID()));
                translog.rollGeneration();
            do {
            TranslogWriter writer = translog.getCurrent();
        final Map<Long, Long> terms = new HashMap<>();
                maxSeqNo = SequenceNumbers.max(maxSeqNo, currentSeqNo);
    private Checkpoint randomCheckpoint() {
            }
import java.util.concurrent.atomic.AtomicBoolean;
        list.add(op);
            if (seqNo != SequenceNumbers.UNASSIGNED_SEQ_NO) {
            for (int t = 0; t < threads.length; t++) {
    private Translog getFailableTranslog(
            .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
        AtomicLong lastGlobalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
                    assertEquals(ex, failableTLog.getTragicException());
                inMemoryTranslog.add(operation);
                            if (startBlocking.get()) {
                        break;
                    assertNotNull("operation " + i + " must be non-null synced: " + sync, next);
                }
                assertFalse("this op has been synced before", translog.ensureSynced(location)); // not syncing now
                primaryTerm.incrementAndGet();
                        translog.currentFileGeneration() - 1,
        }
        final TestTranslog.FailSwitch fail = new TestTranslog.FailSwitch();
            assertNotNull(ex.getCause());
        try {
            try {
                assertThat(snapshot.totalOperations(), equalTo(expectedSnapshotOps));
            assertThat(stats.estimatedNumberOfOperations(), equalTo(4));
                        if (iter++ % 10 == 0) {
                        break;
                    }
                createTranslogDeletionPolicy(),
        int lastSynced = -1;
                success = true;
                seqNo = opsHaveValidSequenceNumbers ? randomNonNegativeLong() : SequenceNumbers.UNASSIGNED_SEQ_NO;
            Exception[] threadExceptions
        return new LocalTranslog(
                    Translog.Operation next = snapshot.next();
        try {
            temp.getTranslogPath(),
        fail.failAlways();
            for (int op = 0; op < translogOperations; op++) {
            );
            for (int i = 0; i < operations; i++) {
                translog.rollGeneration();
                if (!seqNoPerGeneration.containsKey(g)) {
                );
        assertFileIsPresent(translog, 1);
import java.util.HashSet;
            assertThat(snapshot.totalOperations(), equalTo(0));
                assertThat(snapshot, SnapshotMatchers.equalsTo(expectedSeqNo));
                }
                        foundRouted = true;
        );
        Translog.Operation.writeOperation(out, deleteWithRouting);
            translog.rollGeneration();
            final TranslogStats copy = new TranslogStats(out.bytes().streamInput());
        );
                    super.deleteReaderFiles(reader);
                assertThat(writeCalls.get(), greaterThan(initialWriteCalls));
                }
                translog.getTranslogUUID(),
        final ChannelFactory channelFactory = (file, openOption) -> {
                } catch (IOException e) {
        assertThat(translog.add(new ArrayList<>()).length, equalTo(0));
        return false;
                }
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
                assertNull(snapshot.next());
            for (int i = 0; i < iters; i++) {
        }
            return a;
        for (long seqNo = 0; seqNo < operations; seqNo++) {
        }
                        primaryTerm.get(),
            if (rarely()) {
    }
                if (randomBoolean()) {
            assertThat(stats.getUncommittedSizeInBytes(), equalTo(139L));
        }
            null,
        Checkpoint.write(
                for (long i = 0; i < minRetainedReader.generation; i++) {
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            assertThat(noOp.seqNo(), equalTo(seqNo));
            primaryTerm::get
            if (randomBoolean()) {
        final int generations = between(2, 20);
            when(r.getLastModifiedTime()).thenReturn(fixedTime - l);
                                    blocker.await();
        }
            for (int i = 0; i <= rolls; i++) {
                channelFactory
        in.setVersion(wireVersion);
                ops.add(op);
        }
            assertThat(snapshot.totalOperations(), equalTo(0));
        ) {
            out.writeInt(1);
        );
        } catch (MissingHistoryOperationsException e) {
                }
            StandardOpenOption.WRITE,
                            for (Translog.Operation op : ops) {
            Translog.Operation next;
                                .append(committedLocalCheckpointAtView + 1L)
                    () -> SequenceNumbers.NO_OPS_PERFORMED,
                .build()
        final boolean sync = randomBoolean();
        final List<Translog.Operation> ops = buildHttpLogLikeOps(opCount, 0);
        if (longRetention) {
            void callCloseUsingIOUtilsWithExceptionHandling() {
        assertNull(translog.readOperation(new Location(100, 0, 0)));
                source[b] = (byte) ((seqNo * 31 + b) & 0xFF);
     * to clean up its files.
            0,
        translog.trimUnreferencedReaders();
                                translog.sync();
            primaryTerm.get()
        long toSeqNo = Math.min(nextSeqNo - 1, fromSeqNo + 15);
                    throw new MockDirectoryWrapper.FakeIOException();
                if (partialWrite) {
import org.apache.lucene.backward_codecs.store.EndiannessReverserUtil;
            StandardOpenOption.CREATE_NEW
                assertTrue("at least one operation pending", translog.syncNeeded());
            void callCloseDirectly() throws IOException {
            try {
                return channel;
            )
        assertFalse(translog.isOpen());
            "",
                if (isCkpFile) {
            assertThat(stats.getUncommittedSizeInBytes(), equalTo(218L));
        assumeTrue("test only works with assertions enabled", Assertions.ENABLED);
                final FileChannel channel;
        Checkpoint.write(
        List<Translog.Location> locations = new ArrayList<>();
        try (Translog.Snapshot snapshot = translog.newSnapshot(seqNo + 1, randomLongBetween(seqNo + 1, Long.MAX_VALUE))) {
        assertFalse("translog [" + id + "] still exists", Files.exists(translog.location().resolve(Translog.getFilename(id))));
            randomSeqNum,
                )
                .uncommittedOperations(1)
        }
        Translog.TranslogGeneration translogGeneration = null;
    @Before
    @After
            threads[i].join(60 * 1000);
                if (ex.getCause() instanceof MockDirectoryWrapper.FakeIOException) {
        final Translog failableTLog = getFailableTranslog(
            fail,
            )
                Closeable retentionLock = null;
        long earliestLastModifiedAge = Long.MAX_VALUE;
        Translog translog = getFailableTranslog(fail, config);
        translog.close();
    }
                            translog.ensureSynced(location);
    public void testBasicSnapshot() throws IOException {
            final int threadId = i;
        final CountDownLatch blocker = new CountDownLatch(1);
                translog.add(new Translog.Index("" + op, op, primaryTerm.get(), Integer.toString(op).getBytes(Charset.forName("UTF-8"))))
            reader.readBytes(buffer, reader.getFirstOperationOffset() + 4 * i);
        }
            final TranslogStats stats = stats();
        assertEquals(ex.getCause().getClass(), FileAlreadyExistsException.class);
        final String translogUUID = translog.getTranslogUUID();
        } catch (TranslogCorruptedException ex) {
            FileChannel delegate = FileChannel.open(file, openOption);
        long[] periods = new long[numberOfReaders + 1];
    @Before
                        long id = idGenerator.getAndIncrement();
        assertThat(
        try {
                    assertEquals(i, Integer.parseInt(next.getSource().source.utf8ToString()));
        private final Collection<TestTranslog.LocationOperation> writtenOperations;
    public void testSnapshotFromStreamInput() throws IOException {
                        final int pos = src.position();
        List<Translog.Location> locations = new ArrayList<>();
     */
                    case INDEX:
                                randomUnicodeOfLengthBetween(1, 20 * 1024).getBytes("UTF-8")
            assertThat(stats.getTranslogSizeInBytes(), equalTo(157L));
        );
            SequenceNumbers.NO_OPS_PERFORMED,
            locations.add(
            if (fileChannels != null) {
            // otherwise our assertions here are off by one sometimes.
                        .map(allOp -> ((Translog.Index) allOp).source().utf8ToString())
                    primaryTerm.incrementAndGet();
        for (int attempt = 0, maxAttempts = randomIntBetween(3, 10); attempt < maxAttempts; attempt++) {
        try {
                final Path resolved = translogDir.resolve(string);
    }
                    SequenceNumbers.NO_OPS_PERFORMED,
        seqID.primaryTerm.setLongValue(randomPrimaryTerm);
    static boolean hasCircularReference(Exception cause) {
                final Set<Tuple<Long, Long>> generationSeqNo = seqNoPerGeneration.get(g);
                }
    }
                    translog.add(new Translog.Index("id", seqNo, primaryTerm.get(), new byte[] { 1 }));
                }
        }
            if (rollover) {
                translog.rollGeneration();
                    boolean syncNeeded = translog.syncNeeded();
                opsPerThread,
            for (Thread thread : threads) {
                            Translog.Location location = null;
                // don't do partial writes for checkpoints we rely on the fact that the bytes are written as an atomic operation
        Path tempDir = createTempDir();
            if (randomBoolean()) {
                }
                            if (startBlocking.get()) {
import org.opensearch.core.util.FileSystemUtils;
    public void testRecoverWithUnbackedNextGen() throws IOException {
                            case DELETE:
        }
                } else {
            translog.close();
        public int write(ByteBuffer src) throws IOException {
                Translog.Index op = new Translog.Index(randomAlphaOfLength(10), seqNo, primaryTerm.get(), new byte[] { 1 });
                    Translog.Delete del = (Translog.Delete) op;
                    translog2.add(
            ) throws IOException {
                } else {
    /** Make sure that it's ok to close a translog snapshot multiple times */
            final TranslogStats stats = stats();
        try {
                    channel = new FilterFileChannel(delegate) {
                        final Translog.Operation op;
                    createTranslogDeletionPolicy(),
        assertThat(Files.size(translogFile), equalTo(checkpoint.offset));
                    seqNo -> {},
        translog.rollGeneration();
                while ((op = snapshot.next()) != null) {
                for (int i = 0; i < 1; i++) {
                        assertEquals(expIndexOp.version(), indexOp.version());
    public void testVerifyTranslogIsNotDeleted() throws IOException {
                assertThat(writeCalls.get(), greaterThan(initialWriteCalls));
            }
        int count = 0;
    private final AtomicLong primaryTerm = new AtomicLong();
            readers.add(r);
            // all good
                TranslogOperationHelper.DEFAULT,
import org.opensearch.core.xcontent.MediaTypeRegistry;
                } else {
            primaryTerm::get,
    protected Translog createTranslog(TranslogConfig config) throws IOException {
        translog.rollGeneration();
                        if (id % 7 == 0) {
                .earliestLastModifiedAge(1)
                );
                protected Translog.Location add(Translog.Operation op) throws IOException {
        final TranslogDeletionPolicy deletionPolicy = translog.getDeletionPolicy();
}
        expectIntactTranslog = false;
            0,
            max = max(max, location);
    }
        }
                assertNotNull(translogGeneration.translogUUID);
        final Map<Long, Set<Tuple<Long, Long>>> seqNoPerGeneration = new HashMap<>();
import org.apache.lucene.document.Field;
        // no trimming done yet, just recovered
        translog.rollGeneration();
                assertThat(snapshot.skippedOperations(), is(allOperations.size() - effectiveOperations.size()));
                                // expose the new checkpoint (simulating a commit), before we trim the translog
        }
        final int prepareOp = randomIntBetween(0, translogOperations - 1);
        persistedSeqNoConsumer.set(persistedSeqNos::add);
import java.util.Map;
                        final int limit = src.limit();
        final ChannelFactory channelFactory = (file, openOption) -> {
    }
                translog.sync();
        translog.add(new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
                        assertNull(del.routing());
            Path tempDir = createTempDir();
        return getFailableTranslog(fail, config, randomBoolean(), false, null, createTranslogDeletionPolicy());
        ) {
                thread.join();
        }
            );
                            }
            assertEquals(initialWriteCalls, writeCalls.get());
                    reader = translog.openReader(reader.path(), writerCheckpoint);
            assertThat(storedPrimaryTerms, equalTo(primaryTerms));
        persistedSeqNos.remove(SequenceNumbers.UNASSIGNED_SEQ_NO);
        Path ckp = config.getTranslogPath().resolve(Translog.CHECKPOINT_FILE_NAME);
                getPersistedSeqNoConsumer(),
        // Verify via snapshot as well
        }
            }
            }
                        default:
import java.util.HashMap;
                throw threadExceptions[i];
        translog = new LocalTranslog(
                            return super.write(src);
                        assertFalse(loc.equals(location));
        );
        translog.sync();
        final int operations = randomIntBetween(1, 100);
        assertThat(
            return super.position();
        String translogUUID = Translog.createEmptyTranslog(
        }
                translog.rollGeneration();
        {
        List<Translog.Location> locations = new ArrayList<>();
                    views.get(views.size() - 1).add(op);
import org.opensearch.core.Assertions;
                    expectedSnapshotOps += opCountPerGeneration.get(g);
        assertThat(TranslogFooter.readChecksum(translogFile, checkpoint.offset), nullValue());
            FileChannel channel = FileChannel.open(file, openOption);
        for (int op = 0; op < translogOperations; op++) {
                    syncedDocs.addAll(unsynced);
            });
    }
        final Path path = createTempDir();
            if (atLeastOneFailed == false) {
        Checkpoint read = Checkpoint.read(ckp);
            if (rarely()) {
            assertThat(snapshot.next(), equalTo(one.get(0)));
        final TranslogDeletionPolicy deletionPolicy = translog.getDeletionPolicy();
            int totOps = 0;
        for (int i = 0; i < threadCount; i++) {
            }
                            long globalCheckpoint = lastGlobalCheckpoint.get();
        Map<Long, List<Translog.Operation>> operationsByGen = new HashMap<>();
                    assertEquals(next, writtenOperations.get(i).operation);
                throw new MockDirectoryWrapper.FakeIOException();
                            assertNotNull(location);
        }
            translog.add(new Translog.NoOp(tuple.v1(), tuple.v2(), "test"));
            boolean success = false;
        if (sync) {
                translogGeneration.translogFileGeneration + 2,
                );
        }
        long randomSeqNum = randomNonNegativeLong();
    public void testReadLocation() throws IOException {
import java.util.Arrays;
    public static class ThrowingFileChannel extends FilterFileChannel {
                        inner.addSuppressed(e);
            }
        assertThat(total.estimatedNumberOfOperations(), equalTo(0));
                try {
                () -> SequenceNumbers.NO_OPS_PERFORMED,
        }
            failedToSyncCheckpoint.set(true);
                    translog.close();
            }
                    atLeastOneFailed = true;
            validPathString = false;
    }
            };
        translog.add(new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
            try {
import org.apache.lucene.tests.util.LuceneTestCase;
            try (Translog.Snapshot snapshot = translog.newSnapshot(fromSeqNo, toSeqNo)) {
        final int runs = randomIntBetween(5, 10);
        final String foreignTranslog = randomRealisticUnicodeOfCodepointLengthBetween(1, translogGeneration.translogUUID.length());
            : translog.openReader(writer.path(), Checkpoint.read(translog.location().resolve(Translog.CHECKPOINT_FILE_NAME)));
        } catch (IllegalArgumentException ex) {
                translog.add(new Translog.Index("" + op, op, primaryTerm.get(), Integer.toString(op).getBytes(Charset.forName("UTF-8"))))
                    fail,
                return throwingFileChannel;
        Files.copy(ckp, config.getTranslogPath().resolve(Translog.getCommitCheckpointFileName(read.generation)));
                    default:
            assertThat(stats.estimatedNumberOfOperations(), equalTo(2));
                    buffer.flip();
            while ((op = snapshot.next()) != null) {
        }
                        assertEquals(expDelOp.id(), delOp.id());
                                    // Ignore
                    for (int i = 0; i < upTo; i++) {
                    null
                final List<Translog.Operation> expectedSeqNo = new ArrayList<>();
            assertThat(stats.getTranslogSizeInBytes(), equalTo(328L));
        }
        {
            Translog translog = new LocalTranslog(
            FileChannel::open,
        Document document = new Document();
import org.junit.Before;
        long toSeqNo = randomLongBetween(fromSeqNo, Long.MAX_VALUE);
                    + "] > 0:"
            DataOutput out = EndiannessReverserUtil.wrapDataOutput(new ByteArrayDataOutput(new byte[4]));
            for (Translog.Operation op : ops) {
                                synced = translog.ensureSynced(location);
        TranslogWriter w = mock(TranslogWriter.class);
                        switch (type) {
                null
                if (randomBoolean()) {
                } catch (RuntimeException ex) {
                () -> SequenceNumbers.NO_OPS_PERFORMED,
    public void testTranslogWriterDoesNotBlockAddsOnWrite() throws IOException, InterruptedException {
        for (int op = 0; op < translogOperations; op++) {
                expectedException = e;
                translogUUID,
                success = true;
        for (int gen = 0; gen < generations; gen++) {
        );
                );
            assertThat(snapshot.totalOperations(), equalTo(1));
                for (List<Translog.Operation> view : views) {
        out.setVersion(Version.CURRENT);
            fail.failNever(); // we don't wanna fail here but we might since we write a new checkpoint and create a new tlog file
 * not use this file except in compliance with the License.
            final TranslogStats stats = stats();
     * Tests that concurrent readers and writes maintain view and snapshot semantics
            string = randomRealisticUnicodeOfCodepointLength(randomIntBetween(min, max));
                f.truncate(newSize);
            void callCloseOnTragicEvent() {
        for (int op = 0; op < translogOperations; op++) {
            }
            }, tempDir.resolve("foo.cpk"), checkpoint2, StandardOpenOption.WRITE);
                latestOperations.put(op.seqNo(), op);
                        assertEquals("payload mismatch, synced: " + sync, i, Integer.parseInt(next.getSource().source.utf8ToString()));
            if (randomBoolean()) {
                translog.sync();
            }
            () -> new LocalTranslog(
                        foundUnrouted = true;
        try (
            )
            }
        final int flushEveryOps = randomIntBetween(5, 100);
            assertEquals(maxOp.getSource().source.utf8ToString(), Integer.toString(count));
     */
        Field versionField = new NumericDocValuesField("_version", 1);
        for (int i = 0; i < threadCount; i++) {
            channelFactory,
            final int value = buffer.getInt();
        );
import org.opensearch.common.Randomness;
    public void testMinSeqNoBasedAPI() throws IOException {
    }
        final String translogUUID = translog.getTranslogUUID();
    public void testIdParsingFromFile() {
        protected void afterAdd() throws IOException {}
                deletionPolicy,
        for (int i = 0; i < n; i++) {
            .orElse(SequenceNumbers.NO_OPS_PERFORMED);
        AlreadyClosedException ex = expectThrows(AlreadyClosedException.class, () -> translog.newSnapshot());
                );
                    seqNo -> {},
            for (; op < translogOperations / 2; op++) {
            for (int op = 0; op < translogOperations; op++) {
            if (op == prepareOp) {
import java.nio.channels.FileChannel;
            path.getFileSystem()
            }
            assertNotNull("operation 2 must be non-null", secondOp);
            primaryTerm::get,
        List<FileChannel> fileChannels = new ArrayList<>();
        final Deque<List<Translog.Operation>> views = new ArrayDeque<>();
            channelFactory,
            }
                            failableTLog.sync();
                boolean drop = op.primaryTerm() < belowTerm && op.seqNo() > aboveSeqNo;
        try (Translog.Snapshot snapshot = translog.newSnapshot(fromSeqNo, toSeqNo, true)) {
            assertThat(translog.getCurrent().getPrimaryTerm(), equalTo(primaryTerm.get()));
                long committedLocalCheckpointAtView;
        ) {
            }
        }
            Translog.Operation firstOp = snapshot.next();
            deletionPolicy,
    public void testSimpleOperations() throws IOException {
        }
        final InMemoryTranslog inMemoryTranslog = new InMemoryTranslog();
    }
            maxSeqNo = b;
        }
                if (primaryTerm.get() == translog.getCurrent().getPrimaryTerm()) {
                .uncommittedSizeInBytes(1)
        }
                    allOperations.stream()
            config.getTranslogPath(),
                }
        deletionPolicy.setRetentionSizeInBytes(-1);
        downLatch.countDown();
        assertThat(total.getUncommittedSizeInBytes(), equalTo(0L));
            out.writeInt(i);
            null
            createTranslogDeletionPolicy(config.getIndexSettings()),
            Translog.Index operation = new Translog.Index("" + op, op, primaryTerm.get() - op, ascii.getBytes("UTF-8"));
                    + "numOps=55, generation=3, minSeqNo=45, maxSeqNo=99, globalCheckpoint=-1, minTranslogGeneration=1, trimmedAboveSeqNo=-2} "
                        unsynced.clear();
            singleBytes = Files.readAllBytes(singleDir.resolve(Translog.getFilename(gen)));
                translog.trimUnreferencedReaders();
            } catch (Exception e) {
                    deleteIfExists(target);
            null
                protected void doRun() throws Exception {
        queue.add(cause);
                translog.add(op);
        }
                );
import org.apache.lucene.index.IndexFormatTooOldException;
            assertEquals(
                    writer.sync();
        int translogOperations = 100;
            primaryTerm.get()
            translog.sync();
                            Translog.Operation op;
            );
            assertNotNull(translogGeneration);
                        }
                "lastCommitted must be 2 less than current - we never finished the commit",
            assertThat(stats.getUncommittedSizeInBytes(), equalTo(102L));
                    committedLocalCheckpointAtView = lastCommittedLocalCheckpoint.get();
                    final Translog.Operation read = snapshot.next();
                uncommittedOps = operationsInLastGen;
                .uncommittedOperations(1)
        e = expectThrows(
            false
                            }
    }
        );
                    primaryTerm.get(),
                    assertNotNull("operation " + i + " must be non-null", next);
                TranslogOperationHelper.DEFAULT,
            }
    }
            }
                translogUUID,
        Thread[] threads = new Thread[threadCount];
        translog.add(new Translog.Index("" + 0, 0, primaryTerm.get(), Integer.toString(1).getBytes(Charset.forName("UTF-8"))));
    public void testReadGlobalCheckpoint() throws Exception {
            for (op = translogOperations / 2; op < translogOperations; op++) {
        for (int gen = 0; gen < generations; gen++) {
                final Translog.Location location = translog.add(
        } catch (AlreadyClosedException ex) {
            }
            assertThat(stats.getUncommittedSizeInBytes(), equalTo(273L));
                translog.sync();
        final long generation = randomNonNegativeLong();
                    long initialMinTranslogGen,
        int translogOperations = randomIntBetween(10, 100);
            maxSeqNo,
        final TranslogConfig translogConfig = getTranslogConfig(path);
            boolean success = false;
            null
                seqNo -> {},
        boolean opsHaveValidSequenceNumbers = randomBoolean();
            } finally {
                null
import org.apache.lucene.document.TextField;
        final Checkpoint checkpoint = Checkpoint.read(translog.location().resolve(Translog.CHECKPOINT_FILE_NAME));
                        Translog.Delete delOp = (Translog.Delete) op;
                "" + translogOperations,
        try (
            }
    private void truncateTranslogs(Path directory) throws Exception {
            config.getTranslogPath(),
        Checkpoint read = Checkpoint.read(ckp);
                            }
            if (rarely()) {
                operationsInLastGen = 0;
        final boolean throwUnknownException,
            if (randomBoolean()) {
            return new FilterFileChannel(channel) {
            )
 * SPDX-License-Identifier: Apache-2.0
        final TranslogDeletionPolicy deletionPolicy = translog.getDeletionPolicy();
                                failed = true;
                .build();
                new Translog.Index(Integer.toString(op), op, primaryTerm.get(), Integer.toString(op).getBytes(Charset.forName("UTF-8")))
                if (throwUnknownException) {
                assertThat(snapshot.totalOperations(), is(allOperations.size()));
        final TranslogConfig translogConfig = getTranslogConfig(path);
                });
                @Override
import org.opensearch.index.VersionType;
                switch (op.opType()) {
            if (earliestLastModifiedAge > stats.getEarliestLastModifiedAge()) {
                    assertThat(e.getCause(), instanceOf(EOFException.class));
            translog.add(new Translog.NoOp(i, 0, "test"));
                }
        }
            )
                } else {
            Translog translog,
        BytesStreamOutput out = new BytesStreamOutput();
        };
            fail("already closed");
        Files.copy(ckp, config.getTranslogPath().resolve(Translog.getCommitCheckpointFileName(read.generation)));
        final AtomicBoolean startBlocking = new AtomicBoolean(false);
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
            // Sync against so that both operations are written
                    Translog.Operation next = snapshot.next();
            IndexFormatTooOldException.class,
        final Checkpoint checkpoint2 = randomCheckpoint();
            assertEquals(
import org.opensearch.common.collect.Tuple;
        int translogOperations = randomIntBetween(10, 1000);
            // all is well
            }
            assertThat(snapshot.totalOperations(), equalTo(ops.size()));
        long maxSeqNo = SequenceNumbers.NO_OPS_PERFORMED;
    private TranslogConfig getTranslogConfig(final Path path, final Settings settings) {
        }
        final String translogUUID = translog.getTranslogUUID();
                    assertEquals(ex.getMessage(), "__FAKE__ no space left on device");
                TranslogOperationHelper.DEFAULT,
        // a signal for all threads to stop
                    channel = delegate;
                translog.rollGeneration();
            translogUUID,
                "lastCommitted must be 2 less than current - we never finished the commit",
        List<Translog.Location> locations = new ArrayList<>();
                    int upTo = sync ? translogOperations : prepareOp;
                        public void force(boolean metaData) throws IOException {
        translog.rollGeneration();
            void callCloseUsingIOUtils() throws IOException {
        try (TranslogWriter writer = translog.createWriter(translog.currentFileGeneration() + 1)) {
        ArrayList<Translog.Operation> ops = new ArrayList<>();
                @Override
                translog.trimUnreferencedReaders();
                        }
            }
        Checkpoint read = Checkpoint.read(ckp);
            }
            if (rarely()) {
            () -> Checkpoint.read(getDataPath("/org/opensearch/index/checkpoint/v2.ckp.binary"))
        }
            final long pos = reader.getFirstOperationOffset() + 4 * numOps;
            List<Integer> ops = IntStream.range(translogOperations, translogOperations + extraTranslogOperations)
            .put(IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.getKey(), "-1ms")
import org.opensearch.core.common.unit.ByteSizeValue;
            } else {
                final byte[] bytes = new byte[4];
                minUncommittedOp = op + 1;
                if (isCkpFile) {
        final String translogUUID = Translog.createEmptyTranslog(
        }
            assertEquals(i, value);
            }
                            if (idGenerator.get() < maxOps) {
        translog.close();
        Path tempDir = createTempDir();
        primaryTerm.incrementAndGet();
        }
        String deleteRouting = wireVersion.onOrAfter(Version.V_3_9_0) ? "custom-routing" : null;
            failOnCopy.set(true);
        }
        final int operations = scaledRandomIntBetween(10, 100);
            String generationUUID = null;
                singleLocations.add(singleTranslog.add(op));
                if (success == false) {
        // we intentionally don't close the tlog that is in the prepareCommit stage since we try to recovery the uncommitted
    }
            byte[] bytes = new byte[256];
                    assertEquals(ex.getCause().getMessage(), "__FAKE__ no space left on device");
            );
        assertThat(total.getEarliestLastModifiedAge(), equalTo(earliestLastModifiedAge));
                if (frequently()) {
            operationsByGen.put(translog.currentFileGeneration(), ops);
                persistedSeqNos::add,
        Checkpoint corrupted = Checkpoint.emptyTranslogCheckpoint(0, 0, SequenceNumbers.NO_OPS_PERFORMED, 0);
            }
                                op = new Translog.Delete(Long.toString(id), id, primaryTerm.get());
            }
            }
                translog.add(
        if (Files.exists(translog.location().resolve(Translog.getFilename(id)))) {
            shardId,
            if (rarely()) {
                }
            try {
            stats = new TranslogStats(in);
                if (frequently()) {
        ) {
                        "expected operation" + i + " to be in the previous translog but wasn't",
        } catch (AlreadyClosedException ex) {
    public void testFatalIOExceptionsWhileWritingConcurrently() throws IOException, InterruptedException {
import java.util.function.LongConsumer;
        Translog.TranslogGeneration translogGeneration = null;
            } catch (EOFException ex) {
        }
                    brokenTranslog.getDeletionPolicy(),
import org.apache.lucene.store.AlreadyClosedException;
                    translog.add(op);
            assertFalse(tlog.syncNeeded());
            corrupted,
        final List<TranslogStats> statsList = new ArrayList<>(n);
        try (Translog brokenTranslog = create(filterFileSystemProvider.getPath(path.toUri()))) {
                translog.add(new Translog.NoOp(seqNo++, primaryTerm.get(), "test"));
            assertNotNull(maxOp);
                                    writeStarted.countDown();
        final int opsPerThread = randomIntBetween(10, 200);
import static org.hamcrest.Matchers.nullValue;
                );
                    throw new UnknownException();
                                final Translog.Location loc = writtenOps.get(expectedOp);
                () -> SequenceNumbers.NO_OPS_PERFORMED,
        );
                assertFilePresences(recoveredTranslog);
        assertEquals("tenant-routing", readBack1.routing());
            for (int i = 0; i < numOps; i++) {
                    // simulate going OOM and dying just at the wrong moment.
/*
    private AtomicLong globalCheckpoint;
                } else {
import org.opensearch.common.settings.Settings;
                if (success == false) {
                    }
                }
            // Add will not block even though we are currently writing/syncing
    public void testFailWhileCreateWriteWithRecoveredTLogs() throws IOException {
        // file in a consistent way, in order to simplify checking code.
        translog = create(translogDir);
        ) {
        final AtomicLong lastCommittedLocalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
        assertEquals(ops.size(), readOperations.size());
                            syncedDocs.clear();
                            opCount++;
        translog.rollGeneration();
        final FilterFileSystemProvider filterFileSystemProvider = new FilterFileSystemProvider(
                    throwUnknownException,
                    // use the latest source of op with the same seq# - therefore no break
    public void testLocationHashCodeEquals() throws IOException {
                        @Override
                    );
        primaryTerms.add(primaryTerm.get()); // We always create an empty translog.
            );
        // if a previous test failed we clean up things here
            assertThat(persistedSeqNos, empty());
                    shardId,
                translog.add(new Translog.Index("" + op, op, primaryTerm.get(), Integer.toString(op).getBytes(Charset.forName("UTF-8"))))
        // Write deletes with and without routing to a real translog, read them back
                            // we have to sync here first otherwise we don't know if the sync succeeded if the commit fails
    public void testTranslogWriterCanFlushInAddOrReadCall() throws IOException {
            for (int j = 0; j < operations; j++) {
                }
                }
    }
        };
        final TranslogDeletionPolicy deletionPolicy = translog.getDeletionPolicy();
                                } catch (InterruptedException e) {
        final byte[] singleBytes;
            }
        for (long gen = translog.getMinFileGeneration(); gen < translog.currentFileGeneration(); gen++) {
        int translogOperations = randomIntBetween(10, 100);
                assertNotNull(translogGeneration.translogUUID);
                config,
                    int upTo = sync ? translogOperations : prepareOp;
 * under the License.
        String string;
            IllegalArgumentException.class,
            } finally {
                        logger.error("unexpected error while closing view, after failure", inner);
            TranslogDeletionPolicy deletionPolicy = createTranslogDeletionPolicy();
            if (current.getCause() != null) {
        final AlreadyClosedException alreadyClosedException = expectThrows(AlreadyClosedException.class, () -> failableTLog.newSnapshot());
                );
        final List<Translog.Operation> ops = new ArrayList<>(n);
            SequenceNumbers.NO_OPS_PERFORMED,
                downLatch,
            writer.sync();
            SequenceNumbers.NO_OPS_PERFORMED,
import java.util.LinkedList;
                    LineFileDocs lineFileDocs = new LineFileDocs(random()); // writes pretty big docs so we cross buffer boarders regularly
        final String translogUUID = translog.getTranslogUUID();
                assertFalse(translog.isOpen());
        assertEquals(1, deserialized.seqNo());
            assertThat(snapshot, SnapshotMatchers.size(0));
        }
            fail("Should throw exception for missing operations");
        }
                    forwardTranslog.add(op);
        translog.rollGeneration();
    /**
                TranslogOperationHelper.DEFAULT,
            }
    /**
                    maxSeqNoPerGeneration.compute(
        if (randomBoolean()) { // recover twice
import java.util.concurrent.BlockingQueue;
            blocker.countDown();
                fail.onceFailedFailAlways();
            assertThat(stats.getEarliestLastModifiedAge(), greaterThan(0L));
        try (Translog translog2 = create(createTempDir())) {
                }
                } else {
                            Integer.toString(opsSynced).getBytes(Charset.forName("UTF-8"))
    }
                        }
            }
                writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 5);
        try (Translog translog = getFailableTranslog(fail, config)) {
        // New version writes with routing, new version reads with routing preserved
            translog.getDeletionPolicy().setLocalCheckpointOfSafeCommit(2);
import static org.opensearch.index.translog.SnapshotMatchers.containsOperationsInAnyOrder;
    public void testTruncatedTranslogs() throws Exception {
                assertThat(snapshot.totalOperations(), equalTo(0));
                    errors.add(e);
                    fail,
        final int maxOps = randomIntBetween(200, 1000);
                }
        final TranslogDeletionPolicy deletionPolicy = createTranslogDeletionPolicy(translogConfig.getIndexSettings());
            final String threadName = "writer_" + i;
        fail.failNever();
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 1);
                )
        );
        translog.trimUnreferencedReaders();
            }
            translog.add(
        final int maxAttempts = 10;
        }
            // all good
            // ~300 byte source, representative of an http_logs document body
            operationsInLastGen++;
            config.getTranslogPath(),
                primaryTerm::get,
                    config,
            int initialWriteCalls = writeCalls.get();
        final int generations = randomIntBetween(2, 20);
                writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 5);
                locations.add(
                firstGenOps = ops;
        translogDir = createTempDir();
import java.util.IdentityHashMap;
            }
                () -> SequenceNumbers.NO_OPS_PERFORMED,
                config,
                failableTLog.add(operation);
            }
            if (rarely()) {
            threads[i] = new TranslogThread(
            Origin.PRIMARY,
        for (int op = 0; op < extraDocs; op++) {
import org.apache.lucene.codecs.CodecUtil;
            buffer.flip();
                            generationSeenSeqNos.add(Tuple.tuple(operation.seqNo(), operation.primaryTerm()));
        }
        private final AtomicLong seqNoGenerator;
    public static Translog.Location max(Translog.Location a, Translog.Location b) {
                            } else {
            String ascii = randomAlphaOfLengthBetween(1, 50);
                fileChannels.add(channel);
                out.writeInt(i);
    public void testUncommittedOperations() throws Exception {
            singleTranslog.sync();
        final Translog translog = new LocalTranslog(
                    );
        final CountDownLatch downLatch = new CountDownLatch(1);
                .map(t -> t.getPrimaryTerm())
        Translog.Delete readBack2 = (Translog.Delete) translog.readOperation(loc2);
                @Override
        assertThat(e, hasToString(containsString("uncommittedSizeInBytes must be >= 0")));
    /**
                    TranslogOperationHelper.DEFAULT,
            assertEquals(
            false,
        List<TranslogReader> readers = new ArrayList<>();
            0,
        assertThat(
        for (int gen = 0; gen < generations; gen++) {
        try {
                }
                        + "\"total_upload_size\":{\"started_bytes\":0,\"failed_bytes\":0,\"succeeded_bytes\":0}"
            }
                    translogUUID,
        primaryTerm.set(randomLongBetween(1, Integer.MAX_VALUE));
                channelFactory
    private Translog create(Path path) throws IOException {
    }
                opsHaveValidSequenceNumbers = opsHaveValidSequenceNumbers || !rarely();
        } catch (MockDirectoryWrapper.FakeIOException ex) {
            locations.add(translog.add(new Translog.Index("" + op, op, primaryTerm.get(), ascii.getBytes("UTF-8"))));
        translog.add(new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
                    if (failedToSyncCheckpoint.get()) {
            void syncBeforeRollGeneration() {
    }
                        }
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
        final String translogUUID = translog.getTranslogUUID();
                writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), randomNonNegativeLong());
        final TranslogConfig forwardConfig = getTranslogConfig(tempDir, settings);
        translog.close();
        }
import java.util.Queue;
                // expected...
        Translog.Delete deserialized = (Translog.Delete) Translog.Operation.readOperation(in);
        // force flushing and updating of stats
            randomBoolean(),
        return getFailableTranslog(fail, config, partialWrites, throwUnknownException, translogUUID, deletionPolicy, null);
                        assertEquals(loc.hashCode(), location.hashCode());
        }
        translog.add(
    public void testNegativeNumberOfOperations() {
    }
            () -> new TranslogStats.Builder().numberOfOperations(1)
        };
                            }
            Translog translog = new LocalTranslog(
            assertThat(snapshot1, SnapshotMatchers.size(1));
                    LongConsumer persistedSequenceNumberConsumer
        addToTranslogAndList(translog, ops, new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
                assertFalse("the last call to ensureSycned synced all previous ops", translog.syncNeeded());
            }
                }
                    assertNotNull("operation " + i + " must be non-null", operation);
            TranslogException.class,
import org.opensearch.index.translog.Translog.Location;
                // some FS don't like our random file names -- let's just skip these random choices
                .uncommittedSizeInBytes(randomIntBetween(1, 4096))
                minSeqNo = SequenceNumbers.min(minSeqNo, seqNo);
                                op = new Translog.Index("" + id, id, primaryTerm.get(), new byte[] { (byte) id });
                                try {
            temp.getShardId(),
                        }
            Translog.Index op = new Translog.Index(randomAlphaOfLength(10), i, primaryTerm.get(), new byte[] { 1 });
        }
                break;
                    primaryTermSupplier,
                    assertEquals(
                Translog translog = new LocalTranslog(
            return super.write(src, position);
                    builder.toString()
            for (Throwable ex : threadExceptions) {
        BytesStreamOutput out = new BytesStreamOutput();
                translogGeneration = translog.getGeneration();
            }
                    // failed - that's ok, we didn't even create it or it was corrupted from partial writes
            }
    protected Translog openTranslog(TranslogConfig config, String translogUUID) throws IOException {
        for (int i = 0; i < 5; i++) {
                opsSynced++;
            singleDir,
                    snapshot.next();
                assertThat(deletionPolicy.getTranslogRefCount(minGen), equalTo(0L));
                translog.rollGeneration();
                final Translog failableTLog = getFailableTranslog(
                downLatch.await();
            deletionPolicy,
        translog.add(new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
            "",
            for (long i = 0; i < minRetainedReader.generation; i++) {
                seqNo -> {},
            assertEquals(totOps, toSeqNo - fromSeqNo + 1);
                if (success == false) {
        int translogOperations = randomIntBetween(10, 100);
        }
                LongSupplier globalCheckpointSupplier,
            buffer.flip();
                    logger.error(() -> new ParameterizedMessage("--> writer [{}] had an error", threadName), e);
            Translog.Operation maxOp = null;
        for (int run = 0; run < runs; run++) {
            primaryTerm.get()
            )
        }
                        public void force(boolean metaData) throws IOException {
                );
import static org.hamcrest.Matchers.endsWith;
            writers[i].start();
        public int read(ByteBuffer dst) throws IOException {
        // don't copy the new file
                        if (id % flushEveryOps == 0) {
        return stats;
        long minGenForRecovery = 1L;
                threads[t] = new Thread(() -> {
            () -> new TranslogStats.Builder().numberOfOperations(1)
        }
        Translog.TranslogGeneration translogGeneration = translog.getGeneration();
            try (Translog.Snapshot snapshot = new TestTranslog.SortedSnapshot(translog.newSnapshot())) {
            }
            .put(IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.getKey(), randomIntBetween(-1, 2048) + "b")
                primaryTerm::get,
                    retentionLock = translog.acquireRetentionLock();
                for (int i = 0; i < upTo; i++) {
        );
                }
                fail.failAlways();
            assertNull(snapshot.next());
        Translog.Delete readBack1 = (Translog.Delete) translog.readOperation(loc1);
     * A local-only translog must keep the layout it has always had: no footer, so the file is exactly as long as
                        Translog.Operation operation;
                        if (threadExceptions[i] != null) {
                    );
            }
            // disable retention so we trim things
                                threadId + "_" + opCount,
            seenSeqNos.retainAll(expected);
        }
                seqNos.add(seqNo);
            IndexSettingsModule.newIndexSettings(shardId.getIndex(), settings),
        AtomicInteger truncations = new AtomicInteger(0);
        final String translogUUID = translog.getTranslogUUID();
        LineFileDocs lineFileDocs = new LineFileDocs(random()); // writes pretty big docs so we cross buffer boarders regularly
                config,
        out = new BytesStreamOutput();
                    errors.add(e);
            TranslogOperationHelper.DEFAULT,
        try {
                        public void force(boolean metaData) throws IOException {
            assertNotNull(delete);
        }
                for (int j = 0; j < translogOperations; j++) {
        primaryTerms.add(primaryTerm.get());
                () -> SequenceNumbers.NO_OPS_PERFORMED,
                if (failOnCopy.get() && source.toString().endsWith(Translog.CHECKPOINT_SUFFIX)) {
        final TranslogDeletionPolicy deletionPolicy = translog.getDeletionPolicy();
            assertThat(snapshot, SnapshotMatchers.equalsTo(expectedSeqNo));
                            default:
            TranslogConfig config = getTranslogConfig(tempDir);
        document.add(idField);
            assertThat(snapshot, SnapshotMatchers.equalsTo(ops));
                .uncommittedOperations(-1)
        final TranslogDeletionPolicy deletionPolicy = createTranslogDeletionPolicy(config.getIndexSettings());
            IOUtils.closeWhileHandlingException(toClose);
                        src.limit(randomIntBetween(pos, limit));
                        + ",\"remote_store\":{\"upload\":{"
        final Set<Long> persistedSeqNos = new HashSet<>();
            // at least one roll + inc of primary term has to be there - otherwise trim would not take place at all
        Path tempDir = createTempDir();
                                threadId + "_" + opCount,
                        synchronized (signalReaderSomeDataWasIndexed) {
                    2L,
            translogUUID,
 * compatible open source license.
        final long closedGeneration = translog.currentFileGeneration() - 1;
                        new Translog.Index(
            total.estimatedNumberOfOperations(),
    }
        try (Translog.Snapshot snapshot = translog.newSnapshot(fromSeqNo, toSeqNo)) {
                    TranslogOperationHelper.DEFAULT,
            null
        }
            } else {
            while ((next = snap.next()) != null) {
                primaryTerm::get,
                );
        translog.close();
    public void testWithRandomException() throws IOException {
        }
    public void testBatchAddEdgeCounts() throws IOException {
        translog.add(new Translog.Delete("3", 2, primaryTerm.get()));
            seqNo -> {},
                translog.add(
        assertFalse(translog.isOpen());
        }
                IOUtils.close(reader);
            deletionPolicy.setRetentionAgeInMillis(randomBoolean() ? 100 : -1);
        Collections.sort(collect);
            StandardOpenOption.CREATE_NEW
        assertNotNull(readBack2);
            for (long seqNo : seqNos) {
        }
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    translogUUID,
import org.opensearch.test.OpenSearchTestCase;
                    generationUUID,
                        Translog.Operation next = snapshot.next();
        }
                    translog.rollGeneration();
            try (Translog translog = openTranslog(config, uuid); Translog.Snapshot snapshot = translog.newSnapshot()) {
                    IOUtils.closeWhileHandlingException(channel);
                    translog.add(
            assertEquals(2, translog.currentFileGeneration());
        // Old version writes without routing, new version reads with routing=null
                // we are the last location so everything should be synced
            FileChannel::open,
        assertThat(e, hasToString(containsString("earliestLastModifiedAge must be >= 0")));
    }
                        }
            assertThat(TestTranslog.drainSnapshot(snapshot, false), equalTo(expectedOps));
        globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            final Set<Tuple<Long, Long>> seenSeqNos = new HashSet<>();
            }
    public void testTranslogCorruption() throws Exception {
import org.opensearch.test.IndexSettingsModule;
            final TranslogStats stats = stats();
                .translogSizeInBytes(-1)
        for (int op = 0; op < translogOperations; op++) {
        Engine.Delete eDelete = new Engine.Delete(
        translog.getDeletionPolicy().setLocalCheckpointOfSafeCommit(randomLongBetween(3, Long.MAX_VALUE));
    }
                        .filter(allOp -> allOp instanceof Translog.Index && allOp.seqNo() == op)
        translog = new LocalTranslog(
        locs.add(addToTranslogAndList(translog, ops, new Translog.Index("3", 2, primaryTerm.get(), new byte[] { 1 })));
            }
                translogOperations,
                    );
            };
            assertThat(snapshot.totalOperations(), equalTo(1));
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
            }
            thread.join();
        );
        final TranslogConfig config = getTranslogConfig(tempDir);
                // use ongoing primaryTerms - or the same as it was
                threadExceptions
            fail("invalid pattern");
            assertThat(stats.estimatedNumberOfOperations(), equalTo(4));
            ((TranslogReader) reader).close();
                    brokenTranslog.getTranslogUUID(),
import java.nio.file.FileAlreadyExistsException;
                    assertNotNull("operation " + i + " must be non-null", next);
            assertEquals(2048, value);
                    // captures the last committed checkpoint, while holding the view, simulating
                translogUUID,
                    );
        final List<Exception> errors = new CopyOnWriteArrayList<>();
        added.await();
        assertThat(total.getUncommittedOperations(), equalTo(0));
        Engine.Index eIndex = new Engine.Index(
    }
        } catch (TranslogException ex) {
        translog.add(new Translog.Index("2", 1, primaryTerm.get(), new byte[] { 2 }));
                primaryTerm::get,
        IOUtils.rm(translog.location()); // delete all the locations
        return new LocalTranslog(
                assertNull(snapshot.next());
            }
            assertFalse(translog.syncNeeded());
            final int numOps = randomIntBetween(8, 128);
    }
                assertNotNull(translogGeneration);
            writer.sync();
                    )
            assertThat(stats.getUncommittedOperations(), equalTo(1));
                Translog recoveredTranslog = new LocalTranslog(
                        try {
        }
        translog.sync();
    private LongConsumer getPersistedSeqNoConsumer() {
                        unsynced.add(doc);
    }
    }
            assertThat(persistedSeqNos, empty());
    public void testRecoverWithUnbackedNextGenAndFutureFile() throws IOException {
        };
                }
    public void testOldestEntryInSeconds() {
            config,
                for (int opCount = 0; opCount < opsPerThread; opCount++) {
                                // we're committing - is still present when we're committing
            locations.add(translog.add(new Translog.Index("" + op, op, primaryTerm.get(), ascii.getBytes("UTF-8"))));
                    throw new MockDirectoryWrapper.FakeIOException();
            List<String> unsynced = new ArrayList<>();
import static org.hamcrest.Matchers.not;
        file = translogDir.resolve(randomNonTranslogPatternString(1, Translog.TRANSLOG_FILE_PREFIX.length() - 1));
                seqNo -> {},
            Translog batchTranslog = openTranslog(batchConfig, batchUUID)
        final CountDownLatch downLatch = new CountDownLatch(1);
                )
                            primaryTerm.get(),
        long minSeqNo = SequenceNumbers.NO_OPS_PERFORMED;
                    }
        document.add(seqID.seqNoDocValue);
                } catch (TranslogCorruptedException e) {
    }
            false,
            List<Long> seqNos = LongStream.range(startSeqNo, startSeqNo + randomInt(100)).boxed().collect(Collectors.toList());
        for (int i = 0; i < n; i++) {
        if (randomBoolean()) {
                maxSeqNo = SequenceNumbers.max(maxSeqNo, seqNo);
            for (Translog.Operation op = snapshot.next(); op != null; op = snapshot.next()) {
            signalReaderSomeDataWasIndexed.notifyAll();
                final Checkpoint readerCheckpoint = reader.getCheckpoint();
            DataOutput out = EndiannessReverserUtil.wrapDataOutput(new ByteArrayDataOutput(bytes));
        assertThat(translog.stats().getUncommittedOperations(), equalTo(retainedOps));
        when(w.getLastModifiedTime()).thenReturn(fixedTime - period);
        document.add(seqID.seqNo);
                    failableTLog.close();
        for (int i = 0; i < operations; i++) {
        if (errors.size() > 0) {
            fail("WTF");
import org.opensearch.index.engine.MissingHistoryOperationsException;
            final TranslogStats stats = new TranslogStats.Builder().numberOfOperations(randomIntBetween(1, 4096))
                    if (fromSeqNo <= op.seqNo() && op.seqNo() <= toSeqNo && seenSeqNos.add(op.seqNo())) {
            idGenerator.set(Long.MAX_VALUE);
    }
                );
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
            }
            assertThat(translog.getMinFileGeneration(), equalTo(minGenForRecovery));
        // we add N+1 and N+2 to ensure we only delete the N+1 file and never jump ahead and wipe without the right condition
            randomPrimaryTerm,
            byte[] bytes = new byte[4];
            locations.add(
        final TranslogDeletionPolicy deletionPolicy = translog.getDeletionPolicy();
        Files.createFile(config.getTranslogPath().resolve("translog-" + (read.generation + 1) + ".tlog"));
            }
            }
        {
            if (generationUUID == null) {
        translog.close();
                translog.getDeletionPolicy().setLocalCheckpointOfSafeCommit(op);
    }
        translog.rollGeneration();
                            logger.info("Translog exception", threadExceptions[i]);
     * concern only (see {@link TranslogFooter}).
            new ByteSizeValue(10 + randomInt(128 * 1024), ByteSizeUnit.BYTES)
        }
            }
        Path tempDir = createTempDir();
                .collect(Collectors.toList());
    /**
                // don't do partial writes for checkpoints we rely on the fact that the bytes are written as an atomic operation
        );
        }
                TranslogOperationHelper.DEFAULT,
                                expectedOps.remove(op);
        int op = 0;
    public void testSnapshotDedupOperations() throws Exception {
                createTranslogDeletionPolicy(forwardConfig.getIndexSettings()),
                    throw new AssertionError(e);
        final Thread[] readers = new Thread[randomIntBetween(1, 3)];
            translog.add(new Translog.NoOp(randomNonNegativeLong(), 0, "test'"));
                assertFalse("no sync needed since no operations in current translog", translog.syncNeeded());
                builder.endObject();
        final AtomicBoolean run = new AtomicBoolean(true);
    public void expectIntactTranslogByDefault() {
        }
        assertThat(alreadyClosedException.getMessage(), is("translog is already closed"));
            threads[i].start();
            }
            addToTranslogAndList(translog, ops, new Translog.Index("3", 2, primaryTerm.get(), new byte[] { 3 }));
    public void testRandomExceptionsOnTrimOperations() throws Exception {
                    new Translog.Index("" + op, seqNo, primaryTerm.get(), Integer.toString(seqNo).getBytes(Charset.forName("UTF-8")))
            shardId,
        IOUtils.close(writer);
            assertNull(snapshot.next());
        }
                    }
                }
            0
    protected TranslogStats stats() throws IOException {
            random(),
            if (hasCircularReference(alreadyClosedException)) {
                    new Translog.Index(Integer.toString(op), op, primaryTerm.get(), Integer.toString(op).getBytes(Charset.forName("UTF-8")))
        int retainedOps = Stream.concat(translog.getReaders().stream(), Stream.of(translog.getCurrent()))
                // expected
            inMemoryTranslog.trimOperations(primaryTerm.get(), maxTrimmedSeqNo);
        final int threadCount = randomIntBetween(1, 5);
            temp.getTranslogPath(),
        assertThat(failableTLog.getTragicException(), equalTo(expectedException));
                if (throwUnknownException) {
            Translog tlog = new LocalTranslog(
            );
            if (rarely()) {
                }
        final int operations = randomIntBetween(1, 4096);
        TranslogConfig config = getTranslogConfig(tempDir);
                assertFalse("the last call to ensureSycned synced all previous ops", translog.syncNeeded());
        Path tempDir = createTempDir();
        );
            assertFileIsPresent(translog, i);
        };
import static org.mockito.Mockito.when;
        }
        Path file = translogDir.resolve(Translog.TRANSLOG_FILE_PREFIX + id + ".tlog");
        // engine blows up, after committing the above generation
                }
            Origin.PRIMARY,
        final byte[] batchBytes;
                        + ",\"earliest_last_modified_age\":"
                translog.ensureSynced(location);
                                .append(" operations from [")
            Collections.shuffle(locations, random());
            assertEquals("payload mismatch for operation 2", Integer.parseInt(secondOp.getSource().source.utf8ToString()), 2);
            seqNo -> {},
            assertSame(translog.getTragicException(), ex.getCause());
        long id = randomIntBetween(0, Integer.MAX_VALUE);
                    IOUtils.closeWhileHandlingException(delegate);
            writer.sync();
        }
        protected Translog.Location add(Translog.Operation op) throws IOException {
                opsPerThread,
                }
        }
            assertEquals(lastSynced + 1, reader.totalOperations());
            );
            randomPrimaryTerm,
                "lastCommitted must be 2 less than current - we never finished the commit",
            TranslogOperationHelper.DEFAULT,
        logger.info("testing with [{}] threads, each doing [{}] ops", threadCount, opsPerThread);
                translog.rollGeneration();
                views.push(new ArrayList<>());
            final int generations = randomIntBetween(2, 20);
                        assertNotNull("operation " + i + " must be non-null synced: " + sync, next);
        for (int op = 0; op < translogOperations; op++) {
            assertThat(stats.getUncommittedOperations(), equalTo(0));
        int translogOperations = 0;
                assertThat(persistedSeqNos, empty());
        Translog.Delete deleteWithRouting = new Translog.Delete("doc-1", 1, 1, 1, "tenant-abc");
            assertThat(snapshot, SnapshotMatchers.equalsTo(ops));
 * license agreements. See the NOTICE file distributed with
        ) {
                globalCheckpointSupplier,
        }
            }
    public void testRecoveryUncommitted() throws IOException {
        int translogOperations = randomIntBetween(10, 100);
        assertThat(total.getEarliestLastModifiedAge(), equalTo(0L));
                        String doc = lineFileDocs.nextDoc().toString();
        final String translogUUID = Translog.createEmptyTranslog(path, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
            long startSeqNo = randomLongBetween(0, Integer.MAX_VALUE);
            if (rarely()) {
            deletionPolicy.setRetentionAgeInMillis(3600 * 1000);
            // only randomize between nog age retention and a long one, so failures will have a chance of reproducing
            while (views.isEmpty() == false) {
        translog.getDeletionPolicy().setRetentionSizeInBytes(1024 * 1024);
        // Create a separate translog instance with forward reading enabled
        assertNotNull(readBack1);
        }
                translog.rollGeneration();
                    localCheckpointOfSafeCommit = failableTLog.getDeletionPolicy().getLocalCheckpointOfSafeCommit();
                    + "but got Checkpoint{offset=0, numOps=0, generation=0, minSeqNo=-1, maxSeqNo=-1, globalCheckpoint=-1, "
        );
                        if (id % writers.length == threadId) {
            for (int i = 0; i < locations.size(); i++) {
                @Override
        synchronized (signalReaderSomeDataWasIndexed) {
        final Checkpoint checkpoint = randomCheckpoint();
        if (translogUUID == null) {
        final Set<Throwable> seen = Collections.newSetFromMap(new IdentityHashMap<>());
        try (
            }
            // if we have a LeakFS here we fail if not all resources are closed
                    assertNotNull("operation " + i + " must be non-null", next);
                        // slow down things a bit and spread out testing..
            } while (seenSeqNos.contains(seqNo));
        );
        assertThat("all file channels have to be closed", fileChannels.stream().filter(f -> f.isOpen()).findFirst().isPresent(), is(false));
            final Translog.Operation old = operations.put(operation.seqNo(), operation);
 * Licensed to Elasticsearch under one or more contributor
                for (int i = 0; i < writtenOperations.size(); i++) {
        final long seqNo = randomLongBetween(0, Integer.MAX_VALUE);
                    for (int opsAdded = 0; opsAdded < numOps; opsAdded++) {
        in.setVersion(oldVersion);
        document.add(versionField);
            fail.failRandomly();
                () -> SequenceNumbers.NO_OPS_PERFORMED,
            // last attempt we have to make roll as well - otherwise could skip trimming as it has been trimmed already
                translogUUID,
                    case DELETE:
        IllegalArgumentException e = expectThrows(
        long firstId = translog.currentFileGeneration();
        for (int i = 0; i < threadCount; i++) {
import org.apache.logging.log4j.message.ParameterizedMessage;
            try (ReleasableLock ignored = translog.writeLock.acquire()) {
            );
import org.opensearch.cluster.metadata.IndexMetadata;
                translogUUID,
                writtenOperations,
        }
        }
            assertThat(stats.getUncommittedOperations(), equalTo(4));
        int extraDocs = randomIntBetween(10, 15);
                            Integer.toString(opsSynced).getBytes(Charset.forName("UTF-8"))
                    primaryTerm.get()
        try {
                    throw new MockDirectoryWrapper.FakeIOException();
        String uuid = translog.getTranslogUUID();
                    createTranslogDeletionPolicy()
            AtomicLong seqNoGenerator,
                    unsynced.clear();
            }
        };
        Path tempDir = createTempDir();
            try (Translog.Snapshot snapshot = forwardTranslog.newSnapshot()) {
    public void assertFileIsPresent(Translog translog, long id) {
                    assertTrue(ex.toString(), ex instanceof IOException || ex instanceof AlreadyClosedException);
                } catch (TranslogException | MockDirectoryWrapper.FakeIOException | TranslogCorruptedException ex) {
                translog.trimUnreferencedReaders();
                }
            for (Location location : locations) {
            translog.getTranslogUUID(),
                failed = true;
            addToTranslogAndList(translog, ops, new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
                if (rarely()) {
            seqNos.add(Tuple.tuple(repeatingTermSeqNo, terms.get(repeatingTermSeqNo)));
        final int rolls = randomIntBetween(1, 16);
        final List<Translog.Location> singleLocations = new ArrayList<>();
                translogUUID,
        final TranslogConfig singleConfig = new TranslogConfig(
                translog.rollGeneration();
        final ByteSizeValue bufferSize = randomFrom(
            )
                new Translog.Index("" + op, seqNo, primaryTerm.get(), Integer.toString(seqNo).getBytes(Charset.forName("UTF-8")))
                }
        long nextSeqNo = populateTranslogOps(false);
                .earliestLastModifiedAge(1)
            }
        );
            assertThat(snapshot2.totalOperations(), equalTo(ops.size()));
            translog.add(new Translog.Index("1", 1, primaryTerm.get(), new byte[] { 1 }));
            try (Translog.Snapshot snapshot = this.translog.newSnapshot()) {
        final long generation = translog.currentFileGeneration();
            TranslogCorruptedException.class,
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
            ) {
                    final Translog.Operation read = snapshot.next();
                    // boom now we failed
            assertThat(stats.getUncommittedOperations(), equalTo(4));
                }
            try (Translog.Snapshot snapshot = translog.newSnapshot()) {
        }
        final Settings settings = Settings.builder()
                deletionPolicy,
                seqNo = ++count;
        out = new BytesStreamOutput();
        translog.close();
            // 3. Read the on-disk write-generation file from each translog while both are still open (after sync).
                    writtenOperations.add(new TestTranslog.LocationOperation(op, loc));
            tlog.add(new Translog.Index("" + 1, 1, primaryTerm.get(), Integer.toString(2).getBytes(Charset.forName("UTF-8"))));
                config,
        for (int op = 0; op < translogOperations; op++) {
                Translog.Operation operation;
        }
            }
        }
                    assertNotNull("operation " + i + " must be non-null synced: " + sync, next);
            Collections.sort(writtenOperations, (a, b) -> a.location.compareTo(b.location));
            expectThrows(IOException.class, translog::rollGeneration);
                assertThat(snapshot, containsOperationsInAnyOrder(effectiveOperations));
        file = translogDir.resolve(Translog.TRANSLOG_FILE_PREFIX + id);
                        translog.sync();
        assertFileIsPresent(translog, 2);
        ) {
                            }
    }
            )
    }
            config,
            toClose.add(snapshot);
     */
        } finally {
                    try {
                    Translog.Operation op;
                    }
            addToTranslogAndList(translog, ops, new Translog.Index("2", 1, primaryTerm.get(), new byte[] { 2 }));
        final TranslogConfig temp = getTranslogConfig(tempDir);
        long toSeqNo = Math.min(nextSeqNo - 1, fromSeqNo + 15);
            );
        if (a <= b) {
        );
                    channel = new FilterFileChannel(delegate) {
        }
    }
        translog.add(new Translog.Index("3", 2, primaryTerm.get(), new byte[] { 3 }));
import java.util.function.LongSupplier;
import java.nio.file.InvalidPathException;
                            Checkpoint checkpoint = translog.getLastSyncedCheckpoint();
        for (int op = 0; op < translogOperations; op++) {
            () -> SequenceNumbers.NO_OPS_PERFORMED,
            assertTrue("Should find delete without routing in snapshot", foundUnrouted);
                if (throwUnknownException) {
            long lastModifiedAge = System.currentTimeMillis() - translog.getCurrent().getLastModifiedTime();
                            acquireRetentionLock();
            Translog translog = new LocalTranslog(
            createTranslogDeletionPolicy(),
    public void testTranslogWriterFsyncedWithLocalTranslog() throws IOException {
                null
                null
            if (commit && op < translogOperations - 1) {
            ops.add(test);
                    2L,
            }
            TranslogException.class,
        IllegalArgumentException e = expectThrows(
            shardId,
        {
            assertFalse(tlog.syncNeeded());
            false
                TranslogDeletionPolicy deletionPolicy,
            () -> new LocalTranslog(
            createTranslogDeletionPolicy(config.getIndexSettings()),
            Translog.Location location = translog.add(
        }
        translog.add(new Translog.Index("" + 0, 0, primaryTerm.get(), Integer.toString(0).getBytes(Charset.forName("UTF-8"))));
                        if (randomFloat() < 0.1) {
        final int generations = between(2, 20);
                            }
        final ChannelFactory channelFactory = (file, openOption) -> {
            assertThat(stats.getUncommittedSizeInBytes(), equalTo(176L));
            }
                    assertEquals(ex.getMessage(), "simulated");
        final CountDownLatch added = new CountDownLatch(randomIntBetween(10, 100));
            }
            }
                    throw new MockDirectoryWrapper.FakeIOException();
                    assertEquals(i, Integer.parseInt(next.getSource().source.utf8ToString()));
    public static Translog.Location randomTranslogLocation() {
            int seqNo = ++count;
                } else {
            SequenceNumbers.UNASSIGNED_SEQ_NO,
                .collect(Collectors.toList())
            translog.sync();
    // A default primary term is used by translog instances created in this test.
                    translogUUID,
                null
            }, threadName);
                    "expected this to be the first roll (1 gen is on creation, 2 when opened)",
            assertFileIsPresent(translog, gen);
                public void force(boolean metaData) throws IOException {
        final TranslogDeletionPolicy deletionPolicy,
                }
                null
    public void assertFileDeleted(Translog translog, long id) {
            }
        Files.createFile(config.getTranslogPath().resolve("translog-" + (read.generation + 1) + ".tlog"));
            VersionType.INTERNAL,
                threadId,
                .boxed()
            for (int gen = 0; gen < generations; gen++) {
            long maxTrimmedSeqNo = randomInt(allOperations.size());
    }
                        + ",\"uncommitted_operations\":4,\"uncommitted_size_in_bytes\":"
        );
        }
        long expectedMaxSeqNo = maxSeqNoPerGeneration.entrySet()
    }
                Translog.Location location = RandomPicks.randomFrom(random(), locations);
            final List<Translog.Operation> expectedSeqNo = new ArrayList<>();
            fail.failNever();
    }
        // one extra roll to make sure that all ops so far are available via a reader and a translog-{gen}.ckp
                throw new MockDirectoryWrapper.FakeIOException();
                assertEquals("__FAKE__ no space left on device", ex.getMessage());
                earliestLastModifiedAge = stats.getEarliestLastModifiedAge();
            primaryTerm.get()
        barrier.await();
                translog.rollGeneration();
        try (
        final String batchUUID = Translog.createEmptyTranslog(batchDir, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(shardId.getIndex(), settings);
            assertThat(stats.getUncommittedOperations(), equalTo(2));
                                long localCheckpoint = tracker.getProcessedCheckpoint();
            Collection<Translog.Operation> effectiveOperations = inMemoryTranslog.operations();
    public void testTranslogWriter() throws IOException {
                                    // Ignore
                .earliestLastModifiedAge(randomIntBetween(1, 1 << 20))
        }).getMessage(), containsString(translogDir.toString()));
        }
        final AtomicBoolean failedToSyncCheckpoint = new AtomicBoolean();
        Translog.Operation.writeOperation(out, deleteWithRouting);
import org.junit.After;
/*
            try {
                .translogSizeInBytes(1)
        };
            this.fail = fail;
        assertThat(translog.getMinFileGeneration(), equalTo(1L));
        Version oldVersion = VersionUtils.randomVersionBetween(
            }
    }
        int translogOperations = randomIntBetween(10, 100);
            .put(IndexSettings.INDEX_TRANSLOG_READ_FORWARD_SETTING.getKey(), true)
            for (Long seqNo : batch) {
import java.nio.file.Path;
                if (writtenOperations.size() != snapshot.totalOperations()) {
                    deletionPolicy,
                totOps++;
        return new Translog.Location(randomLong(), randomLong(), randomInt());
        final boolean partialWrites,
        @Override
                    TranslogOperationHelper.DEFAULT,
            deletionPolicy.setLocalCheckpointOfSafeCommit(localCheckpointOfSafeCommit);
        }
                    primaryTerm.incrementAndGet();
            }
                                throw new AssertionError("unsupported operation type [" + type + "]");
        final LocalCheckpointTracker tracker = LocalCheckpointTrackerTests.createEmptyTracker();
    }
            shardId,
            fail("already closed");
            )
        }
                    for (int i = 0; i < upTo; i++) {
                void closeRetentionLock() throws IOException {
                            StringBuilder missed = new StringBuilder("missed ").append(expectedOps.size())
        for (int op = 0; op < translogOperations; op++) {
        }
        );
            assertNotNull(translogGeneration);
                new Translog.Index(Integer.toString(op), op, primaryTerm.get(), Integer.toString(op).getBytes(Charset.forName("UTF-8")))
                    assertNull(next);
        private final TestTranslog.FailSwitch fail;
                }
    }
        }
            path.getFileSystem().provider().getScheme(),
                translog,
        for (long gen = 1; gen < translog.currentFileGeneration(); gen++) {
        }
                "] is corrupted, checkpoint file translog-3.ckp already exists but has corrupted content: expected Checkpoint{offset=2750, "
        assertEquals(ops, readOperations);
            shardId,
                    Translog.Operation next = snapshot.next();
    public void testConcurrentWriteViewsAndSnapshot() throws Throwable {
            ) {
                failSwitch.failAlways();
        int count = 0;
        if (translogGeneration == null) {
        }
        assertEquals(translogOperations + 1, translog.totalOperations());
            )
            }
            assertThat(translog.totalOperations(), equalTo(totalOperations));
                        "expected operation" + i + " to be in the current translog but wasn't",
        for (int i = 0; i < rolls; i++) {
        final TranslogDeletionPolicy deletionPolicy
                persistedSeqNos::add,
            final int numOps = randomIntBetween(100, 200);
        {
                translog.add(
        Thread[] threads = new Thread[threadCount];
        ) {
import org.opensearch.core.index.shard.ShardId;
                        } catch (Exception e) {
            assertFileDeleted(translog, gen);
        final BlockingQueue<TestTranslog.LocationOperation> writtenOperations = new ArrayBlockingQueue<>(threadCount * opsPerThread);
                // Since the buffer is full, this will flush before performing the add.
            }
        );
            }
            .filter(r -> r.getGeneration() == closedGeneration)
        }
                        new Translog.Index("" + op, op, primaryTerm.get(), Integer.toString(op).getBytes(Charset.forName("UTF-8")))
                            }
            assertEquals(3, translogFsyncCalls.get());
                lastSynced = op;
                new DefaultTranslogDeletionPolicy(-1, -1, 0),
            } finally {
        Translog.Index serializedIndex = (Translog.Index) Translog.Operation.readOperation(in);
                    assertThat(Tuple.tuple(op.seqNo(), op.primaryTerm()), is(in(seenSeqNos)));
            if (fail.fail()) {
        int translogOperations = randomIntBetween(10, 100);
        for (int i = 0; i < operations; i++) {
                } catch (IOException ex) {
                                location = translog.add(op);
            );
            SequenceNumbers.NO_OPS_PERFORMED,
            assertNull(next);
        );
        }
        }
            try (Translog.Snapshot snapshot = translog.newSnapshot(minUncommittedOp, Long.MAX_VALUE)) {
            // now randomly open this failing tlog again just to make sure we can also recover from failing during recovery
                translog.getDeletionPolicy()
        translog.close(); // we are closed
                        public int write(ByteBuffer src) throws IOException {
            int translogOperations = randomIntBetween(10, 100);
                new Translog.Index("2", 1, primaryTerm.get(), lineFileDocs.nextDoc().toString().getBytes(Charset.forName("UTF-8")))
        final Thread[] writers = new Thread[randomIntBetween(1, 3)];
        for (int i = headerSize; i < singleBytes.length; i++) {
                }
            }, threadId);
            assertFilePresences(translog);
        }
            if (randomBoolean()) {
                    case NO_OP:
        final Map<Translog.Operation, Translog.Location> writtenOps = ConcurrentCollections.newConcurrentMap();
            this.writtenOperations = writtenOperations;
            deleteRouting
        assertTrue(Files.exists(translogDir.resolve(Translog.getFilename(1))));
                    // we survived all the randomness!!!
            };
        try {
                        failableTLog.add(
        file = translogDir.resolve(Translog.TRANSLOG_FILE_PREFIX + randomNonTranslogPatternString(1, 10) + id);
            assertThat(seenSeqNos, equalTo(expected));
        assertThat(total.getTranslogSizeInBytes(), equalTo(statsList.stream().mapToLong(TranslogStats::getTranslogSizeInBytes).sum()));
        // we control retention via time, disable size based calculations for simplicity
    protected Path translogDir;
            try (Translog.Snapshot snapshot = tlog.newSnapshot()) {
            boolean atLeastOneFailed = false;
        Version wireVersion = VersionUtils.randomVersionBetween(random(), Version.CURRENT.minimumCompatibilityVersion(), Version.CURRENT);
    public void testFailFlush() throws IOException {
            }
            final TranslogStats stats = stats();
        assertThat(e, hasToString(containsString("numberOfOperations must be >= 0")));
                        closeRetentionLock();
    }
                    assertFalse("should have failed if sync was needed", syncNeeded);
            .build();
            Translog tlog = new LocalTranslog(
    }
        final String translogUUID = translog.getTranslogUUID();
            assertThat(stats.estimatedNumberOfOperations(), equalTo(3));
        Translog.Delete delete = new Translog.Delete(eDelete, eDeleteResult);
                Translog translog = new LocalTranslog(
                op,
        long lastSyncedGlobalCheckpoint = globalCheckpoint.get();
            () -> SequenceNumbers.NO_OPS_PERFORMED,
        translog.close();
                builder.startObject();
                                missed.append("\n --> [").append(expectedOp).append("] written at ").append(loc);
                assertEquals(Integer.parseInt(next.getSource().source.utf8ToString()), i);
        }
                Translog.Index op = new Translog.Index(
                if (throwUnknownException) {
import java.util.concurrent.CyclicBarrier;
                seqNo -> {},
    }
                long minGen;
    public void testFindEarliestLastModifiedAge() throws IOException {
    }
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            }
            } else {
        int operationsInLastGen = 0;
                    + "minTranslogGeneration=0, trimmedAboveSeqNo=-2}"
    public void testTotalTests() {
        // force stopping, if all writers crashed
            assertSame(translog.getTragicException(), ex.getCause());
                    switch (type) {
            byte[] bytes = new byte[256];
                        @Override
                if (drop) {
            translogUUID = translog.getTranslogUUID();
            }
                reader.readBytes(buffer, reader.getFirstOperationOffset() + 4 * numOps);
            equalTo(maxSeqNoPerGeneration.isEmpty() ? SequenceNumbers.NO_OPS_PERFORMED : Collections.max(maxSeqNoPerGeneration.values()))
            assertThat(stats.getTranslogSizeInBytes(), equalTo(231L));
        );
                }
                    primaryTerm::get,
        final int operations = randomIntBetween(1, 512);
            assertNotNull("operation 1 must be non-null", firstOp);
                    seqNo -> {},
            }
                    throw new IOException(expectedExceptionMessage);
        while (queue.isEmpty() == false) {
        // length) and differ only in the UUID bytes, so compare the operations region after the header for exact
            Translog translog = new LocalTranslog(
import java.util.List;
    public void setUp() throws Exception {
        final Path translogFile = translogDir.resolve(Translog.getFilename(closedGeneration));
    }
import java.util.Collections;
    }
        final String translogUUID;
            .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
        final AtomicBoolean failOnCopy = new AtomicBoolean();
        translog.add(new Translog.Index("2", 1, primaryTerm.get(), new byte[] { 2 }));
            boolean rollover = attempt == 0 || attempt == maxAttempts - 1 || randomBoolean();
                assertNotNull(op);
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 2);
            translog.rollGeneration();
            Translog.Operation op = snapshot.next();
            }
            public void copy(Path source, Path target, CopyOption... options) throws IOException {
                long newSize = prevSize - randomIntBetween(1, (int) prevSize / 2);
import org.opensearch.common.util.concurrent.ConcurrentCollections;
            if (rarely()) {
        final AtomicInteger translogFsyncCalls = new AtomicInteger();
import org.apache.lucene.index.Term;
            translog.getDeletionPolicy().assertNoOpenTranslogRefs();
            0,
                            .values().length))];
        LineFileDocs lineFileDocs = new LineFileDocs(random()); // writes pretty big docs so we cross buffer borders regularly
            getPersistedSeqNoConsumer(),
        try {
                firstUncommitted = op + 1;
        TranslogStats stats = translog.stats();
            Translog.parseIdFromFileName(file);
        assertNull("Routing must be null when written with old format", deserialized.routing());
        for (int iterations = between(1, 10), i = 0; i < iterations; i++) {
                }
                primaryTerm::get,
                            final boolean synced;
import org.apache.lucene.tests.mockfile.FilterFileSystemProvider;
        final Object signalReaderSomeDataWasIndexed = new Object();
                } else {
        assertFileDeleted(translog, 1);
                .uncommittedSizeInBytes(-1)
            if (fail.fail()) {
                translogUUID,
import java.nio.file.CopyOption;
        // it is possible to trim after generation rollover
                for (int i = 0; i < opsAdded; i++) {
        }
                                signalReaderSomeDataWasIndexed.wait();
                        assertThat(opCount, equalTo(checkpoint.numOps));
            throw new UnsupportedOperationException();
import java.nio.charset.Charset;
            NON_RECYCLING_INSTANCE,
            deletionPolicy.setRetentionSizeInBytes(-1);
                failableTLog.trimOperations(primaryTerm.get(), maxTrimmedSeqNo);
                translog.sync();
                        }
                seqNo -> {},
            IndexSettingsModule.newIndexSettings(shardId.getIndex(), settings),
                // failed - that's ok, we didn't even create it or it was corrupted from partial writes
        }
            deletionPolicy.setRetentionAgeInMillis(-1);
                generationUUID = Translog.createEmptyTranslog(
        List<TestTranslog.LocationOperation> writtenOperations = Collections.synchronizedList(new ArrayList<>());
 * KIND, either express or implied.  See the License for the
                translog.add(op);
                    null
            Collections.shuffle(seqNos, new Random(100));
        return new LocalTranslog(
                        }
            // live reader!
            config.getTranslogPath(),
            assertNull(snapshot.next());
            assertThat(persistedSeqNos, contains(1L, 2L, 3L, 4L, 5L));
 * software distributed under the License is distributed on an
        }
    public void testEnsureNoCircularException() throws Exception {
        public void force(boolean metadata) throws IOException {
                    }
        out.writeInt(2048);
            if (fail.fail()) {
                Translog.Index op = new Translog.Index(randomAlphaOfLength(10), seqNo, primaryTerm.get(), new byte[] { randomByte() });
                    };
                    assertEquals(ex, failableTLog.getTragicException());
            // all good
            Randomness.shuffle(seqNos);
                for (int i = 0; i < numOps; i++) {
    @Override
                translog.rollGeneration();
            int maxTrimmedSeqNo;
        final TranslogConfig config = getTranslogConfig(createTempDir());
        final TestTranslog.FailSwitch fail = new TestTranslog.FailSwitch();
                            throw new AssertionError(e);
                foreignTranslog,
            Long repeatingTermSeqNo = randomFrom(seqNos.stream().map(Tuple::v1).collect(Collectors.toList()));
     */
                translog.rollGeneration();
        misbehavingTranslog.callCloseOnTragicEvent();
    public void testSnapshotReadOperationForward() throws Exception {
            // TODO once we have a mock FS that can simulate we can also fail on plain sync
                    primaryTerm::get,
            assertThat(snapshot, SnapshotMatchers.size(0));
            maxSeqNo
                        throw new AssertionError("unsupported operation type [" + op.opType() + "]");
            for (Translog.Operation op = snapshot.next(); op != null; op = snapshot.next()) {
            String ascii = randomAlphaOfLengthBetween(1, 50);
                                // we need not do this concurrently as we need to make sure that the generation
            assertEquals("payload mismatch for operation 1", 1, Integer.parseInt(op.getSource().source.utf8ToString()));
            // fine
                }
        }
        );
        fromSeqNo = randomLongBetween(0, 2000);
            Translog forwardTranslog = new LocalTranslog(
        for (int i = 0; i < threadCount; i++) {
        private final boolean throwUnknownException;
                            }
            int extraTranslogOperations = randomIntBetween(10, 100);
            final int operations = randomIntBetween(1, 100);
import java.util.concurrent.CountDownLatch;
    public void testRollGeneration() throws Exception {
        for (final Tuple<Long, Long> tuple : seqNos) {
        Translog translog = getFailableTranslog(fail, config);
        // make sure we keep some files around
                Translog.Operation op;
            assertThat(stats.getEarliestLastModifiedAge(), greaterThanOrEqualTo(lastModifiedAge));
            temp.getIndexSettings(),
            this.translog = translog;
            if (randomBoolean()) {
import org.opensearch.common.io.stream.BytesStreamOutput;
                assertEquals(writtenOperations.size(), snapshot.totalOperations());
        try (Translog tlog = openTranslog(config, translog.getTranslogUUID()); Translog.Snapshot snapshot = tlog.newSnapshot()) {
                assertEquals(
            Translog.Snapshot snapshot = translog.newSnapshot();
            try (
            if (randomBoolean()) {
            assertThat(snapshot, containsOperationsInAnyOrder(latestOperations.values()));
        assertThat(expectThrows(TranslogCorruptedException.class, () -> {
            () -> new LocalTranslog(
                logger.info("--> truncating {}, prev: {}, now: {}", file, prevSize, newSize);
            boolean foundRouted = false;
            );
            temp.getBigArrays(),
                return channel;
                public void onFailure(Exception e) {
            .put(IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.getKey(), "-1b")
        translog.close();
                            syncedDocs.addAll(unsynced);
        StreamInput in = out.bytes().streamInput();
            writtenOperations.removeIf(next -> checkpoint.offset < (next.location.translogLocation + next.location.size));
            final Checkpoint checkpoint = Checkpoint.read(config.getTranslogPath().resolve(Translog.CHECKPOINT_FILE_NAME));
            if (randomBoolean()) {
                        seqNo.getAndIncrement(),
                primaryTerm::get,
                expectedSeqNo.addAll(views.pop());
                    assertNotNull("operation " + i + " must be non-null", next);
    }
            assertNotNull(ex.getCause());
        final boolean sync = randomBoolean();
        void add(Translog.Operation operation) {
    }
    public void testTranslogCloseInvariant() throws IOException {
            writeStarted.await();
                TranslogOperationHelper.DEFAULT,
                final int operations = randomIntBetween(1, 100);
    }
        final long noopTerm = randomLongBetween(1, primaryTerm.get());
        final Map<Long, Integer> opCountPerGeneration = new HashMap<>();
            }
            assertThat(copy.estimatedNumberOfOperations(), equalTo(4));
        try (Translog.Snapshot snap = new TestTranslog.SortedSnapshot(translog.newSnapshot())) {
        Engine.DeleteResult eDeleteResult = new Engine.DeleteResult(2, randomPrimaryTerm, randomSeqNum, true);
        }
        fail.failNever();
            TranslogReader reader = writer.closeIntoReader();
                    assertEquals(
                primaryTerm.incrementAndGet();
            } catch (AlreadyClosedException ex) {
import org.opensearch.core.common.bytes.BytesReference;
    }
            } finally {
        }
        final BaseTranslogReader minRetainedReader = randomFrom(
            assertThat(snapshot, SnapshotMatchers.size(0));
                                }
        assertEquals(ex.getMessage(), "failed to create new translog file");
                translogGeneration = translog.getGeneration();
                );
                failableTLog.rollGeneration();
                    // recovery logic which captures a view and gets a lucene commit
                primaryTerm::get,
            fileChannels
            assertFalse(translog.syncNeeded());
            assertNull(snapshot.next());
            final AlreadyClosedException alreadyClosedException = expectThrows(AlreadyClosedException.class, translog::rollGeneration);
        }
            ) {
        final AtomicLong seqNoGenerator = new AtomicLong();
            getPersistedSeqNoConsumer(),
        TranslogConfig config = translog.getConfig();
            } catch (IOException e) {
            translog.rollGeneration();
            statsList.add(stats);
            }
    }
            }
                }
        } else {
        document.add(seqID.primaryTerm);
        private final int threadId;
        final List<Long> primaryTerms = new ArrayList<>();
                        TranslogSnapshot snapshot = reader.newSnapshot();
                                fail(missed.toString());
                readFromSnapshot += snapshot.skippedOperations();
                    "lastCommitted must be 3 less than current - we never finished the commit and run recovery twice",
        } catch (UnknownException ex) {
        );
    }
            }
        );
                FileChannel open = FileChannel.open(p, o);
                }
                translog.getDeletionPolicy(),
            gen = singleTranslog.currentFileGeneration();
        LongSupplier globalCheckpointSupplier = () -> {
        }
            int totOps = 0;
                // Add after we the read flushed the buffer
            assertThat("operation byte region differs at offset " + i, batchBytes[i], equalTo(singleBytes[i]));
                    new Translog.Index("" + op, op, primaryTerm.get(), Integer.toString(++count).getBytes(Charset.forName("UTF-8")))
                    super.force(metaData);
        } else {
            endsWith(
    }
                            new Translog.Index("" + opsAdded, opsAdded, primaryTerm.get(), doc.getBytes(Charset.forName("UTF-8")))
        assertThat(checkpoint.globalCheckpoint, equalTo(lastSyncedGlobalCheckpoint));
            return super.read(dsts, offset, length);
                        + 328
                                    writeStarted.countDown();
    }
                        src.limit(limit);
            SequenceNumbers.NO_OPS_PERFORMED,
        expectIntactTranslog = true;
        translog.rollGeneration();
    public void testNegativeSizeInBytes() {
        }
    private String randomNonTranslogPatternString(int min, int max) {
        }
                boolean shouldAdd = !withMissingOps || seqNo % 4 != 0;
                );
                LongSupplier primaryTermSupplier
                    translog.currentFileGeneration()
        assertThat(Translog.readGlobalCheckpoint(translogDir, translogUUID), equalTo(globalCheckpoint.get()));
                    }
    }
                translog.rollGeneration(); // empty generation
                        break;
                for (int i = 0; i < operations; i++) {
                .filter(r -> r.getCheckpoint().minSeqNo >= 0)
                Translog.Operation op = snapshot.next();
        final TranslogConfig config = translog.getConfig();
            config,
                translog.rollGeneration();
            threads[i] = new TranslogThread(translog, downLatch, 200, threadId, writtenOperations, seqNoGenerator, threadExceptions) {
                        tlog.currentFileGeneration() - 1,
                            committing = true;
                } catch (IOException ex) {
            ByteBuffer buffer = ByteBuffer.allocate(4);
                        final Translog.NoOp expectedNoOp = (Translog.NoOp) expectedOp;
        void trimOperations(long belowTerm, long aboveSeqNo) {
            }
                assertFalse(translog.isOpen());
                    "expected this to be the first roll (1 gen is on creation, 2 when opened)",
            FileChannel delegate = FileChannel.open(file, openOption);
    static class InMemoryTranslog {
            total.getUncommittedSizeInBytes(),
                    )
     */
            if (seen.add(current) == false) {
        class MisbehavingTranslog extends LocalTranslog {
        if (longRetention) {
        IOUtils.close(lock);
        translog.trimUnreferencedReaders();
                    views.add(new ArrayList<>());
                        // these are what we expect the snapshot to return (and potentially some more).
                .uncommittedSizeInBytes(1)
    public void testBasicCheckpoint() throws IOException {
        assertEquals(ex.getCause().getClass(), FileAlreadyExistsException.class);
                    channel = new FilterFileChannel(delegate) {
            }
                super(
            is(
                                    blocker.await();
                } else {
            }
import org.hamcrest.Matchers;
        primaryTerm.addAndGet(extraDocs);
                    }
                .uncommittedOperations(randomIntBetween(1, 1 << 20))
        );
            assertEquals(op, translog.readOperation(locs.get(i++)));
            shardId,
            SequenceNumbers.NO_OPS_PERFORMED,
                    seqNo.getAndIncrement(),
        final long minSeqNo;
                translog.add(
            AtomicLong nextSeqNo = new AtomicLong();
            assertThat(expectThrows(IOException.class, brokenTranslog::rollGeneration).getMessage(), equalTo(expectedExceptionMessage));
        }
                    assertEquals(ex.getMessage(), "__FAKE__ no space left on device");
        TranslogConfig config = translog.getConfig();
        final TestTranslog.FailSwitch fail,
        super.afterIfSuccessful();
            assertThat(snapshot1.totalOperations(), equalTo(1));
            List<String> syncedDocs = new ArrayList<>();
            new ByteSizeValue(8, ByteSizeUnit.KB),
    private Long populateTranslogOps(boolean withMissingOps) throws IOException {
                    Translog.Operation next = snapshot.next();
            if (randomBoolean()) {
                assertFalse("location is from a previous translog - already synced", translog.ensureSynced(locations.stream()));
        assertEquals(index, serializedIndex);
import static org.hamcrest.Matchers.is;
                    )
                        }
            shardId,
                        randomAlphaOfLength(10),
        }
        translog.close();
                            }
                String ascii = randomAlphaOfLengthBetween(1, 50);
                    null
                        expectedOps.add(op);
                translog.currentFileGeneration()
            }
 * You may obtain a copy of the License at
                null
            fail("should have been failed");
            VersionUtils.getPreviousVersion(Version.V_3_9_0)
    }
                assertEquals(
    }
                translog.getTranslogUUID(),
            } catch (MockDirectoryWrapper.FakeIOException ex) {
                TranslogOperationHelper.DEFAULT,
                Translog.Index operation = new Translog.Index("" + op, op, primaryTerm.get(), ascii.getBytes("UTF-8"));
                        throw new IOException("simulated");
        final TranslogDeletionPolicy deletionPolicy = translog.getDeletionPolicy();
        TranslogConfig config = getTranslogConfig(tempDir);
            }
                new DefaultTranslogDeletionPolicy(-1, -1, 0),
                        syncedDocs.addAll(unsynced); // failed in fsync but got fully written
        int uncommittedOps = 0;
            deletionPolicy,
                } finally {
                fail("we are already closed");
import org.opensearch.common.xcontent.XContentFactory;
                TranslogOperationHelper.DEFAULT,
                locations.add(
            equalTo(statsList.stream().mapToInt(TranslogStats::estimatedNumberOfOperations).sum())
                    TranslogOperationHelper.DEFAULT,
            }
import org.apache.lucene.tests.util.LineFileDocs;
            Translog.NoOp noOp = (Translog.NoOp) snapshot.next();
            for (final Iterator<Map.Entry<Long, Translog.Operation>> it = operations.entrySet().iterator(); it.hasNext();) {
                            failableTLog.rollGeneration();
            .findFirst()
            threads[i].setDaemon(true);
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 3);
            Translog.Snapshot snapshot = translog.newSnapshot(0, randomIntBetween(0, 10));
                        while ((operation = snapshot.next()) != null) {
        TranslogConfig config = translog.getConfig();
        List<Translog.Operation> ops = new ArrayList<>();
                .translogSizeInBytes(randomIntBetween(1, 1 << 20))
                    translogGeneration.translogFileGeneration
                long prevSize = f.size();
        long period = randomLongBetween(10000, 1000000);
        final BaseTranslogReader reader = randomBoolean()
            // all good
        }
            threads[i] = new TranslogThread(
                        @Override
                Translog.Operation next = snapshot.next();
        }
            assertFileIsPresent(translog, translog.currentFileGeneration());
                }
public class LocalTranslogTests extends OpenSearchTestCase {
                    if (src.hasRemaining()) {
 */
        {
            Randomness.shuffle(ops);
                    int counter = 0;
        final String singleUUID = Translog.createEmptyTranslog(singleDir, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
    }
        final boolean partialWrites,
            } else if (rarely()) {
                    seqNoPerGeneration.put(g, generationSeenSeqNos);
                assertThat(readerCheckpoint, equalTo(writerCheckpoint));
            translogUUID,
        long fromSeqNo = 0L;
                            super.force(metaData);
                e.addSuppressed(suppress);
                    false,
            }
            primaryTerm::get,
            final Translog.Location location = translog.add(
        assertThat("translog file length differs", batchBytes.length, equalTo(singleBytes.length));
            }
    }
                @Override
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            for (int i = 0; i < numOps; i++) {
            // 2. snapshot reads all ops back from the batch translog, in order and equal to the inputs
import org.opensearch.core.common.io.stream.StreamInput;
            translogConfig,
            if (fail.fail()) {
                    long fileGeneration,
                @Override
                    primaryTerm::get,
                            boolean failed = false;
    class TranslogThread extends Thread {
        logger.debug("--> waiting for readers to stop");
            }
            // if we hit a tragic event. this is important to ensure that asserts inside the Translog#add doesn't trip
                    Translog.Operation next = snapshot.next();
            () -> SequenceNumbers.NO_OPS_PERFORMED,
        Translog.Index index = new Translog.Index(eIndex, eIndexResult);
            for (Throwable suppress : errors.subList(1, errors.size())) {
        }
@LuceneTestCase.SuppressFileSystems("ExtrasFS")
     * Tests the situation where the node crashes after a translog gen was committed to lucene, but before the translog had the chance
                            );
                    if (rarely()) { // lets verify we can concurrently read this
        assertEquals("tenant-abc", deserialized.routing());
    }
            Collection<TestTranslog.LocationOperation> writtenOperations,
        boolean validPathString;
        final long maxSeqNo;
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 4);
                .uncommittedSizeInBytes(1)
        long nextSeqNo = populateTranslogOps(true);
                            fail("duplicate op [" + op + "], old entry at " + location);
        Path tempDir = createTempDir();
                primaryTerm::get,
            tempDir.resolve("foo.cpk"),
            translog.add(
                for (int i = 0; i < syncedDocs.size(); i++) {
                void acquireRetentionLock() throws IOException {
        expectThrows(AssertionError.class, () -> misbehavingTranslog.callCloseUsingIOUtilsWithExceptionHandling());
                        Translog.Location existing = writtenOps.put(op, location);
                                assertThat(checkpoint.maxSeqNo, greaterThanOrEqualTo(op.seqNo()));
            seqNo -> {},
                }
            for (int i = 0; i < opCount; i++) {
    }
        );
                    + "[1:"
                        .ifPresent(source::set);
        Translog.Location loc2 = translog.add(new Translog.Delete("doc-2", 1, primaryTerm.get(), 1));
            @Override
        final CountDownLatch downLatch = new CountDownLatch(1);
                    new Translog.Index(Integer.toString(op), op, primaryTerm.get(), Integer.toString(op).getBytes(Charset.forName("UTF-8")))
            assertFalse(tlog.syncNeeded());
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
        translog.add(operation);
        int numOps = between(0, 10);
            List<Long> batch = LongStream.rangeClosed(0, between(0, 500)).boxed().collect(Collectors.toList());
        BytesReference B_1 = new BytesArray(new byte[] { 1 });
                        assertNotNull("operation " + i + " must be non-null synced: " + sync, next);
            }
        try {
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
            assertThat(persistedSeqNos, contains(1L, 2L, 3L, 4L));
import org.opensearch.index.engine.Engine;
            config,
import org.opensearch.index.IndexSettings;
import org.apache.lucene.tests.store.MockDirectoryWrapper;
        for (int i = 0; i <= rolls; i++) {
        );
                    "{\"translog\":{\"operations\":4,\"size_in_bytes\":"
        final TranslogDeletionPolicy deletionPolicy = translog.getDeletionPolicy();
                // don't do partial writes for checkpoints we rely on the fact that the bytes are written as an atomic operation
        final Set<Long> persistedSeqNos = new HashSet<>();
                // not syncing now
        }
            thread.join();
        private final int opsPerThread;
        }
                    for (int i = 0; i < iterations; i++) {
                    int iterations = randomIntBetween(10, 100);
                locations2.add(
        final TestTranslog.FailSwitch fail,
                translog,
            }
            }
        return b;
                final Map.Entry<Long, Translog.Operation> next = it.next();
        if (randomBoolean()) { // recover twice
/*
                    assertEquals("payload mismatch, synced: " + sync, i, Integer.parseInt(next.getSource().source.utf8ToString()));
            }
        }
            final FileChannel channel = FileChannel.open(file, openOption);
            reader.readBytes(buffer, pos);
        }
                return true;
            primaryTerm.incrementAndGet(); // increment primary term to force rolling generation
        ) {
                        )
            this.throwUnknownException = throwUnknownException;
        TranslogConfig config = translog.getConfig();
        }
import java.util.Collection;
                                try {
                // we are the last location so everything should be synced
                for (Translog.Location loc : locations) {
                );
                assertEquals(
                                }
                            op = new Translog.Index(
            }
                seenSeqNos.add(seqNo);
        int opsSynced = 0;
        int translogOperations = randomIntBetween(10, 100);
        }
    }
        assertThat(reader.getCheckpoint().maxSeqNo, equalTo(maxSeqNo));
        final int generations = between(2, 20);
                        case INDEX:
                            "" + opsSynced,
            translog.rollGeneration();
                success = true;
                deletionPolicy,
                seenSeqNos.addAll(generationSeqNo);
            uncommittedOps++;
            try (FileChannel f = FileChannel.open(file, StandardOpenOption.READ, StandardOpenOption.WRITE)) {
                    Translog.Operation next = snapshot.next();
                () -> SequenceNumbers.NO_OPS_PERFORMED,
                    assertThat("op " + i + " read back", read, equalTo(ops.get(i)));
        // Successful snapshot
                null
        TranslogConfig config = getTranslogConfig(path);
     * to clean up its files.
                        );
                seqNoGenerator,
            Translog.Snapshot snapshot = translog.newSnapshot();
            assertThat(snapshot, SnapshotMatchers.size(1));
            }
                }
        final Translog.Location[] batchLocations;
            assertThat(stats.getEarliestLastModifiedAge(), greaterThan(0L));
            assertThat(snapshot.totalOperations(), equalTo(1));
        TestTranslog.corruptRandomTranslogFile(logger, random(), translogDir, 0);
        assertEquals(seenSeqNos, persistedSeqNos);
                    phaser.arriveAndAwaitAdvance();
            }
     * This test adds operations to the translog which might randomly throw an IOException. The only thing this test verifies is
            TranslogOperationHelper.DEFAULT,
            () -> SequenceNumbers.NO_OPS_PERFORMED,
                    translog.add(
            translogUUID,
     * Tests that closing views after the translog is fine and we can reopen the translog
        locs.add(addToTranslogAndList(translog, ops, new Translog.Index("2", 1, primaryTerm.get(), new byte[] { 1 })));
        Path ckp = config.getTranslogPath().resolve(Translog.CHECKPOINT_FILE_NAME);
        translog.getDeletionPolicy().setLocalCheckpointOfSafeCommit(randomLongBetween(0, operations));
            toClose.add(snapshot1);
            config,
            snapshot.close();
            assertTrue("Should find delete with routing in snapshot", foundRouted);
import java.io.Closeable;
                if (isCkpFile) {
                translog.currentFileGeneration()
                    () -> SequenceNumbers.NO_OPS_PERFORMED,
        assertThat(
            if (rarely()) {
import org.opensearch.Version;
                            }
        MisbehavingTranslog misbehavingTranslog = new MisbehavingTranslog(
            BytesStreamOutput out = new BytesStreamOutput();
                new DefaultTranslogDeletionPolicy(-1, -1, 0),
            AtomicReference<String> source = new AtomicReference<>();
        } catch (IllegalArgumentException ex) {
            assertThat(stats.getUncommittedOperations(), equalTo(3));
 * The OpenSearch Contributors require contributions made to
                assertFalse("location is from a previous translog - already synced", translog.ensureSynced(location)); // not syncing now
            final long seqNoLowerBound = seqNo;
    /**
                }
            }
            if (op == prepareOp) {
        }
    public void testSnapshotOnClosedTranslog() throws IOException {
                }
            }
                    throw new UnknownException();
                        new byte[] { 1 }
                        )
            readers[i].start();
        boolean failed = false;
    public void testTranslogOpsCountIsCorrect() throws IOException {
        }
                                break;
                assertFalse("translog has been synced already", translog.ensureSynced(location));
            } catch (IOException ex) {
            translog.trimUnreferencedReaders();
            Randomness.shuffle(ops);
                                synced = true;
            this.seqNoGenerator = seqNoGenerator;
                ThrowingFileChannel channel = new ThrowingFileChannel(failSwitch, false, false, open);
                Integer.toString(op).getBytes(Charset.forName("UTF-8"))
                    + (primaryTerm.get() - 1)
                for (int i = minUncommittedOp; i < translogOperations; i++) {
                    config,
            minGenForRecovery = translog.getMinGenerationForSeqNo(localCheckpoint + 1).translogFileGeneration;
            Translog.Snapshot snapshot1 = translog.newSnapshot(0, randomIntBetween(0, 10))
                                break;
        private final CountDownLatch downLatch;
        // any errors on threads
                () -> globalCheckpoint.get(),
                }
        }
        {
                try {
            maxTrimmedSeqNo = rollover ? translogOperations - randomIntBetween(4, 8) : translogOperations + 1;
        ) {
                    config.getTranslogPath(),
            translog.add(op);
                        final Translog.Operation.Type type = Translog.Operation.Type.values()[((int) (id % Translog.Operation.Type
                    new byte[] { 1 }
                allOperations.add(operation);
        }
import java.util.Set;
        AssertionError error = expectThrows(AssertionError.class, () -> translog.trimOperations(primaryTerm.get(), 0));
            localCheckpoint = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, op);
            }
            toClose.add(snapshot2);
                            failableTLog.sync();
            // this holds a reference to the current tlog channel such that it's not closed
        return getTranslogConfig(path, settings);
    }
        }
            if (threadExceptions[i] != null) {
    public void testRecoverWithUnbackedNextGenInIllegalState() throws IOException {
        long fixedTime = randomLongBetween(0, 10000000000000000L);
        final List<Long> shuffledSeqNos = LongStream.range(0, operations).boxed().collect(Collectors.toList());
import static org.hamcrest.Matchers.instanceOf;
            assertThat(stats.estimatedNumberOfOperations(), equalTo(4));
        in = out.bytes().streamInput();
        assertThat(Translog.parseIdFromFileName(file), equalTo(id));
        );
                config,
import org.apache.lucene.tests.mockfile.FilterFileChannel;
        for (int op = 0; op < translogOperations; op++) {
                TestTranslog.FailSwitch failSwitch = new TestTranslog.FailSwitch();
                        assertTrue(loc.equals(location));
        translog.add(new Translog.Delete("2", 1, primaryTerm.get()));
                // don't do partial writes for checkpoints we rely on the fact that the bytes are written as an atomic operation
            for (long seqNo : seqNos) {
            }
    }
                        }
    public void testCrashDuringCheckpointCopy() throws IOException {
                // have to use exactly the same source for same seq# if primaryTerm is not changed
        private final Exception[] threadExceptions;
            new Translog.Index(
        translog.getDeletionPolicy().setRetentionAgeInMillis(3600 * 1000);
     * the offset recorded in its checkpoint and no content checksum is derived. The footer is a remote-store
        Translog.Location loc1 = translog.add(new Translog.Delete("doc-1", 0, primaryTerm.get(), 1, "tenant-routing"));
            IllegalArgumentException.class,
                        tlog.currentFileGeneration() - 1,
                        }
        }
            threads[i].start();
                    expectedSeqNo.addAll(view);
                if (rarely()) {
        deletionPolicy.setRetentionAgeInMillis(randomLong());
        String translogUUID,
                deletionPolicy,
            } catch (Exception t) {
                config,
            )
        final int opCount = 250;
            if (rarely()) {
            assertThat(stats.getEarliestLastModifiedAge(), greaterThan(0L));
                    forwardTranslog.rollGeneration();
        try (Translog.Snapshot snap = translog.newSnapshot()) {
            if (randomBoolean()) {
                TranslogOperationHelper.DEFAULT,
                lastSyncedGlobalCheckpoint = globalCheckpoint.get();
        // translog here as well.
        int translogOperations = randomIntBetween(10, 100);
                config.getTranslogPath(),
    private void assertFilePresences(Translog translog) {
            return;
                }
 * Unless required by applicable law or agreed to in writing,
                    translogGeneration.translogFileGeneration + 3,
                () -> SequenceNumbers.NO_OPS_PERFORMED,
            // 1. Identical Locations (generation, offset, size) per op
import org.opensearch.index.mapper.Uid;
                for (int i = 0; i < upTo; i++) {
            channelFactory
    }
            assertThat(translog.estimateTotalOperationsFromMinSeq(seqNo), equalTo(expectedSnapshotOps));
        public long read(ByteBuffer[] dsts, int offset, int length) throws IOException {
        Path tempDir = createTempDir();
                writer.readBytes(ByteBuffer.allocate(256), 0);
    }
                assertEquals(opsAdded + 1, snapshot.totalOperations());
            minSeqNo = b;
                    config,
import static org.hamcrest.Matchers.contains;
    /**
                } else {
                                if (writeStarted.getCount() > 0) {
                        opsAdded,
                        if (existing != null) {
            2,
            }
            fail("translog doesn't belong to this UUID");
                threadExceptions[threadId] = t;
                shardId,
                    Translog.Operation next = snapshot.next();
            TranslogOperationHelper.DEFAULT,
                        assertEquals(op, translog.readOperation(loc));
import org.apache.lucene.store.DataOutput;
            for (int op = 0; op < translogOperations; op++) {
    private boolean expectIntactTranslog;
                        locations.get(i).generation
                .collect(Collectors.toList());
                threadId,
                    assertEquals(
import java.util.concurrent.CopyOnWriteArrayList;
            assertThat(snapshot.totalOperations(), equalTo(ops.size()));
        for (int op = 0; op < translogOperations; op++) {
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 1);
            }
        locs.add(addToTranslogAndList(translog, ops, new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 })));
                }
                    int opCount = 0;
                    logger.error(() -> new ParameterizedMessage("--> reader [{}] had an error", threadId), e);
            fail("invalid pattern");
                }
        final String translogUUID = translog.getTranslogUUID();
    /**
    public void testSnapshotCurrentHasUnexpectedOperationsForTrimmedOperations() throws Exception {
        final int opsPerThread = randomIntBetween(10, 200);
import java.nio.file.Files;
                }
                translog.getDeletionPolicy(),
                    readFromSnapshot++;
                    assertEquals(locations.get(j).hashCode(), locations2.get(j).hashCode());
        Set<Long> persistedSeqNos = ConcurrentCollections.newConcurrentSet();
                primaryTerm::get,
    public void testConcurrentWritesWithVaryingSize() throws Throwable {
        final int prepareOp = 44;
    }
    public void testRecoveryFromFailureOnTrimming() throws IOException {
                if (ex != null) {
            }
                translogGeneration.translogUUID,
                primaryTerm::get,
        expectThrows(AssertionError.class, () -> misbehavingTranslog.callCloseUsingIOUtils());
                } catch (IOException ex) {
    public void testSyncUpTo() throws IOException {
            minSeqNo,
            if (randomBoolean()) {
    public void testBasicRecovery() throws IOException {
            assertFalse(brokenTranslog.isOpen());
            final LongConsumer consumer = persistedSeqNoConsumer.get();
            StreamInput in = out.bytes().streamInput();
        final AtomicLong idGenerator = new AtomicLong();
                    while (run.get() && idGenerator.get() < maxOps) {
            }
        }
                            for (Translog.Operation op : ops) {
            }
                    assertThat(deletionPolicy.getTranslogRefCount(minGen), equalTo(1L));
            Translog.Snapshot snapshot1 = translog.newSnapshot();
        assertThat(reader.getTranslogContentChecksum(), nullValue());
                    assertEquals("payload mismatch, synced: " + sync, i, Integer.parseInt(next.getSource().source.utf8ToString()));
        for (Thread thread : readers) {
        final Queue<Throwable> queue = new LinkedList<>();
        ArrayList<Translog.Operation> ops = new ArrayList<>();
    }
import static org.hamcrest.Matchers.containsString;
            Translog.Operation op;
        long seqNo = 0;
            super.force(metadata);
                        final int pos = src.position();
        if (a.compareTo(b) > 0) {
            assertFalse(translog.syncNeeded());
    public void testFullRangeSnapshot() throws Exception {
import java.io.EOFException;
        }
        for (Translog.Operation op : ops) {
        final int numOps = scaledRandomIntBetween(8, 250000);
        }
            long toSeqNo = randomLongBetween(fromSeqNo, minSeqNo - 1);
                        "expected operation" + i + " to be in the previous translog but wasn't",
            ops.add(new Translog.Index(id, seqNo, primaryTerm.get(), source));
            .filter(r -> r.getCheckpoint().generation >= minRetainedReader.generation)
            translogUUID,
        Path path = createTempDir();
        String translogUUID,
        downLatch.countDown();
                        case CREATE:
        String translogUUID = Translog.createEmptyTranslog(
                IOUtils.closeWhileHandlingException(this);
        writer.sync();
            Translog.Operation next = snapshot.next();
                            break;
        for (int i = 0; i < operations; i++) {
            Stream.concat(translog.getReaders().stream(), Stream.of(translog.getCurrent()))
                translog.add(operation);
    }
        }
            CountDownLatch downLatch,
            Thread[] threads = new Thread[between(2, 8)];
            VersionType.INTERNAL,
            Phaser phaser = new Phaser(threads.length);
        assertEquals("doc-1", deserialized.id());
                    Translog.Operation next = snapshot.next();
                    deletionPolicy,
        }
            }
                        assertThat(unsynced, empty());
            }
import org.opensearch.index.mapper.ParsedDocument;
                    assertEquals(
        Closeable lock = translog.acquireRetentionLock();
                    ops.add(op);
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 4);
                translogGeneration.translogFileGeneration + 2,
import org.opensearch.test.VersionUtils;
        try (
                            syncedDocs.clear();
            List<Long> ops = LongStream.range(0, allOperations.size() + randomIntBetween(10, 15)).boxed().collect(Collectors.toList());
            }
                    return add;
                deletionPolicy,
            seqNo -> {},
                try (Closeable ignored = translog.acquireRetentionLock()) {
        Path ckp = config.getTranslogPath().resolve(Translog.CHECKPOINT_FILE_NAME);
        assertEquals("doc-1", deserialized.id());
            null
            );
    // see https://github.com/elastic/elasticsearch/issues/15754
        addToTranslogAndList(translog, ops, new Translog.Delete("2", 1, primaryTerm.get()));
                success = true;
            }
        final String translogUUID = translog.getTranslogUUID();
                    RuntimeException e = new RuntimeException("simulated");
                views.peek().add(op);
                maxOp = next;
                            for (Translog.Operation expectedOp : expectedOps) {
        final Settings settings = Settings.builder()
                    config,
            Translog translog = new LocalTranslog(
                seqNo -> {},
            }
                config,
            config.getTranslogPath().resolve(Translog.getCommitCheckpointFileName(read.generation)),
                    assertNull(ex.getCause().getMessage());
                            op = new Translog.NoOp(seqNoGenerator.getAndIncrement(), primaryTerm.get(), randomAlphaOfLength(16));
                translogGeneration = translog.getGeneration();
        do {
            )
                globalCheckpoint.set(globalCheckpoint.get() + randomIntBetween(1, 16));
                .earliestLastModifiedAge(-1)
            }
            try {
        Translog.Operation.writeOperation(out, index);
        assertThat(reader.getTranslogChecksum(), nullValue());
            () -> new TranslogStats.Builder().numberOfOperations(1)
    public void testTranslogOpSerialization() throws Exception {
 * Modifications Copyright OpenSearch Contributors. See
            assertThat(persistedSeqNos, contains(1L, 2L));
                    logger.info("--> [{}] done. tested [{}] snapshots", threadId, iter);
        );
            assertEquals("payload mismatch for operation 1", Integer.parseInt(firstOp.getSource().source.utf8ToString()), 1);
        };
                }
        final int prepareOp = randomIntBetween(0, translogOperations - 1);
        } catch (MockDirectoryWrapper.FakeIOException ex) {
        assertThat(expectedException, is(not(nullValue())));
            try (
import org.opensearch.index.seqno.LocalCheckpointTrackerTests;
            }
                return lastGlobalCheckpoint.get();
            final byte[] source = new byte[300];
                for (int i = 0; i < locations.size(); i++) {
                @Override
                if (generationSeqNo.stream().map(Tuple::v1).max(Long::compareTo).orElse(Long.MIN_VALUE) >= seqNo) {
        }
                                assertThat(checkpoint.minSeqNo, lessThanOrEqualTo(op.seqNo()));
        Thread[] threads = new Thread[threadCount];
            TranslogReader reader = translog.openReader(
            final Checkpoint writerCheckpoint = writer.getCheckpoint();
        long fromSeqNo = 0L;
                "lastCommitted must be 1 less than current",
            if (threadExceptions[i] != null) {
                        assertEquals(expIndexOp.routing(), indexOp.routing());
                    int iter = 0;
    }
        List<Translog.Location> locations = new ArrayList<>();
        }
            assertThat(snapshot1, SnapshotMatchers.equalsTo(ops.get(0)));
            int count = 0;
                () -> SequenceNumbers.NO_OPS_PERFORMED,
        ParsedDocument doc = new ParsedDocument(versionField, seqID, "1", null, Arrays.asList(document), B_1, MediaTypeRegistry.JSON, null);
                            return super.write(src);
            this.opsPerThread = opsPerThread;
            MisbehavingTranslog(
        assertThat(reader.getCheckpoint().minSeqNo, equalTo(minSeqNo));
        return translog.add(op);
import java.util.Random;
            config.getTranslogPath(),
                primaryTerm::get,
        for (long i = minRetainedReader.generation; i < generation + rolls; i++) {
     */
        StreamInput in = out.bytes().streamInput();
        final AtomicInteger writeCalls = new AtomicInteger();
            }
            getPersistedSeqNoConsumer(),
            }
        );
                    }
    }
        if (translog.isOpen()) {
                                lastCommittedLocalCheckpoint.set(localCheckpoint);
                if (fail.fail()) {
                            .collect(Collectors.toList());
        final long minSeqNo = seenSeqNos.stream().min(Long::compareTo).orElse(SequenceNumbers.NO_OPS_PERFORMED);
                    if (checkpoint.numOps == unsynced.size() + syncedDocs.size()) {
        views.push(new ArrayList<>());
        }
                    }
        translog.trimOperations(primaryTerm.get(), 0);
        private final Map<Long, Translog.Operation> operations = new HashMap<>();
        TranslogConfig config = translog.getConfig();
                assertThat("location mismatch at op " + i, batchLocations[i], equalTo(singleLocations.get(i)));
            fail("closed");
        assertEquals(max.generation, translog.currentFileGeneration());
            final Throwable current = queue.remove();
                    null
                    final Translog.Operation.Type type = randomFrom(Translog.Operation.Type.values());
                    channel
        );
                channelFactory,
        int seqNo = 0;
        List<Translog.Location> locations = new ArrayList<>();
            throws MockDirectoryWrapper.FakeIOException {
        if (randomBoolean()) {
        out.setVersion(oldVersion);
                config,
                createTranslogDeletionPolicy(),
import org.opensearch.index.seqno.LocalCheckpointTracker;
                    "lastCommitted must be 3 less than current - we never finished the commit and run recovery twice",
                    }
                );
                        assertThat(noOp.primaryTerm(), equalTo(expectedNoOp.primaryTerm()));
                        syncedDocs.clear();
import static org.hamcrest.Matchers.empty;
                    while (idGenerator.get() < maxOps) {
            final int threadId = i;
        out.setVersion(wireVersion);
        } catch (AlreadyClosedException ex) {
                @Override
                } catch (TranslogException | MockDirectoryWrapper.FakeIOException ex) {
                closeOnTragicEvent(e);
        return string;
            thread.start();
                        assertEquals(expIndexOp.id(), indexOp.id());
        assertThat(persistedSeqNos, empty());
                        lineFileDocs.nextDoc().toString().getBytes(Charset.forName("UTF-8"))
                recoveredTranslog.rollGeneration();
import static org.hamcrest.Matchers.hasToString;
        TranslogThread(
            operationsByGen.put(translog.currentFileGeneration(), ops);
        }
            translog.add(new Translog.Index("" + op, op, primaryTerm.get(), Integer.toString(op).getBytes(StandardCharsets.UTF_8)));
            int iters = randomIntBetween(10, 100);
import static org.hamcrest.Matchers.in;
                assertNotNull("" + i, next);
            ByteBuffer buffer = ByteBuffer.allocate(4);
                    if (committing && checkpoint.minTranslogGeneration == checkpoint.generation) {
        }
                () -> SequenceNumbers.NO_OPS_PERFORMED,
        }
                }
            }
        final TestTranslog.FailSwitch fail = new TestTranslog.FailSwitch();
            boolean foundUnrouted = false;
            .filter(e -> e.getKey() >= translog.getMinFileGeneration())
    public void testDeleteRoutingBackwardCompatibility() throws Exception {
                    assertEquals(Integer.toString(op), read.getSource().source.utf8ToString());
    ) throws IOException {
            long localCheckpointOfSafeCommit = SequenceNumbers.NO_OPS_PERFORMED;
                )
        } else {
    private List<Translog.Operation> buildHttpLogLikeOps(int n, long seqNoBase) {
                translog.rollGeneration();
                tlog.currentFileGeneration()
                persistedSeqNos::add,
                        expectedOps.removeIf(op -> op.seqNo() <= committedLocalCheckpointAtView);
            threads[i].setDaemon(true);
    }
        final Path singleDir = createTempDir();
            if (randomBoolean()) {
                    getTranslogConfig(path),
        deletionPolicy.setLocalCheckpointOfSafeCommit(localCheckpoint);
        in = out.bytes().streamInput();
                }
    }
        }
        final TranslogDeletionPolicy deletionPolicy = new DefaultTranslogDeletionPolicy(-1, -1, 0);
            Translog.parseIdFromFileName(file);
        // we intentionally don't close the tlog that is in the prepareCommit stage since we try to recovery the uncommitted
            }
        int numOps = randomIntBetween(100, 200);
                            opsSynced,
        // translog here as well.
            });
            randomSeqNum,
                    translogGeneration.translogFileGeneration
            .mapToLong(e -> e.getValue())
                    final ByteBuffer buffer = ByteBuffer.allocate(4);
 *
            assertNotNull(noOp);
            locations.add(
import java.util.concurrent.BrokenBarrierException;
        // add a single operation to current with seq# > trimmed seq# but higher primary term
                        translog.currentFileGeneration(),
        // self control cleaning for test
        }
            assertNotNull(translogGeneration);
        assertTrue(translog.getTragicException() instanceof UnknownException);
    }
        translog.add(new Translog.Index("" + 0, 0, primaryTerm.get(), Integer.toString(0).getBytes(Charset.forName("UTF-8"))));
                primaryTerm::get,
            channelFactory,
    public void testSnapshotReadOperationInReverse() throws Exception {
        translog.sync();
                            while ((op = snapshot.next()) != null) {
        if (expectIntactTranslog) {
    public void testLocalTranslogGenerationHasNoFooter() throws IOException {
                            }
                            case INDEX:
                                if (writeStarted.getCount() > 0) {
                    .setLocalCheckpointOfSafeCommit(randomLongBetween(deletionPolicy.getLocalCheckpointOfSafeCommit(), i));
            Translog.Snapshot snapshot2 = translog.newSnapshot();
        // increment primaryTerm to avoid potential negative numbers
        try (Translog reopenedTranslog = openTranslog(config, failableTLog.getTranslogUUID())) {
            doc,
    }
                    }
                        }
                        if (randomBoolean()) {
            final BytesStreamOutput out = new BytesStreamOutput();
                        case DELETE:
        final String reason = randomAlphaOfLength(16);
                    assertNotNull("operation " + i + " must be non-null synced: " + sync, next);
            final boolean commit = commitOften ? frequently() : rarely();
                try {
        translog.close();
        int threadCount = 2 + randomInt(5);
import org.opensearch.common.util.io.IOUtils;
                        + "\"total_uploads\":{\"started\":0,\"failed\":0,\"succeeded\":0},"
                                seqNoGenerator.getAndIncrement(),
            randomInt(),
        }
        }
        final ChannelFactory channelFactory = (file, openOption) -> {
        translog.add(new Translog.Index("1", 0, primaryTerm.get(), Integer.toString(1).getBytes(Charset.forName("UTF-8"))));
            );
                int upTo = sync ? translogOperations : prepareOp;
            deletionPolicy,
        }
                throw new MockDirectoryWrapper.FakeIOException();
                channelFactory
import java.util.ArrayList;
            this.threadExceptions = threadExceptions;
            TranslogOperationHelper.DEFAULT,
    }
    public void tearDown() throws Exception {
                        public int write(ByteBuffer src) throws IOException {
import org.opensearch.common.util.concurrent.AbstractRunnable;
                assertThat(snapshot.totalOperations(), equalTo(opCount));
            StandardOpenOption.TRUNCATE_EXISTING
            Randomness.shuffle(batch);
        assertThat(total.getUncommittedOperations(), equalTo(statsList.stream().mapToInt(TranslogStats::getUncommittedOperations).sum()));
        translog.sync();
        Checkpoint read = Checkpoint.read(ckp);
    public void testPendingDelete() throws IOException {
                null
        final boolean longRetention = randomBoolean();
                // Will flush on read
                Translog.Operation op = next.getValue();
                                op = new Translog.NoOp(id, 1, Long.toString(id));
            fail.failRandomly();
            .stream()
            deletionPolicy,
        in.setVersion(wireVersion);
            error.getMessage(),
                primaryTerm::get,
            total.add(stats);
            assertThat(translog.stats().getUncommittedOperations(), equalTo(uncommittedOps));
                checkpoint
import org.opensearch.common.bytes.ReleasableBytesReference;
                    assertEquals(ex, failableTLog.getTragicException());
import org.opensearch.index.mapper.ParseContext.Document;
import org.opensearch.core.xcontent.ToXContent;
        byte[] bytes = new byte[4];
            );
        public void run() {
        Randomness.shuffle(shuffledSeqNos);
        }
            } else {
        translog.close();
        Map<Long, List<Translog.Operation>> operationsByGen = new HashMap<>();
            deletionPolicy.setLocalCheckpointOfSafeCommit(localCheckpoint);
        }
                final boolean isCkpFile = file.getFileName().toString().endsWith(".ckp");
        deletionPolicy.setLocalCheckpointOfSafeCommit(
                        List<Translog.Operation> ops = IntStream.range(0, between(1, 10))
        final TranslogConfig batchConfig = new TranslogConfig(
                            synchronized (signalReaderSomeDataWasIndexed) {
            }
                    IOUtils.closeWhileHandlingException(delegate);
        return new Term("_id", Uid.encodeId(doc.id()));
            primaryTerm::get,
            // immediate cleanup
                    translog.currentFileGeneration()
        assertThat(
            translogCorruptedException.getMessage(),
                            if (randomBoolean()) {
            )
            try (
        final long firstOperationPosition = translog.getFirstOperationPosition();
        ) {
            );
    private TranslogConfig getTranslogConfig(final Path path) {
            this.partialWrite = partialWrite;
                );
            // all is well
        }
        return new Checkpoint(
            () -> SequenceNumbers.NO_OPS_PERFORMED,
    }
                assertEquals(
        Files.createFile(config.getTranslogPath().resolve("translog-" + (read.generation + 2) + ".tlog"));
        final AtomicLong seqNo = new AtomicLong();
            List<Long> seqNos = new ArrayList<>();
                        locations.get(i).generation
            assertEquals(
            deletionPolicy,
                            failableTLog.getDeletionPolicy().setLocalCheckpointOfSafeCommit(opsAdded);
        }
        }
                    new Translog.Index("" + op, op, primaryTerm.get(), Integer.toString(++count).getBytes(Charset.forName("UTF-8")))
                int upTo = sync ? translogOperations : prepareOp;
            assertThat(stats.getTranslogSizeInBytes(), equalTo(194L));
        int minUncommittedOp = -1;
        assertThat(e, hasToString(containsString("translogSizeInBytes must be >= 0")));
                    assertTrue(locations.get(j).equals(locations2.get(j)));
        return new LocalTranslog(
                }
                assertTrue("we only synced a previous operation yet", translog.syncNeeded());
        assertThat(total.getTranslogSizeInBytes(), equalTo(0L));
        try (Translog.Snapshot snapshot = this.translog.newSnapshot(randomLongBetween(0, firstUncommitted), Long.MAX_VALUE)) {
        final TranslogConfig config,
                )
            }
            Translog.Index test = new Translog.Index(
                .uncommittedOperations(1)
        try (Translog.Snapshot snapshot = translog.newSnapshot(fromSeqNo, toSeqNo, true)) {
                .earliestLastModifiedAge(1)
            ) {
        // check that despite of IO exception translog is not corrupted
                    TranslogOperationHelper.DEFAULT,
        for (int i = 0; i < iters; i++) {
            Translog.parseIdFromFileName(file);
     */
            translog.sync();
        assertEquals(translogOperations, translog.totalOperations());
            }
        final Checkpoint checkpoint = Checkpoint.read(translogDir.resolve(Translog.getCommitCheckpointFileName(closedGeneration)));
    }
            ArrayList<Translog.Operation> ops = new ArrayList<>();
import org.opensearch.index.engine.Engine.Operation.Origin;
        translog.close();
        assertThat((int) firstOperationPosition, greaterThan(CodecUtil.headerLength(TranslogHeader.TRANSLOG_CODEC)));
        int iters = randomIntBetween(5, 10);
            if (frequently()) {
        }
        long localCheckpoint = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, op);
            for (TestTranslog.LocationOperation locationOperation : collect) {
        Collection<Translog.Operation> operations() {
                    if (randomBoolean()) {
                totOps++;
                }
        @Override
                final FileChannel channel;
            }
    public void testSimpleCommit() throws IOException {
        for (long l : periods) {
                        }
        final TranslogConfig temp = getTranslogConfig(tempDir);
                translog.add(new Translog.Index("" + op, op, primaryTerm.get(), Integer.toString(op).getBytes(Charset.forName("UTF-8"))))
    /** A single-element batch and an empty batch must behave sanely and match the single-op path. */
    }
            () -> new TranslogStats.Builder().numberOfOperations(-1)
            if (fail.fail()) {
                    }
            primaryTerm.get()
        final Set<Long> seenSeqNos = new HashSet<>();
                    assertEquals("payload missmatch", i, Integer.parseInt(next.getSource().source.utf8ToString()));
            try {
                        writtenOperations.get(i).location.generation
            }
    }
import java.util.concurrent.ArrayBlockingQueue;
            )
        final Object flushMutex = new Object();
                            translogFsyncCalls.incrementAndGet();
                    if (src.hasRemaining()) {
import java.util.Deque;
            IOUtils.close(translog);
            fail.failAlways();
            void deleteReaderFiles(TranslogReader reader) {
            channelFactory
        // a map of all written ops and their returned location.
        final Exception[] threadExceptions = new Exception[threadCount];
            // drop all that haven't been synced
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), seqNo);
                    IOUtils.closeWhileHandlingException(delegate);
            );
                }
        final Settings settings = Settings.builder()
                        assertEquals("payload mismatch, synced: " + sync, i, Integer.parseInt(next.getSource().source.utf8ToString()));
 */
                    reader.close();
        DataOutput out = EndiannessReverserUtil.wrapDataOutput(new ByteArrayDataOutput(bytes));
            tlog.add(new Translog.Index("" + 1, 1, primaryTerm.get(), Integer.toString(1).getBytes(Charset.forName("UTF-8"))));
     * this class mimic behaviour of original {@link Translog}
                    null
            translog.add(new Translog.Index("1", 0, primaryTerm.get(), Integer.toString(1).getBytes(Charset.forName("UTF-8"))));
                    TranslogOperationHelper.DEFAULT,
            generation,
                if (randomBoolean()) {
            final long generation = translog.getMinGenerationForSeqNo(seqNo).translogFileGeneration;
        try (
                }
        );
                Translog.Snapshot snapshot = tlog.newSnapshot()
                                translog.rollGeneration();
                        case NO_OP:
                fail.failNever();
                            throw new AssertionError("unsupported operation type [" + type + "]");
        TranslogConfig config = translog.getConfig();
            assertNotNull("operation 1 must be non-null", op);
                        // captures al views that are written since the view was created (with a small caveat see bellow)
            assertTrue(ex.getCause() instanceof UnknownException);
            assertThat(stats.getEarliestLastModifiedAge(), greaterThan(0L));
        for (int i = 0; i < writers.length; i++) {
            thread.join();
                final DataOutput out = EndiannessReverserUtil.wrapDataOutput(new ByteArrayDataOutput(bytes));
        logger.info("using [{}] readers. [{}] writers. flushing every ~[{}] ops.", readers.length, writers.length, flushEveryOps);
        expectThrows(AssertionError.class, () -> misbehavingTranslog.callCloseDirectly());
        List<Translog.Location> locations = new ArrayList<>();
        addToTranslogAndList(translog, ops, new Translog.NoOp(seqNo, noopTerm, reason));
            readers[i] = new Thread(new AbstractRunnable() {
        for (long gen = 1; gen < translog.getMinFileGeneration(); gen++) {
        final TranslogCorruptedException translogCorruptedException = expectThrows(
    }
            shardId,
        }
    protected final ShardId shardId = new ShardId("index", "_na_", 1);
        Translog.writeOperations(out, ops);
            )
                primaryTerm::get,
    }
            TranslogOperationHelper.DEFAULT,
        Map<Long, Long> maxSeqNoPerGeneration = new HashMap<>();
                            opsSynced,
                }
                config,
                deletionPolicy.setLocalCheckpointOfSafeCommit(i);
    public void testSnapshotTrimmedOperations() throws Exception {
                }
        id = randomIntBetween(0, Integer.MAX_VALUE);
        int i = 0;
import org.opensearch.core.common.unit.ByteSizeUnit;
                    barrier.await();
                    + primaryTerm.get()
            final List<Long> storedPrimaryTerms = Stream.concat(translog.getReaders().stream(), Stream.of(translog.getCurrent()))
            super(delegate);
                        final Translog.NoOp noOp = (Translog.NoOp) op;
            // we don't know when things broke exactly
    public void testRecoveryUncommittedCorruptedCheckpoint() throws IOException {
            assertEquals(0, translog.stats().estimatedNumberOfOperations());
                    primaryTerm::get,
            try (Translog.Snapshot snapshot = new TestTranslog.SortedSnapshot(translog.newSnapshot())) {
            Throwable e = errors.get(0);
                    throw e;
        translog.sync();
        document.add(new TextField("value", "test", Field.Store.YES));
        }
        }
                final boolean isCkpFile = file.getFileName().toString().endsWith(".ckp");
                            if (synced) {
                source.set(randomAlphaOfLengthBetween(1, 50));
            config,
                        locations.get(i).generation
        }
                config,
                                signalReaderSomeDataWasIndexed.notifyAll();
            .build();
                    generationUUID = failableTLog.getTranslogUUID();
            }
                                }
                String translogUUID,
                translogGeneration.translogFileGeneration + 1,
                try {
import java.nio.file.StandardOpenOption;
                        src.limit(limit);
                    if (loc == location) {
                        try (Translog.Snapshot snapshot = translog.newSnapshot(committedLocalCheckpointAtView + 1L, Long.MAX_VALUE)) {
            assertThat(snapshot, SnapshotMatchers.size(numOps));
            IllegalArgumentException.class,
            primaryTerm.get()
        Translog.Operation.writeOperation(out, delete);
        // translog here as well.
        @Override
            () -> SequenceNumbers.NO_OPS_PERFORMED,
        int threadCount = 2 + randomInt(5);
                    translogGeneration.translogFileGeneration + 3,
        // we intentionally don't close the tlog that is in the prepareCommit stage since we try to recovery the uncommitted
            }
        TranslogConfig config = getTranslogConfig(tempDir);
                        @Override
    }
                }
                        new Translog.Index("" + op, op, primaryTerm.get(), Integer.toString(op).getBytes(Charset.forName("UTF-8")))
        translog.close();
                null
                () -> SequenceNumbers.NO_OPS_PERFORMED,
        in.setVersion(Version.CURRENT);
                    randomBoolean(),
        final AtomicInteger checkpointFsyncCalls = new AtomicInteger();
                }
                    new Translog.Index(
import java.util.stream.Collectors;
                null
            deletionPolicy.setRetentionAgeInMillis(-1);
            batchLocations = batchTranslog.add(ops);
                    assertNotNull("operation " + i + " must be non-null", next);
    }
                translogUUID,
                }
        final Translog.Location[] locs = translog.add(one);
                        Translog.Delete expDelOp = (Translog.Delete) expectedOp;
                            break;
     * same operations added one at a time. We build two translogs from identical configs/ops and compare on disk.
                    truncations.incrementAndGet();
            try (
    ) throws IOException {
    private Translog getFailableTranslog(TestTranslog.FailSwitch fail, final TranslogConfig config) throws IOException {
                    final int value = buffer.getInt();
    }
     * that we can, after we hit an exception, open and recover the translog successfully and retrieve all successfully synced operations
                for (int i = 0; i < opsSynced; i++) {
        IllegalArgumentException e = expectThrows(
                config,
            translog = new LocalTranslog(
        final String translogUUID = Translog.createEmptyTranslog(
        seqID.seqNo.setLongValue(randomSeqNum);
            return translog.add(op);
        }
            final TestTranslog.FailSwitch fail = new TestTranslog.FailSwitch();
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
                    final Set<Tuple<Long, Long>> generationSeenSeqNos = new HashSet<>();
    private static final class UnknownException extends RuntimeException {
import java.nio.charset.StandardCharsets;
            1,
                    assertNotNull("operation " + i + " must be non-null", next);
                            "" + opsSynced,
            final int threadId = i;
            boolean success = false;
                translogUUID,
        IOException expectedException = null;
        Collections.shuffle(locations, random());
     * Randomly truncate some bytes in the translog files
                    tragedy.setTragicException(e);
    public void testLocationComparison() throws IOException {
                        assertEquals(expDelOp.version(), delOp.version());
            throw e;
            translog.getMaxSeqNo(),
                }
        final BlockingQueue<TestTranslog.LocationOperation> writtenOperations = new ArrayBlockingQueue<>(threadCount * opsPerThread);
        addToTranslogAndList(translog, ops, new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
        try {
                            case NO_OP:
            assert old == null || old.primaryTerm() <= operation.primaryTerm();
                config,
            threads[i].start();
            try (Translog.Snapshot snapshot = tlog.newSnapshot()) {
                        super.write(src, position);
            new ByteSizeValue(4, ByteSizeUnit.KB),
            "",
                config,
                .earliestLastModifiedAge(1)
            try {
                TranslogOperationHelper.DEFAULT,
                    }
        logger.info("--> test done. total ops written [{}]", writtenOps.size());
                            committing = false;
                } else {
                assertThat(snapshot.totalOperations(), greaterThan(0));
                    )
                    super.copy(source, target, options);
            assertTrue(e.getMessage().contains("Not all operations between from_seqno"));
                translogGeneration.translogFileGeneration + 2,
        final TranslogDeletionPolicy deletionPolicy = createTranslogDeletionPolicy(translogConfig.getIndexSettings());
            newUid(doc),
            this.downLatch = downLatch;
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
                }
        assertThat(fileChannels, is(not(empty())));
                            .mapToObj(n -> new Translog.Index("1", nextSeqNo.incrementAndGet(), primaryTerm.get(), new byte[] { 1 }))
                    IOUtils.closeWhileHandlingException(failableTLog);
            }
                                seqNoGenerator.getAndIncrement(),
                            synchronized (flushMutex) {
                    };
            for (int i = firstUncommitted; i < translogOperations; i++) {
        for (int i = 0; i < operations; i++) {
    }
            try (Translog.Snapshot snapshot = new TestTranslog.SortedSnapshot(translog.newSnapshot())) {
                    Checkpoint checkpoint = Translog.readCheckpoint(config.getTranslogPath());
                        "" + opsAdded,
                    assertFileDeleted(translog, i);
        private final boolean partialWrite;
                Translog tlog = new LocalTranslog(
            Translog translog = new LocalTranslog(
            } catch (TranslogException | MockDirectoryWrapper.FakeIOException | TranslogCorruptedException ex) {
                    };
                .build()
                ThrowingFileChannel throwingFileChannel = new ThrowingFileChannel(
            doc.id(),
                assertTrue("one pending operation", translog.syncNeeded());
                    translog.add(
        for (Path file : files) {
 * this work for additional information regarding copyright
                primaryTerm::get,
        long fromSeqNo = randomLongBetween(maxSeqNo + 1, Long.MAX_VALUE);
            super.tearDown();
                translogUUID,
            IllegalArgumentException.class,
                                primaryTerm.get(),
            }
            )
        for (op = translogOperations / 2; op < translogOperations; op++) {
                    generationUUID,
                consumer.accept(seqNo);
            assertThat(noOp.reason(), equalTo(reason));
            if (fail.fail()) {
                downLatch,
                            }
        final TestTranslog.FailSwitch fail = new TestTranslog.FailSwitch();
        final List<Translog.Operation> allOperations = new ArrayList<>();
                    Translog.Location add = super.add(op);
            }
                    translogGeneration.translogFileGeneration
        final Path batchDir = createTempDir();
                    assertEquals(syncedDocs.get(i), next.getSource().source.utf8ToString());
        logger.info("testing with [{}] threads, each doing [{}] ops", threadCount, opsPerThread);
            }
    }
                try (Translog.Snapshot snapshot = new TestTranslog.SortedSnapshot(translog.newSnapshot())) {
            config,
        assertEquals(delete, serializedDelete);
        );
                copy.toXContent(builder, ToXContent.EMPTY_PARAMS);
    public void testFailOnClosedWrite() throws IOException {
            translog.add(operation);
            }
            IllegalArgumentException.class,
                assertThat(translog.stats().getUncommittedOperations(), equalTo(operationsInLastGen));
        Engine.IndexResult eIndexResult = new Engine.IndexResult(1, randomPrimaryTerm, randomSeqNum, true);
                    () -> SequenceNumbers.NO_OPS_PERFORMED,
        try {
                return lastGlobalCheckpoint.addAndGet(randomIntBetween(1, 100));
            null
        for (final Long seqNo : shuffledSeqNos) {
        Translog.Location max = locations.get(0);
                translog.currentFileGeneration()
        assertThat(Translog.findEarliestLastModifiedAge(fixedTime, readers, w), equalTo(LongStream.of(periods).max().orElse(0L)));
                    TranslogDeletionPolicy deletionPolicy = createTranslogDeletionPolicy();
            Collections.addAll(queue, current.getSuppressed());
import org.opensearch.index.mapper.IdFieldMapper;
                TranslogOperationHelper.DEFAULT,
            temp.getIndexSettings(),
        return currentSeqNo;
        TranslogConfig config = translog.getConfig();
                            unsynced.clear();
            for (int i = 0; i < threadCount; i++) {
                .translogSizeInBytes(1)
            @Override
            TranslogOperationHelper.DEFAULT,
        }
                // make it a noop like the old versions
                    config,
        }
            final AtomicLong seqNo = new AtomicLong();
                        throw new IOException("__FAKE__ no space left on device");
                null
                    translogUUID,
        final Exception[] threadExceptions = new Exception[threadCount];
        ) {
            temp.getBigArrays(),
        for (int op = 0; op < translogOperations; op++) {
                            break;
            config,
            assertFileIsPresent(translog, 1);
            read,
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
        }
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                translogGeneration = translog.getGeneration();
            primaryTerm::get,
            }
                );
            assertFalse(translog.isOpen());
import java.util.Iterator;
    }
            "",
            .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
            try {
                    );
    public void testRangeSnapshot() throws Exception {
            snapshot.close();
                        .reduce((a, b) -> b)
        assertThat(translog.currentFileGeneration(), Matchers.not(equalTo(firstId)));
                if (rarely()) {
            );
                public void doRun() throws BrokenBarrierException, InterruptedException, IOException {
            assertThat(readFromSnapshot, equalTo(expectedSnapshotOps));
        final Set<Long> persistedSeqNos = new HashSet<>();
    public void testCheckpointOnDiskFull() throws IOException {
                Translog.Index op = new Translog.Index(randomAlphaOfLength(10), seqNo, primaryTerm.get(), new byte[] { randomByte() });
                                break;
            } catch (IOException ex) {
                    added.countDown();
import java.io.IOException;
        List<Translog.Location> locations = new ArrayList<>();
            }
            if (rarely() && translogOperations > op + 1) {
        deserialized = (Translog.Delete) Translog.Operation.readOperation(in);
            new ByteSizeValue(1, ByteSizeUnit.KB),
                protected TranslogWriter createWriter(
            assertThat(noOp.primaryTerm(), equalTo(noopTerm));
                        }
            primaryTerm::get,
        final boolean throwUnknownException,
            this.threadId = threadId;
                        super.write(src);
            final int threadId = i;
                                deletionPolicy.setLocalCheckpointOfSafeCommit(localCheckpoint);
            try (Translog.Snapshot snapshot = batchTranslog.newSnapshot()) {
    }
            channelFactory,
        try (
            if (frequently()) {
        int translogOperations = randomIntBetween(10, 100);
                null
        try (Translog.Snapshot snapshot = translog.newSnapshot(fromSeqNo, toSeqNo)) {
                locations.add(
            fail("invalid pattern");
package org.opensearch.index.translog;
        assertThat("at least one truncation was caused and caught", truncations.get(), greaterThanOrEqualTo(1));
                for (int i = 0; i < opCount; i++) {
                        primaryTerm.get(),
                assertFileIsPresent(translog, generation + i);
                    for (int i = 0; i < threadCount; i++) {
            int readFromSnapshot = 0;
        final Exception[] threadExceptions = new Exception[threadCount];
        } finally {
            assertFilePresences(translog);
        final TestTranslog.FailSwitch fail = new TestTranslog.FailSwitch();
        Checkpoint.write(
        translog.close();
                        "expected operation" + i + " to be in the previous translog but wasn't",
            randomNonNegativeLong(),
        // byte identity.
        final Map<Long, Translog.Operation> latestOperations = new HashMap<>();
                for (Translog.Operation op : operationsByGen.getOrDefault(gen, Collections.emptyList())) {
                seqNo -> {},
        downLatch.countDown();
                    if (retentionLock != null) {
            for (long seqNo : seqNos) {
                final long seqNo = randomValueOtherThanMany(seqNos::contains, () -> randomLongBetween(0, 1000));
        try (
        private final Translog translog;
            config.getTranslogPath().resolve(Translog.getCommitCheckpointFileName(read.generation)),
                primaryTerm::get,
        ) {
            () -> globalCheckpoint.get(),
                config,
                assertFalse("all of the locations should be synced: " + location, translog.ensureSynced(location));
     */
                }
        for (int i = 0; i < numOps; i++) {
                    closeRetentionLock();
    }
        }
                    deletionPolicy,
            ByteBuffer buffer = ByteBuffer.allocate(4);
            for (int b = 0; b < source.length; b++) {
                createTranslogDeletionPolicy(config.getIndexSettings()),
                                .append("]");
        globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
                        Translog.Index indexOp = (Translog.Index) op;
                            assertThat(checkpoint.offset, greaterThanOrEqualTo(location.translogLocation));
            new ByteSizeValue(1, ByteSizeUnit.KB),
                    }
            writers[i] = new Thread(new AbstractRunnable() {
    }
                return channel;
            ) {
            new LocalTranslog(
            for (long g = generation; g < translog.currentFileGeneration(); g++) {
            if (op == prepareOp) {
                config,
            translog.add(new Translog.Index(Integer.toString(i), i, primaryTerm.get(), new byte[] { 1 }));
            // all is well
                assertEquals(
                seqNo -> {},
                totalOperations++;
            );
            locations.add(
                }
            assertFileIsPresent(translog, generation + i);
 *
            false
            assertThat(translog.currentFileGeneration(), equalTo(generation + i + 1));
                                assertThat("seq# " + op.seqNo() + " was not marked as persisted", persistedSeqNos, hasItem(op.seqNo()));
        @Override
                    closeRetentionLock();
        final TranslogWriter writer = translog.createWriter(translog.currentFileGeneration() + 1);
                }
        for (Translog.Location location : locations) {
        Path ckp = config.getTranslogPath().resolve(Translog.CHECKPOINT_FILE_NAME);
                    opCountPerGeneration.put(g, opCount);
            // w00t
                tragedy.setTragicException(e);
            List<Translog.Operation> ops = new ArrayList<>(seqNos.size());
                        Set<Translog.Operation> expectedOps = new HashSet<>(writtenOps.keySet());
                forwardConfig,
    }
        for (Thread thread : writers) {
        for (int i = 0; i < numOps; i++) {
            StandardOpenOption.WRITE,
                translog.rollGeneration();
                try {
        final String expectedExceptionMessage = "simulated failure during copy";
                        + 273
        logger.debug("--> waiting for threads to stop");
            assertThat(snapshot.totalOperations(), equalTo(ops.size()));
                    channel = delegate;
            fail("invalid pattern");
                        assertThat(opCount, equalTo(reader.totalOperations()));
                final FileChannel channel;
        for (int opsAdded = 0; opsAdded < numOps; opsAdded++) {
        TranslogConfig config = getTranslogConfig(tempDir);
                    logger.info("--> [{}] done. wrote [{}] ops.", threadName, counter);
                TranslogOperationHelper.DEFAULT,
                        (key, existing) -> existing == null ? seqNo : Math.max(existing, seqNo)
        final TranslogDeletionPolicy deletionPolicy = translog.getDeletionPolicy();
            if (frequently()) {
        Field idField = new Field("_id", Uid.encodeId("1"), IdFieldMapper.Defaults.FIELD_TYPE);
        writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), randomNonNegativeLong());
     * from the transaction log.
            );
            }
                        Translog.Location location = translog.add(op);
            SequenceNumbers.NO_OPS_PERFORMED,
            translog.add(new Translog.NoOp(seqNo++, primaryTerm.get(), "test'"));
                                } catch (InterruptedException e) {
                assertFalse("no sync needed since no operations in current translog", translog.syncNeeded());
     * A batch add must produce a byte-identical translog file, identical Locations, and the same readable ops as the
                () -> SequenceNumbers.NO_OPS_PERFORMED,
                () -> SequenceNumbers.NO_OPS_PERFORMED,
                );
    }
                    isCkpFile ? false : partialWrites,
    @Override
                    throw new MockDirectoryWrapper.FakeIOException();
                final boolean isCkpFile = file.getFileName().toString().endsWith(".ckp");
                            primaryTerm.get(),
                    deletionPolicy,
        List<TestTranslog.LocationOperation> collect = new ArrayList<>(writtenOperations);
                TranslogOperationHelper.DEFAULT,
import org.opensearch.common.UUIDs;
                }
        final List<FileChannel> fileChannels
            );
                deletionPolicy,
                                primaryTerm.get(),
                }
        deletionPolicy.setRetentionSizeInBytes(randomLong());
import static org.hamcrest.Matchers.equalTo;
        );
                assertFalse("translog has been synced already", translog.ensureSynced(locations.stream()));
        long minSeqNo = SequenceNumbers.NO_OPS_PERFORMED;
        assertThat(failableTLog.isOpen(), is(false));
                close();
            .max()
                    final Checkpoint checkpoint = Checkpoint.read(translog.location().resolve(Translog.getCommitCheckpointFileName(g)));
                () -> SequenceNumbers.NO_OPS_PERFORMED,
            return super.write(src);
                    assertEquals(i, value);
            assertThat(stats.estimatedNumberOfOperations(), equalTo(0));
        }
            batchBytes = Files.readAllBytes(batchDir.resolve(Translog.getFilename(gen)));
                assertFileDeleted(translog, i);
                    assertEquals("payload mismatch, synced: " + sync, i, Integer.parseInt(next.getSource().source.utf8ToString()));
            assertThat(snapshot, SnapshotMatchers.equalsTo(ops));
                    assertEquals(expectedOp, translog.readOperation(locationOperation.location));
            Translog singleTranslog = openTranslog(singleConfig, singleUUID);
                                assertThat(checkpoint.globalCheckpoint, greaterThanOrEqualTo(globalCheckpoint));
        translog = new LocalTranslog(
        for (int i = 0; i < readers.length; i++) {
            assertThat(translog.getMinFileGeneration(), greaterThanOrEqualTo(1L));
        return seqNo -> {
                    seqNo -> {},
                    channel = new FilterFileChannel(delegate) {
                    try (TranslogReader reader = translog.openReader(translog.location().resolve(Translog.getFilename(g)), checkpoint)) {
     */
        Checkpoint read = Checkpoint.read(tempDir.resolve("foo.cpk"));
                    primaryTerm::get,
 * ownership. Elasticsearch licenses this file to you under
            List<Translog.Operation> expectedOps = new ArrayList<>();
import java.util.concurrent.Phaser;
        } else {
        Checkpoint read = Checkpoint.read(ckp);
            newUid(doc),
                TranslogOperationHelper.DEFAULT,
        Files.copy(ckp, config.getTranslogPath().resolve(Translog.getCommitCheckpointFileName(read.generation)));
        assertThat(translog.currentFileGeneration(), equalTo(generation + rolls));
            }
            List<Translog.Operation> ops = new ArrayList<>(seqNos.size());
        TranslogConfig config = translog.getConfig();
import org.opensearch.common.util.concurrent.ReleasableLock;
            try (
        if (reader instanceof TranslogReader) {
        List<Closeable> toClose = new ArrayList<>();
                TranslogOperationHelper.DEFAULT,
        for (long gen = 1; gen < minRetainedGen; gen++) {
                    if ("doc-1".equals(del.id())) {
            TranslogWriter writer = translog.getCurrent();
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 3);
                assertNotNull(translogGeneration);
        final boolean commitOften = randomBoolean();
import java.util.concurrent.atomic.AtomicInteger;
        assertEquals(ex.getMessage(), "failed to create new translog file");
            if (firstGenOps == null) {
        if (minSeqNo > 0) {
    public void testMaxSeqNo() throws Exception {
            try {
            }
                if (op instanceof Translog.Delete) {
            locations.add(
                Translog.Snapshot snapshot = translog.newSnapshot(localCheckpointOfSafeCommit + 1, Long.MAX_VALUE)
                assertEquals(
                                1 + randomInt(100000)
        periods[numberOfReaders] = period;
                // some strings (like '/' , '..') do not refer to a file, which we this method should return
    // close method should never be called directly from Translog (the only exception is closeOnTragicEvent)
            try {
        };
                                }
            }
            StandardOpenOption.WRITE,
    }
    }
                translog.add(
        try (Translog tlog = openTranslog(config, translog.getTranslogUUID()); Translog.Snapshot snapshot = tlog.newSnapshot()) {
            createTranslogDeletionPolicy(),
        try {
            assertFalse(tlog.syncNeeded());
        this.translog = new LocalTranslog(
        List<Translog.Location> locations2 = new ArrayList<>();
    protected Translog translog;
        for (int i = 0; i < threadCount; i++) {
            ArrayList<Location> locations = new ArrayList<>();
                    // it in the finally block but miss to copy over unsynced docs to syncedDocs and fail the assertion down the road...
        TranslogConfig config = translog.getConfig();
            Translog.Delete delete = (Translog.Delete) snapshot.next();
        assertThat(e, hasToString(containsString("uncommittedOperations must be >= 0")));
            translog.rollGeneration();
        String translogUUID = Translog.createEmptyTranslog(
            assertNull(snapshot.next());
        }
                primaryTerm::get,
            assertFalse(translog.syncNeeded());
    public void testLegacyCheckpointVersion() throws IOException {
                TranslogOperationHelper.DEFAULT,
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
            fail.failRate(attempt < maxAttempts - 1 ? 25 : 100);
                if (rarely()) {
        TranslogException ex = expectThrows(
        };
        );
import static org.opensearch.common.util.BigArrays.NON_RECYCLING_INSTANCE;
            batchTranslog.sync();
                locations.add(location);
        List<Translog.Location> locations = new ArrayList<>();
        }
                        Translog.Operation next = snapshot.next();
                assertEquals(expectedOp.opType(), op.opType());
                seqNo -> {},
        translog.add(new Translog.Index("boom", 0, primaryTerm.get(), "boom".getBytes(Charset.forName("UTF-8"))));
        final CountDownLatch writeStarted = new CountDownLatch(1);
        deletionPolicy.setLocalCheckpointOfSafeCommit(localCheckpoint);
            long seqNo;
    public void testOpenForeignTranslog() throws IOException {
                primaryTerm.get(),
    }
            config.getTranslogPath(),
            temp.getShardId(),
    }
            int opsPerThread,
        out.setVersion(wireVersion);
        }
                    logger.info("--> [{}] min gen after acquiring lock [{}]", threadId, translog.getMinFileGeneration());
    private Translog getFailableTranslog(
                    // lets close the translog and if it succeeds we are all synced again. If we don't do this we will close
                    Translog.Operation next = snapshot.next();
                    () -> SequenceNumbers.NO_OPS_PERFORMED,
        int totalOperations = 0;
                if (randomBoolean()) {
            final TranslogDeletionPolicy deletionPolicy = translog.getDeletionPolicy();
            () -> new TranslogStats.Builder().numberOfOperations(1)
                assertTrue("this operation has not been synced", translog.ensureSynced(locations.stream()));
    }
                    seqNo -> {},
                    globalCheckpointSupplier,
        Translog translog = createTranslog(config);
        );
            Set<Long> seqNos = new HashSet<>();
        // Byte-identical .tlog payloads. The two files share an identical header layout (same version, same UUID
        public long write(ByteBuffer[] srcs, int offset, int length) throws IOException {
        assertEquals(read, checkpoint);
                assertEquals(ex.getMessage(), "__FAKE__ no space left on device");
            } catch (InvalidPathException ex) {
                translog.rollGeneration();
                        src.limit(randomIntBetween(pos, limit));
            try (Translog.Snapshot snapshot = translog.newSnapshot(seqNo, Long.MAX_VALUE)) {
            Translog.Operation secondOp = snapshot.next();
                    2L,
            }
                failSwitch.failNever(); // don't fail in the ctor
        try (
                seqNo -> {},
        try (
                minSeqNo = SequenceNumbers.min(minSeqNo, currentSeqNo);
        final long localCheckpoint;
                        assertEquals("tenant-routing", del.routing());
                                translog.trimUnreferencedReaders();
import org.apache.lucene.store.ByteArrayDataOutput;
                        }
                }
                TranslogConfig config,
                assertFalse(translog.syncNeeded());
        );
        final TranslogReader reader = translog.readers.stream()
