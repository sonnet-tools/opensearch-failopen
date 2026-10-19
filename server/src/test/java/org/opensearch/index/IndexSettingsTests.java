    }  
            .build();
        metadata = newIndexMeta(
            "index",
        assertEquals(100_000, (int) INDEX_CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE.get(settings.getSettings()));
                .build()
            )  
            "index",  
                .build()  
                .put(IndexSettings.INDEX_DERIVED_SOURCE_TRANSLOG_ENABLED_SETTING.getKey(), false)  
                .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), "async")  
        assertEquals(15, settings.getMaxAdjacencyMatrixFilters());
        IndexMetadata metadata = newIndexMeta(  
            .build();
        String newRefreshInterval = getRandomTimeString(false);
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            settings.put(IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.getKey(), randomPositiveTimeValue());
    public void testMaxDocvalueFields() {  
        settings = new IndexSettings(metadata, Settings.EMPTY);
        ByteSizeValue newTranslogFlushThresholdSize = new ByteSizeValue(Math.abs(randomInt()));
        IndexScopedSettings.DEFAULT_SCOPED_SETTINGS.validate(withFencing, true); // must not throw
        IndexScopedSettings settings = new IndexScopedSettings(Settings.EMPTY, IndexScopedSettings.BUILT_IN_INDEX_SETTINGS);
            () -> IndexMetadata.INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING.get(indexSettings)
        );  
        Version version = VersionUtils.getPreviousVersion();
     * writes the restored copy will never see.
                    .put(IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.getKey(), "10m")
        });
            )
    }  
        assertEquals(42, indexValue.get());  
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        // Test that regular indices have periodic flush disabled by default  
        assertEquals(0, integer.get());
        final String key = IndexSettings.INDEX_TRANSLOG_GENERATION_THRESHOLD_SIZE_SETTING.getKey();
    public void testRemoteStoreDefaultSetting() {
        }, (e, ex) -> { assert false : "should not have been invoked, no invalid settings"; });
        assertEquals("foo", settings.getDefaultSearchPipeline());
        );
            Settings.builder()
            newIndexMeta("index", Settings.builder().put(IndexSettings.MAX_ADJACENCY_MATRIX_FILTERS_SETTING.getKey(), 42).build())
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    public void testPeriodicFlushIntervalExplicitValue() {
        assertEquals(TimeValue.timeValueMillis(650), IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.get(settings));  
        Settings build = Settings.builder()
        assertThat(indexSettings.getTranslogRetentionAge().millis(), equalTo(-1L));
        settings.updateIndexMetadata(  
 * under the License.  
        IndexSettings settings = newIndexSettings(metadata, Settings.EMPTY);
            newIndexMeta(
    private String getRandomTimeString(boolean nonNegativeOnly) {  
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);  
        IndexMetadata metadata = newIndexMeta(  
    }  
 *
        );
            "index",  
        assertEquals(TimeValue.timeValueMillis(200), settings.getRemoteTranslogUploadBufferInterval());
        settings.updateIndexMetadata(
        Setting<Integer> integerSetting = Setting.intSetting("index.test.setting.int", -1, Property.Dynamic, Property.IndexScope);
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "")  
            IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey()
        assertEquals(numReplicas, settings.getNumberOfReplicas());
import org.opensearch.Version;
        IndexSettings settings = newIndexSettings(newIndexMeta("index", theSettings), nodeSettings, integerSetting);
    }
            .put(IndexMetadata.SETTING_INDEX_UUID, "0xdeadbeef")
            )
        IllegalArgumentException iae = expectThrows(
import static org.opensearch.index.IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY;
        assertEquals(15, settings.getMaxResultWindow());
    public void testQueryDefaultField() {
        assertEquals(IndexSettings.MAX_REGEX_LENGTH_SETTING.get(Settings.EMPTY).intValue(), settings.getMaxRegexLength());
        // Test 1: Valid case - when derived source is enabled  
        }
        }  
                            .put(IndexSettings.INDEX_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE_SETTING.getKey(), invalid)
        );
        assertThat(index.getDefaultFields(), equalTo(Collections.singletonList("*")));  
            // validation should fail since we are not ignoring private settings
            newIndexMeta(  
        assertEquals(  
    }
            );
                        (randomBoolean() ? -1 : new TimeValue(-1, TimeUnit.MILLISECONDS)).toString()
    }
        assertTrue(settings.isDerivedSourceEnabledForTranslog());  
                assertThat(e.getValue(), equalTo("-200"));  
            .put(IndexMetadata.SETTING_INDEX_UUID, "0xdeadbeef")
            .build();
        Settings settings = IndexScopedSettings.DEFAULT_SCOPED_SETTINGS.archiveUnknownOrInvalidSettings(Settings.EMPTY, e -> {
    }
        int start = -1;
    /**
                IndexSettings.INDEX_GC_DELETES_SETTING.getKey()
        Settings withFencing = Settings.builder()
        assertEquals(TimeValue.MINUS_ONE, defaultValue);
            newIndexMeta("index", Settings.builder().put(IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING.getKey(), 50).build())
            Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build()  
        assertEquals(IndexSettings.MAX_SCRIPT_FIELDS_SETTING.get(Settings.EMPTY).intValue(), settings.getMaxScriptFields());
            .build();  
    }
        IndexSettings indexSettings = new IndexSettings(metadata, Settings.EMPTY);
        settings.getScopedSettings().addSettingsUpdateConsumer(integerSetting, integer::set);  
            }
import org.opensearch.common.settings.Settings;
                .build()
                new TimeValue(1, TimeUnit.DAYS),
            "index",
        assertTrue(
        IndexMetadata metadata = newIndexMeta(  
    }
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertEquals(IndexSettings.MAX_DOCVALUE_FIELDS_SEARCH_SETTING.get(Settings.EMPTY).intValue(), settings.getMaxDocvalueFields());  
    public void testPeriodicFlushIntervalDynamicUpdate() {
    /** Enablement is cluster-only: there is deliberately no index scoped counterpart, so index scope rejects the key. */
            "index",
        );  
            IllegalArgumentException.class,  
        assertEquals(41, integer.get());  
        metadata = newIndexMeta(  
            start = 0;  
        final Settings settings = Settings.builder()  
import java.util.Locale;
            assertTrue(IndexSettings.INDEX_SOFT_DELETES_SETTING.get(settings));
    }  
        int refreshIntervalInt = randomFrom(start, Math.abs(randomInt()));
        settings.updateIndexMetadata(
        assertTrue("Index should be on remote node", settings.isAssignedOnRemoteNode());  
                newIndexMeta("index", Settings.builder().put(theSettings).put("index.test.setting.int", 42).build())
        );  
        {
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
            );
                .build()
                "Settings %s can only be set/enabled when %s is set to true",  
            .put("index.remote_store.enabled", true)  
                    "index",
        assertEquals(
        settings.updateIndexMetadata(
                .build()  
            "index",
        IllegalArgumentException iae = expectThrows(
        assertEquals("", builder.toString());  
        metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build());
            .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), createdVersion)  
        IndexScopedSettings settings = new IndexScopedSettings(Settings.EMPTY, IndexScopedSettings.BUILT_IN_INDEX_SETTINGS);
        return IndexMetadata.builder(name).settings(build).build();
        metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build());
                Settings.builder().put("index.soft_deletes.enabled", randomBoolean()).build(),  
        final AtomicInteger integer = new AtomicInteger(0);  
        settings = new IndexSettings(metadata, Settings.EMPTY);
 *
 */
    }
    public static IndexMetadata newIndexMeta(String name, Settings indexSettings) {  
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertFalse(settings.isDerivedSourceEnabledForTranslog());  
                .put(IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey(), false)
        IndexMetadata metadata = newIndexMeta("index", settings.build());  
        final ByteSizeValue actualValue = ByteSizeValue.parseBytesSizeValue(size.getBytes() + "B", key);
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        try {
                )  
        assertSame(settings.getIndexMetadata(), newMetadata);  
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        TimeValue gcDeleteSetting = new TimeValue(Math.abs(randomInt()), TimeUnit.MILLISECONDS);  
        IndexMetadata metadata = newIndexMeta(  
    public void testMaxScriptFields() {
     * Test private setting validation for private settings defined in {@link IndexScopedSettings#isPrivateSetting(String)}
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);  
        assertEquals(IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING.get(Settings.EMPTY).intValue(), settings.getMaxInnerResultWindow());  
                new TimeValue(1, TimeUnit.DAYS),  
    public void testGCDeletesSetting() {
            translogFlushThresholdSize.getBytes() + "B",
                .build()
        );
                newRefreshInterval,
            assertThat(e, hasToString(containsString("unknown setting [index.version.upgraded]")));
            "index",  
                .put(IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING.getKey(), 200)
        IndexMetadata metadata = newIndexMeta(
        );
        settings.updateIndexMetadata(
            .put(IndexMetadata.SETTING_INDEX_UUID, "test-uuid")
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.fromString("99.99.99"))
        // Test 3: Default(Derived) behavior - no read preference set  
        SettingsException e = expectThrows(
    public void testMaxAdjacencyMatrixFiltersSetting() {
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertNull(settings.getRemoteStoreRepository());  
 * license agreements. See the NOTICE file distributed with
                newGCDeleteSetting.getStringRep(),
            "index",
            Version createdVersion = VersionUtils.randomVersionBetween(random(), Version.V_2_0_0, Version.CURRENT);  
        // use version number that is unknown
                () -> indexScopedSettings.validate(settings, randomBoolean(), false, randomBoolean())
        assertEquals(IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING.get(Settings.EMPTY).intValue(), settings.getMaxInnerResultWindow());
        assertEquals(50, settings.getMaxDocvalueFields());
            e -> {
        assertEquals(0, indexValue.get());  
        IndexMetadata metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build());
        );
            .build();  
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
            Settings.builder()
            Settings.builder()
        assertNull(settings.get("index.refresh_interval"));
            );  
    }
        Settings withoutFencing = Settings.builder()
    public void testFlushOnUncommittedSegmentsThresholdSize() {  
        assertEquals(SearchPipelineService.NOOP_PIPELINE_ID, settings.getDefaultSearchPipeline());
        IllegalArgumentException iae = expectThrows(
            IllegalArgumentException e = expectThrows(  
                IllegalArgumentException.class,
    }
                .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), refreshInterval)
    public void testSetRemoteTranslogBufferIntervalDefaultSetting() {  
        Version version = VersionUtils.getPreviousVersion();
    }
                            .build()
                .put("index.unknown", "foo")
                        Settings.builder()
                SettingsException.class,
 * Licensed to Elasticsearch under one or more contributor  
            SettingsException.class,
                        IndexSettings.INDEX_GC_DELETES_SETTING.getKey(),
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        IndexMetadata metadata = newIndexMeta(
        settings = new IndexSettings(metadata, Settings.EMPTY);  
            IllegalArgumentException.class,  
/*  
        );
        index = newIndexSettings(
            Settings.builder()
        assertEquals(
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
            settings.updateIndexMetadata(
        );
import org.opensearch.index.translog.Translog;
        IndexMetadata metadata = newIndexMeta(
import java.util.Set;
            )
        IndexMetadata metadata = newIndexMeta(
                .put(IndexMetadata.SETTING_INDEX_UUID, "0xdeadbeef")  
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            TimeValue.parseTimeValue(  
    public IndexSettings newIndexSettings(IndexMetadata metadata, Settings nodeSettings, Setting<?>... settings) {  
        metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build());
        );
            settings.updateIndexMetadata(
                Settings.builder().put("index.derived_source.enabled", randomBoolean()).build(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                "index",
import org.opensearch.core.common.unit.ByteSizeUnit;
     * The precedence against the cluster setting is exercised in {@code RemoteStoreRefreshListenerTests}, which owns  
            SettingsException.class,
        IndexMetadata metadata = newIndexMeta(
            Settings settings = Settings.builder().put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), createdVersion).build();
import java.util.Arrays;
                    Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).put("index.test.setting.int", 42).build()  
                    newIndexMeta(  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("0xdeadbeef", settings.getUUID());
        assertEquals(Integer.toString(Version.CURRENT.id), settings.get("index.version.created"));  
        );  
        );
    public void testEnablingRemoteStoreFailsWhenReplicationTypeIsDefault() {  
        IllegalArgumentException iae = expectThrows(
    }
        settings.updateIndexMetadata(
                .build()  
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
        assertEquals(
    public void testMaxResultWindow() {
        assertEquals(
                .put(IndexSettings.INDEX_WARMER_ENABLED_SETTING.getKey(), false)
        Set<Setting<?>> settingSet = new HashSet<>(IndexScopedSettings.BUILT_IN_INDEX_SETTINGS);
        assertEquals("To enable index.remote_store.enabled, index.replication.type should be set to SEGMENT", iae.getMessage());  
        assertEquals(42, settings.getMaxAdjacencyMatrixFilters());  
        IndexMetadata metadata = newIndexMeta(  
    public void testMergedSettingsArePassed() {  
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
            // validation should fail since we are not ignoring private settings
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        return refreshInterval;
            .build();
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas + 1)
                newIndexMeta(  
                new TimeValue(1, TimeUnit.DAYS),
        settings.updateIndexMetadata(  
        Version version = VersionUtils.getPreviousVersion();  
            IllegalArgumentException.class,  
     */
        );
        Settings indexSettings = Settings.builder()
            "index",
        Settings indexSettings = Settings.builder().put("index.remote_store.enabled", true).build();
            "index",
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        ByteSizeValue actualNewTranslogFlushThresholdSize = ByteSizeValue.parseBytesSizeValue(
            "index",  
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas + 1)
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);  
            newTranslogFlushThresholdSize.getBytes() + "B",  
        }
            ),
    public void testSettingsUpdateValidator() {
                        "index",
                assertThat(e.getValue(), equalTo("foo"));  
        );
            fail("uuid missing/change");
        );  
            "index",
        );
        metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build());
            "index",
        );  
        if (settings.length > 0) {
                assertThat(e.getKey(), equalTo("index.refresh_interval"));
    }
    }
            settings.getGcDeletesInMillis()  
            )  
        Settings prevSettings = settings; // no double archive
