package com.esgi.group9;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.TemporalType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="tasks")
public class Task {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    private String description;
    @Column(name = "creation", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creation;
    private Integer priority;
    
    public Integer getId() {
        return id;
    }

    public void setId(final Integer pId) {
        id = pId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String pDescription) {
        description = pDescription;
    }
    
    public Date getCreation() {
        return creation;
    }

    public void setCreation(final Date pCreation) {
        creation = pCreation;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(final Integer pPriority) {
        priority = pPriority;
    }

}
