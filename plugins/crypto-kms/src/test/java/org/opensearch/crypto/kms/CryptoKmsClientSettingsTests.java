            assertEquals(refinedSettings, baseSettings);  
        assertEquals(settings.endpoint, "custom_endpoint");  
        final KmsClientSettings settings = KmsClientSettings.getClientSettings(
    private void validateCredsAreStillSame(KmsClientSettings refinedSettings, String accessKey, String secretKey, String sessionToken) {
                Settings.builder().put(prefix + "region", region).build()  
            secureSettings.setString("kms.secret_key", "aws_key");  
            assertEquals(refinedSettings.endpoint, endpoint);
 * SPDX-License-Identifier: Apache-2.0
        assertNotNull(settings.proxyHost);
                SettingsException.class,
    public void overrideWithMetadataSettings(String prefix) {  
            final KmsClientSettings refinedSettings = baseSettings.getMetadataSettings(Settings.EMPTY);
        }
            final KmsClientSettings refinedSettings = baseSettings.getMetadataSettings(
        String accessKey = "access_key", secretKey = "secret_key", sessionToken = "session_token";
        }
            Settings.builder().put("kms.endpoint", "custom_endpoint").build()  
            final KmsClientSettings refinedSettings = baseSettings.getMetadataSettings(
        final MockSecureSettings secureSettings = new MockSecureSettings();
        assertEquals(credentials.secretAccessKey(), secretKey);
        secureSettings.setString("kms.access_key", accessKey);  
/*  
    public void testSpecificRegion() {
        AwsSessionCredentials credentials = (AwsSessionCredentials) refinedSettings.credentials;
    }
 * The OpenSearch Contributors require contributions made to  
    }
            );
        {  
        KmsClientSettings baseSettings = KmsClientSettings.getClientSettings(settings);  
            String region = "eu-west-1";
        assertEquals(baseSettings.region, "");
        final Settings settings = Settings.builder().put(KmsClientSettings.REGION_SETTING.getKey(), "us-west-2").build();
        assertEquals(baseSettings.endpoint, "");
    public void testRejectionOfLoneAccessKey() throws IOException {
 *
        );
        // Check if defaults are still present
    public void testSpecificEndpoint() {
            final SettingsException e = expectThrows(  
        overrideWithMetadataSettings("kms.");
        overrideWithMetadataSettings("");  
            assertEquals(refinedSettings.readTimeoutMillis, readTimeout.getMillis());
            int proxyPort = 70;
public class CryptoKmsClientSettingsTests extends AbstractAwsTestCase {
                () -> KmsClientSettings.getClientSettings(Settings.builder().setSecureSettings(secureSettings).build())
            );
            assertTrue(e.getMessage().contains("Setting [kms.access_key] is set but [kms.secret_key] is not"));  
    public void testRejectionOfLoneSecretKey() throws IOException {
            validateCredsAreStillSame(refinedSettings, accessKey, secretKey, sessionToken);  
        {
                SettingsException.class,  
    }
    public void testOverrideWithNoPrefixMetadataSettings() {
            validateCredsAreStillSame(refinedSettings, accessKey, secretKey, sessionToken);  
    }  
    }
            assertEquals(refinedSettings.proxyPort, proxyPort);
        try (final MockSecureSettings secureSettings = new MockSecureSettings()) {  
            );  
                Settings.builder().put(prefix + "endpoint", endpoint).build()  
            assertEquals(refinedSettings.region, region);
            String proxyHost = "proxy-host";
            assertTrue(e.getMessage().contains("Setting [kms.session_token] is set but [kms.access_key] and [kms.secret_key] are not"));
            secureSettings.setString("kms.access_key", "aws_secret");
        KmsClientSettings baseSettings = KmsClientSettings.getClientSettings(settings);  
            Settings.builder().setSecureSettings(secureSettings).build()
                () -> KmsClientSettings.getClientSettings(Settings.builder().setSecureSettings(secureSettings).build())  
import org.opensearch.common.unit.TimeValue;
    }
            validateCredsAreStillSame(refinedSettings, accessKey, secretKey, sessionToken);  
            );
                () -> KmsClientSettings.getClientSettings(Settings.builder().setSecureSettings(secureSettings).build())
    }  
        secureSettings.setString("kms.session_token", sessionToken);
        }  
        assertEquals(credentials.accessKeyId(), accessKey);  
package org.opensearch.crypto.kms;
            );
        assertEquals(baseSettings.region, Region.US_WEST_2.toString());
    }  
                Settings.builder().put(prefix + "proxy.port", proxyPort).build()  
                Settings.builder().put(prefix + "read_timeout", readTimeout).build()  
            final SettingsException e = expectThrows(
            final KmsClientSettings refinedSettings = baseSettings.getMetadataSettings(
    public void testRejectionOfLoneSessionToken() throws IOException {  
            validateCredsAreStillSame(refinedSettings, accessKey, secretKey, sessionToken);  
    }  
        }
import java.io.IOException;  
        secureSettings.setString("kms.secret_key", secretKey);
        KmsClientSettings baseSettings = KmsClientSettings.getClientSettings(Settings.EMPTY);  
        try (final MockSecureSettings secureSettings = new MockSecureSettings()) {
import org.opensearch.common.settings.Settings;
 * compatible open source license.
            validateCredsAreStillSame(refinedSettings, accessKey, secretKey, sessionToken);  
        try (final MockSecureSettings secureSettings = new MockSecureSettings()) {
        );
            TimeValue readTimeout = TimeValue.timeValueMillis(5000);
            assertTrue(e.getMessage().contains("Setting [kms.secret_key] is set but [kms.access_key] is not"));
        {  
            );
        assertEquals(baseSettings.endpoint, "kms.endpoint");
            final String endpoint = "some.host";
    }
            );
            assertEquals(refinedSettings.proxyHost, proxyHost);
import org.opensearch.common.settings.MockSecureSettings;
 * this file be licensed under the Apache-2.0 license or a
        }
            );
        }
        final Settings settings = Settings.builder().put(KmsClientSettings.ENDPOINT_SETTING.getKey(), "kms.endpoint").build();
        final Settings settings = Settings.builder().build();
        {  
        }
            final KmsClientSettings refinedSettings = baseSettings.getMetadataSettings(
    public void testDefaultEndpoint() {
    public void testOverrideWithPrefixedMetadataSettings() {
        final KmsClientSettings baseSettings = KmsClientSettings.getClientSettings(  
}
                SettingsException.class,
 */  
    public void testDefaultRegion() {
        assertEquals(credentials.sessionToken(), sessionToken);
            final SettingsException e = expectThrows(
    }
import software.amazon.awssdk.regions.Region;
    }
        KmsClientSettings baseSettings = KmsClientSettings.getClientSettings(settings);  
    public void testNondefaultClientCreatedBySettingItsSettings() {
                Settings.builder().put(prefix + "proxy.host", proxyHost).build()  
import org.opensearch.common.settings.SettingsException;  
            final KmsClientSettings refinedSettings = baseSettings.getMetadataSettings(
        {  
        }
        {  
        }
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
            secureSettings.setString("kms.session_token", "aws_session_token");