import org.opensearch.common.settings.Setting.Property;
 * compatible open source license.
        assertEquals(50, settings.getMaxInnerResultWindow());  
                    .put(  
        Settings.Builder settings = Settings.builder()
    }  
    public void testUpdateDurability() {
    }
            String.format(
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        {
import org.opensearch.common.SuppressForbidden;  
        );  
            newIndexMeta(  
import org.opensearch.common.settings.SettingsException;  
        assertEquals(TimeValue.timeValueMinutes(5), value);
            .put(IndexMetadata.SETTING_REMOTE_STORE_AUTO_RESTORE_ENABLED, true)  
            .build();
        index.updateIndexMetadata(newIndexMeta("index", Settings.builder().putList("index.query.default_field", "body", "title").build()));  
        assertEquals("To enable index.remote_store.enabled, index.replication.type should be set to SEGMENT", iae.getMessage());  
    public void testDefaultPeriodicFlushIntervalForRegularIndex() {
            TimeValue.parseTimeValue(
        IndexMetadata metadata = newIndexMeta(  
                Settings.builder()  
                "index",  
        IndexMetadata newMetadata = newIndexMeta(
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            newIndexMeta("index", Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), newRefreshInterval).build())  
        );  
        assertThat(error.getMessage(), equalTo("final index setting [index.derived_source.enabled], not updateable"));
            )
            newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build()),
            .put("index.foo.bar", 0)  
        assertEquals(
    public void testPartitionMinSegmentSizeDefault() {
        assertTrue(  
            )
        assertEquals(500_000, (int) INDEX_CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE.get(settings.getSettings()));
                    .put(metadata.getSettings())
                    .build()  
        IllegalArgumentException iae = expectThrows(
        }
            (e, ex) -> {
            )  
                    "index",  
        assertEquals(20, settings.getMaxScriptFields());
        );  
        }, (e, ex) -> { assert false : "should not have been invoked, no invalid settings"; });  
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);  
        IndexSettings settings = newIndexSettings(metadata, Settings.EMPTY);  
            "[index.max_adjacency_matrix_filters] setting was deprecated in OpenSearch and will be removed in a "
                .build()
     */
            );  
