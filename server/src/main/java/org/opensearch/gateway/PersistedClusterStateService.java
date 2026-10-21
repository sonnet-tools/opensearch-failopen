        String committedClusterUuid = null;
        void flush() throws IOException {
                        "writing cluster state took [{}ms] which is above the warn threshold of [{}]; "
        ClusterSettings clusterSettings,
        final IndexSearcher searcher = new IndexSearcher(reader);
        params.put(Metadata.CONTEXT_MODE_PARAM, Metadata.CONTEXT_MODE_GATEWAY);
        }
 * | NODE_VERSION_KEY          | "node_version"          | The (ID of the) version of the node that wrote this metadata                  |
    /**
                    + "] in term ["
            return this == NO_ON_DISK_STATE;
        TimeValue.ZERO,
            this.metadataIndexWriters = metadataIndexWriters;
                int numIndicesUnchanged = 0;
                        );
            return makeDocument(GLOBAL_TYPE_NAME, metadata, documentBuffer);
            final long numIndicesUpdated;
                // we require that we have the whole page to ourselves
        // next one.
        private WriterStats addMetadata(Metadata metadata) throws IOException {
            if (closed.get()) {
            } finally {
        void commit(long currentTerm, long lastAcceptedVersion) throws IOException {
    private final NamedXContentRegistry namedXContentRegistry;
                document.add(new StoredField(DATA_FIELD_NAME, streamOutput.toBytesRef()));
                        XContentType.SMILE,
        this.nodeId = nodeId;
                ) {
                buffer = firstPage.bytes;
                documentBufferUsed = documentBuffer.getMaxUsed();
        }
import org.opensearch.common.settings.Setting;
import java.util.Set;
                }
                        logger.trace("growing document buffer from [{}] to [{}]", buffer.length, maxUsed);
        this.slowWriteLoggingThreshold = slowWriteLoggingThreshold;
        this(
import org.opensearch.common.bytes.RecyclingBytesStreamOutput;
    public PersistedClusterStateService(
            final Path indexPath = dataPath.resolve(METADATA_DIRECTORY_NAME);
        public void close() throws IOException {
                    metadataIndexWriter.updateGlobalMetadata(globalMetadataDocument);
                        logger.trace("processing doc {}", docIdSetIterator.docID());
    /**
import org.apache.logging.log4j.Logger;
                if (updateGlobalMeta) {
                commit(currentTerm, clusterState.version());
    private volatile TimeValue slowWriteLoggingThreshold;
            }
                    logger.warn("failed on closing cluster state writer", e);
        }
                                + "] in ["
                                    + committedClusterUuid
        }
                    final Long previousValue = indexMetadataVersionByUUID.putIfAbsent(
        public boolean empty() {
                closeables.add(indexWriter);
            }
import org.opensearch.common.settings.ClusterSettings;
            ensureOpen();
    /**
/*
                    close();
     * Writer for cluster state service
            if (success == false) {
            try {
                        stats.numIndicesUpdated,
import java.util.function.LongSupplier;
    public static class OnDiskState {
                    logger.warn("failed on closing cluster state writer", e2);
            commitData.put(NODE_ID_KEY, nodeId);
                        finalSlowWriteLoggingThreshold,
        private final AtomicBoolean closed = new AtomicBoolean();
                        finalSlowWriteLoggingThreshold,
        searcher.setQueryCache(null);
            final IndexMetadata indexMetadata = IndexMetadata.fromXContent(
                public BytesRef toBytesRef() {
                assert firstPage.bytes.length == PageCacheRecycler.PAGE_SIZE_IN_BYTES : firstPage.bytes.length;
    /**
import org.opensearch.core.common.util.ByteArray;
        /**
        indexWriterConfig.setMergeScheduler(new SerialMergeScheduler());
                // The commit() call has similar semantics to a fsync(): although it's atomic, if it fails then we've no idea whether the
import org.apache.logging.log4j.LogManager;
                }
import java.util.HashSet;
                        stats.numIndicesUnchanged
 * specific language governing permissions and limitations
            try (DocumentBuffer documentBuffer = allocateBuffer()) {
                for (MetadataIndexWriter metadataIndexWriter : metadataIndexWriters) {
        NamedXContentRegistry namedXContentRegistry,
import org.apache.lucene.store.AlreadyClosedException;
                    XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(
import org.opensearch.common.CheckedConsumer;
        assert userData.size() == COMMIT_DATA_SIZE : userData;
                        buffer = bytesRef.bytes;
        /**
import org.apache.lucene.index.StoredFields;
            } finally {
        }
        final Query query = new TermQuery(new Term(TYPE_FIELD_NAME, type));
/*
import java.io.Closeable;
    private static final String LAST_ACCEPTED_VERSION_KEY = "last_accepted_version";
            bigArrays,
            }
            this.slowWriteLoggingThresholdSupplier = slowWriteLoggingThresholdSupplier;
            this.logger.trace("clearing existing metadata");
        consumeFromType(searcher, GLOBAL_TYPE_NAME, bytes -> {
                    metadataIndexWriter.prepareCommit(nodeId, currentTerm, lastAcceptedVersion);
                documentBufferUsed = documentBuffer.getMaxUsed();
     */
            return maxUsed;
                XContentType.SMILE.xContent()
 * this work for additional information regarding copyright
        }
        public void close() {
                        "writing cluster state took [{}ms]; " + "wrote full state with [{}] indices",
                        Streams.flushOnCloseStream(streamOutput)
 * Modifications Copyright OpenSearch Contributors. See
                int numIndicesUpdated = 0;
        for (LeafReaderContext leafReaderContext : indexSearcher.getIndexReader().leaves()) {
                try (DirectoryReader reader = DirectoryReader.open(new NIOFSDirectory(dataPath.resolve(METADATA_DIRECTORY_NAME)))) {
        }
                            "unexpected node ID in metadata, found ["
                        final Map<String, String> commitData = new HashMap<>(userData);
import org.apache.lucene.search.DocIdSetIterator;
                    final Long previousVersion = indexMetadataVersionByUUID.get(indexMetadata.getIndexUUID());
            } catch (IOException e) {
            logger.trace("found index metadata for {}", indexMetadata.getIndex());
            nodeEnvironment.nodeId(),
        Path[] dataPaths,
                metadataIndexWriters.add(new MetadataIndexWriter(directory, indexWriter));
        indexWriterConfig.setCommitOnClose(false);
import java.util.function.IntPredicate;
        Version version = null;
    Directory createDirectory(Path path) throws IOException {
            } catch (Exception e) {
    private static IndexWriter createIndexWriter(Directory directory, boolean openExisting) throws IOException {
    }
        private final Path dataPath;
        }
            dataPath,
                    firstPage = iterator.next();
 * compatible open source license.
                .anyMatch(iw -> iw.getTragicException() != null || iw.isOpen() == false)) {
import org.opensearch.env.NodeEnvironment;
 * <p>
        boolean success = false;
                    }
            this.directory = directory;
        }
                for (final IndexMetadata indexMetadata : previouslyWrittenMetadata.indices().values()) {
     * Remove all persisted cluster states from the given data paths, for use in tests. Should only be called when there is no open
        OnDiskState bestOnDiskState = OnDiskState.NO_ON_DISK_STATE;
                for (MetadataIndexWriter metadataIndexWriter : metadataIndexWriters) {
import org.opensearch.common.util.PageCacheRecycler;
                            committedClusterUuidPath = dataPath;
        }
        this.namedXContentRegistry = namedXContentRegistry;
                                    + "] in ["
                if (durationMillis >= finalSlowWriteLoggingThreshold.getMillis()) {
        // only commit when specifically instructed, we must not write any intermediate states
            } else {
                        numIndicesUpdated++;
                                    + "] and ["
    }
                                "mismatched cluster UUIDs in metadata, found ["
            this.logger.trace("updating metadata for [{}]", index);
                throw new AlreadyClosedException("cluster state writer is closed already");
 *
                    xContentBuilder.endObject();
                } catch (IndexNotFoundException e) {
        return nodeId;
     */
            }
    private void setSlowWriteLoggingThreshold(TimeValue slowWriteLoggingThreshold) {
            final Path indexPath = dataPath.resolve(METADATA_DIRECTORY_NAME);
                    + "] but there is a stale state in ["
        LongSupplier relativeTimeMillisSupplier
            assert previouslyWrittenMetadata.coordinationMetadata().term() == metadata.coordinationMetadata().term();
                        stats.globalMetaUpdated,
            try (DocumentBuffer documentBuffer = allocateBuffer()) {
        }
import org.opensearch.core.xcontent.NamedXContentRegistry;
        assert userData.get(CURRENT_TERM_KEY) != null;
            indexWriter.updateDocument(new Term(TYPE_FIELD_NAME, GLOBAL_TYPE_NAME), globalMetadataDocument);
                    );
        // most of the data goes into stored fields which are not buffered, so we only really need a tiny buffer
        }
 * |        Key symbol         |       Key literal       |                                     Value                                     |
            ensureOpen();
                for (String removedIndexUUID : indexMetadataVersionByUUID.keySet()) {
                                    && onDiskState.currentTerm > bestOnDiskState.currentTerm))) {
         * Update the persisted metadata to match the given cluster state by removing any stale or unnecessary documents and adding any
                        bestOnDiskState = onDiskState;
        static class WriterStats {
        }
            return addMetadata(metadata);
                }
    public OnDiskState loadBestOnDiskState() throws IOException {
        // start empty since we re-write the whole cluster state to ensure it is all using the same format version
import java.nio.file.Files;
    }
         */
                for (final IndexMetadata indexMetadata : metadata.indices().values()) {
        FORMAT_PARAMS = new ToXContent.MapParams(params);
        if (nodeId == null) {
                    for (MetadataIndexWriter metadataIndexWriter : metadataIndexWriters) {
            try {
                        "writing cluster state took [{}ms] which is above the warn threshold of [{}]; "
            return closed.get() == false;
                    metadataIndexWriter.flush();
                        stats.numIndicesUpdated
                                    + "]"
        public void writeFullStateAndCommit(long currentTerm, ClusterState clusterState) throws IOException {
        RecyclingBytesStreamOutput streamOutput() {
            }
        ClusterSettings clusterSettings,
        });
        MetadataIndexWriter(Directory directory, IndexWriter indexWriter) {
        }
    );
    public static final Setting<TimeValue> SLOW_WRITE_LOGGING_THRESHOLD = Setting.timeSetting(
            LongSupplier relativeTimeMillisSupplier,
import org.opensearch.common.unit.TimeValue;
            indexWriter.prepareCommit();
            this.relativeTimeMillisSupplier = relativeTimeMillisSupplier;
    public String getNodeId() {
                final ByteArray byteArray = bigArrays.newByteArray(PageCacheRecycler.PAGE_SIZE_IN_BYTES);
 * You may obtain a copy of the License at
 *
        for (final Path dataPath : dataPaths) {
                }
                try {
         * Updates and commits the given cluster state update
        BigArrays bigArrays,
 * this file be licensed under the Apache-2.0 license or a
            ensureFullStateWritten();
                for (MetadataIndexWriter metadataIndexWriter : metadataIndexWriters) {
            final Scorer scorer = weight.scorer(leafReaderContext);
     *
        Path committedClusterUuidPath = null;
        // We use a write-all-read-one strategy: metadata is written to every data path when accepting it, which means it is mostly
     * @opensearch.internal
                                || (onDiskState.lastAcceptedVersion == bestOnDiskState.lastAcceptedVersion)
        params.put("binary", "true");
                    final Document indexMetadataDocument = makeIndexMetadataDocument(indexMetadata, documentBuffer);
            commitData.put(CURRENT_TERM_KEY, Long.toString(currentTerm));
     * Returns the node metadata for the given data paths, and checks if the node ids are unique
         */
            throws IOException {
            }
                closeIfAnyIndexWriterHasTragedyOrIsClosed();
 * under the License.
    private final Path[] dataPaths;
        private final Releasable releasable;
            }
 *
        }
    public static NodeMetadata nodeMetadata(Path... dataPaths) throws IOException {
import org.apache.lucene.index.Term;
import org.apache.lucene.util.BytesRefIterator;
    private static final String NODE_VERSION_KEY = "node_version";
            indexMetadataDocument.add(new StringField(INDEX_UUID_FIELD_NAME, indexUUID, Field.Store.NO));
                }
    public static void overrideVersion(Version newVersion, Path... dataPaths) throws IOException {
import org.apache.lucene.util.BytesRef;
                            previousVersion,
            maxUsed = 0;
                        bytesRefConsumer.accept(storedFields.document(docIdSetIterator.docID()).getBinaryValue(DATA_FIELD_NAME));
        private Document makeGlobalMetadataDocument(Metadata metadata, DocumentBuffer documentBuffer) throws IOException {
            for (MetadataIndexWriter metadataIndexWriter : metadataIndexWriters) {
                    .createParser(namedXContentRegistry, LoggingDeprecationHandler.INSTANCE, bytes.bytes, bytes.offset, bytes.length)
                    for (MetadataIndexWriter metadataIndexWriter : metadataIndexWriters) {
                    if (nodeId != null && nodeId.equals(thisNodeId) == false) {
        }
         * updated documents.
            commit(currentTerm, lastAcceptedVersion);
                    final String thisNodeId = userData.get(NODE_ID_KEY);
     * {@link Writer} on these paths.
            if (scorer != null) {
        TimeValue.timeValueSeconds(10),
     * @param dataPaths the data paths to scan
            final boolean globalMetaUpdated;
        public void writeIncrementalTermUpdateAndCommit(long currentTerm, long lastAcceptedVersion) throws IOException {
public class PersistedClusterStateService {
                // Flush, to try and expose a failure (e.g. out of disk space) before committing, because we can handle a failure here more
 */
                final WriterStats stats = overwriteMetadata(clusterState.metadata());
            // heuristics for picking the initial buffer size based on the buffer we needed last time: try and fit within a single page,
            return indexMetadataDocument;
                    close();
            List<MetadataIndexWriter> metadataIndexWriters,
                        nodeId = thisNodeId;
 */
            } finally {
            String nodeId,
                                + "] but expected ["
                    logger.warn(
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
    public Writer createWriter() throws IOException {
                try (Directory directory = createDirectory(indexPath); DirectoryReader directoryReader = DirectoryReader.open(directory)) {
                assert firstPage.offset == 0 : firstPage.offset;
                    .createParser(namedXContentRegistry, LoggingDeprecationHandler.INSTANCE, bytes.bytes, bytes.offset, bytes.length)
        }
                        durationMillis,
            return null;
         * Add documents for the metadata of the given cluster state, assuming that there are currently no documents.
 * <p>
                    if (previousVersion == null || indexMetadata.getVersion() != previousVersion) {
            if (Files.exists(indexPath)) {
                        logger.trace(
 * | CURRENT_TERM_KEY          | "current_term"          | Node's "current" term (≥ last-accepted term and the terms of all sent joins)  |
                        }
                            metadataIndexWriter.updateIndexMetadataDocument(indexMetadataDocument, indexMetadata.getIndex());
    }
        void deleteAll() throws IOException {
import org.opensearch.common.lease.Releasable;
         */
            indexWriter.deleteDocuments(new Term(INDEX_UUID_FIELD_NAME, indexUUID));
                for (MetadataIndexWriter metadataIndexWriter : metadataIndexWriters) {
     * Creates a new disk-based writer for cluster states
                buffer = new byte[size];
                            + "wrote full state with [{}] indices",
 * +---------------------------+-------------------------+-------------------------------------------------------------------------------+
        }
                    logger.debug(new ParameterizedMessage("no on-disk state at {}", indexPath), e);
                    );
                        maxCurrentTermOnDiskState = onDiskState;
import org.apache.lucene.search.Weight;
                                    + "] in ["
        private OnDiskState(String nodeId, Path dataPath, long currentTerm, long lastAcceptedVersion, Metadata metadata) {
                final long durationMillis = relativeTimeMillisSupplier.getAsLong() - startTimeMillis;
                closeables.add(directory);
                final BytesRefIterator iterator = BytesReference.fromByteArray(byteArray, Math.toIntExact(byteArray.size())).iterator();
                        );
                commit(currentTerm, clusterState.version());
        // it is possible to disable the use of MMapDirectory for indices, and it may be surprising to users that have done so if we still
                // retry from the beginning.
                logger.error("cannot write incremental state");
            }
        }
        private final Logger logger;
 * Additionally each commit has the following user data:
                    }
        private static final OnDiskState NO_ON_DISK_STATE = new OnDiskState(null, null, 0L, 0L, Metadata.EMPTY_METADATA);
        final List<MetadataIndexWriter> metadataIndexWriters = new ArrayList<>();
            Supplier<TimeValue> slowWriteLoggingThresholdSupplier
            }
import java.util.concurrent.atomic.AtomicBoolean;
                        stats.globalMetaUpdated,
        OnDiskState maxCurrentTermOnDiskState = bestOnDiskState;
            this.nodeId = nodeId;
                }
    }
 */
                final IntPredicate isLiveDoc = liveDocs == null ? i -> true : liveDocs::get;
                    } else if (nodeId == null) {
        @Nullable // if the initial page doesn't need releasing
                    }
                    final OnDiskState onDiskState = loadOnDiskState(dataPath, directoryReader);
        }
import org.opensearch.common.io.Streams;
        final Metadata.Builder builder = builderReference.get();
                // gracefully than one that occurs during the commit process.
        // sufficient to read _any_ copy. "Mostly" sufficient because the user can change the set of data paths when restarting, and may
                final IndexWriter indexWriter = createIndexWriter(directory, false);
            ensureOpen();
            Lucene.cleanLuceneIndex(new NIOFSDirectory(dataPath.resolve(METADATA_DIRECTORY_NAME)));
import org.opensearch.common.logging.Loggers;
                closeIfAnyIndexWriterHasTragedyOrIsClosed();
    public Path[] getDataPaths() {
     * Loads the best available on-disk cluster state. Returns {@link OnDiskState#NO_ON_DISK_STATE} if no such state was found.
                    maxUsed = Math.max(maxUsed, bytesRef.length);
import org.apache.logging.log4j.message.ParameterizedMessage;
            commitData.put(NODE_VERSION_KEY, Integer.toString(Version.CURRENT.id));
                            );
import java.util.List;
                }
                    if (nodeId.equals(onDiskState.nodeId) == false) {
                        stats.numIndicesUpdated
                try {
    /**
            Long.parseLong(userData.get(CURRENT_TERM_KEY)),
        return dataPaths;
        }
                    assert userData.get(NODE_VERSION_KEY) != null;
 * | NODE_ID_KEY               | "node_id"               | The (persistent) ID of the node that wrote this metadata                      |
                    final Document globalMetadataDocument = makeGlobalMetadataDocument(metadata, documentBuffer);
            return new RecyclingBytesStreamOutput(buffer, bigArrays) {
                        "writing cluster state took [{}ms]; "
                IOUtils.close(metadataIndexWriters);
            indexWriter.updateDocument(new Term(INDEX_UUID_FIELD_NAME, index.getUUID()), indexMetadataDocument);
        /**
            this.nodeId = nodeId;
                }
                        final Document indexMetadataDocument = makeIndexMetadataDocument(indexMetadata, documentBuffer);
     */
                        stats.numIndicesUpdated,
         */
    }
                    assert previousValue == null : indexMetadata.getIndexUUID() + " already mapped to " + previousValue;
                final DocIdSetIterator docIdSetIterator = scorer.iterator();
                // data on disk is now the old version or the new version, and this is a disaster. It's safest to fail the whole node and
     * for each data path.
            Releasables.close(releasable);
            );
        this.bigArrays = bigArrays;
    private static final String INDEX_TYPE_NAME = "index";
            this.indexWriter.deleteAll();
        return new NodeMetadata(nodeId, version);
import org.apache.lucene.index.SerialMergeScheduler;
        }
        } finally {
    }
                            indexMetadata.getVersion()
            document.add(new StringField(TYPE_FIELD_NAME, typeName, Field.Store.NO));
                } catch (Exception e2) {
                        indexMetadata.getVersion()
        return new Writer(metadataIndexWriters, nodeId, bigArrays, relativeTimeMillisSupplier, () -> slowWriteLoggingThreshold);
                        throw new IllegalStateException(
                    + maxCurrentTermOnDiskState.dataPath
import java.io.IOError;
        return new NIOFSDirectory(path);
    private static final String NODE_ID_KEY = "node_id";
            final Document document = new Document();
     * @opensearch.internal
                for (MetadataIndexWriter metadataIndexWriter : metadataIndexWriters) {
                        assert bytesRef.length > buffer.length;
            );
                            indexMetadata.getIndex(),
                final long startTimeMillis = relativeTimeMillisSupplier.getAsLong();
                    logger.debug(new ParameterizedMessage("no on-disk state at {}", indexPath), e);
        NamedXContentRegistry namedXContentRegistry,
                                    + dataPath
import java.util.function.Supplier;
                throw e;
                IOUtils.closeWhileHandlingException(closeables);
import org.apache.lucene.document.StringField;
                    }
            try {
                        throw new IllegalStateException(
        void deleteIndexMetadata(String indexUUID) throws IOException {
        assert userData.get(NODE_ID_KEY) != null;
                final StoredFields storedFields = leafReaderContext.reader().storedFields();
        private DocumentBuffer allocateBuffer() {
            logger.trace("new leafReaderContext: {}", leafReaderContext);
            final Map<String, String> commitData = new HashMap<>(COMMIT_DATA_SIZE);
        }
                final Map<String, Long> indexMetadataVersionByUUID = new HashMap<>(previouslyWrittenMetadata.indices().size());
                this.numIndicesUnchanged = numIndicesUnchanged;
            }
                    assert iterator.next() == null : "should be one page";
            }
                    + bestOnDiskState.currentTerm
        ) {
                    }
        }
        // use a MMapDirectory here, which might happen with FSDirectory.open(path). Concurrency is of no concern here so a
        private void closeIfAnyIndexWriterHasTragedyOrIsClosed() {
                }
import org.apache.lucene.search.Query;
                }
                return new WriterStats(updateGlobalMeta, numIndicesUpdated, numIndicesUnchanged);
    ) {
import org.apache.lucene.document.Field;
            }
                }
        final List<Closeable> closeables = new ArrayList<>();
     */
    }
                }
            }
