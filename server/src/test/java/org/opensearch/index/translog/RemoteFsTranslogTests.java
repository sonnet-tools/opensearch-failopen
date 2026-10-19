        ) {  
            ArrayList<Translog.Operation> ops = new ArrayList<>();
            assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
            int bufferSizeInBytes,
            } catch (Exception e) {
public class RemoteFsTranslogTests extends OpenSearchTestCase {
                                lastCommittedLocalCheckpoint.set(localCheckpoint);  
                    final int value = buffer.getInt();
import java.util.concurrent.BlockingQueue;  
    public void testDownloadWithEmptyTranslogOnlyInLocal() throws IOException {
        RemoteFsTranslog.download(mockTransfer, location, logger, false, 0);
                // The footer carries the checksum of header + operations, i.e. of everything the writer has  
        fromSeqNo = randomLongBetween(0, 2000);
        assertThat(persistedSeqNos, empty());
            );  
            BlobContainer fenceContainer = fencedRepository.blobStore().blobContainer(fenceDirectory);
                final boolean isCkpFile = file.getFileName().toString().endsWith(".ckp");  
        verify(manager, times(withoutChecksum.size() + 1)).downloadTranslog(any(), any(), any());
        ArrayList<Translog.Operation> ops = new ArrayList<>();
                @Override
                    translog.rollGeneration();
    }  
        persistedSeqNoConsumer.set(persistedSeqNos::add);
                DefaultRemoteStoreSettings.INSTANCE,  
            );
        RemoteTranslogTransferTracker statsTracker = translog.getRemoteTranslogTracker();
        assertEquals(8, translog.allUploaded().size());
            return true;
        ArrayList<Translog.Location> locations = new ArrayList<>();
            int seqNo = ++count;  
        // download on empty translog should be a no-op  
    // No translog data in local as well as remote, we skip creating empty translog  
import org.apache.lucene.backward_codecs.store.EndiannessReverserUtil;
            Settings.builder()
        );
                config,
        translog.setMinSeqNoToKeep(2);
         * {@link #testBuildTranslogTransferManagerRejectsEmulatedConditionalWrites}, which asserts an unmodified
        // force stopping, if all writers crashed
        for (Path file : FileSystemUtils.files(translogDir)) {
            final long pos = reader.getFirstOperationOffset() + 4 * numOps;
            }
            shardId,  
                }  
                    allocationIdOf("node-1"),  
            }
        for (Thread thread : readers) {
        try {
            int translogOperations = randomIntBetween(10, 100);  
        return getTranslogConfig(path, 0);
        locs.add(addToTranslogAndListAndUpload(translog, ops, new Translog.Index("3", 2, primaryTerm.get(), new byte[] { 1 })));  
            assertThat(snapshot.totalOperations(), equalTo(ops.size()));
        // 4. After drainSync, if an upload is an attempted, we do not upload to remote store.
        RemoteFsTranslog.download(mockTransfer, location, logger, false, 0);  
        assertEquals(newGlobalCheckpoint, ((RemoteFsTranslog) translog).getLastSyncedCheckpoint().globalCheckpoint);  
    public void testSimpleOperationsUpload() throws Exception {
        TranslogTransferManager mockTransfer = mock(TranslogTransferManager.class);
            try {  
        private final TestTranslog.FailSwitch fail;  
import static org.mockito.Mockito.times;  
        Path location = createTempDir();
        // Validate
        for (Translog.Operation op : ops) {
            assertEquals(4, translog.allUploaded().size());
import java.nio.file.Files;  
        addToTranslogAndList(translog, ops, new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));  
                        }
        // Increase primary term
                }  
        assertBusy(() -> assertEquals(1, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size()));  
        }
                            Translog.Operation op;
                assertFalse("no sync needed since no operations in current translog", translog.syncNeeded());
            new ByteSizeValue(1, ByteSizeUnit.KB),
                new RemoteStorePathStrategy(RemoteStoreEnums.PathType.FIXED),  
        Set<String> withChecksum = remoteMetadata.getGenerationToChecksumMapper().keySet();
                        @Override
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
    public void testTrimUnreferencedReadersSkipsRemoteDeletionWhenSuperseded() throws Exception {  
        verify(manager, times(withoutChecksum.size())).downloadTranslog(any(), any(), any());
            try {
            assertThat(snapshot, SnapshotMatchers.size(0));
import java.util.HashSet;  
                false  
    public void testConcurrentWriteViewsAndSnapshot() throws Throwable {
        } catch (IOException e) {  
            assertEquals(4, translog.allUploaded().size());
            VersionedBlob afterFirst = fenceContainer.readBlobWithVersion(RemoteStoreFence.fenceBlobName(primaryTerm.get()));
        final TranslogConfig config = getConfig(1);  
        return currentSeqNo;
            final long readerGeneration = reader.getGeneration();
        translog.trimUnreferencedReaders();  
import org.opensearch.env.TestEnvironment;
            BlobContainer fsContainer = fsBlobStore.blobContainer(BlobPath.cleanPath());
                        if (id % flushEveryOps == 0) {
        logger.info("numDocs={} moreDocs={}", numDocs, moreDocs);  
            final LongConsumer consumer = persistedSeqNoConsumer.get();  
    /**
                fenced.close();
                InputStream stream = new CheckedInputStream(Files.newInputStream(translogPath), new CRC32());
            assertTrue(fenced.getTragicException() instanceof TranslogFencedException);
                assertDownloadStatsNoDownloads(statsTracker);
            max = max(max, location);
    // A default primary term is used by translog instances created in this test.  
            );  
        }
            byte[] bytes = new byte[256];
            byte[] bytes = new byte[256];
    }
        for (int i = 0; i < numOps; i++) {
        final AtomicBoolean run = new AtomicBoolean(true);
        long toSeqNo = Math.min(nextSeqNo - 1, fromSeqNo + 15);
        long minSeqNo = SequenceNumbers.NO_OPS_PERFORMED;
import org.opensearch.env.Environment;  
                        public int write(ByteBuffer src) throws IOException {  
                    primaryTerm.get() - 1
            shardId,  
            for (int i = 0; i < numOps; i++, currentSeqNo++) {
                DefaultRemoteStoreSettings.INSTANCE,
        BlobContainer fenceContainer = freshRepository.blobStore().blobContainer(fenceDirectory(freshRepository));
        try (Translog.Snapshot snapshot = translog.newSnapshot(fromSeqNo, toSeqNo, true)) {
        for (int i = 0; i < readers.length; i++) {
        }
        translogDir = createTempDir();
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("2", 2, primaryTerm.get(), new byte[] { 1 }));  
                        default:  
                    new RemoteStorePathStrategy(RemoteStoreEnums.PathType.FIXED),
        }
import org.opensearch.common.util.concurrent.AbstractRunnable;
        verify(manager).downloadTranslog(any(), Mockito.eq(damaged), any());
                        if (existing != null) {
                .put(Environment.PATH_HOME_SETTING.getKey(), home.toAbsolutePath())  
                translog.add(
    }  
                    Translog.Location loc = add(op);
                    new Translog.Index("" + op, op, primaryTerm.get(), Integer.toString(++count).getBytes(Charset.forName("UTF-8")))  
    public void testSyncUpAlwaysFailure() throws IOException {
            long seqNo;  
                        }
        );
        primaryTerm.set(randomLongBetween(1, Integer.MAX_VALUE));
                        }
        Path[] filesPostFirstDownload = FileSystemUtils.files(location);
        } catch (Exception e) {
        assertEquals(0, statsTracker.getTotalDownloadsSucceeded());
import org.opensearch.index.translog.transfer.TranslogTransferMetadata;  
        Files.createFile(location.resolve(Translog.CHECKPOINT_FILE_NAME));
        byte[] damagedBytes = Files.readAllBytes(damagedPath);
        IllegalArgumentException e = expectThrows(
    public void testStaleTopLevelCheckpointIsRemovedUpFrontAndRecreated() throws IOException {
        Mockito.clearInvocations(manager);  
            reader.readBytes(buffer, pos);  
            // live reader!  
                try {  
                    listener.onFailure(new RuntimeException(e));  
            Throwable e = errors.get(0);
        Path[] filesPostDownload = FileSystemUtils.files(location);
        assertBusy(() -> {  
        final TranslogConfig config = new TranslogConfig(
        }
        translog.trimUnreferencedReaders();  
        TranslogTransferManager finalMockTransfer = mockTransfer;  
        assertBusy(() -> assertEquals(1, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size()));
        }
            minGeneration,  
            return location;  
        return repository;
        }  
    }  
    protected final static String METADATA_DIR = "metadata";
            Translog.Location location = translog.add(op);
            this.translog = translog;
        RemoteFsTranslog.download(succeeding, location, logger, false, 0);
        Releasables.close(releasable);
            threadPool,
    public void testReadLocation() throws IOException {
import org.junit.Before;
        globalCheckpoint.set(initialGlobalCheckpoint);  
                persistedSeqNos::add,
                    Translog.Operation op;
                        if (id % 7 == 0) {
                if (shouldAdd) {  
        final TranslogConfig temp = getTranslogConfig(tempDir);
            terminate(threadPool);
                    shardId,
        verify(mockTransfer).downloadTranslogIfChanged("1", "1", location, String.valueOf(checksum));
        }
            }
            getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))  
                    assertNull(reader.getTranslogChecksum());
        return mockTransfer;
        }
                        long id = idGenerator.getAndIncrement();
            }
        String created = new String(  
        }  
            buffer.flip();
                assertEquals(TranslogFooter.CHECKSUM_ALGORITHM_CRC32, footerBuffer.getInt());
    public void testFullRangeSnapshotWithFailures() throws Exception {
                assertTrue("we only synced a previous operation yet", translog.syncNeeded());  
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));  
                            if (idGenerator.get() < maxOps) {
                    logger.error(() -> new ParameterizedMessage("--> writer [{}] had an error", threadName), e);
        Files.createFile(location.resolve("unrelated.tmp"));  
import static org.mockito.Mockito.verify;
        final AtomicLong idGenerator = new AtomicLong();
        AtomicLong downloadCounter = new AtomicLong();
        translog.setMinSeqNoToKeep(totalDocs);
            }
    }  
    public void testDownloadWithNoTranslogInLocalAndRemote() throws IOException {
    }  
        assertEquals(0, statsTracker.getTotalDownloadTimeInMillis());
                }
            BlobPath blobPath,
        final List<Exception> errors = new CopyOnWriteArrayList<>();  
            for (Translog.Operation op = snapshot.next(); op != null; op = snapshot.next()) {
            false
                addToTranslogAndListAndUpload(translog, ops, new Translog.Index(String.valueOf(1), 1, primaryTerm.get(), new byte[] { 1 }));  
        fail.failNever();
                    final Translog.Operation.Type type = randomFrom(Translog.Operation.Type.values());
            }
    }  
        long checksum2 = createTranslogGeneration(location, 2);
                    throw new RuntimeException(e);
        Path[] filesPostSecondDownload = FileSystemUtils.files(location);
                                // expose the new checkpoint (simulating a commit), before we trim the translog
                    afterAdd();  
    protected final AtomicLong primaryTerm = new AtomicLong();
        ArrayList<Translog.Operation> ops = new ArrayList<>();
import java.util.Random;  
    public void testIncrementalDownloadSkipsMatchingGeneration() throws IOException {  
    }
    public void testTranslogWriter() throws IOException {
            1,
                            }
                allocationIdOf("node-1"),
            SequenceNumbers.NO_OPS_PERFORMED,
            IOUtils.closeWhileHandlingException(toClose);  
        Thread[] threads = new Thread[threadCount];
                        Translog.Location existing = writtenOps.put(op, location);
            this.writtenOperations = writtenOperations;  
                TranslogOperationHelper.DEFAULT,
                }
                assertThat(persistedSeqNos, empty());  
                writer.readBytes(ByteBuffer.allocate(256), 0);
    private class ThrowingBlobContainer extends FsBlobContainer {
                writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), randomNonNegativeLong());
            assertThat(TestTranslog.drainSnapshot(snapshot, false), equalTo(expectedOps));
     * Writes a closed translog generation (header + a few operation bytes + footer) and its checkpoint file at
            fail = currentFail;
            logger.error("Asserting content of {}", readerGeneration);
        // Successful snapshot  
        assertEquals(ex.getMessage(), "translog is already closed");  
    private Environment createEnvironment() {
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
    }  
    }
     * enabled. The caller owns closing it.
                primaryTerm::get,  
                @Override
                        @Override
            super(blobStore, blobPath, path);
            primaryTerm::get,
        verify(mockTransfer, times(1)).readMetadata(0);
        assertEquals(1, translog.readers.size());
                throw new IOException("blob container throwing error");  
            );
        Set<String> tlogFiles = blobStoreTransferService.listAll(
                if (isCkpFile) {  
    private static void assertUploadStatsNoUploads(RemoteTranslogTransferTracker statsTracker) {
        translog.setMinSeqNoToKeep(1);
            RepositoryMetadata metadata,  
import java.io.IOException;  
                fail("io exception expected");
                                primaryTerm.get(),
            if (randomBoolean()) {  
        Collections.shuffle(locations, random());
    protected Path translogDir;
        BlobStoreRepository fencedRepository = createIsolatedRepository();
                translog.rollGeneration(); // empty generation
    }
        Translog.Location max = locations.get(0);
            Collection<TestTranslog.LocationOperation> writtenOperations,
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("3", 2, primaryTerm.get(), new byte[] { 3 }));
                    false,
                ByteBuffer footerBuffer = ByteBuffer.allocate(TranslogFooter.footerLength());  
            .build();
    private final AtomicReference<LongConsumer> persistedSeqNoConsumer = new AtomicReference<>();  
        writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), randomNonNegativeLong());  
            fenced.add(new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
                        public void force(boolean metaData) throws IOException {  
import org.opensearch.test.OpenSearchTestCase;  
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
    public void testSealFenceOnAFreshShardCreatesTheChain() throws Exception {
                translog.sync();
            for (long seqNo : seqNos) {  
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
            translog.getDeletionPolicy().setLocalCheckpointOfSafeCommit(2);
                assertEquals(CodecUtil.FOOTER_MAGIC, footerBuffer.getInt());  
import java.util.Collection;
     */  
            assertThat(snapshot, SnapshotMatchers.size(0));
        }
        Releasable releasable = translog.drainSync();
        }).when(mockTransfer).downloadTranslogIfChanged(any(), any(), any(), any());  
            assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));  
    /** Create a {@link Environment} with random path.home and path.repo **/
        fail.failNever();
        }
                new Translog.Index(String.valueOf(i), i, primaryTerm.get(), new byte[] { (byte) i })  
            Translog.Snapshot snapshot2 = translog.newSnapshot();  
            final Path locationFile = environment.resolveRepoFile(location);