import org.opensearch.cluster.metadata.IndexMetadata;
    public void testRemoteRepositoryDefaultSetting() {  
import org.opensearch.core.common.unit.ByteSizeValue;  
                + "future release! See the breaking changes documentation for the next major version."  
            .put(IndexMetadata.SETTING_INDEX_UUID, "0xdeadbeef")  
    public void testRemoteStoreAutoRestoreRequiresFencing() {  
            Settings.builder()
        assertFalse(settings.isFlushOnUncommittedSegmentsThresholdSizeExplicit());  
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);  
        assertEquals(version, settings.getIndexVersionCreated());
    public void testSetRemoteRepositoryFailsWhenRemoteStoreIsNotEnabled() {
            ),
        settings = new IndexSettings(metadata, Settings.EMPTY);
            .build();
        // Update to 10 minutes
    }
        metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build());
    }  
        );
            Settings.builder()  
    public void testRunListener() {  
                newIndexMeta(
        IllegalArgumentException iae = expectThrows(
                SettingsException.class,
        final AtomicInteger integer = new AtomicInteger(0);  
        );
        assertEquals(Translog.Durability.REQUEST, settings.getTranslogDurability()); // test default  
     */
        );
                Settings.builder()
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)  
        settings = new IndexSettings(metadata, Settings.EMPTY);
            );
        Settings indexSettings = Settings.builder()  
        );  
    }
            Settings.builder()  
        } catch (IllegalArgumentException ex) {
        assertTrue(settings.isDerivedSourceEnabledForTranslog());
                new TimeValue(1, TimeUnit.DAYS),  
    }
    public void testPrivateSettingsValidation() {  
    }
