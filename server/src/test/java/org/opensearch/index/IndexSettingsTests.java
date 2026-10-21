        settings.updateIndexMetadata(newIndexMeta("index", Settings.EMPTY));
            Settings.builder()
        IndexSettings settings = newIndexSettings(newIndexMeta("index", theSettings), Settings.EMPTY, integerSetting, notUpdated);
            settings.updateIndexMetadata(
        final ByteSizeValue actual = ByteSizeValue.parseBytesSizeValue(newSize.getBytes() + "B", key);
    }
    }
    }
        Settings indexSettings = Settings.builder()
        settings = new IndexSettings(metadata, Settings.EMPTY);
            "index",
 */
    }
        settings.updateIndexMetadata(
        Settings indexSettings = Settings.builder()
            "index",
    public static IndexMetadata newIndexMeta(String name, Settings indexSettings) {
                false
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
            newIndexMeta(
            TimeValue.parseTimeValue(
        assertTrue(settings.isDerivedSourceEnabledForTranslog());
            );
        IndexSettings settings = newIndexSettings(metadata, Settings.EMPTY);
        }
        IndexSettings settings = newIndexSettings(newIndexMeta("index", theSettings), Settings.EMPTY, integerSetting);
        Settings theSettings = Settings.builder()
     * The precedence against the cluster setting is exercised in {@code RemoteStoreRefreshListenerTests}, which owns
        final AtomicInteger integer = new AtomicInteger(0);
            .build();
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            IndexMetadata metadata = newIndexMeta(
                Settings.builder(),
 *
        }
 * Licensed to Elasticsearch under one or more contributor
}
        integer.set(0);
                    .build()
        int start = -1;
    public void testMaxResultWindow() {
        assertSame(nodeSettings, settings.getNodeSettings());
    /**
        assertEquals("repo1", settings.getRemoteStoreRepository());
        final Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_UPGRADED, Version.V_EMPTY).build();
        metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build());
        }
        IndexMetadata metadata = newIndexMeta("index", Settings.builder().build());
     */
        );
    }
                .put(IndexMetadata.SETTING_INDEX_UUID, "0xdeadbeef")
            newIndexMeta(
        );
            () -> IndexScopedSettings.DEFAULT_SCOPED_SETTINGS.validate(
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        Settings indexSettings = Settings.builder()
                    "index",
            )
    }
            TimeValue.parseTimeValue(
        assertTrue(
            "index",
        );
            )
                .put(IndexSettings.INDEX_DERIVED_SOURCE_TRANSLOG_ENABLED_SETTING.getKey(), true)
    }
        assertFalse(settings.isFlushOnUncommittedSegmentsThresholdSizeExplicit());
                    ),
        assertThat(index.getDefaultFields(), equalTo(Collections.singletonList("body")));
    }
                        (randomBoolean() ? -1 : new TimeValue(-1, TimeUnit.MILLISECONDS)).toString()
        settings.updateIndexMetadata(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertTrue(settings.isFlushOnUncommittedSegmentsThresholdSizeExplicit());
            newIndexMeta("index", Settings.EMPTY),
    }
        IndexMetadata metadata = newIndexMeta(
        IndexMetadata metadata = newIndexMeta(
        );
    }
        IndexMetadata metadata = newIndexMeta(
        );
        );
            IllegalArgumentException.class,
        IndexMetadata newMetadata = newIndexMeta(
        IndexMetadata metadata = newIndexMeta("index", Settings.builder().build());
        // Test 5: If derived source is disabled then translog setting value should also be disabled
        );
            ).getMillis(),
                Settings.builder()
                Settings.builder()
                .build()
                    .put(IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.getKey(), "10m")
            .put(IndexMetadata.SETTING_INGESTION_SOURCE_TYPE, "kafka")
        assertEquals(IndexSettings.MAX_DOCVALUE_FIELDS_SEARCH_SETTING.get(Settings.EMPTY).intValue(), settings.getMaxDocvalueFields());
    }
    public void testPeriodicFlushIntervalExplicitValue() {
                    "index",
        IndexMetadata metadata = newIndexMeta(
                new TimeValue(1, TimeUnit.DAYS),
     * the resolution.
        assertEquals(new ByteSizeValue(64, ByteSizeUnit.MB), settings.getFlushOnUncommittedSegmentsThresholdSize());
        ByteSizeValue actualValue = ByteSizeValue.parseBytesSizeValue(
            );
            "index",
        IndexMetadata metadata = newIndexMeta("index", settings.build());
        assertTrue(settings.isDerivedSourceEnabledForTranslog());
        );
            .put(IndexMetadata.SETTING_INDEX_UUID, "0xdeadbeef")
                "index",
            newIndexMeta("index", Settings.builder().put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), "request").build())
    }
            Settings.builder()
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                    Settings.builder().put(settings.getIndexMetadata().getSettings()).put("index.not.updated", "boom").build()
        metadata = newIndexMeta(
import java.util.Collections;
    public void testRemoteStoreExplicitSetting() {
            assert false : "should not have been invoked, no unknown settings";
            start = 0;
        int refreshIntervalInt = randomFrom(start, Math.abs(randomInt()));
    public void testUpdateRemoteTranslogBufferInterval() {
        assertEquals(IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING.get(Settings.EMPTY).intValue(), settings.getMaxInnerResultWindow());
            Settings.builder()
    }
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
    public void testSetRemoteTranslogBufferIntervalDefaultSetting() {
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false)
        assertEquals(numReplicas, settings.getNumberOfReplicas());
        settings.getScopedSettings().addSettingsUpdateConsumer(integerSetting, integer::set);
        assertTrue(
                + "future release! See the breaking changes documentation for the next major version."
            settings.updateIndexMetadata(
                .put(IndexMetadata.SETTING_INGESTION_SOURCE_TYPE, "kafka")
        assertWarnings(
        );
                "index",
            Settings.builder().put(settings.getIndexMetadata().getSettings()).put("index.test.setting.int", 42).build()
                Settings.builder().put("index.soft_deletes.enabled", randomBoolean()).build(),
        if (randomBoolean()) {
            (e, ex) -> {
        );
                assertThat(e.getValue(), equalTo("-200"));
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
import java.util.Set;
 *
 * this file be licensed under the Apache-2.0 license or a
                newGCDeleteSetting.getStringRep(),
            ),
    public void testRemoteStoreAutoRestoreRequiresFencing() {
                IllegalArgumentException.class,
        IndexMetadata metadata = newIndexMeta(
        try {
        assertEquals(
        );
        IndexSettings settings = newIndexSettings(newIndexMeta("index", theSettings), nodeSettings);
    }
        }
            newIndexMeta(
            Settings.builder()
            .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), createdVersion)
        IllegalArgumentException iae = expectThrows(
        );
                    Settings.builder()
                newIndexMeta(
        IndexScopedSettings settings = new IndexScopedSettings(Settings.EMPTY, IndexScopedSettings.BUILT_IN_INDEX_SETTINGS);
        settings.updateIndexMetadata(
        {
                assertThat(e.getKey(), equalTo("index.unknown"));
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
        // Verify default value
        IllegalArgumentException iae = expectThrows(
        SettingsException error = expectThrows(
            newIndexMeta("index", Settings.builder().put(IndexSettings.MAX_ADJACENCY_MATRIX_FILTERS_SETTING.getKey(), 42).build())
        assertEquals("foo", settings.getDefaultSearchPipeline());
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
 * specific language governing permissions and limitations
            .put(IndexMetadata.SETTING_INDEX_UUID, "0xdeadbeef")
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
            },
        final ByteSizeValue actualValue = ByteSizeValue.parseBytesSizeValue(size.getBytes() + "B", key);
            final SettingsException e = expectThrows(
        // Test 4: Dynamic update - valid case
            Settings.builder().put("index.query.default_field", "body").build()
            .put(IndexMetadata.SETTING_VERSION_CREATED, version)
        );
        assertEquals(metadata.getSettings(), settings.getSettings());
        settings.updateIndexMetadata(newIndexMeta("index", Settings.builder().put(key, newSize.getBytes() + "B").build()));
                .build()
                .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "repo1")
        );
        Setting<Integer> integerSetting = Setting.intSetting("index.foo.bar", -1, Property.Dynamic, Property.IndexScope);
        assertEquals(100, settings.getMaxScriptFields());
        assertFalse(settings.isRemoteStoreEnabled());
        settings.getScopedSettings().addSettingsUpdateConsumer(integerSetting, indexValue::set);
                )
            Settings.builder()
                .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), translogFlushThresholdSize.getBytes() + "B")
            "index",
        assertEquals(version, settings.getIndexVersionCreated());
            Settings.builder()
        IndexScopedSettings settings = new IndexScopedSettings(Settings.EMPTY, IndexScopedSettings.BUILT_IN_INDEX_SETTINGS);
        );
        TimeValue defaultValue = IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.get(indexSettings);
 * compatible open source license.
            .build();
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        );
        Setting<String> notUpdated = new Setting<>("index.not.updated", "", Function.identity(), Property.Dynamic, Property.IndexScope);
        }, (e, ex) -> { assert false : "should not have been invoked, no invalid settings"; });
        final StringBuilder builder = new StringBuilder();
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertEquals(
            () -> IndexMetadata.INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING.get(indexSettings)
                    "index",
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
        assertEquals(Integer.toString(Version.CURRENT.id), settings.get("index.version.created"));
            )
    public void testRemoteRepositoryExplicitSetting() {
    }
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        Settings indexSettings = Settings.builder()
            // validation should fail since we are not ignoring archived settings
            Settings.builder()
 * You may obtain a copy of the License at
        settings.updateIndexMetadata(newIndexMeta("index", Settings.EMPTY));
            "index",
        assertEquals(Translog.Durability.REQUEST, settings.getTranslogDurability()); // test default
            newIndexMeta("index", Settings.builder().put(IndexSettings.MAX_DOCVALUE_FIELDS_SEARCH_SETTING.getKey(), 50).build())
        );
