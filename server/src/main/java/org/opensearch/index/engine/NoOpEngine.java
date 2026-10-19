                        final List<IndexCommit> commits = DirectoryReader.listCommits(store.directory());
            }
                            ) {  
                    } finally {
        this.segmentsStats = new SegmentsStats();
import org.opensearch.common.util.concurrent.ReleasableLock;  
 * not use this file except in compliance with the License.
/*  
import java.util.function.Function;  
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.translog.DefaultTranslogDeletionPolicy;
                return 0;
                                assert engineConfig.getIndexSettings().isRemoteTranslogStoreEnabled()
        super(config, null, null, true, Function.identity(), true);
                 * that retains nothing but the last translog generation from safe commit.
    @Override  
    }  
 */  
 * NoOpEngine is an engine implementation that does nothing but the bare minimum
                                        engineConfig.getGlobalCheckpointSupplier(),  
                /**  
        try (DirectoryReader reader = openDirectory(directory, config.getIndexSettings().isSoftDeleteEnabled(), config.getLeafSorter())) {
            public boolean isCurrent() {  
                return true;
                        } catch (Exception inner) {  
                                        + " != min gen "
 * {{@link TranslogManager#trimUnreferencedTranslogFiles()}} method.  
        final IndexCommit indexCommit = indexCommits.get(indexCommits.size() - 1);
            @Override  
                            }
        };
                            translogDeletionPolicy.setLocalCheckpointOfSafeCommit(localCheckpoint);
            @Override  
        final Directory directory = commit.getDirectory();
            protected DirectoryReader doOpenIfChanged(IndexCommit commit, ExecutorService executorService) {
 * license agreements. See the NOTICE file distributed with
                return null;  
            public IndexCommit getIndexCommit() {
    public TranslogManager translogManager() {  
            }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected DirectoryReader open(final IndexCommit commit) throws IOException {
                            final TranslogConfig translogConfig = engineConfig.getTranslogConfig();
import org.apache.lucene.index.IndexCommit;
 * compatible open source license.
            protected DirectoryReader doOpenIfChanged() {
import static org.opensearch.index.translog.Translog.EMPTY_TRANSLOG_SNAPSHOT;
                }
        }  
            }
                        if (commits.size() == 1 && translogStats.getTranslogSizeInBytes() > translogStats.getUncommittedSizeInBytes()) {
        final List<IndexCommit> indexCommits = DirectoryReader.listCommits(directory);  
            throw new RuntimeException(ex);
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
                        store.decRef();
            }
            @Override  
            protected DirectoryReader doOpenIfChanged(IndexWriter writer, boolean applyAllDeletes, ExecutorService executorService) {
                    } catch (final Exception e) {  
     * This implementation will trim existing translog files using a {@link TranslogDeletionPolicy}  
 * Licensed to Elasticsearch under one or more contributor  
            protected DirectoryReader doOpenIfChanged(IndexWriter writer, boolean applyAllDeletes) {  
}
            }  
    private final DocsStats docsStats;
    /**
        try {
            }  
            if (includeSegmentFileSizes == false) {  
            return stats;  
                 * This implementation will trim existing translog files using a {@link TranslogDeletionPolicy}
                                        + translog.currentFileGeneration()
            }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.translog.TranslogConfig;
                return null;
                                        + " current gen "  
 * GitHub history for details.
                    store.incRef();
     */
 * under the License.  
/**
import org.apache.lucene.index.SegmentReader;  
        }  
                            failEngine("translog trimming failed", e);
import org.opensearch.index.translog.TranslogDeletionPolicy;
import org.opensearch.index.translog.TranslogManager;
            }
                            }
                                throw new IllegalStateException("commit doesn't contain translog unique id");  
                                Translog translog = engineConfig.getTranslogFactory()
 * index, get), throw {@link UnsupportedOperationException}. However, NoOpEngine
                                    .newTranslog(
 *
            public CacheHelper getReaderCacheHelper() {
                        throw new EngineException(shardId, "failed to trim translog", e);  
            @Override  
                @Override  
                            final Map<String, String> commitUserData = getLastCommittedSegmentInfos().getUserData();  
 * allows to trim any existing translog files through the usage of the
import java.io.IOException;
     * that retains nothing but the last translog generation from safe commit.
 * the Apache License, Version 2.0 (the "License"); you may
        }
                return null;
 * The OpenSearch Contributors require contributions made to  
        } catch (IOException e) {
 * Unless required by applicable law or agreed to in writing,
                                        translogDeletionPolicy,
            return new NoOpTranslogManager(shardId, readLock, this::ensureOpen, this.translogStats, EMPTY_TRANSLOG_SNAPSHOT) {
import org.opensearch.index.translog.TranslogOperationHelper;
                    try (ReleasableLock ignored = writeLock.acquire()) {
public final class NoOpEngine extends ReadOnlyEngine {
 * You may obtain a copy of the License at  
    @Override
    public DocsStats docStats() {
    public NoOpEngine(EngineConfig config) {  
 */  
                                        seqNo -> {},
            public long getVersion() {
            @Override  
                                        translogUuid,
        } else {
import org.opensearch.index.translog.TranslogException;  
                        try {
                            final long localCheckpoint = Long.parseLong(commitUserData.get(SequenceNumbers.LOCAL_CHECKPOINT_KEY));  
                            try (  
import org.apache.lucene.index.LeafReader;
            @Override
 * software distributed under the License is distributed on an
 * required in order to have an engine. All attempts to do something (search,  
                            if (translogUuid == null) {
import org.apache.lucene.store.Directory;
        return new DirectoryReader(directory, new LeafReader[0], null) {
                fillSegmentStats(segmentReader, true, segmentsStats);
            }
                                // being trimmed and leading to current generation being higher than the min file generation.  
                    }  
 */  
                return null;  
            @Override
                                        translogConfig,  
import org.apache.lucene.index.IndexWriter;  
                                translog.trimUnreferencedReaders();
                stats.clearFileSizes();
                                    || translog.currentFileGeneration() == translog.getMinFileGeneration() : "translog was not trimmed "
/*
import java.util.Map;
            @Override
            throw new UncheckedIOException(e);
import org.opensearch.index.translog.NoOpTranslogManager;
        Directory directory = store.directory();  
 * this file be licensed under the Apache-2.0 license or a
                                // lastRefreshedCheckpoint SeqNo - refer RemoteStoreRefreshListener. This leads to older generations not
 * this work for additional information regarding copyright
        return docsStats;
import org.apache.lucene.index.LeafReaderContext;
import java.io.UncheckedIOException;
                                        + translog.getMinFileGeneration();  
                        }
import java.util.List;  
    }  
                                        engineConfig.getStartedPrimarySupplier(),  
    @Override  
                @Override
 * Modifications Copyright OpenSearch Contributors. See
                 */  
            }
            protected void doClose() {}
 * @opensearch.internal
import org.opensearch.index.shard.DocsStats;
        } catch (IOException ex) {  
                return null;
            protected DirectoryReader doOpenIfChanged(ExecutorService executorService) {  
                                // refresh the translog stats
                        }
    }
 *
            this.docsStats = docsStats(reader);  
import org.opensearch.index.store.Store;  
            stats.add(this.segmentsStats);
                                    )
package org.opensearch.index.engine;
            @Override
                return indexCommit;  
 * ownership. Elasticsearch licenses this file to you under  
                                        engineConfig.getPrimaryTermSupplier(),
    private final SegmentsStats segmentsStats;  
import org.apache.lucene.index.DirectoryReader;
                                // When remote translog is enabled, the min file generation is dependent on the (N-1)
import org.opensearch.index.translog.Translog;  
    }
            }  
 * specific language governing permissions and limitations
            final SegmentsStats stats = new SegmentsStats();
    public SegmentsStats segmentsStats(boolean includeSegmentFileSizes, boolean includeUnloadedSegments) {
            @Override
                            e.addSuppressed(inner);
            @Override
    }
 */
 *
            }
                        ensureOpen();  
                return null;
                                        TranslogOperationHelper.create(engineConfig)
                return null;
                            final String translogUuid = commitUserData.get(Translog.TRANSLOG_UUID_KEY);
            };
 *  
import org.opensearch.index.seqno.SequenceNumbers;
import java.util.concurrent.ExecutorService;
                            final TranslogDeletionPolicy translogDeletionPolicy = new DefaultTranslogDeletionPolicy(-1, -1, 0);
                    final Store store = engineConfig.getStore();  
                SegmentReader segmentReader = Lucene.segmentReader(ctx.reader());  
        if (includeUnloadedSegments) {  
import org.opensearch.common.lucene.Lucene;
            protected DirectoryReader doOpenIfChanged(IndexCommit commit) {
                                translogStats = translog.stats();  
            for (LeafReaderContext ctx : reader.getContext().leaves()) {
            return super.segmentsStats(includeSegmentFileSizes, includeUnloadedSegments);
                public void trimUnreferencedTranslogFiles() throws TranslogException {
                public void setMinSeqNoToKeep(long seqNo) {}