import java.util.concurrent.TimeUnit;  
            Settings.builder()
                    Settings.builder()
        Version version = VersionUtils.getPreviousVersion();  
    public void testDefaultPeriodicFlushIntervalForPullBasedIngestionIndex() {
    public void testMaxRegexLengthSetting() {
        assertTrue(settings.updateIndexMetadata(newMetadata));
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
    public void testEnablingRemoteStoreFailsWhenReplicationTypeIsDocument() {  
        assertEquals(0, integer.get());
            newSettings.put(IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.getKey(), randomPositiveTimeValue());
    public void testRemoteTranslogStoreDefaultSetting() {  
        );
        );
                "Setting %s should be provided with non-empty repository ID",  
            .put(IndexMetadata.SETTING_VERSION_CREATED, version)  
import org.opensearch.search.pipeline.SearchPipelineService;  
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            IndexSettings.DEFAULT_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE,  
        }
        );
            settings.getRefreshInterval()
        IndexSettings settings = new IndexSettings(
                IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey()  
            IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey()
    public void testPartitionStrategyValidValues() {  
            assertEquals("uuid mismatch on settings update expected: 0xdeadbeef but was: _na_", ex.getMessage());
                Settings.builder().put("index.remote_store.flush_on_uncommitted_segments.enabled", false).build(),
        Setting<Integer> integerSetting = Setting.intSetting("index.test.setting.int", -1, Property.Dynamic, Property.IndexScope);  
        assertEquals(metadata.getSettings(), settings.getSettings());
            settings.getFlushOnUncommittedSegmentsThresholdSize()
                "index",  
            newIndexMeta("index", Settings.builder().put(IndexSettings.MAX_DOCVALUE_FIELDS_SEARCH_SETTING.getKey(), 50).build())
                )
        }
                Settings.builder(),
        );
    }
        // Test 4: Dynamic update - valid case
        settings.updateIndexMetadata(
    public void testSetRemoteTranslogRepositoryFailsWhenRemoteStoreIsNotEnabled() {
            Settings.builder()
            .build();
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        settings.getScopedSettings().addSettingsUpdateConsumer(integerSetting, indexValue::set);  
        IllegalArgumentException iae = expectThrows(
                .put(IndexSettings.MAX_RESULT_WINDOW_SETTING.getKey(), 15)  
                    .put(IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.getKey(), "-1")
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
import org.opensearch.test.VersionUtils;
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        settings.updateIndexMetadata(
 * Unless required by applicable law or agreed to in writing,
    public void testMaxInnerResultWindow() {
        } catch (IllegalArgumentException ex) {  
        assertSame(nodeSettings, settings.getNodeSettings());
    }
        IndexMetadata metadata = newIndexMeta(
        assertEquals(42, integer.get());
        assertEquals(Version.fromString("99.99.99"), settings.getIndexVersionCreated());
            .build();
        assertEquals(actualValue, settings.getFlushThresholdSize());  
            Settings.builder()
        );
                "index",
            assert false : "should not have been invoked, no unknown settings";  
            .put(indexSettings)
            IndexMetadata metadata = newIndexMeta(
            .put(IndexMetadata.SETTING_INGESTION_SOURCE_TYPE, "kafka")
                .put(IndexSettings.MAX_REGEX_LENGTH_SETTING.getKey(), 99)  
    }
        assertTrue(settings.isFlushOnUncommittedSegmentsThresholdSizeExplicit());
            settings.getGcDeletesInMillis()  
        assertEquals(version, settings.getIndexVersionCreated());  
        String refreshInterval = Integer.toString(refreshIntervalInt);  
            iae.getMessage()
                IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey()  
        IndexSettings settings = newIndexSettings(newIndexMeta("index", theSettings), Settings.EMPTY, integerSetting);  
        IndexSettings settings = newIndexSettings(metadata, Settings.EMPTY);
    public void testDerivedSourceTranslogReadPreferenceValidation() {
        settings = new IndexSettings(metadata, Settings.EMPTY);  
            Settings.builder()  
        assertNull(settings.getRemoteStoreRepository());
            () -> IndexScopedSettings.DEFAULT_SCOPED_SETTINGS.validate(withoutFencing, true)
        }  
            settings.getRemoteTranslogUploadBufferInterval()
        IndexSettings settings = newIndexSettings(newIndexMeta("index", theSettings), Settings.EMPTY, integerSetting);
            iae.getMessage()
                Settings.builder()  
import org.opensearch.common.settings.Setting;  
        }
        for (String strategy : new String[] { "segment", "balanced", "force" }) {
        settings.updateIndexMetadata(
        Setting<Integer> integerSetting = Setting.intSetting("index.foo.bar", -1, Property.Dynamic, Property.IndexScope);
        assertThat(index.getDefaultFields(), equalTo(Collections.singletonList("body")));
    }  
import org.opensearch.common.settings.IndexScopedSettings;
        assertEquals(metadata.getSettings(), settings.getSettings());  
            () -> IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.get(indexSettings)
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        IndexMetadata metadata = newIndexMeta(
        indexScopedSettings.validate(settings, randomBoolean(), true, randomBoolean());
            ).getMillis(),
    public void testDefaultSearchPipeline() throws Exception {
        settings.updateIndexMetadata(newIndexMeta("index", Settings.EMPTY));
            TimeValue.parseTimeValue(  
        );
        Settings indexSettings = Settings.builder()  
            assertTrue(ex.getMessage(), ex.getMessage().startsWith("version mismatch on settings update expected: "));
        Settings indexSettings = Settings.builder()  
                () -> new IndexSettings(
        for (String invalid : new String[] { "0b", "-1" }) {
            TimeValue.parseTimeValue(  
        );
            settings.updateIndexMetadata(
                "index",
        TimeValue defaultValue = IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.get(indexSettings);  
                    .build()
                .put("index.version.created", Version.CURRENT.id) // private setting  
        assertFalse(settings.isDerivedSourceEnabledForTranslog());
            .build();
        );
                IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey()  
     * index.remote_store.auto_restore.enabled requires fencing: the trigger fires on the cluster manager's view of
            settings.getMaxAdjacencyMatrixFilters()
                Settings.builder(),
                    .build()
        String refreshInterval = getRandomTimeString(false);
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)  
        );
            newIndexMeta(  
        }
            .build();  
        );
                    .build()  
    public void testRemoteTranslogRepoDefaultSetting() {
            .put(IndexMetadata.SETTING_VERSION_CREATED, VersionUtils.randomVersionBetween(random(), Version.V_2_0_0, Version.CURRENT));
            Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build()
 *  
            .put(IndexMetadata.SETTING_INDEX_UUID, "test-uuid")
                    .put(IndexSettings.INDEX_DERIVED_SOURCE_TRANSLOG_ENABLED_SETTING.getKey(), false)
            )
            newIndexMeta(
        assertEquals(200, settings.getMaxDocvalueFields());  
     * publication site), and rejects zero or negative sizes since those would flush on every successful segments sync.
        assertEquals(version, settings.getIndexVersionCreated());  
        assertEquals(43, indexValue.get());
                    .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), newTranslogFlushThresholdSize.getBytes() + "B")
        }
        Settings indexSettings = Settings.builder()
                Settings.builder()
        assertEquals(100, settings.getMaxScriptFields());
        }  
    public void testSetRemoteTranslogBufferIntervalFailsWhenEmpty() {  
    public void testIgnoreTranslogRetentionSettingsIfSoftDeletesEnabled() {  
        );
                )
        assertTrue(  
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)  
        );
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        );
                .put(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), bufferInterval)
 * GitHub history for details.
            if (i == 42) throw new AssertionError("boom");
                Locale.ROOT,
        );  
 *     http://www.apache.org/licenses/LICENSE-2.0
        );
                .build()
        settings.getScopedSettings().addSettingsUpdateConsumer(integerSetting, integer::set, (i) -> {  
            "index",
                    .put("index.test.setting.int", 42)  
 * this file be licensed under the Apache-2.0 license or a
        assertThat(index.getDefaultFields(), equalTo(Arrays.asList("body", "title")));
        if (nonNegativeOnly) {
                    .put(IndexMetadata.SETTING_INGESTION_SOURCE_TYPE, "kafka")
            () -> IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.get(indexSettings)
                .build()  
            assertTrue(e.getMessage(), e.getMessage().contains("failed to parse value [" + invalid + "]"));
                )
        assertEquals(TimeValue.timeValueMinutes(10), settings.getPeriodicFlushInterval());  
        Settings nodeSettings = Settings.builder().put("index.foo.bar", 43).build();
                        .build()
    public void testArchivedSettingsValidation() {
        settings.updateIndexMetadata(  
                .put(IndexMetadata.SETTING_INGESTION_SOURCE_TYPE, "kafka")  
                Settings.builder().put(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), newBufferInterval).build()
                .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), translogFlushThresholdSize.getBytes() + "B")
        assertTrue(iae.getMessage(), iae.getMessage().contains("can only be enabled when"));  
                .put(IndexSettings.INDEX_DERIVED_SOURCE_TRANSLOG_ENABLED_SETTING.getKey(), true)  
            IllegalArgumentException.class,  
        assertThat(error.getMessage(), equalTo("final index setting [index.soft_deletes.enabled], not updateable"));  
            .put(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), "")
        );
