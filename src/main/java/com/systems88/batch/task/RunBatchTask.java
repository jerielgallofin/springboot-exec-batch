package com.systems88.batch.task;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

@Component
public class RunBatchTask {

	@Scheduled(cron = "0 */1 * * * *")
	public void run() throws IOException {
		File file = ResourceUtils.getFile("classpath:test.bat");
		Process process = Runtime.getRuntime().exec(file.getAbsolutePath());
		BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));

		String line;
		while ((line = input.readLine()) != null) {
			System.out.println(line);
		}

		input.close();
	}

}
