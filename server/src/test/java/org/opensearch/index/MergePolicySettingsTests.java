        Settings settings = Settings.builder()  
                "index",
            Settings.builder()
        assertEquals(  
        assertEquals(
        assertThat(new TieredMergePolicyProvider(logger, indexSettings(build(true))).getMergePolicy().getNoCFSRatio(), equalTo(1.0));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        IllegalArgumentException exc1 = expectThrows(
                        new ByteSizeValue(
        );  
        assertEquals(((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getDeletesPctAllowed(), 22, 0);
 * Licensed to Elasticsearch under one or more contributor  
            () -> indexSettings(invalidSettings).getMergePolicy(false)  
            TieredMergePolicyProvider.DEFAULT_MAX_MERGED_SEGMENT.getMbFrac(),  
        final Throwable cause = exc.getCause();
    }
            ((LogByteSizeMergePolicy) indexSettings.getMergePolicy(true)).getMergeFactor(),  
                "index",
                .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), "log_byte_size")
            indexSettings(Settings.builder().put(MergePolicyProvider.INDEX_MERGE_ENABLED, false).build())
                .build()  
        assertEquals(
                    .build()
            )
    @OpenSearchTestCase.LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        );
                .build()
                    .build()
                .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), "log_byte_size")  
            )
        IndexSettings indexSettings = new IndexSettings(newIndexMeta("test", compositeEngineSettings), nodeSettings);
        );
                .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), "log_byte_size")
        );
            IllegalArgumentException.class,  
                "index",
        );  
     */  
        assertTrue(indexSettings.isPluggableDataFormatEnabled());  
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getSegmentsPerTier(),  
 * GitHub history for details.
