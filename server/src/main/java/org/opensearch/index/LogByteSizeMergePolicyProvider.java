    public static final Setting<Integer> INDEX_LBS_MAX_MERGED_DOCS_SETTING = Setting.intSetting(
        Setting.Property.Dynamic,
    }
        TieredMergePolicyProvider::parseNoCFSRatio,
import org.apache.logging.log4j.Logger;
    void setLBSNoCFSRatio(Double noCFSRatio) {
 * Typically, adjacent segments in time-index data often contain documents with similar timestamps.
    }
        logByteSizeMergePolicy.setMaxMergeDocs(maxMergeDocs);
    public static final Setting<ByteSizeValue> INDEX_LBS_MERGE_POLICY_MIN_MERGE_SETTING = Setting.byteSizeSetting(
 * In contrast, the TieredMergePolicy does not honor this timestamp range optimization. It focuses on merging segments
        DEFAULT_MAX_MERGED_SEGMENT, // keeping default same as tiered merge policy
        DEFAULT_MAX_MERGE_SEGMENT_FORCE_MERGE,
import org.opensearch.core.common.unit.ByteSizeValue;
    }
        Double.toString(DEFAULT_NO_CFS_RATIO),
/*
    /**
        DEFAULT_MIN_MERGE, // keeping it same as default floor segment for tiered merge policy
    public static final Setting<ByteSizeValue> INDEX_LBS_MAX_MERGE_SEGMENT_FOR_FORCED_MERGE_SETTING = Setting.byteSizeSetting(
     */
            + logByteSizeMergePolicy.getMaxMergeDocs()
        Setting.Property.IndexScope
        "index.merge.log_byte_size_policy.min_merge",
    public static final Setting<ByteSizeValue> INDEX_LBS_MAX_MERGE_SEGMENT_SETTING = Setting.byteSizeSetting(
 * SPDX-License-Identifier: Apache-2.0
        Setting.Property.IndexScope
    void setLBSMaxMergeSegment(ByteSizeValue maxMergeSegment) {
    void setLBSMergeFactor(int mergeFactor) {
    private final LogByteSizeMergePolicy logByteSizeMergePolicy = new LogByteSizeMergePolicy();
 * This characteristic makes it particularly well-suited for range queries on time-index data.
        logByteSizeMergePolicy.setMaxMergeMB(indexSettings.getValue(INDEX_LBS_MAX_MERGE_SEGMENT_SETTING).getMbFrac());
    public static final ByteSizeValue DEFAULT_MIN_MERGE = new ByteSizeValue(16, ByteSizeUnit.MB);
    public static final int DEFAULT_MERGE_FACTOR = 10;
            + logByteSizeMergePolicy.getMinMergeMB()
    );
 * <p>
        logByteSizeMergePolicy.setMaxMergeMBForForcedMerge(maxMergeForcedMerge.getMbFrac());
    private final boolean mergesEnabled;
    void setLBSMaxMergeMBForForcedMerge(ByteSizeValue maxMergeForcedMerge) {
}
 * the overlap of timestamp ranges among adjacent segments managed by TieredMergePolicy can increase.
    void setLBSMinMergedMB(ByteSizeValue minMergedSize) {
     *  Use 16MB floor size to match Lucene default.
 * The OpenSearch Contributors require contributions made to
            + ", maxMergeMBForForcedMerge="
        "index.merge.log_byte_size_policy.no_cfs_ratio",
        return "LogByteSizeMergePolicyProvider{"
            + logByteSizeMergePolicy.getMergeFactor()
        logByteSizeMergePolicy.setMergeFactor(mergeFactor);
        logByteSizeMergePolicy.setMaxMergeMB(maxMergeSegment.getMbFrac());
        Setting.Property.Dynamic,
        this.logger = logger;
        logByteSizeMergePolicy.setNoCFSRatio(noCFSRatio);
        Setting.Property.Dynamic,
        logByteSizeMergePolicy.setMergeFactor(indexSettings.getValue(INDEX_LBS_MERGE_POLICY_MERGE_FACTOR_SETTING));
            indexSettings.getValue(INDEX_LBS_MAX_MERGE_SEGMENT_FOR_FORCED_MERGE_SETTING).getMbFrac()
 * <p>
import org.opensearch.core.common.unit.ByteSizeUnit;
 * to the adjacent segments. This reduced overlap remains even as segments grow older and larger,
 *
    );
            + logByteSizeMergePolicy.getNoCFSRatio()
        2,
 *
 */
        Setting.Property.IndexScope
            + ", maxMergedDocs="
        Setting.Property.Dynamic,
 * as the default merge policy for time-index data using the <code>index.datastream_merge.policy</code> setting.
            + logByteSizeMergePolicy.getMaxMergeMBForForcedMerge()
 * this file be licensed under the Apache-2.0 license or a
    }
        Setting.Property.IndexScope
 * within a given timestamp range could become high.
 * <p>
            + '}';
        Setting.Property.Dynamic,
 *
import static org.apache.lucene.index.LogMergePolicy.DEFAULT_MAX_MERGE_DOCS;
        "index.merge.log_byte_size_policy.max_merged_docs",
    @Override
        Setting.Property.IndexScope
 * This can lead to inefficiencies in range queries on timestamps, as the number of segments to be scanned
        // Undocumented settings, works great with defaults
    public static final Setting<Double> INDEX_LBS_NO_CFS_RATIO_SETTING = new Setting<>(
            + "mergeFactor="
        this.mergesEnabled = indexSettings.getSettings().getAsBoolean(INDEX_MERGE_ENABLED, true);
package org.opensearch.index;
 * of equal sizes and does not consider adjacency. Consequently, as segments grow older and larger,
    void setLBSMaxMergeDocs(int maxMergeDocs) {
 */
    LogByteSizeMergePolicyProvider(Logger logger, IndexSettings indexSettings) {
    );
public class LogByteSizeMergePolicyProvider implements MergePolicyProvider {
import org.apache.lucene.index.NoMergePolicy;
    private final Logger logger;
import org.apache.lucene.index.LogByteSizeMergePolicy;
    }
    public static final ByteSizeValue DEFAULT_MAX_MERGE_SEGMENT_FORCE_MERGE = new ByteSizeValue(Long.MAX_VALUE);
    @Override
    public MergePolicy getMergePolicy() {
            + ", noCFSRatio="
    );
 * compatible open source license.
        );
import org.apache.lucene.index.MergePolicy;
    public String toString() {
    public static final ByteSizeValue DEFAULT_MAX_MERGED_SEGMENT = new ByteSizeValue(5, ByteSizeUnit.GB);
        Setting.Property.Dynamic,
    }
        logByteSizeMergePolicy.setMaxMergeDocs(indexSettings.getValue(INDEX_LBS_MAX_MERGED_DOCS_SETTING));
 * which can significantly benefit range queries on timestamps.
        return mergesEnabled ? logByteSizeMergePolicy : NoMergePolicy.INSTANCE;
        "index.merge.log_byte_size_policy.max_merge_segment_forced_merge",
import org.opensearch.common.settings.Setting;
     *  See <a href="https://github.com/apache/lucene/pull/14189">...</a>
        logByteSizeMergePolicy.setMaxMergeMBForForcedMerge(
            + logByteSizeMergePolicy.getMaxMergeMB()
/**
    public static final Setting<Integer> INDEX_LBS_MERGE_POLICY_MERGE_FACTOR_SETTING = Setting.intSetting(
        "index.merge.log_byte_size_policy.max_merge_segment",
 * with index with timestamps.
 * @opensearch.internal
        Setting.Property.IndexScope
            + ", maxMergeMB="
            + ", minMergeMB="
    }
 * For composite engine, we have LogByteSizeMergePolicy as the default choice while the TieredMergePolicy is the default choice for non-composite engine indexes, the LogByteSizeMergePolicy can be configured
 * specializes in merging adjacent segments efficiently.
import static org.apache.lucene.index.LogMergePolicy.DEFAULT_NO_CFS_RATIO;
        logByteSizeMergePolicy.setMinMergeMB(minMergedSize.getMbFrac());
 * The LogByteSizeMergePolicy is an alternative merge policy primarily used here to optimize the merging of segments in scenarios
 * Unlike the TieredMergePolicy, which prioritizes merging segments of equal sizes, the LogByteSizeMergePolicy
    }
 * When these segments are merged, the resulting segment covers a range of timestamps with reduced overlap compared
        "index.merge.log_byte_size_policy.merge_factor",
    );
    }
        DEFAULT_MAX_MERGE_DOCS,
        DEFAULT_MERGE_FACTOR, // keeping it same as default max merge at once for tiered merge policy
        logByteSizeMergePolicy.setNoCFSRatio(indexSettings.getValue(INDEX_LBS_NO_CFS_RATIO_SETTING));
    );
        logByteSizeMergePolicy.setMinMergeMB(indexSettings.getValue(INDEX_LBS_MERGE_POLICY_MIN_MERGE_SETTING).getMbFrac());
