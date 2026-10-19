    private static boolean causeChainContains(Throwable t, String fragment) {
                        return Set.of();
                DelegatedPredicateSerializer stub = (call, fieldStorage) -> new byte[0];
    }
import java.util.List;
        DelegationBlockList.create(clusterSettings, Settings.EMPTY, registry());
                    public Set<EngineCapability> supportedEngineCapabilities() {
    }
            )  
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {  
    public void testDefaultsSeededWhenSettingsEmpty() {
                        return Set.of(DelegationType.FILTER);
        CapabilityRegistry reg = new CapabilityRegistry(List.of(luceneWithDefaults), FieldStorageResolver::new);  
        AnalyticsSearchBackendPlugin luceneWithDefaults = new AnalyticsSearchBackendPlugin() {
 *
                return Map.of(ScalarFunction.EQUALS, stub, ScalarFunction.LIKE, stub);
        assertFalse(blockList.isBlocked(LUCENE, ScalarFunction.EQUALS));  
        assertTrue(blockList.isBlocked(LUCENE, ScalarFunction.IS_NULL));  
                        return Set.of();  
                };
                // Only EQUALS and LIKE are delegatable (have serializers) in this fixture.  
                    Map.entry(ScalarFunction.LIKE, stub),  
import org.opensearch.analytics.planner.FieldStorageResolver;
        assertFalse(blockList.isBlocked(LUCENE, ScalarFunction.LIKE));
        DelegatedPredicateSerializer stub = (call, fieldStorage) -> new byte[0];
                    }
        IllegalArgumentException e = expectThrows(  
        expectThrows(IllegalArgumentException.class, () -> DelegationBlockList.create(clusterSettings(settings), settings, registry()));
        };
    private static final String LUCENE = "lucene";
                    public Set<DelegationType> acceptedDelegations() {
                    Map.entry(ScalarFunction.IS_NOT_NULL, stub),
package org.opensearch.analytics.settings;
public class DelegationBlockListTests extends OpenSearchTestCase {
            IllegalArgumentException.class,  
            }  
        // Explicit update overrides the seeded default.
        assertTrue(blockList.isBlocked(LUCENE, ScalarFunction.EQUALS));
            public String name() {  
import org.opensearch.test.OpenSearchTestCase;  
        DelegationBlockList.create(clusterSettings, Settings.EMPTY, registry());
            }  
            @Override
        return new CapabilityRegistry(List.of(lucene), fieldStorageFactory);  
            () -> clusterSettings.applySettings(
            }
        assertTrue(blockList.isBlocked(LUCENE, ScalarFunction.NOT_EQUALS));
            @Override
                    Map.entry(ScalarFunction.GREATER_THAN, stub),
            () -> clusterSettings.applySettings(
        assertTrue(blockList.isBlocked(LUCENE, ScalarFunction.GREATER_THAN_OR_EQUAL));
            @Override
            )  
    private ClusterSettings clusterSettings(Settings settings) {  
                return new BackendCapabilityProvider() {  
    private CapabilityRegistry registry() {  
            () -> clusterSettings.applySettings(
                    public Set<EngineCapability> supportedEngineCapabilities() {  
    public void testNonAcceptorBackendNamespaceRejected() {
                        return Set.of(DelegationType.FILTER);  
    }
import org.opensearch.analytics.planner.CapabilityRegistry;
                return LUCENE;
import java.util.Map;  
 * SPDX-License-Identifier: Apache-2.0
    public void testSeedFromClusterSettings() {
                Settings.builder().putList("analytics.delegation.datafusion.blocked_predicates", "LIKE").build()
        clusterSettings.applySettings(Settings.builder().putList("analytics.delegation.lucene.blocked_predicates", "EQUALS").build());  
            }  
}  
import org.opensearch.cluster.metadata.IndexMetadata;  
        );
            }
    }  
 * this file be licensed under the Apache-2.0 license or a
        assertFalse("defaults should be seeded", blockList.isEmpty());
import java.util.function.Function;
                return Map.ofEntries(
                    }
        ClusterSettings clusterSettings = clusterSettings(Settings.EMPTY);
        Function<IndexMetadata, FieldStorageResolver> fieldStorageFactory = FieldStorageResolver::new;
        IllegalArgumentException e = expectThrows(
        assertTrue("case-insensitive token parsed", blockList.isBlocked(LUCENE, ScalarFunction.EQUALS));
        // A token that isn't a ScalarFunction fails the list element parser at update time.
        // REGEXP has no serializer in this fixture → rejected even for the valid lucene namespace.  
                    Map.entry(ScalarFunction.IS_NULL, stub),
import org.opensearch.analytics.spi.BackendCapabilityProvider;
                Settings.builder().putList("analytics.delegation.lucene.blocked_predicates", "REGEXP").build()  
                    Map.entry(ScalarFunction.GREATER_THAN_OR_EQUAL, stub),
    }
        assertTrue("cause: " + e, causeChainContains(e, "not delegatable"));  
import org.opensearch.common.settings.Settings;
            if (c.getMessage() != null && c.getMessage().contains(fragment)) {  
    public void testUnknownPredicateNameRejectedByElementParser() {
            }
                return true;
        assertTrue(blockList.isEmpty());  
        };
            )
                return LUCENE;
                    Map.entry(ScalarFunction.LESS_THAN_OR_EQUAL, stub),
import org.opensearch.analytics.spi.EngineCapability;
                );  
        assertFalse(blockList.isBlocked(LUCENE, ScalarFunction.LIKE));  
                    @Override
import org.opensearch.analytics.spi.ScalarFunction;
        // Clearing the list removes all blocks.
 */  
        ClusterSettings clusterSettings = clusterSettings(Settings.EMPTY);  
                    @Override
import org.opensearch.common.settings.ClusterSettings;
        assertTrue("cause: " + e, causeChainContains(e, "not a delegation-target backend"));
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;  
        // datafusion is not a FILTER-delegation acceptor → the namespace is rejected at update time.
        Settings settings = Settings.builder().putList("analytics.delegation.lucene.blocked_predicates", "LIKE", "equals").build();
    public void testDynamicUpdate() {
        assertTrue(blockList.isBlocked(LUCENE, ScalarFunction.LESS_THAN));  
        // Defaults seed LIKE (the only default that has a serializer in this fixture).
import java.util.Set;
 * compatible open source license.
    }
            IllegalArgumentException.class,  
                    }
                    Map.entry(ScalarFunction.LESS_THAN, stub),  
        return false;
        );
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
    public void testNonDelegatablePredicateRejected() {
        DelegationBlockList.create(clusterSettings, Settings.EMPTY, registry());
                    @Override
                Settings.builder().putList("analytics.delegation.lucene.blocked_predicates", "NONSENSE").build()
            @Override
                    Map.entry(ScalarFunction.NOT_EQUALS, stub),  
        assertTrue(blockList.isBlocked(LUCENE, ScalarFunction.LIKE));  
            public BackendCapabilityProvider getCapabilityProvider() {  
                    }  
    }  
        Settings settings = Settings.builder().putList("analytics.delegation.datafusion.blocked_predicates", "LIKE").build();
                return new BackendCapabilityProvider() {
        assertFalse(blockList.isBlocked(LUCENE, ScalarFunction.LIKE));
            @Override  
        assertTrue(blockList.isBlocked(LUCENE, ScalarFunction.SARG_PREDICATE));
    /** The cluster-settings layer wraps the validator's IllegalArgumentException; search the chain. */  
    }
        assertTrue(blockList.isBlocked(LUCENE, ScalarFunction.GREATER_THAN));
    public void testEmptyBlocksNothing() {
        clusterSettings.applySettings(Settings.builder().putList("analytics.delegation.lucene.blocked_predicates").build());
            @Override
        DelegationBlockList blockList = DelegationBlockList.empty();
        assertTrue(blockList.isBlocked(LUCENE, ScalarFunction.IS_NOT_NULL));
        DelegationBlockList blockList = DelegationBlockList.create(clusterSettings, Settings.EMPTY, registry());
            public String name() {
        ClusterSettings clusterSettings = clusterSettings(Settings.EMPTY);  
        expectThrows(
        return new ClusterSettings(settings, Set.of(AnalyticsQuerySettings.DELEGATION_BLOCKED_PREDICATES));
import org.opensearch.analytics.spi.DelegationType;  
                    @Override  
    }  
            IllegalArgumentException.class,
            }
        AnalyticsSearchBackendPlugin lucene = new AnalyticsSearchBackendPlugin() {
        DelegationBlockList blockList = DelegationBlockList.create(clusterSettings(Settings.EMPTY), Settings.EMPTY, reg);
        );
        ClusterSettings clusterSettings = clusterSettings(Settings.EMPTY);  
    }
    }
        assertTrue(blockList.isBlocked(LUCENE, ScalarFunction.LESS_THAN_OR_EQUAL));
                    Map.entry(ScalarFunction.EQUALS, stub),
        assertTrue(blockList.isEmpty());
        // Fixture with IS_NULL, IS_NOT_NULL, LIKE serializers — mirrors the real Lucene backend.  
import org.opensearch.analytics.spi.DelegatedPredicateSerializer;
        assertTrue(blockList.isBlocked(LUCENE, ScalarFunction.LIKE));  
/*  
                };
    /** Lucene-like backend: accepts FILTER delegation and ships serializers for EQUALS + LIKE. */  
            public BackendCapabilityProvider getCapabilityProvider() {
    public void testSeedRejectsInvalidNamespaceAtConstruction() {  
                    Map.entry(ScalarFunction.SARG_PREDICATE, stub)
        assertTrue(blockList.isBlocked(LUCENE, ScalarFunction.LIKE));
        }  
        DelegationBlockList blockList = DelegationBlockList.create(clusterSettings(settings), settings, registry());  
 * The OpenSearch Contributors require contributions made to  
        for (Throwable c = t; c != null; c = c.getCause()) {
                    public Set<DelegationType> acceptedDelegations() {