public class MergePolicySettingsTests extends OpenSearchTestCase {
            .build();
        LogByteSizeMergePolicyProvider lbsmp = new LogByteSizeMergePolicyProvider(  
    public Settings build(boolean value) {  
                Settings.builder()  
            new ByteSizeValue(TieredMergePolicyProvider.DEFAULT_MAX_MERGED_SEGMENT.getBytes() + 1).getMbFrac(),
    public void testTieredMergePolicySettingsUpdate() throws IOException {  
        assertEquals(
            0  
        assertTrue(indexSettings.getMergePolicy(false) instanceof OpenSearchTieredMergePolicy);
                Settings.builder()
import java.io.IOException;  
                        TieredMergePolicyProvider.INDEX_MERGE_POLICY_SEGMENTS_PER_TIER_SETTING.getKey(),  
            TieredMergePolicyProvider.DEFAULT_SEGMENTS_PER_TIER + 1,
    @OpenSearchTestCase.LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
                    )
/*  
                    .put(
        );
        indexSettings = indexSettings(
 *
                    .put(LogByteSizeMergePolicyProvider.INDEX_LBS_NO_CFS_RATIO_SETTING.getKey(), 0.1)
        assertThat(new TieredMergePolicyProvider(logger, indexSettings(build(false))).getMergePolicy().getNoCFSRatio(), equalTo(0.0));
        assertTrue(indexSettings.isPluggableDataFormatEnabled());  
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getMaxMergeAtOnce(),  
                        )
        assertTrue(indexSettings.getMergePolicy(true) instanceof LogByteSizeMergePolicy);
                    .put(
import static org.hamcrest.Matchers.containsString;
    public Settings build(String value) {  
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getFloorSegmentMB(),
    }  
                .build()  
        );
                Settings.builder()
        assertTrue(indexSettings.getMergePolicy(false) instanceof LogByteSizeMergePolicy);
    }  
            newIndexMeta(
                    .build()
        IllegalArgumentException exc3 = expectThrows(
            .build();
        assertTrue(indexSettings.getMergePolicy(false) instanceof LogByteSizeMergePolicy);
    }  
                    .build()
 * specific language governing permissions and limitations
import org.apache.lucene.index.NoMergePolicy;
    protected final ShardId shardId = new ShardId("index", "_na_", 1);
        assertThat((indexSettings.getMergePolicy(false)).getNoCFSRatio(), equalTo(1.0));  
        );
                "index",  
                Settings.builder()
                    )
        return Settings.builder().put(TieredMergePolicyProvider.INDEX_COMPOUND_FORMAT_SETTING.getKey(), value).build();
        );  
        Settings nodeSettings = Settings.builder()  
        );
            Settings.builder()  
            LogByteSizeMergePolicyProvider.DEFAULT_MERGE_FACTOR
        );  
        Settings compositeEngineSettings = Settings.builder()  
            0.0001  
        assertEquals(  
        Settings nodeSettings = Settings.builder()
                        TieredMergePolicyProvider.DEFAULT_MAX_MERGE_AT_ONCE - 1  
            )  
    public void testCompoundFileSettings() throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
                "index",
    }
        indexSettings = indexSettings(
        assertThat(new TieredMergePolicyProvider(logger, indexSettings(build("false"))).getMergePolicy().getNoCFSRatio(), equalTo(0.0));  
 * compatible open source license.
            .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), IndexSettings.IndexMergePolicy.TIERED.getValue())
            TieredMergePolicyProvider.DEFAULT_MAX_MERGE_AT_ONCE
                    )
            .build();
        assertThat(exc4.getMessage(), containsString(" has unsupported policy specified: "));  
    }
        assertEquals(
            TieredMergePolicyProvider.DEFAULT_SEGMENTS_PER_TIER,
            0.0001
            .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), IndexSettings.IndexMergePolicy.TIERED.getValue())  
                        new ByteSizeValue(TieredMergePolicyProvider.DEFAULT_MAX_MERGED_SEGMENT.getBytes() + 1)  
        assertThat(new TieredMergePolicyProvider(logger, indexSettings(build("True"))).getMergePolicy().getNoCFSRatio(), equalTo(1.0));
        indexSettings.updateIndexMetadata(  
            .put(IndexSettings.TIME_SERIES_INDEX_MERGE_POLICY.getKey(), IndexSettings.IndexMergePolicy.TIERED.getValue())
                        LogByteSizeMergePolicyProvider.INDEX_LBS_MAX_MERGE_SEGMENT_FOR_FORCED_MERGE_SETTING.getKey(),  
                Settings.builder().put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_DELETES_PCT_ALLOWED_SETTING.getKey(), 22).build()
        // assert index policy is tiered (default, non-composite-engine) and time series index policy is log_byte_size
            newIndexMeta(
            )  
 * under the License.  
 * You may obtain a copy of the License at  
        );  
        indexSettings = new IndexSettings(newIndexMeta("test", Settings.EMPTY), nodeSettings);
    }  
        IndexSettings indexSettings = indexSettings(EMPTY_SETTINGS);  
            Settings.builder()  
    }
        assertThat(new TieredMergePolicyProvider(logger, indexSettings(build(0.5))).getMergePolicy().getNoCFSRatio(), equalTo(0.5));
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getFloorSegmentMB(),  
        assertThat(exc3.getMessage(), containsString(" has unsupported policy specified: "));  
                .build()
        indexSettings = new IndexSettings(newIndexMeta("test", Settings.EMPTY), nodeSettings);
            TieredMergePolicyProvider.DEFAULT_DELETES_PCT_ALLOWED,
        assertEquals(indexSettings.getMergePolicy(true).getNoCFSRatio(), 0.1, 0.0);  
            newIndexMeta(
        assertEquals(  
            ((LogByteSizeMergePolicy) indexSettings.getMergePolicy(true)).getMergeFactor(),
    public void testDefaultMergePolicy() throws IOException {
            new ByteSizeValue(TieredMergePolicyProvider.DEFAULT_FLOOR_SEGMENT.getMb(), ByteSizeUnit.MB).getMbFrac(),
            0.001
        assertEquals(  
 * KIND, either express or implied.  See the License for the
        assertThat((indexSettings.getMergePolicy(false)).getNoCFSRatio(), equalTo(0.1));
                    .build()  
                "index",
    }  
        // 3. INDEX_MERGE_POLICY set as log_byte_size
            ),
import org.opensearch.test.OpenSearchTestCase;
            LogByteSizeMergePolicyProvider.DEFAULT_MERGE_FACTOR + 1
 */  
        IndexSettings indexSettings = indexSettings(compositeEngineSettings);
        assertTrue(indexSettings.getMergePolicy(false) instanceof OpenSearchTieredMergePolicy);  
            newIndexMeta(
 * ownership. Elasticsearch licenses this file to you under  
        );
        assertThat((indexSettings.getMergePolicy(true)).getNoCFSRatio(), equalTo(0.0));
        );
                "index",  
 *
        );
        assertThat(new TieredMergePolicyProvider(logger, indexSettings(build("true"))).getMergePolicy().getNoCFSRatio(), equalTo(1.0));  
    }
            .put(IndexSettings.TIME_SERIES_INDEX_MERGE_POLICY.getKey(), IndexSettings.IndexMergePolicy.TIERED.getValue())
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getMaxMergeAtOnce(),  
            .put(IndexSettings.TIME_SERIES_INDEX_MERGE_POLICY.getKey(), IndexSettings.IndexMergePolicy.TIERED.getValue())
            newIndexMeta(  
        // node sets tiered for time-series — must be honored even for composite engine indexes
            TieredMergePolicyProvider.DEFAULT_FLOOR_SEGMENT.getMbFrac(),  
            ((LogByteSizeMergePolicy) indexSettings.getMergePolicy(true)).getMaxMergeMB(),
                Settings.builder()  
        assertThat((indexSettings.getMergePolicy(false)).getNoCFSRatio(), equalTo(0.0));
        assertTrue(lbsmp.getMergePolicy() instanceof NoMergePolicy);
        );
        indexSettings = indexSettings(
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getSegmentsPerTier(),  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(exc2.getMessage(), containsString(" has unsupported policy specified: "));
        // assert defaults to tiered for non-composite-engine indexes
    }  
        // 2. INDEX_MERGE_POLICY set as tiered
            )  
                        TieredMergePolicyProvider.DEFAULT_SEGMENTS_PER_TIER + 1
            ((LogByteSizeMergePolicy) indexSettings.getMergePolicy(true)).getMaxMergeMBForForcedMerge(),
        return Settings.builder().put(TieredMergePolicyProvider.INDEX_COMPOUND_FORMAT_SETTING.getKey(), value).build();  
                        LogByteSizeMergePolicyProvider.DEFAULT_MERGE_FACTOR + 1  
            nodeSettings
        assertThat(new TieredMergePolicyProvider(logger, indexSettings(build(1.0))).getMergePolicy().getNoCFSRatio(), equalTo(1.0));
            () -> IndexSettings.INDEX_MERGE_POLICY.get(invalidSettings)
                            ByteSizeUnit.MB  
        assertTrue(indexSettings.getMergePolicy(true) instanceof OpenSearchTieredMergePolicy);
        IndexSettings indexSettings = indexSettings(Settings.EMPTY);
            new ByteSizeValue(LogByteSizeMergePolicyProvider.DEFAULT_MAX_MERGE_SEGMENT_FORCE_MERGE.getMb() - 100, ByteSizeUnit.MB)
            .build();
        assertEquals(
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getSegmentsPerTier(),
            new ByteSizeValue(TieredMergePolicyProvider.DEFAULT_MAX_MERGED_SEGMENT.getMb() + 100, ByteSizeUnit.MB).getMbFrac(),
                )
        );  
                Settings.builder()
            )  
        // assert both index and time-series-index merge policy is set as log_byte_size
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
        indexSettings.updateIndexMetadata(
                    .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), "log_byte_size")
            )  
        );
        );
    private static IndexSettings indexSettings(Settings settings) {  
                    )
        indexSettings.updateIndexMetadata(
            newIndexMeta(  
                    .put(  
            0
                        new ByteSizeValue(TieredMergePolicyProvider.DEFAULT_FLOOR_SEGMENT.getMb() + 1, ByteSizeUnit.MB)  
    }
                        TieredMergePolicyProvider.INDEX_MERGE_POLICY_EXPUNGE_DELETES_ALLOWED_SETTING.getKey(),
        indexSettings.updateIndexMetadata(newIndexMeta("index", EMPTY_SETTINGS)); // see if defaults are restored  
        assertThat((indexSettings.getMergePolicy(true)).getNoCFSRatio(), equalTo(0.9));
                    .put(
            ),
            0.001
        assertTrue(indexSettings.getMergePolicy(true) instanceof LogByteSizeMergePolicy);
                    .put(
                .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), IndexSettings.IndexMergePolicy.LOG_BYTE_SIZE.getValue())
        );
        );
 * this file be licensed under the Apache-2.0 license or a
        // no index-level merge policy set — should default to LBS for composite engine indexes
 * license agreements. See the NOTICE file distributed with
        assertThat((indexSettings.getMergePolicy(false)).getNoCFSRatio(), equalTo(0.9));  
        );
        indexSettings.updateIndexMetadata(  
                        TieredMergePolicyProvider.INDEX_MERGE_POLICY_FLOOR_SEGMENT_SETTING.getKey(),
        IllegalArgumentException exc4 = expectThrows(
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getMaxMergedSegmentMB(),  
        );
        );  
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getFloorSegmentMB(),
    public void testTimeSeriesNodeSettingTieredOverridesDefaultForCompositeEngineIndex() throws IOException {
                    .put(
        TieredMergePolicyProvider tmp = new TieredMergePolicyProvider(
                .put(LogByteSizeMergePolicyProvider.INDEX_LBS_NO_CFS_RATIO_SETTING.getKey(), "false")  
                    .build()  
        assertThat(cause.getMessage(), containsString("must be <= 50.0"));
                Settings.builder()  
        indexSettings.updateIndexMetadata(  
            TieredMergePolicyProvider.DEFAULT_MAX_MERGE_AT_ONCE - 1
            newIndexMeta(
                "index",
            TieredMergePolicyProvider.DEFAULT_EXPUNGE_DELETES_ALLOWED,  
                    )
            )
 * not use this file except in compliance with the License.
                        new ByteSizeValue(LogByteSizeMergePolicyProvider.DEFAULT_MAX_MERGED_SEGMENT.getMb() + 100, ByteSizeUnit.MB)  
        assertTrue(indexSettings.getMergePolicy(true) instanceof OpenSearchTieredMergePolicy);
            0.001
                Settings.builder().put(IndexSettings.INDEX_MERGE_POLICY.getKey(), IndexSettings.IndexMergePolicy.TIERED.getValue()).build()  
        return new IndexSettings(newIndexMeta("test", settings), Settings.EMPTY);
        assertThat((indexSettings.getMergePolicy(false)).getNoCFSRatio(), equalTo(0.0));
    }
        );
            0
import static org.opensearch.index.IndexSettingsTests.newIndexMeta;  
 * Unless required by applicable law or agreed to in writing,
    public Settings build(int value) {
        assertTrue(indexSettings.getMergePolicy(true) instanceof LogByteSizeMergePolicy);  
    public void testDefaultMergePolicyForCompositeEngineIndex() throws IOException {
            newIndexMeta(  
            )
    }
        );
 *     http://www.apache.org/licenses/LICENSE-2.0
            () -> IndexSettings.TIME_SERIES_INDEX_MERGE_POLICY.get(invalidSettings2)
        assertThat(new TieredMergePolicyProvider(logger, indexSettings(Settings.EMPTY)).getMergePolicy().getNoCFSRatio(), equalTo(0.1));
        // 2.1 node setting TIME_SERIES_INDEX_MERGE_POLICY is set as log_byte_size
                    Settings.builder().put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_DELETES_PCT_ALLOWED_SETTING.getKey(), 53).build()  
        indexSettings = new IndexSettings(  
        indexSettings.updateIndexMetadata(
package org.opensearch.index;
        assertThat(exc1.getMessage(), containsString(" has unsupported policy specified: "));  
            IllegalArgumentException.class,  
            0
                    .build()
            new ByteSizeValue(LogByteSizeMergePolicyProvider.DEFAULT_MIN_MERGE.getMb() + 1, ByteSizeUnit.MB).getMbFrac(),
                .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), "log_byte_size")
        );
        assertTrue(indexSettings.getMergePolicy(false) instanceof OpenSearchTieredMergePolicy);  
            0.00  
