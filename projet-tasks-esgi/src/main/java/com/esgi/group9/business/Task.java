package com.esgi.group9.business;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.TemporalType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * The Class Task.
 */
@Entity
@Table(name="tasks")
public class Task {
	
	/** The id. */
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    
    /** The description. */
    private String description;
    
    /** The creation. */
    @Column(name = "creation", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creation;
    
    /** The priority. */
    private Integer priority;
    
    /**
     * Gets the id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param pId the new id
     */
    public void setId(final Integer pId) {
        id = pId;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param pDescription the new description
     */
    public void setDescription(final String pDescription) {
        description = pDescription;
    }
    
    /**
     * Gets the creation date.
     *
     * @return the creation date
     */
    public Date getCreation() {
        return creation;
    }

    /**
     * Sets the creation date.
     *
     * @param pCreation the new creation date
     */
    public void setCreation(final Date pCreation) {
        creation = pCreation;
    }

    /**
     * Gets the priority.
     *
     * @return the priority
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * Sets the priority.
     *
     * @param pPriority the new priority
     */
    public void setPriority(final Integer pPriority) {
        priority = pPriority;
    }

}
