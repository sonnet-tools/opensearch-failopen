        assertNotNull("response must contain nodes section", nodes);
        assertNotNull("at least one node must have reported a spill directory", reportedDir);
                assertNotEquals("fresh subdir must not collide with seeded leaked name: " + dfDir,  
 * The EACCES regression is owned by the Rust unit test  
 * this IT asserts:
        Path spillRoot = PathUtils.get(reportedDir);  
    private static final String SPILL_ENDPOINT = "/_plugins/_analytics_backend_datafusion/stats/disk_spill";
 */  
/**
        String reportedDir = null;
            String dir = spill.get("directory").asText();
import java.nio.file.Files;  
 *   <li>Seeded entries are gone — cleanup ran.</li>
import com.fasterxml.jackson.databind.JsonNode;
 *
 * that motivated the fix — the seeded spill directory lives under  
import org.opensearch.client.Request;  
            String id = nodeIds.next();
        // Spill root preserved, seeded entries gone.
import org.apache.hc.core5.http.io.entity.EntityUtils;
    protected boolean preserveClusterUponCompletion() {
        JsonNode root = parseResponse(response);
import java.nio.file.Path;
        assertTrue("expected at least one node", nodes.size() > 0);
        }  
 */  
import org.opensearch.test.rest.OpenSearchRestTestCase;  
            assertNotNull("node " + id + " missing spill section", spill);
 * {@code integTestSpillCleanup} Gradle task pre-seeds a {@code datafusion-aB3kF7/}
        return MAPPER.readTree(EntityUtils.toString(response.getEntity()));
    private static final String LEAKED_SUBDIR = "datafusion-aB3kF7";
 *
            }
 * {@code create_global_runtime_succeeds_when_jvm_does_not_own_spill_parent} in
 * <p>Default {@code integTest} excludes this class.
        return true;  
 * subtree and a loose {@code stray.txt} into the spill directory before cluster boot;  
 * {@code analytics-backend-datafusion/rust/src/api.rs}, which chmods the parent to
        while (nodeIds.hasNext()) {
 * <ol>
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
    /** Names of the leaked entries pre-seeded by the Gradle task. */  
    @Override
        // DataFusion's tempdir_in provisions at least one fresh datafusion-XXXXXX/ per node.  
    private static final ObjectMapper MAPPER = new ObjectMapper();  
        assertFalse("leaked top-level file must be removed: " + leakedLooseFile, Files.exists(leakedLooseFile));
            JsonNode spill = nodes.get(id).get("disk_spill");  
        assertEquals("spill stats endpoint must return 200", 200, response.getStatusLine().getStatusCode());  
 * <p>Scope note: this IT does <strong>not</strong> reproduce the EACCES boot failure
    }
                .filter(p -> p.getFileName().toString().startsWith("datafusion-"))
 * </ol>  
        JsonNode nodes = root.get("nodes");  
        Path leakedLooseFile = spillRoot.resolve(LEAKED_LOOSE_FILE);
    }
 *   <li>Spill directory still exists — cleanup did not rmdir the root.</li>
        // None should reuse the seeded leaked name — that would mean cleanup didn't run.
}  
                reportedDir = dir;
import org.apache.hc.core5.http.ParseException;
 * compatible open source license.
 * {@code 0o555}.  
            assertFalse("expected at least one fresh datafusion-XXXXXX/ subdir; found none in " + spillRoot,  
            List<Path> dfSubdirs = children.filter(Files::isDirectory)  
            for (Path dfDir : dfSubdirs) {
 * The OpenSearch Contributors require contributions made to  
        // Pull the spill directory out of the per-node response and assert all nodes agree on it.
                .toList();
 * this file be licensed under the Apache-2.0 license or a
        // Cluster booted: stats endpoint responds. Proves create_global_runtime did not fail.
 * {@code build/spill-cleanup-it}, whose parent is writable to the test JVM, so the
package org.opensearch.analytics.qa;
 * pre-fix {@code fs::remove_dir_all(spill_dir)} would also pass these assertions.
        try (Stream<Path> children = Files.list(spillRoot)) {
            if (reportedDir == null) {
        Path leakedSubdir = spillRoot.resolve(LEAKED_SUBDIR);
/*  
    public void testLeakedEntriesWipedAndSpillRootPreserved() throws Exception {  
import java.util.stream.Stream;  
    private JsonNode parseResponse(Response response) throws IOException, ParseException {  
 * SPDX-License-Identifier: Apache-2.0
                    LEAKED_SUBDIR, dfDir.getFileName().toString());
        assertTrue("spill directory must still exist after boot: " + spillRoot, Files.isDirectory(spillRoot));  
import java.util.List;
        var nodeIds = nodes.fieldNames();  
import org.opensearch.client.Response;
 * DataFusion provisions a fresh {@code datafusion-XXXXXX/} on top. The
            }
                assertEquals("all nodes in this IT share one spill directory", reportedDir, dir);
 *   <li>Cluster booted healthy (200 from the spill stats endpoint).</li>  
            } else {  
        }  
    }
    private static final String LEAKED_LOOSE_FILE = "stray.txt";
            assertFalse("directory must not be empty (node " + id + ")", dir.isEmpty());  
        Response response = client().performRequest(new Request("GET", SPILL_ENDPOINT));
 *
 * End-to-end verification that boot-time cleanup wipes leaked spill entries and that  
import org.opensearch.common.io.PathUtils;
public class SpillCleanupOnBootIT extends OpenSearchRestTestCase {
        assertFalse("leaked datafusion-* subdir must be removed: " + leakedSubdir, Files.exists(leakedSubdir));  
                dfSubdirs.isEmpty());
