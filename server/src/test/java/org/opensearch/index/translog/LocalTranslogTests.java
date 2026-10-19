            }  
                translog.rollGeneration();
                tlog.currentFileGeneration()
        } while (Translog.PARSE_STRICT_ID_PATTERN.matcher(string).matches() || validPathString == false);
        translog.rollGeneration();
        final Object flushMutex = new Object();
import java.util.concurrent.atomic.AtomicBoolean;
        final TestTranslog.FailSwitch fail = new TestTranslog.FailSwitch();
                    seqNo -> {},  
        LineFileDocs lineFileDocs = new LineFileDocs(random()); // writes pretty big docs so we cross buffer borders regularly  
    }
import org.opensearch.index.mapper.ParsedDocument;
                for (int i = 0; i < numOps; i++) {  
        final boolean commitOften = randomBoolean();
        };
}
import org.apache.lucene.tests.mockfile.FilterFileChannel;
                    assertThat(Tuple.tuple(op.seqNo(), op.primaryTerm()), is(in(seenSeqNos)));  
                            failableTLog.getDeletionPolicy().setLocalCheckpointOfSafeCommit(opsAdded);
                if (partialWrite) {
            reader.readBytes(buffer, pos);
                assertThat(persistedSeqNos, empty());
    public void assertFileDeleted(Translog translog, long id) {
                        + ",\"remote_store\":{\"upload\":{"
            final Throwable current = queue.remove();
    public void testRecoveryFromAFutureGenerationCleansUp() throws IOException {
                try {
            statsList.add(stats);  
            false
            if (rarely()) {  
                long prevSize = f.size();
        try (
import java.util.ArrayDeque;
                    translog.currentFileGeneration()  
        {
import static org.mockito.Mockito.when;
            List<Long> seqNos = LongStream.range(startSeqNo, startSeqNo + randomInt(100)).boxed().collect(Collectors.toList());
        fail.failNever();  
            AtomicReference<String> source = new AtomicReference<>();
        long randomPrimaryTerm = randomBoolean() ? 0 : randomNonNegativeLong();
                final byte[] bytes = new byte[4];
                TranslogOperationHelper.DEFAULT,
        for (final Tuple<Long, Long> tuple : seqNos) {
        globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
        LongSupplier globalCheckpointSupplier = () -> {
                    null
            }
        // check that despite of IO exception translog is not corrupted  
                }  
            AtomicLong nextSeqNo = new AtomicLong();
                            .collect(Collectors.toList());  
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
        }
        expectThrows(AssertionError.class, () -> misbehavingTranslog.callCloseDirectly());
        for (int i = 0; i < numOps; i++) {
                                    writeStarted.countDown();  
                }  
            return super.position();
                        long id = idGenerator.getAndIncrement();  
        try (
            config.getTranslogPath(),  
                protected void doRun() throws Exception {
                for (int i = 0; i < operations; i++) {
                    int opCount = 0;  
        }
            // disable retention so we trim things  
            assertNull(snapshot.next());  
            translog.add(
            config.getTranslogPath(),
                assertEquals(syncedDocs.size(), snapshot.totalOperations());  
                translog.rollGeneration();  
                }  
                public void force(boolean metaData) throws IOException {
    }
        final AtomicInteger translogFsyncCalls = new AtomicInteger();
            total.estimatedNumberOfOperations(),
                assertFalse(translog.syncNeeded());  
        AssertionError error = expectThrows(AssertionError.class, () -> translog.trimOperations(primaryTerm.get(), 0));  
        assertThat(expectThrows(TranslogCorruptedException.class, () -> {
        );  
            new ByteSizeValue(4, ByteSizeUnit.KB),  
                builder.startObject();  
        );
            // at least one roll + inc of primary term has to be there - otherwise trim would not take place at all
            assertThat(snapshot, SnapshotMatchers.size(1));
                        case DELETE:
                () -> SequenceNumbers.NO_OPS_PERFORMED,
        seqID.primaryTerm.setLongValue(randomPrimaryTerm);
            () -> new LocalTranslog(  
                    }
                    () -> SequenceNumbers.NO_OPS_PERFORMED,
                .build()
import java.util.Iterator;
        }
        final TestTranslog.FailSwitch fail,  
                TranslogOperationHelper.DEFAULT,
        }
        logger.info("--> test done. total ops written [{}]", writtenOps.size());
                        Translog.Location existing = writtenOps.put(op, location);
            }  
            }
                    fail,
            Translog singleTranslog = openTranslog(singleConfig, singleUUID);
                null
    private Long populateTranslogOps(boolean withMissingOps) throws IOException {  
        // force stopping, if all writers crashed
            config,  
            if (generationUUID == null) {
                    };  
            singleDir,  
            signalReaderSomeDataWasIndexed.notifyAll();
        Translog.writeOperations(out, ops);
                    barrier.await();  
                TranslogOperationHelper.DEFAULT,
        for (int i = 0; i < readers.length; i++) {
        translog.sync();
            reader.readBytes(buffer, reader.getFirstOperationOffset() + 4 * i);
        final int generations = between(2, 20);
        try {
                new Translog.Index(Integer.toString(op), op, primaryTerm.get(), Integer.toString(op).getBytes(Charset.forName("UTF-8")))
            fail("translog doesn't belong to this UUID");  
        final boolean sync = randomBoolean();  
            )
        final String translogUUID = translog.getTranslogUUID();
        final TranslogDeletionPolicy deletionPolicy = translog.getDeletionPolicy();
                    )  
        Translog.Index serializedIndex = (Translog.Index) Translog.Operation.readOperation(in);  
import org.opensearch.index.engine.Engine;  
                );  
                }
        translog.add(new Translog.Delete("3", 2, primaryTerm.get()));  
        );  
            Translog.Operation secondOp = snapshot.next();
                        if (id % 7 == 0) {  
            // all good
            try (Translog.Snapshot snapshot = translog.newSnapshot(seqNo, Long.MAX_VALUE)) {
                translog.sync();
            try {  
        }
        translog.add(new Translog.Index("1", 0, primaryTerm.get(), Integer.toString(1).getBytes(Charset.forName("UTF-8"))));
        }
                translog.add(  
            assertFalse(tlog.syncNeeded());
            getPersistedSeqNoConsumer(),
        }  
            VersionType.INTERNAL,
            } while (seenSeqNos.contains(seqNo));  
            assertThat(snapshot.totalOperations(), equalTo(1));
            assertEquals(
        logger.info("testing with [{}] threads, each doing [{}] ops", threadCount, opsPerThread);  
            Translog.Snapshot snapshot = translog.newSnapshot(0, randomIntBetween(0, 10));  
            assertFalse(tlog.syncNeeded());
            TranslogOperationHelper.DEFAULT,
                }
                    assertNotNull("operation " + i + " must be non-null synced: " + sync, next);
        );
        final boolean throwUnknownException,
            }
            translog.add(new Translog.NoOp(i, 0, "test"));
        final TranslogDeletionPolicy deletionPolicy = createTranslogDeletionPolicy(translogConfig.getIndexSettings());  
        if (longRetention) {
    /**
        final Exception[] threadExceptions = new Exception[threadCount];
 *
import java.util.Collection;
        );
        }
                    seqNo -> {},
        // we intentionally don't close the tlog that is in the prepareCommit stage since we try to recovery the uncommitted
        }  
            assertFalse(translog.syncNeeded());
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {  
                } else {
            .filter(r -> r.getCheckpoint().generation >= minRetainedReader.generation)
                channelFactory
            randomLong(),  
                    TranslogDeletionPolicy deletionPolicy = createTranslogDeletionPolicy();
        }
            Translog translog = new LocalTranslog(
                .translogSizeInBytes(1)  
            }
            seqNo -> {},  
        translog.close();
            } finally {  
                }
                        .map(allOp -> ((Translog.Index) allOp).source().utf8ToString())
    public void testFailFlush() throws IOException {
                    assertNotNull("operation " + i + " must be non-null", next);
                failed = true;
                    for (int opsAdded = 0; opsAdded < numOps; opsAdded++) {
    public void testBasicSnapshot() throws IOException {
        ArrayList<Translog.Operation> ops = new ArrayList<>();
        final String foreignTranslog = randomRealisticUnicodeOfCodepointLengthBetween(1, translogGeneration.translogUUID.length());  
                    translog.add(
                }
            assertFileDeleted(translog, gen);
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(shardId.getIndex(), settings);
                            );
            IndexSettingsModule.newIndexSettings(shardId.getIndex(), settings),
            for (final long op : ops) {
            String ascii = randomAlphaOfLengthBetween(1, 50);  
        translog = create(translogDir);
    }  
import java.util.Map;
            views.add(new ArrayList<>());
                        src.position(pos);
            if (rarely()) {
            try {
    }  
    public void testDeleteRoutingBackwardCompatibility() throws Exception {  
                // have to use exactly the same source for same seq# if primaryTerm is not changed
            )
            writtenOperations.removeIf(next -> checkpoint.offset < (next.location.translogLocation + next.location.size));  
                                    // Ignore
        }
                                    // Ignore
import org.opensearch.test.OpenSearchTestCase;
        Translog.TranslogGeneration translogGeneration = null;
                    atLeastOneFailed = true;
                TranslogOperationHelper.DEFAULT,
                if (!seqNoPerGeneration.containsKey(g)) {
            if (randomBoolean()) {
        }
        final List<Translog.Operation> allOperations = new ArrayList<>();
        long maxSeqNo = SequenceNumbers.NO_OPS_PERFORMED;
                threadExceptions
        try (
            assertThat(stats.getUncommittedOperations(), equalTo(1));  
            try (Translog.Snapshot snapshot = this.translog.newSnapshot()) {  
            assertThat(persistedSeqNos, contains(1L, 2L, 3L, 4L));
                threadExceptions
        Path ckp = config.getTranslogPath().resolve(Translog.CHECKPOINT_FILE_NAME);
            }
    public void testAcquiredLockIsPassedToDeletionPolicy() throws IOException {
        }  
        // engine blows up, after committing the above generation
        Translog.Operation.writeOperation(out, index);  
                    translogUUID,
                        throw new IOException("__FAKE__ no space left on device");
                    generationUUID,
                }
            if (rarely()) {  
            operationsByGen.put(translog.currentFileGeneration(), ops);  
        Path tempDir = createTempDir();  
import java.util.stream.IntStream;
            }
                public void doRun() throws BrokenBarrierException, InterruptedException, IOException {
            false
                            op = new Translog.NoOp(seqNoGenerator.getAndIncrement(), primaryTerm.get(), randomAlphaOfLength(16));
        final TranslogConfig config,
        }).getMessage(), containsString(translogDir.toString()));
        Checkpoint.write(  
        translog.add(new Translog.Delete("2", 1, primaryTerm.get()));
    }
                                seqNoGenerator.getAndIncrement(),
        }
        BytesStreamOutput out = new BytesStreamOutput();
                lastSyncedGlobalCheckpoint = globalCheckpoint.get();
                assertThat(writeCalls.get(), greaterThan(initialWriteCalls));
        public long position() throws IOException {  
        }
        }
        Translog.Delete deleteWithRouting = new Translog.Delete("doc-1", 1, 1, 1, "tenant-abc");  
            readers[i].start();
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 4);
        List<Translog.Location> locations = new ArrayList<>();  
                        Translog.Operation operation;
                seenSeqNos.add(seqNo);
    public void expectIntactTranslogByDefault() {
import java.util.stream.Stream;
        return new LocalTranslog(  
            translog.add(op);
                            StringBuilder missed = new StringBuilder("missed ").append(expectedOps.size())  
        final List<TranslogStats> statsList = new ArrayList<>(n);  
import java.util.concurrent.BrokenBarrierException;
            }
        periods[numberOfReaders] = period;  
                @Override
import java.io.Closeable;
        Path tempDir = createTempDir();
            Translog.Delete delete = (Translog.Delete) snapshot.next();
            translog.sync();
    public void testOpenForeignTranslog() throws IOException {  
            }  
 * this work for additional information regarding copyright
        final long maxSeqNo = seenSeqNos.stream().max(Long::compareTo).orElse(SequenceNumbers.NO_OPS_PERFORMED);
                            }  
    /**  
        }
            translogUUID,  
        final int opCount = 250;
        String translogUUID = Translog.createEmptyTranslog(
                maxSeqNo = SequenceNumbers.max(maxSeqNo, currentSeqNo);  
                assertTrue("one pending operation", translog.syncNeeded());  
        final int opsPerThread = randomIntBetween(10, 200);  
                seqNo -> {},  
        Path path = createTempDir();
            assertThat(persistedSeqNos, empty());
            assertThat(stats.getEarliestLastModifiedAge(), greaterThan(0L));
        if (randomBoolean()) { // recover twice
import static org.hamcrest.CoreMatchers.hasItem;  
        for (Path file : files) {
                primaryTerm::get,  
            Translog tlog = new LocalTranslog(
            "",
        void trimOperations(long belowTerm, long aboveSeqNo) {  
                )  
        Checkpoint read = Checkpoint.read(ckp);
                }
                config,  
                config,  
import java.io.EOFException;
            assertThat(snapshot, SnapshotMatchers.size(0));  
                    deletionPolicy,  
                } finally {
                        public int write(ByteBuffer src) throws IOException {  
            translog.add(new Translog.NoOp(randomNonNegativeLong(), 0, "test'"));
        Files.copy(ckp, config.getTranslogPath().resolve(Translog.getCommitCheckpointFileName(read.generation)));
        int translogOperations = randomIntBetween(10, 100);
                protected void afterAdd() throws IOException {  
            read,  
        Translog translog = getFailableTranslog(fail, config, false, true, null, createTranslogDeletionPolicy());
                void acquireRetentionLock() throws IOException {
        return new Term("_id", Uid.encodeId(doc.id()));
    public void testCloseConcurrently() throws Throwable {
            addToTranslogAndList(translog, ops, new Translog.Index("2", 1, primaryTerm.get(), new byte[] { 2 }));  
            null
    }
    }
            tlog.add(new Translog.Index("" + 1, 1, primaryTerm.get(), Integer.toString(1).getBytes(Charset.forName("UTF-8"))));
            Translog translog = new LocalTranslog(
                config,
        List<Translog.Location> locations = new ArrayList<>();
                minSeqNo = SequenceNumbers.min(minSeqNo, seqNo);
        List<Translog.Location> locations = new ArrayList<>();
                assertNotNull(ex.getCause());  
                translogGeneration = translog.getGeneration();  
                if (success == false) {  
                if (frequently()) {  
                e.addSuppressed(suppress);  
        while (queue.isEmpty() == false) {
                consumer.accept(seqNo);
                new DefaultTranslogDeletionPolicy(-1, -1, 0),
        Translog.TranslogGeneration translogGeneration = null;  
                }
            for (int i = 0; i < opCount; i++) {  
            }
        primaryTerms.add(primaryTerm.get());
            super.tearDown();
            Translog.parseIdFromFileName(file);  
                    translogGeneration.translogFileGeneration + 3,
                    translog.currentFileGeneration()
        final ChannelFactory channelFactory = (file, openOption) -> {  
        try (  
    }  
        TranslogException ex = expectThrows(
        assertThat(reader.getTranslogContentChecksum(), nullValue());
        assertEquals(ex.getMessage(), "translog is already closed");
            .filter(r -> r.getGeneration() == closedGeneration)  
        assertEquals("doc-1", deserialized.id());  
            }  
                    } catch (IOException inner) {
                );  
            final int threadId = i;
    }  
            maxSeqNo = b;
                translog.trimUnreferencedReaders();
        }
        try (  
                config,
                    seqNo -> {},  
                Translog.Snapshot snapshot = tlog.newSnapshot()  
                translog.add(
 * SPDX-License-Identifier: Apache-2.0
            }
                            opsSynced,
            translogUUID,
        for (int i = 0; i <= rolls; i++) {
            assertThat(stats.estimatedNumberOfOperations(), equalTo(0));  
            assertThat(persistedSeqNos, contains(1L, 2L, 3L, 4L, 5L));
            Translog.Snapshot snapshot2 = translog.newSnapshot();
        assertThat(
        try (Translog.Snapshot snapshot = translog.newSnapshot(fromSeqNo, toSeqNo)) {
                assertNull(snapshot.next());
                    config,
                    TranslogOperationHelper.DEFAULT,
        );
            assertThat(snapshot.totalOperations(), equalTo(1));
    }
            }
            assertThat(snapshot, SnapshotMatchers.equalsTo(ops));
                                op = new Translog.Index("" + id, id, primaryTerm.get(), new byte[] { (byte) id });
                                threadId + "_" + opCount,
        deletionPolicy.setLocalCheckpointOfSafeCommit(localCheckpoint);
            if (randomBoolean()) {  
        expectThrows(AssertionError.class, () -> misbehavingTranslog.callCloseUsingIOUtilsWithExceptionHandling());  
                        assertEquals(expDelOp.id(), delOp.id());
        }  
        assertEquals(ex.getMessage(), "failed to create new translog file");  
            equalTo(statsList.stream().mapToLong(TranslogStats::getUncommittedSizeInBytes).sum())  
            );
                                    blocker.await();  
        long nextSeqNo = populateTranslogOps(false);  
            }
                            }
            }
        for (int iterations = between(1, 10), i = 0; i < iterations; i++) {  
            // we don't know when things broke exactly
                        + "}}}}",
                LongSupplier globalCheckpointSupplier,
            assertThat(stats.getUncommittedSizeInBytes(), equalTo(218L));
            ArrayList<Translog.Operation> ops = new ArrayList<>();  
                    primaryTerm::get,
                        + ",\"earliest_last_modified_age\":"
            // otherwise our assertions here are off by one sometimes.
                final List<Translog.Operation> expectedSeqNo = new ArrayList<>();  
                }
            assertEquals(
        toSeqNo = randomLongBetween(fromSeqNo, 2000);  
        final Map<Long, Integer> opCountPerGeneration = new HashMap<>();
                translogGeneration.translogFileGeneration + 2,  
                primaryTerm::get,  
            assertNotNull(maxOp);
                .build()
            assertThat(translog.totalOperations(), equalTo(totalOperations));  
        }
            locations.add(translog.add(new Translog.Index("" + op, op, primaryTerm.get(), ascii.getBytes("UTF-8"))));
                // failed - that's ok, we didn't even create it or it was corrupted from partial writes  
            channelFactory,
                if (generationSeqNo.stream().map(Tuple::v1).max(Long::compareTo).orElse(Long.MIN_VALUE) >= seqNo) {
                    if (retentionLock != null) {
        final AtomicInteger checkpointFsyncCalls = new AtomicInteger();
            }
        final String batchUUID = Translog.createEmptyTranslog(batchDir, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());  
        assertThat(alreadyClosedException.getMessage(), is("translog is already closed"));
            locations.add(translog.add(new Translog.Index("" + op, op, primaryTerm.get(), ascii.getBytes("UTF-8"))));
                primaryTerm.get(),
                if (drop) {
            int translogOperations = randomIntBetween(10, 100);
            } finally {  
            0,
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {  
        Path file = translogDir.resolve(Translog.TRANSLOG_FILE_PREFIX + id + ".tlog");
        for (int i = 0; i < numOps; i++) {  
                    "lastCommitted must be 3 less than current - we never finished the commit and run recovery twice",
                    assertEquals(next, writtenOperations.get(i).operation);  
            null  
            generation,
            translogConfig,  
        Translog.Operation.writeOperation(out, deleteWithRouting);
        private final AtomicLong seqNoGenerator;  
 * Licensed to Elasticsearch under one or more contributor  
                primaryTerm::get,  
            }
        }  
                assertTrue("this operation has not been synced", translog.ensureSynced(locations.stream()));
        translog.getDeletionPolicy().setLocalCheckpointOfSafeCommit(randomLongBetween(0, operations));
        }
            if (randomBoolean()) {
                translogUUID,  
            periods[i] = randomLongBetween(10000, 1000000);  
            List<String> unsynced = new ArrayList<>();  
            deletionPolicy.setRetentionAgeInMillis(3600 * 1000);
            seqNos.add(Tuple.tuple(seqNo, terms.computeIfAbsent(seqNo, k -> 0L)));  
            translog = new LocalTranslog(  
            TranslogSnapshot snapshot = reader.newSnapshot();
            if (rarely()) {  
            assertThat(translog.estimateTotalOperationsFromMinSeq(seqNo), equalTo(expectedSnapshotOps));  
                .translogSizeInBytes(1)
import static org.hamcrest.Matchers.containsString;
                boolean shouldAdd = !withMissingOps || seqNo % 4 != 0;
                    logger.error(() -> new ParameterizedMessage("--> writer [{}] had an error", threadName), e);  
                        tlog.currentFileGeneration() - 1,
            TranslogDeletionPolicy deletionPolicy = createTranslogDeletionPolicy();  
                primaryTerm::get,  
    }
            .put(IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.getKey(), randomIntBetween(-1, 2048) + "b")
                    switch (type) {  
            for (long seqNo : seqNos) {
            return translog.add(op);
        translog.add(operation);
        );
                        }
        translog.sync();
                    isCkpFile ? false : partialWrites,  
        ) {
        }
            () -> new LocalTranslog(
            boolean foundRouted = false;
            final List<Long> storedPrimaryTerms = Stream.concat(translog.getReaders().stream(), Stream.of(translog.getCurrent()))
            assertNull(snapshot.next());
        List<Translog.Location> locations = new ArrayList<>();
                }
            }
        }
            translogUUID,
        for (int i = 0; i < threadCount; i++) {
        long minSeqNo = SequenceNumbers.NO_OPS_PERFORMED;
            final TranslogStats stats = stats();
                for (int i = 0; i < opsSynced; i++) {
                assertThat(readerCheckpoint, equalTo(writerCheckpoint));
            }
            // if we have a LeakFS here we fail if not all resources are closed
                    }
            error.getMessage(),
                        final Translog.Operation op;
        final long minSeqNo = seenSeqNos.stream().min(Long::compareTo).orElse(SequenceNumbers.NO_OPS_PERFORMED);  
        final boolean sync = randomBoolean();
                lastSynced = op;
    }
        assertThat(
            return;
        @Override
        long fromSeqNo = 0L;
                    closeRetentionLock();
            // only randomize between nog age retention and a long one, so failures will have a chance of reproducing
                locations.add(
        final TranslogConfig temp = getTranslogConfig(tempDir);  
            Translog translog = new LocalTranslog(
import org.opensearch.cluster.metadata.IndexMetadata;
        Field idField = new Field("_id", Uid.encodeId("1"), IdFieldMapper.Defaults.FIELD_TYPE);
            failedToSyncCheckpoint.set(true);
                            Translog.Location location = null;
            translogUUID,
                        unsynced.clear();  
            shardId,
            assertThat(translog.getMinFileGeneration(), lessThanOrEqualTo(minGenForRecovery));
        long period = randomLongBetween(10000, 1000000);
                Translog.Index op = new Translog.Index(randomAlphaOfLength(10), seqNo, primaryTerm.get(), new byte[] { 1 });
            }
                if (success == false) {
                    default:
                if (isCkpFile) {
                writtenOperations,
            Randomness.shuffle(seqNos);  
                builder.endObject();
            temp.getIndexSettings(),
            threads[i] = new TranslogThread(
                    null
            translog.getTranslogUUID(),  
                }
                        locations.get(i).generation  
            throw e;
                translog.getTranslogUUID(),  
        file = translogDir.resolve(Translog.TRANSLOG_FILE_PREFIX + id);
    }
                        List<Translog.Operation> ops = IntStream.range(0, between(1, 10))
            long localCheckpointOfSafeCommit = SequenceNumbers.NO_OPS_PERFORMED;
                createTranslogDeletionPolicy(forwardConfig.getIndexSettings()),
                totOps++;
                    case INDEX:
        final Set<Long> persistedSeqNos = new HashSet<>();  
                return channel;
        // we control retention via time, disable size based calculations for simplicity  
            }
                                location = translog.add(op);
        final long seqNo = randomLongBetween(0, Integer.MAX_VALUE);  
                        }  
            }
            // if we hit a tragic event. this is important to ensure that asserts inside the Translog#add doesn't trip
                            .mapToObj(n -> new Translog.Index("1", nextSeqNo.incrementAndGet(), primaryTerm.get(), new byte[] { 1 }))
                @Override
                ops.add(op);
        TranslogConfig config = getTranslogConfig(tempDir);
        } else {
import static org.hamcrest.Matchers.is;
            }
import org.apache.lucene.store.AlreadyClosedException;
        assertThat(
            }
            if (threadExceptions[i] != null) {
                primaryTerm::get,
            }
            new ByteSizeValue(10 + randomInt(128 * 1024), ByteSizeUnit.BYTES)
            }  
            }  
                translog.rollGeneration();
        TranslogWriter w = mock(TranslogWriter.class);
            final String threadName = "writer_" + i;
        for (int i = headerSize; i < singleBytes.length; i++) {
            translog.rollGeneration();
        }
            if (fail.fail()) {  
                            Checkpoint checkpoint = translog.getLastSyncedCheckpoint();  
        deserialized = (Translog.Delete) Translog.Operation.readOperation(in);
import static org.opensearch.index.translog.TranslogDeletionPolicies.createTranslogDeletionPolicy;
                    maxSeqNoPerGeneration.compute(
        assertThat("all file channels have to be closed", fileChannels.stream().filter(f -> f.isOpen()).findFirst().isPresent(), is(false));
                failableTLog.add(operation);  
            )  
        MisbehavingTranslog misbehavingTranslog = new MisbehavingTranslog(
        if (expectIntactTranslog) {  
                translog.currentFileGeneration()
        Path tempDir = createTempDir();  
            int numOps = randomIntBetween(4, 10);  
        out = new BytesStreamOutput();
        final TranslogConfig translogConfig = getTranslogConfig(path);
        Collections.sort(collect);  
            idGenerator.set(Long.MAX_VALUE);  
        // a map of all written ops and their returned location.
        translog = new LocalTranslog(
                seqNoGenerator,
            assertThat(persistedSeqNos, contains(1L, 2L));
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {  
                LongSupplier primaryTermSupplier  
                    } else if ("doc-2".equals(del.id())) {
                }
            for (TestTranslog.LocationOperation locationOperation : collect) {
        ) {  
        String uuid = translog.getTranslogUUID();
                () -> SequenceNumbers.NO_OPS_PERFORMED,
            } else {
            locations.add(
            fail.failRandomly();
                                break;
        long randomSeqNum = randomNonNegativeLong();  
        long fromSeqNo = 0L;
                }  
        TranslogConfig config = translog.getConfig();  
        assertThat(translog.getMaxSeqNo(), equalTo(expectedMaxSeqNo));
                null
            }
        return stats;
        document.add(seqID.seqNoDocValue);  
            this.writtenOperations = writtenOperations;  
            if (atLeastOneFailed == false) {
import java.util.concurrent.CopyOnWriteArrayList;  
        final String translogUUID = translog.getTranslogUUID();
                                op = new Translog.Delete(Long.toString(id), id, primaryTerm.get());
                assertFalse("no sync needed since no operations in current translog", translog.syncNeeded());  
            // fine
                    generationUUID = failableTLog.getTranslogUUID();
            temp.getIndexSettings(),
        translogDir = createTempDir();  
        final Checkpoint checkpoint = Checkpoint.read(translogDir.resolve(Translog.getCommitCheckpointFileName(closedGeneration)));
                fileChannels.add(channel);
import java.util.ArrayList;  
            equalTo(statsList.stream().mapToInt(TranslogStats::estimatedNumberOfOperations).sum())  
                                failed = true;
                            translog.ensureSynced(location);
                    throw new UnknownException();
        file = translogDir.resolve(Translog.TRANSLOG_FILE_PREFIX + randomNonTranslogPatternString(1, 10) + id);  
        TranslogThread(
                }  
                long committedLocalCheckpointAtView;
import org.opensearch.core.common.bytes.BytesArray;  
 * Modifications Copyright OpenSearch Contributors. See
                } else {
    }
        file = translogDir.resolve(Translog.TRANSLOG_FILE_PREFIX + id + ".recovering");
                super(
                channelFactory,
    public void testIdParsingFromFile() {
        Translog.TranslogGeneration translogGeneration = translog.getGeneration();  
                    super.force(metaData);
                    case NO_OP:
                        Set<Translog.Operation> expectedOps = new HashSet<>(writtenOps.keySet());  
            TranslogWriter writer = translog.getCurrent();
                    assertNotNull("operation " + i + " must be non-null", next);  
        translog.getDeletionPolicy().setLocalCheckpointOfSafeCommit(randomLongBetween(3, Long.MAX_VALUE));  
        writer.sync();
    }
            TranslogCorruptedException.class,  
            assertEquals(initialWriteCalls, writeCalls.get());
                    deletionPolicy,
                config,  
            assertThat(stats.estimatedNumberOfOperations(), equalTo(4));
        final int opsPerThread = randomIntBetween(10, 200);
        translog.rollGeneration();
            null  
    }
    public void testRangeSnapshot() throws Exception {
        int firstUncommitted = 0;  
        final Settings settings = Settings.builder()
            TranslogOperationHelper.DEFAULT,  
                    barrier.await();  
            assertFileIsPresent(translog, i);
            assertNull(snapshot.next());
        in.setVersion(wireVersion);  
    }
                null
        }  
                    IOUtils.closeWhileHandlingException(delegate);
                    super.deleteReaderFiles(reader);  
                        assertNotNull("operation " + i + " must be non-null synced: " + sync, next);
                        src.limit(limit);  
    }  
    protected final ShardId shardId = new ShardId("index", "_na_", 1);  
            }
    }
        assertThat(e, hasToString(containsString("translogSizeInBytes must be >= 0")));
            fail.failNever(); // we don't wanna fail here but we might since we write a new checkpoint and create a new tlog file
                        counter++;
import org.opensearch.index.translog.Translog.Location;
                seqNo -> {},  
            final int threadId = i;  
                    createTranslogDeletionPolicy()
    }  
    }
                translog.add(new Translog.Index("" + op, op, primaryTerm.get(), Integer.toString(op).getBytes(Charset.forName("UTF-8"))))  
            ops.add(new Translog.Index(id, seqNo, primaryTerm.get(), source));
        int translogOperations = randomIntBetween(10, 100);
        };
        for (int opsAdded = 0; opsAdded < numOps; opsAdded++) {
                    final Translog.Operation read = snapshot.next();
                close();  
            assertThat(snapshot, SnapshotMatchers.size(0));
                assertNotNull("" + i, next);
        }
            }
            DataOutput out = EndiannessReverserUtil.wrapDataOutput(new ByteArrayDataOutput(bytes));  
    }
                        assertEquals(expDelOp.version(), delOp.version());
        assertNull("Routing must be null when written with old format", deserialized.routing());
            "",
        final int runs = randomIntBetween(5, 10);  
import java.util.LinkedList;  
        int translogOperations = randomIntBetween(1, 10);
            shardId,
        // translog here as well.  
                } else {
            } finally {  
    public static Translog.Location max(Translog.Location a, Translog.Location b) {
    public void testStats() throws IOException {
            deletionPolicy.setRetentionAgeInMillis(-1);
            )
                    primaryTerm.incrementAndGet();
            Translog forwardTranslog = new LocalTranslog(
        final int generations = randomIntBetween(2, 20);  
                    final int value = buffer.getInt();
            }
        try (
        private final CountDownLatch downLatch;  
        }
                        assertNull(del.routing());
        final ChannelFactory channelFactory = (file, openOption) -> {
            assertThat(translog.stats().getUncommittedOperations(), equalTo(uncommittedOps));
        }  
                @Override
        ) {  
            Translog translog,  
        @Override
        for (long gen = 1; gen < minRetainedGen; gen++) {
                        try {
            seqNo -> {},
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 1);
        translog.add(new Translog.Index("" + 0, 0, primaryTerm.get(), Integer.toString(1).getBytes(Charset.forName("UTF-8"))));
            } catch (IOException ex) {
        Translog.Delete serializedDelete = (Translog.Delete) Translog.Operation.readOperation(in);
            randomBoolean(),
     */
    public void testCloseIntoReader() throws IOException {
    }
            assertBusy(() -> {  
            maxSeqNo,
                primaryTerm::get,
            }
                translogUUID,  
        }
            assertFileIsPresent(translog, 1);  
        Translog.Location loc1 = translog.add(new Translog.Delete("doc-1", 0, primaryTerm.get(), 1, "tenant-routing"));  
import static org.hamcrest.Matchers.not;
        return translog.add(op);
    }
    protected Translog translog;
            IndexFormatTooOldException.class,
        final long firstOperationPosition = translog.getFirstOperationPosition();  
    }
        return new LocalTranslog(  
            .mapToInt(r -> r.getCheckpoint().numOps)
                primaryTerm::get,
                    randomBoolean(),
            .stream()  
                );  
                () -> SequenceNumbers.NO_OPS_PERFORMED,
            // Sequence numbers are marked as persisted after sync  
                            case INDEX:  
        final String translogUUID = translog.getTranslogUUID();
                translog.rollGeneration();
        Engine.IndexResult eIndexResult = new Engine.IndexResult(1, randomPrimaryTerm, randomSeqNum, true);  
                translog.rollGeneration();
                        }
    // close method should never be called directly from Translog (the only exception is closeOnTragicEvent)  
        String translogUUID,
            assertThat(stats.getEarliestLastModifiedAge(), greaterThan(0L));  
            ) {
    public void testRecoverWithUnbackedNextGenAndFutureFile() throws IOException {
            IllegalArgumentException.class,
        translog.rollGeneration();
                createTranslogDeletionPolicy(config.getIndexSettings()),  
    }
                    forwardTranslog.rollGeneration();
                        // slow down things a bit and spread out testing..
                logger.info("--> truncating {}, prev: {}, now: {}", file, prevSize, newSize);  
                    Translog.Operation next = snapshot.next();
            Translog.NoOp noOp = (Translog.NoOp) snapshot.next();  
                                }
                        assertEquals("payload mismatch, synced: " + sync, i, Integer.parseInt(next.getSource().source.utf8ToString()));  
            if (randomBoolean()) {  
        }  
            assertThat(snapshot, SnapshotMatchers.size(0));  
        long toSeqNo = randomLongBetween(fromSeqNo, Long.MAX_VALUE);
            assertThat(stats.getTranslogSizeInBytes(), equalTo(194L));  
    public void testFailOnClosedWrite() throws IOException {  
        }  
                            logger.info("Translog exception", threadExceptions[i]);
            assertThat(stats.getUncommittedOperations(), equalTo(2));
                        + "\"total_upload_size\":{\"started_bytes\":0,\"failed_bytes\":0,\"succeeded_bytes\":0}"  
        final String translogUUID = translog.getTranslogUUID();  
            fail.failRate(attempt < maxAttempts - 1 ? 25 : 100);
        List<Translog.Location> locations = new ArrayList<>();
