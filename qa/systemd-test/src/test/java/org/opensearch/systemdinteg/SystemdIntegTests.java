    }
    }
    public void testReadOnlyPaths() throws IOException, InterruptedException {
import org.junit.Before;
import org.apache.hc.core5.http.HttpStatus;
    }
            String ownership = getPathOwnership(path);
        String rebootResult = executeCommand("sudo su opensearch -c 'kill -s SIGHUP 1' 2>&1 || echo 'Operation not permitted'", "Failed to test reboot system call");
import java.nio.file.Files;
            String line;
        for (String path : readOnlyPaths) {
        }
}
    }
            scriptPath = SystemdIntegTests.class.getResource("/scripts/terminate.sh").toURI().getPath();
        String limits = executeCommand("sudo su -c 'cat /proc/" + opensearchPid + "/limits'", "Failed to read process limits");
            "/etc/os-release", "/usr/lib/os-release", "/etc/system-release",
    private static String opensearchPid;
/*
import java.util.Locale;
            assertTrue("Path should be readable: " + path, checkPathReadable(path));
*/
import org.apache.hc.core5.http.HttpHeaders;
    public void testFileDescriptorLimit() throws IOException, InterruptedException {
import java.nio.file.attribute.PosixFilePermissions;
        Thread.sleep(2000);
import org.junit.Test;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8))) {
                assertTrue("Path should be readable: " + path, checkPathReadable(path));
* The OpenSearch Contributors require contributions made to
import static org.junit.Assert.assertTrue;
        assertTrue("Reboot system call should be blocked", rebootResult.contains("Operation not permitted"));
        for (String path : readWritePaths) {
        // Check if Seccomp is enabled
        }
    }
            while ((line = reader.readLine()) != null) {
                throw new RuntimeException(errorMessage);
    public void testSeccompEnabled() throws IOException, InterruptedException {
            "systemctl is-active opensearch",
        String[] readWritePaths = {"/var/log/opensearch", "/var/lib/opensearch"};
        assertTrue("Max processes limit should be 4096 or unlimited", 
    }
        Process process = processBuilder.start();
        }
    }
* GitHub history for details.
        String command = String.format(Locale.ROOT, "test -e %s && echo true || echo false", path);
        return Boolean.parseBoolean(executeCommand(command, "Failed to check write permission"));
                limits.contains("Max processes             unlimited            unlimited"));
            throw new IllegalStateException("Could not find terminate.sh script in resources");
    }
        );
            StringBuilder output = new StringBuilder();
            "/proc/self/cgroup", "/sys/fs/cgroup/cpu", "/sys/fs/cgroup/cpu/-",
            }
    }
        }
            assertTrue("Path should exist: " + path, checkPathExists(path));
            "Failed to check OpenSearch service status"
            return output.toString().trim();
*
        }
public class SystemdIntegTests extends LuceneTestCase {
        assertTrue("File descriptor limit should be at least 65535", 
        String command = String.format(Locale.ROOT, "stat -c '%%U:%%G' %s", path);
                output.append(line).append("\n");
    private boolean checkPathReadable(String path) throws IOException, InterruptedException {
import java.net.URISyntaxException;
    }
                assertFalse("Path should not be writable: " + path, checkPathWritable(path));
import org.junit.BeforeClass;
        if (scriptPath == null) {
            "/sys/fs/cgroup/memory", "/sys/fs/cgroup/memory/-"
            assertTrue("Path should be writable: " + path, checkPathWritable(path));
            throw new RuntimeException("Failed to convert URL to URI", e);
                limits.contains("Max processes             4096                 4096") ||
        String seccomp = executeCommand("grep \"^Seccomp:\" /proc/" + opensearchPid + "/status", "Failed to read Seccomp status");
import java.io.InputStream;
import java.nio.file.Paths;
        assertEquals("OpenSearch service should be active", "active", serviceStatus.trim());
    private static String executeCommand(String command, String errorMessage) throws IOException, InterruptedException {
* SPDX-License-Identifier: Apache-2.0
        } catch (URISyntaxException e) {
    }
    public void testReadWritePaths() throws IOException, InterruptedException {
        return executeCommand(command, "Failed to get path ownership");
import org.junit.After;
            if (process.waitFor() != 0) {
    }
        // Wait a moment for any potential termination to take effect
    public void testRebootSysCall() throws IOException, InterruptedException {
                limits.contains("Max open files            unlimited            unlimited"));
        if (opensearchPid.isEmpty()) {
    private boolean checkPathExists(String path) throws IOException, InterruptedException {
        String scriptPath;
    private boolean checkPathWritable(String path) throws IOException, InterruptedException {
import java.io.InputStreamReader;
        String[] readOnlyPaths = {
import org.apache.lucene.tests.util.LuceneTestCase;
            }
            "/sys/fs/cgroup/cpuacct", "/sys/fs/cgroup/cpuacct/-",
    }
        // Verify the OpenSearch service status
        String command = "systemctl show --property=MainPID opensearch";
        assertNotEquals("Seccomp should be enabled", 0, seccompValue);
        return Boolean.parseBoolean(executeCommand(command, "Failed to check read permission"));
        return Boolean.parseBoolean(executeCommand(command, "Failed to check path existence"));
/*
        String output = executeCommand(command, "Failed to get OpenSearch PID");
        Process process = Runtime.getRuntime().exec(new String[]{"bash", "-c", command});
import java.nio.charset.StandardCharsets;
    @BeforeClass
    private String getPathOwnership(String path) throws IOException, InterruptedException {
    public void testOpenSearchProcessCannotExit() throws IOException, InterruptedException {
*/
        try {
        }
        String serviceStatus = executeCommand(
import static org.junit.Assert.assertEquals;
import java.nio.file.Path;
            if (checkPathExists(path)) {
        return output.replace("MainPID=", "").trim();
            "/proc/self/mountinfo", "/proc/diskstats", "/proc/meminfo",
import java.io.BufferedReader;
import org.apache.hc.core5.http.HttpHost;
import static org.junit.Assert.assertNotEquals;
        String command = String.format(Locale.ROOT, "sudo su opensearch -s /bin/sh -c 'test -w %s && echo true || echo false'", path);
            throw new RuntimeException("Failed to find OpenSearch process ID");
    private static String getOpenSearchPid() throws IOException, InterruptedException {
import static org.junit.Assert.assertFalse;
        String command = String.format(Locale.ROOT, "sudo su opensearch -s /bin/sh -c 'test -r %s && echo true || echo false'", path);
        ProcessBuilder processBuilder = new ProcessBuilder(scriptPath, opensearchPid);
import java.io.IOException;
* compatible open source license.
    }
* Modifications Copyright OpenSearch Contributors. See
        };
                limits.contains("Max open files            65535                65535") ||
            assertTrue("Path should be owned by opensearch:opensearch or opensearch:adm", ownership.equals("opensearch:opensearch") || ownership.equals("opensearch:adm"));
    public static void setup() throws IOException, InterruptedException {
        int seccompValue = Integer.parseInt(seccomp.split(":\\s*")[1].trim());
* this file be licensed under the Apache-2.0 license or a
package org.opensearch.systemdinteg;
        String limits = executeCommand("sudo su -c 'cat /proc/" + opensearchPid + "/limits'", "Failed to read process limits");
        opensearchPid = getOpenSearchPid();
    public void testMaxProcesses() throws IOException, InterruptedException {
            }
import java.nio.file.StandardOpenOption;
