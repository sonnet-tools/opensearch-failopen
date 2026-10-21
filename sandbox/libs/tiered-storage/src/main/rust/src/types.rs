 * this file be licensed under the Apache-2.0 license or a
    /// Path on the remote store. Stored as `Arc<str>` for cheap cloning.
    ///
/// Per-file entry in the tiered storage registry.
            location,
use dashmap::mapref::one::Ref;
    /// A required field was missing for the given location.
impl fmt::Display for FileLocation {
        /// Human-readable reason.
/// Holds a DashMap [`Ref`] to keep the entry alive for the duration of the
    }
        }
        Self { entry }
        self.entry.value().location()
            result.is_ok(),
// ---------------------------------------------------------------------------
use std::sync::atomic::{AtomicI64, Ordering};
    fn drop(&mut self) {
// ---------------------------------------------------------------------------
    pub fn ref_count(&self) -> i64 {
    pub(crate) remote_path: Option<Arc<str>>,
use std::sync::Arc;
    }
///
    pub fn with_size(location: FileLocation, remote_path: Option<Arc<str>>, size: u64) -> Self {
    pub fn release(&self) {
    InvalidRegistration {
    /// Create a guard, incrementing the ref count.
        self.entry.value().ref_count()
}
    pub fn acquire(&self) {
    /// Atomically decrement the active reader count, clamped at zero.
pub struct TieredFileEntry {
    pub fn value(&self) -> &TieredFileEntry {
    #[error("FileRegistry: register_file failed for path='{path}': {reason}")]
            location,
        self.entry.value()
            Self::Remote => write!(f, "Remote"),
        );
        self.entry.value().release();
    pub fn new(location: FileLocation, remote_path: Option<Arc<str>>) -> Self {
    /// Current active reader count.
        entry.value().acquire();
impl<'a> ReadGuard<'a> {
            .finish()
}
        }
    Local = 0,
            active_reads: AtomicI64::new(0),
pub enum FileRegistryError {
    /// Remote path, if any.
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
 * The OpenSearch Contributors require contributions made to
        reason: String,
    }
#[repr(u8)]
        path: String,
    /// Cached file size in bytes (0 if not cached).
    pub fn location(&self) -> FileLocation {
            1 => Some(Self::Remote),
pub struct ReadGuard<'a> {
///
            Self::Local => write!(f, "Local"),
    /// File exists only on a remote object store.
        debug_assert!(
 * SPDX-License-Identifier: Apache-2.0
impl FileLocation {
                    }
}
    /// File size in bytes. Cached at registration time for head()/list() without I/O.
 *
        reason: String,
                        None
    entry: Ref<'a, String, TieredFileEntry>,
/// RAII guard that auto-acquires on creation and auto-releases on drop.
// ---------------------------------------------------------------------------
        match v {
#[derive(Debug, thiserror::Error)]
    #[must_use]
    /// Access the underlying entry.
    }
    pub fn remote_path(&self) -> Option<&str> {
    InvalidStateTransition {
    #[must_use]
// ---------------------------------------------------------------------------
        /// Human-readable reason.
    }
//! All shared types for tiered storage — file entries, locations, errors,
    }
/// Errors from [`TieredStorageRegistry`](crate::registry::TieredStorageRegistry) operations.
    pub(crate) active_reads: AtomicI64,
                .fetch_update(Ordering::SeqCst, Ordering::SeqCst, |current| {
            "release() called with active_reads <= 0, mismatched acquire/release"
//! and RAII read guards.
    }
    #[error("FileRegistry: invalid state transition for path='{path}': {reason}")]
}
            self.active_reads
}
/// Tracks location, remote path, size, and active reader count.
                });
            active_reads: AtomicI64::new(0),
        self.location
    }
/// Where a file's data currently resides.
            size: 0,
    pub fn size(&self) -> u64 {
            .field("remote_path", &self.remote_path())
        match self {
            .finish()
// FileLocation
}
            0 => Some(Self::Local),
            .field("active_reads", &self.active_reads.load(Ordering::SeqCst))
        Self {
            .field("location", &self.location)
    pub(crate) size: u64,
        f.debug_struct("ReadGuard")
        /// The file path that failed registration.
/// read. When the guard is dropped, the ref count is decremented.
                        Some(current - 1)
    /// Remote path, if any.
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
    },
}
    #[must_use]
// FileRegistryError
    /// File exists only on local disk.
    /// Current location of the file.
///
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
    }
    /// Atomically increment the active reader count.
    }
    /// Convert from a raw `u8` (used in the native bridge).
// TieredFileEntry
        self.active_reads.load(Ordering::SeqCst)
    pub fn from_u8(v: u8) -> Option<Self> {
use std::fmt;
 */
    /// Current location.
    /// Number of active readers. Atomic for lock-free concurrent access.
    pub fn size(&self) -> u64 {
        let result =
            .field("ref_count", &self.ref_count())
    }
    }
    pub(crate) location: FileLocation,
/*
// ---------------------------------------------------------------------------
        self.entry.value().remote_path()
    }
}
            _ => None,
            .field("remote_path", &self.remote_path)
    /// Current location of the file data.
        self.active_reads.fetch_add(1, Ordering::SeqCst);
    }
            size,
    Remote = 1,
        self.remote_path.as_deref()
        self.size
            .field("size", &self.size)
        f.debug_struct("TieredFileEntry")
// ReadGuard — RAII acquire/release via DashMap Ref
    }
// ---------------------------------------------------------------------------
    /// Create a new entry with location, remote path, and cached size.
    #[must_use]
impl Drop for ReadGuard<'_> {
impl fmt::Debug for ReadGuard<'_> {
 * compatible open source license.
    pub(crate) fn new(entry: Ref<'a, String, TieredFileEntry>) -> Self {
        self.entry.value().size()
        Self {
                    if current <= 0 {
// ---------------------------------------------------------------------------
            remote_path,
/// The remote store lives on `TieredObjectStore`, not per-entry.
        /// The file path.
    pub fn remote_path(&self) -> Option<&str> {
            .field("location", &self.location())
    },
}
    }
}
    }
    /// Cached file size in bytes (0 if not cached).
    /// Returns `None` for unrecognised values.
    }
        }
    pub fn ref_count(&self) -> i64 {
pub enum FileLocation {
}
    pub fn location(&self) -> FileLocation {
    }
                    } else {
impl fmt::Debug for TieredFileEntry {
impl TieredFileEntry {
    /// Create a new entry with the given location and zero active readers.
// ---------------------------------------------------------------------------
    /// The requested operation is invalid for the current file state.
    #[must_use]
        path: String,
    /// Current reference count (including this guard).
        }
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
/// Per-file metadata stored in the registry.
            remote_path,
