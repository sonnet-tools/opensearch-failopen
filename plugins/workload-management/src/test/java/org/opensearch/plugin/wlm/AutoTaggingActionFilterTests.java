import org.opensearch.rule.RuleAttribute;
        CancelTasksRequest request = new CancelTasksRequest();
        );
        SearchRequest request = mock(SearchRequest.class);
    public void testApplyTwiceOnOneThreadContextIsTolerated() {
                new AttributeValueStoreFactory(featureTypeWithPrincipal, DefaultAttributeValueStore::new),
                    "NodeDefaultQG_ID",
        when(request.indices()).thenReturn(new String[] { "foo" });
                return LogicalOperator.OR;
            return name;
            }
        InMemoryRuleProcessingService svc = spy(
import static org.mockito.Mockito.when;
                null
            ruleProcessingService,
        try {
import org.opensearch.plugin.wlm.spi.AttributeExtractorExtension;
            new InMemoryRuleProcessingService(
    public void testApplyDoesNotOverwriteExistingHeader() {
import java.util.ArrayList;
            @Override
import java.util.List;
        WorkloadGroupTask second = newWorkloadGroupTask();
            autoTaggingActionFilter.apply(mock(Task.class), "Test", request, ActionRequestMetadata.empty(), null, mockFilterChain);
        verify(ruleProcessingService, times(0)).evaluateLabel(anyList());
        ActionFilterChain<ActionRequest, ActionResponse> chain = mock(TestActionFilterChain.class);
    }
            autoTaggingActionFilter.apply(mock(Task.class), "Test", request, metadata, null, chain);
                );
        }
            }
            defaultHeaderPool.shutdownNow();
                assertEquals(
import org.opensearch.rule.InMemoryRuleProcessingService;
    ThreadPool threadPool;
                mock(WlmClusterSettingValuesProvider.class),
            assertEquals("username|alice", first.getThrottlePrincipal());
                return "wlm";
                defaultHeaderPool,
    }
    }
            assertNull(threadPool.getThreadContext().getHeader("workloadGroupPrincipal"));
        // No principal extractor, so the principal stays null and username/role throttling fails open.
            )
                return PRINCIPAL_ATTRIBUTE_NAME;
    public void testApplySetsThrottlePrincipalOnTaskWhenExtractorPresent() {
        }
        }
import org.opensearch.threadpool.ThreadPool;
        INVALID_ATTRIBUTE("invalid_attribute");
            public String getName() {
            featureTypeWithPrincipal
        WorkloadGroupTask task = newWorkloadGroupTask();
            new InMemoryRuleProcessingService(
            assertNull(task.getThrottlePrincipal());
            threadPool,
                task.getThrottlePrincipal()
            @Override
        autoTaggingActionFilter = new AutoTaggingActionFilter(
        );
    }
            assertEquals("TestQG_ID", threadPool.getThreadContext().getHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER));
import org.opensearch.rule.autotagging.FeatureType;
                return LogicalOperator.OR;
        }
            when(ruleProcessingService.evaluateLabel(anyList())).thenReturn(Optional.of("NestedQG_ID"));
        try (ThreadContext.StoredContext ctx = threadPool.getThreadContext().stashContext()) {
        AttributeExtractor<String> principalExtractor = new AttributeExtractor<>() {
    public void testApplyLeavesThrottlePrincipalUnsetWhenNoExtractor() {
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.mock;
        ThreadPool defaultHeaderPool = new TestThreadPool("AutoTaggingActionFilterDefaultHeaderTests", settings);
            assertEquals("extract() must be invoked once per request", 2, extractCalls.get());
        }
        } finally {
                return principalAttr;
    }
        }
            }
            public void writeTo(StreamOutput out) throws IOException {}
    public void testApplyForInValidRequest() {
import org.opensearch.core.tasks.TaskId;
            AutoTaggingActionFilter filter = new AutoTaggingActionFilter(
            @Override
    }
            // Both tokens are joined onto the task.
            @Override
        try (ThreadContext.StoredContext context = threadPool.getThreadContext().stashContext()) {
        AutoTaggingActionFilter filter = new AutoTaggingActionFilter(
            )
            when(svc.evaluateLabel(anyList())).thenReturn(Optional.empty());
                return List.of("username|alice", "role|admin");
            @Override
    }
        Attribute principalAttr = new Attribute() {
import org.opensearch.core.action.ActionListener;
    }
            .put("request.headers." + WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "NodeDefaultQG_ID")
        public void writeTo(StreamOutput out) throws IOException {}
            public String getName() {
        }
import org.opensearch.rule.attribute_extractor.AttributeExtractor;
        }
    }
            @Override
        ActionFilterChain<ActionRequest, ActionResponse> chain = mock(TestActionFilterChain.class);
            assertEquals("OuterQG_ID", threadPool.getThreadContext().getHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER));
 * The OpenSearch Contributors require contributions made to
