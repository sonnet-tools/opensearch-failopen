        try {
                }  
        ex = assertThrows(IllegalArgumentException.class, () -> dynamicActionRegistry.unregisterDynamicAction(testExtensionAction));
        assertNull(registry.get(r3));
 * The OpenSearch Contributors require contributions made to  
            .build();
        private TestAction() {
import org.opensearch.tasks.TaskManager;
        }
        // Should fail inserting twice  
        DynamicActionRegistry registry = new DynamicActionRegistry();  
        public static final TestAction INSTANCE = new TestAction();
            .uniqueName("bar")
        assertNotNull(dynamicActionRegistry.get(TestAction.INSTANCE));  
    public void testDynamicActionRegistryWithNamedRoutes() {
    public void testDynamicActionRegistryWithNamedRoutesAndLegacyActionNames() {
    };  
        assertTrue(registry.isActionRegistered("bar"));  
        assertFalse(registry.isActionRegistered("bar"));
        assertFalse(registry.isActionRegistered("cluster:admin/opensearch/xyz/bar"));
        RestSendToExtensionAction action2 = mock(RestSendToExtensionAction.class);  
        dynamicActionRegistry.registerUnmodifiableActionMap(testMap);  
        ActionFilters emptyFilters = new ActionFilters(Collections.emptySet());
    }
    }  
        NamedRoute r1 = new NamedRoute.Builder().method(RestRequest.Method.GET).path("/foo").uniqueName("foo").build();
        protected void doExecute(Task task, ActionRequest request, ActionListener<ActionResponse> listener) {}
    public void testDynamicActionRegistry() {
            .uniqueName("foo")  
                    return null;
            fail("Should not have thrown exception registering action: " + e);
        // Register an extension action  
    private static final class TestTransportAction extends TransportAction<ActionRequest, ActionResponse> {
            super(actionName, actionFilters, taskManager);
        registry.registerDynamicRoute(r2, action2);
        } catch (Exception e) {  
        // ExtensionsAction not yet registered
import org.opensearch.core.common.io.stream.StreamInput;
        assertNull(dynamicActionRegistry.get(testExtensionAction));
        assertEquals(testExtensionTransportAction, dynamicActionRegistry.get(testExtensionAction));
            IllegalArgumentException.class,
import org.opensearch.extensions.rest.RestSendToExtensionAction;
        DynamicActionRegistry dynamicActionRegistry = new DynamicActionRegistry();
                @Override  
        try {
import org.opensearch.core.action.ActionListener;
        }  
 *
        assertTrue(registry.isActionRegistered("cluster:admin/opensearch/abc/foo"));  
import org.opensearch.core.common.io.stream.Writeable;
import static org.mockito.Mockito.mock;  
    }
 * compatible open source license.
        assertEquals(action, registry.get(r1));
            dynamicActionRegistry.unregisterDynamicAction(testExtensionAction);
import org.opensearch.test.OpenSearchTestCase;
        DynamicActionRegistry registry = new DynamicActionRegistry();  
    private static final class TestAction extends ActionType<ActionResponse> {
        );
        // Should contain the immutable map entry
            super("test-action", new Writeable.Reader<ActionResponse>() {
            .path("/foo")
        assertTrue(registry.isActionRegistered("foo"));  
            .path("/bar")
            () -> dynamicActionRegistry.registerDynamicAction(testExtensionAction, testExtensionTransportAction)  
        registry.registerDynamicRoute(r1, action);
        NamedRoute r2 = new NamedRoute.Builder().method(RestRequest.Method.PUT)  
            .legacyActionNames(Set.of("cluster:admin/opensearch/abc/foo"))
        // Should remove without problem  
        NamedRoute r1 = new NamedRoute.Builder().method(RestRequest.Method.GET)
        RestSendToExtensionAction action2 = mock(RestSendToExtensionAction.class);
        registry.registerDynamicRoute(r2, action2);
import org.opensearch.rest.RestRequest;
        } catch (Exception e) {
}
import java.util.Map;  
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(registry.isActionRegistered("cluster:admin/opensearch/xyz/bar"));
                public ActionResponse read(StreamInput in) throws IOException {
import org.opensearch.rest.NamedRoute;  
 */  
import java.util.Collections;
import org.opensearch.extensions.action.ExtensionTransportAction;
/*  
            fail("Should not have thrown exception unregistering action: " + e);
        Map<ActionType, TransportAction> testMap = Map.of(TestAction.INSTANCE, new TestTransportAction("test-action", emptyFilters, null));  
import java.io.IOException;
        RestSendToExtensionAction action = mock(RestSendToExtensionAction.class);
        assertTrue(registry.isActionRegistered("cluster:admin/opensearch/abc/foo"));
        // Should not contain anything not added
        ExtensionTransportAction testExtensionTransportAction = new ExtensionTransportAction("test-action", emptyFilters, null, null);  
public class DynamicActionRegistryTests extends OpenSearchTestCase {
        registry.unregisterDynamicRoute(r2);
import java.util.Set;
            dynamicActionRegistry.registerDynamicAction(testExtensionAction, testExtensionTransportAction);  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(action2, registry.get(r2));
import org.opensearch.action.ActionModule.DynamicActionRegistry;
        RestSendToExtensionAction action = mock(RestSendToExtensionAction.class);  
        // Should fail removing twice  
            .legacyActionNames(Set.of("cluster:admin/opensearch/xyz/bar"))  
import org.opensearch.extensions.action.ExtensionAction;  
        assertNull(dynamicActionRegistry.get(MainAction.INSTANCE));
import org.opensearch.action.main.MainAction;
package org.opensearch.action;
        RestHandler.Route r3 = new RestHandler.Route(RestRequest.Method.DELETE, "/foo");
        protected TestTransportAction(String actionName, ActionFilters actionFilters, TaskManager taskManager) {  
        assertEquals("action [actionName] was not registered", ex.getMessage());
import org.opensearch.action.support.TransportAction;
import org.opensearch.tasks.Task;  
import org.opensearch.rest.RestHandler;
        // Should have been removed  
            .build();
        registry.unregisterDynamicRoute(r2);
        assertEquals("action [actionName] already registered", ex.getMessage());
        @Override
        NamedRoute r2 = new NamedRoute.Builder().method(RestRequest.Method.PUT).path("/bar").uniqueName("bar").build();  
import org.opensearch.core.action.ActionResponse;  
    }  
        registry.registerDynamicRoute(r1, action);
            });
        IllegalArgumentException ex = assertThrows(
        assertNull(dynamicActionRegistry.get(testExtensionAction));
        ExtensionAction testExtensionAction = new ExtensionAction("extensionId", "actionName");
import org.opensearch.action.support.ActionFilters;  
        }
        // Should insert without problem
        }
        assertTrue(registry.isActionRegistered("foo"));
