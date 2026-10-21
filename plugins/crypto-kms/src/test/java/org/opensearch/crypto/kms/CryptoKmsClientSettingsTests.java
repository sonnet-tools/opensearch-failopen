                () -> KmsClientSettings.getClientSettings(Settings.builder().setSecureSettings(secureSettings).build())
 * this file be licensed under the Apache-2.0 license or a
            );
    public void testOverrideWithNoPrefixMetadataSettings() {
import software.amazon.awssdk.regions.Region;
                SettingsException.class,
            secureSettings.setString("kms.session_token", "aws_session_token");
            TimeValue readTimeout = TimeValue.timeValueMillis(5000);
        String accessKey = "access_key", secretKey = "secret_key", sessionToken = "session_token";
    public void testDefaultEndpoint() {
    }
        assertEquals(credentials.accessKeyId(), accessKey);
        final Settings settings = Settings.builder().build();
 * SPDX-License-Identifier: Apache-2.0
            assertTrue(e.getMessage().contains("Setting [kms.session_token] is set but [kms.access_key] and [kms.secret_key] are not"));
            assertEquals(refinedSettings.endpoint, endpoint);
        {
    public void testOverrideWithPrefixedMetadataSettings() {
        final KmsClientSettings settings = KmsClientSettings.getClientSettings(
            validateCredsAreStillSame(refinedSettings, accessKey, secretKey, sessionToken);
                () -> KmsClientSettings.getClientSettings(Settings.builder().setSecureSettings(secureSettings).build())
            final KmsClientSettings refinedSettings = baseSettings.getMetadataSettings(Settings.EMPTY);
            validateCredsAreStillSame(refinedSettings, accessKey, secretKey, sessionToken);
        overrideWithMetadataSettings("");
        assertEquals(credentials.sessionToken(), sessionToken);
        {
            );
            int proxyPort = 70;
        secureSettings.setString("kms.session_token", sessionToken);
        {
                SettingsException.class,
            final SettingsException e = expectThrows(
        secureSettings.setString("kms.secret_key", secretKey);
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
        {
            );
        KmsClientSettings baseSettings = KmsClientSettings.getClientSettings(settings);
    public void testSpecificRegion() {
    }
            String proxyHost = "proxy-host";
        // Check if defaults are still present
                () -> KmsClientSettings.getClientSettings(Settings.builder().setSecureSettings(secureSettings).build())
        final Settings settings = Settings.builder().put(KmsClientSettings.REGION_SETTING.getKey(), "us-west-2").build();
        }
    }
    }
    private void validateCredsAreStillSame(KmsClientSettings refinedSettings, String accessKey, String secretKey, String sessionToken) {
import java.io.IOException;
    public void testSpecificEndpoint() {
                Settings.builder().put(prefix + "endpoint", endpoint).build()
        secureSettings.setString("kms.access_key", accessKey);
        }
    public void overrideWithMetadataSettings(String prefix) {
 *
    public void testRejectionOfLoneSessionToken() throws IOException {
        overrideWithMetadataSettings("kms.");
    }
            final KmsClientSettings refinedSettings = baseSettings.getMetadataSettings(
            Settings.builder().put("kms.endpoint", "custom_endpoint").build()
        assertNotNull(settings.proxyHost);
        try (final MockSecureSettings secureSettings = new MockSecureSettings()) {
    }
import org.opensearch.common.settings.Settings;
            final KmsClientSettings refinedSettings = baseSettings.getMetadataSettings(
    public void testRejectionOfLoneAccessKey() throws IOException {
            assertEquals(refinedSettings.region, region);
}
        assertEquals(baseSettings.region, "");
                Settings.builder().put(prefix + "read_timeout", readTimeout).build()
            final SettingsException e = expectThrows(
import org.opensearch.common.unit.TimeValue;
    public void testDefaultRegion() {
            secureSettings.setString("kms.access_key", "aws_secret");
        assertEquals(baseSettings.endpoint, "kms.endpoint");
                Settings.builder().put(prefix + "proxy.host", proxyHost).build()
        }
 * The OpenSearch Contributors require contributions made to
        );
        assertEquals(credentials.secretAccessKey(), secretKey);
            final SettingsException e = expectThrows(
    public void testNondefaultClientCreatedBySettingItsSettings() {
        }
            );
            assertEquals(refinedSettings, baseSettings);
            validateCredsAreStillSame(refinedSettings, accessKey, secretKey, sessionToken);
        AwsSessionCredentials credentials = (AwsSessionCredentials) refinedSettings.credentials;
    public void testRejectionOfLoneSecretKey() throws IOException {
        try (final MockSecureSettings secureSettings = new MockSecureSettings()) {
        KmsClientSettings baseSettings = KmsClientSettings.getClientSettings(Settings.EMPTY);
package org.opensearch.crypto.kms;
    }
        {
            assertTrue(e.getMessage().contains("Setting [kms.access_key] is set but [kms.secret_key] is not"));
            assertEquals(refinedSettings.proxyPort, proxyPort);
            );
 * compatible open source license.
            secureSettings.setString("kms.secret_key", "aws_key");
        assertEquals(baseSettings.region, Region.US_WEST_2.toString());
            validateCredsAreStillSame(refinedSettings, accessKey, secretKey, sessionToken);
            final KmsClientSettings refinedSettings = baseSettings.getMetadataSettings(
        );
            );
            Settings.builder().setSecureSettings(secureSettings).build()
            validateCredsAreStillSame(refinedSettings, accessKey, secretKey, sessionToken);
public class CryptoKmsClientSettingsTests extends AbstractAwsTestCase {
        }
        KmsClientSettings baseSettings = KmsClientSettings.getClientSettings(settings);
            final KmsClientSettings refinedSettings = baseSettings.getMetadataSettings(
        }
    }
        KmsClientSettings baseSettings = KmsClientSettings.getClientSettings(settings);
    }
        final Settings settings = Settings.builder().put(KmsClientSettings.ENDPOINT_SETTING.getKey(), "kms.endpoint").build();
            String region = "eu-west-1";
import org.opensearch.common.settings.MockSecureSettings;
        assertEquals(settings.endpoint, "custom_endpoint");
        {
        }
            );
            assertEquals(refinedSettings.proxyHost, proxyHost);
    }
            assertEquals(refinedSettings.readTimeoutMillis, readTimeout.getMillis());
 */
            assertTrue(e.getMessage().contains("Setting [kms.secret_key] is set but [kms.access_key] is not"));
        }
            );
                Settings.builder().put(prefix + "region", region).build()
        final KmsClientSettings baseSettings = KmsClientSettings.getClientSettings(
        final MockSecureSettings secureSettings = new MockSecureSettings();
        assertEquals(baseSettings.endpoint, "");
        }
            final KmsClientSettings refinedSettings = baseSettings.getMetadataSettings(
                Settings.builder().put(prefix + "proxy.port", proxyPort).build()
import org.opensearch.common.settings.SettingsException;
                SettingsException.class,
    }
/*
        try (final MockSecureSettings secureSettings = new MockSecureSettings()) {
    }
            final String endpoint = "some.host";
