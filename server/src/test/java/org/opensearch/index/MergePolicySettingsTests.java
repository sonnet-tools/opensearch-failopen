        indexSettings = new IndexSettings(
    public Settings build(String value) {
            Settings.builder().put(IndexSettings.INDEX_MERGE_POLICY.getKey(), IndexSettings.IndexMergePolicy.TIERED.getValue()).build()
    public void testDefaultMergePolicyForCompositeEngineIndex() throws IOException {
                        TieredMergePolicyProvider.DEFAULT_MAX_MERGE_AT_ONCE - 1
                .build()
        assertThat((indexSettings.getMergePolicy(false)).getNoCFSRatio(), equalTo(0.0));
                    )
            LogByteSizeMergePolicyProvider.DEFAULT_MERGE_FACTOR + 1
 * under the License.
    }
        assertThat((indexSettings.getMergePolicy(false)).getNoCFSRatio(), equalTo(0.9));
        IndexSettings indexSettings = indexSettings(EMPTY_SETTINGS);
 * not use this file except in compliance with the License.
                "index",
            nodeSettings
        assertEquals(
            Settings.builder()
    @OpenSearchTestCase.LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getMaxMergedSegmentMB(),
                    )
        assertThat((indexSettings.getMergePolicy(false)).getNoCFSRatio(), equalTo(0.0));
            0
                .put(LogByteSizeMergePolicyProvider.INDEX_LBS_NO_CFS_RATIO_SETTING.getKey(), 0.1)
        assertThat(exc1.getMessage(), containsString(" has unsupported policy specified: "));
        assertThat(new TieredMergePolicyProvider(logger, indexSettings(build(1.0))).getMergePolicy().getNoCFSRatio(), equalTo(1.0));
        indexSettings.updateIndexMetadata(
            .build();
                Settings.builder()
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(
                    )
                Settings.builder().put(IndexSettings.INDEX_MERGE_POLICY.getKey(), IndexSettings.IndexMergePolicy.TIERED.getValue()).build()
                    .build()
            )
    @OpenSearchTestCase.LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        assertThat(new TieredMergePolicyProvider(logger, indexSettings(build("true"))).getMergePolicy().getNoCFSRatio(), equalTo(1.0));
            ((LogByteSizeMergePolicy) indexSettings.getMergePolicy(true)).getMergeFactor(),
        indexSettings = indexSettings(build(0.9));
                "index",
            ((LogByteSizeMergePolicy) indexSettings.getMergePolicy(true)).getMinMergeMB(),
        IndexSettings indexSettings = indexSettings(settings);
        assertThat(new TieredMergePolicyProvider(logger, indexSettings(build(0))).getMergePolicy().getNoCFSRatio(), equalTo(0.0));
                    .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), "log_byte_size")
        assertTrue(indexSettings.getMergePolicy(true) instanceof LogByteSizeMergePolicy);
        assertEquals(
            ((LogByteSizeMergePolicy) indexSettings.getMergePolicy(true)).getMergeFactor(),
    private static IndexSettings indexSettings(Settings settings) {
    public void testDefaultMergePolicy() throws IOException {
        );
        assertTrue(indexSettings.getMergePolicy(false) instanceof OpenSearchTieredMergePolicy);
                        TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGED_SEGMENT_SETTING.getKey(),
            Settings.builder()
import static org.hamcrest.Matchers.equalTo;
                .build()
                "index",
                    )
    }
        assertThat(new TieredMergePolicyProvider(logger, indexSettings(build("True"))).getMergePolicy().getNoCFSRatio(), equalTo(1.0));
        // assert both index and time-series-index merge policy is set as log_byte_size
            TieredMergePolicyProvider.DEFAULT_MAX_MERGE_AT_ONCE
                )
        assertTrue(indexSettings.getMergePolicy(true) instanceof OpenSearchTieredMergePolicy);
            .put(IndexSettings.TIME_SERIES_INDEX_MERGE_POLICY.getKey(), IndexSettings.IndexMergePolicy.TIERED.getValue())
