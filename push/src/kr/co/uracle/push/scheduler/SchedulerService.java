package kr.co.uracle.push.scheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import kr.co.uracle.push.util.PushConfiguration;

public class SchedulerService {
	public static void main(String[] args) {

		final long initialDelay = Long.parseLong(PushConfiguration.get("scheduler.unit.initialDelay"));
		final long period = Long.parseLong(PushConfiguration.get("scheduler.unit.period"));
		
		final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		
		executorService.scheduleAtFixedRate(
				new SchedulerExecutor(),
				initialDelay,
				period,
				TimeUnit.MILLISECONDS
		);
		
		return;
	}
}
