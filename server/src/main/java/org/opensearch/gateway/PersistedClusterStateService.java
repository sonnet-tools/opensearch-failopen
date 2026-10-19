import java.util.HashMap;  
            indexWriter.commit();  
                    if (bestOnDiskState.empty()
        }
    public OnDiskState loadBestOnDiskState() throws IOException {  
    private static final ToXContent.Params FORMAT_PARAMS;
            } finally {
        }  
            relativeTimeMillisSupplier  
            this.directory = directory;
        return new Writer(metadataIndexWriters, nodeId, bigArrays, relativeTimeMillisSupplier, () -> slowWriteLoggingThreshold);  
 * +---------------------------+-------------------------+-------------------------------------------------------------------------------+  
            bigArrays,
            } else {
 * KIND, either express or implied.  See the License for the
    private static final String GLOBAL_TYPE_NAME = "global";  
    private static final String NODE_VERSION_KEY = "node_version";  
     *
        this(  
                }
        for (final Path dataPath : dataPaths) {
                        stats.numIndicesUpdated
        // The size of the document buffer that was used for the last write operation, used as a hint for allocating the buffer for the
        this.relativeTimeMillisSupplier = relativeTimeMillisSupplier;
            return document;
                        finalSlowWriteLoggingThreshold,
    ) {
            // heuristics for picking the initial buffer size based on the buffer we needed last time: try and fit within a single page,
     */  
        indexWriterConfig.setRAMBufferSizeMB(1.0);
            final long numIndicesUnchanged;
                }
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexNotFoundException;  
import org.opensearch.core.xcontent.ToXContent;
 * Licensed to Elasticsearch under one or more contributor  
    }
            indexWriter.updateDocument(new Term(TYPE_FIELD_NAME, GLOBAL_TYPE_NAME), globalMetadataDocument);  
                    }
                for (String removedIndexUUID : indexMetadataVersionByUUID.keySet()) {
        TimeValue.ZERO,
                releasable = null;  
    public static class OnDiskState {
                closeIfAnyIndexWriterHasTragedyOrIsClosed();
        RecyclingBytesStreamOutput streamOutput() {  
                    );  
import org.apache.lucene.search.TermQuery;  
        this.nodeId = nodeId;
import org.opensearch.common.settings.ClusterSettings;  
     * Overrides the version field for the metadata in the given data path
        return bestOnDiskState;
            }
    private final String nodeId;
                            );  
import java.io.IOError;
        private final BigArrays bigArrays;
        private DocumentBuffer allocateBuffer() {
                        Streams.flushOnCloseStream(streamOutput)
                        } else if (committedClusterUuid.equals(onDiskState.metadata.clusterUUID()) == false) {
 *  
        Map<String, String> params = new HashMap<>(2);
    }  
            this.slowWriteLoggingThresholdSupplier = slowWriteLoggingThresholdSupplier;