import org.opensearch.common.settings.AbstractScopedSettings;
        Settings indexSettings = Settings.builder()
        );
            newIndexMeta(
                () -> indexScopedSettings.validate(settings, randomBoolean())
                newIndexMeta(
        settings.updateIndexMetadata(  
                .put("index.refresh_interval", "2s")
            assertThat(e, hasToString(containsString("unknown setting [archived.foo]")));
            .build();
            () -> IndexMetadata.INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING.get(indexSettings)
                    "index",
        Settings theSettings = Settings.builder()
        );
            Settings.builder()  
/*  
 * specific language governing permissions and limitations
            .put(IndexMetadata.SETTING_VERSION_CREATED, version)
            () -> settings.updateSettings(
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
                Settings.builder()  
                            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            },  
                newIndexMeta("index", Settings.builder().put(theSettings).put("index.test.setting.int", 42).build())
        );
            settings.updateIndexMetadata(
        assertEquals(metadata.getSettings(), settings.getSettings());
    public void testIsWarmerEnabled() {  
        // Update to disabled (-1)
            Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build()
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
        );  
            "index",
            newIndexMeta(
        assertNull(settings.getRemoteStoreRepository());
        metadata = newIndexMeta(  
        assertEquals(
        Settings indexSettings = Settings.builder()
                assertThat(e.getKey(), equalTo("index.unknown"));
                Locale.ROOT,
    }
        settings.updateIndexMetadata(
    }  
import java.util.function.Function;
            "Settings index.remote_store.translog.repository can only be set/enabled when index.remote_store.enabled is set to true",  
        assertEquals(-1, settings.getGcDeletesInMillis());
            settings.put(IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.getKey(), between(1, 1024) + "b");
    public void testFlushOnUncommittedSegmentsEnabledHasNoIndexScopedSetting() {  
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
 * ownership. Elasticsearch licenses this file to you under  
        Settings indexSettings = Settings.builder()
                    "index",
                .build()  
                gcDeleteSetting.getStringRep(),
            .build();
        );  
        IndexMetadata metadata = newIndexMeta(
        );  
                .build()
            "index",
        );
        );
        assertEquals("Setting index.remote_store.translog.repository should be provided with non-empty repository ID", iae.getMessage());  
            Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build()
    public void testIsOnRemoteNode() {
        assertEquals("segment", INDEX_CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.get(settings.getSettings()));  
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
        );
    }  
            .put(IndexMetadata.SETTING_VERSION_CREATED, version)
        final StringBuilder builder = new StringBuilder();
                () -> indexScopedSettings.validate(settings, randomBoolean())  
                    ),  
    @SuppressForbidden(reason = "sets the SEARCH_PIPELINE feature flag")  
        settings = new IndexSettings(metadata, Settings.EMPTY);
        }
            Settings.builder().put("index.query.default_field", "body").build()  
        // Test that ingestion indices have periodic flush enabled by default
        assertEquals("_na_", settings.getUUID());  
                    .put(IndexMetadata.SETTING_INGESTION_SOURCE_TYPE, "kafka")
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        IndexSettings settings = newIndexSettings(metadata, Settings.EMPTY);
    }
        assertEquals(TimeValue.timeValueMinutes(10), settings.getPeriodicFlushInterval());  
            // validation should fail since we are not ignoring archived settings  
    /**  
            Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.fromString("99.99.99")).build()
        String bufferInterval = getRandomTimeString(true);
        IndexMetadata metadata = newIndexMeta("index", Settings.builder().build());  
                .build()
                .put(IndexSettings.MAX_SCRIPT_FIELDS_SETTING.getKey(), 100)  
        assertThat(indexSettings.getTranslogRetentionSize().getBytes(), equalTo(-1L));  
            () -> settings.updateSettings(
}
        );
import org.opensearch.common.unit.TimeValue;
        settings = IndexScopedSettings.DEFAULT_SCOPED_SETTINGS.archiveUnknownOrInvalidSettings(
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "repo1")  
            iae.getMessage()  
            .put(IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.getKey(), "5m")  
            () -> IndexMetadata.INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING.get(indexSettings)  
            "index",
        assertEquals("", builder.toString());
            () -> settings.updateIndexMetadata(  
        settings = new IndexSettings(metadata, Settings.EMPTY);
            newIndexMeta("index", Settings.builder().put(IndexSettings.MAX_SCRIPT_FIELDS_SETTING.getKey(), 20).build())  
        IndexMetadata metadata = newIndexMeta(
        assertWarnings(
                "index",
        final Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_UPGRADED, Version.V_EMPTY).build();
        assertEquals("tlog-store", settings.getRemoteStoreTranslogRepository());  
                    Settings.builder().put(settings.getIndexMetadata().getSettings()).put("index.not.updated", "boom").build()
        assertEquals("-200", settings.get("archived.index.refresh_interval"));
            )
    }  
        settings.updateIndexMetadata(newIndexMeta("index", Settings.EMPTY));
    }  
    public void testRemoteTranslogExplicitSetting() {
        assertEquals(42, integer.get());
 * KIND, either express or implied.  See the License for the
        final int numShards = randomIntBetween(1, 10);  
        );  
        assertFalse(settings.isWarmerEnabled());  
        assertEquals(  
        assertFalse(settings.isDerivedSourceEnabledForTranslog());
        }
    }
        );
            () -> IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.get(indexSettings)
            () -> IndexScopedSettings.DEFAULT_SCOPED_SETTINGS.validate(  
            )
                Settings.builder()
        // nothing should happen since we are ignoring private settings
        );
            )
                newIndexMeta(  
            settings.getRefreshInterval()
            "failed to parse setting [index.remote_store.translog.buffer_interval] with value [] as a time value: unit is missing or unrecognized",
    public void testTranslogFlushSizeThreshold() {
    }
            .put(IndexMetadata.SETTING_VERSION_CREATED, version)  
                .build()
                    Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).put("index.test.setting.int", 42).build()
                "index",
            Settings.builder()
        );
            final SettingsException e = expectThrows(
    }  
        metadata = newIndexMeta(
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false)
        );  
        settings.updateIndexMetadata(metadata);  
        assertSame(prevSettings, settings);
            "index",
        );
                        .build()
        IndexMetadata metadata = newIndexMeta(  
        assertThat(indexSettings.getTranslogRetentionSize().getBytes(), equalTo(-1L));
        {
        IndexMetadata metadata = newIndexMeta("index", theSettings);
            assertThat(e, hasToString(containsString("unknown setting [archived.foo]")));
                .put(IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey(), false)
        );
        // enabled by default on 7.0+ or later
                .build()
            IllegalArgumentException.class,
            "index",
            Settings.builder().put("index.refresh_interval", "-200").build(),  
        assertEquals("foo", settings.get("archived.index.unknown"));
        settings.updateIndexMetadata(  
        settings.updateIndexMetadata(
            "index",  
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
                SettingsException.class,
        );  
public class IndexSettingsTests extends OpenSearchTestCase {
            newSettings.put(IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.getKey(), between(1, 1024) + "b");
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
                assert false : "should not have been invoked, no invalid settings";
        TimeValue newGCDeleteSetting = new TimeValue(Math.abs(randomInt()), TimeUnit.MILLISECONDS);
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        indexSettings.updateIndexMetadata(newIndexMeta("index", newSettings.build()));  
            )  
        assertEquals(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY).intValue(), settings.getMaxResultWindow());
            Settings.builder().put(settings.getIndexMetadata().getSettings()).put("index.test.setting.int", 42).build()  
            SettingsException.class,  
                    .put(IndexSettings.INDEX_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE_SETTING.getKey(), "64mb")  
    public void testPartitionMinSegmentSizeCustom() {
                .build()
            Settings.builder()
import org.opensearch.test.OpenSearchTestCase;
        settings.getScopedSettings().addSettingsUpdateConsumer(integerSetting, integer::set);
        final IndexScopedSettings indexScopedSettings = new IndexScopedSettings(settings, IndexScopedSettings.BUILT_IN_INDEX_SETTINGS);
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        settings.updateIndexMetadata(newIndexMeta("index", Settings.EMPTY));  
                IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey()  
            newIndexMeta(
            settings.getMaxAdjacencyMatrixFilters()
                .put(IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey(), true)
                Settings.builder(),  
                )
 */  
                "index",
        if (refreshIntervalInt >= 0) {
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);  
    public void testUpdateSoftDeletesFails() {
    public void testRemoteStoreExplicitSetting() {
        return new IndexSettings(metadata, nodeSettings, new IndexScopedSettings(Settings.EMPTY, settingSet));
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false)  
        );  
     * the resolution.
import static org.hamcrest.core.StringContains.containsString;
        Setting<String> notUpdated = new Setting<>("index.not.updated", "", Function.identity(), Property.Dynamic, Property.IndexScope);  
            TimeValue.parseTimeValue(
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
    }
            assertEquals(strategy, INDEX_CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.get(settings.getSettings()));
        );
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .build();
        settings.updateIndexMetadata(newIndexMeta("index", Settings.EMPTY));  
        metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build());  
 * the Apache License, Version 2.0 (the "License"); you may
                newIndexMeta(
            Settings.builder()  
    }
        settings.updateIndexMetadata(newIndexMeta("index", Settings.EMPTY));
            Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).put(key, size.getBytes() + "B").build()
        IndexMetadata metadata = newIndexMeta(
import static org.hamcrest.object.HasToString.hasToString;
     * node membership while the departed primary may still be alive, and only the fence stops it acknowledging  
            settings.updateIndexMetadata(  
        );  
            Settings.builder().put(INDEX_CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE.getKey(), 100_000).build()
            )  