import org.opensearch.index.seqno.LocalCheckpointTrackerTests;
            deletionPolicy,
            ) {
        BlobStoreRepository fencedRepository = createIsolatedRepository();  
        Path location = createTempDir();  
                // Reading at or past the checkpoint offset is EOF: the footer is not addressable through the reader.  
        when(mockTransfer.getRemoteTranslogTransferTracker()).thenReturn(remoteTranslogTransferTracker);
                fencedRepository,  
            channelFactory,
                                .append(committedLocalCheckpointAtView + 1L)  
                assertTrue("at least one operation pending", translog.syncNeeded());
                assertEquals(2, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
                            case INDEX:
            StandardCharsets.UTF_8
            if (rarely()) {
        for (int i = 0; i < numDocs; i++) {
        public void listBlobsByPrefixInSortedOrder(
        for (int op = 0; op < translogOperations; op++) {
                public void onFailure(Exception e) {  
                    DefaultRemoteStoreSettings.INSTANCE,  
            primaryTerm::get,
            if (downloadCounter.incrementAndGet() <= 1) {  
                4,
            shardId,
            }
        ChannelFactory channelFactory = getChannelFactory();
            assertThat(snapshot2, containsOperationsInAnyOrder(ops));  
            expectThrows(TranslogFencedException.class, incumbent::sync);
    }
                threadPool,
            );
                            synchronized (flushMutex) {  
        final BlockingQueue<TestTranslog.LocationOperation> writtenOperations = new ArrayBlockingQueue<>(threadCount * opsPerThread);  
        assertBusy(() -> assertEquals(1, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size()));  
                                threadId + "_" + opCount,
            NamedXContentRegistry namedXContentRegistry,
            for (Translog.Operation op = snapshot.next(); op != null; op = snapshot.next()) {
                // Will flush on read
                new Translog.Index(String.valueOf(op), count, primaryTerm.get(), Integer.toString(count).getBytes(StandardCharsets.UTF_8))
        private final TestTranslog.SlowDownWriteSwitch slowDown;
        });  
        translog.trimUnreferencedReaders();
            this.threadId = threadId;
            }
            temp.getTranslogPath(),
            long fromSeqNo = randomLongBetween(0, minSeqNo - 1);
                final long seqNo = randomValueOtherThanMany(seqNos::contains, () -> randomLongBetween(0, 1000));  
    protected BlobPath getTranslogDirectory() {  
                unsupportedRepository,
                translog.ensureSynced(location);
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index(String.valueOf(0), 0, primaryTerm.get(), new byte[] { 1 }));  
    protected ChannelFactory getChannelFactory() {
        }
    private TranslogConfig getTranslogConfig(final Path path, final Settings settings) {  
                Translog.Index op = new Translog.Index(randomAlphaOfLength(10), seqNo, primaryTerm.get(), new byte[] { randomByte() });
        int count = 0;
                }  
            for (int i = 0; i < numOps; i++) {  
            int count = 0;
                    false,  
import org.opensearch.threadpool.ThreadPool;
        RemoteFsTranslog.download(noChecksum, location, logger, false, 0);  
                if (success == false) {  
            addToTranslogAndListAndUpload(translog, ops, new Translog.Index("3", 2, primaryTerm.get(), new byte[] { 1 }));
    public void testSealFenceClaimsChainAndFencesTheIncumbent() throws Exception {  
                footerBuffer.flip();
                InputStream ckpStream = blobStoreTransferService.downloadBlob(path, Translog.getCommitCheckpointFileName(readerGeneration))
        }
        BlobStoreRepository freshRepository = createIsolatedRepository();  
        int moreDocs = randomIntBetween(3, 10);
        try (Translog.Snapshot snapshot = translog.newSnapshot(seqNo + 1, randomLongBetween(seqNo + 1, Long.MAX_VALUE))) {
        Files.write(damagedPath, damagedBytes);
                throw new IOException("blob container throwing error");
        assertUploadStatsNoFailures(statsTracker);  
        }
                    IOUtils.closeWhileHandlingException(delegate);
            }
        if (shouldFailAlways) {
import org.opensearch.common.bytes.ReleasableBytesReference;
        }  
    }
                                threadId + "_" + opCount,  
                seqNo = opsHaveValidSequenceNumbers ? randomNonNegativeLong() : SequenceNumbers.UNASSIGNED_SEQ_NO;
                true,
            addToTranslogAndListAndUpload(translog, ops, new Translog.Index("2", 1, primaryTerm.get(), new byte[] { 1 }));
                }  
                repository,
            try {
                    translog.ensureSynced(location);
            if (randomBoolean()) {
                translogUUID,  
                        case CREATE:
            idGenerator.set(Long.MAX_VALUE);
                final FileChannel channel;
                )
                )
        Path location = createTempDir();  
                assertEquals(expectedContentChecksum, TranslogFooter.readChecksum(reader.path(), writerCheckpoint.offset));  
                minSeqNo = SequenceNumbers.min(minSeqNo, currentSeqNo);  
    private Translog.Location addToTranslogAndList(Translog translog, List<Translog.Operation> list, Translog.Operation op)
        } catch (MissingHistoryOperationsException e) {
        Set<String> remaining = Arrays.stream(FileSystemUtils.files(location))  
import org.opensearch.common.util.concurrent.ConcurrentCollections;  
        long nextSeqNo = populateTranslogOps(false);
                // closing a tragically-failed translog is expected to rethrow  
            incumbent.add(new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
                4,
        assertEquals(6, translog.allUploaded().size());
        }
            new RemoteTranslogTransferTracker(shardId, 10),  
     * A superseded copy must not delete remote generations: the trim's remote phase is gated fail-closed on fence  
            try {
        }
    private RemoteFsTranslog create(Path path, BlobStoreRepository repository, String translogUUID, boolean isServerSideEncryptionEnabled)
        BlobPath fenceDirectory = fenceDirectory(fencedRepository);  
                } catch (IOException e) {
        i = 0;  
            ArrayList<Translog.Location> locations = new ArrayList<>();
                                primaryTerm.get(),  
            .add(TRANSLOG.getName())  
            if (fail.fail()) {
        final ByteSizeValue bufferSize = randomFrom(
            translog.setMinSeqNoToKeep(i);
                () -> Boolean.TRUE,
        }
            incumbent.sync();
        throws IOException {
import java.util.concurrent.atomic.AtomicInteger;
    class TranslogThread extends Thread {
            }
                    EOFException.class,
        try (RemoteFsTranslog incumbent = createFencedTranslog("node-current", fencedRepository)) {
            if (fail.fail()) {
                try {
                );  
        TranslogTransferManager finalMockTransfer = mockTransfer;
        TranslogTransferMetadata translogTransferMetadata = new TranslogTransferMetadata(primaryTerm, generation, generation, 1);  
        long initialGlobalCheckpoint = 0L;  
            translog.getDeletionPolicy().assertNoOpenTranslogRefs();  
    }  
                final boolean isCkpFile = file.getFileName().toString().endsWith(".ckp");  
        long newGlobalCheckpoint = 1L;  
            if (randomBoolean()) {  
                            }
        ArrayList<Translog.Location> locs = new ArrayList<>();
        for (int i = 0; i < iters; i++) {
        Path location = createTempDir();
                }
        }  
        return createTranslogInstance(translogConfig, translogUUID, deletionPolicy, isServerSideEncryptionEnabled);
        assertTrue(Files.exists(translogDir.resolve(Translog.getFilename(1))));
                                expectedOps.remove(op);  
import static org.hamcrest.Matchers.containsString;
                assertUploadStatsNoFailures(statsTracker);  
        BlobStoreRepository fencedRepository = createIsolatedRepository();
                false,
        translog.setMinSeqNoToKeep(totalDocs - 1);
                                break;
    }  
        }  
            CountDownLatch downLatch,
    public void testExtraGenToKeep() throws Exception {
                            }
        writeCalls = new AtomicInteger();
                    switch (type) {  
        createTranslogGeneration(location, 3);
import java.io.EOFException;
                // Since the buffer is full, this will flush before performing the add.
        @Override  
                                seqNoGenerator.getAndIncrement(),
        Path location = createTempDir();  
@LuceneTestCase.SuppressFileSystems("ExtrasFS")
        for (String generation : withChecksum) {  
            translog.trimUnreferencedReaders();
        long maxSeqNo = SequenceNumbers.NO_OPS_PERFORMED;
            assertThat(snapshot, containsOperationsInAnyOrder(ops));  
        }  
            String afterFirstContent = new String(afterFirst.content(), StandardCharsets.UTF_8);
            BlobContainer fenceContainer = fencedRepository.blobStore().blobContainer(fenceDirectory(fencedRepository));
                        }
            thread.join();
        }
                    }
            List<Translog.Operation> ops = new ArrayList<>(seqNos.size());
        boolean isServerSideEncryptionEnabled  
            final Checkpoint writerCheckpoint = writer.getCheckpoint();  
        @Override  
                e.addSuppressed(suppress);
        }
import static org.hamcrest.Matchers.greaterThan;
                }
            translog.ensureSynced(loc);  
            assertTrue(sealed, sealed.contains("|" + (primaryTerm.get() + 1) + "|" + allocationIdOf("node-new") + "|node-new|"));  
            assertThat(persistedSeqNos, contains(1L, 2L, 3L, 4L));
        final Object signalReaderSomeDataWasIndexed = new Object();  
            config.getTranslogPath(),
                Translog.Index op = new Translog.Index(randomAlphaOfLength(10), seqNo, primaryTerm.get(), new byte[] { randomByte() });
                    int counter = 0;  
            terminate(threadPool);
        assertBusy(() -> {
import java.nio.ByteBuffer;
                    false,
    }
            this.slowDown = slowDown;
        ArrayList<Translog.Operation> ops = new ArrayList<>();
            throws IOException {  
                opsList.add(op);  
 * this file be licensed under the Apache-2.0 license or a
        @Override
                translog.ensureSynced(location);  
        final AtomicLong lastCommittedLocalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            return new ThrowingBlobStore(bufferSize, locationFile, isReadOnly(), fail, slowDown);  
        private final Collection<TestTranslog.LocationOperation> writtenOperations;  
            assertEquals(2, checkpointFsyncCalls.get());
        TranslogConfig config = getTranslogConfig(path, settings, nodeId);
        assertTrue(translog.syncNeeded());  
            } catch (Exception t) {
            this.threadExceptions = threadExceptions;
        metadata.setGenerationToPrimaryTermMapper(generationToPrimaryTermMapper);  
            } else {
        public void run() {  
    }  
                writtenOperations,
        }
        // Change primary term and test the deletion of older primaries
        TranslogTransferMetadata remoteMetadata = manager.readMetadata();
        verify(manager, times(remoteGenerations)).downloadTranslog(any(), any(), any());
     * Creates a repository that is isolated from the one backing {@link #translog}, so that a second translog  
     * The advertised checksum for each generation is handed to the transfer manager, which owns the decision to  
            }, threadId);
        globalCheckpoint.set(newGlobalCheckpoint);
                afterFirstContent.contains("|" + primaryTerm.get() + "|" + allocationIdOf("node-1") + "|node-1|")
    /**  
            xContentRegistry(),
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));  
import org.opensearch.test.IndexSettingsModule;
                }
import org.apache.lucene.tests.util.LuceneTestCase;
            assertNotEquals(afterFirst.versionToken(), afterSecond.versionToken());  
        assertEquals(1, translog.readers.size());
            RemoteTranslogTransferTracker statsTracker = translog.getRemoteTranslogTracker();
            1  
                file.getFileName().toString(),
        assertThat(reader.getCheckpoint().maxSeqNo, equalTo(maxSeqNo));
                assertThat(snapshot.totalOperations(), equalTo(0));
            config,  
        // Add a new operation and sync
                maxSeqNo = SequenceNumbers.max(maxSeqNo, seqNo);
            this.downLatch = downLatch;  
            );
        }
                channelFactory,
            filesPostDownload[0].getFileName().toString().contains("translog.ckp")
        long newPrimaryTerm = primaryTerm.incrementAndGet();  
    private static void assertUploadStatsNoFailures(RemoteTranslogTransferTracker statsTracker) {
        }
        Path location = createTempDir();
                assertThrows(
        TranslogTransferMetadata inverted = new TranslogTransferMetadata(1, 3, 5, 0);
            assertThat(snapshot.totalOperations(), equalTo(ops.size()));
        long toSeqNo = Math.min(nextSeqNo - 1, fromSeqNo + 15);  
            TestTranslog.SlowDownWriteSwitch slowDown
            }
        } catch (Exception e) {
        assertTrue(translog.isOpen());
            translog.add(  
                final byte[] bytes = new byte[4];
        doAnswer(invocation -> {
        } finally {
    private BlobStoreRepository createIsolatedRepository() {  
                    throw new RuntimeException(e);  
            when(emulatedRepository.basePath()).thenReturn(BlobPath.cleanPath());
    }
            BlobStoreRepository emulatedRepository = mock(BlobStoreRepository.class);
                threadPool,  
    /**  
     * incumbent's token immediately - without the new copy having uploaded anything. This is what stops a previous  
            expectThrows(TranslogFencedException.class, fenced::sync);
                && newEmptyTranslogCheckpoint.maxSeqNo == SequenceNumbers.NO_OPS_PERFORMED
            final int value = buffer.getInt();
        // assert content of ckp and tlog files
                totOps++;
        assertFalse(translog.syncNeeded());  
        }
            when(emulatedRepository.blobStore(anyBoolean())).thenReturn(blobStore);  
                        logger.error("unexpected error while closing view, after failure", inner);
                                translog.trimUnreferencedReaders();  
        verify(mockTransfer).downloadTranslogIfChanged("1", "1", location, String.valueOf(checksum1));
        threadPool = new TestThreadPool(getClass().getName());  
        Checkpoint newEmptyTranslogCheckpoint = Translog.readCheckpoint(location);  
                    retentionLock = translog.acquireRetentionLock();
            newTranslog.setMinSeqNoToKeep(i);
        assertThat(withoutChecksum, anyOf(empty(), contains(String.valueOf(minGeneration))));  
            new ByteSizeValue(10 + randomInt(128 * 1024), ByteSizeUnit.BYTES)
        int count = 0;  
            int initialWriteCalls = writeCalls.get();
        assertEquals(0, statsTracker.getDownloadBytesSucceeded());  
        TranslogTransferManager mockTransfer = mockTransferManagerFor(metadataFor(2, 2, Map.of(2L, checksum2)));
                                op = new Translog.Index("" + id, id, primaryTerm.get(), new byte[] { (byte) id });  
import org.apache.lucene.tests.mockfile.FilterFileChannel;
        final TranslogConfig translogConfig = getTranslogConfig(path, extraGenToKeep);
                threadExceptions  
        }
    /**  
        CRC32 crc = new CRC32();
        long generation = 1, primaryTerm = 1;
                expectedContentChecksum = Long.valueOf(checksumOf(writer.path(), syncedCheckpoint.offset));  
        TranslogTransferManager mockTransfer = mock(TranslogTransferManager.class);
            assertThat(snapshot, SnapshotMatchers.equalsTo(ops));
        List<Translog.Location> locations = new ArrayList<>();  
        int iters = randomIntBetween(5, 10);
                translogUUID,  
        String translogUUID = translog.translogUUID;
import java.nio.file.NoSuchFileException;
                DefaultRemoteStoreSettings.INSTANCE,  
        Map<Long, List<Translog.Operation>> operationsByGen = new HashMap<>();
                fail.failAlways();  
        final int opsPerThread = randomIntBetween(10, 200);
        }
        Settings settings = Settings.builder().put("location", randomAlphaOfLength(10)).build();
        RemoteFsTranslog fenced = createFencedTranslog("node-old", fencedRepository);
        final String translogUUID = Translog.createEmptyTranslog(path, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());  
    }  
                    // recovery logic which captures a view and gets a lucene commit  
            byte[] bytes = new byte[4];  
        for (int op = 0; op < translogOperations; op++) {
        if (errors.size() > 0) {
        assertBusy(() -> assertEquals(1, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size()));
 */  
        assertTrue(statsTracker.getLastSuccessfulUploadTimestamp() > 0);  
        BlobStore blobStore = mock(BlobStore.class);
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
        when(unsupportedRepository.basePath()).thenReturn(BlobPath.cleanPath());
        assertBusy(() -> assertEquals(2 + 2L * moreDocs, translog.allUploaded().size()));
    }
        // simulating the remote segment upload .
                return;  
        RemoteTranslogTransferTracker remoteTranslogTransferTracker = mock(RemoteTranslogTransferTracker.class);  
            : translog.openReader(writer.path(), Checkpoint.read(translog.location().resolve(Translog.CHECKPOINT_FILE_NAME)));
        TranslogTransferManager mockTransfer = mockTransferManagerFor(metadataFor(1, 2, Map.of(1L, checksum1, 2L, 5678L)));
        if (a.compareTo(b) > 0) {
        return repository.basePath().add(shardId.getIndex().getUUID()).add(String.valueOf(shardId.id())).add(TRANSLOG.getName());
        translog.setMinSeqNoToKeep(3);
        when(mockTransfer.downloadTranslogIfChanged(any(), any(), any(), any())).thenThrow(toThrow).thenReturn(true);
    public void testConcurrentWritesWithVaryingSize() throws Throwable {
                && newEmptyTranslogCheckpoint.minSeqNo == SequenceNumbers.NO_OPS_PERFORMED
                        }
        assertFalse(Files.exists(location.resolve(Translog.CHECKPOINT_FILE_NAME)));  
                        if (expectedOps.isEmpty() == false) {  
            TestTranslog.SlowDownWriteSwitch slowDown  
                    }
            Set<Long> seqNos = new HashSet<>();  
        // Case 2 - During an upload, if drainSync is called, it will wait for it to acquire and available permits are 0.  
        for (Translog.Location location : locations) {  
import org.opensearch.index.remote.RemoteStoreEnums;
            getPersistedSeqNoConsumer(),
import static org.hamcrest.Matchers.anyOf;
            new Translog.Index(String.valueOf(2), 2, primaryTerm.get(), new byte[] { 1 })  
                translog.add(op);
        long minSeqNo = SequenceNumbers.NO_OPS_PERFORMED;
            TranslogOperationHelper.DEFAULT,
                locations.add(location);
            translog.rollGeneration();  
        };
                fail("read past EOF?");  
                translog.rollGeneration();  
        assertEquals(initialGlobalCheckpoint, ((RemoteFsTranslog) translog).getLastSyncedCheckpoint().globalCheckpoint);
        // Case 1 - During ongoing uploads, the available permits are 0.
        assertEquals(6, translog.allUploaded().size());
                    new RemoteTranslogTransferTracker(shardId, 10),  
                writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 5);
            primaryMode::get,
        int translogOperations = randomIntBetween(10, 100);  
                translog.rollGeneration();
                            }
        return loc;  
        // A successful one recreates it from the latest generation's checkpoint.
            translog.close();  
                            checkpointFsyncCalls.incrementAndGet();