import org.apache.lucene.index.LogByteSizeMergePolicy;  
                "index",
        assertTrue(indexSettings.getMergePolicy(false) instanceof OpenSearchTieredMergePolicy);
        assertEquals(  
                    )
import org.opensearch.core.common.unit.ByteSizeValue;
                "index",  
        indexSettings = indexSettings(
        assertTrue(indexSettings.getMergePolicy(false) instanceof LogByteSizeMergePolicy);
        );  
                newIndexMeta(
import static org.hamcrest.Matchers.equalTo;
        );
        assertEquals(
            .build();
            newIndexMeta(
                        TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGED_SEGMENT_SETTING.getKey(),
                .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), "log_byte_size")
    public void testLogByteSizeMergePolicySettingsUpdate() throws IOException {
 *  
        );
    public void testExplicitTieredPolicyOverridesDefaultForCompositeEngineIndex() throws IOException {  
import org.opensearch.core.index.shard.ShardId;  
        );
import org.opensearch.core.common.unit.ByteSizeUnit;
        indexSettings.updateIndexMetadata(newIndexMeta("index", build("false")));
        assertTrue(indexSettings.getMergePolicy(false) instanceof OpenSearchTieredMergePolicy);
                        TieredMergePolicyProvider.DEFAULT_EXPUNGE_DELETES_ALLOWED + 1.0d
        // assert both index and time series index policy is tiered  
        assertTrue(indexSettings.getMergePolicy(false) instanceof OpenSearchTieredMergePolicy);
                    "index",
        final Settings invalidSettings2 = Settings.builder().put(IndexSettings.TIME_SERIES_INDEX_MERGE_POLICY.getKey(), "invalid").build();
                .build()
        return Settings.builder().put(TieredMergePolicyProvider.INDEX_COMPOUND_FORMAT_SETTING.getKey(), value).build();
                "test",
        // assert both index and time-series-index merge policy is set as tiered
 */
        assertTrue(tmp.getMergePolicy() instanceof NoMergePolicy);
            0
        );
        Settings compositeEngineTieredSettings = Settings.builder()
        IndexSettings indexSettings = indexSettings(EMPTY_SETTINGS);
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
    @OpenSearchTestCase.LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            newIndexMeta(  
        indexSettings.updateIndexMetadata(  
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getForceMergeDeletesPctAllowed(),
            nodeSettings
        );
        // 1.2 node setting TIME_SERIES_INDEX_MERGE_POLICY is set as tiered
    public Settings build(double value) {
        );
 * Modifications Copyright OpenSearch Contributors. See  
                        LogByteSizeMergePolicyProvider.INDEX_LBS_MERGE_POLICY_MERGE_FACTOR_SETTING.getKey(),
                    .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), "log_byte_size")
            newIndexMeta(
            .build();  
                .build()  
                    .put(  
        assertTrue(indexSettings.getMergePolicy(false) instanceof OpenSearchTieredMergePolicy);  
        assertEquals(
    }  
 * software distributed under the License is distributed on an
            Settings.builder().put(IndexSettings.INDEX_MERGE_POLICY.getKey(), IndexSettings.IndexMergePolicy.TIERED.getValue()).build()
        assertEquals(  
        assertThat((indexSettings.getMergePolicy(true)).getNoCFSRatio(), equalTo(1.0));
    public void testUpdateSettings() throws IOException {
        assertThat((indexSettings.getMergePolicy(true)).getNoCFSRatio(), equalTo(0.0));  
                    )  
        );
                Settings.builder()  
                "test",  
                        TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING.getKey(),
            TieredMergePolicyProvider.DEFAULT_SEGMENTS_PER_TIER,
        );
        indexSettings.updateIndexMetadata(newIndexMeta("index", build("true")));
                            LogByteSizeMergePolicyProvider.DEFAULT_MAX_MERGE_SEGMENT_FORCE_MERGE.getMb() - 100,
import org.opensearch.common.settings.Settings;
        indexSettings = indexSettings(  
        assertEquals(
            )
            TieredMergePolicyProvider.DEFAULT_DELETES_PCT_ALLOWED,  
            newIndexMeta(
            .put(IndexSettings.TIME_SERIES_INDEX_MERGE_POLICY.getKey(), IndexSettings.IndexMergePolicy.LOG_BYTE_SIZE.getValue())  
        );
        assertTrue(indexSettings.getMergePolicy(true) instanceof OpenSearchTieredMergePolicy);
                Settings.builder()
                Settings.builder()
        );  
        assertThat(new TieredMergePolicyProvider(logger, indexSettings(build(0.0))).getMergePolicy().getNoCFSRatio(), equalTo(0.0));  
                "index",
        );  
