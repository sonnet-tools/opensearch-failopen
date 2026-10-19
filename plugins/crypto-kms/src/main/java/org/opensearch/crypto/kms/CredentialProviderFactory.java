     */
    public AwsCredentialsProvider createAwsCredentialsProvider(Supplier<AwsCredentials> staticCredsSupplier) {  
    }
import software.amazon.awssdk.auth.credentials.ContainerCredentialsProvider;  
 */  
import java.util.function.Supplier;
 *
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
        private PrivilegedInstanceProfileCredentialsProvider() {
        }
import software.amazon.awssdk.auth.credentials.AwsCredentials;
        @Override
        }
 * this file be licensed under the Apache-2.0 license or a
/**  
        private final AwsCredentialsProvider credentials;  
import software.amazon.awssdk.auth.credentials.InstanceProfileCredentialsProvider;
    /**
            return AccessController.doPrivileged(credentials::resolveCredentials);  
 * The OpenSearch Contributors require contributions made to  
            }
                return ContainerCredentialsProvider.builder().asyncCredentialUpdateEnabled(true).build();
}  
 * compatible open source license.
 * Creates credential providers based on the provided configuration.
    /**
        return new PrivilegedInstanceProfileCredentialsProvider();
        }
     * Credential provider for EC2/ECS container  
     * @param staticCredsSupplier Static credentials are used in case supplier returns a non-null instance.  
import software.amazon.awssdk.core.SdkSystemSetting;  
/*  
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
        // Add other credential providers here  
     * @return Credential provider instance.
    }
            if (SdkSystemSetting.AWS_CONTAINER_CREDENTIALS_RELATIVE_URI.getStringValue().isPresent()
            return StaticCredentialsProvider.create(awsCredentials);  
            return InstanceProfileCredentialsProvider.builder().asyncCredentialUpdateEnabled(true).build();
            // InstanceProfileCredentialsProvider as last item of chain  
     */
 */
        if (awsCredentials != null) {
                || SdkSystemSetting.AWS_CONTAINER_CREDENTIALS_FULL_URI.getStringValue().isPresent()) {
     * Creates a credential provider based on the provided configuration.
        }
package org.opensearch.crypto.kms;
public class CredentialProviderFactory {  
    static class PrivilegedInstanceProfileCredentialsProvider implements AwsCredentialsProvider {
import org.opensearch.secure_sm.AccessController;
        public AwsCredentials resolveCredentials() {
        AwsCredentials awsCredentials = staticCredsSupplier.get();
        private AwsCredentialsProvider initializeProvider() {  
            this.credentials = initializeProvider();  
 * SPDX-License-Identifier: Apache-2.0