import org.opensearch.index.translog.Translog;
            newIndexMeta("index", Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), newRefreshInterval).build())
    public void testUpdateDerivedSourceFails() {
    public void testSetRemoteTranslogRepositoryFailsWhenEmptyString() {
            SettingsException.class,
                newIndexMeta(
    }
            Settings.builder()
        assertEquals(-1, settings.getGcDeletesInMillis());
            // validation should fail since we are not ignoring archived settings
    public void testSoftDeletesDefaultSetting() {
            final SettingsException e = expectThrows(
    public void testSetRemoteTranslogBufferIntervalFailsWhenEmpty() {
        );
                    .build()
                    )
        assertEquals(IndexSettings.MAX_SCRIPT_FIELDS_SETTING.get(Settings.EMPTY).intValue(), settings.getMaxScriptFields());
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
            assertTrue(e.getMessage(), e.getMessage().contains("failed to parse value [" + invalid + "]"));
        assertEquals(IndexSettings.MAX_SCRIPT_FIELDS_SETTING.get(Settings.EMPTY).intValue(), settings.getMaxScriptFields());
import static org.hamcrest.CoreMatchers.equalTo;
            .put(IndexMetadata.SETTING_INDEX_UUID, "test-uuid")
            newIndexMeta("index", Settings.builder().put(IndexSettings.MAX_REGEX_LENGTH_SETTING.getKey(), 101).build())
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
            String.format(
        settings.updateIndexMetadata(newIndexMeta("index", Settings.EMPTY));
    public void testMaxDocvalueFields() {
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
    public void testRemoteTranslogRepoDefaultSetting() {
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
        );
        Settings settings = IndexScopedSettings.DEFAULT_SCOPED_SETTINGS.archiveUnknownOrInvalidSettings(Settings.EMPTY, e -> {
        assertEquals(0, integer.get());
        assertTrue(
        assertEquals(SearchPipelineService.NOOP_PIPELINE_ID, settings.getDefaultSearchPipeline());
        indexScopedSettings.validate(settings, randomBoolean(), randomBoolean(), true);
    }
            TimeValue.parseTimeValue(
        }
    public void testFlushOnUncommittedSegmentsEnabledHasNoIndexScopedSetting() {
        );
    public void testUpdateSoftDeletesFails() {
        metadata = newIndexMeta(
        );
                    .build()
        }
        );
        assertEquals(42, integer.get());
            .build();
            .put("index.foo.bar", 0)
            (e, ex) -> { assert false : "should not have been invoked, no invalid settings"; }
            if (i == 42) throw new AssertionError("boom");
    public void testIgnoreTranslogRetentionSettingsIfSoftDeletesEnabled() {
            .put(IndexMetadata.SETTING_VERSION_CREATED, version)
            Settings.builder()
        IndexMetadata metadata = newIndexMeta(
        settings = new IndexSettings(metadata, Settings.EMPTY);
    /**
            "index",
        assertEquals(version, settings.getIndexVersionCreated());
        ByteSizeValue translogFlushThresholdSize = new ByteSizeValue(Math.abs(randomInt()));
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                newIndexMeta("index", Settings.builder().put(theSettings).put("index.test.setting.int", 41).build())
            assertTrue(IndexSettings.INDEX_SOFT_DELETES_SETTING.get(settings));
        assertEquals(42, integer.get());
                "Setting %s should be provided with non-empty repository ID",
        );
        );
        assertEquals("", builder.toString());
        assertEquals(TimeValue.timeValueMinutes(10), defaultValue);
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
    }
                assertThat(e.getValue(), equalTo("foo"));
                SettingsException.class,
            newIndexMeta(
        IllegalArgumentException iae = expectThrows(
            Settings.builder()
 */
 * Unless required by applicable law or agreed to in writing,
            .build();
                .put(IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey(), true)
        assertEquals(42, indexValue.get());
        );
                IndexSettings.INDEX_GC_DELETES_SETTING.getKey()
            // validation should fail since we are not ignoring private settings
        );
        TimeValue gcDeleteSetting = new TimeValue(Math.abs(randomInt()), TimeUnit.MILLISECONDS);
import org.opensearch.core.common.unit.ByteSizeValue;
        IndexSettings settings = newIndexSettings(newIndexMeta("index", theSettings), nodeSettings, integerSetting);
        settings = new IndexSettings(metadata, Settings.EMPTY);
import org.opensearch.indices.replication.common.ReplicationType;
            e -> {
            .put(IndexMetadata.SETTING_REMOTE_STORE_AUTO_RESTORE_ENABLED, true)
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "repo1")
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
    }
        IndexMetadata metadata = newIndexMeta(
import org.opensearch.common.SuppressForbidden;
        );
    public void testPartitionMinSegmentSizeDefault() {
        assertEquals("segment", INDEX_CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.get(settings.getSettings()));
        Settings nodeSettings = Settings.builder().put("index.foo.bar", 43).build();
        if (randomBoolean()) {
        }
        settings.updateIndexMetadata(
            refreshInterval += randomFrom("s", "ms", "h");
    }
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        assertEquals(numShards, settings.getNumberOfShards());
                .build()
            Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build()
                    .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), newTranslogFlushThresholdSize.getBytes() + "B")
 * Modifications Copyright OpenSearch Contributors. See
        IndexSettings indexSettings = new IndexSettings(metadata, Settings.EMPTY);
        assertEquals(50, settings.getMaxDocvalueFields());
                new TimeValue(1, TimeUnit.DAYS),
            settings.updateIndexMetadata(
        settings.updateIndexMetadata(newIndexMeta("index", Settings.EMPTY));
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        indexSettings.updateIndexMetadata(newIndexMeta("index", newSettings.build()));
        );
            IndexSettings.MAX_ADJACENCY_MATRIX_FILTERS_SETTING.get(Settings.EMPTY).intValue(),
        Settings indexSettings = Settings.builder()
        String bufferInterval = getRandomTimeString(true);
            assertTrue(ex.getMessage(), ex.getMessage().startsWith("version mismatch on settings update expected: "));
        index.updateIndexMetadata(newIndexMeta("index", Settings.builder().putList("index.query.default_field", "body", "title").build()));
                new TimeValue(1, TimeUnit.DAYS),
        );
            Settings.builder()
        settings = new IndexSettings(metadata, Settings.EMPTY);
        );
            Settings.builder()
        );
        assertThat(error.getMessage(), equalTo("final index setting [index.soft_deletes.enabled], not updateable"));
            ),
        IndexMetadata metadata = newIndexMeta(
        Settings indexSettings = Settings.builder()
                )
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey()
        settings.getScopedSettings().addSettingsUpdateConsumer(integerSetting, integer::set);
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        } catch (IllegalArgumentException ex) {
 * license agreements. See the NOTICE file distributed with
    }
