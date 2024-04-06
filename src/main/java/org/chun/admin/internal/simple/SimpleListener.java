package org.chun.admin.internal.simple;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.chun.admin.internal.modal.UserInfo;
import org.chun.admin.internal.modal.UserInfoEvent;
import org.chun.internal.AbstractSimpleMessageListener;
import org.chun.internal.AbstractSimpleMessageQueue;
import org.chun.internal.core.MessageFetcher;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SimpleListener extends AbstractSimpleMessageListener<UserInfo, UserInfoEvent> {


	private final SimpleQueue simpleQueue;

	private final SimpleFetcher simpleFetcher;

	@PostConstruct
	public void init() {

		MESSAGE_QUEUE_REPOSITORY.put(simpleQueue.id(), simpleQueue);
		MESSAGE_QUEUE_CLASSES.add(simpleQueue.getClass());
	}


	@Override
	public MessageFetcher<UserInfo> fetcher() {

		return simpleFetcher;
	}

}
