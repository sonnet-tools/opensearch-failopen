import org.opensearch.analytics.spi.FinalAggregateInstructionNode;
                int delegatedPredicateCount,
        return Set.of();
            @Override
        };
            }
    }
            @Override
/*
import java.util.Set;
    public FragmentInstructionHandlerFactory getInstructionHandlerFactory() {
    protected Set<DelegationType> acceptedDelegations() {
    // Overridable capability methods — defaults return empty (no capability declared)
                    new ShardScanWithDelegationInstructionNode(treeShape, delegatedPredicateCount, requestsRowIds, logicalTableName)
        return Set.of();
 * Base class for mock backends in planner tests.
            }
            public FragmentInstructionHandler<?> createHandler(InstructionNode node) {
import org.opensearch.analytics.spi.ScalarFunction;
    @Override
import org.opensearch.analytics.spi.DelegatedPredicateSerializer;
                return Optional.of(new FinalAggregateInstructionNode());
import org.opensearch.analytics.spi.InstructionNode;
                return self.filterCapabilities();
            }
    protected Set<DataTransferCapability> dataTransferCapabilities() {
            ) {
 * so anonymous subclasses only need to override what changes.
package org.opensearch.analytics.planner;
import org.opensearch.analytics.spi.FragmentInstructionHandler;
            @Override
            public Set<ProjectCapability> projectCapabilities() {
import org.opensearch.analytics.spi.JoinCapability;
                return self.supportedEngineCapabilities();
/**
            }
                return self.acceptedDelegations();
import org.opensearch.analytics.spi.WindowFunctionAdapter;
            }
    protected Set<WindowCapability> windowCapabilities() {
import org.opensearch.analytics.spi.FragmentInstructionHandlerFactory;
        return new FragmentInstructionHandlerFactory() {
 */
import org.opensearch.analytics.spi.EngineCapability;
import org.opensearch.analytics.spi.DelegationType;
        return Set.of();
            }
import org.opensearch.analytics.spi.ShardScanInstructionNode;
            public Optional<InstructionNode> createFilterDelegationNode(
 * {@link #getCapabilityProvider()} delegates to these overridable methods,
        return Set.of();
            @Override
import java.util.List;
            @Override
            public Set<AggregateCapability> aggregateCapabilities() {
import org.opensearch.analytics.spi.WindowCapability;
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
import org.opensearch.analytics.spi.AggregateCapability;
 */
                boolean requestsRowIds,
                return self.scanCapabilities();
            }
    }
 *
                return Optional.of(
    protected Map<ScalarFunction, ScalarFunctionAdapter> scalarFunctionAdapters() {
    public final BackendCapabilityProvider getCapabilityProvider() {
                );
 * SPDX-License-Identifier: Apache-2.0
    }
 * <p>Subclasses override only the capability methods relevant to their test.
            public Set<DataTransferCapability> dataTransferCapabilities() {
                return self.projectCapabilities();
            public Set<FilterCapability> filterCapabilities() {
            public Map<WindowFunction, WindowFunctionAdapter> windowFunctionAdapters() {
            public Set<DelegationType> acceptedDelegations() {
            }
            }
                FilterTreeShape treeShape,
            }
    protected Set<EngineCapability> supportedEngineCapabilities() {
    protected Set<JoinCapability> joinCapabilities() {
        return new BackendCapabilityProvider() {
import org.opensearch.analytics.spi.BackendCapabilityProvider;
            }
                int delegatedPredicateCount,
            @Override
    public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
            @Override
    }
        return Set.of();
            @Override
import org.opensearch.analytics.spi.DelegatedExpression;
 * this file be licensed under the Apache-2.0 license or a
            }
                return Optional.of(new PartialAggregateInstructionNode());
        };
    @Override
        return Set.of();
        return Set.of();
                return self.aggregateCapabilities();
 * The OpenSearch Contributors require contributions made to
    @Override
        return Set.of();
import org.opensearch.analytics.spi.ProjectCapability;
            @Override
        return Map.of();
            }
import org.opensearch.analytics.spi.ScanCapability;
                return self.windowFunctionAdapters();
}
            }
            public Set<EngineCapability> supportedEngineCapabilities() {
            }
            public Optional<InstructionNode> createPartialAggregateNode() {
            }
 *
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
    protected Set<ProjectCapability> projectCapabilities() {
            @Override
    }
            @Override
            @Override
import org.opensearch.analytics.spi.DataTransferCapability;
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
                throw new UnsupportedOperationException("Mock backend does not execute instructions");
                return self.dataTransferCapabilities();
    protected Map<WindowFunction, WindowFunctionAdapter> windowFunctionAdapters() {
            public Set<ScanCapability> scanCapabilities() {
                return self.supportedDelegations();
    }
        return Map.of();
                return self.windowCapabilities();
    }
                return self.scalarFunctionAdapters();
    }
            @Override
            public Set<DelegationType> supportedDelegations() {
import org.opensearch.analytics.spi.ShardScanWithDelegationInstructionNode;
    protected Set<FilterCapability> filterCapabilities() {
                return Optional.of(new ShardScanInstructionNode(requestsRowIds, logicalTableName));
 * compatible open source license.
            @Override
    protected Set<AggregateCapability> aggregateCapabilities() {
        return Set.of();
            @Override
    protected Set<DelegationType> supportedDelegations() {
abstract class MockBackend implements AnalyticsSearchBackendPlugin {
            @Override
            public Optional<InstructionNode> createShardScanNode(boolean requestsRowIds, String logicalTableName) {
            }
            public Map<ScalarFunction, ScalarFunctionAdapter> scalarFunctionAdapters() {
    protected Set<ScanCapability> scanCapabilities() {
                List<DelegatedExpression> delegatedExpressions
            public Set<WindowCapability> windowCapabilities() {
        return Map.of();
            ) {
import org.opensearch.analytics.spi.FilterTreeShape;
            @Override
    }
import org.opensearch.analytics.spi.FilterDelegationInstructionNode;
                return self.joinCapabilities();
            }
                return Optional.of(new FilterDelegationInstructionNode(treeShape, delegatedPredicateCount, delegatedExpressions));
            @Override
    }
            public Optional<InstructionNode> createFinalAggregateNode() {
                FilterTreeShape treeShape,
    }
import org.opensearch.analytics.spi.FilterCapability;
    }
            public Set<JoinCapability> joinCapabilities() {
        MockBackend self = this;
        return Set.of();
import java.util.Map;
            }
import org.opensearch.analytics.spi.WindowFunction;
import org.opensearch.analytics.spi.PartialAggregateInstructionNode;
import java.util.Optional;
                String logicalTableName
    }
    }
            public Optional<InstructionNode> createShardScanWithDelegationNode(
                return self.delegatedPredicateSerializers();
            @Override
    }
