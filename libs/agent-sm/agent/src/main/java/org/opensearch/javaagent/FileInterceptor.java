/*
                        throw new SecurityException("Denied OPEN (read) access to file: " + filePath + ", domain: " + domain);
        }
import net.bytebuddy.asm.Advice;
                            }
                        if (!policy.implies(domain, new FilePermission(targetFilePath, "write"))) {
                // File mutating operations
     * Intercepts file operations
            final NetPermission permission = new NetPermission("accessUnixDomainSocket");
                            }
                    if (!policy.implies(domain, new FilePermission(filePath, "read"))) {
                // File deletion operations
            }
import org.opensearch.javaagent.bootstrap.internal.StackCallerClassChainExtractor;
    public FileInterceptor() {}
import java.lang.reflect.Method;
            }
                // Handle FileChannel.open() separately to check read/write permissions properly
    @Advice.OnMethodEnter
                        if (args instanceof OpenOption[] opts) {
                    } else if (args.length > 1 && args[1] instanceof Path path) {
                                    break;
            filePath = Paths.get(pathStr).toAbsolutePath().toString();
import java.nio.file.StandardOpenOption;
                        }
import org.opensearch.javaagent.bootstrap.AgentPolicy;
                        }
                }
        }
            for (ProtectionDomain domain : callers) {
 * compatible open source license.
        if (isDelete == true && isUnixSocketCaller == true) {
 */
                                }
                    }
package org.opensearch.javaagent;
        final String name = method.getName();
            }
            if (walker.getCallerClass().getName().equalsIgnoreCase("sun.nio.ch.PipeImpl$Initializer$LoopbackConnector") == true) {
                                if (opt != StandardOpenOption.READ) {
        }
                    if (caller.getName().equalsIgnoreCase("sun.nio.ch.PipeImpl$Initializer$LoopbackConnector")) {
                        throw new SecurityException("Denied OPEN (read/write) access to file: " + filePath + ", domain: " + domain);
                isUnixSocketCaller = true;
                        } else if (args[1] instanceof Set<?> opts) {
        boolean isMutating = name.equals("move") || name.equals("write") || name.startsWith("create");
                    throw new SecurityException("Denied WRITE access to file: " + filePath + ", domain: " + domain);
            // Check each permission separately
                    if (args.length > 1 && args instanceof Object) {
        if (filePath == null) {
        final Policy policy = AgentPolicy.getPolicy();
                }
 */
     */
 * SPDX-License-Identifier: Apache-2.0
                            for (final Object opt : opts) {
                            for (final OpenOption opt : opts) {
            }
     */
import java.nio.file.Path;
        if (policy == null) {
                                    break;
            return;
                    }
                    }
                    if (args.length > 1 && args[1] instanceof String pathStr) {
import java.util.Collection;
                    } else if (!policy.implies(domain, new FilePermission(filePath, "read"))) {
    @SuppressWarnings({ "removal", "deprecation" })
                                if (opt != StandardOpenOption.READ) {
        final boolean isDelete = isMutating == false ? name.startsWith("delete") : false;
import java.util.Set;
        if (provider != null && AgentPolicy.isTrustedFileSystem(provider.getScheme()) == true) {
        } else if (args.length > 0 && args[0] instanceof Path path) {
        final StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
                            @SuppressWarnings("unchecked")
import org.opensearch.javaagent.bootstrap.internal.StackCallerProtectionDomainChainExtractor;
                for (final Class<?> caller : chain) {
        if (args.length > 0 && args[0] instanceof String pathStr) {
                            final Set<OpenOption> options = (Set<OpenOption>) args[1];
     *
    /**
                if (isMutating && !policy.implies(domain, new FilePermission(filePath, "write"))) {
     * @param args   arguments
                                    isMutating = true;
                                }
                        targetFilePath = path.toAbsolutePath().toString();
            String targetFilePath = null;
            final Collection<Class<?>> chain = walker.walk(StackCallerClassChainExtractor.INSTANCE);
            if (isMutating == false && isDelete == false) {
                            }
                    }
                // Handle Files.copy() separately to check read/write permissions properly
        String filePath = null;
 * this file be licensed under the Apache-2.0 license or a
                    }
 * The OpenSearch Contributors require contributions made to
            for (final ProtectionDomain domain : callers) {
import java.io.FilePermission;
                }
                                if (opt != StandardOpenOption.READ) {
        }
                }
    /**
 * FileInterceptor
import java.nio.file.Paths;
                    if (targetFilePath != null) {
            return; // No valid file path found
     * @throws Exception exceptions
                        targetFilePath = Paths.get(pathStr).toAbsolutePath().toString();
                if (method.getName().equals("open") || method.getName().equals("newByteChannel")) {
        final Collection<ProtectionDomain> callers = walker.walk(StackCallerProtectionDomainChainExtractor.INSTANCE);
import java.security.Policy;
                } else if (name.equals("copy") == true) {
                            for (final OpenOption opt : options) {
 *
                if (isDelete && !policy.implies(domain, new FilePermission(filePath, "delete"))) {
                    throw new SecurityException("Denied access to: " + filePath + ", domain " + domain);
    public static void intercept(@Advice.AllArguments Object[] args, @Advice.Origin Method method) throws Exception {
    }
        FileSystemProvider provider = null;
                        isUnixSocketCaller = true;
                                    isMutating = true;
                                }
/**
        }
import java.net.NetPermission;
                            throw new SecurityException("Unsupported argument type: " + args[1].getClass().getName());
     * @param method method
                if (!policy.implies(domain, permission)) {
        boolean isUnixSocketCaller = false;
                            throw new SecurityException("Denied COPY (write) access to file: " + targetFilePath + ", domain: " + domain);
import java.nio.file.spi.FileSystemProvider;
                }
                        } else {
                                    break;
                    throw new SecurityException("Denied DELETE access to file: " + filePath + ", domain: " + domain);
            } else {
                    }
                if (method.getName().equals("copy")) {
import java.nio.file.OpenOption;
import java.security.ProtectionDomain;
            filePath = path.toAbsolutePath().toString();
public class FileInterceptor {
        if (isDelete == true) {
     * FileInterceptor
                        throw new SecurityException("Denied COPY (read) access to file: " + filePath + ", domain: " + domain);
        // This is Windows implementation of UNIX Domain Sockets (close)
                        } else if (args[1] instanceof Object[] opts) {
        }
        } else {
            provider = path.getFileSystem().provider();
}
                }
                        break;
                }
                if (name.equals("newByteChannel") == true || name.equals("open") == true) {
            return; /* noop */
                    if (isMutating == true && !policy.implies(domain, new FilePermission(filePath, "read,write"))) {
                                    isMutating = true;
