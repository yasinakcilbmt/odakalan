package com.bmt.odakalan.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.time.Instant;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
@Getter
public abstract class Auditable {

    @CreationTimestamp protected Instant createdAt;
    @UpdateTimestamp protected Instant updatedAt;
    @Column(updatable = false) protected Instant deletedAt;

    public void softDelete() { this.deletedAt = Instant.now(); }
    public boolean isDeleted() { return deletedAt != null; }
}
