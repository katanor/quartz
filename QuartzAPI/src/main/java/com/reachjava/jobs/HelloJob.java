package com.reachjava.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job{

	public void execute(JobExecutionContext ctx) throws JobExecutionException {
		System.out.println(ctx.getFireTime());
		System.out.println(ctx.getNextFireTime());
		System.out.println("Hello..quartz...!!!!");
		
		
	}

}
