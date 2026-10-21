                this.id = id;
     * return stats
        return null;
            null,
        LongConsumer persistedSequenceNumberConsumer
        );
            return "NoOp{" + "seqNo=" + seqNo + ", primaryTerm=" + primaryTerm + ", reason='" + reason + '\'' + '}';
     * Creates a new translog for the specified generation.
        // want to do here.
    /**
        public int totalOperations() {
    public static String getCommitCheckpointFileName(long generation) {
        }
        // make sure we move most of the data to disk outside of the writeLock
        }
        try {
                    throw new IllegalArgumentException(
        }
                    return op;
                            + checkpointFromDisk
        public final long generation;
            return Type.DELETE;
            primaryTermSupplier,
                out.writeOptionalString(null); // _parent
                opBytes[i] = all.slice(sliceStarts[i], sliceLens[i]);
    @Override
    /**
        }
        ShardId shardId,
    void closeFilesIfNoPendingRetentionLocks() throws IOException {
        public Source getSource() {
        final long initialGlobalCheckpoint,
     * @param globalCheckpointSupplier        a supplier for the global checkpoint
        readLock = new ReleasableLock(rwl.readLock());
                    return new Index(input);
            if (Files.exists(commitCheckpoint)) {
            operation = Translog.Operation.readOperation(in);
                        "checkpoint file "
        Type opType();
            for (Iterator<TranslogReader> iterator = readers.iterator(); iterator.hasNext();) {
    private Stream<? extends BaseTranslogReader> readersAboveMinSeqNo(long minSeqNo) {
        return Math.max(0, currentTime - Math.min(earliestTime, writer.getLastModifiedTime()));
     * <p>
            out.writeBytesReference(source);
            if (readers.isEmpty()) {
            return new TranslogStats.Builder().numberOfOperations(totalOperations())
            }
            getMinFileGeneration(),
            }
        final LongSupplier primaryTermSupplier,
    ) throws IOException {
    }
        public static final int SERIALIZATION_FORMAT = FORMAT_ROUTING;
     *  Returns <code>true</code> if an fsync is required to ensure durability of the translogs operations or it's metadata.
            IOUtils.close(channel);
    /**
        private static final int FORMAT_6_0 = 4; // 6.0 - *
     * translog UUID could cause a lot of issues and that's why in all (but one) cases the method
                    current.sync();
        }
            TranslogHeader.read(expectedTranslogUUID, translogFile, channel);
     * @param toSeqNo   the upper bound of the range (inclusive)
    protected TranslogWriter current;
        final long primaryTerm,
        Translog.Operation next() throws IOException;
            this.routing = routing;
        // the list of inner callers should be either empty or should contain closeOnTragicEvent method
                case NO_OP:
                return null;
    /**
     * @opensearch.api
            assert maxSeqNo.isPresent() : "must have at least one translog generation";
        public final String routing;
     * Roll the current translog generation into a new generation if it's not empty. This does not commit the translog.
        public boolean equals(Object obj) {
        }
                            + i
    /**
                // create a new translog file; this will sync it and update the checkpoint data;
            config,
        );
        @Nullable final ChannelFactory factory,
import org.opensearch.index.shard.IndexShardComponent;
                    closeFilesIfNoPendingRetentionLocks();
            }
        }
    /**
        try (ReleasableLock lock = readLock.acquire()) {
    public enum Durability {
        }
        long fileGeneration,
        }
        return getLastSyncedCheckpoint().globalCheckpoint;
                .sum();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            translogOperationHelper,
            translogUUID,
                return current.add(opBytes, seqNos);
    }
                in.readByte(); // versionType
        final Path location,
import org.opensearch.index.VersionType;
 * software distributed under the License is distributed on an
     * @param factory                 a {@link ChannelFactory} used to open translog files
            }
        @Override
                .filter(reader -> reader.getCheckpoint().minSeqNo <= toSeqNo && fromSeqNo <= reader.getCheckpoint().maxEffectiveSeqNo())
        /**
                tragedy.setTragicException(e);
            }
            } finally {
        long primaryTerm
        } finally {
                globalCheckpointSupplier,
                closeOnTragicEvent(e);
    ) throws IOException {
            if (closed.get()) {
     * @param primaryTermSupplier             a supplier for the latest value of primary term of the owning index shard. The latest term value is
        final LongConsumer persistedSequenceNumberConsumer
            try {
            }
    void syncBeforeRollGeneration() throws IOException {
        }
     * shares the same underlying resources with the {@code delegate} snapshot, therefore we should not
    }
                            + commitCheckpoint.getFileName()
            for (long i = checkpoint.generation; i >= minGenerationToRecoverFrom; i--) {
        }
    public TranslogConfig getConfig() {
            tempFileRenamed = true;
        }
    /**
        final Path location,
            collect(Collectors.toList());
                toClose.close();
        }
import java.util.function.LongSupplier;
    }
                                + "], operation term["
        ASYNC,
                    ((NoOp) operation).write(output);
    protected void copyCheckpointTo(Path targetPath) throws IOException {
        assert fromSeqNo >= 0 : "from_seq_no must be non-negative " + fromSeqNo;
        boolean tempFileRenamed = false;
     * Returns the size in bytes of the v files
     */
 * different engine.
                this::getMinFileGeneration,
    }
        }
     *
        }
        }
        @Override
        } catch (final Exception ex) {
    public static String createEmptyTranslog(
            + ", header size ["
            }
     * @param fileGeneration          the generation of the write to be written
                }
        }
                return false;
        }
        final LongSupplier globalCheckpointSupplier,
     * @param location                a {@link Path} to the directory that will contains the translog files (translog + translog checkpoint)
    /**
 */
    public int totalOperationsByMinGen(long minGeneration) {
                .map(BaseTranslogReader::newSnapshot)
        try (FileChannel channel = FileChannel.open(highestGenTranslogFile, StandardOpenOption.READ)) {
            this.primaryTerm = primaryTerm;
                return;
    public static final String CHECKPOINT_FILE_NAME = "translog" + CHECKPOINT_SUFFIX;
            deletionPolicy.minTranslogGenRequired(readers, current),
     * @opensearch.api
        }
     * write lock in the course of closing the translog
                );
import java.util.regex.Pattern;
                            + " recovering from: "
        }
 * is written on each fsync operation of the translog and records the number of operations written, the current translog's file generation,
                    "Trimming the translog can only be done for terms lower than the current one. "
                    + "]";
            }
        public String toString() {
 *
     */
                return false;
    /** Returns {@code true} if this {@code Translog} is still open. */
        public String reason() {
        /**
     */
            }
        try {
 * When the current translog file reaches a certain size ({@link IndexSettings#INDEX_TRANSLOG_GENERATION_THRESHOLD_SIZE_SETTING}, or when
                    "Not all operations between from_seqno [" + fromSeqNo + "] " + "and to_seqno [" + toSeqNo + "] found"
            + "] which is higher than the current generation ["
                logger.debug("recovered local translog from checkpoint {}", checkpoint);
     * This method should be used directly under specific circumstances like for shards that will see no indexing. Specifying a non-unique
        } catch (final IOException e) {
            generation,
            if (o == null || getClass() != o.getClass()) {
import java.util.Objects;
            if (this == obj) {
     * Reads a list of operations written with {@link #writeOperations(StreamOutput, List)}
            config,
                    + current.generation
    @PublicApi(since = "1.0.0")
     */
    }
        this.translogOperationHelper = translogOperationHelper;
                case CREATE:
     */
        @Override
                + seqNo
            }
    }
            + DEFAULT_HEADER_SIZE_IN_BYTES
     * deletes all files associated with a reader. package-private to be able to simulate node failures at this point
        return newSnapshot(0, Long.MAX_VALUE);
            + "]";
                    throw new TranslogCorruptedException(
                current = createWriter(current.getGeneration() + 1);
        }
            final int[] sliceStarts = new int[count];
    /**
            this.autoGeneratedIdTimestamp = in.readLong();
            + "]";
            onClose = () -> {};
                }
            }
            uuid,
    protected void onDelete() {}
    }
     *                                With no readers and no current, a call to  {@link #getMinFileGeneration()} would not work.
            return this.current.sizeInBytes() > threshold;
            out.writeLong(seqNo);
            final int format = in.readVInt();// SERIALIZATION_FORMAT
                            + " already exists but has corrupted content: expected "
                            + "], operation term["
     */
    public static String createEmptyTranslog(
    public static final Translog.Location EMPTY_TRANSLOG_LOCATION = new Translog.Location(0, 0, 0);
     * locations must be synced.
            final int format;
        syncBeforeRollGeneration();
                .mapToInt(BaseTranslogReader::totalOperations)
                return false;
    protected final LongConsumer persistedSequenceNumberConsumer;
        // move most of the data to disk to reduce the time the write lock is held
        }
        return () -> {
        );
     * @param translogOperationHelper         a helper method to validate translog operations with the support of derived source
        final long generation
        assert minReferencedGen >= getMinFileGeneration() : "deletion policy requires a minReferenceGen of ["
        }
     * Writes all operations in the given iterable to the given output stream including the size of the array
    public static final String TRANSLOG_UUID_KEY = "translog_uuid";
            return "Index{"
                                                                                                                          // and version
    public static class NoOp implements Operation {
     *
        }
                + "seqNo="
    ) throws IOException {
     * e.g. disk full while flushing a new segment, this returns the root cause exception.
                        return DELETE;
                 * https://github.com/elastic/elasticsearch/issues/15941.
         * Writes the type and translog operation to the given stream
            throw new TranslogException(shardId, "Failed to write operation [" + operation + "]", ex);
                }
        out.writeInt((int) checksum);
     * Secondary constructor, this should only be called if index is normal and not for derived source
        final long threshold = this.indexSettings.getGenerationThresholdSize().getBytes();
            this.autoGeneratedIdTimestamp = autoGeneratedIdTimestamp;
        final TranslogOperationHelper translogOperationHelper,
        }
    @PublicApi(since = "1.0.0")
        final TranslogOperationHelper translogOperationHelper
    }
        final int count = operations.size();
     */