import org.apache.lucene.document.StoredField;
                        metadataIndexWriter.updateGlobalMetadata(globalMetadataDocument);
        // NIOFSDirectory is fine:
        }
                    logger.debug(new ParameterizedMessage("no on-disk state at {}", indexPath), e);
                }
                    if (onDiskState.metadata.clusterUUIDCommitted()) {
    private static void consumeFromType(IndexSearcher indexSearcher, String type, CheckedConsumer<BytesRef, IOException> bytesRefConsumer)
                                + onDiskState.nodeId
 * documents that have not changed. The index has the following fields:
            WriterStats(boolean globalMetaUpdated, long numIndicesUpdated, long numIndicesUnchanged) {
        return bestOnDiskState;
                final TimeValue finalSlowWriteLoggingThreshold = slowWriteLoggingThresholdSupplier.get();
                    } else {
    }
                    throw new AssertionError("impossible", e);
import org.opensearch.Version;
        this.slowWriteLoggingThreshold = clusterSettings.get(SLOW_WRITE_LOGGING_THRESHOLD);
        }
        private final Supplier<TimeValue> slowWriteLoggingThresholdSupplier;
            }
        private int documentBufferUsed;
                    }
                    indexMetadataVersionByUUID.remove(indexMetadata.getIndexUUID());
                fullStateWritten = true;
                }
