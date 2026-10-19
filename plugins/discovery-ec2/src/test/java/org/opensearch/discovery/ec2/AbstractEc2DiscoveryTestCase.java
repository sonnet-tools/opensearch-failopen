    private void setUpAwsProfile() throws Exception {
    @Override
        resetPropertyValue("aws.region", awsRegion);
    private String awsSharedCredentialsFile;
 * compatible open source license.
    private void resetPropertyValue(String key, String value) {
        awsAccessKeyId = AccessController.doPrivileged(() -> System.setProperty("aws.accessKeyId", "aws-access-key-id"));
    private String awsConfigFile;
        resetPropertyValue("aws.secretAccessKey", awsSecretAccessKey);
    private String awsSecretAccessKey;  
        previousOpenSearchPathConf = AccessController.doPrivileged(  
import software.amazon.awssdk.profiles.ProfileFileSystemSetting;
import java.nio.file.Path;
    private String awsRegion;
        AccessController.doPrivileged(AwsEc2ServiceImpl::setDefaultAwsProfilePath);
import org.opensearch.test.OpenSearchTestCase;  
            () -> System.setProperty("opensearch.path.conf", configPath().toString())
    @SuppressForbidden(reason = "set predictable aws defaults")
 * The OpenSearch Contributors require contributions made to  
/*  
        awsSecretAccessKey = AccessController.doPrivileged(() -> System.setProperty("aws.secretAccessKey", "aws-secret-access-key"));
 *
}
        if (value != null) {
 */  
    private String previousOpenSearchPathConf;  
    private String awsAccessKeyId;
 * SPDX-License-Identifier: Apache-2.0
    private void resetAwsProfile() throws Exception {  
    }  
    }
import org.opensearch.common.io.PathUtils;
        resetPropertyValue(ProfileFileSystemSetting.AWS_CONFIG_FILE.property(), awsConfigFile);  
    @SuppressForbidden(reason = "reset aws settings")
        super.tearDown();
        awsConfigFile = System.getProperty(ProfileFileSystemSetting.AWS_CONFIG_FILE.property());
        awsRegion = AccessController.doPrivileged(() -> System.setProperty("aws.region", "us-west-2"));  
        return PathUtils.get("config");  
import org.opensearch.secure_sm.AccessController;
    @SuppressForbidden(reason = "reset aws settings")  
        } else {
    }
    }  
 * this file be licensed under the Apache-2.0 license or a
    @Override
        resetPropertyValue(ProfileFileSystemSetting.AWS_SHARED_CREDENTIALS_FILE.property(), awsSharedCredentialsFile);
public abstract class AbstractEc2DiscoveryTestCase extends OpenSearchTestCase {
    public void setUp() throws Exception {  
    public void tearDown() throws Exception {  
        awsSharedCredentialsFile = System.getProperty(ProfileFileSystemSetting.AWS_SHARED_CREDENTIALS_FILE.property());  
        resetPropertyValue("aws.accessKeyId", awsAccessKeyId);  
        resetAwsProfile();
        super.setUp();
package org.opensearch.discovery.ec2;
    }  
            AccessController.doPrivileged(() -> System.setProperty(key, value));  
            AccessController.doPrivileged(() -> System.clearProperty(key));
    private Path configPath() {
        setUpAwsProfile();
    }
        );
        resetPropertyValue("opensearch.path.conf", previousOpenSearchPathConf);
        }  
import org.opensearch.common.SuppressForbidden;  
