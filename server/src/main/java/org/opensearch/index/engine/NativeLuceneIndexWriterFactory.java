                iwc.setMergedSegmentWarmer(engineConfig.getIndexReaderWarmer());
        }
package org.opensearch.index.engine;
        public long tryDeleteDocument(IndexReader readerIn, int docID) {  
            throw new AssertionError("must not hard update documents");
            // background merges
            .engineConfig(engineConfig)  
            if (indexSettings.isDocumentReplication() == false
            }  
            .buildIndexWriterConfig();  
            return new IndexWriterConfigBuilder();
            if (engineConfig.getIndexSettings().isMergeOnFlushEnabled()) {  
            iwc.setUseCompoundFile(engineConfig.useCompoundFile());  
     * Internal Asserting Index Writer  
        IndexWriterConfig.OpenMode openMode,
        }
        }
import org.apache.lucene.index.Term;  
                new SoftDeletesRetentionMergePolicy(  
        private SoftDeletesPolicy softDeletesPolicy;
        AssertingIndexWriter(Directory d, IndexWriterConfig conf) throws IOException {
    public static final class IndexWriterConfigBuilder {  
    /**
import org.apache.lucene.index.IndexWriter;  
import org.opensearch.Version;  
            iwc.setSoftDeletesField(Lucene.SOFT_DELETES_FIELD);
                    }
                    softDeletesPolicy::getRetentionQuery,
    public IndexWriter createWriter(
            }
                // Disable merge on refresh
import org.apache.lucene.index.MergeScheduler;
    /**
                final long maxFullFlushMergeWaitMillis = engineConfig.getIndexSettings().getMaxFullFlushMergeWaitTime().millis();
            iwc.setCommitOnClose(commitOnClose);
            this.engineConfig = engineConfig;  
            this.openMode = openMode;  
            .mergeScheduler(mergeScheduler)
import org.apache.logging.log4j.Logger;
            // for the child writer is created here where the necessary criteria information is accessible
            boolean verbose = false;
            return this;
        public IndexWriterConfigBuilder mergeScheduler(MergeScheduler mergeScheduler) {
            return this;
            .logger(logger)
                // We wrap the merge policy for all indices even though it is mostly useful for time-based indices
        public IndexWriterConfig buildIndexWriterConfig() {
import org.opensearch.common.lucene.Lucene;  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
     */  
        public IndexWriterConfigBuilder engineConfig(EngineConfig engineConfig) {
        public IndexWriterConfigBuilder softDeletesPolicy(SoftDeletesPolicy softDeletesPolicy) {  
            .deletionPolicy(deletionPolicy)
    }  
     * Factory class used to create Lucene's IndexWriter config.  
            } else {
import org.apache.lucene.index.SoftDeletesRetentionMergePolicy;
            if (engineConfig.getIndexSettings().isContextAwareEnabled()) {  
                iwc.setMaxFullFlushMergeWaitMillis(0);
import java.util.function.UnaryOperator;
import org.opensearch.index.shard.OpenSearchMergePolicy;  
        }
        String associatedCriteria
                iwc.setLeafSorter(engineConfig.getLeafSorter()); // The default segment search order
            if (engineConfig.getLeafSorter() != null) {
public class NativeLuceneIndexWriterFactory implements IndexWriterFactory {
            // always configure soft-deletes field so an engine with soft-deletes disabled can open a Lucene index with soft-deletes.
    public IndexWriter createWriter(Directory directory, IndexWriterConfig config) throws IOException {
 */  
                // to enable it.  
            if (deletionPolicy != null) {
                iwc.setIndexSort(engineConfig.getIndexSort());
            assert false : "#tryDeleteDocument is not supported. See Lucene#DirectoryReaderWithAllLiveDocs";
            }  
            .associatedCriteria(associatedCriteria)
                        mergePolicy = mergeOnFlushPolicy.get().apply(mergePolicy);  
import org.apache.lucene.index.IndexableField;
            return this;  
        }  
            return new IndexWriter(directory, config);
 * SPDX-License-Identifier: Apache-2.0
 *
        Logger logger,  
    }
            }
        Boolean commitOnClose,
                // but there should be no overhead for other type of indices so it's simpler than adding a setting
import org.opensearch.index.mapper.SourceFieldMapper;
                verbose = Boolean.parseBoolean(System.getProperty("tests.verbose"));  
        public IndexWriterConfigBuilder commitOnClose(Boolean commitOnClose) {  
import org.opensearch.index.IndexSettings;
    ) throws IOException {
            final IndexWriterConfig iwc = new IndexWriterConfig(engineConfig.getAnalyzer());  
        }
        private IndexWriterConfigBuilder() {}
        if (Assertions.ENABLED) {
     *
            // determined on a per-document basis and is only available within the InternalEngine. Therefore, the codec
                iwc.setIndexDeletionPolicy(deletionPolicy);  
        IndexWriterConfig config = IndexWriterConfigBuilder.builder()  
            super(d, conf);  
            // Give us the opportunity to upgrade old segments while performing
        }  
                SourceFieldMapper.RECOVERY_SOURCE_NAME,
import org.apache.lucene.index.IndexReader;
            // associatedCriteria to be attached upon creation during IndexWriter initialisation. This criteria is  
                mergePolicy = new ShuffleForcedMergePolicy(mergePolicy);
            );
}
import org.apache.lucene.index.IndexWriterConfig;
            MergePolicy mergePolicy = engineConfig.getMergePolicy();  
     */
            );
            this.logger = logger;
            iwc.setMergeScheduler(mergeScheduler);  
                }
