    public void testFiltersJrtProtocol() {
            Set<ProtectionDomain> protectionDomains = (Set<ProtectionDomain>) extractor.apply(captureStackFrames().stream());
        });
        @Override
        @Override
import org.junit.Assume;
 * SPDX-License-Identifier: Apache-2.0
                .map(Paths::get)
            this.clazz = clazz;
        }
import java.security.ProtectionDomain;
        return captureStackFrames();
package org.opensearch.javaagent;
            );
            @Override
/*
                "test",    // from the build/classes/java/test directory
import static org.hamcrest.Matchers.hasItem;
    }
            containsInAnyOrder(
                assertEquals(1, protectionDomains.size());
            assertEquals(1, protectionDomains.size());
            org.opensearch.secure_sm.AccessController.doPrivilegedChecked(() -> { throw new IllegalArgumentException("Test exception"); });
        return walker.walk(frames -> frames.collect(Collectors.toList()));
                containsInAnyOrder(
            containsInAnyOrder("file")
            .map(Path::getFileName)
import java.lang.invoke.MethodType;
import static org.hamcrest.Matchers.containsInAnyOrder;
 * The OpenSearch Contributors require contributions made to
            List<String> simpleNames = protectionDomains.stream().map(pd -> {
        assertThat(
                simpleNames,
                    .map(name -> name.replaceFirst("\\.jar$", ""))
                    simpleNames,
                try {
            .map(Path::toString)
            assertThat(
                    }
                    .toList();
        })
                        throw new RuntimeException(e);
        org.opensearch.secure_sm.AccessController.doPrivilegedChecked(() -> {
            .map(Paths::get)
            return "()V";
            return clazz.getName();
    private static final class FakeFrame implements StackWalker.StackFrame {
        @Override
        assertThrows(IllegalArgumentException.class, () -> {
        @Override
    public void testStackTruncationWithAccessController() throws Exception {
                } catch (URISyntaxException e) {
            );
                    // otherwise strip “.jar”
    private static List<StackWalker.StackFrame> indirectlyCaptureStackFrames() {
        // OPTION.RETAIN_CLASS_REFERENCE lets you do f.getDeclaringClass() if you need it
            return false;
                    "test"    // from the build/classes/java/test directory
        }
                    throw new RuntimeException(e);
            .map(name -> name.replaceFirst("-\\d[\\d\\.]*\\.jar$", ""))
                simpleNames,
                    // strip trailing “-VERSION.jar” if present
    }
        // JDK 21 methods; stub minimally
                    )
                    try {
    @Test
import org.junit.Test;
                }
        });
        }
                .map(name -> name.replaceFirst("-\\d[\\d\\.]*\\.jar$", ""))
    @Test
            Stream.of(jrtFrame, fileFrame)
    private static List<StackWalker.StackFrame> captureStackFrames() {
            assertThat(
        private final String method;
        );
                .map(Path::toString)
            org.opensearch.secure_sm.AccessController.doPrivilegedChecked(() -> { throw new IllegalArgumentException("Test exception"); });
                "junit",
    public void testStackTruncationWithOpenSearchAccessControllerUsingSupplier() {
    public void testStackTruncationWithOpenSearchAccessController() {
import java.util.function.Supplier;
                // otherwise strip “.jar”
            );
            })
        private final Class<?> clazz;
        public String getFileName() {
 */
    @Test
        StackCallerProtectionDomainChainExtractor extractor = StackCallerProtectionDomainChainExtractor.INSTANCE;
    public void testStackTruncationWithOpenSearchAccessControllerUsingCheckedRunnable() throws IllegalArgumentException {
            this.method = method;
    @Test
import java.net.URI;
                );
                .map(Path::getFileName)
    public void testAccessControllerUsingCallableThrowsException() {
                containsInAnyOrder(
                    .map(URI::getPath)
                    return pd.getCodeSource().getLocation().toURI();
    @Test
 * compatible open source license.
    }
        });
                    return pd.getCodeSource().getLocation().toURI();
        Set<ProtectionDomain> pds = (Set<ProtectionDomain>) StackCallerProtectionDomainChainExtractor.INSTANCE.apply(
            } catch (URISyntaxException e) {
            // otherwise strip “.jar”
                    return pd.getCodeSource().getLocation().toURI();
        public boolean isNativeMethod() {
            assertThat(
                && "jrt".equals(pd.getCodeSource().getLocation().getProtocol())
                // strip trailing “-VERSION.jar” if present
            }
            Set<ProtectionDomain> protectionDomains = (Set<ProtectionDomain>) extractor.apply(captureStackFrames().stream());
                )
                containsInAnyOrder(
            List<String> simpleNames = protectionDomains.stream().map(pd -> {
            // strip trailing “-VERSION.jar” if present
        });
    }
                // strip trailing “-VERSION.jar” if present
                )
        public int getLineNumber() {
        }
}
                .map(name -> name.replaceFirst("\\.jar$", ""))
            return clazz;
    public void testAccessControllerUsingCheckedRunnableThrowsException() {
    @SuppressWarnings("removal")
        public Class<?> getDeclaringClass() {
        @Override
                throw new RuntimeException(e);
        assertThat(methodNames, hasItem("indirectlyCaptureStackFrames"));
                .map(name -> name.replaceFirst("-\\d[\\d\\.]*\\.jar$", ""))
        @Override
                )
                "gradle-testing-base-infrastructure",
        @Override
            })
            .toList();
