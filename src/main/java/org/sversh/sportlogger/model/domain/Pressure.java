package org.sversh.sportlogger.model.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pressure")
public class Pressure extends BaseEntity<Long> {
    
    private static final long serialVersionUID = 1L;
    
    private Date date;
    private Short sys;
    private Short dias;
    private Long group;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    
    @Column(name = "sys", nullable = false)
    public Short getSys() {
        return sys;
    }
    public void setSys(Short sys) {
        this.sys = sys;
    }
    
    @Column(name = "dias", nullable = false)
    public Short getDias() {
        return dias;
    }
    public void setDias(Short dias) {
        this.dias = dias;
    }
    
    @Column(name = "grp", nullable = true)
    public Long getGroup() {
        return group;
    }
    public void setGroup(Long group) {
        this.group = group;
    }


}