import java.io.IOException;
        public IndexWriterConfigBuilder logger(Logger logger) {
        private MergeScheduler mergeScheduler;
        Directory directory,
            if (engineConfig.getIndexSort() != null) {
        public long updateDocuments(Term delTerm, Iterable<? extends Iterable<? extends IndexableField>> docs) {
import org.opensearch.index.mapper.IdFieldMapper;
        }
     *
            this.associatedCriteria = associatedCriteria;
            throw new UnsupportedOperationException();
                // For child IndexWriter, we are not setting deletion policy.
                iwc.setIndexCreatedVersionMajor(engineConfig.getIndexSettings().getIndexVersionCreated().luceneVersion.major);
    @Override  
        }  
            if (shuffleForcedMerge) {  
import java.util.Optional;  
        }
                && (indexSettings.isSegRepLocalEnabled() || indexSettings.isRemoteStoreEnabled())) {  
        private CombinedDeletionPolicy deletionPolicy;
        public IndexWriterConfigBuilder openMode(IndexWriterConfig.OpenMode openMode) {
        @Override  
        private IndexWriterConfig.OpenMode openMode;  
        }  
            iwc.setInfoStream(verbose ? InfoStream.getDefault() : new LoggerInfoStream(logger));
        } else {
            } else {  
        public IndexWriterConfigBuilder deletionPolicy(CombinedDeletionPolicy deletionPolicy) {
                    new PrunePostingsMergePolicy(mergePolicy, IdFieldMapper.NAME)  
                    iwc.setMaxFullFlushMergeWaitMillis(maxFullFlushMergeWaitMillis);  
        private EngineConfig engineConfig;  
            }  
        public static IndexWriterConfigBuilder builder() {  
                if (maxFullFlushMergeWaitMillis > 0) {
                iwc.setCodec(engineConfig.getCodec());  
            this.commitOnClose = commitOnClose;
            iwc.setCheckPendingFlushUpdate(engineConfig.getIndexSettings().isCheckPendingFlushEnabled());
 *
            mergePolicy = new RecoverySourcePruneMergePolicy(  
        @Override
    }
            return this;
                }
        private Logger logger;
        SoftDeletesPolicy softDeletesPolicy,
                    final Optional<UnaryOperator<MergePolicy>> mergeOnFlushPolicy = engineConfig.getIndexSettings().getMergeOnFlushPolicy();
            return this;
    private static class AssertingIndexWriter extends IndexWriter {
        return createWriter(directory, config);
            .softDeletesPolicy(softDeletesPolicy)
            IndexSettings indexSettings = engineConfig.getIndexSettings();
        EngineConfig engineConfig,
            .openMode(openMode)  
        }  
import org.opensearch.index.codec.CriteriaBasedCodec;  
 */  
import org.opensearch.common.Booleans;
        }
            iwc.setOpenMode(openMode);
            boolean shuffleForcedMerge = Booleans.parseBoolean(  
import org.apache.lucene.index.MergePolicy;  
                )
            iwc.setMergePolicy(new OpenSearchMergePolicy(mergePolicy));
                    if (mergeOnFlushPolicy.isPresent()) {
            return this;  
 * compatible open source license.
            this.deletionPolicy = deletionPolicy;
            iwc.setSimilarity(engineConfig.getSimilarity());  
            }
import org.apache.lucene.util.InfoStream;
            } catch (Exception ignore) {}
            return iwc;
                softDeletesPolicy::getRetentionQuery,
     * @opensearch.internal
            return new AssertingIndexWriter(directory, config);  
        private Boolean commitOnClose;
            return this;
            iwc.setRAMBufferSizeMB(engineConfig.getIndexingBufferSize().getMbFrac());
        private String associatedCriteria;
        public IndexWriterConfigBuilder associatedCriteria(String associatedCriteria) {  
        MergeScheduler mergeScheduler,  
/*  
            this.softDeletesPolicy = softDeletesPolicy;
        }  
                    iwc.setParentField(Lucene.PARENT_FIELD);
                System.getProperty("opensearch.shuffle_forced_merge", Boolean.TRUE.toString())
            if (openMode == IndexWriterConfig.OpenMode.CREATE) {  
            this.mergeScheduler = mergeScheduler;
            // We are setting the codec here rather than in the CodecService because each CriteriaBasedCodec requires
            }
            }  
/**  
        CombinedDeletionPolicy deletionPolicy,  
            return this;  
            try {
import org.opensearch.common.lucene.LoggerInfoStream;
            // with tests.verbose, lucene sets this up: plumb to align with filesystem stream  
import org.apache.lucene.store.Directory;
                if (engineConfig.getIndexSettings().getIndexVersionCreated().onOrAfter(Version.V_3_2_0)) {  
    }  
import org.opensearch.core.Assertions;
                    Lucene.SOFT_DELETES_FIELD,
 * Factory class used to create Lucene's IndexWriter.
    @Override  
            .commitOnClose(commitOnClose)
                iwc.setCodec(new CriteriaBasedCodec(engineConfig.getCodec(), associatedCriteria));
                assert null != engineConfig.getIndexReaderWarmer();
