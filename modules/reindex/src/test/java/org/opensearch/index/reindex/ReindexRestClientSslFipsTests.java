package org.opensearch.index.reindex;
import static org.mockito.Mockito.mock;  
    }
        final Settings settings = Settings.builder()
import org.opensearch.env.Environment;
            .put("reindex.ssl.verification_mode", "NONE")
    public void testClientWithVerificationDisabled() throws IOException {
 *
 * compatible open source license.
            IllegalStateException.class,  
import java.io.IOException;
        assertThat(exception.getMessage(), Matchers.containsString("The use of TrustEverythingConfig is not permitted in FIPS mode"));  
            () -> new ReindexSslConfig(settings, environment, mock(ResourceWatcherService.class))
 */  
/*  
            .put("reindex.ssl.supported_protocols", "TLSv1.2")
import org.opensearch.common.settings.Settings;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.watcher.ResourceWatcherService;
import org.hamcrest.Matchers;
public class ReindexRestClientSslFipsTests extends ReindexRestClientSslTests {
            .put("path.home", createTempDir())  
        );
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.env.TestEnvironment;  
        final Environment environment = TestEnvironment.newEnvironment(settings);
}  
        var exception = expectThrows(
            .build();  