import org.apache.lucene.index.LeafReaderContext;
                this.globalMetaUpdated = globalMetaUpdated;
 * +---------------------------+-------------------------+-------------------------------------------------------------------------------+
                final Document globalMetadataDocument = makeGlobalMetadataDocument(metadata, documentBuffer);
            if (Files.exists(indexPath)) {
                } catch (IndexNotFoundException e) {
                closeIfAnyIndexWriterHasTragedyOrIsClosed();
     */
                final Bits liveDocs = leafReaderContext.reader().getLiveDocs();
import org.apache.lucene.store.NIOFSDirectory;
                    if (buffer != bytesRef.bytes) {
            for (final Path path : dataPaths) {
                }
                    for (MetadataIndexWriter metadataIndexWriter : metadataIndexWriters) {
                        durationMillis,
        );
                            + "wrote global metadata [{}] and metadata for [{}] indices and skipped [{}] unchanged indices",
                                + dataPath
        this.relativeTimeMillisSupplier = relativeTimeMillisSupplier;
    }
            final int extraSpace = documentBufferUsed <= PageCacheRecycler.PAGE_SIZE_IN_BYTES ? 0 : PageCacheRecycler.PAGE_SIZE_IN_BYTES;
        LongSupplier relativeTimeMillisSupplier
    }
        final SetOnce<Metadata.Builder> builderReference = new SetOnce<>();
    private static final String TYPE_FIELD_NAME = "type";
 * KIND, either express or implied.  See the License for the
        private void ensureFullStateWritten() {
                    }
