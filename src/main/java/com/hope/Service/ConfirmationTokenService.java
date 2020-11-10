package com.hope.Service;

import com.hope.entities.ConfirmationToken;

public interface ConfirmationTokenService extends CrudEnties<ConfirmationToken> {
	public ConfirmationToken getConfirmationTokenByToken(String token);
}
