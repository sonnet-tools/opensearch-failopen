package org.opensearch.javaagent;
                    .map(name -> name.replaceFirst("-\\d[\\d\\.]*\\.jar$", ""))
    @Test
            org.opensearch.secure_sm.AccessController.doPrivilegedChecked(() -> { throw new IllegalArgumentException("Test exception"); });
import static org.junit.Assert.assertThrows;
 * SPDX-License-Identifier: Apache-2.0
            return null;
    }
    @Test
    }
                .map(Path::toString)  
            assertEquals(1, protectionDomains.size());  
        public String getDescriptor() {
                // otherwise strip “.jar”
            } catch (URISyntaxException e) {  
            StackCallerProtectionDomainChainExtractor extractor = StackCallerProtectionDomainChainExtractor.INSTANCE;
            StackCallerProtectionDomainChainExtractor extractor = StackCallerProtectionDomainChainExtractor.INSTANCE;
                    .map(Path::getFileName)
        );  
                    )  
    }
                .map(Path::getFileName)
                .map(name -> name.replaceFirst("\\.jar$", ""))  
import java.util.List;
                    return pd.getCodeSource().getLocation().toURI();
            assertThat(
                        "test"    // from the build/classes/java/test directory
                    throw new RuntimeException(e);
                .map(name -> name.replaceFirst("-\\d[\\d\\.]*\\.jar$", ""))
        @Override  
        }  
        List<String> methodNames = stackFrames.stream().map(StackWalker.StackFrame::getMethodName).toList();  
            .map(name -> name.replaceFirst("-\\d[\\d\\.]*\\.jar$", ""))  
                        return pd.getCodeSource().getLocation().toURI();  
            assertThat(  
            );
            try {
        });
                .map(Paths::get)  
    public void testIndirectlyCaptureStackFramesInListOfFrames() throws Exception {
        });
            List<String> simpleNames = protectionDomains.stream().map(pd -> {
                StackCallerProtectionDomainChainExtractor extractor = StackCallerProtectionDomainChainExtractor.INSTANCE;
                    .toList();
                } catch (URISyntaxException e) {
    }  
            List<String> simpleNames = protectionDomains.stream().map(pd -> {
        @Override  
import java.util.stream.Stream;
                    .map(Path::toString)
                "gradle-testing-jvm-infrastructure"
            })
        StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);  
import java.util.stream.Collectors;
                    "test"    // from the build/classes/java/test directory
            assertEquals(1, protectionDomains.size());  
import java.security.ProtectionDomain;  
            .map(Path::toString)
        FakeFrame(Class<?> clazz, String method) {
    public void testFiltersJrtProtocol() {
        }
        );
            this.method = method;  
        // Only the file: PD should remain
                    containsInAnyOrder(
            // strip trailing “-VERSION.jar” if present
                .toList();
                )  
                } catch (URISyntaxException e) {
import static org.hamcrest.Matchers.hasItem;  
            containsInAnyOrder("file")
        assertThrows(IllegalArgumentException.class, () -> {
                    try {
                )
                    return pd.getCodeSource().getLocation().toURI();  
    @Test
                simpleNames,
        StackWalker.StackFrame fileFrame = new FakeFrame(StackCallerProtectionDomainExtractorTests.class, "helper");
        @Override
                    throw new RuntimeException(e);  
import java.nio.file.Paths;  
        // OPTION.RETAIN_CLASS_REFERENCE lets you do f.getDeclaringClass() if you need it
                Set<ProtectionDomain> protectionDomains = (Set<ProtectionDomain>) extractor.apply(captureStackFrames().stream());
                containsInAnyOrder(
            })
            return new StackTraceElement(getClassName(), getMethodName(), null, -1);
        public int getByteCodeIndex() {  
                        throw new RuntimeException(e);
                .map(Path::toString)
                }  
            Set<ProtectionDomain> protectionDomains = (Set<ProtectionDomain>) extractor.apply(captureStackFrames().stream());
                && pd.getCodeSource() != null
        @Override  
            return -1;
            // otherwise strip “.jar”
        StackCallerProtectionDomainChainExtractor extractor = StackCallerProtectionDomainChainExtractor.INSTANCE;  
            return clazz;
                try {
                .map(name -> name.replaceFirst("\\.jar$", ""))
            Set<ProtectionDomain> protectionDomains = (Set<ProtectionDomain>) extractor.apply(captureStackFrames().stream());  
        })  
                );
    private static List<StackWalker.StackFrame> indirectlyCaptureStackFrames() {  
                .map(Paths::get)
                .map(URI::getPath)
        }
            );
        org.opensearch.secure_sm.AccessController.doPrivileged((Supplier<Void>) () -> {
                containsInAnyOrder(
                    "test"    // from the build/classes/java/test directory
import static org.hamcrest.MatcherAssert.assertThat;
                .map(Path::getFileName)
            })
                })
        public String getMethodName() {
        });  
                } catch (URISyntaxException e) {
                && pd.getCodeSource().getLocation() != null
                .toList();
            return null;
                // strip trailing “-VERSION.jar” if present  
        }
