            String msg = getRootMessage(e);
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();  
            String msg = getRootMessage(e);
 * Starts a real single-node cluster and verifies the MBean registers and validates paths.
import org.opensearch.plugins.Plugin;  
        ObjectName mbean = new ObjectName(MBEAN_NAME);
/**
/*  
package org.opensearch.nativebridge;
        }
        while (cause.getCause() != null) {
    protected Settings nodeSettings(int nodeOrdinal) {
        try {
        } catch (Exception e) {  
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();  
import javax.management.ObjectName;
        }
        assertTrue("HeapProfiler MBean should be registered after node start", mbs.isRegistered(mbean));
 * Tests that require native library calls are skipped when the library is unavailable.
 * compatible open source license.
    }
 *
@org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix(bugUrl = "Flaky: node disconnection during cluster formation on CI")
        ObjectName mbean = new ObjectName(MBEAN_NAME);
}
    }  
    }  
    private static final String MBEAN_NAME = "org.opensearch.native:type=HeapProfiler";
        ObjectName mbean = new ObjectName(MBEAN_NAME);
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            fail("Should have rejected disallowed path");
        return Collections.singletonList(NativeBridgeModule.class);  
            fail("Should have rejected path with traversal");
        }  
        } catch (Exception e) {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();  
    }  
            cause = cause.getCause();  
        try {  
 */  
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
        try {  
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collections;
    @Override
    }
    public void testDumpRejectsDisallowedPath() throws Exception {  
        } catch (Exception e) {  
        NativeHeapProfiler.setAllowedDumpDirs(List.of("/data/allowed"));  
import java.util.Collection;
        Throwable cause = e;
            assertTrue(msg, msg.contains("Path traversal"));
            mbs.invoke(mbean, "dump", new Object[] { "/tmp/../etc/evil.heap" }, new String[] { "java.lang.String" });
    public void testResetRejectsInvalidSample() throws Exception {
    private static String getRootMessage(Exception e) {  
            String msg = getRootMessage(e);  
    public void testDumpRejectsPathTraversal() throws Exception {
    }  
import javax.management.MBeanServer;  
import org.opensearch.test.OpenSearchIntegTestCase;
            assertTrue(msg, msg.contains("not under allowed directories"));
            mbs.invoke(mbean, "dump", new Object[] { "/etc/not_allowed.heap" }, new String[] { "java.lang.String" });  
    public void testMBeanIsRegistered() throws Exception {
import java.lang.management.ManagementFactory;  
 * The OpenSearch Contributors require contributions made to  
        }  
 * Integration test for NativeHeapProfiler JMX MBean.  
 */  
import org.opensearch.common.settings.Settings;
public class NativeHeapProfilerIT extends OpenSearchIntegTestCase {  
        ObjectName mbean = new ObjectName(MBEAN_NAME);
    @Override  
import org.opensearch.nativebridge.spi.NativeHeapProfiler;
        return cause.getMessage() != null ? cause.getMessage() : cause.toString();
            mbs.invoke(mbean, "reset", new Object[] { -1 }, new String[] { "int" });
            fail("Should have rejected negative lg_sample");
            assertTrue(msg, msg.contains("must be between"));
    }
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;  
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).build();
