        ThreadPool threadPool = new TestThreadPool(getTestName());  
    public static class TestPlugin extends Plugin implements IdentityAwarePlugin {
import java.util.List;
        IdentityService identityService = new IdentityService(Settings.EMPTY, threadPool, List.of());
import org.opensearch.threadpool.ThreadPool;  
        TestPlugin testPlugin = new TestPlugin();  
}  
 * SPDX-License-Identifier: Apache-2.0
        public void assignSubject(PluginSubject subject) {
    }  
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.identity.IdentityService;
    }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.threadpool.TestThreadPool;
        }
 */  
        assertThat(testPlugin.getSubject().getPrincipal().getName(), equalTo(NamedPrincipal.UNAUTHENTICATED.getName()));
import org.opensearch.identity.NamedPrincipal;  
        threadPool.getThreadContext().putHeader("test_header", "foo");  
        testPluginSubject.runAs(() -> { assertNull(threadPool.getThreadContext().getHeader("test_header")); });
import org.opensearch.plugins.IdentityAwarePlugin;
 * compatible open source license.
        public PluginSubject getSubject() {  
package org.opensearch.identity.noop;
import org.opensearch.common.settings.Settings;
 *
        @Override
    public void testInitializeIdentityAwarePlugin() throws Exception {
/*  
 * this file be licensed under the Apache-2.0 license or a
            this.subject = subject;  
        assertThat(threadPool.getThreadContext().getHeader("test_header"), equalTo("foo"));  
import static org.hamcrest.Matchers.equalTo;
            return subject;
        }
        assertThat(threadPool.getThreadContext().getHeader("test_header"), equalTo("foo"));
public class NoopPluginSubjectTests extends OpenSearchTestCase {  
        terminate(threadPool);
        private PluginSubject subject;
        PluginSubject testPluginSubject = new NoopPluginSubject(threadPool);  
import org.opensearch.plugins.Plugin;  
        assertThat(testPluginSubject.getPrincipal().getName(), equalTo(NamedPrincipal.UNAUTHENTICATED.getName()));
        identityService.initializeIdentityAwarePlugins(List.of(testPlugin));
import org.opensearch.identity.PluginSubject;