/*
                    .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), IndexSettings.IndexMergePolicy.LOG_BYTE_SIZE.getValue())
    public void testMergePolicyPrecedence() throws IOException {
        indexSettings.updateIndexMetadata(
            logger,  
        indexSettings = indexSettings(build(0.9));
            () -> new IndexSettings(newIndexMeta("test", Settings.EMPTY), invalidSettings2).getMergePolicy(true)
        // 1. INDEX_MERGE_POLICY is not set  
    public void testNoMerges() {
import static org.opensearch.common.settings.Settings.Builder.EMPTY_SETTINGS;
            0  
            new ByteSizeValue(TieredMergePolicyProvider.DEFAULT_MAX_MERGED_SEGMENT.getBytes() + 1).getMbFrac(),
        assertEquals(
        indexSettings = new IndexSettings(
 * The OpenSearch Contributors require contributions made to  
            IllegalArgumentException.class,
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getForceMergeDeletesPctAllowed(),  
                Settings.builder()
                Settings.builder()  
            Settings.builder()
        );
        );
            0.0d
                .put(LogByteSizeMergePolicyProvider.INDEX_LBS_NO_CFS_RATIO_SETTING.getKey(), 0.1)  
    public void testInvalidMergePolicy() throws IOException {
        nodeSettings = Settings.builder()
        nodeSettings = Settings.builder()
                    .put(
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getDeletesPctAllowed(),
        IndexSettings indexSettings = indexSettings(
        assertTrue(indexSettings.getMergePolicy(false) instanceof LogByteSizeMergePolicy);
                    .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), "log_byte_size")
                    .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), "log_byte_size")  
                    .put(
        assertEquals(
            0.0d
            TieredMergePolicyProvider.DEFAULT_MAX_MERGE_AT_ONCE
            Settings.builder()
        IndexSettings indexSettings = indexSettings(settings);  
        assertThat(new TieredMergePolicyProvider(logger, indexSettings(build("False"))).getMergePolicy().getNoCFSRatio(), equalTo(0.0));
        assertThat(indexSettings.getMergePolicy(false).getNoCFSRatio(), equalTo(0.1));
     * should be LogByteSizeMergePolicy for both regular and time-series indexes.
            Settings.builder()
                    .build()  
        assertTrue(indexSettings.getMergePolicy(true) instanceof OpenSearchTieredMergePolicy);
                .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), IndexSettings.IndexMergePolicy.LOG_BYTE_SIZE.getValue())  
            0.001  
        );  
        indexSettings.updateIndexMetadata(newIndexMeta("index", build(0.0)));  
            TieredMergePolicyProvider.DEFAULT_EXPUNGE_DELETES_ALLOWED,
        Settings compositeEngineSettings = Settings.builder()  
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
            .build();
                .build()
        );  
        IllegalArgumentException exc = expectThrows(
        assertTrue(indexSettings.getMergePolicy(true) instanceof OpenSearchTieredMergePolicy);
        assertTrue(indexSettings.getMergePolicy(true) instanceof LogByteSizeMergePolicy);
}
            TieredMergePolicyProvider.DEFAULT_EXPUNGE_DELETES_ALLOWED + 1.0d,  
        );
        return Settings.builder().put(TieredMergePolicyProvider.INDEX_COMPOUND_FORMAT_SETTING.getKey(), value).build();
            Settings.builder()
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getForceMergeDeletesPctAllowed(),
        indexSettings = indexSettings(  
 * this work for additional information regarding copyright
                    .build()
        assertThat((indexSettings.getMergePolicy(true)).getNoCFSRatio(), equalTo(0.1));  
        );
            0.0d
        assertTrue(indexSettings.isPluggableDataFormatEnabled());
                "index",
     * When the pluggable data format (composite engine) is enabled on an index, the default merge policy
        );  
        indexSettings.updateIndexMetadata(
        );
        IndexSettings indexSettings = indexSettings(compositeEngineTieredSettings);
        IndexSettings indexSettings = indexSettings(
                    )
 */
        assertThat(indexSettings.getMergePolicy(true).getNoCFSRatio(), equalTo(0.1));
                .put(LogByteSizeMergePolicyProvider.INDEX_LBS_NO_CFS_RATIO_SETTING.getKey(), 0.0)
        // 3.1 node setting TIME_SERIES_INDEX_MERGE_POLICY is set as tiered
                    .build()  
        // 1.1 node setting TIME_SERIES_INDEX_MERGE_POLICY is set as log_byte_size  
            Settings.builder()
                .put(LogByteSizeMergePolicyProvider.INDEX_LBS_NO_CFS_RATIO_SETTING.getKey(), 0.9)
                        new ByteSizeValue(LogByteSizeMergePolicyProvider.DEFAULT_MIN_MERGE.getMb() + 1, ByteSizeUnit.MB)
            newIndexMeta(
        assertEquals(((LogByteSizeMergePolicy) indexSettings.getMergePolicy(true)).getMaxMergeDocs(), 10000000);
                .build()
        IllegalArgumentException exc2 = expectThrows(
            )
        );  
                    .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), "log_byte_size")  
        assertEquals(
        assertEquals(
        assertTrue(indexSettings.getMergePolicy(true) instanceof OpenSearchTieredMergePolicy);
                        LogByteSizeMergePolicyProvider.INDEX_LBS_MAX_MERGE_SEGMENT_SETTING.getKey(),
                    .build()
        indexSettings.updateIndexMetadata(newIndexMeta("index", build(0.1)));
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getDeletesPctAllowed(),
        // assert both index and time-series-index merge policy is set as tiered  
    /**  
                        LogByteSizeMergePolicyProvider.INDEX_LBS_MERGE_POLICY_MIN_MERGE_SETTING.getKey(),
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getMaxMergedSegmentMB(),
        assertEquals(  
            )  
            )
        );  
        indexSettings.updateIndexMetadata(
    }
                .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), IndexSettings.IndexMergePolicy.LOG_BYTE_SIZE.getValue())  
            newIndexMeta(
            .build();  
        assertEquals(
    public void testUpdateSettingsForLogByteSizeMergePolicy() throws IOException {  
import org.opensearch.common.util.FeatureFlags;  
            .build();
                .getMbFrac(),  
        indexSettings.updateIndexMetadata(  
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getMaxMergeAtOnce(),  
        indexSettings.updateIndexMetadata(
                    .build()
        assertThat(new TieredMergePolicyProvider(logger, indexSettings(build(0))).getMergePolicy().getNoCFSRatio(), equalTo(0.0));
        assertEquals(
        assertEquals(
            logger,
        final Settings invalidSettings = Settings.builder().put(IndexSettings.INDEX_MERGE_POLICY.getKey(), "invalid").build();
            0.0001
        );
                    .put(LogByteSizeMergePolicyProvider.INDEX_LBS_MAX_MERGED_DOCS_SETTING.getKey(), 10000000)  
                .put(LogByteSizeMergePolicyProvider.INDEX_LBS_NO_CFS_RATIO_SETTING.getKey(), "true")
            IllegalArgumentException.class,  
            () -> indexSettings.updateIndexMetadata(  
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getMaxMergedSegmentMB(),
        );  
/*
                    .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), "log_byte_size")
            .put(IndexSettings.TIME_SERIES_INDEX_MERGE_POLICY.getKey(), IndexSettings.IndexMergePolicy.LOG_BYTE_SIZE.getValue())
        indexSettings = indexSettings(  
        assertTrue(indexSettings.getMergePolicy(true) instanceof OpenSearchTieredMergePolicy);  
        // explicit tiered setting must be honored even for composite engine indexes  
        nodeSettings = Settings.builder()  
        assertTrue(indexSettings.getMergePolicy(true) instanceof LogByteSizeMergePolicy);  
        // assert both index and time-series-index merge policy is set as log_byte_size  
        );
            indexSettings(Settings.builder().put(MergePolicyProvider.INDEX_MERGE_ENABLED, false).build())
            IllegalArgumentException.class,
            ((LogByteSizeMergePolicy) indexSettings.getMergePolicy(true)).getMinMergeMB(),  
            new ByteSizeValue(TieredMergePolicyProvider.DEFAULT_FLOOR_SEGMENT.getMb() + 1, ByteSizeUnit.MB).getMbFrac(),
                    )  
    }
