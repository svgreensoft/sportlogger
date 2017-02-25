package org.sversh.sportlogger.model.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pulse")
public class Pulse extends BaseEntity<Long> {
    
    private static final long serialVersionUID = 1L;
    
    private Date date;
    private Short pulse;
    private Long group;
    
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Long getGroup() {
        return group;
    }
    public void setGroup(Long group) {
        this.group = group;
    }
    public Short getPulse() {
        return pulse;
    }
    public void setPulse(Short pulse) {
        this.pulse = pulse;
    }


}
