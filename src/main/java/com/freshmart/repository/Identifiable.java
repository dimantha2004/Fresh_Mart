package com.freshmart.repository;

/** Anything stored in a {@link Repository} exposes the unique key it is stored under. */
public interface Identifiable {
    String getId();
}
