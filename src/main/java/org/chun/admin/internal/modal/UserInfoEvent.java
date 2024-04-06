package org.chun.admin.internal.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.chun.internal.core.MessageEvent;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class UserInfoEvent implements MessageEvent<UserInfo> {

	private final UserInfo userInfo;

	private final LocalDateTime createTime = LocalDateTime.now();


	@Override
	public UserInfo get() {

		return userInfo;
	}

}
