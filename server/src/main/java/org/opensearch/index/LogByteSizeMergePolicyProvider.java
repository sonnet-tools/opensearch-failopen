    }
        logByteSizeMergePolicy.setMinMergeMB(minMergedSize.getMbFrac());  
        TieredMergePolicyProvider::parseNoCFSRatio,
            + logByteSizeMergePolicy.getMaxMergeMBForForcedMerge()
import org.apache.lucene.index.LogByteSizeMergePolicy;
 * the overlap of timestamp ranges among adjacent segments managed by TieredMergePolicy can increase.  
 * <p>  
        "index.merge.log_byte_size_policy.no_cfs_ratio",  
        Setting.Property.Dynamic,  
            + ", minMergeMB="
 * compatible open source license.
 * Unlike the TieredMergePolicy, which prioritizes merging segments of equal sizes, the LogByteSizeMergePolicy
 * For composite engine, we have LogByteSizeMergePolicy as the default choice while the TieredMergePolicy is the default choice for non-composite engine indexes, the LogByteSizeMergePolicy can be configured
/*  
        "index.merge.log_byte_size_policy.min_merge",
 * This characteristic makes it particularly well-suited for range queries on time-index data.  
 *
        DEFAULT_MAX_MERGE_DOCS,  
 * This can lead to inefficiencies in range queries on timestamps, as the number of segments to be scanned
 * within a given timestamp range could become high.
    void setLBSNoCFSRatio(Double noCFSRatio) {
    public static final ByteSizeValue DEFAULT_MAX_MERGE_SEGMENT_FORCE_MERGE = new ByteSizeValue(Long.MAX_VALUE);  
 * of equal sizes and does not consider adjacency. Consequently, as segments grow older and larger,
    void setLBSMergeFactor(int mergeFactor) {  
        "index.merge.log_byte_size_policy.max_merge_segment_forced_merge",
 * with index with timestamps.  
        2,
        Setting.Property.Dynamic,
public class LogByteSizeMergePolicyProvider implements MergePolicyProvider {  
        DEFAULT_MERGE_FACTOR, // keeping it same as default max merge at once for tiered merge policy
 * The OpenSearch Contributors require contributions made to  
    );
    LogByteSizeMergePolicyProvider(Logger logger, IndexSettings indexSettings) {
            + ", maxMergeMB="
    }  
        DEFAULT_MAX_MERGED_SEGMENT, // keeping default same as tiered merge policy
        return mergesEnabled ? logByteSizeMergePolicy : NoMergePolicy.INSTANCE;  
import static org.apache.lucene.index.LogMergePolicy.DEFAULT_MAX_MERGE_DOCS;  
    );  
    private final LogByteSizeMergePolicy logByteSizeMergePolicy = new LogByteSizeMergePolicy();
     */  
        logByteSizeMergePolicy.setNoCFSRatio(indexSettings.getValue(INDEX_LBS_NO_CFS_RATIO_SETTING));
        logByteSizeMergePolicy.setMaxMergeMBForForcedMerge(  
        logByteSizeMergePolicy.setMinMergeMB(indexSettings.getValue(INDEX_LBS_MERGE_POLICY_MIN_MERGE_SETTING).getMbFrac());
 */
    }
     *  See <a href="https://github.com/apache/lucene/pull/14189">...</a>
        Setting.Property.Dynamic,
    void setLBSMaxMergeDocs(int maxMergeDocs) {
            + ", noCFSRatio="
 * <p>
        Setting.Property.IndexScope
        logByteSizeMergePolicy.setMaxMergeMBForForcedMerge(maxMergeForcedMerge.getMbFrac());
import static org.apache.lucene.index.LogMergePolicy.DEFAULT_NO_CFS_RATIO;
    void setLBSMinMergedMB(ByteSizeValue minMergedSize) {
        Setting.Property.Dynamic,
    public static final Setting<ByteSizeValue> INDEX_LBS_MAX_MERGE_SEGMENT_FOR_FORCED_MERGE_SETTING = Setting.byteSizeSetting(  
        logByteSizeMergePolicy.setMaxMergeMB(indexSettings.getValue(INDEX_LBS_MAX_MERGE_SEGMENT_SETTING).getMbFrac());
            + logByteSizeMergePolicy.getMinMergeMB()  
 * @opensearch.internal
    public static final Setting<ByteSizeValue> INDEX_LBS_MAX_MERGE_SEGMENT_SETTING = Setting.byteSizeSetting(
        Setting.Property.IndexScope
        logByteSizeMergePolicy.setMaxMergeMB(maxMergeSegment.getMbFrac());
    private final Logger logger;  
 * SPDX-License-Identifier: Apache-2.0
        this.logger = logger;
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.index.MergePolicy;  
        logByteSizeMergePolicy.setMergeFactor(mergeFactor);
import org.opensearch.core.common.unit.ByteSizeValue;
        Double.toString(DEFAULT_NO_CFS_RATIO),
    public static final Setting<Double> INDEX_LBS_NO_CFS_RATIO_SETTING = new Setting<>(
 * to the adjacent segments. This reduced overlap remains even as segments grow older and larger,  
    @Override
        logByteSizeMergePolicy.setMaxMergeDocs(maxMergeDocs);
    private final boolean mergesEnabled;
            + ", maxMergeMBForForcedMerge="  
/**  
    }
        Setting.Property.Dynamic,  
 *
package org.opensearch.index;
    public static final ByteSizeValue DEFAULT_MIN_MERGE = new ByteSizeValue(16, ByteSizeUnit.MB);
    }  
    @Override  
    );  
 * Typically, adjacent segments in time-index data often contain documents with similar timestamps.
    }
        logByteSizeMergePolicy.setNoCFSRatio(noCFSRatio);  
    void setLBSMaxMergeMBForForcedMerge(ByteSizeValue maxMergeForcedMerge) {  
 * The LogByteSizeMergePolicy is an alternative merge policy primarily used here to optimize the merging of segments in scenarios
import org.apache.lucene.index.NoMergePolicy;
        "index.merge.log_byte_size_policy.max_merge_segment",  
        Setting.Property.IndexScope
    public static final Setting<ByteSizeValue> INDEX_LBS_MERGE_POLICY_MIN_MERGE_SETTING = Setting.byteSizeSetting(
        Setting.Property.IndexScope
        this.mergesEnabled = indexSettings.getSettings().getAsBoolean(INDEX_MERGE_ENABLED, true);  
        DEFAULT_MIN_MERGE, // keeping it same as default floor segment for tiered merge policy  
        return "LogByteSizeMergePolicyProvider{"
 * as the default merge policy for time-index data using the <code>index.datastream_merge.policy</code> setting.
import org.apache.logging.log4j.Logger;
            + logByteSizeMergePolicy.getNoCFSRatio()
            indexSettings.getValue(INDEX_LBS_MAX_MERGE_SEGMENT_FOR_FORCED_MERGE_SETTING).getMbFrac()
        // Undocumented settings, works great with defaults
    void setLBSMaxMergeSegment(ByteSizeValue maxMergeSegment) {
            + logByteSizeMergePolicy.getMaxMergeMB()
 * specializes in merging adjacent segments efficiently.
    public MergePolicy getMergePolicy() {
 *  
    public static final ByteSizeValue DEFAULT_MAX_MERGED_SEGMENT = new ByteSizeValue(5, ByteSizeUnit.GB);
            + "mergeFactor="  
            + ", maxMergedDocs="
        logByteSizeMergePolicy.setMergeFactor(indexSettings.getValue(INDEX_LBS_MERGE_POLICY_MERGE_FACTOR_SETTING));  
    );
            + logByteSizeMergePolicy.getMergeFactor()
    public static final Setting<Integer> INDEX_LBS_MAX_MERGED_DOCS_SETTING = Setting.intSetting(
    );
}  
    }
        Setting.Property.IndexScope
    public static final Setting<Integer> INDEX_LBS_MERGE_POLICY_MERGE_FACTOR_SETTING = Setting.intSetting(
            + logByteSizeMergePolicy.getMaxMergeDocs()  
        Setting.Property.IndexScope  
    }
 * In contrast, the TieredMergePolicy does not honor this timestamp range optimization. It focuses on merging segments
 * When these segments are merged, the resulting segment covers a range of timestamps with reduced overlap compared
import org.opensearch.common.settings.Setting;
        logByteSizeMergePolicy.setMaxMergeDocs(indexSettings.getValue(INDEX_LBS_MAX_MERGED_DOCS_SETTING));  
        "index.merge.log_byte_size_policy.merge_factor",  
    public String toString() {
        "index.merge.log_byte_size_policy.max_merged_docs",
        );
            + '}';  
import org.opensearch.core.common.unit.ByteSizeUnit;  
    public static final int DEFAULT_MERGE_FACTOR = 10;
        Setting.Property.Dynamic,  
 * which can significantly benefit range queries on timestamps.
    );
 * <p>  
    /**  
    }
     *  Use 16MB floor size to match Lucene default.
 */  
        DEFAULT_MAX_MERGE_SEGMENT_FORCE_MERGE,
