                SourceFieldMapper.RECOVERY_SOURCE_NAME,
            this.engineConfig = engineConfig;
        private CombinedDeletionPolicy deletionPolicy;
            return this;
            // associatedCriteria to be attached upon creation during IndexWriter initialisation. This criteria is
            this.logger = logger;
            return new IndexWriter(directory, config);
                // to enable it.
                System.getProperty("opensearch.shuffle_forced_merge", Boolean.TRUE.toString())
                verbose = Boolean.parseBoolean(System.getProperty("tests.verbose"));
public class NativeLuceneIndexWriterFactory implements IndexWriterFactory {
    /**
        private SoftDeletesPolicy softDeletesPolicy;
            }
            return new AssertingIndexWriter(directory, config);
            .deletionPolicy(deletionPolicy)
        public IndexWriterConfigBuilder logger(Logger logger) {
            iwc.setUseCompoundFile(engineConfig.useCompoundFile());
import org.opensearch.core.Assertions;
        }
     */
        }
        public IndexWriterConfigBuilder softDeletesPolicy(SoftDeletesPolicy softDeletesPolicy) {
import org.opensearch.Version;
            boolean shuffleForcedMerge = Booleans.parseBoolean(
 */
     * Internal Asserting Index Writer
import java.util.function.UnaryOperator;
 *
import java.util.Optional;
            return this;
        public IndexWriterConfigBuilder deletionPolicy(CombinedDeletionPolicy deletionPolicy) {
            if (engineConfig.getIndexSettings().isContextAwareEnabled()) {
            // determined on a per-document basis and is only available within the InternalEngine. Therefore, the codec
                iwc.setIndexDeletionPolicy(deletionPolicy);
            }
        return createWriter(directory, config);
                // Disable merge on refresh
                    new PrunePostingsMergePolicy(mergePolicy, IdFieldMapper.NAME)
            // always configure soft-deletes field so an engine with soft-deletes disabled can open a Lucene index with soft-deletes.
            try {
        }
import org.apache.logging.log4j.Logger;
        private String associatedCriteria;
                if (maxFullFlushMergeWaitMillis > 0) {
        Directory directory,
    @Override
}
        }
            } else {
            iwc.setCheckPendingFlushUpdate(engineConfig.getIndexSettings().isCheckPendingFlushEnabled());
                    }
    @Override
                // We wrap the merge policy for all indices even though it is mostly useful for time-based indices
import org.opensearch.index.shard.OpenSearchMergePolicy;
        AssertingIndexWriter(Directory d, IndexWriterConfig conf) throws IOException {
                if (engineConfig.getIndexSettings().getIndexVersionCreated().onOrAfter(Version.V_3_2_0)) {
        } else {
            return new IndexWriterConfigBuilder();
            // background merges
            } catch (Exception ignore) {}
                mergePolicy = new ShuffleForcedMergePolicy(mergePolicy);
            throw new UnsupportedOperationException();
                    Lucene.SOFT_DELETES_FIELD,
            iwc.setRAMBufferSizeMB(engineConfig.getIndexingBufferSize().getMbFrac());
                // For child IndexWriter, we are not setting deletion policy.
package org.opensearch.index.engine;
     *
            .associatedCriteria(associatedCriteria)
        if (Assertions.ENABLED) {
            assert false : "#tryDeleteDocument is not supported. See Lucene#DirectoryReaderWithAllLiveDocs";
        }
 *
     * Factory class used to create Lucene's IndexWriter config.
        public IndexWriterConfigBuilder engineConfig(EngineConfig engineConfig) {
import org.opensearch.common.Booleans;
import org.apache.lucene.index.IndexableField;
        MergeScheduler mergeScheduler,
import org.apache.lucene.util.InfoStream;
            this.commitOnClose = commitOnClose;
                    if (mergeOnFlushPolicy.isPresent()) {
            }
        public IndexWriterConfigBuilder openMode(IndexWriterConfig.OpenMode openMode) {
                // but there should be no overhead for other type of indices so it's simpler than adding a setting
            return iwc;
import org.apache.lucene.index.IndexWriterConfig;
        }
        EngineConfig engineConfig,
        private MergeScheduler mergeScheduler;
            iwc.setSoftDeletesField(Lucene.SOFT_DELETES_FIELD);
            return this;
        String associatedCriteria
            if (engineConfig.getIndexSettings().isMergeOnFlushEnabled()) {
import org.opensearch.common.lucene.LoggerInfoStream;
    }
import org.apache.lucene.index.IndexReader;
            return this;
    public static final class IndexWriterConfigBuilder {
import org.apache.lucene.index.MergeScheduler;
                }
                    final Optional<UnaryOperator<MergePolicy>> mergeOnFlushPolicy = engineConfig.getIndexSettings().getMergeOnFlushPolicy();
    /**
            if (indexSettings.isDocumentReplication() == false
 * The OpenSearch Contributors require contributions made to
            MergePolicy mergePolicy = engineConfig.getMergePolicy();
import org.apache.lucene.index.SoftDeletesRetentionMergePolicy;
        public IndexWriterConfigBuilder commitOnClose(Boolean commitOnClose) {
        public long updateDocuments(Term delTerm, Iterable<? extends Iterable<? extends IndexableField>> docs) {
            if (deletionPolicy != null) {
            this.deletionPolicy = deletionPolicy;
                )
                    iwc.setMaxFullFlushMergeWaitMillis(maxFullFlushMergeWaitMillis);
            );
            if (engineConfig.getIndexSort() != null) {
        SoftDeletesPolicy softDeletesPolicy,
 * Factory class used to create Lucene's IndexWriter.
import org.apache.lucene.index.Term;
        Logger logger,
                && (indexSettings.isSegRepLocalEnabled() || indexSettings.isRemoteStoreEnabled())) {
            .openMode(openMode)
                        mergePolicy = mergeOnFlushPolicy.get().apply(mergePolicy);
            .logger(logger)
        }
            iwc.setMergeScheduler(mergeScheduler);
import org.opensearch.index.mapper.IdFieldMapper;
            iwc.setInfoStream(verbose ? InfoStream.getDefault() : new LoggerInfoStream(logger));
            }
    }
import org.apache.lucene.index.IndexWriter;
            if (engineConfig.getLeafSorter() != null) {
                iwc.setIndexSort(engineConfig.getIndexSort());
            .softDeletesPolicy(softDeletesPolicy)
            return this;
        public IndexWriterConfigBuilder mergeScheduler(MergeScheduler mergeScheduler) {
        public IndexWriterConfig buildIndexWriterConfig() {
        }
        private IndexWriterConfigBuilder() {}
/**
import java.io.IOException;
            // Give us the opportunity to upgrade old segments while performing
            this.softDeletesPolicy = softDeletesPolicy;
 * compatible open source license.
    public IndexWriter createWriter(Directory directory, IndexWriterConfig config) throws IOException {
    }
 */
                    iwc.setParentField(Lucene.PARENT_FIELD);
 * this file be licensed under the Apache-2.0 license or a
        @Override
import org.opensearch.index.codec.CriteriaBasedCodec;
import org.opensearch.index.mapper.SourceFieldMapper;
    private static class AssertingIndexWriter extends IndexWriter {
                iwc.setMergedSegmentWarmer(engineConfig.getIndexReaderWarmer());
            .mergeScheduler(mergeScheduler)
        public long tryDeleteDocument(IndexReader readerIn, int docID) {
        CombinedDeletionPolicy deletionPolicy,
            if (openMode == IndexWriterConfig.OpenMode.CREATE) {
            return this;
            }
                new SoftDeletesRetentionMergePolicy(
        }
            iwc.setSimilarity(engineConfig.getSimilarity());
import org.opensearch.index.IndexSettings;
                }
     *
import org.opensearch.common.lucene.Lucene;
        }
            iwc.setOpenMode(openMode);
            this.openMode = openMode;
            if (shuffleForcedMerge) {
            }
        private Boolean commitOnClose;
        private EngineConfig engineConfig;
            boolean verbose = false;
            super(d, conf);
                iwc.setMaxFullFlushMergeWaitMillis(0);
                iwc.setCodec(new CriteriaBasedCodec(engineConfig.getCodec(), associatedCriteria));
            iwc.setMergePolicy(new OpenSearchMergePolicy(mergePolicy));
                iwc.setCodec(engineConfig.getCodec());
    ) throws IOException {
                iwc.setLeafSorter(engineConfig.getLeafSorter()); // The default segment search order
    }
            this.mergeScheduler = mergeScheduler;
            } else {
            // We are setting the codec here rather than in the CodecService because each CriteriaBasedCodec requires
        public static IndexWriterConfigBuilder builder() {
            .buildIndexWriterConfig();
            this.associatedCriteria = associatedCriteria;
            // with tests.verbose, lucene sets this up: plumb to align with filesystem stream
            .engineConfig(engineConfig)
        IndexWriterConfig.OpenMode openMode,
            }
            .commitOnClose(commitOnClose)
        public IndexWriterConfigBuilder associatedCriteria(String associatedCriteria) {
            iwc.setCommitOnClose(commitOnClose);
                iwc.setIndexCreatedVersionMajor(engineConfig.getIndexSettings().getIndexVersionCreated().luceneVersion.major);
            IndexSettings indexSettings = engineConfig.getIndexSettings();
        }
/*
        IndexWriterConfig config = IndexWriterConfigBuilder.builder()
        }
        }
    public IndexWriter createWriter(
                    softDeletesPolicy::getRetentionQuery,
        Boolean commitOnClose,
                assert null != engineConfig.getIndexReaderWarmer();
        }
import org.apache.lucene.store.Directory;
            final IndexWriterConfig iwc = new IndexWriterConfig(engineConfig.getAnalyzer());
            }
                softDeletesPolicy::getRetentionQuery,
        private IndexWriterConfig.OpenMode openMode;
            return this;
        @Override
            throw new AssertionError("must not hard update documents");
        private Logger logger;
import org.apache.lucene.index.MergePolicy;
            mergePolicy = new RecoverySourcePruneMergePolicy(
            return this;
            // for the child writer is created here where the necessary criteria information is accessible
                final long maxFullFlushMergeWaitMillis = engineConfig.getIndexSettings().getMaxFullFlushMergeWaitTime().millis();
     */
     * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
            );
