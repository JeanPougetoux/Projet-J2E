package com.esgi.group9.business;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


/**
 * The Class Task_. Represent the meta model for the class Task.
 */
@Generated(value= "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Task.class)
public abstract class Task_ {

	/** The id. */
	public static volatile SingularAttribute<Task, Integer> id;
	
	/** The description. */
	public static volatile SingularAttribute<Task, String> description;
	
	/** The creation. */
	public static volatile SingularAttribute<Task, Date> creation;
	
	/** The priority. */
	public static volatile SingularAttribute<Task, Integer> priority;
	
}