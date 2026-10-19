            @Override
                                        translogConfig,
     */
                return null;
 * required in order to have an engine. All attempts to do something (search,
        final List<IndexCommit> indexCommits = DirectoryReader.listCommits(directory);
        };
 *
                            final Map<String, String> commitUserData = getLastCommittedSegmentInfos().getUserData();
import java.util.Map;
                /**
            }
        final IndexCommit indexCommit = indexCommits.get(indexCommits.size() - 1);
                                        translogDeletionPolicy,
            throw new RuntimeException(ex);
        Directory directory = store.directory();
            @Override
            }
            @Override
                return null;
 *
                                Translog translog = engineConfig.getTranslogFactory()
import java.util.function.Function;
 * @opensearch.internal
                SegmentReader segmentReader = Lucene.segmentReader(ctx.reader());
        return new DirectoryReader(directory, new LeafReader[0], null) {
                return null;
                            e.addSuppressed(inner);
            }
 */
import java.util.concurrent.ExecutorService;
        this.segmentsStats = new SegmentsStats();
                stats.clearFileSizes();
import org.opensearch.index.shard.DocsStats;
import org.opensearch.index.translog.TranslogOperationHelper;
}
            return super.segmentsStats(includeSegmentFileSizes, includeUnloadedSegments);
                    store.incRef();
                    }
    public SegmentsStats segmentsStats(boolean includeSegmentFileSizes, boolean includeUnloadedSegments) {
    }
                            final long localCheckpoint = Long.parseLong(commitUserData.get(SequenceNumbers.LOCAL_CHECKPOINT_KEY));
                            failEngine("translog trimming failed", e);
                        final List<IndexCommit> commits = DirectoryReader.listCommits(store.directory());
            protected DirectoryReader doOpenIfChanged(ExecutorService executorService) {
                fillSegmentStats(segmentReader, true, segmentsStats);
    /**
 * ownership. Elasticsearch licenses this file to you under
                        } catch (Exception inner) {
        }
                                        translogUuid,
 * specific language governing permissions and limitations
import org.apache.lucene.index.IndexWriter;
                return 0;
    }
                }
import java.io.IOException;
            public IndexCommit getIndexCommit() {
                                        engineConfig.getPrimaryTermSupplier(),
            @Override
            if (includeSegmentFileSizes == false) {
                                        + " current gen "
            final SegmentsStats stats = new SegmentsStats();
        }
    @Override
            protected DirectoryReader doOpenIfChanged() {
 * allows to trim any existing translog files through the usage of the
                        store.decRef();
                    } catch (final Exception e) {
        try {
import org.apache.lucene.index.LeafReaderContext;
                            if (translogUuid == null) {
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
            throw new UncheckedIOException(e);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            @Override
 */
                        try {
            @Override
                @Override
            public boolean isCurrent() {
                                        TranslogOperationHelper.create(engineConfig)
                 * that retains nothing but the last translog generation from safe commit.
            protected DirectoryReader doOpenIfChanged(IndexWriter writer, boolean applyAllDeletes, ExecutorService executorService) {
 * this work for additional information regarding copyright
                                // being trimmed and leading to current generation being higher than the min file generation.
                 */
import org.apache.lucene.index.DirectoryReader;
                return null;
                        ensureOpen();
import org.apache.lucene.index.LeafReader;
import org.opensearch.index.translog.TranslogConfig;
    @Override
import org.apache.lucene.index.SegmentReader;
                        }
                                        engineConfig.getGlobalCheckpointSupplier(),
                public void trimUnreferencedTranslogFiles() throws TranslogException {
            }
            }
        super(config, null, null, true, Function.identity(), true);
                            }
        } else {
    }