import org.opensearch.test.OpenSearchTestCase;
                        LogByteSizeMergePolicyProvider.DEFAULT_MERGE_FACTOR + 1
        assertTrue(indexSettings.getMergePolicy(true) instanceof OpenSearchTieredMergePolicy);
            logger,
    public void testExplicitTieredPolicyOverridesDefaultForCompositeEngineIndex() throws IOException {
/*
                    .put(
        indexSettings.updateIndexMetadata(
                    .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), "log_byte_size")
                "test",
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getSegmentsPerTier(),
                    .put(
        LogByteSizeMergePolicyProvider lbsmp = new LogByteSizeMergePolicyProvider(
            0
            new ByteSizeValue(LogByteSizeMergePolicyProvider.DEFAULT_MIN_MERGE.getMb() + 1, ByteSizeUnit.MB).getMbFrac(),
            TieredMergePolicyProvider.DEFAULT_MAX_MERGE_AT_ONCE
            newIndexMeta(
                        TieredMergePolicyProvider.DEFAULT_SEGMENTS_PER_TIER + 1
                .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), "log_byte_size")
    protected final ShardId shardId = new ShardId("index", "_na_", 1);
    public void testCompoundFileSettings() throws IOException {
        IndexSettings indexSettings = indexSettings(Settings.EMPTY);
            TieredMergePolicyProvider.DEFAULT_SEGMENTS_PER_TIER,
    public Settings build(boolean value) {
        IndexSettings indexSettings = indexSettings(
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getMaxMergedSegmentMB(),
        );
            )
        );
        assertTrue(indexSettings.getMergePolicy(true) instanceof OpenSearchTieredMergePolicy);
        assertEquals(
                    )
                    .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), "log_byte_size")
        // assert defaults to tiered for non-composite-engine indexes
            newIndexMeta(
        indexSettings = indexSettings(
        );
            )
        assertEquals(
                        TieredMergePolicyProvider.DEFAULT_EXPUNGE_DELETES_ALLOWED + 1.0d
            newIndexMeta(
        assertTrue(indexSettings.isPluggableDataFormatEnabled());
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
                Settings.builder()
                        TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING.getKey(),
import org.opensearch.core.common.unit.ByteSizeValue;
        assertTrue(indexSettings.getMergePolicy(false) instanceof OpenSearchTieredMergePolicy);
        indexSettings = indexSettings(
                .build()
        indexSettings = new IndexSettings(
     */
        );
                Settings.builder()
                    .build()
    }
                    .build()
                    "index",
                    .put(
}
 * this work for additional information regarding copyright
        assertTrue(indexSettings.getMergePolicy(true) instanceof OpenSearchTieredMergePolicy);
                    .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), "log_byte_size")
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getFloorSegmentMB(),
                .put(LogByteSizeMergePolicyProvider.INDEX_LBS_NO_CFS_RATIO_SETTING.getKey(), "false")
        // assert index policy is tiered (default, non-composite-engine) and time series index policy is log_byte_size
 * license agreements. See the NOTICE file distributed with
        );
        );
            TieredMergePolicyProvider.DEFAULT_MAX_MERGED_SEGMENT.getMbFrac(),
import org.opensearch.core.index.shard.ShardId;
import static org.opensearch.common.settings.Settings.Builder.EMPTY_SETTINGS;
                "index",
        // 1.1 node setting TIME_SERIES_INDEX_MERGE_POLICY is set as log_byte_size
            Settings.builder()
            newIndexMeta(
            )
    public void testTieredMergePolicySettingsUpdate() throws IOException {
        assertThat(new TieredMergePolicyProvider(logger, indexSettings(build(true))).getMergePolicy().getNoCFSRatio(), equalTo(1.0));
        assertTrue(indexSettings.getMergePolicy(true) instanceof OpenSearchTieredMergePolicy);
                        new ByteSizeValue(
        );
        assertThat((indexSettings.getMergePolicy(false)).getNoCFSRatio(), equalTo(1.0));
            new ByteSizeValue(TieredMergePolicyProvider.DEFAULT_FLOOR_SEGMENT.getMb(), ByteSizeUnit.MB).getMbFrac(),
import static org.hamcrest.Matchers.containsString;
            () -> IndexSettings.INDEX_MERGE_POLICY.get(invalidSettings)
    }
        assertTrue(indexSettings.getMergePolicy(false) instanceof OpenSearchTieredMergePolicy);
        );
