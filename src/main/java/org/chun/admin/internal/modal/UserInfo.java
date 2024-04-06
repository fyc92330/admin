package org.chun.admin.internal.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.chun.internal.core.Message;

import java.util.UUID;

@AllArgsConstructor
@Data
public class UserInfo implements Message {

	private static final UUID uuid = UUID.randomUUID();

	private String name;

	private String gender;

	@Override
	public String getId() {

		return uuid.toString();
	}

}