import java.util.Collections;  
 *
                new RemoteTranslogTransferTracker(shardId, 10),
     */
        return fencedRepository.basePath()  
    public void testMetadataFileDeletion() throws Exception {
     * primary that is still alive from acknowledging writes landing after the new copy's restore point.
            assertNull(snapshot.next());
     * the download reconciles the remaining generations.
        );  
                                // deletionPolicy.setLocalCheckpointOfSafeCommit(localCheckpoint);
    @Before
        );
            temp.getShardId(),  
        }
        }
        return new RemoteFsTranslog(
        final LocalCheckpointTracker tracker = LocalCheckpointTrackerTests.createEmptyTracker();  
        when(mockTransfer.readMetadata()).thenReturn(translogTransferMetadata);
        private final CountDownLatch downLatch;  
            this.opsPerThread = opsPerThread;
                assertThat(persistedSeqNos, empty());
                out.writeInt(i);  
            assertEquals(4, translog.allUploaded().size());
    public void testFullRangeSnapshot() throws Exception {
        return nodeId.isEmpty() ? "" : nodeId + "-alloc";  
        byte[] bytes = Files.readAllBytes(path);  
            assertFalse("all of the locations should be synced: " + location, translog.ensureSynced(location));
        try (Translog.Snapshot snap = new TestTranslog.SortedSnapshot(translog.newSnapshot())) {
            new Translog.Index(String.valueOf(totalDocs), totalDocs, primaryTerm.get(), new byte[] { 1 })  
        locs.add(addToTranslogAndListAndUpload(translog, ops, new Translog.Index("2", 1, primaryTerm.get(), new byte[] { 1 })));
        assertTrue(locations[1].compareTo(locations[2]) < 0);
            }  
                CheckedInputStream stream = new CheckedInputStream(Files.newInputStream(checkpointPath), new CRC32());  
        return metadata;
        when(mockTransfer.readMetadata(0)).thenReturn(translogTransferMetadata);  
        return crc.getValue();  
        // Delete translog files to test download flow
        // Case 3 - After drainSync, if trimUnreferencedReaders is attempted, we do not delete from remote store.  
        ArrayList<Translog.Operation> ops = new ArrayList<>();  
        } finally {  
    AtomicInteger writeCalls = new AtomicInteger();
        private final Translog translog;
            assertThat(persistedSeqNos, empty());
                        closeRetentionLock();
        when(mockTransfer.downloadTranslogIfChanged("1", "1", location, String.valueOf(checksum))).thenReturn(false);
 * The OpenSearch Contributors require contributions made to  
        RemoteTranslogTransferTracker remoteTranslogTransferTracker = mock(RemoteTranslogTransferTracker.class);
            slowDown = currentSlowDown;
    private Long populateTranslogOps(boolean withMissingOps) throws IOException {
                final Checkpoint readerCheckpoint = reader.getCheckpoint();
    }
            assertThat(snapshot, SnapshotMatchers.size(0));  
        RemoteFsTranslog incumbent = createFencedTranslog("node-old", fencedRepository);
            toClose.add(snapshot);
        Path tempDir = createTempDir();  
                shardId,  
                maxOp = next;
     * download that fails leaves the directory without one rather than with a checkpoint naming a generation from a
    public class ThrowingBlobRepository extends FsRepository {
import org.opensearch.index.remote.RemoteStorePathStrategy;
            }
        when(failing.downloadTranslogIfChanged("1", "2", location, String.valueOf(checksum2))).thenThrow(new IOException("boom"));
        for (int i = 0; i < threadCount * opsPerThread; i++) {
            this.fail = fail;
                            translogFsyncCalls.incrementAndGet();  
            translogConfig,  
import org.opensearch.cluster.metadata.RepositoryMetadata;
                    barrier.await();
    }
        TranslogTransferManager mockTransfer = mockTransferManagerFor(inverted);
     */
        final TestTranslog.FailSwitch currentFail = fail;
                                assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
        TranslogDeletionPolicy deletionPolicy = createTranslogDeletionPolicy(config.getIndexSettings());
            RemoteFsTranslog.sealFence(
    public void testSyncUpTo() throws IOException {
        BlobStoreRepository repository,  
    }
            fenced.sync();
        DataOutput out = EndiannessReverserUtil.wrapDataOutput(new ByteArrayDataOutput(bytes));
        });
        BlobStoreRepository fencedRepository = createIsolatedRepository();
            assertTrue(e.getMessage().contains("Not all operations between from_seqno"));  
        assertBusy(() -> {
    public void testReadLocationDownload() throws IOException {
                || filesPostDownload[1].getFileName().toString().contains("translog.ckp")  
        }
        assertTrue(statsTracker.getUploadBytesStarted() > 0);  
    // from local file system and create empty translog  
            clusterService,
            for (long seqNo : seqNos) {  
        // Every generation closed by a writer carries a footer and therefore advertises a checksum. The only
        TranslogTransferManager mockTransfer = mock(TranslogTransferManager.class);
        addToTranslogAndList(translog, ops, new Translog.NoOp(seqNo, noopTerm, reason));  
        collect.sort(Comparator.comparing(op -> op.operation.seqNo()));
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
            .map(p -> p.getFileName().toString())
        globalCheckpoint.set(newGlobalCheckpoint);
        TranslogTransferManager succeeding = mockTransferManagerFor(metadataFor(2, 2, Map.of(2L, checksum2)));  
        private final TestTranslog.FailSwitch fail;
    public void testUploadWithPrimaryModeTrue() {  
                    DefaultRemoteStoreSettings.INSTANCE,
            assertEquals(initialWriteCalls, writeCalls.get());
                    channel = new FilterFileChannel(delegate) {
    }
                    new RemoteStorePathStrategy(RemoteStoreEnums.PathType.FIXED),
        final int generations = between(2, 20);
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
    }  
                false  
            assertThat(snapshot, SnapshotMatchers.equalsTo(ops));
                    Thread.sleep(slowDown.getSleepSeconds() * 1000L);
                deletionPolicy,
            fenced.trimUnreferencedReaders(); // gated: skips the remote deletion, does not throw
import org.opensearch.common.util.io.IOUtils;
                        expectedOps.removeIf(op -> op.seqNo() <= committedLocalCheckpointAtView);
            translog.rollGeneration();  
    private static String allocationIdOf(String nodeId) {
    public void testSyncUpLocationFailure() throws IOException {  
         * Overriding lets the fence be exercised without weakening the production guard - see
                primaryTerm::get,  
        assertEquals(1, translog.readers.size());
        List<Translog.Operation> operations = List.of(
    }
        if (random.nextBoolean()) {
            }
import org.opensearch.index.translog.transfer.FileTransferTracker;
        String translogUUID = Translog.createEmptyTranslog(
        logger.debug("--> waiting for threads to stop");  
        // any errors on threads
        this.repository = repository;
import org.opensearch.index.seqno.SequenceNumbers;  
        int newPrimaryTermDocs = randomIntBetween(5, 10);
                new DefaultTranslogDeletionPolicy(-1, -1, 0),
        }
        assertEquals(6, translog.allUploaded().size());
        for (TranslogReader reader : translog.readers) {  
    }
package org.opensearch.index.translog;
        );  
    }  
                            case NO_OP:
        assertEquals(2, translog.readers.size());
        // a map of all written ops and their returned location.
                    () -> finalReader.readBytes(ByteBuffer.allocate(8), finalReader.getFirstOperationOffset() + numOps * 4 - 4)
                "node-1"  
            IllegalArgumentException e = expectThrows(
        try (RemoteFsTranslog fenced = createFencedTranslog("node-1", fencedRepository)) {
                final Translog.Location location = translog.add(
        } else {
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 3);
        try (FsBlobStore fsBlobStore = new FsBlobStore(1024, createTempDir(), false)) {
            .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
            }
        assertEquals(0, statsTracker.getUploadBytesStarted());
        List<Closeable> toClose = new ArrayList<>();  
        private final Environment environment;
                Closeable retentionLock = null;
            Collections.shuffle(seqNos, new Random(100));
     * chain's create-if-absent bootstrap: nothing beyond the shard's own identity and the repository is required.  
        RemoteTranslogTransferTracker statsTracker = translog.getRemoteTranslogTracker();
        } finally {
        assertFalse(withChecksum.isEmpty());
            operationsByGen.put(translog.currentFileGeneration(), ops);
    protected final ShardId shardId = new ShardId("index", "_na_", 1);
            // The incumbent now holds a stale token and cannot acknowledge another write
            this.slowDown = slowDown;  
            writer.sync();
                success = true;
        assertEquals(6, translog.allUploaded().size());  
            threads[i] = new TranslogThread(
                );
            final String threadId = "reader_" + i;  
        long toSeqNo = randomLongBetween(fromSeqNo, Long.MAX_VALUE);
                @Override
                        // these are what we expect the snapshot to return (and potentially some more).  
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
        Path path,
        assertTrue(statsTracker.getTotalUploadsStarted() > 0);
                throw threadExceptions[i];
        boolean isServerSideEncryptionEnabled  
    /**
            .add(shardId.getIndex().getUUID())
        assertEquals(0, statsTracker.getUploadBytesSucceeded());
            }
        try (Translog.Snapshot snapshot = translog.newSnapshot(fromSeqNo, toSeqNo)) {
        // 2. During an upload, if drainSync is called, it will wait for it to acquire and available permits are 0.
            FileChannel delegate = FileChannel.open(file, openOption);
            assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
            this.fail = fail;
                                // we're committing - is still present when we're committing
        );
                }  
            assertThat(snapshot, containsOperationsInAnyOrder(ops));  
     * worse than running unfenced because each shard would report itself protected. Uses a real {@link FsBlobStore}  
                        retentionLock.close();
        Path location = createTempDir();  
        } finally {
                            case DELETE:
        int translogOperations = randomIntBetween(1, 20);
     * content checksum that ended up in the footer.
                        // captures al views that are written since the view was created (with a small caveat see bellow)
            // Fencing is fatal for the shard copy: the translog is marked with a tragic event  
    }
            ops,
import org.opensearch.indices.DefaultRemoteStoreSettings;
        long currentSeqNo = 0L;
import java.util.Set;
        assertEquals(1, translog.readers.size());
        }
            primaryTerm.get()  
            assertThat(persistedSeqNos, contains(1L, 2L, 3L, 4L, 5L));
        // 1. During ongoing uploads, the available permits are 0.
                config,
        logger.debug("--> waiting for readers to stop");
            Files.delete(file);
                return channel;
        TranslogTransferManager manager = Mockito.spy(translog.translogTransferManager);  
                                op = new Translog.Delete(Long.toString(id), id, primaryTerm.get());  
        );  
    }
            }
            }
        boolean shouldFailAlways = randomBoolean();
        when(succeeding.downloadTranslogIfChanged("1", "2", location, String.valueOf(checksum2))).thenReturn(false);
        for (Path file : FileSystemUtils.files(translogDir)) {  
        Translog.Location loc = addToTranslogAndListAndUpload(  
            addToTranslogAndListAndUpload(newTranslog, ops, new Translog.Index(String.valueOf(i), i, primaryTerm.get(), new byte[] { 1 }));  
        RemoteFsTranslog.download(mockTransfer, location, logger, false, 0);
                for (int i = 0; i < numOps; i++) {
            if (fail.fail()) {
        } finally {
        when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(container);
            Math.toIntExact(maxGeneration - minGeneration + 1)
                shardId,
        final AtomicInteger translogFsyncCalls = new AtomicInteger();
            try {
    }  
        @Override
        final Set<Long> seenSeqNos = new HashSet<>();  
                        }  
        for (int i = 0; i < writers.length; i++) {
    }  
        }  
    }
                assertFalse("the last call to ensureSycned synced all previous ops", translog.syncNeeded());
        logger.info("All data files {}", tlogFiles);
    }  
                translog.sync();  
        TranslogConfig config = getConfig(1);  
        Translog.Location loc = translog.add(op);  
import java.util.concurrent.CountDownLatch;
                false  
    public void testIncrementalDownloadFetchesOnlyMissingGenerations() throws IOException {
    private static void assertDownloadStatsPopulated(RemoteTranslogTransferTracker statsTracker) {  
            writers[i].start();
                assertFalse("translog has been synced already", translog.ensureSynced(location));
            translogUUID,
        assertUploadStatsNoUploads(statsTracker);
        // This should not trim tlog-2.* files from remote as we not uploading any more translog to remote
                threadId,  
        verify(mockTransfer).downloadTranslogIfChanged("1", "2", location, "5678");  
     */  
    protected final static String DATA_DIR = "data";  
            createTranslogGeneration(location, 2);
        translog.trimUnreferencedReaders();
            translog.sync();
        for (int i = 0; i < numOps; i++) {  
            this.environment = environment;  
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));  
        }
            contentAfterFirst.put(file.getFileName().toString(), Files.readAllBytes(file));
            threads[i].join(60 * 1000);  
        String translogUUID = translog.translogUUID;  
        assertNull(translog.readOperation(new Translog.Location(100, 0, 0)));
            writer.sync();  
     * single JVM, so it must be refused: two nodes sharing a filesystem would both believe they held the fence, which is
        globalCheckpoint.set(newGlobalCheckpoint);
                );  
            Path checkpointPath = translog.location().resolve(Translog.getCommitCheckpointFileName(readerGeneration));
                    try {  
        try {
        String translogUUID = Translog.createEmptyTranslog(
        translog.trimUnreferencedReaders();  
import org.opensearch.common.blobstore.BlobStore;
import java.util.concurrent.CyclicBarrier;  
    }  
            new RemoteStoreFence(fenceContainer, allocationIdOf("node-new"), "node-new", shardId).validateAndAdvance(primaryTerm.get() + 1);
        translog.sync();
        TranslogThread(
        RemoteFsTranslog.download(manager, location, logger, false, 0);  
        try {  
        Map<String, String> generationToChecksumMapper = new HashMap<>();
        verify(mockTransfer).downloadTranslogIfChanged("1", "2", location, String.valueOf(checksum2));
    private static TranslogTransferMetadata metadataFor(long minGeneration, long maxGeneration, Map<Long, Long> checksums) {
            new ByteSizeValue(8, ByteSizeUnit.KB),
        // To simulate that the node is remote backed
        }
            assertNotEquals(afterFirstContent, new String(afterSecond.content(), StandardCharsets.UTF_8));
         * Test support only. {@link FsBlobContainer} reports {@code false} because its conditional write is emulated per
            temp.getBigArrays(),  
                .put(Environment.PATH_REPO_SETTING.getKey(), home.resolve("repo").toAbsolutePath())
            newTranslog.close();
    public static Translog.Location max(Translog.Location a, Translog.Location b) {  
            for (Translog.Location location : locations) {
                                fail(missed.toString());  
import org.opensearch.index.translog.transfer.BlobStoreTransferService;
        List<Translog.Operation> opsList = new ArrayList<>(threadCount * opsPerThread);  
        long fromSeqNo = randomLongBetween(maxSeqNo + 1, Long.MAX_VALUE);  
                IOUtils.close(reader);
        fail.failAlways();
        private final Exception[] threadExceptions;
        }  
            temp.getIndexSettings(),
                assertEquals(expectedContentChecksum, reader.getTranslogContentChecksum());
import org.opensearch.index.translog.transfer.TranslogTransferManager;
        assertTrue(translog.ensureSynced(locations[locations.length - 1]));
                }
        TranslogTransferManager mockTransfer = mock(TranslogTransferManager.class);
    }  
        addToTranslogAndListAndUpload(  
            }  
        RemoteTranslogTransferTracker remoteTranslogTransferTracker = mock(RemoteTranslogTransferTracker.class);  
            }  
        Map<String, String> generationToPrimaryTermMapper = new HashMap<>();
        ArrayList<Translog.Location> locs = new ArrayList<>();  
            Path path,  
            locations.add(
            BlobNameSortOrder blobNameSortOrder,
        assertEquals(1 + moreDocs, translog.readers.size());  
            translog.rollGeneration();  
                }  
                        @Override
                fenceContainer.readBlobWithVersion(RemoteStoreFence.fenceBlobName(primaryTerm.get() + 1)).content(),  
        }
            // A higher term takes the fence out of band.  
                // not syncing now
        opsList.sort(Comparator.comparing(op -> op.seqNo()));  
                    // captures the last committed checkpoint, while holding the view, simulating
        BlobContainer container = mock(BlobContainer.class);
        final BaseTranslogReader reader = randomBoolean()  
            if (rarely()) {
            if (slowDown.getSleepSeconds() > 0) {
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 2);  
            assertEquals(
                            }
            super.writeBlobAtomic(blobName, inputStream, blobSize, failIfAlreadyExists);
        int numDocs = randomIntBetween(6, 10);
        assertTrue(statsTracker.getTotalUploadsStarted() > 0);  
    /** Allocation ids in these tests are derived from the node id so both identities stay legible in assertions. */
        );  
        for (long g = minGeneration; g <= maxGeneration; g++) {
            RemoteFsTranslog translog = new RemoteFsTranslog(
        assertThat(translog.totalOperations(), equalTo(operations.size()));  
                            while ((op = snapshot.next()) != null) {
            throw e;  
    public void testTranslogWriterCanFlushInAddOrReadCall() throws IOException {
/*  
        translog.ensureSynced(loc);  
        }
    public void testSnapshotOnClosedTranslog() throws IOException {
        // Close the translog
        public BlobContainer blobContainer(BlobPath path) {
            FsBlobStore blobStore,
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
            ByteBuffer buffer = ByteBuffer.allocate(4);
        return channelFactory;
        assertDownloadStatsNoDownloads(statsTracker);  
                byte[] tlog = tlogStream.readAllBytes();  
        } else {
    }
        final TranslogConfig config = new TranslogConfig(
            final Translog.Location location = translog.add(
                    errors.add(e);
        return create(path, repository, translogUUID, 0, isServerSideEncryptionEnabled);
        // 3. After drainSync, if trimUnreferencedReaders is attempted, we do not delete from remote store.  
                @Override  
            );  
        globalCheckpoint.set(initialGlobalCheckpoint);
            List<Long> seqNos = new ArrayList<>();  
                false,
        }  
                                long localCheckpoint = tracker.getProcessedCheckpoint();  
        ) {  
            out.writeInt(i);
                assertEquals(writerCheckpoint.offset, reader.sizeInBytes());
    public void testSyncUpToStream() throws IOException {  
            assertArrayEquals(
    /**  
                seqNos.add(currentSeqNo);
        }
        final Set<Long> persistedSeqNos = new HashSet<>();
    private BlobPath fenceDirectory(BlobStoreRepository fencedRepository) {
            assertTrue(statsTracker.getTotalUploadsFailed() > 0);  
        when(mockTransfer.getRemoteTranslogTransferTracker()).thenReturn(remoteTranslogTransferTracker);
        assertEquals(3, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());
        logger.info("using [{}] readers. [{}] writers. flushing every ~[{}] ops.", readers.length, writers.length, flushEveryOps);
            }  
    }  
         */
            protected void assertSnapshotOrGenericThread() {
                        switch (type) {  
            assertEquals(1, translogFsyncCalls.get());  
     * End to end against the real (filesystem backed) transfer manager: generations uploaded by this translog are
            config.getTranslogPath(),
            IllegalArgumentException.class,
                listener.onFailure(new RuntimeException("blob container throwing error"));
        translog.sync();  
        barrier.await();
            Files.readAllBytes(location.resolve(Translog.getCommitCheckpointFileName(2))),
    }
                    assertEquals(i, value);  
import org.opensearch.common.blobstore.fs.FsBlobStore;
    @Override
                        }
import java.util.concurrent.CopyOnWriteArrayList;
        }
            }
                }  
        slowDown.setSleepSeconds(2);
     * Creates a second translog instance for the same shard, on its own repository, with remote store fencing
            shardId,
            Translog translog = new RemoteFsTranslog(
                maxSeqNo = SequenceNumbers.max(maxSeqNo, currentSeqNo);
            .build();  
        translog.close();
        }
            translog.getDeletionPolicy().assertNoOpenTranslogRefs();
        assertTrue(
        slowDown = new TestTranslog.SlowDownWriteSwitch();  
    }
        translog.trimUnreferencedReaders();
                            throw new AssertionError("unsupported operation type [" + type + "]");
        }  
import org.opensearch.index.translog.transfer.TranslogUploadFailedException;
import static org.opensearch.index.IndexSettings.INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING;
                seqNos.add(seqNo);  
        assertEquals(2, translog.readers.size());  
        long maxSeqNo = SequenceNumbers.NO_OPS_PERFORMED;  
            // we can remove this try-catch block
                throw new NoSuchFileException("File not found");
import java.util.Arrays;
                    errors.add(e);
            primaryTerm.get()  
        assertDownloadStatsNoDownloads(statsTracker);
            expectThrows(  
            Translog translog = new RemoteFsTranslog(
        for (int op = 0; op < translogOperations; op++) {  
        // if a previous test failed we clean up things here  
    }
import java.util.concurrent.atomic.AtomicBoolean;
                    // A re-opened reader recovers the content checksum from the footer but cannot know the
        int totalDocs = numDocs + moreDocs;
                    logger.error(() -> new ParameterizedMessage("--> reader [{}] had an error", threadId), e);
                    new FileTransferTracker(shardId, new RemoteTranslogTransferTracker(shardId, 10)),
                    };
            translog,
                try {
                assertArrayEquals(tlog, content);
            if (firstGenOps == null) {  
                            op = new Translog.Delete(
                seqNo = ++count;  
        Set<String> withoutChecksum = new HashSet<>();  
        ArrayList<Translog.Operation> ops = new ArrayList<>();
            addToTranslogAndListAndUpload(translog, ops, new Translog.Index(String.valueOf(i), i, primaryTerm.get(), new byte[] { 1 }));  
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 1);  
        inverted.setGenerationToChecksumMapper(Map.of());  
            } catch (IOException ex) {
            }
                    threadPool,  
        logger.info("--> test done. total ops written [{}]", writtenOps.size());
    }
        // Verify that sync is not needed
            } catch (IOException e) {  
    /**  
        final int maxOps = randomIntBetween(20, 100);
        // download first time will ensure creating empty translog
import org.opensearch.common.lease.Releasables;
            assertNotNull(maxOp);
    }
import java.util.Map;
            boolean success = false;  
        ArrayList<Translog.Operation> ops = new ArrayList<>();  
     * index UUID - seals against a repository holding no fence for its shard. The seal is then simply the fresh
                new RemoteStorePathStrategy(RemoteStoreEnums.PathType.FIXED),
            config.getTranslogPath(),
        assertArrayEquals(contentAfterFirst.get(damagedPath.getFileName().toString()), Files.readAllBytes(damagedPath));  
            FileChannel delegate = FileChannel.open(file, openOption);
            this.fail = fail;
        translog.trimUnreferencedReaders();  
        String translogUUID = Translog.createEmptyTranslog(path, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());  
        Path location = createTempDir();
                return channel;
                assertTrue("at least one operation pending", translog.syncNeeded());
                        // slow down things a bit and spread out testing..  
                return new ThrowingBlobContainer(this, path, buildAndCreate(path), fail, slowDown);  
                byte[] content = stream.readAllBytes();  
        try {  
        Set<String> mdFiles = blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR));
        assertEquals(seenSeqNos, persistedSeqNos);
        // Creating RemoteFsTranslog with the same location
    }  
            AtomicLong seqNoGenerator,
    public void testRangeSnapshot() throws Exception {  
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
                () -> Boolean.TRUE,
import org.opensearch.repositories.fs.FsRepository;
        } finally {  
import org.opensearch.core.common.unit.ByteSizeUnit;
        when(unsupportedRepository.blobStore(anyBoolean())).thenReturn(blobStore);
        ArrayList<Translog.Operation> ops = new ArrayList<>();
        RemoteFsTranslog newTranslog = create(translogDir, repository, translogUUID, false);
        translogTransferMetadata.setGenerationToPrimaryTermMapper(generationToPrimaryTermMapper);
            translog.trimUnreferencedReaders();
        assertFalse(translog.syncNeeded());  
                            op = new Translog.NoOp(seqNoGenerator.getAndIncrement(), primaryTerm.get(), randomAlphaOfLength(16));
        }  
            List<Translog.Operation> ops = new ArrayList<>(seqNos.size());
            .put(IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.getKey(), randomIntBetween(-1, 2048) + "b")
            new RemoteStorePathStrategy(RemoteStoreEnums.PathType.FIXED),
            writer.sync();  
            assertThat(snapshot1, SnapshotMatchers.equalsTo(ops.get(0)));
            if (threadExceptions[i] != null) {  
        assertTrue(statsTracker.getUploadBytesStarted() > 0);
                final Checkpoint syncedCheckpoint = writer.getCheckpoint();
            }
import org.opensearch.index.remote.RemoteTranslogTransferTracker;  
        TranslogConfig translogConfig,  
        final long minSeqNo = seenSeqNos.stream().min(Long::compareTo).orElse(SequenceNumbers.NO_OPS_PERFORMED);
                afterFirstContent,
         * {@code FsBlobContainer} is still rejected.  
        ArrayList<Translog.Operation> ops = new ArrayList<>();
            );  
                            return super.write(src);
        assertTrue(newEmptyTranslogCheckpoint.generation > existingCheckpoint.generation);
                );  
            if (consumer != null) {
                .build()
            );
        // createRepository() rebinds the shared fail/slowDown switches; keep the ones the setUp translog observes.
        assertDownloadStatsNoDownloads(statsTracker);
            createEnvironment(),  
            generationToPrimaryTermMapper.put(String.valueOf(g), "1");
            fenceContainer.readBlobWithVersion(RemoteStoreFence.fenceBlobName(1)).content(),
     * Tests that concurrent readers and writes maintain view and snapshot semantics
            }
        String translogUUID = Translog.createEmptyTranslog(  
     */
            fencedRepository,  
            throw new RuntimeException(e);
        try (Translog.Snapshot snapshot = translog.newSnapshot(fromSeqNo, toSeqNo)) {  
            TranslogWriter writer = translog.getCurrent();  
        // Sync the translog  
        );  
        TranslogTransferManager mockTransfer = mockTransferManagerFor(metadataFor(1, 1, Map.of(1L, checksum)));  
                                failed = true;
            }  
        final AtomicInteger checkpointFsyncCalls = new AtomicInteger();
    protected RemoteFsTranslog create(Path path) throws IOException {
        protected Translog.Location add(Translog.Operation op) throws IOException {
                assertEquals(expectedContentChecksum.longValue(), footerBuffer.getLong());
                assertNull(snapshot.next());
    }  
    /** CRC32 of the first {@code length} bytes of {@code path}, the algorithm used by {@link TranslogCheckedContainer}. */
            when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(fsContainer);  
                            );
            }  
        final AtomicLong seqNoGenerator = new AtomicLong();
            RecoverySettings recoverySettings,
        Exception toThrow = randomBoolean() ? new NoSuchFileException(msg) : new FileNotFoundException(msg);
 * compatible open source license.
        final ChannelFactory channelFactory = getChannelFactory();  
            channelFactory,
        toSeqNo = randomLongBetween(fromSeqNo, 2000);
        final Thread[] writers = new Thread[randomIntBetween(1, 3)];
    }
            new RecoverySettings(Settings.EMPTY, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)),  
 * SPDX-License-Identifier: Apache-2.0
        writer.sync();
                success = true;  
        blobStoreTransferService = new BlobStoreTransferService(repository.blobStore(), threadPool);
        // Validate
            super.writeBlob(blobName, inputStream, blobSize, failIfAlreadyExists);  
        writeCalls = new AtomicInteger();  
            do {
        Map<String, String> generationToChecksumMapper = new HashMap<>();
            int totOps = 0;
        translog.sync();  
            assertEquals(  
import org.opensearch.core.action.ActionListener;
        super.setUp();
                                final Translog.Location loc = writtenOps.get(expectedOp);
                threadExceptions[threadId] = t;  
            } catch (TranslogUploadFailedException e) {  
                    true,
            .collect(Collectors.toSet());
                downLatch.await();
            fenced.add(new Translog.Index("2", 1, primaryTerm.get(), new byte[] { 1 }));
        assertEquals(0, statsTracker.getLastSuccessfulDownloadTimestamp());  
            final int numOps = randomIntBetween(8, 128);
        return create(path, createRepository(), translogUUID, 0, false);
        assertUploadStatsNoFailures(statsTracker);  
        long nextSeqNo = populateTranslogOps(true);
        assertEquals(0, statsTracker.getTotalUploadsFailed());  
        doAnswer(invocation -> {
            String blobNamePrefix,
        for (Path file : FileSystemUtils.files(location)) {
        assertTrue(statsTracker.getTotalDownloadsSucceeded() > 0);
                assertThat(readerCheckpoint, equalTo(writerCheckpoint));  
        String translogUUID,
        );
    private TranslogConfig getTranslogConfig(final Path path, final Settings settings, final String nodeId) {
            // Sequence numbers are marked as persisted after sync
import static org.hamcrest.Matchers.equalTo;  
            threadPool,
                consumer.accept(seqNo);
            super.tearDown();  
                assertEquals(writerCheckpoint.offset + TranslogFooter.footerLength(), Files.size(reader.path()));  
            temp.getShardId(),  
    // No translog data in remote but non-empty translog is present in local. In this case, we delete all the files
                seenSeqNos.add(seqNo);  
            fenced.sync();  
                Files.createFile(location.resolve(Translog.getCommitCheckpointFileName(generation)));  
            for (Translog.Operation op = snapshot.next(); op != null; op = snapshot.next()) {  
            try (Translog.Snapshot snapshot = translog.newSnapshot(fromSeqNo, toSeqNo)) {  
     */
                    logger.info("--> [{}] done. tested [{}] snapshots", threadId, iter);
                4,  
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 4);
    private static void assertDownloadStatsNoDownloads(RemoteTranslogTransferTracker statsTracker) {
        locs.add(addToTranslogAndList(translog, ops, new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 })));
                throw new AssertionError(e);
                public void onFailure(Exception e) {  
            Translog.Snapshot snapshot = translog.newSnapshot();  
import org.apache.logging.log4j.message.ParameterizedMessage;
        assertEquals(1, translog.readers.size());
        fail = new TestTranslog.FailSwitch();
            }  
                protected void doRun() throws Exception {  
        // Update global checkpoint  
     */
            repositoryMetadata,
    }
            reader.readBytes(buffer, reader.getFirstOperationOffset() + 4 * i);
            }  
    private TranslogTransferManager mockTransferManagerFor(TranslogTransferMetadata metadata) throws IOException {
        locs.add(addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 })));
            if (rarely()) {
import static org.opensearch.index.translog.TranslogDeletionPolicies.createTranslogDeletionPolicy;
        List<TestTranslog.LocationOperation> collect = new ArrayList<>(writtenOperations);  
        assertEquals(4, translog.allUploaded().size());
                assertFalse("location is from a previous translog - already synced", translog.ensureSynced(locations.stream()));  
            final int threadId = i;
        }).when(mockTransfer).downloadTranslogIfChanged("1", "2", location, "5678");  
        translog.sync();
        // no exception thrown
        List<Translog.Operation> firstGenOps = null;  
            // The CAS chain advanced: a new version token over new content
        translog.trimUnreferencedReaders();  
                final FileChannel channel;
        final Set<Long> persistedSeqNos = new HashSet<>();
            }
        assertEquals(1, translog.readers.size());
        assertTrue(translog.syncNeeded());
        // TODO: Need to simulate a delay for this assertion to avoid flakiness  
            addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));  
            boolean success = false;  
            Path path,
        long newGlobalCheckpoint = 2L;
    }
        when(mockTransfer.getRemoteTranslogTransferTracker()).thenReturn(remoteTranslogTransferTracker);
                Channels.readFromFileChannelWithEofException(reader.channel, writerCheckpoint.offset, footerBuffer);
            )
                        counter++;  
        ) {
import org.opensearch.common.blobstore.BlobMetadata;
            DefaultRemoteStoreSettings.INSTANCE,
        translog.add(new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));  
                    channel = delegate;
        protected void afterAdd() {}  
                () -> RemoteFsTranslog.sealFence(
    private TranslogConfig getTranslogConfig(final Path path, int gensToKeep) {
        final Object flushMutex = new Object();
        ArrayList<Translog.Operation> ops = new ArrayList<>();
import org.mockito.Mockito;
        }
            try {
        final CyclicBarrier barrier = new CyclicBarrier(writers.length + readers.length + 1);
        when(mockTransfer.downloadTranslogIfChanged(any(), any(), any(), any())).thenThrow(new NoSuchFileException("File not found"));
                DefaultRemoteStoreSettings.INSTANCE,  
        TranslogTransferManager noChecksum = mockTransferManagerFor(metadataFor(1, 1, Map.of()));
                assertFalse("the last call to ensureSycned synced all previous ops", translog.syncNeeded());
        assertEquals(1, translog.stats().estimatedNumberOfOperations());  
            fenced.add(new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));  
        @Override
            if (randomBoolean()) {
                seqNoGenerator,
        }
            new RemoteTranslogTransferTracker(shardId, 10),  
            fenced.add(new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));  
        BlobStoreRepository unsupportedRepository = mock(BlobStoreRepository.class);  
                void closeRetentionLock() throws IOException {
        // This test checks following scenarios -  
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
        assertBusy(() -> assertEquals(0, latch.getCount()));
     * The recovery seal: a copy taking over claims the chain before it reads its restore point, which invalidates the
        }  
            }  
        assertEquals(1, translog.readers.size());
        assertFalse(translog.syncNeeded());
        };
        public ThrowingBlobContainer(  
        assertBusy(() -> assertEquals(1, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size()));
    public void testDownloadRejectsInvertedGenerationRange() throws IOException {
        Translog newTranslog = create(translogDir, repository, translogUUID, false);  
        Path tempDir = createTempDir();  
                    new Translog.Index("" + op, op, primaryTerm.get(), Integer.toString(++count).getBytes(Charset.forName("UTF-8")))
        }
            fenced.sync();  
            fail("Should throw exception for missing operations");
    ) throws IOException {
    }
        // Always File not found  
                    EOFException.class,  
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(shardId.getIndex(), settings, nodeSettings);  
        }  
            );  
    public void testGlobalCheckpointUpdateDuringClose() throws IOException {
        assertEquals(1, downloadCounter.get());
        private final int threadId;
                                randomUnicodeOfLengthBetween(1, 20 * 1024).getBytes("UTF-8")
        Set<String> mdFiles = blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR));
                    }
            // we can remove this try-catch block
        // File not found in first attempt . File found in second attempt.
        RemoteFsTranslog.download(mockTransfer, location, logger, false, 0);  
    }
            readers[i] = new Thread(new AbstractRunnable() {
                    logger.info("--> [{}] done. wrote [{}] ops.", threadName, counter);
            ((TranslogReader) reader).close();
            int limit,  
            translog.trimUnreferencedReaders();
                    IOUtils.closeWhileHandlingException(delegate);
        Path path = createTempDir();
        assertDownloadStatsNoDownloads(statsTracker);
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
                    Thread.sleep(slowDown.getSleepSeconds() * 1000L);
import org.apache.lucene.store.ByteArrayDataOutput;
    }
                null,
import static org.mockito.ArgumentMatchers.any;
        // Sync the translog  
    private RemoteFsTranslog createFencedTranslog(String nodeId, BlobStoreRepository fencedRepository) throws IOException {
            assertTrue(e.getMessage(), e.getMessage().contains("does not support store-enforced conditional writes"));
        // this should now trim as tlog-2 files from remote, but not tlog-3 and tlog-4
            repository,  
            () -> RemoteFsTranslog.download(mockTransfer, location, logger, false, 0)
        assertEquals(2, mdFiles.size());
                        }
    protected final AtomicBoolean primaryMode = new AtomicBoolean(true);
                                translog.setMinSeqNoToKeep(localCheckpoint + 1);
                IllegalArgumentException.class,  
import java.io.InputStream;
                false,  
            fenced.add(new Translog.Index("2", 1, primaryTerm.get(), new byte[] { 1 }));
        assertBusy(() -> assertEquals(4, translog.allUploaded().size()));  
            assertEquals(i, value);
                fail.failNever();
        RemoteFsTranslog.download(finalMockTransfer, location, logger, false, 0);
                assertTrue("this operation has not been synced", translog.ensureSynced(location));  
        }
    TestTranslog.FailSwitch fail;  
                                signalReaderSomeDataWasIndexed.notifyAll();  
        assertTrue(translog.syncNeeded());
                            );
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 3);
            false  
                    assertTrue("at least one operation pending", translog.syncNeeded());
        assertThat(reader.getCheckpoint().minSeqNo, equalTo(minSeqNo));  
    /**
        ArrayList<Translog.Operation> ops = new ArrayList<>();  
            readers[i].start();
        return new TranslogConfig(shardId, path, indexSettings, NON_RECYCLING_INSTANCE, bufferSize, nodeId, allocationIdOf(nodeId), false);
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {  
            )
        String damaged = randomFrom(new ArrayList<>(withChecksum));  
            SequenceNumbers.NO_OPS_PERFORMED,  
    protected ThreadPool threadPool;
                translog.rollGeneration(); // empty generation
     */
                } catch (InterruptedException e) {
        private final int opsPerThread;
                }
        assertEquals(0, statsTracker.getUploadBytesFailed());
        int i = 0;  
        for (int i = numDocs; i < numDocs + moreDocs; i++) {
        assertEquals(2, translog.readers.size());  
        verify(mockTransfer, times(0)).downloadTranslogIfChanged(any(), any(), any(), any());  
        }  
            this.slowDown = slowDown;  
            assertEquals(op, translog.readOperation(locs.get(i++)));
                } catch (InterruptedException e) {
                Files.readAllBytes(file)
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
            assertEquals(op, translog.readOperation(locs.get(i++)));
                // we are the last location so everything should be synced
    }
                    "node-stale",  
        Mockito.clearInvocations(manager);
        RemoteTranslogTransferTracker statsTracker = translog.getRemoteTranslogTracker();
            }
            }  
            super.listBlobsByPrefixInSortedOrder(blobNamePrefix, limit, blobNameSortOrder, listener);
        );
            }  
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 1);
            // Fsync is still enabled during empty translog creation.
                () -> RemoteFsTranslog.buildTranslogTransferManager(
        // Refill the permits back  
    public void testLocationComparison() throws IOException {
        Path location = createTempDir();
                assertFalse("translog has been synced already", translog.ensureSynced(locations.stream()));
    public void testSyncWithGlobalCheckpointUpdate() throws IOException {  
import static org.hamcrest.Matchers.empty;
    /**
            SequenceNumbers.NO_OPS_PERFORMED,  
                            case CREATE:
        Settings settings = Settings.builder()
        for (int gen = 0; gen < generations; gen++) {
                persistedSeqNos::add,
        // without a writer and is re-downloaded every time (it is header-only, a few dozen bytes).
        assertTrue(
        }  
        try {  
     * reuse the local copy; a generation it reports as reused is not downloaded and counts as skipped.
            } finally {  
            if (randomBoolean()) {
    }
    }
            while ((next = snap.next()) != null) {
        RemoteFsTranslog.download(manager, location, logger, false, 0);
import org.opensearch.common.io.Channels;  
                () -> SequenceNumbers.NO_OPS_PERFORMED,
        translog.sync();
import org.junit.After;  
        final int numOps = scaledRandomIntBetween(8, 250000);
import org.apache.lucene.store.DataOutput;  
        globalCheckpoint.set(initialGlobalCheckpoint);
        assertEquals(6, translog.allUploaded().size());
        ) throws IOException {  
            if (seqNo != SequenceNumbers.UNASSIGNED_SEQ_NO) {
        long checksum = createTranslogGeneration(location, 1);
                        }  
            // Ignoring this exception for now. Once the download flow populates FileTracker,  
    public void testFencingEnabledTranslogUploadCreatesAndAdvancesFence() throws Exception {
        IOUtils.close(writer);
        throws IOException {
                    buffer.flip();
        translog.setMinSeqNoToKeep(1);
                    while (idGenerator.get() < maxOps) {  
            assertEquals(  
            addToTranslogAndListAndUpload(translog, ops, new Translog.Index(String.valueOf(i), i, primaryTerm.get(), new byte[] { 1 }));
        Files.write(location.resolve(Translog.CHECKPOINT_FILE_NAME), randomByteArrayOfLength(randomIntBetween(8, 32)));  
            } catch (Exception e) {
        for (int i = 0; i < numOps; i++) {
        logger.info("All md files {}", mdFiles);  
        ) {
            new RemoteStoreFence(fenceContainer, allocationIdOf("node-new"), "node-new", shardId).validateAndAdvance(primaryTerm.get() + 1);
            final int value = buffer.getInt();
        Map<String, byte[]> contentAfterFirst = new HashMap<>();  
import static org.opensearch.common.util.BigArrays.NON_RECYCLING_INSTANCE;  
                () -> Boolean.TRUE,
            () -> globalCheckpoint.get(),  
            int threadId,  
        } catch (IOException e) {  
        );  
                            op = new Translog.Index(  
            false,  
        for (Translog.Operation op : ops) {
        final TestTranslog.SlowDownWriteSwitch currentSlowDown = slowDown;  
    public void testTranslogWriterFsyncDisabledInRemoteFsTranslog() throws IOException {
        try {
import java.nio.file.Path;
                // we are the last location so everything should be synced
                "node-new",  
import org.opensearch.common.blobstore.fs.FsBlobContainer;  
        assertTrue(locations[0].compareTo(locations[1]) < 0);
        // Update global checkpoint
                for (int opCount = 0; opCount < opsPerThread; opCount++) {  
                final DataOutput out = EndiannessReverserUtil.wrapDataOutput(new ByteArrayDataOutput(bytes));
        final Map<Translog.Operation, Translog.Location> writtenOps = ConcurrentCollections.newConcurrentMap();
            null,  
            .add(String.valueOf(shardId.id()))
     * The local-filesystem container <em>implements</em> conditional writes, but only emulates the precondition within a
     * Only the generations the manager reports as downloaded are counted as such; the one already present is kept.  
            return a;
        // assertTrue(statsTracker.getTotalDownloadTimeInMillis() > 0);
            assertThat(snapshot, SnapshotMatchers.size(0));
                // eliminate thread name check as we create repo manually  
            translog.close();
        }
            .put(IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.getKey(), randomBoolean() ? "-1ms" : "1h")  
                // expected
    private long createTranslogGeneration(Path location, long generation) throws IOException {  
        byte[] bytes = new byte[4];  
        damagedBytes[damagedBytes.length - 1] ^= 0x1;  
        // Set initial global checkpoint
        RemoteTranslogTransferTracker remoteTranslogTransferTracker = mock(RemoteTranslogTransferTracker.class);
        long newGlobalCheckpoint = 1L;
import java.util.ArrayList;  
        assertTrue(created, created.contains("|1|" + allocationIdOf("node-new") + "|node-new|"));
        translog.sync();
    public void testUploadWithPrimaryModeFalse() {  
            IllegalStateException.class,
            Files.copy(file, location.resolve(file.getFileName()));  
        RemoteTranslogTransferTracker statsTracker = translog.getRemoteTranslogTracker();
        assertTrue(statsTracker.getTotalUploadTimeInMillis() > 0);  
        assertEquals(0, statsTracker.getUploadBytesFailed());  
        when(mockTransfer.getRemoteTranslogTransferTracker()).thenReturn(remoteTranslogTransferTracker);
    }  
                persistedSeqNos::add,
            // Sequence numbers are marked as persisted after sync  
        TranslogTransferManager finalMockTransfer = mockTransfer;
                        case INDEX:
import org.opensearch.index.translog.transfer.TranslogFencedException;
                            .values().length))];
        // exception is the initial empty generation laid down by Translog.createEmptyTranslog, which is written  
                contentAfterFirst.get(file.getFileName().toString()),  
                    closeRetentionLock();
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
        return getTranslogConfig(path, settings);  
                    }
                TranslogOperationHelper.DEFAULT,
                assertFalse("this op has been synced before", translog.ensureSynced(location)); // not syncing now
        try {
        translog.trimUnreferencedReaders();
    }
import org.opensearch.core.common.bytes.BytesArray;  
        assertTrue(e.getMessage(), e.getMessage().contains("does not support store-enforced conditional writes"));  
    }  
            threads[i].setDaemon(true);
        when(mockTransfer.readMetadata()).thenReturn(null);
            temp.getTranslogPath(),
        for (Translog.Location location : locations) {  
            DataOutput out = EndiannessReverserUtil.wrapDataOutput(new ByteArrayDataOutput(bytes));
        try {
                downLatch,
                primaryTerm::get,  
                assertTrue("one pending operation", translog.syncNeeded());
            }
         * JVM, which is no fencing primitive between hosts, and remote store fencing correctly refuses it. These tests
import static org.mockito.Mockito.mock;
    protected LongConsumer getPersistedSeqNoConsumer() {
                        if (iter++ % 10 == 0) {
    }  
            writers[i] = new Thread(new AbstractRunnable() {
                assertEquals(Long.valueOf(checksumOf(writer.path(), Files.size(writer.path()))), reader.getTranslogChecksum());  
                assertFalse("all of the locations should be synced: " + location, translog.ensureSynced(location));  
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
            ops,
        TranslogTransferManager failing = mockTransferManagerFor(metadataFor(2, 2, Map.of(2L, checksum2)));  
                                missed.append("\n --> [").append(expectedOp).append("] written at ").append(loc);  
            }
                            StringBuilder missed = new StringBuilder("missed ").append(expectedOps.size())
                    }
            boolean readonly,  
            assertEquals(op, newTranslog.readOperation(locs.get(i++)));
                translog.rollGeneration();
        synchronized (signalReaderSomeDataWasIndexed) {  
            assertThat(snapshot.totalOperations(), equalTo(0));  
        ArrayList<Translog.Operation> ops = new ArrayList<>();
        assertEquals(0, statsTracker.getTotalUploadsFailed());  
        assertDownloadStatsPopulated(statsTracker);
                    } catch (IOException inner) {
            toClose.add(snapshot1);  
    protected AtomicLong globalCheckpoint;
        }  
     * previous remote state; a successful download recreates it from the latest generation's checkpoint.  
        // Creating RemoteFsTranslog with the same location
        ) {
            return true;
        };
            buffer.flip();  
                new RemoteTranslogTransferTracker(shardId, 10),
                DefaultRemoteStoreSettings.INSTANCE,  
        }  
        assertEquals(0, translog.availablePermits());  
                new DefaultTranslogDeletionPolicy(-1, -1, 0),
        final TranslogDeletionPolicy deletionPolicy = createTranslogDeletionPolicy(translogConfig.getIndexSettings());
        // a signal for all threads to stop
                                throw new AssertionError("unsupported operation type [" + type + "]");  
import org.opensearch.index.translog.transfer.RemoteStoreFence;  
            TranslogConfig.DEFAULT_BUFFER_SIZE,  
        Path home = createTempDir();  
            "",
                new Translog.Index("" + op, seqNo, primaryTerm.get(), Integer.toString(seqNo).getBytes(Charset.forName("UTF-8")))  
        statsTracker = newTranslog.getRemoteTranslogTracker();
        assertEquals(0, statsTracker.getTotalUploadsSucceeded());
            // only randomize between nog age retention and a long one, so failures will have a chance of reproducing
            translog.close();
            try {  
            BlobContainer fenceContainer = fencedRepository.blobStore().blobContainer(fenceDirectory(fencedRepository));
            isServerSideEncryptionEnabled
            assertThat(snapshot.totalOperations(), equalTo(ops.size()));  
            @Override
    }  
                            break;
                long committedLocalCheckpointAtView;  
            temp.getIndexSettings(),
import org.opensearch.core.xcontent.NamedXContentRegistry;
    public void testIncrementalDownloadRemovesGenerationsOutsideRemoteRange() throws IOException {
    private RemoteFsTranslog create(
        );
                            translog.ensureSynced(location);  
            int numOps = randomIntBetween(1, 100);
    public void testDownloadWithTranslogOnlyInLocal() throws IOException {
                    if (retentionLock != null) {  
                if (randomBoolean()) {
                }  
                // closing a tragically-failed translog is expected to rethrow  
            final Long expectedContentChecksum;
        );
        Random random = random();
    public void testDrainSync() throws Exception {
                    }  
        }  
            fenced.sync();
                translog.ensureSynced(locations.get(op));
        throws IOException {  
            assertThat(snapshot.totalOperations(), equalTo(ops.size()));
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
        }
        for (int op = 0; op < translogOperations; op++) {  
        }  
        return loc;
            throws IOException {
                    channel = new FilterFileChannel(delegate) {
        assertTrue(translog.syncNeeded());
                    Thread.sleep(slowDown.getSleepSeconds() * 1000L);  
            "node-new",
        final Settings settings = Settings.builder()  
                translog,  
         * run entirely in one JVM and so share that emulation, making the precondition genuinely exclusive here.  
        }  
                config,
                    new Translog.Index("" + op, seqNo, primaryTerm.get(), Integer.toString(seqNo).getBytes(Charset.forName("UTF-8")))
                void acquireRetentionLock() throws IOException {
                    allocationIdOf("node-stale"),
            TestTranslog.SlowDownWriteSwitch slowDown
        public boolean isConditionalWriteSupported() {  
            }  
            } while (seenSeqNos.contains(seqNo));
            fail,
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
            // Ignoring this exception for now. Once the download flow populates FileTracker,  
                        if (id % writers.length == threadId) {
                writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 5);  
                assertThat(writeCalls.get(), greaterThan(initialWriteCalls));
import java.util.Comparator;
            return true;
                // don't do partial writes for checkpoints we rely on the fact that the bytes are written as an atomic operation
            super(metadata, environment, namedXContentRegistry, clusterService, recoverySettings);
import java.util.stream.Collectors;  
import java.io.FileNotFoundException;
            translogUUID,
        // Verify that the globalCheckpointSynced is updated  
        assertBusy(() -> assertEquals(4, translog.allUploaded().size()));
            new ByteSizeValue(1, ByteSizeUnit.KB),
import org.opensearch.index.seqno.LocalCheckpointTracker;
        final CountDownLatch downLatch = new CountDownLatch(1);
            } else if (rarely()) {  
        // writes should get synced up now  
        thread1.start();
import java.util.concurrent.atomic.AtomicReference;
                                translog.rollGeneration();
        long checksum1 = createTranslogGeneration(location, 1);
    }
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)  
                        synchronized (signalReaderSomeDataWasIndexed) {
            List<Translog.Operation> expectedOps = new ArrayList<>();
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), seqNo);
                InputStream tlogStream = blobStoreTransferService.downloadBlob(path, Translog.getFilename(readerGeneration));  
            final String location = REPOSITORIES_LOCATION_SETTING.get(getMetadata().settings());
    ) throws IOException {
                                seqNoGenerator.getAndIncrement(),
        // this should now trim as tlog-2 files from remote, but not tlog-3 and tlog-4
        int count = 0;
     */
            String sealed = new String(
                    emulatedRepository,
                        }
            if (rarely() && translogOperations > op + 1) {  
        fail.failAlways();  
        String translogUUID,
        public void writeBlob(final String blobName, final InputStream inputStream, final long blobSize, boolean failIfAlreadyExists)  
                        case DELETE:
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
        }
        long maxGeneration = remoteMetadata.getGeneration();  
import java.util.HashMap;
            try (
                )
        for (Translog.Operation op : ops) {
                // Validate the raw footer bytes.
        );
            final int threadId = i;
        @Override
        );
            toClose.add(snapshot2);
import org.opensearch.indices.replication.common.ReplicationType;
                    fencedRepository,  
            throw new RuntimeException(e);
        RemoteTranslogTransferTracker statsTracker = translog.getRemoteTranslogTracker();
            primaryMode::get,
        int threadCount = 2 + randomInt(5);  
            );
        assertTrue(statsTracker.getDownloadBytesSucceeded() > 0);
            ActionListener<List<BlobMetadata>> listener
        AtomicLong downloadCounter = new AtomicLong();
     * the metadata. Corrupting one local generation makes exactly that generation download again.  
            for (Throwable suppress : errors.subList(1, errors.size())) {  
            Path translogPath = reader.path();  
                                break;
        );
        }
                    channel = new FilterFileChannel(delegate) {  
            if (randomBoolean()) {
                            synchronized (signalReaderSomeDataWasIndexed) {
        public ThrowingBlobRepository(
    }
        }
                    if (rarely()) { // lets verify we can concurrently read this  
        globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);  
            )
                boolean shouldAdd = !withMissingOps || seqNo % 4 != 0;
import static org.hamcrest.Matchers.contains;  
                assertFalse("no sync needed since no operations in current translog", translog.syncNeeded());
        // A failing download has already removed the stale checkpoint.
                            break;
                                op = new Translog.NoOp(id, 1, Long.toString(id));  
            TranslogWriter writer = translog.getCurrent();  
        downLatch.countDown();  
    protected RemoteFsTranslog createTranslogInstance(
            for (int op = 0; op < translogOperations; op++) {  
            assertThat(snapshot.totalOperations(), equalTo(0));  
        private final TestTranslog.SlowDownWriteSwitch slowDown;
        Thread thread1 = new Thread(() -> {
    public void tearDown() throws Exception {
    }
            Translog.Operation next;
            }
        fail.failNever();
        }
        final Thread[] readers = new Thread[randomIntBetween(1, 3)];  
        );
            assertEquals(maxOp.getSource().source.utf8ToString(), Integer.toString(count));
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 1, primaryTerm.get(), new byte[] { 1 }));
import java.nio.channels.FileChannel;  
            primaryTerm.get()
                                1 + randomInt(100000)  
        RemoteFsTranslog.download(mockTransfer, location, logger, false, 0);
            } finally {
        assertUploadStatsNoUploads(statsTracker);  
                byte[] ckp = ckpStream.readAllBytes();
            int opsPerThread,
        // Verify that sync is now needed due to global checkpoint update  
                } else {
                if (rarely()) {
            assertEquals(opsList.get(i), collect.get(i).operation);  
import org.opensearch.common.settings.ClusterSettings;  
        assertDownloadStatsNoDownloads(statsTracker);  
        return seqNo -> {
            assertDownloadStatsNoDownloads(statsTracker);  
        translogTransferMetadata.setGenerationToChecksumMapper(generationToChecksumMapper);
    public void testBatchedAddAndRemoteSync() throws IOException {  
                    barrier.await();
            assertTrue(fenceContainer.listBlobs().containsKey(RemoteStoreFence.fenceBlobName(primaryTerm.get())));  
    /** Sealing at a term below the fence's must be refused: that copy has already been superseded. */
        };
        long oldPrimaryTerm = primaryTerm.get();
                // Add after we the read flushed the buffer  
        for (int i = 0; i < threadCount; i++) {  
                        }  
        translog.close();
        generationToPrimaryTermMapper.put(String.valueOf(generation), String.valueOf(primaryTerm));  
                opsHaveValidSequenceNumbers = opsHaveValidSequenceNumbers || !rarely();  
     */
                }  
        assertBusy(() -> assertEquals(0, translog.availablePermits()));
        final TranslogWriter writer = translog.createWriter(translog.currentFileGeneration() + 1);
                    translog.add(op);
import java.util.concurrent.ArrayBlockingQueue;
        // Set initial global checkpoint
        assertEquals(4, translog.allUploaded().size());
import java.util.function.LongConsumer;
                try {  
                                .append("]");
        verify(mockTransfer, times(0)).downloadTranslog(any(), any(), any());
        assertArrayEquals(  
     */
                new FileTransferTracker(shardId, new RemoteTranslogTransferTracker(shardId, 10)),
        }  
        // Sync again  
     * rather than a mock, so the test fails if that container ever starts advertising support again.
import java.util.concurrent.atomic.AtomicLong;  
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 4);  
    }
        translog.sync();
                        final Translog.Operation op;  
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.TRANSLOG;
            }  
            // expose the new checkpoint (simulating a commit), before we trim the translog  
            createTranslogDeletionPolicy(config.getIndexSettings()),
    }
            () -> RemoteFsTranslog.buildTranslogTransferManager(  
                            boolean failed = false;
        Translog.Location[] locations = translog.add(operations);
import org.opensearch.repositories.blobstore.BlobStoreTestUtil;  
                }  
        }  
        int extraGenToKeep,
                allocationIdOf("node-new"),
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index(String.valueOf(3), 3, primaryTerm.get(), new byte[] { 1 }));
                    committedLocalCheckpointAtView = lastCommittedLocalCheckpoint.get();
            translog.setMinSeqNoToKeep(2);
            addToTranslogAndList(translog, ops, new Translog.Index("3", 2, primaryTerm.get(), new byte[] { 3 }));
                    while (run.get() && idGenerator.get() < maxOps) {
        final Set<Long> persistedSeqNos = new HashSet<>();  
        assertEquals(mdFiles, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)));  
            try {
        int remoteGenerations = Math.toIntExact(maxGeneration - minGeneration + 1);
        RepositoryMetadata repositoryMetadata = new RepositoryMetadata(randomAlphaOfLength(10), FsRepository.TYPE, settings);
        CountDownLatch latch = new CountDownLatch(1);  
        // This should not trim anything from local  
        ) {
        }
                totOps++;
        metadata.setGenerationToChecksumMapper(generationToChecksumMapper);
        // Test deletion of metadata files  
        }
                } catch (InterruptedException e) {
                StandardCharsets.UTF_8
                    "node-1"
import static org.mockito.ArgumentMatchers.anyBoolean;  
        ) {  
        try (Translog.Snapshot snapshot = translog.newSnapshot()) {
        }
                () -> SequenceNumbers.NO_OPS_PERFORMED,
    }
        }
        assertEquals(2, translog.readers.size());  
        // Damage one local generation's footer checksum: that generation is re-downloaded, and it comes back intact.
            if (slowDown.getSleepSeconds() > 0) {
import org.opensearch.cluster.metadata.IndexMetadata;
        primaryMode.set(false);
    }
     * A stale top-level translog.ckp is removed with the other out-of-range files before the download starts, so a
    TestTranslog.SlowDownWriteSwitch slowDown;
                ops,
                new RemoteTranslogTransferTracker(shardId, 10),
        try (RemoteFsTranslog fenced = createFencedTranslog("node-old", fencedRepository)) {
            }
            addToTranslogAndListAndUpload(translog, ops, new Translog.Index("4", 3, primaryTerm.get(), new byte[] { 1 }));
        // Same remote state, same local directory: only footer-less generations are fetched again, files are untouched.
            int totOps = 0;  
                    shardId,
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("2", 1, primaryTerm.get(), new byte[] { 2 }));  
import java.util.List;
                    writtenOperations.add(new TestTranslog.LocationOperation(op, loc));
            new Translog.Index("1", 0L, primaryTerm.get(), new byte[] { 1 }),
                new RemoteTranslogTransferTracker(shardId, 10),