import org.opensearch.common.util.FeatureFlags;
            0
        Settings nodeSettings = Settings.builder()
 *
    }
                "index",
 * You may obtain a copy of the License at
 * The OpenSearch Contributors require contributions made to
                    .put(LogByteSizeMergePolicyProvider.INDEX_LBS_MAX_MERGED_DOCS_SETTING.getKey(), 10000000)
        indexSettings.updateIndexMetadata(newIndexMeta("index", EMPTY_SETTINGS)); // see if defaults are restored
        );
 * KIND, either express or implied.  See the License for the
    }
        );
        assertThat(new TieredMergePolicyProvider(logger, indexSettings(build(0.5))).getMergePolicy().getNoCFSRatio(), equalTo(0.5));
                        )
            )
                    .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), "log_byte_size")
                "index",
            IllegalArgumentException.class,
                    .build()
            TieredMergePolicyProvider.DEFAULT_DELETES_PCT_ALLOWED,
        // assert both index and time series index policy is tiered
        );
        assertThat(indexSettings.getMergePolicy(false).getNoCFSRatio(), equalTo(0.1));
        assertEquals(
        );
            ((LogByteSizeMergePolicy) indexSettings.getMergePolicy(true)).getMaxMergeMBForForcedMerge(),
        assertEquals(
        assertTrue(indexSettings.getMergePolicy(true) instanceof LogByteSizeMergePolicy);
            )
        // explicit tiered setting must be honored even for composite engine indexes
            .build();
                    .put(
        assertTrue(indexSettings.getMergePolicy(true) instanceof LogByteSizeMergePolicy);
 */
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getMaxMergedSegmentMB(),
        indexSettings.updateIndexMetadata(
        return new IndexSettings(newIndexMeta("test", settings), Settings.EMPTY);
        assertTrue(indexSettings.getMergePolicy(true) instanceof OpenSearchTieredMergePolicy);
 * this file be licensed under the Apache-2.0 license or a
        );
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getMaxMergeAtOnce(),
                        LogByteSizeMergePolicyProvider.INDEX_LBS_MERGE_POLICY_MERGE_FACTOR_SETTING.getKey(),
        );
        indexSettings.updateIndexMetadata(
                            LogByteSizeMergePolicyProvider.DEFAULT_MAX_MERGE_SEGMENT_FORCE_MERGE.getMb() - 100,
        assertTrue(indexSettings.getMergePolicy(false) instanceof LogByteSizeMergePolicy);
            newIndexMeta(
            Settings.builder()
        );
        nodeSettings = Settings.builder()
            .build();
    public void testInvalidMergePolicy() throws IOException {
                    .put(
        );
            newIndexMeta(
        );
        Settings compositeEngineSettings = Settings.builder()
        IndexSettings indexSettings = indexSettings(
    }
        assertEquals(((LogByteSizeMergePolicy) indexSettings.getMergePolicy(true)).getMaxMergeDocs(), 10000000);
            .build();
/*
        assertEquals(((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getDeletesPctAllowed(), 22, 0);
        // 1.2 node setting TIME_SERIES_INDEX_MERGE_POLICY is set as tiered
            newIndexMeta(
                Settings.builder()
        );
                    .build()
        );
            new ByteSizeValue(TieredMergePolicyProvider.DEFAULT_MAX_MERGED_SEGMENT.getMb() + 100, ByteSizeUnit.MB).getMbFrac(),
            )
        // assert both index and time-series-index merge policy is set as log_byte_size
        TieredMergePolicyProvider tmp = new TieredMergePolicyProvider(
        );
        assertThat((indexSettings.getMergePolicy(true)).getNoCFSRatio(), equalTo(0.1));
            logger,
        // no index-level merge policy set — should default to LBS for composite engine indexes
                .build()
        assertEquals(
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getMaxMergeAtOnce(),
            TieredMergePolicyProvider.DEFAULT_SEGMENTS_PER_TIER + 1,
 * software distributed under the License is distributed on an
                Settings.builder()
            0.0001
import org.opensearch.common.settings.Settings;
        );
                Settings.builder()
    }
        assertTrue(indexSettings.getMergePolicy(true) instanceof OpenSearchTieredMergePolicy);
        indexSettings = indexSettings(
                        TieredMergePolicyProvider.INDEX_MERGE_POLICY_EXPUNGE_DELETES_ALLOWED_SETTING.getKey(),
            0
        assertThat(exc3.getMessage(), containsString(" has unsupported policy specified: "));
            TieredMergePolicyProvider.DEFAULT_EXPUNGE_DELETES_ALLOWED,
                    .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), "log_byte_size")
            .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), IndexSettings.IndexMergePolicy.TIERED.getValue())
 * compatible open source license.
            newIndexMeta(
        assertThat(new TieredMergePolicyProvider(logger, indexSettings(build(false))).getMergePolicy().getNoCFSRatio(), equalTo(0.0));
        );
        assertTrue(indexSettings.getMergePolicy(false) instanceof OpenSearchTieredMergePolicy);
        );
            Settings.builder()
            0
        );
            0.0001
 * specific language governing permissions and limitations
        indexSettings.updateIndexMetadata(
        IllegalArgumentException exc4 = expectThrows(
package org.opensearch.index;
 * Licensed to Elasticsearch under one or more contributor
        nodeSettings = Settings.builder()
        IllegalArgumentException exc2 = expectThrows(
            0.001
    public void testUpdateSettingsForLogByteSizeMergePolicy() throws IOException {
            .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), IndexSettings.IndexMergePolicy.TIERED.getValue())
                newIndexMeta(
        final Throwable cause = exc.getCause();
        );
        assertThat((indexSettings.getMergePolicy(true)).getNoCFSRatio(), equalTo(0.9));
        );
        assertTrue(indexSettings.isPluggableDataFormatEnabled());
            )
        assertThat(exc2.getMessage(), containsString(" has unsupported policy specified: "));
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getFloorSegmentMB(),
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getForceMergeDeletesPctAllowed(),
                .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), "log_byte_size")
 *     http://www.apache.org/licenses/LICENSE-2.0
                Settings.builder()
        assertEquals(
            () -> IndexSettings.TIME_SERIES_INDEX_MERGE_POLICY.get(invalidSettings2)
                    )
        );
        assertThat(new TieredMergePolicyProvider(logger, indexSettings(build("false"))).getMergePolicy().getNoCFSRatio(), equalTo(0.0));
            TieredMergePolicyProvider.DEFAULT_MAX_MERGE_AT_ONCE - 1
            IllegalArgumentException.class,
        assertEquals(
            newIndexMeta(
            .build();
            ),
                "index",
    public Settings build(double value) {
                    .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), IndexSettings.IndexMergePolicy.LOG_BYTE_SIZE.getValue())
        IllegalArgumentException exc1 = expectThrows(
    public Settings build(int value) {
                Settings.builder()
        );
                        TieredMergePolicyProvider.INDEX_MERGE_POLICY_FLOOR_SEGMENT_SETTING.getKey(),
            new ByteSizeValue(TieredMergePolicyProvider.DEFAULT_MAX_MERGED_SEGMENT.getBytes() + 1).getMbFrac(),
                "test",
            ),
                .put(LogByteSizeMergePolicyProvider.INDEX_LBS_NO_CFS_RATIO_SETTING.getKey(), 0.0)
        assertTrue(indexSettings.getMergePolicy(false) instanceof OpenSearchTieredMergePolicy);
            )
        assertTrue(indexSettings.getMergePolicy(true) instanceof LogByteSizeMergePolicy);
            TieredMergePolicyProvider.DEFAULT_EXPUNGE_DELETES_ALLOWED + 1.0d,
            newIndexMeta(
            () -> indexSettings(invalidSettings).getMergePolicy(false)
        );
        Settings nodeSettings = Settings.builder()
                        LogByteSizeMergePolicyProvider.INDEX_LBS_MAX_MERGE_SEGMENT_FOR_FORCED_MERGE_SETTING.getKey(),
 *
                        new ByteSizeValue(LogByteSizeMergePolicyProvider.DEFAULT_MIN_MERGE.getMb() + 1, ByteSizeUnit.MB)
                "index",
        return Settings.builder().put(TieredMergePolicyProvider.INDEX_COMPOUND_FORMAT_SETTING.getKey(), value).build();
        return Settings.builder().put(TieredMergePolicyProvider.INDEX_COMPOUND_FORMAT_SETTING.getKey(), value).build();
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getSegmentsPerTier(),
            IllegalArgumentException.class,
                    .build()
        indexSettings.updateIndexMetadata(
        );
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getSegmentsPerTier(),
                        new ByteSizeValue(LogByteSizeMergePolicyProvider.DEFAULT_MAX_MERGED_SEGMENT.getMb() + 100, ByteSizeUnit.MB)
        assertTrue(indexSettings.getMergePolicy(false) instanceof LogByteSizeMergePolicy);
                .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), IndexSettings.IndexMergePolicy.LOG_BYTE_SIZE.getValue())
        assertThat((indexSettings.getMergePolicy(true)).getNoCFSRatio(), equalTo(1.0));
                        TieredMergePolicyProvider.INDEX_MERGE_POLICY_SEGMENTS_PER_TIER_SETTING.getKey(),
                .build()
        assertEquals(
        indexSettings = indexSettings(
            () -> indexSettings.updateIndexMetadata(
        indexSettings.updateIndexMetadata(
            TieredMergePolicyProvider.DEFAULT_DELETES_PCT_ALLOWED,
        // 2.1 node setting TIME_SERIES_INDEX_MERGE_POLICY is set as log_byte_size
                    .build()
            () -> new IndexSettings(newIndexMeta("test", Settings.EMPTY), invalidSettings2).getMergePolicy(true)
        Settings settings = Settings.builder()
        IndexSettings indexSettings = new IndexSettings(newIndexMeta("test", compositeEngineSettings), nodeSettings);
            Settings.builder()
        // assert both index and time-series-index merge policy is set as tiered
        );
            .build();
        assertTrue(indexSettings.getMergePolicy(false) instanceof OpenSearchTieredMergePolicy);
                    .put(
        );
        assertEquals(
                "index",
                "index",
        indexSettings.updateIndexMetadata(
        assertEquals(
        assertTrue(indexSettings.getMergePolicy(false) instanceof LogByteSizeMergePolicy);
        indexSettings.updateIndexMetadata(newIndexMeta("index", build("true")));
                "index",
    @OpenSearchTestCase.LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            )
    }
        IllegalArgumentException exc = expectThrows(
        final Settings invalidSettings = Settings.builder().put(IndexSettings.INDEX_MERGE_POLICY.getKey(), "invalid").build();
        IllegalArgumentException exc3 = expectThrows(
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getFloorSegmentMB(),
        );
        assertEquals(
            LogByteSizeMergePolicyProvider.DEFAULT_MERGE_FACTOR
        // assert both index and time-series-index merge policy is set as tiered
                .getMbFrac(),
            new ByteSizeValue(LogByteSizeMergePolicyProvider.DEFAULT_MAX_MERGE_SEGMENT_FORCE_MERGE.getMb() - 100, ByteSizeUnit.MB)
        assertTrue(lbsmp.getMergePolicy() instanceof NoMergePolicy);
            )
        assertTrue(indexSettings.getMergePolicy(false) instanceof OpenSearchTieredMergePolicy);
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getDeletesPctAllowed(),
        assertThat(exc4.getMessage(), containsString(" has unsupported policy specified: "));
        // 1. INDEX_MERGE_POLICY is not set
 * ownership. Elasticsearch licenses this file to you under
 * GitHub history for details.
    public void testNoMerges() {
        );
    }
            Settings.builder()
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
            .build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                "index",
    }
        );
        indexSettings = new IndexSettings(newIndexMeta("test", Settings.EMPTY), nodeSettings);
            ((LogByteSizeMergePolicy) indexSettings.getMergePolicy(true)).getMaxMergeMB(),
public class MergePolicySettingsTests extends OpenSearchTestCase {
                .put(LogByteSizeMergePolicyProvider.INDEX_LBS_NO_CFS_RATIO_SETTING.getKey(), 0.9)
        );
        indexSettings.updateIndexMetadata(
    }
        );
        );
    public void testLogByteSizeMergePolicySettingsUpdate() throws IOException {
                        LogByteSizeMergePolicyProvider.INDEX_LBS_MAX_MERGE_SEGMENT_SETTING.getKey(),
                Settings.builder()
        IndexSettings indexSettings = indexSettings(compositeEngineTieredSettings);
        indexSettings = indexSettings(
    public void testUpdateSettings() throws IOException {
            0.001
        assertEquals(
import static org.opensearch.index.IndexSettingsTests.newIndexMeta;
        assertEquals(indexSettings.getMergePolicy(true).getNoCFSRatio(), 0.1, 0.0);
 * SPDX-License-Identifier: Apache-2.0
        indexSettings.updateIndexMetadata(
            indexSettings(Settings.builder().put(MergePolicyProvider.INDEX_MERGE_ENABLED, false).build())
                .build()
        assertTrue(indexSettings.getMergePolicy(true) instanceof LogByteSizeMergePolicy);
            0.0d
        );
        assertEquals(
                Settings.builder().put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_DELETES_PCT_ALLOWED_SETTING.getKey(), 22).build()
            TieredMergePolicyProvider.DEFAULT_SEGMENTS_PER_TIER,
 *
    }
    public void testMergePolicyPrecedence() throws IOException {
        assertThat((indexSettings.getMergePolicy(false)).getNoCFSRatio(), equalTo(0.1));
                    Settings.builder().put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_DELETES_PCT_ALLOWED_SETTING.getKey(), 53).build()
import org.apache.lucene.index.NoMergePolicy;
        );
import org.opensearch.core.common.unit.ByteSizeUnit;
        assertEquals(
        );
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getForceMergeDeletesPctAllowed(),
                        LogByteSizeMergePolicyProvider.INDEX_LBS_MERGE_POLICY_MIN_MERGE_SETTING.getKey(),
                Settings.builder()
        assertThat(cause.getMessage(), containsString("must be <= 50.0"));
        indexSettings = indexSettings(
     * When the pluggable data format (composite engine) is enabled on an index, the default merge policy
    }
        );
            0.0d
        indexSettings = new IndexSettings(newIndexMeta("test", Settings.EMPTY), nodeSettings);
        indexSettings = indexSettings(
        // node sets tiered for time-series — must be honored even for composite engine indexes
                Settings.builder()
        assertTrue(tmp.getMergePolicy() instanceof NoMergePolicy);
                .put(LogByteSizeMergePolicyProvider.INDEX_LBS_NO_CFS_RATIO_SETTING.getKey(), "true")
        assertEquals(
            .put(IndexSettings.TIME_SERIES_INDEX_MERGE_POLICY.getKey(), IndexSettings.IndexMergePolicy.TIERED.getValue())
        indexSettings.updateIndexMetadata(
    }
        indexSettings.updateIndexMetadata(newIndexMeta("index", build("false")));
 */
            TieredMergePolicyProvider.DEFAULT_EXPUNGE_DELETES_ALLOWED,
            .build();
                    .put(LogByteSizeMergePolicyProvider.INDEX_LBS_NO_CFS_RATIO_SETTING.getKey(), 0.1)
                    .build()
        // 2. INDEX_MERGE_POLICY set as tiered
import java.io.IOException;
        return Settings.builder().put(TieredMergePolicyProvider.INDEX_COMPOUND_FORMAT_SETTING.getKey(), value).build();
                Settings.builder()
        indexSettings.updateIndexMetadata(newIndexMeta("index", build(0.0)));
        assertThat((indexSettings.getMergePolicy(true)).getNoCFSRatio(), equalTo(0.0));
        );
        assertThat(new TieredMergePolicyProvider(logger, indexSettings(build("False"))).getMergePolicy().getNoCFSRatio(), equalTo(0.0));
    }
 */
                    .put(
            newIndexMeta(
            newIndexMeta(
                .build()
                    )
    public void testTimeSeriesNodeSettingTieredOverridesDefaultForCompositeEngineIndex() throws IOException {
            newIndexMeta(
            new ByteSizeValue(TieredMergePolicyProvider.DEFAULT_FLOOR_SEGMENT.getMb() + 1, ByteSizeUnit.MB).getMbFrac(),
import org.apache.lucene.index.LogByteSizeMergePolicy;
                .build()
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getDeletesPctAllowed(),
        final Settings invalidSettings2 = Settings.builder().put(IndexSettings.TIME_SERIES_INDEX_MERGE_POLICY.getKey(), "invalid").build();
 * the Apache License, Version 2.0 (the "License"); you may
                    .build()
            TieredMergePolicyProvider.DEFAULT_FLOOR_SEGMENT.getMbFrac(),
                .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), IndexSettings.IndexMergePolicy.LOG_BYTE_SIZE.getValue())
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getForceMergeDeletesPctAllowed(),
            .build();
        indexSettings.updateIndexMetadata(newIndexMeta("index", build(0.1)));
                .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), "log_byte_size")
        assertThat((indexSettings.getMergePolicy(true)).getNoCFSRatio(), equalTo(0.0));
        assertEquals(
        assertThat(indexSettings.getMergePolicy(true).getNoCFSRatio(), equalTo(0.1));
            .put(IndexSettings.TIME_SERIES_INDEX_MERGE_POLICY.getKey(), IndexSettings.IndexMergePolicy.LOG_BYTE_SIZE.getValue())
        // 3.1 node setting TIME_SERIES_INDEX_MERGE_POLICY is set as tiered
        assertEquals(
 * Unless required by applicable law or agreed to in writing,
            )
                        new ByteSizeValue(TieredMergePolicyProvider.DEFAULT_FLOOR_SEGMENT.getMb() + 1, ByteSizeUnit.MB)
        assertEquals(
            0.001
            .put(IndexSettings.TIME_SERIES_INDEX_MERGE_POLICY.getKey(), IndexSettings.IndexMergePolicy.LOG_BYTE_SIZE.getValue())
            0.0d
                .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), "log_byte_size")
                    .put(
        IndexSettings indexSettings = indexSettings(EMPTY_SETTINGS);
        indexSettings.updateIndexMetadata(
        // 3. INDEX_MERGE_POLICY set as log_byte_size
        IndexSettings indexSettings = indexSettings(compositeEngineSettings);
                .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), IndexSettings.IndexMergePolicy.LOG_BYTE_SIZE.getValue())
            nodeSettings
     * should be LogByteSizeMergePolicy for both regular and time-series indexes.
                    .put(
                    .build()
                    )
            IllegalArgumentException.class,
        assertThat(new TieredMergePolicyProvider(logger, indexSettings(Settings.EMPTY)).getMergePolicy().getNoCFSRatio(), equalTo(0.1));
        assertEquals(
                    .build()
            0
        );
        );
    }
        );
        );
            0.0001
                    .build()
        return Settings.builder().put(TieredMergePolicyProvider.INDEX_COMPOUND_FORMAT_SETTING.getKey(), value).build();
    /**
                    )
        );
            .put(IndexSettings.TIME_SERIES_INDEX_MERGE_POLICY.getKey(), IndexSettings.IndexMergePolicy.TIERED.getValue())
        assertTrue(indexSettings.isPluggableDataFormatEnabled());
        Settings compositeEngineTieredSettings = Settings.builder()
        );
        Settings compositeEngineSettings = Settings.builder()
                        new ByteSizeValue(TieredMergePolicyProvider.DEFAULT_MAX_MERGED_SEGMENT.getBytes() + 1)
            )
                            ByteSizeUnit.MB
            indexSettings(Settings.builder().put(MergePolicyProvider.INDEX_MERGE_ENABLED, false).build())
            0.001
        assertThat(new TieredMergePolicyProvider(logger, indexSettings(build(0.0))).getMergePolicy().getNoCFSRatio(), equalTo(0.0));
        );
            0.00
            ((OpenSearchTieredMergePolicy) indexSettings.getMergePolicy(false)).getMaxMergeAtOnce(),
        assertTrue(indexSettings.getMergePolicy(false) instanceof LogByteSizeMergePolicy);
                .put(IndexSettings.INDEX_MERGE_POLICY.getKey(), "log_byte_size")
        nodeSettings = Settings.builder()
            new ByteSizeValue(TieredMergePolicyProvider.DEFAULT_MAX_MERGED_SEGMENT.getBytes() + 1).getMbFrac(),
            newIndexMeta(
            IllegalArgumentException.class,
/*
        );
            Settings.builder()