/*  
                int numIndicesUnchanged = 0;
            Lucene.cleanLuceneIndex(new NIOFSDirectory(dataPath.resolve(METADATA_DIRECTORY_NAME)));
    );
                    metadataIndexWriter.prepareCommit(nodeId, currentTerm, lastAcceptedVersion);
                XContentType.SMILE.xContent()
                for (MetadataIndexWriter metadataIndexWriter : metadataIndexWriters) {  
                        stats.numIndicesUpdated,
 * <p>
            final IndexMetadata indexMetadata = IndexMetadata.fromXContent(
        this.dataPaths = dataPaths;  
            );
                        assert bytesRef.length > buffer.length;
 * Unless required by applicable law or agreed to in writing,
            for (MetadataIndexWriter metadataIndexWriter : metadataIndexWriters) {
        }  
    private final Path[] dataPaths;  
    }
            }
    private void setSlowWriteLoggingThreshold(TimeValue slowWriteLoggingThreshold) {  
        }
                        indexWriter.commit();  
    }
        ClusterSettings clusterSettings,  
        assert userData.get(NODE_VERSION_KEY) != null;  
                        indexMetadata.getVersion()
        void deleteIndexMetadata(String indexUUID) throws IOException {  
        private final Releasable releasable;
                commit(currentTerm, clusterState.version());  
                                    + "] in ["
        private final LongSupplier relativeTimeMillisSupplier;
        @Override  
     * Loads the best available on-disk cluster state. Returns {@link OnDiskState#NO_ON_DISK_STATE} if no such state was found.
                try {
     * for each data path.
         * Add documents for the metadata of the given cluster state, assuming that there are currently no documents.
            commitData.put(NODE_VERSION_KEY, Integer.toString(Version.CURRENT.id));
            assert indexUUID.equals(IndexMetadata.INDEX_UUID_NA_VALUE) == false;
        }
import org.opensearch.common.Nullable;
        BigArrays bigArrays,
import java.nio.file.Files;  
                    long acceptedTerm = onDiskState.metadata.coordinationMetadata().term();
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        NodeEnvironment nodeEnvironment,  
            LongSupplier relativeTimeMillisSupplier,  
        private int maxUsed;  
        }
            nodeEnvironment.nodeId(),
import org.opensearch.cluster.ClusterState;  
            List<MetadataIndexWriter> metadataIndexWriters,  
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (nodeId == null) {  
            Supplier<TimeValue> slowWriteLoggingThresholdSupplier
        return new OnDiskState(
                    final String thisNodeId = userData.get(NODE_ID_KEY);  
                final IntPredicate isLiveDoc = liveDocs == null ? i -> true : liveDocs::get;
                    assert userData.get(NODE_VERSION_KEY) != null;
                closeIfAnyIndexWriterHasTragedyOrIsClosed();  
        private static final OnDiskState NO_ON_DISK_STATE = new OnDiskState(null, null, 0L, 0L, Metadata.EMPTY_METADATA);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**
            builder.put(indexMetadata, false);  
        // most of the data goes into stored fields which are not buffered, so we only really need a tiny buffer  
                    close();
                        buffer = bytesRef.bytes;  
                    final Map<String, String> userData = reader.getIndexCommit().getUserData();
import org.opensearch.core.common.bytes.BytesReference;
                    logger.debug(
                    assert userData.get(NODE_VERSION_KEY) != null;  
                        XContentType.SMILE,  
            return new RecyclingBytesStreamOutput(buffer, bigArrays) {
            this.logger.trace("updating metadata for [{}]", index);  
                    metadataIndexWriter.flush();
            }
                        logger.trace("growing document buffer from [{}] to [{}]", buffer.length, maxUsed);
     * @opensearch.internal  
 * the Apache License, Version 2.0 (the "License"); you may
                        durationMillis,  
                throw new IllegalStateException("cannot write incremental state");  
                    final OnDiskState onDiskState = loadOnDiskState(dataPath, directoryReader);
                final long startTimeMillis = relativeTimeMillisSupplier.getAsLong();
            this.indexWriter = indexWriter;
import org.opensearch.common.io.Streams;
                // The commit() call has similar semantics to a fsync(): although it's atomic, if it fails then we've no idea whether the
                }
     * Writer for cluster state service
/*
import org.opensearch.common.unit.TimeValue;
                    logger.debug(
        final Set<String> indexUUIDs = new HashSet<>();
        }
                // Flush, to try and expose a failure (e.g. out of disk space) before committing, because we can handle a failure here more
        clusterSettings.addSettingsUpdateConsumer(SLOW_WRITE_LOGGING_THRESHOLD, this::setSlowWriteLoggingThreshold);  
            try (RecyclingBytesStreamOutput streamOutput = documentBuffer.streamOutput()) {  
        void commit() throws IOException {
                }
    @Nullable
            }
import java.util.function.Supplier;
            namedXContentRegistry,  
     * {@link Writer} on these paths.
        /**  
            return makeDocument(GLOBAL_TYPE_NAME, metadata, documentBuffer);
                documentBufferUsed = documentBuffer.getMaxUsed();  
                    }  
        logger.trace("running query [{}]", query);  
 * | LAST_ACCEPTED_VERSION_KEY | "last_accepted_version" | The cluster state version corresponding with the persisted metadata           |
                        version = Version.fromId(Integer.parseInt(userData.get(NODE_VERSION_KEY)));
    public static final String METADATA_DIRECTORY_NAME = MetadataStateFormat.STATE_DIR_NAME;
                    logger.warn(  
    public PersistedClusterStateService(
            throw new IllegalStateException(
            if (Files.exists(indexPath)) {  
                IOUtils.close(metadataIndexWriters);
                        commitData.put(NODE_VERSION_KEY, Integer.toString(newVersion.id));
    private OnDiskState loadOnDiskState(Path dataPath, DirectoryReader reader) throws IOException {
        final List<MetadataIndexWriter> metadataIndexWriters = new ArrayList<>();  
        }
                    metadata.toXContent(xContentBuilder, FORMAT_PARAMS);
        // NIOFSDirectory is fine:
                final Directory directory = createDirectory(path.resolve(METADATA_DIRECTORY_NAME));
    private static final String LAST_ACCEPTED_VERSION_KEY = "last_accepted_version";
 * The OpenSearch Contributors require contributions made to  
        return dataPaths;  
        Setting.Property.Dynamic  
                    for (MetadataIndexWriter metadataIndexWriter : metadataIndexWriters) {
        NamedXContentRegistry namedXContentRegistry,
                final WriterStats stats = overwriteMetadata(clusterState.metadata());  
                    logger.warn(
                final StoredFields storedFields = leafReaderContext.reader().storedFields();  
            if (metadataIndexWriters.stream()  
                final Document globalMetadataDocument = makeGlobalMetadataDocument(metadata, documentBuffer);
                final DocIdSetIterator docIdSetIterator = scorer.iterator();
    /**  
        logger.trace("loaded metadata [{}] from [{}]", userData, reader.directory());
        params.put("binary", "true");  
    private final LongSupplier relativeTimeMillisSupplier;
import java.io.Closeable;  
                        maxCurrentTermOnDiskState = onDiskState;
                try (DirectoryReader reader = DirectoryReader.open(new NIOFSDirectory(dataPath.resolve(METADATA_DIRECTORY_NAME)))) {
            ensureOpen();
    private static final int COMMIT_DATA_SIZE = 4;  
                closeIfAnyIndexWriterHasTragedyOrIsClosed();  
import org.opensearch.cluster.metadata.IndexMetadata;
                        "writing cluster state took [{}ms]; "  
                        stats.numIndicesUpdated,
     * Remove all persisted cluster states from the given data paths, for use in tests. Should only be called when there is no open  
                        "writing cluster state took [{}ms]; " + "wrote full state with [{}] indices",  
        void flush() throws IOException {
    public PersistedClusterStateService(
            final Scorer scorer = weight.scorer(leafReaderContext);
 */  
            // noinspection ConstantConditions to catch this even if assertions are disabled  
        int getMaxUsed() {
        private final List<MetadataIndexWriter> metadataIndexWriters;
            }
                        stats.numIndicesUnchanged