import java.util.stream.Collectors;
    public long getLastSyncedGlobalCheckpoint() {
        }
            // when we clean up files, we first update the checkpoint with a new minReferencedTranslog and then delete them;
        try (ReleasableLock ignored = readLock.acquire()) {
            persistedSequenceNumberConsumer,
            final int format = in.readVInt(); // SERIALIZATION_FORMAT
                .translogSizeInBytes(sizeInBytes())
                initialGlobalCheckpoint,
            final long minGenerationToRecoverFrom = checkpoint.minTranslogGeneration;
        }
                || id.equals(index.id) == false
        Files.createDirectories(location);
    }
        IOUtils.deleteFilesIgnoringExceptions(
        try (ReleasableLock lock = readLock.acquire()) {
        }
    /**
        Translog.Operation.writeOperation(out, op);
                }
                // read backwards - it's likely we need to read on that is recent
                final TranslogReader reader = current.closeIntoReader();
        public Index(Engine.Index index, Engine.IndexResult indexResult) {
                            + "], operation term["
                }
        final ShardId shardId,
                out.writeByte(VersionType.EXTERNAL.getValue());
        }
                        );
            // we open files in reverse order in order to validate the translog uuid before we start traversing the translog based on
                return false;
 * this work for additional information regarding copyright
        @Override
            closeOnTragicEvent(ex);
        }
            if (closed.get()) {
    protected ArrayList<TranslogReader> recoverFromFiles(Checkpoint checkpoint) throws IOException {
        @Override
            if (routing != null ? !routing.equals(index.routing) : index.routing != null) {
        try (FileChannel channel = FileChannel.open(translogFile, StandardOpenOption.READ)) {
     *
            return result;
        }
                : "all readers were cleaned but the minReferenceGen ["
        final long initialGlobalCheckpoint,
    }
    }
     * Returns the size in bytes of the translog files at least the given generation
            primaryTerm,
                ArrayList<Closeable> toClose = new ArrayList<>(readers);
            out.writeOptionalString(routing);
     *
            Snapshot result = new MultiSnapshot(snapshots, onClose, readForward);
        }
        }
            }
        assert calledFromOutsideOrViaTragedyClose()
                        + "current term["
            throw new TranslogException(shardId, "Unable to get the earliest last modified time for the transaction log");
    public long getMinUnreferencedSeqNoInSegments(long minUnrefCheckpointInLastCommit) {
     * @throws IllegalArgumentException if the path doesn't match the expected pattern.
            final NoOp that = (NoOp) obj;
        // acquire lock to make the two numbers roughly consistent (no file change half way)
            if (closed.get() && deletionPolicy.pendingTranslogRefCount() == 0) {
                        assert false : "Operation term is newer than the current term; "
        return location;
                    throw new TranslogCorruptedException(
     * Trims translog for terms of files below <code>belowTerm</code> and seq# above <code>aboveSeqNo</code>.
        try (ReleasableLock ignored = readLock.acquire()) {
                in.reset();
            }
            public static Type fromId(byte id) {
                throw new UnsupportedOperationException();
        @Nullable final String translogUUID,
     */
            if (tempFileRenamed == false) {
    }
        }
     * @param primaryTerm             the shard's primary term to initialize the translog with
            return false;
            return this.routing;
            + writer.sizeInBytes()
            IOUtils.fsync(targetPath.getParent(), true);
                    default:
            final long[] seqNos = new long[count];
    /**
     * References a transaction log generation
     */
            this(id, seqNo, primaryTerm, Versions.MATCH_ANY, source, null, -1);
        public Delete(String id, long seqNo, long primaryTerm) {
    /**
    }
        }
            globalCheckpointSupplier,
        private final String id;
    }
            if (format < FORMAT_NO_PARENT) {
            assert Translog.parseIdFromFileName(path) == checkpoint.generation : "expected generation: "
            this.seqNo = indexResult.getSeqNo();
    /**
     * @return {@code true} if the current generation should be rolled to a new generation
            return routing;
            }
                logger.trace("current translog set to [{}]", current.getGeneration());
     */
        private final String id;
    /**
            ensureOpen();
 * operation etc. are still preserved.
    /**
            out.writeInt(operationSize);
        public long primaryTerm() {
        public static final int FORMAT_NO_VERSION_TYPE = FORMAT_NO_PARENT + 1;
/*
     *
        public Location(long generation, long translogLocation, int size) {
        if (closed.get()) {
        return newSnapshot(fromSeqNo, toSeqNo, false);
        enum Type {
                try {
    }
            TranslogSnapshot[] snapshots = Stream.concat(readers.stream(), Stream.of(current))
    public Snapshot newSnapshot(long fromSeqNo, long toSeqNo, boolean requiredFullRange) throws IOException {
            }
     *                                        examined and stored in the header whenever a new generation is rolled. It's guaranteed from outside
                IOUtils.close(toClose);
            TranslogReader reader = TranslogReader.open(channel, path, checkpoint, translogUUID);
     * @throws IOException                if an I/O exception occurred reading the checkpoint
            reader.path().resolveSibling(getCommitCheckpointFileName(reader.getGeneration()))
            this.version = version;
        }
            // we first copy this into the temp-file and then fsync it followed by an atomic move into the target file
                for (int i = 0; i < count; i++) {
                location.resolve(Translog.getFilename(minGenerationToRecoverFrom - 1)),
     */
            onClose = acquireTranslogGenFromDeletionPolicy(snapshots[0].generation);
        }
            if (out.getVersion().onOrAfter(Version.V_3_9_0)) {
    }
    /*
     * @opensearch.api
        }
     * @opensearch.internal
            primaryTerm = in.readLong();
                .build();
        );
            channel = null;
        private final long primaryTerm;
    final Checkpoint getLastSyncedCheckpoint() {
        }
                            + " - translog ids must be consecutive"
        public Translog.Operation next() {
        private NoOp(final StreamInput in) throws IOException {
        }
    public static List<Operation> readOperations(StreamInput input, String source) throws IOException {
        out.resetDigest();
    /**
     * Reads the sequence numbers global checkpoint from the translog checkpoint.
                + '\''
     * this method will return <code>null</code>.
                initialMinTranslogGen,
        }
            throw new UnsupportedOperationException("source does not exist for a no-op");
    protected static boolean calledFromOutsideOrViaTragedyClose() {
        final TranslogWriter writer = TranslogWriter.create(
            channelFactory,
            switch (type) {
        }
     */
    /**
    public Exception getTragicException() {
        final TranslogHeader translogHeader;
    public Path location() {
            }
 * Licensed to Elasticsearch under one or more contributor
    }
            closeOnTragicEvent(ex);
        } catch (final AlreadyClosedException | IOException ex) {
     * (translog or checkpoint files).
            out.writeVInt(format);
     */
                + " but got: "
        } finally {
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
     * @throws IOException if something went wrong during translog creation
        final Path location,
 * a clear separation between old and new operations (upon change in primary term), the current file is reopened for read only and a new
                + '}';
            }
                            + checkpoint.generation
            }
                }
        assert config.getIndexSettings().isDerivedSourceEnabled() == false; // For derived source supported index, it is incorrect to use
    private Closeable acquireTranslogGenFromDeletionPolicy(long viewGen) {
            if (format >= FORMAT_ROUTING) {
        public String id() {
                    // the serialization logic in Index was identical to that of Create when create was deprecated
     *                                        persisted.
            checkpoint.generation + 1
     * Returns the age of the oldest entry in the translog files in seconds
        // we can not hold a read lock here because closing will attempt to obtain a write lock and that would result in self-deadlock
     *
                .filter(r -> r.getGeneration() >= minGeneration)
                        "Operation term is newer than the current term; "
                in.skip(opSize - 4);
        TranslogDeletionPolicy deletionPolicy,
                        throw new IllegalArgumentException(
        final TranslogConfig config,
        public long seqNo() {
        }
            return this.source;
import java.util.function.LongConsumer;
        return uuid;
                    final TranslogReader newReader = reader.getPrimaryTerm() < belowTerm
import java.util.ArrayList;
import org.opensearch.common.util.io.IOUtils;
        @Override
            + getMinFileGeneration()
    public Location getLastWriteLocation() {
            public byte id() {
        );
                .max();
import static org.opensearch.index.translog.TranslogConfig.EMPTY_TRANSLOG_BUFFER_SIZE;
        public Index(String id, long seqNo, long primaryTerm, long version, byte[] source, String routing, long autoGeneratedIdTimestamp) {
    }
            persistedSequenceNumberConsumer,
            + "]";
            primaryTerm = in.readLong();
            SequenceNumbers.NO_OPS_PERFORMED,
     */
import org.opensearch.core.common.io.stream.BufferedChecksumStreamInput;
        return current;
        final LongSupplier globalCheckpointSupplier,
        public long estimateSize() {
                assert readers.stream().map(TranslogReader::getGeneration).min(Long::compareTo).get().equals(readers.get(0).getGeneration())
import org.opensearch.index.IndexSettings;
                        + "]";
        @Override
        for (BaseTranslogReader r : readers) {
                format = FORMAT_NO_VERSION_TYPE;
import org.opensearch.core.common.bytes.BytesReference;
            return (2 * id.length()) + source.length() + (routing != null ? 2 * routing.length() : 0) + (4 * Long.BYTES); // timestamp,
                routing = null;
    }
         * The total estimated number of operations in the snapshot.
                getChannelFactory(),
 */
            if (seqNo <= reader.getCheckpoint().maxEffectiveSeqNo()) {
     * Translog no op
import java.nio.file.StandardOpenOption;
                + version
            this.seqNo = seqNo;
        sync();
            this.id = Objects.requireNonNull(id);
    static void verifyChecksum(BufferedChecksumStreamInput in) throws IOException {
                + primaryTerm
        if (tragedy.get() != null) {
            ensureOpen();
            out.seek(start);
        private final long primaryTerm;
            if (format < FORMAT_NO_DOC_TYPE) {
    /**
                out.writeString(IdFieldMapper.NAME);
                // we are sending translogs across the network with LZ4 compression enabled - currently there is no way s
                 * Don't do anything in this case. The AlreadyClosedException comes from TranslogWriter and we should not add it as
    public int totalOperations() {
        }
            this.requiredFullRange = requiredFullRange;
            }
                // no need to fsync here the read operation will ensure that buffers are written to disk
     *
        }
            closeOnTragicEvent(ex);
         */
                IOUtils.closeWhileHandlingException(foundTranslogs);
        final ChannelFactory channelFactory
                            + checkpoint
        }
     * The last synced checkpoint for this translog.
        return createEmptyTranslog(location, shardId, initialGlobalCheckpoint, primaryTerm, null, channelFactory);
                // Can't assert that this is _doc because pre 2.0 indexes can have any name for a type
     * @param location the location of the translog
     */
                    if (operation.primaryTerm() > current.getPrimaryTerm()) {
    public void sync() throws IOException {
        try (ReleasableLock ignored = readLock.acquire()) {
        private final long seqNo;
    TranslogReader openReader(Path path, Checkpoint checkpoint) throws IOException {
    protected final TranslogDeletionPolicy deletionPolicy;
        return deletionPolicy;
                copyCheckpointTo(commitCheckpoint);
        final Path translogFile = location.resolve(getFilename(checkpoint.generation));
     * A snapshot of the transaction log, allows to iterate over all the transaction log operations.
        final Path translogFile = location.resolve(getFilename(generation));
            this.translogUUID = translogUUID;
    /**
    }
                + autoGeneratedIdTimestamp
            final List<TranslogReader> newReaders = new ArrayList<>(readers.size());
            ensureOpen();
 * specific language governing permissions and limitations
            int result = id.hashCode();
            NO_OP((byte) 4);
                out.writeByte(VersionType.EXTERNAL.getValue());
    public Translog(
    }
    /**
             * We use position = current - 1 and size = Integer.MAX_VALUE here instead of position current and size = 0 for two reasons:
            filter(f -> {
     * is based on the size of the current generation compared to the configured generation
    }
            for (int i = 0; i < count; i++) {
                bigArrays,
    public void rollGeneration() throws IOException {
            this.primaryTerm = primaryTerm;
        } catch (final AlreadyClosedException | IOException ex) {
                }
    /**
            if (in.markSupported()) { // if we can we validate the checksum first
            Collections.reverse(foundTranslogs);
        public String id() {
            // the generation id we found in the lucene commit. This gives for better error messages if the wrong
        public final BytesReference source;
        // a temp file to copy checkpoint to - note it must be in on the same FS otherwise atomic move won't work
            }
 * You may obtain a copy of the License at
            assert readers.isEmpty() == false || current.generation == minReferencedGen
                in.getSource(),
            Location location = (Location) o;
            return ensureSynced(max.get());
    }
                try {
        );
                /*
        boolean success = false;
     */
                if (checkpoint.equals(checkpointFromDisk) == false) {
                ensureOpen();
                // The checkpoint is used when opening the translog to know which files should be recovered from.
     * @param ex if an exception occurs closing the translog, it will be suppressed into the provided exception
    }
     *
            return result;
            try (ReleasableLock ignored = readLock.acquire()) {
                } finally {
            }
 * write only file is created. Any non-current, read only translog file always has a {@code translog-${gen}.ckp} associated with it
        try {
                + 1 // writeOptionalString presence byte
 *
        final Closeable onClose;
        @Override
        final Checkpoint checkpoint = readCheckpoint(location);
        @Override
        }
            out.writeLong(seqNo);
                        + belowTerm
    }
 * ownership. Elasticsearch licenses this file to you under
            switch (operation.opType()) {
        } catch (final Exception ex) {
        @Override
     *
     * the generation is not {@code null}, this method tries to open the given translog generation. The generation is treated as the last
    }
            } else {
        }
     * @param translogUUID            the unique identifier to initialize the translog with
            () -> { throw new UnsupportedOperationException(); },
     * Tests whether or not the translog generation should be rolled to a new generation. This test
import java.util.concurrent.locks.ReentrantReadWriteLock;
                case DELETE:
        int totalOperations();
import org.opensearch.index.mapper.IdFieldMapper;
    public static class Location implements Comparable<Location> {
        final TranslogWriter writer = createWriter(
     *
import org.opensearch.common.lucene.uid.Versions;
            final long minReferencedGen = getMinReferencedGen();
            primaryTerm,
        long earliestTime = currentTime;
                iterator.remove();
import org.opensearch.index.shard.AbstractIndexShardComponent;
        Files.createDirectories(this.location);
        long initialGlobalCheckpoint,
        assert fromSeqNo <= toSeqNo : fromSeqNo + " > " + toSeqNo;
    }
    protected void ensureOpen() {
                if (Files.exists(committedTranslogFile) == false) {
            }
            verifyChecksum(in);
        try (ReleasableLock ignored = readLock.acquire()) {
        final Checkpoint checkpoint = readCheckpoint(location, expectedTranslogUUID);
        assert readLock.isHeldByCurrentThread() || writeLock.isHeldByCurrentThread()
            return seqNo == that.seqNo && primaryTerm == that.primaryTerm && reason.equals(that.reason);
        public int hashCode() {
        public long version() {
            success = true;
            IOUtils.deleteFilesIgnoringExceptions(
        return newWriter;
     * Returns the max seq_no of translog operations found in this translog. Since this value is calculated based on the current
     */
                // we are sometimes called when mark is not supported this is the case when
                logger.trace("delete translog file [{}], not referenced and not current anymore", translogPath);
    public static final class TranslogGeneration {
            throw ex;
        public long version() {
        final LongSupplier primaryTermSupplier,
        Releasable toClose = deletionPolicy.acquireTranslogGen(viewGen);
     */
            seqNo = in.readLong();
                                + operation
                        return CREATE;
    /**
            this.delegate = delegate;
     *    need to be able to do random access reads even from the buffer
        public final long translogLocation;
                location.resolve(getFilename(fileGeneration)),
            }
 * {@code translog.ckp} file that is designed to fit in a single disk block such that a write of the file is atomic. The checkpoint file
            if (format < FORMAT_NO_DOC_TYPE) {
        }
        }
            }
                closeFilesIfNoPendingRetentionLocks();
     * Gets the minimum generation that could contain any sequence number after the specified sequence number, or the current generation if
                                + "current term["
                            + current.getPrimaryTerm()
import org.opensearch.common.util.concurrent.ReleasableLock;
    }
                in.readByte(); // _version_type
     */
        try (ReleasableLock ignored = writeLock.acquire()) {
                    + "]";
             * 2. It feels more right to return a *position* that is before the next write's position rather than rely on the size.
                            + operation
        // first check under read lock if any readers can be trimmed
        @Override
            if (opSize < 4) { // 4byte for the checksum
    }
     *                                        and reject operation whose term is higher than the primary term stored in the translog header.
import java.util.Arrays;
 * <p>
        try (ReleasableLock ignored = readLock.acquire()) {
            ensureOpen();
     */
    public void close() throws IOException {
        if (max.isPresent()) {
                + readLock.isHeldByCurrentThread()
    public String getTranslogUUID() {
                            + "current term["
            return 0;
    }
        static Operation readOperation(final StreamInput input) throws IOException {
    ChannelFactory getChannelFactory() {
        }
        // because closing it closes the underlying stream, which we don't
        long primaryTerm();
        public Type opType() {
            Index index = (Index) o;
        public TranslogGeneration(String translogUUID, long translogFileGeneration) {
}
            result = 31 * result + Long.hashCode(primaryTerm);
    /*
            out.writeLong(version);
        }
    }
        }
    private static final class SeqNoFilterSnapshot implements Snapshot {
            IOUtils.fsync(tempFile, false);
            closeOnTragicEvent(ex);
            seqNo = in.readLong();
     *                                        that a new generation is rolled when the term is increased. This guarantee allows to us to validate
     * Returns the number of operations in the translog files
            reader.path(),
            closeOnTragicEvent(ex);
        return foundTranslogs;
            ensureOpen();
    protected final ChannelFactory channelFactory;
     * @param persistedSequenceNumberConsumer a callback that's called whenever an operation with a given sequence number is successfully
                if (operation.primaryTerm() > current.getPrimaryTerm()) {
     * @throws IOException if adding the operations to the translog resulted in an I/O exception
    public static String getFilename(long generation) {
                final Path translogPath = reader.path();
            result = 31 * result + Long.hashCode(autoGeneratedIdTimestamp);
         */
            out.writeLong(primaryTerm);
        return operations;
                return readers.get(0).getGeneration();
    }
            out.writeLong(version);
            if (o == null || getClass() != o.getClass()) {
    public long sizeInBytesByMinGen(long minGeneration) {
        try (Releasable ignored = writeLock.acquire()) {
            this.version = version;
     * required generation
        return createEmptyTranslog(location, shardId, initialGlobalCheckpoint, primaryTerm, translogUUID, factory, 1);
    protected void closeOnTragicEvent(final Exception ex) {
        try (ReleasableLock ignored = readLock.acquire()) {
                    "number formatting issue in a file that passed " + pattern.pattern() + ": " + fileName + "]",
    ) throws IOException {
                sliceStarts[i] = (int) sliceStart;
        @Override
        try (ReleasableLock ignored = readLock.acquire()) {
            closeOnTragicEvent(ex);
            if (this == o) {
     * @opensearch.internal
 * compatible open source license.
     */
        Path location,
                    );
     *
                TranslogReader reader = iterator.next();
            throw ex;
     * Extracts the translog generation from a file name.
            }
            }
        private final BytesReference source;
 * license agreements. See the NOTICE file distributed with
    /**
        try (ReleasableLock ignored = readLock.acquire()) {
        final long primaryTerm,
 * SPDX-License-Identifier: Apache-2.0
 * which is an fsynced copy of its last {@code translog.ckp} such that in disaster recovery last fsynced offsets, number of
                            "Operation term is newer than the current term; "
    /**
            }
     * generation. See {@link #PARSE_STRICT_ID_PATTERN} (translog files only) and {@link #STRICT_TLOG_OR_CKP_PATTERN}
                            + current.getPrimaryTerm()
        };
                    case 4:
                final Checkpoint readerCheckpoint = i == checkpoint.generation
                case NO_OP:
        IOUtils.rm(location);
    /**
                in.readString();
     */
            Releasables.close(out);
            }
            }
import org.opensearch.index.mapper.MapperService;
import org.opensearch.common.util.BigArrays;
                assert reader.getPrimaryTerm() <= primaryTermSupplier.getAsLong() : "Primary terms go backwards; current term ["
    This might be required when segments are persisted via other mechanism than flush.
                // Note that there is a provision in recoverFromFiles to allow for the case where we synced the checkpoint
     *
            for (Operation op : toWrite) {
    }
                format = SERIALIZATION_FORMAT;
                + "id='"
    protected final TranslogOperationHelper translogOperationHelper;
        final TranslogConfig config,
            return 0;
        return config;
        public Operation next() throws IOException, MissingHistoryOperationsException {
                        throw new IllegalArgumentException("no type mapped for [" + id + "]");
            Files.move(tempFile, targetPath, StandardCopyOption.ATOMIC_MOVE);
    TranslogWriter createWriter(long fileGeneration) throws IOException {
        private void write(final StreamOutput out) throws IOException {
                if (reader.getGeneration() >= minReferencedGen) {
        try (ReleasableLock lock = writeLock.acquire()) {
        }
     */
                tragedy,
            Releasables.close(out);
        long minGen = writer.generation;
import java.util.stream.Stream;
     * Returns the translog uuid used to associate a lucene index with a translog.
        // This absolutely must come first, or else reading the checksum becomes part of the checksum
    protected final LongSupplier globalCheckpointSupplier;
                    Files.delete(tempFile);
            translogFile,
    /**
        @Override
                out.seek(start);
            : "Translog.close method is called from inside Translog, but not via closeOnTragicEvent method";
import org.opensearch.Version;
    }
            if (format < FORMAT_NO_DOC_TYPE) {
     * The source in the translog
            Files.copy(location.resolve(CHECKPOINT_FILE_NAME), tempFile, StandardCopyOption.REPLACE_EXISTING);
    }
                IOUtils.closeWhileHandlingException(reader);
            Translog.Operation op;
            if (format < FORMAT_NO_DOC_TYPE) {
import org.apache.logging.log4j.message.ParameterizedMessage;
    protected final TragicExceptionHolder tragedy = new TragicExceptionHolder();
import org.opensearch.common.lease.Releasables;
            // update all existed ones (if it is necessary) as checkpoint and reader are immutable
        final Checkpoint checkpoint = readCheckpoint(location, expectedTranslogUUID);
            }
            this.readers.addAll(newReaders);
            long sliceStart = 0;
                                + current.getPrimaryTerm()
    public Closeable acquireRetentionLock() {
     * @param translogUUID                    the translog uuid to open, null for a new translog
            },
                + ", autoGeneratedIdTimestamp="
 * this file be licensed under the Apache-2.0 license or a
                        + "], operation term["
                .uncommittedOperations(totalOperationsByMinGen(uncommittedGen))
    static final Pattern STRICT_TLOG_OR_CKP_PATTERN = Pattern.compile("^" + TRANSLOG_FILE_PREFIX + "(\\d+)(\\.ckp|\\.tlog)$");
                    opsCount++;
        public Delete(String id, long seqNo, long primaryTerm, long version, String routing) {
                    + Long.toHexString(readChecksum)
                assert Checkpoint.read(location.resolve(CHECKPOINT_FILE_NAME)).generation == current.getGeneration();
     * Returns the number of operations in the transaction files that contain operations with seq# above the given number.
                        return INDEX;
        return checkpoint.minTranslogGeneration;
                }
    @PublicApi(since = "1.0.0")
                if (fromSeqNo <= op.seqNo() && op.seqNo() <= toSeqNo) {
 * log that belongs to a
            ensureOpen();
        public long primaryTerm() {
import org.apache.lucene.store.AlreadyClosedException;
                }
                return true;
        bigArrays = config.getBigArrays();
        }
        }
     *    but we can refactor as we go
        @Override
     * @throws IOException if adding the operation to the translog resulted in an I/O exception
    public static class Delete implements Operation {
    // for testing
        @Override
                                + "]"
        final LongSupplier globalCheckpointSupplier,
         * Async durability - translogs are synced based on a time interval.
import java.nio.channels.FileChannel;
            this.routing = routing;
    static Checkpoint readCheckpoint(final Path location) throws IOException {
            // we only fsync the directory the tempFile was already fsynced
        }
                );
    /**
        // we only need to sync the max location since it will sync all other
        final String translogUUID,
     * @throws IOException                if an I/O exception occurred reading the checkpoint
            final long viewGen = getMinFileGeneration();
            this.seqNo = seqNo;
         */
     * Returns the generation of the current transaction log.
                .earliestLastModifiedAge(earliestLastModifiedAge())
            translogUUID,
 * </p>
            if (format >= FORMAT_ROUTING) {
                + version
            final BytesReference[] opBytes = new BytesReference[count];
        @Override
            out.writeVInt(format);
                + "]";
     */
                + id
        boolean success = false;
        }
        @Override
        } catch (final Exception ex) {
    protected final Path location;
     * {@link #createEmptyTranslog(Path, long, ShardId, long)} should be used instead.
            this.source = source;
            /*
        }
        } else {
    }
                    ((Index) operation).write(output);
    public static class Index implements Operation {
        super(config.getShardId(), config.getIndexSettings());
        writeLock = new ReleasableLock(rwl.writeLock());
        @Override
        long seqNo();
                    ? checkpoint
    public interface Snapshot extends Closeable {
import java.util.regex.Matcher;
     */
            out.writeString(reason);
            out.writeString(id);
        this.persistedSequenceNumberConsumer = persistedSequenceNumberConsumer;
        return minUnrefCheckpointInLastCommit;
            throw ex;
                    e
    }
        assert readLock.isHeldByCurrentThread() == false : Thread.currentThread().getName();
            throw ex;
                throw new UnsupportedOperationException();
        SeqNoFilterSnapshot(Snapshot delegate, long fromSeqNo, long toSeqNo, boolean requiredFullRange) {
                logger.trace("closing files. translog is closed and there are no pending retention locks");
            throw new AlreadyClosedException("translog is already closed", tragedy.get());
/**
                + ", primaryTerm="
            if (closed.get() == false) {
                .filter(r -> r.getGeneration() >= minGeneration)
        private final String routing;
            } catch (final AlreadyClosedException inner) {
                    return new Delete(input);
            final int opSize = in.readInt();
            return this.version;
            return current.getLastSyncedCheckpoint();
     * @throws TranslogCorruptedException if the translog is corrupted or mismatched with the given uuid
        @Override
        } finally {
    public static String createEmptyTranslog(
            while ((op = delegate.next()) != null) {
    }
                return current.getGeneration();
    }
        public String toString() {
            final BufferedChecksumStreamOutput checksumStreamOutput = new BufferedChecksumStreamOutput(out);
 * KIND, either express or implied.  See the License for the
                                                                                                    // and close method frames
                // We now update the checkpoint to ignore the file we are going to remove.
     * {@code primaryTerm} and {@code translogUUID}.
     */
/*
            globalCheckpointSupplier.getAsLong(),
@PublicApi(since = "1.0.0")
            deletionPolicy,
        public String routing() {
            }
                in.mark(opSize);
    /**
                        : reader;
     *
            }
                        "translog file doesn't exist with generation: "
         */
    /**
     */
            } else if (out.getVersion().onOrAfter(Version.V_2_0_0)) {
            }
        }
                switch (id) {
        return totalOperationsByMinGen(-1);
import org.opensearch.index.engine.MissingHistoryOperationsException;
            seqNo = in.readLong();
            int result = Long.hashCode(seqNo);
            Releasables.close(out);
        }
    @PublicApi(since = "1.0.0")
        }
     */
    long earliestLastModifiedAge() {
            return true;
            throw new TruncatedTranslogException(in.getSource(), "reached premature end of file, translog is truncated", e);
            this.routing = routing;
            if (current.generation == location.generation) {
    public static void writeOperations(StreamOutput outStream, List<Operation> toWrite) throws IOException {
                    }
    public boolean ensureSynced(Stream<Location> locations) throws IOException {
                out.writeString(MapperService.SINGLE_MAPPING_NAME);
            result = 31 * result + Long.hashCode(translogLocation);
                return Long.parseLong(matcher.group(1));
        this.deletionPolicy = deletionPolicy;
     *  - we need random exception on the FileSystem API tests for all this.
    /**
            return new Location[] { add(operations.get(0)) };
        private void write(final StreamOutput out) throws IOException {
        private Index(final StreamInput in) throws IOException {
        final long initialGlobalCheckpoint,
    /** recover all translog files found on disk */
    public boolean isOpen() {
                seqNos[i] = operation.seqNo();
     * use {@link #readOperations(StreamInput, String)} to read it back.
import java.nio.file.StandardCopyOption;
            throw ex;
 * </p>
            id = in.readString();
        return writer;
                closeOnTragicEvent(e);
    /**
    }
            this.routing = index.routing();
        try (ReleasableLock ignored = readLock.acquire()) {
            result = 31 * result + Long.hashCode(version);
    }
    }
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;
    }
     * This method allows for internal optimization to minimize the amount of fsync operations if multiple
import java.util.Iterator;
import org.opensearch.index.engine.Engine;
    }
            return acquireTranslogGenFromDeletionPolicy(viewGen);
     * directories holding the transaction logs.
            assert format >= FORMAT_6_0 : "format was: " + format;
        long readChecksum = Integer.toUnsignedLong(in.readInt());
     * @return the last synced checkpoint
                                                                            // this constructor
                            + "current term["
            translogUUID,
            if (current.getPrimaryTerm() < belowTerm) {
            final BytesReference bytes = out.bytes();
        try {
     *
            private final byte id;
     * @return the minimum translog generation
            long uncommittedGen = getMinGenerationForSeqNo(deletionPolicy.getLocalCheckpointOfSafeCommit() + 1).translogFileGeneration;
            assert Arrays.stream(snapshots).map(BaseTranslogReader::getGeneration).min(Long::compareTo).get() == snapshots[0].generation
            if (version != index.version
                && Objects.equals(routing, delete.routing);
            } catch (final Exception inner) {
                toClose.add(current);
            }
    }
                case DELETE:
 * A Translog is a per index shard component that records all non-committed index operations in a durable manner.
        this.primaryTermSupplier = primaryTermSupplier;
     * @param fromSeqNo the lower bound of the range (inclusive)
                    return Translog.class.isAssignableFrom(Class.forName(f.getClassName()));
            return id;
        sync();
        private final long seqNo;
            location,
            final int operationSize = (int) (end - Integer.BYTES - start);
                return false;
     * into one shared buffer (one {@link ReleasableBytesStreamOutput} allocation for the whole batch), the translog
            }
            }
     */
        assert readLock.isHeldByCurrentThread() || writeLock.isHeldByCurrentThread();
    }
    public static void writeOperationNoSize(BufferedChecksumStreamOutput out, Translog.Operation op) throws IOException {
            out.seek(end);
            this.translogFileGeneration = translogFileGeneration;
        public int hashCode() {
 * not use this file except in compliance with the License.
            outStream.writeInt(toWrite.size());
import org.opensearch.common.UUIDs;
     * Parses the generation out of {@code fileName} using {@code pattern}, whose first capturing group must be the
                + (routing != null ? 2 * routing.length() : 0);
            return new Source(source, routing);
                        return NO_OP;
     * This ensures that the translogUUID from this translog matches with the provided translogUUID.
     *
     */
            channelFactory,
        private final long primaryTerm;
        @Override
             */
            return new SeqNoFilterSnapshot(snapshot, fromSeqNo, toSeqNo, requiredFullRange);
                IOUtils.closeWhileHandlingException(newReaders);
        @Override
                out.seek(start);
        public boolean equals(Object o) {
     * Delete operation
    }
        return false;
        }
                throw new IllegalArgumentException(
    }
        writer.close();
            return new Location(current.generation, current.sizeInBytes() - 1, Integer.MAX_VALUE);
            }). // find all inner callers including Translog subclasses
     * Indexing operation
            }
                return true;
            if (this == o) {
                writeOperationNoSize(checksumStreamOutput, op);
            throw ex; // just bubble up.
     */
        ArrayList<Operation> operations = new ArrayList<>();
        public long primaryTerm() {
                throw e;
            }
        final LongSupplier primaryTermSupplier,
        final Translog.Operation operation;
                format = FORMAT_NO_DOC_TYPE;
     */
        public int skippedOperations() {
                minGen = Math.min(minGen, reader.getGeneration());
        }
            return Type.NO_OP;
            throw new TranslogCorruptedException(
            result = 31 * result + (routing != null ? routing.hashCode() : 0);
     * @return Returns <code>true</code> iff this call caused an actual sync operation otherwise <code>false</code>
        public static final int FORMAT_NO_PARENT = FORMAT_6_0 + 1; // since 7.0
    }
            null
        FileChannel channel = getChannelFactory().open(path, StandardOpenOption.READ);
            }
import java.io.EOFException;
import org.opensearch.common.annotation.PublicApi;
         * Returns the next operation in the snapshot or <code>null</code> if we reached the end.
            newWriter = TranslogWriter.create(
        }
        return Checkpoint.read(location.resolve(CHECKPOINT_FILE_NAME));
        final BufferedChecksumStreamInput checksumStreamInput = new BufferedChecksumStreamInput(input, source);
        this.globalCheckpointSupplier = globalCheckpointSupplier;
            } catch (NumberFormatException e) {
        }
        default int skippedOperations() {
    long getFirstOperationPosition() { // for testing
        return operation;
     * Creates a new translog snapshot containing operations from the given range.
    /** package private for testing */
    ) throws IOException {
        @Override
                    );
                case INDEX:
            return Long.compare(generation, o.generation);
            try {
                close();
            return this.id;
        final LongConsumer persistedSequenceNumberConsumer,
        final ShardId shardId,
            }
            final Translog.Operation.Type type = Translog.Operation.Type.fromId(input.readByte());
        try (ReleasableLock ignored = readLock.acquire()) {
     * @throws IOException if creating the translog failed
                // we're shutdown potentially on some tragic event, don't delete anything
     * Closes the translog if the current translog writer experienced a tragic exception.
                    }
            if (obj == null || getClass() != obj.getClass()) {
            id = in.readString();
     * Note that in case this thread closes the translog it must not already be holding a read lock on the translog as it will acquire a
        @Nullable final String translogUUID,
        @Override
    public static final int DEFAULT_HEADER_SIZE_IN_BYTES = TranslogHeader.headerSizeInBytes(UUIDs.randomBase64UUID());
            return "Delete{"
            throw new TranslogException(shardId, "failed to create new translog file", e);
     */
        public static final int FORMAT_NO_VERSION_TYPE = FORMAT_NO_PARENT + 1;
        // This BufferedChecksumStreamOutput remains unclosed on purpose,
import org.opensearch.index.mapper.Uid;
            return 31 * 31 * Long.hashCode(seqNo) + 31 * Long.hashCode(primaryTerm) + reason().hashCode();
            this.version = in.readLong();
            primaryTermSupplier,
        return new TranslogGeneration(translogUUID, currentFileGeneration());
    /**
        return checkpoint.globalCheckpoint;
        public NoOp(final long seqNo, final long primaryTerm, final String reason) {
    private static Checkpoint readCheckpoint(Path location, String expectedTranslogUUID) throws IOException {
            return current.getGeneration();
import org.opensearch.common.io.stream.ReleasableBytesStreamOutput;
        }
                in.readString();
    public static long parseIdFromFileName(String fileName, Pattern pattern) {
import org.opensearch.core.common.Strings;
    protected boolean shouldFlush() {
        this.translogUUID = translogUUID;
            ensureOpen();
            this.source = new BytesArray(source);
                in.readOptionalString(); // _parent
     * <p>
        public static final int FORMAT_6_0 = 8; // since 6.0.0
        }
            + currentFileGeneration()
    public static final String CHECKPOINT_SUFFIX = ".ckp";
 * Unless required by applicable law or agreed to in writing,
     * @return the translog's unique identifier
        }
                writeOperationNoSize(checksumStreamOutput, operation);
                        commitCheckpoint.toString(),
    }
     *
     */
                + ", version="
            }
         * @opensearch.api
        List<StackTraceElement> frames = Stream.of(Thread.currentThread().getStackTrace()).skip(3). // skip getStackTrace, current method
                Path committedTranslogFile = location.resolve(Translog.getFilename(i));
import org.opensearch.index.seqno.SequenceNumbers;
                + (routing != null ? ", routing=" + routing : "")
     *
    public abstract boolean ensureSynced(Location location) throws IOException;
        long checksum = out.getChecksum();
     * framed exactly as {@link #add(Operation)} frames it, so the on-disk bytes and returned {@link Location}s are
                    filteredOpsCount++;
        } else {
             * 1. Translog.Location's compareTo doesn't actually pay attention to size even though it's equals method does.
            }
                copyCheckpointTo(location.resolve(getCommitCheckpointFileName(current.getGeneration())));
                : "first reader generation of " + snapshots + " is not the smallest";
        }
            this.translogLocation = translogLocation;
            final BufferedChecksumStreamOutput checksumStreamOutput = new BufferedChecksumStreamOutput(out);
                verifyChecksum(in);
            if (format < FORMAT_NO_DOC_TYPE) {
                location.resolve(Translog.getCommitCheckpointFileName(minGenerationToRecoverFrom - 1))
            result = 31 * result + Long.hashCode(primaryTerm);
                return;
            if (format < FORMAT_NO_DOC_TYPE) {
    }
            delegate.close();
        } catch (final Exception ex) {
        public boolean equals(Object o) {
        }
    protected final String translogUUID;
     * @return the new snapshot
    }
        long initialGlobalCheckpoint,
            this.autoGeneratedIdTimestamp = index.getAutoGeneratedIdTimestamp();
                sliceStart = end;
    public interface Operation {
     * @param config                          the configuration of this translog
            return new Location[0];
            } else {
                throw new TranslogCorruptedException(in.getSource(), "operation size must be at least 4 but was: " + opSize);
                    break;
                "checksum verification failed - expected: 0x"
    }
        @Override
            return filteredOpsCount + delegate.skippedOperations();
        try (ReleasableLock ignored = readLock.acquire()) {
    /**
        final Checkpoint checkpoint = Checkpoint.emptyTranslogCheckpoint(0, generation, initialGlobalCheckpoint, generation);
            }
            source = in.readBytesReference();
            out.skip(Integer.BYTES);
        } catch (final Exception ex) {
        return readers;
        try {
            // view after all serialization, since the backing buffer may reallocate as it grows.
                    : Checkpoint.read(location.resolve(Translog.getCommitCheckpointFileName(i)));
            translogHeader = TranslogHeader.read(highestGenTranslogFile, channel);
            throw new IllegalStateException("trying to read doc source from delete operation");
                    ((Delete) operation).write(output);
        public final int size;
            }
            if (format < FORMAT_NO_VERSION_TYPE) {
        } catch (Exception ex) {
        public String toString() {
     */
            return reason;
    public Snapshot newSnapshot() throws IOException {
import java.util.Optional;
        private final String reason;
        }
         * Unlike {@link #totalOperations()}, this value is updated each time after {@link #next()}) is called.
                routing = in.readOptionalString();
            result = 31 * result + Long.hashCode(version);
                return true;
        final String translogUUID,
            assert format >= FORMAT_6_0 : "format was: " + format;
     * @throws IOException if an I/O exception occurred during any file operations
            + minReferencedGen
     */
     */
                && seqNo == delete.seqNo
     *
            }
    void deleteReaderFiles(TranslogReader reader) {
                            + "]"
            earliestTime = Math.min(r.getLastModifiedTime(), earliestTime);
        @Nullable final ChannelFactory factory
            return reader;
        return TRANSLOG_FILE_PREFIX + generation + CHECKPOINT_SUFFIX;
                    + ", got: 0x"
    ) throws IOException {
     * @param fileGeneration the translog generation
    private Snapshot newMultiSnapshot(TranslogSnapshot[] snapshots) throws IOException {
            assert primaryTerm >= 0;
    protected long getMinReferencedGen() throws IOException {
     * Ensures that all locations in the given stream have been synced / written to the underlying storage.
        return frames.isEmpty() || frames.stream().anyMatch(f -> f.getMethodName().equals("closeOnTragicEvent"));
                out.skip(Integer.BYTES);
    }
    public long currentFileGeneration() {
     * How to sync the translog
            result = 31 * result + Long.hashCode(seqNo);
        ArrayList<TranslogReader> foundTranslogs = new ArrayList<>();
                        return translogReader.read(location);
            Type(byte id) {
     */
                + ", primaryTerm="
            assert current.assertNoSeqAbove(belowTerm, aboveSeqNo);
            if (generation == o.generation) {
                fileGeneration,
        }
     */
        @Override
     *
                + checkpoint.generation;
    /**
        final Path highestGenTranslogFile = location.resolve(getFilename(checkpoint.generation));
    public TranslogDeletionPolicy getDeletionPolicy() {
                throw new MissingHistoryOperationsException(
     * each translog type can have it's own decider
 * Modifications Copyright OpenSearch Contributors. See
                    if (translogReader.generation == location.generation) {
     * @return Returns <code>true</code> iff this call caused an actual sync operation otherwise <code>false</code>
         */
        }
            final long start = out.position();
     *
            result = 31 * result + (routing != null ? routing.hashCode() : 0);
            try {
        @Override
    public TranslogGeneration getMinGenerationForSeqNo(final long seqNo) {
                }
            }
    public Location[] add(final List<Operation> operations) throws IOException {
 * association between the lucene index an the transaction log file. This UUID is used to prevent accidental recovery from a transaction
                throw new IllegalStateException(
            CREATE((byte) 1),
    }
        @Override
            + "empty translog size ["
        public Source getSource() {
            operations.add(readOperation(checksumStreamInput));
                    newReaders.add(newReader);
        // We need to open at least one translog header to validate the translogUUID.
     */
     * The a {@linkplain Location} that will sort after the {@linkplain Location} returned by the last write but before any locations which
        return TRANSLOG_FILE_PREFIX + generation + TRANSLOG_FILE_SUFFIX;
        }
                    return new NoOp(input);
        ChannelFactory channelFactory,
        }
     * {@code null}. If the generation is {@code null} this method is destructive and will delete all files in the translog path given. If
     *
            throw new TranslogCorruptedException(location.toString(), ex);
        }
        final long primaryTerm = translogHeader.getPrimaryTerm();
        /**
    }
                || autoGeneratedIdTimestamp != index.autoGeneratedIdTimestamp
        return checkpoint;
                && primaryTerm == delete.primaryTerm
        public static final int FORMAT_NO_DOC_TYPE = FORMAT_NO_VERSION_TYPE + 1;
            : "callers of readersAboveMinSeqNo must hold a lock: readLock ["
    TranslogWriter createWriter(
    /**
     * A filtered snapshot consisting of only operations whose sequence numbers are in the given range
        }
        final LongConsumer persistedSequenceNumberConsumer,
     * between {@code fromSeqNo} (inclusive) and {@code toSeqNo} (inclusive). This filtered snapshot
        public Delete(String id, long seqNo, long primaryTerm, long version) {
        int numOps = input.readInt();
    /**
         */
            return findEarliestLastModifiedAge(System.currentTimeMillis(), readers, current);
    public long getMinFileGeneration() {
        public static final int FORMAT_NO_DOC_TYPE = FORMAT_NO_VERSION_TYPE + 1;
            return Stream.concat(readers.stream(), Stream.of(current))
        ReadWriteLock rwl = new ReentrantReadWriteLock();
    /**
        }
        }
 */
                    return false;
        static void writeOperation(final StreamOutput output, final Operation operation) throws IOException {
     *                                needed to solve and initialization problem while constructing an empty translog.
        public Type opType() {
    public TranslogStats stats() {
    /**
    }
    }
        public int totalOperations() {
     *    fsynced far enough
            } else {
                + Translog.parseIdFromFileName(path)
        final ChannelFactory channelFactory = FileChannel::open;
        return createEmptyTranslog(location, initialGlobalCheckpoint, shardId, channelFactory, primaryTerm);
            return seqNo;
        }
        }
     * Each is associated with a type.
        final ReleasableBytesStreamOutput out = new ReleasableBytesStreamOutput(bigArrays);
                + ", seqNo="
                final int operationSize = (int) (end - Integer.BYTES - start);
    public static long parseIdFromFileName(Path translogFile) {
    // STRICT_TLOG_OR_CKP_PATTERN matches either a translog or a checkpoint file of a specific generation.
                    assert false : "Operation term is newer than the current term; "
            }
            // we assume that the current translog generation doesn't have trimmable ops. Verify that.
            }
        public BytesReference source() {
    /**
            return null;
        final long primaryTerm
        return parseIdFromFileName(fileName, PARSE_STRICT_ID_PATTERN);
    protected final List<TranslogReader> readers = new ArrayList<>();
            return current.syncNeeded();
     */
     * @opensearch.api
        @PublicApi(since = "1.0.0")
        try (ReleasableLock ignored = readLock.acquire()) {
     * @opensearch.api
                return;
                out.writeInt(operationSize);
            if (o == null || getClass() != o.getClass()) {
                    logger.warn(() -> new ParameterizedMessage("failed to delete temp file {}", tempFile), ex);
                current.sync();
 * The OpenSearch Contributors require contributions made to
/*
     * @return the locations of the operations in the translog, parallel to {@code operations}
            final int[] sliceLens = new int[count];
        return closed.get() == false;
        } catch (IOException e) {
        if (count == 1) {
        @Override
        return Translog.createEmptyTranslog(
     */
                + seqNo
                out.writeInt(operationSize);
                                                                                                                          // primary_term,
        public Delete(Engine.Delete delete, Engine.DeleteResult deleteResult) {
        /**
        }
        /**
                            + "]";
        }
            ensureOpen();
     */
         * The number of operations have been skipped (overridden or trimmed) in the snapshot so far.
     * Drains ongoing syncs to the underlying store. It returns a releasable which can be closed to resume the syncs back.
        if (current.totalOperations() == 0 && primaryTermSupplier.getAsLong() == current.getPrimaryTerm()) {
            }
    Min Seq number required in translog to restore the complete data .
     *
                        + " ] , current is [ "
     * Trims unreferenced translog generations by asking {@link TranslogDeletionPolicy} for the minimum
        }
                out.writeBytesRef(Uid.encodeId(id));
     * Acquires a lock on the translog files, preventing them from being trimmed
     * A generic interface representing an operation performed on the transaction log.
        return this.channelFactory;
    /**
 * GitHub history for details.
        private Delete(final StreamInput in) throws IOException {
                Checkpoint checkpointFromDisk = Checkpoint.read(commitCheckpoint);
        for (int i = 0; i < numOps; i++) {
                + readLock.isHeldByCurrentThread()
                .sum();
     */
    /**
     * @return a writer for the new translog
     * @return the location of the operation in the translog
    protected void setMinSeqNoToKeep(long seqNo) {}
        final Path tempFile = Files.createTempFile(location, TRANSLOG_FILE_PREFIX, CHECKPOINT_SUFFIX);
    }
            writeOperationNoSize(new BufferedChecksumStreamOutput(out), operation);
    }
                 */
    };
            return new TranslogGeneration(translogUUID, minGenerationForSeqNo(seqNo, current, readers));
            this.version = indexResult.getVersion();
            shardId,
            ensureOpen();
    }
            return result;
        } catch (TranslogCorruptedException ex) {
        return Stream.concat(readers.stream(), Stream.of(current)).filter(reader -> minSeqNo <= reader.getCheckpoint().maxEffectiveSeqNo());
     * existing readers, this value is not necessary to be the max seq_no of all operations have been stored in this translog.
                out.reset();
                final long start = out.position();
                + '}';
            try (ReleasableLock lock = writeLock.acquire()) {
 */
            result = 31 * result + size;
    }
                || primaryTerm != index.primaryTerm
                    + ", existing term ["
                return current.read(location);
    }
        private final long version;
        public long estimateSize() {
     * @return the global checkpoint
    /**
            } catch (final Exception e) {
     * @param initialGlobalCheckpoint the global checkpoint to be written in the first checkpoint.
            shardId,
            out.writeLong(primaryTerm);
     */
    }
    // the list of translog readers is guaranteed to be in order of translog generation
import org.opensearch.core.common.io.stream.StreamInput;
            ensureOpen();
        if (count == 0) {
                return false;
     * can be returned by the next write.
        }
        if (matcher.matches()) {
        this.channelFactory = channelFactory != null ? channelFactory : FileChannel::open;
                try {
    }
                // we're shutdown potentially on some tragic event, don't delete anything
            @Deprecated
    public static long readMinTranslogGeneration(final Path location, final String expectedTranslogUUID) throws IOException {
            this(id, seqNo, primaryTerm, Versions.MATCH_ANY, null);
        if (snapshots.length == 0) {
            throw new TranslogException(shardId, "Failed to write batch of [" + count + "] operations", ex);
        try (ReleasableLock ignored = writeLock.acquire()) {
import java.util.OptionalLong;
        }
     *
            return;
                 * suppressed because it will contain the provided exception as its cause. See also
import java.util.List;
import java.io.Closeable;
    protected final ReleasableLock readLock;
                onClose.close();
            this.primaryTerm = index.primaryTerm();
                translogUUID,
            globalCheckpointSupplier,
                        + "Trim requested for term [ "
            Path commitCheckpoint = location.resolve(Translog.getCommitCheckpointFileName(checkpoint.generation));
     * Returns the minimum translog generation retained by the translog at the given location.
                    TranslogReader translogReader = readers.get(i);
        }
        }
                deleteReaderFiles(reader);
    /**
                    + "] is not the current writer's gen ["
    static final Pattern PARSE_STRICT_ID_PATTERN = Pattern.compile("^" + TRANSLOG_FILE_PREFIX + "(\\d+)(\\.tlog)$");
        private final Snapshot delegate;
            for (int i = 0; i < count; i++) {
     * Checks whether or not the shard should be flushed based on translog files.
        final String uuid = Strings.hasLength(translogUUID) ? translogUUID : UUIDs.randomBase64UUID();
            DELETE((byte) 3),
     */
        return minGen;
            return Stream.concat(readers.stream(), Stream.of(current))
            assert seqNo > SequenceNumbers.NO_OPS_PERFORMED;
            return "[generation: " + generation + ", location: " + translogLocation + ", size: " + size + "]";
     *
     *  - we might need something like a deletion policy to hold on to more than one translog eventually (I think sequence IDs needs this)
            return primaryTerm;
    }
        }
        public void close() throws IOException {
                translogOperationHelper
    abstract Releasable drainSync();
        @Override
                return false;
 *
import java.util.concurrent.atomic.AtomicBoolean;
            this.toSeqNo = toSeqNo;
     * @param deletionPolicy                  an instance of {@link TranslogDeletionPolicy} that controls when a translog file can be safely
            }
    }
     * @param shardId                 the {@link ShardId}
        } catch (EOFException e) {
     * Reads and returns the operation from the given location if the generation it references is still available. Otherwise
        }
    }
                indexSettings.isAssignedOnRemoteNode(),
                out.writeOptionalString(routing);
                    : "the first translog isn't the one with the minimum generation:" + readers;
                || seqNo != index.seqNo
import org.opensearch.core.index.shard.ShardId;
        final Optional<Location> max = locations.max(Location::compareTo);
     * Returns all translog locations as absolute paths.
    public Operation readOperation(Location location) throws IOException {
                    case 3:
    TranslogWriter getCurrent() {
        private final String routing;
         */
        } finally {
     * Returns the minimum file generation referenced by the translog
import org.opensearch.core.common.io.stream.StreamOutput;
            return seqNo;
            + minReferencedGen
        private void write(final StreamOutput out) throws IOException {
            fileGeneration,
     * @throws TranslogCorruptedException if the translog is corrupted or mismatched with the given uuid
                for (TranslogReader reader : readers) {
        @Override
            assert fromSeqNo <= toSeqNo : "from_seq_no[" + fromSeqNo + "] > to_seq_no[" + toSeqNo + "]";
            initialGlobalCheckpoint,
         * The type of operation
    public Location add(final Operation operation) throws IOException {
        }
            if (translogLocation != location.translogLocation) {
        }
     *
import java.nio.file.Files;
        }
        @Override
        public long seqNo() {
            return readersAboveMinSeqNo(minSeqNo).mapToInt(BaseTranslogReader::totalOperations).sum();
         */
            deletionPolicy,
        @Override
            );
     * @opensearch.internal
    public static final String TRANSLOG_FILE_PREFIX = "translog-";
     */
     *
            return primaryTerm;
        }
    public void trimUnreferencedReaders() throws IOException {
        }
     * there is no generation that could any such sequence number.
                default:
                case INDEX:
            }
     * @return {@code true} if the shard should be flushed
                default:
            this.source = index.source();
        for (final TranslogReader reader : readers) {
                    + Long.toHexString(expectedChecksum)
        // locations implicitly
                final long end = out.position();
        public boolean equals(Object o) {
                .mapToLong(BaseTranslogReader::sizeInBytes)
        public static final int FORMAT_NO_PARENT = FORMAT_6_0 + 1; // since 7.0
        public long getAutoGeneratedIdTimestamp() {
                        + current.getPrimaryTerm()
            );
public abstract class Translog extends AbstractIndexShardComponent implements IndexShardComponent, Closeable {
    }
            // translog was found.
         * Request durability - translogs are synced for each high level request (bulk, index, delete)
            // byte-identical to a single add (size int + body + checksum). Slices are taken from the FINAL bytes()
    }
    }
            this.version = in.readLong();
        public int hashCode() {
        }
     * Adds an operation to the transaction log.
    protected final LongSupplier primaryTermSupplier;
        final ReleasableBytesStreamOutput out = new ReleasableBytesStreamOutput(BigArrays.NON_RECYCLING_INSTANCE);
    /**
    /**
            TranslogOperationHelper.DEFAULT,
    public static long readGlobalCheckpoint(final Path location, final String expectedTranslogUUID) throws IOException {
            // Serialize every op into the single shared buffer; record each op's slice bounds so framing is
     */
        private final long toSeqNo;   // inclusive
        }
     */
                + primaryTerm
            if (format < FORMAT_NO_VERSION_TYPE) {
        final ChannelFactory channelFactory = FileChannel::open;
            logger.debug("open uncommitted translog checkpoint {}", checkpoint);
            this.id = index.id();
                            + minGenerationToRecoverFrom
            final OptionalLong maxSeqNo = Stream.concat(readers.stream(), Stream.of(current))
    public int estimateTotalOperationsFromMinSeq(long minSeqNo) {
                    + committedTranslogFile
    ) throws IOException {
            return version == delete.version
        public static final int FORMAT_ROUTING = FORMAT_NO_DOC_TYPE + 1;
            this.id = id;
     * translog file referenced by this generation. The translog creation will fail if this generation can't be opened.
            EMPTY_TRANSLOG_BUFFER_SIZE,
     * Constructor that does not accept channelFactory parameter but accepts translogOperationHelper
    }
     */
     */
     * This ensures that the translogUUID from this translog matches with the provided translogUUID.
                logger.debug("translog closed");
    static Translog.Operation readOperation(BufferedChecksumStreamInput in) throws IOException {
    }
            try (ReleasableLock ignored = readLock.acquire()) {
        private final long seqNo;
     * threshold size.
        private final long autoGeneratedIdTimestamp;
     *                                        deleted
     * Effectively it moves max visible seq# {@link Checkpoint#trimmedAboveSeqNo} therefore {@link TranslogSnapshot} skips those operations.
                ex.addSuppressed(inner);
                return true;
                // to prevent this unfortunately.
        final String translogUUID,
        REQUEST
        public long seqNo() {
                    throw new AssertionError("no case for [" + operation.opType() + "]");
     * If this {@code Translog} was closed as a side-effect of a tragic exception,
     * Ensures that the given location has be synced / written to the underlying storage.
                trimUnreferencedReaders();
    public Translog(
            },
    }
        /**
     * Returns the current generation of this translog. This corresponds to the latest uncommitted translog generation
     * @param seqNo the sequence number
        final ShardId shardId,
    }
        Source getSource();
        }
        try {
        } finally {
    @PublicApi(since = "1.0.0")
    public boolean shouldRollGeneration() {
            success = true;
                final Operation operation = operations.get(i);
                    + minReferencedGen
    public static String createEmptyTranslog(final Path location, final ShardId shardId, Checkpoint checkpoint) throws IOException {
        private final long version;
        public long estimateSize() {
            }
            }
        try {
                in.readBytesRef(); // uid
                long end = out.position();
    public static class Source {
        }
            if (location.generation < getMinFileGeneration()) {
                || source.equals(index.source) == false) {
        private int filteredOpsCount;
            return seqNo;
                assert docType.equals(IdFieldMapper.NAME) : docType + " != " + IdFieldMapper.NAME;
            result = 31 * result + source.hashCode();
                    final Operation operation = operations.get(i);
        final String fileName = translogFile.getFileName().toString();
            return this.version;
            + "] but the lowest gen available is ["
        }
        try (ReleasableLock lock = readLock.acquire()) {
     */
        public static final int SERIALIZATION_FORMAT = FORMAT_NO_DOC_TYPE;
        throw new IllegalArgumentException("can't parse id from file: " + fileName);
        long minReferencedGen = Math.min(
            try {
            out.writeLong(primaryTerm);
 * the Apache License, Version 2.0 (the "License"); you may
    static String createEmptyTranslog(
        try (ReleasableLock ignored = writeLock.acquire()) {
                // if they are still in RAM and we are reading onto that position
            }
        /**
    /**
     */
        public String routing() {
        try (ReleasableLock lock = readLock.acquire()) {
                foundTranslogs.add(reader);
                assert ex != inner.getCause();
     * TODO
            final Snapshot snapshot = newMultiSnapshot(snapshots);
            } catch (IOException e) {
            if (format < FORMAT_NO_VERSION_TYPE) {
     * read lock is acquired once, and the underlying {@link TranslogWriter} monitor is entered once. Each operation is
    /**
                .mapToLong(reader -> reader.getCheckpoint().maxSeqNo)
                        ? reader.closeIntoTrimmedReader(aboveSeqNo, getChannelFactory())
            );
                return this.id;
        final ChannelFactory channelFactory = factory != null ? factory : FileChannel::open;
            return (id.length() * 2) + (3 * Long.BYTES) // seq_no, primary_term, and version
    /**
                out.skip(Integer.BYTES);
     */
                    );
     * These paths don't contain actual translog files they are
     */
            Delete delete = (Delete) o;
    protected final TranslogConfig config;
        TranslogDeletionPolicy deletionPolicy,
            INDEX((byte) 2),
    public long sizeInBytes() {
     * Adds a batch of operations to the transaction log in a single critical section. The operations are serialized
        /**
     * @opensearch.internal
        this(
            return 2 * reason.length() + 2 * Long.BYTES;
                final TranslogReader reader = openReader(committedTranslogFile, readerCheckpoint);
    }
            }
            this.reason = reason;
    public static long parseIdFromFileName(String fileName) {
    @PublicApi(since = "1.0.0")
     * generation referenced from already committed data. This means all operations that have not yet been committed should be in the
            final BytesReference all = out.bytes();
                    + primaryTermSupplier.getAsLong()
            this.readers.clear();
        }
            seqNo -> {
            final long end = out.position();
                for (int i = readers.size() - 1; i >= 0; i--) {
        public Index(String id, long seqNo, long primaryTerm, byte[] source) {
                sliceLens[i] = (int) (end - sliceStart);
            this.fromSeqNo = fromSeqNo;
    protected final AtomicBoolean closed = new AtomicBoolean();
            }
        long initialMinTranslogGen,
                primaryTermSupplier.getAsLong(),
     * @param location the location of the translog
                .uncommittedSizeInBytes(sizeInBytesByMinGen(uncommittedGen))
        }
        public Type opType() {
        public final String translogUUID;
 * Additionally, the engine also records a {@link #TRANSLOG_UUID_KEY} with each commit to ensure a strong
 * under the License.
    }
            }
            this.size = size;
                // but crashed before we could delete the file.
     * Sync's the translog.
         * Reads the type and the operation from the given stream. The operation must be written with
            if (generation != location.generation) {
            this.primaryTerm = primaryTerm;
        public void close() {}
         * Returns the routing value for this delete operation, or {@code null} if no custom routing was specified.
    public long getMaxSeqNo() {
            out.writeString(id);
            boolean readForward = indexSettings().isTranslogReadForward();
            this.generation = generation;
            }
     * Location in the translot
    }
                final String docType = in.readString();
    }
            } else {
            if (getMinReferencedGen() == getMinFileGeneration()) {
            assert reason != null;
import java.nio.file.Path;
    }
    public static final Translog.Snapshot EMPTY_TRANSLOG_SNAPSHOT = new Translog.Snapshot() {
    protected final BigArrays bigArrays;
        this.location = config.getTranslogPath();
                out.bytes().writeTo(outStream);
                persistedSequenceNumberConsumer,
                // can't assert that this is _doc because pre 2.0 indexes can have any name for a type
        final Path checkpointFile = location.resolve(CHECKPOINT_FILE_NAME);
     * Creates a new empty translog within the specified {@code location} that contains the given {@code initialGlobalCheckpoint},
                + "], writeLock ["
            int result = Long.hashCode(generation);
            return size == location.size;
    @PublicApi(since = "1.0.0")
        final TranslogWriter newWriter;
                        committedTranslogFile.toString(),
    static long minGenerationForSeqNo(long seqNo, TranslogWriter writer, List<TranslogReader> readers) {
                out.writeString(MapperService.SINGLE_MAPPING_NAME);
            closeOnTragicEvent(ex);
        final Matcher matcher = pattern.matcher(fileName);
            persistedSequenceNumberConsumer
                    break;
        final String translogUUID = translogHeader.getTranslogUUID();
        }
 * <p>
        return sizeInBytesByMinGen(-1);
                        + operation
    /**
    }
import java.io.IOException;
     * @param operation the operation to add
        /** utility for testing */
            return Type.INDEX;
    /**
                int operationSize = (int) (out.position() - Integer.BYTES - start);
            FileChannel::open
    }
            () -> {
        this(
    /**
        private int opsCount;
     * @param initialMinTranslogGen   the minimum translog generation to be written in the first checkpoint. This is
     * creates a new writer
                out.seek(end);
            return delegate.totalOperations();
            out.writeLong(autoGeneratedIdTimestamp);
        this.config = config;
            this(delete.id(), deleteResult.getSeqNo(), delete.primaryTerm(), deleteResult.getVersion(), delete.routing());
import org.opensearch.common.Nullable;
                            + " but got "
    ) throws IOException {
            return maxSeqNo.getAsLong();
                    + reader.getPrimaryTerm()
        }
                ensureOpen();
    List<TranslogReader> getReaders() {
            // that way if we hit a disk-full here we are still in an consistent state.
 * Each Translog has only one translog file open for writes at any time referenced by a translog generation ID. This ID is written to a
        public int compareTo(Location o) {
            if (success == false) {
     *  - we need to page align the last write before we sync, we can take advantage of ensureSynced for this since we might have already
    }
            }
            output.writeByte(operation.opType().id());
                );
            if (success == false) {
        assert writer.sizeInBytes() == DEFAULT_HEADER_SIZE_IN_BYTES : "Mismatch translog header size; "
        }
     *  - use a simple BufferedOutputStream to write stuff and fold BufferedTranslogWriter into it's super class... the tricky bit is we
        Checkpoint.write(channelFactory, checkpointFile, checkpoint, StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW);
                case CREATE:
    public Snapshot newSnapshot(long fromSeqNo, long toSeqNo) throws IOException {
            this.seqNo = seqNo;
                        + " ]"
                                                                                                                          // seq_no,
                    throw new AssertionError("no case for [" + type + "]");
     */
     * identical to performing the adds individually.
import java.util.Collections;
            in.resetDigest(); // size is not part of the checksum!
     * @param initialGlobalCheckpoint the global checkpoint to initialize the translog with
        public Source getSource() {
     */
         * {@link Operation#writeOperation(StreamOutput, Operation)}
         */
            final int format = out.getVersion().onOrAfter(Version.V_2_0_0) ? SERIALIZATION_FORMAT : FORMAT_NO_VERSION_TYPE;
        try (ReleasableLock lock = readLock.acquire()) {
        public String toString() {
                // sync at once to make sure that there's at most one unreferenced generation.
    public TranslogGeneration getGeneration() {
                + ", version="
                    + "] translog path [ "
 * In OpenSearch there is one Translog instance per {@link org.opensearch.index.engine.InternalEngine}.
        private boolean requiredFullRange;
     * Returns the number of operations in the translog files at least the given generation
        }
            out.writeLong(seqNo);
            } else {
    /**
                final long start = out.position();
            if (format < FORMAT_NO_VERSION_TYPE) {
            }
        if (closed.compareAndSet(false, true)) {
            return primaryTerm;
        private final long fromSeqNo; // inclusive
        } finally {
import org.opensearch.common.lease.Releasable;
    }
                .toArray(TranslogSnapshot[]::new);
                return Long.compare(translogLocation, o.translogLocation);
package org.opensearch.index.translog;
                }
                config.getBufferSize(),
     * use the {@code delegate} after passing it to this filtered snapshot.
 * its fsynced offset in bytes, and other important statistics.
        return parseIdFromFileName(fileName);
     * @opensearch.api
                tragedy.setTragicException(e);
    }
     * @param operations the operations to add, in order
import java.util.concurrent.locks.ReadWriteLock;
            return autoGeneratedIdTimestamp;
        public int hashCode() {
        try (ReleasableLock ignored = readLock.acquire()) {
    }
        }
        }
        long estimateSize();
                } catch (Exception ignored) {
 * @opensearch.api
            generation,
        @Override
        );
        TranslogDeletionPolicy deletionPolicy,
        return current.getFirstOperationOffset();
                    break;
    /**
                    case 1:
     */
     *
                } catch (IOException ex) {
import org.opensearch.core.common.bytes.BytesArray;
        return translogUUID;
                return false;
                    break;
            reason = in.readString();
            try {
    protected final ReleasableLock writeLock;
        @Override
            if (format < FORMAT_NO_PARENT) {
                shardId,
 *
    }
    public static final String TRANSLOG_FILE_SUFFIX = ".tlog";
            return null;
        /**
            routing = in.readOptionalString();
    }
    public void trimOperations(long belowTerm, long aboveSeqNo) throws IOException {
            if (this == o) {
            }
     * Otherwise (no tragic exception has occurred) it returns null.
        assert minReferencedGen <= currentFileGeneration() : "deletion policy requires a minReferenceGen of ["
    static long findEarliestLastModifiedAge(long currentTime, Iterable<TranslogReader> readers, TranslogWriter writer) throws IOException {
            new TragicExceptionHolder(),
        return tragedy.get();
            }
                out.seek(end);
     * Creates a new Translog instance. This method will create a new transaction log unless the given {@link TranslogGeneration} is
    /**
        final ReleasableBytesStreamOutput out = new ReleasableBytesStreamOutput(bigArrays);
                throw e;
            BigArrays.NON_RECYCLING_INSTANCE,
            // if we crash just at the wrong moment, it may be that we leave one unreferenced file behind so we delete it if there
                }
    public boolean syncNeeded() {
                    // the de-serialization logic in Index was identical to that of Create when create was deprecated
                            + operation
            return result;
            limit(10). // limit depth of analysis to 10 frames, it should be enough to catch closing with, e.g. IOUtils
            primaryTerm = in.readLong();
        } finally {
    }
    // public for testing
    public Translog(
                readers.add(reader);
            }
        // in order to reduce the time the lock is held since it's blocking all threads
    /**
    }
                    case 2:
                return current.add(bytes, operation.seqNo());
     * @return the minimum generation for the sequence number
            this(id, seqNo, primaryTerm, version, null);
        }
                        + current.getPrimaryTerm()
         *
            minGenerationForSeqNo(deletionPolicy.getLocalCheckpointOfSafeCommit() + 1, current, readers)
    /**
            if (requiredFullRange && (toSeqNo - fromSeqNo + 1) != opsCount) {
    /** Reads and returns the current checkpoint */
            TranslogOperationHelper.DEFAULT
        final TranslogConfig config,
                } else {
        assert aboveSeqNo >= SequenceNumbers.NO_OPS_PERFORMED : "aboveSeqNo has to a valid sequence number";
        public final long translogFileGeneration;
        try {
        return minReferencedGen;
        long expectedChecksum = in.getChecksum();
        if (readChecksum != expectedChecksum) {
            } finally {
            }
        public Source(BytesReference source, String routing) {
                            + " checkpoint: "
                current.sync();
