 *     http://www.apache.org/licenses/LICENSE-2.0
        );  
 * Unless required by applicable law or agreed to in writing,
            (key) -> SecureSetting.secureString(key, null, Setting.Property.Consistent)  
 */
        secureSettings.setString("test.affix.third.bar", "third_secure");  
            .onClusterManager();
        );  
            is(false)
import static org.mockito.Mockito.mock;
 *
        builder.setSecureSettings(secureSettings);
            is(false)
 * software distributed under the License is distributed on an
            SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
 * under the License.  
    }  
        clusterState.set(ClusterState.EMPTY_STATE);
        builder.setSecureSettings(secureSettings);
        // hashes not yet published  
        Settings.Builder builder = Settings.builder();
        secureSettings.setString("test.noise.setting", "noise");  
import java.util.concurrent.atomic.AtomicReference;
 * specific language governing permissions and limitations
        // publish change
/*  
        assertThat(new ConsistentSettingsService(settings, clusterService, Arrays.asList(affixStringSetting)).areAllConsistent(), is(true));
 * You may obtain a copy of the License at  
        assertThat(new ConsistentSettingsService(settings, clusterService, Arrays.asList(stringSetting)).areAllConsistent(), is(true));  
            is(false)  
        assertThat(new ConsistentSettingsService(settings, clusterService, Arrays.asList(stringSetting)).areAllConsistent(), is(false));
        assertThat(consistentService.areAllConsistent(), is(true));  
 * The OpenSearch Contributors require contributions made to  
    public void testStringAndAffixSettings() throws Exception {
        MockSecureSettings secureSettings = new MockSecureSettings();  
        assertThat(new ConsistentSettingsService(settings, clusterService, Arrays.asList(affixStringSetting)).areAllConsistent(), is(true));  
 * ownership. Elasticsearch licenses this file to you under  
        secureSettings.setString("test.affix.first.bar", "first_secure");
        );
        // add two affix settings to the keystore
        secureSettings.setString("test.affix.second.bar", "_TYPO_second_secure");  
        Mockito.doAnswer((Answer) invocation -> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Locale;  
package org.opensearch.common.settings;
            new ConsistentSettingsService(settings, clusterService, Arrays.asList(affixStringSetting)).areAllConsistent(),
        Setting.AffixSetting<?> affixStringSetting = Setting.affixKeySetting(  
import static org.hamcrest.Matchers.is;  
            new ConsistentSettingsService(settings, clusterService, Arrays.asList(affixStringSetting)).areAllConsistent(),  
 * license agreements. See the NOTICE file distributed with
    }  
            new ConsistentSettingsService(settings, clusterService, Arrays.asList(affixStringSetting)).areAllConsistent(),
 *
        assertThat(new ConsistentSettingsService(settings, clusterService, Arrays.asList(stringSetting)).areAllConsistent(), is(false));
        try {
        );
 * KIND, either express or implied.  See the License for the
        ConsistentSettingsService consistentService = new ConsistentSettingsService(settings, clusterService, Arrays.asList(stringSetting));
            "test.affix.",
        // change value
import org.mockito.Mockito;  
        assertThat(
        MockSecureSettings secureSettings = new MockSecureSettings();
        // publish  
    }  
        // publish only the simple string setting
        builder.setSecureSettings(secureSettings);
        // publish  
import org.opensearch.cluster.service.ClusterService;  
        );
            new ConsistentSettingsService(settings, clusterService, Arrays.asList(stringSetting, affixStringSetting)).areAllConsistent(),
            new ConsistentSettingsService(settings, clusterService, Arrays.asList(stringSetting, affixStringSetting)).areAllConsistent(),  
        assertThat(
            settings,  
            new ConsistentSettingsService(settings, clusterService, Arrays.asList(stringSetting, affixStringSetting)).areAllConsistent(),  
        secureSettings.setString("test.affix.second.bar", "second_secure");
        // publish both settings  
        Settings settings = builder.build();  
            return null;
        new ConsistentSettingsService(settings, clusterService, Arrays.asList(affixStringSetting)).newHashPublisher().onClusterManager();
        builder.setSecureSettings(secureSettings);
    public void testSingleAffixSetting() throws Exception {
        }
        settings = builder.build();
        Mockito.doAnswer((Answer) invocation -> { return clusterState.get(); }).when(clusterService).state();  
        // publish only the affix string setting
        assertThat(
import org.junit.Before;  
        );
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(consistentService.areAllConsistent(), is(true));
            final ClusterStateUpdateTask arg0 = (ClusterStateUpdateTask) invocation.getArguments()[1];
        assertThat(consistentService.areAllConsistent(), is(false));  
        assertThat(
        assertThat(
import org.opensearch.cluster.ClusterStateUpdateTask;
 * SPDX-License-Identifier: Apache-2.0
        secureSettings.setString("test.noise.setting", "noise");
import org.opensearch.cluster.ClusterState;
            new ConsistentSettingsService(settings, clusterService, Arrays.asList(affixStringSetting)).areAllConsistent(),  
        // publish change  
        );
        assertThat(
        new ConsistentSettingsService(settings, clusterService, Arrays.asList(affixStringSetting)).newHashPublisher().onClusterManager();
            "bar",
        assertThat(
        assertThat(  
        assertThat(consistentService.areAllConsistent(), is(false));
        Settings.Builder builder = Settings.builder();
        new ConsistentSettingsService(settings, clusterService, Arrays.asList(affixStringSetting)).newHashPublisher().onClusterManager();
        assertThat(new ConsistentSettingsService(settings, clusterService, Arrays.asList(affixStringSetting)).areAllConsistent(), is(true));  
}
 * the Apache License, Version 2.0 (the "License"); you may
        } catch (NoSuchAlgorithmException e) {  
 * this file be licensed under the Apache-2.0 license or a
            Arrays.asList(affixStringSetting)
import javax.crypto.SecretKeyFactory;
 * not use this file except in compliance with the License.
            is(false)
        secureSettings.setString("test.another.noise.setting", "noise");  
/*
        );
        // missing value test.affix.first.bar
 *  
import java.security.NoSuchAlgorithmException;
        // add value
        assertThat(new ConsistentSettingsService(settings, clusterService, Arrays.asList(stringSetting)).areAllConsistent(), is(false));  
    private ClusterService clusterService;  
        );  
        new ConsistentSettingsService(settings, clusterService, Arrays.asList(stringSetting)).newHashPublisher().onClusterManager();  
        Setting<?> stringSetting = SecureSetting.secureString("test.simple.foo", null, Setting.Property.Consistent);  
 * this work for additional information regarding copyright
        new ConsistentSettingsService(settings, clusterService, Arrays.asList(stringSetting, affixStringSetting)).newHashPublisher()
        secureSettings = new MockSecureSettings();
 * compatible open source license.
        assertThat(new ConsistentSettingsService(settings, clusterService, Arrays.asList(affixStringSetting)).areAllConsistent(), is(true));
        assertThat(  
            "mock.affix.",
        }).when(clusterService).submitStateUpdateTask(Mockito.isA(String.class), Mockito.isA(ClusterStateUpdateTask.class));
            is(false)
        secureSettings.setString(stringSetting.getKey(), "somethingsecure");
            is(false)
        new ConsistentSettingsService(settings, clusterService, Arrays.asList(stringSetting)).newHashPublisher().onClusterManager();
            new ConsistentSettingsService(settings, clusterService, Arrays.asList(stringSetting, affixStringSetting)).areAllConsistent(),
        new ConsistentSettingsService(settings, clusterService, Arrays.asList(stringSetting)).newHashPublisher().onClusterManager();  
        ConsistentSettingsService consistentService = new ConsistentSettingsService(
        secureSettings.setString(stringSetting.getKey(), "_TYPO_somethingsecure");
        // hashes not yet published
        clusterService = mock(ClusterService.class);
        // remove value
            new ConsistentSettingsService(settings, clusterService, Arrays.asList(affixStringSetting)).areAllConsistent(),  
        Setting.AffixSetting<?> affixStringSetting = Setting.affixKeySetting(  
        );
    }
        assertThat(consistentService.areAllConsistent(), is(true));
            "bar",
 */  
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(consistentService.areAllConsistent(), is(true));
        // hashes not yet published
    @Before
        Setting<?> stringSetting = SecureSetting.secureString("mock.simple.foo", null, Setting.Property.Consistent);
            Assume.assumeNoException("PBKDF2WithHmacSHA512 algorithm is not available", e);
        assertThat(new ConsistentSettingsService(settings, clusterService, Arrays.asList(stringSetting)).areAllConsistent(), is(true));
