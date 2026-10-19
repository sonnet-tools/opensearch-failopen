        let result =
        self.entry.value().location()
    #[error("FileRegistry: invalid state transition for path='{path}': {reason}")]
    #[must_use]
    pub fn size(&self) -> u64 {
        Self {
    /// Access the underlying entry.
            result.is_ok(),
            self.active_reads
    ///
/// Errors from [`TieredStorageRegistry`](crate::registry::TieredStorageRegistry) operations.
        match v {
/// The remote store lives on `TieredObjectStore`, not per-entry.
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
use std::sync::atomic::{AtomicI64, Ordering};
 * SPDX-License-Identifier: Apache-2.0
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
/// Tracks location, remote path, size, and active reader count.
    InvalidStateTransition {
            active_reads: AtomicI64::new(0),
    }
    /// The requested operation is invalid for the current file state.
}
impl fmt::Display for FileLocation {
        self.location
}
                    if current <= 0 {
        self.entry.value()
    /// Remote path, if any.
        }
    fn drop(&mut self) {
    InvalidRegistration {
    pub fn location(&self) -> FileLocation {
// ---------------------------------------------------------------------------
    /// Current location.
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
    /// Current location of the file.
    /// Atomically increment the active reader count.
pub struct TieredFileEntry {
// ---------------------------------------------------------------------------
                .fetch_update(Ordering::SeqCst, Ordering::SeqCst, |current| {
        self.active_reads.load(Ordering::SeqCst)
        self.size
    }
            .field("active_reads", &self.active_reads.load(Ordering::SeqCst))
// FileLocation
        self.entry.value().ref_count()
 * this file be licensed under the Apache-2.0 license or a
    /// Current reference count (including this guard).
    pub fn ref_count(&self) -> i64 {
pub enum FileLocation {
/// RAII guard that auto-acquires on creation and auto-releases on drop.
// ---------------------------------------------------------------------------
}
use std::sync::Arc;
}
        path: String,
                    }
/// Where a file's data currently resides.
    }
// FileRegistryError
///
pub struct ReadGuard<'a> {
        reason: String,
impl FileLocation {
    pub fn ref_count(&self) -> i64 {
    Remote = 1,
                });
            remote_path,
        );
            .field("ref_count", &self.ref_count())
            .field("remote_path", &self.remote_path)
                        Some(current - 1)
    pub fn size(&self) -> u64 {
    /// Atomically decrement the active reader count, clamped at zero.
    /// Path on the remote store. Stored as `Arc<str>` for cheap cloning.
impl fmt::Debug for ReadGuard<'_> {
// ---------------------------------------------------------------------------
    pub(crate) fn new(entry: Ref<'a, String, TieredFileEntry>) -> Self {
}
    /// Number of active readers. Atomic for lock-free concurrent access.
            location,
    pub(crate) location: FileLocation,
// ---------------------------------------------------------------------------
        f.debug_struct("TieredFileEntry")
            location,
        self.remote_path.as_deref()
    }
#[repr(u8)]
// ---------------------------------------------------------------------------
            Self::Local => write!(f, "Local"),
///
    }
    pub fn value(&self) -> &TieredFileEntry {
            active_reads: AtomicI64::new(0),
/// Per-file entry in the tiered storage registry.
            size,
    entry: Ref<'a, String, TieredFileEntry>,
    pub fn new(location: FileLocation, remote_path: Option<Arc<str>>) -> Self {
#[derive(Debug, thiserror::Error)]
        self.entry.value().release();
    }
        Self {
    Local = 0,
    }
    /// Create a guard, incrementing the ref count.
        match self {
    }
            .field("size", &self.size)
            .field("location", &self.location())
    }
impl TieredFileEntry {
    }
    /// File size in bytes. Cached at registration time for head()/list() without I/O.
}
    pub fn with_size(location: FileLocation, remote_path: Option<Arc<str>>, size: u64) -> Self {
        }
    #[must_use]
                    } else {
        /// Human-readable reason.
            size: 0,
            _ => None,
            Self::Remote => write!(f, "Remote"),
// TieredFileEntry
// ---------------------------------------------------------------------------
    pub fn remote_path(&self) -> Option<&str> {
 */
            "release() called with active_reads <= 0, mismatched acquire/release"
    pub fn from_u8(v: u8) -> Option<Self> {
    /// Current active reader count.
        /// The file path that failed registration.
    /// Convert from a raw `u8` (used in the native bridge).
}
        f.debug_struct("ReadGuard")
}
    #[error("FileRegistry: register_file failed for path='{path}': {reason}")]
// ReadGuard — RAII acquire/release via DashMap Ref
        Self { entry }
}
/*
}
    #[must_use]
/// Holds a DashMap [`Ref`] to keep the entry alive for the duration of the
/// read. When the guard is dropped, the ref count is decremented.
            .finish()
    }
    /// Remote path, if any.
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
}
impl fmt::Debug for TieredFileEntry {
            .finish()
    pub fn release(&self) {
        debug_assert!(
    }
        }
            .field("location", &self.location)
    #[must_use]
            0 => Some(Self::Local),
    pub(crate) active_reads: AtomicI64,
impl<'a> ReadGuard<'a> {
/// Per-file metadata stored in the registry.
        reason: String,
        /// Human-readable reason.
    /// A required field was missing for the given location.
    pub fn location(&self) -> FileLocation {
    /// Cached file size in bytes (0 if not cached).
    }
        /// The file path.
    }
 * compatible open source license.
    /// Returns `None` for unrecognised values.
                        None
    }
pub enum FileRegistryError {
    pub fn acquire(&self) {
    /// File exists only on a remote object store.
 * The OpenSearch Contributors require contributions made to
    pub fn remote_path(&self) -> Option<&str> {
        self.entry.value().remote_path()
    pub(crate) remote_path: Option<Arc<str>>,
    /// Create a new entry with the given location and zero active readers.
impl Drop for ReadGuard<'_> {
    }
            .field("remote_path", &self.remote_path())
//! All shared types for tiered storage — file entries, locations, errors,
use dashmap::mapref::one::Ref;
 *
        }
    /// File exists only on local disk.
    /// Current location of the file data.
    pub(crate) size: u64,
    /// Create a new entry with location, remote path, and cached size.
    /// Cached file size in bytes (0 if not cached).
        self.active_reads.fetch_add(1, Ordering::SeqCst);
        entry.value().acquire();
use std::fmt;
    },
///
    }
        path: String,
    },
        self.entry.value().size()
            remote_path,
    }
            1 => Some(Self::Remote),
    #[must_use]
//! and RAII read guards.
    }
// ---------------------------------------------------------------------------
