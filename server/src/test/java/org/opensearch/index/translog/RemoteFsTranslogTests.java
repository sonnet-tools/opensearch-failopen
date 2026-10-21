                seqNos.add(seqNo);
            RemoteTranslogTransferTracker statsTracker = translog.getRemoteTranslogTracker();
    public void setUp() throws Exception {
        assertThat(translog.totalOperations(), equalTo(operations.size()));
        assertBusy(() -> assertEquals(2 + 2L * moreDocs, translog.allUploaded().size()));
            List<Translog.Operation> ops = new ArrayList<>(seqNos.size());
                } else {
                // synced so far; capture it before closeIntoReader folds the footer bytes into the writer's checksum.
            }
                fail("read past EOF?");
            for (int op = 0; op < translogOperations; op++) {
    private BlobStoreRepository createIsolatedRepository() {
import static org.mockito.ArgumentMatchers.anyBoolean;
        if (reader instanceof TranslogReader) {
            if (randomBoolean()) {
            assertTrue(e.getMessage().contains("Not all operations between from_seqno"));
                        // slow down things a bit and spread out testing..
            if (slowDown.getSleepSeconds() > 0) {
        locs.add(addToTranslogAndListAndUpload(translog, ops, new Translog.Index("2", 1, primaryTerm.get(), new byte[] { 1 })));
        final AtomicLong idGenerator = new AtomicLong();
            assertEquals(op, translog.readOperation(locs.get(i++)));
        long nextSeqNo = populateTranslogOps(true);
        public ThrowingBlobRepository(
                            case CREATE:
                new RemoteTranslogTransferTracker(shardId, 10),
            primaryMode::get,
            false
        long maxSeqNo = SequenceNumbers.NO_OPS_PERFORMED;
        );
                    listener.onFailure(new RuntimeException(e));
                                expectedOps.remove(op);
            .add(String.valueOf(shardId.id()))
        long newGlobalCheckpoint = 1L;
        RemoteFsTranslog.download(mockTransfer, location, logger, false, 0);
        String created = new String(
        ArrayList<Translog.Location> locs = new ArrayList<>();
import org.opensearch.common.util.io.IOUtils;
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index(String.valueOf(3), 3, primaryTerm.get(), new byte[] { 1 }));
            AtomicLong seqNoGenerator,
                writtenOperations,
            IOUtils.closeWhileHandlingException(toClose);
                if (success == false) {
            BlobPath blobPath,
    protected ChannelFactory getChannelFactory() {
        assertBusy(() -> assertEquals(4, translog.allUploaded().size()));
        translog.trimUnreferencedReaders();
            assertEquals(0, statsTracker.getTotalUploadsFailed());
import org.opensearch.test.OpenSearchTestCase;
                                op = new Translog.Delete(Long.toString(id), id, primaryTerm.get());
            shardId,
            assertThat(snapshot2.totalOperations(), equalTo(ops.size()));
            long seqNo;
    }
                        @Override
            slowDown
        for (Thread thread : readers) {
            assertThat(snapshot, containsOperationsInAnyOrder(ops));
        when(mockTransfer.readMetadata(0)).thenReturn(translogTransferMetadata);
        );
    }
import org.opensearch.common.settings.Settings;
                    assertNull(reader.getTranslogChecksum());
            .build();
    private TranslogConfig getTranslogConfig(final Path path, final Settings settings) {
        Files.write(location.resolve(Translog.CHECKPOINT_FILE_NAME), randomByteArrayOfLength(randomIntBetween(8, 32)));
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
        }
            }
    public void testTranslogWriter() throws IOException {
            assertThat(snapshot, SnapshotMatchers.equalsTo(ops));
                                // we need not do this concurrently as we need to make sure that the generation
            assertThat(snapshot.totalOperations(), equalTo(ops.size()));
        long maxSeqNo = SequenceNumbers.NO_OPS_PERFORMED;
        Path location = createTempDir();
        String translogUUID = Translog.createEmptyTranslog(
     * {@code location}, exactly as {@link TranslogWriter#closeIntoReader()} would leave them. Returns the
            try {
        // a map of all written ops and their returned location.
            assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
                new RemoteStorePathStrategy(RemoteStoreEnums.PathType.FIXED),
            Path checkpointPath = translog.location().resolve(Translog.getCommitCheckpointFileName(readerGeneration));
            ) {
            String sealed = new String(
            ArrayList<Translog.Operation> ops = new ArrayList<>();
                assertArrayEquals(tlog, content);
            }
        when(mockTransfer.getRemoteTranslogTransferTracker()).thenReturn(remoteTranslogTransferTracker);
                    true,
            // Trims from remote now
        TranslogTransferManager mockTransfer = mockTransferManagerFor(metadataFor(1, 2, Map.of(1L, checksum1, 2L, 5678L)));
        return create(path, repository, translogUUID, 0, isServerSideEncryptionEnabled);
            TestTranslog.SlowDownWriteSwitch slowDown
        }
        Path damagedPath = location.resolve(Translog.getFilename(Long.parseLong(damaged)));
         * Test support only. {@link FsBlobContainer} reports {@code false} because its conditional write is emulated per
            try {
        // Increase primary term
        assertTrue(statsTracker.getTotalDownloadsSucceeded() > 0);
                }
                            throw new AssertionError("unsupported operation type [" + type + "]");
                assertFalse("no sync needed since no operations in current translog", translog.syncNeeded());
        translog.trimUnreferencedReaders();
            if (firstGenOps == null) {
        verify(manager).downloadTranslog(any(), Mockito.eq(damaged), any());
                fail.failAlways();
                downLatch,
            assertThat(snapshot.totalOperations(), equalTo(ops.size()));
        RemoteTranslogTransferTracker statsTracker = translog.getRemoteTranslogTracker();
        List<Translog.Operation> firstGenOps = null;
    public void testDownloadWithNoTranslogInLocalAndRemote() throws IOException {
            // expose the new checkpoint (simulating a commit), before we trim the translog
            assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
            RepositoryMetadata metadata,
        locs.add(addToTranslogAndListAndUpload(translog, ops, new Translog.Index("3", 2, primaryTerm.get(), new byte[] { 1 })));
    @Override
                final byte[] bytes = new byte[4];
            .add(TRANSLOG.getName())
                DefaultRemoteStoreSettings.INSTANCE,
    }
            }
        List<Translog.Operation> opsList = new ArrayList<>(threadCount * opsPerThread);
        Path tempDir = createTempDir();
            translog.setMinSeqNoToKeep(2);
            }
        assertBusy(() -> assertEquals(1, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size()));
        final long seqNo = randomLongBetween(0, Integer.MAX_VALUE);
        });
        private final TestTranslog.FailSwitch fail;
        assertTrue(statsTracker.getUploadBytesSucceeded() > 0);
            } catch (IOException e) {
    }
        }
    }
            DefaultRemoteStoreSettings.INSTANCE,
    private class ThrowingBlobContainer extends FsBlobContainer {
    private static void assertDownloadStatsPopulated(RemoteTranslogTransferTracker statsTracker) {
            newTranslog.setMinSeqNoToKeep(i);
                writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), randomNonNegativeLong());
                }
        }
            threads[i].setDaemon(true);
        assertEquals(0, statsTracker.getDownloadBytesSucceeded());
            addToTranslogAndListAndUpload(translog, ops, new Translog.Index("3", 2, primaryTerm.get(), new byte[] { 1 }));
        public void listBlobsByPrefixInSortedOrder(
import java.nio.file.NoSuchFileException;
        assertEquals(1, downloadCounter.get());
 *
                threadPool,
                                // we're committing - is still present when we're committing
            );
        throws IOException {
                maxOp = next;
        logger.debug("--> waiting for readers to stop");
        for (int i = 0; i < iters; i++) {
    }
                // The footer must live past the checkpoint offset so that pre-footer readers never see it.
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 4);
                        assertEquals(op, translog.readOperation(loc));
    protected LongConsumer getPersistedSeqNoConsumer() {
        threadPool = new TestThreadPool(getClass().getName());
        long toSeqNo = Math.min(nextSeqNo - 1, fromSeqNo + 15);
        final Set<Long> persistedSeqNos = new HashSet<>();
                RemoteTranslogTransferTracker statsTracker = translog.getRemoteTranslogTracker();
        final Map<Translog.Operation, Translog.Location> writtenOps = ConcurrentCollections.newConcurrentMap();
        // createRepository() rebinds the shared fail/slowDown switches; keep the ones the setUp translog observes.
        Path path,
    /**
            translogUUID,
    public void testTranslogWriterCanFlushInAddOrReadCall() throws IOException {
    }
                }
        for (int gen = 0; gen < generations; gen++) {
                try {
        Path location = createTempDir();
        final TranslogDeletionPolicy deletionPolicy = createTranslogDeletionPolicy(translogConfig.getIndexSettings());
                                randomUnicodeOfLengthBetween(1, 20 * 1024).getBytes("UTF-8")
        return fencedRepository.basePath()
    protected final AtomicBoolean primaryMode = new AtomicBoolean(true);
        assertUploadStatsNoFailures(statsTracker);
        RemoteFsTranslog.download(mockTransfer, location, logger, false, 0);
        });
    }
    }
        thread1.start();
    }
        RemoteFsTranslog newTranslog = create(translogDir, repository, translogUUID, false);
        fromSeqNo = randomLongBetween(0, 2000);
            );
            newTranslog.trimUnreferencedReaders();
            SequenceNumbers.NO_OPS_PERFORMED,
                assertFalse("this op has been synced before", translog.ensureSynced(location)); // not syncing now
                threadExceptions[threadId] = t;
import org.opensearch.core.util.FileSystemUtils;
     */
        } else {
                () -> RemoteFsTranslog.sealFence(
        RemoteFsTranslog.download(mockTransfer, location, logger, false, 0);
                channelFactory,
    // No translog data in remote but non-empty translog is present in local. In this case, we delete all the files
                TranslogOperationHelper.DEFAULT,
                }
            Translog translog,
            Path translogPath = reader.path();
                && newEmptyTranslogCheckpoint.minSeqNo == SequenceNumbers.NO_OPS_PERFORMED
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(
        );
        }
        );
            fencedRepository,
        assertEquals(0, statsTracker.getTotalUploadsStarted());
            ActionListener<List<BlobMetadata>> listener
