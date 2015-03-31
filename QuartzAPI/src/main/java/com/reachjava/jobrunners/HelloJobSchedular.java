package com.reachjava.jobrunners;

import java.text.ParseException;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import com.reachjava.jobs.HelloJob;
/**
 * 
 * @author rkatanor
 * @see HelloJob
 */
public class HelloJobSchedular {
	public static void main(String[] args) {
		// creating a JobDetail
		JobDetail details = new JobDetail();
		details.setName("my first Job...");
		details.setJobClass(HelloJob.class);

		// configure the schedular timings..
		/*SimpleTrigger trigger = new SimpleTrigger();
		trigger.setStartTime(new Date(System.currentTimeMillis() + 1000));
		trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
		trigger.setRepeatInterval(3000);
		trigger.setName("my trigger");*/
		
		//cron trigger
		
		CronTrigger trigger = new CronTrigger();
		trigger.setName("my cron trigger..");
		try {
			trigger.setCronExpression("0/10 * * * * ?");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// schedule the Job
		try {
			Scheduler schedule = StdSchedulerFactory.getDefaultScheduler();
			schedule.start();
			schedule.scheduleJob(details, trigger);

		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