import org.opensearch.repositories.blobstore.BlobStoreRepository;
import org.apache.lucene.store.AlreadyClosedException;
            super(bufferSizeInBytes, path, readonly);
        private TestTranslog.FailSwitch fail;  
                firstGenOps = ops;
            }
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            TestTranslog.FailSwitch fail,
    // No translog data in remote and empty translog in local. We skip creating another empty translog  
        return TestEnvironment.newEnvironment(
        Path[] filesBeforeDownload = FileSystemUtils.files(location);  
    }
            BlobContainer fenceContainer = fencedRepository.blobStore().blobContainer(fenceDirectory(fencedRepository));
        final ChannelFactory channelFactory = (file, openOption) -> {
                }  
import org.opensearch.indices.recovery.RecoverySettings;  
        Translog.Location loc = translog.add(op);
    /**
        // Test setup
            )
    public void testSealFenceIsRefusedForAStaleTerm() throws Exception {  
            Exception[] threadExceptions  
import java.io.Closeable;  
            for (int i = 0; i < numOps; i++) {
        long fromSeqNo = 0L;  
            channelFactory,
                        try (Translog.Snapshot snapshot = translog.newSnapshot(committedLocalCheckpointAtView + 1L, Long.MAX_VALUE)) {  
            slowDown
        assertEquals(mdFiles, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)));
        BlobStoreRepository fencedRepository = createIsolatedRepository();
                        Set<Translog.Operation> expectedOps = new HashSet<>(writtenOps.keySet());
import java.util.zip.CheckedInputStream;
            Set<Long> seenSeqNos = new HashSet<>();
                    };
                if (isCkpFile) {  
        Checkpoint existingCheckpoint = Translog.readCheckpoint(location);  
        final Exception[] threadExceptions = new Exception[threadCount];  
                threadPool,  
            try {  
            }
                byte[] content = stream.readAllBytes();
            }  
        assertEquals(0, statsTracker.getTotalUploadTimeInMillis());
        translog.setMinSeqNoToKeep(0);
        final FsRepository repository = new ThrowingBlobRepository(
                }  
        final long seqNo = randomLongBetween(0, Integer.MAX_VALUE);  
            }
            writer.add(ReleasableBytesReference.wrap(new BytesArray(bytes)), 2);
                    closeRetentionLock();  
                repository,
        slowDown.setSleepSeconds(0);
                            for (Translog.Operation expectedOp : expectedOps) {  
    public void testSnapshotWithNewTranslog() throws IOException {
            for (long gen = translog.currentFileGeneration(); gen > 0; gen--) {  
        boolean opsHaveValidSequenceNumbers = randomBoolean();
            if (slowDown.getSleepSeconds() > 0) {
        }
            } else {
        final TranslogDeletionPolicy deletionPolicy = translog.getDeletionPolicy();
        int i = 0;  
            TestTranslog.FailSwitch fail,
            try {
        for (long g = minGeneration; g <= maxGeneration; g++) {
import org.opensearch.common.settings.Settings;
        translog.sync();  
     * Files outside the remote generation range, and files that are not translog files at all, are removed before
            } finally {
     * Metadata whose minimum generation exceeds its maximum would make the reconciliation loop a no-op and the final
            assertEquals(totOps, toSeqNo - fromSeqNo + 1);  
                assertTrue("this operation has not been synced", translog.ensureSynced(locations.stream()));  
                            default:
        // Apply state once to initialize repo properly like RepositoriesService would
                            fail("duplicate op [" + op + "], old entry at " + location);  
            }, threadName);
import org.opensearch.common.blobstore.BlobPath;  
                        inner.addSuppressed(e);  
    public void testBuildTranslogTransferManagerRejectsEmulatedConditionalWrites() throws IOException {  
            thread.join();
                                break;
            if (withChecksum.contains(String.valueOf(g)) == false) {
        try (  
            getPersistedSeqNoConsumer(),
    }
import org.opensearch.threadpool.TestThreadPool;
        long checksum2 = createTranslogGeneration(location, 2);
        assertArrayEquals(filesPostFirstDownload, filesPostSecondDownload);
        if (minSeqNo > 0) {  
    /**
        int count = 0;
    }  
            incumbent.add(new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));  
            maxGeneration,
        return config;
        assertEquals(0, statsTracker.getLastSuccessfulUploadTimestamp());  
            BlobStore blobStore = mock(BlobStore.class);
                ops.add(op);  
            TranslogReader reader = writer.closeIntoReader();
            ByteBuffer buffer = ByteBuffer.allocate(4);
            // newTranslog.deletionPolicy.setLocalCheckpointOfSafeCommit(i - 1);
            ) {
            }
import org.opensearch.common.blobstore.VersionedBlob;
     * ownership (see FenceSegmentFlow.tla). The call itself stays safe - it skips, it does not throw.
     */
        final String reason = randomAlphaOfLength(16);
                translog,
            newTranslog.close();
    public void testBuildTranslogTransferManagerRejectsRepositoryWithoutConditionalWrites() {
            assertThat(snapshot2.totalOperations(), equalTo(ops.size()));
                                signalReaderSomeDataWasIndexed.wait();  
        int translogOperations = randomIntBetween(1, 20);
            {
                            acquireRetentionLock();
            }
        );
        when(mockTransfer.downloadTranslogIfChanged("1", "2", location, String.valueOf(checksum2))).thenReturn(false);  
            // A copy recovering at a higher term seals before reading its restore point
            assertEquals(  
    BlobStoreRepository repository;
            temp.getBigArrays(),  
        for (int i = 0; i < threadCount; i++) {
    }
        translog.setMinSeqNoToKeep(0);
import org.apache.lucene.codecs.CodecUtil;  
    /**
        RemoteFsTranslog.sealFence(
        TranslogDeletionPolicy deletionPolicy,
        }  
    private TranslogConfig getTranslogConfig(final Path path) {
    @Override
        Map<String, String> generationToPrimaryTermMapper = new HashMap<>();  
            Translog translog,  
            Translog.Operation maxOp = null;  
        IllegalStateException e = expectThrows(  
        when(mockTransfer.readMetadata()).thenReturn(null);
        return getTranslogConfig(path, settings, "");
                repository,
    }  
     * A copy that begins a fresh lineage - a resize (shrink/split/clone) target, or a snapshot restore into a new
                translog.sync();  
import java.nio.charset.Charset;
            .add(METADATA_DIR);
            incumbent.add(new Translog.Index("2", 1, primaryTerm.get(), new byte[] { 1 }));  
            translog.sync();
            assertTrue(fenced.isRemoteStoreFenceSuperseded());
            new Translog.Index("3", 2L, primaryTerm.get(), new byte[] { 3 })
        // Sync the translog
        createTranslogGeneration(location, 1);
            }
        for (Path file : FileSystemUtils.files(translogDir)) {
            "",
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        private final TestTranslog.SlowDownWriteSwitch slowDown;  
        );
                () -> SequenceNumbers.NO_OPS_PERFORMED,
        assertEquals(0, statsTracker.getTotalUploadsStarted());
    }
        try {
            translog,
        assertFalse(primaryMode.get());  
            long toSeqNo = randomLongBetween(fromSeqNo, minSeqNo - 1);
            .put(INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING.getKey(), gensToKeep)
            () -> globalCheckpoint.get(),  
    }
            } catch (EOFException ex) {
    }  
        AlreadyClosedException ex = expectThrows(AlreadyClosedException.class, () -> translog.newSnapshot());
                    }
                    if (fromSeqNo <= op.seqNo() && op.seqNo() <= toSeqNo && seenSeqNos.add(op.seqNo())) {
                assertFalse("location is from a previous translog - already synced", translog.ensureSynced(location)); // not syncing now
        final Set<Long> persistedSeqNos = new HashSet<>();  
        }  
            } else if (downloadCounter.get() == 2) {
            Files.readAllBytes(location.resolve(Translog.CHECKPOINT_FILE_NAME))
            return createRepository();
            try (
            final String threadName = "writer_" + i;  
        assertThrows(NoSuchFileException.class, () -> RemoteFsTranslog.download(finalMockTransfer, location, logger, false, 0));  
            ? writer
    public void testSyncNeededWithGlobalCheckpointUpdate() throws IOException {  
        try (  
        // This should trim tlog-2 from local  
                            }
        assertFalse(container.isConditionalWriteSupported());  
        assertEquals(Set.of(Translog.getFilename(2), Translog.getCommitCheckpointFileName(2), Translog.CHECKPOINT_FILE_NAME), remaining);  
        Settings nodeSettings = Settings.builder().put("node.attr.remote_store.translog.repository", "my-repo-1").build();
            Collections.shuffle(locations, random());  
        final ClusterService clusterService = BlobStoreTestUtil.mockClusterService(repositoryMetadata);  
            );
                6,
        final ChannelFactory channelFactory = (file, openOption) -> {
        when(mockTransfer.downloadTranslogIfChanged("1", "1", location, String.valueOf(checksum1))).thenReturn(false);  
import org.opensearch.core.index.shard.ShardId;  
import org.opensearch.cluster.service.ClusterService;  
        repository.updateState(clusterService.state());
                TranslogFencedException.class,
        // Verify that the new checkpoint points to empty translog
    }
            }  
                && newEmptyTranslogCheckpoint.numOps == 0  
                        }
    protected RemoteFsTranslog translog;  
        long initialGlobalCheckpoint = 0L;
                    reader.close();  
            this.seqNoGenerator = seqNoGenerator;
            signalReaderSomeDataWasIndexed.notifyAll();
        if (reader instanceof TranslogReader) {
        translog.rollGeneration();
        for (int i = totalDocs + 1; i <= totalDocs + newPrimaryTermDocs; i++) {
            freshRepository,
                channelFactory,
            // A new primary at a higher term seals the fence out of band  
        locs.add(addToTranslogAndList(translog, ops, new Translog.Index("2", 1, primaryTerm.get(), new byte[] { 1 })));  
            }
import static org.opensearch.index.translog.SnapshotMatchers.containsOperationsInAnyOrder;  
    public void testCloseIntoReader() throws IOException {  
        }
                    return;
                minSeqNo = SequenceNumbers.min(minSeqNo, seqNo);
        assertUploadStatsNoFailures(statsTracker);
        checksums.forEach((g, c) -> generationToChecksumMapper.put(String.valueOf(g), String.valueOf(c)));
                    fail("io exception expected");  
        // expose the new checkpoint (simulating a commit), before we trim the translog  
        verify(noChecksum).downloadTranslogIfChanged("1", "1", location, null);
        list.add(op);
            VersionedBlob afterSecond = fenceContainer.readBlobWithVersion(RemoteStoreFence.fenceBlobName(primaryTerm.get()));
        assertEquals(newGlobalCheckpoint, ((RemoteFsTranslog) translog).getLastSyncedCheckpoint().globalCheckpoint);
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
        // clean up  
                    int iter = 0;
        try (  
        for (Path file : FileSystemUtils.files(location)) {  
import org.opensearch.OpenSearchException;  
        assertThat(locations.length, equalTo(operations.size()));  
import org.opensearch.common.blobstore.BlobContainer;
    /**  
            new Translog.Index("2", 1L, primaryTerm.get(), new byte[] { 2 }),  
import org.opensearch.common.lease.Releasable;
        list.add(op);
                        case NO_OP:  
            Translog.Snapshot snapshot1 = translog.newSnapshot();
        // Verify that the globalCheckpointSynced is updated to the new value
        out.writeInt(2048);
     * instance for the same shard id does not collide with it on remote paths.
        assertEquals(0, translog.allUploaded().size());  
import java.util.zip.CRC32;
                for (Translog.Operation op : operationsByGen.getOrDefault(gen, Collections.emptyList())) {
        expectThrows(IOException.class, () -> RemoteFsTranslog.download(failing, location, logger, false, 0));
        inverted.setGenerationToPrimaryTermMapper(Map.of());
    @After  
            TranslogOperationHelper.DEFAULT,
                public void doRun() throws Exception {
        final long noopTerm = randomLongBetween(1, primaryTerm.get());
        mockTransfer = mock(TranslogTransferManager.class);  
                                .append(" operations from [")
import org.opensearch.core.common.unit.ByteSizeValue;
                new Translog.Index("" + op, seqNo, primaryTerm.get(), Integer.toString(seqNo).getBytes(Charset.forName("UTF-8")))
        when(mockTransfer.getRemoteTranslogTransferTracker()).thenReturn(remoteTranslogTransferTracker);
            // Trims from local  
                        assertEquals(op, translog.readOperation(loc));
                throw new OpenSearchException("failed to create blob container", ex);
                assertFalse("no sync needed since no operations in current translog", translog.syncNeeded());
    }
        createTranslogGeneration(location, 1);  
            );
            ByteBuffer buffer = ByteBuffer.allocate(4);  
                            break;  
                // don't do partial writes for checkpoints we rely on the fact that the bytes are written as an atomic operation
            assertFalse("emulated conditional writes must not be advertised as supported", fsContainer.isConditionalWriteSupported());  
        crc.update(bytes, 0, Math.toIntExact(length));
            operationsByGen.put(translog.currentFileGeneration(), ops);
        long minGeneration = remoteMetadata.getMinTranslogGeneration();
        final TranslogConfig temp = getTranslogConfig(tempDir, gensToKeep);
            Files.copy(file, location.resolve(file.getFileName()));  
            null,  
        for (int gen = 0; gen < generations; gen++) {
                        expectedOps.add(op);  
        assertTrue(statsTracker.getTotalUploadsSucceeded() > 0);
                latch.countDown();
            locations.add(location);  
            false  
            newTranslog.trimUnreferencedReaders();  
            int numOps = randomIntBetween(4, 10);
    public void testDownloadWithRetries() throws IOException {  
        protected BlobStore createBlobStore() throws Exception {  
        long fromSeqNo = 0L;
            verify(manager, times(0)).downloadTranslog(any(), Mockito.eq(generation), any());
        return b;
        try {
                    // whole-file checksum.  
                RemoteTranslogTransferTracker statsTracker = translog.getRemoteTranslogTracker();
                    reader.readBytes(buffer, reader.getFirstOperationOffset() + 4 * i);  
        when(mockTransfer.readMetadata()).thenReturn(null);  
        }
            allocationIdOf("node-new"),
        for (Thread thread : writers) {
        Path damagedPath = location.resolve(Translog.getFilename(Long.parseLong(damaged)));
        });  
    }
    protected TranslogConfig getConfig(int gensToKeep) {
        // Verify that sync is not needed after syncing  
                opsPerThread,
                if (success == false) {
    public void testSimpleOperations() throws IOException {  
            assertEquals(2048, value);  
                        Translog.Location location = translog.add(op);
        try {  
            assertEquals(0, statsTracker.getTotalUploadsFailed());
                        final Translog.Operation.Type type = Translog.Operation.Type.values()[((int) (id % Translog.Operation.Type
        final long maxSeqNo = seenSeqNos.stream().max(Long::compareTo).orElse(SequenceNumbers.NO_OPS_PERFORMED);
        assertThat(e.getMessage(), containsString("min generation [5] greater than max generation [3]"));
                    };  
        }  
            if (shouldFailAlways) {
        }  
}  
            .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
    BlobStoreTransferService blobStoreTransferService;
                primaryTerm.get() + 1
            DefaultRemoteStoreSettings.INSTANCE,
    }
    public void setUp() throws Exception {  
        final int flushEveryOps = randomIntBetween(5, 10);
        TranslogTransferManager mockTransfer = mock(TranslogTransferManager.class);
        assertTrue(statsTracker.getLastSuccessfulUploadTimestamp() > 0);
            threads[i].start();  
     * {@code location}, exactly as {@link TranslogWriter#closeIntoReader()} would leave them. Returns the  
        translog.sync();
            newEmptyTranslogCheckpoint.generation == newEmptyTranslogCheckpoint.minTranslogGeneration  
        assertEquals(filesBeforeDownload, FileSystemUtils.files(location));
                            writeCalls.incrementAndGet();
            int seqNo = ++count;
            TestTranslog.FailSwitch fail,
                TranslogOperationHelper.DEFAULT,
        public void writeBlobAtomic(final String blobName, final InputStream inputStream, final long blobSize, boolean failIfAlreadyExists)
        int translogOperations = randomIntBetween(10, 100);
        String msg = "File not found";  
            assertEquals(1, translog.readers.size());
        logger.info("testing with [{}] threads, each doing [{}] ops", threadCount, opsPerThread);
        clusterService.addStateApplier(event -> repository.updateState(event.state()));  
                assertThat(writeCalls.get(), greaterThan(initialWriteCalls));
import static org.mockito.Mockito.when;
     * translog.ckp copy fail with an opaque NoSuchFileException after all retries; it is rejected up front instead.  
            final Translog.Location location = translog.add(
        assertTrue(statsTracker.getLastSuccessfulDownloadTimestamp() > 0);
        locs.add(addToTranslogAndList(translog, ops, new Translog.Index("3", 2, primaryTerm.get(), new byte[] { 1 })));
            translog.getDeletionPolicy().assertNoOpenTranslogRefs();
                    ops.add(op);
        when(mockTransfer.readMetadata(0)).thenReturn(metadata);  
            } else {  
                assertTrue("at least one operation pending", translog.syncNeeded());
                        public void force(boolean metaData) throws IOException {
                    logger.info("--> [{}] min gen after acquiring lock [{}]", threadId, translog.getMinFileGeneration());
                reader.readBytes(buffer, reader.getFirstOperationOffset() + 4 * numOps);
                withoutChecksum.add(String.valueOf(g));  
        assertTrue(statsTracker.getTotalUploadsSucceeded() > 0);
        persistedSeqNos.remove(SequenceNumbers.UNASSIGNED_SEQ_NO);  
                                // we need not do this concurrently as we need to make sure that the generation
                // The footer must live past the checkpoint offset so that pre-footer readers never see it.
    }
        // Update global checkpoint  
        }
                threadPool,  
    private class ThrowingBlobStore extends FsBlobStore {
            // Trims from remote now  
    }  
        // Verify that the last synced checkpoint includes the updated global checkpoint
        BlobPath path = getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()));
        RemoteFsTranslog.download(finalMockTransfer, location, logger, false, 0);  
            }
        // A generation the remote does not advertise a checksum for is passed through with null.
    protected Translog.Location addToTranslogAndListAndUpload(Translog translog, List<Translog.Operation> list, Translog.Operation op)  
import org.opensearch.core.util.FileSystemUtils;
        return new RemoteFsTranslog(
        // Case 4 - After drainSync, if an upload is an attempted, we do not upload to remote store.
                    () -> finalReader.readBytes(ByteBuffer.allocate(4), finalReader.getFirstOperationOffset() + numOps * 4)
        ) {
        }  
import org.opensearch.index.engine.MissingHistoryOperationsException;  
        assertTrue(Files.exists(location.resolve(Translog.CHECKPOINT_FILE_NAME)));
        );
        Path location = createTempDir();
            addToTranslogAndList(translog, ops, new Translog.Index("2", 1, primaryTerm.get(), new byte[] { 2 }));
            .put(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED, true)
                incumbent.close();
                            if (failed) {
            DefaultRemoteStoreSettings.INSTANCE,
                assertThrows(  
                assertArrayEquals(ckp, content);
        RemoteFsTranslog.download(manager, location, logger, false, 0);
            ClusterService clusterService,  
                translog.add(
                translogUUID,  
        long initialGlobalCheckpoint = 1L;  
        int numOps = randomIntBetween(2, 6);
        /**  
    private static long checksumOf(Path path, long length) throws IOException {
        RemoteFsTranslog.download(finalMockTransfer, location, logger, false, 0);  
    public void testFencingEnabledUploadIsFencedByASecondWriter() throws Exception {
    /**
                    assertEquals(expectedContentChecksum, reader.getTranslogContentChecksum());
    }
            Environment environment,
        assertTrue(primaryMode.get());  
import org.opensearch.index.IndexSettings;
                        tracker.markSeqNoAsProcessed(id);  
import static org.mockito.Mockito.doAnswer;
            );
                final TranslogReader finalReader = reader;
    }
        private final AtomicLong seqNoGenerator;  
    private BlobStoreRepository createRepository() {  
            );  
        assertEquals(2, translog.stats().estimatedNumberOfOperations());
        }
        assertFalse(translog.syncNeeded());
            downloadCounter.incrementAndGet();  
                    reader = translog.openReader(reader.path(), writerCheckpoint);
            addToTranslogAndListAndUpload(  
            incumbent.sync();
    }  
        }  
        assertTrue(statsTracker.getUploadBytesSucceeded() > 0);
        try (TranslogWriter writer = translog.createWriter(translog.currentFileGeneration() + 1)) {
                    final ByteBuffer buffer = ByteBuffer.allocate(4);
            }  
        addToTranslogAndList(translog, ops, new Translog.Delete("2", 1, primaryTerm.get()));  
import java.nio.charset.StandardCharsets;
        verify(mockTransfer, times(0)).downloadTranslog(any(), any(), any());  
        // Set a global checkpoint
                } else {
            terminate(threadPool);
        }
        } finally {
        try (Translog.Snapshot snapshot = translog.newSnapshot(fromSeqNo, toSeqNo, true)) {
        TranslogTransferMetadata metadata = new TranslogTransferMetadata(  
        assertEquals(2, filesPostDownload.length);  
        @Override
        assertEquals(newEmptyTranslogCheckpoint.globalCheckpoint, existingCheckpoint.globalCheckpoint);  
            );  
        translog = create(translogDir);
     * downloaded once into a fresh directory, and a second download of the same remote state fetches nothing but
    public void testRepeatedDownloadReusesLocalGenerations() throws IOException {
            assertUploadStatsNoFailures(statsTracker);
        }  
            assertTrue(  
     */
                // synced so far; capture it before closeIntoReader folds the footer bytes into the writer's checksum.
        repository.start();  
        public ThrowingBlobStore(  
        // translog.ckp is re-derived from the latest generation's checkpoint.
        when(mockTransfer.getRemoteTranslogTransferTracker()).thenReturn(mock(RemoteTranslogTransferTracker.class));
        return TestTranslog.createTranslogGeneration(random(), location, generation, true);
        final int generations = between(2, 20);  
                }  
     */  
        Map<Long, List<Translog.Operation>> operationsByGen = new HashMap<>();
        });
            addToTranslogAndList(translog, ops, new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