import org.opensearch.common.settings.ClusterSettings;
                // Will flush on read
                        case CREATE:
                new DefaultTranslogDeletionPolicy(-1, -1, 0),
        final long noopTerm = randomLongBetween(1, primaryTerm.get());
                DefaultRemoteStoreSettings.INSTANCE,
    }
            addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
                    fail("io exception expected");
        Files.createFile(location.resolve(Translog.CHECKPOINT_FILE_NAME));
                        closeRetentionLock();
    @Override
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
        }
        try (
import org.opensearch.index.remote.RemoteStorePathStrategy;
                                primaryTerm.get(),
            translog.getDeletionPolicy().assertNoOpenTranslogRefs();
        String translogUUID = Translog.createEmptyTranslog(
        opsList.sort(Comparator.comparing(op -> op.seqNo()));
            when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(fsContainer);
        assertEquals(0, statsTracker.getTotalUploadsFailed());
    protected TranslogConfig getConfig(int gensToKeep) {
        RemoteTranslogTransferTracker remoteTranslogTransferTracker = mock(RemoteTranslogTransferTracker.class);
            }
                if (randomBoolean()) {
            int initialWriteCalls = writeCalls.get();
        Thread[] threads = new Thread[threadCount];
    }
        translog.close();
        RemoteTranslogTransferTracker statsTracker = translog.getRemoteTranslogTracker();
        assertTrue(translog.syncNeeded());
        assertEquals(newEmptyTranslogCheckpoint.globalCheckpoint, existingCheckpoint.globalCheckpoint);
        when(mockTransfer.readMetadata()).thenReturn(null);
            int numOps = randomIntBetween(1, 100);
                                threadId + "_" + opCount,
        assertTrue(
            fenced.add(new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
import org.opensearch.threadpool.TestThreadPool;
        TranslogTransferMetadata metadata = new TranslogTransferMetadata(
        assertTrue(locations[0].compareTo(locations[1]) < 0);
        translogTransferMetadata.setGenerationToChecksumMapper(generationToChecksumMapper);
            if (randomBoolean()) {
        final long maxSeqNo = seenSeqNos.stream().max(Long::compareTo).orElse(SequenceNumbers.NO_OPS_PERFORMED);
            try {
                        synchronized (signalReaderSomeDataWasIndexed) {
    }
        RemoteFsTranslog.download(manager, location, logger, false, 0);
            locations.add(
            if (rarely()) {
                                translog.trimUnreferencedReaders();
        TranslogTransferManager mockTransfer = mock(TranslogTransferManager.class);
        final String reason = randomAlphaOfLength(16);
    private Long populateTranslogOps(boolean withMissingOps) throws IOException {
        return metadata;
            new ByteSizeValue(8, ByteSizeUnit.KB),
import org.opensearch.index.seqno.SequenceNumbers;
    private TranslogConfig getTranslogConfig(final Path path, final Settings settings, final String nodeId) {
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
        // Every generation closed by a writer carries a footer and therefore advertises a checksum. The only
        final TranslogDeletionPolicy deletionPolicy = translog.getDeletionPolicy();
        assertTrue(statsTracker.getLastSuccessfulDownloadTimestamp() > 0);
            .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
                            acquireRetentionLock();
                byte[] content = stream.readAllBytes();
        }
                new RemoteTranslogTransferTracker(shardId, 10),
        Settings settings = Settings.builder().put("location", randomAlphaOfLength(10)).build();
        RemoteFsTranslog incumbent = createFencedTranslog("node-old", fencedRepository);
    public void testBuildTranslogTransferManagerRejectsRepositoryWithoutConditionalWrites() {
    BlobStoreRepository repository;
            fail = currentFail;
        byte[] bytes = new byte[4];
 * The OpenSearch Contributors require contributions made to
            } catch (IOException ex) {
                }
                InputStream stream = new CheckedInputStream(Files.newInputStream(translogPath), new CRC32());
        long toSeqNo = randomLongBetween(fromSeqNo, Long.MAX_VALUE);
        ) {
                    // whole-file checksum.
            long toSeqNo = randomLongBetween(fromSeqNo, minSeqNo - 1);
                repository,
                        }
            createEnvironment(),
        slowDown.setSleepSeconds(2);
    }
        }
                TranslogOperationHelper.DEFAULT,
            StandardCharsets.UTF_8
            addToTranslogAndListAndUpload(newTranslog, ops, new Translog.Index(String.valueOf(i), i, primaryTerm.get(), new byte[] { 1 }));
import org.opensearch.cluster.metadata.RepositoryMetadata;
    }
            assertThat(snapshot2, containsOperationsInAnyOrder(ops));
            IllegalArgumentException.class,
            }
import java.util.Collections;
            : translog.openReader(writer.path(), Checkpoint.read(translog.location().resolve(Translog.CHECKPOINT_FILE_NAME)));
        long nextSeqNo = populateTranslogOps(false);
        for (int i = 0; i < numOps; i++) {
                IllegalArgumentException.class,
    public void testIncrementalDownloadFetchesOnlyMissingGenerations() throws IOException {
                )
            BlobContainer fenceContainer = fencedRepository.blobStore().blobContainer(fenceDirectory(fencedRepository));
    }
        }
            threadPool,
        }
            throw new RuntimeException(e);
         * {@code FsBlobContainer} is still rejected.
                DefaultRemoteStoreSettings.INSTANCE,
    private BlobPath fenceDirectory(BlobStoreRepository fencedRepository) {
                    }
                            fail("duplicate op [" + op + "], old entry at " + location);
        assertEquals(1, translog.readers.size());
        String translogUUID,
        }
                TranslogOperationHelper.DEFAULT,
            deletionPolicy,
                    IOUtils.closeWhileHandlingException(delegate);
                () -> SequenceNumbers.NO_OPS_PERFORMED,
        long newPrimaryTerm = primaryTerm.incrementAndGet();
                // Since the buffer is full, this will flush before performing the add.
                            if (failed) {
    public void testBatchedAddAndRemoteSync() throws IOException {
                    }
        assertThat(locations.length, equalTo(operations.size()));
    }
        // download first time will ensure creating empty translog
                throw new AssertionError(e);
        // if a previous test failed we clean up things here
        BlobStoreRepository repository,
            List<Translog.Operation> expectedOps = new ArrayList<>();
     * previous remote state; a successful download recreates it from the latest generation's checkpoint.
                        if (id % writers.length == threadId) {
        // Case 4 - After drainSync, if an upload is an attempted, we do not upload to remote store.
                            return super.write(src);
    /**
        BlobStoreRepository freshRepository = createIsolatedRepository();
                    new Translog.Index("" + op, op, primaryTerm.get(), Integer.toString(++count).getBytes(Charset.forName("UTF-8")))
            try {
            NamedXContentRegistry namedXContentRegistry,
        String translogUUID = Translog.createEmptyTranslog(path, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
                } catch (InterruptedException e) {
import org.opensearch.cluster.metadata.IndexMetadata;
        }
            if (rarely()) {
    private RemoteFsTranslog createFencedTranslog(String nodeId, BlobStoreRepository fencedRepository) throws IOException {
            Translog.Snapshot snapshot2 = translog.newSnapshot();
                // Reading at or past the checkpoint offset is EOF: the footer is not addressable through the reader.
                            Translog.Operation op;
import org.opensearch.threadpool.ThreadPool;
     * Files outside the remote generation range, and files that are not translog files at all, are removed before
        assertTrue(translog.syncNeeded());
                translogUUID,
        long fromSeqNo = 0L;
                void acquireRetentionLock() throws IOException {
        return TestTranslog.createTranslogGeneration(random(), location, generation, true);
import org.opensearch.index.translog.transfer.RemoteStoreFence;
                        }
        translog.close();
     * Creates a second translog instance for the same shard, on its own repository, with remote store fencing
        assertDownloadStatsNoDownloads(statsTracker);
        metadata.setGenerationToPrimaryTermMapper(generationToPrimaryTermMapper);
    }
        when(mockTransfer.getRemoteTranslogTransferTracker()).thenReturn(remoteTranslogTransferTracker);
                }
        createTranslogGeneration(location, 1);
        assertEquals(2, translog.readers.size());
            }
        } finally {
import static org.hamcrest.Matchers.containsString;
            }
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("2", 2, primaryTerm.get(), new byte[] { 1 }));
        int i = 0;
        CRC32 crc = new CRC32();
            when(emulatedRepository.basePath()).thenReturn(BlobPath.cleanPath());
        try (Translog.Snapshot snapshot = translog.newSnapshot(fromSeqNo, toSeqNo)) {
                reader.readBytes(buffer, reader.getFirstOperationOffset() + 4 * numOps);
        Map<Long, List<Translog.Operation>> operationsByGen = new HashMap<>();
        ArrayList<Translog.Operation> ops = new ArrayList<>();
public class RemoteFsTranslogTests extends OpenSearchTestCase {
    }
            }
            for (long seqNo : seqNos) {
    }
        translog.trimUnreferencedReaders();
                    int counter = 0;
            assertThat(TestTranslog.drainSnapshot(snapshot, false), equalTo(expectedOps));
                translog.ensureSynced(location);
            TranslogConfig.DEFAULT_BUFFER_SIZE,
            buffer.flip();
            String afterFirstContent = new String(afterFirst.content(), StandardCharsets.UTF_8);
        translog.sync();
        assertBusy(() -> {
        }
            }
            }
        // Case 2 - During an upload, if drainSync is called, it will wait for it to acquire and available permits are 0.
            assertEquals(2, checkpointFsyncCalls.get());
        when(mockTransfer.downloadTranslogIfChanged(any(), any(), any(), any())).thenThrow(new NoSuchFileException("File not found"));
                if (success == false) {
        private final Translog translog;
            ops,
        final Settings settings = Settings.builder()
        locs.add(addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 })));
                    errors.add(e);
            int threadId,
        TranslogTransferManager mockTransfer = mockTransferManagerFor(metadataFor(2, 2, Map.of(2L, checksum2)));
        when(mockTransfer.readMetadata()).thenReturn(null);
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
                // we are the last location so everything should be synced
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
        // Add a new operation and sync
        downLatch.countDown();
     */
import org.opensearch.common.util.concurrent.ConcurrentCollections;
        long minGeneration = remoteMetadata.getMinTranslogGeneration();
        return mockTransfer;
        for (int i = 0; i < numDocs; i++) {
    public void testUploadWithPrimaryModeTrue() {
                persistedSeqNos::add,
            } else if (rarely()) {
        // simulating the remote segment upload .
/*
                assertFalse("location is from a previous translog - already synced", translog.ensureSynced(location)); // not syncing now
            "",
                        if (iter++ % 10 == 0) {
        Set<String> mdFiles = blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR));
            assertNotEquals(afterFirst.versionToken(), afterSecond.versionToken());
    }
        throws IOException {
        Set<String> withChecksum = remoteMetadata.getGenerationToChecksumMapper().keySet();
        persistedSeqNoConsumer.set(persistedSeqNos::add);
    }
                new RemoteTranslogTransferTracker(shardId, 10),
    // No translog data in local as well as remote, we skip creating empty translog
            return location;
            Collections.shuffle(seqNos, new Random(100));
        return new RemoteFsTranslog(
            } catch (EOFException ex) {
            }
        protected Translog.Location add(Translog.Operation op) throws IOException {
        translog = create(translogDir);
            assertEquals(1, translog.readers.size());
            translog.close();
            assertTrue(statsTracker.getTotalUploadsFailed() > 0);
            } catch (TranslogUploadFailedException e) {
        try (Translog.Snapshot snapshot = translog.newSnapshot(fromSeqNo, toSeqNo)) {
        // assertTrue(statsTracker.getTotalDownloadTimeInMillis() > 0);
            operationsByGen.put(translog.currentFileGeneration(), ops);
     */
    public void testReadLocationDownload() throws IOException {
            fenced.sync();
        try (RemoteFsTranslog incumbent = createFencedTranslog("node-current", fencedRepository)) {
                    errors.add(e);
            TranslogReader reader = writer.closeIntoReader();
            assertThat(persistedSeqNos, empty());
        }
                4,
                                lastCommittedLocalCheckpoint.set(localCheckpoint);
                repository,
        TranslogConfig translogConfig,
        int newPrimaryTermDocs = randomIntBetween(5, 10);
    TestTranslog.FailSwitch fail;
                seqNo = ++count;
    private long createTranslogGeneration(Path location, long generation) throws IOException {
                    throw new RuntimeException(e);
        // A failing download has already removed the stale checkpoint.
        fail.failAlways();
                } else {
            terminate(threadPool);
            translog.trimUnreferencedReaders();
                    Thread.sleep(slowDown.getSleepSeconds() * 1000L);
        }
        Collections.shuffle(locations, random());
                    closeRetentionLock();
                        // these are what we expect the snapshot to return (and potentially some more).
                    logger.error(() -> new ParameterizedMessage("--> writer [{}] had an error", threadName), e);
                        case NO_OP:
        assertFalse(container.isConditionalWriteSupported());
            fenced.add(new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
            getPersistedSeqNoConsumer(),
    public void testRepeatedDownloadReusesLocalGenerations() throws IOException {
            IllegalStateException.class,
                                long localCheckpoint = tracker.getProcessedCheckpoint();
                    logger.error(() -> new ParameterizedMessage("--> reader [{}] had an error", threadId), e);
            Translog translog = new RemoteFsTranslog(
        private final TestTranslog.SlowDownWriteSwitch slowDown;
            );
                4,
                success = true;
        }
    public void testFencingEnabledUploadIsFencedByASecondWriter() throws Exception {
        long checksum1 = createTranslogGeneration(location, 1);
            }
                null,
                    // A re-opened reader recovers the content checksum from the footer but cannot know the
            } catch (Exception e) {
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
import java.util.Arrays;
import org.opensearch.repositories.fs.FsRepository;
        BlobStoreRepository fencedRepository = createIsolatedRepository();
    }
        );
        return new RemoteFsTranslog(
        } finally {
            Environment environment,
            throws IOException {
     * The local-filesystem container <em>implements</em> conditional writes, but only emulates the precondition within a
            temp.getShardId(),
        assertEquals(1 + moreDocs, translog.readers.size());
            assertEquals(initialWriteCalls, writeCalls.get());
    public void testFullRangeSnapshot() throws Exception {
                // eliminate thread name check as we create repo manually
            int translogOperations = randomIntBetween(10, 100);
                footerBuffer.flip();
        // This should trim tlog-2 from local
        assertUploadStatsNoUploads(statsTracker);
import org.opensearch.index.remote.RemoteTranslogTransferTracker;
            new RemoteTranslogTransferTracker(shardId, 10),
                if (isCkpFile) {
            assertTrue(sealed, sealed.contains("|" + (primaryTerm.get() + 1) + "|" + allocationIdOf("node-new") + "|node-new|"));
                    logger.info("--> [{}] done. wrote [{}] ops.", threadName, counter);
                            );
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 1, primaryTerm.get(), new byte[] { 1 }));
        int totalDocs = numDocs + moreDocs;
import org.opensearch.index.IndexSettings;
        Random random = random();
                fencedRepository,
        TranslogDeletionPolicy deletionPolicy,
            if (slowDown.getSleepSeconds() > 0) {
                        switch (type) {
            this.writtenOperations = writtenOperations;
                public void onFailure(Exception e) {
import org.opensearch.common.blobstore.BlobStore;
        }
        assertEquals(4, translog.allUploaded().size());
    }
            fenced.sync();
            DefaultRemoteStoreSettings.INSTANCE,
import org.opensearch.indices.recovery.RecoverySettings;
        }
            ByteBuffer buffer = ByteBuffer.allocate(4);
        assertFalse(withChecksum.isEmpty());
        fail = new TestTranslog.FailSwitch();
            writers[i] = new Thread(new AbstractRunnable() {
        for (int i = 0; i < numOps; i++) {
            this.slowDown = slowDown;
        logger.info("using [{}] readers. [{}] writers. flushing every ~[{}] ops.", readers.length, writers.length, flushEveryOps);
        assertThat(persistedSeqNos, empty());
            );
            int bufferSizeInBytes,
                    Translog.Operation op;
                            case DELETE:
        byte[] bytes = Files.readAllBytes(path);
}
        TranslogDeletionPolicy deletionPolicy = createTranslogDeletionPolicy(config.getIndexSettings());
            assertThat(snapshot.totalOperations(), equalTo(0));
        int threadCount = 2 + randomInt(5);
            assertThat(persistedSeqNos, contains(1L, 2L, 3L, 4L));
                                op = new Translog.Index("" + id, id, primaryTerm.get(), new byte[] { (byte) id });
                            op = new Translog.Delete(
    }
        // force stopping, if all writers crashed
import static org.hamcrest.Matchers.contains;
            boolean readonly,
                    retentionLock = translog.acquireRetentionLock();
                    new Translog.Index("" + op, seqNo, primaryTerm.get(), Integer.toString(seqNo).getBytes(Charset.forName("UTF-8")))
            return new ThrowingBlobStore(bufferSize, locationFile, isReadOnly(), fail, slowDown);
                        public int write(ByteBuffer src) throws IOException {
            return createRepository();
                    final int value = buffer.getInt();
        List<TestTranslog.LocationOperation> collect = new ArrayList<>(writtenOperations);
                translog.ensureSynced(locations.get(op));
import org.opensearch.env.Environment;
            assertTrue(fenceContainer.listBlobs().containsKey(RemoteStoreFence.fenceBlobName(primaryTerm.get())));
                translog.ensureSynced(location);
        translog.sync();
            BlobStore blobStore = mock(BlobStore.class);
            }
        TranslogTransferMetadata inverted = new TranslogTransferMetadata(1, 3, 5, 0);
            // newTranslog.deletionPolicy.setLocalCheckpointOfSafeCommit(i - 1);
        long newGlobalCheckpoint = 2L;
    public void testSimpleOperations() throws IOException {
            );
            assertFalse("all of the locations should be synced: " + location, translog.ensureSynced(location));
            toClose.add(snapshot);
        RemoteFsTranslog.download(mockTransfer, location, logger, false, 0);
        ArrayList<Translog.Operation> ops = new ArrayList<>();
                        public void force(boolean metaData) throws IOException {
        }
            // Trims from local
        final AtomicInteger checkpointFsyncCalls = new AtomicInteger();
        for (int i = 0; i < threadCount * opsPerThread; i++) {
                            default:
                        if (id % 7 == 0) {
                    if (rarely()) { // lets verify we can concurrently read this
            this.opsPerThread = opsPerThread;
        translog.trimUnreferencedReaders();
        assertEquals(2, translog.readers.size());
        } catch (MissingHistoryOperationsException e) {
        // this should now trim as tlog-2 files from remote, but not tlog-3 and tlog-4
            .add(shardId.getIndex().getUUID())
    }
        BlobContainer fenceContainer = freshRepository.blobStore().blobContainer(fenceDirectory(freshRepository));
            long fromSeqNo = randomLongBetween(0, minSeqNo - 1);
        long currentSeqNo = 0L;
            out.writeInt(i);
        final Object flushMutex = new Object();
            assertUploadStatsNoFailures(statsTracker);
                    if (fromSeqNo <= op.seqNo() && op.seqNo() <= toSeqNo && seenSeqNos.add(op.seqNo())) {
        for (int i = numDocs; i < numDocs + moreDocs; i++) {
        List<Translog.Operation> operations = List.of(
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 4);
        assertEquals(1, translog.readers.size());
            final long pos = reader.getFirstOperationOffset() + 4 * numOps;
                                // deletionPolicy.setLocalCheckpointOfSafeCommit(localCheckpoint);
import org.opensearch.common.lease.Releasable;
        Set<String> remaining = Arrays.stream(FileSystemUtils.files(location))
                InputStream tlogStream = blobStoreTransferService.downloadBlob(path, Translog.getFilename(readerGeneration));
                config,
        final AtomicBoolean run = new AtomicBoolean(true);
        assertThat(reader.getCheckpoint().minSeqNo, equalTo(minSeqNo));
        assertBusy(() -> assertEquals(1, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size()));
            null,
                if (rarely()) {
        }
            incumbent.add(new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
            downloadCounter.incrementAndGet();
            writer.sync();
import java.util.Set;
        final ChannelFactory channelFactory = (file, openOption) -> {
                    barrier.await();
    /**
        primaryTerm.set(randomLongBetween(1, Integer.MAX_VALUE));
        TranslogTransferManager manager = Mockito.spy(translog.translogTransferManager);
                    };
            String blobNamePrefix,
                expectedContentChecksum = Long.valueOf(checksumOf(writer.path(), syncedCheckpoint.offset));
        // Always File not found
        verify(mockTransfer, times(0)).downloadTranslog(any(), any(), any());
        globalCheckpoint.set(initialGlobalCheckpoint);
                .build()
    }
                            break;
                return new ThrowingBlobContainer(this, path, buildAndCreate(path), fail, slowDown);
        translog.trimUnreferencedReaders();
        final int generations = between(2, 20);
            }
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
        String msg = "File not found";
        // Change primary term and test the deletion of older primaries
                throw new NoSuchFileException("File not found");
import org.opensearch.index.translog.transfer.FileTransferTracker;
        long fromSeqNo = randomLongBetween(maxSeqNo + 1, Long.MAX_VALUE);
        final LocalCheckpointTracker tracker = LocalCheckpointTrackerTests.createEmptyTracker();
        locs.add(addToTranslogAndList(translog, ops, new Translog.Index("3", 2, primaryTerm.get(), new byte[] { 1 })));
        assertTrue(statsTracker.getUploadBytesStarted() > 0);
        globalCheckpoint.set(newGlobalCheckpoint);
    }
    /**
        // Validate
        RemoteTranslogTransferTracker statsTracker = translog.getRemoteTranslogTracker();
            xContentRegistry(),
        try {
            byte[] bytes = new byte[4];
        for (int op = 0; op < translogOperations; op++) {
        }
        assertEquals(1, translog.readers.size());
            } finally {
        long toSeqNo = Math.min(nextSeqNo - 1, fromSeqNo + 15);
        assertEquals(0, statsTracker.getTotalUploadsSucceeded());
import org.opensearch.common.blobstore.VersionedBlob;
        int extraGenToKeep,
import java.util.ArrayList;
            Files.copy(file, location.resolve(file.getFileName()));
import static org.hamcrest.Matchers.empty;
        assertEquals(0, statsTracker.getUploadBytesStarted());
        @Override
                latch.countDown();
            threads[i] = new TranslogThread(
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
            expectThrows(
        doAnswer(invocation -> {
        int remoteGenerations = Math.toIntExact(maxGeneration - minGeneration + 1);
            List<Long> seqNos = new ArrayList<>();
                assertFalse("no sync needed since no operations in current translog", translog.syncNeeded());
        boolean isServerSideEncryptionEnabled
            throws IOException {
        assertEquals(6, translog.allUploaded().size());
        // Set initial global checkpoint
                                // expose the new checkpoint (simulating a commit), before we trim the translog
            assertThat(snapshot.totalOperations(), equalTo(0));
                totOps++;
        verify(mockTransfer, times(0)).downloadTranslogIfChanged(any(), any(), any(), any());
                        final Translog.Operation.Type type = Translog.Operation.Type.values()[((int) (id % Translog.Operation.Type
        RemoteFsTranslog.download(finalMockTransfer, location, logger, false, 0);
            {
            new RemoteTranslogTransferTracker(shardId, 10),
                assertEquals(2, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());
        final BaseTranslogReader reader = randomBoolean()
            getPersistedSeqNoConsumer(),
                }
                totOps++;
     * The recovery seal: a copy taking over claims the chain before it reads its restore point, which invalidates the
                Closeable retentionLock = null;
                withoutChecksum.add(String.valueOf(g));
            translog,
                translog.add(
        // Refill the permits back
            // Fencing is fatal for the shard copy: the translog is marked with a tragic event
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
            int numOps = randomIntBetween(4, 10);
            for (int i = 0; i < numOps; i++, currentSeqNo++) {
     * the metadata. Corrupting one local generation makes exactly that generation download again.
    public void testSyncUpTo() throws IOException {
        Path location = createTempDir();
    }
import org.apache.lucene.backward_codecs.store.EndiannessReverserUtil;
            translog.trimUnreferencedReaders();
        for (int i = 0; i < readers.length; i++) {
import java.util.concurrent.CountDownLatch;
        Path[] filesPostDownload = FileSystemUtils.files(location);
    public void testFullRangeSnapshotWithFailures() throws Exception {
        for (TranslogReader reader : translog.readers) {
        for (Translog.Location location : locations) {
        private final TestTranslog.FailSwitch fail;
        expectThrows(IOException.class, () -> RemoteFsTranslog.download(failing, location, logger, false, 0));
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
        // clean up
            false
            protected void assertSnapshotOrGenericThread() {
        TranslogConfig config = getConfig(1);
        );
        String damaged = randomFrom(new ArrayList<>(withChecksum));
            boolean success = false;
                                missed.append("\n --> [").append(expectedOp).append("] written at ").append(loc);
        final TranslogConfig temp = getTranslogConfig(tempDir, gensToKeep);
        doAnswer(invocation -> {
        return create(path, createRepository(), translogUUID, 0, false);
                    reader = translog.openReader(reader.path(), writerCheckpoint);
        }
     */
            this.environment = environment;
            translog.sync();
import java.util.zip.CRC32;
                    Translog.Location loc = add(op);
                        long id = idGenerator.getAndIncrement();
    private RemoteFsTranslog create(
import org.opensearch.core.common.unit.ByteSizeUnit;
            int totOps = 0;
                final FileChannel channel;
            // we can remove this try-catch block
        /**
        TranslogTransferManager finalMockTransfer = mockTransfer;
        for (int i = 0; i < threadCount; i++) {
    private TranslogConfig getTranslogConfig(final Path path, int gensToKeep) {
        long maxGeneration = remoteMetadata.getGeneration();
import java.util.function.LongConsumer;
        assertTrue(statsTracker.getTotalUploadsSucceeded() > 0);
import java.util.HashSet;
            // The incumbent now holds a stale token and cannot acknowledge another write
        // without a writer and is re-downloaded every time (it is header-only, a few dozen bytes).
        translogDir = createTempDir();
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            assertNotNull(maxOp);
import java.util.concurrent.atomic.AtomicReference;
        }
        }
                        inner.addSuppressed(e);
    protected AtomicLong globalCheckpoint;
        };
    }
     * instance for the same shard id does not collide with it on remote paths.
        // To simulate that the node is remote backed
            try {
            assertFalse("emulated conditional writes must not be advertised as supported", fsContainer.isConditionalWriteSupported());
        int translogOperations = randomIntBetween(10, 100);
        public boolean isConditionalWriteSupported() {
        final int flushEveryOps = randomIntBetween(5, 10);
                shardId,
        for (Path file : FileSystemUtils.files(translogDir)) {
                byte[] ckp = ckpStream.readAllBytes();
            slowDown = currentSlowDown;
            // A copy recovering at a higher term seals before reading its restore point
            assertEquals(i, value);
        return repository;
        TranslogTransferManager mockTransfer = mock(TranslogTransferManager.class);
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
        assertTrue(statsTracker.getDownloadBytesSucceeded() > 0);
            buffer.flip();
                    }
            shardId,
    public void testIncrementalDownloadSkipsMatchingGeneration() throws IOException {
            addToTranslogAndListAndUpload(translog, ops, new Translog.Index("4", 3, primaryTerm.get(), new byte[] { 1 }));
            Set<Long> seqNos = new HashSet<>();
            Math.toIntExact(maxGeneration - minGeneration + 1)
            assertEquals(opsList.get(i), collect.get(i).operation);
            if (seqNo != SequenceNumbers.UNASSIGNED_SEQ_NO) {
                repository,
            List<Translog.Operation> ops = new ArrayList<>(seqNos.size());
        final TranslogConfig config = new TranslogConfig(
            this.downLatch = downLatch;
                    new FileTransferTracker(shardId, new RemoteTranslogTransferTracker(shardId, 10)),
        // File not found in first attempt . File found in second attempt.
            fenceContainer.readBlobWithVersion(RemoteStoreFence.fenceBlobName(1)).content(),
        // expose the new checkpoint (simulating a commit), before we trim the translog
        final ChannelFactory channelFactory = getChannelFactory();
        ArrayList<Translog.Operation> ops = new ArrayList<>();
        slowDown.setSleepSeconds(0);
     * translog.ckp copy fail with an opaque NoSuchFileException after all retries; it is rejected up front instead.
        final long minSeqNo = seenSeqNos.stream().min(Long::compareTo).orElse(SequenceNumbers.NO_OPS_PERFORMED);
                translog.sync();
                                seqNoGenerator.getAndIncrement(),
    }
                false,
            threadPool,
        final Exception[] threadExceptions = new Exception[threadCount];
                }
        };
            reader.readBytes(buffer, pos);
                minSeqNo = SequenceNumbers.min(minSeqNo, currentSeqNo);
                            synchronized (flushMutex) {
                return;
            );
import org.opensearch.indices.replication.common.ReplicationType;
            int limit,
        assertTrue(Files.exists(location.resolve(Translog.CHECKPOINT_FILE_NAME)));
            assertEquals(
        translog.trimUnreferencedReaders();
                    logger.info("--> [{}] min gen after acquiring lock [{}]", threadId, translog.getMinFileGeneration());
        statsTracker = newTranslog.getRemoteTranslogTracker();
        Releasables.close(releasable);
        ) {
            RecoverySettings recoverySettings,
            this.slowDown = slowDown;
    }
        long minSeqNo = SequenceNumbers.NO_OPS_PERFORMED;
        TranslogTransferManager finalMockTransfer = mockTransfer;
        ArrayList<Translog.Operation> ops = new ArrayList<>();
            ) {
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
        @Override
            temp.getIndexSettings(),
                false,
import java.io.FileNotFoundException;
        }
                        final Translog.Operation op;
        assertTrue(primaryMode.get());
    }
import org.opensearch.core.action.ActionListener;
        // This should not trim tlog-2.* files from remote as we not uploading any more translog to remote
            if (randomBoolean()) {
            }
        Path[] filesPostFirstDownload = FileSystemUtils.files(location);
     * ownership (see FenceSegmentFlow.tla). The call itself stays safe - it skips, it does not throw.
        } else {
            // Sequence numbers are marked as persisted after sync
            try (Translog.Snapshot snapshot = translog.newSnapshot(fromSeqNo, toSeqNo)) {
     */
                final long seqNo = randomValueOtherThanMany(seqNos::contains, () -> randomLongBetween(0, 1000));
                );
            int totOps = 0;
        assertEquals(0, statsTracker.getUploadBytesFailed());
            }
        ChannelFactory channelFactory = getChannelFactory();
            }
            translog.getDeletionPolicy().setLocalCheckpointOfSafeCommit(2);
import org.opensearch.repositories.blobstore.BlobStoreTestUtil;
            int opsPerThread,
                    threadPool,
        Path location = createTempDir();
            );
        // Verify that the last synced checkpoint includes the updated global checkpoint
        );
        logger.info("numDocs={} moreDocs={}", numDocs, moreDocs);
        } catch (IOException e) {
        assertTrue(Files.exists(translogDir.resolve(Translog.getFilename(1))));
        Map<String, String> generationToChecksumMapper = new HashMap<>();
        assertEquals(2, translog.readers.size());
                writer.readBytes(ByteBuffer.allocate(256), 0);
    }
            super(blobStore, blobPath, path);
            assertEquals(2048, value);
                }
                throw new IOException("blob container throwing error");
        final Thread[] readers = new Thread[randomIntBetween(1, 3)];
        // This should not trim anything from local
            fail,
        Path tempDir = createTempDir();
                        }
        if (minSeqNo > 0) {
    private final AtomicReference<LongConsumer> persistedSeqNoConsumer = new AtomicReference<>();
        toSeqNo = randomLongBetween(fromSeqNo, 2000);
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 1);
            RemoteFsTranslog.sealFence(
    class TranslogThread extends Thread {
        // 4. After drainSync, if an upload is an attempted, we do not upload to remote store.
        assertNull(translog.readOperation(new Translog.Location(100, 0, 0)));
    }
import static org.hamcrest.Matchers.equalTo;
        }
            new Translog.Index("1", 0L, primaryTerm.get(), new byte[] { 1 }),
    }
                opsPerThread,
            primaryTerm::get,
            .put(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED, true)
                                signalReaderSomeDataWasIndexed.notifyAll();
            Files.delete(file);
            assertEquals(op, translog.readOperation(locs.get(i++)));
        RemoteFsTranslog.sealFence(
        final int numOps = scaledRandomIntBetween(8, 250000);
                opsHaveValidSequenceNumbers = opsHaveValidSequenceNumbers || !rarely();
        Mockito.clearInvocations(manager);
    public void testSyncUpToStream() throws IOException {
            translogConfig,
        addToTranslogAndList(translog, ops, new Translog.NoOp(seqNo, noopTerm, reason));
    ) throws IOException {
                assertFalse("the last call to ensureSycned synced all previous ops", translog.syncNeeded());
                // closing a tragically-failed translog is expected to rethrow
        // Update global checkpoint
        when(mockTransfer.downloadTranslogIfChanged(any(), any(), any(), any())).thenThrow(toThrow).thenReturn(true);
            incumbent.add(new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
                translog.rollGeneration();
        translog.add(new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
            if (consumer != null) {
        // Verify that the new checkpoint points to empty translog
                final FileChannel channel;
                new Translog.Index("" + op, seqNo, primaryTerm.get(), Integer.toString(seqNo).getBytes(Charset.forName("UTF-8")))
                    new RemoteStorePathStrategy(RemoteStoreEnums.PathType.FIXED),
            );
                DefaultRemoteStoreSettings.INSTANCE,
    }
                    while (run.get() && idGenerator.get() < maxOps) {
        translog.sync();
         * run entirely in one JVM and so share that emulation, making the precondition genuinely exclusive here.
            super(metadata, environment, namedXContentRegistry, clusterService, recoverySettings);
                        try (Translog.Snapshot snapshot = translog.newSnapshot(committedLocalCheckpointAtView + 1L, Long.MAX_VALUE)) {
            translog.getDeletionPolicy().assertNoOpenTranslogRefs();
        // a signal for all threads to stop
                    Thread.sleep(slowDown.getSleepSeconds() * 1000L);
        int count = 0;
        }
        }
                                primaryTerm.get(),
            );
import java.util.Random;
            }
    }
                false
        return currentSeqNo;
            () -> RemoteFsTranslog.download(mockTransfer, location, logger, false, 0)
            max = max(max, location);
                new Translog.Index(String.valueOf(i), i, primaryTerm.get(), new byte[] { (byte) i })
            }
        translog.setMinSeqNoToKeep(0);
                }
        @Override
                        // captures al views that are written since the view was created (with a small caveat see bellow)
            verify(manager, times(0)).downloadTranslog(any(), Mockito.eq(generation), any());
                .put(Environment.PATH_REPO_SETTING.getKey(), home.resolve("repo").toAbsolutePath())
                locations.add(location);
        // Sync the translog
            addToTranslogAndList(translog, ops, new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
            BlobContainer fenceContainer = fencedRepository.blobStore().blobContainer(fenceDirectory);
     */
        }
        RemoteFsTranslog fenced = createFencedTranslog("node-old", fencedRepository);
    private Environment createEnvironment() {
import org.opensearch.test.IndexSettingsModule;
            }
        return loc;
                false
        }
            assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
        assertTrue(statsTracker.getLastSuccessfulUploadTimestamp() > 0);
    ) throws IOException {
                if (isCkpFile) {
                || filesPostDownload[1].getFileName().toString().contains("translog.ckp")
        }
                assertThat(readerCheckpoint, equalTo(writerCheckpoint));
                    EOFException.class,
                    shardId,
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
        RemoteTranslogTransferTracker remoteTranslogTransferTracker = mock(RemoteTranslogTransferTracker.class);
                )
            translog.close();
        final BlockingQueue<TestTranslog.LocationOperation> writtenOperations = new ArrayBlockingQueue<>(threadCount * opsPerThread);
        try (Translog.Snapshot snapshot = translog.newSnapshot(fromSeqNo, toSeqNo, true)) {
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 1);
            translog.getDeletionPolicy().assertNoOpenTranslogRefs();
    /**
                            writeCalls.incrementAndGet();
        assertEquals(Set.of(Translog.getFilename(2), Translog.getCommitCheckpointFileName(2), Translog.CHECKPOINT_FILE_NAME), remaining);
    }
    }
                    return;
            final int value = buffer.getInt();
                        expectedOps.removeIf(op -> op.seqNo() <= committedLocalCheckpointAtView);
            new Translog.Index(String.valueOf(totalDocs), totalDocs, primaryTerm.get(), new byte[] { 1 })
            )
        ArrayList<Translog.Operation> ops = new ArrayList<>();
        assertTrue(created, created.contains("|1|" + allocationIdOf("node-new") + "|node-new|"));
            }
        try {
        // Set a global checkpoint
        assertTrue(statsTracker.getTotalUploadsSucceeded() > 0);
        verify(mockTransfer).downloadTranslogIfChanged("1", "2", location, String.valueOf(checksum2));
        ) {
        translog.sync();
                new RemoteStorePathStrategy(RemoteStoreEnums.PathType.FIXED),
                    reader.close();
            Settings.builder()
        assertEquals(6, translog.allUploaded().size());
            null,
    }
    }
            createTranslogGeneration(location, 2);
            channelFactory,
        BlobStoreRepository fencedRepository = createIsolatedRepository();
    }
            assertEquals(
        assertEquals(ex.getMessage(), "translog is already closed");
     * single JVM, so it must be refused: two nodes sharing a filesystem would both believe they held the fence, which is
        for (Path file : FileSystemUtils.files(translogDir)) {
                assertTrue("at least one operation pending", translog.syncNeeded());
            DefaultRemoteStoreSettings.INSTANCE,
         * JVM, which is no fencing primitive between hosts, and remote store fencing correctly refuses it. These tests
    /**
        assertEquals(mdFiles, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)));
import java.nio.file.Files;
                    assertEquals(i, value);
            return true;
        Settings nodeSettings = Settings.builder().put("node.attr.remote_store.translog.repository", "my-repo-1").build();
                .put(Environment.PATH_HOME_SETTING.getKey(), home.toAbsolutePath())
            if (fail.fail()) {
        assertDownloadStatsNoDownloads(statsTracker);
import java.io.EOFException;
        }
    private BlobStoreRepository createRepository() {
        final FsRepository repository = new ThrowingBlobRepository(
        metadata.setGenerationToChecksumMapper(generationToChecksumMapper);
            while ((next = snap.next()) != null) {
            final long readerGeneration = reader.getGeneration();
        DataOutput out = EndiannessReverserUtil.wrapDataOutput(new ByteArrayDataOutput(bytes));
        assertEquals(2, translog.readers.size());
                writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 5);
        }
         * Overriding lets the fence be exercised without weakening the production guard - see
        assertBusy(() -> assertEquals(1, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size()));
    }
            primaryTerm.get()
        // Sync again
        assertTrue(translog.syncNeeded());
        RemoteFsTranslog.download(noChecksum, location, logger, false, 0);
            final int threadId = i;
        @Override
                    DefaultRemoteStoreSettings.INSTANCE,
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            assertThat(snapshot, SnapshotMatchers.size(0));
                                break;
        final Thread[] writers = new Thread[randomIntBetween(1, 3)];
 * SPDX-License-Identifier: Apache-2.0
                primaryTerm.get() + 1
    @Before
            } else {
                @Override
                    buffer.flip();
     * A superseded copy must not delete remote generations: the trim's remote phase is gated fail-closed on fence
            this.threadId = threadId;
                byte[] tlog = tlogStream.readAllBytes();
            // only randomize between nog age retention and a long one, so failures will have a chance of reproducing
                assertUploadStatsNoFailures(statsTracker);
                                throw new AssertionError("unsupported operation type [" + type + "]");
        ) {
        ArrayList<Translog.Operation> ops = new ArrayList<>();
                config,
    }
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
        }
            }
            do {
        private final int opsPerThread;
        assertEquals(1, translog.readers.size());
    public void testDownloadWithTranslogOnlyInLocal() throws IOException {
                            case NO_OP:
        assertEquals(4, translog.allUploaded().size());
 */
                addToTranslogAndListAndUpload(translog, ops, new Translog.Index(String.valueOf(1), 1, primaryTerm.get(), new byte[] { 1 }));
        }
                                1 + randomInt(100000)
    // No translog data in remote and empty translog in local. We skip creating another empty translog
            }
            final LongConsumer consumer = persistedSeqNoConsumer.get();
    /** Create a {@link Environment} with random path.home and path.repo **/
         * {@link #testBuildTranslogTransferManagerRejectsEmulatedConditionalWrites}, which asserts an unmodified
            super.writeBlobAtomic(blobName, inputStream, blobSize, failIfAlreadyExists);
            assertEquals(4, translog.allUploaded().size());
        try (Translog.Snapshot snapshot = translog.newSnapshot(seqNo + 1, randomLongBetween(seqNo + 1, Long.MAX_VALUE))) {
        writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), randomNonNegativeLong());