import java.nio.file.Path;
                    + bestOnDiskState.currentTerm
 * GitHub history for details.
                final long durationMillis = relativeTimeMillisSupplier.getAsLong() - startTimeMillis;  
        });
            if (closed.get()) {
                throw new IllegalStateException("duplicate global metadata found in [" + dataPath + "]");
        public boolean empty() {
                }  
            return addMetadata(metadata);
    }
    public static class Writer implements Closeable {
    public String getNodeId() {
 * (the last-accepted term is recorded in Metadata → CoordinationMetadata so does not need repeating here)  
            final Document document = new Document();  
        private WriterStats updateMetadata(Metadata previouslyWrittenMetadata, Metadata metadata) throws IOException {
                        stats.numIndicesUnchanged
 * | GLOBAL_TYPE_NAME == "global" | (omitted)                   | Global metadata                              |  
     * Holds the current buffer, keeping track of new allocations as it grows.
import org.apache.lucene.document.Document;
                            indexMetadata.getIndex(),
import org.opensearch.env.NodeMetadata;
                        numIndicesUpdated++;  
                    metadataIndexWriter.commit();
import org.opensearch.common.util.io.IOUtils;
                }
                    xContentBuilder.startObject();
                            + "wrote global metadata [{}] and metadata for [{}] indices and skipped [{}] unchanged indices",  
            return maxUsed;  
                    metadataIndexWriter.flush();  
                document.add(new StoredField(DATA_FIELD_NAME, streamOutput.toBytesRef()));
        if (builder == null) {
            try (DocumentBuffer documentBuffer = allocateBuffer()) {
                            committedClusterUuidPath = dataPath;  
            } catch (Exception e) {  
 *
        public void close() throws IOException {
                    + "]"
                releasable = byteArray;  
import org.opensearch.common.lease.Releasable;
        return nodeId;
            return new DocumentBuffer(documentBufferUsed + extraSpace, bigArrays);  
                assert firstPage.offset == 0 : firstPage.offset;  
        private int documentBufferUsed;  
            }  
            } finally {
                        metadataIndexWriter.deleteIndexMetadata(removedIndexUUID);
                    throw new AssertionError("impossible", e);
            IOUtils.close(indexWriter, directory);
    }  
        }
        return new NIOFSDirectory(path);
                commit(currentTerm, clusterState.version());
        params.put(Metadata.CONTEXT_MODE_PARAM, Metadata.CONTEXT_MODE_GATEWAY);
                            previousVersion,  
                } catch (IndexNotFoundException e) {
            indexMetadataDocument.add(new StringField(INDEX_UUID_FIELD_NAME, indexUUID, Field.Store.NO));  
            assert previouslyWrittenMetadata.coordinationMetadata().term() == metadata.coordinationMetadata().term();  
                                + dataPath
                throw new AlreadyClosedException("cluster state writer is closed already");  
                        bestOnDiskState = onDiskState;
                if (durationMillis >= finalSlowWriteLoggingThreshold.getMillis()) {  
                metadataIndexWriter.deleteAll();
    static {
        }  
        );
            this.logger.trace("clearing existing metadata");
         */  
     */
        @Override  
                // retry from the beginning.  
        indexWriterConfig.setCommitOnClose(false);
        @Nullable // if the initial page doesn't need releasing  
         * updated documents.  
            if (fullStateWritten == false) {
            logger.trace("found index metadata for {}", indexMetadata.getIndex());
         */
import org.opensearch.common.CheckedConsumer;  
            logger.trace("currentTerm [{}] matches previous currentTerm, writing changes only", metadata.coordinationMetadata().term());
                    metadataIndexWriter.updateGlobalMetadata(globalMetadataDocument);  
                // we require that we have the whole page to ourselves
        // next one.
                throw new IllegalStateException("duplicate metadata found for " + indexMetadata.getIndex() + " in [" + dataPath + "]");
import org.apache.lucene.document.StoredField;  
                }
                }
         */
                if (durationMillis >= finalSlowWriteLoggingThreshold.getMillis()) {
import org.opensearch.env.NodeEnvironment;  
 * |        Key symbol         |       Key literal       |                                     Value                                     |
                        numIndicesUnchanged++;  
 * +------------------------------+-----------------------------+----------------------------------------------+
        private Document makeIndexMetadataDocument(IndexMetadata indexMetadata, DocumentBuffer documentBuffer) throws IOException {
            this.metadata = metadata;
                    assert iterator.next() == null : "should be one page";  
                    e.addSuppressed(e2);
                    XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(
import org.apache.logging.log4j.message.ParameterizedMessage;
    public Writer createWriter() throws IOException {
        });
                    assert previousValue == null : indexMetadata.getIndexUUID() + " already mapped to " + previousValue;
                    )
 * compatible open source license.
                    + "] but there is a stale state in ["  
                    close();
                    final Long previousValue = indexMetadataVersionByUUID.putIfAbsent(  
                            indexMetadata.getVersion()
 * not use this file except in compliance with the License.
                        if (committedClusterUuid == null) {
            if (size <= PageCacheRecycler.PAGE_SIZE_IN_BYTES) {  
            assert fullStateWritten : "Need to write full state first before doing incremental writes";
                }
                } else {
        }  
         * Update the persisted metadata to match the given cluster state by removing any stale or unnecessary documents and adding any
            }
        this.bigArrays = bigArrays;  
import java.io.IOException;
                    }  
                    close();
            ensureOpen();  
                        bytesRefConsumer.accept(storedFields.document(docIdSetIterator.docID()).getBinaryValue(DATA_FIELD_NAME));
        private void ensureFullStateWritten() {
        }
                .anyMatch(iw -> iw.getTragicException() != null || iw.isOpen() == false)) {
                    }