/*
                @Override
                                        engineConfig.getStartedPrimarySupplier(),
                                        seqNo -> {},
 * SPDX-License-Identifier: Apache-2.0
            @Override
 * software distributed under the License is distributed on an
            for (LeafReaderContext ctx : reader.getContext().leaves()) {
 * license agreements. See the NOTICE file distributed with
                            final TranslogConfig translogConfig = engineConfig.getTranslogConfig();
                                assert engineConfig.getIndexSettings().isRemoteTranslogStoreEnabled()
                                // lastRefreshedCheckpoint SeqNo - refer RemoteStoreRefreshListener. This leads to older generations not
     * that retains nothing but the last translog generation from safe commit.
     * This implementation will trim existing translog files using a {@link TranslogDeletionPolicy}
                            translogDeletionPolicy.setLocalCheckpointOfSafeCommit(localCheckpoint);
                    } finally {
                                    || translog.currentFileGeneration() == translog.getMinFileGeneration() : "translog was not trimmed "
            }
 *
            protected DirectoryReader doOpenIfChanged(IndexCommit commit) {
import org.opensearch.index.translog.NoOpTranslogManager;
    }
                                    .newTranslog(
                            }
                 * This implementation will trim existing translog files using a {@link TranslogDeletionPolicy}
import org.opensearch.index.translog.Translog;
            }
            }
                            ) {
public final class NoOpEngine extends ReadOnlyEngine {
        } catch (IOException ex) {
            @Override
                return null;
 * You may obtain a copy of the License at
                        throw new EngineException(shardId, "failed to trim translog", e);
 * {{@link TranslogManager#trimUnreferencedTranslogFiles()}} method.
            stats.add(this.segmentsStats);
        if (includeUnloadedSegments) {
        }
                                        + " != min gen "
            this.docsStats = docsStats(reader);
 * not use this file except in compliance with the License.
/*
import org.apache.lucene.index.IndexCommit;
import org.opensearch.index.translog.TranslogException;
                                translog.trimUnreferencedReaders();
                                        + translog.getMinFileGeneration();
import java.io.UncheckedIOException;
        return docsStats;
        } catch (IOException e) {
                    final Store store = engineConfig.getStore();
import org.opensearch.index.translog.TranslogDeletionPolicy;
                                translogStats = translog.stats();
    private final SegmentsStats segmentsStats;
import org.opensearch.common.util.concurrent.ReleasableLock;
                        if (commits.size() == 1 && translogStats.getTranslogSizeInBytes() > translogStats.getUncommittedSizeInBytes()) {
 * under the License.
import org.opensearch.index.seqno.SequenceNumbers;
    public NoOpEngine(EngineConfig config) {
        final Directory directory = commit.getDirectory();
            }
    private final DocsStats docsStats;
            public long getVersion() {
 */
            protected DirectoryReader doOpenIfChanged(IndexWriter writer, boolean applyAllDeletes) {
            }
                        }
 * The OpenSearch Contributors require contributions made to
            @Override
                                        + translog.currentFileGeneration()
 */
                return null;
 *
            public CacheHelper getReaderCacheHelper() {
 * index, get), throw {@link UnsupportedOperationException}. However, NoOpEngine
    }
import org.opensearch.index.translog.TranslogManager;
                return true;
import org.opensearch.common.lucene.Lucene;
        try (DirectoryReader reader = openDirectory(directory, config.getIndexSettings().isSoftDeleteEnabled(), config.getLeafSorter())) {
                    try (ReleasableLock ignored = writeLock.acquire()) {
    public TranslogManager translogManager() {
import org.opensearch.index.translog.DefaultTranslogDeletionPolicy;
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.store.Directory;
                return null;
 * Licensed to Elasticsearch under one or more contributor
            };
import static org.opensearch.index.translog.Translog.EMPTY_TRANSLOG_SNAPSHOT;
            return new NoOpTranslogManager(shardId, readLock, this::ensureOpen, this.translogStats, EMPTY_TRANSLOG_SNAPSHOT) {
            return stats;
            protected DirectoryReader doOpenIfChanged(IndexCommit commit, ExecutorService executorService) {
    protected DirectoryReader open(final IndexCommit commit) throws IOException {
 * Unless required by applicable law or agreed to in writing,
                public void setMinSeqNoToKeep(long seqNo) {}
                                    )
 * NoOpEngine is an engine implementation that does nothing but the bare minimum
                            final String translogUuid = commitUserData.get(Translog.TRANSLOG_UUID_KEY);
                return indexCommit;
 * KIND, either express or implied.  See the License for the
import java.util.List;
            }
package org.opensearch.index.engine;
                            final TranslogDeletionPolicy translogDeletionPolicy = new DefaultTranslogDeletionPolicy(-1, -1, 0);
                                // refresh the translog stats
/**
                                throw new IllegalStateException("commit doesn't contain translog unique id");
            @Override
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
            @Override
    public DocsStats docStats() {
import org.opensearch.index.store.Store;
 * compatible open source license.
/*
            protected void doClose() {}
                                // When remote translog is enabled, the min file generation is dependent on the (N-1)
    @Override
                            try (
