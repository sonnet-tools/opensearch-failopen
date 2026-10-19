                return List.of("username|alice", "role|admin");
            assertEquals("OuterQG_ID", threadPool.getThreadContext().getHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER));
            @Override  
            }  
            WLMFeatureType.WLM,
 * compatible open source license.
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest;
        ActionFilterChain<ActionRequest, ActionResponse> chain = mock(TestActionFilterChain.class);  
            );  
                return Map.of(principalAttr, 1);
                List<String> values = new ArrayList<>();
            return "";  
        when(request.indices()).thenReturn(new String[] { "foo" });  
            ActionFilterChain<ActionRequest, ActionResponse> mockFilterChain = mock(TestActionFilterChain.class);
            when(svc.evaluateLabel(anyList())).thenReturn(Optional.empty());
import org.opensearch.rule.InMemoryRuleProcessingService;
        ActionFilterChain<ActionRequest, ActionResponse> mockFilterChain = mock(TestActionFilterChain.class);  
                ruleProcessingService,
        @SuppressWarnings("unchecked")
        }  
    }  
    }
            @Override
import org.opensearch.core.action.ActionListener;  
import static org.mockito.Mockito.anyList;
        };
            }
import org.opensearch.action.ActionRequest;
import org.opensearch.action.search.SearchScrollRequest;
            public Map<Attribute, Integer> getOrderedAttributes() {
            public String getName() {
import static org.mockito.Mockito.times;
import java.util.concurrent.atomic.AtomicInteger;  
            doAnswer(inv -> {
    public enum WLMFeatureType implements FeatureType {
        @Override  
            assertEquals("TestQG_ID", threadPool.getThreadContext().getHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER));
        }  
        SearchRequest request = mock(SearchRequest.class);
            SearchRequest request = mock(SearchRequest.class);
            @Override
            public Map<Attribute, Integer> getOrderedAttributes() {  
            assertNull(threadPool.getThreadContext().getHeader("workloadGroupPrincipal"));  
    public void testApplyTwiceOnOneThreadContextIsTolerated() {
                    "NodeDefaultQG_ID",  
        );
                new HashMap<>(),  
        autoTaggingActionFilter = new AutoTaggingActionFilter(
        WorkloadGroupTask task = newWorkloadGroupTask();
            extensions,  
import org.opensearch.action.support.ActionFilterChain;
            filter.apply(task, "Test", request, ActionRequestMetadata.empty(), null, chain);
            threadPool,
        threadPool.shutdownNow();
            }  
        SearchRequest request = mock(SearchRequest.class);  
        super.tearDown();  
                null  
            mock(WlmClusterSettingValuesProvider.class),  
import java.util.HashMap;
                return LogicalOperator.OR;  
import org.opensearch.tasks.Task;  
        TEST_ATTRIBUTE("test_attribute"),
            public void writeTo(StreamOutput out) throws IOException {}  
                return principalAttr;
package org.opensearch.plugin.wlm;
        try (ThreadContext.StoredContext context = threadPool.getThreadContext().stashContext()) {
            .put("request.headers." + WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "NodeDefaultQG_ID")
            public Attribute getAttribute() {
        };
        };  
            svc,
            // extract() may be single-use, so it must be called once per request.
import org.opensearch.rule.autotagging.FeatureType;  
            // Both tokens are joined onto the task.
    public void testApplyForScrollRequestWithOriginalIndices() {
import java.util.List;  
        private final String name;
            when(ruleProcessingService.evaluateLabel(anyList())).thenReturn(Optional.of("TestQG_ID"));
            @Override  
/*  
    public void testApplyOverridesNodeDefaultWorkloadGroup() {  
            threadPool,
    public void testApplyForInValidRequest() {
            // Each sub-request carries its own principal, and neither run threw on a duplicate key.  
            return Map.of(TestAttribute.TEST_ATTRIBUTE, 1);
        ActionFilterChain<ActionRequest, ActionResponse> chain = mock(TestActionFilterChain.class);
        ThreadPool defaultHeaderPool = new TestThreadPool("AutoTaggingActionFilterDefaultHeaderTests", settings);
        threadPool = new TestThreadPool("AutoTaggingActionFilterTests");
            @Override
import org.opensearch.threadpool.TestThreadPool;
        WorkloadGroupTask second = newWorkloadGroupTask();
import java.util.Optional;
    }
                List<AttributeExtractor<String>> extractors = inv.getArgument(0);  
            public Iterable<String> extract() {  
            assertNull(threadPool.getThreadContext().getHeader("workloadGroupPrincipal"));
                mock(WlmClusterSettingValuesProvider.class),
        ActionFilterChain<ActionRequest, ActionResponse> mockFilterChain = mock(TestActionFilterChain.class);
                WLMFeatureType.WLM
            svc,  
        AttributeExtractor<String> principalExtractor = new AttributeExtractor<>() {
                task.getThrottlePrincipal()
        SearchRequest request = mock(SearchRequest.class);
    public void tearDown() throws Exception {
        @Override
        }
            assertEquals("username|alice", second.getThrottlePrincipal());
            when(ruleProcessingService.evaluateLabel(anyList())).thenReturn(Optional.of("QG"));  
                    defaultHeaderPool.getThreadContext().getHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER)
        SearchRequest request = mock(SearchRequest.class);
            @Override  
            new HashMap<>(),
            @Override
            WLMFeatureType.WLM
            @Override  
            verify(ruleProcessingService, times(1)).evaluateLabel(anyList());  
        @Override  
        @Override  
            DefaultAttributeValueStore::new
        }
 *
                return "wlm";  
import org.opensearch.action.support.ActionRequestMetadata;  
            WorkloadGroupTask task = newWorkloadGroupTask();
    public void testApplyLeavesThrottlePrincipalUnsetWhenNoExtractor() {  
        try {
 * The OpenSearch Contributors require contributions made to  
        // putHeader throws on a repeat, so the principal must live on the task.
            }
            }
        }  
import org.opensearch.core.tasks.TaskId;  
        Map<Attribute, AttributeExtractorExtension> extensions = Map.of(principalAttr, extension);
    }
                return principalAttr;
            when(ruleProcessingService.evaluateLabel(anyList())).thenReturn(Optional.of("NestedQG_ID"));  
        }
import static org.mockito.ArgumentMatchers.any;  
import org.opensearch.plugin.wlm.spi.AttributeExtractorExtension;
        AttributeValueStoreFactory attributeValueStoreFactory = new AttributeValueStoreFactory(  
        @Override
            // Must not throw "value for key [workloadGroupId] already present"
    }
            // No label, so only the principal is under test.
    }
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;  
        };
                return Map.of(principalAttr, 1);
        super.setUp();
        );
            verify(ruleProcessingService, times(1)).evaluateLabel(anyList());
        when(request.indices()).thenReturn(new String[] { "lookupidx" });  
import org.opensearch.core.common.io.stream.StreamOutput;
    InMemoryRuleProcessingService ruleProcessingService;  
    public void setUp() throws Exception {  
            }
        ruleProcessingService = spy(new InMemoryRuleProcessingService(attributeValueStoreFactory, null));
    public void testApplySetsThrottlePrincipalOnTaskWhenExtractorPresent() {
        Attribute principalAttr = new Attribute() {
        AttributeExtractor<String> principalExtractor = new AttributeExtractor<>() {
        when(request.indices()).thenReturn(new String[] { "foo" });  
            );
import static org.opensearch.plugin.wlm.WorkloadManagementPlugin.PRINCIPAL_ATTRIBUTE_NAME;
            mock(WlmClusterSettingValuesProvider.class),
            }  
        CancelTasksRequest request = new CancelTasksRequest();
        public Map<Attribute, Integer> getOrderedAttributes() {
            public void writeTo(StreamOutput out) throws IOException {}
            }  
    }  
    }
        AutoTaggingActionFilter filter = new AutoTaggingActionFilter(
                return PRINCIPAL_ATTRIBUTE_NAME;
            // Not in the thread context, which is serialized to every shard and remote cluster.  
            autoTaggingActionFilter.apply(mock(Task.class), "Test", request, metadata, null, chain);  
        ActionFilterChain<ActionRequest, ActionResponse> chain = mock(TestActionFilterChain.class);
            filter.apply(first, "Test", request, ActionRequestMetadata.empty(), null, chain);  
        };
        );
        Settings settings = Settings.builder()
                AttributeExtractor<String> ex = extractors.get(0);
        verify(ruleProcessingService, times(0)).evaluateLabel(anyList());
            )
        // The filter can run twice on one ThreadContext (an _msearch draining its queue from a response handler), and  
            @Override
        FeatureType featureTypeWithPrincipal = new FeatureType() {
import org.opensearch.test.OpenSearchTestCase;
            assertNull(task.getThrottlePrincipal());  
        try (ThreadContext.StoredContext ctx = threadPool.getThreadContext().stashContext()) {
            autoTaggingActionFilter.apply(mock(Task.class), "Test", request, ActionRequestMetadata.empty(), null, mockFilterChain);
import org.opensearch.wlm.WorkloadGroupTask;
        when(request.indices()).thenReturn(new String[] { "foo" });
            public Attribute getAttribute() {
        INVALID_ATTRIBUTE("invalid_attribute");
        WorkloadGroupTask first = newWorkloadGroupTask();
            autoTaggingActionFilter.apply(mock(Task.class), "Test", request, ActionRequestMetadata.empty(), null, mockFilterChain);  
        InMemoryRuleProcessingService svc = spy(  
        try (ThreadContext.StoredContext ctx = threadPool.getThreadContext().stashContext()) {  
                new AttributeValueStoreFactory(featureTypeWithPrincipal, DefaultAttributeValueStore::new),
    private static class TestActionFilterChain implements ActionFilterChain<ActionRequest, ActionResponse> {
    AutoTaggingActionFilter autoTaggingActionFilter;
            featureTypeWithPrincipal
    }
 * this file be licensed under the Apache-2.0 license or a
                defaultHeaderPool,
                "username|alice" + WorkloadGroupTask.WORKLOAD_GROUP_PRINCIPAL_VALUE_DELIMITER + "role|admin",  
import org.opensearch.rule.storage.DefaultAttributeValueStore;
                );
                return "wlm";
        assertEquals(Integer.MAX_VALUE, autoTaggingActionFilter.order());
            AutoTaggingActionFilter filter = new AutoTaggingActionFilter(  
        }
                when(ruleProcessingService.evaluateLabel(anyList())).thenReturn(Optional.of("TestQG_ID"));  
    }
                assertEquals(
import org.opensearch.rule.autotagging.Attribute;
            @Override  
                assertEquals("TestQG_ID", defaultHeaderPool.getThreadContext().getHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER));
                return PRINCIPAL_ATTRIBUTE_NAME;  
        AutoTaggingActionFilter filter = new AutoTaggingActionFilter(  
        }
            when(svc.evaluateLabel(anyList())).thenReturn(Optional.of("QG"));
import java.util.Map;
    }  
        when(request.originalIndicesOrEmpty()).thenReturn(new String[] { "logs-scroll-index" });
        ActionFilterChain<ActionRequest, ActionResponse> chain = mock(TestActionFilterChain.class);  
            }  
        public void validateAttribute() {}
            @Override  
        InMemoryRuleProcessingService svc = spy(
        } finally {  
    }  
        );  
            public String getName() {
                assertEquals(1, extractors.size());  
    public void testApplyDoesNotOverwriteExistingHeader() {  
    }
import org.opensearch.rule.storage.AttributeValueStoreFactory;
            @Override
        return new WorkloadGroupTask(1L, "transport", "Test", "test task", TaskId.EMPTY_TASK_ID, Map.of());
            return name;  
            public String getName() {
            public void validateAttribute() {}  
        try (ThreadContext.StoredContext context = threadPool.getThreadContext().stashContext()) {  
            mock(WlmClusterSettingValuesProvider.class),  
 */  
                return Optional.of("ScrollQG_ID");  
            new InMemoryRuleProcessingService(  
import static org.mockito.Mockito.mock;  
                @SuppressWarnings("unchecked")
        Attribute principalAttr = new Attribute() {  
            @Override
            defaultHeaderPool.shutdownNow();
        SearchScrollRequest request = mock(SearchScrollRequest.class);
                assertEquals(RuleAttribute.INDEX_PATTERN, ex.getAttribute());  
            @Override  
        );  
    }
import org.opensearch.threadpool.ThreadPool;  
        public void writeTo(StreamOutput out) throws IOException {}
        // A feature type that includes a "principal" attribute + a matching extractor extension in the map.
                assertEquals(List.of("logs-scroll-index"), values);
                return LogicalOperator.OR;
            }).when(ruleProcessingService).evaluateLabel(any());
            threadPool,
import static org.mockito.Mockito.spy;
        @Override  
        AttributeExtractorExtension extension = () -> principalExtractor;
        public void proceed(Task task, String action, ActionRequest request, ActionListener<ActionResponse> listener) {
public class AutoTaggingActionFilterTests extends OpenSearchTestCase {  
            ruleProcessingService,  
        ActionFilterChain<ActionRequest, ActionResponse> mockFilterChain = mock(TestActionFilterChain.class);
                new AttributeValueStoreFactory(featureTypeWithPrincipal, DefaultAttributeValueStore::new),
            public Iterable<String> extract() {  
        AttributeExtractorExtension extension = () -> principalExtractor;  
    private static WorkloadGroupTask newWorkloadGroupTask() {
    public void testOrder() {
                filter.apply(mock(Task.class), "Test", request, ActionRequestMetadata.empty(), null, mockFilterChain);
            autoTaggingActionFilter.apply(task, "Test", request, ActionRequestMetadata.empty(), null, chain);
import static org.mockito.Mockito.when;
            this.name = name;
import org.opensearch.common.settings.Settings;
            @Override
 * SPDX-License-Identifier: Apache-2.0
            public LogicalOperator getLogicalOperator() {
        SearchRequest request = mock(SearchRequest.class);
        public String getName() {
import org.opensearch.rule.RuleAttribute;  
            public String getName() {
                ex.extract().forEach(values::add);  
        WLM;
    public void testApplyForValidRequest() {
            )  
            }  
import java.io.IOException;  
            public LogicalOperator getLogicalOperator() {  
                return List.of("username|alice");
        }
        public String getName() {
        // No principal extractor, so the principal stays null and username/role throttling fails open.
        autoTaggingActionFilter.apply(mock(Task.class), "Test", request, ActionRequestMetadata.empty(), null, mockFilterChain);
        when(request.indices()).thenReturn(new String[] { "foo" });
        FeatureType featureTypeWithPrincipal = new FeatureType() {  
import java.util.ArrayList;
        TestAttribute(String name) {  
            filter.apply(second, "Test", request, ActionRequestMetadata.empty(), null, chain);
            assertEquals("extract() must be invoked once per request", 2, extractCalls.get());
                null
            }
import org.opensearch.rule.attribute_extractor.AttributeExtractor;
        }  
import org.opensearch.core.action.ActionResponse;
            assertEquals("ScrollQG_ID", threadPool.getThreadContext().getHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER));
}
            threadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "OuterQG_ID");
                extractCalls.incrementAndGet();
            Map.of(principalAttr, extension),
    public enum TestAttribute implements Attribute {  
            assertEquals(
import org.opensearch.common.util.concurrent.ThreadContext;
                assertNotNull(extractors);
        ActionRequestMetadata<ActionRequest, ActionResponse> metadata = mock(ActionRequestMetadata.class);  
            }
            .build();  
        try (ThreadContext.StoredContext ctx = threadPool.getThreadContext().stashContext()) {  
            featureTypeWithPrincipal
            }
    }  
import org.opensearch.action.search.SearchRequest;  
            new InMemoryRuleProcessingService(
        }
            assertEquals("username|alice", first.getThrottlePrincipal());
        AtomicInteger extractCalls = new AtomicInteger();
        );
            @Override
        };  
            try (ThreadContext.StoredContext context = defaultHeaderPool.getThreadContext().stashContext()) {
    ThreadPool threadPool;
        try (ThreadContext.StoredContext ctx = threadPool.getThreadContext().stashContext()) {  
        }  
            public void validateAttribute() {}
            when(request.indices()).thenReturn(new String[] { "foo" });  
