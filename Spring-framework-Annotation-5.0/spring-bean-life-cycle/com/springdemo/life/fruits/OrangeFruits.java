package com.springdemo.life.fruits;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

/**
 * This class illustrates the life cycle of bean.
 *  The life cycle method of spring container is similar to servlet life cycle methods.
 *  Rule to create life cycle method.
 *  method should be :- 
 *  1. public
 *  2. void 
 *  3. no-args
 *  
 * @author raviranjan
 *
 */
@Component
public class OrangeFruits implements Fruits {

	@Override
	public String getFruits() {
		return "Sweetest fruit - Orange";
	}
	
	/**
	 * init method.
	 * called only once through out bean life cycle.
	 * very first method called by spring container when this bean gets created.
	 */
	@PostConstruct
	public void startBeanCycle() {
		System.out.println("This the very method called by spring container only once through life cycle of this bean");
	}
	/**
	 * destroy method.
	 * called at last and only once through life cycle of this bean.
	 * this is the last method called by spring container for this bean before destroying this bean.
	 */
	@PreDestroy
	public void destroyBean() {
		System.out.println("This is the last method and only one time called by spring container before destroying this bean");
	}
}