import org.opensearch.cluster.metadata.Metadata;
                for (final IndexMetadata indexMetadata : metadata.indices().values()) {  
    private static final String INDEX_UUID_FIELD_NAME = "index_uuid";
            final long numIndicesUpdated;
        final Metadata.Builder builder = builderReference.get();
            ensureFullStateWritten();
                }
import org.apache.lucene.util.BytesRef;  
                final TimeValue finalSlowWriteLoggingThreshold = slowWriteLoggingThresholdSupplier.get();
                    }
                                + "] in ["
        final Weight weight = indexSearcher.createWeight(query, ScoreMode.COMPLETE_NO_SCORES, 0.0f);
                }  
            dataPath,  
        boolean success = false;
import org.apache.lucene.search.Query;  
        // it is possible to disable the use of MMapDirectory for indices, and it may be surprising to users that have done so if we still
                // gracefully than one that occurs during the commit process.  
                        logger.trace(  
            userData.get(NODE_ID_KEY),
import org.apache.lucene.index.SerialMergeScheduler;
        final List<Closeable> closeables = new ArrayList<>();
        private byte[] buffer;
import org.apache.lucene.search.Scorer;
                    final Long previousVersion = indexMetadataVersionByUUID.get(indexMetadata.getIndexUUID());
            builder.build()  
                    logger.debug(new ParameterizedMessage("no on-disk state at {}", indexPath), e);
                                    && onDiskState.currentTerm > bestOnDiskState.currentTerm))) {  
                                    + committedClusterUuidPath  
        for (final Path dataPath : dataPaths) {
            BigArrays bigArrays,
    private static class DocumentBuffer implements Releasable {  
                return new WriterStats(true, metadata.indices().size(), 0);  
            }
        }  
                }
 * <p>
                this.numIndicesUpdated = numIndicesUpdated;  
            );
 * +---------------------------+-------------------------+-------------------------------------------------------------------------------+
            ensureFullStateWritten();
     * Encapsulates a single {@link IndexWriter} with its {@link Directory} for ease of closing, and a {@link Logger}. There is one of these  
            final Map<String, String> commitData = new HashMap<>(COMMIT_DATA_SIZE);
                closeables.add(directory);  
    /**  
        Path[] dataPaths,
                final boolean updateGlobalMeta = Metadata.isGlobalStateEquals(previouslyWrittenMetadata, metadata) == false;
        consumeFromType(searcher, INDEX_TYPE_NAME, bytes -> {  
                    if (buffer != bytesRef.bytes) {  
        /**
    /**
    }
                    if (nodeId != null && nodeId.equals(thisNodeId) == false) {
                    logger.debug(new ParameterizedMessage("no on-disk state at {}", indexPath), e);
                            throw new IllegalStateException(
            if (indexUUIDs.add(indexMetadata.getIndexUUID()) == false) {  
        }
import java.util.HashSet;
                    if (maxCurrentTermOnDiskState.empty() || maxCurrentTermOnDiskState.currentTerm < onDiskState.currentTerm) {
import org.opensearch.core.xcontent.MediaTypeRegistry;
        }
            return closed.get() == false;
                        "writing cluster state took [{}ms] which is above the warn threshold of [{}]; "
        void updateGlobalMetadata(Document globalMetadataDocument) throws IOException {
     */
        public final long currentTerm;
import org.opensearch.common.logging.Loggers;
        }
        }  
                }  
                    if (onDiskState.metadata.clusterUUIDCommitted()) {  
                }
        /**
                        || (acceptedTerm == maxAcceptedTerm  
                for (final IndexMetadata indexMetadata : metadata.indices().values()) {  
                final TimeValue finalSlowWriteLoggingThreshold = slowWriteLoggingThresholdSupplier.get();
                for (MetadataIndexWriter metadataIndexWriter : metadataIndexWriters) {  
import org.apache.lucene.util.Bits;
 */
        // add a data path containing a stale copy of the metadata. We deal with this by using the freshest copy we can find.
                } else {
import org.opensearch.common.settings.Setting;
                // Flush, to try and expose a failure (e.g. out of disk space) before committing, because we can handle a failure here more  
                        stats.globalMetaUpdated,  
        );
         * Update the persisted metadata to match the given cluster state by removing all existing documents and then adding new documents.
import org.opensearch.common.xcontent.LoggingDeprecationHandler;  
            throws IOException {
                        metadataIndexWriter.updateGlobalMetadata(globalMetadataDocument);  
import org.apache.lucene.search.DocIdSetIterator;
                                    + dataPath
            this.logger.trace("updating global metadata doc");
        }  
import org.apache.lucene.index.IndexWriterConfig;
                        "writing cluster state took [{}ms] which is above the warn threshold of [{}]; "
import org.apache.lucene.document.StringField;
import org.opensearch.common.util.PageCacheRecycler;
        void writeIncrementalStateAndCommit(long currentTerm, ClusterState previousClusterState, ClusterState clusterState)
                    return bytesRef;  
                final Map<String, Long> indexMetadataVersionByUUID = new HashMap<>(previouslyWrittenMetadata.indices().size());
        }
                buffer = new byte[size];
         * Overrides and commits the given current term and cluster state  
            }  
    }
