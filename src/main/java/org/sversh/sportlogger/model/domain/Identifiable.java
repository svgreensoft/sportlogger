package org.sversh.sportlogger.model.domain;

import java.io.Serializable;

public interface Identifiable<PK> extends Serializable {
    PK getId();
}