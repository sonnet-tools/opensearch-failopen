import org.opensearch.analytics.spi.ScalarFunction;
 * compatible open source license.
        assertTrue(blockList.isBlocked(LUCENE, ScalarFunction.GREATER_THAN));
            @Override
                    Map.entry(ScalarFunction.GREATER_THAN_OR_EQUAL, stub),
                        return Set.of(DelegationType.FILTER);
            public String name() {
        assertFalse(blockList.isBlocked(LUCENE, ScalarFunction.EQUALS));
    /** Lucene-like backend: accepts FILTER delegation and ships serializers for EQUALS + LIKE. */
        assertTrue(blockList.isBlocked(LUCENE, ScalarFunction.IS_NOT_NULL));
import org.opensearch.test.OpenSearchTestCase;
        assertFalse("defaults should be seeded", blockList.isEmpty());
public class DelegationBlockListTests extends OpenSearchTestCase {
                Settings.builder().putList("analytics.delegation.datafusion.blocked_predicates", "LIKE").build()
        assertTrue(blockList.isBlocked(LUCENE, ScalarFunction.LESS_THAN));
package org.opensearch.analytics.settings;
                    public Set<EngineCapability> supportedEngineCapabilities() {
                    public Set<EngineCapability> supportedEngineCapabilities() {
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
                    Map.entry(ScalarFunction.LIKE, stub),
                    @Override
        assertTrue(blockList.isEmpty());
            @Override
    }
}
        assertTrue(blockList.isBlocked(LUCENE, ScalarFunction.SARG_PREDICATE));
import org.opensearch.cluster.metadata.IndexMetadata;
    }
import org.opensearch.analytics.spi.BackendCapabilityProvider;
        );
                DelegatedPredicateSerializer stub = (call, fieldStorage) -> new byte[0];
                    public Set<DelegationType> acceptedDelegations() {
            IllegalArgumentException.class,
            if (c.getMessage() != null && c.getMessage().contains(fragment)) {
        assertTrue("case-insensitive token parsed", blockList.isBlocked(LUCENE, ScalarFunction.EQUALS));
    }
                    Map.entry(ScalarFunction.NOT_EQUALS, stub),
                return true;
        DelegationBlockList blockList = DelegationBlockList.create(clusterSettings(settings), settings, registry());
        CapabilityRegistry reg = new CapabilityRegistry(List.of(luceneWithDefaults), FieldStorageResolver::new);
                return new BackendCapabilityProvider() {
        assertTrue(blockList.isBlocked(LUCENE, ScalarFunction.LIKE));
    }
            () -> clusterSettings.applySettings(
        DelegatedPredicateSerializer stub = (call, fieldStorage) -> new byte[0];
    public void testDynamicUpdate() {
        // Explicit update overrides the seeded default.
        assertFalse(blockList.isBlocked(LUCENE, ScalarFunction.LIKE));
        };
            )
        assertTrue(blockList.isBlocked(LUCENE, ScalarFunction.EQUALS));
                );
                return new BackendCapabilityProvider() {
                Settings.builder().putList("analytics.delegation.lucene.blocked_predicates", "REGEXP").build()
        assertTrue(blockList.isBlocked(LUCENE, ScalarFunction.NOT_EQUALS));
    public void testSeedFromClusterSettings() {
                    Map.entry(ScalarFunction.LESS_THAN_OR_EQUAL, stub),
        return false;
        DelegationBlockList blockList = DelegationBlockList.empty();
        Settings settings = Settings.builder().putList("analytics.delegation.datafusion.blocked_predicates", "LIKE").build();
        }
 */
    private CapabilityRegistry registry() {
/*
        IllegalArgumentException e = expectThrows(
import org.opensearch.analytics.spi.EngineCapability;
import java.util.Map;
        Function<IndexMetadata, FieldStorageResolver> fieldStorageFactory = FieldStorageResolver::new;
        DelegationBlockList.create(clusterSettings, Settings.EMPTY, registry());
        );
            @Override
        );
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
import java.util.Set;
            IllegalArgumentException.class,
        DelegationBlockList.create(clusterSettings, Settings.EMPTY, registry());
        clusterSettings.applySettings(Settings.builder().putList("analytics.delegation.lucene.blocked_predicates", "EQUALS").build());
 * SPDX-License-Identifier: Apache-2.0
    }
        expectThrows(IllegalArgumentException.class, () -> DelegationBlockList.create(clusterSettings(settings), settings, registry()));
        return new ClusterSettings(settings, Set.of(AnalyticsQuerySettings.DELEGATION_BLOCKED_PREDICATES));
            () -> clusterSettings.applySettings(
                    Map.entry(ScalarFunction.IS_NOT_NULL, stub),
    public void testEmptyBlocksNothing() {
    }
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
import java.util.List;
        DelegationBlockList.create(clusterSettings, Settings.EMPTY, registry());
                    }
    private ClusterSettings clusterSettings(Settings settings) {
import org.opensearch.common.settings.ClusterSettings;
    public void testUnknownPredicateNameRejectedByElementParser() {
                    }
    }
        ClusterSettings clusterSettings = clusterSettings(Settings.EMPTY);
    }
                // Only EQUALS and LIKE are delegatable (have serializers) in this fixture.
            }
            public String name() {
            }
        assertTrue(blockList.isBlocked(LUCENE, ScalarFunction.IS_NULL));
                return LUCENE;
        clusterSettings.applySettings(Settings.builder().putList("analytics.delegation.lucene.blocked_predicates").build());
        // Fixture with IS_NULL, IS_NOT_NULL, LIKE serializers — mirrors the real Lucene backend.
                    Map.entry(ScalarFunction.EQUALS, stub),
            @Override
 * this file be licensed under the Apache-2.0 license or a
                };
        // Clearing the list removes all blocks.
    public void testNonAcceptorBackendNamespaceRejected() {
    }
                    Map.entry(ScalarFunction.IS_NULL, stub),
        assertTrue(blockList.isBlocked(LUCENE, ScalarFunction.LESS_THAN_OR_EQUAL));
        ClusterSettings clusterSettings = clusterSettings(Settings.EMPTY);
                return Map.of(ScalarFunction.EQUALS, stub, ScalarFunction.LIKE, stub);
        return new CapabilityRegistry(List.of(lucene), fieldStorageFactory);
    public void testNonDelegatablePredicateRejected() {
            public BackendCapabilityProvider getCapabilityProvider() {
        AnalyticsSearchBackendPlugin luceneWithDefaults = new AnalyticsSearchBackendPlugin() {
            }
import org.opensearch.analytics.spi.DelegationType;
        DelegationBlockList blockList = DelegationBlockList.create(clusterSettings, Settings.EMPTY, registry());
        // datafusion is not a FILTER-delegation acceptor → the namespace is rejected at update time.
                    Map.entry(ScalarFunction.LESS_THAN, stub),
        assertTrue(blockList.isEmpty());
            }
            )
        AnalyticsSearchBackendPlugin lucene = new AnalyticsSearchBackendPlugin() {
                    @Override
import org.opensearch.analytics.planner.CapabilityRegistry;
                        return Set.of();
            }
import org.opensearch.analytics.spi.DelegatedPredicateSerializer;
                    }
        // Defaults seed LIKE (the only default that has a serializer in this fixture).
import org.opensearch.analytics.planner.FieldStorageResolver;
import org.opensearch.common.settings.Settings;
            @Override
            }
            () -> clusterSettings.applySettings(
                    }
        for (Throwable c = t; c != null; c = c.getCause()) {
import java.util.function.Function;
        // A token that isn't a ScalarFunction fails the list element parser at update time.
        IllegalArgumentException e = expectThrows(
        assertFalse(blockList.isBlocked(LUCENE, ScalarFunction.LIKE));
            IllegalArgumentException.class,
                        return Set.of(DelegationType.FILTER);
        assertFalse(blockList.isBlocked(LUCENE, ScalarFunction.LIKE));
            public BackendCapabilityProvider getCapabilityProvider() {
    public void testDefaultsSeededWhenSettingsEmpty() {
 * The OpenSearch Contributors require contributions made to
        assertTrue("cause: " + e, causeChainContains(e, "not delegatable"));
        assertTrue(blockList.isBlocked(LUCENE, ScalarFunction.LIKE));
    private static final String LUCENE = "lucene";
                    @Override
        expectThrows(
 *
                    public Set<DelegationType> acceptedDelegations() {
            )
        assertTrue(blockList.isBlocked(LUCENE, ScalarFunction.GREATER_THAN_OR_EQUAL));
    }
                Settings.builder().putList("analytics.delegation.lucene.blocked_predicates", "NONSENSE").build()
                return LUCENE;
                    Map.entry(ScalarFunction.GREATER_THAN, stub),
        // REGEXP has no serializer in this fixture → rejected even for the valid lucene namespace.
    /** The cluster-settings layer wraps the validator's IllegalArgumentException; search the chain. */
        ClusterSettings clusterSettings = clusterSettings(Settings.EMPTY);
            @Override
            }
    private static boolean causeChainContains(Throwable t, String fragment) {
        ClusterSettings clusterSettings = clusterSettings(Settings.EMPTY);
                return Map.ofEntries(
        DelegationBlockList blockList = DelegationBlockList.create(clusterSettings(Settings.EMPTY), Settings.EMPTY, reg);
                    @Override
                        return Set.of();
        };
        assertTrue(blockList.isBlocked(LUCENE, ScalarFunction.LIKE));
    }
                };
        Settings settings = Settings.builder().putList("analytics.delegation.lucene.blocked_predicates", "LIKE", "equals").build();
        assertTrue("cause: " + e, causeChainContains(e, "not a delegation-target backend"));
                    Map.entry(ScalarFunction.SARG_PREDICATE, stub)
    public void testSeedRejectsInvalidNamespaceAtConstruction() {
