import org.opensearch.wlm.WorkloadGroupTask;  
        FeatureType featureType  
        if (isSearchRequest) {
    /**
    private final FeatureType featureType;  
        } else {
                    }
    }
import static org.opensearch.plugin.wlm.WorkloadManagementPlugin.PRINCIPAL_ATTRIBUTE_NAME;
            chain.proceed(task, action, request, listener);
            extractor.extract().forEach(values::add);
import org.opensearch.wlm.WlmMode;
import org.opensearch.core.action.ActionListener;  
import java.util.List;
/**
     * @param ruleProcessingService provides access to in memory view of rules
            principalValues = values;
        }
import org.opensearch.threadpool.ThreadPool;
 * The OpenSearch Contributors require contributions made to  
            Attribute attribute = featureType.getAllowedAttributesRegistry().get(PRINCIPAL_ATTRIBUTE_NAME);
        // Carried on the task, not the thread context; see WorkloadGroupTask#setThrottlePrincipal.
    @Override
    @Override  
                }
    private final ThreadPool threadPool;  
                    }  
                    @Override
        this.ruleProcessingService = ruleProcessingService;
        InMemoryRuleProcessingService ruleProcessingService,
import org.opensearch.rule.autotagging.Attribute;
 * compatible open source license.
import org.opensearch.rule.attribute_extractor.AttributeExtractor;  
    private final InMemoryRuleProcessingService ruleProcessingService;
import org.opensearch.action.ActionRequest;
        ThreadContext threadContext = threadPool.getThreadContext();
            final String[] originalIndices = ((SearchScrollRequest) request).originalIndicesOrEmpty();  
                ((WorkloadGroupTask) task).setThrottlePrincipal(principal);  
        Map<Attribute, AttributeExtractorExtension> attributeExtensions,
        if (featureType.getAllowedAttributesRegistry().containsKey(PRINCIPAL_ATTRIBUTE_NAME)) {
import org.opensearch.rule.RuleAttribute;
    }  
 * this file be licensed under the Apache-2.0 license or a
                    }
     * @param threadPool to access assign the label
 * This class is responsible to evaluate and assign the WORKLOAD_GROUP_ID header in ThreadContext
                    public LogicalOperator getLogicalOperator() {
                }
                }  
            });  
     * @param featureType
    public int order() {
import org.opensearch.action.search.SearchRequest;  
                });
                    return extractor.getLogicalOperator();
import org.opensearch.plugin.wlm.spi.AttributeExtractorExtension;  
    private final Map<Attribute, AttributeExtractorExtension> attributeExtensions;
        }  
import org.opensearch.action.search.SearchScrollRequest;
                    @Override
import org.opensearch.action.support.ActionFilter;
                public Iterable<String> extract() {
    ) {
        if (!isValidRequest || wlmClusterSettingValuesProvider.getWlmMode() == WlmMode.DISABLED) {  
 * SPDX-License-Identifier: Apache-2.0
            final AttributeExtractor<String> extractor = attributeExtensions.get(attribute).getAttributeExtractor();
        chain.proceed(task, action, request, listener);  
            // Materialize once: extract() has no re-iterability contract, and an empty second read would disable throttling.
        this.attributeExtensions = attributeExtensions;
            }
        Task task,
        Optional<String> label = ruleProcessingService.evaluateLabel(attributeExtractors);  
        this.featureType = featureType;  
                    return extractor.getAttribute();  
        List<String> principalValues = null;  
            // Scroll: recover the original user-provided indices from ParsedScrollId
                @Override
import java.util.Map;
            if (originalIndices.length > 0) {
            attributeExtractors.add(new AttributeExtractor<>() {  
import org.opensearch.rule.autotagging.FeatureType;
import org.opensearch.plugin.wlm.rule.attribute_extractor.IndicesExtractor;
                    return values;
        }
        List<AttributeExtractor<String>> attributeExtractors = new ArrayList<>();
        String action,
            if (principal.isEmpty() == false) {
            return;
                attributeExtractors.add(new AttributeExtractor<>() {
                    public Iterable<String> extract() {  
     * @param attributeExtensions  
import org.opensearch.core.action.ActionResponse;
     */  
import org.opensearch.action.IndicesRequest;
            final List<String> values = new ArrayList<>();  
    ) {
        }
                @Override  
            label.ifPresent(s -> threadContext.putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, s));  
            String principal = String.join(WorkloadGroupTask.WORKLOAD_GROUP_PRINCIPAL_VALUE_DELIMITER, principalValues);
                @Override
import org.opensearch.tasks.Task;  
        WlmClusterSettingValuesProvider wlmClusterSettingValuesProvider,
 */  
        final boolean isValidRequest = isSearchRequest || isSearchScrollRequest;
    public AutoTaggingActionFilter(
 */  
import org.opensearch.action.support.ActionFilterChain;  
        ActionFilterChain<Request, Response> chain  
        ActionRequestMetadata<Request, Response> actionRequestMetadata,
                        return RuleAttribute.INDEX_PATTERN;
        final boolean isSearchScrollRequest = request instanceof SearchScrollRequest;  
                public Attribute getAttribute() {
    }
                        return LogicalOperator.AND;  
        final boolean isSearchRequest = request instanceof SearchRequest;
        this.wlmClusterSettingValuesProvider = wlmClusterSettingValuesProvider;
        this.threadPool = threadPool;  
            }  
import java.util.Arrays;  
public class AutoTaggingActionFilter implements ActionFilter {
        if (threadContext.getRequestHeadersOnly().containsKey(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER) == false) {
                        return Arrays.asList(originalIndices);
     * @param wlmClusterSettingValuesProvider
        Request request,  
import org.opensearch.action.support.ActionRequestMetadata;
package org.opensearch.plugin.wlm;
import java.util.ArrayList;
     * Main constructor  
        ThreadPool threadPool,  
/*  
import org.opensearch.common.util.concurrent.ThreadContext;
    private final WlmClusterSettingValuesProvider wlmClusterSettingValuesProvider;
            attributeExtractors.add(new IndicesExtractor((IndicesRequest) request));  
import org.opensearch.rule.InMemoryRuleProcessingService;
 *
        }
            assert attributeExtensions.containsKey(attribute);  
        if (principalValues != null && task instanceof WorkloadGroupTask) {  
    public <Request extends ActionRequest, Response extends ActionResponse> void apply(  
                    public Attribute getAttribute() {
                    @Override  
        ActionListener<Response> listener,
        return Integer.MAX_VALUE;
                public LogicalOperator getLogicalOperator() {  
}
import java.util.Optional;  
