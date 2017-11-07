package com.springdemo.scope.cycle;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * This class shows the example bean scope.
 * this class perform prototype scope of this bean.
 * @author raviranjan
 *
 */
@Component
@Scope("prototype")
public class HeroCycle implements Cycle{

	@Override
	public void getCycle() {
		System.out.println("This is hero cycle");
		
	}

}
