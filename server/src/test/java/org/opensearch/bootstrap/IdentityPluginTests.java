    }  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.plugins.IdentityPlugin;  
        assertTrue(identityService1.getCurrentSubject().getPrincipal().getName().equalsIgnoreCase("Unauthenticated"));
    public void testSingleIdentityPluginSucceeds() {
 * SPDX-License-Identifier: Apache-2.0
}
        List<IdentityPlugin> pluginList = List.of(identityPlugin1, identityPlugin2, identityPlugin3);
    public void testMultipleIdentityPluginsFail() {  
import org.opensearch.identity.noop.NoopTokenManager;
        terminate(threadPool);
import org.opensearch.test.OpenSearchTestCase;
    }
import org.opensearch.identity.IdentityService;  
import static org.hamcrest.Matchers.instanceOf;  
import org.opensearch.identity.noop.NoopIdentityPlugin;
        IdentityPlugin identityPlugin2 = new NoopIdentityPlugin(threadPool);  
        List<IdentityPlugin> pluginList1 = List.of(identityPlugin1);
public class IdentityPluginTests extends OpenSearchTestCase {  
 */  
        terminate(threadPool);  
        IdentityPlugin identityPlugin1 = new NoopIdentityPlugin(threadPool);
 *
        TestThreadPool threadPool = new TestThreadPool(getTestName());  
import java.util.List;
/*  
        IdentityPlugin identityPlugin3 = new NoopIdentityPlugin(threadPool);
        TestThreadPool threadPool = new TestThreadPool(getTestName());
import static org.hamcrest.Matchers.is;
        Exception ex = assertThrows(OpenSearchException.class, () -> new IdentityService(Settings.EMPTY, threadPool, pluginList));  
import org.opensearch.OpenSearchException;
        IdentityPlugin identityPlugin1 = new NoopIdentityPlugin(threadPool);
        assert (ex.getMessage().contains("Multiple identity plugins are not supported,"));
        IdentityService identityService1 = new IdentityService(Settings.EMPTY, threadPool, pluginList1);  
package org.opensearch.bootstrap;
        assertThat(identityService1.getTokenManager(), is(instanceOf(NoopTokenManager.class)));
import org.opensearch.threadpool.TestThreadPool;
import org.opensearch.common.settings.Settings;
