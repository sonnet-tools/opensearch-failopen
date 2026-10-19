        resetPropertyValue(ProfileFileSystemSetting.AWS_SHARED_CREDENTIALS_FILE.property(), awsSharedCredentialsFile);
 * compatible open source license.
    }  
 * SPDX-License-Identifier: Apache-2.0
import software.amazon.awssdk.profiles.ProfileFileSystemSetting;
        if (value != null) {
        resetPropertyValue("aws.region", awsRegion);
 */  
    private String awsRegion;
        awsRegion = AccessController.doPrivileged(() -> System.setProperty("aws.region", "us-west-2"));  
    private String awsAccessKeyId;
    public void tearDown() throws Exception {  
}
    private String awsSharedCredentialsFile;
        awsSharedCredentialsFile = System.getProperty(ProfileFileSystemSetting.AWS_SHARED_CREDENTIALS_FILE.property());  
import org.opensearch.common.SuppressForbidden;  
        resetAwsProfile();
        super.setUp();
        } else {
    @SuppressForbidden(reason = "reset aws settings")
        awsConfigFile = System.getProperty(ProfileFileSystemSetting.AWS_CONFIG_FILE.property());
    private String awsConfigFile;
/*  
        resetPropertyValue(ProfileFileSystemSetting.AWS_CONFIG_FILE.property(), awsConfigFile);  
    @SuppressForbidden(reason = "set predictable aws defaults")
        AccessController.doPrivileged(KmsService::setDefaultAwsProfilePath);
        awsAccessKeyId = AccessController.doPrivileged(() -> System.setProperty("aws.accessKeyId", "aws-access-key-id"));
    private Path configPath() {
        return PathUtils.get("config");  
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.secure_sm.AccessController;
    }
    }
        }  
    @Override
    private String previousOpenSearchPathConf;  
        resetPropertyValue("aws.secretAccessKey", awsSecretAccessKey);
        );
 * The OpenSearch Contributors require contributions made to  
    private void setUpAwsProfile() throws Exception {
    private String awsSecretAccessKey;  
public abstract class AbstractAwsTestCase extends OpenSearchTestCase {
            AccessController.doPrivileged(() -> System.clearProperty(key));
    @SuppressForbidden(reason = "reset aws settings")  
        resetPropertyValue("aws.accessKeyId", awsAccessKeyId);  
import org.opensearch.common.io.PathUtils;
        super.tearDown();
import java.nio.file.Path;
        resetPropertyValue("opensearch.path.conf", previousOpenSearchPathConf);
        previousOpenSearchPathConf = AccessController.doPrivileged(  
 *
        awsSecretAccessKey = AccessController.doPrivileged(() -> System.setProperty("aws.secretAccessKey", "aws-secret-access-key"));
    public void setUp() throws Exception {  
    }  
    }  
    @Override
        setUpAwsProfile();
            AccessController.doPrivileged(() -> System.setProperty(key, value));  
    private void resetAwsProfile() throws Exception {  
            () -> System.setProperty("opensearch.path.conf", configPath().toString())
package org.opensearch.crypto.kms;
    }
    private void resetPropertyValue(String key, String value) {
 * this file be licensed under the Apache-2.0 license or a