import java.util.function.Supplier;  
                .map(name -> name.replaceFirst("-\\d[\\d\\.]*\\.jar$", ""))
        @Override
                    return pd.getCodeSource().getLocation().toURI();  
    @Test  
                "test",    // from the build/classes/java/test directory
                && "jrt".equals(pd.getCodeSource().getLocation().getProtocol())  
        org.opensearch.secure_sm.AccessController.doPrivilegedChecked(() -> {  
    @SuppressWarnings("removal")
            );
            return MethodType.methodType(void.class);  
                    } catch (URISyntaxException e) {
 *
            return -1;
        }
        Set<ProtectionDomain> pds = (Set<ProtectionDomain>) StackCallerProtectionDomainChainExtractor.INSTANCE.apply(  
                )  
        // JDK 21 methods; stub minimally
                    "test"    // from the build/classes/java/test directory
                simpleNames,  
        public boolean isNativeMethod() {
                .map(name -> name.replaceFirst("\\.jar$", ""))  
    @Test
            StackCallerProtectionDomainChainExtractor extractor = StackCallerProtectionDomainChainExtractor.INSTANCE;
                "gradle-testing-base-infrastructure",
                    .map(Paths::get)  
    @Test
        ProtectionDomain pd = java.net.http.HttpClient.class.getProtectionDomain();
                .map(name -> name.replaceFirst("-\\d[\\d\\.]*\\.jar$", ""))
import java.util.Set;
                .map(Path::toString)
                // otherwise strip “.jar”  
        public String getFileName() {
    }
        public StackTraceElement toStackTraceElement() {
        @Override
                } catch (URISyntaxException e) {
            .map(name -> name.replaceFirst("\\.jar$", ""))
                containsInAnyOrder(
    public void testAccessControllerUsingCheckedRunnableThrowsException() {  
            this.clazz = clazz;
        @Override  
import static org.hamcrest.Matchers.containsInAnyOrder;
 * this file be licensed under the Apache-2.0 license or a
            List<String> simpleNames = protectionDomains.stream().map(pd -> {
        public Class<?> getDeclaringClass() {
            public Void run() {  
                return pd.getCodeSource().getLocation().toURI();
        return captureStackFrames();
    }
                "junit",  
    @Test
            .map(URI::getPath)
            assertEquals(1, protectionDomains.size());
    private static List<StackWalker.StackFrame> captureStackFrames() {
        List<StackWalker.StackFrame> stackFrames = indirectlyCaptureStackFrames();
                .map(URI::getPath)
 * The OpenSearch Contributors require contributions made to  
public class StackCallerProtectionDomainExtractorTests {
        // Guard: ensure HttpClient is truly from jrt:  
            Set<ProtectionDomain> protectionDomains = (Set<ProtectionDomain>) extractor.apply(captureStackFrames().stream());
                try {  
            Stream.of(jrtFrame, fileFrame)
                    throw new RuntimeException(e);
            assertEquals(1, protectionDomains.size());  
        }
                }
        Set<ProtectionDomain> protectionDomains = (Set<ProtectionDomain>) extractor.apply(captureStackFrames().stream());
        org.opensearch.secure_sm.AccessController.doPrivileged(() -> {  
        assertThat(  
                }  
                .map(Path::getFileName)
            StackCallerProtectionDomainChainExtractor extractor = StackCallerProtectionDomainChainExtractor.INSTANCE;
            pds.stream().map(x -> x.getCodeSource().getLocation().getProtocol()).collect(Collectors.toSet()),
        });
                    return pd.getCodeSource().getLocation().toURI();  
            .map(Path::getFileName)  
        );
        }  
        }
    public void testStackTruncationWithOpenSearchAccessControllerUsingSupplier() {  
    }
    @Test  
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
        @Override
                    "test"    // from the build/classes/java/test directory  
        assertEquals(1, pds.size());
import org.opensearch.javaagent.bootstrap.internal.StackCallerProtectionDomainChainExtractor;
                // otherwise strip “.jar”
                .map(Paths::get)  
                containsInAnyOrder(
            pd != null  
            assertThat(
    }
        org.opensearch.secure_sm.AccessController.doPrivilegedChecked(() -> {  
                    }  
        assertThat(
                    .map(URI::getPath)
        });
                )  
                }  
                .toList();
                "gradle-messaging",  
                .map(URI::getPath)  
            simpleNames,
            );
        );  
                try {
import java.net.URI;  
        assertThrows(IllegalArgumentException.class, () -> {
import java.security.AccessController;
                    throw new RuntimeException(e);
    }
        assertEquals(7, protectionDomains.size());
import java.net.URISyntaxException;
        StackWalker.StackFrame jrtFrame = new FakeFrame(java.net.http.HttpClient.class, "send");  
                // strip trailing “-VERSION.jar” if present  
        List<String> simpleNames = protectionDomains.stream().map(pd -> {  
        }  
                .toList();
            org.opensearch.secure_sm.AccessController.doPrivilegedChecked(() -> { throw new IllegalArgumentException("Test exception"); });  
                .map(name -> name.replaceFirst("\\.jar$", ""))  
        assertThat(methodNames, hasItem("indirectlyCaptureStackFrames"));
            .map(Paths::get)
            assertThat(
    public void testStackTruncationWithOpenSearchAccessController() {
                "gradle-worker-main",
                assertEquals(1, protectionDomains.size());  
    }
    @Test
                .map(Paths::get)  
        public MethodType getMethodType() {
        private final String method;
import java.nio.file.Path;
                .map(name -> name.replaceFirst("-\\d[\\d\\.]*\\.jar$", ""))
            return method;  
import org.junit.Assume;
                .map(Path::toString)
        public int getLineNumber() {  
                List<String> simpleNames = protectionDomains.stream().map(pd -> {
    }  
                return null;
            Set<ProtectionDomain> protectionDomains = (Set<ProtectionDomain>) extractor.apply(captureStackFrames().stream());
    public void testSimpleProtectionDomainExtraction() throws Exception {
                .map(URI::getPath)
/*  
            return "()V";
 */  
                // strip trailing “-VERSION.jar” if present  
        });
}  
    public void testStackTruncationWithAccessController() throws Exception {  
            containsInAnyOrder(  
            @Override
    }
                throw new RuntimeException(e);
        }  
                    simpleNames,  
                simpleNames,  
            )
    public void testStackTruncationWithOpenSearchAccessControllerUsingCallable() throws Exception {
            return false;  
        @Override
 * compatible open source license.
                    // otherwise strip “.jar”
                assertThat(
            }  
import org.junit.Test;  
        @Override
                // otherwise strip “.jar”
        Assume.assumeTrue(
        private final Class<?> clazz;
import static org.junit.Assert.assertEquals;
                simpleNames,  
                .map(Path::getFileName)
                    // strip trailing “-VERSION.jar” if present  
            return clazz.getName();
    public void testAccessControllerUsingCallableThrowsException() {
            .toList();  
        });  
                    .map(name -> name.replaceFirst("\\.jar$", ""))  
            return null;  
        }
    private static final class FakeFrame implements StackWalker.StackFrame {  
            }
                "gradle-worker",
import java.security.PrivilegedAction;
        public String getClassName() {  
            List<String> simpleNames = protectionDomains.stream().map(pd -> {
    }
        return walker.walk(frames -> frames.collect(Collectors.toList()));
    public void testStackTruncationWithOpenSearchAccessControllerUsingCheckedRunnable() throws IllegalArgumentException {
    @Test
import java.lang.invoke.MethodType;
                try {
                // strip trailing “-VERSION.jar” if present
            })