import org.opensearch.common.settings.SettingsException;
        } catch (IllegalArgumentException ex) {
            settings.put(IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.getKey(), randomPositiveTimeValue());
                .build()
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false)
        assertEquals(Translog.Durability.REQUEST, settings.getTranslogDurability());
            Settings.builder()
        if (refreshIntervalInt >= 0) {
                "index",
        );
            "index",
        );
 * KIND, either express or implied.  See the License for the
            Settings.builder()
        assertEquals("tlog-store", settings.getRemoteStoreTranslogRepository());
            settings.getMaxAdjacencyMatrixFilters()
        SettingsException error = expectThrows(
        assertFalse(settings.isDerivedSourceEnabledForTranslog());
        assertEquals(actualValue, settings.getFlushThresholdSize());
            () -> IndexMetadata.INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING.get(indexSettings)
    public void testQueryDefaultField() {
        assertEquals(
    public void testRemoteRepositoryDefaultSetting() {
                )
    @SuppressForbidden(reason = "sets the SEARCH_PIPELINE feature flag")
        assertSame(settings.getIndexMetadata(), newMetadata);
                SettingsException.class,
            .put(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), "")
        IndexMetadata metadata = newIndexMeta(
                IndexMetadata.SETTING_REMOTE_STORE_ENABLED
            )
                .build()
    public void testGCDeletesSetting() {
                Locale.ROOT,
                SettingsException.class,
        );
        assertNull(settings.getRemoteStoreRepository());
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertFalse(settings.updateIndexMetadata(metadata));
        final IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
                Settings.builder(),
        );
import org.opensearch.core.common.unit.ByteSizeUnit;
        // Test 1: Valid case - when derived source is enabled
            ),
            newIndexMeta(
        assertEquals(
        );
            )
            )
            },
        assertEquals("boom", builder.toString());
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
            TimeValue.parseTimeValue(
                Settings.builder()
                Settings.builder(),
        );
        settings.updateIndexMetadata(newIndexMeta("index", Settings.EMPTY));
        assertEquals("", builder.toString());
    public void testArchiveBrokenIndexSettings() {
        );
            "index",
            .put(IndexMetadata.SETTING_INDEX_UUID, "test-uuid")
        IllegalArgumentException iae = expectThrows(
        assertEquals(Version.fromString("99.99.99"), settings.getIndexVersionCreated());
                .put("index.version.created", Version.CURRENT.id) // private setting
        Settings indexSettings = Settings.builder()
        settings.updateIndexMetadata(newIndexMeta("index", Settings.EMPTY));
/*
        settings = new IndexSettings(metadata, Settings.EMPTY);
    public void testPartitionStrategyValidValues() {
                gcDeleteSetting.getStringRep(),
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "repo1")
                .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), "async")
        );
        assertEquals(
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "")
        // Update to disabled (-1)
                    "index",
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    }
        assertTrue(
package org.opensearch.index;
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
            )
                "index",
    }
            settings.getRefreshInterval()
                        IndexSettings.INDEX_GC_DELETES_SETTING.getKey(),
            Settings.builder()
            "index",
    public void testArchivedSettingsValidation() {
        IndexSettings settings = newIndexSettings(newIndexMeta("index", theSettings), Settings.EMPTY, integerSetting);
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
 * this work for additional information regarding copyright
        );
            .build();
    public void testTranslogFlushSizeThreshold() {
        Version version = VersionUtils.getPreviousVersion();
                Locale.ROOT,
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(TimeValue.MINUS_ONE, defaultValue);
import org.opensearch.search.pipeline.SearchPipelineService;
import org.opensearch.Version;
        }
                    .build()
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
        assertFalse(settings.isRemoteTranslogStoreEnabled());
        IndexMetadata metadata = newIndexMeta(
        assertEquals(TimeValue.timeValueMinutes(5), value);
            .build();
import java.util.Locale;
        settings.updateIndexMetadata(
        assertFalse(settings.isDerivedSourceEnabledForTranslog());
        assertTrue(iae.getMessage(), iae.getMessage().contains("can only be enabled when"));
        assertThat(error.getMessage(), equalTo("final index setting [index.derived_source.enabled], not updateable"));
        );
                .put(IndexSettings.INDEX_WARMER_ENABLED_SETTING.getKey(), false)
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        );
            translogFlushThresholdSize.getBytes() + "B",
    }
        );
        Settings prevSettings = settings; // no double archive
            fail("version has changed");
        final int numShards = randomIntBetween(1, 10);
import java.util.HashSet;
 * SPDX-License-Identifier: Apache-2.0
            )
        assertEquals(TimeValue.MINUS_ONE, settings.getPeriodicFlushInterval());
        );
        assertEquals(0, integer.get());
            () -> settings.updateSettings(
        try {
        }
                Settings.builder(),
        );
            Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).put(key, size.getBytes() + "B").build()
        );
            Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build()
        IndexMetadata metadata = newIndexMeta(
                Settings.builder()
        final Settings settings = Settings.builder()
            "index",
        );
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
     * default, reports whether the index set it explicitly (which is what makes it win over the cluster default at the
        Settings indexSettings = Settings.builder()
            )
        Settings settings = Settings.builder()
        metadata = newIndexMeta(
        final IndexScopedSettings indexScopedSettings = new IndexScopedSettings(settings, IndexScopedSettings.BUILT_IN_INDEX_SETTINGS);
        settings.getScopedSettings().addSettingsUpdateConsumer(notUpdated, builder::append);
 *     http://www.apache.org/licenses/LICENSE-2.0
            );
        }
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            IndexSettings.DEFAULT_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE,
            assertThat(e, hasToString(containsString("unknown setting [index.version.upgraded]")));
            Settings.builder()
        );
            .put(IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.getKey(), "5m")
            );
            .build();
        assertEquals("-200", settings.get("archived.index.refresh_interval"));
        );
            IllegalArgumentException.class,
        );
                .build()
            assert false : "should not have been invoked, no unknown settings";
                    Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).put("index.test.setting.int", 42).build()
                .build()
            newIndexMeta(
            )
            "index",
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
import org.opensearch.common.settings.Setting.Property;
import java.util.function.Function;
        String refreshInterval = Integer.toString(refreshIntervalInt);
                )
                .build()
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
        }
        // removing it puts the index back on the cluster default, which the publication site resolves
        );
        settings = new IndexSettings(metadata, Settings.EMPTY);
            "Settings index.remote_store.translog.repository can only be set/enabled when index.remote_store.enabled is set to true",
                IndexSettings.INDEX_GC_DELETES_SETTING.getKey()
                )
            ),
        // Update to 10 minutes
            settings.updateIndexMetadata(
        // Test that regular indices have periodic flush disabled by default
            settings.updateIndexMetadata(
            "[index.max_adjacency_matrix_filters] setting was deprecated in OpenSearch and will be removed in a "
        assertEquals(0, integer.get());
                .build()
    public void testMaxRegexLengthSetting() {
     * Verifies the index scoped {@code index.remote_store.flush_on_uncommitted_segments.threshold_size}: it has a
    }
        settings.updateIndexMetadata(
        );
            "index",
        final AtomicInteger indexValue = new AtomicInteger(0);
        assertEquals(41, integer.get());
            "index",
        {
        assertEquals(
        );
            "index",
        assertTrue(
        assertNull(settings.getRemoteStoreRepository());
    }
        IllegalArgumentException iae = expectThrows(
            Settings.builder().put(INDEX_CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE.getKey(), 100_000).build()
        if (randomBoolean()) {
        assertSame(prevSettings, settings);
            IllegalArgumentException.class,
        assertEquals("0xdeadbeef", settings.getUUID());
    public void testMaxScriptFields() {
        assertEquals(42, settings.getMaxResultWindow());
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        }, (e, ex) -> { assert false : "should not have been invoked, no invalid settings"; });
            IllegalArgumentException.class,
        assertEquals(metadata.getSettings(), settings.getSettings());
        assertFalse(settings.isWarmerEnabled());
        assertFalse(settings.isFlushOnUncommittedSegmentsThresholdSizeExplicit());
        IllegalArgumentException iae = expectThrows(
        assertEquals(TimeValue.timeValueMillis(650), IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.get(settings));
            Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build()
        settings = IndexScopedSettings.DEFAULT_SCOPED_SETTINGS.archiveUnknownOrInvalidSettings(prevSettings, e -> {
        metadata = newIndexMeta(
            .put(AbstractScopedSettings.ARCHIVED_SETTINGS_PREFIX + "foo", System.currentTimeMillis())
            "index",
                refreshInterval,
        settings.updateIndexMetadata(
                .build()
        assertEquals(
        assertEquals("_na_", settings.getUUID());
                newIndexMeta("index", Settings.builder().put(theSettings).put("index.test.setting.int", 42).build())
            IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey()
import org.opensearch.test.VersionUtils;
                    .put(metadata.getSettings())
        Version version = VersionUtils.getPreviousVersion();
        );
            Settings settings = Settings.builder().put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), createdVersion).build();
                )
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
                () -> indexScopedSettings.validate(settings, randomBoolean(), randomBoolean(), false)
    public void testDefaultSearchPipeline() throws Exception {
            "index",
        assertEquals(15, settings.getMaxAdjacencyMatrixFilters());
        settings.updateIndexMetadata(
        );
            Settings.builder()
     * Test private setting validation for private settings defined in {@link IndexScopedSettings#isPrivateSetting(String)}
    }
            "index",
        IndexMetadata metadata = newIndexMeta(
        settings.updateIndexMetadata(
            newSettings.put(IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.getKey(), between(1, 1024) + "b");
                Settings.builder().put("index.remote_store.flush_on_uncommitted_segments.enabled", false).build(),
        return new IndexSettings(metadata, nodeSettings, new IndexScopedSettings(Settings.EMPTY, settingSet));
        return refreshInterval;
        );
        // enabled by default on 7.0+ or later
            TimeValue.parseTimeValue(
            );
        IndexMetadata metadata = newIndexMeta(
                "index",
                        .build()
            IndexSettings.MAX_ADJACENCY_MATRIX_FILTERS_SETTING.get(Settings.EMPTY).intValue(),
                    .build()
            () -> IndexMetadata.INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING.get(indexSettings)
                .build()
            "index",
 * The OpenSearch Contributors require contributions made to
import org.opensearch.common.settings.IndexScopedSettings;
        if (randomBoolean()) {
        settings.updateIndexMetadata(
        assertEquals(200, settings.getMaxDocvalueFields());
        settings.updateIndexMetadata(
        final String key = IndexSettings.INDEX_TRANSLOG_GENERATION_THRESHOLD_SIZE_SETTING.getKey();
            .put(IndexMetadata.SETTING_VERSION_CREATED, version)
            "index",
    }
        settings.updateIndexMetadata(newIndexMeta("index", Settings.EMPTY));
        assertEquals(
            e -> {
        assertEquals(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY).intValue(), settings.getMaxResultWindow());
        assertTrue(settings.isWarmerEnabled());
                .build()
        {
        assertEquals(TimeValue.timeValueMinutes(10), settings.getPeriodicFlushInterval());
        );
            )
            .build();
    }
    public void testPeriodicFlushIntervalDynamicUpdate() {
        );
    }
    }
        assertTrue("Index should be on remote node", settings.isAssignedOnRemoteNode());
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
        assertThat(indexSettings.getTranslogRetentionAge().millis(), equalTo(-1L));
    public void testMergedSettingsArePassed() {
                        "index",
        ByteSizeValue newTranslogFlushThresholdSize = new ByteSizeValue(Math.abs(randomInt()));
        assertEquals(500_000, (int) INDEX_CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE.get(settings.getSettings()));
            settings.updateIndexMetadata(
            SettingsException.class,
            ),
            settings.put(IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.getKey(), between(1, 1024) + "b");
                .put(IndexSettings.MAX_SCRIPT_FIELDS_SETTING.getKey(), 100)
        settings = IndexScopedSettings.DEFAULT_SCOPED_SETTINGS.archiveUnknownOrInvalidSettings(
    }
    public void testMaxAdjacencyMatrixFiltersSetting() {
        assertEquals(200, settings.getMaxInnerResultWindow());
        assertFalse(settings.updateIndexMetadata(metadata));
        Settings theSettings = Settings.builder()
        );
    }
        assertSame(settings, Settings.EMPTY);
            Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.fromString("99.99.99")).build()
        // nothing should happen since we are ignoring archived settings
        // Test 2: Invalid case - setting read preference when derived source is disabled
                Settings.builder().put(INDEX_CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), strategy).build()
            "index",
                .build()
        SettingsException e = expectThrows(
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
 * not use this file except in compliance with the License.
    public void testSetRemoteRepositoryFailsWhenEmptyString() {
                .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), refreshInterval)
            .put(IndexMetadata.SETTING_INDEX_UUID, "0xdeadbeef")
                    Settings.EMPTY
        );
    public void testSettingsConsistency() {
        );
        assertEquals(101, settings.getMaxRegexLength());
    public void testPrivateSettingsValidation() {
                    .put(IndexMetadata.SETTING_INGESTION_SOURCE_TYPE, "kafka")
        final AtomicInteger integer = new AtomicInteger(0);
            assertThat(e, hasToString(containsString("unknown setting [index.version.upgraded]")));
            .build();
            fail("uuid missing/change");
    /** Enablement is cluster-only: there is deliberately no index scoped counterpart, so index scope rejects the key. */
        );
    public IndexSettings newIndexSettings(IndexMetadata metadata, Settings nodeSettings, Setting<?>... settings) {
        assertEquals(TimeValue.timeValueMinutes(10), settings.getPeriodicFlushInterval());
            // validation should fail since we are not ignoring private settings
        Settings indexSettings = Settings.builder()
        for (String strategy : new String[] { "segment", "balanced", "force" }) {
import static org.hamcrest.object.HasToString.hasToString;
        settings.getScopedSettings().addSettingsUpdateConsumer(integerSetting, integer::set, (i) -> {
        Setting<Integer> integerSetting = Setting.intSetting("index.test.setting.int", -1, Property.Dynamic, Property.IndexScope);
        assertEquals(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY).intValue(), settings.getMaxResultWindow());
    }
                        .build()
        assertEquals(
        Settings theSettings = Settings.builder()
            )
        assertEquals(15, settings.getMaxResultWindow());
            IllegalArgumentException.class,
            .put("index.remote_store.enabled", true)
        assertEquals(
        Version version = VersionUtils.getPreviousVersion();
    public void testDefaultPeriodicFlushIntervalForRegularIndex() {
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
            .put("index.replication.type", ReplicationType.DOCUMENT)
                newIndexMeta(
        assertEquals("To enable index.remote_store.enabled, index.replication.type should be set to SEGMENT", iae.getMessage());
        Version version = VersionUtils.getPreviousVersion();
                "index",
                        .put("index.foo.bar", 42)
            final SettingsException e = expectThrows(
                        Settings.builder()
            Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build()
            () -> IndexScopedSettings.DEFAULT_SCOPED_SETTINGS.validate(withoutFencing, true)
            newIndexMeta("index", Settings.builder().put(IndexSettings.MAX_RESULT_WINDOW_SETTING.getKey(), 42).build())
        // Test 3: Default(Derived) behavior - no read preference set
                .build()
                new TimeValue(1, TimeUnit.DAYS),
        settings.updateIndexMetadata(
        assertEquals(
    public void testDefaultPeriodicFlushIntervalForPullBasedIngestionIndex() {
            () -> IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.get(indexSettings)
                IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey()
        assertEquals(actualValue, settings.getGenerationThresholdSize());
            )
        );
    public void testIsWarmerEnabled() {
        IndexMetadata metadata = newIndexMeta(
        assertThat(indexSettings.getTranslogRetentionAge().millis(), equalTo(-1L));
        assertEquals(Translog.Durability.ASYNC, settings.getTranslogDurability());
        assertEquals("Setting index.remote_store.translog.repository should be provided with non-empty repository ID", iae.getMessage());
    /**
            newIndexMeta("index", Settings.builder().put(IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING.getKey(), 50).build())
        );
        });
        String newBufferInterval = getRandomTimeString(true);
                .build()
        assertThat(index.getDefaultFields(), equalTo(Arrays.asList("body", "title")));
                newRefreshInterval,
            final SettingsException e = expectThrows(
                            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        }
                newBufferInterval,
        IndexMetadata metadata = newIndexMeta(
    }
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        expectThrows(
        settings = new IndexSettings(metadata, Settings.EMPTY);
            newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build()),
        assertThat(index.getDefaultFields(), equalTo(Collections.singletonList("*")));
            );
import org.opensearch.common.settings.AbstractScopedSettings;
    private String getRandomTimeString(boolean nonNegativeOnly) {
        metadata = newIndexMeta(
    public void testMaxInnerResultWindow() {
            TimeValue.parseTimeValue(
    public void testRefreshInterval() {
        IndexScopedSettings.DEFAULT_SCOPED_SETTINGS.validate(withFencing, true); // must not throw
                            .build()
        settings.updateIndexMetadata(metadata);
        index = newIndexSettings(
        Settings theSettings = Settings.builder()
    }
                bufferInterval,
        Setting<Integer> integerSetting = Setting.intSetting("index.test.setting.int", -1, Property.Dynamic, Property.IndexScope);
        }
    }
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import org.opensearch.cluster.metadata.IndexMetadata;
    public void testSettingsUpdateValidator() {
            "index",
    }
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        IndexSettings index = newIndexSettings(newIndexMeta("index", Settings.EMPTY), Settings.EMPTY);
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                    .put(IndexMetadata.SETTING_INGESTION_SOURCE_TYPE, "kafka")
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas + 1)
        assertEquals("foo", settings.get("archived.index.unknown"));
    }
                IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey()
                .build(),
        assertEquals(100_000, (int) INDEX_CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE.get(settings.getSettings()));
        );
    }
        assertEquals(0, indexValue.get());
        assertEquals("_na_", settings.getUUID());
import org.opensearch.common.settings.Setting;
        assertEquals(42, settings.getMaxAdjacencyMatrixFilters());
    }
        assertEquals(IndexSettings.MAX_REGEX_LENGTH_SETTING.get(Settings.EMPTY).intValue(), settings.getMaxRegexLength());
        Settings withoutFencing = Settings.builder()
     * node membership while the departed primary may still be alive, and only the fence stops it acknowledging
            settings.updateIndexMetadata(
/*
            .build();
            "index",
    public void testRemoteTranslogStoreDefaultSetting() {
        );
                Settings.builder()
        indexScopedSettings.validate(settings, randomBoolean(), true, randomBoolean());
        IndexSettings settings = newIndexSettings(metadata, Settings.EMPTY);
                    newIndexMeta(
        ByteSizeValue actualNewTranslogFlushThresholdSize = ByteSizeValue.parseBytesSizeValue(
        assertEquals("not updated - we preserve the old settings", 0, integer.get());
 * ownership. Elasticsearch licenses this file to you under
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        );
        );
        assertThat(indexSettings.getTranslogRetentionSize().getBytes(), equalTo(-1L));
                .build()
        metadata = newIndexMeta(
        );
            .build();
        for (String invalid : new String[] { "0b", "-1" }) {
                    .put(IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.getKey(), "-1")
        IndexMetadata metadata = newIndexMeta(
        TimeValue newGCDeleteSetting = new TimeValue(Math.abs(randomInt()), TimeUnit.MILLISECONDS);
            IllegalArgumentException.class,
            ).getMillis(),
                newIndexMeta("index", Settings.builder().put(theSettings).put("index.test.setting.int", 42).build())
                IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey()
        IllegalArgumentException iae = expectThrows(
        IndexMetadata metadata = newIndexMeta(
        );
                assertThat(e.getKey(), equalTo("index.refresh_interval"));
 * the Apache License, Version 2.0 (the "License"); you may
            newIndexMeta(
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // Test that ingestion indices have periodic flush enabled by default
        assertEquals(actualNewTranslogFlushThresholdSize, settings.getFlushThresholdSize());
                "index",
                .put("index.unknown", "foo")
        assertNull(settings.getRemoteStoreRepository());
            "index",
                newIndexMeta(
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false)
     */
        assertThat(indexSettings.getTranslogRetentionSize().getBytes(), equalTo(-1L));
                "index",
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        );
            .build();
        IndexMetadata metadata = newIndexMeta(
        settings.updateIndexMetadata(
            settingSet.addAll(Arrays.asList(settings));
        Settings.Builder settings = Settings.builder()
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .put(IndexMetadata.SETTING_INDEX_UUID, "0xdeadbeef")
        assertEquals(
     */
        settings.updateIndexMetadata(
        );
            )
    }
    public void testPartitionMinSegmentSizeCustom() {
            .build();
            "failed to parse setting [index.remote_store.translog.buffer_interval] with value [] as a time value: unit is missing or unrecognized",
            .put(IndexMetadata.SETTING_VERSION_CREATED, version)
                .put(IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING.getKey(), 200)
                .put(IndexSettings.MAX_RESULT_WINDOW_SETTING.getKey(), 15)
            () -> settings.updateSettings(
        );
        assertEquals(IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING.get(Settings.EMPTY).intValue(), settings.getMaxInnerResultWindow());
        assertEquals(metadata.getSettings(), settings.getSettings());
                .put(IndexSettings.MAX_ADJACENCY_MATRIX_FILTERS_SETTING.getKey(), 15)
        assertEquals("0xdeadbeef", settings.getUUID());
    public void testUpdateDurability() {
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY,
     * writes the restored copy will never see.
            IllegalArgumentException e = expectThrows(
                "index",
        final int numReplicas = randomIntBetween(0, 10);
        // nothing should happen since we are ignoring private settings
                .put("index.refresh_interval", "2s")
        IndexSettings settings = new IndexSettings(
        );
        assertFalse(settings.isDerivedSourceEnabledForTranslog());
            () -> IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.get(indexSettings)
        assertEquals(
            settings.getRemoteTranslogUploadBufferInterval()
        settings = new IndexSettings(metadata, Settings.EMPTY);
        settings = new IndexSettings(metadata, Settings.EMPTY);
            IllegalArgumentException.class,
                    .build()
            "index",
            .put(IndexMetadata.SETTING_INGESTION_SOURCE_TYPE, "kafka")
                () -> indexScopedSettings.validate(settings, randomBoolean())
                "Settings %s can only be set/enabled when %s is set to true",
                .put(IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey(), false)
            Settings.builder()
        IndexSettings settings = newIndexSettings(metadata, Settings.EMPTY);
        }
    public void testFlushOnUncommittedSegmentsThresholdSize() {
        final IndexMetadata metadata = newIndexMeta(
            settings.getGcDeletesInMillis()
                Settings.builder()
        assertNull(settings.get("index.refresh_interval"));
            .put(indexSettings)
                            .put(IndexSettings.INDEX_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE_SETTING.getKey(), invalid)
import org.opensearch.common.unit.TimeValue;
        assertEquals(IndexSettings.MAX_DOCVALUE_FIELDS_SEARCH_SETTING.get(Settings.EMPTY).intValue(), settings.getMaxDocvalueFields());
                Settings.builder().put("index.derived_source.enabled", randomBoolean()).build(),
    public void testRemoteTranslogExplicitSetting() {
            .put(IndexMetadata.SETTING_INDEX_UUID, "test-uuid")
        );
            assertEquals(strategy, INDEX_CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.get(settings.getSettings()));
                .build()
                    .put(IndexSettings.INDEX_DERIVED_SOURCE_TRANSLOG_ENABLED_SETTING.getKey(), false)
            )
                "index"
            }
    }
        assertEquals(50, settings.getMaxInnerResultWindow());
    }
                .put(IndexSettings.INDEX_GC_DELETES_SETTING.getKey(), gcDeleteSetting.getStringRep())
                .put(IndexSettings.MAX_REGEX_LENGTH_SETTING.getKey(), 99)
        {
                new TimeValue(1, TimeUnit.DAYS),
            Settings.builder()
    }
        settings = new IndexSettings(metadata, Settings.EMPTY);
        assertEquals(IndexSettings.MAX_REGEX_LENGTH_SETTING.get(Settings.EMPTY).intValue(), settings.getMaxRegexLength());
            iae.getMessage()
            iae.getMessage()
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                SettingsException.class,
 */
            .build();
        String newRefreshInterval = getRandomTimeString(false);
            "index",
 *
        Setting<Integer> integerSetting = Setting.intSetting("index.test.setting.int", -1, Property.Dynamic, Property.IndexScope);
            newIndexMeta(
        );
            "index",
        );
        settings.updateIndexMetadata(
                    .build()
        final IndexScopedSettings indexScopedSettings = new IndexScopedSettings(settings, IndexScopedSettings.BUILT_IN_INDEX_SETTINGS);
    public void testSetRemoteTranslogRepositoryFailsWhenRemoteStoreIsNotEnabled() {
                    .put("index.test.setting.int", 42)
                assertThat(ex, hasToString(containsString("failed to parse setting [index.refresh_interval] with value [-200]")));
                .build()
    }
            "index",
            ),
        assertTrue(settings.updateIndexMetadata(newMetadata));
        assertEquals(TimeValue.timeValueMillis(200), settings.getRemoteTranslogUploadBufferInterval());
            )
            newSettings.put(IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.getKey(), randomPositiveTimeValue());
    public void testEnablingRemoteStoreFailsWhenReplicationTypeIsDefault() {
            .build();
        {
            Settings.builder()
        settings = new IndexSettings(metadata, Settings.EMPTY);
import java.util.concurrent.atomic.AtomicInteger;
            settings.getMaxAdjacencyMatrixFilters()
        IndexSettings settings = newIndexSettings(metadata, Settings.EMPTY);
            .build();
        );
            IndexSettings settings = newIndexSettings(metadata, Settings.EMPTY);
        Settings build = Settings.builder()
        );
import org.opensearch.common.settings.Settings;
            assertThat(e, hasToString(containsString("unknown setting [archived.foo]")));
    }
                assert false : "should not have been invoked, no invalid settings";
     * index.remote_store.auto_restore.enabled requires fencing: the trigger fires on the cluster manager's view of
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            );
        );
                    .put(IndexSettings.INDEX_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE_SETTING.getKey(), "64mb")
    }
            .put(IndexMetadata.SETTING_VERSION_CREATED, VersionUtils.randomVersionBetween(random(), Version.V_2_0_0, Version.CURRENT));
            iae.getMessage()
            Settings.EMPTY
    public void testDerivedSourceTranslogReadPreferenceValidation() {
            .put(IndexMetadata.SETTING_REMOTE_STORE_AUTO_RESTORE_ENABLED, true)
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
                .build()
                .put(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), "200ms")
        assertTrue(settings.isWarmerEnabled());
            newIndexMeta("index", Settings.builder().put(IndexSettings.INDEX_WARMER_ENABLED_SETTING.getKey(), "true").build())
                () -> indexScopedSettings.validate(settings, randomBoolean())
            "index",
        Settings indexSettings = Settings.builder().put("index.remote_store.enabled", true).build();
    }
        IndexMetadata metadata = newIndexMeta("index", theSettings);
            () -> IndexMetadata.INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING.get(indexSettings)
    }
    public void testRunListener() {
        }
        IndexMetadata metadata = newIndexMeta(
                .build()
        Settings withFencing = Settings.builder()
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas + 1)
        settings = IndexScopedSettings.DEFAULT_SCOPED_SETTINGS.archiveUnknownOrInvalidSettings(
                    Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).put("index.test.setting.int", 42).build()
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        );
            Version createdVersion = VersionUtils.randomVersionBetween(random(), Version.V_2_0_0, Version.CURRENT);
    public void testTranslogGenerationSizeThreshold() {
        Settings.Builder newSettings = Settings.builder().put(settings.build());
            Settings.builder().put("index.refresh_interval", "-200").build(),
                    .put(
        final AtomicInteger integer = new AtomicInteger(0);
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            )
        }
        metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build());
    public void testPartitionStrategyDefault() {
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        TimeValue value = IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.get(indexSettings);
        settings.updateIndexMetadata(
        return IndexMetadata.builder(name).settings(build).build();
        IndexMetadata metadata = newIndexMeta(
        IllegalArgumentException iae = expectThrows(
                () -> indexScopedSettings.validate(settings, randomBoolean(), false, randomBoolean())
            settings.getGcDeletesInMillis()
            newTranslogFlushThresholdSize.getBytes() + "B",
            newIndexMeta(
            .build();
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        assertEquals(version, settings.getIndexVersionCreated());
            "index",
        assertEquals(99, settings.getMaxRegexLength());
        if (settings.length > 0) {
            IllegalArgumentException.class,
    }
        String refreshInterval = getRandomTimeString(false);
        IndexMetadata metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build());
        );
                .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "tlog-store")
                .build()
                "index",
        Version createdVersion = VersionUtils.randomVersionBetween(random(), Version.V_2_0_0, Version.CURRENT);
            .put(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED, true)
            settings.getFlushOnUncommittedSegmentsThresholdSize()
            .build();
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "")
 * software distributed under the License is distributed on an
            Settings.builder()
            )
    }
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import static org.opensearch.index.IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE;
                Settings.builder().put(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), newBufferInterval).build()
        settings = new IndexSettings(metadata, Settings.EMPTY);
     * publication site), and rejects zero or negative sizes since those would flush on every successful segments sync.
                "index"
        metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build());
                .put(IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey(), true)
    }
                .put(IndexSettings.INDEX_DERIVED_SOURCE_TRANSLOG_ENABLED_SETTING.getKey(), false)
        metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build());
        // use version number that is unknown
    public void testEnablingRemoteStoreFailsWhenReplicationTypeIsDocument() {
        settings = new IndexSettings(metadata, Settings.EMPTY);
        assertEquals(actual, settings.getGenerationThresholdSize());
        assertEquals("2s", settings.get("index.refresh_interval"));
            settings.getRefreshInterval()
        Set<Setting<?>> settingSet = new HashSet<>(IndexScopedSettings.BUILT_IN_INDEX_SETTINGS);
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
        TimeValue defaultValue = IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.get(indexSettings);
        );
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
        assertTrue(settings.isRemoteStoreEnabled());
        metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build());
    public void testIsOnRemoteNode() {
        IndexMetadata metadata = newIndexMeta(
 * under the License.
    }
        assertEquals(20, settings.getMaxScriptFields());
        assertEquals(43, indexValue.get());
        Settings theSettings = Settings.builder()
        );
                IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY
            IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey()
            () -> settings.updateIndexMetadata(
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
            assertEquals("uuid mismatch on settings update expected: 0xdeadbeef but was: _na_", ex.getMessage());
        IndexMetadata metadata = newIndexMeta(
                newIndexMeta(
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        settings.updateIndexMetadata(
            SettingsException.class,
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false)
            assertThat(e, hasToString(containsString("unknown setting [archived.foo]")));
                .put(IndexSettings.MAX_DOCVALUE_FIELDS_SEARCH_SETTING.getKey(), 200)
            () -> IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.get(indexSettings)
                .put(IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey(), false)
import static org.hamcrest.core.StringContains.containsString;
        IndexMetadata metadata = newIndexMeta("index", theSettings);
        metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build());
                .put(IndexSettings.DEFAULT_SEARCH_PIPELINE.getKey(), "foo")
            );
    }
                Settings.builder()
