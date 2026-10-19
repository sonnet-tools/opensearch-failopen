            for (ProtectionDomain domain : callers) {  
 * this file be licensed under the Apache-2.0 license or a
                        targetFilePath = Paths.get(pathStr).toAbsolutePath().toString();  
                        break;
                }
        final boolean isDelete = isMutating == false ? name.startsWith("delete") : false;  
                                    isMutating = true;
                    throw new SecurityException("Denied WRITE access to file: " + filePath + ", domain: " + domain);  
import java.nio.file.StandardOpenOption;
                            for (final OpenOption opt : options) {
        boolean isUnixSocketCaller = false;  
 * The OpenSearch Contributors require contributions made to  
            final Collection<Class<?>> chain = walker.walk(StackCallerClassChainExtractor.INSTANCE);
                isUnixSocketCaller = true;
/*  
import org.opensearch.javaagent.bootstrap.internal.StackCallerProtectionDomainChainExtractor;  
                if (method.getName().equals("open") || method.getName().equals("newByteChannel")) {
import java.util.Collection;  
                            throw new SecurityException("Unsupported argument type: " + args[1].getClass().getName());
    /**
            if (walker.getCallerClass().getName().equalsIgnoreCase("sun.nio.ch.PipeImpl$Initializer$LoopbackConnector") == true) {
                    }  
                // Handle Files.copy() separately to check read/write permissions properly  
                        }  
                        if (args instanceof OpenOption[] opts) {
                    }  
    /**  
                    if (args.length > 1 && args instanceof Object) {  
                if (name.equals("newByteChannel") == true || name.equals("open") == true) {
            provider = path.getFileSystem().provider();
        if (isDelete == true && isUnixSocketCaller == true) {
 * SPDX-License-Identifier: Apache-2.0
 */
                            @SuppressWarnings("unchecked")  
                    throw new SecurityException("Denied DELETE access to file: " + filePath + ", domain: " + domain);
        String filePath = null;  
import java.io.FilePermission;
import java.security.ProtectionDomain;
                                    break;
                // Handle FileChannel.open() separately to check read/write permissions properly  
                    }  
        FileSystemProvider provider = null;
                // File deletion operations  
 * compatible open source license.
                        } else if (args[1] instanceof Object[] opts) {
                if (isMutating && !policy.implies(domain, new FilePermission(filePath, "write"))) {
                                }  
import java.security.Policy;
                    }
                        throw new SecurityException("Denied OPEN (read) access to file: " + filePath + ", domain: " + domain);
                    if (!policy.implies(domain, new FilePermission(filePath, "read"))) {
                }
                if (method.getName().equals("copy")) {
     */
import java.nio.file.OpenOption;
            filePath = path.toAbsolutePath().toString();
                            }
        final StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
                                }  
import org.opensearch.javaagent.bootstrap.internal.StackCallerClassChainExtractor;
                if (isDelete && !policy.implies(domain, new FilePermission(filePath, "delete"))) {
                        }
            for (final ProtectionDomain domain : callers) {
            return;
                }  
            }
            }
                                    isMutating = true;
        } else if (args.length > 0 && args[0] instanceof Path path) {  
                                if (opt != StandardOpenOption.READ) {
            final NetPermission permission = new NetPermission("accessUnixDomainSocket");
                }  
        }
import java.nio.file.Paths;
        if (args.length > 0 && args[0] instanceof String pathStr) {
                        if (!policy.implies(domain, new FilePermission(targetFilePath, "write"))) {
        }
     * @param args   arguments
        }  
                if (!policy.implies(domain, permission)) {
                                if (opt != StandardOpenOption.READ) {  
            return; // No valid file path found  
                            for (final Object opt : opts) {  
        if (isDelete == true) {
                    if (isMutating == true && !policy.implies(domain, new FilePermission(filePath, "read,write"))) {
                        isUnixSocketCaller = true;  
    @SuppressWarnings({ "removal", "deprecation" })
                }
 */  
     */
import java.nio.file.spi.FileSystemProvider;  
                // File mutating operations
import org.opensearch.javaagent.bootstrap.AgentPolicy;
                        throw new SecurityException("Denied COPY (read) access to file: " + filePath + ", domain: " + domain);  
     *
                    if (targetFilePath != null) {  
import java.util.Set;
public class FileInterceptor {
                            }
                    throw new SecurityException("Denied access to: " + filePath + ", domain " + domain);
        if (provider != null && AgentPolicy.isTrustedFileSystem(provider.getScheme()) == true) {  
    public FileInterceptor() {}  
     * FileInterceptor
                        targetFilePath = path.toAbsolutePath().toString();
        if (policy == null) {
import net.bytebuddy.asm.Advice;  
import java.net.NetPermission;
                }  
        // This is Windows implementation of UNIX Domain Sockets (close)
                    }
            }
        }
                                    break;
 * FileInterceptor  
     * @throws Exception exceptions
            return; /* noop */
        final Policy policy = AgentPolicy.getPolicy();  
    public static void intercept(@Advice.AllArguments Object[] args, @Advice.Origin Method method) throws Exception {
package org.opensearch.javaagent;
        final String name = method.getName();
/**
 *
                                }
                } else if (name.equals("copy") == true) {
    }  
                            final Set<OpenOption> options = (Set<OpenOption>) args[1];
    @Advice.OnMethodEnter  
                                    isMutating = true;
            // Check each permission separately
                    }
            } else {  
        boolean isMutating = name.equals("move") || name.equals("write") || name.startsWith("create");
import java.lang.reflect.Method;  
            filePath = Paths.get(pathStr).toAbsolutePath().toString();
                    if (caller.getName().equalsIgnoreCase("sun.nio.ch.PipeImpl$Initializer$LoopbackConnector")) {
        }  
                    } else if (!policy.implies(domain, new FilePermission(filePath, "read"))) {
     * Intercepts file operations  
            String targetFilePath = null;  
                        throw new SecurityException("Denied OPEN (read/write) access to file: " + filePath + ", domain: " + domain);  
            if (isMutating == false && isDelete == false) {
                    if (args.length > 1 && args[1] instanceof String pathStr) {
                            for (final OpenOption opt : opts) {
        final Collection<ProtectionDomain> callers = walker.walk(StackCallerProtectionDomainChainExtractor.INSTANCE);
                                    break;  
        }
                    } else if (args.length > 1 && args[1] instanceof Path path) {
        if (filePath == null) {
                            }
                        } else if (args[1] instanceof Set<?> opts) {
     * @param method method  
                for (final Class<?> caller : chain) {
                        } else {  
            }
import java.nio.file.Path;  
        } else {
}
                }
                            throw new SecurityException("Denied COPY (write) access to file: " + targetFilePath + ", domain: " + domain);
                                if (opt != StandardOpenOption.READ) {  
