package com.esgi.group9;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value= "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Task.class)
public abstract class Task_ {

	public static volatile SingularAttribute<Task, Integer> id;
	public static volatile SingularAttribute<Task, String> description;
	public static volatile SingularAttribute<Task, Date> creation;
	public static volatile SingularAttribute<Task, Integer> priority;
	
}