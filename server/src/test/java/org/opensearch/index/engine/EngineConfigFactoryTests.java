import org.opensearch.index.codec.AdditionalCodecs;
            new InternalTranslogFactory(),
            .build();
    }
        // the plugin changes its answer between engine builds (e.g. a replication role flip); the next
            .numberOfReplicas(1)
package org.opensearch.index.engine;
import org.opensearch.index.translog.InternalTranslogFactory;
import org.apache.lucene.codecs.Codec;
        // the plugin starts overriding the policy, e.g. because a setting it keys off was updated
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", meta.getSettings());
        // and a config copied from it carries the resolver rather than a stale resolved policy
    public void testCreateEngineConfigFromFactoryAdditionalCodecs() {
            .build();
            null,
            );
        );
    public void testCreateEngineConfigFromFactoryMultipleCodecServiceIllegalStateException() {
        public Optional<TranslogDeletionPolicyFactory> getCustomTranslogDeletionPolicyFactory() {
            null,
            null,
        assertSame(DefaultPrimaryOperationPolicy.INSTANCE, newEngineConfig(factory, indexSettings).getPrimaryOperationPolicy());
        List<EnginePlugin> plugins = Arrays.asList(
        }
            return Optional.of(new CodecService(null, indexSettings, LogManager.getLogger(getClass()), List.of()));
        EngineConfigFactory factory = new EngineConfigFactory(plugins, indexSettings);
        }
        public void setRetentionSizeInBytes(long bytes) {
            () -> Boolean.TRUE,
            .settings(settings(Version.CURRENT))
    }
                }
        assertSame(DefaultPrimaryOperationPolicy.INSTANCE, config.toBuilder().build().getPrimaryOperationPolicy());
        AtomicReference<PrimaryOperationPolicy> latePluginPolicy = new AtomicReference<>();
            null,
        public Optional<PrimaryOperationPolicy> getPrimaryOperationPolicy(IndexSettings indexSettings) {
            indexSettings
            .numberOfReplicas(1)
        IndexMetadata meta = IndexMetadata.builder("test")
            null,
            null,
            return Optional.of(provider);
            .numberOfReplicas(1)
 */
            null,
    }
 * compatible open source license.
        assertEquals(engineFactory, enginePluginThatImplementsGetEngineFactory.getEngineFactory(null).orElse(null));
            null,
            null,
        }
        EnginePlugin plugin = new EnginePlugin() {
            .numberOfReplicas(1)
    public void testGetPrimaryOperationPolicyIsEmptyByDefault() {
            public Optional<PrimaryOperationPolicy> getPrimaryOperationPolicy(IndexSettings settings) {
            null
        EngineConfig config = factory.newEngineConfig(
            null,
            TimeValue.timeValueMinutes(5),
        assertNotNull(config.getCustomTranslogDeletionPolicyFactory());
        EngineConfig config = newEngineConfig(factory, indexSettings);
            null,
            .numberOfShards(1)
        );
    public void testGetEngineFactory() {
            null,
    private static EngineConfig newEngineConfig(EngineConfigFactory factory, IndexSettings indexSettings) {
            null,
            .build();
        // config must reflect it without a new factory
}
    }
            indexSettings,
        assertThrows(IllegalStateException.class, () -> factory.newDefaultCodecService(indexSettings, null, logger));
        List<EnginePlugin> plugins = Collections.singletonList(new FooEnginePlugin());
            null,
        assertTrue(config.getCustomTranslogDeletionPolicyFactory().create(indexSettings, null) instanceof CustomTranslogDeletionPolicy);
        return IndexSettingsModule.newIndexSettings("test", meta.getSettings());
            null
            .numberOfShards(1)
            this.additionalCodecs = additionalCodecs;
        AtomicReference<PrimaryOperationPolicy> pluginPolicy = new AtomicReference<>(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE);
            this(Map.of());
     */
        IndexSettings indexSettings = newIndexSettings();
import java.util.Map;
        }
        protected void setRetentionTotalFiles(int retentionTotalFiles) {
        }
            .settings(settings(Version.CURRENT))
        assertThat(config.getPrimaryOperationPolicy(), is(DefaultPrimaryOperationPolicy.INSTANCE));
            false,
            FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE,
        IndexSettings indexSettings = newIndexSettings();
            .settings(settings(Version.CURRENT))
            new PrimaryOperationPolicyEnginePlugin(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE)
            new EnginePlugin() {
        EngineConfig config = factory.newEngineConfig(
        @Override
            null,
            null,
            null,
        }
            indexSettings,
        List<EnginePlugin> plugins = Arrays.asList(new FooEnginePlugin(), new BazEnginePlugin());
        pluginPolicy.set(null);
        public long minTranslogGenRequired(List<TranslogReader> readers, TranslogWriter writer) throws IOException {
                public Optional<PrimaryOperationPolicy> getPrimaryOperationPolicy(IndexSettings settings) {
        BazEnginePlugin() {
        };
        return factory.newEngineConfig(
import org.opensearch.index.mapper.MapperService;
        );
import java.util.Arrays;
    public void testPrimaryOperationPolicyFromPlugin() {
        }
            null,
        }
 * SPDX-License-Identifier: Apache-2.0
            FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE,
        assertThat(codecService.codec("test"), is(instanceOf(SimpleTextCodec.class)));
    }
        List<EnginePlugin> plugins = Arrays.asList(new BakEnginePlugin());
            return 0;
            .numberOfShards(1)
        @Override
            null,
            null,
    public void testPrimaryOperationPolicyReconsultedOnEachReadOfOneConfig() {
        expectThrows(IllegalStateException.class, () -> new EngineConfigFactory(plugins, indexSettings));
        }
                    return Optional.ofNullable(latePluginPolicy.get());
            return Optional.empty();
            null,
    }
            null,
            }
                return Optional.of(engineFactory);
        @Override
    public void testCreateEngineConfigFromFactory() {
                    LogManager.getLogger(getClass()),
            return Optional.of(new CodecService(null, indexSettings, LogManager.getLogger(getClass()), List.of()));
            null,
            null,
            new PrimaryOperationPolicyEnginePlugin(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE),
            .settings(settings(Version.CURRENT))
            new PrimaryOperationPolicyEnginePlugin(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE),
            null,
import java.util.concurrent.atomic.AtomicReference;
import static org.hamcrest.CoreMatchers.is;
            null,
    private static class BarEnginePlugin extends Plugin implements EnginePlugin {
import java.io.IOException;
import java.util.List;
            null,
            .numberOfReplicas(1)
                    config.getMapperService(),
                    config.getIndexSettings(),
        AtomicReference<PrimaryOperationPolicy> pluginPolicy = new AtomicReference<>();
            null,
        assertThat(config.getPrimaryOperationPolicy(), is(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE));
    public void testCreateEngineConfigFromFactoryAdditionalCodecsConflict() {
            null,
            newEngineConfig(factory, indexSettings).getPrimaryOperationPolicy()
            }
    }
        assertSame(
        );
            null,
            null,
        }
            null,
            null,
            () -> new RetentionLeases(0, 0, Collections.emptyList()),
import org.opensearch.plugins.Plugin;
public class EngineConfigFactoryTests extends OpenSearchTestCase {
        @Override
    }
import org.opensearch.test.IndexSettingsModule;
        public Optional<CodecService> getCustomCodecService(IndexSettings indexSettings) {
            null,
            return Optional.of(new AdditionalCodecs() {
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", meta.getSettings());
            null,
        );
    }
import java.util.Optional;
        List<EnginePlugin> plugins = Arrays.asList(new BazEnginePlugin(Map.of("test", new SimpleTextCodec())));
import org.opensearch.common.unit.TimeValue;
        EngineConfigFactory factory = new EngineConfigFactory(Collections.singletonList(new FooEnginePlugin()), indexSettings);
import org.apache.logging.log4j.LogManager;
                    IndexSettings indexSettings,
            return Optional.empty();
        @Override
        public Optional<EngineFactory> getEngineFactory(final IndexSettings indexSettings) {
import java.util.Collections;
        EnginePlugin enginePluginThatImplementsGetEngineFactory = new EnginePlugin() {
            null,
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> new EngineConfigFactory(plugins, indexSettings));
        PrimaryOperationPolicyEnginePlugin(PrimaryOperationPolicy provider) {
    }
                    return additionalCodecs;
        IndexMetadata meta = IndexMetadata.builder("test")
        }
            null,
        };
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", meta.getSettings());
        EngineConfig config = newEngineConfig(factory, indexSettings);
        @Override
            null,
        assertTrue(e.getMessage(), e.getMessage().contains("PrimaryOperationPolicy is already overridden"));
            }
        EngineConfigFactory factory = new EngineConfigFactory(plugins, indexSettings);
            null,
        public Optional<EngineFactory> getEngineFactory(final IndexSettings indexSettings) {
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", meta.getSettings());
        assertNotNull(config.getCodec());
            .build();
 * The OpenSearch Contributors require contributions made to
            new InternalTranslogFactory(),
            TimeValue.timeValueMinutes(5),
    }
        }
        IndexSettings indexSettings = newIndexSettings();
            null,
    /**
import org.opensearch.Version;
            @Override
            null,
        // only one plugin overrides the policy at construction, so the conflict cannot be detected up front
        }
        @Override
        EngineConfigFactory factory = new EngineConfigFactory(plugins, indexSettings);
            .numberOfShards(1)
import org.apache.lucene.codecs.simpletext.SimpleTextCodec;
            null,
            null,
    private static class BazEnginePlugin extends Plugin implements EnginePlugin {
        pluginPolicy.set(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE);
            null,
        BazEnginePlugin(final Map<String, Codec> additionalCodecs) {
        final CodecService codecService = factory.newDefaultCodecService(indexSettings, null, logger);
            .numberOfReplicas(1)
        IndexMetadata meta = IndexMetadata.builder("test")
            null,
            .numberOfReplicas(1)
            null,
        public CustomTranslogDeletionPolicy(IndexSettings indexSettings, Supplier<RetentionLeases> retentionLeasesSupplier) {
            .build();
            null,
            public Optional<PrimaryOperationPolicy> getPrimaryOperationPolicy(IndexSettings settings) {
        List<EnginePlugin> plugins = Arrays.asList(new FooEnginePlugin(), new BarEnginePlugin());
        public Optional<EngineFactory> getEngineFactory(final IndexSettings indexSettings) {
            Collections.singletonList(new PrimaryOperationPolicyEnginePlugin(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE)),
        assertSame(DefaultPrimaryOperationPolicy.INSTANCE, config.getPrimaryOperationPolicy());
            @Override
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", meta.getSettings());
    }
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", meta.getSettings());
import org.opensearch.index.codec.CodecServiceFactory;
        EnginePlugin enginePluginThatDoesNotImplementsGetEngineFactory = new EnginePlugin() {
        );
        IndexMetadata meta = IndexMetadata.builder("test")
                @Override
    public void testCreateEngineConfigFromFactoryMultipleCustomTranslogDeletionPolicyFactoryIllegalStateException() {
            null,
    public void testMultiplePrimaryOperationPoliciesIllegalStateExceptionOnEngineConfig() {
            .numberOfReplicas(1)
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> newEngineConfig(factory, indexSettings));
        @Override
        IndexMetadata meta = IndexMetadata.builder("test")
            null,
            @Override
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", meta.getSettings());
            null
            null,
import java.util.function.Supplier;
        private final PrimaryOperationPolicy provider;
        final EngineFactory engineFactory = config -> null;
        assertSame(DefaultPrimaryOperationPolicy.INSTANCE, config.getPrimaryOperationPolicy());
            .settings(settings(Version.CURRENT))
        EngineConfigFactory factory = new EngineConfigFactory(Collections.singletonList(plugin), indexSettings);
    }
    }
                    MapperService mapperService,
    private static IndexSettings newIndexSettings() {
            new InternalTranslogFactory(),
        @Override
import org.opensearch.index.translog.TranslogDeletionPolicy;
                    Supplier<Codec> defaultCodec
            public Optional<EngineFactory> getEngineFactory(IndexSettings indexSettings) {
                return Optional.ofNullable(pluginPolicy.get());
            .build();
            null,
        expectThrows(IllegalStateException.class, () -> new EngineConfigFactory(plugins, indexSettings));
    }
        public Optional<TranslogDeletionPolicyFactory> getCustomTranslogDeletionPolicyFactory() {
        List<EnginePlugin> plugins = Arrays.asList(
        }
 * this file be licensed under the Apache-2.0 license or a
            TimeValue.timeValueMinutes(5),
 *
                    List.of()
        assertFalse(enginePluginThatDoesNotImplementsGetEngineFactory.getEngineFactory(null).isPresent());
            null,
    public void testMultiplePrimaryOperationPoliciesIllegalStateException() {
            .numberOfShards(1)
        @Override
    }
                public Map<String, Codec> getCodecs(
        EngineConfigFactory factory = new EngineConfigFactory(Collections.singletonList(plugin), indexSettings);
    }
            });
            null,
            null,
import org.opensearch.test.OpenSearchTestCase;
            () -> new RetentionLeases(0, 0, Collections.emptyList()),
                }
        IndexSettings indexSettings = newIndexSettings();
    private static class FooEnginePlugin extends Plugin implements EnginePlugin {
        IndexMetadata meta = IndexMetadata.builder("test")
/*
                config -> new CodecService(
            return Optional.of(CustomTranslogDeletionPolicy::new);
        EngineConfigFactory factory = new EngineConfigFactory(
            null,
    private static class BakEnginePlugin extends Plugin implements EnginePlugin {
    }
            null,
            null,
            null,
            null,
        }
            super();
        IndexSettings indexSettings = newIndexSettings();
            null,
            return Optional.of(
            null,
            null,
     * config must re-consult the plugins on every read rather than caching the answer from build time.
        };
        }
        assertNotSame(DefaultPrimaryOperationPolicy.INSTANCE, config.getPrimaryOperationPolicy());
    public void testPrimaryOperationPolicyReconsultedOnEachEngineConfig() {
    }
import static org.hamcrest.CoreMatchers.instanceOf;
        assertTrue(e.getMessage(), e.getMessage().contains("PrimaryOperationPolicy is already overridden"));
import org.opensearch.index.seqno.RetentionLeases;
        pluginPolicy.set(null);
                )
    public void testCreateCodecServiceFromFactory() {
        public Optional<EngineFactory> getEngineFactory(final IndexSettings indexSettings) {
        assertNotNull(config.getCodec());
        );
        expectThrows(IllegalStateException.class, () -> new EngineConfigFactory(plugins, indexSettings));
import org.opensearch.plugins.EnginePlugin;
        };
import org.opensearch.index.IndexSettings;
            null,
        EngineConfig config = newEngineConfig(factory, indexSettings);
    }
            null,
            () -> Boolean.TRUE,
import org.opensearch.index.translog.TranslogWriter;
            null,
        };
        IndexMetadata meta = IndexMetadata.builder("test")
    private static class CustomTranslogDeletionPolicy extends TranslogDeletionPolicy {
        assertSame(
        @Override
                return Optional.ofNullable(pluginPolicy.get());
            }
        // the second plugin starts overriding it too, so the next engine build must reject the conflict
            .build();
            false,
            indexSettings,
            false,
            null,
        @Override
            null,
            null,
        }
        );
import org.opensearch.index.codec.CodecService;
            .settings(settings(Version.CURRENT))
            null,
            null,
            .numberOfShards(1)
            .build();
        EnginePlugin plugin = new EnginePlugin() {
            null,
            .numberOfShards(1)
        assertSame(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE, config.getPrimaryOperationPolicy());
        public Optional<AdditionalCodecs> getAdditionalCodecs(IndexSettings indexSettings) {
            newEngineConfig(factory, indexSettings).getPrimaryOperationPolicy()
    }
        EnginePlugin plugin = new EnginePlugin() {
            null,
            return Optional.of(CustomTranslogDeletionPolicy::new);
        }
    }
        @Override
            return Optional.empty();
        IndexSettings indexSettings = newIndexSettings();
            this.provider = provider;
    public void testPrimaryOperationPolicyDefaultsWhenNoPluginSuppliesOne() {
            .settings(settings(Version.CURRENT))
        assertFalse(plugin.getPrimaryOperationPolicy(null).isPresent());
            null,
import org.opensearch.cluster.metadata.IndexMetadata;
        public void setRetentionAgeInMillis(long ageInMillis) {
import org.opensearch.index.translog.TranslogDeletionPolicyFactory;
            () -> Boolean.TRUE,
            .settings(settings(Version.CURRENT))
        private final Map<String, Codec> additionalCodecs;
        latePluginPolicy.set(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE);
                ) {
import org.opensearch.index.translog.TranslogReader;
        List<EnginePlugin> plugins = Arrays.asList(new BazEnginePlugin(Map.of("zlib", new SimpleTextCodec())));
        @Override
            null,
            null,
            null,
        List<EnginePlugin> plugins = Arrays.asList(new FooEnginePlugin(), new BakEnginePlugin());
        IndexMetadata meta = IndexMetadata.builder("test")
    }
    public void testCreateEngineConfigFromFactoryMultipleCodecServiceAndFactoryIllegalStateException() {
    private static class PrimaryOperationPolicyEnginePlugin extends Plugin implements EnginePlugin {
        }
            return Optional.empty();
        EngineConfigFactory factory = new EngineConfigFactory(plugins, indexSettings);
            .numberOfShards(1)
        @Override
                @Override
            null,
     * A shard can become a primary without a new engine, and therefore without a new config, so a single
            () -> new RetentionLeases(0, 0, Collections.emptyList()),
        public Optional<CodecService> getCustomCodecService(IndexSettings indexSettings) {
        public Optional<CodecServiceFactory> getCustomCodecServiceFactory(IndexSettings indexSettings) {
        EngineConfigFactory factory = new EngineConfigFactory(plugins, indexSettings);
            null,
