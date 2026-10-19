            public Map<WindowFunction, WindowFunctionAdapter> windowFunctionAdapters() {  
            }
 * Base class for mock backends in planner tests.
abstract class MockBackend implements AnalyticsSearchBackendPlugin {
        return new FragmentInstructionHandlerFactory() {
            }
            public Optional<InstructionNode> createFilterDelegationNode(
                return self.supportedDelegations();
            public Set<EngineCapability> supportedEngineCapabilities() {
import org.opensearch.analytics.spi.EngineCapability;
import org.opensearch.analytics.spi.DelegationType;
            @Override
                return self.scalarFunctionAdapters();
            @Override
    protected Set<WindowCapability> windowCapabilities() {  
                return Optional.of(
            @Override  
import org.opensearch.analytics.spi.ShardScanInstructionNode;
        return Set.of();
import org.opensearch.analytics.spi.FragmentInstructionHandlerFactory;
            }
    }  
            public Set<AggregateCapability> aggregateCapabilities() {
    }
    @Override  
    // Overridable capability methods — defaults return empty (no capability declared)
            }  
    }  
        };  
            @Override
            }
    protected Set<EngineCapability> supportedEngineCapabilities() {  
                return self.projectCapabilities();
        return Set.of();  
    protected Map<ScalarFunction, ScalarFunctionAdapter> scalarFunctionAdapters() {
            }
        return Map.of();
    }  
import java.util.List;
    }  
                FilterTreeShape treeShape,  
 */  
            public Set<ScanCapability> scanCapabilities() {
                return self.dataTransferCapabilities();
            @Override
import org.opensearch.analytics.spi.DelegatedExpression;
import org.opensearch.analytics.spi.JoinCapability;
        MockBackend self = this;
        return Set.of();  
                return self.supportedEngineCapabilities();  
                boolean requestsRowIds,
    protected Set<DelegationType> acceptedDelegations() {  
                return Optional.of(new FinalAggregateInstructionNode());
    }
                return self.windowCapabilities();  
            @Override
    }
    }
            }
    public FragmentInstructionHandlerFactory getInstructionHandlerFactory() {  
 *
 * {@link #getCapabilityProvider()} delegates to these overridable methods,
            }
        return Set.of();
    @Override
            public Map<ScalarFunction, ScalarFunctionAdapter> scalarFunctionAdapters() {
import org.opensearch.analytics.spi.ScalarFunction;
            ) {
            }  
                return self.aggregateCapabilities();  
            }
            public Optional<InstructionNode> createPartialAggregateNode() {
            }
            public Optional<InstructionNode> createShardScanNode(boolean requestsRowIds, String logicalTableName) {  
                return Optional.of(new ShardScanInstructionNode(requestsRowIds, logicalTableName));
            @Override
        return Map.of();  
            @Override  
            public Optional<InstructionNode> createShardScanWithDelegationNode(
        return Set.of();
            }
import java.util.Map;
}
 * <p>Subclasses override only the capability methods relevant to their test.  
            @Override
        return Map.of();
    }
                return Optional.of(new PartialAggregateInstructionNode());  
            @Override  
import org.opensearch.analytics.spi.WindowFunctionAdapter;
    }
                return self.windowFunctionAdapters();
            public Set<DataTransferCapability> dataTransferCapabilities() {
    protected Set<DataTransferCapability> dataTransferCapabilities() {
    protected Set<DelegationType> supportedDelegations() {
package org.opensearch.analytics.planner;
            public Set<WindowCapability> windowCapabilities() {
                List<DelegatedExpression> delegatedExpressions
import org.opensearch.analytics.spi.PartialAggregateInstructionNode;
import org.opensearch.analytics.spi.FilterTreeShape;
            public Optional<InstructionNode> createFinalAggregateNode() {
            @Override
import org.opensearch.analytics.spi.FragmentInstructionHandler;
            public Set<DelegationType> acceptedDelegations() {
import org.opensearch.analytics.spi.ProjectCapability;  
import java.util.Set;
import org.opensearch.analytics.spi.AggregateCapability;
import org.opensearch.analytics.spi.ShardScanWithDelegationInstructionNode;
    }
 * so anonymous subclasses only need to override what changes.
import org.opensearch.analytics.spi.FinalAggregateInstructionNode;  
            @Override
        return Set.of();
                return self.scanCapabilities();
                throw new UnsupportedOperationException("Mock backend does not execute instructions");
                String logicalTableName  
            @Override
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
import org.opensearch.analytics.spi.WindowCapability;  
            public Set<DelegationType> supportedDelegations() {  
import org.opensearch.analytics.spi.ScanCapability;  
            @Override
    }
    }  
    protected Map<WindowFunction, WindowFunctionAdapter> windowFunctionAdapters() {
 * SPDX-License-Identifier: Apache-2.0
        return Set.of();
            public Set<ProjectCapability> projectCapabilities() {
        return Set.of();  
    @Override  
            public Set<JoinCapability> joinCapabilities() {  
import org.opensearch.analytics.spi.DelegatedPredicateSerializer;  
import org.opensearch.analytics.spi.FilterCapability;  
/*  
import org.opensearch.analytics.spi.InstructionNode;  
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
        };
                return self.delegatedPredicateSerializers();  
import org.opensearch.analytics.spi.DataTransferCapability;
            }  
            ) {  
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
import org.opensearch.analytics.spi.BackendCapabilityProvider;  
            }  
            }
    public final BackendCapabilityProvider getCapabilityProvider() {
            @Override  
            }  
            public FragmentInstructionHandler<?> createHandler(InstructionNode node) {  
        return Set.of();
                return self.filterCapabilities();
                int delegatedPredicateCount,
            }
        return new BackendCapabilityProvider() {  
    }
import org.opensearch.analytics.spi.WindowFunction;
            }
            @Override
                );
        return Set.of();
 */  
                return self.joinCapabilities();
                    new ShardScanWithDelegationInstructionNode(treeShape, delegatedPredicateCount, requestsRowIds, logicalTableName)  
/**  
 *
    public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
 * The OpenSearch Contributors require contributions made to  
    protected Set<ScanCapability> scanCapabilities() {
    protected Set<FilterCapability> filterCapabilities() {
            @Override
import org.opensearch.analytics.spi.FilterDelegationInstructionNode;
    protected Set<ProjectCapability> projectCapabilities() {
    }  
                return Optional.of(new FilterDelegationInstructionNode(treeShape, delegatedPredicateCount, delegatedExpressions));
    protected Set<AggregateCapability> aggregateCapabilities() {  
    protected Set<JoinCapability> joinCapabilities() {
            public Set<FilterCapability> filterCapabilities() {  
                return self.acceptedDelegations();  
            @Override
 * compatible open source license.
                FilterTreeShape treeShape,  
 * this file be licensed under the Apache-2.0 license or a
import java.util.Optional;  
            }
                int delegatedPredicateCount,
            @Override  
