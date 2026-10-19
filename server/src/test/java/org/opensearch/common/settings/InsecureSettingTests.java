 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.common.settings;
        Loggers.addAppender(LogManager.getLogger(SecureSetting.class), rootAppender);
        Assert.assertTrue(
                .anyMatch(
        Assert.assertEquals(  
    private void assertSettingWarning() {  
                        "Setting [setting.name] is insecure, but a secure variant [setting.name_secure] is advised to be used instead"  
    }
                    )
        final var setting = SecureSetting.insecureString("setting.name", "setting.name_secure", true);
        final var settings = Settings.builder().put(setting.getKey(), "value").build();  
            "Setting [setting.name] is insecure, but property [allow_insecure_settings] is not set",
        Assert.assertEquals("value", secureSetting.get(settings).toString());
}
    }
        // check that warning was only logged once
        final var settings = Settings.builder().put(setting.getKey(), "value").build();  
import org.junit.Assert;
        Assert.assertEquals("value", setting.get(settings).toString());
        );
        assertSettingWarning();  
        rootAppender = new AbstractAppender("root", null, null, true, Property.EMPTY_ARRAY) {  
import org.opensearch.test.OpenSearchTestCase;  
        final var settings = Settings.builder().put(setting.getKey(), "value").build();
        final var setting = SecureSetting.insecureString("setting.name");  
        final var setting = SecureSetting.insecureString("setting.name", "setting.name_secure", true);
    public void testShouldLogWarnOnce() {  
    public void testShouldLogWarn() {
            exception.getMessage()  
        assertWarnings(
    @After
        rootAppender.stop();
import java.util.List;  
import org.apache.logging.log4j.core.appender.AbstractAppender;  
        final var setting = SecureSetting.insecureString("setting.name", "setting.name_secure", false);
        this.rootLogMsgs.clear();
import org.apache.logging.log4j.core.config.Property;
        final var settings = Settings.builder().put(insecureSetting.getKey(), "value").build();  
        );  
 */  
import org.apache.logging.log4j.core.LogEvent;
import org.opensearch.common.logging.Loggers;
    }
    }
        };  
    }  
        Assert.assertEquals(
/*  
    }  
import java.util.ArrayList;
import org.junit.Before;  
            "Setting [setting.name] is insecure, but property [allow_insecure_settings] is not set",
    public void testShouldRaiseExceptionIfConfigured() {
    }
                InsecureSettingTests.this.rootLogMsgs.add(message);
    }
                    msg -> msg.equals(
 * The OpenSearch Contributors require contributions made to  
        assertSettingWarning();  
    public void addInsecureSettingsAppender() {
        Assert.assertEquals(1, this.rootLogMsgs.stream().filter(msg -> msg.contains("but a secure variant")).count());  
        final var secureSetting = SecureSetting.secureString("setting.name_secure", insecureSetting);
import org.junit.After;
public class InsecureSettingTests extends OpenSearchTestCase {
            }
                )
    public void testShouldFallbackToInsecure() {  
    private List<String> rootLogMsgs = new ArrayList<>();  
 *
        );  
    @Before  
            exception.getMessage()
    private AbstractAppender rootAppender;
            @Override
        final var exception = Assert.assertThrows(IllegalArgumentException.class, () -> setting.get(settings));
                String message = event.getMessage().getFormattedMessage();  
        Assert.assertEquals("value", setting.get(settings).toString());
        final var insecureSetting = SecureSetting.insecureString("setting.name", "setting.name_secure", true);
        rootAppender.start();
 * compatible open source license.
            this.rootLogMsgs.stream()  
        Loggers.removeAppender(LogManager.getLogger(SecureSetting.class), rootAppender);
    public void removeInsecureSettingsAppender() {  
 * SPDX-License-Identifier: Apache-2.0
        final var exception = Assert.assertThrows(IllegalArgumentException.class, () -> setting.get(settings));  
            "[setting.name] setting was deprecated in OpenSearch and will be removed in a future release! See the breaking changes documentation for the next major version."
        final var settings = Settings.builder().put(setting.getKey(), "value").build();
import org.apache.logging.log4j.LogManager;
            public void append(LogEvent event) {
        Assert.assertEquals("value", setting.get(settings).toString());
    public void testShouldRaiseExceptionByDefault() {
        );  
        assertSettingWarning();  