import java.util.Arrays;
    public void testSetRemoteRepositoryFailsWhenRemoteStoreIsNotEnabled() {
        Version version = VersionUtils.getPreviousVersion();
    public void testNodeSettingsAreContained() {
        IndexMetadata metadata = newIndexMeta(
            Settings.builder()
    }
        metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build());
    public void testRemoteStoreDefaultSetting() {
            newIndexMeta("index", Settings.builder().put(IndexSettings.MAX_SCRIPT_FIELDS_SETTING.getKey(), 20).build())
        Settings nodeSettings = Settings.builder().put("node.attr.remote_store.translog.repository", "my-repo-1").build();
            settings.getRemoteTranslogUploadBufferInterval()
                    "index",
                new TimeValue(1, TimeUnit.DAYS),
public class IndexSettingsTests extends OpenSearchTestCase {
                    Settings.builder()
    }
            .build();
                () -> new IndexSettings(
        metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build());
 * GitHub history for details.
            Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build()
        );
            Settings.builder()
        settings.updateIndexMetadata(
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            String.format(
            "index",
import java.util.concurrent.TimeUnit;
        assertTrue(e.getMessage(), e.getMessage().contains("unknown setting [index.remote_store.flush_on_uncommitted_segments.enabled]"));
/*
                Settings.builder().put(IndexSettings.INDEX_GC_DELETES_SETTING.getKey(), newGCDeleteSetting.getStringRep()).build()
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.fromString("99.99.99"))
            IllegalArgumentException.class,
        final ByteSizeValue newSize = new ByteSizeValue(Math.abs(randomInt()));
        assertEquals("To enable index.remote_store.enabled, index.replication.type should be set to SEGMENT", iae.getMessage());
            iae.getMessage()
                .put(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), bufferInterval)
        final ByteSizeValue size = new ByteSizeValue(Math.abs(randomInt()));
                .build()
    }
import static org.opensearch.index.IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY;
        if (nonNegativeOnly) {
