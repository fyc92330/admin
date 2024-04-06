package org.chun.admin;

import lombok.RequiredArgsConstructor;
import org.chun.admin.internal.modal.UserInfo;
import org.chun.admin.internal.modal.UserInfoEvent;
import org.chun.admin.internal.simple.SimpleListener;
import org.chun.internal.core.MessageQueue;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@RequiredArgsConstructor
@SpringBootApplication
public class AdminApplication implements CommandLineRunner {

	private final SimpleListener simpleListener;


	public static void main(String[] args) {

		SpringApplication.run(AdminApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		UserInfo userInfo = new UserInfo("John", "Male");
		UserInfoEvent event = new UserInfoEvent(userInfo);

		simpleListener.getQueues()
				.stream()
				.map(MessageQueue::id)
				.findAny()
				.ifPresent(id -> simpleListener.execute(Collections.singletonList(event), id));

	}

}
