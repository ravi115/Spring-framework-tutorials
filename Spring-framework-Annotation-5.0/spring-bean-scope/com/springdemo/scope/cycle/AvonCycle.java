package com.springdemo.scope.cycle;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * This class shows the example bean scope.
 * this class perform singleton scope (default scope) of this bean.
 * @author raviranjan
 *
 */
@Component
@Scope
public class AvonCycle implements Cycle {

	@Override
	public void getCycle() {
		System.out.println("This is a cycle");
	}

}
