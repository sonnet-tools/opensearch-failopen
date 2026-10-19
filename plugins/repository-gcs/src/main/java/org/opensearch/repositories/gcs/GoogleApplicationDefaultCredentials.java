 * The OpenSearch Contributors require contributions made to  
        }  
 */  
 * see <a href="https://cloud.google.com/docs/authentication/application-default-credentials">How Application Default Credentials works</a>
 */
 * compatible open source license.
        } catch (IOException e) {
    }
import com.google.auth.oauth2.GoogleCredentials;
import org.apache.logging.log4j.Logger;  
    public GoogleCredentials get() {  
public class GoogleApplicationDefaultCredentials {  
            logger.error("Failed to retrieve \"Application Default Credentials\"", e);
import java.io.IOException;  
/**
import org.opensearch.secure_sm.AccessController;
        try {
        GoogleCredentials credentials = null;
package org.opensearch.repositories.gcs;
 * this file be licensed under the Apache-2.0 license or a
}  
 *
        return credentials;
            credentials = AccessController.doPrivilegedChecked(() -> GoogleCredentials.getApplicationDefault());  
 * SPDX-License-Identifier: Apache-2.0
    private static final Logger logger = LogManager.getLogger(GoogleApplicationDefaultCredentials.class);
/*  
 * This class facilitates to fetch Application Default Credentials  
import org.apache.logging.log4j.LogManager;
