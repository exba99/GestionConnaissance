package com.colistransfert.services.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "jhi_user")
public class Profil extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