import org.opensearch.env.TestEnvironment;
                ops,
        RemoteFsTranslog.download(manager, location, logger, false, 0);
        // Update global checkpoint
        assertTrue(statsTracker.getTotalUploadsStarted() > 0);
            }
import org.opensearch.index.seqno.LocalCheckpointTracker;
        when(mockTransfer.readMetadata()).thenReturn(translogTransferMetadata);
import org.opensearch.index.translog.transfer.TranslogFencedException;
        for (Path file : FileSystemUtils.files(location)) {
import org.opensearch.common.lease.Releasables;
                maxSeqNo = SequenceNumbers.max(maxSeqNo, currentSeqNo);
    }
                                failed = true;
        try (Translog.Snapshot snapshot = translog.newSnapshot(fromSeqNo, toSeqNo, true)) {
        try {
 * compatible open source license.
        public ThrowingBlobStore(
        // Same remote state, same local directory: only footer-less generations are fetched again, files are untouched.
                // not syncing now
                // don't do partial writes for checkpoints we rely on the fact that the bytes are written as an atomic operation
            getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))
        }
                    };
import static org.mockito.Mockito.verify;
                        }
        }
        int translogOperations = randomIntBetween(10, 100);
        public ThrowingBlobContainer(
        private final CountDownLatch downLatch;
import org.opensearch.common.bytes.ReleasableBytesReference;
    }
                try {
        when(mockTransfer.downloadTranslogIfChanged("1", "2", location, String.valueOf(checksum2))).thenReturn(false);
    }
        assertEquals(0, statsTracker.getLastSuccessfulUploadTimestamp());
            } finally {
        globalCheckpoint.set(newGlobalCheckpoint);
        assertTrue(statsTracker.getTotalUploadsStarted() > 0);
        Path location = createTempDir();
            ArrayList<Translog.Location> locations = new ArrayList<>();
        // 2. During an upload, if drainSync is called, it will wait for it to acquire and available permits are 0.
        assertFalse(translog.syncNeeded());
            shardId,
            freshRepository,
        Map<String, String> generationToPrimaryTermMapper = new HashMap<>();
                for (int i = 0; i < numOps; i++) {
        when(unsupportedRepository.basePath()).thenReturn(BlobPath.cleanPath());
                throw new IOException("blob container throwing error");
        boolean shouldFailAlways = randomBoolean();
        IOUtils.close(writer);
        addToTranslogAndList(translog, ops, new Translog.Delete("2", 1, primaryTerm.get()));
        Checkpoint existingCheckpoint = Translog.readCheckpoint(location);
                        Set<Translog.Operation> expectedOps = new HashSet<>(writtenOps.keySet());
    private static void assertDownloadStatsNoDownloads(RemoteTranslogTransferTracker statsTracker) {
                            op = new Translog.NoOp(seqNoGenerator.getAndIncrement(), primaryTerm.get(), randomAlphaOfLength(16));
    public void testReadLocation() throws IOException {
import static org.hamcrest.Matchers.anyOf;
                    closeRetentionLock();
                    false,
            .put(IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.getKey(), randomBoolean() ? "-1ms" : "1h")
        assertFalse(Files.exists(location.resolve(Translog.CHECKPOINT_FILE_NAME)));
        fail.failAlways();
                    barrier.await();
            assertThat(snapshot, SnapshotMatchers.size(0));
                assertEquals(writerCheckpoint.offset, reader.sizeInBytes());
                threadPool,
                // Add after we the read flushed the buffer
        ArrayList<Translog.Operation> ops = new ArrayList<>();
        } finally {
        assertBusy(() -> {
        return crc.getValue();
                                translog.setMinSeqNoToKeep(localCheckpoint + 1);
        Translog.Location max = locations.get(0);
                seenSeqNos.add(seqNo);
                            }
            BlobContainer fsContainer = fsBlobStore.blobContainer(BlobPath.cleanPath());
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
            for (Translog.Location location : locations) {
        assertEquals(1, translog.readers.size());
                        logger.error("unexpected error while closing view, after failure", inner);
        } catch (IOException e) {
                    new RemoteTranslogTransferTracker(shardId, 10),
        final TranslogConfig config = new TranslogConfig(
        translog.setMinSeqNoToKeep(1);
            generationToPrimaryTermMapper.put(String.valueOf(g), "1");
        writeCalls = new AtomicInteger();
        return repository.basePath().add(shardId.getIndex().getUUID()).add(String.valueOf(shardId.id())).add(TRANSLOG.getName());
                primaryTerm::get,
        } finally {
            new RemoteStoreFence(fenceContainer, allocationIdOf("node-new"), "node-new", shardId).validateAndAdvance(primaryTerm.get() + 1);
        TranslogTransferMetadata remoteMetadata = manager.readMetadata();
                    switch (type) {
                assertFalse("no sync needed since no operations in current translog", translog.syncNeeded());
            .build();
        try {
                    allocationIdOf("node-stale"),
                threadPool,
            this.fail = fail;
                        }
                assertFalse("translog has been synced already", translog.ensureSynced(locations.stream()));
        }
            TestTranslog.FailSwitch fail,
        translog.setMinSeqNoToKeep(0);
        long oldPrimaryTerm = primaryTerm.get();
            }
    /**
            threads[i].join(60 * 1000);
                persistedSeqNos::add,
        translog.setMinSeqNoToKeep(3);
        TranslogTransferManager noChecksum = mockTransferManagerFor(metadataFor(1, 1, Map.of()));
            throw e;
        }
                }
    public void testTranslogWriterFsyncDisabledInRemoteFsTranslog() throws IOException {
            }
                assertThat(writeCalls.get(), greaterThan(initialWriteCalls));
        ArrayList<Translog.Location> locs = new ArrayList<>();
        }
        CountDownLatch latch = new CountDownLatch(1);
        repository.updateState(clusterService.state());
        translog.trimUnreferencedReaders();
        RemoteFsTranslog.download(manager, location, logger, false, 0);
                            while ((op = snapshot.next()) != null) {
        private final TestTranslog.SlowDownWriteSwitch slowDown;
                    "node-stale",
            ops,
            Translog.Snapshot snapshot1 = translog.newSnapshot();
        assertDownloadStatsPopulated(statsTracker);
        for (Path file : FileSystemUtils.files(location)) {
                @Override
                    while (idGenerator.get() < maxOps) {
            new RemoteStorePathStrategy(RemoteStoreEnums.PathType.FIXED),
        for (String generation : withChecksum) {
            fenced.add(new Translog.Index("2", 1, primaryTerm.get(), new byte[] { 1 }));
                            }
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
            } else {
    protected RemoteFsTranslog create(Path path) throws IOException {
            // Fsync is still enabled during empty translog creation.
                new FileTransferTracker(shardId, new RemoteTranslogTransferTracker(shardId, 10)),
        for (int i = 0; i < writers.length; i++) {
        assertTrue(newEmptyTranslogCheckpoint.generation > existingCheckpoint.generation);
            }, threadName);
                }
                    translog.add(op);
        Map<Long, List<Translog.Operation>> operationsByGen = new HashMap<>();
        verify(mockTransfer).downloadTranslogIfChanged("1", "1", location, String.valueOf(checksum1));
        slowDown = new TestTranslog.SlowDownWriteSwitch();
        TranslogTransferManager finalMockTransfer = mockTransfer;
        Exception toThrow = randomBoolean() ? new NoSuchFileException(msg) : new FileNotFoundException(msg);
                // expected
                translog.rollGeneration();
        verify(manager, times(remoteGenerations)).downloadTranslog(any(), any(), any());
            new ByteSizeValue(10 + randomInt(128 * 1024), ByteSizeUnit.BYTES)
        Path location = createTempDir();
                                .append(committedLocalCheckpointAtView + 1L)
            primaryTerm::get,
        globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
        assertEquals(0, translog.availablePermits());
        assertEquals(0, translog.allUploaded().size());
import org.apache.logging.log4j.message.ParameterizedMessage;
        // A generation the remote does not advertise a checksum for is passed through with null.
        RemoteTranslogTransferTracker statsTracker = translog.getRemoteTranslogTracker();
                byte[] content = stream.readAllBytes();
                fenced.close();
import static org.mockito.Mockito.mock;
            operationsByGen.put(translog.currentFileGeneration(), ops);
import org.junit.After;
            assertThat(snapshot1, SnapshotMatchers.equalsTo(ops.get(0)));
        assertEquals(1, translog.readers.size());
            } catch (Exception e) {
        Releasable releasable = translog.drainSync();
        }
            IllegalArgumentException e = expectThrows(
                firstGenOps = ops;
    public void testMetadataFileDeletion() throws Exception {
        assertEquals(0, statsTracker.getLastSuccessfulDownloadTimestamp());
                        }
        assertEquals(filesBeforeDownload, FileSystemUtils.files(location));
            Files.copy(file, location.resolve(file.getFileName()));
        Path location = createTempDir();
            byte[] bytes = new byte[256];
        }
        // Successful snapshot
                config,
        }
            try (
                assertTrue("at least one operation pending", translog.syncNeeded());
        logger.info("testing with [{}] threads, each doing [{}] ops", threadCount, opsPerThread);
            Exception[] threadExceptions
        public void writeBlobAtomic(final String blobName, final InputStream inputStream, final long blobSize, boolean failIfAlreadyExists)
    }
            super.listBlobsByPrefixInSortedOrder(blobNamePrefix, limit, blobNameSortOrder, listener);
    public void testFencingEnabledTranslogUploadCreatesAndAdvancesFence() throws Exception {
            assertEquals(4, translog.allUploaded().size());
    public void testCloseIntoReader() throws IOException {
        // any errors on threads
    public void testSealFenceOnAFreshShardCreatesTheChain() throws Exception {
            for (Throwable suppress : errors.subList(1, errors.size())) {
    }
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("3", 2, primaryTerm.get(), new byte[] { 3 }));
    }
        final ClusterService clusterService = BlobStoreTestUtil.mockClusterService(repositoryMetadata);
            }
import org.opensearch.core.index.shard.ShardId;
            assertTrue(e.getMessage(), e.getMessage().contains("does not support store-enforced conditional writes"));
        int translogOperations = randomIntBetween(1, 20);
                    emulatedRepository,
     */
        );
                        expectedOps.add(op);
        }
        RemoteFsTranslog.download(mockTransfer, location, logger, false, 0);
        final AtomicLong seqNoGenerator = new AtomicLong();
                assertEquals(expectedContentChecksum, reader.getTranslogContentChecksum());
import org.opensearch.index.seqno.LocalCheckpointTrackerTests;
        }
                                assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
                            for (Translog.Operation expectedOp : expectedOps) {
            "node-new",
            } while (seenSeqNos.contains(seqNo));
        // Verify that sync is not needed
            expectThrows(TranslogFencedException.class, fenced::sync);
            }
            temp.getTranslogPath(),
        TranslogTransferMetadata translogTransferMetadata = new TranslogTransferMetadata(primaryTerm, generation, generation, 1);
        Translog.Location loc = addToTranslogAndListAndUpload(
            assertEquals(totOps, toSeqNo - fromSeqNo + 1);
    private class ThrowingBlobStore extends FsBlobStore {
     */
            // A higher term takes the fence out of band.
            fenced.trimUnreferencedReaders(); // gated: skips the remote deletion, does not throw
            FileChannel delegate = FileChannel.open(file, openOption);
            translog.rollGeneration();
        long initialGlobalCheckpoint = 0L;
        BlobPath fenceDirectory = fenceDirectory(fencedRepository);
        });
                                signalReaderSomeDataWasIndexed.wait();
        translog.trimUnreferencedReaders();
            for (long gen = translog.currentFileGeneration(); gen > 0; gen--) {
                            translogFsyncCalls.incrementAndGet();
     */
                            StringBuilder missed = new StringBuilder("missed ").append(expectedOps.size())
            maxGeneration,
            config.getTranslogPath(),
                }
import java.util.List;
                () -> RemoteFsTranslog.buildTranslogTransferManager(
            // Ignoring this exception for now. Once the download flow populates FileTracker,
            CountDownLatch downLatch,
            if (withChecksum.contains(String.valueOf(g)) == false) {
        try {
    // from local file system and create empty translog
    /** Allocation ids in these tests are derived from the node id so both identities stay legible in assertions. */
    }
import org.mockito.Mockito;
            addToTranslogAndList(translog, ops, new Translog.Index("2", 1, primaryTerm.get(), new byte[] { 2 }));
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.TRANSLOG;
            TranslogOperationHelper.DEFAULT,
        RemoteFsTranslog.download(finalMockTransfer, location, logger, false, 0);
        String translogUUID,
import org.opensearch.index.translog.transfer.BlobStoreTransferService;
            addToTranslogAndListAndUpload(translog, ops, new Translog.Index(String.valueOf(i), i, primaryTerm.get(), new byte[] { 1 }));
        final CyclicBarrier barrier = new CyclicBarrier(writers.length + readers.length + 1);
    protected final ShardId shardId = new ShardId("index", "_na_", 1);
     * The advertised checksum for each generation is handed to the transfer manager, which owns the decision to
                );
                // we are the last location so everything should be synced
            assertThat(persistedSeqNos, contains(1L, 2L, 3L, 4L, 5L));
    public void testDownloadWithRetries() throws IOException {
        BlobStoreRepository unsupportedRepository = mock(BlobStoreRepository.class);
            DataOutput out = EndiannessReverserUtil.wrapDataOutput(new ByteArrayDataOutput(bytes));
                translog.add(
            config.getTranslogPath(),
        Set<String> mdFiles = blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR));
            fenced.add(new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
                long committedLocalCheckpointAtView;
        createTranslogGeneration(location, 3);
        // Set initial global checkpoint
         */
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
        }
        translog.setMinSeqNoToKeep(totalDocs);
            primaryMode::get,
            BlobStoreRepository emulatedRepository = mock(BlobStoreRepository.class);
                    new RemoteStorePathStrategy(RemoteStoreEnums.PathType.FIXED),
            final Long expectedContentChecksum;
                );
        // Damage one local generation's footer checksum: that generation is re-downloaded, and it comes back intact.
                // closing a tragically-failed translog is expected to rethrow
        assertFalse(translog.syncNeeded());
                opsList.add(op);
            }
    protected ThreadPool threadPool;
        for (long g = minGeneration; g <= maxGeneration; g++) {
        final int opsPerThread = randomIntBetween(10, 200);
                new RemoteTranslogTransferTracker(shardId, 10),
            newTranslog.close();
            Collection<TestTranslog.LocationOperation> writtenOperations,
                ByteBuffer footerBuffer = ByteBuffer.allocate(TranslogFooter.footerLength());
        blobStoreTransferService = new BlobStoreTransferService(repository.blobStore(), threadPool);
            this.seqNoGenerator = seqNoGenerator;
                        if (existing != null) {
            FsBlobStore blobStore,
        final ChannelFactory channelFactory = (file, openOption) -> {
        BlobContainer container = mock(BlobContainer.class);
        assertArrayEquals(contentAfterFirst.get(damagedPath.getFileName().toString()), Files.readAllBytes(damagedPath));
    /**
                        if (expectedOps.isEmpty() == false) {
            // A new primary at a higher term seals the fence out of band
        assertEquals(initialGlobalCheckpoint, ((RemoteFsTranslog) translog).getLastSyncedCheckpoint().globalCheckpoint);
            byte[] bytes = new byte[256];
import org.opensearch.common.util.concurrent.AbstractRunnable;
                                break;
        Translog.Location[] locations = translog.add(operations);
                fail("io exception expected");
        }
        }
        for (int op = 0; op < translogOperations; op++) {
        // Case 3 - After drainSync, if trimUnreferencedReaders is attempted, we do not delete from remote store.
    public void testDownloadRejectsInvertedGenerationRange() throws IOException {
                afterFirstContent.contains("|" + primaryTerm.get() + "|" + allocationIdOf("node-1") + "|node-1|")
            assertTrue(fenced.getTragicException() instanceof TranslogFencedException);
        return getTranslogConfig(path, settings, "");
        assertEquals(seenSeqNos, persistedSeqNos);
import org.opensearch.index.remote.RemoteStoreEnums;
                    throw new RuntimeException(e);
        assertThat(e.getMessage(), containsString("min generation [5] greater than max generation [3]"));
        }).when(mockTransfer).downloadTranslogIfChanged(any(), any(), any(), any());
            when(emulatedRepository.blobStore(anyBoolean())).thenReturn(blobStore);
                // Validate the raw footer bytes.
        when(mockTransfer.readMetadata()).thenReturn(null);
                assertEquals(Long.valueOf(checksumOf(writer.path(), Files.size(writer.path()))), reader.getTranslogChecksum());
            new RecoverySettings(Settings.EMPTY, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)),
        RemoteTranslogTransferTracker remoteTranslogTransferTracker = mock(RemoteTranslogTransferTracker.class);
                && newEmptyTranslogCheckpoint.maxSeqNo == SequenceNumbers.NO_OPS_PERFORMED
            TranslogWriter writer = translog.getCurrent();
            try {
        Translog newTranslog = create(translogDir, repository, translogUUID, false);
        long initialGlobalCheckpoint = 1L;
        BlobStore blobStore = mock(BlobStore.class);
    }
            Translog.Operation maxOp = null;
                translog.rollGeneration(); // empty generation
                Channels.readFromFileChannelWithEofException(reader.channel, writerCheckpoint.offset, footerBuffer);
            config,
            for (int i = 0; i < numOps; i++) {
                // The footer carries the checksum of header + operations, i.e. of everything the writer has
                CheckedInputStream stream = new CheckedInputStream(Files.newInputStream(checkpointPath), new CRC32());
            this.fail = fail;
            }
        final TranslogConfig translogConfig = getTranslogConfig(path, extraGenToKeep);
                Files.createFile(location.resolve(Translog.getCommitCheckpointFileName(generation)));
        final Set<Long> persistedSeqNos = new HashSet<>();
        createTranslogGeneration(location, 1);
                InputStream ckpStream = blobStoreTransferService.downloadBlob(path, Translog.getCommitCheckpointFileName(readerGeneration))
            )
        assertBusy(() -> assertEquals(1, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size()));
        );
        assertEquals(2, translog.stats().estimatedNumberOfOperations());
        throws IOException {
        damagedBytes[damagedBytes.length - 1] ^= 0x1;
    public void testSyncUpAlwaysFailure() throws IOException {
        ) {
            "",
        return createTranslogInstance(translogConfig, translogUUID, deletionPolicy, isServerSideEncryptionEnabled);
                maxSeqNo = SequenceNumbers.max(maxSeqNo, seqNo);
            temp.getTranslogPath(),
    }
            reader.readBytes(buffer, reader.getFirstOperationOffset() + 4 * i);
        RemoteTranslogTransferTracker remoteTranslogTransferTracker = mock(RemoteTranslogTransferTracker.class);
                } catch (InterruptedException e) {
        private final int threadId;
        }
            }
            .add(METADATA_DIR);
                () -> Boolean.TRUE,
        private final TestTranslog.SlowDownWriteSwitch slowDown;
        for (int i = 0; i < threadCount; i++) {
        assertFalse(translog.syncNeeded());
            super(bufferSizeInBytes, path, readonly);
            final int value = buffer.getInt();
        when(unsupportedRepository.blobStore(anyBoolean())).thenReturn(blobStore);
        translog.setMinSeqNoToKeep(2);
        BlobStoreRepository fencedRepository = createIsolatedRepository();
                );
            return true;
import java.util.Map;
        when(mockTransfer.getRemoteTranslogTransferTracker()).thenReturn(remoteTranslogTransferTracker);
            }, threadId);
        );
            } finally {
                e.addSuppressed(suppress);
                        if (id % flushEveryOps == 0) {
        collect.sort(Comparator.comparing(op -> op.operation.seqNo()));
        protected void afterAdd() {}
                primaryTerm::get,
        }
        private final Exception[] threadExceptions;
            } catch (Exception t) {
    protected Path translogDir;
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
        try (RemoteFsTranslog fenced = createFencedTranslog("node-old", fencedRepository)) {
                4,
        final AtomicInteger translogFsyncCalls = new AtomicInteger();
        }
        // Validate
    private TranslogConfig getTranslogConfig(final Path path) {
            }
        try (Translog.Snapshot snap = new TestTranslog.SortedSnapshot(translog.newSnapshot())) {
    }
        synchronized (signalReaderSomeDataWasIndexed) {
                        case DELETE:
        return getTranslogConfig(path, 0);
        for (int op = 0; op < translogOperations; op++) {
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
                    allocationIdOf("node-1"),
                    writtenOperations.add(new TestTranslog.LocationOperation(op, loc));
            Set<Long> seenSeqNos = new HashSet<>();
                assertTrue("at least one operation pending", translog.syncNeeded());
            writer.sync();
        translog.sync();
        assertUploadStatsNoFailures(statsTracker);
        return channelFactory;
    private static TranslogTransferMetadata metadataFor(long minGeneration, long maxGeneration, Map<Long, Long> checksums) {
            assertEquals(
        } finally {
        this.repository = repository;
     * Creates a repository that is isolated from the one backing {@link #translog}, so that a second translog
import java.nio.file.Path;
        for (int i = totalDocs + 1; i <= totalDocs + newPrimaryTermDocs; i++) {
            translog.rollGeneration();
                        retentionLock.close();
import java.util.concurrent.BlockingQueue;
        assertBusy(() -> assertEquals(0, latch.getCount()));
            translog.add(
    }
            repository,
        }
                try {
        Translog.Location loc = translog.add(op);
                            );
        TranslogTransferManager mockTransfer = mock(TranslogTransferManager.class);
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        List<Translog.Location> locations = new ArrayList<>();
     * content checksum that ended up in the footer.
    }
                assertEquals(writerCheckpoint.offset + TranslogFooter.footerLength(), Files.size(reader.path()));
            .put(INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING.getKey(), gensToKeep)
        assertFalse(primaryMode.get());
                        tracker.markSeqNoAsProcessed(id);
                        }
            Translog.Operation next;
        // TODO: Need to simulate a delay for this assertion to avoid flakiness
        }
            BlobContainer fenceContainer = fencedRepository.blobStore().blobContainer(fenceDirectory(fencedRepository));
        assertThrows(NoSuchFileException.class, () -> RemoteFsTranslog.download(finalMockTransfer, location, logger, false, 0));
            throw new RuntimeException(e);
    /**
                assertTrue("this operation has not been synced", translog.ensureSynced(location));
        verify(mockTransfer, times(1)).readMetadata(0);
        int translogOperations = randomIntBetween(1, 20);
    }
import java.util.concurrent.atomic.AtomicLong;
        };
        // Sync the translog
            Translog.Location location = translog.add(op);
                allocationIdOf("node-new"),
        // Test setup
            .put(IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.getKey(), randomIntBetween(-1, 2048) + "b")
        private final Collection<TestTranslog.LocationOperation> writtenOperations;
        );
        assertEquals(6, translog.allUploaded().size());
        assertEquals(3, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());
import org.opensearch.common.blobstore.fs.FsBlobStore;
            fail("Should throw exception for missing operations");
        translog.sync();
                return channel;
                downLatch.await();
            assertNull(snapshot.next());
                assertNull(snapshot.next());
        assertEquals(6, translog.allUploaded().size());
        private final Environment environment;
            writer.sync();
                6,
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
        String translogUUID = translog.translogUUID;
    }
            if (fail.fail()) {
            fenced.add(new Translog.Index("2", 1, primaryTerm.get(), new byte[] { 1 }));
    protected Translog.Location addToTranslogAndListAndUpload(Translog translog, List<Translog.Operation> list, Translog.Operation op)
        }
import java.util.stream.Collectors;
                assertThat(writeCalls.get(), greaterThan(initialWriteCalls));
        Path location = createTempDir();
        translog.sync();
                    // recovery logic which captures a view and gets a lucene commit
        TranslogTransferManager mockTransfer = mockTransferManagerFor(inverted);
    public void testSealFenceClaimsChainAndFencesTheIncumbent() throws Exception {
                    }
            terminate(threadPool);
        BlobStoreRepository fencedRepository = createIsolatedRepository();
        Map<String, String> generationToChecksumMapper = new HashMap<>();
            writers[i].start();
            terminate(threadPool);
        list.add(op);
                    final ByteBuffer buffer = ByteBuffer.allocate(4);
                new Translog.Index("" + op, seqNo, primaryTerm.get(), Integer.toString(seqNo).getBytes(Charset.forName("UTF-8")))
        } finally {
                final boolean isCkpFile = file.getFileName().toString().endsWith(".ckp");
     * incumbent's token immediately - without the new copy having uploaded anything. This is what stops a previous
        public BlobContainer blobContainer(BlobPath path) {
        fail.failNever();
import java.util.Comparator;
package org.opensearch.index.translog;
            if (fail.fail()) {
                assertThat(snapshot.totalOperations(), equalTo(0));
        translog.sync();
                            break;
import org.opensearch.common.blobstore.BlobContainer;
    }
        assertBusy(() -> assertEquals(1, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size()));
     * A copy that begins a fresh lineage - a resize (shrink/split/clone) target, or a snapshot restore into a new
import org.opensearch.index.translog.transfer.TranslogTransferManager;
        );
        try {
            assertTrue(fenced.isRemoteStoreFenceSuperseded());
        Path path = createTempDir();
            channelFactory,
        Files.write(damagedPath, damagedBytes);
        assertTrue(translog.ensureSynced(locations[locations.length - 1]));
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
        fail.failNever();
            new ByteSizeValue(1, ByteSizeUnit.KB),
            Collections.shuffle(locations, random());
        IllegalStateException e = expectThrows(
        }
        assertEquals(mdFiles, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)));
                seqNo = opsHaveValidSequenceNumbers ? randomNonNegativeLong() : SequenceNumbers.UNASSIGNED_SEQ_NO;
                    DefaultRemoteStoreSettings.INSTANCE,
            translog.trimUnreferencedReaders();
        int count = 0;
                void closeRetentionLock() throws IOException {
        persistedSeqNos.remove(SequenceNumbers.UNASSIGNED_SEQ_NO);
            locations.add(location);
        assertEquals(6, translog.allUploaded().size());
                    }
            );
            Path path,
        // Verify that sync is not needed after syncing
            }
        AlreadyClosedException ex = expectThrows(AlreadyClosedException.class, () -> translog.newSnapshot());
import java.nio.ByteBuffer;
        translog.setMinSeqNoToKeep(totalDocs - 1);
        }
        );
            minGeneration,
                                fail(missed.toString());
        BlobStoreRepository fencedRepository = createIsolatedRepository();
                assertFalse("location is from a previous translog - already synced", translog.ensureSynced(locations.stream()));
        }
        try {
    }
    }
            }
        try (RemoteFsTranslog fenced = createFencedTranslog("node-1", fencedRepository)) {
        Map<String, String> generationToPrimaryTermMapper = new HashMap<>();
        }
            assertNotEquals(afterFirstContent, new String(afterSecond.content(), StandardCharsets.UTF_8));
import static org.mockito.Mockito.when;
        }
            }
import static org.mockito.Mockito.times;
        }
            translog.setMinSeqNoToKeep(i);
        TranslogTransferManager mockTransfer = mockTransferManagerFor(metadataFor(1, 1, Map.of(1L, checksum)));
            }
        for (Translog.Operation op : ops) {
        assertTrue(statsTracker.getUploadBytesStarted() > 0);
        final TestTranslog.FailSwitch currentFail = fail;
                primaryTerm::get,
        when(mockTransfer.getRemoteTranslogTransferTracker()).thenReturn(remoteTranslogTransferTracker);
            expectThrows(TranslogFencedException.class, incumbent::sync);
            }
            readers[i].start();
                final TranslogReader finalReader = reader;
            assertThat(snapshot, SnapshotMatchers.equalsTo(ops));
                assertEquals(expectedContentChecksum, TranslogFooter.readChecksum(reader.path(), writerCheckpoint.offset));
        // 1. During ongoing uploads, the available permits are 0.
                for (int opCount = 0; opCount < opsPerThread; opCount++) {
import static org.hamcrest.Matchers.greaterThan;
        verify(manager, times(withoutChecksum.size())).downloadTranslog(any(), any(), any());
import static org.mockito.Mockito.doAnswer;
            fenced.sync();
        @Override
        try {
        protected BlobStore createBlobStore() throws Exception {
        });
                assertFalse("all of the locations should be synced: " + location, translog.ensureSynced(location));
    public void testUploadWithPrimaryModeFalse() {
        assertTrue(translog.isOpen());
        Path location = createTempDir();
            clusterService,
                translog.rollGeneration();
            assertThat(snapshot.totalOperations(), equalTo(ops.size()));
        Set<String> tlogFiles = blobStoreTransferService.listAll(
    }
    }
                                op = new Translog.NoOp(id, 1, Long.toString(id));
        addToTranslogAndList(translog, ops, new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
    public class ThrowingBlobRepository extends FsRepository {
        out.writeInt(2048);
        try {
        translogTransferMetadata.setGenerationToPrimaryTermMapper(generationToPrimaryTermMapper);
        assertEquals(2, mdFiles.size());
        List<Closeable> toClose = new ArrayList<>();
                assertDownloadStatsNoDownloads(statsTracker);
        // Update global checkpoint
                        }
            final Checkpoint writerCheckpoint = writer.getCheckpoint();
            }
                assertFalse("translog has been synced already", translog.ensureSynced(location));
        assertEquals(0, statsTracker.getTotalUploadsFailed());
import java.util.concurrent.atomic.AtomicInteger;
        final AtomicLong lastCommittedLocalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            VersionedBlob afterFirst = fenceContainer.readBlobWithVersion(RemoteStoreFence.fenceBlobName(primaryTerm.get()));
        Settings settings = Settings.builder()
        RemoteFsTranslog.download(finalMockTransfer, location, logger, false, 0);
        long fromSeqNo = 0L;
        try {
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(shardId.getIndex(), settings, nodeSettings);
            for (Translog.Operation op = snapshot.next(); op != null; op = snapshot.next()) {
        ArrayList<Translog.Operation> ops = new ArrayList<>();
            // live reader!
            )
                deletionPolicy,
                                .append("]");
                persistedSeqNos::add,
            () -> RemoteFsTranslog.buildTranslogTransferManager(
            createTranslogDeletionPolicy(config.getIndexSettings()),
import org.opensearch.core.common.bytes.BytesArray;
            assertThat(snapshot, SnapshotMatchers.size(0));
        }
            translog.sync();
        checksums.forEach((g, c) -> generationToChecksumMapper.put(String.valueOf(g), String.valueOf(c)));
        assertEquals(0, statsTracker.getUploadBytesFailed());
        // translog.ckp is re-derived from the latest generation's checkpoint.
        i = 0;
        int numDocs = randomIntBetween(6, 10);
                translog.rollGeneration(); // empty generation
            if (threadExceptions[i] != null) {
        locs.add(addToTranslogAndList(translog, ops, new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 })));
        // Creating RemoteFsTranslog with the same location
        assertTrue(translog.syncNeeded());
            if (shouldFailAlways) {
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
        final Set<Long> seenSeqNos = new HashSet<>();
     * worse than running unfenced because each shard would report itself protected. Uses a real {@link FsBlobStore}
        RepositoryMetadata repositoryMetadata = new RepositoryMetadata(randomAlphaOfLength(10), FsRepository.TYPE, settings);
                final DataOutput out = EndiannessReverserUtil.wrapDataOutput(new ByteArrayDataOutput(bytes));
            try {
    }
        // this should now trim as tlog-2 files from remote, but not tlog-3 and tlog-4
                        }
    private RemoteFsTranslog create(Path path, BlobStoreRepository repository, String translogUUID, boolean isServerSideEncryptionEnabled)
                if (shouldAdd) {
import org.opensearch.index.engine.MissingHistoryOperationsException;
                false,
                    };
import java.io.InputStream;
        final Object signalReaderSomeDataWasIndexed = new Object();
            .map(p -> p.getFileName().toString())
                            case INDEX:
import org.apache.lucene.store.AlreadyClosedException;
                    assertEquals(expectedContentChecksum, reader.getTranslogContentChecksum());
        BlobPath path = getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()));
            false,
    }
        assertTrue(locations[1].compareTo(locations[2]) < 0);
import static org.opensearch.common.util.BigArrays.NON_RECYCLING_INSTANCE;
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("2", 1, primaryTerm.get(), new byte[] { 2 }));
        // Delete translog files to test download flow
                Files.readAllBytes(file)
            }
                writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 5);
            FileChannel delegate = FileChannel.open(file, openOption);
     * primary that is still alive from acknowledging writes landing after the new copy's restore point.
        verify(mockTransfer).downloadTranslogIfChanged("1", "2", location, "5678");
                translog.sync();
        repository.start();
                assertEquals(expectedContentChecksum.longValue(), footerBuffer.getLong());
        translog.sync();
        final int maxOps = randomIntBetween(20, 100);
    }
            new Translog.Index(String.valueOf(2), 2, primaryTerm.get(), new byte[] { 1 })
        return seqNo -> {
        long initialGlobalCheckpoint = 0L;
    }
        final int generations = between(2, 20);
            addToTranslogAndList(translog, ops, new Translog.Index("3", 2, primaryTerm.get(), new byte[] { 3 }));
        // no exception thrown
                    int iter = 0;
        assertEquals(0, statsTracker.getUploadBytesSucceeded());
                    translog.ensureSynced(location);
                assertFalse("the last call to ensureSycned synced all previous ops", translog.syncNeeded());
            this.slowDown = slowDown;
                assertTrue("this operation has not been synced", translog.ensureSynced(locations.stream()));
     * Writes a closed translog generation (header + a few operation bytes + footer) and its checkpoint file at
    /** Sealing at a term below the fence's must be refused: that copy has already been superseded. */
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
                    final Translog.Operation.Type type = randomFrom(Translog.Operation.Type.values());
import java.nio.charset.Charset;
                assertEquals(TranslogFooter.CHECKSUM_ALGORITHM_CRC32, footerBuffer.getInt());
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 2);
        // Verify that the globalCheckpointSynced is updated
    public void testIncrementalDownloadRemovesGenerationsOutsideRemoteRange() throws IOException {
        // This test checks following scenarios -
            }
        Translog.Location loc = translog.add(op);
    BlobStoreTransferService blobStoreTransferService;
        }
import org.apache.lucene.tests.util.LuceneTestCase;
            assertThat(snapshot, containsOperationsInAnyOrder(ops));
        assertTrue(statsTracker.getTotalUploadTimeInMillis() > 0);
        @Override
            if (downloadCounter.incrementAndGet() <= 1) {
        try (TranslogWriter writer = translog.createWriter(translog.currentFileGeneration() + 1)) {
        ArrayList<Translog.Operation> ops = new ArrayList<>();
    public void testStaleTopLevelCheckpointIsRemovedUpFrontAndRecreated() throws IOException {
                    shardId,
            assertEquals(4, translog.allUploaded().size());
                    new Translog.Index("" + op, op, primaryTerm.get(), Integer.toString(++count).getBytes(Charset.forName("UTF-8")))
                () -> Boolean.TRUE,
        assertEquals(0, statsTracker.getTotalUploadTimeInMillis());
        // exception is the initial empty generation laid down by Translog.createEmptyTranslog, which is written
            if (rarely()) {
            try (
            }
import java.util.zip.CheckedInputStream;
        Path[] filesBeforeDownload = FileSystemUtils.files(location);
        );
        Mockito.clearInvocations(manager);
        Map<String, byte[]> contentAfterFirst = new HashMap<>();
                            if (idGenerator.get() < maxOps) {
            newEmptyTranslogCheckpoint.generation == newEmptyTranslogCheckpoint.minTranslogGeneration
        // Verify that the globalCheckpointSynced is updated to the new value
        when(mockTransfer.readMetadata(0)).thenReturn(metadata);
        TranslogThread(
            final Translog.Location location = translog.add(
            primaryTerm.get()
        translog.trimUnreferencedReaders();
        when(mockTransfer.getRemoteTranslogTransferTracker()).thenReturn(mock(RemoteTranslogTransferTracker.class));
        public void run() {
                    translog.rollGeneration();
        assertBusy(() -> assertEquals(4, translog.allUploaded().size()));
            final String location = REPOSITORIES_LOCATION_SETTING.get(getMetadata().settings());
        final Set<Long> persistedSeqNos = new HashSet<>();
        assertEquals(0, statsTracker.getTotalDownloadsSucceeded());
        Files.createFile(location.resolve("unrelated.tmp"));
            if (rarely() && translogOperations > op + 1) {
                        }
    public void testSyncWithGlobalCheckpointUpdate() throws IOException {
                            translog.ensureSynced(location);
                public void onFailure(Exception e) {
        ) {
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        logger.info("--> test done. total ops written [{}]", writtenOps.size());
    private Translog.Location addToTranslogAndList(Translog translog, List<Translog.Operation> list, Translog.Operation op)
        }
    public void testBuildTranslogTransferManagerRejectsEmulatedConditionalWrites() throws IOException {
import java.util.concurrent.CyclicBarrier;
    }
        // A successful one recreates it from the latest generation's checkpoint.
        // Case 1 - During ongoing uploads, the available permits are 0.
     */
            contentAfterFirst.put(file.getFileName().toString(), Files.readAllBytes(file));
     * downloaded once into a fresh directory, and a second download of the same remote state fetches nothing but
            temp.getIndexSettings(),
        private TestTranslog.FailSwitch fail;
                    try {
            if (randomBoolean()) {
            this.threadExceptions = threadExceptions;
     * the download reconciles the remaining generations.
            new Translog.Index("2", 1L, primaryTerm.get(), new byte[] { 2 }),
                    () -> finalReader.readBytes(ByteBuffer.allocate(4), finalReader.getFirstOperationOffset() + numOps * 4)
            RemoteFsTranslog translog = new RemoteFsTranslog(
                }
        boolean opsHaveValidSequenceNumbers = randomBoolean();
    protected final static String DATA_DIR = "data";
     */
        when(mockTransfer.getRemoteTranslogTransferTracker()).thenReturn(remoteTranslogTransferTracker);
            );
        return b;
        Path location = createTempDir();
                channelFactory,
     * Tests that concurrent readers and writes maintain view and snapshot semantics
            int seqNo = ++count;
    /**
        );
            @Override
    }
            addToTranslogAndListAndUpload(translog, ops, new Translog.Index("2", 1, primaryTerm.get(), new byte[] { 1 }));
    public static Translog.Location max(Translog.Location a, Translog.Location b) {
                        Translog.Location existing = writtenOps.put(op, location);
            for (Translog.Operation op = snapshot.next(); op != null; op = snapshot.next()) {
                    channel = new FilterFileChannel(delegate) {
        translog.setMinSeqNoToKeep(1);
            logger.error("Asserting content of {}", readerGeneration);
    public void testConcurrentWriteViewsAndSnapshot() throws Throwable {
        try {
                            }
        }
                        Translog.Location location = translog.add(op);
            // The CAS chain advanced: a new version token over new content
                boolean shouldAdd = !withMissingOps || seqNo % 4 != 0;
            () -> globalCheckpoint.get(),
            )
                                translog.rollGeneration();
                                seqNoGenerator.getAndIncrement(),
    }
            thread.join();
                        counter++;
        for (Translog.Operation op : ops) {
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 2);
                            }
        final TestTranslog.SlowDownWriteSwitch currentSlowDown = slowDown;
        final Set<Long> persistedSeqNos = new HashSet<>();
                            op = new Translog.Index(
            boolean success = false;
    @After
            int seqNo = ++count;
        return config;
        assertThat(withoutChecksum, anyOf(empty(), contains(String.valueOf(minGeneration))));
                seqNos.add(currentSeqNo);
        primaryMode.set(false);
        try (FsBlobStore fsBlobStore = new FsBlobStore(1024, createTempDir(), false)) {
            );
        writer.sync();
        generationToPrimaryTermMapper.put(String.valueOf(generation), String.valueOf(primaryTerm));
        }
                assertArrayEquals(ckp, content);
    /** CRC32 of the first {@code length} bytes of {@code path}, the algorithm used by {@link TranslogCheckedContainer}. */
            this.fail = fail;
            translog.ensureSynced(loc);
            final String threadId = "reader_" + i;
        assertEquals(2, filesPostDownload.length);
        verify(noChecksum).downloadTranslogIfChanged("1", "1", location, null);
        }
        Thread thread1 = new Thread(() -> {
        for (int op = 0; op < translogOperations; op++) {
        for (Translog.Location location : locations) {
            1,
        mockTransfer = mock(TranslogTransferManager.class);
            }
    public void testSyncNeededWithGlobalCheckpointUpdate() throws IOException {
    public void testSnapshotWithNewTranslog() throws IOException {
                final Checkpoint syncedCheckpoint = writer.getCheckpoint();
    public void testGlobalCheckpointUpdateDuringClose() throws IOException {
        private final AtomicLong seqNoGenerator;
        barrier.await();
                    afterAdd();
            shardId,
            SequenceNumbers.NO_OPS_PERFORMED,
            assertTrue(
                                final Translog.Location loc = writtenOps.get(expectedOp);
                threadExceptions
        long generation = 1, primaryTerm = 1;
            assertEquals(op, newTranslog.readOperation(locs.get(i++)));
            incumbent.add(new Translog.Index("2", 1, primaryTerm.get(), new byte[] { 1 }));
import org.apache.lucene.codecs.CodecUtil;
        }
     * enabled. The caller owns closing it.
            idGenerator.set(Long.MAX_VALUE);
                        }
    private static long checksumOf(Path path, long length) throws IOException {
            isServerSideEncryptionEnabled
        int numOps = randomIntBetween(2, 6);
    private static void assertUploadStatsNoFailures(RemoteTranslogTransferTracker statsTracker) {
    }
            TranslogOperationHelper.DEFAULT,
    protected final static String METADATA_DIR = "metadata";
            final int numOps = randomIntBetween(8, 128);
        assertFalse(translog.syncNeeded());
            assertThat(snapshot, SnapshotMatchers.size(0));
                Translog.Index op = new Translog.Index(randomAlphaOfLength(10), seqNo, primaryTerm.get(), new byte[] { randomByte() });
import java.io.Closeable;
        final TranslogWriter writer = translog.createWriter(translog.currentFileGeneration() + 1);
        assertArrayEquals(filesPostFirstDownload, filesPostSecondDownload);
    public void testExtraGenToKeep() throws Exception {
                translogUUID,
     * index UUID - seals against a repository holding no fence for its shard. The seal is then simply the fresh
            TestTranslog.FailSwitch fail,
        ) {
        verify(manager, times(withoutChecksum.size() + 1)).downloadTranslog(any(), any(), any());
                    false,
    /**
        int count = 0;
        list.add(op);
        assertDownloadStatsNoDownloads(statsTracker);
                @Override
                new DefaultTranslogDeletionPolicy(-1, -1, 0),
                        }
                throw new OpenSearchException("failed to create blob container", ex);
            }
import org.opensearch.index.translog.transfer.TranslogTransferMetadata;
        }
            threads[i].start();
                translog,
                }
        return nodeId.isEmpty() ? "" : nodeId + "-alloc";
        when(mockTransfer.downloadTranslogIfChanged("1", "1", location, String.valueOf(checksum))).thenReturn(false);
        long checksum2 = createTranslogGeneration(location, 2);
import java.util.concurrent.CopyOnWriteArrayList;
            BlobContainer fenceContainer = fencedRepository.blobStore().blobContainer(fenceDirectory(fencedRepository));
                    fencedRepository,
            } else if (downloadCounter.get() == 2) {
import org.opensearch.common.io.Channels;
import org.opensearch.common.blobstore.BlobMetadata;
                    EOFException.class,
                } catch (InterruptedException e) {
            ClusterService clusterService,
            } else {
                }
import org.opensearch.core.common.unit.ByteSizeValue;
            assertThat(snapshot.totalOperations(), equalTo(ops.size()));
            // Sequence numbers are marked as persisted after sync
     */
                        @Override
        // writes should get synced up now
            try {
     * Only the generations the manager reports as downloaded are counted as such; the one already present is kept.
            temp.getBigArrays(),
                && newEmptyTranslogCheckpoint.numOps == 0
        }
                    primaryTerm.get() - 1
        for (int i = 0; i < numOps; i++) {
        }).when(mockTransfer).downloadTranslogIfChanged("1", "2", location, "5678");
            for (int i = 0; i < numOps; i++) {
    public void testSyncUpLocationFailure() throws IOException {
    }
    /**
        final String translogUUID = Translog.createEmptyTranslog(path, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
        assertEquals(1, translog.readers.size());
        for (long g = minGeneration; g <= maxGeneration; g++) {
        assertEquals(1, translog.stats().estimatedNumberOfOperations());
        // 3. After drainSync, if trimUnreferencedReaders is attempted, we do not delete from remote store.
    }
        TranslogTransferManager failing = mockTransferManagerFor(metadataFor(2, 2, Map.of(2L, checksum2)));
            toClose.add(snapshot1);
            allocationIdOf("node-new"),
                assertThrows(
import org.opensearch.cluster.service.ClusterService;
            super.tearDown();
     * download that fails leaves the directory without one rather than with a checkpoint naming a generation from a
            TestTranslog.SlowDownWriteSwitch slowDown
                seqNoGenerator,
            channelFactory,
                final boolean isCkpFile = file.getFileName().toString().endsWith(".ckp");
        assertBusy(() -> {
        when(mockTransfer.downloadTranslogIfChanged("1", "1", location, String.valueOf(checksum1))).thenReturn(false);
        Path home = createTempDir();
            );
            translog.rollGeneration();
import static org.opensearch.index.translog.TranslogDeletionPolicies.createTranslogDeletionPolicy;
        ) throws IOException {
    }
        );
                        public void force(boolean metaData) throws IOException {
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), seqNo);
                    channel = delegate;
            .collect(Collectors.toSet());
        return getTranslogConfig(path, settings);
                false
        locs.add(addToTranslogAndList(translog, ops, new Translog.Index("2", 1, primaryTerm.get(), new byte[] { 1 })));
    public void tearDown() throws Exception {
        final ByteSizeValue bufferSize = randomFrom(
        String translogUUID = Translog.createEmptyTranslog(
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index(String.valueOf(0), 0, primaryTerm.get(), new byte[] { 1 }));
    }
                }
            Throwable e = errors.get(0);
                translog,
                "node-new",
        assertUploadStatsNoFailures(statsTracker);
        final CountDownLatch downLatch = new CountDownLatch(1);
    private static void assertUploadStatsNoUploads(RemoteTranslogTransferTracker statsTracker) {
                () -> SequenceNumbers.NO_OPS_PERFORMED,
     * reuse the local copy; a generation it reports as reused is not downloaded and counts as skipped.
        long minSeqNo = SequenceNumbers.NO_OPS_PERFORMED;
            signalReaderSomeDataWasIndexed.notifyAll();
                out.writeInt(i);
        // Verify that sync is now needed due to global checkpoint update
        for (Translog.Operation op : ops) {
                                .append(" operations from [")
        globalCheckpoint.set(initialGlobalCheckpoint);
        TranslogTransferManager succeeding = mockTransferManagerFor(metadataFor(2, 2, Map.of(2L, checksum2)));
        assertTrue(
        } catch (Exception e) {
        }
            temp.getBigArrays(),
            translogUUID,
            new ByteSizeValue(1, ByteSizeUnit.KB),
        int iters = randomIntBetween(5, 10);
                assertTrue("we only synced a previous operation yet", translog.syncNeeded());
            // we can remove this try-catch block
    protected BlobPath getTranslogDirectory() {
                "node-1"
                assertThat(persistedSeqNos, empty());
import org.apache.lucene.store.ByteArrayDataOutput;
                protected void doRun() throws Exception {
        return TestEnvironment.newEnvironment(
                    if (retentionLock != null) {
        }
        logger.debug("--> waiting for threads to stop");
import static org.opensearch.index.IndexSettings.INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING;
                contentAfterFirst.get(file.getFileName().toString()),
            ByteBuffer buffer = ByteBuffer.allocate(4);
                            checkpointFsyncCalls.incrementAndGet();
            );
        }
        assertDownloadStatsNoDownloads(statsTracker);
                public void doRun() throws Exception {
        assertBusy(() -> assertEquals(0, translog.availablePermits()));
                    logger.info("--> [{}] done. tested [{}] snapshots", threadId, iter);
            assertEquals(maxOp.getSource().source.utf8ToString(), Integer.toString(count));
                for (Translog.Operation op : operationsByGen.getOrDefault(gen, Collections.emptyList())) {
            }
            config.getTranslogPath(),
                true,
            final int threadId = i;
        assertEquals(0, statsTracker.getTotalDownloadTimeInMillis());
            assertDownloadStatsNoDownloads(statsTracker);
        TranslogTransferManager mockTransfer = mock(TranslogTransferManager.class);
                    reader.readBytes(buffer, reader.getFirstOperationOffset() + 4 * i);
            ByteBuffer buffer = ByteBuffer.allocate(4);
    }
        assertArrayEquals(
                        case INDEX:
        RemoteFsTranslog.download(succeeding, location, logger, false, 0);
            }
                }
            fenced.sync();
    public void testDrainSync() throws Exception {
        final TranslogConfig config = getConfig(1);
        }
                assertTrue("one pending operation", translog.syncNeeded());
            Files.readAllBytes(location.resolve(Translog.CHECKPOINT_FILE_NAME))
            TranslogWriter writer = translog.getCurrent();
            return true;
        assertEquals(newGlobalCheckpoint, ((RemoteFsTranslog) translog).getLastSyncedCheckpoint().globalCheckpoint);
        IllegalArgumentException e = expectThrows(
                }
            addToTranslogAndListAndUpload(
        }
                translogUUID,
    public void testConcurrentWritesWithVaryingSize() throws Throwable {
        assertUploadStatsNoUploads(statsTracker);
    /**
        super.setUp();
    TestTranslog.SlowDownWriteSwitch slowDown;
        public void writeBlob(final String blobName, final InputStream inputStream, final long blobSize, boolean failIfAlreadyExists)
import static org.opensearch.index.translog.SnapshotMatchers.containsOperationsInAnyOrder;
    public void testLocationComparison() throws IOException {
            translog.close();
                    }
    private TranslogTransferManager mockTransferManagerFor(TranslogTransferMetadata metadata) throws IOException {
        ArrayList<Translog.Operation> ops = new ArrayList<>();
        inverted.setGenerationToPrimaryTermMapper(Map.of());
        crc.update(bytes, 0, Math.toIntExact(length));
import org.opensearch.OpenSearchException;
        }
                            break;
        logger.info("All md files {}", mdFiles);
            if (slowDown.getSleepSeconds() > 0) {
            BlobNameSortOrder blobNameSortOrder,
                TranslogFencedException.class,
        Path[] filesPostSecondDownload = FileSystemUtils.files(location);
            SequenceNumbers.NO_OPS_PERFORMED,
                @Override
                    channel = new FilterFileChannel(delegate) {
    }
        assertDownloadStatsNoDownloads(statsTracker);
     * A stale top-level translog.ckp is removed with the other out-of-range files before the download starts, so a
        Set<String> withoutChecksum = new HashSet<>();
        // Test deletion of metadata files
                StandardCharsets.UTF_8
        }
    /**
                () -> SequenceNumbers.NO_OPS_PERFORMED,
            incumbent.sync();
            addToTranslogAndListAndUpload(translog, ops, new Translog.Index(String.valueOf(i), i, primaryTerm.get(), new byte[] { 1 }));
            final Translog.Location location = translog.add(
        int i = 0;
import org.apache.lucene.tests.mockfile.FilterFileChannel;
import org.opensearch.index.translog.transfer.TranslogUploadFailedException;
                incumbent.close();
                fenceContainer.readBlobWithVersion(RemoteStoreFence.fenceBlobName(primaryTerm.get() + 1)).content(),
        }
                assertThrows(
        );
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
                }
                            boolean failed = false;
    public void testSealFenceIsRefusedForAStaleTerm() throws Exception {
     * rather than a mock, so the test fails if that container ever starts advertising support again.
        );
        }
                return channel;
        int moreDocs = randomIntBetween(3, 10);
                success = true;
import org.opensearch.core.xcontent.NamedXContentRegistry;
    private static String allocationIdOf(String nodeId) {
            TestTranslog.FailSwitch fail,
                } catch (IOException e) {
import java.nio.channels.FileChannel;
                    } catch (IOException inner) {
            filesPostDownload[0].getFileName().toString().contains("translog.ckp")
                afterFirstContent,
import org.opensearch.indices.DefaultRemoteStoreSettings;
                new Translog.Index(String.valueOf(op), count, primaryTerm.get(), Integer.toString(count).getBytes(StandardCharsets.UTF_8))
        } finally {
            }
     */
        assertEquals(8, translog.allUploaded().size());
                    () -> finalReader.readBytes(ByteBuffer.allocate(8), finalReader.getFirstOperationOffset() + numOps * 4 - 4)
        verify(mockTransfer, times(0)).downloadTranslog(any(), any(), any());
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 3);
        }
                fail.failNever();
    }
            }
                    false,
                consumer.accept(seqNo);
        addToTranslogAndListAndUpload(
        Checkpoint newEmptyTranslogCheckpoint = Translog.readCheckpoint(location);
    protected final AtomicLong primaryTerm = new AtomicLong();
                            synchronized (signalReaderSomeDataWasIndexed) {
    protected RemoteFsTranslog createTranslogInstance(
        );
                    }
        AtomicLong downloadCounter = new AtomicLong();
            this.translog = translog;
        when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(container);
            false
                    ops.add(op);
        int count = 0;
        String translogUUID = translog.translogUUID;
        long checksum = createTranslogGeneration(location, 1);
    }
    }
                translog.sync();
            thread.join();
            Files.readAllBytes(location.resolve(Translog.getCommitCheckpointFileName(2))),
        TranslogConfig config = getTranslogConfig(path, settings, nodeId);
                listener.onFailure(new RuntimeException("blob container throwing error"));
                            .values().length))];
            Path path,
import org.apache.lucene.store.DataOutput;
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 3);
                final Checkpoint readerCheckpoint = reader.getCheckpoint();
@LuceneTestCase.SuppressFileSystems("ExtrasFS")
    public void testSimpleOperationsUpload() throws Exception {
            incumbent.sync();
     */
            new RemoteStoreFence(fenceContainer, allocationIdOf("node-new"), "node-new", shardId).validateAndAdvance(primaryTerm.get() + 1);
        when(succeeding.downloadTranslogIfChanged("1", "2", location, String.valueOf(checksum2))).thenReturn(false);
            1
                    committedLocalCheckpointAtView = lastCommittedLocalCheckpoint.get();
            repositoryMetadata,
        if (errors.size() > 0) {
            ? writer
                                break;
        );
                    channel = new FilterFileChannel(delegate) {
        final List<Exception> errors = new CopyOnWriteArrayList<>();
        for (Path file : FileSystemUtils.files(translogDir)) {
                threadPool,
        ) {
        clusterService.addStateApplier(event -> repository.updateState(event.state()));
import org.opensearch.common.blobstore.BlobPath;
            temp.getShardId(),
        for (Thread thread : writers) {
        // Creating RemoteFsTranslog with the same location
            new Translog.Index("3", 2L, primaryTerm.get(), new byte[] { 3 })
            newTranslog.close();
        assertTrue(e.getMessage(), e.getMessage().contains("does not support store-enforced conditional writes"));
                    // captures the last committed checkpoint, while holding the view, simulating
            for (long seqNo : seqNos) {
        AtomicLong downloadCounter = new AtomicLong();
import java.util.HashMap;
    public void testTrimUnreferencedReadersSkipsRemoteDeletionWhenSuperseded() throws Exception {
        long checksum2 = createTranslogGeneration(location, 2);
            for (Translog.Operation op = snapshot.next(); op != null; op = snapshot.next()) {
                            }
            return a;
            // Ignoring this exception for now. Once the download flow populates FileTracker,
import static org.mockito.ArgumentMatchers.any;
     * End to end against the real (filesystem backed) transfer manager: generations uploaded by this translog are
                () -> Boolean.TRUE,
        globalCheckpoint.set(newGlobalCheckpoint);
    AtomicInteger writeCalls = new AtomicInteger();
                shardId,
                DefaultRemoteStoreSettings.INSTANCE,
            assertEquals(1, translogFsyncCalls.get());
        if (shouldFailAlways) {
        @Override
            assertArrayEquals(
        if (a.compareTo(b) > 0) {
        // Close the translog
        );
        // assert content of ckp and tlog files
            );
        // Sync the translog
            final Path locationFile = environment.resolveRepoFile(location);
    public void testSnapshotOnClosedTranslog() throws IOException {
            try {
                // don't do partial writes for checkpoints we rely on the fact that the bytes are written as an atomic operation
        writeCalls = new AtomicInteger();
        };
        long newGlobalCheckpoint = 1L;
            readers[i] = new Thread(new AbstractRunnable() {
        assertThat(reader.getCheckpoint().maxSeqNo, equalTo(maxSeqNo));
                    Thread.sleep(slowDown.getSleepSeconds() * 1000L);
                        @Override
        verify(mockTransfer).downloadTranslogIfChanged("1", "1", location, String.valueOf(checksum));
        }
    public void testDownloadWithEmptyTranslogOnlyInLocal() throws IOException {
            }
        }
                    IOUtils.closeWhileHandlingException(delegate);
            final String threadName = "writer_" + i;
            if (randomBoolean()) {
                    "node-1"
        // download on empty translog should be a no-op
                file.getFileName().toString(),
        inverted.setGenerationToChecksumMapper(Map.of());
            ((TranslogReader) reader).close();
        for (int gen = 0; gen < generations; gen++) {
import org.opensearch.common.blobstore.fs.FsBlobContainer;
        boolean isServerSideEncryptionEnabled
        }
        try (
        }
                translog.add(op);
        assertTrue(statsTracker.getLastSuccessfulUploadTimestamp() > 0);
                assertEquals(CodecUtil.FOOTER_MAGIC, footerBuffer.getInt());
            if (randomBoolean()) {
                final Translog.Location location = translog.add(
    }
        when(failing.downloadTranslogIfChanged("1", "2", location, String.valueOf(checksum2))).thenThrow(new IOException("boom"));
import org.junit.Before;
        RemoteTranslogTransferTracker statsTracker = translog.getRemoteTranslogTracker();
            TestTranslog.SlowDownWriteSwitch slowDown
        TranslogTransferManager mockTransfer = mock(TranslogTransferManager.class);
    // A default primary term is used by translog instances created in this test.
                unsupportedRepository,
            .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
        return new TranslogConfig(shardId, path, indexSettings, NON_RECYCLING_INSTANCE, bufferSize, nodeId, allocationIdOf(nodeId), false);
        return loc;
            try {
            int count = 0;
            Translog translog = new RemoteFsTranslog(
            () -> globalCheckpoint.get(),
        translog.ensureSynced(loc);
        }
                minSeqNo = SequenceNumbers.min(minSeqNo, seqNo);
            primaryTerm.get()
                                threadId + "_" + opCount,
            );
    protected RemoteFsTranslog translog;
import java.nio.charset.StandardCharsets;
        byte[] damagedBytes = Files.readAllBytes(damagedPath);
                ops.add(op);
        if (random.nextBoolean()) {
        final TranslogConfig temp = getTranslogConfig(tempDir);
                        default:
        } catch (Exception e) {
            Translog.Snapshot snapshot = translog.newSnapshot();
        try (
        assertEquals(newGlobalCheckpoint, ((RemoteFsTranslog) translog).getLastSyncedCheckpoint().globalCheckpoint);
                Translog.Index op = new Translog.Index(randomAlphaOfLength(10), seqNo, primaryTerm.get(), new byte[] { randomByte() });
            toClose.add(snapshot2);
                )
                    assertTrue("at least one operation pending", translog.syncNeeded());
                allocationIdOf("node-1"),
                try {
     * chain's create-if-absent bootstrap: nothing beyond the shard's own identity and the repository is required.
import java.util.concurrent.atomic.AtomicBoolean;
                throw threadExceptions[i];
import java.io.IOException;
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
        translog.rollGeneration();
        ArrayList<Translog.Operation> ops = new ArrayList<>();
                threadId,
        fail.failNever();
    }
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
                assertThat(persistedSeqNos, empty());
        globalCheckpoint.set(initialGlobalCheckpoint);
        logger.info("All data files {}", tlogFiles);
        ArrayList<Translog.Location> locations = new ArrayList<>();
            super.writeBlob(blobName, inputStream, blobSize, failIfAlreadyExists);
                            }
            }
    public void testRangeSnapshot() throws Exception {
            VersionedBlob afterSecond = fenceContainer.readBlobWithVersion(RemoteStoreFence.fenceBlobName(primaryTerm.get()));
        }
     * Metadata whose minimum generation exceeds its maximum would make the reconciliation loop a no-op and the final
                IOUtils.close(reader);
            translog,
        // Apply state once to initialize repo properly like RepositoriesService would