import org.apache.lucene.index.IndexWriter;
        assert userData.get(CURRENT_TERM_KEY) != null;  
            success = true;  
                documentBufferUsed = documentBuffer.getMaxUsed();
                assert firstPage.bytes.length == PageCacheRecycler.PAGE_SIZE_IN_BYTES : firstPage.bytes.length;
                                + "] but expected ["  
import org.opensearch.core.xcontent.XContentBuilder;
                while (docIdSetIterator.nextDoc() != DocIdSetIterator.NO_MORE_DOCS) {
                    .createParser(namedXContentRegistry, LoggingDeprecationHandler.INSTANCE, bytes.bytes, bytes.offset, bytes.length)  
                        final Document indexMetadataDocument = makeIndexMetadataDocument(indexMetadata, documentBuffer);
 * <p>  
         * Updates and commits the given cluster state update
     */
            return indexMetadataDocument;
                    if (isLiveDoc.test(docIdSetIterator.docID())) {
                throw e;
                    }
            return this == NO_ON_DISK_STATE;
                } catch (IndexNotFoundException e) {
    /**  
    private volatile TimeValue slowWriteLoggingThreshold;  
                            "unexpected node ID in metadata, found ["
        /**
        }  
            this.indexWriter.deleteAll();
        /**
                    final Document indexMetadataDocument = makeIndexMetadataDocument(indexMetadata, documentBuffer);
 */  
        void commit(long currentTerm, long lastAcceptedVersion) throws IOException {  
                    + maxCurrentTermOnDiskState.dataPath
import org.apache.lucene.store.NIOFSDirectory;
                .map(writer -> writer.indexWriter)
        }
            this.lastAcceptedVersion = lastAcceptedVersion;  
        LongSupplier relativeTimeMillisSupplier
        boolean fullStateWritten = false;
        TimeValue.timeValueSeconds(10),  
        for (LeafReaderContext leafReaderContext : indexSearcher.getIndexReader().leaves()) {
            if (closed.compareAndSet(false, true)) {  
                IOUtils.closeWhileHandlingException(closeables);  
        }  
        public void writeIncrementalTermUpdateAndCommit(long currentTerm, long lastAcceptedVersion) throws IOException {  
                ) {  
        @Override  
                try (
    private final NamedXContentRegistry namedXContentRegistry;
 * | INDEX_TYPE_NAME  == "index"  | Index UUID                  | Index metadata                               |
                                "mismatched cluster UUIDs in metadata, found ["  
        }
            }
    /**
            this.logger.trace("removing metadata for [{}]", indexUUID);
     */
                } catch (IndexNotFoundException e) {  
        }  
    }
     * Creates a new disk-based writer for cluster states  
            if (builderReference.get() != null) {
public class PersistedClusterStateService {
            indexWriter.prepareCommit();
        }  
            }
                                    + onDiskState.metadata.clusterUUID()
                    maxUsed = Math.max(maxUsed, bytesRef.length);
        String nodeId = null;  
                    final Map<String, String> userData = reader.getIndexCommit().getUserData();  
                                    + committedClusterUuid
        OnDiskState bestOnDiskState = OnDiskState.NO_ON_DISK_STATE;  
            final Path indexPath = dataPath.resolve(METADATA_DIRECTORY_NAME);
                    long maxAcceptedTerm = bestOnDiskState.metadata.coordinationMetadata().term();  
            for (final Path path : dataPaths) {
                    } else {
                    for (MetadataIndexWriter metadataIndexWriter : metadataIndexWriters) {  
    }
import java.util.Map;  
     * @opensearch.internal  
        String nodeId,  
            try {
                        final Map<String, String> commitData = new HashMap<>(userData);  
        private WriterStats overwriteMetadata(Metadata metadata) throws IOException {  
                XContentType.SMILE.xContent()  
                final Bits liveDocs = leafReaderContext.reader().getLiveDocs();  
                                + nodeId
                    }
        // We use a write-all-read-one strategy: metadata is written to every data path when accepting it, which means it is mostly  
 * SPDX-License-Identifier: Apache-2.0
        final Query query = new TermQuery(new Term(TYPE_FIELD_NAME, type));
            this.bigArrays = bigArrays;
import org.apache.lucene.store.AlreadyClosedException;
 * this work for additional information regarding copyright
                    }
}
                for (final IndexMetadata indexMetadata : previouslyWrittenMetadata.indices().values()) {
                        logger.trace("no action required for [{}]", indexMetadata.getIndex());
        ) {
package org.opensearch.gateway;
                "inconsistent terms found: best state is from ["
                        );
                try {  
        void prepareCommit(String nodeId, long currentTerm, long lastAcceptedVersion) throws IOException {
    /**
                final long startTimeMillis = relativeTimeMillisSupplier.getAsLong();
                    }
                this.numIndicesUnchanged = numIndicesUnchanged;
                final IndexWriter indexWriter = createIndexWriter(directory, false);
                    + bestOnDiskState.dataPath  
import org.opensearch.common.util.BigArrays;  
        }
import org.opensearch.Version;
    public static void deleteAll(Path[] dataPaths) throws IOException {  
import java.util.Set;
 * specific language governing permissions and limitations
                                    + "]"
 * under the License.  
                    if (previousVersion == null || indexMetadata.getVersion() != previousVersion) {
     */
        }  
    }  
        NamedXContentRegistry namedXContentRegistry,
        String committedClusterUuid = null;
        LongSupplier relativeTimeMillisSupplier
                int numIndicesUpdated = 0;
        Path committedClusterUuidPath = null;
                }
            this.nodeId = nodeId;
            final int extraSpace = documentBufferUsed <= PageCacheRecycler.PAGE_SIZE_IN_BYTES ? 0 : PageCacheRecycler.PAGE_SIZE_IN_BYTES;
                    final BytesRef bytesRef = super.toBytesRef();
            }
                    final Document globalMetadataDocument = makeGlobalMetadataDocument(metadata, documentBuffer);
 * | CURRENT_TERM_KEY          | "current_term"          | Node's "current" term (≥ last-accepted term and the terms of all sent joins)  |  
            this.indexWriter.flush();
    public Path[] getDataPaths() {
import java.util.List;
            }  
        public boolean isOpen() {
        if (bestOnDiskState.currentTerm != maxCurrentTermOnDiskState.currentTerm) {  
                for (MetadataIndexWriter metadataIndexWriter : metadataIndexWriters) {
        this.slowWriteLoggingThreshold = slowWriteLoggingThreshold;
        public final Metadata metadata;  
                final long durationMillis = relativeTimeMillisSupplier.getAsLong() - startTimeMillis;
            }
        OnDiskState maxCurrentTermOnDiskState = bestOnDiskState;
            this.relativeTimeMillisSupplier = relativeTimeMillisSupplier;  
 *
            }
            Long.parseLong(userData.get(CURRENT_TERM_KEY)),
    // exposed for tests  
            try {  
                if (updateGlobalMeta) {  
            final boolean globalMetaUpdated;  
                try (Directory directory = createDirectory(indexPath); DirectoryReader directoryReader = DirectoryReader.open(directory)) {  
        this.slowWriteLoggingThreshold = clusterSettings.get(SLOW_WRITE_LOGGING_THRESHOLD);
                    );  
    Directory createDirectory(Path path) throws IOException {
                public BytesRef toBytesRef() {  
            final Document indexMetadataDocument = makeDocument(INDEX_TYPE_NAME, indexMetadata, documentBuffer);  
                        durationMillis,
        }
                        }
        return new NodeMetadata(nodeId, version);  
 * ownership. Elasticsearch licenses this file to you under  
                                    + "] and ["
                buffer = firstPage.bytes;
     * Returns the node metadata for the given data paths, and checks if the node ids are unique
                }
            final Path indexPath = dataPath.resolve(METADATA_DIRECTORY_NAME);
    private final BigArrays bigArrays;  
                    firstPage = iterator.next();
                    }
        private final Path dataPath;  
     *
                                || (onDiskState.lastAcceptedVersion == bestOnDiskState.lastAcceptedVersion)
                    logger.warn("failed on closing cluster state writer", e2);
                    );  
 */
        for (Path dataPath : dataPaths) {
            }
    public static void overrideVersion(Version newVersion, Path... dataPaths) throws IOException {  
        final Map<String, String> userData = reader.getIndexCommit().getUserData();  
 * Modifications Copyright OpenSearch Contributors. See  
    }  
