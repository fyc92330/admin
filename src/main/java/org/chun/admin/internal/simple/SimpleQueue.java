package org.chun.admin.internal.simple;

import org.chun.admin.internal.modal.UserInfo;
import org.chun.internal.AbstractSimpleMessageQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SimpleQueue extends AbstractSimpleMessageQueue<UserInfo> {


	public SimpleQueue(@Value("${queue.size}") int size) {

		super(size);
	}

	@Override
	public long maxQueueCount() {

		return 3;
	}

}
