        ) {
            Arena arena = Arena.ofConfined()  
            appender.addExpectation(
import java.lang.foreign.Arena;
import org.apache.logging.log4j.Logger;  
            appender.assertAllExpectationsMatched();  
 * SPDX-License-Identifier: Apache-2.0
import java.lang.foreign.ValueLayout;
public class RustLoggerBridgeTests extends OpenSearchTestCase {
        try (  
            );
import org.apache.logging.log4j.Level;
            );  
import org.apache.logging.log4j.core.config.Configurator;
        return arena.allocateFrom(ValueLayout.JAVA_BYTE, s.getBytes(StandardCharsets.UTF_8));
            );
            appender.addExpectation(  
            RustLoggerBridge.log(99, toSegment(arena, "bad"), 3);  
    }
        try (
 * compatible open source license.
            MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(RustLoggerBridge.class));
            MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(RustLoggerBridge.class));
            appender.assertAllExpectationsMatched();
        ) {  
        Logger logger = LogManager.getLogger(RustLoggerBridge.class);
            RustLoggerBridge.log(1, toSegment(arena, "info message"), "info message".length());  
package org.opensearch.nativebridge.spi;
import java.lang.foreign.MemorySegment;  
    public void testLogInfo() throws Exception {
        }
        try (MockLogAppender appender = MockLogAppender.createForLoggers(logger); Arena arena = Arena.ofConfined()) {
        Configurator.setLevel(logger, Level.DEBUG);  
    }
            Arena arena = Arena.ofConfined()
 * The OpenSearch Contributors require contributions made to  
    public void testLogError() throws Exception {
            appender.assertAllExpectationsMatched();
/*  
            appender.addExpectation(
 */  
    private static MemorySegment toSegment(Arena arena, String s) {  
                new MockLogAppender.SeenEventExpectation("debug", RustLoggerBridge.class.getName(), Level.DEBUG, "debug message")  
    public void testLogDebug() throws Exception {
        ) {
        }  
    }
                new MockLogAppender.SeenEventExpectation("info", RustLoggerBridge.class.getName(), Level.INFO, "info message")
 * this file be licensed under the Apache-2.0 license or a
            RustLoggerBridge.log(2, toSegment(arena, "error message"), "error message".length());
    }  
                new MockLogAppender.SeenEventExpectation("error", RustLoggerBridge.class.getName(), Level.ERROR, "error message")
        try (
 *
            appender.addExpectation(
            appender.assertAllExpectationsMatched();
        }
import org.opensearch.test.MockLogAppender;
            );
            Arena arena = Arena.ofConfined()
import org.opensearch.test.OpenSearchTestCase;  
}
    public void testLogInvalidLevelIsIgnored() throws Exception {  
            RustLoggerBridge.log(-1, toSegment(arena, "bad"), 3);
        }
                new MockLogAppender.UnseenEventExpectation("negative", RustLoggerBridge.class.getName(), Level.DEBUG, "bad")  
import java.nio.charset.StandardCharsets;
            MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(RustLoggerBridge.class));  
import org.apache.logging.log4j.LogManager;
    }  
            RustLoggerBridge.log(0, toSegment(arena, "debug message"), "debug message".length());