import org.opensearch.common.bytes.RecyclingBytesStreamOutput;  
                            "unexpected node ID in metadata, found [" + thisNodeId + "] in [" + dataPath + "] but expected [" + nodeId + "]"
import java.util.ArrayList;
        private final Directory directory;  
        private Document makeDocument(String typeName, ToXContent metadata, DocumentBuffer documentBuffer) throws IOException {
                        nodeId = thisNodeId;
                try (DirectoryReader reader = DirectoryReader.open(new NIOFSDirectory(dataPath.resolve(METADATA_DIRECTORY_NAME)))) {
            this.logger.trace("flushing");  
        this.namedXContentRegistry = namedXContentRegistry;
            String nodeId,
    private static final String NODE_ID_KEY = "node_id";
 * software distributed under the License is distributed on an
                logger.error("cannot write incremental state");
        logger.trace("got global metadata, now reading index metadata");  
        FORMAT_PARAMS = new ToXContent.MapParams(params);
        }  
        final SetOnce<Metadata.Builder> builderReference = new SetOnce<>();  
                        || acceptedTerm > maxAcceptedTerm
                closeIfAnyIndexWriterHasTragedyOrIsClosed();  
                return new WriterStats(updateGlobalMeta, numIndicesUpdated, numIndicesUnchanged);
        "gateway.slow_write_logging_threshold",
            }  
         */  
     */
                    .createParser(namedXContentRegistry, LoggingDeprecationHandler.INSTANCE, bytes.bytes, bytes.offset, bytes.length)
        }
    /**  
                        );  
                    }
            } finally {
                    } else if (nodeId == null) {  
                        indexMetadata.getIndexUUID(),
            // but if we needed more than a single page last time then allow a bit more space to try and avoid needing to grow the buffer  
                    + maxCurrentTermOnDiskState.currentTerm  
     */
            if (success == false) {
                    indexMetadataVersionByUUID.remove(indexMetadata.getIndexUUID());  
        MetadataIndexWriter(Directory directory, IndexWriter indexWriter) {  
                                + "]"
                    logger.warn("failed on closing cluster state writer", e);  
            }
        }
        assert userData.get(NODE_ID_KEY) != null;
        searcher.setQueryCache(null);
 * Stores cluster metadata in a bare Lucene index (per data path) split across a number of documents. This is used by cluster-manager-eligible nodes