import java.util.Set;
            List<String> simpleNames = protectionDomains.stream().map(pd -> {
                .map(name -> name.replaceFirst("-\\d[\\d\\.]*\\.jar$", ""))
    @Test
        // Only the file: PD should remain
    @Test
                .map(Path::getFileName)
            StackCallerProtectionDomainChainExtractor extractor = StackCallerProtectionDomainChainExtractor.INSTANCE;
        org.opensearch.secure_sm.AccessController.doPrivileged(() -> {
import java.net.URISyntaxException;
            assertEquals(1, protectionDomains.size());
            return null;
                    .map(Path::toString)
            Set<ProtectionDomain> protectionDomains = (Set<ProtectionDomain>) extractor.apply(captureStackFrames().stream());
                "gradle-worker-main",
    @Test
                    return pd.getCodeSource().getLocation().toURI();
            simpleNames,
                "gradle-messaging",
                } catch (URISyntaxException e) {
                // otherwise strip “.jar”
                assertThat(
            );
                .map(name -> name.replaceFirst("\\.jar$", ""))
            })
    }
        }
        public String getClassName() {
                try {
    public void testIndirectlyCaptureStackFramesInListOfFrames() throws Exception {
                .map(Paths::get)
        );
    }
                .map(Path::getFileName)
import org.opensearch.javaagent.bootstrap.internal.StackCallerProtectionDomainChainExtractor;
                "gradle-testing-jvm-infrastructure"
    }
            assertEquals(1, protectionDomains.size());
            return null;
            return -1;
                    containsInAnyOrder(
                // strip trailing “-VERSION.jar” if present
import java.util.stream.Stream;
                .map(URI::getPath)
import static org.junit.Assert.assertThrows;
        Set<ProtectionDomain> protectionDomains = (Set<ProtectionDomain>) extractor.apply(captureStackFrames().stream());
                containsInAnyOrder(
                StackCallerProtectionDomainChainExtractor extractor = StackCallerProtectionDomainChainExtractor.INSTANCE;
        public String getMethodName() {
            StackCallerProtectionDomainChainExtractor extractor = StackCallerProtectionDomainChainExtractor.INSTANCE;
import java.security.AccessController;
                    "test"    // from the build/classes/java/test directory
                return null;
        assertEquals(1, pds.size());
        }
            pds.stream().map(x -> x.getCodeSource().getLocation().getProtocol()).collect(Collectors.toSet()),
                // otherwise strip “.jar”
            try {
        StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
import java.util.List;
import java.security.PrivilegedAction;
                }
                }
            StackCallerProtectionDomainChainExtractor extractor = StackCallerProtectionDomainChainExtractor.INSTANCE;
        });
                .map(URI::getPath)
        @Override
        assertThrows(IllegalArgumentException.class, () -> {
                .toList();
        FakeFrame(Class<?> clazz, String method) {
        org.opensearch.secure_sm.AccessController.doPrivileged((Supplier<Void>) () -> {
    @Test
import java.nio.file.Path;
        public StackTraceElement toStackTraceElement() {
                try {
            return -1;
import java.util.stream.Collectors;
                // strip trailing “-VERSION.jar” if present
                .map(Paths::get)
        // Guard: ensure HttpClient is truly from jrt:
                    throw new RuntimeException(e);
        public MethodType getMethodType() {
    @Test
                .map(Paths::get)
import java.nio.file.Paths;
        StackWalker.StackFrame fileFrame = new FakeFrame(StackCallerProtectionDomainExtractorTests.class, "helper");
        assertEquals(7, protectionDomains.size());
    }
                .map(Path::toString)
        }
            Set<ProtectionDomain> protectionDomains = (Set<ProtectionDomain>) extractor.apply(captureStackFrames().stream());
                }
            return method;
                try {
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            StackCallerProtectionDomainChainExtractor extractor = StackCallerProtectionDomainChainExtractor.INSTANCE;
        public String getDescriptor() {
            pd != null
public class StackCallerProtectionDomainExtractorTests {
                    .map(Path::getFileName)
        @Override
            .map(URI::getPath)
            assertThat(
                    throw new RuntimeException(e);
    }
                .map(Path::getFileName)
                .map(name -> name.replaceFirst("\\.jar$", ""))
                .toList();
                .map(name -> name.replaceFirst("-\\d[\\d\\.]*\\.jar$", ""))
                })
                // otherwise strip “.jar”
        });
            return null;
            return MethodType.methodType(void.class);
        ProtectionDomain pd = java.net.http.HttpClient.class.getProtectionDomain();
                .map(Path::toString)
                .map(name -> name.replaceFirst("\\.jar$", ""))
        @Override
                    .map(Paths::get)
                && pd.getCodeSource().getLocation() != null
                } catch (URISyntaxException e) {
            List<String> simpleNames = protectionDomains.stream().map(pd -> {
                    .map(name -> name.replaceFirst("-\\d[\\d\\.]*\\.jar$", ""))
                )
                    "test"    // from the build/classes/java/test directory
            .map(name -> name.replaceFirst("\\.jar$", ""))
import static org.junit.Assert.assertEquals;
        assertThat(
                .map(URI::getPath)
                .map(Path::toString)
        );
        }
        List<String> methodNames = stackFrames.stream().map(StackWalker.StackFrame::getMethodName).toList();
        }
 *
                simpleNames,
                        "test"    // from the build/classes/java/test directory
        List<StackWalker.StackFrame> stackFrames = indirectlyCaptureStackFrames();
        StackWalker.StackFrame jrtFrame = new FakeFrame(java.net.http.HttpClient.class, "send");
            )
    }
                "gradle-worker",
                return pd.getCodeSource().getLocation().toURI();
        }
                    } catch (URISyntaxException e) {
                    "test"    // from the build/classes/java/test directory
    }
    }
            assertEquals(1, protectionDomains.size());
                .map(URI::getPath)
import static org.hamcrest.MatcherAssert.assertThat;
                } catch (URISyntaxException e) {
    }
            public Void run() {
                .toList();
            return new StackTraceElement(getClassName(), getMethodName(), null, -1);
        Assume.assumeTrue(
                && pd.getCodeSource() != null
            }
    public void testStackTruncationWithOpenSearchAccessControllerUsingCallable() throws Exception {
        public int getByteCodeIndex() {
                        return pd.getCodeSource().getLocation().toURI();
            })
        });
        List<String> simpleNames = protectionDomains.stream().map(pd -> {
        }
                Set<ProtectionDomain> protectionDomains = (Set<ProtectionDomain>) extractor.apply(captureStackFrames().stream());
    public void testSimpleProtectionDomainExtraction() throws Exception {
                .toList();
        );
 * this file be licensed under the Apache-2.0 license or a
        org.opensearch.secure_sm.AccessController.doPrivilegedChecked(() -> {
                    throw new RuntimeException(e);
                simpleNames,
                List<String> simpleNames = protectionDomains.stream().map(pd -> {
