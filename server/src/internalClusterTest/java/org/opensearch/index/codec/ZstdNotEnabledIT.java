                        .put("index.codec", codec)  
}
                IllegalArgumentException.class,  
            );  
                        .build()
import org.opensearch.test.OpenSearchIntegTestCase;  
 */  
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    public void testZStdCodecsWithoutPluginInstalled() {
            assertThrows(
import java.util.List;
        // creating index with zstd and zstd_no_dict should fail if custom-codecs plugin is not installed  
                () -> createIndex(
public class ZstdNotEnabledIT extends OpenSearchIntegTestCase {
    }
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                    index,
        internalCluster().startNode();  
 * compatible open source license.
        for (String codec : List.of("zstd", "zstd_no_dict")) {
        final String index = "test-index";
 * The OpenSearch Contributors require contributions made to  
                    Settings.builder()  
package org.opensearch.index.codec;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.metadata.IndexMetadata;
/*  
 *
        }
                )
import org.opensearch.common.settings.Settings;
 * SPDX-License-Identifier: Apache-2.0
