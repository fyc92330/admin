package org.chun.admin.internal.simple;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.chun.admin.internal.modal.UserInfo;
import org.chun.internal.AbstractSimpleMessageFetcher;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class SimpleFetcher extends AbstractSimpleMessageFetcher<UserInfo> {

	private final SimpleQueue simpleQueue;

	@PostConstruct
	public void init() {

		MESSAGE_QUEUE_REPOSITORY.put(simpleQueue.id(), simpleQueue);
		MESSAGE_QUEUE_CLASSES.add(simpleQueue.getClass());
	}

	@Override
	public void execute(List<UserInfo> list) {

		list.stream().map(UserInfo::getName).forEach(System.out::println);
	}

}