import org.apache.lucene.index.StoredFields;
                            && (onDiskState.lastAcceptedVersion > bestOnDiskState.lastAcceptedVersion
                                + onDiskState.nodeId  
            this.nodeId = nodeId;  
     * @param dataPaths the data paths to scan
            this.metadataIndexWriters = metadataIndexWriters;  
                            + "wrote global metadata [{}] and metadata for [{}] indices and skipped [{}] unchanged indices",
        private void ensureOpen() {
            commitData.put(CURRENT_TERM_KEY, Long.toString(currentTerm));  
        }  
    /**  
    private static final Logger logger = LogManager.getLogger(PersistedClusterStateService.class);
                final BytesRefIterator iterator = BytesReference.fromByteArray(byteArray, Math.toIntExact(byteArray.size())).iterator();
        BigArrays bigArrays,
            }
        private final String nodeId;
import java.util.function.IntPredicate;  
        try {  
import org.opensearch.common.lucene.Lucene;
            logger.trace("found global metadata with last-accepted term [{}]", metadata.coordinationMetadata().term());  
import org.opensearch.core.index.Index;
 * | "type" (string field)        | "index_uuid" (string field) | "data" (stored binary field in SMILE format) |
            this.dataPath = dataPath;
                closeables.add(indexWriter);  
                }  
            }  
        // start empty since we re-write the whole cluster state to ensure it is all using the same format version
                    );  
                    assert thisNodeId != null;
    }  
 *
        } finally {
    private static final String TYPE_FIELD_NAME = "type";
        }
        // merge on the write thread (e.g. while flushing)
        }
        public void close() throws IOException {
        Setting.Property.NodeScope,
import org.opensearch.core.common.util.ByteArray;  
        private final Logger logger;
        void updateIndexMetadataDocument(Document indexMetadataDocument, Index index) throws IOException {
    ) {
import org.opensearch.common.lease.Releasables;  
 * <p>
                final ByteArray byteArray = bigArrays.newByteArray(PageCacheRecycler.PAGE_SIZE_IN_BYTES);
                this.globalMetaUpdated = globalMetaUpdated;
                        for (MetadataIndexWriter metadataIndexWriter : metadataIndexWriters) {
                }
                    + "] with greater term ["
            Releasables.close(releasable);
                try {
 * this file be licensed under the Apache-2.0 license or a
            if (Files.exists(indexPath)) {
            Long.parseLong(userData.get(LAST_ACCEPTED_VERSION_KEY)),
        private final Supplier<TimeValue> slowWriteLoggingThresholdSupplier;
        }
import org.apache.logging.log4j.LogManager;  
            clusterSettings,
            this.bigArrays = bigArrays;
    }
        static class WriterStats {
    public static final Setting<TimeValue> SLOW_WRITE_LOGGING_THRESHOLD = Setting.timeSetting(
            ensureOpen();
    private static final String DATA_FIELD_NAME = "data";
            try (DocumentBuffer documentBuffer = allocateBuffer()) {  
                    if (nodeId.equals(onDiskState.nodeId) == false) {  
            } finally {
import org.apache.lucene.index.DirectoryReader;
        private final AtomicBoolean closed = new AtomicBoolean();
        consumeFromType(searcher, GLOBAL_TYPE_NAME, bytes -> {
import org.apache.lucene.index.Term;  
            this.logger = Loggers.getLogger(MetadataIndexWriter.class, directory.toString());  
        private void closeIfAnyIndexWriterHasTragedyOrIsClosed() {
            // later on.
                        stats.numIndicesUpdated
                        throw new IllegalStateException(  
import org.apache.lucene.search.ScoreMode;
                } catch (Exception e) {
        throws IOException {
                    logger.debug(new ParameterizedMessage("no on-disk state at {}", indexPath), e);  
            this.currentTerm = currentTerm;
        private OnDiskState(String nodeId, Path dataPath, long currentTerm, long lastAcceptedVersion, Metadata metadata) {
import java.util.function.LongSupplier;
            builderReference.set(Metadata.builder(metadata));
        private final BigArrays bigArrays;  
        final IndexSearcher searcher = new IndexSearcher(reader);  
import org.apache.lucene.search.Weight;
            commitData.put(LAST_ACCEPTED_VERSION_KEY, Long.toString(lastAcceptedVersion));
                    );  
                        }
import org.apache.logging.log4j.Logger;
                for (MetadataIndexWriter metadataIndexWriter : metadataIndexWriters) {
                } catch (Exception e2) {  
                        throw new IllegalStateException(
            }  
import org.apache.lucene.index.LeafReaderContext;  
                        metadataIndexWriter.updateIndexMetadataDocument(indexMetadataDocument, indexMetadata.getIndex());  
 * You may obtain a copy of the License at  
    private static void consumeFromType(IndexSearcher indexSearcher, String type, CheckedConsumer<BytesRef, IOException> bytesRefConsumer)
                        stats.globalMetaUpdated,  
                for (MetadataIndexWriter metadataIndexWriter : metadataIndexWriters) {
                }
                    + "] in term ["
            commitData.put(NODE_ID_KEY, nodeId);  
 * documents that have not changed. The index has the following fields:
        private Document makeGlobalMetadataDocument(Metadata metadata, DocumentBuffer documentBuffer) throws IOException {
            try {
            logger.trace("new leafReaderContext: {}", leafReaderContext);  
        }
                // gracefully than one that occurs during the commit process.
 * @opensearch.internal
import org.apache.lucene.store.Directory;  
 * +------------------------------+-----------------------------+----------------------------------------------+
            throw new IllegalStateException("no global metadata found in [" + dataPath + "]");  
        }
            if (Files.exists(indexPath)) {
        final IndexWriterConfig indexWriterConfig = new IndexWriterConfig(new KeywordAnalyzer());
        private final String nodeId;
                        logger.trace("processing doc {}", docIdSetIterator.docID());  
                } catch (Exception e2) {  
import org.opensearch.common.xcontent.XContentType;
            final Metadata metadata = Metadata.Builder.fromXContent(
            final String indexUUID = indexMetadata.getIndexUUID();
            ensureOpen();  
    }
                            metadataIndexWriter.updateIndexMetadataDocument(indexMetadataDocument, indexMetadata.getIndex());  
                fullStateWritten = true;
            document.add(new StringField(TYPE_FIELD_NAME, typeName, Field.Store.NO));
                try {
    }
 * | NODE_VERSION_KEY          | "node_version"          | The (ID of the) version of the node that wrote this metadata                  |  
        assert userData.get(LAST_ACCEPTED_VERSION_KEY) != null;
            indexWriter.setLiveCommitData(commitData.entrySet());
/*
        private WriterStats addMetadata(Metadata metadata) throws IOException {
import org.apache.lucene.util.BytesRefIterator;
        return new IndexWriter(directory, indexWriterConfig);
        public final long lastAcceptedVersion;
import org.apache.lucene.analysis.core.KeywordAnalyzer;  
                            + "wrote full state with [{}] indices",
        Version version = null;
                                    + "] in ["  
            logger.trace("closing PersistedClusterStateService.Writer");
            );
                        indexWriter.setLiveCommitData(commitData.entrySet());
    }
            indexWriter.updateDocument(new Term(INDEX_UUID_FIELD_NAME, index.getUUID()), indexMetadataDocument);
        }
                throw new IOError(e);  
                    xContentBuilder.endObject();  
        indexWriterConfig.setMergeScheduler(new SerialMergeScheduler());  
        }  
 * +------------------------------+-----------------------------+----------------------------------------------+  
                    for (MetadataIndexWriter metadataIndexWriter : metadataIndexWriters) {
 * license agreements. See the NOTICE file distributed with
    public static NodeMetadata nodeMetadata(Path... dataPaths) throws IOException {
        assert userData.size() == COMMIT_DATA_SIZE : userData;
                        finalSlowWriteLoggingThreshold,
        // only commit when specifically instructed, we must not write any intermediate states
    /**  
import java.util.concurrent.atomic.AtomicBoolean;
            }
     */
                metadataIndexWriters.add(new MetadataIndexWriter(directory, indexWriter));
        // sufficient to read _any_ copy. "Mostly" sufficient because the user can change the set of data paths when restarting, and may
import org.opensearch.common.SetOnce;
        public void close() {
                        durationMillis,
    private static class MetadataIndexWriter implements Closeable {  
    private static final String INDEX_TYPE_NAME = "index";
        }
            };
 * to record the last-accepted cluster state during publication. The metadata is written incrementally where possible, leaving alone any  
        DocumentBuffer(int size, BigArrays bigArrays) {
        // use a MMapDirectory here, which might happen with FSDirectory.open(path). Concurrency is of no concern here so a  
                } catch (IOException e) {
            return null;
            indexWriter.deleteDocuments(new Term(INDEX_UUID_FIELD_NAME, indexUUID));
                            "updating metadata for [{}], changing version from [{}] to [{}]",
 * | NODE_ID_KEY               | "node_id"               | The (persistent) ID of the node that wrote this metadata                      |
                            committedClusterUuid = onDiskState.metadata.clusterUUID();
        private Writer(
                @Override
                final WriterStats stats = updateMetadata(previousClusterState.metadata(), clusterState.metadata());
                    e.addSuppressed(e2);
        void deleteAll() throws IOException {  
    private static IndexWriter createIndexWriter(Directory directory, boolean openExisting) throws IOException {  
        indexWriterConfig.setOpenMode(openExisting ? IndexWriterConfig.OpenMode.APPEND : IndexWriterConfig.OpenMode.CREATE);  
                }
            commit(currentTerm, lastAcceptedVersion);  
        public void writeFullStateAndCommit(long currentTerm, ClusterState clusterState) throws IOException {
                }  
import org.apache.lucene.search.IndexSearcher;
            WriterStats(boolean globalMetaUpdated, long numIndicesUpdated, long numIndicesUnchanged) {
                        );
            final Path indexPath = dataPath.resolve(METADATA_DIRECTORY_NAME);  
        for (final Path dataPath : dataPaths) {  
        ClusterSettings clusterSettings,  
            try {
    private static final String CURRENT_TERM_KEY = "current_term";  
                // data on disk is now the old version or the new version, and this is a disaster. It's safest to fail the whole node and
                    }
                    try (IndexWriter indexWriter = createIndexWriter(new NIOFSDirectory(dataPath.resolve(METADATA_DIRECTORY_NAME)), true)) {
            if (scorer != null) {
        }
     * The on disk state.
            maxUsed = 0;  
    }
 * Additionally each commit has the following user data:
            nodeEnvironment.nodeDataPaths(),
 * +---------------------------+-------------------------+-------------------------------------------------------------------------------+
         */
        private final IndexWriter indexWriter;
                    assert maxUsed <= buffer.length;
            } catch (IOException e) {  
                final BytesRef firstPage;  
        }  
                }  
                        durationMillis,