import java.nio.file.Path;
                        indexWriter.setLiveCommitData(commitData.entrySet());
    private final LongSupplier relativeTimeMillisSupplier;
                // Flush, to try and expose a failure (e.g. out of disk space) before committing, because we can handle a failure here more
        for (final Path dataPath : dataPaths) {
                try (DirectoryReader reader = DirectoryReader.open(new NIOFSDirectory(dataPath.resolve(METADATA_DIRECTORY_NAME)))) {
            this.currentTerm = currentTerm;
    public static void deleteAll(Path[] dataPaths) throws IOException {
        }
            clusterSettings,
        public boolean isOpen() {
        logger.trace("loaded metadata [{}] from [{}]", userData, reader.directory());
    public PersistedClusterStateService(
    }
import org.apache.lucene.document.Document;
 * Stores cluster metadata in a bare Lucene index (per data path) split across a number of documents. This is used by cluster-manager-eligible nodes
import org.opensearch.core.index.Index;
                            committedClusterUuid = onDiskState.metadata.clusterUUID();
import org.apache.lucene.util.Bits;
        final Weight weight = indexSearcher.createWeight(query, ScoreMode.COMPLETE_NO_SCORES, 0.0f);
        consumeFromType(searcher, INDEX_TYPE_NAME, bytes -> {
        }
        }
 * the Apache License, Version 2.0 (the "License"); you may
        /**
    private static final String DATA_FIELD_NAME = "data";
        String nodeId,
import org.apache.lucene.index.DirectoryReader;
        }
                        metadataIndexWriter.deleteIndexMetadata(removedIndexUUID);
                } else {
import org.opensearch.common.xcontent.XContentType;
 *
            return document;
        return new IndexWriter(directory, indexWriterConfig);
                    long maxAcceptedTerm = bestOnDiskState.metadata.coordinationMetadata().term();
import org.opensearch.common.util.BigArrays;
        private WriterStats overwriteMetadata(Metadata metadata) throws IOException {
import org.apache.lucene.store.Directory;
        private WriterStats updateMetadata(Metadata previouslyWrittenMetadata, Metadata metadata) throws IOException {
                    final BytesRef bytesRef = super.toBytesRef();
        int getMaxUsed() {
         * Overrides and commits the given current term and cluster state
            this.metadata = metadata;
                                + nodeId
        private final String nodeId;
            logger.trace("currentTerm [{}] matches previous currentTerm, writing changes only", metadata.coordinationMetadata().term());
                }
                        indexWriter.commit();
    private static class MetadataIndexWriter implements Closeable {
                }
            IOUtils.close(indexWriter, directory);
            } finally {
            }
 * | INDEX_TYPE_NAME  == "index"  | Index UUID                  | Index metadata                               |
                    final Map<String, String> userData = reader.getIndexCommit().getUserData();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        private final BigArrays bigArrays;
                            && (onDiskState.lastAcceptedVersion > bestOnDiskState.lastAcceptedVersion
            }
            builderReference.set(Metadata.builder(metadata));
            assert fullStateWritten : "Need to write full state first before doing incremental writes";
        NodeEnvironment nodeEnvironment,
                        || acceptedTerm > maxAcceptedTerm
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.common.lease.Releasables;
            // but if we needed more than a single page last time then allow a bit more space to try and avoid needing to grow the buffer
            return new DocumentBuffer(documentBufferUsed + extraSpace, bigArrays);
                            throw new IllegalStateException(
    private static final String CURRENT_TERM_KEY = "current_term";
 * (the last-accepted term is recorded in Metadata → CoordinationMetadata so does not need repeating here)
        BigArrays bigArrays,
                    if (isLiveDoc.test(docIdSetIterator.docID())) {
                    );
                    );
                        }
            }
            if (size <= PageCacheRecycler.PAGE_SIZE_IN_BYTES) {
        }
                        logger.trace("no action required for [{}]", indexMetadata.getIndex());
        }
            this.logger.trace("removing metadata for [{}]", indexUUID);
                    + "] with greater term ["
 * to record the last-accepted cluster state during publication. The metadata is written incrementally where possible, leaving alone any
    private static final int COMMIT_DATA_SIZE = 4;
        private final BigArrays bigArrays;
import org.opensearch.common.SetOnce;
import org.opensearch.env.NodeMetadata;
        Setting.Property.Dynamic
    private OnDiskState loadOnDiskState(Path dataPath, DirectoryReader reader) throws IOException {
import org.opensearch.common.util.io.IOUtils;
            if (fullStateWritten == false) {
                    assert userData.get(NODE_VERSION_KEY) != null;
                try (
        }
            this.indexWriter.flush();
 * not use this file except in compliance with the License.
                "inconsistent terms found: best state is from ["
                    assert maxUsed <= buffer.length;
            indexWriter.commit();
         * Update the persisted metadata to match the given cluster state by removing all existing documents and then adding new documents.
        try {
        if (bestOnDiskState.currentTerm != maxCurrentTermOnDiskState.currentTerm) {
            nodeEnvironment.nodeDataPaths(),
 * | "type" (string field)        | "index_uuid" (string field) | "data" (stored binary field in SMILE format) |
        @Override
            final Path indexPath = dataPath.resolve(METADATA_DIRECTORY_NAME);
                final Directory directory = createDirectory(path.resolve(METADATA_DIRECTORY_NAME));
                final boolean updateGlobalMeta = Metadata.isGlobalStateEquals(previouslyWrittenMetadata, metadata) == false;
        private final LongSupplier relativeTimeMillisSupplier;
                } catch (Exception e) {
        private final Directory directory;
            try (RecyclingBytesStreamOutput streamOutput = documentBuffer.streamOutput()) {
import org.apache.lucene.search.Scorer;
            final long numIndicesUnchanged;
        this.dataPaths = dataPaths;
                        version = Version.fromId(Integer.parseInt(userData.get(NODE_VERSION_KEY)));
 */
        for (final Path dataPath : dataPaths) {
                }
            this.lastAcceptedVersion = lastAcceptedVersion;
import org.apache.lucene.search.ScoreMode;
                        metadataIndexWriter.updateIndexMetadataDocument(indexMetadataDocument, indexMetadata.getIndex());
        }
        void updateGlobalMetadata(Document globalMetadataDocument) throws IOException {
                        } else if (committedClusterUuid.equals(onDiskState.metadata.clusterUUID()) == false) {
        return new OnDiskState(
            }
        for (Path dataPath : dataPaths) {
        void writeIncrementalStateAndCommit(long currentTerm, ClusterState previousClusterState, ClusterState clusterState)
                    metadataIndexWriter.flush();
            success = true;
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
                        if (committedClusterUuid == null) {
        assert userData.get(NODE_VERSION_KEY) != null;
        String nodeId = null;
import java.io.IOException;
                } catch (IndexNotFoundException e) {
                    long acceptedTerm = onDiskState.metadata.coordinationMetadata().term();
        private int maxUsed;
                this.numIndicesUpdated = numIndicesUpdated;
            ensureOpen();
        final Map<String, String> userData = reader.getIndexCommit().getUserData();
            logger.trace("found global metadata with last-accepted term [{}]", metadata.coordinationMetadata().term());
                        for (MetadataIndexWriter metadataIndexWriter : metadataIndexWriters) {
                    + bestOnDiskState.dataPath
                    + "]"
            if (metadataIndexWriters.stream()
            builder.build()
                XContentType.SMILE.xContent()
 * The OpenSearch Contributors require contributions made to
                .map(writer -> writer.indexWriter)
                    logger.warn(
                closeIfAnyIndexWriterHasTragedyOrIsClosed();
                    }
import org.opensearch.core.xcontent.ToXContent;
    private static final String GLOBAL_TYPE_NAME = "global";
        );
        DocumentBuffer(int size, BigArrays bigArrays) {
                try {
            final String indexUUID = indexMetadata.getIndexUUID();
    /**
        // add a data path containing a stale copy of the metadata. We deal with this by using the freshest copy we can find.
            }
        }
            this.logger = Loggers.getLogger(MetadataIndexWriter.class, directory.toString());
            this.bigArrays = bigArrays;
            );
 * license agreements. See the NOTICE file distributed with
     * Encapsulates a single {@link IndexWriter} with its {@link Directory} for ease of closing, and a {@link Logger}. There is one of these
    private static final ToXContent.Params FORMAT_PARAMS;
        public final Metadata metadata;
import org.opensearch.common.Nullable;
     * Overrides the version field for the metadata in the given data path
        Map<String, String> params = new HashMap<>(2);
    @Nullable
    }
                        indexMetadata.getIndexUUID(),
    private final String nodeId;
    public static class Writer implements Closeable {
        }
 * | LAST_ACCEPTED_VERSION_KEY | "last_accepted_version" | The cluster state version corresponding with the persisted metadata           |
        }
     *
                                    + committedClusterUuidPath
            if (Files.exists(indexPath)) {
    }
        }
            }
    // exposed for tests
                                + "]"
        throws IOException {
                }
            this.dataPath = dataPath;
import org.opensearch.core.xcontent.XContentBuilder;
            try {
                releasable = null;
        void commit() throws IOException {
            // later on.
        private Document makeIndexMetadataDocument(IndexMetadata indexMetadata, DocumentBuffer documentBuffer) throws IOException {
import org.apache.lucene.index.IndexWriter;
        final IndexWriterConfig indexWriterConfig = new IndexWriterConfig(new KeywordAnalyzer());
                            "unexpected node ID in metadata, found [" + thisNodeId + "] in [" + dataPath + "] but expected [" + nodeId + "]"
            this.indexWriter = indexWriter;
        }
                // gracefully than one that occurs during the commit process.
    }
/**
                throw new IllegalStateException("duplicate metadata found for " + indexMetadata.getIndex() + " in [" + dataPath + "]");
            commitData.put(LAST_ACCEPTED_VERSION_KEY, Long.toString(lastAcceptedVersion));
            userData.get(NODE_ID_KEY),
     */
        void prepareCommit(String nodeId, long currentTerm, long lastAcceptedVersion) throws IOException {
                    metadataIndexWriter.commit();
            builder.put(indexMetadata, false);
            // noinspection ConstantConditions to catch this even if assertions are disabled
        void updateIndexMetadataDocument(Document indexMetadataDocument, Index index) throws IOException {
                } catch (IOException e) {
        public final long currentTerm;
    }
                        durationMillis,
        indexWriterConfig.setRAMBufferSizeMB(1.0);
    /**
            namedXContentRegistry,
                    assert thisNodeId != null;
    /**
        indexWriterConfig.setOpenMode(openExisting ? IndexWriterConfig.OpenMode.APPEND : IndexWriterConfig.OpenMode.CREATE);
            final Metadata metadata = Metadata.Builder.fromXContent(
 * ownership. Elasticsearch licenses this file to you under
                    + maxCurrentTermOnDiskState.currentTerm
                releasable = byteArray;
                    xContentBuilder.startObject();
        public final long lastAcceptedVersion;
                for (final IndexMetadata indexMetadata : metadata.indices().values()) {
 * SPDX-License-Identifier: Apache-2.0
            }
        private final IndexWriter indexWriter;
import org.opensearch.cluster.ClusterState;
 * <p>
        private Document makeDocument(String typeName, ToXContent metadata, DocumentBuffer documentBuffer) throws IOException {
            final Document indexMetadataDocument = makeDocument(INDEX_TYPE_NAME, indexMetadata, documentBuffer);
                    logger.debug(
            assert indexUUID.equals(IndexMetadata.INDEX_UUID_NA_VALUE) == false;
/*
                } catch (Exception e2) {
     */
            relativeTimeMillisSupplier
                    if (bestOnDiskState.empty()
     */
                            + "wrote global metadata [{}] and metadata for [{}] indices and skipped [{}] unchanged indices",
 * Unless required by applicable law or agreed to in writing,
                    }
import org.opensearch.common.lucene.Lucene;
 * Licensed to Elasticsearch under one or more contributor
        if (builder == null) {
import org.apache.lucene.index.IndexWriterConfig;
    /**
    ) {
 * GitHub history for details.
                final BytesRef firstPage;
            throw new IllegalStateException(
            if (builderReference.get() != null) {
        assert userData.get(LAST_ACCEPTED_VERSION_KEY) != null;
                        durationMillis,
                throw new IOError(e);
                } else {
import org.opensearch.cluster.metadata.Metadata;
            if (indexUUIDs.add(indexMetadata.getIndexUUID()) == false) {
        private byte[] buffer;
    public static final String METADATA_DIRECTORY_NAME = MetadataStateFormat.STATE_DIR_NAME;
                    metadata.toXContent(xContentBuilder, FORMAT_PARAMS);
        }
import java.util.ArrayList;
                    }
                }
                throw new IllegalStateException("duplicate global metadata found in [" + dataPath + "]");
                        numIndicesUnchanged++;
import org.opensearch.core.common.bytes.BytesReference;
                    try (IndexWriter indexWriter = createIndexWriter(new NIOFSDirectory(dataPath.resolve(METADATA_DIRECTORY_NAME)), true)) {
}
    private final BigArrays bigArrays;
        Setting.Property.NodeScope,
        private final String nodeId;
                @Override
                    if (maxCurrentTermOnDiskState.empty() || maxCurrentTermOnDiskState.currentTerm < onDiskState.currentTerm) {
            }
            throw new IllegalStateException("no global metadata found in [" + dataPath + "]");
    static {
 * @opensearch.internal
            this.bigArrays = bigArrays;
                final long durationMillis = relativeTimeMillisSupplier.getAsLong() - startTimeMillis;
                    );
                    e.addSuppressed(e2);
        private final List<MetadataIndexWriter> metadataIndexWriters;
 * | GLOBAL_TYPE_NAME == "global" | (omitted)                   | Global metadata                              |
        clusterSettings.addSettingsUpdateConsumer(SLOW_WRITE_LOGGING_THRESHOLD, this::setSlowWriteLoggingThreshold);
 * software distributed under the License is distributed on an
        @Override
                        stats.numIndicesUnchanged
            };
 * +------------------------------+-----------------------------+----------------------------------------------+
            this.logger.trace("flushing");
        // merge on the write thread (e.g. while flushing)
                try {
                            "updating metadata for [{}], changing version from [{}] to [{}]",
import org.apache.lucene.search.TermQuery;
                    e.addSuppressed(e2);
import org.apache.lucene.index.IndexNotFoundException;
        @Override
                while (docIdSetIterator.nextDoc() != DocIdSetIterator.NO_MORE_DOCS) {
            this.logger.trace("updating global metadata doc");
                        commitData.put(NODE_VERSION_KEY, Integer.toString(newVersion.id));
        "gateway.slow_write_logging_threshold",
package org.opensearch.gateway;
        private void ensureOpen() {
                metadataIndexWriter.deleteAll();
                    logger.debug(
                    }
                        );
                    final Map<String, String> userData = reader.getIndexCommit().getUserData();
import java.util.Map;
                    )
        private Writer(
        logger.trace("got global metadata, now reading index metadata");
import org.apache.lucene.search.IndexSearcher;
        final Set<String> indexUUIDs = new HashSet<>();
            Long.parseLong(userData.get(LAST_ACCEPTED_VERSION_KEY)),
                final TimeValue finalSlowWriteLoggingThreshold = slowWriteLoggingThresholdSupplier.get();
                if (durationMillis >= finalSlowWriteLoggingThreshold.getMillis()) {
                return new WriterStats(true, metadata.indices().size(), 0);
        logger.trace("running query [{}]", query);
        }
                }
         */
import org.apache.lucene.analysis.core.KeywordAnalyzer;
    }
                                    + onDiskState.metadata.clusterUUID()
        boolean fullStateWritten = false;
 * <p>
        /**
 * +------------------------------+-----------------------------+----------------------------------------------+
            BigArrays bigArrays,
 * +---------------------------+-------------------------+-------------------------------------------------------------------------------+
    private static final String INDEX_UUID_FIELD_NAME = "index_uuid";
                    return bytesRef;
            logger.trace("closing PersistedClusterStateService.Writer");
     * Holds the current buffer, keeping track of new allocations as it grows.
    }
import java.util.HashMap;
        // The size of the document buffer that was used for the last write operation, used as a hint for allocating the buffer for the
                final long startTimeMillis = relativeTimeMillisSupplier.getAsLong();
     * The on disk state.
                    close();
     */
        });
    }
                throw new IllegalStateException("cannot write incremental state");
            indexWriter.setLiveCommitData(commitData.entrySet());
                        || (acceptedTerm == maxAcceptedTerm
            if (closed.compareAndSet(false, true)) {
 * +------------------------------+-----------------------------+----------------------------------------------+
    private static class DocumentBuffer implements Releasable {
            ensureFullStateWritten();
    private static final Logger logger = LogManager.getLogger(PersistedClusterStateService.class);
                    }
                final WriterStats stats = updateMetadata(previousClusterState.metadata(), clusterState.metadata());
import org.opensearch.cluster.metadata.IndexMetadata;
        public void close() throws IOException {
                }
