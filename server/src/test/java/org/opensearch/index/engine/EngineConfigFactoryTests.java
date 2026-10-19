    }  
    private static EngineConfig newEngineConfig(EngineConfigFactory factory, IndexSettings indexSettings) {  
        public Optional<AdditionalCodecs> getAdditionalCodecs(IndexSettings indexSettings) {
        @Override
        // the plugin changes its answer between engine builds (e.g. a replication role flip); the next
            public Optional<EngineFactory> getEngineFactory(IndexSettings indexSettings) {
            null,
        IndexSettings indexSettings = newIndexSettings();  
        public Optional<EngineFactory> getEngineFactory(final IndexSettings indexSettings) {
        assertNotNull(config.getCustomTranslogDeletionPolicyFactory());
            null,
import org.opensearch.Version;
        List<EnginePlugin> plugins = Arrays.asList(new FooEnginePlugin(), new BakEnginePlugin());  
            null,  
        }  
            null
        @Override
            return Optional.of(new AdditionalCodecs() {
        public void setRetentionAgeInMillis(long ageInMillis) {
            });
            null,
            () -> Boolean.TRUE,
    }
            null,
            .settings(settings(Version.CURRENT))
        };
        );
        IndexSettings indexSettings = newIndexSettings();
            .numberOfShards(1)  
                )
            null,  
            return Optional.of(CustomTranslogDeletionPolicy::new);
            super();
    public void testCreateEngineConfigFromFactoryMultipleCodecServiceAndFactoryIllegalStateException() {  
            indexSettings,
        }  
        }
            new InternalTranslogFactory(),
            Collections.singletonList(new PrimaryOperationPolicyEnginePlugin(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE)),
    }
    }
        EnginePlugin plugin = new EnginePlugin() {
        }  
        assertTrue(config.getCustomTranslogDeletionPolicyFactory().create(indexSettings, null) instanceof CustomTranslogDeletionPolicy);  
            this(Map.of());
            null,
        List<EnginePlugin> plugins = Arrays.asList(new BazEnginePlugin(Map.of("test", new SimpleTextCodec())));  
        IndexMetadata meta = IndexMetadata.builder("test")
                public Map<String, Codec> getCodecs(
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", meta.getSettings());
            .numberOfShards(1)  
            .build();
        final CodecService codecService = factory.newDefaultCodecService(indexSettings, null, logger);
            TimeValue.timeValueMinutes(5),  
            .numberOfReplicas(1)
    }
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", meta.getSettings());
            null,
        List<EnginePlugin> plugins = Arrays.asList(
        @Override  
     * A shard can become a primary without a new engine, and therefore without a new config, so a single
        }
            null,  
                return Optional.ofNullable(pluginPolicy.get());
        }  
        EngineConfig config = newEngineConfig(factory, indexSettings);  
            null,
 * compatible open source license.
            }  
        assertSame(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE, config.getPrimaryOperationPolicy());
    private static class BarEnginePlugin extends Plugin implements EnginePlugin {
            null,
        EnginePlugin enginePluginThatImplementsGetEngineFactory = new EnginePlugin() {
import java.util.Optional;
        EngineConfig config = newEngineConfig(factory, indexSettings);  
    }
            .numberOfShards(1)  
                config -> new CodecService(
            null,  
                return Optional.of(engineFactory);
            return Optional.of(new CodecService(null, indexSettings, LogManager.getLogger(getClass()), List.of()));
        assertThat(codecService.codec("test"), is(instanceOf(SimpleTextCodec.class)));
        BazEnginePlugin(final Map<String, Codec> additionalCodecs) {
            null,  
            new PrimaryOperationPolicyEnginePlugin(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE),  
    }  
import static org.hamcrest.CoreMatchers.is;  
        pluginPolicy.set(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE);
    }  
 * The OpenSearch Contributors require contributions made to  
    }
        IndexSettings indexSettings = newIndexSettings();
            () -> Boolean.TRUE,
            () -> new RetentionLeases(0, 0, Collections.emptyList()),  
        assertEquals(engineFactory, enginePluginThatImplementsGetEngineFactory.getEngineFactory(null).orElse(null));
            null,
            null,  
        }
            null,
    }
                    Supplier<Codec> defaultCodec
    }
            @Override  
            null,
        }
            }
            null,
    }
            .numberOfShards(1)  
        // the second plugin starts overriding it too, so the next engine build must reject the conflict  
    }  
    private static class BazEnginePlugin extends Plugin implements EnginePlugin {  
import java.util.Collections;
            .build();
        @Override
        @Override
        @Override
            null,
            null,
    }
        public Optional<CodecService> getCustomCodecService(IndexSettings indexSettings) {  
        @Override
            () -> new RetentionLeases(0, 0, Collections.emptyList()),  
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", meta.getSettings());
            null,
            null,
import org.opensearch.plugins.EnginePlugin;  
            this.additionalCodecs = additionalCodecs;
        IndexMetadata meta = IndexMetadata.builder("test")
        );
        protected void setRetentionTotalFiles(int retentionTotalFiles) {
            .settings(settings(Version.CURRENT))
import org.opensearch.test.IndexSettingsModule;
            return Optional.of(new CodecService(null, indexSettings, LogManager.getLogger(getClass()), List.of()));
        List<EnginePlugin> plugins = Arrays.asList(  
        assertSame(
            null,  
            null,
        expectThrows(IllegalStateException.class, () -> new EngineConfigFactory(plugins, indexSettings));  
            return 0;
        assertFalse(plugin.getPrimaryOperationPolicy(null).isPresent());  
        // config must reflect it without a new factory
        public Optional<EngineFactory> getEngineFactory(final IndexSettings indexSettings) {  
                public Optional<PrimaryOperationPolicy> getPrimaryOperationPolicy(IndexSettings settings) {  
            null,  
                return Optional.ofNullable(pluginPolicy.get());  
import org.opensearch.plugins.Plugin;
        assertThat(config.getPrimaryOperationPolicy(), is(DefaultPrimaryOperationPolicy.INSTANCE));
        IndexMetadata meta = IndexMetadata.builder("test")
        assertNotSame(DefaultPrimaryOperationPolicy.INSTANCE, config.getPrimaryOperationPolicy());
        EngineConfigFactory factory = new EngineConfigFactory(Collections.singletonList(plugin), indexSettings);  
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", meta.getSettings());
        );  
    public void testMultiplePrimaryOperationPoliciesIllegalStateException() {
            return Optional.empty();
            .numberOfReplicas(1)
                    config.getMapperService(),  
            null,
        pluginPolicy.set(null);  
            null,
        assertSame(DefaultPrimaryOperationPolicy.INSTANCE, config.getPrimaryOperationPolicy());
import org.opensearch.index.IndexSettings;
            .numberOfReplicas(1)
        IndexSettings indexSettings = newIndexSettings();
            null,
            TimeValue.timeValueMinutes(5),  
        public Optional<PrimaryOperationPolicy> getPrimaryOperationPolicy(IndexSettings indexSettings) {
                    List.of()  
            .settings(settings(Version.CURRENT))
            null,
        // the plugin starts overriding the policy, e.g. because a setting it keys off was updated  
            @Override
            null,
        assertFalse(enginePluginThatDoesNotImplementsGetEngineFactory.getEngineFactory(null).isPresent());  
            .settings(settings(Version.CURRENT))
import org.opensearch.index.seqno.RetentionLeases;  
/*  
        }  
package org.opensearch.index.engine;
            null,
        );
            null
    private static class CustomTranslogDeletionPolicy extends TranslogDeletionPolicy {  
import org.opensearch.cluster.metadata.IndexMetadata;
            .settings(settings(Version.CURRENT))
        EngineConfig config = factory.newEngineConfig(
            null,
            .numberOfReplicas(1)
            new PrimaryOperationPolicyEnginePlugin(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE)
        // only one plugin overrides the policy at construction, so the conflict cannot be detected up front
        };
        assertSame(
            .numberOfReplicas(1)
import org.opensearch.common.unit.TimeValue;  
     */
    public void testGetEngineFactory() {  
            null,
        EngineConfigFactory factory = new EngineConfigFactory(plugins, indexSettings);
        );
        EngineConfigFactory factory = new EngineConfigFactory(Collections.singletonList(new FooEnginePlugin()), indexSettings);
import org.opensearch.index.translog.TranslogDeletionPolicyFactory;  
        @Override  
            null,  
    public void testMultiplePrimaryOperationPoliciesIllegalStateExceptionOnEngineConfig() {
        EngineConfigFactory factory = new EngineConfigFactory(
        public void setRetentionSizeInBytes(long bytes) {  
        }
        @Override  
            null,
            @Override  
        public Optional<TranslogDeletionPolicyFactory> getCustomTranslogDeletionPolicyFactory() {
        BazEnginePlugin() {  
            .settings(settings(Version.CURRENT))
    public void testCreateEngineConfigFromFactoryAdditionalCodecsConflict() {
        assertThat(config.getPrimaryOperationPolicy(), is(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE));  
            null,
            FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE,
    public void testPrimaryOperationPolicyReconsultedOnEachEngineConfig() {  
 */  
        EngineConfigFactory factory = new EngineConfigFactory(Collections.singletonList(plugin), indexSettings);
            null,  
            null,  
 * this file be licensed under the Apache-2.0 license or a
            }  
        IndexMetadata meta = IndexMetadata.builder("test")
        EngineConfigFactory factory = new EngineConfigFactory(plugins, indexSettings);  
        }  
            null,
        EnginePlugin plugin = new EnginePlugin() {
            null,
            newEngineConfig(factory, indexSettings).getPrimaryOperationPolicy()
            public Optional<PrimaryOperationPolicy> getPrimaryOperationPolicy(IndexSettings settings) {
        @Override
    public void testCreateEngineConfigFromFactoryMultipleCustomTranslogDeletionPolicyFactoryIllegalStateException() {  
            .build();
    }
    }  
    private static class PrimaryOperationPolicyEnginePlugin extends Plugin implements EnginePlugin {
import org.opensearch.index.translog.InternalTranslogFactory;
import java.util.List;
                    IndexSettings indexSettings,  
        };
        EnginePlugin plugin = new EnginePlugin() {  
        PrimaryOperationPolicyEnginePlugin(PrimaryOperationPolicy provider) {
            null,
        public Optional<CodecService> getCustomCodecService(IndexSettings indexSettings) {
            null,  
            null,
                }
            return Optional.of(CustomTranslogDeletionPolicy::new);  
        };
        public long minTranslogGenRequired(List<TranslogReader> readers, TranslogWriter writer) throws IOException {  
        @Override  
            .settings(settings(Version.CURRENT))
        EnginePlugin enginePluginThatDoesNotImplementsGetEngineFactory = new EnginePlugin() {
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> new EngineConfigFactory(plugins, indexSettings));
                @Override
            null,
        expectThrows(IllegalStateException.class, () -> new EngineConfigFactory(plugins, indexSettings));  
import org.opensearch.index.translog.TranslogWriter;
    }
        public Optional<CodecServiceFactory> getCustomCodecServiceFactory(IndexSettings indexSettings) {  
        }  
        IndexSettings indexSettings = newIndexSettings();  
            null,
            null,
        IndexMetadata meta = IndexMetadata.builder("test")  
            null,  
            newEngineConfig(factory, indexSettings).getPrimaryOperationPolicy()  
            indexSettings,
            null,
import org.opensearch.index.codec.CodecServiceFactory;
        List<EnginePlugin> plugins = Collections.singletonList(new FooEnginePlugin());  
            null,
            indexSettings  
            null,
        assertNotNull(config.getCodec());
            null,
        }  
        assertSame(DefaultPrimaryOperationPolicy.INSTANCE, config.toBuilder().build().getPrimaryOperationPolicy());  
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", meta.getSettings());
        }
        List<EnginePlugin> plugins = Arrays.asList(new BazEnginePlugin(Map.of("zlib", new SimpleTextCodec())));
            null,
            new InternalTranslogFactory(),
    }  
            () -> Boolean.TRUE,
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", meta.getSettings());
public class EngineConfigFactoryTests extends OpenSearchTestCase {
        pluginPolicy.set(null);
        List<EnginePlugin> plugins = Arrays.asList(new BakEnginePlugin());  
        EngineConfigFactory factory = new EngineConfigFactory(plugins, indexSettings);
            indexSettings,
            .build();
            TimeValue.timeValueMinutes(5),  
        public Optional<EngineFactory> getEngineFactory(final IndexSettings indexSettings) {
        assertSame(DefaultPrimaryOperationPolicy.INSTANCE, config.getPrimaryOperationPolicy());
            null,  
            .numberOfShards(1)  
            null,  
    }
            new PrimaryOperationPolicyEnginePlugin(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE),
            this.provider = provider;  
            null,  
        );
        private final Map<String, Codec> additionalCodecs;
        }
    }
            new InternalTranslogFactory(),
            .build();
        @Override  
        return factory.newEngineConfig(
import org.opensearch.index.codec.AdditionalCodecs;
            .build();
        EngineConfigFactory factory = new EngineConfigFactory(plugins, indexSettings);
            public Optional<PrimaryOperationPolicy> getPrimaryOperationPolicy(IndexSettings settings) {
            null,
            null,  
        private final PrimaryOperationPolicy provider;  
                @Override  
        AtomicReference<PrimaryOperationPolicy> pluginPolicy = new AtomicReference<>();
    public void testCreateEngineConfigFromFactoryMultipleCodecServiceIllegalStateException() {  
import org.apache.logging.log4j.LogManager;
            .numberOfShards(1)
            return Optional.empty();  
            null,
        };
import org.opensearch.test.OpenSearchTestCase;  
        EngineConfigFactory factory = new EngineConfigFactory(plugins, indexSettings);  
        EngineConfig config = factory.newEngineConfig(
        assertThrows(IllegalStateException.class, () -> factory.newDefaultCodecService(indexSettings, null, logger));  
    }  
            null,
        IndexMetadata meta = IndexMetadata.builder("test")
        AtomicReference<PrimaryOperationPolicy> latePluginPolicy = new AtomicReference<>();
        IndexSettings indexSettings = newIndexSettings();  
import java.util.Map;  
        List<EnginePlugin> plugins = Arrays.asList(new FooEnginePlugin(), new BarEnginePlugin());  
        AtomicReference<PrimaryOperationPolicy> pluginPolicy = new AtomicReference<>(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE);
        // and a config copied from it carries the resolver rather than a stale resolved policy
            null,
        public Optional<TranslogDeletionPolicyFactory> getCustomTranslogDeletionPolicyFactory() {  
    public void testCreateEngineConfigFromFactoryAdditionalCodecs() {  
            null,
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> newEngineConfig(factory, indexSettings));
import org.apache.lucene.codecs.simpletext.SimpleTextCodec;  
        expectThrows(IllegalStateException.class, () -> new EngineConfigFactory(plugins, indexSettings));  
            null,  
            return Optional.empty();
        public CustomTranslogDeletionPolicy(IndexSettings indexSettings, Supplier<RetentionLeases> retentionLeasesSupplier) {
            null,
     * config must re-consult the plugins on every read rather than caching the answer from build time.  
        return IndexSettingsModule.newIndexSettings("test", meta.getSettings());  
            null,
        IndexMetadata meta = IndexMetadata.builder("test")
        assertTrue(e.getMessage(), e.getMessage().contains("PrimaryOperationPolicy is already overridden"));  
    }
            return Optional.of(
    public void testCreateCodecServiceFromFactory() {  
        @Override
    public void testCreateEngineConfigFromFactory() {  
        final EngineFactory engineFactory = config -> null;
            null,  
        );
        public Optional<EngineFactory> getEngineFactory(final IndexSettings indexSettings) {
import java.util.function.Supplier;  
        EngineConfig config = newEngineConfig(factory, indexSettings);
                    MapperService mapperService,
            null,
            null,  
        IndexMetadata meta = IndexMetadata.builder("test")
            FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE,  
            null,  
            false,  
        }
            null,  
            .numberOfReplicas(1)
                    config.getIndexSettings(),
    public void testPrimaryOperationPolicyFromPlugin() {
            .numberOfShards(1)  
        latePluginPolicy.set(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE);
        }
            return Optional.empty();
            () -> new RetentionLeases(0, 0, Collections.emptyList()),  
            return Optional.of(provider);
            null,
                    return Optional.ofNullable(latePluginPolicy.get());
                    return additionalCodecs;  
                ) {
import org.opensearch.index.mapper.MapperService;
 *
                    LogManager.getLogger(getClass()),
        assertSame(DefaultPrimaryOperationPolicy.INSTANCE, newEngineConfig(factory, indexSettings).getPrimaryOperationPolicy());
import java.io.IOException;
    public void testPrimaryOperationPolicyReconsultedOnEachReadOfOneConfig() {
            }  
        @Override  
import org.apache.lucene.codecs.Codec;
    }
    private static IndexSettings newIndexSettings() {  
import static org.hamcrest.CoreMatchers.instanceOf;
            null,  
            .settings(settings(Version.CURRENT))
            .build();
            false,  
import org.opensearch.index.translog.TranslogReader;
                }
import java.util.concurrent.atomic.AtomicReference;
            null,
            null,
        }  
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", meta.getSettings());  
            new EnginePlugin() {
            );
    private static class FooEnginePlugin extends Plugin implements EnginePlugin {  
import org.opensearch.index.codec.CodecService;  
import java.util.Arrays;  
        assertNotNull(config.getCodec());  
        @Override
            .numberOfReplicas(1)
            false,  
            null
        }
            null,
            .build();
            null,  
    private static class BakEnginePlugin extends Plugin implements EnginePlugin {
            null,
}
            .numberOfReplicas(1)  
    /**
            null,
        List<EnginePlugin> plugins = Arrays.asList(new FooEnginePlugin(), new BazEnginePlugin());  
 * SPDX-License-Identifier: Apache-2.0
    public void testGetPrimaryOperationPolicyIsEmptyByDefault() {  
    public void testPrimaryOperationPolicyDefaultsWhenNoPluginSuppliesOne() {  
            .numberOfShards(1)  
        );
import org.opensearch.index.translog.TranslogDeletionPolicy;
        assertTrue(e.getMessage(), e.getMessage().contains("PrimaryOperationPolicy is already overridden"));
            null,