import java.nio.file.InvalidPathException;
                    assertNotNull("operation " + i + " must be non-null", operation);  
        {
                    int iterations = randomIntBetween(10, 100);
    public void testTotalTests() {
            Translog.Location location = translog.add(  
                    ops.add(op);
        Translog translog = createTranslog(config);
                                throw new AssertionError("unsupported operation type [" + type + "]");
                    + (primaryTerm.get() - 1)  
                final DataOutput out = EndiannessReverserUtil.wrapDataOutput(new ByteArrayDataOutput(bytes));  
                singleLocations.add(singleTranslog.add(op));  
            // all good  
    }
            if (rarely()) {  
            TranslogException.class,
            ByteBuffer buffer = ByteBuffer.allocate(4);
            locations.add(
            @Override
    }  
        }
        assertThat(locs.length, equalTo(1));  
            }
        List<Translog.Location> locations = new ArrayList<>();
                    deleteIfExists(target);
        final int operations = randomIntBetween(1, 4096);
            assertEquals(
            if (seqNo != SequenceNumbers.UNASSIGNED_SEQ_NO) {
                Integer.toString(translogOperations).getBytes(Charset.forName("UTF-8"))
                            for (Translog.Operation op : ops) {  
    }
    private Location addToTranslogAndList(Translog translog, List<Translog.Operation> list, Translog.Operation op) throws IOException {
            assertEquals(op, translog.readOperation(locs.get(i++)));
                        } catch (Exception e) {  
                    assertFileDeleted(translog, i);  
        final String translogUUID = translog.getTranslogUUID();
 *
import java.nio.charset.Charset;  
            }
import java.util.List;
                        assertEquals(expIndexOp.routing(), indexOp.routing());  
            FileChannel delegate = FileChannel.open(file, openOption);
        }
                }  
import org.opensearch.common.util.concurrent.AbstractRunnable;  
            endsWith(
        try (Translog translog = getFailableTranslog(fail, config)) {
            Randomness.shuffle(batch);
                        assertEquals(loc.hashCode(), location.hashCode());
        assertThat(total.getTranslogSizeInBytes(), equalTo(statsList.stream().mapToLong(TranslogStats::getTranslogSizeInBytes).sum()));
        final Path batchDir = createTempDir();  
        assertThat(e, hasToString(containsString("uncommittedOperations must be >= 0")));
                                expectedOps.remove(op);
        final Exception[] threadExceptions = new Exception[threadCount];
                config,  
            final BytesStreamOutput out = new BytesStreamOutput();
                while ((op = snapshot.next()) != null) {
        AtomicLong lastGlobalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);  
            Translog.Snapshot snapshot = translog.newSnapshot();
        assertFalse(translog.isOpen());  
    public void testLocalTranslogGenerationHasNoFooter() throws IOException {  
                new Translog.Index(Integer.toString(op), op, primaryTerm.get(), Integer.toString(op).getBytes(Charset.forName("UTF-8")))  
                                // we're committing - is still present when we're committing  
     * Tests the situation where the node crashes after a translog gen was committed to lucene, but before the translog had the chance
        fail(Translog.getFilename(id) + " is not present in any location: " + translog.location());
                                } catch (InterruptedException e) {
                fail.failNever();  
    /**  
        when(w.getLastModifiedTime()).thenReturn(fixedTime - period);
                    assertEquals(ex.getCause().getMessage(), "__FAKE__ no space left on device");
        assertThat(failableTLog.getTragicException(), equalTo(expectedException));
            if (rarely()) {
                    // boom now we failed
            new LocalTranslog(
            // all is well
                if (op <= lastSynced) {
            assertThat(stats.getUncommittedOperations(), equalTo(3));
            final TranslogStats stats = stats();  
        for (int i = 0; i < numOps; i++) {
import org.opensearch.common.util.io.IOUtils;  
                int upTo = sync ? translogOperations : prepareOp;  
                fail.failAlways();
        }
        document.add(new TextField("value", "test", Field.Store.YES));
                createTranslogDeletionPolicy(),
            translogUUID,
        } else {
                seqNo -> {},  
import org.opensearch.common.collect.Tuple;  
        for (int run = 0; run < runs; run++) {
        int translogOperations = 100;
            int initialWriteCalls = writeCalls.get();
                .uncommittedSizeInBytes(1)  
                closeOnTragicEvent(e);
                    translog.add(
    public void testFullRangeSnapshot() throws Exception {
                assertEquals(opsSynced, snapshot.totalOperations());  
        Checkpoint.write(
                translogUUID,  
                    shardId,
        if (translogUUID == null) {  
        assertEquals("doc-1", deserialized.id());  
     * Tests that closing views after the translog is fine and we can reopen the translog
                    localCheckpointOfSafeCommit = failableTLog.getDeletionPolicy().getLocalCheckpointOfSafeCommit();
            startBlocking.set(true);
                translog.currentFileGeneration()
            threads[i].start();
                        }
            assertThat(storedPrimaryTerms, equalTo(primaryTerms));
            int extraTranslogOperations = randomIntBetween(10, 100);
                failSwitch.failNever(); // don't fail in the ctor
                    assertNotNull(snap.next());
                persistedSeqNos::add,
        ParsedDocument doc = new ParsedDocument(versionField, seqID, "1", null, Arrays.asList(document), B_1, MediaTypeRegistry.JSON, null);
                null
import java.util.concurrent.atomic.AtomicInteger;
        assertThat(expectedException, is(not(nullValue())));
            } else if (rarely()) {
                if (randomBoolean()) {  
            }
            assertThat(snapshot, SnapshotMatchers.equalsTo(ops));
        assertThat(reader.getCheckpoint().maxSeqNo, equalTo(maxSeqNo));  
                assertEquals(  
            assertEquals(
            this.downLatch = downLatch;  
            threads[i] = new TranslogThread(  
import java.util.Arrays;
                    () -> SequenceNumbers.NO_OPS_PERFORMED,
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
                foreignTranslog,
                            for (Translog.Operation op : ops) {  
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
                    logger.error(() -> new ParameterizedMessage("--> reader [{}] had an error", threadId), e);  
        final CountDownLatch downLatch = new CountDownLatch(1);
        }
            readers.add(r);  
        in.setVersion(oldVersion);
            translog.add(  
        }
    private boolean expectIntactTranslog;
     * Tests that concurrent readers and writes maintain view and snapshot semantics  
        }  
        out.setVersion(wireVersion);
                    translog.rollGeneration();  
    }
            assertEquals(0, translog.stats().estimatedNumberOfOperations());
        final String translogUUID;
    }
                if (isCkpFile) {  
                Translog.Operation next = snapshot.next();
            toClose.add(snapshot1);
                assertTrue("at least one operation pending", translog.syncNeeded());
                return throwingFileChannel;
                final Path resolved = translogDir.resolve(string);
        for (final Long seqNo : shuffledSeqNos) {
                        if (iter++ % 10 == 0) {  
                    Translog.Location loc = add(op);
            writer.sync();
        }  
        }  
            SequenceNumbers.NO_OPS_PERFORMED,  
            }
                                translog.trimUnreferencedReaders();  
            assertThat(noOp.primaryTerm(), equalTo(noopTerm));  
        final Set<Throwable> seen = Collections.newSetFromMap(new IdentityHashMap<>());  
                        primaryTerm.get(),
                    IOUtils.closeWhileHandlingException(delegate);
                failSwitch.failAlways();
        // Old version writes without routing, new version reads with routing=null
                        if (id % flushEveryOps == 0) {  
                    IOUtils.closeWhileHandlingException(failableTLog);  
            final Translog.Location location = translog.add(  
            }
            uncommittedOps++;
        long minRetainedGen = translog.getMinGenerationForSeqNo(localCheckpoint + 1).translogFileGeneration;
    }  
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
        final AtomicLong seqNoGenerator = new AtomicLong();  
                );
            }
            false
import java.util.Collections;  
        for (int i = 0; i < n; i++) {
    public void testFailWhileCreateWriteWithRecoveredTLogs() throws IOException {
                primaryTerm::get,
            Translog.Snapshot snapshot1 = translog.newSnapshot();  
        translog.close();  
import org.apache.lucene.index.IndexFormatTooOldException;  
                failableTLog.trimOperations(primaryTerm.get(), maxTrimmedSeqNo);  
                    assertEquals(ex, failableTLog.getTragicException());
                );
        out.setVersion(wireVersion);  
            Translog.Operation next;  
                        primaryTerm.get(),  
                } catch (IOException ex) {  
        try (
        private final int threadId;
        TranslogConfig config = getTranslogConfig(tempDir);
     * Randomly truncate some bytes in the translog files
        final int headerSize = TranslogHeader.headerSizeInBytes(singleUUID);
        }
                translogUUID,
        }  
                );  
        }  
                final Translog failableTLog = getFailableTranslog(
        for (int i = 0; i < operations; i++) {
                        break;
        final long generation = randomNonNegativeLong();
        }
            }
        final TranslogDeletionPolicy deletionPolicy = translog.getDeletionPolicy();
                                missed.append("\n --> [").append(expectedOp).append("] written at ").append(loc);
                locations.add(  
                        // these are what we expect the snapshot to return (and potentially some more).
                    assertFalse("should have failed if sync was needed", syncNeeded);  
                forwardConfig,  
        fail.failNever();
        ) {
        // a signal for all threads to stop
        final Set<Long> seenSeqNos = new HashSet<>();
        assertThat(Translog.parseIdFromFileName(file), equalTo(id));
        }
        }
            .build();
        );
                    assertNotNull("operation " + i + " must be non-null", next);
                    translog.rollGeneration();
    public void testSimpleOperations() throws IOException {  
                    closeRetentionLock();  
                break;  
        assertThat(Translog.readGlobalCheckpoint(translogDir, translogUUID), equalTo(globalCheckpoint.get()));  
            List<Integer> ops = IntStream.range(translogOperations, translogOperations + extraTranslogOperations)
        long seqNo = 0;  
     * concern only (see {@link TranslogFooter}).
                    Translog.Operation next = snapshot.next();
            primaryTerm.get()  
                if (rarely()) {
        ) {  
            )
                if (shouldAdd) {
                    long initialGlobalCheckpoint,
        assertThat(e, hasToString(containsString("uncommittedSizeInBytes must be >= 0")));  
            }
            channelFactory
            locations.add(
                for (int i = minUncommittedOp; i < translogOperations; i++) {
                                    blocker.await();  
            }  
            )
                    throw new UnknownException();  
                final boolean isCkpFile = file.getFileName().toString().endsWith(".ckp");  
        );
        List<Translog.Location> locations = new ArrayList<>();
                .uncommittedSizeInBytes(randomIntBetween(1, 4096))  
        );
                                break;
    }
                failed = true;
    public void testFindEarliestLastModifiedAge() throws IOException {
    public void testTranslogCorruption() throws Exception {
        int translogOperations = randomIntBetween(10, 100);
        deletionPolicy.setLocalCheckpointOfSafeCommit(
            assertThat(batchLocations.length, equalTo(singleLocations.size()));
            IndexSettingsModule.newIndexSettings(shardId.getIndex(), settings),
            translogUUID = translog.getTranslogUUID();  
            for (long seqNo : seqNos) {
        Set<Long> persistedSeqNos = ConcurrentCollections.newConcurrentSet();
        synchronized (signalReaderSomeDataWasIndexed) {
                            op = new Translog.Delete(
            assertThat(stats.estimatedNumberOfOperations(), equalTo(3));  
                            opsSynced,
                thread.join();
                    new Translog.Index("" + op, op, primaryTerm.get(), Integer.toString(++count).getBytes(Charset.forName("UTF-8")))  
            out.writeInt(1);
            translogCorruptedException.getMessage(),
    }
                Translog.Index op = new Translog.Index(randomAlphaOfLength(10), seqNo, primaryTerm.get(), new byte[] { randomByte() });
 * this file be licensed under the Apache-2.0 license or a
    public void testSyncConcurrently() throws Exception {
    public void testWithRandomException() throws IOException {
        assertFileDeleted(translog, 1);
            threads[i].setDaemon(true);  
                "lastCommitted must be 2 less than current - we never finished the commit",
        translog = new LocalTranslog(
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 1);  
        }
                }  
            deletionPolicy,
                    TranslogOperationHelper.DEFAULT,  
            }
                    translogUUID,  
        assertEquals(translogOperations, translog.totalOperations());
        // one extra roll to make sure that all ops so far are available via a reader and a translog-{gen}.ckp
                ThrowingFileChannel channel = new ThrowingFileChannel(failSwitch, false, false, open);  
import org.opensearch.index.seqno.LocalCheckpointTracker;
        // translog here as well.
            failOnCopy.set(true);  
            int totOps = 0;
            }
            if (randomBoolean()) {  
            assertTrue(ex.getCause() instanceof UnknownException);
            try (
        return ops;
            corrupted,
                        );  
        return string;  
                translogUUID,
        Files.copy(ckp, config.getTranslogPath().resolve(Translog.getCommitCheckpointFileName(read.generation)));
            deletionPolicy,
        }  
                            for (Translog.Operation op : ops) {
                }
                translogGeneration = translog.getGeneration();
            } catch (EOFException ex) {  
                config,
        ) {  
        writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), randomNonNegativeLong());
                    // lets close the translog and if it succeeds we are all synced again. If we don't do this we will close
            assertThat(noOp.reason(), equalTo(reason));
        } else {  
        final TestTranslog.FailSwitch fail,
                        }
                } catch (IOException ex) {
                } else {
                assertEquals(opsAdded + 1, snapshot.totalOperations());
                boolean committing = false;  
            assertThat(stats.estimatedNumberOfOperations(), equalTo(1));
     * this class mimic behaviour of original {@link Translog}
            assertFilePresences(translog);  
        primaryTerm.addAndGet(extraDocs);  
                translogGeneration.translogFileGeneration + 1,  
            )
            operationsInLastGen++;  
        for (int op = 0; op < translogOperations; op++) {
     * that we can, after we hit an exception, open and recover the translog successfully and retrieve all successfully synced operations
        out = new BytesStreamOutput();
        }
                    for (int i = 0; i < upTo; i++) {
                        syncedDocs.clear();
            localCheckpoint = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, op);  
            final TranslogStats stats = stats();
            assertNotNull(translogGeneration);
                assertFalse(translog.syncNeeded());
                    }  
        try {
            // all good
            seqNo -> {},
                translogUUID,
        for (int attempt = 0, maxAttempts = randomIntBetween(3, 10); attempt < maxAttempts; attempt++) {  
                assertThat(snapshot, SnapshotMatchers.equalsTo(expectedSeqNo));
        final String translogUUID = translog.getTranslogUUID();
import org.opensearch.index.IndexSettings;
import org.opensearch.core.common.bytes.BytesReference;
        );
                for (int i = 0; i < 1; i++) {
            final TranslogStats stats = stats();  
            minSeqNo = a;
                            }
    }
                copy.toXContent(builder, ToXContent.EMPTY_PARAMS);
            )  
        }
            Collections.shuffle(seqNos, new Random(100));  
            final int threadId = i;
                assertNotNull(op);
        }
                TranslogOperationHelper.DEFAULT,  
            locations.add(
            Collection<Translog.Operation> effectiveOperations = inMemoryTranslog.operations();  
        final ByteSizeValue bufferSize = randomFrom(
                            synchronized (signalReaderSomeDataWasIndexed) {
                tragedy.setTragicException(e);
            .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)  
            assertSame(translog.getTragicException(), ex.getCause());
            }
                threads[t] = new Thread(() -> {  
        TranslogConfig config = getTranslogConfig(tempDir);
        final Translog failableTLog = getFailableTranslog(
            void syncBeforeRollGeneration() {
            shardId,
                if (randomBoolean()) {
            // immediate cleanup
            }  
        for (int op = 0; op < translogOperations; op++) {
                    }
        );  
    public void testSnapshotReadOperationForward() throws Exception {  
        boolean opsHaveValidSequenceNumbers = randomBoolean();  
        DataOutput out = EndiannessReverserUtil.wrapDataOutput(new ByteArrayDataOutput(bytes));  
            }
                    for (int i = 0; i < iterations; i++) {  
                .build();
                    }  
            while ((next = snap.next()) != null) {
                .collect(Collectors.toList());  
                        throw new AssertionError("unsupported operation type [" + op.opType() + "]");  
                translog.sync();  
        if (translog.isOpen()) {
        final int flushEveryOps = randomIntBetween(5, 100);
            TranslogException.class,  
                    );
                    syncedDocs.addAll(unsynced);
        try {
                    RuntimeException e = new RuntimeException("simulated");
     */
            try (Translog.Snapshot snapshot = translog.newSnapshot()) {
            }
                .uncommittedSizeInBytes(1)
        final TestTranslog.FailSwitch fail = new TestTranslog.FailSwitch();  
        final TranslogDeletionPolicy deletionPolicy = new DefaultTranslogDeletionPolicy(-1, -1, 0);  
        }
        for (int i = 0; i < threadCount; i++) {
            primaryTerm::get,
            if (fail.fail()) {  
                        + ",\"uncommitted_operations\":4,\"uncommitted_size_in_bytes\":"  
import org.opensearch.index.seqno.LocalCheckpointTrackerTests;  
            for (int op = 0; op < translogOperations; op++) {
        translog.close();  
                    assertEquals(  
import java.nio.channels.FileChannel;
import java.util.IdentityHashMap;
        final TestTranslog.FailSwitch fail = new TestTranslog.FailSwitch();  
                translog.ensureSynced(location);
            List<Long> seqNos = new ArrayList<>();
        assertTrue(Files.exists(translogDir.resolve(Translog.getFilename(1))));  
                        foundRouted = true;  
            assertThat(snapshot.totalOperations(), equalTo(ops.size()));  
        downLatch.countDown();
            String ascii = randomAlphaOfLengthBetween(1, 50);
        final boolean longRetention = randomBoolean();
        }  
        assertEquals(seenSeqNos, persistedSeqNos);  
                    }  
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 2);
            () -> new LocalTranslog(
        // force flushing and updating of stats
            TranslogConfig.DEFAULT_BUFFER_SIZE,
                fail("we are already closed");
                    assertEquals(ex, failableTLog.getTragicException());
import org.opensearch.index.mapper.Uid;
                )
/*
            Translog.parseIdFromFileName(file);
        IllegalArgumentException e = expectThrows(
        final List<Translog.Operation> ops = buildHttpLogLikeOps(opCount, 0);
        }
    private Checkpoint randomCheckpoint() {
        try (
        Checkpoint corrupted = Checkpoint.emptyTranslogCheckpoint(0, 0, SequenceNumbers.NO_OPS_PERFORMED, 0);
            try (Translog translog = openTranslog(config, uuid); Translog.Snapshot snapshot = translog.newSnapshot()) {  
        }
                    }
                primaryTerms.add(primaryTerm.get());
                        Translog.Operation next = snapshot.next();  
        }
                "lastCommitted must be 2 less than current - we never finished the commit",
                            }  
        translog.close();
        for (Thread thread : writers) {  
                    Translog.Operation next = snapshot.next();  
                deletionPolicy,  
            assertNotNull("operation 2 must be non-null", secondOp);
        final List<Tuple<Long, Long>> seqNos = new ArrayList<>();  
                        throw new IOException("simulated");  
            ) {
import java.util.concurrent.CyclicBarrier;
                assertFalse("translog has been synced already", translog.ensureSynced(location));  
@LuceneTestCase.SuppressFileSystems("ExtrasFS")  
        if (a.compareTo(b) > 0) {
                final Checkpoint readerCheckpoint = reader.getCheckpoint();
        TranslogConfig config = getTranslogConfig(tempDir);  
                // we are the last location so everything should be synced  
            assertThat(copy.getTranslogSizeInBytes(), equalTo(328L));  
            }  
    }
                return lastGlobalCheckpoint.get();
            for (int i = 0; i <= rolls; i++) {
                    brokenTranslog.getTranslogUUID(),
 *  
        final TranslogDeletionPolicy deletionPolicy = new DefaultTranslogDeletionPolicy(-1, -1, 0);
        final long noopTerm = randomLongBetween(1, primaryTerm.get());
        int translogOperations = randomIntBetween(10, 100);  
        final AtomicBoolean failOnCopy = new AtomicBoolean();
        assertThat(  
            return operations.values();  
            Set<Long> seenSeqNos = new HashSet<>();
import java.nio.file.Path;  
        List<Translog.Operation> firstGenOps = null;
            for (int j = 0; j < operations; j++) {
import static org.hamcrest.Matchers.in;  
                protected TranslogWriter createWriter(
                shardId,
        final AtomicLong seqNo = new AtomicLong();
                        tracker.markSeqNoAsProcessed(id);
            for (int i = 0; i < threadCount; i++) {
        // don't copy the new file
                if (randomBoolean()) {  
        TranslogConfig config = translog.getConfig();  
                        assertEquals(op, translog.readOperation(loc));
                }
                    for (int i = 0; i < upTo; i++) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.hamcrest.Matchers.equalTo;
    }
            for (Throwable ex : threadExceptions) {
            primaryTerm::get,
        int opsSynced = 0;  
        return new TranslogConfig(shardId, path, indexSettings, NON_RECYCLING_INSTANCE, bufferSize, "", false);
                    errors.add(e);
            assertThat(translog.getMinFileGeneration(), greaterThanOrEqualTo(1L));  
            )
            assertNotNull(ex.getCause());
                    committedLocalCheckpointAtView = lastCommittedLocalCheckpoint.get();  
                    if ("doc-1".equals(del.id())) {
            snapshot.close();
            final String threadId = "reader_" + i;
                } else {  
                operationsInLastGen = 0;  
            for (int i = 0; i < numOps; i++) {
                        expectedOps.add(op);
                            unsynced.clear();
        in.setVersion(Version.CURRENT);
    }
                translog.add(new Translog.Index("" + op, op, primaryTerm.get(), Integer.toString(op).getBytes(Charset.forName("UTF-8"))))
        Translog.Operation.writeOperation(out, deleteWithRouting);
                    throw new MockDirectoryWrapper.FakeIOException();
            Collections.addAll(queue, current.getSuppressed());  
                expectedException = e;
                }
        final BlockingQueue<TestTranslog.LocationOperation> writtenOperations = new ArrayBlockingQueue<>(threadCount * opsPerThread);
        translog.add(new Translog.Index("boom", 0, primaryTerm.get(), "boom".getBytes(Charset.forName("UTF-8"))));  
        Path path = createTempDir("translog");  
            Collections.sort(writtenOperations, (a, b) -> a.location.compareTo(b.location));
            checkpoint,
                translog.add(new Translog.NoOp(seqNo++, primaryTerm.get(), "test"));  
                threads[i].join();
            }
        truncateTranslogs(translogDir);
                );  
import static org.hamcrest.Matchers.instanceOf;
        );
        }
                translogUUID,
                views.peek().add(op);
        } catch (AlreadyClosedException ex) {
        ) {
        for (int op = 0; op < translogOperations; op++) {  
            .orElse(SequenceNumbers.NO_OPS_PERFORMED);
        translog.close();
                        }
            boolean rollover = attempt == 0 || attempt == maxAttempts - 1 || randomBoolean();
        private final int opsPerThread;
        boolean failed = false;
            if (consumer != null) {
            randomPrimaryTerm,
                seqNo = opsHaveValidSequenceNumbers ? randomNonNegativeLong() : SequenceNumbers.UNASSIGNED_SEQ_NO;
        return seqNo -> {
                    IOUtils.close(getFailableTranslog(fail, config, randomBoolean(), false, generationUUID, deletionPolicy));  
        try {
    }
        final TranslogWriter writer = translog.createWriter(translog.currentFileGeneration() + 1);
            }
import org.apache.lucene.backward_codecs.store.EndiannessReverserUtil;
            assertTrue("Should find delete without routing in snapshot", foundUnrouted);
            // if we are so happy to reach the max attempts - fail it always`  
                    return add;
        for (int op = 0; op < translogOperations; op++) {
            throws MockDirectoryWrapper.FakeIOException {  
        int translogOperations = randomIntBetween(10, 1000);
                deletionPolicy,  
        final BaseTranslogReader reader = randomBoolean()
            }  
        } catch (TranslogException ex) {  
                        default:  
        deletionPolicy.setRetentionSizeInBytes(randomLong());
            toClose.add(snapshot2);
                            case NO_OP:  
            assertThat(stats.getUncommittedSizeInBytes(), equalTo(firstOperationPosition));
                assertThat(snapshot.totalOperations(), greaterThan(0));  
    public void testSnapshotOnClosedTranslog() throws IOException {
                    primaryTerm::get,
    }
        assertThat(e, hasToString(containsString("numberOfOperations must be >= 0")));  
                globalCheckpoint.set(globalCheckpoint.get() + randomIntBetween(1, 16));  
                if (randomBoolean()) {
            primaryTerm::get,
        // increment primaryTerm to avoid potential negative numbers
    }  
            if (op == prepareOp) {
            };
                // we never managed to successfully create a translog, make it  
            }  
        final int rolls = randomIntBetween(1, 16);  
                        public void force(boolean metaData) throws IOException {
                throw threadExceptions[i];  
            Throwable e = errors.get(0);
                } catch (TranslogException | MockDirectoryWrapper.FakeIOException ex) {  
                .earliestLastModifiedAge(1)  
                // don't do partial writes for checkpoints we rely on the fact that the bytes are written as an atomic operation
import org.opensearch.common.Randomness;  
        final TranslogDeletionPolicy deletionPolicy = translog.getDeletionPolicy();  
        }
        try (  
                @Override
                assertThat(persistedSeqNos, empty());  
                    config,
            this.partialWrite = partialWrite;  
    }
        translog.add(new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));  
        for (int op = 0; op < extraDocs; op++) {  
        if (sync) {
    ) throws IOException {  
            final TranslogStats copy = new TranslogStats(out.bytes().streamInput());
                                assertThat(checkpoint.maxSeqNo, greaterThanOrEqualTo(op.seqNo()));
                        @Override
        {  
                            assertNotNull(location);  
        TranslogConfig config = getTranslogConfig(tempDir);
        } finally {
                    deletionPolicy,
            () -> SequenceNumbers.NO_OPS_PERFORMED,
            assertThat(BytesReference.toBytes(index.source()), equalTo(new byte[] { 1 }));  
                for (int i = 0; (operation = snapshot.next()) != null; i++) {
                for (int i = 0; i < syncedDocs.size(); i++) {
    }
                channelFactory  
        Engine.Index eIndex = new Engine.Index(
            assertThat(snapshot, SnapshotMatchers.equalsTo(ops));  
                )  
        List<TranslogReader> readers = new ArrayList<>();
    }  
        assertNotNull(readBack1);
                primaryTerm::get,  
        void add(Translog.Operation operation) {
            final long pos = reader.getFirstOperationOffset() + 4 * numOps;
        );
        final AtomicLong lastCommittedLocalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);  
        }  
            final TranslogDeletionPolicy deletionPolicy = translog.getDeletionPolicy();
                translog.rollGeneration();
                    int upTo = sync ? translogOperations : prepareOp;
            IOUtils.closeWhileHandlingException(toClose);
        Thread[] threads = new Thread[threadCount];  
        // Create a separate translog instance with forward reading enabled  
                }
            try (
        Files.copy(ckp, config.getTranslogPath().resolve(Translog.getCommitCheckpointFileName(read.generation)));
            Translog.Operation maxOp = null;
    public void testTranslogOpsCountIsCorrect() throws IOException {  
        assertEquals(index, serializedIndex);
                    )  
        int translogOperations = randomIntBetween(10, 100);
        long id = randomIntBetween(0, Integer.MAX_VALUE);  
                if (rarely()) {  
            Thread thread = new Thread(() -> {  
import org.apache.lucene.tests.store.MockDirectoryWrapper;
            deletionPolicy,  
                throw new MockDirectoryWrapper.FakeIOException();  
            assertNotNull(translogGeneration);  
                                1 + randomInt(100000)  
                            unsynced.clear();
            }
        Collections.shuffle(locations, random());
            final Checkpoint checkpoint = Checkpoint.read(config.getTranslogPath().resolve(Translog.CHECKPOINT_FILE_NAME));
            Origin.PRIMARY,
            }
                Closeable retentionLock = null;
        TranslogConfig config = translog.getConfig();
    }
                translog,
        );
        final byte[] batchBytes;
                Translog translog = new LocalTranslog(  
                    boolean syncNeeded = translog.syncNeeded();
                if (throwUnknownException) {  
        super.setUp();  
                            synchronized (flushMutex) {
        } catch (MockDirectoryWrapper.FakeIOException ex) {
            assertNotNull("operation 1 must be non-null", firstOp);  
                success = true;
    }
                                fail(missed.toString());
    public void testReadGlobalCheckpoint() throws Exception {  
        } catch (IllegalArgumentException ex) {
                    }
import static org.hamcrest.Matchers.contains;
            config.getTranslogPath(),
                translog.rollGeneration();
                    assertEquals(Integer.toString(op), read.getSource().source.utf8ToString());
                for (int opCount = 0; opCount < opsPerThread; opCount++) {  
        final TranslogConfig config = new TranslogConfig(
            assertFalse(translog.syncNeeded());  
        assertThat(total.getTranslogSizeInBytes(), equalTo(0L));  
            }
            } catch (AlreadyClosedException ex) {
                deletionPolicy.setLocalCheckpointOfSafeCommit(i);
     */
        }  
                TestTranslog.FailSwitch failSwitch = new TestTranslog.FailSwitch();
        {
            try (Translog.Snapshot snapshot = translog.newSnapshot(fromSeqNo, toSeqNo)) {
            );
import org.opensearch.Version;
import java.util.Set;
        }
        // if a previous test failed we clean up things here
        final List<Translog.Operation> one = buildHttpLogLikeOps(1, 0);
            }
            .orElseThrow();
            primaryTerm.get()  
                "] is corrupted, checkpoint file translog-3.ckp already exists but has corrupted content: expected Checkpoint{offset=2750, "  
                translogUUID,
            if (fail.fail()) {
            final Translog.Operation old = operations.put(operation.seqNo(), operation);
            try (Translog.Snapshot snapshot = translog.newSnapshot()) {
        ArrayList<Translog.Location> locs = new ArrayList<>();
                                assertThat("seq# " + op.seqNo() + " was not marked as persisted", persistedSeqNos, hasItem(op.seqNo()));
            shardId,
            if (randomBoolean()) {
                    () -> SequenceNumbers.NO_OPS_PERFORMED,  
        };
        }  
        } catch (TranslogCorruptedException ex) {
                                try {
        int translogOperations = randomIntBetween(10, 100);
                translog.rollGeneration();
        for (int i = 0; i < n; i++) {  
                }
                        "" + opsAdded,
    public void testNegativeSizeInBytes() {
                // expected...  
                    truncations.incrementAndGet();
        }
                assertNotNull(translogGeneration);  
                            translogFsyncCalls.incrementAndGet();  
            assertThat("operation byte region differs at offset " + i, batchBytes[i], equalTo(singleBytes[i]));  
                    assertEquals(syncedDocs.get(i), next.getSource().source.utf8ToString());  
                null  
                        @Override
        }  
        }  
        translog.sync();  
                translog.getDeletionPolicy().setLocalCheckpointOfSafeCommit(op);
            }
            this.translog = translog;
                assertTrue("we only synced a previous operation yet", translog.syncNeeded());
        assertNull(readBack2.routing());
        );
                    };
                    assertNotNull("operation " + i + " must be non-null", next);
        }
                .uncommittedOperations(-1)
                translog.add(new Translog.Index("" + op, op, primaryTerm.get(), Integer.toString(op).getBytes(Charset.forName("UTF-8"))))  
        for (int i = 0; i < operations; i++) {  
            config,  
        String translogUUID = Translog.createEmptyTranslog(
                    channel = new FilterFileChannel(delegate) {
            fail("invalid pattern");
            assertEquals(2048, value);
            assertThat(stats.getUncommittedSizeInBytes(), equalTo(176L));  
import org.apache.lucene.store.DataOutput;
                        public void force(boolean metaData) throws IOException {  
                }  
            byte[] bytes = new byte[256];
            this.opsPerThread = opsPerThread;
                        String doc = lineFileDocs.nextDoc().toString();  
                    phaser.arriveAndAwaitAdvance();
            }
            Translog translog = new LocalTranslog(  
    public void testBatchAddEdgeCounts() throws IOException {
        }
                }
import java.util.Queue;  
        }
                                try {
import org.apache.lucene.index.Term;
                    translog.add(
                    assertEquals(ex.getMessage(), "simulated");  
import java.util.stream.LongStream;  
                                .append(committedLocalCheckpointAtView + 1L)
                        + "\"total_uploads\":{\"started\":0,\"failed\":0,\"succeeded\":0},"
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 1);  
                        "expected operation" + i + " to be in the current translog but wasn't",
            assertThat(snapshot.totalOperations(), equalTo(ops.size()));  
        }
        for (int gen = 0; gen < generations; gen++) {  
import java.nio.ByteBuffer;
            total.add(stats);
        }  
                    logger.info("--> [{}] done. tested [{}] snapshots", threadId, iter);
                final boolean isCkpFile = file.getFileName().toString().endsWith(".ckp");  
        final long localCheckpoint;
                                // we need not do this concurrently as we need to make sure that the generation
                seqNo -> {},
                null  
                    config,  
import org.opensearch.index.engine.MissingHistoryOperationsException;
        int numOps = randomIntBetween(100, 200);
    }
        final TranslogReader reader = translog.readers.stream()
        } catch (AlreadyClosedException ex) {
            } else {
    /** Make sure that it's ok to close a translog snapshot multiple times */  
            primaryTerm::get,
                    int iter = 0;
            for (final Iterator<Map.Entry<Long, Translog.Operation>> it = operations.entrySet().iterator(); it.hasNext();) {
                }
            translog = createTranslog(config);
            buffer.flip();
                    reader = translog.openReader(reader.path(), writerCheckpoint);
                null
                try {  
            return a;  
                    generationUUID,  
            translogUUID,  
            }
        }  
    private LongConsumer getPersistedSeqNoConsumer() {
        );
                null
        AtomicInteger truncations = new AtomicInteger(0);
    protected TranslogStats stats() throws IOException {  
                            for (Translog.Operation expectedOp : expectedOps) {
        final Settings settings = Settings.builder()  
                            }  
                            throw new AssertionError("unsupported operation type [" + type + "]");
        assertFileIsPresent(translog, 2);
        if (randomBoolean()) { // recover twice
        List<TestTranslog.LocationOperation> writtenOperations = Collections.synchronizedList(new ArrayList<>());  
        // Write deletes with and without routing to a real translog, read them back
    public void testConcurrentWritesWithVaryingSize() throws Throwable {  
    }
        // we intentionally don't close the tlog that is in the prepareCommit stage since we try to recovery the uncommitted  
            for (int i = firstUncommitted; i < translogOperations; i++) {  
            return super.write(src, position);  
                );
            assertThat(stats.getUncommittedOperations(), equalTo(4));  
                    channel = new FilterFileChannel(delegate) {  
        assertThat(total.getUncommittedOperations(), equalTo(statsList.stream().mapToInt(TranslogStats::getUncommittedOperations).sum()));  
        assertEquals(1, deserialized.seqNo());
        {  
            path.getFileSystem()
    public void testConcurrentWriteViewsAndSnapshot() throws Throwable {
                            if (synced) {  
                    () -> SequenceNumbers.NO_OPS_PERFORMED,
import org.opensearch.common.xcontent.XContentFactory;
                    throw new MockDirectoryWrapper.FakeIOException();
            } catch (TranslogException | MockDirectoryWrapper.FakeIOException | TranslogCorruptedException ex) {
    }  
        {
                    tragedy.setTragicException(e);  
                views.push(new ArrayList<>());  
            if (rarely()) {
                    channel = new FilterFileChannel(delegate) {
        try (
        protected void afterAdd() throws IOException {}
                                lastCommittedLocalCheckpoint.set(localCheckpoint);
                () -> SequenceNumbers.NO_OPS_PERFORMED,
            minSeqNo,  
                public void onFailure(Exception e) {
        if (longRetention) {
                assertFalse(translog.isOpen());  
        List<Translog.Location> locations2 = new ArrayList<>();
import org.apache.lucene.document.Field;  
                    assertThat("op " + i + " read back", read, equalTo(ops.get(i)));  
                    assertEquals(locations.get(j).hashCode(), locations2.get(j).hashCode());  
    /**
                    TranslogOperationHelper.DEFAULT,
            } else {
                    throw new AssertionError(e);
        long nextSeqNo = populateTranslogOps(true);
        String translogUUID,  
        Checkpoint read = Checkpoint.read(ckp);  
                            } else {
            assertThat(snapshot1, SnapshotMatchers.size(1));  
                            if (randomBoolean()) {  
            fail("should have been failed");  
    }  
                final Map.Entry<Long, Translog.Operation> next = it.next();
                    }  
            : translog.openReader(writer.path(), Checkpoint.read(translog.location().resolve(Translog.CHECKPOINT_FILE_NAME)));
        }
            assertThat(stats.getUncommittedOperations(), equalTo(4));
        );
        }  
                int upTo = sync ? translogOperations : prepareOp;
                    "{\"translog\":{\"operations\":4,\"size_in_bytes\":"
        String translogUUID = Translog.createEmptyTranslog(
        for (int op = 0; op < translogOperations; op++) {  
        }
            }  
        IOUtils.close(lock);
    protected Path translogDir;
            thread.join();
        Path tempDir = createTempDir();
        Map<Long, List<Translog.Operation>> operationsByGen = new HashMap<>();  
                    throw new MockDirectoryWrapper.FakeIOException();
        }  
            }
        for (int op = 0; op < translogOperations; op++) {
                                }  
                }  
                new Translog.Index("" + op, seqNo, primaryTerm.get(), Integer.toString(seqNo).getBytes(Charset.forName("UTF-8")))
                    channel = new FilterFileChannel(delegate) {
        final int prepareOp = 44;  
        try {
        }
            FileChannel::open,  
                Translog.Index operation = new Translog.Index("" + op, op, primaryTerm.get(), source.get().getBytes("UTF-8"));
                );  
            seqNos.add(Tuple.tuple(repeatingTermSeqNo, terms.get(repeatingTermSeqNo)));
        long minGenForRecovery = 1L;  
        for (int i = 0; i < threadCount; i++) {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            deleteRouting  
            assertThat(snapshot2, containsOperationsInAnyOrder(ops));
                .uncommittedSizeInBytes(1)  
import org.opensearch.common.UUIDs;
        long expectedMaxSeqNo = maxSeqNoPerGeneration.entrySet()
    }  
        if (Files.exists(translog.location().resolve(Translog.getFilename(id)))) {
                    primaryTerm.incrementAndGet();
                "lastCommitted must be 2 less than current - we never finished the commit",  
            }
            final Set<Tuple<Long, Long>> expected = seqNos.stream().filter(t -> t.v1() >= seqNoLowerBound).collect(Collectors.toSet());
            } finally {
            Translog translog = new LocalTranslog(
        }
                    assertEquals("payload missmatch", i, Integer.parseInt(next.getSource().source.utf8ToString()));
     */
                )
                    brokenTranslog.getDeletionPolicy(),  
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 4);  
        translog.rollGeneration();
                    TranslogOperationHelper.DEFAULT,
            }
        final LocalCheckpointTracker tracker = LocalCheckpointTrackerTests.createEmptyTracker();
            StandardOpenOption.WRITE,
                @Override
            for (int i = 0; i < operations; i++) {  
        final CyclicBarrier barrier = new CyclicBarrier(writers.length + readers.length + 1);  
            if (frequently()) {
            int expectedSnapshotOps = 0;
            primaryTerm.incrementAndGet(); // increment primary term to force rolling generation
                    + "] > 0:"
        );
            false,
        int translogOperations = 0;  
                if (success == false) {
            for (long i = 0; i < minRetainedReader.generation; i++) {
            }
                assertThat(snapshot.totalOperations(), equalTo(0));
            assertEquals(
            fail("invalid pattern");
                            syncedDocs.addAll(unsynced);
                    if (checkpoint.numOps == unsynced.size() + syncedDocs.size()) {
            void callCloseDirectly() throws IOException {
                writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 5);  
            assertThat(stats.getEarliestLastModifiedAge(), greaterThan(0L));
            .build();  
            null  
            seenSeqNos.retainAll(expected);
            for (long g = generation; g < translog.currentFileGeneration(); g++) {  
        try {
            assertThat(snapshot.totalOperations(), equalTo(ops.size()));  
    // see https://github.com/elastic/elasticsearch/issues/15754
            Randomness.shuffle(ops);
                        Translog.Index indexOp = (Translog.Index) op;  
            doc,  
     * Tests the situation where the node crashes after a translog gen was committed to lucene, but before the translog had the chance
            }
            }
                if (failOnCopy.get() && source.toString().endsWith(Translog.CHECKPOINT_SUFFIX)) {
        translog.add(new Translog.Index("2", 1, primaryTerm.get(), new byte[] { 2 }));
                minUncommittedOp = op + 1;
        assertEquals(translogOperations + 1, translog.totalOperations());
    public void testLocationHashCodeEquals() throws IOException {  
    }
                try {
                );  
        translog.close();  
        } catch (MockDirectoryWrapper.FakeIOException ex) {  
            }
                        assertFalse(loc.equals(location));
        translog.rollGeneration();
            }
                translog.rollGeneration();
                    writtenOperations.add(new TestTranslog.LocationOperation(op, loc));
        assertThat(translog.stats().getUncommittedOperations(), equalTo(retainedOps));  
                    }
            }
            this.seqNoGenerator = seqNoGenerator;
            // drop all that haven't been synced
        long firstId = translog.currentFileGeneration();  
                () -> SequenceNumbers.NO_OPS_PERFORMED,  
                primaryTerm::get,
            for (int op = 0; op < translogOperations; op++) {
            }
            primaryTerm::get,  
        int seqNo = 0;
        // it is possible to trim after generation rollover
        translog.rollGeneration();  
            getPersistedSeqNoConsumer(),  
            // all is well
                            }
                return true;
            )
            for (int i = 0; i < numOps; i++) {  
        translog.sync();
                try (Translog.Snapshot snapshot = new TestTranslog.SortedSnapshot(translog.newSnapshot())) {  
                    throw threadExceptions[i];
                final Set<Tuple<Long, Long>> generationSeqNo = seqNoPerGeneration.get(g);  
            newUid(doc),  
                translog.getDeletionPolicy(),  
            if (current.getCause() != null) {
                        case INDEX:
        final CountDownLatch writeStarted = new CountDownLatch(1);  
 * compatible open source license.
            assertTrue(e.getMessage().contains("Not all operations between from_seqno"));
                }
 * KIND, either express or implied.  See the License for the
            translog.rollGeneration();
                for (int j = 0; j < translogOperations; j++) {
                                // expose the new checkpoint (simulating a commit), before we trim the translog  
                        }
                    fail,
        final int operations = randomIntBetween(1, 512);  
            thread.start();
                        super.write(src);
            // last attempt we have to make roll as well - otherwise could skip trimming as it has been trimmed already  
        assertNull(translog.readOperation(new Location(100, 0, 0)));  
                    translog.add(op);  
import org.opensearch.core.index.shard.ShardId;
                            primaryTerm.get(),  
                        assertThat(noOp.reason(), equalTo(expectedNoOp.reason()));  
            batchTranslog.sync();
                    )  
    /** A single-element batch and an empty batch must behave sanely and match the single-op path. */
            this.threadExceptions = threadExceptions;
            }
        ArrayList<Translog.Operation> ops = new ArrayList<>();
                assertFalse("this op has been synced before", translog.ensureSynced(location)); // not syncing now
                        translog.currentFileGeneration(),
            try {
        // Use a small, fixed buffer so the batch spans the writer's buffer-flush threshold at least once.  
        final TranslogConfig batchConfig = new TranslogConfig(
        assertEquals(max.generation, translog.currentFileGeneration());
        assertThat(translog.currentFileGeneration(), Matchers.not(equalTo(firstId)));
 * license agreements. See the NOTICE file distributed with
                        closeRetentionLock();  
                config,
            }  
            TranslogReader reader = writer.closeIntoReader();  
            if (fail.fail()) {
        document.add(idField);  
    public void testTranslogOpSerialization() throws Exception {  
    public void testDeleteRoutingTranslogRoundTrip() throws Exception {
                    }
        translog.trimOperations(primaryTerm.get(), 0);
                    assertTrue(ex.toString(), ex instanceof IOException || ex instanceof AlreadyClosedException);
            random(),
            try (XContentBuilder builder = XContentFactory.jsonBuilder()) {
        final List<Translog.Location> singleLocations = new ArrayList<>();
        if (minSeqNo > 0) {
    }  
        }
                    long fileGeneration,  
            0
            Version.CURRENT.minimumCompatibilityVersion(),
                        try (Translog.Snapshot snapshot = translog.newSnapshot(committedLocalCheckpointAtView + 1L, Long.MAX_VALUE)) {
        final AlreadyClosedException alreadyClosedException = expectThrows(AlreadyClosedException.class, () -> failableTLog.newSnapshot());
        Translog translog = getFailableTranslog(fail, config);  
import org.opensearch.test.IndexSettingsModule;  
            translog.newSnapshot();
        }
                            boolean failed = false;
                assertThat(snapshot.totalOperations(), equalTo(opCount));  
    public void testCheckpointOnDiskFull() throws IOException {
            stats = new TranslogStats(in);
        seqID.seqNoDocValue.setLongValue(randomSeqNum);  
            SequenceNumbers.NO_OPS_PERFORMED,
                String translogUUID,  
        }
    public void testTragicEventCanBeAnyException() throws IOException {  
        assertEquals(deleteRouting, serializedDelete.routing());  
            try {
    public void testVerifyTranslogIsNotDeleted() throws IOException {
        final AtomicLong idGenerator = new AtomicLong();
    }  
            createTranslogDeletionPolicy(),
        }  
        assertEquals(ex.getCause().getClass(), FileAlreadyExistsException.class);  
        final AtomicLong seqNoGenerator = new AtomicLong();  
                seqNo -> {},  
            try (Translog.Snapshot snapshot = new TestTranslog.SortedSnapshot(translog.newSnapshot())) {
    public void testRecoveryUncommittedCorruptedCheckpoint() throws IOException {
        translog.close();
        );
                assertFilePresences(recoveredTranslog);  
                fail.onceFailedFailAlways();
        }  
    public void testLegacyCheckpointVersion() throws IOException {
                translog.getDeletionPolicy().setLocalCheckpointOfSafeCommit(op);  
                Translog translog = new LocalTranslog(
            SequenceNumbers.NO_OPS_PERFORMED,
            TranslogOperationHelper.DEFAULT,
            assertFileIsPresent(translog, translog.currentFileGeneration());
        final long gen;  
        persistedSeqNoConsumer.set(persistedSeqNos::add);  
        int threadCount = 2 + randomInt(5);
                            while ((op = snapshot.next()) != null) {
            config.getTranslogPath().resolve(Translog.getCommitCheckpointFileName(read.generation)),
        for (int i = 0; i < threadCount; i++) {
                        translog.currentFileGeneration(),
        final TranslogDeletionPolicy deletionPolicy = translog.getDeletionPolicy();  
                queue.add(current.getCause());
                minSeqNo = SequenceNumbers.min(minSeqNo, currentSeqNo);
                threadId,
            }  
import org.opensearch.common.settings.Settings;
        assertTrue(translog.getTragicException() instanceof UnknownException);
                    final Checkpoint checkpoint = Checkpoint.read(translog.location().resolve(Translog.getCommitCheckpointFileName(g)));
                                .append("]");  
                Translog.Index op = new Translog.Index(randomAlphaOfLength(10), seqNo, primaryTerm.get(), new byte[] { randomByte() });  
    private final AtomicReference<LongConsumer> persistedSeqNoConsumer = new AtomicReference<>();
    @After
        }  
            for (int i = 0; i < numOps; i++, currentSeqNo++) {
        );  
        Files.createFile(config.getTranslogPath().resolve("translog-" + (read.generation + 1) + ".tlog"));  
            // w00t
                                op = new Translog.NoOp(id, 1, Long.toString(id));
                            if (failed) {
        document.add(seqID.seqNo);
                boolean drop = op.primaryTerm() < belowTerm && op.seqNo() > aboveSeqNo;
                throw new MockDirectoryWrapper.FakeIOException();
            assertEquals(3, translogFsyncCalls.get());
        }  
                    Translog.Index op = new Translog.Index(  
                        break;  
        try {  
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 2);  
                translog.add(new Translog.Index("" + op, op, primaryTerm.get(), Integer.toString(op).getBytes(Charset.forName("UTF-8"))))  
                TranslogOperationHelper.DEFAULT,  
                        new Translog.Index("" + op, op, primaryTerm.get(), Integer.toString(op).getBytes(Charset.forName("UTF-8")))
            TranslogWriter writer = translog.getCurrent();  
        assertThat(reader.getTranslogChecksum(), nullValue());  
        return new Translog.Location(randomLong(), randomLong(), randomInt());  
                config,
        String translogUUID = Translog.createEmptyTranslog(
                translog.location().resolve(Translog.getFilename(translog.currentFileGeneration())),  
            }
        }  
            final int operations = randomIntBetween(1, 128);
                for (long i = 0; i < minRetainedReader.generation; i++) {
        assertFalse("translog [" + id + "] still exists", Files.exists(translog.location().resolve(Translog.getFilename(id))));
            final TranslogStats stats = new TranslogStats.Builder().numberOfOperations(randomIntBetween(1, 4096))  
        final TranslogDeletionPolicy deletionPolicy = translog.getDeletionPolicy();  
        assertEquals(delete, serializedDelete);
        translog.add(new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));  
                        final Translog.NoOp noOp = (Translog.NoOp) op;
                deletionPolicy,
                TranslogOperationHelper.DEFAULT,
    public void testReadLocation() throws IOException {
            () -> SequenceNumbers.NO_OPS_PERFORMED,
            operationsByGen.put(translog.currentFileGeneration(), ops);
/*  
                    readFromSnapshot++;
                assertNotNull(translogGeneration.translogUUID);
            if (rarely()) {
            }  
    public void testRandomExceptionsOnTrimOperations() throws Exception {
        assertThat(Translog.findEarliestLastModifiedAge(fixedTime, readers, w), equalTo(LongStream.of(periods).max().orElse(0L)));
        } else {  
                        final int limit = src.limit();
            }  
import java.util.function.LongSupplier;  
        int translogOperations = randomIntBetween(10, 100);
                () -> SequenceNumbers.NO_OPS_PERFORMED,
            TranslogWriter writer = translog.getCurrent();  
                }  
            // Add will not block even though we are currently writing/syncing
        TranslogException ex = expectThrows(
                new DefaultTranslogDeletionPolicy(-1, -1, 0),
            for (int b = 0; b < source.length; b++) {
            config,  
        SeqNoFieldMapper.SequenceIDFields seqID = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
                    Translog.Operation next = snapshot.next();
            }
            primaryTerm.get()  
            );  
            // ~300 byte source, representative of an http_logs document body  
import java.nio.charset.StandardCharsets;
        in = out.bytes().streamInput();  
    }  
                locations.add(  
                translogGeneration.translogFileGeneration + 1,  
            this.throwUnknownException = throwUnknownException;
                () -> SequenceNumbers.NO_OPS_PERFORMED,
        final Deque<List<Translog.Operation>> views = new ArrayDeque<>();
                translogGeneration.translogFileGeneration + 2,
            Origin.PRIMARY,
                    translogGeneration.translogFileGeneration
        final List<Exception> errors = new CopyOnWriteArrayList<>();
                        final int limit = src.limit();  
    private Translog getFailableTranslog(
            } finally {  
        assertThat(checkpoint.globalCheckpoint, equalTo(lastSyncedGlobalCheckpoint));
            }
                assertThat(snapshot.totalOperations(), equalTo(expectedSnapshotOps));  
        }
        final InMemoryTranslog inMemoryTranslog = new InMemoryTranslog();  
                TranslogOperationHelper.DEFAULT,  
                    "expected this to be the first roll (1 gen is on creation, 2 when opened)",  
                    views.add(new ArrayList<>());
        List<Translog.Location> locations = new ArrayList<>();
        }  
        for (int op = 0; op < translogOperations; op++) {
    public void testTranslogWriter() throws IOException {  
            randomInt(),
        translog.rollGeneration();
        } catch (MissingHistoryOperationsException e) {
        try (TranslogWriter writer = translog.createWriter(translog.currentFileGeneration() + 1)) {
        final String singleUUID = Translog.createEmptyTranslog(singleDir, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
                    "lastCommitted must be 3 less than current - we never finished the commit and run recovery twice",
        try {
        StreamInput in = out.bytes().streamInput();  
    /**  
            }
    public void testRecoverWithUnbackedNextGenInIllegalState() throws IOException {
        // Successful snapshot
    ) throws IOException {  
            boolean success = false;  
    }  
    }
                    while (run.get() && idGenerator.get() < maxOps) {
            VersionType.INTERNAL,
                long newSize = prevSize - randomIntBetween(1, (int) prevSize / 2);
                TranslogOperationHelper.DEFAULT,
                            committing = true;
                    Translog.Operation next = snapshot.next();
            assertFalse(tlog.syncNeeded());
        Map<Long, Long> maxSeqNoPerGeneration = new HashMap<>();
            assertTrue("Should find delete with routing in snapshot", foundRouted);
                void closeRetentionLock() throws IOException {
        }
                if (isCkpFile) {  
                        if (existing != null) {  
            try {
                final FileChannel channel;  
            translog.add(new Translog.NoOp(tuple.v1(), tuple.v2(), "test"));  
                    assertThat(deletionPolicy.getTranslogRefCount(minGen), equalTo(1L));
                    throw new MockDirectoryWrapper.FakeIOException();
            if (hasCircularReference(alreadyClosedException)) {
            shardId,
            )  
                    Translog.Operation next = snapshot.next();
        // file in a consistent way, in order to simplify checking code.  
            );
            minGenForRecovery = translog.getMinGenerationForSeqNo(localCheckpoint + 1).translogFileGeneration;
     */  
    private List<Translog.Operation> buildHttpLogLikeOps(int n, long seqNoBase) {
            ) {
                    new byte[] { 1 }
                final Translog.Location location = translog.add(  
        try (Translog.Snapshot snapshot = translog.newSnapshot(fromSeqNo, toSeqNo, true)) {
            when(r.getLastModifiedTime()).thenReturn(fixedTime - l);
            Set<Long> seqNos = new HashSet<>();
                firstGenOps = ops;  
            TranslogOperationHelper.DEFAULT,
        assertThat(translog.add(new ArrayList<>()).length, equalTo(0));  
            temp.getBigArrays(),
                SequenceNumbers.NO_OPS_PERFORMED,  
    public void assertFileIsPresent(Translog translog, long id) {  
        long maxSeqNo = SequenceNumbers.NO_OPS_PERFORMED;  
            int op = 0;
            final int numOps = randomIntBetween(100, 200);  
            total.getUncommittedSizeInBytes(),
        List<FileChannel> fileChannels = new ArrayList<>();  
        long toSeqNo = Math.min(nextSeqNo - 1, fromSeqNo + 15);  
                .uncommittedOperations(1)  
        }
        Randomness.shuffle(shuffledSeqNos);
                        @Override
            assertEquals(maxOp.getSource().source.utf8ToString(), Integer.toString(count));  
    }  
                    translog.add(new Translog.Index("id", seqNo, primaryTerm.get(), new byte[] { 1 }));  
                Translog.Operation op = snapshot.next();  
import org.opensearch.core.common.io.stream.StreamInput;
            assertFileIsPresent(translog, generation + i);  
        }
        }
                final int operations = randomIntBetween(1, 100);
    public void testSnapshotReadOperationInReverse() throws Exception {
        final Queue<Throwable> queue = new LinkedList<>();
import java.util.concurrent.CountDownLatch;
            List<Translog.Operation> ops = new ArrayList<>(seqNos.size());
            getPersistedSeqNoConsumer(),
            for (Translog.Operation op = snapshot.next(); op != null; op = snapshot.next()) {
                seqNo -> {},  
                translog.rollGeneration();
            }  
                    primaryTerm::get,
                        }
        );
            singleTranslog.sync();
            deletionPolicy,
        out.setVersion(Version.CURRENT);  
        IllegalArgumentException e = expectThrows(  
        logger.debug("--> waiting for threads to stop");
        try {  
        }
                }
                assertThat(snapshot.totalOperations(), is(allOperations.size()));
            .put(IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.getKey(), "-1ms")
            Translog.Operation op;
        try (Translog brokenTranslog = create(filterFileSystemProvider.getPath(path.toUri()))) {
        public void run() {  
        out.setVersion(oldVersion);
                        "expected operation" + i + " to be in the previous translog but wasn't",
                for (int i = 0; i < upTo; i++) {
    }
                                }
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
            randomLongBetween(1, generation),  
        final List<Translog.Operation> ops = new ArrayList<>(n);
            try {
    public void testSnapshotCurrentHasUnexpectedOperationsForTrimmedOperations() throws Exception {
        }
                validPathString = resolved.getFileName() != null;
            if (fileChannels != null) {  
                Integer.toString(op).getBytes(Charset.forName("UTF-8"))
                translog.add(op);
                maxOp = next;  
            assertFileIsPresent(translog, gen);
        }
                } else {  
                    snapshot.next();
        Thread[] threads = new Thread[threadCount];
            final String id = String.format(java.util.Locale.ROOT, "%020d", seqNo);
        final int operations = scaledRandomIntBetween(10, 100);  
                .translogSizeInBytes(randomIntBetween(1, 1 << 20))
            ByteBuffer buffer = ByteBuffer.allocate(4);  
                .build()  
            () -> SequenceNumbers.NO_OPS_PERFORMED,  
        id = randomIntBetween(0, Integer.MAX_VALUE);
            );
            Translog.Snapshot snapshot1 = translog.newSnapshot(0, randomIntBetween(0, 10))
            assertThat(snapshot.next(), equalTo(one.get(0)));  
                                    writeStarted.countDown();  
                        }
                    Translog.Location add = super.add(op);  
            if (rarely() && translogOperations > op + 1) {  
            assertThat(readFromSnapshot, equalTo(expectedSnapshotOps));
    }
            )  
        }
                seqNo -> {},
            translog.rollGeneration();
        // length) and differ only in the UUID bytes, so compare the operations region after the header for exact
        {
        TranslogConfig config = getTranslogConfig(path);
                    () -> SequenceNumbers.NO_OPS_PERFORMED,
        assertThat((int) firstOperationPosition, greaterThan(CodecUtil.headerLength(TranslogHeader.TRANSLOG_CODEC)));
                        // we were committing and blew up in one of the syncs, but they made it through  
            .findFirst()
                .translogSizeInBytes(1)
                }
        document.add(seqID.primaryTerm);
                // Will flush on read
        public long write(ByteBuffer[] srcs, int offset, int length) throws IOException {  
        final Map<Long, Set<Tuple<Long, Long>>> seqNoPerGeneration = new HashMap<>();  
            createTranslogDeletionPolicy(config.getIndexSettings()),  
            final List<Translog.Operation> expectedSeqNo = new ArrayList<>();
            }
            long fromSeqNo = randomLongBetween(0, minSeqNo - 1);
        Path tempDir = createTempDir();
        if (translogGeneration == null) {  
        };  
                        foundUnrouted = true;  
        for (int op = 0; op < translogOperations; op++) {
                translog.currentFileGeneration()
        assertEquals("tenant-abc", deserialized.routing());
                source.set(randomAlphaOfLengthBetween(1, 50));  
        Checkpoint.write(
            final int operations = randomIntBetween(1, 100);
    }
                for (List<Translog.Operation> view : views) {
            try {
        locs.add(addToTranslogAndList(translog, ops, new Translog.Index("3", 2, primaryTerm.get(), new byte[] { 1 })));
 */  
                    }
        try (Translog.Snapshot snap = new TestTranslog.SortedSnapshot(translog.newSnapshot())) {
                            case CREATE:
                config,
        if (errors.size() > 0) {  
                translog.rollGeneration();  
            singleBytes = Files.readAllBytes(singleDir.resolve(Translog.getFilename(gen)));
            toClose.add(snapshot);
            .filter(e -> e.getKey() >= translog.getMinFileGeneration())
            TranslogReader r = mock(TranslogReader.class);
            assertThat(stats.getUncommittedSizeInBytes(), equalTo(139L));
                );
            // live reader!
        final TranslogDeletionPolicy deletionPolicy = translog.getDeletionPolicy();
            translog.trimOperations(primaryTerm.get(), maxTrimmedSeqNo);
                        Translog.Delete expDelOp = (Translog.Delete) expectedOp;  
        }  
                    for (int i = 0; i < threadCount; i++) {  
        ) {
        final AtomicInteger writeCalls = new AtomicInteger();  
            assertEquals(totOps, toSeqNo - fromSeqNo + 1);
        translog.add(new Translog.Index("1", 0, primaryTerm.get(), lineFileDocs.nextDoc().toString().getBytes(Charset.forName("UTF-8"))));  
                assertFalse("location is from a previous translog - already synced", translog.ensureSynced(location)); // not syncing now  
        }  
    static boolean hasCircularReference(Exception cause) {  
            ops.add(test);  
            .max()  
                persistedSeqNos::add,
            () -> new TranslogStats.Builder().numberOfOperations(1)
            final int value = buffer.getInt();
            deletionPolicy,
                    throw new IOException(expectedExceptionMessage);
                createTranslogDeletionPolicy(),  
            assertThat(stats.getUncommittedSizeInBytes(), equalTo(273L));
                assertThat(snapshot, containsOperationsInAnyOrder(effectiveOperations));  
            tempDir.resolve("foo.cpk"),
        in.setVersion(wireVersion);
            temp.getBigArrays(),  
                config,
            List<Long> ops = LongStream.range(0, allOperations.size() + randomIntBetween(10, 15)).boxed().collect(Collectors.toList());
                translog.rollGeneration();
            List<Translog.Operation> expectedOps = new ArrayList<>();  
                    "expected this to be the first roll (1 gen is on creation, 2 when opened)",
                            }
                recoveredTranslog.rollGeneration();
            .mapToLong(e -> e.getValue())
                () -> globalCheckpoint.get(),  
        );
        );  
    public void testTranslogCloseInvariant() throws IOException {
        long fromSeqNo = randomLongBetween(maxSeqNo + 1, Long.MAX_VALUE);
                                signalReaderSomeDataWasIndexed.wait();
        final Translog translog = new LocalTranslog(
            super.force(metadata);
 * under the License.  
        );
        deletionPolicy.setLocalCheckpointOfSafeCommit(localCheckpoint);  
                            }  
    public void testSimpleCommit() throws IOException {
        }  
        final TranslogDeletionPolicy deletionPolicy = translog.getDeletionPolicy();
            try (
    }
                            default:  
                        }
            () -> new TranslogStats.Builder().numberOfOperations(1)  
                    final Translog.Operation.Type type = randomFrom(Translog.Operation.Type.values());
            translogUUID,
        if (randomBoolean()) {
        } finally {  
            for (long gen = translog.currentFileGeneration(); gen > 0; gen--) {
            } catch (IOException ex) {
        }
        final AtomicLong seqNoGenerator = new AtomicLong();
        assertFileIsPresent(translog, 1);
            assertThat(snapshot.totalOperations(), equalTo(1));
            if (randomBoolean()) {
            );  
            SequenceNumbers.NO_OPS_PERFORMED,  
            new Translog.Index(
        );  
                throw new MockDirectoryWrapper.FakeIOException();  
                            syncedDocs.clear();  
        );
                translogGeneration = translog.getGeneration();
                if (throwUnknownException) {
                translog.add(new Translog.Index("" + op, op, primaryTerm.get(), Integer.toString(op).getBytes(Charset.forName("UTF-8"))))
        final ChannelFactory channelFactory = (file, openOption) -> {
            super(delegate);
            try (
        try (Translog.Snapshot snapshot = this.translog.newSnapshot(randomLongBetween(0, firstUncommitted), Long.MAX_VALUE)) {
        } else {  
        IllegalArgumentException e = expectThrows(
                    expectedSnapshotOps += opCountPerGeneration.get(g);
        class MisbehavingTranslog extends LocalTranslog {  
            assertThat(stats.estimatedNumberOfOperations(), equalTo(2));
    }
            config,
                latestOperations.put(op.seqNo(), op);  
            primaryTerm.get()  
    }
            Translog.Operation op = snapshot.next();  
        } catch (IllegalArgumentException ex) {
    public void testSnapshotWithNewTranslog() throws IOException {  
                    final Translog.Operation read = snapshot.next();  
 * You may obtain a copy of the License at  
                final boolean isCkpFile = file.getFileName().toString().endsWith(".ckp");  
            translog.sync();
                seqNo = ++count;
                    }
                        super.write(src, position);  
            Stream.concat(translog.getReaders().stream(), Stream.of(translog.getCurrent()))
            fail("invalid pattern");  
            if (op == prepareOp) {
        Path ckp = config.getTranslogPath().resolve(Translog.CHECKPOINT_FILE_NAME);
            FileChannel delegate = FileChannel.open(file, openOption);  
import java.util.concurrent.atomic.AtomicReference;
        for (int i = 0; i < writers.length; i++) {  
                    if (loc == location) {  
    }
        final long closedGeneration = translog.currentFileGeneration() - 1;
                translogUUID,
                    try (TranslogReader reader = translog.openReader(translog.location().resolve(Translog.getFilename(g)), checkpoint)) {
            int count = 0;  
            fail("invalid pattern");
            throw new UnsupportedOperationException();
                                primaryTerm.get(),
                .uncommittedSizeInBytes(-1)
            writers[i].start();
                }
            Randomness.shuffle(ops);
                Translog.Index operation = new Translog.Index("" + op, op, primaryTerm.get(), ascii.getBytes("UTF-8"));
        try {
        translog.add(new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
        final String translogUUID = Translog.createEmptyTranslog(path, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
                    + "minTranslogGeneration=0, trimmedAboveSeqNo=-2}"  
        translog.rollGeneration();  
        final Set<Long> persistedSeqNos = new HashSet<>();
                assertFalse(translog.isOpen());  
            () -> new TranslogStats.Builder().numberOfOperations(1)
                            }
            primaryTerm.get()
            );
        long lastSyncedGlobalCheckpoint = globalCheckpoint.get();  
        assertThat(persistedSeqNos, empty());  
        final TranslogConfig forwardConfig = getTranslogConfig(tempDir, settings);  
                translog,
        LineFileDocs lineFileDocs = new LineFileDocs(random()); // writes pretty big docs so we cross buffer boarders regularly
    public void testMaxSeqNo() throws Exception {
            snapshot.close();
                }
            Translog.Index index = (Translog.Index) snapshot.next();
            translog.rollGeneration();
            );
        // any errors on threads  
            tlog.add(new Translog.Index("" + 1, 1, primaryTerm.get(), Integer.toString(2).getBytes(Charset.forName("UTF-8"))));
                            op = new Translog.Index(  
                // don't do partial writes for checkpoints we rely on the fact that the bytes are written as an atomic operation  
                writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), randomNonNegativeLong());
        final int numOps = scaledRandomIntBetween(8, 250000);
                try {  
    private void assertFilePresences(Translog translog) {
                    Translog.Operation next = snapshot.next();
                downLatch.await();
            final long seqNo = seqNoBase + i;
                }
            assertThat(stats.getTranslogSizeInBytes(), equalTo(157L));
            () -> Checkpoint.read(getDataPath("/org/opensearch/index/checkpoint/v2.ckp.binary"))
                "lastCommitted must be 1 less than current",
        ) {
        byte[] bytes = new byte[4];
                    .setLocalCheckpointOfSafeCommit(randomLongBetween(deletionPolicy.getLocalCheckpointOfSafeCommit(), i));
            .put(IndexSettings.INDEX_TRANSLOG_READ_FORWARD_SETTING.getKey(), true)
        try (Translog.Snapshot snapshot = translog.newSnapshot(fromSeqNo, toSeqNo)) {  
        final Translog.Location[] batchLocations;  
        }  
        return getFailableTranslog(fail, config, randomBoolean(), false, null, createTranslogDeletionPolicy());
            }  
    }
        try {
            minSeqNo = b;
            locations.add(
                    new Translog.Index(Integer.toString(op), op, primaryTerm.get(), Integer.toString(op).getBytes(Charset.forName("UTF-8")))  
            } catch (Exception e) {
        fail.failNever();
        }
            final AtomicLong seqNo = new AtomicLong();  
                    new Translog.Index(
                seqNo -> {},
                config,
            try {
                persistedSeqNos::add,
            StandardOpenOption.CREATE_NEW
                .uncommittedSizeInBytes(1)
            SequenceNumbers.NO_OPS_PERFORMED,
        translog.trimUnreferencedReaders();
            if (op == prepareOp) {
            assertFalse(brokenTranslog.isOpen());  
                .uncommittedOperations(randomIntBetween(1, 1 << 20))
            translogUUID,
                translog.add(op);  
        translog.rollGeneration();
        }  
            try (Translog.Snapshot snapshot = batchTranslog.newSnapshot()) {
            .build();
import java.util.HashSet;  
import org.apache.lucene.document.TextField;
                    IOUtils.closeWhileHandlingException(delegate);
                if (throwUnknownException) {
                assertNotNull(translogGeneration);
                assertEquals(
                } catch (IOException e) {  
                        Translog.Operation next = snapshot.next();
            for (int i = 0; i < locations.size(); i++) {  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.Assertions;
            .sum();  
        IOUtils.rm(translog.location()); // delete all the locations  
            }  
        final TranslogConfig temp = getTranslogConfig(tempDir);
        Translog.Delete readBack2 = (Translog.Delete) translog.readOperation(loc2);
        );
                        locations.get(i).generation
            }
    }
                if (writtenOperations.size() != snapshot.totalOperations()) {
            try (Translog.Snapshot snapshot = tlog.newSnapshot()) {
            final List<List<Translog.Operation>> views = new ArrayList<>();
    }  
            assertEquals("payload mismatch for operation 1", Integer.parseInt(firstOp.getSource().source.utf8ToString()), 1);
                downLatch,
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
                assertThat(translog.stats().getUncommittedOperations(), equalTo(operationsInLastGen));
            int opsPerThread,
                    translog2.add(  
        final boolean partialWrites,
        };
            if (randomBoolean()) {  
                    new Translog.Index(Integer.toString(op), op, primaryTerm.get(), Integer.toString(op).getBytes(Charset.forName("UTF-8")))
                }
            if (randomBoolean()) {
                // don't do partial writes for checkpoints we rely on the fact that the bytes are written as an atomic operation
            };
            try (Translog.Snapshot snapshot = forwardTranslog.newSnapshot()) {
        int op = 0;  
                Translog.Operation expectedOp = locationOperation.operation;
        }
        Path tempDir = createTempDir();  
    private TranslogConfig getTranslogConfig(final Path path, final Settings settings) {  
        }
                            failableTLog.trimUnreferencedReaders();
                deletionPolicy,
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
    }
                translogUUID,
        }  
                    if (src.hasRemaining()) {
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
                // use ongoing primaryTerms - or the same as it was  
        }
                op,
        return getFailableTranslog(fail, config, partialWrites, throwUnknownException, translogUUID, deletionPolicy, null);
            assertThat(snapshot, SnapshotMatchers.equalsTo(ops));
        assertThat(Translog.findEarliestLastModifiedAge(fixedTime, new ArrayList<>(), w), equalTo(period));  
        assertThat(translog.getMinFileGeneration(), equalTo(1L));
                            case DELETE:  
        final String translogUUID = Translog.createEmptyTranslog(
        ) {
        assertThat(total.getUncommittedSizeInBytes(), equalTo(0L));
                            );
        } catch (IllegalArgumentException ex) {  
                    };
        final Checkpoint checkpoint2 = randomCheckpoint();  
                    throw new MockDirectoryWrapper.FakeIOException();  
                translog.trimUnreferencedReaders();
        int translogOperations = randomIntBetween(10, 100);
                primaryTerm.incrementAndGet();
            int seqNo = ++count;
                assertTrue("at least one operation pending", translog.syncNeeded());
                        assertThat(noOp.seqNo(), equalTo(expectedNoOp.seqNo()));
        Path ckp = config.getTranslogPath().resolve(Translog.CHECKPOINT_FILE_NAME);  
                                threadId + "_" + opCount,  
                assertNotNull(translogGeneration.translogUUID);
        Translog.TranslogGeneration translogGeneration = null;
        for (int i = 0; i < operations; i++) {
        assertThat(reader.getCheckpoint().minSeqNo, equalTo(minSeqNo));
            .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
            TranslogReader reader = translog.openReader(
                    assertThat(e.getCause(), instanceOf(EOFException.class));
                );
            assertThat(seenSeqNos, equalTo(expected));  
            assertFalse(translog.syncNeeded());  
            threads[i].setDaemon(true);
            }
    }
            );
        int extraDocs = randomIntBetween(10, 15);  
            Translog tlog = new LocalTranslog(  
            IllegalArgumentException.class,  
                    // failed - that's ok, we didn't even create it or it was corrupted from partial writes
        TranslogConfig config = translog.getConfig();
                    if (failedToSyncCheckpoint.get()) {
                // Since the buffer is full, this will flush before performing the add.
        final long minSeqNo;
        translog.add(new Translog.Index("" + 0, 0, primaryTerm.get(), Integer.toString(0).getBytes(Charset.forName("UTF-8"))));  
    @Before
        final FilterFileSystemProvider filterFileSystemProvider = new FilterFileSystemProvider(  
import org.apache.lucene.tests.util.LineFileDocs;
    public void setUp() throws Exception {
                try (Closeable ignored = translog.acquireRetentionLock()) {  
                totalOperations++;
                }  
                IOUtils.closeWhileHandlingException(this);
                    assertNotNull("operation " + i + " must be non-null synced: " + sync, next);  
        List<Translog.Location> locations = new ArrayList<>();
                }
            });  
                    LongConsumer persistedSequenceNumberConsumer  
        int translogOperations = randomIntBetween(10, 100);  
        try (Translog.Snapshot snapshot = translog.newSnapshot(seqNo + 1, randomLongBetween(seqNo + 1, Long.MAX_VALUE))) {  
    public void testNegativeNumberOfOperations() {
                }
                                translog.sync();  
            assertNotNull(ex.getCause());  
            fileChannels
                    Translog.Delete del = (Translog.Delete) op;  
        }  
            0,  
                assertFalse("translog has been synced already", translog.ensureSynced(locations.stream()));  
        translog = new LocalTranslog(
import static org.opensearch.index.translog.SnapshotMatchers.containsOperationsInAnyOrder;
    }
                "" + op,
                translog.getTranslogUUID(),
        );
        for (long gen = 1; gen < translog.getMinFileGeneration(); gen++) {  
            if (earliestLastModifiedAge > stats.getEarliestLastModifiedAge()) {
    }
                    assertNull(next);
                        assertTrue(loc.equals(location));
            // Sequence numbers are marked as persisted after sync  
            // now randomly open this failing tlog again just to make sure we can also recover from failing during recovery
                        Translog.Index expIndexOp = (Translog.Index) expectedOp;
        try (Translog.Snapshot snapshot = translog.newSnapshot(0, Long.MAX_VALUE)) {  
                    Translog.Operation next = snapshot.next();
                        assertThat(noOp.primaryTerm(), equalTo(expectedNoOp.primaryTerm()));
        expectThrows(TranslogCorruptedException.class, () -> Translog.readGlobalCheckpoint(translogDir, UUIDs.randomBase64UUID()));
                }  
            TranslogOperationHelper.DEFAULT,  
        }
                    assertEquals("payload mismatch, synced: " + sync, i, Integer.parseInt(next.getSource().source.utf8ToString()));  
                .build()
            } else {
                    null
                }  
        assertThat(total.getUncommittedOperations(), equalTo(0));
import static org.hamcrest.Matchers.endsWith;
                if (throwUnknownException) {
        misbehavingTranslog.callCloseOnTragicEvent();
    }
                        failableTLog.add(
        Version oldVersion = VersionUtils.randomVersionBetween(  
        final ChannelFactory channelFactory = (file, openOption) -> {
            Translog translog = new LocalTranslog(  
                            "" + opsSynced,  
        );
        // byte identity.
    public void testTranslogWriterDoesNotBlockAddsOnWrite() throws IOException, InterruptedException {
                channelFactory  
                    it.remove();  
                        }
            }
            null,  
    public void tearDown() throws Exception {  
                            long globalCheckpoint = lastGlobalCheckpoint.get();
                        Translog.Delete delOp = (Translog.Delete) op;
        deletionPolicy.setRetentionSizeInBytes(-1);
            final TranslogStats stats = stats();
        }
                            checkpointFsyncCalls.incrementAndGet();
                () -> SequenceNumbers.NO_OPS_PERFORMED,
            assertEquals(2, translog.currentFileGeneration());  
                    while (idGenerator.get() < maxOps) {
        int count = 0;  
            IllegalArgumentException.class,
            primaryTerm.get()  
                assertThat(deletionPolicy.getTranslogRefCount(minGen), equalTo(0L));
        private final TestTranslog.FailSwitch fail;
                );  
                        assertEquals(expIndexOp.id(), indexOp.id());
            locations.add(
                long minGen;
        IOUtils.close(writer);
 * ownership. Elasticsearch licenses this file to you under  
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 3);
            );
                translog.sync();  
            translog.add(new Translog.Index("1", 0, primaryTerm.get(), Integer.toString(1).getBytes(Charset.forName("UTF-8"))));
                    if (rarely()) { // lets verify we can concurrently read this  
                    false,
            () -> SequenceNumbers.NO_OPS_PERFORMED,
            }, threadName);  
            threads[i].start();
                );
        }
                .earliestLastModifiedAge(1)  
        translog.close();
                            if (idGenerator.get() < maxOps) {
            }  
                }
                config,
            createTranslogDeletionPolicy(),
                writtenOperations,  
                writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 5);
import org.opensearch.index.mapper.IdFieldMapper;  
import org.apache.lucene.codecs.CodecUtil;
        return new Checkpoint(
        }
    private Term newUid(ParsedDocument doc) {  
                                assertThat(checkpoint.minSeqNo, lessThanOrEqualTo(op.seqNo()));  
            }  
            assertThat(snapshot2.totalOperations(), equalTo(ops.size()));
                        src.limit(randomIntBetween(pos, limit));
                assertEquals(
            assertFalse(translog.syncNeeded());  
        translog.add(new Translog.Index("" + 0, 0, primaryTerm.get(), Integer.toString(0).getBytes(Charset.forName("UTF-8"))));
        }
            Collections.shuffle(locations, random());
                    long initialMinTranslogGen,
                    primaryTerm.get(),
            }  
            )
                // Add after we the read flushed the buffer  
        translog.close();
        public void force(boolean metadata) throws IOException {  
        if (reader instanceof TranslogReader) {
            writer.sync();
    public void testEnsureNoCircularException() throws Exception {
import org.apache.lucene.store.ByteArrayDataOutput;  
import java.util.Random;
            TranslogCorruptedException.class,  
            StandardOpenOption.WRITE,  
                } catch (IOException ex) {
        }  
                firstUncommitted = op + 1;  
                assertFileIsPresent(translog, generation + i);  
            shardId,
                        case NO_OP:  
                    try {
                });
        logger.info("using [{}] readers. [{}] writers. flushing every ~[{}] ops.", readers.length, writers.length, flushEveryOps);
        }  
                    + "but got Checkpoint{offset=0, numOps=0, generation=0, minSeqNo=-1, maxSeqNo=-1, globalCheckpoint=-1, "
    private static final class UnknownException extends RuntimeException {  
            () -> SequenceNumbers.NO_OPS_PERFORMED,  
            );
        for (; op < translogOperations / 2; op++) {
    public void testBasicRecovery() throws IOException {  
     * same operations added one at a time. We build two translogs from identical configs/ops and compare on disk.  
        final Map<Long, Translog.Operation> latestOperations = new HashMap<>();
        e = expectThrows(
                @Override
            expectThrows(IOException.class, translog::rollGeneration);
import org.opensearch.index.engine.Engine.Operation.Origin;
/*  
    }  
            }  
            1,  
            for (int i = 0; i < iters; i++) {  
        final String translogUUID = translog.getTranslogUUID();
            TranslogOperationHelper.DEFAULT,  
        }
            channelFactory
                    null
        this.translog = new LocalTranslog(
                allOperations.add(operation);
                translog.trimUnreferencedReaders();
            void callCloseUsingIOUtilsWithExceptionHandling() {  
import org.opensearch.common.bytes.ReleasableBytesReference;
                                synced = translog.ensureSynced(location);
        }  
            assertThat(stats.getTranslogSizeInBytes(), equalTo(328L));  
            assertEquals(i, value);
        final TranslogDeletionPolicy deletionPolicy = translog.getDeletionPolicy();
            try {  
                    if (src.hasRemaining()) {
                    )
        {  
            shardId,
                int upTo = sync ? translogOperations : prepareOp;
            assertThat(noOp.seqNo(), equalTo(seqNo));
import java.nio.file.StandardOpenOption;
            for (Thread thread : threads) {
                    assertEquals(ex.getMessage(), "__FAKE__ no space left on device");  
            assertThat(stats.getUncommittedOperations(), equalTo(0));
                expectedSeqNo.addAll(views.pop());  
                uncommittedOps = operationsInLastGen;  
                            .values().length))];  
                primaryTerm::get,
        final List<Translog.Operation> readOperations = Translog.readOperations(out.bytes().streamInput(), "testSnapshotFromStreamInput");  
            boolean atLeastOneFailed = false;
        }
                            Integer.toString(opsSynced).getBytes(Charset.forName("UTF-8"))  
        }
            FileChannel delegate = FileChannel.open(file, openOption);
        long localCheckpoint = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, op);
            assertThat(snapshot1.totalOperations(), equalTo(1));
                    );
            deletionPolicy,
                }
                        }  
        final Map<Translog.Operation, Translog.Location> writtenOps = ConcurrentCollections.newConcurrentMap();  
                IOUtils.close(this);
                    assertTrue(locations.get(j).equals(locations2.get(j)));
            assertThat(snapshot1, SnapshotMatchers.equalsTo(ops.get(0)));
        for (int gen = 0; gen < generations; gen++) {
        for (int i = 0; i < threadCount; i++) {
import java.nio.file.CopyOption;
                    translogUUID,
            assertThat(stats.estimatedNumberOfOperations(), equalTo(4));
            fail("already closed");  
                    primaryTerm.get()
            assertSame(translog.getTragicException(), ex.getCause());  
                    // we survived all the randomness!!!  
                            break;
                    assertNotNull("operation " + i + " must be non-null", next);  
                        final int pos = src.position();
        for (int i = 0; i < 5; i++) {
                assertEquals(Integer.parseInt(next.getSource().source.utf8ToString()), i);  
                String ascii = randomAlphaOfLengthBetween(1, 50);  
                )
                assertThat(writeCalls.get(), greaterThan(initialWriteCalls));
            void callCloseUsingIOUtils() throws IOException {
                }
        return false;
                deletionPolicy,
        try (Closeable ignored = translog.acquireRetentionLock()) {
                    )
                translog.getDeletionPolicy()
        deletionPolicy.setRetentionAgeInMillis(randomLong());  
     */
            translog.getMaxSeqNo(),
                seqNos.add(currentSeqNo);
                        public void force(boolean metaData) throws IOException {  
            boolean foundUnrouted = false;  
        Checkpoint read = Checkpoint.read(ckp);  
        }  
            try {
                deletionPolicy,
     */
                            fail("duplicate op [" + op + "], old entry at " + location);
            deletionPolicy.setRetentionAgeInMillis(randomBoolean() ? 100 : -1);
                .uncommittedOperations(1)
        assertThat("at least one truncation was caused and caught", truncations.get(), greaterThanOrEqualTo(1));  
        final TranslogCorruptedException translogCorruptedException = expectThrows(
            IllegalArgumentException.class,
            thread.join();
                TranslogOperationHelper.DEFAULT,
            final Set<Tuple<Long, Long>> seenSeqNos = new HashSet<>();  
            translogConfig,  
            this.fail = fail;
        String deleteRouting = wireVersion.onOrAfter(Version.V_3_9_0) ? "custom-routing" : null;  
    }
                    Translog.Operation next = snapshot.next();
                opsPerThread,  
        for (long gen = translog.getMinFileGeneration(); gen < translog.currentFileGeneration(); gen++) {  
                }  
                .filter(r -> r.getCheckpoint().minSeqNo >= 0)  
        ) {
            }
        }
        final boolean sync = randomBoolean();
    }  
                    opCountPerGeneration.put(g, opCount);  
            }
            );
            }
            for (int t = 0; t < threads.length; t++) {
                TranslogConfig config,
                        assertEquals("payload mismatch, synced: " + sync, i, Integer.parseInt(next.getSource().source.utf8ToString()));
            Translog batchTranslog = openTranslog(batchConfig, batchUUID)  
            }
            primaryTerm.get()  
        }
                if (primaryTerm.get() == translog.getCurrent().getPrimaryTerm()) {  
                if (ex != null) {  
    protected Translog openTranslog(TranslogConfig config, String translogUUID) throws IOException {
            boolean success = false;
            Translog.Operation firstOp = snapshot.next();
            SequenceNumbers.UNASSIGNED_SEQ_NO,
        TranslogConfig config = translog.getConfig();  
                .boxed()
            try (Translog.Snapshot snapshot = new TestTranslog.SortedSnapshot(translog.newSnapshot())) {
                        src.limit(randomIntBetween(pos, limit));
                        if (randomBoolean()) {
        }
            }  
        }  
        };
import org.opensearch.index.VersionType;
                        public int write(ByteBuffer src) throws IOException {
                    Checkpoint checkpoint = Translog.readCheckpoint(config.getTranslogPath());  
        translog.close();  
                        while ((operation = snapshot.next()) != null) {
        translog.close();
                    writer.sync();
                    + "[1:"
            ) {  
        super.afterIfSuccessful();
    public void testRecoveryFromFailureOnTrimming() throws IOException {
                for (int i = 0; i < upTo; i++) {  
            temp.getTranslogPath(),
                assertThat(snapshot.skippedOperations(), is(allOperations.size() - effectiveOperations.size()));
                        + 328
                    }
            final TranslogStats stats = stats();
                );
import org.hamcrest.Matchers;  
                    // captures the last committed checkpoint, while holding the view, simulating
                    reader.close();  
        final TranslogDeletionPolicy deletionPolicy = createTranslogDeletionPolicy(config.getIndexSettings());
        try (
                    assertEquals(
    }
            fail("WTF");  
        persistedSeqNos.remove(SequenceNumbers.UNASSIGNED_SEQ_NO);
            assertThat(snapshot.totalOperations(), equalTo(0));
    public void testUncommittedOperations() throws Exception {
        String translogUUID = Translog.createEmptyTranslog(
            )
                threadExceptions[threadId] = t;  
                TranslogOperationHelper.DEFAULT,
        final Map<Long, Long> terms = new HashMap<>();
            translog.add(operation);  
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 3);
        locs.add(addToTranslogAndList(translog, ops, new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 })));
                            syncedDocs.clear();  
            while ((op = snapshot.next()) != null) {
    private Translog create(Path path) throws IOException {  
            randomLongBetween(minRetainedReader.getCheckpoint().minSeqNo, minRetainedReader.getCheckpoint().maxSeqNo) - 1
                        final int pos = src.position();  
        try (Translog.Snapshot snap = translog.newSnapshot()) {
        final int prepareOp = randomIntBetween(0, translogOperations - 1);
                            new Translog.Index("" + opsAdded, opsAdded, primaryTerm.get(), doc.getBytes(Charset.forName("UTF-8")))
                assertNull(snapshot.next());  
                            break;
        private final Map<Long, Translog.Operation> operations = new HashMap<>();
                        final Translog.Operation.Type type = Translog.Operation.Type.values()[((int) (id % Translog.Operation.Type
                assertFalse("all of the locations should be synced: " + location, translog.ensureSynced(location));  
                seqNo -> {},
            // Sync against so that both operations are written
        assertThat(translog.currentFileGeneration(), equalTo(generation + rolls));
        Path tempDir = createTempDir();
            addToTranslogAndList(translog, ops, new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
import org.opensearch.index.mapper.SeqNoFieldMapper;  
                        }
        int iters = randomIntBetween(5, 10);  
            long seqNo;
            .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)  
            return super.write(src);
        final CountDownLatch downLatch = new CountDownLatch(1);  
        );
                        assertThat(opCount, equalTo(reader.totalOperations()));  
        final Thread[] readers = new Thread[randomIntBetween(1, 3)];
            int numOps = randomIntBetween(1, 100);
                assertFileDeleted(translog, i);  
 */  
        @Override  
        );
    }
                }
        Collection<Translog.Operation> operations() {
            stats.writeTo(out);  
                            opCount++;
        assertThat(total.estimatedNumberOfOperations(), equalTo(0));
                        if (randomFloat() < 0.1) {
            batchBytes = Files.readAllBytes(batchDir.resolve(Translog.getFilename(gen)));  
        translog.close();
                    if (randomBoolean()) {
        return getTranslogConfig(path, settings);  
            }
        @Override
            for (Location location : locations) {
        while (failed == false) {
        }
                translog.rollGeneration();
        @Override
                    added.countDown();
        }
                }
        }  
import java.io.IOException;  
                    assertEquals(  
    }  
                if (op instanceof Translog.Delete) {
            if (fail.fail()) {
        public long read(ByteBuffer[] dsts, int offset, int length) throws IOException {
                        }
            int iters = randomIntBetween(10, 100);
    /**  
        TranslogConfig config = translog.getConfig();
        }  
                        syncedDocs.addAll(unsynced); // failed in fsync but got fully written
        try (
 */
                config,
                if (partialWrite) {  
            new ByteSizeValue(4, ByteSizeUnit.KB),  
            Translog.Index operation = new Translog.Index("" + op, op, primaryTerm.get() - op, ascii.getBytes("UTF-8"));
        final TranslogConfig config = getTranslogConfig(tempDir);
                    TranslogOperationHelper.DEFAULT,
        translog.trimUnreferencedReaders();
                            assertThat(checkpoint.offset, greaterThanOrEqualTo(location.translogLocation));
        translog.add(new Translog.Index("2", 1, primaryTerm.get(), new byte[] { 2 }));
        in = out.bytes().streamInput();
            assertEquals("payload mismatch for operation 1", 1, Integer.parseInt(op.getSource().source.utf8ToString()));
        // add a single operation to current with seq# > trimmed seq# but higher primary term  
            Exception[] threadExceptions  
    public void testFullRangeSnapshotWithFailures() throws Exception {  
        for (int gen = 0; gen < generations; gen++) {  
                .collect(Collectors.toList());  
                threads[t].start();
                }
        for (long gen = 1; gen < translog.currentFileGeneration(); gen++) {
            assertThat(snapshot, SnapshotMatchers.size(numOps));  
        translog.close();  
            if (randomBoolean()) {
        downLatch.countDown();  
                            syncedDocs.addAll(unsynced);
                        TranslogSnapshot snapshot = reader.newSnapshot();  
                switch (op.opType()) {
            int totOps = 0;
        TranslogConfig config = translog.getConfig();
            Translog.Index op = new Translog.Index(randomAlphaOfLength(10), i, primaryTerm.get(), new byte[] { 1 });
                    unsynced.clear();
                    Translog.Operation op;
import java.util.concurrent.atomic.AtomicLong;  
import java.nio.file.Files;
                Translog tlog = new LocalTranslog(
            return super.read(dst);  
        );  
                translog.sync();
            }  
                seqNo -> {},
            assertEquals(4, checkpointFsyncCalls.get());
        AlreadyClosedException ex = expectThrows(AlreadyClosedException.class, () -> translog.newSnapshot());  
            )
            Path tempDir = createTempDir();
                        translog.currentFileGeneration() - 1,
            );
        ) {
        assertThat(failableTLog.isOpen(), is(false));  
                assertFileDeleted(translog, translog.currentFileGeneration() - 1);
    public void testMinSeqNoBasedAPI() throws IOException {
                // we are the last location so everything should be synced  
            }
            ? writer  
            string = randomRealisticUnicodeOfCodepointLength(randomIntBetween(min, max));  
        }  
    private Translog getFailableTranslog(
                    2L,
        expectThrows(
        );  
                () -> SequenceNumbers.NO_OPS_PERFORMED,
        Translog.Location loc2 = translog.add(new Translog.Delete("doc-2", 1, primaryTerm.get(), 1));
            final LongConsumer consumer = persistedSeqNoConsumer.get();  
            return new FilterFileChannel(channel) {
                translog.currentFileGeneration()
                if (ex.getCause() instanceof MockDirectoryWrapper.FakeIOException) {
    public static class ThrowingFileChannel extends FilterFileChannel {  
                    Translog.Operation next = snapshot.next();
                translog.rollGeneration();  
        assertThat(total.getEarliestLastModifiedAge(), equalTo(0L));  
            for (Throwable suppress : errors.subList(1, errors.size())) {
                primaryTerm::get,  
        protected Translog.Location add(Translog.Operation op) throws IOException {
                } catch (TranslogException | MockDirectoryWrapper.FakeIOException | TranslogCorruptedException ex) {
            null
                        throw new IOException("__FAKE__ no space left on device");  
        Checkpoint read = Checkpoint.read(ckp);  
            deletionPolicy.setRetentionAgeInMillis(-1);
        return currentSeqNo;
                }
    static class InMemoryTranslog {
            if (frequently()) {
        translog.add(new Translog.Index("3", 2, primaryTerm.get(), new byte[] { 3 }));
                } catch (RuntimeException ex) {
        int count = 0;
        final AtomicBoolean run = new AtomicBoolean(true);  
        final String reason = randomAlphaOfLength(16);
                    channel
import java.util.concurrent.BlockingQueue;
            fail("already closed");  
        final Checkpoint checkpoint = randomCheckpoint();  
    public void testTranslogWriterCanFlushInAddOrReadCall() throws IOException {
            final int threadId = i;
                }
            boolean success = false;  
                }  
                    IOUtils.closeWhileHandlingException(channel);
                        locations.get(i).generation  
                readFromSnapshot += snapshot.skippedOperations();  
        for (Thread thread : readers) {  
            Long repeatingTermSeqNo = randomFrom(seqNos.stream().map(Tuple::v1).collect(Collectors.toList()));
                        inner.addSuppressed(e);
                locations2.add(
        };
            fail("closed");
                try (Translog.Snapshot snapshot = new TestTranslog.SortedSnapshot(translog.newSnapshot())) {
import org.opensearch.test.VersionUtils;
        int i = 0;
        final TranslogConfig config,  
                if (rarely()) {
    }
    public void testTranslogWriterFsyncedWithLocalTranslog() throws IOException {
    }
            translog.rollGeneration();
                    final ByteBuffer buffer = ByteBuffer.allocate(4);
        }  
            stats.writeTo(out);  
            temp.getTranslogPath(),  
        final TranslogConfig config = getTranslogConfig(tempDir);  
            seqNo -> {},
                    assertEquals(ex.getMessage(), "__FAKE__ no space left on device");
            }
                config.getTranslogPath(),
import org.apache.lucene.document.NumericDocValuesField;
    }
                translog.add(
            assertThat(snapshot.totalOperations(), equalTo(1));
            batchDir,  
        final TestTranslog.FailSwitch fail = new TestTranslog.FailSwitch();
                }
            if (threadExceptions[i] != null) {
                                signalReaderSomeDataWasIndexed.notifyAll();
public class LocalTranslogTests extends OpenSearchTestCase {
                assertEquals(
            primaryTerm::get,
                }
    private AtomicLong globalCheckpoint;  
    private TranslogConfig getTranslogConfig(final Path path) {
        Map<Long, List<Translog.Operation>> operationsByGen = new HashMap<>();
                        }
            threads[i].join(60 * 1000);
                            }  
                    // simulate going OOM and dying just at the wrong moment.
        }
            }
        translog.add(  
            translogUUID,
                            acquireRetentionLock();
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.index.seqno.SequenceNumbers;
            Collection<TestTranslog.LocationOperation> writtenOperations,
import static org.mockito.Mockito.mock;  
        locs.add(addToTranslogAndList(translog, ops, new Translog.Index("2", 1, primaryTerm.get(), new byte[] { 1 })));  
        addToTranslogAndList(translog, ops, new Translog.NoOp(seqNo, noopTerm, reason));  
        final Translog.Location[] locs = translog.add(one);
            TranslogConfig config = getTranslogConfig(tempDir);
                            failableTLog.rollGeneration();  
                            break;  
        StreamInput in = out.bytes().streamInput();
                out.writeInt(i);
                            Translog.Operation op;  
                .earliestLastModifiedAge(1)
                assertFalse("no sync needed since no operations in current translog", translog.syncNeeded());
        assertThat(e, hasToString(containsString("earliestLastModifiedAge must be >= 0")));
            2,  
        return new LocalTranslog(
                    views.get(views.size() - 1).add(op);
        for (long seqNo = 0; seqNo < operations; seqNo++) {
                    afterAdd();  
            }
        final int threadCount = randomIntBetween(1, 5);  
        try (Translog reopenedTranslog = openTranslog(config, failableTLog.getTranslogUUID())) {
                            if (startBlocking.get()) {
        assertEquals(read, checkpoint);
                new Translog.Index("2", 1, primaryTerm.get(), lineFileDocs.nextDoc().toString().getBytes(Charset.forName("UTF-8")))
        try (Translog tlog = openTranslog(config, translog.getTranslogUUID()); Translog.Snapshot snapshot = tlog.newSnapshot()) {
                    }
        @Override  
        public int write(ByteBuffer src, long position) throws IOException {
                null
            );
                protected Translog.Location add(Translog.Operation op) throws IOException {
            List<Translog.Operation> ops = new ArrayList<>(seqNos.size());  
                        (key, existing) -> existing == null ? seqNo : Math.max(existing, seqNo)  
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
            channelFactory,
package org.opensearch.index.translog;
                fail("read past EOF?");
        long minSeqNo = SequenceNumbers.NO_OPS_PERFORMED;
        }
        final ChannelFactory channelFactory = (file, openOption) -> {
                        synchronized (signalReaderSomeDataWasIndexed) {  
            .put(IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.getKey(), "-1b")
                seqNo -> {},
        List<Translog.Operation> ops = new ArrayList<>();  
        );
                .uncommittedOperations(1)
                }
            shardId,
            assertFalse(translog.syncNeeded());
        final Thread[] writers = new Thread[randomIntBetween(1, 3)];  
            }  
            if (fail.fail()) {
                        )
            final int generations = randomIntBetween(2, 20);
        BytesStreamOutput out = new BytesStreamOutput();
            minGenForRecovery = translog.getMinGenerationForSeqNo(localCheckpoint + 1).translogFileGeneration;  
        assertThat(
                        if (threadExceptions[i] != null) {
        Thread[] threads = new Thread[threadCount];
        // we add N+1 and N+2 to ensure we only delete the N+1 file and never jump ahead and wipe without the right condition  
                        }  
                    throw new MockDirectoryWrapper.FakeIOException();
                    final Set<Tuple<Long, Long>> generationSeenSeqNos = new HashSet<>();
        Path[] files = FileSystemUtils.files(directory, "translog-*");
                public void onFailure(Exception e) {
    }
import org.opensearch.common.util.concurrent.ReleasableLock;
                translog.getDeletionPolicy().setLocalCheckpointOfSafeCommit(Long.MAX_VALUE);  
        } catch (IllegalArgumentException ex) {
                opsHaveValidSequenceNumbers = opsHaveValidSequenceNumbers || !rarely();
    }
                primaryTerm::get,
                translogGeneration = translog.getGeneration();  
        added.await();
import static org.hamcrest.Matchers.nullValue;
            Translog.Operation next = snapshot.next();
                );  
    }
        try (Translog tlog = openTranslog(config, translog.getTranslogUUID()); Translog.Snapshot snapshot = tlog.newSnapshot()) {  
            fail("should have failed earlier");
 * GitHub history for details.
            IllegalArgumentException.class,
        }  
        Translog.Delete readBack1 = (Translog.Delete) translog.readOperation(loc1);  
            0,  
            fail("Should throw exception for missing operations");  
                translogOperations,  
        int translogOperations = randomIntBetween(10, 100);
        Path ckp = config.getTranslogPath().resolve(Translog.CHECKPOINT_FILE_NAME);  
            final boolean commit = commitOften ? frequently() : rarely();
                                break;
                }
            }  
            for (int op = 0; op < translogOperations; op++) {
                    Files.createFile(target);  
            if (randomBoolean()) {  
            translog.sync();
                assertEquals(
        final long a = randomNonNegativeLong();
 * The OpenSearch Contributors require contributions made to  
            primaryTerm::get,  
                }
                        opsAdded,  
                translog.rollGeneration();
            shardId,
            AtomicLong seqNoGenerator,
        @Override
        final Exception[] threadExceptions = new Exception[threadCount];
            seqNo -> {},
                new DefaultTranslogDeletionPolicy(-1, -1, 0),
        final int numberOfReaders = scaledRandomIntBetween(1, 10);
            assertFalse(tlog.syncNeeded());  
    public void testTruncatedTranslogs() throws Exception {
                    } else {  
            NON_RECYCLING_INSTANCE,
            String ascii = randomAlphaOfLengthBetween(1, 50);  
                ) throws IOException {
            }
            assertThat(copy.estimatedNumberOfOperations(), equalTo(4));
        try {
                assertNull(snapshot.next());  
        }  
        final TranslogDeletionPolicy deletionPolicy = translog.getDeletionPolicy();  
        final String translogUUID = translog.getTranslogUUID();
    }  
    private String randomNonTranslogPatternString(int min, int max) {
            );  
        for (long i = minRetainedReader.generation; i < generation + rolls; i++) {  
                for (Translog.Operation op : operationsByGen.getOrDefault(gen, Collections.emptyList())) {
        int retainedOps = Stream.concat(translog.getReaders().stream(), Stream.of(translog.getCurrent()))  
            if (randomBoolean()) {
        Files.createFile(config.getTranslogPath().resolve("translog-" + (read.generation + 2) + ".tlog"));
        List<Translog.Location> locations = new ArrayList<>();  
                primaryTerm.incrementAndGet();  
                inMemoryTranslog.add(operation);  
            }
            buffer.flip();  
                null  
            () -> SequenceNumbers.NO_OPS_PERFORMED,  
            assertThat(stats.getTranslogSizeInBytes(), equalTo(273L));
                for (int i = 0; i < opCount; i++) {
            final TranslogStats stats = stats();
        try (
                FileChannel open = FileChannel.open(p, o);  
        for (int op = 0; op < translogOperations; op++) {
    public void testSyncUpToStream() throws IOException {
        Translog.TranslogGeneration translogGeneration = null;
            )  
            )  
            }
                    assertEquals(
            out.writeInt(i);
        // Verify via snapshot as well
                Translog.Operation operation;
        }  
import java.util.HashMap;
            public void copy(Path source, Path target, CopyOption... options) throws IOException {  
import org.opensearch.core.common.unit.ByteSizeUnit;  
                        switch (type) {
            try (ReleasableLock ignored = translog.writeLock.acquire()) {  
        fail.failAlways();
        if (randomBoolean()) {
        e = expectThrows(  
        return new LocalTranslog(
        try {
    public void testBasicCheckpoint() throws IOException {
            locations.add(
                totOps++;  
                                randomUnicodeOfLengthBetween(1, 20 * 1024).getBytes("UTF-8")
            assertThat(stats.getEarliestLastModifiedAge(), greaterThanOrEqualTo(lastModifiedAge));  
 * specific language governing permissions and limitations
    /**
            assertNull(next);
        queue.add(cause);
            );
            channelFactory,  
            }
        assumeTrue("test only works with assertions enabled", Assertions.ENABLED);
                    null  
                writer.readBytes(ByteBuffer.allocate(256), 0);
                failableTLog.rollGeneration();
            writer.sync();  
            }
            assertThat(stats.getUncommittedSizeInBytes(), equalTo(102L));
        final Path path = createTempDir();  
                    allOperations.stream()
            config,
            );
        fail.failNever();
        final int operations = randomIntBetween(1, 4096);
                Translog.Location location = RandomPicks.randomFrom(random(), locations);
                translog.trimUnreferencedReaders();
        addToTranslogAndList(translog, ops, new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
                        if (id % writers.length == threadId) {  
                downLatch,  
    }  
        final List<Long> primaryTerms = new ArrayList<>();  
                assertFalse("location is from a previous translog - already synced", translog.ensureSynced(locations.stream()));
            assertEquals("payload mismatch for operation 2", Integer.parseInt(secondOp.getSource().source.utf8ToString()), 2);  
            Translog.parseIdFromFileName(file);  
            }
            () -> SequenceNumbers.NO_OPS_PERFORMED,
            assertNull(snapshot.next());
            FileChannel::open,  
                assertEquals(expectedOp.opType(), op.opType());  
        }
                    retentionLock = translog.acquireRetentionLock();  
            }  
            List<Long> batch = LongStream.rangeClosed(0, between(0, 500)).boxed().collect(Collectors.toList());
                }
            equalTo(maxSeqNoPerGeneration.isEmpty() ? SequenceNumbers.NO_OPS_PERFORMED : Collections.max(maxSeqNoPerGeneration.values()))  
            TranslogOperationHelper.DEFAULT,
                        logger.error("unexpected error while closing view, after failure", inner);  
            } catch (IOException e) {
        do {
        ) {  
            if (translog.currentFileGeneration() > 1) {
            FileChannel::open,
    public void testSnapshotTrimmedOperations() throws Exception {
            }, threadId);  
            }  
            } catch (Exception t) {
                    assertEquals(expectedOp, translog.readOperation(locationOperation.location));
        final int maxAttempts = 10;
                    }
        final BlockingQueue<TestTranslog.LocationOperation> writtenOperations = new ArrayBlockingQueue<>(threadCount * opsPerThread);
        // make sure we keep some files around
        List<Translog.Location> locations = new ArrayList<>();
        translog.add(new Translog.NoOp(3, 1, randomAlphaOfLength(16)));
            void callCloseOnTragicEvent() {
            seqNo -> {},
                            super.force(metaData);
                    buffer.flip();  
            for (int gen = 0; gen < generations; gen++) {  
            @Override  
                }
                translog.rollGeneration();  
                        src.limit(limit);
        if (sync) {  
        // translog here as well.
                .collect(Collectors.toList())
            Translog.Snapshot snapshot = translog.newSnapshot();
        }  
            int translogOperations = randomIntBetween(10, 100);
        ) {
                    translogUUID,
            assertThat(translog.getCurrent().getPrimaryTerm(), equalTo(primaryTerm.get()));
            threads[i] = new TranslogThread(translog, downLatch, 200, threadId, writtenOperations, seqNoGenerator, threadExceptions) {  
            }
    public void testFatalIOExceptionsWhileWritingConcurrently() throws IOException, InterruptedException {
                    throw new UnknownException();  
            }  
        );
                    assertEquals(ex, failableTLog.getTragicException());
        final int generations = between(2, 20);  
                .earliestLastModifiedAge(-1)
        if (a <= b) {  
                    channel = delegate;
        final CountDownLatch added = new CountDownLatch(randomIntBetween(10, 100));
            assertThat(persistedSeqNos, empty());
                }
        Path tempDir = createTempDir();  
            if (frequently()) {
            )
                    throw e;
                assertEquals(ex.getMessage(), "__FAKE__ no space left on device");
                        assertEquals("tenant-routing", del.routing());
                translog.add(op);
            SequenceNumbers.NO_OPS_PERFORMED,
    protected Translog createTranslog(TranslogConfig config) throws IOException {
        // New version writes with routing, new version reads with routing preserved
            }
        ArrayList<Translog.Operation> ops = new ArrayList<>();  
            translog.add(new Translog.NoOp(seqNo++, primaryTerm.get(), "test'"));
            new ByteSizeValue(1, ByteSizeUnit.KB),
                    LineFileDocs lineFileDocs = new LineFileDocs(random()); // writes pretty big docs so we cross buffer boarders regularly
            assertThat(translog.currentFileGeneration(), equalTo(generation + i + 1));
            });
        for (int op = 0; op < translogOperations; op++) {  
                    assertEquals("payload mismatch, synced: " + sync, i, Integer.parseInt(next.getSource().source.utf8ToString()));
     * A local-only translog must keep the layout it has always had: no footer, so the file is exactly as long as
        expectIntactTranslog = false;
            }
            if (rarely()) {  
                "current should not have any operations with seq#:primaryTerm "
            translog.getDeletionPolicy().assertNoOpenTranslogRefs();
            }
                    throw new UnknownException();  
                        Translog.Location location = translog.add(op);  
            }
        );
                    );
            maxTrimmedSeqNo = rollover ? translogOperations - randomIntBetween(4, 8) : translogOperations + 1;
                    + primaryTerm.get()
                threadId,
            threads[i].join(60 * 1000);
import java.util.function.LongConsumer;
            ((TranslogReader) reader).close();  
                opsSynced++;  
        }
            threads[i].start();
            }
                null  
        // Byte-identical .tlog payloads. The two files share an identical header layout (same version, same UUID  
                                primaryTerm.get(),  
        String string;
        translog.getDeletionPolicy().setRetentionSizeInBytes(1024 * 1024);
                            writeCalls.incrementAndGet();
            while (views.isEmpty() == false) {
                    }  
            Translog translog = new LocalTranslog(
                translog.rollGeneration();  
                    assertEquals("payload mismatch, synced: " + sync, i, Integer.parseInt(next.getSource().source.utf8ToString()));  
        Translog.Index index = new Translog.Index(eIndex, eIndexResult);
                    logger.info("--> [{}] done. wrote [{}] ops.", threadName, counter);
    public void testRecoveryUncommitted() throws IOException {
                assertThat("location mismatch at op " + i, batchLocations[i], equalTo(singleLocations.get(i)));
        int uncommittedOps = 0;
        final String translogUUID = Translog.createEmptyTranslog(
                    assertNull(ex.getCause().getMessage());
        Files.createFile(config.getTranslogPath().resolve("translog-" + (read.generation + 1) + ".tlog"));
                    errors.add(e);
                            committing = false;
        logger.info("testing with [{}] threads, each doing [{}] ops", threadCount, opsPerThread);
                                translog.rollGeneration();
                    translogGeneration.translogFileGeneration
            () -> new TranslogStats.Builder().numberOfOperations(1)  
     * to clean up its files.
                );
                            }
    }
            randomSeqNum,
                if (success == false) {
        final Path singleDir = createTempDir();
                "" + translogOperations,
        for (int i = 0; i < operations; i++) {
        IOException expectedException = null;
            config.getTranslogPath().resolve(Translog.getCommitCheckpointFileName(read.generation)),
            }
        assertEquals(ops.size(), readOperations.size());
            for (long seqNo : seqNos) {
            primaryTerm::get
                    2L,
                translog.sync();
        expectIntactTranslog = true;  
        final int n = randomIntBetween(1, 16);
    public void testRollGeneration() throws Exception {  
            assertThat(delete.id(), equalTo("2"));
                            final boolean synced;
                IOUtils.close(reader);
                // make it a noop like the old versions
        Closeable lock = translog.acquireRetentionLock();
                primaryTerm::get,
        assertEquals(ex.getCause().getClass(), FileAlreadyExistsException.class);
            primaryTerm::get,
                );  
            try {  
            // 1. Identical Locations (generation, offset, size) per op
                }  
                    deletionPolicy.setLocalCheckpointOfSafeCommit(localCheckpointOfSafeCommit);
                }  
    public void testSyncUpTo() throws IOException {
            () -> SequenceNumbers.NO_OPS_PERFORMED,
                            generationSeenSeqNos.add(Tuple.tuple(operation.seqNo(), operation.primaryTerm()));  
            }  
        final TranslogConfig config = new TranslogConfig(
                assertTrue("this operation has not been synced", translog.ensureSynced(location));
            SequenceNumbers.NO_OPS_PERFORMED,  
        );  
            deletionPolicy.setLocalCheckpointOfSafeCommit(localCheckpointOfSafeCommit);
                    int upTo = sync ? translogOperations : prepareOp;
            ) {
        for (op = translogOperations / 2; op < translogOperations; op++) {
        assertEquals("tenant-routing", readBack1.routing());  
        final TranslogConfig config = getTranslogConfig(createTempDir());  
        for (int gen = 0; gen < generations; gen++) {
        );
    public void testCrashDuringCheckpointCopy() throws IOException {
                        new Translog.Index("" + op, op, primaryTerm.get(), Integer.toString(op).getBytes(Charset.forName("UTF-8")))
        file = translogDir.resolve(randomNonTranslogPatternString(1, Translog.TRANSLOG_FILE_PREFIX.length() - 1));
                        .filter(allOp -> allOp instanceof Translog.Index && allOp.seqNo() == op)  
                }
                    if (fromSeqNo <= op.seqNo() && op.seqNo() <= toSeqNo && seenSeqNos.add(op.seqNo())) {  
            Translog.parseIdFromFileName(file);
                    config.getTranslogPath(),
    public void testSnapshotDedupOperations() throws Exception {  
                    reader.readBytes(buffer, reader.getFirstOperationOffset() + 4 * i);
            StandardOpenOption.WRITE,  
                    primaryTerm::get,  
            temp.getShardId(),
                    }
                .translogSizeInBytes(1)  
                maxSeqNo = SequenceNumbers.max(maxSeqNo, seqNo);  
        list.add(op);  
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 2);
                Translog recoveredTranslog = new LocalTranslog(  
                seqNoGenerator,  
            );
                );
                () -> SequenceNumbers.NO_OPS_PERFORMED,  
            assertThat("both translogs on same generation", batchTranslog.currentFileGeneration(), equalTo(gen));
 * software distributed under the License is distributed on an
        Path tempDir = createTempDir();  
            false,
import org.opensearch.core.xcontent.MediaTypeRegistry;
            assertNotNull(noOp);
            assertFileDeleted(translog, gen);  
        translog.sync();  
            final int numOps = randomIntBetween(8, 128);  
            doc.id(),
                                long localCheckpoint = tracker.getProcessedCheckpoint();
            try (Translog.Snapshot snapshot = tlog.newSnapshot()) {  
        final Settings settings = Settings.builder()
        final AtomicBoolean startBlocking = new AtomicBoolean(false);
            final AlreadyClosedException alreadyClosedException = expectThrows(AlreadyClosedException.class, translog::rollGeneration);  
        final CountDownLatch downLatch = new CountDownLatch(1);
        @Override
                                .append(" operations from [")
        }  
                    }
                TranslogOperationHelper.DEFAULT,  
                    + "numOps=55, generation=3, minSeqNo=45, maxSeqNo=99, globalCheckpoint=-1, minTranslogGeneration=1, trimmedAboveSeqNo=-2} "
import org.opensearch.index.mapper.ParseContext.Document;
            inMemoryTranslog.trimOperations(primaryTerm.get(), maxTrimmedSeqNo);  
        primaryTerms.add(primaryTerm.get()); // We always create an empty translog.
                    minGen = translog.getMinFileGeneration();
            if (seen.add(current) == false) {  
                translog.add(  
    @Before
            if (frequently()) {  
            try (Translog.Snapshot snapshot = reopenedTranslog.newSnapshot()) {
        Translog.Operation.writeOperation(out, delete);
    }
                    SequenceNumbers.NO_OPS_PERFORMED,  
        ) {  
        assertEquals(ops, readOperations);
                        }  
        BytesReference B_1 = new BytesArray(new byte[] { 1 });
            // 2. snapshot reads all ops back from the batch translog, in order and equal to the inputs
    }
            StandardOpenOption.CREATE_NEW
    private Translog getFailableTranslog(TestTranslog.FailSwitch fail, final TranslogConfig config) throws IOException {
            NON_RECYCLING_INSTANCE,
    private final AtomicLong primaryTerm = new AtomicLong();  
                Translog.Operation op = next.getValue();  
                    2L,  
        Translog.Index operation = new Translog.Index("" + 1, 1L, primaryTerm.get(), randomAlphaOfLengthBetween(1, 50).getBytes("UTF-8"));
import org.opensearch.common.util.concurrent.ConcurrentCollections;
            writeStarted.await();
        assertEquals("doc-1", readBack1.id());
                );
        try (Translog translog2 = create(createTempDir())) {
        addToTranslogAndList(translog, ops, new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));  
            assertThat(snapshot.totalOperations(), equalTo(0));
                "lastCommitted must be 1 less than current",
                        @Override
            "",
        // self control cleaning for test  
            }
                if (rarely()) {
import org.junit.Before;
                        new Translog.Index(
        );
            config,  
        fromSeqNo = randomLongBetween(0, 2000);
                    builder.toString()
            fail,
            assertThat(snapshot, SnapshotMatchers.size(0));
            () -> globalCheckpoint.get(),  
        }
                    channel = delegate;
                persistedSeqNos::add,  
                            throw new AssertionError(e);
            translog.close();  
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
                        tlog.currentFileGeneration() - 1,
                            // we have to sync here first otherwise we don't know if the sync succeeded if the commit fails
                try {  
            List<String> syncedDocs = new ArrayList<>();
        int totalOperations = 0;
            for (int op : ops) {
                    translog.close();
        } finally {
            final long seqNoLowerBound = seqNo;  
            if (rarely()) {
                        )
                }  
                deletionPolicy,
            }
        Checkpoint read = Checkpoint.read(ckp);
                                if (writeStarted.getCount() > 0) {
import java.util.stream.Collectors;
                    // use the latest source of op with the same seq# - therefore no break
            is(  
            final byte[] source = new byte[300];
                        lineFileDocs.nextDoc().toString().getBytes(Charset.forName("UTF-8"))
                    failableTLog.close();  
                opsPerThread,
                    translogGeneration.translogFileGeneration + 3,  
        int lastSynced = -1;
        }  
        }
        try (Translog.Snapshot snapshot = translog.newSnapshot(fromSeqNo, toSeqNo, true)) {  
                );
                f.truncate(newSize);
            assertNotNull(delete);  
                .earliestLastModifiedAge(randomIntBetween(1, 1 << 20))
            assertFileIsPresent(translog, gen);
        addToTranslogAndList(translog, ops, new Translog.Delete("2", 1, primaryTerm.get()));  
import java.util.concurrent.Phaser;  
        final Path translogFile = translogDir.resolve(Translog.getFilename(closedGeneration));  
            for (; op < translogOperations / 2; op++) {  
                    seqNo -> {},
                    super.copy(source, target, options);  
                    globalCheckpointSupplier,  
            FileChannel channel = FileChannel.open(file, openOption);
        logger.debug("--> waiting for readers to stop");  
                .translogSizeInBytes(-1)
                final FileChannel channel;
     * the offset recorded in its checkpoint and no content checksum is derived. The footer is a remote-store  
            StandardOpenOption.TRUNCATE_EXISTING
                primaryTerm::get,
        final Set<Long> persistedSeqNos = new HashSet<>();
                    // it in the finally block but miss to copy over unsynced docs to syncedDocs and fail the assertion down the road...
            config,
    }
    // A default primary term is used by translog instances created in this test.
                    seqNo -> {},  
                translogUUID,
                checkpoint
                return channel;
            final TranslogStats stats = stats();
        Path ckp = config.getTranslogPath().resolve(Translog.CHECKPOINT_FILE_NAME);
                }  
        int minUncommittedOp = -1;
    }  
                final long seqNo = randomValueOtherThanMany(seqNos::contains, () -> randomLongBetween(0, 1000));
        final BaseTranslogReader minRetainedReader = randomFrom(
            for (Long seqNo : batch) {  
        public int write(ByteBuffer src) throws IOException {
        translog.trimUnreferencedReaders();
        Field versionField = new NumericDocValuesField("_version", 1);  
     */  
            max = max(max, location);
                .build()
                TranslogOperationHelper.DEFAULT,
            fail.failNever();
            void deleteReaderFiles(TranslogReader reader) {
        }  
                    seqNoPerGeneration.put(g, generationSeenSeqNos);
            try {
        }  
            assertFalse(translog.isOpen());  
                        assertNotNull("operation " + i + " must be non-null synced: " + sync, next);
                for (int i = 0; i < writtenOperations.size(); i++) {
            randomPrimaryTerm,
            config.getTranslogPath(),  
        for (Translog.Location location : locations) {  
        long[] periods = new long[numberOfReaders + 1];
        private final Collection<TestTranslog.LocationOperation> writtenOperations;  
                            failableTLog.sync();  
                translogGeneration.translogUUID,
            }
            VersionUtils.getPreviousVersion(Version.V_3_9_0)  
                    );  
                final FileChannel channel;
        };  
                Translog.Index op = new Translog.Index(
            TranslogOperationHelper.DEFAULT,
            if (fail.fail()) {
        } catch (UnknownException ex) {
            path.getFileSystem().provider().getScheme(),
import org.apache.lucene.tests.util.LuceneTestCase;  
                () -> SequenceNumbers.NO_OPS_PERFORMED,  
            ) {
    }
                for (int i = 0; i < upTo; i++) {  
        }
            int readFromSnapshot = 0;
        assertThat(Files.size(translogFile), equalTo(checkpoint.offset));
            final int value = buffer.getInt();  
        final int prepareOp = randomIntBetween(0, translogOperations - 1);  
            blocker.countDown();
        // no trimming done yet, just recovered  
            }  
        );
                        }
                    primaryTermSupplier,
        final Checkpoint checkpoint = Checkpoint.read(translog.location().resolve(Translog.CHECKPOINT_FILE_NAME));  
            if (rollover) {
                        retentionLock.close();  
                    config,  
            do {  
                } catch (TranslogCorruptedException e) {  
                Translog.Operation op;
        for (long l : periods) {  
            deletionPolicy,
                getPersistedSeqNoConsumer(),
 * not use this file except in compliance with the License.
            int maxTrimmedSeqNo;  
            if (randomBoolean()) {
        assertEquals("doc-2", readBack2.id());
        long earliestLastModifiedAge = Long.MAX_VALUE;
                source[b] = (byte) ((seqNo * 31 + b) & 0xFF);  
        ) {
                    getTranslogConfig(path),
        }
            assertThat(snapshot, SnapshotMatchers.equalsTo(expectedSeqNo));
        final TestTranslog.FailSwitch fail = new TestTranslog.FailSwitch();
            }  
        final String translogUUID = translog.getTranslogUUID();
                config,
            int threadId,  
            assertNotNull("operation 1 must be non-null", op);
                translog.rollGeneration();
            boolean success = false;  
        List<TestTranslog.LocationOperation> collect = new ArrayList<>(writtenOperations);
        seqID.seqNo.setLongValue(randomSeqNum);
                        writtenOperations.get(i).location.generation
            null
        final boolean partialWrites,
            ) throws IOException {
            batchLocations = batchTranslog.add(ops);
        final TranslogConfig translogConfig = getTranslogConfig(path);
        final Set<Long> persistedSeqNos = new HashSet<>();
                    TranslogOperationHelper.DEFAULT,  
                deletionPolicy,  
            fail.failRandomly();
                        "expected operation" + i + " to be in the previous translog but wasn't",  
                for (int i = 0; i < locations.size(); i++) {
        }
import static org.hamcrest.Matchers.greaterThan;  
    }
        }
                        break;  
            thread.join();  
                primaryTerm::get,
import org.opensearch.core.xcontent.XContentBuilder;  
                assertEquals(writtenOperations.size(), snapshot.totalOperations());  
                    assertNotNull("operation " + i + " must be non-null", next);  
            config,
            deletionPolicy.setLocalCheckpointOfSafeCommit(localCheckpoint);  
        }  
        translog.add(new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
import org.opensearch.core.util.FileSystemUtils;  
        };
        final int operations = randomIntBetween(1, 100);  
        TranslogConfig config = translog.getConfig();  
                    config,  
                        final Translog.NoOp expectedNoOp = (Translog.NoOp) expectedOp;  
                translog.add(
    }
            assertFilePresences(translog);
                    // recovery logic which captures a view and gets a lucene commit
            maxSeqNo = a;
        final long maxSeqNo;
        Checkpoint read = Checkpoint.read(tempDir.resolve("foo.cpk"));  
        final TranslogStats total = new TranslogStats();  
                            }
            byte[] bytes = new byte[4];
                .earliestLastModifiedAge(1)
                        new byte[] { 1 }
            config.getTranslogPath(),  
            }, tempDir.resolve("foo.cpk"), checkpoint2, StandardOpenOption.WRITE);
            long lastModifiedAge = System.currentTimeMillis() - translog.getCurrent().getLastModifiedTime();  
                translog.add(operation);
    }  
            translog.add(new Translog.Index(Integer.toString(i), i, primaryTerm.get(), new byte[] { 1 }));
        final TranslogDeletionPolicy deletionPolicy
            if (firstGenOps == null) {
                null
                        if (expectedOps.isEmpty() == false) {
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), seqNo);
                success = true;
                                synced = true;
                }
        Translog.TranslogGeneration translogGeneration = translog.getGeneration();  
        );  
                seenSeqNos.addAll(generationSeqNo);
            primaryTerm::get,  
        }  
            0,
            }  
            DataOutput out = EndiannessReverserUtil.wrapDataOutput(new ByteArrayDataOutput(new byte[4]));
    }  
                    translog.rollGeneration();
        final CountDownLatch blocker = new CountDownLatch(1);
    protected void afterIfSuccessful() throws Exception {
                        "expected operation" + i + " to be in the previous translog but wasn't",  
    }
            TranslogOperationHelper.DEFAULT,  
                            "" + opsSynced,
    }
import org.apache.logging.log4j.message.ParameterizedMessage;  
        ) {  
        final long b = randomNonNegativeLong();  
            maxSeqNo
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
            }
                assertFalse("the last call to ensureSycned synced all previous ops", translog.syncNeeded());
            translogOperations += extraTranslogOperations;  
        public ThrowingFileChannel(TestTranslog.FailSwitch fail, boolean partialWrite, boolean throwUnknownException, FileChannel delegate)
            assertNull(snapshot.next());  
        }
            );  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.tests.mockfile.FilterFileSystemProvider;  
            config.getTranslogPath(),
            for (Translog.Operation op = snapshot.next(); op != null; op = snapshot.next()) {  
        final String expectedExceptionMessage = "simulated failure during copy";
            Checkpoint.write((p, o) -> {
        Engine.Delete eDelete = new Engine.Delete(
                return channel;
                    if (committing && checkpoint.minTranslogGeneration == checkpoint.generation) {
        final Object signalReaderSomeDataWasIndexed = new Object();
        final TranslogDeletionPolicy deletionPolicy = createTranslogDeletionPolicy(translogConfig.getIndexSettings());  
        private final boolean throwUnknownException;  
        long fixedTime = randomLongBetween(0, 10000000000000000L);  
                    primaryTerm::get,
            new ByteSizeValue(1, ByteSizeUnit.KB),  
                throw new AssertionError("detect circular reference exception", alreadyClosedException);
        assertEquals(ex.getMessage(), "failed to create new translog file");
            }
        final String translogUUID = Translog.createEmptyTranslog(path, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
            byte[] bytes = new byte[256];
                    assertEquals(i, Integer.parseInt(next.getSource().source.utf8ToString()));  
                } else {
                TranslogOperationHelper.DEFAULT,
                    createTranslogDeletionPolicy(),
                }
                translog.rollGeneration(); // empty generation  
        ) {
        expectThrows(AssertionError.class, () -> misbehavingTranslog.callCloseUsingIOUtils());
                                if (writeStarted.getCount() > 0) {
        translog.close(); // we are closed
                    expectedSeqNo.addAll(view);
        assertThat(TranslogFooter.readChecksum(translogFile, checkpoint.offset), nullValue());  
        Path tempDir = createTempDir();
        for (int i = 0; i < numberOfReaders; i++) {
            assertNotNull(index);
                        new Translog.Index(  
import java.nio.file.FileAlreadyExistsException;  
            translog.rollGeneration();
                } else {
            } catch (MockDirectoryWrapper.FakeIOException ex) {
                                final Translog.Location loc = writtenOps.get(expectedOp);  
            gen = singleTranslog.currentFileGeneration();  
            long toSeqNo = randomLongBetween(fromSeqNo, minSeqNo - 1);  
                        + stats.getEarliestLastModifiedAge()  
        Translog translog = getFailableTranslog(fail, config);  
        assertNotNull(readBack2);  
            try {
                        seqNo.getAndIncrement(),
            false  
            this.threadId = threadId;
                translogUUID,  
        private final Translog translog;
    public static Translog.Location randomTranslogLocation() {
        BytesStreamOutput out = new BytesStreamOutput();
                }  
            translog.rollGeneration();
            () -> new TranslogStats.Builder().numberOfOperations(-1)
        }
                                seqNoGenerator.getAndIncrement(),
            ArrayList<Location> locations = new ArrayList<>();
            final FileChannel channel = FileChannel.open(file, openOption);
        primaryTerm.incrementAndGet();  
            deletionPolicy.setRetentionSizeInBytes(-1);
        barrier.await();
            assertThat(TestTranslog.drainSnapshot(snapshot, false), equalTo(expectedOps));
    public void testCloseSnapshotTwice() throws Exception {
        Path tempDir = createTempDir();
                    };
                                } catch (InterruptedException e) {
                translogUUID,  
            assertThat(translog.getMinFileGeneration(), equalTo(minGenForRecovery));
    @Override  
    public void testLocationComparison() throws IOException {
        }
        translog.add(new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
        final byte[] singleBytes;
                    int counter = 0;
                reader.readBytes(buffer, reader.getFirstOperationOffset() + 4 * numOps);
            byte[] bytes = new byte[4];  
        }
        for (int i = 0; i < iters; i++) {
            new ByteSizeValue(8, ByteSizeUnit.KB),  
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            assertThat(stats.getEarliestLastModifiedAge(), greaterThan(0L));
    public void testRecoveryUncommittedFileExists() throws IOException {  
                // some FS don't like our random file names -- let's just skip these random choices  
        final long generation = translog.currentFileGeneration();
        assertThat("translog file length differs", batchBytes.length, equalTo(singleBytes.length));  
            CountDownLatch downLatch,
import org.opensearch.common.io.stream.BytesStreamOutput;
            createTranslogDeletionPolicy(config.getIndexSettings()),
            long maxTrimmedSeqNo = randomInt(allOperations.size());  
     * A batch add must produce a byte-identical translog file, identical Locations, and the same readable ops as the
            }
                config,
                primaryTerm.get()  
            config,
            Translog translog = new LocalTranslog(
            fail.failAlways();  
            validPathString = false;
                        assertEquals(expIndexOp.version(), indexOp.version());
            .put(IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.getKey(), randomBoolean() ? "-1ms" : "1h")  
                translogGeneration.translogFileGeneration + 2,  
        translog.close();
                            return super.write(src);
                return channel;
import org.opensearch.core.common.unit.ByteSizeValue;
            }
                () -> SequenceNumbers.NO_OPS_PERFORMED,
    }  
                    translogGeneration.translogFileGeneration
                }
        }  
    }
import java.util.concurrent.ArrayBlockingQueue;  
                    );
                        translog.sync();
                                assertThat(checkpoint.globalCheckpoint, greaterThanOrEqualTo(globalCheckpoint));
        final TranslogConfig singleConfig = new TranslogConfig(
            for (op = translogOperations / 2; op < translogOperations; op++) {
                }
            if (rarely()) {  
        private final boolean partialWrite;
        assertThat(fileChannels, is(not(empty())));  
                // some strings (like '/' , '..') do not refer to a file, which we this method should return  
        translog.getDeletionPolicy().setRetentionAgeInMillis(3600 * 1000);
                    new Translog.Index("" + op, seqNo, primaryTerm.get(), Integer.toString(seqNo).getBytes(Charset.forName("UTF-8")))
                } else {
            assertThat(expectThrows(IOException.class, brokenTranslog::rollGeneration).getMessage(), equalTo(expectedExceptionMessage));
import java.util.Deque;
    }
            writers[i] = new Thread(new AbstractRunnable() {  
            return super.read(dsts, offset, length);
                assertEquals("__FAKE__ no space left on device", ex.getMessage());
                } else {
            assertThat(stats.getEarliestLastModifiedAge(), greaterThan(0L));  
            assertEquals(lastSynced + 1, reader.totalOperations());
            // this holds a reference to the current tlog channel such that it's not closed  
                    forwardTranslog.add(op);  
                            }
        assertThat(total.getEarliestLastModifiedAge(), equalTo(earliestLastModifiedAge));
import org.junit.After;
            MisbehavingTranslog(
            final TestTranslog.FailSwitch fail = new TestTranslog.FailSwitch();  
        Translog.Delete deserialized = (Translog.Delete) Translog.Operation.readOperation(in);
        out.writeInt(2048);
                        @Override  
    }  
                                deletionPolicy.setLocalCheckpointOfSafeCommit(localCheckpoint);
    public void testPendingDelete() throws IOException {  
            channelFactory,
                    assertEquals(i, value);
                TranslogOperationHelper.DEFAULT,
                    deletionPolicy,  
            "",
        document.add(versionField);
            long startSeqNo = randomLongBetween(0, Integer.MAX_VALUE);
    }
            } else {  
        translog.rollGeneration();  
        TestTranslog.corruptRandomTranslogFile(logger, random(), translogDir, 0);  
            randomNonNegativeLong(),
            if (commit && op < translogOperations - 1) {
            // all good  
            translog.close();
                // not syncing now
                    );  
            if (rarely()) {  
        globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);  
        primaryTerm.set(randomLongBetween(1, Integer.MAX_VALUE));
    }
            for (Translog.Operation op : ops) {
            try (FileChannel f = FileChannel.open(file, StandardOpenOption.READ, StandardOpenOption.WRITE)) {  
    public void testBatchAddByteIdenticalToSingleAdds() throws IOException {
            assertNotNull(translogGeneration);  
        Translog.Delete delete = new Translog.Delete(eDelete, eDeleteResult);  
            }  
            Translog.Index test = new Translog.Index(  
            readers[i] = new Thread(new AbstractRunnable() {  
        }
                seqNo -> {},
            assertThat(stats.getTranslogSizeInBytes(), equalTo(328L));  
            IOUtils.close(translog);
                locations.add(location);  
                null
            translogUUID = Translog.createEmptyTranslog(
                for (int i = 0; i < opsAdded; i++) {
        TranslogConfig config = translog.getConfig();
                TranslogOperationHelper.DEFAULT,  
     * This test adds operations to the translog which might randomly throw an IOException. The only thing this test verifies is
            try (Translog.Snapshot snapshot = new TestTranslog.SortedSnapshot(translog.newSnapshot())) {
    public void testRecoverWithUnbackedNextGen() throws IOException {  
            StreamInput in = out.bytes().streamInput();
                    seqNo.getAndIncrement(),  
                translog.rollGeneration(); // empty generation
        );
                primaryTerm::get,
        private final Exception[] threadExceptions;
        Translog.Location max = locations.get(0);
            final Checkpoint writerCheckpoint = writer.getCheckpoint();
        }
                earliestLastModifiedAge = stats.getEarliestLastModifiedAge();  
                if (frequently()) {
    }
    public void testOldestEntryInSeconds() {  
                    assertEquals(i, Integer.parseInt(next.getSource().source.utf8ToString()));
        final TranslogConfig config = translog.getConfig();  
        final int generations = between(2, 20);
        }
                }
                TranslogOperationHelper.DEFAULT,
            Thread[] threads = new Thread[between(2, 8)];
        final TranslogDeletionPolicy deletionPolicy,
            newUid(doc),
                }  
                TranslogDeletionPolicy deletionPolicy,
                final boolean isCkpFile = file.getFileName().toString().endsWith(".ckp");
                            Integer.toString(opsSynced).getBytes(Charset.forName("UTF-8"))
                    throwUnknownException,
        globalCheckpoint.set(randomNonNegativeLong());
        try (  
                    "expected this to be the first roll (1 gen is on creation, 2 when opened)",  
            forwardConfig.getTranslogPath(),  
                null
                for (Translog.Location loc : locations) {
                    randomAlphaOfLength(10),
        }
import static org.opensearch.common.util.BigArrays.NON_RECYCLING_INSTANCE;  
        final int maxOps = randomIntBetween(200, 1000);  
        final List<FileChannel> fileChannels
            translog.add(new Translog.Index("1", 1, primaryTerm.get(), new byte[] { 1 }));  
                        case CREATE:
                generationUUID = Translog.createEmptyTranslog(
    /**
                    }  
            );  
            }  
                }  
        translog.close();  
            new LocalTranslog(  
            }  
    private void truncateTranslogs(Path directory) throws Exception {  
                @Override  
            // all is well
        long currentSeqNo = 0L;
                () -> SequenceNumbers.NO_OPS_PERFORMED,
import static org.hamcrest.Matchers.hasToString;
                () -> SequenceNumbers.NO_OPS_PERFORMED,
                        .ifPresent(source::set);  
        return b;
                        randomAlphaOfLength(10),
                    assertNotNull("operation " + i + " must be non-null synced: " + sync, next);
                translog.rollGeneration();
        );
        translog.close();
        final AtomicBoolean failedToSyncCheckpoint = new AtomicBoolean();
        for (int op = 0; op < translogOperations; op++) {  
                                }  
            translog.add(new Translog.Index("" + op, op, primaryTerm.get(), Integer.toString(op).getBytes(StandardCharsets.UTF_8)));
        long toSeqNo = Math.min(nextSeqNo - 1, fromSeqNo + 15);
        }  
                        assertThat(unsynced, empty());
                success = true;  
        int threadCount = 2 + randomInt(5);
        public int read(ByteBuffer dst) throws IOException {
            null
                }
        Engine.DeleteResult eDeleteResult = new Engine.DeleteResult(2, randomPrimaryTerm, randomSeqNum, true);
    @Override  
                    new Translog.Index("" + op, op, primaryTerm.get(), Integer.toString(++count).getBytes(Charset.forName("UTF-8")))
        TranslogConfig config = translog.getConfig();  
        try {
                        .reduce((a, b) -> b)
        boolean validPathString;  
     * from the transaction log.  
                Translog.Snapshot snapshot = translog.newSnapshot(localCheckpointOfSafeCommit + 1, Long.MAX_VALUE)
        assertFalse(translog.isOpen());  
                    }
            SequenceNumbers.UNASSIGNED_SEQ_NO,  
        final TranslogDeletionPolicy deletionPolicy = translog.getDeletionPolicy();
        int numOps = between(0, 10);
    public void testSnapshotFromStreamInput() throws IOException {
                    logger.info("--> [{}] min gen after acquiring lock [{}]", threadId, translog.getMinFileGeneration());
        downLatch.countDown();
                if (fail.fail()) {  
                        src.position(pos);
                success = true;
                        }
        Version wireVersion = VersionUtils.randomVersionBetween(random(), Version.CURRENT.minimumCompatibilityVersion(), Version.CURRENT);  
                ThrowingFileChannel throwingFileChannel = new ThrowingFileChannel(
            }
            threads[i].setDaemon(true);  
            assertThat(stats.getTranslogSizeInBytes(), equalTo(231L));
                }
                    null
                if ((threadExceptions[i] instanceof AlreadyClosedException) == false) {  
                assertEquals(  
            String generationUUID = null;
                } else {
        };
                }  
            assertThat(snapshot, SnapshotMatchers.equalsTo(ops));
                return lastGlobalCheckpoint.addAndGet(randomIntBetween(1, 100));  
                () -> SequenceNumbers.NO_OPS_PERFORMED,  
                Translog translog = new LocalTranslog(  
        List<Closeable> toClose = new ArrayList<>();
        final boolean throwUnknownException,  
                            primaryTerm.get(),
            }
    class TranslogThread extends Thread {
            };
                }  
                        // captures al views that are written since the view was created (with a small caveat see bellow)
            }
        }
                globalCheckpointSupplier,
                        unsynced.add(doc);
            assertThat(stats.estimatedNumberOfOperations(), equalTo(4));
        // we intentionally don't close the tlog that is in the prepareCommit stage since we try to recovery the uncommitted
                        expectedOps.removeIf(op -> op.seqNo() <= committedLocalCheckpointAtView);
    @Override
     * to clean up its files.  
                translog.getDeletionPolicy(),
                Exception e = new Exception("test tragic exception");  
                // expected
            BytesStreamOutput out = new BytesStreamOutput();
        int operationsInLastGen = 0;
            ByteBuffer buffer = ByteBuffer.allocate(4);  
            @Override
 * the Apache License, Version 2.0 (the "License"); you may
    /**
            assertThat(snapshot, containsOperationsInAnyOrder(latestOperations.values()));
import static org.hamcrest.Matchers.empty;  
            Phaser phaser = new Phaser(threads.length);  
                seqNos.add(seqNo);
    }  
            // 3. Read the on-disk write-generation file from each translog while both are still open (after sync).
            addToTranslogAndList(translog, ops, new Translog.Index("3", 2, primaryTerm.get(), new byte[] { 3 }));
            }
            // TODO once we have a mock FS that can simulate we can also fail on plain sync
                assertNotNull(translogGeneration.translogUUID);  
            writer.sync();  
                            failableTLog.sync();  
        TranslogStats stats = translog.stats();  
                            if (startBlocking.get()) {
        Files.createFile(config.getTranslogPath().resolve("translog-" + (read.generation + 1) + ".tlog"));
            randomSeqNum,
                // don't do partial writes for checkpoints we rely on the fact that the bytes are written as an atomic operation
                .uncommittedOperations(1)
        Document document = new Document();
            final long generation = translog.getMinGenerationForSeqNo(seqNo).translogFileGeneration;
                .map(t -> t.getPrimaryTerm())
                            return super.write(src);  
                }  
                primaryTerm.get(),  
            } catch (InvalidPathException ex) {
            () -> globalCheckpoint.get(),  
            assert old == null || old.primaryTerm() <= operation.primaryTerm();  
        translog.rollGeneration();
        views.push(new ArrayList<>());  
        } catch (AlreadyClosedException ex) {  
            try (Translog.Snapshot snapshot = translog.newSnapshot(minUncommittedOp, Long.MAX_VALUE)) {
                        assertThat(opCount, equalTo(checkpoint.numOps));
                assertFalse("the last call to ensureSycned synced all previous ops", translog.syncNeeded());
            );
            );
                        assertEquals(expIndexOp.source(), indexOp.source());
     */
                    seqNo -> {},
            temp.getShardId(),  
            }  
            try (  
        for (int i = 0; i < rolls; i++) {  
            translog.getDeletionPolicy().setLocalCheckpointOfSafeCommit(2);  
                    config,
        final List<Long> shuffledSeqNos = LongStream.range(0, operations).boxed().collect(Collectors.toList());
        );
        for (Translog.Operation op : ops) {  
                    case DELETE:
                        + 273
                @Override
            translog.trimUnreferencedReaders();
