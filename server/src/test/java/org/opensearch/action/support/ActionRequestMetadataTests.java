/*  
            super("action", new ActionFilters(Set.of()), null);  
    public void testResolvedIndices() {
 * this file be licensed under the Apache-2.0 license or a
            super("action", new ActionFilters(Set.of()), null);  
        }  
        protected TestTransportActionUnsupported() {
        assertFalse(resolvedIndices instanceof ResolvedIndices);
            new TestRequest("my_resolution_result")
        assertEquals(ResolvedIndices.of("my_resolution_result"), resolvedIndices);
    }
    }
import org.opensearch.test.OpenSearchTestCase;
    }  
            new TestTransportAction(),  
        protected void doExecute(Task task, TestRequest request, ActionListener<ActionResponse> listener) {
            return ResolvedIndices.of(request.resolutionResult);
package org.opensearch.action.support;
            TransportIndicesResolvingAction<TestRequest> {  
        OptionallyResolvedIndices resolvedIndices = subject.resolvedIndices();  
 * compatible open source license.
import org.opensearch.cluster.metadata.ResolvedIndices;
 * SPDX-License-Identifier: Apache-2.0
        OptionallyResolvedIndices resolvedIndices = subject.resolvedIndices();  
        }  
    public void testResolvedIndices_unknown() {
        public OptionallyResolvedIndices resolveIndices(TestRequest request) {  
        }
    static class TestRequest extends ActionRequest {
        }
            new TestTransportActionUnsupported(),  
        @Override  
        implements
    }
 *
        );
import org.opensearch.core.action.ActionResponse;  
        @Override  
        @Override
        }
        );
import org.opensearch.tasks.Task;
 */  
            return null;
    }
    static class TestTransportAction extends TransportAction<TestRequest, ActionResponse>
            new TestRequest("my_resolution_result")
            this.resolutionResult = resolutionResult;  
        TestRequest(String resolutionResult) {
import org.opensearch.action.ActionRequestValidationException;
        @Override  
        ActionRequestMetadata<?, ?> subject = new ActionRequestMetadata<>(
 * The OpenSearch Contributors require contributions made to  
public class ActionRequestMetadataTests extends OpenSearchTestCase {  
        }  
import org.opensearch.core.action.ActionListener;
import org.opensearch.action.ActionRequest;
import org.opensearch.cluster.metadata.OptionallyResolvedIndices;  
        ActionRequestMetadata<?, ?> subject = new ActionRequestMetadata<>(
import java.util.Set;
        protected TestTransportAction() {
        public ActionRequestValidationException validate() {
        protected void doExecute(Task task, TestRequest request, ActionListener<ActionResponse> listener) {
        final String resolutionResult;  
}
        }
    static class TestTransportActionUnsupported extends TransportAction<TestRequest, ActionResponse> {  