import org.opensearch.indices.replication.common.ReplicationType;
    }
import java.util.concurrent.atomic.AtomicInteger;
        settings = new IndexSettings(metadata, Settings.EMPTY);
            TimeValue.parseTimeValue(  
        final ByteSizeValue size = new ByteSizeValue(Math.abs(randomInt()));  
            .build();
    }
        assertSame(settings, Settings.EMPTY);
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
                newBufferInterval,
        settings.getScopedSettings().addSettingsUpdateConsumer(notUpdated, builder::append);
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false)
        assertEquals("2s", settings.get("index.refresh_interval"));
        assertEquals(42, settings.getMaxResultWindow());
        assertEquals(
        assertFalse(settings.updateIndexMetadata(metadata));
                    "index",
            IllegalArgumentException.class,  
        assertEquals(IndexSettings.MAX_SCRIPT_FIELDS_SETTING.get(Settings.EMPTY).intValue(), settings.getMaxScriptFields());
            IllegalArgumentException.class,  
        IndexMetadata metadata = newIndexMeta(
            newIndexMeta("index", Settings.builder().put(IndexSettings.MAX_RESULT_WINDOW_SETTING.getKey(), 42).build())  
     * Verifies the index scoped {@code index.remote_store.flush_on_uncommitted_segments.threshold_size}: it has a  
        );
        ByteSizeValue translogFlushThresholdSize = new ByteSizeValue(Math.abs(randomInt()));
    }
        ByteSizeValue actualValue = ByteSizeValue.parseBytesSizeValue(  
            "index",
        assertEquals(IndexSettings.MAX_DOCVALUE_FIELDS_SEARCH_SETTING.get(Settings.EMPTY).intValue(), settings.getMaxDocvalueFields());
        assertEquals(  
                IndexSettings.INDEX_GC_DELETES_SETTING.getKey()
        Setting<Integer> integerSetting = Setting.intSetting("index.test.setting.int", -1, Property.Dynamic, Property.IndexScope);
            Settings.builder()
            .put(IndexMetadata.SETTING_INDEX_UUID, "test-uuid")  
    }  
            .build();
            Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build()  
        // nothing should happen since we are ignoring archived settings
        Settings theSettings = Settings.builder()
                "index",
        IndexMetadata metadata = newIndexMeta(
    }
        assertThat(indexSettings.getTranslogRetentionAge().millis(), equalTo(-1L));
        );
                new TimeValue(1, TimeUnit.DAYS),
        indexScopedSettings.validate(settings, randomBoolean(), randomBoolean(), true);  
        IndexMetadata metadata = newIndexMeta(
        settings.updateIndexMetadata(newIndexMeta("index", Settings.EMPTY));  
        metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build());  
                .build(),  
    }  
                    .build()  
            );
    public void testNodeSettingsAreContained() {
        settings.updateIndexMetadata(  
        IndexSettings settings = newIndexSettings(newIndexMeta("index", theSettings), nodeSettings);
            (e, ex) -> { assert false : "should not have been invoked, no invalid settings"; }
    public void testArchiveBrokenIndexSettings() {  
        );
        );
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
                        .put("index.foo.bar", 42)
                .build()  
 */  
        );
        String newBufferInterval = getRandomTimeString(true);
                    )  
            iae.getMessage()  
                .put(IndexSettings.MAX_DOCVALUE_FIELDS_SEARCH_SETTING.getKey(), 200)
        );  
        IllegalArgumentException iae = expectThrows(  
            .put(IndexMetadata.SETTING_INGESTION_SOURCE_TYPE, "kafka")  
                Settings.builder(),
        Settings theSettings = Settings.builder()  
                Settings.builder().put(INDEX_CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), strategy).build()
        assertEquals(IndexSettings.MAX_REGEX_LENGTH_SETTING.get(Settings.EMPTY).intValue(), settings.getMaxRegexLength());
     * default, reports whether the index set it explicitly (which is what makes it win over the cluster default at the
            ),  
        assertEquals("_na_", settings.getUUID());
        assertFalse(settings.isFlushOnUncommittedSegmentsThresholdSizeExplicit());  
        settings = new IndexSettings(metadata, Settings.EMPTY);  
        integer.set(0);  