import static org.mockito.Mockito.anyList;
import org.opensearch.wlm.WorkloadGroupTask;
                "username|alice" + WorkloadGroupTask.WORKLOAD_GROUP_PRINCIPAL_VALUE_DELIMITER + "role|admin",
        SearchRequest request = mock(SearchRequest.class);
        super.setUp();
            public void validateAttribute() {}
        @Override
            public void validateAttribute() {}
            @Override
            }
        when(request.originalIndicesOrEmpty()).thenReturn(new String[] { "logs-scroll-index" });
            @Override
            @Override
                    defaultHeaderPool.getThreadContext().getHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER)
            assertEquals("username|alice", second.getThrottlePrincipal());
        when(request.indices()).thenReturn(new String[] { "foo" });
                return "wlm";
import org.opensearch.common.settings.Settings;
        ruleProcessingService = spy(new InMemoryRuleProcessingService(attributeValueStoreFactory, null));
 */
        }
        };
        @Override
            public void writeTo(StreamOutput out) throws IOException {}
        return new WorkloadGroupTask(1L, "transport", "Test", "test task", TaskId.EMPTY_TASK_ID, Map.of());
                AttributeExtractor<String> ex = extractors.get(0);
import static org.mockito.Mockito.doAnswer;
        when(request.indices()).thenReturn(new String[] { "lookupidx" });
            }
}
        TEST_ATTRIBUTE("test_attribute"),
            public Attribute getAttribute() {
        FeatureType featureTypeWithPrincipal = new FeatureType() {
        InMemoryRuleProcessingService svc = spy(
        );
    public void testApplyOverridesNodeDefaultWorkloadGroup() {
            when(request.indices()).thenReturn(new String[] { "foo" });
                new AttributeValueStoreFactory(featureTypeWithPrincipal, DefaultAttributeValueStore::new),
import org.opensearch.action.search.SearchScrollRequest;
            SearchRequest request = mock(SearchRequest.class);
        };
        // putHeader throws on a repeat, so the principal must live on the task.
        }
            try (ThreadContext.StoredContext context = defaultHeaderPool.getThreadContext().stashContext()) {
            verify(ruleProcessingService, times(1)).evaluateLabel(anyList());
            svc,
            DefaultAttributeValueStore::new
        AttributeExtractorExtension extension = () -> principalExtractor;
public class AutoTaggingActionFilterTests extends OpenSearchTestCase {
        ActionFilterChain<ActionRequest, ActionResponse> chain = mock(TestActionFilterChain.class);
import static org.opensearch.plugin.wlm.WorkloadManagementPlugin.PRINCIPAL_ATTRIBUTE_NAME;
    public void testOrder() {
    private static WorkloadGroupTask newWorkloadGroupTask() {
import org.opensearch.common.util.concurrent.ThreadContext;
                assertNotNull(extractors);
            featureTypeWithPrincipal
        threadPool = new TestThreadPool("AutoTaggingActionFilterTests");
    }
        ActionFilterChain<ActionRequest, ActionResponse> mockFilterChain = mock(TestActionFilterChain.class);
            autoTaggingActionFilter.apply(task, "Test", request, ActionRequestMetadata.empty(), null, chain);
            // extract() may be single-use, so it must be called once per request.
        AtomicInteger extractCalls = new AtomicInteger();
                ex.extract().forEach(values::add);
                null
            @Override
        private final String name;
import org.opensearch.rule.autotagging.Attribute;
            @Override
        Settings settings = Settings.builder()
            mock(WlmClusterSettingValuesProvider.class),
            public String getName() {
        try (ThreadContext.StoredContext ctx = threadPool.getThreadContext().stashContext()) {
            Map.of(principalAttr, extension),
        SearchRequest request = mock(SearchRequest.class);
            );
import org.opensearch.core.common.io.stream.StreamOutput;
import java.io.IOException;
    public void testApplyForScrollRequestWithOriginalIndices() {
                WLMFeatureType.WLM
package org.opensearch.plugin.wlm;
                List<String> values = new ArrayList<>();
        SearchRequest request = mock(SearchRequest.class);
        autoTaggingActionFilter.apply(mock(Task.class), "Test", request, ActionRequestMetadata.empty(), null, mockFilterChain);
        try (ThreadContext.StoredContext context = threadPool.getThreadContext().stashContext()) {
        ActionRequestMetadata<ActionRequest, ActionResponse> metadata = mock(ActionRequestMetadata.class);
            WorkloadGroupTask task = newWorkloadGroupTask();
        public void validateAttribute() {}
        };
                List<AttributeExtractor<String>> extractors = inv.getArgument(0);
            new HashMap<>(),
        AttributeExtractorExtension extension = () -> principalExtractor;
            assertNull(threadPool.getThreadContext().getHeader("workloadGroupPrincipal"));
            filter.apply(second, "Test", request, ActionRequestMetadata.empty(), null, chain);
        @Override
                return principalAttr;
    public void setUp() throws Exception {
            assertEquals(
            public LogicalOperator getLogicalOperator() {
        // A feature type that includes a "principal" attribute + a matching extractor extension in the map.
            public Map<Attribute, Integer> getOrderedAttributes() {
        }
import org.opensearch.action.support.ActionRequestMetadata;
            @Override
    }
            verify(ruleProcessingService, times(1)).evaluateLabel(anyList());
            }
            threadPool,
        when(request.indices()).thenReturn(new String[] { "foo" });
        FeatureType featureTypeWithPrincipal = new FeatureType() {
        threadPool.shutdownNow();
        Map<Attribute, AttributeExtractorExtension> extensions = Map.of(principalAttr, extension);
        };
            when(ruleProcessingService.evaluateLabel(anyList())).thenReturn(Optional.of("QG"));
            this.name = name;
            doAnswer(inv -> {
 * SPDX-License-Identifier: Apache-2.0
            public Iterable<String> extract() {
            @Override
            }
            when(ruleProcessingService.evaluateLabel(anyList())).thenReturn(Optional.of("TestQG_ID"));
            return Map.of(TestAttribute.TEST_ATTRIBUTE, 1);
    }
        // The filter can run twice on one ThreadContext (an _msearch draining its queue from a response handler), and
        };
            svc,
    AutoTaggingActionFilter autoTaggingActionFilter;
        AttributeValueStoreFactory attributeValueStoreFactory = new AttributeValueStoreFactory(
        public String getName() {
                ruleProcessingService,
        ActionFilterChain<ActionRequest, ActionResponse> mockFilterChain = mock(TestActionFilterChain.class);
            threadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "OuterQG_ID");
            }
                assertEquals(RuleAttribute.INDEX_PATTERN, ex.getAttribute());
        WorkloadGroupTask first = newWorkloadGroupTask();
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.tasks.Task;
            threadPool,
            .build();
        };
import org.opensearch.action.ActionRequest;
            assertEquals("ScrollQG_ID", threadPool.getThreadContext().getHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER));
        when(request.indices()).thenReturn(new String[] { "foo" });
            return "";
    private static class TestActionFilterChain implements ActionFilterChain<ActionRequest, ActionResponse> {
                assertEquals(List.of("logs-scroll-index"), values);
                return Optional.of("ScrollQG_ID");
            filter.apply(task, "Test", request, ActionRequestMetadata.empty(), null, chain);
    public enum WLMFeatureType implements FeatureType {
            filter.apply(first, "Test", request, ActionRequestMetadata.empty(), null, chain);
        );
            }
                return List.of("username|alice");
            // No label, so only the principal is under test.
            @Override
            ActionFilterChain<ActionRequest, ActionResponse> mockFilterChain = mock(TestActionFilterChain.class);
import static org.mockito.ArgumentMatchers.any;
import org.opensearch.action.search.SearchRequest;
    InMemoryRuleProcessingService ruleProcessingService;
                assertEquals("TestQG_ID", defaultHeaderPool.getThreadContext().getHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER));
            // Not in the thread context, which is serialized to every shard and remote cluster.
        public String getName() {
        Attribute principalAttr = new Attribute() {
            public Attribute getAttribute() {
        );
        SearchRequest request = mock(SearchRequest.class);
        AutoTaggingActionFilter filter = new AutoTaggingActionFilter(
        AttributeExtractor<String> principalExtractor = new AttributeExtractor<>() {
                assertEquals(1, extractors.size());
                @SuppressWarnings("unchecked")
            extensions,
        ActionFilterChain<ActionRequest, ActionResponse> mockFilterChain = mock(TestActionFilterChain.class);
            }).when(ruleProcessingService).evaluateLabel(any());
 * compatible open source license.
            }
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest;
    public enum TestAttribute implements Attribute {
        }
            public Iterable<String> extract() {
        @Override
 *
                filter.apply(mock(Task.class), "Test", request, ActionRequestMetadata.empty(), null, mockFilterChain);
        try (ThreadContext.StoredContext ctx = threadPool.getThreadContext().stashContext()) {
import org.opensearch.test.OpenSearchTestCase;
    }
        TestAttribute(String name) {
                return Map.of(principalAttr, 1);
        @Override
            autoTaggingActionFilter.apply(mock(Task.class), "Test", request, ActionRequestMetadata.empty(), null, mockFilterChain);
            );
import static org.mockito.Mockito.verify;
/*
                return Map.of(principalAttr, 1);
        public Map<Attribute, Integer> getOrderedAttributes() {
        try (ThreadContext.StoredContext ctx = threadPool.getThreadContext().stashContext()) {
import java.util.Optional;
            WLMFeatureType.WLM,
    public void testApplyForValidRequest() {
        );
        assertEquals(Integer.MAX_VALUE, autoTaggingActionFilter.order());
                new HashMap<>(),
        super.tearDown();
            // Must not throw "value for key [workloadGroupId] already present"
    public void tearDown() throws Exception {
import org.opensearch.rule.storage.DefaultAttributeValueStore;
            @Override
        ActionFilterChain<ActionRequest, ActionResponse> chain = mock(TestActionFilterChain.class);
                extractCalls.incrementAndGet();
        SearchScrollRequest request = mock(SearchScrollRequest.class);
import java.util.concurrent.atomic.AtomicInteger;
import org.opensearch.rule.storage.AttributeValueStoreFactory;
        @Override
        WLM;
    }
        @SuppressWarnings("unchecked")
            }
import java.util.HashMap;
            public Map<Attribute, Integer> getOrderedAttributes() {
            // Each sub-request carries its own principal, and neither run threw on a duplicate key.
            public String getName() {
            public LogicalOperator getLogicalOperator() {
            mock(WlmClusterSettingValuesProvider.class),
import org.opensearch.action.support.ActionFilterChain;
            }
            }
            @Override
import static org.mockito.Mockito.spy;
        public void proceed(Task task, String action, ActionRequest request, ActionListener<ActionResponse> listener) {
            WLMFeatureType.WLM
                return PRINCIPAL_ATTRIBUTE_NAME;
import org.opensearch.threadpool.TestThreadPool;
            mock(WlmClusterSettingValuesProvider.class),
    }
                when(ruleProcessingService.evaluateLabel(anyList())).thenReturn(Optional.of("TestQG_ID"));
import java.util.Map;
            when(svc.evaluateLabel(anyList())).thenReturn(Optional.of("QG"));
import org.opensearch.core.action.ActionResponse;
