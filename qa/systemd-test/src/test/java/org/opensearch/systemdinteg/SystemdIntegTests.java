    private boolean checkPathExists(String path) throws IOException, InterruptedException {
            "/sys/fs/cgroup/memory", "/sys/fs/cgroup/memory/-"  
* GitHub history for details.  
import java.util.Locale;
            assertTrue("Path should be writable: " + path, checkPathWritable(path));
        String seccomp = executeCommand("grep \"^Seccomp:\" /proc/" + opensearchPid + "/status", "Failed to read Seccomp status");
        return Boolean.parseBoolean(executeCommand(command, "Failed to check path existence"));  
        // Wait a moment for any potential termination to take effect  
        String serviceStatus = executeCommand(
            return output.toString().trim();
        // Check if Seccomp is enabled
import org.apache.hc.core5.http.HttpHost;
import org.apache.lucene.tests.util.LuceneTestCase;
            }
        return output.replace("MainPID=", "").trim();
import org.junit.Test;  
*/
import org.junit.After;  
import java.io.InputStreamReader;
            assertTrue("Path should be readable: " + path, checkPathReadable(path));  
    public void testReadWritePaths() throws IOException, InterruptedException {
        String rebootResult = executeCommand("sudo su opensearch -c 'kill -s SIGHUP 1' 2>&1 || echo 'Operation not permitted'", "Failed to test reboot system call");
            if (process.waitFor() != 0) {
        assertNotEquals("Seccomp should be enabled", 0, seccompValue);
        String scriptPath;
        return Boolean.parseBoolean(executeCommand(command, "Failed to check write permission"));
            }
import java.nio.file.attribute.PosixFilePermissions;  
    public void testSeccompEnabled() throws IOException, InterruptedException {  
* Modifications Copyright OpenSearch Contributors. See
        String output = executeCommand(command, "Failed to get OpenSearch PID");  
import java.nio.file.Path;  
import java.net.URISyntaxException;
        Process process = Runtime.getRuntime().exec(new String[]{"bash", "-c", command});
        }
import java.nio.file.Paths;
    }
        String command = String.format(Locale.ROOT, "sudo su opensearch -s /bin/sh -c 'test -w %s && echo true || echo false'", path);  
/*
            "Failed to check OpenSearch service status"  
        assertTrue("Reboot system call should be blocked", rebootResult.contains("Operation not permitted"));  
        ProcessBuilder processBuilder = new ProcessBuilder(scriptPath, opensearchPid);  
        for (String path : readOnlyPaths) {  
import static org.junit.Assert.assertEquals;
            StringBuilder output = new StringBuilder();  
            }
        String command = String.format(Locale.ROOT, "stat -c '%%U:%%G' %s", path);
    private static String opensearchPid;
    }
        String[] readOnlyPaths = {
    public void testOpenSearchProcessCannotExit() throws IOException, InterruptedException {  
        String[] readWritePaths = {"/var/log/opensearch", "/var/lib/opensearch"};  
import org.junit.BeforeClass;
    public void testMaxProcesses() throws IOException, InterruptedException {
        return executeCommand(command, "Failed to get path ownership");  
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8))) {
        assertEquals("OpenSearch service should be active", "active", serviceStatus.trim());  
            "/sys/fs/cgroup/cpuacct", "/sys/fs/cgroup/cpuacct/-",
        String command = String.format(Locale.ROOT, "sudo su opensearch -s /bin/sh -c 'test -r %s && echo true || echo false'", path);
    }
        String limits = executeCommand("sudo su -c 'cat /proc/" + opensearchPid + "/limits'", "Failed to read process limits");
        );
import java.nio.file.Files;
        for (String path : readWritePaths) {
                throw new RuntimeException(errorMessage);  
        }
import static org.junit.Assert.assertFalse;
    private boolean checkPathReadable(String path) throws IOException, InterruptedException {  
                output.append(line).append("\n");  
        // Verify the OpenSearch service status  
    }  
    private static String getOpenSearchPid() throws IOException, InterruptedException {
    private static String executeCommand(String command, String errorMessage) throws IOException, InterruptedException {  
import static org.junit.Assert.assertNotEquals;  
            String line;
    }
                assertFalse("Path should not be writable: " + path, checkPathWritable(path));  
* SPDX-License-Identifier: Apache-2.0
            assertTrue("Path should be owned by opensearch:opensearch or opensearch:adm", ownership.equals("opensearch:opensearch") || ownership.equals("opensearch:adm"));  
    public static void setup() throws IOException, InterruptedException {
        String limits = executeCommand("sudo su -c 'cat /proc/" + opensearchPid + "/limits'", "Failed to read process limits");  
        Process process = processBuilder.start();
        }  
            if (checkPathExists(path)) {
                limits.contains("Max open files            unlimited            unlimited"));  
            String ownership = getPathOwnership(path);
        try {  
            "/proc/self/mountinfo", "/proc/diskstats", "/proc/meminfo",  
    }
        String command = String.format(Locale.ROOT, "test -e %s && echo true || echo false", path);
            while ((line = reader.readLine()) != null) {
import java.io.InputStream;  
import static org.junit.Assert.assertTrue;  
    }
            throw new RuntimeException("Failed to find OpenSearch process ID");  
import java.nio.file.StandardOpenOption;
            "/etc/os-release", "/usr/lib/os-release", "/etc/system-release",
            scriptPath = SystemdIntegTests.class.getResource("/scripts/terminate.sh").toURI().getPath();
        } catch (URISyntaxException e) {
            assertTrue("Path should exist: " + path, checkPathExists(path));
import org.apache.hc.core5.http.HttpHeaders;  
        assertTrue("File descriptor limit should be at least 65535", 
                limits.contains("Max processes             4096                 4096") ||
        String command = "systemctl show --property=MainPID opensearch";
* The OpenSearch Contributors require contributions made to  
    }
import org.apache.hc.core5.http.HttpStatus;
public class SystemdIntegTests extends LuceneTestCase {  
}  
    }
* compatible open source license.
        if (opensearchPid.isEmpty()) {
import java.io.IOException;
        }
        };
            throw new IllegalStateException("Could not find terminate.sh script in resources");
*/  
    }  
import java.io.BufferedReader;
        opensearchPid = getOpenSearchPid();  
        if (scriptPath == null) {  
            "systemctl is-active opensearch",
        int seccompValue = Integer.parseInt(seccomp.split(":\\s*")[1].trim());  
    @BeforeClass
                limits.contains("Max open files            65535                65535") ||
        assertTrue("Max processes limit should be 4096 or unlimited",  
    }
                assertTrue("Path should be readable: " + path, checkPathReadable(path));
*
        }
            "/proc/self/cgroup", "/sys/fs/cgroup/cpu", "/sys/fs/cgroup/cpu/-",
    }  
    public void testFileDescriptorLimit() throws IOException, InterruptedException {
        return Boolean.parseBoolean(executeCommand(command, "Failed to check read permission"));
/*  
    public void testRebootSysCall() throws IOException, InterruptedException {
            throw new RuntimeException("Failed to convert URL to URI", e);  
import org.junit.Before;
import java.nio.charset.StandardCharsets;  
    }
    public void testReadOnlyPaths() throws IOException, InterruptedException {  
    private boolean checkPathWritable(String path) throws IOException, InterruptedException {
        }
        Thread.sleep(2000);
    }
package org.opensearch.systemdinteg;  
    private String getPathOwnership(String path) throws IOException, InterruptedException {
* this file be licensed under the Apache-2.0 license or a
                limits.contains("Max processes             unlimited            unlimited"));