import static org.opensearch.index.IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE;
        IndexMetadata metadata = newIndexMeta(
            assertThat(e, hasToString(containsString("unknown setting [index.version.upgraded]")));
    }
    }  
    public void testSettingsConsistency() {
        assertEquals(
            IndexSettings.MAX_ADJACENCY_MATRIX_FILTERS_SETTING.get(Settings.EMPTY).intValue(),
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "repo1")
        Version createdVersion = VersionUtils.randomVersionBetween(random(), Version.V_2_0_0, Version.CURRENT);
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);  
            String.format(
            e -> {
    public void testTranslogGenerationSizeThreshold() {
 * Modifications Copyright OpenSearch Contributors. See
            ),
            "index",
        assertEquals(new ByteSizeValue(64, ByteSizeUnit.MB), settings.getFlushOnUncommittedSegmentsThresholdSize());
                refreshInterval,
            refreshInterval += randomFrom("s", "ms", "h");
            newIndexMeta("index", Settings.builder().put(IndexSettings.INDEX_WARMER_ENABLED_SETTING.getKey(), "true").build())
            Settings.builder()  
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertFalse(settings.isRemoteStoreEnabled());
        assertEquals(101, settings.getMaxRegexLength());
            "index",
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false)
        assertEquals(actualNewTranslogFlushThresholdSize, settings.getFlushThresholdSize());
            Settings.builder()
            settings.updateIndexMetadata(  
        IndexMetadata metadata = newIndexMeta(
        IndexMetadata metadata = newIndexMeta("index", theSettings);
            newIndexMeta("index", Settings.EMPTY),
                assertThat(ex, hasToString(containsString("failed to parse setting [index.refresh_interval] with value [-200]")));
        if (randomBoolean()) {  
        }  
            ),
    }
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
            )
        Settings indexSettings = Settings.builder()  
            assert false : "should not have been invoked, no unknown settings";
                () -> indexScopedSettings.validate(settings, randomBoolean(), randomBoolean(), false)  
        assertTrue(
                newIndexMeta("index", Settings.builder().put(theSettings).put("index.test.setting.int", 41).build())  
            Settings.builder()
            IndexSettings.MAX_ADJACENCY_MATRIX_FILTERS_SETTING.get(Settings.EMPTY).intValue(),  
            );  
    public void testRefreshInterval() {
        final IndexMetadata metadata = newIndexMeta(  
                IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY,
    }
                )  
    }
            "index",
        assertTrue(e.getMessage(), e.getMessage().contains("unknown setting [index.remote_store.flush_on_uncommitted_segments.enabled]"));
        {
        expectThrows(
        assertEquals("not updated - we preserve the old settings", 0, integer.get());
            "index",  
                    .build()
        final int numReplicas = randomIntBetween(0, 10);
            final SettingsException e = expectThrows(  
                .put(IndexSettings.DEFAULT_SEARCH_PIPELINE.getKey(), "foo")  
                .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "repo1")
        );
        );
        assertFalse(settings.updateIndexMetadata(metadata));  
            final SettingsException e = expectThrows(  
        assertTrue(settings.isWarmerEnabled());
        );  
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    }
        final AtomicInteger indexValue = new AtomicInteger(0);  
            Settings.builder()  
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        final IndexScopedSettings indexScopedSettings = new IndexScopedSettings(settings, IndexScopedSettings.BUILT_IN_INDEX_SETTINGS);  
        assertTrue(
            .build();  
        Version version = VersionUtils.getPreviousVersion();
            IllegalArgumentException.class,
                new TimeValue(1, TimeUnit.DAYS),
            "index",  
        final AtomicInteger integer = new AtomicInteger(0);
        );
            IllegalArgumentException.class,
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        assertEquals(  
        Settings.Builder newSettings = Settings.builder().put(settings.build());
        settings = IndexScopedSettings.DEFAULT_SCOPED_SETTINGS.archiveUnknownOrInvalidSettings(prevSettings, e -> {
        assertEquals(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY).intValue(), settings.getMaxResultWindow());
        settings.updateIndexMetadata(newIndexMeta("index", Settings.EMPTY));
        settings.updateIndexMetadata(newIndexMeta("index", Settings.builder().put(key, newSize.getBytes() + "B").build()));
        );  
                IndexMetadata.SETTING_REMOTE_STORE_ENABLED
            .put("index.replication.type", ReplicationType.DOCUMENT)
            "index",  
        );
    /**
        settings = IndexScopedSettings.DEFAULT_SCOPED_SETTINGS.archiveUnknownOrInvalidSettings(
    public void testPartitionStrategyDefault() {  
        );
            newIndexMeta("index", Settings.builder().put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), "request").build())  
                .put(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), "200ms")
            .build();  
        assertEquals(actualValue, settings.getGenerationThresholdSize());
            ),
        assertEquals(0, integer.get());  
        );
                Settings.builder()  
import java.util.HashSet;  
            settingSet.addAll(Arrays.asList(settings));  
        // removing it puts the index back on the cluster default, which the publication site resolves
            final SettingsException e = expectThrows(
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
 * software distributed under the License is distributed on an
        }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
            newIndexMeta("index", Settings.builder().put(IndexSettings.MAX_REGEX_LENGTH_SETTING.getKey(), 101).build())  
            "index",  
        IndexSettings index = newIndexSettings(newIndexMeta("index", Settings.EMPTY), Settings.EMPTY);
    public void testSetRemoteTranslogRepositoryFailsWhenEmptyString() {
            Settings.builder()
        assertEquals(TimeValue.MINUS_ONE, settings.getPeriodicFlushInterval());  
    }  
                "index"
        // Verify default value
        final ByteSizeValue newSize = new ByteSizeValue(Math.abs(randomInt()));  
        assertFalse(settings.isRemoteTranslogStoreEnabled());  
    public void testSetRemoteRepositoryFailsWhenEmptyString() {
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
                Settings.builder().put(IndexSettings.INDEX_GC_DELETES_SETTING.getKey(), newGCDeleteSetting.getStringRep()).build()  
        settings.updateIndexMetadata(  
        );  
        );
            newIndexMeta(
                .put(IndexSettings.INDEX_GC_DELETES_SETTING.getKey(), gcDeleteSetting.getStringRep())
        metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build());  
        if (randomBoolean()) {  
        // Test 2: Invalid case - setting read preference when derived source is disabled  
            .put(IndexMetadata.SETTING_REMOTE_STORE_AUTO_RESTORE_ENABLED, true)
        TimeValue value = IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.get(indexSettings);  
 * this work for additional information regarding copyright
        settings = new IndexSettings(metadata, Settings.EMPTY);
        );
 * not use this file except in compliance with the License.
                "index"  
            ).getMillis(),
        assertEquals(TimeValue.timeValueMinutes(10), defaultValue);
            )
    }  
        assertTrue(settings.isRemoteStoreEnabled());  
        settings = new IndexSettings(metadata, Settings.EMPTY);  
                    Settings.EMPTY
            },
            () -> IndexMetadata.INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING.get(indexSettings)
        );
 * You may obtain a copy of the License at  
        );  
    public void testSoftDeletesDefaultSetting() {  
                .build()
            // validation should fail since we are not ignoring archived settings  
    public void testRemoteRepositoryExplicitSetting() {  
        metadata = newIndexMeta(
        settings.updateIndexMetadata(
        metadata = newIndexMeta(
import java.util.Collections;
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
package org.opensearch.index;
        Settings settings = Settings.builder()
            .put(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED, true)
        final ByteSizeValue actual = ByteSizeValue.parseBytesSizeValue(newSize.getBytes() + "B", key);
        IndexMetadata metadata = newIndexMeta(
        assertEquals(Translog.Durability.ASYNC, settings.getTranslogDurability());
        }  
                .build()
            )  
                bufferInterval,
            "index",  
                    Settings.builder()  
        final IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
    }  
                    .build()
        assertEquals(numShards, settings.getNumberOfShards());
    public void testUpdateDerivedSourceFails() {  
        Settings theSettings = Settings.builder()
    }
                IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY
        assertTrue(settings.isWarmerEnabled());
        SettingsException error = expectThrows(  
        );  
    public void testUpdateRemoteTranslogBufferInterval() {
            Settings.builder()  
        if (randomBoolean()) {  
            );
        );  
                .build()
    }
            .put(IndexMetadata.SETTING_INDEX_UUID, "0xdeadbeef")
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .put(AbstractScopedSettings.ARCHIVED_SETTINGS_PREFIX + "foo", System.currentTimeMillis())
        );
            Settings.builder()
                "index",
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            IndexSettings settings = newIndexSettings(metadata, Settings.EMPTY);  
        assertEquals(actual, settings.getGenerationThresholdSize());  
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            "index",
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        IndexMetadata metadata = newIndexMeta("index", Settings.builder().build());
        assertEquals(  
        );
        {
        assertEquals(Translog.Durability.REQUEST, settings.getTranslogDurability());
                .build()
        TimeValue defaultValue = IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.get(indexSettings);  
                .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "tlog-store")  
        assertEquals("boom", builder.toString());  
/*
        try {
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "")  
    }  
        // Test 5: If derived source is disabled then translog setting value should also be disabled
        assertEquals("repo1", settings.getRemoteStoreRepository());
        Settings nodeSettings = Settings.builder().put("node.attr.remote_store.translog.repository", "my-repo-1").build();
        assertEquals("0xdeadbeef", settings.getUUID());
                .put(IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey(), true)
            "index",
        settings = new IndexSettings(metadata, Settings.EMPTY);
                .build()
        Settings theSettings = Settings.builder()
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            fail("version has changed");  
        assertEquals(200, settings.getMaxInnerResultWindow());
            )  
            Settings.EMPTY  
import static org.hamcrest.CoreMatchers.equalTo;  
        IndexSettings settings = newIndexSettings(newIndexMeta("index", theSettings), Settings.EMPTY, integerSetting, notUpdated);
                false
        SettingsException error = expectThrows(
        assertEquals(99, settings.getMaxRegexLength());
 * The OpenSearch Contributors require contributions made to  
                .put(IndexSettings.MAX_ADJACENCY_MATRIX_FILTERS_SETTING.getKey(), 15)
                SettingsException.class,
            settings.getRemoteTranslogUploadBufferInterval()
    }  
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
        if (randomBoolean()) {  
            settings.updateIndexMetadata(