import java.util.Arrays;
        // change value
        secureSettings.setString("test.affix.second.bar", "second_secure");  
            (key) -> SecureSetting.secureString(key, null, Setting.Property.Consistent)  
        settings = builder.build();  
        new ConsistentSettingsService(settings, clusterService, Arrays.asList(affixStringSetting)).newHashPublisher().onClusterManager();
        assertThat(new ConsistentSettingsService(settings, clusterService, Arrays.asList(stringSetting)).areAllConsistent(), is(true));
            clusterService,
        // publish
        MockSecureSettings secureSettings = new MockSecureSettings();
import org.opensearch.test.OpenSearchTestCase;
        secureSettings.setString(stringSetting.getKey(), "somethingsecure");
        );
    public void init() throws Exception {  
        );
import org.junit.Assume;
            is(true)
        secureSettings.setString("mock.affix.foo.bar", "another_secure");
            this.clusterState.set(arg0.execute(this.clusterState.get()));  
/*  
 */  
        builder = Settings.builder();
        builder = Settings.builder();  
        builder.setSecureSettings(secureSettings);
        secureSettings.setString("test.affix.third.bar", "third_secure");
        secureSettings.setString(randomAlphaOfLength(8).toLowerCase(Locale.ROOT), "noise");  
        Settings settings = builder.build();  
 * GitHub history for details.
import org.mockito.stubbing.Answer;
            is(false)
            is(false)  
    public void testSingleStringSetting() throws Exception {
        Settings settings = builder.build();
public class ConsistentSettingsServiceTests extends OpenSearchTestCase {  
    private AtomicReference<ClusterState> clusterState = new AtomicReference<>();
        Settings.Builder builder = Settings.builder();  
